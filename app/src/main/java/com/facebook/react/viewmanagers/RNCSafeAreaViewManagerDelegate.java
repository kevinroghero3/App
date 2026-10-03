package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNCSafeAreaViewManagerInterface;
import com.henninghall.date_picker.props.ModeProp;

/* JADX INFO: loaded from: classes4.dex */
public class RNCSafeAreaViewManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNCSafeAreaViewManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNCSafeAreaViewManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(T t, String str, @Nullable Object obj) {
        str.hashCode();
        if (str.equals(ModeProp.name)) {
            ((RNCSafeAreaViewManagerInterface) this.mViewManager).setMode(t, (String) obj);
        } else if (str.equals("edges")) {
            ((RNCSafeAreaViewManagerInterface) this.mViewManager).setEdges(t, (ReadableMap) obj);
        } else {
            super.setProperty(t, str, obj);
        }
    }
}
