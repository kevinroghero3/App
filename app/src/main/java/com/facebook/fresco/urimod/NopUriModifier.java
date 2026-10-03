package com.facebook.fresco.urimod;

import android.net.Uri;
import com.facebook.common.callercontext.ContextChain;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.fresco.vito.source.UriImageSource;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class NopUriModifier implements UriModifierInterface {
    public static final NopUriModifier INSTANCE = new NopUriModifier();

    @Override // com.facebook.fresco.urimod.UriModifierInterface
    public Uri modifyPrefetchUri(@NotNull Uri uri, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return uri;
    }

    @Override // com.facebook.fresco.urimod.UriModifierInterface
    public void unregisterReverseFallbackUri(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
    }

    private NopUriModifier() {
    }

    @Override // com.facebook.fresco.urimod.UriModifierInterface
    public UriModifierInterface.ModificationResult modifyUri(@NotNull UriImageSource imageSource, @Nullable Dimensions dimensions, @Nullable ScalingUtils.ScaleType scaleType, @Nullable Object obj, @Nullable ContextChain contextChain, boolean z) {
        Intrinsics.checkNotNullParameter(imageSource, "imageSource");
        return new UriModifierInterface.ModificationResult.Disabled("NopUriModifier");
    }
}
