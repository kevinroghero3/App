package io.sentry;

import android.graphics.Color;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.facebook.imageutils.JfifUtil;
import com.google.common.base.Ascii;
import com.salesforce.marketingcloud.analytics.stats.b;
import io.sentry.protocol.Contexts;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.SentryTransaction;
import io.sentry.protocol.TransactionNameSource;
import io.sentry.util.AutoClosableReentrantLock;
import io.sentry.util.CollectionUtils;
import io.sentry.util.Objects;
import io.sentry.util.SpanUtils;
import io.sentry.util.thread.IThreadChecker;
import java.lang.reflect.Method;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import o.ArtificialStackFrames;
import o.onNavigationEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class SentryTracer implements ITransaction {
    private final List<Span> children;
    private final CompositePerformanceCollector compositePerformanceCollector;
    private final Contexts contexts;
    private volatile TimerTask deadlineTimeoutTask;
    private final SentryId eventId;
    private FinishStatus finishStatus;
    private volatile TimerTask idleTimeoutTask;
    private final Instrumenter instrumenter;
    private final AtomicBoolean isDeadlineTimerRunning;
    private final AtomicBoolean isIdleFinishTimerRunning;
    private String name;
    private final Span root;
    private final IScopes scopes;
    private volatile Timer timer;
    private final AutoClosableReentrantLock timerLock;
    private final AutoClosableReentrantLock tracerLock;
    private TransactionNameSource transactionNameSource;
    private final TransactionOptions transactionOptions;

    @Override // io.sentry.ISpan
    public boolean isNoOp() {
        return false;
    }

    public SentryTracer(@NotNull TransactionContext transactionContext, @NotNull IScopes iScopes) {
        this(transactionContext, iScopes, new TransactionOptions(), null);
    }

    public SentryTracer(@NotNull TransactionContext transactionContext, @NotNull IScopes iScopes, @NotNull TransactionOptions transactionOptions) {
        this(transactionContext, iScopes, transactionOptions, null);
    }

    SentryTracer(@NotNull TransactionContext transactionContext, @NotNull IScopes iScopes, @NotNull TransactionOptions transactionOptions, @Nullable CompositePerformanceCollector compositePerformanceCollector) {
        this.eventId = new SentryId();
        this.children = new CopyOnWriteArrayList();
        this.finishStatus = FinishStatus.NOT_FINISHED;
        this.timer = null;
        this.timerLock = new AutoClosableReentrantLock();
        this.tracerLock = new AutoClosableReentrantLock();
        this.isIdleFinishTimerRunning = new AtomicBoolean(false);
        this.isDeadlineTimerRunning = new AtomicBoolean(false);
        Contexts contexts = new Contexts();
        this.contexts = contexts;
        Objects.requireNonNull(transactionContext, "context is required");
        Objects.requireNonNull(iScopes, "scopes are required");
        Span span = new Span(transactionContext, this, iScopes, transactionOptions);
        this.root = span;
        this.name = transactionContext.getName();
        this.instrumenter = transactionContext.getInstrumenter();
        this.scopes = iScopes;
        this.compositePerformanceCollector = compositePerformanceCollector;
        this.transactionNameSource = transactionContext.getTransactionNameSource();
        this.transactionOptions = transactionOptions;
        setDefaultSpanData(span);
        SentryId profilerId = iScopes.getOptions().getContinuousProfiler().getProfilerId();
        if (!profilerId.equals(SentryId.EMPTY_ID) && Boolean.TRUE.equals(isSampled())) {
            contexts.setProfile(new ProfileContext(profilerId));
        }
        if (compositePerformanceCollector != null) {
            compositePerformanceCollector.start(this);
        }
        if (transactionOptions.getIdleTimeout() == null && transactionOptions.getDeadlineTimeout() == null) {
            return;
        }
        this.timer = new Timer(true);
        scheduleDeadlineTimeout();
        scheduleFinish();
    }

    @Override // io.sentry.ITransaction
    public void scheduleFinish() {
        Long idleTimeout;
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.timerLock.acquire();
        try {
            if (this.timer != null && (idleTimeout = this.transactionOptions.getIdleTimeout()) != null) {
                cancelIdleTimer();
                this.isIdleFinishTimerRunning.set(true);
                this.idleTimeoutTask = new TimerTask() { // from class: io.sentry.SentryTracer.1
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        SentryTracer.this.onIdleTimeoutReached();
                    }
                };
                try {
                    this.timer.schedule(this.idleTimeoutTask, idleTimeout.longValue());
                } catch (Throwable th) {
                    this.scopes.getOptions().getLogger().log(SentryLevel.WARNING, "Failed to schedule finish timer", th);
                    onIdleTimeoutReached();
                }
            }
            if (iSentryLifecycleTokenAcquire != null) {
                iSentryLifecycleTokenAcquire.close();
            }
        } catch (Throwable th2) {
            if (iSentryLifecycleTokenAcquire != null) {
                try {
                    iSentryLifecycleTokenAcquire.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
            }
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onIdleTimeoutReached() {
        SpanStatus status = getStatus();
        if (status == null) {
            status = SpanStatus.OK;
        }
        finish(status);
        this.isIdleFinishTimerRunning.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDeadlineTimeoutReached() {
        SpanStatus status = getStatus();
        if (status == null) {
            status = SpanStatus.DEADLINE_EXCEEDED;
        }
        forceFinish(status, this.transactionOptions.getIdleTimeout() != null, null);
        this.isDeadlineTimerRunning.set(false);
    }

    @Override // io.sentry.ITransaction
    public void forceFinish(@NotNull SpanStatus spanStatus, boolean z, @Nullable Hint hint) {
        if (isFinished()) {
            return;
        }
        SentryDate sentryDateNow = this.scopes.getOptions().getDateProvider().now();
        ListIterator listIteratorReverseListIterator = CollectionUtils.reverseListIterator((CopyOnWriteArrayList) this.children);
        while (listIteratorReverseListIterator.hasPrevious()) {
            Span span = (Span) listIteratorReverseListIterator.previous();
            span.setSpanFinishedCallback(null);
            span.finish(spanStatus, sentryDateNow);
        }
        finish(spanStatus, sentryDateNow, z, hint);
    }

    @Override // io.sentry.ITransaction
    public void finish(@Nullable SpanStatus spanStatus, @Nullable SentryDate sentryDate, boolean z, @Nullable Hint hint) {
        SentryDate finishDate = this.root.getFinishDate();
        if (sentryDate == null) {
            sentryDate = finishDate;
        }
        if (sentryDate == null) {
            sentryDate = this.scopes.getOptions().getDateProvider().now();
        }
        for (Span span : this.children) {
            if (span.getOptions().isIdle()) {
                span.finish(spanStatus != null ? spanStatus : getSpanContext().status, sentryDate);
            }
        }
        this.finishStatus = FinishStatus.finishing(spanStatus);
        if (this.root.isFinished()) {
            return;
        }
        if (!this.transactionOptions.isWaitForChildren() || hasAllChildrenFinished()) {
            final AtomicReference atomicReference = new AtomicReference();
            final SpanFinishedCallback spanFinishedCallback = this.root.getSpanFinishedCallback();
            this.root.setSpanFinishedCallback(new SpanFinishedCallback() { // from class: io.sentry.SentryTracer$$ExternalSyntheticLambda1
                @Override // io.sentry.SpanFinishedCallback
                public final void execute(Span span2) {
                    this.f$0.lambda$finish$0(spanFinishedCallback, atomicReference, span2);
                }
            });
            this.root.finish(this.finishStatus.spanStatus, sentryDate);
            Boolean bool = Boolean.TRUE;
            ProfilingTraceData profilingTraceDataOnTransactionFinish = (bool.equals(isSampled()) && bool.equals(isProfileSampled())) ? this.scopes.getOptions().getTransactionProfiler().onTransactionFinish(this, (List) atomicReference.get(), this.scopes.getOptions()) : null;
            if (this.scopes.getOptions().isContinuousProfilingEnabled()) {
                ProfileLifecycle profileLifecycle = this.scopes.getOptions().getProfileLifecycle();
                ProfileLifecycle profileLifecycle2 = ProfileLifecycle.TRACE;
                if (profileLifecycle == profileLifecycle2) {
                    this.scopes.getOptions().getContinuousProfiler().stopProfiler(profileLifecycle2);
                }
            }
            if (atomicReference.get() != null) {
                ((List) atomicReference.get()).clear();
            }
            this.scopes.configureScope(new ScopeCallback() { // from class: io.sentry.SentryTracer$$ExternalSyntheticLambda2
                private static final byte[] $$c = {110, -7, -8, 89};
                private static final int $$d = JfifUtil.MARKER_EOI;
                private static int $10 = 0;
                private static int $11 = 1;
                private static final byte[] $$a = {92, 127, 52, -8, Ascii.US, 17, 4, -38, 49, 3, 8, -10, Ascii.CAN, -31, Ascii.SYN, Ascii.SYN, -10, 7, Ascii.FF, 2, Ascii.SYN, -16, Ascii.DC2, -9, Ascii.DC4, -44, 35, Ascii.DC4, 9, -6, Ascii.VT, 4, 0, 10, -2, -29, 46, -8, 6, Ascii.SI, -2, 4, -9, Ascii.DC4, -28, Ascii.SUB, Ascii.DC2, -10, 5, Ascii.VT, -2, -19, 39, -6, 6, -27, 46, -8, 6, Ascii.SI, -2, 4, -13, Ascii.CAN, Ascii.CR, 7, Ascii.FF, -12, 4, 50, Ascii.SO, -50};
                private static final int $$b = 36;
                private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
                private static int artificialFrame = 1;
                private static int setDefaultImpl = -260894136;

                /* JADX WARN: Code duplicated, block: B:10:0x0026  */
                /* JADX WARN: Code duplicated, block: B:8:0x0020  */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x0028). Please report as a decompilation issue!!! */
                /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                    jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0026
                    	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                    	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                    	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                    */
                private static java.lang.String $$e(short r6, byte r7, byte r8) {
                    /*
                        int r8 = r8 * 2
                        int r8 = 3 - r8
                        int r7 = r7 * 4
                        int r7 = 1 - r7
                        int r6 = r6 * 2
                        int r6 = 116 - r6
                        byte[] r0 = io.sentry.SentryTracer$$ExternalSyntheticLambda2.$$c
                        byte[] r1 = new byte[r7]
                        r2 = 0
                        if (r0 != 0) goto L16
                        r3 = r7
                        r5 = r2
                        goto L28
                    L16:
                        r3 = r2
                    L17:
                        int r8 = r8 + 1
                        byte r4 = (byte) r6
                        int r5 = r3 + 1
                        r1[r3] = r4
                        if (r5 != r7) goto L26
                        java.lang.String r6 = new java.lang.String
                        r6.<init>(r1, r2)
                        return r6
                    L26:
                        r3 = r0[r8]
                    L28:
                        int r6 = r6 + r3
                        r3 = r5
                        goto L17
                    */
                    throw new UnsupportedOperationException("Method not decompiled: io.sentry.SentryTracer$$ExternalSyntheticLambda2.$$e(short, byte, byte):java.lang.String");
                }

                /* JADX WARN: Code duplicated, block: B:10:0x0025  */
                /* JADX WARN: Code duplicated, block: B:8:0x001d  */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002b). Please report as a decompilation issue!!! */
                /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                    jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
                    	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                    	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                    	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                    */
                private static void a(int r6, int r7, short r8, java.lang.Object[] r9) {
                    /*
                        int r7 = r7 + 66
                        int r0 = 28 - r8
                        int r6 = r6 + 4
                        byte[] r1 = io.sentry.SentryTracer$$ExternalSyntheticLambda2.$$a
                        byte[] r0 = new byte[r0]
                        int r8 = 27 - r8
                        r2 = 0
                        if (r1 != 0) goto L13
                        r7 = r6
                        r3 = r8
                        r4 = r2
                        goto L2b
                    L13:
                        r3 = r2
                    L14:
                        int r6 = r6 + 1
                        byte r4 = (byte) r7
                        r0[r3] = r4
                        int r4 = r3 + 1
                        if (r3 != r8) goto L25
                        java.lang.String r6 = new java.lang.String
                        r6.<init>(r0, r2)
                        r9[r2] = r6
                        return
                    L25:
                        r3 = r1[r6]
                        r5 = r7
                        r7 = r6
                        r6 = r3
                        r3 = r5
                    L2b:
                        int r3 = r3 + r6
                        int r6 = r3 + (-5)
                        r3 = r4
                        r5 = r7
                        r7 = r6
                        r6 = r5
                        goto L14
                    */
                    throw new UnsupportedOperationException("Method not decompiled: io.sentry.SentryTracer$$ExternalSyntheticLambda2.a(int, int, short, java.lang.Object[]):void");
                }

                @Override // io.sentry.ScopeCallback
                public final void run(IScope iScope) {
                    this.f$0.lambda$finish$2(iScope);
                }

                private static void b(boolean z2, int i, int i2, int i3, char[] cArr, Object[] objArr) throws Throwable {
                    int i4 = 2 % 2;
                    onNavigationEvent onnavigationevent = new onNavigationEvent();
                    char[] cArr2 = new char[i3];
                    onnavigationevent.d = 0;
                    while (onnavigationevent.d < i3) {
                        int i5 = $10 + 59;
                        $11 = i5 % 128;
                        int i6 = i5 % 2;
                        onnavigationevent.c = cArr[onnavigationevent.d];
                        cArr2[onnavigationevent.d] = (char) (i2 + onnavigationevent.c);
                        int i7 = onnavigationevent.d;
                        try {
                            Object[] objArr2 = {Integer.valueOf(cArr2[i7]), Integer.valueOf(setDefaultImpl)};
                            Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(465886069);
                            if (objAccessartificialFrame == null) {
                                int minimumFlingVelocity = 22 - (ViewConfiguration.getMinimumFlingVelocity() >> 16);
                                char c = (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                                int iBlue = Color.blue(0) + 1775;
                                byte b = (byte) ($$d & 7);
                                byte b2 = (byte) (b - 1);
                                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(minimumFlingVelocity, c, iBlue, -2069783171, false, $$e(b, b2, b2), new Class[]{Integer.TYPE, Integer.TYPE});
                            }
                            cArr2[i7] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                            try {
                                Object[] objArr3 = {onnavigationevent, onnavigationevent};
                                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1257606387);
                                if (objAccessartificialFrame2 == null) {
                                    byte b3 = (byte) 0;
                                    byte b4 = b3;
                                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(Color.blue(0) + 37, (char) (56278 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))), 1259 - View.resolveSize(0, 0), 711931141, false, $$e(b3, b4, b4), new Class[]{Object.class, Object.class});
                                }
                                ((Method) objAccessartificialFrame2).invoke(null, objArr3);
                            } catch (Throwable th) {
                                Throwable cause = th.getCause();
                                if (cause == null) {
                                    throw th;
                                }
                                throw cause;
                            }
                        } catch (Throwable th2) {
                            Throwable cause2 = th2.getCause();
                            if (cause2 == null) {
                                throw th2;
                            }
                            throw cause2;
                        }
                    }
                    if (i > 0) {
                        int i8 = $11 + b.i;
                        $10 = i8 % 128;
                        int i9 = i8 % 2;
                        onnavigationevent.b = i;
                        char[] cArr3 = new char[i3];
                        System.arraycopy(cArr2, 0, cArr3, 0, i3);
                        System.arraycopy(cArr3, 0, cArr2, i3 - onnavigationevent.b, onnavigationevent.b);
                        System.arraycopy(cArr3, onnavigationevent.b, cArr2, 0, i3 - onnavigationevent.b);
                    }
                    if (z2) {
                        char[] cArr4 = new char[i3];
                        onnavigationevent.d = 0;
                        while (onnavigationevent.d < i3) {
                            int i10 = $10 + 19;
                            $11 = i10 % 128;
                            int i11 = i10 % 2;
                            cArr4[onnavigationevent.d] = cArr2[(i3 - onnavigationevent.d) - 1];
                            try {
                                Object[] objArr4 = {onnavigationevent, onnavigationevent};
                                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1257606387);
                                if (objAccessartificialFrame3 == null) {
                                    byte b5 = (byte) 0;
                                    byte b6 = b5;
                                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(AndroidCharacter.getMirror('0') - 11, (char) (ExpandableListView.getPackedPositionChild(0L) + 56278), (ViewConfiguration.getFadingEdgeLength() >> 16) + 1259, 711931141, false, $$e(b5, b6, b6), new Class[]{Object.class, Object.class});
                                }
                                ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                            } catch (Throwable th3) {
                                Throwable cause3 = th3.getCause();
                                if (cause3 == null) {
                                    throw th3;
                                }
                                throw cause3;
                            }
                        }
                        cArr2 = cArr4;
                    }
                    objArr[0] = new String(cArr2);
                }

                /* JADX WARN: Code duplicated, block: B:42:0x05f4  */
                /* JADX WARN: Code duplicated, block: B:44:0x05fa  */
                /* JADX WARN: Code duplicated, block: B:46:0x060a  */
                /* JADX WARN: Code duplicated, block: B:47:0x0614  */
                /* JADX WARN: Code duplicated, block: B:50:0x0633  */
                /* JADX WARN: Code duplicated, block: B:51:0x063c  */
                /* JADX WARN: Code restructure failed: missing block: B:111:0x0b5d, code lost:
                
                    if (r0 != true) goto L125;
                 */
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r12v53 */
                /* JADX WARN: Type inference failed for: r13v34 */
                /* JADX WARN: Type inference failed for: r30v0, types: [android.content.Context, java.lang.Object] */
                /* JADX WARN: Type inference failed for: r30v1 */
                /* JADX WARN: Type inference failed for: r30v2 */
                /* JADX WARN: Type inference failed for: r30v3 */
                /* JADX WARN: Type inference failed for: r30v5 */
                /* JADX WARN: Type inference failed for: r30v6 */
                /* JADX WARN: Type inference failed for: r30v7 */
                /* JADX WARN: Type inference failed for: r30v8 */
                /* JADX WARN: Type inference failed for: r30v9 */
                /* JADX WARN: Type inference failed for: r5v91 */
                /* JADX WARN: Type inference failed for: r6v203 */
                /* JADX WARN: Type inference failed for: r9v24 */
                /* JADX WARN: Type inference failed for: r9v47 */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public static java.lang.Object[] CoroutineDebuggingKt(android.content.Context r30, int r31, int r32, int r33) throws java.lang.Throwable {
                    /*
                        Method dump skipped, instruction units count: 3745
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: io.sentry.SentryTracer$$ExternalSyntheticLambda2.CoroutineDebuggingKt(android.content.Context, int, int, int):java.lang.Object[]");
                }
            });
            SentryTransaction sentryTransaction = new SentryTransaction(this);
            if (this.timer != null) {
                ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.timerLock.acquire();
                try {
                    if (this.timer != null) {
                        cancelIdleTimer();
                        cancelDeadlineTimer();
                        this.timer.cancel();
                        this.timer = null;
                    }
                    if (iSentryLifecycleTokenAcquire != null) {
                        iSentryLifecycleTokenAcquire.close();
                    }
                } catch (Throwable th) {
                    if (iSentryLifecycleTokenAcquire != null) {
                        try {
                            iSentryLifecycleTokenAcquire.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }
            if (z && this.children.isEmpty() && this.transactionOptions.getIdleTimeout() != null) {
                this.scopes.getOptions().getLogger().log(SentryLevel.DEBUG, "Dropping idle transaction %s because it has no child spans", this.name);
            } else {
                sentryTransaction.getMeasurements().putAll(this.root.getMeasurements());
                this.scopes.captureTransaction(sentryTransaction, traceContext(), hint, profilingTraceDataOnTransactionFinish);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$finish$0(SpanFinishedCallback spanFinishedCallback, AtomicReference atomicReference, Span span) {
        if (spanFinishedCallback != null) {
            spanFinishedCallback.execute(span);
        }
        TransactionFinishedCallback transactionFinishedCallback = this.transactionOptions.getTransactionFinishedCallback();
        if (transactionFinishedCallback != null) {
            transactionFinishedCallback.execute(this);
        }
        CompositePerformanceCollector compositePerformanceCollector = this.compositePerformanceCollector;
        if (compositePerformanceCollector != null) {
            atomicReference.set(compositePerformanceCollector.lambda$start$0(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$finish$2(final IScope iScope) {
        iScope.withTransaction(new Scope.IWithTransaction() { // from class: io.sentry.SentryTracer$$ExternalSyntheticLambda0
            @Override // io.sentry.Scope.IWithTransaction
            public final void accept(ITransaction iTransaction) {
                this.f$0.lambda$finish$1(iScope, iTransaction);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$finish$1(IScope iScope, ITransaction iTransaction) {
        if (iTransaction == this) {
            iScope.clearTransaction();
        }
    }

    private void cancelIdleTimer() {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.timerLock.acquire();
        try {
            if (this.idleTimeoutTask != null) {
                this.idleTimeoutTask.cancel();
                this.isIdleFinishTimerRunning.set(false);
                this.idleTimeoutTask = null;
            }
            if (iSentryLifecycleTokenAcquire != null) {
                iSentryLifecycleTokenAcquire.close();
            }
        } catch (Throwable th) {
            if (iSentryLifecycleTokenAcquire != null) {
                try {
                    iSentryLifecycleTokenAcquire.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    private void scheduleDeadlineTimeout() {
        Long deadlineTimeout = this.transactionOptions.getDeadlineTimeout();
        if (deadlineTimeout != null) {
            ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.timerLock.acquire();
            try {
                if (this.timer != null) {
                    cancelDeadlineTimer();
                    this.isDeadlineTimerRunning.set(true);
                    this.deadlineTimeoutTask = new TimerTask() { // from class: io.sentry.SentryTracer.2
                        @Override // java.util.TimerTask, java.lang.Runnable
                        public void run() {
                            SentryTracer.this.onDeadlineTimeoutReached();
                        }
                    };
                    try {
                        this.timer.schedule(this.deadlineTimeoutTask, deadlineTimeout.longValue());
                    } catch (Throwable th) {
                        this.scopes.getOptions().getLogger().log(SentryLevel.WARNING, "Failed to schedule finish timer", th);
                        onDeadlineTimeoutReached();
                    }
                }
                if (iSentryLifecycleTokenAcquire != null) {
                    iSentryLifecycleTokenAcquire.close();
                }
            } catch (Throwable th2) {
                if (iSentryLifecycleTokenAcquire != null) {
                    try {
                        iSentryLifecycleTokenAcquire.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    private void cancelDeadlineTimer() {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.timerLock.acquire();
        try {
            if (this.deadlineTimeoutTask != null) {
                this.deadlineTimeoutTask.cancel();
                this.isDeadlineTimerRunning.set(false);
                this.deadlineTimeoutTask = null;
            }
            if (iSentryLifecycleTokenAcquire != null) {
                iSentryLifecycleTokenAcquire.close();
            }
        } catch (Throwable th) {
            if (iSentryLifecycleTokenAcquire != null) {
                try {
                    iSentryLifecycleTokenAcquire.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public List<Span> getChildren() {
        return this.children;
    }

    @Override // io.sentry.ISpan
    public SentryDate getStartDate() {
        return this.root.getStartDate();
    }

    @Override // io.sentry.ISpan
    public SentryDate getFinishDate() {
        return this.root.getFinishDate();
    }

    ISpan startChild(@NotNull SpanId spanId, @NotNull String str, @Nullable String str2) {
        return startChild(spanId, str, str2, new SpanOptions());
    }

    ISpan startChild(@NotNull SpanId spanId, @NotNull String str, @Nullable String str2, @NotNull SpanOptions spanOptions) {
        return createChild(spanId, str, str2, spanOptions);
    }

    ISpan startChild(@NotNull SpanId spanId, @NotNull String str, @Nullable String str2, @Nullable SentryDate sentryDate, @NotNull Instrumenter instrumenter) {
        SpanContext spanContextCopyForChild = getSpanContext().copyForChild(str, spanId, null);
        spanContextCopyForChild.setDescription(str2);
        spanContextCopyForChild.setInstrumenter(instrumenter);
        SpanOptions spanOptions = new SpanOptions();
        spanOptions.setStartTimestamp(sentryDate);
        return createChild(spanContextCopyForChild, spanOptions);
    }

    ISpan startChild(@NotNull SpanId spanId, @NotNull String str, @Nullable String str2, @Nullable SentryDate sentryDate, @NotNull Instrumenter instrumenter, @NotNull SpanOptions spanOptions) {
        SpanContext spanContextCopyForChild = getSpanContext().copyForChild(str, spanId, null);
        spanContextCopyForChild.setDescription(str2);
        spanContextCopyForChild.setInstrumenter(instrumenter);
        spanOptions.setStartTimestamp(sentryDate);
        return createChild(spanContextCopyForChild, spanOptions);
    }

    private ISpan createChild(@NotNull SpanId spanId, @NotNull String str, @Nullable String str2, @NotNull SpanOptions spanOptions) {
        SpanContext spanContextCopyForChild = getSpanContext().copyForChild(str, spanId, null);
        spanContextCopyForChild.setDescription(str2);
        spanContextCopyForChild.setInstrumenter(Instrumenter.SENTRY);
        return createChild(spanContextCopyForChild, spanOptions);
    }

    private ISpan createChild(@NotNull SpanContext spanContext, @NotNull SpanOptions spanOptions) {
        if (this.root.isFinished()) {
            return NoOpSpan.getInstance();
        }
        if (!this.instrumenter.equals(spanContext.getInstrumenter())) {
            return NoOpSpan.getInstance();
        }
        if (SpanUtils.isIgnored(this.scopes.getOptions().getIgnoredSpanOrigins(), spanOptions.getOrigin())) {
            return NoOpSpan.getInstance();
        }
        SpanId parentSpanId = spanContext.getParentSpanId();
        String operation = spanContext.getOperation();
        String description = spanContext.getDescription();
        if (this.children.size() < this.scopes.getOptions().getMaxSpans()) {
            Objects.requireNonNull(parentSpanId, "parentSpanId is required");
            Objects.requireNonNull(operation, "operation is required");
            cancelIdleTimer();
            Span span = new Span(this, this.scopes, spanContext, spanOptions, new SpanFinishedCallback() { // from class: io.sentry.SentryTracer$$ExternalSyntheticLambda3
                @Override // io.sentry.SpanFinishedCallback
                public final void execute(Span span2) {
                    this.f$0.lambda$createChild$3(span2);
                }
            });
            setDefaultSpanData(span);
            this.children.add(span);
            CompositePerformanceCollector compositePerformanceCollector = this.compositePerformanceCollector;
            if (compositePerformanceCollector != null) {
                compositePerformanceCollector.onSpanStarted(span);
            }
            return span;
        }
        this.scopes.getOptions().getLogger().log(SentryLevel.WARNING, "Span operation: %s, description: %s dropped due to limit reached. Returning NoOpSpan.", operation, description);
        return NoOpSpan.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createChild$3(Span span) {
        CompositePerformanceCollector compositePerformanceCollector = this.compositePerformanceCollector;
        if (compositePerformanceCollector != null) {
            compositePerformanceCollector.onSpanFinished(span);
        }
        FinishStatus finishStatus = this.finishStatus;
        if (this.transactionOptions.getIdleTimeout() != null) {
            if (!this.transactionOptions.isWaitForChildren() || hasAllChildrenFinished()) {
                scheduleFinish();
                return;
            }
            return;
        }
        if (finishStatus.isFinishing) {
            finish(finishStatus.spanStatus);
        }
    }

    private void setDefaultSpanData(@NotNull ISpan iSpan) {
        IThreadChecker threadChecker = this.scopes.getOptions().getThreadChecker();
        SentryId profilerId = this.scopes.getOptions().getContinuousProfiler().getProfilerId();
        if (!profilerId.equals(SentryId.EMPTY_ID) && Boolean.TRUE.equals(iSpan.isSampled())) {
            iSpan.setData("profiler_id", profilerId.toString());
        }
        iSpan.setData(SpanDataConvention.THREAD_ID, String.valueOf(threadChecker.currentThreadSystemId()));
        iSpan.setData(SpanDataConvention.THREAD_NAME, threadChecker.getCurrentThreadName());
    }

    @Override // io.sentry.ISpan
    public ISpan startChild(@NotNull String str) {
        return startChild(str, (String) null);
    }

    @Override // io.sentry.ISpan
    public ISpan startChild(@NotNull String str, @Nullable String str2, @Nullable SentryDate sentryDate, @NotNull Instrumenter instrumenter) {
        return startChild(str, str2, sentryDate, instrumenter, new SpanOptions());
    }

    @Override // io.sentry.ISpan
    public ISpan startChild(@NotNull String str, @Nullable String str2, @Nullable SentryDate sentryDate, @NotNull Instrumenter instrumenter, @NotNull SpanOptions spanOptions) {
        return createChild(str, str2, sentryDate, instrumenter, spanOptions);
    }

    @Override // io.sentry.ITransaction
    public ISpan startChild(@NotNull String str, @Nullable String str2, @Nullable SentryDate sentryDate) {
        return createChild(str, str2, sentryDate, Instrumenter.SENTRY, new SpanOptions());
    }

    @Override // io.sentry.ISpan
    public ISpan startChild(@NotNull String str, @Nullable String str2) {
        return startChild(str, str2, (SentryDate) null, Instrumenter.SENTRY, new SpanOptions());
    }

    @Override // io.sentry.ISpan
    public ISpan startChild(@NotNull String str, @Nullable String str2, @NotNull SpanOptions spanOptions) {
        return createChild(str, str2, null, Instrumenter.SENTRY, spanOptions);
    }

    @Override // io.sentry.ISpan
    public ISpan startChild(@NotNull SpanContext spanContext, @NotNull SpanOptions spanOptions) {
        return createChild(spanContext, spanOptions);
    }

    private ISpan createChild(@NotNull String str, @Nullable String str2, @Nullable SentryDate sentryDate, @NotNull Instrumenter instrumenter, @NotNull SpanOptions spanOptions) {
        if (this.root.isFinished()) {
            return NoOpSpan.getInstance();
        }
        if (!this.instrumenter.equals(instrumenter)) {
            return NoOpSpan.getInstance();
        }
        if (this.children.size() < this.scopes.getOptions().getMaxSpans()) {
            return this.root.startChild(str, str2, sentryDate, instrumenter, spanOptions);
        }
        this.scopes.getOptions().getLogger().log(SentryLevel.WARNING, "Span operation: %s, description: %s dropped due to limit reached. Returning NoOpSpan.", str, str2);
        return NoOpSpan.getInstance();
    }

    @Override // io.sentry.ISpan
    public SentryTraceHeader toSentryTrace() {
        return this.root.toSentryTrace();
    }

    @Override // io.sentry.ISpan
    public void finish() {
        finish(getStatus());
    }

    @Override // io.sentry.ISpan
    public void finish(@Nullable SpanStatus spanStatus) {
        finish(spanStatus, null);
    }

    @Override // io.sentry.ISpan
    public void finish(@Nullable SpanStatus spanStatus, @Nullable SentryDate sentryDate) {
        finish(spanStatus, sentryDate, true, null);
    }

    @Override // io.sentry.ISpan
    public TraceContext traceContext() {
        Baggage baggage;
        if (!this.scopes.getOptions().isTraceSampling() || (baggage = getSpanContext().getBaggage()) == null) {
            return null;
        }
        updateBaggageValues(baggage);
        return baggage.toTraceContext();
    }

    private void updateBaggageValues(@NotNull Baggage baggage) {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.tracerLock.acquire();
        try {
            if (baggage.isMutable()) {
                final AtomicReference atomicReference = new AtomicReference();
                this.scopes.configureScope(new ScopeCallback() { // from class: io.sentry.SentryTracer$$ExternalSyntheticLambda4
                    @Override // io.sentry.ScopeCallback
                    public final void run(IScope iScope) {
                        SentryTracer.lambda$updateBaggageValues$4(atomicReference, iScope);
                    }
                });
                baggage.setValuesFromTransaction(getSpanContext().getTraceId(), (SentryId) atomicReference.get(), this.scopes.getOptions(), getSamplingDecision(), getName(), getTransactionNameSource());
                baggage.freeze();
            }
            if (iSentryLifecycleTokenAcquire != null) {
                iSentryLifecycleTokenAcquire.close();
            }
        } catch (Throwable th) {
            if (iSentryLifecycleTokenAcquire != null) {
                try {
                    iSentryLifecycleTokenAcquire.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$updateBaggageValues$4(AtomicReference atomicReference, IScope iScope) {
        atomicReference.set(iScope.getReplayId());
    }

    @Override // io.sentry.ISpan
    public BaggageHeader toBaggageHeader(@Nullable List<String> list) {
        Baggage baggage;
        if (!this.scopes.getOptions().isTraceSampling() || (baggage = getSpanContext().getBaggage()) == null) {
            return null;
        }
        updateBaggageValues(baggage);
        return BaggageHeader.fromBaggageAndOutgoingHeader(baggage, list);
    }

    private boolean hasAllChildrenFinished() {
        ListIterator<Span> listIterator = this.children.listIterator();
        while (listIterator.hasNext()) {
            Span next = listIterator.next();
            if (!next.isFinished() && next.getFinishDate() == null) {
                return false;
            }
        }
        return true;
    }

    @Override // io.sentry.ISpan
    public void setOperation(@NotNull String str) {
        if (this.root.isFinished()) {
            this.scopes.getOptions().getLogger().log(SentryLevel.DEBUG, "The transaction is already finished. Operation %s cannot be set", str);
        } else {
            this.root.setOperation(str);
        }
    }

    @Override // io.sentry.ISpan
    public String getOperation() {
        return this.root.getOperation();
    }

    @Override // io.sentry.ISpan
    public void setDescription(@Nullable String str) {
        if (this.root.isFinished()) {
            this.scopes.getOptions().getLogger().log(SentryLevel.DEBUG, "The transaction is already finished. Description %s cannot be set", str);
        } else {
            this.root.setDescription(str);
        }
    }

    @Override // io.sentry.ISpan
    public String getDescription() {
        return this.root.getDescription();
    }

    @Override // io.sentry.ISpan
    public void setStatus(@Nullable SpanStatus spanStatus) {
        if (this.root.isFinished()) {
            this.scopes.getOptions().getLogger().log(SentryLevel.DEBUG, "The transaction is already finished. Status %s cannot be set", spanStatus == null ? com.google.maps.android.BuildConfig.TRAVIS : spanStatus.name());
        } else {
            this.root.setStatus(spanStatus);
        }
    }

    @Override // io.sentry.ISpan
    public SpanStatus getStatus() {
        return this.root.getStatus();
    }

    @Override // io.sentry.ISpan
    public void setThrowable(@Nullable Throwable th) {
        if (this.root.isFinished()) {
            this.scopes.getOptions().getLogger().log(SentryLevel.DEBUG, "The transaction is already finished. Throwable cannot be set", new Object[0]);
        } else {
            this.root.setThrowable(th);
        }
    }

    @Override // io.sentry.ISpan
    public Throwable getThrowable() {
        return this.root.getThrowable();
    }

    @Override // io.sentry.ISpan
    public SpanContext getSpanContext() {
        return this.root.getSpanContext();
    }

    @Override // io.sentry.ISpan
    public void setTag(@Nullable String str, @Nullable String str2) {
        if (this.root.isFinished()) {
            this.scopes.getOptions().getLogger().log(SentryLevel.DEBUG, "The transaction is already finished. Tag %s cannot be set", str);
        } else {
            this.root.setTag(str, str2);
        }
    }

    @Override // io.sentry.ISpan
    public String getTag(@Nullable String str) {
        return this.root.getTag(str);
    }

    @Override // io.sentry.ISpan
    public boolean isFinished() {
        return this.root.isFinished();
    }

    @Override // io.sentry.ISpan
    public void setData(@Nullable String str, @Nullable Object obj) {
        if (this.root.isFinished()) {
            this.scopes.getOptions().getLogger().log(SentryLevel.DEBUG, "The transaction is already finished. Data %s cannot be set", str);
        } else {
            this.root.setData(str, obj);
        }
    }

    @Override // io.sentry.ISpan
    public Object getData(@Nullable String str) {
        return this.root.getData(str);
    }

    public void setMeasurementFromChild(@NotNull String str, @NotNull Number number) {
        if (this.root.getMeasurements().containsKey(str)) {
            return;
        }
        setMeasurement(str, number);
    }

    public void setMeasurementFromChild(@NotNull String str, @NotNull Number number, @NotNull MeasurementUnit measurementUnit) {
        if (this.root.getMeasurements().containsKey(str)) {
            return;
        }
        setMeasurement(str, number, measurementUnit);
    }

    @Override // io.sentry.ISpan
    public void setMeasurement(@NotNull String str, @NotNull Number number) {
        this.root.setMeasurement(str, number);
    }

    @Override // io.sentry.ISpan
    public void setMeasurement(@NotNull String str, @NotNull Number number, @NotNull MeasurementUnit measurementUnit) {
        this.root.setMeasurement(str, number, measurementUnit);
    }

    public Map<String, Object> getData() {
        return this.root.getData();
    }

    @Override // io.sentry.ISpan
    public Boolean isSampled() {
        return this.root.isSampled();
    }

    @Override // io.sentry.ITransaction
    public Boolean isProfileSampled() {
        return this.root.isProfileSampled();
    }

    @Override // io.sentry.ISpan
    public TracesSamplingDecision getSamplingDecision() {
        return this.root.getSamplingDecision();
    }

    @Override // io.sentry.ITransaction
    public void setName(@NotNull String str) {
        setName(str, TransactionNameSource.CUSTOM);
    }

    @Override // io.sentry.ITransaction
    public void setName(@NotNull String str, @NotNull TransactionNameSource transactionNameSource) {
        if (this.root.isFinished()) {
            this.scopes.getOptions().getLogger().log(SentryLevel.DEBUG, "The transaction is already finished. Name %s cannot be set", str);
        } else {
            this.name = str;
            this.transactionNameSource = transactionNameSource;
        }
    }

    @Override // io.sentry.ITransaction
    public String getName() {
        return this.name;
    }

    @Override // io.sentry.ITransaction
    public TransactionNameSource getTransactionNameSource() {
        return this.transactionNameSource;
    }

    @Override // io.sentry.ITransaction
    public List<Span> getSpans() {
        return this.children;
    }

    @Override // io.sentry.ITransaction
    public ISpan getLatestActiveSpan() {
        ListIterator listIteratorReverseListIterator = CollectionUtils.reverseListIterator((CopyOnWriteArrayList) this.children);
        while (listIteratorReverseListIterator.hasPrevious()) {
            Span span = (Span) listIteratorReverseListIterator.previous();
            if (!span.isFinished()) {
                return span;
            }
        }
        return null;
    }

    @Override // io.sentry.ITransaction
    public SentryId getEventId() {
        return this.eventId;
    }

    @Override // io.sentry.ISpan
    public ISentryLifecycleToken makeCurrent() {
        this.scopes.configureScope(new ScopeCallback() { // from class: io.sentry.SentryTracer$$ExternalSyntheticLambda5
            @Override // io.sentry.ScopeCallback
            public final void run(IScope iScope) {
                this.f$0.lambda$makeCurrent$5(iScope);
            }
        });
        return NoOpScopesLifecycleToken.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$makeCurrent$5(IScope iScope) {
        iScope.setTransaction(this);
    }

    Span getRoot() {
        return this.root;
    }

    TimerTask getIdleTimeoutTask() {
        return this.idleTimeoutTask;
    }

    TimerTask getDeadlineTimeoutTask() {
        return this.deadlineTimeoutTask;
    }

    Timer getTimer() {
        return this.timer;
    }

    AtomicBoolean isFinishTimerRunning() {
        return this.isIdleFinishTimerRunning;
    }

    AtomicBoolean isDeadlineTimerRunning() {
        return this.isDeadlineTimerRunning;
    }

    @Override // io.sentry.ISpan
    public void setContext(@Nullable String str, @Nullable Object obj) {
        this.contexts.put(str, obj);
    }

    @Override // io.sentry.ISpan
    public Contexts getContexts() {
        return this.contexts;
    }

    @Override // io.sentry.ISpan
    public boolean updateEndDate(@NotNull SentryDate sentryDate) {
        return this.root.updateEndDate(sentryDate);
    }

    static final class FinishStatus {
        static final FinishStatus NOT_FINISHED = notFinished();
        private final boolean isFinishing;
        private final SpanStatus spanStatus;

        static FinishStatus finishing(@Nullable SpanStatus spanStatus) {
            return new FinishStatus(true, spanStatus);
        }

        private static FinishStatus notFinished() {
            return new FinishStatus(false, null);
        }

        private FinishStatus(boolean z, @Nullable SpanStatus spanStatus) {
            this.isFinishing = z;
            this.spanStatus = spanStatus;
        }
    }
}
