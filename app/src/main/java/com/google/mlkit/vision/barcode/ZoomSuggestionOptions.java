package com.google.mlkit.vision.barcode;

import android.graphics.Color;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import o.ArtificialStackFrames;
import o._CREATION;

/* JADX INFO: loaded from: classes3.dex */
public class ZoomSuggestionOptions {
    private final ZoomCallback zza;
    private final float zzb;
    private static final byte[] $$c = {75, 100, -62, Ascii.SYN};
    private static final int $$d = 51;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$a = {110, -52, -63, 68, 9, -20, Ascii.FS, -26, -18, 10, -5, -11, 2, 19, -39, 6, -6, Ascii.ESC, -46, 8, -6, -15, 2, -4, Ascii.CR, -24, -13, -7, -12, Ascii.FF, -4, -31, -17, -4, 38, -49, -3, -8, 10, -24, Ascii.US, -22, -22, 10, -7, -12, -2, -22, Ascii.DLE, -18, 9, -20, 44, -35, -20, -9, 6, -11, -4, 0, -10, 2, Ascii.GS, -46, 8, -6, -15, 2, -4, -50, -14, 50};
    private static final int $$b = 148;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static char[] _CREATION = {20903, 39916, 50474, 3960, 30905, 41723, 60474, 54836, 901, 19917, 46848, 57694, 10899, 5340, 24074, 34836, 62917, 16173, 26976, 21182, 40179, 50730, 12394, 8244, 60018, 46255, 32478, 2355, 54135, 40359, 42982, 29200, 15446, 50831, 37078, 23308, 25929, 12194, 63937, 33909, 20152, 60286, 8501, 32755, 46497, 49760, 6178, 22243, 27885, 47452, 63252, 3545, 23431, 36938, 44549, 58579, 13005, 20271, 34294, 54265, 59474, 9791, 31995, 35499, 51050, 7452, 11226, 24963, 48730, 62464, 709, 22702, 38221, 41977, 63924, 6552, 54230, 36119, 18261, 12445, 62675, 16093, 24576, 43603, 56771, 1985, 18698, 29513, 42664, 59575, 4664, 17532, 36775, 45548, 64361, 11620, 20697, 39450, 52289, 63383, 14795, 25353, 38214, 55436, 761, 13430, 32358, 41395, 6540, 54229, 36184, 18262, 12427, 60104, 42003, 40517, 19385, 1531, 65332, 43390, 25259, 12244};
    private static long _BOUNDARY = 2537621539661075386L;

    /* JADX INFO: loaded from: classes5.dex */
    public static class Builder {
        private final ZoomCallback zza;
        private float zzb;

        public Builder(@NonNull ZoomCallback zoomCallback) {
            this.zza = zoomCallback;
        }

        public ZoomSuggestionOptions build() {
            return new ZoomSuggestionOptions(this.zza, this.zzb, null);
        }

        public Builder setMaxSupportedZoomRatio(float f) {
            this.zzb = f;
            return this;
        }
    }

    public interface ZoomCallback {
        boolean setZoom(float f);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0027  */
    /* JADX WARN: Code duplicated, block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x0029). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0027
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$e(byte r6, short r7, short r8) {
        /*
            int r7 = r7 * 2
            int r7 = r7 + 4
            int r8 = r8 + 103
            int r6 = r6 * 3
            int r0 = 1 - r6
            byte[] r1 = com.google.mlkit.vision.barcode.ZoomSuggestionOptions.$$c
            byte[] r0 = new byte[r0]
            r2 = 0
            int r6 = 0 - r6
            r3 = -1
            if (r1 != 0) goto L17
            r4 = r8
            r8 = r7
            goto L29
        L17:
            r5 = r8
            r8 = r7
            r7 = r5
        L1a:
            int r3 = r3 + 1
            byte r4 = (byte) r7
            r0[r3] = r4
            if (r3 != r6) goto L27
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            return r6
        L27:
            r4 = r1[r8]
        L29:
            int r7 = r7 + r4
            int r8 = r8 + 1
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.vision.barcode.ZoomSuggestionOptions.$$e(byte, short, short):java.lang.String");
    }

    /* synthetic */ ZoomSuggestionOptions(ZoomCallback zoomCallback, float f, zzb zzbVar) {
        this.zza = zoomCallback;
        this.zzb = f;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0027  */
    /* JADX WARN: Code duplicated, block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x002d). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0027
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void b(short r5, byte r6, short r7, java.lang.Object[] r8) {
        /*
            int r0 = 28 - r7
            int r5 = r5 + 4
            byte[] r1 = com.google.mlkit.vision.barcode.ZoomSuggestionOptions.$$a
            int r6 = 115 - r6
            byte[] r0 = new byte[r0]
            int r7 = 27 - r7
            r2 = -1
            if (r1 != 0) goto L12
            r3 = r2
            r2 = r5
            goto L2d
        L12:
            r4 = r6
            r6 = r5
            r5 = r4
        L15:
            int r2 = r2 + 1
            byte r3 = (byte) r5
            r0[r2] = r3
            int r6 = r6 + 1
            if (r2 != r7) goto L27
            java.lang.String r5 = new java.lang.String
            r6 = 0
            r5.<init>(r0, r6)
            r8[r6] = r5
            return
        L27:
            r3 = r1[r6]
            r4 = r2
            r2 = r6
            r6 = r3
            r3 = r4
        L2d:
            int r6 = -r6
            int r5 = r5 + r6
            int r5 = r5 + (-5)
            r6 = r2
            r2 = r3
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.vision.barcode.ZoomSuggestionOptions.b(short, byte, short, java.lang.Object[]):void");
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ZoomSuggestionOptions)) {
            return false;
        }
        ZoomSuggestionOptions zoomSuggestionOptions = (ZoomSuggestionOptions) obj;
        return Objects.equal(this.zza, zoomSuggestionOptions.zza) && this.zzb == zoomSuggestionOptions.zzb;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, Float.valueOf(this.zzb));
    }

    public final float zza() {
        return this.zzb;
    }

    public final ZoomCallback zzb() {
        return this.zza;
    }

    private static void a(char c, int i, int i2, Object[] objArr) throws Throwable {
        int i3 = 2 % 2;
        _CREATION _creation = new _CREATION();
        long[] jArr = new long[i2];
        _creation.b = 0;
        int i4 = $10 + 57;
        $11 = i4 % 128;
        if (i4 % 2 == 0) {
            int i5 = 2 / 2;
        }
        while (_creation.b < i2) {
            int i6 = $11 + 29;
            $10 = i6 % 128;
            int i7 = i6 % 2;
            int i8 = _creation.b;
            try {
                Object[] objArr2 = {Integer.valueOf(_CREATION[i + i8])};
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-587087340);
                if (objAccessartificialFrame == null) {
                    byte b = (byte) 0;
                    byte b2 = b;
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(8 - TextUtils.getCapsMode("", 0, 0), (char) (9280 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))), KeyEvent.getDeadChar(0, 0) + 1977, 1113883676, false, $$e(b, b2, (byte) (b2 + 1)), new Class[]{Integer.TYPE});
                }
                Object[] objArr3 = {Long.valueOf(((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue()), Long.valueOf(i8), Long.valueOf(_BOUNDARY), Integer.valueOf(c)};
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1715896821);
                if (objAccessartificialFrame2 == null) {
                    byte b3 = (byte) 0;
                    byte b4 = b3;
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(ExpandableListView.getPackedPositionGroup(0L) + 30, (char) (Color.argb(0, 0, 0, 0) + 49362), (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 683, -115095555, false, $$e(b3, b4, (byte) (b4 + 3)), new Class[]{Long.TYPE, Long.TYPE, Long.TYPE, Integer.TYPE});
                }
                jArr[i8] = ((Long) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).longValue();
                Object[] objArr4 = {_creation, _creation};
                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-293902099);
                if (objAccessartificialFrame3 == null) {
                    byte b5 = (byte) 0;
                    byte b6 = b5;
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(25 - (KeyEvent.getMaxKeyCode() >> 16), (char) (TextUtils.indexOf((CharSequence) "", '0') + 30069), 816 - ExpandableListView.getPackedPositionType(0L), 1897803493, false, $$e(b5, b6, b6), new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame3).invoke(null, objArr4);
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
        char[] cArr = new char[i2];
        _creation.b = 0;
        while (_creation.b < i2) {
            cArr[_creation.b] = (char) jArr[_creation.b];
            Object[] objArr5 = {_creation, _creation};
            Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-293902099);
            if (objAccessartificialFrame4 == null) {
                byte b7 = (byte) 0;
                byte b8 = b7;
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(MotionEvent.axisFromString("") + 26, (char) ((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 30068), View.combineMeasuredStates(0, 0) + 816, 1897803493, false, $$e(b7, b8, b8), new Class[]{Object.class, Object.class});
            }
            ((Method) objAccessartificialFrame4).invoke(null, objArr5);
        }
        objArr[0] = new String(cArr);
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
            Method dump skipped, instruction units count: 3154
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.vision.barcode.ZoomSuggestionOptions.CoroutineDebuggingKt(android.content.Context, int, int, int):java.lang.Object[]");
    }
}
