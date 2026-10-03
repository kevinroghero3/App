package com.reactnativekeyboardcontroller.views.background;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import androidx.annotation.ColorInt;
import androidx.core.view.ViewCompat;
import com.facebook.react.uimanager.ThemedReactContext;
import com.reactnativekeyboardcontroller.R;
import com.reactnativekeyboardcontroller.extensions.ContextKt;
import com.reactnativekeyboardcontroller.log.Logger;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class SkinsKt {
    private static final int MAX_RGB_VALUE = 255;
    private static final String TAG = "Skins";
    private static final Map<String, Pair<Integer, Integer>> imeColorMap = MapsKt__MapsKt.mapOf(TuplesKt.to(ImePackages.AOSP, TuplesKt.to(Integer.valueOf(R.style.aosp_light), Integer.valueOf(R.style.aosp_light))), TuplesKt.to(ImePackages.GBOARD, TuplesKt.to(Integer.valueOf(R.style.gboard_light), Integer.valueOf(R.style.gboard_dark))), TuplesKt.to(ImePackages.SWIFT_KEY, TuplesKt.to(Integer.valueOf(R.style.swiftkey_light), Integer.valueOf(R.style.swiftkey_dark))), TuplesKt.to(ImePackages.GBOARD_TTS, TuplesKt.to(Integer.valueOf(R.style.gboard_tts_light), Integer.valueOf(R.style.gboard_tts_dark))), TuplesKt.to(ImePackages.GOOGLE_TTS, TuplesKt.to(Integer.valueOf(R.style.gboard_tts_light), Integer.valueOf(R.style.gboard_tts_dark))), TuplesKt.to(ImePackages.YANDEX, TuplesKt.to(Integer.valueOf(R.style.yandex_light), Integer.valueOf(R.style.yandex_dark))), TuplesKt.to(ImePackages.SAMSUNG, TuplesKt.to(Integer.valueOf(R.style.samsung_light), Integer.valueOf(R.style.samsung_dark))));

    public static final Map<String, Pair<Integer, Integer>> getImeColorMap() {
        return imeColorMap;
    }

    public static final ColorProperties getColorProperties(@NotNull Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, R.styleable.ColorProperties);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        try {
            return new ColorProperties(typedArrayObtainStyledAttributes.getColor(R.styleable.ColorProperties_color, ViewCompat.MEASURED_STATE_MASK), typedArrayObtainStyledAttributes.getInt(R.styleable.ColorProperties_tone, 0));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static /* synthetic */ int shiftRgbChannels$default(int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 4;
        }
        return shiftRgbChannels(i, i2);
    }

    public static final int shiftRgbChannels(@ColorInt int i, int i2) {
        return Color.argb(Color.alpha(i), RangesKt___RangesKt.coerceIn(Color.red(i) + i2, 0, 255), RangesKt___RangesKt.coerceIn(Color.green(i) + i2, 0, 255), RangesKt___RangesKt.coerceIn(Color.blue(i) + i2, 0, 255));
    }

    public static final int getInputMethodColor(@NotNull ThemedReactContext themedReactContext) {
        Intrinsics.checkNotNullParameter(themedReactContext, "<this>");
        String strCurrentImePackage = ContextKt.currentImePackage(themedReactContext);
        boolean zIsSystemDarkMode = ContextKt.isSystemDarkMode(themedReactContext);
        Logger.i$default(Logger.INSTANCE, TAG, "Current IME: " + strCurrentImePackage, null, 4, null);
        Pair<Integer, Integer> pair = imeColorMap.get(strCurrentImePackage);
        if (pair == null) {
            pair = TuplesKt.to(Integer.valueOf(R.style.gboard_light), Integer.valueOf(R.style.gboard_dark));
        }
        int iIntValue = pair.component1().intValue();
        int iIntValue2 = pair.component2().intValue();
        if (zIsSystemDarkMode && Build.VERSION.SDK_INT > 29) {
            iIntValue = iIntValue2;
        }
        return getColorProperties(themedReactContext, iIntValue).getBlend();
    }
}
