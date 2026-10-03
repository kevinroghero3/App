package com.facebook.common.closeables;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class AutoCleanupDelegate<T> implements ReadWriteProperty<Object, T> {
    private final Function1<T, Unit> cleanupFunction;
    private T currentValue;

    /* JADX WARN: Multi-variable type inference failed */
    public AutoCleanupDelegate(@Nullable T t, @NotNull Function1<? super T, Unit> cleanupFunction) {
        Intrinsics.checkNotNullParameter(cleanupFunction, "cleanupFunction");
        this.currentValue = t;
        this.cleanupFunction = cleanupFunction;
    }

    public /* synthetic */ AutoCleanupDelegate(Object obj, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : obj, function1);
    }

    @Override // kotlin.properties.ReadWriteProperty
    public void setValue(@Nullable Object obj, @NotNull KProperty<?> property, @Nullable T t) {
        Intrinsics.checkNotNullParameter(property, "property");
        T t2 = this.currentValue;
        if (t2 != null && t2 != t) {
            this.cleanupFunction.invoke(t2);
        }
        this.currentValue = t;
    }

    @Override // kotlin.properties.ReadWriteProperty, kotlin.properties.ReadOnlyProperty
    public T getValue(@Nullable Object obj, @NotNull KProperty<?> property) {
        Intrinsics.checkNotNullParameter(property, "property");
        return this.currentValue;
    }
}
