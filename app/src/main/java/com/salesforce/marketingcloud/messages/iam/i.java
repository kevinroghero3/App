package com.salesforce.marketingcloud.messages.iam;

import android.graphics.Typeface;
import androidx.annotation.NonNull;
import com.salesforce.marketingcloud.UrlHandler;
import com.salesforce.marketingcloud.media.o;

/* JADX INFO: loaded from: classes3.dex */
interface i {
    boolean canDisplay(@NonNull InAppMessage inAppMessage);

    int getStatusBarColor();

    Typeface getTypeface();

    void handleMessageFinished(@NonNull InAppMessage inAppMessage, @NonNull j jVar);

    o imageHandler();

    UrlHandler urlHandler();
}
