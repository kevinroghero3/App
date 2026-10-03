package com.salesforce.marketingcloud.sfmcsdk.components.identity;

import com.salesforce.marketingcloud.sfmcsdk.components.events.Event;
import com.salesforce.marketingcloud.sfmcsdk.components.events.EventManager;
import com.salesforce.marketingcloud.sfmcsdk.components.logging.SFMCSdkLogger;
import com.salesforce.marketingcloud.sfmcsdk.modules.ModuleIdentifier;
import com.salesforce.marketingcloud.sfmcsdk.util.SFMCExtension;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class Identity {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "~$Identity";
    private static Identity _instance;
    private final Map<ModuleIdentifier, ModuleIdentity> _moduleIdentities;
    private final String platform;
    private final String registrationId;
    private final List<String> reservedKeys;

    public /* synthetic */ Identity(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    public final void clearProfileAttribute(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        clearProfileAttribute$default(this, key, null, 2, null);
    }

    public final void clearProfileAttributes(@NotNull List<String> keys) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        clearProfileAttributes$default(this, keys, null, 2, null);
    }

    public final void setProfileAttribute(@NotNull String key, @Nullable String str) {
        Intrinsics.checkNotNullParameter(key, "key");
        setProfileAttribute$default(this, key, str, null, 4, null);
    }

    public final void setProfileAttributes(@NotNull Map<String, String> attributes) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        setProfileAttributes$default(this, attributes, null, 2, null);
    }

    public final void setProfileId(@NotNull String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        setProfileId$default(this, id, null, 2, null);
    }

    private Identity(String str) {
        this.registrationId = str;
        this.platform = "Android";
        this._moduleIdentities = new LinkedHashMap();
        this.reservedKeys = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"deviceid", "userid", "eventid", "sessionid", "datetime", "eventtype", "category", "latitude", "longitude"});
    }

    public final String getRegistrationId() {
        return this.registrationId;
    }

    public final String getPlatform() {
        return this.platform;
    }

    public final Map<ModuleIdentifier, ModuleIdentity> getModuleIdentities() {
        return this._moduleIdentities;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private static /* synthetic */ void get_instance$annotations() {
        }

        private Companion() {
        }

        public final Identity getInstance() {
            Identity identity = Identity._instance;
            if (identity != null) {
                return identity;
            }
            throw new IllegalStateException("You must initialize the SDK before attempting to use Identity.");
        }

        public final void setInstance(@NotNull final Identity value) {
            Intrinsics.checkNotNullParameter(value, "value");
            SFMCSdkLogger.INSTANCE.d(Identity.TAG, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.components.identity.Identity$Companion$instance$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "instance = " + value + ", _instance = " + Identity._instance;
                }
            });
            Identity._instance = value;
        }

        public final Identity create$sfmcsdk_release(@NotNull String registrationId) {
            Intrinsics.checkNotNullParameter(registrationId, "registrationId");
            Identity identity = Identity._instance;
            if (identity != null) {
                return identity;
            }
            Identity identity2 = new Identity(registrationId, null);
            Identity.Companion.setInstance(identity2);
            return identity2;
        }

        public final Map<String, Object> toEvent$sfmcsdk_release() throws JSONException {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Identity identity = Identity._instance;
            if (identity != null) {
                linkedHashMap.put("platform", identity.getPlatform());
                linkedHashMap.put("registrationId", identity.getRegistrationId());
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry entry : identity._moduleIdentities.entrySet()) {
                    String lowerCase = ((ModuleIdentifier) entry.getKey()).name().toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                    jSONObject.put(lowerCase, ((ModuleIdentity) entry.getValue()).toJson());
                }
                Unit unit = Unit.INSTANCE;
                linkedHashMap.put("moduleIdentities", jSONObject);
            }
            return linkedHashMap;
        }
    }

    public static /* synthetic */ void setProfileId$default(Identity identity, String str, ModuleIdentifier[] moduleIdentifierArr, int i, Object obj) {
        if ((i & 2) != 0) {
            moduleIdentifierArr = ModuleIdentifier.values();
        }
        identity.setProfileId(str, moduleIdentifierArr);
    }

    public final void setProfileId(@NotNull String id, @NotNull ModuleIdentifier... modules) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(modules, "modules");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (ModuleIdentifier moduleIdentifier : modules) {
            linkedHashMap.put(moduleIdentifier, id);
        }
        setProfileId(linkedHashMap);
    }

    public final void setProfileId(@NotNull Map<ModuleIdentifier, String> ids) {
        ModuleIdentity moduleIdentity;
        Intrinsics.checkNotNullParameter(ids, "ids");
        synchronized (this._moduleIdentities) {
            Iterator<T> it2 = ids.entrySet().iterator();
            while (it2.hasNext()) {
                Map.Entry entry = (Map.Entry) it2.next();
                String validContactKey = SFMCExtension.getValidContactKey((String) entry.getValue());
                if (validContactKey != null && (moduleIdentity = getModuleIdentities().get(entry.getKey())) != null) {
                    moduleIdentity.setProfileId(validContactKey);
                }
            }
            Event eventIdentityEvent$sfmcsdk_release = EventManager.Companion.identityEvent$sfmcsdk_release();
            if (eventIdentityEvent$sfmcsdk_release != null) {
                eventIdentityEvent$sfmcsdk_release.track();
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public static /* synthetic */ void setProfileAttribute$default(Identity identity, String str, String str2, ModuleIdentifier[] moduleIdentifierArr, int i, Object obj) {
        if ((i & 4) != 0) {
            moduleIdentifierArr = ModuleIdentifier.values();
        }
        identity.setProfileAttribute(str, str2, moduleIdentifierArr);
    }

    public final void setProfileAttribute(@NotNull String key, @Nullable String str, @NotNull ModuleIdentifier... modules) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(modules, "modules");
        setProfileAttributes(MapsKt__MapsJVMKt.mapOf(TuplesKt.to(key, str)), (ModuleIdentifier[]) Arrays.copyOf(modules, modules.length));
    }

    public static /* synthetic */ void setProfileAttributes$default(Identity identity, Map map, ModuleIdentifier[] moduleIdentifierArr, int i, Object obj) {
        if ((i & 2) != 0) {
            moduleIdentifierArr = ModuleIdentifier.values();
        }
        identity.setProfileAttributes(map, moduleIdentifierArr);
    }

    public final void setProfileAttributes(@NotNull Map<String, String> attributes, @NotNull ModuleIdentifier... modules) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(modules, "modules");
        synchronized (this._moduleIdentities) {
            for (ModuleIdentifier moduleIdentifier : modules) {
                ModuleIdentity moduleIdentity = this._moduleIdentities.get(moduleIdentifier);
                if (moduleIdentity != null) {
                    moduleIdentity.getCustomProperties().put("attributes", attributes);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        Event eventIdentityEvent$sfmcsdk_release = EventManager.Companion.identityEvent$sfmcsdk_release();
        if (eventIdentityEvent$sfmcsdk_release != null) {
            eventIdentityEvent$sfmcsdk_release.track();
        }
    }

    public static /* synthetic */ void clearProfileAttribute$default(Identity identity, String str, ModuleIdentifier[] moduleIdentifierArr, int i, Object obj) {
        if ((i & 2) != 0) {
            moduleIdentifierArr = ModuleIdentifier.values();
        }
        identity.clearProfileAttribute(str, moduleIdentifierArr);
    }

    public final void clearProfileAttribute(@NotNull String key, @NotNull ModuleIdentifier... modules) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(modules, "modules");
        setProfileAttributes(MapsKt__MapsJVMKt.mapOf(TuplesKt.to(key, "")), (ModuleIdentifier[]) Arrays.copyOf(modules, modules.length));
    }

    public static /* synthetic */ void clearProfileAttributes$default(Identity identity, List list, ModuleIdentifier[] moduleIdentifierArr, int i, Object obj) {
        if ((i & 2) != 0) {
            moduleIdentifierArr = ModuleIdentifier.values();
        }
        identity.clearProfileAttributes(list, moduleIdentifierArr);
    }

    public final void clearProfileAttributes(@NotNull List<String> keys, @NotNull ModuleIdentifier... modules) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        Intrinsics.checkNotNullParameter(modules, "modules");
        List<String> list = keys;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10)), 16));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            linkedHashMap.put((String) it2.next(), "");
        }
        setProfileAttributes(linkedHashMap, (ModuleIdentifier[]) Arrays.copyOf(modules, modules.length));
    }

    public final void setProfile(@NotNull String profileId, @NotNull Map<String, String> attributes, @NotNull ModuleIdentifier module, @NotNull ModuleIdentifier... modules) {
        Intrinsics.checkNotNullParameter(profileId, "profileId");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(modules, "modules");
        setProfile(new Profile(profileId, attributes), module, (ModuleIdentifier[]) Arrays.copyOf(modules, modules.length));
    }

    public final void setProfile(@NotNull Profile profile, @NotNull ModuleIdentifier module, @NotNull ModuleIdentifier... modules) {
        Intrinsics.checkNotNullParameter(profile, "profile");
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(modules, "modules");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(module, profile);
        for (ModuleIdentifier moduleIdentifier : modules) {
            if (!Intrinsics.areEqual(moduleIdentifier.name(), module.name())) {
                linkedHashMap.put(moduleIdentifier, profile);
            }
        }
        setProfile(linkedHashMap);
    }

    public final void setProfile(@NotNull Map<ModuleIdentifier, Profile> identities) {
        Intrinsics.checkNotNullParameter(identities, "identities");
        synchronized (this._moduleIdentities) {
            for (Map.Entry<ModuleIdentifier, Profile> entry : identities.entrySet()) {
                ModuleIdentity moduleIdentity = this._moduleIdentities.get(entry.getKey());
                if (moduleIdentity != null) {
                    moduleIdentity.setProfileId(entry.getValue().getProfileId());
                    moduleIdentity.getCustomProperties().put("attributes", MapsKt__MapsKt.toMutableMap(entry.getValue().getAttributes()));
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        Event eventIdentityEvent$sfmcsdk_release = EventManager.Companion.identityEvent$sfmcsdk_release();
        if (eventIdentityEvent$sfmcsdk_release != null) {
            eventIdentityEvent$sfmcsdk_release.track();
        }
    }

    public final void setModuleIdentity$sfmcsdk_release(@NotNull ModuleIdentity moduleIdentity) {
        Intrinsics.checkNotNullParameter(moduleIdentity, "moduleIdentity");
        synchronized (this._moduleIdentities) {
            this._moduleIdentities.put(moduleIdentity.getModuleName(), moduleIdentity);
            Unit unit = Unit.INSTANCE;
        }
    }

    private final boolean isValidEventAttributeValue(Object obj) {
        return (obj instanceof Number) || (obj instanceof Boolean) || (obj instanceof String) || (obj instanceof Character) || obj == null;
    }

    private final String validatedEventAttributeKey(final String str) {
        final String strJoinToString$default = CollectionsKt___CollectionsKt.joinToString$default(this.reservedKeys, ",", null, null, 0, null, null, 62, null);
        final String string = StringsKt__StringsKt.trim((CharSequence) str).toString();
        if (StringsKt__StringsKt.isBlank(str)) {
            SFMCSdkLogger.INSTANCE.w(TAG, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.components.identity.Identity.validatedEventAttributeKey.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Key '" + str + "' is invalid. Key cannot be empty. The key value pair was dropped.";
                }
            });
        } else {
            List<String> list = this.reservedKeys;
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String lowerCase = str.toLowerCase(US);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            if (list.contains(lowerCase)) {
                SFMCSdkLogger.INSTANCE.w(TAG, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.components.identity.Identity.validatedEventAttributeKey.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Key '" + str + "' is reserved. The key value pair was dropped. Other reserved keys: " + strJoinToString$default;
                    }
                });
            } else {
                if (Intrinsics.areEqual(str, string)) {
                    return string;
                }
                SFMCSdkLogger.INSTANCE.w(TAG, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.components.identity.Identity.validatedEventAttributeKey.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "The key '" + str + "' was trimmed to '" + string + "'";
                    }
                });
                return string;
            }
        }
        return null;
    }

    public final JSONObject toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("platform", this.platform);
        jSONObject.put("registrationId", this.registrationId);
        JSONObject jSONObject2 = new JSONObject();
        for (Map.Entry<ModuleIdentifier, ModuleIdentity> entry : this._moduleIdentities.entrySet()) {
            String lowerCase = entry.getKey().name().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            jSONObject2.put(lowerCase, entry.getValue().toJson());
        }
        Unit unit = Unit.INSTANCE;
        jSONObject.put("moduleIdentities", jSONObject2);
        return jSONObject;
    }

    public String toString() {
        String string = toJson().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
