package com.google.android.gms.internal.common;

import ch.qos.logback.core.CoreConstants;

/* JADX INFO: loaded from: classes4.dex */
final class zzl extends zzk {
    private final char zza;

    zzl(char c) {
        this.zza = c;
    }

    public final String toString() {
        char[] cArr = {CoreConstants.ESCAPE_CHAR, 'u', 0, 0, 0, 0};
        int i = this.zza;
        for (int i2 = 0; i2 < 4; i2++) {
            cArr[5 - i2] = "0123456789ABCDEF".charAt(i & 15);
            i >>= 4;
        }
        return "CharMatcher.is('" + String.copyValueOf(cArr) + "')";
    }

    @Override // com.google.android.gms.internal.common.zzo
    public final boolean zza(char c) {
        return c == this.zza;
    }
}
