package com.facebook.react.devsupport.interfaces;

import android.app.Activity;
import android.util.Pair;
import android.view.View;
import com.facebook.react.bridge.JSExceptionHandler;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.SurfaceDelegate;
import com.facebook.react.modules.debug.interfaces.DeveloperSettings;
import java.io.File;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public interface DevSupportManager extends JSExceptionHandler {

    /* JADX INFO: loaded from: classes2.dex */
    public interface PackagerLocationCustomizer {
        void run(@Nullable Runnable runnable);
    }

    /* JADX INFO: loaded from: classes4.dex */
    public interface PausedInDebuggerOverlayCommandListener {
        void onResume();
    }

    void addCustomDevOption(@Nullable String str, @Nullable DevOptionHandler devOptionHandler);

    View createRootView(@Nullable String str);

    SurfaceDelegate createSurfaceDelegate(@Nullable String str);

    void destroyRootView(@Nullable View view);

    File downloadBundleResourceFromUrlSync(@NotNull String str, @Nullable File file);

    Activity getCurrentActivity();

    ReactContext getCurrentReactContext();

    DeveloperSettings getDevSettings();

    boolean getDevSupportEnabled();

    String getDownloadedJSBundleFile();

    String getJSBundleURLForRemoteDebugging();

    int getLastErrorCookie();

    StackFrame[] getLastErrorStack();

    String getLastErrorTitle();

    ErrorType getLastErrorType();

    RedBoxHandler getRedBoxHandler();

    String getSourceMapUrl();

    String getSourceUrl();

    void handleReloadJS();

    boolean hasUpToDateJSBundleInCache();

    void hidePausedInDebuggerOverlay();

    void hideRedboxDialog();

    void isPackagerRunning(@NotNull PackagerStatusCallback packagerStatusCallback);

    void loadSplitBundleFromServer(@NotNull String str, @NotNull DevSplitBundleCallback devSplitBundleCallback);

    void onNewReactContextCreated(@NotNull ReactContext reactContext);

    void onReactInstanceDestroyed(@NotNull ReactContext reactContext);

    void openDebugger();

    Pair<String, StackFrame[]> processErrorCustomizers(@Nullable Pair<String, StackFrame[]> pair);

    void registerErrorCustomizer(@Nullable ErrorCustomizer errorCustomizer);

    void reloadJSFromServer(@NotNull String str, @NotNull BundleLoadCallback bundleLoadCallback);

    void reloadSettings();

    void setAdditionalOptionForPackager(@NotNull String str, @NotNull String str2);

    void setDevSupportEnabled(boolean z);

    void setFpsDebugEnabled(boolean z);

    void setHotModuleReplacementEnabled(boolean z);

    void setPackagerLocationCustomizer(@Nullable PackagerLocationCustomizer packagerLocationCustomizer);

    void setRemoteJSDebugEnabled(boolean z);

    void showDevOptionsDialog();

    void showNewJSError(@Nullable String str, @Nullable ReadableArray readableArray, int i);

    void showNewJavaError(@Nullable String str, @Nullable Throwable th);

    void showPausedInDebuggerOverlay(@NotNull String str, @NotNull PausedInDebuggerOverlayCommandListener pausedInDebuggerOverlayCommandListener);

    void startInspector();

    void stopInspector();

    void toggleElementInspector();
}
