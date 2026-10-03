package app.notifee.core;

import android.graphics.Color;
import android.graphics.ImageFormat;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import app.notifee.core.event.LogEvent;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import n.o.t.i.f.e.e.f;
import o.ArtificialStackFrames;
import o.ICustomTabsCallbackDefault;

/* JADX INFO: loaded from: classes2.dex */
public class Logger {
    private static final byte[] $$c = {6, Ascii.FS, 8, -86};
    private static final int $$d = 74;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$a = {110, Ascii.GS, -86, 74, -11, -2, Ascii.FF};
    private static final int $$b = 38;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static long coroutineBoundary = -899883803867009716L;
    private static int accessartificialFrame = -1151259316;
    private static char CoroutineDebuggingKt = 47889;

    /* JADX WARN: Code duplicated, block: B:10:0x001f  */
    /* JADX WARN: Code duplicated, block: B:8:0x0019  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x001f -> B:11:0x0025). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x001f
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$e(int r5, byte r6, short r7) {
        /*
            int r5 = r5 * 4
            int r0 = r5 + 1
            int r6 = r6 + 98
            byte[] r1 = app.notifee.core.Logger.$$c
            int r7 = r7 + 4
            byte[] r0 = new byte[r0]
            r2 = 0
            if (r1 != 0) goto L13
            r4 = r6
            r3 = r2
            r6 = r5
            goto L25
        L13:
            r3 = r2
        L14:
            byte r4 = (byte) r6
            r0[r3] = r4
            if (r3 != r5) goto L1f
            java.lang.String r5 = new java.lang.String
            r5.<init>(r0, r2)
            return r5
        L1f:
            int r7 = r7 + 1
            r4 = r1[r7]
            int r3 = r3 + 1
        L25:
            int r6 = r6 + r4
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: app.notifee.core.Logger.$$e(int, byte, short):java.lang.String");
    }

    public static String a(String str, String str2) {
        return "(" + str + "): " + str2;
    }

    private static void c(short s, int i, int i2, Object[] objArr) {
        byte[] bArr = $$a;
        int i3 = 109 - (s * 3);
        int i4 = (i * 4) + 4;
        int i5 = i2 * 3;
        byte[] bArr2 = new byte[i5 + 4];
        int i6 = i5 + 3;
        int i7 = -1;
        if (bArr == null) {
            i4++;
            i3 = (i4 + (-i6)) - 3;
        }
        while (true) {
            i7++;
            bArr2[i7] = (byte) i3;
            if (i7 == i6) {
                objArr[0] = new String(bArr2, 0);
                return;
            } else {
                int i8 = bArr[i4];
                i4++;
                i3 = (i3 + (-i8)) - 3;
            }
        }
    }

    public static void d(@NonNull String str, String str2) {
        Log.d("NOTIFEE", a(str, str2));
    }

    public static void e(@NonNull String str, String str2, Exception exc) {
        Log.e("NOTIFEE", a(str, str2), exc);
        f.a(new LogEvent("error", str, str2, exc));
    }

    public static void i(@NonNull String str, String str2) {
        Log.i("NOTIFEE", a(str, str2));
    }

    public static void v(@NonNull String str, String str2) {
        Log.v("NOTIFEE", a(str, str2));
    }

    public static void w(@NonNull String str, String str2) {
        Log.w("NOTIFEE", a(str, str2));
    }

    public static void e(@NonNull String str, String str2) {
        Log.e("NOTIFEE", a(str, str2));
        f.a(new LogEvent("error", str, str2));
    }

    public static void e(@NonNull String str, String str2, Throwable th) {
        Log.e("NOTIFEE", a(str, str2), th);
        f.a(new LogEvent("error", str, str2, th));
    }

    private static void b(char[] cArr, int i, char[] cArr2, char c, char[] cArr3, Object[] objArr) throws Throwable {
        int i2;
        int i3 = 2;
        int i4 = 2 % 2;
        ICustomTabsCallbackDefault iCustomTabsCallbackDefault = new ICustomTabsCallbackDefault();
        int length = cArr2.length;
        char[] cArr4 = new char[length];
        int length2 = cArr.length;
        char[] cArr5 = new char[length2];
        int i5 = 0;
        System.arraycopy(cArr2, 0, cArr4, 0, length);
        System.arraycopy(cArr, 0, cArr5, 0, length2);
        cArr4[0] = (char) (cArr4[0] ^ c);
        cArr5[2] = (char) (cArr5[2] + ((char) i));
        int length3 = cArr3.length;
        char[] cArr6 = new char[length3];
        iCustomTabsCallbackDefault.a = 0;
        int i6 = $10 + 83;
        $11 = i6 % 128;
        int i7 = i6 % 2;
        while (iCustomTabsCallbackDefault.a < length3) {
            int i8 = $11 + 49;
            $10 = i8 % 128;
            int i9 = i8 % i3;
            try {
                Object[] objArr2 = {iCustomTabsCallbackDefault};
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-10548171);
                if (objAccessartificialFrame == null) {
                    int iRgb = (-16777183) - Color.rgb(i5, i5, i5);
                    char maxKeyCode = (char) (KeyEvent.getMaxKeyCode() >> 16);
                    int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i5, i5) + 1483;
                    byte b = (byte) i5;
                    byte b2 = (byte) (b + 1);
                    String str$$e = $$e(b, b2, (byte) (-b2));
                    Class[] clsArr = new Class[1];
                    clsArr[i5] = Object.class;
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(iRgb, maxKeyCode, iMakeMeasureSpec, 1614432829, false, str$$e, clsArr);
                }
                int iIntValue = ((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
                Object[] objArr3 = {iCustomTabsCallbackDefault};
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1818210492);
                if (objAccessartificialFrame2 == null) {
                    int bitsPerPixel = ImageFormat.getBitsPerPixel(i5) + 33;
                    char cAxisFromString = (char) (49167 - MotionEvent.axisFromString(""));
                    int longPressTimeout = 899 - (ViewConfiguration.getLongPressTimeout() >> 16);
                    byte b3 = (byte) i5;
                    byte b4 = (byte) (b3 + 3);
                    String str$$e2 = $$e(b3, b4, (byte) (b4 - 4));
                    Class[] clsArr2 = new Class[1];
                    clsArr2[i5] = Object.class;
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(bitsPerPixel, cAxisFromString, longPressTimeout, 214239564, false, str$$e2, clsArr2);
                }
                int iIntValue2 = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
                int i10 = cArr4[iCustomTabsCallbackDefault.a % 4] * 32718;
                Object[] objArr4 = new Object[3];
                objArr4[2] = Integer.valueOf(cArr5[iIntValue]);
                objArr4[1] = Integer.valueOf(i10);
                objArr4[i5] = iCustomTabsCallbackDefault;
                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(1532285801);
                if (objAccessartificialFrame3 == null) {
                    byte b5 = (byte) i5;
                    byte b6 = b5;
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 22, (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) - 1), TextUtils.indexOf("", "") + 2441, -1003383455, false, $$e(b5, b6, (byte) (b6 - 1)), new Class[]{Object.class, Integer.TYPE, Integer.TYPE});
                }
                ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                Object[] objArr5 = {Integer.valueOf(cArr4[iIntValue2] * 32718), Integer.valueOf(cArr5[iIntValue])};
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-950633141);
                if (objAccessartificialFrame4 == null) {
                    int iIndexOf = 19 - TextUtils.indexOf((CharSequence) "", '0', 0, 0);
                    char cCombineMeasuredStates = (char) (29754 - View.combineMeasuredStates(0, 0));
                    int doubleTapTimeout = (ViewConfiguration.getDoubleTapTimeout() >> 16) + 1748;
                    byte b7 = (byte) 0;
                    byte b8 = (byte) (b7 + 2);
                    String str$$e3 = $$e(b7, b8, (byte) (b8 - 3));
                    i2 = 2;
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(iIndexOf, cCombineMeasuredStates, doubleTapTimeout, 1479752515, false, str$$e3, new Class[]{Integer.TYPE, Integer.TYPE});
                } else {
                    i2 = 2;
                }
                cArr5[iIntValue2] = ((Character) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).charValue();
                cArr4[iIntValue2] = iCustomTabsCallbackDefault.MediaBrowserCompatApi21ConnectionCallback;
                cArr6[iCustomTabsCallbackDefault.a] = (char) (((((long) (cArr4[iIntValue2] ^ cArr3[iCustomTabsCallbackDefault.a])) ^ (coroutineBoundary ^ (-899883803867009716L))) ^ ((long) ((int) (((long) accessartificialFrame) ^ (-899883803867009716L))))) ^ ((long) ((char) (((long) CoroutineDebuggingKt) ^ (-899883803867009716L)))));
                iCustomTabsCallbackDefault.a++;
                i3 = i2;
                i5 = 0;
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
        objArr[0] = new String(cArr6);
    }

    /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
        java.util.NoSuchElementException
        	at java.base/java.util.TreeMap.key(Unknown Source)
        	at java.base/java.util.TreeMap.lastKey(Unknown Source)
        	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
        	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
        	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
        */
    public static java.lang.Object[] CoroutineDebuggingKt(int r31, int r32) {
        /*
            Method dump skipped, instruction units count: 3698
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: app.notifee.core.Logger.CoroutineDebuggingKt(int, int):java.lang.Object[]");
    }
}
