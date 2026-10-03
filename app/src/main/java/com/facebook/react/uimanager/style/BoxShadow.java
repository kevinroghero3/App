package com.facebook.react.uimanager.style;

import android.content.Context;
import androidx.annotation.ColorInt;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class BoxShadow {
    public static final Companion Companion = new Companion(null);
    private final Float blurRadius;
    private final Integer color;
    private final Boolean inset;
    private final float offsetX;
    private final float offsetY;
    private final Float spreadDistance;

    public static /* synthetic */ BoxShadow copy$default(BoxShadow boxShadow, float f, float f2, Integer num, Float f3, Float f4, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            f = boxShadow.offsetX;
        }
        if ((i & 2) != 0) {
            f2 = boxShadow.offsetY;
        }
        float f5 = f2;
        if ((i & 4) != 0) {
            num = boxShadow.color;
        }
        Integer num2 = num;
        if ((i & 8) != 0) {
            f3 = boxShadow.blurRadius;
        }
        Float f6 = f3;
        if ((i & 16) != 0) {
            f4 = boxShadow.spreadDistance;
        }
        Float f7 = f4;
        if ((i & 32) != 0) {
            bool = boxShadow.inset;
        }
        return boxShadow.copy(f, f5, num2, f6, f7, bool);
    }

    @JvmStatic
    public static final BoxShadow parse(@Nullable ReadableMap readableMap, @NotNull Context context) {
        return Companion.parse(readableMap, context);
    }

    public final float component1() {
        return this.offsetX;
    }

    public final float component2() {
        return this.offsetY;
    }

    public final Integer component3() {
        return this.color;
    }

    public final Float component4() {
        return this.blurRadius;
    }

    public final Float component5() {
        return this.spreadDistance;
    }

    public final Boolean component6() {
        return this.inset;
    }

    public final BoxShadow copy(float f, float f2, @ColorInt @Nullable Integer num, @Nullable Float f3, @Nullable Float f4, @Nullable Boolean bool) {
        return new BoxShadow(f, f2, num, f3, f4, bool);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BoxShadow)) {
            return false;
        }
        BoxShadow boxShadow = (BoxShadow) obj;
        return Float.compare(this.offsetX, boxShadow.offsetX) == 0 && Float.compare(this.offsetY, boxShadow.offsetY) == 0 && Intrinsics.areEqual(this.color, boxShadow.color) && Intrinsics.areEqual((Object) this.blurRadius, (Object) boxShadow.blurRadius) && Intrinsics.areEqual((Object) this.spreadDistance, (Object) boxShadow.spreadDistance) && Intrinsics.areEqual(this.inset, boxShadow.inset);
    }

    public int hashCode() {
        int iHashCode = Float.hashCode(this.offsetX);
        int iHashCode2 = Float.hashCode(this.offsetY);
        Integer num = this.color;
        int iHashCode3 = num == null ? 0 : num.hashCode();
        Float f = this.blurRadius;
        int iHashCode4 = f == null ? 0 : f.hashCode();
        Float f2 = this.spreadDistance;
        int iHashCode5 = f2 == null ? 0 : f2.hashCode();
        Boolean bool = this.inset;
        return (((((((((iHashCode * 31) + iHashCode2) * 31) + iHashCode3) * 31) + iHashCode4) * 31) + iHashCode5) * 31) + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        return "BoxShadow(offsetX=" + this.offsetX + ", offsetY=" + this.offsetY + ", color=" + this.color + ", blurRadius=" + this.blurRadius + ", spreadDistance=" + this.spreadDistance + ", inset=" + this.inset + ")";
    }

    public BoxShadow(float f, float f2, @ColorInt @Nullable Integer num, @Nullable Float f3, @Nullable Float f4, @Nullable Boolean bool) {
        this.offsetX = f;
        this.offsetY = f2;
        this.color = num;
        this.blurRadius = f3;
        this.spreadDistance = f4;
        this.inset = bool;
    }

    public /* synthetic */ BoxShadow(float f, float f2, Integer num, Float f3, Float f4, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : f3, (i & 16) != 0 ? null : f4, (i & 32) != 0 ? null : bool);
    }

    public final float getOffsetX() {
        return this.offsetX;
    }

    public final float getOffsetY() {
        return this.offsetY;
    }

    public final Integer getColor() {
        return this.color;
    }

    public final Float getBlurRadius() {
        return this.blurRadius;
    }

    public final Float getSpreadDistance() {
        return this.spreadDistance;
    }

    public final Boolean getInset() {
        return this.inset;
    }

    public static final class Companion {

        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ReadableType.values().length];
                try {
                    iArr[ReadableType.Number.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ReadableType.Map.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final BoxShadow parse(@Nullable ReadableMap readableMap, @NotNull Context context) {
            Integer num;
            Integer numValueOf;
            Intrinsics.checkNotNullParameter(context, "context");
            if (readableMap == null || !readableMap.hasKey("offsetX") || !readableMap.hasKey("offsetY")) {
                return null;
            }
            float f = (float) readableMap.getDouble("offsetX");
            float f2 = (float) readableMap.getDouble("offsetY");
            if (readableMap.hasKey("color")) {
                ReadableType type = readableMap.getType("color");
                int i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
                if (i == 1) {
                    numValueOf = Integer.valueOf(readableMap.getInt("color"));
                } else if (i == 2) {
                    numValueOf = ColorPropConverter.getColor(readableMap.getMap("color"), context);
                } else {
                    throw new JSApplicationCausedNativeException("Unsupported color type " + type);
                }
                num = numValueOf;
            } else {
                num = null;
            }
            return new BoxShadow(f, f2, num, readableMap.hasKey("blurRadius") ? Float.valueOf((float) readableMap.getDouble("blurRadius")) : null, readableMap.hasKey("spreadDistance") ? Float.valueOf((float) readableMap.getDouble("spreadDistance")) : null, readableMap.hasKey("inset") ? Boolean.valueOf(readableMap.getBoolean("inset")) : null);
        }
    }
}
