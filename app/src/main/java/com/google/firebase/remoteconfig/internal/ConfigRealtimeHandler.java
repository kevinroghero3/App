package com.google.firebase.remoteconfig.internal;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.firebase.FirebaseApp;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.remoteconfig.ConfigUpdateListener;
import com.google.firebase.remoteconfig.ConfigUpdateListenerRegistration;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public class ConfigRealtimeHandler {
    private final ConfigCacheClient activatedCacheClient;
    private final ConfigFetchHandler configFetchHandler;
    private final ConfigRealtimeHttpClient configRealtimeHttpClient;
    private final Context context;
    private final FirebaseApp firebaseApp;
    private final FirebaseInstallationsApi firebaseInstallations;
    private final Set<ConfigUpdateListener> listeners;
    private final ConfigMetadataClient metadataClient;
    private final String namespace;
    private final ScheduledExecutorService scheduledExecutorService;

    public ConfigRealtimeHandler(FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, ConfigFetchHandler configFetchHandler, ConfigCacheClient configCacheClient, Context context, String str, ConfigMetadataClient configMetadataClient, ScheduledExecutorService scheduledExecutorService) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.listeners = linkedHashSet;
        this.configRealtimeHttpClient = new ConfigRealtimeHttpClient(firebaseApp, firebaseInstallationsApi, configFetchHandler, configCacheClient, context, str, linkedHashSet, configMetadataClient, scheduledExecutorService);
        this.firebaseApp = firebaseApp;
        this.configFetchHandler = configFetchHandler;
        this.firebaseInstallations = firebaseInstallationsApi;
        this.activatedCacheClient = configCacheClient;
        this.context = context;
        this.namespace = str;
        this.metadataClient = configMetadataClient;
        this.scheduledExecutorService = scheduledExecutorService;
    }

    private void beginRealtime() {
        synchronized (this) {
            if (!this.listeners.isEmpty()) {
                this.configRealtimeHttpClient.startHttpConnection();
            }
        }
    }

    public ConfigUpdateListenerRegistration addRealtimeConfigUpdateListener(@NonNull ConfigUpdateListener configUpdateListener) {
        ConfigUpdateListenerRegistrationInternal configUpdateListenerRegistrationInternal;
        synchronized (this) {
            this.listeners.add(configUpdateListener);
            beginRealtime();
            configUpdateListenerRegistrationInternal = new ConfigUpdateListenerRegistrationInternal(configUpdateListener);
        }
        return configUpdateListenerRegistrationInternal;
    }

    public void setBackgroundState(boolean z) {
        synchronized (this) {
            this.configRealtimeHttpClient.setRealtimeBackgroundState(z);
            if (!z) {
                beginRealtime();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeRealtimeConfigUpdateListener(ConfigUpdateListener configUpdateListener) {
        synchronized (this) {
            this.listeners.remove(configUpdateListener);
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    public class ConfigUpdateListenerRegistrationInternal implements ConfigUpdateListenerRegistration {
        private final ConfigUpdateListener listener;

        public ConfigUpdateListenerRegistrationInternal(ConfigUpdateListener configUpdateListener) {
            this.listener = configUpdateListener;
        }

        @Override // com.google.firebase.remoteconfig.ConfigUpdateListenerRegistration
        public void remove() {
            ConfigRealtimeHandler.this.removeRealtimeConfigUpdateListener(this.listener);
        }
    }
}
