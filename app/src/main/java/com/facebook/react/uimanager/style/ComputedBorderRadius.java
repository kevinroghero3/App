package com.facebook.react.uimanager.style;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class ComputedBorderRadius {
    private final CornerRadii bottomLeft;
    private final CornerRadii bottomRight;
    private final CornerRadii topLeft;
    private final CornerRadii topRight;

    /* JADX INFO: loaded from: classes4.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ComputedBorderRadiusProp.values().length];
            try {
                iArr[ComputedBorderRadiusProp.COMPUTED_BORDER_TOP_LEFT_RADIUS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ComputedBorderRadiusProp.COMPUTED_BORDER_TOP_RIGHT_RADIUS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ComputedBorderRadiusProp.COMPUTED_BORDER_BOTTOM_LEFT_RADIUS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ComputedBorderRadiusProp.COMPUTED_BORDER_BOTTOM_RIGHT_RADIUS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ ComputedBorderRadius copy$default(ComputedBorderRadius computedBorderRadius, CornerRadii cornerRadii, CornerRadii cornerRadii2, CornerRadii cornerRadii3, CornerRadii cornerRadii4, int i, Object obj) {
        if ((i & 1) != 0) {
            cornerRadii = computedBorderRadius.topLeft;
        }
        if ((i & 2) != 0) {
            cornerRadii2 = computedBorderRadius.topRight;
        }
        if ((i & 4) != 0) {
            cornerRadii3 = computedBorderRadius.bottomLeft;
        }
        if ((i & 8) != 0) {
            cornerRadii4 = computedBorderRadius.bottomRight;
        }
        return computedBorderRadius.copy(cornerRadii, cornerRadii2, cornerRadii3, cornerRadii4);
    }

    public final CornerRadii component1() {
        return this.topLeft;
    }

    public final CornerRadii component2() {
        return this.topRight;
    }

    public final CornerRadii component3() {
        return this.bottomLeft;
    }

    public final CornerRadii component4() {
        return this.bottomRight;
    }

    public final ComputedBorderRadius copy(@NotNull CornerRadii topLeft, @NotNull CornerRadii topRight, @NotNull CornerRadii bottomLeft, @NotNull CornerRadii bottomRight) {
        Intrinsics.checkNotNullParameter(topLeft, "topLeft");
        Intrinsics.checkNotNullParameter(topRight, "topRight");
        Intrinsics.checkNotNullParameter(bottomLeft, "bottomLeft");
        Intrinsics.checkNotNullParameter(bottomRight, "bottomRight");
        return new ComputedBorderRadius(topLeft, topRight, bottomLeft, bottomRight);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ComputedBorderRadius)) {
            return false;
        }
        ComputedBorderRadius computedBorderRadius = (ComputedBorderRadius) obj;
        return Intrinsics.areEqual(this.topLeft, computedBorderRadius.topLeft) && Intrinsics.areEqual(this.topRight, computedBorderRadius.topRight) && Intrinsics.areEqual(this.bottomLeft, computedBorderRadius.bottomLeft) && Intrinsics.areEqual(this.bottomRight, computedBorderRadius.bottomRight);
    }

    public int hashCode() {
        return (((((this.topLeft.hashCode() * 31) + this.topRight.hashCode()) * 31) + this.bottomLeft.hashCode()) * 31) + this.bottomRight.hashCode();
    }

    public String toString() {
        return "ComputedBorderRadius(topLeft=" + this.topLeft + ", topRight=" + this.topRight + ", bottomLeft=" + this.bottomLeft + ", bottomRight=" + this.bottomRight + ")";
    }

    public ComputedBorderRadius(@NotNull CornerRadii topLeft, @NotNull CornerRadii topRight, @NotNull CornerRadii bottomLeft, @NotNull CornerRadii bottomRight) {
        Intrinsics.checkNotNullParameter(topLeft, "topLeft");
        Intrinsics.checkNotNullParameter(topRight, "topRight");
        Intrinsics.checkNotNullParameter(bottomLeft, "bottomLeft");
        Intrinsics.checkNotNullParameter(bottomRight, "bottomRight");
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }

    public final CornerRadii getTopLeft() {
        return this.topLeft;
    }

    public final CornerRadii getTopRight() {
        return this.topRight;
    }

    public final CornerRadii getBottomLeft() {
        return this.bottomLeft;
    }

    public final CornerRadii getBottomRight() {
        return this.bottomRight;
    }

    public final boolean hasRoundedBorders() {
        return this.topLeft.getHorizontal() > 0.0f || this.topLeft.getVertical() > 0.0f || this.topRight.getHorizontal() > 0.0f || this.topRight.getVertical() > 0.0f || this.bottomLeft.getHorizontal() > 0.0f || this.bottomLeft.getVertical() > 0.0f || this.bottomRight.getHorizontal() > 0.0f;
    }

    public final boolean isUniform() {
        return Intrinsics.areEqual(this.topLeft, this.topRight) && Intrinsics.areEqual(this.topLeft, this.bottomLeft) && Intrinsics.areEqual(this.topLeft, this.bottomRight);
    }

    public final CornerRadii get(@NotNull ComputedBorderRadiusProp property) {
        Intrinsics.checkNotNullParameter(property, "property");
        int i = WhenMappings.$EnumSwitchMapping$0[property.ordinal()];
        if (i == 1) {
            return this.topLeft;
        }
        if (i == 2) {
            return this.topRight;
        }
        if (i == 3) {
            return this.bottomLeft;
        }
        if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
        return this.bottomRight;
    }

    public ComputedBorderRadius() {
        this(new CornerRadii(0.0f, 0.0f), new CornerRadii(0.0f, 0.0f), new CornerRadii(0.0f, 0.0f), new CornerRadii(0.0f, 0.0f));
    }
}
