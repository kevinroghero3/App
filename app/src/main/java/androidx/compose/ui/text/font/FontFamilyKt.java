package androidx.compose.ui.text.font;

import java.util.List;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class FontFamilyKt {
    public static final FontFamily FontFamily(@NotNull List<? extends Font> list) {
        return new FontListFontFamily(list);
    }

    public static final FontFamily FontFamily(@NotNull Font... fontArr) {
        return new FontListFontFamily(ArraysKt___ArraysJvmKt.asList(fontArr));
    }

    public static final FontFamily FontFamily(@NotNull Typeface typeface) {
        return new LoadedFontFamily(typeface);
    }
}
