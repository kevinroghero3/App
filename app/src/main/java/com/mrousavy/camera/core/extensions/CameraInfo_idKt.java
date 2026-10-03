package com.mrousavy.camera.core.extensions;

import androidx.camera.core.CameraInfo;
import androidx.camera.core.impl.CameraInfoInternal;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class CameraInfo_idKt {
    public static final String getId(@NotNull CameraInfo cameraInfo) {
        Intrinsics.checkNotNullParameter(cameraInfo, "<this>");
        CameraInfoInternal cameraInfoInternal = cameraInfo instanceof CameraInfoInternal ? (CameraInfoInternal) cameraInfo : null;
        if (cameraInfoInternal != null) {
            return cameraInfoInternal.getCameraId();
        }
        return null;
    }
}
