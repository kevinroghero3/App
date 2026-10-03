package com.facebook.systrace;

import androidx.camera.core.impl.Quirks$$ExternalSyntheticBackport0;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public final class SystraceMessage {
    public static boolean INCLUDE_ARGS;
    public static final SystraceMessage INSTANCE = new SystraceMessage();

    public static abstract class Builder {
        public abstract Builder arg(@NotNull String str, double d);

        public abstract Builder arg(@NotNull String str, int i);

        public abstract Builder arg(@NotNull String str, long j);

        public abstract Builder arg(@NotNull String str, @NotNull Object obj);

        public abstract void flush();
    }

    private SystraceMessage() {
    }

    @JvmStatic
    public static final Builder beginSection(long j, @NotNull String sectionName) {
        Intrinsics.checkNotNullParameter(sectionName, "sectionName");
        return new StartSectionBuilder(j, sectionName);
    }

    @JvmStatic
    public static final Builder endSection(long j) {
        return new EndSectionBuilder(j);
    }

    static final class StartSectionBuilder extends Builder {
        private final List<String> args;
        private final String sectionName;
        private final long tag;

        public StartSectionBuilder(long j, @NotNull String sectionName) {
            Intrinsics.checkNotNullParameter(sectionName, "sectionName");
            this.tag = j;
            this.sectionName = sectionName;
            this.args = new ArrayList();
        }

        @Override // com.facebook.systrace.SystraceMessage.Builder
        public void flush() {
            String str;
            long j = this.tag;
            String str2 = this.sectionName;
            if (SystraceMessage.INCLUDE_ARGS && !this.args.isEmpty()) {
                str = " (" + Quirks$$ExternalSyntheticBackport0.m(", ", this.args) + ")";
            } else {
                str = "";
            }
            Systrace.beginSection(j, str2 + str);
        }

        @Override // com.facebook.systrace.SystraceMessage.Builder
        public Builder arg(@NotNull String key, @NotNull Object value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            addArg(key, value.toString());
            return this;
        }

        @Override // com.facebook.systrace.SystraceMessage.Builder
        public Builder arg(@NotNull String key, int i) {
            Intrinsics.checkNotNullParameter(key, "key");
            addArg(key, String.valueOf(i));
            return this;
        }

        @Override // com.facebook.systrace.SystraceMessage.Builder
        public Builder arg(@NotNull String key, long j) {
            Intrinsics.checkNotNullParameter(key, "key");
            addArg(key, String.valueOf(j));
            return this;
        }

        @Override // com.facebook.systrace.SystraceMessage.Builder
        public Builder arg(@NotNull String key, double d) {
            Intrinsics.checkNotNullParameter(key, "key");
            addArg(key, String.valueOf(d));
            return this;
        }

        private final void addArg(String str, String str2) {
            this.args.add(str + ": " + str2);
        }
    }

    static final class EndSectionBuilder extends Builder {
        private final long tag;

        @Override // com.facebook.systrace.SystraceMessage.Builder
        public Builder arg(@NotNull String key, double d) {
            Intrinsics.checkNotNullParameter(key, "key");
            return this;
        }

        @Override // com.facebook.systrace.SystraceMessage.Builder
        public Builder arg(@NotNull String key, int i) {
            Intrinsics.checkNotNullParameter(key, "key");
            return this;
        }

        @Override // com.facebook.systrace.SystraceMessage.Builder
        public Builder arg(@NotNull String key, long j) {
            Intrinsics.checkNotNullParameter(key, "key");
            return this;
        }

        @Override // com.facebook.systrace.SystraceMessage.Builder
        public Builder arg(@NotNull String key, @NotNull Object value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            return this;
        }

        public EndSectionBuilder(long j) {
            this.tag = j;
        }

        @Override // com.facebook.systrace.SystraceMessage.Builder
        public void flush() {
            Systrace.endSection(this.tag);
        }
    }
}
