package com.reactnativekeyboardcontroller.views;

import com.reactnativekeyboardcontroller.interactive.interpolators.Interpolator;
import com.reactnativekeyboardcontroller.interactive.interpolators.IosInterpolator;
import com.reactnativekeyboardcontroller.interactive.interpolators.LinearInterpolator;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;

/* JADX INFO: loaded from: classes6.dex */
public final class KeyboardGestureAreaReactViewGroupKt {
    private static final Map<String, Interpolator> interpolators = MapsKt__MapsKt.mapOf(TuplesKt.to("linear", new LinearInterpolator()), TuplesKt.to("ios", new IosInterpolator()));

    public static final Map<String, Interpolator> getInterpolators() {
        return interpolators;
    }
}
