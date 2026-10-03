package io.sentry;

import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class DefaultScopesStorage implements IScopesStorage {
    private static final ThreadLocal<IScopes> currentScopes = new ThreadLocal<>();

    @Override // io.sentry.IScopesStorage
    public void init() {
    }

    @Override // io.sentry.IScopesStorage
    public ISentryLifecycleToken set(@Nullable IScopes iScopes) {
        IScopes iScopes2 = get();
        currentScopes.set(iScopes);
        return new DefaultScopesLifecycleToken(iScopes2);
    }

    @Override // io.sentry.IScopesStorage
    public IScopes get() {
        return currentScopes.get();
    }

    @Override // io.sentry.IScopesStorage
    public void close() {
        currentScopes.remove();
    }

    static final class DefaultScopesLifecycleToken implements ISentryLifecycleToken {
        private final IScopes oldValue;

        DefaultScopesLifecycleToken(@Nullable IScopes iScopes) {
            this.oldValue = iScopes;
        }

        @Override // io.sentry.ISentryLifecycleToken, java.lang.AutoCloseable
        public void close() {
            DefaultScopesStorage.currentScopes.set(this.oldValue);
        }
    }
}
