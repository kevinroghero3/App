package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.ReadableMap;

/* JADX INFO: loaded from: classes2.dex */
public interface RNSBottomTabsManagerInterface<T extends View> {
    void setControlNavigationStateInJS(T t, boolean z);

    void setTabBarBackgroundColor(T t, @Nullable Integer num);

    void setTabBarBlurEffect(T t, @Nullable String str);

    void setTabBarItemBadgeBackgroundColor(T t, @Nullable Integer num);

    void setTabBarItemIconColor(T t, @Nullable Integer num);

    void setTabBarItemIconColorActive(T t, @Nullable Integer num);

    void setTabBarItemTitleFontColor(T t, @Nullable Integer num);

    void setTabBarItemTitleFontColorActive(T t, @Nullable Integer num);

    void setTabBarItemTitleFontFamily(T t, @Nullable String str);

    void setTabBarItemTitleFontSize(T t, float f);

    void setTabBarItemTitleFontSizeActive(T t, float f);

    void setTabBarItemTitleFontStyle(T t, @Nullable String str);

    void setTabBarItemTitleFontWeight(T t, @Nullable String str);

    void setTabBarItemTitlePositionAdjustment(T t, @Nullable ReadableMap readableMap);

    void setTabBarTintColor(T t, @Nullable Integer num);
}
