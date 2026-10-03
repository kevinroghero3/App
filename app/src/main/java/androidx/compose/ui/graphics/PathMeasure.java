package androidx.compose.ui.graphics;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public interface PathMeasure {
    float getLength();

    /* JADX INFO: renamed from: getPosition-tuRUvjQ */
    long mo1067getPositiontuRUvjQ(float f);

    boolean getSegment(float f, float f2, @NotNull Path path, boolean z);

    /* JADX INFO: renamed from: getTangent-tuRUvjQ */
    long mo1068getTangenttuRUvjQ(float f);

    void setPath(@Nullable Path path, boolean z);

    public static final class DefaultImpls {
    }

    static /* synthetic */ boolean getSegment$default(PathMeasure pathMeasure, float f, float f2, Path path, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getSegment");
        }
        if ((i & 8) != 0) {
            z = true;
        }
        return pathMeasure.getSegment(f, f2, path, z);
    }
}
