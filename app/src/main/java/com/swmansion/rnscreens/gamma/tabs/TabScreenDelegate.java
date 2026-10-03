package com.swmansion.rnscreens.gamma.tabs;

import androidx.fragment.app.Fragment;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public interface TabScreenDelegate {
    Fragment getFragmentForTabScreen(@NotNull TabScreen tabScreen);

    void onMenuItemAttributesChange(@NotNull TabScreen tabScreen);

    void onTabFocusChangedFromJS(@NotNull TabScreen tabScreen, boolean z);
}
