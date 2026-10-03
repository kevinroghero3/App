package androidx.compose.ui.text;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
final class AnnotationSpan {
    private final String key;
    private final String value;

    public AnnotationSpan(@NotNull String str, @NotNull String str2) {
        this.key = str;
        this.value = str2;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getValue() {
        return this.value;
    }
}
