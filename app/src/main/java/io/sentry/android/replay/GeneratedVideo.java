package io.sentry.android.replay;

import ch.qos.logback.core.CoreConstants;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class GeneratedVideo {
    public static final int $stable = 8;
    private final long duration;
    private final int frameCount;
    private final File video;

    public static /* synthetic */ GeneratedVideo copy$default(GeneratedVideo generatedVideo, File file, int i, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            file = generatedVideo.video;
        }
        if ((i2 & 2) != 0) {
            i = generatedVideo.frameCount;
        }
        if ((i2 & 4) != 0) {
            j = generatedVideo.duration;
        }
        return generatedVideo.copy(file, i, j);
    }

    public final File component1() {
        return this.video;
    }

    public final int component2() {
        return this.frameCount;
    }

    public final long component3() {
        return this.duration;
    }

    public final GeneratedVideo copy(@NotNull File video, int i, long j) {
        Intrinsics.checkNotNullParameter(video, "video");
        return new GeneratedVideo(video, i, j);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GeneratedVideo)) {
            return false;
        }
        GeneratedVideo generatedVideo = (GeneratedVideo) obj;
        return Intrinsics.areEqual(this.video, generatedVideo.video) && this.frameCount == generatedVideo.frameCount && this.duration == generatedVideo.duration;
    }

    public int hashCode() {
        return (((this.video.hashCode() * 31) + Integer.hashCode(this.frameCount)) * 31) + Long.hashCode(this.duration);
    }

    public String toString() {
        return "GeneratedVideo(video=" + this.video + ", frameCount=" + this.frameCount + ", duration=" + this.duration + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public GeneratedVideo(@NotNull File video, int i, long j) {
        Intrinsics.checkNotNullParameter(video, "video");
        this.video = video;
        this.frameCount = i;
        this.duration = j;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final int getFrameCount() {
        return this.frameCount;
    }

    public final File getVideo() {
        return this.video;
    }
}
