package io.legere.pdfiumandroid;

import android.graphics.RectF;
import io.legere.pdfiumandroid.util.ConfigKt;
import java.io.Closeable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class PdfTextPage implements Closeable {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = PdfTextPage.class.getName();
    private final PdfDocument doc;
    private boolean isClosed;
    private final int pageIndex;
    private final Map<Integer, PdfDocument.PageCount> pageMap;
    private final long pagePtr;

    @JvmStatic
    public static final native void nativeCloseTextPage(long j);

    @JvmStatic
    public static final native long nativeFindStart(long j, String str, int i, int i2);

    @JvmStatic
    public static final native double nativeGetFontSize(long j, int i);

    @JvmStatic
    public static final native long nativeLoadWebLink(long j);

    @JvmStatic
    public static final native int nativeTextCountChars(long j);

    @JvmStatic
    public static final native int nativeTextCountRects(long j, int i, int i2);

    @JvmStatic
    public static final native int nativeTextGetBoundedText(long j, double d, double d2, double d3, double d4, short[] sArr);

    @JvmStatic
    public static final native double[] nativeTextGetCharBox(long j, int i);

    @JvmStatic
    public static final native int nativeTextGetCharIndexAtPos(long j, double d, double d2, double d3, double d4);

    @JvmStatic
    public static final native double[] nativeTextGetRect(long j, int i);

    @JvmStatic
    public static final native double[] nativeTextGetRects(long j, int[] iArr);

    @JvmStatic
    public static final native int nativeTextGetText(long j, int i, int i2, short[] sArr);

    @JvmStatic
    public static final native int nativeTextGetTextByteArray(long j, int i, int i2, byte[] bArr);

    @JvmStatic
    public static final native int nativeTextGetUnicode(long j, int i);

    public PdfTextPage(@NotNull PdfDocument doc, int i, long j, @NotNull Map<Integer, PdfDocument.PageCount> pageMap) {
        Intrinsics.checkNotNullParameter(doc, "doc");
        Intrinsics.checkNotNullParameter(pageMap, "pageMap");
        this.doc = doc;
        this.pageIndex = i;
        this.pagePtr = j;
        this.pageMap = pageMap;
    }

    public final PdfDocument getDoc() {
        return this.doc;
    }

    public final int getPageIndex() {
        return this.pageIndex;
    }

    public final long getPagePtr() {
        return this.pagePtr;
    }

    public final Map<Integer, PdfDocument.PageCount> getPageMap() {
        return this.pageMap;
    }

    public final int textPageCountChars() {
        int iNativeTextCountChars;
        if (ConfigKt.handleAlreadyClosed(this.isClosed || this.doc.isClosed())) {
            return -1;
        }
        synchronized (PdfiumCore.Companion.getLock()) {
            iNativeTextCountChars = Companion.nativeTextCountChars(this.pagePtr);
        }
        return iNativeTextCountChars;
    }

    public final String textPageGetTextLegacy(int i, int i2) {
        if (ConfigKt.handleAlreadyClosed(this.isClosed || this.doc.isClosed())) {
            return null;
        }
        synchronized (PdfiumCore.Companion.getLock()) {
            try {
                short[] sArr = new short[i2 + 1];
                int iNativeTextGetText = Companion.nativeTextGetText(this.pagePtr, i, i2, sArr);
                if (iNativeTextGetText <= 0) {
                    return "";
                }
                int i3 = iNativeTextGetText - 1;
                byte[] bArr = new byte[i3 * 2];
                ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
                byteBufferWrap.order(ByteOrder.LITTLE_ENDIAN);
                for (int i4 = 0; i4 < i3; i4++) {
                    byteBufferWrap.putShort(sArr[i4]);
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

    public final String textPageGetText(int i, int i2) {
        if (ConfigKt.handleAlreadyClosed(this.isClosed || this.doc.isClosed())) {
            return null;
        }
        synchronized (PdfiumCore.Companion.getLock()) {
            try {
                try {
                    byte[] bArr = new byte[i2 * 2];
                    if (Companion.nativeTextGetTextByteArray(this.pagePtr, i, i2, bArr) <= 0) {
                        return "";
                    }
                    Charset UTF_16LE = StandardCharsets.UTF_16LE;
                    Intrinsics.checkNotNullExpressionValue(UTF_16LE, "UTF_16LE");
                    return new String(bArr, UTF_16LE);
                } catch (Exception e) {
                    Logger logger = Logger.INSTANCE;
                    String TAG2 = TAG;
                    Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                    logger.e(TAG2, e, "Exception throw from native");
                    return null;
                }
            } catch (NullPointerException e2) {
                Logger logger2 = Logger.INSTANCE;
                String TAG3 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                logger2.e(TAG3, e2, "mContext may be null");
                return null;
            }
        }
    }

    public final char textPageGetUnicode(int i) {
        char cNativeTextGetUnicode;
        if (this.isClosed || this.doc.isClosed()) {
            throw new IllegalStateException("Already closed");
        }
        synchronized (PdfiumCore.Companion.getLock()) {
            cNativeTextGetUnicode = (char) Companion.nativeTextGetUnicode(this.pagePtr, i);
        }
        return cNativeTextGetUnicode;
    }

    public final RectF textPageGetCharBox(int i) {
        if (ConfigKt.handleAlreadyClosed(this.isClosed || this.doc.isClosed())) {
            return null;
        }
        synchronized (PdfiumCore.Companion.getLock()) {
            try {
                try {
                    double[] dArrNativeTextGetCharBox = Companion.nativeTextGetCharBox(this.pagePtr, i);
                    RectF rectF = new RectF();
                    rectF.left = (float) dArrNativeTextGetCharBox[0];
                    rectF.right = (float) dArrNativeTextGetCharBox[1];
                    rectF.bottom = (float) dArrNativeTextGetCharBox[2];
                    rectF.top = (float) dArrNativeTextGetCharBox[3];
                    return rectF;
                } catch (NullPointerException e) {
                    Logger logger = Logger.INSTANCE;
                    String TAG2 = TAG;
                    Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                    logger.e(TAG2, e, "mContext may be null");
                    Unit unit = Unit.INSTANCE;
                    return null;
                }
            } catch (Exception e2) {
                Logger logger2 = Logger.INSTANCE;
                String TAG3 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                logger2.e(TAG3, e2, "Exception throw from native");
                Unit unit2 = Unit.INSTANCE;
                return null;
            }
        }
    }

    public final int textPageGetCharIndexAtPos(double d, double d2, double d3, double d4) {
        int iNativeTextGetCharIndexAtPos;
        if (ConfigKt.handleAlreadyClosed(this.isClosed || this.doc.isClosed())) {
            return -1;
        }
        synchronized (PdfiumCore.Companion.getLock()) {
            try {
                iNativeTextGetCharIndexAtPos = Companion.nativeTextGetCharIndexAtPos(this.pagePtr, d, d2, d3, d4);
            } catch (Exception e) {
                Logger logger = Logger.INSTANCE;
                String TAG2 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                logger.e(TAG2, e, "Exception throw from native");
                Unit unit = Unit.INSTANCE;
                return -1;
            }
        }
        return iNativeTextGetCharIndexAtPos;
    }

    public final int textPageCountRects(int i, int i2) {
        if (this.isClosed || this.doc.isClosed()) {
            throw new IllegalStateException("Already closed");
        }
        synchronized (PdfiumCore.Companion.getLock()) {
            try {
                return Companion.nativeTextCountRects(this.pagePtr, i, i2);
            } catch (NullPointerException e) {
                Logger logger = Logger.INSTANCE;
                String TAG2 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                logger.e(TAG2, e, "mContext may be null");
                Unit unit = Unit.INSTANCE;
                return -1;
            } catch (Exception e2) {
                Logger logger2 = Logger.INSTANCE;
                String TAG3 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                logger2.e(TAG3, e2, "Exception throw from native");
                Unit unit2 = Unit.INSTANCE;
                return -1;
            }
        }
    }

    public final RectF textPageGetRect(int i) {
        RectF rectF = null;
        if (ConfigKt.handleAlreadyClosed(this.isClosed || this.doc.isClosed())) {
            return null;
        }
        synchronized (PdfiumCore.Companion.getLock()) {
            try {
                try {
                    double[] dArrNativeTextGetRect = Companion.nativeTextGetRect(this.pagePtr, i);
                    RectF rectF2 = new RectF();
                    rectF2.left = (float) dArrNativeTextGetRect[0];
                    rectF2.top = (float) dArrNativeTextGetRect[1];
                    rectF2.right = (float) dArrNativeTextGetRect[2];
                    rectF2.bottom = (float) dArrNativeTextGetRect[3];
                    rectF = rectF2;
                } catch (NullPointerException e) {
                    Logger logger = Logger.INSTANCE;
                    String TAG2 = TAG;
                    Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                    logger.e(TAG2, e, "mContext may be null");
                }
            } catch (Exception e2) {
                Logger logger2 = Logger.INSTANCE;
                String TAG3 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                logger2.e(TAG3, e2, "Exception throw from native");
            }
        }
        return rectF;
    }

    public final List<WordRangeRect> textPageGetRectsForRanges(@NotNull int[] wordRanges) {
        Intrinsics.checkNotNullParameter(wordRanges, "wordRanges");
        int i = 0;
        if (ConfigKt.handleAlreadyClosed(this.isClosed || this.doc.isClosed())) {
            return null;
        }
        synchronized (PdfiumCore.Companion.getLock()) {
            double[] dArrNativeTextGetRects = Companion.nativeTextGetRects(this.pagePtr, wordRanges);
            if (dArrNativeTextGetRects != null) {
                ArrayList arrayList = new ArrayList();
                int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, dArrNativeTextGetRects.length - 1, 6);
                if (progressionLastElement >= 0) {
                    while (true) {
                        RectF rectF = new RectF();
                        rectF.left = (float) dArrNativeTextGetRects[i];
                        rectF.top = (float) dArrNativeTextGetRects[i + 1];
                        rectF.right = (float) dArrNativeTextGetRects[i + 2];
                        rectF.bottom = (float) dArrNativeTextGetRects[i + 3];
                        arrayList.add(new WordRangeRect((int) dArrNativeTextGetRects[i + 4], (int) dArrNativeTextGetRects[i + 5], rectF));
                        if (i == progressionLastElement) {
                            break;
                        }
                        i += 6;
                    }
                }
                return arrayList;
            }
            Unit unit = Unit.INSTANCE;
            return null;
        }
    }

    public final String textPageGetBoundedText(@NotNull RectF rect, int i) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        String str = null;
        if (ConfigKt.handleAlreadyClosed(this.isClosed || this.doc.isClosed())) {
            return null;
        }
        synchronized (PdfiumCore.Companion.getLock()) {
            try {
                short[] sArr = new short[i + 1];
                int iNativeTextGetBoundedText = Companion.nativeTextGetBoundedText(this.pagePtr, rect.left, rect.top, rect.right, rect.bottom, sArr) - 1;
                byte[] bArr = new byte[iNativeTextGetBoundedText * 2];
                ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
                byteBufferWrap.order(ByteOrder.LITTLE_ENDIAN);
                for (int i2 = 0; i2 < iNativeTextGetBoundedText; i2++) {
                    byteBufferWrap.putShort(sArr[i2]);
                }
                Charset UTF_16LE = StandardCharsets.UTF_16LE;
                Intrinsics.checkNotNullExpressionValue(UTF_16LE, "UTF_16LE");
                str = new String(bArr, UTF_16LE);
            } catch (NullPointerException e) {
                Logger logger = Logger.INSTANCE;
                String TAG2 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                logger.e(TAG2, e, "mContext may be null");
            } catch (Exception e2) {
                Logger logger2 = Logger.INSTANCE;
                String TAG3 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                logger2.e(TAG3, e2, "Exception throw from native");
            }
        }
        return str;
    }

    public final double getFontSize(int i) {
        double dNativeGetFontSize;
        if (ConfigKt.handleAlreadyClosed(this.isClosed || this.doc.isClosed())) {
            return 0.0d;
        }
        synchronized (PdfiumCore.Companion.getLock()) {
            dNativeGetFontSize = Companion.nativeGetFontSize(this.pagePtr, i);
        }
        return dNativeGetFontSize;
    }

    public final FindResult findStart(@NotNull String findWhat, @NotNull Set<? extends FindFlags> flags, int i) {
        FindResult findResult;
        Intrinsics.checkNotNullParameter(findWhat, "findWhat");
        Intrinsics.checkNotNullParameter(flags, "flags");
        if (ConfigKt.handleAlreadyClosed(this.isClosed || this.doc.isClosed())) {
            return null;
        }
        synchronized (PdfiumCore.Companion.getLock()) {
            Iterator<T> it2 = flags.iterator();
            int value = 0;
            while (it2.hasNext()) {
                value |= ((FindFlags) it2.next()).getValue();
            }
            findResult = new FindResult(Companion.nativeFindStart(this.pagePtr, findWhat, value, i));
        }
        return findResult;
    }

    public final PdfPageLink loadWebLink() {
        if (this.isClosed || this.doc.isClosed()) {
            throw new IllegalStateException("Already closed");
        }
        return new PdfPageLink(Companion.nativeLoadWebLink(this.pagePtr));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (ConfigKt.handleAlreadyClosed(this.isClosed || this.doc.isClosed())) {
            return;
        }
        synchronized (PdfiumCore.Companion.getLock()) {
            PdfDocument.PageCount pageCount = this.pageMap.get(Integer.valueOf(this.pageIndex));
            if (pageCount != null) {
                if (pageCount.getCount() > 1) {
                    pageCount.setCount(pageCount.getCount() - 1);
                    return;
                }
                this.pageMap.remove(Integer.valueOf(this.pageIndex));
                this.isClosed = true;
                Companion.nativeCloseTextPage(this.pagePtr);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void nativeCloseTextPage(long j) {
            PdfTextPage.nativeCloseTextPage(j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long nativeFindStart(long j, String str, int i, int i2) {
            return PdfTextPage.nativeFindStart(j, str, i, i2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final double nativeGetFontSize(long j, int i) {
            return PdfTextPage.nativeGetFontSize(j, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long nativeLoadWebLink(long j) {
            return PdfTextPage.nativeLoadWebLink(j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int nativeTextCountChars(long j) {
            return PdfTextPage.nativeTextCountChars(j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int nativeTextCountRects(long j, int i, int i2) {
            return PdfTextPage.nativeTextCountRects(j, i, i2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int nativeTextGetBoundedText(long j, double d, double d2, double d3, double d4, short[] sArr) {
            return PdfTextPage.nativeTextGetBoundedText(j, d, d2, d3, d4, sArr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final double[] nativeTextGetCharBox(long j, int i) {
            return PdfTextPage.nativeTextGetCharBox(j, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int nativeTextGetCharIndexAtPos(long j, double d, double d2, double d3, double d4) {
            return PdfTextPage.nativeTextGetCharIndexAtPos(j, d, d2, d3, d4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final double[] nativeTextGetRect(long j, int i) {
            return PdfTextPage.nativeTextGetRect(j, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final double[] nativeTextGetRects(long j, int[] iArr) {
            return PdfTextPage.nativeTextGetRects(j, iArr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int nativeTextGetText(long j, int i, int i2, short[] sArr) {
            return PdfTextPage.nativeTextGetText(j, i, i2, sArr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int nativeTextGetTextByteArray(long j, int i, int i2, byte[] bArr) {
            return PdfTextPage.nativeTextGetTextByteArray(j, i, i2, bArr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int nativeTextGetUnicode(long j, int i) {
            return PdfTextPage.nativeTextGetUnicode(j, i);
        }

        private Companion() {
        }
    }
}
