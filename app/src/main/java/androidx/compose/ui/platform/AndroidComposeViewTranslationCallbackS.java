package androidx.compose.ui.platform;

import android.view.View;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidComposeViewTranslationCallbackS {
    public static final int $stable = 0;
    public static final AndroidComposeViewTranslationCallbackS INSTANCE = new AndroidComposeViewTranslationCallbackS();

    private AndroidComposeViewTranslationCallbackS() {
    }

    public final void setViewTranslationCallback(@NotNull View view) {
        view.setViewTranslationCallback(AndroidComposeViewTranslationCallbackS$$ExternalSyntheticApiModelOutline0.m(AndroidComposeViewTranslationCallback.INSTANCE));
    }

    public final void clearViewTranslationCallback(@NotNull View view) {
        view.clearViewTranslationCallback();
    }
}
