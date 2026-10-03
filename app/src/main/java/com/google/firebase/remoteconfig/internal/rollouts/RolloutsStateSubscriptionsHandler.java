package com.google.firebase.remoteconfig.internal.rollouts;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigException;
import com.google.firebase.remoteconfig.internal.ConfigCacheClient;
import com.google.firebase.remoteconfig.internal.ConfigContainer;
import com.google.firebase.remoteconfig.interop.rollouts.RolloutsState;
import com.google.firebase.remoteconfig.interop.rollouts.RolloutsStateSubscriber;
import io.sentry.android.core.SentryLogcatAdapter;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public class RolloutsStateSubscriptionsHandler {
    private ConfigCacheClient activatedConfigsCache;
    private Executor executor;
    private RolloutsStateFactory rolloutsStateFactory;
    private Set<RolloutsStateSubscriber> subscribers = Collections.newSetFromMap(new ConcurrentHashMap());

    public RolloutsStateSubscriptionsHandler(@NonNull ConfigCacheClient configCacheClient, @NonNull RolloutsStateFactory rolloutsStateFactory, @NonNull Executor executor) {
        this.activatedConfigsCache = configCacheClient;
        this.rolloutsStateFactory = rolloutsStateFactory;
        this.executor = executor;
    }

    public void registerRolloutsStateSubscriber(@NonNull final RolloutsStateSubscriber rolloutsStateSubscriber) {
        this.subscribers.add(rolloutsStateSubscriber);
        final Task<ConfigContainer> task = this.activatedConfigsCache.get();
        task.addOnSuccessListener(this.executor, new OnSuccessListener() { // from class: com.google.firebase.remoteconfig.internal.rollouts.RolloutsStateSubscriptionsHandler$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                this.f$0.lambda$registerRolloutsStateSubscriber$1(task, rolloutsStateSubscriber, (ConfigContainer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$registerRolloutsStateSubscriber$1(Task task, final RolloutsStateSubscriber rolloutsStateSubscriber, ConfigContainer configContainer) {
        try {
            ConfigContainer configContainer2 = (ConfigContainer) task.getResult();
            if (configContainer2 != null) {
                final RolloutsState activeRolloutsState = this.rolloutsStateFactory.getActiveRolloutsState(configContainer2);
                this.executor.execute(new Runnable() { // from class: com.google.firebase.remoteconfig.internal.rollouts.RolloutsStateSubscriptionsHandler$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        rolloutsStateSubscriber.onRolloutsStateChanged(activeRolloutsState);
                    }
                });
            }
        } catch (FirebaseRemoteConfigException e) {
            SentryLogcatAdapter.w(FirebaseRemoteConfig.TAG, "Exception publishing RolloutsState to subscriber. Continuing to listen for changes.", e);
        }
    }

    public void publishActiveRolloutsState(@NonNull ConfigContainer configContainer) {
        try {
            final RolloutsState activeRolloutsState = this.rolloutsStateFactory.getActiveRolloutsState(configContainer);
            for (final RolloutsStateSubscriber rolloutsStateSubscriber : this.subscribers) {
                this.executor.execute(new Runnable() { // from class: com.google.firebase.remoteconfig.internal.rollouts.RolloutsStateSubscriptionsHandler$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        rolloutsStateSubscriber.onRolloutsStateChanged(activeRolloutsState);
                    }
                });
            }
        } catch (FirebaseRemoteConfigException e) {
            SentryLogcatAdapter.w(FirebaseRemoteConfig.TAG, "Exception publishing RolloutsState to subscribers. Continuing to listen for changes.", e);
        }
    }
}
