package com.guhungry.photomanipulator.model;

import android.graphics.Paint;
import android.graphics.Typeface;
import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class TextStyle {
    private final Paint.Align alignment;
    private final int color;
    private final Typeface font;
    private final Float rotation;
    private final Integer shadowColor;
    private final float shadowOffsetX;
    private final float shadowOffsetY;
    private final float shadowRadius;
    private final float size;
    private final float thickness;

    public final int component1() {
        return this.color;
    }

    public final Integer component10() {
        return this.shadowColor;
    }

    public final float component2() {
        return this.size;
    }

    public final Typeface component3() {
        return this.font;
    }

    public final Paint.Align component4() {
        return this.alignment;
    }

    public final float component5() {
        return this.thickness;
    }

    public final Float component6() {
        return this.rotation;
    }

    public final float component7() {
        return this.shadowRadius;
    }

    public final float component8() {
        return this.shadowOffsetX;
    }

    public final float component9() {
        return this.shadowOffsetY;
    }

    public final TextStyle copy(int i, float f, @Nullable Typeface typeface, @NotNull Paint.Align alignment, float f2, @Nullable Float f3, float f4, float f5, float f6, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        return new TextStyle(i, f, typeface, alignment, f2, f3, f4, f5, f6, num);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextStyle)) {
            return false;
        }
        TextStyle textStyle = (TextStyle) obj;
        return this.color == textStyle.color && Float.compare(this.size, textStyle.size) == 0 && Intrinsics.areEqual(this.font, textStyle.font) && this.alignment == textStyle.alignment && Float.compare(this.thickness, textStyle.thickness) == 0 && Intrinsics.areEqual((Object) this.rotation, (Object) textStyle.rotation) && Float.compare(this.shadowRadius, textStyle.shadowRadius) == 0 && Float.compare(this.shadowOffsetX, textStyle.shadowOffsetX) == 0 && Float.compare(this.shadowOffsetY, textStyle.shadowOffsetY) == 0 && Intrinsics.areEqual(this.shadowColor, textStyle.shadowColor);
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.color);
        int iHashCode2 = Float.hashCode(this.size);
        Typeface typeface = this.font;
        int iHashCode3 = typeface == null ? 0 : typeface.hashCode();
        int iHashCode4 = this.alignment.hashCode();
        int iHashCode5 = Float.hashCode(this.thickness);
        Float f = this.rotation;
        int iHashCode6 = f == null ? 0 : f.hashCode();
        int iHashCode7 = Float.hashCode(this.shadowRadius);
        int iHashCode8 = Float.hashCode(this.shadowOffsetX);
        int iHashCode9 = Float.hashCode(this.shadowOffsetY);
        Integer num = this.shadowColor;
        return (((((((((((((((((iHashCode * 31) + iHashCode2) * 31) + iHashCode3) * 31) + iHashCode4) * 31) + iHashCode5) * 31) + iHashCode6) * 31) + iHashCode7) * 31) + iHashCode8) * 31) + iHashCode9) * 31) + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "TextStyle(color=" + this.color + ", size=" + this.size + ", font=" + this.font + ", alignment=" + this.alignment + ", thickness=" + this.thickness + ", rotation=" + this.rotation + ", shadowRadius=" + this.shadowRadius + ", shadowOffsetX=" + this.shadowOffsetX + ", shadowOffsetY=" + this.shadowOffsetY + ", shadowColor=" + this.shadowColor + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public TextStyle(int i, float f, @Nullable Typeface typeface, @NotNull Paint.Align alignment, float f2, @Nullable Float f3, float f4, float f5, float f6, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        this.color = i;
        this.size = f;
        this.font = typeface;
        this.alignment = alignment;
        this.thickness = f2;
        this.rotation = f3;
        this.shadowRadius = f4;
        this.shadowOffsetX = f5;
        this.shadowOffsetY = f6;
        this.shadowColor = num;
    }

    public final int getColor() {
        return this.color;
    }

    public final float getSize() {
        return this.size;
    }

    public final Typeface getFont() {
        return this.font;
    }

    public /* synthetic */ TextStyle(int i, float f, Typeface typeface, Paint.Align align, float f2, Float f3, float f4, float f5, float f6, Integer num, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, f, (i2 & 4) != 0 ? null : typeface, (i2 & 8) != 0 ? Paint.Align.LEFT : align, (i2 & 16) != 0 ? 0.0f : f2, (i2 & 32) != 0 ? null : f3, (i2 & 64) != 0 ? 0.0f : f4, (i2 & 128) != 0 ? 0.0f : f5, (i2 & 256) != 0 ? 0.0f : f6, (i2 & 512) != 0 ? null : num);
    }

    public final Paint.Align getAlignment() {
        return this.alignment;
    }

    public final float getThickness() {
        return this.thickness;
    }

    public final Float getRotation() {
        return this.rotation;
    }

    public final float getShadowRadius() {
        return this.shadowRadius;
    }

    public final float getShadowOffsetX() {
        return this.shadowOffsetX;
    }

    public final float getShadowOffsetY() {
        return this.shadowOffsetY;
    }

    public final Integer getShadowColor() {
        return this.shadowColor;
    }
}
