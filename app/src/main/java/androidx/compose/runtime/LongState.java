package androidx.compose.runtime;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface LongState extends State<Long> {
    long getLongValue();

    static /* synthetic */ long access$getValue$jd(LongState longState) {
        return super.getValue().longValue();
    }

    public static final class DefaultImpls {
        @Deprecated
        public static Long getValue(@NotNull LongState longState) {
            return Long.valueOf(LongState.access$getValue$jd(longState));
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.runtime.State
    default Long getValue() {
        return Long.valueOf(getLongValue());
    }
}
