package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
final class zzkt implements Runnable {
    private final URL zza;
    private final byte[] zzb;
    private final zzkq zzc;
    private final String zzd;
    private final Map<String, String> zze;
    private final /* synthetic */ zzkr zzf;

    public zzkt(zzkr zzkrVar, String str, URL url, byte[] bArr, Map<String, String> map, zzkq zzkqVar) {
        this.zzf = zzkrVar;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(url);
        Preconditions.checkNotNull(zzkqVar);
        this.zza = url;
        this.zzb = null;
        this.zzc = zzkqVar;
        this.zzd = str;
        this.zze = null;
    }

    private final void zzb(final int i, final Exception exc, final byte[] bArr, final Map<String, List<String>> map) {
        this.zzf.zzl().zzb(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzks
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zza(i, exc, bArr, map);
            }
        });
    }

    final /* synthetic */ void zza(int i, Exception exc, byte[] bArr, Map map) {
        this.zzc.zza(this.zzd, i, exc, bArr, map);
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        Throwable th;
        HttpURLConnection httpURLConnection;
        Map<String, List<String>> headerFields;
        IOException e;
        this.zzf.zzr();
        int responseCode = 0;
        try {
            URLConnection uRLConnectionZza = com.google.android.gms.internal.measurement.zzcq.zza().zza(this.zza, "client-measurement");
            if (!(uRLConnectionZza instanceof HttpURLConnection)) {
                throw new IOException("Failed to obtain HTTP connection");
            }
            httpURLConnection = (HttpURLConnection) uRLConnectionZza;
            httpURLConnection.setDefaultUseCaches(false);
            httpURLConnection.setConnectTimeout(60000);
            httpURLConnection.setReadTimeout(61000);
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setDoInput(true);
            try {
                responseCode = httpURLConnection.getResponseCode();
                headerFields = httpURLConnection.getHeaderFields();
                try {
                    zzkr zzkrVar = this.zzf;
                    byte[] bArrZza = zzkr.zza(httpURLConnection);
                    httpURLConnection.disconnect();
                    zzb(responseCode, null, bArrZza, headerFields);
                } catch (IOException e2) {
                    e = e2;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    zzb(responseCode, e, null, headerFields);
                } catch (Throwable th2) {
                    th = th2;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    zzb(responseCode, null, null, headerFields);
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
                headerFields = null;
            } catch (Throwable th3) {
                th = th3;
                headerFields = null;
            }
        } catch (IOException e4) {
            e = e4;
            httpURLConnection = null;
            headerFields = null;
        } catch (Throwable th4) {
            th = th4;
            httpURLConnection = null;
            headerFields = null;
        }
    }
}
