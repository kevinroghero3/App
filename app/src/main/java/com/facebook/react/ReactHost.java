package com.facebook.react;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.queue.ReactQueueConfiguration;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.interfaces.TaskInterface;
import com.facebook.react.interfaces.fabric.ReactSurface;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public interface ReactHost {
    void addBeforeDestroyListener(@NotNull Function0<Unit> function0);

    void addReactInstanceEventListener(@NotNull ReactInstanceEventListener reactInstanceEventListener);

    ReactSurface createSurface(@NotNull Context context, @NotNull String str, @Nullable Bundle bundle);

    TaskInterface<Void> destroy(@NotNull String str, @Nullable Exception exc);

    TaskInterface<Void> destroy(@NotNull String str, @Nullable Exception exc, @NotNull Function1<? super Boolean, Unit> function1);

    ReactContext getCurrentReactContext();

    DevSupportManager getDevSupportManager();

    LifecycleState getLifecycleState();

    MemoryPressureRouter getMemoryPressureRouter();

    ReactQueueConfiguration getReactQueueConfiguration();

    void invalidate();

    void onActivityResult(@NotNull Activity activity, int i, int i2, @Nullable Intent intent);

    boolean onBackPressed();

    void onConfigurationChanged(@NotNull Context context);

    void onHostDestroy();

    void onHostDestroy(@Nullable Activity activity);

    void onHostLeaveHint(@Nullable Activity activity);

    void onHostPause();

    void onHostPause(@Nullable Activity activity);

    void onHostResume(@Nullable Activity activity);

    void onHostResume(@Nullable Activity activity, @Nullable DefaultHardwareBackBtnHandler defaultHardwareBackBtnHandler);

    void onNewIntent(@NotNull Intent intent);

    void onWindowFocusChange(boolean z);

    TaskInterface<Void> reload(@NotNull String str);

    void removeBeforeDestroyListener(@NotNull Function0<Unit> function0);

    void removeReactInstanceEventListener(@NotNull ReactInstanceEventListener reactInstanceEventListener);

    TaskInterface<Void> start();

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ TaskInterface destroy$default(ReactHost reactHost, String str, Exception exc, Function1 function1, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: destroy");
        }
        if ((i & 4) != 0) {
            function1 = new Function1() { // from class: com.facebook.react.ReactHost$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return ReactHost.destroy$lambda$0(((Boolean) obj2).booleanValue());
                }
            };
        }
        return reactHost.destroy(str, exc, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static Unit destroy$lambda$0(boolean z) {
        return Unit.INSTANCE;
    }
}
