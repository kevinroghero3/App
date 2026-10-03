package io.sentry;

import androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat;
import io.sentry.protocol.SdkVersion;
import io.sentry.util.SampleRateUtils;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class SentryReplayOptions {
    public static final String ANDROIDX_MEDIA_VIEW_CLASS_NAME = "androidx.media3.ui.PlayerView";
    public static final String EXOPLAYER_CLASS_NAME = "com.google.android.exoplayer2.ui.PlayerView";
    public static final String EXOPLAYER_STYLED_CLASS_NAME = "com.google.android.exoplayer2.ui.StyledPlayerView";
    public static final String IMAGE_VIEW_CLASS_NAME = "android.widget.ImageView";
    public static final String TEXT_VIEW_CLASS_NAME = "android.widget.TextView";
    public static final String VIDEO_VIEW_CLASS_NAME = "android.widget.VideoView";
    public static final String WEB_VIEW_CLASS_NAME = "android.webkit.WebView";
    private boolean debug;
    private long errorReplayDuration;
    private int frameRate;
    private Set<String> maskViewClasses;
    private String maskViewContainerClass;
    private Double onErrorSampleRate;
    private SentryReplayQuality quality;
    private SdkVersion sdkVersion;
    private long sessionDuration;
    private Double sessionSampleRate;
    private long sessionSegmentDuration;
    private boolean trackConfiguration;
    private Set<String> unmaskViewClasses;
    private String unmaskViewContainerClass;

    /* JADX INFO: loaded from: classes3.dex */
    public enum SentryReplayQuality {
        LOW(0.8f, 50000, 10),
        MEDIUM(1.0f, 75000, 30),
        HIGH(1.0f, AndroidComposeViewAccessibilityDelegateCompat.ParcelSafeTextLength, 50);

        public final int bitRate;
        public final int screenshotQuality;
        public final float sizeScale;

        SentryReplayQuality(float f, int i, int i2) {
            this.sizeScale = f;
            this.bitRate = i;
            this.screenshotQuality = i2;
        }

        public String serializedName() {
            return name().toLowerCase(Locale.ROOT);
        }
    }

    public SentryReplayOptions(boolean z, @Nullable SdkVersion sdkVersion) {
        this.maskViewClasses = new CopyOnWriteArraySet();
        this.unmaskViewClasses = new CopyOnWriteArraySet();
        this.maskViewContainerClass = null;
        this.unmaskViewContainerClass = null;
        this.quality = SentryReplayQuality.MEDIUM;
        this.frameRate = 1;
        this.errorReplayDuration = 30000L;
        this.sessionSegmentDuration = 5000L;
        this.sessionDuration = 3600000L;
        this.trackConfiguration = true;
        this.debug = false;
        if (z) {
            return;
        }
        setMaskAllText(true);
        setMaskAllImages(true);
        this.maskViewClasses.add(WEB_VIEW_CLASS_NAME);
        this.maskViewClasses.add(VIDEO_VIEW_CLASS_NAME);
        this.maskViewClasses.add(ANDROIDX_MEDIA_VIEW_CLASS_NAME);
        this.maskViewClasses.add(EXOPLAYER_CLASS_NAME);
        this.maskViewClasses.add(EXOPLAYER_STYLED_CLASS_NAME);
        this.sdkVersion = sdkVersion;
    }

    public SentryReplayOptions(@Nullable Double d, @Nullable Double d2, @Nullable SdkVersion sdkVersion) {
        this(false, sdkVersion);
        this.sessionSampleRate = d;
        this.onErrorSampleRate = d2;
        this.sdkVersion = sdkVersion;
    }

    public Double getOnErrorSampleRate() {
        return this.onErrorSampleRate;
    }

    public boolean isSessionReplayEnabled() {
        return getSessionSampleRate() != null && getSessionSampleRate().doubleValue() > 0.0d;
    }

    public void setOnErrorSampleRate(@Nullable Double d) {
        if (!SampleRateUtils.isValidSampleRate(d)) {
            throw new IllegalArgumentException("The value " + d + " is not valid. Use null to disable or values >= 0.0 and <= 1.0.");
        }
        this.onErrorSampleRate = d;
    }

    public Double getSessionSampleRate() {
        return this.sessionSampleRate;
    }

    public boolean isSessionReplayForErrorsEnabled() {
        return getOnErrorSampleRate() != null && getOnErrorSampleRate().doubleValue() > 0.0d;
    }

    public void setSessionSampleRate(@Nullable Double d) {
        if (!SampleRateUtils.isValidSampleRate(d)) {
            throw new IllegalArgumentException("The value " + d + " is not valid. Use null to disable or values >= 0.0 and <= 1.0.");
        }
        this.sessionSampleRate = d;
    }

    public void setMaskAllText(boolean z) {
        if (z) {
            addMaskViewClass("android.widget.TextView");
            this.unmaskViewClasses.remove("android.widget.TextView");
        } else {
            addUnmaskViewClass("android.widget.TextView");
            this.maskViewClasses.remove("android.widget.TextView");
        }
    }

    public void setMaskAllImages(boolean z) {
        if (z) {
            addMaskViewClass(IMAGE_VIEW_CLASS_NAME);
            this.unmaskViewClasses.remove(IMAGE_VIEW_CLASS_NAME);
        } else {
            addUnmaskViewClass(IMAGE_VIEW_CLASS_NAME);
            this.maskViewClasses.remove(IMAGE_VIEW_CLASS_NAME);
        }
    }

    public Set<String> getMaskViewClasses() {
        return this.maskViewClasses;
    }

    public void addMaskViewClass(@NotNull String str) {
        this.maskViewClasses.add(str);
    }

    public Set<String> getUnmaskViewClasses() {
        return this.unmaskViewClasses;
    }

    public void addUnmaskViewClass(@NotNull String str) {
        this.unmaskViewClasses.add(str);
    }

    public SentryReplayQuality getQuality() {
        return this.quality;
    }

    public void setQuality(@NotNull SentryReplayQuality sentryReplayQuality) {
        this.quality = sentryReplayQuality;
    }

    public int getFrameRate() {
        return this.frameRate;
    }

    public long getErrorReplayDuration() {
        return this.errorReplayDuration;
    }

    public long getSessionSegmentDuration() {
        return this.sessionSegmentDuration;
    }

    public long getSessionDuration() {
        return this.sessionDuration;
    }

    public void setMaskViewContainerClass(@NotNull String str) {
        addMaskViewClass(str);
        this.maskViewContainerClass = str;
    }

    public void setUnmaskViewContainerClass(@NotNull String str) {
        this.unmaskViewContainerClass = str;
    }

    public String getMaskViewContainerClass() {
        return this.maskViewContainerClass;
    }

    public String getUnmaskViewContainerClass() {
        return this.unmaskViewContainerClass;
    }

    public boolean isTrackConfiguration() {
        return this.trackConfiguration;
    }

    public void setTrackConfiguration(boolean z) {
        this.trackConfiguration = z;
    }

    public SdkVersion getSdkVersion() {
        return this.sdkVersion;
    }

    public void setSdkVersion(@Nullable SdkVersion sdkVersion) {
        this.sdkVersion = sdkVersion;
    }

    public boolean isDebug() {
        return this.debug;
    }

    public void setDebug(boolean z) {
        this.debug = z;
    }
}
