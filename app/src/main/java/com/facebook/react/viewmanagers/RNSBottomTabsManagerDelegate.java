package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNSBottomTabsManagerInterface;
import com.google.common.base.Ascii;

/* JADX INFO: loaded from: classes2.dex */
public class RNSBottomTabsManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNSBottomTabsManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNSBottomTabsManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:65:0x00d5  */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(T t, String str, @Nullable Object obj) {
        byte b;
        str.hashCode();
        switch (str) {
            case "tabBarTintColor":
                b = 0;
                break;
            case "tabBarItemIconColor":
                b = 1;
                break;
            case "tabBarItemTitleFontColorActive":
                b = 2;
                break;
            case "tabBarBackgroundColor":
                b = 3;
                break;
            case "tabBarItemTitleFontSize":
                b = 4;
                break;
            case "tabBarItemTitleFontColor":
                b = 5;
                break;
            case "tabBarItemTitleFontStyle":
                b = 6;
                break;
            case "tabBarItemIconColorActive":
                b = 7;
                break;
            case "controlNavigationStateInJS":
                b = 8;
                break;
            case "tabBarItemTitleFontFamily":
                b = 9;
                break;
            case "tabBarItemBadgeBackgroundColor":
                b = 10;
                break;
            case "tabBarItemTitlePositionAdjustment":
                b = Ascii.VT;
                break;
            case "tabBarItemTitleFontWeight":
                b = Ascii.FF;
                break;
            case "tabBarItemTitleFontSizeActive":
                b = Ascii.CR;
                break;
            case "tabBarBlurEffect":
                b = Ascii.SO;
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                ((RNSBottomTabsManagerInterface) this.mViewManager).setTabBarTintColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 1:
                ((RNSBottomTabsManagerInterface) this.mViewManager).setTabBarItemIconColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 2:
                ((RNSBottomTabsManagerInterface) this.mViewManager).setTabBarItemTitleFontColorActive(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 3:
                ((RNSBottomTabsManagerInterface) this.mViewManager).setTabBarBackgroundColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 4:
                ((RNSBottomTabsManagerInterface) this.mViewManager).setTabBarItemTitleFontSize(t, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 5:
                ((RNSBottomTabsManagerInterface) this.mViewManager).setTabBarItemTitleFontColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 6:
                ((RNSBottomTabsManagerInterface) this.mViewManager).setTabBarItemTitleFontStyle(t, obj != null ? (String) obj : null);
                break;
            case 7:
                ((RNSBottomTabsManagerInterface) this.mViewManager).setTabBarItemIconColorActive(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 8:
                ((RNSBottomTabsManagerInterface) this.mViewManager).setControlNavigationStateInJS(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 9:
                ((RNSBottomTabsManagerInterface) this.mViewManager).setTabBarItemTitleFontFamily(t, obj != null ? (String) obj : null);
                break;
            case 10:
                ((RNSBottomTabsManagerInterface) this.mViewManager).setTabBarItemBadgeBackgroundColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 11:
                ((RNSBottomTabsManagerInterface) this.mViewManager).setTabBarItemTitlePositionAdjustment(t, (ReadableMap) obj);
                break;
            case 12:
                ((RNSBottomTabsManagerInterface) this.mViewManager).setTabBarItemTitleFontWeight(t, obj != null ? (String) obj : null);
                break;
            case 13:
                ((RNSBottomTabsManagerInterface) this.mViewManager).setTabBarItemTitleFontSizeActive(t, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 14:
                ((RNSBottomTabsManagerInterface) this.mViewManager).setTabBarBlurEffect(t, (String) obj);
                break;
            default:
                super.setProperty(t, str, obj);
                break;
        }
    }
}
