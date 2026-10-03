package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.database.ContentObserver;
import androidx.core.content.PermissionChecker;
import io.sentry.android.core.SentryLogcatAdapter;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
final class zzhb implements zzgw {
    private static zzhb zza;

    @Nullable
    private final Context zzb;

    @Nullable
    private final ContentObserver zzc;

    static zzhb zza(Context context) {
        zzhb zzhbVar;
        synchronized (zzhb.class) {
            if (zza == null) {
                zza = PermissionChecker.checkSelfPermission(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new zzhb(context) : new zzhb();
            }
            zzhbVar = zza;
        }
        return zzhbVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.measurement.zzgw
    @Nullable
    /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final String zza(final String str) {
        Context context = this.zzb;
        if (context == null || zzgr.zza(context)) {
            return null;
        }
        try {
            return (String) zzgz.zza(new zzgy() { // from class: com.google.android.gms.internal.measurement.zzha
                @Override // com.google.android.gms.internal.measurement.zzgy
                public final Object zza() {
                    return this.zza.zzb(str);
                }
            });
        } catch (IllegalStateException | NullPointerException | SecurityException e) {
            SentryLogcatAdapter.e("GservicesLoader", "Unable to read GServices for: " + str, e);
            return null;
        }
    }

    final /* synthetic */ String zzb(String str) {
        return zzge.zza(this.zzb.getContentResolver(), str, null);
    }

    private zzhb() {
        this.zzb = null;
        this.zzc = null;
    }

    private zzhb(Context context) {
        this.zzb = context;
        zzhd zzhdVar = new zzhd(this, null);
        this.zzc = zzhdVar;
        context.getContentResolver().registerContentObserver(zzgh.zza, true, zzhdVar);
    }

    static void zza() {
        Context context;
        synchronized (zzhb.class) {
            zzhb zzhbVar = zza;
            if (zzhbVar != null && (context = zzhbVar.zzb) != null && zzhbVar.zzc != null) {
                context.getContentResolver().unregisterContentObserver(zza.zzc);
            }
            zza = null;
        }
    }
}
