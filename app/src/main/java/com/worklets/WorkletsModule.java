package com.worklets;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.turbomodule.core.interfaces.CallInvokerHolder;
import io.sentry.android.core.SentryLogcatAdapter;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
@ReactModule(name = WorkletsModule.NAME)
public class WorkletsModule extends WorkletsSpec {
    public static final String NAME = "Worklets";
    private final WeakReference<ReactApplicationContext> weakReactContext;

    public static native boolean nativeInstall(long j, CallInvokerHolder callInvokerHolder);

    WorkletsModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.weakReactContext = new WeakReference<>(reactApplicationContext);
    }

    static {
        System.loadLibrary("rnworklets");
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @Override // com.worklets.WorkletsSpec
    @ReactMethod(isBlockingSynchronousMethod = true)
    public boolean install() {
        try {
            ReactApplicationContext reactApplicationContext = this.weakReactContext.get();
            if (reactApplicationContext == null) {
                SentryLogcatAdapter.e(NAME, "React Application Context was null!");
                return false;
            }
            return nativeInstall(reactApplicationContext.getJavaScriptContextHolder().get(), reactApplicationContext.getCatalystInstance().getJSCallInvokerHolder());
        } catch (Exception e) {
            SentryLogcatAdapter.e(NAME, "Failed to initialize react-native-worklets-core!", e);
            return false;
        }
    }
}
