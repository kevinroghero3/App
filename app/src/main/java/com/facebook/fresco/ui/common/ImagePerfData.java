package com.facebook.fresco.ui.common;

import com.facebook.common.internal.Objects;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class ImagePerfData {
    public static final Companion Companion = new Companion(null);
    public static final long UNSET = -1;
    private final Object callerContext;
    private final String callingClassNameOnVisible;
    private final String contentIdOnVisible;
    private final String[] contextChainArrayOnVisible;
    private final String contextChainExtrasOnVisible;
    private final long controllerFailureTimeMs;
    private final long controllerFinalImageSetTimeMs;
    private final String controllerId;
    private final long controllerSubmitTimeMs;
    private final Integer densityDpiOnSuccess;
    private final DimensionsInfo dimensionsInfo;
    private final Long emptyEventTimestampNs;
    private final Integer errorCodeOnFailure;
    private final String errorMessageOnFailure;
    private final String errorStacktraceStringOnFailure;
    private final Throwable errorThrowable;
    private final ControllerListener2.Extras extraData;
    private final Object imageInfo;
    private final Object imageRequest;
    private final long imageRequestEndTimeMs;
    private final long imageRequestStartTimeMs;
    private final ImageRenderingInfra infra;
    private final int instanceId;
    private final long intermediateImageLoadTimeMs;
    private final List<Pair<String, Long>> intermediateImageSetTimes;
    private final long invisibilityEventTimeMs;
    private final boolean isPrefetch;
    private final Long msSinceLastNavigationOnVisible;
    private final boolean newIntermediateImageSetPointAvailable;
    private final int onScreenHeightPx;
    private final int onScreenWidthPx;
    private final Long releasedEventTimestampNs;
    private final String requestId;
    private final String rootContextNameOnVisible;
    private final String startupStatusOnVisible;
    private final String subSurfaceOnVisible;
    private final String surfaceOnVisible;
    private final long visibilityEventTimeMs;
    private final VisibilityState visibilityState;

    public ImagePerfData(@NotNull ImageRenderingInfra infra, @Nullable String str, @Nullable String str2, @Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, long j, long j2, long j3, long j4, long j5, long j6, @Nullable Long l, @Nullable Long l2, boolean z, int i, int i2, @Nullable Throwable th, @NotNull VisibilityState visibilityState, long j7, long j8, @Nullable DimensionsInfo dimensionsInfo, @Nullable ControllerListener2.Extras extras, @Nullable String str3, @Nullable String str4, @Nullable String[] strArr, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable Long l3, @Nullable String str9, @NotNull List<Pair<String, Long>> intermediateImageSetTimes, boolean z2, @Nullable String str10, @Nullable String str11, @Nullable Integer num, @Nullable Integer num2) {
        Intrinsics.checkNotNullParameter(infra, "infra");
        Intrinsics.checkNotNullParameter(visibilityState, "visibilityState");
        Intrinsics.checkNotNullParameter(intermediateImageSetTimes, "intermediateImageSetTimes");
        this.infra = infra;
        this.controllerId = str;
        this.requestId = str2;
        this.imageRequest = obj;
        this.callerContext = obj2;
        this.imageInfo = obj3;
        this.controllerSubmitTimeMs = j;
        this.intermediateImageLoadTimeMs = j2;
        this.controllerFinalImageSetTimeMs = j3;
        this.controllerFailureTimeMs = j4;
        this.imageRequestStartTimeMs = j5;
        this.imageRequestEndTimeMs = j6;
        this.emptyEventTimestampNs = l;
        this.releasedEventTimestampNs = l2;
        this.isPrefetch = z;
        this.onScreenWidthPx = i;
        this.onScreenHeightPx = i2;
        this.errorThrowable = th;
        this.visibilityState = visibilityState;
        this.visibilityEventTimeMs = j7;
        this.invisibilityEventTimeMs = j8;
        this.dimensionsInfo = dimensionsInfo;
        this.extraData = extras;
        this.callingClassNameOnVisible = str3;
        this.rootContextNameOnVisible = str4;
        this.contextChainArrayOnVisible = strArr;
        this.contextChainExtrasOnVisible = str5;
        this.contentIdOnVisible = str6;
        this.surfaceOnVisible = str7;
        this.subSurfaceOnVisible = str8;
        this.msSinceLastNavigationOnVisible = l3;
        this.startupStatusOnVisible = str9;
        this.intermediateImageSetTimes = intermediateImageSetTimes;
        this.newIntermediateImageSetPointAvailable = z2;
        this.errorMessageOnFailure = str10;
        this.errorStacktraceStringOnFailure = str11;
        this.errorCodeOnFailure = num;
        this.densityDpiOnSuccess = num2;
        this.instanceId = str != null ? str.hashCode() : 0;
    }

    public final ImageRenderingInfra getInfra() {
        return this.infra;
    }

    public final String getControllerId() {
        return this.controllerId;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final Object getImageRequest() {
        return this.imageRequest;
    }

    public final Object getCallerContext() {
        return this.callerContext;
    }

    public final Object getImageInfo() {
        return this.imageInfo;
    }

    public final long getControllerSubmitTimeMs() {
        return this.controllerSubmitTimeMs;
    }

    public final long getIntermediateImageLoadTimeMs() {
        return this.intermediateImageLoadTimeMs;
    }

    public final long getControllerFinalImageSetTimeMs() {
        return this.controllerFinalImageSetTimeMs;
    }

    public final long getControllerFailureTimeMs() {
        return this.controllerFailureTimeMs;
    }

    public final long getImageRequestStartTimeMs() {
        return this.imageRequestStartTimeMs;
    }

    public final long getImageRequestEndTimeMs() {
        return this.imageRequestEndTimeMs;
    }

    public final Long getEmptyEventTimestampNs() {
        return this.emptyEventTimestampNs;
    }

    public final Long getReleasedEventTimestampNs() {
        return this.releasedEventTimestampNs;
    }

    public final boolean isPrefetch() {
        return this.isPrefetch;
    }

    public final int getOnScreenWidthPx() {
        return this.onScreenWidthPx;
    }

    public final int getOnScreenHeightPx() {
        return this.onScreenHeightPx;
    }

    public final Throwable getErrorThrowable() {
        return this.errorThrowable;
    }

    public final VisibilityState getVisibilityState() {
        return this.visibilityState;
    }

    public final long getVisibilityEventTimeMs() {
        return this.visibilityEventTimeMs;
    }

    public final long getInvisibilityEventTimeMs() {
        return this.invisibilityEventTimeMs;
    }

    public final DimensionsInfo getDimensionsInfo() {
        return this.dimensionsInfo;
    }

    public final ControllerListener2.Extras getExtraData() {
        return this.extraData;
    }

    public final String getCallingClassNameOnVisible() {
        return this.callingClassNameOnVisible;
    }

    public final String getRootContextNameOnVisible() {
        return this.rootContextNameOnVisible;
    }

    public final String[] getContextChainArrayOnVisible() {
        return this.contextChainArrayOnVisible;
    }

    public final String getContextChainExtrasOnVisible() {
        return this.contextChainExtrasOnVisible;
    }

    public final String getContentIdOnVisible() {
        return this.contentIdOnVisible;
    }

    public final String getSurfaceOnVisible() {
        return this.surfaceOnVisible;
    }

    public final String getSubSurfaceOnVisible() {
        return this.subSurfaceOnVisible;
    }

    public final Long getMsSinceLastNavigationOnVisible() {
        return this.msSinceLastNavigationOnVisible;
    }

    public final String getStartupStatusOnVisible() {
        return this.startupStatusOnVisible;
    }

    public final List<Pair<String, Long>> getIntermediateImageSetTimes() {
        return this.intermediateImageSetTimes;
    }

    public final boolean getNewIntermediateImageSetPointAvailable() {
        return this.newIntermediateImageSetPointAvailable;
    }

    public final String getErrorMessageOnFailure() {
        return this.errorMessageOnFailure;
    }

    public final String getErrorStacktraceStringOnFailure() {
        return this.errorStacktraceStringOnFailure;
    }

    public final Integer getErrorCodeOnFailure() {
        return this.errorCodeOnFailure;
    }

    public final Integer getDensityDpiOnSuccess() {
        return this.densityDpiOnSuccess;
    }

    public final int getInstanceId() {
        return this.instanceId;
    }

    public final long getFinalImageLoadTimeMs() {
        long j = this.imageRequestEndTimeMs;
        if (j == -1) {
            return -1L;
        }
        long j2 = this.imageRequestStartTimeMs;
        if (j2 == -1) {
            return -1L;
        }
        return j - j2;
    }

    public final String createDebugString() {
        String string = Objects.toStringHelper(this).add("rendering Infra", this.infra).add("controller ID", this.controllerId).add("request ID", this.requestId).add("controller submit", this.controllerSubmitTimeMs).add("controller final image", this.controllerFinalImageSetTimeMs).add("controller failure", this.controllerFailureTimeMs).add("start time", this.imageRequestStartTimeMs).add("end time", this.imageRequestEndTimeMs).add("prefetch", this.isPrefetch).add("caller context", this.callerContext).add("image request", this.imageRequest).add("image info", this.imageInfo).add("on-screen width", this.onScreenWidthPx).add("on-screen height", this.onScreenHeightPx).add("visibility state", this.visibilityState).add("visibility event", this.visibilityEventTimeMs).add("invisibility event", this.invisibilityEventTimeMs).add("dimensions info", this.dimensionsInfo).add("extra data", this.extraData).toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
