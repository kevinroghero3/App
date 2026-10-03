package com.mrousavy.camera.core.extensions;

import androidx.camera.video.VideoRecordEvent;
import com.mrousavy.camera.core.DurationLimitReachedError;
import com.mrousavy.camera.core.EncoderError;
import com.mrousavy.camera.core.FileSizeLimitReachedError;
import com.mrousavy.camera.core.InsufficientStorageForRecorderError;
import com.mrousavy.camera.core.InvalidRecorderConfigurationError;
import com.mrousavy.camera.core.NoDataError;
import com.mrousavy.camera.core.RecorderError;
import com.mrousavy.camera.core.UnknownRecorderError;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class VideoRecordEvent_toCameraErrorKt {
    public static final RecorderError getCameraError(@NotNull VideoRecordEvent.Finalize finalize) {
        Intrinsics.checkNotNullParameter(finalize, "<this>");
        if (!finalize.hasError()) {
            return null;
        }
        switch (finalize.getError()) {
            case 0:
                return null;
            case 1:
                return new UnknownRecorderError(false, finalize.getCause());
            case 2:
                return new FileSizeLimitReachedError(finalize.getCause());
            case 3:
                return new InsufficientStorageForRecorderError(finalize.getCause());
            case 4:
                return new NoDataError(finalize.getCause());
            case 5:
                return new InvalidRecorderConfigurationError(finalize.getCause());
            case 6:
                return new EncoderError(finalize.getCause());
            case 7:
                return new UnknownRecorderError(false, finalize.getCause());
            case 8:
                return new NoDataError(finalize.getCause());
            case 9:
                return new DurationLimitReachedError(finalize.getCause());
            case 10:
                return new UnknownRecorderError(true, finalize.getCause());
            default:
                return new UnknownRecorderError(false, finalize.getCause());
        }
    }
}
