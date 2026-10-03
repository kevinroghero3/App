package androidx.compose.ui.platform;

import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface PlatformTextInputInterceptor {
    Object interceptStartInputMethod(@NotNull PlatformTextInputMethodRequest platformTextInputMethodRequest, @NotNull PlatformTextInputSession platformTextInputSession, @NotNull Continuation<?> continuation);
}
