package androidx.compose.ui.text;

import androidx.compose.ui.text.caches.LruCache;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class TextLayoutCache {
    public static final int $stable = 8;
    private final LruCache<CacheTextLayoutInput, TextLayoutResult> lruCache;

    public TextLayoutCache() {
        this(0, 1, null);
    }

    public TextLayoutCache(int i) {
        this.lruCache = new LruCache<>(i);
    }

    public /* synthetic */ TextLayoutCache(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? TextMeasurerKt.DefaultCacheSize : i);
    }

    public final TextLayoutResult get(@NotNull TextLayoutInput textLayoutInput) {
        TextLayoutResult textLayoutResult = this.lruCache.get(new CacheTextLayoutInput(textLayoutInput));
        if (textLayoutResult == null || textLayoutResult.getMultiParagraph().getIntrinsics().getHasStaleResolvedFonts()) {
            return null;
        }
        return textLayoutResult;
    }

    public final TextLayoutResult put(@NotNull TextLayoutInput textLayoutInput, @NotNull TextLayoutResult textLayoutResult) {
        return this.lruCache.put(new CacheTextLayoutInput(textLayoutInput), textLayoutResult);
    }

    public final TextLayoutResult remove(@NotNull TextLayoutInput textLayoutInput) {
        return this.lruCache.remove(new CacheTextLayoutInput(textLayoutInput));
    }
}
