package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNCAndroidDialogPickerManagerInterface;

/* JADX INFO: loaded from: classes2.dex */
public class RNCAndroidDialogPickerManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNCAndroidDialogPickerManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNCAndroidDialogPickerManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:41:0x0073  */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(T t, String str, @Nullable Object obj) {
        str.hashCode();
        switch (str) {
            case "dropdownIconColor":
                ((RNCAndroidDialogPickerManagerInterface) this.mViewManager).setDropdownIconColor(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case "dropdownIconRippleColor":
                ((RNCAndroidDialogPickerManagerInterface) this.mViewManager).setDropdownIconRippleColor(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case "enabled":
                ((RNCAndroidDialogPickerManagerInterface) this.mViewManager).setEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case "numberOfLines":
                ((RNCAndroidDialogPickerManagerInterface) this.mViewManager).setNumberOfLines(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case "prompt":
                ((RNCAndroidDialogPickerManagerInterface) this.mViewManager).setPrompt(t, obj == null ? null : (String) obj);
                break;
            case "color":
                ((RNCAndroidDialogPickerManagerInterface) this.mViewManager).setColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case "items":
                ((RNCAndroidDialogPickerManagerInterface) this.mViewManager).setItems(t, (ReadableArray) obj);
                break;
            case "selected":
                ((RNCAndroidDialogPickerManagerInterface) this.mViewManager).setSelected(t, obj != null ? ((Double) obj).intValue() : 0);
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
            ((RNCAndroidDialogPickerManagerInterface) this.mViewManager).blur(t);
        } else if (b == 1) {
            ((RNCAndroidDialogPickerManagerInterface) this.mViewManager).focus(t);
        } else {
            if (b != 2) {
                return;
            }
            ((RNCAndroidDialogPickerManagerInterface) this.mViewManager).setNativeSelected(t, readableArray.getInt(0));
        }
    }
}
