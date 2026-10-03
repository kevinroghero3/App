package androidx.compose.ui.text;

import java.util.Locale;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface PlatformStringDelegate {
    String capitalize(@NotNull String str, @NotNull Locale locale);

    String decapitalize(@NotNull String str, @NotNull Locale locale);

    String toLowerCase(@NotNull String str, @NotNull Locale locale);

    String toUpperCase(@NotNull String str, @NotNull Locale locale);
}
