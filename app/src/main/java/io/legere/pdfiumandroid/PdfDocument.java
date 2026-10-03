package io.legere.pdfiumandroid;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.ParcelFileDescriptor;
import android.view.Surface;
import ch.qos.logback.core.CoreConstants;
import io.legere.pdfiumandroid.util.ConfigKt;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class PdfDocument implements Closeable {
    public static final int FPDF_INCREMENTAL = 1;
    public static final int FPDF_NO_INCREMENTAL = 2;
    public static final int FPDF_REMOVE_SECURITY = 3;
    private boolean isClosed;
    private final long mNativeDocPtr;
    private ParcelFileDescriptor parcelFileDescriptor;
    private PdfiumSource source;
    public static final Companion Companion = new Companion(null);
    private static final String TAG = PdfDocument.class.getName();
    private final Map<Integer, PageCount> pageMap = new LinkedHashMap();
    private final Map<Integer, PageCount> textPageMap = new LinkedHashMap();

    public final native void nativeCloseDocument(long j);

    public final native void nativeDeletePage(long j, int i);

    public final native long nativeGetBookmarkDestIndex(long j, long j2);

    public final native String nativeGetBookmarkTitle(long j);

    public final native String nativeGetDocumentMetaText(long j, String str);

    public final native long nativeGetFirstChildBookmark(long j, long j2);

    public final native int[] nativeGetPageCharCounts(long j);

    public final native int nativeGetPageCount(long j);

    public final native long nativeGetSiblingBookmark(long j, long j2);

    public final native long nativeLoadPage(long j, int i);

    public final native long[] nativeLoadPages(long j, int i, int i2);

    public final native long nativeLoadTextPage(long j, long j2);

    public final native boolean nativeRenderPagesSurfaceWithMatrix(long[] jArr, Surface surface, float[] fArr, float[] fArr2, boolean z, boolean z2, int i, int i2);

    public final native void nativeRenderPagesWithMatrix(long[] jArr, long j, int i, int i2, float[] fArr, float[] fArr2, boolean z, boolean z2, int i3, int i4);

    public final native boolean nativeSaveAsCopy(long j, PdfWriteCallback pdfWriteCallback, int i);

    public PdfDocument(long j) {
        this.mNativeDocPtr = j;
    }

    public final long getMNativeDocPtr() {
        return this.mNativeDocPtr;
    }

    public final boolean isClosed() {
        return this.isClosed;
    }

    public final ParcelFileDescriptor getParcelFileDescriptor() {
        return this.parcelFileDescriptor;
    }

    public final void setParcelFileDescriptor(@Nullable ParcelFileDescriptor parcelFileDescriptor) {
        this.parcelFileDescriptor = parcelFileDescriptor;
    }

    public final PdfiumSource getSource() {
        return this.source;
    }

    public final void setSource(@Nullable PdfiumSource pdfiumSource) {
        this.source = pdfiumSource;
    }

    public final int getPageCount() {
        int iNativeGetPageCount;
        if (ConfigKt.handleAlreadyClosed(this.isClosed)) {
            return 0;
        }
        synchronized (PdfiumCore.Companion.getLock()) {
            iNativeGetPageCount = nativeGetPageCount(this.mNativeDocPtr);
        }
        return iNativeGetPageCount;
    }

    public final int[] getPageCharCounts() {
        int[] iArrNativeGetPageCharCounts;
        if (ConfigKt.handleAlreadyClosed(this.isClosed)) {
            return new int[0];
        }
        synchronized (PdfiumCore.Companion.getLock()) {
            iArrNativeGetPageCharCounts = nativeGetPageCharCounts(this.mNativeDocPtr);
        }
        return iArrNativeGetPageCharCounts;
    }

    public final PdfPage openPage(int i) {
        PageCount pageCount;
        if (this.isClosed) {
            throw new IllegalStateException("Already closed");
        }
        synchronized (PdfiumCore.Companion.getLock()) {
            if (this.pageMap.containsKey(Integer.valueOf(i)) && (pageCount = this.pageMap.get(Integer.valueOf(i))) != null) {
                pageCount.setCount(pageCount.getCount() + 1);
                return new PdfPage(this, i, pageCount.getPagePtr(), this.pageMap);
            }
            long jNativeLoadPage = nativeLoadPage(this.mNativeDocPtr, i);
            this.pageMap.put(Integer.valueOf(i), new PageCount(jNativeLoadPage, 1));
            return new PdfPage(this, i, jNativeLoadPage, this.pageMap);
        }
    }

    public final void deletePage(int i) {
        if (ConfigKt.handleAlreadyClosed(this.isClosed)) {
            return;
        }
        synchronized (PdfiumCore.Companion.getLock()) {
            nativeDeletePage(this.mNativeDocPtr, i);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final List<PdfPage> openPages(int i, int i2) {
        ArrayList arrayList;
        if (ConfigKt.handleAlreadyClosed(this.isClosed)) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        synchronized (PdfiumCore.Companion.getLock()) {
            long[] jArrNativeLoadPages = nativeLoadPages(this.mNativeDocPtr, i, i2);
            for (long j : jArrNativeLoadPages) {
                if (i > i2) {
                    break;
                }
                i++;
            }
            arrayList = new ArrayList(jArrNativeLoadPages.length);
            for (long j2 : jArrNativeLoadPages) {
                arrayList.add(new PdfPage(this, i, j2, this.pageMap));
            }
        }
        return arrayList;
    }

    public final void renderPages(long j, int i, int i2, @NotNull List<PdfPage> pages, @NotNull List<? extends Matrix> matrices, @NotNull List<? extends RectF> clipRects, boolean z, boolean z2, int i3, int i4) {
        boolean z3;
        Intrinsics.checkNotNullParameter(pages, "pages");
        Intrinsics.checkNotNullParameter(matrices, "matrices");
        Intrinsics.checkNotNullParameter(clipRects, "clipRects");
        if (this.isClosed) {
            z3 = true;
        } else {
            List<PdfPage> list = pages;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it2 = list.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (((PdfPage) it2.next()).isClosed$pdfiumandroid_release()) {
                            z3 = true;
                        }
                    }
                }
            }
            z3 = false;
        }
        if (ConfigKt.handleAlreadyClosed(z3)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it3 = matrices.iterator();
        while (it3.hasNext()) {
            float[] fArr = new float[9];
            ((Matrix) it3.next()).getValues(fArr);
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, CollectionsKt__CollectionsKt.listOf((Object[]) new Float[]{Float.valueOf(fArr[0]), Float.valueOf(fArr[2]), Float.valueOf(fArr[5])}));
        }
        float[] floatArray = CollectionsKt___CollectionsKt.toFloatArray(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (RectF rectF : clipRects) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList2, CollectionsKt__CollectionsKt.listOf((Object[]) new Float[]{Float.valueOf(rectF.left), Float.valueOf(rectF.top), Float.valueOf(rectF.right), Float.valueOf(rectF.bottom)}));
        }
        float[] floatArray2 = CollectionsKt___CollectionsKt.toFloatArray(arrayList2);
        synchronized (PdfiumCore.Companion.getLock()) {
            List<PdfPage> list2 = pages;
            ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it4 = list2.iterator();
            while (it4.hasNext()) {
                arrayList3.add(Long.valueOf(((PdfPage) it4.next()).getPagePtr()));
            }
            nativeRenderPagesWithMatrix(CollectionsKt___CollectionsKt.toLongArray(arrayList3), j, i, i2, floatArray, floatArray2, z, z2, i3, i4);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final boolean renderPages(@NotNull Surface surface, @NotNull List<PdfPage> pages, @NotNull List<? extends Matrix> matrices, @NotNull List<? extends RectF> clipRects, boolean z, boolean z2, int i, int i2) {
        boolean z3;
        boolean zNativeRenderPagesSurfaceWithMatrix;
        Intrinsics.checkNotNullParameter(surface, "surface");
        Intrinsics.checkNotNullParameter(pages, "pages");
        Intrinsics.checkNotNullParameter(matrices, "matrices");
        Intrinsics.checkNotNullParameter(clipRects, "clipRects");
        if (this.isClosed) {
            z3 = true;
        } else {
            List<PdfPage> list = pages;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it2 = list.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (((PdfPage) it2.next()).isClosed$pdfiumandroid_release()) {
                            z3 = true;
                        }
                    }
                }
            }
            z3 = false;
        }
        if (ConfigKt.handleAlreadyClosed(z3)) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it3 = matrices.iterator();
        while (it3.hasNext()) {
            float[] fArr = new float[9];
            ((Matrix) it3.next()).getValues(fArr);
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, CollectionsKt__CollectionsKt.listOf((Object[]) new Float[]{Float.valueOf(fArr[0]), Float.valueOf(fArr[2]), Float.valueOf(fArr[5])}));
        }
        float[] floatArray = CollectionsKt___CollectionsKt.toFloatArray(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (RectF rectF : clipRects) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList2, CollectionsKt__CollectionsKt.listOf((Object[]) new Float[]{Float.valueOf(rectF.left), Float.valueOf(rectF.top), Float.valueOf(rectF.right), Float.valueOf(rectF.bottom)}));
        }
        float[] floatArray2 = CollectionsKt___CollectionsKt.toFloatArray(arrayList2);
        synchronized (PdfiumCore.Companion.getLock()) {
            List<PdfPage> list2 = pages;
            ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it4 = list2.iterator();
            while (it4.hasNext()) {
                arrayList3.add(Long.valueOf(((PdfPage) it4.next()).getPagePtr()));
            }
            zNativeRenderPagesSurfaceWithMatrix = nativeRenderPagesSurfaceWithMatrix(CollectionsKt___CollectionsKt.toLongArray(arrayList3), surface, floatArray, floatArray2, z, z2, i, i2);
        }
        return zNativeRenderPagesSurfaceWithMatrix;
    }

    public final Meta getDocumentMeta() {
        Meta meta;
        if (ConfigKt.handleAlreadyClosed(this.isClosed)) {
            return new Meta();
        }
        synchronized (PdfiumCore.Companion.getLock()) {
            meta = new Meta();
            meta.setTitle(nativeGetDocumentMetaText(this.mNativeDocPtr, "Title"));
            meta.setAuthor(nativeGetDocumentMetaText(this.mNativeDocPtr, "Author"));
            meta.setSubject(nativeGetDocumentMetaText(this.mNativeDocPtr, "Subject"));
            meta.setKeywords(nativeGetDocumentMetaText(this.mNativeDocPtr, "Keywords"));
            meta.setCreator(nativeGetDocumentMetaText(this.mNativeDocPtr, "Creator"));
            meta.setProducer(nativeGetDocumentMetaText(this.mNativeDocPtr, "Producer"));
            meta.setCreationDate(nativeGetDocumentMetaText(this.mNativeDocPtr, "CreationDate"));
            meta.setModDate(nativeGetDocumentMetaText(this.mNativeDocPtr, "ModDate"));
        }
        return meta;
    }

    private final void recursiveGetBookmark(List<Bookmark> list, long j, long j2) {
        long j3;
        if (ConfigKt.handleAlreadyClosed(this.isClosed)) {
            return;
        }
        Bookmark bookmark = new Bookmark();
        bookmark.setMNativePtr(j);
        bookmark.setTitle(nativeGetBookmarkTitle(j));
        bookmark.setPageIdx(nativeGetBookmarkDestIndex(this.mNativeDocPtr, j));
        list.add(bookmark);
        long jNativeGetFirstChildBookmark = nativeGetFirstChildBookmark(this.mNativeDocPtr, j);
        if (jNativeGetFirstChildBookmark == 0 || j2 >= 16) {
            j3 = j2;
        } else {
            recursiveGetBookmark(bookmark.getChildren(), jNativeGetFirstChildBookmark, j2);
            j3 = j2 + 1;
        }
        long jNativeGetSiblingBookmark = nativeGetSiblingBookmark(this.mNativeDocPtr, j);
        if (jNativeGetSiblingBookmark == 0 || j3 >= 16) {
            return;
        }
        recursiveGetBookmark(list, jNativeGetSiblingBookmark, j3);
    }

    public final List<Bookmark> getTableOfContents() {
        ArrayList arrayList;
        if (ConfigKt.handleAlreadyClosed(this.isClosed)) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        synchronized (PdfiumCore.Companion.getLock()) {
            arrayList = new ArrayList();
            long jNativeGetFirstChildBookmark = nativeGetFirstChildBookmark(this.mNativeDocPtr, 0L);
            if (jNativeGetFirstChildBookmark != 0) {
                recursiveGetBookmark(arrayList, jNativeGetFirstChildBookmark, 1L);
            }
        }
        return arrayList;
    }

    @Deprecated(message = "Use PdfPage.openTextPage instead", replaceWith = @ReplaceWith(expression = "page.openTextPage()", imports = {}))
    public final PdfTextPage openTextPage(@NotNull PdfPage page) {
        PageCount pageCount;
        Intrinsics.checkNotNullParameter(page, "page");
        if (this.isClosed) {
            throw new IllegalStateException("Already closed");
        }
        synchronized (PdfiumCore.Companion.getLock()) {
            if (this.textPageMap.containsKey(Integer.valueOf(page.getPageIndex())) && (pageCount = this.textPageMap.get(Integer.valueOf(page.getPageIndex()))) != null) {
                pageCount.setCount(pageCount.getCount() + 1);
                return new PdfTextPage(this, page.getPageIndex(), pageCount.getPagePtr(), this.textPageMap);
            }
            long jNativeLoadTextPage = nativeLoadTextPage(this.mNativeDocPtr, page.getPagePtr());
            this.textPageMap.put(Integer.valueOf(page.getPageIndex()), new PageCount(jNativeLoadTextPage, 1));
            return new PdfTextPage(this, page.getPageIndex(), jNativeLoadTextPage, this.textPageMap);
        }
    }

    public final List<PdfTextPage> openTextPages(int i, int i2) {
        ArrayList arrayList;
        if (ConfigKt.handleAlreadyClosed(this.isClosed)) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        synchronized (PdfiumCore.Companion.getLock()) {
            long[] jArrNativeLoadPages = nativeLoadPages(this.mNativeDocPtr, i, i2);
            arrayList = new ArrayList(jArrNativeLoadPages.length);
            int length = jArrNativeLoadPages.length;
            int i3 = 0;
            int i4 = 0;
            while (i3 < length) {
                arrayList.add(new PdfTextPage(this, i + i4, jArrNativeLoadPages[i3], this.textPageMap));
                i3++;
                i4++;
            }
        }
        return arrayList;
    }

    public static /* synthetic */ boolean saveAsCopy$default(PdfDocument pdfDocument, PdfWriteCallback pdfWriteCallback, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 2;
        }
        return pdfDocument.saveAsCopy(pdfWriteCallback, i);
    }

    public final boolean saveAsCopy(@NotNull PdfWriteCallback callback, int i) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (ConfigKt.handleAlreadyClosed(this.isClosed)) {
            return false;
        }
        return nativeSaveAsCopy(this.mNativeDocPtr, callback, i);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (ConfigKt.handleAlreadyClosed(this.isClosed)) {
            return;
        }
        Logger logger = Logger.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        logger.d(TAG2, "PdfDocument.close");
        synchronized (PdfiumCore.Companion.getLock()) {
            this.isClosed = true;
            nativeCloseDocument(this.mNativeDocPtr);
            ParcelFileDescriptor parcelFileDescriptor = this.parcelFileDescriptor;
            if (parcelFileDescriptor != null) {
                parcelFileDescriptor.close();
            }
            this.parcelFileDescriptor = null;
            PdfiumSource pdfiumSource = this.source;
            if (pdfiumSource != null) {
                pdfiumSource.close();
            }
            this.source = null;
            Unit unit = Unit.INSTANCE;
        }
    }

    public static final class Meta {
        private String author;
        private String creationDate;
        private String creator;
        private String keywords;
        private String modDate;
        private String producer;
        private String subject;
        private String title;

        public final String getTitle() {
            return this.title;
        }

        public final void setTitle(@Nullable String str) {
            this.title = str;
        }

        public final String getAuthor() {
            return this.author;
        }

        public final void setAuthor(@Nullable String str) {
            this.author = str;
        }

        public final String getSubject() {
            return this.subject;
        }

        public final void setSubject(@Nullable String str) {
            this.subject = str;
        }

        public final String getKeywords() {
            return this.keywords;
        }

        public final void setKeywords(@Nullable String str) {
            this.keywords = str;
        }

        public final String getCreator() {
            return this.creator;
        }

        public final void setCreator(@Nullable String str) {
            this.creator = str;
        }

        public final String getProducer() {
            return this.producer;
        }

        public final void setProducer(@Nullable String str) {
            this.producer = str;
        }

        public final String getCreationDate() {
            return this.creationDate;
        }

        public final void setCreationDate(@Nullable String str) {
            this.creationDate = str;
        }

        public final String getModDate() {
            return this.modDate;
        }

        public final void setModDate(@Nullable String str) {
            this.modDate = str;
        }
    }

    public static final class Bookmark {
        private final List<Bookmark> children = new ArrayList();
        private long mNativePtr;
        private long pageIdx;
        private String title;

        public final List<Bookmark> getChildren() {
            return this.children;
        }

        public final String getTitle() {
            return this.title;
        }

        public final void setTitle(@Nullable String str) {
            this.title = str;
        }

        public final long getPageIdx() {
            return this.pageIdx;
        }

        public final void setPageIdx(long j) {
            this.pageIdx = j;
        }

        public final long getMNativePtr() {
            return this.mNativePtr;
        }

        public final void setMNativePtr(long j) {
            this.mNativePtr = j;
        }
    }

    public static final class Link {
        private final RectF bounds;
        private final Integer destPageIdx;
        private final String uri;

        public Link(@NotNull RectF bounds, @Nullable Integer num, @Nullable String str) {
            Intrinsics.checkNotNullParameter(bounds, "bounds");
            this.bounds = bounds;
            this.destPageIdx = num;
            this.uri = str;
        }

        public final RectF getBounds() {
            return this.bounds;
        }

        public final Integer getDestPageIdx() {
            return this.destPageIdx;
        }

        public final String getUri() {
            return this.uri;
        }
    }

    public static final class PageCount {
        private int count;
        private final long pagePtr;

        public static /* synthetic */ PageCount copy$default(PageCount pageCount, long j, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                j = pageCount.pagePtr;
            }
            if ((i2 & 2) != 0) {
                i = pageCount.count;
            }
            return pageCount.copy(j, i);
        }

        public final long component1() {
            return this.pagePtr;
        }

        public final int component2() {
            return this.count;
        }

        public final PageCount copy(long j, int i) {
            return new PageCount(j, i);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PageCount)) {
                return false;
            }
            PageCount pageCount = (PageCount) obj;
            return this.pagePtr == pageCount.pagePtr && this.count == pageCount.count;
        }

        public int hashCode() {
            return (Long.hashCode(this.pagePtr) * 31) + Integer.hashCode(this.count);
        }

        public String toString() {
            return "PageCount(pagePtr=" + this.pagePtr + ", count=" + this.count + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public PageCount(long j, int i) {
            this.pagePtr = j;
            this.count = i;
        }

        public final long getPagePtr() {
            return this.pagePtr;
        }

        public final int getCount() {
            return this.count;
        }

        public final void setCount(int i) {
            this.count = i;
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
