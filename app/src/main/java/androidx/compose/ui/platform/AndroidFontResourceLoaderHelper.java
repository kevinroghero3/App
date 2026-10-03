package androidx.compose.ui.platform;

import android.content.Context;
import android.graphics.Typeface;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
final class AndroidFontResourceLoaderHelper {
    public static final AndroidFontResourceLoaderHelper INSTANCE = new AndroidFontResourceLoaderHelper();

    private AndroidFontResourceLoaderHelper() {
    }

    public final Typeface create(@NotNull Context context, int i) {
        return context.getResources().getFont(i);
    }
}
