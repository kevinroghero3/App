package com.swmansion.gesturehandler.core;

import android.view.View;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public interface GestureHandlerRegistry {
    ArrayList<GestureHandler> getHandlersForView(@NotNull View view);
}
