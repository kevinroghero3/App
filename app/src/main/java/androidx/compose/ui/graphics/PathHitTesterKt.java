package androidx.compose.ui.graphics;

import androidx.annotation.FloatRange;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class PathHitTesterKt {
    private static final Path EmptyPath = AndroidPath_androidKt.Path();

    public static /* synthetic */ PathHitTester PathHitTester$default(Path path, float f, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 0.5f;
        }
        return PathHitTester(path, f);
    }

    public static final PathHitTester PathHitTester(@NotNull Path path, @FloatRange(from = 0.0d) float f) {
        PathHitTester pathHitTester = new PathHitTester();
        pathHitTester.updatePath(path, f);
        return pathHitTester;
    }
}
