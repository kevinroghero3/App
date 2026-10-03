package com.mrousavy.camera.core.extensions;

import androidx.camera.core.CameraState;
import com.mrousavy.camera.core.CameraError;
import com.mrousavy.camera.core.CameraInUseError;
import com.mrousavy.camera.core.CameraIsRestrictedError;
import com.mrousavy.camera.core.DoNotDisturbBugError;
import com.mrousavy.camera.core.FatalCameraError;
import com.mrousavy.camera.core.InvalidOutputConfigurationError;
import com.mrousavy.camera.core.MaxCamerasInUseError;
import com.mrousavy.camera.core.RecoverableError;
import com.mrousavy.camera.core.UnknownCameraError;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class StateError_toCameraErrorKt {
    public static final CameraError toCameraError(@NotNull CameraState.StateError stateError) {
        Intrinsics.checkNotNullParameter(stateError, "<this>");
        switch (stateError.getCode()) {
            case 1:
                return new MaxCamerasInUseError(stateError.getCause());
            case 2:
                return new CameraInUseError(stateError.getCause());
            case 3:
                return new RecoverableError(stateError.getCause());
            case 4:
                return new InvalidOutputConfigurationError(stateError.getCause());
            case 5:
                return new CameraIsRestrictedError(stateError.getCause());
            case 6:
                return new FatalCameraError(stateError.getCause());
            case 7:
                return new DoNotDisturbBugError(stateError.getCause());
            default:
                return new UnknownCameraError(stateError.getCause());
        }
    }
}
