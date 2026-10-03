package com.salesforce.marketingcloud.messages.iam;

import android.os.CountDownTimer;

/* JADX INFO: loaded from: classes3.dex */
abstract class a extends CountDownTimer {
    private long a;
    private long b;

    a(long j, long j2) {
        super(j - j2, 500L);
        this.b = j;
    }

    public long a() {
        return this.b - this.a;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        this.a = 0L;
    }

    @Override // android.os.CountDownTimer
    public final void onTick(long j) {
        this.a = j;
    }
}
