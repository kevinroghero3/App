package io.sentry.android.core;

import com.facebook.react.modules.appstate.AppStateModule;
import io.sentry.Breadcrumb;
import io.sentry.IScope;
import io.sentry.IScopes;
import io.sentry.ISentryLifecycleToken;
import io.sentry.ScopeCallback;
import io.sentry.SentryLevel;
import io.sentry.Session;
import io.sentry.transport.CurrentDateProvider;
import io.sentry.transport.ICurrentDateProvider;
import io.sentry.util.AutoClosableReentrantLock;
import io.sentry.util.LazyEvaluator;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicLong;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
final class LifecycleWatcher implements AppState.AppStateListener {
    private final ICurrentDateProvider currentDateProvider;
    private final boolean enableAppLifecycleBreadcrumbs;
    private final boolean enableSessionTracking;
    private final AtomicLong lastUpdatedSession;
    private final IScopes scopes;
    private final long sessionIntervalMillis;
    private final LazyEvaluator<Timer> timer;
    private final AutoClosableReentrantLock timerLock;
    private TimerTask timerTask;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Timer lambda$new$0() {
        return new Timer(true);
    }

    LifecycleWatcher(@NotNull IScopes iScopes, long j, boolean z, boolean z2) {
        this(iScopes, j, z, z2, CurrentDateProvider.getInstance());
    }

    LifecycleWatcher(@NotNull IScopes iScopes, long j, boolean z, boolean z2, @NotNull ICurrentDateProvider iCurrentDateProvider) {
        this.lastUpdatedSession = new AtomicLong(0L);
        this.timer = new LazyEvaluator<>(new LazyEvaluator.Evaluator() { // from class: io.sentry.android.core.LifecycleWatcher$$ExternalSyntheticLambda0
            @Override // io.sentry.util.LazyEvaluator.Evaluator
            public final Object evaluate() {
                return LifecycleWatcher.lambda$new$0();
            }
        });
        this.timerLock = new AutoClosableReentrantLock();
        this.sessionIntervalMillis = j;
        this.enableSessionTracking = z;
        this.enableAppLifecycleBreadcrumbs = z2;
        this.scopes = iScopes;
        this.currentDateProvider = iCurrentDateProvider;
    }

    @Override // io.sentry.android.core.AppState.AppStateListener
    public void onForeground() {
        startSession();
        addAppBreadcrumb("foreground");
    }

    private void startSession() {
        cancelTask();
        long currentTimeMillis = this.currentDateProvider.getCurrentTimeMillis();
        this.scopes.configureScope(new ScopeCallback() { // from class: io.sentry.android.core.LifecycleWatcher$$ExternalSyntheticLambda1
            @Override // io.sentry.ScopeCallback
            public final void run(IScope iScope) {
                this.f$0.lambda$startSession$1(iScope);
            }
        });
        long j = this.lastUpdatedSession.get();
        if (j == 0 || j + this.sessionIntervalMillis <= currentTimeMillis) {
            if (this.enableSessionTracking) {
                this.scopes.startSession();
            }
            this.scopes.getOptions().getReplayController().start();
        }
        this.scopes.getOptions().getReplayController().resume();
        this.lastUpdatedSession.set(currentTimeMillis);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startSession$1(IScope iScope) {
        Session session;
        if (this.lastUpdatedSession.get() != 0 || (session = iScope.getSession()) == null || session.getStarted() == null) {
            return;
        }
        this.lastUpdatedSession.set(session.getStarted().getTime());
    }

    @Override // io.sentry.android.core.AppState.AppStateListener
    public void onBackground() {
        this.lastUpdatedSession.set(this.currentDateProvider.getCurrentTimeMillis());
        this.scopes.getOptions().getReplayController().pause();
        scheduleEndSession();
        addAppBreadcrumb(AppStateModule.APP_STATE_BACKGROUND);
    }

    private void scheduleEndSession() {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.timerLock.acquire();
        try {
            cancelTask();
            this.timerTask = new TimerTask() { // from class: io.sentry.android.core.LifecycleWatcher.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (LifecycleWatcher.this.enableSessionTracking) {
                        LifecycleWatcher.this.scopes.endSession();
                    }
                    LifecycleWatcher.this.scopes.getOptions().getReplayController().stop();
                    LifecycleWatcher.this.scopes.getOptions().getContinuousProfiler().close(false);
                }
            };
            this.timer.getValue().schedule(this.timerTask, this.sessionIntervalMillis);
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

    private void cancelTask() {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.timerLock.acquire();
        try {
            TimerTask timerTask = this.timerTask;
            if (timerTask != null) {
                timerTask.cancel();
                this.timerTask = null;
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

    private void addAppBreadcrumb(@NotNull String str) {
        if (this.enableAppLifecycleBreadcrumbs) {
            Breadcrumb breadcrumb = new Breadcrumb();
            breadcrumb.setType("navigation");
            breadcrumb.setData("state", str);
            breadcrumb.setCategory("app.lifecycle");
            breadcrumb.setLevel(SentryLevel.INFO);
            this.scopes.addBreadcrumb(breadcrumb);
        }
    }

    TimerTask getTimerTask() {
        return this.timerTask;
    }

    Timer getTimer() {
        return this.timer.getValue();
    }
}
