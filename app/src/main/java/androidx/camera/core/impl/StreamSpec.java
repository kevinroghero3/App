package androidx.camera.core.impl;

import android.util.Range;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.camera.core.DynamicRange;

/* JADX INFO: loaded from: classes2.dex */
public abstract class StreamSpec {
    public static final Range<Integer> FRAME_RATE_RANGE_UNSPECIFIED = new Range<>(0, 0);

    public abstract DynamicRange getDynamicRange();

    public abstract Range<Integer> getExpectedFrameRateRange();

    public abstract Config getImplementationOptions();

    public abstract Size getResolution();

    public abstract boolean getZslDisabled();

    public abstract Builder toBuilder();

    public static Builder builder(@NonNull Size size) {
        return new AutoValue_StreamSpec.Builder().setResolution(size).setExpectedFrameRateRange(FRAME_RATE_RANGE_UNSPECIFIED).setDynamicRange(DynamicRange.SDR).setZslDisabled(false);
    }

    public static abstract class Builder {
        public abstract StreamSpec build();

        public abstract Builder setDynamicRange(@NonNull DynamicRange dynamicRange);

        public abstract Builder setExpectedFrameRateRange(@NonNull Range<Integer> range);

        public abstract Builder setImplementationOptions(@NonNull Config config);

        public abstract Builder setResolution(@NonNull Size size);

        public abstract Builder setZslDisabled(boolean z);

        Builder() {
        }
    }
}
