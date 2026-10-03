package androidx.compose.ui.graphics.layer;

import android.graphics.Canvas;
import android.view.Surface;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
final class LockHardwareCanvasHelper {
    public static final LockHardwareCanvasHelper INSTANCE = new LockHardwareCanvasHelper();

    private LockHardwareCanvasHelper() {
    }

    public final Canvas lockHardwareCanvas(@NotNull Surface surface) {
        return surface.lockHardwareCanvas();
    }
}
