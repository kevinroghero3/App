package com.mrousavy.camera.core;

import android.hardware.camera2.CameraCharacteristics;
import android.util.Range;
import android.util.Size;
import android.util.SizeF;
import androidx.camera.camera2.internal.Camera2CameraInfoImpl;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.MeteringPoint;
import androidx.camera.core.PreviewCapabilities;
import androidx.camera.core.SurfaceOrientedMeteringPointFactory;
import androidx.camera.core.ZoomState;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.capability.PreviewCapabilitiesImpl;
import androidx.camera.extensions.ExtensionsManager;
import androidx.camera.video.Quality;
import androidx.camera.video.Recorder;
import androidx.camera.video.VideoCapabilities;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ViewProps;
import com.mrousavy.camera.core.extensions.CameraInfo_idKt;
import com.mrousavy.camera.core.types.AutoFocusSystem;
import com.mrousavy.camera.core.types.DeviceType;
import com.mrousavy.camera.core.types.HardwareLevel;
import com.mrousavy.camera.core.types.Orientation;
import com.mrousavy.camera.core.types.Position;
import com.mrousavy.camera.core.types.VideoStabilizationMode;
import com.mrousavy.camera.core.utils.CamcorderProfileUtils;
import com.mrousavy.camera.react.extensions.List_toJSValueKt;
import io.sentry.android.core.SentryLogcatAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class CameraDeviceDetails {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "CameraDeviceDetails";
    private final AutoFocusSystem autoFocusSystem;
    private final Camera2CameraInfoImpl camera2Details;
    private final Integer cameraHardwareLevel;
    private final String cameraId;
    private final CameraInfo cameraInfo;
    private final CameraInfoInternal cameraInfoInternal;
    private final HardwareLevel hardwareLevel;
    private final boolean hasFlash;
    private final boolean isMultiCam;
    private final Range<Integer> isoRange;
    private final Integer maxExposure;
    private final double maxFieldOfView;
    private final float maxZoom;
    private final Integer minExposure;
    private final double minFocusDistance;
    private final float minZoom;
    private final String name;
    private final Set<String> physicalDeviceIds;
    private final Position position;
    private final PreviewCapabilities previewCapabilities;
    private final Orientation sensorOrientation;
    private final int sensorRotationDegrees;
    private final boolean supports10BitHdr;
    private final boolean supportsDepthCapture;
    private final boolean supportsFocus;
    private final boolean supportsHdrExtension;
    private final boolean supportsLowLightBoostExtension;
    private final boolean supportsRawCapture;
    private final VideoCapabilities videoCapabilities;

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public CameraDeviceDetails(@NotNull CameraInfo cameraInfo, @NotNull ExtensionsManager extensionsManager) throws NoCameraDeviceError {
        CameraCharacteristicsCompat cameraCharacteristicsCompat;
        Map<String, CameraCharacteristics> cameraCharacteristicsMap;
        Intrinsics.checkNotNullParameter(cameraInfo, "cameraInfo");
        Intrinsics.checkNotNullParameter(extensionsManager, "extensionsManager");
        this.cameraInfo = cameraInfo;
        String id = CameraInfo_idKt.getId(cameraInfo);
        if (id == null) {
            throw new NoCameraDeviceError();
        }
        this.cameraId = id;
        Position positionFromLensFacing = Position.Companion.fromLensFacing(cameraInfo.getLensFacing());
        this.position = positionFromLensFacing;
        this.name = id + " (" + positionFromLensFacing + ") " + cameraInfo.getImplementationType();
        this.hasFlash = cameraInfo.hasFlashUnit();
        ZoomState value = cameraInfo.getZoomState().getValue();
        this.minZoom = value != null ? value.getMinZoomRatio() : 0.0f;
        ZoomState value2 = cameraInfo.getZoomState().getValue();
        this.maxZoom = value2 != null ? value2.getMaxZoomRatio() : 1.0f;
        this.minExposure = (Integer) cameraInfo.getExposureState().getExposureCompensationRange().getLower();
        this.maxExposure = (Integer) cameraInfo.getExposureState().getExposureCompensationRange().getUpper();
        boolean supportsFocus = getSupportsFocus();
        this.supportsFocus = supportsFocus;
        this.autoFocusSystem = supportsFocus ? AutoFocusSystem.CONTRAST_DETECTION : AutoFocusSystem.NONE;
        PreviewCapabilities previewCapabilitiesFrom = PreviewCapabilitiesImpl.from(cameraInfo);
        Intrinsics.checkNotNullExpressionValue(previewCapabilitiesFrom, "from(...)");
        this.previewCapabilities = previewCapabilitiesFrom;
        VideoCapabilities videoCapabilities = Recorder.getVideoCapabilities(cameraInfo, 0);
        Intrinsics.checkNotNullExpressionValue(videoCapabilities, "getVideoCapabilities(...)");
        this.videoCapabilities = videoCapabilities;
        this.supports10BitHdr = getSupports10BitHDR();
        int sensorRotationDegrees = cameraInfo.getSensorRotationDegrees();
        this.sensorRotationDegrees = sensorRotationDegrees;
        this.sensorOrientation = Orientation.Companion.fromRotationDegrees(sensorRotationDegrees);
        Intrinsics.checkNotNull(cameraInfo, "null cannot be cast to non-null type androidx.camera.core.impl.CameraInfoInternal");
        this.cameraInfoInternal = (CameraInfoInternal) cameraInfo;
        Integer num = null;
        Camera2CameraInfoImpl camera2CameraInfoImpl = cameraInfo instanceof Camera2CameraInfoImpl ? (Camera2CameraInfoImpl) cameraInfo : null;
        this.camera2Details = camera2CameraInfoImpl;
        Set<String> setEmptySet = (camera2CameraInfoImpl == null || (cameraCharacteristicsMap = camera2CameraInfoImpl.getCameraCharacteristicsMap()) == null || (setEmptySet = cameraCharacteristicsMap.keySet()) == null) ? SetsKt__SetsKt.emptySet() : setEmptySet;
        this.physicalDeviceIds = setEmptySet;
        this.isMultiCam = setEmptySet.size() > 1;
        if (camera2CameraInfoImpl != null && (cameraCharacteristicsCompat = camera2CameraInfoImpl.getCameraCharacteristicsCompat()) != null) {
            num = (Integer) cameraCharacteristicsCompat.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        }
        this.cameraHardwareLevel = num;
        this.hardwareLevel = HardwareLevel.Companion.fromCameraHardwareLevel(num != null ? num.intValue() : 2);
        this.minFocusDistance = getMinFocusDistanceCm();
        this.isoRange = getIsoRange();
        this.maxFieldOfView = getMaxFieldOfView();
        this.supportsHdrExtension = extensionsManager.isExtensionAvailable(cameraInfo.getCameraSelector(), 2);
        this.supportsLowLightBoostExtension = extensionsManager.isExtensionAvailable(cameraInfo.getCameraSelector(), 3);
    }

    public final ReadableMap toMap() {
        List<DeviceType> deviceTypes = getDeviceTypes();
        ReadableArray formats = getFormats();
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("id", this.cameraId);
        writableMapCreateMap.putArray("physicalDevices", List_toJSValueKt.toJSValue(deviceTypes));
        writableMapCreateMap.putString(ViewProps.POSITION, this.position.getUnionValue());
        writableMapCreateMap.putString("name", this.name);
        writableMapCreateMap.putBoolean("hasFlash", this.hasFlash);
        writableMapCreateMap.putBoolean("hasTorch", this.hasFlash);
        writableMapCreateMap.putDouble("minFocusDistance", this.minFocusDistance);
        writableMapCreateMap.putBoolean("isMultiCam", this.isMultiCam);
        writableMapCreateMap.putBoolean("supportsRawCapture", this.supportsRawCapture);
        writableMapCreateMap.putBoolean("supportsLowLightBoost", this.supportsLowLightBoostExtension);
        writableMapCreateMap.putBoolean("supportsFocus", this.supportsFocus);
        writableMapCreateMap.putDouble("minZoom", this.minZoom);
        writableMapCreateMap.putDouble("maxZoom", this.maxZoom);
        writableMapCreateMap.putDouble("neutralZoom", 1.0d);
        Integer minExposure = this.minExposure;
        Intrinsics.checkNotNullExpressionValue(minExposure, "minExposure");
        writableMapCreateMap.putInt("minExposure", minExposure.intValue());
        Integer maxExposure = this.maxExposure;
        Intrinsics.checkNotNullExpressionValue(maxExposure, "maxExposure");
        writableMapCreateMap.putInt("maxExposure", maxExposure.intValue());
        writableMapCreateMap.putString("hardwareLevel", this.hardwareLevel.getUnionValue());
        writableMapCreateMap.putString("sensorOrientation", this.sensorOrientation.getUnionValue());
        writableMapCreateMap.putArray("formats", formats);
        Intrinsics.checkNotNull(writableMapCreateMap);
        return writableMapCreateMap;
    }

    private final ReadableArray getFormats() {
        Iterator it2;
        List list;
        CameraDeviceDetails cameraDeviceDetails = this;
        WritableArray writableArrayCreateArray = Arguments.createArray();
        Set<DynamicRange> supportedDynamicRanges = cameraDeviceDetails.videoCapabilities.getSupportedDynamicRanges();
        Intrinsics.checkNotNullExpressionValue(supportedDynamicRanges, "getSupportedDynamicRanges(...)");
        Iterator it3 = supportedDynamicRanges.iterator();
        while (it3.hasNext()) {
            DynamicRange dynamicRange = (DynamicRange) it3.next();
            try {
                List<Quality> supportedQualities = cameraDeviceDetails.videoCapabilities.getSupportedQualities(dynamicRange);
                Intrinsics.checkNotNullExpressionValue(supportedQualities, "getSupportedQualities(...)");
                List<Quality> list2 = supportedQualities;
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10));
                for (Quality quality : list2) {
                    Intrinsics.checkNotNull(quality, "null cannot be cast to non-null type androidx.camera.video.Quality.ConstantQuality");
                    arrayList.add((Quality.ConstantQuality) quality);
                }
                ArrayList<Size> arrayList2 = new ArrayList();
                Iterator it4 = arrayList.iterator();
                while (it4.hasNext()) {
                    List<Size> typicalSizes = ((Quality.ConstantQuality) it4.next()).getTypicalSizes();
                    Intrinsics.checkNotNullExpressionValue(typicalSizes, "getTypicalSizes(...)");
                    CollectionsKt__MutableCollectionsKt.addAll(arrayList2, typicalSizes);
                }
                List<Size> supportedHighResolutions = cameraDeviceDetails.cameraInfoInternal.getSupportedHighResolutions(256);
                Intrinsics.checkNotNullExpressionValue(supportedHighResolutions, "getSupportedHighResolutions(...)");
                List<Size> supportedResolutions = cameraDeviceDetails.cameraInfoInternal.getSupportedResolutions(256);
                Intrinsics.checkNotNullExpressionValue(supportedResolutions, "getSupportedResolutions(...)");
                List<Size> list3 = CollectionsKt___CollectionsKt.toList(CollectionsKt___CollectionsKt.union(supportedHighResolutions, supportedResolutions));
                Set<Range<Integer>> supportedFrameRateRanges = cameraDeviceDetails.cameraInfo.getSupportedFrameRateRanges();
                Intrinsics.checkNotNullExpressionValue(supportedFrameRateRanges, "getSupportedFrameRateRanges(...)");
                Iterator<T> it5 = supportedFrameRateRanges.iterator();
                if (!it5.hasNext()) {
                    throw new NoSuchElementException();
                }
                Integer num = (Integer) ((Range) it5.next()).getLower();
                while (it5.hasNext()) {
                    Integer num2 = (Integer) ((Range) it5.next()).getLower();
                    if (num.compareTo(num2) > 0) {
                        num = num2;
                    }
                }
                Iterator<T> it6 = supportedFrameRateRanges.iterator();
                if (!it6.hasNext()) {
                    throw new NoSuchElementException();
                }
                Integer num3 = (Integer) ((Range) it6.next()).getUpper();
                while (it6.hasNext()) {
                    Integer num4 = (Integer) ((Range) it6.next()).getUpper();
                    if (num3.compareTo(num4) < 0) {
                        num3 = num4;
                    }
                }
                for (Size size : arrayList2) {
                    try {
                        CamcorderProfileUtils.Companion companion = CamcorderProfileUtils.Companion;
                        String str = cameraDeviceDetails.cameraId;
                        Intrinsics.checkNotNull(size);
                        Integer maximumFps = companion.getMaximumFps(str, size);
                        if (maximumFps == null) {
                            maximumFps = num3;
                        }
                        Intrinsics.checkNotNull(num);
                        int iIntValue = num.intValue();
                        Intrinsics.checkNotNull(maximumFps);
                        Range<Integer> range = new Range<>(Integer.valueOf(Math.min(iIntValue, maximumFps.intValue())), maximumFps);
                        for (Size size2 : list3) {
                            try {
                                Intrinsics.checkNotNull(size2);
                                writableArrayCreateArray.pushMap(cameraDeviceDetails.buildFormatMap(size2, size, range));
                                it2 = it3;
                                list = list3;
                            } catch (Throwable th) {
                                int width = size2.getWidth();
                                int height = size2.getHeight();
                                it2 = it3;
                                try {
                                    StringBuilder sb = new StringBuilder();
                                    list = list3;
                                    try {
                                        sb.append("Photo size ");
                                        sb.append(width);
                                        sb.append("x");
                                        sb.append(height);
                                        sb.append(" cannot be used as a format!");
                                        SentryLogcatAdapter.w(TAG, sb.toString(), th);
                                    } catch (Throwable th2) {
                                        th = th2;
                                        try {
                                            SentryLogcatAdapter.w(TAG, "Video size " + size.getWidth() + "x" + size.getHeight() + " cannot be used as a format!", th);
                                            cameraDeviceDetails = this;
                                            it3 = it2;
                                            list3 = list;
                                        } catch (Throwable th3) {
                                            th = th3;
                                            SentryLogcatAdapter.w(TAG, "Dynamic Range Profile " + dynamicRange + " cannot be used as a format!", th);
                                            cameraDeviceDetails = this;
                                            it3 = it2;
                                        }
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                    list = list3;
                                    SentryLogcatAdapter.w(TAG, "Video size " + size.getWidth() + "x" + size.getHeight() + " cannot be used as a format!", th);
                                    cameraDeviceDetails = this;
                                    it3 = it2;
                                    list3 = list;
                                }
                            }
                            cameraDeviceDetails = this;
                            it3 = it2;
                            list3 = list;
                        }
                        it2 = it3;
                        list = list3;
                    } catch (Throwable th5) {
                        th = th5;
                        it2 = it3;
                    }
                    cameraDeviceDetails = this;
                    it3 = it2;
                    list3 = list;
                }
                it2 = it3;
                cameraDeviceDetails = this;
                it3 = it2;
            } catch (Throwable th6) {
                th = th6;
                it2 = it3;
            }
        }
        Intrinsics.checkNotNull(writableArrayCreateArray);
        return writableArrayCreateArray;
    }

    private final ReadableMap buildFormatMap(Size size, Size size2, Range<Integer> range) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putInt("photoHeight", size.getHeight());
        writableMapCreateMap.putInt("photoWidth", size.getWidth());
        writableMapCreateMap.putInt("videoHeight", size2.getHeight());
        writableMapCreateMap.putInt("videoWidth", size2.getWidth());
        Object lower = range.getLower();
        Intrinsics.checkNotNullExpressionValue(lower, "getLower(...)");
        writableMapCreateMap.putInt("minFps", ((Number) lower).intValue());
        Object upper = range.getUpper();
        Intrinsics.checkNotNullExpressionValue(upper, "getUpper(...)");
        writableMapCreateMap.putInt("maxFps", ((Number) upper).intValue());
        Object lower2 = this.isoRange.getLower();
        Intrinsics.checkNotNullExpressionValue(lower2, "getLower(...)");
        writableMapCreateMap.putInt("minISO", ((Number) lower2).intValue());
        Object upper2 = this.isoRange.getUpper();
        Intrinsics.checkNotNullExpressionValue(upper2, "getUpper(...)");
        writableMapCreateMap.putInt("maxISO", ((Number) upper2).intValue());
        writableMapCreateMap.putDouble("fieldOfView", this.maxFieldOfView);
        writableMapCreateMap.putBoolean("supportsVideoHdr", this.supports10BitHdr);
        writableMapCreateMap.putBoolean("supportsPhotoHdr", this.supportsHdrExtension);
        writableMapCreateMap.putBoolean("supportsDepthCapture", this.supportsDepthCapture);
        writableMapCreateMap.putString("autoFocusSystem", this.autoFocusSystem.getUnionValue());
        writableMapCreateMap.putArray("videoStabilizationModes", createStabilizationModes());
        Intrinsics.checkNotNull(writableMapCreateMap);
        return writableMapCreateMap;
    }

    private final boolean getSupports10BitHDR() {
        Set<DynamicRange> supportedDynamicRanges = this.videoCapabilities.getSupportedDynamicRanges();
        Intrinsics.checkNotNullExpressionValue(supportedDynamicRanges, "getSupportedDynamicRanges(...)");
        Set<DynamicRange> set = supportedDynamicRanges;
        if (!(set instanceof Collection) || !set.isEmpty()) {
            for (DynamicRange dynamicRange : set) {
                if (dynamicRange.is10BitHdr() || Intrinsics.areEqual(dynamicRange, DynamicRange.HDR_UNSPECIFIED_10_BIT)) {
                    return true;
                }
            }
        }
        return false;
    }

    private final boolean getSupportsFocus() {
        MeteringPoint meteringPointCreatePoint = new SurfaceOrientedMeteringPointFactory(1.0f, 1.0f).createPoint(0.5f, 0.5f);
        Intrinsics.checkNotNullExpressionValue(meteringPointCreatePoint, "createPoint(...)");
        return this.cameraInfo.isFocusMeteringSupported(new FocusMeteringAction.Builder(meteringPointCreatePoint).build());
    }

    private final double getMinFocusDistanceCm() {
        Float f;
        CameraInfo cameraInfo = this.cameraInfo;
        Camera2CameraInfoImpl camera2CameraInfoImpl = cameraInfo instanceof Camera2CameraInfoImpl ? (Camera2CameraInfoImpl) cameraInfo : null;
        if (camera2CameraInfoImpl == null || (f = (Float) camera2CameraInfoImpl.getCameraCharacteristicsCompat().get(CameraCharacteristics.LENS_INFO_MINIMUM_FOCUS_DISTANCE)) == null || Intrinsics.areEqual(f, 0.0f) || Float.isNaN(f.floatValue()) || Float.isInfinite(f.floatValue())) {
            return 0.0d;
        }
        return (1.0d / ((double) f.floatValue())) * 100.0d;
    }

    private final Range<Integer> getIsoRange() {
        CameraInfo cameraInfo = this.cameraInfo;
        Camera2CameraInfoImpl camera2CameraInfoImpl = cameraInfo instanceof Camera2CameraInfoImpl ? (Camera2CameraInfoImpl) cameraInfo : null;
        if (camera2CameraInfoImpl == null) {
            return new Range<>(0, 0);
        }
        Range<Integer> range = (Range) camera2CameraInfoImpl.getCameraCharacteristicsCompat().get(CameraCharacteristics.SENSOR_INFO_SENSITIVITY_RANGE);
        return range == null ? new Range<>(0, 0) : range;
    }

    private final ReadableArray createStabilizationModes() {
        Set setMutableSetOf = SetsKt__SetsKt.mutableSetOf(VideoStabilizationMode.OFF);
        if (this.videoCapabilities.isStabilizationSupported()) {
            setMutableSetOf.add(VideoStabilizationMode.CINEMATIC);
        }
        if (this.previewCapabilities.isStabilizationSupported()) {
            setMutableSetOf.add(VideoStabilizationMode.CINEMATIC_EXTENDED);
        }
        WritableArray writableArrayCreateArray = Arguments.createArray();
        Iterator it2 = setMutableSetOf.iterator();
        while (it2.hasNext()) {
            writableArrayCreateArray.pushString(((VideoStabilizationMode) it2.next()).getUnionValue());
        }
        Intrinsics.checkNotNull(writableArrayCreateArray);
        return writableArrayCreateArray;
    }

    private final List<DeviceType> getDeviceTypes() {
        DeviceType deviceType;
        List<DeviceType> listListOf = CollectionsKt__CollectionsJVMKt.listOf(DeviceType.WIDE_ANGLE);
        Camera2CameraInfoImpl camera2CameraInfoImpl = this.camera2Details;
        if (camera2CameraInfoImpl == null) {
            return listListOf;
        }
        Map<String, CameraCharacteristics> cameraCharacteristicsMap = camera2CameraInfoImpl.getCameraCharacteristicsMap();
        Intrinsics.checkNotNullExpressionValue(cameraCharacteristicsMap, "getCameraCharacteristicsMap(...)");
        ArrayList arrayList = new ArrayList(cameraCharacteristicsMap.size());
        Iterator<Map.Entry<String, CameraCharacteristics>> it2 = cameraCharacteristicsMap.entrySet().iterator();
        while (it2.hasNext()) {
            CameraCharacteristics value = it2.next().getValue();
            SizeF sizeF = (SizeF) value.get(CameraCharacteristics.SENSOR_INFO_PHYSICAL_SIZE);
            if (sizeF == null) {
                deviceType = DeviceType.WIDE_ANGLE;
            } else {
                float[] fArr = (float[]) value.get(CameraCharacteristics.LENS_INFO_AVAILABLE_FOCAL_LENGTHS);
                if (fArr == null) {
                    deviceType = DeviceType.WIDE_ANGLE;
                } else {
                    double maxFieldOfView = getMaxFieldOfView(fArr, sizeF);
                    if (maxFieldOfView > 94.0d) {
                        deviceType = DeviceType.ULTRA_WIDE_ANGLE;
                    } else if (60.0d <= maxFieldOfView && maxFieldOfView <= 94.0d) {
                        deviceType = DeviceType.WIDE_ANGLE;
                    } else if (maxFieldOfView < 60.0d) {
                        deviceType = DeviceType.TELEPHOTO;
                    } else {
                        throw new Error("Invalid Field Of View! (" + maxFieldOfView + ")");
                    }
                }
            }
            arrayList.add(deviceType);
        }
        return arrayList;
    }

    private final double getFieldOfView(float f, SizeF sizeF) {
        if (sizeF.getWidth() == 0.0f || sizeF.getHeight() == 0.0f) {
            return 0.0d;
        }
        return Math.toDegrees(Math.atan2(Math.sqrt((sizeF.getWidth() * sizeF.getWidth()) + (sizeF.getHeight() * sizeF.getHeight())), ((double) f) * 2.0d) * 2.0d);
    }

    private final double getMaxFieldOfView(float[] fArr, SizeF sizeF) {
        Float fMinOrNull = ArraysKt___ArraysKt.minOrNull(fArr);
        if (fMinOrNull != null) {
            return getFieldOfView(fMinOrNull.floatValue(), sizeF);
        }
        return 0.0d;
    }

    private final double getMaxFieldOfView() {
        CameraCharacteristicsCompat cameraCharacteristicsCompat;
        SizeF sizeF;
        float[] fArr;
        Camera2CameraInfoImpl camera2CameraInfoImpl = this.camera2Details;
        if (camera2CameraInfoImpl == null || (cameraCharacteristicsCompat = camera2CameraInfoImpl.getCameraCharacteristicsCompat()) == null || (sizeF = (SizeF) cameraCharacteristicsCompat.get(CameraCharacteristics.SENSOR_INFO_PHYSICAL_SIZE)) == null || (fArr = (float[]) cameraCharacteristicsCompat.get(CameraCharacteristics.LENS_INFO_AVAILABLE_FOCAL_LENGTHS)) == null) {
            return 0.0d;
        }
        return getMaxFieldOfView(fArr, sizeF);
    }
}
