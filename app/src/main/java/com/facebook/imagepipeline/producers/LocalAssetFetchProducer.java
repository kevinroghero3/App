package com.facebook.imagepipeline.producers;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewConfiguration;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o.ArtificialStackFrames;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public final class LocalAssetFetchProducer extends LocalFetchProducer {
    public static final Companion Companion = new Companion(null);
    public static final String PRODUCER_NAME = "LocalAssetFetchProducer";
    private static int artificialFrame = 1;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;
    private final AssetManager assetManager;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalAssetFetchProducer(@NotNull Executor executor, @NotNull PooledByteBufferFactory pooledByteBufferFactory, @NotNull AssetManager assetManager) {
        super(executor, pooledByteBufferFactory);
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(pooledByteBufferFactory, "pooledByteBufferFactory");
        Intrinsics.checkNotNullParameter(assetManager, "assetManager");
        this.assetManager = assetManager;
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    protected EncodedImage getEncodedImage(@NotNull ImageRequest imageRequest) throws Throwable {
        int i = 2 % 2;
        int i2 = artificialFrame + 73;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i2 % 128;
        int i3 = i2 % 2;
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        try {
            Object[] objArr = {this.assetManager, Companion.getAssetName(imageRequest)};
            Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-982065286);
            if (objAccessartificialFrame == null) {
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(Gravity.getAbsoluteGravity(0, 0) + 12, (char) ((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 7116), 37 - (ViewConfiguration.getPressedStateDuration() >> 16), 1511233906, false, "accessartificialFrame", new Class[]{AssetManager.class, String.class});
            }
            EncodedImage encodedImage = getEncodedImage((InputStream) ((Method) objAccessartificialFrame).invoke(null, objArr), getLength(imageRequest));
            int i4 = getARTIFICIAL_FRAME_PACKAGE_NAME + 87;
            artificialFrame = i4 % 128;
            int i5 = i4 % 2;
            return encodedImage;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    private final int getLength(ImageRequest imageRequest) {
        AssetFileDescriptor assetFileDescriptorOpenFd = null;
        try {
            assetFileDescriptorOpenFd = this.assetManager.openFd(Companion.getAssetName(imageRequest));
            int length = (int) assetFileDescriptorOpenFd.getLength();
            try {
                assetFileDescriptorOpenFd.close();
                return length;
            } catch (IOException unused) {
                return length;
            }
        } catch (IOException unused2) {
            if (assetFileDescriptorOpenFd != null) {
                try {
                    assetFileDescriptorOpenFd.close();
                } catch (IOException unused3) {
                }
            }
            return -1;
        } catch (Throwable th) {
            if (assetFileDescriptorOpenFd != null) {
                try {
                    assetFileDescriptorOpenFd.close();
                } catch (IOException unused4) {
                }
            }
            throw th;
        }
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    protected String getProducerName() {
        return PRODUCER_NAME;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String getAssetName(ImageRequest imageRequest) {
            String path = imageRequest.getSourceUri().getPath();
            Intrinsics.checkNotNull(path);
            String strSubstring = path.substring(1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            return strSubstring;
        }
    }
}
