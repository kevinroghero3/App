package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.imageutils.JfifUtil;
import com.google.android.gms.common.internal.Asserts;
import com.google.common.base.Ascii;
import com.transistorsoft.locationmanager.location.TSLocationManager;
import it.aep_italia.vts.sdk.internal.database.receipts.ReceiptDao_Impl;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;
import o.ArtificialStackFrames;
import o.asBinder;

/* JADX INFO: loaded from: classes4.dex */
public final class zaa implements Runnable {
    final /* synthetic */ ImageManager zaa;
    private final Uri zab;
    private final ParcelFileDescriptor zac;
    private static final byte[] $$c = {67, 32, -18, 9};
    private static final int $$d = 9;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$a = {71, -70, 54, 33, Ascii.VT, 2, -12};
    private static final int $$b = 37;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static long extraCommand = -1073533722262741191L;

    /* JADX WARN: Code duplicated, block: B:10:0x002a  */
    /* JADX WARN: Code duplicated, block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x002c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x002a
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$e(short r6, byte r7, short r8) {
        /*
            int r8 = r8 * 4
            int r8 = 4 - r8
            byte[] r0 = com.google.android.gms.common.images.zaa.$$c
            int r6 = r6 * 3
            int r6 = r6 + 118
            int r7 = r7 * 2
            int r1 = 1 - r7
            byte[] r1 = new byte[r1]
            r2 = 0
            int r7 = 0 - r7
            if (r0 != 0) goto L19
            r3 = r7
            r6 = r8
            r4 = r2
            goto L2c
        L19:
            r3 = r2
            r5 = r8
            r8 = r6
            r6 = r5
        L1d:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r7) goto L2a
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            return r6
        L2a:
            r3 = r0[r6]
        L2c:
            int r3 = -r3
            int r8 = r8 + r3
            int r6 = r6 + 1
            r3 = r4
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.images.zaa.$$e(short, byte, short):java.lang.String");
    }

    public zaa(ImageManager imageManager, @Nullable Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
        this.zaa = imageManager;
        this.zab = uri;
        this.zac = parcelFileDescriptor;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0027  */
    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x002b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0027
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void b(int r5, byte r6, short r7, java.lang.Object[] r8) {
        /*
            int r5 = r5 * 4
            int r5 = 109 - r5
            int r6 = r6 * 2
            int r6 = r6 + 4
            int r7 = r7 * 3
            int r0 = 4 - r7
            byte[] r1 = com.google.android.gms.common.images.zaa.$$a
            byte[] r0 = new byte[r0]
            int r7 = 3 - r7
            r2 = 0
            if (r1 != 0) goto L19
            r5 = r6
            r4 = r7
            r3 = r2
            goto L2b
        L19:
            r3 = r2
        L1a:
            byte r4 = (byte) r5
            r0[r3] = r4
            if (r3 != r7) goto L27
            java.lang.String r5 = new java.lang.String
            r5.<init>(r0, r2)
            r8[r2] = r5
            return
        L27:
            int r3 = r3 + 1
            r4 = r1[r6]
        L2b:
            int r6 = r6 + 1
            int r5 = r5 + r4
            int r5 = r5 + (-3)
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.images.zaa.b(int, byte, short, java.lang.Object[]):void");
    }

    @Override // java.lang.Runnable
    public final void run() {
        Asserts.checkNotMainThread("LoadBitmapFromDiskRunnable can't be executed in the main thread");
        ParcelFileDescriptor parcelFileDescriptor = this.zac;
        Bitmap bitmapDecodeFileDescriptor = null;
        boolean z = false;
        if (parcelFileDescriptor != null) {
            try {
                bitmapDecodeFileDescriptor = BitmapFactory.decodeFileDescriptor(parcelFileDescriptor.getFileDescriptor());
            } catch (OutOfMemoryError e) {
                Log.e("ImageManager", "OOM while loading bitmap for uri: ".concat(String.valueOf(this.zab)), e);
                z = true;
            }
            try {
                this.zac.close();
            } catch (IOException e2) {
                Log.e("ImageManager", "closed failed", e2);
            }
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ImageManager imageManager = this.zaa;
        imageManager.zae.post(new zac(imageManager, this.zab, bitmapDecodeFileDescriptor, z, countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
            Log.w("ImageManager", "Latch interrupted while posting ".concat(String.valueOf(this.zab)));
        }
    }

    private static void a(int i, char[] cArr, Object[] objArr) throws Throwable {
        char c = 2;
        int i2 = 2 % 2;
        asBinder asbinder = new asBinder();
        asbinder.c = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        asbinder.d = 0;
        while (asbinder.d < cArr.length) {
            int i3 = asbinder.d;
            char c2 = cArr[asbinder.d];
            try {
                Object[] objArr2 = new Object[3];
                objArr2[c] = asbinder;
                objArr2[1] = asbinder;
                objArr2[0] = Integer.valueOf(c2);
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1562553046);
                if (objAccessartificialFrame == null) {
                    byte b = (byte) 0;
                    byte b2 = b;
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 11, (char) ((Process.getThreadPriority(0) + 20) >> 6), 1407 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), 1035473698, false, $$e(b, b2, b2), new Class[]{Integer.TYPE, Object.class, Object.class});
                }
                jArr[i3] = ((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue() ^ (extraCommand ^ (-2360974883025274865L));
                Object[] objArr3 = {asbinder, asbinder};
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1981632360);
                if (objAccessartificialFrame2 == null) {
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getJumpTapTimeout() >> 16) + 8, (char) TextUtils.getCapsMode("", 0, 0), 249 - Gravity.getAbsoluteGravity(0, 0), 378009232, false, "w", new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame2).invoke(null, objArr3);
                int i4 = $11 + 3;
                $10 = i4 % 128;
                int i5 = i4 % 2;
                c = 2;
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
        char[] cArr2 = new char[length];
        asbinder.d = 0;
        while (asbinder.d < cArr.length) {
            int i6 = $10 + 49;
            $11 = i6 % 128;
            if (i6 % 2 == 0) {
                cArr2[asbinder.d] = (char) jArr[asbinder.d];
                Object[] objArr4 = {asbinder, asbinder};
                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1981632360);
                if (objAccessartificialFrame3 == null) {
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 7, (char) ((-1) - MotionEvent.axisFromString("")), 250 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), 378009232, false, "w", new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                int i7 = 33 / 0;
            } else {
                cArr2[asbinder.d] = (char) jArr[asbinder.d];
                Object[] objArr5 = {asbinder, asbinder};
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1981632360);
                if (objAccessartificialFrame4 == null) {
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(8 - Drawable.resolveOpacity(0, 0), (char) View.getDefaultSize(0, 0), 249 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), 378009232, false, "w", new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame4).invoke(null, objArr5);
            }
        }
        objArr[0] = new String(cArr2);
    }

    /* JADX WARN: Code duplicated, block: B:81:0x07c1  */
    /* JADX WARN: Code duplicated, block: B:82:0x07c3 A[Catch: Exception -> 0x096d, TRY_LEAVE, TryCatch #1 {Exception -> 0x096d, blocks: (B:79:0x075a, B:82:0x07c3, B:84:0x0840, B:86:0x0848, B:89:0x0873, B:91:0x08a6, B:96:0x095e, B:97:0x0964, B:99:0x0966, B:100:0x096c, B:83:0x07cd, B:90:0x087d), top: B:116:0x075a, inners: #2, #6 }] */
    /* JADX WARN: Code duplicated, block: B:86:0x0848 A[Catch: Exception -> 0x096d, TryCatch #1 {Exception -> 0x096d, blocks: (B:79:0x075a, B:82:0x07c3, B:84:0x0840, B:86:0x0848, B:89:0x0873, B:91:0x08a6, B:96:0x095e, B:97:0x0964, B:99:0x0966, B:100:0x096c, B:83:0x07cd, B:90:0x087d), top: B:116:0x075a, inners: #2, #6 }] */
    /* JADX WARN: Code duplicated, block: B:88:0x0871  */
    /* JADX WARN: Code duplicated, block: B:89:0x0873 A[Catch: Exception -> 0x096d, TRY_LEAVE, TryCatch #1 {Exception -> 0x096d, blocks: (B:79:0x075a, B:82:0x07c3, B:84:0x0840, B:86:0x0848, B:89:0x0873, B:91:0x08a6, B:96:0x095e, B:97:0x0964, B:99:0x0966, B:100:0x096c, B:83:0x07cd, B:90:0x087d), top: B:116:0x075a, inners: #2, #6 }] */
    public static Object[] coroutineCreation(int i, int i2) throws Throwable {
        Object[] objArr;
        char c;
        String line;
        int i3;
        File file;
        FileReader fileReader;
        BufferedReader bufferedReader;
        boolean zEquals;
        File file2;
        FileReader fileReader2;
        BufferedReader bufferedReader2;
        boolean zEquals2;
        int i4;
        int i5;
        int i6;
        int i7;
        int[] iArr;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12 = 2 % 2;
        int i13 = artificialFrame;
        int i14 = (i13 ^ 43) + ((i13 & 43) << 1);
        getARTIFICIAL_FRAME_PACKAGE_NAME = i14 % 128;
        int i15 = i14 % 2;
        long j = 0;
        try {
            int i16 = -(ViewConfiguration.getTouchSlop() >> 8);
            int i17 = i16 * (-949);
            int i18 = (i17 & (-18316649)) + (i17 | (-18316649));
            int i19 = ~i;
            int i20 = ~((-19302) | i19);
            int i21 = ~((~i16) | i);
            int i22 = -(-(((i20 ^ i21) | (i20 & i21)) * 1900));
            int i23 = (i18 ^ i22) + ((i18 & i22) << 1);
            int i24 = ~i;
            int i25 = ~((i24 ^ i16) | (i24 & i16));
            int i26 = ~((i & 19301) | (i ^ 19301));
            int i27 = ((i26 & i25) | (i25 ^ i26)) * (-950);
            int i28 = ((i23 | i27) << 1) - (i27 ^ i23);
            int i29 = ~((i24 ^ 19301) | (i24 & 19301));
            int i30 = ~((i16 & i) | (i16 ^ i));
            int i31 = i29 ^ i30;
            Object[] objArr2 = new Object[1];
            a(i28 + (((i29 & i30) | i31) * 950), new char[]{59231, 44064, 29112, 1404, 51904, 40890, 8975, 59538, 48251, 16841, 5767, 55822, 28644, 13177, 63701, 36286, 20754, 59110, 43592}, objArr2);
            int i32 = -Color.blue(0);
            Object[] objArr3 = new Object[1];
            a((i32 & 62819) + (i32 | 62819), new char[]{59201, 4660, 3481, 1899, 13011, 11703, 9987, 21189, 19521, 18239, 29356, 27666, 26608, 37188, 35899, 34716, 45411, 44247}, objArr3);
            String[] strArr = {(String) objArr2[0], (String) objArr3[0]};
            int i33 = 0;
            while (true) {
                if (i33 >= 2) {
                    objArr = new Object[4];
                    int[] iArr2 = new int[1];
                    objArr[0] = iArr2;
                    int[] iArr3 = new int[1];
                    objArr[1] = iArr3;
                    objArr[2] = new int[1];
                    int i34 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                    int i35 = (i34 ^ 97) + ((i34 & 97) << 1);
                    artificialFrame = i35 % 128;
                    int i36 = i35 % 2;
                    iArr2[0] = i;
                    iArr3[0] = i;
                    objArr[3] = null;
                    int i37 = ((i34 | 93) << 1) - (i34 ^ 93);
                    artificialFrame = i37 % 128;
                    int i38 = i37 % 2;
                    int iElapsedRealtime = (int) SystemClock.elapsedRealtime();
                    int i39 = ~iElapsedRealtime;
                    int i40 = ~(439195416 | i39);
                    int i41 = (-669965554) + ((537001990 | i40) * (-712)) + (((~(iElapsedRealtime | 976197406)) | (~(i39 | (-537001991)))) * (-712)) + (((-539428359) | i40) * 712);
                    int iMediaBrowserCompatMediaBrowserImplBase = ReceiptDao_Impl.MediaBrowserCompatMediaBrowserImplBase();
                    int i42 = (-1) - (~(-(-(i41 * TSLocationManager.LOCATION_ERROR_TIMEOUT))));
                    int i43 = ~(~i41);
                    int i44 = ~iMediaBrowserCompatMediaBrowserImplBase;
                    int i45 = i42 + (((i43 & i44) | (i43 ^ i44)) * (-814));
                    int i46 = ~i41;
                    int i47 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                    int i48 = ((i47 | 105) << 1) - (i47 ^ 105);
                    artificialFrame = i48 % 128;
                    if (i48 % 2 == 0) {
                        int i49 = ~iMediaBrowserCompatMediaBrowserImplBase;
                        int i50 = ~((i46 & i49) | (i46 ^ i49));
                        int i51 = ~(((-1) ^ i41) | i41);
                        int i52 = (i50 & i51) | (i50 ^ i51);
                        int i53 = ((i52 & i44) | (i52 ^ i44)) * 407;
                        i4 = ((i45 | i53) << 1) - (i53 ^ i45);
                    } else {
                        int i54 = ~iMediaBrowserCompatMediaBrowserImplBase;
                        int i55 = ~((i46 & i54) | (i46 ^ i54));
                        int i56 = ~(((-1) ^ i41) | i41);
                        int i57 = (i55 & i56) | (i55 ^ i56);
                        int i58 = ~iMediaBrowserCompatMediaBrowserImplBase;
                        i4 = (i45 - (~(((i57 & i58) | (i57 ^ i58)) * 407))) - 1;
                    }
                    int i59 = (i47 ^ 9) + ((i47 & 9) << 1);
                    int i60 = i59 % 128;
                    artificialFrame = i60;
                    if (i59 % 2 == 0) {
                        int i61 = ~(((-1) ^ i41) | i41);
                        int i62 = ~((iMediaBrowserCompatMediaBrowserImplBase & i41) | (i41 ^ iMediaBrowserCompatMediaBrowserImplBase));
                        i5 = i2 / (i4 * (407 << ((i62 & i61) | (i61 ^ i62))));
                        i6 = 76;
                    } else {
                        int i63 = ~(((-1) ^ i41) | i41);
                        int i64 = ~(((-1) ^ iMediaBrowserCompatMediaBrowserImplBase) | iMediaBrowserCompatMediaBrowserImplBase);
                        int i65 = -(-(407 * ((~(iMediaBrowserCompatMediaBrowserImplBase | i41)) | (i64 & i63) | (i63 ^ i64))));
                        int i66 = -(-(((i4 | i65) << 1) - (i65 ^ i4)));
                        i5 = ((i2 | i66) << 1) - (i66 ^ i2);
                        i6 = 13;
                    }
                    int i67 = i60 + 117;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i67 % 128;
                    int i68 = i67 % 2;
                    int i69 = i5 << i6;
                    int i70 = ((~i5) & i69) | ((~i69) & i5);
                    int i71 = i70 >>> 17;
                    int i72 = ((~i70) & i71) | ((~i71) & i70);
                    int i73 = i72 << 5;
                    ((int[]) objArr[2])[0] = (i72 | i73) & (~(i72 & i73));
                    break;
                }
                String str = strArr[i33];
                int packedPositionType = ExpandableListView.getPackedPositionType(j);
                int iMediaBrowserCompatMediaBrowserImplBase2 = ReceiptDao_Impl.MediaBrowserCompatMediaBrowserImplBase();
                int i74 = (((packedPositionType * (-419)) + 7332557) - (~((~((iMediaBrowserCompatMediaBrowserImplBase2 ^ 17417) | (iMediaBrowserCompatMediaBrowserImplBase2 & 17417))) * TypedValues.CycleType.TYPE_EASING))) - 1;
                int i75 = ~packedPositionType;
                int i76 = ((i75 ^ 17417) | (i75 & 17417)) * (-420);
                int i77 = ((i74 | i76) << 1) - (i76 ^ i74);
                int i78 = ~((i75 & (-17418)) | (i75 ^ (-17418)));
                int i79 = ~((~iMediaBrowserCompatMediaBrowserImplBase2) | 17417);
                int i80 = i78 ^ i79;
                Object[] objArr4 = new Object[1];
                a(i77 + (((i78 & i79) | i80) * TypedValues.CycleType.TYPE_EASING), new char[]{59223, 41809, 28480, 11103, 63357, 45938, 32612, 15143, 50961, 33556, 20290, 2833, 55103, 37665, 24381, 7126}, objArr4);
                Class<?> cls = Class.forName((String) objArr4[0]);
                if (((Boolean) cls.getMethod(str, new Class[0]).invoke(cls, null)).booleanValue()) {
                    int i81 = artificialFrame + 91;
                    int i82 = i81 % 128;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i82;
                    if (i81 % 2 != 0) {
                        i7 = (i & (-2)) | (i24 & 1);
                        objArr = new Object[2];
                        objArr[0] = new int[1];
                        iArr = new int[0];
                    } else {
                        i7 = (~(i & 1)) & (i | 1);
                        Object[] objArr5 = new Object[4];
                        objArr5[0] = new int[1];
                        iArr = new int[1];
                        objArr = objArr5;
                    }
                    objArr[1] = iArr;
                    objArr[2] = new int[1];
                    int i83 = i82 + 125;
                    artificialFrame = i83 % 128;
                    int i84 = i83 % 2;
                    ((int[]) objArr[0])[0] = i;
                    iArr[0] = i7;
                    ReceiptDao_Impl.MediaBrowserCompatMediaBrowserImplBase();
                    ReceiptDao_Impl.MediaBrowserCompatMediaBrowserImplBase();
                    objArr[3] = null;
                    int i85 = (int) Runtime.getRuntime().totalMemory();
                    int i86 = ~i85;
                    int i87 = (((~((-147932878) | i86)) | (~((-830690898) | i85)) | (~(i86 | 830690897))) * 959) + 1443787614 + (((~(i85 | 830690897)) | (~(i86 | (-830690898))) | (~((-147932878) | i85))) * 959);
                    int i88 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                    int i89 = ((i88 | 7) << 1) - (i88 ^ 7);
                    int i90 = i89 % 128;
                    artificialFrame = i90;
                    int i91 = i89 % 2;
                    int i92 = 2639 - (~(i87 * (-163)));
                    int i93 = ~(i19 | i87);
                    int i94 = (i93 & 16) | (16 ^ i93);
                    int i95 = (i90 & 101) + (i90 | 101);
                    int i96 = i95 % 128;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i96;
                    if (i95 % 2 != 0) {
                        i8 = (i92 << ((-328) % i94)) << (164 << ((i ^ 16) | (i & 16)));
                        i10 = ~i87;
                        i9 = ~((-17) | i10);
                    } else {
                        int i97 = (i92 - (~(-(-(i94 * (-328)))))) - 1;
                        int i98 = ((i ^ 16) | (i & 16)) * 164;
                        i8 = (i97 | i98) + (i97 & i98);
                        int i99 = ~i87;
                        i9 = ~((i99 & (-17)) | ((-17) ^ i99));
                        i10 = ~i87;
                    }
                    int i100 = ((i96 | 67) << 1) - (i96 ^ 67);
                    artificialFrame = i100 % 128;
                    if (i100 % 2 == 0) {
                        int i101 = (~((i10 ^ i) | (i10 & i))) | i9;
                        int i102 = i24 | 16;
                        int i103 = ~((i102 & i87) | (i102 ^ i87));
                        int i104 = i2 % (i8 / (164 - ((i103 & i101) | (i101 ^ i103))));
                        i11 = i104 ^ (i104 * 13);
                    } else {
                        int i105 = ~((i10 ^ i) | (i10 & i));
                        int i106 = (i24 & 16) | (i24 ^ 16);
                        int i107 = 164 * ((~((i106 & i87) | (i106 ^ i87))) | (i105 & i9) | (i9 ^ i105));
                        int i108 = (i8 & i107) + (i8 | i107) + i2;
                        int i109 = i108 << 13;
                        i11 = (i108 | i109) & (~(i108 & i109));
                    }
                    int i110 = i11 >>> 17;
                    int i111 = ((~i11) & i110) | ((~i110) & i11);
                    int i112 = i111 << 5;
                    ((int[]) objArr[2])[0] = (i111 | i112) & (~(i111 & i112));
                    break;
                }
                i33 = (i33 ^ 1) + ((i33 & 1) << 1);
                j = 0;
            }
        } catch (Exception unused) {
            objArr = new Object[]{new int[]{i}, new int[]{(~(i & 2)) & (i | 2)}, new int[1], null};
            int iMyTid = Process.myTid();
            int i113 = 395406744 + (((-67764233) | iMyTid) * (-627)) + (((~((-723868884) | iMyTid)) | 254754891) * (-627)) + (((~(iMyTid | 254754891)) | (~((~iMyTid) | 723868883))) * 627) + 16;
            int i114 = (i113 * 530) + 1058;
            int i115 = i2 * 530;
            int i116 = (i114 ^ i115) + ((i114 & i115) << 1);
            int i117 = ~i;
            int i118 = i116 + (((~((i117 & i113) | (i117 ^ i113))) | (~((i113 ^ i2) | (i113 & i2)))) * 529);
            int i119 = ~i2;
            int i120 = ~((i113 ^ i) | (i113 & i));
            int i121 = -(-(((i119 & i120) | (i119 ^ i120)) * 529));
            int i122 = (i118 ^ i121) + ((i121 & i118) << 1);
            int i123 = i122 << 13;
            int i124 = (i123 | i122) & (~(i122 & i123));
            int i125 = i124 >>> 17;
            int i126 = (i124 | i125) & (~(i124 & i125));
            int i127 = i126 << 5;
            ((int[]) objArr[2])[0] = ((~i126) & i127) | ((~i127) & i126);
        }
        Object obj = objArr[1];
        int i128 = getARTIFICIAL_FRAME_PACKAGE_NAME;
        int i129 = ((i128 | 21) << 1) - (i128 ^ 21);
        artificialFrame = i129 % 128;
        int i130 = i129 % 2;
        if (i != ((int[]) obj)[0]) {
            int i131 = i128 + 73;
            artificialFrame = i131 % 128;
            if (i131 % 2 == 0) {
                int i132 = 8 / 0;
            }
            i3 = 2;
        } else {
            try {
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(590025679);
                if (objAccessartificialFrame == null) {
                    int size = 9 - View.MeasureSpec.getSize(0);
                    char trimmedLength = (char) (64610 - TextUtils.getTrimmedLength(""));
                    int i133 = 1805 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1));
                    byte b = (byte) 0;
                    byte b2 = b;
                    Object[] objArr6 = new Object[1];
                    b(b, b2, b2, objArr6);
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(size, trimmedLength, i133, -1135716921, false, (String) objArr6[0], new Class[0]);
                }
                long jLongValue = ((Long) ((Method) objAccessartificialFrame).invoke(null, null)).longValue();
                int i134 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                int i135 = (i134 ^ 105) + ((i134 & 105) << 1);
                artificialFrame = i135 % 128;
                int i136 = i135 % 2;
                long j2 = -300097430;
                long j3 = -68;
                long j4 = -1;
                long j5 = j2 ^ j4;
                long j6 = jLongValue ^ j4;
                long jMaxMemory = (int) Runtime.getRuntime().maxMemory();
                long j7 = jMaxMemory ^ j4;
                long j8 = (((long) 69) * j2) + (((long) (-67)) * jLongValue) + ((((jMaxMemory | jLongValue) ^ j4) | (((j5 | j6) | j7) ^ j4) | ((j2 | jLongValue) ^ j4)) * j3) + (j3 * (((j5 | j7) | jLongValue) ^ j4)) + (((long) 68) * (j5 | ((j6 | j7) ^ j4))) + ((long) 640305464);
                int i137 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                int i138 = ((i137 | 37) << 1) - (i137 ^ 37);
                int i139 = i138 % 128;
                artificialFrame = i139;
                int i140 = i138 % 2;
                int i141 = ((int) (j8 >> 32)) & ((-1419669030) + (((~(1812761425 | i)) | (-2121187320)) * (-140)) + ((~((-308425895) | i)) * 70) + (((~((-375535015) | i)) | (-2054078200)) * 70));
                int i142 = ~i;
                if ((i141 | (((int) j8) & (1788176917 + ((673751336 | i142) * (-192)) + (((~(1055456040 | i142)) | (-1055521706)) * (-384)) + (((~(1055521705 | i)) | (~((-65666) | i142)) | (~((-381704705) | i))) * JfifUtil.MARKER_SOFn)))) == 1) {
                    int i143 = (i139 ^ 97) + ((i139 & 97) << 1);
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i143 % 128;
                    int i144 = i143 % 2;
                    int[] iArr4 = new int[1];
                    int i145 = (-1188835266) + (((~(i | 203209662)) | (-775945215)) * 305) + (((~(203209662 | i142)) | (-775414113)) * 305);
                    int i146 = -(-(i145 * (-500)));
                    int i147 = ((-8000) & i146) + (i146 | (-8000));
                    int i148 = ~i145;
                    int i149 = ((-17) ^ i145) | ((-17) & i145);
                    int i150 = ((~((i148 ^ 16) | (i148 & 16))) | (~((i149 & i) | (i149 ^ i)))) * TypedValues.PositionType.TYPE_TRANSITION_EASING;
                    int i151 = (i147 & i150) + (i150 | i147);
                    int i152 = -(-((~((i148 & (-17)) | ((-17) ^ i148))) * 1002));
                    int i153 = (i151 ^ i152) + ((i152 & i151) << 1);
                    int i154 = (-17) | i142;
                    int i155 = (i153 - (~(-(-((~((i154 & i145) | (i154 ^ i145))) * TypedValues.PositionType.TYPE_TRANSITION_EASING))))) - 1;
                    int i156 = (i2 ^ i155) + ((i2 & i155) << 1);
                    int i157 = i156 ^ (i156 << 13);
                    int i158 = i157 >>> 17;
                    int i159 = ((~i157) & i158) | ((~i158) & i157);
                    int i160 = i159 << 5;
                    iArr4[0] = (i159 | i160) & (~(i159 & i160));
                    objArr = new Object[]{new int[]{i}, new int[]{(i & (-11)) | (i142 & 10)}, iArr4, null};
                    c = 0;
                } else {
                    Object[] objArr7 = {new int[]{i}, new int[]{i}, new int[1], null};
                    int i161 = ~(735707315 | i);
                    int i162 = ((631282904 | i161) * (-658)) + 1431703358 + ((i161 | 69246024) * 658);
                    int iMediaBrowserCompatMediaBrowserImplBase3 = ReceiptDao_Impl.MediaBrowserCompatMediaBrowserImplBase();
                    int i163 = i162 * 51;
                    int i164 = i2 * (-49);
                    int i165 = ((i163 | i164) << 1) - (i163 ^ i164);
                    int i166 = -(-(((i162 ^ iMediaBrowserCompatMediaBrowserImplBase3) | (i162 & iMediaBrowserCompatMediaBrowserImplBase3)) * (-50)));
                    int i167 = (i165 ^ i166) + ((i166 & i165) << 1);
                    int i168 = ~i162;
                    int i169 = ~i2;
                    int i170 = i168 | i169;
                    int i171 = ~((i170 & iMediaBrowserCompatMediaBrowserImplBase3) | (i170 ^ iMediaBrowserCompatMediaBrowserImplBase3));
                    int i172 = ~i2;
                    int i173 = ~iMediaBrowserCompatMediaBrowserImplBase3;
                    int i174 = i172 | i173;
                    int i175 = -(-((i171 | (~((i174 & i162) | (i174 ^ i162)))) * 50));
                    int i176 = ((i167 | i175) << 1) - (i175 ^ i167);
                    int i177 = ((~((i173 & i162) | (i173 ^ i162))) | (~((i169 ^ i173) | (i169 & i173))) | (~((i172 ^ i162) | (i172 & i162)))) * 50;
                    int i178 = (i176 & i177) + (i177 | i176);
                    int i179 = (i178 << 13) ^ i178;
                    int i180 = i179 ^ (i179 >>> 17);
                    int i181 = i180 << 5;
                    int i182 = (i180 | i181) & (~(i180 & i181));
                    c = 0;
                    ((int[]) objArr7[2])[0] = i182;
                    objArr = objArr7;
                }
                if (i != ((int[]) objArr[1])[c]) {
                    int i183 = artificialFrame + 75;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i183 % 128;
                    int i184 = i183 % 2;
                } else {
                    try {
                        int i185 = -(Process.myPid() >> 22);
                        int i186 = ~i185;
                        int i187 = ~((i186 ^ i142) | (i186 & i142));
                        int i188 = ~(((-49758) ^ i142) | ((-49758) & i142));
                        int i189 = (((i185 * 868) - (-43189076)) - (~(-(-(((i187 & i188) | (i187 ^ i188)) * (-867)))))) - 1;
                        int i190 = ~((i186 & (-49758)) | (i186 ^ (-49758)));
                        int i191 = ~i185;
                        int i192 = ~((i191 ^ i) | (i191 & i));
                        int i193 = (i190 & i192) | (i190 ^ i192);
                        int i194 = ~(((-49758) & i) | ((-49758) ^ i));
                        int i195 = (i189 - (~(-(-(((i193 & i194) | (i193 ^ i194)) * (-1734)))))) - 1;
                        int i196 = (i191 ^ (-49758)) | (i191 & (-49758));
                        int i197 = ~i;
                        int i198 = ~((i196 & i197) | (i196 ^ i197));
                        int i199 = (i191 & 49757) | (i191 ^ 49757);
                        int i200 = ~((i199 & i) | (i199 ^ i));
                        int i201 = (i200 & i198) | (i198 ^ i200);
                        int i202 = (i185 & (-49758)) | ((-49758) ^ i185);
                        int i203 = ~((i202 & i) | (i202 ^ i));
                        int i204 = -(-(((i203 & i201) | (i201 ^ i203)) * 867));
                        Object[] objArr8 = new Object[1];
                        a((i195 & i204) + (i204 | i195), new char[]{59161, 9496, 25589, 41042, 61037, 11404, 27005, 47055, 62896, 12822, 28920, 48870, 64270, 14826, 17986, 33840, 49793, 3892, 19912, 35747, 51219, 5876, 21665, 37123, 57321, 7180, 23079, 39052, 42344, 58317, 8629, 28187, 44258, 60052, 14104, 30195, 45635, 61476, 16029, 31599}, objArr8);
                        File file3 = new File((String) objArr8[0]);
                        try {
                            if (file3.canRead()) {
                                FileReader fileReader3 = new FileReader(file3);
                                BufferedReader bufferedReader3 = new BufferedReader(fileReader3);
                                try {
                                    line = bufferedReader3.readLine();
                                    Object[] objArr9 = new Object[1];
                                    a(17076 - (~(ViewConfiguration.getWindowTouchSlop() >> 8)), new char[]{59224, 42476, 25132}, objArr9);
                                    if (line.equals((String) objArr9[0])) {
                                        fileReader3.close();
                                        bufferedReader3.close();
                                    } else {
                                        fileReader3.close();
                                        bufferedReader3.close();
                                    }
                                    int i205 = -(ViewConfiguration.getKeyRepeatTimeout() >> 16);
                                    int iMediaBrowserCompatMediaBrowserImplBase4 = ReceiptDao_Impl.MediaBrowserCompatMediaBrowserImplBase();
                                    int i206 = (i205 * (-1965)) + 42212616;
                                    int i207 = -(-(((i205 ^ (-42900)) | (i205 & (-42900))) * 983));
                                    int i208 = ((i206 | i207) << 1) - (i206 ^ i207);
                                    int i209 = ~i205;
                                    int i210 = ~iMediaBrowserCompatMediaBrowserImplBase4;
                                    int i211 = ~((-42900) | i210);
                                    int i212 = (i208 - (~(((i211 & i209) | (i209 ^ i211)) * (-983)))) - 1;
                                    int i213 = ~((i210 & i209) | (i209 ^ i210));
                                    int i214 = ~i205;
                                    int i215 = ~((i214 & 42899) | (i214 ^ 42899));
                                    int i216 = -(-(((i215 & i213) | (i213 ^ i215)) * 983));
                                    Object[] objArr10 = new Object[1];
                                    a(((i212 | i216) << 1) - (i216 ^ i212), new char[]{59161, 16597, 43106, 4576, 31001, 41670, 2615, 29258, 56285, 818, 27875, 54274, 15776, 25903, 52569, 14023, 40489, 51091, 12052, 34989, 61483, 22618, 33265, 59740, 21147, 47619, 58297, 19413, 45902, 7412, 17512}, objArr10);
                                    file = new File((String) objArr10[0]);
                                    if (!file.canRead()) {
                                        fileReader = new FileReader(file);
                                        bufferedReader = new BufferedReader(fileReader);
                                        try {
                                            String line2 = bufferedReader.readLine();
                                            int i217 = (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                                            int iMediaBrowserCompatMediaBrowserImplBase5 = ReceiptDao_Impl.MediaBrowserCompatMediaBrowserImplBase();
                                            int i218 = (((i217 * 677) - 38871225) - (~(-(-(((i217 | iMediaBrowserCompatMediaBrowserImplBase5) | (-57588)) * (-676)))))) - 1;
                                            int i219 = ~(((-57588) ^ i217) | ((-57588) & i217));
                                            int i220 = ~iMediaBrowserCompatMediaBrowserImplBase5;
                                            int i221 = ~((i220 & i217) | (i220 ^ i217));
                                            int i222 = (i218 - (~(((i219 & i221) | (i219 ^ i221)) * 676))) - 1;
                                            int i223 = ~i217;
                                            int i224 = ~((i223 & (-57588)) | (i223 ^ (-57588)));
                                            int i225 = ~iMediaBrowserCompatMediaBrowserImplBase5;
                                            int i226 = ~(((-57588) & i225) | ((-57588) ^ i225));
                                            int i227 = (i224 & i226) | (i224 ^ i226);
                                            int i228 = ~((i217 & 57587) | (i217 ^ 57587) | iMediaBrowserCompatMediaBrowserImplBase5);
                                            int i229 = -(-(((i228 & i227) | (i227 ^ i228)) * 676));
                                            Object[] objArr11 = new Object[1];
                                            a((i222 & i229) + (i229 | i222), new char[]{59143}, objArr11);
                                            zEquals = line2.equals((String) objArr11[0]);
                                            fileReader.close();
                                            bufferedReader.close();
                                            if (zEquals) {
                                                int i230 = -(ViewConfiguration.getScrollBarSize() >> 8);
                                                Object[] objArr12 = new Object[1];
                                                a((i230 & 21767) + (i230 | 21767), new char[]{59161, 45634, 19777, 6224, 45829, 20094, 6521, 46197, 20320, 6764, 46364, 16468, 6918, 46600, 16694, 7210, 46881, 17006, 7484, 43201, 17371, 7878, 43461, 17657, 8185, 43702, 17908, 4345, 43923, 18078, 4493, 44161, 18353, 4750, 44471, 30893}, objArr12);
                                                file2 = new File((String) objArr12[0]);
                                                if (!file2.canRead()) {
                                                    fileReader2 = new FileReader(file2);
                                                    bufferedReader2 = new BufferedReader(fileReader2);
                                                    try {
                                                        String line3 = bufferedReader2.readLine();
                                                        int i231 = -(ViewConfiguration.getScrollBarFadeDuration() >> 16);
                                                        Object[] objArr13 = new Object[1];
                                                        a(((i231 | 57587) << 1) - (i231 ^ 57587), new char[]{59143}, objArr13);
                                                        zEquals2 = line3.equals((String) objArr13[0]);
                                                        fileReader2.close();
                                                        bufferedReader2.close();
                                                        if (!zEquals2 && line != null) {
                                                            int[] iArr5 = new int[1];
                                                            objArr = new Object[]{new int[]{i}, new int[]{(i & (-21)) | (i142 & 20)}, iArr5, line};
                                                            int i232 = (-120974004) + (((~((-59731089) | i142)) | 918892686) * 519) + (((~((-17452049) | i142)) | (~(936344734 | i))) * (-519)) + (((~(i | 918892686)) | 59731088) * 519) + 16;
                                                            int i233 = i232 * 755;
                                                            int i234 = -(-(i2 * (-753)));
                                                            int i235 = (i233 & i234) + (i233 | i234);
                                                            int i236 = ~i232;
                                                            int i237 = (i236 ^ i2) | (i236 & i2);
                                                            int i238 = ~i237;
                                                            int i239 = ~((i236 ^ i) | (i236 & i));
                                                            int i240 = (i238 & i239) | (i238 ^ i239);
                                                            int i241 = ~(i2 | i);
                                                            int i242 = -(-(((i240 & i241) | (i240 ^ i241)) * (-754)));
                                                            int i243 = ((i235 | i242) << 1) - (i235 ^ i242);
                                                            int i244 = ~(i | i237);
                                                            int i245 = (i142 ^ i232) | (i232 & i142);
                                                            int i246 = -(-((i244 | (~((i2 & i245) | (i245 ^ i2)))) * (-754)));
                                                            int i247 = (i243 & i246) + (i246 | i243) + (((i236 & i142) | (i236 ^ i142)) * 754);
                                                            int i248 = i247 << 13;
                                                            int i249 = (i248 & (~i247)) | ((~i248) & i247);
                                                            int i250 = i249 >>> 17;
                                                            int i251 = (i249 | i250) & (~(i249 & i250));
                                                            int i252 = i251 << 5;
                                                            iArr5[0] = (i251 | i252) & (~(i251 & i252));
                                                        }
                                                    } catch (Throwable th) {
                                                        fileReader2.close();
                                                        bufferedReader2.close();
                                                        throw th;
                                                    }
                                                }
                                            }
                                        } catch (Throwable th2) {
                                            fileReader.close();
                                            bufferedReader.close();
                                            throw th2;
                                        }
                                    }
                                    objArr = new Object[]{new int[]{i}, new int[]{i}, new int[1], null};
                                    int iMyTid2 = Process.myTid();
                                    int i253 = ~iMyTid2;
                                    int i254 = i2 + (-850621568) + (((~(20879329 | i253)) | (~((-2917090) | iMyTid2))) * (-831)) + ((~(1002420193 | iMyTid2)) * (-1662)) + (((~(iMyTid2 | (-20879330))) | (~(i253 | (-999503105))) | (~(999503104 | iMyTid2))) * 831);
                                    int i255 = i254 << 13;
                                    int i256 = (i254 | i255) & (~(i254 & i255));
                                    int i257 = i256 >>> 17;
                                    int i258 = (i256 | i257) & (~(i256 & i257));
                                    int i259 = i258 << 5;
                                    int i260 = (i258 | i259) & (~(i258 & i259));
                                    i3 = 2;
                                    ((int[]) objArr[2])[0] = i260;
                                    int i261 = getARTIFICIAL_FRAME_PACKAGE_NAME + 107;
                                    artificialFrame = i261 % 128;
                                    int i262 = i261 % 2;
                                } catch (Throwable th3) {
                                    fileReader3.close();
                                    bufferedReader3.close();
                                    throw th3;
                                }
                            }
                            int i2010 = -(ViewConfiguration.getKeyRepeatTimeout() >> 16);
                            int iMediaBrowserCompatMediaBrowserImplBase6 = ReceiptDao_Impl.MediaBrowserCompatMediaBrowserImplBase();
                            int i2011 = (i2010 * (-1965)) + 42212616;
                            int i2012 = -(-(((i2010 ^ (-42900)) | (i2010 & (-42900))) * 983));
                            int i2013 = ((i2011 | i2012) << 1) - (i2011 ^ i2012);
                            int i2014 = ~i2010;
                            int i2110 = ~iMediaBrowserCompatMediaBrowserImplBase6;
                            int i2111 = ~((-42900) | i2110);
                            int i2112 = (i2013 - (~(((i2111 & i2014) | (i2014 ^ i2111)) * (-983)))) - 1;
                            int i2113 = ~((i2110 & i2014) | (i2014 ^ i2110));
                            int i2114 = ~i2010;
                            int i2115 = ~((i2114 & 42899) | (i2114 ^ 42899));
                            int i2116 = -(-(((i2115 & i2113) | (i2113 ^ i2115)) * 983));
                            Object[] objArr14 = new Object[1];
                            a(((i2112 | i2116) << 1) - (i2116 ^ i2112), new char[]{59161, 16597, 43106, 4576, 31001, 41670, 2615, 29258, 56285, 818, 27875, 54274, 15776, 25903, 52569, 14023, 40489, 51091, 12052, 34989, 61483, 22618, 33265, 59740, 21147, 47619, 58297, 19413, 45902, 7412, 17512}, objArr14);
                            file = new File((String) objArr14[0]);
                            if (!file.canRead()) {
                                fileReader = new FileReader(file);
                                bufferedReader = new BufferedReader(fileReader);
                                String line4 = bufferedReader.readLine();
                                int i2117 = (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                                int iMediaBrowserCompatMediaBrowserImplBase7 = ReceiptDao_Impl.MediaBrowserCompatMediaBrowserImplBase();
                                int i2118 = (((i2117 * 677) - 38871225) - (~(-(-(((i2117 | iMediaBrowserCompatMediaBrowserImplBase7) | (-57588)) * (-676)))))) - 1;
                                int i2119 = ~(((-57588) ^ i2117) | ((-57588) & i2117));
                                int i2210 = ~iMediaBrowserCompatMediaBrowserImplBase7;
                                int i2211 = ~((i2210 & i2117) | (i2210 ^ i2117));
                                int i2212 = (i2118 - (~(((i2119 & i2211) | (i2119 ^ i2211)) * 676))) - 1;
                                int i2213 = ~i2117;
                                int i2214 = ~((i2213 & (-57588)) | (i2213 ^ (-57588)));
                                int i2215 = ~iMediaBrowserCompatMediaBrowserImplBase7;
                                int i2216 = ~(((-57588) & i2215) | ((-57588) ^ i2215));
                                int i2217 = (i2214 & i2216) | (i2214 ^ i2216);
                                int i2218 = ~((i2117 & 57587) | (i2117 ^ 57587) | iMediaBrowserCompatMediaBrowserImplBase7);
                                int i2219 = -(-(((i2218 & i2217) | (i2217 ^ i2218)) * 676));
                                Object[] objArr15 = new Object[1];
                                a((i2212 & i2219) + (i2219 | i2212), new char[]{59143}, objArr15);
                                zEquals = line4.equals((String) objArr15[0]);
                                fileReader.close();
                                bufferedReader.close();
                                if (zEquals) {
                                    int i2310 = -(ViewConfiguration.getScrollBarSize() >> 8);
                                    Object[] objArr16 = new Object[1];
                                    a((i2310 & 21767) + (i2310 | 21767), new char[]{59161, 45634, 19777, 6224, 45829, 20094, 6521, 46197, 20320, 6764, 46364, 16468, 6918, 46600, 16694, 7210, 46881, 17006, 7484, 43201, 17371, 7878, 43461, 17657, 8185, 43702, 17908, 4345, 43923, 18078, 4493, 44161, 18353, 4750, 44471, 30893}, objArr16);
                                    file2 = new File((String) objArr16[0]);
                                    if (!file2.canRead()) {
                                        fileReader2 = new FileReader(file2);
                                        bufferedReader2 = new BufferedReader(fileReader2);
                                        String line5 = bufferedReader2.readLine();
                                        int i2311 = -(ViewConfiguration.getScrollBarFadeDuration() >> 16);
                                        Object[] objArr17 = new Object[1];
                                        a(((i2311 | 57587) << 1) - (i2311 ^ 57587), new char[]{59143}, objArr17);
                                        zEquals2 = line5.equals((String) objArr17[0]);
                                        fileReader2.close();
                                        bufferedReader2.close();
                                        if (!zEquals2) {
                                        }
                                    }
                                }
                            }
                        } catch (Exception unused2) {
                        }
                    } catch (Exception unused3) {
                    }
                    line = null;
                    objArr = new Object[]{new int[]{i}, new int[]{i}, new int[1], null};
                    int iMyTid3 = Process.myTid();
                    int i2510 = ~iMyTid3;
                    int i2511 = i2 + (-850621568) + (((~(20879329 | i2510)) | (~((-2917090) | iMyTid3))) * (-831)) + ((~(1002420193 | iMyTid3)) * (-1662)) + (((~(iMyTid3 | (-20879330))) | (~(i2510 | (-999503105))) | (~(999503104 | iMyTid3))) * 831);
                    int i2512 = i2511 << 13;
                    int i2513 = (i2511 | i2512) & (~(i2511 & i2512));
                    int i2514 = i2513 >>> 17;
                    int i2515 = (i2513 | i2514) & (~(i2513 & i2514));
                    int i2516 = i2515 << 5;
                    int i263 = (i2515 | i2516) & (~(i2515 & i2516));
                    i3 = 2;
                    ((int[]) objArr[2])[0] = i263;
                    int i264 = getARTIFICIAL_FRAME_PACKAGE_NAME + 107;
                    artificialFrame = i264 % 128;
                    int i265 = i264 % 2;
                }
                i3 = 2;
            } catch (Throwable th4) {
                Throwable cause = th4.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th4;
            }
        }
        int i266 = getARTIFICIAL_FRAME_PACKAGE_NAME;
        int i267 = (i266 & 19) + (i266 | 19);
        artificialFrame = i267 % 128;
        if (i267 % i3 != 0) {
            return objArr;
        }
        Object obj2 = null;
        obj2.hashCode();
        throw null;
    }
}
