package androidx.camera.core;

import android.util.Size;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
final class ImageProxyDownsampler {

    enum DownsamplingMethod {
        NEAREST_NEIGHBOR,
        AVERAGING
    }

    private ImageProxyDownsampler() {
    }

    static ForwardingImageProxy downsample(ImageProxy imageProxy, int i, int i2, DownsamplingMethod downsamplingMethod) {
        byte[] bArr;
        if (imageProxy.getFormat() != 35) {
            throw new UnsupportedOperationException("Only YUV_420_888 format is currently supported.");
        }
        if (imageProxy.getWidth() < i || imageProxy.getHeight() < i2) {
            throw new IllegalArgumentException("Downsampled dimension " + new Size(i, i2) + " is not <= original dimension " + new Size(imageProxy.getWidth(), imageProxy.getHeight()) + ".");
        }
        if (imageProxy.getWidth() == i && imageProxy.getHeight() == i2) {
            return new ForwardingImageProxyImpl(imageProxy, imageProxy.getPlanes(), i, i2);
        }
        int[] iArr = {imageProxy.getWidth(), imageProxy.getWidth() / 2, imageProxy.getWidth() / 2};
        int[] iArr2 = {imageProxy.getHeight(), imageProxy.getHeight() / 2, imageProxy.getHeight() / 2};
        int i3 = i / 2;
        int[] iArr3 = {i, i3, i3};
        int i4 = i2 / 2;
        int[] iArr4 = {i2, i4, i4};
        ImageProxy.PlaneProxy[] planeProxyArr = new ImageProxy.PlaneProxy[3];
        int i5 = 0;
        for (int i6 = 3; i5 < i6; i6 = 3) {
            ImageProxy.PlaneProxy planeProxy = imageProxy.getPlanes()[i5];
            ByteBuffer buffer = planeProxy.getBuffer();
            byte[] bArr2 = new byte[iArr3[i5] * iArr4[i5]];
            int iOrdinal = downsamplingMethod.ordinal();
            if (iOrdinal == 0) {
                bArr = bArr2;
                resizeNearestNeighbor(buffer, iArr[i5], planeProxy.getPixelStride(), planeProxy.getRowStride(), iArr2[i5], bArr, iArr3[i5], iArr4[i5]);
            } else if (iOrdinal != 1) {
                bArr = bArr2;
            } else {
                resizeAveraging(buffer, iArr[i5], planeProxy.getPixelStride(), planeProxy.getRowStride(), iArr2[i5], bArr2, iArr3[i5], iArr4[i5]);
                bArr = bArr2;
            }
            planeProxyArr[i5] = createPlaneProxy(iArr3[i5], 1, bArr);
            i5++;
        }
        return new ForwardingImageProxyImpl(imageProxy, planeProxyArr, i, i2);
    }

    private static void resizeNearestNeighbor(ByteBuffer byteBuffer, int i, int i2, int i3, int i4, byte[] bArr, int i5, int i6) {
        float f = i / i5;
        float f2 = i4 / i6;
        byte[] bArr2 = new byte[i3];
        int[] iArr = new int[i5];
        for (int i7 = 0; i7 < i5; i7++) {
            iArr[i7] = ((int) (i7 * f)) * i2;
        }
        synchronized (byteBuffer) {
            byteBuffer.rewind();
            for (int i8 = 0; i8 < i6; i8++) {
                byteBuffer.position(Math.min((int) (i8 * f2), i4 - 1) * i3);
                byteBuffer.get(bArr2, 0, Math.min(i3, byteBuffer.remaining()));
                for (int i9 = 0; i9 < i5; i9++) {
                    bArr[(i8 * i5) + i9] = bArr2[iArr[i9]];
                }
            }
        }
    }

    private static void resizeAveraging(ByteBuffer byteBuffer, int i, int i2, int i3, int i4, byte[] bArr, int i5, int i6) {
        float f = i / i5;
        float f2 = i4 / i6;
        byte[] bArr2 = new byte[i3];
        byte[] bArr3 = new byte[i3];
        int[] iArr = new int[i5];
        for (int i7 = 0; i7 < i5; i7++) {
            iArr[i7] = ((int) (i7 * f)) * i2;
        }
        synchronized (byteBuffer) {
            byteBuffer.rewind();
            for (int i8 = 0; i8 < i6; i8++) {
                int i9 = (int) (i8 * f2);
                int i10 = i4 - 1;
                int iMin = Math.min(i9, i10);
                int iMin2 = Math.min(i9 + 1, i10);
                byteBuffer.position(iMin * i3);
                byteBuffer.get(bArr2, 0, Math.min(i3, byteBuffer.remaining()));
                byteBuffer.position(iMin2 * i3);
                byteBuffer.get(bArr3, 0, Math.min(i3, byteBuffer.remaining()));
                for (int i11 = 0; i11 < i5; i11++) {
                    int i12 = iArr[i11];
                    int i13 = i12 + i2;
                    bArr[(i8 * i5) + i11] = (byte) ((((((bArr2[i12] & 255) + (bArr2[i13] & 255)) + (bArr3[i12] & 255)) + (bArr3[i13] & 255)) / 4) & 255);
                }
            }
        }
    }

    private static ImageProxy.PlaneProxy createPlaneProxy(int i, int i2, byte[] bArr) {
        return new ImageProxy.PlaneProxy(bArr, i, i2) { // from class: androidx.camera.core.ImageProxyDownsampler.1
            final ByteBuffer mBuffer;
            final /* synthetic */ byte[] val$data;
            final /* synthetic */ int val$pixelStride;
            final /* synthetic */ int val$rowStride;

            {
                this.val$data = bArr;
                this.val$rowStride = i;
                this.val$pixelStride = i2;
                this.mBuffer = ByteBuffer.wrap(bArr);
            }

            @Override // androidx.camera.core.ImageProxy.PlaneProxy
            public int getRowStride() {
                return this.val$rowStride;
            }

            @Override // androidx.camera.core.ImageProxy.PlaneProxy
            public int getPixelStride() {
                return this.val$pixelStride;
            }

            @Override // androidx.camera.core.ImageProxy.PlaneProxy
            public ByteBuffer getBuffer() {
                return this.mBuffer;
            }
        };
    }

    static final class ForwardingImageProxyImpl extends ForwardingImageProxy {
        private final int mDownsampledHeight;
        private final ImageProxy.PlaneProxy[] mDownsampledPlanes;
        private final int mDownsampledWidth;

        ForwardingImageProxyImpl(ImageProxy imageProxy, ImageProxy.PlaneProxy[] planeProxyArr, int i, int i2) {
            super(imageProxy);
            this.mDownsampledPlanes = planeProxyArr;
            this.mDownsampledWidth = i;
            this.mDownsampledHeight = i2;
        }

        @Override // androidx.camera.core.ForwardingImageProxy, androidx.camera.core.ImageProxy
        public int getWidth() {
            return this.mDownsampledWidth;
        }

        @Override // androidx.camera.core.ForwardingImageProxy, androidx.camera.core.ImageProxy
        public int getHeight() {
            return this.mDownsampledHeight;
        }

        @Override // androidx.camera.core.ForwardingImageProxy, androidx.camera.core.ImageProxy
        public ImageProxy.PlaneProxy[] getPlanes() {
            return this.mDownsampledPlanes;
        }
    }
}
