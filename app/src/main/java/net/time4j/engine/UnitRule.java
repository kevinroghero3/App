package net.time4j.engine;

/* JADX INFO: loaded from: classes3.dex */
public interface UnitRule<T> {
    T addTo(T t, long j);

    long between(T t, T t2);
}
