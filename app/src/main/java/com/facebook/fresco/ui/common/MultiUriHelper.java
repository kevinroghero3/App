package com.facebook.fresco.ui.common;

import android.net.Uri;
import com.facebook.common.internal.Fn;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class MultiUriHelper {
    public static final MultiUriHelper INSTANCE = new MultiUriHelper();

    private MultiUriHelper() {
    }

    @JvmStatic
    public static final <T> Uri getMainUri(@Nullable T t, @Nullable T t2, @Nullable T[] tArr, @NotNull Fn<T, Uri> requestToUri) {
        Intrinsics.checkNotNullParameter(requestToUri, "requestToUri");
        Uri uriApply = t != null ? requestToUri.apply(t) : null;
        if (uriApply != null) {
            return uriApply;
        }
        if (tArr != null && tArr.length != 0) {
            T t3 = tArr[0];
            Uri uriApply2 = t3 != null ? requestToUri.apply(t3) : null;
            if (uriApply2 != null) {
                return uriApply2;
            }
        }
        if (t2 != null) {
            return requestToUri.apply(t2);
        }
        return null;
    }
}
