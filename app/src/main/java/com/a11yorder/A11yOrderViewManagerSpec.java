package com.a11yorder;

import androidx.annotation.Nullable;
import com.a11yorder.views.A11yOrderView.A11yOrderView;
import com.facebook.react.views.view.ReactViewManager;

/* JADX INFO: loaded from: classes2.dex */
public abstract class A11yOrderViewManagerSpec<T extends A11yOrderView> extends ReactViewManager {
    public abstract void setOrderKey(T t, @Nullable String str);
}
