package com.salesforce.marketingcloud.media;

import android.net.Uri;
import androidx.annotation.ColorInt;
import androidx.annotation.Px;

/* JADX INFO: loaded from: classes3.dex */
public class t {
    static final char m = '\n';
    public final Uri a;
    public final String b = a();
    public final o.c c;
    public final int d;
    public final int e;
    public final int f;
    public final boolean g;
    public final boolean h;
    public final float i;
    public final float j;
    public final int k;
    public long l;

    public enum b {
        NO_MEMORY_CACHE(1),
        NO_MEMORY_STORE(2),
        NO_DISK_STORE(4);

        int b;

        b(int i) {
            this.b = i;
        }

        public static boolean b(int i) {
            return (i & NO_MEMORY_STORE.b) == 0;
        }

        public static boolean c(int i) {
            return (i & NO_DISK_STORE.b) == 0;
        }

        public static boolean a(int i) {
            return (i & NO_MEMORY_CACHE.b) == 0;
        }

        public int b() {
            return this.b;
        }
    }

    t(a aVar) {
        this.a = aVar.a;
        this.c = aVar.b;
        this.d = aVar.c;
        this.e = aVar.d;
        this.f = aVar.e;
        this.g = aVar.f;
        this.h = aVar.g;
        this.i = aVar.h;
        this.j = aVar.i;
        this.k = aVar.j;
    }

    private String a() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.a.toString());
        sb.append('\n');
        if (d()) {
            sb.append("resize:");
            sb.append(this.e);
            sb.append('x');
            sb.append(this.f);
            sb.append('\n');
        }
        if (this.g) {
            sb.append("centerCrop");
            sb.append('\n');
        }
        if (this.h) {
            sb.append("centerInside");
            sb.append('\n');
        }
        if (c()) {
            sb.append("radius:");
            sb.append(this.i);
            sb.append(",border:");
            sb.append(this.j);
            sb.append(",color:");
            sb.append(this.k);
        }
        return sb.toString();
    }

    String b() {
        return String.valueOf(this.a.getPath());
    }

    boolean c() {
        return (this.i == 0.0f && this.j == 0.0f) ? false : true;
    }

    public boolean d() {
        return (this.e == 0 && this.f == 0) ? false : true;
    }

    boolean e() {
        return d() || c();
    }

    public static class a {
        Uri a;
        o.c b;
        int c;
        int d;
        int e;
        boolean f;
        boolean g;
        float h;
        float i;
        int j;

        public a(Uri uri) {
            this.a = uri;
        }

        public a a(float f, float f2, @ColorInt int i) {
            this.h = f;
            this.i = f2;
            this.j = i;
            return this;
        }

        public a b() {
            this.f = true;
            return this;
        }

        public a c() {
            this.g = true;
            return this;
        }

        public boolean d() {
            return this.b != null;
        }

        public a a(@Px int i, @Px int i2) {
            this.d = i;
            this.e = i2;
            return this;
        }

        public a a(o.c cVar) {
            this.b = cVar;
            return this;
        }

        public a a(b bVar, b... bVarArr) {
            if (bVar == null) {
                return this;
            }
            this.c = bVar.b | this.c;
            if (bVarArr == null) {
                return this;
            }
            for (b bVar2 : bVarArr) {
                this.c = bVar2.b | this.c;
            }
            return this;
        }

        public t a() {
            if (this.b == null) {
                this.b = o.c.NORMAL;
            }
            return new t(this);
        }
    }
}
