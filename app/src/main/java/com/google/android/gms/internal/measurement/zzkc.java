package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public class zzkc extends IOException {
    private zzlh zza;

    static zzkf zza() {
        return new zzkf("Protocol message tag had invalid wire type.");
    }

    static zzkc zzb() {
        return new zzkc("Protocol message end-group tag did not match expected tag.");
    }

    static zzkc zzc() {
        return new zzkc("Protocol message contained an invalid tag (zero).");
    }

    static zzkc zzd() {
        return new zzkc("Protocol message had invalid UTF-8.");
    }

    static zzkc zze() {
        return new zzkc("CodedInputStream encountered a malformed varint.");
    }

    static zzkc zzf() {
        return new zzkc("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzkc zzg() {
        return new zzkc("Failed to parse the message.");
    }

    static zzkc zzh() {
        return new zzkc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public zzkc(String str) {
        super(str);
        this.zza = null;
    }
}
