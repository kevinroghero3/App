package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.ReadableArray;

/* JADX INFO: loaded from: classes2.dex */
public interface RNCAndroidDialogPickerManagerInterface<T extends View> {
    void blur(T t);

    void focus(T t);

    void setBackgroundColor(T t, int i);

    void setColor(T t, @Nullable Integer num);

    void setDropdownIconColor(T t, int i);

    void setDropdownIconRippleColor(T t, int i);

    void setEnabled(T t, boolean z);

    void setItems(T t, @Nullable ReadableArray readableArray);

    void setNativeSelected(T t, int i);

    void setNumberOfLines(T t, int i);

    void setPrompt(T t, @Nullable String str);

    void setSelected(T t, int i);
}
