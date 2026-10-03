package com.salesforce.marketingcloud;

import androidx.annotation.NonNull;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b implements d, k.f {
    public static final int i = 0;
    public static final int j = 1;
    public static final int k = 2;
    public static final int l = 4;
    public static final int m = 8;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f45n = 16;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f46o = 32;
    public static final int p = 64;
    public static final int q = 128;
    public static final int r = 256;
    public static final int s = 512;
    public static final int t = 1024;
    public static final int u = 2048;
    public static final int v = 4096;
    private static final int w = 1;
    private final com.salesforce.marketingcloud.storage.d d;
    private final k e;
    private InterfaceC0069b f;
    private c g;
    private c h;

    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.b$b, reason: collision with other inner class name */
    interface InterfaceC0069b {
        void a(int i);
    }

    /* JADX INFO: loaded from: classes3.dex */
    public enum c {
        RTBF(8191),
        ROP(8190),
        DNT(1888),
        NONE(0),
        NO_BEACON(64),
        NO_GEOFENCE(32),
        NO_LOCATION(96);

        public final int b;

        c(int i) {
            this.b = i;
        }

        public static c a(String str) {
            try {
                return valueOf(str);
            } catch (Exception unused) {
                return NONE;
            }
        }
    }

    b(k kVar, com.salesforce.marketingcloud.storage.d dVar) {
        this.e = kVar;
        this.d = dVar;
        c cVarB = b(dVar);
        this.h = cVarB;
        if (cVarB != c.RTBF) {
            kVar.a(k.e.blocked, this);
        }
    }

    public static boolean a(int i2, int i3) {
        return (i2 & i3) == i3;
    }

    public static boolean b(int i2, int i3) {
        return !a(i2, i3);
    }

    public static boolean c(int i2, int i3) {
        if (b(i2, i3)) {
            return false;
        }
        switch (i3) {
            case 2:
            case 256:
            case 512:
            case 2048:
                if (c.ROP.b == i2) {
                    return false;
                }
            case 4:
            case 8:
            case 16:
            case 32:
            case 64:
            case 128:
            case 4096:
                return true;
            default:
                return false;
        }
    }

    @Override // com.salesforce.marketingcloud.d
    public String componentName() {
        return "ControlChannel";
    }

    @Override // com.salesforce.marketingcloud.d
    public JSONObject componentState() {
        try {
            return new JSONObject().put("flag", this.h.name());
        } catch (JSONException unused) {
            return null;
        }
    }

    @Override // com.salesforce.marketingcloud.k.f
    public void onSyncReceived(@NonNull k.e eVar, @NonNull JSONObject jSONObject) {
        if (eVar == k.e.blocked && jSONObject.optInt("version", -1) == 1) {
            try {
                a(jSONObject.getJSONObject("items").getInt("blocked"));
            } catch (JSONException e) {
                g.b(MarketingCloudSdk.v, e, "Failed to parse [blocked] sync data.", new Object[0]);
            }
        }
    }

    @Override // com.salesforce.marketingcloud.d
    public void tearDown(boolean z) {
        this.e.a(k.e.blocked, (k.f) null);
        this.f = null;
    }

    public static int a(@NonNull com.salesforce.marketingcloud.storage.d dVar) {
        return b(dVar).b;
    }

    private static c b(@NonNull com.salesforce.marketingcloud.storage.d dVar) {
        String strA = dVar.a((String) null);
        return strA != null ? c.a(strA) : c.NONE;
    }

    int a() {
        return this.h.b;
    }

    void a(InterfaceC0069b interfaceC0069b) {
        c cVar;
        synchronized (this) {
            this.f = interfaceC0069b;
            if (interfaceC0069b != null && (cVar = this.g) != null) {
                this.h = cVar;
                this.g = null;
                interfaceC0069b.a(cVar.b);
            }
        }
    }

    private void a(int i2) {
        synchronized (this) {
            c cVar = c.RTBF;
            if (!a(i2, cVar.b)) {
                cVar = c.ROP;
                if (!a(i2, cVar.b)) {
                    cVar = c.DNT;
                    if (!a(i2, cVar.b)) {
                        cVar = c.NONE;
                    }
                }
            }
            g.d(MarketingCloudSdk.v, "Control Channel blocked value %d received", Integer.valueOf(i2));
            this.d.b(cVar.name());
            if (cVar != this.h) {
                InterfaceC0069b interfaceC0069b = this.f;
                if (interfaceC0069b != null) {
                    this.h = cVar;
                    interfaceC0069b.a(cVar.b);
                } else {
                    this.g = cVar;
                }
            }
        }
    }
}
