package io.sentry;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import ch.qos.logback.core.net.SyslogConstants;
import com.facebook.imageutils.JfifUtil;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.salesforce.marketingcloud.analytics.stats.b;
import io.sentry.cache.EnvelopeCache;
import io.sentry.hints.Flushable;
import io.sentry.hints.Resettable;
import io.sentry.hints.Retryable;
import io.sentry.hints.SubmissionResult;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.SentryTransaction;
import io.sentry.util.CollectionUtils;
import io.sentry.util.HintUtils;
import io.sentry.util.LogUtils;
import io.sentry.util.Objects;
import io.sentry.util.SampleRateUtils;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import o.ArtificialStackFrames;
import o.ICustomTabsCallback;
import o.onRelationshipValidationResult;
import org.apache.commons.lang3.CharEncoding;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class OutboxSender extends DirectoryProcessor implements IEnvelopeSender {
    private static final Charset UTF_8 = Charset.forName(CharEncoding.UTF_8);
    private final IEnvelopeReader envelopeReader;
    private final ILogger logger;
    private final IScopes scopes;
    private final ISerializer serializer;

    @Override // io.sentry.DirectoryProcessor
    public /* bridge */ /* synthetic */ void processDirectory(@NotNull File file) {
        super.processDirectory(file);
    }

    public OutboxSender(@NotNull IScopes iScopes, @NotNull IEnvelopeReader iEnvelopeReader, @NotNull ISerializer iSerializer, @NotNull ILogger iLogger, long j, int i) {
        super(iScopes, iLogger, j, i);
        this.scopes = (IScopes) Objects.requireNonNull(iScopes, "Scopes are required.");
        this.envelopeReader = (IEnvelopeReader) Objects.requireNonNull(iEnvelopeReader, "Envelope reader is required.");
        this.serializer = (ISerializer) Objects.requireNonNull(iSerializer, "Serializer is required.");
        this.logger = (ILogger) Objects.requireNonNull(iLogger, "Logger is required.");
    }

    @Override // io.sentry.DirectoryProcessor
    protected void processFile(@NotNull final File file, @NotNull Hint hint) {
        ILogger iLogger;
        HintUtils.SentryConsumer sentryConsumer;
        Objects.requireNonNull(file, "File is required.");
        try {
            if (!isRelevantFileName(file.getName())) {
                this.logger.log(SentryLevel.DEBUG, "File '%s' should be ignored.", file.getAbsolutePath());
                return;
            }
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                try {
                    SentryEnvelope sentryEnvelope = this.envelopeReader.read(bufferedInputStream);
                    if (sentryEnvelope == null) {
                        this.logger.log(SentryLevel.ERROR, "Stream from path %s resulted in a null envelope.", file.getAbsolutePath());
                    } else {
                        processEnvelope(sentryEnvelope, hint);
                        this.logger.log(SentryLevel.DEBUG, "File '%s' is done.", file.getAbsolutePath());
                    }
                    bufferedInputStream.close();
                    iLogger = this.logger;
                    sentryConsumer = new HintUtils.SentryConsumer() { // from class: io.sentry.OutboxSender$$ExternalSyntheticLambda1
                        @Override // io.sentry.util.HintUtils.SentryConsumer
                        public final void accept(Object obj) {
                            this.f$0.lambda$processFile$0(file, (Retryable) obj);
                        }
                    };
                    HintUtils.runIfHasTypeLogIfNot(hint, Retryable.class, iLogger, sentryConsumer);
                } catch (Throwable th) {
                    try {
                        bufferedInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (IOException e) {
                this.logger.log(SentryLevel.ERROR, "Error processing envelope.", e);
                iLogger = this.logger;
                sentryConsumer = new HintUtils.SentryConsumer() { // from class: io.sentry.OutboxSender$$ExternalSyntheticLambda1
                    @Override // io.sentry.util.HintUtils.SentryConsumer
                    public final void accept(Object obj) {
                        this.f$0.lambda$processFile$0(file, (Retryable) obj);
                    }
                };
            }
        } catch (Throwable th3) {
            HintUtils.runIfHasTypeLogIfNot(hint, Retryable.class, this.logger, new HintUtils.SentryConsumer() { // from class: io.sentry.OutboxSender$$ExternalSyntheticLambda1
                @Override // io.sentry.util.HintUtils.SentryConsumer
                public final void accept(Object obj) {
                    this.f$0.lambda$processFile$0(file, (Retryable) obj);
                }
            });
            throw th3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processFile$0(File file, Retryable retryable) {
        if (retryable.isRetry()) {
            return;
        }
        try {
            if (file.delete()) {
                return;
            }
            this.logger.log(SentryLevel.ERROR, "Failed to delete: %s", file.getAbsolutePath());
        } catch (RuntimeException e) {
            this.logger.log(SentryLevel.ERROR, e, "Failed to delete: %s", file.getAbsolutePath());
        }
    }

    @Override // io.sentry.DirectoryProcessor
    protected boolean isRelevantFileName(@Nullable String str) {
        return (str == null || str.startsWith(EnvelopeCache.PREFIX_CURRENT_SESSION_FILE) || str.startsWith(EnvelopeCache.PREFIX_PREVIOUS_SESSION_FILE) || str.startsWith(EnvelopeCache.STARTUP_CRASH_MARKER_FILE)) ? false : true;
    }

    @Override // io.sentry.IEnvelopeSender
    public void processEnvelopeFile(@NotNull String str, @NotNull Hint hint) {
        Objects.requireNonNull(str, "Path is required.");
        processFile(new File(str), hint);
    }

    private void processEnvelope(@NotNull SentryEnvelope sentryEnvelope, @NotNull Hint hint) throws IOException {
        Object sentrySdkHint;
        this.logger.log(SentryLevel.DEBUG, "Processing Envelope with %d item(s)", Integer.valueOf(CollectionUtils.size(sentryEnvelope.getItems())));
        int i = 0;
        for (SentryEnvelopeItem sentryEnvelopeItem : sentryEnvelope.getItems()) {
            i++;
            if (sentryEnvelopeItem.getHeader() == null) {
                this.logger.log(SentryLevel.ERROR, "Item %d has no header", Integer.valueOf(i));
            } else if (SentryItemType.Event.equals(sentryEnvelopeItem.getHeader().getType())) {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(sentryEnvelopeItem.getData()), UTF_8));
                    try {
                        SentryEvent sentryEvent = (SentryEvent) this.serializer.deserialize(bufferedReader, SentryEvent.class);
                        if (sentryEvent == null) {
                            logEnvelopeItemNull(sentryEnvelopeItem, i);
                        } else {
                            if (sentryEvent.getSdk() != null) {
                                HintUtils.setIsFromHybridSdk(hint, sentryEvent.getSdk().getName());
                            }
                            if (sentryEnvelope.getHeader().getEventId() != null && !sentryEnvelope.getHeader().getEventId().equals(sentryEvent.getEventId())) {
                                logUnexpectedEventId(sentryEnvelope, sentryEvent.getEventId(), i);
                                bufferedReader.close();
                            } else {
                                this.scopes.captureEvent(sentryEvent, hint);
                                logItemCaptured(i);
                                if (!waitFlush(hint)) {
                                    logTimeout(sentryEvent.getEventId());
                                    bufferedReader.close();
                                    return;
                                }
                            }
                        }
                        bufferedReader.close();
                    } catch (Throwable th) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    this.logger.log(SentryLevel.ERROR, "Item failed to process.", th3);
                }
                sentrySdkHint = HintUtils.getSentrySdkHint(hint);
                if (!(sentrySdkHint instanceof SubmissionResult) && !((SubmissionResult) sentrySdkHint).isSuccess()) {
                    this.logger.log(SentryLevel.WARNING, "Envelope had a failed capture at item %d. No more items will be sent.", Integer.valueOf(i));
                    return;
                }
                HintUtils.runIfHasType(hint, Resettable.class, new HintUtils.SentryConsumer() { // from class: io.sentry.OutboxSender$$ExternalSyntheticLambda0
                    private static short[] ICustomTabsService;
                    private static final byte[] $$a = {106, -29, -101, -119};
                    private static final int $$b = 19;
                    private static int $10 = 0;
                    private static int $11 = 1;
                    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
                    private static int artificialFrame = 1;
                    private static int onTransact = 1462758790;
                    private static int mayLaunchUrl = -81862468;
                    private static int getInterfaceDescriptor = -1645978976;
                    private static byte[] ICustomTabsCallbackStubProxy = {100, 50, 36, 78, 79, 56, 72, 62, 107, 85, 53, 34, 0, 83, 39, 53, 34, -32, 115, Ascii.SI, 57, 38, 89, 122, -8, 72, 50, 62, 32, 91, 39, 59, -120, -1, 94, Ascii.DC2, 88, 62, 107, -36, Ascii.CR, -17, Ascii.SUB, -47, 44, Ascii.VT, -106, Ascii.SUB, 7, -17, Ascii.SUB, -47, Ascii.FF, 43, -58, -43, -42, -45, 2, -22, 3, 92, -124, -16, -15, -85, -122, Ascii.SO, -98, -12, 2, -13, -96, -11, -122, 92, -1, 46, -37, Ascii.SUB, 44, -28, Ascii.DC4, -2, -32, -9, 66, -3, 44, 108, -80, -95, -60, -123, -81, -89, -105, -79, -69, -56, -37, 120, -84, -5, 99, -89, -80, -88, -89, -82, -67, -44, 115, -94, -93, -84, -65, -105, -68, 101, 124, 112, -40, 102, 119, 120, -42, -58, 96, -37, -33, 112, -38, -62, 119, -118, -105, 98, Ascii.US, 119, -118, 119, -126, 2, 114, -120, -52, -38, 103, -37, -57, 50, -54, -24, 98, -52, 110, -64, -34, -78, -96, -64, -76, -35, -91, -106, -14, -34, 113, Ascii.EM, -75, -54, -62, -75, -36, -49, -122, 9, -40, -39, -34, -51, -59, -50, 107, -75, 83, -55, -56, 95, -49, 89, -84, -94, -62, 69, 103, 110, -77, SignedBytes.MAX_POWER_OF_TWO, 69, -54, 87, -84, 97, -79, SignedBytes.MAX_POWER_OF_TWO};
                    private static long onPostMessage = 4960719954659065335L;

                    /* JADX WARN: Code duplicated, block: B:10:0x0022  */
                    /* JADX WARN: Code duplicated, block: B:8:0x001c  */
                    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0022 -> B:11:0x0026). Please report as a decompilation issue!!! */
                    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0022
                        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                        */
                    private static java.lang.String $$c(int r5, int r6, int r7) {
                        /*
                            byte[] r0 = io.sentry.OutboxSender$$ExternalSyntheticLambda0.$$a
                            int r7 = 117 - r7
                            int r5 = r5 * 4
                            int r5 = r5 + 4
                            int r6 = r6 * 2
                            int r1 = 1 - r6
                            byte[] r1 = new byte[r1]
                            r2 = 0
                            int r6 = 0 - r6
                            if (r0 != 0) goto L16
                            r4 = r6
                            r3 = r2
                            goto L26
                        L16:
                            r3 = r2
                        L17:
                            byte r4 = (byte) r7
                            r1[r3] = r4
                            if (r3 != r6) goto L22
                            java.lang.String r5 = new java.lang.String
                            r5.<init>(r1, r2)
                            return r5
                        L22:
                            int r3 = r3 + 1
                            r4 = r0[r5]
                        L26:
                            int r7 = r7 + r4
                            int r5 = r5 + 1
                            goto L17
                        */
                        throw new UnsupportedOperationException("Method not decompiled: io.sentry.OutboxSender$$ExternalSyntheticLambda0.$$c(int, int, int):java.lang.String");
                    }

                    @Override // io.sentry.util.HintUtils.SentryConsumer
                    public final void accept(Object obj) {
                        ((Resettable) obj).reset();
                    }

                    private static void b(int i2, char[] cArr, Object[] objArr) throws Throwable {
                        int i3 = 2 % 2;
                        onRelationshipValidationResult onrelationshipvalidationresult = new onRelationshipValidationResult();
                        char[] cArrAccessartificialFrame = onRelationshipValidationResult.accessartificialFrame(onPostMessage ^ 2573525503365829440L, cArr, i2);
                        onrelationshipvalidationresult.e = 4;
                        while (onrelationshipvalidationresult.e < cArrAccessartificialFrame.length) {
                            int i4 = $11 + 117;
                            $10 = i4 % 128;
                            int i5 = i4 % 2;
                            onrelationshipvalidationresult.d = onrelationshipvalidationresult.e - 4;
                            int i6 = onrelationshipvalidationresult.e;
                            try {
                                Object[] objArr2 = {Long.valueOf(cArrAccessartificialFrame[onrelationshipvalidationresult.e] ^ cArrAccessartificialFrame[onrelationshipvalidationresult.e % 4]), Long.valueOf(onrelationshipvalidationresult.d), Long.valueOf(onPostMessage)};
                                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(797310229);
                                if (objAccessartificialFrame == null) {
                                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getScrollDefaultDelay() >> 16) + 27, (char) (KeyEvent.getDeadChar(0, 0) + 30690), TextUtils.lastIndexOf("", '0', 0) + 189, -1327449315, false, "k", new Class[]{Long.TYPE, Long.TYPE, Long.TYPE});
                                }
                                cArrAccessartificialFrame[i6] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                                Object[] objArr3 = {onrelationshipvalidationresult, onrelationshipvalidationresult};
                                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(321542193);
                                if (objAccessartificialFrame2 == null) {
                                    byte b = (byte) 0;
                                    byte b2 = b;
                                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(33 - (KeyEvent.getMaxKeyCode() >> 16), (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)), (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 1482, -1940971975, false, $$c(b, b2, (byte) (b2 | 6)), new Class[]{Object.class, Object.class});
                                }
                                ((Method) objAccessartificialFrame2).invoke(null, objArr3);
                                int i7 = $10 + 19;
                                $11 = i7 % 128;
                                int i8 = i7 % 2;
                            } catch (Throwable th4) {
                                Throwable cause = th4.getCause();
                                if (cause == null) {
                                    throw th4;
                                }
                                throw cause;
                            }
                        }
                        objArr[0] = new String(cArrAccessartificialFrame, 4, cArrAccessartificialFrame.length - 4);
                    }

                    /* JADX WARN: Code duplicated, block: B:50:0x023e  */
                    private static void a(int i2, byte b, int i3, short s, int i4, Object[] objArr) throws Throwable {
                        long j;
                        boolean z;
                        int i5 = 2 % 2;
                        ICustomTabsCallback iCustomTabsCallback = new ICustomTabsCallback();
                        StringBuilder sb = new StringBuilder();
                        try {
                            Object[] objArr2 = {Integer.valueOf(i3), Integer.valueOf(mayLaunchUrl)};
                            Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1991297565);
                            if (objAccessartificialFrame == null) {
                                byte b2 = (byte) 0;
                                byte b3 = b2;
                                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getWindowTouchSlop() >> 8) + 40, (char) (36241 - Gravity.getAbsoluteGravity(0, 0)), (ViewConfiguration.getEdgeSlop() >> 16) + 2342, 371880939, false, $$c(b2, b3, (byte) (b3 + 5)), new Class[]{Integer.TYPE, Integer.TYPE});
                            }
                            int iIntValue = ((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
                            int i6 = iIntValue == -1 ? 1 : 0;
                            long j2 = 0;
                            if (i6 == 0) {
                                j = -4629754035390455669L;
                            } else {
                                byte[] bArr = ICustomTabsCallbackStubProxy;
                                if (bArr != null) {
                                    int i7 = $10 + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
                                    $11 = i7 % 128;
                                    int i8 = i7 % 2;
                                    int length = bArr.length;
                                    byte[] bArr2 = new byte[length];
                                    int i9 = 0;
                                    while (i9 < length) {
                                        Object[] objArr3 = {Integer.valueOf(bArr[i9])};
                                        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1557994855);
                                        if (objAccessartificialFrame2 == null) {
                                            int iCombineMeasuredStates = View.combineMeasuredStates(0, 0) + 44;
                                            char mirror = (char) ('0' - AndroidCharacter.getMirror('0'));
                                            int i10 = (SystemClock.uptimeMillis() > j2 ? 1 : (SystemClock.uptimeMillis() == j2 ? 0 : -1)) + 1214;
                                            byte b4 = (byte) 0;
                                            byte b5 = b4;
                                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iCombineMeasuredStates, mirror, i10, 1011328145, false, $$c(b4, b5, b5), new Class[]{Integer.TYPE});
                                        }
                                        bArr2[i9] = ((Byte) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).byteValue();
                                        i9++;
                                        j2 = 0;
                                    }
                                    bArr = bArr2;
                                }
                                if (bArr != null) {
                                    byte[] bArr3 = ICustomTabsCallbackStubProxy;
                                    Object[] objArr4 = {Integer.valueOf(i4), Integer.valueOf(onTransact)};
                                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1991297565);
                                    if (objAccessartificialFrame3 == null) {
                                        byte b6 = (byte) 0;
                                        byte b7 = b6;
                                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(ImageFormat.getBitsPerPixel(0) + 41, (char) (Color.argb(0, 0, 0, 0) + 36241), 2342 - TextUtils.getOffsetAfter("", 0), 371880939, false, $$c(b6, b7, (byte) (b7 + 5)), new Class[]{Integer.TYPE, Integer.TYPE});
                                    }
                                    iIntValue = (byte) (((byte) (((long) bArr3[((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue()]) ^ (-4629754035390455669L))) + ((int) (((long) mayLaunchUrl) ^ (-4629754035390455669L))));
                                    int i11 = $10 + 83;
                                    $11 = i11 % 128;
                                    int i12 = i11 % 2;
                                    j = -4629754035390455669L;
                                } else {
                                    j = -4629754035390455669L;
                                    iIntValue = (short) (((short) (((long) ICustomTabsService[i4 + ((int) (((long) onTransact) ^ (-4629754035390455669L)))]) ^ (-4629754035390455669L))) + ((int) (((long) mayLaunchUrl) ^ (-4629754035390455669L))));
                                }
                            }
                            if (iIntValue > 0) {
                                iCustomTabsCallback.c = ((i4 + iIntValue) - 2) + ((int) (((long) onTransact) ^ j)) + i6;
                                try {
                                    Object[] objArr5 = {iCustomTabsCallback, Integer.valueOf(i2), Integer.valueOf(getInterfaceDescriptor), sb};
                                    Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(216546027);
                                    if (objAccessartificialFrame4 == null) {
                                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 40, (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), 4066 - (ViewConfiguration.getJumpTapTimeout() >> 16), -1819443997, false, "x", new Class[]{Object.class, Integer.TYPE, Integer.TYPE, Object.class});
                                    }
                                    ((StringBuilder) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).append(iCustomTabsCallback.createConnectionCallback);
                                    iCustomTabsCallback.createBrowser = iCustomTabsCallback.createConnectionCallback;
                                    byte[] bArr4 = ICustomTabsCallbackStubProxy;
                                    if (bArr4 != null) {
                                        int i13 = $10 + 15;
                                        $11 = i13 % 128;
                                        int i14 = i13 % 2;
                                        int length2 = bArr4.length;
                                        byte[] bArr5 = new byte[length2];
                                        for (int i15 = 0; i15 < length2; i15++) {
                                            bArr5[i15] = (byte) (((long) bArr4[i15]) ^ (-4629754035390455669L));
                                        }
                                        bArr4 = bArr5;
                                    }
                                    if (bArr4 != null) {
                                        int i16 = $10 + 13;
                                        $11 = i16 % 128;
                                        if (i16 % 2 == 0) {
                                            z = false;
                                        } else {
                                            z = true;
                                        }
                                    } else {
                                        z = false;
                                    }
                                    iCustomTabsCallback.a = 1;
                                    int i17 = $10 + 101;
                                    $11 = i17 % 128;
                                    int i18 = i17 % 2;
                                    while (iCustomTabsCallback.a < iIntValue) {
                                        if (z) {
                                            byte[] bArr6 = ICustomTabsCallbackStubProxy;
                                            int i19 = iCustomTabsCallback.c;
                                            iCustomTabsCallback.c = i19 - 1;
                                            iCustomTabsCallback.createConnectionCallback = (char) (iCustomTabsCallback.createBrowser + (((byte) (((byte) (((long) bArr6[i19]) ^ (-4629754035390455669L))) + s)) ^ b));
                                        } else {
                                            short[] sArr = ICustomTabsService;
                                            int i20 = iCustomTabsCallback.c;
                                            iCustomTabsCallback.c = i20 - 1;
                                            iCustomTabsCallback.createConnectionCallback = (char) (iCustomTabsCallback.createBrowser + (((short) (((short) (((long) sArr[i20]) ^ (-4629754035390455669L))) + s)) ^ b));
                                        }
                                        sb.append(iCustomTabsCallback.createConnectionCallback);
                                        iCustomTabsCallback.createBrowser = iCustomTabsCallback.createConnectionCallback;
                                        iCustomTabsCallback.a++;
                                    }
                                } catch (Throwable th4) {
                                    Throwable cause = th4.getCause();
                                    if (cause == null) {
                                        throw th4;
                                    }
                                    throw cause;
                                }
                            }
                            objArr[0] = sb.toString();
                        } catch (Throwable th5) {
                            Throwable cause2 = th5.getCause();
                            if (cause2 == null) {
                                throw th5;
                            }
                            throw cause2;
                        }
                    }

                    public static Object[] accessartificialFrame(Context context, int i2, int i3) {
                        int i4;
                        String str;
                        int iICustomTabsCallbackStubProxy;
                        int i5;
                        Method method;
                        int i6;
                        int iIndexOf;
                        int i7;
                        int i8;
                        int i9;
                        int i10;
                        int i11;
                        int i12;
                        int i13;
                        Object[] objArr;
                        int i14;
                        char c;
                        int i15;
                        int i16;
                        String str2 = "";
                        int i17 = 2 % 2;
                        int i18 = 13;
                        int i19 = getARTIFICIAL_FRAME_PACKAGE_NAME + 13;
                        int i20 = i19 % 128;
                        artificialFrame = i20;
                        int i21 = i19 % 2;
                        if (context == null) {
                            Object[] objArr2 = new Object[4];
                            int[] iArr = new int[1];
                            objArr2[0] = iArr;
                            int[] iArr2 = new int[1];
                            objArr2[1] = iArr2;
                            objArr2[2] = new int[1];
                            int i22 = (i20 ^ 69) + ((i20 & 69) << 1);
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i22 % 128;
                            if (i22 % 2 != 0) {
                                iArr2[1] = i2;
                                iArr[1] = i2;
                            } else {
                                iArr[0] = i2;
                                iArr2[0] = i2;
                            }
                            objArr2[3] = null;
                            int i23 = ~((int) Process.getStartElapsedRealtime());
                            int i24 = (((-469710298) + (((~(970185950 | i23)) | 8437824) * (-828))) + ((i23 | 970185950) * (-828))) - 155083076;
                            int i25 = i24 * (-167);
                            int i26 = i3 * (-167);
                            int i27 = ((i25 | i26) << 1) - (i25 ^ i26);
                            int i28 = ~i24;
                            int i29 = ~i3;
                            int i30 = ~((i28 & i29) | (i28 ^ i29));
                            int i31 = ~i3;
                            int i32 = ~(i31 | i2);
                            int i33 = i27 + (((i30 & i32) | (i30 ^ i32)) * 336);
                            int i34 = ~(i3 | i24);
                            int i35 = artificialFrame + 47;
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i35 % 128;
                            int i36 = i35 % 2;
                            int i37 = ~((i24 ^ i2) | (i24 & i2));
                            if (i36 != 0) {
                                int i38 = i33 / ((-168) / (i34 | i37));
                                int i39 = ~((~i2) | i24);
                                int i40 = -(-((i39 & i31) | (i31 ^ i39)));
                                int i41 = -((i40 ^ 168) + ((i40 & 168) << 1));
                                i16 = ((i38 | i41) << 1) - (i41 ^ i38);
                                i18 = 41;
                            } else {
                                int i42 = ~i2;
                                int i43 = ~((i42 & i24) | (i42 ^ i24));
                                i16 = i33 + (((i34 & i37) | (i34 ^ i37)) * (-168)) + (((i43 & i31) | (i31 ^ i43)) * 168);
                            }
                            int i44 = i16 << i18;
                            int i45 = (i44 | i16) & (~(i16 & i44));
                            int i46 = i45 >>> 17;
                            int i47 = ((~i45) & i46) | ((~i46) & i45);
                            ((int[]) objArr2[2])[0] = i47 ^ (i47 << 5);
                            return objArr2;
                        }
                        try {
                            int iResolveOpacity = Drawable.resolveOpacity(0, 0);
                            int i48 = iResolveOpacity * 659;
                            int i49 = (i48 & 1232517201) + (i48 | 1232517201);
                            int i50 = ~iResolveOpacity;
                            int i51 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                            int i52 = (i51 & 91) + (i51 | 91);
                            artificialFrame = i52 % 128;
                            int i53 = i52 % 2;
                            int i54 = ~((i50 & (-1727707585)) | (i50 ^ (-1727707585)));
                            int i55 = ~((1727707584 & iResolveOpacity) | (1727707584 ^ iResolveOpacity));
                            int i56 = (i54 & i55) | (i54 ^ i55);
                            int i57 = ~(iResolveOpacity | i2);
                            int i58 = (i49 - (~(-(-((-658) * ((i56 & i57) | (i56 ^ i57))))))) - 1;
                            int i59 = ~((1727707584 ^ iResolveOpacity) | (1727707584 & iResolveOpacity));
                            int i60 = i58 + (i59 * 658);
                            int i61 = ~((iResolveOpacity & i2) | (iResolveOpacity ^ i2));
                            int i62 = -(-(((i61 & i59) | (i59 ^ i61)) * 658));
                            int i63 = (i60 ^ i62) + ((i62 & i60) << 1);
                            int i64 = -(-(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)));
                            byte b = (byte) ((i64 ^ 9) + ((i64 & 9) << 1));
                            int i65 = -AndroidCharacter.getMirror('0');
                            int i66 = i65 * (-494);
                            int i67 = (i66 & 3952) + (i66 | 3952) + ((~((i65 ^ (-8)) | (i65 & (-8)))) * (-495));
                            int i68 = ~i2;
                            int i69 = i67 + (((i65 ^ i68) | (i65 & i68)) * 495);
                            int i70 = ~i65;
                            int i71 = artificialFrame + 75;
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i71 % 128;
                            int i72 = i71 % 2;
                            int i73 = ~((i70 ^ 7) | (i70 & 7));
                            int i74 = ~i2;
                            int i75 = ~((i65 & i74) | (i74 ^ i65));
                            int i76 = 495 * ((i75 & i73) | (i73 ^ i75));
                            int i77 = ((i69 | i76) << 1) - (i76 ^ i69);
                            int i78 = -(-TextUtils.getOffsetBefore("", 0));
                            int i79 = -(-(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)));
                            int i80 = (i79 ^ 1406071540) + ((i79 & 1406071540) << 1);
                            Object[] objArr3 = new Object[1];
                            a(i63, b, i77, (short) ((i78 ^ 74) + ((i78 & 74) << 1)), i80, objArr3);
                            Object[] objArr4 = (Object[]) Array.newInstance(Class.forName((String) objArr3[0]), 2);
                            int i81 = -(CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                            int i82 = i81 * 319;
                            int i83 = (i82 ^ (-317)) + ((i82 & (-317)) << 1);
                            int i84 = ~i81;
                            int i85 = ~((i84 & i2) | (i84 ^ i2));
                            int i86 = -(-(((i85 & (-2)) | ((-2) ^ i85)) * (-318)));
                            int i87 = (i83 & i86) + (i86 | i83);
                            int i88 = (i74 ^ i81) | (i74 & i81);
                            int i89 = (~(((-2) ^ i2) | ((-2) & i2))) | (~((i88 ^ 1) | (i88 & 1)));
                            int i90 = ~(((-1062704294) ^ i74) | ((-1062704294) & i74));
                            int i91 = (i90 ^ 256119812) | (i90 & 256119812);
                            int i92 = ~((i68 ^ (-264518741)) | (i68 & (-264518741)));
                            int i93 = (i91 ^ i92) | (i92 & i91);
                            int i94 = ~((1071103221 ^ i2) | (1071103221 & i2));
                            int i95 = (((-2119239557) - (~(((i93 ^ i94) | (i93 & i94)) * 590))) - (~((((~(((-1062704294) ^ i68) | ((-1062704294) & i68))) | 256119812) | (~((i74 ^ (-264518741)) | (i74 & (-264518741))))) * (-1180)))) - 1;
                            int i96 = ~(264518740 | i74);
                            int i97 = ~(1062704293 | i74);
                            int i98 = -(-(((i96 ^ i97) | (i96 & i97)) * 590));
                            int i99 = ((i95 | i98) << 1) - (i95 ^ i98);
                            int i100 = ~(694503791 | i2);
                            int i101 = ~((i74 ^ 710137315) | (i74 & 710137315));
                            int i102 = (i100 ^ i101) | (i100 & i101);
                            int i103 = ~(i74 | (-694503792));
                            int i104 = -(-(((i102 ^ i103) | (i102 & i103)) * (-516)));
                            int i105 = (1070295335 ^ i104) + ((i104 & 1070295335) << 1);
                            int i106 = ~(((-34772097) & i2) | ((-34772097) ^ i2));
                            int i107 = (-710137316) | i68;
                            int i108 = ~((i107 ^ (-694503792)) | (i107 & (-694503792)));
                            int i109 = ((i106 ^ i108) | (i106 & i108)) * 516;
                            int i110 = (i105 & i109) + (i105 | i109);
                            int i111 = ~((i68 ^ (-694503792)) | ((-694503792) & i68));
                            if (i99 <= (i110 - (~(-(-(((675365219 ^ i111) | (i111 & 675365219)) * 516))))) - 1) {
                                int i112 = i87 << (TypedValues.AttributesType.TYPE_PIVOT_TARGET / i89);
                                int i113 = ((-2) ^ i74) | ((-2) & i74);
                                int i114 = ~((i113 & i81) | (i113 ^ i81));
                                int i115 = ~(i81 | 1 | i2);
                                int i116 = -(TypedValues.AttributesType.TYPE_PIVOT_TARGET >>> ((i115 & i114) | (i114 ^ i115)));
                                Object[] objArr5 = new Object[1];
                                b((i112 ^ i116) + ((i116 & i112) << 1), new char[]{44271, 34595, 2436, 44204, 1396, 59866, 54487, 18704, 5725, 44756, 37308, 538, 55614, 25384, 23170, 50413, 39966, 6154, 2035, 31146, 18355, 56651, 49511, 12960, 2765, 37444, 35404, 63338, 52654, 18584, 14142, 43130, 45270, 3533, 61605}, objArr5);
                                str = (String) objArr5[0];
                                i4 = 0;
                            } else {
                                int i117 = (i87 - (~(i89 * TypedValues.AttributesType.TYPE_PIVOT_TARGET))) - 1;
                                int i118 = ((-2) ^ i74) | ((-2) & i74);
                                int i119 = ~((i118 & i81) | (i118 ^ i81));
                                int i120 = (i81 & 1) | (i81 ^ 1);
                                int i121 = ~((i120 & i2) | (i120 ^ i2));
                                int i122 = -(-(((i121 & i119) | (i119 ^ i121)) * TypedValues.AttributesType.TYPE_PIVOT_TARGET));
                                Object[] objArr6 = new Object[1];
                                b(((i117 | i122) << 1) - (i122 ^ i117), new char[]{44271, 34595, 2436, 44204, 1396, 59866, 54487, 18704, 5725, 44756, 37308, 538, 55614, 25384, 23170, 50413, 39966, 6154, 2035, 31146, 18355, 56651, 49511, 12960, 2765, 37444, 35404, 63338, 52654, 18584, 14142, 43130, 45270, 3533, 61605}, objArr6);
                                i4 = 0;
                                str = (String) objArr6[0];
                            }
                            try {
                                int packedPositionType = (-1727707585) - ExpandableListView.getPackedPositionType(0L);
                                byte bNormalizeMetaState = (byte) (KeyEvent.normalizeMetaState(i4) + 8);
                                int defaultSize = View.getDefaultSize(i4, i4);
                                int iICustomTabsCallbackStubProxy2 = com.google.android.gms.common.internal.Objects.ICustomTabsCallbackStubProxy();
                                int i123 = ~defaultSize;
                                int i124 = ~iICustomTabsCallbackStubProxy2;
                                int i125 = ~((i123 ^ i124) | (i123 & i124));
                                int i126 = ~((i123 ^ (-56)) | (i123 & (-56)));
                                int i127 = (i125 ^ i126) | (i125 & i126);
                                int i128 = ~(i124 | (-56));
                                int i129 = (((defaultSize * 398) + 22176) - (~(-(-(((i127 & i128) | (i127 ^ i128)) * (-397)))))) - 1;
                                int i130 = ~defaultSize;
                                int i131 = -(-((~((i130 ^ (-56)) | (i130 & (-56)))) * (-397)));
                                int i132 = (i129 ^ i131) + ((i129 & i131) << 1);
                                int i133 = ~((i130 ^ (-56)) | (i130 & (-56)));
                                int i134 = (iICustomTabsCallbackStubProxy2 & i133) | (iICustomTabsCallbackStubProxy2 ^ i133);
                                int i135 = ~((defaultSize & 55) | (55 ^ defaultSize));
                                int i136 = ((i134 & i135) | (i134 ^ i135)) * 397;
                                int i137 = (i132 ^ i136) + ((i136 & i132) << 1);
                                int maximumDrawingCacheSize = ViewConfiguration.getMaximumDrawingCacheSize() >> 24;
                                int iICustomTabsCallbackStubProxy3 = com.google.android.gms.common.internal.Objects.ICustomTabsCallbackStubProxy();
                                int i138 = ~iICustomTabsCallbackStubProxy3;
                                int i139 = (i138 & maximumDrawingCacheSize) | (i138 ^ maximumDrawingCacheSize);
                                int i140 = ((((maximumDrawingCacheSize * (-115)) - 8510) + ((~((i139 & 74) | (i139 ^ 74))) * (-116))) - (~((maximumDrawingCacheSize | iICustomTabsCallbackStubProxy3) * 116))) - 1;
                                int i141 = ~((~maximumDrawingCacheSize) | (-75));
                                int i142 = ~(iICustomTabsCallbackStubProxy3 | (-75));
                                short s = (short) (i140 + (((i141 & i142) | (i141 ^ i142)) * 116));
                                int i143 = -View.getDefaultSize(0, 0);
                                int iICustomTabsCallbackStubProxy4 = com.google.android.gms.common.internal.Objects.ICustomTabsCallbackStubProxy();
                                int i144 = i143 * 860;
                                int i145 = (((i144 & 476429714) + (i144 | 476429714)) - (~(((i143 ^ iICustomTabsCallbackStubProxy4) | (i143 & iICustomTabsCallbackStubProxy4)) * (-859)))) - 1;
                                int i146 = ~iICustomTabsCallbackStubProxy4;
                                int i147 = ~(i146 | i143);
                                int i148 = ~i143;
                                int i149 = (i148 ^ (-1406071540)) | (i148 & (-1406071540));
                                int i150 = ~((i149 ^ iICustomTabsCallbackStubProxy4) | (i149 & iICustomTabsCallbackStubProxy4));
                                int i151 = ((i150 & i147) | (i147 ^ i150)) * 859;
                                int i152 = ((i145 | i151) << 1) - (i145 ^ i151);
                                int i153 = -(-(((~(((-1406071540) & i143) | ((-1406071540) ^ i143))) | (~(((-1406071540) ^ i146) | ((-1406071540) & i146)))) * 859));
                                int i154 = (i152 ^ i153) + ((i153 & i152) << 1);
                                Object[] objArr7 = new Object[1];
                                a(packedPositionType, bNormalizeMetaState, i137, s, i154, objArr7);
                                objArr4[0] = Class.forName((String) objArr7[0]).getDeclaredConstructor(String.class).newInstance(str);
                                Object[] objArr8 = new Object[1];
                                b((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), new char[]{63801, 41260, 60175, 63866, 49841, 53158, 13876, 36551, 17353, 35056, 29560, 50673, 36079, 17703, 47195, 771, 51652, 15875, 58657, 48715, 4615, 64310, 9104, 62794, 24337, 46173, 26842, 12457, 39029, 28371, 54749, 28569, 58719, 11234, 4634}, objArr8);
                                String str3 = (String) objArr8[0];
                                int i155 = artificialFrame;
                                int i156 = (i155 & 53) + (i155 | 53);
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i156 % 128;
                                int i157 = i156 % 2;
                                int i158 = i155 + 3;
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i158 % 128;
                                int i159 = i158 % 2;
                                try {
                                    Object[] objArr9 = {str3};
                                    int i160 = (-1727707587) - (~(-TextUtils.lastIndexOf("", '0', 0, 0)));
                                    int jumpTapTimeout = ViewConfiguration.getJumpTapTimeout() >> 16;
                                    int iResolveSizeAndState = View.resolveSizeAndState(0, 0, 0);
                                    int iICustomTabsCallbackStubProxy5 = com.google.android.gms.common.internal.Objects.ICustomTabsCallbackStubProxy();
                                    int i161 = iResolveSizeAndState * (-244);
                                    int i162 = (i161 & (-13776)) + (i161 | (-13776));
                                    int i163 = ~iICustomTabsCallbackStubProxy5;
                                    int i164 = ~((i163 & 55) | (55 ^ i163));
                                    int i165 = ~(55 | iResolveSizeAndState);
                                    int i166 = (i162 - (~(((i164 ^ i165) | (i164 & i165)) * (-245)))) - 1;
                                    int i167 = (~(55 | iICustomTabsCallbackStubProxy5)) * (-245);
                                    int i168 = (i166 ^ i167) + ((i167 & i166) << 1);
                                    int i169 = ~((iICustomTabsCallbackStubProxy5 & 55) | (55 ^ iICustomTabsCallbackStubProxy5));
                                    int i170 = ((i169 & iResolveSizeAndState) | (iResolveSizeAndState ^ i169)) * 245;
                                    Object[] objArr10 = new Object[1];
                                    a(i160, (byte) ((jumpTapTimeout ^ 8) + ((jumpTapTimeout & 8) << 1)), (i168 ^ i170) + ((i170 & i168) << 1), (short) (73 - (~(-Gravity.getAbsoluteGravity(0, 0)))), (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 1406071539, objArr10);
                                    objArr4[1] = Class.forName((String) objArr10[0]).getDeclaredConstructor(String.class).newInstance(objArr9);
                                    try {
                                        int i171 = -(-TextUtils.indexOf("", "", 0, 0));
                                        int i172 = ((i171 | (-1727707594)) << 1) - (i171 ^ (-1727707594));
                                        int i173 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
                                        int iLastIndexOf = (-57) - TextUtils.lastIndexOf("", '0');
                                        int i174 = -View.combineMeasuredStates(0, 0);
                                        int i175 = -ExpandableListView.getPackedPositionType(0L);
                                        int i176 = (i175 & 1406071577) + (i175 | 1406071577);
                                        Object[] objArr11 = new Object[1];
                                        a(i172, (byte) ((i173 ^ 27) + ((i173 & 27) << 1)), iLastIndexOf, (short) ((i174 & (-119)) + (i174 | (-119))), i176, objArr11);
                                        Class<?> cls = Class.forName((String) objArr11[0]);
                                        Object[] objArr12 = new Object[1];
                                        b((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 1, new char[]{11837, 12977, 4647, 11866, 53400, 23651, 53053, 40173, 38016, 6977, 35334, 55288, 23522, 54971, 16716, 4388, 7879, 44443, 7234, 44100, 50495}, objArr12);
                                        Object objInvoke = cls.getMethod((String) objArr12[0], null).invoke(context, null);
                                        try {
                                            int i177 = (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1727707595;
                                            int longPressTimeout = ViewConfiguration.getLongPressTimeout() >> 16;
                                            int i178 = -(Process.myPid() >> 22);
                                            int iICustomTabsCallbackStubProxy6 = com.google.android.gms.common.internal.Objects.ICustomTabsCallbackStubProxy();
                                            int i179 = i178 * (-1335);
                                            int i180 = ((i179 | 37352) << 1) - (i179 ^ 37352);
                                            int i181 = (i178 ^ iICustomTabsCallbackStubProxy6) | (i178 & iICustomTabsCallbackStubProxy6);
                                            int i182 = ~i181;
                                            int i183 = ((55 ^ i182) | (i182 & 55)) * (-668);
                                            int i184 = (i180 ^ i183) + ((i183 & i180) << 1);
                                            int i185 = ~((iICustomTabsCallbackStubProxy6 & 55) | (55 ^ iICustomTabsCallbackStubProxy6));
                                            int i186 = -(-(((i178 & i185) | (i178 ^ i185)) * 1336));
                                            int i187 = (i184 ^ i186) + ((i184 & i186) << 1);
                                            int i188 = ((i181 ^ 55) | (i181 & 55)) * 668;
                                            int i189 = (i187 & i188) + (i188 | i187);
                                            int i190 = -(SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
                                            Object[] objArr13 = new Object[1];
                                            a(i177, (byte) ((longPressTimeout ^ 28) + ((longPressTimeout & 28) << 1)), i189, (short) (((i190 | (-118)) << 1) - (i190 ^ (-118))), 1406071576 - (~(-View.resolveSizeAndState(0, 0, 0))), objArr13);
                                            Class<?> cls2 = Class.forName((String) objArr13[0]);
                                            int iIndexOf2 = (-1727707589) - TextUtils.indexOf((CharSequence) "", '0');
                                            int i191 = (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                                            int offsetAfter = (-56) - TextUtils.getOffsetAfter("", 0);
                                            short fadingEdgeLength = (short) ((-75) - (ViewConfiguration.getFadingEdgeLength() >> 16));
                                            int threadPriority = Process.getThreadPriority(0);
                                            int i192 = (((threadPriority | 20) << 1) - (threadPriority ^ 20)) >> 6;
                                            int i193 = i192 * 165;
                                            int i194 = ~((i74 ^ 1406071600) | (i74 & 1406071600));
                                            int i195 = (i193 & (-1556404112)) + (i193 | (-1556404112)) + (((i192 ^ i194) | (i194 & i192)) * (-328));
                                            int i196 = ((i192 ^ i2) | (i192 & i2)) * 164;
                                            int i197 = (i195 & i196) + (i196 | i195);
                                            int i198 = ~i192;
                                            int i199 = ~((i198 ^ (-1406071601)) | (i198 & (-1406071601)));
                                            int i200 = ~(((-1406071601) ^ i2) | ((-1406071601) & i2));
                                            int i201 = (i199 ^ i200) | (i199 & i200);
                                            int i202 = i192 | i68;
                                            int i203 = ~((i202 & 1406071600) | (i202 ^ 1406071600));
                                            int i204 = i197 + (((i203 & i201) | (i201 ^ i203)) * 164);
                                            Object[] objArr14 = new Object[1];
                                            a(iIndexOf2, (byte) ((i191 ^ 59) + ((i191 & 59) << 1)), offsetAfter, fadingEdgeLength, i204, objArr14);
                                            Object objInvoke2 = cls2.getMethod((String) objArr14[0], null).invoke(context, null);
                                            int i205 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                            int i206 = (i205 & 71) + (i205 | 71);
                                            artificialFrame = i206 % 128;
                                            int i207 = i206 % 2;
                                            try {
                                                Object[] objArr15 = {objInvoke2, 64};
                                                int threadPriority2 = Process.getThreadPriority(0);
                                                int i208 = ((threadPriority2 & 20) + (threadPriority2 | 20)) >> 6;
                                                int iICustomTabsCallbackStubProxy7 = com.google.android.gms.common.internal.Objects.ICustomTabsCallbackStubProxy();
                                                int i209 = ~iICustomTabsCallbackStubProxy7;
                                                int i210 = (i208 * (-51)) + 53 + ((~(i209 | i208 | 1)) * 52);
                                                int i211 = ~((i209 & (-2)) | ((-2) ^ i209));
                                                int i212 = ~(((-2) & i208) | ((-2) ^ i208));
                                                int i213 = (i211 & i212) | (i211 ^ i212);
                                                int i214 = ~iICustomTabsCallbackStubProxy7;
                                                int i215 = ~((i214 ^ i208) | (i214 & i208));
                                                int i216 = artificialFrame;
                                                int i217 = (i216 ^ 21) + ((i216 & 21) << 1);
                                                getARTIFICIAL_FRAME_PACKAGE_NAME = i217 % 128;
                                                int i218 = i217 % 2;
                                                int i219 = (i210 - (~(-(-((-52) * ((i213 & i215) | (i213 ^ i215))))))) - 1;
                                                int i220 = ~i208;
                                                int i221 = ~((i214 & i220) | (i220 ^ i214));
                                                int i222 = ~i208;
                                                int i223 = ~((i222 & 1) | (i222 ^ 1));
                                                int i224 = (i219 - (~(-(-(((i223 & i221) | (i221 ^ i223)) * 52))))) - 1;
                                                Object[] objArr16 = new Object[1];
                                                b(i224, new char[]{5893, 62238, 11905, 5988, 52707, 40391, 62347, 33204, 44470, 56036, 46767, 51916, 25310, 5918, 32201, 3146, 10228, 27707, 8439, 45428, 64517, 43348, 58993, 64038, 45352, 59006, 44368, 16371, 30282, 15524, 4186, 24783, 2927, 31172, 55188, 42415, 49559}, objArr16);
                                                Class<?> cls3 = Class.forName((String) objArr16[0]);
                                                int absoluteGravity = (-1727707588) - Gravity.getAbsoluteGravity(0, 0);
                                                int i225 = -ExpandableListView.getPackedPositionChild(0L);
                                                int keyRepeatDelay = (ViewConfiguration.getKeyRepeatDelay() >> 16) - 56;
                                                int i226 = -Color.argb(0, 0, 0, 0);
                                                int mode = View.MeasureSpec.getMode(0);
                                                int iICustomTabsCallbackStubProxy8 = com.google.android.gms.common.internal.Objects.ICustomTabsCallbackStubProxy();
                                                int i227 = (mode * 755) + 2084996770;
                                                int i228 = ~mode;
                                                int i229 = (i228 ^ 1406071614) | (i228 & 1406071614);
                                                int i230 = ~i229;
                                                int i231 = ~mode;
                                                int i232 = ~((i231 ^ iICustomTabsCallbackStubProxy8) | (i231 & iICustomTabsCallbackStubProxy8));
                                                int i233 = ((i230 ^ i232) | (i232 & i230) | (~((iICustomTabsCallbackStubProxy8 ^ 1406071614) | (iICustomTabsCallbackStubProxy8 & 1406071614)))) * (-754);
                                                int i234 = (i227 ^ i233) + ((i233 & i227) << 1);
                                                int i235 = ~((i229 ^ iICustomTabsCallbackStubProxy8) | (i229 & iICustomTabsCallbackStubProxy8));
                                                int i236 = ~iICustomTabsCallbackStubProxy8;
                                                int i237 = ~((mode & i236) | (i236 ^ mode) | 1406071614);
                                                int i238 = i234 + (((i235 & i237) | (i235 ^ i237)) * (-754));
                                                int i239 = (i231 | (~iICustomTabsCallbackStubProxy8)) * 754;
                                                int i240 = (i238 ^ i239) + ((i239 & i238) << 1);
                                                Object[] objArr17 = new Object[1];
                                                a(absoluteGravity, (byte) ((i225 & (-30)) + (i225 | (-30))), keyRepeatDelay, (short) ((i226 ^ 118) + ((i226 & 118) << 1)), i240, objArr17);
                                                Method method2 = cls3.getMethod((String) objArr17[0], String.class, Integer.TYPE);
                                                int i241 = artificialFrame;
                                                int i242 = (i241 ^ 11) + ((i241 & 11) << 1);
                                                getARTIFICIAL_FRAME_PACKAGE_NAME = i242 % 128;
                                                int i243 = i242 % 2;
                                                Object objInvoke3 = method2.invoke(objInvoke, objArr15);
                                                int i244 = -(-TextUtils.indexOf((CharSequence) "", '0', 0));
                                                int i245 = (i244 ^ (-1727707593)) + ((i244 & (-1727707593)) << 1);
                                                int i246 = -(ViewConfiguration.getScrollBarSize() >> 8);
                                                byte b2 = (byte) ((i246 ^ 6) + ((i246 & 6) << 1));
                                                int i247 = (-57) - (~(-TextUtils.getOffsetAfter("", 0)));
                                                int i248 = -(ViewConfiguration.getTapTimeout() >> 16);
                                                short s2 = (short) (((i248 | (-44)) << 1) - (i248 ^ (-44)));
                                                int i249 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                int i250 = (i249 & 83) + (i249 | 83);
                                                artificialFrame = i250 % 128;
                                                int i251 = i250 % 2;
                                                Object[] objArr18 = new Object[1];
                                                a(i245, b2, i247, s2, ExpandableListView.getPackedPositionType(0L) + 1406071628, objArr18);
                                                Class<?> cls4 = Class.forName((String) objArr18[0]);
                                                int scrollDefaultDelay = ViewConfiguration.getScrollDefaultDelay() >> 16;
                                                Object[] objArr19 = new Object[1];
                                                b((scrollDefaultDelay ^ 1) + ((scrollDefaultDelay & 1) << 1), new char[]{47730, 8560, 11973, 47617, 33973, 20398, 62412, 51454, 207, 2199, 46842, 33734, 53167, 50540}, objArr19);
                                                Object[] objArr20 = (Object[]) cls4.getField((String) objArr19[0]).get(objInvoke3);
                                                int length = objArr20.length;
                                                int i252 = 0;
                                                while (i252 < length) {
                                                    Object obj = objArr20[i252];
                                                    Object[] objArr21 = new Object[1];
                                                    b(-Process.getGidForName(str2), new char[]{13527, 1048, 29177, 13455, 999, 27265, 44194, 20466, 36402}, objArr21);
                                                    try {
                                                        Object[] objArr22 = {(String) objArr21[0]};
                                                        int offsetBefore = TextUtils.getOffsetBefore(str2, 0);
                                                        int iICustomTabsCallbackStubProxy9 = com.google.android.gms.common.internal.Objects.ICustomTabsCallbackStubProxy();
                                                        int i253 = offsetBefore * 370;
                                                        int i254 = (i253 & 698320654) + (i253 | 698320654);
                                                        int i255 = ~iICustomTabsCallbackStubProxy9;
                                                        int i256 = -(-(((offsetBefore ^ (-1727707585)) | (offsetBefore & (-1727707585)) | i255) * (-369)));
                                                        int i257 = (i254 ^ i256) + ((i256 & i254) << 1);
                                                        int i258 = ~offsetBefore;
                                                        int i259 = ~((i258 & i255) | (i258 ^ i255));
                                                        int i260 = ((i259 & (-1727707585)) | (i259 ^ (-1727707585))) * (-369);
                                                        int i261 = ((i257 | i260) << 1) - (i260 ^ i257);
                                                        int i262 = ~((1727707584 ^ offsetBefore) | (1727707584 & offsetBefore));
                                                        int i263 = ~((offsetBefore ^ iICustomTabsCallbackStubProxy9) | (offsetBefore & iICustomTabsCallbackStubProxy9));
                                                        int i264 = (i262 & i263) | (i262 ^ i263);
                                                        int i265 = (~iICustomTabsCallbackStubProxy9) | (~offsetBefore);
                                                        int i266 = ~((i265 & (-1727707585)) | (i265 ^ (-1727707585)));
                                                        int i267 = -(-(((i266 & i264) | (i264 ^ i266)) * 369));
                                                        int i268 = ((i261 | i267) << 1) - (i267 ^ i261);
                                                        int i269 = -TextUtils.indexOf(str2, str2);
                                                        int iICustomTabsCallbackStubProxy10 = com.google.android.gms.common.internal.Objects.ICustomTabsCallbackStubProxy();
                                                        int i270 = (i269 * (-830)) - 34112;
                                                        int i271 = ~iICustomTabsCallbackStubProxy10;
                                                        int i272 = ~((i271 & 40) | (40 ^ i271));
                                                        int i273 = (i269 ^ (-41)) | (i269 & (-41));
                                                        int i274 = ~((i273 ^ iICustomTabsCallbackStubProxy10) | (i273 & iICustomTabsCallbackStubProxy10));
                                                        int i275 = ((i272 ^ i274) | (i272 & i274)) * (-831);
                                                        int i276 = (i270 ^ i275) + ((i270 & i275) << 1);
                                                        int i277 = (40 ^ i269) | (40 & i269);
                                                        int i278 = (i276 - (~(-(-((~((i277 & iICustomTabsCallbackStubProxy10) | (i277 ^ iICustomTabsCallbackStubProxy10))) * (-1662)))))) - 1;
                                                        int i279 = ~((~i269) | (~iICustomTabsCallbackStubProxy10));
                                                        int i280 = ~(i269 | iICustomTabsCallbackStubProxy10);
                                                        int i281 = (i280 & i279) | (i279 ^ i280);
                                                        int i282 = ~((iICustomTabsCallbackStubProxy10 & (-41)) | (iICustomTabsCallbackStubProxy10 ^ (-41)));
                                                        byte b3 = (byte) (i278 + (((i281 & i282) | (i281 ^ i282)) * 831));
                                                        int mirror = 65528 - AndroidCharacter.getMirror('0');
                                                        int deadChar = KeyEvent.getDeadChar(0, 0);
                                                        int i283 = -TextUtils.indexOf(str2, str2, 0, 0);
                                                        int i284 = ((i283 | 1406071658) << 1) - (i283 ^ 1406071658);
                                                        Object[] objArr23 = new Object[1];
                                                        a(i268, b3, mirror, (short) (((deadChar | (-39)) << 1) - (deadChar ^ (-39))), i284, objArr23);
                                                        Class<?> cls5 = Class.forName((String) objArr23[0]);
                                                        Object[] objArr24 = new Object[1];
                                                        b((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), new char[]{8695, 37833, 7617, 8592, 10881, 64795, 49371, 26349, 39749, 47657, 34303, 11745, 21537, 30661, 20098}, objArr24);
                                                        Object objInvoke4 = cls5.getMethod((String) objArr24[0], String.class).invoke(null, objArr22);
                                                        try {
                                                            byte modifierMetaStateMask = (byte) KeyEvent.getModifierMetaStateMask();
                                                            int i285 = (modifierMetaStateMask ^ (-1727707593)) + ((modifierMetaStateMask & (-1727707593)) << 1);
                                                            int i286 = -(-KeyEvent.normalizeMetaState(0));
                                                            byte b4 = (byte) ((i286 ^ (-16)) + ((i286 & (-16)) << 1));
                                                            int i287 = -View.getDefaultSize(0, 0);
                                                            int i288 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                            int i289 = ((i288 | 87) << 1) - (i288 ^ 87);
                                                            artificialFrame = i289 % 128;
                                                            if (i289 % 2 == 0) {
                                                                iICustomTabsCallbackStubProxy = com.google.android.gms.common.internal.Objects.ICustomTabsCallbackStubProxy();
                                                                int i290 = 904 - (~(-i287));
                                                                i5 = (i290 ^ 50568) + ((i290 & 50568) << 1);
                                                            } else {
                                                                iICustomTabsCallbackStubProxy = com.google.android.gms.common.internal.Objects.ICustomTabsCallbackStubProxy();
                                                                i5 = (i287 * TypedValues.Custom.TYPE_DIMENSION) + 50568;
                                                            }
                                                            int i291 = ~i287;
                                                            int i292 = ~((i291 ^ iICustomTabsCallbackStubProxy) | (i291 & iICustomTabsCallbackStubProxy));
                                                            int i293 = ~iICustomTabsCallbackStubProxy;
                                                            Object[] objArr25 = objArr20;
                                                            int i294 = ~(i293 | (-56));
                                                            int i295 = i5 + ((-1808) * ((i292 ^ i294) | (i294 & i292)));
                                                            int i296 = (i291 ^ 55) | (i291 & 55);
                                                            int i297 = ~((i296 & iICustomTabsCallbackStubProxy) | (i296 ^ iICustomTabsCallbackStubProxy));
                                                            int i298 = (i293 & i287) | (i293 ^ i287);
                                                            int i299 = artificialFrame + 93;
                                                            int i300 = length;
                                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i299 % 128;
                                                            int i301 = i299 % 2;
                                                            int i302 = ~((i298 & (-56)) | (i298 ^ (-56)));
                                                            int i303 = i301 != 0 ? -(TypedValues.Custom.TYPE_BOOLEAN >> ((i297 & i302) | (i297 ^ i302))) : (i297 | i302) * TypedValues.Custom.TYPE_BOOLEAN;
                                                            int i304 = (i295 & i303) + (i295 | i303);
                                                            int i305 = ~((i291 ^ (-56)) | (i291 & (-56)));
                                                            int i306 = ~((55 ^ iICustomTabsCallbackStubProxy) | (55 & iICustomTabsCallbackStubProxy));
                                                            int i307 = (i305 & i306) | (i305 ^ i306);
                                                            int i308 = ~iICustomTabsCallbackStubProxy;
                                                            int i309 = -(-(TypedValues.Custom.TYPE_BOOLEAN * (i307 | (~((i287 & i308) | (i308 ^ i287))))));
                                                            int i310 = (i304 ^ i309) + ((i309 & i304) << 1);
                                                            short s3 = (short) ((-73) - (~(-(ViewConfiguration.getScrollBarSize() >> 8))));
                                                            int i311 = -(-(ViewConfiguration.getKeyRepeatDelay() >> 16));
                                                            int i312 = (i311 ^ 1406071695) + ((i311 & 1406071695) << 1);
                                                            Object[] objArr26 = new Object[1];
                                                            a(i285, b4, i310, s3, i312, objArr26);
                                                            Class<?> cls6 = Class.forName((String) objArr26[0]);
                                                            Object[] objArr27 = new Object[1];
                                                            b((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), new char[]{14777, 51843, 59677, 14797, 7538, 42075, 13361, 20782, 33553, 58229, 28950, 6657, 19571, 11917, 47682}, objArr27);
                                                            try {
                                                                Object[] objArr28 = {new ByteArrayInputStream((byte[]) cls6.getMethod((String) objArr27[0], null).invoke(obj, null))};
                                                                int i313 = -(-KeyEvent.normalizeMetaState(0));
                                                                int i314 = -(-View.MeasureSpec.getMode(0));
                                                                int i315 = (-58) - (~(-TextUtils.lastIndexOf(str2, '0', 0)));
                                                                int i316 = -(-TextUtils.indexOf(str2, str2, 0, 0));
                                                                int i317 = -(AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                                                                int i318 = (i317 ^ 1406071659) + ((i317 & 1406071659) << 1);
                                                                Object[] objArr29 = new Object[1];
                                                                a(((i313 | (-1727707585)) << 1) - (i313 ^ (-1727707585)), (byte) ((i314 ^ (-41)) + ((i314 & (-41)) << 1)), i315, (short) ((i316 ^ (-39)) + ((i316 & (-39)) << 1)), i318, objArr29);
                                                                Class<?> cls7 = Class.forName((String) objArr29[0]);
                                                                int iResolveSize = View.resolveSize(0, 0);
                                                                int iICustomTabsCallbackStubProxy11 = com.google.android.gms.common.internal.Objects.ICustomTabsCallbackStubProxy();
                                                                int i319 = iResolveSize * 980;
                                                                int i320 = (i319 ^ (-978)) + ((i319 & (-978)) << 1);
                                                                int i321 = ~iICustomTabsCallbackStubProxy11;
                                                                int i322 = (~((-2) | i321)) * 979;
                                                                int i323 = (((i320 & i322) + (i320 | i322)) - (~(-(-((iResolveSize | iICustomTabsCallbackStubProxy11) * (-979)))))) - 1;
                                                                int i324 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                                int i325 = (i324 ^ b.f40o) + ((i324 & b.f40o) << 1);
                                                                int i326 = i325 % 128;
                                                                artificialFrame = i326;
                                                                int i327 = i325 % 2;
                                                                int i328 = ((~((iICustomTabsCallbackStubProxy11 & (-2)) | ((-2) ^ iICustomTabsCallbackStubProxy11))) | (~((iResolveSize & i321) | (i321 ^ iResolveSize)))) * 979;
                                                                int i329 = (i326 ^ 87) + ((i326 & 87) << 1);
                                                                getARTIFICIAL_FRAME_PACKAGE_NAME = i329 % 128;
                                                                if (i329 % 2 != 0) {
                                                                    Object[] objArr30 = new Object[1];
                                                                    b(i323 % i328, new char[]{23261, 59164, 53419, 23226, 56831, 35278, 3499, 37311, 57459, 52974, 18581, 55963, 12070, 790, 33791, 7254, 27168, 30769, 57024, 41253, 45516, 48463, 6160}, objArr30);
                                                                    String str4 = (String) objArr30[0];
                                                                    Class<?>[] clsArr = new Class[1];
                                                                    clsArr[1] = InputStream.class;
                                                                    method = cls7.getMethod(str4, clsArr);
                                                                } else {
                                                                    Object[] objArr31 = new Object[1];
                                                                    b((i323 ^ i328) + ((i328 & i323) << 1), new char[]{23261, 59164, 53419, 23226, 56831, 35278, 3499, 37311, 57459, 52974, 18581, 55963, 12070, 790, 33791, 7254, 27168, 30769, 57024, 41253, 45516, 48463, 6160}, objArr31);
                                                                    method = cls7.getMethod((String) objArr31[0], InputStream.class);
                                                                }
                                                                Object objInvoke5 = method.invoke(objInvoke4, objArr28);
                                                                int i330 = getARTIFICIAL_FRAME_PACKAGE_NAME + 3;
                                                                artificialFrame = i330 % 128;
                                                                if (i330 % 2 == 0) {
                                                                    int length2 = objArr4.length;
                                                                    i6 = 1;
                                                                } else {
                                                                    int length3 = objArr4.length;
                                                                    i6 = 0;
                                                                }
                                                                for (int i331 = 2; i6 < i331; i331 = 2) {
                                                                    Object obj2 = objArr4[i6];
                                                                    try {
                                                                        Object[] objArr32 = new Object[1];
                                                                        b(1 - (Process.myPid() >> 22), new char[]{48408, 35073, 40836, 48498, 9327, 59351, 17052, 26667, 2026, 41185, 1963, 8973, 51413, 27932, 52427, 58822, 36341, 5732, 37349, 22707, 22042, 54098, 22388, 5026, 7009, 39986, 7175, 54877, 56405, 18092, 41318, 35147, 41338, 979, 26261, 19495, 27532, 52467}, objArr32);
                                                                        Class<?> cls8 = Class.forName((String) objArr32[0]);
                                                                        int i332 = -TextUtils.getTrimmedLength(str2);
                                                                        int i333 = (i332 ^ (-1727707588)) + ((i332 & (-1727707588)) << 1);
                                                                        int i334 = -(-TextUtils.lastIndexOf(str2, '0'));
                                                                        byte b5 = (byte) ((i334 & 64) + (i334 | 64));
                                                                        int i335 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                                        int i336 = ((i335 | 67) << 1) - (i335 ^ 67);
                                                                        artificialFrame = i336 % 128;
                                                                        if (i336 % 2 == 0) {
                                                                            int iIndexOf3 = TextUtils.indexOf((CharSequence) str2, '9', 0);
                                                                            i7 = (866 >>> iIndexOf3) * (-919);
                                                                            iIndexOf = iIndexOf3;
                                                                        } else {
                                                                            iIndexOf = TextUtils.indexOf((CharSequence) str2, '0', 0);
                                                                            int i337 = iIndexOf * 866;
                                                                            i7 = (i337 & 47520) + (i337 | 47520);
                                                                        }
                                                                        int i338 = ~((~iIndexOf) | i74);
                                                                        int i339 = -(-(((54 ^ i338) | (54 & i338)) * (-865)));
                                                                        int i340 = (i7 & i339) + (i7 | i339);
                                                                        int i341 = (~((iIndexOf ^ i2) | (iIndexOf & i2))) * 865;
                                                                        int i342 = (i340 ^ i341) + ((i340 & i341) << 1);
                                                                        int i343 = ~((54 ^ i74) | (54 & i74));
                                                                        int i344 = ~((i74 ^ iIndexOf) | (iIndexOf & i74));
                                                                        int i345 = ((i343 ^ i344) | (i343 & i344)) * 865;
                                                                        int i346 = ((i342 | i345) << 1) - (i345 ^ i342);
                                                                        int i347 = -(ViewConfiguration.getMaximumFlingVelocity() >> 16);
                                                                        int i348 = getARTIFICIAL_FRAME_PACKAGE_NAME + 87;
                                                                        int i349 = i348 % 128;
                                                                        artificialFrame = i349;
                                                                        if (i348 % 2 == 0) {
                                                                            i8 = (-589) / i347;
                                                                            int i350 = ~(9 | i74);
                                                                            int i351 = ~((9 ^ i347) | (9 & i347));
                                                                            i9 = (i350 ^ i351) | (i350 & i351);
                                                                        } else {
                                                                            int i352 = i347 * (-589);
                                                                            i8 = (i352 & (-5910)) + (i352 | (-5910));
                                                                            int i353 = ~((9 ^ i74) | (9 & i74));
                                                                            int i354 = ~(9 | i347);
                                                                            i9 = (i354 & i353) | (i353 ^ i354);
                                                                        }
                                                                        int i355 = ~((i74 ^ i347) | (i74 & i347));
                                                                        int i356 = (i9 & i355) | (i9 ^ i355);
                                                                        int i357 = ~i347;
                                                                        int i358 = (i357 ^ (-10)) | (i357 & (-10));
                                                                        int i359 = ~((i358 ^ i2) | (i358 & i2));
                                                                        int i360 = i8 + (((i356 ^ i359) | (i356 & i359)) * 590);
                                                                        int i361 = ~((9 ^ i74) | (9 & i74));
                                                                        int i362 = i349 + 13;
                                                                        int i363 = i362 % 128;
                                                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i363;
                                                                        String str5 = str2;
                                                                        if (i362 % 2 != 0) {
                                                                            int i364 = ~((9 ^ i347) | (9 & i347));
                                                                            int i365 = (i361 ^ i364) | (i361 & i364);
                                                                            int i366 = ~(i68 | i347);
                                                                            i10 = i360 * ((-1180) >> ((i365 & i366) | (i365 ^ i366)));
                                                                            i11 = ~((i357 ^ i68) | (i357 & i68));
                                                                            i12 = i74;
                                                                        } else {
                                                                            int i367 = ~((9 ^ i347) | (9 & i347));
                                                                            int i368 = (i361 ^ i367) | (i361 & i367);
                                                                            int i369 = ~(i347 | i74);
                                                                            i10 = i360 + (((i368 & i369) | (i368 ^ i369)) * (-1180));
                                                                            i11 = ~((i357 ^ i74) | (i357 & i74));
                                                                            i12 = i68;
                                                                        }
                                                                        int i370 = i363 + 67;
                                                                        artificialFrame = i370 % 128;
                                                                        int i371 = i370 % 2;
                                                                        int i372 = ~((i12 & (-10)) | (i12 ^ (-10)));
                                                                        short s4 = (short) (i10 + (590 * ((i11 & i372) | (i11 ^ i372))));
                                                                        int size = View.MeasureSpec.getSize(0);
                                                                        Object[] objArr33 = new Object[1];
                                                                        a(i333, b5, i346, s4, ((size | 1406071723) << 1) - (1406071723 ^ size), objArr33);
                                                                        if (obj2.equals(cls8.getMethod((String) objArr33[0], null).invoke(objInvoke5, null))) {
                                                                            int iICustomTabsCallbackStubProxy12 = com.google.android.gms.common.internal.Objects.ICustomTabsCallbackStubProxy();
                                                                            int i373 = ~iICustomTabsCallbackStubProxy12;
                                                                            int i374 = ((i373 & (-1375767557)) | ((-1375767557) ^ i373)) * SyslogConstants.LOG_LOCAL7;
                                                                            int i375 = ((-96148785) & i374) + (i374 | (-96148785));
                                                                            int i376 = ~iICustomTabsCallbackStubProxy12;
                                                                            int i377 = (~((i376 & 167735923) | (i376 ^ 167735923))) | 152711776;
                                                                            int i378 = -(-(((i377 & (-1543503480)) | (i377 ^ (-1543503480))) * SyslogConstants.LOG_LOCAL7));
                                                                            int i379 = (i375 & i378) + (i378 | i375);
                                                                            int i380 = ~(((-118274234) & i74) | ((-118274234) ^ i74));
                                                                            int i381 = ~((-1226275853) | i2);
                                                                            int i382 = 1739252983 + (((i380 & i381) | (i380 ^ i381)) * JfifUtil.MARKER_EOI) + (((~(((-118274234) & i2) | ((-118274234) ^ i2))) | 17053704) * JfifUtil.MARKER_EOI);
                                                                            int i383 = ~(((-1226275853) & i74) | ((-1226275853) ^ i74));
                                                                            int i384 = -(-(((i383 & 118274233) | (118274233 ^ i383)) * JfifUtil.MARKER_EOI));
                                                                            if (i379 <= (i382 & i384) + (i384 | i382)) {
                                                                                i14 = 0;
                                                                                c = 1;
                                                                                i13 = (~(i2 & 1)) & (i2 | 1);
                                                                                objArr = new Object[5];
                                                                            } else {
                                                                                i13 = (i2 & (-2)) | (i74 & 1);
                                                                                objArr = new Object[4];
                                                                                i14 = 1;
                                                                                c = 0;
                                                                            }
                                                                            objArr[c] = new int[i14];
                                                                            objArr[1] = new int[]{i13};
                                                                            objArr[2] = new int[1];
                                                                            ((int[]) objArr[0])[0] = i2;
                                                                            objArr[3] = null;
                                                                            int i385 = getARTIFICIAL_FRAME_PACKAGE_NAME + 45;
                                                                            artificialFrame = i385 % 128;
                                                                            if (i385 % 2 == 0) {
                                                                                int i386 = (-331426088) + (((~((-767125977) | i74)) | 555763864) * (-245));
                                                                                int i387 = ~((-767125977) | i2);
                                                                                int i388 = i386 + (i387 * (-245)) + ((i387 | 211497798) * 245);
                                                                                int i389 = -(-(((i388 | 16) << 1) - (i388 ^ 16)));
                                                                                i15 = ((i3 | i389) << 1) - (i3 ^ i389);
                                                                            } else {
                                                                                int iUptimeMillis = (int) SystemClock.uptimeMillis();
                                                                                int i390 = ~iUptimeMillis;
                                                                                int i391 = 844030607 + (((~(i390 | 534403099)) | (-536501532) | (~((-442122244) | iUptimeMillis))) * 717) + (((~(iUptimeMillis | 534403099)) | (~(i390 | (-442122244))) | (-536501532)) * 717) + 16;
                                                                                i15 = (i3 ^ i391) + ((i3 & i391) << 1);
                                                                            }
                                                                            int i392 = i15 << 13;
                                                                            int i393 = (i392 & (~i15)) | ((~i392) & i15);
                                                                            int i394 = i393 ^ (i393 >>> 17);
                                                                            ((int[]) objArr[2])[0] = i394 ^ (i394 << 5);
                                                                            int i395 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                                            int i396 = (i395 & 55) + (i395 | 55);
                                                                            artificialFrame = i396 % 128;
                                                                            int i397 = i396 % 2;
                                                                            return objArr;
                                                                        }
                                                                        i6 = (i6 | 1) + (i6 & 1);
                                                                        str2 = str5;
                                                                    } catch (Throwable th4) {
                                                                        Throwable cause = th4.getCause();
                                                                        if (cause != null) {
                                                                            throw cause;
                                                                        }
                                                                        throw th4;
                                                                    }
                                                                }
                                                                i252++;
                                                                objArr20 = objArr25;
                                                                length = i300;
                                                                str2 = str2;
                                                            } catch (Throwable th5) {
                                                                Throwable cause2 = th5.getCause();
                                                                if (cause2 != null) {
                                                                    throw cause2;
                                                                }
                                                                throw th5;
                                                            }
                                                        } catch (Throwable th6) {
                                                            Throwable cause3 = th6.getCause();
                                                            if (cause3 != null) {
                                                                throw cause3;
                                                            }
                                                            throw th6;
                                                        }
                                                    } catch (Throwable th7) {
                                                        Throwable cause4 = th7.getCause();
                                                        if (cause4 != null) {
                                                            throw cause4;
                                                        }
                                                        throw th7;
                                                    }
                                                }
                                            } catch (Throwable th8) {
                                                Throwable cause5 = th8.getCause();
                                                if (cause5 != null) {
                                                    throw cause5;
                                                }
                                                throw th8;
                                            }
                                        } catch (Throwable th9) {
                                            Throwable cause6 = th9.getCause();
                                            if (cause6 != null) {
                                                throw cause6;
                                            }
                                            throw th9;
                                        }
                                    } catch (Throwable th10) {
                                        Throwable cause7 = th10.getCause();
                                        if (cause7 != null) {
                                            throw cause7;
                                        }
                                        throw th10;
                                    }
                                } catch (Throwable th11) {
                                    Throwable cause8 = th11.getCause();
                                    if (cause8 != null) {
                                        throw cause8;
                                    }
                                    throw th11;
                                }
                            } catch (Throwable th12) {
                                Throwable cause9 = th12.getCause();
                                if (cause9 != null) {
                                    throw cause9;
                                }
                                throw th12;
                            }
                        } catch (Throwable unused) {
                        }
                        Object[] objArr34 = {new int[]{i2}, new int[]{i2}, new int[1], null};
                        int iMyTid = Process.myTid();
                        int i398 = ~iMyTid;
                        int i399 = (((~((-876185823) | i398)) | (~(iMyTid | 102437952))) * 959) + 1983759611 + (((~(iMyTid | (-876185823))) | (~(i398 | 102437952))) * 959);
                        int iICustomTabsCallbackStubProxy13 = com.google.android.gms.common.internal.Objects.ICustomTabsCallbackStubProxy();
                        int i400 = ~iICustomTabsCallbackStubProxy13;
                        int i401 = (i399 * (-1527)) + (((~i400) | i399) * 764);
                        int i402 = ~(((-1) ^ i399) | i399);
                        int i403 = ~iICustomTabsCallbackStubProxy13;
                        int i404 = ~((i403 & i399) | (i403 ^ i399));
                        int i405 = (i401 - (~(((i404 & i402) | (i402 ^ i404)) * (-1528)))) - 1;
                        int i406 = ~(((-1) ^ i399) | i399);
                        int i407 = getARTIFICIAL_FRAME_PACKAGE_NAME + 121;
                        artificialFrame = i407 % 128;
                        int i408 = i407 % 2;
                        int i409 = ~(~i399);
                        int i410 = (i406 & i409) | (i406 ^ i409);
                        int i411 = ~i400;
                        int i412 = i3 + i405 + (764 * ((i410 & i411) | (i410 ^ i411)));
                        int i413 = i412 << 13;
                        int i414 = ((~i412) & i413) | ((~i413) & i412);
                        int i415 = i414 >>> 17;
                        int i416 = ((~i414) & i415) | ((~i415) & i414);
                        int i417 = i416 << 5;
                        ((int[]) objArr34[2])[0] = ((~i416) & i417) | ((~i417) & i416);
                        return objArr34;
                    }
                });
            } else {
                if (SentryItemType.Transaction.equals(sentryEnvelopeItem.getHeader().getType())) {
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(sentryEnvelopeItem.getData()), UTF_8));
                        try {
                            SentryTransaction sentryTransaction = (SentryTransaction) this.serializer.deserialize(bufferedReader2, SentryTransaction.class);
                            if (sentryTransaction == null) {
                                logEnvelopeItemNull(sentryEnvelopeItem, i);
                            } else if (sentryEnvelope.getHeader().getEventId() != null && !sentryEnvelope.getHeader().getEventId().equals(sentryTransaction.getEventId())) {
                                logUnexpectedEventId(sentryEnvelope, sentryTransaction.getEventId(), i);
                                bufferedReader2.close();
                            } else {
                                TraceContext traceContext = sentryEnvelope.getHeader().getTraceContext();
                                if (sentryTransaction.getContexts().getTrace() != null) {
                                    sentryTransaction.getContexts().getTrace().setSamplingDecision(extractSamplingDecision(traceContext));
                                }
                                this.scopes.captureTransaction(sentryTransaction, traceContext, hint);
                                logItemCaptured(i);
                                if (!waitFlush(hint)) {
                                    logTimeout(sentryTransaction.getEventId());
                                    bufferedReader2.close();
                                    return;
                                }
                            }
                            bufferedReader2.close();
                        } catch (Throwable th4) {
                            try {
                                bufferedReader2.close();
                            } catch (Throwable th5) {
                                th4.addSuppressed(th5);
                            }
                            throw th4;
                        }
                    } catch (Throwable th6) {
                        this.logger.log(SentryLevel.ERROR, "Item failed to process.", th6);
                    }
                } else {
                    this.scopes.captureEnvelope(new SentryEnvelope(sentryEnvelope.getHeader().getEventId(), sentryEnvelope.getHeader().getSdkVersion(), sentryEnvelopeItem), hint);
                    this.logger.log(SentryLevel.DEBUG, "%s item %d is being captured.", sentryEnvelopeItem.getHeader().getType().getItemType(), Integer.valueOf(i));
                    if (!waitFlush(hint)) {
                        this.logger.log(SentryLevel.WARNING, "Timed out waiting for item type submission: %s", sentryEnvelopeItem.getHeader().getType().getItemType());
                        return;
                    }
                }
                sentrySdkHint = HintUtils.getSentrySdkHint(hint);
                if (!(sentrySdkHint instanceof SubmissionResult)) {
                }
                HintUtils.runIfHasType(hint, Resettable.class, new HintUtils.SentryConsumer() { // from class: io.sentry.OutboxSender$$ExternalSyntheticLambda0
                    private static short[] ICustomTabsService;
                    private static final byte[] $$a = {106, -29, -101, -119};
                    private static final int $$b = 19;
                    private static int $10 = 0;
                    private static int $11 = 1;
                    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
                    private static int artificialFrame = 1;
                    private static int onTransact = 1462758790;
                    private static int mayLaunchUrl = -81862468;
                    private static int getInterfaceDescriptor = -1645978976;
                    private static byte[] ICustomTabsCallbackStubProxy = {100, 50, 36, 78, 79, 56, 72, 62, 107, 85, 53, 34, 0, 83, 39, 53, 34, -32, 115, Ascii.SI, 57, 38, 89, 122, -8, 72, 50, 62, 32, 91, 39, 59, -120, -1, 94, Ascii.DC2, 88, 62, 107, -36, Ascii.CR, -17, Ascii.SUB, -47, 44, Ascii.VT, -106, Ascii.SUB, 7, -17, Ascii.SUB, -47, Ascii.FF, 43, -58, -43, -42, -45, 2, -22, 3, 92, -124, -16, -15, -85, -122, Ascii.SO, -98, -12, 2, -13, -96, -11, -122, 92, -1, 46, -37, Ascii.SUB, 44, -28, Ascii.DC4, -2, -32, -9, 66, -3, 44, 108, -80, -95, -60, -123, -81, -89, -105, -79, -69, -56, -37, 120, -84, -5, 99, -89, -80, -88, -89, -82, -67, -44, 115, -94, -93, -84, -65, -105, -68, 101, 124, 112, -40, 102, 119, 120, -42, -58, 96, -37, -33, 112, -38, -62, 119, -118, -105, 98, Ascii.US, 119, -118, 119, -126, 2, 114, -120, -52, -38, 103, -37, -57, 50, -54, -24, 98, -52, 110, -64, -34, -78, -96, -64, -76, -35, -91, -106, -14, -34, 113, Ascii.EM, -75, -54, -62, -75, -36, -49, -122, 9, -40, -39, -34, -51, -59, -50, 107, -75, 83, -55, -56, 95, -49, 89, -84, -94, -62, 69, 103, 110, -77, SignedBytes.MAX_POWER_OF_TWO, 69, -54, 87, -84, 97, -79, SignedBytes.MAX_POWER_OF_TWO};
                    private static long onPostMessage = 4960719954659065335L;

                    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0022
                        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                        */
                    private static java.lang.String $$c(int r5, int r6, int r7) {
                        /*
                            byte[] r0 = io.sentry.OutboxSender$$ExternalSyntheticLambda0.$$a
                            int r7 = 117 - r7
                            int r5 = r5 * 4
                            int r5 = r5 + 4
                            int r6 = r6 * 2
                            int r1 = 1 - r6
                            byte[] r1 = new byte[r1]
                            r2 = 0
                            int r6 = 0 - r6
                            if (r0 != 0) goto L16
                            r4 = r6
                            r3 = r2
                            goto L26
                        L16:
                            r3 = r2
                        L17:
                            byte r4 = (byte) r7
                            r1[r3] = r4
                            if (r3 != r6) goto L22
                            java.lang.String r5 = new java.lang.String
                            r5.<init>(r1, r2)
                            return r5
                        L22:
                            int r3 = r3 + 1
                            r4 = r0[r5]
                        L26:
                            int r7 = r7 + r4
                            int r5 = r5 + 1
                            goto L17
                        */
                        throw new UnsupportedOperationException("Method not decompiled: io.sentry.OutboxSender$$ExternalSyntheticLambda0.$$c(int, int, int):java.lang.String");
                    }

                    @Override // io.sentry.util.HintUtils.SentryConsumer
                    public final void accept(Object obj) {
                        ((Resettable) obj).reset();
                    }

                    private static void b(int i2, char[] cArr, Object[] objArr) throws Throwable {
                        int i3 = 2 % 2;
                        onRelationshipValidationResult onrelationshipvalidationresult = new onRelationshipValidationResult();
                        char[] cArrAccessartificialFrame = onRelationshipValidationResult.accessartificialFrame(onPostMessage ^ 2573525503365829440L, cArr, i2);
                        onrelationshipvalidationresult.e = 4;
                        while (onrelationshipvalidationresult.e < cArrAccessartificialFrame.length) {
                            int i4 = $11 + 117;
                            $10 = i4 % 128;
                            int i5 = i4 % 2;
                            onrelationshipvalidationresult.d = onrelationshipvalidationresult.e - 4;
                            int i6 = onrelationshipvalidationresult.e;
                            try {
                                Object[] objArr2 = {Long.valueOf(cArrAccessartificialFrame[onrelationshipvalidationresult.e] ^ cArrAccessartificialFrame[onrelationshipvalidationresult.e % 4]), Long.valueOf(onrelationshipvalidationresult.d), Long.valueOf(onPostMessage)};
                                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(797310229);
                                if (objAccessartificialFrame == null) {
                                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getScrollDefaultDelay() >> 16) + 27, (char) (KeyEvent.getDeadChar(0, 0) + 30690), TextUtils.lastIndexOf("", '0', 0) + 189, -1327449315, false, "k", new Class[]{Long.TYPE, Long.TYPE, Long.TYPE});
                                }
                                cArrAccessartificialFrame[i6] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                                Object[] objArr3 = {onrelationshipvalidationresult, onrelationshipvalidationresult};
                                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(321542193);
                                if (objAccessartificialFrame2 == null) {
                                    byte b = (byte) 0;
                                    byte b2 = b;
                                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(33 - (KeyEvent.getMaxKeyCode() >> 16), (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)), (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 1482, -1940971975, false, $$c(b, b2, (byte) (b2 | 6)), new Class[]{Object.class, Object.class});
                                }
                                ((Method) objAccessartificialFrame2).invoke(null, objArr3);
                                int i7 = $10 + 19;
                                $11 = i7 % 128;
                                int i8 = i7 % 2;
                            } catch (Throwable th7) {
                                Throwable cause = th7.getCause();
                                if (cause == null) {
                                    throw th7;
                                }
                                throw cause;
                            }
                        }
                        objArr[0] = new String(cArrAccessartificialFrame, 4, cArrAccessartificialFrame.length - 4);
                    }

                    /* JADX WARN: Code duplicated, block: B:50:0x023e  */
                    private static void a(int i2, byte b, int i3, short s, int i4, Object[] objArr) throws Throwable {
                        long j;
                        boolean z;
                        int i5 = 2 % 2;
                        ICustomTabsCallback iCustomTabsCallback = new ICustomTabsCallback();
                        StringBuilder sb = new StringBuilder();
                        try {
                            Object[] objArr2 = {Integer.valueOf(i3), Integer.valueOf(mayLaunchUrl)};
                            Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1991297565);
                            if (objAccessartificialFrame == null) {
                                byte b2 = (byte) 0;
                                byte b3 = b2;
                                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getWindowTouchSlop() >> 8) + 40, (char) (36241 - Gravity.getAbsoluteGravity(0, 0)), (ViewConfiguration.getEdgeSlop() >> 16) + 2342, 371880939, false, $$c(b2, b3, (byte) (b3 + 5)), new Class[]{Integer.TYPE, Integer.TYPE});
                            }
                            int iIntValue = ((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
                            int i6 = iIntValue == -1 ? 1 : 0;
                            long j2 = 0;
                            if (i6 == 0) {
                                j = -4629754035390455669L;
                            } else {
                                byte[] bArr = ICustomTabsCallbackStubProxy;
                                if (bArr != null) {
                                    int i7 = $10 + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
                                    $11 = i7 % 128;
                                    int i8 = i7 % 2;
                                    int length = bArr.length;
                                    byte[] bArr2 = new byte[length];
                                    int i9 = 0;
                                    while (i9 < length) {
                                        Object[] objArr3 = {Integer.valueOf(bArr[i9])};
                                        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1557994855);
                                        if (objAccessartificialFrame2 == null) {
                                            int iCombineMeasuredStates = View.combineMeasuredStates(0, 0) + 44;
                                            char mirror = (char) ('0' - AndroidCharacter.getMirror('0'));
                                            int i10 = (SystemClock.uptimeMillis() > j2 ? 1 : (SystemClock.uptimeMillis() == j2 ? 0 : -1)) + 1214;
                                            byte b4 = (byte) 0;
                                            byte b5 = b4;
                                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iCombineMeasuredStates, mirror, i10, 1011328145, false, $$c(b4, b5, b5), new Class[]{Integer.TYPE});
                                        }
                                        bArr2[i9] = ((Byte) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).byteValue();
                                        i9++;
                                        j2 = 0;
                                    }
                                    bArr = bArr2;
                                }
                                if (bArr != null) {
                                    byte[] bArr3 = ICustomTabsCallbackStubProxy;
                                    Object[] objArr4 = {Integer.valueOf(i4), Integer.valueOf(onTransact)};
                                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1991297565);
                                    if (objAccessartificialFrame3 == null) {
                                        byte b6 = (byte) 0;
                                        byte b7 = b6;
                                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(ImageFormat.getBitsPerPixel(0) + 41, (char) (Color.argb(0, 0, 0, 0) + 36241), 2342 - TextUtils.getOffsetAfter("", 0), 371880939, false, $$c(b6, b7, (byte) (b7 + 5)), new Class[]{Integer.TYPE, Integer.TYPE});
                                    }
                                    iIntValue = (byte) (((byte) (((long) bArr3[((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue()]) ^ (-4629754035390455669L))) + ((int) (((long) mayLaunchUrl) ^ (-4629754035390455669L))));
                                    int i11 = $10 + 83;
                                    $11 = i11 % 128;
                                    int i12 = i11 % 2;
                                    j = -4629754035390455669L;
                                } else {
                                    j = -4629754035390455669L;
                                    iIntValue = (short) (((short) (((long) ICustomTabsService[i4 + ((int) (((long) onTransact) ^ (-4629754035390455669L)))]) ^ (-4629754035390455669L))) + ((int) (((long) mayLaunchUrl) ^ (-4629754035390455669L))));
                                }
                            }
                            if (iIntValue > 0) {
                                iCustomTabsCallback.c = ((i4 + iIntValue) - 2) + ((int) (((long) onTransact) ^ j)) + i6;
                                try {
                                    Object[] objArr5 = {iCustomTabsCallback, Integer.valueOf(i2), Integer.valueOf(getInterfaceDescriptor), sb};
                                    Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(216546027);
                                    if (objAccessartificialFrame4 == null) {
                                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 40, (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), 4066 - (ViewConfiguration.getJumpTapTimeout() >> 16), -1819443997, false, "x", new Class[]{Object.class, Integer.TYPE, Integer.TYPE, Object.class});
                                    }
                                    ((StringBuilder) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).append(iCustomTabsCallback.createConnectionCallback);
                                    iCustomTabsCallback.createBrowser = iCustomTabsCallback.createConnectionCallback;
                                    byte[] bArr4 = ICustomTabsCallbackStubProxy;
                                    if (bArr4 != null) {
                                        int i13 = $10 + 15;
                                        $11 = i13 % 128;
                                        int i14 = i13 % 2;
                                        int length2 = bArr4.length;
                                        byte[] bArr5 = new byte[length2];
                                        for (int i15 = 0; i15 < length2; i15++) {
                                            bArr5[i15] = (byte) (((long) bArr4[i15]) ^ (-4629754035390455669L));
                                        }
                                        bArr4 = bArr5;
                                    }
                                    if (bArr4 != null) {
                                        int i16 = $10 + 13;
                                        $11 = i16 % 128;
                                        if (i16 % 2 == 0) {
                                            z = false;
                                        } else {
                                            z = true;
                                        }
                                    } else {
                                        z = false;
                                    }
                                    iCustomTabsCallback.a = 1;
                                    int i17 = $10 + 101;
                                    $11 = i17 % 128;
                                    int i18 = i17 % 2;
                                    while (iCustomTabsCallback.a < iIntValue) {
                                        if (z) {
                                            byte[] bArr6 = ICustomTabsCallbackStubProxy;
                                            int i19 = iCustomTabsCallback.c;
                                            iCustomTabsCallback.c = i19 - 1;
                                            iCustomTabsCallback.createConnectionCallback = (char) (iCustomTabsCallback.createBrowser + (((byte) (((byte) (((long) bArr6[i19]) ^ (-4629754035390455669L))) + s)) ^ b));
                                        } else {
                                            short[] sArr = ICustomTabsService;
                                            int i20 = iCustomTabsCallback.c;
                                            iCustomTabsCallback.c = i20 - 1;
                                            iCustomTabsCallback.createConnectionCallback = (char) (iCustomTabsCallback.createBrowser + (((short) (((short) (((long) sArr[i20]) ^ (-4629754035390455669L))) + s)) ^ b));
                                        }
                                        sb.append(iCustomTabsCallback.createConnectionCallback);
                                        iCustomTabsCallback.createBrowser = iCustomTabsCallback.createConnectionCallback;
                                        iCustomTabsCallback.a++;
                                    }
                                } catch (Throwable th7) {
                                    Throwable cause = th7.getCause();
                                    if (cause == null) {
                                        throw th7;
                                    }
                                    throw cause;
                                }
                            }
                            objArr[0] = sb.toString();
                        } catch (Throwable th8) {
                            Throwable cause2 = th8.getCause();
                            if (cause2 == null) {
                                throw th8;
                            }
                            throw cause2;
                        }
                    }

                    public static Object[] accessartificialFrame(Context context, int i2, int i3) {
                        int i4;
                        String str;
                        int iICustomTabsCallbackStubProxy;
                        int i5;
                        Method method;
                        int i6;
                        int iIndexOf;
                        int i7;
                        int i8;
                        int i9;
                        int i10;
                        int i11;
                        int i12;
                        int i13;
                        Object[] objArr;
                        int i14;
                        char c;
                        int i15;
                        int i16;
                        String str2 = "";
                        int i17 = 2 % 2;
                        int i18 = 13;
                        int i19 = getARTIFICIAL_FRAME_PACKAGE_NAME + 13;
                        int i20 = i19 % 128;
                        artificialFrame = i20;
                        int i21 = i19 % 2;
                        if (context == null) {
                            Object[] objArr2 = new Object[4];
                            int[] iArr = new int[1];
                            objArr2[0] = iArr;
                            int[] iArr2 = new int[1];
                            objArr2[1] = iArr2;
                            objArr2[2] = new int[1];
                            int i22 = (i20 ^ 69) + ((i20 & 69) << 1);
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i22 % 128;
                            if (i22 % 2 != 0) {
                                iArr2[1] = i2;
                                iArr[1] = i2;
                            } else {
                                iArr[0] = i2;
                                iArr2[0] = i2;
                            }
                            objArr2[3] = null;
                            int i23 = ~((int) Process.getStartElapsedRealtime());
                            int i24 = (((-469710298) + (((~(970185950 | i23)) | 8437824) * (-828))) + ((i23 | 970185950) * (-828))) - 155083076;
                            int i25 = i24 * (-167);
                            int i26 = i3 * (-167);
                            int i27 = ((i25 | i26) << 1) - (i25 ^ i26);
                            int i28 = ~i24;
                            int i29 = ~i3;
                            int i30 = ~((i28 & i29) | (i28 ^ i29));
                            int i31 = ~i3;
                            int i32 = ~(i31 | i2);
                            int i33 = i27 + (((i30 & i32) | (i30 ^ i32)) * 336);
                            int i34 = ~(i3 | i24);
                            int i35 = artificialFrame + 47;
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i35 % 128;
                            int i36 = i35 % 2;
                            int i37 = ~((i24 ^ i2) | (i24 & i2));
                            if (i36 != 0) {
                                int i38 = i33 / ((-168) / (i34 | i37));
                                int i39 = ~((~i2) | i24);
                                int i40 = -(-((i39 & i31) | (i31 ^ i39)));
                                int i41 = -((i40 ^ 168) + ((i40 & 168) << 1));
                                i16 = ((i38 | i41) << 1) - (i41 ^ i38);
                                i18 = 41;
                            } else {
                                int i42 = ~i2;
                                int i43 = ~((i42 & i24) | (i42 ^ i24));
                                i16 = i33 + (((i34 & i37) | (i34 ^ i37)) * (-168)) + (((i43 & i31) | (i31 ^ i43)) * 168);
                            }
                            int i44 = i16 << i18;
                            int i45 = (i44 | i16) & (~(i16 & i44));
                            int i46 = i45 >>> 17;
                            int i47 = ((~i45) & i46) | ((~i46) & i45);
                            ((int[]) objArr2[2])[0] = i47 ^ (i47 << 5);
                            return objArr2;
                        }
                        try {
                            int iResolveOpacity = Drawable.resolveOpacity(0, 0);
                            int i48 = iResolveOpacity * 659;
                            int i49 = (i48 & 1232517201) + (i48 | 1232517201);
                            int i50 = ~iResolveOpacity;
                            int i51 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                            int i52 = (i51 & 91) + (i51 | 91);
                            artificialFrame = i52 % 128;
                            int i53 = i52 % 2;
                            int i54 = ~((i50 & (-1727707585)) | (i50 ^ (-1727707585)));
                            int i55 = ~((1727707584 & iResolveOpacity) | (1727707584 ^ iResolveOpacity));
                            int i56 = (i54 & i55) | (i54 ^ i55);
                            int i57 = ~(iResolveOpacity | i2);
                            int i58 = (i49 - (~(-(-((-658) * ((i56 & i57) | (i56 ^ i57))))))) - 1;
                            int i59 = ~((1727707584 ^ iResolveOpacity) | (1727707584 & iResolveOpacity));
                            int i60 = i58 + (i59 * 658);
                            int i61 = ~((iResolveOpacity & i2) | (iResolveOpacity ^ i2));
                            int i62 = -(-(((i61 & i59) | (i59 ^ i61)) * 658));
                            int i63 = (i60 ^ i62) + ((i62 & i60) << 1);
                            int i64 = -(-(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)));
                            byte b = (byte) ((i64 ^ 9) + ((i64 & 9) << 1));
                            int i65 = -AndroidCharacter.getMirror('0');
                            int i66 = i65 * (-494);
                            int i67 = (i66 & 3952) + (i66 | 3952) + ((~((i65 ^ (-8)) | (i65 & (-8)))) * (-495));
                            int i68 = ~i2;
                            int i69 = i67 + (((i65 ^ i68) | (i65 & i68)) * 495);
                            int i70 = ~i65;
                            int i71 = artificialFrame + 75;
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i71 % 128;
                            int i72 = i71 % 2;
                            int i73 = ~((i70 ^ 7) | (i70 & 7));
                            int i74 = ~i2;
                            int i75 = ~((i65 & i74) | (i74 ^ i65));
                            int i76 = 495 * ((i75 & i73) | (i73 ^ i75));
                            int i77 = ((i69 | i76) << 1) - (i76 ^ i69);
                            int i78 = -(-TextUtils.getOffsetBefore("", 0));
                            int i79 = -(-(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)));
                            int i80 = (i79 ^ 1406071540) + ((i79 & 1406071540) << 1);
                            Object[] objArr3 = new Object[1];
                            a(i63, b, i77, (short) ((i78 ^ 74) + ((i78 & 74) << 1)), i80, objArr3);
                            Object[] objArr4 = (Object[]) Array.newInstance(Class.forName((String) objArr3[0]), 2);
                            int i81 = -(CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                            int i82 = i81 * 319;
                            int i83 = (i82 ^ (-317)) + ((i82 & (-317)) << 1);
                            int i84 = ~i81;
                            int i85 = ~((i84 & i2) | (i84 ^ i2));
                            int i86 = -(-(((i85 & (-2)) | ((-2) ^ i85)) * (-318)));
                            int i87 = (i83 & i86) + (i86 | i83);
                            int i88 = (i74 ^ i81) | (i74 & i81);
                            int i89 = (~(((-2) ^ i2) | ((-2) & i2))) | (~((i88 ^ 1) | (i88 & 1)));
                            int i90 = ~(((-1062704294) ^ i74) | ((-1062704294) & i74));
                            int i91 = (i90 ^ 256119812) | (i90 & 256119812);
                            int i92 = ~((i68 ^ (-264518741)) | (i68 & (-264518741)));
                            int i93 = (i91 ^ i92) | (i92 & i91);
                            int i94 = ~((1071103221 ^ i2) | (1071103221 & i2));
                            int i95 = (((-2119239557) - (~(((i93 ^ i94) | (i93 & i94)) * 590))) - (~((((~(((-1062704294) ^ i68) | ((-1062704294) & i68))) | 256119812) | (~((i74 ^ (-264518741)) | (i74 & (-264518741))))) * (-1180)))) - 1;
                            int i96 = ~(264518740 | i74);
                            int i97 = ~(1062704293 | i74);
                            int i98 = -(-(((i96 ^ i97) | (i96 & i97)) * 590));
                            int i99 = ((i95 | i98) << 1) - (i95 ^ i98);
                            int i100 = ~(694503791 | i2);
                            int i101 = ~((i74 ^ 710137315) | (i74 & 710137315));
                            int i102 = (i100 ^ i101) | (i100 & i101);
                            int i103 = ~(i74 | (-694503792));
                            int i104 = -(-(((i102 ^ i103) | (i102 & i103)) * (-516)));
                            int i105 = (1070295335 ^ i104) + ((i104 & 1070295335) << 1);
                            int i106 = ~(((-34772097) & i2) | ((-34772097) ^ i2));
                            int i107 = (-710137316) | i68;
                            int i108 = ~((i107 ^ (-694503792)) | (i107 & (-694503792)));
                            int i109 = ((i106 ^ i108) | (i106 & i108)) * 516;
                            int i110 = (i105 & i109) + (i105 | i109);
                            int i111 = ~((i68 ^ (-694503792)) | ((-694503792) & i68));
                            if (i99 <= (i110 - (~(-(-(((675365219 ^ i111) | (i111 & 675365219)) * 516))))) - 1) {
                                int i112 = i87 << (TypedValues.AttributesType.TYPE_PIVOT_TARGET / i89);
                                int i113 = ((-2) ^ i74) | ((-2) & i74);
                                int i114 = ~((i113 & i81) | (i113 ^ i81));
                                int i115 = ~(i81 | 1 | i2);
                                int i116 = -(TypedValues.AttributesType.TYPE_PIVOT_TARGET >>> ((i115 & i114) | (i114 ^ i115)));
                                Object[] objArr5 = new Object[1];
                                b((i112 ^ i116) + ((i116 & i112) << 1), new char[]{44271, 34595, 2436, 44204, 1396, 59866, 54487, 18704, 5725, 44756, 37308, 538, 55614, 25384, 23170, 50413, 39966, 6154, 2035, 31146, 18355, 56651, 49511, 12960, 2765, 37444, 35404, 63338, 52654, 18584, 14142, 43130, 45270, 3533, 61605}, objArr5);
                                str = (String) objArr5[0];
                                i4 = 0;
                            } else {
                                int i117 = (i87 - (~(i89 * TypedValues.AttributesType.TYPE_PIVOT_TARGET))) - 1;
                                int i118 = ((-2) ^ i74) | ((-2) & i74);
                                int i119 = ~((i118 & i81) | (i118 ^ i81));
                                int i120 = (i81 & 1) | (i81 ^ 1);
                                int i121 = ~((i120 & i2) | (i120 ^ i2));
                                int i122 = -(-(((i121 & i119) | (i119 ^ i121)) * TypedValues.AttributesType.TYPE_PIVOT_TARGET));
                                Object[] objArr6 = new Object[1];
                                b(((i117 | i122) << 1) - (i122 ^ i117), new char[]{44271, 34595, 2436, 44204, 1396, 59866, 54487, 18704, 5725, 44756, 37308, 538, 55614, 25384, 23170, 50413, 39966, 6154, 2035, 31146, 18355, 56651, 49511, 12960, 2765, 37444, 35404, 63338, 52654, 18584, 14142, 43130, 45270, 3533, 61605}, objArr6);
                                i4 = 0;
                                str = (String) objArr6[0];
                            }
                            try {
                                int packedPositionType = (-1727707585) - ExpandableListView.getPackedPositionType(0L);
                                byte bNormalizeMetaState = (byte) (KeyEvent.normalizeMetaState(i4) + 8);
                                int defaultSize = View.getDefaultSize(i4, i4);
                                int iICustomTabsCallbackStubProxy2 = com.google.android.gms.common.internal.Objects.ICustomTabsCallbackStubProxy();
                                int i123 = ~defaultSize;
                                int i124 = ~iICustomTabsCallbackStubProxy2;
                                int i125 = ~((i123 ^ i124) | (i123 & i124));
                                int i126 = ~((i123 ^ (-56)) | (i123 & (-56)));
                                int i127 = (i125 ^ i126) | (i125 & i126);
                                int i128 = ~(i124 | (-56));
                                int i129 = (((defaultSize * 398) + 22176) - (~(-(-(((i127 & i128) | (i127 ^ i128)) * (-397)))))) - 1;
                                int i130 = ~defaultSize;
                                int i131 = -(-((~((i130 ^ (-56)) | (i130 & (-56)))) * (-397)));
                                int i132 = (i129 ^ i131) + ((i129 & i131) << 1);
                                int i133 = ~((i130 ^ (-56)) | (i130 & (-56)));
                                int i134 = (iICustomTabsCallbackStubProxy2 & i133) | (iICustomTabsCallbackStubProxy2 ^ i133);
                                int i135 = ~((defaultSize & 55) | (55 ^ defaultSize));
                                int i136 = ((i134 & i135) | (i134 ^ i135)) * 397;
                                int i137 = (i132 ^ i136) + ((i136 & i132) << 1);
                                int maximumDrawingCacheSize = ViewConfiguration.getMaximumDrawingCacheSize() >> 24;
                                int iICustomTabsCallbackStubProxy3 = com.google.android.gms.common.internal.Objects.ICustomTabsCallbackStubProxy();
                                int i138 = ~iICustomTabsCallbackStubProxy3;
                                int i139 = (i138 & maximumDrawingCacheSize) | (i138 ^ maximumDrawingCacheSize);
                                int i140 = ((((maximumDrawingCacheSize * (-115)) - 8510) + ((~((i139 & 74) | (i139 ^ 74))) * (-116))) - (~((maximumDrawingCacheSize | iICustomTabsCallbackStubProxy3) * 116))) - 1;
                                int i141 = ~((~maximumDrawingCacheSize) | (-75));
                                int i142 = ~(iICustomTabsCallbackStubProxy3 | (-75));
                                short s = (short) (i140 + (((i141 & i142) | (i141 ^ i142)) * 116));
                                int i143 = -View.getDefaultSize(0, 0);
                                int iICustomTabsCallbackStubProxy4 = com.google.android.gms.common.internal.Objects.ICustomTabsCallbackStubProxy();
                                int i144 = i143 * 860;
                                int i145 = (((i144 & 476429714) + (i144 | 476429714)) - (~(((i143 ^ iICustomTabsCallbackStubProxy4) | (i143 & iICustomTabsCallbackStubProxy4)) * (-859)))) - 1;
                                int i146 = ~iICustomTabsCallbackStubProxy4;
                                int i147 = ~(i146 | i143);
                                int i148 = ~i143;
                                int i149 = (i148 ^ (-1406071540)) | (i148 & (-1406071540));
                                int i150 = ~((i149 ^ iICustomTabsCallbackStubProxy4) | (i149 & iICustomTabsCallbackStubProxy4));
                                int i151 = ((i150 & i147) | (i147 ^ i150)) * 859;
                                int i152 = ((i145 | i151) << 1) - (i145 ^ i151);
                                int i153 = -(-(((~(((-1406071540) & i143) | ((-1406071540) ^ i143))) | (~(((-1406071540) ^ i146) | ((-1406071540) & i146)))) * 859));
                                int i154 = (i152 ^ i153) + ((i153 & i152) << 1);
                                Object[] objArr7 = new Object[1];
                                a(packedPositionType, bNormalizeMetaState, i137, s, i154, objArr7);
                                objArr4[0] = Class.forName((String) objArr7[0]).getDeclaredConstructor(String.class).newInstance(str);
                                Object[] objArr8 = new Object[1];
                                b((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), new char[]{63801, 41260, 60175, 63866, 49841, 53158, 13876, 36551, 17353, 35056, 29560, 50673, 36079, 17703, 47195, 771, 51652, 15875, 58657, 48715, 4615, 64310, 9104, 62794, 24337, 46173, 26842, 12457, 39029, 28371, 54749, 28569, 58719, 11234, 4634}, objArr8);
                                String str3 = (String) objArr8[0];
                                int i155 = artificialFrame;
                                int i156 = (i155 & 53) + (i155 | 53);
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i156 % 128;
                                int i157 = i156 % 2;
                                int i158 = i155 + 3;
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i158 % 128;
                                int i159 = i158 % 2;
                                try {
                                    Object[] objArr9 = {str3};
                                    int i160 = (-1727707587) - (~(-TextUtils.lastIndexOf("", '0', 0, 0)));
                                    int jumpTapTimeout = ViewConfiguration.getJumpTapTimeout() >> 16;
                                    int iResolveSizeAndState = View.resolveSizeAndState(0, 0, 0);
                                    int iICustomTabsCallbackStubProxy5 = com.google.android.gms.common.internal.Objects.ICustomTabsCallbackStubProxy();
                                    int i161 = iResolveSizeAndState * (-244);
                                    int i162 = (i161 & (-13776)) + (i161 | (-13776));
                                    int i163 = ~iICustomTabsCallbackStubProxy5;
                                    int i164 = ~((i163 & 55) | (55 ^ i163));
                                    int i165 = ~(55 | iResolveSizeAndState);
                                    int i166 = (i162 - (~(((i164 ^ i165) | (i164 & i165)) * (-245)))) - 1;
                                    int i167 = (~(55 | iICustomTabsCallbackStubProxy5)) * (-245);
                                    int i168 = (i166 ^ i167) + ((i167 & i166) << 1);
                                    int i169 = ~((iICustomTabsCallbackStubProxy5 & 55) | (55 ^ iICustomTabsCallbackStubProxy5));
                                    int i170 = ((i169 & iResolveSizeAndState) | (iResolveSizeAndState ^ i169)) * 245;
                                    Object[] objArr10 = new Object[1];
                                    a(i160, (byte) ((jumpTapTimeout ^ 8) + ((jumpTapTimeout & 8) << 1)), (i168 ^ i170) + ((i170 & i168) << 1), (short) (73 - (~(-Gravity.getAbsoluteGravity(0, 0)))), (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 1406071539, objArr10);
                                    objArr4[1] = Class.forName((String) objArr10[0]).getDeclaredConstructor(String.class).newInstance(objArr9);
                                    try {
                                        int i171 = -(-TextUtils.indexOf("", "", 0, 0));
                                        int i172 = ((i171 | (-1727707594)) << 1) - (i171 ^ (-1727707594));
                                        int i173 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
                                        int iLastIndexOf = (-57) - TextUtils.lastIndexOf("", '0');
                                        int i174 = -View.combineMeasuredStates(0, 0);
                                        int i175 = -ExpandableListView.getPackedPositionType(0L);
                                        int i176 = (i175 & 1406071577) + (i175 | 1406071577);
                                        Object[] objArr11 = new Object[1];
                                        a(i172, (byte) ((i173 ^ 27) + ((i173 & 27) << 1)), iLastIndexOf, (short) ((i174 & (-119)) + (i174 | (-119))), i176, objArr11);
                                        Class<?> cls = Class.forName((String) objArr11[0]);
                                        Object[] objArr12 = new Object[1];
                                        b((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 1, new char[]{11837, 12977, 4647, 11866, 53400, 23651, 53053, 40173, 38016, 6977, 35334, 55288, 23522, 54971, 16716, 4388, 7879, 44443, 7234, 44100, 50495}, objArr12);
                                        Object objInvoke = cls.getMethod((String) objArr12[0], null).invoke(context, null);
                                        try {
                                            int i177 = (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1727707595;
                                            int longPressTimeout = ViewConfiguration.getLongPressTimeout() >> 16;
                                            int i178 = -(Process.myPid() >> 22);
                                            int iICustomTabsCallbackStubProxy6 = com.google.android.gms.common.internal.Objects.ICustomTabsCallbackStubProxy();
                                            int i179 = i178 * (-1335);
                                            int i180 = ((i179 | 37352) << 1) - (i179 ^ 37352);
                                            int i181 = (i178 ^ iICustomTabsCallbackStubProxy6) | (i178 & iICustomTabsCallbackStubProxy6);
                                            int i182 = ~i181;
                                            int i183 = ((55 ^ i182) | (i182 & 55)) * (-668);
                                            int i184 = (i180 ^ i183) + ((i183 & i180) << 1);
                                            int i185 = ~((iICustomTabsCallbackStubProxy6 & 55) | (55 ^ iICustomTabsCallbackStubProxy6));
                                            int i186 = -(-(((i178 & i185) | (i178 ^ i185)) * 1336));
                                            int i187 = (i184 ^ i186) + ((i184 & i186) << 1);
                                            int i188 = ((i181 ^ 55) | (i181 & 55)) * 668;
                                            int i189 = (i187 & i188) + (i188 | i187);
                                            int i190 = -(SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
                                            Object[] objArr13 = new Object[1];
                                            a(i177, (byte) ((longPressTimeout ^ 28) + ((longPressTimeout & 28) << 1)), i189, (short) (((i190 | (-118)) << 1) - (i190 ^ (-118))), 1406071576 - (~(-View.resolveSizeAndState(0, 0, 0))), objArr13);
                                            Class<?> cls2 = Class.forName((String) objArr13[0]);
                                            int iIndexOf2 = (-1727707589) - TextUtils.indexOf((CharSequence) "", '0');
                                            int i191 = (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                                            int offsetAfter = (-56) - TextUtils.getOffsetAfter("", 0);
                                            short fadingEdgeLength = (short) ((-75) - (ViewConfiguration.getFadingEdgeLength() >> 16));
                                            int threadPriority = Process.getThreadPriority(0);
                                            int i192 = (((threadPriority | 20) << 1) - (threadPriority ^ 20)) >> 6;
                                            int i193 = i192 * 165;
                                            int i194 = ~((i74 ^ 1406071600) | (i74 & 1406071600));
                                            int i195 = (i193 & (-1556404112)) + (i193 | (-1556404112)) + (((i192 ^ i194) | (i194 & i192)) * (-328));
                                            int i196 = ((i192 ^ i2) | (i192 & i2)) * 164;
                                            int i197 = (i195 & i196) + (i196 | i195);
                                            int i198 = ~i192;
                                            int i199 = ~((i198 ^ (-1406071601)) | (i198 & (-1406071601)));
                                            int i200 = ~(((-1406071601) ^ i2) | ((-1406071601) & i2));
                                            int i201 = (i199 ^ i200) | (i199 & i200);
                                            int i202 = i192 | i68;
                                            int i203 = ~((i202 & 1406071600) | (i202 ^ 1406071600));
                                            int i204 = i197 + (((i203 & i201) | (i201 ^ i203)) * 164);
                                            Object[] objArr14 = new Object[1];
                                            a(iIndexOf2, (byte) ((i191 ^ 59) + ((i191 & 59) << 1)), offsetAfter, fadingEdgeLength, i204, objArr14);
                                            Object objInvoke2 = cls2.getMethod((String) objArr14[0], null).invoke(context, null);
                                            int i205 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                            int i206 = (i205 & 71) + (i205 | 71);
                                            artificialFrame = i206 % 128;
                                            int i207 = i206 % 2;
                                            try {
                                                Object[] objArr15 = {objInvoke2, 64};
                                                int threadPriority2 = Process.getThreadPriority(0);
                                                int i208 = ((threadPriority2 & 20) + (threadPriority2 | 20)) >> 6;
                                                int iICustomTabsCallbackStubProxy7 = com.google.android.gms.common.internal.Objects.ICustomTabsCallbackStubProxy();
                                                int i209 = ~iICustomTabsCallbackStubProxy7;
                                                int i210 = (i208 * (-51)) + 53 + ((~(i209 | i208 | 1)) * 52);
                                                int i211 = ~((i209 & (-2)) | ((-2) ^ i209));
                                                int i212 = ~(((-2) & i208) | ((-2) ^ i208));
                                                int i213 = (i211 & i212) | (i211 ^ i212);
                                                int i214 = ~iICustomTabsCallbackStubProxy7;
                                                int i215 = ~((i214 ^ i208) | (i214 & i208));
                                                int i216 = artificialFrame;
                                                int i217 = (i216 ^ 21) + ((i216 & 21) << 1);
                                                getARTIFICIAL_FRAME_PACKAGE_NAME = i217 % 128;
                                                int i218 = i217 % 2;
                                                int i219 = (i210 - (~(-(-((-52) * ((i213 & i215) | (i213 ^ i215))))))) - 1;
                                                int i220 = ~i208;
                                                int i221 = ~((i214 & i220) | (i220 ^ i214));
                                                int i222 = ~i208;
                                                int i223 = ~((i222 & 1) | (i222 ^ 1));
                                                int i224 = (i219 - (~(-(-(((i223 & i221) | (i221 ^ i223)) * 52))))) - 1;
                                                Object[] objArr16 = new Object[1];
                                                b(i224, new char[]{5893, 62238, 11905, 5988, 52707, 40391, 62347, 33204, 44470, 56036, 46767, 51916, 25310, 5918, 32201, 3146, 10228, 27707, 8439, 45428, 64517, 43348, 58993, 64038, 45352, 59006, 44368, 16371, 30282, 15524, 4186, 24783, 2927, 31172, 55188, 42415, 49559}, objArr16);
                                                Class<?> cls3 = Class.forName((String) objArr16[0]);
                                                int absoluteGravity = (-1727707588) - Gravity.getAbsoluteGravity(0, 0);
                                                int i225 = -ExpandableListView.getPackedPositionChild(0L);
                                                int keyRepeatDelay = (ViewConfiguration.getKeyRepeatDelay() >> 16) - 56;
                                                int i226 = -Color.argb(0, 0, 0, 0);
                                                int mode = View.MeasureSpec.getMode(0);
                                                int iICustomTabsCallbackStubProxy8 = com.google.android.gms.common.internal.Objects.ICustomTabsCallbackStubProxy();
                                                int i227 = (mode * 755) + 2084996770;
                                                int i228 = ~mode;
                                                int i229 = (i228 ^ 1406071614) | (i228 & 1406071614);
                                                int i230 = ~i229;
                                                int i231 = ~mode;
                                                int i232 = ~((i231 ^ iICustomTabsCallbackStubProxy8) | (i231 & iICustomTabsCallbackStubProxy8));
                                                int i233 = ((i230 ^ i232) | (i232 & i230) | (~((iICustomTabsCallbackStubProxy8 ^ 1406071614) | (iICustomTabsCallbackStubProxy8 & 1406071614)))) * (-754);
                                                int i234 = (i227 ^ i233) + ((i233 & i227) << 1);
                                                int i235 = ~((i229 ^ iICustomTabsCallbackStubProxy8) | (i229 & iICustomTabsCallbackStubProxy8));
                                                int i236 = ~iICustomTabsCallbackStubProxy8;
                                                int i237 = ~((mode & i236) | (i236 ^ mode) | 1406071614);
                                                int i238 = i234 + (((i235 & i237) | (i235 ^ i237)) * (-754));
                                                int i239 = (i231 | (~iICustomTabsCallbackStubProxy8)) * 754;
                                                int i240 = (i238 ^ i239) + ((i239 & i238) << 1);
                                                Object[] objArr17 = new Object[1];
                                                a(absoluteGravity, (byte) ((i225 & (-30)) + (i225 | (-30))), keyRepeatDelay, (short) ((i226 ^ 118) + ((i226 & 118) << 1)), i240, objArr17);
                                                Method method2 = cls3.getMethod((String) objArr17[0], String.class, Integer.TYPE);
                                                int i241 = artificialFrame;
                                                int i242 = (i241 ^ 11) + ((i241 & 11) << 1);
                                                getARTIFICIAL_FRAME_PACKAGE_NAME = i242 % 128;
                                                int i243 = i242 % 2;
                                                Object objInvoke3 = method2.invoke(objInvoke, objArr15);
                                                int i244 = -(-TextUtils.indexOf((CharSequence) "", '0', 0));
                                                int i245 = (i244 ^ (-1727707593)) + ((i244 & (-1727707593)) << 1);
                                                int i246 = -(ViewConfiguration.getScrollBarSize() >> 8);
                                                byte b2 = (byte) ((i246 ^ 6) + ((i246 & 6) << 1));
                                                int i247 = (-57) - (~(-TextUtils.getOffsetAfter("", 0)));
                                                int i248 = -(ViewConfiguration.getTapTimeout() >> 16);
                                                short s2 = (short) (((i248 | (-44)) << 1) - (i248 ^ (-44)));
                                                int i249 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                int i250 = (i249 & 83) + (i249 | 83);
                                                artificialFrame = i250 % 128;
                                                int i251 = i250 % 2;
                                                Object[] objArr18 = new Object[1];
                                                a(i245, b2, i247, s2, ExpandableListView.getPackedPositionType(0L) + 1406071628, objArr18);
                                                Class<?> cls4 = Class.forName((String) objArr18[0]);
                                                int scrollDefaultDelay = ViewConfiguration.getScrollDefaultDelay() >> 16;
                                                Object[] objArr19 = new Object[1];
                                                b((scrollDefaultDelay ^ 1) + ((scrollDefaultDelay & 1) << 1), new char[]{47730, 8560, 11973, 47617, 33973, 20398, 62412, 51454, 207, 2199, 46842, 33734, 53167, 50540}, objArr19);
                                                Object[] objArr20 = (Object[]) cls4.getField((String) objArr19[0]).get(objInvoke3);
                                                int length = objArr20.length;
                                                int i252 = 0;
                                                while (i252 < length) {
                                                    Object obj = objArr20[i252];
                                                    Object[] objArr21 = new Object[1];
                                                    b(-Process.getGidForName(str2), new char[]{13527, 1048, 29177, 13455, 999, 27265, 44194, 20466, 36402}, objArr21);
                                                    try {
                                                        Object[] objArr22 = {(String) objArr21[0]};
                                                        int offsetBefore = TextUtils.getOffsetBefore(str2, 0);
                                                        int iICustomTabsCallbackStubProxy9 = com.google.android.gms.common.internal.Objects.ICustomTabsCallbackStubProxy();
                                                        int i253 = offsetBefore * 370;
                                                        int i254 = (i253 & 698320654) + (i253 | 698320654);
                                                        int i255 = ~iICustomTabsCallbackStubProxy9;
                                                        int i256 = -(-(((offsetBefore ^ (-1727707585)) | (offsetBefore & (-1727707585)) | i255) * (-369)));
                                                        int i257 = (i254 ^ i256) + ((i256 & i254) << 1);
                                                        int i258 = ~offsetBefore;
                                                        int i259 = ~((i258 & i255) | (i258 ^ i255));
                                                        int i260 = ((i259 & (-1727707585)) | (i259 ^ (-1727707585))) * (-369);
                                                        int i261 = ((i257 | i260) << 1) - (i260 ^ i257);
                                                        int i262 = ~((1727707584 ^ offsetBefore) | (1727707584 & offsetBefore));
                                                        int i263 = ~((offsetBefore ^ iICustomTabsCallbackStubProxy9) | (offsetBefore & iICustomTabsCallbackStubProxy9));
                                                        int i264 = (i262 & i263) | (i262 ^ i263);
                                                        int i265 = (~iICustomTabsCallbackStubProxy9) | (~offsetBefore);
                                                        int i266 = ~((i265 & (-1727707585)) | (i265 ^ (-1727707585)));
                                                        int i267 = -(-(((i266 & i264) | (i264 ^ i266)) * 369));
                                                        int i268 = ((i261 | i267) << 1) - (i267 ^ i261);
                                                        int i269 = -TextUtils.indexOf(str2, str2);
                                                        int iICustomTabsCallbackStubProxy10 = com.google.android.gms.common.internal.Objects.ICustomTabsCallbackStubProxy();
                                                        int i270 = (i269 * (-830)) - 34112;
                                                        int i271 = ~iICustomTabsCallbackStubProxy10;
                                                        int i272 = ~((i271 & 40) | (40 ^ i271));
                                                        int i273 = (i269 ^ (-41)) | (i269 & (-41));
                                                        int i274 = ~((i273 ^ iICustomTabsCallbackStubProxy10) | (i273 & iICustomTabsCallbackStubProxy10));
                                                        int i275 = ((i272 ^ i274) | (i272 & i274)) * (-831);
                                                        int i276 = (i270 ^ i275) + ((i270 & i275) << 1);
                                                        int i277 = (40 ^ i269) | (40 & i269);
                                                        int i278 = (i276 - (~(-(-((~((i277 & iICustomTabsCallbackStubProxy10) | (i277 ^ iICustomTabsCallbackStubProxy10))) * (-1662)))))) - 1;
                                                        int i279 = ~((~i269) | (~iICustomTabsCallbackStubProxy10));
                                                        int i280 = ~(i269 | iICustomTabsCallbackStubProxy10);
                                                        int i281 = (i280 & i279) | (i279 ^ i280);
                                                        int i282 = ~((iICustomTabsCallbackStubProxy10 & (-41)) | (iICustomTabsCallbackStubProxy10 ^ (-41)));
                                                        byte b3 = (byte) (i278 + (((i281 & i282) | (i281 ^ i282)) * 831));
                                                        int mirror = 65528 - AndroidCharacter.getMirror('0');
                                                        int deadChar = KeyEvent.getDeadChar(0, 0);
                                                        int i283 = -TextUtils.indexOf(str2, str2, 0, 0);
                                                        int i284 = ((i283 | 1406071658) << 1) - (i283 ^ 1406071658);
                                                        Object[] objArr23 = new Object[1];
                                                        a(i268, b3, mirror, (short) (((deadChar | (-39)) << 1) - (deadChar ^ (-39))), i284, objArr23);
                                                        Class<?> cls5 = Class.forName((String) objArr23[0]);
                                                        Object[] objArr24 = new Object[1];
                                                        b((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), new char[]{8695, 37833, 7617, 8592, 10881, 64795, 49371, 26349, 39749, 47657, 34303, 11745, 21537, 30661, 20098}, objArr24);
                                                        Object objInvoke4 = cls5.getMethod((String) objArr24[0], String.class).invoke(null, objArr22);
                                                        try {
                                                            byte modifierMetaStateMask = (byte) KeyEvent.getModifierMetaStateMask();
                                                            int i285 = (modifierMetaStateMask ^ (-1727707593)) + ((modifierMetaStateMask & (-1727707593)) << 1);
                                                            int i286 = -(-KeyEvent.normalizeMetaState(0));
                                                            byte b4 = (byte) ((i286 ^ (-16)) + ((i286 & (-16)) << 1));
                                                            int i287 = -View.getDefaultSize(0, 0);
                                                            int i288 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                            int i289 = ((i288 | 87) << 1) - (i288 ^ 87);
                                                            artificialFrame = i289 % 128;
                                                            if (i289 % 2 == 0) {
                                                                iICustomTabsCallbackStubProxy = com.google.android.gms.common.internal.Objects.ICustomTabsCallbackStubProxy();
                                                                int i290 = 904 - (~(-i287));
                                                                i5 = (i290 ^ 50568) + ((i290 & 50568) << 1);
                                                            } else {
                                                                iICustomTabsCallbackStubProxy = com.google.android.gms.common.internal.Objects.ICustomTabsCallbackStubProxy();
                                                                i5 = (i287 * TypedValues.Custom.TYPE_DIMENSION) + 50568;
                                                            }
                                                            int i291 = ~i287;
                                                            int i292 = ~((i291 ^ iICustomTabsCallbackStubProxy) | (i291 & iICustomTabsCallbackStubProxy));
                                                            int i293 = ~iICustomTabsCallbackStubProxy;
                                                            Object[] objArr25 = objArr20;
                                                            int i294 = ~(i293 | (-56));
                                                            int i295 = i5 + ((-1808) * ((i292 ^ i294) | (i294 & i292)));
                                                            int i296 = (i291 ^ 55) | (i291 & 55);
                                                            int i297 = ~((i296 & iICustomTabsCallbackStubProxy) | (i296 ^ iICustomTabsCallbackStubProxy));
                                                            int i298 = (i293 & i287) | (i293 ^ i287);
                                                            int i299 = artificialFrame + 93;
                                                            int i300 = length;
                                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i299 % 128;
                                                            int i301 = i299 % 2;
                                                            int i302 = ~((i298 & (-56)) | (i298 ^ (-56)));
                                                            int i303 = i301 != 0 ? -(TypedValues.Custom.TYPE_BOOLEAN >> ((i297 & i302) | (i297 ^ i302))) : (i297 | i302) * TypedValues.Custom.TYPE_BOOLEAN;
                                                            int i304 = (i295 & i303) + (i295 | i303);
                                                            int i305 = ~((i291 ^ (-56)) | (i291 & (-56)));
                                                            int i306 = ~((55 ^ iICustomTabsCallbackStubProxy) | (55 & iICustomTabsCallbackStubProxy));
                                                            int i307 = (i305 & i306) | (i305 ^ i306);
                                                            int i308 = ~iICustomTabsCallbackStubProxy;
                                                            int i309 = -(-(TypedValues.Custom.TYPE_BOOLEAN * (i307 | (~((i287 & i308) | (i308 ^ i287))))));
                                                            int i310 = (i304 ^ i309) + ((i309 & i304) << 1);
                                                            short s3 = (short) ((-73) - (~(-(ViewConfiguration.getScrollBarSize() >> 8))));
                                                            int i311 = -(-(ViewConfiguration.getKeyRepeatDelay() >> 16));
                                                            int i312 = (i311 ^ 1406071695) + ((i311 & 1406071695) << 1);
                                                            Object[] objArr26 = new Object[1];
                                                            a(i285, b4, i310, s3, i312, objArr26);
                                                            Class<?> cls6 = Class.forName((String) objArr26[0]);
                                                            Object[] objArr27 = new Object[1];
                                                            b((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), new char[]{14777, 51843, 59677, 14797, 7538, 42075, 13361, 20782, 33553, 58229, 28950, 6657, 19571, 11917, 47682}, objArr27);
                                                            try {
                                                                Object[] objArr28 = {new ByteArrayInputStream((byte[]) cls6.getMethod((String) objArr27[0], null).invoke(obj, null))};
                                                                int i313 = -(-KeyEvent.normalizeMetaState(0));
                                                                int i314 = -(-View.MeasureSpec.getMode(0));
                                                                int i315 = (-58) - (~(-TextUtils.lastIndexOf(str2, '0', 0)));
                                                                int i316 = -(-TextUtils.indexOf(str2, str2, 0, 0));
                                                                int i317 = -(AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                                                                int i318 = (i317 ^ 1406071659) + ((i317 & 1406071659) << 1);
                                                                Object[] objArr29 = new Object[1];
                                                                a(((i313 | (-1727707585)) << 1) - (i313 ^ (-1727707585)), (byte) ((i314 ^ (-41)) + ((i314 & (-41)) << 1)), i315, (short) ((i316 ^ (-39)) + ((i316 & (-39)) << 1)), i318, objArr29);
                                                                Class<?> cls7 = Class.forName((String) objArr29[0]);
                                                                int iResolveSize = View.resolveSize(0, 0);
                                                                int iICustomTabsCallbackStubProxy11 = com.google.android.gms.common.internal.Objects.ICustomTabsCallbackStubProxy();
                                                                int i319 = iResolveSize * 980;
                                                                int i320 = (i319 ^ (-978)) + ((i319 & (-978)) << 1);
                                                                int i321 = ~iICustomTabsCallbackStubProxy11;
                                                                int i322 = (~((-2) | i321)) * 979;
                                                                int i323 = (((i320 & i322) + (i320 | i322)) - (~(-(-((iResolveSize | iICustomTabsCallbackStubProxy11) * (-979)))))) - 1;
                                                                int i324 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                                int i325 = (i324 ^ b.f40o) + ((i324 & b.f40o) << 1);
                                                                int i326 = i325 % 128;
                                                                artificialFrame = i326;
                                                                int i327 = i325 % 2;
                                                                int i328 = ((~((iICustomTabsCallbackStubProxy11 & (-2)) | ((-2) ^ iICustomTabsCallbackStubProxy11))) | (~((iResolveSize & i321) | (i321 ^ iResolveSize)))) * 979;
                                                                int i329 = (i326 ^ 87) + ((i326 & 87) << 1);
                                                                getARTIFICIAL_FRAME_PACKAGE_NAME = i329 % 128;
                                                                if (i329 % 2 != 0) {
                                                                    Object[] objArr30 = new Object[1];
                                                                    b(i323 % i328, new char[]{23261, 59164, 53419, 23226, 56831, 35278, 3499, 37311, 57459, 52974, 18581, 55963, 12070, 790, 33791, 7254, 27168, 30769, 57024, 41253, 45516, 48463, 6160}, objArr30);
                                                                    String str4 = (String) objArr30[0];
                                                                    Class<?>[] clsArr = new Class[1];
                                                                    clsArr[1] = InputStream.class;
                                                                    method = cls7.getMethod(str4, clsArr);
                                                                } else {
                                                                    Object[] objArr31 = new Object[1];
                                                                    b((i323 ^ i328) + ((i328 & i323) << 1), new char[]{23261, 59164, 53419, 23226, 56831, 35278, 3499, 37311, 57459, 52974, 18581, 55963, 12070, 790, 33791, 7254, 27168, 30769, 57024, 41253, 45516, 48463, 6160}, objArr31);
                                                                    method = cls7.getMethod((String) objArr31[0], InputStream.class);
                                                                }
                                                                Object objInvoke5 = method.invoke(objInvoke4, objArr28);
                                                                int i330 = getARTIFICIAL_FRAME_PACKAGE_NAME + 3;
                                                                artificialFrame = i330 % 128;
                                                                if (i330 % 2 == 0) {
                                                                    int length2 = objArr4.length;
                                                                    i6 = 1;
                                                                } else {
                                                                    int length3 = objArr4.length;
                                                                    i6 = 0;
                                                                }
                                                                for (int i331 = 2; i6 < i331; i331 = 2) {
                                                                    Object obj2 = objArr4[i6];
                                                                    try {
                                                                        Object[] objArr32 = new Object[1];
                                                                        b(1 - (Process.myPid() >> 22), new char[]{48408, 35073, 40836, 48498, 9327, 59351, 17052, 26667, 2026, 41185, 1963, 8973, 51413, 27932, 52427, 58822, 36341, 5732, 37349, 22707, 22042, 54098, 22388, 5026, 7009, 39986, 7175, 54877, 56405, 18092, 41318, 35147, 41338, 979, 26261, 19495, 27532, 52467}, objArr32);
                                                                        Class<?> cls8 = Class.forName((String) objArr32[0]);
                                                                        int i332 = -TextUtils.getTrimmedLength(str2);
                                                                        int i333 = (i332 ^ (-1727707588)) + ((i332 & (-1727707588)) << 1);
                                                                        int i334 = -(-TextUtils.lastIndexOf(str2, '0'));
                                                                        byte b5 = (byte) ((i334 & 64) + (i334 | 64));
                                                                        int i335 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                                        int i336 = ((i335 | 67) << 1) - (i335 ^ 67);
                                                                        artificialFrame = i336 % 128;
                                                                        if (i336 % 2 == 0) {
                                                                            int iIndexOf3 = TextUtils.indexOf((CharSequence) str2, '9', 0);
                                                                            i7 = (866 >>> iIndexOf3) * (-919);
                                                                            iIndexOf = iIndexOf3;
                                                                        } else {
                                                                            iIndexOf = TextUtils.indexOf((CharSequence) str2, '0', 0);
                                                                            int i337 = iIndexOf * 866;
                                                                            i7 = (i337 & 47520) + (i337 | 47520);
                                                                        }
                                                                        int i338 = ~((~iIndexOf) | i74);
                                                                        int i339 = -(-(((54 ^ i338) | (54 & i338)) * (-865)));
                                                                        int i340 = (i7 & i339) + (i7 | i339);
                                                                        int i341 = (~((iIndexOf ^ i2) | (iIndexOf & i2))) * 865;
                                                                        int i342 = (i340 ^ i341) + ((i340 & i341) << 1);
                                                                        int i343 = ~((54 ^ i74) | (54 & i74));
                                                                        int i344 = ~((i74 ^ iIndexOf) | (iIndexOf & i74));
                                                                        int i345 = ((i343 ^ i344) | (i343 & i344)) * 865;
                                                                        int i346 = ((i342 | i345) << 1) - (i345 ^ i342);
                                                                        int i347 = -(ViewConfiguration.getMaximumFlingVelocity() >> 16);
                                                                        int i348 = getARTIFICIAL_FRAME_PACKAGE_NAME + 87;
                                                                        int i349 = i348 % 128;
                                                                        artificialFrame = i349;
                                                                        if (i348 % 2 == 0) {
                                                                            i8 = (-589) / i347;
                                                                            int i350 = ~(9 | i74);
                                                                            int i351 = ~((9 ^ i347) | (9 & i347));
                                                                            i9 = (i350 ^ i351) | (i350 & i351);
                                                                        } else {
                                                                            int i352 = i347 * (-589);
                                                                            i8 = (i352 & (-5910)) + (i352 | (-5910));
                                                                            int i353 = ~((9 ^ i74) | (9 & i74));
                                                                            int i354 = ~(9 | i347);
                                                                            i9 = (i354 & i353) | (i353 ^ i354);
                                                                        }
                                                                        int i355 = ~((i74 ^ i347) | (i74 & i347));
                                                                        int i356 = (i9 & i355) | (i9 ^ i355);
                                                                        int i357 = ~i347;
                                                                        int i358 = (i357 ^ (-10)) | (i357 & (-10));
                                                                        int i359 = ~((i358 ^ i2) | (i358 & i2));
                                                                        int i360 = i8 + (((i356 ^ i359) | (i356 & i359)) * 590);
                                                                        int i361 = ~((9 ^ i74) | (9 & i74));
                                                                        int i362 = i349 + 13;
                                                                        int i363 = i362 % 128;
                                                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i363;
                                                                        String str5 = str2;
                                                                        if (i362 % 2 != 0) {
                                                                            int i364 = ~((9 ^ i347) | (9 & i347));
                                                                            int i365 = (i361 ^ i364) | (i361 & i364);
                                                                            int i366 = ~(i68 | i347);
                                                                            i10 = i360 * ((-1180) >> ((i365 & i366) | (i365 ^ i366)));
                                                                            i11 = ~((i357 ^ i68) | (i357 & i68));
                                                                            i12 = i74;
                                                                        } else {
                                                                            int i367 = ~((9 ^ i347) | (9 & i347));
                                                                            int i368 = (i361 ^ i367) | (i361 & i367);
                                                                            int i369 = ~(i347 | i74);
                                                                            i10 = i360 + (((i368 & i369) | (i368 ^ i369)) * (-1180));
                                                                            i11 = ~((i357 ^ i74) | (i357 & i74));
                                                                            i12 = i68;
                                                                        }
                                                                        int i370 = i363 + 67;
                                                                        artificialFrame = i370 % 128;
                                                                        int i371 = i370 % 2;
                                                                        int i372 = ~((i12 & (-10)) | (i12 ^ (-10)));
                                                                        short s4 = (short) (i10 + (590 * ((i11 & i372) | (i11 ^ i372))));
                                                                        int size = View.MeasureSpec.getSize(0);
                                                                        Object[] objArr33 = new Object[1];
                                                                        a(i333, b5, i346, s4, ((size | 1406071723) << 1) - (1406071723 ^ size), objArr33);
                                                                        if (obj2.equals(cls8.getMethod((String) objArr33[0], null).invoke(objInvoke5, null))) {
                                                                            int iICustomTabsCallbackStubProxy12 = com.google.android.gms.common.internal.Objects.ICustomTabsCallbackStubProxy();
                                                                            int i373 = ~iICustomTabsCallbackStubProxy12;
                                                                            int i374 = ((i373 & (-1375767557)) | ((-1375767557) ^ i373)) * SyslogConstants.LOG_LOCAL7;
                                                                            int i375 = ((-96148785) & i374) + (i374 | (-96148785));
                                                                            int i376 = ~iICustomTabsCallbackStubProxy12;
                                                                            int i377 = (~((i376 & 167735923) | (i376 ^ 167735923))) | 152711776;
                                                                            int i378 = -(-(((i377 & (-1543503480)) | (i377 ^ (-1543503480))) * SyslogConstants.LOG_LOCAL7));
                                                                            int i379 = (i375 & i378) + (i378 | i375);
                                                                            int i380 = ~(((-118274234) & i74) | ((-118274234) ^ i74));
                                                                            int i381 = ~((-1226275853) | i2);
                                                                            int i382 = 1739252983 + (((i380 & i381) | (i380 ^ i381)) * JfifUtil.MARKER_EOI) + (((~(((-118274234) & i2) | ((-118274234) ^ i2))) | 17053704) * JfifUtil.MARKER_EOI);
                                                                            int i383 = ~(((-1226275853) & i74) | ((-1226275853) ^ i74));
                                                                            int i384 = -(-(((i383 & 118274233) | (118274233 ^ i383)) * JfifUtil.MARKER_EOI));
                                                                            if (i379 <= (i382 & i384) + (i384 | i382)) {
                                                                                i14 = 0;
                                                                                c = 1;
                                                                                i13 = (~(i2 & 1)) & (i2 | 1);
                                                                                objArr = new Object[5];
                                                                            } else {
                                                                                i13 = (i2 & (-2)) | (i74 & 1);
                                                                                objArr = new Object[4];
                                                                                i14 = 1;
                                                                                c = 0;
                                                                            }
                                                                            objArr[c] = new int[i14];
                                                                            objArr[1] = new int[]{i13};
                                                                            objArr[2] = new int[1];
                                                                            ((int[]) objArr[0])[0] = i2;
                                                                            objArr[3] = null;
                                                                            int i385 = getARTIFICIAL_FRAME_PACKAGE_NAME + 45;
                                                                            artificialFrame = i385 % 128;
                                                                            if (i385 % 2 == 0) {
                                                                                int i386 = (-331426088) + (((~((-767125977) | i74)) | 555763864) * (-245));
                                                                                int i387 = ~((-767125977) | i2);
                                                                                int i388 = i386 + (i387 * (-245)) + ((i387 | 211497798) * 245);
                                                                                int i389 = -(-(((i388 | 16) << 1) - (i388 ^ 16)));
                                                                                i15 = ((i3 | i389) << 1) - (i3 ^ i389);
                                                                            } else {
                                                                                int iUptimeMillis = (int) SystemClock.uptimeMillis();
                                                                                int i390 = ~iUptimeMillis;
                                                                                int i391 = 844030607 + (((~(i390 | 534403099)) | (-536501532) | (~((-442122244) | iUptimeMillis))) * 717) + (((~(iUptimeMillis | 534403099)) | (~(i390 | (-442122244))) | (-536501532)) * 717) + 16;
                                                                                i15 = (i3 ^ i391) + ((i3 & i391) << 1);
                                                                            }
                                                                            int i392 = i15 << 13;
                                                                            int i393 = (i392 & (~i15)) | ((~i392) & i15);
                                                                            int i394 = i393 ^ (i393 >>> 17);
                                                                            ((int[]) objArr[2])[0] = i394 ^ (i394 << 5);
                                                                            int i395 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                                            int i396 = (i395 & 55) + (i395 | 55);
                                                                            artificialFrame = i396 % 128;
                                                                            int i397 = i396 % 2;
                                                                            return objArr;
                                                                        }
                                                                        i6 = (i6 | 1) + (i6 & 1);
                                                                        str2 = str5;
                                                                    } catch (Throwable th7) {
                                                                        Throwable cause = th7.getCause();
                                                                        if (cause != null) {
                                                                            throw cause;
                                                                        }
                                                                        throw th7;
                                                                    }
                                                                }
                                                                i252++;
                                                                objArr20 = objArr25;
                                                                length = i300;
                                                                str2 = str2;
                                                            } catch (Throwable th8) {
                                                                Throwable cause2 = th8.getCause();
                                                                if (cause2 != null) {
                                                                    throw cause2;
                                                                }
                                                                throw th8;
                                                            }
                                                        } catch (Throwable th9) {
                                                            Throwable cause3 = th9.getCause();
                                                            if (cause3 != null) {
                                                                throw cause3;
                                                            }
                                                            throw th9;
                                                        }
                                                    } catch (Throwable th10) {
                                                        Throwable cause4 = th10.getCause();
                                                        if (cause4 != null) {
                                                            throw cause4;
                                                        }
                                                        throw th10;
                                                    }
                                                }
                                            } catch (Throwable th11) {
                                                Throwable cause5 = th11.getCause();
                                                if (cause5 != null) {
                                                    throw cause5;
                                                }
                                                throw th11;
                                            }
                                        } catch (Throwable th12) {
                                            Throwable cause6 = th12.getCause();
                                            if (cause6 != null) {
                                                throw cause6;
                                            }
                                            throw th12;
                                        }
                                    } catch (Throwable th13) {
                                        Throwable cause7 = th13.getCause();
                                        if (cause7 != null) {
                                            throw cause7;
                                        }
                                        throw th13;
                                    }
                                } catch (Throwable th14) {
                                    Throwable cause8 = th14.getCause();
                                    if (cause8 != null) {
                                        throw cause8;
                                    }
                                    throw th14;
                                }
                            } catch (Throwable th15) {
                                Throwable cause9 = th15.getCause();
                                if (cause9 != null) {
                                    throw cause9;
                                }
                                throw th15;
                            }
                        } catch (Throwable unused) {
                        }
                        Object[] objArr34 = {new int[]{i2}, new int[]{i2}, new int[1], null};
                        int iMyTid = Process.myTid();
                        int i398 = ~iMyTid;
                        int i399 = (((~((-876185823) | i398)) | (~(iMyTid | 102437952))) * 959) + 1983759611 + (((~(iMyTid | (-876185823))) | (~(i398 | 102437952))) * 959);
                        int iICustomTabsCallbackStubProxy13 = com.google.android.gms.common.internal.Objects.ICustomTabsCallbackStubProxy();
                        int i400 = ~iICustomTabsCallbackStubProxy13;
                        int i401 = (i399 * (-1527)) + (((~i400) | i399) * 764);
                        int i402 = ~(((-1) ^ i399) | i399);
                        int i403 = ~iICustomTabsCallbackStubProxy13;
                        int i404 = ~((i403 & i399) | (i403 ^ i399));
                        int i405 = (i401 - (~(((i404 & i402) | (i402 ^ i404)) * (-1528)))) - 1;
                        int i406 = ~(((-1) ^ i399) | i399);
                        int i407 = getARTIFICIAL_FRAME_PACKAGE_NAME + 121;
                        artificialFrame = i407 % 128;
                        int i408 = i407 % 2;
                        int i409 = ~(~i399);
                        int i410 = (i406 & i409) | (i406 ^ i409);
                        int i411 = ~i400;
                        int i412 = i3 + i405 + (764 * ((i410 & i411) | (i410 ^ i411)));
                        int i413 = i412 << 13;
                        int i414 = ((~i412) & i413) | ((~i413) & i412);
                        int i415 = i414 >>> 17;
                        int i416 = ((~i414) & i415) | ((~i415) & i414);
                        int i417 = i416 << 5;
                        ((int[]) objArr34[2])[0] = ((~i416) & i417) | ((~i417) & i416);
                        return objArr34;
                    }
                });
            }
        }
    }

    private TracesSamplingDecision extractSamplingDecision(@Nullable TraceContext traceContext) {
        String sampleRate;
        if (traceContext != null && (sampleRate = traceContext.getSampleRate()) != null) {
            try {
                Double dValueOf = Double.valueOf(Double.parseDouble(sampleRate));
                if (!SampleRateUtils.isValidTracesSampleRate(dValueOf, false)) {
                    this.logger.log(SentryLevel.ERROR, "Invalid sample rate parsed from TraceContext: %s", sampleRate);
                } else {
                    String sampleRand = traceContext.getSampleRand();
                    if (sampleRand != null) {
                        Double dValueOf2 = Double.valueOf(Double.parseDouble(sampleRand));
                        if (SampleRateUtils.isValidTracesSampleRate(dValueOf2, false)) {
                            return new TracesSamplingDecision(Boolean.TRUE, dValueOf, dValueOf2);
                        }
                    }
                    return SampleRateUtils.backfilledSampleRand(new TracesSamplingDecision(Boolean.TRUE, dValueOf));
                }
            } catch (Exception unused) {
                this.logger.log(SentryLevel.ERROR, "Unable to parse sample rate from TraceContext: %s", sampleRate);
            }
        }
        return new TracesSamplingDecision(Boolean.TRUE);
    }

    private void logEnvelopeItemNull(@NotNull SentryEnvelopeItem sentryEnvelopeItem, int i) {
        this.logger.log(SentryLevel.ERROR, "Item %d of type %s returned null by the parser.", Integer.valueOf(i), sentryEnvelopeItem.getHeader().getType());
    }

    private void logUnexpectedEventId(@NotNull SentryEnvelope sentryEnvelope, @Nullable SentryId sentryId, int i) {
        this.logger.log(SentryLevel.ERROR, "Item %d of has a different event id (%s) to the envelope header (%s)", Integer.valueOf(i), sentryEnvelope.getHeader().getEventId(), sentryId);
    }

    private void logItemCaptured(int i) {
        this.logger.log(SentryLevel.DEBUG, "Item %d is being captured.", Integer.valueOf(i));
    }

    private void logTimeout(@Nullable SentryId sentryId) {
        this.logger.log(SentryLevel.WARNING, "Timed out waiting for event id submission: %s", sentryId);
    }

    private boolean waitFlush(@NotNull Hint hint) {
        Object sentrySdkHint = HintUtils.getSentrySdkHint(hint);
        if (sentrySdkHint instanceof Flushable) {
            return ((Flushable) sentrySdkHint).waitFlush();
        }
        LogUtils.logNotInstanceOf(Flushable.class, sentrySdkHint, this.logger);
        return true;
    }
}
