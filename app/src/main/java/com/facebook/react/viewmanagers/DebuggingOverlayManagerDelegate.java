package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.DebuggingOverlayManagerInterface;

/* JADX INFO: loaded from: classes2.dex */
public class DebuggingOverlayManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & DebuggingOverlayManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public DebuggingOverlayManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(T t, String str, @Nullable Object obj) {
        super.setProperty(t, str, obj);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0038  */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void receiveCommand(T t, String str, @Nullable ReadableArray readableArray) {
        byte b;
        str.hashCode();
        int iHashCode = str.hashCode();
        if (iHashCode != -1942063165) {
            if (iHashCode != 1326903961) {
                if (iHashCode == 1385348555 && str.equals("highlightElements")) {
                    b = 2;
                } else {
                    b = -1;
                }
            } else if (str.equals("highlightTraceUpdates")) {
                b = 1;
            } else {
                b = -1;
            }
        } else if (str.equals("clearElementsHighlights")) {
            b = 0;
        } else {
            b = -1;
        }
        if (b == 0) {
            ((DebuggingOverlayManagerInterface) this.mViewManager).clearElementsHighlights(t);
        } else if (b == 1) {
            ((DebuggingOverlayManagerInterface) this.mViewManager).highlightTraceUpdates(t, readableArray.getArray(0));
        } else {
            if (b != 2) {
                return;
            }
            ((DebuggingOverlayManagerInterface) this.mViewManager).highlightElements(t, readableArray.getArray(0));
        }
    }
}
