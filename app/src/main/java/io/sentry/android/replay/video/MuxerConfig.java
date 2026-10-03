package io.sentry.android.replay.video;

import ch.qos.logback.core.CoreConstants;
import java.io.File;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class MuxerConfig {
    public static final int $stable = 8;
    private final int bitRate;
    private final File file;
    private final int frameRate;
    private final String mimeType;
    private int recordingHeight;
    private int recordingWidth;

    public static /* synthetic */ MuxerConfig copy$default(MuxerConfig muxerConfig, File file, int i, int i2, int i3, int i4, String str, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            file = muxerConfig.file;
        }
        if ((i5 & 2) != 0) {
            i = muxerConfig.recordingWidth;
        }
        int i6 = i;
        if ((i5 & 4) != 0) {
            i2 = muxerConfig.recordingHeight;
        }
        int i7 = i2;
        if ((i5 & 8) != 0) {
            i3 = muxerConfig.frameRate;
        }
        int i8 = i3;
        if ((i5 & 16) != 0) {
            i4 = muxerConfig.bitRate;
        }
        int i9 = i4;
        if ((i5 & 32) != 0) {
            str = muxerConfig.mimeType;
        }
        return muxerConfig.copy(file, i6, i7, i8, i9, str);
    }

    public final File component1() {
        return this.file;
    }

    public final int component2() {
        return this.recordingWidth;
    }

    public final int component3() {
        return this.recordingHeight;
    }

    public final int component4() {
        return this.frameRate;
    }

    public final int component5() {
        return this.bitRate;
    }

    public final String component6() {
        return this.mimeType;
    }

    public final MuxerConfig copy(@NotNull File file, int i, int i2, int i3, int i4, @NotNull String mimeType) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        return new MuxerConfig(file, i, i2, i3, i4, mimeType);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MuxerConfig)) {
            return false;
        }
        MuxerConfig muxerConfig = (MuxerConfig) obj;
        return Intrinsics.areEqual(this.file, muxerConfig.file) && this.recordingWidth == muxerConfig.recordingWidth && this.recordingHeight == muxerConfig.recordingHeight && this.frameRate == muxerConfig.frameRate && this.bitRate == muxerConfig.bitRate && Intrinsics.areEqual(this.mimeType, muxerConfig.mimeType);
    }

    public int hashCode() {
        return (((((((((this.file.hashCode() * 31) + Integer.hashCode(this.recordingWidth)) * 31) + Integer.hashCode(this.recordingHeight)) * 31) + Integer.hashCode(this.frameRate)) * 31) + Integer.hashCode(this.bitRate)) * 31) + this.mimeType.hashCode();
    }

    public String toString() {
        return "MuxerConfig(file=" + this.file + ", recordingWidth=" + this.recordingWidth + ", recordingHeight=" + this.recordingHeight + ", frameRate=" + this.frameRate + ", bitRate=" + this.bitRate + ", mimeType=" + this.mimeType + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public MuxerConfig(@NotNull File file, int i, int i2, int i3, int i4, @NotNull String mimeType) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        this.file = file;
        this.recordingWidth = i;
        this.recordingHeight = i2;
        this.frameRate = i3;
        this.bitRate = i4;
        this.mimeType = mimeType;
    }

    public final File getFile() {
        return this.file;
    }

    public final int getRecordingWidth() {
        return this.recordingWidth;
    }

    public final void setRecordingWidth(int i) {
        this.recordingWidth = i;
    }

    public final int getRecordingHeight() {
        return this.recordingHeight;
    }

    public final void setRecordingHeight(int i) {
        this.recordingHeight = i;
    }

    public final int getFrameRate() {
        return this.frameRate;
    }

    public final int getBitRate() {
        return this.bitRate;
    }

    public /* synthetic */ MuxerConfig(File file, int i, int i2, int i3, int i4, String str, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, i, i2, i3, i4, (i5 & 32) != 0 ? "video/avc" : str);
    }

    public final String getMimeType() {
        return this.mimeType;
    }
}
