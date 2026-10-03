package com.salesforce.marketingcloud.sfmcsdk;

import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.salesforce.marketingcloud.sfmcsdk.components.behaviors.LifecycleListener;
import io.sentry.android.core.performance.AppStartMetrics;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class SFMCSdkInitContentProvider extends ContentProvider {
    @Override // android.content.ContentProvider
    public int delete(@NotNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(@NotNull Uri uri, @Nullable ContentValues contentValues) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public Cursor query(@NotNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(@NotNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return 0;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        Context applicationContext;
        AppStartMetrics.onContentProviderCreate(this);
        Context context = getContext();
        if (context != null && (applicationContext = context.getApplicationContext()) != null) {
            SFMCSdk.Companion.getBehaviorManager$sfmcsdk_release().initIfNecessary$sfmcsdk_release(applicationContext);
            Lifecycle lifecycle = ProcessLifecycleOwner.Companion.get().getLifecycle();
            LifecycleListener.Companion companion = LifecycleListener.Companion;
            lifecycle.addObserver(companion.getInstance(applicationContext));
            ((Application) applicationContext).registerActivityLifecycleCallbacks(companion.getInstance(applicationContext));
        }
        AppStartMetrics.onContentProviderPostCreate(this);
        return true;
    }
}
