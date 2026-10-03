package com.google.android.gms.dynamite;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.recyclerview.widget.ItemTouchHelper;
import ch.qos.logback.core.net.SyslogConstants;
import com.facebook.appevents.ml.ModelManager$$ExternalSyntheticLambda1;
import com.facebook.imageutils.JfifUtil;
import com.salesforce.marketingcloud.analytics.stats.b;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import o.ArtificialStackFrames;
import o.asBinder;
import o.onPostMessage;

/* JADX INFO: loaded from: classes2.dex */
public final class zze implements DynamiteModule.VersionPolicy.IVersions {
    private static final byte[] $$a = {85, 48, 73, -84};
    private static final int $$b = 47;
    private static int $10 = 0;
    private static int $11 = 1;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static char[] IPostMessageService = {38273, 38346, 38348, 38343, 38349, 38343, 38343, 38342, 38367, 38370, 38342, 38350, 38342, 38207, 38341, 38340, 38204, 38367, 38379, 38343, 38206, 38340, 38375, 38367, 38364, 38272, 38274, 38275, 38383, 38380, 38272, 38274, 38386, 38353, 38341, 38343, 38346, 38348, 38303, 38272, 38393, 38274, 38272, 38379, 38390, 38399, 38378, 38353, 38356, 38364, 38379, 38285, 38397, 38361, 38355, 38351, 38356, 38358, 38376, 38272, 38394, 38391, 38280, 38391, 38361, 38355, 38351, 38356, 38358, 38302, 38279, 38382, 38350, 38358, 38355, 38350, 38353, 38358, 38391, 38390, 38361, 38355, 38351, 38356, 38358, 38360, 38357, 38345, 38353, 38355, 38350, 38353, 38071, 38069, 38075, 38065, 38073, 38075, 38220, 38056, 38071, 38069, 38061, 38070, 38062, 38227, 38280, 38357, 38357, 38372, 38376, 38361, 38363, 38361, 38360, 38365, 38375, 38272, 38386, 38353, 38384, 38382, 38350, 38358, 38355, 38350, 38353, 38358, 38391, 38390, 38361, 38355, 38351, 38356, 38358, 38360, 38277, 38356, 38365, 38380, 38378, 38355, 38357, 38365, 38361, 38360, 38360, 38353, 38348, 38356, 38379, 38279, 38382, 38348, 38356, 38363, 38391, 38380, 38345, 38353, 38354, 38348, 38355, 38363, 38355, 38383, 38392, 38356, 38356, 38362, 38350, 38346, 38351, 38350, 38234, 38239, 38242, 38234, 38266, 38268, 38237, 38270, 38155, 38253, 38243, 38241, 38244, 38241, 38231, 38232, 38240, 38248, 38244, 38242, 38240, 38235, 38239, 38245, 38146, 38147, 38242, 38220, 38220, 38269, 38233, 38218, 38213, 38268, 38223, 38218, 38213, 38237, 38281, 38361, 38359, 38355, 38361, 38359, 38356, 38354, 38366, 38399, 38287, 38285, 38393, 38361, 38356, 38363, 38360, 38361, 38356, 38363, 38364, 38355, 38361};
    private static long extraCommand = 5125098881368261663L;

    private static String $$c(byte b, short s, short s2) {
        int i = b * 2;
        int i2 = 122 - s2;
        byte[] bArr = $$a;
        int i3 = 4 - (s * 3);
        byte[] bArr2 = new byte[1 - i];
        int i4 = 0 - i;
        int i5 = -1;
        if (bArr == null) {
            i3++;
            i2 = i3 + i2;
        }
        while (true) {
            i5++;
            bArr2[i5] = (byte) i2;
            if (i5 == i4) {
                return new String(bArr2, 0);
            }
            byte b2 = bArr[i3];
            i3++;
            i2 += b2;
        }
    }

    zze() {
    }

    @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.IVersions
    public final int zza(Context context, String str) {
        return DynamiteModule.getLocalVersion(context, str);
    }

    @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.IVersions
    public final int zzb(Context context, String str, boolean z) throws DynamiteModule.LoadingException {
        return DynamiteModule.zza(context, str, z);
    }

    private static void b(int i, char[] cArr, Object[] objArr) throws Throwable {
        int i2 = 2 % 2;
        asBinder asbinder = new asBinder();
        asbinder.c = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        asbinder.d = 0;
        int i3 = $11 + 121;
        $10 = i3 % 128;
        if (i3 % 2 != 0) {
            int i4 = 5 / 5;
        }
        while (asbinder.d < cArr.length) {
            int i5 = asbinder.d;
            try {
                Object[] objArr2 = {Integer.valueOf(cArr[asbinder.d]), asbinder, asbinder};
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1562553046);
                if (objAccessartificialFrame == null) {
                    byte b = (byte) 0;
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(10 - Process.getGidForName(""), (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1), (ViewConfiguration.getTouchSlop() >> 8) + 1407, 1035473698, false, $$c(b, b, (byte) $$a.length), new Class[]{Integer.TYPE, Object.class, Object.class});
                }
                jArr[i5] = ((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue() ^ (extraCommand ^ (-2360974883025274865L));
                try {
                    Object[] objArr3 = {asbinder, asbinder};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1981632360);
                    if (objAccessartificialFrame2 == null) {
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getLongPressTimeout() >> 16) + 8, (char) Color.argb(0, 0, 0, 0), 249 - (ViewConfiguration.getFadingEdgeLength() >> 16), 378009232, false, "w", new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame2).invoke(null, objArr3);
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
        }
        char[] cArr2 = new char[length];
        asbinder.d = 0;
        while (asbinder.d < cArr.length) {
            int i6 = $11 + 79;
            $10 = i6 % 128;
            int i7 = i6 % 2;
            cArr2[asbinder.d] = (char) jArr[asbinder.d];
            try {
                Object[] objArr4 = {asbinder, asbinder};
                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1981632360);
                if (objAccessartificialFrame3 == null) {
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(7 - TextUtils.lastIndexOf("", '0', 0), (char) ('0' - AndroidCharacter.getMirror('0')), TextUtils.indexOf((CharSequence) "", '0', 0, 0) + ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 378009232, false, "w", new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame3).invoke(null, objArr4);
            } catch (Throwable th3) {
                Throwable cause3 = th3.getCause();
                if (cause3 == null) {
                    throw th3;
                }
                throw cause3;
            }
        }
        objArr[0] = new String(cArr2);
    }

    private static void a(byte[] bArr, int[] iArr, boolean z, Object[] objArr) throws Throwable {
        int i;
        int i2 = 2;
        int i3 = 2 % 2;
        onPostMessage onpostmessage = new onPostMessage();
        int i4 = 0;
        int i5 = iArr[0];
        int i6 = 1;
        int i7 = iArr[1];
        int i8 = iArr[2];
        int i9 = iArr[3];
        char[] cArr = IPostMessageService;
        if (cArr != null) {
            int length = cArr.length;
            char[] cArr2 = new char[length];
            int i10 = 0;
            while (i10 < length) {
                int i11 = $11 + 59;
                $10 = i11 % 128;
                int i12 = i11 % i2;
                try {
                    Object[] objArr2 = new Object[i6];
                    objArr2[i4] = Integer.valueOf(cArr[i10]);
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1782207618);
                    if (objAccessartificialFrame == null) {
                        byte b = (byte) i4;
                        byte b2 = b;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(ImageFormat.getBitsPerPixel(i4) + 12, (char) TextUtils.getCapsMode("", i4, i4), 1561 - ((byte) KeyEvent.getModifierMetaStateMask()), 178318710, false, $$c(b, b2, (byte) (b2 | 57)), new Class[]{Integer.TYPE});
                    }
                    cArr2[i10] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                    i10++;
                    i2 = 2;
                    i4 = 0;
                    i6 = 1;
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
                if (bArr[onpostmessage.a] == 1) {
                    int i13 = onpostmessage.a;
                    Object[] objArr3 = {Integer.valueOf(cArr3[onpostmessage.a]), Integer.valueOf(c)};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1378437083);
                    if (objAccessartificialFrame2 == null) {
                        byte b3 = (byte) 0;
                        byte b4 = b3;
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getDoubleTapTimeout() >> 16) + 23, (char) View.resolveSize(0, 0), Color.alpha(0) + 2441, -850656813, false, $$c(b3, b4, (byte) (b4 | 54)), new Class[]{Integer.TYPE, Integer.TYPE});
                    }
                    cArr4[i13] = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
                } else {
                    int i14 = onpostmessage.a;
                    Object[] objArr4 = {Integer.valueOf(cArr3[onpostmessage.a]), Integer.valueOf(c)};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-314759072);
                    if (objAccessartificialFrame3 == null) {
                        byte b5 = (byte) 0;
                        byte b6 = b5;
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(11 - Color.argb(0, 0, 0, 0), (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 1), 1562 - (ViewConfiguration.getFadingEdgeLength() >> 16), 1918398056, false, $$c(b5, b6, b6), new Class[]{Integer.TYPE, Integer.TYPE});
                    }
                    cArr4[i14] = ((Character) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).charValue();
                }
                c = cArr4[onpostmessage.a];
                Object[] objArr5 = {onpostmessage, onpostmessage};
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(898481158);
                if (objAccessartificialFrame4 == null) {
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 22, (char) (Color.green(0) + 29363), 215 - Color.argb(0, 0, 0, 0), -1427572210, false, "F", new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame4).invoke(null, objArr5);
            }
            cArr3 = cArr4;
        }
        if (i9 > 0) {
            char[] cArr5 = new char[i7];
            i = 0;
            System.arraycopy(cArr3, 0, cArr5, 0, i7);
            int i15 = i7 - i9;
            System.arraycopy(cArr5, 0, cArr3, i15, i9);
            System.arraycopy(cArr5, i9, cArr3, 0, i15);
        } else {
            i = 0;
        }
        if (z) {
            char[] cArr6 = new char[i7];
            while (true) {
                onpostmessage.a = i;
                if (onpostmessage.a >= i7) {
                    break;
                }
                cArr6[onpostmessage.a] = cArr3[(i7 - onpostmessage.a) - 1];
                i = onpostmessage.a + 1;
            }
            cArr3 = cArr6;
        }
        if (i8 > 0) {
            onpostmessage.a = 0;
            int i16 = $10 + 37;
            $11 = i16 % 128;
            int i17 = 2;
            int i18 = i16 % 2;
            while (onpostmessage.a < i7) {
                int i19 = $11 + 27;
                $10 = i19 % 128;
                int i20 = i19 % i17;
                cArr3[onpostmessage.a] = (char) (cArr3[onpostmessage.a] - iArr[i17]);
                onpostmessage.a++;
                int i21 = $11 + 5;
                $10 = i21 % 128;
                int i22 = i21 % 2;
                i17 = 2;
            }
        }
        objArr[0] = new String(cArr3);
    }

    public static Object[] accessartificialFrame(Context context, int i, int i2) {
        Object[] objArr;
        byte[] bArr;
        int[] iArr;
        boolean z;
        int i3;
        int i4;
        int i5;
        Object[] objArr2;
        byte[] bArr2;
        int[] iArr2;
        int i6;
        Object obj;
        Class<?> cls;
        Object obj2;
        Object[] objArr3;
        int i7;
        int i8 = 2 % 2;
        int i9 = artificialFrame;
        int i10 = (i9 & 121) + (i9 | 121);
        getARTIFICIAL_FRAME_PACKAGE_NAME = i10 % 128;
        if (i10 % 2 != 0) {
            int i11 = 7 / 0;
        }
        if (context == null) {
            int i12 = (i9 ^ 57) + ((i9 & 57) << 1);
            getARTIFICIAL_FRAME_PACKAGE_NAME = i12 % 128;
            if (i12 % 2 != 0) {
                objArr3 = new Object[]{new int[0], new int[1], new int[1]};
                i7 = 1;
            } else {
                objArr3 = new Object[4];
                objArr3[0] = new int[1];
                objArr3[1] = new int[1];
                objArr3[2] = new int[1];
                i7 = 0;
            }
            ((int[]) objArr3[0])[0] = i;
            ((int[]) objArr3[1])[0] = i;
            objArr3[3] = null;
            int i13 = ~i;
            int i14 = (~((-747742810) | i13)) | 537985048 | (~(230880965 | i13));
            int i15 = 984433718 + (((~((-21123205) | i)) | i14) * 590) + (i14 * (-1180)) + (((~((-230880966) | i13)) | (~(747742809 | i13))) * 590);
            int i16 = i7 * 615;
            int i17 = i15 * (-613);
            int i18 = ((i16 | i17) << 1) - (i16 ^ i17);
            int i19 = ~i7;
            int i20 = ~((i19 ^ i15) | (i19 & i15));
            int i21 = ~i15;
            int i22 = -(-(((i20 & i) | (i ^ i20) | (~((i21 & i7) | (i21 ^ i7)))) * 614));
            int i23 = (i18 ^ i22) + ((i22 & i18) << 1);
            int i24 = ~i;
            int i25 = ~((i24 & i19) | (i19 ^ i24));
            int i26 = ~(i19 | i15);
            int i27 = (i25 & i26) | (i25 ^ i26);
            int i28 = ~((i13 ^ i15) | (i13 & i15));
            int i29 = (i23 - (~(((i27 & i28) | (i27 ^ i28)) * (-1228)))) - 1;
            int i30 = ~i15;
            int i31 = (i30 & i19) | (i19 ^ i30);
            int i32 = ~((i31 & i13) | (i31 ^ i13));
            int i33 = i7 | i13;
            int i34 = ~((i33 & i15) | (i33 ^ i15));
            int i35 = (i29 - (~(-(-(((i32 & i34) | (i32 ^ i34)) * 614))))) - 1;
            int iArtificialFrame = ModelManager$$ExternalSyntheticLambda1.artificialFrame();
            int i36 = i35 * 673;
            int i37 = i2 * (-1343);
            int i38 = (i36 ^ i37) + ((i36 & i37) << 1);
            int i39 = ~((i35 ^ iArtificialFrame) | (i35 & iArtificialFrame));
            int i40 = (i38 - (~(-(-(((i39 & i2) | (i2 ^ i39)) * 672))))) - 1;
            int i41 = ~i35;
            int i42 = ~iArtificialFrame;
            int i43 = ~((i41 & i42) | (i41 ^ i42));
            int i44 = ~((i2 ^ iArtificialFrame) | (i2 & iArtificialFrame));
            int i45 = ((i43 & i44) | (i43 ^ i44)) * (-672);
            int i46 = (i40 ^ i45) + ((i45 & i40) << 1);
            int i47 = ~i2;
            int i48 = ~iArtificialFrame;
            int i49 = ~((i48 & i47) | (i47 ^ i48));
            int i50 = ~i2;
            int i51 = ~((i50 & i35) | (i50 ^ i35));
            int i52 = (i49 & i51) | (i49 ^ i51);
            int i53 = getARTIFICIAL_FRAME_PACKAGE_NAME;
            int i54 = (i53 ^ 39) + ((i53 & 39) << 1);
            artificialFrame = i54 % 128;
            if (i54 % 2 != 0) {
                int i55 = (i46 - (~(i52 * 672))) - 1;
                int i56 = i55 << 13;
                int i57 = (i56 & (~i55)) | ((~i56) & i55);
                int i58 = i57 ^ (i57 >>> 17);
                ((int[]) objArr3[2])[0] = i58 ^ (i58 << 5);
                return objArr3;
            }
            int i59 = i46 >>> (672 / i52);
            int i60 = i59 >> 14;
            int i61 = ((~i59) & i60) | ((~i60) & i59);
            int i62 = i61 << 21;
            int i63 = (i61 | i62) & (~(i61 & i62));
            int i64 = i63 >> 3;
            ((int[]) objArr3[2])[1] = ((~i63) & i64) | ((~i64) & i63);
            return objArr3;
        }
        try {
            Object[] objArr4 = new Object[1];
            a(new byte[]{1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0}, new int[]{0, 38, 13, 3}, false, objArr4);
            Object[] objArr5 = (Object[]) Array.newInstance(Class.forName((String) objArr4[0]), 2);
            int iIndexOf = TextUtils.indexOf("", "");
            int iArtificialFrame2 = ModelManager$$ExternalSyntheticLambda1.artificialFrame();
            int i65 = iIndexOf * 399;
            int i66 = (i65 & 1551711) + (i65 | 1551711);
            int i67 = ~iIndexOf;
            int i68 = ~((i67 ^ 3889) | (i67 & 3889));
            int i69 = ((-3890) ^ iIndexOf) | ((-3890) & iIndexOf);
            int i70 = ~i69;
            int i71 = (i68 ^ i70) | (i68 & i70);
            int i72 = ~(((-3890) & iArtificialFrame2) | ((-3890) ^ iArtificialFrame2));
            int i73 = (i66 - (~(((i71 & i72) | (i71 ^ i72)) * 398))) - 1;
            int i74 = -(-(((iIndexOf ^ 3889) | (iIndexOf & 3889)) * (-1194)));
            int i75 = ((i73 | i74) << 1) - (i73 ^ i74);
            int i76 = ~iArtificialFrame2;
            int i77 = (~((i76 & (-3890)) | ((-3890) ^ i76))) | (~((~iIndexOf) | 3889));
            int i78 = ~i69;
            int i79 = ((i77 & i78) | (i77 ^ i78)) * 398;
            Object[] objArr6 = new Object[1];
            b((i75 ^ i79) + ((i79 & i75) << 1), new char[]{48211, 45935, 41551, 37314, 32954, 63361, 59204, 54824, 50673, 13517, 11226, 6991, 2617, 30991, 26827, 24488, 20268, 48670, 44383, 40178, 37802, 33649, 62036, 57624, 53473, 51133, 14022, 9848, 5489, 1224, 31741}, objArr6);
            String str = (String) objArr6[0];
            int i80 = artificialFrame + 49;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i80 % 128;
            try {
                if (i80 % 2 != 0) {
                    objArr = new Object[]{str};
                    bArr = new byte[]{1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0};
                    iArr = new int[]{0, 38, 13, 3};
                    z = true;
                } else {
                    objArr = new Object[]{str};
                    bArr = new byte[]{1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0};
                    iArr = new int[]{0, 38, 13, 3};
                    z = false;
                }
                Object[] objArr7 = new Object[1];
                a(bArr, iArr, z, objArr7);
                objArr5[0] = Class.forName((String) objArr7[0]).getDeclaredConstructor(String.class).newInstance(objArr);
                Object[] objArr8 = new Object[1];
                a(new byte[]{1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0}, new int[]{38, 31, 0, 8}, true, objArr8);
                try {
                    Object[] objArr9 = {(String) objArr8[0]};
                    Object[] objArr10 = new Object[1];
                    a(new byte[]{1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0}, new int[]{0, 38, 13, 3}, false, objArr10);
                    objArr5[1] = Class.forName((String) objArr10[0]).getDeclaredConstructor(String.class).newInstance(objArr9);
                    int i81 = artificialFrame + 97;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i81 % 128;
                    int i82 = i81 % 2;
                    try {
                        Object[] objArr11 = new Object[1];
                        a(new byte[]{1, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1}, new int[]{69, 23, 0, 17}, true, objArr11);
                        Class<?> cls2 = Class.forName((String) objArr11[0]);
                        int i83 = -(ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                        int i84 = i83 * 51;
                        int i85 = ((i84 | (-1045709)) << 1) - (i84 ^ (-1045709));
                        int i86 = -(-(((i83 ^ i) | (i83 & i)) * (-50)));
                        int i87 = (i85 ^ i86) + ((i85 & i86) << 1);
                        int i88 = ~i83;
                        int i89 = (i88 ^ (-21342)) | (i88 & (-21342));
                        int i90 = ~((i89 & i) | (i89 ^ i));
                        int i91 = ~i;
                        int i92 = ((-21342) ^ i91) | ((-21342) & i91);
                        int i93 = ~((i92 ^ i83) | (i92 & i83));
                        int i94 = i87 + (((i90 ^ i93) | (i93 & i90)) * 50);
                        int i95 = ~(((-21342) ^ i91) | ((-21342) & i91));
                        int i96 = ~(((-21342) ^ i83) | ((-21342) & i83));
                        int i97 = (i95 & i96) | (i95 ^ i96);
                        int i98 = ~((i83 & i91) | (i91 ^ i83));
                        int i99 = ((i97 & i98) | (i97 ^ i98)) * 50;
                        Object[] objArr12 = new Object[1];
                        b((i94 ^ i99) + ((i99 & i94) << 1), new char[]{48247, 61224, 6878, 18007, 61701, 7330, 18517, 64506, 9887, 21040, 65023, 10382, 21538, 34760, 13153, 24070, 35250}, objArr12);
                        Object objInvoke = cls2.getMethod((String) objArr12[0], null).invoke(context, null);
                        try {
                            Object[] objArr13 = new Object[1];
                            a(new byte[]{1, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1}, new int[]{69, 23, 0, 17}, true, objArr13);
                            Class<?> cls3 = Class.forName((String) objArr13[0]);
                            int i100 = -(ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                            int iArtificialFrame3 = ModelManager$$ExternalSyntheticLambda1.artificialFrame();
                            int i101 = i100 * TypedValues.Custom.TYPE_DIMENSION;
                            int i102 = (i101 ^ (-45803772)) + ((i101 & (-45803772)) << 1);
                            int i103 = ~i100;
                            int i104 = ~((i103 ^ iArtificialFrame3) | (i103 & iArtificialFrame3));
                            int i105 = ~iArtificialFrame3;
                            int i106 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                            int i107 = (i106 & 49) + (i106 | 49);
                            artificialFrame = i107 % 128;
                            int i108 = i107 % 2;
                            int i109 = (~((i105 ^ 50724) | (i105 & 50724))) | i104;
                            if (i108 == 0) {
                                int i110 = -((-1808) >>> i109);
                                i3 = ((i102 | i110) << 1) - (i110 ^ i102);
                                int i111 = ~i100;
                                i103 = i111 ^ (-50725);
                                i4 = i111 & (-50725);
                            } else {
                                i3 = (i109 * (-1808)) + i102;
                                i4 = -50725;
                            }
                            int i112 = i4 | i103;
                            int i113 = ~((i112 & iArtificialFrame3) | (i112 ^ iArtificialFrame3));
                            int i114 = (i105 ^ i100) | (i105 & i100);
                            int i115 = ~((i114 & 50724) | (i114 ^ 50724));
                            int i116 = i3 + (TypedValues.Custom.TYPE_BOOLEAN * ((i113 & i115) | (i113 ^ i115)));
                            int i117 = ~i100;
                            int i118 = ~((i117 & 50724) | (i117 ^ 50724));
                            int i119 = ~((iArtificialFrame3 & (-50725)) | ((-50725) ^ iArtificialFrame3));
                            int i120 = -(-(((i118 & i119) | (i118 ^ i119) | (~((i105 & i100) | (i105 ^ i100)))) * TypedValues.Custom.TYPE_BOOLEAN));
                            Object[] objArr14 = new Object[1];
                            b(((i116 | i120) << 1) - (i120 ^ i116), new char[]{48247, 31318, 12322, 60969, 42237, 25308, 6313, 54916, 36207, 19278, 256, 16368, 62937, 46002}, objArr14);
                            try {
                                Object[] objArr15 = {cls3.getMethod((String) objArr14[0], null).invoke(context, null), 64};
                                int i121 = -(-TextUtils.indexOf("", ""));
                                Object[] objArr16 = new Object[1];
                                b(((i121 | 49057) << 1) - (i121 ^ 49057), new char[]{48241, 991, 49974, 33409, 17147, 604, 49586, 33113, 16763, 214, 49204, 34703, 18425, 1875, 50858, 34385, 18032, 1484, 50540, 33971, 17637, 1094, 52141, 35590, 19311, 2764, 51719, 35210, 18914, 2380, 51369, 34826, 18498}, objArr16);
                                Class<?> cls4 = Class.forName((String) objArr16[0]);
                                Object[] objArr17 = new Object[1];
                                a(null, new int[]{92, 14, 163, 10}, true, objArr17);
                                Object objInvoke2 = cls4.getMethod((String) objArr17[0], String.class, Integer.TYPE).invoke(objInvoke, objArr15);
                                Object[] objArr18 = new Object[1];
                                a(new byte[]{1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1}, new int[]{b.l, 30, 0, 0}, true, objArr18);
                                Class<?> cls5 = Class.forName((String) objArr18[0]);
                                Object[] objArr19 = new Object[1];
                                b(Color.blue(0) + 61703, new char[]{48227, 19838, 24185, 28523, 30829, 2375, 6735, 11091, 13389, 50524}, objArr19);
                                Object[] objArr20 = (Object[]) cls5.getField((String) objArr19[0]).get(objInvoke2);
                                int length = objArr20.length;
                                int i122 = 0;
                                while (i122 < length) {
                                    Object obj3 = objArr20[i122];
                                    int scrollBarSize = ViewConfiguration.getScrollBarSize() >> 8;
                                    int iArtificialFrame4 = ModelManager$$ExternalSyntheticLambda1.artificialFrame();
                                    ModelManager$$ExternalSyntheticLambda1.artificialFrame();
                                    int i123 = scrollBarSize * (-1335);
                                    int i124 = (i123 ^ (-2232449)) + ((i123 & (-2232449)) << 1);
                                    int i125 = ~((scrollBarSize ^ iArtificialFrame4) | (scrollBarSize & iArtificialFrame4));
                                    int i126 = -(-(((i125 & (-3348)) | ((-3348) ^ i125)) * (-668)));
                                    int i127 = (i124 ^ i126) + ((i126 & i124) << 1);
                                    int i128 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                    int i129 = ((i128 | b.i) << 1) - (i128 ^ b.i);
                                    artificialFrame = i129 % 128;
                                    if (i129 % 2 == 0) {
                                        int i130 = ~(((-3348) ^ iArtificialFrame4) | ((-3348) & iArtificialFrame4));
                                        i5 = i127 % (1336 << ((i130 & scrollBarSize) | (scrollBarSize ^ i130)));
                                    } else {
                                        int i131 = ~(((-3348) ^ iArtificialFrame4) | ((-3348) & iArtificialFrame4));
                                        int i132 = -(-(((i131 & scrollBarSize) | (scrollBarSize ^ i131)) * 1336));
                                        i5 = (i127 & i132) + (i132 | i127);
                                    }
                                    int i133 = scrollBarSize | iArtificialFrame4;
                                    int i134 = 668 * ((i133 & (-3348)) | (i133 ^ (-3348)));
                                    Object[] objArr21 = new Object[1];
                                    b(((i5 | i134) << 1) - (i134 ^ i5), new char[]{48200, 45357, 42499, 39705, 34917}, objArr21);
                                    String str2 = (String) objArr21[0];
                                    int i135 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                    int i136 = (i135 & 13) + (i135 | 13);
                                    int i137 = i136 % 128;
                                    artificialFrame = i137;
                                    int i138 = i136 % 2;
                                    int i139 = ((i137 | 93) << 1) - (i137 ^ 93);
                                    int i140 = i139 % 128;
                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i140;
                                    if (i139 % 2 != 0) {
                                        try {
                                            objArr2 = new Object[0];
                                            objArr2[0] = str2;
                                            bArr2 = new byte[]{0, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1};
                                            iArr2 = new int[]{SyslogConstants.LOG_LOCAL1, 37, 0, 34};
                                        } catch (Throwable th) {
                                            Throwable cause = th.getCause();
                                            if (cause != null) {
                                                throw cause;
                                            }
                                            throw th;
                                        }
                                    } else {
                                        objArr2 = new Object[]{str2};
                                        bArr2 = new byte[]{0, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1};
                                        iArr2 = new int[]{SyslogConstants.LOG_LOCAL1, 37, 0, 34};
                                    }
                                    int i141 = (i140 & 7) + (i140 | 7);
                                    artificialFrame = i141 % 128;
                                    int i142 = i141 % 2;
                                    Object[] objArr22 = new Object[1];
                                    a(bArr2, iArr2, true, objArr22);
                                    Class<?> cls6 = Class.forName((String) objArr22[0]);
                                    int tapTimeout = ViewConfiguration.getTapTimeout();
                                    int i143 = artificialFrame + 93;
                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i143 % 128;
                                    int i144 = i143 % 2;
                                    Object[] objArr23 = new Object[1];
                                    b(50417 - (tapTimeout >> 16), new char[]{48247, 30852, 13702, 62090, 44986, 25814, 8642, 57062, 39926, 20490, 3359}, objArr23);
                                    Object objInvoke3 = cls6.getMethod((String) objArr23[0], String.class).invoke(null, objArr2);
                                    try {
                                        Object[] objArr24 = new Object[1];
                                        a(new byte[]{0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0}, new int[]{173, 28, 116, 18}, false, objArr24);
                                        Class<?> cls7 = Class.forName((String) objArr24[0]);
                                        Object[] objArr25 = new Object[1];
                                        a(null, new int[]{201, 11, 129, 9}, true, objArr25);
                                        try {
                                            Object[] objArr26 = {new ByteArrayInputStream((byte[]) cls7.getMethod((String) objArr25[0], null).invoke(obj3, null))};
                                            Object[] objArr27 = new Object[1];
                                            a(new byte[]{0, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, new int[]{SyslogConstants.LOG_LOCAL1, 37, 0, 34}, true, objArr27);
                                            Class<?> cls8 = Class.forName((String) objArr27[0]);
                                            Object[] objArr28 = new Object[1];
                                            b(ExpandableListView.getPackedPositionGroup(0L) + 62347, new char[]{48247, 20478, 23400, 26324, 29262, 32198, 2342, 5304, 8203, 13206, 16140, 51869, 55037, 57977, 60899, 63830, 33985, 36959, 41907}, objArr28);
                                            Object objInvoke4 = cls8.getMethod((String) objArr28[0], InputStream.class).invoke(objInvoke3, objArr26);
                                            int i145 = artificialFrame + 89;
                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i145 % 128;
                                            if (i145 % 2 != 0) {
                                                int length2 = objArr5.length;
                                                i6 = 1;
                                            } else {
                                                int length3 = objArr5.length;
                                                i6 = 0;
                                            }
                                            for (int i146 = 2; i6 < i146; i146 = 2) {
                                                int i147 = artificialFrame;
                                                int i148 = (i147 ^ 11) + ((i147 & 11) << 1);
                                                getARTIFICIAL_FRAME_PACKAGE_NAME = i148 % 128;
                                                if (i148 % i146 != 0) {
                                                    obj = objArr5[i6];
                                                    int i149 = 26 / 0;
                                                } else {
                                                    obj = objArr5[i6];
                                                }
                                                try {
                                                    int i150 = -(-(SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)));
                                                    Object[] objArr29 = new Object[1];
                                                    b((i150 ^ 46600) + ((i150 & 46600) << 1), new char[]{48250, 2680, 53364, 40554, 25626, 12878, 63555, 17996, 3117, 55859, 40995, 28167, 13317, 33355, 18445, 5874, 56562, 43773, 28828, 16099, 33937, 21149, 6383, 59036, 44205, 31363, 49294, 36490, 21642, 9084, 59773, 46950, 32068, 52060}, objArr29);
                                                    String str3 = (String) objArr29[0];
                                                    int i151 = artificialFrame + 69;
                                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i151 % 128;
                                                    if (i151 % 2 != 0) {
                                                        cls = Class.forName(str3);
                                                        Object[] objArr30 = new Object[1];
                                                        a(new byte[]{0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0}, new int[]{212, 23, 0, 0}, false, objArr30);
                                                        obj2 = objArr30[0];
                                                    } else {
                                                        cls = Class.forName(str3);
                                                        Object[] objArr31 = new Object[1];
                                                        a(new byte[]{0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0}, new int[]{212, 23, 0, 0}, true, objArr31);
                                                        obj2 = objArr31[0];
                                                    }
                                                    if (obj.equals(cls.getMethod((String) obj2, null).invoke(objInvoke4, null))) {
                                                        int i152 = (i & (-2)) | (i91 & 1);
                                                        Object[] objArr32 = new Object[4];
                                                        int i153 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                        int i154 = i153 + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
                                                        artificialFrame = i154 % 128;
                                                        int i155 = i154 % 2;
                                                        int[] iArr3 = new int[1];
                                                        objArr32[0] = iArr3;
                                                        int[] iArr4 = new int[1];
                                                        objArr32[1] = iArr4;
                                                        int[] iArr5 = new int[1];
                                                        objArr32[2] = iArr5;
                                                        int i156 = (i153 & b.i) + (i153 | b.i);
                                                        artificialFrame = i156 % 128;
                                                        int i157 = i156 % 2 == 0 ? 38 : 16;
                                                        iArr3[0] = i;
                                                        int i158 = i153 + 31;
                                                        artificialFrame = i158 % 128;
                                                        int i159 = i158 % 2;
                                                        iArr4[0] = i152;
                                                        objArr32[3] = null;
                                                        int i160 = i153 + 59;
                                                        artificialFrame = i160 % 128;
                                                        int i161 = i160 % 2;
                                                        int i162 = 1735012142 + ((~(i | 222627330)) * JfifUtil.MARKER_SOI) + (((-537563421) | i91) * (-216)) + (((~(222627330 | i91)) | 755996444) * JfifUtil.MARKER_SOI) + i157;
                                                        int i163 = ((i2 | i162) << 1) - (i2 ^ i162);
                                                        int i164 = i163 << 13;
                                                        int i165 = (i163 | i164) & (~(i163 & i164));
                                                        int i166 = i165 ^ (i165 >>> 17);
                                                        int i167 = (i153 & 19) + (i153 | 19);
                                                        artificialFrame = i167 % 128;
                                                        int i168 = i166 << 5;
                                                        if (i167 % 2 == 0) {
                                                            iArr5[1] = ((~i166) & i168) | ((~i168) & i166);
                                                        } else {
                                                            iArr5[0] = ((~i166) & i168) | ((~i168) & i166);
                                                        }
                                                        return objArr32;
                                                    }
                                                    i6++;
                                                } catch (Throwable th2) {
                                                    Throwable cause2 = th2.getCause();
                                                    if (cause2 != null) {
                                                        throw cause2;
                                                    }
                                                    throw th2;
                                                }
                                            }
                                            i122++;
                                            int i169 = artificialFrame + 93;
                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i169 % 128;
                                            if (i169 % 2 != 0) {
                                                int i170 = 4 / 2;
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
        int[] iArr6 = new int[1];
        int i171 = getARTIFICIAL_FRAME_PACKAGE_NAME + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
        int i172 = i171 % 128;
        artificialFrame = i172;
        int i173 = i171 % 2;
        Object[] objArr33 = {new int[]{i}, new int[]{i}, iArr6, null};
        int i174 = (-1639129168) + (((~((-728999807) | i)) | 174105888) * 345);
        int i175 = ~i;
        int i176 = i174 + (((~((-728999807) | i175)) | 75518080) * 345) + ((~((-174105889) | i)) * 345);
        int i177 = i176 * (-115);
        int i178 = (~((i175 & i176) | (i175 ^ i176))) * (-116);
        int i179 = (i177 ^ i178) + ((i177 & i178) << 1);
        int i180 = i * 116;
        int i181 = ((i179 | i180) << 1) - (i180 ^ i179);
        int i182 = (i172 ^ 85) + ((i172 & 85) << 1);
        int i183 = i182 % 128;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i183;
        int i184 = i182 % 2;
        int i185 = i2 + i181 + (116 * (~(i | (~i176))));
        int i186 = i185 << 13;
        int i187 = (i185 | i186) & (~(i185 & i186));
        int i188 = i183 + 33;
        artificialFrame = i188 % 128;
        int i189 = i188 % 2;
        int i190 = i187 >>> 17;
        int i191 = (i187 | i190) & (~(i187 & i190));
        int i192 = i191 << 5;
        iArr6[0] = ((~i191) & i192) | ((~i192) & i191);
        return objArr33;
    }
}
