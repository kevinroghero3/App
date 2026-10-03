package io.sentry.android.replay.util;

import io.sentry.util.Random;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class SamplingKt {
    public static final boolean sample(@NotNull Random random, @Nullable Double d) {
        Intrinsics.checkNotNullParameter(random, "<this>");
        return d != null && d.doubleValue() >= random.nextDouble();
    }
}
