package com.facebook.react.uimanager;

import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.uimanager.style.CornerRadii;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class LengthPercentage {
    public static final Companion Companion = new Companion(null);
    private final LengthPercentageType type;
    private final float value;

    private final float component1() {
        return this.value;
    }

    public static /* synthetic */ LengthPercentage copy$default(LengthPercentage lengthPercentage, float f, LengthPercentageType lengthPercentageType, int i, Object obj) {
        if ((i & 1) != 0) {
            f = lengthPercentage.value;
        }
        if ((i & 2) != 0) {
            lengthPercentageType = lengthPercentage.type;
        }
        return lengthPercentage.copy(f, lengthPercentageType);
    }

    @JvmStatic
    public static final LengthPercentage setFromDynamic(@NotNull Dynamic dynamic) {
        return Companion.setFromDynamic(dynamic);
    }

    public final LengthPercentageType component2() {
        return this.type;
    }

    public final LengthPercentage copy(float f, @NotNull LengthPercentageType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return new LengthPercentage(f, type);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LengthPercentage)) {
            return false;
        }
        LengthPercentage lengthPercentage = (LengthPercentage) obj;
        return Float.compare(this.value, lengthPercentage.value) == 0 && this.type == lengthPercentage.type;
    }

    public int hashCode() {
        return (Float.hashCode(this.value) * 31) + this.type.hashCode();
    }

    public String toString() {
        return "LengthPercentage(value=" + this.value + ", type=" + this.type + ")";
    }

    public LengthPercentage(float f, @NotNull LengthPercentageType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.value = f;
        this.type = type;
    }

    public final LengthPercentageType getType() {
        return this.type;
    }

    public static final class Companion {

        /* JADX INFO: loaded from: classes2.dex */
        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ReadableType.values().length];
                try {
                    iArr[ReadableType.Number.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ReadableType.String.ordinal()] = 2;
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
        public final LengthPercentage setFromDynamic(@NotNull Dynamic dynamic) {
            Intrinsics.checkNotNullParameter(dynamic, "dynamic");
            int i = WhenMappings.$EnumSwitchMapping$0[dynamic.getType().ordinal()];
            if (i == 1) {
                double dAsDouble = dynamic.asDouble();
                if (dAsDouble >= 0.0d) {
                    return new LengthPercentage((float) dAsDouble, LengthPercentageType.POINT);
                }
                return null;
            }
            if (i == 2) {
                String strAsString = dynamic.asString();
                if (StringsKt__StringsJVMKt.endsWith$default(strAsString, "%", false, 2, null)) {
                    try {
                        String strSubstring = strAsString.substring(0, strAsString.length() - 1);
                        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                        float f = Float.parseFloat(strSubstring);
                        if (f >= 0.0f) {
                            return new LengthPercentage(f, LengthPercentageType.PERCENT);
                        }
                        return null;
                    } catch (NumberFormatException unused) {
                        FLog.w(ReactConstants.TAG, "Invalid percentage format: " + strAsString);
                        return null;
                    }
                }
                FLog.w(ReactConstants.TAG, "Invalid string value: " + strAsString);
                return null;
            }
            FLog.w(ReactConstants.TAG, "Unsupported type for radius property: " + dynamic.getType());
            return null;
        }
    }

    public final CornerRadii resolve(float f, float f2) {
        if (this.type == LengthPercentageType.PERCENT) {
            float f3 = this.value / 100;
            return new CornerRadii(f * f3, f3 * f2);
        }
        float f4 = this.value;
        return new CornerRadii(f4, f4);
    }

    public LengthPercentage() {
        this(0.0f, LengthPercentageType.POINT);
    }
}
