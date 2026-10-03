package androidx.compose.ui.text.android;

import android.text.StaticLayout;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
final class StaticLayoutFactory26 {
    public static final StaticLayoutFactory26 INSTANCE = new StaticLayoutFactory26();

    private StaticLayoutFactory26() {
    }

    @JvmStatic
    public static final void setJustificationMode(@NotNull StaticLayout.Builder builder, int i) {
        builder.setJustificationMode(i);
    }
}
