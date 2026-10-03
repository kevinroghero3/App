package com.facebook.fresco.vito.options;

import java.util.Arrays;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class RoundingOptions {
    public static final float CORNER_RADIUS_UNSET = 0.0f;
    private final float[] cornerRadii;
    private final float cornerRadius;
    private final boolean isAntiAliased;
    private final boolean isCircular;
    private final boolean isForceRoundAtDecode;
    public static final Companion Companion = new Companion(null);
    private static final RoundingOptions AS_CIRCLE = new RoundingOptions(true, 0.0f, null, false, false);
    private static final RoundingOptions AS_CIRCLE_ANTI_ALIASING = new RoundingOptions(true, 0.0f, null, true, false);

    @JvmStatic
    public static final RoundingOptions asCircle() {
        return Companion.asCircle();
    }

    @JvmStatic
    public static final RoundingOptions asCircle(boolean z) {
        return Companion.asCircle(z);
    }

    @JvmStatic
    public static final RoundingOptions asCircle(boolean z, boolean z2) {
        return Companion.asCircle(z, z2);
    }

    public static /* synthetic */ RoundingOptions copy$default(RoundingOptions roundingOptions, boolean z, float f, float[] fArr, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = roundingOptions.isCircular;
        }
        if ((i & 2) != 0) {
            f = roundingOptions.cornerRadius;
        }
        float f2 = f;
        if ((i & 4) != 0) {
            fArr = roundingOptions.cornerRadii;
        }
        float[] fArr2 = fArr;
        if ((i & 8) != 0) {
            z2 = roundingOptions.isAntiAliased;
        }
        boolean z4 = z2;
        if ((i & 16) != 0) {
            z3 = roundingOptions.isForceRoundAtDecode;
        }
        return roundingOptions.copy(z, f2, fArr2, z4, z3);
    }

    @JvmStatic
    public static final RoundingOptions forCornerRadii(float f, float f2, float f3, float f4) {
        return Companion.forCornerRadii(f, f2, f3, f4);
    }

    @JvmStatic
    public static final RoundingOptions forCornerRadii(@NotNull float[] fArr) {
        return Companion.forCornerRadii(fArr);
    }

    @JvmStatic
    public static final RoundingOptions forCornerRadii(@NotNull float[] fArr, boolean z) {
        return Companion.forCornerRadii(fArr, z);
    }

    @JvmStatic
    public static final RoundingOptions forCornerRadiusPx(float f) {
        return Companion.forCornerRadiusPx(f);
    }

    public final boolean component1() {
        return this.isCircular;
    }

    public final float component2() {
        return this.cornerRadius;
    }

    public final float[] component3() {
        return this.cornerRadii;
    }

    public final boolean component4() {
        return this.isAntiAliased;
    }

    public final boolean component5() {
        return this.isForceRoundAtDecode;
    }

    public final RoundingOptions copy(boolean z, float f, @Nullable float[] fArr, boolean z2, boolean z3) {
        return new RoundingOptions(z, f, fArr, z2, z3);
    }

    public String toString() {
        return "RoundingOptions(isCircular=" + this.isCircular + ", cornerRadius=" + this.cornerRadius + ", cornerRadii=" + Arrays.toString(this.cornerRadii) + ", isAntiAliased=" + this.isAntiAliased + ", isForceRoundAtDecode=" + this.isForceRoundAtDecode + ")";
    }

    public RoundingOptions(boolean z, float f, @Nullable float[] fArr, boolean z2, boolean z3) {
        this.isCircular = z;
        this.cornerRadius = f;
        this.cornerRadii = fArr;
        this.isAntiAliased = z2;
        this.isForceRoundAtDecode = z3;
    }

    public final boolean isCircular() {
        return this.isCircular;
    }

    public final float getCornerRadius() {
        return this.cornerRadius;
    }

    public final float[] getCornerRadii() {
        return this.cornerRadii;
    }

    public final boolean isAntiAliased() {
        return this.isAntiAliased;
    }

    public final boolean isForceRoundAtDecode() {
        return this.isForceRoundAtDecode;
    }

    public final boolean hasRoundedCorners() {
        return (this.cornerRadius == 0.0f && this.cornerRadii == null) ? false : true;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(RoundingOptions.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.facebook.fresco.vito.options.RoundingOptions");
        RoundingOptions roundingOptions = (RoundingOptions) obj;
        return this.isCircular == roundingOptions.isCircular && this.cornerRadius == roundingOptions.cornerRadius && Arrays.equals(this.cornerRadii, roundingOptions.cornerRadii) && this.isAntiAliased == roundingOptions.isAntiAliased && this.isForceRoundAtDecode == roundingOptions.isForceRoundAtDecode;
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.isCircular);
        int iHashCode2 = Float.hashCode(this.cornerRadius);
        return (((((((iHashCode * 31) + iHashCode2) * 31) + Arrays.hashCode(this.cornerRadii)) * 31) + Boolean.hashCode(this.isAntiAliased)) * 31) + Boolean.hashCode(this.isForceRoundAtDecode);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final RoundingOptions forCornerRadii(@NotNull float[] cornerRadii) {
            Intrinsics.checkNotNullParameter(cornerRadii, "cornerRadii");
            return forCornerRadii$default(this, cornerRadii, false, 2, null);
        }

        private Companion() {
        }

        public final RoundingOptions getAS_CIRCLE() {
            return RoundingOptions.AS_CIRCLE;
        }

        public final RoundingOptions getAS_CIRCLE_ANTI_ALIASING() {
            return RoundingOptions.AS_CIRCLE_ANTI_ALIASING;
        }

        @JvmStatic
        public final RoundingOptions asCircle() {
            return getAS_CIRCLE();
        }

        @JvmStatic
        public final RoundingOptions asCircle(boolean z) {
            return z ? getAS_CIRCLE_ANTI_ALIASING() : getAS_CIRCLE();
        }

        @JvmStatic
        public final RoundingOptions asCircle(boolean z, boolean z2) {
            return new RoundingOptions(true, 0.0f, null, z, z2);
        }

        @JvmStatic
        public final RoundingOptions forCornerRadiusPx(float f) {
            return new RoundingOptions(false, f, null, false, false);
        }

        @JvmStatic
        public final RoundingOptions forCornerRadii(float f, float f2, float f3, float f4) {
            return new RoundingOptions(false, 0.0f, new float[]{f, f, f2, f2, f3, f3, f4, f4}, false, false);
        }

        public static /* synthetic */ RoundingOptions forCornerRadii$default(Companion companion, float[] fArr, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            return companion.forCornerRadii(fArr, z);
        }

        @JvmStatic
        public final RoundingOptions forCornerRadii(@NotNull float[] cornerRadii, boolean z) {
            Intrinsics.checkNotNullParameter(cornerRadii, "cornerRadii");
            return new RoundingOptions(false, 0.0f, cornerRadii, z, false);
        }
    }
}
