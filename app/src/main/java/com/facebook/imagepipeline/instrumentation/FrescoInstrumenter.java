package com.facebook.imagepipeline.instrumentation;

import com.facebook.infer.annotation.PropagatesNullable;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class FrescoInstrumenter {
    public static final FrescoInstrumenter INSTANCE = new FrescoInstrumenter();
    private static volatile Instrumenter instance;

    public interface Instrumenter {
        Runnable decorateRunnable(@NotNull Runnable runnable, @NotNull String str);

        boolean isTracing();

        void markFailure(@NotNull Object obj, @NotNull Throwable th);

        Object onBeforeSubmitWork(@NotNull String str);

        Object onBeginWork(@NotNull Object obj, @Nullable String str);

        void onEndWork(@NotNull Object obj);
    }

    private FrescoInstrumenter() {
    }

    @JvmStatic
    public static final void provide(@Nullable Instrumenter instrumenter) {
        instance = instrumenter;
    }

    @JvmStatic
    public static final boolean isTracing() {
        Instrumenter instrumenter = instance;
        if (instrumenter == null) {
            return false;
        }
        return instrumenter.isTracing();
    }

    @JvmStatic
    public static final Object onBeforeSubmitWork(@Nullable String str) {
        Instrumenter instrumenter = instance;
        if (instrumenter == null || str == null) {
            return null;
        }
        return instrumenter.onBeforeSubmitWork(str);
    }

    @JvmStatic
    public static final Object onBeginWork(@Nullable Object obj, @Nullable String str) {
        Instrumenter instrumenter = instance;
        if (instrumenter == null || obj == null) {
            return null;
        }
        return instrumenter.onBeginWork(obj, str);
    }

    @JvmStatic
    public static final void onEndWork(@Nullable Object obj) {
        Instrumenter instrumenter = instance;
        if (instrumenter == null || obj == null) {
            return;
        }
        instrumenter.onEndWork(obj);
    }

    @JvmStatic
    public static final void markFailure(@Nullable Object obj, @NotNull Throwable th) {
        Intrinsics.checkNotNullParameter(th, "th");
        Instrumenter instrumenter = instance;
        if (instrumenter == null || obj == null) {
            return;
        }
        instrumenter.markFailure(obj, th);
    }

    @JvmStatic
    public static final Runnable decorateRunnable(@PropagatesNullable @Nullable Runnable runnable, @Nullable String str) {
        Instrumenter instrumenter = instance;
        if (instrumenter == null || runnable == null) {
            return runnable;
        }
        if (str == null) {
            str = "";
        }
        return instrumenter.decorateRunnable(runnable, str);
    }
}
