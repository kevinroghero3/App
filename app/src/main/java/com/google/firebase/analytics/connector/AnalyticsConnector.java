package com.google.firebase.analytics.connector;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Size;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public interface AnalyticsConnector {

    /* JADX INFO: loaded from: classes5.dex */
    public interface AnalyticsConnectorHandle {
        void registerEventNames(@NonNull Set<String> set);

        void unregister();

        void unregisterEventNames();
    }

    /* JADX INFO: loaded from: classes5.dex */
    public interface AnalyticsConnectorListener {
        void onMessageTriggered(int i, @Nullable Bundle bundle);
    }

    public static class ConditionalUserProperty {
        public boolean active;
        public long creationTimestamp;
        public String expiredEventName;
        public Bundle expiredEventParams;
        public String name;
        public String origin;
        public long timeToLive;
        public String timedOutEventName;
        public Bundle timedOutEventParams;
        public String triggerEventName;
        public long triggerTimeout;
        public String triggeredEventName;
        public Bundle triggeredEventParams;
        public long triggeredTimestamp;
        public Object value;
    }

    void clearConditionalUserProperty(@NonNull @Size(max = 24, min = 1) String str, @Nullable String str2, @Nullable Bundle bundle);

    List<ConditionalUserProperty> getConditionalUserProperties(@NonNull String str, @Nullable @Size(max = 23, min = 1) String str2);

    int getMaxUserProperties(@NonNull @Size(min = 1) String str);

    Map<String, Object> getUserProperties(boolean z);

    void logEvent(@NonNull String str, @NonNull String str2, @Nullable Bundle bundle);

    AnalyticsConnectorHandle registerAnalyticsConnectorListener(@NonNull String str, @NonNull AnalyticsConnectorListener analyticsConnectorListener);

    void setConditionalUserProperty(@NonNull ConditionalUserProperty conditionalUserProperty);

    void setUserProperty(@NonNull String str, @NonNull String str2, @NonNull Object obj);
}
