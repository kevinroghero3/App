package com.google.android.material.internal;

import android.widget.Checkable;
import androidx.annotation.Nullable;
import com.google.android.material.internal.MaterialCheckable;

/* JADX INFO: loaded from: classes5.dex */
public interface MaterialCheckable<T extends MaterialCheckable<T>> extends Checkable {

    public interface OnCheckedChangeListener<C> {
        void onCheckedChanged(C c, boolean z);
    }

    int getId();

    void setInternalOnCheckedChangeListener(@Nullable OnCheckedChangeListener<T> onCheckedChangeListener);
}
