package com.facebook.react.bridge;

import androidx.annotation.Nullable;
import com.facebook.yoga.YogaUnit;
import com.facebook.yoga.YogaValue;

/* JADX INFO: loaded from: classes4.dex */
public class DimensionPropConverter {
    public static YogaValue getDimension(@Nullable Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Double) {
            return new YogaValue(((Double) obj).floatValue(), YogaUnit.POINT);
        }
        if (obj instanceof String) {
            return YogaValue.parse((String) obj);
        }
        throw new JSApplicationCausedNativeException("DimensionValue: the value must be a number or string.");
    }
}
