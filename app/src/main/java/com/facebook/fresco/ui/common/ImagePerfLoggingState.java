package com.facebook.fresco.ui.common;

import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public class ImagePerfLoggingState {
    private String callingClassNameOnVisible;
    private String contentIdOnVisible;
    private String[] contextChainArrayOnVisible;
    private String contextChainExtrasOnVisible;
    private Integer densityDpiOnSuccess;
    private Long emptyEventTimestampNs;
    private Integer errorCodeOnFailure;
    private String errorMessageOnFailure;
    private String errorStacktraceStringOnFailure;
    private final ImageRenderingInfra infra;
    private final List<Pair<String, Long>> intermediateImageSetTimes;
    private Long msSinceLastNavigationOnVisible;
    private boolean newIntermediateImageSetPointAvailable;
    private Long releasedEventTimestampNs;
    private String rootContextNameOnVisible;
    private String startupStatusOnVisible;
    private String subSurfaceOnVisible;
    private String surfaceOnVisible;

    public ImagePerfLoggingState(@NotNull ImageRenderingInfra infra) {
        Intrinsics.checkNotNullParameter(infra, "infra");
        this.infra = infra;
        this.intermediateImageSetTimes = new ArrayList();
    }

    public final ImageRenderingInfra getInfra() {
        return this.infra;
    }

    public final List<Pair<String, Long>> getIntermediateImageSetTimes() {
        return this.intermediateImageSetTimes;
    }

    public final boolean getNewIntermediateImageSetPointAvailable() {
        return this.newIntermediateImageSetPointAvailable;
    }

    public final void setNewIntermediateImageSetPointAvailable(boolean z) {
        this.newIntermediateImageSetPointAvailable = z;
    }

    public final Long getEmptyEventTimestampNs() {
        return this.emptyEventTimestampNs;
    }

    public final void setEmptyEventTimestampNs(@Nullable Long l) {
        this.emptyEventTimestampNs = l;
    }

    public final Long getReleasedEventTimestampNs() {
        return this.releasedEventTimestampNs;
    }

    public final void setReleasedEventTimestampNs(@Nullable Long l) {
        this.releasedEventTimestampNs = l;
    }

    public final String getCallingClassNameOnVisible() {
        return this.callingClassNameOnVisible;
    }

    public final void setCallingClassNameOnVisible(@Nullable String str) {
        this.callingClassNameOnVisible = str;
    }

    public final String getRootContextNameOnVisible() {
        return this.rootContextNameOnVisible;
    }

    public final void setRootContextNameOnVisible(@Nullable String str) {
        this.rootContextNameOnVisible = str;
    }

    public final String[] getContextChainArrayOnVisible() {
        return this.contextChainArrayOnVisible;
    }

    public final void setContextChainArrayOnVisible(@Nullable String[] strArr) {
        this.contextChainArrayOnVisible = strArr;
    }

    public final String getContextChainExtrasOnVisible() {
        return this.contextChainExtrasOnVisible;
    }

    public final void setContextChainExtrasOnVisible(@Nullable String str) {
        this.contextChainExtrasOnVisible = str;
    }

    public final String getContentIdOnVisible() {
        return this.contentIdOnVisible;
    }

    public final void setContentIdOnVisible(@Nullable String str) {
        this.contentIdOnVisible = str;
    }

    public final String getSurfaceOnVisible() {
        return this.surfaceOnVisible;
    }

    public final void setSurfaceOnVisible(@Nullable String str) {
        this.surfaceOnVisible = str;
    }

    public final String getSubSurfaceOnVisible() {
        return this.subSurfaceOnVisible;
    }

    public final void setSubSurfaceOnVisible(@Nullable String str) {
        this.subSurfaceOnVisible = str;
    }

    public final Long getMsSinceLastNavigationOnVisible() {
        return this.msSinceLastNavigationOnVisible;
    }

    public final void setMsSinceLastNavigationOnVisible(@Nullable Long l) {
        this.msSinceLastNavigationOnVisible = l;
    }

    public final String getStartupStatusOnVisible() {
        return this.startupStatusOnVisible;
    }

    public final void setStartupStatusOnVisible(@Nullable String str) {
        this.startupStatusOnVisible = str;
    }

    public final String getErrorMessageOnFailure() {
        return this.errorMessageOnFailure;
    }

    public final void setErrorMessageOnFailure(@Nullable String str) {
        this.errorMessageOnFailure = str;
    }

    public final String getErrorStacktraceStringOnFailure() {
        return this.errorStacktraceStringOnFailure;
    }

    public final void setErrorStacktraceStringOnFailure(@Nullable String str) {
        this.errorStacktraceStringOnFailure = str;
    }

    public final Integer getErrorCodeOnFailure() {
        return this.errorCodeOnFailure;
    }

    public final void setErrorCodeOnFailure(@Nullable Integer num) {
        this.errorCodeOnFailure = num;
    }

    public final Integer getDensityDpiOnSuccess() {
        return this.densityDpiOnSuccess;
    }

    public final void setDensityDpiOnSuccess(@Nullable Integer num) {
        this.densityDpiOnSuccess = num;
    }

    public final void resetLoggingState$ui_common_release() {
        this.intermediateImageSetTimes.clear();
        this.newIntermediateImageSetPointAvailable = false;
        this.emptyEventTimestampNs = null;
        this.releasedEventTimestampNs = null;
        this.callingClassNameOnVisible = null;
        this.rootContextNameOnVisible = null;
        this.contextChainArrayOnVisible = null;
        this.contextChainExtrasOnVisible = null;
        this.contentIdOnVisible = null;
        this.surfaceOnVisible = null;
        this.subSurfaceOnVisible = null;
        this.msSinceLastNavigationOnVisible = null;
        this.startupStatusOnVisible = null;
        this.errorMessageOnFailure = null;
        this.errorStacktraceStringOnFailure = null;
        this.errorCodeOnFailure = null;
        this.densityDpiOnSuccess = null;
    }
}
