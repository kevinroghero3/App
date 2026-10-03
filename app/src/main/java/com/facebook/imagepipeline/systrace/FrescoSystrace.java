package com.facebook.imagepipeline.systrace;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class FrescoSystrace {
    public static final FrescoSystrace INSTANCE = new FrescoSystrace();
    public static final ArgsBuilder NO_OP_ARGS_BUILDER = new NoOpArgsBuilder();
    private static Systrace _instance;

    public interface ArgsBuilder {
        ArgsBuilder arg(@NotNull String str, double d);

        ArgsBuilder arg(@NotNull String str, int i);

        ArgsBuilder arg(@NotNull String str, long j);

        ArgsBuilder arg(@NotNull String str, @NotNull Object obj);

        void flush();
    }

    static final class NoOpArgsBuilder implements ArgsBuilder {
        @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.ArgsBuilder
        public ArgsBuilder arg(@NotNull String key, double d) {
            Intrinsics.checkNotNullParameter(key, "key");
            return this;
        }

        @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.ArgsBuilder
        public ArgsBuilder arg(@NotNull String key, int i) {
            Intrinsics.checkNotNullParameter(key, "key");
            return this;
        }

        @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.ArgsBuilder
        public ArgsBuilder arg(@NotNull String key, long j) {
            Intrinsics.checkNotNullParameter(key, "key");
            return this;
        }

        @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.ArgsBuilder
        public ArgsBuilder arg(@NotNull String key, @NotNull Object value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            return this;
        }

        @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.ArgsBuilder
        public void flush() {
        }
    }

    public interface Systrace {
        void beginSection(@NotNull String str);

        ArgsBuilder beginSectionWithArgs(@NotNull String str);

        void endSection();

        boolean isTracing();
    }

    private FrescoSystrace() {
    }

    @JvmStatic
    public static final void provide(@Nullable Systrace systrace) {
        _instance = systrace;
    }

    @JvmStatic
    public static final void beginSection(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        INSTANCE.getInstance().beginSection(name);
    }

    @JvmStatic
    public static final ArgsBuilder beginSectionWithArgs(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return INSTANCE.getInstance().beginSectionWithArgs(name);
    }

    @JvmStatic
    public static final void endSection() {
        INSTANCE.getInstance().endSection();
    }

    public final <T> T traceSection(@NotNull String name, @NotNull Function0<? extends T> block) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(block, "block");
        if (!isTracing()) {
            return block.invoke();
        }
        beginSection(name);
        try {
            return block.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            endSection();
            InlineMarker.finallyEnd(1);
        }
    }

    @JvmStatic
    public static final boolean isTracing() {
        return INSTANCE.getInstance().isTracing();
    }

    private final Systrace getInstance() {
        DefaultFrescoSystrace defaultFrescoSystrace;
        Systrace systrace = _instance;
        if (systrace != null) {
            return systrace;
        }
        synchronized (FrescoSystrace.class) {
            defaultFrescoSystrace = new DefaultFrescoSystrace();
            _instance = defaultFrescoSystrace;
        }
        return defaultFrescoSystrace;
    }
}
