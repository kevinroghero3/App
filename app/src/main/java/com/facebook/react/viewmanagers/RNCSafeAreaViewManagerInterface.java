package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.ReadableMap;

/* JADX INFO: loaded from: classes4.dex */
public interface RNCSafeAreaViewManagerInterface<T extends View> {
    void setEdges(T t, @Nullable ReadableMap readableMap);

    void setMode(T t, @Nullable String str);
}
