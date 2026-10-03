package com.reactnativekeyboardcontroller.modules;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.reactnativekeyboardcontroller.traversal.FocusedInputHolder;
import com.reactnativekeyboardcontroller.traversal.ViewHierarchyNavigator;
import io.sentry.protocol.SentryThread;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class KeyboardControllerModuleImpl {
    public static final Companion Companion = new Companion(null);
    public static final String NAME = "KeyboardController";
    private final int mDefaultMode;
    private final ReactApplicationContext mReactContext;

    public final void preload() {
    }

    public KeyboardControllerModuleImpl(@NotNull ReactApplicationContext mReactContext) {
        Intrinsics.checkNotNullParameter(mReactContext, "mReactContext");
        this.mReactContext = mReactContext;
        this.mDefaultMode = getCurrentMode();
    }

    public final void setInputMode(int i) {
        setSoftInputMode(i);
    }

    public final void setDefaultMode() {
        setSoftInputMode(this.mDefaultMode);
    }

    public final void dismiss(final boolean z) {
        final Activity currentActivity = this.mReactContext.getCurrentActivity();
        final EditText editText = FocusedInputHolder.INSTANCE.get();
        if (editText != null) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.reactnativekeyboardcontroller.modules.KeyboardControllerModuleImpl$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    KeyboardControllerModuleImpl.dismiss$lambda$0(currentActivity, editText, z);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dismiss$lambda$0(Activity activity, View view, boolean z) {
        Object systemService = activity != null ? activity.getSystemService("input_method") : null;
        InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
        if (z) {
            return;
        }
        view.clearFocus();
    }

    public final void setFocusTo(@NotNull String direction) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        if (Intrinsics.areEqual(direction, SentryThread.JsonKeys.CURRENT)) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.reactnativekeyboardcontroller.modules.KeyboardControllerModuleImpl$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    KeyboardControllerModuleImpl.setFocusTo$lambda$1();
                }
            });
            return;
        }
        EditText editText = FocusedInputHolder.INSTANCE.get();
        if (editText != null) {
            ViewHierarchyNavigator.INSTANCE.setFocusTo(direction, editText);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setFocusTo$lambda$1() {
        FocusedInputHolder.INSTANCE.focus();
    }

    private final void setSoftInputMode(final int i) {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.reactnativekeyboardcontroller.modules.KeyboardControllerModuleImpl$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                KeyboardControllerModuleImpl.setSoftInputMode$lambda$2(this.f$0, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setSoftInputMode$lambda$2(KeyboardControllerModuleImpl keyboardControllerModuleImpl, int i) {
        Activity currentActivity;
        Window window;
        if (keyboardControllerModuleImpl.getCurrentMode() == i || (currentActivity = keyboardControllerModuleImpl.mReactContext.getCurrentActivity()) == null || (window = currentActivity.getWindow()) == null) {
            return;
        }
        window.setSoftInputMode(i);
    }

    private final int getCurrentMode() {
        Window window;
        WindowManager.LayoutParams attributes;
        Activity currentActivity = this.mReactContext.getCurrentActivity();
        if (currentActivity == null || (window = currentActivity.getWindow()) == null || (attributes = window.getAttributes()) == null) {
            return 0;
        }
        return attributes.softInputMode;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
