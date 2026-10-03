package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.ReadableMap;

/* JADX INFO: loaded from: classes2.dex */
public interface RNSBottomTabsScreenManagerInterface<T extends View> {
    void setBadgeValue(T t, @Nullable String str);

    void setIconImageSource(T t, @Nullable ReadableMap readableMap);

    void setIconResourceName(T t, @Nullable String str);

    void setIconSfSymbolName(T t, @Nullable String str);

    void setIconType(T t, @Nullable String str);

    void setIsFocused(T t, boolean z);

    void setOverrideScrollViewContentInsetAdjustmentBehavior(T t, boolean z);

    void setSelectedIconImageSource(T t, @Nullable ReadableMap readableMap);

    void setSelectedIconSfSymbolName(T t, @Nullable String str);

    void setSpecialEffects(T t, @Nullable ReadableMap readableMap);

    void setTabBarBackgroundColor(T t, @Nullable Integer num);

    void setTabBarBlurEffect(T t, @Nullable String str);

    void setTabBarItemBadgeBackgroundColor(T t, @Nullable Integer num);

    void setTabBarItemIconColor(T t, @Nullable Integer num);

    void setTabBarItemTitleFontColor(T t, @Nullable Integer num);

    void setTabBarItemTitleFontFamily(T t, @Nullable String str);

    void setTabBarItemTitleFontSize(T t, float f);

    void setTabBarItemTitleFontStyle(T t, @Nullable String str);

    void setTabBarItemTitleFontWeight(T t, @Nullable String str);

    void setTabBarItemTitlePositionAdjustment(T t, @Nullable ReadableMap readableMap);

    void setTabKey(T t, @Nullable String str);

    void setTitle(T t, @Nullable String str);
}
