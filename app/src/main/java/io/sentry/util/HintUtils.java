package io.sentry.util;

import io.sentry.Hint;
import io.sentry.ILogger;
import io.sentry.TypeCheckHint;
import io.sentry.hints.ApplyScopeData;
import io.sentry.hints.Backfillable;
import io.sentry.hints.Cached;
import io.sentry.hints.EventDropReason;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class HintUtils {

    /* JADX INFO: loaded from: classes6.dex */
    @FunctionalInterface
    public interface SentryConsumer<T> {
        void accept(@NotNull T t);
    }

    /* JADX INFO: loaded from: classes6.dex */
    @FunctionalInterface
    public interface SentryHintFallback {
        void accept(@Nullable Object obj, @NotNull Class<?> cls);
    }

    /* JADX INFO: loaded from: classes6.dex */
    @FunctionalInterface
    public interface SentryNullableConsumer<T> {
        void accept(@Nullable T t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$runIfDoesNotHaveType$0(Object obj) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$runIfHasType$2(Object obj, Class cls) {
    }

    private HintUtils() {
    }

    public static void setIsFromHybridSdk(@NotNull Hint hint, @NotNull String str) {
        if (str.startsWith(TypeCheckHint.SENTRY_JAVASCRIPT_SDK_NAME) || str.startsWith(TypeCheckHint.SENTRY_DART_SDK_NAME) || str.startsWith(TypeCheckHint.SENTRY_DOTNET_SDK_NAME)) {
            hint.set(TypeCheckHint.SENTRY_IS_FROM_HYBRID_SDK, Boolean.TRUE);
        }
    }

    public static boolean isFromHybridSdk(@NotNull Hint hint) {
        return Boolean.TRUE.equals(hint.getAs(TypeCheckHint.SENTRY_IS_FROM_HYBRID_SDK, Boolean.class));
    }

    public static void setEventDropReason(@NotNull Hint hint, @NotNull EventDropReason eventDropReason) {
        hint.set(TypeCheckHint.SENTRY_EVENT_DROP_REASON, eventDropReason);
    }

    public static EventDropReason getEventDropReason(@NotNull Hint hint) {
        return (EventDropReason) hint.getAs(TypeCheckHint.SENTRY_EVENT_DROP_REASON, EventDropReason.class);
    }

    public static Hint createWithTypeCheckHint(Object obj) {
        Hint hint = new Hint();
        setTypeCheckHint(hint, obj);
        return hint;
    }

    public static void setTypeCheckHint(@NotNull Hint hint, Object obj) {
        hint.set(TypeCheckHint.SENTRY_TYPE_CHECK_HINT, obj);
    }

    public static Object getSentrySdkHint(@NotNull Hint hint) {
        return hint.get(TypeCheckHint.SENTRY_TYPE_CHECK_HINT);
    }

    public static boolean hasType(@NotNull Hint hint, @NotNull Class<?> cls) {
        return cls.isInstance(getSentrySdkHint(hint));
    }

    public static <T> void runIfDoesNotHaveType(@NotNull Hint hint, @NotNull Class<T> cls, final SentryNullableConsumer<Object> sentryNullableConsumer) {
        runIfHasType(hint, cls, new SentryConsumer() { // from class: io.sentry.util.HintUtils$$ExternalSyntheticLambda2
            @Override // io.sentry.util.HintUtils.SentryConsumer
            public final void accept(Object obj) {
                HintUtils.lambda$runIfDoesNotHaveType$0(obj);
            }
        }, new SentryHintFallback() { // from class: io.sentry.util.HintUtils$$ExternalSyntheticLambda3
            @Override // io.sentry.util.HintUtils.SentryHintFallback
            public final void accept(Object obj, Class cls2) {
                sentryNullableConsumer.accept(obj);
            }
        });
    }

    public static <T> void runIfHasType(@NotNull Hint hint, @NotNull Class<T> cls, SentryConsumer<T> sentryConsumer) {
        runIfHasType(hint, cls, sentryConsumer, new SentryHintFallback() { // from class: io.sentry.util.HintUtils$$ExternalSyntheticLambda0
            @Override // io.sentry.util.HintUtils.SentryHintFallback
            public final void accept(Object obj, Class cls2) {
                HintUtils.lambda$runIfHasType$2(obj, cls2);
            }
        });
    }

    public static <T> void runIfHasTypeLogIfNot(@NotNull Hint hint, @NotNull Class<T> cls, final ILogger iLogger, SentryConsumer<T> sentryConsumer) {
        runIfHasType(hint, cls, sentryConsumer, new SentryHintFallback() { // from class: io.sentry.util.HintUtils$$ExternalSyntheticLambda1
            @Override // io.sentry.util.HintUtils.SentryHintFallback
            public final void accept(Object obj, Class cls2) {
                LogUtils.logNotInstanceOf(cls2, obj, iLogger);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void runIfHasType(@NotNull Hint hint, @NotNull Class<T> cls, SentryConsumer<T> sentryConsumer, SentryHintFallback sentryHintFallback) {
        Object sentrySdkHint = getSentrySdkHint(hint);
        if (hasType(hint, cls) && sentrySdkHint != null) {
            sentryConsumer.accept(sentrySdkHint);
        } else {
            sentryHintFallback.accept(sentrySdkHint, cls);
        }
    }

    public static boolean shouldApplyScopeData(@NotNull Hint hint) {
        return !(hasType(hint, Cached.class) || hasType(hint, Backfillable.class)) || hasType(hint, ApplyScopeData.class);
    }
}
