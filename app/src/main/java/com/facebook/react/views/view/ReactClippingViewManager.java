package com.facebook.react.views.view;

import android.view.View;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.uimanager.ReactClippingViewGroupHelper;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.view.ReactViewGroup;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public abstract class ReactClippingViewManager<T extends ReactViewGroup> extends ViewGroupManager<T> {
    @ReactProp(name = ReactClippingViewGroupHelper.PROP_REMOVE_CLIPPED_SUBVIEWS)
    public void setRemoveClippedSubviews(@NotNull T view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        UiThreadUtil.assertOnUiThread();
        view.setRemoveClippedSubviews(z);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void addView(@NotNull T parent, @NotNull View child, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        UiThreadUtil.assertOnUiThread();
        if (parent.getRemoveClippedSubviews()) {
            parent.addViewWithSubviewClippingEnabled(child, i);
        } else {
            parent.addView(child, i);
        }
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public int getChildCount(@NotNull T parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (parent.getRemoveClippedSubviews()) {
            return parent.getAllChildrenCount();
        }
        return parent.getChildCount();
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public View getChildAt(@NotNull T parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (parent.getRemoveClippedSubviews()) {
            return parent.getChildAtWithSubviewClippingEnabled(i);
        }
        return parent.getChildAt(i);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void removeViewAt(@NotNull T parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        UiThreadUtil.assertOnUiThread();
        if (parent.getRemoveClippedSubviews()) {
            View childAt = getChildAt((ReactViewGroup) parent, i);
            if (childAt != null) {
                parent.removeViewWithSubviewClippingEnabled(childAt);
                return;
            }
            return;
        }
        parent.removeViewAt(i);
    }

    @Override // com.facebook.react.uimanager.IViewGroupManager
    public void removeAllViews(@NotNull T parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        UiThreadUtil.assertOnUiThread();
        if (parent.getRemoveClippedSubviews()) {
            parent.removeAllViewsWithSubviewClippingEnabled();
        } else {
            parent.removeAllViews();
        }
    }
}
