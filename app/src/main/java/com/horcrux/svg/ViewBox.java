package com.horcrux.svg;

import android.graphics.Matrix;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes.dex */
class ViewBox {
    private static final int MOS_MEET = 0;
    private static final int MOS_NONE = 2;
    private static final int MOS_SLICE = 1;

    ViewBox() {
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0093  */
    /* JADX WARN: Code duplicated, block: B:25:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:28:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:31:0x00bd  */
    static Matrix getTransform(RectF rectF, RectF rectF2, String str, int i) {
        double dMax;
        double d;
        double d2;
        double d3;
        double dMin;
        double d4;
        double d5 = rectF.left;
        double d6 = rectF.top;
        double dWidth = rectF.width();
        double dHeight = rectF.height();
        double d7 = rectF2.left;
        double d8 = rectF2.top;
        double dWidth2 = rectF2.width();
        double dHeight2 = rectF2.height();
        double d9 = dWidth2 / dWidth;
        double d10 = dHeight2 / dHeight;
        double d11 = d7 - (d5 * d9);
        if (i == 2) {
            dMin = Math.min(d9, d10);
            if (dMin > 1.0d) {
                d4 = d11 - (((dWidth2 / dMin) - dWidth) / 2.0d);
                dHeight2 /= dMin;
            } else {
                d4 = d11 - ((dWidth2 - (dWidth * dMin)) / 2.0d);
                dHeight *= dMin;
            }
            d3 = (d8 - (d6 * d10)) - ((dHeight2 - dHeight) / 2.0d);
            d10 = dMin;
            d = d4;
        } else {
            if (!str.equals("none") && i == 0) {
                dMax = Math.min(d9, d10);
            } else {
                if (!str.equals("none") && i == 1) {
                    dMax = Math.max(d9, d10);
                }
                d = d7 - (d5 * d9);
                d2 = d8 - (d6 * d10);
                if (str.contains("xMid")) {
                    d += (dWidth2 - (dWidth * d9)) / 2.0d;
                }
                if (str.contains("xMax")) {
                    d += dWidth2 - (dWidth * d9);
                }
                if (str.contains("YMid")) {
                    d2 += (dHeight2 - (dHeight * d10)) / 2.0d;
                }
                if (str.contains("YMax")) {
                    d2 += dHeight2 - (dHeight * d10);
                }
                d3 = d2;
                dMin = d9;
            }
            d9 = dMax;
            d10 = d9;
            d = d7 - (d5 * d9);
            d2 = d8 - (d6 * d10);
            if (str.contains("xMid")) {
                d += (dWidth2 - (dWidth * d9)) / 2.0d;
            }
            if (str.contains("xMax")) {
                d += dWidth2 - (dWidth * d9);
            }
            if (str.contains("YMid")) {
                d2 += (dHeight2 - (dHeight * d10)) / 2.0d;
            }
            if (str.contains("YMax")) {
                d2 += dHeight2 - (dHeight * d10);
            }
            d3 = d2;
            dMin = d9;
        }
        Matrix matrix = new Matrix();
        matrix.postTranslate((float) d, (float) d3);
        matrix.preScale((float) dMin, (float) d10);
        return matrix;
    }
}
