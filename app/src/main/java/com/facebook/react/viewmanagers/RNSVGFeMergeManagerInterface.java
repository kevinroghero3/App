package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;

/* JADX INFO: loaded from: classes2.dex */
public interface RNSVGFeMergeManagerInterface<T extends View> {
    void setHeight(T t, Dynamic dynamic);

    void setNodes(T t, @Nullable ReadableArray readableArray);

    void setResult(T t, @Nullable String str);

    void setWidth(T t, Dynamic dynamic);

    void setX(T t, Dynamic dynamic);

    void setY(T t, Dynamic dynamic);
}
