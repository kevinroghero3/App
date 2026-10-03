package androidx.camera.core.impl;

import android.util.Size;
import androidx.annotation.NonNull;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class SurfaceSizeDefinition {
    public abstract Size getAnalysisSize();

    public abstract Map<Integer, Size> getMaximumSizeMap();

    public abstract Size getPreviewSize();

    public abstract Size getRecordSize();

    public abstract Map<Integer, Size> getS1440pSizeMap();

    public abstract Map<Integer, Size> getS720pSizeMap();

    public abstract Map<Integer, Size> getUltraMaximumSizeMap();

    SurfaceSizeDefinition() {
    }

    public static SurfaceSizeDefinition create(@NonNull Size size, @NonNull Map<Integer, Size> map, @NonNull Size size2, @NonNull Map<Integer, Size> map2, @NonNull Size size3, @NonNull Map<Integer, Size> map3, @NonNull Map<Integer, Size> map4) {
        return new AutoValue_SurfaceSizeDefinition(size, map, size2, map2, size3, map3, map4);
    }

    public Size getS720pSize(int i) {
        return getS720pSizeMap().get(Integer.valueOf(i));
    }

    public Size getS1440pSize(int i) {
        return getS1440pSizeMap().get(Integer.valueOf(i));
    }

    public Size getMaximumSize(int i) {
        return getMaximumSizeMap().get(Integer.valueOf(i));
    }

    public Size getUltraMaximumSize(int i) {
        return getUltraMaximumSizeMap().get(Integer.valueOf(i));
    }
}
