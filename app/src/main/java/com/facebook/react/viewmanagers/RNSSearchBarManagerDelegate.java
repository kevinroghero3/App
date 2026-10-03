package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNSSearchBarManagerInterface;
import com.google.common.base.Ascii;

/* JADX INFO: loaded from: classes2.dex */
public class RNSSearchBarManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNSSearchBarManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNSSearchBarManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:65:0x00cb  */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(T t, String str, @Nullable Object obj) {
        byte b;
        str.hashCode();
        switch (str) {
            case "hideNavigationBar":
                b = 0;
                break;
            case "headerIconColor":
                b = 1;
                break;
            case "autoCapitalize":
                b = 2;
                break;
            case "textColor":
                b = 3;
                break;
            case "barTintColor":
                b = 4;
                break;
            case "hintTextColor":
                b = 5;
                break;
            case "hideWhenScrolling":
                b = 6;
                break;
            case "cancelButtonText":
                b = 7;
                break;
            case "disableBackButtonOverride":
                b = 8;
                break;
            case "shouldShowHintSearchIcon":
                b = 9;
                break;
            case "placeholder":
                b = 10;
                break;
            case "tintColor":
                b = Ascii.VT;
                break;
            case "obscureBackground":
                b = Ascii.FF;
                break;
            case "inputType":
                b = Ascii.CR;
                break;
            case "placement":
                b = Ascii.SO;
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                ((RNSSearchBarManagerInterface) this.mViewManager).setHideNavigationBar(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 1:
                ((RNSSearchBarManagerInterface) this.mViewManager).setHeaderIconColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 2:
                ((RNSSearchBarManagerInterface) this.mViewManager).setAutoCapitalize(t, (String) obj);
                break;
            case 3:
                ((RNSSearchBarManagerInterface) this.mViewManager).setTextColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 4:
                ((RNSSearchBarManagerInterface) this.mViewManager).setBarTintColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 5:
                ((RNSSearchBarManagerInterface) this.mViewManager).setHintTextColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 6:
                ((RNSSearchBarManagerInterface) this.mViewManager).setHideWhenScrolling(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 7:
                ((RNSSearchBarManagerInterface) this.mViewManager).setCancelButtonText(t, obj != null ? (String) obj : null);
                break;
            case 8:
                ((RNSSearchBarManagerInterface) this.mViewManager).setDisableBackButtonOverride(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 9:
                ((RNSSearchBarManagerInterface) this.mViewManager).setShouldShowHintSearchIcon(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 10:
                ((RNSSearchBarManagerInterface) this.mViewManager).setPlaceholder(t, obj != null ? (String) obj : null);
                break;
            case 11:
                ((RNSSearchBarManagerInterface) this.mViewManager).setTintColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 12:
                ((RNSSearchBarManagerInterface) this.mViewManager).setObscureBackground(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 13:
                ((RNSSearchBarManagerInterface) this.mViewManager).setInputType(t, obj != null ? (String) obj : null);
                break;
            case 14:
                ((RNSSearchBarManagerInterface) this.mViewManager).setPlacement(t, (String) obj);
                break;
            default:
                super.setProperty(t, str, obj);
                break;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:29:0x0055  */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void receiveCommand(T t, String str, @Nullable ReadableArray readableArray) {
        byte b;
        str.hashCode();
        switch (str) {
            case "cancelSearch":
                b = 0;
                break;
            case "clearText":
                b = 1;
                break;
            case "toggleCancelButton":
                b = 2;
                break;
            case "blur":
                b = 3;
                break;
            case "focus":
                b = 4;
                break;
            case "setText":
                b = 5;
                break;
            default:
                b = -1;
                break;
        }
        if (b == 0) {
            ((RNSSearchBarManagerInterface) this.mViewManager).cancelSearch(t);
            return;
        }
        if (b == 1) {
            ((RNSSearchBarManagerInterface) this.mViewManager).clearText(t);
            return;
        }
        if (b == 2) {
            ((RNSSearchBarManagerInterface) this.mViewManager).toggleCancelButton(t, readableArray.getBoolean(0));
            return;
        }
        if (b == 3) {
            ((RNSSearchBarManagerInterface) this.mViewManager).blur(t);
        } else if (b == 4) {
            ((RNSSearchBarManagerInterface) this.mViewManager).focus(t);
        } else {
            if (b != 5) {
                return;
            }
            ((RNSSearchBarManagerInterface) this.mViewManager).setText(t, readableArray.getString(0));
        }
    }
}
