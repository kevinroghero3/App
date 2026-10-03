package com.hitachiapp;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.imageutils.JfifUtil;
import com.facebook.react.ReactActivity;
import com.facebook.react.ReactActivityDelegate;
import com.facebook.react.defaults.DefaultNewArchitectureEntryPoint;
import com.facebook.react.defaults.DefaultReactActivityDelegate;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.hitachiapp.utils.PinningManager;
import com.zoontek.rnbootsplash.RNBootSplash;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import o.ArtificialStackFrames;
import o.onNavigationEvent;
import org.apache.commons.lang3.CharUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class MainActivity extends ReactActivity {
    private final String TAG = "[MainActivity]";
    private static final byte[] $$l = {38, -81, -30, 49};
    private static final int $$m = 116;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$j = {109, -105, -81, -102, Ascii.DC2, 4, -57, 62, 1, 8, 8, 3, 19, 6, 2, -55, 65, 10, -6, Ascii.FF, 4, 17, -1, Ascii.CR, -5, Ascii.CR, 3, Ascii.VT, -3, -49, 59, Ascii.DC2, 9, -7, -49, 40, 40, 3, -5, Ascii.ETB, -12, 8, 19, -25, Ascii.CAN, Ascii.DC2, 10, -10, Ascii.SI, -5, 8, -25, 33, 8, Ascii.ETB, 1, 9, Ascii.CR, -79, 37, 50, 4, 9, -9, 19, 1, Ascii.FF, 5, 6, 67, 2, 3, Ascii.DC2, 6, 2, -55, 1, 65, Ascii.VT, Ascii.FF, -9, 19, 2, -7, 17, -56, 79, 2, -63, 42, Ascii.EM, 2, 17, -15, Ascii.DC4, 3, -9, 34, -6, Ascii.SO, 0, Ascii.NAK, -74, 57, 33, -3, 17, -9, 19, -24, 19, Ascii.CAN, -2};
    private static final int $$k = 213;
    private static final byte[] $$d = {104, 119, -28, 53, 5, -1, -33, 33, -2, -9, 5, -7, 5, -1, -50, 39, Ascii.VT, -7, -12, Ascii.SI, Ascii.ESC, 1, -7, -6, -33, 51, -12, 3, -8, 1, Ascii.CR};
    private static final int $$e = 119;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static int setDefaultImpl = -260894125;

    private static String $$n(int i, byte b, byte b2) {
        int i2 = 116 - (i * 2);
        int i3 = b * 4;
        int i4 = (b2 * 3) + 4;
        byte[] bArr = $$l;
        byte[] bArr2 = new byte[1 - i3];
        int i5 = 0 - i3;
        int i6 = -1;
        if (bArr == null) {
            i2 = (-i2) + i5;
            i4++;
            i6 = -1;
        }
        while (true) {
            int i7 = i6 + 1;
            bArr2[i7] = (byte) i2;
            if (i7 == i5) {
                return new String(bArr2, 0);
            }
            i2 = (-bArr[i4]) + i2;
            i4++;
            i6 = i7;
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0023  */
    /* JADX WARN: Code duplicated, block: B:8:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x0025). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void d(short r6, int r7, byte r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = com.hitachiapp.MainActivity.$$j
            int r7 = 65 - r7
            int r6 = r6 + 4
            int r8 = 111 - r8
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L11
            r3 = r8
            r5 = r2
            r8 = r7
            goto L25
        L11:
            r3 = r2
        L12:
            int r6 = r6 + 1
            byte r4 = (byte) r8
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r7) goto L23
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L23:
            r3 = r0[r6]
        L25:
            int r8 = r8 + r3
            int r8 = r8 + (-6)
            r3 = r5
            goto L12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hitachiapp.MainActivity.d(short, int, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    /* JADX WARN: Code duplicated, block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002e). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void e(int r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = com.hitachiapp.MainActivity.$$d
            int r6 = r6 * 3
            int r1 = r6 + 9
            int r8 = r8 * 28
            int r8 = r8 + 84
            int r7 = r7 + 4
            byte[] r1 = new byte[r1]
            int r6 = r6 + 8
            r2 = 0
            if (r0 != 0) goto L17
            r4 = r8
            r3 = r2
            r8 = r7
            goto L2e
        L17:
            r3 = r2
        L18:
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r6) goto L25
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L25:
            int r7 = r7 + 1
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r8
            r8 = r7
            r7 = r5
        L2e:
            int r7 = r7 + r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hitachiapp.MainActivity.e(int, short, short, java.lang.Object[]):void");
    }

    @Override // com.facebook.react.ReactActivity
    public String getMainComponentName() {
        return "hitachiapp";
    }

    @Override // com.facebook.react.ReactActivity
    public ReactActivityDelegate createReactActivityDelegate() {
        return new DefaultReactActivityDelegate(this, getMainComponentName(), DefaultNewArchitectureEntryPoint.getFabricEnabled());
    }

    @Override // com.facebook.react.ReactActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Log.i(this.TAG, "onNewIntent");
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override // com.facebook.react.ReactActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Log.i(this.TAG, "onCreate");
        RNBootSplash.init(this, R.style.BootTheme);
        super.onCreate(null);
        PinningManager.init(this);
        Application application = getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.hitachiapp.MainApplication");
        ((MainApplication) application).addActivityToStack(MainActivity.class);
    }

    @Override // com.facebook.react.ReactActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Log.i(this.TAG, "onCreate");
        super.onDestroy();
        Application application = getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.hitachiapp.MainApplication");
        ((MainApplication) application).removeActivityFromStack(MainActivity.class);
    }

    @Override // com.facebook.react.ReactActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onResume() throws Throwable {
        int i = 2 % 2;
        int i2 = artificialFrame + 41;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i2 % 128;
        Object obj = null;
        try {
            if (i2 % 2 != 0) {
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(949068051);
                if (objAccessartificialFrame == null) {
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(30 - Color.blue(0), (char) (49993 - TextUtils.getOffsetBefore("", 0)), 74 - (ViewConfiguration.getLongPressTimeout() >> 16), -1477122277, false, "MediaDescriptionCompatApi23Builder", null);
                }
                Object obj2 = ((Field) objAccessartificialFrame).get(null);
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1579113874);
                if (objAccessartificialFrame2 == null) {
                    int iIndexOf = 29 - TextUtils.indexOf((CharSequence) "", '0', 0);
                    char absoluteGravity = (char) (49993 - Gravity.getAbsoluteGravity(0, 0));
                    int i3 = 75 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                    byte[] bArr = $$j;
                    byte b = bArr[22];
                    Object[] objArr = new Object[1];
                    d(b, (byte) (b & SignedBytes.MAX_POWER_OF_TWO), bArr[23], objArr);
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iIndexOf, absoluteGravity, i3, -1048962150, false, (String) objArr[0], new Class[0]);
                }
                ((Method) objAccessartificialFrame2).invoke(obj2, null);
                super.onResume();
                obj.hashCode();
                throw null;
            }
            Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(949068051);
            if (objAccessartificialFrame3 == null) {
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(30 - Color.red(0), (char) ((ViewConfiguration.getFadingEdgeLength() >> 16) + 49993), 74 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), -1477122277, false, "MediaDescriptionCompatApi23Builder", null);
            }
            Object obj3 = ((Field) objAccessartificialFrame3).get(null);
            Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1579113874);
            if (objAccessartificialFrame4 == null) {
                int scrollBarSize = (ViewConfiguration.getScrollBarSize() >> 8) + 30;
                char c = (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 49992);
                int i4 = 75 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                byte[] bArr2 = $$j;
                byte b2 = bArr2[22];
                Object[] objArr2 = new Object[1];
                d(b2, (byte) (b2 & SignedBytes.MAX_POWER_OF_TWO), bArr2[23], objArr2);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(scrollBarSize, c, i4, -1048962150, false, (String) objArr2[0], new Class[0]);
            }
            ((Method) objAccessartificialFrame4).invoke(obj3, null);
            super.onResume();
            int i5 = getARTIFICIAL_FRAME_PACKAGE_NAME + 17;
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

    @Override // com.facebook.react.ReactActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onPause() throws Throwable {
        int i = 2 % 2;
        int i2 = getARTIFICIAL_FRAME_PACKAGE_NAME + 77;
        artificialFrame = i2 % 128;
        try {
            if (i2 % 2 == 0) {
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(949068051);
                if (objAccessartificialFrame == null) {
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(Color.argb(0, 0, 0, 0) + 30, (char) (49993 - KeyEvent.getDeadChar(0, 0)), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 73, -1477122277, false, "MediaDescriptionCompatApi23Builder", null);
                }
                Object obj = ((Field) objAccessartificialFrame).get(null);
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1579114835);
                if (objAccessartificialFrame2 == null) {
                    int i3 = 31 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                    char c = (char) (49992 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)));
                    int keyRepeatDelay = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 74;
                    byte[] bArr = $$j;
                    byte b = bArr[22];
                    Object[] objArr = new Object[1];
                    d(b, (byte) (b & SignedBytes.MAX_POWER_OF_TWO), bArr[19], objArr);
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(i3, c, keyRepeatDelay, -1048959141, false, (String) objArr[0], new Class[0]);
                }
                ((Method) objAccessartificialFrame2).invoke(obj, null);
                super.onPause();
                throw null;
            }
            Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(949068051);
            if (objAccessartificialFrame3 == null) {
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(29 - TextUtils.indexOf((CharSequence) "", '0', 0), (char) (Color.blue(0) + 49993), (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 73, -1477122277, false, "MediaDescriptionCompatApi23Builder", null);
            }
            Object obj2 = ((Field) objAccessartificialFrame3).get(null);
            Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1579114835);
            if (objAccessartificialFrame4 == null) {
                int packedPositionChild = ExpandableListView.getPackedPositionChild(0L) + 31;
                char packedPositionType = (char) (ExpandableListView.getPackedPositionType(0L) + 49993);
                int minimumFlingVelocity = 74 - (ViewConfiguration.getMinimumFlingVelocity() >> 16);
                byte[] bArr2 = $$j;
                byte b2 = bArr2[22];
                Object[] objArr2 = new Object[1];
                d(b2, (byte) (b2 & SignedBytes.MAX_POWER_OF_TWO), bArr2[19], objArr2);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(packedPositionChild, packedPositionType, minimumFlingVelocity, -1048959141, false, (String) objArr2[0], new Class[0]);
            }
            ((Method) objAccessartificialFrame4).invoke(obj2, null);
            super.onPause();
            int i4 = artificialFrame + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i4 % 128;
            int i5 = i4 % 2;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    private static void f(char[] cArr, int i, int i2, int i3, boolean z, Object[] objArr) throws Throwable {
        Object obj;
        int i4 = 2 % 2;
        onNavigationEvent onnavigationevent = new onNavigationEvent();
        char[] cArr2 = new char[i];
        onnavigationevent.d = 0;
        while (onnavigationevent.d < i) {
            onnavigationevent.c = cArr[onnavigationevent.d];
            cArr2[onnavigationevent.d] = (char) (i3 + onnavigationevent.c);
            int i5 = onnavigationevent.d;
            try {
                Object[] objArr2 = {Integer.valueOf(cArr2[i5]), Integer.valueOf(setDefaultImpl)};
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(465886069);
                if (objAccessartificialFrame == null) {
                    byte b = (byte) 1;
                    byte b2 = (byte) (b - 1);
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(TextUtils.lastIndexOf("", '0') + 23, (char) Color.blue(0), ((byte) KeyEvent.getModifierMetaStateMask()) + 1776, -2069783171, false, $$n(b, b2, b2), new Class[]{Integer.TYPE, Integer.TYPE});
                }
                cArr2[i5] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                try {
                    Object[] objArr3 = {onnavigationevent, onnavigationevent};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1257606387);
                    if (objAccessartificialFrame2 == null) {
                        byte b3 = (byte) 0;
                        byte b4 = b3;
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 36, (char) (ExpandableListView.getPackedPositionChild(0L) + 56278), 1259 - View.MeasureSpec.getMode(0), 711931141, false, $$n(b3, b4, b4), new Class[]{Object.class, Object.class});
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
        if (i2 > 0) {
            onnavigationevent.b = i2;
            char[] cArr3 = new char[i];
            System.arraycopy(cArr2, 0, cArr3, 0, i);
            System.arraycopy(cArr3, 0, cArr2, i - onnavigationevent.b, onnavigationevent.b);
            System.arraycopy(cArr3, onnavigationevent.b, cArr2, 0, i - onnavigationevent.b);
        }
        if (z) {
            int i6 = $10 + 3;
            $11 = i6 % 128;
            int i7 = i6 % 2;
            char[] cArr4 = new char[i];
            onnavigationevent.d = 0;
            while (onnavigationevent.d < i) {
                int i8 = $10 + 49;
                $11 = i8 % 128;
                if (i8 % 2 == 0) {
                    cArr4[onnavigationevent.d] = cArr2[i / onnavigationevent.d];
                    try {
                        Object[] objArr4 = {onnavigationevent, onnavigationevent};
                        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1257606387);
                        if (objAccessartificialFrame3 == null) {
                            byte b5 = (byte) 0;
                            byte b6 = b5;
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(TextUtils.getOffsetBefore("", 0) + 37, (char) ((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 56277), 1259 - View.resolveSizeAndState(0, 0, 0), 711931141, false, $$n(b5, b6, b6), new Class[]{Object.class, Object.class});
                        }
                        ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                        obj = null;
                    } catch (Throwable th3) {
                        Throwable cause3 = th3.getCause();
                        if (cause3 == null) {
                            throw th3;
                        }
                        throw cause3;
                    }
                } else {
                    cArr4[onnavigationevent.d] = cArr2[(i - onnavigationevent.d) - 1];
                    Object[] objArr5 = {onnavigationevent, onnavigationevent};
                    Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1257606387);
                    if (objAccessartificialFrame4 == null) {
                        byte b7 = (byte) 0;
                        byte b8 = b7;
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(37 - TextUtils.getTrimmedLength(""), (char) (56277 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1))), 1259 - View.getDefaultSize(0, 0), 711931141, false, $$n(b7, b8, b8), new Class[]{Object.class, Object.class});
                    }
                    obj = null;
                    ((Method) objAccessartificialFrame4).invoke(null, objArr5);
                }
            }
            cArr2 = cArr4;
        }
        objArr[0] = new String(cArr2);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x021c  */
    /* JADX WARN: Code duplicated, block: B:16:0x0329 A[Catch: all -> 0x0cf8, TryCatch #0 {all -> 0x0cf8, blocks: (B:51:0x097e, B:53:0x0992, B:54:0x09c3, B:14:0x0309, B:16:0x0329, B:17:0x0374), top: B:91:0x0309 }] */
    /* JADX WARN: Code duplicated, block: B:20:0x0386  */
    /* JADX WARN: Code duplicated, block: B:25:0x04ea  */
    /* JADX WARN: Code duplicated, block: B:50:0x08b4  */
    /* JADX WARN: Code duplicated, block: B:53:0x0992 A[Catch: all -> 0x0cf8, TryCatch #0 {all -> 0x0cf8, blocks: (B:51:0x097e, B:53:0x0992, B:54:0x09c3, B:14:0x0309, B:16:0x0329, B:17:0x0374), top: B:91:0x0309 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x09d9  */
    /* JADX WARN: Code duplicated, block: B:62:0x0b2d  */
    @Override // com.facebook.react.ReactActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) throws Throwable {
        Object objAccessartificialFrame;
        Object[] objArr;
        Object objAccessartificialFrame2;
        Object objAccessartificialFrame3;
        Object objAccessartificialFrame4;
        Object[] objArrAccessartificialFrame$78cbbd35;
        Object objAccessartificialFrame5;
        Object objAccessartificialFrame6;
        int i = 2 % 2;
        int i2 = artificialFrame + 115;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i2 % 128;
        int i3 = i2 % 2;
        super.attachBaseContext(context);
        Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame7 == null) {
            int i4 = 26 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
            char cCombineMeasuredStates = (char) (30068 - View.combineMeasuredStates(0, 0));
            int i5 = (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 815;
            byte[] bArr = $$d;
            byte b = bArr[21];
            Object[] objArr2 = new Object[1];
            e((byte) (b - 1), bArr[5], b, objArr2);
            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(i4, cCombineMeasuredStates, i5, 721586079, false, (String) objArr2[0], null);
        }
        long j = ((Field) objAccessartificialFrame7).getLong(null);
        if (j != -1) {
            long j2 = j + 1859;
            Object[] objArr3 = new Object[1];
            f(new char[]{15, '\f', 6, 1, 65483, '\f', 16, 65483, 65520, 22, 16, 17, 2, '\n', 65504, '\t', '\f', 0, '\b', 65534, 11, 1}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 18, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 16, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(9) + 151, false, objArr3);
            Class<?> cls = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            f(new char[]{5, 65530, 65534, 65515, 65533, 65534, '\f', '\t', 65530, 5, 65534, 65534, 6, 2, CharUtils.CR}, View.MeasureSpec.makeMeasureSpec(0, 0) + 15, (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 11, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 234, true, objArr4);
            if (j2 >= ((Long) cls.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame8 == null) {
                    int i6 = (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 24;
                    char cMakeMeasureSpec = (char) (View.MeasureSpec.makeMeasureSpec(0, 0) + 30068);
                    int longPressTimeout = 816 - (ViewConfiguration.getLongPressTimeout() >> 16);
                    byte[] bArr2 = $$d;
                    byte b2 = bArr2[21];
                    Object[] objArr5 = new Object[1];
                    e((byte) (b2 - 1), (byte) (-bArr2[11]), b2, objArr5);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(i6, cMakeMeasureSpec, longPressTimeout, 891606461, false, (String) objArr5[0], null);
                }
                Object[] objArr6 = (Object[]) ((Field) objAccessartificialFrame8).get(null);
                objArr = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i7 = ((int[]) objArr6[0])[0];
                int i8 = ((int[]) objArr6[1])[0];
                String[] strArr = (String[]) objArr6[2];
                int i9 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getDisplayMetrics().heightPixels;
                int i10 = ~i9;
                int i11 = (((425930034 + (((~((-774195267) | i10)) | (-576022901)) * 519)) + (((~(i10 | (-570771521))) | (~((-5251381) | i9))) * (-519))) + (((~(i9 | (-576022901))) | 774195266) * 519)) - 184934935;
                int i12 = (i11 << 13) ^ i11;
                int i13 = i12 ^ (i12 >>> 17);
                ((int[]) objArr[3])[0] = i13 ^ (i13 << 5);
            } else {
                Object[] objArr7 = new Object[1];
                f(new char[]{65484, '\n', 65535, '\f', 5, 65484, 65521, 23, 17, 18, 3, 11, '\b', 65535, 20, 65535}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 19, (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 11, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(3) + JfifUtil.MARKER_SOS, false, objArr7);
                Class<?> cls2 = Class.forName((String) objArr7[0]);
                Object[] objArr8 = new Object[1];
                f(new char[]{65534, 65535, 3, 65534, 65535, '\b', 14, 3, 14, 19, 65506, 65531, CharUtils.CR, 2, 65501, '\t'}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 19, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 2, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 233, false, objArr8);
                try {
                    Object[] objArr9 = {Integer.valueOf(((Integer) cls2.getMethod((String) objArr8[0], Object.class).invoke(null, this)).intValue()), 0, -184934935};
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1327366003);
                    if (objAccessartificialFrame == null) {
                        int doubleTapTimeout = (ViewConfiguration.getDoubleTapTimeout() >> 16) + 25;
                        char defaultSize = (char) (30068 - View.getDefaultSize(0, 0));
                        int i14 = 817 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                        byte[] bArr3 = $$d;
                        byte b3 = bArr3[21];
                        Object[] objArr10 = new Object[1];
                        e(b3, bArr3[19], (byte) (b3 - 1), objArr10);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(doubleTapTimeout, defaultSize, i14, -797394565, false, (String) objArr10[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    objArr = (Object[]) ((Method) objAccessartificialFrame).invoke(null, objArr9);
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                    if (objAccessartificialFrame2 == null) {
                        int iResolveOpacity = Drawable.resolveOpacity(0, 0) + 25;
                        char c = (char) (30069 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)));
                        int doubleTapTimeout2 = (ViewConfiguration.getDoubleTapTimeout() >> 16) + 816;
                        byte[] bArr4 = $$d;
                        byte b4 = bArr4[21];
                        Object[] objArr11 = new Object[1];
                        e((byte) (b4 - 1), (byte) (-bArr4[11]), b4, objArr11);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iResolveOpacity, c, doubleTapTimeout2, 891606461, false, (String) objArr11[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, objArr);
                    try {
                        Object[] objArr12 = new Object[1];
                        f(new char[]{15, '\f', 6, 1, 65483, '\f', 16, 65483, 65520, 22, 16, 17, 2, '\n', 65504, '\t', '\f', 0, '\b', 65534, 11, 1}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(0) - 15, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(6) - 98, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 230, false, objArr12);
                        Class<?> cls3 = Class.forName((String) objArr12[0]);
                        Object[] objArr13 = new Object[1];
                        f(new char[]{5, 65530, 65534, 65515, 65533, 65534, '\f', '\t', 65530, 5, 65534, 65534, 6, 2, CharUtils.CR}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(0) - 22, Color.argb(0, 0, 0, 0) + 11, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 265, true, objArr13);
                        Long lValueOf = Long.valueOf(((Long) cls3.getDeclaredMethod((String) objArr13[0], new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                        if (objAccessartificialFrame3 == null) {
                            int deadChar = KeyEvent.getDeadChar(0, 0) + 25;
                            char cIndexOf = (char) (30068 - TextUtils.indexOf("", "", 0));
                            int windowTouchSlop = (ViewConfiguration.getWindowTouchSlop() >> 8) + 816;
                            byte[] bArr5 = $$d;
                            byte b5 = bArr5[21];
                            Object[] objArr14 = new Object[1];
                            e((byte) (b5 - 1), bArr5[5], b5, objArr14);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(deadChar, cIndexOf, windowTouchSlop, 721586079, false, (String) objArr14[0], null);
                        }
                        ((Field) objAccessartificialFrame3).set(null, lValueOf);
                        int i15 = artificialFrame + 11;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i15 % 128;
                        int i16 = i15 % 2;
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
            f(new char[]{65484, '\n', 65535, '\f', 5, 65484, 65521, 23, 17, 18, 3, 11, '\b', 65535, 20, 65535}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 19, (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 11, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(3) + JfifUtil.MARKER_SOS, false, objArr15);
            Class<?> cls4 = Class.forName((String) objArr15[0]);
            Object[] objArr16 = new Object[1];
            f(new char[]{65534, 65535, 3, 65534, 65535, '\b', 14, 3, 14, 19, 65506, 65531, CharUtils.CR, 2, 65501, '\t'}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 19, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 2, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 233, false, objArr16);
            Object[] objArr17 = {Integer.valueOf(((Integer) cls4.getMethod((String) objArr16[0], Object.class).invoke(null, this)).intValue()), 0, -184934935};
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame == null) {
                int doubleTapTimeout3 = (ViewConfiguration.getDoubleTapTimeout() >> 16) + 25;
                char defaultSize2 = (char) (30068 - View.getDefaultSize(0, 0));
                int i17 = 817 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                byte[] bArr6 = $$d;
                byte b6 = bArr6[21];
                Object[] objArr18 = new Object[1];
                e(b6, bArr6[19], (byte) (b6 - 1), objArr18);
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(doubleTapTimeout3, defaultSize2, i17, -797394565, false, (String) objArr18[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr = (Object[]) ((Method) objAccessartificialFrame).invoke(null, objArr17);
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame2 == null) {
                int iResolveOpacity2 = Drawable.resolveOpacity(0, 0) + 25;
                char c2 = (char) (30069 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)));
                int doubleTapTimeout4 = (ViewConfiguration.getDoubleTapTimeout() >> 16) + 816;
                byte[] bArr7 = $$d;
                byte b7 = bArr7[21];
                Object[] objArr19 = new Object[1];
                e((byte) (b7 - 1), (byte) (-bArr7[11]), b7, objArr19);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iResolveOpacity2, c2, doubleTapTimeout4, 891606461, false, (String) objArr19[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, objArr);
            Object[] objArr110 = new Object[1];
            f(new char[]{15, '\f', 6, 1, 65483, '\f', 16, 65483, 65520, 22, 16, 17, 2, '\n', 65504, '\t', '\f', 0, '\b', 65534, 11, 1}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(0) - 15, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(6) - 98, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 230, false, objArr110);
            Class<?> cls5 = Class.forName((String) objArr110[0]);
            Object[] objArr111 = new Object[1];
            f(new char[]{5, 65530, 65534, 65515, 65533, 65534, '\f', '\t', 65530, 5, 65534, 65534, 6, 2, CharUtils.CR}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(0) - 22, Color.argb(0, 0, 0, 0) + 11, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 265, true, objArr111);
            Long lValueOf2 = Long.valueOf(((Long) cls5.getDeclaredMethod((String) objArr111[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame3 == null) {
                int deadChar2 = KeyEvent.getDeadChar(0, 0) + 25;
                char cIndexOf2 = (char) (30068 - TextUtils.indexOf("", "", 0));
                int windowTouchSlop2 = (ViewConfiguration.getWindowTouchSlop() >> 8) + 816;
                byte[] bArr8 = $$d;
                byte b8 = bArr8[21];
                Object[] objArr112 = new Object[1];
                e((byte) (b8 - 1), bArr8[5], b8, objArr112);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(deadChar2, cIndexOf2, windowTouchSlop2, 721586079, false, (String) objArr112[0], null);
            }
            ((Field) objAccessartificialFrame3).set(null, lValueOf2);
            int i18 = artificialFrame + 11;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i18 % 128;
            int i19 = i18 % 2;
        }
        int i20 = ((int[]) objArr[1])[0];
        int i21 = ((int[]) objArr[0])[0];
        if (i21 == i20) {
            Object[] objArr20 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i22 = ((int[]) objArr[3])[0];
            int i23 = ((int[]) objArr[0])[0];
            int i24 = ((int[]) objArr[1])[0];
            String[] strArr2 = (String[]) objArr[2];
            int iIdentityHashCode = System.identityHashCode(this);
            int i25 = (-1474359308) + (((~((~iIdentityHashCode) | 9510019)) | (-217186260)) * (-245));
            int i26 = ~(iIdentityHashCode | 9510019);
            int i27 = i22 + i25 + (i26 * (-245)) + ((i26 | 207682385) * 245);
            int i28 = (i27 << 13) ^ i27;
            int i29 = i28 ^ (i28 >>> 17);
            ((int[]) objArr20[3])[0] = i29 ^ (i29 << 5);
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr3 = (String[]) objArr[2];
            if (strArr3 != null) {
                int i30 = artificialFrame + 43;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i30 % 128;
                int i31 = i30 % 2;
                for (String str : strArr3) {
                    arrayList.add(str);
                }
            }
            long j3 = (((long) 760531500) << 32) ^ ((long) (i20 ^ i21));
            long j4 = 760531501;
            int i32 = artificialFrame + 57;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i32 % 128;
            int i33 = i32 % 2;
            try {
                Object[] objArr21 = {Long.valueOf(j3), Long.valueOf(j4)};
                byte[] bArr9 = $$j;
                Object[] objArr22 = new Object[1];
                d(bArr9[22], bArr9[100], bArr9[19], objArr22);
                Class<?> cls6 = Class.forName((String) objArr22[0]);
                Object[] objArr23 = new Object[1];
                d((byte) (-bArr9[88]), bArr9[7], (byte) 75, objArr23);
                cls6.getMethod((String) objArr23[0], Long.TYPE, Long.TYPE).invoke(null, objArr21);
                Object[] objArr24 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i34 = ((int[]) objArr[3])[0];
                int i35 = ((int[]) objArr[0])[0];
                int i36 = ((int[]) objArr[1])[0];
                String[] strArr4 = (String[]) objArr[2];
                int i37 = ~(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().screenHeightDp | (-869715825));
                int i38 = i34 + ((((-1073147775) | i37) * (-196)) - 903350567) + ((i37 | 203431950) * 196);
                int i39 = (i38 << 13) ^ i38;
                int i40 = i39 ^ (i39 >>> 17);
                ((int[]) objArr24[3])[0] = i40 ^ (i40 << 5);
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
            int modifierMetaStateMask = 25 - ((byte) KeyEvent.getModifierMetaStateMask());
            char c3 = (char) ((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)));
            int defaultSize3 = 1041 - View.getDefaultSize(0, 0);
            byte[] bArr10 = $$d;
            byte b9 = bArr10[21];
            Object[] objArr25 = new Object[1];
            e((byte) (b9 - 1), bArr10[5], b9, objArr25);
            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(modifierMetaStateMask, c3, defaultSize3, 2061780482, false, (String) objArr25[0], null);
        }
        long j5 = ((Field) objAccessartificialFrame9).getLong(null);
        if (j5 != -1) {
            long j6 = j5 + 1968;
            Object[] objArr26 = new Object[1];
            f(new char[]{15, '\f', 6, 1, 65483, '\f', 16, 65483, 65520, 22, 16, 17, 2, '\n', 65504, '\t', '\f', 0, '\b', 65534, 11, 1}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 18, 18 - ((byte) KeyEvent.getModifierMetaStateMask()), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 230, false, objArr26);
            Class<?> cls7 = Class.forName((String) objArr26[0]);
            Object[] objArr27 = new Object[1];
            f(new char[]{5, 65530, 65534, 65515, 65533, 65534, '\f', '\t', 65530, 5, 65534, 65534, 6, 2, CharUtils.CR}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(0) - 22, 11 - TextUtils.indexOf("", "", 0, 0), 269 - (ViewConfiguration.getJumpTapTimeout() >> 16), true, objArr27);
            if (j6 >= ((Long) cls7.getDeclaredMethod((String) objArr27[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                int i41 = getARTIFICIAL_FRAME_PACKAGE_NAME + 87;
                artificialFrame = i41 % 128;
                int i42 = i41 % 2;
                Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame10 == null) {
                    int i43 = (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 25;
                    char c4 = (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                    int packedPositionGroup = 1041 - ExpandableListView.getPackedPositionGroup(0L);
                    byte[] bArr11 = $$d;
                    byte b10 = bArr11[21];
                    Object[] objArr28 = new Object[1];
                    e((byte) (b10 - 1), (byte) (-bArr11[11]), b10, objArr28);
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(i43, c4, packedPositionGroup, 1145017376, false, (String) objArr28[0], null);
                }
                Object[] objArr29 = (Object[]) ((Field) objAccessartificialFrame10).get(null);
                objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                int i44 = ((int[]) objArr29[3])[0];
                int i45 = ((int[]) objArr29[2])[0];
                String[] strArr5 = (String[]) objArr29[0];
                int length = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 1628282248;
                int i46 = ~length;
                int i47 = (~(160646341 | i46)) | 103287040;
                int i48 = ~(length | (-25183234));
                int i49 = ((i47 | i48) * (-252)) + 336634110 + ((i48 | (~(i46 | 263933381))) * 252) + 710326489;
                int i50 = (i49 << 13) ^ i49;
                int i51 = i50 ^ (i50 >>> 17);
                ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i51 ^ (i51 << 5);
            } else {
                Object[] objArr30 = new Object[1];
                f(new char[]{65484, '\n', 65535, '\f', 5, 65484, 65521, 23, 17, 18, 3, 11, '\b', 65535, 20, 65535}, Color.alpha(0) + 16, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 8, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(6) + 147, false, objArr30);
                Class<?> cls8 = Class.forName((String) objArr30[0]);
                Object[] objArr31 = new Object[1];
                f(new char[]{65534, 65535, 3, 65534, 65535, '\b', 14, 3, 14, 19, 65506, 65531, CharUtils.CR, 2, 65501, '\t'}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 5, TextUtils.indexOf("", "", 0, 0) + 2, View.MeasureSpec.getMode(0) + 268, false, objArr31);
                int iIntValue = ((Integer) cls8.getMethod((String) objArr31[0], Object.class).invoke(null, this)).intValue();
                Object[] objArr32 = {1236034766};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                if (objAccessartificialFrame4 == null) {
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(Color.rgb(0, 0, 0) + 16777224, (char) (Color.alpha(0) + 22251), 1033 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)), 47343338, false, null, new Class[]{Integer.TYPE});
                }
                objArrAccessartificialFrame$78cbbd35 = com.google.firebase.R.raw.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame4).newInstance(objArr32), 710326489, false);
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame5 == null) {
                    int size = 26 - View.MeasureSpec.getSize(0);
                    char trimmedLength = (char) TextUtils.getTrimmedLength("");
                    int iRgb = Color.rgb(0, 0, 0) + 16778257;
                    byte[] bArr12 = $$d;
                    byte b11 = bArr12[21];
                    Object[] objArr33 = new Object[1];
                    e((byte) (b11 - 1), (byte) (-bArr12[11]), b11, objArr33);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(size, trimmedLength, iRgb, 1145017376, false, (String) objArr33[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, objArrAccessartificialFrame$78cbbd35);
                try {
                    Object[] objArr34 = new Object[1];
                    f(new char[]{15, '\f', 6, 1, 65483, '\f', 16, 65483, 65520, 22, 16, 17, 2, '\n', 65504, '\t', '\f', 0, '\b', 65534, 11, 1}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 27, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 2, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 230, false, objArr34);
                    Class<?> cls9 = Class.forName((String) objArr34[0]);
                    Object[] objArr35 = new Object[1];
                    f(new char[]{5, 65530, 65534, 65515, 65533, 65534, '\f', '\t', 65530, 5, 65534, 65534, 6, 2, CharUtils.CR}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 20, (ViewConfiguration.getEdgeSlop() >> 16) + 11, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 265, true, objArr35);
                    Long lValueOf3 = Long.valueOf(((Long) cls9.getDeclaredMethod((String) objArr35[0], new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-444530678);
                    if (objAccessartificialFrame6 == null) {
                        int i52 = 27 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                        char maxKeyCode = (char) (KeyEvent.getMaxKeyCode() >> 16);
                        int iIndexOf = TextUtils.indexOf("", "", 0, 0) + 1041;
                        byte[] bArr13 = $$d;
                        byte b12 = bArr13[21];
                        Object[] objArr36 = new Object[1];
                        e((byte) (b12 - 1), bArr13[5], b12, objArr36);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(i52, maxKeyCode, iIndexOf, 2061780482, false, (String) objArr36[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, lValueOf3);
                } catch (Exception unused2) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object[] objArr37 = new Object[1];
            f(new char[]{65484, '\n', 65535, '\f', 5, 65484, 65521, 23, 17, 18, 3, 11, '\b', 65535, 20, 65535}, Color.alpha(0) + 16, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 8, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(6) + 147, false, objArr37);
            Class<?> cls10 = Class.forName((String) objArr37[0]);
            Object[] objArr38 = new Object[1];
            f(new char[]{65534, 65535, 3, 65534, 65535, '\b', 14, 3, 14, 19, 65506, 65531, CharUtils.CR, 2, 65501, '\t'}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 5, TextUtils.indexOf("", "", 0, 0) + 2, View.MeasureSpec.getMode(0) + 268, false, objArr38);
            int iIntValue2 = ((Integer) cls10.getMethod((String) objArr38[0], Object.class).invoke(null, this)).intValue();
            Object[] objArr39 = {1236034766};
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame4 == null) {
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(Color.rgb(0, 0, 0) + 16777224, (char) (Color.alpha(0) + 22251), 1033 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)), 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = com.google.firebase.R.raw.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame4).newInstance(objArr39), 710326489, false);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame5 == null) {
                int size2 = 26 - View.MeasureSpec.getSize(0);
                char trimmedLength2 = (char) TextUtils.getTrimmedLength("");
                int iRgb2 = Color.rgb(0, 0, 0) + 16778257;
                byte[] bArr14 = $$d;
                byte b13 = bArr14[21];
                Object[] objArr310 = new Object[1];
                e((byte) (b13 - 1), (byte) (-bArr14[11]), b13, objArr310);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(size2, trimmedLength2, iRgb2, 1145017376, false, (String) objArr310[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArrAccessartificialFrame$78cbbd35);
            Object[] objArr311 = new Object[1];
            f(new char[]{15, '\f', 6, 1, 65483, '\f', 16, 65483, 65520, 22, 16, 17, 2, '\n', 65504, '\t', '\f', 0, '\b', 65534, 11, 1}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 27, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 2, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 230, false, objArr311);
            Class<?> cls11 = Class.forName((String) objArr311[0]);
            Object[] objArr312 = new Object[1];
            f(new char[]{5, 65530, 65534, 65515, 65533, 65534, '\f', '\t', 65530, 5, 65534, 65534, 6, 2, CharUtils.CR}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 20, (ViewConfiguration.getEdgeSlop() >> 16) + 11, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 265, true, objArr312);
            Long lValueOf4 = Long.valueOf(((Long) cls11.getDeclaredMethod((String) objArr312[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame6 == null) {
                int i53 = 27 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                char maxKeyCode2 = (char) (KeyEvent.getMaxKeyCode() >> 16);
                int iIndexOf2 = TextUtils.indexOf("", "", 0, 0) + 1041;
                byte[] bArr15 = $$d;
                byte b14 = bArr15[21];
                Object[] objArr313 = new Object[1];
                e((byte) (b14 - 1), bArr15[5], b14, objArr313);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(i53, maxKeyCode2, iIndexOf2, 2061780482, false, (String) objArr313[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf4);
        }
        int i54 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        int i55 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i55 == i54) {
            Object[] objArr40 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i56 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i57 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i58 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr6 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int iMyTid = Process.myTid();
            int i59 = ~iMyTid;
            int i60 = (~((-223692478) | i59)) | 89146881;
            int i61 = ~(iMyTid | (-11043075));
            int i62 = i56 + 1880165108 + ((i60 | i61) * (-502)) + ((i61 | (~(i59 | (-134545597)))) * TypedValues.PositionType.TYPE_DRAWPATH);
            int i63 = (i62 << 13) ^ i62;
            int i64 = i63 ^ (i63 >>> 17);
            ((int[]) objArr40[1])[0] = i64 ^ (i64 << 5);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        String[] strArr7 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
        if (strArr7 != null) {
            for (String str2 : strArr7) {
                int i65 = artificialFrame + 119;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i65 % 128;
                int i66 = i65 % 2;
                arrayList2.add(str2);
            }
        }
        Object[] objArr41 = {Long.valueOf(((long) (i54 ^ i55)) ^ (((long) 822269570) << 32)), Long.valueOf(822269568)};
        byte[] bArr16 = $$j;
        Object[] objArr42 = new Object[1];
        d(bArr16[16], bArr16[101], bArr16[100], objArr42);
        Class<?> cls12 = Class.forName((String) objArr42[0]);
        Object[] objArr43 = new Object[1];
        d((byte) (-bArr16[88]), bArr16[7], (byte) 75, objArr43);
        cls12.getMethod((String) objArr43[0], Long.TYPE, Long.TYPE).invoke(null, objArr41);
        Object[] objArr44 = {strArr, new int[1], new int[]{i}, new int[]{i}};
        int i67 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
        int i68 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        int i69 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        String[] strArr8 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
        int i70 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().densityDpi;
        int i71 = ~((-239101609) | (~i70));
        int i72 = i67 + (((-265873322) | i71 | (~(239101608 | i70))) * (-338)) + 407234186 + (((~(i70 | (-26771714))) | i71) * 338);
        int i73 = (i72 << 13) ^ i72;
        int i74 = i73 ^ (i73 >>> 17);
        ((int[]) objArr44[1])[0] = i74 ^ (i74 << 5);
    }

    @Override // com.facebook.react.ReactActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onStart() throws Throwable {
        int i = 2 % 2;
        int i2 = getARTIFICIAL_FRAME_PACKAGE_NAME + 67;
        artificialFrame = i2 % 128;
        int i3 = i2 % 2;
        super.onStart();
        if (i3 == 0) {
            int i4 = 18 / 0;
        }
    }
}
