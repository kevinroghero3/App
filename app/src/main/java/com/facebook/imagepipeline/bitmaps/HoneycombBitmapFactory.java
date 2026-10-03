package com.facebook.imagepipeline.bitmaps;

import android.graphics.Bitmap;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imagepipeline.core.CloseableReferenceFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.platform.PlatformDecoder;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class HoneycombBitmapFactory extends PlatformBitmapFactory {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = HoneycombBitmapFactory.class.getSimpleName();
    private final CloseableReferenceFactory closeableReferenceFactory;
    private boolean immutableBitmapFallback;
    private final EmptyJpegGenerator jpegGenerator;
    private final PlatformDecoder purgeableDecoder;

    public HoneycombBitmapFactory(@NotNull EmptyJpegGenerator jpegGenerator, @NotNull PlatformDecoder purgeableDecoder, @NotNull CloseableReferenceFactory closeableReferenceFactory) {
        Intrinsics.checkNotNullParameter(jpegGenerator, "jpegGenerator");
        Intrinsics.checkNotNullParameter(purgeableDecoder, "purgeableDecoder");
        Intrinsics.checkNotNullParameter(closeableReferenceFactory, "closeableReferenceFactory");
        this.jpegGenerator = jpegGenerator;
        this.purgeableDecoder = purgeableDecoder;
        this.closeableReferenceFactory = closeableReferenceFactory;
    }

    @Override // com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory
    public CloseableReference<Bitmap> createBitmapInternal(int i, int i2, @NotNull Bitmap.Config bitmapConfig) throws Throwable {
        Intrinsics.checkNotNullParameter(bitmapConfig, "bitmapConfig");
        if (this.immutableBitmapFallback) {
            return createFallbackBitmap(i, i2, bitmapConfig);
        }
        CloseableReference<PooledByteBuffer> closeableReferenceGenerate = this.jpegGenerator.generate((short) i, (short) i2);
        Intrinsics.checkNotNullExpressionValue(closeableReferenceGenerate, "generate(...)");
        try {
            EncodedImage encodedImage = new EncodedImage(closeableReferenceGenerate);
            encodedImage.setImageFormat(DefaultImageFormats.JPEG);
            try {
                CloseableReference<Bitmap> closeableReferenceDecodeJPEGFromEncodedImage = this.purgeableDecoder.decodeJPEGFromEncodedImage(encodedImage, bitmapConfig, null, closeableReferenceGenerate.get().size());
                if (closeableReferenceDecodeJPEGFromEncodedImage == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                if (!closeableReferenceDecodeJPEGFromEncodedImage.get().isMutable()) {
                    CloseableReference.closeSafely(closeableReferenceDecodeJPEGFromEncodedImage);
                    this.immutableBitmapFallback = true;
                    FLog.wtf(TAG, "Immutable bitmap returned by decoder");
                    CloseableReference<Bitmap> closeableReferenceCreateFallbackBitmap = createFallbackBitmap(i, i2, bitmapConfig);
                    EncodedImage.closeSafely(encodedImage);
                    closeableReferenceGenerate.close();
                    return closeableReferenceCreateFallbackBitmap;
                }
                closeableReferenceDecodeJPEGFromEncodedImage.get().setHasAlpha(true);
                closeableReferenceDecodeJPEGFromEncodedImage.get().eraseColor(0);
                EncodedImage.closeSafely(encodedImage);
                closeableReferenceGenerate.close();
                return closeableReferenceDecodeJPEGFromEncodedImage;
            } catch (Throwable th) {
                EncodedImage.closeSafely(encodedImage);
                throw th;
            }
        } catch (Throwable th2) {
            closeableReferenceGenerate.close();
            throw th2;
        }
    }

    private final CloseableReference<Bitmap> createFallbackBitmap(int i, int i2, Bitmap.Config config) {
        CloseableReference<Bitmap> closeableReferenceCreate = this.closeableReferenceFactory.create(Bitmap.createBitmap(i, i2, config), SimpleBitmapReleaser.getInstance());
        Intrinsics.checkNotNullExpressionValue(closeableReferenceCreate, "create(...)");
        return closeableReferenceCreate;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
