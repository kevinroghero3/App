package com.mrousavy.camera.core;

import android.util.Range;
import com.mrousavy.camera.core.types.CameraDeviceFormat;
import com.mrousavy.camera.core.types.CodeType;
import com.mrousavy.camera.core.types.OutputOrientation;
import com.mrousavy.camera.core.types.PixelFormat;
import com.mrousavy.camera.core.types.QualityBalance;
import com.mrousavy.camera.core.types.Torch;
import com.mrousavy.camera.core.types.VideoStabilizationMode;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class CameraConfiguration {
    public static final Companion Companion = new Companion(null);
    private Output<Audio> audio;
    private String cameraId;
    private Output<CodeScanner> codeScanner;
    private boolean enableLocation;
    private boolean enableLowLightBoost;
    private Double exposure;
    private CameraDeviceFormat format;
    private Output<FrameProcessor> frameProcessor;
    private boolean isActive;
    private Integer maxFps;
    private Integer minFps;
    private OutputOrientation outputOrientation;
    private Output<Photo> photo;
    private Output<Preview> preview;
    private Torch torch;
    private Output<Video> video;
    private VideoStabilizationMode videoStabilizationMode;
    private float zoom;

    public static final class AbortThrow extends Throwable {
    }

    public CameraConfiguration() {
        this(null, null, null, null, null, null, null, null, false, null, null, false, null, null, null, 0.0f, false, null, 262143, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CameraConfiguration copy$default(CameraConfiguration cameraConfiguration, String str, Output output, Output output2, Output output3, Output output4, Output output5, Integer num, Integer num2, boolean z, OutputOrientation outputOrientation, CameraDeviceFormat cameraDeviceFormat, boolean z2, Torch torch, VideoStabilizationMode videoStabilizationMode, Double d, float f, boolean z3, Output output6, int i, Object obj) {
        return cameraConfiguration.copy((i & 1) != 0 ? cameraConfiguration.cameraId : str, (i & 2) != 0 ? cameraConfiguration.preview : output, (i & 4) != 0 ? cameraConfiguration.photo : output2, (i & 8) != 0 ? cameraConfiguration.video : output3, (i & 16) != 0 ? cameraConfiguration.frameProcessor : output4, (i & 32) != 0 ? cameraConfiguration.codeScanner : output5, (i & 64) != 0 ? cameraConfiguration.minFps : num, (i & 128) != 0 ? cameraConfiguration.maxFps : num2, (i & 256) != 0 ? cameraConfiguration.enableLocation : z, (i & 512) != 0 ? cameraConfiguration.outputOrientation : outputOrientation, (i & 1024) != 0 ? cameraConfiguration.format : cameraDeviceFormat, (i & 2048) != 0 ? cameraConfiguration.enableLowLightBoost : z2, (i & 4096) != 0 ? cameraConfiguration.torch : torch, (i & 8192) != 0 ? cameraConfiguration.videoStabilizationMode : videoStabilizationMode, (i & 16384) != 0 ? cameraConfiguration.exposure : d, (i & 32768) != 0 ? cameraConfiguration.zoom : f, (i & 65536) != 0 ? cameraConfiguration.isActive : z3, (i & 131072) != 0 ? cameraConfiguration.audio : output6);
    }

    public final String component1() {
        return this.cameraId;
    }

    public final OutputOrientation component10() {
        return this.outputOrientation;
    }

    public final CameraDeviceFormat component11() {
        return this.format;
    }

    public final boolean component12() {
        return this.enableLowLightBoost;
    }

    public final Torch component13() {
        return this.torch;
    }

    public final VideoStabilizationMode component14() {
        return this.videoStabilizationMode;
    }

    public final Double component15() {
        return this.exposure;
    }

    public final float component16() {
        return this.zoom;
    }

    public final boolean component17() {
        return this.isActive;
    }

    public final Output<Audio> component18() {
        return this.audio;
    }

    public final Output<Preview> component2() {
        return this.preview;
    }

    public final Output<Photo> component3() {
        return this.photo;
    }

    public final Output<Video> component4() {
        return this.video;
    }

    public final Output<FrameProcessor> component5() {
        return this.frameProcessor;
    }

    public final Output<CodeScanner> component6() {
        return this.codeScanner;
    }

    public final Integer component7() {
        return this.minFps;
    }

    public final Integer component8() {
        return this.maxFps;
    }

    public final boolean component9() {
        return this.enableLocation;
    }

    public final CameraConfiguration copy(@Nullable String str, @NotNull Output<Preview> preview, @NotNull Output<Photo> photo, @NotNull Output<Video> video, @NotNull Output<FrameProcessor> frameProcessor, @NotNull Output<CodeScanner> codeScanner, @Nullable Integer num, @Nullable Integer num2, boolean z, @NotNull OutputOrientation outputOrientation, @Nullable CameraDeviceFormat cameraDeviceFormat, boolean z2, @NotNull Torch torch, @NotNull VideoStabilizationMode videoStabilizationMode, @Nullable Double d, float f, boolean z3, @NotNull Output<Audio> audio) {
        Intrinsics.checkNotNullParameter(preview, "preview");
        Intrinsics.checkNotNullParameter(photo, "photo");
        Intrinsics.checkNotNullParameter(video, "video");
        Intrinsics.checkNotNullParameter(frameProcessor, "frameProcessor");
        Intrinsics.checkNotNullParameter(codeScanner, "codeScanner");
        Intrinsics.checkNotNullParameter(outputOrientation, "outputOrientation");
        Intrinsics.checkNotNullParameter(torch, "torch");
        Intrinsics.checkNotNullParameter(videoStabilizationMode, "videoStabilizationMode");
        Intrinsics.checkNotNullParameter(audio, "audio");
        return new CameraConfiguration(str, preview, photo, video, frameProcessor, codeScanner, num, num2, z, outputOrientation, cameraDeviceFormat, z2, torch, videoStabilizationMode, d, f, z3, audio);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CameraConfiguration)) {
            return false;
        }
        CameraConfiguration cameraConfiguration = (CameraConfiguration) obj;
        return Intrinsics.areEqual(this.cameraId, cameraConfiguration.cameraId) && Intrinsics.areEqual(this.preview, cameraConfiguration.preview) && Intrinsics.areEqual(this.photo, cameraConfiguration.photo) && Intrinsics.areEqual(this.video, cameraConfiguration.video) && Intrinsics.areEqual(this.frameProcessor, cameraConfiguration.frameProcessor) && Intrinsics.areEqual(this.codeScanner, cameraConfiguration.codeScanner) && Intrinsics.areEqual(this.minFps, cameraConfiguration.minFps) && Intrinsics.areEqual(this.maxFps, cameraConfiguration.maxFps) && this.enableLocation == cameraConfiguration.enableLocation && this.outputOrientation == cameraConfiguration.outputOrientation && Intrinsics.areEqual(this.format, cameraConfiguration.format) && this.enableLowLightBoost == cameraConfiguration.enableLowLightBoost && this.torch == cameraConfiguration.torch && this.videoStabilizationMode == cameraConfiguration.videoStabilizationMode && Intrinsics.areEqual((Object) this.exposure, (Object) cameraConfiguration.exposure) && Float.compare(this.zoom, cameraConfiguration.zoom) == 0 && this.isActive == cameraConfiguration.isActive && Intrinsics.areEqual(this.audio, cameraConfiguration.audio);
    }

    public int hashCode() {
        String str = this.cameraId;
        int iHashCode = str == null ? 0 : str.hashCode();
        int iHashCode2 = this.preview.hashCode();
        int iHashCode3 = this.photo.hashCode();
        int iHashCode4 = this.video.hashCode();
        int iHashCode5 = this.frameProcessor.hashCode();
        int iHashCode6 = this.codeScanner.hashCode();
        Integer num = this.minFps;
        int iHashCode7 = num == null ? 0 : num.hashCode();
        Integer num2 = this.maxFps;
        int iHashCode8 = num2 == null ? 0 : num2.hashCode();
        int iHashCode9 = Boolean.hashCode(this.enableLocation);
        int iHashCode10 = this.outputOrientation.hashCode();
        CameraDeviceFormat cameraDeviceFormat = this.format;
        int iHashCode11 = cameraDeviceFormat == null ? 0 : cameraDeviceFormat.hashCode();
        int iHashCode12 = Boolean.hashCode(this.enableLowLightBoost);
        int iHashCode13 = this.torch.hashCode();
        int iHashCode14 = this.videoStabilizationMode.hashCode();
        Double d = this.exposure;
        return (((((((((((((((((((((((((((((((((iHashCode * 31) + iHashCode2) * 31) + iHashCode3) * 31) + iHashCode4) * 31) + iHashCode5) * 31) + iHashCode6) * 31) + iHashCode7) * 31) + iHashCode8) * 31) + iHashCode9) * 31) + iHashCode10) * 31) + iHashCode11) * 31) + iHashCode12) * 31) + iHashCode13) * 31) + iHashCode14) * 31) + (d == null ? 0 : d.hashCode())) * 31) + Float.hashCode(this.zoom)) * 31) + Boolean.hashCode(this.isActive)) * 31) + this.audio.hashCode();
    }

    public String toString() {
        return "CameraConfiguration(cameraId=" + this.cameraId + ", preview=" + this.preview + ", photo=" + this.photo + ", video=" + this.video + ", frameProcessor=" + this.frameProcessor + ", codeScanner=" + this.codeScanner + ", minFps=" + this.minFps + ", maxFps=" + this.maxFps + ", enableLocation=" + this.enableLocation + ", outputOrientation=" + this.outputOrientation + ", format=" + this.format + ", enableLowLightBoost=" + this.enableLowLightBoost + ", torch=" + this.torch + ", videoStabilizationMode=" + this.videoStabilizationMode + ", exposure=" + this.exposure + ", zoom=" + this.zoom + ", isActive=" + this.isActive + ", audio=" + this.audio + ")";
    }

    public CameraConfiguration(@Nullable String str, @NotNull Output<Preview> preview, @NotNull Output<Photo> photo, @NotNull Output<Video> video, @NotNull Output<FrameProcessor> frameProcessor, @NotNull Output<CodeScanner> codeScanner, @Nullable Integer num, @Nullable Integer num2, boolean z, @NotNull OutputOrientation outputOrientation, @Nullable CameraDeviceFormat cameraDeviceFormat, boolean z2, @NotNull Torch torch, @NotNull VideoStabilizationMode videoStabilizationMode, @Nullable Double d, float f, boolean z3, @NotNull Output<Audio> audio) {
        Intrinsics.checkNotNullParameter(preview, "preview");
        Intrinsics.checkNotNullParameter(photo, "photo");
        Intrinsics.checkNotNullParameter(video, "video");
        Intrinsics.checkNotNullParameter(frameProcessor, "frameProcessor");
        Intrinsics.checkNotNullParameter(codeScanner, "codeScanner");
        Intrinsics.checkNotNullParameter(outputOrientation, "outputOrientation");
        Intrinsics.checkNotNullParameter(torch, "torch");
        Intrinsics.checkNotNullParameter(videoStabilizationMode, "videoStabilizationMode");
        Intrinsics.checkNotNullParameter(audio, "audio");
        this.cameraId = str;
        this.preview = preview;
        this.photo = photo;
        this.video = video;
        this.frameProcessor = frameProcessor;
        this.codeScanner = codeScanner;
        this.minFps = num;
        this.maxFps = num2;
        this.enableLocation = z;
        this.outputOrientation = outputOrientation;
        this.format = cameraDeviceFormat;
        this.enableLowLightBoost = z2;
        this.torch = torch;
        this.videoStabilizationMode = videoStabilizationMode;
        this.exposure = d;
        this.zoom = f;
        this.isActive = z3;
        this.audio = audio;
    }

    public final String getCameraId() {
        return this.cameraId;
    }

    public final void setCameraId(@Nullable String str) {
        this.cameraId = str;
    }

    public /* synthetic */ CameraConfiguration(String str, Output output, Output output2, Output output3, Output output4, Output output5, Integer num, Integer num2, boolean z, OutputOrientation outputOrientation, CameraDeviceFormat cameraDeviceFormat, boolean z2, Torch torch, VideoStabilizationMode videoStabilizationMode, Double d, float f, boolean z3, Output output6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? Output.Disabled.Companion.create() : output, (i & 4) != 0 ? Output.Disabled.Companion.create() : output2, (i & 8) != 0 ? Output.Disabled.Companion.create() : output3, (i & 16) != 0 ? Output.Disabled.Companion.create() : output4, (i & 32) != 0 ? Output.Disabled.Companion.create() : output5, (i & 64) != 0 ? null : num, (i & 128) != 0 ? null : num2, (i & 256) != 0 ? false : z, (i & 512) != 0 ? OutputOrientation.DEVICE : outputOrientation, (i & 1024) != 0 ? null : cameraDeviceFormat, (i & 2048) != 0 ? false : z2, (i & 4096) != 0 ? Torch.OFF : torch, (i & 8192) != 0 ? VideoStabilizationMode.OFF : videoStabilizationMode, (i & 16384) != 0 ? null : d, (i & 32768) != 0 ? 1.0f : f, (i & 65536) != 0 ? false : z3, (i & 131072) != 0 ? Output.Disabled.Companion.create() : output6);
    }

    public final Output<Preview> getPreview() {
        return this.preview;
    }

    public final void setPreview(@NotNull Output<Preview> output) {
        Intrinsics.checkNotNullParameter(output, "<set-?>");
        this.preview = output;
    }

    public final Output<Photo> getPhoto() {
        return this.photo;
    }

    public final void setPhoto(@NotNull Output<Photo> output) {
        Intrinsics.checkNotNullParameter(output, "<set-?>");
        this.photo = output;
    }

    public final Output<Video> getVideo() {
        return this.video;
    }

    public final void setVideo(@NotNull Output<Video> output) {
        Intrinsics.checkNotNullParameter(output, "<set-?>");
        this.video = output;
    }

    public final Output<FrameProcessor> getFrameProcessor() {
        return this.frameProcessor;
    }

    public final void setFrameProcessor(@NotNull Output<FrameProcessor> output) {
        Intrinsics.checkNotNullParameter(output, "<set-?>");
        this.frameProcessor = output;
    }

    public final Output<CodeScanner> getCodeScanner() {
        return this.codeScanner;
    }

    public final void setCodeScanner(@NotNull Output<CodeScanner> output) {
        Intrinsics.checkNotNullParameter(output, "<set-?>");
        this.codeScanner = output;
    }

    public final Integer getMinFps() {
        return this.minFps;
    }

    public final void setMinFps(@Nullable Integer num) {
        this.minFps = num;
    }

    public final Integer getMaxFps() {
        return this.maxFps;
    }

    public final void setMaxFps(@Nullable Integer num) {
        this.maxFps = num;
    }

    public final boolean getEnableLocation() {
        return this.enableLocation;
    }

    public final void setEnableLocation(boolean z) {
        this.enableLocation = z;
    }

    public final OutputOrientation getOutputOrientation() {
        return this.outputOrientation;
    }

    public final void setOutputOrientation(@NotNull OutputOrientation outputOrientation) {
        Intrinsics.checkNotNullParameter(outputOrientation, "<set-?>");
        this.outputOrientation = outputOrientation;
    }

    public final CameraDeviceFormat getFormat() {
        return this.format;
    }

    public final void setFormat(@Nullable CameraDeviceFormat cameraDeviceFormat) {
        this.format = cameraDeviceFormat;
    }

    public final boolean getEnableLowLightBoost() {
        return this.enableLowLightBoost;
    }

    public final void setEnableLowLightBoost(boolean z) {
        this.enableLowLightBoost = z;
    }

    public final Torch getTorch() {
        return this.torch;
    }

    public final void setTorch(@NotNull Torch torch) {
        Intrinsics.checkNotNullParameter(torch, "<set-?>");
        this.torch = torch;
    }

    public final VideoStabilizationMode getVideoStabilizationMode() {
        return this.videoStabilizationMode;
    }

    public final void setVideoStabilizationMode(@NotNull VideoStabilizationMode videoStabilizationMode) {
        Intrinsics.checkNotNullParameter(videoStabilizationMode, "<set-?>");
        this.videoStabilizationMode = videoStabilizationMode;
    }

    public final Double getExposure() {
        return this.exposure;
    }

    public final void setExposure(@Nullable Double d) {
        this.exposure = d;
    }

    public final float getZoom() {
        return this.zoom;
    }

    public final void setZoom(float f) {
        this.zoom = f;
    }

    public final boolean isActive() {
        return this.isActive;
    }

    public final void setActive(boolean z) {
        this.isActive = z;
    }

    public final Output<Audio> getAudio() {
        return this.audio;
    }

    public final void setAudio(@NotNull Output<Audio> output) {
        Intrinsics.checkNotNullParameter(output, "<set-?>");
        this.audio = output;
    }

    public static final class CodeScanner {
        private final List<CodeType> codeTypes;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ CodeScanner copy$default(CodeScanner codeScanner, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = codeScanner.codeTypes;
            }
            return codeScanner.copy(list);
        }

        public final List<CodeType> component1() {
            return this.codeTypes;
        }

        public final CodeScanner copy(@NotNull List<? extends CodeType> codeTypes) {
            Intrinsics.checkNotNullParameter(codeTypes, "codeTypes");
            return new CodeScanner(codeTypes);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CodeScanner) && Intrinsics.areEqual(this.codeTypes, ((CodeScanner) obj).codeTypes);
        }

        public int hashCode() {
            return this.codeTypes.hashCode();
        }

        public String toString() {
            return "CodeScanner(codeTypes=" + this.codeTypes + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public CodeScanner(@NotNull List<? extends CodeType> codeTypes) {
            Intrinsics.checkNotNullParameter(codeTypes, "codeTypes");
            this.codeTypes = codeTypes;
        }

        public final List<CodeType> getCodeTypes() {
            return this.codeTypes;
        }
    }

    public static final class Photo {
        private final boolean enableHdr;
        private final boolean isMirrored;
        private final QualityBalance photoQualityBalance;

        public static /* synthetic */ Photo copy$default(Photo photo, boolean z, boolean z2, QualityBalance qualityBalance, int i, Object obj) {
            if ((i & 1) != 0) {
                z = photo.isMirrored;
            }
            if ((i & 2) != 0) {
                z2 = photo.enableHdr;
            }
            if ((i & 4) != 0) {
                qualityBalance = photo.photoQualityBalance;
            }
            return photo.copy(z, z2, qualityBalance);
        }

        public final boolean component1() {
            return this.isMirrored;
        }

        public final boolean component2() {
            return this.enableHdr;
        }

        public final QualityBalance component3() {
            return this.photoQualityBalance;
        }

        public final Photo copy(boolean z, boolean z2, @NotNull QualityBalance photoQualityBalance) {
            Intrinsics.checkNotNullParameter(photoQualityBalance, "photoQualityBalance");
            return new Photo(z, z2, photoQualityBalance);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Photo)) {
                return false;
            }
            Photo photo = (Photo) obj;
            return this.isMirrored == photo.isMirrored && this.enableHdr == photo.enableHdr && this.photoQualityBalance == photo.photoQualityBalance;
        }

        public int hashCode() {
            return (((Boolean.hashCode(this.isMirrored) * 31) + Boolean.hashCode(this.enableHdr)) * 31) + this.photoQualityBalance.hashCode();
        }

        public String toString() {
            return "Photo(isMirrored=" + this.isMirrored + ", enableHdr=" + this.enableHdr + ", photoQualityBalance=" + this.photoQualityBalance + ")";
        }

        public Photo(boolean z, boolean z2, @NotNull QualityBalance photoQualityBalance) {
            Intrinsics.checkNotNullParameter(photoQualityBalance, "photoQualityBalance");
            this.isMirrored = z;
            this.enableHdr = z2;
            this.photoQualityBalance = photoQualityBalance;
        }

        public final boolean getEnableHdr() {
            return this.enableHdr;
        }

        public final QualityBalance getPhotoQualityBalance() {
            return this.photoQualityBalance;
        }

        public final boolean isMirrored() {
            return this.isMirrored;
        }
    }

    public static final class Video {
        private final Double bitRateMultiplier;
        private final Double bitRateOverride;
        private final boolean enableHdr;
        private final boolean isMirrored;

        public static /* synthetic */ Video copy$default(Video video, boolean z, boolean z2, Double d, Double d2, int i, Object obj) {
            if ((i & 1) != 0) {
                z = video.isMirrored;
            }
            if ((i & 2) != 0) {
                z2 = video.enableHdr;
            }
            if ((i & 4) != 0) {
                d = video.bitRateOverride;
            }
            if ((i & 8) != 0) {
                d2 = video.bitRateMultiplier;
            }
            return video.copy(z, z2, d, d2);
        }

        public final boolean component1() {
            return this.isMirrored;
        }

        public final boolean component2() {
            return this.enableHdr;
        }

        public final Double component3() {
            return this.bitRateOverride;
        }

        public final Double component4() {
            return this.bitRateMultiplier;
        }

        public final Video copy(boolean z, boolean z2, @Nullable Double d, @Nullable Double d2) {
            return new Video(z, z2, d, d2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Video)) {
                return false;
            }
            Video video = (Video) obj;
            return this.isMirrored == video.isMirrored && this.enableHdr == video.enableHdr && Intrinsics.areEqual((Object) this.bitRateOverride, (Object) video.bitRateOverride) && Intrinsics.areEqual((Object) this.bitRateMultiplier, (Object) video.bitRateMultiplier);
        }

        public int hashCode() {
            int iHashCode = Boolean.hashCode(this.isMirrored);
            int iHashCode2 = Boolean.hashCode(this.enableHdr);
            Double d = this.bitRateOverride;
            int iHashCode3 = d == null ? 0 : d.hashCode();
            Double d2 = this.bitRateMultiplier;
            return (((((iHashCode * 31) + iHashCode2) * 31) + iHashCode3) * 31) + (d2 != null ? d2.hashCode() : 0);
        }

        public String toString() {
            return "Video(isMirrored=" + this.isMirrored + ", enableHdr=" + this.enableHdr + ", bitRateOverride=" + this.bitRateOverride + ", bitRateMultiplier=" + this.bitRateMultiplier + ")";
        }

        public Video(boolean z, boolean z2, @Nullable Double d, @Nullable Double d2) {
            this.isMirrored = z;
            this.enableHdr = z2;
            this.bitRateOverride = d;
            this.bitRateMultiplier = d2;
        }

        public final Double getBitRateMultiplier() {
            return this.bitRateMultiplier;
        }

        public final Double getBitRateOverride() {
            return this.bitRateOverride;
        }

        public final boolean getEnableHdr() {
            return this.enableHdr;
        }

        public final boolean isMirrored() {
            return this.isMirrored;
        }
    }

    public static final class FrameProcessor {
        private final boolean isMirrored;
        private final PixelFormat pixelFormat;

        public static /* synthetic */ FrameProcessor copy$default(FrameProcessor frameProcessor, boolean z, PixelFormat pixelFormat, int i, Object obj) {
            if ((i & 1) != 0) {
                z = frameProcessor.isMirrored;
            }
            if ((i & 2) != 0) {
                pixelFormat = frameProcessor.pixelFormat;
            }
            return frameProcessor.copy(z, pixelFormat);
        }

        public final boolean component1() {
            return this.isMirrored;
        }

        public final PixelFormat component2() {
            return this.pixelFormat;
        }

        public final FrameProcessor copy(boolean z, @NotNull PixelFormat pixelFormat) {
            Intrinsics.checkNotNullParameter(pixelFormat, "pixelFormat");
            return new FrameProcessor(z, pixelFormat);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FrameProcessor)) {
                return false;
            }
            FrameProcessor frameProcessor = (FrameProcessor) obj;
            return this.isMirrored == frameProcessor.isMirrored && this.pixelFormat == frameProcessor.pixelFormat;
        }

        public int hashCode() {
            return (Boolean.hashCode(this.isMirrored) * 31) + this.pixelFormat.hashCode();
        }

        public String toString() {
            return "FrameProcessor(isMirrored=" + this.isMirrored + ", pixelFormat=" + this.pixelFormat + ")";
        }

        public FrameProcessor(boolean z, @NotNull PixelFormat pixelFormat) {
            Intrinsics.checkNotNullParameter(pixelFormat, "pixelFormat");
            this.isMirrored = z;
            this.pixelFormat = pixelFormat;
        }

        public final PixelFormat getPixelFormat() {
            return this.pixelFormat;
        }

        public final boolean isMirrored() {
            return this.isMirrored;
        }
    }

    public static final class Audio {
        private final Unit nothing;

        public static /* synthetic */ Audio copy$default(Audio audio, Unit unit, int i, Object obj) {
            if ((i & 1) != 0) {
                unit = audio.nothing;
            }
            return audio.copy(unit);
        }

        public final void component1() {
        }

        public final Audio copy(@NotNull Unit nothing) {
            Intrinsics.checkNotNullParameter(nothing, "nothing");
            return new Audio(nothing);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Audio) && Intrinsics.areEqual(this.nothing, ((Audio) obj).nothing);
        }

        public int hashCode() {
            return this.nothing.hashCode();
        }

        public String toString() {
            return "Audio(nothing=" + this.nothing + ")";
        }

        public Audio(@NotNull Unit nothing) {
            Intrinsics.checkNotNullParameter(nothing, "nothing");
            this.nothing = nothing;
        }

        public final Unit getNothing() {
            return this.nothing;
        }
    }

    public static final class Preview {
        private final androidx.camera.core.Preview.SurfaceProvider surfaceProvider;

        public static /* synthetic */ Preview copy$default(Preview preview, androidx.camera.core.Preview.SurfaceProvider surfaceProvider, int i, Object obj) {
            if ((i & 1) != 0) {
                surfaceProvider = preview.surfaceProvider;
            }
            return preview.copy(surfaceProvider);
        }

        public final androidx.camera.core.Preview.SurfaceProvider component1() {
            return this.surfaceProvider;
        }

        public final Preview copy(@NotNull androidx.camera.core.Preview.SurfaceProvider surfaceProvider) {
            Intrinsics.checkNotNullParameter(surfaceProvider, "surfaceProvider");
            return new Preview(surfaceProvider);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Preview) && Intrinsics.areEqual(this.surfaceProvider, ((Preview) obj).surfaceProvider);
        }

        public int hashCode() {
            return this.surfaceProvider.hashCode();
        }

        public String toString() {
            return "Preview(surfaceProvider=" + this.surfaceProvider + ")";
        }

        public Preview(@NotNull androidx.camera.core.Preview.SurfaceProvider surfaceProvider) {
            Intrinsics.checkNotNullParameter(surfaceProvider, "surfaceProvider");
            this.surfaceProvider = surfaceProvider;
        }

        public final androidx.camera.core.Preview.SurfaceProvider getSurfaceProvider() {
            return this.surfaceProvider;
        }
    }

    public final Range<Integer> getTargetFpsRange() {
        Integer num;
        Integer num2 = this.minFps;
        if (num2 == null || (num = this.maxFps) == null) {
            return null;
        }
        return new Range<>(num2, num);
    }

    public final Float getTargetPreviewAspectRatio() {
        CameraDeviceFormat cameraDeviceFormat = this.format;
        if (cameraDeviceFormat == null) {
            return null;
        }
        Output<Video> output = this.video;
        Output.Enabled enabled = output instanceof Output.Enabled ? (Output.Enabled) output : null;
        Output<Photo> output2 = this.photo;
        Output.Enabled enabled2 = output2 instanceof Output.Enabled ? (Output.Enabled) output2 : null;
        if (enabled != null) {
            return Float.valueOf(cameraDeviceFormat.getVideoWidth() / cameraDeviceFormat.getVideoHeight());
        }
        if (enabled2 != null) {
            return Float.valueOf(cameraDeviceFormat.getPhotoWidth() / cameraDeviceFormat.getPhotoHeight());
        }
        return null;
    }

    public static abstract class Output<T> {
        public /* synthetic */ Output(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Output() {
        }

        public static final class Disabled<T> extends Output<T> {
            public static final Companion Companion = new Companion(null);

            public /* synthetic */ Disabled(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Disabled() {
                super(null);
            }

            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final <T> Disabled<T> create() {
                    return new Disabled<>(null);
                }
            }

            public boolean equals(@Nullable Object obj) {
                return obj instanceof Disabled;
            }
        }

        public final boolean isEnabled() {
            return this instanceof Enabled;
        }

        public static final class Enabled<T> extends Output<T> {
            public static final Companion Companion = new Companion(null);
            private final T config;

            public /* synthetic */ Enabled(Object obj, DefaultConstructorMarker defaultConstructorMarker) {
                this(obj);
            }

            private Enabled(T t) {
                super(null);
                this.config = t;
            }

            public final T getConfig() {
                return this.config;
            }

            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final <T> Enabled<T> create(T t) {
                    return new Enabled<>(t, null);
                }
            }

            public boolean equals(@Nullable Object obj) {
                return (obj instanceof Enabled) && Intrinsics.areEqual(this.config, ((Enabled) obj).config);
            }
        }
    }

    public static final class Difference {
        private final boolean deviceChanged;
        private final boolean isActiveChanged;
        private final boolean locationChanged;
        private final boolean orientationChanged;
        private final boolean outputsChanged;
        private final boolean sidePropsChanged;

        public static /* synthetic */ Difference copy$default(Difference difference, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i, Object obj) {
            if ((i & 1) != 0) {
                z = difference.deviceChanged;
            }
            if ((i & 2) != 0) {
                z2 = difference.outputsChanged;
            }
            boolean z7 = z2;
            if ((i & 4) != 0) {
                z3 = difference.sidePropsChanged;
            }
            boolean z8 = z3;
            if ((i & 8) != 0) {
                z4 = difference.isActiveChanged;
            }
            boolean z9 = z4;
            if ((i & 16) != 0) {
                z5 = difference.orientationChanged;
            }
            boolean z10 = z5;
            if ((i & 32) != 0) {
                z6 = difference.locationChanged;
            }
            return difference.copy(z, z7, z8, z9, z10, z6);
        }

        public final boolean component1() {
            return this.deviceChanged;
        }

        public final boolean component2() {
            return this.outputsChanged;
        }

        public final boolean component3() {
            return this.sidePropsChanged;
        }

        public final boolean component4() {
            return this.isActiveChanged;
        }

        public final boolean component5() {
            return this.orientationChanged;
        }

        public final boolean component6() {
            return this.locationChanged;
        }

        public final Difference copy(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
            return new Difference(z, z2, z3, z4, z5, z6);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Difference)) {
                return false;
            }
            Difference difference = (Difference) obj;
            return this.deviceChanged == difference.deviceChanged && this.outputsChanged == difference.outputsChanged && this.sidePropsChanged == difference.sidePropsChanged && this.isActiveChanged == difference.isActiveChanged && this.orientationChanged == difference.orientationChanged && this.locationChanged == difference.locationChanged;
        }

        public int hashCode() {
            return (((((((((Boolean.hashCode(this.deviceChanged) * 31) + Boolean.hashCode(this.outputsChanged)) * 31) + Boolean.hashCode(this.sidePropsChanged)) * 31) + Boolean.hashCode(this.isActiveChanged)) * 31) + Boolean.hashCode(this.orientationChanged)) * 31) + Boolean.hashCode(this.locationChanged);
        }

        public String toString() {
            return "Difference(deviceChanged=" + this.deviceChanged + ", outputsChanged=" + this.outputsChanged + ", sidePropsChanged=" + this.sidePropsChanged + ", isActiveChanged=" + this.isActiveChanged + ", orientationChanged=" + this.orientationChanged + ", locationChanged=" + this.locationChanged + ")";
        }

        public Difference(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
            this.deviceChanged = z;
            this.outputsChanged = z2;
            this.sidePropsChanged = z3;
            this.isActiveChanged = z4;
            this.orientationChanged = z5;
            this.locationChanged = z6;
        }

        public final boolean getDeviceChanged() {
            return this.deviceChanged;
        }

        public final boolean getOutputsChanged() {
            return this.outputsChanged;
        }

        public final boolean getSidePropsChanged() {
            return this.sidePropsChanged;
        }

        public final boolean isActiveChanged() {
            return this.isActiveChanged;
        }

        public final boolean getOrientationChanged() {
            return this.orientationChanged;
        }

        public final boolean getLocationChanged() {
            return this.locationChanged;
        }

        public final boolean getHasChanges() {
            return this.deviceChanged || this.outputsChanged || this.sidePropsChanged || this.isActiveChanged || this.orientationChanged || this.locationChanged;
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CameraConfiguration copyOf(@Nullable CameraConfiguration cameraConfiguration) {
            CameraConfiguration cameraConfigurationCopy$default;
            return (cameraConfiguration == null || (cameraConfigurationCopy$default = CameraConfiguration.copy$default(cameraConfiguration, null, null, null, null, null, null, null, null, false, null, null, false, null, null, null, 0.0f, false, null, 262143, null)) == null) ? new CameraConfiguration(null, null, null, null, null, null, null, null, false, null, null, false, null, null, null, 0.0f, false, null, 262143, null) : cameraConfigurationCopy$default;
        }

        /* JADX WARN: Code duplicated, block: B:37:0x00ab  */
        /* JADX WARN: Code duplicated, block: B:50:0x00d9  */
        public final Difference difference(@Nullable CameraConfiguration cameraConfiguration, @NotNull CameraConfiguration right) {
            boolean z;
            boolean z2;
            Intrinsics.checkNotNullParameter(right, "right");
            boolean z3 = false;
            boolean z4 = (Intrinsics.areEqual(cameraConfiguration != null ? cameraConfiguration.getPhoto() : null, right.getPhoto()) && Intrinsics.areEqual(cameraConfiguration.getVideo(), right.getVideo()) && cameraConfiguration.getEnableLowLightBoost() == right.getEnableLowLightBoost() && cameraConfiguration.getVideoStabilizationMode() == right.getVideoStabilizationMode() && Intrinsics.areEqual(cameraConfiguration.getFrameProcessor(), right.getFrameProcessor()) && Intrinsics.areEqual(cameraConfiguration.getCodeScanner(), right.getCodeScanner()) && Intrinsics.areEqual(cameraConfiguration.getPreview(), right.getPreview()) && Intrinsics.areEqual(cameraConfiguration.getFormat(), right.getFormat()) && Intrinsics.areEqual(cameraConfiguration.getMinFps(), right.getMinFps()) && Intrinsics.areEqual(cameraConfiguration.getMaxFps(), right.getMaxFps())) ? false : true;
            if (z4) {
                z = true;
            } else {
                if (Intrinsics.areEqual(cameraConfiguration != null ? cameraConfiguration.getCameraId() : null, right.getCameraId())) {
                    z = false;
                } else {
                    z = true;
                }
            }
            if (z) {
                z2 = true;
            } else {
                if ((cameraConfiguration != null ? cameraConfiguration.getTorch() : null) == right.getTorch() && cameraConfiguration.getZoom() == right.getZoom() && Intrinsics.areEqual(cameraConfiguration.getExposure(), right.getExposure())) {
                    z2 = false;
                } else {
                    z2 = true;
                }
            }
            boolean z5 = cameraConfiguration != null && cameraConfiguration.isActive() == right.isActive();
            boolean z6 = (cameraConfiguration != null ? cameraConfiguration.getOutputOrientation() : null) != right.getOutputOrientation();
            if (cameraConfiguration != null && cameraConfiguration.getEnableLocation() == right.getEnableLocation()) {
                z3 = true;
            }
            return new Difference(z, z4, z2, !z5, z6, !z3);
        }
    }
}
