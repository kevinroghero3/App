package com.salesforce.marketingcloud.internal;

import com.salesforce.marketingcloud.registration.Registration;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class m {
    public static final a a = new a(null);

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final Registration a(@NotNull JSONObject json) {
            Intrinsics.checkNotNullParameter(json, "json");
            return new Registration(json);
        }

        @JvmStatic
        public final int b(@NotNull Registration registration) {
            Intrinsics.checkNotNullParameter(registration, "registration");
            return registration.getId$sdk_release();
        }

        @JvmStatic
        public final JSONObject c(@NotNull Registration registration) {
            Intrinsics.checkNotNullParameter(registration, "registration");
            return registration.toJson$sdk_release();
        }

        @JvmStatic
        public final String d(@NotNull Registration registration) {
            Intrinsics.checkNotNullParameter(registration, "registration");
            return registration.getUuid$sdk_release();
        }

        private a() {
        }

        @JvmStatic
        public final void a(@NotNull Registration registration, int i) {
            Intrinsics.checkNotNullParameter(registration, "registration");
            registration.setId$sdk_release(i);
        }

        @JvmStatic
        public final String a(@NotNull Registration registration) {
            Intrinsics.checkNotNullParameter(registration, "registration");
            String string = registration.copy((1048573 & 1) != 0 ? registration.id : 0, (1048573 & 2) != 0 ? registration.uuid : "", (1048573 & 4) != 0 ? registration.signedString : null, (1048573 & 8) != 0 ? registration.deviceId : null, (1048573 & 16) != 0 ? registration.systemToken : null, (1048573 & 32) != 0 ? registration.sdkVersion : null, (1048573 & 64) != 0 ? registration.appVersion : null, (1048573 & 128) != 0 ? registration.dst : false, (1048573 & 256) != 0 ? registration.locationEnabled : false, (1048573 & 512) != 0 ? registration.proximityEnabled : false, (1048573 & 1024) != 0 ? registration.platformVersion : null, (1048573 & 2048) != 0 ? registration.pushEnabled : false, (1048573 & 4096) != 0 ? registration.timeZone : 0, (1048573 & 8192) != 0 ? registration.contactKey : null, (1048573 & 16384) != 0 ? registration.platform : null, (1048573 & 32768) != 0 ? registration.hwid : null, (1048573 & 65536) != 0 ? registration.appId : null, (1048573 & 131072) != 0 ? registration.locale : null, (1048573 & 262144) != 0 ? registration.tags : null, (1048573 & 524288) != 0 ? registration.attributes : null).toJson$sdk_release().toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }
    }

    @JvmStatic
    public static final Registration a(@NotNull JSONObject jSONObject) {
        return a.a(jSONObject);
    }

    @JvmStatic
    public static final int b(@NotNull Registration registration) {
        return a.b(registration);
    }

    @JvmStatic
    public static final JSONObject c(@NotNull Registration registration) {
        return a.c(registration);
    }

    @JvmStatic
    public static final String d(@NotNull Registration registration) {
        return a.d(registration);
    }

    @JvmStatic
    public static final String a(@NotNull Registration registration) {
        return a.a(registration);
    }

    @JvmStatic
    public static final void a(@NotNull Registration registration, int i) {
        a.a(registration, i);
    }
}
