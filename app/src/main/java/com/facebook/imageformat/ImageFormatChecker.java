package com.facebook.imageformat;

import com.facebook.common.internal.ByteStreams;
import com.facebook.common.internal.Closeables;
import com.facebook.common.internal.Throwables;
import io.sentry.instrumentation.file.SentryFileInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class ImageFormatChecker {
    public static final Companion Companion = new Companion(null);
    private static final Lazy<ImageFormatChecker> instance$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new Function0() { // from class: com.facebook.imageformat.ImageFormatChecker$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ImageFormatChecker.instance_delegate$lambda$2();
        }
    });
    private boolean binaryXmlEnabled;
    private List<? extends ImageFormat.FormatChecker> customImageFormatCheckers;
    private final DefaultImageFormatChecker defaultFormatChecker = new DefaultImageFormatChecker();
    private int maxHeaderLength;

    @JvmStatic
    public static final ImageFormat getImageFormat(@NotNull InputStream inputStream) throws IOException {
        return Companion.getImageFormat(inputStream);
    }

    @JvmStatic
    public static final ImageFormat getImageFormat(@Nullable String str) {
        return Companion.getImageFormat(str);
    }

    @JvmStatic
    public static final ImageFormat getImageFormat_WrapIOException(@NotNull InputStream inputStream) {
        return Companion.getImageFormat_WrapIOException(inputStream);
    }

    @JvmStatic
    public static final ImageFormatChecker getInstance() {
        return Companion.getInstance();
    }

    private ImageFormatChecker() {
        updateMaxHeaderLength();
    }

    public final ImageFormatChecker setCustomImageFormatCheckers(@Nullable List<? extends ImageFormat.FormatChecker> list) {
        this.customImageFormatCheckers = list;
        updateMaxHeaderLength();
        return this;
    }

    public final ImageFormatChecker setBinaryXmlEnabled(boolean z) {
        this.binaryXmlEnabled = z;
        return this;
    }

    public final ImageFormat determineImageFormat(@NotNull InputStream is) throws IOException {
        Intrinsics.checkNotNullParameter(is, "is");
        int i = this.maxHeaderLength;
        byte[] bArr = new byte[i];
        int headerFromStream = Companion.readHeaderFromStream(i, is, bArr);
        ImageFormat imageFormatDetermineFormat = this.defaultFormatChecker.determineFormat(bArr, headerFromStream);
        if (Intrinsics.areEqual(imageFormatDetermineFormat, DefaultImageFormats.BINARY_XML) && !this.binaryXmlEnabled) {
            imageFormatDetermineFormat = ImageFormat.UNKNOWN;
        }
        if (imageFormatDetermineFormat != ImageFormat.UNKNOWN) {
            return imageFormatDetermineFormat;
        }
        List<? extends ImageFormat.FormatChecker> list = this.customImageFormatCheckers;
        if (list != null) {
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                ImageFormat imageFormatDetermineFormat2 = ((ImageFormat.FormatChecker) it2.next()).determineFormat(bArr, headerFromStream);
                if (imageFormatDetermineFormat2 != ImageFormat.UNKNOWN) {
                    return imageFormatDetermineFormat2;
                }
            }
        }
        return ImageFormat.UNKNOWN;
    }

    private final void updateMaxHeaderLength() {
        this.maxHeaderLength = this.defaultFormatChecker.getHeaderSize();
        List<? extends ImageFormat.FormatChecker> list = this.customImageFormatCheckers;
        if (list != null) {
            Intrinsics.checkNotNull(list);
            Iterator<? extends ImageFormat.FormatChecker> it2 = list.iterator();
            while (it2.hasNext()) {
                this.maxHeaderLength = Math.max(this.maxHeaderLength, it2.next().getHeaderSize());
            }
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int readHeaderFromStream(int i, InputStream inputStream, byte[] bArr) throws IOException {
            if (bArr.length < i) {
                throw new IllegalStateException("Check failed.");
            }
            if (inputStream.markSupported()) {
                try {
                    inputStream.mark(i);
                    return ByteStreams.read(inputStream, bArr, 0, i);
                } finally {
                    inputStream.reset();
                }
            }
            return ByteStreams.read(inputStream, bArr, 0, i);
        }

        @JvmStatic
        public final ImageFormatChecker getInstance() {
            return (ImageFormatChecker) ImageFormatChecker.instance$delegate.getValue();
        }

        @JvmStatic
        public final ImageFormat getImageFormat(@NotNull InputStream is) throws IOException {
            Intrinsics.checkNotNullParameter(is, "is");
            return getInstance().determineImageFormat(is);
        }

        @JvmStatic
        public final ImageFormat getImageFormat_WrapIOException(@NotNull InputStream is) {
            Intrinsics.checkNotNullParameter(is, "is");
            try {
                return getImageFormat(is);
            } catch (IOException e) {
                throw Throwables.propagate(e);
            }
        }

        @JvmStatic
        public final ImageFormat getImageFormat(@Nullable String str) {
            ImageFormat imageFormat;
            FileInputStream fileInputStreamCreate = null;
            try {
                try {
                    fileInputStreamCreate = SentryFileInputStream.Factory.create(new FileInputStream(str), str);
                    imageFormat = getImageFormat(fileInputStreamCreate);
                } catch (IOException unused) {
                    imageFormat = ImageFormat.UNKNOWN;
                }
                return imageFormat;
            } finally {
                Closeables.closeQuietly(fileInputStreamCreate);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ImageFormatChecker instance_delegate$lambda$2() {
        return new ImageFormatChecker();
    }
}
