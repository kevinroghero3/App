package com.hitachiapp;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.facebook.react.ReactActivity;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.reactnativekeyboardcontroller.listeners.FocusedInputObserver;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Random;
import kotlin.jvm.internal.Intrinsics;
import o.ArtificialStackFrames;
import o.extraCallback;
import okio.Utf8;
import org.apache.commons.lang3.CharUtils;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class LaunchActivity extends ReactActivity {
    private static final byte[] $$l = {54, 81, -13, 100};
    private static final int $$m = 220;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$j = {6, Ascii.FS, 8, -86, 8, -55, 70, 1, 7, -66, 65, 6, -5, -2, 2, 5, Ascii.VT, -58, 56, Ascii.SI, 6, -10, -52, 72, 0, -4, -56, Ascii.CAN, 57, -19, Ascii.FF, 0, -3, -30, 54, -12, 3, 2, Ascii.DLE, -27, 33, -14, 5, Ascii.VT, -3, Ascii.DLE, 3, SignedBytes.MAX_POWER_OF_TWO, Ascii.SI, 1, -60, 60, Ascii.VT, 3, -5, 8, -4, -52, 54, Ascii.DLE, -7, 17, 0, -3, -2, -51, 66, -9, Ascii.SYN, -12, Ascii.DLE, -6, -5, Ascii.SO, -59, 56, Ascii.SI, 0, 6, 6, -65, 74, 2, -8, 6, 0, Ascii.SO, -8, -1, 17, -66, Ascii.EM, 56, -8, -10, Ascii.SI, -1, -3, -29, 47, 0, 6, 6, -75, 3, 36, 54, -1, -12, Ascii.DLE, -1, -10, Ascii.SO, -22, 41, -8, 9, -9, 0, Ascii.DC2, -8, -3, -20, Ascii.CAN, Ascii.SI, -8, 5, 0, -46};
    private static final int $$k = 71;
    private static final byte[] $$d = {38, -81, -30, 49, -5, 1, 33, -33, 2, 9, -5, 7, -5, 1, 50, -39, -11, 7, Ascii.FF, -15, -27, -1, 7, 6, 33, -51, Ascii.FF, -3, 8, -1, -13};
    private static final int $$e = 139;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static char[] ArtificialStackFrames = {44389, 44334, 44394, 44399, 44360, 44406, 44371, 44404, 44698, 44409, 44402, 44400, 44385, 44398, 44388, 44403, 44370, 44393, 44392, 44355, 44395, 44391, 44397, 44396, 44387};
    private static char coroutineCreation = 39071;

    /* JADX WARN: Code duplicated, block: B:10:0x0021  */
    /* JADX WARN: Code duplicated, block: B:8:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0021 -> B:11:0x0028). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0021
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$n(byte r6, int r7, int r8) {
        /*
            int r6 = r6 * 3
            int r0 = r6 + 1
            byte[] r1 = com.hitachiapp.LaunchActivity.$$l
            int r8 = r8 + 4
            int r7 = 105 - r7
            byte[] r0 = new byte[r0]
            r2 = 0
            if (r1 != 0) goto L13
            r4 = r6
            r7 = r8
            r3 = r2
            goto L28
        L13:
            r3 = r2
        L14:
            int r8 = r8 + 1
            byte r4 = (byte) r7
            r0[r3] = r4
            if (r3 != r6) goto L21
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            return r6
        L21:
            int r3 = r3 + 1
            r4 = r1[r8]
            r5 = r8
            r8 = r7
            r7 = r5
        L28:
            int r8 = r8 + r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hitachiapp.LaunchActivity.$$n(byte, int, int):java.lang.String");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0023  */
    /* JADX WARN: Code duplicated, block: B:8:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x0028). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void d(byte r6, byte r7, byte r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = com.hitachiapp.LaunchActivity.$$j
            int r8 = r8 * 2
            int r8 = r8 + 4
            int r1 = r6 + 1
            int r7 = r7 + 36
            byte[] r1 = new byte[r1]
            r2 = 0
            if (r0 != 0) goto L13
            r7 = r6
            r3 = r8
            r4 = r2
            goto L28
        L13:
            r3 = r2
        L14:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L23
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L23:
            r3 = r0[r8]
            r5 = r3
            r3 = r8
            r8 = r5
        L28:
            int r7 = r7 + r8
            int r7 = r7 + (-3)
            int r8 = r3 + 1
            r3 = r4
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hitachiapp.LaunchActivity.d(byte, byte, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x002c  */
    /* JADX WARN: Code duplicated, block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002c -> B:11:0x002e). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x002c
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void e(byte r6, int r7, int r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = com.hitachiapp.LaunchActivity.$$d
            int r6 = r6 * 8
            int r6 = 20 - r6
            int r8 = r8 * 28
            int r8 = 112 - r8
            int r7 = r7 * 3
            int r1 = r7 + 9
            byte[] r1 = new byte[r1]
            int r7 = r7 + 8
            r2 = 0
            if (r0 != 0) goto L19
            r8 = r6
            r3 = r7
            r4 = r2
            goto L2e
        L19:
            r3 = r2
            r5 = r8
            r8 = r6
            r6 = r5
        L1d:
            byte r4 = (byte) r6
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r7) goto L2c
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2c:
            r3 = r0[r8]
        L2e:
            int r3 = -r3
            int r6 = r6 + r3
            int r8 = r8 + 1
            r3 = r4
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hitachiapp.LaunchActivity.e(byte, int, int, java.lang.Object[]):void");
    }

    @Override // com.facebook.react.ReactActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Application application = getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.hitachiapp.MainApplication");
        if (!((MainApplication) application).isActivityInBackStack(MainActivity.class)) {
            startActivity(new Intent(this, (Class<?>) MainActivity.class));
        }
        finish();
    }

    @Override // com.facebook.react.ReactActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onResume() throws Throwable {
        int i = 2 % 2;
        int i2 = artificialFrame + 67;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i2 % 128;
        try {
            if (i2 % 2 != 0) {
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(949068051);
                if (objAccessartificialFrame == null) {
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(30 - Color.alpha(0), (char) (49992 - TextUtils.indexOf((CharSequence) "", '0', 0, 0)), (ViewConfiguration.getJumpTapTimeout() >> 16) + 74, -1477122277, false, "MediaDescriptionCompatApi23Builder", null);
                }
                Object obj = ((Field) objAccessartificialFrame).get(null);
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1579113874);
                if (objAccessartificialFrame2 == null) {
                    int iRed = Color.red(0) + 30;
                    char packedPositionGroup = (char) (ExpandableListView.getPackedPositionGroup(0L) + 49993);
                    int i3 = (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 75;
                    byte b = $$j[24];
                    byte b2 = b;
                    Object[] objArr = new Object[1];
                    d(b2, (byte) (b2 | 62), b, objArr);
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iRed, packedPositionGroup, i3, -1048962150, false, (String) objArr[0], new Class[0]);
                }
                ((Method) objAccessartificialFrame2).invoke(obj, null);
                super.onResume();
                throw null;
            }
            Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(949068051);
            if (objAccessartificialFrame3 == null) {
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(((byte) KeyEvent.getModifierMetaStateMask()) + Ascii.US, (char) (49993 - (ViewConfiguration.getTapTimeout() >> 16)), 74 - View.MeasureSpec.makeMeasureSpec(0, 0), -1477122277, false, "MediaDescriptionCompatApi23Builder", null);
            }
            Object obj2 = ((Field) objAccessartificialFrame3).get(null);
            Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1579113874);
            if (objAccessartificialFrame4 == null) {
                int absoluteGravity = Gravity.getAbsoluteGravity(0, 0) + 30;
                char size = (char) (View.MeasureSpec.getSize(0) + 49993);
                int iRed2 = Color.red(0) + 74;
                byte b3 = $$j[24];
                byte b4 = b3;
                Object[] objArr2 = new Object[1];
                d(b4, (byte) (b4 | 62), b3, objArr2);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(absoluteGravity, size, iRed2, -1048962150, false, (String) objArr2[0], new Class[0]);
            }
            ((Method) objAccessartificialFrame4).invoke(obj2, null);
            super.onResume();
            int i4 = artificialFrame + 79;
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

    @Override // com.facebook.react.ReactActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onPause() throws Throwable {
        int i = 2 % 2;
        int i2 = artificialFrame + 99;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i2 % 128;
        if (i2 % 2 != 0) {
            Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(949068051);
            if (objAccessartificialFrame == null) {
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(30 - TextUtils.getCapsMode("", 0, 0), (char) (49993 - Drawable.resolveOpacity(0, 0)), Color.blue(0) + 74, -1477122277, false, "MediaDescriptionCompatApi23Builder", null);
            }
            Object obj = ((Field) objAccessartificialFrame).get(null);
            try {
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1579114835);
                if (objAccessartificialFrame2 == null) {
                    int mode = View.MeasureSpec.getMode(0) + 30;
                    char cIndexOf = (char) (49992 - TextUtils.indexOf((CharSequence) "", '0', 0, 0));
                    int offsetBefore = 74 - TextUtils.getOffsetBefore("", 0);
                    byte b = $$j[24];
                    byte b2 = b;
                    Object[] objArr = new Object[1];
                    d(b2, (byte) (b2 | Utf8.REPLACEMENT_BYTE), b, objArr);
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(mode, cIndexOf, offsetBefore, -1048959141, false, (String) objArr[0], new Class[0]);
                }
                ((Method) objAccessartificialFrame2).invoke(obj, null);
                super.onPause();
                throw null;
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
            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(30 - TextUtils.getOffsetBefore("", 0), (char) (49993 - TextUtils.indexOf("", "")), AndroidCharacter.getMirror('0') + 26, -1477122277, false, "MediaDescriptionCompatApi23Builder", null);
        }
        Object obj2 = ((Field) objAccessartificialFrame3).get(null);
        try {
            Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1579114835);
            if (objAccessartificialFrame4 == null) {
                int tapTimeout = (ViewConfiguration.getTapTimeout() >> 16) + 30;
                char keyRepeatDelay = (char) (49993 - (ViewConfiguration.getKeyRepeatDelay() >> 16));
                int mirror = 'z' - AndroidCharacter.getMirror('0');
                byte b3 = $$j[24];
                byte b4 = b3;
                Object[] objArr2 = new Object[1];
                d(b4, (byte) (b4 | Utf8.REPLACEMENT_BYTE), b3, objArr2);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(tapTimeout, keyRepeatDelay, mirror, -1048959141, false, (String) objArr2[0], new Class[0]);
            }
            ((Method) objAccessartificialFrame4).invoke(obj2, null);
            super.onPause();
        } catch (Throwable th2) {
            Throwable cause2 = th2.getCause();
            if (cause2 == null) {
                throw th2;
            }
            throw cause2;
        }
    }

    private static void f(byte b, int i, char[] cArr, Object[] objArr) throws Throwable {
        int i2;
        int i3 = 2 % 2;
        extraCallback extracallback = new extraCallback();
        char[] cArr2 = ArtificialStackFrames;
        int i4 = -1819279892;
        int i5 = 0;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            int i6 = 0;
            while (i6 < length) {
                try {
                    Object[] objArr2 = new Object[1];
                    objArr2[i5] = Integer.valueOf(cArr2[i6]);
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(i4);
                    if (objAccessartificialFrame == null) {
                        byte b2 = (byte) i5;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 15, (char) (20488 - TextUtils.getTrimmedLength("")), 2148 - TextUtils.getOffsetBefore("", i5), 216710116, false, $$n(b2, (byte) (b2 | 8), (byte) (-1)), new Class[]{Integer.TYPE});
                    }
                    cArr3[i6] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                    i6++;
                    i4 = -1819279892;
                    i5 = 0;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            cArr2 = cArr3;
        }
        Object[] objArr3 = {Integer.valueOf(coroutineCreation)};
        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1819279892);
        if (objAccessartificialFrame2 == null) {
            byte b3 = (byte) 0;
            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 15, (char) ((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 20488), (ViewConfiguration.getJumpTapTimeout() >> 16) + 2148, 216710116, false, $$n(b3, (byte) (b3 | 8), (byte) (-1)), new Class[]{Integer.TYPE});
        }
        char cCharValue = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
        char[] cArr4 = new char[i];
        if (i % 2 != 0) {
            int i7 = $11 + 125;
            $10 = i7 % 128;
            if (i7 % 2 != 0) {
                i2 = i + 29;
                cArr4[i2] = (char) (cArr[i2] / b);
            } else {
                i2 = i - 1;
                cArr4[i2] = (char) (cArr[i2] - b);
            }
        } else {
            i2 = i;
        }
        if (i2 > 1) {
            int i8 = $10 + 21;
            $11 = i8 % 128;
            int i9 = i8 % 2;
            extracallback.a = 0;
            while (extracallback.a < i2) {
                extracallback.createBrowser = cArr[extracallback.a];
                extracallback.c = cArr[extracallback.a + 1];
                if (extracallback.createBrowser == extracallback.c) {
                    int i10 = $10 + 25;
                    $11 = i10 % 128;
                    int i11 = i10 % 2;
                    cArr4[extracallback.a] = (char) (extracallback.createBrowser - b);
                    cArr4[extracallback.a + 1] = (char) (extracallback.c - b);
                } else {
                    Object[] objArr4 = {extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1894223152);
                    if (objAccessartificialFrame3 == null) {
                        byte b4 = (byte) 0;
                        byte b5 = (byte) (b4 + 3);
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(View.MeasureSpec.getSize(0) + 46, (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 58860), 2465 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), 276640984, false, $$n(b4, b5, (byte) (b5 - 4)), new Class[]{Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class});
                    }
                    if (((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue() == extracallback.g) {
                        int i12 = $10 + 87;
                        $11 = i12 % 128;
                        int i13 = i12 % 2;
                        Object[] objArr5 = {extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, Integer.valueOf(cCharValue), extracallback};
                        Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1361113423);
                        if (objAccessartificialFrame4 == null) {
                            byte b6 = (byte) 0;
                            byte b7 = b6;
                            objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(24 - View.combineMeasuredStates(0, 0), (char) Color.red(0), AndroidCharacter.getMirror('0') + 744, -834291897, false, $$n(b6, b7, (byte) (b7 - 1)), new Class[]{Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Integer.TYPE, Object.class});
                        }
                        int iIntValue = ((Integer) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).intValue();
                        int i14 = (extracallback.d * cCharValue) + extracallback.g;
                        cArr4[extracallback.a] = cArr2[iIntValue];
                        cArr4[extracallback.a + 1] = cArr2[i14];
                    } else if (extracallback.b == extracallback.d) {
                        extracallback.j = ((extracallback.j + cCharValue) - 1) % cCharValue;
                        extracallback.g = ((extracallback.g + cCharValue) - 1) % cCharValue;
                        int i15 = (extracallback.b * cCharValue) + extracallback.j;
                        int i16 = (extracallback.d * cCharValue) + extracallback.g;
                        cArr4[extracallback.a] = cArr2[i15];
                        cArr4[extracallback.a + 1] = cArr2[i16];
                    } else {
                        int i17 = (extracallback.b * cCharValue) + extracallback.g;
                        int i18 = (extracallback.d * cCharValue) + extracallback.j;
                        cArr4[extracallback.a] = cArr2[i17];
                        cArr4[extracallback.a + 1] = cArr2[i18];
                    }
                }
                extracallback.a += 2;
                int i19 = $11 + 67;
                $10 = i19 % 128;
                int i20 = i19 % 2;
            }
        }
        for (int i21 = 0; i21 < i; i21++) {
            cArr4[i21] = (char) (cArr4[i21] ^ 13722);
        }
        objArr[0] = new String(cArr4);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:16:0x02a3 A[Catch: all -> 0x0b63, TryCatch #2 {all -> 0x0b63, blocks: (B:54:0x0837, B:56:0x0857, B:57:0x08a5, B:14:0x028f, B:16:0x02a3, B:17:0x02d2), top: B:101:0x028f }] */
    /* JADX WARN: Code duplicated, block: B:20:0x02e8  */
    /* JADX WARN: Code duplicated, block: B:25:0x03cd  */
    /* JADX WARN: Code duplicated, block: B:53:0x076f  */
    /* JADX WARN: Code duplicated, block: B:56:0x0857 A[Catch: all -> 0x0b63, TryCatch #2 {all -> 0x0b63, blocks: (B:54:0x0837, B:56:0x0857, B:57:0x08a5, B:14:0x028f, B:16:0x02a3, B:17:0x02d2), top: B:101:0x028f }] */
    /* JADX WARN: Code duplicated, block: B:60:0x08b7  */
    /* JADX WARN: Code duplicated, block: B:65:0x098b  */
    @Override // com.facebook.react.ReactActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) throws Throwable {
        Object objAccessartificialFrame;
        Object[] objArrAccessartificialFrame$78cbbd35;
        Object objAccessartificialFrame2;
        Object objAccessartificialFrame3;
        Object objAccessartificialFrame4;
        Object[] objArr;
        Object objAccessartificialFrame5;
        Object objAccessartificialFrame6;
        int i = 2 % 2;
        super.attachBaseContext(context);
        Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-444530678);
        if (objAccessartificialFrame7 == null) {
            int mode = View.MeasureSpec.getMode(0) + 26;
            char modifierMetaStateMask = (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 1);
            int maximumFlingVelocity = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 1041;
            byte b = $$d[8];
            byte b2 = (byte) (b - 2);
            Object[] objArr2 = new Object[1];
            e(b, b2, b2, objArr2);
            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(mode, modifierMetaStateMask, maximumFlingVelocity, 2061780482, false, (String) objArr2[0], null);
        }
        long j = ((Field) objAccessartificialFrame7).getLong(null);
        if (j != -1) {
            long j2 = j + 1968;
            Object[] objArr3 = new Object[1];
            f((byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) + 20), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 18, new char[]{CharUtils.CR, 14, '\n', 11, 2, 18, 11, 4, 0, 18, 6, 11, 5, 19, 5, 2, 24, 17, 3, '\b', 20, 21}, objArr3);
            Class<?> cls = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            f((byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 14), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 20, new char[]{3, 20, CharUtils.CR, '\f', 20, 5, 11, 19, 2, '\n', 22, '\b', 22, 2, 13841}, objArr4);
            if (j2 >= ((Long) cls.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame8 == null) {
                    int iResolveOpacity = 26 - Drawable.resolveOpacity(0, 0);
                    char cNormalizeMetaState = (char) KeyEvent.normalizeMetaState(0);
                    int maximumFlingVelocity2 = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 1041;
                    byte b3 = $$d[5];
                    byte b4 = (byte) (b3 - 1);
                    Object[] objArr5 = new Object[1];
                    e(b3, b4, b4, objArr5);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(iResolveOpacity, cNormalizeMetaState, maximumFlingVelocity2, 1145017376, false, (String) objArr5[0], null);
                }
                Object[] objArr6 = (Object[]) ((Field) objAccessartificialFrame8).get(null);
                objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                int i2 = ((int[]) objArr6[3])[0];
                int i3 = ((int[]) objArr6[2])[0];
                String[] strArr = (String[]) objArr6[0];
                int ringerMode = ((AudioManager) ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getSystemService("audio")).getRingerMode();
                int i4 = (((-1260364472) + (((~(503738876 | ringerMode)) | 581842683) * (-366))) + (((~(ringerMode | 1051621375)) | 33960184) * 366)) - 378007342;
                int i5 = (i4 << 13) ^ i4;
                int i6 = i5 ^ (i5 >>> 17);
                ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i6 ^ (i6 << 5);
                int i7 = getARTIFICIAL_FRAME_PACKAGE_NAME + 15;
                artificialFrame = i7 % 128;
                int i8 = i7 % 2;
            } else {
                Object[] objArr7 = new Object[1];
                f((byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(6) - 76), (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 15, new char[]{7, 17, 7, '\n', 3, 21, CharUtils.CR, 14, 1, 6, 7, 5, 17, 5, 2, 20}, objArr7);
                Class<?> cls2 = Class.forName((String) objArr7[0]);
                Object[] objArr8 = new Object[1];
                f((byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) + 87), (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 16, new char[]{19, '\f', 3, '\n', '\f', 22, '\b', 5, 2, 14, 16, 19, 18, 4, '\n', 4}, objArr8);
                int iIntValue = ((Integer) cls2.getMethod((String) objArr8[0], Object.class).invoke(null, this)).intValue();
                try {
                    Object[] objArr9 = {2026262112};
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1648942878);
                    if (objAccessartificialFrame == null) {
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(8 - Color.alpha(0), (char) (MotionEvent.axisFromString("") + 22252), (KeyEvent.getMaxKeyCode() >> 16) + 1033, 47343338, false, null, new Class[]{Integer.TYPE});
                    }
                    objArrAccessartificialFrame$78cbbd35 = FocusedInputObserver.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame).newInstance(objArr9), -378007342, false);
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-614804952);
                    if (objAccessartificialFrame2 == null) {
                        int i9 = 26 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                        char windowTouchSlop = (char) (ViewConfiguration.getWindowTouchSlop() >> 8);
                        int iMyTid = (Process.myTid() >> 22) + 1041;
                        byte b5 = $$d[5];
                        byte b6 = (byte) (b5 - 1);
                        Object[] objArr10 = new Object[1];
                        e(b5, b6, b6, objArr10);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(i9, windowTouchSlop, iMyTid, 1145017376, false, (String) objArr10[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, objArrAccessartificialFrame$78cbbd35);
                    try {
                        Object[] objArr11 = new Object[1];
                        f((byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(0) + 19), ((Process.getThreadPriority(0) + 20) >> 6) + 22, new char[]{CharUtils.CR, 14, '\n', 11, 2, 18, 11, 4, 0, 18, 6, 11, 5, 19, 5, 2, 24, 17, 3, '\b', 20, 21}, objArr11);
                        Class<?> cls3 = Class.forName((String) objArr11[0]);
                        Object[] objArr12 = new Object[1];
                        f((byte) ((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 18), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 20, new char[]{3, 20, CharUtils.CR, '\f', 20, 5, 11, 19, 2, '\n', 22, '\b', 22, 2, 13841}, objArr12);
                        Long lValueOf = Long.valueOf(((Long) cls3.getDeclaredMethod((String) objArr12[0], new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-444530678);
                        if (objAccessartificialFrame3 == null) {
                            int packedPositionGroup = 26 - ExpandableListView.getPackedPositionGroup(0L);
                            char capsMode = (char) TextUtils.getCapsMode("", 0, 0);
                            int maximumDrawingCacheSize = (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 1041;
                            byte b7 = $$d[8];
                            byte b8 = (byte) (b7 - 2);
                            Object[] objArr13 = new Object[1];
                            e(b7, b8, b8, objArr13);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(packedPositionGroup, capsMode, maximumDrawingCacheSize, 2061780482, false, (String) objArr13[0], null);
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
            Object[] objArr14 = new Object[1];
            f((byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(6) - 76), (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 15, new char[]{7, 17, 7, '\n', 3, 21, CharUtils.CR, 14, 1, 6, 7, 5, 17, 5, 2, 20}, objArr14);
            Class<?> cls4 = Class.forName((String) objArr14[0]);
            Object[] objArr15 = new Object[1];
            f((byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) + 87), (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 16, new char[]{19, '\f', 3, '\n', '\f', 22, '\b', 5, 2, 14, 16, 19, 18, 4, '\n', 4}, objArr15);
            int iIntValue2 = ((Integer) cls4.getMethod((String) objArr15[0], Object.class).invoke(null, this)).intValue();
            Object[] objArr16 = {2026262112};
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame == null) {
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(8 - Color.alpha(0), (char) (MotionEvent.axisFromString("") + 22252), (KeyEvent.getMaxKeyCode() >> 16) + 1033, 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = FocusedInputObserver.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame).newInstance(objArr16), -378007342, false);
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame2 == null) {
                int i10 = 26 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                char windowTouchSlop2 = (char) (ViewConfiguration.getWindowTouchSlop() >> 8);
                int iMyTid2 = (Process.myTid() >> 22) + 1041;
                byte b9 = $$d[5];
                byte b10 = (byte) (b9 - 1);
                Object[] objArr17 = new Object[1];
                e(b9, b10, b10, objArr17);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(i10, windowTouchSlop2, iMyTid2, 1145017376, false, (String) objArr17[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, objArrAccessartificialFrame$78cbbd35);
            Object[] objArr18 = new Object[1];
            f((byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(0) + 19), ((Process.getThreadPriority(0) + 20) >> 6) + 22, new char[]{CharUtils.CR, 14, '\n', 11, 2, 18, 11, 4, 0, 18, 6, 11, 5, 19, 5, 2, 24, 17, 3, '\b', 20, 21}, objArr18);
            Class<?> cls5 = Class.forName((String) objArr18[0]);
            Object[] objArr19 = new Object[1];
            f((byte) ((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 18), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 20, new char[]{3, 20, CharUtils.CR, '\f', 20, 5, 11, 19, 2, '\n', 22, '\b', 22, 2, 13841}, objArr19);
            Long lValueOf2 = Long.valueOf(((Long) cls5.getDeclaredMethod((String) objArr19[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame3 == null) {
                int packedPositionGroup2 = 26 - ExpandableListView.getPackedPositionGroup(0L);
                char capsMode2 = (char) TextUtils.getCapsMode("", 0, 0);
                int maximumDrawingCacheSize2 = (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 1041;
                byte b11 = $$d[8];
                byte b12 = (byte) (b11 - 2);
                Object[] objArr110 = new Object[1];
                e(b11, b12, b12, objArr110);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(packedPositionGroup2, capsMode2, maximumDrawingCacheSize2, 2061780482, false, (String) objArr110[0], null);
            }
            ((Field) objAccessartificialFrame3).set(null, lValueOf2);
        }
        int i11 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        int i12 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i12 != i11) {
            ArrayList arrayList = new ArrayList();
            String[] strArr2 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            if (strArr2 != null) {
                int i13 = artificialFrame + 49;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i13 % 128;
                int i14 = i13 % 2;
                int i15 = 0;
                while (i15 < strArr2.length) {
                    int i16 = getARTIFICIAL_FRAME_PACKAGE_NAME + 91;
                    artificialFrame = i16 % 128;
                    if (i16 % 2 == 0) {
                        arrayList.add(strArr2[i15]);
                        i15 += 51;
                    } else {
                        arrayList.add(strArr2[i15]);
                        i15++;
                    }
                }
            }
            long j3 = ((long) (i11 ^ i12)) ^ (((long) (-462412795)) << 32);
            long j4 = -462412793;
            int i17 = artificialFrame + 113;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i17 % 128;
            int i18 = i17 % 2;
            try {
                Object[] objArr20 = {Long.valueOf(j3), Long.valueOf(j4)};
                byte[] bArr = $$j;
                byte b13 = (byte) (bArr[114] + 1);
                Object[] objArr21 = new Object[1];
                d(b13, (byte) (b13 | Ascii.NAK), bArr[24], objArr21);
                Class<?> cls6 = Class.forName((String) objArr21[0]);
                byte b14 = bArr[14];
                byte b15 = bArr[24];
                Object[] objArr22 = new Object[1];
                d(b14, b15, (byte) (b15 | Ascii.NAK), objArr22);
                cls6.getMethod((String) objArr22[0], Long.TYPE, Long.TYPE).invoke(null, objArr20);
                Object[] objArr23 = {strArr, new int[1], new int[]{i}, new int[]{i}};
                int i19 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
                int i20 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                int i21 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                String[] strArr3 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                int iCodePointAt = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(3) - 1413381393;
                int i22 = ~iCodePointAt;
                int i23 = i19 + (-1166362852) + (((-10502161) | i22) * (-369)) + (((~((-793718768) | i22)) | (-715614961)) * (-369)) + (((~(iCodePointAt | 793718767)) | (-804220928) | (~(i22 | (-705112801)))) * 369);
                int i24 = (i23 << 13) ^ i23;
                int i25 = i24 ^ (i24 >>> 17);
                ((int[]) objArr23[1])[0] = i25 ^ (i25 << 5);
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 != null) {
                    throw cause2;
                }
                throw th2;
            }
        } else {
            int i26 = getARTIFICIAL_FRAME_PACKAGE_NAME + 3;
            artificialFrame = i26 % 128;
            int i27 = i26 % 2;
            Object[] objArr24 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i28 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i29 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i30 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr4 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int iNextInt = new Random().nextInt(1246871056);
            int i31 = ~iNextInt;
            int i32 = (~(450482127 | i31)) | (-534372304) | (~(528585934 | i31));
            int i33 = i28 + (-2046435110) + (((~(iNextInt | (-444695759))) | i32) * 590) + (i32 * (-1180)) + (((~((-528585935) | i31)) | (~(i31 | (-450482128)))) * 590);
            int i34 = (i33 << 13) ^ i33;
            int i35 = i34 ^ (i34 >>> 17);
            ((int[]) objArr24[1])[0] = i35 ^ (i35 << 5);
        }
        Object objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame9 == null) {
            int i36 = (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 24;
            char packedPositionGroup3 = (char) (ExpandableListView.getPackedPositionGroup(0L) + 30068);
            int i37 = (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 815;
            byte b16 = $$d[8];
            byte b17 = (byte) (b16 - 2);
            Object[] objArr25 = new Object[1];
            e(b16, b17, b17, objArr25);
            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(i36, packedPositionGroup3, i37, 721586079, false, (String) objArr25[0], null);
        }
        long j5 = ((Field) objAccessartificialFrame9).getLong(null);
        if (j5 == -1) {
            Object[] objArr26 = new Object[1];
            f((byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 6), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 12, new char[]{7, 17, 7, '\n', 3, 21, CharUtils.CR, 14, 1, 6, 7, 5, 17, 5, 2, 20}, objArr26);
            Class<?> cls7 = Class.forName((String) objArr26[0]);
            Object[] objArr27 = new Object[1];
            f((byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 119), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 19, new char[]{19, '\f', 3, '\n', '\f', 22, '\b', 5, 2, 14, 16, 19, 18, 4, '\n', 4}, objArr27);
            Object[] objArr28 = {Integer.valueOf(((Integer) cls7.getMethod((String) objArr27[0], Object.class).invoke(null, this)).intValue()), 0, -1033723892};
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame4 == null) {
                int i38 = 26 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                char cResolveSizeAndState = (char) (30068 - View.resolveSizeAndState(0, 0, 0));
                int i39 = 817 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                byte b18 = $$d[5];
                byte b19 = (byte) (b18 - 1);
                byte b20 = b18;
                Object[] objArr29 = new Object[1];
                e(b19, b20, b20, objArr29);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(i38, cResolveSizeAndState, i39, -797394565, false, (String) objArr29[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr28);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame5 == null) {
                int i40 = 25 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                char size = (char) (30068 - View.MeasureSpec.getSize(0));
                int mode2 = 816 - View.MeasureSpec.getMode(0);
                byte b21 = $$d[5];
                byte b22 = (byte) (b21 - 1);
                Object[] objArr30 = new Object[1];
                e(b21, b22, b22, objArr30);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(i40, size, mode2, 891606461, false, (String) objArr30[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArr);
            Object[] objArr31 = new Object[1];
            f((byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 21), TextUtils.getOffsetAfter("", 0) + 22, new char[]{CharUtils.CR, 14, '\n', 11, 2, 18, 11, 4, 0, 18, 6, 11, 5, 19, 5, 2, 24, 17, 3, '\b', 20, 21}, objArr31);
            Class<?> cls8 = Class.forName((String) objArr31[0]);
            Object[] objArr32 = new Object[1];
            f((byte) (Color.rgb(0, 0, 0) + 16777234), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 6, new char[]{3, 20, CharUtils.CR, '\f', 20, 5, 11, 19, 2, '\n', 22, '\b', 22, 2, 13841}, objArr32);
            Long lValueOf3 = Long.valueOf(((Long) cls8.getDeclaredMethod((String) objArr32[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame6 == null) {
                int bitsPerPixel = 24 - ImageFormat.getBitsPerPixel(0);
                char cResolveOpacity = (char) (30068 - Drawable.resolveOpacity(0, 0));
                int packedPositionGroup4 = ExpandableListView.getPackedPositionGroup(0L) + 816;
                byte b23 = $$d[8];
                byte b24 = (byte) (b23 - 2);
                Object[] objArr33 = new Object[1];
                e(b23, b24, b24, objArr33);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(bitsPerPixel, cResolveOpacity, packedPositionGroup4, 721586079, false, (String) objArr33[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf3);
        } else {
            long j6 = j5 + 2049;
            Object[] objArr34 = new Object[1];
            f((byte) (55 - TextUtils.indexOf((CharSequence) "", '0', 0)), (ViewConfiguration.getDoubleTapTimeout() >> 16) + 22, new char[]{CharUtils.CR, 14, '\n', 11, 2, 18, 11, 4, 0, 18, 6, 11, 5, 19, 5, 2, 24, 17, 3, '\b', 20, 21}, objArr34);
            Class<?> cls9 = Class.forName((String) objArr34[0]);
            Object[] objArr35 = new Object[1];
            f((byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 17), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(3) - 100, new char[]{3, 20, CharUtils.CR, '\f', 20, 5, 11, 19, 2, '\n', 22, '\b', 22, 2, 13841}, objArr35);
            if (j6 < ((Long) cls9.getDeclaredMethod((String) objArr35[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object[] objArr210 = new Object[1];
                f((byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 6), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 12, new char[]{7, 17, 7, '\n', 3, 21, CharUtils.CR, 14, 1, 6, 7, 5, 17, 5, 2, 20}, objArr210);
                Class<?> cls10 = Class.forName((String) objArr210[0]);
                Object[] objArr211 = new Object[1];
                f((byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 119), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 19, new char[]{19, '\f', 3, '\n', '\f', 22, '\b', 5, 2, 14, 16, 19, 18, 4, '\n', 4}, objArr211);
                Object[] objArr212 = {Integer.valueOf(((Integer) cls10.getMethod((String) objArr211[0], Object.class).invoke(null, this)).intValue()), 0, -1033723892};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1327366003);
                if (objAccessartificialFrame4 == null) {
                    int i310 = 26 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                    char cResolveSizeAndState2 = (char) (30068 - View.resolveSizeAndState(0, 0, 0));
                    int i311 = 817 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                    byte b110 = $$d[5];
                    byte b111 = (byte) (b110 - 1);
                    byte b25 = b110;
                    Object[] objArr213 = new Object[1];
                    e(b111, b25, b25, objArr213);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(i310, cResolveSizeAndState2, i311, -797394565, false, (String) objArr213[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                }
                objArr = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr212);
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame5 == null) {
                    int i41 = 25 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                    char size2 = (char) (30068 - View.MeasureSpec.getSize(0));
                    int mode3 = 816 - View.MeasureSpec.getMode(0);
                    byte b26 = $$d[5];
                    byte b27 = (byte) (b26 - 1);
                    Object[] objArr36 = new Object[1];
                    e(b26, b27, b27, objArr36);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(i41, size2, mode3, 891606461, false, (String) objArr36[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, objArr);
                try {
                    Object[] objArr37 = new Object[1];
                    f((byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 21), TextUtils.getOffsetAfter("", 0) + 22, new char[]{CharUtils.CR, 14, '\n', 11, 2, 18, 11, 4, 0, 18, 6, 11, 5, 19, 5, 2, 24, 17, 3, '\b', 20, 21}, objArr37);
                    Class<?> cls11 = Class.forName((String) objArr37[0]);
                    Object[] objArr38 = new Object[1];
                    f((byte) (Color.rgb(0, 0, 0) + 16777234), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 6, new char[]{3, 20, CharUtils.CR, '\f', 20, 5, 11, 19, 2, '\n', 22, '\b', 22, 2, 13841}, objArr38);
                    Long lValueOf4 = Long.valueOf(((Long) cls11.getDeclaredMethod((String) objArr38[0], new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                    if (objAccessartificialFrame6 == null) {
                        int bitsPerPixel2 = 24 - ImageFormat.getBitsPerPixel(0);
                        char cResolveOpacity2 = (char) (30068 - Drawable.resolveOpacity(0, 0));
                        int packedPositionGroup5 = ExpandableListView.getPackedPositionGroup(0L) + 816;
                        byte b28 = $$d[8];
                        byte b29 = (byte) (b28 - 2);
                        Object[] objArr39 = new Object[1];
                        e(b28, b29, b29, objArr39);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(bitsPerPixel2, cResolveOpacity2, packedPositionGroup5, 721586079, false, (String) objArr39[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, lValueOf4);
                } catch (Exception unused2) {
                    throw new RuntimeException();
                }
            } else {
                Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame10 == null) {
                    int minimumFlingVelocity = 25 - (ViewConfiguration.getMinimumFlingVelocity() >> 16);
                    char cNormalizeMetaState2 = (char) (30068 - KeyEvent.normalizeMetaState(0));
                    int i42 = 817 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                    byte b30 = $$d[5];
                    byte b31 = (byte) (b30 - 1);
                    Object[] objArr40 = new Object[1];
                    e(b30, b31, b31, objArr40);
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(minimumFlingVelocity, cNormalizeMetaState2, i42, 891606461, false, (String) objArr40[0], null);
                }
                Object[] objArr41 = (Object[]) ((Field) objAccessartificialFrame10).get(null);
                objArr = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i43 = ((int[]) objArr41[0])[0];
                int i44 = ((int[]) objArr41[1])[0];
                String[] strArr5 = (String[]) objArr41[2];
                int iIdentityHashCode = System.identityHashCode(this);
                int i45 = ~iIdentityHashCode;
                int i46 = (((1994001108 + ((~(665185751 | i45)) * 979)) + ((iIdentityHashCode | 863358117) * (-979))) + (((~(iIdentityHashCode | 665185751)) | (~(i45 | 863358117))) * 979)) - 1033723892;
                int i47 = (i46 << 13) ^ i46;
                int i48 = i47 ^ (i47 >>> 17);
                ((int[]) objArr[3])[0] = i48 ^ (i48 << 5);
            }
        }
        int i49 = ((int[]) objArr[1])[0];
        int i50 = ((int[]) objArr[0])[0];
        if (i50 != i49) {
            ArrayList arrayList2 = new ArrayList();
            String[] strArr6 = (String[]) objArr[2];
            if (strArr6 != null) {
                int i51 = 0;
                while (i51 < strArr6.length) {
                    int i52 = getARTIFICIAL_FRAME_PACKAGE_NAME + 27;
                    artificialFrame = i52 % 128;
                    if (i52 % 2 == 0) {
                        arrayList2.add(strArr6[i51]);
                        i51 += 95;
                    } else {
                        arrayList2.add(strArr6[i51]);
                        i51++;
                    }
                }
            }
            Object[] objArr42 = {Long.valueOf((((long) 1635065589) << 32) ^ ((long) (i49 ^ i50))), Long.valueOf(1635065588)};
            byte[] bArr2 = $$j;
            Object[] objArr43 = new Object[1];
            d((byte) 81, (byte) (bArr2[47] - 1), bArr2[68], objArr43);
            Class<?> cls12 = Class.forName((String) objArr43[0]);
            byte b32 = bArr2[14];
            byte b33 = bArr2[24];
            Object[] objArr44 = new Object[1];
            d(b32, b33, (byte) (b33 | Ascii.NAK), objArr44);
            cls12.getMethod((String) objArr44[0], Long.TYPE, Long.TYPE).invoke(null, objArr42);
            Object[] objArr45 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i53 = ((int[]) objArr[3])[0];
            int i54 = ((int[]) objArr[0])[0];
            int i55 = ((int[]) objArr[1])[0];
            String[] strArr7 = (String[]) objArr[2];
            int i56 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().mnc;
            int i57 = i53 + (((~((~i56) | 877980535)) * 130) - 1662890757) + (((~(i56 | 877980535)) | 264737) * 130);
            int i58 = (i57 << 13) ^ i57;
            int i59 = i58 ^ (i58 >>> 17);
            ((int[]) objArr45[3])[0] = i59 ^ (i59 << 5);
            return;
        }
        int i60 = getARTIFICIAL_FRAME_PACKAGE_NAME + 41;
        artificialFrame = i60 % 128;
        int i61 = i60 % 2;
        Object[] objArr46 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
        int i62 = ((int[]) objArr[3])[0];
        int i63 = ((int[]) objArr[0])[0];
        int i64 = ((int[]) objArr[1])[0];
        String[] strArr8 = (String[]) objArr[2];
        int iUptimeMillis = (int) SystemClock.uptimeMillis();
        int i65 = i62 + 1264953413 + (((~(456825487 | iUptimeMillis)) | 604004688) * 336) + (((~(iUptimeMillis | 654997853)) | 405832322) * (-168)) + (((~((~iUptimeMillis) | 654997853)) | 456825487) * 168);
        int i66 = (i65 << 13) ^ i65;
        int i67 = i66 ^ (i66 >>> 17);
        ((int[]) objArr46[3])[0] = i67 ^ (i67 << 5);
    }

    @Override // com.facebook.react.ReactActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onStart() throws Throwable {
        int i = 2 % 2;
        int i2 = artificialFrame + 87;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i2 % 128;
        int i3 = i2 % 2;
        super.onStart();
        if (i3 != 0) {
            throw null;
        }
        int i4 = artificialFrame + 49;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i4 % 128;
        if (i4 % 2 != 0) {
            int i5 = 44 / 0;
        }
    }
}
