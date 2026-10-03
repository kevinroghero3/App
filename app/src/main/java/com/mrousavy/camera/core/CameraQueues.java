package com.mrousavy.camera.core;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.android.HandlerDispatcher;
import kotlinx.coroutines.android.HandlerDispatcherKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class CameraQueues {
    public static final Companion Companion = new Companion(null);
    private static final ExecutorService analyzerExecutor;
    private static final ExecutorService cameraExecutor;
    private static final CameraQueue videoQueue;

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ExecutorService getAnalyzerExecutor() {
            return CameraQueues.analyzerExecutor;
        }

        public final ExecutorService getCameraExecutor() {
            return CameraQueues.cameraExecutor;
        }

        public final CameraQueue getVideoQueue() {
            return CameraQueues.videoQueue;
        }
    }

    static {
        ExecutorService executorServiceNewCachedThreadPool = Executors.newCachedThreadPool();
        Intrinsics.checkNotNullExpressionValue(executorServiceNewCachedThreadPool, "newCachedThreadPool(...)");
        analyzerExecutor = executorServiceNewCachedThreadPool;
        ExecutorService executorServiceNewCachedThreadPool2 = Executors.newCachedThreadPool();
        Intrinsics.checkNotNullExpressionValue(executorServiceNewCachedThreadPool2, "newCachedThreadPool(...)");
        cameraExecutor = executorServiceNewCachedThreadPool2;
        videoQueue = new CameraQueue("mrousavy/VisionCamera.video");
    }

    public static final class CameraQueue {
        private final CoroutineDispatcher coroutineDispatcher;
        private final Executor executor;
        private final Handler handler;
        private final HandlerThread thread;

        public CameraQueue(@NotNull String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            HandlerThread handlerThread = new HandlerThread(name);
            this.thread = handlerThread;
            handlerThread.start();
            Handler handler = new Handler(handlerThread.getLooper());
            this.handler = handler;
            HandlerDispatcher handlerDispatcherFrom = HandlerDispatcherKt.from(handler, name);
            this.coroutineDispatcher = handlerDispatcherFrom;
            this.executor = ExecutorsKt.asExecutor(handlerDispatcherFrom);
        }

        public final Handler getHandler() {
            return this.handler;
        }

        public final Executor getExecutor() {
            return this.executor;
        }

        protected final void finalize() {
            this.thread.quitSafely();
        }
    }
}
