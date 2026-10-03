package androidx.compose.ui.platform;

import androidx.compose.ui.text.AnnotatedString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public interface ClipboardManager {
    default ClipEntry getClip() {
        return null;
    }

    AnnotatedString getText();

    default void setClip(@Nullable ClipEntry clipEntry) {
    }

    void setText(@NotNull AnnotatedString annotatedString);

    default boolean hasText() {
        AnnotatedString text = getText();
        return text != null && text.length() > 0;
    }

    default android.content.ClipboardManager getNativeClipboard() {
        throw new UnsupportedOperationException("This platform does not offer a native Clipboard");
    }
}
