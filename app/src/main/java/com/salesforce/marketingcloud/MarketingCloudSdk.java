package com.salesforce.marketingcloud;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.salesforce.marketingcloud.analytics.AnalyticsManager;
import com.salesforce.marketingcloud.events.EventManager;
import com.salesforce.marketingcloud.internal.n;
import com.salesforce.marketingcloud.legacycrypto.OldSdkHash;
import com.salesforce.marketingcloud.media.o;
import com.salesforce.marketingcloud.messages.RegionMessageManager;
import com.salesforce.marketingcloud.messages.iam.InAppMessageComponent;
import com.salesforce.marketingcloud.messages.iam.InAppMessageManager;
import com.salesforce.marketingcloud.messages.inbox.InboxMessageManager;
import com.salesforce.marketingcloud.messages.push.PushMessageManager;
import com.salesforce.marketingcloud.notifications.NotificationManager;
import com.salesforce.marketingcloud.registration.RegistrationManager;
import com.salesforce.marketingcloud.sfmcsdk.SFMCSdkComponents;
import com.salesforce.marketingcloud.sfmcsdk.components.identity.ModuleIdentity;
import com.salesforce.marketingcloud.sfmcsdk.modules.push.PushModuleInterface;
import com.salesforce.marketingcloud.util.AesCrypto;
import com.salesforce.marketingcloud.util.Crypto;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import kotlin.Deprecated;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class MarketingCloudSdk extends PushModuleInterface implements com.salesforce.marketingcloud.b.InterfaceC0069b {
    private static volatile boolean A = false;
    private static volatile boolean B = false;
    static final String t = "MarketingCloudPrefs";
    static final String u = "InitConfig";
    static MarketingCloudSdk y;
    private static Context z;
    private final MarketingCloudConfig a;
    private final List<d> b = new ArrayList();
    private final SFMCSdkComponents c;
    com.salesforce.marketingcloud.location.f d;
    com.salesforce.marketingcloud.behaviors.c e;
    private com.salesforce.marketingcloud.b f;
    private com.salesforce.marketingcloud.storage.h g;
    private com.salesforce.marketingcloud.http.e h;
    private com.salesforce.marketingcloud.messages.inbox.a i;
    private com.salesforce.marketingcloud.registration.d j;
    private com.salesforce.marketingcloud.notifications.a k;
    private com.salesforce.marketingcloud.messages.push.a l;
    private com.salesforce.marketingcloud.messages.d m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private com.salesforce.marketingcloud.events.c f27n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private AnalyticsManager f28o;
    private InitializationStatus p;
    private InAppMessageComponent q;
    private n r;
    private o s;
    static final String v = g.a("MarketingCloudSdk");
    private static final Object w = new Object();
    private static final List<c> x = new ArrayList();
    private static volatile boolean C = true;

    public interface InitializationListener {
        void complete(@NonNull InitializationStatus initializationStatus);
    }

    public interface WhenReadyListener {
        void ready(@NonNull MarketingCloudSdk marketingCloudSdk);
    }

    class a implements Runnable {
        final /* synthetic */ Context b;
        final /* synthetic */ MarketingCloudConfig c;
        final /* synthetic */ SFMCSdkComponents d;
        final /* synthetic */ InitializationListener e;

        a(Context context, MarketingCloudConfig marketingCloudConfig, SFMCSdkComponents sFMCSdkComponents, InitializationListener initializationListener) {
            this.b = context;
            this.c = marketingCloudConfig;
            this.d = sFMCSdkComponents;
            this.e = initializationListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            String name = Thread.currentThread().getName();
            Thread.currentThread().setName("SFMC_init");
            try {
                g.d(MarketingCloudSdk.v, "Starting init thread", new Object[0]);
                MarketingCloudSdk.a(this.b, this.c, this.d, this.e);
                Thread.currentThread().setName(name);
            } finally {
                Thread.currentThread().setName(name);
                g.d(MarketingCloudSdk.v, "~~ MarketingCloudSdk v%s init complete ~~", MarketingCloudSdk.getSdkVersionName());
            }
        }
    }

    class b extends c {
        b(Looper looper, WhenReadyListener whenReadyListener) {
            super(looper, whenReadyListener);
        }

        @Override // com.salesforce.marketingcloud.MarketingCloudSdk.c
        protected void a(WhenReadyListener whenReadyListener) {
            if (whenReadyListener != null) {
                try {
                    whenReadyListener.ready(MarketingCloudSdk.y);
                } catch (Exception e) {
                    g.b(MarketingCloudSdk.v, e, "Error occurred in %s", whenReadyListener.getClass().getName());
                }
            }
        }
    }

    static abstract class c {
        private final Handler a;
        WhenReadyListener b;
        volatile boolean c;
        private final Runnable d = new a();
        private volatile boolean e;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.this) {
                    if (c.this.c) {
                        return;
                    }
                    c cVar = c.this;
                    cVar.a(cVar.b);
                    c.this.c = true;
                }
            }
        }

        c(Looper looper, WhenReadyListener whenReadyListener) {
            looper = looper == null ? Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper() : looper;
            this.b = whenReadyListener;
            this.a = new Handler(looper);
        }

        public void a() {
            synchronized (this) {
                if (!this.c && !this.e) {
                    this.e = true;
                    this.a.post(this.d);
                }
            }
        }

        protected abstract void a(WhenReadyListener whenReadyListener);
    }

    private MarketingCloudSdk(@NonNull MarketingCloudConfig marketingCloudConfig, @Nullable SFMCSdkComponents sFMCSdkComponents) {
        this.a = marketingCloudConfig;
        this.c = sFMCSdkComponents;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00a8 A[Catch: all -> 0x00b0, TryCatch #1 {, blocks: (B:4:0x000e, B:6:0x0012, B:7:0x001b, B:9:0x0026, B:11:0x0031, B:13:0x004c, B:14:0x005a, B:31:0x00a1, B:33:0x00a8, B:34:0x00ab, B:26:0x0092, B:27:0x0093, B:28:0x009c, B:38:0x00af, B:15:0x005b, B:17:0x0075, B:18:0x0079, B:20:0x007f, B:21:0x0089, B:22:0x008e, B:29:0x009d, B:30:0x00a0), top: B:44:0x000e, inners: #0, #2 }] */
    static void a(@NonNull Context context, @NonNull MarketingCloudConfig marketingCloudConfig, @Nullable SFMCSdkComponents sFMCSdkComponents, @Nullable InitializationListener initializationListener) {
        String registrationId;
        boolean encryptionChanged;
        String str = v;
        g.d(str, "executeInit %s", marketingCloudConfig);
        synchronized (w) {
            MarketingCloudSdk marketingCloudSdk = y;
            if (marketingCloudSdk != null) {
                marketingCloudSdk.b(com.salesforce.marketingcloud.internal.g.a(marketingCloudConfig, marketingCloudSdk.a));
            }
            y = new MarketingCloudSdk(marketingCloudConfig, sFMCSdkComponents);
            if (sFMCSdkComponents != null) {
                registrationId = sFMCSdkComponents.getRegistrationId();
                encryptionChanged = sFMCSdkComponents.getEncryptionChanged();
            } else {
                registrationId = null;
                encryptionChanged = false;
            }
            InitializationStatus initializationStatusA = y.a(registrationId, marketingCloudConfig, encryptionChanged);
            g.a(str, "MarketingCloudSdk init finished with status: %s", initializationStatusA);
            B = initializationStatusA.isUsable();
            A = false;
            if (B) {
                y.a(initializationStatusA);
                MarketingCloudSdk marketingCloudSdk2 = y;
                marketingCloudSdk2.f.a(marketingCloudSdk2);
                List<c> list = x;
                synchronized (list) {
                    C = false;
                    g.d(str, "Delivering queued SDK requests to %s listeners", Integer.valueOf(list.size()));
                    if (!list.isEmpty()) {
                        Iterator<c> it2 = list.iterator();
                        while (it2.hasNext()) {
                            it2.next().a();
                        }
                        x.clear();
                    }
                }
                w.notifyAll();
                if (initializationListener != null) {
                    initializationListener.complete(initializationStatusA);
                }
            } else {
                y.a(false);
                y = null;
                List<c> list2 = x;
                synchronized (list2) {
                    list2.clear();
                }
                w.notifyAll();
                if (initializationListener != null) {
                    initializationListener.complete(initializationStatusA);
                }
            }
        }
    }

    static void b(@NonNull Context context, @NonNull MarketingCloudConfig marketingCloudConfig, @Nullable SFMCSdkComponents sFMCSdkComponents, @Nullable InitializationListener initializationListener) {
        MarketingCloudSdk marketingCloudSdk;
        String str = v;
        g.d(str, "~~ MarketingCloudSdk v%s init() ~~", getSdkVersionName());
        com.salesforce.marketingcloud.util.g.a(context, "Context cannot be null.");
        com.salesforce.marketingcloud.util.g.a(marketingCloudConfig, "Config cannot be null.");
        com.salesforce.marketingcloud.internal.f.a(marketingCloudConfig.applicationId(), marketingCloudConfig.accessToken(), marketingCloudConfig.senderId());
        synchronized (w) {
            if ((B || A) && (marketingCloudSdk = y) != null && marketingCloudConfig.equals(marketingCloudSdk.a)) {
                g.d(str, "MarketingCloudSdk is already %s", B ? "initialized" : "initializing");
                if (isReady() && initializationListener != null) {
                    initializationListener.complete(y.p);
                }
                return;
            }
            g.d(str, "Starting initialization", new Object[0]);
            B = false;
            A = true;
            C = true;
            z = context.getApplicationContext();
            new Thread(new a(context, marketingCloudConfig, sFMCSdkComponents, initializationListener)).start();
        }
    }

    static void c() {
        MarketingCloudSdk marketingCloudSdk = y;
        if (marketingCloudSdk != null) {
            marketingCloudSdk.a(false);
        }
        y = null;
    }

    public static MarketingCloudSdk getInstance() {
        if (!A && !B) {
            throw new IllegalStateException("MarketingCloudSdk#init must be called before calling MarketingCloudSdk#getInstance.");
        }
        synchronized (w) {
            if (B) {
                return y;
            }
            boolean z2 = false;
            while (!B && A) {
                try {
                    try {
                        w.wait(0L);
                    } catch (InterruptedException unused) {
                        z2 = true;
                    }
                } catch (Throwable th) {
                    if (z2) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            }
            MarketingCloudSdk marketingCloudSdk = y;
            if (z2) {
                Thread.currentThread().interrupt();
            }
            return marketingCloudSdk;
        }
    }

    @MCLogListener.LogLevel
    public static int getLogLevel() {
        return com.salesforce.marketingcloud.internal.f.a();
    }

    public static int getSdkVersionCode() {
        return com.salesforce.marketingcloud.a.e;
    }

    public static String getSdkVersionName() {
        return com.salesforce.marketingcloud.a.f;
    }

    @Deprecated(message = "Initialize the SDK with SFMCSdk.configure()")
    public static void init(@NonNull Context context, @NonNull MarketingCloudConfig marketingCloudConfig, @Nullable InitializationListener initializationListener) {
        b(context, marketingCloudConfig, null, initializationListener);
    }

    public static boolean isInitializing() {
        return A;
    }

    public static boolean isReady() {
        return B && y != null;
    }

    public static void requestSdk(@NonNull WhenReadyListener whenReadyListener) {
        requestSdk(null, whenReadyListener);
    }

    public static void setLogLevel(@MCLogListener.LogLevel int i) {
        com.salesforce.marketingcloud.internal.f.a(i);
    }

    public static void setLogListener(@Nullable MCLogListener mCLogListener) {
        com.salesforce.marketingcloud.internal.f.a(mCLogListener);
    }

    public static void unregisterWhenReadyListener(@NonNull WhenReadyListener whenReadyListener) {
        if (whenReadyListener == null) {
            return;
        }
        List<c> list = x;
        synchronized (list) {
            Iterator<c> it2 = list.iterator();
            while (it2.hasNext()) {
                if (whenReadyListener == it2.next().b) {
                    it2.remove();
                }
            }
        }
    }

    @Override // com.salesforce.marketingcloud.sfmcsdk.modules.push.PushModuleInterface
    public AnalyticsManager getAnalyticsManager() {
        return this.f28o;
    }

    @Override // com.salesforce.marketingcloud.sfmcsdk.modules.push.PushModuleInterface
    public EventManager getEventManager() {
        return this.f27n;
    }

    @Override // com.salesforce.marketingcloud.sfmcsdk.modules.push.PushModuleInterface
    public InAppMessageManager getInAppMessageManager() {
        return this.q;
    }

    @Override // com.salesforce.marketingcloud.sfmcsdk.modules.push.PushModuleInterface
    public InboxMessageManager getInboxMessageManager() {
        return this.i;
    }

    @Override // com.salesforce.marketingcloud.sfmcsdk.modules.push.PushModuleInterface
    public InitializationStatus getInitializationStatus() {
        return this.p;
    }

    public MarketingCloudConfig getMarketingCloudConfig() {
        return this.a;
    }

    @Override // com.salesforce.marketingcloud.sfmcsdk.modules.ModuleInterface
    public ModuleIdentity getModuleIdentity() {
        return i.a(this.a.applicationId(), getRegistrationManager());
    }

    @Override // com.salesforce.marketingcloud.sfmcsdk.modules.push.PushModuleInterface
    public NotificationManager getNotificationManager() {
        return this.k;
    }

    @Override // com.salesforce.marketingcloud.sfmcsdk.modules.push.PushModuleInterface
    public PushMessageManager getPushMessageManager() {
        return this.l;
    }

    @Override // com.salesforce.marketingcloud.sfmcsdk.modules.push.PushModuleInterface
    public RegionMessageManager getRegionMessageManager() {
        return this.m;
    }

    @Override // com.salesforce.marketingcloud.sfmcsdk.modules.push.PushModuleInterface
    public RegistrationManager getRegistrationManager() {
        return this.j;
    }

    public JSONObject getSdkState() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("initConfig", this.a.toString());
            jSONObject.put("initStatus", this.p.toString());
            for (d dVar : this.b) {
                if (dVar != null) {
                    try {
                        jSONObject.put(dVar.componentName(), dVar.componentState());
                    } catch (Exception e) {
                        g.b(v, e, "Failed to create component state for %s", dVar);
                    }
                }
            }
        } catch (Exception e2) {
            g.b(v, e2, "Unable to create Sdk state json", new Object[0]);
        }
        return jSONObject;
    }

    @Override // com.salesforce.marketingcloud.sfmcsdk.modules.ModuleInterface
    public JSONObject getState() {
        return getSdkState();
    }

    public static void requestSdk(@Nullable Looper looper, @NonNull WhenReadyListener whenReadyListener) {
        b bVar = new b(looper, whenReadyListener);
        List<c> list = x;
        synchronized (list) {
            if (C) {
                list.add(bVar);
            } else {
                bVar.a();
            }
        }
    }

    private void b(boolean z2) {
        for (int size = this.b.size() - 1; size >= 0; size--) {
            try {
                this.b.get(size).tearDown(z2);
            } catch (Exception e) {
                g.b(v, e, "Error encountered tearing down component.", new Object[0]);
            }
        }
        this.b.clear();
        n nVar = this.r;
        if (nVar != null) {
            nVar.c();
        }
        com.salesforce.marketingcloud.storage.h hVar = this.g;
        if (hVar != null) {
            try {
                hVar.s();
            } catch (Exception e2) {
                g.b(v, e2, "Error encountered tearing down storage.", new Object[0]);
            }
            this.g = null;
        }
        List<c> list = x;
        synchronized (list) {
            list.clear();
        }
        B = false;
        C = true;
    }

    private void a(boolean z2) {
        b(z2);
        A = false;
    }

    private InitializationStatus a(@Nullable String str, @NonNull MarketingCloudConfig marketingCloudConfig, boolean z2) {
        int i;
        InitializationStatus.a aVar;
        Crypto cryptoA;
        if (com.salesforce.marketingcloud.util.a.a()) {
            return com.salesforce.marketingcloud.internal.e.a();
        }
        InitializationStatus.a aVarB = com.salesforce.marketingcloud.internal.e.b();
        try {
            String strA = com.salesforce.marketingcloud.util.c.a(z, str);
            if (z2 || marketingCloudConfig.legacyEncryptionDependencyForciblyRemoved()) {
                cryptoA = null;
            } else {
                cryptoA = a(marketingCloudConfig, strA);
                if (cryptoA == null) {
                    return com.salesforce.marketingcloud.internal.e.c();
                }
            }
            Crypto crypto = cryptoA;
            try {
                this.r = new n();
                com.salesforce.marketingcloud.storage.h hVar = new com.salesforce.marketingcloud.storage.h(z, new com.salesforce.marketingcloud.util.h(this.c.getEncryptionManager()), marketingCloudConfig.applicationId(), marketingCloudConfig.accessToken(), this.r, crypto, z2);
                this.g = hVar;
                hVar.a(aVarB);
            } catch (Throwable th) {
                g.a(v, th, "Unable to initialize SDK storage.", new Object[0]);
                aVarB.a(th);
            }
            if (!aVarB.b()) {
                com.salesforce.marketingcloud.registration.d.a(marketingCloudConfig, z, strA, str);
                return aVarB.a();
            }
            this.e = new com.salesforce.marketingcloud.behaviors.c(z, Executors.newSingleThreadExecutor());
            this.h = new com.salesforce.marketingcloud.http.e(z, this.g.e(), this.r);
            com.salesforce.marketingcloud.alarms.b bVar = new com.salesforce.marketingcloud.alarms.b(z, this.g, this.e);
            com.salesforce.marketingcloud.analytics.h hVar2 = new com.salesforce.marketingcloud.analytics.h(marketingCloudConfig, this.g, strA, bVar, this.e, this.h, this.r);
            this.f28o = hVar2;
            try {
                k kVar = new k(strA, marketingCloudConfig, this.g, this.h, this.e, bVar, this.r, hVar2);
                this.f = new com.salesforce.marketingcloud.b(kVar, this.g.j());
                this.d = com.salesforce.marketingcloud.location.f.a(z, marketingCloudConfig);
                com.salesforce.marketingcloud.proximity.e eVarA = com.salesforce.marketingcloud.proximity.e.a(z, marketingCloudConfig);
                this.k = com.salesforce.marketingcloud.notifications.a.a(z, this.g, marketingCloudConfig.notificationCustomizationOptions(), hVar2);
                try {
                    this.i = new com.salesforce.marketingcloud.messages.inbox.a(marketingCloudConfig, this.g, strA, this.e, bVar, this.h, this.r, hVar2);
                    InitializationStatus.a aVar2 = aVarB;
                    try {
                        this.m = new com.salesforce.marketingcloud.messages.d(z, marketingCloudConfig, this.g, strA, this.d, eVarA, this.e, bVar, this.h, this.k, this.r, hVar2);
                        this.s = o.a(z, this.g);
                        this.l = new com.salesforce.marketingcloud.messages.push.a(z, this.g, this.k, bVar, marketingCloudConfig.senderId(), hVar2, this.s, this.r);
                        com.salesforce.marketingcloud.registration.f fVar = new com.salesforce.marketingcloud.registration.f(strA, marketingCloudConfig.applicationId(), com.salesforce.marketingcloud.util.f.a(z));
                        this.j = new com.salesforce.marketingcloud.registration.d(z, marketingCloudConfig, this.g, fVar, this.e, bVar, this.h, this.l, this.r, this.c);
                        com.salesforce.marketingcloud.config.a aVar3 = new com.salesforce.marketingcloud.config.a(kVar, this.g, hVar2);
                        this.q = new InAppMessageComponent(z, this.g, bVar, kVar, this.e, this.s, marketingCloudConfig.urlHandler(), this.r, hVar2, this.c, aVar3);
                        this.f27n = new com.salesforce.marketingcloud.events.c(z, fVar, this.g, kVar, this.e, hVar2, this.r, this.c, aVar3, this.q);
                        this.b.add(this.e);
                        this.b.add(com.salesforce.marketingcloud.behaviors.d.a((Application) z.getApplicationContext()));
                        this.b.add(this.h);
                        this.b.add(bVar);
                        this.b.add(hVar2);
                        this.b.add(kVar);
                        this.b.add(this.f);
                        this.b.add(this.d);
                        this.b.add(eVarA);
                        this.b.add(this.i);
                        this.b.add(this.k);
                        this.b.add(this.m);
                        this.b.add(this.l);
                        this.b.add(this.j);
                        this.b.add(aVar3);
                        this.b.add(this.q);
                        this.b.add(this.f27n);
                        int iA = this.f.a();
                        String str2 = v;
                        Object[] objArr = new Object[1];
                        i = 0;
                        try {
                            objArr[0] = Integer.valueOf(iA);
                            g.d(str2, "Initializing all components with control channel flag [%d]", objArr);
                            for (d dVar : this.b) {
                                g.d(v, "init called for %s", dVar.componentName());
                                if (dVar instanceof e) {
                                    aVar = aVar2;
                                    try {
                                        ((e) dVar).init(aVar, iA);
                                    } catch (Exception e) {
                                        e = e;
                                        aVar.a(e);
                                        g.b(v, e, "Something wrong with internal init", new Object[i]);
                                        return aVar.a();
                                    }
                                } else {
                                    aVar = aVar2;
                                    if (dVar instanceof f) {
                                        ((f) dVar).a(aVar);
                                    }
                                }
                                aVar.a(dVar);
                                aVar2 = aVar;
                            }
                            aVar = aVar2;
                        } catch (Exception e2) {
                            e = e2;
                            aVar = aVar2;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        aVar = aVar2;
                        i = 0;
                        aVar.a(e);
                        g.b(v, e, "Something wrong with internal init", new Object[i]);
                        return aVar.a();
                    }
                } catch (Exception e4) {
                    e = e4;
                    aVar = aVarB;
                }
            } catch (Exception e5) {
                e = e5;
                i = 0;
                aVar = aVarB;
            }
            return aVar.a();
        } catch (Exception e6) {
            e = e6;
            i = 0;
            aVar = aVarB;
        }
    }

    public com.salesforce.marketingcloud.storage.h b() {
        return this.g;
    }

    private Crypto a(@NonNull MarketingCloudConfig marketingCloudConfig, @NonNull String str) {
        try {
            g.c(v, "Checking for legacy hashing dependency", new Object[0]);
            return new AesCrypto(z, marketingCloudConfig.applicationId(), marketingCloudConfig.accessToken(), str, new OldSdkHash());
        } catch (Error e) {
            g.b(v, "Legacy hashing is not available", e);
            return null;
        }
    }

    private void a(InitializationStatus initializationStatus) {
        this.p = initializationStatus;
    }

    public com.salesforce.marketingcloud.http.e a() {
        return this.h;
    }

    @Override // com.salesforce.marketingcloud.b.InterfaceC0069b
    public void a(int i) {
        for (int size = this.b.size() - 1; size >= 0; size--) {
            try {
                d dVar = this.b.get(size);
                if (dVar instanceof e) {
                    ((e) dVar).controlChannelInit(i);
                }
            } catch (Exception e) {
                g.b(v, e, "Error encountered during control channel init.", new Object[0]);
            }
        }
    }
}
