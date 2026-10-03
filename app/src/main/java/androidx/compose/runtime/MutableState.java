package androidx.compose.runtime;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
public interface MutableState<T> extends State<T> {
    T component1();

    Function1<T, Unit> component2();

    @Override // androidx.compose.runtime.State
    T getValue();

    void setValue(T t);
}
