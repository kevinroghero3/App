package com.facebook.fresco.vito.options;

import com.facebook.common.internal.Objects;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import io.sentry.protocol.SentryThread;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public class EncodedImageOptions {
    private final ImageRequest.CacheChoice cacheChoice;
    private final String diskCacheId;
    private final Priority priority;

    public EncodedImageOptions(@NotNull Builder<?> builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.priority = builder.getPriority$options_release();
        this.cacheChoice = builder.getCacheChoice$options_release();
        String diskCacheId$options_release = builder.getDiskCacheId$options_release();
        this.diskCacheId = diskCacheId$options_release;
        if (builder.getCacheChoice$options_release() == ImageRequest.CacheChoice.DYNAMIC) {
            if (diskCacheId$options_release == null) {
                throw new ImageRequestBuilder.BuilderException("Disk cache id must be set for dynamic cache choice");
            }
        } else if (diskCacheId$options_release != null && diskCacheId$options_release.length() != 0) {
            throw new ImageRequestBuilder.BuilderException("Ensure that if you want to use a disk cache id, you set the CacheChoice to DYNAMIC");
        }
    }

    public final Priority getPriority() {
        return this.priority;
    }

    public final ImageRequest.CacheChoice getCacheChoice() {
        return this.cacheChoice;
    }

    public final String getDiskCacheId() {
        return this.diskCacheId;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.areEqual(getClass(), obj.getClass())) {
            return false;
        }
        return equalEncodedOptions((EncodedImageOptions) obj);
    }

    protected final boolean equalEncodedOptions(@NotNull EncodedImageOptions other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return Objects.equal(this.priority, other.priority) && Objects.equal(this.cacheChoice, other.cacheChoice) && Objects.equal(this.diskCacheId, other.diskCacheId);
    }

    public int hashCode() {
        Priority priority = this.priority;
        int iHashCode = priority != null ? priority.hashCode() : 0;
        ImageRequest.CacheChoice cacheChoice = this.cacheChoice;
        int iHashCode2 = cacheChoice != null ? cacheChoice.hashCode() : 0;
        String str = this.diskCacheId;
        return (((iHashCode * 31) + iHashCode2) * 31) + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        String string = toStringHelper().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    protected Objects.ToStringHelper toStringHelper() {
        Objects.ToStringHelper toStringHelperAdd = Objects.toStringHelper(this).add(SentryThread.JsonKeys.PRIORITY, this.priority).add("cacheChoice", this.cacheChoice).add("diskCacheId", this.diskCacheId);
        Intrinsics.checkNotNullExpressionValue(toStringHelperAdd, "add(...)");
        return toStringHelperAdd;
    }

    public static class Builder<T extends Builder<T>> {
        private ImageRequest.CacheChoice cacheChoice;
        private String diskCacheId;
        private Priority priority;

        public final Priority getPriority$options_release() {
            return this.priority;
        }

        public final void setPriority$options_release(@Nullable Priority priority) {
            this.priority = priority;
        }

        public final ImageRequest.CacheChoice getCacheChoice$options_release() {
            return this.cacheChoice;
        }

        public final void setCacheChoice$options_release(@Nullable ImageRequest.CacheChoice cacheChoice) {
            this.cacheChoice = cacheChoice;
        }

        public final String getDiskCacheId$options_release() {
            return this.diskCacheId;
        }

        public final void setDiskCacheId$options_release(@Nullable String str) {
            this.diskCacheId = str;
        }

        protected Builder() {
        }

        protected Builder(@NotNull EncodedImageOptions defaultOptions) {
            Intrinsics.checkNotNullParameter(defaultOptions, "defaultOptions");
            this.priority = defaultOptions.getPriority();
            this.cacheChoice = defaultOptions.getCacheChoice();
            this.diskCacheId = defaultOptions.getDiskCacheId();
        }

        public final T priority(@Nullable Priority priority) {
            this.priority = priority;
            return (T) getThis();
        }

        public final T cacheChoice(@Nullable ImageRequest.CacheChoice cacheChoice) {
            this.cacheChoice = cacheChoice;
            return (T) getThis();
        }

        public final T diskCacheId(@Nullable String str) {
            this.diskCacheId = str;
            return (T) getThis();
        }

        public EncodedImageOptions build() {
            return new EncodedImageOptions(this);
        }

        protected final T getThis() {
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.facebook.fresco.vito.options.EncodedImageOptions.Builder");
            return this;
        }

        private final T modify(Function1<? super Builder<T>, Unit> function1) {
            function1.invoke(this);
            return (T) getThis();
        }
    }
}
