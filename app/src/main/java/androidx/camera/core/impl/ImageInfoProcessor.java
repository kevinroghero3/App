package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.camera.core.ImageInfo;

/* JADX INFO: loaded from: classes3.dex */
public interface ImageInfoProcessor {
    CaptureStage getCaptureStage();

    boolean process(@NonNull ImageInfo imageInfo);
}
