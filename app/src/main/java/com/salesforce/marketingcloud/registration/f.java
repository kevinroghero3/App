package com.salesforce.marketingcloud.registration;

import android.os.Build;
import com.salesforce.marketingcloud.MarketingCloudSdk;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class f {
    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;

    public f(@NotNull String deviceId, @NotNull String appId, @NotNull String appVersion) {
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        this.a = deviceId;
        this.b = appId;
        this.c = appVersion;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.ENGLISH, "%s %s", Arrays.copyOf(new Object[]{Build.MANUFACTURER, Build.MODEL}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        this.d = str;
        this.e = "Android";
        String str2 = Build.VERSION.RELEASE;
        this.f = str2 == null ? "Unknown Release" : str2;
        String sdkVersionName = MarketingCloudSdk.getSdkVersionName();
        Intrinsics.checkNotNullExpressionValue(sdkVersionName, "getSdkVersionName(...)");
        this.g = sdkVersionName;
    }

    public final String a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return this.c;
    }

    public final String d() {
        return this.b;
    }

    public final String e() {
        return this.c;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return Intrinsics.areEqual(this.a, fVar.a) && Intrinsics.areEqual(this.b, fVar.b) && Intrinsics.areEqual(this.c, fVar.c);
    }

    public final String f() {
        return this.a;
    }

    public final String g() {
        return this.d;
    }

    public final String h() {
        return this.e;
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public final String i() {
        return this.f;
    }

    public final String j() {
        return this.g;
    }

    public String toString() {
        return "RegistrationMeta(deviceId=" + this.a + ", appId=" + this.b + ", appVersion=" + this.c + ")";
    }

    public final f a(@NotNull String deviceId, @NotNull String appId, @NotNull String appVersion) {
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        return new f(deviceId, appId, appVersion);
    }

    public static /* synthetic */ f a(f fVar, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = fVar.a;
        }
        if ((i & 2) != 0) {
            str2 = fVar.b;
        }
        if ((i & 4) != 0) {
            str3 = fVar.c;
        }
        return fVar.a(str, str2, str3);
    }
}
