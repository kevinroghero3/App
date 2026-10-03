package io.sentry;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public class SpanOptions {
    private SentryDate startTimestamp = null;
    private ScopeBindingMode scopeBindingMode = ScopeBindingMode.AUTO;
    private boolean trimStart = false;
    private boolean trimEnd = false;
    private boolean isIdle = false;
    protected String origin = SpanContext.DEFAULT_ORIGIN;

    public SentryDate getStartTimestamp() {
        return this.startTimestamp;
    }

    public void setStartTimestamp(@Nullable SentryDate sentryDate) {
        this.startTimestamp = sentryDate;
    }

    public boolean isTrimStart() {
        return this.trimStart;
    }

    public boolean isTrimEnd() {
        return this.trimEnd;
    }

    public boolean isIdle() {
        return this.isIdle;
    }

    public void setTrimStart(boolean z) {
        this.trimStart = z;
    }

    public void setTrimEnd(boolean z) {
        this.trimEnd = z;
    }

    public void setIdle(boolean z) {
        this.isIdle = z;
    }

    public String getOrigin() {
        return this.origin;
    }

    public void setOrigin(@Nullable String str) {
        this.origin = str;
    }

    public ScopeBindingMode getScopeBindingMode() {
        return this.scopeBindingMode;
    }

    public void setScopeBindingMode(@NotNull ScopeBindingMode scopeBindingMode) {
        this.scopeBindingMode = scopeBindingMode;
    }
}
