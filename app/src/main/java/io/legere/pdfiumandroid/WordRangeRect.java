package io.legere.pdfiumandroid;

import android.graphics.RectF;
import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class WordRangeRect {
    private final int rangeLength;
    private final int rangeStart;
    private final RectF rect;

    public static /* synthetic */ WordRangeRect copy$default(WordRangeRect wordRangeRect, int i, int i2, RectF rectF, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = wordRangeRect.rangeStart;
        }
        if ((i3 & 2) != 0) {
            i2 = wordRangeRect.rangeLength;
        }
        if ((i3 & 4) != 0) {
            rectF = wordRangeRect.rect;
        }
        return wordRangeRect.copy(i, i2, rectF);
    }

    public final int component1() {
        return this.rangeStart;
    }

    public final int component2() {
        return this.rangeLength;
    }

    public final RectF component3() {
        return this.rect;
    }

    public final WordRangeRect copy(int i, int i2, @NotNull RectF rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        return new WordRangeRect(i, i2, rect);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WordRangeRect)) {
            return false;
        }
        WordRangeRect wordRangeRect = (WordRangeRect) obj;
        return this.rangeStart == wordRangeRect.rangeStart && this.rangeLength == wordRangeRect.rangeLength && Intrinsics.areEqual(this.rect, wordRangeRect.rect);
    }

    public int hashCode() {
        return (((Integer.hashCode(this.rangeStart) * 31) + Integer.hashCode(this.rangeLength)) * 31) + this.rect.hashCode();
    }

    public String toString() {
        return "WordRangeRect(rangeStart=" + this.rangeStart + ", rangeLength=" + this.rangeLength + ", rect=" + this.rect + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public WordRangeRect(int i, int i2, @NotNull RectF rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        this.rangeStart = i;
        this.rangeLength = i2;
        this.rect = rect;
    }

    public final int getRangeStart() {
        return this.rangeStart;
    }

    public final int getRangeLength() {
        return this.rangeLength;
    }

    public final RectF getRect() {
        return this.rect;
    }
}
