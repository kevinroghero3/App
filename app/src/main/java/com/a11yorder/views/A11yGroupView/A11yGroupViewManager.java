package com.a11yorder.views.A11yGroupView;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.a11yorder.A11yGroupViewManagerSpec;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.views.view.ReactViewGroup;

/* JADX INFO: loaded from: classes2.dex */
public class A11yGroupViewManager extends A11yGroupViewManagerSpec<ViewGroup> {
    public static final String REACT_CLASS = "A11yGroupView";

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public ReactViewGroup createViewInstance(@NonNull ThemedReactContext themedReactContext) {
        return new ReactViewGroup(themedReactContext);
    }
}
