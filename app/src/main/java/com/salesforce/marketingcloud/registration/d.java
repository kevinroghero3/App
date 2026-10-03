package com.salesforce.marketingcloud.registration;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Size;
import com.salesforce.marketingcloud.InitializationStatus;
import com.salesforce.marketingcloud.MarketingCloudConfig;
import com.salesforce.marketingcloud.MarketingCloudSdk;
import com.salesforce.marketingcloud.g;
import com.salesforce.marketingcloud.internal.m;
import com.salesforce.marketingcloud.internal.n;
import com.salesforce.marketingcloud.messages.push.PushMessageManager;
import com.salesforce.marketingcloud.sfmcsdk.SFMCSdkComponents;
import com.salesforce.marketingcloud.sfmcsdk.components.events.Event;
import com.salesforce.marketingcloud.sfmcsdk.components.events.EventSubscriber;
import com.salesforce.marketingcloud.sfmcsdk.modules.ModuleIdentifier;
import com.salesforce.marketingcloud.storage.h;
import com.salesforce.marketingcloud.util.j;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TimeZone;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d implements com.salesforce.marketingcloud.e, RegistrationManager, com.salesforce.marketingcloud.behaviors.b, com.salesforce.marketingcloud.alarms.b.InterfaceC0064b, com.salesforce.marketingcloud.http.e.c, e.f, EventSubscriber {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final EnumSet<com.salesforce.marketingcloud.behaviors.a> f83o = EnumSet.of(com.salesforce.marketingcloud.behaviors.a.BEHAVIOR_APP_PACKAGE_REPLACED, com.salesforce.marketingcloud.behaviors.a.BEHAVIOR_DEVICE_TIME_ZONE_CHANGED, com.salesforce.marketingcloud.behaviors.a.BEHAVIOR_APP_FOREGROUNDED, com.salesforce.marketingcloud.behaviors.a.BEHAVIOR_CUSTOMER_FENCE_MESSAGING_TOGGLED, com.salesforce.marketingcloud.behaviors.a.BEHAVIOR_CUSTOMER_PROXIMITY_MESSAGING_TOGGLED, com.salesforce.marketingcloud.behaviors.a.BEHAVIOR_CUSTOMER_PUSH_MESSAGING_TOGGLED, com.salesforce.marketingcloud.behaviors.a.BEHAVIOR_SDK_TOKEN_REFRESHED, com.salesforce.marketingcloud.behaviors.a.BEHAVIOR_APP_BACKGROUNDED);
    private final Context d;
    private final MarketingCloudConfig e;
    private final h f;
    private final com.salesforce.marketingcloud.behaviors.c g;
    private final com.salesforce.marketingcloud.alarms.b h;
    private final com.salesforce.marketingcloud.http.e i;
    private final PushMessageManager j;
    private final n k;
    private final SFMCSdkComponents l;
    private final f m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private e f84n;

    class a implements com.salesforce.marketingcloud.storage.b {
        a() {
        }

        @Override // com.salesforce.marketingcloud.storage.b
        public void a() {
        }

        @Override // com.salesforce.marketingcloud.storage.b
        public void a(String str) {
        }

        @Override // com.salesforce.marketingcloud.storage.b
        public void a(String str, @NonNull String str2) {
        }

        @Override // com.salesforce.marketingcloud.storage.b
        public String b(String str, String str2) {
            return str2;
        }
    }

    static /* synthetic */ class b {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[com.salesforce.marketingcloud.alarms.a.EnumC0062a.values().length];
            b = iArr;
            try {
                iArr[com.salesforce.marketingcloud.alarms.a.EnumC0062a.c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            int[] iArr2 = new int[com.salesforce.marketingcloud.behaviors.a.values().length];
            a = iArr2;
            try {
                iArr2[com.salesforce.marketingcloud.behaviors.a.BEHAVIOR_APP_PACKAGE_REPLACED.ordinal()] = 1;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[com.salesforce.marketingcloud.behaviors.a.BEHAVIOR_DEVICE_TIME_ZONE_CHANGED.ordinal()] = 2;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[com.salesforce.marketingcloud.behaviors.a.BEHAVIOR_CUSTOMER_PUSH_MESSAGING_TOGGLED.ordinal()] = 3;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[com.salesforce.marketingcloud.behaviors.a.BEHAVIOR_CUSTOMER_FENCE_MESSAGING_TOGGLED.ordinal()] = 4;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[com.salesforce.marketingcloud.behaviors.a.BEHAVIOR_CUSTOMER_PROXIMITY_MESSAGING_TOGGLED.ordinal()] = 5;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[com.salesforce.marketingcloud.behaviors.a.BEHAVIOR_APP_FOREGROUNDED.ordinal()] = 6;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[com.salesforce.marketingcloud.behaviors.a.BEHAVIOR_APP_BACKGROUNDED.ordinal()] = 7;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[com.salesforce.marketingcloud.behaviors.a.BEHAVIOR_SDK_TOKEN_REFRESHED.ordinal()] = 8;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    static class c implements RegistrationManager.Editor {
        c() {
        }

        @Override // com.salesforce.marketingcloud.registration.RegistrationManager.Editor
        public RegistrationManager.Editor addTag(String str) {
            return this;
        }

        @Override // com.salesforce.marketingcloud.registration.RegistrationManager.Editor
        public RegistrationManager.Editor addTags(Iterable<String> iterable) {
            return this;
        }

        @Override // com.salesforce.marketingcloud.registration.RegistrationManager.Editor
        public RegistrationManager.Editor addTags(String... strArr) {
            return this;
        }

        @Override // com.salesforce.marketingcloud.registration.RegistrationManager.Editor
        public RegistrationManager.Editor clearAttribute(String str) {
            return this;
        }

        @Override // com.salesforce.marketingcloud.registration.RegistrationManager.Editor
        public RegistrationManager.Editor clearAttributes(Iterable<String> iterable) {
            return this;
        }

        @Override // com.salesforce.marketingcloud.registration.RegistrationManager.Editor
        public RegistrationManager.Editor clearAttributes(String... strArr) {
            return this;
        }

        @Override // com.salesforce.marketingcloud.registration.RegistrationManager.Editor
        public RegistrationManager.Editor clearTags() {
            return this;
        }

        @Override // com.salesforce.marketingcloud.registration.RegistrationManager.Editor
        public boolean commit() {
            return false;
        }

        @Override // com.salesforce.marketingcloud.registration.RegistrationManager.Editor
        public RegistrationManager.Editor removeTag(String str) {
            return this;
        }

        @Override // com.salesforce.marketingcloud.registration.RegistrationManager.Editor
        public RegistrationManager.Editor removeTags(Iterable<String> iterable) {
            return this;
        }

        @Override // com.salesforce.marketingcloud.registration.RegistrationManager.Editor
        public RegistrationManager.Editor removeTags(String... strArr) {
            return this;
        }

        @Override // com.salesforce.marketingcloud.registration.RegistrationManager.Editor
        public RegistrationManager.Editor setAttribute(@NonNull String str, @NonNull String str2) {
            return this;
        }

        @Override // com.salesforce.marketingcloud.registration.RegistrationManager.Editor
        public RegistrationManager.Editor setContactKey(@NonNull String str) {
            return this;
        }

        @Override // com.salesforce.marketingcloud.registration.RegistrationManager.Editor
        public RegistrationManager.Editor setSignedString(@NonNull String str) {
            return this;
        }
    }

    public d(@NonNull Context context, @NonNull MarketingCloudConfig marketingCloudConfig, @NonNull h hVar, @NonNull f fVar, @NonNull com.salesforce.marketingcloud.behaviors.c cVar, @NonNull com.salesforce.marketingcloud.alarms.b bVar, @NonNull com.salesforce.marketingcloud.http.e eVar, @NonNull PushMessageManager pushMessageManager, @NonNull n nVar) {
        this(context, marketingCloudConfig, hVar, fVar, cVar, bVar, eVar, pushMessageManager, nVar, (SFMCSdkComponents) null);
    }

    static String a(Registration registration, @Nullable String str) {
        try {
            return m.c(registration).put("registrationDateUtc", j.a(new Date())).put("quietPushEnabled", false).putOpt("registrationId", str).toString();
        } catch (Exception e) {
            g.b(RegistrationManager.a, e, "Unable to create registration request payload", new Object[0]);
            return null;
        }
    }

    @Override // com.salesforce.marketingcloud.d
    public final String componentName() {
        return "RegistrationManager";
    }

    @Override // com.salesforce.marketingcloud.d
    public final JSONObject componentState() {
        e eVar = this.f84n;
        return eVar != null ? eVar.d() : new JSONObject();
    }

    @Override // com.salesforce.marketingcloud.e
    public void controlChannelInit(int i) {
        if (!com.salesforce.marketingcloud.b.a(i, 2)) {
            if (this.f84n == null) {
                a((InitializationStatus.a) null);
                this.f84n.g();
                return;
            }
            return;
        }
        this.f84n = null;
        e.a(this.f, this.h, com.salesforce.marketingcloud.b.c(i, 2));
        this.g.a(this);
        a();
        this.h.e(com.salesforce.marketingcloud.alarms.a.EnumC0062a.c);
        this.i.a(com.salesforce.marketingcloud.http.b.p);
    }

    @Override // com.salesforce.marketingcloud.registration.RegistrationManager
    public RegistrationManager.Editor edit() {
        e eVar = this.f84n;
        return eVar != null ? eVar.a(this) : new c();
    }

    @Override // com.salesforce.marketingcloud.registration.RegistrationManager
    public Map<String, String> getAttributes() {
        e eVar = this.f84n;
        return eVar != null ? eVar.getAttributes() : Collections.emptyMap();
    }

    @Override // com.salesforce.marketingcloud.registration.RegistrationManager
    public String getContactKey() {
        e eVar = this.f84n;
        if (eVar != null) {
            return eVar.getContactKey();
        }
        return null;
    }

    @Override // com.salesforce.marketingcloud.registration.RegistrationManager
    public String getDeviceId() {
        e eVar = this.f84n;
        return eVar != null ? eVar.getDeviceId() : "";
    }

    @Override // com.salesforce.marketingcloud.registration.RegistrationManager
    public String getSignedString() {
        e eVar = this.f84n;
        if (eVar != null) {
            return eVar.getSignedString();
        }
        return null;
    }

    @Override // com.salesforce.marketingcloud.registration.RegistrationManager
    public String getSystemToken() {
        e eVar = this.f84n;
        if (eVar != null) {
            return eVar.getSystemToken();
        }
        return null;
    }

    @Override // com.salesforce.marketingcloud.registration.RegistrationManager
    public Set<String> getTags() {
        e eVar = this.f84n;
        return eVar != null ? eVar.getTags() : Collections.emptySet();
    }

    @Override // com.salesforce.marketingcloud.e
    public void init(@NonNull InitializationStatus.a aVar, int i) {
        if (com.salesforce.marketingcloud.b.b(i, 2)) {
            a(aVar);
        }
    }

    @Override // com.salesforce.marketingcloud.behaviors.b
    public final void onBehavior(@NonNull com.salesforce.marketingcloud.behaviors.a aVar, @NonNull Bundle bundle) {
        if (this.f84n != null) {
            switch (b.a[aVar.ordinal()]) {
                case 1:
                    this.f84n.c();
                    break;
                case 2:
                    this.f84n.h();
                    break;
                case 3:
                    this.f84n.b(bundle.getBoolean(PushMessageManager.g));
                    break;
                case 4:
                case 5:
                case 6:
                    this.f84n.b();
                    break;
                case 7:
                    this.f84n.a();
                    break;
                case 8:
                    this.f84n.a(bundle.getString(PushMessageManager.h, ""));
                    break;
                default:
                    g.a(RegistrationManager.a, "Unhandled behavior: %s", aVar);
                    break;
            }
        }
    }

    @Override // com.salesforce.marketingcloud.sfmcsdk.components.events.EventSubscriber
    public void onEventPublished(@NonNull Event... eventArr) {
        for (com.salesforce.marketingcloud.events.Event event : com.salesforce.marketingcloud.events.d.a(eventArr, (EnumSet<Event.Producer>) EnumSet.of(Event.Producer.SFMC_SDK), (EnumSet<Event.Category>) EnumSet.of(Event.Category.IDENTITY))) {
            try {
                Object obj = event.attributes().get("moduleIdentities");
                Objects.requireNonNull(obj);
                JSONObject jSONObject = (JSONObject) ((JSONObject) obj).get(ModuleIdentifier.PUSH.name().toLowerCase());
                JSONObject jSONObject2 = jSONObject.getJSONObject("customProperties").getJSONObject("attributes");
                Iterator<String> itKeys = jSONObject2.keys();
                HashMap map = new HashMap();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    Object obj2 = jSONObject2.get(next);
                    map.put(next, obj2 instanceof String ? (String) obj2 : "");
                }
                String strOptString = jSONObject.optString("profileId", null);
                if (strOptString != null) {
                    this.f84n.b(this).a(strOptString, (Map<String, String>) map, false).commit();
                } else {
                    this.f84n.b(this).a((Map<String, String>) map, false).commit();
                }
            } catch (Exception e) {
                g.e(RegistrationManager.a, e, "Failed to parse event for identity update.", new Object[0]);
            }
        }
    }

    @Override // com.salesforce.marketingcloud.registration.RegistrationManager
    public void registerForRegistrationEvents(@NonNull RegistrationManager.RegistrationEventListener registrationEventListener) {
        e eVar = this.f84n;
        if (eVar != null) {
            eVar.registerForRegistrationEvents(registrationEventListener);
        }
    }

    @Override // com.salesforce.marketingcloud.d
    public void tearDown(boolean z) {
        com.salesforce.marketingcloud.alarms.b bVar = this.h;
        com.salesforce.marketingcloud.alarms.a.EnumC0062a enumC0062a = com.salesforce.marketingcloud.alarms.a.EnumC0062a.c;
        bVar.d(enumC0062a);
        this.h.e(enumC0062a);
        this.g.a(this);
        a();
    }

    @Override // com.salesforce.marketingcloud.registration.RegistrationManager
    public void unregisterForRegistrationEvents(@NonNull RegistrationManager.RegistrationEventListener registrationEventListener) {
        e eVar = this.f84n;
        if (eVar != null) {
            eVar.unregisterForRegistrationEvents(registrationEventListener);
        }
    }

    public d(@NonNull Context context, @NonNull MarketingCloudConfig marketingCloudConfig, @NonNull h hVar, @NonNull f fVar, @NonNull com.salesforce.marketingcloud.behaviors.c cVar, @NonNull com.salesforce.marketingcloud.alarms.b bVar, @NonNull com.salesforce.marketingcloud.http.e eVar, @NonNull PushMessageManager pushMessageManager, @NonNull n nVar, @Nullable SFMCSdkComponents sFMCSdkComponents) {
        this.d = context;
        this.e = marketingCloudConfig;
        this.f = hVar;
        this.m = fVar;
        this.g = cVar;
        this.h = bVar;
        this.i = eVar;
        this.j = pushMessageManager;
        this.k = nVar;
        this.l = sFMCSdkComponents;
    }

    public static com.salesforce.marketingcloud.http.f a(@NonNull MarketingCloudConfig marketingCloudConfig, @NonNull Context context, @NonNull @Size(min = 1) String str, @Nullable String str2) {
        return com.salesforce.marketingcloud.http.b.p.a(marketingCloudConfig, new a(), a(new Registration(0, UUID.randomUUID().toString(), null, str, null, MarketingCloudSdk.getSdkVersionName(), com.salesforce.marketingcloud.util.f.a(context), TimeZone.getDefault().inDaylightTime(new Date()), false, false, Build.VERSION.RELEASE, false, j.b(), null, "Android", String.format(Locale.ENGLISH, "%s %s", Build.MANUFACTURER, Build.MODEL), marketingCloudConfig.applicationId(), Locale.getDefault().toString(), Collections.emptySet(), Collections.emptyMap()), str2)).k();
    }

    d(e eVar, Context context, MarketingCloudConfig marketingCloudConfig, h hVar, f fVar, com.salesforce.marketingcloud.behaviors.c cVar, com.salesforce.marketingcloud.alarms.b bVar, com.salesforce.marketingcloud.http.e eVar2, PushMessageManager pushMessageManager, n nVar) {
        this.f84n = eVar;
        this.d = context;
        this.e = marketingCloudConfig;
        this.f = hVar;
        this.m = fVar;
        this.g = cVar;
        this.h = bVar;
        this.i = eVar2;
        this.j = pushMessageManager;
        this.k = nVar;
        this.l = null;
    }

    public static String a(@NonNull h hVar) {
        return hVar.c().b(com.salesforce.marketingcloud.storage.b.d, null);
    }

    private void a(InitializationStatus.a aVar) {
        this.g.a(this, f83o);
        this.h.a(this, com.salesforce.marketingcloud.alarms.a.EnumC0062a.c);
        this.i.a(com.salesforce.marketingcloud.http.b.p, this);
        SFMCSdkComponents sFMCSdkComponents = this.l;
        if (sFMCSdkComponents != null) {
            sFMCSdkComponents.getEventManager().subscribe(this);
        }
        try {
            this.f84n = new e(this.d, this.e, this.f, this.m, this.h, this.i, this.j, this.k, this.l);
        } catch (Exception e) {
            if (aVar != null) {
                aVar.a(e);
            }
        }
    }

    private void a() {
        SFMCSdkComponents sFMCSdkComponents = this.l;
        if (sFMCSdkComponents != null) {
            sFMCSdkComponents.getEventManager().unsubscribe(this);
        }
    }

    @Override // com.salesforce.marketingcloud.registration.e.f
    public void a(String str, String str2, Map<String, String> map, Collection<String> collection, boolean z) {
        e eVar = this.f84n;
        if (eVar != null) {
            try {
                eVar.a(str, str2, map, collection, z);
            } catch (Exception e) {
                g.b(RegistrationManager.a, e, "Error encountered while saving registration", new Object[0]);
            }
        }
    }

    @Override // com.salesforce.marketingcloud.alarms.b.InterfaceC0064b
    public final void a(@NonNull com.salesforce.marketingcloud.alarms.a.EnumC0062a enumC0062a) {
        e eVar;
        if (b.b[enumC0062a.ordinal()] == 1 && (eVar = this.f84n) != null) {
            eVar.e();
        }
    }

    @Override // com.salesforce.marketingcloud.http.e.c
    public void a(com.salesforce.marketingcloud.http.c cVar, com.salesforce.marketingcloud.http.f fVar) {
        if (this.f84n != null) {
            if (fVar.p()) {
                try {
                    this.f84n.a(m.a(new JSONObject(cVar.p())), fVar.m());
                    return;
                } catch (Exception unused) {
                    this.f84n.a(-1, "Failed to convert our Response Body into a Registration.");
                    return;
                }
            }
            this.f84n.a(fVar.k(), fVar.n());
        }
    }
}
