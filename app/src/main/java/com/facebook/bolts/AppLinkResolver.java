package com.facebook.bolts;

import android.net.Uri;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface AppLinkResolver {
    Task<AppLink> getAppLinkFromUrlInBackground(@NotNull Uri uri);
}
