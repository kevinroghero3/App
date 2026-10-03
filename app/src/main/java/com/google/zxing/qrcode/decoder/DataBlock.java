package com.google.zxing.qrcode.decoder;

/* JADX INFO: loaded from: classes6.dex */
final class DataBlock {
    private final byte[] codewords;
    private final int numDataCodewords;

    private DataBlock(int i, byte[] bArr) {
        this.numDataCodewords = i;
        this.codewords = bArr;
    }

    static DataBlock[] getDataBlocks(byte[] bArr, Version version, ErrorCorrectionLevel errorCorrectionLevel) {
        if (bArr.length != version.getTotalCodewords()) {
            throw new IllegalArgumentException();
        }
        Version.ECBlocks eCBlocksForLevel = version.getECBlocksForLevel(errorCorrectionLevel);
        Version.ECB[] eCBlocks = eCBlocksForLevel.getECBlocks();
        int count = 0;
        for (Version.ECB ecb : eCBlocks) {
            count += ecb.getCount();
        }
        DataBlock[] dataBlockArr = new DataBlock[count];
        int i = 0;
        for (Version.ECB ecb2 : eCBlocks) {
            int i2 = 0;
            while (i2 < ecb2.getCount()) {
                int dataCodewords = ecb2.getDataCodewords();
                dataBlockArr[i] = new DataBlock(dataCodewords, new byte[eCBlocksForLevel.getECCodewordsPerBlock() + dataCodewords]);
                i2++;
                i++;
            }
        }
        int length = dataBlockArr[0].codewords.length;
        do {
            count--;
            if (count < 0) {
                break;
            }
        } while (dataBlockArr[count].codewords.length != length);
        int i3 = count + 1;
        int eCCodewordsPerBlock = length - eCBlocksForLevel.getECCodewordsPerBlock();
        int i4 = 0;
        for (int i5 = 0; i5 < eCCodewordsPerBlock; i5++) {
            int i6 = 0;
            while (i6 < i) {
                dataBlockArr[i6].codewords[i5] = bArr[i4];
                i6++;
                i4++;
            }
        }
        int i7 = i3;
        while (i7 < i) {
            dataBlockArr[i7].codewords[eCCodewordsPerBlock] = bArr[i4];
            i7++;
            i4++;
        }
        int length2 = dataBlockArr[0].codewords.length;
        while (eCCodewordsPerBlock < length2) {
            int i8 = 0;
            while (i8 < i) {
                dataBlockArr[i8].codewords[i8 < i3 ? eCCodewordsPerBlock : eCCodewordsPerBlock + 1] = bArr[i4];
                i8++;
                i4++;
            }
            eCCodewordsPerBlock++;
        }
        return dataBlockArr;
    }

    int getNumDataCodewords() {
        return this.numDataCodewords;
    }

    byte[] getCodewords() {
        return this.codewords;
    }
}
