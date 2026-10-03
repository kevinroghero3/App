package com.salesforce.marketingcloud.analytics;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Size;
import com.salesforce.marketingcloud.messages.inbox.InboxMessage;

/* JADX INFO: loaded from: classes.dex */
public interface AnalyticsManager {
    public static final String TAG = com.salesforce.marketingcloud.g.a("AnalyticsManager");

    boolean areAnalyticsEnabled();

    boolean arePiAnalyticsEnabled();

    void disableAnalytics();

    void disablePiAnalytics();

    void enableAnalytics();

    void enablePiAnalytics();

    String getPiIdentifier();

    void setPiIdentifier(@Nullable @Size(min = 1) String str);

    void trackCartContents(@NonNull PiCart piCart);

    void trackCartConversion(@NonNull PiOrder piOrder);

    void trackInboxOpenEvent(@NonNull InboxMessage inboxMessage);

    void trackPageView(@NonNull @Size(min = 1) String str);

    void trackPageView(@NonNull @Size(min = 1) String str, @Nullable String str2);

    void trackPageView(@NonNull @Size(min = 1) String str, @Nullable String str2, @Nullable String str3);

    void trackPageView(@NonNull @Size(min = 1) String str, @Nullable String str2, @Nullable String str3, @Nullable String str4);
}
