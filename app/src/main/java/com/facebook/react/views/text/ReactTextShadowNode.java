package com.facebook.react.views.text;

import android.os.Build;
import android.text.BoringLayout;
import android.text.Layout;
import android.text.Spannable;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextPaint;
import androidx.annotation.Nullable;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.NativeViewHierarchyOptimizer;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ReactShadowNode;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIViewOperationQueue;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.facebook.react.views.text.internal.span.ReactAbsoluteSizeSpan;
import com.facebook.react.views.text.internal.span.TextInlineViewPlaceholderSpan;
import com.facebook.yoga.YogaBaselineFunction;
import com.facebook.yoga.YogaConstants;
import com.facebook.yoga.YogaDirection;
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaMeasureMode;
import com.facebook.yoga.YogaMeasureOutput;
import com.facebook.yoga.YogaNode;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ReactTextShadowNode extends ReactBaseTextShadowNode {
    private static final TextPaint sTextPaintInstance = new TextPaint(1);
    private Spannable mPreparedSpannableText;
    private boolean mShouldNotifyOnTextLayout;
    private final YogaBaselineFunction mTextBaselineFunction;
    private final YogaMeasureFunction mTextMeasureFunction;

    @Override // com.facebook.react.uimanager.ReactShadowNodeImpl, com.facebook.react.uimanager.ReactShadowNode
    public boolean hoistNativeChildren() {
        return true;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNodeImpl, com.facebook.react.uimanager.ReactShadowNode
    public boolean isVirtualAnchor() {
        return false;
    }

    public ReactTextShadowNode() {
        this(null);
    }

    public ReactTextShadowNode(@Nullable ReactTextViewManagerCallback reactTextViewManagerCallback) {
        super(reactTextViewManagerCallback);
        this.mTextMeasureFunction = new YogaMeasureFunction() { // from class: com.facebook.react.views.text.ReactTextShadowNode.1
            /* JADX WARN: Code duplicated, block: B:58:0x016b  */
            @Override // com.facebook.yoga.YogaMeasureFunction
            public long measure(YogaNode yogaNode, float f, YogaMeasureMode yogaMeasureMode, float f2, YogaMeasureMode yogaMeasureMode2) {
                int iMin;
                float lineBottom;
                float fCeil = f;
                Spannable spannable = (Spannable) Assertions.assertNotNull(ReactTextShadowNode.this.mPreparedSpannableText, "Spannable element has not been prepared in onBeforeLayout");
                Layout layoutMeasureSpannedText = ReactTextShadowNode.this.measureSpannedText(spannable, fCeil, yogaMeasureMode);
                ReactTextShadowNode reactTextShadowNode = ReactTextShadowNode.this;
                int i = -1;
                int i2 = 0;
                int i3 = 1;
                if (reactTextShadowNode.mAdjustsFontSizeToFit) {
                    int effectiveFontSize = reactTextShadowNode.mTextAttributes.getEffectiveFontSize();
                    int effectiveFontSize2 = ReactTextShadowNode.this.mTextAttributes.getEffectiveFontSize();
                    float f3 = effectiveFontSize;
                    int iMax = (int) Math.max(ReactTextShadowNode.this.mMinimumFontScale * f3, PixelUtil.toPixelFromDIP(4.0f));
                    while (effectiveFontSize2 > iMax && ((ReactTextShadowNode.this.mNumberOfLines != i && layoutMeasureSpannedText.getLineCount() > ReactTextShadowNode.this.mNumberOfLines) || (yogaMeasureMode2 != YogaMeasureMode.UNDEFINED && layoutMeasureSpannedText.getHeight() > f2))) {
                        effectiveFontSize2 -= Math.max(i3, (int) PixelUtil.toPixelFromDIP(1.0f));
                        float f4 = effectiveFontSize2 / f3;
                        ReactAbsoluteSizeSpan[] reactAbsoluteSizeSpanArr = (ReactAbsoluteSizeSpan[]) spannable.getSpans(i2, spannable.length(), ReactAbsoluteSizeSpan.class);
                        int length = reactAbsoluteSizeSpanArr.length;
                        int i4 = i2;
                        while (i4 < length) {
                            ReactAbsoluteSizeSpan reactAbsoluteSizeSpan = reactAbsoluteSizeSpanArr[i4];
                            spannable.setSpan(new ReactAbsoluteSizeSpan((int) Math.max(reactAbsoluteSizeSpan.getSize() * f4, iMax)), spannable.getSpanStart(reactAbsoluteSizeSpan), spannable.getSpanEnd(reactAbsoluteSizeSpan), spannable.getSpanFlags(reactAbsoluteSizeSpan));
                            spannable.removeSpan(reactAbsoluteSizeSpan);
                            i4++;
                            f4 = f4;
                        }
                        layoutMeasureSpannedText = ReactTextShadowNode.this.measureSpannedText(spannable, fCeil, yogaMeasureMode);
                        i = -1;
                        i2 = 0;
                        i3 = 1;
                    }
                }
                if (ReactTextShadowNode.this.mShouldNotifyOnTextLayout) {
                    ThemedReactContext themedContext = ReactTextShadowNode.this.getThemedContext();
                    WritableArray fontMetrics = FontMetricsUtil.getFontMetrics(spannable, layoutMeasureSpannedText, ReactTextShadowNode.sTextPaintInstance, themedContext);
                    WritableMap writableMapCreateMap = Arguments.createMap();
                    writableMapCreateMap.putArray("lines", fontMetrics);
                    if (themedContext.hasActiveReactInstance()) {
                        ((RCTEventEmitter) themedContext.getJSModule(RCTEventEmitter.class)).receiveEvent(ReactTextShadowNode.this.getReactTag(), "topTextLayout", writableMapCreateMap);
                    } else {
                        ReactSoftExceptionLogger.logSoftException("ReactTextShadowNode", new ReactNoCrashSoftException("Cannot get RCTEventEmitter, no CatalystInstance"));
                    }
                }
                int i5 = ReactTextShadowNode.this.mNumberOfLines;
                if (i5 == -1) {
                    iMin = layoutMeasureSpannedText.getLineCount();
                } else {
                    iMin = Math.min(i5, layoutMeasureSpannedText.getLineCount());
                }
                if (yogaMeasureMode != YogaMeasureMode.EXACTLY) {
                    float f5 = 0.0f;
                    for (int i6 = 0; i6 < iMin; i6++) {
                        float lineWidth = (spannable.length() <= 0 || spannable.charAt(layoutMeasureSpannedText.getLineEnd(i6) - 1) != '\n') ? layoutMeasureSpannedText.getLineWidth(i6) : layoutMeasureSpannedText.getLineMax(i6);
                        if (lineWidth > f5) {
                            f5 = lineWidth;
                        }
                    }
                    if (yogaMeasureMode != YogaMeasureMode.AT_MOST || f5 <= fCeil) {
                        fCeil = f5;
                    }
                }
                if (Build.VERSION.SDK_INT > 29) {
                    fCeil = (float) Math.ceil(fCeil);
                }
                if (yogaMeasureMode2 != YogaMeasureMode.EXACTLY) {
                    lineBottom = layoutMeasureSpannedText.getLineBottom(iMin - 1);
                    if (yogaMeasureMode2 == YogaMeasureMode.AT_MOST && lineBottom > f2) {
                        lineBottom = f2;
                    }
                } else {
                    lineBottom = f2;
                }
                return YogaMeasureOutput.make(fCeil, lineBottom);
            }
        };
        this.mTextBaselineFunction = new YogaBaselineFunction() { // from class: com.facebook.react.views.text.ReactTextShadowNode.2
            @Override // com.facebook.yoga.YogaBaselineFunction
            public float baseline(YogaNode yogaNode, float f, float f2) {
                Layout layoutMeasureSpannedText = ReactTextShadowNode.this.measureSpannedText((Spannable) Assertions.assertNotNull(ReactTextShadowNode.this.mPreparedSpannableText, "Spannable element has not been prepared in onBeforeLayout"), f, YogaMeasureMode.EXACTLY);
                return layoutMeasureSpannedText.getLineBaseline(layoutMeasureSpannedText.getLineCount() - 1);
            }
        };
        initMeasureFunction();
    }

    private void initMeasureFunction() {
        if (isVirtual()) {
            return;
        }
        setMeasureFunction(this.mTextMeasureFunction);
        setBaselineFunction(this.mTextBaselineFunction);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Layout measureSpannedText(Spannable spannable, float f, YogaMeasureMode yogaMeasureMode) {
        TextPaint textPaint = sTextPaintInstance;
        textPaint.setTextSize(this.mTextAttributes.getEffectiveFontSize());
        BoringLayout.Metrics metricsIsBoring = BoringLayout.isBoring(spannable, textPaint);
        float desiredWidth = metricsIsBoring == null ? Layout.getDesiredWidth(spannable, textPaint) : Float.NaN;
        boolean z = yogaMeasureMode == YogaMeasureMode.UNDEFINED || f < 0.0f;
        Layout.Alignment alignment = Layout.Alignment.ALIGN_NORMAL;
        int textAlign = getTextAlign();
        if (textAlign == 1) {
            alignment = Layout.Alignment.ALIGN_CENTER;
        } else if (textAlign != 3 && textAlign == 5) {
            alignment = Layout.Alignment.ALIGN_OPPOSITE;
        }
        Layout.Alignment alignment2 = alignment;
        if (metricsIsBoring == null && (z || (!YogaConstants.isUndefined(desiredWidth) && desiredWidth <= f))) {
            StaticLayout.Builder hyphenationFrequency = StaticLayout.Builder.obtain(spannable, 0, spannable.length(), textPaint, (int) Math.ceil(desiredWidth)).setAlignment(alignment2).setLineSpacing(0.0f, 1.0f).setIncludePad(this.mIncludeFontPadding).setBreakStrategy(this.mTextBreakStrategy).setHyphenationFrequency(this.mHyphenationFrequency);
            int i = Build.VERSION.SDK_INT;
            if (i >= 26) {
                hyphenationFrequency.setJustificationMode(this.mJustificationMode);
            }
            if (i >= 28) {
                hyphenationFrequency.setUseLineSpacingFromFallbacks(true);
            }
            return hyphenationFrequency.build();
        }
        if (metricsIsBoring != null && (z || metricsIsBoring.width <= f)) {
            return BoringLayout.make(spannable, textPaint, Math.max(metricsIsBoring.width, 0), alignment2, 1.0f, 0.0f, metricsIsBoring, this.mIncludeFontPadding);
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 > 29) {
            f = (float) Math.ceil(f);
        }
        StaticLayout.Builder hyphenationFrequency2 = StaticLayout.Builder.obtain(spannable, 0, spannable.length(), textPaint, (int) f).setAlignment(alignment2).setLineSpacing(0.0f, 1.0f).setIncludePad(this.mIncludeFontPadding).setBreakStrategy(this.mTextBreakStrategy).setHyphenationFrequency(this.mHyphenationFrequency);
        if (i2 >= 26) {
            hyphenationFrequency2.setJustificationMode(this.mJustificationMode);
        }
        if (i2 >= 28) {
            hyphenationFrequency2.setUseLineSpacingFromFallbacks(true);
        }
        return hyphenationFrequency2.build();
    }

    private int getTextAlign() {
        int i = this.mTextAlign;
        if (getLayoutDirection() != YogaDirection.RTL) {
            return i;
        }
        if (i == 5) {
            return 3;
        }
        if (i == 3) {
            return 5;
        }
        return i;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNodeImpl, com.facebook.react.uimanager.ReactShadowNode
    public void onBeforeLayout(NativeViewHierarchyOptimizer nativeViewHierarchyOptimizer) {
        this.mPreparedSpannableText = spannedFromShadowNode(this, null, true, nativeViewHierarchyOptimizer);
        markUpdated();
    }

    @Override // com.facebook.react.uimanager.ReactShadowNodeImpl, com.facebook.react.uimanager.ReactShadowNode
    public void markUpdated() {
        super.markUpdated();
        super.dirty();
    }

    @Override // com.facebook.react.uimanager.ReactShadowNodeImpl, com.facebook.react.uimanager.ReactShadowNode
    public void onCollectExtraUpdates(UIViewOperationQueue uIViewOperationQueue) {
        super.onCollectExtraUpdates(uIViewOperationQueue);
        Spannable spannable = this.mPreparedSpannableText;
        if (spannable != null) {
            uIViewOperationQueue.enqueueUpdateExtraData(getReactTag(), new ReactTextUpdate(spannable, -1, this.mContainsImages, getPadding(4), getPadding(1), getPadding(5), getPadding(3), getTextAlign(), this.mTextBreakStrategy, this.mJustificationMode));
        }
    }

    @ReactProp(name = "onTextLayout")
    public void setShouldNotifyOnTextLayout(boolean z) {
        this.mShouldNotifyOnTextLayout = z;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNodeImpl, com.facebook.react.uimanager.ReactShadowNode
    public Iterable<? extends ReactShadowNode> calculateLayoutOnChildren() {
        Map<Integer, ReactShadowNode> map = this.mInlineViews;
        if (map == null || map.isEmpty()) {
            return null;
        }
        Spanned spanned = (Spanned) Assertions.assertNotNull(this.mPreparedSpannableText, "Spannable element has not been prepared in onBeforeLayout");
        TextInlineViewPlaceholderSpan[] textInlineViewPlaceholderSpanArr = (TextInlineViewPlaceholderSpan[]) spanned.getSpans(0, spanned.length(), TextInlineViewPlaceholderSpan.class);
        ArrayList arrayList = new ArrayList(textInlineViewPlaceholderSpanArr.length);
        for (TextInlineViewPlaceholderSpan textInlineViewPlaceholderSpan : textInlineViewPlaceholderSpanArr) {
            ReactShadowNode reactShadowNode = this.mInlineViews.get(Integer.valueOf(textInlineViewPlaceholderSpan.getReactTag()));
            reactShadowNode.calculateLayout();
            arrayList.add(reactShadowNode);
        }
        return arrayList;
    }
}
