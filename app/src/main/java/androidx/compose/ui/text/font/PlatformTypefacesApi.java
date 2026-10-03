package androidx.compose.ui.text.font;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
final class PlatformTypefacesApi implements PlatformTypefaces {
    @Override // androidx.compose.ui.text.font.PlatformTypefaces
    /* JADX INFO: renamed from: createDefault-FO1MlWM */
    public android.graphics.Typeface mo3272createDefaultFO1MlWM(@NotNull FontWeight fontWeight, int i) {
        return m3275createAndroidTypefaceUsingTypefaceStyleRetOiIg(null, fontWeight, i);
    }

    @Override // androidx.compose.ui.text.font.PlatformTypefaces
    /* JADX INFO: renamed from: createNamed-RetOiIg */
    public android.graphics.Typeface mo3273createNamedRetOiIg(@NotNull GenericFontFamily genericFontFamily, @NotNull FontWeight fontWeight, int i) {
        android.graphics.Typeface typefaceM3277loadNamedFromTypefaceCacheOrNullRetOiIg = m3277loadNamedFromTypefaceCacheOrNullRetOiIg(PlatformTypefaces_androidKt.getWeightSuffixForFallbackFamilyName(genericFontFamily.getName(), fontWeight), fontWeight, i);
        return typefaceM3277loadNamedFromTypefaceCacheOrNullRetOiIg == null ? m3275createAndroidTypefaceUsingTypefaceStyleRetOiIg(genericFontFamily.getName(), fontWeight, i) : typefaceM3277loadNamedFromTypefaceCacheOrNullRetOiIg;
    }

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
            typefaceMo3273createNamedRetOiIg = Intrinsics.areEqual(str, companion.getCursive().getName()) ? mo3273createNamedRetOiIg(companion.getCursive(), fontWeight, i) : m3277loadNamedFromTypefaceCacheOrNullRetOiIg(str, fontWeight, i);
        }
        return PlatformTypefaces_androidKt.setFontVariationSettings(typefaceMo3273createNamedRetOiIg, settings, context);
    }

    /* JADX INFO: renamed from: loadNamedFromTypefaceCacheOrNull-RetOiIg, reason: not valid java name */
    private final android.graphics.Typeface m3277loadNamedFromTypefaceCacheOrNullRetOiIg(String str, FontWeight fontWeight, int i) {
        if (str.length() == 0) {
            return null;
        }
        android.graphics.Typeface typefaceM3275createAndroidTypefaceUsingTypefaceStyleRetOiIg = m3275createAndroidTypefaceUsingTypefaceStyleRetOiIg(str, fontWeight, i);
        if (Intrinsics.areEqual(typefaceM3275createAndroidTypefaceUsingTypefaceStyleRetOiIg, android.graphics.Typeface.create(android.graphics.Typeface.DEFAULT, AndroidFontUtils_androidKt.m3199getAndroidTypefaceStyleFO1MlWM(fontWeight, i))) || Intrinsics.areEqual(typefaceM3275createAndroidTypefaceUsingTypefaceStyleRetOiIg, m3275createAndroidTypefaceUsingTypefaceStyleRetOiIg(null, fontWeight, i))) {
            return null;
        }
        return typefaceM3275createAndroidTypefaceUsingTypefaceStyleRetOiIg;
    }

    /* JADX INFO: renamed from: createAndroidTypefaceUsingTypefaceStyle-RetOiIg$default, reason: not valid java name */
    static /* synthetic */ android.graphics.Typeface m3276createAndroidTypefaceUsingTypefaceStyleRetOiIg$default(PlatformTypefacesApi platformTypefacesApi, String str, FontWeight fontWeight, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        if ((i2 & 2) != 0) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        if ((i2 & 4) != 0) {
            i = FontStyle.Companion.m3252getNormal_LCdwA();
        }
        return platformTypefacesApi.m3275createAndroidTypefaceUsingTypefaceStyleRetOiIg(str, fontWeight, i);
    }

    /* JADX INFO: renamed from: createAndroidTypefaceUsingTypefaceStyle-RetOiIg, reason: not valid java name */
    private final android.graphics.Typeface m3275createAndroidTypefaceUsingTypefaceStyleRetOiIg(String str, FontWeight fontWeight, int i) {
        if (FontStyle.m3245equalsimpl0(i, FontStyle.Companion.m3252getNormal_LCdwA()) && Intrinsics.areEqual(fontWeight, FontWeight.Companion.getNormal()) && (str == null || str.length() == 0)) {
            return android.graphics.Typeface.DEFAULT;
        }
        int iM3199getAndroidTypefaceStyleFO1MlWM = AndroidFontUtils_androidKt.m3199getAndroidTypefaceStyleFO1MlWM(fontWeight, i);
        if (str == null || str.length() == 0) {
            return android.graphics.Typeface.defaultFromStyle(iM3199getAndroidTypefaceStyleFO1MlWM);
        }
        return android.graphics.Typeface.create(str, iM3199getAndroidTypefaceStyleFO1MlWM);
    }
}
