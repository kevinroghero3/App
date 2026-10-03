package com.facebook.fresco.vito.source;

import android.net.Uri;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface SingleImageSource extends UriImageSource {
    String getStringExtra(@NotNull String str);

    Uri getUri();
}
