package com.google.android.material.color;

import androidx.annotation.NonNull;
import com.google.android.material.R;
import com.google.android.material.color.utilities.DynamicColor;
import com.google.android.material.color.utilities.DynamicScheme;
import com.google.android.material.color.utilities.MaterialDynamicColors;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class MaterialColorUtilitiesHelper {
    private static final Map<Integer, DynamicColor> colorResourceIdToColorValue;
    private static final MaterialDynamicColors dynamicColors;

    private MaterialColorUtilitiesHelper() {
    }

    static {
        MaterialDynamicColors materialDynamicColors = new MaterialDynamicColors();
        dynamicColors = materialDynamicColors;
        HashMap map = new HashMap();
        map.put(Integer.valueOf(R.color.material_personalized_color_primary), materialDynamicColors.primary());
        map.put(Integer.valueOf(R.color.material_personalized_color_on_primary), materialDynamicColors.onPrimary());
        map.put(Integer.valueOf(R.color.material_personalized_color_primary_inverse), materialDynamicColors.inversePrimary());
        int i = R.color.material_personalized_color_primary_container;
        map.put(Integer.valueOf(i), materialDynamicColors.primaryContainer());
        int i2 = R.color.material_personalized_color_on_primary_container;
        map.put(Integer.valueOf(i2), materialDynamicColors.onPrimaryContainer());
        map.put(Integer.valueOf(R.color.material_personalized_color_secondary), materialDynamicColors.secondary());
        map.put(Integer.valueOf(R.color.material_personalized_color_on_secondary), materialDynamicColors.onSecondary());
        int i3 = R.color.material_personalized_color_secondary_container;
        map.put(Integer.valueOf(i3), materialDynamicColors.secondaryContainer());
        int i4 = R.color.material_personalized_color_on_secondary_container;
        map.put(Integer.valueOf(i4), materialDynamicColors.onSecondaryContainer());
        map.put(Integer.valueOf(R.color.material_personalized_color_tertiary), materialDynamicColors.tertiary());
        map.put(Integer.valueOf(R.color.material_personalized_color_on_tertiary), materialDynamicColors.onTertiary());
        int i5 = R.color.material_personalized_color_tertiary_container;
        map.put(Integer.valueOf(i5), materialDynamicColors.tertiaryContainer());
        int i6 = R.color.material_personalized_color_on_tertiary_container;
        map.put(Integer.valueOf(i6), materialDynamicColors.onTertiaryContainer());
        map.put(Integer.valueOf(R.color.material_personalized_color_background), materialDynamicColors.background());
        map.put(Integer.valueOf(R.color.material_personalized_color_on_background), materialDynamicColors.onBackground());
        map.put(Integer.valueOf(R.color.material_personalized_color_surface), materialDynamicColors.surface());
        map.put(Integer.valueOf(R.color.material_personalized_color_on_surface), materialDynamicColors.onSurface());
        map.put(Integer.valueOf(R.color.material_personalized_color_surface_variant), materialDynamicColors.surfaceVariant());
        int i7 = R.color.material_personalized_color_on_surface_variant;
        map.put(Integer.valueOf(i7), materialDynamicColors.onSurfaceVariant());
        map.put(Integer.valueOf(R.color.material_personalized_color_surface_inverse), materialDynamicColors.inverseSurface());
        int i8 = R.color.material_personalized_color_on_surface_inverse;
        map.put(Integer.valueOf(i8), materialDynamicColors.inverseOnSurface());
        map.put(Integer.valueOf(R.color.material_personalized_color_surface_bright), materialDynamicColors.surfaceBright());
        map.put(Integer.valueOf(R.color.material_personalized_color_surface_dim), materialDynamicColors.surfaceDim());
        int i9 = R.color.material_personalized_color_surface_container;
        map.put(Integer.valueOf(i9), materialDynamicColors.surfaceContainer());
        int i10 = R.color.material_personalized_color_surface_container_low;
        map.put(Integer.valueOf(i10), materialDynamicColors.surfaceContainerLow());
        int i11 = R.color.material_personalized_color_surface_container_high;
        map.put(Integer.valueOf(i11), materialDynamicColors.surfaceContainerHigh());
        int i12 = R.color.material_personalized_color_surface_container_lowest;
        map.put(Integer.valueOf(i12), materialDynamicColors.surfaceContainerLowest());
        int i13 = R.color.material_personalized_color_surface_container_highest;
        map.put(Integer.valueOf(i13), materialDynamicColors.surfaceContainerHighest());
        map.put(Integer.valueOf(R.color.material_personalized_color_outline), materialDynamicColors.outline());
        map.put(Integer.valueOf(R.color.material_personalized_color_outline_variant), materialDynamicColors.outlineVariant());
        map.put(Integer.valueOf(R.color.material_personalized_color_error), materialDynamicColors.error());
        map.put(Integer.valueOf(R.color.material_personalized_color_on_error), materialDynamicColors.onError());
        map.put(Integer.valueOf(R.color.material_personalized_color_error_container), materialDynamicColors.errorContainer());
        int i14 = R.color.material_personalized_color_on_error_container;
        map.put(Integer.valueOf(i14), materialDynamicColors.onErrorContainer());
        int i15 = R.color.material_personalized_color_control_activated;
        map.put(Integer.valueOf(i15), materialDynamicColors.controlActivated());
        map.put(Integer.valueOf(R.color.material_personalized_color_control_normal), materialDynamicColors.controlNormal());
        int i16 = R.color.material_personalized_color_control_highlight;
        map.put(Integer.valueOf(i16), materialDynamicColors.controlHighlight());
        int i17 = R.color.material_personalized_color_text_primary_inverse;
        map.put(Integer.valueOf(i17), materialDynamicColors.textPrimaryInverse());
        int i18 = R.color.material_personalized_color_text_secondary_and_tertiary_inverse;
        map.put(Integer.valueOf(i18), materialDynamicColors.textSecondaryAndTertiaryInverse());
        int i19 = R.color.material_personalized_color_text_secondary_and_tertiary_inverse_disabled;
        map.put(Integer.valueOf(i19), materialDynamicColors.textSecondaryAndTertiaryInverseDisabled());
        int i20 = R.color.material_personalized_color_text_primary_inverse_disable_only;
        map.put(Integer.valueOf(i20), materialDynamicColors.textPrimaryInverseDisableOnly());
        int i21 = R.color.material_personalized_color_text_hint_foreground_inverse;
        map.put(Integer.valueOf(i21), materialDynamicColors.textHintInverse());
        colorResourceIdToColorValue = Collections.unmodifiableMap(map);
    }

    public static Map<Integer, Integer> createColorResourcesIdsToColorValues(@NonNull DynamicScheme dynamicScheme) {
        HashMap map = new HashMap();
        for (Map.Entry<Integer, DynamicColor> entry : colorResourceIdToColorValue.entrySet()) {
            map.put(entry.getKey(), Integer.valueOf(entry.getValue().getArgb(dynamicScheme)));
        }
        return Collections.unmodifiableMap(map);
    }
}
