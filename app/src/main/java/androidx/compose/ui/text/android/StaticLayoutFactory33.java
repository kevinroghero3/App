package androidx.compose.ui.text.android;

import android.text.StaticLayout;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
final class StaticLayoutFactory33 {
    public static final StaticLayoutFactory33 INSTANCE = new StaticLayoutFactory33();

    private StaticLayoutFactory33() {
    }

    @JvmStatic
    public static final boolean isFallbackLineSpacingEnabled(@NotNull StaticLayout staticLayout) {
        return staticLayout.isFallbackLineSpacingEnabled();
    }

    @JvmStatic
    public static final void setLineBreakConfig(@NotNull StaticLayout.Builder builder, int i, int i2) {
        builder.setLineBreakConfig(StaticLayoutFactory33$$ExternalSyntheticApiModelOutline5.m().setLineBreakStyle(i).setLineBreakWordStyle(i2).build());
    }
}
