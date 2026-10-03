package com.google.android.gms.internal.mlkit_vision_barcode;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import o.ArtificialStackFrames;
import o.artificialFrame;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzce implements Iterator {
    int zzb;
    int zzc;
    int zzd = -1;
    final /* synthetic */ zzci zze;
    private static final byte[] $$h = {114, -78, -61, 42};
    private static final int $$i = 80;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$d = {6, Ascii.FS, 8, -86, -11, -2, Ascii.FF};
    private static final int $$e = 237;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static int[] ICustomTabsCallbackStub = {-193745828, 583647433, -1503824397, -1055086057, 1528753607, 627344929, -1154409951, -2134961468, 278059442, -1293575486, -60253285, 354908551, 1800491051, 2073744371, -136647637, -2098818419, 1474912108, -1422868457};

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002e). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$j(int r6, int r7, short r8) {
        /*
            int r8 = r8 * 6
            int r8 = 115 - r8
            byte[] r0 = com.google.android.gms.internal.mlkit_vision_barcode.zzce.$$h
            int r7 = r7 * 3
            int r7 = 3 - r7
            int r6 = r6 * 4
            int r1 = r6 + 1
            byte[] r1 = new byte[r1]
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r6
            r8 = r7
            r4 = r2
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
            r4 = r0[r7]
            int r3 = r3 + 1
            r5 = r8
            r8 = r7
            r7 = r4
            r4 = r3
            r3 = r5
        L2e:
            int r7 = -r7
            int r7 = r7 + r3
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode.zzce.$$j(int, int, short):java.lang.String");
    }

    /* synthetic */ zzce(zzci zzciVar, zzcd zzcdVar) {
        this.zze = zzciVar;
        this.zzb = zzciVar.zzf;
        this.zzc = zzciVar.zze();
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0027  */
    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x002e). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0027
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void e(short r6, int r7, short r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = com.google.android.gms.internal.mlkit_vision_barcode.zzce.$$d
            int r8 = r8 * 4
            int r8 = 109 - r8
            int r7 = r7 * 2
            int r1 = 4 - r7
            int r6 = r6 + 4
            byte[] r1 = new byte[r1]
            int r7 = 3 - r7
            r2 = 0
            if (r0 != 0) goto L17
            r8 = r6
            r4 = r7
            r3 = r2
            goto L2e
        L17:
            r3 = r2
        L18:
            byte r4 = (byte) r8
            int r6 = r6 + 1
            r1[r3] = r4
            if (r3 != r7) goto L27
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L27:
            int r3 = r3 + 1
            r4 = r0[r6]
            r5 = r8
            r8 = r6
            r6 = r5
        L2e:
            int r4 = -r4
            int r6 = r6 + r4
            int r6 = r6 + (-3)
            r5 = r8
            r8 = r6
            r6 = r5
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode.zzce.e(short, int, short, java.lang.Object[]):void");
    }

    private final void zzb() {
        if (this.zze.zzf != this.zzb) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzc >= 0;
    }

    @Override // java.util.Iterator
    public final Object next() {
        zzb();
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i = this.zzc;
        this.zzd = i;
        Object objZza = zza(i);
        this.zzc = this.zze.zzf(this.zzc);
        return objZza;
    }

    @Override // java.util.Iterator
    public final void remove() {
        zzb();
        zzaz.zzf(this.zzd >= 0, "no calls to next() since the last call to remove()");
        this.zzb += 32;
        int i = this.zzd;
        zzci zzciVar = this.zze;
        zzciVar.remove(zzci.zzg(zzciVar, i));
        this.zzc--;
        this.zzd = -1;
    }

    abstract Object zza(int i);

    private static void d(int i, int[] iArr, Object[] objArr) throws Throwable {
        int length;
        int[] iArr2;
        int i2;
        int i3 = 2;
        int i4 = 2 % 2;
        artificialFrame artificialframe = new artificialFrame();
        char[] cArr = new char[4];
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr3 = ICustomTabsCallbackStub;
        int i5 = -1780896814;
        long j = 0;
        int i6 = 1;
        int i7 = 0;
        if (iArr3 != null) {
            int length2 = iArr3.length;
            int[] iArr4 = new int[length2];
            int i8 = 0;
            while (i8 < length2) {
                int i9 = $10 + 77;
                $11 = i9 % 128;
                int i10 = i9 % i3;
                try {
                    Object[] objArr2 = {Integer.valueOf(iArr3[i8])};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(i5);
                    if (objAccessartificialFrame == null) {
                        byte b = (byte) 0;
                        byte b2 = b;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(11 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (char) (ExpandableListView.getPackedPositionChild(j) + 1), ((byte) KeyEvent.getModifierMetaStateMask()) + Ascii.ESC, 180153818, false, $$j(b, b2, (byte) (b2 + 1)), new Class[]{Integer.TYPE});
                    }
                    iArr4[i8] = ((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
                    i8++;
                    i3 = 2;
                    i5 = -1780896814;
                    j = 0;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            iArr3 = iArr4;
        }
        int length3 = iArr3.length;
        int[] iArr5 = new int[length3];
        int[] iArr6 = ICustomTabsCallbackStub;
        if (iArr6 != null) {
            int i11 = $11 + 77;
            $10 = i11 % 128;
            if (i11 % 2 != 0) {
                length = iArr6.length;
                iArr2 = new int[length];
                i2 = 1;
            } else {
                length = iArr6.length;
                iArr2 = new int[length];
                i2 = 0;
            }
            while (i2 < length) {
                try {
                    Object[] objArr3 = new Object[i6];
                    objArr3[i7] = Integer.valueOf(iArr6[i2]);
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1780896814);
                    if (objAccessartificialFrame2 == null) {
                        byte b3 = (byte) i7;
                        byte b4 = b3;
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(11 - Color.alpha(i7), (char) ((-1) - MotionEvent.axisFromString("")), (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 1561, 180153818, false, $$j(b3, b4, (byte) (b4 + 1)), new Class[]{Integer.TYPE});
                    }
                    iArr2[i2] = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
                    i2++;
                    iArr6 = iArr6;
                    i6 = 1;
                    i7 = 0;
                } catch (Throwable th2) {
                    Throwable cause2 = th2.getCause();
                    if (cause2 == null) {
                        throw th2;
                    }
                    throw cause2;
                }
            }
            iArr6 = iArr2;
        }
        int i12 = i7;
        System.arraycopy(iArr6, i12, iArr5, i12, length3);
        artificialframe.e = i12;
        while (artificialframe.e < iArr.length) {
            cArr[0] = (char) (iArr[artificialframe.e] >> 16);
            cArr[1] = (char) iArr[artificialframe.e];
            cArr[2] = (char) (iArr[artificialframe.e + 1] >> 16);
            cArr[3] = (char) iArr[artificialframe.e + 1];
            artificialframe.c = (cArr[0] << 16) + cArr[1];
            artificialframe.b = (cArr[2] << 16) + cArr[3];
            artificialFrame.coroutineBoundary(iArr5);
            int i13 = $11 + 41;
            $10 = i13 % 128;
            int i14 = 2;
            int i15 = i13 % 2;
            int i16 = 0;
            while (i16 < 16) {
                int i17 = $11 + 73;
                $10 = i17 % 128;
                int i18 = i17 % i14;
                artificialframe.c ^= iArr5[i16];
                Object[] objArr4 = {artificialframe, Integer.valueOf(artificialFrame.coroutineBoundary(artificialframe.c)), artificialframe, artificialframe};
                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1540318455);
                if (objAccessartificialFrame3 == null) {
                    byte b5 = (byte) 0;
                    byte b6 = b5;
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getScrollDefaultDelay() >> 16) + 26, (char) Color.blue(0), TextUtils.getOffsetAfter("", 0) + 1041, 995482881, false, $$j(b5, b6, b6), new Class[]{Object.class, Integer.TYPE, Object.class, Object.class});
                }
                int iIntValue = ((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue();
                artificialframe.c = artificialframe.b;
                artificialframe.b = iIntValue;
                i16++;
                i14 = 2;
            }
            int i19 = artificialframe.c;
            artificialframe.c = artificialframe.b;
            artificialframe.b = i19;
            artificialframe.b ^= iArr5[16];
            artificialframe.c ^= iArr5[17];
            int i20 = artificialframe.c;
            int i21 = artificialframe.b;
            cArr[0] = (char) (artificialframe.c >>> 16);
            cArr[1] = (char) artificialframe.c;
            cArr[2] = (char) (artificialframe.b >>> 16);
            cArr[3] = (char) artificialframe.b;
            artificialFrame.coroutineBoundary(iArr5);
            cArr2[artificialframe.e * 2] = cArr[0];
            cArr2[(artificialframe.e * 2) + 1] = cArr[1];
            cArr2[(artificialframe.e * 2) + 2] = cArr[2];
            cArr2[(artificialframe.e * 2) + 3] = cArr[3];
            Object[] objArr5 = {artificialframe, artificialframe};
            Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1348396126);
            if (objAccessartificialFrame4 == null) {
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(TextUtils.getOffsetBefore("", 0) + 37, (char) (28010 - ExpandableListView.getPackedPositionType(0L)), (ViewConfiguration.getWindowTouchSlop() >> 8) + 306, -818175402, false, "q", new Class[]{Object.class, Object.class});
            }
            ((Method) objAccessartificialFrame4).invoke(null, objArr5);
        }
        objArr[0] = new String(cArr2, 0, i);
    }

    /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
        java.util.NoSuchElementException
        	at java.base/java.util.TreeMap.key(Unknown Source)
        	at java.base/java.util.TreeMap.lastKey(Unknown Source)
        	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
        	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
        	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
        */
    public static java.lang.Object[] CoroutineDebuggingKt(int r30, int r31) {
        /*
            Method dump skipped, instruction units count: 2814
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode.zzce.CoroutineDebuggingKt(int, int):java.lang.Object[]");
    }
}
