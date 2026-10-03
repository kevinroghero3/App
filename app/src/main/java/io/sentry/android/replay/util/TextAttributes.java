package io.sentry.android.replay.util;

import androidx.compose.ui.graphics.Color;
import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class TextAttributes {
    public static final int $stable = 0;
    private final Color color;
    private final boolean hasFillModifier;

    public /* synthetic */ TextAttributes(Color color, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(color, z);
    }

    /* JADX INFO: renamed from: copy-fRWUv9g$default, reason: not valid java name */
    public static /* synthetic */ TextAttributes m5436copyfRWUv9g$default(TextAttributes textAttributes, Color color, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            color = textAttributes.color;
        }
        if ((i & 2) != 0) {
            z = textAttributes.hasFillModifier;
        }
        return textAttributes.m5438copyfRWUv9g(color, z);
    }

    /* JADX INFO: renamed from: component1-QN2ZGVo, reason: not valid java name */
    public final Color m5437component1QN2ZGVo() {
        return this.color;
    }

    public final boolean component2() {
        return this.hasFillModifier;
    }

    /* JADX INFO: renamed from: copy-fRWUv9g, reason: not valid java name */
    public final TextAttributes m5438copyfRWUv9g(@Nullable Color color, boolean z) {
        return new TextAttributes(color, z, null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextAttributes)) {
            return false;
        }
        TextAttributes textAttributes = (TextAttributes) obj;
        return Intrinsics.areEqual(this.color, textAttributes.color) && this.hasFillModifier == textAttributes.hasFillModifier;
    }

    public int hashCode() {
        Color color = this.color;
        return ((color == null ? 0 : Color.m1176hashCodeimpl(color.m1179unboximpl())) * 31) + Boolean.hashCode(this.hasFillModifier);
    }

    public String toString() {
        return "TextAttributes(color=" + this.color + ", hasFillModifier=" + this.hasFillModifier + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    private TextAttributes(Color color, boolean z) {
        this.color = color;
        this.hasFillModifier = z;
    }

    /* JADX INFO: renamed from: getColor-QN2ZGVo, reason: not valid java name */
    public final Color m5439getColorQN2ZGVo() {
        return this.color;
    }

    public final boolean getHasFillModifier() {
        return this.hasFillModifier;
    }
}
