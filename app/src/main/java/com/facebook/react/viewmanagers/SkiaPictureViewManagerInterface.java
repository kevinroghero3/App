package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import com.shopify.reactnative.skia.SkiaPictureView;

/* JADX INFO: loaded from: classes2.dex */
public interface SkiaPictureViewManagerInterface<T extends View> {
    void setColorSpace(SkiaPictureView skiaPictureView, @Nullable String str);

    void setDebug(T t, boolean z);

    void setOpaque(T t, boolean z);
}
