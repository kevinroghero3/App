package com.facebook.imagepipeline.xml;

import android.graphics.drawable.Drawable;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableXml;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public final class XmlDrawableFactory implements DrawableFactory {
    @Override // com.facebook.imagepipeline.drawable.DrawableFactory
    public boolean supportsImageType(@NotNull CloseableImage image) {
        Intrinsics.checkNotNullParameter(image, "image");
        return image instanceof CloseableXml;
    }

    @Override // com.facebook.imagepipeline.drawable.DrawableFactory
    public Drawable createDrawable(@NotNull CloseableImage image) {
        Intrinsics.checkNotNullParameter(image, "image");
        CloseableXml closeableXml = image instanceof CloseableXml ? (CloseableXml) image : null;
        if (closeableXml != null) {
            return closeableXml.buildDrawable();
        }
        return null;
    }
}
