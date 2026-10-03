package androidx.compose.ui.platform;

import android.os.Parcel;
import android.util.Base64;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitType;
import com.google.common.base.Ascii;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class EncodeHelper {
    public static final int $stable = 8;
    private Parcel parcel = Parcel.obtain();

    public final void reset() {
        this.parcel.recycle();
        this.parcel = Parcel.obtain();
    }

    public final String encodedString() {
        return Base64.encodeToString(this.parcel.marshall(), 0);
    }

    public final void encode(@NotNull SpanStyle spanStyle) {
        long jM3085getColor0d7_KjU = spanStyle.m3085getColor0d7_KjU();
        Color.Companion companion = Color.Companion;
        if (!Color.m1170equalsimpl0(jM3085getColor0d7_KjU, companion.m1205getUnspecified0d7_KjU())) {
            encode((byte) 1);
            m2886encode8_81llA(spanStyle.m3085getColor0d7_KjU());
        }
        long jM3086getFontSizeXSAIIZE = spanStyle.m3086getFontSizeXSAIIZE();
        TextUnit.Companion companion2 = TextUnit.Companion;
        if (!TextUnit.m3840equalsimpl0(jM3086getFontSizeXSAIIZE, companion2.m3854getUnspecifiedXSAIIZE())) {
            encode((byte) 2);
            m2883encodeR2X_6o(spanStyle.m3086getFontSizeXSAIIZE());
        }
        FontWeight fontWeight = spanStyle.getFontWeight();
        if (fontWeight != null) {
            encode((byte) 3);
            encode(fontWeight);
        }
        FontStyle fontStyleM3087getFontStyle4Lr2A7w = spanStyle.m3087getFontStyle4Lr2A7w();
        if (fontStyleM3087getFontStyle4Lr2A7w != null) {
            int iM3248unboximpl = fontStyleM3087getFontStyle4Lr2A7w.m3248unboximpl();
            encode((byte) 4);
            m2888encodenzbMABs(iM3248unboximpl);
        }
        FontSynthesis fontSynthesisM3088getFontSynthesisZQGJjVo = spanStyle.m3088getFontSynthesisZQGJjVo();
        if (fontSynthesisM3088getFontSynthesisZQGJjVo != null) {
            int iM3261unboximpl = fontSynthesisM3088getFontSynthesisZQGJjVo.m3261unboximpl();
            encode((byte) 5);
            m2885encode6p3vJLY(iM3261unboximpl);
        }
        String fontFeatureSettings = spanStyle.getFontFeatureSettings();
        if (fontFeatureSettings != null) {
            encode((byte) 6);
            encode(fontFeatureSettings);
        }
        if (!TextUnit.m3840equalsimpl0(spanStyle.m3089getLetterSpacingXSAIIZE(), companion2.m3854getUnspecifiedXSAIIZE())) {
            encode((byte) 7);
            m2883encodeR2X_6o(spanStyle.m3089getLetterSpacingXSAIIZE());
        }
        BaselineShift baselineShiftM3084getBaselineShift5SSeXJ0 = spanStyle.m3084getBaselineShift5SSeXJ0();
        if (baselineShiftM3084getBaselineShift5SSeXJ0 != null) {
            float fM3429unboximpl = baselineShiftM3084getBaselineShift5SSeXJ0.m3429unboximpl();
            encode((byte) 8);
            m2884encode4Dl_Bck(fM3429unboximpl);
        }
        TextGeometricTransform textGeometricTransform = spanStyle.getTextGeometricTransform();
        if (textGeometricTransform != null) {
            encode((byte) 9);
            encode(textGeometricTransform);
        }
        if (!Color.m1170equalsimpl0(spanStyle.m3083getBackground0d7_KjU(), companion.m1205getUnspecified0d7_KjU())) {
            encode((byte) 10);
            m2886encode8_81llA(spanStyle.m3083getBackground0d7_KjU());
        }
        TextDecoration textDecoration = spanStyle.getTextDecoration();
        if (textDecoration != null) {
            encode(Ascii.VT);
            encode(textDecoration);
        }
        Shadow shadow = spanStyle.getShadow();
        if (shadow != null) {
            encode(Ascii.FF);
            encode(shadow);
        }
    }

    /* JADX INFO: renamed from: encode-8_81llA, reason: not valid java name */
    public final void m2886encode8_81llA(long j) {
        m2887encodeVKZWuLQ(j);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0029  */
    /* JADX INFO: renamed from: encode--R2X_6o, reason: not valid java name */
    public final void m2883encodeR2X_6o(long j) {
        byte b;
        long jM3842getTypeUIouoOA = TextUnit.m3842getTypeUIouoOA(j);
        TextUnitType.Companion companion = TextUnitType.Companion;
        if (TextUnitType.m3871equalsimpl0(jM3842getTypeUIouoOA, companion.m3877getUnspecifiedUIouoOA())) {
            b = 0;
        } else if (TextUnitType.m3871equalsimpl0(jM3842getTypeUIouoOA, companion.m3876getSpUIouoOA())) {
            b = 1;
        } else if (TextUnitType.m3871equalsimpl0(jM3842getTypeUIouoOA, companion.m3875getEmUIouoOA())) {
            b = 2;
        } else {
            b = 0;
        }
        encode(b);
        if (TextUnitType.m3871equalsimpl0(TextUnit.m3842getTypeUIouoOA(j), companion.m3877getUnspecifiedUIouoOA())) {
            return;
        }
        encode(TextUnit.m3843getValueimpl(j));
    }

    public final void encode(@NotNull FontWeight fontWeight) {
        encode(fontWeight.getWeight());
    }

    /* JADX INFO: renamed from: encode-nzbMABs, reason: not valid java name */
    public final void m2888encodenzbMABs(int i) {
        FontStyle.Companion companion = FontStyle.Companion;
        encode((!FontStyle.m3245equalsimpl0(i, companion.m3252getNormal_LCdwA()) && FontStyle.m3245equalsimpl0(i, companion.m3251getItalic_LCdwA())) ? (byte) 1 : (byte) 0);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0031  */
    /* JADX INFO: renamed from: encode-6p3vJLY, reason: not valid java name */
    public final void m2885encode6p3vJLY(int i) {
        byte b;
        FontSynthesis.Companion companion = FontSynthesis.Companion;
        if (FontSynthesis.m3256equalsimpl0(i, companion.m3263getNoneGVVA2EU())) {
            b = 0;
        } else if (FontSynthesis.m3256equalsimpl0(i, companion.m3262getAllGVVA2EU())) {
            b = 1;
        } else if (FontSynthesis.m3256equalsimpl0(i, companion.m3265getWeightGVVA2EU())) {
            b = 2;
        } else if (FontSynthesis.m3256equalsimpl0(i, companion.m3264getStyleGVVA2EU())) {
            b = 3;
        } else {
            b = 0;
        }
        encode(b);
    }

    /* JADX INFO: renamed from: encode-4Dl_Bck, reason: not valid java name */
    public final void m2884encode4Dl_Bck(float f) {
        encode(f);
    }

    public final void encode(@NotNull TextGeometricTransform textGeometricTransform) {
        encode(textGeometricTransform.getScaleX());
        encode(textGeometricTransform.getSkewX());
    }

    public final void encode(@NotNull TextDecoration textDecoration) {
        encode(textDecoration.getMask());
    }

    public final void encode(@NotNull Shadow shadow) {
        m2886encode8_81llA(shadow.m1496getColor0d7_KjU());
        encode(Offset.m928getXimpl(shadow.m1497getOffsetF1C5BW0()));
        encode(Offset.m929getYimpl(shadow.m1497getOffsetF1C5BW0()));
        encode(shadow.getBlurRadius());
    }

    public final void encode(byte b) {
        this.parcel.writeByte(b);
    }

    public final void encode(int i) {
        this.parcel.writeInt(i);
    }

    public final void encode(float f) {
        this.parcel.writeFloat(f);
    }

    /* JADX INFO: renamed from: encode-VKZWuLQ, reason: not valid java name */
    public final void m2887encodeVKZWuLQ(long j) {
        this.parcel.writeLong(j);
    }

    public final void encode(@NotNull String str) {
        this.parcel.writeString(str);
    }
}
