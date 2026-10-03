package com.google.android.gms.measurement;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzho;
import io.sentry.android.core.performance.AppStartMetrics;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class AppMeasurementContentProvider extends ContentProvider {
    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, @Nullable String str, @NonNull String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(@NonNull Uri uri, @NonNull ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Cursor query(@NonNull Uri uri, @NonNull String[] strArr, @Nullable String str, @NonNull String[] strArr2, @Nullable String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @NonNull String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public void attachInfo(@NonNull Context context, @NonNull ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if ("com.google.android.gms.measurement.google_measurement_service".equals(providerInfo.authority)) {
            throw new IllegalStateException("Incorrect provider authority in manifest. Most likely due to a missing applicationId variable in application's build.gradle.");
        }
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        AppStartMetrics.onContentProviderCreate(this);
        Context context = getContext();
        Preconditions.checkNotNull(context);
        zzho.zza(context, null, null);
        AppStartMetrics.onContentProviderPostCreate(this);
        return false;
    }
}
