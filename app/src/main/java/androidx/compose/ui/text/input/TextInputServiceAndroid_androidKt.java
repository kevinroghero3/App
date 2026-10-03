package androidx.compose.ui.text.input;

import android.view.Choreographer;
import android.view.inputmethod.EditorInfo;
import androidx.compose.ui.text.TextRange;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.emoji2.text.EmojiCompat;
import java.util.concurrent.Executor;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class TextInputServiceAndroid_androidKt {
    private static final String DEBUG_CLASS = "TextInputServiceAndroid";

    private static final boolean hasFlag(int i, int i2) {
        return (i & i2) == i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateWithEmojiCompat(EditorInfo editorInfo) {
        if (EmojiCompat.isConfigured()) {
            EmojiCompat.get().updateEditorInfo(editorInfo);
        }
    }

    public static final void update(@NotNull EditorInfo editorInfo, @NotNull ImeOptions imeOptions, @NotNull TextFieldValue textFieldValue) {
        int i;
        String privateImeOptions;
        int iM3329getImeActioneUduSuo = imeOptions.m3329getImeActioneUduSuo();
        ImeAction.Companion companion = ImeAction.Companion;
        if (ImeAction.m3300equalsimpl0(iM3329getImeActioneUduSuo, companion.m3313getDefaulteUduSuo())) {
            i = imeOptions.getSingleLine() ? 6 : 0;
        } else if (ImeAction.m3300equalsimpl0(iM3329getImeActioneUduSuo, companion.m3317getNoneeUduSuo())) {
            i = 1;
        } else if (ImeAction.m3300equalsimpl0(iM3329getImeActioneUduSuo, companion.m3315getGoeUduSuo())) {
            i = 2;
        } else if (ImeAction.m3300equalsimpl0(iM3329getImeActioneUduSuo, companion.m3316getNexteUduSuo())) {
            i = 5;
        } else if (ImeAction.m3300equalsimpl0(iM3329getImeActioneUduSuo, companion.m3318getPreviouseUduSuo())) {
            i = 7;
        } else if (ImeAction.m3300equalsimpl0(iM3329getImeActioneUduSuo, companion.m3319getSearcheUduSuo())) {
            i = 3;
        } else if (ImeAction.m3300equalsimpl0(iM3329getImeActioneUduSuo, companion.m3320getSendeUduSuo())) {
            i = 4;
        } else {
            if (!ImeAction.m3300equalsimpl0(iM3329getImeActioneUduSuo, companion.m3314getDoneeUduSuo())) {
                throw new IllegalStateException("invalid ImeAction");
            }
        }
        editorInfo.imeOptions = i;
        PlatformImeOptions platformImeOptions = imeOptions.getPlatformImeOptions();
        if (platformImeOptions != null && (privateImeOptions = platformImeOptions.getPrivateImeOptions()) != null) {
            editorInfo.privateImeOptions = privateImeOptions;
        }
        int iM3330getKeyboardTypePjHm6EE = imeOptions.m3330getKeyboardTypePjHm6EE();
        KeyboardType.Companion companion2 = KeyboardType.Companion;
        if (KeyboardType.m3353equalsimpl0(iM3330getKeyboardTypePjHm6EE, companion2.m3374getTextPjHm6EE())) {
            editorInfo.inputType = 1;
        } else if (KeyboardType.m3353equalsimpl0(iM3330getKeyboardTypePjHm6EE, companion2.m3367getAsciiPjHm6EE())) {
            editorInfo.inputType = 1;
            editorInfo.imeOptions |= Integer.MIN_VALUE;
        } else if (KeyboardType.m3353equalsimpl0(iM3330getKeyboardTypePjHm6EE, companion2.m3370getNumberPjHm6EE())) {
            editorInfo.inputType = 2;
        } else if (KeyboardType.m3353equalsimpl0(iM3330getKeyboardTypePjHm6EE, companion2.m3373getPhonePjHm6EE())) {
            editorInfo.inputType = 3;
        } else if (KeyboardType.m3353equalsimpl0(iM3330getKeyboardTypePjHm6EE, companion2.m3376getUriPjHm6EE())) {
            editorInfo.inputType = 17;
        } else if (KeyboardType.m3353equalsimpl0(iM3330getKeyboardTypePjHm6EE, companion2.m3369getEmailPjHm6EE())) {
            editorInfo.inputType = 33;
        } else if (KeyboardType.m3353equalsimpl0(iM3330getKeyboardTypePjHm6EE, companion2.m3372getPasswordPjHm6EE())) {
            editorInfo.inputType = 129;
        } else if (KeyboardType.m3353equalsimpl0(iM3330getKeyboardTypePjHm6EE, companion2.m3371getNumberPasswordPjHm6EE())) {
            editorInfo.inputType = 18;
        } else if (KeyboardType.m3353equalsimpl0(iM3330getKeyboardTypePjHm6EE, companion2.m3368getDecimalPjHm6EE())) {
            editorInfo.inputType = 8194;
        } else {
            throw new IllegalStateException("Invalid Keyboard Type");
        }
        if (!imeOptions.getSingleLine() && hasFlag(editorInfo.inputType, 1)) {
            editorInfo.inputType |= 131072;
            if (ImeAction.m3300equalsimpl0(imeOptions.m3329getImeActioneUduSuo(), companion.m3313getDefaulteUduSuo())) {
                editorInfo.imeOptions |= 1073741824;
            }
        }
        if (hasFlag(editorInfo.inputType, 1)) {
            int iM3328getCapitalizationIUNYP9k = imeOptions.m3328getCapitalizationIUNYP9k();
            KeyboardCapitalization.Companion companion3 = KeyboardCapitalization.Companion;
            if (KeyboardCapitalization.m3336equalsimpl0(iM3328getCapitalizationIUNYP9k, companion3.m3345getCharactersIUNYP9k())) {
                editorInfo.inputType |= 4096;
            } else if (KeyboardCapitalization.m3336equalsimpl0(iM3328getCapitalizationIUNYP9k, companion3.m3349getWordsIUNYP9k())) {
                editorInfo.inputType |= 8192;
            } else if (KeyboardCapitalization.m3336equalsimpl0(iM3328getCapitalizationIUNYP9k, companion3.m3347getSentencesIUNYP9k())) {
                editorInfo.inputType |= 16384;
            }
            if (imeOptions.getAutoCorrect()) {
                editorInfo.inputType |= 32768;
            }
        }
        editorInfo.initialSelStart = TextRange.m3135getStartimpl(textFieldValue.m3382getSelectiond9O1mEE());
        editorInfo.initialSelEnd = TextRange.m3130getEndimpl(textFieldValue.m3382getSelectiond9O1mEE());
        EditorInfoCompat.setInitialSurroundingText(editorInfo, textFieldValue.getText());
        editorInfo.imeOptions |= 33554432;
    }

    public static final Executor asExecutor(@NotNull final Choreographer choreographer) {
        return new Executor() { // from class: androidx.compose.ui.text.input.TextInputServiceAndroid_androidKt$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                TextInputServiceAndroid_androidKt.asExecutor$lambda$2(choreographer, runnable);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void asExecutor$lambda$2(Choreographer choreographer, final Runnable runnable) {
        choreographer.postFrameCallback(new Choreographer.FrameCallback() { // from class: androidx.compose.ui.text.input.TextInputServiceAndroid_androidKt$$ExternalSyntheticLambda0
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j) {
                runnable.run();
            }
        });
    }
}
