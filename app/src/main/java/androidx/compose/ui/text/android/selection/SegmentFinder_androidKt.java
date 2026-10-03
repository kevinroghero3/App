package androidx.compose.ui.text.android.selection;

import android.os.Build;
import android.text.TextPaint;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class SegmentFinder_androidKt {
    public static final SegmentFinder createGraphemeClusterSegmentFinder(@NotNull CharSequence charSequence, @NotNull TextPaint textPaint) {
        if (Build.VERSION.SDK_INT >= 29) {
            return new GraphemeClusterSegmentFinderApi29(charSequence, textPaint);
        }
        return new GraphemeClusterSegmentFinderUnderApi29(charSequence);
    }
}
