package com.salesforce.marketingcloud.registration;

import android.content.Context;
import android.os.CountDownTimer;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Size;
import androidx.collection.ArraySet;
import androidx.core.app.NotificationManagerCompat;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.salesforce.marketingcloud.MarketingCloudConfig;
import com.salesforce.marketingcloud.MarketingCloudSdk;
import com.salesforce.marketingcloud.g;
import com.salesforce.marketingcloud.internal.i;
import com.salesforce.marketingcloud.internal.m;
import com.salesforce.marketingcloud.internal.n;
import com.salesforce.marketingcloud.messages.push.PushMessageManager;
import com.salesforce.marketingcloud.sfmcsdk.SFMCSdkComponents;
import com.salesforce.marketingcloud.sfmcsdk.modules.ModuleIdentifier;
import com.salesforce.marketingcloud.sfmcsdk.util.SFMCExtension;
import com.salesforce.marketingcloud.storage.h;
import com.salesforce.marketingcloud.util.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
class e implements RegistrationManager {
    public static final String w = "Android";
    static final String x = "previousRegistrationHash";
    static final String y = "lastRegistrationSendTimestamp";
    final Set<String> d;
    final MarketingCloudConfig e;
    final h f;
    final com.salesforce.marketingcloud.alarms.b g;
    final com.salesforce.marketingcloud.http.e h;
    final n i;
    final SFMCSdkComponents j;
    private final Context k;
    private final Set<RegistrationManager.RegistrationEventListener> l;
    private final com.salesforce.marketingcloud.registration.f m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private ConcurrentHashMap<String, String> f85n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private ConcurrentSkipListSet<String> f86o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private String t;
    private String u;
    private String v;

    class a implements MarketingCloudSdk.WhenReadyListener {
        final /* synthetic */ boolean a;

        /* JADX INFO: renamed from: com.salesforce.marketingcloud.registration.e$a$a, reason: collision with other inner class name */
        class CountDownTimerC0112a extends AbstractCountDownTimerC0114e {

            /* JADX INFO: renamed from: com.salesforce.marketingcloud.registration.e$a$a$a, reason: collision with other inner class name */
            class C0113a extends i {
                C0113a(String str, Object... objArr) {
                    super(str, objArr);
                }

                @Override // com.salesforce.marketingcloud.internal.i
                public void a() {
                    try {
                        SFMCSdkComponents sFMCSdkComponents = e.this.j;
                        String registrationId = sFMCSdkComponents != null ? sFMCSdkComponents.getRegistrationId() : null;
                        Registration registrationK = e.this.f.p().k(e.this.f.b());
                        e eVar = e.this;
                        if (e.a(registrationK, eVar.f, eVar.e.delayRegistrationUntilContactKeyIsSet())) {
                            e.this.g.d(com.salesforce.marketingcloud.alarms.a.EnumC0062a.c);
                            e eVar2 = e.this;
                            eVar2.h.a(com.salesforce.marketingcloud.http.b.p.a(eVar2.e, eVar2.f.c(), com.salesforce.marketingcloud.registration.d.a(registrationK, registrationId)));
                        }
                    } catch (Exception e) {
                        g.b(RegistrationManager.a, e, "Failed to get our Registration from local storage.", new Object[0]);
                    }
                }
            }

            CountDownTimerC0112a(int i) {
                super(i);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                e.this.i.b().execute(new C0113a("registration_request", new Object[0]));
            }
        }

        a(boolean z) {
            this.a = z;
        }

        @Override // com.salesforce.marketingcloud.MarketingCloudSdk.WhenReadyListener
        public void ready(@NonNull MarketingCloudSdk marketingCloudSdk) {
            new CountDownTimerC0112a(this.a ? 1000 : 0).start();
        }
    }

    class b extends i {
        b(String str, Object... objArr) {
            super(str, objArr);
        }

        @Override // com.salesforce.marketingcloud.internal.i
        public void a() {
            e.this.f.p().c();
        }
    }

    class c extends i {
        c(String str, Object... objArr) {
            super(str, objArr);
        }

        @Override // com.salesforce.marketingcloud.internal.i
        public void a() {
            e eVar = e.this;
            if (e.a(eVar.f, eVar.e.delayRegistrationUntilContactKeyIsSet())) {
                e.this.g.b(com.salesforce.marketingcloud.alarms.a.EnumC0062a.c);
            }
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.registration.e$e, reason: collision with other inner class name */
    static abstract class AbstractCountDownTimerC0114e extends CountDownTimer {
        public AbstractCountDownTimerC0114e(int i) {
            this(i, 1000L);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
        }

        private AbstractCountDownTimerC0114e(long j, long j2) {
            super(j, j2);
        }
    }

    interface f {
        default void a(String str, String str2, Map<String, String> map, Collection<String> collection) {
            a(str, str2, map, collection, false);
        }

        void a(String str, String str2, Map<String, String> map, Collection<String> collection, boolean z);
    }

    e(@NonNull Context context, @NonNull MarketingCloudConfig marketingCloudConfig, @NonNull h hVar, @NonNull com.salesforce.marketingcloud.registration.f fVar, @NonNull com.salesforce.marketingcloud.alarms.b bVar, @NonNull com.salesforce.marketingcloud.http.e eVar, @NonNull PushMessageManager pushMessageManager, @NonNull n nVar) {
        this(context, marketingCloudConfig, hVar, fVar, bVar, eVar, pushMessageManager, nVar, null);
    }

    private static ConcurrentSkipListSet<String> a(ConcurrentSkipListSet<String> concurrentSkipListSet, Set<String> set) {
        if (!concurrentSkipListSet.containsAll(set)) {
            concurrentSkipListSet.addAll(set);
        }
        return concurrentSkipListSet;
    }

    com.salesforce.marketingcloud.registration.c b(f fVar) {
        return new d(fVar, this.v, this.t, this.f85n, this.f86o, this.d);
    }

    void c(boolean z) {
        try {
            Registration registrationA = a(0);
            this.i.b().execute(new com.salesforce.marketingcloud.registration.a(this.f.p(), this.f.b(), registrationA, false));
            a(this.f, registrationA.contactKey());
            if (a(registrationA, this.f, this.e.delayRegistrationUntilContactKeyIsSet())) {
                SFMCSdkComponents sFMCSdkComponents = this.j;
                if (sFMCSdkComponents != null && z) {
                    if (this.t != null) {
                        sFMCSdkComponents.getIdentity().setProfile(this.t, this.f85n, ModuleIdentifier.PUSH, new ModuleIdentifier[0]);
                    } else {
                        sFMCSdkComponents.getIdentity().setProfileAttributes(this.f85n, ModuleIdentifier.PUSH);
                    }
                }
                e();
            }
        } catch (Exception e) {
            g.b(RegistrationManager.a, e, "An error occurred trying to save our Registration.", new Object[0]);
        }
    }

    JSONObject d() {
        String strB;
        Registration registrationA = a(0);
        if (registrationA == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("current_registration", m.c(registrationA));
            if (a(registrationA, this.f, this.e.delayRegistrationUntilContactKeyIsSet()) && (strB = this.f.c().b(com.salesforce.marketingcloud.storage.b.h, null)) != null) {
                jSONObject.put("last_registration_sent", new JSONObject(strB));
            }
            long j = this.f.e().getLong(y, 0L);
            if (j > 0) {
                jSONObject.put("last_sent_timestamp", j.a(new Date(j)));
            }
        } catch (JSONException e) {
            g.b(RegistrationManager.a, e, "Failed to build our component state JSONObject.", new Object[0]);
        }
        return jSONObject;
    }

    void e() {
        a(true);
    }

    @Override // com.salesforce.marketingcloud.registration.RegistrationManager
    public RegistrationManager.Editor edit() {
        g.a(RegistrationManager.a, "Changes with this editor will not be saved.", new Object[0]);
        return new d(null, this.v, this.t, this.f85n, this.f86o, this.d);
    }

    boolean f() {
        return this.s && NotificationManagerCompat.from(this.k).areNotificationsEnabled();
    }

    void g() {
        c(false);
    }

    @Override // com.salesforce.marketingcloud.registration.RegistrationManager
    public Map<String, String> getAttributes() {
        return new HashMap(this.f85n);
    }

    @Override // com.salesforce.marketingcloud.registration.RegistrationManager
    public String getContactKey() {
        return this.t;
    }

    @Override // com.salesforce.marketingcloud.registration.RegistrationManager
    public String getDeviceId() {
        return this.m.f();
    }

    @Override // com.salesforce.marketingcloud.registration.RegistrationManager
    public String getSignedString() {
        return this.v;
    }

    @Override // com.salesforce.marketingcloud.registration.RegistrationManager
    public String getSystemToken() {
        return this.u;
    }

    @Override // com.salesforce.marketingcloud.registration.RegistrationManager
    public Set<String> getTags() {
        return new TreeSet((SortedSet) this.f86o);
    }

    void h() {
        g();
    }

    @Override // com.salesforce.marketingcloud.registration.RegistrationManager
    public void registerForRegistrationEvents(@NonNull RegistrationManager.RegistrationEventListener registrationEventListener) {
        if (registrationEventListener == null) {
            return;
        }
        synchronized (this.l) {
            this.l.add(registrationEventListener);
        }
    }

    @Override // com.salesforce.marketingcloud.registration.RegistrationManager
    public void unregisterForRegistrationEvents(@NonNull RegistrationManager.RegistrationEventListener registrationEventListener) {
        synchronized (this.l) {
            this.l.remove(registrationEventListener);
        }
    }

    static class d implements RegistrationManager.Editor, com.salesforce.marketingcloud.registration.c {
        private static final List<String> j;
        private final Object a = new Object();
        private final Map<String, String> b;
        private final Set<String> c;
        private final f d;
        private final Map<String, String> e;
        private String f;
        private String g;
        private boolean h;
        private boolean i;

        static {
            String[] strArr = {"addressId", "alias", "apId", "backgroundRefreshEnabled", "badge", "channel", "contactId", "contactKey", "createdBy", "createdDate", "customObjectKey", "device", "deviceId", "deviceType", "gcmSenderId", "hardwareId", "isHonorDst", "lastAppOpen", "lastMessageOpen", "lastSend", "locationEnabled", "messageOpenCount", "modifiedBy", "modifiedDate", "optInDate", "optInMethodId", "optInStatusId", "optOutDate", "optOutMethodId", "optOutStatusId", "platform", RemoteConfigConstants.RequestFieldKey.PLATFORM_VERSION, "providerToken", "proximityEnabled", "pushAddressExtensionId", "pushApplicationId", RemoteConfigConstants.RequestFieldKey.SDK_VERSION, "sendCount", "source", "sourceObjectId", "status", "systemToken", "timezone", "utcOffset", "signedString", "quietPushEnabled"};
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 46; i++) {
                arrayList.add(strArr[i].toLowerCase(Locale.ENGLISH));
            }
            j = Collections.unmodifiableList(arrayList);
        }

        d(f fVar, String str, String str2, ConcurrentHashMap<String, String> concurrentHashMap, ConcurrentSkipListSet<String> concurrentSkipListSet, Set<String> set) {
            Comparator comparator = String.CASE_INSENSITIVE_ORDER;
            this.b = new TreeMap(comparator);
            this.c = new TreeSet(comparator);
            this.d = fVar;
            this.f = str;
            this.g = str2;
            this.e = new com.salesforce.marketingcloud.registration.b(concurrentHashMap);
            for (String str3 : concurrentSkipListSet) {
                this.b.put(str3, str3);
            }
            this.c.addAll(set);
        }

        private boolean b(String str) {
            if (str != null) {
                return true;
            }
            g.b(RegistrationManager.a, "Attribute value was null and will not be saved.", new Object[0]);
            return false;
        }

        private boolean c(@Nullable String str) {
            return str == null || TextUtils.getTrimmedLength(str) > 0;
        }

        private String d(String str) {
            String validContactKey = SFMCExtension.getValidContactKey(str);
            if (validContactKey == null) {
                g.e(RegistrationManager.a, "An invalid ContactKey will not be transmitted to the Marketing Cloud and was NOT updated with the provided value.", new Object[0]);
            }
            return validContactKey;
        }

        private String e(String str) {
            return str != null ? str.trim() : str;
        }

        @Override // com.salesforce.marketingcloud.registration.c
        public RegistrationManager.Editor a(@NonNull String str, @NonNull String str2, boolean z) {
            synchronized (this.a) {
                if (a(str) && b(str2)) {
                    this.e.put(str, str2);
                    this.h = true;
                    this.i = z;
                }
            }
            return this;
        }

        @Override // com.salesforce.marketingcloud.registration.RegistrationManager.Editor
        public RegistrationManager.Editor addTag(String str) {
            String strE = e(str);
            synchronized (this.a) {
                if (!TextUtils.isEmpty(strE) && !strE.equals(this.b.put(strE, strE))) {
                    this.h = true;
                }
            }
            return this;
        }

        @Override // com.salesforce.marketingcloud.registration.RegistrationManager.Editor
        public RegistrationManager.Editor addTags(Iterable<String> iterable) {
            if (iterable == null) {
                return this;
            }
            Iterator<String> it2 = iterable.iterator();
            while (it2.hasNext()) {
                addTag(it2.next());
            }
            return this;
        }

        @Override // com.salesforce.marketingcloud.registration.RegistrationManager.Editor
        public RegistrationManager.Editor clearAttribute(String str) {
            return !a(str) ? this : setAttribute(str, "");
        }

        @Override // com.salesforce.marketingcloud.registration.RegistrationManager.Editor
        public RegistrationManager.Editor clearAttributes(Iterable<String> iterable) {
            Iterator<String> it2 = iterable.iterator();
            while (it2.hasNext()) {
                clearAttribute(it2.next());
            }
            return this;
        }

        @Override // com.salesforce.marketingcloud.registration.RegistrationManager.Editor
        public RegistrationManager.Editor clearTags() {
            synchronized (this.a) {
                if (this.b.keySet().retainAll(this.c)) {
                    this.h = true;
                }
            }
            return this;
        }

        @Override // com.salesforce.marketingcloud.registration.RegistrationManager.Editor
        public boolean commit() {
            f fVar;
            synchronized (this.a) {
                if (!this.h || (fVar = this.d) == null) {
                    return false;
                }
                fVar.a(this.f, this.g, this.e, this.b.values(), this.i);
                return true;
            }
        }

        @Override // com.salesforce.marketingcloud.registration.RegistrationManager.Editor
        public RegistrationManager.Editor removeTag(String str) {
            if (str == null) {
                return this;
            }
            synchronized (this.a) {
                if (!this.c.contains(str) && this.b.remove(str) != null) {
                    this.h = true;
                }
            }
            return this;
        }

        @Override // com.salesforce.marketingcloud.registration.RegistrationManager.Editor
        public RegistrationManager.Editor removeTags(Iterable<String> iterable) {
            if (iterable == null) {
                return this;
            }
            Iterator<String> it2 = iterable.iterator();
            while (it2.hasNext()) {
                removeTag(it2.next());
            }
            return this;
        }

        @Override // com.salesforce.marketingcloud.registration.RegistrationManager.Editor
        @Deprecated
        public RegistrationManager.Editor setAttribute(@NonNull String str, @NonNull String str2) {
            return a(str, str2, true);
        }

        @Override // com.salesforce.marketingcloud.registration.RegistrationManager.Editor
        @Deprecated
        public RegistrationManager.Editor setContactKey(@NonNull String str) {
            return a(str, true);
        }

        @Override // com.salesforce.marketingcloud.registration.RegistrationManager.Editor
        public RegistrationManager.Editor setSignedString(@Nullable @Size(min = 1) String str) {
            synchronized (this.a) {
                if (c(str)) {
                    this.f = str;
                    this.h = true;
                }
            }
            return this;
        }

        @Override // com.salesforce.marketingcloud.registration.RegistrationManager.Editor
        public RegistrationManager.Editor addTags(String... strArr) {
            if (strArr != null && strArr.length != 0) {
                for (String str : strArr) {
                    addTag(str);
                }
            }
            return this;
        }

        @Override // com.salesforce.marketingcloud.registration.RegistrationManager.Editor
        public RegistrationManager.Editor clearAttributes(String... strArr) {
            if (strArr != null && strArr.length != 0) {
                for (String str : strArr) {
                    clearAttribute(str);
                }
            }
            return this;
        }

        @Override // com.salesforce.marketingcloud.registration.RegistrationManager.Editor
        public RegistrationManager.Editor removeTags(String... strArr) {
            if (strArr != null && strArr.length != 0) {
                for (String str : strArr) {
                    removeTag(str);
                }
            }
            return this;
        }

        @Override // com.salesforce.marketingcloud.registration.c
        public RegistrationManager.Editor a(@NonNull String str, boolean z) {
            String strD = d(str);
            if (strD != null) {
                synchronized (this.a) {
                    this.h = true;
                    this.i = z;
                    this.g = strD;
                }
            }
            return this;
        }

        @Override // com.salesforce.marketingcloud.registration.c
        public RegistrationManager.Editor a(@NonNull String str, @NonNull Map<String, String> map, boolean z) {
            a(str, z);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                a(entry.getKey(), entry.getValue(), z);
            }
            return this;
        }

        @Override // com.salesforce.marketingcloud.registration.c
        public RegistrationManager.Editor a(@NonNull Map<String, String> map, boolean z) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                a(entry.getKey(), entry.getValue(), z);
            }
            return this;
        }

        private boolean a(String str) {
            if (TextUtils.isEmpty(str)) {
                g.e(RegistrationManager.a, "The attribute you provided was null or empty.", new Object[0]);
                return false;
            }
            String strTrim = str.trim();
            if (TextUtils.isEmpty(strTrim)) {
                g.e(RegistrationManager.a, "The attribute you provided was blank.", new Object[0]);
                return false;
            }
            if (j.contains(strTrim.toLowerCase(Locale.ENGLISH))) {
                g.e(RegistrationManager.a, "Attribute key '%s' is invalid and can not be added.  Please see documentation regarding Attributes and Reserved Words.", strTrim);
                return false;
            }
            if (strTrim.length() <= 128) {
                return true;
            }
            g.e(RegistrationManager.a, "Your attribute key was %s characters long.  Attribute keys are restricted to %s characters.  Your attribute key will be truncated.", Integer.valueOf(strTrim.length()), 128);
            return false;
        }
    }

    e(@NonNull Context context, @NonNull MarketingCloudConfig marketingCloudConfig, @NonNull h hVar, @NonNull com.salesforce.marketingcloud.registration.f fVar, @NonNull com.salesforce.marketingcloud.alarms.b bVar, @NonNull com.salesforce.marketingcloud.http.e eVar, @NonNull PushMessageManager pushMessageManager, @NonNull n nVar, SFMCSdkComponents sFMCSdkComponents) {
        Registration registrationA;
        this.l = new ArraySet();
        this.k = context;
        this.e = marketingCloudConfig;
        this.f = hVar;
        this.m = fVar;
        this.g = bVar;
        this.h = eVar;
        this.i = nVar;
        this.j = sFMCSdkComponents;
        TreeSet treeSet = new TreeSet();
        treeSet.add("ALL");
        treeSet.add("Android");
        if (j.a(context)) {
            treeSet.add("DEBUG");
        }
        Set<String> setUnmodifiableSet = Collections.unmodifiableSet(treeSet);
        this.d = setUnmodifiableSet;
        this.s = pushMessageManager.isPushEnabled();
        boolean zB = com.salesforce.marketingcloud.util.f.b(context);
        this.p = zB;
        boolean z = true;
        boolean z2 = false;
        this.q = zB && com.salesforce.marketingcloud.util.f.c(context);
        this.r = NotificationManagerCompat.from(context).areNotificationsEnabled();
        this.u = pushMessageManager.getPushToken();
        com.salesforce.marketingcloud.storage.b bVarC = hVar.c();
        try {
            Registration registrationK = hVar.p().k(hVar.b());
            if (registrationK == null) {
                this.v = null;
                this.t = bVarC.b(com.salesforce.marketingcloud.storage.b.d, null);
                this.f85n = new ConcurrentHashMap<>(j.b(bVarC.b(com.salesforce.marketingcloud.storage.b.b, "")));
                ConcurrentSkipListSet concurrentSkipListSet = new ConcurrentSkipListSet(j.c(bVarC.b(com.salesforce.marketingcloud.storage.b.c, "")));
                this.f86o = concurrentSkipListSet.isEmpty() ? new ConcurrentSkipListSet<>(setUnmodifiableSet) : a((ConcurrentSkipListSet<String>) concurrentSkipListSet, setUnmodifiableSet);
                registrationA = a(0);
                z = false;
            } else {
                this.v = registrationK.signedString();
                this.t = registrationK.contactKey();
                this.f85n = new ConcurrentHashMap<>(registrationK.attributes());
                this.f86o = a((ConcurrentSkipListSet<String>) new ConcurrentSkipListSet(registrationK.tags()), setUnmodifiableSet);
                Registration registrationA2 = a(m.b(registrationK));
                registrationA = j.a(registrationK, registrationA2) ? registrationA2 : registrationK;
            }
            a(hVar, this.t);
            z2 = z;
        } catch (Exception e) {
            g.b(RegistrationManager.a, e, "Error trying to get, update or add a registration to local storage.", new Object[0]);
            this.f86o = new ConcurrentSkipListSet<>(this.d);
            this.f85n = new ConcurrentHashMap<>();
            this.t = null;
            this.v = null;
            registrationA = a(0);
        }
        nVar.b().execute(new com.salesforce.marketingcloud.registration.a(hVar.p(), hVar.b(), registrationA, z2));
        if (a(registrationA, hVar, marketingCloudConfig.delayRegistrationUntilContactKeyIsSet())) {
            e();
        }
    }

    void b() {
        boolean zB = com.salesforce.marketingcloud.util.f.b(this.k);
        boolean z = zB && com.salesforce.marketingcloud.util.f.c(this.k);
        boolean zAreNotificationsEnabled = NotificationManagerCompat.from(this.k).areNotificationsEnabled();
        if (zB == this.p && z == this.q && zAreNotificationsEnabled == this.r) {
            return;
        }
        this.p = zB;
        this.q = z;
        this.r = zAreNotificationsEnabled;
        g();
    }

    static void a(h hVar, com.salesforce.marketingcloud.alarms.b bVar, boolean z) {
        if (z) {
            hVar.p().n();
            hVar.c().a(com.salesforce.marketingcloud.storage.b.d);
        }
        bVar.d(com.salesforce.marketingcloud.alarms.a.EnumC0062a.c);
    }

    static boolean a(@NonNull h hVar, boolean z) {
        try {
            return a(hVar.p().k(hVar.b()), hVar, z);
        } catch (Exception e) {
            g.b(RegistrationManager.a, e, "Failed to get Registration from local storage or we can not determine if this Registration contains any changes.", new Object[0]);
            return false;
        }
    }

    static boolean a(Registration registration, @NonNull h hVar, boolean z) {
        if (registration == null) {
            return false;
        }
        if (registration.contactKey() == null && z) {
            g.e(RegistrationManager.a, "You have delayRegistrationUntilContactKeyIsSet set to `true.`  The SDK will not send a registration to the Marketing Cloud until a contact key has been set.", new Object[0]);
            return false;
        }
        String string = hVar.e().getString(x, null);
        return string == null || !j.a(registration).equals(string);
    }

    void b(boolean z) {
        this.s = z;
        g();
    }

    private void a(@NonNull h hVar, @Nullable String str) {
        hVar.c().a(com.salesforce.marketingcloud.storage.b.d, str);
    }

    RegistrationManager.Editor a(f fVar) {
        return new d(fVar, this.v, this.t, this.f85n, this.f86o, this.d);
    }

    void c() {
        this.g.d(com.salesforce.marketingcloud.alarms.a.EnumC0062a.c);
        g();
    }

    private Registration a(int i) {
        return new Registration(i, UUID.randomUUID().toString(), this.v, this.m.f(), this.u, this.m.j(), this.m.e(), TimeZone.getDefault().inDaylightTime(new Date()), this.p, this.q, this.m.i(), f(), j.b(), this.t, this.m.h(), this.m.g(), this.e.applicationId(), Locale.getDefault().toString(), this.f86o, this.f85n);
    }

    void a(String str, String str2, Map<String, String> map, Collection<String> collection) throws Exception {
        a(str, str2, map, collection, false);
    }

    void a(String str, String str2, Map<String, String> map, Collection<String> collection, boolean z) throws Exception {
        this.v = str;
        this.t = str2;
        this.f85n.clear();
        this.f85n.putAll(map);
        this.f86o.clear();
        this.f86o.addAll(collection);
        this.g.c(com.salesforce.marketingcloud.alarms.a.EnumC0062a.c);
        c(z);
    }

    void a(boolean z) {
        MarketingCloudSdk.requestSdk(new a(z));
    }

    void a(@NonNull Registration registration, Map<String, List<String>> map) {
        com.salesforce.marketingcloud.http.b.a(map, this.f.c());
        this.g.c(com.salesforce.marketingcloud.alarms.a.EnumC0062a.c);
        synchronized (this.l) {
            for (RegistrationManager.RegistrationEventListener registrationEventListener : this.l) {
                if (registrationEventListener != null) {
                    try {
                        registrationEventListener.onRegistrationReceived(registration);
                    } catch (Exception e) {
                        g.b(RegistrationManager.a, e, "%s threw an exception while processing the registration response", registrationEventListener.getClass().getName());
                    }
                }
            }
        }
        this.f.c().a(com.salesforce.marketingcloud.storage.b.h, m.c(registration).toString());
        this.f.e().edit().putLong(y, System.currentTimeMillis()).putString(x, j.a(registration)).apply();
        this.i.b().execute(new b("delete_old_registrations", new Object[0]));
    }

    void a(int i, String str) {
        g.a(RegistrationManager.a, "%s: %s", Integer.valueOf(i), str);
        this.i.b().execute(new c("schedule_registration_retry", new Object[0]));
    }

    void a() {
        this.f.e().edit().remove(com.salesforce.marketingcloud.http.b.p.d + "_device").apply();
        a(false);
    }

    void a(String str) {
        if (TextUtils.isEmpty(str) || str.equals(this.u)) {
            return;
        }
        this.u = str;
        g();
    }
}
