package com.swmansion.rnscreens.transition;

import android.animation.FloatEvaluator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class ExternalBoundaryValuesEvaluator extends FloatEvaluator {
    private Number endValueCache;
    private final Function1<Number, Float> endValueProvider;
    private Number startValueCache;
    private final Function1<Number, Float> startValueProvider;

    public final Function1<Number, Float> getStartValueProvider() {
        return this.startValueProvider;
    }

    public final Function1<Number, Float> getEndValueProvider() {
        return this.endValueProvider;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ExternalBoundaryValuesEvaluator(@NotNull Function1<? super Number, Float> startValueProvider, @NotNull Function1<? super Number, Float> endValueProvider) {
        Intrinsics.checkNotNullParameter(startValueProvider, "startValueProvider");
        Intrinsics.checkNotNullParameter(endValueProvider, "endValueProvider");
        this.startValueProvider = startValueProvider;
        this.endValueProvider = endValueProvider;
    }

    public final Number getStartValueCache() {
        return this.startValueCache;
    }

    public final void setStartValueCache(@Nullable Number number) {
        this.startValueCache = number;
    }

    public final Number getEndValueCache() {
        return this.endValueCache;
    }

    public final void setEndValueCache(@Nullable Number number) {
        this.endValueCache = number;
    }

    private final Number getStartValue(Number number) {
        if (this.startValueCache == null) {
            this.startValueCache = this.startValueProvider.invoke(number);
        }
        return this.startValueCache;
    }

    private final Number getEndValue(Number number) {
        if (this.endValueCache == null) {
            this.endValueCache = this.endValueProvider.invoke(number);
        }
        return this.endValueCache;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.animation.TypeEvaluator
    public Float evaluate(float f, @Nullable Number number, @Nullable Number number2) {
        Number startValue = getStartValue(number);
        Number endValue = getEndValue(number2);
        if (startValue == null || endValue == null) {
            return null;
        }
        return super.evaluate(f, startValue, endValue);
    }
}
