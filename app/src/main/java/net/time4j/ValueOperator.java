package net.time4j;

import android.os.Process;
import net.time4j.engine.ChronoOperator;

/* JADX INFO: loaded from: classes3.dex */
public final class ValueOperator<T> implements ChronoOperator<T> {
    public static int onPlayFromSearch;
    public static int onPrepare;
    private final ChronoOperator<T> delegate;
    private final Object value;

    private ValueOperator(ChronoOperator<T> chronoOperator, Object obj) {
        this.delegate = chronoOperator;
        this.value = obj;
    }

    static <T> ValueOperator of(ChronoOperator<T> chronoOperator, Object obj) {
        return new ValueOperator(chronoOperator, obj);
    }

    @Override // net.time4j.engine.ChronoOperator
    public T apply(T t) {
        return this.delegate.apply(t);
    }

    Object getValue() {
        return this.value;
    }

    public static int MediaBrowserCompatMediaBrowserImplBaseMediaServiceConnection() {
        int i = onPrepare;
        int i2 = i % 8490989;
        onPrepare = i + 1;
        if (i2 != 0) {
            return onPlayFromSearch;
        }
        int iMyUid = Process.myUid();
        onPlayFromSearch = iMyUid;
        return iMyUid;
    }
}
