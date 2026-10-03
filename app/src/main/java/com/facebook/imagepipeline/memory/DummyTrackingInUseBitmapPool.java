package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import com.facebook.common.internal.Sets;
import com.facebook.common.memory.MemoryTrimType;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public final class DummyTrackingInUseBitmapPool implements BitmapPool {
    private final Set<Bitmap> inUseValues;

    @Override // com.facebook.common.memory.MemoryTrimmable
    public void trim(@NotNull MemoryTrimType trimType) {
        Intrinsics.checkNotNullParameter(trimType, "trimType");
    }

    public DummyTrackingInUseBitmapPool() {
        Set<Bitmap> setNewIdentityHashSet = Sets.newIdentityHashSet();
        Intrinsics.checkNotNullExpressionValue(setNewIdentityHashSet, "newIdentityHashSet(...)");
        this.inUseValues = setNewIdentityHashSet;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.facebook.common.memory.Pool
    public Bitmap get(int i) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(1, (int) Math.ceil(((double) i) / 2.0d), Bitmap.Config.RGB_565);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        this.inUseValues.add(bitmapCreateBitmap);
        return bitmapCreateBitmap;
    }

    @Override // com.facebook.common.memory.Pool, com.facebook.common.references.ResourceReleaser
    public void release(@NotNull Bitmap value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.inUseValues.remove(value);
        value.recycle();
    }
}
