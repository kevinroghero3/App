package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import app.notifee.core.event.LogEvent;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.SkiaPictureViewManagerInterface;

/* JADX INFO: loaded from: classes2.dex */
public class SkiaPictureViewManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & SkiaPictureViewManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public SkiaPictureViewManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(T t, String str, @Nullable Object obj) {
        str.hashCode();
        if (str.equals("opaque")) {
            ((SkiaPictureViewManagerInterface) this.mViewManager).setOpaque(t, obj != null && ((Boolean) obj).booleanValue());
        } else if (str.equals(LogEvent.LEVEL_DEBUG)) {
            ((SkiaPictureViewManagerInterface) this.mViewManager).setDebug(t, obj != null && ((Boolean) obj).booleanValue());
        } else {
            super.setProperty(t, str, obj);
        }
    }
}
