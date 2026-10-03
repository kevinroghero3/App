package com.google.firebase.remoteconfig;

import com.google.firebase.Firebase;
import com.google.firebase.FirebaseApp;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
public final class RemoteConfigKt {
    public static final FirebaseRemoteConfig getRemoteConfig(@NotNull Firebase firebase2) {
        Intrinsics.checkNotNullParameter(firebase2, "<this>");
        FirebaseRemoteConfig firebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
        Intrinsics.checkNotNullExpressionValue(firebaseRemoteConfig, "getInstance()");
        return firebaseRemoteConfig;
    }

    public static final FirebaseRemoteConfig remoteConfig(@NotNull Firebase firebase2, @NotNull FirebaseApp app2) {
        Intrinsics.checkNotNullParameter(firebase2, "<this>");
        Intrinsics.checkNotNullParameter(app2, "app");
        FirebaseRemoteConfig firebaseRemoteConfig = FirebaseRemoteConfig.getInstance(app2);
        Intrinsics.checkNotNullExpressionValue(firebaseRemoteConfig, "getInstance(app)");
        return firebaseRemoteConfig;
    }

    public static final FirebaseRemoteConfigValue get(@NotNull FirebaseRemoteConfig firebaseRemoteConfig, @NotNull String key) {
        Intrinsics.checkNotNullParameter(firebaseRemoteConfig, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        FirebaseRemoteConfigValue value = firebaseRemoteConfig.getValue(key);
        Intrinsics.checkNotNullExpressionValue(value, "this.getValue(key)");
        return value;
    }

    public static final FirebaseRemoteConfigSettings remoteConfigSettings(@NotNull Function1<? super FirebaseRemoteConfigSettings.Builder, Unit> init) {
        Intrinsics.checkNotNullParameter(init, "init");
        FirebaseRemoteConfigSettings.Builder builder = new FirebaseRemoteConfigSettings.Builder();
        init.invoke(builder);
        FirebaseRemoteConfigSettings firebaseRemoteConfigSettingsBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(firebaseRemoteConfigSettingsBuild, "builder.build()");
        return firebaseRemoteConfigSettingsBuild;
    }

    public static final Flow<ConfigUpdate> getConfigUpdates(@NotNull FirebaseRemoteConfig firebaseRemoteConfig) {
        Intrinsics.checkNotNullParameter(firebaseRemoteConfig, "<this>");
        return FlowKt.callbackFlow(new RemoteConfigKt$configUpdates$1(firebaseRemoteConfig, null));
    }
}
