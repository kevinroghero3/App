package io.sentry.android.replay;

import android.content.Context;
import ch.qos.logback.core.CoreConstants;
import io.sentry.SentryReplayOptions;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class ScreenshotRecorderConfig {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final int bitRate;
    private final int frameRate;
    private final int recordingHeight;
    private final int recordingWidth;
    private final float scaleFactorX;
    private final float scaleFactorY;

    public static /* synthetic */ ScreenshotRecorderConfig copy$default(ScreenshotRecorderConfig screenshotRecorderConfig, int i, int i2, float f, float f2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = screenshotRecorderConfig.recordingWidth;
        }
        if ((i5 & 2) != 0) {
            i2 = screenshotRecorderConfig.recordingHeight;
        }
        int i6 = i2;
        if ((i5 & 4) != 0) {
            f = screenshotRecorderConfig.scaleFactorX;
        }
        float f3 = f;
        if ((i5 & 8) != 0) {
            f2 = screenshotRecorderConfig.scaleFactorY;
        }
        float f4 = f2;
        if ((i5 & 16) != 0) {
            i3 = screenshotRecorderConfig.frameRate;
        }
        int i7 = i3;
        if ((i5 & 32) != 0) {
            i4 = screenshotRecorderConfig.bitRate;
        }
        return screenshotRecorderConfig.copy(i, i6, f3, f4, i7, i4);
    }

    public final int component1() {
        return this.recordingWidth;
    }

    public final int component2() {
        return this.recordingHeight;
    }

    public final float component3() {
        return this.scaleFactorX;
    }

    public final float component4() {
        return this.scaleFactorY;
    }

    public final int component5() {
        return this.frameRate;
    }

    public final int component6() {
        return this.bitRate;
    }

    public final ScreenshotRecorderConfig copy(int i, int i2, float f, float f2, int i3, int i4) {
        return new ScreenshotRecorderConfig(i, i2, f, f2, i3, i4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ScreenshotRecorderConfig)) {
            return false;
        }
        ScreenshotRecorderConfig screenshotRecorderConfig = (ScreenshotRecorderConfig) obj;
        return this.recordingWidth == screenshotRecorderConfig.recordingWidth && this.recordingHeight == screenshotRecorderConfig.recordingHeight && Float.compare(this.scaleFactorX, screenshotRecorderConfig.scaleFactorX) == 0 && Float.compare(this.scaleFactorY, screenshotRecorderConfig.scaleFactorY) == 0 && this.frameRate == screenshotRecorderConfig.frameRate && this.bitRate == screenshotRecorderConfig.bitRate;
    }

    public int hashCode() {
        return (((((((((Integer.hashCode(this.recordingWidth) * 31) + Integer.hashCode(this.recordingHeight)) * 31) + Float.hashCode(this.scaleFactorX)) * 31) + Float.hashCode(this.scaleFactorY)) * 31) + Integer.hashCode(this.frameRate)) * 31) + Integer.hashCode(this.bitRate);
    }

    public String toString() {
        return "ScreenshotRecorderConfig(recordingWidth=" + this.recordingWidth + ", recordingHeight=" + this.recordingHeight + ", scaleFactorX=" + this.scaleFactorX + ", scaleFactorY=" + this.scaleFactorY + ", frameRate=" + this.frameRate + ", bitRate=" + this.bitRate + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public ScreenshotRecorderConfig(int i, int i2, float f, float f2, int i3, int i4) {
        this.recordingWidth = i;
        this.recordingHeight = i2;
        this.scaleFactorX = f;
        this.scaleFactorY = f2;
        this.frameRate = i3;
        this.bitRate = i4;
    }

    public final int getRecordingWidth() {
        return this.recordingWidth;
    }

    public final int getRecordingHeight() {
        return this.recordingHeight;
    }

    public final float getScaleFactorX() {
        return this.scaleFactorX;
    }

    public final float getScaleFactorY() {
        return this.scaleFactorY;
    }

    public final int getFrameRate() {
        return this.frameRate;
    }

    public final int getBitRate() {
        return this.bitRate;
    }

    public ScreenshotRecorderConfig(float f, float f2) {
        this(0, 0, f, f2, 0, 0);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final int adjustToBlockSize(int i) {
            int i2 = i % 16;
            return i2 <= 8 ? i - i2 : i + (16 - i2);
        }

        public final ScreenshotRecorderConfig fromSize(@NotNull Context context, @NotNull SentryReplayOptions sessionReplay, int i, int i2) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(sessionReplay, "sessionReplay");
            float f = i2;
            float f2 = i;
            Pair pair = TuplesKt.to(Integer.valueOf(adjustToBlockSize(MathKt__MathJVMKt.roundToInt((f / context.getResources().getDisplayMetrics().density) * sessionReplay.getQuality().sizeScale))), Integer.valueOf(adjustToBlockSize(MathKt__MathJVMKt.roundToInt((f2 / context.getResources().getDisplayMetrics().density) * sessionReplay.getQuality().sizeScale))));
            int iIntValue = ((Number) pair.component1()).intValue();
            int iIntValue2 = ((Number) pair.component2()).intValue();
            return new ScreenshotRecorderConfig(iIntValue2, iIntValue, iIntValue2 / f2, iIntValue / f, sessionReplay.getFrameRate(), sessionReplay.getQuality().bitRate);
        }
    }
}
