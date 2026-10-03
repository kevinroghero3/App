package com.mrousavy.camera.core.types;

import android.util.Size;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class Video {
    private final long durationMs;
    private final String path;
    private final Size size;

    public static /* synthetic */ Video copy$default(Video video, String str, long j, Size size, int i, Object obj) {
        if ((i & 1) != 0) {
            str = video.path;
        }
        if ((i & 2) != 0) {
            j = video.durationMs;
        }
        if ((i & 4) != 0) {
            size = video.size;
        }
        return video.copy(str, j, size);
    }

    public final String component1() {
        return this.path;
    }

    public final long component2() {
        return this.durationMs;
    }

    public final Size component3() {
        return this.size;
    }

    public final Video copy(@NotNull String path, long j, @NotNull Size size) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(size, "size");
        return new Video(path, j, size);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Video)) {
            return false;
        }
        Video video = (Video) obj;
        return Intrinsics.areEqual(this.path, video.path) && this.durationMs == video.durationMs && Intrinsics.areEqual(this.size, video.size);
    }

    public int hashCode() {
        return (((this.path.hashCode() * 31) + Long.hashCode(this.durationMs)) * 31) + this.size.hashCode();
    }

    public String toString() {
        return "Video(path=" + this.path + ", durationMs=" + this.durationMs + ", size=" + this.size + ")";
    }

    public Video(@NotNull String path, long j, @NotNull Size size) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(size, "size");
        this.path = path;
        this.durationMs = j;
        this.size = size;
    }

    public final long getDurationMs() {
        return this.durationMs;
    }

    public final String getPath() {
        return this.path;
    }

    public final Size getSize() {
        return this.size;
    }
}
