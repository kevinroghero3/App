package androidx.compose.ui.text.font;

import android.os.Build;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class FontSynthesis_androidKt {
    /* JADX WARN: Code duplicated, block: B:14:0x0033  */
    /* JADX INFO: renamed from: synthesizeTypeface-FxwP2eA, reason: not valid java name */
    public static final Object m3266synthesizeTypefaceFxwP2eA(int i, @NotNull Object obj, @NotNull Font font, @NotNull FontWeight fontWeight, int i2) {
        boolean z;
        int weight;
        boolean zM3245equalsimpl0;
        if (!(obj instanceof android.graphics.Typeface)) {
            return obj;
        }
        if (!FontSynthesis.m3259isWeightOnimpl$ui_text_release(i) || Intrinsics.areEqual(font.getWeight(), fontWeight)) {
            z = false;
        } else {
            FontWeight.Companion companion = FontWeight.Companion;
            if (fontWeight.compareTo(AndroidFontUtils_androidKt.getAndroidBold(companion)) < 0 || font.getWeight().compareTo(AndroidFontUtils_androidKt.getAndroidBold(companion)) >= 0) {
                z = false;
            } else {
                z = true;
            }
        }
        boolean z2 = FontSynthesis.m3258isStyleOnimpl$ui_text_release(i) && !FontStyle.m3245equalsimpl0(i2, font.mo3200getStyle_LCdwA());
        if (!z2 && !z) {
            return obj;
        }
        if (Build.VERSION.SDK_INT < 28) {
            return android.graphics.Typeface.create((android.graphics.Typeface) obj, AndroidFontUtils_androidKt.getAndroidTypefaceStyle(z, z2 && FontStyle.m3245equalsimpl0(i2, FontStyle.Companion.m3251getItalic_LCdwA())));
        }
        if (z) {
            weight = fontWeight.getWeight();
        } else {
            weight = font.getWeight().getWeight();
        }
        if (z2) {
            zM3245equalsimpl0 = FontStyle.m3245equalsimpl0(i2, FontStyle.Companion.m3251getItalic_LCdwA());
        } else {
            zM3245equalsimpl0 = FontStyle.m3245equalsimpl0(font.mo3200getStyle_LCdwA(), FontStyle.Companion.m3251getItalic_LCdwA());
        }
        return TypefaceHelperMethodsApi28.INSTANCE.create((android.graphics.Typeface) obj, weight, zM3245equalsimpl0);
    }
}
