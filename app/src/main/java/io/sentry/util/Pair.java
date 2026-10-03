package io.sentry.util;

import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class Pair<A, B> {
    private final A first;
    private final B second;

    public Pair(@Nullable A a, @Nullable B b) {
        this.first = a;
        this.second = b;
    }

    public A getFirst() {
        return this.first;
    }

    public B getSecond() {
        return this.second;
    }
}
