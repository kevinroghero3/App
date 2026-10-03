package androidx.compose.ui.graphics;

import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.collection.ScatterMapKt;
import androidx.compose.ui.graphics.colorspace.ColorModel;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.DoubleFunction;
import androidx.compose.ui.graphics.colorspace.Rgb;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.ULong;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.ws.WebSocketProtocol;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class ColorKt {
    public static final long UnspecifiedColor = 16;

    private static final float compositeComponent(float f, float f2, float f3, float f4, float f5) {
        if (f5 == 0.0f) {
            return 0.0f;
        }
        return ((f * f3) + ((f2 * f4) * (1.0f - f3))) / f5;
    }

    public static /* synthetic */ void getUnspecifiedColor$annotations() {
    }

    /* JADX INFO: renamed from: isSpecified-8_81llA, reason: not valid java name */
    public static final boolean m1216isSpecified8_81llA(long j) {
        return j != 16;
    }

    /* JADX INFO: renamed from: isSpecified-8_81llA$annotations, reason: not valid java name */
    public static /* synthetic */ void m1217isSpecified8_81llA$annotations(long j) {
    }

    /* JADX INFO: renamed from: isUnspecified-8_81llA, reason: not valid java name */
    public static final boolean m1218isUnspecified8_81llA(long j) {
        return j == 16;
    }

    /* JADX INFO: renamed from: isUnspecified-8_81llA$annotations, reason: not valid java name */
    public static /* synthetic */ void m1219isUnspecified8_81llA$annotations(long j) {
    }

    public static /* synthetic */ long Color$default(float f, float f2, float f3, float f4, ColorSpace colorSpace, int i, Object obj) {
        if ((i & 8) != 0) {
            f4 = 1.0f;
        }
        if ((i & 16) != 0) {
            colorSpace = ColorSpaces.INSTANCE.getSrgb();
        }
        return Color(f, f2, f3, f4, colorSpace);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x013d  */
    /* JADX WARN: Code duplicated, block: B:101:0x0145  */
    /* JADX WARN: Code duplicated, block: B:106:0x015d  */
    /* JADX WARN: Code duplicated, block: B:110:0x0164  */
    /* JADX WARN: Code duplicated, block: B:113:0x0171 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:114:0x0173  */
    /* JADX WARN: Code duplicated, block: B:115:0x0176  */
    /* JADX WARN: Code duplicated, block: B:117:0x017a  */
    /* JADX WARN: Code duplicated, block: B:119:0x017e  */
    /* JADX WARN: Code duplicated, block: B:120:0x0181 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:121:0x0183 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:122:0x0185  */
    /* JADX WARN: Code duplicated, block: B:124:0x018e  */
    /* JADX WARN: Code duplicated, block: B:126:0x0194  */
    /* JADX WARN: Code duplicated, block: B:128:0x0198  */
    /* JADX WARN: Code duplicated, block: B:130:0x019e  */
    /* JADX WARN: Code duplicated, block: B:131:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:136:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:140:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:76:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:80:0x0104  */
    /* JADX WARN: Code duplicated, block: B:83:0x0112 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:84:0x0114  */
    /* JADX WARN: Code duplicated, block: B:85:0x0117  */
    /* JADX WARN: Code duplicated, block: B:87:0x011a  */
    /* JADX WARN: Code duplicated, block: B:89:0x011e  */
    /* JADX WARN: Code duplicated, block: B:90:0x0122 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:91:0x0124 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:92:0x0126  */
    /* JADX WARN: Code duplicated, block: B:94:0x012f  */
    /* JADX WARN: Code duplicated, block: B:96:0x0134  */
    /* JADX WARN: Code duplicated, block: B:98:0x0137  */
    public static final long Color(float f, float f2, float f3, float f4, @NotNull ColorSpace colorSpace) {
        int i;
        int i2;
        int i3;
        float minValue;
        float maxValue;
        int iFloatToRawIntBits;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        float minValue2;
        float maxValue2;
        int iFloatToRawIntBits2;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        float f5;
        int i22;
        if (colorSpace.isSrgb()) {
            float f6 = f4 < 0.0f ? 0.0f : f4;
            if (f6 > 1.0f) {
                f6 = 1.0f;
            }
            int i23 = (int) ((f6 * 255.0f) + 0.5f);
            float f7 = f < 0.0f ? 0.0f : f;
            if (f7 > 1.0f) {
                f7 = 1.0f;
            }
            int i24 = (int) ((f7 * 255.0f) + 0.5f);
            float f8 = f2 < 0.0f ? 0.0f : f2;
            if (f8 > 1.0f) {
                f8 = 1.0f;
            }
            int i25 = (int) ((f8 * 255.0f) + 0.5f);
            f5 = f3 >= 0.0f ? f3 : 0.0f;
            return Color.m1165constructorimpl(ULong.m5646constructorimpl(ULong.m5646constructorimpl((((i23 << 24) | (i24 << 16)) | (i25 << 8)) | ((int) (((f5 <= 1.0f ? f5 : 1.0f) * 255.0f) + 0.5f))) << 32));
        }
        if (colorSpace.getComponentCount() != 3) {
            InlineClassHelperKt.throwIllegalArgumentException("Color only works with ColorSpaces with 3 components");
        }
        int id$ui_graphics_release = colorSpace.getId$ui_graphics_release();
        if (id$ui_graphics_release == -1) {
            InlineClassHelperKt.throwIllegalArgumentException("Unknown color space, please use a color space in ColorSpaces");
        }
        float minValue3 = colorSpace.getMinValue(0);
        float maxValue3 = colorSpace.getMaxValue(0);
        if (f >= minValue3) {
            minValue3 = f;
        }
        if (minValue3 <= maxValue3) {
            maxValue3 = minValue3;
        }
        int iFloatToRawIntBits3 = Float.floatToRawIntBits(maxValue3);
        int i26 = iFloatToRawIntBits3 >>> 31;
        int i27 = (iFloatToRawIntBits3 >>> 23) & 255;
        int i28 = iFloatToRawIntBits3 & 8388607;
        if (i27 == 255) {
            i2 = i28 != 0 ? 512 : 0;
            i = 31;
        } else {
            i = i27 - 112;
            if (i >= 31) {
                i2 = 0;
                i = 49;
            } else {
                if (i > 0) {
                    int i29 = i28 >> 13;
                    if ((iFloatToRawIntBits3 & 4096) != 0) {
                        i2 = ((i << 10) | i29) + 1;
                        i3 = i26 << 15;
                    } else {
                        i2 = i29;
                    }
                    short s = (short) (i2 | i3);
                    minValue = colorSpace.getMinValue(1);
                    maxValue = colorSpace.getMaxValue(1);
                    if (f2 >= minValue) {
                        minValue = f2;
                    }
                    if (minValue <= maxValue) {
                        maxValue = minValue;
                    }
                    iFloatToRawIntBits = Float.floatToRawIntBits(maxValue);
                    i4 = iFloatToRawIntBits >>> 31;
                    i5 = (iFloatToRawIntBits >>> 23) & 255;
                    i6 = iFloatToRawIntBits & 8388607;
                    if (i5 == 255) {
                        if (i6 != 0) {
                            i9 = 512;
                        } else {
                            i9 = 0;
                        }
                        i7 = 31;
                    } else {
                        i7 = i5 - 112;
                        if (i7 >= 31) {
                            i9 = 0;
                            i7 = 49;
                        } else {
                            if (i7 <= 0) {
                                i8 = i6 >> 13;
                                if ((iFloatToRawIntBits & 4096) != 0) {
                                    i9 = ((i7 << 10) | i8) + 1;
                                    i10 = i4 << 15;
                                } else {
                                    i9 = i8;
                                }
                                short s2 = (short) (i9 | i10);
                                minValue2 = colorSpace.getMinValue(2);
                                maxValue2 = colorSpace.getMaxValue(2);
                                if (f3 >= minValue2) {
                                    minValue2 = f3;
                                }
                                if (minValue2 <= maxValue2) {
                                    maxValue2 = minValue2;
                                }
                                iFloatToRawIntBits2 = Float.floatToRawIntBits(maxValue2);
                                i12 = iFloatToRawIntBits2 >>> 31;
                                i13 = (iFloatToRawIntBits2 >>> 23) & 255;
                                i14 = 8388607 & iFloatToRawIntBits2;
                                if (i13 == 255) {
                                    if (i14 != 0) {
                                        i22 = 512;
                                    } else {
                                        i22 = 0;
                                    }
                                    i17 = i22;
                                    i18 = 31;
                                } else {
                                    i15 = i13 - 112;
                                    if (i15 >= 31) {
                                        i20 = 49;
                                    } else {
                                        if (i15 <= 0) {
                                            i16 = i14 >> 13;
                                            if ((iFloatToRawIntBits2 & 4096) != 0) {
                                                i19 = (((i15 << 10) | i16) + 1) | (i12 << 15);
                                            } else {
                                                i17 = i16;
                                                i18 = i15;
                                            }
                                            short s3 = (short) i19;
                                            f5 = f4 >= 0.0f ? f4 : 0.0f;
                                            return Color.m1165constructorimpl(ULong.m5646constructorimpl((((long) id$ui_graphics_release) & 63) | ((((long) s) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) s2) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | ((((long) s3) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 16) | ((((long) ((int) (((f5 <= 1.0f ? f5 : 1.0f) * 1023.0f) + 0.5f))) & 1023) << 6)));
                                        }
                                        if (i15 >= -10) {
                                            i21 = (i14 | 8388608) >> (1 - i15);
                                            if ((i21 & 4096) != 0) {
                                                i21 += 8192;
                                            }
                                            i17 = i21 >> 13;
                                            i18 = 0;
                                        } else {
                                            i20 = 0;
                                        }
                                    }
                                    i18 = i20;
                                    i17 = 0;
                                }
                                i19 = i17 | (i18 << 10) | (i12 << 15);
                                short s4 = (short) i19;
                                if (f4 >= 0.0f) {
                                }
                                return Color.m1165constructorimpl(ULong.m5646constructorimpl((((long) id$ui_graphics_release) & 63) | ((((long) s) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) s2) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | ((((long) s4) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 16) | ((((long) ((int) (((f5 <= 1.0f ? f5 : 1.0f) * 1023.0f) + 0.5f))) & 1023) << 6)));
                            }
                            if (i7 >= -10) {
                                i11 = (i6 | 8388608) >> (1 - i7);
                                if ((i11 & 4096) != 0) {
                                    i11 += 8192;
                                }
                                i9 = i11 >> 13;
                            } else {
                                i9 = 0;
                            }
                            i7 = 0;
                        }
                    }
                    i10 = (i4 << 15) | (i7 << 10);
                    short s5 = (short) (i9 | i10);
                    minValue2 = colorSpace.getMinValue(2);
                    maxValue2 = colorSpace.getMaxValue(2);
                    if (f3 >= minValue2) {
                        minValue2 = f3;
                    }
                    if (minValue2 <= maxValue2) {
                        maxValue2 = minValue2;
                    }
                    iFloatToRawIntBits2 = Float.floatToRawIntBits(maxValue2);
                    i12 = iFloatToRawIntBits2 >>> 31;
                    i13 = (iFloatToRawIntBits2 >>> 23) & 255;
                    i14 = 8388607 & iFloatToRawIntBits2;
                    if (i13 == 255) {
                        if (i14 != 0) {
                            i22 = 512;
                        } else {
                            i22 = 0;
                        }
                        i17 = i22;
                        i18 = 31;
                    } else {
                        i15 = i13 - 112;
                        if (i15 >= 31) {
                            i20 = 49;
                        } else {
                            if (i15 <= 0) {
                                i16 = i14 >> 13;
                                if ((iFloatToRawIntBits2 & 4096) != 0) {
                                    i19 = (((i15 << 10) | i16) + 1) | (i12 << 15);
                                } else {
                                    i17 = i16;
                                    i18 = i15;
                                }
                                short s6 = (short) i19;
                                if (f4 >= 0.0f) {
                                }
                                return Color.m1165constructorimpl(ULong.m5646constructorimpl((((long) id$ui_graphics_release) & 63) | ((((long) s) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) s5) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | ((((long) s6) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 16) | ((((long) ((int) (((f5 <= 1.0f ? f5 : 1.0f) * 1023.0f) + 0.5f))) & 1023) << 6)));
                            }
                            if (i15 >= -10) {
                                i21 = (i14 | 8388608) >> (1 - i15);
                                if ((i21 & 4096) != 0) {
                                    i21 += 8192;
                                }
                                i17 = i21 >> 13;
                                i18 = 0;
                            } else {
                                i20 = 0;
                            }
                        }
                        i18 = i20;
                        i17 = 0;
                    }
                    i19 = i17 | (i18 << 10) | (i12 << 15);
                    short s7 = (short) i19;
                    if (f4 >= 0.0f) {
                    }
                    return Color.m1165constructorimpl(ULong.m5646constructorimpl((((long) id$ui_graphics_release) & 63) | ((((long) s) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) s5) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | ((((long) s7) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 16) | ((((long) ((int) (((f5 <= 1.0f ? f5 : 1.0f) * 1023.0f) + 0.5f))) & 1023) << 6)));
                }
                if (i >= -10) {
                    int i30 = (i28 | 8388608) >> (1 - i);
                    if ((i30 & 4096) != 0) {
                        i30 += 8192;
                    }
                    i2 = i30 >> 13;
                } else {
                    i2 = 0;
                }
                i = 0;
            }
        }
        i3 = (i26 << 15) | (i << 10);
        short s8 = (short) (i2 | i3);
        minValue = colorSpace.getMinValue(1);
        maxValue = colorSpace.getMaxValue(1);
        if (f2 >= minValue) {
            minValue = f2;
        }
        if (minValue <= maxValue) {
            maxValue = minValue;
        }
        iFloatToRawIntBits = Float.floatToRawIntBits(maxValue);
        i4 = iFloatToRawIntBits >>> 31;
        i5 = (iFloatToRawIntBits >>> 23) & 255;
        i6 = iFloatToRawIntBits & 8388607;
        if (i5 == 255) {
            if (i6 != 0) {
                i9 = 512;
            } else {
                i9 = 0;
            }
            i7 = 31;
        } else {
            i7 = i5 - 112;
            if (i7 >= 31) {
                i9 = 0;
                i7 = 49;
            } else {
                if (i7 <= 0) {
                    i8 = i6 >> 13;
                    if ((iFloatToRawIntBits & 4096) != 0) {
                        i9 = ((i7 << 10) | i8) + 1;
                        i10 = i4 << 15;
                    } else {
                        i9 = i8;
                    }
                    short s9 = (short) (i9 | i10);
                    minValue2 = colorSpace.getMinValue(2);
                    maxValue2 = colorSpace.getMaxValue(2);
                    if (f3 >= minValue2) {
                        minValue2 = f3;
                    }
                    if (minValue2 <= maxValue2) {
                        maxValue2 = minValue2;
                    }
                    iFloatToRawIntBits2 = Float.floatToRawIntBits(maxValue2);
                    i12 = iFloatToRawIntBits2 >>> 31;
                    i13 = (iFloatToRawIntBits2 >>> 23) & 255;
                    i14 = 8388607 & iFloatToRawIntBits2;
                    if (i13 == 255) {
                        if (i14 != 0) {
                            i22 = 512;
                        } else {
                            i22 = 0;
                        }
                        i17 = i22;
                        i18 = 31;
                    } else {
                        i15 = i13 - 112;
                        if (i15 >= 31) {
                            i20 = 49;
                        } else {
                            if (i15 <= 0) {
                                i16 = i14 >> 13;
                                if ((iFloatToRawIntBits2 & 4096) != 0) {
                                    i19 = (((i15 << 10) | i16) + 1) | (i12 << 15);
                                } else {
                                    i17 = i16;
                                    i18 = i15;
                                }
                                short s10 = (short) i19;
                                if (f4 >= 0.0f) {
                                }
                                return Color.m1165constructorimpl(ULong.m5646constructorimpl((((long) id$ui_graphics_release) & 63) | ((((long) s8) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) s9) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | ((((long) s10) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 16) | ((((long) ((int) (((f5 <= 1.0f ? f5 : 1.0f) * 1023.0f) + 0.5f))) & 1023) << 6)));
                            }
                            if (i15 >= -10) {
                                i21 = (i14 | 8388608) >> (1 - i15);
                                if ((i21 & 4096) != 0) {
                                    i21 += 8192;
                                }
                                i17 = i21 >> 13;
                                i18 = 0;
                            } else {
                                i20 = 0;
                            }
                        }
                        i18 = i20;
                        i17 = 0;
                    }
                    i19 = i17 | (i18 << 10) | (i12 << 15);
                    short s11 = (short) i19;
                    if (f4 >= 0.0f) {
                    }
                    return Color.m1165constructorimpl(ULong.m5646constructorimpl((((long) id$ui_graphics_release) & 63) | ((((long) s8) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) s9) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | ((((long) s11) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 16) | ((((long) ((int) (((f5 <= 1.0f ? f5 : 1.0f) * 1023.0f) + 0.5f))) & 1023) << 6)));
                }
                if (i7 >= -10) {
                    i11 = (i6 | 8388608) >> (1 - i7);
                    if ((i11 & 4096) != 0) {
                        i11 += 8192;
                    }
                    i9 = i11 >> 13;
                } else {
                    i9 = 0;
                }
                i7 = 0;
            }
        }
        i10 = (i4 << 15) | (i7 << 10);
        short s12 = (short) (i9 | i10);
        minValue2 = colorSpace.getMinValue(2);
        maxValue2 = colorSpace.getMaxValue(2);
        if (f3 >= minValue2) {
            minValue2 = f3;
        }
        if (minValue2 <= maxValue2) {
            maxValue2 = minValue2;
        }
        iFloatToRawIntBits2 = Float.floatToRawIntBits(maxValue2);
        i12 = iFloatToRawIntBits2 >>> 31;
        i13 = (iFloatToRawIntBits2 >>> 23) & 255;
        i14 = 8388607 & iFloatToRawIntBits2;
        if (i13 == 255) {
            if (i14 != 0) {
                i22 = 512;
            } else {
                i22 = 0;
            }
            i17 = i22;
            i18 = 31;
        } else {
            i15 = i13 - 112;
            if (i15 >= 31) {
                i20 = 49;
            } else {
                if (i15 <= 0) {
                    i16 = i14 >> 13;
                    if ((iFloatToRawIntBits2 & 4096) != 0) {
                        i19 = (((i15 << 10) | i16) + 1) | (i12 << 15);
                    } else {
                        i17 = i16;
                        i18 = i15;
                    }
                    short s13 = (short) i19;
                    if (f4 >= 0.0f) {
                    }
                    return Color.m1165constructorimpl(ULong.m5646constructorimpl((((long) id$ui_graphics_release) & 63) | ((((long) s8) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) s12) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | ((((long) s13) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 16) | ((((long) ((int) (((f5 <= 1.0f ? f5 : 1.0f) * 1023.0f) + 0.5f))) & 1023) << 6)));
                }
                if (i15 >= -10) {
                    i21 = (i14 | 8388608) >> (1 - i15);
                    if ((i21 & 4096) != 0) {
                        i21 += 8192;
                    }
                    i17 = i21 >> 13;
                    i18 = 0;
                } else {
                    i20 = 0;
                }
            }
            i18 = i20;
            i17 = 0;
        }
        i19 = i17 | (i18 << 10) | (i12 << 15);
        short s14 = (short) i19;
        if (f4 >= 0.0f) {
        }
        return Color.m1165constructorimpl(ULong.m5646constructorimpl((((long) id$ui_graphics_release) & 63) | ((((long) s8) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) s12) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | ((((long) s14) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 16) | ((((long) ((int) (((f5 <= 1.0f ? f5 : 1.0f) * 1023.0f) + 0.5f))) & 1023) << 6)));
    }

    public static /* synthetic */ long UncheckedColor$default(float f, float f2, float f3, float f4, ColorSpace colorSpace, int i, Object obj) {
        if ((i & 8) != 0) {
            f4 = 1.0f;
        }
        if ((i & 16) != 0) {
            colorSpace = ColorSpaces.INSTANCE.getSrgb();
        }
        return UncheckedColor(f, f2, f3, f4, colorSpace);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x009a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:30:0x009c  */
    /* JADX WARN: Code duplicated, block: B:31:0x009e  */
    /* JADX WARN: Code duplicated, block: B:33:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:35:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:36:0x00a9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:37:0x00ab A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:38:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:40:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:42:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:43:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:45:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:46:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:50:0x00e3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:52:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:54:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:56:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:57:0x00f1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:58:0x00f3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:59:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:61:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:63:0x0105  */
    /* JADX WARN: Code duplicated, block: B:64:0x0107  */
    /* JADX WARN: Code duplicated, block: B:66:0x010d  */
    public static final long UncheckedColor(float f, float f2, float f3, float f4, @NotNull ColorSpace colorSpace) {
        int i;
        int i2;
        int i3;
        int iFloatToRawIntBits;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int iFloatToRawIntBits2;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        if (colorSpace.isSrgb()) {
            return Color.m1165constructorimpl(ULong.m5646constructorimpl(ULong.m5646constructorimpl((((((int) ((f4 * 255.0f) + 0.5f)) << 24) | (((int) ((f * 255.0f) + 0.5f)) << 16)) | (((int) ((f2 * 255.0f) + 0.5f)) << 8)) | ((int) ((255.0f * f3) + 0.5f))) << 32));
        }
        int iFloatToRawIntBits3 = Float.floatToRawIntBits(f);
        int i18 = iFloatToRawIntBits3 >>> 31;
        int i19 = (iFloatToRawIntBits3 >>> 23) & 255;
        int i20 = iFloatToRawIntBits3 & 8388607;
        int i21 = 0;
        if (i19 == 255) {
            i2 = i20 != 0 ? 512 : 0;
            i = 31;
        } else {
            i = i19 - 112;
            if (i >= 31) {
                i2 = 0;
                i = 49;
            } else {
                if (i > 0) {
                    int i22 = i20 >> 13;
                    if ((iFloatToRawIntBits3 & 4096) != 0) {
                        i2 = ((i << 10) | i22) + 1;
                        i3 = i18 << 15;
                    } else {
                        i2 = i22;
                    }
                    short s = (short) (i2 | i3);
                    iFloatToRawIntBits = Float.floatToRawIntBits(f2);
                    i4 = iFloatToRawIntBits >>> 31;
                    i5 = (iFloatToRawIntBits >>> 23) & 255;
                    i6 = iFloatToRawIntBits & 8388607;
                    if (i5 == 255) {
                        if (i6 != 0) {
                            i9 = 512;
                        } else {
                            i9 = 0;
                        }
                        i7 = 31;
                    } else {
                        i7 = i5 - 112;
                        if (i7 >= 31) {
                            i9 = 0;
                            i7 = 49;
                        } else {
                            if (i7 <= 0) {
                                i8 = i6 >> 13;
                                if ((iFloatToRawIntBits & 4096) != 0) {
                                    i9 = ((i7 << 10) | i8) + 1;
                                    i10 = i4 << 15;
                                } else {
                                    i9 = i8;
                                }
                                short s2 = (short) (i9 | i10);
                                iFloatToRawIntBits2 = Float.floatToRawIntBits(f3);
                                i12 = iFloatToRawIntBits2 >>> 31;
                                i13 = (iFloatToRawIntBits2 >>> 23) & 255;
                                i14 = 8388607 & iFloatToRawIntBits2;
                                if (i13 == 255) {
                                    i21 = i14 == 0 ? 0 : 512;
                                    i15 = 31;
                                } else {
                                    i15 = i13 - 112;
                                    if (i15 >= 31) {
                                        i15 = 49;
                                    } else {
                                        if (i15 <= 0) {
                                            i21 = i14 >> 13;
                                            if ((iFloatToRawIntBits2 & 4096) != 0) {
                                                i16 = (((i15 << 10) | i21) + 1) | (i12 << 15);
                                            }
                                            return Color.m1165constructorimpl(ULong.m5646constructorimpl(((((long) ((int) ((Math.max(0.0f, Math.min(f4, 1.0f)) * 1023.0f) + 0.5f))) & 1023) << 6) | ((((long) ((short) i16)) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 16) | ((((long) s) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) s2) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | (63 & ((long) colorSpace.getId$ui_graphics_release()))));
                                        }
                                        if (i15 >= -10) {
                                            i17 = (i14 | 8388608) >> (1 - i15);
                                            if ((i17 & 4096) != 0) {
                                                i17 += 8192;
                                            }
                                            i15 = 0;
                                            i21 = i17 >> 13;
                                        } else {
                                            i15 = 0;
                                        }
                                    }
                                }
                                i16 = (i12 << 15) | (i15 << 10) | i21;
                                return Color.m1165constructorimpl(ULong.m5646constructorimpl(((((long) ((int) ((Math.max(0.0f, Math.min(f4, 1.0f)) * 1023.0f) + 0.5f))) & 1023) << 6) | ((((long) ((short) i16)) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 16) | ((((long) s) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) s2) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | (63 & ((long) colorSpace.getId$ui_graphics_release()))));
                            }
                            if (i7 >= -10) {
                                i11 = (i6 | 8388608) >> (1 - i7);
                                if ((i11 & 4096) != 0) {
                                    i11 += 8192;
                                }
                                i9 = i11 >> 13;
                                i7 = 0;
                            } else {
                                i9 = 0;
                                i7 = 0;
                            }
                        }
                    }
                    i10 = (i4 << 15) | (i7 << 10);
                    short s3 = (short) (i9 | i10);
                    iFloatToRawIntBits2 = Float.floatToRawIntBits(f3);
                    i12 = iFloatToRawIntBits2 >>> 31;
                    i13 = (iFloatToRawIntBits2 >>> 23) & 255;
                    i14 = 8388607 & iFloatToRawIntBits2;
                    if (i13 == 255) {
                        i21 = i14 == 0 ? 0 : 512;
                        i15 = 31;
                    } else {
                        i15 = i13 - 112;
                        if (i15 >= 31) {
                            i15 = 49;
                        } else {
                            if (i15 <= 0) {
                                i21 = i14 >> 13;
                                if ((iFloatToRawIntBits2 & 4096) != 0) {
                                    i16 = (((i15 << 10) | i21) + 1) | (i12 << 15);
                                }
                                return Color.m1165constructorimpl(ULong.m5646constructorimpl(((((long) ((int) ((Math.max(0.0f, Math.min(f4, 1.0f)) * 1023.0f) + 0.5f))) & 1023) << 6) | ((((long) ((short) i16)) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 16) | ((((long) s) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) s3) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | (63 & ((long) colorSpace.getId$ui_graphics_release()))));
                            }
                            if (i15 >= -10) {
                                i17 = (i14 | 8388608) >> (1 - i15);
                                if ((i17 & 4096) != 0) {
                                    i17 += 8192;
                                }
                                i15 = 0;
                                i21 = i17 >> 13;
                            } else {
                                i15 = 0;
                            }
                        }
                    }
                    i16 = (i12 << 15) | (i15 << 10) | i21;
                    return Color.m1165constructorimpl(ULong.m5646constructorimpl(((((long) ((int) ((Math.max(0.0f, Math.min(f4, 1.0f)) * 1023.0f) + 0.5f))) & 1023) << 6) | ((((long) ((short) i16)) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 16) | ((((long) s) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) s3) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | (63 & ((long) colorSpace.getId$ui_graphics_release()))));
                }
                if (i >= -10) {
                    int i23 = (i20 | 8388608) >> (1 - i);
                    if ((i23 & 4096) != 0) {
                        i23 += 8192;
                    }
                    i2 = i23 >> 13;
                    i = 0;
                } else {
                    i2 = 0;
                    i = 0;
                }
            }
        }
        i3 = (i18 << 15) | (i << 10);
        short s4 = (short) (i2 | i3);
        iFloatToRawIntBits = Float.floatToRawIntBits(f2);
        i4 = iFloatToRawIntBits >>> 31;
        i5 = (iFloatToRawIntBits >>> 23) & 255;
        i6 = iFloatToRawIntBits & 8388607;
        if (i5 == 255) {
            if (i6 != 0) {
                i9 = 512;
            } else {
                i9 = 0;
            }
            i7 = 31;
        } else {
            i7 = i5 - 112;
            if (i7 >= 31) {
                i9 = 0;
                i7 = 49;
            } else {
                if (i7 <= 0) {
                    i8 = i6 >> 13;
                    if ((iFloatToRawIntBits & 4096) != 0) {
                        i9 = ((i7 << 10) | i8) + 1;
                        i10 = i4 << 15;
                    } else {
                        i9 = i8;
                    }
                    short s5 = (short) (i9 | i10);
                    iFloatToRawIntBits2 = Float.floatToRawIntBits(f3);
                    i12 = iFloatToRawIntBits2 >>> 31;
                    i13 = (iFloatToRawIntBits2 >>> 23) & 255;
                    i14 = 8388607 & iFloatToRawIntBits2;
                    if (i13 == 255) {
                        i21 = i14 == 0 ? 0 : 512;
                        i15 = 31;
                    } else {
                        i15 = i13 - 112;
                        if (i15 >= 31) {
                            i15 = 49;
                        } else {
                            if (i15 <= 0) {
                                i21 = i14 >> 13;
                                if ((iFloatToRawIntBits2 & 4096) != 0) {
                                    i16 = (((i15 << 10) | i21) + 1) | (i12 << 15);
                                }
                                return Color.m1165constructorimpl(ULong.m5646constructorimpl(((((long) ((int) ((Math.max(0.0f, Math.min(f4, 1.0f)) * 1023.0f) + 0.5f))) & 1023) << 6) | ((((long) ((short) i16)) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 16) | ((((long) s4) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) s5) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | (63 & ((long) colorSpace.getId$ui_graphics_release()))));
                            }
                            if (i15 >= -10) {
                                i17 = (i14 | 8388608) >> (1 - i15);
                                if ((i17 & 4096) != 0) {
                                    i17 += 8192;
                                }
                                i15 = 0;
                                i21 = i17 >> 13;
                            } else {
                                i15 = 0;
                            }
                        }
                    }
                    i16 = (i12 << 15) | (i15 << 10) | i21;
                    return Color.m1165constructorimpl(ULong.m5646constructorimpl(((((long) ((int) ((Math.max(0.0f, Math.min(f4, 1.0f)) * 1023.0f) + 0.5f))) & 1023) << 6) | ((((long) ((short) i16)) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 16) | ((((long) s4) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) s5) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | (63 & ((long) colorSpace.getId$ui_graphics_release()))));
                }
                if (i7 >= -10) {
                    i11 = (i6 | 8388608) >> (1 - i7);
                    if ((i11 & 4096) != 0) {
                        i11 += 8192;
                    }
                    i9 = i11 >> 13;
                    i7 = 0;
                } else {
                    i9 = 0;
                    i7 = 0;
                }
            }
        }
        i10 = (i4 << 15) | (i7 << 10);
        short s6 = (short) (i9 | i10);
        iFloatToRawIntBits2 = Float.floatToRawIntBits(f3);
        i12 = iFloatToRawIntBits2 >>> 31;
        i13 = (iFloatToRawIntBits2 >>> 23) & 255;
        i14 = 8388607 & iFloatToRawIntBits2;
        if (i13 == 255) {
            i21 = i14 == 0 ? 0 : 512;
            i15 = 31;
        } else {
            i15 = i13 - 112;
            if (i15 >= 31) {
                i15 = 49;
            } else {
                if (i15 <= 0) {
                    i21 = i14 >> 13;
                    if ((iFloatToRawIntBits2 & 4096) != 0) {
                        i16 = (((i15 << 10) | i21) + 1) | (i12 << 15);
                    }
                    return Color.m1165constructorimpl(ULong.m5646constructorimpl(((((long) ((int) ((Math.max(0.0f, Math.min(f4, 1.0f)) * 1023.0f) + 0.5f))) & 1023) << 6) | ((((long) ((short) i16)) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 16) | ((((long) s4) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) s6) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | (63 & ((long) colorSpace.getId$ui_graphics_release()))));
                }
                if (i15 >= -10) {
                    i17 = (i14 | 8388608) >> (1 - i15);
                    if ((i17 & 4096) != 0) {
                        i17 += 8192;
                    }
                    i15 = 0;
                    i21 = i17 >> 13;
                } else {
                    i15 = 0;
                }
            }
        }
        i16 = (i12 << 15) | (i15 << 10) | i21;
        return Color.m1165constructorimpl(ULong.m5646constructorimpl(((((long) ((int) ((Math.max(0.0f, Math.min(f4, 1.0f)) * 1023.0f) + 0.5f))) & 1023) << 6) | ((((long) ((short) i16)) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 16) | ((((long) s4) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) s6) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | (63 & ((long) colorSpace.getId$ui_graphics_release()))));
    }

    public static final long Color(@ColorInt int i) {
        return Color.m1165constructorimpl(ULong.m5646constructorimpl(ULong.m5646constructorimpl(i) << 32));
    }

    public static final long Color(long j) {
        return Color.m1165constructorimpl(ULong.m5646constructorimpl(j << 32));
    }

    public static /* synthetic */ long Color$default(int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 8) != 0) {
            i4 = 255;
        }
        return Color(i, i2, i3, i4);
    }

    public static final long Color(@IntRange(from = 0, to = ScatterMapKt.Sentinel) int i, @IntRange(from = 0, to = ScatterMapKt.Sentinel) int i2, @IntRange(from = 0, to = ScatterMapKt.Sentinel) int i3, @IntRange(from = 0, to = ScatterMapKt.Sentinel) int i4) {
        return Color(((i & 255) << 16) | ((i4 & 255) << 24) | ((i2 & 255) << 8) | (i3 & 255));
    }

    /* JADX INFO: renamed from: lerp-jxsXWHM, reason: not valid java name */
    public static final long m1220lerpjxsXWHM(long j, long j2, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        ColorSpace oklab = ColorSpaces.INSTANCE.getOklab();
        long jM1166convertvNxB06k = Color.m1166convertvNxB06k(j, oklab);
        long jM1166convertvNxB06k2 = Color.m1166convertvNxB06k(j2, oklab);
        float fM1171getAlphaimpl = Color.m1171getAlphaimpl(jM1166convertvNxB06k);
        float fM1175getRedimpl = Color.m1175getRedimpl(jM1166convertvNxB06k);
        float fM1174getGreenimpl = Color.m1174getGreenimpl(jM1166convertvNxB06k);
        float fM1172getBlueimpl = Color.m1172getBlueimpl(jM1166convertvNxB06k);
        float fM1171getAlphaimpl2 = Color.m1171getAlphaimpl(jM1166convertvNxB06k2);
        float fM1175getRedimpl2 = Color.m1175getRedimpl(jM1166convertvNxB06k2);
        float fM1174getGreenimpl2 = Color.m1174getGreenimpl(jM1166convertvNxB06k2);
        float fM1172getBlueimpl2 = Color.m1172getBlueimpl(jM1166convertvNxB06k2);
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        return Color.m1166convertvNxB06k(UncheckedColor(MathHelpersKt.lerp(fM1175getRedimpl, fM1175getRedimpl2, f), MathHelpersKt.lerp(fM1174getGreenimpl, fM1174getGreenimpl2, f), MathHelpersKt.lerp(fM1172getBlueimpl, fM1172getBlueimpl2, f), MathHelpersKt.lerp(fM1171getAlphaimpl, fM1171getAlphaimpl2, f), oklab), Color.m1173getColorSpaceimpl(j2));
    }

    /* JADX INFO: renamed from: compositeOver--OWjLjI, reason: not valid java name */
    public static final long m1214compositeOverOWjLjI(long j, long j2) {
        long jM1166convertvNxB06k = Color.m1166convertvNxB06k(j, Color.m1173getColorSpaceimpl(j2));
        float fM1171getAlphaimpl = Color.m1171getAlphaimpl(j2);
        float fM1171getAlphaimpl2 = Color.m1171getAlphaimpl(jM1166convertvNxB06k);
        float f = 1.0f - fM1171getAlphaimpl2;
        float f2 = (fM1171getAlphaimpl * f) + fM1171getAlphaimpl2;
        return UncheckedColor(f2 == 0.0f ? 0.0f : ((Color.m1175getRedimpl(jM1166convertvNxB06k) * fM1171getAlphaimpl2) + ((Color.m1175getRedimpl(j2) * fM1171getAlphaimpl) * f)) / f2, f2 == 0.0f ? 0.0f : ((Color.m1174getGreenimpl(jM1166convertvNxB06k) * fM1171getAlphaimpl2) + ((Color.m1174getGreenimpl(j2) * fM1171getAlphaimpl) * f)) / f2, f2 != 0.0f ? ((Color.m1172getBlueimpl(jM1166convertvNxB06k) * fM1171getAlphaimpl2) + ((Color.m1172getBlueimpl(j2) * fM1171getAlphaimpl) * f)) / f2 : 0.0f, f2, Color.m1173getColorSpaceimpl(j2));
    }

    /* JADX INFO: renamed from: getComponents-8_81llA, reason: not valid java name */
    private static final float[] m1215getComponents8_81llA(long j) {
        return new float[]{Color.m1175getRedimpl(j), Color.m1174getGreenimpl(j), Color.m1172getBlueimpl(j), Color.m1171getAlphaimpl(j)};
    }

    /* JADX INFO: renamed from: luminance-8_81llA, reason: not valid java name */
    public static final float m1221luminance8_81llA(long j) {
        ColorSpace colorSpaceM1173getColorSpaceimpl = Color.m1173getColorSpaceimpl(j);
        if (!ColorModel.m1578equalsimpl0(colorSpaceM1173getColorSpaceimpl.m1587getModelxdoWZVw(), ColorModel.Companion.m1585getRgbxdoWZVw())) {
            InlineClassHelperKt.throwIllegalArgumentException("The specified color must be encoded in an RGB color space. The supplied color space is " + ((Object) ColorModel.m1581toStringimpl(colorSpaceM1173getColorSpaceimpl.m1587getModelxdoWZVw())));
        }
        Intrinsics.checkNotNull(colorSpaceM1173getColorSpaceimpl, "null cannot be cast to non-null type androidx.compose.ui.graphics.colorspace.Rgb");
        DoubleFunction eotfFunc$ui_graphics_release = ((Rgb) colorSpaceM1173getColorSpaceimpl).getEotfFunc$ui_graphics_release();
        float fInvoke = (float) ((eotfFunc$ui_graphics_release.invoke(Color.m1175getRedimpl(j)) * 0.2126d) + (eotfFunc$ui_graphics_release.invoke(Color.m1174getGreenimpl(j)) * 0.7152d) + (eotfFunc$ui_graphics_release.invoke(Color.m1172getBlueimpl(j)) * 0.0722d));
        if (fInvoke < 0.0f) {
            fInvoke = 0.0f;
        }
        if (fInvoke > 1.0f) {
            return 1.0f;
        }
        return fInvoke;
    }

    /* JADX INFO: renamed from: toArgb-8_81llA, reason: not valid java name */
    public static final int m1223toArgb8_81llA(long j) {
        return (int) ULong.m5646constructorimpl(Color.m1166convertvNxB06k(j, ColorSpaces.INSTANCE.getSrgb()) >>> 32);
    }

    /* JADX INFO: renamed from: takeOrElse-DxMtmZc, reason: not valid java name */
    public static final long m1222takeOrElseDxMtmZc(long j, @NotNull Function0<Color> function0) {
        return j != 16 ? j : function0.invoke().m1179unboximpl();
    }
}
