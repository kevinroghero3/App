package androidx.compose.ui.text.platform;

import android.content.Context;
import android.graphics.Typeface;
import kotlin.Deprecated;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Deprecated(message = "Only used by deprecated APIs in this file, remove with them.")
final class AndroidResourceFontLoaderHelper {
    public static final AndroidResourceFontLoaderHelper INSTANCE = new AndroidResourceFontLoaderHelper();

    private AndroidResourceFontLoaderHelper() {
    }

    public final Typeface create(@NotNull Context context, int i) {
        return context.getResources().getFont(i);
    }
}
