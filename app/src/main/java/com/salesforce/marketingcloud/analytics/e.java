package com.salesforce.marketingcloud.analytics;

import com.facebook.react.animated.InterpolationAnimatedNode;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.salesforce.marketingcloud.messages.push.PushMessageManager;
import com.salesforce.marketingcloud.sfmcsdk.components.identity.Identity;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class e {
    private final com.salesforce.marketingcloud.registration.f a;
    private final PushMessageManager b;
    private final boolean c;
    private final Identity d;

    public e(@NotNull com.salesforce.marketingcloud.registration.f registrationMeta, @Nullable PushMessageManager pushMessageManager, boolean z, @Nullable Identity identity) {
        Intrinsics.checkNotNullParameter(registrationMeta, "registrationMeta");
        this.a = registrationMeta;
        this.b = pushMessageManager;
        this.c = z;
        this.d = identity;
    }

    private final com.salesforce.marketingcloud.registration.f a() {
        return this.a;
    }

    private final PushMessageManager b() {
        return this.b;
    }

    private final boolean c() {
        return this.c;
    }

    private final Identity d() {
        return this.d;
    }

    public final JSONObject e() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("deviceID", this.a.f());
        jSONObject.put(b.v, this.a.d());
        jSONObject.put(com.salesforce.marketingcloud.storage.db.k.a.m, this.a.g());
        jSONObject.put("platform", this.a.h());
        jSONObject.put("platform_Version", this.a.i());
        jSONObject.put("sdk_Version", this.a.j());
        jSONObject.put("app_Version", this.a.e());
        jSONObject.put("locale", Locale.getDefault().toString());
        jSONObject.put(RemoteConfigConstants.RequestFieldKey.TIME_ZONE, com.salesforce.marketingcloud.util.j.b());
        jSONObject.put("location_Enabled", this.c);
        PushMessageManager pushMessageManager = this.b;
        if (pushMessageManager != null) {
            jSONObject.put("backgroundRefreshEnabled", pushMessageManager.isPushEnabled());
            jSONObject.put("push_Enabled", pushMessageManager.isPushEnabled());
        }
        Identity identity = this.d;
        if (identity != null) {
            jSONObject.put(InterpolationAnimatedNode.EXTRAPOLATE_TYPE_IDENTITY, identity.toJson());
        }
        return jSONObject;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return Intrinsics.areEqual(this.a, eVar.a) && Intrinsics.areEqual(this.b, eVar.b) && this.c == eVar.c && Intrinsics.areEqual(this.d, eVar.d);
    }

    public int hashCode() {
        int iHashCode = this.a.hashCode();
        PushMessageManager pushMessageManager = this.b;
        int iHashCode2 = pushMessageManager == null ? 0 : pushMessageManager.hashCode();
        int iHashCode3 = Boolean.hashCode(this.c);
        Identity identity = this.d;
        return (((((iHashCode * 31) + iHashCode2) * 31) + iHashCode3) * 31) + (identity != null ? identity.hashCode() : 0);
    }

    public String toString() {
        return "EventMetaData(registrationMeta=" + this.a + ", pushMessageManager=" + this.b + ", locationEnabled=" + this.c + ", identity=" + this.d + ")";
    }

    public final e a(@NotNull com.salesforce.marketingcloud.registration.f registrationMeta, @Nullable PushMessageManager pushMessageManager, boolean z, @Nullable Identity identity) {
        Intrinsics.checkNotNullParameter(registrationMeta, "registrationMeta");
        return new e(registrationMeta, pushMessageManager, z, identity);
    }

    public static /* synthetic */ e a(e eVar, com.salesforce.marketingcloud.registration.f fVar, PushMessageManager pushMessageManager, boolean z, Identity identity, int i, Object obj) {
        if ((i & 1) != 0) {
            fVar = eVar.a;
        }
        if ((i & 2) != 0) {
            pushMessageManager = eVar.b;
        }
        if ((i & 4) != 0) {
            z = eVar.c;
        }
        if ((i & 8) != 0) {
            identity = eVar.d;
        }
        return eVar.a(fVar, pushMessageManager, z, identity);
    }
}
