package io.legere.pdfiumandroid;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.Surface;
import androidx.annotation.ColorInt;
import io.legere.pdfiumandroid.util.ConfigKt;
import io.legere.pdfiumandroid.util.Size;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class PdfPage implements Closeable {
    public static final int BOTTOM = 3;
    public static final Companion Companion = new Companion(null);
    public static final int LEFT = 0;
    public static final int RIGHT = 2;
    private static final String TAG = "PdfPage";
    public static final int TOP = 1;
    private final PdfDocument doc;
    private boolean isClosed;
    private final int pageIndex;
    private final Map<Integer, PdfDocument.PageCount> pageMap;
    private final long pagePtr;

    @JvmStatic
    public static final native void nativeClosePage(long j);

    @JvmStatic
    public static final native void nativeClosePages(long[] jArr);

    @JvmStatic
    public static final native float[] nativeDeviceCoordsToPage(long j, int i, int i2, int i3, int i4, int i5, int i6, int i7);

    @JvmStatic
    public static final native int nativeGetDestPageIndex(long j, long j2);

    @JvmStatic
    public static final native float[] nativeGetLinkRect(long j, long j2);

    @JvmStatic
    public static final native String nativeGetLinkURI(long j, long j2);

    @JvmStatic
    public static final native float[] nativeGetPageArtBox(long j);

    @JvmStatic
    public static final native float[] nativeGetPageBleedBox(long j);

    @JvmStatic
    public static final native float[] nativeGetPageBoundingBox(long j);

    @JvmStatic
    public static final native float[] nativeGetPageCropBox(long j);

    @JvmStatic
    public static final native int nativeGetPageHeightPixel(long j, int i);

    @JvmStatic
    public static final native int nativeGetPageHeightPoint(long j);

    @JvmStatic
    public static final native long[] nativeGetPageLinks(long j);

    @JvmStatic
    public static final native float[] nativeGetPageMatrix(long j);

    @JvmStatic
    public static final native float[] nativeGetPageMediaBox(long j);

    @JvmStatic
    public static final native int nativeGetPageRotation(long j);

    @JvmStatic
    public static final native int[] nativeGetPageSizeByIndex(long j, int i, int i2);

    @JvmStatic
    public static final native float[] nativeGetPageTrimBox(long j);

    @JvmStatic
    public static final native int nativeGetPageWidthPixel(long j, int i);

    @JvmStatic
    public static final native int nativeGetPageWidthPoint(long j);

    @JvmStatic
    public static final native boolean nativeLockSurface(Surface surface, int[] iArr, long[] jArr);

    @JvmStatic
    public static final native int[] nativePageCoordsToDevice(long j, int i, int i2, int i3, int i4, int i5, double d, double d2);

    @JvmStatic
    public static final native boolean nativeRenderPage(long j, long j2, int i, int i2, int i3, int i4, boolean z, int i5, int i6);

    @JvmStatic
    public static final native void nativeRenderPageBitmap(long j, long j2, Bitmap bitmap, int i, int i2, int i3, int i4, boolean z, boolean z2, int i5, int i6);

    @JvmStatic
    public static final native void nativeRenderPageBitmapWithMatrix(long j, Bitmap bitmap, float[] fArr, float[] fArr2, boolean z, boolean z2, int i, int i2);

    @JvmStatic
    public static final native boolean nativeRenderPageSurface(long j, Surface surface, int i, int i2, boolean z, int i3, int i4);

    @JvmStatic
    public static final native boolean nativeRenderPageSurfaceWithMatrix(long j, Surface surface, float[] fArr, float[] fArr2, boolean z, boolean z2, int i, int i2);

    @JvmStatic
    public static final native boolean nativeRenderPageWithMatrix(long j, long j2, int i, int i2, float[] fArr, float[] fArr2, boolean z, boolean z2, int i3, int i4);

    @JvmStatic
    public static final native void nativeUnlockSurface(long[] jArr);

    public PdfPage(@NotNull PdfDocument doc, int i, long j, @NotNull Map<Integer, PdfDocument.PageCount> pageMap) {
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

    public final boolean isClosed$pdfiumandroid_release() {
        return this.isClosed;
    }

    public final void setClosed$pdfiumandroid_release(boolean z) {
        this.isClosed = z;
    }

    public final PdfTextPage openTextPage() {
        return this.doc.openTextPage(this);
    }

    public final int getPageWidth(int i) {
        int iNativeGetPageWidthPixel;
        if (ConfigKt.handleAlreadyClosed(this.isClosed || this.doc.isClosed())) {
            return -1;
        }
        synchronized (PdfiumCore.Companion.getLock()) {
            iNativeGetPageWidthPixel = Companion.nativeGetPageWidthPixel(this.pagePtr, i);
        }
        return iNativeGetPageWidthPixel;
    }

    public final int getPageHeight(int i) {
        int iNativeGetPageHeightPixel;
        if (ConfigKt.handleAlreadyClosed(this.isClosed || this.doc.isClosed())) {
            return -1;
        }
        synchronized (PdfiumCore.Companion.getLock()) {
            iNativeGetPageHeightPixel = Companion.nativeGetPageHeightPixel(this.pagePtr, i);
        }
        return iNativeGetPageHeightPixel;
    }

    public final int getPageWidthPoint() {
        int iNativeGetPageWidthPoint;
        if (ConfigKt.handleAlreadyClosed(this.isClosed || this.doc.isClosed())) {
            return -1;
        }
        synchronized (PdfiumCore.Companion.getLock()) {
            iNativeGetPageWidthPoint = Companion.nativeGetPageWidthPoint(this.pagePtr);
        }
        return iNativeGetPageWidthPoint;
    }

    public final int getPageHeightPoint() {
        int iNativeGetPageHeightPoint;
        if (ConfigKt.handleAlreadyClosed(this.isClosed || this.doc.isClosed())) {
            return -1;
        }
        synchronized (PdfiumCore.Companion.getLock()) {
            iNativeGetPageHeightPoint = Companion.nativeGetPageHeightPoint(this.pagePtr);
        }
        return iNativeGetPageHeightPoint;
    }

    public final Matrix getPageMatrix() {
        Matrix matrix;
        if (ConfigKt.handleAlreadyClosed(this.isClosed || this.doc.isClosed())) {
            return null;
        }
        synchronized (PdfiumCore.Companion.getLock()) {
            float[] fArrNativeGetPageMatrix = Companion.nativeGetPageMatrix(this.pagePtr);
            Logger logger = Logger.INSTANCE;
            logger.d(TAG, "pageMatrix[0] = " + fArrNativeGetPageMatrix[0]);
            logger.d(TAG, "pageMatrix[1] = " + fArrNativeGetPageMatrix[1]);
            logger.d(TAG, "pageMatrix[2] = " + fArrNativeGetPageMatrix[2]);
            logger.d(TAG, "pageMatrix[3] = " + fArrNativeGetPageMatrix[3]);
            logger.d(TAG, "pageMatrix[4] = " + fArrNativeGetPageMatrix[4]);
            logger.d(TAG, "pageMatrix[5] = " + fArrNativeGetPageMatrix[5]);
            float[] fArr = {fArrNativeGetPageMatrix[0], fArrNativeGetPageMatrix[1], fArrNativeGetPageMatrix[4], fArrNativeGetPageMatrix[2], fArrNativeGetPageMatrix[3], fArrNativeGetPageMatrix[5], 0.0f, 0.0f, 1.0f};
            matrix = new Matrix();
            matrix.setValues(fArr);
        }
        return matrix;
    }

    public final int getPageRotation() {
        int iNativeGetPageRotation;
        if (ConfigKt.handleAlreadyClosed(this.isClosed || this.doc.isClosed())) {
            return -1;
        }
        synchronized (PdfiumCore.Companion.getLock()) {
            iNativeGetPageRotation = Companion.nativeGetPageRotation(this.pagePtr);
        }
        return iNativeGetPageRotation;
    }

    public final RectF getPageCropBox() {
        RectF rectF;
        if (this.isClosed || this.doc.isClosed()) {
            throw new IllegalStateException("Already closed");
        }
        synchronized (PdfiumCore.Companion.getLock()) {
            float[] fArrNativeGetPageCropBox = Companion.nativeGetPageCropBox(this.pagePtr);
            rectF = new RectF();
            rectF.left = fArrNativeGetPageCropBox[0];
            rectF.top = fArrNativeGetPageCropBox[1];
            rectF.right = fArrNativeGetPageCropBox[2];
            rectF.bottom = fArrNativeGetPageCropBox[3];
        }
        return rectF;
    }

    public final RectF getPageMediaBox() {
        RectF rectF;
        if (this.isClosed || this.doc.isClosed()) {
            throw new IllegalStateException("Already closed");
        }
        synchronized (PdfiumCore.Companion.getLock()) {
            float[] fArrNativeGetPageMediaBox = Companion.nativeGetPageMediaBox(this.pagePtr);
            rectF = new RectF();
            rectF.left = fArrNativeGetPageMediaBox[0];
            rectF.top = fArrNativeGetPageMediaBox[1];
            rectF.right = fArrNativeGetPageMediaBox[2];
            rectF.bottom = fArrNativeGetPageMediaBox[3];
        }
        return rectF;
    }

    public final RectF getPageBleedBox() {
        RectF rectF;
        if (this.isClosed || this.doc.isClosed()) {
            throw new IllegalStateException("Already closed");
        }
        synchronized (PdfiumCore.Companion.getLock()) {
            float[] fArrNativeGetPageBleedBox = Companion.nativeGetPageBleedBox(this.pagePtr);
            rectF = new RectF();
            rectF.left = fArrNativeGetPageBleedBox[0];
            rectF.top = fArrNativeGetPageBleedBox[1];
            rectF.right = fArrNativeGetPageBleedBox[2];
            rectF.bottom = fArrNativeGetPageBleedBox[3];
        }
        return rectF;
    }

    public final RectF getPageTrimBox() {
        RectF rectF;
        if (this.isClosed || this.doc.isClosed()) {
            throw new IllegalStateException("Already closed");
        }
        synchronized (PdfiumCore.Companion.getLock()) {
            float[] fArrNativeGetPageTrimBox = Companion.nativeGetPageTrimBox(this.pagePtr);
            rectF = new RectF();
            rectF.left = fArrNativeGetPageTrimBox[0];
            rectF.top = fArrNativeGetPageTrimBox[1];
            rectF.right = fArrNativeGetPageTrimBox[2];
            rectF.bottom = fArrNativeGetPageTrimBox[3];
        }
        return rectF;
    }

    public final RectF getPageArtBox() {
        RectF rectF;
        if (this.isClosed || this.doc.isClosed()) {
            throw new IllegalStateException("Already closed");
        }
        synchronized (PdfiumCore.Companion.getLock()) {
            float[] fArrNativeGetPageArtBox = Companion.nativeGetPageArtBox(this.pagePtr);
            rectF = new RectF();
            rectF.left = fArrNativeGetPageArtBox[0];
            rectF.top = fArrNativeGetPageArtBox[1];
            rectF.right = fArrNativeGetPageArtBox[2];
            rectF.bottom = fArrNativeGetPageArtBox[3];
        }
        return rectF;
    }

    public final RectF getPageBoundingBox() {
        RectF rectF;
        if (this.isClosed || this.doc.isClosed()) {
            throw new IllegalStateException("Already closed");
        }
        synchronized (PdfiumCore.Companion.getLock()) {
            float[] fArrNativeGetPageBoundingBox = Companion.nativeGetPageBoundingBox(this.pagePtr);
            rectF = new RectF();
            rectF.left = fArrNativeGetPageBoundingBox[0];
            rectF.top = fArrNativeGetPageBoundingBox[1];
            rectF.right = fArrNativeGetPageBoundingBox[2];
            rectF.bottom = fArrNativeGetPageBoundingBox[3];
        }
        return rectF;
    }

    public final Size getPageSize(int i) {
        Size size;
        if (this.isClosed || this.doc.isClosed()) {
            throw new IllegalStateException("Already closed");
        }
        synchronized (PdfiumCore.Companion.getLock()) {
            int[] iArrNativeGetPageSizeByIndex = Companion.nativeGetPageSizeByIndex(this.doc.getMNativeDocPtr(), this.pageIndex, i);
            size = new Size(iArrNativeGetPageSizeByIndex[0], iArrNativeGetPageSizeByIndex[1]);
        }
        return size;
    }

    public final boolean renderPage(long j, int i, int i2, int i3, int i4, boolean z, @ColorInt int i5, @ColorInt int i6) {
        if (ConfigKt.handleAlreadyClosed(this.isClosed || this.doc.isClosed())) {
            return false;
        }
        synchronized (PdfiumCore.Companion.getLock()) {
            try {
                return Companion.nativeRenderPage(this.pagePtr, j, i, i2, i3, i4, z, i5, i6);
            } catch (NullPointerException e) {
                Logger.INSTANCE.e(TAG, e, "mContext may be null");
                Unit unit = Unit.INSTANCE;
                return false;
            } catch (Exception e2) {
                Logger.INSTANCE.e(TAG, e2, "Exception throw from native");
                Unit unit2 = Unit.INSTANCE;
                return false;
            }
        }
    }

    public final boolean renderPage(long j, int i, int i2, @NotNull Matrix matrix, @NotNull RectF clipRect, boolean z, boolean z2, int i3, int i4) {
        boolean zNativeRenderPageWithMatrix;
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        Intrinsics.checkNotNullParameter(clipRect, "clipRect");
        if (ConfigKt.handleAlreadyClosed(this.isClosed || this.doc.isClosed())) {
            return false;
        }
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        synchronized (PdfiumCore.Companion.getLock()) {
            zNativeRenderPageWithMatrix = Companion.nativeRenderPageWithMatrix(this.pagePtr, j, i, i2, new float[]{fArr[0], fArr[4], fArr[2], fArr[5]}, new float[]{clipRect.left, clipRect.top, clipRect.right, clipRect.bottom}, z, z2, i3, i4);
        }
        return zNativeRenderPageWithMatrix;
    }

    public final boolean renderPage(@NotNull Surface surface, @NotNull Matrix matrix, @NotNull RectF clipRect, boolean z, boolean z2, int i, int i2) {
        boolean zNativeRenderPageSurfaceWithMatrix;
        Intrinsics.checkNotNullParameter(surface, "surface");
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        Intrinsics.checkNotNullParameter(clipRect, "clipRect");
        if (ConfigKt.handleAlreadyClosed(this.isClosed || this.doc.isClosed())) {
            return false;
        }
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        synchronized (PdfiumCore.Companion.getLock()) {
            zNativeRenderPageSurfaceWithMatrix = Companion.nativeRenderPageSurfaceWithMatrix(this.pagePtr, surface, new float[]{fArr[0], fArr[4], fArr[2], fArr[5]}, new float[]{clipRect.left, clipRect.top, clipRect.right, clipRect.bottom}, z, z2, i, i2);
        }
        return zNativeRenderPageSurfaceWithMatrix;
    }

    public final void renderPageBitmap(@Nullable Bitmap bitmap, int i, int i2, int i3, int i4, boolean z, boolean z2, int i5, int i6) {
        if (ConfigKt.handleAlreadyClosed(this.isClosed || this.doc.isClosed())) {
            return;
        }
        synchronized (PdfiumCore.Companion.getLock()) {
            Companion.nativeRenderPageBitmap(this.doc.getMNativeDocPtr(), this.pagePtr, bitmap, i, i2, i3, i4, z, z2, i5, i6);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void renderPageBitmap(@Nullable Bitmap bitmap, @NotNull Matrix matrix, @NotNull RectF clipRect, boolean z, boolean z2, int i, int i2) {
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        Intrinsics.checkNotNullParameter(clipRect, "clipRect");
        if (ConfigKt.handleAlreadyClosed(this.isClosed || this.doc.isClosed())) {
            return;
        }
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        synchronized (PdfiumCore.Companion.getLock()) {
            Companion.nativeRenderPageBitmapWithMatrix(this.pagePtr, bitmap, new float[]{fArr[0], fArr[4], fArr[2], fArr[5]}, new float[]{clipRect.left, clipRect.top, clipRect.right, clipRect.bottom}, z, z2, i, i2);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final List<PdfDocument.Link> getPageLinks() {
        ArrayList arrayList;
        if (ConfigKt.handleAlreadyClosed(this.isClosed || this.doc.isClosed())) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        synchronized (PdfiumCore.Companion.getLock()) {
            arrayList = new ArrayList();
            for (long j : Companion.nativeGetPageLinks(this.pagePtr)) {
                Companion companion = Companion;
                int iNativeGetDestPageIndex = companion.nativeGetDestPageIndex(this.doc.getMNativeDocPtr(), j);
                String strNativeGetLinkURI = companion.nativeGetLinkURI(this.doc.getMNativeDocPtr(), j);
                float[] fArrNativeGetLinkRect = companion.nativeGetLinkRect(this.doc.getMNativeDocPtr(), j);
                if (fArrNativeGetLinkRect.length != 4 && (iNativeGetDestPageIndex != -1 || strNativeGetLinkURI != null)) {
                    arrayList.add(new PdfDocument.Link(new RectF(fArrNativeGetLinkRect[0], fArrNativeGetLinkRect[1], fArrNativeGetLinkRect[2], fArrNativeGetLinkRect[3]), Integer.valueOf(iNativeGetDestPageIndex), strNativeGetLinkURI));
                }
            }
        }
        return arrayList;
    }

    public final Point mapPageCoordsToDevice(int i, int i2, int i3, int i4, int i5, double d, double d2) {
        if (this.isClosed || this.doc.isClosed()) {
            throw new IllegalStateException("Already closed");
        }
        int[] iArrNativePageCoordsToDevice = Companion.nativePageCoordsToDevice(this.pagePtr, i, i2, i3, i4, i5, d, d2);
        return new Point(iArrNativePageCoordsToDevice[0], iArrNativePageCoordsToDevice[1]);
    }

    public final PointF mapDeviceCoordsToPage(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        if (this.isClosed || this.doc.isClosed()) {
            throw new IllegalStateException("Already closed");
        }
        float[] fArrNativeDeviceCoordsToPage = Companion.nativeDeviceCoordsToPage(this.pagePtr, i, i2, i3, i4, i5, i6, i7);
        return new PointF(fArrNativeDeviceCoordsToPage[0], fArrNativeDeviceCoordsToPage[1]);
    }

    public final Rect mapRectToDevice(int i, int i2, int i3, int i4, int i5, @NotNull RectF coords) {
        Intrinsics.checkNotNullParameter(coords, "coords");
        if (this.isClosed || this.doc.isClosed()) {
            throw new IllegalStateException("Already closed");
        }
        Point pointMapPageCoordsToDevice = mapPageCoordsToDevice(i, i2, i3, i4, i5, coords.left, coords.top);
        Point pointMapPageCoordsToDevice2 = mapPageCoordsToDevice(i, i2, i3, i4, i5, coords.right, coords.bottom);
        return new Rect(pointMapPageCoordsToDevice.x, pointMapPageCoordsToDevice.y, pointMapPageCoordsToDevice2.x, pointMapPageCoordsToDevice2.y);
    }

    public final RectF mapRectToPage(int i, int i2, int i3, int i4, int i5, @NotNull Rect coords) {
        Intrinsics.checkNotNullParameter(coords, "coords");
        if (this.isClosed || this.doc.isClosed()) {
            throw new IllegalStateException("Already closed");
        }
        PointF pointFMapDeviceCoordsToPage = mapDeviceCoordsToPage(i, i2, i3, i4, i5, coords.left, coords.top);
        PointF pointFMapDeviceCoordsToPage2 = mapDeviceCoordsToPage(i, i2, i3, i4, i5, coords.right, coords.bottom);
        return new RectF(pointFMapDeviceCoordsToPage.x, pointFMapDeviceCoordsToPage.y, pointFMapDeviceCoordsToPage2.x, pointFMapDeviceCoordsToPage2.y);
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
                Companion.nativeClosePage(this.pagePtr);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void nativeClosePage(long j) {
            PdfPage.nativeClosePage(j);
        }

        @JvmStatic
        private final void nativeClosePages(long[] jArr) {
            PdfPage.nativeClosePages(jArr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final float[] nativeDeviceCoordsToPage(long j, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
            return PdfPage.nativeDeviceCoordsToPage(j, i, i2, i3, i4, i5, i6, i7);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int nativeGetDestPageIndex(long j, long j2) {
            return PdfPage.nativeGetDestPageIndex(j, j2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final float[] nativeGetLinkRect(long j, long j2) {
            return PdfPage.nativeGetLinkRect(j, j2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final String nativeGetLinkURI(long j, long j2) {
            return PdfPage.nativeGetLinkURI(j, j2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final float[] nativeGetPageArtBox(long j) {
            return PdfPage.nativeGetPageArtBox(j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final float[] nativeGetPageBleedBox(long j) {
            return PdfPage.nativeGetPageBleedBox(j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final float[] nativeGetPageBoundingBox(long j) {
            return PdfPage.nativeGetPageBoundingBox(j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final float[] nativeGetPageCropBox(long j) {
            return PdfPage.nativeGetPageCropBox(j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int nativeGetPageHeightPixel(long j, int i) {
            return PdfPage.nativeGetPageHeightPixel(j, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int nativeGetPageHeightPoint(long j) {
            return PdfPage.nativeGetPageHeightPoint(j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long[] nativeGetPageLinks(long j) {
            return PdfPage.nativeGetPageLinks(j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final float[] nativeGetPageMatrix(long j) {
            return PdfPage.nativeGetPageMatrix(j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final float[] nativeGetPageMediaBox(long j) {
            return PdfPage.nativeGetPageMediaBox(j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int nativeGetPageRotation(long j) {
            return PdfPage.nativeGetPageRotation(j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int[] nativeGetPageSizeByIndex(long j, int i, int i2) {
            return PdfPage.nativeGetPageSizeByIndex(j, i, i2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final float[] nativeGetPageTrimBox(long j) {
            return PdfPage.nativeGetPageTrimBox(j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int nativeGetPageWidthPixel(long j, int i) {
            return PdfPage.nativeGetPageWidthPixel(j, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int nativeGetPageWidthPoint(long j) {
            return PdfPage.nativeGetPageWidthPoint(j);
        }

        @JvmStatic
        private final boolean nativeLockSurface(Surface surface, int[] iArr, long[] jArr) {
            return PdfPage.nativeLockSurface(surface, iArr, jArr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int[] nativePageCoordsToDevice(long j, int i, int i2, int i3, int i4, int i5, double d, double d2) {
            return PdfPage.nativePageCoordsToDevice(j, i, i2, i3, i4, i5, d, d2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean nativeRenderPage(long j, long j2, int i, int i2, int i3, int i4, boolean z, int i5, int i6) {
            return PdfPage.nativeRenderPage(j, j2, i, i2, i3, i4, z, i5, i6);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void nativeRenderPageBitmap(long j, long j2, Bitmap bitmap, int i, int i2, int i3, int i4, boolean z, boolean z2, int i5, int i6) {
            PdfPage.nativeRenderPageBitmap(j, j2, bitmap, i, i2, i3, i4, z, z2, i5, i6);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void nativeRenderPageBitmapWithMatrix(long j, Bitmap bitmap, float[] fArr, float[] fArr2, boolean z, boolean z2, int i, int i2) {
            PdfPage.nativeRenderPageBitmapWithMatrix(j, bitmap, fArr, fArr2, z, z2, i, i2);
        }

        @JvmStatic
        private final boolean nativeRenderPageSurface(long j, Surface surface, int i, int i2, boolean z, int i3, int i4) {
            return PdfPage.nativeRenderPageSurface(j, surface, i, i2, z, i3, i4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean nativeRenderPageSurfaceWithMatrix(long j, Surface surface, float[] fArr, float[] fArr2, boolean z, boolean z2, int i, int i2) {
            return PdfPage.nativeRenderPageSurfaceWithMatrix(j, surface, fArr, fArr2, z, z2, i, i2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean nativeRenderPageWithMatrix(long j, long j2, int i, int i2, float[] fArr, float[] fArr2, boolean z, boolean z2, int i3, int i4) {
            return PdfPage.nativeRenderPageWithMatrix(j, j2, i, i2, fArr, fArr2, z, z2, i3, i4);
        }

        @JvmStatic
        private final void nativeUnlockSurface(long[] jArr) {
            PdfPage.nativeUnlockSurface(jArr);
        }

        private Companion() {
        }

        public final boolean lockSurface(@NotNull Surface surface, @NotNull int[] dimensions, @NotNull long[] ptrs) {
            boolean zNativeLockSurface;
            Intrinsics.checkNotNullParameter(surface, "surface");
            Intrinsics.checkNotNullParameter(dimensions, "dimensions");
            Intrinsics.checkNotNullParameter(ptrs, "ptrs");
            synchronized (PdfiumCore.Companion.getLock()) {
                zNativeLockSurface = PdfPage.Companion.nativeLockSurface(surface, dimensions, ptrs);
            }
            return zNativeLockSurface;
        }

        public final void unlockSurface(@NotNull long[] ptrs) {
            Intrinsics.checkNotNullParameter(ptrs, "ptrs");
            synchronized (PdfiumCore.Companion.getLock()) {
                PdfPage.Companion.nativeUnlockSurface(ptrs);
                Unit unit = Unit.INSTANCE;
            }
        }
    }
}
