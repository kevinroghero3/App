package com.reactnative.ivpusic.imagepicker;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.AudioTrack;
import android.media.ExifInterface;
import android.os.Environment;
import android.os.Process;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import ch.qos.logback.core.net.SyslogConstants;
import com.facebook.imageutils.JfifUtil;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReadableMap;
import com.google.common.base.Ascii;
import com.reactnativecommunity.clipboard.ClipboardModule;
import com.salesforce.marketingcloud.analytics.stats.b;
import io.sentry.instrumentation.file.SentryFileOutputStream;
import it.aep_italia.vts.sdk.dto.soap.functions.requests.SellContractsInput;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import o.ArtificialStackFrames;
import o.onMessageChannelReady;

/* JADX INFO: loaded from: classes3.dex */
public class Compression {
    private static final byte[] $$c = {49, Ascii.SUB, -88, -35};
    private static final int $$d = SyslogConstants.LOG_CLOCK;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$a = {73, -128, -106, 120, Ascii.VT, 2, -12};
    private static final int $$b = 80;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static char[] validateRelationship = {56271, 56261, 56308, 56267, 56278, 56123, 56265, 56262, 56309, 56257, 56258, 56277, 56260, 56276, 56121, 56279, 56298, 56194, 56193, 56127, 56269, 56268, 56273, 56256, 56266, 56199};
    private static int warmup = -1044259920;
    private static boolean requestPostMessageChannelWithExtras = true;
    private static boolean ICustomTabsServiceDefault = true;

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$e(int r7, byte r8, short r9) {
        /*
            byte[] r0 = com.reactnative.ivpusic.imagepicker.Compression.$$c
            int r9 = r9 + 66
            int r7 = r7 * 2
            int r7 = 1 - r7
            int r8 = r8 * 2
            int r8 = 3 - r8
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L15
            r3 = r7
            r9 = r8
            r5 = r2
            goto L2a
        L15:
            r3 = r2
        L16:
            int r8 = r8 + 1
            byte r4 = (byte) r9
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r7) goto L25
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            return r7
        L25:
            r3 = r0[r8]
            r6 = r9
            r9 = r8
            r8 = r6
        L2a:
            int r3 = -r3
            int r8 = r8 + r3
            r3 = r5
            r6 = r9
            r9 = r8
            r8 = r6
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnative.ivpusic.imagepicker.Compression.$$e(int, byte, short):java.lang.String");
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
    private static void b(short r5, int r6, byte r7, java.lang.Object[] r8) {
        /*
            int r5 = r5 * 4
            int r5 = r5 + 4
            int r6 = r6 * 2
            int r0 = 4 - r6
            byte[] r1 = com.reactnative.ivpusic.imagepicker.Compression.$$a
            int r7 = r7 * 4
            int r7 = 109 - r7
            byte[] r0 = new byte[r0]
            int r6 = 3 - r6
            r2 = 0
            if (r1 != 0) goto L19
            r4 = r5
            r7 = r6
            r3 = r2
            goto L2b
        L19:
            r3 = r2
        L1a:
            byte r4 = (byte) r7
            r0[r3] = r4
            if (r3 != r6) goto L27
            java.lang.String r5 = new java.lang.String
            r5.<init>(r0, r2)
            r8[r2] = r5
            return
        L27:
            int r3 = r3 + 1
            r4 = r1[r5]
        L2b:
            int r5 = r5 + 1
            int r7 = r7 + r4
            int r7 = r7 + (-3)
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnative.ivpusic.imagepicker.Compression.b(short, int, byte, java.lang.Object[]):void");
    }

    Compression() {
    }

    File resize(Context context, String str, int i, int i2, int i3, int i4, int i5) throws IOException, OutOfMemoryError {
        Bitmap bitmapDecodeFile;
        Pair<Integer, Integer> pairCalculateTargetDimensions = calculateTargetDimensions(i, i2, i3, i4);
        int iIntValue = ((Integer) pairCalculateTargetDimensions.first).intValue();
        int iIntValue2 = ((Integer) pairCalculateTargetDimensions.second).intValue();
        if (i <= i3 && i2 <= i4) {
            bitmapDecodeFile = BitmapFactory.decodeFile(str);
        } else {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = calculateInSampleSize(i, i2, iIntValue, iIntValue2);
            bitmapDecodeFile = BitmapFactory.decodeFile(str, options);
        }
        String attribute = new ExifInterface(str).getAttribute(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION);
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapDecodeFile, iIntValue, iIntValue2, true);
        File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        if (!externalFilesDir.exists()) {
            Log.d("image-crop-picker", "Pictures Directory is not existing. Will create this directory.");
            externalFilesDir.mkdirs();
        }
        File file = new File(externalFilesDir, UUID.randomUUID() + ".jpg");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(SentryFileOutputStream.Factory.create(new FileOutputStream(file), file));
        bitmapCreateScaledBitmap.compress(Bitmap.CompressFormat.JPEG, i5, bufferedOutputStream);
        if (shouldSetOrientation(attribute)) {
            ExifInterface exifInterface = new ExifInterface(file.getAbsolutePath());
            exifInterface.setAttribute(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, attribute);
            exifInterface.saveAttributes();
        }
        bufferedOutputStream.close();
        bitmapCreateScaledBitmap.recycle();
        return file;
    }

    private int calculateInSampleSize(int i, int i2, int i3, int i4) {
        int i5 = 1;
        if (i > i3 || i2 > i4) {
            int i6 = i / 2;
            int i7 = i2 / 2;
            while (i6 / i5 >= i3 && i7 / i5 >= i4) {
                i5 *= 2;
            }
        }
        return i5;
    }

    private boolean shouldSetOrientation(String str) {
        return (str.equals(String.valueOf(1)) || str.equals(String.valueOf(0))) ? false : true;
    }

    File compressImage(Context context, ReadableMap readableMap, String str, BitmapFactory.Options options) throws IOException, OutOfMemoryError {
        Integer numValueOf = readableMap.hasKey("compressImageMaxWidth") ? Integer.valueOf(readableMap.getInt("compressImageMaxWidth")) : null;
        Integer numValueOf2 = readableMap.hasKey("compressImageMaxHeight") ? Integer.valueOf(readableMap.getInt("compressImageMaxHeight")) : null;
        Double dValueOf = readableMap.hasKey("compressImageQuality") ? Double.valueOf(readableMap.getDouble("compressImageQuality")) : null;
        boolean z = false;
        boolean z2 = dValueOf == null || dValueOf.doubleValue() == 1.0d;
        boolean z3 = numValueOf == null || numValueOf.intValue() >= options.outWidth;
        boolean z4 = numValueOf2 == null || numValueOf2.intValue() >= options.outHeight;
        List listAsList = Arrays.asList("image/jpeg", ClipboardModule.MIMETYPE_JPG, "image/png", "image/gif", "image/tiff");
        String str2 = options.outMimeType;
        if (str2 != null && listAsList.contains(str2.toLowerCase())) {
            z = true;
        }
        if (!z2 || !z3 || !z4 || !z) {
            Log.d("image-crop-picker", "Image compression activated");
            int iDoubleValue = dValueOf != null ? (int) (dValueOf.doubleValue() * 100.0d) : 100;
            Log.d("image-crop-picker", "Compressing image with quality " + iDoubleValue);
            if (numValueOf == null) {
                numValueOf = Integer.valueOf(options.outWidth);
            }
            if (numValueOf2 == null) {
                numValueOf2 = Integer.valueOf(options.outHeight);
            }
            return resize(context, str, options.outWidth, options.outHeight, numValueOf.intValue(), numValueOf2.intValue(), iDoubleValue);
        }
        Log.d("image-crop-picker", "Skipping image compression");
        return new File(str);
    }

    private Pair<Integer, Integer> calculateTargetDimensions(int i, int i2, int i3, int i4) {
        if (i > i3) {
            i2 = (int) (i2 * (i3 / i));
            i = i3;
        }
        if (i2 > i4) {
            i = (int) (i * (i4 / i2));
        } else {
            i4 = i2;
        }
        return Pair.create(Integer.valueOf(i), Integer.valueOf(i4));
    }

    void compressVideo(Activity activity, ReadableMap readableMap, String str, String str2, Promise promise) {
        synchronized (this) {
            promise.resolve(str);
        }
    }

    private static void a(int i, byte[] bArr, char[] cArr, int[] iArr, Object[] objArr) throws Throwable {
        int i2 = 2 % 2;
        onMessageChannelReady onmessagechannelready = new onMessageChannelReady();
        char[] cArr2 = validateRelationship;
        char c = '0';
        int i3 = 0;
        if (cArr2 != null) {
            int i4 = $11 + b.f40o;
            $10 = i4 % 128;
            int i5 = i4 % 2;
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            int i6 = 0;
            while (i6 < length) {
                try {
                    Object[] objArr2 = new Object[1];
                    objArr2[i3] = Integer.valueOf(cArr2[i6]);
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(115862995);
                    if (objAccessartificialFrame == null) {
                        byte b = (byte) i3;
                        byte b2 = b;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 25, (char) (TextUtils.lastIndexOf("", c, i3, i3) + 1), (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 1040, -1719489573, false, $$e(b, b2, (byte) (b2 | 55)), new Class[]{Integer.TYPE});
                    }
                    cArr3[i6] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                    i6++;
                    c = '0';
                    i3 = 0;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            int i7 = $11 + b.i;
            $10 = i7 % 128;
            int i8 = i7 % 2;
            cArr2 = cArr3;
        }
        Object[] objArr3 = {Integer.valueOf(warmup)};
        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1820173622);
        if (objAccessartificialFrame2 == null) {
            byte b3 = (byte) 0;
            byte b4 = b3;
            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(15 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (char) (KeyEvent.getDeadChar(0, 0) + 20488), 2147 - TextUtils.lastIndexOf("", '0'), 216472770, false, $$e(b3, b4, (byte) (b4 + 1)), new Class[]{Integer.TYPE});
        }
        int iIntValue = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
        float f = 0.0f;
        int i9 = 59174;
        if (!(!ICustomTabsServiceDefault)) {
            onmessagechannelready.c = bArr.length;
            char[] cArr4 = new char[onmessagechannelready.c];
            onmessagechannelready.a = 0;
            while (onmessagechannelready.a < onmessagechannelready.c) {
                cArr4[onmessagechannelready.a] = (char) (cArr2[bArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] + i] - iIntValue);
                try {
                    Object[] objArr4 = {onmessagechannelready, onmessagechannelready};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-2083387879);
                    if (objAccessartificialFrame3 == null) {
                        byte b5 = (byte) 0;
                        byte b6 = b5;
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 21, (char) (Gravity.getAbsoluteGravity(0, 0) + i9), 1942 - TextUtils.lastIndexOf("", '0'), 481771537, false, $$e(b5, b6, b6), new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                    i9 = 59174;
                } catch (Throwable th2) {
                    Throwable cause2 = th2.getCause();
                    if (cause2 == null) {
                        throw th2;
                    }
                    throw cause2;
                }
            }
            objArr[0] = new String(cArr4);
            return;
        }
        if (!(!requestPostMessageChannelWithExtras)) {
            onmessagechannelready.c = cArr.length;
            char[] cArr5 = new char[onmessagechannelready.c];
            onmessagechannelready.a = 0;
            while (onmessagechannelready.a < onmessagechannelready.c) {
                int i10 = $11 + b.f40o;
                $10 = i10 % 128;
                if (i10 % 2 != 0) {
                    cArr5[onmessagechannelready.a] = (char) (cArr2[cArr[(onmessagechannelready.c - 1) / onmessagechannelready.a] - i] - iIntValue);
                    Object[] objArr5 = {onmessagechannelready, onmessagechannelready};
                    Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-2083387879);
                    if (objAccessartificialFrame4 == null) {
                        byte b7 = (byte) 0;
                        byte b8 = b7;
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(22 - (AudioTrack.getMaxVolume() > f ? 1 : (AudioTrack.getMaxVolume() == f ? 0 : -1)), (char) ((ViewConfiguration.getWindowTouchSlop() >> 8) + 59174), 1943 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), 481771537, false, $$e(b7, b8, b8), new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame4).invoke(null, objArr5);
                } else {
                    cArr5[onmessagechannelready.a] = (char) (cArr2[cArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] - i] - iIntValue);
                    Object[] objArr6 = {onmessagechannelready, onmessagechannelready};
                    Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-2083387879);
                    if (objAccessartificialFrame5 == null) {
                        byte b9 = (byte) 0;
                        byte b10 = b9;
                        objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(20 - TextUtils.lastIndexOf("", '0'), (char) (59174 - View.MeasureSpec.getSize(0)), 1942 - Process.getGidForName(""), 481771537, false, $$e(b9, b10, b10), new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame5).invoke(null, objArr6);
                    f = 0.0f;
                }
            }
            objArr[0] = new String(cArr5);
            return;
        }
        int i11 = 0;
        onmessagechannelready.c = iArr.length;
        char[] cArr6 = new char[onmessagechannelready.c];
        while (true) {
            onmessagechannelready.a = i11;
            if (onmessagechannelready.a >= onmessagechannelready.c) {
                objArr[0] = new String(cArr6);
                return;
            } else {
                cArr6[onmessagechannelready.a] = (char) (cArr2[iArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] - i] - iIntValue);
                i11 = onmessagechannelready.a + 1;
            }
        }
    }

    public static Object[] coroutineCreation(int i, int i2) throws Throwable {
        Object[] objArr;
        Object[] objArr2;
        String line;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        char c;
        char c2;
        int i8;
        int i9;
        int i10 = 2 % 2;
        try {
            String[] strArr = new String[2];
            Object[] objArr3 = new Object[1];
            a(126 - (~(-(AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))), new byte[]{-114, -124, -115, -116, -124, -117, -117, -118, -119, -120, -124, -121, -121, -122, -123, -124, -125, -126, -127}, null, null, objArr3);
            strArr[0] = (String) objArr3[0];
            int absoluteGravity = Gravity.getAbsoluteGravity(0, 0);
            int i11 = getARTIFICIAL_FRAME_PACKAGE_NAME + 77;
            artificialFrame = i11 % 128;
            int i12 = i11 % 2;
            int iMediaBrowserCompatMediaBrowserImplApi26 = SellContractsInput.MediaBrowserCompatMediaBrowserImplApi26();
            int i13 = absoluteGravity * (-419);
            int i14 = (i13 ^ 53467) + ((i13 & 53467) << 1);
            int i15 = (~((iMediaBrowserCompatMediaBrowserImplApi26 ^ 127) | (iMediaBrowserCompatMediaBrowserImplApi26 & 127))) * TypedValues.CycleType.TYPE_EASING;
            int i16 = ((i14 | i15) << 1) - (i15 ^ i14);
            int i17 = ~absoluteGravity;
            int i18 = -(-((i17 | 127) * (-420)));
            int i19 = (i16 & i18) + (i18 | i16);
            int i20 = ~((i17 & (-128)) | (i17 ^ (-128)));
            int i21 = ~iMediaBrowserCompatMediaBrowserImplApi26;
            int i22 = ~((i21 & 127) | (i21 ^ 127));
            int i23 = ((i20 & i22) | (i20 ^ i22)) * TypedValues.CycleType.TYPE_EASING;
            Object[] objArr4 = new Object[1];
            a((i19 ^ i23) + ((i23 & i19) << 1), new byte[]{-120, -124, -121, -121, -122, -123, -124, -125, -120, -118, -111, -121, -117, -127, -115, -127, -112, -113}, null, null, objArr4);
            strArr[1] = (String) objArr4[0];
            int i24 = 0;
            while (true) {
                if (i24 >= 2) {
                    objArr = new Object[]{new int[]{i}, new int[]{i}, new int[1], null};
                    int i25 = ~i;
                    int i26 = ~(996805192 | i25);
                    int i27 = 45014702 + ((i26 | (-18181418)) * 764) + (((~(i25 | (-18181418))) | 16779272) * (-1528)) + (((-981428066) | i26) * 764);
                    int iMediaBrowserCompatMediaBrowserImplApi27 = SellContractsInput.MediaBrowserCompatMediaBrowserImplApi26();
                    int i28 = i27 * (-495);
                    int i29 = i2 * (-495);
                    int i30 = (i28 ^ i29) + ((i28 & i29) << 1);
                    int i31 = ~i27;
                    int i32 = ~i2;
                    int i33 = ~((i31 & i32) | (i31 ^ i32));
                    int i34 = ~i27;
                    int i35 = (i34 ^ iMediaBrowserCompatMediaBrowserImplApi27) | (i34 & iMediaBrowserCompatMediaBrowserImplApi27);
                    int i36 = ~i35;
                    int i37 = (i30 - (~(-(-(((i33 ^ i36) | (i36 & i33)) * 992))))) - 1;
                    int i38 = ~((i34 ^ i32) | (i34 & i32));
                    int i39 = ~i35;
                    int i40 = (i39 & i38) | (i38 ^ i39);
                    int i41 = ~iMediaBrowserCompatMediaBrowserImplApi27;
                    int i42 = (i41 & i27) | (i41 ^ i27);
                    int i43 = i37 + ((i40 | (~((i42 & i2) | (i42 ^ i2)))) * (-496)) + ((iMediaBrowserCompatMediaBrowserImplApi27 | i2) * 496);
                    int i44 = i43 << 13;
                    int i45 = (i44 | i43) & (~(i43 & i44));
                    int i46 = i45 >>> 17;
                    int i47 = (i45 | i46) & (~(i45 & i46));
                    int i48 = i47 << 5;
                    ((int[]) objArr[2])[0] = (i47 | i48) & (~(i47 & i48));
                    break;
                }
                int i49 = getARTIFICIAL_FRAME_PACKAGE_NAME + 63;
                artificialFrame = i49 % 128;
                int i50 = i49 % 2;
                String str = strArr[i24];
                int i51 = -KeyEvent.normalizeMetaState(0);
                int iMediaBrowserCompatMediaBrowserImplApi28 = SellContractsInput.MediaBrowserCompatMediaBrowserImplApi26();
                int i52 = i51 * (-432);
                int i53 = (i52 & 55118) + (i52 | 55118);
                int i54 = ~i51;
                int i55 = ~iMediaBrowserCompatMediaBrowserImplApi28;
                int i56 = (i54 ^ i55) | (i55 & i54);
                int i57 = (((i53 - (~((~((i56 ^ 127) | (i56 & 127))) * 433))) - 1) - (~(-(-((i54 | (~(((-128) ^ iMediaBrowserCompatMediaBrowserImplApi28) | ((-128) & iMediaBrowserCompatMediaBrowserImplApi28)))) * (-433)))))) - 1;
                int i58 = ~i51;
                int i59 = ~((iMediaBrowserCompatMediaBrowserImplApi28 & i58) | (i58 ^ iMediaBrowserCompatMediaBrowserImplApi28));
                int i60 = ~((i51 & 127) | (i51 ^ 127));
                Object[] objArr5 = new Object[1];
                a(i57 + (((i60 & i59) | (i59 ^ i60)) * 433), new byte[]{-121, -122, -123, -124, -125, -110, -126, -118, -110, -114, -127, -118, -120, -114, -117, -112}, null, null, objArr5);
                Class<?> cls = Class.forName((String) objArr5[0]);
                if (((Boolean) cls.getMethod(str, new Class[0]).invoke(cls, null)).booleanValue()) {
                    objArr = new Object[]{new int[]{i}, new int[]{(i & (-2)) | ((~i) & 1)}, new int[1], null};
                    int iMyTid = Process.myTid();
                    int i61 = ~iMyTid;
                    int i62 = (-120974004) + (((~((-113810410) | i61)) | 864813365) * 519) + (((~(i61 | (-71342793))) | (~(936156157 | iMyTid))) * (-519)) + (((~(iMyTid | 864813365)) | 113810409) * 519);
                    SellContractsInput.MediaBrowserCompatMediaBrowserImplApi26();
                    int i63 = (i2 - (~((i62 & 16) + (i62 | 16)))) - 1;
                    int i64 = i63 << 13;
                    int i65 = ((~i63) & i64) | ((~i64) & i63);
                    int i66 = i65 >>> 17;
                    int i67 = (i65 | i66) & (~(i65 & i66));
                    int i68 = artificialFrame;
                    int i69 = (i68 ^ 57) + ((i68 & 57) << 1);
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i69 % 128;
                    if (i69 % 2 == 0) {
                        int i70 = i67 << 5;
                        ((int[]) objArr[2])[0] = ((~i67) & i70) | ((~i70) & i67);
                        break;
                    }
                    int i71 = (i67 & 3) + (i67 | 3);
                    ((int[]) objArr[5])[0] = (i67 | i71) & (~(i67 & i71));
                    break;
                }
                i24 = ((i24 | 1) << 1) - (i24 ^ 1);
            }
        } catch (Exception unused) {
            int i72 = ~i;
            objArr = new Object[]{new int[]{i}, new int[]{(i & (-3)) | (i72 & 2)}, new int[]{((~i) & i) | ((~i) & i)}, null};
            int i73 = (-120974004) + (((~((-429833792) | i72)) | 548789983) * 519) + (((~((-420093985) | i72)) | (~(968883967 | i))) * (-519)) + (((~(i | 548789983)) | 429833791) * 519) + 16;
            int i74 = i73 * 375;
            int i75 = -(-(i2 * (-747)));
            int i76 = (i74 ^ i75) + ((i74 & i75) << 1);
            int i77 = ~i73;
            int i78 = -(-(((~((i77 & i2) | (i77 ^ i2))) | (~(i72 | i73))) * (-374)));
            int i79 = ((i76 | i78) << 1) - (i78 ^ i76);
            int i80 = ~i2;
            int i81 = (i79 - (~((~((i80 & i73) | (i80 ^ i73))) * 748))) - 1;
            int i82 = ~i73;
            int i83 = ~i2;
            int i84 = ~((i82 & i83) | (i82 ^ i83));
            int i85 = ~((i72 & i73) | (i72 ^ i73));
            int i86 = -(-(((i84 & i85) | (i84 ^ i85)) * 374));
            int i87 = (i81 & i86) + (i86 | i81);
            int i88 = (i87 << 13) ^ i87;
            int i89 = i88 >>> 17;
            int i90 = (i88 | i89) & (~(i88 & i89));
            int i91 = i90 << 5;
        }
        if (i != ((int[]) objArr[1])[0]) {
            int i92 = artificialFrame;
            int i93 = i92 + 47;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i93 % 128;
            int i94 = i93 % 2;
            int i95 = (i92 & 67) + (i92 | 67);
            getARTIFICIAL_FRAME_PACKAGE_NAME = i95 % 128;
            if (i95 % 2 == 0) {
                return objArr;
            }
            int i96 = 3 / 5;
            return objArr;
        }
        try {
            Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(590025679);
            if (objAccessartificialFrame == null) {
                int jumpTapTimeout = (ViewConfiguration.getJumpTapTimeout() >> 16) + 9;
                char cIndexOf = (char) (TextUtils.indexOf("", "", 0, 0) + 64610);
                int iGreen = Color.green(0) + 1806;
                byte b = (byte) 0;
                byte b2 = b;
                Object[] objArr6 = new Object[1];
                b(b, b2, b2, objArr6);
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(jumpTapTimeout, cIndexOf, iGreen, -1135716921, false, (String) objArr6[0], new Class[0]);
            }
            long jLongValue = ((Long) ((Method) objAccessartificialFrame).invoke(null, null)).longValue();
            long j = -852645215;
            long j2 = 988;
            long jNextInt = new Random().nextInt(27329602);
            long j3 = -1;
            long j4 = ((j ^ j3) | jLongValue) ^ j3;
            long j5 = jLongValue ^ j3;
            long j6 = jNextInt ^ j3;
            long j7 = (((long) (-1975)) * j) + (((long) 989) * jLongValue) + ((jNextInt | j4) * j2) + (((long) (-1976)) * (((j5 | j) ^ j3) | ((j6 | j) ^ j3))) + (j2 * (j4 | ((j5 | jNextInt) ^ j3) | (j3 ^ (j6 | jLongValue)))) + ((long) 1192853249);
            int i97 = (-1808254866) + (((~((-1291781583) | i)) | 1146355714 | (~(145444828 | i))) * (-754));
            int i98 = ~((-1146355715) | i);
            int i99 = ~i;
            int i100 = ((int) (j7 >> 32)) & (i97 + ((i98 | (~(1291800542 | i99))) * (-754)) + (((-1291781583) | i99) * 754));
            int iMyTid2 = Process.myTid();
            int i101 = ~iMyTid2;
            if ((i100 | (((int) j7) & ((-1854946753) + (((~((-865169586) | i101)) | (~((-1992571301) | iMyTid2))) * JfifUtil.MARKER_EOI) + (((~(iMyTid2 | (-865169586))) | 847261856) * JfifUtil.MARKER_EOI) + (((~((-1992571301) | i101)) | 865169585) * JfifUtil.MARKER_EOI)))) == 1) {
                int i102 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                int i103 = (i102 ^ 107) + ((i102 & 107) << 1);
                artificialFrame = i103 % 128;
                int i104 = i103 % 2;
                Object[] objArr7 = {new int[]{i}, new int[]{(i & (-11)) | (i99 & 10)}, new int[]{i ^ (i << 5)}, null};
                int i105 = i2 + 1313543516 + ((973052923 | i99) * (-369)) + (((~((-544704940) | i99)) | 433918835) * (-369)) + (((~(544704939 | i)) | 428347984 | (~((-539134089) | i99))) * 369) + 16;
                int i106 = i105 << 13;
                int i107 = ((~i105) & i106) | ((~i106) & i105);
                int i108 = i107 >>> 17;
                int i109 = (i107 | i108) & (~(i107 & i108));
                objArr2 = objArr7;
            } else {
                Object[] objArr8 = {new int[]{i}, new int[]{i}, new int[1], null};
                int i110 = ~((int) Runtime.getRuntime().freeMemory());
                int i111 = -(-(1795982722 + (((-272912525) | i110) * 494) + (((~(i110 | 630204273)) | (-827609821)) * 494)));
                int i112 = ((i2 | i111) << 1) - (i111 ^ i2);
                int i113 = i112 << 13;
                int i114 = (i113 & (~i112)) | ((~i113) & i112);
                int i115 = i114 >>> 17;
                int i116 = ((~i114) & i115) | ((~i115) & i114);
                int i117 = i116 << 5;
                ((int[]) objArr8[2])[0] = ((~i116) & i117) | ((~i117) & i116);
                int i118 = artificialFrame;
                int i119 = (i118 ^ 123) + ((i118 & 123) << 1);
                getARTIFICIAL_FRAME_PACKAGE_NAME = i119 % 128;
                int i120 = i119 % 2;
                objArr2 = objArr8;
            }
            if (i != ((int[]) objArr2[1])[0]) {
                int i121 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                int i122 = (i121 & 1) + (i121 | 1);
                artificialFrame = i122 % 128;
                if (i122 % 2 != 0) {
                    return objArr2;
                }
                Object obj = null;
                obj.hashCode();
                throw null;
            }
            try {
                int iBlue = Color.blue(0);
                int iMediaBrowserCompatMediaBrowserImplApi29 = SellContractsInput.MediaBrowserCompatMediaBrowserImplApi26();
                int i123 = iBlue * 70;
                int i124 = ((i123 | (-8636)) << 1) - (i123 ^ (-8636));
                int i125 = ~iBlue;
                int i126 = (i125 & (-128)) | (i125 ^ (-128));
                int i127 = ~((i126 & iMediaBrowserCompatMediaBrowserImplApi29) | (i126 ^ iMediaBrowserCompatMediaBrowserImplApi29));
                int i128 = (iBlue ^ 127) | (iBlue & 127);
                int i129 = ~((i128 & iMediaBrowserCompatMediaBrowserImplApi29) | (i128 ^ iMediaBrowserCompatMediaBrowserImplApi29));
                int i130 = -(-(((i127 & i129) | (i127 ^ i129)) * 69));
                int i131 = ((i124 | i130) << 1) - (i130 ^ i124);
                int i132 = ~iBlue;
                int i133 = ~((i132 ^ 127) | (i132 & 127));
                int i134 = ~((i132 & iMediaBrowserCompatMediaBrowserImplApi29) | (i132 ^ iMediaBrowserCompatMediaBrowserImplApi29));
                int i135 = (i134 & i133) | (i133 ^ i134);
                int i136 = ~((iMediaBrowserCompatMediaBrowserImplApi29 & 127) | (iMediaBrowserCompatMediaBrowserImplApi29 ^ 127));
                int i137 = ((i136 & i135) | (i135 ^ i136)) * (-69);
                int i138 = ((i131 | i137) << 1) - (i137 ^ i131);
                int i139 = (-128) & iBlue;
                Object[] objArr9 = new Object[1];
                a(i138 + ((~(i139 | ((-128) ^ iBlue))) * 69), new byte[]{-120, -124, -116, -112, -120, -115, -105, -115, -117, -124, -120, -120, -122, -116, -109, -121, -117, -127, -116, -112, -120, -115, -109, -121, -122, -123, -124, -114, -109, -106, -124, -117, -120, -124, -107, -109, -126, -108, -126, -109}, null, null, objArr9);
                File file = new File((String) objArr9[0]);
                if (file.canRead()) {
                    FileReader fileReader = new FileReader(file);
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    try {
                        line = bufferedReader.readLine();
                        int i140 = -(ViewConfiguration.getLongPressTimeout() >> 16);
                        int i141 = (i140 ^ 127) | (i140 & 127);
                        int i142 = (((i140 * (-300)) - (-38354)) - (~((~((i141 & i) | (i141 ^ i))) * (-301)))) - 1;
                        int i143 = ~(((-128) ^ i) | ((-128) & i));
                        int i144 = ~i;
                        int i145 = ~((i144 & i140) | (i144 ^ i140));
                        int i146 = i142 + (((i143 & i145) | (i143 ^ i145)) * (-301));
                        int i147 = ~i140;
                        int i148 = ~((i147 & i) | (i147 ^ i));
                        int i149 = (-128) ^ i148;
                        Object[] objArr10 = new Object[1];
                        a((i146 - (~(((i148 & (-128)) | i149) * 301))) - 1, new byte[]{-104, -118, -117}, null, null, objArr10);
                        if (line.equals((String) objArr10[0])) {
                            fileReader.close();
                            bufferedReader.close();
                            int i150 = artificialFrame + 41;
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i150 % 128;
                            int i151 = i150 % 2;
                            int i152 = artificialFrame + 67;
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i152 % 128;
                            int i153 = i152 % 2;
                            line = null;
                        } else {
                            int i154 = artificialFrame;
                            int i155 = (i154 & 23) + (i154 | 23);
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i155 % 128;
                            int i156 = i155 % 2;
                            fileReader.close();
                            bufferedReader.close();
                        }
                    } catch (Throwable th) {
                        fileReader.close();
                        bufferedReader.close();
                        throw th;
                    }
                } else {
                    line = null;
                }
            } catch (Exception unused2) {
            }
            try {
                Object[] objArr11 = new Object[1];
                a(78 - (~AndroidCharacter.getMirror('0')), new byte[]{-114, -124, -106, -123, -112, -117, -124, -105, -124, -116, -112, -120, -115, -103, -109, -106, -124, -117, -120, -124, -107, -109, -126, -108, -126, -109, -116, -118, -120, -104, -109}, null, null, objArr11);
                File file2 = new File((String) objArr11[0]);
                if (file2.canRead()) {
                    FileReader fileReader2 = new FileReader(file2);
                    BufferedReader bufferedReader2 = new BufferedReader(fileReader2);
                    try {
                        String line2 = bufferedReader2.readLine();
                        int i157 = -(ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                        int i158 = artificialFrame;
                        int i159 = i158 + 21;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i159 % 128;
                        int i160 = i159 % 2;
                        int i161 = i157 * (-958);
                        int i162 = (i161 ^ (-122624)) + ((i161 & (-122624)) << 1);
                        int i163 = ~((-129) | i99);
                        int i164 = ~i157;
                        int i165 = ~((i164 & i) | (i164 ^ i));
                        int i166 = (i163 & i165) | (i163 ^ i165);
                        int i167 = ((i158 | 3) << 1) - (i158 ^ 3);
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i167 % 128;
                        if (i167 % 2 != 0) {
                            int i168 = ~((i99 ^ i157) | (i99 & i157));
                            i3 = (i162 >> (959 / ((i166 & i168) | (i166 ^ i168)))) % ((-959) >> (~((i157 ^ 128) | (i157 & 128))));
                        } else {
                            int i169 = ~((i99 ^ i157) | (i99 & i157));
                            int i170 = ((i166 & i169) | (i166 ^ i169)) * 959;
                            int i171 = (i162 ^ i170) + ((i170 & i162) << 1);
                            int i172 = (~((i157 ^ 128) | (i157 & 128))) * (-959);
                            i3 = ((i171 & i172) << 1) + (i171 ^ i172);
                        }
                        int i173 = ~i157;
                        int i174 = ~i;
                        int i175 = ~((i173 & i174) | (i173 ^ i174));
                        int i176 = ~((-129) | i);
                        int i177 = (i175 & i176) | (i175 ^ i176);
                        int i178 = ~(i157 | i);
                        int i179 = 959 * ((i178 & i177) | (i177 ^ i178));
                        Object[] objArr12 = new Object[1];
                        a(((i3 | i179) << 1) - (i3 ^ i179), new byte[]{-102}, null, null, objArr12);
                        boolean zEquals = line2.equals((String) objArr12[0]);
                        int i180 = artificialFrame + 41;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i180 % 128;
                        if (i180 % 2 != 0) {
                            fileReader2.close();
                            bufferedReader2.close();
                            int i181 = 7 / 0;
                        } else {
                            fileReader2.close();
                            bufferedReader2.close();
                        }
                        if (zEquals) {
                            int iIndexOf = TextUtils.indexOf((CharSequence) "", '0', 0);
                            int iMediaBrowserCompatMediaBrowserImplApi210 = SellContractsInput.MediaBrowserCompatMediaBrowserImplApi26();
                            int i182 = iIndexOf * (-519);
                            int i183 = (i182 ^ 66688) + ((i182 & 66688) << 1);
                            int i184 = ~iIndexOf;
                            int i185 = (i184 & (-129)) | (i184 ^ (-129));
                            int i186 = ~iMediaBrowserCompatMediaBrowserImplApi210;
                            int i187 = ~((i185 & i186) | (i185 ^ i186));
                            int i188 = ~((iMediaBrowserCompatMediaBrowserImplApi210 ^ 128) | (iMediaBrowserCompatMediaBrowserImplApi210 & 128));
                            int i189 = i183 + (((i187 & i188) | (i187 ^ i188)) * 520);
                            int i190 = ~(((-129) ^ i186) | ((-129) & i186));
                            int i191 = ~(iIndexOf | iMediaBrowserCompatMediaBrowserImplApi210);
                            int i192 = -(-(((i190 & i191) | (i190 ^ i191)) * (-1040)));
                            int i193 = ~(i186 | (~iIndexOf));
                            int i194 = ~(((-129) & iIndexOf) | ((-129) ^ iIndexOf));
                            int i195 = (i194 & i193) | (i193 ^ i194);
                            int i196 = ~((iIndexOf & iMediaBrowserCompatMediaBrowserImplApi210) | (iIndexOf ^ iMediaBrowserCompatMediaBrowserImplApi210));
                            Object[] objArr13 = new Object[1];
                            a((((i189 ^ i192) + ((i189 & i192) << 1)) - (~(-(-(((i196 & i195) | (i195 ^ i196)) * 520))))) - 1, new byte[]{-117, -118, -105, -121, -117, -127, -116, -112, -120, -115, -109, -121, -117, -127, -116, -112, -120, -115, -109, -121, -122, -123, -124, -114, -109, -106, -124, -117, -120, -124, -107, -109, -126, -108, -126, -109}, null, null, objArr13);
                            File file3 = new File((String) objArr13[0]);
                            if (!(!file3.canRead())) {
                                FileReader fileReader3 = new FileReader(file3);
                                BufferedReader bufferedReader3 = new BufferedReader(fileReader3);
                                try {
                                    String line3 = bufferedReader3.readLine();
                                    int i197 = -Process.getGidForName("");
                                    int iMediaBrowserCompatMediaBrowserImplApi211 = SellContractsInput.MediaBrowserCompatMediaBrowserImplApi26();
                                    int i198 = (i197 * (-344)) - 43344;
                                    int i199 = getARTIFICIAL_FRAME_PACKAGE_NAME + 17;
                                    artificialFrame = i199 % 128;
                                    int i200 = i199 % 2;
                                    int i201 = ~i197;
                                    int i202 = ~((i201 ^ (-127)) | (i201 & (-127)));
                                    int i203 = ~(i201 | iMediaBrowserCompatMediaBrowserImplApi211);
                                    int iMediaBrowserCompatMediaBrowserImplApi212 = SellContractsInput.MediaBrowserCompatMediaBrowserImplApi26();
                                    int i204 = ~((2121143712 ^ iMediaBrowserCompatMediaBrowserImplApi212) | (2121143712 & iMediaBrowserCompatMediaBrowserImplApi212));
                                    int i205 = ((-2135376738) - (~(-(-(((17883216 ^ i204) | (17883216 & i204)) * 1504))))) + ((~((2139026928 ^ iMediaBrowserCompatMediaBrowserImplApi212) | (iMediaBrowserCompatMediaBrowserImplApi212 & 2139026928))) * (-1504));
                                    int i206 = ((i205 | 50875408) << 1) - (i205 ^ 50875408);
                                    int iMediaBrowserCompatMediaBrowserImplApi213 = SellContractsInput.MediaBrowserCompatMediaBrowserImplApi26();
                                    int i207 = ~((457453550 ^ iMediaBrowserCompatMediaBrowserImplApi213) | (457453550 & iMediaBrowserCompatMediaBrowserImplApi213));
                                    int i208 = ((711298113 ^ i207) | (711298113 & i207)) * 56;
                                    int i209 = (143167975 & i208) + (143167975 | i208);
                                    int i210 = (i209 & (-29459328)) + (i209 | (-29459328));
                                    int i211 = ~iMediaBrowserCompatMediaBrowserImplApi213;
                                    int i212 = ~((i211 & 711298113) | (i211 ^ 711298113));
                                    if (i206 > i210 + (((457453550 & i212) | (457453550 ^ i212)) * 56)) {
                                        int i213 = -(-((i202 ^ i203) | (i202 & i203)));
                                        i6 = i198 << ((i213 & 345) + (i213 | 345));
                                        int i214 = ~i197;
                                        int i215 = ~iMediaBrowserCompatMediaBrowserImplApi211;
                                        i5 = ~((i214 & i215) | (i214 ^ i215));
                                    } else {
                                        int i216 = (i198 - (~(-(-((i202 | i203) * 345))))) - 1;
                                        int i217 = ~iMediaBrowserCompatMediaBrowserImplApi211;
                                        i5 = ~((i217 & i201) | (i201 ^ i217));
                                        i6 = i216;
                                    }
                                    int i218 = artificialFrame;
                                    int i219 = (i218 & 23) + (i218 | 23);
                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i219 % 128;
                                    if (i219 % 2 != 0) {
                                        int i220 = ~(((-127) ^ i197) | ((-127) & i197));
                                        i7 = i6 * (345 / ((i5 & i220) | (i5 ^ i220)));
                                        i201 = ~i197;
                                    } else {
                                        int i221 = ~((i197 & (-127)) | ((-127) ^ i197));
                                        i7 = (i6 - (~(345 * ((i221 & i5) | (i5 ^ i221))))) - 1;
                                    }
                                    int i222 = (i201 ^ (-127)) | (i201 & (-127));
                                    int i223 = -(-(345 * (~((i222 & iMediaBrowserCompatMediaBrowserImplApi211) | (i222 ^ iMediaBrowserCompatMediaBrowserImplApi211)))));
                                    Object[] objArr14 = new Object[1];
                                    a((i7 ^ i223) + ((i223 & i7) << 1), new byte[]{-102}, null, null, objArr14);
                                    boolean zEquals2 = line3.equals((String) objArr14[0]);
                                    int i224 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                    int i225 = (i224 & 11) + (i224 | 11);
                                    artificialFrame = i225 % 128;
                                    if (i225 % 2 == 0) {
                                        fileReader3.close();
                                        bufferedReader3.close();
                                        throw null;
                                    }
                                    fileReader3.close();
                                    bufferedReader3.close();
                                    if (zEquals2 && line != null) {
                                        int i226 = i ^ 20;
                                        Object[] objArr15 = new Object[4];
                                        objArr15[0] = new int[1];
                                        int i227 = artificialFrame;
                                        int i228 = (i227 & 85) + (i227 | 85);
                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i228 % 128;
                                        if (i228 % 2 != 0) {
                                            c = 0;
                                            objArr15[0] = new int[0];
                                            c2 = 1;
                                            objArr15[5] = new int[1];
                                            i8 = 121;
                                        } else {
                                            c = 0;
                                            c2 = 1;
                                            objArr15[1] = new int[1];
                                            objArr15[2] = new int[1];
                                            i8 = 16;
                                        }
                                        ((int[]) objArr15[c])[c] = i;
                                        int[] iArr = (int[]) objArr15[c2];
                                        int i229 = i227 + 31;
                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i229 % 128;
                                        if (i229 % 2 != 0) {
                                            iArr[c] = i226;
                                            objArr15[5] = line;
                                            int i230 = 1578642166 + (((~((-397186613) | i99)) | 44566048 | (~((-581437163) | i99)) | (~(934057726 | i))) * (-84));
                                            int i231 = (~((-581437163) | i)) | 397186612;
                                            int i232 = ~(581437162 | i99);
                                            i9 = i230 + ((i231 | i232) * (-84)) + (((-934057727) | i232) * 84);
                                        } else {
                                            iArr[c] = i226;
                                            objArr15[3] = line;
                                            i9 = 1168600350 + ((~(723064591 | i99)) * (-560)) + ((~((-69369857) | i)) * (-560)) + (((~(255559183 | i99)) | 536875264) * 560);
                                        }
                                        int iMediaBrowserCompatMediaBrowserImplApi214 = SellContractsInput.MediaBrowserCompatMediaBrowserImplApi26();
                                        int i233 = i8 * 755;
                                        int i234 = i9 * (-753);
                                        int i235 = ((i233 | i234) << 1) - (i233 ^ i234);
                                        int i236 = ~i8;
                                        int i237 = (i236 & i9) | (i236 ^ i9);
                                        int i238 = ~i237;
                                        int i239 = ~i8;
                                        int i240 = i238 | (~((i239 ^ iMediaBrowserCompatMediaBrowserImplApi214) | (i239 & iMediaBrowserCompatMediaBrowserImplApi214)));
                                        int i241 = ~((i9 ^ iMediaBrowserCompatMediaBrowserImplApi214) | (i9 & iMediaBrowserCompatMediaBrowserImplApi214));
                                        int i242 = i235 + (((i240 & i241) | (i240 ^ i241)) * (-754));
                                        int i243 = ~(i237 | iMediaBrowserCompatMediaBrowserImplApi214);
                                        int i244 = artificialFrame;
                                        int i245 = (i244 ^ 65) + ((i244 & 65) << 1);
                                        int i246 = i245 % 128;
                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i246;
                                        int i247 = i245 % 2;
                                        int i248 = ~iMediaBrowserCompatMediaBrowserImplApi214;
                                        int i249 = ~(i9 | (i248 ^ i8) | (i248 & i8));
                                        int i250 = (-754) * ((i243 & i249) | (i243 ^ i249));
                                        int i251 = (i2 - (~(((i242 ^ i250) + ((i250 & i242) << 1)) + ((i248 | i239) * 754)))) - 1;
                                        int i252 = i246 + 11;
                                        artificialFrame = i252 % 128;
                                        if (i252 % 2 != 0) {
                                            int i253 = i251 << 13;
                                            int i254 = ((~i251) & i253) | ((~i253) & i251);
                                            int i255 = i254 ^ (i254 >>> 17);
                                            ((int[]) objArr15[2])[0] = i255 ^ (i255 << 5);
                                            return objArr15;
                                        }
                                        int i256 = i251 % 13;
                                        int i257 = ((~i251) & i256) | ((~i256) & i251);
                                        int i258 = i257 >> 83;
                                        int i259 = ((~i257) & i258) | ((~i258) & i257);
                                        ((int[]) objArr15[4])[1] = i259 ^ (i259 - 4);
                                        return objArr15;
                                    }
                                } catch (Throwable th2) {
                                    fileReader3.close();
                                    bufferedReader3.close();
                                    throw th2;
                                }
                            } else {
                                int i260 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                i4 = (i260 ^ 11) + ((i260 & 11) << 1);
                            }
                        }
                        Object[] objArr16 = {new int[]{i}, new int[]{i}, new int[1], null};
                        int i261 = (-1013828930) + (((~(i99 | 441950587)) | (-536869884)) * (-160)) + ((441950587 | (~((-536673188) | i99))) * SyslogConstants.LOG_LOCAL4);
                        int iMediaBrowserCompatMediaBrowserImplApi215 = SellContractsInput.MediaBrowserCompatMediaBrowserImplApi26();
                        int i262 = i261 * 306;
                        int i263 = ((610 | i262) << 1) - (i262 ^ TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS);
                        int i264 = ~i261;
                        int i265 = ~iMediaBrowserCompatMediaBrowserImplApi215;
                        int i266 = i2 + ((i263 - (~(-(-(((i264 & i265) | (i264 ^ i265)) * 305))))) - 1) + (((~(~iMediaBrowserCompatMediaBrowserImplApi215)) | (~i261)) * 305);
                        int i267 = i266 << 13;
                        int i268 = (i266 | i267) & (~(i266 & i267));
                        int i269 = i268 >>> 17;
                        int i270 = ((~i268) & i269) | ((~i269) & i268);
                        int i271 = i270 << 5;
                        ((int[]) objArr16[2])[0] = ((~i270) & i271) | ((~i271) & i270);
                        return objArr16;
                    } catch (Throwable th3) {
                        fileReader2.close();
                        bufferedReader2.close();
                        throw th3;
                    }
                }
                int i272 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                i4 = ((i272 | 61) << 1) - (i272 ^ 61);
                artificialFrame = i4 % 128;
                int i273 = i4 % 2;
            } catch (Exception unused3) {
            }
            Object[] objArr17 = {new int[]{i}, new int[]{i}, new int[1], null};
            int i2610 = (-1013828930) + (((~(i99 | 441950587)) | (-536869884)) * (-160)) + ((441950587 | (~((-536673188) | i99))) * SyslogConstants.LOG_LOCAL4);
            int iMediaBrowserCompatMediaBrowserImplApi216 = SellContractsInput.MediaBrowserCompatMediaBrowserImplApi26();
            int i2611 = i2610 * 306;
            int i2612 = ((610 | i2611) << 1) - (i2611 ^ TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS);
            int i2613 = ~i2610;
            int i2614 = ~iMediaBrowserCompatMediaBrowserImplApi216;
            int i2615 = i2 + ((i2612 - (~(-(-(((i2613 & i2614) | (i2613 ^ i2614)) * 305))))) - 1) + (((~(~iMediaBrowserCompatMediaBrowserImplApi216)) | (~i2610)) * 305);
            int i2616 = i2615 << 13;
            int i2617 = (i2615 | i2616) & (~(i2615 & i2616));
            int i2618 = i2617 >>> 17;
            int i274 = ((~i2617) & i2618) | ((~i2618) & i2617);
            int i275 = i274 << 5;
            ((int[]) objArr17[2])[0] = ((~i274) & i275) | ((~i275) & i274);
            return objArr17;
        } catch (Throwable th4) {
            Throwable cause = th4.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th4;
        }
    }
}
