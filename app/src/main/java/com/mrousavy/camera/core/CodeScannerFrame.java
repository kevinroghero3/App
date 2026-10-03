package com.mrousavy.camera.core;

import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class CodeScannerFrame {
    private final int height;
    private final int width;

    public static /* synthetic */ CodeScannerFrame copy$default(CodeScannerFrame codeScannerFrame, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = codeScannerFrame.width;
        }
        if ((i3 & 2) != 0) {
            i2 = codeScannerFrame.height;
        }
        return codeScannerFrame.copy(i, i2);
    }

    public final int component1() {
        return this.width;
    }

    public final int component2() {
        return this.height;
    }

    public final CodeScannerFrame copy(int i, int i2) {
        return new CodeScannerFrame(i, i2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CodeScannerFrame)) {
            return false;
        }
        CodeScannerFrame codeScannerFrame = (CodeScannerFrame) obj;
        return this.width == codeScannerFrame.width && this.height == codeScannerFrame.height;
    }

    public int hashCode() {
        return (Integer.hashCode(this.width) * 31) + Integer.hashCode(this.height);
    }

    public String toString() {
        return "CodeScannerFrame(width=" + this.width + ", height=" + this.height + ")";
    }

    public CodeScannerFrame(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getWidth() {
        return this.width;
    }
}
