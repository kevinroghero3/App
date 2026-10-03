package com.facebook.fresco.animation.bitmap.preparation.loadframe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public final class AnimationLoaderExecutor {
    public static final AnimationLoaderExecutor INSTANCE = new AnimationLoaderExecutor();
    private static final ExecutorService executor;
    private static final ThreadFactory frameThreadFactory;

    private AnimationLoaderExecutor() {
    }

    static {
        ThreadFactory threadFactory = new ThreadFactory() { // from class: com.facebook.fresco.animation.bitmap.preparation.loadframe.AnimationLoaderExecutor$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return AnimationLoaderExecutor.frameThreadFactory$lambda$0(runnable);
            }
        };
        frameThreadFactory = threadFactory;
        executor = Executors.newCachedThreadPool(threadFactory);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread frameThreadFactory$lambda$0(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setPriority(1);
        return thread;
    }

    public final void execute(@NotNull Runnable task) {
        Intrinsics.checkNotNullParameter(task, "task");
        executor.execute(task);
    }
}
