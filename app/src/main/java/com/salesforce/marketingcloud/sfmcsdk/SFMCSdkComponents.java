package com.salesforce.marketingcloud.sfmcsdk;

import android.content.Context;
import android.content.SharedPreferences;
import com.salesforce.marketingcloud.sfmcsdk.components.behaviors.BehaviorManager;
import com.salesforce.marketingcloud.sfmcsdk.components.encryption.EncryptedSharedPreferences;
import com.salesforce.marketingcloud.sfmcsdk.components.encryption.EncryptionManager;
import com.salesforce.marketingcloud.sfmcsdk.components.events.EventManager;
import com.salesforce.marketingcloud.sfmcsdk.components.http.Authenticator;
import com.salesforce.marketingcloud.sfmcsdk.components.http.NetworkManager;
import com.salesforce.marketingcloud.sfmcsdk.components.identity.Identity;
import com.salesforce.marketingcloud.sfmcsdk.components.logging.SFMCSdkLogger;
import com.salesforce.marketingcloud.sfmcsdk.components.storage.StorageManager;
import com.salesforce.marketingcloud.sfmcsdk.components.utils.SdkExecutors;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class SFMCSdkComponents {
    private static final Companion Companion = new Companion(null);
    private static final String KEY_PREFS_REGISTRATION_ID = "registrationId";
    private static final String REGISTRATION_ID_STORAGE = "unified_sdk_registration";

    @Deprecated
    public static final String TAG = "SFMCSdkComponents";
    private final BehaviorManager behaviorManager;
    private final Context context;
    private final boolean encryptionChanged;
    private final EncryptionManager encryptionManager;
    private final EventManager eventManager;
    private final SdkExecutors executors;
    private final Identity identity;
    private final String moduleApplicationId;
    private final String moduleName;
    private final String registrationId;
    private final StorageManager storageManager;

    public final NetworkManager createNetworkManager() {
        return createNetworkManager$default(this, null, 1, null);
    }

    public SFMCSdkComponents(@NotNull Context context, @NotNull String moduleName, @NotNull String moduleApplicationId, @NotNull BehaviorManager behaviorManager, @NotNull EventManager eventManager) throws NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        Intrinsics.checkNotNullParameter(moduleApplicationId, "moduleApplicationId");
        Intrinsics.checkNotNullParameter(behaviorManager, "behaviorManager");
        Intrinsics.checkNotNullParameter(eventManager, "eventManager");
        this.context = context;
        this.moduleName = moduleName;
        this.moduleApplicationId = moduleApplicationId;
        this.behaviorManager = behaviorManager;
        this.eventManager = eventManager;
        EncryptionManager encryptionManager = new EncryptionManager(context, moduleApplicationId);
        this.encryptionManager = encryptionManager;
        this.executors = new SdkExecutors(null, null, 3, null);
        EncryptedSharedPreferences.Companion companion = EncryptedSharedPreferences.Companion;
        String packageName = context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
        SharedPreferences sharedPreferencesCreate = companion.create(context, REGISTRATION_ID_STORAGE, new EncryptionManager(context, packageName).getEncryptionKey$sfmcsdk_release());
        Intrinsics.checkNotNull(sharedPreferencesCreate, "null cannot be cast to non-null type com.salesforce.marketingcloud.sfmcsdk.components.encryption.EncryptedSharedPreferences");
        EncryptedSharedPreferences encryptedSharedPreferences = (EncryptedSharedPreferences) sharedPreferencesCreate;
        boolean zVerifyEncryption = encryptedSharedPreferences.verifyEncryption();
        this.encryptionChanged = !zVerifyEncryption;
        if (!zVerifyEncryption) {
            encryptedSharedPreferences.clearInstallationPrefs();
        }
        final String string = sharedPreferencesCreate.getString(KEY_PREFS_REGISTRATION_ID, null);
        if (string != null) {
            SFMCSdkLogger.INSTANCE.d(TAG, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.SFMCSdkComponents.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "StorageManager was initialized with existing install id: " + string;
                }
            });
        } else {
            string = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            encryptedSharedPreferences.edit().putString(KEY_PREFS_REGISTRATION_ID, string).apply();
            SFMCSdkLogger.INSTANCE.d(TAG, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.SFMCSdkComponents.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "StorageManager was initialized with new install id: " + string;
                }
            });
        }
        this.registrationId = string;
        this.storageManager = new StorageManager(context, encryptionManager, moduleApplicationId, string);
        this.identity = Identity.Companion.create$sfmcsdk_release(string);
    }

    public final Context getContext$sfmcsdk_release() {
        return this.context;
    }

    public final String getModuleName$sfmcsdk_release() {
        return this.moduleName;
    }

    public final String getModuleApplicationId() {
        return this.moduleApplicationId;
    }

    public final BehaviorManager getBehaviorManager() {
        return this.behaviorManager;
    }

    public final EventManager getEventManager() {
        return this.eventManager;
    }

    public final EncryptionManager getEncryptionManager() {
        return this.encryptionManager;
    }

    public final StorageManager getStorageManager() {
        return this.storageManager;
    }

    public final SdkExecutors getExecutors() {
        return this.executors;
    }

    public final String getRegistrationId() {
        return this.registrationId;
    }

    public final Identity getIdentity() {
        return this.identity;
    }

    public final boolean getEncryptionChanged() {
        return this.encryptionChanged;
    }

    public static /* synthetic */ NetworkManager createNetworkManager$default(SFMCSdkComponents sFMCSdkComponents, Authenticator authenticator, int i, Object obj) {
        if ((i & 1) != 0) {
            authenticator = null;
        }
        return sFMCSdkComponents.createNetworkManager(authenticator);
    }

    public final NetworkManager createNetworkManager(@Nullable Authenticator authenticator) {
        return new NetworkManager(this.context, this.executors, this.storageManager.getSecurePrefs("network_manager"), authenticator);
    }

    /* JADX INFO: loaded from: classes3.dex */
    static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
