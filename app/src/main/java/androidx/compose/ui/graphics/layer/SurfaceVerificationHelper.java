package androidx.compose.ui.graphics.layer;

import android.graphics.Canvas;
import android.view.Surface;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
final class SurfaceVerificationHelper {
    public static final SurfaceVerificationHelper INSTANCE = new SurfaceVerificationHelper();

    private SurfaceVerificationHelper() {
    }

    public final Canvas lockHardwareCanvas(@NotNull Surface surface) {
        return surface.lockHardwareCanvas();
    }
}
