package com.facebook.appevents.iap;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public interface InAppPurchaseBillingClientWrapper {
    Object getBillingClient();

    void queryPurchaseHistory(@NotNull InAppPurchaseUtils.IAPProductType iAPProductType, @NotNull Runnable runnable);

    void queryPurchases(@NotNull InAppPurchaseUtils.IAPProductType iAPProductType, @NotNull Runnable runnable);
}
