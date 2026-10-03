package com.facebook.react.uimanager.style;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.Shader;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.uimanager.ViewProps;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class Gradient {
    public static int ITrustedWebActivityServiceStub;
    public static int notifyNotificationWithChannel;
    private final LinearGradient linearGradient;
    private final GradientType type;

    enum GradientType {
        LINEAR_GRADIENT;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<GradientType> getEntries() {
            return $ENTRIES;
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[GradientType.values().length];
            try {
                iArr[GradientType.LINEAR_GRADIENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public Gradient(@Nullable ReadableMap readableMap, @NotNull Context context) {
        Integer numValueOf;
        Intrinsics.checkNotNullParameter(context, "context");
        if (readableMap == null) {
            throw new IllegalArgumentException("Gradient cannot be null");
        }
        String string = readableMap.getString("type");
        if (Intrinsics.areEqual(string, "linearGradient")) {
            this.type = GradientType.LINEAR_GRADIENT;
            ReadableMap map = readableMap.getMap("direction");
            if (map == null) {
                throw new IllegalArgumentException("Gradient must have direction");
            }
            ReadableArray array = readableMap.getArray("colorStops");
            if (array == null) {
                throw new IllegalArgumentException("Invalid colorStops array");
            }
            int size = array.size();
            int[] iArr = new int[size];
            float[] fArr = new float[size];
            for (int i = 0; i < size; i++) {
                ReadableMap map2 = array.getMap(i);
                if (map2 != null) {
                    if (map2.getType("color") == ReadableType.Map) {
                        numValueOf = ColorPropConverter.getColor(map2.getMap("color"), context);
                    } else {
                        numValueOf = Integer.valueOf(map2.getInt("color"));
                    }
                    Intrinsics.checkNotNull(numValueOf);
                    iArr[i] = numValueOf.intValue();
                    fArr[i] = (float) map2.getDouble(ViewProps.POSITION);
                }
            }
            this.linearGradient = new LinearGradient(map, iArr, fArr);
            return;
        }
        throw new IllegalArgumentException("Unsupported gradient type: " + string);
    }

    public final Shader getShader(@NotNull Rect bounds) {
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        if (WhenMappings.$EnumSwitchMapping$0[this.type.ordinal()] != 1) {
            throw new NoWhenBranchMatchedException();
        }
        return this.linearGradient.getShader(bounds.width(), bounds.height());
    }

    public static int asInterface() {
        int i = ITrustedWebActivityServiceStub;
        int i2 = i % 5209122;
        ITrustedWebActivityServiceStub = i + 1;
        if (i2 != 0) {
            return notifyNotificationWithChannel;
        }
        int iMaxMemory = (int) Runtime.getRuntime().maxMemory();
        notifyNotificationWithChannel = iMaxMemory;
        return iMaxMemory;
    }
}
