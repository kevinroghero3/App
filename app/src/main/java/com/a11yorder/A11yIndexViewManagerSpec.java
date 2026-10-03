package com.a11yorder;

import com.a11yorder.views.A11yIndexView.A11yIndexView;
import com.facebook.react.views.view.ReactViewManager;

/* JADX INFO: loaded from: classes2.dex */
public abstract class A11yIndexViewManagerSpec<T extends A11yIndexView> extends ReactViewManager {
    public abstract void focus(T t);

    public abstract void setOrderIndex(T t, int i);

    public abstract void setOrderKey(T t, String str);
}
