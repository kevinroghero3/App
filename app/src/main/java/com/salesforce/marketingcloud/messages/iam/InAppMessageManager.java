package com.salesforce.marketingcloud.messages.iam;

import android.graphics.Typeface;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public interface InAppMessageManager {

    /* JADX INFO: loaded from: classes3.dex */
    public interface EventListener {
        void didCloseMessage(@NonNull InAppMessage inAppMessage);

        void didShowMessage(@NonNull InAppMessage inAppMessage);

        boolean shouldShowMessage(@NonNull InAppMessage inAppMessage);
    }

    void setInAppMessageListener(@Nullable EventListener eventListener);

    void setStatusBarColor(@ColorInt int i);

    void setTypeface(@Nullable Typeface typeface);

    void showMessage(@NonNull String str);
}
