package com.facebook.fresco.animation.bitmap.preparation;

import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.bitmap.BitmapFrameCache;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public interface BitmapFramePreparer {
    boolean prepareFrame(@NotNull BitmapFrameCache bitmapFrameCache, @NotNull AnimationBackend animationBackend, int i);
}
