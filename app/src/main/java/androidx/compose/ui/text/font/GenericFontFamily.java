package androidx.compose.ui.text.font;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class GenericFontFamily extends SystemFontFamily {
    public static final int $stable = 0;
    private final String fontFamilyName;
    private final String name;

    public final String getName() {
        return this.name;
    }

    public GenericFontFamily(@NotNull String str, @NotNull String str2) {
        super(null);
        this.name = str;
        this.fontFamilyName = str2;
    }

    public String toString() {
        return this.fontFamilyName;
    }
}
