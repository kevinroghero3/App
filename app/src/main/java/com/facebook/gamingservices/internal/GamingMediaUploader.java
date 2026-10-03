package com.facebook.gamingservices.internal;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestAsyncTask;
import com.facebook.HttpMethod;
import com.facebook.internal.Utility;
import com.facebook.share.internal.ShareConstants;
import java.io.File;
import java.io.FileNotFoundException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class GamingMediaUploader {
    public static final GamingMediaUploader INSTANCE = new GamingMediaUploader();
    private static final String photoUploadEdge = "me/photos";

    private GamingMediaUploader() {
    }

    @JvmStatic
    public static final GraphRequestAsyncTask uploadToGamingServices(@Nullable String str, @NotNull Bitmap imageBitmap, @Nullable Bundle bundle, @Nullable GraphRequest.Callback callback) {
        Intrinsics.checkNotNullParameter(imageBitmap, "imageBitmap");
        return GraphRequest.Companion.newUploadPhotoRequest(AccessToken.Companion.getCurrentAccessToken(), photoUploadEdge, imageBitmap, str, bundle, callback).executeAsync();
    }

    @JvmStatic
    public static final GraphRequestAsyncTask uploadToGamingServices(@Nullable String str, @NotNull File imageFile, @Nullable Bundle bundle, @Nullable GraphRequest.Callback callback) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter(imageFile, "imageFile");
        return GraphRequest.Companion.newUploadPhotoRequest(AccessToken.Companion.getCurrentAccessToken(), photoUploadEdge, imageFile, str, bundle, callback).executeAsync();
    }

    @JvmStatic
    public static final GraphRequestAsyncTask uploadToGamingServices(@Nullable String str, @NotNull Uri imageUri, @Nullable Bundle bundle, @Nullable GraphRequest.Callback callback) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter(imageUri, "imageUri");
        if (Utility.isFileUri(imageUri) || Utility.isContentUri(imageUri)) {
            return GraphRequest.Companion.newUploadPhotoRequest(AccessToken.Companion.getCurrentAccessToken(), photoUploadEdge, imageUri, str, bundle, callback).executeAsync();
        }
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        bundle2.putString("url", imageUri.toString());
        if (str != null && str.length() != 0) {
            bundle2.putString(ShareConstants.FEED_CAPTION_PARAM, str);
        }
        return new GraphRequest(AccessToken.Companion.getCurrentAccessToken(), photoUploadEdge, bundle2, HttpMethod.POST, callback, null, 32, null).executeAsync();
    }
}
