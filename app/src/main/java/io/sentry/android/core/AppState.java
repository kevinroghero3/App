package io.sentry.android.core;

import androidx.annotation.NonNull;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleOwner;
import io.sentry.ILogger;
import io.sentry.ISentryLifecycleToken;
import io.sentry.NoOpLogger;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.android.core.internal.util.AndroidThreadChecker;
import io.sentry.util.AutoClosableReentrantLock;
import java.io.Closeable;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class AppState implements Closeable {
    private static AppState instance = new AppState();
    private volatile LifecycleObserver lifecycleObserver;
    private final AutoClosableReentrantLock lock = new AutoClosableReentrantLock();
    private MainLooperHandler handler = new MainLooperHandler();
    private volatile Boolean inBackground = null;

    public interface AppStateListener {
        void onBackground();

        void onForeground();
    }

    private AppState() {
    }

    public static AppState getInstance() {
        return instance;
    }

    void setHandler(@NotNull MainLooperHandler mainLooperHandler) {
        this.handler = mainLooperHandler;
    }

    public void resetInstance() {
        instance = new AppState();
    }

    public LifecycleObserver getLifecycleObserver() {
        return this.lifecycleObserver;
    }

    public Boolean isInBackground() {
        return this.inBackground;
    }

    void setInBackground(boolean z) {
        this.inBackground = Boolean.valueOf(z);
    }

    public void addAppStateListener(@NotNull AppStateListener appStateListener) {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.lock.acquire();
        try {
            ensureLifecycleObserver(NoOpLogger.getInstance());
            if (this.lifecycleObserver != null) {
                this.lifecycleObserver.listeners.add(appStateListener);
            }
            if (iSentryLifecycleTokenAcquire != null) {
                iSentryLifecycleTokenAcquire.close();
            }
        } catch (Throwable th) {
            if (iSentryLifecycleTokenAcquire != null) {
                try {
                    iSentryLifecycleTokenAcquire.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public void removeAppStateListener(@NotNull AppStateListener appStateListener) {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.lock.acquire();
        try {
            if (this.lifecycleObserver != null) {
                this.lifecycleObserver.listeners.remove(appStateListener);
            }
            if (iSentryLifecycleTokenAcquire != null) {
                iSentryLifecycleTokenAcquire.close();
            }
        } catch (Throwable th) {
            if (iSentryLifecycleTokenAcquire != null) {
                try {
                    iSentryLifecycleTokenAcquire.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public void registerLifecycleObserver(@Nullable SentryOptions sentryOptions) {
        if (this.lifecycleObserver != null) {
            return;
        }
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.lock.acquire();
        try {
            ensureLifecycleObserver(sentryOptions != null ? sentryOptions.getLogger() : NoOpLogger.getInstance());
            if (iSentryLifecycleTokenAcquire != null) {
                iSentryLifecycleTokenAcquire.close();
            }
        } catch (Throwable th) {
            if (iSentryLifecycleTokenAcquire != null) {
                try {
                    iSentryLifecycleTokenAcquire.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    private void ensureLifecycleObserver(@NotNull final ILogger iLogger) {
        if (this.lifecycleObserver != null) {
            return;
        }
        try {
            Class.forName("androidx.lifecycle.ProcessLifecycleOwner");
            this.lifecycleObserver = new LifecycleObserver();
            if (AndroidThreadChecker.getInstance().isMainThread()) {
                lambda$ensureLifecycleObserver$0(iLogger);
            } else {
                this.handler.post(new Runnable() { // from class: io.sentry.android.core.AppState$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$ensureLifecycleObserver$0(iLogger);
                    }
                });
            }
        } catch (ClassNotFoundException unused) {
            iLogger.log(SentryLevel.WARNING, "androidx.lifecycle is not available, some features might not be properly working,e.g. Session Tracking, Network and System Events breadcrumbs, etc.", new Object[0]);
        } catch (Throwable th) {
            iLogger.log(SentryLevel.ERROR, "AppState could not register lifecycle observer", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addObserverInternal, reason: merged with bridge method [inline-methods] */
    public void lambda$ensureLifecycleObserver$0(@NotNull ILogger iLogger) {
        LifecycleObserver lifecycleObserver = this.lifecycleObserver;
        if (lifecycleObserver != null) {
            try {
                ProcessLifecycleOwner.get().getLifecycle().addObserver(lifecycleObserver);
            } catch (Throwable th) {
                this.lifecycleObserver = null;
                iLogger.log(SentryLevel.ERROR, "AppState failed to get Lifecycle and could not install lifecycle observer.", th);
            }
        }
    }

    public void unregisterLifecycleObserver() {
        if (this.lifecycleObserver == null) {
            return;
        }
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.lock.acquire();
        try {
            final LifecycleObserver lifecycleObserver = this.lifecycleObserver;
            this.lifecycleObserver.listeners.clear();
            this.lifecycleObserver = null;
            if (iSentryLifecycleTokenAcquire != null) {
                iSentryLifecycleTokenAcquire.close();
            }
            if (AndroidThreadChecker.getInstance().isMainThread()) {
                lambda$unregisterLifecycleObserver$1(lifecycleObserver);
            } else {
                this.handler.post(new Runnable() { // from class: io.sentry.android.core.AppState$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$unregisterLifecycleObserver$1(lifecycleObserver);
                    }
                });
            }
        } catch (Throwable th) {
            if (iSentryLifecycleTokenAcquire != null) {
                try {
                    iSentryLifecycleTokenAcquire.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: removeObserverInternal, reason: merged with bridge method [inline-methods] */
    public void lambda$unregisterLifecycleObserver$1(@Nullable LifecycleObserver lifecycleObserver) {
        if (lifecycleObserver != null) {
            ProcessLifecycleOwner.get().getLifecycle().removeObserver(lifecycleObserver);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        unregisterLifecycleObserver();
    }

    public final class LifecycleObserver implements DefaultLifecycleObserver {
        final List<AppStateListener> listeners = new CopyOnWriteArrayList<AppStateListener>() { // from class: io.sentry.android.core.AppState.LifecycleObserver.1
            @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List, java.util.Collection
            public boolean add(AppStateListener appStateListener) {
                boolean zAdd = super.add(appStateListener);
                if (!Boolean.FALSE.equals(AppState.this.inBackground)) {
                    if (Boolean.TRUE.equals(AppState.this.inBackground)) {
                        appStateListener.onBackground();
                    }
                } else {
                    appStateListener.onForeground();
                }
                return zAdd;
            }
        };

        public LifecycleObserver() {
        }

        public List<AppStateListener> getListeners() {
            return this.listeners;
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void onStart(@NonNull LifecycleOwner lifecycleOwner) {
            AppState.this.setInBackground(false);
            Iterator<AppStateListener> it2 = this.listeners.iterator();
            while (it2.hasNext()) {
                it2.next().onForeground();
            }
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void onStop(@NonNull LifecycleOwner lifecycleOwner) {
            AppState.this.setInBackground(true);
            Iterator<AppStateListener> it2 = this.listeners.iterator();
            while (it2.hasNext()) {
                it2.next().onBackground();
            }
        }
    }
}
