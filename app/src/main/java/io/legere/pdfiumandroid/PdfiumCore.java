package io.legere.pdfiumandroid;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.ParcelFileDescriptor;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Surface;
import com.facebook.imageutils.JfifUtil;
import io.legere.pdfiumandroid.util.Config;
import io.legere.pdfiumandroid.util.ConfigKt;
import io.legere.pdfiumandroid.util.InitLock;
import io.legere.pdfiumandroid.util.PdfiumNativeSourceBridge;
import io.legere.pdfiumandroid.util.Size;
import io.sentry.Session;
import java.io.IOException;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.LongRange;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class PdfiumCore {
    public static final Companion Companion = new Companion(null);
    private static final String TAG;
    private static final InitLock isReady;
    private static final Object lock;
    private static final Mutex surfaceMutex;
    private final Config config;
    private final int mCurrentDpi;

    public PdfiumCore() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use page.close()", replaceWith = @ReplaceWith(expression = "page.close()", imports = {}))
    public final void closePage(@NotNull PdfDocument pdfDocument, int i) {
        Intrinsics.checkNotNullParameter(pdfDocument, "pdfDocument");
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use textPage.close()", replaceWith = @ReplaceWith(expression = "textPage.close()", imports = {}))
    public final void closeTextPage(@NotNull PdfDocument pdfDocument, int i) {
        Intrinsics.checkNotNullParameter(pdfDocument, "pdfDocument");
    }

    public final native long nativeOpenCustomDocument(PdfiumNativeSourceBridge pdfiumNativeSourceBridge, String str, long j);

    public final native long nativeOpenDocument(int i, String str);

    public final native long nativeOpenMemDocument(byte[] bArr, String str);

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use PdfDocument.openPage()", replaceWith = @ReplaceWith(expression = "pdfDocument.openPage(pageIndex)", imports = {}))
    public final long openPage(@NotNull PdfDocument pdfDocument, int i) {
        Intrinsics.checkNotNullParameter(pdfDocument, "pdfDocument");
        return i;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use PdfDocument.openTextPage()", replaceWith = @ReplaceWith(expression = "pdfDocument.openTextPage(pageIndex)", imports = {}))
    public final long openTextPage(@NotNull PdfDocument pdfDocument, int i) {
        Intrinsics.checkNotNullParameter(pdfDocument, "pdfDocument");
        return i;
    }

    public PdfiumCore(@Nullable Context context, @NotNull Config config) {
        Resources resources;
        DisplayMetrics displayMetrics;
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
        ConfigKt.setPdfiumConfig(config);
        Logger logger = Logger.INSTANCE;
        logger.setLogger(config.getLogger());
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        logger.d(TAG2, "Starting PdfiumAndroid ");
        this.mCurrentDpi = (context == null || (resources = context.getResources()) == null || (displayMetrics = resources.getDisplayMetrics()) == null) ? -1 : displayMetrics.densityDpi;
        isReady.waitForReady();
    }

    public /* synthetic */ PdfiumCore(Context context, Config config, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : context, (i & 2) != 0 ? new Config(null, null, 3, null) : config);
    }

    public final Config getConfig() {
        return this.config;
    }

    public final PdfDocument newDocument(@NotNull ParcelFileDescriptor fd) throws IOException {
        Intrinsics.checkNotNullParameter(fd, "fd");
        return newDocument(fd, (String) null);
    }

    public final PdfDocument newDocument(@NotNull ParcelFileDescriptor parcelFileDescriptor, @Nullable String str) throws IOException {
        PdfDocument pdfDocument;
        Intrinsics.checkNotNullParameter(parcelFileDescriptor, "parcelFileDescriptor");
        synchronized (lock) {
            pdfDocument = new PdfDocument(nativeOpenDocument(parcelFileDescriptor.getFd(), str));
            pdfDocument.setParcelFileDescriptor(parcelFileDescriptor);
            pdfDocument.setSource(null);
        }
        return pdfDocument;
    }

    public final PdfDocument newDocument(@Nullable byte[] bArr) throws IOException {
        return newDocument(bArr, (String) null);
    }

    public final PdfDocument newDocument(@Nullable byte[] bArr, @Nullable String str) throws IOException {
        PdfDocument pdfDocument;
        synchronized (lock) {
            pdfDocument = new PdfDocument(nativeOpenMemDocument(bArr, str));
            pdfDocument.setParcelFileDescriptor(null);
            pdfDocument.setSource(null);
        }
        return pdfDocument;
    }

    public final PdfDocument newDocument(@NotNull PdfiumSource data) throws IOException {
        Intrinsics.checkNotNullParameter(data, "data");
        return newDocument(data, (String) null);
    }

    public final PdfDocument newDocument(@NotNull PdfiumSource data, @Nullable String str) throws IOException {
        PdfDocument pdfDocument;
        Intrinsics.checkNotNullParameter(data, "data");
        synchronized (lock) {
            pdfDocument = new PdfDocument(nativeOpenCustomDocument(new PdfiumNativeSourceBridge(data), str, data.getLength()));
            pdfDocument.setParcelFileDescriptor(null);
            pdfDocument.setSource(data);
        }
        return pdfDocument;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use PdfDocument.getPageCount()", replaceWith = @ReplaceWith(expression = "pdfDocument.getPageCount()", imports = {}))
    public final void getPageCount(@NotNull PdfDocument pdfDocument) {
        Intrinsics.checkNotNullParameter(pdfDocument, "pdfDocument");
        pdfDocument.getPageCount();
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use PdfDocument.closeDocument()", replaceWith = @ReplaceWith(expression = "pdfDocument.close()", imports = {}))
    public final void closeDocument(@NotNull PdfDocument pdfDocument) {
        Intrinsics.checkNotNullParameter(pdfDocument, "pdfDocument");
        pdfDocument.close();
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use PdfDocument.getTableOfContents()", replaceWith = @ReplaceWith(expression = "pdfDocument.getTableOfContents()", imports = {}))
    public final List<PdfDocument.Bookmark> getTableOfContents(@NotNull PdfDocument pdfDocument) {
        Intrinsics.checkNotNullParameter(pdfDocument, "pdfDocument");
        return pdfDocument.getTableOfContents();
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use Page.getPageMediaBox()", replaceWith = @ReplaceWith(expression = "page.getPageMediaBox()", imports = {}))
    public final RectF getPageMediaBox(@NotNull PdfDocument pdfDocument, int i) {
        Intrinsics.checkNotNullParameter(pdfDocument, "pdfDocument");
        PdfPage pdfPageOpenPage = pdfDocument.openPage(i);
        try {
            RectF pageMediaBox = pdfPageOpenPage.getPageMediaBox();
            CloseableKt.closeFinally(pdfPageOpenPage, null);
            return pageMediaBox;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(pdfPageOpenPage, th);
                throw th2;
            }
        }
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use textPage.textPageCountChars()", replaceWith = @ReplaceWith(expression = "textPage.textPageCountChars()", imports = {}))
    public final int textPageCountChars(@NotNull PdfDocument pdfDocument, int i) {
        Intrinsics.checkNotNullParameter(pdfDocument, "pdfDocument");
        PdfPage pdfPageOpenPage = pdfDocument.openPage(i);
        try {
            PdfTextPage pdfTextPageOpenTextPage = pdfPageOpenPage.openTextPage();
            try {
                int iTextPageCountChars = pdfTextPageOpenTextPage.textPageCountChars();
                CloseableKt.closeFinally(pdfTextPageOpenTextPage, null);
                CloseableKt.closeFinally(pdfPageOpenPage, null);
                return iTextPageCountChars;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(pdfTextPageOpenTextPage, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            try {
                throw th3;
            } catch (Throwable th4) {
                CloseableKt.closeFinally(pdfPageOpenPage, th3);
                throw th4;
            }
        }
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use textPage.textPageGetText(start, count)", replaceWith = @ReplaceWith(expression = "textPage.textPageGetText(start, count)", imports = {}))
    public final String textPageGetText(@NotNull PdfDocument pdfDocument, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(pdfDocument, "pdfDocument");
        PdfPage pdfPageOpenPage = pdfDocument.openPage(i);
        try {
            PdfTextPage pdfTextPageOpenTextPage = pdfPageOpenPage.openTextPage();
            try {
                String strTextPageGetText = pdfTextPageOpenTextPage.textPageGetText(i2, i3);
                CloseableKt.closeFinally(pdfTextPageOpenTextPage, null);
                CloseableKt.closeFinally(pdfPageOpenPage, null);
                return strTextPageGetText;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(pdfTextPageOpenTextPage, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            try {
                throw th3;
            } catch (Throwable th4) {
                CloseableKt.closeFinally(pdfPageOpenPage, th3);
                throw th4;
            }
        }
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use pdfDocument.getDocumentMeta()", replaceWith = @ReplaceWith(expression = "pdfDocument.getDocumentMeta()", imports = {}))
    public final PdfDocument.Meta getDocumentMeta(@NotNull PdfDocument pdfDocument) {
        Intrinsics.checkNotNullParameter(pdfDocument, "pdfDocument");
        return pdfDocument.getDocumentMeta();
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use PdfPage.getPageWidthPoint()", replaceWith = @ReplaceWith(expression = "page.getPageWidthPoint()", imports = {}))
    public final int getPageWidthPoint(@NotNull PdfDocument pdfDocument, int i) {
        Intrinsics.checkNotNullParameter(pdfDocument, "pdfDocument");
        PdfPage pdfPageOpenPage = pdfDocument.openPage(i);
        try {
            int pageWidthPoint = pdfPageOpenPage.getPageWidthPoint();
            CloseableKt.closeFinally(pdfPageOpenPage, null);
            return pageWidthPoint;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(pdfPageOpenPage, th);
                throw th2;
            }
        }
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use PdfPage.getPageHeightPoint()", replaceWith = @ReplaceWith(expression = "page.getPageHeightPoint()", imports = {}))
    public final int getPageHeightPoint(@NotNull PdfDocument pdfDocument, int i) {
        Intrinsics.checkNotNullParameter(pdfDocument, "pdfDocument");
        PdfPage pdfPageOpenPage = pdfDocument.openPage(i);
        try {
            int pageHeightPoint = pdfPageOpenPage.getPageHeightPoint();
            CloseableKt.closeFinally(pdfPageOpenPage, null);
            return pageHeightPoint;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(pdfPageOpenPage, th);
                throw th2;
            }
        }
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use PdfPage.renderPageBitmap(bitmap, startX, startY, drawSizeX, drawSizeY, screenDpi, renderAnnot, textMask)", replaceWith = @ReplaceWith(expression = "page.renderPageBitmap(bitmap, startX, startY, drawSizeX, drawSizeY, screenDpi, renderAnnot, textMask)", imports = {}))
    public final void renderPageBitmap(@NotNull PdfDocument pdfDocument, @Nullable Bitmap bitmap, int i, int i2, int i3, int i4, int i5, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(pdfDocument, "pdfDocument");
        PdfPage pdfPageOpenPage = pdfDocument.openPage(i);
        try {
            pdfPageOpenPage.renderPageBitmap(bitmap, i2, i3, i4, i5, (448 & 32) != 0 ? false : z, (448 & 64) != 0 ? false : z2, (448 & 128) != 0 ? -8092540 : 0, (448 & 256) != 0 ? -1 : 0);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(pdfPageOpenPage, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(pdfPageOpenPage, th);
                throw th2;
            }
        }
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use PdfPage.textPageGetRect(index)", replaceWith = @ReplaceWith(expression = "page.textPageGetRect(index)", imports = {}))
    public final RectF textPageGetRect(@NotNull PdfDocument pdfDocument, int i, int i2) {
        Intrinsics.checkNotNullParameter(pdfDocument, "pdfDocument");
        PdfPage pdfPageOpenPage = pdfDocument.openPage(i);
        try {
            PdfTextPage pdfTextPageOpenTextPage = pdfPageOpenPage.openTextPage();
            try {
                RectF rectFTextPageGetRect = pdfTextPageOpenTextPage.textPageGetRect(i2);
                CloseableKt.closeFinally(pdfTextPageOpenTextPage, null);
                CloseableKt.closeFinally(pdfPageOpenPage, null);
                return rectFTextPageGetRect;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(pdfTextPageOpenTextPage, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            try {
                throw th3;
            } catch (Throwable th4) {
                CloseableKt.closeFinally(pdfPageOpenPage, th3);
                throw th4;
            }
        }
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use PdfPage.textPageGetBoundedText(sourceRect, size)", replaceWith = @ReplaceWith(expression = "page.textPageGetBoundedText(sourceRect, size)", imports = {}))
    public final String textPageGetBoundedText(@NotNull PdfDocument pdfDocument, int i, @NotNull RectF sourceRect, int i2) {
        Intrinsics.checkNotNullParameter(pdfDocument, "pdfDocument");
        Intrinsics.checkNotNullParameter(sourceRect, "sourceRect");
        PdfPage pdfPageOpenPage = pdfDocument.openPage(i);
        try {
            PdfTextPage pdfTextPageOpenTextPage = pdfPageOpenPage.openTextPage();
            try {
                String strTextPageGetBoundedText = pdfTextPageOpenTextPage.textPageGetBoundedText(sourceRect, i2);
                CloseableKt.closeFinally(pdfTextPageOpenTextPage, null);
                CloseableKt.closeFinally(pdfPageOpenPage, null);
                return strTextPageGetBoundedText;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(pdfTextPageOpenTextPage, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            try {
                throw th3;
            } catch (Throwable th4) {
                CloseableKt.closeFinally(pdfPageOpenPage, th3);
                throw th4;
            }
        }
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use PdfPage.mapRectToPage(startX, startY, sizeX, sizeY, rotate, coords)", replaceWith = @ReplaceWith(expression = "page.mapRectToPage(startX, startY, sizeX, sizeY, rotate, coords)", imports = {}))
    public final RectF mapRectToPage(@NotNull PdfDocument pdfDocument, int i, int i2, int i3, int i4, int i5, int i6, @NotNull Rect coords) {
        Intrinsics.checkNotNullParameter(pdfDocument, "pdfDocument");
        Intrinsics.checkNotNullParameter(coords, "coords");
        PdfPage pdfPageOpenPage = pdfDocument.openPage(i);
        try {
            RectF rectFMapRectToPage = pdfPageOpenPage.mapRectToPage(i2, i3, i4, i5, i6, coords);
            CloseableKt.closeFinally(pdfPageOpenPage, null);
            return rectFMapRectToPage;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(pdfPageOpenPage, th);
                throw th2;
            }
        }
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use PdfTextPage.textPageCountRects(startIndex, count)", replaceWith = @ReplaceWith(expression = "textPage.textPageCountRects(startIndex, count)", imports = {}))
    public final int textPageCountRects(@NotNull PdfDocument pdfDocument, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(pdfDocument, "pdfDocument");
        PdfPage pdfPageOpenPage = pdfDocument.openPage(i);
        try {
            PdfTextPage pdfTextPageOpenTextPage = pdfPageOpenPage.openTextPage();
            try {
                int iTextPageCountRects = pdfTextPageOpenTextPage.textPageCountRects(i2, i3);
                CloseableKt.closeFinally(pdfTextPageOpenTextPage, null);
                CloseableKt.closeFinally(pdfPageOpenPage, null);
                return iTextPageCountRects;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(pdfTextPageOpenTextPage, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            try {
                throw th3;
            } catch (Throwable th4) {
                CloseableKt.closeFinally(pdfPageOpenPage, th3);
                throw th4;
            }
        }
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use PdfDocument.openPage(fromIndex, toIndex)", replaceWith = @ReplaceWith(expression = "pdfDocument.openPage(fromIndex, toIndex)", imports = {}))
    public final Long[] openPage(@NotNull PdfDocument pdfDocument, int i, int i2) {
        Intrinsics.checkNotNullParameter(pdfDocument, "pdfDocument");
        return (Long[]) CollectionsKt___CollectionsKt.toList(new LongRange(i, i2)).toArray(new Long[0]);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use PdfPage.getPageWidth()", replaceWith = @ReplaceWith(expression = "page.getPageWidth()", imports = {}))
    public final int getPageWidth(@NotNull PdfDocument pdfDocument, int i) {
        Intrinsics.checkNotNullParameter(pdfDocument, "pdfDocument");
        PdfPage pdfPageOpenPage = pdfDocument.openPage(i);
        try {
            int pageWidth = pdfPageOpenPage.getPageWidth(this.mCurrentDpi);
            CloseableKt.closeFinally(pdfPageOpenPage, null);
            return pageWidth;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(pdfPageOpenPage, th);
                throw th2;
            }
        }
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use PdfPage.getPageHeight()", replaceWith = @ReplaceWith(expression = "page.getPageHeight()", imports = {}))
    public final int getPageHeight(@NotNull PdfDocument pdfDocument, int i) {
        Intrinsics.checkNotNullParameter(pdfDocument, "pdfDocument");
        PdfPage pdfPageOpenPage = pdfDocument.openPage(i);
        try {
            int pageHeight = pdfPageOpenPage.getPageHeight(this.mCurrentDpi);
            CloseableKt.closeFinally(pdfPageOpenPage, null);
            return pageHeight;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(pdfPageOpenPage, th);
                throw th2;
            }
        }
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use PdfPage.getPageSize()", replaceWith = @ReplaceWith(expression = "page.getPageSize()", imports = {}))
    public final Size getPageSize(@NotNull PdfDocument pdfDocument, int i) {
        Intrinsics.checkNotNullParameter(pdfDocument, "pdfDocument");
        PdfPage pdfPageOpenPage = pdfDocument.openPage(i);
        try {
            Size pageSize = pdfPageOpenPage.getPageSize(this.mCurrentDpi);
            CloseableKt.closeFinally(pdfPageOpenPage, null);
            return pageSize;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(pdfPageOpenPage, th);
                throw th2;
            }
        }
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use PdfPage.renderPage(surface, startX, startY, drawSizeX, drawSizeY)", replaceWith = @ReplaceWith(expression = "page.renderPage(surface, startX, startY, drawSizeX, drawSizeY)", imports = {}))
    public final boolean renderPage(@NotNull PdfDocument pdfDocument, @Nullable Surface surface, int i, int i2, int i3, int i4, int i5, boolean z) {
        Intrinsics.checkNotNullParameter(pdfDocument, "pdfDocument");
        PdfPage pdfPageOpenPage = pdfDocument.openPage(i);
        try {
            int[] iArr = new int[2];
            long[] jArr = new long[2];
            if (surface != null) {
                PdfPage.Companion.lockSurface(surface, iArr, jArr);
            }
            boolean zRenderPage = false;
            long j = jArr[0];
            long j2 = jArr[1];
            if (j2 != 0 && j2 != -1 && j != 0 && j != -1) {
                zRenderPage = pdfPageOpenPage.renderPage(j2, i2, i3, i4, i5, (JfifUtil.MARKER_SOFn & 32) != 0 ? false : z, (JfifUtil.MARKER_SOFn & 64) != 0 ? -8092540 : 0, (JfifUtil.MARKER_SOFn & 128) != 0 ? -1 : 0);
                if (surface != null) {
                    PdfPage.Companion.unlockSurface(jArr);
                }
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(pdfPageOpenPage, null);
            return zRenderPage;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(pdfPageOpenPage, th);
                throw th2;
            }
        }
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use PdfPage.renderPageBitmap(bitmap, startX, startY, drawSizeX, drawSizeY)", replaceWith = @ReplaceWith(expression = "page.renderPageBitmap(bitmap, startX, startY, drawSizeX, drawSizeY)", imports = {}))
    public final void renderPageBitmap(@NotNull PdfDocument pdfDocument, @Nullable Bitmap bitmap, int i, int i2, int i3, int i4, int i5, boolean z) {
        Intrinsics.checkNotNullParameter(pdfDocument, "pdfDocument");
        PdfPage pdfPageOpenPage = pdfDocument.openPage(i);
        try {
            pdfPageOpenPage.renderPageBitmap(bitmap, i2, i3, i4, i5, (448 & 32) != 0 ? false : z, (448 & 64) != 0 ? false : false, (448 & 128) != 0 ? -8092540 : 0, (448 & 256) != 0 ? -1 : 0);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(pdfPageOpenPage, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(pdfPageOpenPage, th);
                throw th2;
            }
        }
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use PdfPage.getPageLinks()", replaceWith = @ReplaceWith(expression = "page.getPageLinks()", imports = {}))
    public final List<PdfDocument.Link> getPageLinks(@NotNull PdfDocument pdfDocument, int i) {
        Intrinsics.checkNotNullParameter(pdfDocument, "pdfDocument");
        PdfPage pdfPageOpenPage = pdfDocument.openPage(i);
        try {
            List<PdfDocument.Link> pageLinks = pdfPageOpenPage.getPageLinks();
            CloseableKt.closeFinally(pdfPageOpenPage, null);
            return pageLinks;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(pdfPageOpenPage, th);
                throw th2;
            }
        }
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use PdfPage.mapPageCoordsToDevice(startX, startY, sizeX, sizeY, rotate, pageX, pageY)", replaceWith = @ReplaceWith(expression = "page.mapPageCoordsToDevice(startX, startY, sizeX, sizeY, rotate, pageX, pageY)", imports = {}))
    public final Point mapPageCoordsToDevice(@NotNull PdfDocument pdfDocument, int i, int i2, int i3, int i4, int i5, int i6, double d, double d2) {
        Intrinsics.checkNotNullParameter(pdfDocument, "pdfDocument");
        PdfPage pdfPageOpenPage = pdfDocument.openPage(i);
        try {
            Point pointMapPageCoordsToDevice = pdfPageOpenPage.mapPageCoordsToDevice(i2, i3, i4, i5, i6, d, d2);
            CloseableKt.closeFinally(pdfPageOpenPage, null);
            return pointMapPageCoordsToDevice;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(pdfPageOpenPage, th);
                throw th2;
            }
        }
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use PdfPage.mapRectToDevice(startX, startY, sizeX, sizeY, rotate, coords)", replaceWith = @ReplaceWith(expression = "page.mapRectToDevice(startX, startY, sizeX, sizeY, rotate, coords)", imports = {}))
    public final Rect mapRectToDevice(@NotNull PdfDocument pdfDocument, int i, int i2, int i3, int i4, int i5, int i6, @NotNull RectF coords) {
        Intrinsics.checkNotNullParameter(pdfDocument, "pdfDocument");
        Intrinsics.checkNotNullParameter(coords, "coords");
        PdfPage pdfPageOpenPage = pdfDocument.openPage(i);
        try {
            Rect rectMapRectToDevice = pdfPageOpenPage.mapRectToDevice(i2, i3, i4, i5, i6, coords);
            CloseableKt.closeFinally(pdfPageOpenPage, null);
            return rectMapRectToDevice;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(pdfPageOpenPage, th);
                throw th2;
            }
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Object getLock() {
            return PdfiumCore.lock;
        }

        public final Mutex getSurfaceMutex() {
            return PdfiumCore.surfaceMutex;
        }

        public final InitLock isReady() {
            return PdfiumCore.isReady;
        }
    }

    static {
        String name = PdfiumCore.class.getName();
        TAG = name;
        lock = new Object();
        surfaceMutex = MutexKt.Mutex$default(false, 1, null);
        isReady = new InitLock();
        Log.d(name, Session.JsonKeys.INIT);
        new Thread(new Runnable() { // from class: io.legere.pdfiumandroid.PdfiumCore$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                PdfiumCore._init_$lambda$32();
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$32() {
        String str = TAG;
        Log.d(str, "init thread start");
        synchronized (lock) {
            Log.d(str, "init in lock");
            try {
                System.loadLibrary("pdfium");
                System.loadLibrary("pdfiumandroid");
                isReady.markReady();
            } catch (UnsatisfiedLinkError e) {
                Logger logger = Logger.INSTANCE;
                String TAG2 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                logger.e(TAG2, e, "Native libraries failed to load");
            }
            Log.d(TAG, "init in lock");
            Unit unit = Unit.INSTANCE;
        }
    }
}
