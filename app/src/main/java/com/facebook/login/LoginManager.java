package com.facebook.login;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.facebook.AccessToken;
import com.facebook.AuthenticationToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookActivity;
import com.facebook.FacebookAuthorizationException;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphResponse;
import com.facebook.LoginStatusCallback;
import com.facebook.Profile;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.imageutils.JfifUtil;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CustomTabUtils;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.PlatformServiceClient;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.google.android.gms.internal.stats.zzd;
import io.sentry.android.core.SentryLogcatAdapter;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Deprecated;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import o.ArtificialStackFrames;
import o.artificialFrame;
import o.asBinder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class LoginManager {
    public static final Companion Companion;
    private static final String EXPRESS_LOGIN_ALLOWED = "express_login_allowed";
    private static final String MANAGE_PERMISSION_PREFIX = "manage";
    private static final Set<String> OTHER_PUBLISH_PERMISSIONS;
    private static final String PREFERENCE_LOGIN_MANAGER = "com.facebook.loginManager";
    private static final String PUBLISH_PERMISSION_PREFIX = "publish";
    private static final String TAG;
    private static volatile LoginManager instance;
    private boolean isFamilyLogin;
    private String messengerPageId;
    private boolean resetMessengerState;
    private final SharedPreferences sharedPreferences;
    private boolean shouldSkipAccountDeduplication;
    private LoginBehavior loginBehavior = LoginBehavior.NATIVE_WITH_FALLBACK;
    private DefaultAudience defaultAudience = DefaultAudience.FRIENDS;
    private String authType = ServerProtocol.DIALOG_REREQUEST_AUTH_TYPE;
    private LoginTargetApp loginTargetApp = LoginTargetApp.FACEBOOK;

    @JvmStatic
    public static final LoginResult computeLoginResult(@NotNull LoginClient.Request request, @NotNull AccessToken accessToken, @Nullable AuthenticationToken authenticationToken) {
        return Companion.computeLoginResult(request, accessToken, authenticationToken);
    }

    @JvmStatic
    public static final Map<String, String> getExtraDataFromIntent(@Nullable Intent intent) {
        return Companion.getExtraDataFromIntent(intent);
    }

    @JvmStatic
    public static LoginManager getInstance() {
        return Companion.getInstance();
    }

    @JvmStatic
    public static final boolean isPublishPermission(@Nullable String str) {
        return Companion.isPublishPermission(str);
    }

    public final FacebookLoginActivityResultContract createLogInActivityResultContract() {
        return createLogInActivityResultContract$default(this, null, null, 3, null);
    }

    public final FacebookLoginActivityResultContract createLogInActivityResultContract(@Nullable CallbackManager callbackManager) {
        return createLogInActivityResultContract$default(this, callbackManager, null, 2, null);
    }

    public final boolean onActivityResult(int i, @Nullable Intent intent) {
        return onActivityResult$default(this, i, intent, null, 4, null);
    }

    public LoginManager() {
        Validate.sdkInitialized();
        SharedPreferences sharedPreferences = FacebookSdk.getApplicationContext().getSharedPreferences(PREFERENCE_LOGIN_MANAGER, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getApplicationContext().…ER, Context.MODE_PRIVATE)");
        this.sharedPreferences = sharedPreferences;
        if (!FacebookSdk.hasCustomTabsPrefetching || CustomTabUtils.getChromePackage() == null) {
            return;
        }
        CustomTabsClient.bindCustomTabsService(FacebookSdk.getApplicationContext(), "com.android.chrome", new CustomTabPrefetchHelper());
        CustomTabsClient.connectAndInitialize(FacebookSdk.getApplicationContext(), FacebookSdk.getApplicationContext().getPackageName());
    }

    public final LoginBehavior getLoginBehavior() {
        return this.loginBehavior;
    }

    public final DefaultAudience getDefaultAudience() {
        return this.defaultAudience;
    }

    public final String getAuthType() {
        return this.authType;
    }

    public final class FacebookLoginActivityResultContract extends ActivityResultContract<Collection<? extends String>, CallbackManager.ActivityResultParameters> {
        private CallbackManager callbackManager;
        private String loggerID;
        private static final byte[] $$a = {10, -69, -10, 57};
        private static final int $$b = 154;
        private static int $10 = 0;
        private static int $11 = 1;
        private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        private static int artificialFrame = 1;
        private static int[] ICustomTabsCallbackStub = {-257767434, 6686016, -1076389018, -1475014751, -1892510839, -952133935, 324913386, 1197773200, 100925349, 228832790, 1554038167, -2053266325, 1780717953, 1802012550, -1712779483, 1899459866, -1342793567, 1852998704};
        private static long extraCommand = 6400825295907610566L;

        /* JADX WARN: Code duplicated, block: B:10:0x0023  */
        /* JADX WARN: Code duplicated, block: B:8:0x001d  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x0027). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static java.lang.String $$c(short r5, byte r6, int r7) {
            /*
                int r6 = r6 + 4
                byte[] r0 = com.facebook.login.LoginManager.FacebookLoginActivityResultContract.$$a
                int r7 = r7 * 3
                int r1 = r7 + 1
                int r5 = r5 * 3
                int r5 = 118 - r5
                byte[] r1 = new byte[r1]
                r2 = 0
                if (r0 != 0) goto L15
                r4 = r5
                r5 = r7
                r3 = r2
                goto L27
            L15:
                r3 = r2
            L16:
                byte r4 = (byte) r5
                int r6 = r6 + 1
                r1[r3] = r4
                if (r3 != r7) goto L23
                java.lang.String r5 = new java.lang.String
                r5.<init>(r1, r2)
                return r5
            L23:
                int r3 = r3 + 1
                r4 = r0[r6]
            L27:
                int r5 = r5 + r4
                goto L16
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.login.LoginManager.FacebookLoginActivityResultContract.$$c(short, byte, int):java.lang.String");
        }

        private static void b(int i, char[] cArr, Object[] objArr) throws Throwable {
            char c = 2;
            int i2 = 2 % 2;
            asBinder asbinder = new asBinder();
            asbinder.c = i;
            int length = cArr.length;
            long[] jArr = new long[length];
            asbinder.d = 0;
            while (asbinder.d < cArr.length) {
                int i3 = $11 + 23;
                $10 = i3 % 128;
                int i4 = i3 % 2;
                int i5 = asbinder.d;
                char c2 = cArr[asbinder.d];
                try {
                    Object[] objArr2 = new Object[3];
                    objArr2[c] = asbinder;
                    objArr2[1] = asbinder;
                    objArr2[0] = Integer.valueOf(c2);
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1562553046);
                    if (objAccessartificialFrame == null) {
                        byte b = (byte) 0;
                        byte b2 = (byte) (b - 1);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(11 - Color.argb(0, 0, 0, 0), (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), ((byte) KeyEvent.getModifierMetaStateMask()) + 1408, 1035473698, false, $$c(b, b2, (byte) (b2 + 1)), new Class[]{Integer.TYPE, Object.class, Object.class});
                    }
                    jArr[i5] = ((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue() ^ (extraCommand ^ (-2360974883025274865L));
                    try {
                        Object[] objArr3 = {asbinder, asbinder};
                        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1981632360);
                        if (objAccessartificialFrame2 == null) {
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(8 - Color.alpha(0), (char) (MotionEvent.axisFromString("") + 1), 249 - TextUtils.indexOf("", "", 0, 0), 378009232, false, "w", new Class[]{Object.class, Object.class});
                        }
                        ((Method) objAccessartificialFrame2).invoke(null, objArr3);
                        int i6 = $10 + 113;
                        $11 = i6 % 128;
                        int i7 = i6 % 2;
                        c = 2;
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
                cArr2[asbinder.d] = (char) jArr[asbinder.d];
                Object[] objArr4 = {asbinder, asbinder};
                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1981632360);
                if (objAccessartificialFrame3 == null) {
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getTapTimeout() >> 16) + 8, (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), 248 - TextUtils.indexOf((CharSequence) "", '0'), 378009232, false, "w", new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame3).invoke(null, objArr4);
            }
            String str = new String(cArr2);
            int i8 = $10 + 7;
            $11 = i8 % 128;
            if (i8 % 2 != 0) {
                objArr[0] = str;
            } else {
                int i9 = 43 / 0;
                objArr[0] = str;
            }
        }

        private static void a(int i, int[] iArr, Object[] objArr) throws Throwable {
            int i2;
            int i3 = 2 % 2;
            artificialFrame artificialframe = new artificialFrame();
            char[] cArr = new char[4];
            char[] cArr2 = new char[iArr.length * 2];
            int[] iArr2 = ICustomTabsCallbackStub;
            int i4 = -1780896814;
            long j = 0;
            int i5 = 3;
            int i6 = 1;
            int i7 = 0;
            if (iArr2 != null) {
                int length = iArr2.length;
                int[] iArr3 = new int[length];
                int i8 = 0;
                while (i8 < length) {
                    try {
                        Object[] objArr2 = {Integer.valueOf(iArr2[i8])};
                        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(i4);
                        if (objAccessartificialFrame == null) {
                            int deadChar = KeyEvent.getDeadChar(0, 0) + 11;
                            char deadChar2 = (char) KeyEvent.getDeadChar(0, 0);
                            int packedPositionGroup = 1562 - ExpandableListView.getPackedPositionGroup(j);
                            byte b = (byte) i5;
                            byte b2 = (byte) (b - 4);
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(deadChar, deadChar2, packedPositionGroup, 180153818, false, $$c(b, b2, (byte) (b2 + 1)), new Class[]{Integer.TYPE});
                        }
                        iArr3[i8] = ((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
                        i8++;
                        int i9 = $10 + 99;
                        $11 = i9 % 128;
                        if (i9 % 2 == 0) {
                            int i10 = 3 % 4;
                        }
                        i4 = -1780896814;
                        j = 0;
                        i5 = 3;
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                }
                iArr2 = iArr3;
            }
            int length2 = iArr2.length;
            int[] iArr4 = new int[length2];
            int[] iArr5 = ICustomTabsCallbackStub;
            if (iArr5 != null) {
                int length3 = iArr5.length;
                int[] iArr6 = new int[length3];
                int i11 = 0;
                while (i11 < length3) {
                    int i12 = $10 + 3;
                    $11 = i12 % 128;
                    if (i12 % 2 == 0) {
                        Object[] objArr3 = new Object[i6];
                        objArr3[i7] = Integer.valueOf(iArr5[i11]);
                        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1780896814);
                        if (objAccessartificialFrame2 == null) {
                            byte b3 = (byte) 3;
                            byte b4 = (byte) (b3 - 4);
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(TextUtils.indexOf((CharSequence) "", '0', i7, i7) + 12, (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) - 1), 1562 - (ViewConfiguration.getEdgeSlop() >> 16), 180153818, false, $$c(b3, b4, (byte) (b4 + 1)), new Class[]{Integer.TYPE});
                        }
                        iArr6[i11] = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
                        length3 = length3;
                        i11 = 0;
                    } else {
                        int i13 = length3;
                        Object[] objArr4 = {Integer.valueOf(iArr5[i11])};
                        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1780896814);
                        if (objAccessartificialFrame3 == null) {
                            byte b5 = (byte) 3;
                            byte b6 = (byte) (b5 - 4);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(TextUtils.lastIndexOf("", '0', 0) + 12, (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16), (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 1561, 180153818, false, $$c(b5, b6, (byte) (b6 + 1)), new Class[]{Integer.TYPE});
                        }
                        iArr6[i11] = ((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue();
                        i11++;
                        length3 = i13;
                    }
                    i6 = 1;
                    i7 = 0;
                }
                int i14 = $10 + 89;
                $11 = i14 % 128;
                int i15 = i14 % 2;
                iArr5 = iArr6;
                i2 = 0;
            } else {
                i2 = 0;
            }
            System.arraycopy(iArr5, i2, iArr4, i2, length2);
            artificialframe.e = i2;
            while (artificialframe.e < iArr.length) {
                int i16 = $11 + 75;
                $10 = i16 % 128;
                int i17 = i16 % 2;
                cArr[0] = (char) (iArr[artificialframe.e] >> 16);
                cArr[1] = (char) iArr[artificialframe.e];
                cArr[2] = (char) (iArr[artificialframe.e + 1] >> 16);
                cArr[3] = (char) iArr[artificialframe.e + 1];
                artificialframe.c = (cArr[0] << 16) + cArr[1];
                artificialframe.b = (cArr[2] << 16) + cArr[3];
                artificialFrame.coroutineBoundary(iArr4);
                int i18 = 0;
                for (int i19 = 16; i18 < i19; i19 = 16) {
                    artificialframe.c ^= iArr4[i18];
                    Object[] objArr5 = {artificialframe, Integer.valueOf(artificialFrame.coroutineBoundary(artificialframe.c)), artificialframe, artificialframe};
                    Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1540318455);
                    if (objAccessartificialFrame4 == null) {
                        byte b7 = (byte) 1;
                        byte b8 = (byte) (-b7);
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(26 - (ViewConfiguration.getPressedStateDuration() >> 16), (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 1), TextUtils.indexOf("", "", 0) + 1041, 995482881, false, $$c(b7, b8, (byte) (b8 + 1)), new Class[]{Object.class, Integer.TYPE, Object.class, Object.class});
                    }
                    int iIntValue = ((Integer) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).intValue();
                    artificialframe.c = artificialframe.b;
                    artificialframe.b = iIntValue;
                    i18++;
                }
                int i20 = artificialframe.c;
                artificialframe.c = artificialframe.b;
                artificialframe.b = i20;
                artificialframe.b ^= iArr4[16];
                artificialframe.c ^= iArr4[17];
                int i21 = artificialframe.c;
                int i22 = artificialframe.b;
                cArr[0] = (char) (artificialframe.c >>> 16);
                cArr[1] = (char) artificialframe.c;
                cArr[2] = (char) (artificialframe.b >>> 16);
                cArr[3] = (char) artificialframe.b;
                artificialFrame.coroutineBoundary(iArr4);
                cArr2[artificialframe.e * 2] = cArr[0];
                cArr2[(artificialframe.e * 2) + 1] = cArr[1];
                cArr2[(artificialframe.e * 2) + 2] = cArr[2];
                cArr2[(artificialframe.e * 2) + 3] = cArr[3];
                try {
                    Object[] objArr6 = {artificialframe, artificialframe};
                    Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(1348396126);
                    if (objAccessartificialFrame5 == null) {
                        objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(38 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (char) (28010 - TextUtils.getOffsetBefore("", 0)), Process.getGidForName("") + 307, -818175402, false, "q", new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame5).invoke(null, objArr6);
                } catch (Throwable th2) {
                    Throwable cause2 = th2.getCause();
                    if (cause2 == null) {
                        throw th2;
                    }
                    throw cause2;
                }
            }
            objArr[0] = new String(cArr2, 0, i);
        }

        public FacebookLoginActivityResultContract(@Nullable CallbackManager callbackManager, String str) {
            this.callbackManager = callbackManager;
            this.loggerID = str;
        }

        public /* synthetic */ FacebookLoginActivityResultContract(LoginManager loginManager, CallbackManager callbackManager, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : callbackManager, (i & 2) != 0 ? null : str);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Intent createIntent(Context context, Collection<? extends String> collection) {
            return createIntent2(context, (Collection<String>) collection);
        }

        public final CallbackManager getCallbackManager() {
            return this.callbackManager;
        }

        public final void setCallbackManager(@Nullable CallbackManager callbackManager) {
            this.callbackManager = callbackManager;
        }

        public final String getLoggerID() {
            return this.loggerID;
        }

        public final void setLoggerID(@Nullable String str) {
            this.loggerID = str;
        }

        /* JADX INFO: renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(@NotNull Context context, @NotNull Collection<String> permissions) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(permissions, "permissions");
            LoginClient.Request requestCreateLoginRequestWithConfig = LoginManager.this.createLoginRequestWithConfig(new LoginConfiguration(permissions, null, 2, null));
            String str = this.loggerID;
            if (str != null) {
                requestCreateLoginRequestWithConfig.setAuthId(str);
            }
            LoginManager.this.logStartLogin(context, requestCreateLoginRequestWithConfig);
            Intent facebookActivityIntent = LoginManager.this.getFacebookActivityIntent(requestCreateLoginRequestWithConfig);
            if (LoginManager.this.resolveIntent(facebookActivityIntent)) {
                return facebookActivityIntent;
            }
            FacebookException facebookException = new FacebookException("Log in attempt failed: FacebookActivity could not be started. Please make sure you added FacebookActivity to the AndroidManifest.");
            LoginManager.this.logCompleteLogin(context, LoginClient.Result.Code.ERROR, null, facebookException, false, requestCreateLoginRequestWithConfig);
            throw facebookException;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        public CallbackManager.ActivityResultParameters parseResult(int i, @Nullable Intent intent) {
            LoginManager.onActivityResult$default(LoginManager.this, i, intent, null, 4, null);
            int requestCode = CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode();
            CallbackManager callbackManager = this.callbackManager;
            if (callbackManager != null) {
                callbackManager.onActivityResult(requestCode, i, intent);
            }
            return new CallbackManager.ActivityResultParameters(requestCode, i, intent);
        }

        public static Object[] accessartificialFrame(Context context, int i, int i2) {
            int i3;
            String str;
            int i4;
            int i5;
            int i6;
            int i7;
            Object objInvoke;
            int i8;
            int i9;
            int i10;
            int i11 = 2 % 2;
            int i12 = getARTIFICIAL_FRAME_PACKAGE_NAME + 23;
            artificialFrame = i12 % 128;
            int i13 = i12 % 2;
            int i14 = 1;
            if (context == null) {
                Object[] objArr = {new int[]{i}, new int[]{i}, new int[1], null};
                int startElapsedRealtime = (int) Process.getStartElapsedRealtime();
                int i15 = 1471627896 + ((~((-3156194) | startElapsedRealtime)) * (-301)) + (((~(87763439 | startElapsedRealtime)) | (~((~startElapsedRealtime) | 1066387214))) * (-301)) + (((~(startElapsedRealtime | (-1066387215))) | 87763439) * 301);
                int iRequestPostMessageChannelWithExtras = zzd.requestPostMessageChannelWithExtras();
                int i16 = i15 * (-661);
                int i17 = -(-(i2 * (-661)));
                int i18 = (i16 & i17) + (i16 | i17);
                int i19 = ~iRequestPostMessageChannelWithExtras;
                int i20 = ~i15;
                int i21 = ~i2;
                int i22 = ~((i20 ^ i21) | (i20 & i21));
                int i23 = -(-(((i19 & i22) | (i19 ^ i22)) * 1324));
                int i24 = (i18 & i23) + (i23 | i18);
                int i25 = ~((i15 ^ iRequestPostMessageChannelWithExtras) | (i15 & iRequestPostMessageChannelWithExtras));
                int i26 = ~(iRequestPostMessageChannelWithExtras | i2);
                int i27 = -(-(((i26 & i25) | (i25 ^ i26)) * (-1324)));
                int i28 = ((i24 | i27) << 1) - (i27 ^ i24);
                int i29 = ~((i20 ^ i2) | (i2 & i20));
                int i30 = ~((i21 ^ i15) | (i15 & i21));
                int i31 = (i28 - (~(-(-(((i29 & i30) | (i29 ^ i30)) * 662))))) - 1;
                int i32 = (i31 << 13) ^ i31;
                int i33 = i32 >>> 17;
                int i34 = (i32 | i33) & (~(i32 & i33));
                int i35 = i34 << 5;
                ((int[]) objArr[2])[0] = (i34 | i35) & (~(i34 & i35));
                int i36 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                int i37 = (i36 & 75) + (i36 | 75);
                artificialFrame = i37 % 128;
                int i38 = i37 % 2;
                return objArr;
            }
            try {
                Object[] objArr2 = new Object[1];
                a(38 - View.resolveSizeAndState(0, 0, 0), new int[]{2141742366, 149152476, 1875558364, -229029792, 65956430, 149081225, 1056934960, -468485975, -545150695, 1073833887, 8053985, -1838262853, -1910261982, -985710149, 2114845174, 973109931, 369598553, 635438931, 622076241, -1651298710}, objArr2);
                Object[] objArr3 = (Object[]) Array.newInstance(Class.forName((String) objArr2[0]), 2);
                int iCombineMeasuredStates = View.combineMeasuredStates(0, 0);
                int iRequestPostMessageChannelWithExtras2 = zzd.requestPostMessageChannelWithExtras();
                int i39 = getARTIFICIAL_FRAME_PACKAGE_NAME + 113;
                int i40 = i39 % 128;
                artificialFrame = i40;
                int i41 = (i39 % 2 == 0 ? TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS << (iCombineMeasuredStates * 306) : (iCombineMeasuredStates * 306) + TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS) - (-12119742);
                int i42 = ~(39607 | iCombineMeasuredStates);
                int i43 = i40 + 119;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i43 % 128;
                if (i43 % 2 != 0) {
                    i3 = i41 + (305 / ((~((iCombineMeasuredStates ^ iRequestPostMessageChannelWithExtras2) | (iCombineMeasuredStates & iRequestPostMessageChannelWithExtras2))) | i42));
                } else {
                    int i44 = ~((iCombineMeasuredStates ^ iRequestPostMessageChannelWithExtras2) | (iCombineMeasuredStates & iRequestPostMessageChannelWithExtras2));
                    i3 = (i41 - (~(((i42 ^ i44) | (i44 & i42)) * 305))) - 1;
                }
                int i45 = ~iRequestPostMessageChannelWithExtras2;
                int i46 = ~((iCombineMeasuredStates & i45) | (i45 ^ iCombineMeasuredStates));
                Object[] objArr4 = new Object[1];
                b(i3 + (305 * ((i46 & (-39608)) | ((-39608) ^ i46))), new char[]{59274, 32048, 53914, 14253, 36219, 57918, 18417, 56487, 12824, 38850, 60623, 16976, 42808, 15584, 37310, 63255, 19605, 41377, 1834, 39965, 61931, 22190, 44033, 471, 26248, 64626, 20851, 46791, 3056, 24871, 50920}, objArr4);
                String str2 = (String) objArr4[0];
                int i47 = artificialFrame + 63;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i47 % 128;
                int i48 = i47 % 2;
                try {
                    int iIndexOf = TextUtils.indexOf((CharSequence) "", '0', 0);
                    int iRequestPostMessageChannelWithExtras3 = zzd.requestPostMessageChannelWithExtras();
                    int i49 = iIndexOf * 284;
                    int i50 = ((i49 | (-10998)) << 1) - (i49 ^ (-10998));
                    int i51 = ~iIndexOf;
                    int i52 = ~((i51 & 39) | (i51 ^ 39));
                    int i53 = ~iIndexOf;
                    int i54 = ~((i53 ^ iRequestPostMessageChannelWithExtras3) | (i53 & iRequestPostMessageChannelWithExtras3));
                    int i55 = i50 + (((i52 ^ i54) | (i54 & i52)) * (-283));
                    int i56 = (~(((-40) & iIndexOf) | ((-40) ^ iIndexOf))) * 283;
                    Object[] objArr5 = new Object[1];
                    a((((i55 ^ i56) + ((i56 & i55) << 1)) - (~((~(((i53 ^ (-40)) | (i53 & (-40))) | iRequestPostMessageChannelWithExtras3)) * 283))) - 1, new int[]{2141742366, 149152476, 1875558364, -229029792, 65956430, 149081225, 1056934960, -468485975, -545150695, 1073833887, 8053985, -1838262853, -1910261982, -985710149, 2114845174, 973109931, 369598553, 635438931, 622076241, -1651298710}, objArr5);
                    objArr3[0] = Class.forName((String) objArr5[0]).getDeclaredConstructor(String.class).newInstance(str2);
                    int i57 = -(-View.MeasureSpec.makeMeasureSpec(0, 0));
                    Object[] objArr6 = new Object[1];
                    a(((i57 | 31) << 1) - (i57 ^ 31), new int[]{306878398, 419264552, -1170326907, -1822625564, -656464312, -1219730698, -1648156089, -1997960649, -1663768653, -1375710016, 1016165412, -295665108, 392859914, -756427861, 504947873, -1435805638}, objArr6);
                    try {
                        Object[] objArr7 = {(String) objArr6[0]};
                        int i58 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                        int i59 = (i58 & 35) + (i58 | 35);
                        artificialFrame = i59 % 128;
                        if (i59 % 2 == 0) {
                            Object[] objArr8 = new Object[1];
                            a(38 / KeyEvent.keyCodeFromString(""), new int[]{2141742366, 149152476, 1875558364, -229029792, 65956430, 149081225, 1056934960, -468485975, -545150695, 1073833887, 8053985, -1838262853, -1910261982, -985710149, 2114845174, 973109931, 369598553, 635438931, 622076241, -1651298710}, objArr8);
                            str = (String) objArr8[0];
                        } else {
                            int iKeyCodeFromString = KeyEvent.keyCodeFromString("");
                            Object[] objArr9 = new Object[1];
                            a((iKeyCodeFromString & 38) + (iKeyCodeFromString | 38), new int[]{2141742366, 149152476, 1875558364, -229029792, 65956430, 149081225, 1056934960, -468485975, -545150695, 1073833887, 8053985, -1838262853, -1910261982, -985710149, 2114845174, 973109931, 369598553, 635438931, 622076241, -1651298710}, objArr9);
                            str = (String) objArr9[0];
                        }
                        Constructor<?> declaredConstructor = Class.forName(str).getDeclaredConstructor(String.class);
                        int i60 = ~((-446606980) | i);
                        int i61 = ((i60 & 303464577) | (303464577 ^ i60)) * (-566);
                        int i62 = (((-1031681193) | i61) << 1) - (i61 ^ (-1031681193));
                        int i63 = ((((i62 | (-1081708616)) << 1) - ((-1081708616) ^ i62)) - (~(-(-((~(((-143142403) & i) | ((-143142403) ^ i))) * 566))))) - 1;
                        int i64 = ~i;
                        int i65 = (~((1289997542 & i64) | (1289997542 ^ i64))) | (-1307307264);
                        int i66 = ~(((-1281376289) & i) | ((-1281376289) ^ i));
                        int i67 = 1113253169 - (~(-(-(((i65 & i66) | (i65 ^ i66)) * (-713)))));
                        int i68 = -(-((~(((-1281376289) & i) | ((-1281376289) ^ i))) * 1426));
                        int i69 = ((i67 | i68) << 1) - (i68 ^ i67);
                        int i70 = (~(((-1298686010) & i64) | ((-1298686010) ^ i64))) * 713;
                        if (i63 > (i69 & i70) + (i70 | i69)) {
                            objArr3[1] = declaredConstructor.newInstance(objArr7);
                            Object obj = null;
                            obj.hashCode();
                            throw null;
                        }
                        objArr3[1] = declaredConstructor.newInstance(objArr7);
                        int i71 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                        int i72 = ((i71 | 107) << 1) - (i71 ^ 107);
                        artificialFrame = i72 % 128;
                        int i73 = i72 % 2;
                        try {
                            int i74 = -Color.rgb(0, 0, 0);
                            int iRequestPostMessageChannelWithExtras4 = zzd.requestPostMessageChannelWithExtras();
                            int i75 = i74 * (-947);
                            int i76 = (i75 ^ 1258313027) + ((i75 & 1258313027) << 1);
                            int i77 = ~i74;
                            int i78 = ~((16777192 & iRequestPostMessageChannelWithExtras4) | (16777192 ^ iRequestPostMessageChannelWithExtras4));
                            int i79 = i76 + (((i78 & i77) | (i77 ^ i78)) * (-948));
                            int i80 = i77 | 16777192;
                            int i81 = ~iRequestPostMessageChannelWithExtras4;
                            int i82 = (~((i81 & i80) | (i80 ^ i81))) * (-948);
                            Object[] objArr10 = new Object[1];
                            a((i79 ^ i82) + ((i82 & i79) << 1) + ((i74 | 16777192) * 948), new int[]{1283055029, -1563759573, 1192496239, 849546927, -1718402627, -589372332, 1312310645, 796045153, -1119374604, 938773308, -484404113, -284043367}, objArr10);
                            Class<?> cls = Class.forName((String) objArr10[0]);
                            Object[] objArr11 = new Object[1];
                            a(18 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), new int[]{1318200541, 1399308465, 1448895185, -859270913, -1380887705, 681496525, 1275823305, 117590244, 1013044180, -497172120}, objArr11);
                            Object objInvoke2 = cls.getMethod((String) objArr11[0], null).invoke(context, null);
                            int i83 = artificialFrame;
                            int i84 = (i83 & 33) + (i83 | 33);
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i84 % 128;
                            int i85 = i84 % 2;
                            try {
                                int i86 = -(TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                                Object[] objArr12 = new Object[1];
                                a(((i86 | 23) << 1) - (i86 ^ 23), new int[]{1283055029, -1563759573, 1192496239, 849546927, -1718402627, -589372332, 1312310645, 796045153, -1119374604, 938773308, -484404113, -284043367}, objArr12);
                                Class<?> cls2 = Class.forName((String) objArr12[0]);
                                int i87 = getARTIFICIAL_FRAME_PACKAGE_NAME + 113;
                                artificialFrame = i87 % 128;
                                if (i87 % 2 == 0) {
                                    i4 = -(Process.myTid() - 84);
                                    i5 = 99;
                                } else {
                                    i4 = -(Process.myTid() >> 22);
                                    i5 = 14;
                                }
                                int i88 = i4 * (-115);
                                int i89 = -(-(i5 * (-115)));
                                int i90 = ((i88 | i89) << 1) - (i88 ^ i89);
                                int i91 = ~((i64 ^ i4) | (i64 & i4) | i5);
                                int i92 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                int i93 = ((i92 | 35) << 1) - (i92 ^ 35);
                                artificialFrame = i93 % 128;
                                int i94 = i93 % 2 == 0 ? i90 * ((-116) % i91) * ((i4 | i) + 116) : (((i90 - (~(i91 * (-116)))) - 1) - (~((i4 | i) * 116))) - 1;
                                int i95 = ~(i64 | 1791860688);
                                int i96 = (-1200188847) + ((((-1792008151) ^ i95) | (i95 & (-1792008151))) * (-712));
                                int i97 = ~i;
                                int i98 = (1220723590 ^ i97) | (1220723590 & i97);
                                int i99 = ~((i98 ^ 1791860688) | (i98 & 1791860688));
                                int i100 = ~(((-147463) ^ i) | ((-147463) & i));
                                int i101 = -(-(((i99 ^ i100) | (i99 & i100)) * (-712)));
                                int i102 = ((i96 | i101) << 1) - (i101 ^ i96);
                                int i103 = ~((i64 ^ 1791860688) | (1791860688 & i64));
                                int i104 = (i102 - (~(-(-(((i103 & 1220723590) | (1220723590 ^ i103)) * 712))))) - 1;
                                int iRequestPostMessageChannelWithExtras5 = zzd.requestPostMessageChannelWithExtras();
                                int i105 = (-503054320) | iRequestPostMessageChannelWithExtras5;
                                int i106 = (-1123257327) - (~(((i105 ^ 135332109) | (i105 & 135332109)) * 376));
                                int i107 = ~((~iRequestPostMessageChannelWithExtras5) | (-208736720));
                                int i108 = (i106 - (~(((i107 ^ 135332109) | (i107 & 135332109)) * (-376)))) - 1;
                                int i109 = ~((208736719 ^ iRequestPostMessageChannelWithExtras5) | (iRequestPostMessageChannelWithExtras5 & 208736719));
                                int i110 = (((-429649710) ^ i109) | (i109 & (-429649710))) * 376;
                                if (i104 <= (i108 ^ i110) + ((i110 & i108) << 1)) {
                                    i6 = ~((~i4) | (~i5));
                                    int i111 = ~i5;
                                    i7 = (i111 & i) | (i111 ^ i);
                                    int i112 = 67 / 0;
                                } else {
                                    int i113 = ~i4;
                                    int i114 = ~i5;
                                    i6 = ~((i113 & i114) | (i113 ^ i114));
                                    i7 = (i114 & i) | (i114 ^ i);
                                }
                                Object[] objArr13 = new Object[1];
                                a(i94 + (116 * (i6 | (~i7))), new int[]{1318200541, 1399308465, 1448895185, -859270913, 1470272415, -404277229, 657711055, 1039561811}, objArr13);
                                Method method = cls2.getMethod((String) objArr13[0], null);
                                int i115 = getARTIFICIAL_FRAME_PACKAGE_NAME + 105;
                                artificialFrame = i115 % 128;
                                if (i115 % 2 == 0) {
                                    objInvoke = method.invoke(context, null);
                                    i8 = 3;
                                } else {
                                    objInvoke = method.invoke(context, null);
                                    i8 = 64;
                                }
                                try {
                                    Object[] objArr14 = {objInvoke, Integer.valueOf(i8)};
                                    int i116 = -KeyEvent.getDeadChar(0, 0);
                                    int iRequestPostMessageChannelWithExtras6 = zzd.requestPostMessageChannelWithExtras();
                                    int i117 = i116 * (-337);
                                    int i118 = ((i117 | 11187) << 1) - (i117 ^ 11187);
                                    int i119 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                    int i120 = (i119 ^ 45) + ((i119 & 45) << 1);
                                    int i121 = i120 % 128;
                                    artificialFrame = i121;
                                    int i122 = i120 % 2;
                                    int i123 = ~i116;
                                    int i124 = ~iRequestPostMessageChannelWithExtras6;
                                    int i125 = ~(i123 | i124);
                                    int i126 = ~(((-34) ^ i116) | ((-34) & i116));
                                    int i127 = (i125 ^ i126) | (i126 & i125);
                                    int i128 = ~((i116 ^ iRequestPostMessageChannelWithExtras6) | (i116 & iRequestPostMessageChannelWithExtras6));
                                    int i129 = -(-((-338) * ((i127 ^ i128) | (i127 & i128))));
                                    int i130 = (((i118 ^ i129) + ((i129 & i118) << 1)) - (~((~((i123 ^ 33) | (i123 & 33))) * 338))) - 1;
                                    int i131 = i121 + 69;
                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i131 % 128;
                                    int i132 = i131 % 2;
                                    int i133 = ~((i123 ^ i124) | (i123 & i124));
                                    int i134 = (i116 & 33) | (i116 ^ 33);
                                    int i135 = ~((i134 & iRequestPostMessageChannelWithExtras6) | (i134 ^ iRequestPostMessageChannelWithExtras6));
                                    int i136 = -(-(338 * ((i135 & i133) | (i133 ^ i135))));
                                    Object[] objArr15 = new Object[1];
                                    a(((i130 | i136) << 1) - (i136 ^ i130), new int[]{1283055029, -1563759573, 1192496239, 849546927, -1718402627, -589372332, 1312310645, 796045153, -1928502247, 606161099, 1448895185, -859270913, -1380887705, 681496525, 1275823305, 117590244, 1013044180, -497172120}, objArr15);
                                    Class<?> cls3 = Class.forName((String) objArr15[0]);
                                    int i137 = -View.getDefaultSize(0, 0);
                                    Object[] objArr16 = new Object[1];
                                    b((i137 ^ 21727) + ((i137 & 21727) << 1), new char[]{59310, 45939, 19971, 6404, 46292, 20465, 6808, 46513, 16726, 7291, 46902, 16946, 7643, 43253}, objArr16);
                                    Object objInvoke3 = cls3.getMethod((String) objArr16[0], String.class, Integer.TYPE).invoke(objInvoke2, objArr14);
                                    int i138 = -KeyEvent.getDeadChar(0, 0);
                                    int i139 = (i138 * (-51)) + 1590;
                                    int i140 = artificialFrame;
                                    int i141 = (i140 ^ 113) + ((i140 & 113) << 1);
                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i141 % 128;
                                    int i142 = i141 % 2;
                                    int i143 = i64 | i138;
                                    int i144 = 52 * (~((i143 & 30) | (i143 ^ 30)));
                                    int i145 = (i139 ^ i144) + ((i139 & i144) << 1);
                                    int i146 = ~(((-31) & i97) | ((-31) ^ i97));
                                    int i147 = ~(((-31) & i138) | ((-31) ^ i138));
                                    int i148 = (i146 & i147) | (i146 ^ i147);
                                    int i149 = ~(i97 | i138);
                                    int i150 = -(-(((i148 & i149) | (i148 ^ i149)) * (-52)));
                                    int i151 = (i145 & i150) + (i150 | i145);
                                    int i152 = ~i138;
                                    int i153 = ~((i152 & i64) | (i152 ^ i64));
                                    int i154 = ~i138;
                                    int i155 = i151 + (((~((i154 & 30) | (i154 ^ 30))) | i153) * 52);
                                    Object[] objArr17 = new Object[1];
                                    a(i155, new int[]{1283055029, -1563759573, 1192496239, 849546927, -1718402627, -589372332, 1312310645, 796045153, -1928502247, 606161099, 1448895185, -859270913, -1737109768, 1463833155, 778605477, 592649728}, objArr17);
                                    Class<?> cls4 = Class.forName((String) objArr17[0]);
                                    int absoluteGravity = Gravity.getAbsoluteGravity(0, 0);
                                    int iRequestPostMessageChannelWithExtras7 = zzd.requestPostMessageChannelWithExtras();
                                    int i156 = absoluteGravity * (-244);
                                    int i157 = (i156 & 2460) + (i156 | 2460);
                                    int i158 = ~iRequestPostMessageChannelWithExtras7;
                                    int i159 = ~((i158 & (-11)) | ((-11) ^ i158));
                                    int i160 = ~((-11) | absoluteGravity);
                                    int i161 = i157 + (((i159 & i160) | (i159 ^ i160)) * (-245));
                                    int i162 = (~(((-11) ^ iRequestPostMessageChannelWithExtras7) | ((-11) & iRequestPostMessageChannelWithExtras7))) * (-245);
                                    int i163 = (i161 & i162) + (i162 | i161);
                                    int i164 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                    int i165 = ((i164 | AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY) << 1) - (i164 ^ AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY);
                                    artificialFrame = i165 % 128;
                                    int i166 = i165 % 2;
                                    int i167 = ~(iRequestPostMessageChannelWithExtras7 | (-11));
                                    int i168 = 245 * ((i167 & absoluteGravity) | (absoluteGravity ^ i167));
                                    Object[] objArr18 = new Object[1];
                                    a(((i163 | i168) << 1) - (i168 ^ i163), new int[]{487875689, -1230242912, 1934981276, -1472158937, 2126982559, -802208467}, objArr18);
                                    Object[] objArr19 = (Object[]) cls4.getField((String) objArr18[0]).get(objInvoke3);
                                    int length = objArr19.length;
                                    int i169 = 0;
                                    while (i169 < length) {
                                        Object obj2 = objArr19[i169];
                                        int i170 = -(-TextUtils.lastIndexOf("", '0'));
                                        Object[] objArr20 = new Object[i14];
                                        a(((i170 | 6) << i14) - (i170 ^ 6), new int[]{1630745790, -1837555381, -455178459, 1347043084}, objArr20);
                                        String str3 = (String) objArr20[0];
                                        int i171 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                        int i172 = (i171 ^ 23) + ((i171 & 23) << i14);
                                        artificialFrame = i172 % 128;
                                        int i173 = i172 % 2;
                                        try {
                                            Object[] objArr21 = {str3};
                                            int fadingEdgeLength = ViewConfiguration.getFadingEdgeLength() >> 16;
                                            int i174 = ~(((-1358569118) & i64) | ((-1358569118) ^ i64));
                                            int i175 = ((i174 & (-1410194087)) | ((-1410194087) ^ i174)) * (-865);
                                            int i176 = (1062837978 ^ i175) + ((i175 & 1062837978) << i14) + ((~((1358569117 ^ i) | (1358569117 & i))) * 865);
                                            int i177 = ~(((-1410194087) & i97) | ((-1410194087) ^ i97));
                                            int i178 = ~((1358569117 & i64) | (i64 ^ 1358569117));
                                            int i179 = ((i178 & i177) | (i177 ^ i178)) * 865;
                                            int i180 = ((i176 | i179) << i14) - (i176 ^ i179);
                                            int i181 = ~(((-910539894) & i64) | ((-910539894) ^ i64));
                                            int i182 = ~((1169340596 ^ i) | (1169340596 & i));
                                            int i183 = (-728273518) + (((i181 ^ i182) | (i181 & i182)) * 210);
                                            int i184 = ~(2012724469 | i64);
                                            int i185 = ~(((-67156021) ^ i) | ((-67156021) & i));
                                            int i186 = -(-(((i184 ^ i185) | (i184 & i185)) * 210));
                                            if (i180 > (i183 & i186) + (i186 | i183)) {
                                                i9 = (866 >> fadingEdgeLength) * (-901);
                                            } else {
                                                int i187 = fadingEdgeLength * 866;
                                                i9 = (i187 | (-31968)) + (i187 & (-31968));
                                            }
                                            int i188 = ~fadingEdgeLength;
                                            int i189 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                            int i190 = (i189 & 29) + (i189 | 29);
                                            artificialFrame = i190 % 128;
                                            int i191 = i190 % 2;
                                            int i192 = ~((i188 & i97) | (i188 ^ i97));
                                            int i193 = -(-((-865) * ((i192 & (-38)) | ((-38) ^ i192))));
                                            int i194 = ((((i9 | i193) << i14) - (i9 ^ i193)) - (~(-(-((~((fadingEdgeLength ^ i) | (fadingEdgeLength & i))) * 865))))) - i14;
                                            int i195 = ~(((-38) & i97) | ((-38) ^ i97));
                                            int i196 = ~(fadingEdgeLength | i64);
                                            int i197 = i194 + (((i196 & i195) | (i195 ^ i196)) * 865);
                                            Object[] objArr22 = new Object[i14];
                                            a(i197, new int[]{2141742366, 149152476, 1237246735, 259653581, 1029115830, -1288454701, 527217856, 606971965, 1344444776, -1113434690, 1530761326, 16636686, 1920420601, 320601217, -179572803, -1973015462, 1500242737, 1176495815, 493921267, 1144517822}, objArr22);
                                            Class<?> cls5 = Class.forName((String) objArr22[0]);
                                            int maximumDrawingCacheSize = ViewConfiguration.getMaximumDrawingCacheSize();
                                            int i198 = getARTIFICIAL_FRAME_PACKAGE_NAME + 19;
                                            int i199 = i198 % 128;
                                            artificialFrame = i199;
                                            int i200 = i198 % 2;
                                            int i201 = -(maximumDrawingCacheSize >> 24);
                                            int i202 = (i201 * 530) + 1058;
                                            int i203 = i199 + 1;
                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i203 % 128;
                                            if (i203 % 2 != 0) {
                                                int i204 = (i202 ^ 5830) + ((i202 & 5830) << 1);
                                                int i205 = ~((i64 ^ i201) | (i64 & i201));
                                                int i206 = ~((i201 ^ 11) | (i201 & 11));
                                                i10 = i204 >>> (529 >>> ((i205 ^ i206) | (i205 & i206)));
                                            } else {
                                                int i207 = ((i202 | 5830) << 1) - (i202 ^ 5830);
                                                int i208 = ~((i97 ^ i201) | (i97 & i201));
                                                int i209 = ~(i201 | 11);
                                                int i210 = -(-(((i208 ^ i209) | (i208 & i209)) * 529));
                                                i10 = ((i207 | i210) << 1) - (i207 ^ i210);
                                            }
                                            int i211 = i199 + 33;
                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i211 % 128;
                                            int i212 = i211 % 2;
                                            int i213 = ~((i201 & i) | (i201 ^ i));
                                            Object[] objArr23 = new Object[1];
                                            a(i10 + (529 * ((i213 & (-12)) | ((-12) ^ i213))), new int[]{1126897079, -2033415029, -2100261536, 1603176665, 300357326, -1745823483}, objArr23);
                                            Object objInvoke4 = cls5.getMethod((String) objArr23[0], String.class).invoke(null, objArr21);
                                            try {
                                                int iRed = Color.red(0);
                                                int iRequestPostMessageChannelWithExtras8 = zzd.requestPostMessageChannelWithExtras();
                                                int i214 = iRed * 677;
                                                int i215 = (((i214 & (-4099275)) + (i214 | (-4099275))) - (~((((iRed ^ iRequestPostMessageChannelWithExtras8) | (iRed & iRequestPostMessageChannelWithExtras8)) | (-6074)) * (-676)))) - 1;
                                                int i216 = ~((-6074) | iRed);
                                                int i217 = ~iRequestPostMessageChannelWithExtras8;
                                                int i218 = ~((i217 ^ iRed) | (i217 & iRed));
                                                int i219 = (i215 - (~(((i216 ^ i218) | (i216 & i218)) * 676))) - 1;
                                                int i220 = ~iRed;
                                                int i221 = ~((i220 & (-6074)) | (i220 ^ (-6074)));
                                                int i222 = ~((-6074) | (~iRequestPostMessageChannelWithExtras8));
                                                int i223 = (i221 ^ i222) | (i221 & i222);
                                                int i224 = (iRed & 6073) | (iRed ^ 6073);
                                                int i225 = ~((iRequestPostMessageChannelWithExtras8 & i224) | (i224 ^ iRequestPostMessageChannelWithExtras8));
                                                int i226 = -(-(((i225 & i223) | (i223 ^ i225)) * 676));
                                                Object[] objArr24 = new Object[1];
                                                b((i219 ^ i226) + ((i226 & i219) << 1), new char[]{59304, 61470, 51423, 41104, 47426, 37181, 27131, 16872, 23138, 12839, 2717, 58190, 64256, 54210, 43939, 33840, 39977, 29933, 19685, 9505, 15828, 5507, 60993, 50743, 57061, 46765, 36721, 26415}, objArr24);
                                                Class<?> cls6 = Class.forName((String) objArr24[0]);
                                                int i227 = -Process.getGidForName("");
                                                int iRequestPostMessageChannelWithExtras9 = zzd.requestPostMessageChannelWithExtras();
                                                int i228 = (i227 * 934) - 9320;
                                                int i229 = ~i227;
                                                Object[] objArr25 = objArr19;
                                                int i230 = ~iRequestPostMessageChannelWithExtras9;
                                                int i231 = ~((i229 ^ i230) | (i230 & i229));
                                                int i232 = -(-((((-11) ^ i231) | (i231 & (-11))) * (-933)));
                                                int i233 = (i228 & i232) + (i232 | i228);
                                                int i234 = ~((~iRequestPostMessageChannelWithExtras9) | (-11));
                                                int i235 = ~(((-11) & i227) | ((-11) ^ i227));
                                                int i236 = ((i234 & i235) | (i234 ^ i235)) * 933;
                                                int i237 = (i233 ^ i236) + ((i233 & i236) << 1);
                                                int i238 = (~(i227 | 10)) * 933;
                                                Object[] objArr26 = new Object[1];
                                                a((i237 ^ i238) + ((i238 & i237) << 1), new int[]{784023543, -1555184755, 466179605, -1352688316, -1532850708, 1097359151}, objArr26);
                                                try {
                                                    Object[] objArr27 = {new ByteArrayInputStream((byte[]) cls6.getMethod((String) objArr26[0], null).invoke(obj2, null))};
                                                    Object[] objArr28 = new Object[1];
                                                    a(37 - KeyEvent.getDeadChar(0, 0), new int[]{2141742366, 149152476, 1237246735, 259653581, 1029115830, -1288454701, 527217856, 606971965, 1344444776, -1113434690, 1530761326, 16636686, 1920420601, 320601217, -179572803, -1973015462, 1500242737, 1176495815, 493921267, 1144517822}, objArr28);
                                                    Class<?> cls7 = Class.forName((String) objArr28[0]);
                                                    int i239 = -(ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                                                    Object[] objArr29 = new Object[1];
                                                    a((i239 ^ 20) + ((i239 & 20) << 1), new int[]{-1723232562, 150375267, 111194310, 1416200615, -1952686048, -1959898021, 1353797707, -828567379, 342832386, 1521161090}, objArr29);
                                                    Object objInvoke5 = cls7.getMethod((String) objArr29[0], InputStream.class).invoke(objInvoke4, objArr27);
                                                    int length2 = objArr3.length;
                                                    int i240 = 0;
                                                    for (int i241 = 2; i240 < i241; i241 = 2) {
                                                        Object obj3 = objArr3[i240];
                                                        try {
                                                            Object[] objArr30 = new Object[1];
                                                            a(32 - (~(AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))), new int[]{2141742366, 149152476, 1237246735, 259653581, 1029115830, -1288454701, 527217856, 606971965, -492072776, -460675442, -170754726, 303500173, 1530761326, 16636686, 1920420601, 320601217, 1345726520, 1705527465}, objArr30);
                                                            Class<?> cls8 = Class.forName((String) objArr30[0]);
                                                            int i242 = artificialFrame;
                                                            int i243 = (i242 & 113) + (i242 | 113);
                                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i243 % 128;
                                                            int i244 = i243 % 2;
                                                            int i245 = -View.combineMeasuredStates(0, 0);
                                                            Object[] objArr31 = new Object[1];
                                                            a((i245 ^ 23) + ((i245 & 23) << 1), new int[]{-799093521, 1778839409, 1847423612, -1767228610, -431027199, 1680624733, 797277854, 1067952591, -924519403, -1547532022, -1983180041, 449400616}, objArr31);
                                                            String str4 = (String) objArr31[0];
                                                            int i246 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                            int i247 = ((i246 | 3) << 1) - (i246 ^ 3);
                                                            artificialFrame = i247 % 128;
                                                            int i248 = i247 % 2;
                                                            if (obj3.equals(cls8.getMethod(str4, null).invoke(objInvoke5, null))) {
                                                                Object[] objArr32 = {new int[]{i}, new int[]{(i & (-2)) | (i64 & 1)}, new int[1], null};
                                                                int startElapsedRealtime2 = (int) Process.getStartElapsedRealtime();
                                                                int i249 = ~startElapsedRealtime2;
                                                                int i250 = 833097086 + (((~(i249 | 234604206)) | (~((-744019569) | i249)) | 536875088) * 464) + (((-207144481) | startElapsedRealtime2) * (-464)) + (((~(startElapsedRealtime2 | 234604206)) | 536875088) * 464) + 16;
                                                                int iRequestPostMessageChannelWithExtras10 = zzd.requestPostMessageChannelWithExtras();
                                                                int i251 = (i250 * 236) + (i2 * 471);
                                                                int i252 = ~i250;
                                                                int i253 = ~iRequestPostMessageChannelWithExtras10;
                                                                int i254 = ~((i252 & i253) | (i252 ^ i253));
                                                                int i255 = -(-(((i254 & i2) | (i2 ^ i254)) * (-235)));
                                                                int i256 = (i251 & i255) + (i251 | i255);
                                                                int i257 = ~i250;
                                                                int i258 = ~((i257 ^ iRequestPostMessageChannelWithExtras10) | (i257 & iRequestPostMessageChannelWithExtras10));
                                                                int i259 = -(-(((i258 & i2) | (i2 ^ i258)) * (-470)));
                                                                int i260 = (i256 ^ i259) + ((i259 & i256) << 1);
                                                                int i261 = ~i2;
                                                                int i262 = (i257 & i2) | (i257 ^ i2);
                                                                int i263 = ((~((iRequestPostMessageChannelWithExtras10 & i262) | (i262 ^ iRequestPostMessageChannelWithExtras10))) | (~((i250 & i261) | (i261 ^ i250)))) * 235;
                                                                int i264 = (i260 & i263) + (i263 | i260);
                                                                int i265 = i264 << 13;
                                                                int i266 = (i265 & (~i264)) | ((~i265) & i264);
                                                                int i267 = i266 >>> 17;
                                                                int i268 = ((~i266) & i267) | ((~i267) & i266);
                                                                ((int[]) objArr32[2])[0] = i268 ^ (i268 << 5);
                                                                return objArr32;
                                                            }
                                                            i240 = ((i240 | 1) << 1) - (i240 ^ 1);
                                                        } catch (Throwable th) {
                                                            Throwable cause = th.getCause();
                                                            if (cause != null) {
                                                                throw cause;
                                                            }
                                                            throw th;
                                                        }
                                                    }
                                                    i169 = ((i169 | 1) << 1) - (i169 ^ 1);
                                                    objArr19 = objArr25;
                                                    i14 = 1;
                                                } catch (Throwable th2) {
                                                    Throwable cause2 = th2.getCause();
                                                    if (cause2 != null) {
                                                        throw cause2;
                                                    }
                                                    throw th2;
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
                                    Object[] objArr33 = {new int[]{i}, new int[]{i}, new int[1], null};
                                    int i269 = ~i;
                                    int i270 = (~((-207530392) | i269)) | 206872967;
                                    int i271 = ~(i | 771750807);
                                    int i272 = ((i270 | i271) * (-252)) + 1571003906 + ((i271 | (~(i269 | (-657425)))) * 252);
                                    int iRequestPostMessageChannelWithExtras11 = zzd.requestPostMessageChannelWithExtras();
                                    int i273 = (-1) - (~(i272 * (-216)));
                                    int i274 = ~iRequestPostMessageChannelWithExtras11;
                                    int i275 = ~i272;
                                    int i276 = -(-((~((i275 & iRequestPostMessageChannelWithExtras11) | (i275 ^ iRequestPostMessageChannelWithExtras11))) * JfifUtil.MARKER_EOI));
                                    int i277 = (i273 & i276) + (i273 | i276);
                                    int i278 = ~i272;
                                    int i279 = -(-(((~(iRequestPostMessageChannelWithExtras11 | ((-1) ^ iRequestPostMessageChannelWithExtras11))) | (~(((-1) ^ i278) | i278))) * JfifUtil.MARKER_EOI));
                                    int i280 = (i277 & i279) + (i279 | i277) + ((~((i278 ^ i274) | (i278 & i274))) * JfifUtil.MARKER_EOI);
                                    int i281 = (i2 & i280) + (i2 | i280);
                                    int i282 = i281 ^ (i281 << 13);
                                    int i283 = i282 >>> 17;
                                    int i284 = ((~i282) & i283) | ((~i283) & i282);
                                    ((int[]) objArr33[2])[0] = i284 ^ (i284 << 5);
                                    return objArr33;
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
        }
    }

    public final LoginTargetApp getLoginTargetApp() {
        return this.loginTargetApp;
    }

    public final boolean isFamilyLogin() {
        return this.isFamilyLogin;
    }

    public final boolean getShouldSkipAccountDeduplication() {
        return this.shouldSkipAccountDeduplication;
    }

    public final void resolveError(@NotNull Activity activity, @NotNull GraphResponse response) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(response, "response");
        startLogin(new ActivityStartActivityDelegate(activity), createLoginRequestFromResponse(response));
    }

    @Deprecated(message = "")
    public final void resolveError(@NotNull Fragment fragment, @NotNull GraphResponse response) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(response, "response");
        resolveError(new FragmentWrapper(fragment), response);
    }

    public final void resolveError(@NotNull Fragment fragment, @NotNull CallbackManager callbackManager, @NotNull GraphResponse response) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(callbackManager, "callbackManager");
        Intrinsics.checkNotNullParameter(response, "response");
        FragmentActivity activity = fragment.getActivity();
        if (activity != null) {
            resolveError(activity, callbackManager, response);
            return;
        }
        throw new FacebookException("Cannot obtain activity context on the fragment " + fragment);
    }

    public final void resolveError(@NotNull android.app.Fragment fragment, @NotNull GraphResponse response) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(response, "response");
        resolveError(new FragmentWrapper(fragment), response);
    }

    private final void resolveError(FragmentWrapper fragmentWrapper, GraphResponse graphResponse) {
        startLogin(new FragmentStartActivityDelegate(fragmentWrapper), createLoginRequestFromResponse(graphResponse));
    }

    public final void resolveError(@NotNull ActivityResultRegistryOwner activityResultRegistryOwner, @NotNull CallbackManager callbackManager, @NotNull GraphResponse response) {
        Intrinsics.checkNotNullParameter(activityResultRegistryOwner, "activityResultRegistryOwner");
        Intrinsics.checkNotNullParameter(callbackManager, "callbackManager");
        Intrinsics.checkNotNullParameter(response, "response");
        startLogin(new AndroidxActivityResultRegistryOwnerStartActivityDelegate(activityResultRegistryOwner, callbackManager), createLoginRequestFromResponse(response));
    }

    private final LoginClient.Request createLoginRequestFromResponse(GraphResponse graphResponse) {
        Set<String> permissions;
        AccessToken accessToken = graphResponse.getRequest().getAccessToken();
        return createLoginRequest((accessToken == null || (permissions = accessToken.getPermissions()) == null) ? null : CollectionsKt___CollectionsKt.filterNotNull(permissions));
    }

    public final void registerCallback(@Nullable CallbackManager callbackManager, @Nullable final FacebookCallback<LoginResult> facebookCallback) {
        if (!(callbackManager instanceof CallbackManagerImpl)) {
            throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
        }
        ((CallbackManagerImpl) callbackManager).registerCallback(CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode(), new CallbackManagerImpl.Callback() { // from class: com.facebook.login.LoginManager$$ExternalSyntheticLambda0
            @Override // com.facebook.internal.CallbackManagerImpl.Callback
            public final boolean onActivityResult(int i, Intent intent) {
                return LoginManager.registerCallback$lambda$0(this.f$0, facebookCallback, i, intent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean registerCallback$lambda$0(LoginManager this$0, FacebookCallback facebookCallback, int i, Intent intent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return this$0.onActivityResult(i, intent, facebookCallback);
    }

    public final void unregisterCallback(@Nullable CallbackManager callbackManager) {
        if (!(callbackManager instanceof CallbackManagerImpl)) {
            throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
        }
        ((CallbackManagerImpl) callbackManager).unregisterCallback(CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean onActivityResult$default(LoginManager loginManager, int i, Intent intent, FacebookCallback facebookCallback, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onActivityResult");
        }
        if ((i2 & 4) != 0) {
            facebookCallback = null;
        }
        return loginManager.onActivityResult(i, intent, facebookCallback);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0055  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [com.facebook.FacebookException, java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r16v0, types: [com.facebook.login.LoginManager] */
    /* JADX WARN: Type inference failed for: r9v1, types: [com.facebook.AccessToken] */
    public boolean onActivityResult(int i, @Nullable Intent intent, @Nullable FacebookCallback<LoginResult> facebookCallback) {
        LoginClient.Result.Code code;
        boolean z;
        Object obj;
        AuthenticationToken authenticationToken;
        LoginClient.Request request;
        Map<String, String> map;
        FacebookAuthorizationException facebookAuthorizationException;
        AuthenticationToken authenticationToken2;
        LoginClient.Result.Code code2 = LoginClient.Result.Code.ERROR;
        Object facebookException = null;
        boolean z2 = false;
        if (intent != null) {
            intent.setExtrasClassLoader(LoginClient.Result.class.getClassLoader());
            LoginClient.Result result = (LoginClient.Result) intent.getParcelableExtra(LoginFragment.RESULT_KEY);
            if (result != null) {
                request = result.request;
                LoginClient.Result.Code code3 = result.code;
                if (i != -1) {
                    z2 = i == 0;
                    facebookAuthorizationException = null;
                    authenticationToken2 = null;
                } else if (code3 == LoginClient.Result.Code.SUCCESS) {
                    AccessToken accessToken = result.token;
                    authenticationToken2 = result.authenticationToken;
                    facebookException = accessToken;
                    facebookAuthorizationException = null;
                } else {
                    facebookAuthorizationException = new FacebookAuthorizationException(result.errorMessage);
                    authenticationToken2 = null;
                }
                map = result.loggingExtras;
                z = z2;
                authenticationToken = authenticationToken2;
                code = code3;
                Object obj2 = facebookException;
                facebookException = facebookAuthorizationException;
                obj = obj2;
            } else {
                code = code2;
                obj = null;
                authenticationToken = null;
                request = null;
                map = null;
                z = false;
            }
        } else if (i == 0) {
            code = LoginClient.Result.Code.CANCEL;
            z = true;
            obj = null;
            authenticationToken = null;
            request = null;
            map = null;
        } else {
            code = code2;
            obj = null;
            authenticationToken = null;
            request = null;
            map = null;
            z = false;
        }
        if (facebookException == null && obj == null && !z) {
            facebookException = new FacebookException("Unexpected call to LoginManager.onActivityResult");
        }
        ?? r12 = facebookException;
        LoginClient.Request request2 = request;
        logCompleteLogin(null, code, map, r12, true, request2);
        finishLogin(obj, authenticationToken, request2, r12, z, facebookCallback);
        return true;
    }

    public final LoginManager setLoginBehavior(@NotNull LoginBehavior loginBehavior) {
        Intrinsics.checkNotNullParameter(loginBehavior, "loginBehavior");
        this.loginBehavior = loginBehavior;
        return this;
    }

    public final LoginManager setLoginTargetApp(@NotNull LoginTargetApp targetApp) {
        Intrinsics.checkNotNullParameter(targetApp, "targetApp");
        this.loginTargetApp = targetApp;
        return this;
    }

    public final LoginManager setDefaultAudience(@NotNull DefaultAudience defaultAudience) {
        Intrinsics.checkNotNullParameter(defaultAudience, "defaultAudience");
        this.defaultAudience = defaultAudience;
        return this;
    }

    public final LoginManager setAuthType(@NotNull String authType) {
        Intrinsics.checkNotNullParameter(authType, "authType");
        this.authType = authType;
        return this;
    }

    public final LoginManager setMessengerPageId(@Nullable String str) {
        this.messengerPageId = str;
        return this;
    }

    public final LoginManager setResetMessengerState(boolean z) {
        this.resetMessengerState = z;
        return this;
    }

    public final LoginManager setFamilyLogin(boolean z) {
        this.isFamilyLogin = z;
        return this;
    }

    public final LoginManager setShouldSkipAccountDeduplication(boolean z) {
        this.shouldSkipAccountDeduplication = z;
        return this;
    }

    public void logOut() {
        AccessToken.Companion.setCurrentAccessToken(null);
        AuthenticationToken.Companion.setCurrentAuthenticationToken(null);
        Profile.Companion.setCurrentProfile(null);
        setExpressLoginStatus(false);
    }

    public final void retrieveLoginStatus(@NotNull Context context, @NotNull LoginStatusCallback responseCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(responseCallback, "responseCallback");
        retrieveLoginStatus(context, 5000L, responseCallback);
    }

    public final void retrieveLoginStatus(@NotNull Context context, long j, @NotNull LoginStatusCallback responseCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(responseCallback, "responseCallback");
        retrieveLoginStatusImpl(context, responseCallback, j);
    }

    @Deprecated(message = "")
    public final void logInWithReadPermissions(@NotNull Fragment fragment, @NotNull Collection<String> permissions) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        logInWithReadPermissions(new FragmentWrapper(fragment), permissions);
    }

    public final void logInWithReadPermissions(@NotNull Fragment fragment, @NotNull CallbackManager callbackManager, @NotNull Collection<String> permissions) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(callbackManager, "callbackManager");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        FragmentActivity activity = fragment.getActivity();
        if (activity != null) {
            logInWithReadPermissions(activity, callbackManager, permissions);
            return;
        }
        throw new FacebookException("Cannot obtain activity context on the fragment " + fragment);
    }

    public final void logInWithReadPermissions(@NotNull android.app.Fragment fragment, @NotNull Collection<String> permissions) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        logInWithReadPermissions(new FragmentWrapper(fragment), permissions);
    }

    private final void logInWithReadPermissions(FragmentWrapper fragmentWrapper, Collection<String> collection) {
        validateReadPermissions(collection);
        logIn(fragmentWrapper, new LoginConfiguration(collection, null, 2, null));
    }

    public final void logInWithReadPermissions(@NotNull Activity activity, @Nullable Collection<String> collection) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        validateReadPermissions(collection);
        logIn(activity, new LoginConfiguration(collection, null, 2, null));
    }

    public final void logInWithReadPermissions(@NotNull ActivityResultRegistryOwner activityResultRegistryOwner, @NotNull CallbackManager callbackManager, @NotNull Collection<String> permissions) {
        Intrinsics.checkNotNullParameter(activityResultRegistryOwner, "activityResultRegistryOwner");
        Intrinsics.checkNotNullParameter(callbackManager, "callbackManager");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        validateReadPermissions(permissions);
        logIn(activityResultRegistryOwner, callbackManager, new LoginConfiguration(permissions, null, 2, null));
    }

    public final void logInWithConfiguration(@NotNull Fragment fragment, @NotNull LoginConfiguration loginConfig) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(loginConfig, "loginConfig");
        loginWithConfiguration(new FragmentWrapper(fragment), loginConfig);
    }

    private final void loginWithConfiguration(FragmentWrapper fragmentWrapper, LoginConfiguration loginConfiguration) {
        logIn(fragmentWrapper, loginConfiguration);
    }

    public final void loginWithConfiguration(@NotNull Activity activity, @NotNull LoginConfiguration loginConfig) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(loginConfig, "loginConfig");
        logIn(activity, loginConfig);
    }

    public final void reauthorizeDataAccess(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        startLogin(new ActivityStartActivityDelegate(activity), createReauthorizeRequest());
    }

    public final void reauthorizeDataAccess(@NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        reauthorizeDataAccess(new FragmentWrapper(fragment));
    }

    private final void reauthorizeDataAccess(FragmentWrapper fragmentWrapper) {
        startLogin(new FragmentStartActivityDelegate(fragmentWrapper), createReauthorizeRequest());
    }

    @Deprecated(message = "")
    public final void logInWithPublishPermissions(@NotNull Fragment fragment, @NotNull Collection<String> permissions) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        logInWithPublishPermissions(new FragmentWrapper(fragment), permissions);
    }

    public final void logInWithPublishPermissions(@NotNull Fragment fragment, @NotNull CallbackManager callbackManager, @NotNull Collection<String> permissions) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(callbackManager, "callbackManager");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        FragmentActivity activity = fragment.getActivity();
        if (activity != null) {
            logInWithPublishPermissions(activity, callbackManager, permissions);
            return;
        }
        throw new FacebookException("Cannot obtain activity context on the fragment " + fragment);
    }

    public final void logInWithPublishPermissions(@NotNull android.app.Fragment fragment, @NotNull Collection<String> permissions) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        logInWithPublishPermissions(new FragmentWrapper(fragment), permissions);
    }

    private final void logInWithPublishPermissions(FragmentWrapper fragmentWrapper, Collection<String> collection) {
        validatePublishPermissions(collection);
        loginWithConfiguration(fragmentWrapper, new LoginConfiguration(collection, null, 2, null));
    }

    public final void logInWithPublishPermissions(@NotNull Activity activity, @Nullable Collection<String> collection) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        validatePublishPermissions(collection);
        loginWithConfiguration(activity, new LoginConfiguration(collection, null, 2, null));
    }

    public final void logInWithPublishPermissions(@NotNull ActivityResultRegistryOwner activityResultRegistryOwner, @NotNull CallbackManager callbackManager, @NotNull Collection<String> permissions) {
        Intrinsics.checkNotNullParameter(activityResultRegistryOwner, "activityResultRegistryOwner");
        Intrinsics.checkNotNullParameter(callbackManager, "callbackManager");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        validatePublishPermissions(permissions);
        logIn(activityResultRegistryOwner, callbackManager, new LoginConfiguration(permissions, null, 2, null));
    }

    public final void logIn(@NotNull Fragment fragment, @Nullable Collection<String> collection) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        logIn(new FragmentWrapper(fragment), collection);
    }

    public final void logIn(@NotNull Fragment fragment, @Nullable Collection<String> collection, @Nullable String str) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        logIn(new FragmentWrapper(fragment), collection, str);
    }

    public final void logIn(@NotNull android.app.Fragment fragment, @Nullable Collection<String> collection) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        logIn(new FragmentWrapper(fragment), collection);
    }

    public final void logIn(@NotNull android.app.Fragment fragment, @Nullable Collection<String> collection, @Nullable String str) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        logIn(new FragmentWrapper(fragment), collection, str);
    }

    public final void logIn(@NotNull FragmentWrapper fragment, @Nullable Collection<String> collection) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        logIn(fragment, new LoginConfiguration(collection, null, 2, null));
    }

    public final void logIn(@NotNull FragmentWrapper fragment, @Nullable Collection<String> collection, @Nullable String str) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        LoginClient.Request requestCreateLoginRequestWithConfig = createLoginRequestWithConfig(new LoginConfiguration(collection, null, 2, null));
        if (str != null) {
            requestCreateLoginRequestWithConfig.setAuthId(str);
        }
        startLogin(new FragmentStartActivityDelegate(fragment), requestCreateLoginRequestWithConfig);
    }

    public final void logIn(@NotNull Activity activity, @Nullable Collection<String> collection) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        logIn(activity, new LoginConfiguration(collection, null, 2, null));
    }

    public final void logIn(@NotNull FragmentWrapper fragment, @NotNull LoginConfiguration loginConfig) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(loginConfig, "loginConfig");
        startLogin(new FragmentStartActivityDelegate(fragment), createLoginRequestWithConfig(loginConfig));
    }

    public final void logIn(@NotNull Activity activity, @NotNull LoginConfiguration loginConfig) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(loginConfig, "loginConfig");
        if (activity instanceof ActivityResultRegistryOwner) {
            SentryLogcatAdapter.w(TAG, "You're calling logging in Facebook with an activity supports androidx activity result APIs. Please follow our document to upgrade to new APIs to avoid overriding onActivityResult().");
        }
        startLogin(new ActivityStartActivityDelegate(activity), createLoginRequestWithConfig(loginConfig));
    }

    public final void logIn(@NotNull Activity activity, @Nullable Collection<String> collection, @Nullable String str) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        LoginClient.Request requestCreateLoginRequestWithConfig = createLoginRequestWithConfig(new LoginConfiguration(collection, null, 2, null));
        if (str != null) {
            requestCreateLoginRequestWithConfig.setAuthId(str);
        }
        startLogin(new ActivityStartActivityDelegate(activity), requestCreateLoginRequestWithConfig);
    }

    private final void logIn(ActivityResultRegistryOwner activityResultRegistryOwner, CallbackManager callbackManager, LoginConfiguration loginConfiguration) {
        startLogin(new AndroidxActivityResultRegistryOwnerStartActivityDelegate(activityResultRegistryOwner, callbackManager), createLoginRequestWithConfig(loginConfiguration));
    }

    public final void logIn(@NotNull ActivityResultRegistryOwner activityResultRegistryOwner, @NotNull CallbackManager callbackManager, @NotNull Collection<String> permissions, @Nullable String str) {
        Intrinsics.checkNotNullParameter(activityResultRegistryOwner, "activityResultRegistryOwner");
        Intrinsics.checkNotNullParameter(callbackManager, "callbackManager");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        LoginClient.Request requestCreateLoginRequestWithConfig = createLoginRequestWithConfig(new LoginConfiguration(permissions, null, 2, null));
        if (str != null) {
            requestCreateLoginRequestWithConfig.setAuthId(str);
        }
        startLogin(new AndroidxActivityResultRegistryOwnerStartActivityDelegate(activityResultRegistryOwner, callbackManager), requestCreateLoginRequestWithConfig);
    }

    public final void logIn(@NotNull ActivityResultRegistryOwner activityResultRegistryOwner, @NotNull CallbackManager callbackManager, @NotNull Collection<String> permissions) {
        Intrinsics.checkNotNullParameter(activityResultRegistryOwner, "activityResultRegistryOwner");
        Intrinsics.checkNotNullParameter(callbackManager, "callbackManager");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        logIn(activityResultRegistryOwner, callbackManager, new LoginConfiguration(permissions, null, 2, null));
    }

    public static /* synthetic */ FacebookLoginActivityResultContract createLogInActivityResultContract$default(LoginManager loginManager, CallbackManager callbackManager, String str, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createLogInActivityResultContract");
        }
        if ((i & 1) != 0) {
            callbackManager = null;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        return loginManager.createLogInActivityResultContract(callbackManager, str);
    }

    public final FacebookLoginActivityResultContract createLogInActivityResultContract(@Nullable CallbackManager callbackManager, @Nullable String str) {
        return new FacebookLoginActivityResultContract(callbackManager, str);
    }

    private final void validateReadPermissions(Collection<String> collection) {
        if (collection == null) {
            return;
        }
        for (String str : collection) {
            if (Companion.isPublishPermission(str)) {
                throw new FacebookException("Cannot pass a publish or manage permission (" + str + ") to a request for read authorization");
            }
        }
    }

    private final void validatePublishPermissions(Collection<String> collection) {
        if (collection == null) {
            return;
        }
        for (String str : collection) {
            if (!Companion.isPublishPermission(str)) {
                throw new FacebookException("Cannot pass a read permission (" + str + ") to a request for publish authorization");
            }
        }
    }

    protected LoginClient.Request createLoginRequestWithConfig(@NotNull LoginConfiguration loginConfig) {
        String codeVerifier;
        Intrinsics.checkNotNullParameter(loginConfig, "loginConfig");
        CodeChallengeMethod codeChallengeMethod = CodeChallengeMethod.S256;
        try {
            codeVerifier = PKCEUtil.generateCodeChallenge(loginConfig.getCodeVerifier(), codeChallengeMethod);
        } catch (FacebookException unused) {
            codeChallengeMethod = CodeChallengeMethod.PLAIN;
            codeVerifier = loginConfig.getCodeVerifier();
        }
        LoginBehavior loginBehavior = this.loginBehavior;
        Set set = CollectionsKt___CollectionsKt.toSet(loginConfig.getPermissions());
        DefaultAudience defaultAudience = this.defaultAudience;
        String str = this.authType;
        String applicationId = FacebookSdk.getApplicationId();
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
        LoginTargetApp loginTargetApp = this.loginTargetApp;
        String nonce = loginConfig.getNonce();
        String codeVerifier2 = loginConfig.getCodeVerifier();
        LoginClient.Request request = new LoginClient.Request(loginBehavior, set, defaultAudience, str, applicationId, string, loginTargetApp, nonce, codeVerifier2, codeVerifier, codeChallengeMethod);
        request.setRerequest(AccessToken.Companion.isCurrentAccessTokenActive());
        request.setMessengerPageId(this.messengerPageId);
        request.setResetMessengerState(this.resetMessengerState);
        request.setFamilyLogin(this.isFamilyLogin);
        request.setShouldSkipAccountDeduplication(this.shouldSkipAccountDeduplication);
        return request;
    }

    protected LoginClient.Request createLoginRequest(@Nullable Collection<String> collection) {
        LoginBehavior loginBehavior = this.loginBehavior;
        Set set = collection != null ? CollectionsKt___CollectionsKt.toSet(collection) : null;
        DefaultAudience defaultAudience = this.defaultAudience;
        String str = this.authType;
        String applicationId = FacebookSdk.getApplicationId();
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
        LoginClient.Request request = new LoginClient.Request(loginBehavior, set, defaultAudience, str, applicationId, string, this.loginTargetApp, null, null, null, null, 1920, null);
        request.setRerequest(AccessToken.Companion.isCurrentAccessTokenActive());
        request.setMessengerPageId(this.messengerPageId);
        request.setResetMessengerState(this.resetMessengerState);
        request.setFamilyLogin(this.isFamilyLogin);
        request.setShouldSkipAccountDeduplication(this.shouldSkipAccountDeduplication);
        return request;
    }

    protected LoginClient.Request createReauthorizeRequest() {
        LoginBehavior loginBehavior = LoginBehavior.DIALOG_ONLY;
        HashSet hashSet = new HashSet();
        DefaultAudience defaultAudience = this.defaultAudience;
        String applicationId = FacebookSdk.getApplicationId();
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
        LoginClient.Request request = new LoginClient.Request(loginBehavior, hashSet, defaultAudience, "reauthorize", applicationId, string, this.loginTargetApp, null, null, null, null, 1920, null);
        request.setFamilyLogin(this.isFamilyLogin);
        request.setShouldSkipAccountDeduplication(this.shouldSkipAccountDeduplication);
        return request;
    }

    private final void startLogin(StartActivityDelegate startActivityDelegate, LoginClient.Request request) throws FacebookException {
        logStartLogin(startActivityDelegate.getActivityContext(), request);
        CallbackManagerImpl.Companion.registerStaticCallback(CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode(), new CallbackManagerImpl.Callback() { // from class: com.facebook.login.LoginManager$$ExternalSyntheticLambda2
            @Override // com.facebook.internal.CallbackManagerImpl.Callback
            public final boolean onActivityResult(int i, Intent intent) {
                return LoginManager.startLogin$lambda$1(this.f$0, i, intent);
            }
        });
        if (tryFacebookActivity(startActivityDelegate, request)) {
            return;
        }
        FacebookException facebookException = new FacebookException("Log in attempt failed: FacebookActivity could not be started. Please make sure you added FacebookActivity to the AndroidManifest.");
        logCompleteLogin(startActivityDelegate.getActivityContext(), LoginClient.Result.Code.ERROR, null, facebookException, false, request);
        throw facebookException;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean startLogin$lambda$1(LoginManager this$0, int i, Intent intent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return onActivityResult$default(this$0, i, intent, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void logStartLogin(Context context, LoginClient.Request request) {
        LoginLogger logger = LoginLoggerHolder.INSTANCE.getLogger(context);
        if (logger == null || request == null) {
            return;
        }
        logger.logStartLogin(request, request.isFamilyLogin() ? LoginLogger.EVENT_NAME_FOA_LOGIN_START : LoginLogger.EVENT_NAME_LOGIN_START);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void logCompleteLogin(Context context, LoginClient.Result.Code code, Map<String, String> map, Exception exc, boolean z, LoginClient.Request request) {
        String str;
        LoginLogger logger = LoginLoggerHolder.INSTANCE.getLogger(context);
        if (logger == null) {
            return;
        }
        if (request == null) {
            LoginLogger.logUnexpectedError$default(logger, LoginLogger.EVENT_NAME_LOGIN_COMPLETE, "Unexpected call to logCompleteLogin with null pendingAuthorizationRequest.", null, 4, null);
            return;
        }
        HashMap map2 = new HashMap();
        if (z) {
            str = AppEventsConstants.EVENT_PARAM_VALUE_YES;
        } else {
            str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
        map2.put(LoginLogger.EVENT_EXTRAS_TRY_LOGIN_ACTIVITY, str);
        logger.logCompleteLogin(request.getAuthId(), map2, code, map, exc, request.isFamilyLogin() ? LoginLogger.EVENT_NAME_FOA_LOGIN_COMPLETE : LoginLogger.EVENT_NAME_LOGIN_COMPLETE);
    }

    private final boolean tryFacebookActivity(StartActivityDelegate startActivityDelegate, LoginClient.Request request) {
        Intent facebookActivityIntent = getFacebookActivityIntent(request);
        if (!resolveIntent(facebookActivityIntent)) {
            return false;
        }
        try {
            startActivityDelegate.startActivityForResult(facebookActivityIntent, LoginClient.Companion.getLoginRequestCode());
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean resolveIntent(Intent intent) {
        return FacebookSdk.getApplicationContext().getPackageManager().resolveActivity(intent, 0) != null;
    }

    protected Intent getFacebookActivityIntent(@NotNull LoginClient.Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intent intent = new Intent();
        intent.setClass(FacebookSdk.getApplicationContext(), FacebookActivity.class);
        intent.setAction(request.getLoginBehavior().toString());
        Bundle bundle = new Bundle();
        bundle.putParcelable("request", request);
        intent.putExtra(LoginFragment.REQUEST_KEY, bundle);
        return intent;
    }

    private final void finishLogin(AccessToken accessToken, AuthenticationToken authenticationToken, LoginClient.Request request, FacebookException facebookException, boolean z, FacebookCallback<LoginResult> facebookCallback) {
        if (accessToken != null) {
            AccessToken.Companion.setCurrentAccessToken(accessToken);
            Profile.Companion.fetchProfileForCurrentAccessToken();
        }
        if (authenticationToken != null) {
            AuthenticationToken.Companion.setCurrentAuthenticationToken(authenticationToken);
        }
        if (facebookCallback != null) {
            LoginResult loginResultComputeLoginResult = (accessToken == null || request == null) ? null : Companion.computeLoginResult(request, accessToken, authenticationToken);
            if (z || (loginResultComputeLoginResult != null && loginResultComputeLoginResult.getRecentlyGrantedPermissions().isEmpty())) {
                facebookCallback.onCancel();
                return;
            }
            if (facebookException != null) {
                facebookCallback.onError(facebookException);
            } else {
                if (accessToken == null || loginResultComputeLoginResult == null) {
                    return;
                }
                setExpressLoginStatus(true);
                facebookCallback.onSuccess(loginResultComputeLoginResult);
            }
        }
    }

    private final void retrieveLoginStatusImpl(Context context, final LoginStatusCallback loginStatusCallback, long j) {
        final String applicationId = FacebookSdk.getApplicationId();
        final String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
        final LoginLogger loginLogger = new LoginLogger(context == null ? FacebookSdk.getApplicationContext() : context, applicationId);
        if (!isExpressLoginAllowed()) {
            loginLogger.logLoginStatusFailure(string);
            loginStatusCallback.onFailure();
            return;
        }
        LoginStatusClient loginStatusClientNewInstance$facebook_common_release = LoginStatusClient.Companion.newInstance$facebook_common_release(context, applicationId, string, FacebookSdk.getGraphApiVersion(), j, null);
        loginStatusClientNewInstance$facebook_common_release.setCompletedListener(new PlatformServiceClient.CompletedListener() { // from class: com.facebook.login.LoginManager$$ExternalSyntheticLambda1
            @Override // com.facebook.internal.PlatformServiceClient.CompletedListener
            public final void completed(Bundle bundle) {
                LoginManager.retrieveLoginStatusImpl$lambda$2(string, loginLogger, loginStatusCallback, applicationId, bundle);
            }
        });
        loginLogger.logLoginStatusStart(string);
        if (loginStatusClientNewInstance$facebook_common_release.start()) {
            return;
        }
        loginLogger.logLoginStatusFailure(string);
        loginStatusCallback.onFailure();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void retrieveLoginStatusImpl$lambda$2(String loggerRef, LoginLogger logger, LoginStatusCallback responseCallback, String applicationId, Bundle bundle) {
        Intrinsics.checkNotNullParameter(loggerRef, "$loggerRef");
        Intrinsics.checkNotNullParameter(logger, "$logger");
        Intrinsics.checkNotNullParameter(responseCallback, "$responseCallback");
        Intrinsics.checkNotNullParameter(applicationId, "$applicationId");
        if (bundle != null) {
            String string = bundle.getString(NativeProtocol.STATUS_ERROR_TYPE);
            String string2 = bundle.getString(NativeProtocol.STATUS_ERROR_DESCRIPTION);
            if (string == null) {
                String string3 = bundle.getString(NativeProtocol.EXTRA_ACCESS_TOKEN);
                Date bundleLongAsDate = Utility.getBundleLongAsDate(bundle, NativeProtocol.EXTRA_EXPIRES_SECONDS_SINCE_EPOCH, new Date(0L));
                ArrayList<String> stringArrayList = bundle.getStringArrayList(NativeProtocol.EXTRA_PERMISSIONS);
                String string4 = bundle.getString(NativeProtocol.RESULT_ARGS_SIGNED_REQUEST);
                String string5 = bundle.getString("graph_domain");
                Date bundleLongAsDate2 = Utility.getBundleLongAsDate(bundle, NativeProtocol.EXTRA_DATA_ACCESS_EXPIRATION_TIME, new Date(0L));
                String userIDFromSignedRequest = (string4 == null || string4.length() == 0) ? null : LoginMethodHandler.Companion.getUserIDFromSignedRequest(string4);
                if (string3 != null && string3.length() != 0 && stringArrayList != null && !stringArrayList.isEmpty() && userIDFromSignedRequest != null && userIDFromSignedRequest.length() != 0) {
                    AccessToken accessToken = new AccessToken(string3, applicationId, userIDFromSignedRequest, stringArrayList, null, null, null, bundleLongAsDate, null, bundleLongAsDate2, string5);
                    AccessToken.Companion.setCurrentAccessToken(accessToken);
                    Profile.Companion.fetchProfileForCurrentAccessToken();
                    logger.logLoginStatusSuccess(loggerRef);
                    responseCallback.onCompleted(accessToken);
                    return;
                }
                logger.logLoginStatusFailure(loggerRef);
                responseCallback.onFailure();
                return;
            }
            Companion.handleLoginStatusError(string, string2, loggerRef, logger, responseCallback);
            return;
        }
        logger.logLoginStatusFailure(loggerRef);
        responseCallback.onFailure();
    }

    private final void setExpressLoginStatus(boolean z) {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putBoolean(EXPRESS_LOGIN_ALLOWED, z);
        editorEdit.apply();
    }

    private final boolean isExpressLoginAllowed() {
        return this.sharedPreferences.getBoolean(EXPRESS_LOGIN_ALLOWED, true);
    }

    static final class AndroidxActivityResultRegistryOwnerStartActivityDelegate implements StartActivityDelegate {
        private final ActivityResultRegistryOwner activityResultRegistryOwner;
        private final CallbackManager callbackManager;

        public AndroidxActivityResultRegistryOwnerStartActivityDelegate(@NotNull ActivityResultRegistryOwner activityResultRegistryOwner, @NotNull CallbackManager callbackManager) {
            Intrinsics.checkNotNullParameter(activityResultRegistryOwner, "activityResultRegistryOwner");
            Intrinsics.checkNotNullParameter(callbackManager, "callbackManager");
            this.activityResultRegistryOwner = activityResultRegistryOwner;
            this.callbackManager = callbackManager;
        }

        @Override // com.facebook.login.StartActivityDelegate
        public void startActivityForResult(@NotNull Intent intent, int i) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            final LoginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder loginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder = new LoginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder();
            loginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder.setLauncher(this.activityResultRegistryOwner.getActivityResultRegistry().register("facebook-login", new ActivityResultContract<Intent, Pair<Integer, Intent>>() { // from class: com.facebook.login.LoginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$1
                @Override // androidx.activity.result.contract.ActivityResultContract
                public Intent createIntent(@NotNull Context context, @NotNull Intent input) {
                    Intrinsics.checkNotNullParameter(context, "context");
                    Intrinsics.checkNotNullParameter(input, "input");
                    return input;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // androidx.activity.result.contract.ActivityResultContract
                public Pair<Integer, Intent> parseResult(int i2, @Nullable Intent intent2) {
                    Pair<Integer, Intent> pairCreate = Pair.create(Integer.valueOf(i2), intent2);
                    Intrinsics.checkNotNullExpressionValue(pairCreate, "create(resultCode, intent)");
                    return pairCreate;
                }
            }, new ActivityResultCallback() { // from class: com.facebook.login.LoginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$$ExternalSyntheticLambda0
                @Override // androidx.activity.result.ActivityResultCallback
                public final void onActivityResult(Object obj) {
                    LoginManager.AndroidxActivityResultRegistryOwnerStartActivityDelegate.startActivityForResult$lambda$0(this.f$0, loginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder, (Pair) obj);
                }
            }));
            ActivityResultLauncher<Intent> launcher = loginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder.getLauncher();
            if (launcher != null) {
                launcher.launch(intent);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void startActivityForResult$lambda$0(AndroidxActivityResultRegistryOwnerStartActivityDelegate this$0, LoginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder launcherHolder, Pair pair) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(launcherHolder, "$launcherHolder");
            CallbackManager callbackManager = this$0.callbackManager;
            int requestCode = CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode();
            Object obj = pair.first;
            Intrinsics.checkNotNullExpressionValue(obj, "result.first");
            callbackManager.onActivityResult(requestCode, ((Number) obj).intValue(), (Intent) pair.second);
            ActivityResultLauncher<Intent> launcher = launcherHolder.getLauncher();
            if (launcher != null) {
                launcher.unregister();
            }
            launcherHolder.setLauncher(null);
        }

        @Override // com.facebook.login.StartActivityDelegate
        public Activity getActivityContext() {
            Object obj = this.activityResultRegistryOwner;
            if (obj instanceof Activity) {
                return (Activity) obj;
            }
            return null;
        }
    }

    static final class ActivityStartActivityDelegate implements StartActivityDelegate {
        private final Activity activityContext;

        public ActivityStartActivityDelegate(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            this.activityContext = activity;
        }

        @Override // com.facebook.login.StartActivityDelegate
        public Activity getActivityContext() {
            return this.activityContext;
        }

        @Override // com.facebook.login.StartActivityDelegate
        public void startActivityForResult(@NotNull Intent intent, int i) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            getActivityContext().startActivityForResult(intent, i);
        }
    }

    static final class FragmentStartActivityDelegate implements StartActivityDelegate {
        private final Activity activityContext;
        private final FragmentWrapper fragment;

        public FragmentStartActivityDelegate(@NotNull FragmentWrapper fragment) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            this.fragment = fragment;
            this.activityContext = fragment.getActivity();
        }

        @Override // com.facebook.login.StartActivityDelegate
        public void startActivityForResult(@NotNull Intent intent, int i) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            this.fragment.startActivityForResult(intent, i);
        }

        @Override // com.facebook.login.StartActivityDelegate
        public Activity getActivityContext() {
            return this.activityContext;
        }
    }

    static final class LoginLoggerHolder {
        public static final LoginLoggerHolder INSTANCE = new LoginLoggerHolder();
        private static LoginLogger logger;

        private LoginLoggerHolder() {
        }

        /* JADX WARN: Code duplicated, block: B:12:0x000f A[Catch: all -> 0x0008, TRY_ENTER, TryCatch #0 {, blocks: (B:4:0x0003, B:12:0x000f, B:14:0x0013, B:15:0x001e), top: B:20:0x0003 }] */
        /* JADX WARN: Code duplicated, block: B:14:0x0013 A[Catch: all -> 0x0008, TryCatch #0 {, blocks: (B:4:0x0003, B:12:0x000f, B:14:0x0013, B:15:0x001e), top: B:20:0x0003 }] */
        /* JADX WARN: Code duplicated, block: B:9:0x000c A[DONT_GENERATE] */
        public final LoginLogger getLogger(@Nullable Context context) {
            synchronized (this) {
                if (context != null) {
                    if (context == null) {
                        return null;
                    }
                    if (logger == null) {
                        logger = new LoginLogger(context, FacebookSdk.getApplicationId());
                    }
                    return logger;
                }
                context = FacebookSdk.getApplicationContext();
                if (context == null) {
                    return null;
                }
                if (logger == null) {
                    logger = new LoginLogger(context, FacebookSdk.getApplicationId());
                }
                return logger;
                throw th;
            }
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public LoginManager getInstance() {
            if (LoginManager.instance == null) {
                synchronized (this) {
                    Companion companion = LoginManager.Companion;
                    LoginManager.instance = new LoginManager();
                    Unit unit = Unit.INSTANCE;
                }
            }
            LoginManager loginManager = LoginManager.instance;
            if (loginManager != null) {
                return loginManager;
            }
            Intrinsics.throwUninitializedPropertyAccessException("instance");
            return null;
        }

        @JvmStatic
        public final Map<String, String> getExtraDataFromIntent(@Nullable Intent intent) {
            if (intent == null) {
                return null;
            }
            intent.setExtrasClassLoader(LoginClient.Result.class.getClassLoader());
            LoginClient.Result result = (LoginClient.Result) intent.getParcelableExtra(LoginFragment.RESULT_KEY);
            if (result == null) {
                return null;
            }
            return result.extraData;
        }

        @JvmStatic
        public final boolean isPublishPermission(@Nullable String str) {
            if (str != null) {
                return StringsKt__StringsJVMKt.startsWith$default(str, LoginManager.PUBLISH_PERMISSION_PREFIX, false, 2, null) || StringsKt__StringsJVMKt.startsWith$default(str, LoginManager.MANAGE_PERMISSION_PREFIX, false, 2, null) || LoginManager.OTHER_PUBLISH_PERMISSIONS.contains(str);
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Set<String> getOtherPublishPermissions() {
            return SetsKt__SetsKt.setOf((Object[]) new String[]{"ads_management", "create_event", "rsvp_event"});
        }

        @JvmStatic
        public final LoginResult computeLoginResult(@NotNull LoginClient.Request request, @NotNull AccessToken newToken, @Nullable AuthenticationToken authenticationToken) {
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(newToken, "newToken");
            Set<String> permissions = request.getPermissions();
            Set mutableSet = CollectionsKt___CollectionsKt.toMutableSet(CollectionsKt___CollectionsKt.filterNotNull(newToken.getPermissions()));
            if (request.isRerequest()) {
                mutableSet.retainAll(permissions);
            }
            Set mutableSet2 = CollectionsKt___CollectionsKt.toMutableSet(CollectionsKt___CollectionsKt.filterNotNull(permissions));
            mutableSet2.removeAll(mutableSet);
            return new LoginResult(newToken, authenticationToken, mutableSet, mutableSet2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void handleLoginStatusError(String str, String str2, String str3, LoginLogger loginLogger, LoginStatusCallback loginStatusCallback) {
            FacebookException facebookException = new FacebookException(str + ": " + str2);
            loginLogger.logLoginStatusError(str3, facebookException);
            loginStatusCallback.onError(facebookException);
        }
    }

    static {
        Companion companion = new Companion(null);
        Companion = companion;
        OTHER_PUBLISH_PERMISSIONS = companion.getOtherPublishPermissions();
        String string = LoginManager.class.toString();
        Intrinsics.checkNotNullExpressionValue(string, "LoginManager::class.java.toString()");
        TAG = string;
    }
}
