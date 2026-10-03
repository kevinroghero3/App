package com.google.android.gms.internal.auth;

import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;
import io.sentry.android.core.SentryLogcatAdapter;
import java.io.UnsupportedEncodingException;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: loaded from: classes4.dex */
public abstract class zzbz extends FastSafeParcelableJsonResponse {
    @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse
    public final byte[] toByteArray() {
        try {
            return toString().getBytes(CharEncoding.UTF_8);
        } catch (UnsupportedEncodingException e) {
            SentryLogcatAdapter.e("AUTH", "Error serializing object.", e);
            return null;
        }
    }
}
