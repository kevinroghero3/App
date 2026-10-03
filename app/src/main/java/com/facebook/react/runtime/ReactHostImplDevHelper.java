package com.facebook.react.runtime;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.facebook.react.bridge.JSBundleLoader;
import com.facebook.react.bridge.JavaJSExecutor;
import com.facebook.react.bridge.JavaScriptExecutorFactory;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.devsupport.ReactInstanceDevHelper;
import com.facebook.react.interfaces.TaskInterface;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.runtime.internal.bolts.Task;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public final class ReactHostImplDevHelper implements ReactInstanceDevHelper {
    private final ReactHostImpl delegate;

    @Override // com.facebook.react.devsupport.ReactInstanceDevHelper
    public void destroyRootView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
    }

    @Override // com.facebook.react.devsupport.ReactInstanceDevHelper
    public void onJSBundleLoadedFromServer() {
    }

    @Override // com.facebook.react.devsupport.ReactInstanceDevHelper
    public void onReloadWithJSDebugger(@NotNull JavaJSExecutor.Factory proxyExecutorFactory) {
        Intrinsics.checkNotNullParameter(proxyExecutorFactory, "proxyExecutorFactory");
    }

    public ReactHostImplDevHelper(@NotNull ReactHostImpl delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    @Override // com.facebook.react.devsupport.ReactInstanceDevHelper
    public void toggleElementInspector() {
        DeviceEventManagerModule.RCTDeviceEventEmitter rCTDeviceEventEmitter;
        ReactContext currentReactContext = this.delegate.getCurrentReactContext();
        if (currentReactContext == null || (rCTDeviceEventEmitter = (DeviceEventManagerModule.RCTDeviceEventEmitter) currentReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)) == null) {
            return;
        }
        rCTDeviceEventEmitter.emit("toggleElementInspector", null);
    }

    @Override // com.facebook.react.devsupport.ReactInstanceDevHelper
    public Activity getCurrentActivity() {
        return this.delegate.getLastUsedActivity();
    }

    @Override // com.facebook.react.devsupport.ReactInstanceDevHelper
    public JavaScriptExecutorFactory getJavaScriptExecutorFactory() {
        throw new IllegalStateException("Not implemented for bridgeless mode");
    }

    @Override // com.facebook.react.devsupport.ReactInstanceDevHelper
    public View createRootView(@NotNull String appKey) {
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null || this.delegate.isSurfaceWithModuleNameAttached(appKey)) {
            return null;
        }
        ReactSurfaceImpl reactSurfaceImplCreateWithView = ReactSurfaceImpl.createWithView(currentActivity, appKey, new Bundle());
        Intrinsics.checkNotNullExpressionValue(reactSurfaceImplCreateWithView, "createWithView(...)");
        reactSurfaceImplCreateWithView.attach(this.delegate);
        reactSurfaceImplCreateWithView.start();
        return reactSurfaceImplCreateWithView.getView();
    }

    @Override // com.facebook.react.devsupport.ReactInstanceDevHelper
    public void reload(@NotNull String s) {
        Intrinsics.checkNotNullParameter(s, "s");
        this.delegate.reload(s);
    }

    @Override // com.facebook.react.devsupport.ReactInstanceDevHelper
    public TaskInterface<Boolean> loadBundle(@NotNull JSBundleLoader bundleLoader) {
        Intrinsics.checkNotNullParameter(bundleLoader, "bundleLoader");
        Task<Boolean> taskLoadBundle = this.delegate.loadBundle(bundleLoader);
        Intrinsics.checkNotNullExpressionValue(taskLoadBundle, "loadBundle(...)");
        return taskLoadBundle;
    }

    @Override // com.facebook.react.devsupport.ReactInstanceDevHelper
    public ReactContext getCurrentReactContext() {
        return this.delegate.getCurrentReactContext();
    }
}
