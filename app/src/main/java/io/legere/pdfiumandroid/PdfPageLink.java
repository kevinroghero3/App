package io.legere.pdfiumandroid;

import android.graphics.RectF;
import java.io.Closeable;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Pair;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class PdfPageLink implements Closeable {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = PdfPageLink.class.getName();
    private final long pageLinkPtr;

    @JvmStatic
    public static final native void nativeClosePageLink(long j);

    @JvmStatic
    public static final native int nativeCountRects(long j, int i);

    @JvmStatic
    public static final native int nativeCountWebLinks(long j);

    @JvmStatic
    public static final native float[] nativeGetRect(long j, int i, int i2);

    @JvmStatic
    public static final native int[] nativeGetTextRange(long j, int i);

    @JvmStatic
    public static final native int nativeGetURL(long j, int i, int i2, byte[] bArr);

    public PdfPageLink(long j) {
        this.pageLinkPtr = j;
    }

    public final int countWebLinks() {
        int iNativeCountWebLinks;
        synchronized (PdfiumCore.Companion.getLock()) {
            iNativeCountWebLinks = Companion.nativeCountWebLinks(this.pageLinkPtr);
        }
        return iNativeCountWebLinks;
    }

    public final String getURL(int i, int i2) {
        synchronized (PdfiumCore.Companion.getLock()) {
            try {
                byte[] bArr = new byte[i2 * 2];
                if (Companion.nativeGetURL(this.pageLinkPtr, i, i2, bArr) <= 0) {
                    return "";
                }
                Charset UTF_16LE = StandardCharsets.UTF_16LE;
                Intrinsics.checkNotNullExpressionValue(UTF_16LE, "UTF_16LE");
                return new String(bArr, UTF_16LE);
            } catch (NullPointerException e) {
                Logger logger = Logger.INSTANCE;
                String TAG2 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                logger.e(TAG2, e, "mContext may be null");
                return null;
            } catch (Exception e2) {
                Logger logger2 = Logger.INSTANCE;
                String TAG3 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                logger2.e(TAG3, e2, "Exception throw from native");
                return null;
            }
        }
    }

    public final int countRects(int i) {
        int iNativeCountRects;
        synchronized (PdfiumCore.Companion.getLock()) {
            iNativeCountRects = Companion.nativeCountRects(this.pageLinkPtr, i);
        }
        return iNativeCountRects;
    }

    public final RectF getRect(int i, int i2) {
        RectF rectF;
        synchronized (PdfiumCore.Companion.getLock()) {
            float[] fArrNativeGetRect = Companion.nativeGetRect(this.pageLinkPtr, i, i2);
            rectF = new RectF(fArrNativeGetRect[0], fArrNativeGetRect[1], fArrNativeGetRect[2], fArrNativeGetRect[3]);
        }
        return rectF;
    }

    public final Pair<Integer, Integer> getTextRange(int i) {
        Pair<Integer, Integer> pair;
        synchronized (PdfiumCore.Companion.getLock()) {
            int[] iArrNativeGetTextRange = Companion.nativeGetTextRange(this.pageLinkPtr, i);
            pair = new Pair<>(Integer.valueOf(iArrNativeGetTextRange[0]), Integer.valueOf(iArrNativeGetTextRange[1]));
        }
        return pair;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Companion.nativeClosePageLink(this.pageLinkPtr);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void nativeClosePageLink(long j) {
            PdfPageLink.nativeClosePageLink(j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int nativeCountRects(long j, int i) {
            return PdfPageLink.nativeCountRects(j, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int nativeCountWebLinks(long j) {
            return PdfPageLink.nativeCountWebLinks(j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final float[] nativeGetRect(long j, int i, int i2) {
            return PdfPageLink.nativeGetRect(j, i, i2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int[] nativeGetTextRange(long j, int i) {
            return PdfPageLink.nativeGetTextRange(j, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int nativeGetURL(long j, int i, int i2, byte[] bArr) {
            return PdfPageLink.nativeGetURL(j, i, i2, bArr);
        }

        private Companion() {
        }
    }
}
