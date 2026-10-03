package io.sentry;

import java.util.concurrent.Callable;
import java.util.function.Supplier;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class SentryWrapper {
    public static <U> Callable<U> wrapCallable(@NotNull final Callable<U> callable) {
        final IScopes iScopesForkedScopes = Sentry.getCurrentScopes().forkedScopes("SentryWrapper.wrapCallable");
        return new Callable() { // from class: io.sentry.SentryWrapper$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return SentryWrapper.lambda$wrapCallable$0(iScopesForkedScopes, callable);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$wrapCallable$0(IScopes iScopes, Callable callable) throws Exception {
        ISentryLifecycleToken iSentryLifecycleTokenMakeCurrent = iScopes.makeCurrent();
        try {
            Object objCall = callable.call();
            if (iSentryLifecycleTokenMakeCurrent != null) {
                iSentryLifecycleTokenMakeCurrent.close();
            }
            return objCall;
        } catch (Throwable th) {
            if (iSentryLifecycleTokenMakeCurrent != null) {
                try {
                    iSentryLifecycleTokenMakeCurrent.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static <U> Supplier<U> wrapSupplier(@NotNull final Supplier<U> supplier) {
        final IScopes iScopesForkedScopes = Sentry.forkedScopes("SentryWrapper.wrapSupplier");
        return new Supplier() { // from class: io.sentry.SentryWrapper$$ExternalSyntheticLambda1
            @Override // java.util.function.Supplier
            public final Object get() {
                return SentryWrapper.lambda$wrapSupplier$1(iScopesForkedScopes, supplier);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$wrapSupplier$1(IScopes iScopes, Supplier supplier) {
        ISentryLifecycleToken iSentryLifecycleTokenMakeCurrent = iScopes.makeCurrent();
        try {
            Object obj = supplier.get();
            if (iSentryLifecycleTokenMakeCurrent != null) {
                iSentryLifecycleTokenMakeCurrent.close();
            }
            return obj;
        } catch (Throwable th) {
            if (iSentryLifecycleTokenMakeCurrent != null) {
                try {
                    iSentryLifecycleTokenMakeCurrent.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static Runnable wrapRunnable(@NotNull final Runnable runnable) {
        final IScopes iScopesForkedScopes = Sentry.forkedScopes("SentryWrapper.wrapRunnable");
        return new Runnable() { // from class: io.sentry.SentryWrapper$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                SentryWrapper.lambda$wrapRunnable$2(iScopesForkedScopes, runnable);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$wrapRunnable$2(IScopes iScopes, Runnable runnable) {
        ISentryLifecycleToken iSentryLifecycleTokenMakeCurrent = iScopes.makeCurrent();
        try {
            runnable.run();
            if (iSentryLifecycleTokenMakeCurrent != null) {
                iSentryLifecycleTokenMakeCurrent.close();
            }
        } catch (Throwable th) {
            if (iSentryLifecycleTokenMakeCurrent != null) {
                try {
                    iSentryLifecycleTokenMakeCurrent.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }
}
