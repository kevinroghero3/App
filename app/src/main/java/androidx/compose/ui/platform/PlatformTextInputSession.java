package androidx.compose.ui.platform;

import android.view.View;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface PlatformTextInputSession {
    View getView();

    Object startInputMethod(@NotNull PlatformTextInputMethodRequest platformTextInputMethodRequest, @NotNull Continuation<?> continuation);
}
