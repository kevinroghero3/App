package androidx.compose.ui.platform;

import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface PlatformTextInputMethodRequest {
    InputConnection createInputConnection(@NotNull EditorInfo editorInfo);
}
