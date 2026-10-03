package androidx.compose.ui.text.font;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
final class PlatformTypefacesApi28 implements PlatformTypefaces {
    @Override // androidx.compose.ui.text.font.PlatformTypefaces
    /* JADX INFO: renamed from: optionalOnDeviceFontFamilyByName-78DK7lM */
    public android.graphics.Typeface mo3274optionalOnDeviceFontFamilyByName78DK7lM(@NotNull String str, @NotNull FontWeight fontWeight, int i, @NotNull FontVariation.Settings settings, @NotNull Context context) {
        android.graphics.Typeface typefaceMo3273createNamedRetOiIg;
        FontFamily.Companion companion = FontFamily.Companion;
        if (Intrinsics.areEqual(str, companion.getSansSerif().getName())) {
            typefaceMo3273createNamedRetOiIg = mo3273createNamedRetOiIg(companion.getSansSerif(), fontWeight, i);
        } else if (Intrinsics.areEqual(str, companion.getSerif().getName())) {
            typefaceMo3273createNamedRetOiIg = mo3273createNamedRetOiIg(companion.getSerif(), fontWeight, i);
        } else if (Intrinsics.areEqual(str, companion.getMonospace().getName())) {
            typefaceMo3273createNamedRetOiIg = mo3273createNamedRetOiIg(companion.getMonospace(), fontWeight, i);
        } else {
            typefaceMo3273createNamedRetOiIg = Intrinsics.areEqual(str, companion.getCursive().getName()) ? mo3273createNamedRetOiIg(companion.getCursive(), fontWeight, i) : m3280loadNamedFromTypefaceCacheOrNullRetOiIg(str, fontWeight, i);
        }
        return PlatformTypefaces_androidKt.setFontVariationSettings(typefaceMo3273createNamedRetOiIg, settings, context);
    }

    @Override // androidx.compose.ui.text.font.PlatformTypefaces
    /* JADX INFO: renamed from: createDefault-FO1MlWM */
    public android.graphics.Typeface mo3272createDefaultFO1MlWM(@NotNull FontWeight fontWeight, int i) {
        return m3278createAndroidTypefaceApi28RetOiIg(null, fontWeight, i);
    }

    @Override // androidx.compose.ui.text.font.PlatformTypefaces
    /* JADX INFO: renamed from: createNamed-RetOiIg */
    public android.graphics.Typeface mo3273createNamedRetOiIg(@NotNull GenericFontFamily genericFontFamily, @NotNull FontWeight fontWeight, int i) {
        return m3278createAndroidTypefaceApi28RetOiIg(genericFontFamily.getName(), fontWeight, i);
    }

    /* JADX INFO: renamed from: loadNamedFromTypefaceCacheOrNull-RetOiIg, reason: not valid java name */
    private final android.graphics.Typeface m3280loadNamedFromTypefaceCacheOrNullRetOiIg(String str, FontWeight fontWeight, int i) {
        if (str.length() == 0) {
            return null;
        }
        android.graphics.Typeface typefaceM3278createAndroidTypefaceApi28RetOiIg = m3278createAndroidTypefaceApi28RetOiIg(str, fontWeight, i);
        if (Intrinsics.areEqual(typefaceM3278createAndroidTypefaceApi28RetOiIg, TypefaceHelperMethodsApi28.INSTANCE.create(android.graphics.Typeface.DEFAULT, fontWeight.getWeight(), FontStyle.m3245equalsimpl0(i, FontStyle.Companion.m3251getItalic_LCdwA()))) || Intrinsics.areEqual(typefaceM3278createAndroidTypefaceApi28RetOiIg, m3278createAndroidTypefaceApi28RetOiIg(null, fontWeight, i))) {
            return null;
        }
        return typefaceM3278createAndroidTypefaceApi28RetOiIg;
    }

    /* JADX INFO: renamed from: createAndroidTypefaceApi28-RetOiIg$default, reason: not valid java name */
    static /* synthetic */ android.graphics.Typeface m3279createAndroidTypefaceApi28RetOiIg$default(PlatformTypefacesApi28 platformTypefacesApi28, String str, FontWeight fontWeight, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        return platformTypefacesApi28.m3278createAndroidTypefaceApi28RetOiIg(str, fontWeight, i);
    }

    /* JADX INFO: renamed from: createAndroidTypefaceApi28-RetOiIg, reason: not valid java name */
    private final android.graphics.Typeface m3278createAndroidTypefaceApi28RetOiIg(String str, FontWeight fontWeight, int i) {
        android.graphics.Typeface typefaceCreate;
        FontStyle.Companion companion = FontStyle.Companion;
        if (FontStyle.m3245equalsimpl0(i, companion.m3252getNormal_LCdwA()) && Intrinsics.areEqual(fontWeight, FontWeight.Companion.getNormal()) && (str == null || str.length() == 0)) {
            return android.graphics.Typeface.DEFAULT;
        }
        if (str == null) {
            typefaceCreate = android.graphics.Typeface.DEFAULT;
        } else {
            typefaceCreate = android.graphics.Typeface.create(str, 0);
        }
        return android.graphics.Typeface.create(typefaceCreate, fontWeight.getWeight(), FontStyle.m3245equalsimpl0(i, companion.m3251getItalic_LCdwA()));
    }
}
