package kotlin.reflect;

import kotlin.Unit;

/* JADX INFO: loaded from: classes3.dex */
public interface KMutableProperty<V> extends KProperty<V> {

    public interface Setter<V> extends KProperty.Accessor<V>, KFunction<Unit> {
    }

    Setter<V> getSetter();
}
