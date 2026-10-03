package com.facebook.imagepipeline.xml;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.core.content.res.ResourcesCompat;
import com.facebook.common.logging.FLog;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.DefaultCloseableXml;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.QualityInfo;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public final class XmlFormatDecoder implements ImageDecoder {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "XmlFormatDecoder";
    private final Map<String, Integer> resourceIdCache;
    private final Resources resources;

    public XmlFormatDecoder(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.resources = resources;
        this.resourceIdCache = new ConcurrentHashMap();
    }

    @Override // com.facebook.imagepipeline.decoder.ImageDecoder
    public CloseableImage decode(@NotNull EncodedImage encodedImage, int i, @NotNull QualityInfo qualityInfo, @NotNull ImageDecodeOptions options) {
        Intrinsics.checkNotNullParameter(encodedImage, "encodedImage");
        Intrinsics.checkNotNullParameter(qualityInfo, "qualityInfo");
        Intrinsics.checkNotNullParameter(options, "options");
        try {
            String source = encodedImage.getSource();
            if (source == null) {
                throw new IllegalStateException("No source in encoded image");
            }
            Drawable drawable = ResourcesCompat.getDrawable(this.resources, getXmlResourceId(source), null);
            if (drawable != null) {
                return new DefaultCloseableXml(drawable);
            }
            return null;
        } catch (Throwable th) {
            FLog.e(TAG, "Cannot decode xml", th);
            return null;
        }
    }

    private final int getXmlResourceId(String str) {
        Map<String, Integer> map = this.resourceIdCache;
        Integer numValueOf = map.get(str);
        if (numValueOf == null) {
            Uri uri = Uri.parse(str);
            Intrinsics.checkNotNullExpressionValue(uri, "parse(...)");
            numValueOf = Integer.valueOf(parseImageSourceResourceId(uri));
            map.put(str, numValueOf);
        }
        return numValueOf.intValue();
    }

    private final int parseImageSourceResourceId(Uri uri) {
        Integer intOrNull;
        if (UriUtil.isLocalResourceUri(uri) || UriUtil.isQualifiedResourceUri(uri)) {
            List<String> pathSegments = uri.getPathSegments();
            Intrinsics.checkNotNullExpressionValue(pathSegments, "getPathSegments(...)");
            String str = (String) CollectionsKt___CollectionsKt.lastOrNull((List) pathSegments);
            if (str != null && (intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(str)) != null) {
                return intOrNull.intValue();
            }
            throw new IllegalStateException(("Unable to read resource ID from " + uri.getPath()).toString());
        }
        throw new IllegalStateException(("Unsupported uri " + uri).toString());
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
