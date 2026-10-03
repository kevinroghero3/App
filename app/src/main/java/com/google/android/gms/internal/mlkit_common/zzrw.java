package com.google.android.gms.internal.mlkit_common;

import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.drawable.Drawable;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import o.ArtificialStackFrames;
import o.onPostMessage;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class zzrw {
    private static final byte[] $$c = {19, -17, 93, 33};
    private static final int $$d = 143;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$a = {0, -128, -114, 48, -33, Ascii.US, 17, 4, -38, 49, 3, 8, -10, Ascii.CAN, -31, Ascii.SYN, Ascii.SYN, -10, 7, Ascii.FF, 2, Ascii.SYN, -16, Ascii.DC2, -9, Ascii.DC4, -44, 35, Ascii.DC4, 9, -6, Ascii.VT, 4, 0, 10, -2, -29, 46, -8, 6, Ascii.SI, -2, 4, -9, Ascii.DC4, -28, Ascii.SUB, Ascii.DC2, -10, 5, Ascii.VT, -2, -19, 39, -6, 6, -27, 46, -8, 6, Ascii.SI, -2, 4, -13, Ascii.CAN, Ascii.CR, 7, Ascii.FF, -12, 4, 50, Ascii.SO, -50};
    private static final int $$b = 249;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static char[] IPostMessageService = {38203, 38062, 38050, 38058, 38060, 38055, 38058, 38079, 38240, 38215, 38055, 38063, 38060, 38055, 38058, 38063, 38224, 38223, 38066, 38060, 38056, 38061, 38063, 38280, 38356, 38361, 38355, 38373, 38375, 38351, 38353, 38357, 38361, 38365, 38357, 38353, 38355, 38353, 38372, 38372, 38357, 38381, 38172, 38164, 38160, 38162, 38160, 38179, 38179, 38164, 38164, 38166, 38167, 38165, 38163, 38158, 38162, 38168, 38197, 38198, 38165, 38160, 38157, 38162, 38165, 38157, 38189, 38191, 38160, 38193, 38343, 38182, 38158, 38160, 38164, 38284, 38358, 38361, 38363, 38354, 38369, 38181, 38188, 38157, 38158, 38164, 38161, 38158, 38151, 38154, 38162, 38161, 38189, 38189, 38158, 38154, 38153, 38184, 38180, 38151, 38154, 38154, 38185, 38188, 38154, 38153, 38187, 38188, 38346, 38230, 38264, 38269, 38242, 38243, 38235, 38232, 38239, 38242, 38245, 38239, 38238, 38348};

    /* JADX WARN: Code duplicated, block: B:10:0x0026  */
    /* JADX WARN: Code duplicated, block: B:8:0x0020  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x002a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0026
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$e(int r5, int r6, short r7) {
        /*
            int r6 = r6 * 3
            int r6 = r6 + 65
            int r7 = r7 * 4
            int r7 = 3 - r7
            int r5 = r5 * 3
            int r0 = 1 - r5
            byte[] r1 = com.google.android.gms.internal.mlkit_common.zzrw.$$c
            byte[] r0 = new byte[r0]
            r2 = 0
            int r5 = 0 - r5
            if (r1 != 0) goto L18
            r4 = r5
            r3 = r2
            goto L2a
        L18:
            r3 = r2
        L19:
            int r7 = r7 + 1
            byte r4 = (byte) r6
            r0[r3] = r4
            if (r3 != r5) goto L26
            java.lang.String r5 = new java.lang.String
            r5.<init>(r0, r2)
            return r5
        L26:
            int r3 = r3 + 1
            r4 = r1[r7]
        L2a:
            int r6 = r6 + r4
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzrw.$$e(int, int, short):java.lang.String");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0023  */
    /* JADX WARN: Code duplicated, block: B:8:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x0027). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void b(byte r5, byte r6, byte r7, java.lang.Object[] r8) {
        /*
            int r0 = 28 - r6
            byte[] r1 = com.google.android.gms.internal.mlkit_common.zzrw.$$a
            int r5 = 71 - r5
            int r7 = r7 + 66
            byte[] r0 = new byte[r0]
            int r6 = 27 - r6
            r2 = 0
            if (r1 != 0) goto L13
            r4 = r7
            r3 = r2
            r7 = r6
            goto L27
        L13:
            r3 = r2
        L14:
            byte r4 = (byte) r7
            int r5 = r5 + 1
            r0[r3] = r4
            if (r3 != r6) goto L23
            java.lang.String r5 = new java.lang.String
            r5.<init>(r0, r2)
            r8[r2] = r5
            return
        L23:
            r4 = r1[r5]
            int r3 = r3 + 1
        L27:
            int r7 = r7 + r4
            int r7 = r7 + (-5)
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzrw.b(byte, byte, byte, java.lang.Object[]):void");
    }

    private static void a(byte[] bArr, int[] iArr, boolean z, Object[] objArr) throws Throwable {
        int i;
        char[] cArr;
        int length;
        char[] cArr2;
        int i2 = 2;
        int i3 = 2 % 2;
        onPostMessage onpostmessage = new onPostMessage();
        int i4 = 0;
        int i5 = iArr[0];
        int i6 = 1;
        int i7 = iArr[1];
        int i8 = iArr[2];
        int i9 = iArr[3];
        char[] cArr3 = IPostMessageService;
        if (cArr3 != null) {
            int i10 = $10 + 7;
            $11 = i10 % 128;
            if (i10 % 2 == 0) {
                length = cArr3.length;
                cArr2 = new char[length];
            } else {
                length = cArr3.length;
                cArr2 = new char[length];
            }
            int i11 = 0;
            while (i11 < length) {
                int i12 = $10 + 23;
                $11 = i12 % 128;
                if (i12 % i2 == 0) {
                    try {
                        Object[] objArr2 = new Object[i6];
                        objArr2[i4] = Integer.valueOf(cArr3[i11]);
                        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1782207618);
                        if (objAccessartificialFrame == null) {
                            byte b = (byte) i4;
                            byte b2 = b;
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(11 - (ViewConfiguration.getPressedStateDuration() >> 16), (char) TextUtils.getOffsetBefore("", i4), 1610 - AndroidCharacter.getMirror('0'), 178318710, false, $$e(b, b2, b2), new Class[]{Integer.TYPE});
                        }
                        cArr2[i11] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                        i11 >>= 1;
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                } else {
                    try {
                        Object[] objArr3 = {Integer.valueOf(cArr3[i11])};
                        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1782207618);
                        if (objAccessartificialFrame2 == null) {
                            byte b3 = (byte) 0;
                            byte b4 = b3;
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(ExpandableListView.getPackedPositionType(0L) + 11, (char) View.getDefaultSize(0, 0), 1562 - Color.alpha(0), 178318710, false, $$e(b3, b4, b4), new Class[]{Integer.TYPE});
                        }
                        cArr2[i11] = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
                        i11++;
                    } catch (Throwable th2) {
                        Throwable cause2 = th2.getCause();
                        if (cause2 == null) {
                            throw th2;
                        }
                        throw cause2;
                    }
                }
                i2 = 2;
                i4 = 0;
                i6 = 1;
            }
            cArr3 = cArr2;
        }
        char[] cArr4 = new char[i7];
        System.arraycopy(cArr3, i5, cArr4, 0, i7);
        if (bArr != null) {
            char[] cArr5 = new char[i7];
            onpostmessage.a = 0;
            char c = 0;
            while (onpostmessage.a < i7) {
                int i13 = $10 + 123;
                $11 = i13 % 128;
                int i14 = i13 % 2;
                if (bArr[onpostmessage.a] == 1) {
                    int i15 = onpostmessage.a;
                    Object[] objArr4 = {Integer.valueOf(cArr4[onpostmessage.a]), Integer.valueOf(c)};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(1378437083);
                    if (objAccessartificialFrame3 == null) {
                        byte b5 = (byte) 0;
                        byte b6 = (byte) (b5 + 1);
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(23 - KeyEvent.getDeadChar(0, 0), (char) (ViewConfiguration.getJumpTapTimeout() >> 16), KeyEvent.keyCodeFromString("") + 2441, -850656813, false, $$e(b5, b6, (byte) (b6 - 1)), new Class[]{Integer.TYPE, Integer.TYPE});
                    }
                    cArr5[i15] = ((Character) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).charValue();
                    int i16 = $11 + 77;
                    $10 = i16 % 128;
                    int i17 = i16 % 2;
                } else {
                    int i18 = onpostmessage.a;
                    Object[] objArr5 = {Integer.valueOf(cArr4[onpostmessage.a]), Integer.valueOf(c)};
                    Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-314759072);
                    if (objAccessartificialFrame4 == null) {
                        byte b7 = (byte) 0;
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getPressedStateDuration() >> 16) + 11, (char) Drawable.resolveOpacity(0, 0), View.resolveSizeAndState(0, 0, 0) + 1562, 1918398056, false, $$e(b7, $$c[0], b7), new Class[]{Integer.TYPE, Integer.TYPE});
                    }
                    cArr5[i18] = ((Character) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).charValue();
                }
                c = cArr5[onpostmessage.a];
                Object[] objArr6 = {onpostmessage, onpostmessage};
                Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(898481158);
                if (objAccessartificialFrame5 == null) {
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(ImageFormat.getBitsPerPixel(0) + 23, (char) (29364 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))), 215 - View.MeasureSpec.makeMeasureSpec(0, 0), -1427572210, false, "F", new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame5).invoke(null, objArr6);
            }
            cArr4 = cArr5;
        }
        if (i9 > 0) {
            int i19 = $10 + 35;
            $11 = i19 % 128;
            if (i19 % 2 == 0) {
                char[] cArr6 = new char[i7];
                System.arraycopy(cArr4, 0, cArr6, 1, i7);
                System.arraycopy(cArr6, 0, cArr4, i7 >>> i9, i9);
                System.arraycopy(cArr6, i9, cArr4, 0, i7 / i9);
            } else {
                char[] cArr7 = new char[i7];
                System.arraycopy(cArr4, 0, cArr7, 0, i7);
                int i20 = i7 - i9;
                System.arraycopy(cArr7, 0, cArr4, i20, i9);
                System.arraycopy(cArr7, i9, cArr4, 0, i20);
            }
        }
        if (z) {
            int i21 = $10 + 21;
            $11 = i21 % 128;
            if (i21 % 2 == 0) {
                cArr = new char[i7];
                i = 1;
                onpostmessage.a = 1;
            } else {
                i = 1;
                cArr = new char[i7];
                onpostmessage.a = 0;
            }
            while (onpostmessage.a < i7) {
                cArr[onpostmessage.a] = cArr4[(i7 - onpostmessage.a) - i];
                onpostmessage.a += i;
                int i22 = $10 + 13;
                $11 = i22 % 128;
                int i23 = i22 % 2;
                i = 1;
            }
            cArr4 = cArr;
        }
        if (i8 > 0) {
            int i24 = $11 + 105;
            $10 = i24 % 128;
            int i25 = i24 % 2 != 0 ? 1 : 0;
            while (true) {
                onpostmessage.a = i25;
                if (onpostmessage.a >= i7) {
                    break;
                }
                cArr4[onpostmessage.a] = (char) (cArr4[onpostmessage.a] - iArr[2]);
                i25 = onpostmessage.a + 1;
            }
        }
        objArr[0] = new String(cArr4);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x07cd  */
    /* JADX WARN: Code duplicated, block: B:101:0x07e2  */
    /* JADX WARN: Code duplicated, block: B:110:0x08be  */
    /* JADX WARN: Code duplicated, block: B:111:0x08c8  */
    /* JADX WARN: Code duplicated, block: B:44:0x043b  */
    /* JADX WARN: Code duplicated, block: B:46:0x0441  */
    /* JADX WARN: Code duplicated, block: B:48:0x044d  */
    /* JADX WARN: Code duplicated, block: B:49:0x045e  */
    /* JADX WARN: Code duplicated, block: B:52:0x047e  */
    /* JADX WARN: Code duplicated, block: B:53:0x04af  */
    /* JADX WARN: Code duplicated, block: B:56:0x0500  */
    /* JADX WARN: Code duplicated, block: B:57:0x0511  */
    /* JADX WARN: Code duplicated, block: B:60:0x057f  */
    /* JADX WARN: Code duplicated, block: B:62:0x0583  */
    /* JADX WARN: Code duplicated, block: B:64:0x058e A[Catch: Exception -> 0x08a5, TRY_ENTER, TryCatch #1 {Exception -> 0x08a5, blocks: (B:64:0x058e, B:69:0x059b, B:75:0x061d, B:79:0x0669, B:80:0x06bd, B:86:0x071f, B:88:0x0725, B:89:0x0726, B:90:0x0727, B:96:0x07a0, B:104:0x089d, B:106:0x08a3, B:107:0x08a4, B:67:0x0595, B:91:0x0741, B:93:0x074e, B:94:0x0798, B:70:0x05b7, B:72:0x05c4, B:73:0x060d), top: B:129:0x058c, inners: #2, #3 }] */
    /* JADX WARN: Code duplicated, block: B:66:0x0594  */
    /* JADX WARN: Code duplicated, block: B:67:0x0595 A[Catch: Exception -> 0x08a5, TryCatch #1 {Exception -> 0x08a5, blocks: (B:64:0x058e, B:69:0x059b, B:75:0x061d, B:79:0x0669, B:80:0x06bd, B:86:0x071f, B:88:0x0725, B:89:0x0726, B:90:0x0727, B:96:0x07a0, B:104:0x089d, B:106:0x08a3, B:107:0x08a4, B:67:0x0595, B:91:0x0741, B:93:0x074e, B:94:0x0798, B:70:0x05b7, B:72:0x05c4, B:73:0x060d), top: B:129:0x058c, inners: #2, #3 }] */
    /* JADX WARN: Code duplicated, block: B:69:0x059b A[Catch: Exception -> 0x08a5, TRY_LEAVE, TryCatch #1 {Exception -> 0x08a5, blocks: (B:64:0x058e, B:69:0x059b, B:75:0x061d, B:79:0x0669, B:80:0x06bd, B:86:0x071f, B:88:0x0725, B:89:0x0726, B:90:0x0727, B:96:0x07a0, B:104:0x089d, B:106:0x08a3, B:107:0x08a4, B:67:0x0595, B:91:0x0741, B:93:0x074e, B:94:0x0798, B:70:0x05b7, B:72:0x05c4, B:73:0x060d), top: B:129:0x058c, inners: #2, #3 }] */
    /* JADX WARN: Code duplicated, block: B:72:0x05c4 A[Catch: all -> 0x071e, TryCatch #3 {all -> 0x071e, blocks: (B:70:0x05b7, B:72:0x05c4, B:73:0x060d), top: B:132:0x05b7, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:78:0x0664  */
    /* JADX WARN: Code duplicated, block: B:80:0x06bd A[Catch: Exception -> 0x08a5, TRY_LEAVE, TryCatch #1 {Exception -> 0x08a5, blocks: (B:64:0x058e, B:69:0x059b, B:75:0x061d, B:79:0x0669, B:80:0x06bd, B:86:0x071f, B:88:0x0725, B:89:0x0726, B:90:0x0727, B:96:0x07a0, B:104:0x089d, B:106:0x08a3, B:107:0x08a4, B:67:0x0595, B:91:0x0741, B:93:0x074e, B:94:0x0798, B:70:0x05b7, B:72:0x05c4, B:73:0x060d), top: B:129:0x058c, inners: #2, #3 }] */
    /* JADX WARN: Code duplicated, block: B:84:0x0712  */
    /* JADX WARN: Code duplicated, block: B:90:0x0727 A[Catch: Exception -> 0x08a5, TRY_LEAVE, TryCatch #1 {Exception -> 0x08a5, blocks: (B:64:0x058e, B:69:0x059b, B:75:0x061d, B:79:0x0669, B:80:0x06bd, B:86:0x071f, B:88:0x0725, B:89:0x0726, B:90:0x0727, B:96:0x07a0, B:104:0x089d, B:106:0x08a3, B:107:0x08a4, B:67:0x0595, B:91:0x0741, B:93:0x074e, B:94:0x0798, B:70:0x05b7, B:72:0x05c4, B:73:0x060d), top: B:129:0x058c, inners: #2, #3 }] */
    /* JADX WARN: Code duplicated, block: B:93:0x074e A[Catch: all -> 0x089c, TryCatch #2 {all -> 0x089c, blocks: (B:91:0x0741, B:93:0x074e, B:94:0x0798), top: B:130:0x0741, outer: #1 }] */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x07ba, code lost:
    
        if (r0.equals((java.lang.String) r7[0]) != false) goto L98;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Object[] CoroutineDebuggingKt(android.content.Context r29, int r30, int r31, int r32) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 2469
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzrw.CoroutineDebuggingKt(android.content.Context, int, int, int):java.lang.Object[]");
    }
}
