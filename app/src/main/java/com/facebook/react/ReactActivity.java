package com.facebook.react;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Configuration;
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
import androidx.appcompat.app.AppCompatActivity;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.net.SyslogConstants;
import com.facebook.imageutils.JfifUtil;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.modules.core.PermissionAwareActivity;
import com.facebook.react.modules.core.PermissionListener;
import com.google.common.base.Ascii;
import com.google.common.collect.CompactHashMap;
import com.salesforce.marketingcloud.analytics.stats.b;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import kotlin.text.Typography;
import o.ArtificialStackFrames;
import o.extraCallback;
import org.apache.commons.lang3.CharEncoding;
import org.apache.commons.lang3.CharUtils;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public abstract class ReactActivity extends AppCompatActivity implements DefaultHardwareBackBtnHandler, PermissionAwareActivity {
    private static final byte[] $$a;
    private static final int $$b;
    private static final byte[] $$g;
    private static final int $$h;
    private static char[] ArtificialStackFrames;
    private static int artificialFrame;
    private static char coroutineCreation;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;
    private final ReactActivityDelegate mDelegate = createReactActivityDelegate();
    private static final byte[] $$c = {6, 70, -89, 92};
    private static final int $$f = 240;
    private static int $10 = 0;
    private static int $11 = 1;

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$i(int r6, byte r7, short r8) {
        /*
            int r7 = r7 + 97
            int r8 = r8 * 2
            int r8 = r8 + 4
            byte[] r0 = com.facebook.react.ReactActivity.$$c
            int r6 = r6 * 2
            int r1 = 1 - r6
            byte[] r1 = new byte[r1]
            r2 = 0
            int r6 = 0 - r6
            if (r0 != 0) goto L17
            r7 = r6
            r3 = r8
            r4 = r2
            goto L2a
        L17:
            r3 = r2
        L18:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L25
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            return r6
        L25:
            r3 = r0[r8]
            r5 = r3
            r3 = r8
            r8 = r5
        L2a:
            int r7 = r7 + r8
            int r8 = r3 + 1
            r3 = r4
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.ReactActivity.$$i(int, byte, short):java.lang.String");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0024  */
    /* JADX WARN: Code duplicated, block: B:8:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x0026). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0024
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void b(byte r7, int r8, int r9, java.lang.Object[] r10) {
        /*
            int r7 = r7 + 4
            int r8 = r8 + 8
            int r9 = r9 + 65
            byte[] r0 = com.facebook.react.ReactActivity.$$a
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L11
            r9 = r7
            r3 = r8
            r4 = r2
            goto L26
        L11:
            r3 = r2
            r6 = r9
            r9 = r7
            r7 = r6
        L15:
            int r4 = r3 + 1
            byte r5 = (byte) r7
            r1[r3] = r5
            if (r4 != r8) goto L24
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L24:
            r3 = r0[r9]
        L26:
            int r3 = -r3
            int r7 = r7 + r3
            int r9 = r9 + 1
            r3 = r4
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.ReactActivity.b(byte, int, int, java.lang.Object[]):void");
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
    private static void c(short r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            int r6 = 111 - r6
            byte[] r0 = com.facebook.react.ReactActivity.$$g
            int r8 = r8 + 3
            int r7 = r7 + 4
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L11
            r6 = r7
            r3 = r8
            r4 = r2
            goto L23
        L11:
            r3 = r2
        L12:
            int r4 = r3 + 1
            byte r5 = (byte) r6
            r1[r3] = r5
            if (r4 != r8) goto L21
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L21:
            r3 = r0[r7]
        L23:
            int r7 = r7 + 1
            int r3 = -r3
            int r6 = r6 + r3
            int r6 = r6 + (-4)
            r3 = r4
            goto L12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.ReactActivity.c(short, short, short, java.lang.Object[]):void");
    }

    protected String getMainComponentName() {
        return null;
    }

    protected ReactActivityDelegate createReactActivityDelegate() {
        return new ReactActivityDelegate(this, getMainComponentName());
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mDelegate.onCreate(bundle);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.mDelegate.onPause();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.mDelegate.onResume();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mDelegate.onDestroy();
    }

    public ReactDelegate getReactDelegate() {
        return this.mDelegate.getReactDelegate();
    }

    public ReactActivityDelegate getReactActivityDelegate() {
        return this.mDelegate;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.mDelegate.onActivityResult(i, i2, intent);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.mDelegate.onKeyDown(i, keyEvent) || super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return this.mDelegate.onKeyUp(i, keyEvent) || super.onKeyUp(i, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyLongPress(int i, KeyEvent keyEvent) {
        return this.mDelegate.onKeyLongPress(i, keyEvent) || super.onKeyLongPress(i, keyEvent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.mDelegate.onBackPressed()) {
            return;
        }
        super.onBackPressed();
    }

    @Override // com.facebook.react.modules.core.DefaultHardwareBackBtnHandler
    public void invokeDefaultOnBackPressed() {
        super.onBackPressed();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        if (this.mDelegate.onNewIntent(intent)) {
            return;
        }
        super.onNewIntent(intent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onUserLeaveHint() {
        super.onUserLeaveHint();
        this.mDelegate.onUserLeaveHint();
    }

    @Override // com.facebook.react.modules.core.PermissionAwareActivity
    public void requestPermissions(String[] strArr, int i, PermissionListener permissionListener) {
        this.mDelegate.requestPermissions(strArr, i, permissionListener);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NotNull String[] strArr, @NotNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        this.mDelegate.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.mDelegate.onWindowFocusChanged(z);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mDelegate.onConfigurationChanged(configuration);
    }

    protected final ReactNativeHost getReactNativeHost() {
        return this.mDelegate.getReactNativeHost();
    }

    protected ReactHost getReactHost() {
        return this.mDelegate.getReactHost();
    }

    protected final ReactInstanceManager getReactInstanceManager() {
        return this.mDelegate.getReactInstanceManager();
    }

    protected final void loadApp(String str) {
        this.mDelegate.loadApp(str);
    }

    private static void a(int i, char[] cArr, byte b, Object[] objArr) throws Throwable {
        int i2;
        int i3 = 2;
        int i4 = 2 % 2;
        extraCallback extracallback = new extraCallback();
        char[] cArr2 = ArtificialStackFrames;
        long j = 0;
        int i5 = -1819279892;
        Object obj = null;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            int i6 = 0;
            while (i6 < length) {
                int i7 = $10 + 123;
                $11 = i7 % 128;
                if (i7 % i3 == 0) {
                    try {
                        Object[] objArr2 = {Integer.valueOf(cArr2[i6])};
                        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(i5);
                        if (objAccessartificialFrame == null) {
                            byte b2 = (byte) 0;
                            byte b3 = b2;
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(15 - (ExpandableListView.getPackedPositionForGroup(0) > j ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == j ? 0 : -1)), (char) ((ViewConfiguration.getLongPressTimeout() >> 16) + 20488), 2147 - TextUtils.lastIndexOf("", '0'), 216710116, false, $$i(b2, b3, b3), new Class[]{Integer.TYPE});
                        }
                        cArr3[i6] = ((Character) ((Method) objAccessartificialFrame).invoke(obj, objArr2)).charValue();
                        i6 >>= 1;
                        i3 = 2;
                        j = 0;
                        i5 = -1819279892;
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                } else {
                    Object[] objArr3 = {Integer.valueOf(cArr2[i6])};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1819279892);
                    if (objAccessartificialFrame2 == null) {
                        byte b4 = (byte) 0;
                        byte b5 = b4;
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation((CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 15, (char) (20488 - View.MeasureSpec.getMode(0)), 2148 - TextUtils.indexOf("", "", 0), 216710116, false, $$i(b4, b5, b5), new Class[]{Integer.TYPE});
                    }
                    cArr3[i6] = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
                    i6++;
                    i3 = 2;
                    j = 0;
                    i5 = -1819279892;
                    obj = null;
                }
            }
            cArr2 = cArr3;
        }
        Object[] objArr4 = {Integer.valueOf(coroutineCreation)};
        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1819279892);
        if (objAccessartificialFrame3 == null) {
            byte b6 = (byte) 0;
            byte b7 = b6;
            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(KeyEvent.keyCodeFromString("") + 15, (char) ((ViewConfiguration.getEdgeSlop() >> 16) + 20488), 2148 - View.resolveSizeAndState(0, 0, 0), 216710116, false, $$i(b6, b7, b7), new Class[]{Integer.TYPE});
        }
        char cCharValue = ((Character) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).charValue();
        char[] cArr4 = new char[i];
        if (i % 2 != 0) {
            i2 = i - 1;
            cArr4[i2] = (char) (cArr[i2] - b);
        } else {
            i2 = i;
        }
        char c = 5;
        if (i2 > 1) {
            int i8 = $10 + 99;
            $11 = i8 % 128;
            int i9 = i8 % 2;
            extracallback.a = 0;
            while (extracallback.a < i2) {
                extracallback.createBrowser = cArr[extracallback.a];
                extracallback.c = cArr[extracallback.a + 1];
                if (extracallback.createBrowser == extracallback.c) {
                    cArr4[extracallback.a] = (char) (extracallback.createBrowser - b);
                    cArr4[extracallback.a + 1] = (char) (extracallback.c - b);
                } else {
                    Object[] objArr5 = new Object[13];
                    objArr5[12] = extracallback;
                    objArr5[11] = Integer.valueOf(cCharValue);
                    objArr5[10] = extracallback;
                    objArr5[9] = extracallback;
                    objArr5[8] = Integer.valueOf(cCharValue);
                    objArr5[7] = extracallback;
                    objArr5[6] = extracallback;
                    objArr5[c] = Integer.valueOf(cCharValue);
                    objArr5[4] = extracallback;
                    objArr5[3] = extracallback;
                    objArr5[2] = Integer.valueOf(cCharValue);
                    objArr5[1] = extracallback;
                    objArr5[0] = extracallback;
                    Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1894223152);
                    if (objAccessartificialFrame4 == null) {
                        byte b8 = (byte) 0;
                        byte b9 = (byte) (b8 + 5);
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation((Process.myPid() >> 22) + 46, (char) (58859 - KeyEvent.keyCodeFromString("")), 2464 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), 276640984, false, $$i(b8, b9, (byte) (b9 - 5)), new Class[]{Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class});
                    }
                    if (((Integer) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).intValue() == extracallback.g) {
                        Object[] objArr6 = {extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, Integer.valueOf(cCharValue), extracallback};
                        Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(1361113423);
                        if (objAccessartificialFrame5 == null) {
                            byte b10 = (byte) 0;
                            objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 23, (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1), (ViewConfiguration.getJumpTapTimeout() >> 16) + 792, -834291897, false, $$i(b10, (byte) (b10 | 8), b10), new Class[]{Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Integer.TYPE, Object.class});
                        }
                        int iIntValue = ((Integer) ((Method) objAccessartificialFrame5).invoke(null, objArr6)).intValue();
                        int i10 = (extracallback.d * cCharValue) + extracallback.g;
                        cArr4[extracallback.a] = cArr2[iIntValue];
                        cArr4[extracallback.a + 1] = cArr2[i10];
                    } else if (extracallback.b == extracallback.d) {
                        extracallback.j = ((extracallback.j + cCharValue) - 1) % cCharValue;
                        extracallback.g = ((extracallback.g + cCharValue) - 1) % cCharValue;
                        int i11 = (extracallback.b * cCharValue) + extracallback.j;
                        int i12 = (extracallback.d * cCharValue) + extracallback.g;
                        cArr4[extracallback.a] = cArr2[i11];
                        cArr4[extracallback.a + 1] = cArr2[i12];
                    } else {
                        int i13 = (extracallback.b * cCharValue) + extracallback.g;
                        int i14 = (extracallback.d * cCharValue) + extracallback.j;
                        cArr4[extracallback.a] = cArr2[i13];
                        cArr4[extracallback.a + 1] = cArr2[i14];
                    }
                }
                extracallback.a += 2;
                c = 5;
            }
        }
        int i15 = $10 + 15;
        $11 = i15 % 128;
        if (i15 % 2 == 0) {
            int i16 = 5 / 4;
        }
        for (int i17 = 0; i17 < i; i17++) {
            int i18 = $10 + 19;
            $11 = i18 % 128;
            if (i18 % 2 == 0) {
                cArr4[i17] = (char) (cArr4[i17] ^ 6294);
            } else {
                cArr4[i17] = (char) (cArr4[i17] ^ 13722);
            }
        }
        objArr[0] = new String(cArr4);
    }

    /* JADX WARN: Code duplicated, block: B:159:0x13c0  */
    /* JADX WARN: Code duplicated, block: B:161:0x13c7  */
    /* JADX WARN: Code duplicated, block: B:163:0x1465  */
    /* JADX WARN: Code duplicated, block: B:169:0x1476  */
    /* JADX WARN: Code duplicated, block: B:173:0x150c  */
    /* JADX WARN: Code duplicated, block: B:175:0x1518  */
    /* JADX WARN: Code duplicated, block: B:177:0x1521  */
    /* JADX WARN: Code duplicated, block: B:182:0x1591  */
    /* JADX WARN: Code duplicated, block: B:183:0x15c9  */
    /* JADX WARN: Code duplicated, block: B:185:0x15d2  */
    /* JADX WARN: Code duplicated, block: B:190:0x1642  */
    /* JADX WARN: Code duplicated, block: B:213:0x1906  */
    /* JADX WARN: Code duplicated, block: B:216:0x1938 A[Catch: all -> 0x26a5, TryCatch #4 {all -> 0x26a5, blocks: (B:277:0x1fce, B:279:0x1fdb, B:280:0x200e, B:282:0x2018, B:284:0x2025, B:285:0x205b, B:214:0x1923, B:216:0x1938, B:217:0x1965, B:123:0x0fa4, B:125:0x0fc6, B:126:0x101d, B:89:0x0b3f, B:91:0x0b45, B:92:0x0b73, B:94:0x0b9d, B:95:0x0c30), top: B:376:0x0b3f }] */
    /* JADX WARN: Code duplicated, block: B:220:0x197c  */
    /* JADX WARN: Code duplicated, block: B:225:0x19ec  */
    /* JADX WARN: Code duplicated, block: B:261:0x1de2  */
    /* JADX WARN: Code duplicated, block: B:331:0x2529  */
    /* JADX WARN: Code duplicated, block: B:332:0x258c  */
    /* JADX WARN: Code duplicated, block: B:334:0x2597  */
    /* JADX WARN: Code duplicated, block: B:337:0x259b A[LOOP:0: B:335:0x2598->B:337:0x259b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:54:0x070d  */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onStart() throws Throwable {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        int i;
        Object[] objArr4;
        Context baseContext;
        Object[] objArr5;
        int i2;
        Object objAccessartificialFrame;
        Long lValueOf;
        Object objAccessartificialFrame2;
        int absoluteGravity;
        char cAxisFromString;
        int mode;
        int i3;
        boolean z;
        Object obj;
        Object objAccessartificialFrame3;
        Object objAccessartificialFrame4;
        Object[] objArrAccessartificialFrame$78cbbd35;
        Object objAccessartificialFrame5;
        Object objAccessartificialFrame6;
        int i4;
        Object[] objArr6;
        int i5;
        Object[] objArr7;
        char c;
        int i6;
        int i7;
        ArrayList arrayList;
        String[] strArr;
        int i8;
        int i9 = 2 % 2;
        int i10 = getARTIFICIAL_FRAME_PACKAGE_NAME + 93;
        artificialFrame = i10 % 128;
        int i11 = i10 % 2;
        Object[] objArr8 = new Object[1];
        a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 13, new char[]{5, CoreConstants.LEFT_PARENTHESIS_CHAR, 1, 2, '\n', 21, 1, 0, '\t', '#', CharUtils.CR, 20, '#', Typography.amp, 20, 25, '#', 18, 28, 11, 4, ' '}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + b.l), objArr8);
        String str = (String) objArr8[0];
        Object[] objArr9 = new Object[1];
        a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 11, new char[]{25, '\"', '*', '!', CoreConstants.RIGHT_PARENTHESIS_CHAR, 23, 1, 7, 26, '0', CoreConstants.SINGLE_QUOTE_CHAR, 25, 25, Typography.amp, 13826}, (byte) (4 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))), objArr9);
        String str2 = (String) objArr9[0];
        Object[] objArr10 = new Object[1];
        a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 19, new char[]{'\f', CoreConstants.DASH_CHAR, '!', CoreConstants.COMMA_CHAR, 4, '\"', 5, CoreConstants.LEFT_PARENTHESIS_CHAR, CoreConstants.RIGHT_PARENTHESIS_CHAR, 1, 20, '0', CoreConstants.SINGLE_QUOTE_CHAR, 16, 25, CoreConstants.RIGHT_PARENTHESIS_CHAR}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 18), objArr10);
        String str3 = (String) objArr10[0];
        Object[] objArr11 = new Object[1];
        a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 19, new char[]{21, 3, 26, '\"', 17, 25, 20, CoreConstants.SINGLE_QUOTE_CHAR, 19, 5, Typography.amp, '$', 21, 14, 6, 21}, (byte) (165 - AndroidCharacter.getMirror('0')), objArr11);
        String str4 = (String) objArr11[0];
        Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(1056123296);
        if (objAccessartificialFrame7 == null) {
            int jumpTapTimeout = (ViewConfiguration.getJumpTapTimeout() >> 16) + 30;
            char c2 = (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 49361);
            int scrollBarFadeDuration = 684 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
            byte[] bArr = $$a;
            Object[] objArr12 = new Object[1];
            b((byte) (bArr[44] - 1), (byte) (-bArr[14]), (byte) ($$b & 54), objArr12);
            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(jumpTapTimeout, c2, scrollBarFadeDuration, -1583976536, false, (String) objArr12[0], null);
        }
        long j = ((Field) objAccessartificialFrame7).getLong(null);
        if (j == -1 || j + 1869 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            try {
                Object[] objArr13 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 608488975};
                byte[] bArr2 = $$g;
                byte b = bArr2[715];
                short s = bArr2[30];
                Object[] objArr14 = new Object[1];
                c(b, s, (byte) (s | 54), objArr14);
                Class<?> cls = Class.forName((String) objArr14[0]);
                Object[] objArr15 = new Object[1];
                c(bArr2[715], (short) ($$h + 5), bArr2[233], objArr15);
                Object[] objArr16 = (Object[]) cls.getMethod((String) objArr15[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr13);
                Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(910856866);
                if (objAccessartificialFrame8 == null) {
                    int iNormalizeMetaState = 30 - KeyEvent.normalizeMetaState(0);
                    char absoluteGravity2 = (char) (49362 - Gravity.getAbsoluteGravity(0, 0));
                    int deadChar = KeyEvent.getDeadChar(0, 0) + 684;
                    byte[] bArr3 = $$a;
                    Object[] objArr17 = new Object[1];
                    b(bArr3[57], bArr3[44], (byte) ($$b & 56), objArr17);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(iNormalizeMetaState, absoluteGravity2, deadChar, -1456483158, false, (String) objArr17[0], null);
                }
                ((Field) objAccessartificialFrame8).set(null, objArr16);
                try {
                    Long lValueOf2 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(1056123296);
                    if (objAccessartificialFrame9 == null) {
                        int iLastIndexOf = TextUtils.lastIndexOf("", '0', 0, 0) + 31;
                        char size = (char) (49362 - View.MeasureSpec.getSize(0));
                        int iIndexOf = 683 - TextUtils.indexOf((CharSequence) "", '0', 0);
                        byte[] bArr4 = $$a;
                        Object[] objArr18 = new Object[1];
                        b((byte) (bArr4[44] - 1), (byte) (-bArr4[14]), (byte) ($$b & 54), objArr18);
                        objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(iLastIndexOf, size, iIndexOf, -1583976536, false, (String) objArr18[0], null);
                    }
                    ((Field) objAccessartificialFrame9).set(null, lValueOf2);
                    objArr = objArr16;
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
            Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(910856866);
            if (objAccessartificialFrame10 == null) {
                int i12 = (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 30;
                char cRed = (char) (49362 - Color.red(0));
                int iRed = 684 - Color.red(0);
                byte[] bArr5 = $$a;
                Object[] objArr19 = new Object[1];
                b(bArr5[57], bArr5[44], (byte) ($$b & 56), objArr19);
                objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(i12, cRed, iRed, -1456483158, false, (String) objArr19[0], null);
            }
            Object[] objArr20 = (Object[]) ((Field) objAccessartificialFrame10).get(null);
            objArr = new Object[]{new int[]{((int[]) objArr20[0])[0]}, new int[]{((int[]) objArr20[1])[0]}, new int[1], (String) objArr20[3]};
            int i13 = ~((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().mcc;
            int i14 = 1902935726 + (((-17449109) | i13) * SyslogConstants.LOG_LOCAL7) + (((~(i13 | 917876553)) | (-892027549)) * SyslogConstants.LOG_LOCAL7) + 608488975;
            int i15 = (i14 << 13) ^ i14;
            int i16 = i15 ^ (i15 >>> 17);
            ((int[]) objArr[2])[0] = i16 ^ (i16 << 5);
        }
        int i17 = ((int[]) objArr[1])[0];
        int i18 = ((int[]) objArr[0])[0];
        if (i18 == i17) {
            int i19 = ((int[]) objArr[2])[0];
            Object[] objArr21 = {new int[]{((int[]) objArr[0])[0]}, new int[]{((int[]) objArr[1])[0]}, new int[1], (String) objArr[3]};
            int iIdentityHashCode = System.identityHashCode(this);
            int i20 = i19 + (-812496702) + (((~(624818956 | iIdentityHashCode)) | 268566546) * (-140)) + ((~(893385502 | iIdentityHashCode)) * 70) + (((~(iIdentityHashCode | 353804818)) | 808147230) * 70);
            int i21 = (i20 << 13) ^ i20;
            int i22 = i21 ^ (i21 >>> 17);
            ((int[]) objArr21[2])[0] = i22 ^ (i22 << 5);
        } else {
            new ArrayList().add((String) objArr[3]);
            try {
                Object[] objArr22 = {Long.valueOf(((long) (i17 ^ i18)) ^ (((long) 1450147168) << 32)), Long.valueOf(1450147184)};
                byte[] bArr6 = $$g;
                Object[] objArr23 = new Object[1];
                c(bArr6[715], (short) (-bArr6[88]), bArr6[103], objArr23);
                Class<?> cls2 = Class.forName((String) objArr23[0]);
                Object[] objArr24 = new Object[1];
                c((byte) (-bArr6[2]), (short) 138, bArr6[30], objArr24);
                cls2.getMethod((String) objArr24[0], Long.TYPE, Long.TYPE).invoke(null, objArr22);
                int i23 = ((int[]) objArr[2])[0];
                Object[] objArr25 = {new int[]{((int[]) objArr[0])[0]}, new int[]{((int[]) objArr[1])[0]}, new int[1], (String) objArr[3]};
                int iCodePointAt = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 1729988547;
                int i24 = ~iCodePointAt;
                int i25 = i23 + ((((~(1055899519 | i24)) | (~((-758018) | iCodePointAt))) * 988) - 1480193086) + (((~(iCodePointAt | 76517727)) | 979381792 | (~(i24 | (-758018)))) * 988);
                int i26 = (i25 << 13) ^ i25;
                int i27 = i26 ^ (i26 >>> 17);
                ((int[]) objArr25[2])[0] = i27 ^ (i27 << 5);
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        Object objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(-2127922582);
        if (objAccessartificialFrame11 == null) {
            int pressedStateDuration = 30 - (ViewConfiguration.getPressedStateDuration() >> 16);
            char jumpTapTimeout2 = (char) (49362 - (ViewConfiguration.getJumpTapTimeout() >> 16));
            int i28 = 684 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
            byte[] bArr7 = $$a;
            byte b2 = (byte) (-bArr7[18]);
            byte b3 = (byte) (-bArr7[14]);
            Object[] objArr26 = new Object[1];
            b(b2, b3, (byte) (b3 | 40), objArr26);
            objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(pressedStateDuration, jumpTapTimeout2, i28, 508509282, false, (String) objArr26[0], null);
        }
        long j2 = ((Field) objAccessartificialFrame11).getLong(null);
        if (j2 == -1 || j2 + 1897 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext2 = getBaseContext();
            if (baseContext2 == null) {
                Object[] objArr27 = new Object[1];
                a(26 - View.getDefaultSize(0, 0), new char[]{5, CoreConstants.LEFT_PARENTHESIS_CHAR, 1, 2, '\n', 21, 1, 0, '*', '!', '\"', 0, CoreConstants.SINGLE_QUOTE_CHAR, CoreConstants.DASH_CHAR, 17, 25, 31, 23, 20, CoreConstants.SINGLE_QUOTE_CHAR, 0, CoreConstants.SINGLE_QUOTE_CHAR, 6, 22, '*', 5}, (byte) ((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 44), objArr27);
                Class<?> cls3 = Class.forName((String) objArr27[0]);
                Object[] objArr28 = new Object[1];
                a(Color.argb(0, 0, 0, 0) + 18, new char[]{'0', ' ', 13802, 13802, 26, '\"', 17, CoreConstants.SINGLE_QUOTE_CHAR, 13804, 13804, 31, 25, '/', '0', 17, 25, '\f', 28}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(5) - 106), objArr28);
                baseContext2 = (Context) cls3.getMethod((String) objArr28[0], new Class[0]).invoke(null, null);
            }
            if (baseContext2 != null) {
                int i29 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                int i30 = i29 + 125;
                artificialFrame = i30 % 128;
                if (i30 % 2 == 0) {
                    boolean z2 = baseContext2 instanceof ContextWrapper;
                    throw null;
                }
                if (baseContext2 instanceof ContextWrapper) {
                    int i31 = i29 + 91;
                    artificialFrame = i31 % 128;
                    int i32 = i31 % 2;
                    if (((ContextWrapper) baseContext2).getBaseContext() != null) {
                        baseContext2 = baseContext2.getApplicationContext();
                    } else {
                        baseContext2 = null;
                    }
                } else {
                    baseContext2 = baseContext2.getApplicationContext();
                }
            }
            Object[] objArr29 = {baseContext2, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 1234670485};
            byte[] bArr8 = $$g;
            byte b4 = bArr8[715];
            Object[] objArr30 = new Object[1];
            c(b4, (short) (b4 | 128), (byte) (bArr8[308] + 1), objArr30);
            Class<?> cls4 = Class.forName((String) objArr30[0]);
            Object[] objArr31 = new Object[1];
            c(bArr8[233], (short) 224, (byte) (-bArr8[231]), objArr31);
            objArr2 = (Object[]) cls4.getMethod((String) objArr31[0], Context.class, Integer.TYPE, Integer.TYPE).invoke(null, objArr29);
            if (baseContext2 != null) {
                Object objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(777251007);
                if (objAccessartificialFrame12 == null) {
                    int iArgb = 30 - Color.argb(0, 0, 0, 0);
                    char cIndexOf = (char) (49361 - TextUtils.indexOf((CharSequence) "", '0', 0, 0));
                    int iLastIndexOf2 = 683 - TextUtils.lastIndexOf("", '0', 0, 0);
                    byte[] bArr9 = $$a;
                    Object[] objArr32 = new Object[1];
                    b(bArr9[10], (byte) (bArr9[44] - 1), (byte) (-bArr9[54]), objArr32);
                    objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(iArgb, cIndexOf, iLastIndexOf2, -1321816393, false, (String) objArr32[0], null);
                }
                ((Field) objAccessartificialFrame12).set(null, objArr2);
                try {
                    Long lValueOf3 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(-2127922582);
                    if (objAccessartificialFrame13 == null) {
                        int offsetAfter = 30 - TextUtils.getOffsetAfter("", 0);
                        char c3 = (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 49361);
                        int edgeSlop = (ViewConfiguration.getEdgeSlop() >> 16) + 684;
                        byte[] bArr10 = $$a;
                        byte b5 = (byte) (-bArr10[18]);
                        byte b6 = (byte) (-bArr10[14]);
                        Object[] objArr33 = new Object[1];
                        b(b5, b6, (byte) (b6 | 40), objArr33);
                        objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(offsetAfter, c3, edgeSlop, 508509282, false, (String) objArr33[0], null);
                    }
                    ((Field) objAccessartificialFrame13).set(null, lValueOf3);
                } catch (Exception unused2) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(777251007);
            if (objAccessartificialFrame14 == null) {
                int i33 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 30;
                char cIndexOf2 = (char) (49361 - TextUtils.indexOf((CharSequence) "", '0'));
                int edgeSlop2 = (ViewConfiguration.getEdgeSlop() >> 16) + 684;
                byte[] bArr11 = $$a;
                Object[] objArr34 = new Object[1];
                b(bArr11[10], (byte) (bArr11[44] - 1), (byte) (-bArr11[54]), objArr34);
                objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(i33, cIndexOf2, edgeSlop2, -1321816393, false, (String) objArr34[0], null);
            }
            Object[] objArr35 = (Object[]) ((Field) objAccessartificialFrame14).get(null);
            objArr2 = new Object[]{new int[]{((int[]) objArr35[0])[0]}, new int[]{((int[]) objArr35[1])[0]}, new int[1], (String) objArr35[3]};
            int iIdentityHashCode2 = System.identityHashCode(this);
            int i34 = ((((~((-101416634) | iIdentityHashCode2)) | 843210972) * 398) - 1379755584) + (((~((~iIdentityHashCode2) | (-101416634))) | 843210972) * 398) + 1234670485;
            int i35 = (i34 << 13) ^ i34;
            int i36 = i35 ^ (i35 >>> 17);
            ((int[]) objArr2[2])[0] = i36 ^ (i36 << 5);
        }
        int i37 = ((int[]) objArr2[1])[0];
        int i38 = ((int[]) objArr2[0])[0];
        if (i38 == i37) {
            int i39 = artificialFrame + 81;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i39 % 128;
            int i40 = i39 % 2;
            int i41 = ((int[]) objArr2[2])[0];
            Object[] objArr36 = {new int[]{((int[]) objArr2[0])[0]}, new int[]{((int[]) objArr2[1])[0]}, new int[1], (String) objArr2[3]};
            int i42 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().mnc;
            int i43 = i41 + (((~((-522069100) | i42)) | 69754072) * 398) + 812513044 + (((~((~i42) | (-522069100))) | 69754072) * 398);
            int i44 = (i43 << 13) ^ i43;
            int i45 = i44 ^ (i44 >>> 17);
            ((int[]) objArr36[2])[0] = i45 ^ (i45 << 5);
        } else {
            Object[] objArr37 = {Long.valueOf(((long) (i37 ^ i38)) ^ (((long) 2114415141) << 32)), Long.valueOf(2114414629)};
            byte[] bArr12 = $$g;
            Object[] objArr38 = new Object[1];
            c(bArr12[715], (short) 244, (byte) (-bArr12[448]), objArr38);
            Class<?> cls5 = Class.forName((String) objArr38[0]);
            Object[] objArr39 = new Object[1];
            c((byte) (-bArr12[2]), (short) 138, bArr12[30], objArr39);
            cls5.getMethod((String) objArr39[0], Long.TYPE, Long.TYPE).invoke(null, objArr37);
            int i46 = ((int[]) objArr2[2])[0];
            Object[] objArr40 = {new int[]{((int[]) objArr2[0])[0]}, new int[]{((int[]) objArr2[1])[0]}, new int[1], (String) objArr2[3]};
            int i47 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 1332433392;
            int i48 = i46 + (-1639129168) + (((~((-946508458) | i47)) | 6947361) * 345) + (((~((-946508458) | (~i47))) | 25167956) * 345) + ((~(i47 | (-6947362))) * 345);
            int i49 = (i48 << 13) ^ i48;
            int i50 = i49 ^ (i49 >>> 17);
            ((int[]) objArr40[2])[0] = i50 ^ (i50 << 5);
        }
        Object objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(-1168947751);
        if (objAccessartificialFrame15 == null) {
            int keyRepeatDelay = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 36;
            char touchSlop = (char) (ViewConfiguration.getTouchSlop() >> 8);
            int iMyPid = 540 - (Process.myPid() >> 22);
            byte[] bArr13 = $$a;
            byte b7 = (byte) (-bArr13[54]);
            byte b8 = bArr13[44];
            Object[] objArr41 = new Object[1];
            b(b7, b8, (byte) (b8 | 46), objArr41);
            objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay, touchSlop, iMyPid, 624296913, false, (String) objArr41[0], null);
        }
        long j3 = ((Field) objAccessartificialFrame15).getLong(null);
        if (j3 == -1 || j3 + 1890 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            try {
                Object objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(-1717965552);
                if (objAccessartificialFrame16 == null) {
                    objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(20 - Color.red(0), (char) (39515 - ExpandableListView.getPackedPositionChild(0L)), 982 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), 117222168, false, null, new Class[0]);
                }
                Object[] objArr42 = {null, ((Constructor) objAccessartificialFrame16).newInstance(null), -1198434662, 0};
                Object objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(-501205803);
                if (objAccessartificialFrame17 == null) {
                    int i51 = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 36;
                    char longPressTimeout = (char) (ViewConfiguration.getLongPressTimeout() >> 16);
                    int packedPositionChild = 539 - ExpandableListView.getPackedPositionChild(0L);
                    byte[] bArr14 = $$a;
                    Object[] objArr43 = new Object[1];
                    b((byte) 55, bArr14[22], (byte) (bArr14[44] - 1), objArr43);
                    objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(i51, longPressTimeout, packedPositionChild, 2101703389, false, (String) objArr43[0], new Class[]{(Class) ArtificialStackFrames.coroutineCreation(53 - TextUtils.indexOf((CharSequence) "", '0'), (char) ((ViewConfiguration.getDoubleTapTimeout() >> 16) + 833), 576 - (Process.myTid() >> 22)), (Class) ArtificialStackFrames.coroutineCreation(54 - TextUtils.indexOf("", "", 0), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0)), Color.red(0) + 630), Integer.TYPE, Integer.TYPE});
                }
                objArr3 = (Object[]) ((Method) objAccessartificialFrame17).invoke(null, objArr42);
                Object objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(-1339222025);
                if (objAccessartificialFrame18 == null) {
                    int tapTimeout = (ViewConfiguration.getTapTimeout() >> 16) + 36;
                    char bitsPerPixel = (char) ((-1) - ImageFormat.getBitsPerPixel(0));
                    int capsMode = TextUtils.getCapsMode("", 0, 0) + 540;
                    byte b9 = (byte) ($$b & 63);
                    byte b10 = $$a[44];
                    Object[] objArr44 = new Object[1];
                    b(b9, b10, (byte) (b10 | 46), objArr44);
                    objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(tapTimeout, bitsPerPixel, capsMode, 793268735, false, (String) objArr44[0], null);
                }
                ((Field) objAccessartificialFrame18).set(null, objArr3);
                try {
                    Long lValueOf4 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame19 = ArtificialStackFrames.accessartificialFrame(-1168947751);
                    if (objAccessartificialFrame19 == null) {
                        int i52 = 37 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                        char c4 = (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1);
                        int iBlue = Color.blue(0) + 540;
                        byte[] bArr15 = $$a;
                        byte b11 = (byte) (-bArr15[54]);
                        byte b12 = bArr15[44];
                        Object[] objArr45 = new Object[1];
                        b(b11, b12, (byte) (b12 | 46), objArr45);
                        objAccessartificialFrame19 = ArtificialStackFrames.coroutineCreation(i52, c4, iBlue, 624296913, false, (String) objArr45[0], null);
                    }
                    ((Field) objAccessartificialFrame19).set(null, lValueOf4);
                } catch (Exception unused3) {
                    throw new RuntimeException();
                }
            } catch (Throwable th3) {
                Throwable cause3 = th3.getCause();
                if (cause3 == null) {
                    throw th3;
                }
                throw cause3;
            }
        } else {
            Object objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(-1339222025);
            if (objAccessartificialFrame20 == null) {
                int packedPositionGroup = 36 - ExpandableListView.getPackedPositionGroup(0L);
                char windowTouchSlop = (char) (ViewConfiguration.getWindowTouchSlop() >> 8);
                int iAlpha = Color.alpha(0) + 540;
                byte b13 = (byte) ($$b & 63);
                byte b14 = $$a[44];
                Object[] objArr46 = new Object[1];
                b(b13, b14, (byte) (b14 | 46), objArr46);
                objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation(packedPositionGroup, windowTouchSlop, iAlpha, 793268735, false, (String) objArr46[0], null);
            }
            Object[] objArr47 = (Object[]) ((Field) objAccessartificialFrame20).get(null);
            objArr3 = new Object[]{new int[1], new int[1], new int[1]};
            int i53 = ((int[]) objArr47[2])[0];
            int i54 = ((int[]) objArr47[1])[0];
            ((int[]) objArr3[2])[0] = i53;
            ((int[]) objArr3[1])[0] = i54;
            int i55 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().uiMode;
            int i56 = ~i55;
            int i57 = ((((-751893166) + (((~((-674717328) | i55)) | (~((-676904423) | i56))) * JfifUtil.MARKER_EOI)) + (((~(i55 | (-676904423))) | 672144518) * JfifUtil.MARKER_EOI)) + (((~((-674717328) | i56)) | 676904422) * JfifUtil.MARKER_EOI)) - 1198434662;
            int i58 = (i57 << 13) ^ i57;
            int i59 = i58 ^ (i58 >>> 17);
            ((int[]) objArr3[0])[0] = i59 ^ (i59 << 5);
        }
        Object obj2 = objArr3[1];
        int i60 = ((int[]) obj2)[0];
        Object obj3 = objArr3[2];
        int i61 = ((int[]) obj3)[0];
        if (i61 == i60) {
            Object[] objArr48 = {new int[1], new int[1], new int[1]};
            int i62 = ((int[]) objArr3[0])[0];
            int i63 = ((int[]) obj3)[0];
            int i64 = ((int[]) obj2)[0];
            ((int[]) objArr48[2])[0] = i63;
            ((int[]) objArr48[1])[0] = i64;
            int i65 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getDisplayMetrics().heightPixels;
            int i66 = ~i65;
            int i67 = i62 + 215513361 + (((~((-320697341) | i66)) | (-1030924410) | (~(320697340 | i65))) * (-564)) + ((~(i65 | (-744654850))) * 1128) + (((~((-1030924410) | i66)) | (-1065352190)) * 564);
            int i68 = (i67 << 13) ^ i67;
            int i69 = i68 ^ (i68 >>> 17);
            ((int[]) objArr48[0])[0] = i69 ^ (i69 << 5);
            i = 0;
        } else {
            long j4 = ((long) (i60 ^ i61)) ^ (((long) (-22053520)) << 32);
            long j5 = -22057616;
            int i70 = artificialFrame + 87;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i70 % 128;
            int i71 = i70 % 2;
            Object[] objArr49 = {Long.valueOf(j4), Long.valueOf(j5)};
            byte[] bArr16 = $$g;
            Object[] objArr50 = new Object[1];
            c(bArr16[715], (short) (-bArr16[88]), bArr16[103], objArr50);
            Class<?> cls6 = Class.forName((String) objArr50[0]);
            Object[] objArr51 = new Object[1];
            c((byte) (-bArr16[2]), (short) 138, bArr16[30], objArr51);
            cls6.getMethod((String) objArr51[0], Long.TYPE, Long.TYPE).invoke(null, objArr49);
            Object[] objArr52 = {new int[1], new int[1], new int[1]};
            int i72 = ((int[]) objArr3[0])[0];
            int i73 = ((int[]) objArr3[2])[0];
            int i74 = ((int[]) objArr3[1])[0];
            ((int[]) objArr52[2])[0] = i73;
            ((int[]) objArr52[1])[0] = i74;
            int i75 = ~((int) Process.getStartUptimeMillis());
            int i76 = i72 + (-727821643) + (((~(i75 | 227757192)) | (-1342164974)) * (-160)) + (((~(i75 | (-1123864558))) | 227757192) * SyslogConstants.LOG_LOCAL4);
            int i77 = (i76 << 13) ^ i76;
            int i78 = i77 ^ (i77 >>> 17);
            i = 0;
            ((int[]) objArr52[0])[0] = i78 ^ (i78 << 5);
        }
        Object objAccessartificialFrame21 = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame21 == null) {
            int offsetAfter2 = 25 - TextUtils.getOffsetAfter("", i);
            char longPressTimeout2 = (char) ((ViewConfiguration.getLongPressTimeout() >> 16) + 30068);
            int gidForName = Process.getGidForName("") + 817;
            byte[] bArr17 = $$a;
            byte b15 = (byte) (-bArr17[54]);
            byte b16 = bArr17[44];
            Object[] objArr53 = new Object[1];
            b(b15, b16, (byte) (b16 | 46), objArr53);
            objAccessartificialFrame21 = ArtificialStackFrames.coroutineCreation(offsetAfter2, longPressTimeout2, gidForName, 721586079, false, (String) objArr53[0], null);
        }
        long j6 = ((Field) objAccessartificialFrame21).getLong(null);
        if (j6 == -1 || j6 + 1975 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object[] objArr54 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 1932442110};
            Object objAccessartificialFrame22 = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame22 == null) {
                int i79 = 26 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                char c5 = (char) ((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 30068);
                int iResolveSize = View.resolveSize(0, 0) + 816;
                byte b17 = (byte) ($$b & 347);
                byte[] bArr18 = $$a;
                Object[] objArr55 = new Object[1];
                b(b17, bArr18[40], bArr18[8], objArr55);
                objAccessartificialFrame22 = ArtificialStackFrames.coroutineCreation(i79, c5, iResolveSize, -797394565, false, (String) objArr55[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr4 = (Object[]) ((Method) objAccessartificialFrame22).invoke(null, objArr54);
            Object objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame23 == null) {
                int scrollDefaultDelay = (ViewConfiguration.getScrollDefaultDelay() >> 16) + 25;
                char maximumFlingVelocity = (char) (30068 - (ViewConfiguration.getMaximumFlingVelocity() >> 16));
                int iKeyCodeFromString = KeyEvent.keyCodeFromString("") + 816;
                byte b18 = (byte) ($$b & 63);
                byte b19 = $$a[44];
                Object[] objArr56 = new Object[1];
                b(b18, b19, (byte) (b19 | 46), objArr56);
                objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(scrollDefaultDelay, maximumFlingVelocity, iKeyCodeFromString, 891606461, false, (String) objArr56[0], null);
            }
            ((Field) objAccessartificialFrame23).set(null, objArr4);
            try {
                Long lValueOf5 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame24 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                if (objAccessartificialFrame24 == null) {
                    int tapTimeout2 = (ViewConfiguration.getTapTimeout() >> 16) + 25;
                    char scrollBarFadeDuration2 = (char) (30068 - (ViewConfiguration.getScrollBarFadeDuration() >> 16));
                    int absoluteGravity3 = 816 - Gravity.getAbsoluteGravity(0, 0);
                    byte[] bArr19 = $$a;
                    byte b20 = (byte) (-bArr19[54]);
                    byte b21 = bArr19[44];
                    Object[] objArr57 = new Object[1];
                    b(b20, b21, (byte) (b21 | 46), objArr57);
                    objAccessartificialFrame24 = ArtificialStackFrames.coroutineCreation(tapTimeout2, scrollBarFadeDuration2, absoluteGravity3, 721586079, false, (String) objArr57[0], null);
                }
                ((Field) objAccessartificialFrame24).set(null, lValueOf5);
            } catch (Exception unused4) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame25 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame25 == null) {
                int modifierMetaStateMask = 24 - ((byte) KeyEvent.getModifierMetaStateMask());
                char cMakeMeasureSpec = (char) (View.MeasureSpec.makeMeasureSpec(0, 0) + 30068);
                int iIndexOf2 = 816 - TextUtils.indexOf("", "");
                byte b22 = (byte) ($$b & 63);
                byte b23 = $$a[44];
                Object[] objArr58 = new Object[1];
                b(b22, b23, (byte) (b23 | 46), objArr58);
                objAccessartificialFrame25 = ArtificialStackFrames.coroutineCreation(modifierMetaStateMask, cMakeMeasureSpec, iIndexOf2, 891606461, false, (String) objArr58[0], null);
            }
            Object[] objArr59 = (Object[]) ((Field) objAccessartificialFrame25).get(null);
            objArr4 = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i80 = ((int[]) objArr59[0])[0];
            int i81 = ((int[]) objArr59[1])[0];
            String[] strArr2 = (String[]) objArr59[2];
            int iIdentityHashCode3 = System.identityHashCode(this);
            int i82 = (-1300192843) + ((200306386 | iIdentityHashCode3) * 376) + (((~((~iIdentityHashCode3) | 468432888)) | 1067010) * (-376)) + (((~(iIdentityHashCode3 | (-468432889))) | (-270260523)) * 376) + 1932442110;
            int i83 = (i82 << 13) ^ i82;
            int i84 = i83 ^ (i83 >>> 17);
            ((int[]) objArr4[3])[0] = i84 ^ (i84 << 5);
        }
        int i85 = ((int[]) objArr4[1])[0];
        int i86 = ((int[]) objArr4[0])[0];
        if (i86 == i85) {
            Object[] objArr60 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i87 = ((int[]) objArr4[3])[0];
            int i88 = ((int[]) objArr4[0])[0];
            int i89 = ((int[]) objArr4[1])[0];
            String[] strArr3 = (String[]) objArr4[2];
            int i90 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().navigationHidden;
            int i91 = ~i90;
            int i92 = i87 + 1941108025 + ((i90 | (-142614644)) * 140) + (((~((-142614644) | i91)) | 8257) * (-280)) + (((~(i90 | (-8258))) | (~(340787009 | i91)) | (-483393396)) * 140);
            int i93 = (i92 << 13) ^ i92;
            int i94 = i93 ^ (i93 >>> 17);
            ((int[]) objArr60[3])[0] = i94 ^ (i94 << 5);
        } else {
            ArrayList arrayList2 = new ArrayList();
            String[] strArr4 = (String[]) objArr4[2];
            if (strArr4 != null) {
                for (String str5 : strArr4) {
                    arrayList2.add(str5);
                }
            }
            Object[] objArr61 = {Long.valueOf(((long) (i85 ^ i86)) ^ (((long) (-1392449166)) << 32)), Long.valueOf(-1392449165)};
            byte[] bArr20 = $$g;
            byte b24 = bArr20[715];
            Object[] objArr62 = new Object[1];
            c(b24, (short) (b24 | 256), (byte) (-bArr20[181]), objArr62);
            Class<?> cls7 = Class.forName((String) objArr62[0]);
            Object[] objArr63 = new Object[1];
            c((byte) (-bArr20[2]), (short) 138, bArr20[30], objArr63);
            cls7.getMethod((String) objArr63[0], Long.TYPE, Long.TYPE).invoke(null, objArr61);
            Object[] objArr64 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i95 = ((int[]) objArr4[3])[0];
            int i96 = ((int[]) objArr4[0])[0];
            int i97 = ((int[]) objArr4[1])[0];
            String[] strArr5 = (String[]) objArr4[2];
            int iCodePointAt2 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) + 1806978092;
            int i98 = i95 + 581951913 + (((~((-194036291) | iCodePointAt2)) | 4136075) * (-366)) + (((~(iCodePointAt2 | (-192987713))) | 3087497) * 366);
            int i99 = (i98 << 13) ^ i98;
            int i100 = i99 ^ (i99 >>> 17);
            ((int[]) objArr64[3])[0] = i100 ^ (i100 << 5);
        }
        Object objAccessartificialFrame26 = ArtificialStackFrames.accessartificialFrame(-1283093189);
        if (objAccessartificialFrame26 == null) {
            int gidForName2 = 29 - Process.getGidForName("");
            char trimmedLength = (char) (49362 - TextUtils.getTrimmedLength(""));
            int keyRepeatDelay2 = 684 - (ViewConfiguration.getKeyRepeatDelay() >> 16);
            byte b25 = $$a[20];
            Object[] objArr65 = new Object[1];
            b((byte) 86, b25, (byte) (b25 | 37), objArr65);
            objAccessartificialFrame26 = ArtificialStackFrames.coroutineCreation(gidForName2, trimmedLength, keyRepeatDelay2, 752929587, false, (String) objArr65[0], null);
        }
        long j7 = ((Field) objAccessartificialFrame26).getLong(null);
        if (j7 != -1) {
            int i101 = getARTIFICIAL_FRAME_PACKAGE_NAME + 55;
            artificialFrame = i101 % 128;
            int i102 = i101 % 2;
            if (j7 + 1935 >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame27 = ArtificialStackFrames.accessartificialFrame(-326560385);
                if (objAccessartificialFrame27 == null) {
                    int i103 = 31 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                    char absoluteGravity4 = (char) (Gravity.getAbsoluteGravity(0, 0) + 49362);
                    int iAxisFromString = MotionEvent.axisFromString("") + 685;
                    int i104 = $$b;
                    Object[] objArr66 = new Object[1];
                    b((byte) (i104 & 373), $$a[20], (byte) (i104 & 54), objArr66);
                    objAccessartificialFrame27 = ArtificialStackFrames.coroutineCreation(i103, absoluteGravity4, iAxisFromString, 1944867703, false, (String) objArr66[0], null);
                }
                Object[] objArr67 = (Object[]) ((Field) objAccessartificialFrame27).get(null);
                objArr5 = new Object[]{new int[]{((int[]) objArr67[0])[0]}, new int[]{((int[]) objArr67[1])[0]}, new int[1], (String) objArr67[3]};
                int iIdentityHashCode4 = System.identityHashCode(this);
                int i105 = ~iIdentityHashCode4;
                int i106 = ((((-1689385426) + (((~(482061862 | i105)) | 16793816) * SyslogConstants.LOG_LOCAL7)) + ((iIdentityHashCode4 | 2293766) * (-184))) + ((~((-496561913) | i105)) * SyslogConstants.LOG_LOCAL7)) - 1721147777;
                int i107 = (i106 << 13) ^ i106;
                int i108 = i107 ^ (i107 >>> 17);
                ((int[]) objArr5[2])[0] = i108 ^ (i108 << 5);
            } else {
                baseContext = getBaseContext();
                if (baseContext == null) {
                    Object[] objArr68 = new Object[1];
                    a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 22, new char[]{5, CoreConstants.LEFT_PARENTHESIS_CHAR, 1, 2, '\n', 21, 1, 0, '*', '!', '\"', 0, CoreConstants.SINGLE_QUOTE_CHAR, CoreConstants.DASH_CHAR, 17, 25, 31, 23, 20, CoreConstants.SINGLE_QUOTE_CHAR, 0, CoreConstants.SINGLE_QUOTE_CHAR, 6, 22, '*', 5}, (byte) (44 - View.MeasureSpec.makeMeasureSpec(0, 0)), objArr68);
                    Class<?> cls8 = Class.forName((String) objArr68[0]);
                    Object[] objArr69 = new Object[1];
                    a((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 17, new char[]{'0', ' ', 13802, 13802, 26, '\"', 17, CoreConstants.SINGLE_QUOTE_CHAR, 13804, 13804, 31, 25, '/', '0', 17, 25, '\f', 28}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) - 47), objArr69);
                    baseContext = (Context) cls8.getMethod((String) objArr69[0], new Class[0]).invoke(null, null);
                }
                if (baseContext != null) {
                    if ((!(baseContext instanceof ContextWrapper)) && ((ContextWrapper) baseContext).getBaseContext() == null) {
                        baseContext = null;
                    } else {
                        baseContext = baseContext.getApplicationContext();
                    }
                }
                Object[] objArr70 = {baseContext, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, -1721147777};
                byte[] bArr21 = $$g;
                Object[] objArr71 = new Object[1];
                c(bArr21[715], (short) 306, bArr21[39], objArr71);
                Class<?> cls9 = Class.forName((String) objArr71[0]);
                Object[] objArr72 = new Object[1];
                c(bArr21[715], (short) 358, bArr21[233], objArr72);
                objArr5 = (Object[]) cls9.getMethod((String) objArr72[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr70);
                if (baseContext != null) {
                    i2 = artificialFrame + 13;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i2 % 128;
                    try {
                        if (i2 % 2 != 0) {
                            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-326560385);
                            if (objAccessartificialFrame3 == null) {
                                int iResolveOpacity = Drawable.resolveOpacity(0, 0) + 30;
                                char c6 = (char) (49363 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)));
                                int iIndexOf3 = TextUtils.indexOf("", "", 0) + 684;
                                int i109 = $$b;
                                Object[] objArr73 = new Object[1];
                                b((byte) (i109 & 373), $$a[20], (byte) (i109 & 54), objArr73);
                                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(iResolveOpacity, c6, iIndexOf3, 1944867703, false, (String) objArr73[0], null);
                            }
                            ((Field) objAccessartificialFrame3).set(null, objArr5);
                            lValueOf = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[1]).invoke(null, new Object[0])).longValue());
                            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1283093189);
                            if (objAccessartificialFrame2 == null) {
                                absoluteGravity = (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 29;
                                cAxisFromString = (char) (49361 - MotionEvent.axisFromString(""));
                                mode = 684 - (ViewConfiguration.getTapTimeout() >> 16);
                                i3 = 752929587;
                                z = false;
                                byte b26 = $$a[20];
                                Object[] objArr74 = new Object[1];
                                b((byte) 86, b26, (byte) (b26 | 37), objArr74);
                                obj = objArr74[0];
                                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(absoluteGravity, cAxisFromString, mode, i3, z, (String) obj, null);
                            }
                        } else {
                            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-326560385);
                            if (objAccessartificialFrame == null) {
                                int longPressTimeout3 = 30 - (ViewConfiguration.getLongPressTimeout() >> 16);
                                char maximumDrawingCacheSize = (char) (49362 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24));
                                int trimmedLength2 = 684 - TextUtils.getTrimmedLength("");
                                int i110 = $$b;
                                Object[] objArr75 = new Object[1];
                                b((byte) (i110 & 373), $$a[20], (byte) (i110 & 54), objArr75);
                                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(longPressTimeout3, maximumDrawingCacheSize, trimmedLength2, 1944867703, false, (String) objArr75[0], null);
                            }
                            ((Field) objAccessartificialFrame).set(null, objArr5);
                            lValueOf = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1283093189);
                            if (objAccessartificialFrame2 == null) {
                                absoluteGravity = 30 - Gravity.getAbsoluteGravity(0, 0);
                                cAxisFromString = (char) ((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 49362);
                                mode = View.MeasureSpec.getMode(0) + 684;
                                i3 = 752929587;
                                z = false;
                                byte b27 = $$a[20];
                                Object[] objArr76 = new Object[1];
                                b((byte) 86, b27, (byte) (b27 | 37), objArr76);
                                obj = objArr76[0];
                                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(absoluteGravity, cAxisFromString, mode, i3, z, (String) obj, null);
                            }
                        }
                        ((Field) objAccessartificialFrame2).set(null, lValueOf);
                    } catch (Exception unused5) {
                        throw new RuntimeException();
                    }
                }
            }
        } else {
            baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr610 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 22, new char[]{5, CoreConstants.LEFT_PARENTHESIS_CHAR, 1, 2, '\n', 21, 1, 0, '*', '!', '\"', 0, CoreConstants.SINGLE_QUOTE_CHAR, CoreConstants.DASH_CHAR, 17, 25, 31, 23, 20, CoreConstants.SINGLE_QUOTE_CHAR, 0, CoreConstants.SINGLE_QUOTE_CHAR, 6, 22, '*', 5}, (byte) (44 - View.MeasureSpec.makeMeasureSpec(0, 0)), objArr610);
                Class<?> cls10 = Class.forName((String) objArr610[0]);
                Object[] objArr611 = new Object[1];
                a((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 17, new char[]{'0', ' ', 13802, 13802, 26, '\"', 17, CoreConstants.SINGLE_QUOTE_CHAR, 13804, 13804, 31, 25, '/', '0', 17, 25, '\f', 28}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) - 47), objArr611);
                baseContext = (Context) cls10.getMethod((String) objArr611[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                if (!(baseContext instanceof ContextWrapper)) {
                    baseContext = baseContext.getApplicationContext();
                } else {
                    baseContext = baseContext.getApplicationContext();
                }
            }
            Object[] objArr77 = {baseContext, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, -1721147777};
            byte[] bArr22 = $$g;
            Object[] objArr78 = new Object[1];
            c(bArr22[715], (short) 306, bArr22[39], objArr78);
            Class<?> cls11 = Class.forName((String) objArr78[0]);
            Object[] objArr79 = new Object[1];
            c(bArr22[715], (short) 358, bArr22[233], objArr79);
            objArr5 = (Object[]) cls11.getMethod((String) objArr79[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr77);
            if (baseContext != null) {
                i2 = artificialFrame + 13;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i2 % 128;
                if (i2 % 2 != 0) {
                    objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-326560385);
                    if (objAccessartificialFrame3 == null) {
                        int iResolveOpacity2 = Drawable.resolveOpacity(0, 0) + 30;
                        char c7 = (char) (49363 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)));
                        int iIndexOf4 = TextUtils.indexOf("", "", 0) + 684;
                        int i1010 = $$b;
                        Object[] objArr710 = new Object[1];
                        b((byte) (i1010 & 373), $$a[20], (byte) (i1010 & 54), objArr710);
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(iResolveOpacity2, c7, iIndexOf4, 1944867703, false, (String) objArr710[0], null);
                    }
                    ((Field) objAccessartificialFrame3).set(null, objArr5);
                    lValueOf = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[1]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1283093189);
                    if (objAccessartificialFrame2 == null) {
                        absoluteGravity = (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 29;
                        cAxisFromString = (char) (49361 - MotionEvent.axisFromString(""));
                        mode = 684 - (ViewConfiguration.getTapTimeout() >> 16);
                        i3 = 752929587;
                        z = false;
                        byte b28 = $$a[20];
                        Object[] objArr711 = new Object[1];
                        b((byte) 86, b28, (byte) (b28 | 37), objArr711);
                        obj = objArr711[0];
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(absoluteGravity, cAxisFromString, mode, i3, z, (String) obj, null);
                    }
                } else {
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-326560385);
                    if (objAccessartificialFrame == null) {
                        int longPressTimeout4 = 30 - (ViewConfiguration.getLongPressTimeout() >> 16);
                        char maximumDrawingCacheSize2 = (char) (49362 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24));
                        int trimmedLength3 = 684 - TextUtils.getTrimmedLength("");
                        int i111 = $$b;
                        Object[] objArr712 = new Object[1];
                        b((byte) (i111 & 373), $$a[20], (byte) (i111 & 54), objArr712);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(longPressTimeout4, maximumDrawingCacheSize2, trimmedLength3, 1944867703, false, (String) objArr712[0], null);
                    }
                    ((Field) objAccessartificialFrame).set(null, objArr5);
                    lValueOf = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1283093189);
                    if (objAccessartificialFrame2 == null) {
                        absoluteGravity = 30 - Gravity.getAbsoluteGravity(0, 0);
                        cAxisFromString = (char) ((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 49362);
                        mode = View.MeasureSpec.getMode(0) + 684;
                        i3 = 752929587;
                        z = false;
                        byte b29 = $$a[20];
                        Object[] objArr713 = new Object[1];
                        b((byte) 86, b29, (byte) (b29 | 37), objArr713);
                        obj = objArr713[0];
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(absoluteGravity, cAxisFromString, mode, i3, z, (String) obj, null);
                    }
                }
                ((Field) objAccessartificialFrame2).set(null, lValueOf);
            }
        }
        int i112 = ((int[]) objArr5[1])[0];
        int i113 = ((int[]) objArr5[0])[0];
        if (i113 == i112) {
            int i114 = ((int[]) objArr5[2])[0];
            Object[] objArr80 = {new int[]{((int[]) objArr5[0])[0]}, new int[]{((int[]) objArr5[1])[0]}, new int[1], (String) objArr5[3]};
            int i115 = ~System.identityHashCode(this);
            int i116 = i114 + (-31962325) + ((~((-294915) | i115)) * (-783)) + (((~(i115 | 765988860)) | (-212634915)) * 783);
            int i117 = (i116 << 13) ^ i116;
            int i118 = i117 ^ (i117 >>> 17);
            ((int[]) objArr80[2])[0] = i118 ^ (i118 << 5);
        } else {
            Object[] objArr81 = {Long.valueOf(((long) (i112 ^ i113)) ^ (((long) 2088170378) << 32)), Long.valueOf(2088170382)};
            byte[] bArr23 = $$g;
            Object[] objArr82 = new Object[1];
            c(bArr23[715], (short) (-bArr23[88]), bArr23[103], objArr82);
            Class<?> cls12 = Class.forName((String) objArr82[0]);
            Object[] objArr83 = new Object[1];
            c((byte) (-bArr23[2]), (short) 138, bArr23[30], objArr83);
            cls12.getMethod((String) objArr83[0], Long.TYPE, Long.TYPE).invoke(null, objArr81);
            int i119 = ((int[]) objArr5[2])[0];
            Object[] objArr84 = {new int[]{((int[]) objArr5[0])[0]}, new int[]{((int[]) objArr5[1])[0]}, new int[1], (String) objArr5[3]};
            int i120 = ~((int) Runtime.getRuntime().freeMemory());
            int i121 = i119 + (-1172337062) + (((-272711681) | i120) * 494) + (((~(i120 | 696954871)) | (-960709329)) * 494);
            int i122 = (i121 << 13) ^ i121;
            int i123 = i122 ^ (i122 >>> 17);
            ((int[]) objArr84[2])[0] = i123 ^ (i123 << 5);
        }
        Object objAccessartificialFrame28 = ArtificialStackFrames.accessartificialFrame(-444530678);
        if (objAccessartificialFrame28 == null) {
            int i124 = 27 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
            char c8 = (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1);
            int iAlpha2 = Color.alpha(0) + 1041;
            byte[] bArr24 = $$a;
            byte b30 = (byte) (-bArr24[54]);
            byte b31 = bArr24[44];
            Object[] objArr85 = new Object[1];
            b(b30, b31, (byte) (b31 | 46), objArr85);
            objAccessartificialFrame28 = ArtificialStackFrames.coroutineCreation(i124, c8, iAlpha2, 2061780482, false, (String) objArr85[0], null);
        }
        long j8 = ((Field) objAccessartificialFrame28).getLong(null);
        if (j8 != -1) {
            int i125 = artificialFrame + 77;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i125 % 128;
            int i126 = i125 % 2;
            if (j8 + 1851 >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame29 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame29 == null) {
                    int iIndexOf5 = 25 - TextUtils.indexOf((CharSequence) "", '0', 0);
                    char size2 = (char) View.MeasureSpec.getSize(0);
                    int packedPositionType = ExpandableListView.getPackedPositionType(0L) + 1041;
                    byte b32 = (byte) ($$b & 63);
                    byte b33 = $$a[44];
                    Object[] objArr86 = new Object[1];
                    b(b32, b33, (byte) (b33 | 46), objArr86);
                    objAccessartificialFrame29 = ArtificialStackFrames.coroutineCreation(iIndexOf5, size2, packedPositionType, 1145017376, false, (String) objArr86[0], null);
                }
                Object[] objArr87 = (Object[]) ((Field) objAccessartificialFrame29).get(null);
                objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                int i127 = ((int[]) objArr87[3])[0];
                int i128 = ((int[]) objArr87[2])[0];
                String[] strArr6 = (String[]) objArr87[0];
                int iIdentityHashCode5 = System.identityHashCode(this);
                int i129 = ((508035898 + (((~((-101187586) | (~iIdentityHashCode5))) | 23083778) * (-591))) + ((iIdentityHashCode5 | (-101187586)) * 591)) - 1848952540;
                int i130 = (i129 << 13) ^ i129;
                int i131 = i130 ^ (i130 >>> 17);
                ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i131 ^ (i131 << 5);
            } else {
                int iIntValue = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
                Object[] objArr88 = {780282457};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                if (objAccessartificialFrame4 == null) {
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(8 - View.MeasureSpec.getSize(0), (char) ((Process.myPid() >> 22) + 22251), KeyEvent.keyCodeFromString("") + 1033, 47343338, false, null, new Class[]{Integer.TYPE});
                }
                objArrAccessartificialFrame$78cbbd35 = com.facebook.core.R.string.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame4).newInstance(objArr88), -1848952540, false);
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame5 == null) {
                    int i132 = 27 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                    char c9 = (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                    int i133 = (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 1041;
                    byte b34 = (byte) ($$b & 63);
                    byte b35 = $$a[44];
                    Object[] objArr89 = new Object[1];
                    b(b34, b35, (byte) (b35 | 46), objArr89);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(i132, c9, i133, 1145017376, false, (String) objArr89[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, objArrAccessartificialFrame$78cbbd35);
                try {
                    Long lValueOf6 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-444530678);
                    if (objAccessartificialFrame6 == null) {
                        int iArgb2 = Color.argb(0, 0, 0, 0) + 26;
                        char tapTimeout3 = (char) (ViewConfiguration.getTapTimeout() >> 16);
                        int i134 = 1042 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                        byte[] bArr25 = $$a;
                        byte b36 = (byte) (-bArr25[54]);
                        byte b37 = bArr25[44];
                        Object[] objArr90 = new Object[1];
                        b(b36, b37, (byte) (b37 | 46), objArr90);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(iArgb2, tapTimeout3, i134, 2061780482, false, (String) objArr90[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, lValueOf6);
                } catch (Exception unused6) {
                    throw new RuntimeException();
                }
            }
        } else {
            int iIntValue2 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            Object[] objArr810 = {780282457};
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame4 == null) {
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(8 - View.MeasureSpec.getSize(0), (char) ((Process.myPid() >> 22) + 22251), KeyEvent.keyCodeFromString("") + 1033, 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = com.facebook.core.R.string.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame4).newInstance(objArr810), -1848952540, false);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame5 == null) {
                int i135 = 27 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                char c10 = (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                int i136 = (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 1041;
                byte b38 = (byte) ($$b & 63);
                byte b39 = $$a[44];
                Object[] objArr811 = new Object[1];
                b(b38, b39, (byte) (b39 | 46), objArr811);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(i135, c10, i136, 1145017376, false, (String) objArr811[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArrAccessartificialFrame$78cbbd35);
            Long lValueOf7 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame6 == null) {
                int iArgb3 = Color.argb(0, 0, 0, 0) + 26;
                char tapTimeout4 = (char) (ViewConfiguration.getTapTimeout() >> 16);
                int i137 = 1042 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                byte[] bArr26 = $$a;
                byte b310 = (byte) (-bArr26[54]);
                byte b311 = bArr26[44];
                Object[] objArr91 = new Object[1];
                b(b310, b311, (byte) (b311 | 46), objArr91);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(iArgb3, tapTimeout4, i137, 2061780482, false, (String) objArr91[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf7);
        }
        int i138 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        int i139 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i139 == i138) {
            Object[] objArr92 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i140 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i141 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i142 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr7 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int iMaxMemory = (int) Runtime.getRuntime().maxMemory();
            int i143 = ~iMaxMemory;
            int i144 = i140 + 1112479338 + (((~(945178297 | i143)) | (-1023299514)) * 98) + (((~(i143 | (-1023282105))) | 945178297 | (~(1023282104 | iMaxMemory))) * (-49)) + (((~(iMaxMemory | 945178297)) | 17409) * 49);
            int i145 = (i144 << 13) ^ i144;
            int i146 = i145 ^ (i145 >>> 17);
            ((int[]) objArr92[1])[0] = i146 ^ (i146 << 5);
            i4 = 0;
        } else {
            ArrayList arrayList3 = new ArrayList();
            String[] strArr8 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            if (strArr8 != null) {
                for (String str6 : strArr8) {
                    arrayList3.add(str6);
                }
            }
            Object[] objArr93 = {Long.valueOf(((long) (i138 ^ i139)) ^ (((long) (-1219371094)) << 32)), Long.valueOf(-1219371096)};
            byte[] bArr27 = $$g;
            byte b40 = bArr27[30];
            short s2 = (short) (b40 | 374);
            Object[] objArr94 = new Object[1];
            c(b40, s2, (byte) (s2 & 189), objArr94);
            Class<?> cls13 = Class.forName((String) objArr94[0]);
            Object[] objArr95 = new Object[1];
            c((byte) (-bArr27[2]), (short) 138, bArr27[30], objArr95);
            cls13.getMethod((String) objArr95[0], Long.TYPE, Long.TYPE).invoke(null, objArr93);
            Object[] objArr96 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i147 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i148 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i149 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr9 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int elapsedCpuTime = (int) Process.getElapsedCpuTime();
            int i150 = ~elapsedCpuTime;
            int i151 = i147 + 1283309896 + ((275305200 | i150) * (-757)) + ((~(468312049 | elapsedCpuTime)) * 1514) + (((~(elapsedCpuTime | (-193006850))) | (~(i150 | 197201393)) | 271110656) * 757);
            int i152 = (i151 << 13) ^ i151;
            int i153 = i152 ^ (i152 >>> 17);
            i4 = 0;
            ((int[]) objArr96[1])[0] = i153 ^ (i153 << 5);
        }
        super.onStart();
        Object objAccessartificialFrame30 = ArtificialStackFrames.accessartificialFrame(1745676544);
        if (objAccessartificialFrame30 == null) {
            int mirror = 'A' - AndroidCharacter.getMirror('0');
            char mode2 = (char) View.MeasureSpec.getMode(i4);
            int modifierMetaStateMask2 = ((byte) KeyEvent.getModifierMetaStateMask()) + 748;
            byte[] bArr28 = $$a;
            byte b41 = (byte) (-bArr28[54]);
            byte b42 = bArr28[44];
            Object[] objArr97 = new Object[1];
            b(b41, b42, (byte) (b42 | 46), objArr97);
            objAccessartificialFrame30 = ArtificialStackFrames.coroutineCreation(mirror, mode2, modifierMetaStateMask2, -144068856, false, (String) objArr97[0], null);
        }
        long j9 = ((Field) objAccessartificialFrame30).getLong(null);
        if (j9 == -1 || j9 + 1959 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext3 = getBaseContext();
            if (baseContext3 == null) {
                Object[] objArr98 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(3) - 89, new char[]{5, CoreConstants.LEFT_PARENTHESIS_CHAR, 1, 2, '\n', 21, 1, 0, '*', '!', '\"', 0, CoreConstants.SINGLE_QUOTE_CHAR, CoreConstants.DASH_CHAR, 17, 25, 31, 23, 20, CoreConstants.SINGLE_QUOTE_CHAR, 0, CoreConstants.SINGLE_QUOTE_CHAR, 6, 22, '*', 5}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 9), objArr98);
                Class<?> cls14 = Class.forName((String) objArr98[0]);
                Object[] objArr99 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 14, new char[]{'0', ' ', 13802, 13802, 26, '\"', 17, CoreConstants.SINGLE_QUOTE_CHAR, 13804, 13804, 31, 25, '/', '0', 17, 25, '\f', 28}, (byte) (2 - (ViewConfiguration.getKeyRepeatDelay() >> 16)), objArr99);
                baseContext3 = (Context) cls14.getMethod((String) objArr99[0], new Class[0]).invoke(null, null);
            }
            if (baseContext3 != null) {
                if (baseContext3 instanceof ContextWrapper) {
                    int i154 = getARTIFICIAL_FRAME_PACKAGE_NAME + 5;
                    artificialFrame = i154 % 128;
                    int i155 = i154 % 2;
                    if (((ContextWrapper) baseContext3).getBaseContext() != null) {
                        baseContext3 = baseContext3.getApplicationContext();
                    } else {
                        baseContext3 = null;
                    }
                } else {
                    baseContext3 = baseContext3.getApplicationContext();
                }
            }
            Object[] objArr100 = {baseContext3, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, -110425227};
            byte[] bArr29 = $$g;
            byte b43 = bArr29[715];
            Object[] objArr101 = new Object[1];
            c(b43, (short) (b43 | 416), (byte) (-bArr29[147]), objArr101);
            Class<?> cls15 = Class.forName((String) objArr101[0]);
            byte b44 = (byte) (bArr29[141] - 1);
            Object[] objArr102 = new Object[1];
            c(b44, (short) (b44 | 448), bArr29[112], objArr102);
            objArr6 = (Object[]) cls15.getMethod((String) objArr102[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr100);
            Object objAccessartificialFrame31 = ArtificialStackFrames.accessartificialFrame(1575402270);
            if (objAccessartificialFrame31 == null) {
                int iLastIndexOf3 = TextUtils.lastIndexOf("", '0') + 18;
                char cIndexOf3 = (char) TextUtils.indexOf("", "", 0);
                int defaultSize = View.getDefaultSize(0, 0) + 747;
                byte b45 = (byte) ($$b & 63);
                byte b46 = $$a[44];
                Object[] objArr103 = new Object[1];
                b(b45, b46, (byte) (b46 | 46), objArr103);
                objAccessartificialFrame31 = ArtificialStackFrames.coroutineCreation(iLastIndexOf3, cIndexOf3, defaultSize, -1031537386, false, (String) objArr103[0], null);
            }
            ((Field) objAccessartificialFrame31).set(null, objArr6);
            try {
                Long lValueOf8 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame32 = ArtificialStackFrames.accessartificialFrame(1745676544);
                if (objAccessartificialFrame32 == null) {
                    int i156 = (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 18;
                    char mode3 = (char) View.MeasureSpec.getMode(0);
                    int fadingEdgeLength = 747 - (ViewConfiguration.getFadingEdgeLength() >> 16);
                    byte[] bArr30 = $$a;
                    byte b47 = (byte) (-bArr30[54]);
                    byte b48 = bArr30[44];
                    Object[] objArr104 = new Object[1];
                    b(b47, b48, (byte) (b48 | 46), objArr104);
                    objAccessartificialFrame32 = ArtificialStackFrames.coroutineCreation(i156, mode3, fadingEdgeLength, -144068856, false, (String) objArr104[0], null);
                }
                ((Field) objAccessartificialFrame32).set(null, lValueOf8);
            } catch (Exception unused7) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame33 = ArtificialStackFrames.accessartificialFrame(1575402270);
            if (objAccessartificialFrame33 == null) {
                int i157 = (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 16;
                char cAxisFromString2 = (char) ((-1) - MotionEvent.axisFromString(""));
                int iAxisFromString2 = MotionEvent.axisFromString("") + 748;
                byte b49 = (byte) ($$b & 63);
                byte b50 = $$a[44];
                Object[] objArr105 = new Object[1];
                b(b49, b50, (byte) (b50 | 46), objArr105);
                objAccessartificialFrame33 = ArtificialStackFrames.coroutineCreation(i157, cAxisFromString2, iAxisFromString2, -1031537386, false, (String) objArr105[0], null);
            }
            Object[] objArr106 = (Object[]) ((Field) objAccessartificialFrame33).get(null);
            objArr6 = new Object[]{list, new int[1], list, new int[]{i}, new int[]{i}};
            int i158 = ((int[]) objArr106[3])[0];
            int i159 = ((int[]) objArr106[4])[0];
            List list = (List) objArr106[0];
            List list2 = (List) objArr106[2];
            int iCodePointAt3 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) + 1085176050;
            int i160 = ~iCodePointAt3;
            int i161 = ((((-1480396066) + ((iCodePointAt3 | 124011468) * (-859))) + (((~(iCodePointAt3 | (-69206285))) | (~(124011468 | i160))) * 859)) + (((~((-481436990) | i160)) | 412230705) * 859)) - 110425227;
            int i162 = (i161 << 13) ^ i161;
            int i163 = i162 ^ (i162 >>> 17);
            ((int[]) objArr6[1])[0] = i163 ^ (i163 << 5);
        }
        int i164 = ((int[]) objArr6[4])[0];
        int i165 = ((int[]) objArr6[3])[0];
        if (i165 == i164) {
            Object[] objArr107 = {list, new int[1], list, new int[]{i}, new int[]{i}};
            int i166 = ((int[]) objArr6[1])[0];
            int i167 = ((int[]) objArr6[3])[0];
            int i168 = ((int[]) objArr6[4])[0];
            List list3 = (List) objArr6[0];
            List list4 = (List) objArr6[2];
            int layoutDirection = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().getLayoutDirection();
            int i169 = ~layoutDirection;
            int i170 = i166 + (-2108698361) + (((~(layoutDirection | (-301098753))) | (~((-906547211) | i169))) * 333) + (((~(layoutDirection | (-906547211))) | (~(i169 | (-301098753)))) * 333);
            int i171 = (i170 << 13) ^ i170;
            int i172 = i171 ^ (i171 >>> 17);
            ((int[]) objArr107[1])[0] = i172 ^ (i172 << 5);
        } else {
            ArrayList arrayList4 = new ArrayList();
            Object[] objArr108 = {objArr6};
            Object objAccessartificialFrame34 = ArtificialStackFrames.accessartificialFrame(1804664566);
            if (objAccessartificialFrame34 == null) {
                objAccessartificialFrame34 = ArtificialStackFrames.coroutineCreation(41 - View.resolveSizeAndState(0, 0, 0), (char) (12468 - (ViewConfiguration.getMaximumFlingVelocity() >> 16)), 3643 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), -185222914, false, "coroutineCreation", new Class[]{Object[].class});
            }
            arrayList4.add(((Method) objAccessartificialFrame34).invoke(null, objArr108));
            Object[] objArr109 = {objArr6};
            Object objAccessartificialFrame35 = ArtificialStackFrames.accessartificialFrame(-1243809191);
            if (objAccessartificialFrame35 == null) {
                objAccessartificialFrame35 = ArtificialStackFrames.coroutineCreation((Process.myPid() >> 22) + 41, (char) ((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 12468), (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 3642, 716815441, false, "ArtificialStackFrames", new Class[]{Object[].class});
            }
            arrayList4.add(((Method) objAccessartificialFrame35).invoke(null, objArr109));
            Object[] objArr110 = {Long.valueOf(((long) (i164 ^ i165)) ^ (((long) (-1450584327)) << 32)), Long.valueOf(-1450584335)};
            byte[] bArr31 = $$g;
            byte b51 = bArr31[715];
            Object[] objArr111 = new Object[1];
            c(b51, (short) (b51 | 499), bArr31[20], objArr111);
            Class<?> cls16 = Class.forName((String) objArr111[0]);
            Object[] objArr112 = new Object[1];
            c((byte) (-bArr31[2]), (short) 138, bArr31[30], objArr112);
            cls16.getMethod((String) objArr112[0], Long.TYPE, Long.TYPE).invoke(null, objArr110);
            Object[] objArr113 = {list, new int[1], list, new int[]{i}, new int[]{i}};
            int i173 = ((int[]) objArr6[1])[0];
            int i174 = ((int[]) objArr6[3])[0];
            int i175 = ((int[]) objArr6[4])[0];
            List list5 = (List) objArr6[0];
            List list6 = (List) objArr6[2];
            int iIdentityHashCode6 = System.identityHashCode(this);
            int i176 = i173 + (-1030072271) + (((~((-468044254) | iIdentityHashCode6)) | 137404204) * (-366)) + (((~(iIdentityHashCode6 | (-331694290))) | 1054240) * 366);
            int i177 = (i176 << 13) ^ i176;
            int i178 = i177 ^ (i177 >>> 17);
            ((int[]) objArr113[1])[0] = i178 ^ (i178 << 5);
        }
        Object objAccessartificialFrame36 = ArtificialStackFrames.accessartificialFrame(1313006081);
        if (objAccessartificialFrame36 == null) {
            int iLastIndexOf4 = 20 - TextUtils.lastIndexOf("", '0');
            char c11 = (char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)));
            int edgeSlop3 = (ViewConfiguration.getEdgeSlop() >> 16) + 465;
            byte[] bArr32 = $$a;
            byte b52 = (byte) (-bArr32[54]);
            byte b53 = bArr32[44];
            Object[] objArr114 = new Object[1];
            b(b52, b53, (byte) (b53 | 46), objArr114);
            objAccessartificialFrame36 = ArtificialStackFrames.coroutineCreation(iLastIndexOf4, c11, edgeSlop3, -785931255, false, (String) objArr114[0], null);
        }
        long j10 = ((Field) objAccessartificialFrame36).getLong(null);
        if (j10 != -1) {
            if (j10 + 1917 >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame37 = ArtificialStackFrames.accessartificialFrame(1142731807);
                if (objAccessartificialFrame37 == null) {
                    int iIndexOf6 = TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 22;
                    char cIndexOf4 = (char) TextUtils.indexOf("", "", 0, 0);
                    int iMakeMeasureSpec = 465 - View.MeasureSpec.makeMeasureSpec(0, 0);
                    byte b54 = (byte) ($$b & 63);
                    byte b55 = $$a[44];
                    Object[] objArr115 = new Object[1];
                    b(b54, b55, (byte) (b55 | 46), objArr115);
                    objAccessartificialFrame37 = ArtificialStackFrames.coroutineCreation(iIndexOf6, cIndexOf4, iMakeMeasureSpec, -612765161, false, (String) objArr115[0], null);
                }
                Object[] objArr116 = (Object[]) ((Field) objAccessartificialFrame37).get(null);
                objArr7 = new Object[]{new int[]{i}, strArr, new int[1], new int[]{i}};
                int i179 = ((int[]) objArr116[3])[0];
                int i180 = ((int[]) objArr116[0])[0];
                String[] strArr10 = (String[]) objArr116[1];
                int i181 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().keyboard;
                int i182 = ~((-203424287) | i181);
                int i183 = ~i181;
                int i184 = ((((-1332509211) + ((i182 | (~(788125375 | i183))) * 920)) + (((~((-745050816) | i183)) | 203424286) * 920)) + (((~(i181 | 788125375)) | ((~((-203424287) | i183)) | (~((-541626530) | i181)))) * 920)) - 998707246;
                int i185 = (i184 << 13) ^ i184;
                int i186 = i185 ^ (i185 >>> 17);
                ((int[]) objArr7[2])[0] = i186 ^ (i186 << 5);
                c = 0;
            } else {
                i5 = 0;
            }
            i6 = ((int[]) objArr7[c])[c];
            i7 = ((int[]) objArr7[3])[c];
            if (i7 == i6) {
                Object[] objArr117 = new Object[4];
                int[] iArr = new int[1];
                objArr117[c] = iArr;
                objArr117[2] = new int[1];
                int[] iArr2 = new int[1];
                objArr117[3] = iArr2;
                int i187 = ((int[]) objArr7[2])[c];
                int i188 = ((int[]) objArr7[3])[c];
                int i189 = ((int[]) objArr7[c])[c];
                String[] strArr11 = (String[]) objArr7[1];
                iArr2[c] = i188;
                iArr[c] = i189;
                int iIdentityHashCode7 = System.identityHashCode(this);
                int i190 = i187 + ((((-1551194222) + (((-537139265) | iIdentityHashCode7) * (-381))) + (((~((~iIdentityHashCode7) | (-682990661))) | 452052518) * 381)) - 1508370624);
                int i191 = (i190 << 13) ^ i190;
                int i192 = i191 ^ (i191 >>> 17);
                ((int[]) objArr117[2])[0] = i192 ^ (i192 << 5);
                objArr117[1] = strArr11;
                return;
            }
            arrayList = new ArrayList();
            strArr = (String[]) objArr7[1];
            if (strArr != null) {
                for (String str7 : strArr) {
                    arrayList.add(str7);
                }
            }
            Object[] objArr118 = {Long.valueOf(((long) (i6 ^ i7)) ^ (((long) (-845964226)) << 32)), Long.valueOf(-845964162)};
            byte[] bArr33 = $$g;
            Object[] objArr119 = new Object[1];
            c(bArr33[715], (short) 630, (byte) (-bArr33[181]), objArr119);
            Class<?> cls17 = Class.forName((String) objArr119[0]);
            Object[] objArr120 = new Object[1];
            c((byte) (-bArr33[2]), (short) 138, bArr33[30], objArr120);
            cls17.getMethod((String) objArr120[0], Long.TYPE, Long.TYPE).invoke(null, objArr118);
            Object[] objArr121 = {new int[]{i}, strArr, new int[1], new int[]{i}};
            int i193 = ((int[]) objArr7[2])[0];
            int i194 = ((int[]) objArr7[3])[0];
            int i195 = ((int[]) objArr7[0])[0];
            String[] strArr12 = (String[]) objArr7[1];
            int i196 = (int) Runtime.getRuntime().totalMemory();
            int i197 = ~i196;
            int i198 = i193 + 1744607828 + (((~((-884685219) | i197)) | (~(724335492 | i197))) * (-867)) + (((~((-884685219) | i196)) | 345178146 | (~(724335492 | i196))) * (-1734)) + (((~(i196 | 1069513638)) | (~(i197 | (-345178147))) | (~((-539507073) | i196))) * 867);
            int i199 = (i198 << 13) ^ i198;
            int i200 = i199 ^ (i199 >>> 17);
            ((int[]) objArr121[2])[0] = i200 ^ (i200 << 5);
        }
        i5 = 0;
        Context baseContext4 = getBaseContext();
        if (baseContext4 == null) {
            Object[] objArr122 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i5]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(i5, 4).codePointAt(i5) - 11, new char[]{5, CoreConstants.LEFT_PARENTHESIS_CHAR, 1, 2, '\n', 21, 1, 0, '*', '!', '\"', 0, CoreConstants.SINGLE_QUOTE_CHAR, CoreConstants.DASH_CHAR, 17, 25, 31, 23, 20, CoreConstants.SINGLE_QUOTE_CHAR, 0, CoreConstants.SINGLE_QUOTE_CHAR, 6, 22, '*', 5}, (byte) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 43), objArr122);
            Class<?> cls18 = Class.forName((String) objArr122[0]);
            Object[] objArr123 = new Object[1];
            a(18 - (ViewConfiguration.getScrollBarSize() >> 8), new char[]{'0', ' ', 13802, 13802, 26, '\"', 17, CoreConstants.SINGLE_QUOTE_CHAR, 13804, 13804, 31, 25, '/', '0', 17, 25, '\f', 28}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 2), objArr123);
            baseContext4 = (Context) cls18.getMethod((String) objArr123[0], new Class[0]).invoke(null, null);
        }
        if (baseContext4 != null) {
            baseContext4 = ((baseContext4 instanceof ContextWrapper) && ((ContextWrapper) baseContext4).getBaseContext() == null) ? null : baseContext4.getApplicationContext();
        }
        int iIntValue3 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
        Object[] objArr124 = new Object[1];
        a(64 - KeyEvent.getDeadChar(0, 0), new char[]{'/', '\f', 17, '!', '0', 21, '/', 26, CoreConstants.COMMA_CHAR, 25, 19, CoreConstants.COMMA_CHAR, 4, '\t', '!', '/', 21, 6, '\t', 18, 23, 30, '!', '/', 26, 5, CoreConstants.COMMA_CHAR, 0, 5, 21, 26, CoreConstants.RIGHT_PARENTHESIS_CHAR, CoreConstants.PERCENT_CHAR, 19, 14, 2, '!', '/', 26, CoreConstants.PERCENT_CHAR, 4, CoreConstants.COMMA_CHAR, CoreConstants.PERCENT_CHAR, 19, 27, '/', CoreConstants.COMMA_CHAR, 4, '/', 5, 5, 26, 27, CoreConstants.COMMA_CHAR, '\f', '.', 4, CoreConstants.COMMA_CHAR, '0', 26, 18, '/', 7, 0}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 79), objArr124);
        String str8 = (String) objArr124[0];
        Object[] objArr125 = new Object[1];
        a(63 - TextUtils.lastIndexOf("", '0'), new char[]{17, 20, 13870, 13870, 26, CoreConstants.RIGHT_PARENTHESIS_CHAR, 6, CoreConstants.COMMA_CHAR, 2, 26, 17, 16, 7, '.', 2, 21, '.', 7, 6, 26, 5, '/', 19, CoreConstants.COMMA_CHAR, 27, CoreConstants.COMMA_CHAR, '\n', ' ', 2, 14, 17, 29, 14, CoreConstants.COMMA_CHAR, 13783, 13783, 19, CoreConstants.COMMA_CHAR, 23, 20, 24, 30, 17, 30, CoreConstants.COMMA_CHAR, 0, 17, '!', 14, '/', 5, '/', 20, 22, 13787, 13787, 19, '+', 21, '/', 5, CoreConstants.COMMA_CHAR, CoreConstants.RIGHT_PARENTHESIS_CHAR, 26}, (byte) ((ViewConfiguration.getScrollDefaultDelay() >> 16) + 47), objArr125);
        String[] strArr13 = {str8, (String) objArr125[0]};
        int i201 = getARTIFICIAL_FRAME_PACKAGE_NAME + 67;
        artificialFrame = i201 % 128;
        int i202 = i201 % 2;
        Object[] objArr126 = {baseContext4, strArr13, Integer.valueOf(iIntValue3), 1, -998707246};
        byte[] bArr34 = $$g;
        byte b56 = bArr34[715];
        short s3 = (short) (b56 | 562);
        Object[] objArr127 = new Object[1];
        c(b56, s3, (byte) (s3 & 247), objArr127);
        Class<?> cls19 = Class.forName((String) objArr127[0]);
        Object[] objArr128 = new Object[1];
        c(bArr34[233], (short) 224, (byte) (-bArr34[231]), objArr128);
        objArr7 = (Object[]) cls19.getMethod((String) objArr128[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr126);
        int i203 = ((int[]) objArr7[0])[0];
        int i204 = ((int[]) objArr7[3])[0];
        if (baseContext4 != null) {
            Object objAccessartificialFrame38 = ArtificialStackFrames.accessartificialFrame(1142731807);
            if (objAccessartificialFrame38 == null) {
                int iMyPid2 = 21 - (Process.myPid() >> 22);
                char cBlue = (char) Color.blue(0);
                int iMyPid3 = 465 - (Process.myPid() >> 22);
                byte b57 = (byte) ($$b & 63);
                byte b58 = $$a[44];
                Object[] objArr129 = new Object[1];
                b(b57, b58, (byte) (b58 | 46), objArr129);
                objAccessartificialFrame38 = ArtificialStackFrames.coroutineCreation(iMyPid2, cBlue, iMyPid3, -612765161, false, (String) objArr129[0], null);
            }
            ((Field) objAccessartificialFrame38).set(null, objArr7);
            try {
                Long lValueOf9 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame39 = ArtificialStackFrames.accessartificialFrame(1313006081);
                if (objAccessartificialFrame39 == null) {
                    int i205 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 21;
                    char cIndexOf5 = (char) (TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1);
                    int iArgb4 = Color.argb(0, 0, 0, 0) + 465;
                    byte[] bArr35 = $$a;
                    byte b59 = (byte) (-bArr35[54]);
                    byte b60 = bArr35[44];
                    Object[] objArr130 = new Object[1];
                    b(b59, b60, (byte) (b60 | 46), objArr130);
                    objAccessartificialFrame39 = ArtificialStackFrames.coroutineCreation(i205, cIndexOf5, iArgb4, -785931255, false, (String) objArr130[0], null);
                }
                ((Field) objAccessartificialFrame39).set(null, lValueOf9);
            } catch (Exception unused8) {
                throw new RuntimeException();
            }
        }
        c = 0;
        i6 = ((int[]) objArr7[c])[c];
        i7 = ((int[]) objArr7[3])[c];
        if (i7 == i6) {
            Object[] objArr1110 = new Object[4];
            int[] iArr3 = new int[1];
            objArr1110[c] = iArr3;
            objArr1110[2] = new int[1];
            int[] iArr4 = new int[1];
            objArr1110[3] = iArr4;
            int i1810 = ((int[]) objArr7[2])[c];
            int i1811 = ((int[]) objArr7[3])[c];
            int i1812 = ((int[]) objArr7[c])[c];
            String[] strArr14 = (String[]) objArr7[1];
            iArr4[c] = i1811;
            iArr3[c] = i1812;
            int iIdentityHashCode8 = System.identityHashCode(this);
            int i1910 = i1810 + ((((-1551194222) + (((-537139265) | iIdentityHashCode8) * (-381))) + (((~((~iIdentityHashCode8) | (-682990661))) | 452052518) * 381)) - 1508370624);
            int i1911 = (i1910 << 13) ^ i1910;
            int i1912 = i1911 ^ (i1911 >>> 17);
            ((int[]) objArr1110[2])[0] = i1912 ^ (i1912 << 5);
            objArr1110[1] = strArr14;
            return;
        }
        arrayList = new ArrayList();
        strArr = (String[]) objArr7[1];
        if (strArr != null) {
            while (i8 < strArr.length) {
                arrayList.add(str7);
            }
        }
        Object[] objArr1111 = {Long.valueOf(((long) (i6 ^ i7)) ^ (((long) (-845964226)) << 32)), Long.valueOf(-845964162)};
        byte[] bArr36 = $$g;
        Object[] objArr1112 = new Object[1];
        c(bArr36[715], (short) 630, (byte) (-bArr36[181]), objArr1112);
        Class<?> cls110 = Class.forName((String) objArr1112[0]);
        Object[] objArr1210 = new Object[1];
        c((byte) (-bArr36[2]), (short) 138, bArr36[30], objArr1210);
        cls110.getMethod((String) objArr1210[0], Long.TYPE, Long.TYPE).invoke(null, objArr1111);
        Object[] objArr1211 = {new int[]{i195}, strArr12, new int[1], new int[]{i194}};
        int i1913 = ((int[]) objArr7[2])[0];
        int i1914 = ((int[]) objArr7[3])[0];
        int i1915 = ((int[]) objArr7[0])[0];
        String[] strArr15 = (String[]) objArr7[1];
        int i1916 = (int) Runtime.getRuntime().totalMemory();
        int i1917 = ~i1916;
        int i1918 = i1913 + 1744607828 + (((~((-884685219) | i1917)) | (~(724335492 | i1917))) * (-867)) + (((~((-884685219) | i1916)) | 345178146 | (~(724335492 | i1916))) * (-1734)) + (((~(i1916 | 1069513638)) | (~(i1917 | (-345178147))) | (~((-539507073) | i1916))) * 867);
        int i1919 = (i1918 << 13) ^ i1918;
        int i206 = i1919 ^ (i1919 >>> 17);
        ((int[]) objArr1211[2])[0] = i206 ^ (i206 << 5);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:16:0x027e A[Catch: all -> 0x0ad1, TryCatch #0 {all -> 0x0ad1, blocks: (B:52:0x0787, B:54:0x079b, B:55:0x07ce, B:14:0x025e, B:16:0x027e, B:17:0x02ce), top: B:95:0x025e }] */
    /* JADX WARN: Code duplicated, block: B:20:0x02e0  */
    /* JADX WARN: Code duplicated, block: B:25:0x03c3  */
    /* JADX WARN: Code duplicated, block: B:51:0x0729  */
    /* JADX WARN: Code duplicated, block: B:54:0x079b A[Catch: all -> 0x0ad1, TryCatch #0 {all -> 0x0ad1, blocks: (B:52:0x0787, B:54:0x079b, B:55:0x07ce, B:14:0x025e, B:16:0x027e, B:17:0x02ce), top: B:95:0x025e }] */
    /* JADX WARN: Code duplicated, block: B:58:0x07e4  */
    /* JADX WARN: Code duplicated, block: B:63:0x08da  */
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
        int i;
        int i2 = 2 % 2;
        super.attachBaseContext(context);
        Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame7 == null) {
            int i3 = 24 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1));
            char cResolveSizeAndState = (char) (30068 - View.resolveSizeAndState(0, 0, 0));
            int maximumFlingVelocity = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 816;
            byte[] bArr = $$a;
            byte b = (byte) (-bArr[54]);
            byte b2 = bArr[44];
            Object[] objArr2 = new Object[1];
            b(b, b2, (byte) (b2 | 46), objArr2);
            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(i3, cResolveSizeAndState, maximumFlingVelocity, 721586079, false, (String) objArr2[0], null);
        }
        long j = ((Field) objAccessartificialFrame7).getLong(null);
        if (j != -1) {
            int i4 = artificialFrame + 77;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i4 % 128;
            int i5 = i4 % 2;
            long j2 = j + 1990;
            Object[] objArr3 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) - 27, new char[]{5, CoreConstants.LEFT_PARENTHESIS_CHAR, 1, 2, '\n', 21, 1, 0, '\t', '#', CharUtils.CR, 20, '#', Typography.amp, 20, 25, '#', 18, 28, 11, 4, ' '}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 89), objArr3);
            Class<?> cls = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            a(((Process.getThreadPriority(0) + 20) >> 6) + 15, new char[]{25, '\"', '*', '!', CoreConstants.RIGHT_PARENTHESIS_CHAR, 23, 1, 7, 26, '0', CoreConstants.SINGLE_QUOTE_CHAR, 25, 25, Typography.amp, 13826}, (byte) (2 - MotionEvent.axisFromString("")), objArr4);
            if (j2 >= ((Long) cls.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                int i6 = artificialFrame + 73;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i6 % 128;
                int i7 = i6 % 2;
                Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame8 == null) {
                    int i8 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 25;
                    char pressedStateDuration = (char) (30068 - (ViewConfiguration.getPressedStateDuration() >> 16));
                    int iMyTid = (Process.myTid() >> 22) + 816;
                    byte b3 = (byte) ($$b & 63);
                    byte b4 = $$a[44];
                    Object[] objArr5 = new Object[1];
                    b(b3, b4, (byte) (b4 | 46), objArr5);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(i8, pressedStateDuration, iMyTid, 891606461, false, (String) objArr5[0], null);
                }
                Object[] objArr6 = (Object[]) ((Field) objAccessartificialFrame8).get(null);
                objArr = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i9 = ((int[]) objArr6[0])[0];
                int i10 = ((int[]) objArr6[1])[0];
                String[] strArr = (String[]) objArr6[2];
                int iIdentityHashCode = System.identityHashCode(this);
                int i11 = ~iIdentityHashCode;
                int i12 = (((1825167297 + (((~((-4203011) | i11)) | 202375376) * 220)) + (((~(i11 | (-275540527))) | 473712892) * (-440))) + ((iIdentityHashCode | (-4203011)) * 220)) - 1764019256;
                int i13 = (i12 << 13) ^ i12;
                int i14 = i13 ^ (i13 >>> 17);
                ((int[]) objArr[3])[0] = i14 ^ (i14 << 5);
            } else {
                Object[] objArr7 = new Object[1];
                a((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 15, new char[]{'\f', CoreConstants.DASH_CHAR, '!', CoreConstants.COMMA_CHAR, 4, '\"', 5, CoreConstants.LEFT_PARENTHESIS_CHAR, CoreConstants.RIGHT_PARENTHESIS_CHAR, 1, 20, '0', CoreConstants.SINGLE_QUOTE_CHAR, 16, 25, CoreConstants.RIGHT_PARENTHESIS_CHAR}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 18), objArr7);
                Class<?> cls2 = Class.forName((String) objArr7[0]);
                Object[] objArr8 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 12, new char[]{21, 3, 26, '\"', 17, 25, 20, CoreConstants.SINGLE_QUOTE_CHAR, 19, 5, Typography.amp, '$', 21, 14, 6, 21}, (byte) ((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 117), objArr8);
                try {
                    Object[] objArr9 = {Integer.valueOf(((Integer) cls2.getMethod((String) objArr8[0], Object.class).invoke(null, this)).intValue()), 0, -1764019256};
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1327366003);
                    if (objAccessartificialFrame == null) {
                        int longPressTimeout = 25 - (ViewConfiguration.getLongPressTimeout() >> 16);
                        char cBlue = (char) (30068 - Color.blue(0));
                        int iLastIndexOf = 815 - TextUtils.lastIndexOf("", '0', 0);
                        byte b5 = (byte) ($$b & 347);
                        byte[] bArr2 = $$a;
                        Object[] objArr10 = new Object[1];
                        b(b5, bArr2[40], bArr2[8], objArr10);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(longPressTimeout, cBlue, iLastIndexOf, -797394565, false, (String) objArr10[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    objArr = (Object[]) ((Method) objAccessartificialFrame).invoke(null, objArr9);
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                    if (objAccessartificialFrame2 == null) {
                        int iLastIndexOf2 = 24 - TextUtils.lastIndexOf("", '0');
                        char cIndexOf = (char) (30068 - TextUtils.indexOf("", ""));
                        int packedPositionChild = ExpandableListView.getPackedPositionChild(0L) + 817;
                        byte b6 = (byte) ($$b & 63);
                        byte b7 = $$a[44];
                        Object[] objArr11 = new Object[1];
                        b(b6, b7, (byte) (b7 | 46), objArr11);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iLastIndexOf2, cIndexOf, packedPositionChild, 891606461, false, (String) objArr11[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, objArr);
                    try {
                        Object[] objArr12 = new Object[1];
                        a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 13, new char[]{5, CoreConstants.LEFT_PARENTHESIS_CHAR, 1, 2, '\n', 21, 1, 0, '\t', '#', CharUtils.CR, 20, '#', Typography.amp, 20, 25, '#', 18, 28, 11, 4, ' '}, (byte) (((byte) KeyEvent.getModifierMetaStateMask()) + 111), objArr12);
                        Class<?> cls3 = Class.forName((String) objArr12[0]);
                        Object[] objArr13 = new Object[1];
                        a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 11, new char[]{25, '\"', '*', '!', CoreConstants.RIGHT_PARENTHESIS_CHAR, 23, 1, 7, 26, '0', CoreConstants.SINGLE_QUOTE_CHAR, 25, 25, Typography.amp, 13826}, (byte) ((ViewConfiguration.getTouchSlop() >> 8) + 3), objArr13);
                        Long lValueOf = Long.valueOf(((Long) cls3.getDeclaredMethod((String) objArr13[0], new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                        if (objAccessartificialFrame3 == null) {
                            int threadPriority = ((Process.getThreadPriority(0) + 20) >> 6) + 25;
                            char cRgb = (char) (Color.rgb(0, 0, 0) + 16807284);
                            int tapTimeout = 816 - (ViewConfiguration.getTapTimeout() >> 16);
                            byte[] bArr3 = $$a;
                            byte b8 = (byte) (-bArr3[54]);
                            byte b9 = bArr3[44];
                            Object[] objArr14 = new Object[1];
                            b(b8, b9, (byte) (b9 | 46), objArr14);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(threadPriority, cRgb, tapTimeout, 721586079, false, (String) objArr14[0], null);
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
            a((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 15, new char[]{'\f', CoreConstants.DASH_CHAR, '!', CoreConstants.COMMA_CHAR, 4, '\"', 5, CoreConstants.LEFT_PARENTHESIS_CHAR, CoreConstants.RIGHT_PARENTHESIS_CHAR, 1, 20, '0', CoreConstants.SINGLE_QUOTE_CHAR, 16, 25, CoreConstants.RIGHT_PARENTHESIS_CHAR}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 18), objArr15);
            Class<?> cls4 = Class.forName((String) objArr15[0]);
            Object[] objArr16 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 12, new char[]{21, 3, 26, '\"', 17, 25, 20, CoreConstants.SINGLE_QUOTE_CHAR, 19, 5, Typography.amp, '$', 21, 14, 6, 21}, (byte) ((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 117), objArr16);
            Object[] objArr17 = {Integer.valueOf(((Integer) cls4.getMethod((String) objArr16[0], Object.class).invoke(null, this)).intValue()), 0, -1764019256};
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame == null) {
                int longPressTimeout2 = 25 - (ViewConfiguration.getLongPressTimeout() >> 16);
                char cBlue2 = (char) (30068 - Color.blue(0));
                int iLastIndexOf3 = 815 - TextUtils.lastIndexOf("", '0', 0);
                byte b10 = (byte) ($$b & 347);
                byte[] bArr4 = $$a;
                Object[] objArr18 = new Object[1];
                b(b10, bArr4[40], bArr4[8], objArr18);
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(longPressTimeout2, cBlue2, iLastIndexOf3, -797394565, false, (String) objArr18[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr = (Object[]) ((Method) objAccessartificialFrame).invoke(null, objArr17);
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame2 == null) {
                int iLastIndexOf4 = 24 - TextUtils.lastIndexOf("", '0');
                char cIndexOf2 = (char) (30068 - TextUtils.indexOf("", ""));
                int packedPositionChild2 = ExpandableListView.getPackedPositionChild(0L) + 817;
                byte b11 = (byte) ($$b & 63);
                byte b12 = $$a[44];
                Object[] objArr19 = new Object[1];
                b(b11, b12, (byte) (b12 | 46), objArr19);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iLastIndexOf4, cIndexOf2, packedPositionChild2, 891606461, false, (String) objArr19[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, objArr);
            Object[] objArr110 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 13, new char[]{5, CoreConstants.LEFT_PARENTHESIS_CHAR, 1, 2, '\n', 21, 1, 0, '\t', '#', CharUtils.CR, 20, '#', Typography.amp, 20, 25, '#', 18, 28, 11, 4, ' '}, (byte) (((byte) KeyEvent.getModifierMetaStateMask()) + 111), objArr110);
            Class<?> cls5 = Class.forName((String) objArr110[0]);
            Object[] objArr111 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 11, new char[]{25, '\"', '*', '!', CoreConstants.RIGHT_PARENTHESIS_CHAR, 23, 1, 7, 26, '0', CoreConstants.SINGLE_QUOTE_CHAR, 25, 25, Typography.amp, 13826}, (byte) ((ViewConfiguration.getTouchSlop() >> 8) + 3), objArr111);
            Long lValueOf2 = Long.valueOf(((Long) cls5.getDeclaredMethod((String) objArr111[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame3 == null) {
                int threadPriority2 = ((Process.getThreadPriority(0) + 20) >> 6) + 25;
                char cRgb2 = (char) (Color.rgb(0, 0, 0) + 16807284);
                int tapTimeout2 = 816 - (ViewConfiguration.getTapTimeout() >> 16);
                byte[] bArr5 = $$a;
                byte b13 = (byte) (-bArr5[54]);
                byte b14 = bArr5[44];
                Object[] objArr112 = new Object[1];
                b(b13, b14, (byte) (b14 | 46), objArr112);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(threadPriority2, cRgb2, tapTimeout2, 721586079, false, (String) objArr112[0], null);
            }
            ((Field) objAccessartificialFrame3).set(null, lValueOf2);
        }
        int i15 = ((int[]) objArr[1])[0];
        int i16 = ((int[]) objArr[0])[0];
        if (i16 == i15) {
            Object[] objArr20 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i17 = ((int[]) objArr[3])[0];
            int i18 = ((int[]) objArr[0])[0];
            int i19 = ((int[]) objArr[1])[0];
            String[] strArr2 = (String[]) objArr[2];
            int i20 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().screenHeightDp;
            int i21 = (-1533276917) + (((~((-354268947) | i20)) | 17666048 | (~((-156096581) | i20))) * (-754));
            int i22 = ~((-17666049) | i20);
            int i23 = ~i20;
            int i24 = i17 + i21 + ((i22 | (~((-138430533) | i23))) * (-754)) + ((i23 | (-354268947)) * 754);
            int i25 = (i24 << 13) ^ i24;
            int i26 = i25 ^ (i25 >>> 17);
            ((int[]) objArr20[3])[0] = i26 ^ (i26 << 5);
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr3 = (String[]) objArr[2];
            if (strArr3 != null) {
                for (String str : strArr3) {
                    arrayList.add(str);
                }
            }
            try {
                Object[] objArr21 = {Long.valueOf(((long) (i15 ^ i16)) ^ (((long) 1516887429) << 32)), Long.valueOf(1516887428)};
                byte[] bArr6 = $$g;
                byte b15 = bArr6[715];
                Object[] objArr22 = new Object[1];
                c(b15, (short) (b15 | 656), (byte) (-bArr6[147]), objArr22);
                Class<?> cls6 = Class.forName((String) objArr22[0]);
                Object[] objArr23 = new Object[1];
                c((byte) (-bArr6[2]), (short) 138, bArr6[30], objArr23);
                cls6.getMethod((String) objArr23[0], Long.TYPE, Long.TYPE).invoke(null, objArr21);
                Object[] objArr24 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i27 = ((int[]) objArr[3])[0];
                int i28 = ((int[]) objArr[0])[0];
                int i29 = ((int[]) objArr[1])[0];
                String[] strArr4 = (String[]) objArr[2];
                int i30 = ~Process.myPid();
                int i31 = i27 + 374458967 + ((~((-537317638) | i30)) * (-783)) + (((~(i30 | (-613872904))) | (-812045270)) * 783);
                int i32 = (i31 << 13) ^ i31;
                int i33 = i32 ^ (i32 >>> 17);
                ((int[]) objArr24[3])[0] = i33 ^ (i33 << 5);
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
            int longPressTimeout3 = (ViewConfiguration.getLongPressTimeout() >> 16) + 26;
            char cIndexOf3 = (char) (TextUtils.indexOf((CharSequence) "", '0') + 1);
            int iResolveOpacity = 1041 - Drawable.resolveOpacity(0, 0);
            byte[] bArr7 = $$a;
            byte b16 = (byte) (-bArr7[54]);
            byte b17 = bArr7[44];
            Object[] objArr25 = new Object[1];
            b(b16, b17, (byte) (b17 | 46), objArr25);
            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(longPressTimeout3, cIndexOf3, iResolveOpacity, 2061780482, false, (String) objArr25[0], null);
        }
        long j3 = ((Field) objAccessartificialFrame9).getLong(null);
        if (j3 != -1) {
            long j4 = j3 + 1892;
            Object[] objArr26 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 13, new char[]{5, CoreConstants.LEFT_PARENTHESIS_CHAR, 1, 2, '\n', 21, 1, 0, '\t', '#', CharUtils.CR, 20, '#', Typography.amp, 20, 25, '#', 18, 28, 11, 4, ' '}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) + 74), objArr26);
            Class<?> cls7 = Class.forName((String) objArr26[0]);
            Object[] objArr27 = new Object[1];
            a(15 - Color.blue(0), new char[]{25, '\"', '*', '!', CoreConstants.RIGHT_PARENTHESIS_CHAR, 23, 1, 7, 26, '0', CoreConstants.SINGLE_QUOTE_CHAR, 25, 25, Typography.amp, 13826}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(8) - 98), objArr27);
            if (j4 >= ((Long) cls7.getDeclaredMethod((String) objArr27[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame10 == null) {
                    int offsetAfter = TextUtils.getOffsetAfter("", 0) + 26;
                    char mirror = (char) ('0' - AndroidCharacter.getMirror('0'));
                    int iRgb = (-16776175) - Color.rgb(0, 0, 0);
                    byte b18 = (byte) ($$b & 63);
                    byte b19 = $$a[44];
                    Object[] objArr28 = new Object[1];
                    b(b18, b19, (byte) (b19 | 46), objArr28);
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(offsetAfter, mirror, iRgb, 1145017376, false, (String) objArr28[0], null);
                }
                Object[] objArr29 = (Object[]) ((Field) objAccessartificialFrame10).get(null);
                objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                int i34 = ((int[]) objArr29[3])[0];
                int i35 = ((int[]) objArr29[2])[0];
                String[] strArr5 = (String[]) objArr29[0];
                int iIdentityHashCode2 = System.identityHashCode(this);
                int i36 = 29961378 + (((-553881797) | iIdentityHashCode2) * (-381)) + (((~((~iIdentityHashCode2) | (-755749319))) | 481838851) * 381) + 2107675392;
                int i37 = (i36 << 13) ^ i36;
                int i38 = i37 ^ (i37 >>> 17);
                ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i38 ^ (i38 << 5);
                i = artificialFrame + 99;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i % 128;
            } else {
                Object[] objArr30 = new Object[1];
                a(15 - TextUtils.indexOf((CharSequence) "", '0'), new char[]{'\f', CoreConstants.DASH_CHAR, '!', CoreConstants.COMMA_CHAR, 4, '\"', 5, CoreConstants.LEFT_PARENTHESIS_CHAR, CoreConstants.RIGHT_PARENTHESIS_CHAR, 1, 20, '0', CoreConstants.SINGLE_QUOTE_CHAR, 16, 25, CoreConstants.RIGHT_PARENTHESIS_CHAR}, (byte) (((Process.getThreadPriority(0) + 20) >> 6) + 53), objArr30);
                Class<?> cls8 = Class.forName((String) objArr30[0]);
                Object[] objArr31 = new Object[1];
                a(16 - TextUtils.getTrimmedLength(""), new char[]{21, 3, 26, '\"', 17, 25, 20, CoreConstants.SINGLE_QUOTE_CHAR, 19, 5, Typography.amp, '$', 21, 14, 6, 21}, (byte) (118 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))), objArr31);
                int iIntValue = ((Integer) cls8.getMethod((String) objArr31[0], Object.class).invoke(null, this)).intValue();
                Object[] objArr32 = {-660517059};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                if (objAccessartificialFrame4 == null) {
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 7, (char) ((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 22251), (ViewConfiguration.getKeyRepeatDelay() >> 16) + 1033, 47343338, false, null, new Class[]{Integer.TYPE});
                }
                objArrAccessartificialFrame$78cbbd35 = CompactHashMap.Itr.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame4).newInstance(objArr32), 1532108620, false);
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame5 == null) {
                    int i39 = (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 25;
                    char threadPriority3 = (char) ((Process.getThreadPriority(0) + 20) >> 6);
                    int mirror2 = 1089 - AndroidCharacter.getMirror('0');
                    byte b20 = (byte) ($$b & 63);
                    byte b21 = $$a[44];
                    Object[] objArr33 = new Object[1];
                    b(b20, b21, (byte) (b21 | 46), objArr33);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(i39, threadPriority3, mirror2, 1145017376, false, (String) objArr33[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, objArrAccessartificialFrame$78cbbd35);
                try {
                    Object[] objArr34 = new Object[1];
                    a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 18, new char[]{5, CoreConstants.LEFT_PARENTHESIS_CHAR, 1, 2, '\n', 21, 1, 0, '\t', '#', CharUtils.CR, 20, '#', Typography.amp, 20, 25, '#', 18, 28, 11, 4, ' '}, (byte) ((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + b.f39n), objArr34);
                    Class<?> cls9 = Class.forName((String) objArr34[0]);
                    Object[] objArr35 = new Object[1];
                    a(KeyEvent.getDeadChar(0, 0) + 15, new char[]{25, '\"', '*', '!', CoreConstants.RIGHT_PARENTHESIS_CHAR, 23, 1, 7, 26, '0', CoreConstants.SINGLE_QUOTE_CHAR, 25, 25, Typography.amp, 13826}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 1), objArr35);
                    Long lValueOf3 = Long.valueOf(((Long) cls9.getDeclaredMethod((String) objArr35[0], new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-444530678);
                    if (objAccessartificialFrame6 == null) {
                        int i40 = 27 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
                        char cKeyCodeFromString = (char) KeyEvent.keyCodeFromString("");
                        int iGreen = 1041 - Color.green(0);
                        byte[] bArr8 = $$a;
                        byte b22 = (byte) (-bArr8[54]);
                        byte b23 = bArr8[44];
                        Object[] objArr36 = new Object[1];
                        b(b22, b23, (byte) (b23 | 46), objArr36);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(i40, cKeyCodeFromString, iGreen, 2061780482, false, (String) objArr36[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, lValueOf3);
                    i = getARTIFICIAL_FRAME_PACKAGE_NAME + 93;
                    artificialFrame = i % 128;
                } catch (Exception unused2) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object[] objArr37 = new Object[1];
            a(15 - TextUtils.indexOf((CharSequence) "", '0'), new char[]{'\f', CoreConstants.DASH_CHAR, '!', CoreConstants.COMMA_CHAR, 4, '\"', 5, CoreConstants.LEFT_PARENTHESIS_CHAR, CoreConstants.RIGHT_PARENTHESIS_CHAR, 1, 20, '0', CoreConstants.SINGLE_QUOTE_CHAR, 16, 25, CoreConstants.RIGHT_PARENTHESIS_CHAR}, (byte) (((Process.getThreadPriority(0) + 20) >> 6) + 53), objArr37);
            Class<?> cls10 = Class.forName((String) objArr37[0]);
            Object[] objArr38 = new Object[1];
            a(16 - TextUtils.getTrimmedLength(""), new char[]{21, 3, 26, '\"', 17, 25, 20, CoreConstants.SINGLE_QUOTE_CHAR, 19, 5, Typography.amp, '$', 21, 14, 6, 21}, (byte) (118 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))), objArr38);
            int iIntValue2 = ((Integer) cls10.getMethod((String) objArr38[0], Object.class).invoke(null, this)).intValue();
            Object[] objArr39 = {-660517059};
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame4 == null) {
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 7, (char) ((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 22251), (ViewConfiguration.getKeyRepeatDelay() >> 16) + 1033, 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = CompactHashMap.Itr.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame4).newInstance(objArr39), 1532108620, false);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame5 == null) {
                int i310 = (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 25;
                char threadPriority4 = (char) ((Process.getThreadPriority(0) + 20) >> 6);
                int mirror3 = 1089 - AndroidCharacter.getMirror('0');
                byte b24 = (byte) ($$b & 63);
                byte b25 = $$a[44];
                Object[] objArr310 = new Object[1];
                b(b24, b25, (byte) (b25 | 46), objArr310);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(i310, threadPriority4, mirror3, 1145017376, false, (String) objArr310[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArrAccessartificialFrame$78cbbd35);
            Object[] objArr311 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 18, new char[]{5, CoreConstants.LEFT_PARENTHESIS_CHAR, 1, 2, '\n', 21, 1, 0, '\t', '#', CharUtils.CR, 20, '#', Typography.amp, 20, 25, '#', 18, 28, 11, 4, ' '}, (byte) ((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + b.f39n), objArr311);
            Class<?> cls11 = Class.forName((String) objArr311[0]);
            Object[] objArr312 = new Object[1];
            a(KeyEvent.getDeadChar(0, 0) + 15, new char[]{25, '\"', '*', '!', CoreConstants.RIGHT_PARENTHESIS_CHAR, 23, 1, 7, 26, '0', CoreConstants.SINGLE_QUOTE_CHAR, 25, 25, Typography.amp, 13826}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 1), objArr312);
            Long lValueOf4 = Long.valueOf(((Long) cls11.getDeclaredMethod((String) objArr312[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame6 == null) {
                int i41 = 27 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
                char cKeyCodeFromString2 = (char) KeyEvent.keyCodeFromString("");
                int iGreen2 = 1041 - Color.green(0);
                byte[] bArr9 = $$a;
                byte b26 = (byte) (-bArr9[54]);
                byte b27 = bArr9[44];
                Object[] objArr313 = new Object[1];
                b(b26, b27, (byte) (b27 | 46), objArr313);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(i41, cKeyCodeFromString2, iGreen2, 2061780482, false, (String) objArr313[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf4);
            i = getARTIFICIAL_FRAME_PACKAGE_NAME + 93;
            artificialFrame = i % 128;
        }
        int i42 = i % 2;
        int i43 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        int i44 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i44 == i43) {
            Object[] objArr40 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i45 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i46 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i47 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr6 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int iNextInt = new Random().nextInt(1744162891);
            int i48 = ~iNextInt;
            int i49 = i45 + (-281035190) + ((iNextInt | 813703376) * 988) + (((~(914419923 | i48)) | (-937032664)) * (-1976)) + (((~(iNextInt | 836316116)) | 813703376 | (~((-836316117) | i48))) * 988);
            int i50 = (i49 << 13) ^ i49;
            int i51 = i50 ^ (i50 >>> 17);
            ((int[]) objArr40[1])[0] = i51 ^ (i51 << 5);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        String[] strArr7 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
        if (strArr7 != null) {
            int i52 = getARTIFICIAL_FRAME_PACKAGE_NAME + 21;
            artificialFrame = i52 % 128;
            for (int i53 = i52 % 2 == 0 ? 1 : 0; i53 < strArr7.length; i53++) {
                arrayList2.add(strArr7[i53]);
            }
        }
        Object[] objArr41 = {Long.valueOf(((long) (i43 ^ i44)) ^ (((long) 549831720) << 32)), Long.valueOf(549831722)};
        byte[] bArr10 = $$g;
        byte b28 = bArr10[30];
        short s = (short) (b28 | 374);
        Object[] objArr42 = new Object[1];
        c(b28, s, (byte) (s & 189), objArr42);
        Class<?> cls12 = Class.forName((String) objArr42[0]);
        Object[] objArr43 = new Object[1];
        c((byte) (-bArr10[2]), (short) 138, bArr10[30], objArr43);
        cls12.getMethod((String) objArr43[0], Long.TYPE, Long.TYPE).invoke(null, objArr41);
        Object[] objArr44 = {strArr, new int[1], new int[]{i}, new int[]{i}};
        int i54 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
        int i55 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        int i56 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        String[] strArr8 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
        int i57 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().densityDpi;
        int i58 = ~i57;
        int i59 = (-1951111082) + (((~((-553220715) | i58)) | 547899904 | (~(475116907 | i58)) | (~((-469796098) | i57))) * (-84));
        int i60 = (~(i57 | 475116907)) | 553220714;
        int i61 = ~(i58 | (-475116908));
        int i62 = i54 + i59 + ((i60 | i61) * (-84)) + ((469796097 | i61) * 84);
        int i63 = (i62 << 13) ^ i62;
        int i64 = i63 ^ (i63 >>> 17);
        ((int[]) objArr44[1])[0] = i64 ^ (i64 << 5);
    }

    static {
        byte[] bArr = new byte[736];
        System.arraycopy("\u0004\u0086µ¢ðþ;Ãôü\u0004÷\u00033Çíõ\u0005ø\u0001=¶\u0007÷ÿ9·ûþ\t\u0000ð\u0000÷\u0003\u0002ø\u0000ù2×Ûþ\t\u0000ð\u0000÷\u0003\"Ø\u0000ù\u001aáúë\u0001ùõðùÿöý\u0007÷\u0005\u001eÍ\t\u0000é\u0007öýðþ;Ä\u0001úúÿïü\u00009¸\t\u0000úëBµ\bø\bï\töþï@Ñæ\u0004\u0002\u000fÛ\u0007û\u0011ÝüÿDüÛÉ\u0000\u000bï\u0000\tñ\u0015Ö\u0007ö\bÿí\u0007\u0002\u0013çð\u0007úÿ-ü¿ðþ;Âÿóü\u0001÷\u0003û\u0003ñü:Æÿé\u000b\u0002ë\u0003\u0002ô\u0002ï@Ãþó\u0005ï\ré\u000bý2ÜÕ\u0004\u0007ùï\u001eã\u0002ô\u0002ïJüÛÉ\u0000\u000bï\u0000\tñ\u0015Ö\u0007ö\bÿí\u0007\u0002\u001eÍ\u0003\u0018Ú\u0007ûõ\u0019Öý\u0004ÿ÷\u0005/úüúîü\u000eëú\u0007ÿù\u0002ö\u0004ñ\"Ð\rð\u0004ðþ;Ãôü\u0004÷\u00033Éí\u00037ÙØ\u0002÷\u000f\rÚÿ÷\u0001ðþ;Ãôü\u0004÷\u00033Çíõ\u0005ø\u0001=¶\u0007÷ÿ9Éø\u0000ù2éØî*àå)âèQïðþ;¶þ\rï÷\u0006òû\u0001ùû\u0000\u0005îB¾ù\bþé\u0007öýý\bï\töþï@Åë\róöBÚçïû\u0006òû+Ë\róöðùÿöý\u0007÷\u0005\u001fÏö\u0003\u0006ÿëõ\u0000ÿðü\u00009\u0001Á÷ö\u000bï\u0000\tñ:º\u0000\u0007é\nóù\u0001;Éï\u0006îÿ\u0002\u00012æÛûýïü\tý\rà\bô\u0002í/Ùÿíø\u000bïðþ;Ãôü\u0004÷\u00033Äùó\tÿýê\n3¸\tôú÷\u000bþðý\u0004ùþ5Á÷ö\u000bï\u0000\tñ:çÐý\u0004ùþ Ðýö\u000fô÷\u0005ïJÞÉ\bù\u0004ûïÐùÿöý\u0007÷\u0005\u001dÛÿé\nüú÷\u0003\u0018Óðþ;Ãôü\u0004÷\u00033Éï\u0006îÿ\u0002\u00012ÃööAÁ÷ö\u000bï\u0000\tñ:½ýýþñ\u0011å\tò\u0006öý\u000bùýë\u000bð\u0007û\u0002ùé\u0003\u0006ô\u0003ý2°ü\u0011ðþ;Ãôü\u0004÷\u00033Éï\u0006îÿ\u0002\u00012ÃööAÁ÷ö\u000bï\u0000\tñ:½ýýþñ\u0011å\tò\u0006öý\u000bùýë\u000bð\u0007û3°ü\u0014äðþ;Ãôü\u0004÷\u00033½ýýþñBÇðþüúý<·\u000bõþ÷ö\u000bï\u0000\tñ:°ü\u0005ðþ;Ä\u0001úúÿïü\u00009Áø\böþñ\u0003õ\u0007õÿ÷\u00053Çðù\t3ÚÚÿ\u0007ë\u000eúï\u001bêðø\fó\u0007ú\u001báúë\u0001ùõQÝÐþù\u000bï\u0001öý".getBytes(CharEncoding.ISO_8859_1), 0, bArr, 0, 736);
        $$g = bArr;
        $$h = 51;
        $$a = new byte[]{Ascii.GS, Ascii.VT, Ascii.VT, -116, 2, -15, 33, -33, 19, -17, 32, -15, -19, Ascii.VT, -5, 7, -10, Ascii.US, -20, -13, 8, Ascii.VT, Ascii.CR, -27, 9, -18, 36, -33, 19, -17, 32, -15, -19, Ascii.VT, -5, 7, 7, -18, 43, -29, 4, -17, -2, -5, 1, 33, -33, 2, 9, -5, 7, -5, 1, 50, -39, -11, 7, Ascii.FF, -15, -49, -2, Ascii.VT, 3, -3, 6, -6, 8, -11, Ascii.EM, -33, 19, -2, -8, 37, -44, 17, -12, 8, -14, -27, -1, 7, 6, 33, -51, Ascii.FF, -3, 8, -1, -13, 9, -18, 34, -25, -4, 17, -19, Ascii.SI, 1, Ascii.DC2, -15, -19, Ascii.VT, -5, 7, 2, -15, 36, -21, -13, Ascii.SI, -2, -9, -6, 34, -15, -19, Ascii.VT, -5, 7};
        $$b = 239;
        getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        artificialFrame = 1;
        ArtificialStackFrames = new char[]{44388, 44402, 44336, 44698, 44372, 44337, 44334, 44399, 44370, 44699, 44394, 44342, 44360, 44371, 44355, 44386, 44341, 44703, 44404, 44343, 44696, 44702, 44700, 44345, 44393, 44395, 44344, 44389, 44400, 44691, 44406, 44338, 44396, 44398, 44405, 44392, 44391, 44403, 44353, 44397, 44390, 44409, 44339, 44701, 44697, 44690, 44387, 44385, 44340};
        coroutineCreation = (char) 39069;
    }
}
