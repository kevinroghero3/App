package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNSVGFeMergeManagerInterface;

/* JADX INFO: loaded from: classes2.dex */
public class RNSVGFeMergeManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNSVGFeMergeManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNSVGFeMergeManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:29:0x0055  */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(T t, String str, @Nullable Object obj) {
        byte b;
        str.hashCode();
        switch (str) {
            case "height":
                b = 0;
                break;
            case "result":
                b = 1;
                break;
            case "x":
                b = 2;
                break;
            case "y":
                b = 3;
                break;
            case "nodes":
                b = 4;
                break;
            case "width":
                b = 5;
                break;
            default:
                b = -1;
                break;
        }
        if (b == 0) {
            ((RNSVGFeMergeManagerInterface) this.mViewManager).setHeight(t, new DynamicFromObject(obj));
            return;
        }
        if (b == 1) {
            ((RNSVGFeMergeManagerInterface) this.mViewManager).setResult(t, obj == null ? null : (String) obj);
            return;
        }
        if (b == 2) {
            ((RNSVGFeMergeManagerInterface) this.mViewManager).setX(t, new DynamicFromObject(obj));
            return;
        }
        if (b == 3) {
            ((RNSVGFeMergeManagerInterface) this.mViewManager).setY(t, new DynamicFromObject(obj));
            return;
        }
        if (b == 4) {
            ((RNSVGFeMergeManagerInterface) this.mViewManager).setNodes(t, (ReadableArray) obj);
        } else if (b == 5) {
            ((RNSVGFeMergeManagerInterface) this.mViewManager).setWidth(t, new DynamicFromObject(obj));
        } else {
            super.setProperty(t, str, obj);
        }
    }
}
