package com.salesforce.marketingcloud.messages;

import androidx.annotation.NonNull;
import com.salesforce.marketingcloud.messages.geofence.GeofenceMessageResponse;
import com.salesforce.marketingcloud.messages.proximity.ProximityMessageResponse;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public interface RegionMessageManager {
    public static final String BUNDLE_KEY_MESSAGING_ENABLED = "com.salesforce.marketingcloud.messaging.ENABLED";

    /* JADX INFO: loaded from: classes3.dex */
    public interface GeofenceMessageResponseListener {
        void onGeofenceMessageResponse(@NonNull GeofenceMessageResponse geofenceMessageResponse);
    }

    /* JADX INFO: loaded from: classes3.dex */
    public interface ProximityMessageResponseListener {
        void onProximityMessageResponse(@NonNull ProximityMessageResponse proximityMessageResponse);
    }

    /* JADX INFO: loaded from: classes3.dex */
    public interface RegionTransitionEventListener {
        public static final int TRANSITION_ENTERED = 1;
        public static final int TRANSITION_EXITED = 2;

        /* JADX INFO: loaded from: classes.dex */
        @Retention(RetentionPolicy.SOURCE)
        public @interface a {
        }

        void onTransitionEvent(int i, @NonNull Region region);
    }

    void disableGeofenceMessaging();

    void disableProximityMessaging();

    boolean enableGeofenceMessaging();

    boolean enableProximityMessaging();

    boolean isGeofenceMessagingEnabled();

    boolean isProximityMessagingEnabled();

    void registerGeofenceMessageResponseListener(@NonNull GeofenceMessageResponseListener geofenceMessageResponseListener);

    void registerProximityMessageResponseListener(@NonNull ProximityMessageResponseListener proximityMessageResponseListener);

    void registerRegionTransitionEventListener(@NonNull RegionTransitionEventListener regionTransitionEventListener);

    void unregisterGeofenceMessageResponseListener(@NonNull GeofenceMessageResponseListener geofenceMessageResponseListener);

    void unregisterProximityMessageResponseListener(@NonNull ProximityMessageResponseListener proximityMessageResponseListener);

    void unregisterRegionTransitionEventListener(@NonNull RegionTransitionEventListener regionTransitionEventListener);
}
