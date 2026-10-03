package com.salesforce.marketingcloud.http;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.ResponseTypeValues;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements Parcelable, g {
    private final int b;
    private final String c;
    private final String d;
    private final long e;
    private final long f;
    private final Map<String, List<String>> g;
    public static final b h = new b(null);
    public static final Parcelable.Creator<f> CREATOR = new c();

    public static final class a {
        private int a;
        private String b;
        private String c;
        private long d;
        private long e;
        private Map<String, ? extends List<String>> f;

        public final a a(int i) {
            this.a = i;
            return this;
        }

        public final a b(@Nullable String str) {
            this.c = str;
            return this;
        }

        public final a a(@Nullable String str) {
            this.b = str;
            return this;
        }

        public final a b(long j) {
            this.d = j;
            return this;
        }

        public final a a(long j) {
            this.e = j;
            return this;
        }

        public final a a(@Nullable Map<String, ? extends List<String>> map) {
            this.f = map;
            return this;
        }

        public final f a() {
            int i = this.a;
            String str = this.b;
            String str2 = this.c;
            long j = this.d;
            long j2 = this.e;
            Map<String, ? extends List<String>> mapEmptyMap = this.f;
            if (mapEmptyMap == null) {
                mapEmptyMap = MapsKt__MapsKt.emptyMap();
            }
            return new f(i, str, str2, j, j2, mapEmptyMap);
        }
    }

    public static final class b {
        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final a a() {
            return new a();
        }

        private b() {
        }

        @JvmStatic
        public final f a(@NotNull String message, int i) {
            Intrinsics.checkNotNullParameter(message, "message");
            long jCurrentTimeMillis = System.currentTimeMillis();
            return a().a(i).b(message).b(jCurrentTimeMillis).a(jCurrentTimeMillis).a();
        }
    }

    public static final class c implements Parcelable.Creator<f> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final f createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int i = parcel.readInt();
            String string = parcel.readString();
            String string2 = parcel.readString();
            long j = parcel.readLong();
            long j2 = parcel.readLong();
            int i2 = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(i2);
            for (int i3 = 0; i3 != i2; i3++) {
                linkedHashMap.put(parcel.readString(), parcel.createStringArrayList());
            }
            return new f(i, string, string2, j, j2, linkedHashMap);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final f[] newArray(int i) {
            return new f[i];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(int i, @Nullable String str, @Nullable String str2, long j, long j2, @NotNull Map<String, ? extends List<String>> headers) {
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.b = i;
        this.c = str;
        this.d = str2;
        this.e = j;
        this.f = j2;
        this.g = headers;
    }

    @JvmStatic
    public static final f a(@NotNull String str, int i) {
        return h.a(str, i);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.salesforce.marketingcloud.http.g
    public Bundle h() {
        Bundle bundle = new Bundle();
        bundle.putInt(ResponseTypeValues.CODE, this.b);
        bundle.putString("body", this.c);
        bundle.putString("message", this.d);
        bundle.putLong("startTimeMillis", this.e);
        bundle.putLong("endTimeMillis", this.f);
        bundle.putString("headers", this.g.toString());
        return bundle;
    }

    public final String j() {
        return this.c;
    }

    public final int k() {
        return this.b;
    }

    public final long l() {
        return this.f;
    }

    public final Map<String, List<String>> m() {
        return this.g;
    }

    public final String n() {
        return this.d;
    }

    public final long o() {
        return this.e;
    }

    public final boolean p() {
        int i = this.b;
        return 200 <= i && i < 300;
    }

    public final long q() {
        return this.f - this.e;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeInt(this.b);
        out.writeString(this.c);
        out.writeString(this.d);
        out.writeLong(this.e);
        out.writeLong(this.f);
        Map<String, List<String>> map = this.g;
        out.writeInt(map.size());
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            out.writeString(entry.getKey());
            out.writeStringList(entry.getValue());
        }
    }
}
