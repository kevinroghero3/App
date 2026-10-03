package org.joda.time.chrono;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.appcompat.app.AppCompatDelegate;
import ch.qos.logback.core.net.SyslogConstants;
import com.facebook.imageutils.JfifUtil;
import com.google.android.gms.internal.mlkit_vision_common.zzkf;
import com.google.common.base.Ascii;
import com.salesforce.marketingcloud.analytics.stats.b;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import o.ArtificialStackFrames;
import o.ICustomTabsCallbackDefault;
import o.onPostMessage;
import org.joda.time.Chronology;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeZone;
import org.joda.time.field.DividedDateTimeField;
import org.joda.time.field.RemainderDateTimeField;

/* JADX INFO: loaded from: classes3.dex */
public final class ISOChronology extends AssembledChronology {
    private static final ISOChronology INSTANCE_UTC;
    private static final ConcurrentHashMap<DateTimeZone, ISOChronology> cCache;
    private static final long serialVersionUID = -6212696554273812441L;

    static {
        ConcurrentHashMap<DateTimeZone, ISOChronology> concurrentHashMap = new ConcurrentHashMap<>();
        cCache = concurrentHashMap;
        ISOChronology iSOChronology = new ISOChronology(GregorianChronology.getInstanceUTC());
        INSTANCE_UTC = iSOChronology;
        concurrentHashMap.put(DateTimeZone.UTC, iSOChronology);
    }

    public static ISOChronology getInstanceUTC() {
        return INSTANCE_UTC;
    }

    public static ISOChronology getInstance() {
        return getInstance(DateTimeZone.getDefault());
    }

    public static ISOChronology getInstance(DateTimeZone dateTimeZone) {
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.getDefault();
        }
        ConcurrentHashMap<DateTimeZone, ISOChronology> concurrentHashMap = cCache;
        ISOChronology iSOChronology = concurrentHashMap.get(dateTimeZone);
        if (iSOChronology != null) {
            return iSOChronology;
        }
        ISOChronology iSOChronology2 = new ISOChronology(ZonedChronology.getInstance(INSTANCE_UTC, dateTimeZone));
        ISOChronology iSOChronologyPutIfAbsent = concurrentHashMap.putIfAbsent(dateTimeZone, iSOChronology2);
        return iSOChronologyPutIfAbsent != null ? iSOChronologyPutIfAbsent : iSOChronology2;
    }

    private ISOChronology(Chronology chronology) {
        super(chronology, null);
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.Chronology
    public Chronology withUTC() {
        return INSTANCE_UTC;
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static final class Stub implements Serializable {
        private static final long serialVersionUID = -6212696554273812441L;
        private transient DateTimeZone iZone;
        private static final byte[] $$a = {4, -24, -50, 10};
        private static final int $$b = 169;
        private static int $10 = 0;
        private static int $11 = 1;
        private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        private static int artificialFrame = 1;
        private static char[] IPostMessageService = {38281, 38361, 38359, 38355, 38361, 38359, 38356, 38354, 38366, 38399, 38287, 38285, 38393, 38396, 38288, 38287, 38285, 38377, 38380, 38388, 38353, 38347, 38356, 38392, 38380, 38345, 38353, 38354, 38348, 38355, 38363, 38355, 38383, 38380, 38355, 38356, 38356, 38362, 38278, 38356, 38358, 38376, 38272, 38394, 38391, 38388, 38379, 38390, 38399, 38280, 38391, 38361, 38355, 38351, 38356, 38358, 38376, 38272, 38393, 38274, 38390, 38353, 38356, 38364, 38379, 38285, 38397, 38361, 38355, 38284, 38353, 38356, 38364, 38379, 38285, 38397, 38361, 38355, 38351, 38356, 38358, 38376, 38272, 38394, 38391, 38280, 38391, 38361, 38355, 38351, 38356, 38358, 38376, 38272, 38393, 38274, 38272, 38379, 38390, 38399, 38338, 38217, 38217, 38232, 38236, 38221, 38223, 38221, 38220, 38225, 38235, 38260, 38246, 38213, 38244, 38242, 38210, 38218, 38215, 38210, 38213, 38218, 38251, 38250, 38221, 38215, 38211, 38216, 38218, 38220, 38340, 38222, 38216, 38216, 38252, 38243, 38215, 38223, 38215, 38208, 38214, 38213, 38077, 38240, 38251, 38223, 38216, 38208, 38242, 38267, 38239, 38216, 38208, 38213, 38220, 38220, 38221, 38225, 38217, 38215, 38238, 38240, 38225, 38216, 38210, 38211, 38078, 38155, 38153, 38155, 38157, 38146, 38159, 38268, 38269, 38146, 38183, 38268, 38186, 38041, 38039, 38034, 38038, 38044, 38073, 38074, 38041, 38036, 38033, 38038, 38041, 38033, 38065, 38067, 38036, 38069, 38210, 38052, 38042, 38040, 38043, 38040, 38030, 38031, 38039, 38047, 38346, 38254, 38260, 38235, 38225, 38250, 38255, 38230, 38225, 38234, 38238, 38287, 38357, 38355, 38379, 38379, 38356, 38348, 38353, 38360, 38360, 38361, 38365, 38357, 38355, 38361, 38361, 38358, 38358, 38356, 38281, 38361, 38359, 38355, 38361, 38359, 38356, 38354, 38366, 38399, 38287, 38285, 38393, 38361, 38356, 38363, 38360, 38361, 38356, 38363, 38364, 38355, 38361};
        private static long coroutineBoundary = -899883803867009716L;
        private static int accessartificialFrame = -1151259316;
        private static char CoroutineDebuggingKt = 31812;

        /* JADX WARN: Code duplicated, block: B:10:0x0023  */
        /* JADX WARN: Code duplicated, block: B:8:0x001c  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x002b). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static java.lang.String $$c(byte r5, int r6, byte r7) {
            /*
                byte[] r0 = org.joda.time.chrono.ISOChronology.Stub.$$a
                int r7 = r7 * 2
                int r1 = r7 + 1
                int r5 = r5 + 4
                int r6 = 122 - r6
                byte[] r1 = new byte[r1]
                r2 = -1
                if (r0 != 0) goto L12
                r3 = r2
                r2 = r5
                goto L2b
            L12:
                r4 = r6
                r6 = r5
                r5 = r4
            L15:
                int r2 = r2 + 1
                byte r3 = (byte) r5
                r1[r2] = r3
                if (r2 != r7) goto L23
                java.lang.String r5 = new java.lang.String
                r6 = 0
                r5.<init>(r1, r6)
                return r5
            L23:
                int r6 = r6 + 1
                r3 = r0[r6]
                r4 = r2
                r2 = r6
                r6 = r3
                r3 = r4
            L2b:
                int r5 = r5 + r6
                r6 = r2
                r2 = r3
                goto L15
            */
            throw new UnsupportedOperationException("Method not decompiled: org.joda.time.chrono.ISOChronology.Stub.$$c(byte, int, byte):java.lang.String");
        }

        private static void b(char[] cArr, char c, int i, char[] cArr2, char[] cArr3, Object[] objArr) throws Throwable {
            int i2 = 2;
            int i3 = 2 % 2;
            ICustomTabsCallbackDefault iCustomTabsCallbackDefault = new ICustomTabsCallbackDefault();
            int length = cArr2.length;
            char[] cArr4 = new char[length];
            int length2 = cArr3.length;
            char[] cArr5 = new char[length2];
            int i4 = 0;
            System.arraycopy(cArr2, 0, cArr4, 0, length);
            System.arraycopy(cArr3, 0, cArr5, 0, length2);
            cArr4[0] = (char) (cArr4[0] ^ c);
            cArr5[2] = (char) (cArr5[2] + ((char) i));
            int length3 = cArr.length;
            char[] cArr6 = new char[length3];
            iCustomTabsCallbackDefault.a = 0;
            while (iCustomTabsCallbackDefault.a < length3) {
                int i5 = $11 + 115;
                $10 = i5 % 128;
                int i6 = i5 % i2;
                try {
                    Object[] objArr2 = {iCustomTabsCallbackDefault};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-10548171);
                    if (objAccessartificialFrame == null) {
                        int packedPositionType = 33 - ExpandableListView.getPackedPositionType(0L);
                        char mode = (char) View.MeasureSpec.getMode(i4);
                        int bitsPerPixel = ImageFormat.getBitsPerPixel(i4) + 1484;
                        byte b = (byte) (-1);
                        String str$$c = $$c(b, (byte) (b & Ascii.ETB), (byte) i4);
                        Class[] clsArr = new Class[1];
                        clsArr[i4] = Object.class;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(packedPositionType, mode, bitsPerPixel, 1614432829, false, str$$c, clsArr);
                    }
                    int iIntValue = ((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
                    Object[] objArr3 = {iCustomTabsCallbackDefault};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1818210492);
                    if (objAccessartificialFrame2 == null) {
                        int absoluteGravity = Gravity.getAbsoluteGravity(i4, i4) + 32;
                        char c2 = (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 49167);
                        int absoluteGravity2 = Gravity.getAbsoluteGravity(i4, i4) + 899;
                        byte b2 = (byte) (-1);
                        String str$$c2 = $$c(b2, (byte) (b2 & Ascii.NAK), (byte) i4);
                        Class[] clsArr2 = new Class[1];
                        clsArr2[i4] = Object.class;
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(absoluteGravity, c2, absoluteGravity2, 214239564, false, str$$c2, clsArr2);
                    }
                    int iIntValue2 = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
                    int i7 = cArr4[iCustomTabsCallbackDefault.a % 4] * 32718;
                    Object[] objArr4 = new Object[3];
                    objArr4[2] = Integer.valueOf(cArr5[iIntValue]);
                    objArr4[1] = Integer.valueOf(i7);
                    objArr4[i4] = iCustomTabsCallbackDefault;
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(1532285801);
                    if (objAccessartificialFrame3 == null) {
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(TextUtils.indexOf((CharSequence) "", '0') + 24, (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))), 2440 - MotionEvent.axisFromString(""), -1003383455, false, $$c((byte) (-1), (byte) (-$$a[1]), (byte) 0), new Class[]{Object.class, Integer.TYPE, Integer.TYPE});
                    }
                    ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                    Object[] objArr5 = {Integer.valueOf(cArr4[iIntValue2] * 32718), Integer.valueOf(cArr5[iIntValue])};
                    Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-950633141);
                    if (objAccessartificialFrame4 == null) {
                        byte b3 = (byte) (-1);
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(21 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), (char) (KeyEvent.keyCodeFromString("") + 29754), Drawable.resolveOpacity(0, 0) + 1748, 1479752515, false, $$c(b3, (byte) (b3 & Ascii.SYN), (byte) 0), new Class[]{Integer.TYPE, Integer.TYPE});
                    }
                    cArr5[iIntValue2] = ((Character) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).charValue();
                    cArr4[iIntValue2] = iCustomTabsCallbackDefault.MediaBrowserCompatApi21ConnectionCallback;
                    cArr6[iCustomTabsCallbackDefault.a] = (char) (((((long) (cArr4[iIntValue2] ^ cArr[iCustomTabsCallbackDefault.a])) ^ (coroutineBoundary ^ (-899883803867009716L))) ^ ((long) ((int) (((long) accessartificialFrame) ^ (-899883803867009716L))))) ^ ((long) ((char) (((long) CoroutineDebuggingKt) ^ (-899883803867009716L)))));
                    iCustomTabsCallbackDefault.a++;
                    length3 = length3;
                    i2 = 2;
                    i4 = 0;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            String str = new String(cArr6);
            int i8 = $10 + 1;
            $11 = i8 % 128;
            int i9 = i8 % 2;
            objArr[0] = str;
        }

        Stub(DateTimeZone dateTimeZone) {
            this.iZone = dateTimeZone;
        }

        private static void a(byte[] bArr, int[] iArr, boolean z, Object[] objArr) throws Throwable {
            int i;
            int i2;
            int i3 = 2;
            int i4 = 2 % 2;
            onPostMessage onpostmessage = new onPostMessage();
            int i5 = iArr[0];
            int i6 = 1;
            int i7 = iArr[1];
            int i8 = iArr[2];
            int i9 = iArr[3];
            char[] cArr = IPostMessageService;
            int i10 = -1;
            if (cArr != null) {
                int length = cArr.length;
                char[] cArr2 = new char[length];
                int i11 = 0;
                while (i11 < length) {
                    int i12 = $11 + 97;
                    $10 = i12 % 128;
                    int i13 = i12 % i3;
                    try {
                        Object[] objArr2 = new Object[i6];
                        objArr2[0] = Integer.valueOf(cArr[i11]);
                        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1782207618);
                        if (objAccessartificialFrame == null) {
                            byte b = (byte) i10;
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(11 - (Process.myPid() >> 22), (char) Color.red(0), 1562 - (ViewConfiguration.getJumpTapTimeout() >> 16), 178318710, false, $$c(b, (byte) (b & 57), (byte) 0), new Class[]{Integer.TYPE});
                        }
                        cArr2[i11] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                        i11++;
                        i3 = 2;
                        i6 = 1;
                        i10 = -1;
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                }
                cArr = cArr2;
            }
            char[] cArr3 = new char[i7];
            System.arraycopy(cArr, i5, cArr3, 0, i7);
            if (bArr != null) {
                char[] cArr4 = new char[i7];
                onpostmessage.a = 0;
                char c = 0;
                while (onpostmessage.a < i7) {
                    int i14 = $11 + 125;
                    $10 = i14 % 128;
                    int i15 = i14 % 2;
                    if (bArr[onpostmessage.a] == 1) {
                        int i16 = onpostmessage.a;
                        Object[] objArr3 = {Integer.valueOf(cArr3[onpostmessage.a]), Integer.valueOf(c)};
                        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1378437083);
                        if (objAccessartificialFrame2 == null) {
                            byte b2 = (byte) (-1);
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(ImageFormat.getBitsPerPixel(0) + 24, (char) TextUtils.getCapsMode("", 0, 0), (ViewConfiguration.getDoubleTapTimeout() >> 16) + 2441, -850656813, false, $$c(b2, (byte) (b2 & 54), (byte) 0), new Class[]{Integer.TYPE, Integer.TYPE});
                        }
                        cArr4[i16] = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
                    } else {
                        int i17 = onpostmessage.a;
                        Object[] objArr4 = {Integer.valueOf(cArr3[onpostmessage.a]), Integer.valueOf(c)};
                        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-314759072);
                        if (objAccessartificialFrame3 == null) {
                            byte b3 = (byte) (-1);
                            byte b4 = (byte) (b3 + 1);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(10 - ImageFormat.getBitsPerPixel(0), (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16), View.MeasureSpec.makeMeasureSpec(0, 0) + 1562, 1918398056, false, $$c(b3, b4, b4), new Class[]{Integer.TYPE, Integer.TYPE});
                        }
                        cArr4[i17] = ((Character) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).charValue();
                    }
                    c = cArr4[onpostmessage.a];
                    Object[] objArr5 = {onpostmessage, onpostmessage};
                    Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(898481158);
                    if (objAccessartificialFrame4 == null) {
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(23 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), (char) (TextUtils.getCapsMode("", 0, 0) + 29363), (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + JfifUtil.MARKER_RST7, -1427572210, false, "F", new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame4).invoke(null, objArr5);
                }
                cArr3 = cArr4;
            }
            if (i9 > 0) {
                int i18 = $11 + 35;
                $10 = i18 % 128;
                if (i18 % 2 != 0) {
                    char[] cArr5 = new char[i7];
                    System.arraycopy(cArr3, 1, cArr5, 1, i7);
                    System.arraycopy(cArr5, 1, cArr3, i7 % i9, i9);
                    System.arraycopy(cArr5, i9, cArr3, 1, i7 - i9);
                } else {
                    char[] cArr6 = new char[i7];
                    System.arraycopy(cArr3, 0, cArr6, 0, i7);
                    int i19 = i7 - i9;
                    System.arraycopy(cArr6, 0, cArr3, i19, i9);
                    System.arraycopy(cArr6, i9, cArr3, 0, i19);
                }
            }
            if (z) {
                int i20 = $10 + 61;
                $11 = i20 % 128;
                int i21 = i20 % 2;
                char[] cArr7 = new char[i7];
                onpostmessage.a = 0;
                while (onpostmessage.a < i7) {
                    int i22 = $11 + 55;
                    $10 = i22 % 128;
                    int i23 = i22 % 2;
                    cArr7[onpostmessage.a] = cArr3[(i7 - onpostmessage.a) - 1];
                    onpostmessage.a++;
                }
                int i24 = $11 + 9;
                $10 = i24 % 128;
                i = 2;
                int i25 = i24 % 2;
                cArr3 = cArr7;
            } else {
                i = 2;
            }
            if (i8 > 0) {
                int i26 = $10 + 63;
                $11 = i26 % 128;
                int i27 = i26 % i;
                onpostmessage.a = 0;
                while (onpostmessage.a < i7) {
                    int i28 = $11 + 99;
                    $10 = i28 % 128;
                    if (i28 % 2 != 0) {
                        cArr3[onpostmessage.a] = (char) (cArr3[onpostmessage.a] + iArr[3]);
                        i2 = onpostmessage.a;
                    } else {
                        cArr3[onpostmessage.a] = (char) (cArr3[onpostmessage.a] - iArr[2]);
                        i2 = onpostmessage.a + 1;
                    }
                    onpostmessage.a = i2;
                }
            }
            objArr[0] = new String(cArr3);
        }

        private Object readResolve() {
            return ISOChronology.getInstance(this.iZone);
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeObject(this.iZone);
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            this.iZone = (DateTimeZone) objectInputStream.readObject();
        }

        public static Object[] accessartificialFrame(Context context, int i, int i2) {
            Object obj;
            String str;
            char c;
            Class<?> cls;
            char[] cArr;
            int i3;
            int i4;
            int i5;
            char c2;
            int fadingEdgeLength;
            char[] cArr2;
            char[] cArr3;
            int i6;
            Object[] objArr;
            byte[] bArr;
            char c3;
            Class<?>[] clsArr;
            String str2;
            int i7;
            int i8 = 2;
            int i9 = 2 % 2;
            int i10 = artificialFrame;
            int i11 = ((i10 | 41) << 1) - (i10 ^ 41);
            int i12 = i11 % 128;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i12;
            if (i11 % 2 != 0) {
                throw null;
            }
            if (context == null) {
                int i13 = ((i12 | b.f40o) << 1) - (i12 ^ b.f40o);
                int i14 = i13 % 128;
                artificialFrame = i14;
                int i15 = i13 % 2;
                Object[] objArr2 = new Object[4];
                objArr2[0] = new int[]{i};
                objArr2[1] = new int[]{i};
                objArr2[2] = new int[1];
                int i16 = i14 + 73;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i16 % 128;
                if (i16 % 2 != 0) {
                    objArr2[5] = null;
                    int i17 = ~i;
                    i7 = (((~(i17 | 50661204)) | (~((-927962571) | i17)) | 877301898) * (-397)) + 978412570 + ((877302430 | i) * 397);
                } else {
                    objArr2[3] = null;
                    int iFreeMemory = (int) Runtime.getRuntime().freeMemory();
                    int i18 = ~iFreeMemory;
                    i7 = (((~((-170077843) | i18)) | 167903250) * 859) + (-333100804) + ((iFreeMemory | 808545932) * (-859)) + (((~(iFreeMemory | (-2174593))) | (~(808545932 | i18))) * 859);
                }
                int i19 = ((i7 * 866) - (~(-(-(i2 * (-864)))))) - 1;
                int i20 = ~i2;
                int i21 = i19 + (((~((~i7) | (~i))) | i20) * (-865));
                int i22 = (~((i7 ^ i) | (i7 & i))) * 865;
                int i23 = (i21 ^ i22) + ((i21 & i22) << 1);
                int i24 = artificialFrame;
                int i25 = (i24 & 3) + (i24 | 3);
                getARTIFICIAL_FRAME_PACKAGE_NAME = i25 % 128;
                int i26 = i25 % 2;
                int i27 = ~i;
                int i28 = 865 * ((~((i27 & i7) | (i27 ^ i7))) | (~(i20 | i27)));
                int i29 = ((i23 | i28) << 1) - (i28 ^ i23);
                int i30 = i29 << 13;
                int i31 = ((~i29) & i30) | ((~i30) & i29);
                int i32 = ((i24 | 11) << 1) - (i24 ^ 11);
                getARTIFICIAL_FRAME_PACKAGE_NAME = i32 % 128;
                int i33 = i32 % 2;
                int i34 = i31 >>> 17;
                int i35 = ((~i31) & i34) | ((~i34) & i31);
                int i36 = i35 << 5;
                ((int[]) objArr2[2])[0] = ((~i35) & i36) | ((~i36) & i35);
                return objArr2;
            }
            try {
                Object[] objArr3 = new Object[1];
                a(new byte[]{0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1}, new int[]{0, 38, 0, 0}, true, objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                int i37 = artificialFrame + 7;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i37 % 128;
                Object[] objArr4 = i37 % 2 != 0 ? (Object[]) Array.newInstance(cls2, 2) : (Object[]) Array.newInstance(cls2, 2);
                byte[] bArr2 = {0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 0};
                int i38 = getARTIFICIAL_FRAME_PACKAGE_NAME + 95;
                artificialFrame = i38 % 128;
                if (i38 % 2 == 0) {
                    Object[] objArr5 = new Object[1];
                    a(bArr2, new int[]{38, 31, 0, 7}, true, objArr5);
                    obj = objArr5[0];
                } else {
                    Object[] objArr6 = new Object[1];
                    a(bArr2, new int[]{38, 31, 0, 7}, true, objArr6);
                    obj = objArr6[0];
                }
                String str3 = (String) obj;
                int i39 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                int i40 = (i39 & 89) + (i39 | 89);
                artificialFrame = i40 % 128;
                int i41 = i40 % 2;
                try {
                    Object[] objArr7 = {str3};
                    byte[] bArr3 = {0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1};
                    int[] iArr = {0, 38, 0, 0};
                    zzkf.postMessage();
                    zzkf.postMessage();
                    Object[] objArr8 = new Object[1];
                    a(bArr3, iArr, true, objArr8);
                    Class<?> cls3 = Class.forName((String) objArr8[0]);
                    Class<?>[] clsArr2 = new Class[1];
                    int i42 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                    int i43 = ((i42 | 43) << 1) - (i42 ^ 43);
                    artificialFrame = i43 % 128;
                    int i44 = i43 % 2;
                    clsArr2[0] = String.class;
                    Object objNewInstance = cls3.getDeclaredConstructor(clsArr2).newInstance(objArr7);
                    int i45 = artificialFrame + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i45 % 128;
                    if (i45 % 2 != 0) {
                        objArr4[0] = objNewInstance;
                        Object[] objArr9 = new Object[1];
                        a(new byte[]{1, 0, 1, 1, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0}, new int[]{69, 31, 0, 31}, true, objArr9);
                        str = (String) objArr9[0];
                        c = 0;
                    } else {
                        objArr4[0] = objNewInstance;
                        Object[] objArr10 = new Object[1];
                        a(new byte[]{1, 0, 1, 1, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0}, new int[]{69, 31, 0, 31}, true, objArr10);
                        str = (String) objArr10[0];
                        c = 1;
                    }
                    try {
                        Object[] objArr11 = new Object[1];
                        a(new byte[]{0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1}, new int[]{0, 38, 0, 0}, true, objArr11);
                        objArr4[c] = Class.forName((String) objArr11[0]).getDeclaredConstructor(String.class).newInstance(str);
                        int i46 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                        int i47 = ((i46 | 79) << 1) - (i46 ^ 79);
                        artificialFrame = i47 % 128;
                        int i48 = i47 % 2;
                        try {
                            Object[] objArr12 = new Object[1];
                            b(new char[]{12004, 6751, 4098, 21952, 44995, 51642, 27386, 45796, 41614, 43252, 4935, 9652, 65269, 24883, 46762, 32216, 12447, 54011, 13725, 55377, 62175, 31563, 27162}, (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 2052935789, new char[]{28221, 23888, 5242, 44233}, new char[]{0, 0, 0, 0}, objArr12);
                            Class<?> cls4 = Class.forName((String) objArr12[0]);
                            char gidForName = (char) (23981 - Process.getGidForName(""));
                            int i49 = -(SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                            Object[] objArr13 = new Object[1];
                            b(new char[]{5075, 45255, 54221, 31510, 58862, 2709, 5103, 34920, 6687, 11628, 59732, 55915, 41834, 24405, 3461, 57097, 54707}, gidForName, ((i49 | 1747155238) << 1) - (i49 ^ 1747155238), new char[]{9634, 9081, 44648, 31581}, new char[]{0, 0, 0, 0}, objArr13);
                            Object objInvoke = cls4.getMethod((String) objArr13[0], null).invoke(context, null);
                            int i50 = getARTIFICIAL_FRAME_PACKAGE_NAME + 39;
                            artificialFrame = i50 % 128;
                            int i51 = i50 % 2;
                            try {
                                int i52 = (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
                                int i53 = -Color.red(0);
                                int iPostMessage = zzkf.postMessage();
                                int i54 = i53 * (-300);
                                int i55 = (i54 ^ 1511317956) + ((i54 & 1511317956) << 1);
                                int i56 = -(-((~(2052935790 | i53 | iPostMessage)) * (-301)));
                                int i57 = (i55 ^ i56) + ((i55 & i56) << 1);
                                int i58 = ~(((-2052935791) ^ iPostMessage) | ((-2052935791) & iPostMessage));
                                int i59 = ~iPostMessage;
                                int i60 = -(-(((~((i59 ^ i53) | (i59 & i53))) | i58) * (-301)));
                                int i61 = (i57 ^ i60) + ((i57 & i60) << 1);
                                int i62 = ~i53;
                                int i63 = ~((i62 & iPostMessage) | (i62 ^ iPostMessage));
                                int i64 = ((i63 & (-2052935791)) | ((-2052935791) ^ i63)) * 301;
                                Object[] objArr14 = new Object[1];
                                b(new char[]{12004, 6751, 4098, 21952, 44995, 51642, 27386, 45796, 41614, 43252, 4935, 9652, 65269, 24883, 46762, 32216, 12447, 54011, 13725, 55377, 62175, 31563, 27162}, (char) ((i52 ^ (-1)) + (i52 << 1)), (i61 ^ i64) + ((i64 & i61) << 1), new char[]{28221, 23888, 5242, 44233}, new char[]{0, 0, 0, 0}, objArr14);
                                Class<?> cls5 = Class.forName((String) objArr14[0]);
                                int i65 = -TextUtils.getOffsetAfter("", 0);
                                int iPostMessage2 = zzkf.postMessage();
                                int i66 = i65 * (-919);
                                int i67 = (i66 & (-52602641)) + (i66 | (-52602641));
                                int i68 = ~i65;
                                int i69 = (i68 ^ (-57240)) | (i68 & (-57240));
                                int i70 = ~(i69 | iPostMessage2);
                                int i71 = ~iPostMessage2;
                                int i72 = ((-57240) ^ i71) | ((-57240) & i71);
                                int i73 = ~((i72 ^ i65) | (i72 & i65));
                                int i74 = i67 + (((i70 ^ i73) | (i73 & i70)) * 920);
                                int i75 = ~i65;
                                int i76 = ~((i75 & (-57240)) | (i75 ^ (-57240)));
                                int i77 = ~(i68 | i71);
                                int i78 = -(-(((i76 & i77) | (i76 ^ i77)) * 920));
                                int i79 = ((i74 | i78) << 1) - (i74 ^ i78);
                                int i80 = ~iPostMessage2;
                                int i81 = ~((i69 & i80) | (i69 ^ i80));
                                int i82 = 57239 | i68;
                                int i83 = ~((i82 & iPostMessage2) | (i82 ^ iPostMessage2));
                                int i84 = (i81 & i83) | (i81 ^ i83);
                                int i85 = (i65 & (-57240)) | ((-57240) ^ i65);
                                int i86 = ~((i85 & iPostMessage2) | (i85 ^ iPostMessage2));
                                int i87 = ((i84 & i86) | (i84 ^ i86)) * 920;
                                Object[] objArr15 = new Object[1];
                                b(new char[]{22789, 60500, 2620, 53992, 25681, 3626, 46774, 45638, 2037, 38873, 37005, 58764, 21533, 25403}, (char) ((i79 & i87) + (i87 | i79)), Color.argb(0, 0, 0, 0), new char[]{41246, 18559, 38911, 33759}, new char[]{0, 0, 0, 0}, objArr15);
                                try {
                                    Object[] objArr16 = {cls5.getMethod((String) objArr15[0], null).invoke(context, null), 64};
                                    char cMyPid = (char) (Process.myPid() >> 22);
                                    int i88 = -(-(ViewConfiguration.getMaximumDrawingCacheSize() >> 24));
                                    Object[] objArr17 = new Object[1];
                                    b(new char[]{62202, 57758, 26446, 26735, 29023, 35693, 40915, 45325, 41577, 50329, 50489, 15193, 15965, 6577, 5594, 39699, 52773, 41022, 56272, 33010, 26821, 8591, 48276, 20474, 50671, 51255, 40876, 61081, 14681, 38532, 32493, 61028, 26147}, cMyPid, (i88 ^ (-525039661)) + ((i88 & (-525039661)) << 1), new char[]{54138, 46215, 45280, 12928}, new char[]{0, 0, 0, 0}, objArr17);
                                    String str4 = (String) objArr17[0];
                                    int i89 = artificialFrame;
                                    int i90 = (i89 & 47) + (i89 | 47);
                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i90 % 128;
                                    if (i90 % 2 != 0) {
                                        cls = Class.forName(str4);
                                        cArr = new char[]{4190, 5767, 32349, 27268, 6446, 53962, 49586, 52439, 31560, 62178, 36890, 61663, 32532, 24746};
                                        int scrollBarSize = ViewConfiguration.getScrollBarSize();
                                        i3 = -(((scrollBarSize | 48) << 1) - (scrollBarSize ^ 48));
                                        i4 = (50 << i3) / (-2738892);
                                        i5 = 28236;
                                    } else {
                                        cls = Class.forName(str4);
                                        cArr = new char[]{4190, 5767, 32349, 27268, 6446, 53962, 49586, 52439, 31560, 62178, 36890, 61663, 32532, 24746};
                                        i3 = -(ViewConfiguration.getScrollBarSize() >> 8);
                                        int i91 = i3 * 50;
                                        i4 = ((i91 & (-878432)) << 1) + (i91 ^ (-878432));
                                        i5 = 9056;
                                    }
                                    char[] cArr4 = cArr;
                                    int i92 = ~i5;
                                    int i93 = ~i;
                                    int i94 = ~((i92 ^ i93) | (i92 & i93));
                                    int i95 = ~i5;
                                    int i96 = ~((i95 ^ i3) | (i95 & i3));
                                    int i97 = (i4 - (~(-(-(98 * ((i94 ^ i96) | (i96 & i94))))))) - 1;
                                    int i98 = ~i3;
                                    int i99 = ~i;
                                    int i100 = ~(i98 | i99);
                                    int i101 = (i95 ^ i100) | (i95 & i100);
                                    int i102 = artificialFrame;
                                    int i103 = (i102 ^ 79) + ((i102 & 79) << 1);
                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i103 % 128;
                                    if (i103 % 2 != 0) {
                                        int i104 = (i97 - (~(-((-49) - ((~(i3 | i)) | i101))))) - 1;
                                        int i105 = ~((i92 ^ i) | (i92 & i));
                                        int i106 = ~(i3 | i5);
                                        c2 = (char) (i104 >>> (49 >> ((i105 & i106) | (i105 ^ i106))));
                                        fadingEdgeLength = ViewConfiguration.getFadingEdgeLength() >> 29;
                                        cArr2 = new char[]{48907, 44551, 24653, 56611};
                                        cArr3 = new char[4];
                                    } else {
                                        int i107 = ~((i3 ^ i) | (i3 & i));
                                        int i108 = (i97 - (~(-(-(((i107 & i101) | (i101 ^ i107)) * (-49)))))) - 1;
                                        int i109 = ~((i92 ^ i) | (i92 & i));
                                        int i110 = ~(i3 | i5);
                                        int i111 = ((i109 & i110) | (i109 ^ i110)) * 49;
                                        c2 = (char) ((i108 & i111) + (i111 | i108));
                                        fadingEdgeLength = ViewConfiguration.getFadingEdgeLength() >> 16;
                                        cArr2 = new char[]{48907, 44551, 24653, 56611};
                                        cArr3 = new char[4];
                                    }
                                    // fill-array-data instruction
                                    cArr3[0] = 0;
                                    cArr3[1] = 0;
                                    cArr3[2] = 0;
                                    cArr3[3] = 0;
                                    int i112 = fadingEdgeLength;
                                    Object[] objArr18 = new Object[1];
                                    b(cArr4, c2, i112, cArr2, cArr3, objArr18);
                                    Object objInvoke2 = cls.getMethod((String) objArr18[0], String.class, Integer.TYPE).invoke(objInvoke, objArr16);
                                    Object[] objArr19 = new Object[1];
                                    a(new byte[]{1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1}, new int[]{100, 30, 140, 0}, true, objArr19);
                                    Class<?> cls6 = Class.forName((String) objArr19[0]);
                                    char packedPositionType = (char) ExpandableListView.getPackedPositionType(0L);
                                    int i113 = (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                                    int i114 = i113 * 960;
                                    int i115 = (i114 & 1917) + (i114 | 1917);
                                    int i116 = ((~i99) | (~((i113 ^ i) | (i113 & i)))) * 959;
                                    int i117 = ((i115 | i116) << 1) - (i116 ^ i115);
                                    int i118 = ~i;
                                    int i119 = ~((i113 & i93) | (i93 ^ i113));
                                    Object[] objArr20 = new Object[1];
                                    b(new char[]{28005, 25513, 10731, 57539, 1255, 33049, 28333, 57438, 56429, 33418}, packedPositionType, (i117 - (~(((i119 & i118) | (i118 ^ i119)) * 959))) - 1, new char[]{23520, 41787, 20135, 34261}, new char[]{0, 0, 0, 0}, objArr20);
                                    Object[] objArr21 = (Object[]) cls6.getField((String) objArr20[0]).get(objInvoke2);
                                    int length = objArr21.length;
                                    int i120 = artificialFrame;
                                    int i121 = ((i120 | 23) << 1) - (i120 ^ 23);
                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i121 % 128;
                                    if (i121 % 2 != 0) {
                                        i6 = 5;
                                        int i122 = 4 % 5;
                                    } else {
                                        i6 = 5;
                                    }
                                    int i123 = 0;
                                    while (i123 < length) {
                                        Object obj2 = objArr21[i123];
                                        char[] cArr5 = new char[i6];
                                        // fill-array-data instruction
                                        cArr5[0] = 28666;
                                        cArr5[1] = 29564;
                                        cArr5[2] = 17823;
                                        cArr5[3] = 26395;
                                        cArr5[4] = 61817;
                                        int defaultSize = View.getDefaultSize(0, 0);
                                        int i124 = defaultSize * 51;
                                        int i125 = artificialFrame;
                                        int i126 = (i125 ^ 25) + ((i125 & 25) << 1);
                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i126 % 128;
                                        int i127 = i126 % i8;
                                        int i128 = (((i124 | (-232505)) << 1) - ((-232505) ^ i124)) + (((defaultSize ^ i) | (defaultSize & i)) * (-50));
                                        int i129 = i125 + 87;
                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i129 % 128;
                                        if (i129 % i8 != 0) {
                                            Object obj3 = null;
                                            obj3.hashCode();
                                            throw null;
                                        }
                                        int i130 = ~defaultSize;
                                        int i131 = (i130 & (-4746)) | (i130 ^ (-4746));
                                        int i132 = ((-4746) ^ i93) | ((-4746) & i93);
                                        int i133 = ((~((i131 & i) | (i131 ^ i))) | (~((i132 ^ defaultSize) | (i132 & defaultSize)))) * 50;
                                        int i134 = ((i128 | i133) << 1) - (i133 ^ i128);
                                        int i135 = ~(((-4746) ^ i93) | ((-4746) & i93));
                                        int i136 = ~(((-4746) & defaultSize) | ((-4746) ^ defaultSize));
                                        int i137 = (i135 & i136) | (i135 ^ i136);
                                        int i138 = ~((defaultSize & i93) | (i93 ^ defaultSize));
                                        int i139 = ((i137 & i138) | (i137 ^ i138)) * 50;
                                        char c4 = (char) ((i134 ^ i139) + ((i139 & i134) << 1));
                                        int i140 = -(ViewConfiguration.getEdgeSlop() >> 16);
                                        Object[] objArr22 = new Object[1];
                                        b(cArr5, c4, (i140 ^ (-1582801552)) + ((i140 & (-1582801552)) << 1), new char[]{28779, 43101, 35233, 24850}, new char[]{0, 0, 0, 0}, objArr22);
                                        String str5 = (String) objArr22[0];
                                        int i141 = artificialFrame;
                                        int i142 = ((i141 | AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY) << 1) - (i141 ^ AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY);
                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i142 % 128;
                                        if (i142 % i8 != 0) {
                                            try {
                                                objArr = new Object[1];
                                                objArr[1] = str5;
                                                bArr = new byte[37];
                                            } catch (Throwable th) {
                                                Throwable cause = th.getCause();
                                                if (cause != null) {
                                                    throw cause;
                                                }
                                                throw th;
                                            }
                                        } else {
                                            objArr = new Object[]{str5};
                                            bArr = new byte[37];
                                        }
                                        // fill-array-data instruction
                                        bArr[0] = 0;
                                        bArr[1] = 1;
                                        bArr[2] = 1;
                                        bArr[3] = 1;
                                        bArr[4] = 1;
                                        bArr[5] = 1;
                                        bArr[6] = 0;
                                        bArr[7] = 0;
                                        bArr[8] = 0;
                                        bArr[9] = 1;
                                        bArr[10] = 1;
                                        bArr[11] = 1;
                                        bArr[12] = 1;
                                        bArr[13] = 1;
                                        bArr[14] = 1;
                                        bArr[15] = 0;
                                        bArr[16] = 1;
                                        bArr[17] = 0;
                                        bArr[18] = 0;
                                        bArr[19] = 1;
                                        bArr[20] = 0;
                                        bArr[21] = 1;
                                        bArr[22] = 0;
                                        bArr[23] = 1;
                                        bArr[24] = 1;
                                        bArr[25] = 1;
                                        bArr[26] = 0;
                                        bArr[27] = 0;
                                        bArr[28] = 1;
                                        bArr[29] = 1;
                                        bArr[30] = 1;
                                        bArr[31] = 1;
                                        bArr[32] = 0;
                                        bArr[33] = 1;
                                        bArr[34] = 1;
                                        bArr[35] = 1;
                                        bArr[36] = 1;
                                        Object[] objArr23 = new Object[1];
                                        a(bArr, new int[]{130, 37, 140, 0}, false, objArr23);
                                        Class<?> cls7 = Class.forName((String) objArr23[0]);
                                        int i143 = artificialFrame;
                                        int i144 = (i143 & 33) + (i143 | 33);
                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i144 % 128;
                                        if (i144 % i8 != 0) {
                                            Object[] objArr24 = new Object[1];
                                            a(null, new int[]{167, 11, 79, i8}, false, objArr24);
                                            str2 = (String) objArr24[0];
                                            clsArr = new Class[1];
                                            c3 = 0;
                                        } else {
                                            Object[] objArr25 = new Object[1];
                                            a(null, new int[]{167, 11, 79, 2}, true, objArr25);
                                            c3 = 0;
                                            clsArr = new Class[1];
                                            str2 = (String) objArr25[0];
                                        }
                                        clsArr[c3] = String.class;
                                        Object objInvoke3 = cls7.getMethod(str2, clsArr).invoke(null, objArr);
                                        try {
                                            Object[] objArr26 = new Object[1];
                                            a(new byte[]{1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0}, new int[]{178, 28, 189, 27}, false, objArr26);
                                            Class<?> cls8 = Class.forName((String) objArr26[0]);
                                            Object[] objArr27 = objArr21;
                                            Object[] objArr28 = new Object[1];
                                            a(new byte[]{0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1}, new int[]{206, 11, SyslogConstants.LOG_CLOCK, 8}, true, objArr28);
                                            try {
                                                Object[] objArr29 = {new ByteArrayInputStream((byte[]) cls8.getMethod((String) objArr28[0], null).invoke(obj2, null))};
                                                Object[] objArr30 = new Object[1];
                                                a(new byte[]{0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1}, new int[]{130, 37, 140, 0}, false, objArr30);
                                                Class<?> cls9 = Class.forName((String) objArr30[0]);
                                                byte[] bArr4 = {1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1};
                                                int[] iArr2 = {JfifUtil.MARKER_EOI, 19, 0, 14};
                                                int i145 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                int i146 = ((i145 | b.f40o) << 1) - (i145 ^ b.f40o);
                                                artificialFrame = i146 % 128;
                                                int i147 = i146 % 2;
                                                Object[] objArr31 = new Object[1];
                                                a(bArr4, iArr2, false, objArr31);
                                                String str6 = (String) objArr31[0];
                                                Class<?>[] clsArr3 = {InputStream.class};
                                                int i148 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                int i149 = (i148 & 23) + (i148 | 23);
                                                artificialFrame = i149 % 128;
                                                int i150 = i149 % 2;
                                                Object objInvoke4 = cls9.getMethod(str6, clsArr3).invoke(objInvoke3, objArr29);
                                                int length2 = objArr4.length;
                                                int i151 = 0;
                                                for (int i152 = 2; i151 < i152; i152 = 2) {
                                                    Object obj4 = objArr4[i151];
                                                    try {
                                                        char fadingEdgeLength2 = (char) (ViewConfiguration.getFadingEdgeLength() >> 16);
                                                        int i153 = -(AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                                                        int i154 = 1057 - (~(i153 * 530));
                                                        int i155 = ((i154 | 530) << 1) - (i154 ^ 530);
                                                        int i156 = ~(i99 | i153);
                                                        int i157 = ~((i153 ^ 1) | (i153 & 1));
                                                        int i158 = (i155 - (~(-(-(((i156 ^ i157) | (i156 & i157)) * 529))))) - 1;
                                                        int i159 = -(-(((~(i153 | i)) | (-2)) * 529));
                                                        Object[] objArr32 = new Object[1];
                                                        b(new char[]{56060, 58935, 14543, 11412, 51870, 1181, 11882, 18937, 62369, 27825, 15299, 37053, 51206, 58304, 30345, 23025, 39013, 50975, 65026, 57619, 8503, 55272, 58572, 64544, 6080, 54810, 27520, 24891, 30724, 60130, 47951, 18946, 1878, 40932}, fadingEdgeLength2, (i158 & i159) + (i159 | i158), new char[]{41644, 64172, 8479, 24521}, new char[]{0, 0, 0, 0}, objArr32);
                                                        Class<?> cls10 = Class.forName((String) objArr32[0]);
                                                        Object[] objArr33 = new Object[1];
                                                        a(new byte[]{0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0}, new int[]{236, 23, 0, 0}, true, objArr33);
                                                        if (obj4.equals(cls10.getMethod((String) objArr33[0], null).invoke(objInvoke4, null))) {
                                                            int i160 = (~(i & 1)) & (i | 1);
                                                            Object[] objArr34 = new Object[4];
                                                            int[] iArr3 = new int[1];
                                                            objArr34[0] = iArr3;
                                                            int[] iArr4 = new int[1];
                                                            objArr34[1] = iArr4;
                                                            int i161 = artificialFrame;
                                                            int i162 = (i161 ^ 49) + ((i161 & 49) << 1);
                                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i162 % 128;
                                                            int i163 = i162 % 2;
                                                            objArr34[2] = new int[1];
                                                            iArr3[0] = i;
                                                            iArr4[0] = i160;
                                                            int i164 = i161 + 85;
                                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i164 % 128;
                                                            int i165 = i164 % 2;
                                                            objArr34[3] = null;
                                                            int iMyTid = Process.myTid();
                                                            int i166 = ~iMyTid;
                                                            int i167 = (-120974004) + (((~((-231894314) | i166)) | 746729461) * 519) + (((~(i166 | (-22036489))) | (~(768765949 | iMyTid))) * (-519)) + (((~(iMyTid | 746729461)) | 231894313) * 519);
                                                            int i168 = i167 * (-463);
                                                            int i169 = ((7440 | i168) << 1) - (i168 ^ 7440);
                                                            int i170 = ~i167;
                                                            int i171 = ~((i170 & i93) | (i170 ^ i93));
                                                            int i172 = ~i167;
                                                            int i173 = ~(i172 | 16);
                                                            int i174 = (i171 & i173) | (i171 ^ i173);
                                                            int i175 = ~((i99 ^ 16) | (i99 & 16));
                                                            int i176 = i169 + (((i174 & i175) | (i174 ^ i175)) * 464);
                                                            int i177 = (i ^ (-17)) | (i & (-17));
                                                            int i178 = ((i177 & i172) | (i177 ^ i172)) * (-464);
                                                            int i179 = (i176 & i178) + (i178 | i176);
                                                            int i180 = ~((i172 ^ 16) | (i172 & 16));
                                                            int i181 = ~((i ^ 16) | (i & 16));
                                                            int i182 = -(-(((i180 & i181) | (i180 ^ i181)) * 464));
                                                            int i183 = i2 + (((i179 | i182) << 1) - (i182 ^ i179));
                                                            int i184 = i183 << 13;
                                                            int i185 = (i183 | i184) & (~(i183 & i184));
                                                            int i186 = i185 >>> 17;
                                                            int i187 = (i185 | i186) & (~(i185 & i186));
                                                            int i188 = i187 << 5;
                                                            ((int[]) objArr34[2])[0] = (i187 | i188) & (~(i187 & i188));
                                                            return objArr34;
                                                        }
                                                        i151++;
                                                    } catch (Throwable th2) {
                                                        Throwable cause2 = th2.getCause();
                                                        if (cause2 != null) {
                                                            throw cause2;
                                                        }
                                                        throw th2;
                                                    }
                                                }
                                                i123++;
                                                objArr21 = objArr27;
                                                i8 = 2;
                                                i6 = 5;
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
            int[] iArr5 = new int[1];
            Object[] objArr35 = {new int[]{i}, new int[]{i}, iArr5, null};
            int i189 = ~((-629995993) | i);
            int i190 = 1715467510 + ((554195096 | i189) * (-280)) + ((i189 | (~((-348627783) | i))) * 140);
            int i191 = ~((-75800897) | i);
            int i192 = ~i;
            int i193 = i190 + ((i191 | (~((-554195097) | i192)) | (~((-272826887) | i192))) * 140);
            int i194 = i193 * (-756);
            int i195 = -(-(i192 * (-757)));
            int i196 = (i194 & i195) + (i194 | i195);
            int i197 = ~i193;
            int i198 = (i196 - (~((~((i197 ^ i) | (i197 & i))) * 1514))) - 1;
            int i199 = ~(i197 | ((-1) ^ i197));
            int i200 = ~i193;
            int i201 = artificialFrame;
            int i202 = (i201 ^ 7) + ((i201 & 7) << 1);
            getARTIFICIAL_FRAME_PACKAGE_NAME = i202 % 128;
            int i203 = i202 % 2;
            int i204 = ~i;
            int i205 = i199 | (~((i204 & i200) | (i200 ^ i204)));
            int i206 = ~((i & i193) | (i193 ^ i));
            int i207 = (i2 - (~(-(-((i198 - (~(-(-(757 * ((i206 & i205) | (i205 ^ i206))))))) - 1))))) - 1;
            int i208 = i207 << 13;
            int i209 = (i208 & (~i207)) | ((~i208) & i207);
            int i210 = i209 >>> 17;
            int i211 = (i209 | i210) & (~(i209 & i210));
            int i212 = i211 << 5;
            iArr5[0] = (i211 | i212) & (~(i211 & i212));
            return objArr35;
        }
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.Chronology
    public Chronology withZone(DateTimeZone dateTimeZone) {
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.getDefault();
        }
        return dateTimeZone == getZone() ? this : getInstance(dateTimeZone);
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.Chronology
    public String toString() {
        DateTimeZone zone = getZone();
        if (zone == null) {
            return "ISOChronology";
        }
        return "ISOChronology[" + zone.getID() + ']';
    }

    @Override // org.joda.time.chrono.AssembledChronology
    protected void assemble(AssembledChronology.Fields fields) {
        if (getBase().getZone() == DateTimeZone.UTC) {
            DividedDateTimeField dividedDateTimeField = new DividedDateTimeField(ISOYearOfEraDateTimeField.INSTANCE, DateTimeFieldType.centuryOfEra(), 100);
            fields.centuryOfEra = dividedDateTimeField;
            fields.centuries = dividedDateTimeField.getDurationField();
            fields.yearOfCentury = new RemainderDateTimeField((DividedDateTimeField) fields.centuryOfEra, DateTimeFieldType.yearOfCentury());
            fields.weekyearOfCentury = new RemainderDateTimeField((DividedDateTimeField) fields.centuryOfEra, fields.weekyears, DateTimeFieldType.weekyearOfCentury());
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ISOChronology) {
            return getZone().equals(((ISOChronology) obj).getZone());
        }
        return false;
    }

    public int hashCode() {
        return getZone().hashCode() + 800855;
    }

    private Object writeReplace() {
        return new Stub(getZone());
    }
}
