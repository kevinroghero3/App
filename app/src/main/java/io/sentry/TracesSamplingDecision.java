package io.sentry;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class TracesSamplingDecision {
    private final Double profileSampleRate;
    private final Boolean profileSampled;
    private final Double sampleRand;
    private final Double sampleRate;
    private final Boolean sampled;

    public TracesSamplingDecision(@NotNull Boolean bool) {
        this(bool, null);
    }

    public TracesSamplingDecision(@NotNull Boolean bool, @Nullable Double d) {
        this(bool, d, null, Boolean.FALSE, null);
    }

    public TracesSamplingDecision(@NotNull Boolean bool, @Nullable Double d, @Nullable Double d2) {
        this(bool, d, d2, Boolean.FALSE, null);
    }

    public TracesSamplingDecision(@NotNull Boolean bool, @Nullable Double d, @NotNull Boolean bool2, @Nullable Double d2) {
        this(bool, d, null, bool2, d2);
    }

    public TracesSamplingDecision(@NotNull Boolean bool, @Nullable Double d, @Nullable Double d2, @NotNull Boolean bool2, @Nullable Double d3) {
        this.sampled = bool;
        this.sampleRate = d;
        this.sampleRand = d2;
        this.profileSampled = Boolean.valueOf(bool.booleanValue() && bool2.booleanValue());
        this.profileSampleRate = d3;
    }

    public Boolean getSampled() {
        return this.sampled;
    }

    public Double getSampleRate() {
        return this.sampleRate;
    }

    public Double getSampleRand() {
        return this.sampleRand;
    }

    public Boolean getProfileSampled() {
        return this.profileSampled;
    }

    public Double getProfileSampleRate() {
        return this.profileSampleRate;
    }
}
