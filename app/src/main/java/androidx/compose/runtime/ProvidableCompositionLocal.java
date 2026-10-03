package androidx.compose.runtime;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public abstract class ProvidableCompositionLocal<T> extends CompositionLocal<T> {
    public static final int $stable = 0;

    public abstract ProvidedValue<T> defaultProvidedValue$runtime_release(T t);

    public ProvidableCompositionLocal(@NotNull Function0<? extends T> function0) {
        super(function0, null);
    }

    public final ProvidedValue<T> provides(T t) {
        return defaultProvidedValue$runtime_release(t);
    }

    public final ProvidedValue<T> providesDefault(T t) {
        return defaultProvidedValue$runtime_release(t).ifNotAlreadyProvided$runtime_release();
    }

    public final ProvidedValue<T> providesComputed(@NotNull Function1<? super CompositionLocalAccessorScope, ? extends T> function1) {
        return new ProvidedValue<>(this, null, false, null, null, function1, false);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0044  */
    @Override // androidx.compose.runtime.CompositionLocal
    public ValueHolder<T> updatedStateOf$runtime_release(@NotNull ProvidedValue<T> providedValue, @Nullable ValueHolder<T> valueHolder) {
        ComputedValueHolder computedValueHolder;
        StaticValueHolder staticValueHolder;
        ValueHolder<T> valueHolder2;
        DynamicValueHolder dynamicValueHolder;
        if (valueHolder instanceof DynamicValueHolder) {
            if (providedValue.isDynamic$runtime_release()) {
                dynamicValueHolder = (DynamicValueHolder) valueHolder;
                dynamicValueHolder.getState().setValue(providedValue.getEffectiveValue$runtime_release());
            } else {
                valueHolder2 = computedValueHolder;
                valueHolder2 = staticValueHolder;
                valueHolder2 = (ValueHolder<T>) null;
            }
        } else if (valueHolder instanceof StaticValueHolder) {
            if (providedValue.isStatic$runtime_release()) {
                staticValueHolder = (StaticValueHolder) valueHolder;
                if (!Intrinsics.areEqual(providedValue.getEffectiveValue$runtime_release(), staticValueHolder.getValue())) {
                    valueHolder2 = computedValueHolder;
                    valueHolder2 = staticValueHolder;
                    valueHolder2 = (ValueHolder<T>) null;
                }
            } else {
                valueHolder2 = computedValueHolder;
                valueHolder2 = staticValueHolder;
                valueHolder2 = (ValueHolder<T>) null;
            }
        } else if (valueHolder instanceof ComputedValueHolder) {
            computedValueHolder = (ComputedValueHolder) valueHolder;
            if (providedValue.getCompute$runtime_release() != computedValueHolder.getCompute()) {
                valueHolder2 = computedValueHolder;
                valueHolder2 = staticValueHolder;
                valueHolder2 = (ValueHolder<T>) null;
            }
        } else {
            valueHolder2 = computedValueHolder;
            valueHolder2 = staticValueHolder;
            valueHolder2 = (ValueHolder<T>) null;
        }
        if (valueHolder2 == null) {
            valueHolder2 = dynamicValueHolder;
            return valueHolderOf(providedValue);
        }
        valueHolder2 = dynamicValueHolder;
        return valueHolder2;
    }

    private final ValueHolder<T> valueHolderOf(ProvidedValue<T> providedValue) {
        ValueHolder<T> dynamicValueHolder;
        if (providedValue.isDynamic$runtime_release()) {
            MutableState<T> state$runtime_release = providedValue.getState$runtime_release();
            if (state$runtime_release == null) {
                T value = providedValue.getValue();
                SnapshotMutationPolicy<T> mutationPolicy$runtime_release = providedValue.getMutationPolicy$runtime_release();
                if (mutationPolicy$runtime_release == null) {
                    mutationPolicy$runtime_release = SnapshotStateKt.structuralEqualityPolicy();
                }
                state$runtime_release = SnapshotStateKt.mutableStateOf(value, mutationPolicy$runtime_release);
            }
            return new DynamicValueHolder(state$runtime_release);
        }
        if (providedValue.getCompute$runtime_release() != null) {
            dynamicValueHolder = new ComputedValueHolder<>(providedValue.getCompute$runtime_release());
        } else {
            dynamicValueHolder = providedValue.getState$runtime_release() != null ? new DynamicValueHolder<>(providedValue.getState$runtime_release()) : new StaticValueHolder<>(providedValue.getEffectiveValue$runtime_release());
        }
        return dynamicValueHolder;
    }
}
