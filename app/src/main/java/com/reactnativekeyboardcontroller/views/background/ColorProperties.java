package com.reactnativekeyboardcontroller.views.background;

import androidx.annotation.ColorInt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class ColorProperties {
    private final int color;
    private final int tone;

    public static /* synthetic */ ColorProperties copy$default(ColorProperties colorProperties, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = colorProperties.color;
        }
        if ((i3 & 2) != 0) {
            i2 = colorProperties.tone;
        }
        return colorProperties.copy(i, i2);
    }

    public final int component1() {
        return this.color;
    }

    public final int component2() {
        return this.tone;
    }

    public final ColorProperties copy(@ColorInt int i, int i2) {
        return new ColorProperties(i, i2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ColorProperties)) {
            return false;
        }
        ColorProperties colorProperties = (ColorProperties) obj;
        return this.color == colorProperties.color && this.tone == colorProperties.tone;
    }

    public int hashCode() {
        return (Integer.hashCode(this.color) * 31) + Integer.hashCode(this.tone);
    }

    public String toString() {
        return "ColorProperties(color=" + this.color + ", tone=" + this.tone + ")";
    }

    public ColorProperties(@ColorInt int i, int i2) {
        this.color = i;
        this.tone = i2;
    }

    public /* synthetic */ ColorProperties(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i3 & 2) != 0 ? 0 : i2);
    }

    public final int getColor() {
        return this.color;
    }

    public final int getTone() {
        return this.tone;
    }

    public final int getBlend() {
        return SkinsKt.shiftRgbChannels(this.color, this.tone);
    }
}
