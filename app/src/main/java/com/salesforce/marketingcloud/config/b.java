package com.salesforce.marketingcloud.config;

import android.net.Uri;
import com.google.firebase.sessions.settings.RemoteSettings;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static final a d = new a(null);
    private final String a;
    private final String b;
    private final Integer c;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final b a(@NotNull String endpointIn) {
            Intrinsics.checkNotNullParameter(endpointIn, "endpointIn");
            return a(this, endpointIn, null, null, 6, null);
        }

        private a() {
        }

        public final b a(@NotNull String endpointIn, @Nullable String str) {
            Intrinsics.checkNotNullParameter(endpointIn, "endpointIn");
            return a(this, endpointIn, str, null, 4, null);
        }

        public static /* synthetic */ b a(a aVar, String str, String str2, Integer num, int i, Object obj) {
            if ((i & 2) != 0) {
                str2 = null;
            }
            if ((i & 4) != 0) {
                num = null;
            }
            return aVar.a(str, str2, num);
        }

        public final b a(@NotNull String endpointIn, @Nullable String str, @Nullable Integer num) {
            String string;
            Intrinsics.checkNotNullParameter(endpointIn, "endpointIn");
            String string2 = StringsKt__StringsKt.trim((CharSequence) endpointIn).toString();
            if (string2.length() != 0 && ArraysKt___ArraysKt.contains(EnumC0072b.values(), EnumC0072b.valueOf(string2))) {
                DefaultConstructorMarker defaultConstructorMarker = null;
                if (str == null || (string = StringsKt__StringsKt.trim((CharSequence) str).toString()) == null) {
                    string = null;
                } else if (string.length() == 0 || !StringsKt__StringsJVMKt.startsWith$default(string, RemoteSettings.FORWARD_SLASH_STRING, false, 2, null) || !Intrinsics.areEqual(string, Uri.parse(string).getPath())) {
                    throw new IllegalArgumentException("Invalid 'path' for " + string2 + " endpoint config.");
                }
                if (num != null && !new IntRange(10, Integer.MAX_VALUE).contains(num.intValue())) {
                    throw new IllegalArgumentException("Invalid 'maxBatchSize' for " + string2 + " endpoint config.");
                }
                if (string == null && num == null) {
                    throw new IllegalArgumentException("Empty endpoint config for " + string2 + " is pointless.");
                }
                return new b(string2, string, num, defaultConstructorMarker);
            }
            throw new IllegalArgumentException("Invalid 'endpoint' for endpoint config.");
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.config.b$b, reason: collision with other inner class name */
    public enum EnumC0072b {
        EVENTS;

        private static final /* synthetic */ EnumEntries d = EnumEntriesKt.enumEntries(a());

        public static EnumEntries<EnumC0072b> b() {
            return d;
        }
    }

    public /* synthetic */ b(String str, String str2, Integer num, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, num);
    }

    public final String a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public final Integer c() {
        return this.c;
    }

    public final String d() {
        return this.a;
    }

    public final Integer e() {
        return this.c;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Intrinsics.areEqual(this.a, bVar.a) && Intrinsics.areEqual(this.b, bVar.b) && Intrinsics.areEqual(this.c, bVar.c);
    }

    public final String f() {
        return this.b;
    }

    public int hashCode() {
        int iHashCode = this.a.hashCode();
        String str = this.b;
        int iHashCode2 = str == null ? 0 : str.hashCode();
        Integer num = this.c;
        return (((iHashCode * 31) + iHashCode2) * 31) + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "EndpointConfig(endpoint=" + this.a + ", path=" + this.b + ", maxBatchSize=" + this.c + ")";
    }

    private b(String str, String str2, Integer num) {
        this.a = str;
        this.b = str2;
        this.c = num;
    }

    public final b a(@NotNull String endpoint, @Nullable String str, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(endpoint, "endpoint");
        return new b(endpoint, str, num);
    }

    public static /* synthetic */ b a(b bVar, String str, String str2, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bVar.a;
        }
        if ((i & 2) != 0) {
            str2 = bVar.b;
        }
        if ((i & 4) != 0) {
            num = bVar.c;
        }
        return bVar.a(str, str2, num);
    }

    /* synthetic */ b(String str, String str2, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : num);
    }
}
