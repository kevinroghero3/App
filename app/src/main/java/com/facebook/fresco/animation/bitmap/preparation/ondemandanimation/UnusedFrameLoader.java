package com.facebook.fresco.animation.bitmap.preparation.ondemandanimation;

import java.util.Date;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
final class UnusedFrameLoader {
    private final FrameLoader frameLoader;
    private final Date insertedTime;

    public UnusedFrameLoader(@NotNull FrameLoader frameLoader, @NotNull Date insertedTime) {
        Intrinsics.checkNotNullParameter(frameLoader, "frameLoader");
        Intrinsics.checkNotNullParameter(insertedTime, "insertedTime");
        this.frameLoader = frameLoader;
        this.insertedTime = insertedTime;
    }

    public final FrameLoader getFrameLoader() {
        return this.frameLoader;
    }

    public final Date getInsertedTime() {
        return this.insertedTime;
    }
}
