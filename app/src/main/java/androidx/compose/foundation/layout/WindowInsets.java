package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public interface WindowInsets {
    public static final Companion Companion = Companion.$$INSTANCE;

    int getBottom(@NotNull Density density);

    int getLeft(@NotNull Density density, @NotNull LayoutDirection layoutDirection);

    int getRight(@NotNull Density density, @NotNull LayoutDirection layoutDirection);

    int getTop(@NotNull Density density);

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }
}
