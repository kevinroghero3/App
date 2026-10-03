package androidx.graphics.path;

import android.graphics.Path;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class PathUtilities {
    public static final PathIterator iterator(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        return new PathIterator(path, null, 0.0f, 6, null);
    }

    public static /* synthetic */ PathIterator iterator$default(Path path, PathIterator.ConicEvaluation conicEvaluation, float f, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 0.25f;
        }
        return iterator(path, conicEvaluation, f);
    }

    public static final PathIterator iterator(@NotNull Path path, @NotNull PathIterator.ConicEvaluation conicEvaluation, float f) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(conicEvaluation, "conicEvaluation");
        return new PathIterator(path, conicEvaluation, f);
    }
}
