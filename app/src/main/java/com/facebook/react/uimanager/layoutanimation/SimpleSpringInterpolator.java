package com.facebook.react.uimanager.layoutanimation;

import android.view.animation.Interpolator;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class SimpleSpringInterpolator implements Interpolator {
    public static final Companion Companion = new Companion(null);
    private static final float FACTOR = 0.5f;
    public static final String PARAM_SPRING_DAMPING = "springDamping";
    private final float _springDamping;

    public SimpleSpringInterpolator() {
        this(0.0f, 1, null);
    }

    @JvmStatic
    public static final float getSpringDamping(@NotNull ReadableMap readableMap) {
        return Companion.getSpringDamping(readableMap);
    }

    public /* synthetic */ SimpleSpringInterpolator(float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0.5f : f);
    }

    public SimpleSpringInterpolator(float f) {
        this._springDamping = f;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        double dPow = Math.pow(2.0d, (-10) * f);
        float f2 = this._springDamping;
        return (float) (((double) 1) + (dPow * Math.sin(((((double) (f - (f2 / 4))) * 3.141592653589793d) * ((double) 2)) / ((double) f2))));
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final float getSpringDamping(@NotNull ReadableMap params) {
            Intrinsics.checkNotNullParameter(params, "params");
            if (params.getType(SimpleSpringInterpolator.PARAM_SPRING_DAMPING) == ReadableType.Number) {
                return (float) params.getDouble(SimpleSpringInterpolator.PARAM_SPRING_DAMPING);
            }
            return 0.5f;
        }
    }
}
