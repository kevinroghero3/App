package com.google.zxing.client.result;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.appcompat.app.AppCompatDelegate;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import o.ArtificialStackFrames;
import o.onNavigationEvent;

/* JADX INFO: loaded from: classes6.dex */
public abstract class ParsedResult {
    private final ParsedResultType type;
    private static final byte[] $$c = {110, -52, -63, 68};
    private static final int $$d = 245;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$a = {Ascii.CAN, 50, 47, 107, 9, -20, Ascii.FS, -26, -18, 10, -5, -11, 2, 19, -39, 6, -6, Ascii.ESC, -46, 8, -6, -15, 2, -4, Ascii.CR, -24, -13, -7, -12, Ascii.FF, -4, -50, -14, -31, -17, -4, 38, -49, -3, -8, 10, -24, Ascii.US, -22, -22, 10, -7, -12, -2, -22, Ascii.DLE, -18, 9, -20, 44, -35, -20, -9, 6, -11, -4, 0, -10, 2, Ascii.GS, -46, 8, -6, -15, 2, -4, 50};
    private static final int $$b = AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static int setDefaultImpl = -260894015;

    /* JADX WARN: Code duplicated, block: B:10:0x0024  */
    /* JADX WARN: Code duplicated, block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x0026). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0024
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$e(int r6, short r7, byte r8) {
        /*
            int r8 = r8 * 2
            int r8 = r8 + 114
            byte[] r0 = com.google.zxing.client.result.ParsedResult.$$c
            int r7 = r7 * 2
            int r7 = r7 + 4
            int r6 = r6 * 4
            int r6 = 1 - r6
            byte[] r1 = new byte[r6]
            r2 = 0
            if (r0 != 0) goto L16
            r3 = r6
            r4 = r2
            goto L26
        L16:
            r3 = r2
        L17:
            int r4 = r3 + 1
            byte r5 = (byte) r8
            r1[r3] = r5
            if (r4 != r6) goto L24
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            return r6
        L24:
            r3 = r0[r7]
        L26:
            int r8 = r8 + r3
            int r7 = r7 + 1
            r3 = r4
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.client.result.ParsedResult.$$e(int, short, byte):java.lang.String");
    }

    private static void a(short s, byte b, short s2, Object[] objArr) {
        int i = 70 - b;
        byte[] bArr = $$a;
        int i2 = s2 + 66;
        byte[] bArr2 = new byte[s + 2];
        int i3 = s + 1;
        int i4 = -1;
        if (bArr == null) {
            i2 = (i2 + (-i3)) - 5;
        }
        while (true) {
            i4++;
            bArr2[i4] = (byte) i2;
            i++;
            if (i4 == i3) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            i2 = (i2 + (-bArr[i])) - 5;
        }
    }

    public abstract String getDisplayResult();

    protected ParsedResult(ParsedResultType parsedResultType) {
        this.type = parsedResultType;
    }

    public final ParsedResultType getType() {
        return this.type;
    }

    public final String toString() {
        return getDisplayResult();
    }

    public static void maybeAppend(String str, StringBuilder sb) {
        if (str == null || str.isEmpty()) {
            return;
        }
        if (sb.length() > 0) {
            sb.append('\n');
        }
        sb.append(str);
    }

    public static void maybeAppend(String[] strArr, StringBuilder sb) {
        if (strArr != null) {
            for (String str : strArr) {
                maybeAppend(str, sb);
            }
        }
    }

    private static void b(boolean z, int i, int i2, int i3, char[] cArr, Object[] objArr) throws Throwable {
        char[] cArr2;
        int i4 = 2 % 2;
        onNavigationEvent onnavigationevent = new onNavigationEvent();
        char[] cArr3 = new char[i3];
        onnavigationevent.d = 0;
        while (onnavigationevent.d < i3) {
            int i5 = $11 + 75;
            $10 = i5 % 128;
            int i6 = i5 % 2;
            onnavigationevent.c = cArr[onnavigationevent.d];
            cArr3[onnavigationevent.d] = (char) (i2 + onnavigationevent.c);
            int i7 = onnavigationevent.d;
            try {
                Object[] objArr2 = {Integer.valueOf(cArr3[i7]), Integer.valueOf(setDefaultImpl)};
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(465886069);
                if (objAccessartificialFrame == null) {
                    byte b = (byte) 0;
                    byte b2 = b;
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 22, (char) ExpandableListView.getPackedPositionType(0L), View.combineMeasuredStates(0, 0) + 1775, -2069783171, false, $$e(b, b2, b2), new Class[]{Integer.TYPE, Integer.TYPE});
                }
                cArr3[i7] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                Object[] objArr3 = {onnavigationevent, onnavigationevent};
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1257606387);
                if (objAccessartificialFrame2 == null) {
                    byte b3 = (byte) 0;
                    byte b4 = b3;
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(37 - TextUtils.indexOf("", "", 0), (char) ((KeyEvent.getMaxKeyCode() >> 16) + 56277), 1258 - TextUtils.indexOf((CharSequence) "", '0', 0), 711931141, false, $$e(b3, b4, (byte) (b4 + 1)), new Class[]{Object.class, Object.class});
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
        if (i > 0) {
            onnavigationevent.b = i;
            char[] cArr4 = new char[i3];
            System.arraycopy(cArr3, 0, cArr4, 0, i3);
            System.arraycopy(cArr4, 0, cArr3, i3 - onnavigationevent.b, onnavigationevent.b);
            System.arraycopy(cArr4, onnavigationevent.b, cArr3, 0, i3 - onnavigationevent.b);
        }
        if (z) {
            int i8 = $10 + 91;
            $11 = i8 % 128;
            if (i8 % 2 == 0) {
                cArr2 = new char[i3];
                onnavigationevent.d = 1;
            } else {
                cArr2 = new char[i3];
                onnavigationevent.d = 0;
            }
            while (onnavigationevent.d < i3) {
                cArr2[onnavigationevent.d] = cArr3[(i3 - onnavigationevent.d) - 1];
                Object[] objArr4 = {onnavigationevent, onnavigationevent};
                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1257606387);
                if (objAccessartificialFrame3 == null) {
                    byte b5 = (byte) 0;
                    byte b6 = b5;
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 37, (char) (56277 - KeyEvent.keyCodeFromString("")), 16778475 + Color.rgb(0, 0, 0), 711931141, false, $$e(b5, b6, (byte) (b6 + 1)), new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                int i9 = $11 + 55;
                $10 = i9 % 128;
                int i10 = i9 % 2;
            }
            int i11 = $10 + 63;
            $11 = i11 % 128;
            int i12 = i11 % 2;
            cArr3 = cArr2;
        }
        String str = new String(cArr3);
        int i13 = $11 + 77;
        $10 = i13 % 128;
        int i14 = i13 % 2;
        objArr[0] = str;
    }

    /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
        java.util.NoSuchElementException
        	at java.base/java.util.TreeMap.key(Unknown Source)
        	at java.base/java.util.TreeMap.lastKey(Unknown Source)
        	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
        	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
        	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
        */
    public static java.lang.Object[] CoroutineDebuggingKt(android.content.Context r28, int r29, int r30, int r31) {
        /*
            Method dump skipped, instruction units count: 3757
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.client.result.ParsedResult.CoroutineDebuggingKt(android.content.Context, int, int, int):java.lang.Object[]");
    }
}
