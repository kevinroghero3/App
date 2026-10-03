package com.facebook.react.views.text;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.text.BoringLayout;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.common.build.ReactBuildConfig;
import com.facebook.react.common.mapbuffer.MapBuffer;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.views.text.internal.span.ReactAbsoluteSizeSpan;
import com.facebook.react.views.text.internal.span.ReactTextPaintHolderSpan;
import com.facebook.react.views.text.internal.span.SetSpanOperation;
import com.facebook.react.views.text.internal.span.TextInlineViewPlaceholderSpan;
import com.facebook.yoga.YogaConstants;
import com.facebook.yoga.YogaMeasureMode;
import com.facebook.yoga.YogaMeasureOutput;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class TextLayoutManager {
    public static final short AS_KEY_BASE_ATTRIBUTES = 4;
    public static final short AS_KEY_CACHE_ID = 3;
    public static final short AS_KEY_FRAGMENTS = 2;
    public static final short AS_KEY_HASH = 0;
    public static final short AS_KEY_STRING = 1;
    private static final boolean DEFAULT_ADJUST_FONT_SIZE_TO_FIT = false;
    private static final boolean DEFAULT_INCLUDE_FONT_PADDING = true;
    private static final boolean ENABLE_MEASURE_LOGGING;
    public static final short FR_KEY_HEIGHT = 4;
    public static final short FR_KEY_IS_ATTACHMENT = 2;
    public static final short FR_KEY_REACT_TAG = 1;
    public static final short FR_KEY_STRING = 0;
    public static final short FR_KEY_TEXT_ATTRIBUTES = 5;
    public static final short FR_KEY_WIDTH = 3;
    private static final String INLINE_VIEW_PLACEHOLDER = "0";
    public static final short PA_KEY_ADJUST_FONT_SIZE_TO_FIT = 3;
    public static final short PA_KEY_ELLIPSIZE_MODE = 1;
    public static final short PA_KEY_HYPHENATION_FREQUENCY = 5;
    public static final short PA_KEY_INCLUDE_FONT_PADDING = 4;
    public static final short PA_KEY_MAXIMUM_FONT_SIZE = 7;
    public static final short PA_KEY_MAX_NUMBER_OF_LINES = 0;
    public static final short PA_KEY_MINIMUM_FONT_SIZE = 6;
    public static final short PA_KEY_TEXT_BREAK_STRATEGY = 2;
    private static final String TAG;
    private static final ConcurrentHashMap<Integer, Spannable> sTagToSpannableCache;
    private static final ThreadLocal<TextPaint> sTextPaintInstance;

    static {
        boolean z = ReactBuildConfig.DEBUG;
        ENABLE_MEASURE_LOGGING = false;
        TAG = TextLayoutManager.class.getSimpleName();
        sTextPaintInstance = new ThreadLocal<TextPaint>() { // from class: com.facebook.react.views.text.TextLayoutManager.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.lang.ThreadLocal
            public TextPaint initialValue() {
                return new TextPaint(1);
            }
        };
        sTagToSpannableCache = new ConcurrentHashMap<>();
    }

    public static void setCachedSpannableForTag(int i, @NonNull Spannable spannable) {
        if (ENABLE_MEASURE_LOGGING) {
            FLog.e(TAG, "Set cached spannable for tag[" + i + "]: " + spannable.toString());
        }
        sTagToSpannableCache.put(Integer.valueOf(i), spannable);
    }

    public static void deleteCachedSpannableForTag(int i) {
        if (ENABLE_MEASURE_LOGGING) {
            FLog.e(TAG, "Delete cached spannable for tag[" + i + "]");
        }
        sTagToSpannableCache.remove(Integer.valueOf(i));
    }

    public static boolean isRTL(MapBuffer mapBuffer) {
        if (!mapBuffer.contains(2)) {
            return false;
        }
        MapBuffer mapBuffer2 = mapBuffer.getMapBuffer(2);
        if (mapBuffer2.getCount() == 0) {
            return false;
        }
        MapBuffer mapBuffer3 = mapBuffer2.getMapBuffer(0).getMapBuffer(5);
        return mapBuffer3.contains(23) && TextAttributeProps.getLayoutDirection(mapBuffer3.getString(23)) == 1;
    }

    private static String getTextAlignmentAttr(MapBuffer mapBuffer) {
        if (!mapBuffer.contains(2)) {
            return null;
        }
        MapBuffer mapBuffer2 = mapBuffer.getMapBuffer(2);
        if (mapBuffer2.getCount() != 0) {
            MapBuffer mapBuffer3 = mapBuffer2.getMapBuffer(0).getMapBuffer(5);
            if (mapBuffer3.contains(12)) {
                return mapBuffer3.getString(12);
            }
        }
        return null;
    }

    private static int getTextJustificationMode(@Nullable String str) {
        if (Build.VERSION.SDK_INT < 26) {
            return -1;
        }
        return (str == null || !str.equals("justified")) ? 0 : 1;
    }

    private static Layout.Alignment getTextAlignment(MapBuffer mapBuffer, Spannable spannable, @Nullable String str) {
        boolean z = isRTL(mapBuffer) != TextDirectionHeuristics.FIRSTSTRONG_LTR.isRtl(spannable, 0, spannable.length());
        Layout.Alignment alignment = z ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL;
        if (str == null) {
            return alignment;
        }
        if (str.equals("center")) {
            return Layout.Alignment.ALIGN_CENTER;
        }
        if (str.equals(ViewProps.RIGHT)) {
            return z ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_OPPOSITE;
        }
        return alignment;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0022 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:9:0x0020 A[RETURN, SYNTHETIC] */
    public static int getTextGravity(MapBuffer mapBuffer, Spannable spannable, int i) {
        Layout.Alignment textAlignment = getTextAlignment(mapBuffer, spannable, getTextAlignmentAttr(mapBuffer));
        boolean zIsRtl = TextDirectionHeuristics.FIRSTSTRONG_LTR.isRtl(spannable, 0, spannable.length());
        if (textAlignment == Layout.Alignment.ALIGN_NORMAL) {
            if (zIsRtl) {
                return 5;
            }
            return 3;
        }
        if (textAlignment == Layout.Alignment.ALIGN_OPPOSITE) {
            if (zIsRtl) {
                return 3;
            }
            return 5;
        }
        if (textAlignment == Layout.Alignment.ALIGN_CENTER) {
            return 1;
        }
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0088, code lost:
    
        r22.add(new com.facebook.react.views.text.internal.span.SetSpanOperation(r6, r8, new com.facebook.react.views.text.internal.span.ReactClickableSpan(r11)));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void buildSpannableFromFragments(android.content.Context r19, com.facebook.react.common.mapbuffer.MapBuffer r20, android.text.SpannableStringBuilder r21, java.util.List<com.facebook.react.views.text.internal.span.SetSpanOperation> r22) {
        /*
            Method dump skipped, instruction units count: 426
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.text.TextLayoutManager.buildSpannableFromFragments(android.content.Context, com.facebook.react.common.mapbuffer.MapBuffer, android.text.SpannableStringBuilder, java.util.List):void");
    }

    public static Spannable getOrCreateSpannableForText(Context context, MapBuffer mapBuffer, @Nullable ReactTextViewManagerCallback reactTextViewManagerCallback) {
        if (mapBuffer.contains(3)) {
            return sTagToSpannableCache.get(Integer.valueOf(mapBuffer.getInt(3)));
        }
        return createSpannableFromAttributedString(context, mapBuffer, reactTextViewManagerCallback);
    }

    private static Spannable createSpannableFromAttributedString(Context context, MapBuffer mapBuffer, @Nullable ReactTextViewManagerCallback reactTextViewManagerCallback) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ArrayList arrayList = new ArrayList();
        buildSpannableFromFragments(context, mapBuffer.getMapBuffer(2), spannableStringBuilder, arrayList);
        for (int i = 0; i < arrayList.size(); i++) {
            ((SetSpanOperation) arrayList.get((arrayList.size() - i) - 1)).execute(spannableStringBuilder, i);
        }
        if (reactTextViewManagerCallback != null) {
            reactTextViewManagerCallback.onPostProcessSpannable(spannableStringBuilder);
        }
        return spannableStringBuilder;
    }

    private static Layout createLayout(Spannable spannable, BoringLayout.Metrics metrics, float f, YogaMeasureMode yogaMeasureMode, boolean z, int i, int i2, Layout.Alignment alignment, int i3, TextPaint textPaint) {
        int i4;
        int length = spannable.length();
        boolean z2 = yogaMeasureMode == YogaMeasureMode.UNDEFINED || f < 0.0f;
        float desiredWidth = metrics == null ? Layout.getDesiredWidth(spannable, textPaint) : Float.NaN;
        boolean zIsRtl = TextDirectionHeuristics.FIRSTSTRONG_LTR.isRtl(spannable, 0, length);
        if (metrics == null && (z2 || (!YogaConstants.isUndefined(desiredWidth) && desiredWidth <= f))) {
            if (yogaMeasureMode == YogaMeasureMode.EXACTLY) {
                desiredWidth = f;
            }
            StaticLayout.Builder textDirection = StaticLayout.Builder.obtain(spannable, 0, length, textPaint, (int) Math.ceil(desiredWidth)).setAlignment(alignment).setLineSpacing(0.0f, 1.0f).setIncludePad(z).setBreakStrategy(i).setHyphenationFrequency(i2).setTextDirection(zIsRtl ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
            if (Build.VERSION.SDK_INT >= 28) {
                textDirection.setUseLineSpacingFromFallbacks(true);
            }
            return textDirection.build();
        }
        if (metrics != null && (z2 || metrics.width <= f)) {
            int iCeil = metrics.width;
            if (yogaMeasureMode == YogaMeasureMode.EXACTLY) {
                iCeil = (int) Math.ceil(f);
            }
            if (metrics.width < 0) {
                ReactSoftExceptionLogger.logSoftException(TAG, new ReactNoCrashSoftException("Text width is invalid: " + metrics.width));
                i4 = 0;
            } else {
                i4 = iCeil;
            }
            return BoringLayout.make(spannable, textPaint, i4, alignment, 1.0f, 0.0f, metrics, z);
        }
        StaticLayout.Builder textDirection2 = StaticLayout.Builder.obtain(spannable, 0, length, textPaint, (int) Math.ceil(f)).setAlignment(alignment).setLineSpacing(0.0f, 1.0f).setIncludePad(z).setBreakStrategy(i).setHyphenationFrequency(i2).setTextDirection(zIsRtl ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 26) {
            textDirection2.setJustificationMode(i3);
        }
        if (i5 >= 28) {
            textDirection2.setUseLineSpacingFromFallbacks(true);
        }
        return textDirection2.build();
    }

    private static void updateTextPaint(TextPaint textPaint, TextAttributeProps textAttributeProps, Context context) {
        textPaint.reset();
        textPaint.setAntiAlias(true);
        if (textAttributeProps.getEffectiveFontSize() != -1) {
            textPaint.setTextSize(textAttributeProps.getEffectiveFontSize());
        }
        if (textAttributeProps.getFontStyle() != -1 || textAttributeProps.getFontWeight() != -1 || textAttributeProps.getFontFamily() != null) {
            Typeface typefaceApplyStyles = ReactTypefaceUtils.applyStyles(null, textAttributeProps.getFontStyle(), textAttributeProps.getFontWeight(), textAttributeProps.getFontFamily(), context.getAssets());
            textPaint.setTypeface(typefaceApplyStyles);
            if (textAttributeProps.getFontStyle() == -1 || textAttributeProps.getFontStyle() == typefaceApplyStyles.getStyle()) {
                return;
            }
            int fontStyle = textAttributeProps.getFontStyle() & (~typefaceApplyStyles.getStyle());
            textPaint.setFakeBoldText((fontStyle & 1) != 0);
            textPaint.setTextSkewX((fontStyle & 2) != 0 ? -0.25f : 0.0f);
            return;
        }
        textPaint.setTypeface(null);
    }

    private static Layout createLayout(@NonNull Context context, MapBuffer mapBuffer, MapBuffer mapBuffer2, float f, float f2, ReactTextViewManagerCallback reactTextViewManagerCallback) {
        TextPaint textPaint;
        Spannable orCreateSpannableForText = getOrCreateSpannableForText(context, mapBuffer, reactTextViewManagerCallback);
        if (mapBuffer.contains(3)) {
            textPaint = ((ReactTextPaintHolderSpan[]) orCreateSpannableForText.getSpans(0, 0, ReactTextPaintHolderSpan.class))[0].getTextPaint();
        } else {
            TextAttributeProps textAttributePropsFromMapBuffer = TextAttributeProps.fromMapBuffer(mapBuffer.getMapBuffer(4));
            TextPaint textPaint2 = (TextPaint) Preconditions.checkNotNull(sTextPaintInstance.get());
            updateTextPaint(textPaint2, textAttributePropsFromMapBuffer, context);
            textPaint = textPaint2;
        }
        BoringLayout.Metrics metricsIsBoring = BoringLayout.isBoring(orCreateSpannableForText, textPaint);
        int textBreakStrategy = TextAttributeProps.getTextBreakStrategy(mapBuffer2.getString(2));
        boolean z = mapBuffer2.contains(4) ? mapBuffer2.getBoolean(4) : true;
        int hyphenationFrequency = TextAttributeProps.getHyphenationFrequency(mapBuffer2.getString(5));
        boolean z2 = mapBuffer2.contains(3) ? mapBuffer2.getBoolean(3) : false;
        int i = mapBuffer2.contains(0) ? mapBuffer2.getInt(0) : -1;
        String textAlignmentAttr = getTextAlignmentAttr(mapBuffer);
        Layout.Alignment textAlignment = getTextAlignment(mapBuffer, orCreateSpannableForText, textAlignmentAttr);
        int textJustificationMode = getTextJustificationMode(textAlignmentAttr);
        if (z2) {
            adjustSpannableFontToFit(orCreateSpannableForText, f, YogaMeasureMode.EXACTLY, f2, YogaMeasureMode.UNDEFINED, mapBuffer2.contains(6) ? mapBuffer2.getDouble(6) : Double.NaN, i, z, textBreakStrategy, hyphenationFrequency, textAlignment, textJustificationMode, textPaint);
        }
        return createLayout(orCreateSpannableForText, metricsIsBoring, f, YogaMeasureMode.EXACTLY, z, textBreakStrategy, hyphenationFrequency, textAlignment, textJustificationMode, textPaint);
    }

    static void adjustSpannableFontToFit(Spannable spannable, float f, YogaMeasureMode yogaMeasureMode, float f2, YogaMeasureMode yogaMeasureMode2, double d, int i, boolean z, int i2, int i3, Layout.Alignment alignment, int i4, TextPaint textPaint) {
        BoringLayout.Metrics metricsIsBoring = BoringLayout.isBoring(spannable, textPaint);
        Layout layoutCreateLayout = createLayout(spannable, metricsIsBoring, f, yogaMeasureMode, z, i2, i3, alignment, i4, textPaint);
        int pixelFromDIP = (int) (Double.isNaN(d) ? PixelUtil.toPixelFromDIP(4.0f) : d);
        int i5 = 0;
        int iMax = pixelFromDIP;
        for (ReactAbsoluteSizeSpan reactAbsoluteSizeSpan : (ReactAbsoluteSizeSpan[]) spannable.getSpans(0, spannable.length(), ReactAbsoluteSizeSpan.class)) {
            iMax = Math.max(iMax, reactAbsoluteSizeSpan.getSize());
        }
        int i6 = iMax;
        while (i6 > pixelFromDIP) {
            if ((i == -1 || i == 0 || layoutCreateLayout.getLineCount() <= i) && ((yogaMeasureMode2 == YogaMeasureMode.UNDEFINED || layoutCreateLayout.getHeight() <= f2) && (spannable.length() != 1 || layoutCreateLayout.getLineWidth(i5) <= f))) {
                return;
            }
            int iMax2 = i6 - Math.max(1, (int) PixelUtil.toPixelFromDIP(1.0f));
            float f3 = iMax2 / iMax;
            float f4 = pixelFromDIP;
            textPaint.setTextSize(Math.max(textPaint.getTextSize() * f3, f4));
            ReactAbsoluteSizeSpan[] reactAbsoluteSizeSpanArr = (ReactAbsoluteSizeSpan[]) spannable.getSpans(i5, spannable.length(), ReactAbsoluteSizeSpan.class);
            int length = reactAbsoluteSizeSpanArr.length;
            int i7 = i5;
            while (i7 < length) {
                ReactAbsoluteSizeSpan reactAbsoluteSizeSpan2 = reactAbsoluteSizeSpanArr[i7];
                spannable.setSpan(new ReactAbsoluteSizeSpan((int) Math.max(reactAbsoluteSizeSpan2.getSize() * f3, f4)), spannable.getSpanStart(reactAbsoluteSizeSpan2), spannable.getSpanEnd(reactAbsoluteSizeSpan2), spannable.getSpanFlags(reactAbsoluteSizeSpan2));
                spannable.removeSpan(reactAbsoluteSizeSpan2);
                i7++;
                reactAbsoluteSizeSpanArr = reactAbsoluteSizeSpanArr;
                f3 = f3;
                f4 = f4;
            }
            if (metricsIsBoring != null) {
                metricsIsBoring = BoringLayout.isBoring(spannable, textPaint);
            }
            layoutCreateLayout = createLayout(spannable, metricsIsBoring, f, yogaMeasureMode, z, i2, i3, alignment, i4, textPaint);
            i6 = iMax2;
            iMax = iMax;
            i5 = 0;
        }
    }

    /* JADX WARN: Code duplicated, block: B:41:0x0089  */
    /* JADX WARN: Code duplicated, block: B:51:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:79:0x0132  */
    /* JADX WARN: Code duplicated, block: B:80:0x0135  */
    public static long measureText(Context context, MapBuffer mapBuffer, MapBuffer mapBuffer2, float f, YogaMeasureMode yogaMeasureMode, float f2, YogaMeasureMode yogaMeasureMode2, ReactTextViewManagerCallback reactTextViewManagerCallback, @Nullable float[] fArr) {
        int lineCount;
        float fCeil;
        float lineBottom;
        char c;
        float secondaryHorizontal;
        float lineRight;
        boolean z;
        char c2;
        float lineWidth;
        Layout layoutCreateLayout = createLayout(context, mapBuffer, mapBuffer2, f, f2, reactTextViewManagerCallback);
        Spannable spannable = (Spannable) layoutCreateLayout.getText();
        if (spannable == null) {
            return 0L;
        }
        int i = 0;
        int i2 = -1;
        int i3 = mapBuffer2.contains(0) ? mapBuffer2.getInt(0) : -1;
        if (i3 == -1 || i3 == 0) {
            lineCount = layoutCreateLayout.getLineCount();
        } else {
            lineCount = Math.min(i3, layoutCreateLayout.getLineCount());
        }
        char c3 = '\n';
        boolean z2 = true;
        if (yogaMeasureMode == YogaMeasureMode.EXACTLY) {
            fCeil = f;
        } else {
            fCeil = 0.0f;
            for (int i4 = 0; i4 < lineCount; i4++) {
                boolean z3 = spannable.length() > 0 && spannable.charAt(layoutCreateLayout.getLineEnd(i4) - 1) == '\n';
                if (!z3 && i4 + 1 < layoutCreateLayout.getLineCount()) {
                    fCeil = f;
                    break;
                }
                float lineMax = z3 ? layoutCreateLayout.getLineMax(i4) : layoutCreateLayout.getLineWidth(i4);
                if (lineMax > fCeil) {
                    fCeil = lineMax;
                }
            }
            if (yogaMeasureMode == YogaMeasureMode.AT_MOST && fCeil > f) {
                fCeil = f;
            }
        }
        if (Build.VERSION.SDK_INT > 29) {
            fCeil = (float) Math.ceil(fCeil);
        }
        if (yogaMeasureMode2 != YogaMeasureMode.EXACTLY) {
            lineBottom = layoutCreateLayout.getLineBottom(lineCount - 1);
            if (yogaMeasureMode2 == YogaMeasureMode.AT_MOST && lineBottom > f2) {
                lineBottom = f2;
            }
        } else {
            lineBottom = f2;
        }
        int i5 = 0;
        int i6 = 0;
        while (i5 < spannable.length()) {
            int iNextSpanTransition = spannable.nextSpanTransition(i5, spannable.length(), TextInlineViewPlaceholderSpan.class);
            TextInlineViewPlaceholderSpan[] textInlineViewPlaceholderSpanArr = (TextInlineViewPlaceholderSpan[]) spannable.getSpans(i5, iNextSpanTransition, TextInlineViewPlaceholderSpan.class);
            int length = textInlineViewPlaceholderSpanArr.length;
            int i7 = i;
            while (i7 < length) {
                TextInlineViewPlaceholderSpan textInlineViewPlaceholderSpan = textInlineViewPlaceholderSpanArr[i7];
                int spanStart = spannable.getSpanStart(textInlineViewPlaceholderSpan);
                int lineForOffset = layoutCreateLayout.getLineForOffset(spanStart);
                if (layoutCreateLayout.getEllipsisCount(lineForOffset) <= 0 || spanStart < layoutCreateLayout.getLineStart(lineForOffset) + layoutCreateLayout.getEllipsisStart(lineForOffset) || spanStart >= layoutCreateLayout.getLineEnd(lineForOffset)) {
                    float width = textInlineViewPlaceholderSpan.getWidth();
                    float height = textInlineViewPlaceholderSpan.getHeight();
                    boolean zIsRtlCharAt = layoutCreateLayout.isRtlCharAt(spanStart);
                    boolean z4 = layoutCreateLayout.getParagraphDirection(lineForOffset) == i2;
                    if (spanStart == spannable.length() - 1) {
                        if (spannable.length() > 0) {
                            c2 = '\n';
                            if (spannable.charAt(layoutCreateLayout.getLineEnd(lineForOffset) - 1) == '\n') {
                                lineWidth = layoutCreateLayout.getLineMax(lineForOffset);
                            }
                            if (z4) {
                                lineRight = fCeil - lineWidth;
                            } else {
                                lineRight = layoutCreateLayout.getLineRight(lineForOffset) - width;
                            }
                            c = c2;
                        } else {
                            c2 = '\n';
                        }
                        lineWidth = layoutCreateLayout.getLineWidth(lineForOffset);
                        if (z4) {
                            lineRight = fCeil - lineWidth;
                        } else {
                            lineRight = layoutCreateLayout.getLineRight(lineForOffset) - width;
                        }
                        c = c2;
                    } else {
                        c = '\n';
                        if (z4 == zIsRtlCharAt) {
                            secondaryHorizontal = layoutCreateLayout.getPrimaryHorizontal(spanStart);
                        } else {
                            secondaryHorizontal = layoutCreateLayout.getSecondaryHorizontal(spanStart);
                        }
                        float lineRight2 = (!z4 || zIsRtlCharAt) ? secondaryHorizontal : fCeil - (layoutCreateLayout.getLineRight(lineForOffset) - secondaryHorizontal);
                        lineRight = zIsRtlCharAt ? lineRight2 - width : lineRight2;
                    }
                    int i8 = i6 * 2;
                    fArr[i8] = PixelUtil.toDIPFromPixel(layoutCreateLayout.getLineBaseline(lineForOffset) - height);
                    z = true;
                    fArr[i8 + 1] = PixelUtil.toDIPFromPixel(lineRight);
                    i6++;
                } else {
                    c = c3;
                    z = z2;
                }
                i7++;
                z2 = z;
                i = 0;
                c3 = c;
                i2 = -1;
            }
            i5 = iNextSpanTransition;
        }
        float dIPFromPixel = PixelUtil.toDIPFromPixel(fCeil);
        float dIPFromPixel2 = PixelUtil.toDIPFromPixel(lineBottom);
        if (ENABLE_MEASURE_LOGGING) {
            FLog.e(TAG, "TextMeasure call ('" + ((Object) spannable) + "'): w: " + fCeil + " px - h: " + lineBottom + " px - w : " + dIPFromPixel + " sp - h: " + dIPFromPixel2 + " sp");
        }
        return YogaMeasureOutput.make(dIPFromPixel, dIPFromPixel2);
    }

    public static WritableArray measureLines(@NonNull Context context, MapBuffer mapBuffer, MapBuffer mapBuffer2, float f, float f2) {
        Layout layoutCreateLayout = createLayout(context, mapBuffer, mapBuffer2, f, f2, null);
        return FontMetricsUtil.getFontMetrics(layoutCreateLayout.getText(), layoutCreateLayout, (TextPaint) Preconditions.checkNotNull(sTextPaintInstance.get()), context);
    }
}
