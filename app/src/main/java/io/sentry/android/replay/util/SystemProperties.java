package io.sentry.android.replay.util;

import android.os.Build;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class SystemProperties {
    public static final int $stable = 0;
    public static final SystemProperties INSTANCE = new SystemProperties();

    public enum Property {
        SOC_MODEL,
        SOC_MANUFACTURER
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Property.values().length];
            try {
                iArr[Property.SOC_MODEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Property.SOC_MANUFACTURER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private SystemProperties() {
    }

    public static /* synthetic */ String get$default(SystemProperties systemProperties, Property property, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "";
        }
        return systemProperties.get(property, str);
    }

    public final String get(@NotNull Property key, @NotNull String defaultValue) {
        String str;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        if (Build.VERSION.SDK_INT < 31) {
            return defaultValue;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[key.ordinal()];
        if (i == 1) {
            str = Build.SOC_MODEL;
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            str = Build.SOC_MANUFACTURER;
        }
        String str2 = str;
        Intrinsics.checkNotNullExpressionValue(str2, "{\n      when (key) {\n   …ANUFACTURER\n      }\n    }");
        return str2;
    }
}
