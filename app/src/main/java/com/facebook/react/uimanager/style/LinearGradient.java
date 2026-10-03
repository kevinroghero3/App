package com.facebook.react.uimanager.style;

import android.graphics.Shader;
import com.BV.LinearGradient.LinearGradientManager;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.react.bridge.ReadableMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class LinearGradient {
    private final int[] colors;
    private final Direction direction;
    private final float[] positions;

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Direction.Keywords.values().length];
            try {
                iArr[Direction.Keywords.TO_TOP_RIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Direction.Keywords.TO_BOTTOM_RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Direction.Keywords.TO_TOP_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Direction.Keywords.TO_BOTTOM_LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public LinearGradient(@NotNull ReadableMap directionMap, @NotNull int[] colors, @NotNull float[] positions) {
        Direction.Keywords keywords;
        Direction keyword;
        Intrinsics.checkNotNullParameter(directionMap, "directionMap");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(positions, "positions");
        this.colors = colors;
        this.positions = positions;
        String string = directionMap.getString("type");
        if (!Intrinsics.areEqual(string, LinearGradientManager.PROP_ANGLE)) {
            if (!Intrinsics.areEqual(string, "keyword")) {
                throw new IllegalArgumentException("Invalid direction type: " + string);
            }
            String string2 = directionMap.getString("value");
            if (string2 != null) {
                switch (string2.hashCode()) {
                    case -1849920841:
                        if (string2.equals("to bottom left")) {
                            keywords = Direction.Keywords.TO_BOTTOM_LEFT;
                            keyword = new Direction.Keyword(keywords);
                        }
                        break;
                    case -1507310228:
                        if (string2.equals("to bottom right")) {
                            keywords = Direction.Keywords.TO_BOTTOM_RIGHT;
                            keyword = new Direction.Keyword(keywords);
                        }
                        break;
                    case -1359525897:
                        if (string2.equals("to top left")) {
                            keywords = Direction.Keywords.TO_TOP_LEFT;
                            keyword = new Direction.Keyword(keywords);
                        }
                        break;
                    case 810031148:
                        if (string2.equals("to top right")) {
                            keywords = Direction.Keywords.TO_TOP_RIGHT;
                            keyword = new Direction.Keyword(keywords);
                        }
                        break;
                }
            }
            throw new IllegalArgumentException("Invalid linear gradient direction keyword: " + directionMap.getString("value"));
        }
        keyword = new Direction.Angle(directionMap.getDouble("value"));
        this.direction = keyword;
    }

    static abstract class Direction {

        public enum Keywords {
            TO_TOP_RIGHT,
            TO_BOTTOM_RIGHT,
            TO_TOP_LEFT,
            TO_BOTTOM_LEFT;

            private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

            public static EnumEntries<Keywords> getEntries() {
                return $ENTRIES;
            }
        }

        public /* synthetic */ Direction(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static final class Angle extends Direction {
            private final double value;

            public static /* synthetic */ Angle copy$default(Angle angle, double d, int i, Object obj) {
                if ((i & 1) != 0) {
                    d = angle.value;
                }
                return angle.copy(d);
            }

            public final double component1() {
                return this.value;
            }

            public final Angle copy(double d) {
                return new Angle(d);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Angle) && Double.compare(this.value, ((Angle) obj).value) == 0;
            }

            public int hashCode() {
                return Double.hashCode(this.value);
            }

            public String toString() {
                return "Angle(value=" + this.value + ")";
            }

            public Angle(double d) {
                super(null);
                this.value = d;
            }

            public final double getValue() {
                return this.value;
            }
        }

        private Direction() {
        }

        public static final class Keyword extends Direction {
            private final Keywords value;

            public static /* synthetic */ Keyword copy$default(Keyword keyword, Keywords keywords, int i, Object obj) {
                if ((i & 1) != 0) {
                    keywords = keyword.value;
                }
                return keyword.copy(keywords);
            }

            public final Keywords component1() {
                return this.value;
            }

            public final Keyword copy(@NotNull Keywords value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return new Keyword(value);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Keyword) && this.value == ((Keyword) obj).value;
            }

            public int hashCode() {
                return this.value.hashCode();
            }

            public String toString() {
                return "Keyword(value=" + this.value + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Keyword(@NotNull Keywords value) {
                super(null);
                Intrinsics.checkNotNullParameter(value, "value");
                this.value = value;
            }

            public final Keywords getValue() {
                return this.value;
            }
        }
    }

    public final Shader getShader(float f, float f2) {
        double angleForKeyword;
        Direction direction = this.direction;
        if (direction instanceof Direction.Angle) {
            angleForKeyword = ((Direction.Angle) direction).getValue();
        } else {
            if (!(direction instanceof Direction.Keyword)) {
                throw new NoWhenBranchMatchedException();
            }
            angleForKeyword = getAngleForKeyword(((Direction.Keyword) direction).getValue(), f, f2);
        }
        Pair<float[], float[]> pairEndPointsFromAngle = endPointsFromAngle(angleForKeyword, f2, f);
        float[] fArrComponent1 = pairEndPointsFromAngle.component1();
        float[] fArrComponent2 = pairEndPointsFromAngle.component2();
        return new android.graphics.LinearGradient(fArrComponent1[0], fArrComponent1[1], fArrComponent2[0], fArrComponent2[1], this.colors, this.positions, Shader.TileMode.CLAMP);
    }

    private final double getAngleForKeyword(Direction.Keywords keywords, double d, double d2) {
        double degrees;
        double d3;
        int i;
        int i2 = WhenMappings.$EnumSwitchMapping$0[keywords.ordinal()];
        if (i2 == 1) {
            return ((double) 90) - Math.toDegrees(Math.atan(d / d2));
        }
        if (i2 != 2) {
            if (i2 == 3) {
                degrees = Math.toDegrees(Math.atan(d / d2));
                i = RotationOptions.ROTATE_270;
            } else {
                if (i2 != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                degrees = Math.toDegrees(Math.atan(d2 / d));
                i = RotationOptions.ROTATE_180;
            }
            d3 = i;
        } else {
            degrees = Math.toDegrees(Math.atan(d / d2));
            d3 = 90;
        }
        return degrees + d3;
    }

    private final Pair<float[], float[]> endPointsFromAngle(double d, float f, float f2) {
        float[] fArr;
        float[] fArr2;
        double d2 = 360;
        double d3 = d % d2;
        if (d3 < 0.0d) {
            d3 += d2;
        }
        if (d3 == 0.0d) {
            return new Pair<>(new float[]{0.0f, f}, new float[]{0.0f, 0.0f});
        }
        if (d3 == 90.0d) {
            return new Pair<>(new float[]{0.0f, 0.0f}, new float[]{f2, 0.0f});
        }
        if (d3 == 180.0d) {
            return new Pair<>(new float[]{0.0f, 0.0f}, new float[]{0.0f, f});
        }
        if (d3 == 270.0d) {
            return new Pair<>(new float[]{f2, 0.0f}, new float[]{0.0f, 0.0f});
        }
        float fTan = (float) Math.tan(Math.toRadians(((double) 90) - d3));
        float f3 = (-1) / fTan;
        float f4 = 2;
        float f5 = f / f4;
        float f6 = f2 / f4;
        if (d3 < 90.0d) {
            fArr2 = new float[]{f6, f5};
        } else {
            if (d3 < 180.0d) {
                fArr = new float[]{f6, -f5};
            } else if (d3 < 270.0d) {
                fArr2 = new float[]{-f6, -f5};
            } else {
                fArr = new float[]{-f6, f5};
            }
            fArr2 = fArr;
        }
        float f7 = fArr2[1] - (fArr2[0] * f3);
        float f8 = f7 / (fTan - f3);
        float f9 = (f3 * f8) + f7;
        return new Pair<>(new float[]{f6 - f8, f5 + f9}, new float[]{f6 + f8, f5 - f9});
    }
}
