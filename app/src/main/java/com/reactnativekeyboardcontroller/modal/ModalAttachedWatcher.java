package com.reactnativekeyboardcontroller.modal;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.view.ViewCompat;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.events.EventDispatcherListener;
import com.facebook.react.views.modal.ReactModalHostView;
import com.facebook.react.views.view.ReactViewGroup;
import com.reactnativekeyboardcontroller.extensions.ViewGroupKt;
import com.reactnativekeyboardcontroller.listeners.KeyboardAnimationCallback;
import com.reactnativekeyboardcontroller.listeners.KeyboardAnimationCallbackConfig;
import com.reactnativekeyboardcontroller.log.Logger;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class ModalAttachedWatcher implements EventDispatcherListener {
    public static final Companion Companion = new Companion(null);
    private static final String MODAL_SHOW_EVENT = "topShow";
    private final int archType;
    private Function0<KeyboardAnimationCallback> callback;
    private final KeyboardAnimationCallbackConfig config;
    private final EventDispatcher eventDispatcher;
    private final ThemedReactContext reactContext;
    private final UIManager uiManager;
    private final ReactViewGroup view;

    public ModalAttachedWatcher(@NotNull ReactViewGroup view, @NotNull ThemedReactContext reactContext, @NotNull KeyboardAnimationCallbackConfig config, @NotNull Function0<KeyboardAnimationCallback> callback) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.view = view;
        this.reactContext = reactContext;
        this.config = config;
        this.callback = callback;
        this.archType = 1;
        this.uiManager = UIManagerHelper.getUIManager(reactContext.getReactApplicationContext(), 1);
        this.eventDispatcher = UIManagerHelper.getEventDispatcher(reactContext.getReactApplicationContext(), 1);
    }

    @Override // com.facebook.react.uimanager.events.EventDispatcherListener
    public void onEventDispatch(@NotNull Event<?> event) {
        ReactModalHostView reactModalHostView;
        View decorView;
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(event.getEventName(), "topShow")) {
            View rootView = null;
            try {
                UIManager uIManager = this.uiManager;
                View viewResolveView = uIManager != null ? uIManager.resolveView(event.getViewTag()) : null;
                reactModalHostView = viewResolveView instanceof ReactModalHostView ? (ReactModalHostView) viewResolveView : null;
            } catch (Exception e) {
                Logger.INSTANCE.w(ModalAttachedWatcherKt.TAG, "Can not resolve view for Modal#" + event.getViewTag(), e);
            }
            if (reactModalHostView == null) {
                return;
            }
            Dialog dialog = reactModalHostView.getDialog();
            Window window = dialog != null ? dialog.getWindow() : null;
            if (window != null && (decorView = window.getDecorView()) != null) {
                rootView = decorView.getRootView();
            }
            ViewGroup viewGroup = (ViewGroup) rootView;
            if (viewGroup != null) {
                final ReactViewGroup reactViewGroup = new ReactViewGroup(this.reactContext);
                reactViewGroup.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
                final KeyboardAnimationCallback keyboardAnimationCallback = new KeyboardAnimationCallback(this.view, viewGroup, this.reactContext, this.config);
                viewGroup.addView(reactViewGroup);
                if (ModalAttachedWatcherKt.areEventsComingFromOwnWindow) {
                    KeyboardAnimationCallback keyboardAnimationCallbackInvoke = this.callback.invoke();
                    if (keyboardAnimationCallbackInvoke != null) {
                        keyboardAnimationCallbackInvoke.suspend(true);
                    }
                    ViewCompat.setWindowInsetsAnimationCallback(viewGroup, keyboardAnimationCallback);
                    ViewCompat.setOnApplyWindowInsetsListener(reactViewGroup, keyboardAnimationCallback);
                    keyboardAnimationCallback.syncKeyboardPosition(Double.valueOf(0.0d), Boolean.FALSE);
                }
                if (dialog != null) {
                    dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.reactnativekeyboardcontroller.modal.ModalAttachedWatcher$$ExternalSyntheticLambda0
                        @Override // android.content.DialogInterface.OnDismissListener
                        public final void onDismiss(DialogInterface dialogInterface) {
                            ModalAttachedWatcher.onEventDispatch$lambda$1(keyboardAnimationCallback, reactViewGroup, this, dialogInterface);
                        }
                    });
                }
                if (window != null) {
                    window.setSoftInputMode(48);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onEventDispatch$lambda$1(KeyboardAnimationCallback keyboardAnimationCallback, ReactViewGroup reactViewGroup, ModalAttachedWatcher modalAttachedWatcher, DialogInterface dialogInterface) {
        KeyboardAnimationCallback.syncKeyboardPosition$default(keyboardAnimationCallback, null, null, 3, null);
        keyboardAnimationCallback.destroy();
        ViewGroupKt.removeSelf(reactViewGroup);
        KeyboardAnimationCallback keyboardAnimationCallbackInvoke = modalAttachedWatcher.callback.invoke();
        if (keyboardAnimationCallbackInvoke != null) {
            keyboardAnimationCallbackInvoke.suspend(false);
        }
    }

    public final void enable() {
        EventDispatcher eventDispatcher = this.eventDispatcher;
        if (eventDispatcher != null) {
            eventDispatcher.addListener(this);
        }
    }

    public final void disable() {
        EventDispatcher eventDispatcher = this.eventDispatcher;
        if (eventDispatcher != null) {
            eventDispatcher.removeListener(this);
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
