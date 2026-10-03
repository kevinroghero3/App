package com.google.android.datatransport.cct.internal;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.imageutils.JfifUtil;
import com.google.common.base.Ascii;
import com.google.common.collect.Iterables;
import com.google.firebase.encoders.annotations.Encodable;
import com.salesforce.marketingcloud.analytics.stats.b;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Random;
import java.util.Set;
import o.ArtificialStackFrames;
import o.ICustomTabsCallback;
import okio.Utf8;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_LogRequest extends LogRequest {
    private final ClientInfo clientInfo;
    private final List<LogEvent> logEvents;
    private final Integer logSource;
    private final String logSourceName;
    private final QosTier qosTier;
    private final long requestTimeMs;
    private final long requestUptimeMs;

    private AutoValue_LogRequest(long j, long j2, @Nullable ClientInfo clientInfo, @Nullable Integer num, @Nullable String str, @Nullable List<LogEvent> list, @Nullable QosTier qosTier) {
        this.requestTimeMs = j;
        this.requestUptimeMs = j2;
        this.clientInfo = clientInfo;
        this.logSource = num;
        this.logSourceName = str;
        this.logEvents = list;
        this.qosTier = qosTier;
    }

    @Override // com.google.android.datatransport.cct.internal.LogRequest
    public long getRequestTimeMs() {
        return this.requestTimeMs;
    }

    @Override // com.google.android.datatransport.cct.internal.LogRequest
    public long getRequestUptimeMs() {
        return this.requestUptimeMs;
    }

    @Override // com.google.android.datatransport.cct.internal.LogRequest
    public ClientInfo getClientInfo() {
        return this.clientInfo;
    }

    @Override // com.google.android.datatransport.cct.internal.LogRequest
    public Integer getLogSource() {
        return this.logSource;
    }

    @Override // com.google.android.datatransport.cct.internal.LogRequest
    public String getLogSourceName() {
        return this.logSourceName;
    }

    @Override // com.google.android.datatransport.cct.internal.LogRequest
    @Encodable.Field(name = "logEvent")
    public List<LogEvent> getLogEvents() {
        return this.logEvents;
    }

    @Override // com.google.android.datatransport.cct.internal.LogRequest
    public QosTier getQosTier() {
        return this.qosTier;
    }

    public String toString() {
        return "LogRequest{requestTimeMs=" + this.requestTimeMs + ", requestUptimeMs=" + this.requestUptimeMs + ", clientInfo=" + this.clientInfo + ", logSource=" + this.logSource + ", logSourceName=" + this.logSourceName + ", logEvents=" + this.logEvents + ", qosTier=" + this.qosTier + "}";
    }

    public boolean equals(Object obj) {
        ClientInfo clientInfo;
        Integer num;
        String str;
        List<LogEvent> list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LogRequest)) {
            return false;
        }
        LogRequest logRequest = (LogRequest) obj;
        if (this.requestTimeMs == logRequest.getRequestTimeMs() && this.requestUptimeMs == logRequest.getRequestUptimeMs() && ((clientInfo = this.clientInfo) != null ? clientInfo.equals(logRequest.getClientInfo()) : logRequest.getClientInfo() == null) && ((num = this.logSource) != null ? num.equals(logRequest.getLogSource()) : logRequest.getLogSource() == null) && ((str = this.logSourceName) != null ? str.equals(logRequest.getLogSourceName()) : logRequest.getLogSourceName() == null) && ((list = this.logEvents) != null ? list.equals(logRequest.getLogEvents()) : logRequest.getLogEvents() == null)) {
            QosTier qosTier = this.qosTier;
            if (qosTier == null) {
                if (logRequest.getQosTier() == null) {
                    return true;
                }
            } else if (qosTier.equals(logRequest.getQosTier())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j = this.requestTimeMs;
        int i = (int) (j ^ (j >>> 32));
        long j2 = this.requestUptimeMs;
        int i2 = (int) ((j2 >>> 32) ^ j2);
        ClientInfo clientInfo = this.clientInfo;
        int iHashCode = clientInfo == null ? 0 : clientInfo.hashCode();
        Integer num = this.logSource;
        int iHashCode2 = num == null ? 0 : num.hashCode();
        String str = this.logSourceName;
        int iHashCode3 = str == null ? 0 : str.hashCode();
        List<LogEvent> list = this.logEvents;
        int iHashCode4 = list == null ? 0 : list.hashCode();
        QosTier qosTier = this.qosTier;
        return ((((((((((((i ^ 1000003) * 1000003) ^ i2) * 1000003) ^ iHashCode) * 1000003) ^ iHashCode2) * 1000003) ^ iHashCode3) * 1000003) ^ iHashCode4) * 1000003) ^ (qosTier != null ? qosTier.hashCode() : 0);
    }

    public static final class Builder extends LogRequest.Builder {
        private static short[] ICustomTabsService;
        private ClientInfo clientInfo;
        private List<LogEvent> logEvents;
        private Integer logSource;
        private String logSourceName;
        private QosTier qosTier;
        private Long requestTimeMs;
        private Long requestUptimeMs;
        private static final byte[] $$c = {19, -17, 93, 33};
        private static final int $$d = 233;
        private static int $10 = 0;
        private static int $11 = 1;
        private static final byte[] $$a = {4, -94, -54, -39, 9, -20, Ascii.FS, -26, -18, 10, -5, -11, 2, 19, -39, 6, -6, Ascii.ESC, -46, 8, -6, -15, 2, -4, Ascii.CR, -24, -13, -7, -12, Ascii.FF, -4, 50, -50, -14, -31, -17, -4, 38, -49, -3, -8, 10, -24, Ascii.US, -22, -22, 10, -7, -12, -2, -22, Ascii.DLE, -18, 9, -20, 44, -35, -20, -9, 6, -11, -4, 0, -10, 2, Ascii.GS, -46, 8, -6, -15, 2, -4};
        private static final int $$b = 25;
        private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        private static int artificialFrame = 1;
        private static int onTransact = 1191595727;
        private static int mayLaunchUrl = -81862512;
        private static int getInterfaceDescriptor = 1041177426;
        private static byte[] ICustomTabsCallbackStubProxy = {119, -21, -4, -34, -31, -24, Ascii.ESC, -14, -107, -31, -26, -34, -31, -24, -5, Ascii.DC2, -91, -44, -43, -22, -7, -47, -6, 124, 67, 60, 111, 17, 53, 78, Utf8.REPLACEMENT_BYTE, 89, 54, 50, 55, 48, 52, 101, 7, 69, 54, -116, -55, -70, -43, -97, -77, -76, -91, -57, -68, -72, -67, -66, -78, -29, -57, 113, -67, -16, 120, -76, -55, -95, -76, -77, -50, -27, -120, -65, -72, -67, -52, -92, -51, 97, 8, -10, -25, -10, -118, -82, -13, 118, -90, -75, -66, -91, -65, -83, -52, -70, -66, -32, 118, -90, -72, -65, -6, 100, -76, -92, -78, -27, -117, -88, -56, -31, 121, -20, -13, -28, -29, -27, -21, 10, -32, -28, 47, -90, -32, 109};

        /* JADX WARN: Code duplicated, block: B:10:0x0024  */
        /* JADX WARN: Code duplicated, block: B:8:0x001e  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x002a). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0024
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static java.lang.String $$e(byte r6, short r7, short r8) {
            /*
                int r8 = r8 * 3
                int r8 = r8 + 4
                byte[] r0 = com.google.android.datatransport.cct.internal.AutoValue_LogRequest.Builder.$$c
                int r6 = r6 * 3
                int r6 = 1 - r6
                int r7 = r7 * 5
                int r7 = 117 - r7
                byte[] r1 = new byte[r6]
                r2 = 0
                if (r0 != 0) goto L16
                r3 = r8
                r4 = r2
                goto L2a
            L16:
                r3 = r2
            L17:
                byte r4 = (byte) r7
                r1[r3] = r4
                int r3 = r3 + 1
                if (r3 != r6) goto L24
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                return r6
            L24:
                r4 = r0[r8]
                r5 = r3
                r3 = r8
                r8 = r4
                r4 = r5
            L2a:
                int r8 = -r8
                int r3 = r3 + 1
                int r7 = r7 + r8
                r8 = r3
                r3 = r4
                goto L17
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.datatransport.cct.internal.AutoValue_LogRequest.Builder.$$e(byte, short, short):java.lang.String");
        }

        /* JADX WARN: Code duplicated, block: B:10:0x0021  */
        /* JADX WARN: Code duplicated, block: B:8:0x0019  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0021 -> B:11:0x0027). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0021
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static void a(byte r7, int r8, int r9, java.lang.Object[] r10) {
            /*
                int r8 = 53 - r8
                int r9 = 115 - r9
                int r7 = r7 + 2
                byte[] r0 = com.google.android.datatransport.cct.internal.AutoValue_LogRequest.Builder.$$a
                byte[] r1 = new byte[r7]
                r2 = 0
                if (r0 != 0) goto L11
                r3 = r7
                r9 = r8
                r4 = r2
                goto L27
            L11:
                r3 = r2
            L12:
                int r4 = r3 + 1
                byte r5 = (byte) r9
                r1[r3] = r5
                if (r4 != r7) goto L21
                java.lang.String r7 = new java.lang.String
                r7.<init>(r1, r2)
                r10[r2] = r7
                return
            L21:
                r3 = r0[r8]
                r6 = r9
                r9 = r8
                r8 = r3
                r3 = r6
            L27:
                int r8 = -r8
                int r3 = r3 + r8
                int r8 = r9 + 1
                int r9 = r3 + (-5)
                r3 = r4
                goto L12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.datatransport.cct.internal.AutoValue_LogRequest.Builder.a(byte, int, int, java.lang.Object[]):void");
        }

        Builder() {
        }

        @Override // com.google.android.datatransport.cct.internal.LogRequest.Builder
        public LogRequest.Builder setRequestTimeMs(long j) {
            this.requestTimeMs = Long.valueOf(j);
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogRequest.Builder
        public LogRequest.Builder setRequestUptimeMs(long j) {
            this.requestUptimeMs = Long.valueOf(j);
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogRequest.Builder
        public LogRequest.Builder setClientInfo(@Nullable ClientInfo clientInfo) {
            this.clientInfo = clientInfo;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogRequest.Builder
        LogRequest.Builder setLogSource(@Nullable Integer num) {
            this.logSource = num;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogRequest.Builder
        LogRequest.Builder setLogSourceName(@Nullable String str) {
            this.logSourceName = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogRequest.Builder
        public LogRequest.Builder setLogEvents(@Nullable List<LogEvent> list) {
            this.logEvents = list;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogRequest.Builder
        public LogRequest.Builder setQosTier(@Nullable QosTier qosTier) {
            this.qosTier = qosTier;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogRequest.Builder
        public LogRequest build() {
            String str = "";
            if (this.requestTimeMs == null) {
                str = " requestTimeMs";
            }
            if (this.requestUptimeMs == null) {
                str = str + " requestUptimeMs";
            }
            if (!str.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + str);
            }
            return new AutoValue_LogRequest(this.requestTimeMs.longValue(), this.requestUptimeMs.longValue(), this.clientInfo, this.logSource, this.logSourceName, this.logEvents, this.qosTier);
        }

        private static void b(int i, byte b, int i2, short s, int i3, Object[] objArr) throws Throwable {
            boolean z;
            long j;
            int i4;
            int length;
            byte[] bArr;
            int i5;
            int i6 = 2 % 2;
            ICustomTabsCallback iCustomTabsCallback = new ICustomTabsCallback();
            StringBuilder sb = new StringBuilder();
            try {
                Object[] objArr2 = {Integer.valueOf(i2), Integer.valueOf(mayLaunchUrl)};
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1991297565);
                long j2 = 0;
                if (objAccessartificialFrame == null) {
                    byte b2 = (byte) 0;
                    byte b3 = (byte) (b2 + 1);
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(41 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) ((ViewConfiguration.getTapTimeout() >> 16) + 36241), 2342 - ((Process.getThreadPriority(0) + 20) >> 6), 371880939, false, $$e(b2, b3, (byte) (b3 - 1)), new Class[]{Integer.TYPE, Integer.TYPE});
                }
                int iIntValue = ((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
                if (iIntValue == -1) {
                    z = true;
                } else {
                    int i7 = $10 + 37;
                    $11 = i7 % 128;
                    int i8 = i7 % 2;
                    z = false;
                }
                if (z) {
                    byte[] bArr2 = ICustomTabsCallbackStubProxy;
                    if (bArr2 != null) {
                        int i9 = $10 + 27;
                        $11 = i9 % 128;
                        if (i9 % 2 == 0) {
                            length = bArr2.length;
                            bArr = new byte[length];
                            i5 = 1;
                        } else {
                            length = bArr2.length;
                            bArr = new byte[length];
                            i5 = 0;
                        }
                        while (i5 < length) {
                            try {
                                Object[] objArr3 = {Integer.valueOf(bArr2[i5])};
                                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1557994855);
                                if (objAccessartificialFrame2 == null) {
                                    byte b4 = (byte) 0;
                                    byte b5 = b4;
                                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(View.combineMeasuredStates(0, 0) + 44, (char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > j2 ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == j2 ? 0 : -1))), 1215 - Color.alpha(0), 1011328145, false, $$e(b4, b5, b5), new Class[]{Integer.TYPE});
                                }
                                bArr[i5] = ((Byte) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).byteValue();
                                i5++;
                                j2 = 0;
                            } catch (Throwable th) {
                                Throwable cause = th.getCause();
                                if (cause == null) {
                                    throw th;
                                }
                                throw cause;
                            }
                        }
                        bArr2 = bArr;
                    }
                    if (bArr2 != null) {
                        byte[] bArr3 = ICustomTabsCallbackStubProxy;
                        Object[] objArr4 = {Integer.valueOf(i3), Integer.valueOf(onTransact)};
                        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1991297565);
                        if (objAccessartificialFrame3 == null) {
                            byte b6 = (byte) 0;
                            byte b7 = (byte) (b6 + 1);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(40 - TextUtils.getTrimmedLength(""), (char) (36241 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1))), (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 2341, 371880939, false, $$e(b6, b7, (byte) (b7 - 1)), new Class[]{Integer.TYPE, Integer.TYPE});
                        }
                        iIntValue = (byte) (((byte) (((long) bArr3[((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue()]) ^ (-4629754035390455669L))) + ((int) (((long) mayLaunchUrl) ^ (-4629754035390455669L))));
                        j = -4629754035390455669L;
                    } else {
                        j = -4629754035390455669L;
                        iIntValue = (short) (((short) (((long) ICustomTabsService[i3 + ((int) (((long) onTransact) ^ (-4629754035390455669L)))]) ^ (-4629754035390455669L))) + ((int) (((long) mayLaunchUrl) ^ (-4629754035390455669L))));
                    }
                } else {
                    j = -4629754035390455669L;
                }
                if (iIntValue > 0) {
                    int i10 = ((i3 + iIntValue) - 2) + ((int) (((long) onTransact) ^ j));
                    if (z) {
                        i4 = 1;
                    } else {
                        int i11 = $10 + 101;
                        $11 = i11 % 128;
                        int i12 = i11 % 2;
                        i4 = 0;
                    }
                    iCustomTabsCallback.c = i10 + i4;
                    Object[] objArr5 = {iCustomTabsCallback, Integer.valueOf(i), Integer.valueOf(getInterfaceDescriptor), sb};
                    Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(216546027);
                    if (objAccessartificialFrame4 == null) {
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(TextUtils.lastIndexOf("", '0') + 42, (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 1), (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 4066, -1819443997, false, "x", new Class[]{Object.class, Integer.TYPE, Integer.TYPE, Object.class});
                    }
                    ((StringBuilder) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).append(iCustomTabsCallback.createConnectionCallback);
                    iCustomTabsCallback.createBrowser = iCustomTabsCallback.createConnectionCallback;
                    byte[] bArr4 = ICustomTabsCallbackStubProxy;
                    if (bArr4 != null) {
                        int i13 = $10 + 35;
                        $11 = i13 % 128;
                        int i14 = i13 % 2;
                        int length2 = bArr4.length;
                        byte[] bArr5 = new byte[length2];
                        for (int i15 = 0; i15 < length2; i15++) {
                            bArr5[i15] = (byte) (((long) bArr4[i15]) ^ (-4629754035390455669L));
                        }
                        bArr4 = bArr5;
                    }
                    boolean z2 = bArr4 != null;
                    iCustomTabsCallback.a = 1;
                    while (iCustomTabsCallback.a < iIntValue) {
                        int i16 = $11 + 45;
                        $10 = i16 % 128;
                        int i17 = i16 % 2;
                        if (z2) {
                            byte[] bArr6 = ICustomTabsCallbackStubProxy;
                            int i18 = iCustomTabsCallback.c;
                            iCustomTabsCallback.c = i18 - 1;
                            iCustomTabsCallback.createConnectionCallback = (char) (iCustomTabsCallback.createBrowser + (((byte) (((byte) (((long) bArr6[i18]) ^ (-4629754035390455669L))) + s)) ^ b));
                        } else {
                            short[] sArr = ICustomTabsService;
                            int i19 = iCustomTabsCallback.c;
                            iCustomTabsCallback.c = i19 - 1;
                            iCustomTabsCallback.createConnectionCallback = (char) (iCustomTabsCallback.createBrowser + (((short) (((short) (((long) sArr[i19]) ^ (-4629754035390455669L))) + s)) ^ b));
                        }
                        sb.append(iCustomTabsCallback.createConnectionCallback);
                        iCustomTabsCallback.createBrowser = iCustomTabsCallback.createConnectionCallback;
                        iCustomTabsCallback.a++;
                    }
                }
                objArr[0] = sb.toString();
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }

        /* JADX WARN: Code duplicated, block: B:116:0x06dd A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:58:0x0606  */
        /* JADX WARN: Code duplicated, block: B:60:0x060c  */
        /* JADX WARN: Code duplicated, block: B:61:0x06d9  */
        /* JADX WARN: Code duplicated, block: B:65:0x06e3 A[Catch: Exception -> 0x0c5e, TRY_LEAVE, TryCatch #1 {Exception -> 0x0c5e, blocks: (B:63:0x06dd, B:65:0x06e3, B:71:0x0821, B:76:0x08c3, B:78:0x08c9, B:79:0x08ca, B:80:0x08cb, B:85:0x0a40, B:89:0x0c56, B:91:0x0c5c, B:92:0x0c5d, B:66:0x07bc, B:68:0x07c9, B:69:0x0810, B:81:0x09ef, B:83:0x09fc, B:84:0x0a39), top: B:116:0x06dd, inners: #0, #2 }] */
        /* JADX WARN: Code duplicated, block: B:68:0x07c9 A[Catch: all -> 0x08c2, TryCatch #0 {all -> 0x08c2, blocks: (B:66:0x07bc, B:68:0x07c9, B:69:0x0810), top: B:114:0x07bc, outer: #1 }] */
        /* JADX WARN: Code duplicated, block: B:74:0x08b6  */
        /* JADX WARN: Code duplicated, block: B:80:0x08cb A[Catch: Exception -> 0x0c5e, TRY_LEAVE, TryCatch #1 {Exception -> 0x0c5e, blocks: (B:63:0x06dd, B:65:0x06e3, B:71:0x0821, B:76:0x08c3, B:78:0x08c9, B:79:0x08ca, B:80:0x08cb, B:85:0x0a40, B:89:0x0c56, B:91:0x0c5c, B:92:0x0c5d, B:66:0x07bc, B:68:0x07c9, B:69:0x0810, B:81:0x09ef, B:83:0x09fc, B:84:0x0a39), top: B:116:0x06dd, inners: #0, #2 }] */
        /* JADX WARN: Code duplicated, block: B:83:0x09fc A[Catch: all -> 0x0c55, TryCatch #2 {all -> 0x0c55, blocks: (B:81:0x09ef, B:83:0x09fc, B:84:0x0a39), top: B:117:0x09ef, outer: #1 }] */
        /* JADX WARN: Code duplicated, block: B:87:0x0ba1  */
        /* JADX WARN: Code duplicated, block: B:95:0x0cbe  */
        /* JADX WARN: Code duplicated, block: B:96:0x0cc6  */
        public static Object[] CoroutineDebuggingKt(Context context, int i, int i2, int i3) throws Throwable {
            int i4;
            int i5;
            int i6;
            int i7;
            int i8;
            Object[] objArr;
            Object objAccessartificialFrame;
            Object objInvoke;
            Object[] objArr2;
            Object objAccessartificialFrame2;
            int i9;
            int i10;
            int iNextInt;
            int i11;
            int i12;
            int i13;
            int i14;
            int i15 = 2 % 2;
            int i16 = artificialFrame;
            int i17 = i16 + 9;
            int i18 = i17 % 128;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i18;
            int i19 = i17 % 2;
            if (context == null) {
                int i20 = ((i16 | 119) << 1) - (i16 ^ 119);
                getARTIFICIAL_FRAME_PACKAGE_NAME = i20 % 128;
                int i21 = i20 % 2;
                objArr = new Object[]{new int[]{i}, new int[]{i}, new int[1], null};
                int iMaxMemory = (int) Runtime.getRuntime().maxMemory();
                int i22 = ~iMaxMemory;
                int i23 = (-1361715906) + (((~((-77922818) | i22)) | (~(631603729 | iMaxMemory))) * 520);
                int i24 = ~((-631603730) | i22);
                int i25 = ~(iMaxMemory | 347020045);
                int i26 = i23 + ((i24 | i25) * (-1040)) + ((i25 | (~(i22 | (-347020046))) | 553680912) * 520);
                int i27 = (i3 - (~((i26 << 1) - i26))) - 1;
                int i28 = i27 << 13;
                int i29 = (i27 | i28) & (~(i27 & i28));
                int i30 = i29 >>> 17;
                int i31 = (i29 | i30) & (~(i29 & i30));
                ((int[]) objArr[2])[0] = i31 ^ (i31 << 5);
                i14 = 2;
            } else {
                int i32 = (i18 & 119) + (i18 | 119);
                artificialFrame = i32 % 128;
                int i33 = i32 % 2;
                try {
                    int maximumFlingVelocity = 988677256 - (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                    int i34 = -(SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                    int iUpdateVisuals = Iterables.AnonymousClass9.updateVisuals();
                    int i35 = ~((i34 ^ iUpdateVisuals) | (i34 & iUpdateVisuals));
                    int i36 = ((i34 * (-55)) - 55) + (((i35 & 1) | (i35 ^ 1)) * 56);
                    int i37 = -(-((~((i34 ^ 1) | (i34 & 1))) * (-56)));
                    int i38 = (i36 & i37) + (i36 | i37);
                    int i39 = artificialFrame;
                    int i40 = (i39 ^ b.f40o) + ((i39 & b.f40o) << 1);
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i40 % 128;
                    int i41 = i40 % 2;
                    int i42 = ~iUpdateVisuals;
                    int i43 = ~((i42 & 1) | (i42 ^ 1));
                    int i44 = -(-(((i34 & i43) | (i34 ^ i43)) * 56));
                    byte b = (byte) (((i38 | i44) << 1) - (i44 ^ i38));
                    int i45 = -AndroidCharacter.getMirror('0');
                    int i46 = (i45 ^ 20) + ((i45 & 20) << 1);
                    int i47 = -(-TextUtils.indexOf("", ""));
                    Object[] objArr3 = new Object[1];
                    b(maximumFlingVelocity, b, i46, (short) ((i47 ^ (-100)) + ((i47 & (-100)) << 1)), 1139233213 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), objArr3);
                    Class<?> cls = Class.forName((String) objArr3[0]);
                    int jumpTapTimeout = ViewConfiguration.getJumpTapTimeout() >> 16;
                    int i48 = (jumpTapTimeout * (-109)) - 1925973614;
                    int i49 = ~jumpTapTimeout;
                    int i50 = ~((i ^ 988677262) | (i & 988677262));
                    int i51 = -(-(((i49 ^ i50) | (i49 & i50)) * (-220)));
                    int i52 = ((i48 | i51) << 1) - (i51 ^ i48);
                    int i53 = -(-(((~((jumpTapTimeout ^ 988677262) | (jumpTapTimeout & 988677262))) | i50) * 220));
                    int i54 = (i52 ^ i53) + ((i52 & i53) << 1);
                    int i55 = ~(i49 | 988677262);
                    int i56 = artificialFrame + 63;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i56 % 128;
                    int i57 = i56 % 2;
                    int i58 = ~(jumpTapTimeout | (-988677263));
                    int i59 = (i54 - (~(b.f39n * ((i55 & i58) | (i55 ^ i58))))) - 1;
                    byte maximumFlingVelocity2 = (byte) (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                    int i60 = (-29) - (~(-View.resolveSizeAndState(0, 0, 0)));
                    short s = (short) (63 - (~(-TextUtils.indexOf((CharSequence) "", '0', 0))));
                    int i61 = (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                    int iUpdateVisuals2 = Iterables.AnonymousClass9.updateVisuals();
                    int i62 = getARTIFICIAL_FRAME_PACKAGE_NAME + 71;
                    artificialFrame = i62 % 128;
                    int i63 = i62 % 2;
                    int i64 = ~iUpdateVisuals2;
                    int i65 = (i64 & i61) | (i64 ^ i61);
                    int i66 = (i61 * (-115)) + 2132164266 + ((~((i65 ^ 1139233234) | (i65 & 1139233234))) * (-116));
                    int i67 = ((i61 ^ iUpdateVisuals2) | (i61 & iUpdateVisuals2)) * 116;
                    int i68 = (i66 ^ i67) + ((i66 & i67) << 1);
                    int i69 = ~i61;
                    int i70 = ~((i69 ^ (-1139233235)) | (i69 & (-1139233235)));
                    int i71 = ~(((-1139233235) ^ iUpdateVisuals2) | ((-1139233235) & iUpdateVisuals2));
                    int i72 = ((i70 & i71) | (i70 ^ i71)) * 116;
                    int i73 = (i68 ^ i72) + ((i72 & i68) << 1);
                    Object[] objArr4 = new Object[1];
                    b(i59, maximumFlingVelocity2, i60, s, i73, objArr4);
                    Object objInvoke2 = cls.getMethod((String) objArr4[0], null).invoke(context, null);
                    int i74 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                    int i75 = (i74 ^ 89) + ((i74 & 89) << 1);
                    artificialFrame = i75 % 128;
                    int i76 = i75 % 2;
                    int i77 = 988677255 - (~(-ExpandableListView.getPackedPositionType(0L)));
                    byte doubleTapTimeout = (byte) (ViewConfiguration.getDoubleTapTimeout() >> 16);
                    int fadingEdgeLength = (-28) - (ViewConfiguration.getFadingEdgeLength() >> 16);
                    int i78 = -TextUtils.getOffsetBefore("", 0);
                    int iUpdateVisuals3 = Iterables.AnonymousClass9.updateVisuals();
                    int i79 = (i78 * 253) - 14421;
                    int i80 = ~((~i78) | 56);
                    int i81 = ~iUpdateVisuals3;
                    int i82 = (i78 ^ (-57)) | (i78 & (-57));
                    int i83 = (i82 ^ iUpdateVisuals3) | (iUpdateVisuals3 & i82);
                    int i84 = ((~i83) | i80 | (~((56 ^ i81) | (56 & i81)))) * (-252);
                    int i85 = (i79 & i84) + (i84 | i79);
                    int i86 = i82 * (-252);
                    int i87 = (i85 & i86) + (i85 | i86);
                    int i88 = 56 | i81;
                    int i89 = ~((i78 & i88) | (i88 ^ i78));
                    int i90 = ~i83;
                    int i91 = -(-(((i89 & i90) | (i89 ^ i90)) * 252));
                    short s2 = (short) (((i87 | i91) << 1) - (i87 ^ i91));
                    int size = View.MeasureSpec.getSize(0);
                    int i92 = getARTIFICIAL_FRAME_PACKAGE_NAME + 107;
                    artificialFrame = i92 % 128;
                    int i93 = i92 % 2;
                    int i94 = -size;
                    int i95 = ((1139233253 | i94) << 1) - (i94 ^ 1139233253);
                    Object[] objArr5 = new Object[1];
                    b(i77, doubleTapTimeout, fadingEdgeLength, s2, i95, objArr5);
                    Class<?> cls2 = Class.forName((String) objArr5[0]);
                    int i96 = -(Process.myPid() >> 22);
                    int i97 = (i96 & 988677261) + (i96 | 988677261);
                    byte b2 = (byte) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                    int i98 = (-29) - (~(-(-View.MeasureSpec.makeMeasureSpec(0, 0))));
                    int i99 = -TextUtils.getTrimmedLength("");
                    short s3 = (short) ((i99 ^ (-119)) + ((i99 & (-119)) << 1));
                    int i100 = -Process.getGidForName("");
                    int i101 = (i100 ^ 1139233286) + ((i100 & 1139233286) << 1);
                    Object[] objArr6 = new Object[1];
                    b(i97, b2, i98, s3, i101, objArr6);
                    if ((cls2.getField((String) objArr6[0]).getInt(objInvoke2) & 2) != 0) {
                        Object[] objArr7 = {new int[]{i}, new int[]{(i & (-2)) | ((~i) & 1)}, new int[1], null};
                        int iMaxMemory2 = (int) Runtime.getRuntime().maxMemory();
                        int i102 = ~iMaxMemory2;
                        int i103 = (-222132200) + (((~((-1007489581) | i102)) | 28865805) * (-865)) + ((~(iMaxMemory2 | 1007489580)) * 865) + (((~(28865805 | i102)) | (~(i102 | 1007489580))) * 865) + 16;
                        int i104 = ((i3 | i103) << 1) - (i3 ^ i103);
                        int i105 = i104 ^ (i104 << 13);
                        int i106 = i105 >>> 17;
                        int i107 = (i105 | i106) & (~(i105 & i106));
                        int i108 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                        int i109 = i108 + 29;
                        artificialFrame = i109 % 128;
                        if (i109 % 2 == 0) {
                            int i110 = i107 / 4;
                            ((int[]) objArr7[4])[0] = ((~i107) & i110) | ((~i110) & i107);
                        } else {
                            int i111 = i107 << 5;
                            ((int[]) objArr7[2])[0] = (i107 | i111) & (~(i107 & i111));
                        }
                        int i112 = ((i108 | b.i) << 1) - (i108 ^ b.i);
                        artificialFrame = i112 % 128;
                        int i113 = i112 % 2;
                        objArr = objArr7;
                    } else {
                        int i114 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                        int i115 = (i114 & 43) + (i114 | 43);
                        artificialFrame = i115 % 128;
                        int i116 = i115 % 2;
                        Object[] objArr8 = {new int[]{i}, new int[]{i}, new int[1], null};
                        int i117 = ((i114 | 95) << 1) - (i114 ^ 95);
                        artificialFrame = i117 % 128;
                        int i118 = i117 % 2;
                        int startUptimeMillis = (int) Process.getStartUptimeMillis();
                        int i119 = (((~(startUptimeMillis | 8046882)) | 970576892) * 56) + 652893782 + (((~((~startUptimeMillis) | 970576892)) | 8046882) * 56);
                        int i120 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                        int i121 = i120 + b.i;
                        artificialFrame = i121 % 128;
                        if (i121 % 2 == 0) {
                            i4 = (371 << i119) << (371 >>> i3);
                            int i122 = ~i3;
                            int i123 = ~i;
                            i5 = ~((i122 & i123) | (i122 ^ i123));
                            int i124 = ~i119;
                            i6 = (i124 & i) | (i124 ^ i);
                        } else {
                            i4 = ((i119 * 371) - (~(-(-(i3 * 371))))) - 1;
                            i5 = ~((~i3) | (~i));
                            i6 = (~i119) | i;
                        }
                        int i125 = (i120 ^ 67) + ((i120 & 67) << 1);
                        int i126 = i125 % 128;
                        artificialFrame = i126;
                        int i127 = i125 % 2;
                        int i128 = ~i6;
                        if (i127 == 0) {
                            int i129 = -((-370) >>> ((i5 & i128) | (i5 ^ i128)));
                            i7 = (i4 ^ i129) + ((i4 & i129) << 1);
                            int i130 = ~((~i119) | (~i));
                            int i131 = ~i3;
                            int i132 = ~((i131 & i) | (i131 ^ i));
                            i8 = (i130 & i132) | (i130 ^ i132);
                        } else {
                            i7 = i4 + ((-370) * ((i5 & i128) | (i5 ^ i128)));
                            int i133 = ~i119;
                            int i134 = ~i;
                            int i135 = ~((i133 & i134) | (i133 ^ i134));
                            int i136 = ~i3;
                            i8 = i135 | (~((i136 & i) | (i136 ^ i)));
                        }
                        int i137 = ~((i119 & i3) | (i119 ^ i3));
                        int i138 = (-370) * (i8 | i137);
                        int i139 = (((i7 & i138) + (i138 | i7)) - (~(-(-(i137 * 370))))) - 1;
                        int i140 = i139 ^ (i139 << 13);
                        int i141 = (i126 ^ 75) + ((i126 & 75) << 1);
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i141 % 128;
                        if (i141 % 2 != 0) {
                            int i142 = i140 % 84;
                            int i143 = (i142 | i140) & (~(i140 & i142));
                            int i144 = (i143 & (-2)) + (i143 | (-2));
                            ((int[]) objArr8[3])[0] = ((~i143) & i144) | ((~i144) & i143);
                        } else {
                            int i145 = i140 >>> 17;
                            int i146 = (i145 & (~i140)) | ((~i145) & i140);
                            ((int[]) objArr8[2])[0] = i146 ^ (i146 << 5);
                        }
                        objArr = objArr8;
                    }
                    int i147 = ((int[]) objArr[1])[0];
                    int i148 = artificialFrame;
                    int i149 = ((i148 | 105) << 1) - (i148 ^ 105);
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i149 % 128;
                    int i150 = i149 % 2;
                    if (i147 != i) {
                        i14 = 2;
                    } else {
                        try {
                            Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1330934317);
                            if (objAccessartificialFrame3 == null) {
                                int i151 = 21 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                                char touchSlop = (char) (29754 - (ViewConfiguration.getTouchSlop() >> 8));
                                int touchSlop2 = (ViewConfiguration.getTouchSlop() >> 8) + 1748;
                                byte[] bArr = $$a;
                                Object[] objArr9 = new Object[1];
                                a((byte) (-bArr[8]), bArr[13], (byte) 42, objArr9);
                                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(i151, touchSlop, touchSlop2, 802081755, false, (String) objArr9[0], new Class[0]);
                            }
                            Set set = (Set) ((Method) objAccessartificialFrame3).invoke(null, null);
                            Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-613930663);
                            if (objAccessartificialFrame4 == null) {
                                int packedPositionType = 20 - ExpandableListView.getPackedPositionType(0L);
                                char cAxisFromString = (char) (29753 - MotionEvent.axisFromString(""));
                                int gidForName = Process.getGidForName("") + 1749;
                                byte[] bArr2 = $$a;
                                byte b3 = (byte) (-bArr2[8]);
                                byte b4 = bArr2[62];
                                Object[] objArr10 = new Object[1];
                                a(b3, b4, b4, objArr10);
                                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(packedPositionType, cAxisFromString, gidForName, 1141731153, false, (String) objArr10[0], null);
                            }
                            if (!set.contains(((Field) objAccessartificialFrame4).get(null))) {
                                int i152 = artificialFrame;
                                int i153 = (i152 & 11) + (i152 | 11);
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i153 % 128;
                                if (i153 % 2 != 0) {
                                    Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1912765649);
                                    if (objAccessartificialFrame5 == null) {
                                        int scrollBarSize = (ViewConfiguration.getScrollBarSize() >> 8) + 20;
                                        char bitsPerPixel = (char) (29753 - ImageFormat.getBitsPerPixel(0));
                                        int iKeyCodeFromString = KeyEvent.keyCodeFromString("") + 1748;
                                        byte[] bArr3 = $$a;
                                        Object[] objArr11 = new Object[1];
                                        a((byte) (-bArr3[7]), (byte) (-bArr3[38]), bArr3[62], objArr11);
                                        objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(scrollBarSize, bitsPerPixel, iKeyCodeFromString, 312001831, false, (String) objArr11[0], null);
                                    }
                                    Object obj = null;
                                    set.contains(((Field) objAccessartificialFrame5).get(null));
                                    obj.hashCode();
                                    throw null;
                                }
                                Object objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1912765649);
                                if (objAccessartificialFrame6 == null) {
                                    int size2 = View.MeasureSpec.getSize(0) + 20;
                                    char cResolveOpacity = (char) (29754 - Drawable.resolveOpacity(0, 0));
                                    int tapTimeout = 1748 - (ViewConfiguration.getTapTimeout() >> 16);
                                    byte[] bArr4 = $$a;
                                    Object[] objArr12 = new Object[1];
                                    a((byte) (-bArr4[7]), (byte) (-bArr4[38]), bArr4[62], objArr12);
                                    objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(size2, cResolveOpacity, tapTimeout, 312001831, false, (String) objArr12[0], null);
                                }
                                if (!set.contains(((Field) objAccessartificialFrame6).get(null))) {
                                    if ((i2 & 32) == 0) {
                                        if (Build.VERSION.SDK_INT > 33) {
                                            int iMyTid = Process.myTid() >> 22;
                                            int iUpdateVisuals4 = Iterables.AnonymousClass9.updateVisuals();
                                            int i154 = ~((~iMyTid) | (-988677207));
                                            int i155 = (i154 & iUpdateVisuals4) | (iUpdateVisuals4 ^ i154);
                                            int i156 = ~((iMyTid ^ 988677206) | (iMyTid & 988677206));
                                            int i157 = ((iMyTid * (-375)) - 1386764794) + (((i155 & i156) | (i155 ^ i156)) * 376);
                                            int i158 = ~((~iUpdateVisuals4) | iMyTid);
                                            int i159 = (i157 - (~(-(-(((i158 & i156) | (i158 ^ i156)) * (-376)))))) - 1;
                                            int i160 = ~iMyTid;
                                            int i161 = ~((i160 & iUpdateVisuals4) | (i160 ^ iUpdateVisuals4));
                                            int i162 = i159 + (((i161 & 988677206) | (i161 ^ 988677206)) * 376);
                                            byte b5 = (byte) (0 - (~(-(-TextUtils.lastIndexOf("", '0', 0)))));
                                            int i163 = -View.resolveSizeAndState(0, 0, 0);
                                            int iUpdateVisuals5 = Iterables.AnonymousClass9.updateVisuals();
                                            int i164 = (i163 * JfifUtil.MARKER_EOI) + 6020 + ((~((i163 ^ iUpdateVisuals5) | (i163 & iUpdateVisuals5))) * JfifUtil.MARKER_SOI);
                                            int i165 = (i163 ^ 27) | (i163 & 27);
                                            int i166 = ~iUpdateVisuals5;
                                            int i167 = ((i165 & i166) | (i165 ^ i166)) * (-216);
                                            int i168 = (((i164 & i167) + (i164 | i167)) - (~(((~(i163 | (~iUpdateVisuals5))) | (-28)) * JfifUtil.MARKER_SOI))) - 1;
                                            int i169 = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                                            int i170 = (i169 * (-559)) - 29172;
                                            int i171 = ~i;
                                            int i172 = -(-((~((i171 ^ i169) | (i171 & i169))) * (-560)));
                                            int i173 = ((i170 | i172) << 1) - (i170 ^ i172);
                                            int i174 = (51 & i169) | (51 ^ i169);
                                            int i175 = -(-((~((i174 & i) | (i174 ^ i))) * (-560)));
                                            int i176 = ((i173 | i175) << 1) - (i175 ^ i173);
                                            int i177 = ~((~i169) | (-52));
                                            int i178 = ~(i171 | (-52));
                                            short s4 = (short) (i176 + (((i177 & i178) | (i177 ^ i178)) * 560));
                                            int iIndexOf = TextUtils.indexOf("", "", 0);
                                            int i179 = (iIndexOf ^ 1139233292) + ((iIndexOf & 1139233292) << 1);
                                            Object[] objArr13 = new Object[1];
                                            b(i162, b5, i168, s4, i179, objArr13);
                                            Object[] objArr14 = {(String) objArr13[0]};
                                            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(267846469);
                                            if (objAccessartificialFrame2 == null) {
                                                int i180 = (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 16;
                                                char keyRepeatTimeout = (char) (24343 - (ViewConfiguration.getKeyRepeatTimeout() >> 16));
                                                int i181 = 2014 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                                                byte[] bArr5 = $$a;
                                                Object[] objArr15 = new Object[1];
                                                a(bArr5[62], (byte) (-bArr5[44]), (byte) (-bArr5[11]), objArr15);
                                                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(i180, keyRepeatTimeout, i181, -1869462195, false, (String) objArr15[0], new Class[]{String.class});
                                            }
                                            long jLongValue = ((Long) ((Method) objAccessartificialFrame2).invoke(null, objArr14)).longValue();
                                            long j = -906717170;
                                            long j2 = 829;
                                            long j3 = (j2 * j) + (j2 * jLongValue);
                                            long j4 = -828;
                                            long j5 = -1;
                                            long jUptimeMillis = ((long) ((int) SystemClock.uptimeMillis())) ^ j5;
                                            long j6 = j3 + (((((j ^ j5) | (jLongValue ^ j5)) ^ j5) | (((jUptimeMillis | j) | jLongValue) ^ j5)) * j4);
                                            long j7 = jLongValue | j;
                                            long j8 = j6 + (j4 * (j7 | jUptimeMillis)) + (((long) 828) * (j7 ^ j5)) + ((long) (-404914806));
                                            int elapsedCpuTime = (int) Process.getElapsedCpuTime();
                                            int i182 = ~elapsedCpuTime;
                                            i9 = ((int) (j8 >> 32)) & (((((~(2058350555 | i182)) | (~((-42093337) | elapsedCpuTime))) * 988) - 644494970) + (((~(elapsedCpuTime | 579030808)) | 1479319747 | (~(i182 | (-42093337)))) * 988));
                                            i10 = (int) j8;
                                            iNextInt = new Random().nextInt();
                                            if ((i9 | (i10 & (902178707 + (((~((-341210419) | iNextInt)) | 1096015991) * (-465)) + (((-341210419) | (~(1096015991 | iNextInt))) * 930) + ((iNextInt | (-335811841)) * 465)))) == 1) {
                                                int i183 = getARTIFICIAL_FRAME_PACKAGE_NAME + 101;
                                                artificialFrame = i183 % 128;
                                                int i184 = i183 % 2;
                                                Object[] objArr16 = {new int[]{i}, new int[]{(~(i & 10)) & (i | 10)}, new int[1], null};
                                                int iUptimeMillis = (int) SystemClock.uptimeMillis();
                                                int i185 = (-687433986) + ((~(iUptimeMillis | 863253321)) * JfifUtil.MARKER_SOI);
                                                int i186 = ~iUptimeMillis;
                                                int i187 = i185 + (((-75516053) | i186) * (-216)) + (((~(i186 | 863253321)) | 115370453) * JfifUtil.MARKER_SOI) + 16;
                                                int i188 = ((i187 * 51) - (~(-(-(i3 * (-49)))))) - 1;
                                                int i189 = ((i187 ^ i) | (i187 & i)) * (-50);
                                                int i190 = (i188 ^ i189) + ((i188 & i189) << 1);
                                                int i191 = ~i187;
                                                int i192 = ~i3;
                                                int i193 = (i191 & i192) | (i191 ^ i192);
                                                int i194 = ~((i193 & i) | (i193 ^ i));
                                                int i195 = ~i3;
                                                int i196 = ~i;
                                                int i197 = (i196 & i195) | (i195 ^ i196);
                                                int i198 = ~((i197 & i187) | (i197 ^ i187));
                                                int i199 = ((i194 & i198) | (i194 ^ i198)) * 50;
                                                int i200 = (i190 & i199) + (i199 | i190);
                                                int i201 = ~i;
                                                int i202 = ~((i192 ^ i201) | (i192 & i201));
                                                int i203 = ~(i195 | i187);
                                                int i204 = (i202 & i203) | (i202 ^ i203);
                                                int i205 = ~(i201 | i187);
                                                int i206 = -(-(((i205 & i204) | (i204 ^ i205)) * 50));
                                                int i207 = (i200 & i206) + (i206 | i200);
                                                int i208 = i207 << 13;
                                                int i209 = (i208 | i207) & (~(i207 & i208));
                                                int i210 = i209 >>> 17;
                                                int i211 = (i209 | i210) & (~(i209 & i210));
                                                ((int[]) objArr16[2])[0] = i211 ^ (i211 << 5);
                                                objArr = objArr16;
                                            }
                                        } else {
                                            int i212 = -(-View.combineMeasuredStates(0, 0));
                                            int i213 = (i212 ^ 988677273) + ((i212 & 988677273) << 1);
                                            byte bArgb = (byte) Color.argb(0, 0, 0, 0);
                                            int i214 = -TextUtils.indexOf((CharSequence) "", '0', 0, 0);
                                            int i215 = (i214 * (-958)) + 27782;
                                            int i216 = ~i;
                                            int i217 = ~((28 & i216) | (28 ^ i216));
                                            int i218 = ~i214;
                                            int i219 = i217 | (~((i218 ^ i) | (i218 & i)));
                                            int i220 = ~i;
                                            int i221 = (i219 | (~((i220 ^ i214) | (i220 & i214)))) * 959;
                                            int i222 = (((i215 | i221) << 1) - (i215 ^ i221)) + ((~((i214 ^ (-29)) | (i214 & (-29)))) * (-959));
                                            int i223 = ~(i218 | i216);
                                            int i224 = ~((28 & i) | (28 ^ i));
                                            int i225 = (i223 & i224) | (i223 ^ i224);
                                            int i226 = ~((i214 & i) | (i214 ^ i));
                                            int i227 = ((i226 & i225) | (i225 ^ i226)) * 959;
                                            int i228 = (i222 & i227) + (i227 | i222);
                                            int i229 = -Color.rgb(0, 0, 0);
                                            int iUpdateVisuals6 = Iterables.AnonymousClass9.updateVisuals();
                                            int i230 = i229 * (-958);
                                            int i231 = (i230 ^ (-1107190876)) + ((i230 & (-1107190876)) << 1);
                                            int i232 = ~iUpdateVisuals6;
                                            int i233 = ~((16777325 ^ i232) | (16777325 & i232));
                                            int i234 = ~i229;
                                            int i235 = ~((i234 ^ iUpdateVisuals6) | (i234 & iUpdateVisuals6));
                                            int i236 = (i233 ^ i235) | (i235 & i233);
                                            int i237 = ~((i232 & i229) | (i232 ^ i229));
                                            int i238 = (i231 - (~(-(-(((i237 & i236) | (i236 ^ i237)) * 959))))) - 1;
                                            int i239 = -(-((~(((-16777326) & i229) | (i229 ^ (-16777326)))) * (-959)));
                                            int i240 = (i238 & i239) + (i239 | i238);
                                            int i241 = ~((~iUpdateVisuals6) | i234);
                                            int i242 = ~((16777325 & iUpdateVisuals6) | (16777325 ^ iUpdateVisuals6));
                                            int i243 = (i241 & i242) | (i241 ^ i242);
                                            int i244 = ~((i229 & iUpdateVisuals6) | (i229 ^ iUpdateVisuals6));
                                            short s5 = (short) ((i240 - (~(-(-(((i244 & i243) | (i243 ^ i244)) * 959))))) - 1);
                                            int iIndexOf2 = TextUtils.indexOf("", "", 0, 0);
                                            int i245 = iIndexOf2 * 450;
                                            int i246 = (i245 ^ 724580864) + ((i245 & 724580864) << 1);
                                            int i247 = ~iIndexOf2;
                                            int i248 = ((-1139233321) & iIndexOf2) | ((-1139233321) ^ iIndexOf2);
                                            int i249 = ((i246 - (~(((~(i247 | 1139233320)) | (~((i248 & i) | (i248 ^ i)))) * 449))) - 1) + ((~((~iIndexOf2) | 1139233320)) * (-1347));
                                            int i250 = ~((i247 & 1139233320) | (i247 ^ 1139233320));
                                            int i251 = ~(iIndexOf2 | ((-1139233321) & i216) | ((-1139233321) ^ i216));
                                            int i252 = i249 + (((i251 & i250) | (i250 ^ i251)) * 449);
                                            Object[] objArr17 = new Object[1];
                                            b(i213, bArgb, i228, s5, i252, objArr17);
                                            Object[] objArr18 = {(String) objArr17[0]};
                                            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1483923676);
                                            if (objAccessartificialFrame == null) {
                                                int defaultSize = View.getDefaultSize(0, 0) + 23;
                                                char cResolveSizeAndState = (char) View.resolveSizeAndState(0, 0, 0);
                                                int iResolveSizeAndState = View.resolveSizeAndState(0, 0, 0) + 2441;
                                                byte b6 = (byte) ($$b & 7);
                                                Object[] objArr19 = new Object[1];
                                                a(b6, (byte) (b6 | Ascii.DC4), (byte) (-$$a[38]), objArr19);
                                                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(defaultSize, cResolveSizeAndState, iResolveSizeAndState, 954751276, false, (String) objArr19[0], new Class[]{String.class});
                                            }
                                            objInvoke = ((Method) objAccessartificialFrame).invoke(null, objArr18);
                                            int i253 = -(SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                                            int i254 = ((i253 | 988677209) << 1) - (i253 ^ 988677209);
                                            byte fadingEdgeLength2 = (byte) (ViewConfiguration.getFadingEdgeLength() >> 16);
                                            int threadPriority = Process.getThreadPriority(0);
                                            int iUpdateVisuals7 = Iterables.AnonymousClass9.updateVisuals();
                                            int i255 = threadPriority * 370;
                                            int i256 = (7400 & i255) + (i255 | 7400);
                                            int i257 = (threadPriority ^ 20) | (threadPriority & 20);
                                            int i258 = ~iUpdateVisuals7;
                                            int i259 = ((i256 - (~(-(-(((i257 & i258) | (i257 ^ i258)) * (-369)))))) - 1) + (((~(((-21) & i258) | ((-21) ^ i258))) | threadPriority) * (-369));
                                            int i260 = ~threadPriority;
                                            int i261 = ~((i260 & 20) | (i260 ^ 20));
                                            int i262 = ~((iUpdateVisuals7 ^ 20) | (iUpdateVisuals7 & 20));
                                            int i263 = (i261 & i262) | (i261 ^ i262);
                                            int i264 = ~iUpdateVisuals7;
                                            int i265 = (i264 & (-21)) | ((-21) ^ i264);
                                            int i266 = ~((i265 & threadPriority) | (i265 ^ threadPriority));
                                            int i267 = ((i266 & i263) | (i263 ^ i266)) * 369;
                                            int i268 = -(((i259 ^ i267) + ((i267 & i259) << 1)) >> 6);
                                            int iUpdateVisuals8 = Iterables.AnonymousClass9.updateVisuals();
                                            int i269 = ~i268;
                                            int i270 = ~((i269 & 27) | (i269 ^ 27));
                                            int i271 = ~((i268 ^ (-28)) | (i268 & (-28)));
                                            int i272 = (((i268 * (-375)) + 10500) - (~((((i270 & iUpdateVisuals8) | (iUpdateVisuals8 ^ i270)) | i271) * 376))) - 1;
                                            int i273 = ~iUpdateVisuals8;
                                            int i274 = (i271 | (~((i273 & i268) | (i273 ^ i268)))) * (-376);
                                            int i275 = ~i268;
                                            int i276 = ~((i275 & iUpdateVisuals8) | (i275 ^ iUpdateVisuals8));
                                            int i277 = (((i272 ^ i274) + ((i272 & i274) << 1)) - (~(((i276 & (-28)) | (i276 ^ (-28))) * 376))) - 1;
                                            int i278 = -ExpandableListView.getPackedPositionChild(0L);
                                            int i279 = i278 * (-563);
                                            int i280 = ((i279 | (-44070)) << 1) - (i279 ^ (-44070));
                                            int i281 = ((~i278) | (~((i216 & 77) | (77 ^ i216))) | (~((i ^ (-78)) | (i & (-78))))) * (-564);
                                            int i282 = ((i280 | i281) << 1) - (i281 ^ i280);
                                            int i283 = ~i278;
                                            int i284 = (i283 ^ (-78)) | (i283 & (-78));
                                            int i285 = -(-((~((i284 & i) | (i284 ^ i))) * 1128));
                                            int i286 = ~((i283 & i220) | (i283 ^ i220));
                                            int i287 = ~((i278 & (-78)) | (i278 ^ (-78)));
                                            short s6 = (short) ((((i282 & i285) + (i282 | i285)) - (~(((i286 & i287) | (i286 ^ i287)) * 564))) - 1);
                                            int i288 = -(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1));
                                            int iUpdateVisuals9 = Iterables.AnonymousClass9.updateVisuals();
                                            int i289 = (i288 * (-665)) - 1748156456;
                                            int i290 = ~i288;
                                            int i291 = -(-(i290 * (-333)));
                                            int i292 = ((i289 | i291) << 1) - (i289 ^ i291);
                                            int i293 = ~i288;
                                            int i294 = ~iUpdateVisuals9;
                                            int i295 = ~(i293 | i294);
                                            int i296 = ~((iUpdateVisuals9 ^ 1139233332) | (iUpdateVisuals9 & 1139233332));
                                            int i297 = (i292 - (~(((i295 & i296) | (i295 ^ i296)) * 333))) - 1;
                                            int i298 = ~((i290 ^ iUpdateVisuals9) | (iUpdateVisuals9 & i290));
                                            int i299 = ~(i294 | 1139233332);
                                            int i300 = -(-(((i298 & i299) | (i298 ^ i299)) * 333));
                                            int i301 = (i297 ^ i300) + ((i300 & i297) << 1);
                                            objArr2 = new Object[1];
                                            b(i254, fadingEdgeLength2, i277, s6, i301, objArr2);
                                            if (objInvoke.equals((String) objArr2[0])) {
                                                Object[] objArr110 = {new int[]{i}, new int[]{(~(i & 10)) & (i | 10)}, new int[1], null};
                                                int iUptimeMillis2 = (int) SystemClock.uptimeMillis();
                                                int i1810 = (-687433986) + ((~(iUptimeMillis2 | 863253321)) * JfifUtil.MARKER_SOI);
                                                int i1811 = ~iUptimeMillis2;
                                                int i1812 = i1810 + (((-75516053) | i1811) * (-216)) + (((~(i1811 | 863253321)) | 115370453) * JfifUtil.MARKER_SOI) + 16;
                                                int i1813 = ((i1812 * 51) - (~(-(-(i3 * (-49)))))) - 1;
                                                int i1814 = ((i1812 ^ i) | (i1812 & i)) * (-50);
                                                int i1910 = (i1813 ^ i1814) + ((i1813 & i1814) << 1);
                                                int i1911 = ~i1812;
                                                int i1912 = ~i3;
                                                int i1913 = (i1911 & i1912) | (i1911 ^ i1912);
                                                int i1914 = ~((i1913 & i) | (i1913 ^ i));
                                                int i1915 = ~i3;
                                                int i1916 = ~i;
                                                int i1917 = (i1916 & i1915) | (i1915 ^ i1916);
                                                int i1918 = ~((i1917 & i1812) | (i1917 ^ i1812));
                                                int i1919 = ((i1914 & i1918) | (i1914 ^ i1918)) * 50;
                                                int i2010 = (i1910 & i1919) + (i1919 | i1910);
                                                int i2011 = ~i;
                                                int i2012 = ~((i1912 ^ i2011) | (i1912 & i2011));
                                                int i2013 = ~(i1915 | i1812);
                                                int i2014 = (i2012 & i2013) | (i2012 ^ i2013);
                                                int i2015 = ~(i2011 | i1812);
                                                int i2016 = -(-(((i2015 & i2014) | (i2014 ^ i2015)) * 50));
                                                int i2017 = (i2010 & i2016) + (i2016 | i2010);
                                                int i2018 = i2017 << 13;
                                                int i2019 = (i2018 | i2017) & (~(i2017 & i2018));
                                                int i2110 = i2019 >>> 17;
                                                int i2111 = (i2019 | i2110) & (~(i2019 & i2110));
                                                ((int[]) objArr110[2])[0] = i2111 ^ (i2111 << 5);
                                                objArr = objArr110;
                                            }
                                        }
                                    }
                                    int i302 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                    int i303 = ((i302 | 87) << 1) - (i302 ^ 87);
                                    artificialFrame = i303 % 128;
                                    int i304 = i303 % 2;
                                    int i305 = (i302 ^ 9) + ((i302 & 9) << 1);
                                    artificialFrame = i305 % 128;
                                    int i306 = i305 % 2;
                                    objArr = new Object[]{new int[]{i}, new int[]{i}, new int[1], null};
                                    int startElapsedRealtime = (int) Process.getStartElapsedRealtime();
                                    i11 = (((~(startElapsedRealtime | 688078839)) * TypedValues.CycleType.TYPE_EASING) - 573195262) + (((~((~startElapsedRealtime) | 688078839)) | 16850215) * TypedValues.CycleType.TYPE_EASING);
                                    i12 = artificialFrame + 121;
                                    int i307 = i12 % 128;
                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i307;
                                    if (i12 % 2 != 0) {
                                        i13 = ((-563) >> i11) / (565 << i3);
                                    } else {
                                        int i308 = i11 * (-563);
                                        int i309 = i3 * 565;
                                        i13 = ((i308 & i309) << 1) + (i308 ^ i309);
                                    }
                                    int i310 = ~i11;
                                    int i311 = ~i3;
                                    int i312 = ~i;
                                    int i313 = ~((i311 & i312) | (i311 ^ i312));
                                    int i314 = (-564) * ((i310 & i313) | (i310 ^ i313) | (~((i3 ^ i) | (i3 & i))));
                                    int i315 = ((i13 | i314) << 1) - (i13 ^ i314);
                                    int i316 = ~i11;
                                    int i317 = (~((i316 ^ i3) | (i316 & i3) | i)) * 1128;
                                    int i318 = (i315 & i317) + (i315 | i317);
                                    int i319 = ~((~i) | i316);
                                    int i320 = ~((i3 & i11) | (i11 ^ i3));
                                    int i321 = ((i319 & i320) | (i319 ^ i320)) * 564;
                                    int i322 = ((i318 | i321) << 1) - (i321 ^ i318);
                                    int i323 = i322 << 13;
                                    int i324 = (i323 | i322) & (~(i322 & i323));
                                    int i325 = ((i307 | 25) << 1) - (i307 ^ 25);
                                    int i326 = i325 % 128;
                                    artificialFrame = i326;
                                    int i327 = i325 % 2;
                                    int i328 = i324 ^ (i324 >>> 17);
                                    int i329 = i328 << 5;
                                    int i330 = ((~i328) & i329) | ((~i329) & i328);
                                    i14 = 2;
                                    ((int[]) objArr[2])[0] = i330;
                                    int i331 = i326 + 17;
                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i331 % 128;
                                    int i332 = i331 % 2;
                                } else if (Build.VERSION.SDK_INT == 30) {
                                    int i333 = getARTIFICIAL_FRAME_PACKAGE_NAME + 61;
                                    artificialFrame = i333 % 128;
                                    int i334 = i333 % 2;
                                    objArr = new Object[]{new int[]{i}, new int[]{i}, new int[1], null};
                                    int i335 = (-78226562) + (((~(769065825 | i)) | 209557949) * 672);
                                    int i336 = ~i;
                                    int i337 = i335 + (((~(209557949 | i)) | (~((-769065826) | i336))) * (-672)) + (((~((-209557950) | i336)) | 2660508) * 672);
                                    int i338 = ~(((-1) ^ i336) | i336);
                                    int i339 = ~i337;
                                    int i340 = (i339 & i) | (i339 ^ i);
                                    int i341 = (i337 * (-574)) + ((i338 | (~i340)) * 1150);
                                    int i342 = ~i340;
                                    int i343 = ~((i337 & i336) | (i336 ^ i337));
                                    int i344 = ((i343 & i342) | (i342 ^ i343)) * (-575);
                                    int i345 = (i341 & i344) + (i341 | i344) + (((~(i | ((-1) ^ i))) | (~i336)) * 575);
                                    int iUpdateVisuals10 = Iterables.AnonymousClass9.updateVisuals();
                                    int i346 = ((i345 * 659) - (~(-(-(i3 * (-657)))))) - 1;
                                    int i347 = ~i345;
                                    int i348 = ~((i347 & i3) | (i347 ^ i3));
                                    int i349 = ~i3;
                                    int i350 = (i349 & i345) | (i349 ^ i345);
                                    int i351 = ~i350;
                                    int i352 = (i348 & i351) | (i348 ^ i351);
                                    int i353 = ~((iUpdateVisuals10 & i345) | (i345 ^ iUpdateVisuals10));
                                    int i354 = ((i352 & i353) | (i352 ^ i353)) * (-658);
                                    int i355 = (((i346 ^ i354) + ((i346 & i354) << 1)) - (~((~i350) * 658))) - 1;
                                    int i356 = (i353 | (~((~i3) | i345))) * 658;
                                    int i357 = ((i355 | i356) << 1) - (i356 ^ i355);
                                    int i358 = i357 << 13;
                                    int i359 = (i358 & (~i357)) | ((~i358) & i357);
                                    int i360 = i359 >>> 17;
                                    int i361 = ((~i359) & i360) | ((~i360) & i359);
                                    ((int[]) objArr[2])[0] = i361 ^ (i361 << 5);
                                } else {
                                    if ((i2 & 32) == 0) {
                                        try {
                                            if (Build.VERSION.SDK_INT > 33) {
                                                int iMyTid2 = Process.myTid() >> 22;
                                                int iUpdateVisuals11 = Iterables.AnonymousClass9.updateVisuals();
                                                int i1510 = ~((~iMyTid2) | (-988677207));
                                                int i1511 = (i1510 & iUpdateVisuals11) | (iUpdateVisuals11 ^ i1510);
                                                int i1512 = ~((iMyTid2 ^ 988677206) | (iMyTid2 & 988677206));
                                                int i1513 = ((iMyTid2 * (-375)) - 1386764794) + (((i1511 & i1512) | (i1511 ^ i1512)) * 376);
                                                int i1514 = ~((~iUpdateVisuals11) | iMyTid2);
                                                int i1515 = (i1513 - (~(-(-(((i1514 & i1512) | (i1514 ^ i1512)) * (-376)))))) - 1;
                                                int i1610 = ~iMyTid2;
                                                int i1611 = ~((i1610 & iUpdateVisuals11) | (i1610 ^ iUpdateVisuals11));
                                                int i1612 = i1515 + (((i1611 & 988677206) | (i1611 ^ 988677206)) * 376);
                                                byte b7 = (byte) (0 - (~(-(-TextUtils.lastIndexOf("", '0', 0)))));
                                                int i1613 = -View.resolveSizeAndState(0, 0, 0);
                                                int iUpdateVisuals12 = Iterables.AnonymousClass9.updateVisuals();
                                                int i1614 = (i1613 * JfifUtil.MARKER_EOI) + 6020 + ((~((i1613 ^ iUpdateVisuals12) | (i1613 & iUpdateVisuals12))) * JfifUtil.MARKER_SOI);
                                                int i1615 = (i1613 ^ 27) | (i1613 & 27);
                                                int i1616 = ~iUpdateVisuals12;
                                                int i1617 = ((i1615 & i1616) | (i1615 ^ i1616)) * (-216);
                                                int i1618 = (((i1614 & i1617) + (i1614 | i1617)) - (~(((~(i1613 | (~iUpdateVisuals12))) | (-28)) * JfifUtil.MARKER_SOI))) - 1;
                                                int i1619 = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                                                int i1710 = (i1619 * (-559)) - 29172;
                                                int i1711 = ~i;
                                                int i1712 = -(-((~((i1711 ^ i1619) | (i1711 & i1619))) * (-560)));
                                                int i1713 = ((i1710 | i1712) << 1) - (i1710 ^ i1712);
                                                int i1714 = (51 & i1619) | (51 ^ i1619);
                                                int i1715 = -(-((~((i1714 & i) | (i1714 ^ i))) * (-560)));
                                                int i1716 = ((i1713 | i1715) << 1) - (i1715 ^ i1713);
                                                int i1717 = ~((~i1619) | (-52));
                                                int i1718 = ~(i1711 | (-52));
                                                short s7 = (short) (i1716 + (((i1717 & i1718) | (i1717 ^ i1718)) * 560));
                                                int iIndexOf3 = TextUtils.indexOf("", "", 0);
                                                int i1719 = (iIndexOf3 ^ 1139233292) + ((iIndexOf3 & 1139233292) << 1);
                                                Object[] objArr111 = new Object[1];
                                                b(i1612, b7, i1618, s7, i1719, objArr111);
                                                try {
                                                    Object[] objArr112 = {(String) objArr111[0]};
                                                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(267846469);
                                                    if (objAccessartificialFrame2 == null) {
                                                        int i1815 = (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 16;
                                                        char keyRepeatTimeout2 = (char) (24343 - (ViewConfiguration.getKeyRepeatTimeout() >> 16));
                                                        int i1816 = 2014 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                                                        byte[] bArr6 = $$a;
                                                        Object[] objArr113 = new Object[1];
                                                        a(bArr6[62], (byte) (-bArr6[44]), (byte) (-bArr6[11]), objArr113);
                                                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(i1815, keyRepeatTimeout2, i1816, -1869462195, false, (String) objArr113[0], new Class[]{String.class});
                                                    }
                                                    long jLongValue2 = ((Long) ((Method) objAccessartificialFrame2).invoke(null, objArr112)).longValue();
                                                    long j9 = -906717170;
                                                    long j10 = 829;
                                                    long j11 = (j10 * j9) + (j10 * jLongValue2);
                                                    long j12 = -828;
                                                    long j13 = -1;
                                                    long jUptimeMillis2 = ((long) ((int) SystemClock.uptimeMillis())) ^ j13;
                                                    long j14 = j11 + (((((j9 ^ j13) | (jLongValue2 ^ j13)) ^ j13) | (((jUptimeMillis2 | j9) | jLongValue2) ^ j13)) * j12);
                                                    long j15 = jLongValue2 | j9;
                                                    long j16 = j14 + (j12 * (j15 | jUptimeMillis2)) + (((long) 828) * (j15 ^ j13)) + ((long) (-404914806));
                                                    int elapsedCpuTime2 = (int) Process.getElapsedCpuTime();
                                                    int i1817 = ~elapsedCpuTime2;
                                                    i9 = ((int) (j16 >> 32)) & (((((~(2058350555 | i1817)) | (~((-42093337) | elapsedCpuTime2))) * 988) - 644494970) + (((~(elapsedCpuTime2 | 579030808)) | 1479319747 | (~(i1817 | (-42093337)))) * 988));
                                                    i10 = (int) j16;
                                                    iNextInt = new Random().nextInt();
                                                    if ((i9 | (i10 & (902178707 + (((~((-341210419) | iNextInt)) | 1096015991) * (-465)) + (((-341210419) | (~(1096015991 | iNextInt))) * 930) + ((iNextInt | (-335811841)) * 465)))) == 1) {
                                                        int i1818 = getARTIFICIAL_FRAME_PACKAGE_NAME + 101;
                                                        artificialFrame = i1818 % 128;
                                                        int i1819 = i1818 % 2;
                                                        Object[] objArr114 = {new int[]{i}, new int[]{(~(i & 10)) & (i | 10)}, new int[1], null};
                                                        int iUptimeMillis3 = (int) SystemClock.uptimeMillis();
                                                        int i18110 = (-687433986) + ((~(iUptimeMillis3 | 863253321)) * JfifUtil.MARKER_SOI);
                                                        int i18111 = ~iUptimeMillis3;
                                                        int i18112 = i18110 + (((-75516053) | i18111) * (-216)) + (((~(i18111 | 863253321)) | 115370453) * JfifUtil.MARKER_SOI) + 16;
                                                        int i18113 = ((i18112 * 51) - (~(-(-(i3 * (-49)))))) - 1;
                                                        int i18114 = ((i18112 ^ i) | (i18112 & i)) * (-50);
                                                        int i19110 = (i18113 ^ i18114) + ((i18113 & i18114) << 1);
                                                        int i19111 = ~i18112;
                                                        int i19112 = ~i3;
                                                        int i19113 = (i19111 & i19112) | (i19111 ^ i19112);
                                                        int i19114 = ~((i19113 & i) | (i19113 ^ i));
                                                        int i19115 = ~i3;
                                                        int i19116 = ~i;
                                                        int i19117 = (i19116 & i19115) | (i19115 ^ i19116);
                                                        int i19118 = ~((i19117 & i18112) | (i19117 ^ i18112));
                                                        int i19119 = ((i19114 & i19118) | (i19114 ^ i19118)) * 50;
                                                        int i20110 = (i19110 & i19119) + (i19119 | i19110);
                                                        int i20111 = ~i;
                                                        int i20112 = ~((i19112 ^ i20111) | (i19112 & i20111));
                                                        int i20113 = ~(i19115 | i18112);
                                                        int i20114 = (i20112 & i20113) | (i20112 ^ i20113);
                                                        int i20115 = ~(i20111 | i18112);
                                                        int i20116 = -(-(((i20115 & i20114) | (i20114 ^ i20115)) * 50));
                                                        int i20117 = (i20110 & i20116) + (i20116 | i20110);
                                                        int i20118 = i20117 << 13;
                                                        int i20119 = (i20118 | i20117) & (~(i20117 & i20118));
                                                        int i2112 = i20119 >>> 17;
                                                        int i2113 = (i20119 | i2112) & (~(i20119 & i2112));
                                                        ((int[]) objArr114[2])[0] = i2113 ^ (i2113 << 5);
                                                        objArr = objArr114;
                                                    }
                                                } catch (Throwable th) {
                                                    Throwable cause = th.getCause();
                                                    if (cause != null) {
                                                        throw cause;
                                                    }
                                                    throw th;
                                                }
                                            } else {
                                                int i2114 = -(-View.combineMeasuredStates(0, 0));
                                                int i2115 = (i2114 ^ 988677273) + ((i2114 & 988677273) << 1);
                                                byte bArgb2 = (byte) Color.argb(0, 0, 0, 0);
                                                int i2116 = -TextUtils.indexOf((CharSequence) "", '0', 0, 0);
                                                int i2117 = (i2116 * (-958)) + 27782;
                                                int i2118 = ~i;
                                                int i2119 = ~((28 & i2118) | (28 ^ i2118));
                                                int i2120 = ~i2116;
                                                int i2121 = i2119 | (~((i2120 ^ i) | (i2120 & i)));
                                                int i2210 = ~i;
                                                int i2211 = (i2121 | (~((i2210 ^ i2116) | (i2210 & i2116)))) * 959;
                                                int i2212 = (((i2117 | i2211) << 1) - (i2117 ^ i2211)) + ((~((i2116 ^ (-29)) | (i2116 & (-29)))) * (-959));
                                                int i2213 = ~(i2120 | i2118);
                                                int i2214 = ~((28 & i) | (28 ^ i));
                                                int i2215 = (i2213 & i2214) | (i2213 ^ i2214);
                                                int i2216 = ~((i2116 & i) | (i2116 ^ i));
                                                int i2217 = ((i2216 & i2215) | (i2215 ^ i2216)) * 959;
                                                int i2218 = (i2212 & i2217) + (i2217 | i2212);
                                                int i2219 = -Color.rgb(0, 0, 0);
                                                int iUpdateVisuals13 = Iterables.AnonymousClass9.updateVisuals();
                                                int i2310 = i2219 * (-958);
                                                int i2311 = (i2310 ^ (-1107190876)) + ((i2310 & (-1107190876)) << 1);
                                                int i2312 = ~iUpdateVisuals13;
                                                int i2313 = ~((16777325 ^ i2312) | (16777325 & i2312));
                                                int i2314 = ~i2219;
                                                int i2315 = ~((i2314 ^ iUpdateVisuals13) | (i2314 & iUpdateVisuals13));
                                                int i2316 = (i2313 ^ i2315) | (i2315 & i2313);
                                                int i2317 = ~((i2312 & i2219) | (i2312 ^ i2219));
                                                int i2318 = (i2311 - (~(-(-(((i2317 & i2316) | (i2316 ^ i2317)) * 959))))) - 1;
                                                int i2319 = -(-((~(((-16777326) & i2219) | (i2219 ^ (-16777326)))) * (-959)));
                                                int i2410 = (i2318 & i2319) + (i2319 | i2318);
                                                int i2411 = ~((~iUpdateVisuals13) | i2314);
                                                int i2412 = ~((16777325 & iUpdateVisuals13) | (16777325 ^ iUpdateVisuals13));
                                                int i2413 = (i2411 & i2412) | (i2411 ^ i2412);
                                                int i2414 = ~((i2219 & iUpdateVisuals13) | (i2219 ^ iUpdateVisuals13));
                                                short s8 = (short) ((i2410 - (~(-(-(((i2414 & i2413) | (i2413 ^ i2414)) * 959))))) - 1);
                                                int iIndexOf4 = TextUtils.indexOf("", "", 0, 0);
                                                int i2415 = iIndexOf4 * 450;
                                                int i2416 = (i2415 ^ 724580864) + ((i2415 & 724580864) << 1);
                                                int i2417 = ~iIndexOf4;
                                                int i2418 = ((-1139233321) & iIndexOf4) | ((-1139233321) ^ iIndexOf4);
                                                int i2419 = ((i2416 - (~(((~(i2417 | 1139233320)) | (~((i2418 & i) | (i2418 ^ i)))) * 449))) - 1) + ((~((~iIndexOf4) | 1139233320)) * (-1347));
                                                int i2510 = ~((i2417 & 1139233320) | (i2417 ^ 1139233320));
                                                int i2511 = ~(iIndexOf4 | ((-1139233321) & i2118) | ((-1139233321) ^ i2118));
                                                int i2512 = i2419 + (((i2511 & i2510) | (i2510 ^ i2511)) * 449);
                                                Object[] objArr115 = new Object[1];
                                                b(i2115, bArgb2, i2218, s8, i2512, objArr115);
                                                try {
                                                    Object[] objArr116 = {(String) objArr115[0]};
                                                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1483923676);
                                                    if (objAccessartificialFrame == null) {
                                                        int defaultSize2 = View.getDefaultSize(0, 0) + 23;
                                                        char cResolveSizeAndState2 = (char) View.resolveSizeAndState(0, 0, 0);
                                                        int iResolveSizeAndState2 = View.resolveSizeAndState(0, 0, 0) + 2441;
                                                        byte b8 = (byte) ($$b & 7);
                                                        Object[] objArr117 = new Object[1];
                                                        a(b8, (byte) (b8 | Ascii.DC4), (byte) (-$$a[38]), objArr117);
                                                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(defaultSize2, cResolveSizeAndState2, iResolveSizeAndState2, 954751276, false, (String) objArr117[0], new Class[]{String.class});
                                                    }
                                                    objInvoke = ((Method) objAccessartificialFrame).invoke(null, objArr116);
                                                    int i2513 = -(SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                                                    int i2514 = ((i2513 | 988677209) << 1) - (i2513 ^ 988677209);
                                                    byte fadingEdgeLength3 = (byte) (ViewConfiguration.getFadingEdgeLength() >> 16);
                                                    int threadPriority2 = Process.getThreadPriority(0);
                                                    int iUpdateVisuals14 = Iterables.AnonymousClass9.updateVisuals();
                                                    int i2515 = threadPriority2 * 370;
                                                    int i2516 = (7400 & i2515) + (i2515 | 7400);
                                                    int i2517 = (threadPriority2 ^ 20) | (threadPriority2 & 20);
                                                    int i2518 = ~iUpdateVisuals14;
                                                    int i2519 = ((i2516 - (~(-(-(((i2517 & i2518) | (i2517 ^ i2518)) * (-369)))))) - 1) + (((~(((-21) & i2518) | ((-21) ^ i2518))) | threadPriority2) * (-369));
                                                    int i2610 = ~threadPriority2;
                                                    int i2611 = ~((i2610 & 20) | (i2610 ^ 20));
                                                    int i2612 = ~((iUpdateVisuals14 ^ 20) | (iUpdateVisuals14 & 20));
                                                    int i2613 = (i2611 & i2612) | (i2611 ^ i2612);
                                                    int i2614 = ~iUpdateVisuals14;
                                                    int i2615 = (i2614 & (-21)) | ((-21) ^ i2614);
                                                    int i2616 = ~((i2615 & threadPriority2) | (i2615 ^ threadPriority2));
                                                    int i2617 = ((i2616 & i2613) | (i2613 ^ i2616)) * 369;
                                                    int i2618 = -(((i2519 ^ i2617) + ((i2617 & i2519) << 1)) >> 6);
                                                    int iUpdateVisuals15 = Iterables.AnonymousClass9.updateVisuals();
                                                    int i2619 = ~i2618;
                                                    int i2710 = ~((i2619 & 27) | (i2619 ^ 27));
                                                    int i2711 = ~((i2618 ^ (-28)) | (i2618 & (-28)));
                                                    int i2712 = (((i2618 * (-375)) + 10500) - (~((((i2710 & iUpdateVisuals15) | (iUpdateVisuals15 ^ i2710)) | i2711) * 376))) - 1;
                                                    int i2713 = ~iUpdateVisuals15;
                                                    int i2714 = (i2711 | (~((i2713 & i2618) | (i2713 ^ i2618)))) * (-376);
                                                    int i2715 = ~i2618;
                                                    int i2716 = ~((i2715 & iUpdateVisuals15) | (i2715 ^ iUpdateVisuals15));
                                                    int i2717 = (((i2712 ^ i2714) + ((i2712 & i2714) << 1)) - (~(((i2716 & (-28)) | (i2716 ^ (-28))) * 376))) - 1;
                                                    int i2718 = -ExpandableListView.getPackedPositionChild(0L);
                                                    int i2719 = i2718 * (-563);
                                                    int i2810 = ((i2719 | (-44070)) << 1) - (i2719 ^ (-44070));
                                                    int i2811 = ((~i2718) | (~((i2118 & 77) | (77 ^ i2118))) | (~((i ^ (-78)) | (i & (-78))))) * (-564);
                                                    int i2812 = ((i2810 | i2811) << 1) - (i2811 ^ i2810);
                                                    int i2813 = ~i2718;
                                                    int i2814 = (i2813 ^ (-78)) | (i2813 & (-78));
                                                    int i2815 = -(-((~((i2814 & i) | (i2814 ^ i))) * 1128));
                                                    int i2816 = ~((i2813 & i2210) | (i2813 ^ i2210));
                                                    int i2817 = ~((i2718 & (-78)) | (i2718 ^ (-78)));
                                                    short s9 = (short) ((((i2812 & i2815) + (i2812 | i2815)) - (~(((i2816 & i2817) | (i2816 ^ i2817)) * 564))) - 1);
                                                    int i2818 = -(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1));
                                                    int iUpdateVisuals16 = Iterables.AnonymousClass9.updateVisuals();
                                                    int i2819 = (i2818 * (-665)) - 1748156456;
                                                    int i2910 = ~i2818;
                                                    int i2911 = -(-(i2910 * (-333)));
                                                    int i2912 = ((i2819 | i2911) << 1) - (i2819 ^ i2911);
                                                    int i2913 = ~i2818;
                                                    int i2914 = ~iUpdateVisuals16;
                                                    int i2915 = ~(i2913 | i2914);
                                                    int i2916 = ~((iUpdateVisuals16 ^ 1139233332) | (iUpdateVisuals16 & 1139233332));
                                                    int i2917 = (i2912 - (~(((i2915 & i2916) | (i2915 ^ i2916)) * 333))) - 1;
                                                    int i2918 = ~((i2910 ^ iUpdateVisuals16) | (iUpdateVisuals16 & i2910));
                                                    int i2919 = ~(i2914 | 1139233332);
                                                    int i3010 = -(-(((i2918 & i2919) | (i2918 ^ i2919)) * 333));
                                                    int i3011 = (i2917 ^ i3010) + ((i3010 & i2917) << 1);
                                                    objArr2 = new Object[1];
                                                    b(i2514, fadingEdgeLength3, i2717, s9, i3011, objArr2);
                                                    if (objInvoke.equals((String) objArr2[0])) {
                                                        Object[] objArr118 = {new int[]{i}, new int[]{(~(i & 10)) & (i | 10)}, new int[1], null};
                                                        int iUptimeMillis4 = (int) SystemClock.uptimeMillis();
                                                        int i18115 = (-687433986) + ((~(iUptimeMillis4 | 863253321)) * JfifUtil.MARKER_SOI);
                                                        int i18116 = ~iUptimeMillis4;
                                                        int i18117 = i18115 + (((-75516053) | i18116) * (-216)) + (((~(i18116 | 863253321)) | 115370453) * JfifUtil.MARKER_SOI) + 16;
                                                        int i18118 = ((i18117 * 51) - (~(-(-(i3 * (-49)))))) - 1;
                                                        int i18119 = ((i18117 ^ i) | (i18117 & i)) * (-50);
                                                        int i191110 = (i18118 ^ i18119) + ((i18118 & i18119) << 1);
                                                        int i191111 = ~i18117;
                                                        int i191112 = ~i3;
                                                        int i191113 = (i191111 & i191112) | (i191111 ^ i191112);
                                                        int i191114 = ~((i191113 & i) | (i191113 ^ i));
                                                        int i191115 = ~i3;
                                                        int i191116 = ~i;
                                                        int i191117 = (i191116 & i191115) | (i191115 ^ i191116);
                                                        int i191118 = ~((i191117 & i18117) | (i191117 ^ i18117));
                                                        int i191119 = ((i191114 & i191118) | (i191114 ^ i191118)) * 50;
                                                        int i201110 = (i191110 & i191119) + (i191119 | i191110);
                                                        int i201111 = ~i;
                                                        int i201112 = ~((i191112 ^ i201111) | (i191112 & i201111));
                                                        int i201113 = ~(i191115 | i18117);
                                                        int i201114 = (i201112 & i201113) | (i201112 ^ i201113);
                                                        int i201115 = ~(i201111 | i18117);
                                                        int i201116 = -(-(((i201115 & i201114) | (i201114 ^ i201115)) * 50));
                                                        int i201117 = (i201110 & i201116) + (i201116 | i201110);
                                                        int i201118 = i201117 << 13;
                                                        int i201119 = (i201118 | i201117) & (~(i201117 & i201118));
                                                        int i21110 = i201119 >>> 17;
                                                        int i21111 = (i201119 | i21110) & (~(i201119 & i21110));
                                                        ((int[]) objArr118[2])[0] = i21111 ^ (i21111 << 5);
                                                        objArr = objArr118;
                                                    }
                                                } catch (Throwable th2) {
                                                    Throwable cause2 = th2.getCause();
                                                    if (cause2 != null) {
                                                        throw cause2;
                                                    }
                                                    throw th2;
                                                }
                                            }
                                        } catch (Exception unused) {
                                        }
                                    }
                                    int i3012 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                    int i3013 = ((i3012 | 87) << 1) - (i3012 ^ 87);
                                    artificialFrame = i3013 % 128;
                                    int i3014 = i3013 % 2;
                                    int i3015 = (i3012 ^ 9) + ((i3012 & 9) << 1);
                                    artificialFrame = i3015 % 128;
                                    int i3016 = i3015 % 2;
                                    objArr = new Object[]{new int[]{i}, new int[]{i}, new int[1], null};
                                    int startElapsedRealtime2 = (int) Process.getStartElapsedRealtime();
                                    i11 = (((~(startElapsedRealtime2 | 688078839)) * TypedValues.CycleType.TYPE_EASING) - 573195262) + (((~((~startElapsedRealtime2) | 688078839)) | 16850215) * TypedValues.CycleType.TYPE_EASING);
                                    i12 = artificialFrame + 121;
                                    int i3017 = i12 % 128;
                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i3017;
                                    if (i12 % 2 != 0) {
                                        i13 = ((-563) >> i11) / (565 << i3);
                                    } else {
                                        int i3018 = i11 * (-563);
                                        int i3019 = i3 * 565;
                                        i13 = ((i3018 & i3019) << 1) + (i3018 ^ i3019);
                                    }
                                    int i3110 = ~i11;
                                    int i3111 = ~i3;
                                    int i3112 = ~i;
                                    int i3113 = ~((i3111 & i3112) | (i3111 ^ i3112));
                                    int i3114 = (-564) * ((i3110 & i3113) | (i3110 ^ i3113) | (~((i3 ^ i) | (i3 & i))));
                                    int i3115 = ((i13 | i3114) << 1) - (i13 ^ i3114);
                                    int i3116 = ~i11;
                                    int i3117 = (~((i3116 ^ i3) | (i3116 & i3) | i)) * 1128;
                                    int i3118 = (i3115 & i3117) + (i3115 | i3117);
                                    int i3119 = ~((~i) | i3116);
                                    int i3210 = ~((i3 & i11) | (i11 ^ i3));
                                    int i3211 = ((i3119 & i3210) | (i3119 ^ i3210)) * 564;
                                    int i3212 = ((i3118 | i3211) << 1) - (i3211 ^ i3118);
                                    int i3213 = i3212 << 13;
                                    int i3214 = (i3213 | i3212) & (~(i3212 & i3213));
                                    int i3215 = ((i3017 | 25) << 1) - (i3017 ^ 25);
                                    int i3216 = i3215 % 128;
                                    artificialFrame = i3216;
                                    int i3217 = i3215 % 2;
                                    int i3218 = i3214 ^ (i3214 >>> 17);
                                    int i3219 = i3218 << 5;
                                    int i3310 = ((~i3218) & i3219) | ((~i3219) & i3218);
                                    i14 = 2;
                                    ((int[]) objArr[2])[0] = i3310;
                                    int i3311 = i3216 + 17;
                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i3311 % 128;
                                    int i3312 = i3311 % 2;
                                }
                            } else if (Build.VERSION.SDK_INT == 30) {
                                int i3313 = getARTIFICIAL_FRAME_PACKAGE_NAME + 61;
                                artificialFrame = i3313 % 128;
                                int i3314 = i3313 % 2;
                                objArr = new Object[]{new int[]{i}, new int[]{i}, new int[1], null};
                                int i3315 = (-78226562) + (((~(769065825 | i)) | 209557949) * 672);
                                int i3316 = ~i;
                                int i3317 = i3315 + (((~(209557949 | i)) | (~((-769065826) | i3316))) * (-672)) + (((~((-209557950) | i3316)) | 2660508) * 672);
                                int i3318 = ~(((-1) ^ i3316) | i3316);
                                int i3319 = ~i3317;
                                int i3410 = (i3319 & i) | (i3319 ^ i);
                                int i3411 = (i3317 * (-574)) + ((i3318 | (~i3410)) * 1150);
                                int i3412 = ~i3410;
                                int i3413 = ~((i3317 & i3316) | (i3316 ^ i3317));
                                int i3414 = ((i3413 & i3412) | (i3412 ^ i3413)) * (-575);
                                int i3415 = (i3411 & i3414) + (i3411 | i3414) + (((~(i | ((-1) ^ i))) | (~i3316)) * 575);
                                int iUpdateVisuals17 = Iterables.AnonymousClass9.updateVisuals();
                                int i3416 = ((i3415 * 659) - (~(-(-(i3 * (-657)))))) - 1;
                                int i3417 = ~i3415;
                                int i3418 = ~((i3417 & i3) | (i3417 ^ i3));
                                int i3419 = ~i3;
                                int i3510 = (i3419 & i3415) | (i3419 ^ i3415);
                                int i3511 = ~i3510;
                                int i3512 = (i3418 & i3511) | (i3418 ^ i3511);
                                int i3513 = ~((iUpdateVisuals17 & i3415) | (i3415 ^ iUpdateVisuals17));
                                int i3514 = ((i3512 & i3513) | (i3512 ^ i3513)) * (-658);
                                int i3515 = (((i3416 ^ i3514) + ((i3416 & i3514) << 1)) - (~((~i3510) * 658))) - 1;
                                int i3516 = (i3513 | (~((~i3) | i3415))) * 658;
                                int i3517 = ((i3515 | i3516) << 1) - (i3516 ^ i3515);
                                int i3518 = i3517 << 13;
                                int i3519 = (i3518 & (~i3517)) | ((~i3518) & i3517);
                                int i362 = i3519 >>> 17;
                                int i363 = ((~i3519) & i362) | ((~i362) & i3519);
                                ((int[]) objArr[2])[0] = i363 ^ (i363 << 5);
                            } else {
                                if ((i2 & 32) == 0) {
                                    if (Build.VERSION.SDK_INT > 33) {
                                        int iMyTid3 = Process.myTid() >> 22;
                                        int iUpdateVisuals18 = Iterables.AnonymousClass9.updateVisuals();
                                        int i1516 = ~((~iMyTid3) | (-988677207));
                                        int i1517 = (i1516 & iUpdateVisuals18) | (iUpdateVisuals18 ^ i1516);
                                        int i1518 = ~((iMyTid3 ^ 988677206) | (iMyTid3 & 988677206));
                                        int i1519 = ((iMyTid3 * (-375)) - 1386764794) + (((i1517 & i1518) | (i1517 ^ i1518)) * 376);
                                        int i15110 = ~((~iUpdateVisuals18) | iMyTid3);
                                        int i15111 = (i1519 - (~(-(-(((i15110 & i1518) | (i15110 ^ i1518)) * (-376)))))) - 1;
                                        int i16110 = ~iMyTid3;
                                        int i16111 = ~((i16110 & iUpdateVisuals18) | (i16110 ^ iUpdateVisuals18));
                                        int i16112 = i15111 + (((i16111 & 988677206) | (i16111 ^ 988677206)) * 376);
                                        byte b9 = (byte) (0 - (~(-(-TextUtils.lastIndexOf("", '0', 0)))));
                                        int i16113 = -View.resolveSizeAndState(0, 0, 0);
                                        int iUpdateVisuals19 = Iterables.AnonymousClass9.updateVisuals();
                                        int i16114 = (i16113 * JfifUtil.MARKER_EOI) + 6020 + ((~((i16113 ^ iUpdateVisuals19) | (i16113 & iUpdateVisuals19))) * JfifUtil.MARKER_SOI);
                                        int i16115 = (i16113 ^ 27) | (i16113 & 27);
                                        int i16116 = ~iUpdateVisuals19;
                                        int i16117 = ((i16115 & i16116) | (i16115 ^ i16116)) * (-216);
                                        int i16118 = (((i16114 & i16117) + (i16114 | i16117)) - (~(((~(i16113 | (~iUpdateVisuals19))) | (-28)) * JfifUtil.MARKER_SOI))) - 1;
                                        int i16119 = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                                        int i17110 = (i16119 * (-559)) - 29172;
                                        int i17111 = ~i;
                                        int i17112 = -(-((~((i17111 ^ i16119) | (i17111 & i16119))) * (-560)));
                                        int i17113 = ((i17110 | i17112) << 1) - (i17110 ^ i17112);
                                        int i17114 = (51 & i16119) | (51 ^ i16119);
                                        int i17115 = -(-((~((i17114 & i) | (i17114 ^ i))) * (-560)));
                                        int i17116 = ((i17113 | i17115) << 1) - (i17115 ^ i17113);
                                        int i17117 = ~((~i16119) | (-52));
                                        int i17118 = ~(i17111 | (-52));
                                        short s10 = (short) (i17116 + (((i17117 & i17118) | (i17117 ^ i17118)) * 560));
                                        int iIndexOf5 = TextUtils.indexOf("", "", 0);
                                        int i17119 = (iIndexOf5 ^ 1139233292) + ((iIndexOf5 & 1139233292) << 1);
                                        Object[] objArr119 = new Object[1];
                                        b(i16112, b9, i16118, s10, i17119, objArr119);
                                        Object[] objArr1110 = {(String) objArr119[0]};
                                        objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(267846469);
                                        if (objAccessartificialFrame2 == null) {
                                            int i18120 = (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 16;
                                            char keyRepeatTimeout3 = (char) (24343 - (ViewConfiguration.getKeyRepeatTimeout() >> 16));
                                            int i18121 = 2014 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                                            byte[] bArr7 = $$a;
                                            Object[] objArr1111 = new Object[1];
                                            a(bArr7[62], (byte) (-bArr7[44]), (byte) (-bArr7[11]), objArr1111);
                                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(i18120, keyRepeatTimeout3, i18121, -1869462195, false, (String) objArr1111[0], new Class[]{String.class});
                                        }
                                        long jLongValue3 = ((Long) ((Method) objAccessartificialFrame2).invoke(null, objArr1110)).longValue();
                                        long j17 = -906717170;
                                        long j18 = 829;
                                        long j19 = (j18 * j17) + (j18 * jLongValue3);
                                        long j110 = -828;
                                        long j111 = -1;
                                        long jUptimeMillis3 = ((long) ((int) SystemClock.uptimeMillis())) ^ j111;
                                        long j112 = j19 + (((((j17 ^ j111) | (jLongValue3 ^ j111)) ^ j111) | (((jUptimeMillis3 | j17) | jLongValue3) ^ j111)) * j110);
                                        long j113 = jLongValue3 | j17;
                                        long j114 = j112 + (j110 * (j113 | jUptimeMillis3)) + (((long) 828) * (j113 ^ j111)) + ((long) (-404914806));
                                        int elapsedCpuTime3 = (int) Process.getElapsedCpuTime();
                                        int i18122 = ~elapsedCpuTime3;
                                        i9 = ((int) (j114 >> 32)) & (((((~(2058350555 | i18122)) | (~((-42093337) | elapsedCpuTime3))) * 988) - 644494970) + (((~(elapsedCpuTime3 | 579030808)) | 1479319747 | (~(i18122 | (-42093337)))) * 988));
                                        i10 = (int) j114;
                                        iNextInt = new Random().nextInt();
                                        if ((i9 | (i10 & (902178707 + (((~((-341210419) | iNextInt)) | 1096015991) * (-465)) + (((-341210419) | (~(1096015991 | iNextInt))) * 930) + ((iNextInt | (-335811841)) * 465)))) == 1) {
                                            int i18123 = getARTIFICIAL_FRAME_PACKAGE_NAME + 101;
                                            artificialFrame = i18123 % 128;
                                            int i18124 = i18123 % 2;
                                            Object[] objArr1112 = {new int[]{i}, new int[]{(~(i & 10)) & (i | 10)}, new int[1], null};
                                            int iUptimeMillis5 = (int) SystemClock.uptimeMillis();
                                            int i181110 = (-687433986) + ((~(iUptimeMillis5 | 863253321)) * JfifUtil.MARKER_SOI);
                                            int i181111 = ~iUptimeMillis5;
                                            int i181112 = i181110 + (((-75516053) | i181111) * (-216)) + (((~(i181111 | 863253321)) | 115370453) * JfifUtil.MARKER_SOI) + 16;
                                            int i181113 = ((i181112 * 51) - (~(-(-(i3 * (-49)))))) - 1;
                                            int i181114 = ((i181112 ^ i) | (i181112 & i)) * (-50);
                                            int i1911110 = (i181113 ^ i181114) + ((i181113 & i181114) << 1);
                                            int i1911111 = ~i181112;
                                            int i1911112 = ~i3;
                                            int i1911113 = (i1911111 & i1911112) | (i1911111 ^ i1911112);
                                            int i1911114 = ~((i1911113 & i) | (i1911113 ^ i));
                                            int i1911115 = ~i3;
                                            int i1911116 = ~i;
                                            int i1911117 = (i1911116 & i1911115) | (i1911115 ^ i1911116);
                                            int i1911118 = ~((i1911117 & i181112) | (i1911117 ^ i181112));
                                            int i1911119 = ((i1911114 & i1911118) | (i1911114 ^ i1911118)) * 50;
                                            int i2011110 = (i1911110 & i1911119) + (i1911119 | i1911110);
                                            int i2011111 = ~i;
                                            int i2011112 = ~((i1911112 ^ i2011111) | (i1911112 & i2011111));
                                            int i2011113 = ~(i1911115 | i181112);
                                            int i2011114 = (i2011112 & i2011113) | (i2011112 ^ i2011113);
                                            int i2011115 = ~(i2011111 | i181112);
                                            int i2011116 = -(-(((i2011115 & i2011114) | (i2011114 ^ i2011115)) * 50));
                                            int i2011117 = (i2011110 & i2011116) + (i2011116 | i2011110);
                                            int i2011118 = i2011117 << 13;
                                            int i2011119 = (i2011118 | i2011117) & (~(i2011117 & i2011118));
                                            int i21112 = i2011119 >>> 17;
                                            int i21113 = (i2011119 | i21112) & (~(i2011119 & i21112));
                                            ((int[]) objArr1112[2])[0] = i21113 ^ (i21113 << 5);
                                            objArr = objArr1112;
                                        }
                                    } else {
                                        int i21114 = -(-View.combineMeasuredStates(0, 0));
                                        int i21115 = (i21114 ^ 988677273) + ((i21114 & 988677273) << 1);
                                        byte bArgb3 = (byte) Color.argb(0, 0, 0, 0);
                                        int i21116 = -TextUtils.indexOf((CharSequence) "", '0', 0, 0);
                                        int i21117 = (i21116 * (-958)) + 27782;
                                        int i21118 = ~i;
                                        int i21119 = ~((28 & i21118) | (28 ^ i21118));
                                        int i2122 = ~i21116;
                                        int i2123 = i21119 | (~((i2122 ^ i) | (i2122 & i)));
                                        int i22110 = ~i;
                                        int i22111 = (i2123 | (~((i22110 ^ i21116) | (i22110 & i21116)))) * 959;
                                        int i22112 = (((i21117 | i22111) << 1) - (i21117 ^ i22111)) + ((~((i21116 ^ (-29)) | (i21116 & (-29)))) * (-959));
                                        int i22113 = ~(i2122 | i21118);
                                        int i22114 = ~((28 & i) | (28 ^ i));
                                        int i22115 = (i22113 & i22114) | (i22113 ^ i22114);
                                        int i22116 = ~((i21116 & i) | (i21116 ^ i));
                                        int i22117 = ((i22116 & i22115) | (i22115 ^ i22116)) * 959;
                                        int i22118 = (i22112 & i22117) + (i22117 | i22112);
                                        int i22119 = -Color.rgb(0, 0, 0);
                                        int iUpdateVisuals110 = Iterables.AnonymousClass9.updateVisuals();
                                        int i23110 = i22119 * (-958);
                                        int i23111 = (i23110 ^ (-1107190876)) + ((i23110 & (-1107190876)) << 1);
                                        int i23112 = ~iUpdateVisuals110;
                                        int i23113 = ~((16777325 ^ i23112) | (16777325 & i23112));
                                        int i23114 = ~i22119;
                                        int i23115 = ~((i23114 ^ iUpdateVisuals110) | (i23114 & iUpdateVisuals110));
                                        int i23116 = (i23113 ^ i23115) | (i23115 & i23113);
                                        int i23117 = ~((i23112 & i22119) | (i23112 ^ i22119));
                                        int i23118 = (i23111 - (~(-(-(((i23117 & i23116) | (i23116 ^ i23117)) * 959))))) - 1;
                                        int i23119 = -(-((~(((-16777326) & i22119) | (i22119 ^ (-16777326)))) * (-959)));
                                        int i24110 = (i23118 & i23119) + (i23119 | i23118);
                                        int i24111 = ~((~iUpdateVisuals110) | i23114);
                                        int i24112 = ~((16777325 & iUpdateVisuals110) | (16777325 ^ iUpdateVisuals110));
                                        int i24113 = (i24111 & i24112) | (i24111 ^ i24112);
                                        int i24114 = ~((i22119 & iUpdateVisuals110) | (i22119 ^ iUpdateVisuals110));
                                        short s11 = (short) ((i24110 - (~(-(-(((i24114 & i24113) | (i24113 ^ i24114)) * 959))))) - 1);
                                        int iIndexOf6 = TextUtils.indexOf("", "", 0, 0);
                                        int i24115 = iIndexOf6 * 450;
                                        int i24116 = (i24115 ^ 724580864) + ((i24115 & 724580864) << 1);
                                        int i24117 = ~iIndexOf6;
                                        int i24118 = ((-1139233321) & iIndexOf6) | ((-1139233321) ^ iIndexOf6);
                                        int i24119 = ((i24116 - (~(((~(i24117 | 1139233320)) | (~((i24118 & i) | (i24118 ^ i)))) * 449))) - 1) + ((~((~iIndexOf6) | 1139233320)) * (-1347));
                                        int i25110 = ~((i24117 & 1139233320) | (i24117 ^ 1139233320));
                                        int i25111 = ~(iIndexOf6 | ((-1139233321) & i21118) | ((-1139233321) ^ i21118));
                                        int i25112 = i24119 + (((i25111 & i25110) | (i25110 ^ i25111)) * 449);
                                        Object[] objArr1113 = new Object[1];
                                        b(i21115, bArgb3, i22118, s11, i25112, objArr1113);
                                        Object[] objArr1114 = {(String) objArr1113[0]};
                                        objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1483923676);
                                        if (objAccessartificialFrame == null) {
                                            int defaultSize3 = View.getDefaultSize(0, 0) + 23;
                                            char cResolveSizeAndState3 = (char) View.resolveSizeAndState(0, 0, 0);
                                            int iResolveSizeAndState3 = View.resolveSizeAndState(0, 0, 0) + 2441;
                                            byte b10 = (byte) ($$b & 7);
                                            Object[] objArr1115 = new Object[1];
                                            a(b10, (byte) (b10 | Ascii.DC4), (byte) (-$$a[38]), objArr1115);
                                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(defaultSize3, cResolveSizeAndState3, iResolveSizeAndState3, 954751276, false, (String) objArr1115[0], new Class[]{String.class});
                                        }
                                        objInvoke = ((Method) objAccessartificialFrame).invoke(null, objArr1114);
                                        int i25113 = -(SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                                        int i25114 = ((i25113 | 988677209) << 1) - (i25113 ^ 988677209);
                                        byte fadingEdgeLength4 = (byte) (ViewConfiguration.getFadingEdgeLength() >> 16);
                                        int threadPriority3 = Process.getThreadPriority(0);
                                        int iUpdateVisuals111 = Iterables.AnonymousClass9.updateVisuals();
                                        int i25115 = threadPriority3 * 370;
                                        int i25116 = (7400 & i25115) + (i25115 | 7400);
                                        int i25117 = (threadPriority3 ^ 20) | (threadPriority3 & 20);
                                        int i25118 = ~iUpdateVisuals111;
                                        int i25119 = ((i25116 - (~(-(-(((i25117 & i25118) | (i25117 ^ i25118)) * (-369)))))) - 1) + (((~(((-21) & i25118) | ((-21) ^ i25118))) | threadPriority3) * (-369));
                                        int i26110 = ~threadPriority3;
                                        int i26111 = ~((i26110 & 20) | (i26110 ^ 20));
                                        int i26112 = ~((iUpdateVisuals111 ^ 20) | (iUpdateVisuals111 & 20));
                                        int i26113 = (i26111 & i26112) | (i26111 ^ i26112);
                                        int i26114 = ~iUpdateVisuals111;
                                        int i26115 = (i26114 & (-21)) | ((-21) ^ i26114);
                                        int i26116 = ~((i26115 & threadPriority3) | (i26115 ^ threadPriority3));
                                        int i26117 = ((i26116 & i26113) | (i26113 ^ i26116)) * 369;
                                        int i26118 = -(((i25119 ^ i26117) + ((i26117 & i25119) << 1)) >> 6);
                                        int iUpdateVisuals112 = Iterables.AnonymousClass9.updateVisuals();
                                        int i26119 = ~i26118;
                                        int i27110 = ~((i26119 & 27) | (i26119 ^ 27));
                                        int i27111 = ~((i26118 ^ (-28)) | (i26118 & (-28)));
                                        int i27112 = (((i26118 * (-375)) + 10500) - (~((((i27110 & iUpdateVisuals112) | (iUpdateVisuals112 ^ i27110)) | i27111) * 376))) - 1;
                                        int i27113 = ~iUpdateVisuals112;
                                        int i27114 = (i27111 | (~((i27113 & i26118) | (i27113 ^ i26118)))) * (-376);
                                        int i27115 = ~i26118;
                                        int i27116 = ~((i27115 & iUpdateVisuals112) | (i27115 ^ iUpdateVisuals112));
                                        int i27117 = (((i27112 ^ i27114) + ((i27112 & i27114) << 1)) - (~(((i27116 & (-28)) | (i27116 ^ (-28))) * 376))) - 1;
                                        int i27118 = -ExpandableListView.getPackedPositionChild(0L);
                                        int i27119 = i27118 * (-563);
                                        int i28110 = ((i27119 | (-44070)) << 1) - (i27119 ^ (-44070));
                                        int i28111 = ((~i27118) | (~((i21118 & 77) | (77 ^ i21118))) | (~((i ^ (-78)) | (i & (-78))))) * (-564);
                                        int i28112 = ((i28110 | i28111) << 1) - (i28111 ^ i28110);
                                        int i28113 = ~i27118;
                                        int i28114 = (i28113 ^ (-78)) | (i28113 & (-78));
                                        int i28115 = -(-((~((i28114 & i) | (i28114 ^ i))) * 1128));
                                        int i28116 = ~((i28113 & i22110) | (i28113 ^ i22110));
                                        int i28117 = ~((i27118 & (-78)) | (i27118 ^ (-78)));
                                        short s12 = (short) ((((i28112 & i28115) + (i28112 | i28115)) - (~(((i28116 & i28117) | (i28116 ^ i28117)) * 564))) - 1);
                                        int i28118 = -(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1));
                                        int iUpdateVisuals113 = Iterables.AnonymousClass9.updateVisuals();
                                        int i28119 = (i28118 * (-665)) - 1748156456;
                                        int i29110 = ~i28118;
                                        int i29111 = -(-(i29110 * (-333)));
                                        int i29112 = ((i28119 | i29111) << 1) - (i28119 ^ i29111);
                                        int i29113 = ~i28118;
                                        int i29114 = ~iUpdateVisuals113;
                                        int i29115 = ~(i29113 | i29114);
                                        int i29116 = ~((iUpdateVisuals113 ^ 1139233332) | (iUpdateVisuals113 & 1139233332));
                                        int i29117 = (i29112 - (~(((i29115 & i29116) | (i29115 ^ i29116)) * 333))) - 1;
                                        int i29118 = ~((i29110 ^ iUpdateVisuals113) | (iUpdateVisuals113 & i29110));
                                        int i29119 = ~(i29114 | 1139233332);
                                        int i30110 = -(-(((i29118 & i29119) | (i29118 ^ i29119)) * 333));
                                        int i30111 = (i29117 ^ i30110) + ((i30110 & i29117) << 1);
                                        objArr2 = new Object[1];
                                        b(i25114, fadingEdgeLength4, i27117, s12, i30111, objArr2);
                                        if (objInvoke.equals((String) objArr2[0])) {
                                            Object[] objArr1116 = {new int[]{i}, new int[]{(~(i & 10)) & (i | 10)}, new int[1], null};
                                            int iUptimeMillis6 = (int) SystemClock.uptimeMillis();
                                            int i181115 = (-687433986) + ((~(iUptimeMillis6 | 863253321)) * JfifUtil.MARKER_SOI);
                                            int i181116 = ~iUptimeMillis6;
                                            int i181117 = i181115 + (((-75516053) | i181116) * (-216)) + (((~(i181116 | 863253321)) | 115370453) * JfifUtil.MARKER_SOI) + 16;
                                            int i181118 = ((i181117 * 51) - (~(-(-(i3 * (-49)))))) - 1;
                                            int i181119 = ((i181117 ^ i) | (i181117 & i)) * (-50);
                                            int i19111110 = (i181118 ^ i181119) + ((i181118 & i181119) << 1);
                                            int i19111111 = ~i181117;
                                            int i19111112 = ~i3;
                                            int i19111113 = (i19111111 & i19111112) | (i19111111 ^ i19111112);
                                            int i19111114 = ~((i19111113 & i) | (i19111113 ^ i));
                                            int i19111115 = ~i3;
                                            int i19111116 = ~i;
                                            int i19111117 = (i19111116 & i19111115) | (i19111115 ^ i19111116);
                                            int i19111118 = ~((i19111117 & i181117) | (i19111117 ^ i181117));
                                            int i19111119 = ((i19111114 & i19111118) | (i19111114 ^ i19111118)) * 50;
                                            int i20111110 = (i19111110 & i19111119) + (i19111119 | i19111110);
                                            int i20111111 = ~i;
                                            int i20111112 = ~((i19111112 ^ i20111111) | (i19111112 & i20111111));
                                            int i20111113 = ~(i19111115 | i181117);
                                            int i20111114 = (i20111112 & i20111113) | (i20111112 ^ i20111113);
                                            int i20111115 = ~(i20111111 | i181117);
                                            int i20111116 = -(-(((i20111115 & i20111114) | (i20111114 ^ i20111115)) * 50));
                                            int i20111117 = (i20111110 & i20111116) + (i20111116 | i20111110);
                                            int i20111118 = i20111117 << 13;
                                            int i20111119 = (i20111118 | i20111117) & (~(i20111117 & i20111118));
                                            int i211110 = i20111119 >>> 17;
                                            int i211111 = (i20111119 | i211110) & (~(i20111119 & i211110));
                                            ((int[]) objArr1116[2])[0] = i211111 ^ (i211111 << 5);
                                            objArr = objArr1116;
                                        }
                                    }
                                }
                                int i30112 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                int i30113 = ((i30112 | 87) << 1) - (i30112 ^ 87);
                                artificialFrame = i30113 % 128;
                                int i30114 = i30113 % 2;
                                int i30115 = (i30112 ^ 9) + ((i30112 & 9) << 1);
                                artificialFrame = i30115 % 128;
                                int i30116 = i30115 % 2;
                                objArr = new Object[]{new int[]{i}, new int[]{i}, new int[1], null};
                                int startElapsedRealtime3 = (int) Process.getStartElapsedRealtime();
                                i11 = (((~(startElapsedRealtime3 | 688078839)) * TypedValues.CycleType.TYPE_EASING) - 573195262) + (((~((~startElapsedRealtime3) | 688078839)) | 16850215) * TypedValues.CycleType.TYPE_EASING);
                                i12 = artificialFrame + 121;
                                int i30117 = i12 % 128;
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i30117;
                                if (i12 % 2 != 0) {
                                    i13 = ((-563) >> i11) / (565 << i3);
                                } else {
                                    int i30118 = i11 * (-563);
                                    int i30119 = i3 * 565;
                                    i13 = ((i30118 & i30119) << 1) + (i30118 ^ i30119);
                                }
                                int i31110 = ~i11;
                                int i31111 = ~i3;
                                int i31112 = ~i;
                                int i31113 = ~((i31111 & i31112) | (i31111 ^ i31112));
                                int i31114 = (-564) * ((i31110 & i31113) | (i31110 ^ i31113) | (~((i3 ^ i) | (i3 & i))));
                                int i31115 = ((i13 | i31114) << 1) - (i13 ^ i31114);
                                int i31116 = ~i11;
                                int i31117 = (~((i31116 ^ i3) | (i31116 & i3) | i)) * 1128;
                                int i31118 = (i31115 & i31117) + (i31115 | i31117);
                                int i31119 = ~((~i) | i31116);
                                int i32110 = ~((i3 & i11) | (i11 ^ i3));
                                int i32111 = ((i31119 & i32110) | (i31119 ^ i32110)) * 564;
                                int i32112 = ((i31118 | i32111) << 1) - (i32111 ^ i31118);
                                int i32113 = i32112 << 13;
                                int i32114 = (i32113 | i32112) & (~(i32112 & i32113));
                                int i32115 = ((i30117 | 25) << 1) - (i30117 ^ 25);
                                int i32116 = i32115 % 128;
                                artificialFrame = i32116;
                                int i32117 = i32115 % 2;
                                int i32118 = i32114 ^ (i32114 >>> 17);
                                int i32119 = i32118 << 5;
                                int i33110 = ((~i32118) & i32119) | ((~i32119) & i32118);
                                i14 = 2;
                                ((int[]) objArr[2])[0] = i33110;
                                int i33111 = i32116 + 17;
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i33111 % 128;
                                int i33112 = i33111 % 2;
                            }
                            i14 = 2;
                        } catch (Throwable th3) {
                            Throwable cause3 = th3.getCause();
                            if (cause3 != null) {
                                throw cause3;
                            }
                            throw th3;
                        }
                    }
                } catch (Throwable th4) {
                    Throwable cause4 = th4.getCause();
                    if (cause4 != null) {
                        throw cause4;
                    }
                    throw th4;
                }
            }
            int i364 = getARTIFICIAL_FRAME_PACKAGE_NAME + 23;
            artificialFrame = i364 % 128;
            if (i364 % i14 != 0) {
                return objArr;
            }
            Object obj2 = null;
            obj2.hashCode();
            throw null;
        }
    }
}
