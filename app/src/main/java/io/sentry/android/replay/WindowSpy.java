package io.sentry.android.replay;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.Window;
import java.lang.reflect.Field;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class WindowSpy {
    public static final int $stable;
    public static final WindowSpy INSTANCE = new WindowSpy();
    private static final Lazy decorViewClass$delegate;
    private static final Lazy windowField$delegate;

    private WindowSpy() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Class<?> getDecorViewClass() {
        return (Class) decorViewClass$delegate.getValue();
    }

    static {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        decorViewClass$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<Class<?>>() { // from class: io.sentry.android.replay.WindowSpy$decorViewClass$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Class<?> invoke() {
                try {
                    return Class.forName("com.android.internal.policy.DecorView");
                } catch (Throwable th) {
                    Log.d("WindowSpy", "Unexpected exception loading DecorView on API " + Build.VERSION.SDK_INT, th);
                    return null;
                }
            }
        });
        windowField$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<Field>() { // from class: io.sentry.android.replay.WindowSpy$windowField$2
            @Override // kotlin.jvm.functions.Function0
            public final Field invoke() {
                Class decorViewClass = WindowSpy.INSTANCE.getDecorViewClass();
                if (decorViewClass != null) {
                    try {
                        Field declaredField = decorViewClass.getDeclaredField("mWindow");
                        declaredField.setAccessible(true);
                        return declaredField;
                    } catch (NoSuchFieldException e) {
                        Log.d("WindowSpy", "Unexpected exception retrieving " + decorViewClass + "#mWindow on API " + Build.VERSION.SDK_INT, e);
                    }
                }
                return null;
            }
        });
        $stable = 8;
    }

    private final Field getWindowField() {
        return (Field) windowField$delegate.getValue();
    }

    public final Window pullWindow(@NotNull View maybeDecorView) throws IllegalAccessException {
        Field windowField;
        Intrinsics.checkNotNullParameter(maybeDecorView, "maybeDecorView");
        Class<?> decorViewClass = getDecorViewClass();
        if (decorViewClass == null || !decorViewClass.isInstance(maybeDecorView) || (windowField = INSTANCE.getWindowField()) == null) {
            return null;
        }
        Object obj = windowField.get(maybeDecorView);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.view.Window");
        return (Window) obj;
    }
}
