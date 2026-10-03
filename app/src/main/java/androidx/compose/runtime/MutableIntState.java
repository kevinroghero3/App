package androidx.compose.runtime;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public interface MutableIntState extends IntState, MutableState<Integer> {
    @Override // androidx.compose.runtime.IntState
    int getIntValue();

    void setIntValue(int i);

    static /* synthetic */ int access$getValue$jd(MutableIntState mutableIntState) {
        return super.getValue().intValue();
    }

    @Override // androidx.compose.runtime.MutableState
    /* synthetic */ default void setValue(Integer num) {
        setValue(num.intValue());
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static Integer getValue(@NotNull MutableIntState mutableIntState) {
            return Integer.valueOf(MutableIntState.access$getValue$jd(mutableIntState));
        }

        @Deprecated
        public static void setValue(@NotNull MutableIntState mutableIntState, int i) {
            MutableIntState.super.setValue(i);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.runtime.IntState, androidx.compose.runtime.State
    default Integer getValue() {
        return Integer.valueOf(getIntValue());
    }

    default void setValue(int i) {
        setIntValue(i);
    }
}
