package com.transistorsoft.locationmanager.crash;

/* JADX INFO: loaded from: classes3.dex */
class b {
    private long a;
    private double b;
    private double c;

    b(long j, double d, double d2) {
        this.a = j / 1000;
        this.b = d;
        this.c = d2;
    }

    double a() {
        return this.b;
    }

    double b() {
        return this.c;
    }

    long c() {
        return this.a;
    }

    public String toString() {
        return this.a + "," + this.b + "," + this.c + "\n";
    }
}
