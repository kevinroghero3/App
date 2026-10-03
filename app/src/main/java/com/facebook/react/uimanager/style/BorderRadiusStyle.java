package com.facebook.react.uimanager.style;

import android.content.Context;
import com.facebook.react.modules.i18nmanager.I18nUtil;
import com.facebook.react.uimanager.LengthPercentage;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class BorderRadiusStyle {
    private LengthPercentage bottomEnd;
    private LengthPercentage bottomLeft;
    private LengthPercentage bottomRight;
    private LengthPercentage bottomStart;
    private LengthPercentage endEnd;
    private LengthPercentage endStart;
    private LengthPercentage startEnd;
    private LengthPercentage startStart;
    private LengthPercentage topEnd;
    private LengthPercentage topLeft;
    private LengthPercentage topRight;
    private LengthPercentage topStart;
    private LengthPercentage uniform;

    /* JADX INFO: loaded from: classes2.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BorderRadiusProp.values().length];
            try {
                iArr[BorderRadiusProp.BORDER_RADIUS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BorderRadiusProp.BORDER_TOP_LEFT_RADIUS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BorderRadiusProp.BORDER_TOP_RIGHT_RADIUS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[BorderRadiusProp.BORDER_BOTTOM_LEFT_RADIUS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[BorderRadiusProp.BORDER_BOTTOM_RIGHT_RADIUS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[BorderRadiusProp.BORDER_TOP_START_RADIUS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[BorderRadiusProp.BORDER_TOP_END_RADIUS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[BorderRadiusProp.BORDER_BOTTOM_START_RADIUS.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[BorderRadiusProp.BORDER_BOTTOM_END_RADIUS.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[BorderRadiusProp.BORDER_START_START_RADIUS.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[BorderRadiusProp.BORDER_START_END_RADIUS.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[BorderRadiusProp.BORDER_END_START_RADIUS.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[BorderRadiusProp.BORDER_END_END_RADIUS.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public BorderRadiusStyle() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, 8191, null);
    }

    public final LengthPercentage component1() {
        return this.uniform;
    }

    public final LengthPercentage component10() {
        return this.startStart;
    }

    public final LengthPercentage component11() {
        return this.startEnd;
    }

    public final LengthPercentage component12() {
        return this.endStart;
    }

    public final LengthPercentage component13() {
        return this.endEnd;
    }

    public final LengthPercentage component2() {
        return this.topLeft;
    }

    public final LengthPercentage component3() {
        return this.topRight;
    }

    public final LengthPercentage component4() {
        return this.bottomLeft;
    }

    public final LengthPercentage component5() {
        return this.bottomRight;
    }

    public final LengthPercentage component6() {
        return this.topStart;
    }

    public final LengthPercentage component7() {
        return this.topEnd;
    }

    public final LengthPercentage component8() {
        return this.bottomStart;
    }

    public final LengthPercentage component9() {
        return this.bottomEnd;
    }

    public final BorderRadiusStyle copy(@Nullable LengthPercentage lengthPercentage, @Nullable LengthPercentage lengthPercentage2, @Nullable LengthPercentage lengthPercentage3, @Nullable LengthPercentage lengthPercentage4, @Nullable LengthPercentage lengthPercentage5, @Nullable LengthPercentage lengthPercentage6, @Nullable LengthPercentage lengthPercentage7, @Nullable LengthPercentage lengthPercentage8, @Nullable LengthPercentage lengthPercentage9, @Nullable LengthPercentage lengthPercentage10, @Nullable LengthPercentage lengthPercentage11, @Nullable LengthPercentage lengthPercentage12, @Nullable LengthPercentage lengthPercentage13) {
        return new BorderRadiusStyle(lengthPercentage, lengthPercentage2, lengthPercentage3, lengthPercentage4, lengthPercentage5, lengthPercentage6, lengthPercentage7, lengthPercentage8, lengthPercentage9, lengthPercentage10, lengthPercentage11, lengthPercentage12, lengthPercentage13);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BorderRadiusStyle)) {
            return false;
        }
        BorderRadiusStyle borderRadiusStyle = (BorderRadiusStyle) obj;
        return Intrinsics.areEqual(this.uniform, borderRadiusStyle.uniform) && Intrinsics.areEqual(this.topLeft, borderRadiusStyle.topLeft) && Intrinsics.areEqual(this.topRight, borderRadiusStyle.topRight) && Intrinsics.areEqual(this.bottomLeft, borderRadiusStyle.bottomLeft) && Intrinsics.areEqual(this.bottomRight, borderRadiusStyle.bottomRight) && Intrinsics.areEqual(this.topStart, borderRadiusStyle.topStart) && Intrinsics.areEqual(this.topEnd, borderRadiusStyle.topEnd) && Intrinsics.areEqual(this.bottomStart, borderRadiusStyle.bottomStart) && Intrinsics.areEqual(this.bottomEnd, borderRadiusStyle.bottomEnd) && Intrinsics.areEqual(this.startStart, borderRadiusStyle.startStart) && Intrinsics.areEqual(this.startEnd, borderRadiusStyle.startEnd) && Intrinsics.areEqual(this.endStart, borderRadiusStyle.endStart) && Intrinsics.areEqual(this.endEnd, borderRadiusStyle.endEnd);
    }

    public int hashCode() {
        LengthPercentage lengthPercentage = this.uniform;
        int iHashCode = lengthPercentage == null ? 0 : lengthPercentage.hashCode();
        LengthPercentage lengthPercentage2 = this.topLeft;
        int iHashCode2 = lengthPercentage2 == null ? 0 : lengthPercentage2.hashCode();
        LengthPercentage lengthPercentage3 = this.topRight;
        int iHashCode3 = lengthPercentage3 == null ? 0 : lengthPercentage3.hashCode();
        LengthPercentage lengthPercentage4 = this.bottomLeft;
        int iHashCode4 = lengthPercentage4 == null ? 0 : lengthPercentage4.hashCode();
        LengthPercentage lengthPercentage5 = this.bottomRight;
        int iHashCode5 = lengthPercentage5 == null ? 0 : lengthPercentage5.hashCode();
        LengthPercentage lengthPercentage6 = this.topStart;
        int iHashCode6 = lengthPercentage6 == null ? 0 : lengthPercentage6.hashCode();
        LengthPercentage lengthPercentage7 = this.topEnd;
        int iHashCode7 = lengthPercentage7 == null ? 0 : lengthPercentage7.hashCode();
        LengthPercentage lengthPercentage8 = this.bottomStart;
        int iHashCode8 = lengthPercentage8 == null ? 0 : lengthPercentage8.hashCode();
        LengthPercentage lengthPercentage9 = this.bottomEnd;
        int iHashCode9 = lengthPercentage9 == null ? 0 : lengthPercentage9.hashCode();
        LengthPercentage lengthPercentage10 = this.startStart;
        int iHashCode10 = lengthPercentage10 == null ? 0 : lengthPercentage10.hashCode();
        LengthPercentage lengthPercentage11 = this.startEnd;
        int iHashCode11 = lengthPercentage11 == null ? 0 : lengthPercentage11.hashCode();
        LengthPercentage lengthPercentage12 = this.endStart;
        int iHashCode12 = lengthPercentage12 == null ? 0 : lengthPercentage12.hashCode();
        LengthPercentage lengthPercentage13 = this.endEnd;
        return (((((((((((((((((((((((iHashCode * 31) + iHashCode2) * 31) + iHashCode3) * 31) + iHashCode4) * 31) + iHashCode5) * 31) + iHashCode6) * 31) + iHashCode7) * 31) + iHashCode8) * 31) + iHashCode9) * 31) + iHashCode10) * 31) + iHashCode11) * 31) + iHashCode12) * 31) + (lengthPercentage13 != null ? lengthPercentage13.hashCode() : 0);
    }

    public String toString() {
        return "BorderRadiusStyle(uniform=" + this.uniform + ", topLeft=" + this.topLeft + ", topRight=" + this.topRight + ", bottomLeft=" + this.bottomLeft + ", bottomRight=" + this.bottomRight + ", topStart=" + this.topStart + ", topEnd=" + this.topEnd + ", bottomStart=" + this.bottomStart + ", bottomEnd=" + this.bottomEnd + ", startStart=" + this.startStart + ", startEnd=" + this.startEnd + ", endStart=" + this.endStart + ", endEnd=" + this.endEnd + ")";
    }

    public BorderRadiusStyle(@Nullable LengthPercentage lengthPercentage, @Nullable LengthPercentage lengthPercentage2, @Nullable LengthPercentage lengthPercentage3, @Nullable LengthPercentage lengthPercentage4, @Nullable LengthPercentage lengthPercentage5, @Nullable LengthPercentage lengthPercentage6, @Nullable LengthPercentage lengthPercentage7, @Nullable LengthPercentage lengthPercentage8, @Nullable LengthPercentage lengthPercentage9, @Nullable LengthPercentage lengthPercentage10, @Nullable LengthPercentage lengthPercentage11, @Nullable LengthPercentage lengthPercentage12, @Nullable LengthPercentage lengthPercentage13) {
        this.uniform = lengthPercentage;
        this.topLeft = lengthPercentage2;
        this.topRight = lengthPercentage3;
        this.bottomLeft = lengthPercentage4;
        this.bottomRight = lengthPercentage5;
        this.topStart = lengthPercentage6;
        this.topEnd = lengthPercentage7;
        this.bottomStart = lengthPercentage8;
        this.bottomEnd = lengthPercentage9;
        this.startStart = lengthPercentage10;
        this.startEnd = lengthPercentage11;
        this.endStart = lengthPercentage12;
        this.endEnd = lengthPercentage13;
    }

    public /* synthetic */ BorderRadiusStyle(LengthPercentage lengthPercentage, LengthPercentage lengthPercentage2, LengthPercentage lengthPercentage3, LengthPercentage lengthPercentage4, LengthPercentage lengthPercentage5, LengthPercentage lengthPercentage6, LengthPercentage lengthPercentage7, LengthPercentage lengthPercentage8, LengthPercentage lengthPercentage9, LengthPercentage lengthPercentage10, LengthPercentage lengthPercentage11, LengthPercentage lengthPercentage12, LengthPercentage lengthPercentage13, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : lengthPercentage, (i & 2) != 0 ? null : lengthPercentage2, (i & 4) != 0 ? null : lengthPercentage3, (i & 8) != 0 ? null : lengthPercentage4, (i & 16) != 0 ? null : lengthPercentage5, (i & 32) != 0 ? null : lengthPercentage6, (i & 64) != 0 ? null : lengthPercentage7, (i & 128) != 0 ? null : lengthPercentage8, (i & 256) != 0 ? null : lengthPercentage9, (i & 512) != 0 ? null : lengthPercentage10, (i & 1024) != 0 ? null : lengthPercentage11, (i & 2048) != 0 ? null : lengthPercentage12, (i & 4096) == 0 ? lengthPercentage13 : null);
    }

    public final LengthPercentage getUniform() {
        return this.uniform;
    }

    public final void setUniform(@Nullable LengthPercentage lengthPercentage) {
        this.uniform = lengthPercentage;
    }

    public final LengthPercentage getTopLeft() {
        return this.topLeft;
    }

    public final void setTopLeft(@Nullable LengthPercentage lengthPercentage) {
        this.topLeft = lengthPercentage;
    }

    public final LengthPercentage getTopRight() {
        return this.topRight;
    }

    public final void setTopRight(@Nullable LengthPercentage lengthPercentage) {
        this.topRight = lengthPercentage;
    }

    public final LengthPercentage getBottomLeft() {
        return this.bottomLeft;
    }

    public final void setBottomLeft(@Nullable LengthPercentage lengthPercentage) {
        this.bottomLeft = lengthPercentage;
    }

    public final LengthPercentage getBottomRight() {
        return this.bottomRight;
    }

    public final void setBottomRight(@Nullable LengthPercentage lengthPercentage) {
        this.bottomRight = lengthPercentage;
    }

    public final LengthPercentage getTopStart() {
        return this.topStart;
    }

    public final void setTopStart(@Nullable LengthPercentage lengthPercentage) {
        this.topStart = lengthPercentage;
    }

    public final LengthPercentage getTopEnd() {
        return this.topEnd;
    }

    public final void setTopEnd(@Nullable LengthPercentage lengthPercentage) {
        this.topEnd = lengthPercentage;
    }

    public final LengthPercentage getBottomStart() {
        return this.bottomStart;
    }

    public final void setBottomStart(@Nullable LengthPercentage lengthPercentage) {
        this.bottomStart = lengthPercentage;
    }

    public final LengthPercentage getBottomEnd() {
        return this.bottomEnd;
    }

    public final void setBottomEnd(@Nullable LengthPercentage lengthPercentage) {
        this.bottomEnd = lengthPercentage;
    }

    public final LengthPercentage getStartStart() {
        return this.startStart;
    }

    public final void setStartStart(@Nullable LengthPercentage lengthPercentage) {
        this.startStart = lengthPercentage;
    }

    public final LengthPercentage getStartEnd() {
        return this.startEnd;
    }

    public final void setStartEnd(@Nullable LengthPercentage lengthPercentage) {
        this.startEnd = lengthPercentage;
    }

    public final LengthPercentage getEndStart() {
        return this.endStart;
    }

    public final void setEndStart(@Nullable LengthPercentage lengthPercentage) {
        this.endStart = lengthPercentage;
    }

    public final LengthPercentage getEndEnd() {
        return this.endEnd;
    }

    public final void setEndEnd(@Nullable LengthPercentage lengthPercentage) {
        this.endEnd = lengthPercentage;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BorderRadiusStyle(@NotNull List<? extends Pair<? extends BorderRadiusProp, LengthPercentage>> properties) {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, 8191, null);
        Intrinsics.checkNotNullParameter(properties, "properties");
        Iterator<T> it2 = properties.iterator();
        while (it2.hasNext()) {
            Pair pair = (Pair) it2.next();
            set((BorderRadiusProp) pair.component1(), (LengthPercentage) pair.component2());
        }
    }

    public final void set(@NotNull BorderRadiusProp property, @Nullable LengthPercentage lengthPercentage) {
        Intrinsics.checkNotNullParameter(property, "property");
        switch (WhenMappings.$EnumSwitchMapping$0[property.ordinal()]) {
            case 1:
                this.uniform = lengthPercentage;
                return;
            case 2:
                this.topLeft = lengthPercentage;
                return;
            case 3:
                this.topRight = lengthPercentage;
                return;
            case 4:
                this.bottomLeft = lengthPercentage;
                return;
            case 5:
                this.bottomRight = lengthPercentage;
                return;
            case 6:
                this.topStart = lengthPercentage;
                return;
            case 7:
                this.topEnd = lengthPercentage;
                return;
            case 8:
                this.bottomStart = lengthPercentage;
                return;
            case 9:
                this.bottomEnd = lengthPercentage;
                return;
            case 10:
                this.startStart = lengthPercentage;
                return;
            case 11:
                this.startEnd = lengthPercentage;
                return;
            case 12:
                this.endStart = lengthPercentage;
                return;
            case 13:
                this.endEnd = lengthPercentage;
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final LengthPercentage get(@NotNull BorderRadiusProp property) {
        Intrinsics.checkNotNullParameter(property, "property");
        switch (WhenMappings.$EnumSwitchMapping$0[property.ordinal()]) {
            case 1:
                return this.uniform;
            case 2:
                return this.topLeft;
            case 3:
                return this.topRight;
            case 4:
                return this.bottomLeft;
            case 5:
                return this.bottomRight;
            case 6:
                return this.topStart;
            case 7:
                return this.topEnd;
            case 8:
                return this.bottomStart;
            case 9:
                return this.bottomEnd;
            case 10:
                return this.startStart;
            case 11:
                return this.startEnd;
            case 12:
                return this.endStart;
            case 13:
                return this.endEnd;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final boolean hasRoundedBorders() {
        return (this.uniform == null && this.topLeft == null && this.topRight == null && this.bottomLeft == null && this.bottomRight == null && this.topStart == null && this.topEnd == null && this.bottomStart == null && this.bottomEnd == null && this.startStart == null && this.startEnd == null && this.endStart == null && this.endEnd == null) ? false : true;
    }

    public final ComputedBorderRadius resolve(int i, @NotNull Context context, float f, float f2) {
        CornerRadii cornerRadiiResolve;
        CornerRadii cornerRadiiResolve2;
        CornerRadii cornerRadiiResolve3;
        CornerRadii cornerRadiiResolve4;
        CornerRadii cornerRadiiResolve5;
        CornerRadii cornerRadiiResolve6;
        CornerRadii cornerRadiiResolve7;
        CornerRadii cornerRadiiResolve8;
        CornerRadii cornerRadiiResolve9;
        CornerRadii cornerRadiiResolve10;
        CornerRadii cornerRadiiResolve11;
        CornerRadii cornerRadiiResolve12;
        Intrinsics.checkNotNullParameter(context, "context");
        CornerRadii cornerRadii = new CornerRadii(0.0f, 0.0f);
        if (i == 0) {
            LengthPercentage lengthPercentage = this.startStart;
            if (lengthPercentage == null && (lengthPercentage = this.topStart) == null && (lengthPercentage = this.topLeft) == null) {
                lengthPercentage = this.uniform;
            }
            CornerRadii cornerRadii2 = (lengthPercentage == null || (cornerRadiiResolve4 = lengthPercentage.resolve(f, f2)) == null) ? cornerRadii : cornerRadiiResolve4;
            LengthPercentage lengthPercentage2 = this.endStart;
            if (lengthPercentage2 == null && (lengthPercentage2 = this.topEnd) == null && (lengthPercentage2 = this.topRight) == null) {
                lengthPercentage2 = this.uniform;
            }
            CornerRadii cornerRadii3 = (lengthPercentage2 == null || (cornerRadiiResolve3 = lengthPercentage2.resolve(f, f2)) == null) ? cornerRadii : cornerRadiiResolve3;
            LengthPercentage lengthPercentage3 = this.startEnd;
            if (lengthPercentage3 == null && (lengthPercentage3 = this.bottomStart) == null && (lengthPercentage3 = this.bottomLeft) == null) {
                lengthPercentage3 = this.uniform;
            }
            CornerRadii cornerRadii4 = (lengthPercentage3 == null || (cornerRadiiResolve2 = lengthPercentage3.resolve(f, f2)) == null) ? cornerRadii : cornerRadiiResolve2;
            LengthPercentage lengthPercentage4 = this.endEnd;
            if (lengthPercentage4 == null && (lengthPercentage4 = this.bottomEnd) == null && (lengthPercentage4 = this.bottomRight) == null) {
                lengthPercentage4 = this.uniform;
            }
            return ensureNoOverlap(cornerRadii2, cornerRadii3, cornerRadii4, (lengthPercentage4 == null || (cornerRadiiResolve = lengthPercentage4.resolve(f, f2)) == null) ? cornerRadii : cornerRadiiResolve, f, f2);
        }
        if (i == 1) {
            if (I18nUtil.Companion.getInstance().doLeftAndRightSwapInRTL(context)) {
                LengthPercentage lengthPercentage5 = this.endStart;
                if (lengthPercentage5 == null && (lengthPercentage5 = this.topEnd) == null && (lengthPercentage5 = this.topRight) == null) {
                    lengthPercentage5 = this.uniform;
                }
                CornerRadii cornerRadii5 = (lengthPercentage5 == null || (cornerRadiiResolve12 = lengthPercentage5.resolve(f, f2)) == null) ? cornerRadii : cornerRadiiResolve12;
                LengthPercentage lengthPercentage6 = this.startStart;
                if (lengthPercentage6 == null && (lengthPercentage6 = this.topStart) == null && (lengthPercentage6 = this.topLeft) == null) {
                    lengthPercentage6 = this.uniform;
                }
                CornerRadii cornerRadii6 = (lengthPercentage6 == null || (cornerRadiiResolve11 = lengthPercentage6.resolve(f, f2)) == null) ? cornerRadii : cornerRadiiResolve11;
                LengthPercentage lengthPercentage7 = this.endEnd;
                if (lengthPercentage7 == null && (lengthPercentage7 = this.bottomEnd) == null && (lengthPercentage7 = this.bottomRight) == null) {
                    lengthPercentage7 = this.uniform;
                }
                CornerRadii cornerRadii7 = (lengthPercentage7 == null || (cornerRadiiResolve10 = lengthPercentage7.resolve(f, f2)) == null) ? cornerRadii : cornerRadiiResolve10;
                LengthPercentage lengthPercentage8 = this.startEnd;
                if (lengthPercentage8 == null && (lengthPercentage8 = this.bottomStart) == null && (lengthPercentage8 = this.bottomLeft) == null) {
                    lengthPercentage8 = this.uniform;
                }
                return ensureNoOverlap(cornerRadii5, cornerRadii6, cornerRadii7, (lengthPercentage8 == null || (cornerRadiiResolve9 = lengthPercentage8.resolve(f, f2)) == null) ? cornerRadii : cornerRadiiResolve9, f, f2);
            }
            LengthPercentage lengthPercentage9 = this.endStart;
            if (lengthPercentage9 == null && (lengthPercentage9 = this.topEnd) == null && (lengthPercentage9 = this.topLeft) == null) {
                lengthPercentage9 = this.uniform;
            }
            CornerRadii cornerRadii8 = (lengthPercentage9 == null || (cornerRadiiResolve8 = lengthPercentage9.resolve(f, f2)) == null) ? cornerRadii : cornerRadiiResolve8;
            LengthPercentage lengthPercentage10 = this.startStart;
            if (lengthPercentage10 == null && (lengthPercentage10 = this.topStart) == null && (lengthPercentage10 = this.topRight) == null) {
                lengthPercentage10 = this.uniform;
            }
            CornerRadii cornerRadii9 = (lengthPercentage10 == null || (cornerRadiiResolve7 = lengthPercentage10.resolve(f, f2)) == null) ? cornerRadii : cornerRadiiResolve7;
            LengthPercentage lengthPercentage11 = this.endEnd;
            if (lengthPercentage11 == null && (lengthPercentage11 = this.bottomStart) == null && (lengthPercentage11 = this.bottomLeft) == null) {
                lengthPercentage11 = this.uniform;
            }
            CornerRadii cornerRadii10 = (lengthPercentage11 == null || (cornerRadiiResolve6 = lengthPercentage11.resolve(f, f2)) == null) ? cornerRadii : cornerRadiiResolve6;
            LengthPercentage lengthPercentage12 = this.startEnd;
            if (lengthPercentage12 == null && (lengthPercentage12 = this.bottomEnd) == null && (lengthPercentage12 = this.bottomRight) == null) {
                lengthPercentage12 = this.uniform;
            }
            return ensureNoOverlap(cornerRadii8, cornerRadii9, cornerRadii10, (lengthPercentage12 == null || (cornerRadiiResolve5 = lengthPercentage12.resolve(f, f2)) == null) ? cornerRadii : cornerRadiiResolve5, f, f2);
        }
        throw new IllegalArgumentException("Expected?.resolved layout direction");
    }

    private final ComputedBorderRadius ensureNoOverlap(CornerRadii cornerRadii, CornerRadii cornerRadii2, CornerRadii cornerRadii3, CornerRadii cornerRadii4, float f, float f2) {
        float vertical = cornerRadii.getVertical() + cornerRadii3.getVertical();
        float horizontal = cornerRadii.getHorizontal() + cornerRadii2.getHorizontal();
        float vertical2 = cornerRadii2.getVertical() + cornerRadii4.getVertical();
        float horizontal2 = cornerRadii3.getHorizontal() + cornerRadii4.getHorizontal();
        float fMin = vertical > 0.0f ? Math.min(f2 / vertical, 1.0f) : 0.0f;
        float fMin2 = horizontal > 0.0f ? Math.min(f / horizontal, 1.0f) : 0.0f;
        float fMin3 = vertical2 > 0.0f ? Math.min(f2 / vertical2, 1.0f) : 0.0f;
        float fMin4 = horizontal2 > 0.0f ? Math.min(f / horizontal2, 1.0f) : 0.0f;
        return new ComputedBorderRadius(new CornerRadii(cornerRadii.getHorizontal() * Math.min(fMin2, fMin), cornerRadii.getVertical() * Math.min(fMin2, fMin)), new CornerRadii(cornerRadii2.getHorizontal() * Math.min(fMin3, fMin2), cornerRadii2.getVertical() * Math.min(fMin3, fMin2)), new CornerRadii(cornerRadii3.getHorizontal() * Math.min(fMin4, fMin), cornerRadii3.getVertical() * Math.min(fMin4, fMin)), new CornerRadii(cornerRadii4.getHorizontal() * Math.min(fMin4, fMin3), cornerRadii4.getVertical() * Math.min(fMin4, fMin3)));
    }
}
