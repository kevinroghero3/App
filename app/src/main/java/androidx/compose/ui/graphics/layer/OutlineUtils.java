package androidx.compose.ui.graphics.layer;

import android.view.View;
import java.lang.reflect.Method;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
final class OutlineUtils {
    public static final OutlineUtils INSTANCE = new OutlineUtils();
    private static boolean hasRetrievedMethod;
    private static Method rebuildOutlineMethod;

    private OutlineUtils() {
    }

    public final boolean rebuildOutline(@NotNull View view) {
        view.invalidateOutline();
        return true;
    }
}
