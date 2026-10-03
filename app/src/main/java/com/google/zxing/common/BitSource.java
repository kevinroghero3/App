package com.google.zxing.common;

/* JADX INFO: loaded from: classes6.dex */
public final class BitSource {
    private int bitOffset;
    private int byteOffset;
    private final byte[] bytes;

    public BitSource(byte[] bArr) {
        this.bytes = bArr;
    }

    public int getBitOffset() {
        return this.bitOffset;
    }

    public int getByteOffset() {
        return this.byteOffset;
    }

    public int readBits(int i) {
        if (i <= 0 || i > 32 || i > available()) {
            throw new IllegalArgumentException(String.valueOf(i));
        }
        int i2 = this.bitOffset;
        int i3 = 0;
        if (i2 > 0) {
            int i4 = 8 - i2;
            int i5 = i < i4 ? i : i4;
            int i6 = i4 - i5;
            byte[] bArr = this.bytes;
            int i7 = this.byteOffset;
            byte b = bArr[i7];
            i -= i5;
            int i8 = i2 + i5;
            this.bitOffset = i8;
            if (i8 == 8) {
                this.bitOffset = 0;
                this.byteOffset = i7 + 1;
            }
            i3 = (((255 >> (8 - i5)) << i6) & b) >> i6;
        }
        if (i <= 0) {
            return i3;
        }
        while (i >= 8) {
            byte[] bArr2 = this.bytes;
            int i9 = this.byteOffset;
            i3 = (i3 << 8) | (bArr2[i9] & 255);
            this.byteOffset = i9 + 1;
            i -= 8;
        }
        if (i <= 0) {
            return i3;
        }
        int i10 = 8 - i;
        int i11 = (i3 << i) | ((((255 >> i10) << i10) & this.bytes[this.byteOffset]) >> i10);
        this.bitOffset += i;
        return i11;
    }

    public int available() {
        return ((this.bytes.length - this.byteOffset) * 8) - this.bitOffset;
    }
}
