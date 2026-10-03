package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNCAndroidDropdownPickerManagerInterface;

/* JADX INFO: loaded from: classes2.dex */
public class RNCAndroidDropdownPickerManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNCAndroidDropdownPickerManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNCAndroidDropdownPickerManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:41:0x0073  */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(T t, String str, @Nullable Object obj) {
        str.hashCode();
        switch (str) {
            case "dropdownIconColor":
                ((RNCAndroidDropdownPickerManagerInterface) this.mViewManager).setDropdownIconColor(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case "dropdownIconRippleColor":
                ((RNCAndroidDropdownPickerManagerInterface) this.mViewManager).setDropdownIconRippleColor(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case "enabled":
                ((RNCAndroidDropdownPickerManagerInterface) this.mViewManager).setEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case "numberOfLines":
                ((RNCAndroidDropdownPickerManagerInterface) this.mViewManager).setNumberOfLines(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case "prompt":
                ((RNCAndroidDropdownPickerManagerInterface) this.mViewManager).setPrompt(t, obj == null ? null : (String) obj);
                break;
            case "color":
                ((RNCAndroidDropdownPickerManagerInterface) this.mViewManager).setColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case "items":
                ((RNCAndroidDropdownPickerManagerInterface) this.mViewManager).setItems(t, (ReadableArray) obj);
                break;
            case "selected":
                ((RNCAndroidDropdownPickerManagerInterface) this.mViewManager).setSelected(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case "backgroundColor":
                this.mViewManager.setBackgroundColor(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            default:
                super.setProperty(t, str, obj);
                break;
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0038  */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void receiveCommand(T t, String str, ReadableArray readableArray) {
        byte b;
        str.hashCode();
        int iHashCode = str.hashCode();
        if (iHashCode != 3027047) {
            if (iHashCode != 97604824) {
                if (iHashCode == 361157844 && str.equals("setNativeSelected")) {
                    b = 2;
                } else {
                    b = -1;
                }
            } else if (str.equals("focus")) {
                b = 1;
            } else {
                b = -1;
            }
        } else if (str.equals("blur")) {
            b = 0;
        } else {
            b = -1;
        }
        if (b == 0) {
            ((RNCAndroidDropdownPickerManagerInterface) this.mViewManager).blur(t);
        } else if (b == 1) {
            ((RNCAndroidDropdownPickerManagerInterface) this.mViewManager).focus(t);
        } else {
            if (b != 2) {
                return;
            }
            ((RNCAndroidDropdownPickerManagerInterface) this.mViewManager).setNativeSelected(t, readableArray.getInt(0));
        }
    }
}
