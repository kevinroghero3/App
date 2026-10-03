package com.google.android.material.datepicker;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes5.dex */
public abstract class OnSelectionChangedListener<S> {
    public void onIncompleteSelectionChanged() {
    }

    public abstract void onSelectionChanged(@NonNull S s);
}
