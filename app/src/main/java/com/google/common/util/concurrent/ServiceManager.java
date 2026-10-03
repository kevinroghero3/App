package com.google.common.util.concurrent;

import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.google.common.base.Ascii;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicates;
import com.google.common.base.Stopwatch;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.MultimapBuilder;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Multiset;
import com.google.common.collect.Ordering;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.UnmodifiableIterator;
import com.salesforce.marketingcloud.analytics.stats.b;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import o.ArtificialStackFrames;
import o._CREATION;

/* JADX INFO: loaded from: classes5.dex */
@ElementTypesAreNonnullByDefault
public final class ServiceManager implements ServiceManagerBridge {
    private final ImmutableList<Service> services;
    private final ServiceManagerState state;
    private static final Logger logger = Logger.getLogger(ServiceManager.class.getName());
    private static final ListenerCallQueue.Event<Listener> HEALTHY_EVENT = new ListenerCallQueue.Event<Listener>() { // from class: com.google.common.util.concurrent.ServiceManager.1
        @Override // com.google.common.util.concurrent.ListenerCallQueue.Event
        public void call(Listener listener) {
            listener.healthy();
        }

        public String toString() {
            return "healthy()";
        }
    };
    private static final ListenerCallQueue.Event<Listener> STOPPED_EVENT = new ListenerCallQueue.Event<Listener>() { // from class: com.google.common.util.concurrent.ServiceManager.2
        @Override // com.google.common.util.concurrent.ListenerCallQueue.Event
        public void call(Listener listener) {
            listener.stopped();
        }

        public String toString() {
            return "stopped()";
        }
    };

    public static abstract class Listener {
        public void failure(Service service) {
        }

        public void healthy() {
        }

        public void stopped() {
        }
    }

    public ServiceManager(Iterable<? extends Service> iterable) {
        ImmutableList<Service> immutableListCopyOf = ImmutableList.copyOf(iterable);
        if (immutableListCopyOf.isEmpty()) {
            logger.log(Level.WARNING, "ServiceManager configured with no services.  Is your application configured properly?", (Throwable) new EmptyServiceManagerWarning());
            immutableListCopyOf = ImmutableList.of(new NoOpService());
        }
        ServiceManagerState serviceManagerState = new ServiceManagerState(immutableListCopyOf);
        this.state = serviceManagerState;
        this.services = immutableListCopyOf;
        WeakReference weakReference = new WeakReference(serviceManagerState);
        UnmodifiableIterator<Service> it2 = immutableListCopyOf.iterator();
        while (it2.hasNext()) {
            Service next = it2.next();
            next.addListener(new ServiceListener(next, weakReference), MoreExecutors.directExecutor());
            Preconditions.checkArgument(next.state() == Service.State.NEW, "Can only manage NEW services, %s", next);
        }
        this.state.markReady();
    }

    public void addListener(Listener listener, Executor executor) {
        this.state.addListener(listener, executor);
    }

    public ServiceManager startAsync() {
        UnmodifiableIterator<Service> it2 = this.services.iterator();
        while (it2.hasNext()) {
            Preconditions.checkState(it2.next().state() == Service.State.NEW, "Not all services are NEW, cannot start %s", this);
        }
        UnmodifiableIterator<Service> it3 = this.services.iterator();
        while (it3.hasNext()) {
            Service next = it3.next();
            try {
                this.state.tryStartTiming(next);
                next.startAsync();
            } catch (IllegalStateException e) {
                Logger logger2 = logger;
                Level level = Level.WARNING;
                String strValueOf = String.valueOf(next);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 24);
                sb.append("Unable to start Service ");
                sb.append(strValueOf);
                logger2.log(level, sb.toString(), (Throwable) e);
            }
        }
        return this;
    }

    public void awaitHealthy() {
        this.state.awaitHealthy();
    }

    public void awaitHealthy(long j, TimeUnit timeUnit) throws TimeoutException {
        this.state.awaitHealthy(j, timeUnit);
    }

    public ServiceManager stopAsync() {
        UnmodifiableIterator<Service> it2 = this.services.iterator();
        while (it2.hasNext()) {
            it2.next().stopAsync();
        }
        return this;
    }

    public void awaitStopped() {
        this.state.awaitStopped();
    }

    public void awaitStopped(long j, TimeUnit timeUnit) throws TimeoutException {
        this.state.awaitStopped(j, timeUnit);
    }

    public boolean isHealthy() {
        UnmodifiableIterator<Service> it2 = this.services.iterator();
        while (it2.hasNext()) {
            if (!it2.next().isRunning()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.common.util.concurrent.ServiceManagerBridge
    public ImmutableSetMultimap<Service.State, Service> servicesByState() {
        return this.state.servicesByState();
    }

    public ImmutableMap<Service, Long> startupTimes() {
        return this.state.startupTimes();
    }

    public String toString() {
        return MoreObjects.toStringHelper((Class<?>) ServiceManager.class).add("services", Collections2.filter(this.services, Predicates.not(Predicates.instanceOf(NoOpService.class)))).toString();
    }

    static final class ServiceManagerState {
        final Monitor.Guard awaitHealthGuard;
        final ListenerCallQueue<Listener> listeners;
        final Monitor monitor = new Monitor();
        final int numberOfServices;
        boolean ready;
        final SetMultimap<Service.State, Service> servicesByState;
        final Map<Service, Stopwatch> startupTimers;
        final Multiset<Service.State> states;
        final Monitor.Guard stoppedGuard;
        boolean transitioned;

        final class AwaitHealthGuard extends Monitor.Guard {
            AwaitHealthGuard() {
                super(ServiceManagerState.this.monitor);
            }

            @Override // com.google.common.util.concurrent.Monitor.Guard
            public boolean isSatisfied() {
                int iCount = ServiceManagerState.this.states.count(Service.State.RUNNING);
                ServiceManagerState serviceManagerState = ServiceManagerState.this;
                return iCount == serviceManagerState.numberOfServices || serviceManagerState.states.contains(Service.State.STOPPING) || ServiceManagerState.this.states.contains(Service.State.TERMINATED) || ServiceManagerState.this.states.contains(Service.State.FAILED);
            }
        }

        final class StoppedGuard extends Monitor.Guard {
            StoppedGuard() {
                super(ServiceManagerState.this.monitor);
            }

            @Override // com.google.common.util.concurrent.Monitor.Guard
            public boolean isSatisfied() {
                return ServiceManagerState.this.states.count(Service.State.TERMINATED) + ServiceManagerState.this.states.count(Service.State.FAILED) == ServiceManagerState.this.numberOfServices;
            }
        }

        ServiceManagerState(ImmutableCollection<Service> immutableCollection) {
            SetMultimap<Service.State, Service> setMultimapBuild = MultimapBuilder.enumKeys(Service.State.class).linkedHashSetValues().build();
            this.servicesByState = setMultimapBuild;
            this.states = setMultimapBuild.keys();
            this.startupTimers = Maps.newIdentityHashMap();
            this.awaitHealthGuard = new AwaitHealthGuard();
            this.stoppedGuard = new StoppedGuard();
            this.listeners = new ListenerCallQueue<>();
            this.numberOfServices = immutableCollection.size();
            setMultimapBuild.putAll(Service.State.NEW, immutableCollection);
        }

        void tryStartTiming(Service service) {
            this.monitor.enter();
            try {
                if (this.startupTimers.get(service) == null) {
                    this.startupTimers.put(service, Stopwatch.createStarted());
                }
            } finally {
                this.monitor.leave();
            }
        }

        void markReady() {
            this.monitor.enter();
            try {
                if (!this.transitioned) {
                    this.ready = true;
                    this.monitor.leave();
                    return;
                }
                ArrayList arrayListNewArrayList = Lists.newArrayList();
                UnmodifiableIterator<Service> it2 = servicesByState().values().iterator();
                while (it2.hasNext()) {
                    Service next = it2.next();
                    if (next.state() != Service.State.NEW) {
                        arrayListNewArrayList.add(next);
                    }
                }
                String strValueOf = String.valueOf(arrayListNewArrayList);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 89);
                sb.append("Services started transitioning asynchronously before the ServiceManager was constructed: ");
                sb.append(strValueOf);
                throw new IllegalArgumentException(sb.toString());
            } catch (Throwable th) {
                this.monitor.leave();
                throw th;
            }
        }

        void addListener(Listener listener, Executor executor) {
            this.listeners.addListener(listener, executor);
        }

        void awaitHealthy() {
            this.monitor.enterWhenUninterruptibly(this.awaitHealthGuard);
            try {
                checkHealthy();
            } finally {
                this.monitor.leave();
            }
        }

        void awaitHealthy(long j, TimeUnit timeUnit) throws TimeoutException {
            this.monitor.enter();
            try {
                if (!this.monitor.waitForUninterruptibly(this.awaitHealthGuard, j, timeUnit)) {
                    String strValueOf = String.valueOf(Multimaps.filterKeys((SetMultimap) this.servicesByState, Predicates.in(ImmutableSet.of(Service.State.NEW, Service.State.STARTING))));
                    StringBuilder sb = new StringBuilder(strValueOf.length() + 93);
                    sb.append("Timeout waiting for the services to become healthy. The following services have not started: ");
                    sb.append(strValueOf);
                    throw new TimeoutException(sb.toString());
                }
                checkHealthy();
                this.monitor.leave();
            } catch (Throwable th) {
                this.monitor.leave();
                throw th;
            }
        }

        void awaitStopped() {
            this.monitor.enterWhenUninterruptibly(this.stoppedGuard);
            this.monitor.leave();
        }

        void awaitStopped(long j, TimeUnit timeUnit) throws TimeoutException {
            this.monitor.enter();
            try {
                if (!this.monitor.waitForUninterruptibly(this.stoppedGuard, j, timeUnit)) {
                    String strValueOf = String.valueOf(Multimaps.filterKeys((SetMultimap) this.servicesByState, Predicates.not(Predicates.in(EnumSet.of(Service.State.TERMINATED, Service.State.FAILED)))));
                    StringBuilder sb = new StringBuilder(strValueOf.length() + 83);
                    sb.append("Timeout waiting for the services to stop. The following services have not stopped: ");
                    sb.append(strValueOf);
                    throw new TimeoutException(sb.toString());
                }
                this.monitor.leave();
            } catch (Throwable th) {
                this.monitor.leave();
                throw th;
            }
        }

        ImmutableSetMultimap<Service.State, Service> servicesByState() {
            ImmutableSetMultimap.Builder builder = ImmutableSetMultimap.builder();
            this.monitor.enter();
            try {
                for (Map.Entry<Service.State, Service> entry : this.servicesByState.entries()) {
                    if (!(entry.getValue() instanceof NoOpService)) {
                        builder.put((Map.Entry) entry);
                    }
                }
                this.monitor.leave();
                return builder.build();
            } catch (Throwable th) {
                this.monitor.leave();
                throw th;
            }
        }

        ImmutableMap<Service, Long> startupTimes() {
            this.monitor.enter();
            try {
                ArrayList arrayListNewArrayListWithCapacity = Lists.newArrayListWithCapacity(this.startupTimers.size());
                for (Map.Entry<Service, Stopwatch> entry : this.startupTimers.entrySet()) {
                    Service key = entry.getKey();
                    Stopwatch value = entry.getValue();
                    if (!value.isRunning() && !(key instanceof NoOpService)) {
                        arrayListNewArrayListWithCapacity.add(Maps.immutableEntry(key, Long.valueOf(value.elapsed(TimeUnit.MILLISECONDS))));
                    }
                }
                this.monitor.leave();
                Collections.sort(arrayListNewArrayListWithCapacity, Ordering.natural().onResultOf(new Function<Map.Entry<Service, Long>, Long>(this) { // from class: com.google.common.util.concurrent.ServiceManager.ServiceManagerState.1
                    @Override // com.google.common.base.Function
                    public Long apply(Map.Entry<Service, Long> entry2) {
                        return entry2.getValue();
                    }
                }));
                return ImmutableMap.copyOf(arrayListNewArrayListWithCapacity);
            } catch (Throwable th) {
                this.monitor.leave();
                throw th;
            }
        }

        void transitionService(Service service, Service.State state, Service.State state2) {
            Preconditions.checkNotNull(service);
            Preconditions.checkArgument(state != state2);
            this.monitor.enter();
            try {
                this.transitioned = true;
                if (this.ready) {
                    Preconditions.checkState(this.servicesByState.remove(state, service), "Service %s not at the expected location in the state map %s", service, state);
                    Preconditions.checkState(this.servicesByState.put(state2, service), "Service %s in the state map unexpectedly at %s", service, state2);
                    Stopwatch stopwatchCreateStarted = this.startupTimers.get(service);
                    if (stopwatchCreateStarted == null) {
                        stopwatchCreateStarted = Stopwatch.createStarted();
                        this.startupTimers.put(service, stopwatchCreateStarted);
                    }
                    Service.State state3 = Service.State.RUNNING;
                    if (state2.compareTo(state3) >= 0 && stopwatchCreateStarted.isRunning()) {
                        stopwatchCreateStarted.stop();
                        if (!(service instanceof NoOpService)) {
                            ServiceManager.logger.log(Level.FINE, "Started {0} in {1}.", new Object[]{service, stopwatchCreateStarted});
                        }
                    }
                    Service.State state4 = Service.State.FAILED;
                    if (state2 == state4) {
                        enqueueFailedEvent(service);
                    }
                    if (this.states.count(state3) == this.numberOfServices) {
                        enqueueHealthyEvent();
                    } else if (this.states.count(Service.State.TERMINATED) + this.states.count(state4) == this.numberOfServices) {
                        enqueueStoppedEvent();
                    }
                }
            } finally {
                this.monitor.leave();
                dispatchListenerEvents();
            }
        }

        void enqueueStoppedEvent() {
            this.listeners.enqueue(ServiceManager.STOPPED_EVENT);
        }

        void enqueueHealthyEvent() {
            this.listeners.enqueue(ServiceManager.HEALTHY_EVENT);
        }

        void enqueueFailedEvent(final Service service) {
            this.listeners.enqueue(new ListenerCallQueue.Event<Listener>(this) { // from class: com.google.common.util.concurrent.ServiceManager.ServiceManagerState.2
                private static final byte[] $$c = {44, 60, -60, 113};
                private static final int $$d = b.f39n;
                private static int $10 = 0;
                private static int $11 = 1;
                private static final byte[] $$a = {70, -54, 7, 50, -31, -17, -4, 38, -49, -3, -8, 10, -24, Ascii.US, -22, -22, 10, -7, -12, -2, -22, Ascii.DLE, -18, 9, -20, 44, -35, -20, -9, 6, -11, -4, 0, -10, 2, Ascii.GS, -46, 8, -6, -15, 2, -4, 9, -20, Ascii.FS, -26, -18, 10, -5, -11, 2, 19, -39, 6, -6, Ascii.ESC, -46, 8, -6, -15, 2, -4, Ascii.CR, -24, -13, -7, -12, Ascii.FF, -4, 50, -50, -14};
                private static final int $$b = 191;
                private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
                private static int artificialFrame = 1;
                private static char[] _CREATION = {6559, 43597, 32288, 539, 55013, 39622, 11956, 62171, 34677, 19284, 7986, 41973, 30663, 15273, 53148, 36899, 9325, 59452, 48154, 16621, 5343, 55463, 28020, 64637, 20386, 39892, 59340, 13086, 32571, 52056, 6008, 25233, 44734, 64204, 17932, 37417, 56909, 10821, 30087, 49580, 3544, 6559, 43597, 32288, 539, 55013, 39622, 11956, 62171, 34677, 19284, 7986, 41973, 30663, 15273, 53148, 36899, 9310, 59454, 48218, 16600, 5322, 55471, 28012, 12620, 50469, 35082, 24056, 57816, 46525, 31129, 2641, 56915, 25144, 14060, 6552, 43599, 32293, 526, 55033, 6609, 43590, 32304, 522, 54949, 39622, 11966, 62108, 34658, 19220, 7984, 41965, 30665, 15267, 53189, 36969, 9291, 59441, 48129, 16638, 5341, 55486, 28002, 12617, 50467, 35141, 24062, 57810, 6540, 43596, 32362, 525, 55023, 39629, 11941, 62098, 34673, 19290, 7998, 41965, 30663, 6607};
                private static long _BOUNDARY = 1940083025037797923L;

                /* JADX WARN: Code duplicated, block: B:10:0x0023  */
                /* JADX WARN: Code duplicated, block: B:8:0x001d  */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x0027). Please report as a decompilation issue!!! */
                /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                    jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
                    	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                    	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                    	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                    */
                private static java.lang.String $$e(int r5, byte r6, short r7) {
                    /*
                        int r6 = r6 * 3
                        int r6 = 4 - r6
                        int r7 = r7 + 103
                        int r5 = r5 * 2
                        int r0 = 1 - r5
                        byte[] r1 = com.google.common.util.concurrent.ServiceManager.ServiceManagerState.AnonymousClass2.$$c
                        byte[] r0 = new byte[r0]
                        r2 = 0
                        int r5 = 0 - r5
                        if (r1 != 0) goto L17
                        r4 = r7
                        r3 = r2
                        r7 = r5
                        goto L27
                    L17:
                        r3 = r2
                    L18:
                        byte r4 = (byte) r7
                        r0[r3] = r4
                        if (r3 != r5) goto L23
                        java.lang.String r5 = new java.lang.String
                        r5.<init>(r0, r2)
                        return r5
                    L23:
                        int r3 = r3 + 1
                        r4 = r1[r6]
                    L27:
                        int r7 = r7 + r4
                        int r6 = r6 + 1
                        goto L18
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.ServiceManager.ServiceManagerState.AnonymousClass2.$$e(int, byte, short):java.lang.String");
                }

                /* JADX WARN: Code duplicated, block: B:10:0x0023  */
                /* JADX WARN: Code duplicated, block: B:8:0x001b  */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x002a). Please report as a decompilation issue!!! */
                /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                    jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
                    	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                    	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                    	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                    */
                private static void a(byte r6, byte r7, short r8, java.lang.Object[] r9) {
                    /*
                        int r7 = 115 - r7
                        int r8 = 69 - r8
                        byte[] r0 = com.google.common.util.concurrent.ServiceManager.ServiceManagerState.AnonymousClass2.$$a
                        int r1 = 28 - r6
                        byte[] r1 = new byte[r1]
                        int r6 = 27 - r6
                        r2 = 0
                        if (r0 != 0) goto L13
                        r7 = r6
                        r3 = r8
                        r4 = r2
                        goto L2a
                    L13:
                        r3 = r2
                    L14:
                        byte r4 = (byte) r7
                        r1[r3] = r4
                        int r4 = r3 + 1
                        if (r3 != r6) goto L23
                        java.lang.String r6 = new java.lang.String
                        r6.<init>(r1, r2)
                        r9[r2] = r6
                        return
                    L23:
                        int r8 = r8 + 1
                        r3 = r0[r8]
                        r5 = r3
                        r3 = r8
                        r8 = r5
                    L2a:
                        int r8 = -r8
                        int r7 = r7 + r8
                        int r7 = r7 + (-5)
                        r8 = r3
                        r3 = r4
                        goto L14
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.ServiceManager.ServiceManagerState.AnonymousClass2.a(byte, byte, short, java.lang.Object[]):void");
                }

                private static void b(char c, int i, int i2, Object[] objArr) throws Throwable {
                    int i3 = 2 % 2;
                    _CREATION _creation = new _CREATION();
                    long[] jArr = new long[i2];
                    _creation.b = 0;
                    int i4 = $10 + 41;
                    $11 = i4 % 128;
                    int i5 = i4 % 2;
                    while (_creation.b < i2) {
                        int i6 = $10 + b.i;
                        $11 = i6 % 128;
                        if (i6 % 2 == 0) {
                            int i7 = _creation.b;
                            try {
                                Object[] objArr2 = {Integer.valueOf(_CREATION[i >>> i7])};
                                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-587087340);
                                if (objAccessartificialFrame == null) {
                                    byte b = (byte) 0;
                                    byte b2 = b;
                                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(8 - (ViewConfiguration.getDoubleTapTimeout() >> 16), (char) (9279 - ExpandableListView.getPackedPositionGroup(0L)), TextUtils.lastIndexOf("", '0', 0) + 1978, 1113883676, false, $$e(b, b2, (byte) (b2 + 1)), new Class[]{Integer.TYPE});
                                }
                                try {
                                    Object[] objArr3 = {Long.valueOf(((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue()), Long.valueOf(i7), Long.valueOf(_BOUNDARY), Integer.valueOf(c)};
                                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1715896821);
                                    if (objAccessartificialFrame2 == null) {
                                        byte b3 = (byte) 0;
                                        byte b4 = b3;
                                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(31 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (char) (49362 - ((Process.getThreadPriority(0) + 20) >> 6)), 684 - (ViewConfiguration.getScrollBarSize() >> 8), -115095555, false, $$e(b3, b4, (byte) (b4 + 3)), new Class[]{Long.TYPE, Long.TYPE, Long.TYPE, Integer.TYPE});
                                    }
                                    jArr[i7] = ((Long) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).longValue();
                                    try {
                                        Object[] objArr4 = {_creation, _creation};
                                        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-293902099);
                                        if (objAccessartificialFrame3 == null) {
                                            byte b5 = (byte) 0;
                                            byte b6 = b5;
                                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(24 - ImageFormat.getBitsPerPixel(0), (char) (30068 - (ViewConfiguration.getFadingEdgeLength() >> 16)), 815 - TextUtils.lastIndexOf("", '0'), 1897803493, false, $$e(b5, b6, b6), new Class[]{Object.class, Object.class});
                                        }
                                        ((Method) objAccessartificialFrame3).invoke(null, objArr4);
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
                            } catch (Throwable th3) {
                                Throwable cause3 = th3.getCause();
                                if (cause3 == null) {
                                    throw th3;
                                }
                                throw cause3;
                            }
                        } else {
                            int i8 = _creation.b;
                            try {
                                Object[] objArr5 = {Integer.valueOf(_CREATION[i + i8])};
                                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-587087340);
                                if (objAccessartificialFrame4 == null) {
                                    byte b7 = (byte) 0;
                                    byte b8 = b7;
                                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 8, (char) ((-16767937) - Color.rgb(0, 0, 0)), 1977 - Drawable.resolveOpacity(0, 0), 1113883676, false, $$e(b7, b8, (byte) (b8 + 1)), new Class[]{Integer.TYPE});
                                }
                                Object[] objArr6 = {Long.valueOf(((Long) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).longValue()), Long.valueOf(i8), Long.valueOf(_BOUNDARY), Integer.valueOf(c)};
                                Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(1715896821);
                                if (objAccessartificialFrame5 == null) {
                                    byte b9 = (byte) 0;
                                    byte b10 = b9;
                                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(MotionEvent.axisFromString("") + 31, (char) (View.combineMeasuredStates(0, 0) + 49362), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 683, -115095555, false, $$e(b9, b10, (byte) (b10 + 3)), new Class[]{Long.TYPE, Long.TYPE, Long.TYPE, Integer.TYPE});
                                }
                                jArr[i8] = ((Long) ((Method) objAccessartificialFrame5).invoke(null, objArr6)).longValue();
                                Object[] objArr7 = {_creation, _creation};
                                Object objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-293902099);
                                if (objAccessartificialFrame6 == null) {
                                    byte b11 = (byte) 0;
                                    byte b12 = b11;
                                    objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(25 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (char) ((ViewConfiguration.getEdgeSlop() >> 16) + 30068), 816 - TextUtils.getTrimmedLength(""), 1897803493, false, $$e(b11, b12, b12), new Class[]{Object.class, Object.class});
                                }
                                ((Method) objAccessartificialFrame6).invoke(null, objArr7);
                            } catch (Throwable th4) {
                                Throwable cause4 = th4.getCause();
                                if (cause4 == null) {
                                    throw th4;
                                }
                                throw cause4;
                            }
                        }
                    }
                    char[] cArr = new char[i2];
                    _creation.b = 0;
                    while (_creation.b < i2) {
                        cArr[_creation.b] = (char) jArr[_creation.b];
                        Object[] objArr8 = {_creation, _creation};
                        Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-293902099);
                        if (objAccessartificialFrame7 == null) {
                            byte b13 = (byte) 0;
                            byte b14 = b13;
                            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(25 - KeyEvent.normalizeMetaState(0), (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 30067), (Process.myTid() >> 22) + 816, 1897803493, false, $$e(b13, b14, b14), new Class[]{Object.class, Object.class});
                        }
                        ((Method) objAccessartificialFrame7).invoke(null, objArr8);
                    }
                    objArr[0] = new String(cArr);
                }

                @Override // com.google.common.util.concurrent.ListenerCallQueue.Event
                public void call(Listener listener) {
                    listener.failure(service);
                }

                public String toString() {
                    String strValueOf = String.valueOf(service);
                    StringBuilder sb = new StringBuilder(strValueOf.length() + 18);
                    sb.append("failed({service=");
                    sb.append(strValueOf);
                    sb.append("})");
                    return sb.toString();
                }

                /* JADX WARN: Code duplicated, block: B:46:0x05a2  */
                /* JADX WARN: Code duplicated, block: B:48:0x05a8  */
                /* JADX WARN: Code duplicated, block: B:50:0x05cd  */
                /* JADX WARN: Code duplicated, block: B:51:0x05d8  */
                /* JADX WARN: Code restructure failed: missing block: B:102:0x0a4f, code lost:
                
                    if (r0.equals((java.lang.String) r7[0]) != false) goto L103;
                 */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public static java.lang.Object[] CoroutineDebuggingKt(android.content.Context r28, int r29, int r30, int r31) throws java.lang.Throwable {
                    /*
                        Method dump skipped, instruction units count: 3055
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.ServiceManager.ServiceManagerState.AnonymousClass2.CoroutineDebuggingKt(android.content.Context, int, int, int):java.lang.Object[]");
                }
            });
        }

        void dispatchListenerEvents() {
            Preconditions.checkState(!this.monitor.isOccupiedByCurrentThread(), "It is incorrect to execute listeners with the monitor held.");
            this.listeners.dispatch();
        }

        void checkHealthy() {
            Multiset<Service.State> multiset = this.states;
            Service.State state = Service.State.RUNNING;
            if (multiset.count(state) == this.numberOfServices) {
                return;
            }
            String strValueOf = String.valueOf(Multimaps.filterKeys((SetMultimap) this.servicesByState, Predicates.not(Predicates.equalTo(state))));
            StringBuilder sb = new StringBuilder(strValueOf.length() + 79);
            sb.append("Expected to be healthy after starting. The following services are not running: ");
            sb.append(strValueOf);
            throw new IllegalStateException(sb.toString());
        }
    }

    static final class ServiceListener extends Service.Listener {
        final Service service;
        final WeakReference<ServiceManagerState> state;

        ServiceListener(Service service, WeakReference<ServiceManagerState> weakReference) {
            this.service = service;
            this.state = weakReference;
        }

        @Override // com.google.common.util.concurrent.Service.Listener
        public void starting() {
            ServiceManagerState serviceManagerState = this.state.get();
            if (serviceManagerState != null) {
                serviceManagerState.transitionService(this.service, Service.State.NEW, Service.State.STARTING);
                if (this.service instanceof NoOpService) {
                    return;
                }
                ServiceManager.logger.log(Level.FINE, "Starting {0}.", this.service);
            }
        }

        @Override // com.google.common.util.concurrent.Service.Listener
        public void running() {
            ServiceManagerState serviceManagerState = this.state.get();
            if (serviceManagerState != null) {
                serviceManagerState.transitionService(this.service, Service.State.STARTING, Service.State.RUNNING);
            }
        }

        @Override // com.google.common.util.concurrent.Service.Listener
        public void stopping(Service.State state) {
            ServiceManagerState serviceManagerState = this.state.get();
            if (serviceManagerState != null) {
                serviceManagerState.transitionService(this.service, state, Service.State.STOPPING);
            }
        }

        @Override // com.google.common.util.concurrent.Service.Listener
        public void terminated(Service.State state) {
            ServiceManagerState serviceManagerState = this.state.get();
            if (serviceManagerState != null) {
                if (!(this.service instanceof NoOpService)) {
                    ServiceManager.logger.log(Level.FINE, "Service {0} has terminated. Previous state was: {1}", new Object[]{this.service, state});
                }
                serviceManagerState.transitionService(this.service, state, Service.State.TERMINATED);
            }
        }

        @Override // com.google.common.util.concurrent.Service.Listener
        public void failed(Service.State state, Throwable th) {
            ServiceManagerState serviceManagerState = this.state.get();
            if (serviceManagerState != null) {
                if (!(this.service instanceof NoOpService)) {
                    Logger logger = ServiceManager.logger;
                    Level level = Level.SEVERE;
                    String strValueOf = String.valueOf(this.service);
                    String strValueOf2 = String.valueOf(state);
                    StringBuilder sb = new StringBuilder(strValueOf.length() + 34 + strValueOf2.length());
                    sb.append("Service ");
                    sb.append(strValueOf);
                    sb.append(" has failed in the ");
                    sb.append(strValueOf2);
                    sb.append(" state.");
                    logger.log(level, sb.toString(), th);
                }
                serviceManagerState.transitionService(this.service, state, Service.State.FAILED);
            }
        }
    }

    static final class NoOpService extends AbstractService {
        private NoOpService() {
        }

        @Override // com.google.common.util.concurrent.AbstractService
        protected void doStart() {
            notifyStarted();
        }

        @Override // com.google.common.util.concurrent.AbstractService
        protected void doStop() {
            notifyStopped();
        }
    }

    static final class EmptyServiceManagerWarning extends Throwable {
        private EmptyServiceManagerWarning() {
        }
    }
}
