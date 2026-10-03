package androidx.compose.ui.text.android;

import android.graphics.Paint;
import android.graphics.Rect;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
final class Paint29 {
    public static final Paint29 INSTANCE = new Paint29();

    private Paint29() {
    }

    @JvmStatic
    public static final void getTextBounds(@NotNull Paint paint, @NotNull CharSequence charSequence, int i, int i2, @NotNull Rect rect) {
        paint.getTextBounds(charSequence, i, i2, rect);
    }
}
