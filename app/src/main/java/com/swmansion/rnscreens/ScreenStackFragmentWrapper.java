package com.swmansion.rnscreens;

import androidx.appcompat.widget.Toolbar;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public interface ScreenStackFragmentWrapper extends ScreenFragmentWrapper {
    boolean canNavigateBack();

    void dismissFromContainer();

    void removeToolbar();

    void setToolbar(@NotNull Toolbar toolbar);

    void setToolbarShadowHidden(boolean z);

    void setToolbarTranslucent(boolean z);
}
