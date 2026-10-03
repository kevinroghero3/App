package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzod;
import com.google.android.gms.internal.measurement.zzoi;
import com.google.android.gms.internal.measurement.zzoo;
import com.google.android.gms.internal.measurement.zzop;
import com.google.android.gms.internal.measurement.zzpz;
import com.google.android.gms.internal.measurement.zzql;
import com.google.android.gms.internal.measurement.zzqw;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.perf.util.Constants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.time.DurationKt;

/* JADX INFO: loaded from: classes5.dex */
final class zzan extends zznf {
    private static final String[] zza = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};
    private static final String[] zzb = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    private static final String[] zzc = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;", "config_last_modified_time", "ALTER TABLE apps ADD COLUMN config_last_modified_time TEXT;", "e_tag", "ALTER TABLE apps ADD COLUMN e_tag TEXT;", "session_stitching_token", "ALTER TABLE apps ADD COLUMN session_stitching_token TEXT;", "sgtm_upload_enabled", "ALTER TABLE apps ADD COLUMN sgtm_upload_enabled INTEGER;", "target_os_version", "ALTER TABLE apps ADD COLUMN target_os_version INTEGER;", "session_stitching_token_hash", "ALTER TABLE apps ADD COLUMN session_stitching_token_hash INTEGER;", "ad_services_version", "ALTER TABLE apps ADD COLUMN ad_services_version INTEGER;", "unmatched_first_open_without_ad_id", "ALTER TABLE apps ADD COLUMN unmatched_first_open_without_ad_id INTEGER;", "npa_metadata_value", "ALTER TABLE apps ADD COLUMN npa_metadata_value INTEGER;", "attribution_eligibility_status", "ALTER TABLE apps ADD COLUMN attribution_eligibility_status INTEGER;", "sgtm_preview_key", "ALTER TABLE apps ADD COLUMN sgtm_preview_key TEXT;", "dma_consent_state", "ALTER TABLE apps ADD COLUMN dma_consent_state INTEGER;", "daily_realtime_dcu_count", "ALTER TABLE apps ADD COLUMN daily_realtime_dcu_count INTEGER;", "bundle_delivery_index", "ALTER TABLE apps ADD COLUMN bundle_delivery_index INTEGER;", "serialized_npa_metadata", "ALTER TABLE apps ADD COLUMN serialized_npa_metadata TEXT;", "unmatched_pfo", "ALTER TABLE apps ADD COLUMN unmatched_pfo INTEGER;", "unmatched_uwa", "ALTER TABLE apps ADD COLUMN unmatched_uwa INTEGER;"};
    private static final String[] zzd = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    private static final String[] zze = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    private static final String[] zzg = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};
    private static final String[] zzh = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};
    private static final String[] zzi = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    private static final String[] zzj = {"consent_source", "ALTER TABLE consent_settings ADD COLUMN consent_source INTEGER;", "dma_consent_settings", "ALTER TABLE consent_settings ADD COLUMN dma_consent_settings TEXT;"};
    private static final String[] zzk = {"idempotent", "CREATE INDEX IF NOT EXISTS trigger_uris_index ON trigger_uris (app_id);"};
    private final zzat zzl;
    private final zzmz zzm;

    public final int zza(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzt();
        zzak();
        try {
            return e_().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error deleting conditional property", zzgb.zza(str), zzi().zzc(str2), e);
            return 0;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zznf
    protected final boolean zzc() {
        return false;
    }

    public final long zza(String str) {
        Preconditions.checkNotEmpty(str);
        zzt();
        zzak();
        try {
            return e_().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, String.valueOf(Math.max(0, Math.min(DurationKt.NANOS_IN_MILLIS, zze().zzb(str, zzbh.zzp))))});
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error deleting over the limit events. appId", zzgb.zza(str), e);
            return 0L;
        }
    }

    public final long b_() {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = e_().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
                if (!cursorRawQuery.moveToFirst()) {
                    cursorRawQuery.close();
                    return -1L;
                }
                long j = cursorRawQuery.getLong(0);
                cursorRawQuery.close();
                return j;
            } catch (SQLiteException e) {
                zzj().zzg().zza("Error querying raw events", e);
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return -1L;
            }
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    public final long zza(com.google.android.gms.internal.measurement.zzfs.zzj zzjVar) throws IOException {
        zzt();
        zzak();
        Preconditions.checkNotNull(zzjVar);
        Preconditions.checkNotEmpty(zzjVar.zzy());
        byte[] bArrZzbx = zzjVar.zzbx();
        long jZza = g_().zza(bArrZzbx);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzjVar.zzy());
        contentValues.put("metadata_fingerprint", Long.valueOf(jZza));
        contentValues.put("metadata", bArrZzbx);
        try {
            e_().insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
            return jZza;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing raw event metadata. appId", zzgb.zza(zzjVar.zzy()), e);
            throw e;
        }
    }

    protected final long zzb(String str, String str2) {
        SQLiteException e;
        long jZza;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzt();
        zzak();
        SQLiteDatabase sQLiteDatabaseE_ = e_();
        sQLiteDatabaseE_.beginTransaction();
        try {
            try {
                jZza = zza("select " + str2 + " from app2 where app_id=?", new String[]{str}, -1L);
                try {
                    if (jZza == -1) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("app_id", str);
                        contentValues.put("first_open_count", (Integer) 0);
                        contentValues.put("previous_install_count", (Integer) 0);
                        if (sQLiteDatabaseE_.insertWithOnConflict("app2", null, contentValues, 5) == -1) {
                            zzj().zzg().zza("Failed to insert column (got -1). appId", zzgb.zza(str), str2);
                            return -1L;
                        }
                        jZza = 0;
                        zzj().zzg().zza("Error inserting column. appId", zzgb.zza(str), str2, e);
                        return jZza;
                    }
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put("app_id", str);
                    contentValues2.put(str2, Long.valueOf(1 + jZza));
                    if (sQLiteDatabaseE_.update("app2", contentValues2, "app_id = ?", new String[]{str}) == 0) {
                        zzj().zzg().zza("Failed to update column (got 0). appId", zzgb.zza(str), str2);
                        return -1L;
                    }
                    sQLiteDatabaseE_.setTransactionSuccessful();
                    return jZza;
                } catch (SQLiteException e2) {
                    e = e2;
                    zzj().zzg().zza("Error inserting column. appId", zzgb.zza(str), str2, e);
                }
            } catch (SQLiteException e3) {
                e = e3;
                jZza = 0;
            }
        } finally {
            sQLiteDatabaseE_.endTransaction();
        }
    }

    public final long zzb(String str) {
        Preconditions.checkNotEmpty(str);
        zzt();
        zzak();
        return zza("select first_open_count from app2 where app_id=?", new String[]{str}, -1L);
    }

    public final long c_() {
        return zza("select max(bundle_end_timestamp) from queue", (String[]) null, 0L);
    }

    public final long d_() {
        return zza("select max(timestamp) from raw_events", (String[]) null, 0L);
    }

    public final long zzc(String str) {
        Preconditions.checkNotEmpty(str);
        return zza("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0L);
    }

    private final long zzb(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                Cursor cursorRawQuery = e_().rawQuery(str, strArr);
                if (cursorRawQuery.moveToFirst()) {
                    long j = cursorRawQuery.getLong(0);
                    cursorRawQuery.close();
                    return j;
                }
                throw new SQLiteException("Database returned empty set");
            } catch (SQLiteException e) {
                zzj().zzg().zza("Database error", str, e);
                throw e;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    private final long zza(String str, String[] strArr, long j) {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = e_().rawQuery(str, strArr);
                if (cursorRawQuery.moveToFirst()) {
                    long j2 = cursorRawQuery.getLong(0);
                    cursorRawQuery.close();
                    return j2;
                }
                cursorRawQuery.close();
                return j;
            } catch (SQLiteException e) {
                zzj().zzg().zza("Database error", str, e);
                throw e;
            }
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    final SQLiteDatabase e_() {
        zzt();
        try {
            return this.zzl.getWritableDatabase();
        } catch (SQLiteException e) {
            zzj().zzu().zza("Error opening database", e);
            throw e;
        }
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0085  */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0082: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:30:0x0082 */
    public final Bundle zzd(String str) throws Throwable {
        Cursor cursorRawQuery;
        Cursor cursor;
        zzt();
        zzak();
        Cursor cursor2 = null;
        try {
            try {
                cursorRawQuery = e_().rawQuery("select parameters from default_event_params where app_id=?", new String[]{str});
                try {
                    if (!cursorRawQuery.moveToFirst()) {
                        zzj().zzp().zza("Default event parameters not found");
                        cursorRawQuery.close();
                        return null;
                    }
                    try {
                        com.google.android.gms.internal.measurement.zzfs.zze zzeVar = (com.google.android.gms.internal.measurement.zzfs.zze) ((com.google.android.gms.internal.measurement.zzju) ((com.google.android.gms.internal.measurement.zzfs.zze.zza) zznt.zza(com.google.android.gms.internal.measurement.zzfs.zze.zze(), cursorRawQuery.getBlob(0))).zzah());
                        g_();
                        Bundle bundleZza = zznt.zza(zzeVar.zzh());
                        cursorRawQuery.close();
                        return bundleZza;
                    } catch (IOException e) {
                        zzj().zzg().zza("Failed to retrieve default event parameters. appId", zzgb.zza(str), e);
                        cursorRawQuery.close();
                        return null;
                    }
                } catch (SQLiteException e2) {
                    e = e2;
                    zzj().zzg().zza("Error selecting default event parameters", e);
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return null;
                }
            } catch (SQLiteException e3) {
                e = e3;
                cursorRawQuery = null;
            } catch (Throwable th) {
                th = th;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            cursor2 = cursor;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:32:0x008b  */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0088: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:30:0x0088 */
    public final Pair<com.google.android.gms.internal.measurement.zzfs.zze, Long> zza(String str, Long l) throws Throwable {
        Cursor cursorRawQuery;
        Cursor cursor;
        zzt();
        zzak();
        Cursor cursor2 = null;
        try {
            try {
                cursorRawQuery = e_().rawQuery("select main_event, children_to_process from main_event_params where app_id=? and event_id=?", new String[]{str, String.valueOf(l)});
                try {
                    if (!cursorRawQuery.moveToFirst()) {
                        zzj().zzp().zza("Main event not found");
                        cursorRawQuery.close();
                        return null;
                    }
                    try {
                        Pair<com.google.android.gms.internal.measurement.zzfs.zze, Long> pairCreate = Pair.create((com.google.android.gms.internal.measurement.zzfs.zze) ((com.google.android.gms.internal.measurement.zzju) ((com.google.android.gms.internal.measurement.zzfs.zze.zza) zznt.zza(com.google.android.gms.internal.measurement.zzfs.zze.zze(), cursorRawQuery.getBlob(0))).zzah()), Long.valueOf(cursorRawQuery.getLong(1)));
                        cursorRawQuery.close();
                        return pairCreate;
                    } catch (IOException e) {
                        zzj().zzg().zza("Failed to merge main event. appId, eventId", zzgb.zza(str), l, e);
                        cursorRawQuery.close();
                        return null;
                    }
                } catch (SQLiteException e2) {
                    e = e2;
                    zzj().zzg().zza("Error selecting main event", e);
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return null;
                }
            } catch (SQLiteException e3) {
                e = e3;
                cursorRawQuery = null;
            } catch (Throwable th) {
                th = th;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            cursor2 = cursor;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:137:0x0461  */
    /* JADX WARN: Code duplicated, block: B:143:? A[SYNTHETIC] */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x045e: MOVE (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:135:0x045d */
    public final zzf zze(String str) {
        Throwable th;
        SQLiteException sQLiteException;
        Cursor cursorQuery;
        Cursor cursor;
        Boolean boolValueOf;
        Preconditions.checkNotEmpty(str);
        zzt();
        zzak();
        Cursor cursor2 = null;
        try {
            try {
                cursorQuery = e_().query("apps", new String[]{"app_instance_id", "gmp_app_id", "resettable_device_id_hash", "last_bundle_index", "last_bundle_start_timestamp", "last_bundle_end_timestamp", "app_version", "app_store", "gmp_version", "dev_cert_hash", "measurement_enabled", "day", "daily_public_events_count", "daily_events_count", "daily_conversions_count", "config_fetched_time", "failed_config_fetch_time", "app_version_int", "firebase_instance_id", "daily_error_events_count", "daily_realtime_events_count", "health_monitor_sample", "android_id", "adid_reporting_enabled", "admob_app_id", "dynamite_version", "safelisted_events", "ga_app_id", "session_stitching_token", "sgtm_upload_enabled", "target_os_version", "session_stitching_token_hash", "ad_services_version", "unmatched_first_open_without_ad_id", "npa_metadata_value", "attribution_eligibility_status", "sgtm_preview_key", "dma_consent_state", "daily_realtime_dcu_count", "bundle_delivery_index", "serialized_npa_metadata", "unmatched_pfo", "unmatched_uwa"}, "app_id=?", new String[]{str}, null, null, null);
                try {
                    if (!cursorQuery.moveToFirst()) {
                        cursorQuery.close();
                        return null;
                    }
                    zzf zzfVar = new zzf(this.zzf.zzk(), str);
                    if (!zzod.zza() || !zze().zza(zzbh.zzdg) || this.zzf.zzb(str).zza(zzis.zza.ANALYTICS_STORAGE)) {
                        zzfVar.zzb(cursorQuery.getString(0));
                    }
                    zzfVar.zzf(cursorQuery.getString(1));
                    if (!zzod.zza() || !zze().zza(zzbh.zzdg) || this.zzf.zzb(str).zza(zzis.zza.AD_STORAGE)) {
                        zzfVar.zzh(cursorQuery.getString(2));
                    }
                    zzfVar.zzq(cursorQuery.getLong(3));
                    zzfVar.zzr(cursorQuery.getLong(4));
                    zzfVar.zzp(cursorQuery.getLong(5));
                    zzfVar.zzd(cursorQuery.getString(6));
                    zzfVar.zzc(cursorQuery.getString(7));
                    zzfVar.zzn(cursorQuery.getLong(8));
                    zzfVar.zzk(cursorQuery.getLong(9));
                    zzfVar.zzb(cursorQuery.isNull(10) || cursorQuery.getInt(10) != 0);
                    zzfVar.zzj(cursorQuery.getLong(11));
                    zzfVar.zzh(cursorQuery.getLong(12));
                    zzfVar.zzg(cursorQuery.getLong(13));
                    zzfVar.zze(cursorQuery.getLong(14));
                    zzfVar.zzd(cursorQuery.getLong(15));
                    zzfVar.zzm(cursorQuery.getLong(16));
                    zzfVar.zzb(cursorQuery.isNull(17) ? -2147483648L : cursorQuery.getInt(17));
                    zzfVar.zze(cursorQuery.getString(18));
                    zzfVar.zzf(cursorQuery.getLong(19));
                    zzfVar.zzi(cursorQuery.getLong(20));
                    zzfVar.zzg(cursorQuery.getString(21));
                    zzfVar.zza(cursorQuery.isNull(23) || cursorQuery.getInt(23) != 0);
                    zzfVar.zza(cursorQuery.getString(24));
                    zzfVar.zzl(cursorQuery.isNull(25) ? 0L : cursorQuery.getLong(25));
                    if (!cursorQuery.isNull(26)) {
                        zzfVar.zza(Arrays.asList(cursorQuery.getString(26).split(",", -1)));
                    }
                    if (zzql.zza() && ((zze().zze(str, zzbh.zzbs) || zze().zza(zzbh.zzbq)) && (!zzod.zza() || !zze().zza(zzbh.zzdg) || this.zzf.zzb(str).zza(zzis.zza.ANALYTICS_STORAGE)))) {
                        zzfVar.zzj(cursorQuery.getString(28));
                    }
                    if (zzqw.zza() && zze().zza(zzbh.zzbt)) {
                        zzq();
                        if (zznw.zzf(str)) {
                            zzfVar.zzc((cursorQuery.isNull(29) || cursorQuery.getInt(29) == 0) ? false : true);
                            zzfVar.zzo(cursorQuery.getLong(39));
                            if (zze().zza(zzbh.zzbu)) {
                                zzfVar.zzk(cursorQuery.getString(36));
                            }
                        }
                    }
                    zzfVar.zzt(cursorQuery.getLong(30));
                    zzfVar.zzs(cursorQuery.getLong(31));
                    if (zzpz.zza() && zze().zze(str, zzbh.zzcg)) {
                        zzfVar.zza(cursorQuery.getInt(32));
                        zzfVar.zzc(cursorQuery.getLong(35));
                    }
                    if (zzoi.zza() && zze().zze(str, zzbh.zzcs)) {
                        zzfVar.zzd((cursorQuery.isNull(33) || cursorQuery.getInt(33) == 0) ? false : true);
                    }
                    if (cursorQuery.isNull(34)) {
                        boolValueOf = null;
                    } else {
                        boolValueOf = Boolean.valueOf(cursorQuery.getInt(34) != 0);
                    }
                    zzfVar.zza(boolValueOf);
                    if (zzoo.zza() && zze().zze(str, zzbh.zzcr)) {
                        zzfVar.zzc(cursorQuery.getInt(37));
                        zzfVar.zzb(cursorQuery.getInt(38));
                    }
                    if (com.google.android.gms.internal.measurement.zznx.zza() && zze().zze(str, zzbh.zzcz)) {
                        String string = cursorQuery.getString(40);
                        if (string == null) {
                            string = "";
                        }
                        zzfVar.zzi(string);
                    }
                    if (zze().zza(zzbh.zzdd)) {
                        if (!cursorQuery.isNull(41)) {
                            zzfVar.zza(Long.valueOf(cursorQuery.getLong(41)));
                        }
                        if (!cursorQuery.isNull(42)) {
                            zzfVar.zzb(Long.valueOf(cursorQuery.getLong(42)));
                        }
                    }
                    zzfVar.zzao();
                    if (cursorQuery.moveToNext()) {
                        zzj().zzg().zza("Got multiple records for app, expected one. appId", zzgb.zza(str));
                    }
                    cursorQuery.close();
                    return zzfVar;
                } catch (SQLiteException e) {
                    sQLiteException = e;
                    zzj().zzg().zza("Error querying app. appId", zzgb.zza(str), sQLiteException);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
            } catch (SQLiteException e2) {
                sQLiteException = e2;
                cursorQuery = null;
            } catch (Throwable th2) {
                th = th2;
                if (cursor2 != null) {
                    cursor2.close();
                    throw th;
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            cursor2 = cursor;
            if (cursor2 != null) {
                cursor2.close();
                throw th;
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0150  */
    public final zzac zzc(String str, String str2) throws Throwable {
        Cursor cursorQuery;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzt();
        zzak();
        Cursor cursor = null;
        try {
            try {
                cursorQuery = e_().query("conditional_properties", new String[]{"origin", "value", "active", AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, "timed_out_event", AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, "triggered_event", AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, "expired_event"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
                try {
                    if (!cursorQuery.moveToFirst()) {
                        cursorQuery.close();
                        return null;
                    }
                    String string = cursorQuery.getString(0);
                    if (string == null) {
                        string = "";
                    }
                    String str3 = string;
                    try {
                        Object objZza = zza(cursorQuery, 1);
                        boolean z = cursorQuery.getInt(2) != 0;
                        String string2 = cursorQuery.getString(3);
                        long j = cursorQuery.getLong(4);
                        zznt zzntVarG_ = g_();
                        byte[] blob = cursorQuery.getBlob(5);
                        Parcelable.Creator<zzbf> creator = zzbf.CREATOR;
                        zzac zzacVar = new zzac(str, str3, new zznv(str2, cursorQuery.getLong(8), objZza, str3), cursorQuery.getLong(6), z, string2, (zzbf) zzntVarG_.zza(blob, creator), j, (zzbf) g_().zza(cursorQuery.getBlob(7), creator), cursorQuery.getLong(9), (zzbf) g_().zza(cursorQuery.getBlob(10), creator));
                        if (cursorQuery.moveToNext()) {
                            zzj().zzg().zza("Got multiple records for conditional property, expected one", zzgb.zza(str), zzi().zzc(str2));
                        }
                        cursorQuery.close();
                        return zzacVar;
                    } catch (SQLiteException e) {
                        e = e;
                    }
                } catch (SQLiteException e2) {
                    e = e2;
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (SQLiteException e3) {
                e = e3;
                cursorQuery = null;
            } catch (Throwable th2) {
                th = th2;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
        zzj().zzg().zza("Error querying conditional property", zzgb.zza(str), zzi().zzc(str2), e);
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x008d  */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x008a: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:28:0x008a */
    public final zzap zzf(String str) throws Throwable {
        SQLiteException e;
        Cursor cursorQuery;
        Cursor cursor;
        Preconditions.checkNotEmpty(str);
        zzt();
        zzak();
        Cursor cursor2 = null;
        try {
            try {
                cursorQuery = e_().query("apps", new String[]{"remote_config", "config_last_modified_time", "e_tag"}, "app_id=?", new String[]{str}, null, null, null);
                try {
                    if (!cursorQuery.moveToFirst()) {
                        cursorQuery.close();
                        return null;
                    }
                    byte[] blob = cursorQuery.getBlob(0);
                    String string = cursorQuery.getString(1);
                    String string2 = cursorQuery.getString(2);
                    if (cursorQuery.moveToNext()) {
                        zzj().zzg().zza("Got multiple records for app config, expected one. appId", zzgb.zza(str));
                    }
                    if (blob == null) {
                        cursorQuery.close();
                        return null;
                    }
                    zzap zzapVar = new zzap(blob, string, string2);
                    cursorQuery.close();
                    return zzapVar;
                } catch (SQLiteException e2) {
                    e = e2;
                    zzj().zzg().zza("Error querying remote config. appId", zzgb.zza(str), e);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
            } catch (SQLiteException e3) {
                e = e3;
                cursorQuery = null;
            } catch (Throwable th) {
                th = th;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            cursor2 = cursor;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public final zzao zza(long j, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        return zza(j, str, 1L, false, false, z3, false, z5, z6);
    }

    /* JADX WARN: Code duplicated, block: B:54:0x0188  */
    public final zzao zza(long j, String str, long j2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) throws Throwable {
        Cursor cursor;
        Preconditions.checkNotEmpty(str);
        zzt();
        zzak();
        String[] strArr = {str};
        zzao zzaoVar = new zzao();
        try {
            SQLiteDatabase sQLiteDatabaseE_ = e_();
            Cursor cursorQuery = sQLiteDatabaseE_.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count", "daily_realtime_dcu_count"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (!cursorQuery.moveToFirst()) {
                    zzj().zzu().zza("Not updating daily counts, app is not known. appId", zzgb.zza(str));
                    cursorQuery.close();
                    return zzaoVar;
                }
                if (cursorQuery.getLong(0) == j) {
                    zzaoVar.zzb = cursorQuery.getLong(1);
                    zzaoVar.zza = cursorQuery.getLong(2);
                    zzaoVar.zzc = cursorQuery.getLong(3);
                    zzaoVar.zzd = cursorQuery.getLong(4);
                    zzaoVar.zze = cursorQuery.getLong(5);
                    if (zzoo.zza() && zze().zza(zzbh.zzcr)) {
                        zzaoVar.zzf = cursorQuery.getLong(6);
                    }
                }
                if (z) {
                    zzaoVar.zzb += j2;
                }
                if (z2) {
                    zzaoVar.zza += j2;
                }
                if (z3) {
                    zzaoVar.zzc += j2;
                }
                if (z4) {
                    zzaoVar.zzd += j2;
                }
                if (z5) {
                    zzaoVar.zze += j2;
                }
                if (zzoo.zza() && zze().zza(zzbh.zzcr) && z6) {
                    zzaoVar.zzf += j2;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("day", Long.valueOf(j));
                contentValues.put("daily_public_events_count", Long.valueOf(zzaoVar.zza));
                contentValues.put("daily_events_count", Long.valueOf(zzaoVar.zzb));
                contentValues.put("daily_conversions_count", Long.valueOf(zzaoVar.zzc));
                contentValues.put("daily_error_events_count", Long.valueOf(zzaoVar.zzd));
                contentValues.put("daily_realtime_events_count", Long.valueOf(zzaoVar.zze));
                if (zzoo.zza() && zze().zza(zzbh.zzcr)) {
                    contentValues.put("daily_realtime_dcu_count", Long.valueOf(zzaoVar.zzf));
                }
                sQLiteDatabaseE_.update("apps", contentValues, "app_id=?", strArr);
                cursorQuery.close();
                return zzaoVar;
            } catch (SQLiteException e) {
                e = e;
                cursor = cursorQuery;
                try {
                    zzj().zzg().zza("Error updating daily counts. appId", zzgb.zza(str), e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return zzaoVar;
                } catch (Throwable th) {
                    th = th;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                cursor = cursorQuery;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (SQLiteException e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
    }

    public final zzax zzg(String str) {
        Preconditions.checkNotNull(str);
        zzt();
        zzak();
        return zzax.zza(zza("select dma_consent_settings from consent_settings where app_id=? limit 1;", new String[]{str}, ""));
    }

    /* JADX WARN: Code duplicated, block: B:53:0x0126  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v3 */
    public final zzbb zzd(String str, String str2) {
        Cursor cursorQuery;
        Boolean boolValueOf;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzt();
        zzak();
        ArrayList arrayList = new ArrayList(Arrays.asList("lifetime_count", "current_bundle_count", "last_fire_timestamp", "last_bundled_timestamp", "last_bundled_day", "last_sampled_complex_event_id", "last_sampling_rate", "last_exempt_from_sampling", "current_session_count"));
        ?? r2 = 0;
        try {
            try {
                cursorQuery = e_().query("events", (String[]) arrayList.toArray(new String[0]), "app_id=? and name=?", new String[]{str, str2}, null, null, null);
                try {
                    if (!cursorQuery.moveToFirst()) {
                        cursorQuery.close();
                        return null;
                    }
                    long j = cursorQuery.getLong(0);
                    long j2 = cursorQuery.getLong(1);
                    long j3 = cursorQuery.getLong(2);
                    long j4 = 0;
                    long j5 = cursorQuery.isNull(3) ? 0L : cursorQuery.getLong(3);
                    Long lValueOf = cursorQuery.isNull(4) ? null : Long.valueOf(cursorQuery.getLong(4));
                    Long lValueOf2 = cursorQuery.isNull(5) ? null : Long.valueOf(cursorQuery.getLong(5));
                    Long lValueOf3 = cursorQuery.isNull(6) ? null : Long.valueOf(cursorQuery.getLong(6));
                    if (cursorQuery.isNull(7)) {
                        boolValueOf = null;
                    } else {
                        boolValueOf = Boolean.valueOf(cursorQuery.getLong(7) == 1);
                    }
                    if (!cursorQuery.isNull(8)) {
                        j4 = cursorQuery.getLong(8);
                    }
                    zzbb zzbbVar = new zzbb(str, str2, j, j2, j4, j3, j5, lValueOf, lValueOf2, lValueOf3, boolValueOf);
                    if (cursorQuery.moveToNext()) {
                        zzj().zzg().zza("Got multiple records for event aggregates, expected one. appId", zzgb.zza(str));
                    }
                    cursorQuery.close();
                    return zzbbVar;
                } catch (SQLiteException e) {
                    e = e;
                    zzj().zzg().zza("Error querying events. appId", zzgb.zza(str), zzi().zza(str2), e);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
            } catch (SQLiteException e2) {
                e = e2;
                cursorQuery = null;
            } catch (Throwable th) {
                th = th;
                if (r2 != 0) {
                    r2.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            r2 = arrayList;
            if (r2 != 0) {
                r2.close();
            }
            throw th;
        }
    }

    public final zzis zzh(String str) {
        Preconditions.checkNotNull(str);
        zzt();
        zzak();
        zzis zzisVar = (zzis) zza("select consent_state, consent_source from consent_settings where app_id=? limit 1;", new String[]{str}, new zzaq() { // from class: com.google.android.gms.measurement.internal.zzam
            @Override // com.google.android.gms.measurement.internal.zzaq
            public final Object zza(Cursor cursor) {
                return zzis.zza(cursor.getString(0), cursor.getInt(1));
            }
        });
        return zzisVar == null ? zzis.zza : zzisVar;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x009a  */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0097: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:28:0x0097 */
    public final zznx zze(String str, String str2) {
        Cursor cursorQuery;
        Cursor cursor;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzt();
        zzak();
        Cursor cursor2 = null;
        try {
            try {
                cursorQuery = e_().query("user_attributes", new String[]{"set_timestamp", "value", "origin"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
                try {
                    if (!cursorQuery.moveToFirst()) {
                        cursorQuery.close();
                        return null;
                    }
                    long j = cursorQuery.getLong(0);
                    Object objZza = zza(cursorQuery, 1);
                    if (objZza == null) {
                        cursorQuery.close();
                        return null;
                    }
                    zznx zznxVar = new zznx(str, cursorQuery.getString(2), str2, j, objZza);
                    if (cursorQuery.moveToNext()) {
                        zzj().zzg().zza("Got multiple records for user property, expected one. appId", zzgb.zza(str));
                    }
                    cursorQuery.close();
                    return zznxVar;
                } catch (SQLiteException e) {
                    e = e;
                    zzj().zzg().zza("Error querying user property. appId", zzgb.zza(str), zzi().zzc(str2), e);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
            } catch (SQLiteException e2) {
                e = e2;
                cursorQuery = null;
            } catch (Throwable th) {
                th = th;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            cursor2 = cursor;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    private final Object zza(Cursor cursor, int i) {
        int type = cursor.getType(i);
        if (type == 0) {
            zzj().zzg().zza("Loaded invalid null value from database");
            return null;
        }
        if (type == 1) {
            return Long.valueOf(cursor.getLong(i));
        }
        if (type == 2) {
            return Double.valueOf(cursor.getDouble(i));
        }
        if (type == 3) {
            return cursor.getString(i);
        }
        if (type == 4) {
            zzj().zzg().zza("Loaded invalid blob type value, ignoring it");
            return null;
        }
        zzj().zzg().zza("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0047  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v2 */
    private final <T> T zza(String str, String[] strArr, zzaq<T> zzaqVar) throws Throwable {
        SQLiteException e;
        Cursor cursorRawQuery;
        ?? r0 = 0;
        try {
            try {
                cursorRawQuery = e_().rawQuery(str, strArr);
                try {
                    if (!cursorRawQuery.moveToFirst()) {
                        zzj().zzp().zza("No data found");
                        cursorRawQuery.close();
                        return null;
                    }
                    T tZza = zzaqVar.zza(cursorRawQuery);
                    cursorRawQuery.close();
                    return tZza;
                } catch (SQLiteException e2) {
                    e = e2;
                    zzj().zzg().zza("Error querying database.", e);
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return null;
                }
            } catch (SQLiteException e3) {
                e = e3;
                cursorRawQuery = null;
            } catch (Throwable th) {
                th = th;
                if (r0 != 0) {
                    r0.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            r0 = str;
            th = th2;
            if (r0 != 0) {
                r0.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0059  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r4v0, types: [long] */
    public final String zza(long j) throws Throwable {
        SQLiteException e;
        Cursor cursorRawQuery;
        zzt();
        zzak();
        ?? r0 = 0;
        try {
            try {
                cursorRawQuery = e_().rawQuery("select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;", new String[]{String.valueOf((long) j)});
                try {
                    if (!cursorRawQuery.moveToFirst()) {
                        zzj().zzp().zza("No expired configs for apps with pending events");
                        cursorRawQuery.close();
                        return null;
                    }
                    String string = cursorRawQuery.getString(0);
                    cursorRawQuery.close();
                    return string;
                } catch (SQLiteException e2) {
                    e = e2;
                    zzj().zzg().zza("Error selecting expired configs", e);
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return null;
                }
            } catch (SQLiteException e3) {
                e = e3;
                cursorRawQuery = null;
            } catch (Throwable th) {
                th = th;
                if (r0 != 0) {
                    r0.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            r0 = j;
            th = th2;
            if (r0 != 0) {
                r0.close();
            }
            throw th;
        }
    }

    public final String f_() throws Throwable {
        SQLiteException e;
        Cursor cursorRawQuery;
        Cursor cursor = null;
        try {
            cursorRawQuery = e_().rawQuery("select app_id from queue order by has_realtime desc, rowid asc limit 1;", null);
            try {
                try {
                    if (cursorRawQuery.moveToFirst()) {
                        String string = cursorRawQuery.getString(0);
                        cursorRawQuery.close();
                        return string;
                    }
                    cursorRawQuery.close();
                    return null;
                } catch (Throwable th) {
                    cursor = cursorRawQuery;
                    th = th;
                }
            } catch (SQLiteException e2) {
                e = e2;
                zzj().zzg().zza("Database error getting next bundle app id", e);
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return null;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursorRawQuery = null;
        } catch (Throwable th2) {
            th = th2;
        }
        cursor = cursorRawQuery;
        th = th;
        if (cursor != null) {
            cursor.close();
        }
        throw th;
    }

    private final String zza(String str, String[] strArr, String str2) {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = e_().rawQuery(str, strArr);
                if (cursorRawQuery.moveToFirst()) {
                    String string = cursorRawQuery.getString(0);
                    cursorRawQuery.close();
                    return string;
                }
                cursorRawQuery.close();
                return str2;
            } catch (SQLiteException e) {
                zzj().zzg().zza("Database error", str, e);
                throw e;
            }
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    public final List<Pair<com.google.android.gms.internal.measurement.zzfs.zzj, Long>> zza(String str, int i, int i2) {
        long jZzc;
        long jZzc2;
        zzt();
        zzak();
        int i3 = 1;
        Preconditions.checkArgument(i > 0);
        Preconditions.checkArgument(i2 > 0);
        Preconditions.checkNotEmpty(str);
        Cursor cursor = null;
        try {
            try {
                Cursor cursorQuery = e_().query("queue", new String[]{"rowid", "data", "retry_count"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(i));
                if (!cursorQuery.moveToFirst()) {
                    List<Pair<com.google.android.gms.internal.measurement.zzfs.zzj, Long>> listEmptyList = Collections.emptyList();
                    cursorQuery.close();
                    return listEmptyList;
                }
                ArrayList arrayList = new ArrayList();
                int length = 0;
                while (true) {
                    long j = cursorQuery.getLong(0);
                    try {
                        byte[] bArrZzc = g_().zzc(cursorQuery.getBlob(i3));
                        if (!arrayList.isEmpty() && bArrZzc.length + length > i2) {
                            break;
                        }
                        try {
                            com.google.android.gms.internal.measurement.zzfs.zzj.zza zzaVar = (com.google.android.gms.internal.measurement.zzfs.zzj.zza) zznt.zza(com.google.android.gms.internal.measurement.zzfs.zzj.zzv(), bArrZzc);
                            if (!arrayList.isEmpty()) {
                                com.google.android.gms.internal.measurement.zzfs.zzj zzjVar = (com.google.android.gms.internal.measurement.zzfs.zzj) ((Pair) arrayList.get(0)).first;
                                com.google.android.gms.internal.measurement.zzfs.zzj zzjVar2 = (com.google.android.gms.internal.measurement.zzfs.zzj) ((com.google.android.gms.internal.measurement.zzju) zzaVar.zzah());
                                if (!zzjVar.zzad().equals(zzjVar2.zzad()) || !zzjVar.zzac().equals(zzjVar2.zzac()) || zzjVar.zzat() != zzjVar2.zzat() || !zzjVar.zzae().equals(zzjVar2.zzae())) {
                                    break;
                                }
                                Iterator<com.google.android.gms.internal.measurement.zzfs.zzn> it2 = zzjVar.zzar().iterator();
                                while (true) {
                                    jZzc = -1;
                                    if (!it2.hasNext()) {
                                        jZzc2 = -1;
                                        break;
                                    }
                                    com.google.android.gms.internal.measurement.zzfs.zzn next = it2.next();
                                    if ("_npa".equals(next.zzg())) {
                                        jZzc2 = next.zzc();
                                        break;
                                    }
                                }
                                for (com.google.android.gms.internal.measurement.zzfs.zzn zznVar : zzjVar2.zzar()) {
                                    if ("_npa".equals(zznVar.zzg())) {
                                        jZzc = zznVar.zzc();
                                        break;
                                    }
                                }
                                if (jZzc2 != jZzc) {
                                    break;
                                }
                            }
                            if (!cursorQuery.isNull(2)) {
                                zzaVar.zzi(cursorQuery.getInt(2));
                            }
                            length += bArrZzc.length;
                            arrayList.add(Pair.create((com.google.android.gms.internal.measurement.zzfs.zzj) ((com.google.android.gms.internal.measurement.zzju) zzaVar.zzah()), Long.valueOf(j)));
                        } catch (IOException e) {
                            zzj().zzg().zza("Failed to merge queued bundle. appId", zzgb.zza(str), e);
                        }
                        if (!cursorQuery.moveToNext() || length > i2) {
                            break;
                        }
                        i3 = 1;
                    } catch (IOException e2) {
                        zzj().zzg().zza("Failed to unzip queued bundle. appId", zzgb.zza(str), e2);
                    }
                }
                cursorQuery.close();
                return arrayList;
            } catch (SQLiteException e3) {
                zzj().zzg().zza("Error querying bundles. appId", zzgb.zza(str), e3);
                List<Pair<com.google.android.gms.internal.measurement.zzfs.zzj, Long>> listEmptyList2 = Collections.emptyList();
                if (0 != 0) {
                    cursor.close();
                }
                return listEmptyList2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public final List<zzac> zza(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zzt();
        zzak();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(str3 + "*");
            sb.append(" and name glob ?");
        }
        return zza(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0172  */
    /* JADX WARN: Multi-variable type inference failed */
    public final List<zzac> zza(String str, String[] strArr) throws Throwable {
        Cursor cursor;
        zzt();
        zzak();
        ArrayList arrayList = new ArrayList();
        try {
            int i = 0;
            int i2 = 5;
            Cursor cursorQuery = e_().query("conditional_properties", new String[]{"app_id", "origin", "name", "value", "active", AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, "timed_out_event", AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, "triggered_event", AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, "expired_event"}, str, strArr, null, null, "rowid", "1001");
            try {
                if (!cursorQuery.moveToFirst()) {
                    cursorQuery.close();
                    return arrayList;
                }
                while (arrayList.size() < 1000) {
                    String string = cursorQuery.getString(i);
                    String string2 = cursorQuery.getString(1);
                    String string3 = cursorQuery.getString(2);
                    Object objZza = zza(cursorQuery, 3);
                    int i3 = cursorQuery.getInt(4) != 0 ? 1 : i;
                    String string4 = cursorQuery.getString(i2);
                    long j = cursorQuery.getLong(6);
                    zznt zzntVarG_ = g_();
                    byte[] blob = cursorQuery.getBlob(7);
                    Parcelable.Creator<zzbf> creator = zzbf.CREATOR;
                    arrayList.add(new zzac(string, string2, new zznv(string3, cursorQuery.getLong(10), objZza, string2), cursorQuery.getLong(8), i3, string4, (zzbf) zzntVarG_.zza(blob, creator), j, (zzbf) g_().zza(cursorQuery.getBlob(9), creator), cursorQuery.getLong(11), (zzbf) g_().zza(cursorQuery.getBlob(12), creator)));
                    if (!cursorQuery.moveToNext()) {
                        cursorQuery.close();
                        return arrayList;
                    }
                    i2 = 5;
                    i = 0;
                }
                zzj().zzg().zza("Read more than the max allowed conditional properties, ignoring extra", 1000);
                cursorQuery.close();
                return arrayList;
            } catch (SQLiteException e) {
                e = e;
                cursor = cursorQuery;
                try {
                    zzj().zzg().zza("Error querying conditional user property value", e);
                    List<zzac> listEmptyList = Collections.emptyList();
                    if (cursor != null) {
                        cursor.close();
                    }
                    return listEmptyList;
                } catch (Throwable th) {
                    th = th;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                cursor = cursorQuery;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (SQLiteException e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
    }

    public final List<zzmy> zzi(String str) {
        Preconditions.checkNotEmpty(str);
        zzt();
        zzak();
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = e_().query("trigger_uris", new String[]{"trigger_uri", "timestamp_millis", "source"}, "app_id=?", new String[]{str}, null, null, "rowid", null);
                if (!cursorQuery.moveToFirst()) {
                    cursorQuery.close();
                    return arrayList;
                }
                do {
                    String string = cursorQuery.getString(0);
                    if (string == null) {
                        string = "";
                    }
                    arrayList.add(new zzmy(string, cursorQuery.getLong(1), cursorQuery.getInt(2)));
                } while (cursorQuery.moveToNext());
                cursorQuery.close();
                return arrayList;
            } catch (SQLiteException e) {
                zzj().zzg().zza("Error querying trigger uris. appId", zzgb.zza(str), e);
                List<zzmy> listEmptyList = Collections.emptyList();
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return listEmptyList;
            }
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00aa  */
    public final List<zznx> zzj(String str) throws Throwable {
        Preconditions.checkNotEmpty(str);
        zzt();
        zzak();
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = e_().query("user_attributes", new String[]{"name", "origin", "set_timestamp", "value"}, "app_id=?", new String[]{str}, null, null, "rowid", "1000");
                if (!cursorQuery.moveToFirst()) {
                    cursorQuery.close();
                    return arrayList;
                }
                do {
                    String string = cursorQuery.getString(0);
                    String string2 = cursorQuery.getString(1);
                    if (string2 == null) {
                        string2 = "";
                    }
                    String str2 = string2;
                    long j = cursorQuery.getLong(2);
                    try {
                        Object objZza = zza(cursorQuery, 3);
                        if (objZza == null) {
                            zzj().zzg().zza("Read invalid user property value, ignoring it. appId", zzgb.zza(str));
                        } else {
                            arrayList.add(new zznx(str, str2, string, j, objZza));
                        }
                    } catch (SQLiteException e) {
                        e = e;
                    }
                } while (cursorQuery.moveToNext());
                cursorQuery.close();
                return arrayList;
            } catch (SQLiteException e2) {
                e = e2;
            } catch (Throwable th) {
                th = th;
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
        zzj().zzg().zza("Error querying user properties. appId", zzgb.zza(str), e);
        List<zznx> listEmptyList = Collections.emptyList();
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return listEmptyList;
    }

    /* JADX WARN: Code duplicated, block: B:51:0x013f  */
    /* JADX WARN: Code duplicated, block: B:55:0x0146  */
    public final List<zznx> zzb(String str, String str2, String str3) throws Throwable {
        String str4;
        Preconditions.checkNotEmpty(str);
        zzt();
        zzak();
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                int i = 3;
                ArrayList arrayList2 = new ArrayList(3);
                try {
                    arrayList2.add(str);
                    StringBuilder sb = new StringBuilder("app_id=?");
                    if (TextUtils.isEmpty(str2)) {
                        str4 = str2;
                    } else {
                        str4 = str2;
                        try {
                            arrayList2.add(str4);
                            sb.append(" and origin=?");
                        } catch (SQLiteException e) {
                            e = e;
                            zzj().zzg().zza("(2)Error querying user properties", zzgb.zza(str), str4, e);
                            List<zznx> listEmptyList = Collections.emptyList();
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            return listEmptyList;
                        }
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        arrayList2.add(str3 + "*");
                        sb.append(" and name glob ?");
                    }
                    int i2 = 0;
                    int i3 = 1;
                    int i4 = 2;
                    cursorQuery = e_().query("user_attributes", new String[]{"name", "set_timestamp", "value", "origin"}, sb.toString(), (String[]) arrayList2.toArray(new String[arrayList2.size()]), null, null, "rowid", "1001");
                    if (!cursorQuery.moveToFirst()) {
                        cursorQuery.close();
                        return arrayList;
                    }
                    while (arrayList.size() < 1000) {
                        String string = cursorQuery.getString(i2);
                        long j = cursorQuery.getLong(i3);
                        try {
                            try {
                                Object objZza = zza(cursorQuery, i4);
                                String string2 = cursorQuery.getString(i);
                                if (objZza == null) {
                                    try {
                                        zzj().zzg().zza("(2)Read invalid user property value, ignoring it", zzgb.zza(str), string2, str3);
                                    } catch (SQLiteException e2) {
                                        e = e2;
                                        string2 = string2;
                                        str4 = string2;
                                        zzj().zzg().zza("(2)Error querying user properties", zzgb.zza(str), str4, e);
                                        List<zznx> listEmptyList2 = Collections.emptyList();
                                        if (cursorQuery != null) {
                                            cursorQuery.close();
                                        }
                                        return listEmptyList2;
                                    }
                                } else {
                                    arrayList.add(new zznx(str, string2, string, j, objZza));
                                }
                                try {
                                    if (!cursorQuery.moveToNext()) {
                                        cursorQuery.close();
                                        return arrayList;
                                    }
                                    i2 = i2;
                                    str4 = string2;
                                    i4 = i4;
                                    i3 = i3;
                                    i = 3;
                                } catch (SQLiteException e3) {
                                    e = e3;
                                    str4 = string2;
                                    zzj().zzg().zza("(2)Error querying user properties", zzgb.zza(str), str4, e);
                                    List<zznx> listEmptyList3 = Collections.emptyList();
                                    if (cursorQuery != null) {
                                        cursorQuery.close();
                                    }
                                    return listEmptyList3;
                                }
                            } catch (SQLiteException e4) {
                                e = e4;
                            }
                        } catch (Throwable th) {
                            th = th;
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            throw th;
                        }
                    }
                    zzj().zzg().zza("Read more than the max allowed user properties, ignoring excess", 1000);
                    cursorQuery.close();
                    return arrayList;
                } catch (SQLiteException e5) {
                    e = e5;
                    str4 = str2;
                    zzj().zzg().zza("(2)Error querying user properties", zzgb.zza(str), str4, e);
                    List<zznx> listEmptyList4 = Collections.emptyList();
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return listEmptyList4;
                }
            } catch (Throwable th2) {
                th = th2;
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                throw th;
            }
        } catch (SQLiteException e6) {
            e = e6;
        }
    }

    final Map<Integer, com.google.android.gms.internal.measurement.zzfs.zzl> zzk(String str) {
        zzak();
        zzt();
        Preconditions.checkNotEmpty(str);
        Cursor cursor = null;
        try {
            try {
                Cursor cursorQuery = e_().query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{str}, null, null, null);
                if (!cursorQuery.moveToFirst()) {
                    Map<Integer, com.google.android.gms.internal.measurement.zzfs.zzl> mapEmptyMap = Collections.emptyMap();
                    cursorQuery.close();
                    return mapEmptyMap;
                }
                ArrayMap arrayMap = new ArrayMap();
                do {
                    int i = cursorQuery.getInt(0);
                    try {
                        arrayMap.put(Integer.valueOf(i), (com.google.android.gms.internal.measurement.zzfs.zzl) ((com.google.android.gms.internal.measurement.zzju) ((com.google.android.gms.internal.measurement.zzfs.zzl.zza) zznt.zza(com.google.android.gms.internal.measurement.zzfs.zzl.zze(), cursorQuery.getBlob(1))).zzah()));
                    } catch (IOException e) {
                        zzj().zzg().zza("Failed to merge filter results. appId, audienceId, error", zzgb.zza(str), Integer.valueOf(i), e);
                    }
                } while (cursorQuery.moveToNext());
                cursorQuery.close();
                return arrayMap;
            } catch (SQLiteException e2) {
                zzj().zzg().zza("Database error querying filter results. appId", zzgb.zza(str), e2);
                Map<Integer, com.google.android.gms.internal.measurement.zzfs.zzl> mapEmptyMap2 = Collections.emptyMap();
                if (0 != 0) {
                    cursor.close();
                }
                return mapEmptyMap2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    final Map<Integer, List<com.google.android.gms.internal.measurement.zzfg.zzb>> zzl(String str) {
        Preconditions.checkNotEmpty(str);
        ArrayMap arrayMap = new ArrayMap();
        Cursor cursor = null;
        try {
            try {
                Cursor cursorQuery = e_().query("event_filters", new String[]{"audience_id", "data"}, "app_id=?", new String[]{str}, null, null, null);
                if (!cursorQuery.moveToFirst()) {
                    Map<Integer, List<com.google.android.gms.internal.measurement.zzfg.zzb>> mapEmptyMap = Collections.emptyMap();
                    cursorQuery.close();
                    return mapEmptyMap;
                }
                do {
                    try {
                        com.google.android.gms.internal.measurement.zzfg.zzb zzbVar = (com.google.android.gms.internal.measurement.zzfg.zzb) ((com.google.android.gms.internal.measurement.zzju) ((com.google.android.gms.internal.measurement.zzfg.zzb.zza) zznt.zza(com.google.android.gms.internal.measurement.zzfg.zzb.zzc(), cursorQuery.getBlob(1))).zzah());
                        if (zzbVar.zzk()) {
                            int i = cursorQuery.getInt(0);
                            List arrayList = (List) arrayMap.get(Integer.valueOf(i));
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                                arrayMap.put(Integer.valueOf(i), arrayList);
                            }
                            arrayList.add(zzbVar);
                        }
                    } catch (IOException e) {
                        zzj().zzg().zza("Failed to merge filter. appId", zzgb.zza(str), e);
                    }
                } while (cursorQuery.moveToNext());
                cursorQuery.close();
                return arrayMap;
            } catch (SQLiteException e2) {
                zzj().zzg().zza("Database error querying filters. appId", zzgb.zza(str), e2);
                Map<Integer, List<com.google.android.gms.internal.measurement.zzfg.zzb>> mapEmptyMap2 = Collections.emptyMap();
                if (0 != 0) {
                    cursor.close();
                }
                return mapEmptyMap2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    final Map<Integer, List<com.google.android.gms.internal.measurement.zzfg.zzb>> zzf(String str, String str2) {
        zzak();
        zzt();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        ArrayMap arrayMap = new ArrayMap();
        Cursor cursor = null;
        try {
            try {
                Cursor cursorQuery = e_().query("event_filters", new String[]{"audience_id", "data"}, "app_id=? AND event_name=?", new String[]{str, str2}, null, null, null);
                if (!cursorQuery.moveToFirst()) {
                    Map<Integer, List<com.google.android.gms.internal.measurement.zzfg.zzb>> mapEmptyMap = Collections.emptyMap();
                    cursorQuery.close();
                    return mapEmptyMap;
                }
                do {
                    try {
                        com.google.android.gms.internal.measurement.zzfg.zzb zzbVar = (com.google.android.gms.internal.measurement.zzfg.zzb) ((com.google.android.gms.internal.measurement.zzju) ((com.google.android.gms.internal.measurement.zzfg.zzb.zza) zznt.zza(com.google.android.gms.internal.measurement.zzfg.zzb.zzc(), cursorQuery.getBlob(1))).zzah());
                        int i = cursorQuery.getInt(0);
                        List arrayList = (List) arrayMap.get(Integer.valueOf(i));
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                            arrayMap.put(Integer.valueOf(i), arrayList);
                        }
                        arrayList.add(zzbVar);
                    } catch (IOException e) {
                        zzj().zzg().zza("Failed to merge filter. appId", zzgb.zza(str), e);
                    }
                } while (cursorQuery.moveToNext());
                cursorQuery.close();
                return arrayMap;
            } catch (SQLiteException e2) {
                zzj().zzg().zza("Database error querying filters. appId", zzgb.zza(str), e2);
                Map<Integer, List<com.google.android.gms.internal.measurement.zzfg.zzb>> mapEmptyMap2 = Collections.emptyMap();
                if (0 != 0) {
                    cursor.close();
                }
                return mapEmptyMap2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    final Map<Integer, List<com.google.android.gms.internal.measurement.zzfg.zze>> zzg(String str, String str2) {
        zzak();
        zzt();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        ArrayMap arrayMap = new ArrayMap();
        Cursor cursor = null;
        try {
            try {
                Cursor cursorQuery = e_().query("property_filters", new String[]{"audience_id", "data"}, "app_id=? AND property_name=?", new String[]{str, str2}, null, null, null);
                if (!cursorQuery.moveToFirst()) {
                    Map<Integer, List<com.google.android.gms.internal.measurement.zzfg.zze>> mapEmptyMap = Collections.emptyMap();
                    cursorQuery.close();
                    return mapEmptyMap;
                }
                do {
                    try {
                        com.google.android.gms.internal.measurement.zzfg.zze zzeVar = (com.google.android.gms.internal.measurement.zzfg.zze) ((com.google.android.gms.internal.measurement.zzju) ((com.google.android.gms.internal.measurement.zzfg.zze.zza) zznt.zza(com.google.android.gms.internal.measurement.zzfg.zze.zzc(), cursorQuery.getBlob(1))).zzah());
                        int i = cursorQuery.getInt(0);
                        List arrayList = (List) arrayMap.get(Integer.valueOf(i));
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                            arrayMap.put(Integer.valueOf(i), arrayList);
                        }
                        arrayList.add(zzeVar);
                    } catch (IOException e) {
                        zzj().zzg().zza("Failed to merge filter", zzgb.zza(str), e);
                    }
                } while (cursorQuery.moveToNext());
                cursorQuery.close();
                return arrayMap;
            } catch (SQLiteException e2) {
                zzj().zzg().zza("Database error querying filters. appId", zzgb.zza(str), e2);
                Map<Integer, List<com.google.android.gms.internal.measurement.zzfg.zze>> mapEmptyMap2 = Collections.emptyMap();
                if (0 != 0) {
                    cursor.close();
                }
                return mapEmptyMap2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    final Map<Integer, List<Integer>> zzm(String str) {
        zzak();
        zzt();
        Preconditions.checkNotEmpty(str);
        ArrayMap arrayMap = new ArrayMap();
        Cursor cursor = null;
        try {
            try {
                Cursor cursorRawQuery = e_().rawQuery("select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;", new String[]{str, str});
                if (!cursorRawQuery.moveToFirst()) {
                    Map<Integer, List<Integer>> mapEmptyMap = Collections.emptyMap();
                    cursorRawQuery.close();
                    return mapEmptyMap;
                }
                do {
                    int i = cursorRawQuery.getInt(0);
                    List arrayList = (List) arrayMap.get(Integer.valueOf(i));
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        arrayMap.put(Integer.valueOf(i), arrayList);
                    }
                    arrayList.add(Integer.valueOf(cursorRawQuery.getInt(1)));
                } while (cursorRawQuery.moveToNext());
                cursorRawQuery.close();
                return arrayMap;
            } catch (SQLiteException e) {
                zzj().zzg().zza("Database error querying scoped filters. appId", zzgb.zza(str), e);
                Map<Integer, List<Integer>> mapEmptyMap2 = Collections.emptyMap();
                if (0 != 0) {
                    cursor.close();
                }
                return mapEmptyMap2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    zzan(zzng zzngVar) {
        super(zzngVar);
        this.zzm = new zzmz(zzb());
        this.zzl = new zzat(this, zza(), "google_app_measurement.db");
    }

    public final void zzp() {
        zzak();
        e_().beginTransaction();
    }

    public final void zzu() {
        zzak();
        e_().endTransaction();
    }

    final void zza(List<Long> list) {
        zzt();
        zzak();
        Preconditions.checkNotNull(list);
        Preconditions.checkNotZero(list.size());
        if (zzan()) {
            String str = "(" + TextUtils.join(",", list) + ")";
            if (zzb("SELECT COUNT(1) FROM queue WHERE rowid IN " + str + " AND retry_count =  2147483647 LIMIT 1", (String[]) null) > 0) {
                zzj().zzu().zza("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                e_().execSQL("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN " + str + " AND (retry_count IS NULL OR retry_count < 2147483647)");
            } catch (SQLiteException e) {
                zzj().zzg().zza("Error incrementing retry count. error", e);
            }
        }
    }

    final void zzv() {
        zzt();
        zzak();
        if (zzan()) {
            long jZza = zzn().zza.zza();
            long jElapsedRealtime = zzb().elapsedRealtime();
            if (Math.abs(jElapsedRealtime - jZza) > zzbh.zzy.zza(null).longValue()) {
                zzn().zza.zza(jElapsedRealtime);
                zzt();
                zzak();
                if (zzan()) {
                    int iDelete = e_().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(zzb().currentTimeMillis()), String.valueOf(zzae.zzm())});
                    if (iDelete > 0) {
                        zzj().zzp().zza("Deleted stale rows. rowsDeleted", Integer.valueOf(iDelete));
                    }
                }
            }
        }
    }

    public final void zzh(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzt();
        zzak();
        try {
            e_().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error deleting user property. appId", zzgb.zza(str), zzi().zzc(str2), e);
        }
    }

    private static void zza(ContentValues contentValues, String str, Object obj) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else {
            if (obj instanceof Double) {
                contentValues.put(str, (Double) obj);
                return;
            }
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    /* JADX WARN: Code duplicated, block: B:104:0x01d3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:109:0x0102 A[EDGE_INSN: B:109:0x0102->B:105:0x0102 BREAK  A[LOOP:5: B:42:0x013e->B:111:?], SYNTHETIC] */
    final void zza(String str, List<com.google.android.gms.internal.measurement.zzfg.zza> list) {
        boolean z;
        boolean z2;
        Preconditions.checkNotNull(list);
        for (int i = 0; i < list.size(); i++) {
            com.google.android.gms.internal.measurement.zzfg.zza.C0029zza c0029zzaZzca = list.get(i).zzca();
            if (c0029zzaZzca.zza() != 0) {
                for (int i2 = 0; i2 < c0029zzaZzca.zza(); i2++) {
                    com.google.android.gms.internal.measurement.zzfg.zzb.zza zzaVarZzca = c0029zzaZzca.zza(i2).zzca();
                    com.google.android.gms.internal.measurement.zzfg.zzb.zza zzaVar = (com.google.android.gms.internal.measurement.zzfg.zzb.zza) ((com.google.android.gms.internal.measurement.zzju.zza) zzaVarZzca.clone());
                    String strZzb = zziv.zzb(zzaVarZzca.zzb());
                    if (strZzb != null) {
                        zzaVar.zza(strZzb);
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    for (int i3 = 0; i3 < zzaVarZzca.zza(); i3++) {
                        com.google.android.gms.internal.measurement.zzfg.zzc zzcVarZza = zzaVarZzca.zza(i3);
                        String strZza = zziu.zza(zzcVarZza.zze());
                        if (strZza != null) {
                            zzaVar.zza(i3, (com.google.android.gms.internal.measurement.zzfg.zzc) ((com.google.android.gms.internal.measurement.zzju) zzcVarZza.zzca().zza(strZza).zzah()));
                            z2 = true;
                        }
                    }
                    if (z2) {
                        c0029zzaZzca = c0029zzaZzca.zza(i2, zzaVar);
                        list.set(i, (com.google.android.gms.internal.measurement.zzfg.zza) ((com.google.android.gms.internal.measurement.zzju) c0029zzaZzca.zzah()));
                    }
                }
            }
            if (c0029zzaZzca.zzb() != 0) {
                for (int i4 = 0; i4 < c0029zzaZzca.zzb(); i4++) {
                    com.google.android.gms.internal.measurement.zzfg.zze zzeVarZzb = c0029zzaZzca.zzb(i4);
                    String strZza2 = zzix.zza(zzeVarZzb.zze());
                    if (strZza2 != null) {
                        c0029zzaZzca = c0029zzaZzca.zza(i4, zzeVarZzb.zzca().zza(strZza2));
                        list.set(i, (com.google.android.gms.internal.measurement.zzfg.zza) ((com.google.android.gms.internal.measurement.zzju) c0029zzaZzca.zzah()));
                    }
                }
            }
        }
        zzak();
        zzt();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(list);
        SQLiteDatabase sQLiteDatabaseE_ = e_();
        sQLiteDatabaseE_.beginTransaction();
        try {
            zzak();
            zzt();
            Preconditions.checkNotEmpty(str);
            SQLiteDatabase sQLiteDatabaseE_2 = e_();
            sQLiteDatabaseE_2.delete("property_filters", "app_id=?", new String[]{str});
            sQLiteDatabaseE_2.delete("event_filters", "app_id=?", new String[]{str});
            for (com.google.android.gms.internal.measurement.zzfg.zza zzaVar2 : list) {
                zzak();
                zzt();
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotNull(zzaVar2);
                if (!zzaVar2.zzg()) {
                    zzj().zzu().zza("Audience with no ID. appId", zzgb.zza(str));
                } else {
                    int iZza = zzaVar2.zza();
                    Iterator<com.google.android.gms.internal.measurement.zzfg.zzb> it2 = zzaVar2.zze().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (!it2.next().zzl()) {
                                zzj().zzu().zza("Event filter with no ID. Audience definition ignored. appId, audienceId", zzgb.zza(str), Integer.valueOf(iZza));
                                break;
                            }
                        } else {
                            Iterator<com.google.android.gms.internal.measurement.zzfg.zze> it3 = zzaVar2.zzf().iterator();
                            while (true) {
                                if (it3.hasNext()) {
                                    if (!it3.next().zzi()) {
                                        zzj().zzu().zza("Property filter with no ID. Audience definition ignored. appId, audienceId", zzgb.zza(str), Integer.valueOf(iZza));
                                        break;
                                    }
                                } else {
                                    Iterator<com.google.android.gms.internal.measurement.zzfg.zzb> it4 = zzaVar2.zze().iterator();
                                    while (true) {
                                        if (it4.hasNext()) {
                                            if (!zza(str, iZza, it4.next())) {
                                                z = false;
                                                break;
                                            }
                                        } else {
                                            z = true;
                                            break;
                                        }
                                    }
                                    if (!z) {
                                        if (z) {
                                            zzak();
                                            zzt();
                                            Preconditions.checkNotEmpty(str);
                                            SQLiteDatabase sQLiteDatabaseE_3 = e_();
                                            sQLiteDatabaseE_3.delete("property_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(iZza)});
                                            sQLiteDatabaseE_3.delete("event_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(iZza)});
                                            break;
                                            break;
                                        }
                                        break;
                                        break;
                                    }
                                    Iterator<com.google.android.gms.internal.measurement.zzfg.zze> it5 = zzaVar2.zzf().iterator();
                                    while (true) {
                                        if (!it5.hasNext()) {
                                            if (z) {
                                                break;
                                            }
                                        } else if (!zza(str, iZza, it5.next())) {
                                        }
                                        zzak();
                                        zzt();
                                        Preconditions.checkNotEmpty(str);
                                        SQLiteDatabase sQLiteDatabaseE_4 = e_();
                                        sQLiteDatabaseE_4.delete("property_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(iZza)});
                                        sQLiteDatabaseE_4.delete("event_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(iZza)});
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            for (com.google.android.gms.internal.measurement.zzfg.zza zzaVar3 : list) {
                arrayList.add(zzaVar3.zzg() ? Integer.valueOf(zzaVar3.zza()) : null);
            }
            zzb(str, arrayList);
            sQLiteDatabaseE_.setTransactionSuccessful();
        } finally {
            sQLiteDatabaseE_.endTransaction();
        }
    }

    public final void zzw() {
        zzak();
        e_().setTransactionSuccessful();
    }

    public final void zza(zzf zzfVar) {
        Preconditions.checkNotNull(zzfVar);
        zzt();
        zzak();
        String strZzac = zzfVar.zzac();
        Preconditions.checkNotNull(strZzac);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", strZzac);
        if (!zzod.zza() || !zze().zza(zzbh.zzdg) || this.zzf.zzb(strZzac).zza(zzis.zza.ANALYTICS_STORAGE) || zzfVar.zzad() == null) {
            contentValues.put("app_instance_id", zzfVar.zzad());
        }
        contentValues.put("gmp_app_id", zzfVar.zzah());
        if (!zzod.zza() || !zze().zza(zzbh.zzdg) || this.zzf.zzb(strZzac).zza(zzis.zza.AD_STORAGE)) {
            contentValues.put("resettable_device_id_hash", zzfVar.zzaj());
        }
        contentValues.put("last_bundle_index", Long.valueOf(zzfVar.zzt()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(zzfVar.zzu()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(zzfVar.zzs()));
        contentValues.put("app_version", zzfVar.zzaf());
        contentValues.put("app_store", zzfVar.zzae());
        contentValues.put("gmp_version", Long.valueOf(zzfVar.zzq()));
        contentValues.put("dev_cert_hash", Long.valueOf(zzfVar.zzn()));
        contentValues.put("measurement_enabled", Boolean.valueOf(zzfVar.zzar()));
        contentValues.put("day", Long.valueOf(zzfVar.zzm()));
        contentValues.put("daily_public_events_count", Long.valueOf(zzfVar.zzk()));
        contentValues.put("daily_events_count", Long.valueOf(zzfVar.zzj()));
        contentValues.put("daily_conversions_count", Long.valueOf(zzfVar.zzh()));
        contentValues.put("config_fetched_time", Long.valueOf(zzfVar.zzg()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(zzfVar.zzp()));
        contentValues.put("app_version_int", Long.valueOf(zzfVar.zze()));
        contentValues.put("firebase_instance_id", zzfVar.zzag());
        contentValues.put("daily_error_events_count", Long.valueOf(zzfVar.zzi()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(zzfVar.zzl()));
        contentValues.put("health_monitor_sample", zzfVar.zzai());
        contentValues.put("android_id", Long.valueOf(zzfVar.zzd()));
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(zzfVar.zzaq()));
        contentValues.put("admob_app_id", zzfVar.zzaa());
        contentValues.put("dynamite_version", Long.valueOf(zzfVar.zzo()));
        if (!zzod.zza() || !zze().zza(zzbh.zzdg) || this.zzf.zzb(strZzac).zza(zzis.zza.ANALYTICS_STORAGE) || zzfVar.zzal() == null) {
            contentValues.put("session_stitching_token", zzfVar.zzal());
        }
        contentValues.put("sgtm_upload_enabled", Boolean.valueOf(zzfVar.zzat()));
        contentValues.put("target_os_version", Long.valueOf(zzfVar.zzw()));
        contentValues.put("session_stitching_token_hash", Long.valueOf(zzfVar.zzv()));
        if (zzpz.zza() && zze().zze(strZzac, zzbh.zzcg)) {
            contentValues.put("ad_services_version", Integer.valueOf(zzfVar.zza()));
            contentValues.put("attribution_eligibility_status", Long.valueOf(zzfVar.zzf()));
        }
        if (zzoi.zza() && zze().zze(strZzac, zzbh.zzcs)) {
            contentValues.put("unmatched_first_open_without_ad_id", Boolean.valueOf(zzfVar.zzau()));
        }
        contentValues.put("npa_metadata_value", zzfVar.zzx());
        if (zzqw.zza() && zze().zze(strZzac, zzbh.zzbt)) {
            zzq();
            if (zznw.zzf(strZzac)) {
                contentValues.put("bundle_delivery_index", Long.valueOf(zzfVar.zzr()));
            }
        }
        if (zzqw.zza() && zze().zze(strZzac, zzbh.zzbu)) {
            contentValues.put("sgtm_preview_key", zzfVar.zzam());
        }
        if (zzoo.zza() && zze().zze(strZzac, zzbh.zzcr)) {
            contentValues.put("dma_consent_state", Integer.valueOf(zzfVar.zzc()));
            contentValues.put("daily_realtime_dcu_count", Integer.valueOf(zzfVar.zzb()));
        }
        if (com.google.android.gms.internal.measurement.zznx.zza() && zze().zze(strZzac, zzbh.zzcz)) {
            contentValues.put("serialized_npa_metadata", zzfVar.zzak());
        }
        List<String> listZzan = zzfVar.zzan();
        if (listZzan != null) {
            if (listZzan.isEmpty()) {
                zzj().zzu().zza("Safelisted events should not be an empty list. appId", strZzac);
            } else {
                contentValues.put("safelisted_events", TextUtils.join(",", listZzan));
            }
        }
        if (zzop.zza() && zze().zza(zzbh.zzbo) && !contentValues.containsKey("safelisted_events")) {
            contentValues.put("safelisted_events", (String) null);
        }
        if (zze().zza(zzbh.zzdd)) {
            contentValues.put("unmatched_pfo", zzfVar.zzy());
            contentValues.put("unmatched_uwa", zzfVar.zzz());
        }
        try {
            SQLiteDatabase sQLiteDatabaseE_ = e_();
            if (sQLiteDatabaseE_.update("apps", contentValues, "app_id = ?", new String[]{strZzac}) == 0 && sQLiteDatabaseE_.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                zzj().zzg().zza("Failed to insert/update app (got -1). appId", zzgb.zza(strZzac));
            }
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing app. appId", zzgb.zza(strZzac), e);
        }
    }

    public final void zza(String str, zzis zzisVar) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzisVar);
        zzt();
        zzak();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("consent_state", zzisVar.zzh());
        contentValues.put("consent_source", Integer.valueOf(zzisVar.zza()));
        zza("consent_settings", "app_id", contentValues);
    }

    public final void zza(String str, zzax zzaxVar) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzaxVar);
        zzt();
        zzak();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("dma_consent_settings", zzaxVar.zzf());
        zza("consent_settings", "app_id", contentValues);
    }

    public final void zza(zzbb zzbbVar) {
        Preconditions.checkNotNull(zzbbVar);
        zzt();
        zzak();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzbbVar.zza);
        contentValues.put("name", zzbbVar.zzb);
        contentValues.put("lifetime_count", Long.valueOf(zzbbVar.zzc));
        contentValues.put("current_bundle_count", Long.valueOf(zzbbVar.zzd));
        contentValues.put("last_fire_timestamp", Long.valueOf(zzbbVar.zzf));
        contentValues.put("last_bundled_timestamp", Long.valueOf(zzbbVar.zzg));
        contentValues.put("last_bundled_day", zzbbVar.zzh);
        contentValues.put("last_sampled_complex_event_id", zzbbVar.zzi);
        contentValues.put("last_sampling_rate", zzbbVar.zzj);
        contentValues.put("current_session_count", Long.valueOf(zzbbVar.zze));
        Boolean bool = zzbbVar.zzk;
        contentValues.put("last_exempt_from_sampling", (bool == null || !bool.booleanValue()) ? null : 1L);
        try {
            if (e_().insertWithOnConflict("events", null, contentValues, 5) == -1) {
                zzj().zzg().zza("Failed to insert/update event aggregates (got -1). appId", zzgb.zza(zzbbVar.zza));
            }
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing event aggregates. appId", zzgb.zza(zzbbVar.zza), e);
        }
    }

    private final void zza(String str, String str2, ContentValues contentValues) {
        try {
            SQLiteDatabase sQLiteDatabaseE_ = e_();
            String asString = contentValues.getAsString(str2);
            if (asString == null) {
                zzj().zzh().zza("Value of the primary key is not set.", zzgb.zza(str2));
                return;
            }
            if (sQLiteDatabaseE_.update(str, contentValues, str2 + " = ?", new String[]{asString}) == 0 && sQLiteDatabaseE_.insertWithOnConflict(str, null, contentValues, 5) == -1) {
                zzj().zzg().zza("Failed to insert/update table (got -1). key", zzgb.zza(str), zzgb.zza(str2));
            }
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing into table. key", zzgb.zza(str), zzgb.zza(str2), e);
        }
    }

    private final boolean zzb(String str, List<Integer> list) {
        Preconditions.checkNotEmpty(str);
        zzak();
        zzt();
        SQLiteDatabase sQLiteDatabaseE_ = e_();
        try {
            long jZzb = zzb("select count(1) from audience_filter_values where app_id=?", new String[]{str});
            int iMax = Math.max(0, Math.min(Constants.MAX_URL_LENGTH, zze().zzb(str, zzbh.zzaf)));
            if (jZzb <= iMax) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                Integer num = list.get(i);
                if (num == null) {
                    return false;
                }
                arrayList.add(Integer.toString(num.intValue()));
            }
            String str2 = "(" + TextUtils.join(",", arrayList) + ")";
            StringBuilder sb = new StringBuilder("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ");
            sb.append(str2);
            sb.append(" order by rowid desc limit -1 offset ?)");
            return sQLiteDatabaseE_.delete("audience_filter_values", sb.toString(), new String[]{str, Integer.toString(iMax)}) > 0;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Database error querying filters. appId", zzgb.zza(str), e);
            return false;
        }
    }

    public final boolean zzx() {
        return zzb("select count(1) > 0 from raw_events", (String[]) null) != 0;
    }

    public final boolean zzy() {
        return zzb("select count(1) > 0 from queue where has_realtime = 1", (String[]) null) != 0;
    }

    public final boolean zzz() {
        return zzb("select count(1) > 0 from raw_events where realtime = 1", (String[]) null) != 0;
    }

    public final boolean zza(com.google.android.gms.internal.measurement.zzfs.zzj zzjVar, boolean z) {
        zzt();
        zzak();
        Preconditions.checkNotNull(zzjVar);
        Preconditions.checkNotEmpty(zzjVar.zzy());
        Preconditions.checkState(zzjVar.zzbg());
        zzv();
        long jCurrentTimeMillis = zzb().currentTimeMillis();
        if (zzjVar.zzm() < jCurrentTimeMillis - zzae.zzm() || zzjVar.zzm() > zzae.zzm() + jCurrentTimeMillis) {
            zzj().zzu().zza("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzgb.zza(zzjVar.zzy()), Long.valueOf(jCurrentTimeMillis), Long.valueOf(zzjVar.zzm()));
        }
        try {
            byte[] bArrZzb = g_().zzb(zzjVar.zzbx());
            zzj().zzp().zza("Saving bundle, size", Integer.valueOf(bArrZzb.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzjVar.zzy());
            contentValues.put("bundle_end_timestamp", Long.valueOf(zzjVar.zzm()));
            contentValues.put("data", bArrZzb);
            contentValues.put("has_realtime", Integer.valueOf(z ? 1 : 0));
            if (zzjVar.zzbn()) {
                contentValues.put("retry_count", Integer.valueOf(zzjVar.zzg()));
            }
            try {
                if (e_().insert("queue", null, contentValues) != -1) {
                    return true;
                }
                zzj().zzg().zza("Failed to insert bundle (got -1). appId", zzgb.zza(zzjVar.zzy()));
                return false;
            } catch (SQLiteException e) {
                zzj().zzg().zza("Error storing bundle. appId", zzgb.zza(zzjVar.zzy()), e);
                return false;
            }
        } catch (IOException e2) {
            zzj().zzg().zza("Data loss. Failed to serialize bundle. appId", zzgb.zza(zzjVar.zzy()), e2);
            return false;
        }
    }

    private final boolean zza(String str, int i, com.google.android.gms.internal.measurement.zzfg.zzb zzbVar) {
        zzak();
        zzt();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzbVar);
        if (zzbVar.zzf().isEmpty()) {
            zzj().zzu().zza("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", zzgb.zza(str), Integer.valueOf(i), String.valueOf(zzbVar.zzl() ? Integer.valueOf(zzbVar.zzb()) : null));
            return false;
        }
        byte[] bArrZzbx = zzbVar.zzbx();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i));
        contentValues.put("filter_id", zzbVar.zzl() ? Integer.valueOf(zzbVar.zzb()) : null);
        contentValues.put("event_name", zzbVar.zzf());
        contentValues.put("session_scoped", zzbVar.zzm() ? Boolean.valueOf(zzbVar.zzj()) : null);
        contentValues.put("data", bArrZzbx);
        try {
            if (e_().insertWithOnConflict("event_filters", null, contentValues, 5) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert event filter (got -1). appId", zzgb.zza(str));
            return true;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing event filter. appId", zzgb.zza(str), e);
            return false;
        }
    }

    private final boolean zza(String str, int i, com.google.android.gms.internal.measurement.zzfg.zze zzeVar) {
        zzak();
        zzt();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzeVar);
        if (zzeVar.zze().isEmpty()) {
            zzj().zzu().zza("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", zzgb.zza(str), Integer.valueOf(i), String.valueOf(zzeVar.zzi() ? Integer.valueOf(zzeVar.zza()) : null));
            return false;
        }
        byte[] bArrZzbx = zzeVar.zzbx();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i));
        contentValues.put("filter_id", zzeVar.zzi() ? Integer.valueOf(zzeVar.zza()) : null);
        contentValues.put("property_name", zzeVar.zze());
        contentValues.put("session_scoped", zzeVar.zzj() ? Boolean.valueOf(zzeVar.zzh()) : null);
        contentValues.put("data", bArrZzbx);
        try {
            if (e_().insertWithOnConflict("property_filters", null, contentValues, 5) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert property filter (got -1). appId", zzgb.zza(str));
            return false;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing property filter. appId", zzgb.zza(str), e);
            return false;
        }
    }

    public final boolean zza(zzay zzayVar, long j, boolean z) {
        zzt();
        zzak();
        Preconditions.checkNotNull(zzayVar);
        Preconditions.checkNotEmpty(zzayVar.zza);
        byte[] bArrZzbx = g_().zza(zzayVar).zzbx();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzayVar.zza);
        contentValues.put("name", zzayVar.zzb);
        contentValues.put("timestamp", Long.valueOf(zzayVar.zzc));
        contentValues.put("metadata_fingerprint", Long.valueOf(j));
        contentValues.put("data", bArrZzbx);
        contentValues.put("realtime", Integer.valueOf(z ? 1 : 0));
        try {
            if (e_().insert("raw_events", null, contentValues) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert raw event (got -1). appId", zzgb.zza(zzayVar.zza));
            return false;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing raw event. appId", zzgb.zza(zzayVar.zza), e);
            return false;
        }
    }

    public final boolean zza(String str, zzmy zzmyVar) {
        zzt();
        zzak();
        Preconditions.checkNotNull(zzmyVar);
        Preconditions.checkNotEmpty(str);
        long jCurrentTimeMillis = zzb().currentTimeMillis();
        if (zzmyVar.zzb < jCurrentTimeMillis - zzae.zzm() || zzmyVar.zzb > zzae.zzm() + jCurrentTimeMillis) {
            zzj().zzu().zza("Storing trigger URI outside of the max retention time span. appId, now, timestamp", zzgb.zza(str), Long.valueOf(jCurrentTimeMillis), Long.valueOf(zzmyVar.zzb));
        }
        zzj().zzp().zza("Saving trigger URI");
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("trigger_uri", zzmyVar.zza);
        contentValues.put("source", Integer.valueOf(zzmyVar.zzc));
        contentValues.put("timestamp_millis", Long.valueOf(zzmyVar.zzb));
        try {
            if (e_().insert("trigger_uris", null, contentValues) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert trigger URI (got -1). appId", zzgb.zza(str));
            return false;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing trigger URI. appId", zzgb.zza(str), e);
            return false;
        }
    }

    private final boolean zzan() {
        return zza().getDatabasePath("google_app_measurement.db").exists();
    }

    public final boolean zza(String str, Long l, long j, com.google.android.gms.internal.measurement.zzfs.zze zzeVar) {
        zzt();
        zzak();
        Preconditions.checkNotNull(zzeVar);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(l);
        byte[] bArrZzbx = zzeVar.zzbx();
        zzj().zzp().zza("Saving complex main event, appId, data size", zzi().zza(str), Integer.valueOf(bArrZzbx.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("event_id", l);
        contentValues.put("children_to_process", Long.valueOf(j));
        contentValues.put("main_event", bArrZzbx);
        try {
            if (e_().insertWithOnConflict("main_event_params", null, contentValues, 5) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert complex main event (got -1). appId", zzgb.zza(str));
            return false;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing complex main event. appId", zzgb.zza(str), e);
            return false;
        }
    }

    public final boolean zza(zzac zzacVar) {
        Preconditions.checkNotNull(zzacVar);
        zzt();
        zzak();
        String str = zzacVar.zza;
        Preconditions.checkNotNull(str);
        if (zze(str, zzacVar.zzc.zza) == null && zzb("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{str}) >= 1000) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("origin", zzacVar.zzb);
        contentValues.put("name", zzacVar.zzc.zza);
        zza(contentValues, "value", Preconditions.checkNotNull(zzacVar.zzc.zza()));
        contentValues.put("active", Boolean.valueOf(zzacVar.zze));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, zzacVar.zzf);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.valueOf(zzacVar.zzh));
        zzq();
        contentValues.put("timed_out_event", zznw.zza((Parcelable) zzacVar.zzg));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzacVar.zzd));
        zzq();
        contentValues.put("triggered_event", zznw.zza((Parcelable) zzacVar.zzi));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, Long.valueOf(zzacVar.zzc.zzb));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.valueOf(zzacVar.zzj));
        zzq();
        contentValues.put("expired_event", zznw.zza((Parcelable) zzacVar.zzk));
        try {
            if (e_().insertWithOnConflict("conditional_properties", null, contentValues, 5) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert/update conditional user property (got -1)", zzgb.zza(str));
            return true;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing conditional user property", zzgb.zza(str), e);
            return true;
        }
    }

    final boolean zza(String str, Bundle bundle) {
        zzt();
        zzak();
        byte[] bArrZzbx = g_().zza(new zzay(this.zzu, "", str, "dep", 0L, 0L, bundle)).zzbx();
        zzj().zzp().zza("Saving default event parameters, appId, data size", zzi().zza(str), Integer.valueOf(bArrZzbx.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("parameters", bArrZzbx);
        try {
            if (e_().insertWithOnConflict("default_event_params", null, contentValues, 5) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert default event parameters (got -1). appId", zzgb.zza(str));
            return false;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing default event parameters. appId", zzgb.zza(str), e);
            return false;
        }
    }

    public final boolean zza(zznx zznxVar) {
        Preconditions.checkNotNull(zznxVar);
        zzt();
        zzak();
        if (zze(zznxVar.zza, zznxVar.zzc) == null) {
            if (zznw.zzh(zznxVar.zzc)) {
                if (zzb("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{zznxVar.zza}) >= zze().zza(zznxVar.zza, zzbh.zzag, 25, 100)) {
                    return false;
                }
            } else if (!"_npa".equals(zznxVar.zzc) && zzb("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{zznxVar.zza, zznxVar.zzb}) >= 25) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zznxVar.zza);
        contentValues.put("origin", zznxVar.zzb);
        contentValues.put("name", zznxVar.zzc);
        contentValues.put("set_timestamp", Long.valueOf(zznxVar.zzd));
        zza(contentValues, "value", zznxVar.zze);
        try {
            if (e_().insertWithOnConflict("user_attributes", null, contentValues, 5) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert/update user property (got -1). appId", zzgb.zza(zznxVar.zza));
            return true;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing user property. appId", zzgb.zza(zznxVar.zza), e);
            return true;
        }
    }
}
