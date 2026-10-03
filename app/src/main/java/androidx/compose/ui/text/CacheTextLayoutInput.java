package androidx.compose.ui.text;

import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class CacheTextLayoutInput {
    public static final int $stable = 0;
    private final TextLayoutInput textLayoutInput;

    public CacheTextLayoutInput(@NotNull TextLayoutInput textLayoutInput) {
        this.textLayoutInput = textLayoutInput;
    }

    public final TextLayoutInput getTextLayoutInput() {
        return this.textLayoutInput;
    }

    public int hashCode() {
        TextLayoutInput textLayoutInput = this.textLayoutInput;
        int iHashCode = textLayoutInput.getText().hashCode();
        int iHashCodeLayoutAffectingAttributes$ui_text_release = textLayoutInput.getStyle().hashCodeLayoutAffectingAttributes$ui_text_release();
        int iHashCode2 = textLayoutInput.getPlaceholders().hashCode();
        int maxLines = textLayoutInput.getMaxLines();
        int iHashCode3 = Boolean.hashCode(textLayoutInput.getSoftWrap());
        int iM3582hashCodeimpl = TextOverflow.m3582hashCodeimpl(textLayoutInput.m3104getOverflowgIe3tQ8());
        int iHashCode4 = textLayoutInput.getDensity().hashCode();
        int iHashCode5 = textLayoutInput.getLayoutDirection().hashCode();
        return (((((((((((((((((((iHashCode * 31) + iHashCodeLayoutAffectingAttributes$ui_text_release) * 31) + iHashCode2) * 31) + maxLines) * 31) + iHashCode3) * 31) + iM3582hashCodeimpl) * 31) + iHashCode4) * 31) + iHashCode5) * 31) + textLayoutInput.getFontFamilyResolver().hashCode()) * 31) + Integer.hashCode(Constraints.m3603getMaxWidthimpl(textLayoutInput.m3103getConstraintsmsEJaDk()))) * 31) + Integer.hashCode(Constraints.m3602getMaxHeightimpl(textLayoutInput.m3103getConstraintsmsEJaDk()));
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CacheTextLayoutInput)) {
            return false;
        }
        TextLayoutInput textLayoutInput = this.textLayoutInput;
        CacheTextLayoutInput cacheTextLayoutInput = (CacheTextLayoutInput) obj;
        return Intrinsics.areEqual(textLayoutInput.getText(), cacheTextLayoutInput.textLayoutInput.getText()) && textLayoutInput.getStyle().hasSameLayoutAffectingAttributes(cacheTextLayoutInput.textLayoutInput.getStyle()) && Intrinsics.areEqual(textLayoutInput.getPlaceholders(), cacheTextLayoutInput.textLayoutInput.getPlaceholders()) && textLayoutInput.getMaxLines() == cacheTextLayoutInput.textLayoutInput.getMaxLines() && textLayoutInput.getSoftWrap() == cacheTextLayoutInput.textLayoutInput.getSoftWrap() && TextOverflow.m3581equalsimpl0(textLayoutInput.m3104getOverflowgIe3tQ8(), cacheTextLayoutInput.textLayoutInput.m3104getOverflowgIe3tQ8()) && Intrinsics.areEqual(textLayoutInput.getDensity(), cacheTextLayoutInput.textLayoutInput.getDensity()) && textLayoutInput.getLayoutDirection() == cacheTextLayoutInput.textLayoutInput.getLayoutDirection() && textLayoutInput.getFontFamilyResolver() == cacheTextLayoutInput.textLayoutInput.getFontFamilyResolver() && Constraints.m3603getMaxWidthimpl(textLayoutInput.m3103getConstraintsmsEJaDk()) == Constraints.m3603getMaxWidthimpl(cacheTextLayoutInput.textLayoutInput.m3103getConstraintsmsEJaDk()) && Constraints.m3602getMaxHeightimpl(textLayoutInput.m3103getConstraintsmsEJaDk()) == Constraints.m3602getMaxHeightimpl(cacheTextLayoutInput.textLayoutInput.m3103getConstraintsmsEJaDk());
    }
}
