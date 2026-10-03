package androidx.compose.ui.graphics;

import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidGraphicsContext_androidKt {
    public static final boolean isLayerPersistenceEnabled() {
        return false;
    }

    public static final GraphicsContext GraphicsContext(@NotNull ViewGroup viewGroup) {
        return new AndroidGraphicsContext(viewGroup);
    }

    public static final boolean isLayerManagerInitialized(@NotNull GraphicsContext graphicsContext) {
        Intrinsics.checkNotNull(graphicsContext, "null cannot be cast to non-null type androidx.compose.ui.graphics.AndroidGraphicsContext");
        return ((AndroidGraphicsContext) graphicsContext).isLayerManagerInitialized();
    }
}
