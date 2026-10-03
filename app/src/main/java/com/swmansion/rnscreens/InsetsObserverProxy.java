package com.swmansion.rnscreens;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import io.sentry.android.core.SentryLogcatAdapter;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class InsetsObserverProxy implements OnApplyWindowInsetsListener, LifecycleEventListener {
    private static boolean hasBeenRegistered;
    private static boolean isObservingContextLifetime;
    public static final InsetsObserverProxy INSTANCE = new InsetsObserverProxy();
    private static final HashSet<OnApplyWindowInsetsListener> listeners = new HashSet<>();
    private static WeakReference<View> eventSourceView = new WeakReference<>(null);
    private static boolean shouldForwardInsetsToView = true;

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
    }

    private InsetsObserverProxy() {
    }

    private final boolean getAllowRegistration() {
        return !hasBeenRegistered || eventSourceView.get() == null;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(@NotNull View v, @NotNull WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(insets, "insets");
        WindowInsetsCompat windowInsetsCompatOnApplyWindowInsets = shouldForwardInsetsToView ? ViewCompat.onApplyWindowInsets(v, insets) : insets;
        Intrinsics.checkNotNull(windowInsetsCompatOnApplyWindowInsets);
        Iterator<T> it2 = listeners.iterator();
        while (it2.hasNext()) {
            windowInsetsCompatOnApplyWindowInsets = ((OnApplyWindowInsetsListener) it2.next()).onApplyWindowInsets(v, insets);
        }
        return windowInsetsCompatOnApplyWindowInsets;
    }

    public final void registerWithContext(@NotNull ReactApplicationContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (isObservingContextLifetime) {
            SentryLogcatAdapter.w("[RNScreens]", "InsetObserverProxy registers on new context while it has not been invalidated on the old one. Please report this as issue at https://github.com/software-mansion/react-native-screens/issues");
        }
        isObservingContextLifetime = true;
        context.addLifecycleEventListener(this);
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
        View observedView = getObservedView();
        if (hasBeenRegistered && observedView != null) {
            ViewCompat.setOnApplyWindowInsetsListener(observedView, null);
            hasBeenRegistered = false;
            eventSourceView.clear();
        }
        isObservingContextLifetime = false;
    }

    public final void addOnApplyWindowInsetsListener(@NotNull OnApplyWindowInsetsListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        listeners.add(listener);
    }

    public final void removeOnApplyWindowInsetsListener(@NotNull OnApplyWindowInsetsListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        listeners.remove(listener);
    }

    public final boolean registerOnView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (!getAllowRegistration()) {
            return false;
        }
        ViewCompat.setOnApplyWindowInsetsListener(view, this);
        eventSourceView = new WeakReference<>(view);
        hasBeenRegistered = true;
        return true;
    }

    public final void unregister() {
        View observedView = getObservedView();
        if (observedView != null) {
            if (!hasBeenRegistered) {
                observedView = null;
            }
            if (observedView != null) {
                ViewCompat.setOnApplyWindowInsetsListener(observedView, null);
            }
        }
    }

    private final View getObservedView() {
        return eventSourceView.get();
    }
}
