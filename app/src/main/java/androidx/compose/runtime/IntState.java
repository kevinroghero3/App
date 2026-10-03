package androidx.compose.runtime;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface IntState extends State<Integer> {
    int getIntValue();

    static /* synthetic */ int access$getValue$jd(IntState intState) {
        return super.getValue().intValue();
    }

    public static final class DefaultImpls {
        @Deprecated
        public static Integer getValue(@NotNull IntState intState) {
            return Integer.valueOf(IntState.access$getValue$jd(intState));
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.runtime.State
    default Integer getValue() {
        return Integer.valueOf(getIntValue());
    }
}
