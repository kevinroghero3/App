package io.sentry.protocol;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PointF;
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
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.net.SyslogConstants;
import com.facebook.imageutils.JfifUtil;
import com.google.android.gms.internal.measurement.zzmr;
import com.google.common.base.Ascii;
import com.salesforce.marketingcloud.analytics.stats.b;
import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.JsonUnknown;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.text.Typography;
import o.ArtificialStackFrames;
import o.ICustomTabsCallbackDefault;
import o.extraCallback;
import okhttp3.internal.ws.WebSocketProtocol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class Geo implements JsonUnknown, JsonSerializable {
    private String city;
    private String countryCode;
    private String region;
    private Map<String, Object> unknown;

    /* JADX INFO: loaded from: classes6.dex */
    public static final class JsonKeys {
        public static final String CITY = "city";
        public static final String COUNTRY_CODE = "country_code";
        public static final String REGION = "region";
    }

    public Geo() {
    }

    public Geo(@NotNull Geo geo) {
        this.city = geo.city;
        this.countryCode = geo.countryCode;
        this.region = geo.region;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x005a  */
    public static Geo fromMap(@NotNull Map<String, Object> map) {
        byte b;
        Geo geo = new Geo();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            Object value = entry.getValue();
            String key = entry.getKey();
            key.hashCode();
            int iHashCode = key.hashCode();
            if (iHashCode != -934795532) {
                if (iHashCode != 3053931) {
                    if (iHashCode == 1481071862 && key.equals(JsonKeys.COUNTRY_CODE)) {
                        b = 2;
                    } else {
                        b = -1;
                    }
                } else if (key.equals(JsonKeys.CITY)) {
                    b = 1;
                } else {
                    b = -1;
                }
            } else if (key.equals(JsonKeys.REGION)) {
                b = 0;
            } else {
                b = -1;
            }
            if (b == 0) {
                geo.region = value instanceof String ? (String) value : null;
            } else if (b == 1) {
                geo.city = value instanceof String ? (String) value : null;
            } else if (b == 2) {
                geo.countryCode = value instanceof String ? (String) value : null;
            }
        }
        return geo;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(@Nullable String str) {
        this.city = str;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public void setCountryCode(@Nullable String str) {
        this.countryCode = str;
    }

    public String getRegion() {
        return this.region;
    }

    public void setRegion(@Nullable String str) {
        this.region = str;
    }

    public static final class Deserializer implements JsonDeserializer<Geo> {
        private static final byte[] $$a = {Ascii.SYN, -120, 37, 108};
        private static final int $$b = 147;
        private static int $10 = 0;
        private static int $11 = 1;
        private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        private static int artificialFrame = 1;
        private static char[] ArtificialStackFrames = {44390, 44406, 44371, 44405, 44696, 44389, 44320, 44367, 44395, 44392, 44366, 44376, 44396, 44387, 44386, 44408, 44355, 44385, 44701, 44356, 44702, 44699, 44393, 44700, 44334, 44697, 44403, 44698, 44361, 44398, 44353, 44391, 44409, 44349, 44345, 44332, 44368, 44394, 44388, 44373, 44400, 44703, 44336, 44354, 44397, 44402, 44404, 44399, 44341};
        private static char coroutineCreation = 39069;
        private static long coroutineBoundary = 367803732971287840L;
        private static int accessartificialFrame = -1151259316;
        private static char CoroutineDebuggingKt = 11596;

        /* JADX WARN: Code duplicated, block: B:10:0x0023  */
        /* JADX WARN: Code duplicated, block: B:8:0x001d  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x0025). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static java.lang.String $$c(short r5, byte r6, int r7) {
            /*
                byte[] r0 = io.sentry.protocol.Geo.Deserializer.$$a
                int r7 = r7 * 2
                int r1 = r7 + 1
                int r6 = r6 + 97
                int r5 = r5 * 2
                int r5 = r5 + 4
                byte[] r1 = new byte[r1]
                r2 = 0
                if (r0 != 0) goto L15
                r6 = r5
                r3 = r7
                r4 = r2
                goto L25
            L15:
                r3 = r2
            L16:
                byte r4 = (byte) r6
                r1[r3] = r4
                int r4 = r3 + 1
                if (r3 != r7) goto L23
                java.lang.String r5 = new java.lang.String
                r5.<init>(r1, r2)
                return r5
            L23:
                r3 = r0[r5]
            L25:
                int r3 = -r3
                int r5 = r5 + 1
                int r6 = r6 + r3
                r3 = r4
                goto L16
            */
            throw new UnsupportedOperationException("Method not decompiled: io.sentry.protocol.Geo.Deserializer.$$c(short, byte, int):java.lang.String");
        }

        private static void a(char[] cArr, char c, int i, char[] cArr2, char[] cArr3, Object[] objArr) throws Throwable {
            int i2 = 2 % 2;
            ICustomTabsCallbackDefault iCustomTabsCallbackDefault = new ICustomTabsCallbackDefault();
            int length = cArr2.length;
            char[] cArr4 = new char[length];
            int length2 = cArr3.length;
            char[] cArr5 = new char[length2];
            int i3 = 0;
            System.arraycopy(cArr2, 0, cArr4, 0, length);
            System.arraycopy(cArr3, 0, cArr5, 0, length2);
            cArr4[0] = (char) (cArr4[0] ^ c);
            cArr5[2] = (char) (cArr5[2] + ((char) i));
            int length3 = cArr.length;
            char[] cArr6 = new char[length3];
            iCustomTabsCallbackDefault.a = 0;
            int i4 = 1;
            int i5 = $11 + 1;
            $10 = i5 % 128;
            int i6 = i5 % 2;
            while (iCustomTabsCallbackDefault.a < length3) {
                try {
                    Object[] objArr2 = {iCustomTabsCallbackDefault};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-10548171);
                    if (objAccessartificialFrame == null) {
                        int iRgb = (-16777183) - Color.rgb(i3, i3, i3);
                        char c2 = (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                        int i7 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 1483;
                        byte b = (byte) i3;
                        byte b2 = (byte) (b + 2);
                        String str$$c = $$c(b, b2, (byte) (b2 - 2));
                        Class[] clsArr = new Class[i4];
                        clsArr[i3] = Object.class;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(iRgb, c2, i7, 1614432829, false, str$$c, clsArr);
                    }
                    int iIntValue = ((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
                    try {
                        Object[] objArr3 = {iCustomTabsCallbackDefault};
                        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1818210492);
                        if (objAccessartificialFrame2 == null) {
                            int maximumFlingVelocity = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 32;
                            char longPressTimeout = (char) ((ViewConfiguration.getLongPressTimeout() >> 16) + 49168);
                            int defaultSize = View.getDefaultSize(i3, i3) + 899;
                            byte length4 = (byte) $$a.length;
                            String str$$c2 = $$c((byte) i3, length4, (byte) (length4 - 4));
                            Class[] clsArr2 = new Class[i4];
                            clsArr2[i3] = Object.class;
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(maximumFlingVelocity, longPressTimeout, defaultSize, 214239564, false, str$$c2, clsArr2);
                        }
                        int iIntValue2 = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
                        int i8 = cArr4[iCustomTabsCallbackDefault.a % 4] * 32718;
                        try {
                            Object[] objArr4 = new Object[3];
                            objArr4[2] = Integer.valueOf(cArr5[iIntValue]);
                            objArr4[i4] = Integer.valueOf(i8);
                            objArr4[i3] = iCustomTabsCallbackDefault;
                            Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(1532285801);
                            if (objAccessartificialFrame3 == null) {
                                byte b3 = (byte) i3;
                                byte b4 = (byte) (b3 + 1);
                                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(TextUtils.lastIndexOf("", '0', i3) + 24, (char) (ViewConfiguration.getKeyRepeatDelay() >> 16), MotionEvent.axisFromString("") + 2442, -1003383455, false, $$c(b3, b4, (byte) (b4 - 1)), new Class[]{Object.class, Integer.TYPE, Integer.TYPE});
                            }
                            ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                            try {
                                Object[] objArr5 = {Integer.valueOf(cArr4[iIntValue2] * 32718), Integer.valueOf(cArr5[iIntValue])};
                                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-950633141);
                                if (objAccessartificialFrame4 == null) {
                                    byte b5 = (byte) 0;
                                    byte b6 = (byte) (b5 + 3);
                                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(19 - TextUtils.lastIndexOf("", '0', 0, 0), (char) ((-16747462) - Color.rgb(0, 0, 0)), 1748 - Gravity.getAbsoluteGravity(0, 0), 1479752515, false, $$c(b5, b6, (byte) (b6 - 3)), new Class[]{Integer.TYPE, Integer.TYPE});
                                }
                                cArr5[iIntValue2] = ((Character) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).charValue();
                                cArr4[iIntValue2] = iCustomTabsCallbackDefault.MediaBrowserCompatApi21ConnectionCallback;
                                cArr6[iCustomTabsCallbackDefault.a] = (char) (((((long) (cArr4[iIntValue2] ^ cArr[iCustomTabsCallbackDefault.a])) ^ (coroutineBoundary ^ (-899883803867009716L))) ^ ((long) ((int) (((long) accessartificialFrame) ^ (-899883803867009716L))))) ^ ((long) ((char) (((long) CoroutineDebuggingKt) ^ (-899883803867009716L)))));
                                iCustomTabsCallbackDefault.a++;
                                i4 = 1;
                                i3 = 0;
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
            int i9 = $10 + 53;
            $11 = i9 % 128;
            if (i9 % 2 != 0) {
                objArr[0] = str;
            } else {
                Object obj = null;
                obj.hashCode();
                throw null;
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Code duplicated, block: B:22:0x004c  */
        @Override // io.sentry.JsonDeserializer
        public Geo deserialize(@NotNull ObjectReader objectReader, @NotNull ILogger iLogger) throws Exception {
            byte b;
            objectReader.beginObject();
            Geo geo = new Geo();
            ConcurrentHashMap concurrentHashMap = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.hashCode();
                int iHashCode = strNextName.hashCode();
                if (iHashCode != -934795532) {
                    if (iHashCode != 3053931) {
                        if (iHashCode == 1481071862 && strNextName.equals(JsonKeys.COUNTRY_CODE)) {
                            b = 2;
                        } else {
                            b = -1;
                        }
                    } else if (strNextName.equals(JsonKeys.CITY)) {
                        b = 1;
                    } else {
                        b = -1;
                    }
                } else if (strNextName.equals(JsonKeys.REGION)) {
                    b = 0;
                } else {
                    b = -1;
                }
                if (b == 0) {
                    geo.region = objectReader.nextStringOrNull();
                } else if (b == 1) {
                    geo.city = objectReader.nextStringOrNull();
                } else if (b == 2) {
                    geo.countryCode = objectReader.nextStringOrNull();
                } else {
                    if (concurrentHashMap == null) {
                        concurrentHashMap = new ConcurrentHashMap();
                    }
                    objectReader.nextUnknown(iLogger, concurrentHashMap, strNextName);
                }
            }
            geo.setUnknown(concurrentHashMap);
            objectReader.endObject();
            return geo;
        }

        /* JADX WARN: Code duplicated, block: B:42:0x017a  */
        /* JADX WARN: Code duplicated, block: B:43:0x0192  */
        /* JADX WARN: Code duplicated, block: B:47:0x01de A[Catch: all -> 0x0390, TRY_ENTER, TryCatch #0 {all -> 0x0390, blocks: (B:44:0x0194, B:47:0x01de, B:48:0x0255), top: B:78:0x0194 }] */
        /* JADX WARN: Code duplicated, block: B:51:0x0268  */
        /* JADX WARN: Code duplicated, block: B:54:0x02a8 A[Catch: all -> 0x03ae, TryCatch #1 {all -> 0x03ae, blocks: (B:9:0x0030, B:11:0x003e, B:12:0x0074, B:15:0x0088, B:17:0x0096, B:18:0x00c8, B:23:0x00e2, B:25:0x00f3, B:26:0x0123, B:52:0x026a, B:54:0x02a8, B:56:0x0312), top: B:80:0x0030 }] */
        /* JADX WARN: Code duplicated, block: B:55:0x030f  */
        /* JADX WARN: Code duplicated, block: B:58:0x033d  */
        /* JADX WARN: Code duplicated, block: B:60:0x0347  */
        /* JADX WARN: Code duplicated, block: B:61:0x036f  */
        private static void b(int i, char[] cArr, byte b, Object[] objArr) throws Throwable {
            int i2;
            Object[] objArr2;
            Object objAccessartificialFrame;
            Object objAccessartificialFrame2;
            int i3 = 2;
            int i4 = 2 % 2;
            extraCallback extracallback = new extraCallback();
            char[] cArr2 = ArtificialStackFrames;
            int i5 = -1819279892;
            int i6 = 7;
            if (cArr2 != null) {
                int i7 = $10 + 83;
                $11 = i7 % 128;
                int i8 = i7 % 2;
                int length = cArr2.length;
                char[] cArr3 = new char[length];
                int i9 = 0;
                while (i9 < length) {
                    int i10 = $11 + i6;
                    $10 = i10 % 128;
                    if (i10 % i3 != 0) {
                        try {
                            Object[] objArr3 = {Integer.valueOf(cArr2[i9])};
                            Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(i5);
                            if (objAccessartificialFrame3 == null) {
                                byte b2 = (byte) 0;
                                byte b3 = b2;
                                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getLongPressTimeout() >> 16) + 15, (char) ((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 20488), 2148 - (ViewConfiguration.getTapTimeout() >> 16), 216710116, false, $$c(b2, b3, b3), new Class[]{Integer.TYPE});
                            }
                            cArr3[i9] = ((Character) ((Method) objAccessartificialFrame3).invoke(null, objArr3)).charValue();
                            i9--;
                            i3 = 2;
                        } catch (Throwable th) {
                            Throwable cause = th.getCause();
                            if (cause == null) {
                                throw th;
                            }
                            throw cause;
                        }
                    } else {
                        Object[] objArr4 = {Integer.valueOf(cArr2[i9])};
                        Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(i5);
                        if (objAccessartificialFrame4 == null) {
                            byte b4 = (byte) 0;
                            byte b5 = b4;
                            objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation((-16777201) - Color.rgb(0, 0, 0), (char) (20488 - Drawable.resolveOpacity(0, 0)), 2148 - ExpandableListView.getPackedPositionType(0L), 216710116, false, $$c(b4, b5, b5), new Class[]{Integer.TYPE});
                        }
                        cArr3[i9] = ((Character) ((Method) objAccessartificialFrame4).invoke(null, objArr4)).charValue();
                        i9++;
                        i3 = 2;
                        i5 = -1819279892;
                    }
                    i6 = 7;
                }
                cArr2 = cArr3;
            }
            Object[] objArr5 = {Integer.valueOf(coroutineCreation)};
            Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1819279892);
            if (objAccessartificialFrame5 == null) {
                byte b6 = (byte) 0;
                byte b7 = b6;
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getJumpTapTimeout() >> 16) + 15, (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 20487), 2148 - KeyEvent.getDeadChar(0, 0), 216710116, false, $$c(b6, b7, b7), new Class[]{Integer.TYPE});
            }
            char cCharValue = ((Character) ((Method) objAccessartificialFrame5).invoke(null, objArr5)).charValue();
            char[] cArr4 = new char[i];
            if (i % 2 != 0) {
                i2 = i - 1;
                cArr4[i2] = (char) (cArr[i2] - b);
            } else {
                i2 = i;
            }
            if (i2 > 1) {
                extracallback.a = 0;
                while (extracallback.a < i2) {
                    int i11 = $11 + 117;
                    $10 = i11 % 128;
                    if (i11 % 2 != 0) {
                        extracallback.createBrowser = cArr[extracallback.a];
                        extracallback.c = cArr[extracallback.a];
                        if (extracallback.createBrowser == extracallback.c) {
                            cArr4[extracallback.a] = (char) (extracallback.createBrowser - b);
                            cArr4[extracallback.a + 1] = (char) (extracallback.c - b);
                        } else {
                            try {
                                objArr2 = new Object[]{extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback};
                                objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1894223152);
                                if (objAccessartificialFrame == null) {
                                    byte b8 = (byte) 0;
                                    byte b9 = (byte) (b8 + 5);
                                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(TextUtils.getTrimmedLength("") + 46, (char) (TextUtils.getOffsetAfter("", 0) + 58859), 2463 - TextUtils.indexOf((CharSequence) "", '0'), 276640984, false, $$c(b8, b9, (byte) (b9 - 5)), new Class[]{Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class});
                                }
                                if (((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue() == extracallback.g) {
                                    Object[] objArr6 = {extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, Integer.valueOf(cCharValue), extracallback};
                                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1361113423);
                                    if (objAccessartificialFrame2 == null) {
                                        byte b10 = (byte) 0;
                                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 23, (char) KeyEvent.getDeadChar(0, 0), 791 - MotionEvent.axisFromString(""), -834291897, false, $$c(b10, (byte) (b10 | 8), b10), new Class[]{Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Integer.TYPE, Object.class});
                                    }
                                    int iIntValue = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr6)).intValue();
                                    int i12 = (extracallback.d * cCharValue) + extracallback.g;
                                    cArr4[extracallback.a] = cArr2[iIntValue];
                                    cArr4[extracallback.a + 1] = cArr2[i12];
                                    int i13 = $11 + 51;
                                    $10 = i13 % 128;
                                    int i14 = i13 % 2;
                                } else if (extracallback.b == extracallback.d) {
                                    extracallback.j = ((extracallback.j + cCharValue) - 1) % cCharValue;
                                    extracallback.g = ((extracallback.g + cCharValue) - 1) % cCharValue;
                                    int i15 = (extracallback.b * cCharValue) + extracallback.j;
                                    int i16 = (extracallback.d * cCharValue) + extracallback.g;
                                    cArr4[extracallback.a] = cArr2[i15];
                                    cArr4[extracallback.a + 1] = cArr2[i16];
                                } else {
                                    int i17 = (extracallback.b * cCharValue) + extracallback.g;
                                    int i18 = (extracallback.d * cCharValue) + extracallback.j;
                                    cArr4[extracallback.a] = cArr2[i17];
                                    cArr4[extracallback.a + 1] = cArr2[i18];
                                }
                            } catch (Throwable th2) {
                                Throwable cause2 = th2.getCause();
                                if (cause2 == null) {
                                    throw th2;
                                }
                                throw cause2;
                            }
                        }
                    } else {
                        extracallback.createBrowser = cArr[extracallback.a];
                        extracallback.c = cArr[extracallback.a + 1];
                        if (extracallback.createBrowser == extracallback.c) {
                            cArr4[extracallback.a] = (char) (extracallback.createBrowser - b);
                            cArr4[extracallback.a + 1] = (char) (extracallback.c - b);
                        } else {
                            objArr2 = new Object[]{extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback};
                            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1894223152);
                            if (objAccessartificialFrame == null) {
                                byte b11 = (byte) 0;
                                byte b12 = (byte) (b11 + 5);
                                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(TextUtils.getTrimmedLength("") + 46, (char) (TextUtils.getOffsetAfter("", 0) + 58859), 2463 - TextUtils.indexOf((CharSequence) "", '0'), 276640984, false, $$c(b11, b12, (byte) (b12 - 5)), new Class[]{Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class});
                            }
                            if (((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue() == extracallback.g) {
                                Object[] objArr7 = {extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, Integer.valueOf(cCharValue), extracallback};
                                objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1361113423);
                                if (objAccessartificialFrame2 == null) {
                                    byte b13 = (byte) 0;
                                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 23, (char) KeyEvent.getDeadChar(0, 0), 791 - MotionEvent.axisFromString(""), -834291897, false, $$c(b13, (byte) (b13 | 8), b13), new Class[]{Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Integer.TYPE, Object.class});
                                }
                                int iIntValue2 = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr7)).intValue();
                                int i19 = (extracallback.d * cCharValue) + extracallback.g;
                                cArr4[extracallback.a] = cArr2[iIntValue2];
                                cArr4[extracallback.a + 1] = cArr2[i19];
                                int i110 = $11 + 51;
                                $10 = i110 % 128;
                                int i111 = i110 % 2;
                            } else if (extracallback.b == extracallback.d) {
                                extracallback.j = ((extracallback.j + cCharValue) - 1) % cCharValue;
                                extracallback.g = ((extracallback.g + cCharValue) - 1) % cCharValue;
                                int i112 = (extracallback.b * cCharValue) + extracallback.j;
                                int i113 = (extracallback.d * cCharValue) + extracallback.g;
                                cArr4[extracallback.a] = cArr2[i112];
                                cArr4[extracallback.a + 1] = cArr2[i113];
                            } else {
                                int i114 = (extracallback.b * cCharValue) + extracallback.g;
                                int i115 = (extracallback.d * cCharValue) + extracallback.j;
                                cArr4[extracallback.a] = cArr2[i114];
                                cArr4[extracallback.a + 1] = cArr2[i115];
                            }
                        }
                    }
                    extracallback.a += 2;
                }
            }
            for (int i20 = 0; i20 < i; i20++) {
                cArr4[i20] = (char) (cArr4[i20] ^ 13722);
            }
            objArr[0] = new String(cArr4);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v23, types: [java.lang.reflect.Method] */
        /* JADX WARN: Type inference failed for: r7v0 */
        /* JADX WARN: Type inference failed for: r7v1 */
        /* JADX WARN: Type inference failed for: r7v104 */
        /* JADX WARN: Type inference failed for: r7v105 */
        /* JADX WARN: Type inference failed for: r7v106 */
        /* JADX WARN: Type inference failed for: r7v107 */
        /* JADX WARN: Type inference failed for: r7v108 */
        /* JADX WARN: Type inference failed for: r7v109 */
        /* JADX WARN: Type inference failed for: r7v110 */
        /* JADX WARN: Type inference failed for: r7v111 */
        /* JADX WARN: Type inference failed for: r7v113 */
        /* JADX WARN: Type inference failed for: r7v12 */
        /* JADX WARN: Type inference failed for: r7v2, types: [int] */
        /* JADX WARN: Type inference failed for: r7v30 */
        /* JADX WARN: Type inference failed for: r7v32, types: [java.lang.Object[]] */
        /* JADX WARN: Type inference failed for: r7v41, types: [byte[]] */
        /* JADX WARN: Type inference failed for: r7v75 */
        /* JADX WARN: Type inference failed for: r7v80, types: [int] */
        /* JADX WARN: Type inference failed for: r7v90, types: [java.lang.String] */
        public static Object[] accessartificialFrame(Context context, int i, int i2) {
            int i3;
            int i4;
            int i5;
            Object obj;
            int i6;
            char[] cArr;
            int maximumFlingVelocity;
            int i7;
            int i8;
            int i9;
            int i10;
            int i11;
            int i12 = i2;
            int i13 = 2 % 2;
            int i14 = artificialFrame;
            ?? r7 = 1;
            r7 = 1;
            int i15 = 1;
            r7 = 1;
            r7 = 1;
            r7 = 1;
            r7 = 1;
            r7 = 1;
            r7 = 1;
            r7 = 1;
            r7 = 1;
            int i16 = (i14 ^ 77) + ((i14 & 77) << 1);
            int i17 = i16 % 128;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i17;
            Object obj2 = null;
            if (i16 % 2 != 0) {
                obj2.hashCode();
                throw null;
            }
            int i18 = 0;
            if (context == null) {
                int i19 = (i17 ^ 23) + ((i17 & 23) << 1);
                artificialFrame = i19 % 128;
                int i20 = i19 % 2;
                Object[] objArr = {new int[]{i}, new int[]{i}, new int[1], null};
                int i21 = (~((-72189333) | i)) | 67437952;
                int i22 = ~((~i) | 911185822);
                int i23 = (-1685277154) + ((i21 | i22) * (-470)) + (((~(i | (-4751381))) | i22) * 470);
                int iRequestPostMessageChannel = zzmr.requestPostMessageChannel();
                int i24 = i23 * (-858);
                int i25 = (i24 << 1) - i24;
                int i26 = -(-(iRequestPostMessageChannel * (-859)));
                int i27 = (i25 & i26) + (i26 | i25);
                int i28 = ~(~iRequestPostMessageChannel);
                int i29 = ~i23;
                int i30 = ((-1) ^ i29) | i29;
                int i31 = ~((i30 & iRequestPostMessageChannel) | (i30 ^ iRequestPostMessageChannel));
                int i32 = -(-(((i28 & i31) | (i28 ^ i31)) * 859));
                int i33 = (((i27 & i32) + (i32 | i27)) - (~(((~((~iRequestPostMessageChannel) | i29)) | (~i29)) * 859))) - 1;
                int i34 = ((i12 | i33) << 1) - (i12 ^ i33);
                int i35 = i34 ^ (i34 << 13);
                int i36 = i35 ^ (i35 >>> 17);
                int i37 = i36 << 5;
                ((int[]) objArr[2])[0] = (i36 | i37) & (~(i36 & i37));
                return objArr;
            }
            try {
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0) + 38;
                char[] cArr2 = {Typography.amp, 16, 3, 15, 17, 22, '!', '\f', '\n', 6, '+', 24, 4, CoreConstants.SINGLE_QUOTE_CHAR, 31, 24, 4, CoreConstants.DASH_CHAR, '\n', 23, 20, '+', 13839, 13839, 25, '\n', '*', '+', '+', '#', '+', 24, '\"', '\b', 26, '$', 19, '\n'};
                int i38 = -View.MeasureSpec.getMode(0);
                int iRequestPostMessageChannel2 = zzmr.requestPostMessageChannel();
                int i39 = i38 * (-419);
                int i40 = (i39 & 42521) + (i39 | 42521);
                int i41 = -(-((~((iRequestPostMessageChannel2 ^ 101) | (iRequestPostMessageChannel2 & 101))) * TypedValues.CycleType.TYPE_EASING));
                int i42 = (i40 & i41) + (i40 | i41);
                int i43 = ~i38;
                int i44 = ((i43 ^ 101) | (i43 & 101)) * (-420);
                int i45 = (i42 ^ i44) + ((i42 & i44) << 1);
                int i46 = ~i38;
                int i47 = ~((i46 & (-102)) | (i46 ^ (-102)));
                int i48 = ~iRequestPostMessageChannel2;
                int i49 = ~((i48 & 101) | (i48 ^ 101));
                int i50 = -(-(((i47 & i49) | (i47 ^ i49)) * TypedValues.CycleType.TYPE_EASING));
                Object[] objArr2 = new Object[1];
                b(iMakeMeasureSpec, cArr2, (byte) ((i45 & i50) + (i45 | i50)), objArr2);
                Object[] objArr3 = (Object[]) Array.newInstance(Class.forName((String) objArr2[0]), 2);
                int iAlpha = Color.alpha(0);
                int iRequestPostMessageChannel3 = zzmr.requestPostMessageChannel();
                int i51 = (iAlpha * (-183)) + 5735;
                int i52 = ~iAlpha;
                int i53 = ((i52 ^ 31) | (i52 & 31)) * (-368);
                int i54 = (i51 & i53) + (i51 | i53);
                int i55 = iAlpha | (-32);
                int i56 = ~iRequestPostMessageChannel3;
                int i57 = (i54 - (~(-(-(((i55 & i56) | (i55 ^ i56)) * SyslogConstants.LOG_LOCAL7))))) - 1;
                int i58 = ~((~iAlpha) | (-32));
                int i59 = ~((i56 & iAlpha) | (i56 ^ iAlpha));
                int i60 = -(-(((~((iAlpha & 31) | (iAlpha ^ 31))) | (i59 & i58) | (i58 ^ i59)) * SyslogConstants.LOG_LOCAL7));
                Object[] objArr4 = new Object[1];
                b((i57 & i60) + (i57 | i60), new char[]{17, '\t', '\"', 31, 31, '$', '.', '0', 24, '$', 5, 20, 0, 19, '\n', Typography.amp, '*', 14, '\"', 31, 31, '$', '.', '0', 24, '$', CoreConstants.PERCENT_CHAR, 14, ' ', CoreConstants.LEFT_PARENTHESIS_CHAR, 13852}, (byte) (82 - TextUtils.lastIndexOf("", '0', 0, 0)), objArr4);
                try {
                    try {
                        Object[] objArr5 = {(String) objArr4[0]};
                        int maximumFlingVelocity2 = ViewConfiguration.getMaximumFlingVelocity() >> 16;
                        Object[] objArr6 = new Object[1];
                        b(((maximumFlingVelocity2 | 38) << 1) - (maximumFlingVelocity2 ^ 38), new char[]{Typography.amp, 16, 3, 15, 17, 22, '!', '\f', '\n', 6, '+', 24, 4, CoreConstants.SINGLE_QUOTE_CHAR, 31, 24, 4, CoreConstants.DASH_CHAR, '\n', 23, 20, '+', 13839, 13839, 25, '\n', '*', '+', '+', '#', '+', 24, '\"', '\b', 26, '$', 19, '\n'}, (byte) (100 - (~(-(ViewConfiguration.getWindowTouchSlop() >> 8)))), objArr6);
                        Class<?> cls = Class.forName((String) objArr6[0]);
                        int i61 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                        int i62 = (i61 ^ 69) + ((i61 & 69) << 1);
                        artificialFrame = i62 % 128;
                        int i63 = i62 % 2;
                        objArr3[0] = cls.getDeclaredConstructor(String.class).newInstance(objArr5);
                        char[] cArr3 = {3175, 19153, 14928, 51688, 51309, 64161, 36447, 2175, 33980, 48197, 4392, 58404, 23308, 40509, 51261, 22066, 53913, 18797, 61563, 44306, 59829, 57516, 32209, 11784, 39923, 53462, 53427, 30138, 2304, 12268, 13831};
                        int i64 = (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                        int iRequestPostMessageChannel4 = zzmr.requestPostMessageChannel();
                        int i65 = (i64 * 659) - 1644471;
                        int i66 = ~i64;
                        int i67 = ~((i66 & 2503) | (i66 ^ 2503));
                        int i68 = ~(((-2504) ^ i64) | ((-2504) & i64));
                        int i69 = (i67 ^ i68) | (i67 & i68);
                        int i70 = (iRequestPostMessageChannel4 & i64) | (i64 ^ iRequestPostMessageChannel4);
                        int i71 = ~i70;
                        int i72 = ((i69 ^ i71) | (i69 & i71)) * (-658);
                        int i73 = ((i65 | i72) << 1) - (i65 ^ i72);
                        int i74 = (i64 & (-2504)) | ((-2504) ^ i64);
                        int i75 = -(-((~i74) * 658));
                        int i76 = ~i74;
                        int i77 = ~i70;
                        char c = (char) ((((i73 & i75) + (i75 | i73)) - (~(((i76 & i77) | (i76 ^ i77)) * 658))) - 1);
                        int i78 = -TextUtils.getOffsetAfter("", 0);
                        int i79 = artificialFrame;
                        int i80 = (i79 & 67) + (i79 | 67);
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i80 % 128;
                        if (i80 % 2 != 0) {
                            int i81 = (i78 & (-183)) + (i78 | (-183));
                            int i82 = ~i78;
                            int i83 = -((-368) % ((i82 ^ 1631318091) | (i82 & 1631318091)));
                            i5 = (i81 & i83) + (i81 | i83);
                        } else {
                            int i84 = ~i78;
                            i5 = (((i78 * (-183)) + 1146136115) - (~(((i84 ^ 1631318091) | (i84 & 1631318091)) * (-368)))) - 1;
                        }
                        int i85 = ((-1631318092) & i78) | (i78 ^ (-1631318092));
                        int i86 = ~i;
                        int i87 = (i5 - (~(((i85 ^ i86) | (i85 & i86)) * SyslogConstants.LOG_LOCAL7))) - 1;
                        int i88 = ~i78;
                        int i89 = ~((i88 ^ (-1631318092)) | (i88 & (-1631318092)));
                        int i90 = ~((i86 ^ i78) | (i86 & i78));
                        int i91 = ((i89 ^ i90) | (i90 & i89) | (~(i78 | 1631318091))) * SyslogConstants.LOG_LOCAL7;
                        Object[] objArr7 = new Object[1];
                        a(cArr3, c, (i87 ^ i91) + ((i87 & i91) << 1), new char[]{19319, 15344, 51297, 21257}, new char[]{55404, 22961, 19449, 63128}, objArr7);
                        try {
                            Object[] objArr8 = {(String) objArr7[0]};
                            int iLastIndexOf = 37 - TextUtils.lastIndexOf("", '0');
                            char[] cArr4 = {Typography.amp, 16, 3, 15, 17, 22, '!', '\f', '\n', 6, '+', 24, 4, CoreConstants.SINGLE_QUOTE_CHAR, 31, 24, 4, CoreConstants.DASH_CHAR, '\n', 23, 20, '+', 13839, 13839, 25, '\n', '*', '+', '+', '#', '+', 24, '\"', '\b', 26, '$', 19, '\n'};
                            int iIndexOf = TextUtils.indexOf((CharSequence) "", '0', 0);
                            Object[] objArr9 = new Object[1];
                            b(iLastIndexOf, cArr4, (byte) ((iIndexOf ^ 102) + ((iIndexOf & 102) << 1)), objArr9);
                            Object objNewInstance = Class.forName((String) objArr9[0]).getDeclaredConstructor(String.class).newInstance(objArr8);
                            int i92 = artificialFrame;
                            int i93 = (i92 & 73) + (i92 | 73);
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i93 % 128;
                            if (i93 % 2 != 0) {
                                objArr3[1] = objNewInstance;
                                int i94 = 7 / 0;
                            } else {
                                objArr3[1] = objNewInstance;
                            }
                            try {
                                int i95 = -View.MeasureSpec.makeMeasureSpec(0, 0);
                                int i96 = getARTIFICIAL_FRAME_PACKAGE_NAME + 63;
                                artificialFrame = i96 % 128;
                                int i97 = i96 % 2;
                                int i98 = ((-958) * i95) - 22034;
                                int i99 = ~i;
                                int i100 = ~((-24) | i99);
                                int i101 = ~i95;
                                int i102 = ~(i101 | i);
                                int i103 = ((i100 ^ i102) | (i100 & i102) | (~((i86 ^ i95) | (i86 & i95)))) * 959;
                                int i104 = (((i98 & i103) + (i98 | i103)) - (~(-(-((~(i95 | 23)) * (-959)))))) - 1;
                                int i105 = ~((i101 ^ i86) | (i101 & i86));
                                int i106 = ~(((-24) & i) | ((-24) ^ i));
                                int i107 = (i105 & i106) | (i105 ^ i106);
                                int i108 = ~(i95 | i);
                                Object[] objArr10 = new Object[1];
                                b((i104 - (~(((i108 & i107) | (i107 ^ i108)) * 959))) - 1, new char[]{15, 31, CoreConstants.DASH_CHAR, 3, '+', 26, CoreConstants.DASH_CHAR, 31, '\f', '0', ' ', '+', 1, '!', CoreConstants.DASH_CHAR, 25, 19, CoreConstants.COMMA_CHAR, ' ', '+', 1, 19, 13886}, (byte) (80 - KeyEvent.getDeadChar(0, 0)), objArr10);
                                Class<?> cls2 = Class.forName((String) objArr10[0]);
                                int i109 = -(-(ViewConfiguration.getTapTimeout() >> 16));
                                Object[] objArr11 = new Object[1];
                                a(new char[]{34558, 13238, 7877, 64971, 14110, 58249, 18031, 28896, 18548, 3625, 11235, 1639, 13566, 65020, 45367, 32451, 16631}, (char) ((i109 & 10249) + (i109 | 10249)), ((byte) KeyEvent.getModifierMetaStateMask()) + Ascii.BS, new char[]{2024, 1237, 2405, 46632}, new char[]{55404, 22961, 19449, 63128}, objArr11);
                                Object objInvoke = cls2.getMethod((String) objArr11[0], null).invoke(context, null);
                                try {
                                    int i110 = -(-(ViewConfiguration.getDoubleTapTimeout() >> 16));
                                    int i111 = (i110 & 23) + (i110 | 23);
                                    char[] cArr5 = {15, 31, CoreConstants.DASH_CHAR, 3, '+', 26, CoreConstants.DASH_CHAR, 31, '\f', '0', ' ', '+', 1, '!', CoreConstants.DASH_CHAR, 25, 19, CoreConstants.COMMA_CHAR, ' ', '+', 1, 19, 13886};
                                    int i112 = artificialFrame;
                                    int i113 = ((i112 | 59) << 1) - (i112 ^ 59);
                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i113 % 128;
                                    if (i113 % 2 != 0) {
                                        int i114 = -View.MeasureSpec.makeMeasureSpec(0, 0);
                                        Object[] objArr12 = new Object[1];
                                        b(i111, cArr5, (byte) (((i114 | 69) << 1) - (i114 ^ 69)), objArr12);
                                        obj = objArr12[0];
                                    } else {
                                        int i115 = -(-View.MeasureSpec.makeMeasureSpec(0, 0));
                                        Object[] objArr13 = new Object[1];
                                        b(i111, cArr5, (byte) ((i115 & 80) + (i115 | 80)), objArr13);
                                        obj = objArr13[0];
                                    }
                                    Class<?> cls3 = Class.forName((String) obj);
                                    int i116 = -(ViewConfiguration.getJumpTapTimeout() >> 16);
                                    int i117 = (i116 ^ 14) + ((i116 & 14) << 1);
                                    char[] cArr6 = {'!', 3, '+', CoreConstants.SINGLE_QUOTE_CHAR, 20, '\n', '\n', 15, '!', 3, 17, 24, '/', 2};
                                    byte modifierMetaStateMask = (byte) KeyEvent.getModifierMetaStateMask();
                                    Object[] objArr14 = new Object[1];
                                    b(i117, cArr6, (byte) ((modifierMetaStateMask ^ Ascii.CAN) + ((modifierMetaStateMask & Ascii.CAN) << 1)), objArr14);
                                    try {
                                        Object[] objArr15 = {cls3.getMethod((String) objArr14[0], null).invoke(context, null), 64};
                                        Object[] objArr16 = new Object[1];
                                        a(new char[]{19419, 54868, 9878, 17106, 44566, 54805, 49296, 61877, 19746, 41353, 45496, 27630, 19621, 239, 43105, 44331, 16326, 53951, 57386, 47983, 65234, 21398, 35002, 49166, 27502, 11973, 63801, 8233, 35673, 11113, 22555, 43604, 46019}, (char) TextUtils.getOffsetAfter("", 0), (-1604207809) - (~(-(ViewConfiguration.getDoubleTapTimeout() >> 16))), new char[]{16484, 25019, 30624, 59517}, new char[]{55404, 22961, 19449, 63128}, objArr16);
                                        Class<?> cls4 = Class.forName((String) objArr16[0]);
                                        char[] cArr7 = {20773, 1049, 18138, 25849, 20833, 18901, 46502, 25800, 62064, 18925, 37040, 42984, 61574, 21588};
                                        int windowTouchSlop = ViewConfiguration.getWindowTouchSlop();
                                        int i118 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                        int i119 = (i118 ^ 41) + ((i118 & 41) << 1);
                                        artificialFrame = i119 % 128;
                                        int i120 = i119 % 2;
                                        int i121 = windowTouchSlop >> 8;
                                        int i122 = i121 * (-563);
                                        int i123 = (i122 ^ 19117905) + ((i122 & 19117905) << 1);
                                        int i124 = ~i121;
                                        int i125 = ~((-33838) | i86);
                                        int i126 = ((~((33837 ^ i) | (33837 & i))) | (i124 ^ i125) | (i125 & i124)) * (-564);
                                        int i127 = (i123 ^ i126) + ((i123 & i126) << 1);
                                        int i128 = (i124 ^ 33837) | (i124 & 33837);
                                        int i129 = -(-((~((i128 & i) | (i128 ^ i))) * 1128));
                                        int i130 = (i127 ^ i129) + ((i129 & i127) << 1);
                                        int i131 = ~i121;
                                        int i132 = ((~((i131 & i99) | (i131 ^ i99))) | (~((i121 & 33837) | (i121 ^ 33837)))) * 564;
                                        Object[] objArr17 = new Object[1];
                                        a(cArr7, (char) ((i130 ^ i132) + ((i132 & i130) << 1)), TextUtils.indexOf("", "", 0, 0), new char[]{21530, 34495, 11632, 54404}, new char[]{55404, 22961, 19449, 63128}, objArr17);
                                        Object objInvoke2 = cls4.getMethod((String) objArr17[0], String.class, Integer.TYPE).invoke(objInvoke, objArr15);
                                        int mode = View.MeasureSpec.getMode(0);
                                        int iRequestPostMessageChannel5 = zzmr.requestPostMessageChannel();
                                        int i133 = mode * (-523);
                                        int i134 = (i133 & 7890) + (i133 | 7890);
                                        int i135 = ~mode;
                                        int i136 = ~((i135 & 30) | (i135 ^ 30));
                                        int i137 = ~((-31) | mode);
                                        int i138 = i134 + (((i136 & i137) | (i136 ^ i137) | (~((-31) | iRequestPostMessageChannel5))) * 262);
                                        int i139 = ~(((-31) ^ mode) | ((-31) & mode));
                                        int i140 = (i138 - (~(-(-(i139 * (-786)))))) - 1;
                                        int i141 = ~iRequestPostMessageChannel5;
                                        int i142 = ~((i141 & (-31)) | ((-31) ^ i141));
                                        int i143 = ~mode;
                                        int i144 = artificialFrame + b.f40o;
                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i144 % 128;
                                        int i145 = i144 % 2;
                                        int i146 = ~((i143 & 30) | (i143 ^ 30));
                                        int i147 = (i146 & i142) | (i142 ^ i146);
                                        int i148 = (i140 - (~(262 * ((i147 & i139) | (i147 ^ i139))))) - 1;
                                        char[] cArr8 = {15, 31, CoreConstants.DASH_CHAR, 3, '+', 26, CoreConstants.DASH_CHAR, 31, '\f', '0', ' ', '+', 1, '!', CoreConstants.DASH_CHAR, 25, CoreConstants.PERCENT_CHAR, '/', 22, Typography.amp, 20, '\n', '\n', 15, '!', 3, 29, 30, 5, '*'};
                                        int i149 = -(CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                                        Object[] objArr18 = new Object[1];
                                        b(i148, cArr8, (byte) ((i149 & b.f40o) + (i149 | b.f40o)), objArr18);
                                        Class<?> cls5 = Class.forName((String) objArr18[0]);
                                        int fadingEdgeLength = ViewConfiguration.getFadingEdgeLength() >> 16;
                                        int i150 = getARTIFICIAL_FRAME_PACKAGE_NAME + 113;
                                        artificialFrame = i150 % 128;
                                        int i151 = i150 % 2;
                                        int i152 = ~fadingEdgeLength;
                                        int i153 = ~(((-11) & i99) | ((-11) ^ i99));
                                        int i154 = (i152 & i153) | (i152 ^ i153);
                                        int i155 = ~((10 ^ i) | (10 & i));
                                        int i156 = ((-563) * fadingEdgeLength) + 5650 + (((i154 & i155) | (i154 ^ i155)) * (-564));
                                        int i157 = ~fadingEdgeLength;
                                        int i158 = (i157 ^ 10) | (i157 & 10);
                                        int i159 = -(-((~((i158 & i) | (i158 ^ i))) * 1128));
                                        int i160 = ((i156 | i159) << 1) - (i156 ^ i159);
                                        int i161 = ((~(fadingEdgeLength | 10)) | (~((i157 ^ i99) | (i157 & i99)))) * 564;
                                        Object[] objArr19 = new Object[1];
                                        b(((i160 | i161) << 1) - (i161 ^ i160), new char[]{27, 23, ' ', 30, 18, CoreConstants.DASH_CHAR, '\n', 3, '\f', '!'}, (byte) (19 - (~(-(TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1))))), objArr19);
                                        Object[] objArr20 = (Object[]) cls5.getField((String) objArr19[0]).get(objInvoke2);
                                        int length = objArr20.length;
                                        int i162 = 0;
                                        while (i162 < length) {
                                            Object obj3 = objArr20[i162];
                                            int iResolveSize = View.resolveSize(i18, i18);
                                            int iRequestPostMessageChannel6 = zzmr.requestPostMessageChannel();
                                            int i163 = getARTIFICIAL_FRAME_PACKAGE_NAME + 17;
                                            int i164 = i163 % 128;
                                            artificialFrame = i164;
                                            int i165 = i163 % 2;
                                            int i166 = 866 * iResolveSize;
                                            int i167 = (i166 ^ (-4320)) + ((i166 & (-4320)) << i15);
                                            int i168 = ~iResolveSize;
                                            int i169 = ~iRequestPostMessageChannel6;
                                            int i170 = ~((i168 ^ i169) | (i168 & i169));
                                            int i171 = (((-6) ^ i170) | ((-6) & i170)) * (-865);
                                            int i172 = ((((i167 | i171) << 1) - (i167 ^ i171)) - (~(-(-((~((iResolveSize ^ iRequestPostMessageChannel6) | (iResolveSize & iRequestPostMessageChannel6))) * 865))))) - 1;
                                            int i173 = ((i164 | 69) << 1) - (i164 ^ 69);
                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i173 % 128;
                                            if (i173 % 2 != 0) {
                                                int i174 = ~iRequestPostMessageChannel6;
                                                int i175 = ~(((-6) ^ i174) | ((-6) & i174));
                                                int i176 = ~((i174 & iResolveSize) | (i174 ^ iResolveSize));
                                                int i177 = -((i176 & i175) | (i175 ^ i176));
                                                i6 = i172 >> ((i177 ^ 865) + ((i177 & 865) << 1));
                                                cArr = new char[]{'\n', 25, '*', '+', 13819};
                                                maximumFlingVelocity = ViewConfiguration.getMaximumFlingVelocity();
                                                i7 = 57;
                                            } else {
                                                int i178 = ~(((-6) ^ i169) | ((-6) & i169));
                                                int i179 = ~((i169 & iResolveSize) | (i169 ^ iResolveSize));
                                                int i180 = -(-(((i179 & i178) | (i178 ^ i179)) * 865));
                                                i6 = (i172 | i180) + (i172 & i180);
                                                cArr = new char[]{'\n', 25, '*', '+', 13819};
                                                maximumFlingVelocity = ViewConfiguration.getMaximumFlingVelocity();
                                                i7 = 88;
                                            }
                                            int i181 = artificialFrame;
                                            int i182 = (i181 & 73) + (i181 | 73);
                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i182 % 128;
                                            if (i182 % 2 != 0) {
                                                i8 = -(maximumFlingVelocity / WebSocketProtocol.PAYLOAD_SHORT);
                                                int i183 = -i8;
                                                i9 = ((i183 | (-432)) << 1) - (i183 ^ (-432));
                                            } else {
                                                i8 = -(maximumFlingVelocity >> 16);
                                                i9 = i8 * (-432);
                                            }
                                            int i184 = 434 * i7;
                                            int i185 = (i9 ^ i184) + ((i184 & i9) << 1);
                                            int i186 = ~i8;
                                            int i187 = i186 | i86;
                                            int i188 = -(-((~((i187 ^ i7) | (i187 & i7))) * 433));
                                            int i189 = (i185 & i188) + (i185 | i188);
                                            int i190 = ~i7;
                                            int i191 = ~((i190 ^ i) | (i190 & i));
                                            int i192 = ((i186 ^ i191) | (i191 & i186)) * (-433);
                                            int i193 = ~((i186 & i) | (i186 ^ i));
                                            int i194 = ~(i8 | i7);
                                            byte b = (byte) ((i189 ^ i192) + ((i189 & i192) << 1) + (((i194 & i193) | (i193 ^ i194)) * 433));
                                            Object[] objArr21 = new Object[1];
                                            b(i6, cArr, b, objArr21);
                                            r7 = 0;
                                            try {
                                                r7 = new Object[]{(String) objArr21[0]};
                                                char keyRepeatTimeout = (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                                                int i195 = -(AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                                                Object[] objArr22 = objArr20;
                                                Object[] objArr23 = new Object[1];
                                                a(new char[]{25592, 39938, 53937, 12802, 16406, 5592, 34799, 18680, 62113, 6431, 1752, 13659, 44701, 42287, 10167, 23529, 28118, 4351, 26358, 33140, 12557, 41680, 17723, 35015, 46501, 18935, 18355, 16650, 14321, 35776, 59854, 46094, 16631, 2622, 7977, 23752, 19327}, keyRepeatTimeout, (i195 & (-997730392)) + (i195 | (-997730392)), new char[]{42902, 34775, 33476, 4224}, new char[]{55404, 22961, 19449, 63128}, objArr23);
                                                Class<?> cls6 = Class.forName((String) objArr23[0]);
                                                char offsetBefore = (char) TextUtils.getOffsetBefore("", 0);
                                                int i196 = -(ViewConfiguration.getMinimumFlingVelocity() >> 16);
                                                int iRequestPostMessageChannel7 = zzmr.requestPostMessageChannel();
                                                int i197 = i196 * (-405);
                                                int i198 = (i197 ^ (-1585592255)) + ((i197 & (-1585592255)) << 1);
                                                int i199 = ~((-1431277544) | iRequestPostMessageChannel7);
                                                int i200 = length;
                                                int i201 = ~iRequestPostMessageChannel7;
                                                int i202 = (i201 ^ i196) | (i201 & i196);
                                                int i203 = ((~((i202 ^ 1431277543) | (i202 & 1431277543))) | i199) * (-406);
                                                int i204 = (i198 & i203) + (i198 | i203);
                                                int i205 = ~iRequestPostMessageChannel7;
                                                int i206 = i162;
                                                int i207 = -(-((~((-1431277544) | i205 | i196)) * (-406)));
                                                int i208 = ((i204 | i207) << 1) - (i207 ^ i204);
                                                int i209 = ~i196;
                                                int i210 = ~((i209 & iRequestPostMessageChannel7) | (i209 ^ iRequestPostMessageChannel7));
                                                int i211 = ~((i205 & 1431277543) | (i205 ^ 1431277543));
                                                int i212 = -(-(((i211 & i210) | (i210 ^ i211)) * 406));
                                                Object[] objArr24 = new Object[1];
                                                a(new char[]{29781, 16986, 29786, 2892, 63568, 57141, 13324, 52755, 57065, 45592, 25800}, offsetBefore, ((i208 | i212) << 1) - (i208 ^ i212), new char[]{59161, 20367, 61269, 63857}, new char[]{55404, 22961, 19449, 63128}, objArr24);
                                                Object objInvoke3 = cls6.getMethod((String) objArr24[0], String.class).invoke(null, r7);
                                                try {
                                                    Object[] objArr25 = new Object[1];
                                                    b(MotionEvent.axisFromString("") + 29, new char[]{15, 31, CoreConstants.DASH_CHAR, 3, '+', 26, CoreConstants.DASH_CHAR, 31, '\f', '0', ' ', '+', 1, '!', CoreConstants.DASH_CHAR, 25, CoreConstants.PERCENT_CHAR, '/', 23, 3, 24, 29, 31, 15, CoreConstants.DASH_CHAR, 4, '/', 3}, (byte) (164 - (~(-AndroidCharacter.getMirror('0')))), objArr25);
                                                    Class<?> cls7 = Class.forName((String) objArr25[0]);
                                                    int iIndexOf2 = TextUtils.indexOf((CharSequence) "", '0', 0) + 12;
                                                    char[] cArr9 = {'/', '0', '.', 29, '/', 4, 31, CoreConstants.COMMA_CHAR, 3, 24, 13898};
                                                    int iAxisFromString = MotionEvent.axisFromString("");
                                                    Object[] objArr26 = new Object[1];
                                                    b(iIndexOf2, cArr9, (byte) ((iAxisFromString & 104) + (iAxisFromString | 104)), objArr26);
                                                    r7 = (byte[]) cls7.getMethod((String) objArr26[0], null).invoke(obj3, null);
                                                    try {
                                                        Object[] objArr27 = {new ByteArrayInputStream(r7)};
                                                        char[] cArr10 = {25592, 39938, 53937, 12802, 16406, 5592, 34799, 18680, 62113, 6431, 1752, 13659, 44701, 42287, 10167, 23529, 28118, 4351, 26358, 33140, 12557, 41680, 17723, 35015, 46501, 18935, 18355, 16650, 14321, 35776, 59854, 46094, 16631, 2622, 7977, 23752, 19327};
                                                        int i213 = -(ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                                                        int iRequestPostMessageChannel8 = zzmr.requestPostMessageChannel();
                                                        int i214 = i213 * 960;
                                                        int i215 = ((i214 | (-1917)) << 1) - (i214 ^ (-1917));
                                                        int i216 = ~iRequestPostMessageChannel8;
                                                        int i217 = ~(((-2) & i216) | ((-2) ^ i216));
                                                        int i218 = ~((i213 ^ iRequestPostMessageChannel8) | (i213 & iRequestPostMessageChannel8));
                                                        int i219 = -(-(((i217 ^ i218) | (i217 & i218)) * 959));
                                                        int i220 = (i215 & i219) + (i215 | i219);
                                                        int i221 = (i220 & 1918) + (i220 | 1918);
                                                        int i222 = ~((iRequestPostMessageChannel8 & (-2)) | ((-2) ^ iRequestPostMessageChannel8));
                                                        int i223 = ~((i213 & i216) | (i216 ^ i213));
                                                        int i224 = ((i223 & i222) | (i222 ^ i223)) * 959;
                                                        char c2 = (char) ((i221 ^ i224) + ((i224 & i221) << 1));
                                                        int i225 = -TextUtils.getCapsMode("", 0, 0);
                                                        int i226 = artificialFrame;
                                                        int i227 = ((i226 | 81) << 1) - (i226 ^ 81);
                                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i227 % 128;
                                                        int i228 = i227 % 2;
                                                        int iRequestPostMessageChannel9 = zzmr.requestPostMessageChannel();
                                                        int i229 = i225 * 980;
                                                        int i230 = (i229 ^ 822748162) + ((i229 & 822748162) << 1);
                                                        int i231 = ~iRequestPostMessageChannel9;
                                                        int i232 = (~((997730392 ^ i231) | (997730392 & i231))) * 979;
                                                        int i233 = (i230 ^ i232) + ((i232 & i230) << 1);
                                                        int i234 = (i225 | iRequestPostMessageChannel9) * (-979);
                                                        int i235 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                        int i236 = (i235 ^ 19) + ((i235 & 19) << 1);
                                                        artificialFrame = i236 % 128;
                                                        int i237 = i236 % 2;
                                                        int i238 = (i233 ^ i234) + ((i233 & i234) << 1) + (979 * ((~((i225 & i231) | (i231 ^ i225))) | (~((997730392 ^ iRequestPostMessageChannel9) | (iRequestPostMessageChannel9 & 997730392)))));
                                                        Object[] objArr28 = new Object[1];
                                                        a(cArr10, c2, i238, new char[]{42902, 34775, 33476, 4224}, new char[]{55404, 22961, 19449, 63128}, objArr28);
                                                        Class<?> cls8 = Class.forName((String) objArr28[0]);
                                                        char[] cArr11 = {42336, 53723, 52483, 20868, 63174, 30442, 13328, 9127, 10993, 43936, 29925, 42914, 30823, 24220, 24363, 35653, 57764, 62603, 61531};
                                                        int minimumFlingVelocity = ViewConfiguration.getMinimumFlingVelocity() >> 16;
                                                        int i239 = minimumFlingVelocity * (-574);
                                                        int i240 = (i239 & (-19860974)) + (i239 | (-19860974));
                                                        int i241 = ~minimumFlingVelocity;
                                                        int i242 = (i240 - (~(((~(i241 | i86)) | (~(((-34602) ^ i) | ((-34602) & i)))) * 1150))) - 1;
                                                        int i243 = ~(((-34602) & i) | ((-34602) ^ i));
                                                        int i244 = ~(34601 | i86);
                                                        int i245 = ((i243 ^ i244) | (i243 & i244)) * (-575);
                                                        int i246 = ((i242 | i245) << 1) - (i245 ^ i242);
                                                        int i247 = -(-(((~((minimumFlingVelocity & i86) | (i86 ^ minimumFlingVelocity))) | (~((i241 & i) | (i241 ^ i)))) * 575));
                                                        char c3 = (char) ((i246 & i247) + (i247 | i246));
                                                        int trimmedLength = TextUtils.getTrimmedLength("");
                                                        int i248 = trimmedLength * 758;
                                                        int i249 = ((i248 | 54337688) << 1) - (i248 ^ 54337688);
                                                        int i250 = ((trimmedLength ^ i86) | (trimmedLength & i86)) * (-757);
                                                        int i251 = (((i249 & i250) + (i250 | i249)) - (~((~(((90970653 ^ trimmedLength) | (90970653 & trimmedLength)) | i)) * 1514))) - 1;
                                                        int i252 = ~trimmedLength;
                                                        int i253 = ~((i252 ^ 90970653) | (90970653 & i252));
                                                        int i254 = artificialFrame + 105;
                                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i254 % 128;
                                                        int i255 = i254 % 2;
                                                        int i256 = ~((90970653 ^ i99) | (90970653 & i99));
                                                        int i257 = (i256 & i253) | (i253 ^ i256);
                                                        int i258 = ((-90970654) & trimmedLength) | (trimmedLength ^ (-90970654));
                                                        int i259 = ~((i258 & i) | (i258 ^ i));
                                                        int i260 = -(-(757 * ((i257 & i259) | (i257 ^ i259))));
                                                        try {
                                                            Object[] objArr29 = new Object[1];
                                                            a(cArr11, c3, ((i251 | i260) << 1) - (i260 ^ i251), new char[]{58049, 37861, 10746, 17799}, new char[]{55404, 22961, 19449, 63128}, objArr29);
                                                            Object objInvoke4 = cls8.getMethod((String) objArr29[0], InputStream.class).invoke(objInvoke3, objArr27);
                                                            try {
                                                                int length2 = objArr3.length;
                                                                int i261 = 0;
                                                                while (i261 < 2) {
                                                                    int i262 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                                    int i263 = (i262 & 53) + (i262 | 53);
                                                                    artificialFrame = i263 % 128;
                                                                    r7 = i263 % 2;
                                                                    if (r7 == 0) {
                                                                        Object obj4 = objArr3[i261];
                                                                        Object obj5 = null;
                                                                        obj5.hashCode();
                                                                        throw null;
                                                                    }
                                                                    Object obj6 = objArr3[i261];
                                                                    try {
                                                                        int i264 = -(SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                                                                        int i265 = (i264 & 35) + (i264 | 35);
                                                                        char[] cArr12 = {Typography.amp, 16, 3, 15, 25, 27, 6, '\f', '\n', 3, 25, '+', 31, 25, '\f', 6, '.', '/', 25, '\n', '*', '+', 30, 20, 3, '/', '+', 25, 1, 21, '\n', 20, '/', 4};
                                                                        int i266 = -TextUtils.indexOf("", "", 0);
                                                                        Object[] objArr30 = new Object[1];
                                                                        b(i265, cArr12, (byte) (((i266 | 65) << 1) - (i266 ^ 65)), objArr30);
                                                                        Class<?> cls9 = Class.forName((String) objArr30[0]);
                                                                        char[] cArr13 = {43270, 3516, 21161, 4394, 41081, 16149, 53501, 9887, 60529, 10134, 57627, 1613, 52399, 21455, 22192, 22421, 10706, 41541, 56381, 56300, 64196, 28956, 9085};
                                                                        int i267 = -(ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                                                                        int i268 = ~i267;
                                                                        int i269 = ~((i268 ^ i86) | (i268 & i86));
                                                                        int i270 = ~(((-2) ^ i267) | ((-2) & i267));
                                                                        int i271 = (i267 * (-337)) + 339 + (((i269 ^ i270) | (i269 & i270) | (~((i267 ^ i) | (i267 & i)))) * (-338));
                                                                        int i272 = -(-((~((i268 ^ 1) | (i268 & 1))) * 338));
                                                                        int i273 = ((i271 | i272) << 1) - (i271 ^ i272);
                                                                        int i274 = ~((i268 ^ i86) | (i268 & i86));
                                                                        int i275 = i267 | 1;
                                                                        int i276 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                                        int i277 = (i276 ^ 71) + ((i276 & 71) << 1);
                                                                        artificialFrame = i277 % 128;
                                                                        int i278 = i277 % 2;
                                                                        int i279 = ~((i275 & i) | (i275 ^ i));
                                                                        char c4 = (char) (i273 + (338 * ((i279 & i274) | (i274 ^ i279))));
                                                                        int windowTouchSlop2 = ViewConfiguration.getWindowTouchSlop() >> 8;
                                                                        int i280 = ~windowTouchSlop2;
                                                                        int i281 = ~((i280 ^ (-1296727094)) | (i280 & (-1296727094)));
                                                                        int i282 = (i99 ^ windowTouchSlop2) | (i99 & windowTouchSlop2);
                                                                        int i283 = ~((i282 ^ 1296727093) | (i282 & 1296727093));
                                                                        int i284 = ((windowTouchSlop2 * 221) - 515391831) + (((i281 ^ i283) | (i281 & i283)) * 220);
                                                                        int i285 = ~(i86 | 1296727093);
                                                                        int i286 = -(-(((i285 & windowTouchSlop2) | (windowTouchSlop2 ^ i285)) * (-440)));
                                                                        int i287 = (i284 ^ i286) + ((i284 & i286) << 1);
                                                                        int i288 = windowTouchSlop2 | 1296727093;
                                                                        int i289 = -(-(((i288 & i) | (i288 ^ i)) * 220));
                                                                        int i290 = ((i289 & i287) << 1) + (i287 ^ i289);
                                                                        int i291 = getARTIFICIAL_FRAME_PACKAGE_NAME + 55;
                                                                        artificialFrame = i291 % 128;
                                                                        int i292 = i291 % 2;
                                                                        Object[] objArr31 = new Object[1];
                                                                        a(cArr13, c4, i290, new char[]{13690, 19068, 38477, 31146}, new char[]{55404, 22961, 19449, 63128}, objArr31);
                                                                        r7 = (String) objArr31[0];
                                                                        if (obj6.equals(cls9.getMethod(r7, null).invoke(objInvoke4, null))) {
                                                                            int i293 = (i & (-2)) | (i86 & 1);
                                                                            Object[] objArr32 = new Object[4];
                                                                            objArr32[0] = new int[]{i};
                                                                            int[] iArr = new int[1];
                                                                            objArr32[1] = iArr;
                                                                            int[] iArr2 = new int[1];
                                                                            objArr32[2] = iArr2;
                                                                            int i294 = getARTIFICIAL_FRAME_PACKAGE_NAME + 95;
                                                                            int i295 = i294 % 128;
                                                                            artificialFrame = i295;
                                                                            int i296 = i294 % 2;
                                                                            iArr[0] = i293;
                                                                            objArr32[3] = null;
                                                                            int i297 = (i295 & 55) + (i295 | 55);
                                                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i297 % 128;
                                                                            int i298 = i297 % 2;
                                                                            int i299 = (-104172642) + ((4933644 | i86) * (-192)) + (((~((-973386995) | i86)) | 303136) * (-384)) + (((~((-303137) | i)) | (~((-973083859) | i86)) | (~(978320638 | i))) * JfifUtil.MARKER_SOFn);
                                                                            int i300 = (i2 - (~(-(-((i299 ^ 16) + ((i299 & 16) << 1)))))) - 1;
                                                                            int i301 = ((i295 | 69) << 1) - (i295 ^ 69);
                                                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i301 % 128;
                                                                            if (i301 % 2 != 0) {
                                                                                int i302 = i300 ^ (i300 >>> 123);
                                                                                i10 = i302 ^ (i302 + 25);
                                                                                i11 = 3;
                                                                            } else {
                                                                                int i303 = i300 ^ (i300 << 13);
                                                                                i10 = i303 ^ (i303 >>> 17);
                                                                                i11 = 5;
                                                                            }
                                                                            int i304 = i10 << i11;
                                                                            iArr2[0] = ((~i10) & i304) | ((~i304) & i10);
                                                                            return objArr32;
                                                                        }
                                                                        i261 = (i261 | 1) + (i261 & 1);
                                                                        int i305 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                                        int i306 = ((i305 | 67) << 1) - (i305 ^ 67);
                                                                        artificialFrame = i306 % 128;
                                                                        int i307 = i306 % 2;
                                                                    } catch (Throwable th) {
                                                                        Throwable cause = th.getCause();
                                                                        if (cause != null) {
                                                                            throw cause;
                                                                        }
                                                                        throw th;
                                                                    }
                                                                }
                                                                i162 = (i206 & 1) + (i206 | 1);
                                                                i12 = i2;
                                                                objArr20 = objArr22;
                                                                length = i200;
                                                                i15 = 1;
                                                                i18 = 0;
                                                            } catch (Throwable unused) {
                                                                r7 = i2;
                                                            }
                                                        } catch (Throwable th2) {
                                                            th = th2;
                                                            Throwable cause2 = th.getCause();
                                                            if (cause2 != null) {
                                                                throw cause2;
                                                            }
                                                            throw th;
                                                        }
                                                    } catch (Throwable th3) {
                                                        th = th3;
                                                    }
                                                } catch (Throwable th4) {
                                                    Throwable cause3 = th4.getCause();
                                                    if (cause3 != null) {
                                                        throw cause3;
                                                    }
                                                    throw th4;
                                                }
                                            } catch (Throwable th5) {
                                                Throwable cause4 = th5.getCause();
                                                if (cause4 != null) {
                                                    throw cause4;
                                                }
                                                throw th5;
                                            }
                                        }
                                        r7 = i12;
                                    } catch (Throwable th6) {
                                        Throwable cause5 = th6.getCause();
                                        if (cause5 != null) {
                                            throw cause5;
                                        }
                                        throw th6;
                                    }
                                } catch (Throwable th7) {
                                    Throwable cause6 = th7.getCause();
                                    if (cause6 != null) {
                                        throw cause6;
                                    }
                                    throw th7;
                                }
                            } catch (Throwable th8) {
                                Throwable cause7 = th8.getCause();
                                if (cause7 != null) {
                                    throw cause7;
                                }
                                throw th8;
                            }
                        } catch (Throwable th9) {
                            Throwable cause8 = th9.getCause();
                            if (cause8 != null) {
                                throw cause8;
                            }
                            throw th9;
                        }
                    } catch (Throwable th10) {
                        Throwable cause9 = th10.getCause();
                        if (cause9 != null) {
                            throw cause9;
                        }
                        throw th10;
                    }
                } catch (Throwable unused2) {
                }
            } catch (Throwable unused3) {
            }
            int i308 = getARTIFICIAL_FRAME_PACKAGE_NAME + 115;
            artificialFrame = i308 % 128;
            int i309 = i308 % 2;
            Object[] objArr33 = {new int[]{i}, new int[]{i}, new int[1], null};
            int i310 = ~(Process.myTid() | 365214906);
            int i311 = (((289414298 | i310) * (-196)) - 102765946) + ((i310 | 75800608) * 196);
            int i312 = (i311 << 1) - i311;
            int i313 = i312 * 465;
            int i314 = -(-(r7 * (-463)));
            int i315 = (i313 & i314) + (i313 | i314);
            int i316 = ~r7;
            int i317 = ~i;
            int i318 = ~((i317 & i316) | (i316 ^ i317));
            int i319 = getARTIFICIAL_FRAME_PACKAGE_NAME;
            int i320 = (i319 & 89) + (i319 | 89);
            artificialFrame = i320 % 128;
            if (i320 % 2 == 0) {
                int i321 = ~((i316 ^ i312) | (i316 & i312));
                int i322 = (i318 & i321) | (i318 ^ i321);
                int i323 = ~i;
                int i324 = ~((i323 & i312) | (i323 ^ i312));
                i3 = i315 * (464 / ((i322 & i324) | (i322 ^ i324)));
                int i325 = ~i312;
                i4 = (-464) - (((i325 & i) | (i ^ i325)) | i316);
            } else {
                int i326 = ~((i316 ^ i312) | (i316 & i312));
                int i327 = (i318 & i326) | (i318 ^ i326);
                int i328 = ~i;
                int i329 = -(-((i327 | (~((i328 & i312) | (i328 ^ i312)))) * 464));
                i3 = ((i315 | i329) << 1) - (i329 ^ i315);
                int i330 = ~i312;
                int i331 = (i330 & i) | (i ^ i330);
                int i332 = ~r7;
                i4 = ((i331 & i332) | (i331 ^ i332)) * (-464);
            }
            int i333 = (i3 & i4) + (i4 | i3);
            int i334 = ~((i316 & i312) | (i316 ^ i312));
            int i335 = ~(i | i312);
            int i336 = ((i335 & i334) | (i334 ^ i335)) * 464;
            int i337 = ((i333 | i336) << 1) - (i336 ^ i333);
            int i338 = (i337 << 13) ^ i337;
            int i339 = i338 >>> 17;
            int i340 = ((~i338) & i339) | ((~i339) & i338);
            ((int[]) objArr33[2])[0] = i340 ^ (i340 << 5);
            return objArr33;
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

    @Override // io.sentry.JsonSerializable
    public void serialize(@NotNull ObjectWriter objectWriter, @NotNull ILogger iLogger) throws IOException {
        objectWriter.beginObject();
        if (this.city != null) {
            objectWriter.name(JsonKeys.CITY).value(this.city);
        }
        if (this.countryCode != null) {
            objectWriter.name(JsonKeys.COUNTRY_CODE).value(this.countryCode);
        }
        if (this.region != null) {
            objectWriter.name(JsonKeys.REGION).value(this.region);
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
}
