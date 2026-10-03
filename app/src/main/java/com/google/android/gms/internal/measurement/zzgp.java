package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public interface zzgp {
    String zza(ContentResolver contentResolver, String str) throws zzgo;

    <T extends Map<String, String>> T zza(ContentResolver contentResolver, String[] strArr, zzgm<T> zzgmVar) throws zzgo;
}
