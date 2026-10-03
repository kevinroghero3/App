package com.facebook.imagepipeline.systrace;

import android.os.Trace;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public final class DefaultFrescoSystrace implements FrescoSystrace.Systrace {
    @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.Systrace
    public boolean isTracing() {
        return false;
    }

    @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.Systrace
    public void beginSection(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (isTracing()) {
            Trace.beginSection(name);
        }
    }

    @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.Systrace
    public FrescoSystrace.ArgsBuilder beginSectionWithArgs(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (isTracing()) {
            return new DefaultArgsBuilder(name);
        }
        return FrescoSystrace.NO_OP_ARGS_BUILDER;
    }

    @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.Systrace
    public void endSection() {
        if (isTracing()) {
            Trace.endSection();
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    static final class DefaultArgsBuilder implements FrescoSystrace.ArgsBuilder {
        private final StringBuilder stringBuilder;

        public DefaultArgsBuilder(@NotNull String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.stringBuilder = new StringBuilder(name);
        }

        @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.ArgsBuilder
        public void flush() {
            if (this.stringBuilder.length() > 127) {
                this.stringBuilder.setLength(127);
            }
            Trace.beginSection(this.stringBuilder.toString());
        }

        @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.ArgsBuilder
        public DefaultArgsBuilder arg(@NotNull String key, @NotNull Object value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            appendArgument(key, value);
            return this;
        }

        @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.ArgsBuilder
        public DefaultArgsBuilder arg(@NotNull String key, int i) {
            Intrinsics.checkNotNullParameter(key, "key");
            appendArgument(key, Integer.valueOf(i));
            return this;
        }

        @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.ArgsBuilder
        public DefaultArgsBuilder arg(@NotNull String key, long j) {
            Intrinsics.checkNotNullParameter(key, "key");
            appendArgument(key, Long.valueOf(j));
            return this;
        }

        @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.ArgsBuilder
        public DefaultArgsBuilder arg(@NotNull String key, double d) {
            Intrinsics.checkNotNullParameter(key, "key");
            appendArgument(key, Double.valueOf(d));
            return this;
        }

        private final StringBuilder appendArgument(String str, Object obj) {
            StringBuilder sb = this.stringBuilder;
            sb.append(';');
            sb.append(str + "=" + obj);
            return sb;
        }
    }
}
