package com.facebook.imagepipeline.bitmaps;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.webp.BitmapCreator;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.FlexByteArrayPool;
import com.facebook.imagepipeline.memory.PoolFactory;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public final class HoneycombBitmapCreator implements BitmapCreator {
    public static final Companion Companion = new Companion(null);
    private final FlexByteArrayPool flexByteArrayPool;
    private final EmptyJpegGenerator jpegGenerator;

    public HoneycombBitmapCreator(@NotNull PoolFactory poolFactory) {
        Intrinsics.checkNotNullParameter(poolFactory, "poolFactory");
        this.jpegGenerator = new EmptyJpegGenerator(poolFactory.getPooledByteBufferFactory());
        FlexByteArrayPool flexByteArrayPool = poolFactory.getFlexByteArrayPool();
        Intrinsics.checkNotNullExpressionValue(flexByteArrayPool, "getFlexByteArrayPool(...)");
        this.flexByteArrayPool = flexByteArrayPool;
    }

    @Override // com.facebook.common.webp.BitmapCreator
    public Bitmap createNakedBitmap(int i, int i2, @NotNull Bitmap.Config bitmapConfig) throws Throwable {
        EncodedImage encodedImage;
        Intrinsics.checkNotNullParameter(bitmapConfig, "bitmapConfig");
        CloseableReference<PooledByteBuffer> closeableReferenceGenerate = this.jpegGenerator.generate((short) i, (short) i2);
        Intrinsics.checkNotNullExpressionValue(closeableReferenceGenerate, "generate(...)");
        try {
            encodedImage = new EncodedImage(closeableReferenceGenerate);
            try {
                encodedImage.setImageFormat(DefaultImageFormats.JPEG);
                BitmapFactory.Options bitmapFactoryOptions = Companion.getBitmapFactoryOptions(encodedImage.getSampleSize(), bitmapConfig);
                int size = closeableReferenceGenerate.get().size();
                PooledByteBuffer pooledByteBuffer = closeableReferenceGenerate.get();
                Intrinsics.checkNotNullExpressionValue(pooledByteBuffer, "get(...)");
                CloseableReference<byte[]> closeableReference = this.flexByteArrayPool.get(size + 2);
                byte[] bArr = closeableReference.get();
                Intrinsics.checkNotNullExpressionValue(bArr, "get(...)");
                byte[] bArr2 = bArr;
                pooledByteBuffer.read(0, bArr2, 0, size);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr2, 0, size, bitmapFactoryOptions);
                if (bitmapDecodeByteArray == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                bitmapDecodeByteArray.setHasAlpha(true);
                bitmapDecodeByteArray.eraseColor(0);
                CloseableReference.closeSafely((CloseableReference<?>) closeableReference);
                EncodedImage.closeSafely(encodedImage);
                CloseableReference.closeSafely(closeableReferenceGenerate);
                return bitmapDecodeByteArray;
            } catch (Throwable th) {
                th = th;
                CloseableReference.closeSafely((CloseableReference<?>) null);
                EncodedImage.closeSafely(encodedImage);
                CloseableReference.closeSafely(closeableReferenceGenerate);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            encodedImage = null;
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final BitmapFactory.Options getBitmapFactoryOptions(int i, Bitmap.Config config) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inDither = true;
            options.inPreferredConfig = config;
            options.inPurgeable = true;
            options.inInputShareable = true;
            options.inSampleSize = i;
            options.inMutable = true;
            return options;
        }
    }
}
