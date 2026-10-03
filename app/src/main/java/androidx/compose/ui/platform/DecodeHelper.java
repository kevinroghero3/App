package androidx.compose.ui.platform;

import android.os.Parcel;
import android.util.Base64;
import androidx.compose.ui.geometry.OffsetKt;
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
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;
import kotlin.ULong;
import kotlin.collections.CollectionsKt__CollectionsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class DecodeHelper {
    public static final int $stable = 8;
    private final Parcel parcel;

    public DecodeHelper(@NotNull String str) {
        Parcel parcelObtain = Parcel.obtain();
        this.parcel = parcelObtain;
        byte[] bArrDecode = Base64.decode(str, 0);
        parcelObtain.unmarshall(bArrDecode, 0, bArrDecode.length);
        parcelObtain.setDataPosition(0);
    }

    public final SpanStyle decodeSpanStyle() {
        MutableSpanStyle mutableSpanStyle;
        MutableSpanStyle mutableSpanStyle2 = mutableSpanStyle;
        MutableSpanStyle mutableSpanStyle3 = new MutableSpanStyle(0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, 16383, null);
        while (this.parcel.dataAvail() > 1) {
            byte bDecodeByte = decodeByte();
            if (bDecodeByte != 1) {
                mutableSpanStyle = mutableSpanStyle2;
                if (bDecodeByte == 2) {
                    if (dataAvailable() >= 5) {
                        mutableSpanStyle.m2905setFontSizeR2X_6o(m2875decodeTextUnitXSAIIZE());
                        mutableSpanStyle2 = mutableSpanStyle;
                    } else {
                        return mutableSpanStyle.toSpanStyle();
                    }
                } else if (bDecodeByte == 3) {
                    if (dataAvailable() >= 4) {
                        mutableSpanStyle.setFontWeight(decodeFontWeight());
                        mutableSpanStyle2 = mutableSpanStyle;
                    } else {
                        return mutableSpanStyle.toSpanStyle();
                    }
                } else if (bDecodeByte == 4) {
                    if (dataAvailable() >= 1) {
                        mutableSpanStyle.m2906setFontStylemLjRB2g(FontStyle.m3242boximpl(m2873decodeFontStyle_LCdwA()));
                        mutableSpanStyle2 = mutableSpanStyle;
                    } else {
                        return mutableSpanStyle.toSpanStyle();
                    }
                } else if (bDecodeByte != 5) {
                    if (bDecodeByte == 6) {
                        mutableSpanStyle.setFontFeatureSettings(decodeString());
                    } else if (bDecodeByte == 7) {
                        if (dataAvailable() >= 5) {
                            mutableSpanStyle.m2908setLetterSpacingR2X_6o(m2875decodeTextUnitXSAIIZE());
                        } else {
                            return mutableSpanStyle.toSpanStyle();
                        }
                    } else if (bDecodeByte == 8) {
                        if (dataAvailable() >= 4) {
                            mutableSpanStyle.m2903setBaselineShift_isdbwI(BaselineShift.m3423boximpl(m2870decodeBaselineShifty9eOQZs()));
                        } else {
                            return mutableSpanStyle.toSpanStyle();
                        }
                    } else if (bDecodeByte == 9) {
                        if (dataAvailable() >= 8) {
                            mutableSpanStyle.setTextGeometricTransform(decodeTextGeometricTransform());
                        } else {
                            return mutableSpanStyle.toSpanStyle();
                        }
                    } else if (bDecodeByte == 10) {
                        if (dataAvailable() >= 8) {
                            mutableSpanStyle.m2902setBackground8_81llA(m2872decodeColor0d7_KjU());
                        } else {
                            return mutableSpanStyle.toSpanStyle();
                        }
                    } else if (bDecodeByte == 11) {
                        if (dataAvailable() >= 4) {
                            mutableSpanStyle.setTextDecoration(decodeTextDecoration());
                        } else {
                            return mutableSpanStyle.toSpanStyle();
                        }
                    } else if (bDecodeByte == 12) {
                        if (dataAvailable() >= 20) {
                            mutableSpanStyle.setShadow(decodeShadow());
                        } else {
                            return mutableSpanStyle.toSpanStyle();
                        }
                    }
                    mutableSpanStyle2 = mutableSpanStyle;
                } else if (dataAvailable() >= 1) {
                    mutableSpanStyle.m2907setFontSynthesistDdu0R4(FontSynthesis.m3253boximpl(m2874decodeFontSynthesisGVVA2EU()));
                    mutableSpanStyle2 = mutableSpanStyle;
                } else {
                    return mutableSpanStyle.toSpanStyle();
                }
            } else {
                if (dataAvailable() < 8) {
                    break;
                }
                mutableSpanStyle2.m2904setColor8_81llA(m2872decodeColor0d7_KjU());
            }
        }
        mutableSpanStyle = mutableSpanStyle2;
        return mutableSpanStyle.toSpanStyle();
    }

    /* JADX INFO: renamed from: decodeColor-0d7_KjU, reason: not valid java name */
    public final long m2872decodeColor0d7_KjU() {
        return Color.m1165constructorimpl(m2871decodeULongsVKNKU());
    }

    /* JADX INFO: renamed from: decodeTextUnit-XSAIIZE, reason: not valid java name */
    public final long m2875decodeTextUnitXSAIIZE() {
        long jM3877getUnspecifiedUIouoOA;
        byte bDecodeByte = decodeByte();
        if (bDecodeByte == 1) {
            jM3877getUnspecifiedUIouoOA = TextUnitType.Companion.m3876getSpUIouoOA();
        } else if (bDecodeByte == 2) {
            jM3877getUnspecifiedUIouoOA = TextUnitType.Companion.m3875getEmUIouoOA();
        } else {
            jM3877getUnspecifiedUIouoOA = TextUnitType.Companion.m3877getUnspecifiedUIouoOA();
        }
        if (TextUnitType.m3871equalsimpl0(jM3877getUnspecifiedUIouoOA, TextUnitType.Companion.m3877getUnspecifiedUIouoOA())) {
            return TextUnit.Companion.m3854getUnspecifiedXSAIIZE();
        }
        return TextUnitKt.m3855TextUnitanM5pPY(decodeFloat(), jM3877getUnspecifiedUIouoOA);
    }

    public final FontWeight decodeFontWeight() {
        return new FontWeight(decodeInt());
    }

    /* JADX INFO: renamed from: decodeFontStyle-_-LCdwA, reason: not valid java name */
    public final int m2873decodeFontStyle_LCdwA() {
        byte bDecodeByte = decodeByte();
        if (bDecodeByte == 0) {
            return FontStyle.Companion.m3252getNormal_LCdwA();
        }
        if (bDecodeByte == 1) {
            return FontStyle.Companion.m3251getItalic_LCdwA();
        }
        return FontStyle.Companion.m3252getNormal_LCdwA();
    }

    /* JADX INFO: renamed from: decodeFontSynthesis-GVVA2EU, reason: not valid java name */
    public final int m2874decodeFontSynthesisGVVA2EU() {
        byte bDecodeByte = decodeByte();
        if (bDecodeByte == 0) {
            return FontSynthesis.Companion.m3263getNoneGVVA2EU();
        }
        if (bDecodeByte == 1) {
            return FontSynthesis.Companion.m3262getAllGVVA2EU();
        }
        if (bDecodeByte == 3) {
            return FontSynthesis.Companion.m3264getStyleGVVA2EU();
        }
        if (bDecodeByte == 2) {
            return FontSynthesis.Companion.m3265getWeightGVVA2EU();
        }
        return FontSynthesis.Companion.m3263getNoneGVVA2EU();
    }

    /* JADX INFO: renamed from: decodeBaselineShift-y9eOQZs, reason: not valid java name */
    private final float m2870decodeBaselineShifty9eOQZs() {
        return BaselineShift.m3424constructorimpl(decodeFloat());
    }

    private final TextGeometricTransform decodeTextGeometricTransform() {
        return new TextGeometricTransform(decodeFloat(), decodeFloat());
    }

    private final TextDecoration decodeTextDecoration() {
        int iDecodeInt = decodeInt();
        TextDecoration.Companion companion = TextDecoration.Companion;
        boolean z = (companion.getLineThrough().getMask() & iDecodeInt) != 0;
        boolean z2 = (iDecodeInt & companion.getUnderline().getMask()) != 0;
        if (z && z2) {
            return companion.combine(CollectionsKt__CollectionsKt.listOf((Object[]) new TextDecoration[]{companion.getLineThrough(), companion.getUnderline()}));
        }
        if (z) {
            return companion.getLineThrough();
        }
        if (z2) {
            return companion.getUnderline();
        }
        return companion.getNone();
    }

    private final Shadow decodeShadow() {
        return new Shadow(m2872decodeColor0d7_KjU(), OffsetKt.Offset(decodeFloat(), decodeFloat()), decodeFloat(), null);
    }

    private final byte decodeByte() {
        return this.parcel.readByte();
    }

    private final int decodeInt() {
        return this.parcel.readInt();
    }

    /* JADX INFO: renamed from: decodeULong-s-VKNKU, reason: not valid java name */
    private final long m2871decodeULongsVKNKU() {
        return ULong.m5646constructorimpl(this.parcel.readLong());
    }

    private final float decodeFloat() {
        return this.parcel.readFloat();
    }

    private final String decodeString() {
        return this.parcel.readString();
    }

    private final int dataAvailable() {
        return this.parcel.dataAvail();
    }
}
