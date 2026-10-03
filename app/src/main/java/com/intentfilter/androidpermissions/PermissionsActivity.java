package com.intentfilter.androidpermissions;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Bundle;
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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.ActivityCompat;
import androidx.core.view.ViewCompat;
import com.facebook.imageutils.JfifUtil;
import com.google.android.material.carousel.KeylineState;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.intentfilter.androidpermissions.helpers.Logger;
import com.intentfilter.androidpermissions.models.DeniedPermission;
import com.intentfilter.androidpermissions.models.DeniedPermissions;
import com.intentfilter.androidpermissions.services.BroadcastService;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import kotlin.time.DurationKt;
import o.ArtificialStackFrames;
import o.artificialFrame;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: loaded from: classes3.dex */
public class PermissionsActivity extends AppCompatActivity {
    private static final byte[] $$a;
    private static final int $$b;
    private static final byte[] $$d;
    private static final int $$e;
    static final String EXTRA_PERMISSIONS = "com.intentfilter.androidpermissions.PERMISSIONS";
    public static final String EXTRA_PERMISSIONS_DENIED = "com.intentfilter.androidpermissions.PERMISSIONS_DENIED";
    public static final String EXTRA_PERMISSIONS_GRANTED = "com.intentfilter.androidpermissions.PERMISSIONS_GRANTED";
    private static int[] ICustomTabsCallbackStub = null;
    static final int PERMISSIONS_REQUEST_CODE = 100;
    private static int artificialFrame;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;
    static final Logger logger;
    private static final byte[] $$c = {38, -81, -30, 49};
    private static final int $$f = 172;
    private static int $10 = 0;
    private static int $11 = 1;

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$g(short r6, int r7, int r8) {
        /*
            int r6 = r6 * 6
            int r6 = 115 - r6
            int r7 = r7 + 4
            byte[] r0 = com.intentfilter.androidpermissions.PermissionsActivity.$$c
            int r8 = r8 * 2
            int r1 = 1 - r8
            byte[] r1 = new byte[r1]
            r2 = 0
            int r8 = 0 - r8
            if (r0 != 0) goto L17
            r6 = r7
            r3 = r8
            r4 = r2
            goto L2c
        L17:
            r3 = r2
        L18:
            byte r4 = (byte) r6
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r8) goto L25
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            return r6
        L25:
            int r7 = r7 + 1
            r3 = r0[r7]
            r5 = r7
            r7 = r6
            r6 = r5
        L2c:
            int r7 = r7 + r3
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.intentfilter.androidpermissions.PermissionsActivity.$$g(short, int, int):java.lang.String");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0021  */
    /* JADX WARN: Code duplicated, block: B:8:0x0019  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0021 -> B:11:0x0023). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0021
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void b(short r6, byte r7, int r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 + 4
            int r7 = 112 - r7
            byte[] r0 = com.intentfilter.androidpermissions.PermissionsActivity.$$a
            int r8 = 21 - r8
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L11
            r3 = r6
            r7 = r8
            r4 = r2
            goto L23
        L11:
            r3 = r2
        L12:
            int r4 = r3 + 1
            byte r5 = (byte) r7
            r1[r3] = r5
            if (r4 != r8) goto L21
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L21:
            r3 = r0[r6]
        L23:
            int r6 = r6 + 1
            int r3 = -r3
            int r7 = r7 + r3
            r3 = r4
            goto L12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.intentfilter.androidpermissions.PermissionsActivity.b(short, byte, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0021  */
    /* JADX WARN: Code duplicated, block: B:8:0x0019  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0021 -> B:11:0x002a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0021
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void c(int r6, int r7, byte r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = com.intentfilter.androidpermissions.PermissionsActivity.$$d
            int r1 = r6 + 1
            int r8 = 111 - r8
            int r7 = 594 - r7
            byte[] r1 = new byte[r1]
            r2 = 0
            if (r0 != 0) goto L11
            r3 = r8
            r4 = r2
            r8 = r7
            goto L2a
        L11:
            r3 = r2
        L12:
            int r7 = r7 + 1
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r6) goto L21
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L21:
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r8
            r8 = r7
            r7 = r4
            r4 = r3
            r3 = r5
        L2a:
            int r3 = r3 + r7
            int r7 = r3 + (-4)
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.intentfilter.androidpermissions.PermissionsActivity.c(int, int, byte, java.lang.Object[]):void");
    }

    static {
        byte[] bArr = new byte[638];
        System.arraycopy("\fm>\u0099\u0010\u0002Å=\f\u0004ü\týÍ<\u0007\r÷\u0001\u0003\u0016öÍ9\u0010\u0002\u0007\u0003\u0003û\r\n\u0003¿\u00190\u0002\u0007\u0003\u0003û\r\n0\u0007\u0001\n\u0003ù\tûã%\u0001\u0017ö\u0004\u0006\týè-\u0010\u0002Å=\f\u0004ü\týÍ7\u0011ú\u0012\u0001þÿÎ=\n\n¿?\t\nõ\u0011\u0000÷\u000fÆC\u0003\u0003\u0002\u000fï\u001b÷\u000eú\n\u0003õ\u0007\u0003\u0015õ\u0010ù\u0005þ\u0007\u0017ýú\fý\u0003ÎP\u0004ï\u0004A\u0010\u0002ÅH÷\u0000\u0006\u0015þ÷\u0017ù\u0011ó\u0002\u0010\u0002\u0004\fýÿ\u000f\t¹7\u0016\nùù\u0014\u0005ÿ\u0007ó\n\u0002Í$\u0017\u0017ù\u0011óà6\nùùô%ÿ\u0007ó\n\u0002ì&ù\u0015ûýò!ù\u0002\u0010\u0002Å<ÿ\u0006\u0006\u0001\u0011\u0004\u0000ÇH÷\u0000\u0006\u0015¾Kø\bø\u0011÷\n\u0002\u0011À/\u001aüþñ%ù\u0005ï#\u0004\u0001¼\u0004%7\u0000õ\u0011\u0000÷\u000fë*ù\nø\u0001\u0013ùþí\u0019\u0010ù\u0006\u0001Ó\u0010\u0002Å=\f\u0004ü\týÍ7\u0013ýÉ'(þ\tñó&\u0001\tÿ\tÊG\u0002\b¿B\u0007üÿ\u0003\u0006\fÇ9\u0010\u0007÷ÍI\u0001ýÉ\u0019:î\r\u0001þã7õ\u0004\u0003\u0011æ\"ó\u0006\fþ\u0011\u0010\u0002Å=\f\u0004ü\týÍ7\u0011ú\u0012\u0001þÿÎ=\n\n¿?\t\nõ\u0011\u0000÷\u000fÆC\u0003\u0003\u0002\u000fï\u001b÷\u000eú\n\u0003õ\u0007\u0003\u0015õ\u0010ù\u0005ÍP\u0004ì\u001c\u0006\u0004\u0006\u0012\u0004ò\u0015\u0006ù\u0001\u0007þ\nü\u000fÞ0ó\u0010ü\u0010\u0002Å=\f\u0004ü\týÍC\u0003\u0003\u0002\u000f¾9\u0010\u0002\u0004\u0006\u0003ÄIõ\u000b\u0002\t\nõ\u0011\u0000÷\u000fÆP\u0004û\u0007ùËIú\b\u0007\u0000ý\u0005\u0010ó\u0010ü\u0016ü\u0007ýÇNù\u0003ÆI\u0005\u0002ó\u0017õ\u0006\u0016¹(\u0017\u0005\u0003\u0011÷\rù\u0006\u0010\u0007\u0001\n\u0003ù\tûâ3÷\u0000\u0017ù\n\u0003\u0010\u0002Å?\bø\n\u0002\u000fýþ\fþ\u0011À\u001f(ø\n\u0002ï\u001dþ\fþ\u0011ß&ù\u0015ûýè(\u0007\u0000\u0010\u0002Å<ÿ\u0006\u0006\u0001\u0011\u0004\u0000Ç?\bø\n\u0002\u000fý\u000bù\u000b\u0001\tûÍ9\u0010\u0007÷Í&&\u0001ù\u0015ò\u0006\u0011å\u0016\u0010\bô\rù\u0006å\u001f\u0006\u0015ÿ\u0007\u000b¯#0\u0002\u0007õ\u0011ÿ\n\u0003\u0000\u0001\u0010\u0004\u0000Çÿ?\t\nõ\u0011\u0000÷\u000fÆM\u0000¿(\u0017\u0000\u000fï\u0012\u0001õ ø\fþ\u0013´7\u001fû\u000fõ\u0011æ\u0011\u0016ü".getBytes(CharEncoding.ISO_8859_1), 0, bArr, 0, 638);
        $$d = bArr;
        $$e = JfifUtil.MARKER_RST0;
        $$a = new byte[]{103, -8, -85, 41, -5, 1, 33, -33, 2, 9, -5, 7, -5, 1, 50, -39, -11, 7, Ascii.FF, -15, 9, -18, 34, -25, -4, 17, -19, Ascii.SI, 1, Ascii.DC2, -15, -19, Ascii.VT, -5, 7, 2, -15, 36, -21, -13, Ascii.SI, -2, -9, -6, 34, -15, -19, Ascii.VT, -5, 7, -49, -2, Ascii.VT, 3, -3, 6, -6, 8, -11, Ascii.EM, -33, 19, -2, -8, 37, -44, 17, -12, 8, -14, 2, -15, 33, -33, 19, -17, 32, -15, -19, Ascii.VT, -5, 7, -10, Ascii.US, -20, -13, 8, Ascii.VT, Ascii.CR, -27, 9, -18, 36, -33, 19, -17, 32, -15, -19, Ascii.VT, -5, 7, 7, -18, 43, -29, 4, -17, -2, -27, -1, 7, 6, 33, -51, Ascii.FF, -3, 8, -1, -13};
        $$b = 18;
        getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        artificialFrame = 1;
        accessartificialFrame();
        logger = Logger.loggerFor(PermissionsActivity.class);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ActivityCompat.requestPermissions(this, getIntent().getStringArrayExtra(EXTRA_PERMISSIONS), 100);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (iArr.length == 0 || strArr.length == 0) {
            logger.e("Permission request interrupted. Aborting.");
            PermissionManager.getInstance(this).removePendingPermissionRequests(Arrays.asList(getIntent().getStringArrayExtra(EXTRA_PERMISSIONS)));
            finish();
            return;
        }
        logger.i("RequestPermissionsResult, sending broadcast for permissions " + Arrays.toString(strArr));
        sendPermissionResponse(strArr, iArr);
        finish();
    }

    private void sendPermissionResponse(@NonNull String[] strArr, @NonNull int[] iArr) {
        HashSet hashSet = new HashSet();
        DeniedPermissions deniedPermissions = new DeniedPermissions();
        for (int i = 0; i < strArr.length; i++) {
            if (iArr[i] == 0) {
                hashSet.add(strArr[i]);
            } else {
                deniedPermissions.add(new DeniedPermission(strArr[i], ActivityCompat.shouldShowRequestPermissionRationale(this, strArr[i])));
            }
        }
        new BroadcastService(this).broadcastPermissionRequestResult(hashSet, deniedPermissions);
    }

    private static void a(int i, int[] iArr, Object[] objArr) throws Throwable {
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
        int i6 = 16;
        int i7 = 1;
        int i8 = 0;
        if (iArr3 != null) {
            int i9 = $10 + 43;
            $11 = i9 % 128;
            if (i9 % 2 == 0) {
                length = iArr3.length;
                iArr2 = new int[length];
                i2 = 1;
            } else {
                length = iArr3.length;
                iArr2 = new int[length];
                i2 = 0;
            }
            while (i2 < length) {
                int i10 = $10 + 119;
                $11 = i10 % 128;
                if (i10 % i3 == 0) {
                    try {
                        Object[] objArr2 = {Integer.valueOf(iArr3[i2])};
                        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(i5);
                        if (objAccessartificialFrame == null) {
                            byte b = (byte) 1;
                            byte b2 = (byte) (-b);
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(11 - (ViewConfiguration.getJumpTapTimeout() >> i6), (char) ((Process.getThreadPriority(0) + 20) >> 6), (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 1561, 180153818, false, $$g(b, b2, (byte) (b2 + 1)), new Class[]{Integer.TYPE});
                        }
                        iArr2[i2] = ((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
                        i2 = 0;
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                } else {
                    Object[] objArr3 = {Integer.valueOf(iArr3[i2])};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1780896814);
                    if (objAccessartificialFrame2 == null) {
                        byte b3 = (byte) 1;
                        byte b4 = (byte) (-b3);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(10 - ExpandableListView.getPackedPositionChild(0L), (char) (ViewConfiguration.getKeyRepeatDelay() >> 16), 1562 - (KeyEvent.getMaxKeyCode() >> 16), 180153818, false, $$g(b3, b4, (byte) (b4 + 1)), new Class[]{Integer.TYPE});
                    }
                    iArr2[i2] = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
                    i2++;
                }
                i3 = 2;
                i5 = -1780896814;
                i6 = 16;
            }
            iArr3 = iArr2;
        }
        int length2 = iArr3.length;
        int[] iArr4 = new int[length2];
        int[] iArr5 = ICustomTabsCallbackStub;
        if (iArr5 != null) {
            int i11 = $10 + 97;
            $11 = i11 % 128;
            int i12 = i11 % 2;
            int length3 = iArr5.length;
            int[] iArr6 = new int[length3];
            int i13 = 0;
            while (i13 < length3) {
                Object[] objArr4 = new Object[i7];
                objArr4[i8] = Integer.valueOf(iArr5[i13]);
                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1780896814);
                if (objAccessartificialFrame3 == null) {
                    int longPressTimeout = (ViewConfiguration.getLongPressTimeout() >> 16) + 11;
                    char defaultSize = (char) View.getDefaultSize(i8, i8);
                    int iBlue = 1562 - Color.blue(i8);
                    byte b5 = (byte) i7;
                    byte b6 = (byte) (-b5);
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(longPressTimeout, defaultSize, iBlue, 180153818, false, $$g(b5, b6, (byte) (b6 + 1)), new Class[]{Integer.TYPE});
                }
                iArr6[i13] = ((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue();
                i13++;
                i7 = 1;
                i8 = 0;
            }
            iArr5 = iArr6;
        }
        int i14 = i8;
        System.arraycopy(iArr5, i14, iArr4, i14, length2);
        artificialframe.e = i14;
        while (artificialframe.e < iArr.length) {
            cArr[i14] = (char) (iArr[artificialframe.e] >> 16);
            cArr[1] = (char) iArr[artificialframe.e];
            cArr[2] = (char) (iArr[artificialframe.e + 1] >> 16);
            cArr[3] = (char) iArr[artificialframe.e + 1];
            artificialframe.c = (cArr[0] << 16) + cArr[1];
            artificialframe.b = (cArr[2] << 16) + cArr[3];
            artificialFrame.coroutineBoundary(iArr4);
            int i15 = 0;
            for (int i16 = 16; i15 < i16; i16 = 16) {
                artificialframe.c ^= iArr4[i15];
                Object[] objArr5 = {artificialframe, Integer.valueOf(artificialFrame.coroutineBoundary(artificialframe.c)), artificialframe, artificialframe};
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1540318455);
                if (objAccessartificialFrame4 == null) {
                    byte b7 = (byte) 0;
                    byte b8 = (byte) (b7 - 1);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(Color.argb(0, 0, 0, 0) + 26, (char) TextUtils.getCapsMode("", 0, 0), Color.argb(0, 0, 0, 0) + 1041, 995482881, false, $$g(b7, b8, (byte) (b8 + 1)), new Class[]{Object.class, Integer.TYPE, Object.class, Object.class});
                }
                int iIntValue = ((Integer) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).intValue();
                artificialframe.c = artificialframe.b;
                artificialframe.b = iIntValue;
                i15++;
            }
            int i17 = artificialframe.c;
            artificialframe.c = artificialframe.b;
            artificialframe.b = i17;
            artificialframe.b ^= iArr4[16];
            artificialframe.c ^= iArr4[17];
            int i18 = artificialframe.c;
            int i19 = artificialframe.b;
            cArr[0] = (char) (artificialframe.c >>> 16);
            cArr[1] = (char) artificialframe.c;
            cArr[2] = (char) (artificialframe.b >>> 16);
            cArr[3] = (char) artificialframe.b;
            artificialFrame.coroutineBoundary(iArr4);
            cArr2[artificialframe.e * 2] = cArr[0];
            cArr2[(artificialframe.e * 2) + 1] = cArr[1];
            cArr2[(artificialframe.e * 2) + 2] = cArr[2];
            cArr2[(artificialframe.e * 2) + 3] = cArr[3];
            Object[] objArr6 = {artificialframe, artificialframe};
            Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(1348396126);
            if (objAccessartificialFrame5 == null) {
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 37, (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 28009), TextUtils.getOffsetAfter("", 0) + 306, -818175402, false, "q", new Class[]{Object.class, Object.class});
            }
            ((Method) objAccessartificialFrame5).invoke(null, objArr6);
            i14 = 0;
        }
        String str = new String(cArr2, 0, i);
        int i20 = $10 + 31;
        $11 = i20 % 128;
        if (i20 % 2 == 0) {
            Object obj = null;
            obj.hashCode();
            throw null;
        }
        objArr[0] = str;
    }

    /* JADX WARN: Code duplicated, block: B:118:0x0c20  */
    /* JADX WARN: Code duplicated, block: B:121:0x0c29 A[Catch: all -> 0x259d, TryCatch #9 {all -> 0x259d, blocks: (B:326:0x22e7, B:328:0x230a, B:329:0x2352, B:159:0x10ee, B:161:0x1103, B:162:0x1130, B:119:0x0c23, B:121:0x0c29, B:122:0x0c59, B:124:0x0c84, B:125:0x0d10, B:41:0x047d, B:43:0x048a, B:44:0x04b8, B:46:0x04c4, B:48:0x04d1, B:49:0x0503), top: B:395:0x047d }] */
    /* JADX WARN: Code duplicated, block: B:124:0x0c84 A[Catch: all -> 0x259d, TryCatch #9 {all -> 0x259d, blocks: (B:326:0x22e7, B:328:0x230a, B:329:0x2352, B:159:0x10ee, B:161:0x1103, B:162:0x1130, B:119:0x0c23, B:121:0x0c29, B:122:0x0c59, B:124:0x0c84, B:125:0x0d10, B:41:0x047d, B:43:0x048a, B:44:0x04b8, B:46:0x04c4, B:48:0x04d1, B:49:0x0503), top: B:395:0x047d }] */
    /* JADX WARN: Code duplicated, block: B:128:0x0d23  */
    /* JADX WARN: Code duplicated, block: B:133:0x0d8e  */
    /* JADX WARN: Code duplicated, block: B:158:0x10d0  */
    /* JADX WARN: Code duplicated, block: B:161:0x1103 A[Catch: all -> 0x259d, TryCatch #9 {all -> 0x259d, blocks: (B:326:0x22e7, B:328:0x230a, B:329:0x2352, B:159:0x10ee, B:161:0x1103, B:162:0x1130, B:119:0x0c23, B:121:0x0c29, B:122:0x0c59, B:124:0x0c84, B:125:0x0d10, B:41:0x047d, B:43:0x048a, B:44:0x04b8, B:46:0x04c4, B:48:0x04d1, B:49:0x0503), top: B:395:0x047d }] */
    /* JADX WARN: Code duplicated, block: B:165:0x1147  */
    /* JADX WARN: Code duplicated, block: B:170:0x11b6  */
    /* JADX WARN: Code duplicated, block: B:229:0x174e  */
    /* JADX WARN: Code duplicated, block: B:230:0x17bd  */
    /* JADX WARN: Code duplicated, block: B:232:0x17c9  */
    /* JADX WARN: Code duplicated, block: B:235:0x17cd A[LOOP:1: B:233:0x17ca->B:235:0x17cd, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:241:0x18d4  */
    /* JADX WARN: Code duplicated, block: B:251:0x1a14  */
    /* JADX WARN: Code duplicated, block: B:255:0x1a99  */
    /* JADX WARN: Code duplicated, block: B:260:0x1b09  */
    /* JADX WARN: Code duplicated, block: B:264:0x1b67  */
    /* JADX WARN: Code duplicated, block: B:265:0x1bd9  */
    /* JADX WARN: Code duplicated, block: B:270:0x1cc6  */
    /* JADX WARN: Code duplicated, block: B:273:0x1d19  */
    /* JADX WARN: Code duplicated, block: B:275:0x1d37  */
    /* JADX WARN: Code duplicated, block: B:277:0x1d40  */
    /* JADX WARN: Code duplicated, block: B:280:0x1e26  */
    /* JADX WARN: Code duplicated, block: B:281:0x1e28  */
    /* JADX WARN: Code duplicated, block: B:284:0x1e2f  */
    /* JADX WARN: Code duplicated, block: B:286:0x1e99  */
    /* JADX WARN: Code duplicated, block: B:291:0x1ea9  */
    /* JADX WARN: Code duplicated, block: B:296:0x1f36  */
    /* JADX WARN: Code duplicated, block: B:298:0x1f3f  */
    /* JADX WARN: Code duplicated, block: B:303:0x1fb1  */
    /* JADX WARN: Code duplicated, block: B:309:0x2015  */
    /* JADX WARN: Code duplicated, block: B:310:0x20be  */
    /* JADX WARN: Code duplicated, block: B:315:0x21ad  */
    /* JADX WARN: Code duplicated, block: B:318:0x21fa  */
    /* JADX WARN: Code duplicated, block: B:325:0x22c9  */
    /* JADX WARN: Code duplicated, block: B:328:0x230a A[Catch: all -> 0x259d, TryCatch #9 {all -> 0x259d, blocks: (B:326:0x22e7, B:328:0x230a, B:329:0x2352, B:159:0x10ee, B:161:0x1103, B:162:0x1130, B:119:0x0c23, B:121:0x0c29, B:122:0x0c59, B:124:0x0c84, B:125:0x0d10, B:41:0x047d, B:43:0x048a, B:44:0x04b8, B:46:0x04c4, B:48:0x04d1, B:49:0x0503), top: B:395:0x047d }] */
    /* JADX WARN: Code duplicated, block: B:332:0x2364  */
    /* JADX WARN: Code duplicated, block: B:337:0x23ca  */
    /* JADX WARN: Code duplicated, block: B:341:0x241c  */
    /* JADX WARN: Code duplicated, block: B:342:0x2489  */
    /* JADX WARN: Code duplicated, block: B:344:0x2495  */
    /* JADX WARN: Code duplicated, block: B:347:0x2499 A[LOOP:0: B:345:0x2496->B:347:0x2499, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:69:0x076d  */
    /* JADX WARN: Code duplicated, block: B:72:0x0774  */
    /* JADX WARN: Code duplicated, block: B:74:0x07cd  */
    /* JADX WARN: Code duplicated, block: B:76:0x07d1  */
    /* JADX WARN: Code duplicated, block: B:80:0x07dd  */
    /* JADX WARN: Code duplicated, block: B:84:0x0873  */
    /* JADX WARN: Code duplicated, block: B:86:0x087c  */
    /* JADX WARN: Code duplicated, block: B:91:0x08ee  */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onStart() throws Throwable {
        Object[] objArr;
        int i;
        int i2;
        Object[] objArr2;
        int i3;
        Object objAccessartificialFrame;
        Object objAccessartificialFrame2;
        Object[] objArr3;
        Object objAccessartificialFrame3;
        Object objAccessartificialFrame4;
        Object objAccessartificialFrame5;
        Object[] objArrAccessartificialFrame$78cbbd35;
        Object objAccessartificialFrame6;
        Object objAccessartificialFrame7;
        int i4;
        Object[] objArr4;
        char c;
        int i5;
        int i6;
        ArrayList arrayList;
        String[] strArr;
        int i7;
        Object objAccessartificialFrame8;
        long j;
        Object[] objArr5;
        Object objAccessartificialFrame9;
        Object objAccessartificialFrame10;
        int i8;
        int i9;
        int i10;
        Object objAccessartificialFrame11;
        long j2;
        int i11;
        Context baseContext;
        Object[] objArr6;
        Object objAccessartificialFrame12;
        Object objAccessartificialFrame13;
        int i12;
        int i13;
        int i14;
        Object objAccessartificialFrame14;
        long j3;
        Object objAccessartificialFrame15;
        Object objAccessartificialFrame16;
        Object objAccessartificialFrame17;
        Object[] objArr7;
        int i15;
        int i16;
        ArrayList arrayList2;
        String[] strArr2;
        int i17;
        Object objAccessartificialFrame18;
        Context baseContext2;
        Object objAccessartificialFrame19;
        Object objAccessartificialFrame20;
        int i18 = 2 % 2;
        Object[] objArr8 = new Object[1];
        a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 27, new int[]{721578335, -1565849910, -2013940550, -695591454, 776370029, -1075895906, 77418597, 185607679, -548190626, 1264014842, -1929241007, 392198446}, objArr8);
        String str = (String) objArr8[0];
        Object[] objArr9 = new Object[1];
        a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(20) - 84, new int[]{-1501823017, 1270962718, -171413344, -969408767, 1037446900, -779947746, -2099513253, -908342076}, objArr9);
        String str2 = (String) objArr9[0];
        Object[] objArr10 = new Object[1];
        a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 20, new int[]{-517413556, -1248007819, 952129232, -1812122499, 167904363, -1248444044, 1370902927, 476569326}, objArr10);
        String str3 = (String) objArr10[0];
        Object[] objArr11 = new Object[1];
        a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(3) - 99, new int[]{-1519391270, -2054469892, -258456670, -822058583, -626898694, 1527937918, -687209262, -1307792301}, objArr11);
        String str4 = (String) objArr11[0];
        Object objAccessartificialFrame21 = ArtificialStackFrames.accessartificialFrame(1745676544);
        if (objAccessartificialFrame21 == null) {
            int maxKeyCode = (KeyEvent.getMaxKeyCode() >> 16) + 17;
            char tapTimeout = (char) (ViewConfiguration.getTapTimeout() >> 16);
            int iMyTid = 747 - (Process.myTid() >> 22);
            byte[] bArr = $$a;
            byte b = (byte) (bArr[5] - 1);
            Object[] objArr12 = new Object[1];
            b(b, b, bArr[18], objArr12);
            objAccessartificialFrame21 = ArtificialStackFrames.coroutineCreation(maxKeyCode, tapTimeout, iMyTid, -144068856, false, (String) objArr12[0], null);
        }
        long j4 = ((Field) objAccessartificialFrame21).getLong(null);
        if (j4 == -1 || j4 + DurationKt.MAX_MILLIS < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext3 = getBaseContext();
            if (baseContext3 == null) {
                Object[] objArr13 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 9, new int[]{721578335, -1565849910, -2013940550, -695591454, 1577959775, 1568303289, -313253021, -1695859094, 634303605, -509814910, -1495177834, -540186052, -756860588, 1186567138}, objArr13);
                Class<?> cls = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                a((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 18, new int[]{251814919, 1633520329, -1093159096, -1871449063, -1297860173, 1957793086, 1873867491, -1451760763, -1519411634, -1318508961}, objArr14);
                baseContext3 = (Context) cls.getMethod((String) objArr14[0], new Class[0]).invoke(null, null);
            }
            if (baseContext3 != null) {
                baseContext3 = ((baseContext3 instanceof ContextWrapper) && ((ContextWrapper) baseContext3).getBaseContext() == null) ? null : baseContext3.getApplicationContext();
            }
            try {
                Object[] objArr15 = {baseContext3, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 181900080};
                byte[] bArr2 = $$d;
                Object[] objArr16 = new Object[1];
                c(bArr2[272], (short) 591, bArr2[0], objArr16);
                Class<?> cls2 = Class.forName((String) objArr16[0]);
                Object[] objArr17 = new Object[1];
                c(bArr2[248], (short) 552, (byte) (bArr2[61] - 1), objArr17);
                Object[] objArr18 = (Object[]) cls2.getMethod((String) objArr17[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr15);
                Object objAccessartificialFrame22 = ArtificialStackFrames.accessartificialFrame(1575402270);
                if (objAccessartificialFrame22 == null) {
                    int i19 = (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 16;
                    char minimumFlingVelocity = (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16);
                    int i20 = (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 746;
                    byte[] bArr3 = $$a;
                    Object[] objArr19 = new Object[1];
                    b(bArr3[57], (byte) (bArr3[5] - 1), bArr3[18], objArr19);
                    objAccessartificialFrame22 = ArtificialStackFrames.coroutineCreation(i19, minimumFlingVelocity, i20, -1031537386, false, (String) objArr19[0], null);
                }
                ((Field) objAccessartificialFrame22).set(null, objArr18);
                try {
                    Long lValueOf = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(1745676544);
                    if (objAccessartificialFrame23 == null) {
                        int i21 = 18 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                        char edgeSlop = (char) (ViewConfiguration.getEdgeSlop() >> 16);
                        int i22 = (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 746;
                        byte[] bArr4 = $$a;
                        byte b2 = (byte) (bArr4[5] - 1);
                        Object[] objArr20 = new Object[1];
                        b(b2, b2, bArr4[18], objArr20);
                        objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(i21, edgeSlop, i22, -144068856, false, (String) objArr20[0], null);
                    }
                    ((Field) objAccessartificialFrame23).set(null, lValueOf);
                    objArr = objArr18;
                } catch (Exception unused) {
                    throw new RuntimeException();
                }
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        } else {
            Object objAccessartificialFrame24 = ArtificialStackFrames.accessartificialFrame(1575402270);
            if (objAccessartificialFrame24 == null) {
                int offsetAfter = TextUtils.getOffsetAfter("", 0) + 17;
                char maxKeyCode2 = (char) (KeyEvent.getMaxKeyCode() >> 16);
                int absoluteGravity = Gravity.getAbsoluteGravity(0, 0) + 747;
                byte[] bArr5 = $$a;
                Object[] objArr21 = new Object[1];
                b(bArr5[57], (byte) (bArr5[5] - 1), bArr5[18], objArr21);
                objAccessartificialFrame24 = ArtificialStackFrames.coroutineCreation(offsetAfter, maxKeyCode2, absoluteGravity, -1031537386, false, (String) objArr21[0], null);
            }
            Object[] objArr22 = (Object[]) ((Field) objAccessartificialFrame24).get(null);
            objArr = new Object[]{list, new int[1], list, new int[]{i}, new int[]{i}};
            int i23 = ((int[]) objArr22[3])[0];
            int i24 = ((int[]) objArr22[4])[0];
            List list = (List) objArr22[0];
            List list2 = (List) objArr22[2];
            int i25 = ~(System.identityHashCode(this) | (-287358156));
            int i26 = (((-363657253) + (((-892806614) | i25) * (-220))) + ((i25 | 38922) * 220)) - 2001483810;
            int i27 = (i26 << 13) ^ i26;
            int i28 = i27 ^ (i27 >>> 17);
            ((int[]) objArr[1])[0] = i28 ^ (i28 << 5);
        }
        int i29 = ((int[]) objArr[4])[0];
        int i30 = ((int[]) objArr[3])[0];
        if (i30 == i29) {
            Object[] objArr23 = {list, new int[1], list, new int[]{i}, new int[]{i}};
            int i31 = ((int[]) objArr[1])[0];
            int i32 = ((int[]) objArr[3])[0];
            int i33 = ((int[]) objArr[4])[0];
            List list3 = (List) objArr[0];
            List list4 = (List) objArr[2];
            int i34 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().uiMode;
            int i35 = ~(1041504082 | i34);
            int i36 = i31 + 1843670078 + (((-1073594203) | i35) * (-814)) + ((i35 | (~(436055624 | (~i34))) | 403965504) * 407) + (((~(i34 | (-436055625))) | 403965504 | (~((-1041504083) | i34))) * 407);
            int i37 = i36 ^ (i36 << 13);
            int i38 = i37 ^ (i37 >>> 17);
            ((int[]) objArr23[1])[0] = i38 ^ (i38 << 5);
            i = 0;
        } else {
            ArrayList arrayList3 = new ArrayList();
            try {
                Object[] objArr24 = {objArr};
                Object objAccessartificialFrame25 = ArtificialStackFrames.accessartificialFrame(1804664566);
                if (objAccessartificialFrame25 == null) {
                    objAccessartificialFrame25 = ArtificialStackFrames.coroutineCreation(Process.getGidForName("") + 42, (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 12467), KeyEvent.keyCodeFromString("") + 3642, -185222914, false, "coroutineCreation", new Class[]{Object[].class});
                }
                arrayList3.add(((Method) objAccessartificialFrame25).invoke(null, objArr24));
                Object[] objArr25 = {objArr};
                Object objAccessartificialFrame26 = ArtificialStackFrames.accessartificialFrame(-1243809191);
                if (objAccessartificialFrame26 == null) {
                    objAccessartificialFrame26 = ArtificialStackFrames.coroutineCreation(Drawable.resolveOpacity(0, 0) + 41, (char) (12467 - TextUtils.indexOf((CharSequence) "", '0')), (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 3642, 716815441, false, "ArtificialStackFrames", new Class[]{Object[].class});
                }
                arrayList3.add(((Method) objAccessartificialFrame26).invoke(null, objArr25));
                try {
                    Object[] objArr26 = {Long.valueOf((((long) 999635754) << 32) ^ ((long) (i29 ^ i30))), Long.valueOf(999635746)};
                    byte[] bArr6 = $$d;
                    Object[] objArr27 = new Object[1];
                    c(bArr6[84], (short) 533, bArr6[0], objArr27);
                    Class<?> cls3 = Class.forName((String) objArr27[0]);
                    byte b3 = bArr6[5];
                    Object[] objArr28 = new Object[1];
                    c(b3, (short) (b3 | 468), bArr6[210], objArr28);
                    cls3.getMethod((String) objArr28[0], Long.TYPE, Long.TYPE).invoke(null, objArr26);
                    Object[] objArr29 = {list, new int[1], list, new int[]{i}, new int[]{i}};
                    int i39 = ((int[]) objArr[1])[0];
                    int i40 = ((int[]) objArr[3])[0];
                    int i41 = ((int[]) objArr[4])[0];
                    List list5 = (List) objArr[0];
                    List list6 = (List) objArr[2];
                    int i42 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getDisplayMetrics().widthPixels;
                    int i43 = ~i42;
                    int i44 = i39 + 1543250564 + (((~((-185651671) | i43)) | (~((-419796788) | i43))) * (-867)) + (((~((-185651671) | i42)) | 151032082 | (~((-419796788) | i42))) * (-1734)) + (((~(i42 | (-268764706))) | (~(i43 | (-151032083))) | (~((-34619589) | i42))) * 867);
                    int i45 = (i44 << 13) ^ i44;
                    int i46 = i45 ^ (i45 >>> 17);
                    i = 0;
                    ((int[]) objArr29[1])[0] = i46 ^ (i46 << 5);
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
        }
        Object objAccessartificialFrame27 = ArtificialStackFrames.accessartificialFrame(-1283093189);
        if (objAccessartificialFrame27 == null) {
            int i47 = 31 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
            char c2 = (char) (49362 - (TypedValue.complexToFloat(i) > 0.0f ? 1 : (TypedValue.complexToFloat(i) == 0.0f ? 0 : -1)));
            int trimmedLength = TextUtils.getTrimmedLength("") + 684;
            byte b4 = (byte) ($$b - 2);
            byte[] bArr7 = $$a;
            Object[] objArr30 = new Object[1];
            b(b4, bArr7[8], (byte) (-bArr7[4]), objArr30);
            objAccessartificialFrame27 = ArtificialStackFrames.coroutineCreation(i47, c2, trimmedLength, 752929587, false, (String) objArr30[0], null);
        }
        long j5 = ((Field) objAccessartificialFrame27).getLong(null);
        if (j5 != -1) {
            int i48 = artificialFrame + 17;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i48 % 128;
            if (i48 % 2 != 0) {
                i2 = 0;
                if (j5 / 1991 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                    baseContext2 = getBaseContext();
                    if (baseContext2 == null) {
                        Object[] objArr31 = new Object[1];
                        a(TextUtils.getOffsetBefore("", i2) + 26, new int[]{721578335, -1565849910, -2013940550, -695591454, 1577959775, 1568303289, -313253021, -1695859094, 634303605, -509814910, -1495177834, -540186052, -756860588, 1186567138}, objArr31);
                        Class<?> cls4 = Class.forName((String) objArr31[i2]);
                        Object[] objArr32 = new Object[1];
                        a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i2]).invoke(null, null)).getApplicationContext().getPackageName().length() - 3, new int[]{251814919, 1633520329, -1093159096, -1871449063, -1297860173, 1957793086, 1873867491, -1451760763, -1519411634, -1318508961}, objArr32);
                        baseContext2 = (Context) cls4.getMethod((String) objArr32[0], new Class[0]).invoke(null, null);
                    }
                    if (baseContext2 != null) {
                        if ((baseContext2 instanceof ContextWrapper) || ((ContextWrapper) baseContext2).getBaseContext() != null) {
                            baseContext2 = baseContext2.getApplicationContext();
                        } else {
                            baseContext2 = null;
                        }
                    }
                    Object[] objArr33 = {baseContext2, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, -1940847400};
                    byte[] bArr8 = $$d;
                    Object[] objArr34 = new Object[1];
                    c(bArr8[126], (short) ($$e | 260), bArr8[0], objArr34);
                    Class<?> cls5 = Class.forName((String) objArr34[0]);
                    Object[] objArr35 = new Object[1];
                    c(bArr8[248], (short) 552, (byte) (bArr8[61] - 1), objArr35);
                    objArr2 = (Object[]) cls5.getMethod((String) objArr35[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr33);
                    if (baseContext2 != null) {
                        objAccessartificialFrame19 = ArtificialStackFrames.accessartificialFrame(-326560385);
                        if (objAccessartificialFrame19 == null) {
                            int iIndexOf = TextUtils.indexOf((CharSequence) "", '0', 0) + 31;
                            char scrollDefaultDelay = (char) ((ViewConfiguration.getScrollDefaultDelay() >> 16) + 49362);
                            int fadingEdgeLength = (ViewConfiguration.getFadingEdgeLength() >> 16) + 684;
                            byte[] bArr9 = $$a;
                            Object[] objArr36 = new Object[1];
                            b(bArr9[83], bArr9[9], (byte) (-bArr9[4]), objArr36);
                            objAccessartificialFrame19 = ArtificialStackFrames.coroutineCreation(iIndexOf, scrollDefaultDelay, fadingEdgeLength, 1944867703, false, (String) objArr36[0], null);
                        }
                        ((Field) objAccessartificialFrame19).set(null, objArr2);
                        try {
                            Long lValueOf2 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                            objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(-1283093189);
                            if (objAccessartificialFrame20 == null) {
                                int i49 = 31 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                                char maximumFlingVelocity = (char) (49362 - (ViewConfiguration.getMaximumFlingVelocity() >> 16));
                                int iAlpha = 684 - Color.alpha(0);
                                byte b5 = (byte) ($$b - 2);
                                byte[] bArr10 = $$a;
                                Object[] objArr37 = new Object[1];
                                b(b5, bArr10[8], (byte) (-bArr10[4]), objArr37);
                                objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation(i49, maximumFlingVelocity, iAlpha, 752929587, false, (String) objArr37[0], null);
                            }
                            ((Field) objAccessartificialFrame20).set(null, lValueOf2);
                        } catch (Exception unused2) {
                            throw new RuntimeException();
                        }
                    }
                }
            } else if (j5 + 1991 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                i2 = 0;
                baseContext2 = getBaseContext();
                if (baseContext2 == null) {
                    Object[] objArr38 = new Object[1];
                    a(TextUtils.getOffsetBefore("", i2) + 26, new int[]{721578335, -1565849910, -2013940550, -695591454, 1577959775, 1568303289, -313253021, -1695859094, 634303605, -509814910, -1495177834, -540186052, -756860588, 1186567138}, objArr38);
                    Class<?> cls6 = Class.forName((String) objArr38[i2]);
                    Object[] objArr39 = new Object[1];
                    a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i2]).invoke(null, null)).getApplicationContext().getPackageName().length() - 3, new int[]{251814919, 1633520329, -1093159096, -1871449063, -1297860173, 1957793086, 1873867491, -1451760763, -1519411634, -1318508961}, objArr39);
                    baseContext2 = (Context) cls6.getMethod((String) objArr39[0], new Class[0]).invoke(null, null);
                }
                if (baseContext2 != null) {
                    if (baseContext2 instanceof ContextWrapper) {
                        baseContext2 = baseContext2.getApplicationContext();
                    } else {
                        baseContext2 = baseContext2.getApplicationContext();
                    }
                }
                Object[] objArr310 = {baseContext2, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, -1940847400};
                byte[] bArr11 = $$d;
                Object[] objArr311 = new Object[1];
                c(bArr11[126], (short) ($$e | 260), bArr11[0], objArr311);
                Class<?> cls7 = Class.forName((String) objArr311[0]);
                Object[] objArr312 = new Object[1];
                c(bArr11[248], (short) 552, (byte) (bArr11[61] - 1), objArr312);
                objArr2 = (Object[]) cls7.getMethod((String) objArr312[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr310);
                if (baseContext2 != null) {
                    objAccessartificialFrame19 = ArtificialStackFrames.accessartificialFrame(-326560385);
                    if (objAccessartificialFrame19 == null) {
                        int iIndexOf2 = TextUtils.indexOf((CharSequence) "", '0', 0) + 31;
                        char scrollDefaultDelay2 = (char) ((ViewConfiguration.getScrollDefaultDelay() >> 16) + 49362);
                        int fadingEdgeLength2 = (ViewConfiguration.getFadingEdgeLength() >> 16) + 684;
                        byte[] bArr12 = $$a;
                        Object[] objArr313 = new Object[1];
                        b(bArr12[83], bArr12[9], (byte) (-bArr12[4]), objArr313);
                        objAccessartificialFrame19 = ArtificialStackFrames.coroutineCreation(iIndexOf2, scrollDefaultDelay2, fadingEdgeLength2, 1944867703, false, (String) objArr313[0], null);
                    }
                    ((Field) objAccessartificialFrame19).set(null, objArr2);
                    Long lValueOf3 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(-1283093189);
                    if (objAccessartificialFrame20 == null) {
                        int i410 = 31 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                        char maximumFlingVelocity2 = (char) (49362 - (ViewConfiguration.getMaximumFlingVelocity() >> 16));
                        int iAlpha2 = 684 - Color.alpha(0);
                        byte b6 = (byte) ($$b - 2);
                        byte[] bArr13 = $$a;
                        Object[] objArr314 = new Object[1];
                        b(b6, bArr13[8], (byte) (-bArr13[4]), objArr314);
                        objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation(i410, maximumFlingVelocity2, iAlpha2, 752929587, false, (String) objArr314[0], null);
                    }
                    ((Field) objAccessartificialFrame20).set(null, lValueOf3);
                }
            }
            Object objAccessartificialFrame28 = ArtificialStackFrames.accessartificialFrame(-326560385);
            if (objAccessartificialFrame28 == null) {
                int iKeyCodeFromString = KeyEvent.keyCodeFromString("") + 30;
                char packedPositionType = (char) (49362 - ExpandableListView.getPackedPositionType(0L));
                int scrollBarSize = (ViewConfiguration.getScrollBarSize() >> 8) + 684;
                byte[] bArr14 = $$a;
                Object[] objArr40 = new Object[1];
                b(bArr14[83], bArr14[9], (byte) (-bArr14[4]), objArr40);
                objAccessartificialFrame28 = ArtificialStackFrames.coroutineCreation(iKeyCodeFromString, packedPositionType, scrollBarSize, 1944867703, false, (String) objArr40[0], null);
            }
            Object[] objArr41 = (Object[]) ((Field) objAccessartificialFrame28).get(null);
            objArr2 = new Object[]{new int[]{((int[]) objArr41[0])[0]}, new int[]{((int[]) objArr41[1])[0]}, new int[1], (String) objArr41[3]};
            int iIdentityHashCode = System.identityHashCode(this);
            int i50 = ~iIdentityHashCode;
            int i51 = (~((-873511000) | i50)) | 67149895;
            int i52 = ~(iIdentityHashCode | 911473879);
            int i53 = ((((i51 | i52) * (-252)) + 720528130) + ((i52 | (~(i50 | (-806361105)))) * 252)) - 1940847400;
            int i54 = (i53 << 13) ^ i53;
            int i55 = i54 ^ (i54 >>> 17);
            ((int[]) objArr2[2])[0] = i55 ^ (i55 << 5);
        } else {
            i2 = 0;
            baseContext2 = getBaseContext();
            if (baseContext2 == null) {
                Object[] objArr315 = new Object[1];
                a(TextUtils.getOffsetBefore("", i2) + 26, new int[]{721578335, -1565849910, -2013940550, -695591454, 1577959775, 1568303289, -313253021, -1695859094, 634303605, -509814910, -1495177834, -540186052, -756860588, 1186567138}, objArr315);
                Class<?> cls8 = Class.forName((String) objArr315[i2]);
                Object[] objArr316 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i2]).invoke(null, null)).getApplicationContext().getPackageName().length() - 3, new int[]{251814919, 1633520329, -1093159096, -1871449063, -1297860173, 1957793086, 1873867491, -1451760763, -1519411634, -1318508961}, objArr316);
                baseContext2 = (Context) cls8.getMethod((String) objArr316[0], new Class[0]).invoke(null, null);
            }
            if (baseContext2 != null) {
                if (baseContext2 instanceof ContextWrapper) {
                    baseContext2 = baseContext2.getApplicationContext();
                } else {
                    baseContext2 = baseContext2.getApplicationContext();
                }
            }
            Object[] objArr317 = {baseContext2, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, -1940847400};
            byte[] bArr15 = $$d;
            Object[] objArr318 = new Object[1];
            c(bArr15[126], (short) ($$e | 260), bArr15[0], objArr318);
            Class<?> cls9 = Class.forName((String) objArr318[0]);
            Object[] objArr319 = new Object[1];
            c(bArr15[248], (short) 552, (byte) (bArr15[61] - 1), objArr319);
            objArr2 = (Object[]) cls9.getMethod((String) objArr319[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr317);
            if (baseContext2 != null) {
                objAccessartificialFrame19 = ArtificialStackFrames.accessartificialFrame(-326560385);
                if (objAccessartificialFrame19 == null) {
                    int iIndexOf3 = TextUtils.indexOf((CharSequence) "", '0', 0) + 31;
                    char scrollDefaultDelay3 = (char) ((ViewConfiguration.getScrollDefaultDelay() >> 16) + 49362);
                    int fadingEdgeLength3 = (ViewConfiguration.getFadingEdgeLength() >> 16) + 684;
                    byte[] bArr16 = $$a;
                    Object[] objArr3110 = new Object[1];
                    b(bArr16[83], bArr16[9], (byte) (-bArr16[4]), objArr3110);
                    objAccessartificialFrame19 = ArtificialStackFrames.coroutineCreation(iIndexOf3, scrollDefaultDelay3, fadingEdgeLength3, 1944867703, false, (String) objArr3110[0], null);
                }
                ((Field) objAccessartificialFrame19).set(null, objArr2);
                Long lValueOf4 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(-1283093189);
                if (objAccessartificialFrame20 == null) {
                    int i411 = 31 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                    char maximumFlingVelocity3 = (char) (49362 - (ViewConfiguration.getMaximumFlingVelocity() >> 16));
                    int iAlpha3 = 684 - Color.alpha(0);
                    byte b7 = (byte) ($$b - 2);
                    byte[] bArr17 = $$a;
                    Object[] objArr3111 = new Object[1];
                    b(b7, bArr17[8], (byte) (-bArr17[4]), objArr3111);
                    objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation(i411, maximumFlingVelocity3, iAlpha3, 752929587, false, (String) objArr3111[0], null);
                }
                ((Field) objAccessartificialFrame20).set(null, lValueOf4);
            }
        }
        int i56 = ((int[]) objArr2[1])[0];
        int i57 = ((int[]) objArr2[0])[0];
        if (i57 == i56) {
            int i58 = artificialFrame + 11;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i58 % 128;
            int i59 = i58 % 2;
            int i60 = ((int[]) objArr2[2])[0];
            Object[] objArr42 = {new int[]{((int[]) objArr2[0])[0]}, new int[]{((int[]) objArr2[1])[0]}, new int[1], (String) objArr2[3]};
            int i61 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().smallestScreenWidthDp;
            int i62 = ~i61;
            int i63 = i60 + (-725948290) + (((~(i62 | 714256742)) | (~((-264367033) | i62)) | 88165016) * 464) + (((-176202017) | i61) * (-464)) + (((~(i61 | 714256742)) | 88165016) * 464);
            int i64 = (i63 << 13) ^ i63;
            int i65 = i64 ^ (i64 >>> 17);
            ((int[]) objArr42[2])[0] = i65 ^ (i65 << 5);
            i3 = 0;
        } else {
            Object[] objArr43 = {Long.valueOf(((long) (i56 ^ i57)) ^ (((long) 58685655) << 32)), Long.valueOf(58685651)};
            byte[] bArr18 = $$d;
            Object[] objArr44 = new Object[1];
            c(bArr18[288], (short) TypedValues.CycleType.TYPE_ALPHA, bArr18[0], objArr44);
            Class<?> cls10 = Class.forName((String) objArr44[0]);
            byte b8 = bArr18[5];
            Object[] objArr45 = new Object[1];
            c(b8, (short) (b8 | 468), bArr18[210], objArr45);
            cls10.getMethod((String) objArr45[0], Long.TYPE, Long.TYPE).invoke(null, objArr43);
            int i66 = ((int[]) objArr2[2])[0];
            Object[] objArr46 = {new int[]{((int[]) objArr2[0])[0]}, new int[]{((int[]) objArr2[1])[0]}, new int[1], (String) objArr2[3]};
            int i67 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 915671996;
            int i68 = i66 + 1669747082 + (((~i67) | 2433089) * 1324) + (((~(i67 | 270888005)) | (~(707735769 | i67))) * (-1324)) + 382434152;
            int i69 = (i68 << 13) ^ i68;
            int i70 = i69 ^ (i69 >>> 17);
            i3 = 0;
            ((int[]) objArr46[2])[0] = i70 ^ (i70 << 5);
        }
        Object objAccessartificialFrame29 = ArtificialStackFrames.accessartificialFrame(-1168947751);
        if (objAccessartificialFrame29 == null) {
            int iResolveSize = View.resolveSize(i3, i3) + 36;
            char cIndexOf = (char) (TextUtils.indexOf((CharSequence) "", '0', i3, i3) + 1);
            int iRed = 540 - Color.red(i3);
            byte[] bArr19 = $$a;
            byte b9 = (byte) (bArr19[5] - 1);
            Object[] objArr47 = new Object[1];
            b(b9, b9, bArr19[18], objArr47);
            objAccessartificialFrame29 = ArtificialStackFrames.coroutineCreation(iResolveSize, cIndexOf, iRed, 624296913, false, (String) objArr47[0], null);
        }
        long j6 = ((Field) objAccessartificialFrame29).getLong(null);
        if (j6 != -1) {
            int i71 = getARTIFICIAL_FRAME_PACKAGE_NAME + 65;
            artificialFrame = i71 % 128;
            if (i71 % 2 != 0 ? j6 + 2020 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue() : j6 % 2020 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[1])).longValue()) {
                objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1717965552);
                if (objAccessartificialFrame == null) {
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(19 - TextUtils.indexOf((CharSequence) "", '0'), (char) (39516 - (ViewConfiguration.getLongPressTimeout() >> 16)), (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 982, 117222168, false, null, new Class[0]);
                }
                Object[] objArr48 = {null, ((Constructor) objAccessartificialFrame).newInstance(null), -1280810695, 0};
                objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-501205803);
                if (objAccessartificialFrame2 == null) {
                    int iResolveOpacity = Drawable.resolveOpacity(0, 0) + 36;
                    char cAxisFromString = (char) (MotionEvent.axisFromString("") + 1);
                    int i72 = (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 539;
                    byte b10 = (byte) 46;
                    Object[] objArr49 = new Object[1];
                    b(b10, (byte) (b10 + 1), (byte) ($$a[5] - 1), objArr49);
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iResolveOpacity, cAxisFromString, i72, 2101703389, false, (String) objArr49[0], new Class[]{(Class) ArtificialStackFrames.coroutineCreation(((byte) KeyEvent.getModifierMetaStateMask()) + 55, (char) (834 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))), 576 - (ViewConfiguration.getKeyRepeatTimeout() >> 16)), (Class) ArtificialStackFrames.coroutineCreation(54 - View.combineMeasuredStates(0, 0), (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)), 630 - (ViewConfiguration.getDoubleTapTimeout() >> 16)), Integer.TYPE, Integer.TYPE});
                }
                objArr3 = (Object[]) ((Method) objAccessartificialFrame2).invoke(null, objArr48);
                objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1339222025);
                if (objAccessartificialFrame3 == null) {
                    int iAlpha4 = Color.alpha(0) + 36;
                    char trimmedLength2 = (char) TextUtils.getTrimmedLength("");
                    int scrollBarFadeDuration = (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 540;
                    byte[] bArr20 = $$a;
                    Object[] objArr50 = new Object[1];
                    b(bArr20[57], (byte) (bArr20[5] - 1), bArr20[18], objArr50);
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(iAlpha4, trimmedLength2, scrollBarFadeDuration, 793268735, false, (String) objArr50[0], null);
                }
                ((Field) objAccessartificialFrame3).set(null, objArr3);
                try {
                    Long lValueOf5 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1168947751);
                    if (objAccessartificialFrame4 == null) {
                        int i73 = 37 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                        char cAlpha = (char) Color.alpha(0);
                        int deadChar = 540 - KeyEvent.getDeadChar(0, 0);
                        byte[] bArr21 = $$a;
                        byte b11 = (byte) (bArr21[5] - 1);
                        Object[] objArr51 = new Object[1];
                        b(b11, b11, bArr21[18], objArr51);
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(i73, cAlpha, deadChar, 624296913, false, (String) objArr51[0], null);
                    }
                    ((Field) objAccessartificialFrame4).set(null, lValueOf5);
                } catch (Exception unused3) {
                    throw new RuntimeException();
                }
            } else {
                Object objAccessartificialFrame30 = ArtificialStackFrames.accessartificialFrame(-1339222025);
                if (objAccessartificialFrame30 == null) {
                    int gidForName = Process.getGidForName("") + 37;
                    char packedPositionChild = (char) (ExpandableListView.getPackedPositionChild(0L) + 1);
                    int i74 = 540 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                    byte[] bArr22 = $$a;
                    Object[] objArr52 = new Object[1];
                    b(bArr22[57], (byte) (bArr22[5] - 1), bArr22[18], objArr52);
                    objAccessartificialFrame30 = ArtificialStackFrames.coroutineCreation(gidForName, packedPositionChild, i74, 793268735, false, (String) objArr52[0], null);
                }
                Object[] objArr53 = (Object[]) ((Field) objAccessartificialFrame30).get(null);
                objArr3 = new Object[]{new int[1], new int[1], new int[1]};
                int i75 = ((int[]) objArr53[2])[0];
                int i76 = ((int[]) objArr53[1])[0];
                ((int[]) objArr3[2])[0] = i75;
                ((int[]) objArr3[1])[0] = i76;
                int iUptimeMillis = (int) SystemClock.uptimeMillis();
                int i77 = ((((-52014947) + (((-795843430) | iUptimeMillis) * 376)) + (((~((~iUptimeMillis) | 935086541)) | (-1073732590)) * (-376))) + (((~(iUptimeMillis | (-935086542))) | 416535208) * 376)) - 1280810695;
                int i78 = (i77 << 13) ^ i77;
                int i79 = i78 ^ (i78 >>> 17);
                ((int[]) objArr3[0])[0] = i79 ^ (i79 << 5);
            }
        } else {
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1717965552);
            if (objAccessartificialFrame == null) {
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(19 - TextUtils.indexOf((CharSequence) "", '0'), (char) (39516 - (ViewConfiguration.getLongPressTimeout() >> 16)), (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 982, 117222168, false, null, new Class[0]);
            }
            Object[] objArr410 = {null, ((Constructor) objAccessartificialFrame).newInstance(null), -1280810695, 0};
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-501205803);
            if (objAccessartificialFrame2 == null) {
                int iResolveOpacity2 = Drawable.resolveOpacity(0, 0) + 36;
                char cAxisFromString2 = (char) (MotionEvent.axisFromString("") + 1);
                int i710 = (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 539;
                byte b12 = (byte) 46;
                Object[] objArr411 = new Object[1];
                b(b12, (byte) (b12 + 1), (byte) ($$a[5] - 1), objArr411);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iResolveOpacity2, cAxisFromString2, i710, 2101703389, false, (String) objArr411[0], new Class[]{(Class) ArtificialStackFrames.coroutineCreation(((byte) KeyEvent.getModifierMetaStateMask()) + 55, (char) (834 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))), 576 - (ViewConfiguration.getKeyRepeatTimeout() >> 16)), (Class) ArtificialStackFrames.coroutineCreation(54 - View.combineMeasuredStates(0, 0), (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)), 630 - (ViewConfiguration.getDoubleTapTimeout() >> 16)), Integer.TYPE, Integer.TYPE});
            }
            objArr3 = (Object[]) ((Method) objAccessartificialFrame2).invoke(null, objArr410);
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1339222025);
            if (objAccessartificialFrame3 == null) {
                int iAlpha5 = Color.alpha(0) + 36;
                char trimmedLength3 = (char) TextUtils.getTrimmedLength("");
                int scrollBarFadeDuration2 = (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 540;
                byte[] bArr23 = $$a;
                Object[] objArr54 = new Object[1];
                b(bArr23[57], (byte) (bArr23[5] - 1), bArr23[18], objArr54);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(iAlpha5, trimmedLength3, scrollBarFadeDuration2, 793268735, false, (String) objArr54[0], null);
            }
            ((Field) objAccessartificialFrame3).set(null, objArr3);
            Long lValueOf6 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1168947751);
            if (objAccessartificialFrame4 == null) {
                int i711 = 37 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                char cAlpha2 = (char) Color.alpha(0);
                int deadChar2 = 540 - KeyEvent.getDeadChar(0, 0);
                byte[] bArr24 = $$a;
                byte b13 = (byte) (bArr24[5] - 1);
                Object[] objArr55 = new Object[1];
                b(b13, b13, bArr24[18], objArr55);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(i711, cAlpha2, deadChar2, 624296913, false, (String) objArr55[0], null);
            }
            ((Field) objAccessartificialFrame4).set(null, lValueOf6);
        }
        Object obj = objArr3[1];
        int i80 = ((int[]) obj)[0];
        Object obj2 = objArr3[2];
        int i81 = ((int[]) obj2)[0];
        if (i81 == i80) {
            Object[] objArr56 = {new int[1], new int[1], new int[1]};
            int i82 = ((int[]) objArr3[0])[0];
            int i83 = ((int[]) obj2)[0];
            int i84 = ((int[]) obj)[0];
            ((int[]) objArr56[2])[0] = i83;
            ((int[]) objArr56[1])[0] = i84;
            int iCodePointAt = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) + 559241616;
            int i85 = ~iCodePointAt;
            int i86 = ~((-636119714) | i85);
            int i87 = ~((-715502037) | iCodePointAt);
            int i88 = i82 + 1558196650 + ((i86 | i87) * 1150) + (((~(715502036 | i85)) | i87) * (-575)) + (((~(iCodePointAt | (-636119714))) | (~(i85 | 636119713))) * 575);
            int i89 = i88 ^ (i88 << 13);
            int i90 = i89 ^ (i89 >>> 17);
            ((int[]) objArr56[0])[0] = i90 ^ (i90 << 5);
        } else {
            Object[] objArr57 = {Long.valueOf((((long) 1461409712) << 32) ^ ((long) (i80 ^ i81))), Long.valueOf(1461405616)};
            byte[] bArr25 = $$d;
            Object[] objArr58 = new Object[1];
            c((byte) (-bArr25[60]), (short) 337, bArr25[0], objArr58);
            Class<?> cls11 = Class.forName((String) objArr58[0]);
            byte b14 = bArr25[5];
            Object[] objArr59 = new Object[1];
            c(b14, (short) (b14 | 468), bArr25[210], objArr59);
            cls11.getMethod((String) objArr59[0], Long.TYPE, Long.TYPE).invoke(null, objArr57);
            Object[] objArr60 = {new int[1], new int[1], new int[1]};
            int i91 = ((int[]) objArr3[0])[0];
            int i92 = ((int[]) objArr3[2])[0];
            int i93 = ((int[]) objArr3[1])[0];
            ((int[]) objArr60[2])[0] = i92;
            ((int[]) objArr60[1])[0] = i93;
            int iCodePointAt2 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(3) + 202275384;
            int i94 = ~iCodePointAt2;
            int i95 = i91 + (-878983839) + (((~((-696678959) | i94)) | (-654942792) | (~(696678958 | iCodePointAt2))) * (-564)) + ((~(iCodePointAt2 | (-101285954))) * 1128) + (((~((-654942792) | i94)) | (-797964912)) * 564);
            int i96 = (i95 << 13) ^ i95;
            int i97 = i96 ^ (i96 >>> 17);
            ((int[]) objArr60[0])[0] = i97 ^ (i97 << 5);
        }
        Object objAccessartificialFrame31 = ArtificialStackFrames.accessartificialFrame(-444530678);
        if (objAccessartificialFrame31 == null) {
            int minimumFlingVelocity2 = 26 - (ViewConfiguration.getMinimumFlingVelocity() >> 16);
            char cMyTid = (char) (Process.myTid() >> 22);
            int i98 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 1040;
            byte[] bArr26 = $$a;
            byte b15 = (byte) (bArr26[5] - 1);
            Object[] objArr61 = new Object[1];
            b(b15, b15, bArr26[18], objArr61);
            objAccessartificialFrame31 = ArtificialStackFrames.coroutineCreation(minimumFlingVelocity2, cMyTid, i98, 2061780482, false, (String) objArr61[0], null);
        }
        long j7 = ((Field) objAccessartificialFrame31).getLong(null);
        if (j7 != -1) {
            int i99 = artificialFrame + 123;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i99 % 128;
            if (i99 % 2 == 0 ? j7 + 4611686018427387919L < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue() : j7 - 4611686018427387919L < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[1]).invoke(null, new Object[1])).longValue()) {
                int iIntValue = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
                Object[] objArr62 = {292630047};
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                if (objAccessartificialFrame5 == null) {
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(TextUtils.lastIndexOf("", '0', 0) + 9, (char) (View.MeasureSpec.getSize(0) + 22251), 1033 - TextUtils.getCapsMode("", 0, 0), 47343338, false, null, new Class[]{Integer.TYPE});
                }
                objArrAccessartificialFrame$78cbbd35 = KeylineState.Keyline.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame5).newInstance(objArr62), -2026360728, false);
                objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame6 == null) {
                    int i100 = (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 25;
                    char edgeSlop2 = (char) (ViewConfiguration.getEdgeSlop() >> 16);
                    int iMyPid = 1041 - (Process.myPid() >> 22);
                    byte[] bArr27 = $$a;
                    Object[] objArr63 = new Object[1];
                    b(bArr27[57], (byte) (bArr27[5] - 1), bArr27[18], objArr63);
                    objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(i100, edgeSlop2, iMyPid, 1145017376, false, (String) objArr63[0], null);
                }
                ((Field) objAccessartificialFrame6).set(null, objArrAccessartificialFrame$78cbbd35);
                try {
                    Long lValueOf7 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-444530678);
                    if (objAccessartificialFrame7 == null) {
                        int size = 26 - View.MeasureSpec.getSize(0);
                        char capsMode = (char) TextUtils.getCapsMode("", 0, 0);
                        int iKeyCodeFromString2 = 1041 - KeyEvent.keyCodeFromString("");
                        byte[] bArr28 = $$a;
                        byte b16 = (byte) (bArr28[5] - 1);
                        Object[] objArr64 = new Object[1];
                        b(b16, b16, bArr28[18], objArr64);
                        objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(size, capsMode, iKeyCodeFromString2, 2061780482, false, (String) objArr64[0], null);
                    }
                    ((Field) objAccessartificialFrame7).set(null, lValueOf7);
                } catch (Exception unused4) {
                    throw new RuntimeException();
                }
            } else {
                int i101 = getARTIFICIAL_FRAME_PACKAGE_NAME + 95;
                artificialFrame = i101 % 128;
                int i102 = i101 % 2;
                Object objAccessartificialFrame32 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame32 == null) {
                    int iIndexOf4 = 25 - TextUtils.indexOf((CharSequence) "", '0', 0);
                    char bitsPerPixel = (char) ((-1) - ImageFormat.getBitsPerPixel(0));
                    int keyRepeatDelay = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 1041;
                    byte[] bArr29 = $$a;
                    Object[] objArr65 = new Object[1];
                    b(bArr29[57], (byte) (bArr29[5] - 1), bArr29[18], objArr65);
                    objAccessartificialFrame32 = ArtificialStackFrames.coroutineCreation(iIndexOf4, bitsPerPixel, keyRepeatDelay, 1145017376, false, (String) objArr65[0], null);
                }
                Object[] objArr66 = (Object[]) ((Field) objAccessartificialFrame32).get(null);
                objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                int i103 = ((int[]) objArr66[3])[0];
                int i104 = ((int[]) objArr66[2])[0];
                String[] strArr3 = (String[]) objArr66[0];
                int i105 = ~((~new Random().nextInt(2024565957)) | 702604103);
                int i106 = ((((555745856 | i105) * (-374)) - 1616753084) + ((i105 | 146858247) * 374)) - 2026360728;
                int i107 = (i106 << 13) ^ i106;
                int i108 = i107 ^ (i107 >>> 17);
                ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i108 ^ (i108 << 5);
            }
        } else {
            int iIntValue2 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            Object[] objArr67 = {292630047};
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame5 == null) {
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(TextUtils.lastIndexOf("", '0', 0) + 9, (char) (View.MeasureSpec.getSize(0) + 22251), 1033 - TextUtils.getCapsMode("", 0, 0), 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = KeylineState.Keyline.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame5).newInstance(objArr67), -2026360728, false);
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame6 == null) {
                int i109 = (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 25;
                char edgeSlop3 = (char) (ViewConfiguration.getEdgeSlop() >> 16);
                int iMyPid2 = 1041 - (Process.myPid() >> 22);
                byte[] bArr210 = $$a;
                Object[] objArr68 = new Object[1];
                b(bArr210[57], (byte) (bArr210[5] - 1), bArr210[18], objArr68);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(i109, edgeSlop3, iMyPid2, 1145017376, false, (String) objArr68[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, objArrAccessartificialFrame$78cbbd35);
            Long lValueOf8 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame7 == null) {
                int size2 = 26 - View.MeasureSpec.getSize(0);
                char capsMode2 = (char) TextUtils.getCapsMode("", 0, 0);
                int iKeyCodeFromString3 = 1041 - KeyEvent.keyCodeFromString("");
                byte[] bArr211 = $$a;
                byte b17 = (byte) (bArr211[5] - 1);
                Object[] objArr69 = new Object[1];
                b(b17, b17, bArr211[18], objArr69);
                objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(size2, capsMode2, iKeyCodeFromString3, 2061780482, false, (String) objArr69[0], null);
            }
            ((Field) objAccessartificialFrame7).set(null, lValueOf8);
        }
        int i110 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        int i111 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i111 == i110) {
            Object[] objArr70 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i112 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i113 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i114 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr4 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int iIdentityHashCode2 = System.identityHashCode(this);
            int i115 = ~iIdentityHashCode2;
            int i116 = (~((-884004990) | i115)) | 78694401;
            int i117 = ~(iIdentityHashCode2 | (-590595));
            int i118 = i112 + 927987444 + ((i116 | i117) * (-502)) + ((i117 | (~(i115 | (-805310589)))) * TypedValues.PositionType.TYPE_DRAWPATH);
            int i119 = (i118 << 13) ^ i118;
            int i120 = i119 ^ (i119 >>> 17);
            ((int[]) objArr70[1])[0] = i120 ^ (i120 << 5);
        } else {
            ArrayList arrayList4 = new ArrayList();
            String[] strArr5 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            if (strArr5 != null) {
                int i121 = 0;
                while (i121 < strArr5.length) {
                    int i122 = getARTIFICIAL_FRAME_PACKAGE_NAME + 99;
                    artificialFrame = i122 % 128;
                    if (i122 % 2 == 0) {
                        arrayList4.add(strArr5[i121]);
                        i121 += 49;
                    } else {
                        arrayList4.add(strArr5[i121]);
                        i121++;
                    }
                }
            }
            Object[] objArr71 = {Long.valueOf((((long) (-1194570894)) << 32) ^ ((long) (i110 ^ i111))), Long.valueOf(-1194570896)};
            byte[] bArr30 = $$d;
            Object[] objArr72 = new Object[1];
            c(bArr30[243], (short) 313, bArr30[0], objArr72);
            Class<?> cls12 = Class.forName((String) objArr72[0]);
            byte b18 = bArr30[5];
            Object[] objArr73 = new Object[1];
            c(b18, (short) (b18 | 468), bArr30[210], objArr73);
            cls12.getMethod((String) objArr73[0], Long.TYPE, Long.TYPE).invoke(null, objArr71);
            Object[] objArr74 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i123 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i124 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i125 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr6 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int iMyUid = Process.myUid();
            int i126 = ~((-1020735362) | iMyUid);
            int i127 = ~iMyUid;
            int i128 = i123 + 1140302622 + ((i126 | (~((-942631555) | i127))) * (-1808)) + (((~((-80741634) | iMyUid)) | (~(i127 | (-2637827)))) * TypedValues.Custom.TYPE_BOOLEAN) + (((~(iMyUid | 942631554)) | 939993728 | (~(1020735361 | i127))) * TypedValues.Custom.TYPE_BOOLEAN);
            int i129 = (i128 << 13) ^ i128;
            int i130 = i129 ^ (i129 >>> 17);
            ((int[]) objArr74[1])[0] = i130 ^ (i130 << 5);
        }
        Object objAccessartificialFrame33 = ArtificialStackFrames.accessartificialFrame(1313006081);
        if (objAccessartificialFrame33 == null) {
            int tapTimeout2 = 21 - (ViewConfiguration.getTapTimeout() >> 16);
            char packedPositionGroup = (char) ExpandableListView.getPackedPositionGroup(0L);
            int absoluteGravity2 = Gravity.getAbsoluteGravity(0, 0) + 465;
            byte[] bArr31 = $$a;
            byte b19 = (byte) (bArr31[5] - 1);
            Object[] objArr75 = new Object[1];
            b(b19, b19, bArr31[18], objArr75);
            objAccessartificialFrame33 = ArtificialStackFrames.coroutineCreation(tapTimeout2, packedPositionGroup, absoluteGravity2, -785931255, false, (String) objArr75[0], null);
        }
        long j8 = ((Field) objAccessartificialFrame33).getLong(null);
        if (j8 != -1) {
            int i131 = getARTIFICIAL_FRAME_PACKAGE_NAME + 57;
            artificialFrame = i131 % 128;
            int i132 = i131 % 2;
            if (j8 + 2004 >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame34 = ArtificialStackFrames.accessartificialFrame(1142731807);
                if (objAccessartificialFrame34 == null) {
                    int iLastIndexOf = 20 - TextUtils.lastIndexOf("", '0', 0, 0);
                    char cRgb = (char) (ViewCompat.MEASURED_STATE_MASK - Color.rgb(0, 0, 0));
                    int iIndexOf5 = 465 - TextUtils.indexOf("", "", 0);
                    byte[] bArr32 = $$a;
                    Object[] objArr76 = new Object[1];
                    b(bArr32[57], (byte) (bArr32[5] - 1), bArr32[18], objArr76);
                    objAccessartificialFrame34 = ArtificialStackFrames.coroutineCreation(iLastIndexOf, cRgb, iIndexOf5, -612765161, false, (String) objArr76[0], null);
                }
                Object[] objArr77 = (Object[]) ((Field) objAccessartificialFrame34).get(null);
                objArr4 = new Object[]{new int[]{i}, strArr, new int[1], new int[]{i}};
                int i133 = ((int[]) objArr77[3])[0];
                int i134 = ((int[]) objArr77[0])[0];
                String[] strArr7 = (String[]) objArr77[1];
                int iNextInt = new Random().nextInt();
                int i135 = ~iNextInt;
                int i136 = (((1744607828 + (((~((-452216770) | i135)) | (~(291867043 | i135))) * (-867))) + ((((~((-452216770) | iNextInt)) | 177227328) | (~(291867043 | iNextInt))) * (-1734))) + (((~(iNextInt | 469094371)) | ((~(i135 | (-177227329))) | (~((-274989442) | iNextInt)))) * 867)) - 1302219826;
                int i137 = (i136 << 13) ^ i136;
                int i138 = i137 ^ (i137 >>> 17);
                ((int[]) objArr4[2])[0] = i138 ^ (i138 << 5);
                c = 0;
            } else {
                i4 = 0;
            }
            i5 = ((int[]) objArr4[c])[c];
            i6 = ((int[]) objArr4[3])[c];
            if (i6 == i5) {
                Object[] objArr78 = new Object[4];
                int[] iArr = new int[1];
                objArr78[c] = iArr;
                objArr78[2] = new int[1];
                int[] iArr2 = new int[1];
                objArr78[3] = iArr2;
                int i139 = ((int[]) objArr4[2])[c];
                int i140 = ((int[]) objArr4[3])[c];
                int i141 = ((int[]) objArr4[c])[c];
                String[] strArr8 = (String[]) objArr4[1];
                iArr2[c] = i140;
                iArr[c] = i141;
                int iIdentityHashCode3 = System.identityHashCode(this);
                int i142 = ~iIdentityHashCode3;
                int i143 = ~(890315765 | i142);
                int i144 = i139 + 1865907189 + (((-1066625016) | i143) * (-712)) + (((~(iIdentityHashCode3 | (-176309251))) | (~(i142 | 1066625015))) * (-712)) + ((729966039 | i143) * 712);
                int i145 = (i144 << 13) ^ i144;
                int i146 = i145 ^ (i145 >>> 17);
                ((int[]) objArr78[2])[0] = i146 ^ (i146 << 5);
                objArr78[1] = strArr8;
            } else {
                arrayList = new ArrayList();
                strArr = (String[]) objArr4[1];
                if (strArr != null) {
                    for (String str5 : strArr) {
                        arrayList.add(str5);
                    }
                }
                Object[] objArr79 = {Long.valueOf(((long) (i5 ^ i6)) ^ (((long) 1553993881) << 32)), Long.valueOf(1553993945)};
                byte[] bArr33 = $$d;
                Object[] objArr80 = new Object[1];
                c(bArr33[183], (short) 195, bArr33[0], objArr80);
                Class<?> cls13 = Class.forName((String) objArr80[0]);
                byte b20 = bArr33[5];
                Object[] objArr81 = new Object[1];
                c(b20, (short) (b20 | 468), bArr33[210], objArr81);
                cls13.getMethod((String) objArr81[0], Long.TYPE, Long.TYPE).invoke(null, objArr79);
                Object[] objArr82 = {new int[]{i}, strArr, new int[1], new int[]{i}};
                int i147 = ((int[]) objArr4[2])[0];
                int i148 = ((int[]) objArr4[3])[0];
                int i149 = ((int[]) objArr4[0])[0];
                String[] strArr9 = (String[]) objArr4[1];
                int i150 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 1389450418;
                int i151 = (-465813043) + (((~((-772793551) | i150)) | 168738894 | (~(612443824 | i150))) * (-880));
                int i152 = (~((-772793551) | (~i150))) | (-612443825);
                int i153 = ~(i150 | 772793550);
                int i154 = i147 + i151 + ((i152 | i153) * (-880)) + (i153 * 880);
                int i155 = (i154 << 13) ^ i154;
                int i156 = i155 ^ (i155 >>> 17);
                ((int[]) objArr82[2])[0] = i156 ^ (i156 << 5);
            }
            super.onStart();
            objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(1056123296);
            if (objAccessartificialFrame8 == null) {
                int scrollBarFadeDuration3 = (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 30;
                char c3 = (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 49361);
                int trimmedLength4 = TextUtils.getTrimmedLength("") + 684;
                byte[] bArr34 = $$a;
                Object[] objArr83 = new Object[1];
                b((byte) 66, bArr34[9], bArr34[57], objArr83);
                objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration3, c3, trimmedLength4, -1583976536, false, (String) objArr83[0], null);
            }
            j = ((Field) objAccessartificialFrame8).getLong(null);
            if (j != -1 || j + 1887 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object[] objArr84 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), -716906627};
                byte[] bArr35 = $$d;
                Object[] objArr85 = new Object[1];
                c((byte) (bArr35[243] - 1), (short) 157, bArr35[89], objArr85);
                Class<?> cls14 = Class.forName((String) objArr85[0]);
                byte b21 = bArr35[4];
                Object[] objArr86 = new Object[1];
                c(b21, (short) (b21 | 100), bArr35[0], objArr86);
                objArr5 = (Object[]) cls14.getMethod((String) objArr86[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr84);
                objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(910856866);
                if (objAccessartificialFrame9 == null) {
                    int mode = 30 - View.MeasureSpec.getMode(0);
                    char c4 = (char) (49362 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)));
                    int i157 = (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 685;
                    byte[] bArr36 = $$a;
                    Object[] objArr87 = new Object[1];
                    b((byte) 78, bArr36[11], bArr36[18], objArr87);
                    objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(mode, c4, i157, -1456483158, false, (String) objArr87[0], null);
                }
                ((Field) objAccessartificialFrame9).set(null, objArr5);
                try {
                    Long lValueOf9 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(1056123296);
                    if (objAccessartificialFrame10 == null) {
                        int i158 = 30 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                        char modifierMetaStateMask = (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 49363);
                        int iLastIndexOf2 = TextUtils.lastIndexOf("", '0', 0, 0) + 685;
                        byte[] bArr37 = $$a;
                        Object[] objArr88 = new Object[1];
                        b((byte) 66, bArr37[9], bArr37[57], objArr88);
                        objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(i158, modifierMetaStateMask, iLastIndexOf2, -1583976536, false, (String) objArr88[0], null);
                    }
                    ((Field) objAccessartificialFrame10).set(null, lValueOf9);
                } catch (Exception unused5) {
                    throw new RuntimeException();
                }
            } else {
                Object objAccessartificialFrame35 = ArtificialStackFrames.accessartificialFrame(910856866);
                if (objAccessartificialFrame35 == null) {
                    int iBlue = 30 - Color.blue(0);
                    char deadChar3 = (char) (49362 - KeyEvent.getDeadChar(0, 0));
                    int scrollBarSize2 = 684 - (ViewConfiguration.getScrollBarSize() >> 8);
                    byte[] bArr38 = $$a;
                    Object[] objArr89 = new Object[1];
                    b((byte) 78, bArr38[11], bArr38[18], objArr89);
                    objAccessartificialFrame35 = ArtificialStackFrames.coroutineCreation(iBlue, deadChar3, scrollBarSize2, -1456483158, false, (String) objArr89[0], null);
                }
                Object[] objArr90 = (Object[]) ((Field) objAccessartificialFrame35).get(null);
                objArr5 = new Object[]{new int[]{((int[]) objArr90[0])[0]}, new int[]{((int[]) objArr90[1])[0]}, new int[1], (String) objArr90[3]};
                int i159 = ~((~(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 621385427)) | 44456384);
                int i160 = ((((6272 | i159) * (-970)) + 817771934) + ((i159 | 44450112) * 970)) - 716906627;
                int i161 = (i160 << 13) ^ i160;
                int i162 = i161 ^ (i161 >>> 17);
                ((int[]) objArr5[2])[0] = i162 ^ (i162 << 5);
            }
            i8 = ((int[]) objArr5[1])[0];
            i9 = ((int[]) objArr5[0])[0];
            if (i9 == i8) {
                int i163 = ((int[]) objArr5[2])[0];
                Object[] objArr91 = {new int[]{((int[]) objArr5[0])[0]}, new int[]{((int[]) objArr5[1])[0]}, new int[1], (String) objArr5[3]};
                int iNextInt2 = new Random().nextInt(1761998875);
                int i164 = ~iNextInt2;
                int i165 = (~((-524726003) | i164)) | 453291552;
                int i166 = ~(iNextInt2 | 525332222);
                int i167 = i163 + (((i165 | i166) * (-252)) - 756022114) + ((i166 | (~(i164 | (-71434451)))) * 252);
                int i168 = (i167 << 13) ^ i167;
                int i169 = i168 ^ (i168 >>> 17);
                ((int[]) objArr91[2])[0] = i169 ^ (i169 << 5);
                i10 = 0;
            } else {
                new ArrayList().add((String) objArr5[3]);
                Object[] objArr92 = {Long.valueOf(((long) (i8 ^ i9)) ^ (((long) (-1343134863)) << 32)), Long.valueOf(-1343134879)};
                byte[] bArr39 = $$d;
                Object[] objArr93 = new Object[1];
                c(bArr39[288], (short) TypedValues.CycleType.TYPE_ALPHA, bArr39[0], objArr93);
                Class<?> cls15 = Class.forName((String) objArr93[0]);
                byte b22 = bArr39[5];
                Object[] objArr94 = new Object[1];
                c(b22, (short) (b22 | 468), bArr39[210], objArr94);
                cls15.getMethod((String) objArr94[0], Long.TYPE, Long.TYPE).invoke(null, objArr92);
                int i170 = ((int[]) objArr5[2])[0];
                Object[] objArr95 = {new int[]{((int[]) objArr5[0])[0]}, new int[]{((int[]) objArr5[1])[0]}, new int[1], (String) objArr5[3]};
                int iIdentityHashCode4 = System.identityHashCode(this);
                int i171 = ~iIdentityHashCode4;
                int i172 = i170 + 1552183774 + (((~((-642124168) | i171)) | (-336499608) | (~(642124167 | iIdentityHashCode4))) * (-564)) + ((~(iIdentityHashCode4 | (-268997137))) * 1128) + (((~((-336499608) | i171)) | (-911121304)) * 564);
                int i173 = (i172 << 13) ^ i172;
                int i174 = i173 ^ (i173 >>> 17);
                i10 = 0;
                ((int[]) objArr95[2])[0] = i174 ^ (i174 << 5);
            }
            objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(-2127922582);
            if (objAccessartificialFrame11 == null) {
                int maximumDrawingCacheSize = (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 30;
                char cArgb = (char) (Color.argb(i10, i10, i10, i10) + 49362);
                int scrollDefaultDelay4 = (ViewConfiguration.getScrollDefaultDelay() >> 16) + 684;
                byte b23 = (byte) ($$b | 68);
                byte[] bArr40 = $$a;
                Object[] objArr96 = new Object[1];
                b(b23, bArr40[8], bArr40[57], objArr96);
                objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(maximumDrawingCacheSize, cArgb, scrollDefaultDelay4, 508509282, false, (String) objArr96[0], null);
            }
            j2 = ((Field) objAccessartificialFrame11).getLong(null);
            if (j2 != -1) {
                if (j2 + 1963 >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                    objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(777251007);
                    if (objAccessartificialFrame18 == null) {
                        int iGreen = 30 - Color.green(0);
                        char cIndexOf2 = (char) (TextUtils.indexOf("", "") + 49362);
                        int keyRepeatTimeout = 684 - (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                        byte[] bArr41 = $$a;
                        Object[] objArr97 = new Object[1];
                        b((byte) 98, bArr41[57], bArr41[88], objArr97);
                        objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(iGreen, cIndexOf2, keyRepeatTimeout, -1321816393, false, (String) objArr97[0], null);
                    }
                    Object[] objArr98 = (Object[]) ((Field) objAccessartificialFrame18).get(null);
                    objArr6 = new Object[]{new int[]{((int[]) objArr98[0])[0]}, new int[]{((int[]) objArr98[1])[0]}, new int[1], (String) objArr98[3]};
                    int i175 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().touchscreen;
                    int i176 = ~i175;
                    int i177 = ((((-1508821074) + ((((~((-523294475) | i176)) | 455132672) | (~((-455329301) | i176))) * (-1136))) + ((((~((-523294475) | i175)) | (~((-455329301) | i175))) | (~(523491102 | i176))) * (-568))) + (((~(i175 | (-455132673))) | ((~(i176 | 455329300)) | (~(523294474 | i176)))) * 568)) - 713052149;
                    int i178 = (i177 << 13) ^ i177;
                    int i179 = i178 ^ (i178 >>> 17);
                    ((int[]) objArr6[2])[0] = i179 ^ (i179 << 5);
                } else {
                    i11 = 0;
                }
                i12 = ((int[]) objArr6[1])[0];
                i13 = ((int[]) objArr6[0])[0];
                if (i13 == i12) {
                    int i180 = artificialFrame + 11;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i180 % 128;
                    int i181 = i180 % 2;
                    int i182 = ((int[]) objArr6[2])[0];
                    Object[] objArr99 = {new int[]{((int[]) objArr6[0])[0]}, new int[]{((int[]) objArr6[1])[0]}, new int[1], (String) objArr6[3]};
                    int length = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 996539712;
                    int i183 = ~length;
                    int i184 = i182 + (-104172642) + ((67108880 | i183) * (-192)) + (((~(67397938 | i183)) | 978912833) * (-384)) + (((~(length | (-289059))) | (~(i183 | 1046310771)) | (~((-978912834) | length))) * JfifUtil.MARKER_SOFn);
                    int i185 = (i184 << 13) ^ i184;
                    int i186 = i185 ^ (i185 >>> 17);
                    i14 = 0;
                    ((int[]) objArr99[2])[0] = i186 ^ (i186 << 5);
                } else {
                    long j9 = ((long) (i12 ^ i13)) ^ (((long) 183305586) << 32);
                    long j10 = 183306098;
                    int i187 = artificialFrame + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i187 % 128;
                    int i188 = i187 % 2;
                    Object[] objArr100 = {Long.valueOf(j9), Long.valueOf(j10)};
                    byte[] bArr42 = $$d;
                    Object[] objArr101 = new Object[1];
                    c(bArr42[288], (short) TypedValues.CycleType.TYPE_ALPHA, bArr42[0], objArr101);
                    Class<?> cls16 = Class.forName((String) objArr101[0]);
                    byte b24 = bArr42[5];
                    Object[] objArr102 = new Object[1];
                    c(b24, (short) (b24 | 468), bArr42[210], objArr102);
                    cls16.getMethod((String) objArr102[0], Long.TYPE, Long.TYPE).invoke(null, objArr100);
                    int i189 = ((int[]) objArr6[2])[0];
                    Object[] objArr103 = {new int[]{((int[]) objArr6[0])[0]}, new int[]{((int[]) objArr6[1])[0]}, new int[1], (String) objArr6[3]};
                    int i190 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().touchscreen;
                    int i191 = i189 + 563769436 + (((~((-176467521) | (~i190))) | (-802156255)) * (-591)) + ((i190 | (-176467521)) * 591);
                    int i192 = (i191 << 13) ^ i191;
                    int i193 = i192 ^ (i192 >>> 17);
                    i14 = 0;
                    ((int[]) objArr103[2])[0] = i193 ^ (i193 << 5);
                }
                objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                if (objAccessartificialFrame14 == null) {
                    int defaultSize = 25 - View.getDefaultSize(i14, i14);
                    char cLastIndexOf = (char) (30067 - TextUtils.lastIndexOf("", '0'));
                    int iMyPid3 = 816 - (Process.myPid() >> 22);
                    byte[] bArr43 = $$a;
                    byte b25 = (byte) (bArr43[5] - 1);
                    Object[] objArr104 = new Object[1];
                    b(b25, b25, bArr43[18], objArr104);
                    objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(defaultSize, cLastIndexOf, iMyPid3, 721586079, false, (String) objArr104[0], null);
                }
                j3 = ((Field) objAccessartificialFrame14).getLong(null);
                if (j3 != -1 || j3 + 1983 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                    Object[] objArr105 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 1855704524};
                    objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(1327366003);
                    if (objAccessartificialFrame15 == null) {
                        int iMakeMeasureSpec = 25 - View.MeasureSpec.makeMeasureSpec(0, 0);
                        char modifierMetaStateMask2 = (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 30069);
                        int maximumFlingVelocity4 = 816 - (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                        Object[] objArr106 = new Object[1];
                        b((byte) 105, (byte) 28, $$a[9], objArr106);
                        objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(iMakeMeasureSpec, modifierMetaStateMask2, maximumFlingVelocity4, -797394565, false, (String) objArr106[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    Object[] objArr107 = (Object[]) ((Method) objAccessartificialFrame15).invoke(null, objArr105);
                    objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                    if (objAccessartificialFrame16 == null) {
                        int scrollBarFadeDuration4 = 25 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                        char cArgb2 = (char) (30068 - Color.argb(0, 0, 0, 0));
                        int size3 = View.MeasureSpec.getSize(0) + 816;
                        byte[] bArr44 = $$a;
                        Object[] objArr108 = new Object[1];
                        b(bArr44[57], (byte) (bArr44[5] - 1), bArr44[18], objArr108);
                        objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration4, cArgb2, size3, 891606461, false, (String) objArr108[0], null);
                    }
                    ((Field) objAccessartificialFrame16).set(null, objArr107);
                    try {
                        Long lValueOf10 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                        if (objAccessartificialFrame17 == null) {
                            int iGreen2 = 25 - Color.green(0);
                            char c5 = (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 30067);
                            int pressedStateDuration = (ViewConfiguration.getPressedStateDuration() >> 16) + 816;
                            byte[] bArr45 = $$a;
                            byte b26 = (byte) (bArr45[5] - 1);
                            Object[] objArr109 = new Object[1];
                            b(b26, b26, bArr45[18], objArr109);
                            objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(iGreen2, c5, pressedStateDuration, 721586079, false, (String) objArr109[0], null);
                        }
                        ((Field) objAccessartificialFrame17).set(null, lValueOf10);
                        objArr7 = objArr107;
                    } catch (Exception unused6) {
                        throw new RuntimeException();
                    }
                } else {
                    Object objAccessartificialFrame36 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                    if (objAccessartificialFrame36 == null) {
                        int scrollBarSize3 = (ViewConfiguration.getScrollBarSize() >> 8) + 25;
                        char c6 = (char) (30069 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)));
                        int mode2 = View.MeasureSpec.getMode(0) + 816;
                        byte[] bArr46 = $$a;
                        Object[] objArr110 = new Object[1];
                        b(bArr46[57], (byte) (bArr46[5] - 1), bArr46[18], objArr110);
                        objAccessartificialFrame36 = ArtificialStackFrames.coroutineCreation(scrollBarSize3, c6, mode2, 891606461, false, (String) objArr110[0], null);
                    }
                    Object[] objArr111 = (Object[]) ((Field) objAccessartificialFrame36).get(null);
                    objArr7 = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                    int i194 = ((int[]) objArr111[0])[0];
                    int i195 = ((int[]) objArr111[1])[0];
                    String[] strArr10 = (String[]) objArr111[2];
                    int iIdentityHashCode5 = System.identityHashCode(this);
                    int i196 = 1496409245 + (((~((-204921831) | iIdentityHashCode5)) | 202375910) * 1504) + ((~(iIdentityHashCode5 | (-2545921))) * (-1504)) + 1126777020;
                    int i197 = (i196 << 13) ^ i196;
                    int i198 = i197 ^ (i197 >>> 17);
                    ((int[]) objArr7[3])[0] = i198 ^ (i198 << 5);
                }
                i15 = ((int[]) objArr7[1])[0];
                i16 = ((int[]) objArr7[0])[0];
                if (i16 == i15) {
                    Object[] objArr112 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
                    int i199 = ((int[]) objArr7[3])[0];
                    int i200 = ((int[]) objArr7[0])[0];
                    int i201 = ((int[]) objArr7[1])[0];
                    String[] strArr11 = (String[]) objArr7[2];
                    int iIdentityHashCode6 = System.identityHashCode(this);
                    int i202 = ~iIdentityHashCode6;
                    int i203 = i199 + (((~(1073344466 | i202)) | (~((-100671875) | iIdentityHashCode6))) * 988) + 220654249 + (((~(iIdentityHashCode6 | 774500226)) | 298844240 | (~(i202 | (-100671875)))) * 988);
                    int i204 = (i203 << 13) ^ i203;
                    int i205 = i204 ^ (i204 >>> 17);
                    ((int[]) objArr112[3])[0] = i205 ^ (i205 << 5);
                    return;
                }
                arrayList2 = new ArrayList();
                strArr2 = (String[]) objArr7[2];
                if (strArr2 != null) {
                    for (String str6 : strArr2) {
                        arrayList2.add(str6);
                    }
                }
                Object[] objArr113 = {Long.valueOf(((long) (i15 ^ i16)) ^ (((long) 614400810) << 32)), Long.valueOf(614400811)};
                byte[] bArr47 = $$d;
                byte b27 = (byte) (-bArr47[219]);
                Object[] objArr114 = new Object[1];
                c(b27, b27, bArr47[0], objArr114);
                Class<?> cls17 = Class.forName((String) objArr114[0]);
                byte b28 = bArr47[5];
                Object[] objArr115 = new Object[1];
                c(b28, (short) (b28 | 468), bArr47[210], objArr115);
                cls17.getMethod((String) objArr115[0], Long.TYPE, Long.TYPE).invoke(null, objArr113);
                Object[] objArr116 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i206 = ((int[]) objArr7[3])[0];
                int i207 = ((int[]) objArr7[0])[0];
                int i208 = ((int[]) objArr7[1])[0];
                String[] strArr12 = (String[]) objArr7[2];
                int iIdentityHashCode7 = System.identityHashCode(this);
                int i209 = ~((-64157394) | iIdentityHashCode7);
                int i210 = (-991954103) + ((135169 | i209) * (-280)) + ((i209 | (~((-134014973) | iIdentityHashCode7))) * 140);
                int i211 = ~((-64022225) | iIdentityHashCode7);
                int i212 = ~iIdentityHashCode7;
                int i213 = i206 + i210 + (((~(i212 | (-69992749))) | i211 | (~((-135170) | i212))) * 140);
                int i214 = (i213 << 13) ^ i213;
                int i215 = i214 ^ (i214 >>> 17);
                ((int[]) objArr116[3])[0] = i215 ^ (i215 << 5);
            }
            i11 = 0;
            baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr117 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i11]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(i11, 4).codePointAt(2) - 10, new int[]{721578335, -1565849910, -2013940550, -695591454, 1577959775, 1568303289, -313253021, -1695859094, 634303605, -509814910, -1495177834, -540186052, -756860588, 1186567138}, objArr117);
                Class<?> cls18 = Class.forName((String) objArr117[i11]);
                Object[] objArr118 = new Object[1];
                a((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 18, new int[]{251814919, 1633520329, -1093159096, -1871449063, -1297860173, 1957793086, 1873867491, -1451760763, -1519411634, -1318508961}, objArr118);
                baseContext = (Context) cls18.getMethod((String) objArr118[i11], new Class[i11]).invoke(null, null);
            }
            if (baseContext != null) {
                if ((!(baseContext instanceof ContextWrapper)) && ((ContextWrapper) baseContext).getBaseContext() == null) {
                    baseContext = null;
                } else {
                    baseContext = baseContext.getApplicationContext();
                }
            }
            Object[] objArr119 = {baseContext, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), -713052149};
            byte[] bArr48 = $$d;
            byte b29 = bArr48[164];
            Object[] objArr120 = new Object[1];
            c(b29, (short) (b29 | SignedBytes.MAX_POWER_OF_TWO), bArr48[0], objArr120);
            Class<?> cls19 = Class.forName((String) objArr120[0]);
            byte b30 = bArr48[156];
            Object[] objArr121 = new Object[1];
            c(b30, (short) (b30 | 195), bArr48[101], objArr121);
            objArr6 = (Object[]) cls19.getMethod((String) objArr121[0], Context.class, Integer.TYPE, Integer.TYPE).invoke(null, objArr119);
            if (baseContext != null) {
                objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(777251007);
                if (objAccessartificialFrame12 == null) {
                    int windowTouchSlop = 30 - (ViewConfiguration.getWindowTouchSlop() >> 8);
                    char c7 = (char) (49362 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)));
                    int minimumFlingVelocity3 = (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 684;
                    byte[] bArr49 = $$a;
                    Object[] objArr122 = new Object[1];
                    b((byte) 98, bArr49[57], bArr49[88], objArr122);
                    objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(windowTouchSlop, c7, minimumFlingVelocity3, -1321816393, false, (String) objArr122[0], null);
                }
                ((Field) objAccessartificialFrame12).set(null, objArr6);
                try {
                    Long lValueOf11 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(-2127922582);
                    if (objAccessartificialFrame13 == null) {
                        int maximumFlingVelocity5 = 30 - (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                        char cIndexOf3 = (char) (TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 49363);
                        int deadChar4 = 684 - KeyEvent.getDeadChar(0, 0);
                        byte b31 = (byte) ($$b | 68);
                        byte[] bArr50 = $$a;
                        Object[] objArr123 = new Object[1];
                        b(b31, bArr50[8], bArr50[57], objArr123);
                        objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(maximumFlingVelocity5, cIndexOf3, deadChar4, 508509282, false, (String) objArr123[0], null);
                    }
                    ((Field) objAccessartificialFrame13).set(null, lValueOf11);
                } catch (Exception unused7) {
                    throw new RuntimeException();
                }
            }
            i12 = ((int[]) objArr6[1])[0];
            i13 = ((int[]) objArr6[0])[0];
            if (i13 == i12) {
                int i1810 = artificialFrame + 11;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i1810 % 128;
                int i1811 = i1810 % 2;
                int i1812 = ((int[]) objArr6[2])[0];
                Object[] objArr910 = {new int[]{((int[]) objArr6[0])[0]}, new int[]{((int[]) objArr6[1])[0]}, new int[1], (String) objArr6[3]};
                int length2 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 996539712;
                int i1813 = ~length2;
                int i1814 = i1812 + (-104172642) + ((67108880 | i1813) * (-192)) + (((~(67397938 | i1813)) | 978912833) * (-384)) + (((~(length2 | (-289059))) | (~(i1813 | 1046310771)) | (~((-978912834) | length2))) * JfifUtil.MARKER_SOFn);
                int i1815 = (i1814 << 13) ^ i1814;
                int i1816 = i1815 ^ (i1815 >>> 17);
                i14 = 0;
                ((int[]) objArr910[2])[0] = i1816 ^ (i1816 << 5);
            } else {
                long j11 = ((long) (i12 ^ i13)) ^ (((long) 183305586) << 32);
                long j12 = 183306098;
                int i1817 = artificialFrame + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i1817 % 128;
                int i1818 = i1817 % 2;
                Object[] objArr1010 = {Long.valueOf(j11), Long.valueOf(j12)};
                byte[] bArr410 = $$d;
                Object[] objArr1011 = new Object[1];
                c(bArr410[288], (short) TypedValues.CycleType.TYPE_ALPHA, bArr410[0], objArr1011);
                Class<?> cls110 = Class.forName((String) objArr1011[0]);
                byte b210 = bArr410[5];
                Object[] objArr1012 = new Object[1];
                c(b210, (short) (b210 | 468), bArr410[210], objArr1012);
                cls110.getMethod((String) objArr1012[0], Long.TYPE, Long.TYPE).invoke(null, objArr1010);
                int i1819 = ((int[]) objArr6[2])[0];
                Object[] objArr1013 = {new int[]{((int[]) objArr6[0])[0]}, new int[]{((int[]) objArr6[1])[0]}, new int[1], (String) objArr6[3]};
                int i1910 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().touchscreen;
                int i1911 = i1819 + 563769436 + (((~((-176467521) | (~i1910))) | (-802156255)) * (-591)) + ((i1910 | (-176467521)) * 591);
                int i1912 = (i1911 << 13) ^ i1911;
                int i1913 = i1912 ^ (i1912 >>> 17);
                i14 = 0;
                ((int[]) objArr1013[2])[0] = i1913 ^ (i1913 << 5);
            }
            objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame14 == null) {
                int defaultSize2 = 25 - View.getDefaultSize(i14, i14);
                char cLastIndexOf2 = (char) (30067 - TextUtils.lastIndexOf("", '0'));
                int iMyPid4 = 816 - (Process.myPid() >> 22);
                byte[] bArr411 = $$a;
                byte b211 = (byte) (bArr411[5] - 1);
                Object[] objArr1014 = new Object[1];
                b(b211, b211, bArr411[18], objArr1014);
                objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(defaultSize2, cLastIndexOf2, iMyPid4, 721586079, false, (String) objArr1014[0], null);
            }
            j3 = ((Field) objAccessartificialFrame14).getLong(null);
            if (j3 != -1) {
                Object[] objArr1015 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 1855704524};
                objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(1327366003);
                if (objAccessartificialFrame15 == null) {
                    int iMakeMeasureSpec2 = 25 - View.MeasureSpec.makeMeasureSpec(0, 0);
                    char modifierMetaStateMask3 = (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 30069);
                    int maximumFlingVelocity6 = 816 - (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                    Object[] objArr1016 = new Object[1];
                    b((byte) 105, (byte) 28, $$a[9], objArr1016);
                    objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(iMakeMeasureSpec2, modifierMetaStateMask3, maximumFlingVelocity6, -797394565, false, (String) objArr1016[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                }
                Object[] objArr1017 = (Object[]) ((Method) objAccessartificialFrame15).invoke(null, objArr1015);
                objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame16 == null) {
                    int scrollBarFadeDuration5 = 25 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                    char cArgb3 = (char) (30068 - Color.argb(0, 0, 0, 0));
                    int size4 = View.MeasureSpec.getSize(0) + 816;
                    byte[] bArr412 = $$a;
                    Object[] objArr1018 = new Object[1];
                    b(bArr412[57], (byte) (bArr412[5] - 1), bArr412[18], objArr1018);
                    objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration5, cArgb3, size4, 891606461, false, (String) objArr1018[0], null);
                }
                ((Field) objAccessartificialFrame16).set(null, objArr1017);
                Long lValueOf12 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                if (objAccessartificialFrame17 == null) {
                    int iGreen3 = 25 - Color.green(0);
                    char c8 = (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 30067);
                    int pressedStateDuration2 = (ViewConfiguration.getPressedStateDuration() >> 16) + 816;
                    byte[] bArr413 = $$a;
                    byte b212 = (byte) (bArr413[5] - 1);
                    Object[] objArr1019 = new Object[1];
                    b(b212, b212, bArr413[18], objArr1019);
                    objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(iGreen3, c8, pressedStateDuration2, 721586079, false, (String) objArr1019[0], null);
                }
                ((Field) objAccessartificialFrame17).set(null, lValueOf12);
                objArr7 = objArr1017;
            } else {
                Object[] objArr10110 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 1855704524};
                objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(1327366003);
                if (objAccessartificialFrame15 == null) {
                    int iMakeMeasureSpec3 = 25 - View.MeasureSpec.makeMeasureSpec(0, 0);
                    char modifierMetaStateMask4 = (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 30069);
                    int maximumFlingVelocity7 = 816 - (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                    Object[] objArr10111 = new Object[1];
                    b((byte) 105, (byte) 28, $$a[9], objArr10111);
                    objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(iMakeMeasureSpec3, modifierMetaStateMask4, maximumFlingVelocity7, -797394565, false, (String) objArr10111[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                }
                Object[] objArr10112 = (Object[]) ((Method) objAccessartificialFrame15).invoke(null, objArr10110);
                objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame16 == null) {
                    int scrollBarFadeDuration6 = 25 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                    char cArgb4 = (char) (30068 - Color.argb(0, 0, 0, 0));
                    int size5 = View.MeasureSpec.getSize(0) + 816;
                    byte[] bArr414 = $$a;
                    Object[] objArr10113 = new Object[1];
                    b(bArr414[57], (byte) (bArr414[5] - 1), bArr414[18], objArr10113);
                    objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration6, cArgb4, size5, 891606461, false, (String) objArr10113[0], null);
                }
                ((Field) objAccessartificialFrame16).set(null, objArr10112);
                Long lValueOf13 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                if (objAccessartificialFrame17 == null) {
                    int iGreen4 = 25 - Color.green(0);
                    char c9 = (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 30067);
                    int pressedStateDuration3 = (ViewConfiguration.getPressedStateDuration() >> 16) + 816;
                    byte[] bArr415 = $$a;
                    byte b213 = (byte) (bArr415[5] - 1);
                    Object[] objArr10114 = new Object[1];
                    b(b213, b213, bArr415[18], objArr10114);
                    objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(iGreen4, c9, pressedStateDuration3, 721586079, false, (String) objArr10114[0], null);
                }
                ((Field) objAccessartificialFrame17).set(null, lValueOf13);
                objArr7 = objArr10112;
            }
            i15 = ((int[]) objArr7[1])[0];
            i16 = ((int[]) objArr7[0])[0];
            if (i16 == i15) {
                Object[] objArr1110 = {new int[]{i200}, new int[]{i201}, strArr11, new int[1]};
                int i1914 = ((int[]) objArr7[3])[0];
                int i2010 = ((int[]) objArr7[0])[0];
                int i2011 = ((int[]) objArr7[1])[0];
                String[] strArr13 = (String[]) objArr7[2];
                int iIdentityHashCode8 = System.identityHashCode(this);
                int i2012 = ~iIdentityHashCode8;
                int i2013 = i1914 + (((~(1073344466 | i2012)) | (~((-100671875) | iIdentityHashCode8))) * 988) + 220654249 + (((~(iIdentityHashCode8 | 774500226)) | 298844240 | (~(i2012 | (-100671875)))) * 988);
                int i2014 = (i2013 << 13) ^ i2013;
                int i2015 = i2014 ^ (i2014 >>> 17);
                ((int[]) objArr1110[3])[0] = i2015 ^ (i2015 << 5);
                return;
            }
            arrayList2 = new ArrayList();
            strArr2 = (String[]) objArr7[2];
            if (strArr2 != null) {
                while (i17 < strArr2.length) {
                    arrayList2.add(str6);
                }
            }
            Object[] objArr1111 = {Long.valueOf(((long) (i15 ^ i16)) ^ (((long) 614400810) << 32)), Long.valueOf(614400811)};
            byte[] bArr416 = $$d;
            byte b214 = (byte) (-bArr416[219]);
            Object[] objArr1112 = new Object[1];
            c(b214, b214, bArr416[0], objArr1112);
            Class<?> cls111 = Class.forName((String) objArr1112[0]);
            byte b215 = bArr416[5];
            Object[] objArr1113 = new Object[1];
            c(b215, (short) (b215 | 468), bArr416[210], objArr1113);
            cls111.getMethod((String) objArr1113[0], Long.TYPE, Long.TYPE).invoke(null, objArr1111);
            Object[] objArr1114 = {new int[]{i207}, new int[]{i208}, strArr12, new int[1]};
            int i2016 = ((int[]) objArr7[3])[0];
            int i2017 = ((int[]) objArr7[0])[0];
            int i2018 = ((int[]) objArr7[1])[0];
            String[] strArr14 = (String[]) objArr7[2];
            int iIdentityHashCode9 = System.identityHashCode(this);
            int i2019 = ~((-64157394) | iIdentityHashCode9);
            int i216 = (-991954103) + ((135169 | i2019) * (-280)) + ((i2019 | (~((-134014973) | iIdentityHashCode9))) * 140);
            int i217 = ~((-64022225) | iIdentityHashCode9);
            int i218 = ~iIdentityHashCode9;
            int i219 = i2016 + i216 + (((~(i218 | (-69992749))) | i217 | (~((-135170) | i218))) * 140);
            int i2110 = (i219 << 13) ^ i219;
            int i2111 = i2110 ^ (i2110 >>> 17);
            ((int[]) objArr1114[3])[0] = i2111 ^ (i2111 << 5);
        }
        i4 = 0;
        Context baseContext4 = getBaseContext();
        if (baseContext4 == null) {
            Object[] objArr124 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i4]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(i4, 4).length() + 22, new int[]{721578335, -1565849910, -2013940550, -695591454, 1577959775, 1568303289, -313253021, -1695859094, 634303605, -509814910, -1495177834, -540186052, -756860588, 1186567138}, objArr124);
            Class<?> cls20 = Class.forName((String) objArr124[i4]);
            Object[] objArr125 = new Object[1];
            a(18 - Color.argb(i4, i4, i4, i4), new int[]{251814919, 1633520329, -1093159096, -1871449063, -1297860173, 1957793086, 1873867491, -1451760763, -1519411634, -1318508961}, objArr125);
            baseContext4 = (Context) cls20.getMethod((String) objArr125[i4], new Class[i4]).invoke(null, null);
        }
        if (baseContext4 != null) {
            baseContext4 = ((baseContext4 instanceof ContextWrapper) && ((ContextWrapper) baseContext4).getBaseContext() == null) ? null : baseContext4.getApplicationContext();
        }
        int iIntValue3 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
        Object[] objArr126 = new Object[1];
        a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 43, new int[]{924476294, -1524966082, -1432962379, -1564483692, 788241735, 1448294982, -619763740, 1595140908, -1573834599, 1663186809, 916396762, 518000890, -100395087, 1379995261, -1003773881, 1202407466, -553079192, 1356092368, -2021281501, 1161713030, -201405973, 379645466, 752254269, -1268727194, -1060820478, -178409248, -469050245, -1527804314, -2062483578, 1542235150, -1060095813, 334754021}, objArr126);
        String str7 = (String) objArr126[0];
        Object[] objArr127 = new Object[1];
        a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(3) - 51, new int[]{1246284503, 2068163453, 1034748334, -546399201, -1400856268, -51246651, -291558693, -843457877, -1066954512, -904474346, 1426910357, -1942582244, -1046596761, -34997864, 1230131733, -1925189334, -1704894030, 1260803053, 1448833017, 584620990, -635684963, -610265885, 1600856950, -1714326272, -424976617, -1886434794, 1747820123, 1273084455, -1739047758, -710255530, -764489394, -1683883263}, objArr127);
        String[] strArr15 = {str7, (String) objArr127[0]};
        int i220 = artificialFrame + 121;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i220 % 128;
        int i221 = i220 % 2;
        Object[] objArr128 = {baseContext4, strArr15, Integer.valueOf(iIntValue3), 1, -1302219826};
        byte[] bArr51 = $$d;
        Object[] objArr129 = new Object[1];
        c((byte) (bArr51[23] - 1), (short) 271, bArr51[0], objArr129);
        Class<?> cls21 = Class.forName((String) objArr129[0]);
        byte b32 = bArr51[156];
        Object[] objArr130 = new Object[1];
        c(b32, (short) (b32 | 195), bArr51[101], objArr130);
        objArr4 = (Object[]) cls21.getMethod((String) objArr130[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr128);
        int i222 = ((int[]) objArr4[0])[0];
        int i223 = ((int[]) objArr4[3])[0];
        if (baseContext4 != null) {
            Object objAccessartificialFrame37 = ArtificialStackFrames.accessartificialFrame(1142731807);
            if (objAccessartificialFrame37 == null) {
                int scrollBarFadeDuration7 = 21 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                char pressedStateDuration4 = (char) (ViewConfiguration.getPressedStateDuration() >> 16);
                int keyRepeatDelay2 = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 465;
                byte[] bArr52 = $$a;
                Object[] objArr131 = new Object[1];
                b(bArr52[57], (byte) (bArr52[5] - 1), bArr52[18], objArr131);
                objAccessartificialFrame37 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration7, pressedStateDuration4, keyRepeatDelay2, -612765161, false, (String) objArr131[0], null);
            }
            ((Field) objAccessartificialFrame37).set(null, objArr4);
            try {
                Long lValueOf14 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame38 = ArtificialStackFrames.accessartificialFrame(1313006081);
                if (objAccessartificialFrame38 == null) {
                    int jumpTapTimeout = (ViewConfiguration.getJumpTapTimeout() >> 16) + 21;
                    char capsMode3 = (char) TextUtils.getCapsMode("", 0, 0);
                    int i224 = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 465;
                    byte[] bArr53 = $$a;
                    byte b33 = (byte) (bArr53[5] - 1);
                    Object[] objArr132 = new Object[1];
                    b(b33, b33, bArr53[18], objArr132);
                    objAccessartificialFrame38 = ArtificialStackFrames.coroutineCreation(jumpTapTimeout, capsMode3, i224, -785931255, false, (String) objArr132[0], null);
                }
                ((Field) objAccessartificialFrame38).set(null, lValueOf14);
            } catch (Exception unused8) {
                throw new RuntimeException();
            }
        }
        c = 0;
        i5 = ((int[]) objArr4[c])[c];
        i6 = ((int[]) objArr4[3])[c];
        if (i6 == i5) {
            Object[] objArr710 = new Object[4];
            int[] iArr3 = new int[1];
            objArr710[c] = iArr3;
            objArr710[2] = new int[1];
            int[] iArr4 = new int[1];
            objArr710[3] = iArr4;
            int i1310 = ((int[]) objArr4[2])[c];
            int i1410 = ((int[]) objArr4[3])[c];
            int i1411 = ((int[]) objArr4[c])[c];
            String[] strArr16 = (String[]) objArr4[1];
            iArr4[c] = i1410;
            iArr3[c] = i1411;
            int iIdentityHashCode10 = System.identityHashCode(this);
            int i1412 = ~iIdentityHashCode10;
            int i1413 = ~(890315765 | i1412);
            int i1414 = i1310 + 1865907189 + (((-1066625016) | i1413) * (-712)) + (((~(iIdentityHashCode10 | (-176309251))) | (~(i1412 | 1066625015))) * (-712)) + ((729966039 | i1413) * 712);
            int i1415 = (i1414 << 13) ^ i1414;
            int i1416 = i1415 ^ (i1415 >>> 17);
            ((int[]) objArr710[2])[0] = i1416 ^ (i1416 << 5);
            objArr710[1] = strArr16;
        } else {
            arrayList = new ArrayList();
            strArr = (String[]) objArr4[1];
            if (strArr != null) {
                while (i7 < strArr.length) {
                    arrayList.add(str5);
                }
            }
            Object[] objArr711 = {Long.valueOf(((long) (i5 ^ i6)) ^ (((long) 1553993881) << 32)), Long.valueOf(1553993945)};
            byte[] bArr310 = $$d;
            Object[] objArr810 = new Object[1];
            c(bArr310[183], (short) 195, bArr310[0], objArr810);
            Class<?> cls112 = Class.forName((String) objArr810[0]);
            byte b216 = bArr310[5];
            Object[] objArr811 = new Object[1];
            c(b216, (short) (b216 | 468), bArr310[210], objArr811);
            cls112.getMethod((String) objArr811[0], Long.TYPE, Long.TYPE).invoke(null, objArr711);
            Object[] objArr812 = {new int[]{i149}, strArr9, new int[1], new int[]{i148}};
            int i1417 = ((int[]) objArr4[2])[0];
            int i1418 = ((int[]) objArr4[3])[0];
            int i1419 = ((int[]) objArr4[0])[0];
            String[] strArr17 = (String[]) objArr4[1];
            int i1510 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 1389450418;
            int i1511 = (-465813043) + (((~((-772793551) | i1510)) | 168738894 | (~(612443824 | i1510))) * (-880));
            int i1512 = (~((-772793551) | (~i1510))) | (-612443825);
            int i1513 = ~(i1510 | 772793550);
            int i1514 = i1417 + i1511 + ((i1512 | i1513) * (-880)) + (i1513 * 880);
            int i1515 = (i1514 << 13) ^ i1514;
            int i1516 = i1515 ^ (i1515 >>> 17);
            ((int[]) objArr812[2])[0] = i1516 ^ (i1516 << 5);
        }
        super.onStart();
        objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(1056123296);
        if (objAccessartificialFrame8 == null) {
            int scrollBarFadeDuration8 = (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 30;
            char c10 = (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 49361);
            int trimmedLength5 = TextUtils.getTrimmedLength("") + 684;
            byte[] bArr311 = $$a;
            Object[] objArr813 = new Object[1];
            b((byte) 66, bArr311[9], bArr311[57], objArr813);
            objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration8, c10, trimmedLength5, -1583976536, false, (String) objArr813[0], null);
        }
        j = ((Field) objAccessartificialFrame8).getLong(null);
        if (j != -1) {
            Object[] objArr814 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), -716906627};
            byte[] bArr312 = $$d;
            Object[] objArr815 = new Object[1];
            c((byte) (bArr312[243] - 1), (short) 157, bArr312[89], objArr815);
            Class<?> cls113 = Class.forName((String) objArr815[0]);
            byte b217 = bArr312[4];
            Object[] objArr816 = new Object[1];
            c(b217, (short) (b217 | 100), bArr312[0], objArr816);
            objArr5 = (Object[]) cls113.getMethod((String) objArr816[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr814);
            objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(910856866);
            if (objAccessartificialFrame9 == null) {
                int mode3 = 30 - View.MeasureSpec.getMode(0);
                char c11 = (char) (49362 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)));
                int i1517 = (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 685;
                byte[] bArr313 = $$a;
                Object[] objArr817 = new Object[1];
                b((byte) 78, bArr313[11], bArr313[18], objArr817);
                objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(mode3, c11, i1517, -1456483158, false, (String) objArr817[0], null);
            }
            ((Field) objAccessartificialFrame9).set(null, objArr5);
            Long lValueOf15 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(1056123296);
            if (objAccessartificialFrame10 == null) {
                int i1518 = 30 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                char modifierMetaStateMask5 = (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 49363);
                int iLastIndexOf3 = TextUtils.lastIndexOf("", '0', 0, 0) + 685;
                byte[] bArr314 = $$a;
                Object[] objArr818 = new Object[1];
                b((byte) 66, bArr314[9], bArr314[57], objArr818);
                objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(i1518, modifierMetaStateMask5, iLastIndexOf3, -1583976536, false, (String) objArr818[0], null);
            }
            ((Field) objAccessartificialFrame10).set(null, lValueOf15);
        } else {
            Object[] objArr819 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), -716906627};
            byte[] bArr315 = $$d;
            Object[] objArr8110 = new Object[1];
            c((byte) (bArr315[243] - 1), (short) 157, bArr315[89], objArr8110);
            Class<?> cls114 = Class.forName((String) objArr8110[0]);
            byte b218 = bArr315[4];
            Object[] objArr8111 = new Object[1];
            c(b218, (short) (b218 | 100), bArr315[0], objArr8111);
            objArr5 = (Object[]) cls114.getMethod((String) objArr8111[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr819);
            objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(910856866);
            if (objAccessartificialFrame9 == null) {
                int mode4 = 30 - View.MeasureSpec.getMode(0);
                char c12 = (char) (49362 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)));
                int i1519 = (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 685;
                byte[] bArr316 = $$a;
                Object[] objArr8112 = new Object[1];
                b((byte) 78, bArr316[11], bArr316[18], objArr8112);
                objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(mode4, c12, i1519, -1456483158, false, (String) objArr8112[0], null);
            }
            ((Field) objAccessartificialFrame9).set(null, objArr5);
            Long lValueOf16 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(1056123296);
            if (objAccessartificialFrame10 == null) {
                int i15110 = 30 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                char modifierMetaStateMask6 = (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 49363);
                int iLastIndexOf4 = TextUtils.lastIndexOf("", '0', 0, 0) + 685;
                byte[] bArr317 = $$a;
                Object[] objArr8113 = new Object[1];
                b((byte) 66, bArr317[9], bArr317[57], objArr8113);
                objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(i15110, modifierMetaStateMask6, iLastIndexOf4, -1583976536, false, (String) objArr8113[0], null);
            }
            ((Field) objAccessartificialFrame10).set(null, lValueOf16);
        }
        i8 = ((int[]) objArr5[1])[0];
        i9 = ((int[]) objArr5[0])[0];
        if (i9 == i8) {
            int i1610 = ((int[]) objArr5[2])[0];
            Object[] objArr911 = {new int[]{((int[]) objArr5[0])[0]}, new int[]{((int[]) objArr5[1])[0]}, new int[1], (String) objArr5[3]};
            int iNextInt3 = new Random().nextInt(1761998875);
            int i1611 = ~iNextInt3;
            int i1612 = (~((-524726003) | i1611)) | 453291552;
            int i1613 = ~(iNextInt3 | 525332222);
            int i1614 = i1610 + (((i1612 | i1613) * (-252)) - 756022114) + ((i1613 | (~(i1611 | (-71434451)))) * 252);
            int i1615 = (i1614 << 13) ^ i1614;
            int i1616 = i1615 ^ (i1615 >>> 17);
            ((int[]) objArr911[2])[0] = i1616 ^ (i1616 << 5);
            i10 = 0;
        } else {
            new ArrayList().add((String) objArr5[3]);
            Object[] objArr912 = {Long.valueOf(((long) (i8 ^ i9)) ^ (((long) (-1343134863)) << 32)), Long.valueOf(-1343134879)};
            byte[] bArr318 = $$d;
            Object[] objArr913 = new Object[1];
            c(bArr318[288], (short) TypedValues.CycleType.TYPE_ALPHA, bArr318[0], objArr913);
            Class<?> cls115 = Class.forName((String) objArr913[0]);
            byte b219 = bArr318[5];
            Object[] objArr914 = new Object[1];
            c(b219, (short) (b219 | 468), bArr318[210], objArr914);
            cls115.getMethod((String) objArr914[0], Long.TYPE, Long.TYPE).invoke(null, objArr912);
            int i1710 = ((int[]) objArr5[2])[0];
            Object[] objArr915 = {new int[]{((int[]) objArr5[0])[0]}, new int[]{((int[]) objArr5[1])[0]}, new int[1], (String) objArr5[3]};
            int iIdentityHashCode11 = System.identityHashCode(this);
            int i1711 = ~iIdentityHashCode11;
            int i1712 = i1710 + 1552183774 + (((~((-642124168) | i1711)) | (-336499608) | (~(642124167 | iIdentityHashCode11))) * (-564)) + ((~(iIdentityHashCode11 | (-268997137))) * 1128) + (((~((-336499608) | i1711)) | (-911121304)) * 564);
            int i1713 = (i1712 << 13) ^ i1712;
            int i1714 = i1713 ^ (i1713 >>> 17);
            i10 = 0;
            ((int[]) objArr915[2])[0] = i1714 ^ (i1714 << 5);
        }
        objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(-2127922582);
        if (objAccessartificialFrame11 == null) {
            int maximumDrawingCacheSize2 = (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 30;
            char cArgb5 = (char) (Color.argb(i10, i10, i10, i10) + 49362);
            int scrollDefaultDelay5 = (ViewConfiguration.getScrollDefaultDelay() >> 16) + 684;
            byte b220 = (byte) ($$b | 68);
            byte[] bArr417 = $$a;
            Object[] objArr916 = new Object[1];
            b(b220, bArr417[8], bArr417[57], objArr916);
            objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(maximumDrawingCacheSize2, cArgb5, scrollDefaultDelay5, 508509282, false, (String) objArr916[0], null);
        }
        j2 = ((Field) objAccessartificialFrame11).getLong(null);
        if (j2 != -1) {
            if (j2 + 1963 >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(777251007);
                if (objAccessartificialFrame18 == null) {
                    int iGreen5 = 30 - Color.green(0);
                    char cIndexOf4 = (char) (TextUtils.indexOf("", "") + 49362);
                    int keyRepeatTimeout2 = 684 - (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                    byte[] bArr418 = $$a;
                    Object[] objArr917 = new Object[1];
                    b((byte) 98, bArr418[57], bArr418[88], objArr917);
                    objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(iGreen5, cIndexOf4, keyRepeatTimeout2, -1321816393, false, (String) objArr917[0], null);
                }
                Object[] objArr918 = (Object[]) ((Field) objAccessartificialFrame18).get(null);
                objArr6 = new Object[]{new int[]{((int[]) objArr918[0])[0]}, new int[]{((int[]) objArr918[1])[0]}, new int[1], (String) objArr918[3]};
                int i1715 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().touchscreen;
                int i1716 = ~i1715;
                int i1717 = ((((-1508821074) + ((((~((-523294475) | i1716)) | 455132672) | (~((-455329301) | i1716))) * (-1136))) + ((((~((-523294475) | i1715)) | (~((-455329301) | i1715))) | (~(523491102 | i1716))) * (-568))) + (((~(i1715 | (-455132673))) | ((~(i1716 | 455329300)) | (~(523294474 | i1716)))) * 568)) - 713052149;
                int i1718 = (i1717 << 13) ^ i1717;
                int i1719 = i1718 ^ (i1718 >>> 17);
                ((int[]) objArr6[2])[0] = i1719 ^ (i1719 << 5);
            } else {
                i11 = 0;
            }
            i12 = ((int[]) objArr6[1])[0];
            i13 = ((int[]) objArr6[0])[0];
            if (i13 == i12) {
                int i18110 = artificialFrame + 11;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i18110 % 128;
                int i18111 = i18110 % 2;
                int i18112 = ((int[]) objArr6[2])[0];
                Object[] objArr919 = {new int[]{((int[]) objArr6[0])[0]}, new int[]{((int[]) objArr6[1])[0]}, new int[1], (String) objArr6[3]};
                int length3 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 996539712;
                int i18113 = ~length3;
                int i18114 = i18112 + (-104172642) + ((67108880 | i18113) * (-192)) + (((~(67397938 | i18113)) | 978912833) * (-384)) + (((~(length3 | (-289059))) | (~(i18113 | 1046310771)) | (~((-978912834) | length3))) * JfifUtil.MARKER_SOFn);
                int i18115 = (i18114 << 13) ^ i18114;
                int i18116 = i18115 ^ (i18115 >>> 17);
                i14 = 0;
                ((int[]) objArr919[2])[0] = i18116 ^ (i18116 << 5);
            } else {
                long j13 = ((long) (i12 ^ i13)) ^ (((long) 183305586) << 32);
                long j14 = 183306098;
                int i18117 = artificialFrame + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i18117 % 128;
                int i18118 = i18117 % 2;
                Object[] objArr10115 = {Long.valueOf(j13), Long.valueOf(j14)};
                byte[] bArr419 = $$d;
                Object[] objArr10116 = new Object[1];
                c(bArr419[288], (short) TypedValues.CycleType.TYPE_ALPHA, bArr419[0], objArr10116);
                Class<?> cls116 = Class.forName((String) objArr10116[0]);
                byte b2110 = bArr419[5];
                Object[] objArr10117 = new Object[1];
                c(b2110, (short) (b2110 | 468), bArr419[210], objArr10117);
                cls116.getMethod((String) objArr10117[0], Long.TYPE, Long.TYPE).invoke(null, objArr10115);
                int i18119 = ((int[]) objArr6[2])[0];
                Object[] objArr10118 = {new int[]{((int[]) objArr6[0])[0]}, new int[]{((int[]) objArr6[1])[0]}, new int[1], (String) objArr6[3]};
                int i1915 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().touchscreen;
                int i1916 = i18119 + 563769436 + (((~((-176467521) | (~i1915))) | (-802156255)) * (-591)) + ((i1915 | (-176467521)) * 591);
                int i1917 = (i1916 << 13) ^ i1916;
                int i1918 = i1917 ^ (i1917 >>> 17);
                i14 = 0;
                ((int[]) objArr10118[2])[0] = i1918 ^ (i1918 << 5);
            }
            objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame14 == null) {
                int defaultSize3 = 25 - View.getDefaultSize(i14, i14);
                char cLastIndexOf3 = (char) (30067 - TextUtils.lastIndexOf("", '0'));
                int iMyPid5 = 816 - (Process.myPid() >> 22);
                byte[] bArr4110 = $$a;
                byte b2111 = (byte) (bArr4110[5] - 1);
                Object[] objArr10119 = new Object[1];
                b(b2111, b2111, bArr4110[18], objArr10119);
                objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(defaultSize3, cLastIndexOf3, iMyPid5, 721586079, false, (String) objArr10119[0], null);
            }
            j3 = ((Field) objAccessartificialFrame14).getLong(null);
            if (j3 != -1) {
                Object[] objArr101110 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 1855704524};
                objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(1327366003);
                if (objAccessartificialFrame15 == null) {
                    int iMakeMeasureSpec4 = 25 - View.MeasureSpec.makeMeasureSpec(0, 0);
                    char modifierMetaStateMask7 = (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 30069);
                    int maximumFlingVelocity8 = 816 - (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                    Object[] objArr101111 = new Object[1];
                    b((byte) 105, (byte) 28, $$a[9], objArr101111);
                    objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(iMakeMeasureSpec4, modifierMetaStateMask7, maximumFlingVelocity8, -797394565, false, (String) objArr101111[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                }
                Object[] objArr101112 = (Object[]) ((Method) objAccessartificialFrame15).invoke(null, objArr101110);
                objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame16 == null) {
                    int scrollBarFadeDuration9 = 25 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                    char cArgb6 = (char) (30068 - Color.argb(0, 0, 0, 0));
                    int size6 = View.MeasureSpec.getSize(0) + 816;
                    byte[] bArr4111 = $$a;
                    Object[] objArr101113 = new Object[1];
                    b(bArr4111[57], (byte) (bArr4111[5] - 1), bArr4111[18], objArr101113);
                    objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration9, cArgb6, size6, 891606461, false, (String) objArr101113[0], null);
                }
                ((Field) objAccessartificialFrame16).set(null, objArr101112);
                Long lValueOf17 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                if (objAccessartificialFrame17 == null) {
                    int iGreen6 = 25 - Color.green(0);
                    char c13 = (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 30067);
                    int pressedStateDuration5 = (ViewConfiguration.getPressedStateDuration() >> 16) + 816;
                    byte[] bArr4112 = $$a;
                    byte b2112 = (byte) (bArr4112[5] - 1);
                    Object[] objArr101114 = new Object[1];
                    b(b2112, b2112, bArr4112[18], objArr101114);
                    objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(iGreen6, c13, pressedStateDuration5, 721586079, false, (String) objArr101114[0], null);
                }
                ((Field) objAccessartificialFrame17).set(null, lValueOf17);
                objArr7 = objArr101112;
            } else {
                Object[] objArr101115 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 1855704524};
                objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(1327366003);
                if (objAccessartificialFrame15 == null) {
                    int iMakeMeasureSpec5 = 25 - View.MeasureSpec.makeMeasureSpec(0, 0);
                    char modifierMetaStateMask8 = (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 30069);
                    int maximumFlingVelocity9 = 816 - (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                    Object[] objArr101116 = new Object[1];
                    b((byte) 105, (byte) 28, $$a[9], objArr101116);
                    objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(iMakeMeasureSpec5, modifierMetaStateMask8, maximumFlingVelocity9, -797394565, false, (String) objArr101116[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                }
                Object[] objArr101117 = (Object[]) ((Method) objAccessartificialFrame15).invoke(null, objArr101115);
                objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame16 == null) {
                    int scrollBarFadeDuration10 = 25 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                    char cArgb7 = (char) (30068 - Color.argb(0, 0, 0, 0));
                    int size7 = View.MeasureSpec.getSize(0) + 816;
                    byte[] bArr4113 = $$a;
                    Object[] objArr101118 = new Object[1];
                    b(bArr4113[57], (byte) (bArr4113[5] - 1), bArr4113[18], objArr101118);
                    objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration10, cArgb7, size7, 891606461, false, (String) objArr101118[0], null);
                }
                ((Field) objAccessartificialFrame16).set(null, objArr101117);
                Long lValueOf18 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                if (objAccessartificialFrame17 == null) {
                    int iGreen7 = 25 - Color.green(0);
                    char c14 = (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 30067);
                    int pressedStateDuration6 = (ViewConfiguration.getPressedStateDuration() >> 16) + 816;
                    byte[] bArr4114 = $$a;
                    byte b2113 = (byte) (bArr4114[5] - 1);
                    Object[] objArr101119 = new Object[1];
                    b(b2113, b2113, bArr4114[18], objArr101119);
                    objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(iGreen7, c14, pressedStateDuration6, 721586079, false, (String) objArr101119[0], null);
                }
                ((Field) objAccessartificialFrame17).set(null, lValueOf18);
                objArr7 = objArr101117;
            }
            i15 = ((int[]) objArr7[1])[0];
            i16 = ((int[]) objArr7[0])[0];
            if (i16 == i15) {
                Object[] objArr1115 = {new int[]{i2010}, new int[]{i2011}, strArr13, new int[1]};
                int i1919 = ((int[]) objArr7[3])[0];
                int i20110 = ((int[]) objArr7[0])[0];
                int i20111 = ((int[]) objArr7[1])[0];
                String[] strArr18 = (String[]) objArr7[2];
                int iIdentityHashCode12 = System.identityHashCode(this);
                int i20112 = ~iIdentityHashCode12;
                int i20113 = i1919 + (((~(1073344466 | i20112)) | (~((-100671875) | iIdentityHashCode12))) * 988) + 220654249 + (((~(iIdentityHashCode12 | 774500226)) | 298844240 | (~(i20112 | (-100671875)))) * 988);
                int i20114 = (i20113 << 13) ^ i20113;
                int i20115 = i20114 ^ (i20114 >>> 17);
                ((int[]) objArr1115[3])[0] = i20115 ^ (i20115 << 5);
                return;
            }
            arrayList2 = new ArrayList();
            strArr2 = (String[]) objArr7[2];
            if (strArr2 != null) {
                while (i17 < strArr2.length) {
                    arrayList2.add(str6);
                }
            }
            Object[] objArr1116 = {Long.valueOf(((long) (i15 ^ i16)) ^ (((long) 614400810) << 32)), Long.valueOf(614400811)};
            byte[] bArr4115 = $$d;
            byte b2114 = (byte) (-bArr4115[219]);
            Object[] objArr1117 = new Object[1];
            c(b2114, b2114, bArr4115[0], objArr1117);
            Class<?> cls117 = Class.forName((String) objArr1117[0]);
            byte b2115 = bArr4115[5];
            Object[] objArr1118 = new Object[1];
            c(b2115, (short) (b2115 | 468), bArr4115[210], objArr1118);
            cls117.getMethod((String) objArr1118[0], Long.TYPE, Long.TYPE).invoke(null, objArr1116);
            Object[] objArr1119 = {new int[]{i2017}, new int[]{i2018}, strArr14, new int[1]};
            int i20116 = ((int[]) objArr7[3])[0];
            int i20117 = ((int[]) objArr7[0])[0];
            int i20118 = ((int[]) objArr7[1])[0];
            String[] strArr19 = (String[]) objArr7[2];
            int iIdentityHashCode13 = System.identityHashCode(this);
            int i20119 = ~((-64157394) | iIdentityHashCode13);
            int i2112 = (-991954103) + ((135169 | i20119) * (-280)) + ((i20119 | (~((-134014973) | iIdentityHashCode13))) * 140);
            int i2113 = ~((-64022225) | iIdentityHashCode13);
            int i2114 = ~iIdentityHashCode13;
            int i2115 = i20116 + i2112 + (((~(i2114 | (-69992749))) | i2113 | (~((-135170) | i2114))) * 140);
            int i2116 = (i2115 << 13) ^ i2115;
            int i2117 = i2116 ^ (i2116 >>> 17);
            ((int[]) objArr1119[3])[0] = i2117 ^ (i2117 << 5);
        }
        i11 = 0;
        baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr1120 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i11]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(i11, 4).codePointAt(2) - 10, new int[]{721578335, -1565849910, -2013940550, -695591454, 1577959775, 1568303289, -313253021, -1695859094, 634303605, -509814910, -1495177834, -540186052, -756860588, 1186567138}, objArr1120);
            Class<?> cls118 = Class.forName((String) objArr1120[i11]);
            Object[] objArr1121 = new Object[1];
            a((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 18, new int[]{251814919, 1633520329, -1093159096, -1871449063, -1297860173, 1957793086, 1873867491, -1451760763, -1519411634, -1318508961}, objArr1121);
            baseContext = (Context) cls118.getMethod((String) objArr1121[i11], new Class[i11]).invoke(null, null);
        }
        if (baseContext != null) {
            if (!(baseContext instanceof ContextWrapper)) {
                baseContext = baseContext.getApplicationContext();
            } else {
                baseContext = null;
            }
        }
        Object[] objArr1122 = {baseContext, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), -713052149};
        byte[] bArr420 = $$d;
        byte b221 = bArr420[164];
        Object[] objArr1210 = new Object[1];
        c(b221, (short) (b221 | SignedBytes.MAX_POWER_OF_TWO), bArr420[0], objArr1210);
        Class<?> cls119 = Class.forName((String) objArr1210[0]);
        byte b34 = bArr420[156];
        Object[] objArr1211 = new Object[1];
        c(b34, (short) (b34 | 195), bArr420[101], objArr1211);
        objArr6 = (Object[]) cls119.getMethod((String) objArr1211[0], Context.class, Integer.TYPE, Integer.TYPE).invoke(null, objArr1122);
        if (baseContext != null) {
            objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(777251007);
            if (objAccessartificialFrame12 == null) {
                int windowTouchSlop2 = 30 - (ViewConfiguration.getWindowTouchSlop() >> 8);
                char c15 = (char) (49362 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)));
                int minimumFlingVelocity4 = (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 684;
                byte[] bArr421 = $$a;
                Object[] objArr1212 = new Object[1];
                b((byte) 98, bArr421[57], bArr421[88], objArr1212);
                objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(windowTouchSlop2, c15, minimumFlingVelocity4, -1321816393, false, (String) objArr1212[0], null);
            }
            ((Field) objAccessartificialFrame12).set(null, objArr6);
            Long lValueOf19 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(-2127922582);
            if (objAccessartificialFrame13 == null) {
                int maximumFlingVelocity10 = 30 - (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                char cIndexOf5 = (char) (TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 49363);
                int deadChar5 = 684 - KeyEvent.getDeadChar(0, 0);
                byte b35 = (byte) ($$b | 68);
                byte[] bArr54 = $$a;
                Object[] objArr1213 = new Object[1];
                b(b35, bArr54[8], bArr54[57], objArr1213);
                objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(maximumFlingVelocity10, cIndexOf5, deadChar5, 508509282, false, (String) objArr1213[0], null);
            }
            ((Field) objAccessartificialFrame13).set(null, lValueOf19);
        }
        i12 = ((int[]) objArr6[1])[0];
        i13 = ((int[]) objArr6[0])[0];
        if (i13 == i12) {
            int i181110 = artificialFrame + 11;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i181110 % 128;
            int i181111 = i181110 % 2;
            int i181112 = ((int[]) objArr6[2])[0];
            Object[] objArr9110 = {new int[]{((int[]) objArr6[0])[0]}, new int[]{((int[]) objArr6[1])[0]}, new int[1], (String) objArr6[3]};
            int length4 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 996539712;
            int i181113 = ~length4;
            int i181114 = i181112 + (-104172642) + ((67108880 | i181113) * (-192)) + (((~(67397938 | i181113)) | 978912833) * (-384)) + (((~(length4 | (-289059))) | (~(i181113 | 1046310771)) | (~((-978912834) | length4))) * JfifUtil.MARKER_SOFn);
            int i181115 = (i181114 << 13) ^ i181114;
            int i181116 = i181115 ^ (i181115 >>> 17);
            i14 = 0;
            ((int[]) objArr9110[2])[0] = i181116 ^ (i181116 << 5);
        } else {
            long j15 = ((long) (i12 ^ i13)) ^ (((long) 183305586) << 32);
            long j16 = 183306098;
            int i181117 = artificialFrame + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i181117 % 128;
            int i181118 = i181117 % 2;
            Object[] objArr101120 = {Long.valueOf(j15), Long.valueOf(j16)};
            byte[] bArr4116 = $$d;
            Object[] objArr101121 = new Object[1];
            c(bArr4116[288], (short) TypedValues.CycleType.TYPE_ALPHA, bArr4116[0], objArr101121);
            Class<?> cls1110 = Class.forName((String) objArr101121[0]);
            byte b2116 = bArr4116[5];
            Object[] objArr101122 = new Object[1];
            c(b2116, (short) (b2116 | 468), bArr4116[210], objArr101122);
            cls1110.getMethod((String) objArr101122[0], Long.TYPE, Long.TYPE).invoke(null, objArr101120);
            int i181119 = ((int[]) objArr6[2])[0];
            Object[] objArr101123 = {new int[]{((int[]) objArr6[0])[0]}, new int[]{((int[]) objArr6[1])[0]}, new int[1], (String) objArr6[3]};
            int i19110 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().touchscreen;
            int i19111 = i181119 + 563769436 + (((~((-176467521) | (~i19110))) | (-802156255)) * (-591)) + ((i19110 | (-176467521)) * 591);
            int i19112 = (i19111 << 13) ^ i19111;
            int i19113 = i19112 ^ (i19112 >>> 17);
            i14 = 0;
            ((int[]) objArr101123[2])[0] = i19113 ^ (i19113 << 5);
        }
        objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame14 == null) {
            int defaultSize4 = 25 - View.getDefaultSize(i14, i14);
            char cLastIndexOf4 = (char) (30067 - TextUtils.lastIndexOf("", '0'));
            int iMyPid6 = 816 - (Process.myPid() >> 22);
            byte[] bArr4117 = $$a;
            byte b2117 = (byte) (bArr4117[5] - 1);
            Object[] objArr101124 = new Object[1];
            b(b2117, b2117, bArr4117[18], objArr101124);
            objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(defaultSize4, cLastIndexOf4, iMyPid6, 721586079, false, (String) objArr101124[0], null);
        }
        j3 = ((Field) objAccessartificialFrame14).getLong(null);
        if (j3 != -1) {
            Object[] objArr1011110 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 1855704524};
            objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame15 == null) {
                int iMakeMeasureSpec6 = 25 - View.MeasureSpec.makeMeasureSpec(0, 0);
                char modifierMetaStateMask9 = (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 30069);
                int maximumFlingVelocity11 = 816 - (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                Object[] objArr1011111 = new Object[1];
                b((byte) 105, (byte) 28, $$a[9], objArr1011111);
                objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(iMakeMeasureSpec6, modifierMetaStateMask9, maximumFlingVelocity11, -797394565, false, (String) objArr1011111[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            Object[] objArr1011112 = (Object[]) ((Method) objAccessartificialFrame15).invoke(null, objArr1011110);
            objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame16 == null) {
                int scrollBarFadeDuration11 = 25 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                char cArgb8 = (char) (30068 - Color.argb(0, 0, 0, 0));
                int size8 = View.MeasureSpec.getSize(0) + 816;
                byte[] bArr4118 = $$a;
                Object[] objArr1011113 = new Object[1];
                b(bArr4118[57], (byte) (bArr4118[5] - 1), bArr4118[18], objArr1011113);
                objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration11, cArgb8, size8, 891606461, false, (String) objArr1011113[0], null);
            }
            ((Field) objAccessartificialFrame16).set(null, objArr1011112);
            Long lValueOf110 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame17 == null) {
                int iGreen8 = 25 - Color.green(0);
                char c16 = (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 30067);
                int pressedStateDuration7 = (ViewConfiguration.getPressedStateDuration() >> 16) + 816;
                byte[] bArr4119 = $$a;
                byte b2118 = (byte) (bArr4119[5] - 1);
                Object[] objArr1011114 = new Object[1];
                b(b2118, b2118, bArr4119[18], objArr1011114);
                objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(iGreen8, c16, pressedStateDuration7, 721586079, false, (String) objArr1011114[0], null);
            }
            ((Field) objAccessartificialFrame17).set(null, lValueOf110);
            objArr7 = objArr1011112;
        } else {
            Object[] objArr1011115 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 1855704524};
            objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame15 == null) {
                int iMakeMeasureSpec7 = 25 - View.MeasureSpec.makeMeasureSpec(0, 0);
                char modifierMetaStateMask10 = (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 30069);
                int maximumFlingVelocity12 = 816 - (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                Object[] objArr1011116 = new Object[1];
                b((byte) 105, (byte) 28, $$a[9], objArr1011116);
                objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(iMakeMeasureSpec7, modifierMetaStateMask10, maximumFlingVelocity12, -797394565, false, (String) objArr1011116[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            Object[] objArr1011117 = (Object[]) ((Method) objAccessartificialFrame15).invoke(null, objArr1011115);
            objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame16 == null) {
                int scrollBarFadeDuration12 = 25 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                char cArgb9 = (char) (30068 - Color.argb(0, 0, 0, 0));
                int size9 = View.MeasureSpec.getSize(0) + 816;
                byte[] bArr41110 = $$a;
                Object[] objArr1011118 = new Object[1];
                b(bArr41110[57], (byte) (bArr41110[5] - 1), bArr41110[18], objArr1011118);
                objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration12, cArgb9, size9, 891606461, false, (String) objArr1011118[0], null);
            }
            ((Field) objAccessartificialFrame16).set(null, objArr1011117);
            Long lValueOf111 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame17 == null) {
                int iGreen9 = 25 - Color.green(0);
                char c17 = (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 30067);
                int pressedStateDuration8 = (ViewConfiguration.getPressedStateDuration() >> 16) + 816;
                byte[] bArr41111 = $$a;
                byte b2119 = (byte) (bArr41111[5] - 1);
                Object[] objArr1011119 = new Object[1];
                b(b2119, b2119, bArr41111[18], objArr1011119);
                objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(iGreen9, c17, pressedStateDuration8, 721586079, false, (String) objArr1011119[0], null);
            }
            ((Field) objAccessartificialFrame17).set(null, lValueOf111);
            objArr7 = objArr1011117;
        }
        i15 = ((int[]) objArr7[1])[0];
        i16 = ((int[]) objArr7[0])[0];
        if (i16 == i15) {
            Object[] objArr11110 = {new int[]{i20110}, new int[]{i20111}, strArr18, new int[1]};
            int i19114 = ((int[]) objArr7[3])[0];
            int i201110 = ((int[]) objArr7[0])[0];
            int i201111 = ((int[]) objArr7[1])[0];
            String[] strArr110 = (String[]) objArr7[2];
            int iIdentityHashCode14 = System.identityHashCode(this);
            int i201112 = ~iIdentityHashCode14;
            int i201113 = i19114 + (((~(1073344466 | i201112)) | (~((-100671875) | iIdentityHashCode14))) * 988) + 220654249 + (((~(iIdentityHashCode14 | 774500226)) | 298844240 | (~(i201112 | (-100671875)))) * 988);
            int i201114 = (i201113 << 13) ^ i201113;
            int i201115 = i201114 ^ (i201114 >>> 17);
            ((int[]) objArr11110[3])[0] = i201115 ^ (i201115 << 5);
            return;
        }
        arrayList2 = new ArrayList();
        strArr2 = (String[]) objArr7[2];
        if (strArr2 != null) {
            while (i17 < strArr2.length) {
                arrayList2.add(str6);
            }
        }
        Object[] objArr11111 = {Long.valueOf(((long) (i15 ^ i16)) ^ (((long) 614400810) << 32)), Long.valueOf(614400811)};
        byte[] bArr41112 = $$d;
        byte b21110 = (byte) (-bArr41112[219]);
        Object[] objArr11112 = new Object[1];
        c(b21110, b21110, bArr41112[0], objArr11112);
        Class<?> cls1111 = Class.forName((String) objArr11112[0]);
        byte b21111 = bArr41112[5];
        Object[] objArr11113 = new Object[1];
        c(b21111, (short) (b21111 | 468), bArr41112[210], objArr11113);
        cls1111.getMethod((String) objArr11113[0], Long.TYPE, Long.TYPE).invoke(null, objArr11111);
        Object[] objArr11114 = {new int[]{i20117}, new int[]{i20118}, strArr19, new int[1]};
        int i201116 = ((int[]) objArr7[3])[0];
        int i201117 = ((int[]) objArr7[0])[0];
        int i201118 = ((int[]) objArr7[1])[0];
        String[] strArr111 = (String[]) objArr7[2];
        int iIdentityHashCode15 = System.identityHashCode(this);
        int i201119 = ~((-64157394) | iIdentityHashCode15);
        int i2118 = (-991954103) + ((135169 | i201119) * (-280)) + ((i201119 | (~((-134014973) | iIdentityHashCode15))) * 140);
        int i2119 = ~((-64022225) | iIdentityHashCode15);
        int i21110 = ~iIdentityHashCode15;
        int i21111 = i201116 + i2118 + (((~(i21110 | (-69992749))) | i2119 | (~((-135170) | i21110))) * 140);
        int i21112 = (i21111 << 13) ^ i21111;
        int i21113 = i21112 ^ (i21112 >>> 17);
        ((int[]) objArr11114[3])[0] = i21113 ^ (i21113 << 5);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onResume() throws Throwable {
        int i = 2 % 2;
        int i2 = getARTIFICIAL_FRAME_PACKAGE_NAME + 53;
        artificialFrame = i2 % 128;
        if (i2 % 2 == 0) {
            Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(949068051);
            if (objAccessartificialFrame == null) {
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 30, (char) (49993 - (ViewConfiguration.getKeyRepeatDelay() >> 16)), (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 73, -1477122277, false, "MediaDescriptionCompatApi23Builder", null);
            }
            Object obj = ((Field) objAccessartificialFrame).get(null);
            try {
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1579113874);
                if (objAccessartificialFrame2 == null) {
                    int deadChar = 30 - KeyEvent.getDeadChar(0, 0);
                    char c = (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 49992);
                    int iRed = Color.red(0) + 74;
                    byte[] bArr = $$d;
                    byte b = bArr[89];
                    Object[] objArr = new Object[1];
                    c(b, b, bArr[16], objArr);
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(deadChar, c, iRed, -1048962150, false, (String) objArr[0], new Class[0]);
                }
                ((Method) objAccessartificialFrame2).invoke(obj, null);
                super.onResume();
                int i3 = 20 / 0;
                return;
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(949068051);
        if (objAccessartificialFrame3 == null) {
            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(30 - (ViewConfiguration.getEdgeSlop() >> 16), (char) (49993 - View.resolveSize(0, 0)), TextUtils.indexOf((CharSequence) "", '0', 0) + 75, -1477122277, false, "MediaDescriptionCompatApi23Builder", null);
        }
        Object obj2 = ((Field) objAccessartificialFrame3).get(null);
        try {
            Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1579113874);
            if (objAccessartificialFrame4 == null) {
                int iLastIndexOf = TextUtils.lastIndexOf("", '0') + 31;
                char touchSlop = (char) (49993 - (ViewConfiguration.getTouchSlop() >> 8));
                int i4 = 75 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                byte[] bArr2 = $$d;
                byte b2 = bArr2[89];
                Object[] objArr2 = new Object[1];
                c(b2, b2, bArr2[16], objArr2);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(iLastIndexOf, touchSlop, i4, -1048962150, false, (String) objArr2[0], new Class[0]);
            }
            ((Method) objAccessartificialFrame4).invoke(obj2, null);
            super.onResume();
        } catch (Throwable th2) {
            Throwable cause2 = th2.getCause();
            if (cause2 == null) {
                throw th2;
            }
            throw cause2;
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onPause() throws Throwable {
        int i = 2 % 2;
        int i2 = artificialFrame + 35;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i2 % 128;
        int i3 = i2 % 2;
        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(949068051);
        if (objAccessartificialFrame == null) {
            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(30 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (char) ((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 49993), 74 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), -1477122277, false, "MediaDescriptionCompatApi23Builder", null);
        }
        Object obj = ((Field) objAccessartificialFrame).get(null);
        try {
            Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1579114835);
            if (objAccessartificialFrame2 == null) {
                int iIndexOf = TextUtils.indexOf((CharSequence) "", '0') + 31;
                char cBlue = (char) (49993 - Color.blue(0));
                int i4 = (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 73;
                byte[] bArr = $$d;
                byte b = bArr[89];
                Object[] objArr = new Object[1];
                c(b, b, bArr[0], objArr);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iIndexOf, cBlue, i4, -1048959141, false, (String) objArr[0], new Class[0]);
            }
            ((Method) objAccessartificialFrame2).invoke(obj, null);
            super.onPause();
            int i5 = getARTIFICIAL_FRAME_PACKAGE_NAME + 59;
            artificialFrame = i5 % 128;
            int i6 = i5 % 2;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:16:0x0246 A[Catch: all -> 0x0a37, TryCatch #0 {all -> 0x0a37, blocks: (B:51:0x0705, B:53:0x0719, B:54:0x0749, B:14:0x0225, B:16:0x0246, B:17:0x0293), top: B:94:0x0225 }] */
    /* JADX WARN: Code duplicated, block: B:20:0x02a5  */
    /* JADX WARN: Code duplicated, block: B:25:0x035f  */
    /* JADX WARN: Code duplicated, block: B:50:0x0698  */
    /* JADX WARN: Code duplicated, block: B:53:0x0719 A[Catch: all -> 0x0a37, TryCatch #0 {all -> 0x0a37, blocks: (B:51:0x0705, B:53:0x0719, B:54:0x0749, B:14:0x0225, B:16:0x0246, B:17:0x0293), top: B:94:0x0225 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x075f  */
    /* JADX WARN: Code duplicated, block: B:62:0x0830  */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) throws Throwable {
        Object objAccessartificialFrame;
        Object[] objArr;
        Object objAccessartificialFrame2;
        Object objAccessartificialFrame3;
        Object objAccessartificialFrame4;
        Object[] objArrAccessartificialFrame$78cbbd35;
        Object objAccessartificialFrame5;
        Object objAccessartificialFrame6;
        char c;
        int i = 2 % 2;
        int i2 = artificialFrame + 21;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i2 % 128;
        int i3 = i2 % 2;
        super.attachBaseContext(context);
        Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame7 == null) {
            int iMyPid = 25 - (Process.myPid() >> 22);
            char cRed = (char) (30068 - Color.red(0));
            int i4 = 816 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
            byte[] bArr = $$a;
            byte b = (byte) (bArr[5] - 1);
            Object[] objArr2 = new Object[1];
            b(b, b, bArr[18], objArr2);
            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(iMyPid, cRed, i4, 721586079, false, (String) objArr2[0], null);
        }
        long j = ((Field) objAccessartificialFrame7).getLong(null);
        if (j != -1) {
            int i5 = getARTIFICIAL_FRAME_PACKAGE_NAME + 97;
            artificialFrame = i5 % 128;
            int i6 = i5 % 2;
            long j2 = j + 1926;
            Object[] objArr3 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 18, new int[]{721578335, -1565849910, -2013940550, -695591454, 776370029, -1075895906, 77418597, 185607679, -548190626, 1264014842, -1929241007, 392198446}, objArr3);
            Class<?> cls = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 11, new int[]{-1501823017, 1270962718, -171413344, -969408767, 1037446900, -779947746, -2099513253, -908342076}, objArr4);
            if (j2 >= ((Long) cls.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame8 == null) {
                    int i7 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 25;
                    char c2 = (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 30067);
                    int i8 = 817 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                    byte[] bArr2 = $$a;
                    Object[] objArr5 = new Object[1];
                    b(bArr2[57], (byte) (bArr2[5] - 1), bArr2[18], objArr5);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(i7, c2, i8, 891606461, false, (String) objArr5[0], null);
                }
                Object[] objArr6 = (Object[]) ((Field) objAccessartificialFrame8).get(null);
                objArr = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i9 = ((int[]) objArr6[0])[0];
                int i10 = ((int[]) objArr6[1])[0];
                String[] strArr = (String[]) objArr6[2];
                int iIdentityHashCode = System.identityHashCode(this);
                int i11 = (-2001068339) + (((~(235144179 | iIdentityHashCode)) | 433316545) * (-366)) + (((~(iIdentityHashCode | 534242291)) | 134218433) * 366) + 1649738283;
                int i12 = (i11 << 13) ^ i11;
                int i13 = i12 ^ (i12 >>> 17);
                ((int[]) objArr[3])[0] = i13 ^ (i13 << 5);
            } else {
                Object[] objArr7 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 20, new int[]{-517413556, -1248007819, 952129232, -1812122499, 167904363, -1248444044, 1370902927, 476569326}, objArr7);
                Class<?> cls2 = Class.forName((String) objArr7[0]);
                Object[] objArr8 = new Object[1];
                a(16 - (ViewConfiguration.getWindowTouchSlop() >> 8), new int[]{-1519391270, -2054469892, -258456670, -822058583, -626898694, 1527937918, -687209262, -1307792301}, objArr8);
                try {
                    Object[] objArr9 = {Integer.valueOf(((Integer) cls2.getMethod((String) objArr8[0], Object.class).invoke(null, this)).intValue()), 0, 1649738283};
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1327366003);
                    if (objAccessartificialFrame == null) {
                        int iNormalizeMetaState = 25 - KeyEvent.normalizeMetaState(0);
                        char doubleTapTimeout = (char) ((ViewConfiguration.getDoubleTapTimeout() >> 16) + 30068);
                        int longPressTimeout = (ViewConfiguration.getLongPressTimeout() >> 16) + 816;
                        Object[] objArr10 = new Object[1];
                        b((byte) 105, (byte) 28, $$a[9], objArr10);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(iNormalizeMetaState, doubleTapTimeout, longPressTimeout, -797394565, false, (String) objArr10[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    objArr = (Object[]) ((Method) objAccessartificialFrame).invoke(null, objArr9);
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                    if (objAccessartificialFrame2 == null) {
                        int i14 = (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 25;
                        char cAxisFromString = (char) (MotionEvent.axisFromString("") + 30069);
                        int offsetAfter = TextUtils.getOffsetAfter("", 0) + 816;
                        byte[] bArr3 = $$a;
                        Object[] objArr11 = new Object[1];
                        b(bArr3[57], (byte) (bArr3[5] - 1), bArr3[18], objArr11);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(i14, cAxisFromString, offsetAfter, 891606461, false, (String) objArr11[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, objArr);
                    try {
                        Object[] objArr12 = new Object[1];
                        a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 18, new int[]{721578335, -1565849910, -2013940550, -695591454, 776370029, -1075895906, 77418597, 185607679, -548190626, 1264014842, -1929241007, 392198446}, objArr12);
                        Class<?> cls3 = Class.forName((String) objArr12[0]);
                        Object[] objArr13 = new Object[1];
                        a((ViewConfiguration.getTapTimeout() >> 16) + 15, new int[]{-1501823017, 1270962718, -171413344, -969408767, 1037446900, -779947746, -2099513253, -908342076}, objArr13);
                        Long lValueOf = Long.valueOf(((Long) cls3.getDeclaredMethod((String) objArr13[0], new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                        if (objAccessartificialFrame3 == null) {
                            int iIndexOf = TextUtils.indexOf((CharSequence) "", '0') + 26;
                            char maxKeyCode = (char) ((KeyEvent.getMaxKeyCode() >> 16) + 30068);
                            int defaultSize = 816 - View.getDefaultSize(0, 0);
                            byte[] bArr4 = $$a;
                            byte b2 = (byte) (bArr4[5] - 1);
                            Object[] objArr14 = new Object[1];
                            b(b2, b2, bArr4[18], objArr14);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(iIndexOf, maxKeyCode, defaultSize, 721586079, false, (String) objArr14[0], null);
                        }
                        ((Field) objAccessartificialFrame3).set(null, lValueOf);
                    } catch (Exception unused) {
                        throw new RuntimeException();
                    }
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
        } else {
            Object[] objArr15 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 20, new int[]{-517413556, -1248007819, 952129232, -1812122499, 167904363, -1248444044, 1370902927, 476569326}, objArr15);
            Class<?> cls4 = Class.forName((String) objArr15[0]);
            Object[] objArr16 = new Object[1];
            a(16 - (ViewConfiguration.getWindowTouchSlop() >> 8), new int[]{-1519391270, -2054469892, -258456670, -822058583, -626898694, 1527937918, -687209262, -1307792301}, objArr16);
            Object[] objArr17 = {Integer.valueOf(((Integer) cls4.getMethod((String) objArr16[0], Object.class).invoke(null, this)).intValue()), 0, 1649738283};
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame == null) {
                int iNormalizeMetaState2 = 25 - KeyEvent.normalizeMetaState(0);
                char doubleTapTimeout2 = (char) ((ViewConfiguration.getDoubleTapTimeout() >> 16) + 30068);
                int longPressTimeout2 = (ViewConfiguration.getLongPressTimeout() >> 16) + 816;
                Object[] objArr18 = new Object[1];
                b((byte) 105, (byte) 28, $$a[9], objArr18);
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(iNormalizeMetaState2, doubleTapTimeout2, longPressTimeout2, -797394565, false, (String) objArr18[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr = (Object[]) ((Method) objAccessartificialFrame).invoke(null, objArr17);
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame2 == null) {
                int i15 = (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 25;
                char cAxisFromString2 = (char) (MotionEvent.axisFromString("") + 30069);
                int offsetAfter2 = TextUtils.getOffsetAfter("", 0) + 816;
                byte[] bArr5 = $$a;
                Object[] objArr19 = new Object[1];
                b(bArr5[57], (byte) (bArr5[5] - 1), bArr5[18], objArr19);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(i15, cAxisFromString2, offsetAfter2, 891606461, false, (String) objArr19[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, objArr);
            Object[] objArr110 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 18, new int[]{721578335, -1565849910, -2013940550, -695591454, 776370029, -1075895906, 77418597, 185607679, -548190626, 1264014842, -1929241007, 392198446}, objArr110);
            Class<?> cls5 = Class.forName((String) objArr110[0]);
            Object[] objArr111 = new Object[1];
            a((ViewConfiguration.getTapTimeout() >> 16) + 15, new int[]{-1501823017, 1270962718, -171413344, -969408767, 1037446900, -779947746, -2099513253, -908342076}, objArr111);
            Long lValueOf2 = Long.valueOf(((Long) cls5.getDeclaredMethod((String) objArr111[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame3 == null) {
                int iIndexOf2 = TextUtils.indexOf((CharSequence) "", '0') + 26;
                char maxKeyCode2 = (char) ((KeyEvent.getMaxKeyCode() >> 16) + 30068);
                int defaultSize2 = 816 - View.getDefaultSize(0, 0);
                byte[] bArr6 = $$a;
                byte b3 = (byte) (bArr6[5] - 1);
                Object[] objArr112 = new Object[1];
                b(b3, b3, bArr6[18], objArr112);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(iIndexOf2, maxKeyCode2, defaultSize2, 721586079, false, (String) objArr112[0], null);
            }
            ((Field) objAccessartificialFrame3).set(null, lValueOf2);
        }
        int i16 = ((int[]) objArr[1])[0];
        int i17 = ((int[]) objArr[0])[0];
        if (i17 == i16) {
            Object[] objArr20 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i18 = ((int[]) objArr[3])[0];
            int i19 = ((int[]) objArr[0])[0];
            int i20 = ((int[]) objArr[1])[0];
            String[] strArr2 = (String[]) objArr[2];
            int i21 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().mnc;
            int i22 = ~i21;
            int i23 = i18 + (((~(787887599 | i22)) | (~((-5251393) | i21))) * 988) + 1229422597 + (((~(i21 | 584463841)) | 203423758 | (~(i22 | (-5251393)))) * 988);
            int i24 = (i23 << 13) ^ i23;
            int i25 = i24 ^ (i24 >>> 17);
            ((int[]) objArr20[3])[0] = i25 ^ (i25 << 5);
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr3 = (String[]) objArr[2];
            if (strArr3 != null) {
                for (String str : strArr3) {
                    arrayList.add(str);
                }
            }
            long j3 = ((long) (i16 ^ i17)) ^ (((long) 1182907806) << 32);
            long j4 = 1182907807;
            int i26 = artificialFrame + 7;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i26 % 128;
            int i27 = i26 % 2;
            try {
                Object[] objArr21 = {Long.valueOf(j3), Long.valueOf(j4)};
                byte[] bArr7 = $$d;
                byte b4 = (byte) (-bArr7[219]);
                Object[] objArr22 = new Object[1];
                c(b4, b4, bArr7[0], objArr22);
                Class<?> cls6 = Class.forName((String) objArr22[0]);
                byte b5 = bArr7[5];
                Object[] objArr23 = new Object[1];
                c(b5, (short) (b5 | 468), bArr7[210], objArr23);
                cls6.getMethod((String) objArr23[0], Long.TYPE, Long.TYPE).invoke(null, objArr21);
                Object[] objArr24 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i28 = ((int[]) objArr[3])[0];
                int i29 = ((int[]) objArr[0])[0];
                int i30 = ((int[]) objArr[1])[0];
                String[] strArr4 = (String[]) objArr[2];
                int i31 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().navigation;
                int i32 = i28 + 1264953413 + (((~(587530590 | i31)) | 215015456) * 336) + (((~(i31 | 785702956)) | android.R.attr.cursorVisible) * (-168)) + (((~((~i31) | 785702956)) | 587530590) * 168);
                int i33 = (i32 << 13) ^ i32;
                int i34 = i33 ^ (i33 >>> 17);
                ((int[]) objArr24[3])[0] = i34 ^ (i34 << 5);
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        Object objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-444530678);
        if (objAccessartificialFrame9 == null) {
            int i35 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 26;
            char edgeSlop = (char) (ViewConfiguration.getEdgeSlop() >> 16);
            int i36 = 1042 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
            byte[] bArr8 = $$a;
            byte b6 = (byte) (bArr8[5] - 1);
            Object[] objArr25 = new Object[1];
            b(b6, b6, bArr8[18], objArr25);
            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(i35, edgeSlop, i36, 2061780482, false, (String) objArr25[0], null);
        }
        long j5 = ((Field) objAccessartificialFrame9).getLong(null);
        if (j5 != -1) {
            int i37 = getARTIFICIAL_FRAME_PACKAGE_NAME + 31;
            artificialFrame = i37 % 128;
            int i38 = i37 % 2;
            long j6 = j5 + 4611686018427387853L;
            Object[] objArr26 = new Object[1];
            a(MotionEvent.axisFromString("") + 23, new int[]{721578335, -1565849910, -2013940550, -695591454, 776370029, -1075895906, 77418597, 185607679, -548190626, 1264014842, -1929241007, 392198446}, objArr26);
            Class<?> cls7 = Class.forName((String) objArr26[0]);
            Object[] objArr27 = new Object[1];
            a(14 - ((byte) KeyEvent.getModifierMetaStateMask()), new int[]{-1501823017, 1270962718, -171413344, -969408767, 1037446900, -779947746, -2099513253, -908342076}, objArr27);
            if (j6 >= ((Long) cls7.getDeclaredMethod((String) objArr27[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame10 == null) {
                    int i39 = (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 26;
                    char c3 = (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) - 1);
                    int iRgb = Color.rgb(0, 0, 0) + 16778257;
                    byte[] bArr9 = $$a;
                    Object[] objArr28 = new Object[1];
                    b(bArr9[57], (byte) (bArr9[5] - 1), bArr9[18], objArr28);
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(i39, c3, iRgb, 1145017376, false, (String) objArr28[0], null);
                }
                Object[] objArr29 = (Object[]) ((Field) objAccessartificialFrame10).get(null);
                objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                int i40 = ((int[]) objArr29[3])[0];
                int i41 = ((int[]) objArr29[2])[0];
                String[] strArr5 = (String[]) objArr29[0];
                int iElapsedRealtime = (int) SystemClock.elapsedRealtime();
                int i42 = ~iElapsedRealtime;
                int i43 = 1187586950 + (((~((-588356676) | i42)) | 510252868) * (-865)) + ((~(iElapsedRealtime | 588356675)) * 865) + (((~(510252868 | i42)) | (~(i42 | 588356675))) * 865) + 1186743857;
                int i44 = (i43 << 13) ^ i43;
                int i45 = i44 ^ (i44 >>> 17);
                ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i45 ^ (i45 << 5);
                c = 2;
            } else {
                Object[] objArr30 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(3) - 99, new int[]{-517413556, -1248007819, 952129232, -1812122499, 167904363, -1248444044, 1370902927, 476569326}, objArr30);
                Class<?> cls8 = Class.forName((String) objArr30[0]);
                Object[] objArr31 = new Object[1];
                a(16 - KeyEvent.normalizeMetaState(0), new int[]{-1519391270, -2054469892, -258456670, -822058583, -626898694, 1527937918, -687209262, -1307792301}, objArr31);
                int iIntValue = ((Integer) cls8.getMethod((String) objArr31[0], Object.class).invoke(null, this)).intValue();
                Object[] objArr32 = {366082734};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                if (objAccessartificialFrame4 == null) {
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(8 - TextUtils.getOffsetAfter("", 0), (char) (AndroidCharacter.getMirror('0') + 22203), (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 1033, 47343338, false, null, new Class[]{Integer.TYPE});
                }
                objArrAccessartificialFrame$78cbbd35 = KeylineState.Keyline.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame4).newInstance(objArr32), 1186743857, false);
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame5 == null) {
                    int bitsPerPixel = 25 - ImageFormat.getBitsPerPixel(0);
                    char cAlpha = (char) Color.alpha(0);
                    int iResolveSizeAndState = View.resolveSizeAndState(0, 0, 0) + 1041;
                    byte[] bArr10 = $$a;
                    Object[] objArr33 = new Object[1];
                    b(bArr10[57], (byte) (bArr10[5] - 1), bArr10[18], objArr33);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(bitsPerPixel, cAlpha, iResolveSizeAndState, 1145017376, false, (String) objArr33[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, objArrAccessartificialFrame$78cbbd35);
                try {
                    Object[] objArr34 = new Object[1];
                    a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 18, new int[]{721578335, -1565849910, -2013940550, -695591454, 776370029, -1075895906, 77418597, 185607679, -548190626, 1264014842, -1929241007, 392198446}, objArr34);
                    Class<?> cls9 = Class.forName((String) objArr34[0]);
                    Object[] objArr35 = new Object[1];
                    a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 20, new int[]{-1501823017, 1270962718, -171413344, -969408767, 1037446900, -779947746, -2099513253, -908342076}, objArr35);
                    Long lValueOf3 = Long.valueOf(((Long) cls9.getDeclaredMethod((String) objArr35[0], new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-444530678);
                    if (objAccessartificialFrame6 == null) {
                        int i46 = 27 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                        char c4 = (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                        int offsetBefore = TextUtils.getOffsetBefore("", 0) + 1041;
                        byte[] bArr11 = $$a;
                        byte b7 = (byte) (bArr11[5] - 1);
                        Object[] objArr36 = new Object[1];
                        b(b7, b7, bArr11[18], objArr36);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(i46, c4, offsetBefore, 2061780482, false, (String) objArr36[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, lValueOf3);
                    int i47 = getARTIFICIAL_FRAME_PACKAGE_NAME + 19;
                    artificialFrame = i47 % 128;
                    c = 2;
                    int i48 = i47 % 2;
                } catch (Exception unused2) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object[] objArr37 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(3) - 99, new int[]{-517413556, -1248007819, 952129232, -1812122499, 167904363, -1248444044, 1370902927, 476569326}, objArr37);
            Class<?> cls10 = Class.forName((String) objArr37[0]);
            Object[] objArr38 = new Object[1];
            a(16 - KeyEvent.normalizeMetaState(0), new int[]{-1519391270, -2054469892, -258456670, -822058583, -626898694, 1527937918, -687209262, -1307792301}, objArr38);
            int iIntValue2 = ((Integer) cls10.getMethod((String) objArr38[0], Object.class).invoke(null, this)).intValue();
            Object[] objArr39 = {366082734};
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame4 == null) {
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(8 - TextUtils.getOffsetAfter("", 0), (char) (AndroidCharacter.getMirror('0') + 22203), (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 1033, 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = KeylineState.Keyline.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame4).newInstance(objArr39), 1186743857, false);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame5 == null) {
                int bitsPerPixel2 = 25 - ImageFormat.getBitsPerPixel(0);
                char cAlpha2 = (char) Color.alpha(0);
                int iResolveSizeAndState2 = View.resolveSizeAndState(0, 0, 0) + 1041;
                byte[] bArr12 = $$a;
                Object[] objArr310 = new Object[1];
                b(bArr12[57], (byte) (bArr12[5] - 1), bArr12[18], objArr310);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(bitsPerPixel2, cAlpha2, iResolveSizeAndState2, 1145017376, false, (String) objArr310[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArrAccessartificialFrame$78cbbd35);
            Object[] objArr311 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 18, new int[]{721578335, -1565849910, -2013940550, -695591454, 776370029, -1075895906, 77418597, 185607679, -548190626, 1264014842, -1929241007, 392198446}, objArr311);
            Class<?> cls11 = Class.forName((String) objArr311[0]);
            Object[] objArr312 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 20, new int[]{-1501823017, 1270962718, -171413344, -969408767, 1037446900, -779947746, -2099513253, -908342076}, objArr312);
            Long lValueOf4 = Long.valueOf(((Long) cls11.getDeclaredMethod((String) objArr312[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame6 == null) {
                int i49 = 27 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                char c5 = (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                int offsetBefore2 = TextUtils.getOffsetBefore("", 0) + 1041;
                byte[] bArr13 = $$a;
                byte b8 = (byte) (bArr13[5] - 1);
                Object[] objArr313 = new Object[1];
                b(b8, b8, bArr13[18], objArr313);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(i49, c5, offsetBefore2, 2061780482, false, (String) objArr313[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf4);
            int i410 = getARTIFICIAL_FRAME_PACKAGE_NAME + 19;
            artificialFrame = i410 % 128;
            c = 2;
            int i411 = i410 % 2;
        }
        int i50 = ((int[]) objArrAccessartificialFrame$78cbbd35[c])[0];
        int i51 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i51 == i50) {
            int i52 = artificialFrame + 69;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i52 % 128;
            int i53 = i52 % 2;
            Object[] objArr40 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i54 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i55 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i56 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr6 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int i57 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().screenHeightDp;
            int i58 = i54 + 1590175574 + (((~((~i57) | (-941883993))) | (~((-9978883) | i57))) * (-302)) + ((~((-941883993) | i57)) * (-604)) + (((~(i57 | (-951862875))) | (-1039945564)) * 302);
            int i59 = (i58 << 13) ^ i58;
            int i60 = i59 ^ (i59 >>> 17);
            ((int[]) objArr40[1])[0] = i60 ^ (i60 << 5);
            int i61 = artificialFrame + 73;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i61 % 128;
            if (i61 % 2 != 0) {
                int i62 = 4 / 3;
            }
        } else {
            ArrayList arrayList2 = new ArrayList();
            String[] strArr7 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            if (strArr7 != null) {
                for (String str2 : strArr7) {
                    arrayList2.add(str2);
                }
            }
            long j7 = ((long) (i50 ^ i51)) ^ (((long) (-535717396)) << 32);
            long j8 = -535717394;
            int i63 = artificialFrame + 81;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i63 % 128;
            int i64 = i63 % 2;
            Object[] objArr41 = {Long.valueOf(j7), Long.valueOf(j8)};
            byte[] bArr14 = $$d;
            byte b9 = (byte) (bArr14[243] + 1);
            short s = bArr14[89];
            Object[] objArr42 = new Object[1];
            c(b9, s, (byte) s, objArr42);
            Class<?> cls12 = Class.forName((String) objArr42[0]);
            byte b10 = bArr14[5];
            Object[] objArr43 = new Object[1];
            c(b10, (short) (b10 | 468), bArr14[210], objArr43);
            cls12.getMethod((String) objArr43[0], Long.TYPE, Long.TYPE).invoke(null, objArr41);
            Object[] objArr44 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i65 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i66 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i67 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr8 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int iMaxMemory = (int) Runtime.getRuntime().maxMemory();
            int i68 = ~iMaxMemory;
            int i69 = i65 + 270803390 + (((~((-210329433) | i68)) | 288433239) * (-328)) + ((iMaxMemory | 288433239) * 164) + (((~(iMaxMemory | 210329432)) | 288366599 | (~(i68 | (-210262793)))) * 164);
            int i70 = (i69 << 13) ^ i69;
            int i71 = i70 ^ (i70 >>> 17);
            ((int[]) objArr44[1])[0] = i71 ^ (i71 << 5);
        }
        int i72 = artificialFrame + 117;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i72 % 128;
        int i73 = i72 % 2;
    }

    static void accessartificialFrame() {
        ICustomTabsCallbackStub = new int[]{1155309305, 31356797, -945490746, -1533398344, 845369320, -396433046, 42651712, 192320239, -661395279, 1061611786, -1308231562, -784593123, 1607289719, -752907899, 1665348372, 1640433012, -1354666326, 1176320394};
    }
}
