package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNSBottomTabsScreenManagerInterface;
import com.google.common.base.Ascii;

/* JADX INFO: loaded from: classes2.dex */
public class RNSBottomTabsScreenManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNSBottomTabsScreenManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNSBottomTabsScreenManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:93:0x0137  */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(T t, String str, @Nullable Object obj) {
        byte b;
        str.hashCode();
        switch (str) {
            case "specialEffects":
                b = 0;
                break;
            case "iconResourceName":
                b = 1;
                break;
            case "isFocused":
                b = 2;
                break;
            case "overrideScrollViewContentInsetAdjustmentBehavior":
                b = 3;
                break;
            case "tabBarItemIconColor":
                b = 4;
                break;
            case "tabKey":
                b = 5;
                break;
            case "iconImageSource":
                b = 6;
                break;
            case "iconType":
                b = 7;
                break;
            case "selectedIconSfSymbolName":
                b = 8;
                break;
            case "tabBarBackgroundColor":
                b = 9;
                break;
            case "tabBarItemTitleFontSize":
                b = 10;
                break;
            case "tabBarItemTitleFontColor":
                b = Ascii.VT;
                break;
            case "tabBarItemTitleFontStyle":
                b = Ascii.FF;
                break;
            case "title":
                b = Ascii.CR;
                break;
            case "iconSfSymbolName":
                b = Ascii.SO;
                break;
            case "selectedIconImageSource":
                b = Ascii.SI;
                break;
            case "badgeValue":
                b = Ascii.DLE;
                break;
            case "tabBarItemTitleFontFamily":
                b = 17;
                break;
            case "tabBarItemBadgeBackgroundColor":
                b = Ascii.DC2;
                break;
            case "tabBarItemTitlePositionAdjustment":
                b = 19;
                break;
            case "tabBarItemTitleFontWeight":
                b = Ascii.DC4;
                break;
            case "tabBarBlurEffect":
                b = Ascii.NAK;
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                ((RNSBottomTabsScreenManagerInterface) this.mViewManager).setSpecialEffects(t, (ReadableMap) obj);
                break;
            case 1:
                ((RNSBottomTabsScreenManagerInterface) this.mViewManager).setIconResourceName(t, obj != null ? (String) obj : null);
                break;
            case 2:
                ((RNSBottomTabsScreenManagerInterface) this.mViewManager).setIsFocused(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 3:
                ((RNSBottomTabsScreenManagerInterface) this.mViewManager).setOverrideScrollViewContentInsetAdjustmentBehavior(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 4:
                ((RNSBottomTabsScreenManagerInterface) this.mViewManager).setTabBarItemIconColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 5:
                ((RNSBottomTabsScreenManagerInterface) this.mViewManager).setTabKey(t, obj != null ? (String) obj : null);
                break;
            case 6:
                ((RNSBottomTabsScreenManagerInterface) this.mViewManager).setIconImageSource(t, (ReadableMap) obj);
                break;
            case 7:
                ((RNSBottomTabsScreenManagerInterface) this.mViewManager).setIconType(t, (String) obj);
                break;
            case 8:
                ((RNSBottomTabsScreenManagerInterface) this.mViewManager).setSelectedIconSfSymbolName(t, obj != null ? (String) obj : null);
                break;
            case 9:
                ((RNSBottomTabsScreenManagerInterface) this.mViewManager).setTabBarBackgroundColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 10:
                ((RNSBottomTabsScreenManagerInterface) this.mViewManager).setTabBarItemTitleFontSize(t, obj == null ? 0.0f : ((Double) obj).floatValue());
                break;
            case 11:
                ((RNSBottomTabsScreenManagerInterface) this.mViewManager).setTabBarItemTitleFontColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 12:
                ((RNSBottomTabsScreenManagerInterface) this.mViewManager).setTabBarItemTitleFontStyle(t, obj != null ? (String) obj : null);
                break;
            case 13:
                ((RNSBottomTabsScreenManagerInterface) this.mViewManager).setTitle(t, obj != null ? (String) obj : null);
                break;
            case 14:
                ((RNSBottomTabsScreenManagerInterface) this.mViewManager).setIconSfSymbolName(t, obj != null ? (String) obj : null);
                break;
            case 15:
                ((RNSBottomTabsScreenManagerInterface) this.mViewManager).setSelectedIconImageSource(t, (ReadableMap) obj);
                break;
            case 16:
                ((RNSBottomTabsScreenManagerInterface) this.mViewManager).setBadgeValue(t, obj != null ? (String) obj : null);
                break;
            case 17:
                ((RNSBottomTabsScreenManagerInterface) this.mViewManager).setTabBarItemTitleFontFamily(t, obj != null ? (String) obj : null);
                break;
            case 18:
                ((RNSBottomTabsScreenManagerInterface) this.mViewManager).setTabBarItemBadgeBackgroundColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 19:
                ((RNSBottomTabsScreenManagerInterface) this.mViewManager).setTabBarItemTitlePositionAdjustment(t, (ReadableMap) obj);
                break;
            case 20:
                ((RNSBottomTabsScreenManagerInterface) this.mViewManager).setTabBarItemTitleFontWeight(t, obj != null ? (String) obj : null);
                break;
            case 21:
                ((RNSBottomTabsScreenManagerInterface) this.mViewManager).setTabBarBlurEffect(t, (String) obj);
                break;
            default:
                super.setProperty(t, str, obj);
                break;
        }
    }
}
