package com.facebook.react.views.text;

import android.text.Spannable;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class ReactTextUpdate {
    public static final Companion Companion = new Companion(null);
    private final boolean containsImages;
    private final int jsEventCounter;
    private final int justificationMode;
    private final float paddingBottom;
    private final float paddingLeft;
    private final float paddingRight;
    private final float paddingTop;
    private final Spannable text;
    private final int textAlign;
    private final int textBreakStrategy;

    @JvmStatic
    public static final ReactTextUpdate buildReactTextUpdateFromState(@NotNull Spannable spannable, int i, int i2, int i3, int i4) {
        return Companion.buildReactTextUpdateFromState(spannable, i, i2, i3, i4);
    }

    public ReactTextUpdate(@NotNull Spannable text, int i, boolean z, float f, float f2, float f3, float f4, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.text = text;
        this.jsEventCounter = i;
        this.containsImages = z;
        this.paddingLeft = f;
        this.paddingTop = f2;
        this.paddingRight = f3;
        this.paddingBottom = f4;
        this.textAlign = i2;
        this.textBreakStrategy = i3;
        this.justificationMode = i4;
    }

    public final Spannable getText() {
        return this.text;
    }

    public final int getJsEventCounter() {
        return this.jsEventCounter;
    }

    public final boolean getContainsImages() {
        return this.containsImages;
    }

    public final float getPaddingLeft() {
        return this.paddingLeft;
    }

    public final float getPaddingTop() {
        return this.paddingTop;
    }

    public final float getPaddingRight() {
        return this.paddingRight;
    }

    public final float getPaddingBottom() {
        return this.paddingBottom;
    }

    public final int getTextAlign() {
        return this.textAlign;
    }

    public final int getTextBreakStrategy() {
        return this.textBreakStrategy;
    }

    public final int getJustificationMode() {
        return this.justificationMode;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ReactTextUpdate(@NotNull Spannable text, int i, boolean z, float f, float f2, float f3, float f4, int i2) {
        this(text, i, z, f, f2, f3, f4, i2, 1, 0);
        Intrinsics.checkNotNullParameter(text, "text");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ReactTextUpdate(@NotNull Spannable text, int i, boolean z, int i2, int i3, int i4) {
        this(text, i, z, -1.0f, -1.0f, -1.0f, -1.0f, i2, i3, i4);
        Intrinsics.checkNotNullParameter(text, "text");
    }

    @Deprecated(message = "This is just for backwards compatibility and will be removed some time in the future", replaceWith = @ReplaceWith(expression = "containsImages", imports = {}))
    public final boolean containsImages() {
        return this.containsImages;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ReactTextUpdate buildReactTextUpdateFromState(@NotNull Spannable text, int i, int i2, int i3, int i4) {
            Intrinsics.checkNotNullParameter(text, "text");
            return new ReactTextUpdate(text, i, false, i2, i3, i4);
        }
    }
}
