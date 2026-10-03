package com.facebook;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
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
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import ch.qos.logback.core.net.SyslogConstants;
import com.facebook.internal.FacebookDialogFragment;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.internal.logging.dumpsys.EndToEndDumper;
import com.facebook.login.LoginFragment;
import com.google.common.base.Ascii;
import com.salesforce.marketingcloud.analytics.stats.b;
import com.swmansion.gesturehandler.core.NativeViewGestureHandler;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.internal.HashMapClassDesc;
import o.ArtificialStackFrames;
import o.asBinder;
import org.apache.commons.lang3.CharEncoding;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class FacebookActivity extends FragmentActivity {
    private static final byte[] $$a;
    private static final int $$b;
    private static final byte[] $$d;
    private static final int $$e;
    public static final Companion Companion;
    private static final String FRAGMENT_TAG = "SingleFragment";
    public static final String PASS_THROUGH_CANCEL_ACTION = "PassThrough";
    private static final String TAG;
    private static int artificialFrame;
    private static long extraCommand;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;
    private Fragment currentFragment;
    private static final byte[] $$c = {115, -32, -105, -45};
    private static final int $$f = 141;
    private static int $10 = 0;
    private static int $11 = 1;

    /* JADX WARN: Code duplicated, block: B:10:0x0026  */
    /* JADX WARN: Code duplicated, block: B:8:0x0020  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x002d). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0026
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$g(int r6, byte r7, int r8) {
        /*
            int r7 = r7 * 2
            int r0 = r7 + 1
            int r6 = r6 * 4
            int r6 = 4 - r6
            int r8 = r8 * 2
            int r8 = r8 + 118
            byte[] r1 = com.facebook.FacebookActivity.$$c
            byte[] r0 = new byte[r0]
            r2 = 0
            if (r1 != 0) goto L17
            r4 = r8
            r3 = r2
            r8 = r6
            goto L2d
        L17:
            r3 = r2
        L18:
            r5 = r8
            r8 = r6
            r6 = r5
            byte r4 = (byte) r6
            r0[r3] = r4
            if (r3 != r7) goto L26
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            return r6
        L26:
            int r3 = r3 + 1
            r4 = r1[r8]
            r5 = r8
            r8 = r6
            r6 = r5
        L2d:
            int r6 = r6 + 1
            int r8 = r8 + r4
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.FacebookActivity.$$g(int, byte, int):java.lang.String");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0020  */
    /* JADX WARN: Code duplicated, block: B:8:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0020 -> B:11:0x0024). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0020
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void b(int r6, short r7, int r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = com.facebook.FacebookActivity.$$a
            int r6 = r6 + 4
            int r7 = r7 + 8
            int r8 = r8 + 65
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L10
            r3 = r7
            r4 = r2
            goto L24
        L10:
            r3 = r2
        L11:
            int r4 = r3 + 1
            byte r5 = (byte) r8
            r1[r3] = r5
            if (r4 != r7) goto L20
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L20:
            int r6 = r6 + 1
            r3 = r0[r6]
        L24:
            int r3 = -r3
            int r8 = r8 + r3
            r3 = r4
            goto L11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.FacebookActivity.b(int, short, int, java.lang.Object[]):void");
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
    private static void c(int r5, int r6, int r7, java.lang.Object[] r8) {
        /*
            int r7 = r7 + 4
            byte[] r0 = com.facebook.FacebookActivity.$$d
            int r1 = r6 + 1
            int r5 = 111 - r5
            byte[] r1 = new byte[r1]
            r2 = 0
            if (r0 != 0) goto L11
            r3 = r5
            r5 = r6
            r4 = r2
            goto L25
        L11:
            r3 = r2
        L12:
            int r7 = r7 + 1
            byte r4 = (byte) r5
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L23
            java.lang.String r5 = new java.lang.String
            r5.<init>(r1, r2)
            r8[r2] = r5
            return
        L23:
            r3 = r0[r7]
        L25:
            int r5 = r5 + r3
            int r5 = r5 + (-4)
            r3 = r4
            goto L12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.FacebookActivity.c(int, int, int, java.lang.Object[]):void");
    }

    public final Fragment getCurrentFragment() {
        return this.currentFragment;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (!FacebookSdk.isInitialized()) {
            Utility.logd(TAG, "Facebook SDK not initialized. Make sure you call sdkInitialize inside your Application's onCreate method.");
            Context applicationContext = getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
            FacebookSdk.sdkInitialize(applicationContext);
        }
        setContentView(com.facebook.common.R.layout.com_facebook_activity_layout);
        if (Intrinsics.areEqual(PASS_THROUGH_CANCEL_ACTION, intent.getAction())) {
            handlePassThroughError();
        } else {
            this.currentFragment = getFragment();
        }
    }

    protected Fragment getFragment() {
        Fragment fragment;
        Intent intent = getIntent();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        Fragment fragmentFindFragmentByTag = supportFragmentManager.findFragmentByTag(FRAGMENT_TAG);
        if (fragmentFindFragmentByTag != null) {
            return fragmentFindFragmentByTag;
        }
        if (Intrinsics.areEqual(FacebookDialogFragment.TAG, intent.getAction())) {
            FacebookDialogFragment facebookDialogFragment = new FacebookDialogFragment();
            facebookDialogFragment.setRetainInstance(true);
            facebookDialogFragment.show(supportFragmentManager, FRAGMENT_TAG);
            fragment = facebookDialogFragment;
        } else {
            LoginFragment loginFragment = new LoginFragment();
            loginFragment.setRetainInstance(true);
            supportFragmentManager.beginTransaction().add(com.facebook.common.R.id.com_facebook_fragment_container, loginFragment, FRAGMENT_TAG).commit();
            fragment = loginFragment;
        }
        return fragment;
    }

    private static void a(int i, char[] cArr, Object[] objArr) throws Throwable {
        int i2 = 2 % 2;
        asBinder asbinder = new asBinder();
        asbinder.c = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        asbinder.d = 0;
        while (asbinder.d < cArr.length) {
            int i3 = asbinder.d;
            try {
                Object[] objArr2 = {Integer.valueOf(cArr[asbinder.d]), asbinder, asbinder};
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1562553046);
                if (objAccessartificialFrame == null) {
                    byte b = (byte) 0;
                    byte b2 = b;
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getTapTimeout() >> 16) + 11, (char) (ViewConfiguration.getJumpTapTimeout() >> 16), (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 1406, 1035473698, false, $$g(b, b2, b2), new Class[]{Integer.TYPE, Object.class, Object.class});
                }
                jArr[i3] = ((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue() ^ (extraCommand ^ (-2360974883025274865L));
                Object[] objArr3 = {asbinder, asbinder};
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1981632360);
                if (objAccessartificialFrame2 == null) {
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 8, (char) (ViewConfiguration.getDoubleTapTimeout() >> 16), 248 - TextUtils.lastIndexOf("", '0', 0, 0), 378009232, false, "w", new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame2).invoke(null, objArr3);
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
            int i4 = $11 + 73;
            $10 = i4 % 128;
            if (i4 % 2 != 0) {
                cArr2[asbinder.d] = (char) jArr[asbinder.d];
                Object[] objArr4 = {asbinder, asbinder};
                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1981632360);
                if (objAccessartificialFrame3 == null) {
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(9 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (char) View.resolveSize(0, 0), Color.alpha(0) + 249, 378009232, false, "w", new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                int i5 = 57 / 0;
            } else {
                cArr2[asbinder.d] = (char) jArr[asbinder.d];
                Object[] objArr5 = {asbinder, asbinder};
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1981632360);
                if (objAccessartificialFrame4 == null) {
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getLongPressTimeout() >> 16) + 8, (char) (ExpandableListView.getPackedPositionChild(0L) + 1), 250 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), 378009232, false, "w", new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame4).invoke(null, objArr5);
            }
            int i6 = $10 + 99;
            $11 = i6 % 128;
            int i7 = i6 % 2;
        }
        objArr[0] = new String(cArr2);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        Fragment fragment = this.currentFragment;
        if (fragment != null) {
            fragment.onConfigurationChanged(newConfig);
        }
    }

    private final void handlePassThroughError() {
        Intent requestIntent = getIntent();
        Intrinsics.checkNotNullExpressionValue(requestIntent, "requestIntent");
        FacebookException exceptionFromErrorData = NativeProtocol.getExceptionFromErrorData(NativeProtocol.getMethodArgumentsFromIntent(requestIntent));
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        setResult(0, NativeProtocol.createProtocolResultIntent(intent, null, exceptionFromErrorData));
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void dump(@NotNull String prefix, @Nullable FileDescriptor fileDescriptor, @NotNull PrintWriter writer, @Nullable String[] strArr) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(prefix, "prefix");
            Intrinsics.checkNotNullParameter(writer, "writer");
            EndToEndDumper companion = EndToEndDumper.Companion.getInstance();
            if (companion == null || !companion.maybeDump(prefix, writer, strArr)) {
                super.dump(prefix, fileDescriptor, writer, strArr);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        byte[] bArr = new byte[745];
        System.arraycopy("FÊ\u00072\u0010\u0002Å=\f\u0004ü\týÍ7\u0011ú\u0012\u0001þÿÎCø\u0017õ\u0011ûü\u000fÆ9\u0010\u0001\u0007\u0007ÀK\u0003ù\u0007\u0001\u000fù\u0000\u0012¿#\u0018\u0017õ\u0011ûü\u000fÜ9ù÷\u0010\u0000þä0\u0001\u0007\u0007\u0005µ\u0004%7\u0000õ\u0011\u0000÷\u000fë*ù\nø\u0001\u0013ùþí\u0019\u0010ù\u0006\u0001Ô\b\u00060\u0007\u0001\n\u0003ù\tûã%\u0001\u0017ö\u0004\u0006\týè-\u0010\u0002ÅJ\u0002ó\u0011\tú\u000e\u0005ÿ\u0007\u0005\u0000û\u0012¾B\u0007ø\u0002\u0017ù\n\u0003\u0003ø\u0011÷\n\u0002\u0011ÀB\u0007ü\u0004\u0002\u0011À*\u0003\u0004\u0002ÿ!\u000fõà3\u0004ù\rú\u0005\u0011¶C\u0004A\b\tü\u0001\t\u000eº9\u0010\u0007\u0001\n\u0003ù\tû\u0012¿\u001b,\u0007\b\t\u0010\u0002Å<ÿ\u0006\u0006\u0001\u0011\u0004\u0000ÇH÷\u0000\u0006\u0015¾Kø\bø\u0011÷\n\u0002\u0011À/\u001aüþñ%ù\u0005ï#\u0004\u0001¼\u0004%7\u0000õ\u0011\u0000÷\u000fë*ù\nø\u0001\u0013ùþí\u0019\u0010ù\u0006\u0001Ó\u0010\u0002Å<ÿ\u0006\u0006\u0001\u0011\u0004\u0000Ç7\u0013\u0004\u0000\u0001\t\u0001\f¿\u00173\u0004à!\t\u0001Ý!\u0017ñÇ\u0011\u0000\u0001\u0010\u0004\u0000Çÿ?\t\nõ\u0011\u0000÷\u000fÆM\u0000¿(\u0017\u0000\u000fï\u0012\u0001õ ø\fþ\u0013´7\u001fû\u000fõ\u0011æ\u0011\u0016ü\u0010\u0002ÅJ\u0002ó\u0011\tú\u000e\u0005ÿ\u0007\u0005\u0000û\u0012¾B\u0007ø\u0002\u0017ù\n\u0003\u0003ø\u0011÷\n\u0002\u0011ÀIö\u0011\b÷þ\u0006Í*\"ó\u0006\f\u0002\týð\u0016\u0011\b÷þ\u0006ÃD\u0010\u0002Å=\f\u0004ü\týÍ7\u0013ýÉ'(þ\tñó&\u0001\tÿ\u0010\u0002Å=\f\u0004ü\týÍ9\u0010\u0002\u0004\u0006\u0003Ä9\u0010\u0001\u0004ý\u0002\u0015¾*\"÷\u0004ó\"ó\u0019ó\u0011\u0005ö\u0011¶\"4÷\u0000\u0007\u0014øâ'\r\u0005\u0005Ù/õ\u0011ó\u0017ÿ\u0007\u0006\u0004\u0006\u0012\u0004ò\u0015\u0006ù\u0001\u0007þ\nü\u000fÞ0ó\u0010ü\u0010\u0002Å<ÿ\u0006\u0006\u0001\u0011\u0004\u0000Ç?\bø\n\u0002\u000fý\u000bù\u000b\u0001\tûÍ9\u0010\u0007÷Í&&\u0001ù\u0015ò\u0006\u0011å\u0016\u0010\bô\rù\u0006å\u001f\u0006\u0015ÿ\u0007\u000b¯#0\u0002\u0007õ\u0011ÿ\n\u0003\u0010\u0002Å<ÿ\u0006\u0006\u0001\u0011\u0004\u0000Ç:\u0012ó\u001aò\u0004Í8\u0003\u0006\fþ\rú\u0013¿Fý\u000bù\u000b\u0001\tûÍ?\tü\rÃ\u001f(ø\n\u0002î'û\u0002\u0006\të#ù\u0007\u000b\u0010\u0002Å=\f\u0004ü\týÍC\u0003\u0003\u0002\u000f¾9\u0010\u0002\u0004\u0006\u0003ÄIõ\u000b\u0002\t\nõ\u0011\u0000÷\u000fÆP\u0004û\u0010\u0002Å=\f\u0004ü\týÍ7\u0011ú\u0012\u0001þÿÎCø\u0017õ\u0011ûü\u000fÆ9\u0010\u0001\u0007\u0007ÀK\u0003ù\u0007\u0001\u000fù\u0000\u0012¿\u001a9ù÷\u0010\u0000þä0\u0001\u0007\u0007¶\u0004%7\u0000õ\u0011\u0000÷\u000fë*ù\nø\u0001\u0013ùþí\u0019\u0010ù\u0006\u0001Ó".getBytes(CharEncoding.ISO_8859_1), 0, bArr, 0, 745);
        $$d = bArr;
        $$e = 44;
        $$a = new byte[]{32, -58, -29, Ascii.ETB, -5, 1, 33, -33, 2, 9, -5, 7, -5, 1, 50, -39, -11, 7, Ascii.FF, -15, 9, -18, 34, -25, -4, 17, -19, Ascii.SI, 1, Ascii.DC2, -15, -19, Ascii.VT, -5, 7, 2, -15, 36, -21, -13, Ascii.SI, -2, -9, -6, 34, -15, -19, Ascii.VT, -5, 7, -49, -2, Ascii.VT, 3, -3, 6, -6, 8, -11, Ascii.EM, -33, 19, -2, -8, 37, -44, 17, -12, 8, -14, 2, -15, 33, -33, 19, -17, 32, -15, -19, Ascii.VT, -5, 7, -10, Ascii.US, -20, -13, 8, Ascii.VT, Ascii.CR, -27, 9, -18, 36, -33, 19, -17, 32, -15, -19, Ascii.VT, -5, 7, 7, -18, 43, -29, 4, -17, -2, -27, -1, 7, 6, 33, -51, Ascii.FF, -3, 8, -1, -13};
        $$b = 254;
        getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        artificialFrame = 1;
        accessartificialFrame();
        Companion = new Companion(null);
        TAG = FacebookActivity.class.getName();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onStart() throws Throwable {
        Object[] objArr;
        int i;
        Object[] objArr2;
        Long lValueOf;
        Object objAccessartificialFrame;
        int i2;
        char edgeSlop;
        int iArgb;
        int i3;
        boolean z;
        Object obj;
        Object[] objArr3;
        int i4;
        Object[] objArrAccessartificialFrame$78cbbd35;
        int i5;
        Object[] objArr4;
        int i6;
        Object[] objArr5;
        Long lValueOf2;
        Object objAccessartificialFrame2;
        int i7;
        char maximumFlingVelocity;
        int iIndexOf;
        int i8;
        boolean z2;
        Object obj2;
        int i9;
        Object[] objArr6;
        int i10;
        Object[] objArr7;
        int i11 = 2 % 2;
        Object[] objArr8 = new Object[1];
        a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 47083, new char[]{41000, 6088, 53235, 34806, 32666, 14219, 61367, 42990, 8030, 55133, 36657, 18271, 16132, 63257, 44847, 26413, 57044, 38613, 20203, 1691, 65158, 46777}, objArr8);
        String str = (String) objArr8[0];
        Object[] objArr9 = new Object[1];
        a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(0) + 58564, new char[]{41004, 17612, 27130, 3714, 13214, 55457, 64859, 57924, 34660, 44057, 20799, 30270, 6860, 16369, 9362}, objArr9);
        String str2 = (String) objArr9[0];
        Object[] objArr10 = new Object[1];
        a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) + 50461, new char[]{40995, 25961, 10941, 61419, 46435, 31328, 16302, 50400, 35366, 20270, 5264, 55803, 40758, 42096, 27042, 12011}, objArr10);
        String str3 = (String) objArr10[0];
        Object[] objArr11 = new Object[1];
        a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 5662, new char[]{40992, 46622, 35914, 58046, 63729, 52959, 9487, 15189, 4505, 26595, 32196, 21520, 43630, 32945, 38631, 60625}, objArr11);
        String str4 = (String) objArr11[0];
        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(1745676544);
        if (objAccessartificialFrame3 == null) {
            int iGreen = Color.green(0) + 17;
            char deadChar = (char) KeyEvent.getDeadChar(0, 0);
            int i12 = 746 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1));
            byte[] bArr = $$a;
            byte b = bArr[110];
            byte b2 = bArr[5];
            Object[] objArr12 = new Object[1];
            b(b, b2, (byte) (b2 | 46), objArr12);
            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(iGreen, deadChar, i12, -144068856, false, (String) objArr12[0], null);
        }
        long j = ((Field) objAccessartificialFrame3).getLong(null);
        if (j == -1 || j + 4611686018427387765L < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr13 = new Object[1];
                a(TextUtils.lastIndexOf("", '0') + 30698, new char[]{41000, 55246, 20479, 51072, 32642, 63405, 28507, 59192, 8032, 38664, 3875, 34660, 16100, 46847, 11907, 42631, 57007, 22105, 52831, 18043, 65065, 30268, 60989, 26051, 40432, 5612}, objArr13);
                Class<?> cls = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 51235, new char[]{41002, 26651, 12405, 63566, 32944, 18660, 4311, 55577, 57601, 43366, 29091, 14733, 49662, 35283, 21023, 6761, 8790, 60080}, objArr14);
                baseContext = (Context) cls.getMethod((String) objArr14[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = ((baseContext instanceof ContextWrapper) && ((ContextWrapper) baseContext).getBaseContext() == null) ? null : baseContext.getApplicationContext();
            }
            try {
                Object[] objArr15 = {baseContext, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 681824105};
                byte[] bArr2 = $$d;
                byte b3 = bArr2[8];
                Object[] objArr16 = new Object[1];
                c(b3, (byte) (b3 | 80), bArr2[20], objArr16);
                Class<?> cls2 = Class.forName((String) objArr16[0]);
                byte b4 = (byte) $$e;
                byte b5 = bArr2[84];
                Object[] objArr17 = new Object[1];
                c(b4, b5, (short) (b5 | 72), objArr17);
                Object[] objArr18 = (Object[]) cls2.getMethod((String) objArr17[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr15);
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1575402270);
                if (objAccessartificialFrame4 == null) {
                    int maximumFlingVelocity2 = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 17;
                    char packedPositionType = (char) ExpandableListView.getPackedPositionType(0L);
                    int iArgb2 = Color.argb(0, 0, 0, 0) + 747;
                    byte[] bArr3 = $$a;
                    byte b6 = bArr3[11];
                    byte b7 = bArr3[5];
                    Object[] objArr19 = new Object[1];
                    b(b6, b7, (byte) (b7 | 46), objArr19);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(maximumFlingVelocity2, packedPositionType, iArgb2, -1031537386, false, (String) objArr19[0], null);
                }
                ((Field) objAccessartificialFrame4).set(null, objArr18);
                try {
                    Long lValueOf3 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(1745676544);
                    if (objAccessartificialFrame5 == null) {
                        int edgeSlop2 = 17 - (ViewConfiguration.getEdgeSlop() >> 16);
                        char maximumFlingVelocity3 = (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                        int i13 = 748 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                        byte[] bArr4 = $$a;
                        byte b8 = bArr4[110];
                        byte b9 = bArr4[5];
                        Object[] objArr20 = new Object[1];
                        b(b8, b9, (byte) (b9 | 46), objArr20);
                        objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(edgeSlop2, maximumFlingVelocity3, i13, -144068856, false, (String) objArr20[0], null);
                    }
                    ((Field) objAccessartificialFrame5).set(null, lValueOf3);
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
            Object objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(1575402270);
            if (objAccessartificialFrame6 == null) {
                int jumpTapTimeout = (ViewConfiguration.getJumpTapTimeout() >> 16) + 17;
                char scrollBarSize = (char) (ViewConfiguration.getScrollBarSize() >> 8);
                int i14 = 747 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                byte[] bArr5 = $$a;
                byte b10 = bArr5[11];
                byte b11 = bArr5[5];
                Object[] objArr21 = new Object[1];
                b(b10, b11, (byte) (b11 | 46), objArr21);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(jumpTapTimeout, scrollBarSize, i14, -1031537386, false, (String) objArr21[0], null);
            }
            Object[] objArr22 = (Object[]) ((Field) objAccessartificialFrame6).get(null);
            objArr = new Object[]{list, new int[1], list, new int[]{i}, new int[]{i}};
            int i15 = ((int[]) objArr22[3])[0];
            int i16 = ((int[]) objArr22[4])[0];
            List list = (List) objArr22[0];
            List list2 = (List) objArr22[2];
            int length = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 1709807821;
            int i17 = (-2080694125) + ((453075177 | length) * 614);
            int i18 = ~length;
            int i19 = i17 + (((~((-394970137) | i18)) | 318783496 | (~(210478321 | i18))) * (-1228)) + (((~(i18 | 529261817)) | (~((-76186641) | i18))) * 614) + 681824105;
            int i20 = (i19 << 13) ^ i19;
            int i21 = i20 ^ (i20 >>> 17);
            ((int[]) objArr[1])[0] = i21 ^ (i21 << 5);
        }
        int i22 = ((int[]) objArr[4])[0];
        int i23 = ((int[]) objArr[3])[0];
        if (i23 == i22) {
            Object[] objArr23 = {list, new int[1], list, new int[]{i}, new int[]{i}};
            int i24 = ((int[]) objArr[1])[0];
            int i25 = ((int[]) objArr[3])[0];
            int i26 = ((int[]) objArr[4])[0];
            List list3 = (List) objArr[0];
            List list4 = (List) objArr[2];
            int i27 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getDisplayMetrics().widthPixels;
            int i28 = ~i27;
            int i29 = ~((-573717381) | i28);
            int i30 = ~((-31731078) | i27);
            int i31 = i24 + 364936658 + ((i29 | i30) * 1150) + ((i30 | (~(31731077 | i28))) * (-575)) + (((~(i27 | (-573717381))) | (~(i28 | 573717380))) * 575);
            int i32 = i31 ^ (i31 << 13);
            int i33 = i32 ^ (i32 >>> 17);
            ((int[]) objArr23[1])[0] = i33 ^ (i33 << 5);
            i = 0;
        } else {
            ArrayList arrayList = new ArrayList();
            try {
                Object[] objArr24 = {objArr};
                Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(1804664566);
                if (objAccessartificialFrame7 == null) {
                    objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 40, (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 12469), ExpandableListView.getPackedPositionType(0L) + 3642, -185222914, false, "coroutineCreation", new Class[]{Object[].class});
                }
                arrayList.add(((Method) objAccessartificialFrame7).invoke(null, objArr24));
                Object[] objArr25 = {objArr};
                Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-1243809191);
                if (objAccessartificialFrame8 == null) {
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(41 - ExpandableListView.getPackedPositionType(0L), (char) (12468 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1))), 3643 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), 716815441, false, "ArtificialStackFrames", new Class[]{Object[].class});
                }
                arrayList.add(((Method) objAccessartificialFrame8).invoke(null, objArr25));
                try {
                    Object[] objArr26 = {Long.valueOf((((long) (-1931807211)) << 32) ^ ((long) (i22 ^ i23))), Long.valueOf(-1931807203)};
                    byte[] bArr6 = $$d;
                    Object[] objArr27 = new Object[1];
                    c(bArr6[8], (byte) (-bArr6[6]), (short) ($$e | 66), objArr27);
                    Class<?> cls3 = Class.forName((String) objArr27[0]);
                    Object[] objArr28 = new Object[1];
                    c(bArr6[37], bArr6[5], (short) 169, objArr28);
                    cls3.getMethod((String) objArr28[0], Long.TYPE, Long.TYPE).invoke(null, objArr26);
                    Object[] objArr29 = {list, new int[1], list, new int[]{i}, new int[]{i}};
                    int i34 = ((int[]) objArr[1])[0];
                    int i35 = ((int[]) objArr[3])[0];
                    int i36 = ((int[]) objArr[4])[0];
                    List list5 = (List) objArr[0];
                    List list6 = (List) objArr[2];
                    int iUptimeMillis = (int) SystemClock.uptimeMillis();
                    int i37 = ~iUptimeMillis;
                    int i38 = i34 + 677629698 + (((-67903545) | i37) * (-369)) + (((~((-963877319) | i37)) | (-358428861)) * (-369)) + (((~(iUptimeMillis | 963877318)) | (-1031780863) | (~(i37 | (-290525317)))) * 369);
                    int i39 = (i38 << 13) ^ i38;
                    int i40 = i39 ^ (i39 >>> 17);
                    i = 0;
                    ((int[]) objArr29[1])[0] = i40 ^ (i40 << 5);
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
        Object objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-1283093189);
        if (objAccessartificialFrame9 == null) {
            int iMakeMeasureSpec = 30 - View.MeasureSpec.makeMeasureSpec(i, i);
            char cIndexOf = (char) (49361 - TextUtils.indexOf((CharSequence) "", '0'));
            int scrollBarFadeDuration = 684 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
            byte[] bArr7 = $$a;
            byte b12 = bArr7[27];
            byte b13 = bArr7[57];
            Object[] objArr30 = new Object[1];
            b(b12, b13, (byte) (b13 | 37), objArr30);
            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(iMakeMeasureSpec, cIndexOf, scrollBarFadeDuration, 752929587, false, (String) objArr30[0], null);
        }
        long j2 = ((Field) objAccessartificialFrame9).getLong(null);
        if (j2 == -1 || j2 + 1861 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext2 = getBaseContext();
            if (baseContext2 == null) {
                int i41 = getARTIFICIAL_FRAME_PACKAGE_NAME + 45;
                artificialFrame = i41 % 128;
                int i42 = i41 % 2;
                Object[] objArr31 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(3) + 30582, new char[]{41000, 55246, 20479, 51072, 32642, 63405, 28507, 59192, 8032, 38664, 3875, 34660, 16100, 46847, 11907, 42631, 57007, 22105, 52831, 18043, 65065, 30268, 60989, 26051, 40432, 5612}, objArr31);
                Class<?> cls4 = Class.forName((String) objArr31[0]);
                Object[] objArr32 = new Object[1];
                a(51240 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), new char[]{41002, 26651, 12405, 63566, 32944, 18660, 4311, 55577, 57601, 43366, 29091, 14733, 49662, 35283, 21023, 6761, 8790, 60080}, objArr32);
                baseContext2 = (Context) cls4.getMethod((String) objArr32[0], new Class[0]).invoke(null, null);
            }
            if (baseContext2 != null) {
                baseContext2 = ((baseContext2 instanceof ContextWrapper) && ((ContextWrapper) baseContext2).getBaseContext() == null) ? null : baseContext2.getApplicationContext();
            }
            Object[] objArr33 = {baseContext2, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 1616546505};
            byte[] bArr8 = $$d;
            Object[] objArr34 = new Object[1];
            c(bArr8[9], bArr8[24], (short) 171, objArr34);
            Class<?> cls5 = Class.forName((String) objArr34[0]);
            byte b14 = (byte) $$e;
            byte b15 = bArr8[84];
            Object[] objArr35 = new Object[1];
            c(b14, b15, (short) (b15 | 72), objArr35);
            objArr2 = (Object[]) cls5.getMethod((String) objArr35[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr33);
            if (baseContext2 != null) {
                int i43 = artificialFrame + 29;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i43 % 128;
                try {
                    if (i43 % 2 != 0) {
                        Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-326560385);
                        if (objAccessartificialFrame10 == null) {
                            int windowTouchSlop = 30 - (ViewConfiguration.getWindowTouchSlop() >> 8);
                            char c = (char) (49363 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)));
                            int iCombineMeasuredStates = 684 - View.combineMeasuredStates(0, 0);
                            int i44 = $$b;
                            Object[] objArr36 = new Object[1];
                            b((byte) (i44 & 31), $$a[57], (byte) (i44 & 39), objArr36);
                            objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(windowTouchSlop, c, iCombineMeasuredStates, 1944867703, false, (String) objArr36[0], null);
                        }
                        ((Field) objAccessartificialFrame10).set(null, objArr2);
                        lValueOf = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[1]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1283093189);
                        if (objAccessartificialFrame == null) {
                            i2 = (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 31;
                            edgeSlop = (char) ((ViewConfiguration.getEdgeSlop() >> 16) + 49362);
                            iArgb = (Process.myTid() >> 22) + 684;
                            i3 = 752929587;
                            z = false;
                            byte[] bArr9 = $$a;
                            byte b16 = bArr9[27];
                            byte b17 = bArr9[57];
                            Object[] objArr37 = new Object[1];
                            b(b16, b17, (byte) (b17 | 37), objArr37);
                            obj = objArr37[0];
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(i2, edgeSlop, iArgb, i3, z, (String) obj, null);
                        }
                    } else {
                        Object objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(-326560385);
                        if (objAccessartificialFrame11 == null) {
                            int iRgb = Color.rgb(0, 0, 0) + 16777246;
                            char mirror = (char) (49410 - AndroidCharacter.getMirror('0'));
                            int iAlpha = Color.alpha(0) + 684;
                            int i45 = $$b;
                            Object[] objArr38 = new Object[1];
                            b((byte) (i45 & 31), $$a[57], (byte) (i45 & 39), objArr38);
                            objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(iRgb, mirror, iAlpha, 1944867703, false, (String) objArr38[0], null);
                        }
                        ((Field) objAccessartificialFrame11).set(null, objArr2);
                        lValueOf = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1283093189);
                        if (objAccessartificialFrame == null) {
                            i2 = 30 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                            edgeSlop = (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 49361);
                            iArgb = 684 - Color.argb(0, 0, 0, 0);
                            i3 = 752929587;
                            z = false;
                            byte[] bArr10 = $$a;
                            byte b18 = bArr10[27];
                            byte b19 = bArr10[57];
                            Object[] objArr39 = new Object[1];
                            b(b18, b19, (byte) (b19 | 37), objArr39);
                            obj = objArr39[0];
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(i2, edgeSlop, iArgb, i3, z, (String) obj, null);
                        }
                    }
                    ((Field) objAccessartificialFrame).set(null, lValueOf);
                } catch (Exception unused2) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(-326560385);
            if (objAccessartificialFrame12 == null) {
                int iResolveOpacity = Drawable.resolveOpacity(0, 0) + 30;
                char cIndexOf2 = (char) (TextUtils.indexOf("", "", 0) + 49362);
                int maxKeyCode = 684 - (KeyEvent.getMaxKeyCode() >> 16);
                int i46 = $$b;
                Object[] objArr40 = new Object[1];
                b((byte) (i46 & 31), $$a[57], (byte) (i46 & 39), objArr40);
                objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(iResolveOpacity, cIndexOf2, maxKeyCode, 1944867703, false, (String) objArr40[0], null);
            }
            Object[] objArr41 = (Object[]) ((Field) objAccessartificialFrame12).get(null);
            objArr2 = new Object[]{new int[]{((int[]) objArr41[0])[0]}, new int[]{((int[]) objArr41[1])[0]}, new int[1], (String) objArr41[3]};
            int iIdentityHashCode = System.identityHashCode(this);
            int i47 = ~iIdentityHashCode;
            int i48 = (~((-12316900) | i47)) | 10002467;
            int i49 = ~(iIdentityHashCode | 968621307);
            int i50 = 1704894912 + ((i48 | i49) * (-502)) + ((i49 | (~(i47 | (-2314433)))) * TypedValues.PositionType.TYPE_DRAWPATH) + 1616546505;
            int i51 = (i50 << 13) ^ i50;
            int i52 = i51 ^ (i51 >>> 17);
            ((int[]) objArr2[2])[0] = i52 ^ (i52 << 5);
        }
        int i53 = ((int[]) objArr2[1])[0];
        int i54 = ((int[]) objArr2[0])[0];
        if (i54 == i53) {
            int i55 = ((int[]) objArr2[2])[0];
            Object[] objArr42 = {new int[]{((int[]) objArr2[0])[0]}, new int[]{((int[]) objArr2[1])[0]}, new int[1], (String) objArr2[3]};
            int iNextInt = new Random().nextInt(1093454734);
            int i56 = i55 + (-1911695090) + ((978624353 | iNextInt) * 376) + (((~((~iNextInt) | 979230272)) | 289) * (-376)) + (((~(iNextInt | (-979230273))) | (-606498)) * 376);
            int i57 = (i56 << 13) ^ i56;
            int i58 = i57 ^ (i57 >>> 17);
            ((int[]) objArr42[2])[0] = i58 ^ (i58 << 5);
        } else {
            long j3 = ((long) (i53 ^ i54)) ^ (((long) 1472918031) << 32);
            long j4 = 1472918027;
            int i59 = artificialFrame + 45;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i59 % 128;
            int i60 = i59 % 2;
            Object[] objArr43 = {Long.valueOf(j3), Long.valueOf(j4)};
            byte[] bArr11 = $$d;
            byte b20 = bArr11[8];
            byte b21 = bArr11[133];
            Object[] objArr44 = new Object[1];
            c(b20, b21, (short) (b21 | 128), objArr44);
            Class<?> cls6 = Class.forName((String) objArr44[0]);
            Object[] objArr45 = new Object[1];
            c(bArr11[37], bArr11[5], (short) 169, objArr45);
            cls6.getMethod((String) objArr45[0], Long.TYPE, Long.TYPE).invoke(null, objArr43);
            int i61 = ((int[]) objArr2[2])[0];
            Object[] objArr46 = {new int[]{((int[]) objArr2[0])[0]}, new int[]{((int[]) objArr2[1])[0]}, new int[1], (String) objArr2[3]};
            int iIdentityHashCode2 = System.identityHashCode(this);
            int i62 = i61 + (-1532797562) + (((~(905698558 | iIdentityHashCode2)) | 72925216) * (-756)) + (((~iIdentityHashCode2) | 905698558) * 756);
            int i63 = (i62 << 13) ^ i62;
            int i64 = i63 ^ (i63 >>> 17);
            ((int[]) objArr46[2])[0] = i64 ^ (i64 << 5);
        }
        Object objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(-1168947751);
        if (objAccessartificialFrame13 == null) {
            int iMyPid = 36 - (Process.myPid() >> 22);
            char modifierMetaStateMask = (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 1);
            int i65 = (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 539;
            byte[] bArr12 = $$a;
            byte b22 = bArr12[110];
            byte b23 = bArr12[5];
            Object[] objArr47 = new Object[1];
            b(b22, b23, (byte) (b23 | 46), objArr47);
            objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(iMyPid, modifierMetaStateMask, i65, 624296913, false, (String) objArr47[0], null);
        }
        long j5 = ((Field) objAccessartificialFrame13).getLong(null);
        if (j5 == -1 || j5 + 1853 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(-1717965552);
            if (objAccessartificialFrame14 == null) {
                objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 20, (char) ((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 39516), 982 - (ViewConfiguration.getDoubleTapTimeout() >> 16), 117222168, false, null, new Class[0]);
            }
            Object[] objArr48 = {null, ((Constructor) objAccessartificialFrame14).newInstance(null), -797670035, 0};
            Object objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(-501205803);
            if (objAccessartificialFrame15 == null) {
                int absoluteGravity = Gravity.getAbsoluteGravity(0, 0) + 36;
                char deadChar2 = (char) KeyEvent.getDeadChar(0, 0);
                int maximumDrawingCacheSize = 540 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                byte[] bArr13 = $$a;
                Object[] objArr49 = new Object[1];
                b((byte) 45, bArr13[88], (byte) (bArr13[5] - 1), objArr49);
                objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(absoluteGravity, deadChar2, maximumDrawingCacheSize, 2101703389, false, (String) objArr49[0], new Class[]{(Class) ArtificialStackFrames.coroutineCreation((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 54, (char) ((ViewConfiguration.getKeyRepeatDelay() >> 16) + 833), (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 576), (Class) ArtificialStackFrames.coroutineCreation(54 - TextUtils.getOffsetAfter("", 0), (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) - 1), 630 - TextUtils.getCapsMode("", 0, 0)), Integer.TYPE, Integer.TYPE});
            }
            objArr3 = (Object[]) ((Method) objAccessartificialFrame15).invoke(null, objArr48);
            Object objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(-1339222025);
            if (objAccessartificialFrame16 == null) {
                int iArgb3 = 36 - Color.argb(0, 0, 0, 0);
                char offsetAfter = (char) TextUtils.getOffsetAfter("", 0);
                int longPressTimeout = 540 - (ViewConfiguration.getLongPressTimeout() >> 16);
                byte[] bArr14 = $$a;
                byte b24 = bArr14[11];
                byte b25 = bArr14[5];
                Object[] objArr50 = new Object[1];
                b(b24, b25, (byte) (b25 | 46), objArr50);
                objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(iArgb3, offsetAfter, longPressTimeout, 793268735, false, (String) objArr50[0], null);
            }
            ((Field) objAccessartificialFrame16).set(null, objArr3);
            try {
                Long lValueOf4 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(-1168947751);
                if (objAccessartificialFrame17 == null) {
                    int iKeyCodeFromString = KeyEvent.keyCodeFromString("") + 36;
                    char cKeyCodeFromString = (char) KeyEvent.keyCodeFromString("");
                    int longPressTimeout2 = (ViewConfiguration.getLongPressTimeout() >> 16) + 540;
                    byte[] bArr15 = $$a;
                    byte b26 = bArr15[110];
                    byte b27 = bArr15[5];
                    Object[] objArr51 = new Object[1];
                    b(b26, b27, (byte) (b27 | 46), objArr51);
                    objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(iKeyCodeFromString, cKeyCodeFromString, longPressTimeout2, 624296913, false, (String) objArr51[0], null);
                }
                ((Field) objAccessartificialFrame17).set(null, lValueOf4);
            } catch (Exception unused3) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(-1339222025);
            if (objAccessartificialFrame18 == null) {
                int i66 = (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 35;
                char cResolveSizeAndState = (char) View.resolveSizeAndState(0, 0, 0);
                int scrollDefaultDelay = (ViewConfiguration.getScrollDefaultDelay() >> 16) + 540;
                byte[] bArr16 = $$a;
                byte b28 = bArr16[11];
                byte b29 = bArr16[5];
                Object[] objArr52 = new Object[1];
                b(b28, b29, (byte) (b29 | 46), objArr52);
                objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(i66, cResolveSizeAndState, scrollDefaultDelay, 793268735, false, (String) objArr52[0], null);
            }
            Object[] objArr53 = (Object[]) ((Field) objAccessartificialFrame18).get(null);
            objArr3 = new Object[]{new int[1], new int[1], new int[1]};
            int i67 = ((int[]) objArr53[2])[0];
            int i68 = ((int[]) objArr53[1])[0];
            ((int[]) objArr3[2])[0] = i67;
            ((int[]) objArr3[1])[0] = i68;
            int iIdentityHashCode3 = System.identityHashCode(this);
            int i69 = (((((~(iIdentityHashCode3 | 154940731)) | 1196681018) * 56) + 352843773) + (((~((~iIdentityHashCode3) | 1196681018)) | 154940731) * 56)) - 797670035;
            int i70 = (i69 << 13) ^ i69;
            int i71 = i70 ^ (i70 >>> 17);
            ((int[]) objArr3[0])[0] = i71 ^ (i71 << 5);
        }
        Object obj3 = objArr3[1];
        int i72 = ((int[]) obj3)[0];
        Object obj4 = objArr3[2];
        int i73 = ((int[]) obj4)[0];
        if (i73 == i72) {
            Object[] objArr54 = {new int[1], new int[1], new int[1]};
            int i74 = ((int[]) objArr3[0])[0];
            int i75 = ((int[]) obj4)[0];
            int i76 = ((int[]) obj3)[0];
            ((int[]) objArr54[2])[0] = i75;
            ((int[]) objArr54[1])[0] = i76;
            int i77 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().smallestScreenWidthDp;
            int i78 = ~((-627806315) | i77);
            int i79 = 795246697 + ((72028256 | i78) * (-280)) + ((i78 | (~((-723815436) | i77))) * 140);
            int i80 = ~((-555778059) | i77);
            int i81 = ~i77;
            int i82 = i74 + i79 + (((~(i81 | (-168037378))) | i80 | (~((-72028257) | i81))) * 140);
            int i83 = (i82 << 13) ^ i82;
            int i84 = i83 ^ (i83 >>> 17);
            ((int[]) objArr54[0])[0] = i84 ^ (i84 << 5);
            i4 = 0;
        } else {
            Object[] objArr55 = {Long.valueOf(((long) (i72 ^ i73)) ^ (((long) 781121748) << 32)), Long.valueOf(781117652)};
            byte[] bArr17 = $$d;
            Object[] objArr56 = new Object[1];
            c(bArr17[8], bArr17[385], (short) 260, objArr56);
            Class<?> cls7 = Class.forName((String) objArr56[0]);
            Object[] objArr57 = new Object[1];
            c(bArr17[37], bArr17[5], (short) 169, objArr57);
            cls7.getMethod((String) objArr57[0], Long.TYPE, Long.TYPE).invoke(null, objArr55);
            Object[] objArr58 = {new int[1], new int[1], new int[1]};
            int i85 = ((int[]) objArr3[0])[0];
            int i86 = ((int[]) objArr3[2])[0];
            int i87 = ((int[]) objArr3[1])[0];
            ((int[]) objArr58[2])[0] = i86;
            ((int[]) objArr58[1])[0] = i87;
            int iIdentityHashCode4 = System.identityHashCode(this);
            int i88 = i85 + ((((-68778521) + (((~iIdentityHashCode4) | 605036726) * 1324)) + (((~(iIdentityHashCode4 | 611644351)) | (~(739977398 | iIdentityHashCode4))) * (-1324))) - 784307898);
            int i89 = (i88 << 13) ^ i88;
            int i90 = i89 ^ (i89 >>> 17);
            i4 = 0;
            ((int[]) objArr58[0])[0] = i90 ^ (i90 << 5);
        }
        Object objAccessartificialFrame19 = ArtificialStackFrames.accessartificialFrame(-444530678);
        if (objAccessartificialFrame19 == null) {
            int iResolveSizeAndState = View.resolveSizeAndState(i4, i4, i4) + 26;
            char c2 = (char) (CdmaCellLocation.convertQuartSecToDecDegrees(i4) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(i4) == 0.0d ? 0 : -1));
            int i91 = 1041 - (TypedValue.complexToFloat(i4) > 0.0f ? 1 : (TypedValue.complexToFloat(i4) == 0.0f ? 0 : -1));
            byte[] bArr18 = $$a;
            byte b30 = bArr18[110];
            byte b31 = bArr18[5];
            Object[] objArr59 = new Object[1];
            b(b30, b31, (byte) (b31 | 46), objArr59);
            objAccessartificialFrame19 = ArtificialStackFrames.coroutineCreation(iResolveSizeAndState, c2, i91, 2061780482, false, (String) objArr59[0], null);
        }
        long j6 = ((Field) objAccessartificialFrame19).getLong(null);
        if (j6 == -1 || j6 + 4611686018427387798L < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            int iIntValue = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            Object[] objArr60 = {-1080677326};
            Object objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame20 == null) {
                objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation(9 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), (char) (22252 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))), 1033 - (ViewConfiguration.getTapTimeout() >> 16), 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = HashMapClassDesc.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame20).newInstance(objArr60), 749139616, false);
            Object objAccessartificialFrame21 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame21 == null) {
                int iMyTid = 26 - (Process.myTid() >> 22);
                char c3 = (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 1);
                int i92 = 1041 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                byte[] bArr19 = $$a;
                byte b32 = bArr19[11];
                byte b33 = bArr19[5];
                Object[] objArr61 = new Object[1];
                b(b32, b33, (byte) (b33 | 46), objArr61);
                objAccessartificialFrame21 = ArtificialStackFrames.coroutineCreation(iMyTid, c3, i92, 1145017376, false, (String) objArr61[0], null);
            }
            ((Field) objAccessartificialFrame21).set(null, objArrAccessartificialFrame$78cbbd35);
            try {
                Long lValueOf5 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame22 = ArtificialStackFrames.accessartificialFrame(-444530678);
                if (objAccessartificialFrame22 == null) {
                    int iRed = 26 - Color.red(0);
                    char cResolveSizeAndState2 = (char) View.resolveSizeAndState(0, 0, 0);
                    int iCombineMeasuredStates2 = 1041 - View.combineMeasuredStates(0, 0);
                    byte[] bArr20 = $$a;
                    byte b34 = bArr20[110];
                    byte b35 = bArr20[5];
                    Object[] objArr62 = new Object[1];
                    b(b34, b35, (byte) (b35 | 46), objArr62);
                    objAccessartificialFrame22 = ArtificialStackFrames.coroutineCreation(iRed, cResolveSizeAndState2, iCombineMeasuredStates2, 2061780482, false, (String) objArr62[0], null);
                }
                ((Field) objAccessartificialFrame22).set(null, lValueOf5);
            } catch (Exception unused4) {
                throw new RuntimeException();
            }
        } else {
            int i93 = getARTIFICIAL_FRAME_PACKAGE_NAME + 19;
            artificialFrame = i93 % 128;
            int i94 = i93 % 2;
            Object objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame23 == null) {
                int maximumDrawingCacheSize2 = (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 26;
                char scrollBarFadeDuration2 = (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                int longPressTimeout3 = 1041 - (ViewConfiguration.getLongPressTimeout() >> 16);
                byte[] bArr21 = $$a;
                byte b36 = bArr21[11];
                byte b37 = bArr21[5];
                Object[] objArr63 = new Object[1];
                b(b36, b37, (byte) (b37 | 46), objArr63);
                objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(maximumDrawingCacheSize2, scrollBarFadeDuration2, longPressTimeout3, 1145017376, false, (String) objArr63[0], null);
            }
            Object[] objArr64 = (Object[]) ((Field) objAccessartificialFrame23).get(null);
            objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
            int i95 = ((int[]) objArr64[3])[0];
            int i96 = ((int[]) objArr64[2])[0];
            String[] strArr = (String[]) objArr64[0];
            int iIdentityHashCode5 = System.identityHashCode(this);
            int i97 = ~iIdentityHashCode5;
            int i98 = 81545496 + (((~(688255556 | i97)) | (~((-766359364) | iIdentityHashCode5))) * 210) + (((~(iIdentityHashCode5 | 766375751)) | (~(i97 | (-688239169)))) * 210) + 749139616;
            int i99 = (i98 << 13) ^ i98;
            int i100 = i99 ^ (i99 >>> 17);
            ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i100 ^ (i100 << 5);
        }
        int i101 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        int i102 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i102 == i101) {
            Object[] objArr65 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i103 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i104 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i105 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr2 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int iMaxMemory = (int) Runtime.getRuntime().maxMemory();
            int i106 = ~iMaxMemory;
            int i107 = i103 + (-246934978) + (((~(i106 | 256226929)) | (~(178123122 | i106)) | (-266205044)) * 464) + (((-88081922) | iMaxMemory) * (-464)) + (((~(iMaxMemory | 256226929)) | (-266205044)) * 464);
            int i108 = (i107 << 13) ^ i107;
            int i109 = i108 ^ (i108 >>> 17);
            ((int[]) objArr65[1])[0] = i109 ^ (i109 << 5);
            i5 = 0;
        } else {
            ArrayList arrayList2 = new ArrayList();
            String[] strArr3 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            if (strArr3 != null) {
                for (String str5 : strArr3) {
                    arrayList2.add(str5);
                }
            }
            Object[] objArr66 = {Long.valueOf((((long) 386709850) << 32) ^ ((long) (i101 ^ i102))), Long.valueOf(386709848)};
            byte[] bArr22 = $$d;
            byte b38 = bArr22[44];
            Object[] objArr67 = new Object[1];
            c(b38, (byte) (b38 | 43), (short) 294, objArr67);
            Class<?> cls8 = Class.forName((String) objArr67[0]);
            Object[] objArr68 = new Object[1];
            c(bArr22[37], bArr22[5], (short) 169, objArr68);
            cls8.getMethod((String) objArr68[0], Long.TYPE, Long.TYPE).invoke(null, objArr66);
            Object[] objArr69 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i110 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i111 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i112 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr4 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int iUptimeMillis2 = (int) SystemClock.uptimeMillis();
            int i113 = (~(325909234 | iUptimeMillis2)) | 135267585;
            int i114 = ~iUptimeMillis2;
            int i115 = i110 + (-277552596) + ((i113 | (~((-57163779) | i114))) * 886) + (((~(i114 | (-325909235))) | 404013041) * (-1772)) + ((~(i114 | 404013041)) * 886);
            int i116 = (i115 << 13) ^ i115;
            int i117 = i116 ^ (i116 >>> 17);
            i5 = 0;
            ((int[]) objArr69[1])[0] = i117 ^ (i117 << 5);
        }
        Object objAccessartificialFrame24 = ArtificialStackFrames.accessartificialFrame(1056123296);
        if (objAccessartificialFrame24 == null) {
            int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i5, i5) + 30;
            char cRgb = (char) (Color.rgb(i5, i5, i5) + 16826578);
            int i118 = 684 - (ExpandableListView.getPackedPositionForGroup(i5) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(i5) == 0L ? 0 : -1));
            Object[] objArr70 = new Object[1];
            b((byte) 65, (byte) (-$$a[4]), (byte) ($$b & 39), objArr70);
            objAccessartificialFrame24 = ArtificialStackFrames.coroutineCreation(iMakeMeasureSpec2, cRgb, i118, -1583976536, false, (String) objArr70[0], null);
        }
        long j7 = ((Field) objAccessartificialFrame24).getLong(null);
        if (j7 == -1 || j7 + 1946 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            int iIntValue2 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            int i119 = getARTIFICIAL_FRAME_PACKAGE_NAME + 85;
            artificialFrame = i119 % 128;
            int i120 = i119 % 2;
            Object[] objArr71 = {Integer.valueOf(iIntValue2), 2052629527};
            byte[] bArr23 = $$d;
            Object[] objArr72 = new Object[1];
            c(bArr23[8], (byte) (-bArr23[6]), (short) 337, objArr72);
            Class<?> cls9 = Class.forName((String) objArr72[0]);
            byte b39 = (byte) $$e;
            byte b40 = bArr23[84];
            Object[] objArr73 = new Object[1];
            c(b39, b40, (short) (b40 | 72), objArr73);
            objArr4 = (Object[]) cls9.getMethod((String) objArr73[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr71);
            Object objAccessartificialFrame25 = ArtificialStackFrames.accessartificialFrame(910856866);
            if (objAccessartificialFrame25 == null) {
                int defaultSize = View.getDefaultSize(0, 0) + 30;
                char cIndexOf3 = (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 49363);
                int mirror2 = AndroidCharacter.getMirror('0') + 636;
                Object[] objArr74 = new Object[1];
                b((byte) 77, $$a[5], (byte) ($$b & 40), objArr74);
                objAccessartificialFrame25 = ArtificialStackFrames.coroutineCreation(defaultSize, cIndexOf3, mirror2, -1456483158, false, (String) objArr74[0], null);
            }
            ((Field) objAccessartificialFrame25).set(null, objArr4);
            try {
                Long lValueOf6 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame26 = ArtificialStackFrames.accessartificialFrame(1056123296);
                if (objAccessartificialFrame26 == null) {
                    int packedPositionType2 = 30 - ExpandableListView.getPackedPositionType(0L);
                    char cResolveSizeAndState3 = (char) (View.resolveSizeAndState(0, 0, 0) + 49362);
                    int i121 = (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 683;
                    Object[] objArr75 = new Object[1];
                    b((byte) 65, (byte) (-$$a[4]), (byte) ($$b & 39), objArr75);
                    objAccessartificialFrame26 = ArtificialStackFrames.coroutineCreation(packedPositionType2, cResolveSizeAndState3, i121, -1583976536, false, (String) objArr75[0], null);
                }
                ((Field) objAccessartificialFrame26).set(null, lValueOf6);
            } catch (Exception unused5) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame27 = ArtificialStackFrames.accessartificialFrame(910856866);
            if (objAccessartificialFrame27 == null) {
                int edgeSlop3 = (ViewConfiguration.getEdgeSlop() >> 16) + 30;
                char cGreen = (char) (49362 - Color.green(0));
                int i122 = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 684;
                Object[] objArr76 = new Object[1];
                b((byte) 77, $$a[5], (byte) ($$b & 40), objArr76);
                objAccessartificialFrame27 = ArtificialStackFrames.coroutineCreation(edgeSlop3, cGreen, i122, -1456483158, false, (String) objArr76[0], null);
            }
            Object[] objArr77 = (Object[]) ((Field) objAccessartificialFrame27).get(null);
            objArr4 = new Object[]{new int[]{((int[]) objArr77[0])[0]}, new int[]{((int[]) objArr77[1])[0]}, new int[1], (String) objArr77[3]};
            int iCodePointAt = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(11) + 2080011151;
            int i123 = 1342108478 + (((~((-802846296) | iCodePointAt)) | 629166096 | (~(175777479 | iCodePointAt))) * (-754));
            int i124 = ~((-629166097) | iCodePointAt);
            int i125 = ~iCodePointAt;
            int i126 = i123 + ((i124 | (~(804943575 | i125))) * (-754)) + ((i125 | (-802846296)) * 754) + 2052629527;
            int i127 = (i126 << 13) ^ i126;
            int i128 = i127 ^ (i127 >>> 17);
            ((int[]) objArr4[2])[0] = i128 ^ (i128 << 5);
        }
        int i129 = ((int[]) objArr4[1])[0];
        int i130 = ((int[]) objArr4[0])[0];
        if (i130 == i129) {
            int i131 = ((int[]) objArr4[2])[0];
            Object[] objArr78 = {new int[]{((int[]) objArr4[0])[0]}, new int[]{((int[]) objArr4[1])[0]}, new int[1], (String) objArr4[3]};
            int length2 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 1893584172;
            int i132 = i131 + (-1817899220) + (((~((-42280225) | length2)) | (~(936343550 | length2))) * 69) + (((~(length2 | 851929012)) | (~((-126694763) | length2)) | 84414538) * (-69)) + 31191524;
            int i133 = (i132 << 13) ^ i132;
            int i134 = i133 ^ (i133 >>> 17);
            i6 = 0;
            ((int[]) objArr78[2])[0] = i134 ^ (i134 << 5);
        } else {
            new ArrayList().add((String) objArr4[3]);
            Object[] objArr79 = {Long.valueOf(((long) (i129 ^ i130)) ^ (((long) 1977079947) << 32)), Long.valueOf(1977079963)};
            byte[] bArr24 = $$d;
            Object[] objArr80 = new Object[1];
            c(bArr24[8], bArr24[48], (short) 396, objArr80);
            Class<?> cls10 = Class.forName((String) objArr80[0]);
            Object[] objArr81 = new Object[1];
            c(bArr24[37], bArr24[5], (short) 169, objArr81);
            cls10.getMethod((String) objArr81[0], Long.TYPE, Long.TYPE).invoke(null, objArr79);
            int i135 = ((int[]) objArr4[2])[0];
            Object[] objArr82 = {new int[]{((int[]) objArr4[0])[0]}, new int[]{((int[]) objArr4[1])[0]}, new int[1], (String) objArr4[3]};
            int iNextInt2 = new Random().nextInt(961856202);
            int i136 = 490749898 + ((iNextInt2 | 742131186) * (-50));
            int i137 = ~((-202900769) | iNextInt2);
            int i138 = ~iNextInt2;
            int i139 = i135 + i136 + ((i137 | (~((-33591821) | i138))) * 50) + (((~(i138 | 742131186)) | (~((-236492589) | i138)) | 33591820) * 50);
            int i140 = (i139 << 13) ^ i139;
            int i141 = i140 ^ (i140 >>> 17);
            i6 = 0;
            ((int[]) objArr82[2])[0] = i141 ^ (i141 << 5);
        }
        Object objAccessartificialFrame28 = ArtificialStackFrames.accessartificialFrame(-2127922582);
        if (objAccessartificialFrame28 == null) {
            int i142 = (ExpandableListView.getPackedPositionForChild(i6, i6) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(i6, i6) == 0L ? 0 : -1)) + 31;
            char cRed = (char) (Color.red(i6) + 49362);
            int iIndexOf2 = TextUtils.indexOf("", "", i6) + 684;
            byte b41 = (byte) (-$$a[4]);
            Object[] objArr83 = new Object[1];
            b((byte) 85, b41, (byte) (b41 | 40), objArr83);
            objAccessartificialFrame28 = ArtificialStackFrames.coroutineCreation(i142, cRed, iIndexOf2, 508509282, false, (String) objArr83[0], null);
        }
        long j8 = ((Field) objAccessartificialFrame28).getLong(null);
        if (j8 == -1 || j8 + 1856 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext3 = getBaseContext();
            if (baseContext3 == null) {
                int i143 = getARTIFICIAL_FRAME_PACKAGE_NAME + 19;
                artificialFrame = i143 % 128;
                int i144 = i143 % 2;
                Object[] objArr84 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) + 30648, new char[]{41000, 55246, 20479, 51072, 32642, 63405, 28507, 59192, 8032, 38664, 3875, 34660, 16100, 46847, 11907, 42631, 57007, 22105, 52831, 18043, 65065, 30268, 60989, 26051, 40432, 5612}, objArr84);
                Class<?> cls11 = Class.forName((String) objArr84[0]);
                Object[] objArr85 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 51235, new char[]{41002, 26651, 12405, 63566, 32944, 18660, 4311, 55577, 57601, 43366, 29091, 14733, 49662, 35283, 21023, 6761, 8790, 60080}, objArr85);
                baseContext3 = (Context) cls11.getMethod((String) objArr85[0], new Class[0]).invoke(null, null);
            }
            if (baseContext3 != null) {
                baseContext3 = ((baseContext3 instanceof ContextWrapper) && ((ContextWrapper) baseContext3).getBaseContext() == null) ? null : baseContext3.getApplicationContext();
            }
            Object[] objArr86 = {baseContext3, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), -497821641};
            byte[] bArr25 = $$d;
            Object[] objArr87 = new Object[1];
            c(bArr25[8], (byte) (-bArr25[6]), (short) TypedValues.CycleType.TYPE_EASING, objArr87);
            Class<?> cls12 = Class.forName((String) objArr87[0]);
            byte b42 = bArr25[124];
            byte b43 = bArr25[469];
            Object[] objArr88 = new Object[1];
            c(b42, b43, (short) (b43 | 459), objArr88);
            objArr5 = (Object[]) cls12.getMethod((String) objArr88[0], Context.class, Integer.TYPE, Integer.TYPE).invoke(null, objArr86);
            if (baseContext3 != null) {
                int i145 = artificialFrame + 69;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i145 % 128;
                try {
                    if (i145 % 2 != 0) {
                        Object objAccessartificialFrame29 = ArtificialStackFrames.accessartificialFrame(777251007);
                        if (objAccessartificialFrame29 == null) {
                            int iCombineMeasuredStates3 = View.combineMeasuredStates(0, 0) + 30;
                            char packedPositionChild = (char) (ExpandableListView.getPackedPositionChild(0L) + 49363);
                            int size = 684 - View.MeasureSpec.getSize(0);
                            byte[] bArr26 = $$a;
                            Object[] objArr89 = new Object[1];
                            b((byte) 97, (byte) (bArr26[5] - 1), (byte) (-bArr26[15]), objArr89);
                            objAccessartificialFrame29 = ArtificialStackFrames.coroutineCreation(iCombineMeasuredStates3, packedPositionChild, size, -1321816393, false, (String) objArr89[0], null);
                        }
                        ((Field) objAccessartificialFrame29).set(null, objArr5);
                        lValueOf2 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-2127922582);
                        if (objAccessartificialFrame2 == null) {
                            i7 = 31 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                            maximumFlingVelocity = (char) (49362 - (ViewConfiguration.getTapTimeout() >> 16));
                            iIndexOf = (ViewConfiguration.getJumpTapTimeout() >> 16) + 684;
                            i8 = 508509282;
                            z2 = false;
                            byte b44 = (byte) (-$$a[4]);
                            Object[] objArr90 = new Object[1];
                            b((byte) 85, b44, (byte) (b44 | 40), objArr90);
                            obj2 = objArr90[0];
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(i7, maximumFlingVelocity, iIndexOf, i8, z2, (String) obj2, null);
                        }
                    } else {
                        Object objAccessartificialFrame30 = ArtificialStackFrames.accessartificialFrame(777251007);
                        if (objAccessartificialFrame30 == null) {
                            int i146 = 29 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1));
                            char c4 = (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 49363);
                            int scrollDefaultDelay2 = 684 - (ViewConfiguration.getScrollDefaultDelay() >> 16);
                            byte[] bArr27 = $$a;
                            Object[] objArr91 = new Object[1];
                            b((byte) 97, (byte) (bArr27[5] - 1), (byte) (-bArr27[15]), objArr91);
                            objAccessartificialFrame30 = ArtificialStackFrames.coroutineCreation(i146, c4, scrollDefaultDelay2, -1321816393, false, (String) objArr91[0], null);
                        }
                        ((Field) objAccessartificialFrame30).set(null, objArr5);
                        lValueOf2 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-2127922582);
                        if (objAccessartificialFrame2 == null) {
                            i7 = (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 29;
                            maximumFlingVelocity = (char) ((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 49362);
                            iIndexOf = TextUtils.indexOf((CharSequence) "", '0', 0) + 685;
                            i8 = 508509282;
                            z2 = false;
                            byte b45 = (byte) (-$$a[4]);
                            Object[] objArr92 = new Object[1];
                            b((byte) 85, b45, (byte) (b45 | 40), objArr92);
                            obj2 = objArr92[0];
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(i7, maximumFlingVelocity, iIndexOf, i8, z2, (String) obj2, null);
                        }
                    }
                    ((Field) objAccessartificialFrame2).set(null, lValueOf2);
                    int i147 = getARTIFICIAL_FRAME_PACKAGE_NAME + 63;
                    artificialFrame = i147 % 128;
                    int i148 = i147 % 2;
                } catch (Exception unused6) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object objAccessartificialFrame31 = ArtificialStackFrames.accessartificialFrame(777251007);
            if (objAccessartificialFrame31 == null) {
                int i149 = 30 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                char cLastIndexOf = (char) (TextUtils.lastIndexOf("", '0', 0) + 49363);
                int i150 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 684;
                byte[] bArr28 = $$a;
                Object[] objArr93 = new Object[1];
                b((byte) 97, (byte) (bArr28[5] - 1), (byte) (-bArr28[15]), objArr93);
                objAccessartificialFrame31 = ArtificialStackFrames.coroutineCreation(i149, cLastIndexOf, i150, -1321816393, false, (String) objArr93[0], null);
            }
            Object[] objArr94 = (Object[]) ((Field) objAccessartificialFrame31).get(null);
            objArr5 = new Object[]{new int[]{((int[]) objArr94[0])[0]}, new int[]{((int[]) objArr94[1])[0]}, new int[1], (String) objArr94[3]};
            int i151 = ~(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().uiMode | 1004986039);
            int i152 = (((((-980721456) | i151) * (-658)) + 454987582) + ((i151 | (-1006034880)) * 658)) - 497821641;
            int i153 = (i152 << 13) ^ i152;
            int i154 = i153 ^ (i153 >>> 17);
            ((int[]) objArr5[2])[0] = i154 ^ (i154 << 5);
        }
        int i155 = ((int[]) objArr5[1])[0];
        int i156 = ((int[]) objArr5[0])[0];
        if (i156 == i155) {
            int i157 = ((int[]) objArr5[2])[0];
            Object[] objArr95 = {new int[]{((int[]) objArr5[0])[0]}, new int[]{((int[]) objArr5[1])[0]}, new int[1], (String) objArr5[3]};
            int iFreeMemory = (int) Runtime.getRuntime().freeMemory();
            int i158 = ~iFreeMemory;
            int i159 = i157 + (-1508821074) + (((~((-1047520669) | i158)) | 979674496 | (~(68896893 | i158))) * (-1136)) + (((~((-1047520669) | iFreeMemory)) | (~(68896893 | iFreeMemory)) | (~((-1050722) | i158))) * (-568)) + (((~(iFreeMemory | (-979674497))) | (~(i158 | (-68896894))) | (~(1047520668 | i158))) * 568);
            int i160 = (i159 << 13) ^ i159;
            int i161 = i160 ^ (i160 >>> 17);
            i9 = 0;
            ((int[]) objArr95[2])[0] = i161 ^ (i161 << 5);
        } else {
            Object[] objArr96 = {Long.valueOf(((long) (i155 ^ i156)) ^ (((long) 1534581070) << 32)), Long.valueOf(1534581582)};
            byte[] bArr29 = $$d;
            byte b46 = bArr29[8];
            byte b47 = bArr29[133];
            Object[] objArr97 = new Object[1];
            c(b46, b47, (short) (b47 | 128), objArr97);
            Class<?> cls13 = Class.forName((String) objArr97[0]);
            Object[] objArr98 = new Object[1];
            c(bArr29[37], bArr29[5], (short) 169, objArr98);
            cls13.getMethod((String) objArr98[0], Long.TYPE, Long.TYPE).invoke(null, objArr96);
            int i162 = ((int[]) objArr5[2])[0];
            Object[] objArr99 = {new int[]{((int[]) objArr5[0])[0]}, new int[]{((int[]) objArr5[1])[0]}, new int[1], (String) objArr5[3]};
            int i163 = ~System.identityHashCode(this);
            int i164 = i162 + (-567103970) + (((-67109457) | i163) * SyslogConstants.LOG_LOCAL7) + (((~(i163 | 464686510)) | (-84968159)) * SyslogConstants.LOG_LOCAL7);
            int i165 = (i164 << 13) ^ i164;
            int i166 = i165 ^ (i165 >>> 17);
            i9 = 0;
            ((int[]) objArr99[2])[0] = i166 ^ (i166 << 5);
        }
        Object objAccessartificialFrame32 = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame32 == null) {
            int packedPositionGroup = 25 - ExpandableListView.getPackedPositionGroup(0L);
            char cRgb2 = (char) ((-16747148) - Color.rgb(i9, i9, i9));
            int pressedStateDuration = 816 - (ViewConfiguration.getPressedStateDuration() >> 16);
            byte[] bArr30 = $$a;
            byte b48 = bArr30[110];
            byte b49 = bArr30[5];
            Object[] objArr100 = new Object[1];
            b(b48, b49, (byte) (b49 | 46), objArr100);
            objAccessartificialFrame32 = ArtificialStackFrames.coroutineCreation(packedPositionGroup, cRgb2, pressedStateDuration, 721586079, false, (String) objArr100[0], null);
        }
        long j9 = ((Field) objAccessartificialFrame32).getLong(null);
        if (j9 == -1 || j9 + 1892 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object[] objArr101 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 789785598};
            Object objAccessartificialFrame33 = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame33 == null) {
                int touchSlop = (ViewConfiguration.getTouchSlop() >> 8) + 25;
                char packedPositionGroup2 = (char) (ExpandableListView.getPackedPositionGroup(0L) + 30068);
                int iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(0, 0) + 816;
                byte b50 = (byte) ($$b & 360);
                byte[] bArr31 = $$a;
                Object[] objArr102 = new Object[1];
                b(b50, bArr31[106], bArr31[61], objArr102);
                objAccessartificialFrame33 = ArtificialStackFrames.coroutineCreation(touchSlop, packedPositionGroup2, iMakeMeasureSpec3, -797394565, false, (String) objArr102[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr6 = (Object[]) ((Method) objAccessartificialFrame33).invoke(null, objArr101);
            Object objAccessartificialFrame34 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame34 == null) {
                int i167 = 25 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                char threadPriority = (char) (30068 - ((Process.getThreadPriority(0) + 20) >> 6));
                int iIndexOf3 = TextUtils.indexOf("", "") + 816;
                byte[] bArr32 = $$a;
                byte b51 = bArr32[11];
                byte b52 = bArr32[5];
                Object[] objArr103 = new Object[1];
                b(b51, b52, (byte) (b52 | 46), objArr103);
                objAccessartificialFrame34 = ArtificialStackFrames.coroutineCreation(i167, threadPriority, iIndexOf3, 891606461, false, (String) objArr103[0], null);
            }
            ((Field) objAccessartificialFrame34).set(null, objArr6);
            try {
                Long lValueOf7 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame35 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                if (objAccessartificialFrame35 == null) {
                    int iRgb2 = Color.rgb(0, 0, 0) + 16777241;
                    char doubleTapTimeout = (char) (30068 - (ViewConfiguration.getDoubleTapTimeout() >> 16));
                    int minimumFlingVelocity = (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 816;
                    byte[] bArr33 = $$a;
                    byte b53 = bArr33[110];
                    byte b54 = bArr33[5];
                    Object[] objArr104 = new Object[1];
                    b(b53, b54, (byte) (b54 | 46), objArr104);
                    objAccessartificialFrame35 = ArtificialStackFrames.coroutineCreation(iRgb2, doubleTapTimeout, minimumFlingVelocity, 721586079, false, (String) objArr104[0], null);
                }
                ((Field) objAccessartificialFrame35).set(null, lValueOf7);
            } catch (Exception unused7) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame36 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame36 == null) {
                int iIndexOf4 = TextUtils.indexOf("", "", 0, 0) + 25;
                char c5 = (char) (30069 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)));
                int maximumDrawingCacheSize3 = (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 816;
                byte[] bArr34 = $$a;
                byte b55 = bArr34[11];
                byte b56 = bArr34[5];
                Object[] objArr105 = new Object[1];
                b(b55, b56, (byte) (b56 | 46), objArr105);
                objAccessartificialFrame36 = ArtificialStackFrames.coroutineCreation(iIndexOf4, c5, maximumDrawingCacheSize3, 891606461, false, (String) objArr105[0], null);
            }
            Object[] objArr106 = (Object[]) ((Field) objAccessartificialFrame36).get(null);
            objArr6 = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i168 = ((int[]) objArr106[0])[0];
            int i169 = ((int[]) objArr106[1])[0];
            String[] strArr5 = (String[]) objArr106[2];
            int i170 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 1405193672;
            int i171 = 2077774887 + (((~((-773333009) | i170)) | 671096848) * (-140)) + ((~((-102236161) | i170)) * 70) + (((~(i170 | 971505374)) | (-402644687)) * 70) + 789785598;
            int i172 = (i171 << 13) ^ i171;
            int i173 = i172 ^ (i172 >>> 17);
            ((int[]) objArr6[3])[0] = i173 ^ (i173 << 5);
        }
        int i174 = ((int[]) objArr6[1])[0];
        int i175 = ((int[]) objArr6[0])[0];
        if (i175 == i174) {
            int i176 = getARTIFICIAL_FRAME_PACKAGE_NAME + 73;
            artificialFrame = i176 % 128;
            int i177 = i176 % 2;
            Object[] objArr107 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i178 = ((int[]) objArr6[3])[0];
            int i179 = ((int[]) objArr6[0])[0];
            int i180 = ((int[]) objArr6[1])[0];
            String[] strArr6 = (String[]) objArr6[2];
            int iMyUid = Process.myUid();
            int i181 = i178 + (((1522922450 + (((-9277441) | iMyUid) * (-381))) + (((~((~iMyUid) | (-79541381))) | 338700246) * 381)) - 760262656);
            int i182 = (i181 << 13) ^ i181;
            int i183 = i182 ^ (i182 >>> 17);
            i10 = 0;
            ((int[]) objArr107[3])[0] = i183 ^ (i183 << 5);
        } else {
            ArrayList arrayList3 = new ArrayList();
            String[] strArr7 = (String[]) objArr6[2];
            if (strArr7 != null) {
                for (String str6 : strArr7) {
                    int i184 = artificialFrame + 35;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i184 % 128;
                    int i185 = i184 % 2;
                    arrayList3.add(str6);
                }
            }
            Object[] objArr108 = {Long.valueOf(((long) (i174 ^ i175)) ^ (((long) 863132761) << 32)), Long.valueOf(863132760)};
            byte[] bArr35 = $$d;
            byte b57 = bArr35[8];
            byte b58 = (byte) (-bArr35[36]);
            Object[] objArr109 = new Object[1];
            c(b57, b58, (short) (b58 | 435), objArr109);
            Class<?> cls14 = Class.forName((String) objArr109[0]);
            Object[] objArr110 = new Object[1];
            c(bArr35[37], bArr35[5], (short) 169, objArr110);
            cls14.getMethod((String) objArr110[0], Long.TYPE, Long.TYPE).invoke(null, objArr108);
            Object[] objArr111 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i186 = ((int[]) objArr6[3])[0];
            int i187 = ((int[]) objArr6[0])[0];
            int i188 = ((int[]) objArr6[1])[0];
            String[] strArr8 = (String[]) objArr6[2];
            int i189 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().touchscreen;
            int i190 = i186 + (-410921614) + (((~((-551559383) | i189)) | (~((-353387017) | i189))) * 69) + (((~(i189 | (-487836170))) | (~((-686008536) | i189)) | 134449153) * (-69)) + 1296150944;
            int i191 = (i190 << 13) ^ i190;
            int i192 = i191 ^ (i191 >>> 17);
            i10 = 0;
            ((int[]) objArr111[3])[0] = i192 ^ (i192 << 5);
        }
        super.onStart();
        Object objAccessartificialFrame37 = ArtificialStackFrames.accessartificialFrame(1313006081);
        if (objAccessartificialFrame37 == null) {
            int absoluteGravity2 = Gravity.getAbsoluteGravity(i10, i10) + 21;
            char cRed2 = (char) Color.red(i10);
            int i193 = (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 464;
            byte[] bArr36 = $$a;
            byte b59 = bArr36[110];
            byte b60 = bArr36[5];
            Object[] objArr112 = new Object[1];
            b(b59, b60, (byte) (b60 | 46), objArr112);
            objAccessartificialFrame37 = ArtificialStackFrames.coroutineCreation(absoluteGravity2, cRed2, i193, -785931255, false, (String) objArr112[0], null);
        }
        long j10 = ((Field) objAccessartificialFrame37).getLong(null);
        if (j10 == -1 || j10 + 2012 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext4 = getBaseContext();
            if (baseContext4 == null) {
                Object[] objArr113 = new Object[1];
                a((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 30697, new char[]{41000, 55246, 20479, 51072, 32642, 63405, 28507, 59192, 8032, 38664, 3875, 34660, 16100, 46847, 11907, 42631, 57007, 22105, 52831, 18043, 65065, 30268, 60989, 26051, 40432, 5612}, objArr113);
                Class<?> cls15 = Class.forName((String) objArr113[0]);
                Object[] objArr114 = new Object[1];
                a(51239 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), new char[]{41002, 26651, 12405, 63566, 32944, 18660, 4311, 55577, 57601, 43366, 29091, 14733, 49662, 35283, 21023, 6761, 8790, 60080}, objArr114);
                baseContext4 = (Context) cls15.getMethod((String) objArr114[0], new Class[0]).invoke(null, null);
            }
            if (baseContext4 != null) {
                baseContext4 = ((baseContext4 instanceof ContextWrapper) && ((ContextWrapper) baseContext4).getBaseContext() == null) ? null : baseContext4.getApplicationContext();
            }
            int iIntValue3 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            Object[] objArr115 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 55466, new char[]{41007, 30901, 4580, 10780, 49998, 39981, 46305, 19941, 26178, 16197, 55422, 61671, 35301, 41494, 31559, 5164, 11516, 50608, 40469, 46923, 20600, 26785, 495, 55876, 62278, 35885, 42152, 32230, 5697, 12104, 51242, 57596, 47503, 21009, 27462, 1066, 56485, 62862, 36382, 42772, 16497, 6399, 12685, 51731, 58189, 48244, 21756, 28122, 1631, 57109, 63522, 37033, 43476, 16908, 6977, 13347, 52385, 58767, 48730, 22291, 28786, 2291, 8587, 64009}, objArr115);
            String str7 = (String) objArr115[0];
            Object[] objArr116 = new Object[1];
            a(52052 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), new char[]{41084, 27437, 13962, 49621, 36192, 22704, 25483, 12088, 64224, 34203, 20802, 7354, 10139, 62285, 48807, 18861, 5450, 8444, 60334, 46853, 16980, 3552, 55646, 58461, 44984, 31590, 1553, 53690, 40249, 43035, 29585, 16246, 51740, 38345, 41341, 27682, 14288, 49879, 36478, 23001, 25736, 12336, 64482, 34442, 21054, 7662, 10388, 62534, 49134, 19097, 5662, 8614, 60663, 47107, 17405, 3754, 55811, 58707, 45247, 31835, 1805, 53999, 40501, 43329}, objArr116);
            Object[] objArr117 = {baseContext4, new String[]{str7, (String) objArr116[0]}, Integer.valueOf(iIntValue3), 1, 1993008319};
            byte[] bArr37 = $$d;
            Object[] objArr118 = new Object[1];
            c(bArr37[8], bArr37[580], (short) 563, objArr118);
            Class<?> cls16 = Class.forName((String) objArr118[0]);
            byte b61 = bArr37[124];
            byte b62 = bArr37[469];
            Object[] objArr119 = new Object[1];
            c(b61, b62, (short) (b62 | 459), objArr119);
            objArr7 = (Object[]) cls16.getMethod((String) objArr119[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr117);
            int i194 = ((int[]) objArr7[0])[0];
            int i195 = ((int[]) objArr7[3])[0];
            if (baseContext4 != null) {
                Object objAccessartificialFrame38 = ArtificialStackFrames.accessartificialFrame(1142731807);
                if (objAccessartificialFrame38 == null) {
                    int i196 = (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 20;
                    char c6 = (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 1);
                    int i197 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 464;
                    byte[] bArr38 = $$a;
                    byte b63 = bArr38[11];
                    byte b64 = bArr38[5];
                    Object[] objArr120 = new Object[1];
                    b(b63, b64, (byte) (b64 | 46), objArr120);
                    objAccessartificialFrame38 = ArtificialStackFrames.coroutineCreation(i196, c6, i197, -612765161, false, (String) objArr120[0], null);
                }
                ((Field) objAccessartificialFrame38).set(null, objArr7);
                try {
                    Long lValueOf8 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame39 = ArtificialStackFrames.accessartificialFrame(1313006081);
                    if (objAccessartificialFrame39 == null) {
                        int doubleTapTimeout2 = 21 - (ViewConfiguration.getDoubleTapTimeout() >> 16);
                        char c7 = (char) (1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)));
                        int iNormalizeMetaState = 465 - KeyEvent.normalizeMetaState(0);
                        byte[] bArr39 = $$a;
                        byte b65 = bArr39[110];
                        byte b66 = bArr39[5];
                        Object[] objArr121 = new Object[1];
                        b(b65, b66, (byte) (b66 | 46), objArr121);
                        objAccessartificialFrame39 = ArtificialStackFrames.coroutineCreation(doubleTapTimeout2, c7, iNormalizeMetaState, -785931255, false, (String) objArr121[0], null);
                    }
                    ((Field) objAccessartificialFrame39).set(null, lValueOf8);
                } catch (Exception unused8) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object objAccessartificialFrame40 = ArtificialStackFrames.accessartificialFrame(1142731807);
            if (objAccessartificialFrame40 == null) {
                int iIndexOf5 = TextUtils.indexOf((CharSequence) "", '0') + 22;
                char c8 = (char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)));
                int iIndexOf6 = 464 - TextUtils.indexOf((CharSequence) "", '0', 0);
                byte[] bArr40 = $$a;
                byte b67 = bArr40[11];
                byte b68 = bArr40[5];
                Object[] objArr122 = new Object[1];
                b(b67, b68, (byte) (b68 | 46), objArr122);
                objAccessartificialFrame40 = ArtificialStackFrames.coroutineCreation(iIndexOf5, c8, iIndexOf6, -612765161, false, (String) objArr122[0], null);
            }
            Object[] objArr123 = (Object[]) ((Field) objAccessartificialFrame40).get(null);
            objArr7 = new Object[]{new int[]{i}, strArr, new int[1], new int[]{i}};
            int i198 = ((int[]) objArr123[3])[0];
            int i199 = ((int[]) objArr123[0])[0];
            String[] strArr9 = (String[]) objArr123[1];
            int iNextInt3 = new Random().nextInt(1636602724);
            int i200 = (-266196757) + ((141475101 | iNextInt3) * 614);
            int i201 = ~iNextInt3;
            int i202 = i200 + (((~((-146280590) | i201)) | 136843277 | (~(14069136 | i201))) * (-1228)) + (((~(i201 | 150912413)) | (~((-9437313) | i201))) * 614) + 1993008319;
            int i203 = (i202 << 13) ^ i202;
            int i204 = i203 ^ (i203 >>> 17);
            ((int[]) objArr7[2])[0] = i204 ^ (i204 << 5);
        }
        int i205 = ((int[]) objArr7[0])[0];
        int i206 = ((int[]) objArr7[3])[0];
        if (i206 == i205) {
            Object[] objArr124 = {new int[]{i}, strArr, new int[1], new int[]{i}};
            int i207 = ((int[]) objArr7[2])[0];
            int i208 = ((int[]) objArr7[3])[0];
            int i209 = ((int[]) objArr7[0])[0];
            String[] strArr10 = (String[]) objArr7[1];
            int startElapsedRealtime = (int) Process.getStartElapsedRealtime();
            int i210 = ~startElapsedRealtime;
            int i211 = i207 + (-1276843316) + (((~(463375272 | i210)) | (~((-445809193) | startElapsedRealtime))) * (-831)) + ((~(1069534190 | startElapsedRealtime)) * (-1662)) + (((~(startElapsedRealtime | (-463375273))) | (~(i210 | (-623724999))) | (~(623724998 | startElapsedRealtime))) * 831);
            int i212 = (i211 << 13) ^ i211;
            int i213 = i212 ^ (i212 >>> 17);
            ((int[]) objArr124[2])[0] = i213 ^ (i213 << 5);
            return;
        }
        ArrayList arrayList4 = new ArrayList();
        String[] strArr11 = (String[]) objArr7[1];
        if (strArr11 != null) {
            for (String str8 : strArr11) {
                arrayList4.add(str8);
            }
        }
        Object[] objArr125 = {Long.valueOf(((long) (i205 ^ i206)) ^ (((long) 217330485) << 32)), Long.valueOf(217330549)};
        byte[] bArr41 = $$d;
        Object[] objArr126 = new Object[1];
        c(bArr41[8], bArr41[421], (short) ($$e | 577), objArr126);
        Class<?> cls17 = Class.forName((String) objArr126[0]);
        Object[] objArr127 = new Object[1];
        c(bArr41[37], bArr41[5], (short) 169, objArr127);
        cls17.getMethod((String) objArr127[0], Long.TYPE, Long.TYPE).invoke(null, objArr125);
        Object[] objArr128 = {new int[]{i}, strArr, new int[1], new int[]{i}};
        int i214 = ((int[]) objArr7[2])[0];
        int i215 = ((int[]) objArr7[3])[0];
        int i216 = ((int[]) objArr7[0])[0];
        String[] strArr12 = (String[]) objArr7[1];
        int i217 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 337266690;
        int i218 = (-1289370051) + (((~(498181693 | i217)) | (-337831968)) * 672);
        int i219 = ~i217;
        int i220 = i214 + i218 + (((~(i217 | (-337831968))) | (~((-498181694) | i219))) * (-672)) + (((~(337831967 | i219)) | (-498331200)) * 672);
        int i221 = (i220 << 13) ^ i220;
        int i222 = i221 ^ (i221 >>> 17);
        ((int[]) objArr128[2])[0] = i222 ^ (i222 << 5);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onResume() throws Throwable {
        int i = 2 % 2;
        int i2 = getARTIFICIAL_FRAME_PACKAGE_NAME + 89;
        artificialFrame = i2 % 128;
        int i3 = i2 % 2;
        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(949068051);
        if (objAccessartificialFrame == null) {
            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getScrollBarSize() >> 8) + 30, (char) (49993 - TextUtils.getOffsetAfter("", 0)), 75 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), -1477122277, false, "MediaDescriptionCompatApi23Builder", null);
        }
        Object obj = null;
        Object obj2 = ((Field) objAccessartificialFrame).get(null);
        try {
            Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1579113874);
            if (objAccessartificialFrame2 == null) {
                int offsetBefore = 30 - TextUtils.getOffsetBefore("", 0);
                char cResolveSizeAndState = (char) (View.resolveSizeAndState(0, 0, 0) + 49993);
                int threadPriority = ((Process.getThreadPriority(0) + 20) >> 6) + 74;
                byte[] bArr = $$d;
                byte b = bArr[168];
                byte b2 = bArr[44];
                Object[] objArr = new Object[1];
                c(b, b2, (short) (b2 | 659), objArr);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(offsetBefore, cResolveSizeAndState, threadPriority, -1048962150, false, (String) objArr[0], new Class[0]);
            }
            ((Method) objAccessartificialFrame2).invoke(obj2, null);
            super.onResume();
            int i4 = getARTIFICIAL_FRAME_PACKAGE_NAME + 107;
            artificialFrame = i4 % 128;
            if (i4 % 2 != 0) {
                return;
            }
            obj.hashCode();
            throw null;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onPause() throws Throwable {
        int i = 2 % 2;
        int i2 = getARTIFICIAL_FRAME_PACKAGE_NAME + 35;
        artificialFrame = i2 % 128;
        int i3 = i2 % 2;
        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(949068051);
        if (objAccessartificialFrame == null) {
            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 31, (char) ((ViewConfiguration.getFadingEdgeLength() >> 16) + 49993), View.resolveSize(0, 0) + 74, -1477122277, false, "MediaDescriptionCompatApi23Builder", null);
        }
        Object obj = null;
        Object obj2 = ((Field) objAccessartificialFrame).get(null);
        try {
            Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1579114835);
            if (objAccessartificialFrame2 == null) {
                int iMyTid = (Process.myTid() >> 22) + 30;
                char c = (char) (49993 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)));
                int iGreen = Color.green(0) + 74;
                byte[] bArr = $$d;
                byte b = bArr[8];
                byte b2 = bArr[44];
                Object[] objArr = new Object[1];
                c(b, b2, (short) (b2 | 659), objArr);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iMyTid, c, iGreen, -1048959141, false, (String) objArr[0], new Class[0]);
            }
            ((Method) objAccessartificialFrame2).invoke(obj2, null);
            super.onPause();
            int i4 = getARTIFICIAL_FRAME_PACKAGE_NAME + b.i;
            artificialFrame = i4 % 128;
            if (i4 % 2 != 0) {
                return;
            }
            obj.hashCode();
            throw null;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:17:0x023e A[Catch: all -> 0x0a84, TryCatch #2 {all -> 0x0a84, blocks: (B:52:0x073e, B:54:0x075f, B:55:0x07b4, B:15:0x022a, B:17:0x023e, B:18:0x026c), top: B:96:0x022a }] */
    /* JADX WARN: Code duplicated, block: B:21:0x0282  */
    /* JADX WARN: Code duplicated, block: B:26:0x0356  */
    /* JADX WARN: Code duplicated, block: B:51:0x06c4  */
    /* JADX WARN: Code duplicated, block: B:54:0x075f A[Catch: all -> 0x0a84, TryCatch #2 {all -> 0x0a84, blocks: (B:52:0x073e, B:54:0x075f, B:55:0x07b4, B:15:0x022a, B:17:0x023e, B:18:0x026c), top: B:96:0x022a }] */
    /* JADX WARN: Code duplicated, block: B:58:0x07c6  */
    /* JADX WARN: Code duplicated, block: B:63:0x0877  */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
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
            int threadPriority = 26 - ((Process.getThreadPriority(0) + 20) >> 6);
            char cLastIndexOf = (char) (TextUtils.lastIndexOf("", '0') + 1);
            int iRgb = Color.rgb(0, 0, 0) + 16778257;
            byte[] bArr = $$a;
            byte b = bArr[110];
            byte b2 = bArr[5];
            Object[] objArr2 = new Object[1];
            b(b, b2, (byte) (b2 | 46), objArr2);
            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(threadPriority, cLastIndexOf, iRgb, 2061780482, false, (String) objArr2[0], null);
        }
        long j = ((Field) objAccessartificialFrame7).getLong(null);
        if (j != -1) {
            long j2 = j + 4611686018427387871L;
            Object[] objArr3 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 47052, new char[]{41000, 6088, 53235, 34806, 32666, 14219, 61367, 42990, 8030, 55133, 36657, 18271, 16132, 63257, 44847, 26413, 57044, 38613, 20203, 1691, 65158, 46777}, objArr3);
            Class<?> cls = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 58597, new char[]{41004, 17612, 27130, 3714, 13214, 55457, 64859, 57924, 34660, 44057, 20799, 30270, 6860, 16369, 9362}, objArr4);
            if (j2 >= ((Long) cls.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                int i2 = getARTIFICIAL_FRAME_PACKAGE_NAME + 81;
                artificialFrame = i2 % 128;
                int i3 = i2 % 2;
                Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame8 == null) {
                    int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0) + 26;
                    char c = (char) (1 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)));
                    int windowTouchSlop = (ViewConfiguration.getWindowTouchSlop() >> 8) + 1041;
                    byte[] bArr2 = $$a;
                    byte b3 = bArr2[11];
                    byte b4 = bArr2[5];
                    Object[] objArr5 = new Object[1];
                    b(b3, b4, (byte) (b4 | 46), objArr5);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(iMakeMeasureSpec, c, windowTouchSlop, 1145017376, false, (String) objArr5[0], null);
                }
                Object[] objArr6 = (Object[]) ((Field) objAccessartificialFrame8).get(null);
                objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                int i4 = ((int[]) objArr6[3])[0];
                int i5 = ((int[]) objArr6[2])[0];
                String[] strArr = (String[]) objArr6[0];
                int i6 = (int) Runtime.getRuntime().totalMemory();
                int i7 = (-555341630) + ((i6 | 719912216) * (-50));
                int i8 = ~((-145278209) | i6);
                int i9 = ~i6;
                int i10 = i7 + (((~(i9 | 787086617)) | i8) * 50) + (((~(641808409 | i9)) | (-787086618) | (~(i9 | 719912216))) * 50) + 207929719;
                int i11 = (i10 << 13) ^ i10;
                int i12 = i11 ^ (i11 >>> 17);
                ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i12 ^ (i12 << 5);
            } else {
                Object[] objArr7 = new Object[1];
                a((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 50497, new char[]{40995, 25961, 10941, 61419, 46435, 31328, 16302, 50400, 35366, 20270, 5264, 55803, 40758, 42096, 27042, 12011}, objArr7);
                Class<?> cls2 = Class.forName((String) objArr7[0]);
                Object[] objArr8 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 5679, new char[]{40992, 46622, 35914, 58046, 63729, 52959, 9487, 15189, 4505, 26595, 32196, 21520, 43630, 32945, 38631, 60625}, objArr8);
                int iIntValue = ((Integer) cls2.getMethod((String) objArr8[0], Object.class).invoke(null, this)).intValue();
                try {
                    Object[] objArr9 = {609520876};
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1648942878);
                    if (objAccessartificialFrame == null) {
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(TextUtils.lastIndexOf("", '0') + 9, (char) (22250 - TextUtils.lastIndexOf("", '0')), (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 1032, 47343338, false, null, new Class[]{Integer.TYPE});
                    }
                    objArrAccessartificialFrame$78cbbd35 = NativeViewGestureHandler.NativeViewGestureHandlerHook.DefaultImpls.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame).newInstance(objArr9), 207929719, false);
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-614804952);
                    if (objAccessartificialFrame2 == null) {
                        int minimumFlingVelocity = 26 - (ViewConfiguration.getMinimumFlingVelocity() >> 16);
                        char capsMode = (char) TextUtils.getCapsMode("", 0, 0);
                        int i13 = 1042 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
                        byte[] bArr3 = $$a;
                        byte b5 = bArr3[11];
                        byte b6 = bArr3[5];
                        Object[] objArr10 = new Object[1];
                        b(b5, b6, (byte) (b6 | 46), objArr10);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(minimumFlingVelocity, capsMode, i13, 1145017376, false, (String) objArr10[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, objArrAccessartificialFrame$78cbbd35);
                    try {
                        Object[] objArr11 = new Object[1];
                        a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) + 47038, new char[]{41000, 6088, 53235, 34806, 32666, 14219, 61367, 42990, 8030, 55133, 36657, 18271, 16132, 63257, 44847, 26413, 57044, 38613, 20203, 1691, 65158, 46777}, objArr11);
                        Class<?> cls3 = Class.forName((String) objArr11[0]);
                        Object[] objArr12 = new Object[1];
                        a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 58566, new char[]{41004, 17612, 27130, 3714, 13214, 55457, 64859, 57924, 34660, 44057, 20799, 30270, 6860, 16369, 9362}, objArr12);
                        Long lValueOf = Long.valueOf(((Long) cls3.getDeclaredMethod((String) objArr12[0], new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-444530678);
                        if (objAccessartificialFrame3 == null) {
                            int gidForName = Process.getGidForName("") + 27;
                            char mode = (char) View.MeasureSpec.getMode(0);
                            int iLastIndexOf = 1040 - TextUtils.lastIndexOf("", '0', 0, 0);
                            byte[] bArr4 = $$a;
                            byte b7 = bArr4[110];
                            byte b8 = bArr4[5];
                            Object[] objArr13 = new Object[1];
                            b(b7, b8, (byte) (b8 | 46), objArr13);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(gidForName, mode, iLastIndexOf, 2061780482, false, (String) objArr13[0], null);
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
            a((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 50497, new char[]{40995, 25961, 10941, 61419, 46435, 31328, 16302, 50400, 35366, 20270, 5264, 55803, 40758, 42096, 27042, 12011}, objArr14);
            Class<?> cls4 = Class.forName((String) objArr14[0]);
            Object[] objArr15 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 5679, new char[]{40992, 46622, 35914, 58046, 63729, 52959, 9487, 15189, 4505, 26595, 32196, 21520, 43630, 32945, 38631, 60625}, objArr15);
            int iIntValue2 = ((Integer) cls4.getMethod((String) objArr15[0], Object.class).invoke(null, this)).intValue();
            Object[] objArr16 = {609520876};
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame == null) {
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(TextUtils.lastIndexOf("", '0') + 9, (char) (22250 - TextUtils.lastIndexOf("", '0')), (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 1032, 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = NativeViewGestureHandler.NativeViewGestureHandlerHook.DefaultImpls.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame).newInstance(objArr16), 207929719, false);
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame2 == null) {
                int minimumFlingVelocity2 = 26 - (ViewConfiguration.getMinimumFlingVelocity() >> 16);
                char capsMode2 = (char) TextUtils.getCapsMode("", 0, 0);
                int i14 = 1042 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
                byte[] bArr5 = $$a;
                byte b9 = bArr5[11];
                byte b10 = bArr5[5];
                Object[] objArr17 = new Object[1];
                b(b9, b10, (byte) (b10 | 46), objArr17);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(minimumFlingVelocity2, capsMode2, i14, 1145017376, false, (String) objArr17[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, objArrAccessartificialFrame$78cbbd35);
            Object[] objArr18 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) + 47038, new char[]{41000, 6088, 53235, 34806, 32666, 14219, 61367, 42990, 8030, 55133, 36657, 18271, 16132, 63257, 44847, 26413, 57044, 38613, 20203, 1691, 65158, 46777}, objArr18);
            Class<?> cls5 = Class.forName((String) objArr18[0]);
            Object[] objArr19 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 58566, new char[]{41004, 17612, 27130, 3714, 13214, 55457, 64859, 57924, 34660, 44057, 20799, 30270, 6860, 16369, 9362}, objArr19);
            Long lValueOf2 = Long.valueOf(((Long) cls5.getDeclaredMethod((String) objArr19[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame3 == null) {
                int gidForName2 = Process.getGidForName("") + 27;
                char mode2 = (char) View.MeasureSpec.getMode(0);
                int iLastIndexOf2 = 1040 - TextUtils.lastIndexOf("", '0', 0, 0);
                byte[] bArr6 = $$a;
                byte b11 = bArr6[110];
                byte b12 = bArr6[5];
                Object[] objArr110 = new Object[1];
                b(b11, b12, (byte) (b12 | 46), objArr110);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(gidForName2, mode2, iLastIndexOf2, 2061780482, false, (String) objArr110[0], null);
            }
            ((Field) objAccessartificialFrame3).set(null, lValueOf2);
        }
        int i15 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        int i16 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i16 == i15) {
            int i17 = getARTIFICIAL_FRAME_PACKAGE_NAME + 69;
            artificialFrame = i17 % 128;
            int i18 = i17 % 2;
            Object[] objArr20 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i19 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i20 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i21 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr2 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int i22 = ~(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 1556544725);
            int i23 = i19 + 715283710 + ((803200995 | i22) * SyslogConstants.LOG_LOCAL7) + (((~(i22 | 797299938)) | 89905921) * SyslogConstants.LOG_LOCAL7);
            int i24 = (i23 << 13) ^ i23;
            int i25 = i24 ^ (i24 >>> 17);
            ((int[]) objArr20[1])[0] = i25 ^ (i25 << 5);
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr3 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            if (strArr3 != null) {
                int i26 = 0;
                while (i26 < strArr3.length) {
                    arrayList.add(strArr3[i26]);
                    i26++;
                    int i27 = artificialFrame + 99;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i27 % 128;
                    int i28 = i27 % 2;
                }
            }
            try {
                Object[] objArr21 = {Long.valueOf(((long) (i15 ^ i16)) ^ (((long) (-1515451500)) << 32)), Long.valueOf(-1515451498)};
                byte[] bArr7 = $$d;
                byte b13 = bArr7[44];
                Object[] objArr22 = new Object[1];
                c(b13, (byte) (b13 | 43), (short) 294, objArr22);
                Class<?> cls6 = Class.forName((String) objArr22[0]);
                Object[] objArr23 = new Object[1];
                c(bArr7[37], bArr7[5], (short) 169, objArr23);
                cls6.getMethod((String) objArr23[0], Long.TYPE, Long.TYPE).invoke(null, objArr21);
                Object[] objArr24 = {strArr, new int[1], new int[]{i}, new int[]{i}};
                int i29 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
                int i30 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                int i31 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                String[] strArr4 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                int i32 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().densityDpi;
                int i33 = 89976350 + (((~((-1046693958) | i32)) | 104876033 | (~(968590150 | i32))) * (-880));
                int i34 = (~((-1046693958) | (~i32))) | (-968590151);
                int i35 = ~(i32 | 1046693957);
                int i36 = i29 + i33 + ((i34 | i35) * (-880)) + (i35 * 880);
                int i37 = (i36 << 13) ^ i36;
                int i38 = i37 ^ (i37 >>> 17);
                ((int[]) objArr24[1])[0] = i38 ^ (i38 << 5);
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        Object objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame9 == null) {
            int iIndexOf = TextUtils.indexOf((CharSequence) "", '0') + 26;
            char cAlpha = (char) (30068 - Color.alpha(0));
            int i39 = 816 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
            byte[] bArr8 = $$a;
            byte b14 = bArr8[110];
            byte b15 = bArr8[5];
            Object[] objArr25 = new Object[1];
            b(b14, b15, (byte) (b15 | 46), objArr25);
            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(iIndexOf, cAlpha, i39, 721586079, false, (String) objArr25[0], null);
        }
        long j3 = ((Field) objAccessartificialFrame9).getLong(null);
        if (j3 != -1) {
            long j4 = j3 + 1921;
            Object[] objArr26 = new Object[1];
            a(47087 - (ViewConfiguration.getTapTimeout() >> 16), new char[]{41000, 6088, 53235, 34806, 32666, 14219, 61367, 42990, 8030, 55133, 36657, 18271, 16132, 63257, 44847, 26413, 57044, 38613, 20203, 1691, 65158, 46777}, objArr26);
            Class<?> cls7 = Class.forName((String) objArr26[0]);
            Object[] objArr27 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(13) + 58500, new char[]{41004, 17612, 27130, 3714, 13214, 55457, 64859, 57924, 34660, 44057, 20799, 30270, 6860, 16369, 9362}, objArr27);
            if (j4 >= ((Long) cls7.getDeclaredMethod((String) objArr27[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                int i40 = artificialFrame + 119;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i40 % 128;
                int i41 = i40 % 2;
                Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame10 == null) {
                    int i42 = 26 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                    char threadPriority2 = (char) (30068 - ((Process.getThreadPriority(0) + 20) >> 6));
                    int iIndexOf2 = 815 - TextUtils.indexOf((CharSequence) "", '0', 0, 0);
                    byte[] bArr9 = $$a;
                    byte b16 = bArr9[11];
                    byte b17 = bArr9[5];
                    Object[] objArr28 = new Object[1];
                    b(b16, b17, (byte) (b17 | 46), objArr28);
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(i42, threadPriority2, iIndexOf2, 891606461, false, (String) objArr28[0], null);
                }
                Object[] objArr29 = (Object[]) ((Field) objAccessartificialFrame10).get(null);
                objArr = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i43 = ((int[]) objArr29[0])[0];
                int i44 = ((int[]) objArr29[1])[0];
                String[] strArr5 = (String[]) objArr29[2];
                int i45 = ~((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().keyboardHidden;
                int i46 = (((~((-741152150) | i45)) | 203424016) * (-241)) + 1473409333 + (((~(i45 | (-537728134))) | (-746403800)) * 241) + 1997771599;
                int i47 = (i46 << 13) ^ i46;
                int i48 = i47 ^ (i47 >>> 17);
                ((int[]) objArr[3])[0] = i48 ^ (i48 << 5);
            } else {
                Object[] objArr30 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 50462, new char[]{40995, 25961, 10941, 61419, 46435, 31328, 16302, 50400, 35366, 20270, 5264, 55803, 40758, 42096, 27042, 12011}, objArr30);
                Class<?> cls8 = Class.forName((String) objArr30[0]);
                Object[] objArr31 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 5648, new char[]{40992, 46622, 35914, 58046, 63729, 52959, 9487, 15189, 4505, 26595, 32196, 21520, 43630, 32945, 38631, 60625}, objArr31);
                Object[] objArr32 = {Integer.valueOf(((Integer) cls8.getMethod((String) objArr31[0], Object.class).invoke(null, this)).intValue()), 0, 1997771599};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1327366003);
                if (objAccessartificialFrame4 == null) {
                    int i49 = 26 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                    char doubleTapTimeout = (char) (30068 - (ViewConfiguration.getDoubleTapTimeout() >> 16));
                    int iIndexOf3 = 816 - TextUtils.indexOf("", "", 0);
                    byte b18 = (byte) ($$b & 360);
                    byte[] bArr10 = $$a;
                    Object[] objArr33 = new Object[1];
                    b(b18, bArr10[106], bArr10[61], objArr33);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(i49, doubleTapTimeout, iIndexOf3, -797394565, false, (String) objArr33[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                }
                objArr = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr32);
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame5 == null) {
                    int capsMode3 = TextUtils.getCapsMode("", 0, 0) + 25;
                    char cResolveSizeAndState = (char) (30068 - View.resolveSizeAndState(0, 0, 0));
                    int mirror = AndroidCharacter.getMirror('0') + 768;
                    byte[] bArr11 = $$a;
                    byte b19 = bArr11[11];
                    byte b20 = bArr11[5];
                    Object[] objArr34 = new Object[1];
                    b(b19, b20, (byte) (b20 | 46), objArr34);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(capsMode3, cResolveSizeAndState, mirror, 891606461, false, (String) objArr34[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, objArr);
                try {
                    Object[] objArr35 = new Object[1];
                    a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(12) + 46988, new char[]{41000, 6088, 53235, 34806, 32666, 14219, 61367, 42990, 8030, 55133, 36657, 18271, 16132, 63257, 44847, 26413, 57044, 38613, 20203, 1691, 65158, 46777}, objArr35);
                    Class<?> cls9 = Class.forName((String) objArr35[0]);
                    Object[] objArr36 = new Object[1];
                    a(KeyEvent.normalizeMetaState(0) + 58601, new char[]{41004, 17612, 27130, 3714, 13214, 55457, 64859, 57924, 34660, 44057, 20799, 30270, 6860, 16369, 9362}, objArr36);
                    Long lValueOf3 = Long.valueOf(((Long) cls9.getDeclaredMethod((String) objArr36[0], new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                    if (objAccessartificialFrame6 == null) {
                        int edgeSlop = 25 - (ViewConfiguration.getEdgeSlop() >> 16);
                        char mirror2 = (char) (30116 - AndroidCharacter.getMirror('0'));
                        int iMyTid = 816 - (Process.myTid() >> 22);
                        byte[] bArr12 = $$a;
                        byte b21 = bArr12[110];
                        byte b22 = bArr12[5];
                        Object[] objArr37 = new Object[1];
                        b(b21, b22, (byte) (b22 | 46), objArr37);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(edgeSlop, mirror2, iMyTid, 721586079, false, (String) objArr37[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, lValueOf3);
                } catch (Exception unused2) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object[] objArr38 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 50462, new char[]{40995, 25961, 10941, 61419, 46435, 31328, 16302, 50400, 35366, 20270, 5264, 55803, 40758, 42096, 27042, 12011}, objArr38);
            Class<?> cls10 = Class.forName((String) objArr38[0]);
            Object[] objArr39 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 5648, new char[]{40992, 46622, 35914, 58046, 63729, 52959, 9487, 15189, 4505, 26595, 32196, 21520, 43630, 32945, 38631, 60625}, objArr39);
            Object[] objArr310 = {Integer.valueOf(((Integer) cls10.getMethod((String) objArr39[0], Object.class).invoke(null, this)).intValue()), 0, 1997771599};
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame4 == null) {
                int i410 = 26 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                char doubleTapTimeout2 = (char) (30068 - (ViewConfiguration.getDoubleTapTimeout() >> 16));
                int iIndexOf4 = 816 - TextUtils.indexOf("", "", 0);
                byte b110 = (byte) ($$b & 360);
                byte[] bArr13 = $$a;
                Object[] objArr311 = new Object[1];
                b(b110, bArr13[106], bArr13[61], objArr311);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(i410, doubleTapTimeout2, iIndexOf4, -797394565, false, (String) objArr311[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr310);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame5 == null) {
                int capsMode4 = TextUtils.getCapsMode("", 0, 0) + 25;
                char cResolveSizeAndState2 = (char) (30068 - View.resolveSizeAndState(0, 0, 0));
                int mirror3 = AndroidCharacter.getMirror('0') + 768;
                byte[] bArr14 = $$a;
                byte b111 = bArr14[11];
                byte b23 = bArr14[5];
                Object[] objArr312 = new Object[1];
                b(b111, b23, (byte) (b23 | 46), objArr312);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(capsMode4, cResolveSizeAndState2, mirror3, 891606461, false, (String) objArr312[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArr);
            Object[] objArr313 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(12) + 46988, new char[]{41000, 6088, 53235, 34806, 32666, 14219, 61367, 42990, 8030, 55133, 36657, 18271, 16132, 63257, 44847, 26413, 57044, 38613, 20203, 1691, 65158, 46777}, objArr313);
            Class<?> cls11 = Class.forName((String) objArr313[0]);
            Object[] objArr314 = new Object[1];
            a(KeyEvent.normalizeMetaState(0) + 58601, new char[]{41004, 17612, 27130, 3714, 13214, 55457, 64859, 57924, 34660, 44057, 20799, 30270, 6860, 16369, 9362}, objArr314);
            Long lValueOf4 = Long.valueOf(((Long) cls11.getDeclaredMethod((String) objArr314[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame6 == null) {
                int edgeSlop2 = 25 - (ViewConfiguration.getEdgeSlop() >> 16);
                char mirror4 = (char) (30116 - AndroidCharacter.getMirror('0'));
                int iMyTid2 = 816 - (Process.myTid() >> 22);
                byte[] bArr15 = $$a;
                byte b24 = bArr15[110];
                byte b25 = bArr15[5];
                Object[] objArr315 = new Object[1];
                b(b24, b25, (byte) (b25 | 46), objArr315);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(edgeSlop2, mirror4, iMyTid2, 721586079, false, (String) objArr315[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf4);
        }
        int i50 = ((int[]) objArr[1])[0];
        int i51 = ((int[]) objArr[0])[0];
        if (i51 == i50) {
            int i52 = getARTIFICIAL_FRAME_PACKAGE_NAME + 31;
            artificialFrame = i52 % 128;
            int i53 = i52 % 2;
            Object[] objArr40 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i54 = ((int[]) objArr[3])[0];
            int i55 = ((int[]) objArr[0])[0];
            int i56 = ((int[]) objArr[1])[0];
            String[] strArr6 = (String[]) objArr[2];
            int i57 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getDisplayMetrics().densityDpi;
            int i58 = ~i57;
            int i59 = i54 + (-62030135) + (((~((-701188527) | i58)) | 562759724) * (-108)) + (((~(i58 | 899360892)) | (~((-899360893) | i57)) | (-1037789695)) * 54) + ((i57 | (-1037789695)) * 54);
            int i60 = (i59 << 13) ^ i59;
            int i61 = i60 ^ (i60 >>> 17);
            ((int[]) objArr40[3])[0] = i61 ^ (i61 << 5);
            int i62 = artificialFrame + 65;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i62 % 128;
            int i63 = i62 % 2;
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        String[] strArr7 = (String[]) objArr[2];
        if (strArr7 != null) {
            int i64 = artificialFrame;
            int i65 = i64 + 9;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i65 % 128;
            int i66 = i65 % 2;
            int i67 = i64 + 13;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i67 % 128;
            int i68 = i67 % 2;
            for (String str : strArr7) {
                arrayList2.add(str);
            }
        }
        long j5 = ((long) (i50 ^ i51)) ^ (((long) 1328986351) << 32);
        long j6 = 1328986350;
        int i69 = getARTIFICIAL_FRAME_PACKAGE_NAME + 83;
        artificialFrame = i69 % 128;
        int i70 = i69 % 2;
        Object[] objArr41 = {Long.valueOf(j5), Long.valueOf(j6)};
        byte[] bArr16 = $$d;
        Object[] objArr42 = new Object[1];
        c(bArr16[8], (byte) (-bArr16[558]), (short) 659, objArr42);
        Class<?> cls12 = Class.forName((String) objArr42[0]);
        Object[] objArr43 = new Object[1];
        c(bArr16[37], bArr16[5], (short) 169, objArr43);
        cls12.getMethod((String) objArr43[0], Long.TYPE, Long.TYPE).invoke(null, objArr41);
        Object[] objArr44 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
        int i71 = ((int[]) objArr[3])[0];
        int i72 = ((int[]) objArr[0])[0];
        int i73 = ((int[]) objArr[1])[0];
        String[] strArr8 = (String[]) objArr[2];
        int iMaxMemory = (int) Runtime.getRuntime().maxMemory();
        int i74 = ~iMaxMemory;
        int i75 = i71 + 1310238454 + (((~((-19644595) | i74)) | (~(196075195 | iMaxMemory))) * (-831)) + ((~((-17547425) | iMaxMemory)) * (-1662)) + (((~(iMaxMemory | 19644594)) | (~(i74 | (-178527772))) | (~(178527771 | iMaxMemory))) * 831);
        int i76 = (i75 << 13) ^ i75;
        int i77 = i76 ^ (i76 >>> 17);
        ((int[]) objArr44[3])[0] = i77 ^ (i77 << 5);
    }

    static void accessartificialFrame() {
        extraCommand = -301644478134871994L;
    }
}
