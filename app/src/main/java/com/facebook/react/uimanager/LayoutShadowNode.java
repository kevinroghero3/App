package com.facebook.react.uimanager;

import androidx.annotation.Nullable;
import com.facebook.appevents.codeless.internal.Constants;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.modules.i18nmanager.I18nUtil;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import com.facebook.yoga.YogaAlign;
import com.facebook.yoga.YogaDisplay;
import com.facebook.yoga.YogaFlexDirection;
import com.facebook.yoga.YogaJustify;
import com.facebook.yoga.YogaOverflow;
import com.facebook.yoga.YogaPositionType;
import com.facebook.yoga.YogaUnit;
import com.facebook.yoga.YogaWrap;

/* JADX INFO: loaded from: classes.dex */
public class LayoutShadowNode extends ReactShadowNodeImpl {
    boolean mCollapsable;
    private final MutableYogaValue mTempYogaValue = new MutableYogaValue();

    @ReactProp(name = ViewProps.COLLAPSABLE_CHILDREN)
    public void setCollapsableChildren(boolean z) {
    }

    @ReactProp(name = "inset")
    public void setInset(Dynamic dynamic) {
    }

    @ReactPropGroup(names = {"insetBlock", "insetBlockEnd", "insetBlockStart"})
    public void setInsetBlock(int i, Dynamic dynamic) {
    }

    @ReactPropGroup(names = {"insetInline", "insetInlineEnd", "insetInlineStart"})
    public void setInsetInline(int i, Dynamic dynamic) {
    }

    @ReactPropGroup(names = {"marginBlock", "marginBlockEnd", "marginBlockStart"})
    public void setMarginBlock(int i, Dynamic dynamic) {
    }

    @ReactPropGroup(names = {"marginInline", "marginInlineEnd", "marginInlineStart"})
    public void setMarginInline(int i, Dynamic dynamic) {
    }

    @ReactPropGroup(names = {"paddingBlock", "paddingBlockEnd", "paddingBlockStart"})
    public void setPaddingBlock(int i, Dynamic dynamic) {
    }

    @ReactPropGroup(names = {"paddingInline", "paddingInlineEnd", "paddingInlineStart"})
    public void setPaddingInline(int i, Dynamic dynamic) {
    }

    @ReactProp(name = ViewProps.ON_POINTER_ENTER)
    public void setShouldNotifyPointerEnter(boolean z) {
    }

    @ReactProp(name = ViewProps.ON_POINTER_LEAVE)
    public void setShouldNotifyPointerLeave(boolean z) {
    }

    @ReactProp(name = ViewProps.ON_POINTER_MOVE)
    public void setShouldNotifyPointerMove(boolean z) {
    }

    /* JADX INFO: loaded from: classes2.dex */
    static class MutableYogaValue {
        YogaUnit unit;
        float value;

        private MutableYogaValue() {
        }

        private MutableYogaValue(MutableYogaValue mutableYogaValue) {
            this.value = mutableYogaValue.value;
            this.unit = mutableYogaValue.unit;
        }

        void setFromDynamic(Dynamic dynamic) {
            if (dynamic.isNull()) {
                this.unit = YogaUnit.UNDEFINED;
                this.value = Float.NaN;
                return;
            }
            if (dynamic.getType() == ReadableType.String) {
                String strAsString = dynamic.asString();
                if (strAsString.equals("auto")) {
                    this.unit = YogaUnit.AUTO;
                    this.value = Float.NaN;
                    return;
                } else {
                    if (strAsString.endsWith("%")) {
                        this.unit = YogaUnit.PERCENT;
                        this.value = Float.parseFloat(strAsString.substring(0, strAsString.length() - 1));
                        return;
                    }
                    FLog.w(ReactConstants.TAG, "Unknown value: " + strAsString);
                    this.unit = YogaUnit.UNDEFINED;
                    this.value = Float.NaN;
                    return;
                }
            }
            if (dynamic.getType() == ReadableType.Number) {
                this.unit = YogaUnit.POINT;
                this.value = PixelUtil.toPixelFromDIP(dynamic.asDouble());
            } else {
                this.unit = YogaUnit.UNDEFINED;
                this.value = Float.NaN;
            }
        }
    }

    @ReactProp(name = "width")
    public void setWidth(Dynamic dynamic) {
        if (isVirtual()) {
            return;
        }
        this.mTempYogaValue.setFromDynamic(dynamic);
        int i = AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()];
        if (i == 1 || i == 2) {
            setStyleWidth(this.mTempYogaValue.value);
        } else if (i == 3) {
            setStyleWidthAuto();
        } else if (i == 4) {
            setStyleWidthPercent(this.mTempYogaValue.value);
        }
        dynamic.recycle();
    }

    /* JADX INFO: renamed from: com.facebook.react.uimanager.LayoutShadowNode$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$yoga$YogaUnit;

        static {
            int[] iArr = new int[YogaUnit.values().length];
            $SwitchMap$com$facebook$yoga$YogaUnit = iArr;
            try {
                iArr[YogaUnit.POINT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$facebook$yoga$YogaUnit[YogaUnit.UNDEFINED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$facebook$yoga$YogaUnit[YogaUnit.AUTO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$facebook$yoga$YogaUnit[YogaUnit.PERCENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @ReactProp(name = ViewProps.MIN_WIDTH)
    public void setMinWidth(Dynamic dynamic) {
        if (isVirtual()) {
            return;
        }
        this.mTempYogaValue.setFromDynamic(dynamic);
        int i = AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()];
        if (i == 1 || i == 2) {
            setStyleMinWidth(this.mTempYogaValue.value);
        } else if (i == 4) {
            setStyleMinWidthPercent(this.mTempYogaValue.value);
        }
        dynamic.recycle();
    }

    @ReactProp(name = ViewProps.COLLAPSABLE)
    public void setCollapsable(boolean z) {
        this.mCollapsable = z;
    }

    @ReactProp(name = ViewProps.MAX_WIDTH)
    public void setMaxWidth(Dynamic dynamic) {
        if (isVirtual()) {
            return;
        }
        this.mTempYogaValue.setFromDynamic(dynamic);
        int i = AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()];
        if (i == 1 || i == 2) {
            setStyleMaxWidth(this.mTempYogaValue.value);
        } else if (i == 4) {
            setStyleMaxWidthPercent(this.mTempYogaValue.value);
        }
        dynamic.recycle();
    }

    @ReactProp(name = "height")
    public void setHeight(Dynamic dynamic) {
        if (isVirtual()) {
            return;
        }
        this.mTempYogaValue.setFromDynamic(dynamic);
        int i = AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()];
        if (i == 1 || i == 2) {
            setStyleHeight(this.mTempYogaValue.value);
        } else if (i == 3) {
            setStyleHeightAuto();
        } else if (i == 4) {
            setStyleHeightPercent(this.mTempYogaValue.value);
        }
        dynamic.recycle();
    }

    @ReactProp(name = ViewProps.MIN_HEIGHT)
    public void setMinHeight(Dynamic dynamic) {
        if (isVirtual()) {
            return;
        }
        this.mTempYogaValue.setFromDynamic(dynamic);
        int i = AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()];
        if (i == 1 || i == 2) {
            setStyleMinHeight(this.mTempYogaValue.value);
        } else if (i == 4) {
            setStyleMinHeightPercent(this.mTempYogaValue.value);
        }
        dynamic.recycle();
    }

    @ReactProp(name = ViewProps.MAX_HEIGHT)
    public void setMaxHeight(Dynamic dynamic) {
        if (isVirtual()) {
            return;
        }
        this.mTempYogaValue.setFromDynamic(dynamic);
        int i = AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()];
        if (i == 1 || i == 2) {
            setStyleMaxHeight(this.mTempYogaValue.value);
        } else if (i == 4) {
            setStyleMaxHeightPercent(this.mTempYogaValue.value);
        }
        dynamic.recycle();
    }

    @Override // com.facebook.react.uimanager.ReactShadowNodeImpl, com.facebook.react.uimanager.ReactShadowNode
    @ReactProp(defaultFloat = 0.0f, name = ViewProps.FLEX)
    public void setFlex(float f) {
        if (isVirtual()) {
            return;
        }
        super.setFlex(f);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNodeImpl, com.facebook.react.uimanager.ReactShadowNode
    @ReactProp(defaultFloat = 0.0f, name = ViewProps.FLEX_GROW)
    public void setFlexGrow(float f) {
        if (isVirtual()) {
            return;
        }
        super.setFlexGrow(f);
    }

    @ReactProp(name = ViewProps.ROW_GAP)
    public void setRowGap(Dynamic dynamic) {
        if (isVirtual()) {
            return;
        }
        this.mTempYogaValue.setFromDynamic(dynamic);
        int i = AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            setRowGap(this.mTempYogaValue.value);
        } else if (i == 4) {
            setRowGapPercent(this.mTempYogaValue.value);
        }
        dynamic.recycle();
    }

    @ReactProp(name = ViewProps.COLUMN_GAP)
    public void setColumnGap(Dynamic dynamic) {
        if (isVirtual()) {
            return;
        }
        this.mTempYogaValue.setFromDynamic(dynamic);
        int i = AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            setColumnGap(this.mTempYogaValue.value);
        } else if (i == 4) {
            setColumnGapPercent(this.mTempYogaValue.value);
        }
        dynamic.recycle();
    }

    @ReactProp(name = ViewProps.GAP)
    public void setGap(Dynamic dynamic) {
        if (isVirtual()) {
            return;
        }
        this.mTempYogaValue.setFromDynamic(dynamic);
        int i = AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            setGap(this.mTempYogaValue.value);
        } else if (i == 4) {
            setGapPercent(this.mTempYogaValue.value);
        }
        dynamic.recycle();
    }

    @Override // com.facebook.react.uimanager.ReactShadowNodeImpl, com.facebook.react.uimanager.ReactShadowNode
    @ReactProp(defaultFloat = 0.0f, name = ViewProps.FLEX_SHRINK)
    public void setFlexShrink(float f) {
        if (isVirtual()) {
            return;
        }
        super.setFlexShrink(f);
    }

    @ReactProp(name = ViewProps.FLEX_BASIS)
    public void setFlexBasis(Dynamic dynamic) {
        if (isVirtual()) {
            return;
        }
        this.mTempYogaValue.setFromDynamic(dynamic);
        int i = AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()];
        if (i == 1 || i == 2) {
            setFlexBasis(this.mTempYogaValue.value);
        } else if (i == 3) {
            setFlexBasisAuto();
        } else if (i == 4) {
            setFlexBasisPercent(this.mTempYogaValue.value);
        }
        dynamic.recycle();
    }

    @ReactProp(defaultFloat = Float.NaN, name = ViewProps.ASPECT_RATIO)
    public void setAspectRatio(float f) {
        setStyleAspectRatio(f);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:27:0x0046  */
    @ReactProp(name = ViewProps.FLEX_DIRECTION)
    public void setFlexDirection(@Nullable String str) {
        byte b;
        if (isVirtual()) {
            return;
        }
        if (str == null) {
            setFlexDirection(YogaFlexDirection.COLUMN);
            return;
        }
        switch (str) {
            case "row-reverse":
                b = 0;
                break;
            case "column":
                b = 1;
                break;
            case "row":
                b = 2;
                break;
            case "column-reverse":
                b = 3;
                break;
            default:
                b = -1;
                break;
        }
        if (b == 0) {
            setFlexDirection(YogaFlexDirection.ROW_REVERSE);
            return;
        }
        if (b == 1) {
            setFlexDirection(YogaFlexDirection.COLUMN);
            return;
        }
        if (b == 2) {
            setFlexDirection(YogaFlexDirection.ROW);
            return;
        }
        if (b == 3) {
            setFlexDirection(YogaFlexDirection.COLUMN_REVERSE);
            return;
        }
        FLog.w(ReactConstants.TAG, "invalid value for flexDirection: " + str);
        setFlexDirection(YogaFlexDirection.COLUMN);
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0043  */
    @ReactProp(name = ViewProps.FLEX_WRAP)
    public void setFlexWrap(@Nullable String str) {
        byte b;
        if (isVirtual()) {
            return;
        }
        if (str == null) {
            setFlexWrap(YogaWrap.NO_WRAP);
            return;
        }
        int iHashCode = str.hashCode();
        if (iHashCode != -1039592053) {
            if (iHashCode != -749527969) {
                if (iHashCode == 3657802 && str.equals("wrap")) {
                    b = 2;
                } else {
                    b = -1;
                }
            } else if (str.equals("wrap-reverse")) {
                b = 1;
            } else {
                b = -1;
            }
        } else if (str.equals("nowrap")) {
            b = 0;
        } else {
            b = -1;
        }
        if (b == 0) {
            setFlexWrap(YogaWrap.NO_WRAP);
            return;
        }
        if (b == 1) {
            setFlexWrap(YogaWrap.WRAP_REVERSE);
            return;
        }
        if (b == 2) {
            setFlexWrap(YogaWrap.WRAP);
            return;
        }
        FLog.w(ReactConstants.TAG, "invalid value for flexWrap: " + str);
        setFlexWrap(YogaWrap.NO_WRAP);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:43:0x0070  */
    @ReactProp(name = ViewProps.ALIGN_SELF)
    public void setAlignSelf(@Nullable String str) {
        if (isVirtual()) {
        }
        if (str == null) {
            setAlignSelf(YogaAlign.AUTO);
            return;
        }
        switch (str) {
            case "stretch":
                setAlignSelf(YogaAlign.STRETCH);
                break;
            case "baseline":
                setAlignSelf(YogaAlign.BASELINE);
                break;
            case "center":
                setAlignSelf(YogaAlign.CENTER);
                break;
            case "flex-start":
                setAlignSelf(YogaAlign.FLEX_START);
                break;
            case "auto":
                setAlignSelf(YogaAlign.AUTO);
                break;
            case "space-between":
                setAlignSelf(YogaAlign.SPACE_BETWEEN);
                break;
            case "flex-end":
                setAlignSelf(YogaAlign.FLEX_END);
                break;
            case "space-around":
                setAlignSelf(YogaAlign.SPACE_AROUND);
                break;
            default:
                FLog.w(ReactConstants.TAG, "invalid value for alignSelf: " + str);
                setAlignSelf(YogaAlign.AUTO);
                break;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:43:0x0070  */
    @ReactProp(name = ViewProps.ALIGN_ITEMS)
    public void setAlignItems(@Nullable String str) {
        if (isVirtual()) {
        }
        if (str == null) {
            setAlignItems(YogaAlign.STRETCH);
            return;
        }
        switch (str) {
            case "stretch":
                setAlignItems(YogaAlign.STRETCH);
                break;
            case "baseline":
                setAlignItems(YogaAlign.BASELINE);
                break;
            case "center":
                setAlignItems(YogaAlign.CENTER);
                break;
            case "flex-start":
                setAlignItems(YogaAlign.FLEX_START);
                break;
            case "auto":
                setAlignItems(YogaAlign.AUTO);
                break;
            case "space-between":
                setAlignItems(YogaAlign.SPACE_BETWEEN);
                break;
            case "flex-end":
                setAlignItems(YogaAlign.FLEX_END);
                break;
            case "space-around":
                setAlignItems(YogaAlign.SPACE_AROUND);
                break;
            default:
                FLog.w(ReactConstants.TAG, "invalid value for alignItems: " + str);
                setAlignItems(YogaAlign.STRETCH);
                break;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:47:0x007e  */
    @ReactProp(name = ViewProps.ALIGN_CONTENT)
    public void setAlignContent(@Nullable String str) {
        if (isVirtual()) {
        }
        if (str == null) {
            setAlignContent(YogaAlign.FLEX_START);
            return;
        }
        switch (str) {
            case "stretch":
                setAlignContent(YogaAlign.STRETCH);
                break;
            case "baseline":
                setAlignContent(YogaAlign.BASELINE);
                break;
            case "center":
                setAlignContent(YogaAlign.CENTER);
                break;
            case "flex-start":
                setAlignContent(YogaAlign.FLEX_START);
                break;
            case "auto":
                setAlignContent(YogaAlign.AUTO);
                break;
            case "space-between":
                setAlignContent(YogaAlign.SPACE_BETWEEN);
                break;
            case "flex-end":
                setAlignContent(YogaAlign.FLEX_END);
                break;
            case "space-around":
                setAlignContent(YogaAlign.SPACE_AROUND);
                break;
            case "space-evenly":
                setAlignContent(YogaAlign.SPACE_EVENLY);
                break;
            default:
                FLog.w(ReactConstants.TAG, "invalid value for alignContent: " + str);
                setAlignContent(YogaAlign.FLEX_START);
                break;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:35:0x005e  */
    @ReactProp(name = ViewProps.JUSTIFY_CONTENT)
    public void setJustifyContent(@Nullable String str) {
        byte b;
        if (isVirtual()) {
            return;
        }
        if (str == null) {
            setJustifyContent(YogaJustify.FLEX_START);
            return;
        }
        switch (str) {
            case "center":
                b = 0;
                break;
            case "flex-start":
                b = 1;
                break;
            case "space-between":
                b = 2;
                break;
            case "flex-end":
                b = 3;
                break;
            case "space-around":
                b = 4;
                break;
            case "space-evenly":
                b = 5;
                break;
            default:
                b = -1;
                break;
        }
        if (b == 0) {
            setJustifyContent(YogaJustify.CENTER);
            return;
        }
        if (b == 1) {
            setJustifyContent(YogaJustify.FLEX_START);
            return;
        }
        if (b == 2) {
            setJustifyContent(YogaJustify.SPACE_BETWEEN);
            return;
        }
        if (b == 3) {
            setJustifyContent(YogaJustify.FLEX_END);
            return;
        }
        if (b == 4) {
            setJustifyContent(YogaJustify.SPACE_AROUND);
            return;
        }
        if (b == 5) {
            setJustifyContent(YogaJustify.SPACE_EVENLY);
            return;
        }
        FLog.w(ReactConstants.TAG, "invalid value for justifyContent: " + str);
        setJustifyContent(YogaJustify.FLEX_START);
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0043  */
    @ReactProp(name = ViewProps.OVERFLOW)
    public void setOverflow(@Nullable String str) {
        byte b;
        if (isVirtual()) {
            return;
        }
        if (str == null) {
            setOverflow(YogaOverflow.VISIBLE);
            return;
        }
        int iHashCode = str.hashCode();
        if (iHashCode != -1217487446) {
            if (iHashCode != -907680051) {
                if (iHashCode == 466743410 && str.equals(ViewProps.VISIBLE)) {
                    b = 2;
                } else {
                    b = -1;
                }
            } else if (str.equals(ViewProps.SCROLL)) {
                b = 1;
            } else {
                b = -1;
            }
        } else if (str.equals(ViewProps.HIDDEN)) {
            b = 0;
        } else {
            b = -1;
        }
        if (b == 0) {
            setOverflow(YogaOverflow.HIDDEN);
            return;
        }
        if (b == 1) {
            setOverflow(YogaOverflow.SCROLL);
            return;
        }
        if (b == 2) {
            setOverflow(YogaOverflow.VISIBLE);
            return;
        }
        FLog.w(ReactConstants.TAG, "invalid value for overflow: " + str);
        setOverflow(YogaOverflow.VISIBLE);
    }

    @ReactProp(name = "display")
    public void setDisplay(@Nullable String str) {
        if (isVirtual()) {
            return;
        }
        if (str == null) {
            setDisplay(YogaDisplay.FLEX);
            return;
        }
        if (str.equals(ViewProps.FLEX)) {
            setDisplay(YogaDisplay.FLEX);
            return;
        }
        if (str.equals("none")) {
            setDisplay(YogaDisplay.NONE);
            return;
        }
        FLog.w(ReactConstants.TAG, "invalid value for display: " + str);
        setDisplay(YogaDisplay.FLEX);
    }

    @ReactPropGroup(names = {ViewProps.MARGIN, ViewProps.MARGIN_VERTICAL, ViewProps.MARGIN_HORIZONTAL, ViewProps.MARGIN_START, ViewProps.MARGIN_END, ViewProps.MARGIN_TOP, ViewProps.MARGIN_BOTTOM, ViewProps.MARGIN_LEFT, ViewProps.MARGIN_RIGHT})
    public void setMargins(int i, Dynamic dynamic) {
        if (isVirtual()) {
            return;
        }
        int iMaybeTransformLeftRightToStartEnd = maybeTransformLeftRightToStartEnd(ViewProps.PADDING_MARGIN_SPACING_TYPES[i]);
        this.mTempYogaValue.setFromDynamic(dynamic);
        int i2 = AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()];
        if (i2 == 1 || i2 == 2) {
            setMargin(iMaybeTransformLeftRightToStartEnd, this.mTempYogaValue.value);
        } else if (i2 == 3) {
            setMarginAuto(iMaybeTransformLeftRightToStartEnd);
        } else if (i2 == 4) {
            setMarginPercent(iMaybeTransformLeftRightToStartEnd, this.mTempYogaValue.value);
        }
        dynamic.recycle();
    }

    @ReactPropGroup(names = {ViewProps.PADDING, ViewProps.PADDING_VERTICAL, ViewProps.PADDING_HORIZONTAL, ViewProps.PADDING_START, ViewProps.PADDING_END, ViewProps.PADDING_TOP, ViewProps.PADDING_BOTTOM, ViewProps.PADDING_LEFT, ViewProps.PADDING_RIGHT})
    public void setPaddings(int i, Dynamic dynamic) {
        if (isVirtual()) {
            return;
        }
        int iMaybeTransformLeftRightToStartEnd = maybeTransformLeftRightToStartEnd(ViewProps.PADDING_MARGIN_SPACING_TYPES[i]);
        this.mTempYogaValue.setFromDynamic(dynamic);
        int i2 = AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()];
        if (i2 == 1 || i2 == 2) {
            setPadding(iMaybeTransformLeftRightToStartEnd, this.mTempYogaValue.value);
        } else if (i2 == 4) {
            setPaddingPercent(iMaybeTransformLeftRightToStartEnd, this.mTempYogaValue.value);
        }
        dynamic.recycle();
    }

    @ReactPropGroup(defaultFloat = Float.NaN, names = {ViewProps.BORDER_WIDTH, ViewProps.BORDER_START_WIDTH, ViewProps.BORDER_END_WIDTH, ViewProps.BORDER_TOP_WIDTH, ViewProps.BORDER_BOTTOM_WIDTH, ViewProps.BORDER_LEFT_WIDTH, ViewProps.BORDER_RIGHT_WIDTH})
    public void setBorderWidths(int i, float f) {
        if (isVirtual()) {
            return;
        }
        setBorder(maybeTransformLeftRightToStartEnd(ViewProps.BORDER_SPACING_TYPES[i]), PixelUtil.toPixelFromDIP(f));
    }

    @ReactPropGroup(names = {"start", ViewProps.END, "left", ViewProps.RIGHT, "top", ViewProps.BOTTOM})
    public void setPositionValues(int i, Dynamic dynamic) {
        if (isVirtual()) {
            return;
        }
        int iMaybeTransformLeftRightToStartEnd = maybeTransformLeftRightToStartEnd(new int[]{4, 5, 0, 2, 1, 3}[i]);
        this.mTempYogaValue.setFromDynamic(dynamic);
        int i2 = AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()];
        if (i2 == 1 || i2 == 2) {
            setPosition(iMaybeTransformLeftRightToStartEnd, this.mTempYogaValue.value);
        } else if (i2 == 4) {
            setPositionPercent(iMaybeTransformLeftRightToStartEnd, this.mTempYogaValue.value);
        }
        dynamic.recycle();
    }

    private int maybeTransformLeftRightToStartEnd(int i) {
        if (!I18nUtil.getInstance().doLeftAndRightSwapInRTL(getThemedContext())) {
            return i;
        }
        if (i == 0) {
            return 4;
        }
        if (i != 2) {
            return i;
        }
        return 5;
    }

    @ReactProp(name = ViewProps.POSITION)
    public void setPosition(@Nullable String str) {
        if (isVirtual()) {
            return;
        }
        if (str == null) {
            setPositionType(YogaPositionType.RELATIVE);
            return;
        }
        if (str.equals(Constants.PATH_TYPE_RELATIVE)) {
            setPositionType(YogaPositionType.RELATIVE);
            return;
        }
        if (str.equals(Constants.PATH_TYPE_ABSOLUTE)) {
            setPositionType(YogaPositionType.ABSOLUTE);
            return;
        }
        FLog.w(ReactConstants.TAG, "invalid value for position: " + str);
        setPositionType(YogaPositionType.RELATIVE);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNodeImpl, com.facebook.react.uimanager.ReactShadowNode
    @ReactProp(name = "onLayout")
    public void setShouldNotifyOnLayout(boolean z) {
        super.setShouldNotifyOnLayout(z);
    }
}
