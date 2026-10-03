package com.facebook.react.shell;

import com.facebook.imagepipeline.core.ImagePipelineConfig;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public final class MainPackageConfig {
    private final ImagePipelineConfig frescoConfig;

    public MainPackageConfig(@NotNull ImagePipelineConfig frescoConfig) {
        Intrinsics.checkNotNullParameter(frescoConfig, "frescoConfig");
        this.frescoConfig = frescoConfig;
    }

    public final ImagePipelineConfig getFrescoConfig() {
        return this.frescoConfig;
    }
}
