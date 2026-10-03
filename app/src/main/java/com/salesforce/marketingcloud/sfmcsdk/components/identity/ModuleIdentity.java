package com.salesforce.marketingcloud.sfmcsdk.components.identity;

import com.salesforce.marketingcloud.analytics.stats.d;
import com.salesforce.marketingcloud.sfmcsdk.modules.ModuleIdentifier;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class ModuleIdentity {
    private final String applicationId;
    private Map<String, Object> customProperties;
    private String installationId;
    private final ModuleIdentifier moduleName;
    private String profileId;

    public abstract JSONObject customPropertiesToJson(@NotNull Map<String, ? extends Object> map);

    public ModuleIdentity(@NotNull ModuleIdentifier moduleName, @NotNull String applicationId) {
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        Intrinsics.checkNotNullParameter(applicationId, "applicationId");
        this.moduleName = moduleName;
        this.applicationId = applicationId;
        this.customProperties = new LinkedHashMap();
    }

    public final ModuleIdentifier getModuleName() {
        return this.moduleName;
    }

    public final String getApplicationId() {
        return this.applicationId;
    }

    public final String getProfileId() {
        return this.profileId;
    }

    public final void setProfileId(@Nullable String str) {
        if (Intrinsics.areEqual(str, this.profileId)) {
            return;
        }
        this.profileId = str;
    }

    public final Map<String, Object> getCustomProperties() {
        return this.customProperties;
    }

    public final void setCustomProperties(@NotNull Map<String, Object> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (Intrinsics.areEqual(value, this.customProperties)) {
            return;
        }
        this.customProperties = value;
    }

    public final String getInstallationId() {
        return this.installationId;
    }

    public final void setInstallationId(@Nullable String str) {
        if (Intrinsics.areEqual(str, this.installationId)) {
            return;
        }
        this.installationId = str;
    }

    public final JSONObject toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("profileId", this.profileId);
        jSONObject.put(d.b, this.applicationId);
        jSONObject.put("installationId", this.installationId);
        jSONObject.put("customProperties", customPropertiesToJson(this.customProperties));
        return jSONObject;
    }

    public String toString() {
        String string = toJson().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
