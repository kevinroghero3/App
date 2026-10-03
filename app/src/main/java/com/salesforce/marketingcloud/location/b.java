package com.salesforce.marketingcloud.location;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static final a f = new a(null);
    public static final int g = 1;
    public static final int h = 2;
    public static final int i = 4;
    private final String a;
    private final float b;
    private final double c;
    private final double d;
    private final int e;

    /* JADX INFO: loaded from: classes3.dex */
    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.location.b$b, reason: collision with other inner class name */
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface InterfaceC0081b {
    }

    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface c {
    }

    public b(@NotNull String id, float f2, double d, double d2, int i2) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.a = id;
        this.b = f2;
        this.c = d;
        this.d = d2;
        this.e = i2;
    }

    public final String a() {
        return this.a;
    }

    public final float b() {
        return this.b;
    }

    public final double c() {
        return this.c;
    }

    public final double d() {
        return this.d;
    }

    public final int e() {
        return this.e;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Intrinsics.areEqual(this.a, bVar.a) && Float.compare(this.b, bVar.b) == 0 && Double.compare(this.c, bVar.c) == 0 && Double.compare(this.d, bVar.d) == 0 && this.e == bVar.e;
    }

    public final String f() {
        return this.a;
    }

    public final double g() {
        return this.c;
    }

    public final double h() {
        return this.d;
    }

    public int hashCode() {
        return (((((((this.a.hashCode() * 31) + Float.hashCode(this.b)) * 31) + Double.hashCode(this.c)) * 31) + Double.hashCode(this.d)) * 31) + Integer.hashCode(this.e);
    }

    public final float i() {
        return this.b;
    }

    public final int j() {
        return this.e;
    }

    public String toString() {
        return "GeofenceRegion(id=" + this.a + ", radius=" + this.b + ", latitude=" + this.c + ", longitude=" + this.d + ", transition=" + this.e + ")";
    }

    public final b a(@NotNull String id, float f2, double d, double d2, int i2) {
        Intrinsics.checkNotNullParameter(id, "id");
        return new b(id, f2, d, d2, i2);
    }

    public static /* synthetic */ b a(b bVar, String str, float f2, double d, double d2, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = bVar.a;
        }
        if ((i3 & 2) != 0) {
            f2 = bVar.b;
        }
        float f3 = f2;
        if ((i3 & 4) != 0) {
            d = bVar.c;
        }
        double d3 = d;
        if ((i3 & 8) != 0) {
            d2 = bVar.d;
        }
        double d4 = d2;
        if ((i3 & 16) != 0) {
            i2 = bVar.e;
        }
        return bVar.a(str, f3, d3, d4, i2);
    }
}
