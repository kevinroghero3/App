package com.captureprotection.utils;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
public final class ModuleThread {
    public static final Companion Companion = new Companion(null);
    private static final Handler MainHandler = new Handler(Looper.getMainLooper());
    private static final Executor MainExecutor = new Executor() { // from class: com.captureprotection.utils.ModuleThread$$ExternalSyntheticLambda0
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            ModuleThread.MainExecutor$lambda$0(runnable);
        }
    };

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Handler getMainHandler() {
            return ModuleThread.MainHandler;
        }

        public final Executor getMainExecutor() {
            return ModuleThread.MainExecutor;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void MainExecutor$lambda$0(Runnable runnable) {
        MainHandler.post(runnable);
    }
}
