package androidx.compose.ui.text.font;

import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface PlatformFontLoader {
    Object awaitLoad(@NotNull Font font, @NotNull Continuation<Object> continuation);

    Object getCacheKey();

    Object loadBlocking(@NotNull Font font);
}
