package androidx.compose.runtime;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface DoubleState extends State<Double> {
    double getDoubleValue();

    static /* synthetic */ double access$getValue$jd(DoubleState doubleState) {
        return super.getValue().doubleValue();
    }

    public static final class DefaultImpls {
        @Deprecated
        public static Double getValue(@NotNull DoubleState doubleState) {
            return Double.valueOf(DoubleState.access$getValue$jd(doubleState));
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.runtime.State
    default Double getValue() {
        return Double.valueOf(getDoubleValue());
    }
}
