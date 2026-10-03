package io.sentry.android.core.internal.threaddump;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class Line {
    public int lineno;
    public String text;

    public Line(int i, @NotNull String str) {
        this.lineno = i;
        this.text = str;
    }
}
