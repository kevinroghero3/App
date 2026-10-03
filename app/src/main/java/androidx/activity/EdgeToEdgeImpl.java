package androidx.activity;

import android.view.View;
import android.view.Window;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
interface EdgeToEdgeImpl {
    void adjustLayoutInDisplayCutoutMode(@NotNull Window window);

    void setUp(@NotNull SystemBarStyle systemBarStyle, @NotNull SystemBarStyle systemBarStyle2, @NotNull Window window, @NotNull View view, boolean z, boolean z2);
}
