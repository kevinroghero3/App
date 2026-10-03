package com.facebook.react.uimanager;

import android.view.View;
import com.facebook.react.bridge.UiThreadUtil;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public interface IViewGroupManager<T extends View> extends IViewManagerWithChildren {
    void addView(@NotNull T t, @NotNull View view, int i);

    View getChildAt(@NotNull T t, int i);

    int getChildCount(@NotNull T t);

    void removeViewAt(@NotNull T t, int i);

    default void removeAllViews(@NotNull T parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        UiThreadUtil.assertOnUiThread();
        int childCount = getChildCount(parent);
        while (true) {
            childCount--;
            if (-1 >= childCount) {
                return;
            } else {
                removeViewAt(parent, childCount);
            }
        }
    }
}
