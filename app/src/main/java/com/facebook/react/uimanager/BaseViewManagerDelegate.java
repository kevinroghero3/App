package com.facebook.react.uimanager;

import android.view.View;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.BaseViewManager;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseViewManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode>> implements ViewManagerDelegate<T> {
    public final U mViewManager;

    @Override // com.facebook.react.uimanager.ViewManagerDelegate
    public void receiveCommand(@NotNull T view, @Nullable String str, @Nullable ReadableArray readableArray) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    public BaseViewManagerDelegate(@NotNull U mViewManager) {
        Intrinsics.checkNotNullParameter(mViewManager, "mViewManager");
        this.mViewManager = mViewManager;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(@NotNull T view, @Nullable String str, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (str != null) {
            switch (str.hashCode()) {
                case -2018402664:
                    if (str.equals(ViewProps.MIX_BLEND_MODE)) {
                        this.mViewManager.setMixBlendMode(view, (String) obj);
                        break;
                    }
                    break;
                case -1898517556:
                    if (str.equals(ViewProps.ON_POINTER_ENTER_CAPTURE)) {
                        Boolean bool = (Boolean) obj;
                        this.mViewManager.setPointerEnterCapture(view, bool != null ? bool.booleanValue() : false);
                        break;
                    }
                    break;
                case -1721943862:
                    if (str.equals(ViewProps.TRANSLATE_X)) {
                        Double d = (Double) obj;
                        this.mViewManager.setTranslateX(view, d != null ? (float) d.doubleValue() : 0.0f);
                        break;
                    }
                    break;
                case -1721943861:
                    if (str.equals(ViewProps.TRANSLATE_Y)) {
                        Double d2 = (Double) obj;
                        this.mViewManager.setTranslateY(view, d2 != null ? (float) d2.doubleValue() : 0.0f);
                        break;
                    }
                    break;
                case -1589741021:
                    if (str.equals(ViewProps.SHADOW_COLOR)) {
                        U u = this.mViewManager;
                        Integer color = obj == null ? 0 : ColorPropConverter.getColor(obj, view.getContext());
                        Intrinsics.checkNotNull(color);
                        u.setShadowColor(view, color.intValue());
                        break;
                    }
                    break;
                case -1489432511:
                    if (str.equals(ViewProps.OUTLINE_COLOR)) {
                        this.mViewManager.setOutlineColor(view, (Integer) obj);
                        break;
                    }
                    break;
                case -1474494833:
                    if (str.equals(ViewProps.OUTLINE_STYLE)) {
                        this.mViewManager.setOutlineStyle(view, (String) obj);
                        break;
                    }
                    break;
                case -1471148380:
                    if (str.equals(ViewProps.OUTLINE_WIDTH)) {
                        Double d3 = (Double) obj;
                        this.mViewManager.setOutlineWidth(view, d3 != null ? (float) d3.doubleValue() : Float.NaN);
                        break;
                    }
                    break;
                case -1351902487:
                    if (str.equals(ViewProps.ON_CLICK)) {
                        Boolean bool2 = (Boolean) obj;
                        this.mViewManager.setClick(view, bool2 != null ? bool2.booleanValue() : false);
                        break;
                    }
                    break;
                case -1274492040:
                    if (str.equals(ViewProps.FILTER)) {
                        this.mViewManager.setFilter(view, (ReadableArray) obj);
                        break;
                    }
                    break;
                case -1267206133:
                    if (str.equals(ViewProps.OPACITY)) {
                        Double d4 = (Double) obj;
                        this.mViewManager.setOpacity(view, d4 != null ? (float) d4.doubleValue() : 1.0f);
                        break;
                    }
                    break;
                case -1247970794:
                    if (str.equals(ViewProps.ON_POINTER_OUT_CAPTURE)) {
                        Boolean bool3 = (Boolean) obj;
                        this.mViewManager.setPointerOutCapture(view, bool3 != null ? bool3.booleanValue() : false);
                        break;
                    }
                    break;
                case -1228066334:
                    if (str.equals("borderTopLeftRadius")) {
                        Double d5 = (Double) obj;
                        this.mViewManager.setBorderTopLeftRadius(view, d5 != null ? (float) d5.doubleValue() : Float.NaN);
                        break;
                    }
                    break;
                case -1219666915:
                    if (str.equals(ViewProps.ON_CLICK_CAPTURE)) {
                        Boolean bool4 = (Boolean) obj;
                        this.mViewManager.setClickCapture(view, bool4 != null ? bool4.booleanValue() : false);
                        break;
                    }
                    break;
                case -1036769289:
                    if (str.equals(ViewProps.ON_POINTER_MOVE_CAPTURE)) {
                        Boolean bool5 = (Boolean) obj;
                        this.mViewManager.setPointerMoveCapture(view, bool5 != null ? bool5.booleanValue() : false);
                        break;
                    }
                    break;
                case -908189618:
                    if (str.equals("scaleX")) {
                        Double d6 = (Double) obj;
                        this.mViewManager.setScaleX(view, d6 != null ? (float) d6.doubleValue() : 1.0f);
                        break;
                    }
                    break;
                case -908189617:
                    if (str.equals("scaleY")) {
                        Double d7 = (Double) obj;
                        this.mViewManager.setScaleY(view, d7 != null ? (float) d7.doubleValue() : 1.0f);
                        break;
                    }
                    break;
                case -877170387:
                    if (str.equals(ViewProps.TEST_ID)) {
                        this.mViewManager.setTestId(view, (String) obj);
                        break;
                    }
                    break;
                case -781597262:
                    if (str.equals(ViewProps.TRANSFORM_ORIGIN)) {
                        this.mViewManager.setTransformOrigin(view, (ReadableArray) obj);
                        break;
                    }
                    break;
                case -731417480:
                    if (str.equals(ViewProps.Z_INDEX)) {
                        Double d8 = (Double) obj;
                        this.mViewManager.setZIndex(view, d8 != null ? (float) d8.doubleValue() : 0.0f);
                        break;
                    }
                    break;
                case -112141555:
                    if (str.equals(ViewProps.ON_POINTER_LEAVE_CAPTURE)) {
                        Boolean bool6 = (Boolean) obj;
                        this.mViewManager.setPointerLeaveCapture(view, bool6 != null ? bool6.booleanValue() : false);
                        break;
                    }
                    break;
                case -101663499:
                    if (str.equals(ViewProps.ACCESSIBILITY_HINT)) {
                        this.mViewManager.setAccessibilityHint(view, (String) obj);
                        break;
                    }
                    break;
                case -101359900:
                    if (str.equals(ViewProps.ACCESSIBILITY_ROLE)) {
                        this.mViewManager.setAccessibilityRole(view, (String) obj);
                        break;
                    }
                    break;
                case -80891667:
                    if (str.equals(ViewProps.RENDER_TO_HARDWARE_TEXTURE)) {
                        Boolean bool7 = (Boolean) obj;
                        this.mViewManager.setRenderToHardwareTexture(view, bool7 != null ? bool7.booleanValue() : false);
                        break;
                    }
                    break;
                case -40300674:
                    if (str.equals("rotation")) {
                        Double d9 = (Double) obj;
                        this.mViewManager.setRotation(view, d9 != null ? (float) d9.doubleValue() : 0.0f);
                        break;
                    }
                    break;
                case -4379043:
                    if (str.equals("elevation")) {
                        Double d10 = (Double) obj;
                        this.mViewManager.setElevation(view, d10 != null ? (float) d10.doubleValue() : 0.0f);
                        break;
                    }
                    break;
                case 3506294:
                    if (str.equals(ViewProps.ROLE)) {
                        this.mViewManager.setRole(view, (String) obj);
                        break;
                    }
                    break;
                case 17941018:
                    if (str.equals(ViewProps.ON_POINTER_ENTER)) {
                        Boolean bool8 = (Boolean) obj;
                        this.mViewManager.setPointerEnter(view, bool8 != null ? bool8.booleanValue() : false);
                        break;
                    }
                    break;
                case 24119801:
                    if (str.equals(ViewProps.ON_POINTER_LEAVE)) {
                        Boolean bool9 = (Boolean) obj;
                        this.mViewManager.setPointerLeave(view, bool9 != null ? bool9.booleanValue() : false);
                        break;
                    }
                    break;
                case 36255470:
                    if (str.equals(ViewProps.ACCESSIBILITY_LIVE_REGION)) {
                        this.mViewManager.setAccessibilityLiveRegion(view, (String) obj);
                        break;
                    }
                    break;
                case 132353428:
                    if (str.equals(ViewProps.ON_POINTER_OVER_CAPTURE)) {
                        Boolean bool10 = (Boolean) obj;
                        this.mViewManager.setPointerOverCapture(view, bool10 != null ? bool10.booleanValue() : false);
                        break;
                    }
                    break;
                case 317346576:
                    if (str.equals(ViewProps.ON_POINTER_OUT)) {
                        Boolean bool11 = (Boolean) obj;
                        this.mViewManager.setPointerOut(view, bool11 != null ? bool11.booleanValue() : false);
                        break;
                    }
                    break;
                case 333432965:
                    if (str.equals("borderTopRightRadius")) {
                        Double d11 = (Double) obj;
                        this.mViewManager.setBorderTopRightRadius(view, d11 != null ? (float) d11.doubleValue() : Float.NaN);
                        break;
                    }
                    break;
                case 581268560:
                    if (str.equals("borderBottomLeftRadius")) {
                        Double d12 = (Double) obj;
                        this.mViewManager.setBorderBottomLeftRadius(view, d12 != null ? (float) d12.doubleValue() : Float.NaN);
                        break;
                    }
                    break;
                case 588239831:
                    if (str.equals("borderBottomRightRadius")) {
                        Double d13 = (Double) obj;
                        this.mViewManager.setBorderBottomRightRadius(view, d13 != null ? (float) d13.doubleValue() : Float.NaN);
                        break;
                    }
                    break;
                case 743055051:
                    if (str.equals(ViewProps.BOX_SHADOW)) {
                        this.mViewManager.setBoxShadow(view, (ReadableArray) obj);
                        break;
                    }
                    break;
                case 746986311:
                    if (str.equals(ViewProps.IMPORTANT_FOR_ACCESSIBILITY)) {
                        this.mViewManager.setImportantForAccessibility(view, (String) obj);
                        break;
                    }
                    break;
                case 1052666732:
                    if (str.equals(ViewProps.TRANSFORM)) {
                        this.mViewManager.setTransform(view, (ReadableArray) obj);
                        break;
                    }
                    break;
                case 1146842694:
                    if (str.equals(ViewProps.ACCESSIBILITY_LABEL)) {
                        this.mViewManager.setAccessibilityLabel(view, (String) obj);
                        break;
                    }
                    break;
                case 1153872867:
                    if (str.equals(ViewProps.ACCESSIBILITY_STATE)) {
                        this.mViewManager.setViewState(view, (ReadableMap) obj);
                        break;
                    }
                    break;
                case 1156088003:
                    if (str.equals(ViewProps.ACCESSIBILITY_VALUE)) {
                        this.mViewManager.setAccessibilityValue(view, (ReadableMap) obj);
                        break;
                    }
                    break;
                case 1247744079:
                    if (str.equals(ViewProps.ON_POINTER_MOVE)) {
                        Boolean bool12 = (Boolean) obj;
                        this.mViewManager.setPointerMove(view, bool12 != null ? bool12.booleanValue() : false);
                        break;
                    }
                    break;
                case 1247809874:
                    if (str.equals(ViewProps.ON_POINTER_OVER)) {
                        Boolean bool13 = (Boolean) obj;
                        this.mViewManager.setPointerOver(view, bool13 != null ? bool13.booleanValue() : false);
                        break;
                    }
                    break;
                case 1287124693:
                    if (str.equals(ViewProps.BACKGROUND_COLOR)) {
                        U u2 = this.mViewManager;
                        Integer color2 = obj == null ? 0 : ColorPropConverter.getColor(obj, view.getContext());
                        Intrinsics.checkNotNull(color2);
                        u2.setBackgroundColor(view, color2.intValue());
                        break;
                    }
                    break;
                case 1349188574:
                    if (str.equals("borderRadius")) {
                        Double d14 = (Double) obj;
                        this.mViewManager.setBorderRadius(view, d14 != null ? (float) d14.doubleValue() : Float.NaN);
                        break;
                    }
                    break;
                case 1407295349:
                    if (str.equals(ViewProps.OUTLINE_OFFSET)) {
                        Double d15 = (Double) obj;
                        this.mViewManager.setOutlineOffset(view, d15 != null ? (float) d15.doubleValue() : Float.NaN);
                        break;
                    }
                    break;
                case 1505602511:
                    if (str.equals(ViewProps.ACCESSIBILITY_ACTIONS)) {
                        this.mViewManager.setAccessibilityActions(view, (ReadableArray) obj);
                        break;
                    }
                    break;
                case 1761903244:
                    if (str.equals(ViewProps.ACCESSIBILITY_COLLECTION)) {
                        this.mViewManager.setAccessibilityCollection(view, (ReadableMap) obj);
                        break;
                    }
                    break;
                case 1865277756:
                    if (str.equals(ViewProps.ACCESSIBILITY_LABELLED_BY)) {
                        this.mViewManager.setAccessibilityLabelledBy(view, new DynamicFromObject(obj));
                        break;
                    }
                    break;
                case 1993034687:
                    if (str.equals(ViewProps.ACCESSIBILITY_COLLECTION_ITEM)) {
                        this.mViewManager.setAccessibilityCollectionItem(view, (ReadableMap) obj);
                        break;
                    }
                    break;
                case 2045685618:
                    if (str.equals(ViewProps.NATIVE_ID)) {
                        this.mViewManager.setNativeId(view, (String) obj);
                        break;
                    }
                    break;
            }
        }
    }
}
