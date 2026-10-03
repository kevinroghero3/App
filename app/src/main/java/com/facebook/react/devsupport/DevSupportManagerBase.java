package com.facebook.react.devsupport;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.hardware.SensorManager;
import android.os.Build;
import android.util.Base64;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.util.Supplier;
import com.facebook.common.logging.FLog;
import com.facebook.fbreact.specs.NativeRedBoxSpec;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.R;
import com.facebook.react.bridge.DefaultJSExceptionHandler;
import com.facebook.react.bridge.JSBundleLoader;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.DebugServerException;
import com.facebook.react.common.JavascriptException;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.common.ShakeDetector;
import com.facebook.react.common.SurfaceDelegate;
import com.facebook.react.common.SurfaceDelegateFactory;
import com.facebook.react.devsupport.interfaces.BundleLoadCallback;
import com.facebook.react.devsupport.interfaces.DevBundleDownloadListener;
import com.facebook.react.devsupport.interfaces.DevLoadingViewManager;
import com.facebook.react.devsupport.interfaces.DevOptionHandler;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.devsupport.interfaces.ErrorCustomizer;
import com.facebook.react.devsupport.interfaces.ErrorType;
import com.facebook.react.devsupport.interfaces.PackagerStatusCallback;
import com.facebook.react.devsupport.interfaces.PausedInDebuggerOverlayManager;
import com.facebook.react.devsupport.interfaces.RedBoxHandler;
import com.facebook.react.devsupport.interfaces.StackFrame;
import com.facebook.react.modules.core.RCTNativeAppEventEmitter;
import com.facebook.react.modules.debug.interfaces.DeveloperSettings;
import com.facebook.react.packagerconnection.RequestHandler;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class DevSupportManagerBase implements DevSupportManager {
    private static final String EXOPACKAGE_LOCATION_FORMAT = "/data/local/tmp/exopackage/%s//secondary-dex";
    private static final int JAVA_ERROR_COOKIE = -1;
    private static final int JSEXCEPTION_ERROR_COOKIE = -1;
    private static final String RELOAD_APP_ACTION_SUFFIX = ".RELOAD_APP_ACTION";
    private static int artificialFrame = 1;
    private static byte extraCallback = -124;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;
    private final Context mApplicationContext;
    private final DevBundleDownloadListener mBundleDownloadListener;
    private ReactContext mCurrentReactContext;
    private final Map<String, RequestHandler> mCustomPackagerCommandHandlers;
    private DebugOverlayController mDebugOverlayController;
    private final DefaultJSExceptionHandler mDefaultJSExceptionHandler;
    private final DevLoadingViewManager mDevLoadingViewManager;
    private AlertDialog mDevOptionsDialog;
    private final DevServerHelper mDevServerHelper;
    private final DeveloperSettings mDevSettings;
    private List<ErrorCustomizer> mErrorCustomizers;
    private boolean mIsPackagerConnected;
    private final String mJSAppBundleName;
    private final File mJSBundleDownloadedFile;
    private final File mJSSplitBundlesDir;
    private StackFrame[] mLastErrorStack;
    private String mLastErrorTitle;
    private ErrorType mLastErrorType;
    private DevSupportManager.PackagerLocationCustomizer mPackagerLocationCustomizer;
    private final PausedInDebuggerOverlayManager mPausedInDebuggerOverlayManager;
    protected final ReactInstanceDevHelper mReactInstanceDevHelper;
    private final RedBoxHandler mRedBoxHandler;
    private SurfaceDelegate mRedBoxSurfaceDelegate;
    private final BroadcastReceiver mReloadAppBroadcastReceiver;
    private final ShakeDetector mShakeDetector;
    private final SurfaceDelegateFactory mSurfaceDelegateFactory;
    private final LinkedHashMap<String, DevOptionHandler> mCustomDevOptions = new LinkedHashMap<>();
    private boolean mDevLoadingViewVisible = false;
    private int mPendingJSSplitBundleRequests = 0;
    private boolean mIsReceiverRegistered = false;
    private boolean mIsShakeDetectorStarted = false;
    private boolean mIsDevSupportEnabled = false;
    private int mLastErrorCookie = 0;

    /* JADX INFO: loaded from: classes4.dex */
    public interface CallbackWithBundleLoader {
        void onError(String str, Throwable th);

        void onSuccess(JSBundleLoader jSBundleLoader);
    }

    protected abstract String getUniqueTag();

    private void a(String str, Object[] objArr) {
        byte[] bArrDecode = Base64.decode(str, 0);
        byte[] bArr = new byte[bArrDecode.length];
        for (int i = 0; i < bArrDecode.length; i++) {
            bArr[i] = (byte) (bArrDecode[(bArrDecode.length - i) - 1] ^ extraCallback);
        }
        objArr[0] = new String(bArr, StandardCharsets.UTF_8);
    }

    public DevSupportManagerBase(Context context, ReactInstanceDevHelper reactInstanceDevHelper, @Nullable String str, boolean z, @Nullable RedBoxHandler redBoxHandler, @Nullable DevBundleDownloadListener devBundleDownloadListener, int i, @Nullable Map<String, RequestHandler> map, @Nullable SurfaceDelegateFactory surfaceDelegateFactory, @Nullable DevLoadingViewManager devLoadingViewManager, @Nullable PausedInDebuggerOverlayManager pausedInDebuggerOverlayManager) {
        this.mReactInstanceDevHelper = reactInstanceDevHelper;
        this.mApplicationContext = context;
        this.mJSAppBundleName = str;
        DevInternalSettings devInternalSettings = new DevInternalSettings(context, new DevInternalSettings.Listener() { // from class: com.facebook.react.devsupport.DevSupportManagerBase$$ExternalSyntheticLambda13
            @Override // com.facebook.react.devsupport.DevInternalSettings.Listener
            public final void onInternalSettingsChanged() {
                this.f$0.reloadSettings();
            }
        });
        this.mDevSettings = devInternalSettings;
        this.mDevServerHelper = new DevServerHelper(devInternalSettings, context, devInternalSettings.getPackagerConnectionSettings());
        this.mBundleDownloadListener = devBundleDownloadListener;
        this.mShakeDetector = new ShakeDetector(new ShakeDetector.ShakeListener() { // from class: com.facebook.react.devsupport.DevSupportManagerBase$$ExternalSyntheticLambda14
            @Override // com.facebook.react.common.ShakeDetector.ShakeListener
            public final void onShake() {
                this.f$0.showDevOptionsDialog();
            }
        }, i);
        this.mCustomPackagerCommandHandlers = map;
        this.mReloadAppBroadcastReceiver = new BroadcastReceiver() { // from class: com.facebook.react.devsupport.DevSupportManagerBase.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                if (DevSupportManagerBase.getReloadAppAction(context2).equals(intent.getAction())) {
                    if (intent.getBooleanExtra(DevServerHelper.RELOAD_APP_EXTRA_JS_PROXY, false)) {
                        DevSupportManagerBase.this.mDevSettings.setRemoteJSDebugEnabled(true);
                        DevSupportManagerBase.this.mDevServerHelper.launchJSDevtools();
                    } else {
                        DevSupportManagerBase.this.mDevSettings.setRemoteJSDebugEnabled(false);
                    }
                    DevSupportManagerBase.this.handleReloadJS();
                }
            }
        };
        String uniqueTag = getUniqueTag();
        this.mJSBundleDownloadedFile = new File(context.getFilesDir(), uniqueTag + "ReactNativeDevBundle.js");
        this.mJSSplitBundlesDir = context.getDir(uniqueTag.toLowerCase(Locale.ROOT) + "_dev_js_split_bundles", 0);
        this.mDefaultJSExceptionHandler = new DefaultJSExceptionHandler();
        setDevSupportEnabled(z);
        this.mRedBoxHandler = redBoxHandler;
        this.mDevLoadingViewManager = devLoadingViewManager == null ? new DefaultDevLoadingViewImplementation(reactInstanceDevHelper) : devLoadingViewManager;
        this.mSurfaceDelegateFactory = surfaceDelegateFactory;
        this.mPausedInDebuggerOverlayManager = pausedInDebuggerOverlayManager == null ? new PausedInDebuggerOverlayDialogManager(new Supplier() { // from class: com.facebook.react.devsupport.DevSupportManagerBase$$ExternalSyntheticLambda15
            @Override // androidx.core.util.Supplier
            public final Object get() {
                return this.f$0.lambda$new$0();
            }
        }) : pausedInDebuggerOverlayManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Context lambda$new$0() {
        Activity currentActivity = this.mReactInstanceDevHelper.getCurrentActivity();
        if (currentActivity == null || currentActivity.isFinishing()) {
            return null;
        }
        return currentActivity;
    }

    @Override // com.facebook.react.bridge.JSExceptionHandler
    public void handleException(Exception exc) {
        if (this.mIsDevSupportEnabled) {
            logJSException(exc);
        } else {
            this.mDefaultJSExceptionHandler.handleException(exc);
        }
    }

    private void logJSException(Exception exc) {
        StringBuilder sb = new StringBuilder(exc.getMessage() == null ? "Exception in native call from JS" : exc.getMessage());
        for (Throwable cause = exc.getCause(); cause != null; cause = cause.getCause()) {
            sb.append("\n\n");
            sb.append(cause.getMessage());
        }
        if (exc instanceof JavascriptException) {
            FLog.e(ReactConstants.TAG, "Exception in native call from JS", exc);
            showNewError(exc.getMessage().toString(), new StackFrame[0], -1, ErrorType.JS);
        } else {
            showNewJavaError(sb.toString(), exc);
        }
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public void showNewJavaError(@Nullable String str, Throwable th) {
        FLog.e(ReactConstants.TAG, "Exception in native call", th);
        showNewError(str, StackTraceHelper.convertJavaStackTrace(th), -1, ErrorType.NATIVE);
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public void addCustomDevOption(String str, DevOptionHandler devOptionHandler) {
        this.mCustomDevOptions.put(str, devOptionHandler);
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public void showNewJSError(String str, ReadableArray readableArray, int i) {
        showNewError(str, StackTraceHelper.convertJsStackTrace(readableArray), i, ErrorType.JS);
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public void registerErrorCustomizer(ErrorCustomizer errorCustomizer) {
        if (this.mErrorCustomizers == null) {
            this.mErrorCustomizers = new ArrayList();
        }
        this.mErrorCustomizers.add(errorCustomizer);
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public Pair<String, StackFrame[]> processErrorCustomizers(Pair<String, StackFrame[]> pair) {
        List<ErrorCustomizer> list = this.mErrorCustomizers;
        if (list != null) {
            Iterator<ErrorCustomizer> it2 = list.iterator();
            while (it2.hasNext()) {
                Pair<String, StackFrame[]> pairCustomizeErrorInfo = it2.next().customizeErrorInfo(pair);
                if (pairCustomizeErrorInfo != null) {
                    pair = pairCustomizeErrorInfo;
                }
            }
        }
        return pair;
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public void hideRedboxDialog() {
        SurfaceDelegate surfaceDelegate = this.mRedBoxSurfaceDelegate;
        if (surfaceDelegate == null) {
            return;
        }
        surfaceDelegate.hide();
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public View createRootView(String str) {
        return this.mReactInstanceDevHelper.createRootView(str);
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public void destroyRootView(View view) {
        this.mReactInstanceDevHelper.destroyRootView(view);
    }

    private void hideDevOptionsDialog() {
        AlertDialog alertDialog = this.mDevOptionsDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.mDevOptionsDialog = null;
        }
    }

    private void showNewError(@Nullable final String str, final StackFrame[] stackFrameArr, final int i, final ErrorType errorType) {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.devsupport.DevSupportManagerBase$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$showNewError$1(str, stackFrameArr, i, errorType);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showNewError$1(String str, StackFrame[] stackFrameArr, int i, ErrorType errorType) {
        updateLastErrorInfo(str, stackFrameArr, i, errorType);
        if (this.mRedBoxSurfaceDelegate == null) {
            SurfaceDelegate surfaceDelegateCreateSurfaceDelegate = createSurfaceDelegate(NativeRedBoxSpec.NAME);
            if (surfaceDelegateCreateSurfaceDelegate != null) {
                this.mRedBoxSurfaceDelegate = surfaceDelegateCreateSurfaceDelegate;
            } else {
                this.mRedBoxSurfaceDelegate = new RedBoxDialogSurfaceDelegate(this);
            }
            this.mRedBoxSurfaceDelegate.createContentView(NativeRedBoxSpec.NAME);
        }
        if (this.mRedBoxSurfaceDelegate.isShowing()) {
            return;
        }
        this.mRedBoxSurfaceDelegate.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDevOptionsDialog$3() {
        int i = 2 % 2;
        int i2 = getARTIFICIAL_FRAME_PACKAGE_NAME + 75;
        artificialFrame = i2 % 128;
        int i3 = i2 % 2;
        Activity currentActivity = this.mReactInstanceDevHelper.getCurrentActivity();
        if (currentActivity != null) {
            int i4 = getARTIFICIAL_FRAME_PACKAGE_NAME + 51;
            artificialFrame = i4 % 128;
            int i5 = i4 % 2;
            if (!currentActivity.isFinishing()) {
                final EditText editText = new EditText(currentActivity);
                editText.setHint("localhost:8081");
                AlertDialog.Builder builder = new AlertDialog.Builder(currentActivity);
                String string = this.mApplicationContext.getString(R.string.catalyst_change_bundle_location);
                if (!(!string.startsWith(".,.%"))) {
                    Object[] objArr = new Object[1];
                    a(string.substring(4), objArr);
                    string = ((String) objArr[0]).intern();
                }
                builder.setTitle(string).setView(editText).setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() { // from class: com.facebook.react.devsupport.DevSupportManagerBase.3
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i6) {
                        DevSupportManagerBase.this.mDevSettings.getPackagerConnectionSettings().setDebugServerHost(editText.getText().toString());
                        DevSupportManagerBase.this.handleReloadJS();
                    }
                }).create().show();
                return;
            }
        }
        FLog.e(ReactConstants.TAG, "Unable to launch change bundle location because react activity is not available");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:10:0x0033  */
    /* JADX WARN: Code duplicated, block: B:11:0x0048  */
    /* JADX WARN: Code duplicated, block: B:9:0x0031 A[DONT_INVERT, PHI: r1 r2
  0x0031: PHI (r1v6 boolean) = (r1v5 boolean), (r1v17 boolean) binds: [B:8:0x002f, B:5:0x001d] A[DONT_GENERATE, DONT_INLINE]
  0x0031: PHI (r2v3 com.facebook.react.bridge.ReactContext) = (r2v2 com.facebook.react.bridge.ReactContext), (r2v10 com.facebook.react.bridge.ReactContext) binds: [B:8:0x002f, B:5:0x001d] A[DONT_GENERATE, DONT_INLINE]] */
    public /* synthetic */ void lambda$showDevOptionsDialog$4() {
        boolean zIsHotModuleReplacementEnabled;
        ReactContext reactContext;
        int i = 2 % 2;
        int i2 = getARTIFICIAL_FRAME_PACKAGE_NAME + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
        artificialFrame = i2 % 128;
        if (i2 % 2 == 0) {
            zIsHotModuleReplacementEnabled = this.mDevSettings.isHotModuleReplacementEnabled();
            this.mDevSettings.setHotModuleReplacementEnabled(!zIsHotModuleReplacementEnabled);
            reactContext = this.mCurrentReactContext;
            if (reactContext != null) {
                if (zIsHotModuleReplacementEnabled) {
                    ((HMRClient) reactContext.getJSModule(HMRClient.class)).disable();
                } else {
                    int i3 = artificialFrame + 55;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i3 % 128;
                    int i4 = i3 % 2;
                    ((HMRClient) reactContext.getJSModule(HMRClient.class)).enable();
                }
            }
        } else {
            zIsHotModuleReplacementEnabled = this.mDevSettings.isHotModuleReplacementEnabled();
            this.mDevSettings.setHotModuleReplacementEnabled(!zIsHotModuleReplacementEnabled);
            reactContext = this.mCurrentReactContext;
            if (reactContext != null) {
                if (zIsHotModuleReplacementEnabled) {
                    int i5 = artificialFrame + 55;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i5 % 128;
                    int i6 = i5 % 2;
                    ((HMRClient) reactContext.getJSModule(HMRClient.class)).enable();
                } else {
                    ((HMRClient) reactContext.getJSModule(HMRClient.class)).disable();
                }
            }
        }
        if (!zIsHotModuleReplacementEnabled && !this.mDevSettings.isJSDevModeEnabled()) {
            Context context = this.mApplicationContext;
            String string = context.getString(R.string.catalyst_hot_reloading_auto_enable);
            if (string.startsWith(".,.%")) {
                int i7 = artificialFrame + 45;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i7 % 128;
                int i8 = i7 % 2;
                Object[] objArr = new Object[1];
                a(string.substring(4), objArr);
                string = ((String) objArr[0]).intern();
                int i9 = artificialFrame + 73;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i9 % 128;
                int i10 = i9 % 2;
            }
            Toast.makeText(context, string, 1).show();
            this.mDevSettings.setJSDevModeEnabled(true);
            handleReloadJS();
        }
        int i11 = getARTIFICIAL_FRAME_PACKAGE_NAME + 89;
        artificialFrame = i11 % 128;
        if (i11 % 2 == 0) {
            int i12 = 73 / 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDevOptionsDialog$5() {
        if (!this.mDevSettings.isFpsDebugEnabled()) {
            Activity currentActivity = this.mReactInstanceDevHelper.getCurrentActivity();
            if (currentActivity == null) {
                FLog.e(ReactConstants.TAG, "Unable to get reference to react activity");
            } else {
                DebugOverlayController.requestPermission(currentActivity);
            }
        }
        DeveloperSettings developerSettings = this.mDevSettings;
        developerSettings.setFpsDebugEnabled(!developerSettings.isFpsDebugEnabled());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDevOptionsDialog$6() {
        Intent intent = new Intent(this.mApplicationContext, (Class<?>) DevSettingsActivity.class);
        intent.setFlags(268435456);
        this.mApplicationContext.startActivity(intent);
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public void showDevOptionsDialog() {
        String string;
        int i;
        int i2 = 2 % 2;
        int i3 = getARTIFICIAL_FRAME_PACKAGE_NAME + 83;
        int i4 = i3 % 128;
        artificialFrame = i4;
        int i5 = i3 % 2;
        if (this.mDevOptionsDialog == null) {
            int i6 = i4 + 117;
            int i7 = i6 % 128;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i7;
            Object obj = null;
            if (i6 % 2 != 0) {
                throw null;
            }
            if (!this.mIsDevSupportEnabled) {
                return;
            }
            int i8 = i7 + 23;
            artificialFrame = i8 % 128;
            if (i8 % 2 == 0) {
                int i9 = 92 / 0;
                if (ActivityManager.isUserAMonkey()) {
                    return;
                }
            } else if (ActivityManager.isUserAMonkey()) {
                return;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            final HashSet hashSet = new HashSet();
            String string2 = this.mApplicationContext.getString(R.string.catalyst_reload);
            if (string2.startsWith(".,.%")) {
                Object[] objArr = new Object[1];
                a(string2.substring(4), objArr);
                string2 = ((String) objArr[0]).intern();
            }
            linkedHashMap.put(string2, new DevOptionHandler() { // from class: com.facebook.react.devsupport.DevSupportManagerBase.2
                private static int artificialFrame = 1;
                private static byte extraCallback = -124;
                private static int getARTIFICIAL_FRAME_PACKAGE_NAME;

                private void a(String str, Object[] objArr2) {
                    byte[] bArrDecode = Base64.decode(str, 0);
                    byte[] bArr = new byte[bArrDecode.length];
                    for (int i10 = 0; i10 < bArrDecode.length; i10++) {
                        bArr[i10] = (byte) (bArrDecode[(bArrDecode.length - i10) - 1] ^ extraCallback);
                    }
                    objArr2[0] = new String(bArr, StandardCharsets.UTF_8);
                }

                @Override // com.facebook.react.devsupport.interfaces.DevOptionHandler
                public void onOptionSelected() {
                    int i10 = 2 % 2;
                    int i11 = getARTIFICIAL_FRAME_PACKAGE_NAME + 51;
                    artificialFrame = i11 % 128;
                    Object obj2 = null;
                    if (i11 % 2 == 0) {
                        DevSupportManagerBase.this.mDevSettings.isJSDevModeEnabled();
                        obj2.hashCode();
                        throw null;
                    }
                    if (!DevSupportManagerBase.this.mDevSettings.isJSDevModeEnabled()) {
                        int i12 = artificialFrame + 93;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i12 % 128;
                        if (i12 % 2 != 0) {
                            DevSupportManagerBase.this.mDevSettings.isHotModuleReplacementEnabled();
                            obj2.hashCode();
                            throw null;
                        }
                        if (DevSupportManagerBase.this.mDevSettings.isHotModuleReplacementEnabled()) {
                            Context context = DevSupportManagerBase.this.mApplicationContext;
                            String string3 = DevSupportManagerBase.this.mApplicationContext.getString(R.string.catalyst_hot_reloading_auto_disable);
                            if (string3.startsWith(".,.%")) {
                                Object[] objArr2 = new Object[1];
                                a(string3.substring(4), objArr2);
                                string3 = ((String) objArr2[0]).intern();
                                int i13 = getARTIFICIAL_FRAME_PACKAGE_NAME + 93;
                                artificialFrame = i13 % 128;
                                int i14 = i13 % 2;
                            }
                            Toast.makeText(context, string3, 1).show();
                            DevSupportManagerBase.this.mDevSettings.setHotModuleReplacementEnabled(false);
                        }
                    }
                    DevSupportManagerBase.this.handleReloadJS();
                    int i15 = getARTIFICIAL_FRAME_PACKAGE_NAME + 123;
                    artificialFrame = i15 % 128;
                    int i16 = i15 % 2;
                }
            });
            if (this.mDevSettings.isRemoteJSDebugEnabled()) {
                this.mDevSettings.setRemoteJSDebugEnabled(false);
                handleReloadJS();
            }
            if (this.mDevSettings.isDeviceDebugEnabled() && !this.mDevSettings.isRemoteJSDebugEnabled()) {
                boolean z = this.mIsPackagerConnected;
                Context context = this.mApplicationContext;
                if (z) {
                    int i10 = getARTIFICIAL_FRAME_PACKAGE_NAME + 93;
                    artificialFrame = i10 % 128;
                    int i11 = i10 % 2;
                    i = R.string.catalyst_debug_open;
                } else {
                    i = R.string.catalyst_debug_open_disabled;
                }
                String string3 = context.getString(i);
                if (string3.startsWith(".,.%")) {
                    Object[] objArr2 = new Object[1];
                    a(string3.substring(4), objArr2);
                    string3 = ((String) objArr2[0]).intern();
                }
                if (!z) {
                    hashSet.add(string3);
                }
                linkedHashMap.put(string3, new DevOptionHandler() { // from class: com.facebook.react.devsupport.DevSupportManagerBase$$ExternalSyntheticLambda5
                    @Override // com.facebook.react.devsupport.interfaces.DevOptionHandler
                    public final void onOptionSelected() {
                        this.f$0.lambda$showDevOptionsDialog$2();
                    }
                });
            }
            String string4 = this.mApplicationContext.getString(R.string.catalyst_change_bundle_location);
            if (string4.startsWith(".,.%")) {
                int i12 = artificialFrame + 15;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i12 % 128;
                int i13 = i12 % 2;
                Object[] objArr3 = new Object[1];
                a(string4.substring(4), objArr3);
                string4 = ((String) objArr3[0]).intern();
            }
            linkedHashMap.put(string4, new DevOptionHandler() { // from class: com.facebook.react.devsupport.DevSupportManagerBase$$ExternalSyntheticLambda6
                @Override // com.facebook.react.devsupport.interfaces.DevOptionHandler
                public final void onOptionSelected() {
                    this.f$0.lambda$showDevOptionsDialog$3();
                }
            });
            String string5 = this.mApplicationContext.getString(R.string.catalyst_inspector_toggle);
            if (string5.startsWith(".,.%")) {
                int i14 = artificialFrame + 47;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i14 % 128;
                if (i14 % 2 != 0) {
                    Object[] objArr4 = new Object[1];
                    a(string5.substring(4), objArr4);
                    string5 = ((String) objArr4[0]).intern();
                    int i15 = 81 / 0;
                } else {
                    Object[] objArr5 = new Object[1];
                    a(string5.substring(4), objArr5);
                    string5 = ((String) objArr5[0]).intern();
                }
            }
            linkedHashMap.put(string5, new DevOptionHandler() { // from class: com.facebook.react.devsupport.DevSupportManagerBase.4
                @Override // com.facebook.react.devsupport.interfaces.DevOptionHandler
                public void onOptionSelected() {
                    DevSupportManagerBase.this.mDevSettings.setElementInspectorEnabled(!DevSupportManagerBase.this.mDevSettings.isElementInspectorEnabled());
                    DevSupportManagerBase.this.mReactInstanceDevHelper.toggleElementInspector();
                }
            });
            linkedHashMap.put(this.mDevSettings.isHotModuleReplacementEnabled() ? this.mApplicationContext.getString(R.string.catalyst_hot_reloading_stop) : this.mApplicationContext.getString(R.string.catalyst_hot_reloading), new DevOptionHandler() { // from class: com.facebook.react.devsupport.DevSupportManagerBase$$ExternalSyntheticLambda7
                @Override // com.facebook.react.devsupport.interfaces.DevOptionHandler
                public final void onOptionSelected() {
                    this.f$0.lambda$showDevOptionsDialog$4();
                }
            });
            if (this.mDevSettings.isFpsDebugEnabled()) {
                int i16 = getARTIFICIAL_FRAME_PACKAGE_NAME + 21;
                artificialFrame = i16 % 128;
                int i17 = i16 % 2;
                string = this.mApplicationContext.getString(R.string.catalyst_perf_monitor_stop);
            } else {
                string = this.mApplicationContext.getString(R.string.catalyst_perf_monitor);
            }
            linkedHashMap.put(string, new DevOptionHandler() { // from class: com.facebook.react.devsupport.DevSupportManagerBase$$ExternalSyntheticLambda8
                @Override // com.facebook.react.devsupport.interfaces.DevOptionHandler
                public final void onOptionSelected() {
                    this.f$0.lambda$showDevOptionsDialog$5();
                }
            });
            String string6 = this.mApplicationContext.getString(R.string.catalyst_settings);
            if (string6.startsWith(".,.%")) {
                int i18 = artificialFrame + 13;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i18 % 128;
                if (i18 % 2 != 0) {
                    Object[] objArr6 = new Object[1];
                    a(string6.substring(4), objArr6);
                    ((String) objArr6[0]).intern();
                    obj.hashCode();
                    throw null;
                }
                Object[] objArr7 = new Object[1];
                a(string6.substring(4), objArr7);
                string6 = ((String) objArr7[0]).intern();
            }
            linkedHashMap.put(string6, new DevOptionHandler() { // from class: com.facebook.react.devsupport.DevSupportManagerBase$$ExternalSyntheticLambda9
                @Override // com.facebook.react.devsupport.interfaces.DevOptionHandler
                public final void onOptionSelected() {
                    this.f$0.lambda$showDevOptionsDialog$6();
                }
            });
            if (this.mCustomDevOptions.size() > 0) {
                linkedHashMap.putAll(this.mCustomDevOptions);
            }
            final DevOptionHandler[] devOptionHandlerArr = (DevOptionHandler[]) linkedHashMap.values().toArray(new DevOptionHandler[0]);
            Activity currentActivity = this.mReactInstanceDevHelper.getCurrentActivity();
            if (currentActivity != null) {
                int i19 = getARTIFICIAL_FRAME_PACKAGE_NAME + 33;
                artificialFrame = i19 % 128;
                int i20 = i19 % 2;
                if (!currentActivity.isFinishing()) {
                    LinearLayout linearLayout = new LinearLayout(currentActivity);
                    linearLayout.setOrientation(1);
                    TextView textView = new TextView(currentActivity);
                    int i21 = R.string.catalyst_dev_menu_header;
                    Object[] objArr8 = {getUniqueTag()};
                    Resources resources = currentActivity.getResources();
                    Configuration configuration = resources.getConfiguration();
                    Locale locale = Build.VERSION.SDK_INT >= 24 ? configuration.getLocales().get(0) : configuration.locale;
                    String string7 = resources.getString(i21);
                    if (string7.startsWith(".,.%")) {
                        Object[] objArr9 = new Object[1];
                        a(string7.substring(4), objArr9);
                        string7 = ((String) objArr9[0]).intern();
                    }
                    textView.setText(String.format(locale, string7, objArr8));
                    textView.setPadding(0, 50, 0, 0);
                    textView.setGravity(17);
                    textView.setTextSize(16.0f);
                    textView.setTypeface(textView.getTypeface(), 1);
                    linearLayout.addView(textView);
                    String jSExecutorDescription = getJSExecutorDescription();
                    if (jSExecutorDescription != null) {
                        TextView textView2 = new TextView(currentActivity);
                        int i22 = R.string.catalyst_dev_menu_sub_header;
                        Object[] objArr10 = {jSExecutorDescription};
                        Resources resources2 = currentActivity.getResources();
                        Configuration configuration2 = resources2.getConfiguration();
                        Locale locale2 = Build.VERSION.SDK_INT >= 24 ? configuration2.getLocales().get(0) : configuration2.locale;
                        String string8 = resources2.getString(i22);
                        if (string8.startsWith(".,.%")) {
                            String strSubstring = string8.substring(4);
                            Object[] objArr11 = new Object[1];
                            a(strSubstring, objArr11);
                            string8 = ((String) objArr11[0]).intern();
                        }
                        textView2.setText(String.format(locale2, string8, objArr10));
                        textView2.setPadding(0, 20, 0, 0);
                        textView2.setGravity(17);
                        textView2.setTextSize(14.0f);
                        linearLayout.addView(textView2);
                    }
                    AlertDialog alertDialogCreate = new AlertDialog.Builder(currentActivity).setCustomTitle(linearLayout).setAdapter(new ArrayAdapter<String>(currentActivity, android.R.layout.simple_list_item_1, (String[]) linkedHashMap.keySet().toArray(new String[0])) { // from class: com.facebook.react.devsupport.DevSupportManagerBase.5
                        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
                        public boolean areAllItemsEnabled() {
                            return false;
                        }

                        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
                        public boolean isEnabled(int i23) {
                            return !hashSet.contains(getItem(i23));
                        }

                        @Override // android.widget.ArrayAdapter, android.widget.Adapter
                        public View getView(int i23, @Nullable View view, ViewGroup viewGroup) {
                            View view2 = super.getView(i23, view, viewGroup);
                            view2.setEnabled(isEnabled(i23));
                            return view2;
                        }
                    }, new DialogInterface.OnClickListener() { // from class: com.facebook.react.devsupport.DevSupportManagerBase$$ExternalSyntheticLambda10
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i23) {
                            this.f$0.lambda$showDevOptionsDialog$7(devOptionHandlerArr, dialogInterface, i23);
                        }
                    }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.facebook.react.devsupport.DevSupportManagerBase$$ExternalSyntheticLambda11
                        @Override // android.content.DialogInterface.OnCancelListener
                        public final void onCancel(DialogInterface dialogInterface) {
                            this.f$0.lambda$showDevOptionsDialog$8(dialogInterface);
                        }
                    }).create();
                    this.mDevOptionsDialog = alertDialogCreate;
                    alertDialogCreate.show();
                    ReactContext reactContext = this.mCurrentReactContext;
                    if (reactContext != null) {
                        int i23 = artificialFrame + 113;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i23 % 128;
                        int i24 = i23 % 2;
                        ((RCTNativeAppEventEmitter) reactContext.getJSModule(RCTNativeAppEventEmitter.class)).emit("RCTDevMenuShown", null);
                        return;
                    }
                    return;
                }
            }
            FLog.e(ReactConstants.TAG, "Unable to launch dev options menu because react activity isn't available");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDevOptionsDialog$7(DevOptionHandler[] devOptionHandlerArr, DialogInterface dialogInterface, int i) {
        devOptionHandlerArr[i].onOptionSelected();
        this.mDevOptionsDialog = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDevOptionsDialog$8(DialogInterface dialogInterface) {
        this.mDevOptionsDialog = null;
    }

    private String getJSExecutorDescription() {
        try {
            return getReactInstanceDevHelper().getJavaScriptExecutorFactory().toString();
        } catch (IllegalStateException unused) {
            return null;
        }
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public void setDevSupportEnabled(boolean z) {
        this.mIsDevSupportEnabled = z;
        reloadSettings();
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public boolean getDevSupportEnabled() {
        return this.mIsDevSupportEnabled;
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public DeveloperSettings getDevSettings() {
        return this.mDevSettings;
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public RedBoxHandler getRedBoxHandler() {
        return this.mRedBoxHandler;
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public void onNewReactContextCreated(ReactContext reactContext) {
        resetCurrentContext(reactContext);
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public void onReactInstanceDestroyed(ReactContext reactContext) {
        if (reactContext == this.mCurrentReactContext) {
            resetCurrentContext(null);
        }
        System.gc();
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public String getSourceMapUrl() {
        String str = this.mJSAppBundleName;
        if (str == null) {
            return "";
        }
        return this.mDevServerHelper.getSourceMapUrl((String) Assertions.assertNotNull(str));
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public String getSourceUrl() {
        String str = this.mJSAppBundleName;
        if (str == null) {
            return "";
        }
        return this.mDevServerHelper.getSourceUrl((String) Assertions.assertNotNull(str));
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public String getJSBundleURLForRemoteDebugging() {
        return this.mDevServerHelper.getJSBundleURLForRemoteDebugging((String) Assertions.assertNotNull(this.mJSAppBundleName));
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public String getDownloadedJSBundleFile() {
        return this.mJSBundleDownloadedFile.getAbsolutePath();
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public boolean hasUpToDateJSBundleInCache() {
        if (this.mIsDevSupportEnabled && this.mJSBundleDownloadedFile.exists()) {
            try {
                String packageName = this.mApplicationContext.getPackageName();
                if (this.mJSBundleDownloadedFile.lastModified() > this.mApplicationContext.getPackageManager().getPackageInfo(packageName, 0).lastUpdateTime) {
                    File file = new File(String.format(Locale.US, EXOPACKAGE_LOCATION_FORMAT, packageName));
                    return !file.exists() || this.mJSBundleDownloadedFile.lastModified() > file.lastModified();
                }
            } catch (PackageManager.NameNotFoundException unused) {
                FLog.e(ReactConstants.TAG, "DevSupport is unable to get current app info");
            }
        }
        return false;
    }

    private void resetCurrentContext(@Nullable ReactContext reactContext) {
        if (this.mCurrentReactContext == reactContext) {
            return;
        }
        this.mCurrentReactContext = reactContext;
        DebugOverlayController debugOverlayController = this.mDebugOverlayController;
        if (debugOverlayController != null) {
            debugOverlayController.setFpsDebugViewVisible(false);
        }
        if (reactContext != null) {
            this.mDebugOverlayController = new DebugOverlayController(reactContext);
        }
        if (this.mCurrentReactContext != null) {
            try {
                URL url = new URL(getSourceUrl());
                ((HMRClient) this.mCurrentReactContext.getJSModule(HMRClient.class)).setup("android", url.getPath().substring(1), url.getHost(), url.getPort() != -1 ? url.getPort() : url.getDefaultPort(), this.mDevSettings.isHotModuleReplacementEnabled(), url.getProtocol());
            } catch (MalformedURLException e) {
                showNewJavaError(e.getMessage(), e);
            }
        }
        reloadSettings();
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public void reloadSettings() {
        if (UiThreadUtil.isOnUiThread()) {
            reload();
        } else {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.devsupport.DevSupportManagerBase$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.reload();
                }
            });
        }
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public ReactContext getCurrentReactContext() {
        return this.mCurrentReactContext;
    }

    public String getJSAppBundleName() {
        return this.mJSAppBundleName;
    }

    protected Context getApplicationContext() {
        return this.mApplicationContext;
    }

    public DevServerHelper getDevServerHelper() {
        return this.mDevServerHelper;
    }

    public DevLoadingViewManager getDevLoadingViewManager() {
        return this.mDevLoadingViewManager;
    }

    public ReactInstanceDevHelper getReactInstanceDevHelper() {
        return this.mReactInstanceDevHelper;
    }

    private void showDevLoadingViewForUrl(String str) {
        int defaultPort;
        Locale locale;
        int i = 2 % 2;
        int i2 = getARTIFICIAL_FRAME_PACKAGE_NAME + 49;
        artificialFrame = i2 % 128;
        if (i2 % 2 == 0) {
            Object obj = null;
            obj.hashCode();
            throw null;
        }
        if (this.mApplicationContext == null) {
            return;
        }
        try {
            URL url = new URL(str);
            if (url.getPort() != -1) {
                int i3 = getARTIFICIAL_FRAME_PACKAGE_NAME + 27;
                artificialFrame = i3 % 128;
                int i4 = i3 % 2;
                defaultPort = url.getPort();
            } else {
                defaultPort = url.getDefaultPort();
            }
            DevLoadingViewManager devLoadingViewManager = this.mDevLoadingViewManager;
            Context context = this.mApplicationContext;
            int i5 = R.string.catalyst_loading_from_url;
            Object[] objArr = {url.getHost() + ":" + defaultPort};
            Resources resources = context.getResources();
            Configuration configuration = resources.getConfiguration();
            if (Build.VERSION.SDK_INT >= 24) {
                int i6 = artificialFrame + 75;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i6 % 128;
                locale = i6 % 2 != 0 ? configuration.getLocales().get(1) : configuration.getLocales().get(0);
            } else {
                Locale locale2 = configuration.locale;
                int i7 = artificialFrame + 85;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i7 % 128;
                int i8 = i7 % 2;
                locale = locale2;
            }
            String string = resources.getString(i5);
            if (string.startsWith(".,.%")) {
                Object[] objArr2 = new Object[1];
                a(string.substring(4), objArr2);
                string = ((String) objArr2[0]).intern();
            }
            devLoadingViewManager.showMessage(String.format(locale, string, objArr));
            this.mDevLoadingViewVisible = true;
        } catch (MalformedURLException e) {
            FLog.e(ReactConstants.TAG, "Bundle url format is invalid. \n\n" + e.toString());
        }
    }

    protected void showDevLoadingViewForRemoteJSEnabled() {
        int i = 2 % 2;
        int i2 = artificialFrame + 63;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i2 % 128;
        int i3 = i2 % 2;
        Context context = this.mApplicationContext;
        if (context == null) {
            return;
        }
        DevLoadingViewManager devLoadingViewManager = this.mDevLoadingViewManager;
        String string = context.getString(R.string.catalyst_debug_connecting);
        if (string.startsWith(".,.%")) {
            int i4 = artificialFrame + 35;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i4 % 128;
            if (i4 % 2 != 0) {
                String strSubstring = string.substring(4);
                Object[] objArr = new Object[1];
                a(strSubstring, objArr);
                string = ((String) objArr[0]).intern();
                int i5 = 99 / 0;
            } else {
                String strSubstring2 = string.substring(4);
                Object[] objArr2 = new Object[1];
                a(strSubstring2, objArr2);
                string = ((String) objArr2[0]).intern();
            }
        }
        devLoadingViewManager.showMessage(string);
        this.mDevLoadingViewVisible = true;
    }

    protected void hideDevLoadingView() {
        this.mDevLoadingViewManager.hide();
        this.mDevLoadingViewVisible = false;
    }

    public void fetchSplitBundleAndCreateBundleLoader(String str, final CallbackWithBundleLoader callbackWithBundleLoader) {
        final String devServerSplitBundleURL = this.mDevServerHelper.getDevServerSplitBundleURL(str);
        final File file = new File(this.mJSSplitBundlesDir, str.replaceAll(RemoteSettings.FORWARD_SLASH_STRING, "_") + ".jsbundle");
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.devsupport.DevSupportManagerBase$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$fetchSplitBundleAndCreateBundleLoader$9(devServerSplitBundleURL, file, callbackWithBundleLoader);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchSplitBundleAndCreateBundleLoader$9(String str, File file, CallbackWithBundleLoader callbackWithBundleLoader) {
        showSplitBundleDevLoadingView(str);
        this.mDevServerHelper.downloadBundleFromURL(new AnonymousClass6(str, file, callbackWithBundleLoader), file, str, null);
    }

    /* JADX INFO: renamed from: com.facebook.react.devsupport.DevSupportManagerBase$6, reason: invalid class name */
    class AnonymousClass6 implements DevBundleDownloadListener {
        final /* synthetic */ File val$bundleFile;
        final /* synthetic */ String val$bundleUrl;
        final /* synthetic */ CallbackWithBundleLoader val$callback;

        AnonymousClass6(String str, File file, CallbackWithBundleLoader callbackWithBundleLoader) {
            this.val$bundleUrl = str;
            this.val$bundleFile = file;
            this.val$callback = callbackWithBundleLoader;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onSuccess$0() {
            DevSupportManagerBase.this.hideSplitBundleDevLoadingView();
        }

        @Override // com.facebook.react.devsupport.interfaces.DevBundleDownloadListener
        public void onSuccess() {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.devsupport.DevSupportManagerBase$6$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onSuccess$0();
                }
            });
            ReactContext reactContext = DevSupportManagerBase.this.mCurrentReactContext;
            if (reactContext == null || !reactContext.hasActiveReactInstance()) {
                return;
            }
            this.val$callback.onSuccess(JSBundleLoader.createCachedSplitBundleFromNetworkLoader(this.val$bundleUrl, this.val$bundleFile.getAbsolutePath()));
        }

        @Override // com.facebook.react.devsupport.interfaces.DevBundleDownloadListener
        public void onProgress(@Nullable String str, @Nullable Integer num, @Nullable Integer num2) {
            DevSupportManagerBase.this.mDevLoadingViewManager.updateProgress(str, num, num2);
        }

        @Override // com.facebook.react.devsupport.interfaces.DevBundleDownloadListener
        public void onFailure(Exception exc) {
            final DevSupportManagerBase devSupportManagerBase = DevSupportManagerBase.this;
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.devsupport.DevSupportManagerBase$6$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    devSupportManagerBase.hideSplitBundleDevLoadingView();
                }
            });
            this.val$callback.onError(this.val$bundleUrl, exc);
        }
    }

    private void showSplitBundleDevLoadingView(String str) {
        showDevLoadingViewForUrl(str);
        this.mPendingJSSplitBundleRequests++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideSplitBundleDevLoadingView() {
        int i = this.mPendingJSSplitBundleRequests - 1;
        this.mPendingJSSplitBundleRequests = i;
        if (i == 0) {
            hideDevLoadingView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$isPackagerRunning$10(PackagerStatusCallback packagerStatusCallback) {
        this.mDevServerHelper.isPackagerRunning(packagerStatusCallback);
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public void isPackagerRunning(final PackagerStatusCallback packagerStatusCallback) {
        Runnable runnable = new Runnable() { // from class: com.facebook.react.devsupport.DevSupportManagerBase$$ExternalSyntheticLambda16
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$isPackagerRunning$10(packagerStatusCallback);
            }
        };
        DevSupportManager.PackagerLocationCustomizer packagerLocationCustomizer = this.mPackagerLocationCustomizer;
        if (packagerLocationCustomizer != null) {
            packagerLocationCustomizer.run(runnable);
        } else {
            runnable.run();
        }
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public File downloadBundleResourceFromUrlSync(String str, File file) {
        return this.mDevServerHelper.downloadBundleResourceFromUrlSync(str, file);
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public String getLastErrorTitle() {
        return this.mLastErrorTitle;
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public StackFrame[] getLastErrorStack() {
        return this.mLastErrorStack;
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public int getLastErrorCookie() {
        return this.mLastErrorCookie;
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public ErrorType getLastErrorType() {
        return this.mLastErrorType;
    }

    private void updateLastErrorInfo(@Nullable String str, StackFrame[] stackFrameArr, int i, ErrorType errorType) {
        this.mLastErrorTitle = str;
        this.mLastErrorStack = stackFrameArr;
        this.mLastErrorCookie = i;
        this.mLastErrorType = errorType;
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public void reloadJSFromServer(String str, final BundleLoadCallback bundleLoadCallback) {
        ReactMarker.logMarker(ReactMarkerConstants.DOWNLOAD_START);
        showDevLoadingViewForUrl(str);
        final BundleDownloader.BundleInfo bundleInfo = new BundleDownloader.BundleInfo();
        this.mDevServerHelper.downloadBundleFromURL(new DevBundleDownloadListener() { // from class: com.facebook.react.devsupport.DevSupportManagerBase.7
            @Override // com.facebook.react.devsupport.interfaces.DevBundleDownloadListener
            public void onSuccess() {
                DevSupportManagerBase.this.hideDevLoadingView();
                if (DevSupportManagerBase.this.mBundleDownloadListener != null) {
                    DevSupportManagerBase.this.mBundleDownloadListener.onSuccess();
                }
                ReactMarker.logMarker(ReactMarkerConstants.DOWNLOAD_END, bundleInfo.toJSONString());
                bundleLoadCallback.onSuccess();
            }

            @Override // com.facebook.react.devsupport.interfaces.DevBundleDownloadListener
            public void onProgress(@Nullable String str2, @Nullable Integer num, @Nullable Integer num2) {
                DevSupportManagerBase.this.mDevLoadingViewManager.updateProgress(str2, num, num2);
                if (DevSupportManagerBase.this.mBundleDownloadListener != null) {
                    DevSupportManagerBase.this.mBundleDownloadListener.onProgress(str2, num, num2);
                }
            }

            @Override // com.facebook.react.devsupport.interfaces.DevBundleDownloadListener
            public void onFailure(Exception exc) {
                DevSupportManagerBase.this.hideDevLoadingView();
                if (DevSupportManagerBase.this.mBundleDownloadListener != null) {
                    DevSupportManagerBase.this.mBundleDownloadListener.onFailure(exc);
                }
                FLog.e(ReactConstants.TAG, "Unable to download JS bundle", exc);
                DevSupportManagerBase.this.reportBundleLoadingFailure(exc);
                bundleLoadCallback.onError(exc);
            }
        }, this.mJSBundleDownloadedFile, str, bundleInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportBundleLoadingFailure(final Exception exc) {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.devsupport.DevSupportManagerBase$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$reportBundleLoadingFailure$11(exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reportBundleLoadingFailure$11(Exception exc) {
        if (exc instanceof DebugServerException) {
            showNewJavaError(((DebugServerException) exc).getMessage(), exc);
        } else {
            showNewJavaError(this.mApplicationContext.getString(R.string.catalyst_reload_error), exc);
        }
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public void startInspector() {
        if (this.mIsDevSupportEnabled) {
            this.mDevServerHelper.openInspectorConnection();
        }
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public void stopInspector() {
        this.mDevServerHelper.closeInspectorConnection();
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public void setHotModuleReplacementEnabled(final boolean z) {
        if (this.mIsDevSupportEnabled) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.devsupport.DevSupportManagerBase$$ExternalSyntheticLambda17
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setHotModuleReplacementEnabled$12(z);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setHotModuleReplacementEnabled$12(boolean z) {
        this.mDevSettings.setHotModuleReplacementEnabled(z);
        handleReloadJS();
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public void setRemoteJSDebugEnabled(final boolean z) {
        if (this.mIsDevSupportEnabled && this.mDevSettings.isRemoteJSDebugEnabled() != z) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.devsupport.DevSupportManagerBase$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setRemoteJSDebugEnabled$13(z);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setRemoteJSDebugEnabled$13(boolean z) {
        this.mDevSettings.setRemoteJSDebugEnabled(z);
        handleReloadJS();
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public void setFpsDebugEnabled(final boolean z) {
        if (this.mIsDevSupportEnabled) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.devsupport.DevSupportManagerBase$$ExternalSyntheticLambda12
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setFpsDebugEnabled$14(z);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setFpsDebugEnabled$14(boolean z) {
        this.mDevSettings.setFpsDebugEnabled(z);
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public void toggleElementInspector() {
        if (this.mIsDevSupportEnabled) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.devsupport.DevSupportManagerBase$$ExternalSyntheticLambda18
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$toggleElementInspector$15();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$toggleElementInspector$15() {
        DeveloperSettings developerSettings = this.mDevSettings;
        developerSettings.setElementInspectorEnabled(!developerSettings.isElementInspectorEnabled());
        this.mReactInstanceDevHelper.toggleElementInspector();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reload() {
        UiThreadUtil.assertOnUiThread();
        if (this.mIsDevSupportEnabled) {
            DebugOverlayController debugOverlayController = this.mDebugOverlayController;
            if (debugOverlayController != null) {
                debugOverlayController.setFpsDebugViewVisible(this.mDevSettings.isFpsDebugEnabled());
            }
            if (!this.mIsShakeDetectorStarted) {
                this.mShakeDetector.start((SensorManager) this.mApplicationContext.getSystemService("sensor"));
                this.mIsShakeDetectorStarted = true;
            }
            if (!this.mIsReceiverRegistered) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(getReloadAppAction(this.mApplicationContext));
                compatRegisterReceiver(this.mApplicationContext, this.mReloadAppBroadcastReceiver, intentFilter, true);
                this.mIsReceiverRegistered = true;
            }
            if (this.mDevLoadingViewVisible) {
                this.mDevLoadingViewManager.showMessage("Reloading...");
            }
            this.mDevServerHelper.openPackagerConnection(getClass().getSimpleName(), new AnonymousClass8());
            return;
        }
        DebugOverlayController debugOverlayController2 = this.mDebugOverlayController;
        if (debugOverlayController2 != null) {
            debugOverlayController2.setFpsDebugViewVisible(false);
        }
        if (this.mIsShakeDetectorStarted) {
            this.mShakeDetector.stop();
            this.mIsShakeDetectorStarted = false;
        }
        if (this.mIsReceiverRegistered) {
            this.mApplicationContext.unregisterReceiver(this.mReloadAppBroadcastReceiver);
            this.mIsReceiverRegistered = false;
        }
        hideRedboxDialog();
        hideDevOptionsDialog();
        this.mDevLoadingViewManager.hide();
        this.mDevServerHelper.closePackagerConnection();
    }

    /* JADX INFO: renamed from: com.facebook.react.devsupport.DevSupportManagerBase$8, reason: invalid class name */
    class AnonymousClass8 implements DevServerHelper.PackagerCommandListener {
        AnonymousClass8() {
        }

        @Override // com.facebook.react.devsupport.DevServerHelper.PackagerCommandListener
        public void onPackagerConnected() {
            DevSupportManagerBase.this.mIsPackagerConnected = true;
        }

        @Override // com.facebook.react.devsupport.DevServerHelper.PackagerCommandListener
        public void onPackagerDisconnected() {
            DevSupportManagerBase.this.mIsPackagerConnected = false;
        }

        @Override // com.facebook.react.devsupport.DevServerHelper.PackagerCommandListener
        public void onPackagerReloadCommand() {
            if (!InspectorFlags.getFuseboxEnabled()) {
                DevSupportManagerBase.this.mDevServerHelper.disableDebugger();
            }
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.devsupport.DevSupportManagerBase$8$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onPackagerReloadCommand$0();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onPackagerReloadCommand$0() {
            DevSupportManagerBase.this.handleReloadJS();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onPackagerDevMenuCommand$1() {
            DevSupportManagerBase.this.showDevOptionsDialog();
        }

        @Override // com.facebook.react.devsupport.DevServerHelper.PackagerCommandListener
        public void onPackagerDevMenuCommand() {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.devsupport.DevSupportManagerBase$8$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onPackagerDevMenuCommand$1();
                }
            });
        }

        @Override // com.facebook.react.devsupport.DevServerHelper.PackagerCommandListener
        public Map<String, RequestHandler> customCommandHandlers() {
            return DevSupportManagerBase.this.mCustomPackagerCommandHandlers;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getReloadAppAction(Context context) {
        return context.getPackageName() + RELOAD_APP_ACTION_SUFFIX;
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public void setPackagerLocationCustomizer(DevSupportManager.PackagerLocationCustomizer packagerLocationCustomizer) {
        this.mPackagerLocationCustomizer = packagerLocationCustomizer;
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public Activity getCurrentActivity() {
        return this.mReactInstanceDevHelper.getCurrentActivity();
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public SurfaceDelegate createSurfaceDelegate(String str) {
        SurfaceDelegateFactory surfaceDelegateFactory = this.mSurfaceDelegateFactory;
        if (surfaceDelegateFactory == null) {
            return null;
        }
        return surfaceDelegateFactory.createSurfaceDelegate(str);
    }

    private void compatRegisterReceiver(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, boolean z) {
        if (Build.VERSION.SDK_INT >= 34 && context.getApplicationInfo().targetSdkVersion >= 34) {
            context.registerReceiver(broadcastReceiver, intentFilter, z ? 2 : 4);
        } else {
            context.registerReceiver(broadcastReceiver, intentFilter);
        }
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    /* JADX INFO: renamed from: openDebugger, reason: merged with bridge method [inline-methods] */
    public void lambda$showDevOptionsDialog$2() {
        int i = 2 % 2;
        int i2 = getARTIFICIAL_FRAME_PACKAGE_NAME + 97;
        artificialFrame = i2 % 128;
        if (i2 % 2 != 0) {
            DevServerHelper devServerHelper = this.mDevServerHelper;
            ReactContext reactContext = this.mCurrentReactContext;
            String string = this.mApplicationContext.getString(R.string.catalyst_open_debugger_error);
            if (string.startsWith(".,.%")) {
                int i3 = artificialFrame + 87;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i3 % 128;
                int i4 = i3 % 2;
                Object[] objArr = new Object[1];
                a(string.substring(4), objArr);
                string = ((String) objArr[0]).intern();
                int i5 = artificialFrame + 61;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i5 % 128;
                if (i5 % 2 != 0) {
                    int i6 = 5 / 4;
                }
            }
            devServerHelper.openDebugger(reactContext, string);
            return;
        }
        this.mApplicationContext.getString(R.string.catalyst_open_debugger_error).startsWith(".,.%");
        throw null;
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public void showPausedInDebuggerOverlay(String str, DevSupportManager.PausedInDebuggerOverlayCommandListener pausedInDebuggerOverlayCommandListener) {
        this.mPausedInDebuggerOverlayManager.showPausedInDebuggerOverlay(str, pausedInDebuggerOverlayCommandListener);
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public void hidePausedInDebuggerOverlay() {
        this.mPausedInDebuggerOverlayManager.hidePausedInDebuggerOverlay();
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public void setAdditionalOptionForPackager(String str, String str2) {
        this.mDevSettings.getPackagerConnectionSettings().setAdditionalOptionForPackager(str, str2);
    }
}
