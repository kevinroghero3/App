package io.sentry;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PointF;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.common.base.Ascii;
import com.google.mlkit.common.MlKitException;
import com.salesforce.marketingcloud.analytics.stats.b;
import io.sentry.protocol.SdkVersion;
import io.sentry.protocol.SentryId;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import o.ArtificialStackFrames;
import o.ICustomTabsCallbackDefault;
import o.onNavigationEvent;
import org.apache.commons.lang3.CharUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.helpers.BasicMarkerFactory;

/* JADX INFO: loaded from: classes3.dex */
public final class SentryEnvelopeHeader implements JsonSerializable, JsonUnknown {
    private final SentryId eventId;
    private final SdkVersion sdkVersion;
    private Date sentAt;
    private final TraceContext traceContext;
    private Map<String, Object> unknown;

    /* JADX INFO: loaded from: classes6.dex */
    public static final class JsonKeys {
        public static final String EVENT_ID = "event_id";
        public static final String SDK = "sdk";
        public static final String SENT_AT = "sent_at";
        public static final String TRACE = "trace";
    }

    public SentryEnvelopeHeader(@Nullable SentryId sentryId, @Nullable SdkVersion sdkVersion) {
        this(sentryId, sdkVersion, null);
    }

    public SentryEnvelopeHeader(@Nullable SentryId sentryId, @Nullable SdkVersion sdkVersion, @Nullable TraceContext traceContext) {
        this.eventId = sentryId;
        this.sdkVersion = sdkVersion;
        this.traceContext = traceContext;
    }

    public SentryEnvelopeHeader(@Nullable SentryId sentryId) {
        this(sentryId, null);
    }

    public SentryEnvelopeHeader() {
        this(new SentryId());
    }

    public SentryId getEventId() {
        return this.eventId;
    }

    public SdkVersion getSdkVersion() {
        return this.sdkVersion;
    }

    public TraceContext getTraceContext() {
        return this.traceContext;
    }

    public Date getSentAt() {
        return this.sentAt;
    }

    public void setSentAt(@Nullable Date date) {
        this.sentAt = date;
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(@NotNull ObjectWriter objectWriter, @NotNull ILogger iLogger) throws IOException {
        objectWriter.beginObject();
        if (this.eventId != null) {
            objectWriter.name("event_id").value(iLogger, this.eventId);
        }
        if (this.sdkVersion != null) {
            objectWriter.name("sdk").value(iLogger, this.sdkVersion);
        }
        if (this.traceContext != null) {
            objectWriter.name("trace").value(iLogger, this.traceContext);
        }
        if (this.sentAt != null) {
            objectWriter.name(JsonKeys.SENT_AT).value(iLogger, DateUtils.getTimestamp(this.sentAt));
        }
        Map<String, Object> map = this.unknown;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.unknown.get(str);
                objectWriter.name(str);
                objectWriter.value(iLogger, obj);
            }
        }
        objectWriter.endObject();
    }

    public static final class Deserializer implements JsonDeserializer<SentryEnvelopeHeader> {
        private static final byte[] $$a = {85, -33, -39, -30};
        private static final int $$b = 85;
        private static int $10 = 0;
        private static int $11 = 1;
        private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        private static int artificialFrame = 1;
        private static long coroutineBoundary = 6519187106483581644L;
        private static int accessartificialFrame = -1151259316;
        private static char CoroutineDebuggingKt = 11596;
        private static int setDefaultImpl = -260894051;

        /* JADX WARN: Code duplicated, block: B:10:0x0025  */
        /* JADX WARN: Code duplicated, block: B:8:0x001f  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002e). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static java.lang.String $$c(int r6, short r7, short r8) {
            /*
                byte[] r0 = io.sentry.SentryEnvelopeHeader.Deserializer.$$a
                int r6 = r6 * 4
                int r1 = 1 - r6
                int r7 = r7 * 4
                int r7 = 3 - r7
                int r8 = 116 - r8
                byte[] r1 = new byte[r1]
                r2 = 0
                int r6 = 0 - r6
                if (r0 != 0) goto L17
                r3 = r8
                r4 = r2
                r8 = r7
                goto L2e
            L17:
                r3 = r2
            L18:
                byte r4 = (byte) r8
                r1[r3] = r4
                int r7 = r7 + 1
                if (r3 != r6) goto L25
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                return r6
            L25:
                int r3 = r3 + 1
                r4 = r0[r7]
                r5 = r8
                r8 = r7
                r7 = r4
                r4 = r3
                r3 = r5
            L2e:
                int r7 = r7 + r3
                r3 = r4
                r5 = r8
                r8 = r7
                r7 = r5
                goto L18
            */
            throw new UnsupportedOperationException("Method not decompiled: io.sentry.SentryEnvelopeHeader.Deserializer.$$c(int, short, short):java.lang.String");
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Code duplicated, block: B:24:0x004e  */
        @Override // io.sentry.JsonDeserializer
        public SentryEnvelopeHeader deserialize(@NotNull ObjectReader objectReader, @NotNull ILogger iLogger) throws Exception {
            byte b;
            objectReader.beginObject();
            SentryId sentryId = null;
            SdkVersion sdkVersion = null;
            TraceContext traceContext = null;
            Date dateNextDateOrNull = null;
            HashMap map = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.hashCode();
                switch (strNextName) {
                    case "sdk":
                        b = 0;
                        break;
                    case "trace":
                        b = 1;
                        break;
                    case "event_id":
                        b = 2;
                        break;
                    case "sent_at":
                        b = 3;
                        break;
                    default:
                        b = -1;
                        break;
                }
                if (b == 0) {
                    sdkVersion = (SdkVersion) objectReader.nextOrNull(iLogger, new SdkVersion.Deserializer());
                } else if (b == 1) {
                    traceContext = (TraceContext) objectReader.nextOrNull(iLogger, new TraceContext.Deserializer());
                } else if (b == 2) {
                    sentryId = (SentryId) objectReader.nextOrNull(iLogger, new SentryId.Deserializer());
                } else if (b == 3) {
                    dateNextDateOrNull = objectReader.nextDateOrNull(iLogger);
                } else {
                    if (map == null) {
                        map = new HashMap();
                    }
                    objectReader.nextUnknown(iLogger, map, strNextName);
                }
            }
            SentryEnvelopeHeader sentryEnvelopeHeader = new SentryEnvelopeHeader(sentryId, sdkVersion, traceContext);
            sentryEnvelopeHeader.setSentAt(dateNextDateOrNull);
            sentryEnvelopeHeader.setUnknown(map);
            objectReader.endObject();
            return sentryEnvelopeHeader;
        }

        private static void a(char[] cArr, int i, char[] cArr2, char c, char[] cArr3, Object[] objArr) throws Throwable {
            int i2 = 2;
            int i3 = 2 % 2;
            ICustomTabsCallbackDefault iCustomTabsCallbackDefault = new ICustomTabsCallbackDefault();
            int length = cArr2.length;
            char[] cArr4 = new char[length];
            int length2 = cArr.length;
            char[] cArr5 = new char[length2];
            System.arraycopy(cArr2, 0, cArr4, 0, length);
            System.arraycopy(cArr, 0, cArr5, 0, length2);
            cArr4[0] = (char) (cArr4[0] ^ c);
            cArr5[2] = (char) (cArr5[2] + ((char) i));
            int length3 = cArr3.length;
            char[] cArr6 = new char[length3];
            iCustomTabsCallbackDefault.a = 0;
            while (iCustomTabsCallbackDefault.a < length3) {
                int i4 = $10 + b.i;
                $11 = i4 % 128;
                int i5 = i4 % i2;
                try {
                    Object[] objArr2 = {iCustomTabsCallbackDefault};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-10548171);
                    if (objAccessartificialFrame == null) {
                        byte b = (byte) 0;
                        byte b2 = b;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(View.resolveSizeAndState(0, 0, 0) + 33, (char) (KeyEvent.getMaxKeyCode() >> 16), 1483 - View.resolveSize(0, 0), 1614432829, false, $$c(b, b2, (byte) (b2 | 17)), new Class[]{Object.class});
                    }
                    int iIntValue = ((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
                    try {
                        Object[] objArr3 = {iCustomTabsCallbackDefault};
                        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1818210492);
                        if (objAccessartificialFrame2 == null) {
                            byte b3 = (byte) 0;
                            byte b4 = b3;
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 33, (char) (49169 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))), View.resolveSizeAndState(0, 0, 0) + 899, 214239564, false, $$c(b3, b4, (byte) (b4 | Ascii.SI)), new Class[]{Object.class});
                        }
                        int iIntValue2 = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
                        try {
                            Object[] objArr4 = {iCustomTabsCallbackDefault, Integer.valueOf(cArr4[iCustomTabsCallbackDefault.a % 4] * 32718), Integer.valueOf(cArr5[iIntValue])};
                            Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(1532285801);
                            if (objAccessartificialFrame3 == null) {
                                byte b5 = (byte) 0;
                                byte b6 = b5;
                                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(23 - View.MeasureSpec.getMode(0), (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), Color.green(0) + 2441, -1003383455, false, $$c(b5, b6, (byte) (b6 | Ascii.DC2)), new Class[]{Object.class, Integer.TYPE, Integer.TYPE});
                            }
                            ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                            try {
                                Object[] objArr5 = {Integer.valueOf(cArr4[iIntValue2] * 32718), Integer.valueOf(cArr5[iIntValue])};
                                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-950633141);
                                if (objAccessartificialFrame4 == null) {
                                    byte b7 = (byte) 0;
                                    byte b8 = b7;
                                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(21 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) (View.resolveSize(0, 0) + 29754), 1748 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), 1479752515, false, $$c(b7, b8, (byte) (b8 | Ascii.DLE)), new Class[]{Integer.TYPE, Integer.TYPE});
                                }
                                cArr5[iIntValue2] = ((Character) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).charValue();
                                cArr4[iIntValue2] = iCustomTabsCallbackDefault.MediaBrowserCompatApi21ConnectionCallback;
                                cArr6[iCustomTabsCallbackDefault.a] = (char) (((((long) (cArr3[iCustomTabsCallbackDefault.a] ^ cArr4[iIntValue2])) ^ (coroutineBoundary ^ (-899883803867009716L))) ^ ((long) ((int) (((long) accessartificialFrame) ^ (-899883803867009716L))))) ^ ((long) ((char) (((long) CoroutineDebuggingKt) ^ (-899883803867009716L)))));
                                iCustomTabsCallbackDefault.a++;
                                i2 = 2;
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
                } catch (Throwable th4) {
                    Throwable cause4 = th4.getCause();
                    if (cause4 == null) {
                        throw th4;
                    }
                    throw cause4;
                }
            }
            String str = new String(cArr6);
            int i6 = $10 + 47;
            $11 = i6 % 128;
            int i7 = i6 % 2;
            objArr[0] = str;
        }

        private static void b(char[] cArr, int i, int i2, int i3, boolean z, Object[] objArr) throws Throwable {
            Object obj;
            int i4 = 2 % 2;
            onNavigationEvent onnavigationevent = new onNavigationEvent();
            char[] cArr2 = new char[i];
            onnavigationevent.d = 0;
            while (onnavigationevent.d < i) {
                onnavigationevent.c = cArr[onnavigationevent.d];
                cArr2[onnavigationevent.d] = (char) (i3 + onnavigationevent.c);
                int i5 = onnavigationevent.d;
                try {
                    Object[] objArr2 = {Integer.valueOf(cArr2[i5]), Integer.valueOf(setDefaultImpl)};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(465886069);
                    if (objAccessartificialFrame == null) {
                        byte b = (byte) 0;
                        byte b2 = b;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(KeyEvent.keyCodeFromString("") + 22, (char) ((-1) - MotionEvent.axisFromString("")), 1775 - View.MeasureSpec.getMode(0), -2069783171, false, $$c(b, b2, (byte) (b2 + 2)), new Class[]{Integer.TYPE, Integer.TYPE});
                    }
                    cArr2[i5] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                    Object[] objArr3 = {onnavigationevent, onnavigationevent};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1257606387);
                    if (objAccessartificialFrame2 == null) {
                        byte b3 = (byte) 0;
                        byte b4 = b3;
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 37, (char) (56277 - (ViewConfiguration.getMinimumFlingVelocity() >> 16)), View.MeasureSpec.getSize(0) + 1259, 711931141, false, $$c(b3, b4, b4), new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame2).invoke(null, objArr3);
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            if (i2 > 0) {
                onnavigationevent.b = i2;
                char[] cArr3 = new char[i];
                System.arraycopy(cArr2, 0, cArr3, 0, i);
                System.arraycopy(cArr3, 0, cArr2, i - onnavigationevent.b, onnavigationevent.b);
                System.arraycopy(cArr3, onnavigationevent.b, cArr2, 0, i - onnavigationevent.b);
            }
            if (z) {
                int i6 = $11 + 99;
                $10 = i6 % 128;
                int i7 = i6 % 2;
                char[] cArr4 = new char[i];
                onnavigationevent.d = 0;
                while (onnavigationevent.d < i) {
                    int i8 = $11 + 83;
                    $10 = i8 % 128;
                    if (i8 % 2 != 0) {
                        cArr4[onnavigationevent.d] = cArr2[(i - onnavigationevent.d) >>> 1];
                        Object[] objArr4 = {onnavigationevent, onnavigationevent};
                        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1257606387);
                        if (objAccessartificialFrame3 == null) {
                            byte b5 = (byte) 0;
                            byte b6 = b5;
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(Color.argb(0, 0, 0, 0) + 37, (char) (TextUtils.lastIndexOf("", '0', 0) + 56278), 1259 - (ViewConfiguration.getPressedStateDuration() >> 16), 711931141, false, $$c(b5, b6, b6), new Class[]{Object.class, Object.class});
                        }
                        ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                        obj = null;
                    } else {
                        cArr4[onnavigationevent.d] = cArr2[(i - onnavigationevent.d) - 1];
                        Object[] objArr5 = {onnavigationevent, onnavigationevent};
                        Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1257606387);
                        if (objAccessartificialFrame4 == null) {
                            byte b7 = (byte) 0;
                            byte b8 = b7;
                            objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(37 - Color.green(0), (char) ((ViewConfiguration.getLongPressTimeout() >> 16) + 56277), (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 1258, 711931141, false, $$c(b7, b8, b8), new Class[]{Object.class, Object.class});
                        }
                        obj = null;
                        ((Method) objAccessartificialFrame4).invoke(null, objArr5);
                    }
                }
                cArr2 = cArr4;
            }
            objArr[0] = new String(cArr2);
        }

        public static Object[] accessartificialFrame(Context context, int i, int i2) {
            char c;
            int i3;
            int i4;
            Object obj;
            Object[] objArr;
            int iAxisFromString;
            char[] cArr;
            int i5;
            Constructor<?> declaredConstructor;
            char mode;
            int i6;
            char[] cArr2;
            char[] cArr3;
            int i7;
            int i8;
            int i9;
            int i10;
            int i11 = 2 % 2;
            int i12 = 1;
            if (context == null) {
                Object[] objArr2 = {new int[]{i}, new int[]{i}, new int[1], null};
                int i13 = ~((~Process.myPid()) | 908083202);
                int i14 = ((838860802 | i13) * (-374)) + 1060577290 + ((i13 | 69222400) * 374);
                int iMediaBrowserCompatMediaBrowserImplBaseMediaServiceConnection1 = BasicMarkerFactory.MediaBrowserCompatMediaBrowserImplBaseMediaServiceConnection1();
                int i15 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                int i16 = ((i15 | 25) << 1) - (i15 ^ 25);
                artificialFrame = i16 % 128;
                int i17 = i16 % 2;
                int i18 = i14 * (-518);
                int i19 = ((((((i18 << 1) - i18) + (i14 * 519)) - (~((~((i14 ^ iMediaBrowserCompatMediaBrowserImplBaseMediaServiceConnection1) | (i14 & iMediaBrowserCompatMediaBrowserImplBaseMediaServiceConnection1))) * (-519)))) - 1) - (~(-(-((~((iMediaBrowserCompatMediaBrowserImplBaseMediaServiceConnection1 & i14) | (i14 ^ iMediaBrowserCompatMediaBrowserImplBaseMediaServiceConnection1))) * 519))))) - 1;
                int i20 = ((i2 | i19) << 1) - (i2 ^ i19);
                int i21 = i20 ^ (i20 << 13);
                int i22 = i21 >>> 17;
                int i23 = (i21 | i22) & (~(i21 & i22));
                int i24 = i23 << 5;
                ((int[]) objArr2[2])[0] = ((~i23) & i24) | ((~i24) & i23);
                return objArr2;
            }
            try {
                Object[] objArr3 = new Object[1];
                a(new char[]{40832, 41251, 13904, 43514}, KeyEvent.getMaxKeyCode() >> 16, new char[]{20994, 46519, 46440, 17223}, (char) View.resolveSizeAndState(0, 0, 0), new char[]{50487, 57713, 35524, 55050, 32344, 35712, 14915, 63004, 41629, 63753, 37803, 61734, 54510, 42114, 55776, 8053, 43275, 4783, 57107, 8031, 62725, 38250, 18543, 28608, 14736, 26745, 6179, 55576, 35208, 33972, 19940, 26673, 18564, 62542, 48849, 24137, 46677, 24796}, objArr3);
                Object[] objArr4 = (Object[]) Array.newInstance(Class.forName((String) objArr3[0]), 2);
                int i25 = -Color.rgb(0, 0, 0);
                int iMediaBrowserCompatMediaBrowserImplBaseMediaServiceConnection2 = BasicMarkerFactory.MediaBrowserCompatMediaBrowserImplBaseMediaServiceConnection1();
                int i26 = (i25 * 483) - (-244461562);
                int i27 = ~i25;
                int i28 = ~((i27 ^ 16737626) | (i27 & 16737626));
                int i29 = ~iMediaBrowserCompatMediaBrowserImplBaseMediaServiceConnection2;
                int i30 = ~(i27 | i29);
                int i31 = ((i28 ^ i30) | (i30 & i28)) * (-241);
                int i32 = ((i26 | i31) << 1) - (i31 ^ i26);
                int i33 = -(-((i25 | (-16737627)) * (-482)));
                int i34 = (i32 & i33) + (i32 | i33);
                int i35 = ~((16737626 ^ i25) | (16737626 & i25));
                int i36 = ~i25;
                int i37 = (i36 & i29) | (i36 ^ i29);
                Object[] objArr5 = new Object[1];
                a(new char[]{40832, 41251, 13904, 43514}, (-1115717649) - (~TextUtils.lastIndexOf("", '0', 0)), new char[]{61217, 32639, 42429, 45210}, (char) (i34 + (((~(((-16737627) & i37) | (i37 ^ (-16737627)))) | i35) * 241)), new char[]{25313, 44746, 12738, 53922, 18304, 57172, 15927, 57921, 15204, 15282, 19629, 24731, 59419, 40216, 61198, 43597, 29578, 31878, 16047, 4385, 14318, 53039, 20223, 19366, 47085, 63575, 931, 13395, 17271, 63776, 39071}, objArr5);
                try {
                    Object[] objArr6 = {(String) objArr5[0]};
                    Object[] objArr7 = new Object[1];
                    a(new char[]{40832, 41251, 13904, 43514}, ViewConfiguration.getScrollBarFadeDuration() >> 16, new char[]{20994, 46519, 46440, 17223}, (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), new char[]{50487, 57713, 35524, 55050, 32344, 35712, 14915, 63004, 41629, 63753, 37803, 61734, 54510, 42114, 55776, 8053, 43275, 4783, 57107, 8031, 62725, 38250, 18543, 28608, 14736, 26745, 6179, 55576, 35208, 33972, 19940, 26673, 18564, 62542, 48849, 24137, 46677, 24796}, objArr7);
                    objArr4[0] = Class.forName((String) objArr7[0]).getDeclaredConstructor(String.class).newInstance(objArr6);
                    char[] cArr4 = {65516, 65512, 65530, 65495, 65534, 0, 65512, 65518, 18, ' ', CharUtils.CR, 16, 65519, 65483, 15, 20, 26, 29, 15, 25, 65516, 65512, 65529, 65518, 65495, 15, 20, 26, 29, 15, 25};
                    int iResolveSize = 31 - View.resolveSize(0, 0);
                    int offsetAfter = TextUtils.getOffsetAfter("", 0);
                    int i38 = getARTIFICIAL_FRAME_PACKAGE_NAME + 119;
                    int i39 = i38 % 128;
                    artificialFrame = i39;
                    if (i38 % 2 == 0) {
                        int i40 = -offsetAfter;
                        int i41 = (i40 ^ (-520)) + ((i40 & (-520)) << 1);
                        i3 = ((i41 | (-4176)) << 1) - (i41 ^ (-4176));
                        i4 = (~offsetAfter) | 8 | i;
                    } else {
                        int i42 = offsetAfter * (-520);
                        i3 = ((i42 & 4176) << 1) + (i42 ^ 4176);
                        int i43 = ~offsetAfter;
                        int i44 = (i43 & 8) | (i43 ^ 8);
                        i4 = (i44 & i) | (i44 ^ i);
                    }
                    int i45 = 521 * (~i4);
                    int i46 = (((i3 | i45) << 1) - (i3 ^ i45)) + ((~(((-9) & offsetAfter) | ((-9) ^ offsetAfter))) * (-1042));
                    int i47 = ~((-9) | offsetAfter);
                    int i48 = ~offsetAfter;
                    int i49 = ~i;
                    int i50 = i48 | i49;
                    int i51 = ~((i50 ^ 8) | (i50 & 8));
                    int i52 = ((i47 ^ i51) | (i51 & i47)) * 521;
                    int i53 = (i39 & 41) + (i39 | 41);
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i53 % 128;
                    if (i53 % 2 != 0) {
                        int i54 = -i52;
                        Object[] objArr8 = new Object[1];
                        b(cArr4, iResolveSize, (i46 & i54) + (i54 | i46), (ViewConfiguration.getScrollDefaultDelay() % 119) * 15015, true, objArr8);
                        obj = objArr8[0];
                    } else {
                        int i55 = ((i46 | i52) << 1) - (i52 ^ i46);
                        int i56 = -(-(ViewConfiguration.getScrollDefaultDelay() >> 16));
                        int i57 = ((i56 | 189) << 1) - (i56 ^ 189);
                        Object[] objArr9 = new Object[1];
                        b(cArr4, iResolveSize, i55, i57, true, objArr9);
                        obj = objArr9[0];
                    }
                    String str = (String) obj;
                    int i58 = artificialFrame + 79;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i58 % 128;
                    try {
                        if (i58 % 2 != 0) {
                            objArr = new Object[1];
                            objArr[1] = str;
                            iAxisFromString = MotionEvent.axisFromString("");
                            cArr = new char[]{40832, 41251, 13904, 43514};
                            i5 = 0;
                        } else {
                            objArr = new Object[]{str};
                            iAxisFromString = MotionEvent.axisFromString("");
                            cArr = new char[]{40832, 41251, 13904, 43514};
                            i5 = 1;
                        }
                        int i59 = iAxisFromString * (-496);
                        int i60 = -(-(i5 * (-496)));
                        int i61 = (i59 ^ i60) + ((i59 & i60) << 1);
                        int i62 = ~iAxisFromString;
                        int i63 = ~i5;
                        int i64 = i61 + ((~((i63 & i62) | (i62 ^ i63))) * 497);
                        int i65 = ~iAxisFromString;
                        int i66 = ~i5;
                        int i67 = i65 | i66;
                        int i68 = ~((i67 ^ i) | (i67 & i));
                        int i69 = ~((i66 ^ i49) | (i66 & i49) | iAxisFromString);
                        int i70 = ((i68 ^ i69) | (i68 & i69)) * 497;
                        int i71 = ((i64 | i70) << 1) - (i70 ^ i64);
                        int i72 = ~i;
                        int i73 = (~(i5 | i62)) | (~((i65 & i72) | (i65 ^ i72)));
                        int i74 = (iAxisFromString & i66) | (i66 ^ iAxisFromString);
                        int i75 = ~((i74 & i) | (i74 ^ i));
                        int i76 = -(-(((i73 & i75) | (i73 ^ i75)) * 497));
                        int i77 = ((i71 | i76) << 1) - (i76 ^ i71);
                        char[] cArr5 = {20994, 46519, 46440, 17223};
                        char maximumFlingVelocity = (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                        char[] cArr6 = {50487, 57713, 35524, 55050, 32344, 35712, 14915, 63004, 41629, 63753, 37803, 61734, 54510, 42114, 55776, 8053, 43275, 4783, 57107, 8031, 62725, 38250, 18543, 28608, 14736, 26745, 6179, 55576, 35208, 33972, 19940, 26673, 18564, 62542, 48849, 24137, 46677, 24796};
                        int i78 = artificialFrame;
                        int i79 = ((i78 | 87) << 1) - (i78 ^ 87);
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i79 % 128;
                        if (i79 % 2 != 0) {
                            Object[] objArr10 = new Object[1];
                            a(cArr, i77, cArr5, maximumFlingVelocity, cArr6, objArr10);
                            Class<?> cls = Class.forName((String) objArr10[0]);
                            Class<?>[] clsArr = new Class[0];
                            clsArr[1] = String.class;
                            declaredConstructor = cls.getDeclaredConstructor(clsArr);
                        } else {
                            Object[] objArr11 = new Object[1];
                            a(cArr, i77, cArr5, maximumFlingVelocity, cArr6, objArr11);
                            declaredConstructor = Class.forName((String) objArr11[0]).getDeclaredConstructor(String.class);
                        }
                        objArr4[1] = declaredConstructor.newInstance(objArr);
                        try {
                            char[] cArr7 = {65534, '\n', '\t', 15, 0, '\t', 15, 65481, 65502, '\n', '\t', 15, 0, 19, 15, 65532, '\t', 65535, CharUtils.CR, '\n', 4, 65535, 65481};
                            int i80 = 22 - (~(-(-(TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)))));
                            int i81 = -(Process.myPid() >> 22);
                            int i82 = (i81 * 673) - 20145;
                            int i83 = ~((i81 ^ i) | (i81 & i));
                            int i84 = -(-(((i83 & 15) | (i83 ^ 15)) * 672));
                            int i85 = ((i82 | i84) << 1) - (i82 ^ i84);
                            int i86 = ~i81;
                            int i87 = ~((i86 & i49) | (i86 ^ i49));
                            int i88 = ~((i ^ 15) | (i & 15));
                            int i89 = (i85 - (~(-(-(((i87 & i88) | (i87 ^ i88)) * (-672)))))) - 1;
                            int i90 = ~((-16) | i49);
                            int i91 = ~((i81 & (-16)) | ((-16) ^ i81));
                            int i92 = ((i91 & i90) | (i90 ^ i91)) * 672;
                            Object[] objArr12 = new Object[1];
                            b(cArr7, i80, ((i89 | i92) << 1) - (i92 ^ i89), 205 - TextUtils.indexOf("", "", 0, 0), false, objArr12);
                            Class<?> cls2 = Class.forName((String) objArr12[0]);
                            int iLastIndexOf = TextUtils.lastIndexOf("", '0', 0);
                            int i93 = (iLastIndexOf * (-518)) - 1423885182;
                            int i94 = ~iLastIndexOf;
                            int i95 = (i94 & i72) | (i94 ^ i72);
                            int i96 = -(-(((~i95) | 77371797) * 519));
                            int i97 = ((i93 | i96) << 1) - (i93 ^ i96);
                            int i98 = ~(i95 | 77371797);
                            int i99 = ~((iLastIndexOf ^ 77371797) | (iLastIndexOf & 77371797) | i);
                            int i100 = i97 + (((i98 & i99) | (i98 ^ i99)) * (-519));
                            int i101 = ~((i ^ 77371797) | (i & 77371797));
                            int i102 = ((i101 & iLastIndexOf) | (iLastIndexOf ^ i101)) * 519;
                            int i103 = -View.MeasureSpec.getSize(0);
                            int iMediaBrowserCompatMediaBrowserImplBaseMediaServiceConnection3 = BasicMarkerFactory.MediaBrowserCompatMediaBrowserImplBaseMediaServiceConnection1();
                            int i104 = (i103 * 367) + 17627744;
                            int i105 = (i103 | 48032) * (-366);
                            int i106 = ((i104 | i105) << 1) - (i105 ^ i104);
                            int i107 = ~(((-48033) & iMediaBrowserCompatMediaBrowserImplBaseMediaServiceConnection3) | ((-48033) ^ iMediaBrowserCompatMediaBrowserImplBaseMediaServiceConnection3));
                            int i108 = i106 + (((i107 & i103) | (i103 ^ i107)) * (-366));
                            int i109 = ~i103;
                            int i110 = ((-48033) ^ i103) | (i103 & (-48033));
                            Object[] objArr13 = new Object[1];
                            a(new char[]{40832, 41251, 13904, 43514}, (i100 ^ i102) + ((i100 & i102) << 1), new char[]{38042, 40089, 40964, 54971}, (char) ((i108 - (~(((~((i109 & 48032) | (i109 ^ 48032))) | (~((i110 & iMediaBrowserCompatMediaBrowserImplBaseMediaServiceConnection3) | (i110 ^ iMediaBrowserCompatMediaBrowserImplBaseMediaServiceConnection3)))) * 366))) - 1), new char[]{12739, 15461, 47451, 15814, 11618, 50161, 26068, 37176, 7353, 59941, 20787, 35272, 56669, 42161, 60976, 40523, 3326}, objArr13);
                            Object objInvoke = cls2.getMethod((String) objArr13[0], null).invoke(context, null);
                            try {
                                char[] cArr8 = {65534, '\n', '\t', 15, 0, '\t', 15, 65481, 65502, '\n', '\t', 15, 0, 19, 15, 65532, '\t', 65535, CharUtils.CR, '\n', 4, 65535, 65481};
                                int i111 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 23;
                                int i112 = -(-TextUtils.getTrimmedLength(""));
                                int i113 = (i112 ^ 15) + ((i112 & 15) << 1);
                                int i114 = -(ViewConfiguration.getJumpTapTimeout() >> 16);
                                int i115 = (i114 & MlKitException.CODE_SCANNER_PIPELINE_INITIALIZATION_ERROR) + (i114 | MlKitException.CODE_SCANNER_PIPELINE_INITIALIZATION_ERROR);
                                Object[] objArr14 = new Object[1];
                                b(cArr8, i111, i113, i115, false, objArr14);
                                Class<?> cls3 = Class.forName((String) objArr14[0]);
                                char[] cArr9 = {40832, 41251, 13904, 43514};
                                int i116 = (-(-(Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)))) - 1;
                                char[] cArr10 = {57210, 32843, 52534, 32414};
                                int i117 = -(ViewConfiguration.getJumpTapTimeout() >> 16);
                                int i118 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                int i119 = (i118 ^ 93) + ((i118 & 93) << 1);
                                artificialFrame = i119 % 128;
                                int i120 = i119 % 2;
                                int i121 = (i118 ^ 57) + ((i118 & 57) << 1);
                                artificialFrame = i121 % 128;
                                int i122 = i121 % 2;
                                int i123 = ((i117 * (-501)) - (-20448459)) + (((~((i117 ^ 40653) | (i117 & 40653))) | (~(((-40654) ^ i) | ((-40654) & i)))) * (-502));
                                int i124 = -(-((~(((-40654) & i72) | ((-40654) ^ i72) | i117)) * (-502)));
                                int i125 = ((i123 | i124) << 1) - (i124 ^ i123);
                                int i126 = ~i117;
                                int i127 = ~((i126 & i) | (i126 ^ i));
                                int i128 = ((i127 & (-40654)) | ((-40654) ^ i127)) * TypedValues.PositionType.TYPE_DRAWPATH;
                                char c2 = (char) (((i125 | i128) << 1) - (i128 ^ i125));
                                Object[] objArr15 = new Object[1];
                                a(cArr9, i116, cArr10, c2, new char[]{40582, 28537, 60738, 58394, 32763, 19851, 6035, 31731, 4463, 37750, 53418, 11099, 7299, 29351}, objArr15);
                                try {
                                    Object[] objArr16 = {cls3.getMethod((String) objArr15[0], null).invoke(context, null), 64};
                                    int iCombineMeasuredStates = View.combineMeasuredStates(0, 0);
                                    Object[] objArr17 = new Object[1];
                                    a(new char[]{40832, 41251, 13904, 43514}, (iCombineMeasuredStates & 1857652990) + (iCombineMeasuredStates | 1857652990), new char[]{65141, 47496, 27502, 47663}, (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16), new char[]{38047, 58090, 9931, 48179, 38571, 10472, 19316, 3685, 45287, 30065, 13678, 52516, 29931, 32886, 60973, 32274, 37534, 28192, 63086, 16350, 45185, 3100, 6664, 37970, 44570, 11213, 6414, 34691, 45078, 5572, 15646, 25388, 18971}, objArr17);
                                    Class<?> cls4 = Class.forName((String) objArr17[0]);
                                    char[] cArr11 = {1, 3, 11, 2, '\n', 65509, 1, 3, 65533, 7, 65535, 65533, 65516, 16};
                                    int i129 = -(ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                                    int iMediaBrowserCompatMediaBrowserImplBaseMediaServiceConnection4 = BasicMarkerFactory.MediaBrowserCompatMediaBrowserImplBaseMediaServiceConnection1();
                                    int i130 = i129 * TypedValues.Custom.TYPE_DIMENSION;
                                    int i131 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                    int i132 = (i131 ^ 25) + ((i131 & 25) << 1);
                                    artificialFrame = i132 % 128;
                                    int i133 = i132 % 2;
                                    int i134 = (i130 ^ (-13545)) + ((i130 & (-13545)) << 1);
                                    int i135 = ~i129;
                                    int i136 = ~(i135 | iMediaBrowserCompatMediaBrowserImplBaseMediaServiceConnection4);
                                    int i137 = ~iMediaBrowserCompatMediaBrowserImplBaseMediaServiceConnection4;
                                    int i138 = ~((i137 ^ 15) | (i137 & 15));
                                    int i139 = -(-(((i136 ^ i138) | (i136 & i138)) * (-1808)));
                                    int i140 = (i134 & i139) + (i134 | i139);
                                    int i141 = ~i129;
                                    int i142 = ~((i141 & (-16)) | (i141 ^ (-16)) | iMediaBrowserCompatMediaBrowserImplBaseMediaServiceConnection4);
                                    int i143 = i137 | i129;
                                    int i144 = ~((i143 & 15) | (i143 ^ 15));
                                    int i145 = (i140 - (~(((i142 & i144) | (i142 ^ i144)) * TypedValues.Custom.TYPE_BOOLEAN))) - 1;
                                    int i146 = ~((i135 & 15) | (i135 ^ 15));
                                    int i147 = ~(((-16) & iMediaBrowserCompatMediaBrowserImplBaseMediaServiceConnection4) | ((-16) ^ iMediaBrowserCompatMediaBrowserImplBaseMediaServiceConnection4));
                                    int i148 = (i146 & i147) | (i146 ^ i147);
                                    int i149 = ~(i129 | (~iMediaBrowserCompatMediaBrowserImplBaseMediaServiceConnection4));
                                    int i150 = i145 + (((i149 & i148) | (i148 ^ i149)) * TypedValues.Custom.TYPE_BOOLEAN);
                                    int iAxisFromString2 = MotionEvent.axisFromString("");
                                    int i151 = (iAxisFromString2 * (-716)) + 4305;
                                    int i152 = ~iAxisFromString2;
                                    int i153 = -(-(((i152 ^ 3) | (i152 & 3)) * (-1434)));
                                    int i154 = ((i151 | i153) << 1) - (i151 ^ i153);
                                    int i155 = ~((i49 ^ 3) | (i49 & 3));
                                    int i156 = ~((iAxisFromString2 & 3) | (iAxisFromString2 ^ 3));
                                    int i157 = i155 | i156;
                                    int i158 = ~(i152 | (-4) | i);
                                    int i159 = -(-(((i157 & i158) | (i157 ^ i158)) * 717));
                                    int i160 = (i154 ^ i159) + ((i159 & i154) << 1);
                                    int i161 = ~((i152 ^ (-4)) | (i152 & (-4)) | i72);
                                    int i162 = (i156 & i161) | (i161 ^ i156);
                                    int i163 = ~(i | 3);
                                    int i164 = -(-(((i162 & i163) | (i162 ^ i163)) * 717));
                                    int i165 = (i160 & i164) + (i164 | i160);
                                    int fadingEdgeLength = ViewConfiguration.getFadingEdgeLength() >> 16;
                                    int i166 = fadingEdgeLength * (-501);
                                    int i167 = (i166 ^ 102612) + ((i166 & 102612) << 1);
                                    int i168 = ~(((-205) ^ i) | ((-205) & i));
                                    int i169 = ~((fadingEdgeLength & 204) | (fadingEdgeLength ^ 204));
                                    int i170 = ((i167 - (~(-(-(((i169 & i168) | (i168 ^ i169)) * (-502)))))) - 1) + ((~((-205) | i72 | fadingEdgeLength)) * (-502));
                                    int i171 = artificialFrame + 5;
                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i171 % 128;
                                    int i172 = i171 % 2;
                                    int i173 = ~fadingEdgeLength;
                                    int i174 = ~((i173 & i) | (i173 ^ i));
                                    int i175 = TypedValues.PositionType.TYPE_DRAWPATH * ((i174 & (-205)) | ((-205) ^ i174));
                                    Object[] objArr18 = new Object[1];
                                    b(cArr11, i150, i165, ((i170 | i175) << 1) - (i175 ^ i170), true, objArr18);
                                    Object objInvoke2 = cls4.getMethod((String) objArr18[0], String.class, Integer.TYPE).invoke(objInvoke, objArr16);
                                    char[] cArr12 = {65519, 65485, '\f', 15, 65485, 19, CharUtils.CR, 4, 19, CharUtils.CR, 14, 2, 65485, 3, '\b', 14, 17, 3, CharUtils.CR, 0, 14, 5, CharUtils.CR, 65512, 4, 6, 0, '\n', 2, 0};
                                    int iLastIndexOf2 = 29 - TextUtils.lastIndexOf("", '0', 0);
                                    int i176 = 19 - (~(AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)));
                                    int iMyTid = Process.myTid() >> 22;
                                    int iMediaBrowserCompatMediaBrowserImplBaseMediaServiceConnection5 = BasicMarkerFactory.MediaBrowserCompatMediaBrowserImplBaseMediaServiceConnection1();
                                    int i177 = iMyTid * 302;
                                    int i178 = (i177 ^ 121203) + ((i177 & 121203) << 1);
                                    int i179 = ~iMyTid;
                                    int i180 = ~iMediaBrowserCompatMediaBrowserImplBaseMediaServiceConnection5;
                                    int i181 = ~((i179 ^ i180) | (i179 & i180));
                                    int i182 = ((i181 & 201) | (i181 ^ 201)) * (-602);
                                    int i183 = ((i178 | i182) << 1) - (i182 ^ i178);
                                    int i184 = ~iMyTid;
                                    int i185 = ~((i184 & (-202)) | (i184 ^ (-202)));
                                    int i186 = ~((i179 & iMediaBrowserCompatMediaBrowserImplBaseMediaServiceConnection5) | (i179 ^ iMediaBrowserCompatMediaBrowserImplBaseMediaServiceConnection5));
                                    int i187 = iMyTid | (~iMediaBrowserCompatMediaBrowserImplBaseMediaServiceConnection5);
                                    int i188 = (~((i187 & 201) | (i187 ^ 201))) | (i185 & i186) | (i185 ^ i186);
                                    int i189 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                    int i190 = ((i189 | 83) << 1) - (i189 ^ 83);
                                    artificialFrame = i190 % 128;
                                    int i191 = i190 % 2;
                                    int i192 = (i183 - (~(-(-((-301) * i188))))) - 1;
                                    int i193 = -(-((~((i180 ^ 201) | (i180 & 201))) * 301));
                                    int i194 = (i192 ^ i193) + ((i193 & i192) << 1);
                                    Object[] objArr19 = new Object[1];
                                    b(cArr12, iLastIndexOf2, i176, i194, true, objArr19);
                                    Class<?> cls5 = Class.forName((String) objArr19[0]);
                                    Object[] objArr20 = new Object[1];
                                    a(new char[]{40832, 41251, 13904, 43514}, Gravity.getAbsoluteGravity(0, 0), new char[]{23929, 55898, 60028, 60216}, (char) TextUtils.indexOf("", ""), new char[]{15531, 41780, 18533, 18608, 44971, 14923, 59001, 35533, 16659, 2177}, objArr20);
                                    Object[] objArr21 = (Object[]) cls5.getField((String) objArr20[0]).get(objInvoke2);
                                    int length = objArr21.length;
                                    int i195 = 0;
                                    while (i195 < length) {
                                        Object obj2 = objArr21[i195];
                                        char[] cArr13 = {40832, 41251, 13904, 43514};
                                        int i196 = -TextUtils.lastIndexOf("", '0', 0);
                                        int iMediaBrowserCompatMediaBrowserImplBaseMediaServiceConnection6 = BasicMarkerFactory.MediaBrowserCompatMediaBrowserImplBaseMediaServiceConnection1();
                                        int i197 = artificialFrame;
                                        int i198 = (i197 ^ 119) + ((i197 & 119) << i12);
                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i198 % 128;
                                        int i199 = i198 % 2;
                                        int i200 = ~i196;
                                        int i201 = (((-496) * i196) - 479628672) + ((~(i200 | 1384506327)) * 497);
                                        int i202 = ~i196;
                                        int i203 = (i202 ^ 1384506327) | (i202 & 1384506327);
                                        int i204 = ~((i203 ^ iMediaBrowserCompatMediaBrowserImplBaseMediaServiceConnection6) | (i203 & iMediaBrowserCompatMediaBrowserImplBaseMediaServiceConnection6));
                                        int i205 = ~iMediaBrowserCompatMediaBrowserImplBaseMediaServiceConnection6;
                                        int i206 = (1384506327 ^ i205) | (1384506327 & i205);
                                        int i207 = ~((i206 ^ i196) | (i206 & i196));
                                        int i208 = ((i204 ^ i207) | (i207 & i204)) * 497;
                                        int i209 = (i201 ^ i208) + ((i208 & i201) << 1);
                                        int i210 = ~iMediaBrowserCompatMediaBrowserImplBaseMediaServiceConnection6;
                                        int i211 = ~((i210 & i200) | (i200 ^ i210));
                                        int i212 = ~((-1384506328) | i202);
                                        int i213 = (i211 & i212) | (i211 ^ i212);
                                        int i214 = ~((i196 & 1384506327) | (1384506327 ^ i196) | iMediaBrowserCompatMediaBrowserImplBaseMediaServiceConnection6);
                                        int i215 = -(-(((i214 & i213) | (i213 ^ i214)) * 497));
                                        int i216 = (i209 & i215) + (i215 | i209);
                                        int capsMode = TextUtils.getCapsMode("", 0, 0);
                                        int iMediaBrowserCompatMediaBrowserImplBaseMediaServiceConnection7 = BasicMarkerFactory.MediaBrowserCompatMediaBrowserImplBaseMediaServiceConnection1();
                                        int i217 = capsMode * (-958);
                                        int i218 = (i217 & (-20528982)) + (i217 | (-20528982));
                                        int i219 = ~iMediaBrowserCompatMediaBrowserImplBaseMediaServiceConnection7;
                                        int i220 = ~(((-21430) ^ i219) | ((-21430) & i219));
                                        Object[] objArr22 = objArr21;
                                        int i221 = ~((~capsMode) | iMediaBrowserCompatMediaBrowserImplBaseMediaServiceConnection7);
                                        int i222 = (i220 ^ i221) | (i221 & i220);
                                        int i223 = ~((i219 ^ capsMode) | (i219 & capsMode));
                                        int i224 = (i218 - (~(((i222 ^ i223) | (i222 & i223)) * 959))) - 1;
                                        int i225 = -(-((~((capsMode ^ 21429) | (capsMode & 21429))) * (-959)));
                                        int i226 = (i224 ^ i225) + ((i225 & i224) << 1);
                                        int i227 = ~capsMode;
                                        int i228 = ~((i227 & i219) | (i227 ^ i219));
                                        int i229 = ~(((-21430) & iMediaBrowserCompatMediaBrowserImplBaseMediaServiceConnection7) | ((-21430) ^ iMediaBrowserCompatMediaBrowserImplBaseMediaServiceConnection7));
                                        int i230 = (i228 & i229) | (i228 ^ i229);
                                        int i231 = ~(iMediaBrowserCompatMediaBrowserImplBaseMediaServiceConnection7 | capsMode);
                                        int i232 = -(-(((i230 & i231) | (i230 ^ i231)) * 959));
                                        Object[] objArr23 = new Object[1];
                                        a(cArr13, i216, new char[]{10737, 31260, 46509, 46931}, (char) (((i226 | i232) << 1) - (i232 ^ i226)), new char[]{12771, 8362, 1094, 37852, 62705}, objArr23);
                                        String str2 = (String) objArr23[0];
                                        int i233 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                        int i234 = (i233 & 37) + (i233 | 37);
                                        artificialFrame = i234 % 128;
                                        int i235 = i234 % 2;
                                        try {
                                            Object[] objArr24 = {str2};
                                            int i236 = -(ViewConfiguration.getWindowTouchSlop() >> 8);
                                            Object[] objArr25 = new Object[1];
                                            a(new char[]{40832, 41251, 13904, 43514}, (i236 ^ (-32683695)) + ((i236 & (-32683695)) << 1), new char[]{20739, 3401, 45566, 19207}, (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16), new char[]{51863, 35892, 8775, 24836, 40071, 25404, 57224, 56742, 33535, 37766, 45627, 7489, 10077, 44533, 57341, 64739, 39789, 27040, 27849, 9345, 4068, 60998, 55911, 48862, 65279, 52226, 54136, 17330, 51552, 32660, 36968, 63342, 6169, 48357, 10173, 8976, 29595}, objArr25);
                                            Class<?> cls6 = Class.forName((String) objArr25[0]);
                                            char[] cArr14 = {7, 65506, CharUtils.CR, 65534, 0, 65534, 65532, 7, 65530, CharUtils.CR, '\f'};
                                            int size = View.MeasureSpec.getSize(0);
                                            int iMediaBrowserCompatMediaBrowserImplBaseMediaServiceConnection8 = BasicMarkerFactory.MediaBrowserCompatMediaBrowserImplBaseMediaServiceConnection1();
                                            int i237 = (size * 51) - 539;
                                            int i238 = -(-(((size ^ iMediaBrowserCompatMediaBrowserImplBaseMediaServiceConnection8) | (size & iMediaBrowserCompatMediaBrowserImplBaseMediaServiceConnection8)) * (-50)));
                                            int i239 = ((i237 | i238) << 1) - (i237 ^ i238);
                                            int i240 = ~size;
                                            int i241 = (i240 & (-12)) | (i240 ^ (-12));
                                            int i242 = ~((i241 & iMediaBrowserCompatMediaBrowserImplBaseMediaServiceConnection8) | (i241 ^ iMediaBrowserCompatMediaBrowserImplBaseMediaServiceConnection8));
                                            int i243 = ~iMediaBrowserCompatMediaBrowserImplBaseMediaServiceConnection8;
                                            int i244 = ((-12) ^ i243) | ((-12) & i243);
                                            int i245 = ~((i244 ^ size) | (i244 & size));
                                            int i246 = -(-(((i242 ^ i245) | (i242 & i245)) * 50));
                                            int i247 = ((i239 | i246) << 1) - (i246 ^ i239);
                                            int i248 = (~(((-12) & size) | ((-12) ^ size))) | (~((i243 & (-12)) | ((-12) ^ i243)));
                                            int i249 = ~iMediaBrowserCompatMediaBrowserImplBaseMediaServiceConnection8;
                                            int i250 = ~((i249 & size) | (i249 ^ size));
                                            int i251 = i247 + (((i250 & i248) | (i248 ^ i250)) * 50);
                                            int i252 = artificialFrame;
                                            int i253 = (i252 & 55) + (i252 | 55);
                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i253 % 128;
                                            int i254 = i253 % 2;
                                            int i255 = 4 - (~(-Color.alpha(0)));
                                            int i256 = -ExpandableListView.getPackedPositionType(0L);
                                            int i257 = (i256 * (-958)) - 198306;
                                            int i258 = ~(((-208) & i49) | ((-208) ^ i49));
                                            int i259 = ~i256;
                                            int i260 = length;
                                            int i261 = -(-(((~((i259 ^ i) | (i259 & i))) | i258 | (~((i72 ^ i256) | (i72 & i256)))) * 959));
                                            int i262 = (i257 & i261) + (i261 | i257) + ((~((i256 ^ 207) | (i256 & 207))) * (-959));
                                            int i263 = ~((i259 ^ i49) | (i259 & i49));
                                            int i264 = ~((-208) | i);
                                            int i265 = (i262 - (~((((i263 & i264) | (i263 ^ i264)) | (~((i256 & i) | (i256 ^ i)))) * 959))) - 1;
                                            Object[] objArr26 = new Object[1];
                                            b(cArr14, i251, i255, i265, true, objArr26);
                                            Object objInvoke3 = cls6.getMethod((String) objArr26[0], String.class).invoke(null, objArr24);
                                            try {
                                                int i266 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                                                Object[] objArr27 = new Object[1];
                                                a(new char[]{40832, 41251, 13904, 43514}, TextUtils.getOffsetBefore("", 0), new char[]{56984, 51112, 41114, 60487}, (char) (((i266 | 18336) << 1) - (i266 ^ 18336)), new char[]{2623, 17725, 41340, 63185, 8152, 44939, 1794, 19242, 18019, 12420, 40854, 41503, 24867, 51852, 16739, 9071, 917, 27454, 46212, 11945, 6313, 27275, 46831, 29043, 31740, 19001, 50927, 25381}, objArr27);
                                                Class<?> cls7 = Class.forName((String) objArr27[0]);
                                                int iAlpha = Color.alpha(0);
                                                int iMediaBrowserCompatMediaBrowserImplBaseMediaServiceConnection9 = BasicMarkerFactory.MediaBrowserCompatMediaBrowserImplBaseMediaServiceConnection1();
                                                int i267 = iAlpha * 934;
                                                int i268 = (i267 & (-1324886812)) + (i267 | (-1324886812));
                                                int i269 = ~iAlpha;
                                                int i270 = ~iMediaBrowserCompatMediaBrowserImplBaseMediaServiceConnection9;
                                                int i271 = ~((i269 ^ i270) | (i269 & i270));
                                                int i272 = -(-((((-337829936) ^ i271) | (i271 & (-337829936))) * (-933)));
                                                int i273 = ((i268 | i272) << 1) - (i272 ^ i268);
                                                int i274 = ~iMediaBrowserCompatMediaBrowserImplBaseMediaServiceConnection9;
                                                int i275 = ~((i274 & (-337829936)) | ((-337829936) ^ i274));
                                                int i276 = ~(((-337829936) ^ iAlpha) | ((-337829936) & iAlpha));
                                                int i277 = ((i275 & i276) | (i275 ^ i276)) * 933;
                                                int i278 = ((i273 | i277) << 1) - (i273 ^ i277);
                                                int i279 = -(-((~(337829935 | iAlpha)) * 933));
                                                Object[] objArr28 = new Object[1];
                                                a(new char[]{40832, 41251, 13904, 43514}, ((i278 | i279) << 1) - (i279 ^ i278), new char[]{12119, 8928, 17428, 42994}, (char) (ViewConfiguration.getScrollBarSize() >> 8), new char[]{61655, 2670, 29300, 35830, 9881, 57208, 30329, 33796, 37998, 46256, 10194}, objArr28);
                                                try {
                                                    Object[] objArr29 = {new ByteArrayInputStream((byte[]) cls7.getMethod((String) objArr28[0], null).invoke(obj2, null))};
                                                    char[] cArr15 = {40832, 41251, 13904, 43514};
                                                    int maximumDrawingCacheSize = ViewConfiguration.getMaximumDrawingCacheSize() >> 24;
                                                    int i280 = ~((maximumDrawingCacheSize ^ i) | (maximumDrawingCacheSize & i));
                                                    int i281 = (maximumDrawingCacheSize * 673) + 944529425 + (((i280 & (-32683695)) | (i280 ^ (-32683695))) * 672);
                                                    int i282 = ~maximumDrawingCacheSize;
                                                    int i283 = ~((i282 & i72) | (i282 ^ i72));
                                                    int i284 = ~(((-32683695) & i) | (i ^ (-32683695)));
                                                    int i285 = i281 + (((i283 & i284) | (i283 ^ i284)) * (-672));
                                                    int i286 = (32683694 ^ i72) | (32683694 & i72);
                                                    int i287 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                    int i288 = (i287 ^ AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY) + ((i287 & AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY) << 1);
                                                    artificialFrame = i288 % 128;
                                                    if (i288 % 2 == 0) {
                                                        int i289 = i285 / (((~(maximumDrawingCacheSize | 32683694)) | (~i286)) * 672);
                                                        mode = (char) View.MeasureSpec.getMode(0);
                                                        i6 = i289;
                                                        cArr2 = new char[]{51863, 35892, 8775, 24836, 40071, 25404, 57224, 56742, 33535, 37766, 45627, 7489, 10077, 44533, 57341, 64739, 39789, 27040, 27849, 9345, 4068, 60998, 55911, 48862, 65279, 52226, 54136, 17330, 51552, 32660, 36968, 63342, 6169, 48357, 10173, 8976, 29595};
                                                        cArr3 = new char[]{20739, 3401, 45566, 19207};
                                                    } else {
                                                        int i290 = ((~((maximumDrawingCacheSize & 32683694) | (32683694 ^ maximumDrawingCacheSize))) | (~i286)) * 672;
                                                        int i291 = (i285 ^ i290) + ((i290 & i285) << 1);
                                                        char[] cArr16 = {20739, 3401, 45566, 19207};
                                                        char[] cArr17 = {51863, 35892, 8775, 24836, 40071, 25404, 57224, 56742, 33535, 37766, 45627, 7489, 10077, 44533, 57341, 64739, 39789, 27040, 27849, 9345, 4068, 60998, 55911, 48862, 65279, 52226, 54136, 17330, 51552, 32660, 36968, 63342, 6169, 48357, 10173, 8976, 29595};
                                                        mode = (char) View.MeasureSpec.getMode(0);
                                                        i6 = i291;
                                                        cArr2 = cArr17;
                                                        cArr3 = cArr16;
                                                    }
                                                    int i292 = artificialFrame + 51;
                                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i292 % 128;
                                                    int i293 = i292 % 2;
                                                    Object[] objArr30 = new Object[1];
                                                    a(cArr15, i6, cArr3, mode, cArr2, objArr30);
                                                    Class<?> cls8 = Class.forName((String) objArr30[0]);
                                                    int i294 = -MotionEvent.axisFromString("");
                                                    int i295 = -(ViewConfiguration.getLongPressTimeout() >> 16);
                                                    Object[] objArr31 = new Object[1];
                                                    a(new char[]{40832, 41251, 13904, 43514}, ((i294 | 238342535) << 1) - (i294 ^ 238342535), new char[]{34840, 13521, 45582, 41942}, (char) ((i295 & 54962) + (i295 | 54962)), new char[]{9729, 1202, 24197, 47012, 20609, 59800, 39680, 23630, 13407, 60807, 31388, 19545, 56399, 26461, 21783, 49671, 20148, 32373, 52064}, objArr31);
                                                    Object objInvoke4 = cls8.getMethod((String) objArr31[0], InputStream.class).invoke(objInvoke3, objArr29);
                                                    int length2 = objArr4.length;
                                                    int i296 = 0;
                                                    for (int i297 = 2; i296 < i297; i297 = 2) {
                                                        int i298 = artificialFrame + 93;
                                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i298 % 128;
                                                        int i299 = i298 % i297;
                                                        Object obj3 = objArr4[i296];
                                                        try {
                                                            char[] cArr18 = {40832, 41251, 13904, 43514};
                                                            int iRed = Color.red(0);
                                                            char[] cArr19 = {45492, 62197, 62242, 54805};
                                                            int i300 = artificialFrame;
                                                            int i301 = (i300 & 113) + (i300 | 113);
                                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i301 % 128;
                                                            int iLastIndexOf3 = i301 % 2 != 0 ? (-1) >>> TextUtils.lastIndexOf("", ';', 1, 1) : (-1) - TextUtils.lastIndexOf("", '0', 0, 0);
                                                            Object[] objArr32 = new Object[1];
                                                            a(cArr18, iRed, cArr19, (char) iLastIndexOf3, new char[]{17973, 28595, 51840, 18275, 40695, 31120, 1352, 63511, 49203, 2024, 50859, 22441, 21816, 29397, 37422, 59378, 26466, 42471, 8619, 26883, 7817, 41548, 32460, 65129, 57629, 47048, 41844, 31851, 63077, 4990, 35237, 43178, 23987, 31226}, objArr32);
                                                            Class<?> cls9 = Class.forName((String) objArr32[0]);
                                                            char[] cArr20 = {40832, 41251, 13904, 43514};
                                                            int scrollBarSize = (ViewConfiguration.getScrollBarSize() >> 8) - 1467426610;
                                                            char[] cArr21 = {52748, 35032, 18344, 34997};
                                                            int i302 = artificialFrame + 51;
                                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i302 % 128;
                                                            int i303 = i302 % 2;
                                                            Object[] objArr33 = new Object[1];
                                                            a(cArr20, scrollBarSize, cArr21, (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16), new char[]{43075, 20868, 5152, 7619, 9257, 36300, 57149, 27973, 8933, 52190, 33068, 3109, 44354, 64922, 15936, 43629, 53648, 17433, 52570, 15322, 36264, 14262, 45625}, objArr33);
                                                            String str3 = (String) objArr33[0];
                                                            int i304 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                            int i305 = (i304 & 107) + (i304 | 107);
                                                            artificialFrame = i305 % 128;
                                                            if (i305 % 2 == 0) {
                                                                obj3.equals(cls9.getMethod(str3, null).invoke(objInvoke4, null));
                                                                throw null;
                                                            }
                                                            if (obj3.equals(cls9.getMethod(str3, null).invoke(objInvoke4, null))) {
                                                                Object[] objArr34 = {new int[]{i}, new int[]{(~(i & 1)) & (i | 1)}, new int[1], null};
                                                                int startUptimeMillis = (int) Process.getStartUptimeMillis();
                                                                int i306 = ~startUptimeMillis;
                                                                int i307 = (-1253695070) + ((startUptimeMillis | 33556572) * 988) + (((~(35703165 | i306)) | 940774016) * (-1976)) + (((~(startUptimeMillis | (-942920610))) | 33556572 | (~(942920609 | i306))) * 988);
                                                                int i308 = artificialFrame;
                                                                int i309 = i308 + 93;
                                                                getARTIFICIAL_FRAME_PACKAGE_NAME = i309 % 128;
                                                                int i310 = i309 % 2;
                                                                int i311 = i307 * (-107);
                                                                int i312 = (880 & i311) + (i311 | 880);
                                                                int i313 = ~(((-17) & i307) | ((-17) ^ i307));
                                                                int i314 = (i308 & 5) + (i308 | 5);
                                                                getARTIFICIAL_FRAME_PACKAGE_NAME = i314 % 128;
                                                                if (i314 % 2 != 0) {
                                                                    int i315 = ~((i72 ^ i307) | (i72 & i307));
                                                                    i7 = i312 + ((-108) << ((i313 & i315) | (i313 ^ i315)));
                                                                    int i316 = ~(((-17) & i) | ((-17) ^ i));
                                                                    int i317 = ~i307;
                                                                    int i318 = ~((i317 & 16) | (i317 ^ 16));
                                                                    i8 = (i316 & i318) | (i316 ^ i318);
                                                                } else {
                                                                    int i319 = ~((i72 ^ i307) | (i72 & i307));
                                                                    i7 = i312 + (((i313 & i319) | (i313 ^ i319)) * (-108));
                                                                    i8 = (~((-17) | i)) | (~((~i307) | 16));
                                                                }
                                                                int i320 = -(-(((i49 & 152049738) | (i49 ^ 152049738)) * 1324));
                                                                int i321 = ((-1416227048) & i320) + (i320 | (-1416227048));
                                                                int i322 = ~((458726010 & i) | (458726010 ^ i));
                                                                int i323 = ~((1226315982 & i) | (1226315982 ^ i));
                                                                int i324 = -(-(((i322 & i323) | (i322 ^ i323)) * (-1324)));
                                                                int i325 = ((i321 | i324) << 1) - (i324 ^ i321);
                                                                int i326 = (i325 ^ (-644088456)) + (((-644088456) & i325) << 1);
                                                                int i327 = ~(((-1056818842) & i49) | ((-1056818842) ^ i49));
                                                                int i328 = -(-(((i327 & 637600400) | (637600400 ^ i327)) * 168));
                                                                int i329 = (1571469253 & i328) + (i328 | 1571469253);
                                                                int i330 = (~(((-637600401) & i) | ((-637600401) ^ i))) * 168;
                                                                int i331 = (i329 ^ i330) + ((i330 & i329) << 1);
                                                                int i332 = ~(((-1711354805) & i49) | ((-1711354805) ^ i49));
                                                                int i333 = (i332 & 1073754404) | (i332 ^ 1073754404);
                                                                int i334 = ~(((-419218442) & i) | ((-419218442) ^ i));
                                                                int i335 = ((i333 & i334) | (i333 ^ i334)) * 168;
                                                                if (i326 <= ((i331 | i335) << 1) - (i335 ^ i331)) {
                                                                    int i336 = ~((i72 ^ 16) | (i72 & 16));
                                                                    int i337 = -(54 << ((i8 & i336) | (i8 ^ i336)));
                                                                    int i338 = ((i7 | i337) << 1) - (i337 ^ i7);
                                                                    int i339 = ~i307;
                                                                    int i340 = ~((i339 & 16) | (i339 ^ 16));
                                                                    i9 = i2 / (i338 >>> (54 % ((i340 & i) | (i ^ i340))));
                                                                    i10 = 57;
                                                                } else {
                                                                    int i341 = ~((i72 ^ 16) | (i72 & 16));
                                                                    int i342 = -(-(54 * ((i8 & i341) | (i8 ^ i341))));
                                                                    int i343 = ((i7 | i342) << 1) - (i342 ^ i7);
                                                                    int i344 = ~i307;
                                                                    int i345 = ~((i344 & 16) | (i344 ^ 16));
                                                                    int i346 = ((i345 & i) | (i ^ i345)) * 54;
                                                                    i9 = (i2 - (~((i343 ^ i346) + ((i346 & i343) << 1)))) - 1;
                                                                    i10 = 13;
                                                                }
                                                                int i347 = i9 ^ (i9 << i10);
                                                                int i348 = i347 >>> 17;
                                                                int i349 = (i347 | i348) & (~(i347 & i348));
                                                                int i350 = i349 << 5;
                                                                ((int[]) objArr34[2])[0] = (i349 | i350) & (~(i349 & i350));
                                                                return objArr34;
                                                            }
                                                            i296++;
                                                        } catch (Throwable th) {
                                                            Throwable cause = th.getCause();
                                                            if (cause != null) {
                                                                throw cause;
                                                            }
                                                            throw th;
                                                        }
                                                    }
                                                    i195++;
                                                    objArr21 = objArr22;
                                                    length = i260;
                                                    i12 = 1;
                                                } catch (Throwable th2) {
                                                    Throwable cause2 = th2.getCause();
                                                    if (cause2 != null) {
                                                        throw cause2;
                                                    }
                                                    throw th2;
                                                }
                                            } catch (Throwable th3) {
                                                Throwable cause3 = th3.getCause();
                                                if (cause3 != null) {
                                                    throw cause3;
                                                }
                                                throw th3;
                                            }
                                        } catch (Throwable th4) {
                                            Throwable cause4 = th4.getCause();
                                            if (cause4 != null) {
                                                throw cause4;
                                            }
                                            throw th4;
                                        }
                                    }
                                } catch (Throwable th5) {
                                    Throwable cause5 = th5.getCause();
                                    if (cause5 != null) {
                                        throw cause5;
                                    }
                                    throw th5;
                                }
                            } catch (Throwable th6) {
                                Throwable cause6 = th6.getCause();
                                if (cause6 != null) {
                                    throw cause6;
                                }
                                throw th6;
                            }
                        } catch (Throwable th7) {
                            Throwable cause7 = th7.getCause();
                            if (cause7 != null) {
                                throw cause7;
                            }
                            throw th7;
                        }
                    } catch (Throwable th8) {
                        Throwable cause8 = th8.getCause();
                        if (cause8 != null) {
                            throw cause8;
                        }
                        throw th8;
                    }
                } catch (Throwable th9) {
                    Throwable cause9 = th9.getCause();
                    if (cause9 != null) {
                        throw cause9;
                    }
                    throw th9;
                }
            } catch (Throwable unused) {
            }
            Object[] objArr35 = new Object[4];
            int[] iArr = new int[1];
            objArr35[0] = iArr;
            int[] iArr2 = new int[1];
            objArr35[1] = iArr2;
            objArr35[2] = new int[1];
            int i351 = getARTIFICIAL_FRAME_PACKAGE_NAME + 37;
            int i352 = i351 % 128;
            artificialFrame = i352;
            int i353 = i351 % 2;
            int i354 = (i352 & 105) + (i352 | 105);
            getARTIFICIAL_FRAME_PACKAGE_NAME = i354 % 128;
            if (i354 % 2 != 0) {
                c = 0;
                iArr2[0] = i;
            } else {
                c = 0;
                iArr[0] = i;
            }
            iArr2[c] = i;
            objArr35[3] = null;
            int i355 = ~((~((int) Runtime.getRuntime().freeMemory())) | 718667775);
            int i356 = ((545350368 | i355) * (-970)) + 1073343080 + ((i355 | 173317407) * 970);
            int i357 = i2 + ((i356 << 1) - i356);
            int i358 = i357 << 13;
            int i359 = ((~i357) & i358) | ((~i358) & i357);
            int i360 = i359 >>> 17;
            int i361 = (i359 | i360) & (~(i359 & i360));
            int i362 = i361 << 5;
            ((int[]) objArr35[2])[0] = ((~i361) & i362) | ((~i362) & i361);
            return objArr35;
        }
    }

    @Override // io.sentry.JsonUnknown
    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    @Override // io.sentry.JsonUnknown
    public void setUnknown(@Nullable Map<String, Object> map) {
        this.unknown = map;
    }
}
