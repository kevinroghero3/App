package androidx.compose.ui.text.font;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.fonts.FontVariationAxis;
import android.os.ParcelFileDescriptor;
import androidx.compose.ui.unit.AndroidDensity_androidKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
final class TypefaceBuilderCompat {
    public static final TypefaceBuilderCompat INSTANCE = new TypefaceBuilderCompat();

    private TypefaceBuilderCompat() {
    }

    public final android.graphics.Typeface createFromAssets(@NotNull AssetManager assetManager, @NotNull String str, @Nullable Context context, @NotNull FontVariation.Settings settings) {
        if (context == null) {
            return null;
        }
        return TypefaceBuilderCompat$$ExternalSyntheticApiModelOutline3.m(assetManager, str).setFontVariationSettings(toVariationSettings(settings, context)).build();
    }

    public final android.graphics.Typeface createFromFile(@NotNull File file, @Nullable Context context, @NotNull FontVariation.Settings settings) {
        if (context == null) {
            return null;
        }
        return TypefaceBuilderCompat$$ExternalSyntheticApiModelOutline2.m(file).setFontVariationSettings(toVariationSettings(settings, context)).build();
    }

    public final android.graphics.Typeface createFromFileDescriptor(@NotNull ParcelFileDescriptor parcelFileDescriptor, @Nullable Context context, @NotNull FontVariation.Settings settings) {
        if (context == null) {
            return null;
        }
        TypefaceBuilderCompat$$ExternalSyntheticApiModelOutline7.m();
        return TypefaceBuilderCompat$$ExternalSyntheticApiModelOutline6.m(parcelFileDescriptor.getFileDescriptor()).setFontVariationSettings(toVariationSettings(settings, context)).build();
    }

    private final FontVariationAxis[] toVariationSettings(FontVariation.Settings settings, Context context) {
        Density Density;
        if (context != null) {
            Density = AndroidDensity_androidKt.Density(context);
        } else if (!settings.getNeedsDensity$ui_text_release()) {
            Density = DensityKt.Density(1.0f, 1.0f);
        } else {
            throw new IllegalStateException("Required density, but not provided");
        }
        List<FontVariation.Setting> settings2 = settings.getSettings();
        ArrayList arrayList = new ArrayList(settings2.size());
        int size = settings2.size();
        for (int i = 0; i < size; i++) {
            FontVariation.Setting setting = settings2.get(i);
            TypefaceBuilderCompat$$ExternalSyntheticApiModelOutline5.m();
            arrayList.add(TypefaceBuilderCompat$$ExternalSyntheticApiModelOutline4.m(setting.getAxisName(), setting.toVariationValue(Density)));
        }
        return (FontVariationAxis[]) arrayList.toArray(new FontVariationAxis[0]);
    }
}
