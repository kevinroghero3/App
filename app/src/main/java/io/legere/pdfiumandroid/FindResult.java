package io.legere.pdfiumandroid;

import java.io.Closeable;
import kotlin.Unit;

/* JADX INFO: loaded from: classes6.dex */
public final class FindResult implements Closeable {
    private final long handle;

    public final native void nativeCloseFind(long j);

    public final native boolean nativeFindNext(long j);

    public final native boolean nativeFindPrev(long j);

    public final native int nativeGetSchCount(long j);

    public final native int nativeGetSchResultIndex(long j);

    public FindResult(long j) {
        this.handle = j;
    }

    public final long getHandle() {
        return this.handle;
    }

    public final boolean findNext() {
        boolean zNativeFindNext;
        synchronized (PdfiumCore.Companion.getLock()) {
            zNativeFindNext = nativeFindNext(this.handle);
        }
        return zNativeFindNext;
    }

    public final boolean findPrev() {
        boolean zNativeFindPrev;
        synchronized (PdfiumCore.Companion.getLock()) {
            zNativeFindPrev = nativeFindPrev(this.handle);
        }
        return zNativeFindPrev;
    }

    public final int getSchResultIndex() {
        int iNativeGetSchResultIndex;
        synchronized (PdfiumCore.Companion.getLock()) {
            iNativeGetSchResultIndex = nativeGetSchResultIndex(this.handle);
        }
        return iNativeGetSchResultIndex;
    }

    public final int getSchCount() {
        int iNativeGetSchCount;
        synchronized (PdfiumCore.Companion.getLock()) {
            iNativeGetSchCount = nativeGetSchCount(this.handle);
        }
        return iNativeGetSchCount;
    }

    public final void closeFind() {
        synchronized (PdfiumCore.Companion.getLock()) {
            nativeCloseFind(this.handle);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        nativeCloseFind(this.handle);
    }
}
