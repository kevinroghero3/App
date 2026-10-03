package com.google.android.datatransport;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ProductData {
    public abstract Integer getProductId();

    public static ProductData withProductId(@Nullable Integer num) {
        return new AutoValue_ProductData(num);
    }
}
