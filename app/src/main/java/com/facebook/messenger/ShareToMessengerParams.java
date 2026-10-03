package com.facebook.messenger;

import android.net.Uri;
import com.facebook.common.util.UriUtil;
import java.util.HashSet;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class ShareToMessengerParams {
    public static final Companion Companion = new Companion(null);
    private static final Set<String> VALID_EXTERNAL_URI_SCHEMES;
    private static final Set<String> VALID_MIME_TYPES;
    private static final Set<String> VALID_URI_SCHEMES;
    private final Uri externalUri;
    private final String metaData;
    private final String mimeType;
    private final Uri uri;

    @JvmStatic
    public static final ShareToMessengerParamsBuilder newBuilder(@NotNull Uri uri, @NotNull String str) {
        return Companion.newBuilder(uri, str);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Set<String> getVALID_URI_SCHEMES() {
            return ShareToMessengerParams.VALID_URI_SCHEMES;
        }

        public final Set<String> getVALID_MIME_TYPES() {
            return ShareToMessengerParams.VALID_MIME_TYPES;
        }

        public final Set<String> getVALID_EXTERNAL_URI_SCHEMES() {
            return ShareToMessengerParams.VALID_EXTERNAL_URI_SCHEMES;
        }

        @JvmStatic
        public final ShareToMessengerParamsBuilder newBuilder(@NotNull Uri uri, @NotNull String mimeType) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            Intrinsics.checkNotNullParameter(mimeType, "mimeType");
            return new ShareToMessengerParamsBuilder(uri, mimeType);
        }
    }

    public ShareToMessengerParams(@NotNull ShareToMessengerParamsBuilder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        Uri uri = builder.getUri();
        if (uri == null) {
            throw new IllegalStateException("Must provide non-null uri");
        }
        this.uri = uri;
        String mimeType = builder.getMimeType();
        if (mimeType == null) {
            throw new IllegalStateException("Must provide mimeType");
        }
        this.mimeType = mimeType;
        this.metaData = builder.getMetaData();
        Uri externalUri = builder.getExternalUri();
        this.externalUri = externalUri;
        if (!CollectionsKt___CollectionsKt.contains(VALID_URI_SCHEMES, uri.getScheme())) {
            throw new IllegalArgumentException(("Unsupported URI scheme: " + uri.getScheme()).toString());
        }
        if (!VALID_MIME_TYPES.contains(mimeType)) {
            throw new IllegalArgumentException(("Unsupported mime-type: " + mimeType).toString());
        }
        if (externalUri == null || CollectionsKt___CollectionsKt.contains(VALID_EXTERNAL_URI_SCHEMES, externalUri.getScheme())) {
            return;
        }
        throw new IllegalArgumentException(("Unsupported external uri scheme: " + externalUri.getScheme()).toString());
    }

    static {
        HashSet hashSet = new HashSet();
        hashSet.add("image/*");
        hashSet.add("image/jpeg");
        hashSet.add("image/png");
        hashSet.add("image/gif");
        hashSet.add("image/webp");
        hashSet.add("video/*");
        hashSet.add("video/mp4");
        hashSet.add("audio/*");
        hashSet.add("audio/mpeg");
        VALID_MIME_TYPES = CollectionsKt___CollectionsKt.toSet(hashSet);
        HashSet hashSet2 = new HashSet();
        hashSet2.add("content");
        hashSet2.add(UriUtil.QUALIFIED_RESOURCE_SCHEME);
        hashSet2.add("file");
        VALID_URI_SCHEMES = CollectionsKt___CollectionsKt.toSet(hashSet2);
        HashSet hashSet3 = new HashSet();
        hashSet3.add("http");
        hashSet3.add("https");
        VALID_EXTERNAL_URI_SCHEMES = CollectionsKt___CollectionsKt.toSet(hashSet3);
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final String getMetaData() {
        return this.metaData;
    }

    public final Uri getExternalUri() {
        return this.externalUri;
    }
}
