package com.facebook.react.views.text;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.TintContextWrapper;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.internal.SystraceSection;
import com.facebook.react.uimanager.BackgroundStyleApplicator;
import com.facebook.react.uimanager.LengthPercentage;
import com.facebook.react.uimanager.LengthPercentageType;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ReactCompoundView;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.common.ViewUtil;
import com.facebook.react.uimanager.style.BorderRadiusProp;
import com.facebook.react.uimanager.style.BorderStyle;
import com.facebook.react.uimanager.style.LogicalEdge;
import com.facebook.react.uimanager.style.Overflow;
import com.facebook.react.views.text.internal.span.ReactTagSpan;
import com.facebook.react.views.text.internal.span.TextInlineImageSpan;
import com.facebook.react.views.text.internal.span.TextInlineViewPlaceholderSpan;
import com.facebook.yoga.YogaMeasureMode;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class ReactTextView extends AppCompatTextView implements ReactCompoundView {
    private static final int DEFAULT_GRAVITY = 8388659;
    private static final ViewGroup.LayoutParams EMPTY_LAYOUT_PARAMS = new ViewGroup.LayoutParams(0, 0);
    private boolean mAdjustsFontSizeToFit;
    private boolean mContainsImages;
    private TextUtils.TruncateAt mEllipsizeLocation;
    private float mFontSize;
    private float mLetterSpacing;
    private int mLinkifyMaskType;
    private float mMinimumFontSize;
    private boolean mNotifyOnInlineViewLayout;
    private int mNumberOfLines;
    private Overflow mOverflow;
    private boolean mShouldAdjustSpannableFontSize;
    private Spannable mSpanned;
    private boolean mTextIsSelectable;

    @Override // android.widget.TextView, android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    public ReactTextView(Context context) {
        super(context);
        this.mOverflow = Overflow.VISIBLE;
        initView();
    }

    private void initView() {
        this.mNumberOfLines = Integer.MAX_VALUE;
        this.mAdjustsFontSizeToFit = false;
        this.mLinkifyMaskType = 0;
        this.mNotifyOnInlineViewLayout = false;
        this.mTextIsSelectable = false;
        this.mShouldAdjustSpannableFontSize = false;
        this.mEllipsizeLocation = TextUtils.TruncateAt.END;
        this.mFontSize = Float.NaN;
        this.mMinimumFontSize = Float.NaN;
        this.mLetterSpacing = 0.0f;
        this.mOverflow = Overflow.VISIBLE;
        this.mSpanned = null;
    }

    void recycleView() {
        initView();
        BackgroundStyleApplicator.reset(this);
        setBreakStrategy(0);
        setMovementMethod(getDefaultMovementMethod());
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            setJustificationMode(0);
        }
        setLayoutParams(EMPTY_LAYOUT_PARAMS);
        super.setText((CharSequence) null);
        applyTextAttributes();
        setGravity(8388659);
        setNumberOfLines(this.mNumberOfLines);
        setAdjustFontSizeToFit(this.mAdjustsFontSizeToFit);
        setLinkifyMask(this.mLinkifyMaskType);
        setTextIsSelectable(this.mTextIsSelectable);
        setIncludeFontPadding(true);
        setEnabled(true);
        setLinkifyMask(0);
        setEllipsizeLocation(this.mEllipsizeLocation);
        setEnabled(true);
        if (i >= 26) {
            setFocusable(16);
        }
        setHyphenationFrequency(0);
        updateView();
    }

    private static WritableMap inlineViewJson(int i, int i2, int i3, int i4, int i5, int i6) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        if (i == 8) {
            writableMapCreateMap.putString("visibility", "gone");
            writableMapCreateMap.putInt(FirebaseAnalytics.Param.INDEX, i2);
        } else if (i == 0) {
            writableMapCreateMap.putString("visibility", ViewProps.VISIBLE);
            writableMapCreateMap.putInt(FirebaseAnalytics.Param.INDEX, i2);
            writableMapCreateMap.putDouble("left", PixelUtil.toDIPFromPixel(i3));
            writableMapCreateMap.putDouble("top", PixelUtil.toDIPFromPixel(i4));
            writableMapCreateMap.putDouble(ViewProps.RIGHT, PixelUtil.toDIPFromPixel(i5));
            writableMapCreateMap.putDouble(ViewProps.BOTTOM, PixelUtil.toDIPFromPixel(i6));
        } else {
            writableMapCreateMap.putString("visibility", "unknown");
            writableMapCreateMap.putInt(FirebaseAnalytics.Param.INDEX, i2);
        }
        return writableMapCreateMap;
    }

    private ReactContext getReactContext() {
        Context context = getContext();
        if (context instanceof TintContextWrapper) {
            return (ReactContext) ((TintContextWrapper) context).getBaseContext();
        }
        return (ReactContext) context;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:40:0x00d1  */
    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        TextInlineViewPlaceholderSpan[] textInlineViewPlaceholderSpanArr;
        int i5;
        Spanned spanned;
        float secondaryHorizontal;
        int lineRight;
        int totalPaddingLeft;
        float lineWidth;
        int id = getId();
        if (!(getText() instanceof Spanned) || ViewUtil.getUIManagerType(id) == 2) {
            return;
        }
        UIManagerModule uIManagerModule = (UIManagerModule) Assertions.assertNotNull((UIManagerModule) getReactContext().getNativeModule(UIManagerModule.class));
        Spanned spanned2 = (Spanned) getText();
        Layout layout = getLayout();
        if (layout == null) {
            return;
        }
        TextInlineViewPlaceholderSpan[] textInlineViewPlaceholderSpanArr2 = (TextInlineViewPlaceholderSpan[]) spanned2.getSpans(0, spanned2.length(), TextInlineViewPlaceholderSpan.class);
        ArrayList arrayList = this.mNotifyOnInlineViewLayout ? new ArrayList(textInlineViewPlaceholderSpanArr2.length) : null;
        int i6 = i3 - i;
        int length = textInlineViewPlaceholderSpanArr2.length;
        int i7 = 0;
        while (i7 < length) {
            TextInlineViewPlaceholderSpan textInlineViewPlaceholderSpan = textInlineViewPlaceholderSpanArr2[i7];
            View viewResolveView = uIManagerModule.resolveView(textInlineViewPlaceholderSpan.getReactTag());
            int spanStart = spanned2.getSpanStart(textInlineViewPlaceholderSpan);
            int lineForOffset = layout.getLineForOffset(spanStart);
            if ((layout.getEllipsisCount(lineForOffset) > 0 && spanStart >= layout.getLineStart(lineForOffset) + layout.getEllipsisStart(lineForOffset)) || lineForOffset >= this.mNumberOfLines || spanStart >= layout.getLineEnd(lineForOffset)) {
                spanned = spanned2;
                textInlineViewPlaceholderSpanArr = textInlineViewPlaceholderSpanArr2;
                i5 = length;
                viewResolveView.setVisibility(8);
                if (this.mNotifyOnInlineViewLayout) {
                    arrayList.add(inlineViewJson(8, spanStart, -1, -1, -1, -1));
                }
            } else {
                int width = textInlineViewPlaceholderSpan.getWidth();
                int height = textInlineViewPlaceholderSpan.getHeight();
                boolean zIsRtlCharAt = layout.isRtlCharAt(spanStart);
                textInlineViewPlaceholderSpanArr = textInlineViewPlaceholderSpanArr2;
                i5 = length;
                boolean z2 = layout.getParagraphDirection(lineForOffset) == -1;
                if (spanStart == spanned2.length() - 1) {
                    if (spanned2.length() > 0) {
                        spanned = spanned2;
                        if (spanned2.charAt(layout.getLineEnd(lineForOffset) - 1) == '\n') {
                            lineWidth = layout.getLineMax(lineForOffset);
                        }
                        if (z2) {
                            lineRight = i6 - ((int) lineWidth);
                        } else {
                            lineRight = (int) layout.getLineRight(lineForOffset);
                            lineRight -= width;
                        }
                    } else {
                        spanned = spanned2;
                    }
                    lineWidth = layout.getLineWidth(lineForOffset);
                    if (z2) {
                        lineRight = i6 - ((int) lineWidth);
                    } else {
                        lineRight = (int) layout.getLineRight(lineForOffset);
                        lineRight -= width;
                    }
                } else {
                    spanned = spanned2;
                    if (z2 == zIsRtlCharAt) {
                        secondaryHorizontal = layout.getPrimaryHorizontal(spanStart);
                    } else {
                        secondaryHorizontal = layout.getSecondaryHorizontal(spanStart);
                    }
                    lineRight = (int) secondaryHorizontal;
                    if (z2) {
                        lineRight = i6 - (((int) layout.getLineRight(lineForOffset)) - lineRight);
                    }
                    if (zIsRtlCharAt) {
                        lineRight -= width;
                    }
                }
                if (zIsRtlCharAt) {
                    totalPaddingLeft = getTotalPaddingRight();
                } else {
                    totalPaddingLeft = getTotalPaddingLeft();
                }
                int i8 = lineRight + totalPaddingLeft;
                int i9 = i + i8;
                int totalPaddingTop = (getTotalPaddingTop() + layout.getLineBaseline(lineForOffset)) - height;
                int i10 = i2 + totalPaddingTop;
                int i11 = (i6 <= i8 || i4 - i2 <= totalPaddingTop) ? 8 : 0;
                int i12 = i9 + width;
                int i13 = i10 + height;
                viewResolveView.setVisibility(i11);
                viewResolveView.layout(i9, i10, i12, i13);
                if (this.mNotifyOnInlineViewLayout) {
                    arrayList.add(inlineViewJson(i11, spanStart, i9, i10, i12, i13));
                }
            }
            i7++;
            textInlineViewPlaceholderSpanArr2 = textInlineViewPlaceholderSpanArr;
            length = i5;
            spanned2 = spanned;
        }
        if (this.mNotifyOnInlineViewLayout) {
            Collections.sort(arrayList, new Comparator() { // from class: com.facebook.react.views.text.ReactTextView.1
                @Override // java.util.Comparator
                public int compare(Object obj, Object obj2) {
                    return ((WritableMap) obj).getInt(FirebaseAnalytics.Param.INDEX) - ((WritableMap) obj2).getInt(FirebaseAnalytics.Param.INDEX);
                }
            });
            WritableArray writableArrayCreateArray = Arguments.createArray();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                writableArrayCreateArray.pushMap((WritableMap) it2.next());
            }
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putArray("inlineViews", writableArrayCreateArray);
            if (uIManagerModule != null) {
                uIManagerModule.receiveEvent(id, "topInlineViewLayout", writableMapCreateMap);
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        SystraceSection systraceSection = new SystraceSection("ReactTextView.onDraw");
        try {
            if (this.mAdjustsFontSizeToFit && getSpanned() != null && this.mShouldAdjustSpannableFontSize) {
                this.mShouldAdjustSpannableFontSize = false;
                Spannable spanned = getSpanned();
                float width = getWidth();
                YogaMeasureMode yogaMeasureMode = YogaMeasureMode.EXACTLY;
                TextLayoutManager.adjustSpannableFontToFit(spanned, width, yogaMeasureMode, getHeight(), yogaMeasureMode, this.mMinimumFontSize, this.mNumberOfLines, getIncludeFontPadding(), getBreakStrategy(), getHyphenationFrequency(), Layout.Alignment.ALIGN_NORMAL, Build.VERSION.SDK_INT < 26 ? -1 : getJustificationMode(), getPaint());
                setText(getSpanned());
            }
            if (this.mOverflow != Overflow.VISIBLE) {
                BackgroundStyleApplicator.clipToPaddingBox(this, canvas);
            }
            super.onDraw(canvas);
            systraceSection.close();
        } catch (Throwable th) {
            try {
                systraceSection.close();
                throw th;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
                throw th;
            }
        }
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        SystraceSection systraceSection = new SystraceSection("ReactTextView.onMeasure");
        try {
            super.onMeasure(i, i2);
            systraceSection.close();
        } catch (Throwable th) {
            try {
                systraceSection.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public void setText(ReactTextUpdate reactTextUpdate) {
        SystraceSection systraceSection = new SystraceSection("ReactTextView.setText(ReactTextUpdate)");
        try {
            this.mContainsImages = reactTextUpdate.containsImages();
            if (getLayoutParams() == null) {
                setLayoutParams(EMPTY_LAYOUT_PARAMS);
            }
            Spannable text = reactTextUpdate.getText();
            int i = this.mLinkifyMaskType;
            if (i > 0) {
                Linkify.addLinks(text, i);
                setMovementMethod(LinkMovementMethod.getInstance());
            }
            setText(text);
            float paddingLeft = reactTextUpdate.getPaddingLeft();
            float paddingTop = reactTextUpdate.getPaddingTop();
            float paddingRight = reactTextUpdate.getPaddingRight();
            float paddingBottom = reactTextUpdate.getPaddingBottom();
            if (paddingLeft != -1.0f && paddingTop != -1.0f && paddingRight != -1.0f && paddingBottom != -1.0f) {
                setPadding((int) Math.floor(paddingLeft), (int) Math.floor(paddingTop), (int) Math.floor(paddingRight), (int) Math.floor(paddingBottom));
            }
            int textAlign = reactTextUpdate.getTextAlign();
            if (textAlign != getGravityHorizontal()) {
                setGravityHorizontal(textAlign);
            }
            if (getBreakStrategy() != reactTextUpdate.getTextBreakStrategy()) {
                setBreakStrategy(reactTextUpdate.getTextBreakStrategy());
            }
            if (Build.VERSION.SDK_INT >= 26 && getJustificationMode() != reactTextUpdate.getJustificationMode()) {
                setJustificationMode(reactTextUpdate.getJustificationMode());
            }
            requestLayout();
            systraceSection.close();
        } catch (Throwable th) {
            try {
                systraceSection.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // com.facebook.react.uimanager.ReactCompoundView
    public int reactTagForTouch(float f, float f2) {
        int i;
        CharSequence text = getText();
        int id = getId();
        int i2 = (int) f;
        int i3 = (int) f2;
        Layout layout = getLayout();
        if (layout == null) {
            return id;
        }
        int lineForVertical = layout.getLineForVertical(i3);
        int lineLeft = (int) layout.getLineLeft(lineForVertical);
        int lineRight = (int) layout.getLineRight(lineForVertical);
        if ((text instanceof Spanned) && i2 >= lineLeft && i2 <= lineRight) {
            Spanned spanned = (Spanned) text;
            try {
                int offsetForHorizontal = layout.getOffsetForHorizontal(lineForVertical, i2);
                ReactTagSpan[] reactTagSpanArr = (ReactTagSpan[]) spanned.getSpans(offsetForHorizontal, offsetForHorizontal, ReactTagSpan.class);
                if (reactTagSpanArr != null) {
                    int length = text.length();
                    for (int i4 = 0; i4 < reactTagSpanArr.length; i4++) {
                        int spanStart = spanned.getSpanStart(reactTagSpanArr[i4]);
                        int spanEnd = spanned.getSpanEnd(reactTagSpanArr[i4]);
                        if (spanEnd >= offsetForHorizontal && (i = spanEnd - spanStart) <= length) {
                            id = reactTagSpanArr[i4].getReactTag();
                            length = i;
                        }
                    }
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                FLog.e(ReactConstants.TAG, "Crash in HorizontalMeasurementProvider: " + e.getMessage());
            }
        }
        return id;
    }

    @Override // android.widget.TextView, android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        if (this.mContainsImages && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            for (TextInlineImageSpan textInlineImageSpan : (TextInlineImageSpan[]) spanned.getSpans(0, spanned.length(), TextInlineImageSpan.class)) {
                if (textInlineImageSpan.getDrawable() == drawable) {
                    return true;
                }
            }
        }
        return super.verifyDrawable(drawable);
    }

    @Override // android.widget.TextView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        if (this.mContainsImages && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            for (TextInlineImageSpan textInlineImageSpan : (TextInlineImageSpan[]) spanned.getSpans(0, spanned.length(), TextInlineImageSpan.class)) {
                if (textInlineImageSpan.getDrawable() == drawable) {
                    invalidate();
                }
            }
        }
        super.invalidateDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mContainsImages && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            for (TextInlineImageSpan textInlineImageSpan : (TextInlineImageSpan[]) spanned.getSpans(0, spanned.length(), TextInlineImageSpan.class)) {
                textInlineImageSpan.onDetachedFromWindow();
            }
        }
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        if (this.mContainsImages && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            for (TextInlineImageSpan textInlineImageSpan : (TextInlineImageSpan[]) spanned.getSpans(0, spanned.length(), TextInlineImageSpan.class)) {
                textInlineImageSpan.onStartTemporaryDetach();
            }
        }
    }

    @Override // android.widget.TextView
    public void setTextIsSelectable(boolean z) {
        this.mTextIsSelectable = z;
        super.setTextIsSelectable(z);
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setTextIsSelectable(this.mTextIsSelectable);
        if (this.mContainsImages && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            for (TextInlineImageSpan textInlineImageSpan : (TextInlineImageSpan[]) spanned.getSpans(0, spanned.length(), TextInlineImageSpan.class)) {
                textInlineImageSpan.onAttachedToWindow();
            }
        }
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        if (this.mContainsImages && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            for (TextInlineImageSpan textInlineImageSpan : (TextInlineImageSpan[]) spanned.getSpans(0, spanned.length(), TextInlineImageSpan.class)) {
                textInlineImageSpan.onFinishTemporaryDetach();
            }
        }
    }

    int getGravityHorizontal() {
        return getGravity() & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
    }

    void setGravityHorizontal(int i) {
        if (i == 0) {
            i = GravityCompat.START;
        }
        setGravity(i | (getGravity() & (-8388616)));
    }

    void setGravityVertical(int i) {
        if (i == 0) {
            i = 48;
        }
        setGravity(i | (getGravity() & (-113)));
    }

    public void setNumberOfLines(int i) {
        if (i == 0) {
            i = Integer.MAX_VALUE;
        }
        this.mNumberOfLines = i;
        setMaxLines(i);
        this.mShouldAdjustSpannableFontSize = true;
    }

    public void setAdjustFontSizeToFit(boolean z) {
        this.mAdjustsFontSizeToFit = z;
    }

    public void setFontSize(float f) {
        double dCeil;
        if (this.mAdjustsFontSizeToFit) {
            dCeil = Math.ceil(PixelUtil.toPixelFromSP(f));
        } else {
            dCeil = Math.ceil(PixelUtil.toPixelFromDIP(f));
        }
        this.mFontSize = (float) dCeil;
        applyTextAttributes();
    }

    public void setMinimumFontSize(float f) {
        this.mMinimumFontSize = f;
        this.mShouldAdjustSpannableFontSize = true;
    }

    @Override // android.widget.TextView
    public void setIncludeFontPadding(boolean z) {
        super.setIncludeFontPadding(z);
        this.mShouldAdjustSpannableFontSize = true;
    }

    @Override // android.widget.TextView
    public void setBreakStrategy(int i) {
        super.setBreakStrategy(i);
        this.mShouldAdjustSpannableFontSize = true;
    }

    @Override // android.widget.TextView
    public void setHyphenationFrequency(int i) {
        super.setHyphenationFrequency(i);
        this.mShouldAdjustSpannableFontSize = true;
    }

    @Override // android.widget.TextView
    public void setLetterSpacing(float f) {
        if (Float.isNaN(f)) {
            return;
        }
        this.mLetterSpacing = PixelUtil.toPixelFromDIP(f) / this.mFontSize;
        applyTextAttributes();
    }

    public void setEllipsizeLocation(TextUtils.TruncateAt truncateAt) {
        this.mEllipsizeLocation = truncateAt;
    }

    public void setNotifyOnInlineViewLayout(boolean z) {
        this.mNotifyOnInlineViewLayout = z;
    }

    public void updateView() {
        setEllipsize((this.mNumberOfLines == Integer.MAX_VALUE || this.mAdjustsFontSizeToFit) ? null : this.mEllipsizeLocation);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        BackgroundStyleApplicator.setBackgroundColor(this, Integer.valueOf(i));
    }

    public void setBorderWidth(int i, float f) {
        BackgroundStyleApplicator.setBorderWidth(this, LogicalEdge.values()[i], Float.valueOf(PixelUtil.toDIPFromPixel(f)));
    }

    public void setBorderColor(int i, @Nullable Integer num) {
        BackgroundStyleApplicator.setBorderColor(this, LogicalEdge.values()[i], num);
    }

    public void setBorderRadius(float f) {
        setBorderRadius(f, BorderRadiusProp.BORDER_RADIUS.ordinal());
    }

    public void setBorderRadius(float f, int i) {
        BackgroundStyleApplicator.setBorderRadius(this, BorderRadiusProp.values()[i], Float.isNaN(f) ? null : new LengthPercentage(PixelUtil.toDIPFromPixel(f), LengthPercentageType.POINT));
    }

    public void setBorderStyle(@Nullable String str) {
        BackgroundStyleApplicator.setBorderStyle(this, str == null ? null : BorderStyle.fromString(str));
    }

    public void setSpanned(Spannable spannable) {
        this.mSpanned = spannable;
        this.mShouldAdjustSpannableFontSize = true;
    }

    public Spannable getSpanned() {
        return this.mSpanned;
    }

    public void setLinkifyMask(int i) {
        this.mLinkifyMaskType = i;
    }

    @Override // android.view.View
    protected boolean dispatchHoverEvent(MotionEvent motionEvent) {
        if (ViewCompat.hasAccessibilityDelegate(this)) {
            AccessibilityDelegateCompat accessibilityDelegate = ViewCompat.getAccessibilityDelegate(this);
            if (accessibilityDelegate instanceof ExploreByTouchHelper) {
                return ((ExploreByTouchHelper) accessibilityDelegate).dispatchHoverEvent(motionEvent) || super.dispatchHoverEvent(motionEvent);
            }
        }
        return super.dispatchHoverEvent(motionEvent);
    }

    private void applyTextAttributes() {
        if (!Float.isNaN(this.mFontSize)) {
            setTextSize(0, this.mFontSize);
        }
        if (Float.isNaN(this.mLetterSpacing)) {
            return;
        }
        super.setLetterSpacing(this.mLetterSpacing);
    }

    public void setOverflow(@Nullable String str) {
        if (str == null) {
            this.mOverflow = Overflow.VISIBLE;
        } else {
            Overflow overflowFromString = Overflow.fromString(str);
            if (overflowFromString == null) {
                overflowFromString = Overflow.VISIBLE;
            }
            this.mOverflow = overflowFromString;
        }
        invalidate();
    }
}
