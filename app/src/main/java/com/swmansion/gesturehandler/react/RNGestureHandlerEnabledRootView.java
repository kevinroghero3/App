package com.swmansion.gesturehandler.react;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.react.ReactRootView;
import kotlin.Deprecated;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
@Deprecated(message = "Use <GestureHandlerRootView /> component instead.Check gesture handler installation instructions in documentation for more information.")
public final class RNGestureHandlerEnabledRootView extends ReactRootView {
    public RNGestureHandlerEnabledRootView(@Nullable Context context) {
        super(context);
        throw new UnsupportedOperationException("Your application is configured to use RNGestureHandlerEnabledRootView which is no longer supported. You can see how to migrate to <GestureHandlerRootView /> here: https://docs.swmansion.com/react-native-gesture-handler/docs/guides/migrating-off-rnghenabledroot");
    }

    public RNGestureHandlerEnabledRootView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        throw new UnsupportedOperationException("Your application is configured to use RNGestureHandlerEnabledRootView which is no longer supported. You can see how to migrate to <GestureHandlerRootView /> here: https://docs.swmansion.com/react-native-gesture-handler/docs/guides/migrating-off-rnghenabledroot");
    }
}
