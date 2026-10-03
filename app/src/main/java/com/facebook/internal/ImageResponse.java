package com.facebook.internal;

import android.graphics.Bitmap;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class ImageResponse {
    private final Bitmap bitmap;
    private final Exception error;
    private final boolean isCachedRedirect;
    private final ImageRequest request;

    public ImageResponse(@NotNull ImageRequest request, @Nullable Exception exc, boolean z, @Nullable Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(request, "request");
        this.request = request;
        this.error = exc;
        this.isCachedRedirect = z;
        this.bitmap = bitmap;
    }

    public final ImageRequest getRequest() {
        return this.request;
    }

    public final Exception getError() {
        return this.error;
    }

    public final boolean isCachedRedirect() {
        return this.isCachedRedirect;
    }

    public final Bitmap getBitmap() {
        return this.bitmap;
    }
}
