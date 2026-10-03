package androidx.compose.ui.text.input;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class TextFieldValueKt {
    public static final AnnotatedString getTextBeforeSelection(@NotNull TextFieldValue textFieldValue, int i) {
        return textFieldValue.getAnnotatedString().subSequence(Math.max(0, TextRange.m3133getMinimpl(textFieldValue.m3382getSelectiond9O1mEE()) - i), TextRange.m3133getMinimpl(textFieldValue.m3382getSelectiond9O1mEE()));
    }

    public static final AnnotatedString getTextAfterSelection(@NotNull TextFieldValue textFieldValue, int i) {
        return textFieldValue.getAnnotatedString().subSequence(TextRange.m3132getMaximpl(textFieldValue.m3382getSelectiond9O1mEE()), Math.min(TextRange.m3132getMaximpl(textFieldValue.m3382getSelectiond9O1mEE()) + i, textFieldValue.getText().length()));
    }

    public static final AnnotatedString getSelectedText(@NotNull TextFieldValue textFieldValue) {
        return textFieldValue.getAnnotatedString().m2986subSequence5zctL8(textFieldValue.m3382getSelectiond9O1mEE());
    }
}
