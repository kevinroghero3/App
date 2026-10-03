package com.horcrux.svg;

import android.content.res.AssetManager;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewParent;
import androidx.compose.ui.text.font.TypefaceBuilderCompat$$ExternalSyntheticApiModelOutline3;
import androidx.compose.ui.text.font.TypefaceBuilderCompat$$ExternalSyntheticApiModelOutline7;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.views.text.ReactFontManager;
import java.text.Bidi;
import java.util.ArrayList;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
class TSpanView extends TextView {
    private static final String FONTS = "fonts/";
    private static final String OTF = ".otf";
    private static final String TTF = ".ttf";
    static final String additionalLigatures = "'hlig', 'cala', ";
    static final String defaultFeatures = "'rlig', 'liga', 'clig', 'calt', 'locl', 'ccmp', 'mark', 'mkmk','kern', ";
    static final String disableDiscretionaryLigatures = "'liga' 0, 'clig' 0, 'dlig' 0, 'hlig' 0, 'cala' 0, ";
    static final String fontWeightTag = "'wght' ";
    private static final double radToDeg = 57.29577951308232d;
    static final String requiredFontFeatures = "'rlig', 'liga', 'clig', 'calt', 'locl', 'ccmp', 'mark', 'mkmk',";
    private static final double tau = 6.283185307179586d;
    private final AssetManager assets;
    private final ArrayList<String> emoji;
    private final ArrayList<Matrix> emojiTransforms;
    private Path mCachedPath;

    @Nullable
    String mContent;
    private TextPathView textPath;

    public TSpanView(ReactContext reactContext) {
        super(reactContext);
        this.emoji = new ArrayList<>();
        this.emojiTransforms = new ArrayList<>();
        this.assets = this.mContext.getResources().getAssets();
    }

    public void setContent(@Nullable String str) {
        this.mContent = str;
        invalidate();
    }

    @Override // com.horcrux.svg.TextView, com.horcrux.svg.VirtualView, android.view.View
    public void invalidate() {
        this.mCachedPath = null;
        super.invalidate();
    }

    @Override // com.horcrux.svg.TextView, com.horcrux.svg.VirtualView
    void clearCache() {
        this.mCachedPath = null;
        super.clearCache();
    }

    @Override // com.horcrux.svg.TextView, com.horcrux.svg.GroupView, com.horcrux.svg.RenderableView, com.horcrux.svg.VirtualView
    void draw(Canvas canvas, Paint paint, float f) {
        if (this.mContent != null) {
            SVGLength sVGLength = this.mInlineSize;
            if (sVGLength != null && sVGLength.value != 0.0d) {
                if (setupFillPaint(paint, this.fillOpacity * f)) {
                    drawWrappedText(canvas, paint);
                }
                if (setupStrokePaint(paint, f * this.strokeOpacity)) {
                    drawWrappedText(canvas, paint);
                    return;
                }
                return;
            }
            int size = this.emoji.size();
            if (size > 0) {
                applyTextPropertiesToPaint(paint, getTextRootGlyphContext().getFont());
                for (int i = 0; i < size; i++) {
                    String str = this.emoji.get(i);
                    Matrix matrix = this.emojiTransforms.get(i);
                    canvas.save();
                    canvas.concat(matrix);
                    canvas.drawText(str, 0.0f, 0.0f, paint);
                    canvas.restore();
                }
            }
            drawPath(canvas, paint, f);
            return;
        }
        clip(canvas, paint);
        drawGroup(canvas, paint, f);
    }

    private void drawWrappedText(Canvas canvas, Paint paint) {
        Layout.Alignment alignment;
        GlyphContext textRootGlyphContext = getTextRootGlyphContext();
        pushGlyphContext();
        FontData font = textRootGlyphContext.getFont();
        TextPaint textPaint = new TextPaint(paint);
        applyTextPropertiesToPaint(textPaint, font);
        applySpacingAndFeatures(textPaint, font);
        double fontSize = textRootGlyphContext.getFontSize();
        int i = AnonymousClass1.$SwitchMap$com$horcrux$svg$TextProperties$TextAnchor[font.textAnchor.ordinal()];
        if (i == 2) {
            alignment = Layout.Alignment.ALIGN_CENTER;
        } else if (i != 3) {
            alignment = Layout.Alignment.ALIGN_NORMAL;
        } else {
            alignment = Layout.Alignment.ALIGN_OPPOSITE;
        }
        StaticLayout staticLayout = getStaticLayout(textPaint, alignment, true, new SpannableString(this.mContent), (int) PropHelper.fromRelative(this.mInlineSize, canvas.getWidth(), 0.0d, this.mScale, fontSize));
        int lineAscent = staticLayout.getLineAscent(0);
        float fNextX = (float) textRootGlyphContext.nextX(0.0d);
        float fNextY = (float) (textRootGlyphContext.nextY() + ((double) lineAscent));
        popGlyphContext();
        canvas.save();
        canvas.translate(fNextX, fNextY);
        staticLayout.draw(canvas);
        canvas.restore();
    }

    private StaticLayout getStaticLayout(TextPaint textPaint, Layout.Alignment alignment, boolean z, SpannableString spannableString, int i) {
        return StaticLayout.Builder.obtain(spannableString, 0, spannableString.length(), textPaint, i).setAlignment(alignment).setLineSpacing(0.0f, 1.0f).setIncludePad(z).setBreakStrategy(1).setHyphenationFrequency(1).build();
    }

    public static String visualToLogical(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        Bidi bidi = new Bidi(str, -2);
        if (bidi.isLeftToRight()) {
            return str;
        }
        int runCount = bidi.getRunCount();
        byte[] bArr = new byte[runCount];
        Integer[] numArr = new Integer[runCount];
        for (int i = 0; i < runCount; i++) {
            bArr[i] = (byte) bidi.getRunLevel(i);
            numArr[i] = Integer.valueOf(i);
        }
        Bidi.reorderVisually(bArr, 0, numArr, 0, runCount);
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < runCount; i2++) {
            int iIntValue = numArr[i2].intValue();
            int runStart = bidi.getRunStart(iIntValue);
            int runLimit = bidi.getRunLimit(iIntValue);
            if ((bArr[iIntValue] & 1) != 0) {
                while (true) {
                    runLimit--;
                    if (runLimit >= runStart) {
                        sb.append(str.charAt(runLimit));
                    }
                }
            } else {
                sb.append((CharSequence) str, runStart, runLimit);
            }
        }
        return sb.toString();
    }

    @Override // com.horcrux.svg.TextView, com.horcrux.svg.GroupView, com.horcrux.svg.RenderableView, com.horcrux.svg.VirtualView
    Path getPath(Canvas canvas, Paint paint) {
        Path path = this.mCachedPath;
        if (path != null) {
            return path;
        }
        if (this.mContent == null) {
            Path groupPath = getGroupPath(canvas, paint);
            this.mCachedPath = groupPath;
            return groupPath;
        }
        setupTextPath();
        pushGlyphContext();
        this.mCachedPath = getLinePath(visualToLogical(this.mContent), paint, canvas);
        popGlyphContext();
        return this.mCachedPath;
    }

    @Override // com.horcrux.svg.TextView
    double getSubtreeTextChunksTotalAdvance(Paint paint) {
        if (!Double.isNaN(this.cachedAdvance)) {
            return this.cachedAdvance;
        }
        String str = this.mContent;
        double subtreeTextChunksTotalAdvance = 0.0d;
        if (str == null) {
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof TextView) {
                    subtreeTextChunksTotalAdvance += ((TextView) childAt).getSubtreeTextChunksTotalAdvance(paint);
                }
            }
            this.cachedAdvance = subtreeTextChunksTotalAdvance;
            return subtreeTextChunksTotalAdvance;
        }
        if (str.length() == 0) {
            this.cachedAdvance = 0.0d;
            return 0.0d;
        }
        FontData font = getTextRootGlyphContext().getFont();
        applyTextPropertiesToPaint(paint, font);
        applySpacingAndFeatures(paint, font);
        double dMeasureText = paint.measureText(str);
        this.cachedAdvance = dMeasureText;
        return dMeasureText;
    }

    private void applySpacingAndFeatures(Paint paint, FontData fontData) {
        int i = Build.VERSION.SDK_INT;
        double d = fontData.letterSpacing;
        paint.setLetterSpacing((float) (d / (fontData.fontSize * ((double) this.mScale))));
        if (d == 0.0d && fontData.fontVariantLigatures == TextProperties.FontVariantLigatures.normal) {
            paint.setFontFeatureSettings("'rlig', 'liga', 'clig', 'calt', 'locl', 'ccmp', 'mark', 'mkmk','kern', 'hlig', 'cala', " + fontData.fontFeatureSettings);
        } else {
            paint.setFontFeatureSettings("'rlig', 'liga', 'clig', 'calt', 'locl', 'ccmp', 'mark', 'mkmk','kern', 'liga' 0, 'clig' 0, 'dlig' 0, 'hlig' 0, 'cala' 0, " + fontData.fontFeatureSettings);
        }
        if (i >= 26) {
            paint.setFontVariationSettings(fontWeightTag + fontData.absoluteFontWeight + fontData.fontVariationSettings);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:100:0x024e  */
    /* JADX WARN: Code duplicated, block: B:190:0x051b  */
    /* JADX WARN: Code duplicated, block: B:64:0x01d2  */
    private Path getLinePath(String str, Paint paint, Canvas canvas) {
        PathMeasure pathMeasure;
        boolean z;
        double d;
        double d2;
        double d3;
        boolean z2;
        int i;
        double d4;
        boolean z3;
        int i2;
        boolean z4;
        int i3;
        String str2;
        TSpanView tSpanView;
        Path path;
        PathMeasure pathMeasure2;
        float[] fArr;
        double d5;
        double d6;
        int i4;
        boolean z5;
        Paint paint2;
        float[] fArr2;
        GlyphPathBag glyphPathBag;
        boolean z6;
        double d7;
        String str3;
        boolean z7;
        Path orCreateAndCache;
        int i5;
        int i6;
        int i7;
        double d8;
        TSpanView tSpanView2 = this;
        Paint paint3 = paint;
        int length = str.length();
        Path path2 = new Path();
        tSpanView2.emoji.clear();
        tSpanView2.emojiTransforms.clear();
        if (length == 0) {
            return path2;
        }
        boolean z8 = tSpanView2.textPath != null;
        if (z8) {
            PathMeasure pathMeasure3 = new PathMeasure(tSpanView2.textPath.getTextPath(canvas, paint3), false);
            double length2 = pathMeasure3.getLength();
            boolean zIsClosed = pathMeasure3.isClosed();
            if (length2 == 0.0d) {
                return path2;
            }
            pathMeasure = pathMeasure3;
            d = length2;
            z = zIsClosed;
        } else {
            pathMeasure = null;
            z = false;
            d = 0.0d;
        }
        GlyphContext textRootGlyphContext = getTextRootGlyphContext();
        FontData font = textRootGlyphContext.getFont();
        tSpanView2.applyTextPropertiesToPaint(paint3, font);
        GlyphPathBag glyphPathBag2 = new GlyphPathBag(paint3);
        boolean[] zArr = new boolean[length];
        char[] charArray = str.toCharArray();
        double d9 = font.kerning;
        Path path3 = path2;
        double d10 = font.wordSpacing;
        double d11 = font.letterSpacing;
        boolean z9 = font.manualKerning;
        boolean z10 = d11 == 0.0d && font.fontVariantLigatures == TextProperties.FontVariantLigatures.normal;
        int i8 = Build.VERSION.SDK_INT;
        if (z10) {
            paint3.setFontFeatureSettings("'rlig', 'liga', 'clig', 'calt', 'locl', 'ccmp', 'mark', 'mkmk','kern', 'hlig', 'cala', " + font.fontFeatureSettings);
        } else {
            paint3.setFontFeatureSettings("'rlig', 'liga', 'clig', 'calt', 'locl', 'ccmp', 'mark', 'mkmk','kern', 'liga' 0, 'clig' 0, 'dlig' 0, 'hlig' 0, 'cala' 0, " + font.fontFeatureSettings);
        }
        if (i8 >= 26) {
            paint3.setFontVariationSettings(fontWeightTag + font.absoluteFontWeight + font.fontVariationSettings);
        }
        ReadableMap readableMap = font.fontData;
        float[] fArr3 = new float[length];
        paint3.getTextWidths(str, fArr3);
        TextProperties.TextAnchor textAnchor = font.textAnchor;
        PathMeasure pathMeasure4 = pathMeasure;
        double d12 = d11;
        double subtreeTextChunksTotalAdvance = getTextAnchorRoot().getSubtreeTextChunksTotalAdvance(paint3);
        double textAnchorOffset = tSpanView2.getTextAnchorOffset(textAnchor, subtreeTextChunksTotalAdvance);
        double fontSize = textRootGlyphContext.getFontSize();
        if (z8) {
            boolean z11 = tSpanView2.textPath.getMidLine() == TextProperties.TextPathMidLine.sharp;
            int i9 = tSpanView2.textPath.getSide() == TextProperties.TextPathSide.right ? -1 : 1;
            boolean z12 = z11;
            double absoluteStartOffset = getAbsoluteStartOffset(tSpanView2.textPath.getStartOffset(), d, fontSize);
            textAnchorOffset += absoluteStartOffset;
            if (z) {
                d3 = absoluteStartOffset + (textAnchor == TextProperties.TextAnchor.middle ? -(d / 2.0d) : 0.0d);
                d2 = d3 + d;
            } else {
                d2 = d;
                d3 = 0.0d;
            }
            i = i9;
            z2 = z12;
        } else {
            d2 = d;
            d3 = 0.0d;
            z2 = false;
            i = 1;
        }
        SVGLength sVGLength = tSpanView2.mTextLength;
        double d13 = d;
        double d14 = 1.0d;
        if (sVGLength != null) {
            z3 = z2;
            d4 = d3;
            double dFromRelative = PropHelper.fromRelative(sVGLength, canvas.getWidth(), 0.0d, tSpanView2.mScale, fontSize);
            if (dFromRelative < 0.0d) {
                throw new IllegalArgumentException("Negative textLength value");
            }
            if (AnonymousClass1.$SwitchMap$com$horcrux$svg$TextProperties$TextLengthAdjust[tSpanView2.mLengthAdjust.ordinal()] != 2) {
                d12 += (dFromRelative - subtreeTextChunksTotalAdvance) / ((double) (length - 1));
            } else {
                d14 = dFromRelative / subtreeTextChunksTotalAdvance;
            }
        } else {
            d4 = d3;
            z3 = z2;
        }
        double d15 = i;
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        double d16 = fontMetrics.descent;
        float f = fontMetrics.leading;
        double d17 = d14 * d15;
        double d18 = ((double) f) + d16;
        int i10 = i;
        double d19 = d2;
        double dFromRelative2 = (-fontMetrics.ascent) + f;
        double d20 = -fontMetrics.top;
        String baselineShift = getBaselineShift();
        TextProperties.AlignmentBaseline alignmentBaseline = getAlignmentBaseline();
        if (alignmentBaseline != null) {
            switch (AnonymousClass1.$SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline[alignmentBaseline.ordinal()]) {
                case 2:
                case 3:
                case 4:
                case 6:
                    i2 = 0;
                    dFromRelative2 = -d16;
                    break;
                case 5:
                default:
                    i2 = 0;
                    dFromRelative2 = 0.0d;
                    break;
                case 7:
                    Rect rect = new Rect();
                    i2 = 0;
                    paint3.getTextBounds("x", 0, 1, rect);
                    dFromRelative2 = ((double) rect.height()) / 2.0d;
                    break;
                case 8:
                    d18 = (dFromRelative2 - d16) / 2.0d;
                    dFromRelative2 = d18;
                    i2 = 0;
                    break;
                case 9:
                    d8 = 0.5d;
                    d18 = dFromRelative2 * d8;
                    dFromRelative2 = d18;
                    i2 = 0;
                    break;
                case 10:
                    d8 = 0.8d;
                    d18 = dFromRelative2 * d8;
                    dFromRelative2 = d18;
                    i2 = 0;
                    break;
                case 11:
                case 12:
                case 13:
                    i2 = 0;
                    break;
                case 14:
                    dFromRelative2 = d18;
                    i2 = 0;
                    break;
                case 15:
                    d18 = (d20 + d18) / 2.0d;
                    dFromRelative2 = d18;
                    i2 = 0;
                    break;
                case 16:
                    dFromRelative2 = d20;
                    i2 = 0;
                    break;
            }
        } else {
            i2 = 0;
            dFromRelative2 = 0.0d;
        }
        if (baselineShift != null && !baselineShift.isEmpty() && (i6 = AnonymousClass1.$SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline[alignmentBaseline.ordinal()]) != 14 && i6 != 16) {
            int iHashCode = baselineShift.hashCode();
            if (iHashCode != -1720785339) {
                if (iHashCode != 114240) {
                    if (iHashCode == 109801339 && baselineShift.equals("super")) {
                        i7 = 2;
                    } else {
                        i7 = -1;
                    }
                } else if (baselineShift.equals("sub")) {
                    i7 = 1;
                } else {
                    i7 = -1;
                }
            } else if (baselineShift.equals("baseline")) {
                i7 = i2;
            } else {
                i7 = -1;
            }
            if (i7 != 0) {
                if (i7 != 1) {
                    if (i7 == 2) {
                        if (readableMap != 0 && readableMap.hasKey("tables") && readableMap.hasKey("unitsPerEm")) {
                            int i11 = readableMap.getInt("unitsPerEm");
                            ReadableMap map = readableMap.getMap("tables");
                            if (map.hasKey("os2")) {
                                ReadableMap map2 = map.getMap("os2");
                                if (map2.hasKey("ySuperscriptYOffset")) {
                                    dFromRelative2 -= ((((double) tSpanView2.mScale) * fontSize) * map2.getDouble("ySuperscriptYOffset")) / ((double) i11);
                                }
                            }
                        }
                    } else {
                        double d21 = tSpanView2.mScale;
                        dFromRelative2 -= PropHelper.fromRelative(baselineShift, d21 * fontSize, d21, fontSize);
                    }
                } else if (readableMap != 0 && readableMap.hasKey("tables") && readableMap.hasKey("unitsPerEm")) {
                    int i12 = readableMap.getInt("unitsPerEm");
                    ReadableMap map3 = readableMap.getMap("tables");
                    if (map3.hasKey("os2")) {
                        ReadableMap map4 = map3.getMap("os2");
                        if (map4.hasKey("ySubscriptYOffset")) {
                            dFromRelative2 += ((((double) tSpanView2.mScale) * fontSize) * map4.getDouble("ySubscriptYOffset")) / ((double) i12);
                        }
                    }
                }
            }
        }
        Matrix matrix = new Matrix();
        Matrix matrix2 = new Matrix();
        Matrix matrix3 = new Matrix();
        float[] fArr4 = new float[9];
        float[] fArr5 = new float[9];
        int i13 = i2;
        while (i13 < length) {
            char c = charArray[i13];
            boolean z13 = zArr[i13];
            if (z13) {
                i3 = length;
                str2 = "";
                z4 = false;
            } else {
                int i14 = i13;
                String strValueOf = String.valueOf(c);
                z4 = false;
                while (true) {
                    int i15 = i14 + 1;
                    if (i15 < length && fArr3[i15] <= 0.0f) {
                        strValueOf = strValueOf + charArray[i15];
                        zArr[i15] = true;
                        z4 = true;
                        i14 = i15;
                        length = length;
                    }
                }
                i3 = length;
                str2 = strValueOf;
            }
            double dMeasureText = ((double) paint3.measureText(str2)) * d14;
            if (!z9) {
                d9 = (((double) fArr3[i13]) * d14) - dMeasureText;
            }
            boolean z14 = c == ' ';
            double d22 = (z14 ? d10 : 0.0d) + d12 + dMeasureText;
            GlyphContext glyphContext = textRootGlyphContext;
            double dNextX = glyphContext.nextX(z13 ? 0.0d : d9 + d22);
            float[] fArr6 = fArr5;
            float[] fArr7 = fArr4;
            double dNextY = glyphContext.nextY();
            double dNextDeltaX = glyphContext.nextDeltaX();
            double dNextDeltaY = glyphContext.nextDeltaY();
            double dNextRotation = glyphContext.nextRotation();
            if (z13 || z14) {
                tSpanView = this;
                matrix = matrix;
                matrix3 = matrix3;
                glyphContext = glyphContext;
                path = path3;
                pathMeasure2 = pathMeasure4;
                i3 = i3;
                z9 = z9;
                fArr = fArr7;
                d5 = d17;
                d6 = d13;
                i4 = i10;
                z5 = false;
                paint2 = paint;
                d15 = d15;
                fArr2 = fArr6;
                glyphPathBag = glyphPathBag2;
            } else {
                double d23 = dMeasureText * d15;
                double d24 = (textAnchorOffset + ((dNextX + dNextDeltaX) * d15)) - (d22 * d15);
                if (z8) {
                    double d25 = d24 + d23;
                    double d26 = d23 / 2.0d;
                    double d27 = d24 + d26;
                    if (d27 <= d19 && d27 >= d4) {
                        if (z3) {
                            PathMeasure pathMeasure5 = pathMeasure4;
                            pathMeasure5.getMatrix((float) d27, matrix2, 3);
                            str2 = str2;
                            fArr2 = fArr6;
                            d6 = d13;
                            pathMeasure2 = pathMeasure5;
                            fArr = fArr7;
                        } else {
                            pathMeasure2 = pathMeasure4;
                            if (d24 < 0.0d) {
                                pathMeasure2.getMatrix(0.0f, matrix, 3);
                                matrix.preTranslate((float) d24, 0.0f);
                                i5 = 1;
                            } else {
                                float f2 = (float) d24;
                                i5 = 1;
                                pathMeasure2.getMatrix(f2, matrix, 1);
                            }
                            pathMeasure2.getMatrix((float) d27, matrix2, i5);
                            if (d25 > d13) {
                                d6 = d13;
                                pathMeasure2.getMatrix((float) d6, matrix3, 3);
                                matrix3.preTranslate((float) (d25 - d6), 0.0f);
                            } else {
                                d6 = d13;
                                pathMeasure2.getMatrix((float) d25, matrix3, i5);
                            }
                            matrix.getValues(fArr7);
                            matrix3.getValues(fArr6);
                            double d28 = fArr7[2];
                            double d29 = fArr7[5];
                            double d30 = fArr6[2];
                            float f3 = fArr6[5];
                            fArr = fArr7;
                            fArr2 = fArr6;
                            matrix2.preRotate((float) (Math.atan2(((double) f3) - d29, d30 - d28) * radToDeg * d15));
                        }
                        matrix2.preTranslate((float) (-d26), (float) (dNextDeltaY + dFromRelative2));
                        d5 = d17;
                        i4 = i10;
                        matrix2.preScale((float) d5, i4);
                        matrix2.postTranslate(0.0f, (float) dNextY);
                        d7 = dNextRotation;
                        z6 = true;
                    } else {
                        tSpanView = this;
                        matrix = matrix;
                        matrix3 = matrix3;
                        glyphContext = glyphContext;
                        path = path3;
                        pathMeasure2 = pathMeasure4;
                        i3 = i3;
                        z9 = z9;
                        fArr = fArr7;
                        d5 = d17;
                        d6 = d13;
                        i4 = i10;
                        z5 = false;
                        paint2 = paint;
                        d15 = d15;
                        fArr2 = fArr6;
                        glyphPathBag = glyphPathBag2;
                    }
                } else {
                    matrix = matrix;
                    glyphContext = glyphContext;
                    pathMeasure2 = pathMeasure4;
                    d5 = d17;
                    fArr2 = fArr6;
                    d6 = d13;
                    i4 = i10;
                    z6 = true;
                    str2 = str2;
                    fArr = fArr7;
                    matrix2.setTranslate((float) d24, (float) (dNextY + dNextDeltaY + dFromRelative2));
                    d7 = dNextRotation;
                }
                matrix2.preRotate((float) d7);
                if (z4) {
                    orCreateAndCache = new Path();
                    z5 = false;
                    z7 = z6;
                    paint.getTextPath(str2, 0, str2.length(), 0.0f, 0.0f, orCreateAndCache);
                    str3 = str2;
                    glyphPathBag = glyphPathBag2;
                } else {
                    str3 = str2;
                    z5 = false;
                    z7 = z6;
                    glyphPathBag = glyphPathBag2;
                    orCreateAndCache = glyphPathBag.getOrCreateAndCache(c, str3);
                }
                RectF rectF = new RectF();
                orCreateAndCache.computeBounds(rectF, z7);
                if (rectF.width() == 0.0f) {
                    canvas.save();
                    canvas.concat(matrix2);
                    tSpanView = this;
                    tSpanView.emoji.add(str3);
                    tSpanView.emojiTransforms.add(new Matrix(matrix2));
                    paint2 = paint;
                    canvas.drawText(str3, 0.0f, 0.0f, paint2);
                    canvas.restore();
                    path = path3;
                } else {
                    tSpanView = this;
                    paint2 = paint;
                    orCreateAndCache.transform(matrix2);
                    path = path3;
                    path.addPath(orCreateAndCache);
                }
            }
            glyphPathBag2 = glyphPathBag;
            i10 = i4;
            i13++;
            tSpanView2 = tSpanView;
            matrix = matrix;
            textRootGlyphContext = glyphContext;
            z9 = z9;
            length = i3;
            d15 = d15;
            pathMeasure4 = pathMeasure2;
            fArr5 = fArr2;
            fArr4 = fArr;
            path3 = path;
            d13 = d6;
            d17 = d5;
            dFromRelative2 = dFromRelative2;
            Matrix matrix4 = matrix3;
            paint3 = paint2;
            matrix3 = matrix4;
        }
        return path3;
    }

    /* JADX INFO: renamed from: com.horcrux.svg.TSpanView$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline;
        static final /* synthetic */ int[] $SwitchMap$com$horcrux$svg$TextProperties$TextAnchor;
        static final /* synthetic */ int[] $SwitchMap$com$horcrux$svg$TextProperties$TextLengthAdjust;

        static {
            int[] iArr = new int[TextProperties.AlignmentBaseline.values().length];
            $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline = iArr;
            try {
                iArr[TextProperties.AlignmentBaseline.baseline.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline[TextProperties.AlignmentBaseline.textBottom.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline[TextProperties.AlignmentBaseline.afterEdge.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline[TextProperties.AlignmentBaseline.textAfterEdge.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline[TextProperties.AlignmentBaseline.alphabetic.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline[TextProperties.AlignmentBaseline.ideographic.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline[TextProperties.AlignmentBaseline.middle.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline[TextProperties.AlignmentBaseline.central.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline[TextProperties.AlignmentBaseline.mathematical.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline[TextProperties.AlignmentBaseline.hanging.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline[TextProperties.AlignmentBaseline.textTop.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline[TextProperties.AlignmentBaseline.beforeEdge.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline[TextProperties.AlignmentBaseline.textBeforeEdge.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline[TextProperties.AlignmentBaseline.bottom.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline[TextProperties.AlignmentBaseline.center.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline[TextProperties.AlignmentBaseline.top.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            int[] iArr2 = new int[TextProperties.TextLengthAdjust.values().length];
            $SwitchMap$com$horcrux$svg$TextProperties$TextLengthAdjust = iArr2;
            try {
                iArr2[TextProperties.TextLengthAdjust.spacing.ordinal()] = 1;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$horcrux$svg$TextProperties$TextLengthAdjust[TextProperties.TextLengthAdjust.spacingAndGlyphs.ordinal()] = 2;
            } catch (NoSuchFieldError unused18) {
            }
            int[] iArr3 = new int[TextProperties.TextAnchor.values().length];
            $SwitchMap$com$horcrux$svg$TextProperties$TextAnchor = iArr3;
            try {
                iArr3[TextProperties.TextAnchor.start.ordinal()] = 1;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$com$horcrux$svg$TextProperties$TextAnchor[TextProperties.TextAnchor.middle.ordinal()] = 2;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$com$horcrux$svg$TextProperties$TextAnchor[TextProperties.TextAnchor.end.ordinal()] = 3;
            } catch (NoSuchFieldError unused21) {
            }
        }
    }

    private double getAbsoluteStartOffset(SVGLength sVGLength, double d, double d2) {
        return PropHelper.fromRelative(sVGLength, d, 0.0d, this.mScale, d2);
    }

    private double getTextAnchorOffset(TextProperties.TextAnchor textAnchor, double d) {
        int i = AnonymousClass1.$SwitchMap$com$horcrux$svg$TextProperties$TextAnchor[textAnchor.ordinal()];
        if (i == 2) {
            return (-d) / 2.0d;
        }
        if (i != 3) {
            return 0.0d;
        }
        return -d;
    }

    private void applyTextPropertiesToPaint(Paint paint, FontData fontData) {
        int i = 0;
        boolean z = fontData.fontWeight == TextProperties.FontWeight.Bold || fontData.absoluteFontWeight >= 550;
        boolean z2 = fontData.fontStyle == TextProperties.FontStyle.italic;
        if (z && z2) {
            i = 3;
        } else if (z) {
            i = 1;
        } else if (z2) {
            i = 2;
        }
        int i2 = fontData.absoluteFontWeight;
        String str = fontData.fontFamily;
        Typeface typeface = null;
        if (str != null && str.length() > 0) {
            String str2 = FONTS + str + OTF;
            String str3 = FONTS + str + TTF;
            if (Build.VERSION.SDK_INT >= 26) {
                TypefaceBuilderCompat$$ExternalSyntheticApiModelOutline7.m();
                Typeface.Builder builderM = TypefaceBuilderCompat$$ExternalSyntheticApiModelOutline3.m(this.assets, str2);
                builderM.setFontVariationSettings(fontWeightTag + i2 + fontData.fontVariationSettings);
                builderM.setWeight(i2);
                builderM.setItalic(z2);
                typeface = builderM.build();
                if (typeface == null) {
                    TypefaceBuilderCompat$$ExternalSyntheticApiModelOutline7.m();
                    Typeface.Builder builderM2 = TypefaceBuilderCompat$$ExternalSyntheticApiModelOutline3.m(this.assets, str3);
                    builderM2.setFontVariationSettings(fontWeightTag + i2 + fontData.fontVariationSettings);
                    builderM2.setWeight(i2);
                    builderM2.setItalic(z2);
                    typeface = builderM2.build();
                }
            } else {
                try {
                    try {
                        typeface = Typeface.create(Typeface.createFromAsset(this.assets, str2), i);
                    } catch (Exception unused) {
                    }
                } catch (Exception unused2) {
                    typeface = Typeface.create(Typeface.createFromAsset(this.assets, str3), i);
                }
            }
        }
        if (typeface == null) {
            try {
                typeface = ReactFontManager.getInstance().getTypeface(str, i, this.assets);
            } catch (Exception unused3) {
            }
        }
        if (Build.VERSION.SDK_INT >= 28) {
            typeface = Typeface.create(typeface, i2, z2);
        }
        paint.setLinearText(true);
        paint.setSubpixelText(true);
        paint.setTypeface(typeface);
        paint.setTextSize((float) (fontData.fontSize * ((double) this.mScale)));
        paint.setLetterSpacing(0.0f);
    }

    private void setupTextPath() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent.getClass() == TextPathView.class) {
                this.textPath = (TextPathView) parent;
                return;
            } else {
                if (!(parent instanceof TextView)) {
                    return;
                }
            }
        }
    }

    @Override // com.horcrux.svg.GroupView, com.horcrux.svg.RenderableView, com.horcrux.svg.VirtualView
    int hitTest(float[] fArr) {
        Region region;
        if (this.mContent == null) {
            return super.hitTest(fArr);
        }
        if (this.mPath != null && this.mInvertible) {
            float[] fArr2 = new float[2];
            this.mInvMatrix.mapPoints(fArr2, fArr);
            int iRound = Math.round(fArr2[0]);
            int iRound2 = Math.round(fArr2[1]);
            initBounds();
            Region region2 = this.mRegion;
            if ((region2 != null && region2.contains(iRound, iRound2)) || ((region = this.mStrokeRegion) != null && region.contains(iRound, iRound2))) {
                if (getClipPath() == null || this.mClipRegion.contains(iRound, iRound2)) {
                    return getId();
                }
                return -1;
            }
        }
        return -1;
    }
}
