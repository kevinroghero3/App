package com.mrousavy.camera.core.types;

import android.util.Size;
import androidx.camera.video.FallbackStrategy;
import androidx.camera.video.Quality;
import androidx.camera.video.QualitySelector;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.mrousavy.camera.core.InvalidTypeScriptUnionError;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class CameraDeviceFormat {
    public static final Companion Companion = new Companion(null);
    private final AutoFocusSystem autoFocusSystem;
    private final double fieldOfView;
    private final double maxFps;
    private final double maxISO;
    private final double minFps;
    private final double minISO;
    private final int photoHeight;
    private final int photoWidth;
    private final Map<Quality, Integer> qualitySizes;
    private final boolean supportsDepthCapture;
    private final boolean supportsPhotoHdr;
    private final boolean supportsVideoHdr;
    private final int videoHeight;
    private final List<VideoStabilizationMode> videoStabilizationModes;
    private final int videoWidth;

    public final int component1() {
        return this.videoWidth;
    }

    public final List<VideoStabilizationMode> component10() {
        return this.videoStabilizationModes;
    }

    public final AutoFocusSystem component11() {
        return this.autoFocusSystem;
    }

    public final boolean component12() {
        return this.supportsVideoHdr;
    }

    public final boolean component13() {
        return this.supportsPhotoHdr;
    }

    public final boolean component14() {
        return this.supportsDepthCapture;
    }

    public final int component2() {
        return this.videoHeight;
    }

    public final int component3() {
        return this.photoWidth;
    }

    public final int component4() {
        return this.photoHeight;
    }

    public final double component5() {
        return this.minFps;
    }

    public final double component6() {
        return this.maxFps;
    }

    public final double component7() {
        return this.minISO;
    }

    public final double component8() {
        return this.maxISO;
    }

    public final double component9() {
        return this.fieldOfView;
    }

    public final CameraDeviceFormat copy(int i, int i2, int i3, int i4, double d, double d2, double d3, double d4, double d5, @NotNull List<? extends VideoStabilizationMode> videoStabilizationModes, @NotNull AutoFocusSystem autoFocusSystem, boolean z, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(videoStabilizationModes, "videoStabilizationModes");
        Intrinsics.checkNotNullParameter(autoFocusSystem, "autoFocusSystem");
        return new CameraDeviceFormat(i, i2, i3, i4, d, d2, d3, d4, d5, videoStabilizationModes, autoFocusSystem, z, z2, z3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CameraDeviceFormat)) {
            return false;
        }
        CameraDeviceFormat cameraDeviceFormat = (CameraDeviceFormat) obj;
        return this.videoWidth == cameraDeviceFormat.videoWidth && this.videoHeight == cameraDeviceFormat.videoHeight && this.photoWidth == cameraDeviceFormat.photoWidth && this.photoHeight == cameraDeviceFormat.photoHeight && Double.compare(this.minFps, cameraDeviceFormat.minFps) == 0 && Double.compare(this.maxFps, cameraDeviceFormat.maxFps) == 0 && Double.compare(this.minISO, cameraDeviceFormat.minISO) == 0 && Double.compare(this.maxISO, cameraDeviceFormat.maxISO) == 0 && Double.compare(this.fieldOfView, cameraDeviceFormat.fieldOfView) == 0 && Intrinsics.areEqual(this.videoStabilizationModes, cameraDeviceFormat.videoStabilizationModes) && this.autoFocusSystem == cameraDeviceFormat.autoFocusSystem && this.supportsVideoHdr == cameraDeviceFormat.supportsVideoHdr && this.supportsPhotoHdr == cameraDeviceFormat.supportsPhotoHdr && this.supportsDepthCapture == cameraDeviceFormat.supportsDepthCapture;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((Integer.hashCode(this.videoWidth) * 31) + Integer.hashCode(this.videoHeight)) * 31) + Integer.hashCode(this.photoWidth)) * 31) + Integer.hashCode(this.photoHeight)) * 31) + Double.hashCode(this.minFps)) * 31) + Double.hashCode(this.maxFps)) * 31) + Double.hashCode(this.minISO)) * 31) + Double.hashCode(this.maxISO)) * 31) + Double.hashCode(this.fieldOfView)) * 31) + this.videoStabilizationModes.hashCode()) * 31) + this.autoFocusSystem.hashCode()) * 31) + Boolean.hashCode(this.supportsVideoHdr)) * 31) + Boolean.hashCode(this.supportsPhotoHdr)) * 31) + Boolean.hashCode(this.supportsDepthCapture);
    }

    public String toString() {
        return "CameraDeviceFormat(videoWidth=" + this.videoWidth + ", videoHeight=" + this.videoHeight + ", photoWidth=" + this.photoWidth + ", photoHeight=" + this.photoHeight + ", minFps=" + this.minFps + ", maxFps=" + this.maxFps + ", minISO=" + this.minISO + ", maxISO=" + this.maxISO + ", fieldOfView=" + this.fieldOfView + ", videoStabilizationModes=" + this.videoStabilizationModes + ", autoFocusSystem=" + this.autoFocusSystem + ", supportsVideoHdr=" + this.supportsVideoHdr + ", supportsPhotoHdr=" + this.supportsPhotoHdr + ", supportsDepthCapture=" + this.supportsDepthCapture + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CameraDeviceFormat(int i, int i2, int i3, int i4, double d, double d2, double d3, double d4, double d5, @NotNull List<? extends VideoStabilizationMode> videoStabilizationModes, @NotNull AutoFocusSystem autoFocusSystem, boolean z, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(videoStabilizationModes, "videoStabilizationModes");
        Intrinsics.checkNotNullParameter(autoFocusSystem, "autoFocusSystem");
        this.videoWidth = i;
        this.videoHeight = i2;
        this.photoWidth = i3;
        this.photoHeight = i4;
        this.minFps = d;
        this.maxFps = d2;
        this.minISO = d3;
        this.maxISO = d4;
        this.fieldOfView = d5;
        this.videoStabilizationModes = videoStabilizationModes;
        this.autoFocusSystem = autoFocusSystem;
        this.supportsVideoHdr = z;
        this.supportsPhotoHdr = z2;
        this.supportsDepthCapture = z3;
        this.qualitySizes = MapsKt__MapsKt.mapOf(TuplesKt.to(Quality.SD, 345600), TuplesKt.to(Quality.HD, 921600), TuplesKt.to(Quality.FHD, 2073600), TuplesKt.to(Quality.UHD, 8294400));
    }

    public final int getVideoWidth() {
        return this.videoWidth;
    }

    public final int getVideoHeight() {
        return this.videoHeight;
    }

    public final int getPhotoWidth() {
        return this.photoWidth;
    }

    public final int getPhotoHeight() {
        return this.photoHeight;
    }

    public final double getMinFps() {
        return this.minFps;
    }

    public final double getMaxFps() {
        return this.maxFps;
    }

    public final double getMinISO() {
        return this.minISO;
    }

    public final double getMaxISO() {
        return this.maxISO;
    }

    public final double getFieldOfView() {
        return this.fieldOfView;
    }

    public final List<VideoStabilizationMode> getVideoStabilizationModes() {
        return this.videoStabilizationModes;
    }

    public final AutoFocusSystem getAutoFocusSystem() {
        return this.autoFocusSystem;
    }

    public final boolean getSupportsVideoHdr() {
        return this.supportsVideoHdr;
    }

    public final boolean getSupportsPhotoHdr() {
        return this.supportsPhotoHdr;
    }

    public final boolean getSupportsDepthCapture() {
        return this.supportsDepthCapture;
    }

    public final Size getPhotoSize() {
        return new Size(this.photoWidth, this.photoHeight);
    }

    public final Size getVideoSize() {
        return new Size(this.videoWidth, this.videoHeight);
    }

    private final QualitySelector getQualitySelector(Size size) {
        int width = size.getWidth() * size.getHeight();
        Iterator<T> it2 = this.qualitySizes.entrySet().iterator();
        if (!it2.hasNext()) {
            throw new NoSuchElementException();
        }
        Object next = it2.next();
        if (it2.hasNext()) {
            int iAbs = Math.abs(width - ((Number) ((Map.Entry) next).getValue()).intValue());
            do {
                Object next2 = it2.next();
                int iAbs2 = Math.abs(width - ((Number) ((Map.Entry) next2).getValue()).intValue());
                if (iAbs > iAbs2) {
                    next = next2;
                    iAbs = iAbs2;
                }
            } while (it2.hasNext());
        }
        Quality quality = (Quality) ((Map.Entry) next).getKey();
        QualitySelector qualitySelectorFrom = QualitySelector.from(quality, FallbackStrategy.higherQualityOrLowerThan(quality));
        Intrinsics.checkNotNullExpressionValue(qualitySelectorFrom, "from(...)");
        return qualitySelectorFrom;
    }

    public final QualitySelector getVideoQualitySelector() {
        return getQualitySelector(getVideoSize());
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CameraDeviceFormat fromJSValue(@NotNull ReadableMap value) throws InvalidTypeScriptUnionError {
            Intrinsics.checkNotNullParameter(value, "value");
            ReadableArray array = value.getArray("videoStabilizationModes");
            if (array == null) {
                throw new InvalidTypeScriptUnionError("format", value.toString());
            }
            ArrayList<Object> arrayList = array.toArrayList();
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
            for (Object obj : arrayList) {
                VideoStabilizationMode.Companion companion = VideoStabilizationMode.Companion;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                arrayList2.add(companion.fromUnionValue((String) obj));
            }
            return new CameraDeviceFormat(value.getInt("videoWidth"), value.getInt("videoHeight"), value.getInt("photoWidth"), value.getInt("photoHeight"), value.getDouble("minFps"), value.getDouble("maxFps"), value.getDouble("minISO"), value.getDouble("maxISO"), value.getDouble("fieldOfView"), arrayList2, AutoFocusSystem.Companion.fromUnionValue(value.getString("autoFocusSystem")), value.getBoolean("supportsVideoHdr"), value.getBoolean("supportsPhotoHdr"), value.getBoolean("supportsDepthCapture"));
        }
    }
}
