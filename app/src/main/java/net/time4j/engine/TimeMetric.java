package net.time4j.engine;

/* JADX INFO: loaded from: classes3.dex */
public interface TimeMetric<U, P> {
    <T extends TimePoint<? super U, T>> P between(T t, T t2);

    TimeMetric<U, P> reversible();
}
