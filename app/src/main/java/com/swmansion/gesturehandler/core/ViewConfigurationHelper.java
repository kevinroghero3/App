package com.swmansion.gesturehandler.core;

import android.view.View;
import android.view.ViewGroup;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public interface ViewConfigurationHelper {
    View getChildInDrawingOrderAtIndex(@NotNull ViewGroup viewGroup, int i);

    PointerEventsConfig getPointerEventsConfigForView(@NotNull View view);

    boolean isViewClippingChildren(@NotNull ViewGroup viewGroup);
}
