package com.google.crypto.tink.internal;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.google.crypto.tink.subtle.Bytes;
import com.google.crypto.tink.subtle.EngineFactory;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class Ed25519 {
    public static final int PUBLIC_KEY_LEN = 32;
    public static final int SECRET_KEY_LEN = 32;
    public static final int SIGNATURE_LEN = 64;
    private static final CachedXYT CACHED_NEUTRAL = new CachedXYT(new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
    private static final PartialXYZT NEUTRAL = new PartialXYZT(new XYZ(new long[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}), new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0});
    static final byte[] GROUP_ORDER = {-19, -45, -11, 92, Ascii.SUB, 99, Ascii.DC2, 88, -42, -100, -9, -94, -34, -7, -34, Ascii.DC4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, Ascii.DLE};

    private static int eq(int i, int i2) {
        int i3 = (~(i ^ i2)) & 255;
        int i4 = i3 & (i3 << 4);
        int i5 = i4 & (i4 << 2);
        return ((i5 & (i5 << 1)) >> 7) & 1;
    }

    static class XYZ {
        final long[] x;
        final long[] y;
        final long[] z;

        XYZ() {
            this(new long[10], new long[10], new long[10]);
        }

        XYZ(long[] jArr, long[] jArr2, long[] jArr3) {
            this.x = jArr;
            this.y = jArr2;
            this.z = jArr3;
        }

        XYZ(XYZ xyz) {
            this.x = Arrays.copyOf(xyz.x, 10);
            this.y = Arrays.copyOf(xyz.y, 10);
            this.z = Arrays.copyOf(xyz.z, 10);
        }

        XYZ(PartialXYZT partialXYZT) {
            this();
            fromPartialXYZT(this, partialXYZT);
        }

        static XYZ fromPartialXYZT(XYZ xyz, PartialXYZT partialXYZT) {
            Field25519.mult(xyz.x, partialXYZT.xyz.x, partialXYZT.t);
            long[] jArr = xyz.y;
            XYZ xyz2 = partialXYZT.xyz;
            Field25519.mult(jArr, xyz2.y, xyz2.z);
            Field25519.mult(xyz.z, partialXYZT.xyz.z, partialXYZT.t);
            return xyz;
        }

        byte[] toBytes() {
            long[] jArr = new long[10];
            long[] jArr2 = new long[10];
            long[] jArr3 = new long[10];
            Field25519.inverse(jArr, this.z);
            Field25519.mult(jArr2, this.x, jArr);
            Field25519.mult(jArr3, this.y, jArr);
            byte[] bArrContract = Field25519.contract(jArr3);
            bArrContract[31] = (byte) ((Ed25519.getLsb(jArr2) << 7) ^ bArrContract[31]);
            return bArrContract;
        }

        boolean isOnCurve() {
            long[] jArr = new long[10];
            Field25519.square(jArr, this.x);
            long[] jArr2 = new long[10];
            Field25519.square(jArr2, this.y);
            long[] jArr3 = new long[10];
            Field25519.square(jArr3, this.z);
            long[] jArr4 = new long[10];
            Field25519.square(jArr4, jArr3);
            long[] jArr5 = new long[10];
            Field25519.sub(jArr5, jArr2, jArr);
            Field25519.mult(jArr5, jArr5, jArr3);
            long[] jArr6 = new long[10];
            Field25519.mult(jArr6, jArr, jArr2);
            Field25519.mult(jArr6, jArr6, Ed25519Constants.D);
            Field25519.sum(jArr6, jArr4);
            Field25519.reduce(jArr6, jArr6);
            return Bytes.equal(Field25519.contract(jArr5), Field25519.contract(jArr6));
        }
    }

    static class XYZT {
        final long[] t;
        final XYZ xyz;

        XYZT() {
            this(new XYZ(), new long[10]);
        }

        XYZT(XYZ xyz, long[] jArr) {
            this.xyz = xyz;
            this.t = jArr;
        }

        XYZT(PartialXYZT partialXYZT) {
            this();
            fromPartialXYZT(this, partialXYZT);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static XYZT fromPartialXYZT(XYZT xyzt, PartialXYZT partialXYZT) {
            Field25519.mult(xyzt.xyz.x, partialXYZT.xyz.x, partialXYZT.t);
            long[] jArr = xyzt.xyz.y;
            XYZ xyz = partialXYZT.xyz;
            Field25519.mult(jArr, xyz.y, xyz.z);
            Field25519.mult(xyzt.xyz.z, partialXYZT.xyz.z, partialXYZT.t);
            long[] jArr2 = xyzt.t;
            XYZ xyz2 = partialXYZT.xyz;
            Field25519.mult(jArr2, xyz2.x, xyz2.y);
            return xyzt;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static XYZT fromBytesNegateVarTime(byte[] bArr) throws GeneralSecurityException {
            long[] jArr = new long[10];
            long[] jArrExpand = Field25519.expand(bArr);
            long[] jArr2 = new long[10];
            jArr2[0] = 1;
            long[] jArr3 = new long[10];
            long[] jArr4 = new long[10];
            long[] jArr5 = new long[10];
            long[] jArr6 = new long[10];
            long[] jArr7 = new long[10];
            Field25519.square(jArr4, jArrExpand);
            Field25519.mult(jArr5, jArr4, Ed25519Constants.D);
            Field25519.sub(jArr4, jArr4, jArr2);
            Field25519.sum(jArr5, jArr5, jArr2);
            long[] jArr8 = new long[10];
            Field25519.square(jArr8, jArr5);
            Field25519.mult(jArr8, jArr8, jArr5);
            Field25519.square(jArr, jArr8);
            Field25519.mult(jArr, jArr, jArr5);
            Field25519.mult(jArr, jArr, jArr4);
            Ed25519.pow2252m3(jArr, jArr);
            Field25519.mult(jArr, jArr, jArr8);
            Field25519.mult(jArr, jArr, jArr4);
            Field25519.square(jArr6, jArr);
            Field25519.mult(jArr6, jArr6, jArr5);
            Field25519.sub(jArr7, jArr6, jArr4);
            if (Ed25519.isNonZeroVarTime(jArr7)) {
                Field25519.sum(jArr7, jArr6, jArr4);
                if (Ed25519.isNonZeroVarTime(jArr7)) {
                    throw new GeneralSecurityException("Cannot convert given bytes to extended projective coordinates. No square root exists for modulo 2^255-19");
                }
                Field25519.mult(jArr, jArr, Ed25519Constants.SQRTM1);
            }
            if (Ed25519.isNonZeroVarTime(jArr) || ((bArr[31] & 255) >> 7) == 0) {
                if (Ed25519.getLsb(jArr) == ((bArr[31] & 255) >> 7)) {
                    Ed25519.neg(jArr, jArr);
                }
                Field25519.mult(jArr3, jArr, jArrExpand);
                return new XYZT(new XYZ(jArr, jArrExpand, jArr2), jArr3);
            }
            throw new GeneralSecurityException("Cannot convert given bytes to extended projective coordinates. Computed x is zero and encoded x's least significant bit is not zero");
        }
    }

    static class PartialXYZT {
        final long[] t;
        final XYZ xyz;

        PartialXYZT() {
            this(new XYZ(), new long[10]);
        }

        PartialXYZT(XYZ xyz, long[] jArr) {
            this.xyz = xyz;
            this.t = jArr;
        }

        PartialXYZT(PartialXYZT partialXYZT) {
            this.xyz = new XYZ(partialXYZT.xyz);
            this.t = Arrays.copyOf(partialXYZT.t, 10);
        }
    }

    static class CachedXYT {
        final long[] t2d;
        final long[] yMinusX;
        final long[] yPlusX;

        CachedXYT() {
            this(new long[10], new long[10], new long[10]);
        }

        CachedXYT(long[] jArr, long[] jArr2, long[] jArr3) {
            this.yPlusX = jArr;
            this.yMinusX = jArr2;
            this.t2d = jArr3;
        }

        CachedXYT(CachedXYT cachedXYT) {
            this.yPlusX = Arrays.copyOf(cachedXYT.yPlusX, 10);
            this.yMinusX = Arrays.copyOf(cachedXYT.yMinusX, 10);
            this.t2d = Arrays.copyOf(cachedXYT.t2d, 10);
        }

        void multByZ(long[] jArr, long[] jArr2) {
            System.arraycopy(jArr2, 0, jArr, 0, 10);
        }

        void copyConditional(CachedXYT cachedXYT, int i) {
            Curve25519.copyConditional(this.yPlusX, cachedXYT.yPlusX, i);
            Curve25519.copyConditional(this.yMinusX, cachedXYT.yMinusX, i);
            Curve25519.copyConditional(this.t2d, cachedXYT.t2d, i);
        }
    }

    static class CachedXYZT extends CachedXYT {
        private final long[] z;

        CachedXYZT() {
            this(new long[10], new long[10], new long[10], new long[10]);
        }

        CachedXYZT(XYZT xyzt) {
            this();
            long[] jArr = this.yPlusX;
            XYZ xyz = xyzt.xyz;
            Field25519.sum(jArr, xyz.y, xyz.x);
            long[] jArr2 = this.yMinusX;
            XYZ xyz2 = xyzt.xyz;
            Field25519.sub(jArr2, xyz2.y, xyz2.x);
            System.arraycopy(xyzt.xyz.z, 0, this.z, 0, 10);
            Field25519.mult(this.t2d, xyzt.t, Ed25519Constants.D2);
        }

        CachedXYZT(long[] jArr, long[] jArr2, long[] jArr3, long[] jArr4) {
            super(jArr, jArr2, jArr4);
            this.z = jArr3;
        }

        @Override // com.google.crypto.tink.internal.Ed25519.CachedXYT
        public void multByZ(long[] jArr, long[] jArr2) {
            Field25519.mult(jArr, jArr2, this.z);
        }
    }

    private static void add(PartialXYZT partialXYZT, XYZT xyzt, CachedXYT cachedXYT) {
        long[] jArr = new long[10];
        long[] jArr2 = partialXYZT.xyz.x;
        XYZ xyz = xyzt.xyz;
        Field25519.sum(jArr2, xyz.y, xyz.x);
        long[] jArr3 = partialXYZT.xyz.y;
        XYZ xyz2 = xyzt.xyz;
        Field25519.sub(jArr3, xyz2.y, xyz2.x);
        long[] jArr4 = partialXYZT.xyz.y;
        Field25519.mult(jArr4, jArr4, cachedXYT.yMinusX);
        XYZ xyz3 = partialXYZT.xyz;
        Field25519.mult(xyz3.z, xyz3.x, cachedXYT.yPlusX);
        Field25519.mult(partialXYZT.t, xyzt.t, cachedXYT.t2d);
        cachedXYT.multByZ(partialXYZT.xyz.x, xyzt.xyz.z);
        long[] jArr5 = partialXYZT.xyz.x;
        Field25519.sum(jArr, jArr5, jArr5);
        XYZ xyz4 = partialXYZT.xyz;
        Field25519.sub(xyz4.x, xyz4.z, xyz4.y);
        XYZ xyz5 = partialXYZT.xyz;
        long[] jArr6 = xyz5.y;
        Field25519.sum(jArr6, xyz5.z, jArr6);
        Field25519.sum(partialXYZT.xyz.z, jArr, partialXYZT.t);
        long[] jArr7 = partialXYZT.t;
        Field25519.sub(jArr7, jArr, jArr7);
    }

    private static void sub(PartialXYZT partialXYZT, XYZT xyzt, CachedXYT cachedXYT) {
        long[] jArr = new long[10];
        long[] jArr2 = partialXYZT.xyz.x;
        XYZ xyz = xyzt.xyz;
        Field25519.sum(jArr2, xyz.y, xyz.x);
        long[] jArr3 = partialXYZT.xyz.y;
        XYZ xyz2 = xyzt.xyz;
        Field25519.sub(jArr3, xyz2.y, xyz2.x);
        long[] jArr4 = partialXYZT.xyz.y;
        Field25519.mult(jArr4, jArr4, cachedXYT.yPlusX);
        XYZ xyz3 = partialXYZT.xyz;
        Field25519.mult(xyz3.z, xyz3.x, cachedXYT.yMinusX);
        Field25519.mult(partialXYZT.t, xyzt.t, cachedXYT.t2d);
        cachedXYT.multByZ(partialXYZT.xyz.x, xyzt.xyz.z);
        long[] jArr5 = partialXYZT.xyz.x;
        Field25519.sum(jArr, jArr5, jArr5);
        XYZ xyz4 = partialXYZT.xyz;
        Field25519.sub(xyz4.x, xyz4.z, xyz4.y);
        XYZ xyz5 = partialXYZT.xyz;
        long[] jArr6 = xyz5.y;
        Field25519.sum(jArr6, xyz5.z, jArr6);
        Field25519.sub(partialXYZT.xyz.z, jArr, partialXYZT.t);
        long[] jArr7 = partialXYZT.t;
        Field25519.sum(jArr7, jArr, jArr7);
    }

    private static void doubleXYZ(PartialXYZT partialXYZT, XYZ xyz) {
        long[] jArr = new long[10];
        Field25519.square(partialXYZT.xyz.x, xyz.x);
        Field25519.square(partialXYZT.xyz.z, xyz.y);
        Field25519.square(partialXYZT.t, xyz.z);
        long[] jArr2 = partialXYZT.t;
        Field25519.sum(jArr2, jArr2, jArr2);
        Field25519.sum(partialXYZT.xyz.y, xyz.x, xyz.y);
        Field25519.square(jArr, partialXYZT.xyz.y);
        XYZ xyz2 = partialXYZT.xyz;
        Field25519.sum(xyz2.y, xyz2.z, xyz2.x);
        XYZ xyz3 = partialXYZT.xyz;
        long[] jArr3 = xyz3.z;
        Field25519.sub(jArr3, jArr3, xyz3.x);
        XYZ xyz4 = partialXYZT.xyz;
        Field25519.sub(xyz4.x, jArr, xyz4.y);
        long[] jArr4 = partialXYZT.t;
        Field25519.sub(jArr4, jArr4, partialXYZT.xyz.z);
    }

    private static void doubleXYZT(PartialXYZT partialXYZT, XYZT xyzt) {
        doubleXYZ(partialXYZT, xyzt.xyz);
    }

    private static void select(CachedXYT cachedXYT, int i, byte b) {
        int i2 = (b & 255) >> 7;
        int i3 = b - (((-i2) & b) << 1);
        CachedXYT[][] cachedXYTArr = Ed25519Constants.B_TABLE;
        cachedXYT.copyConditional(cachedXYTArr[i][0], eq(i3, 1));
        cachedXYT.copyConditional(cachedXYTArr[i][1], eq(i3, 2));
        cachedXYT.copyConditional(cachedXYTArr[i][2], eq(i3, 3));
        cachedXYT.copyConditional(cachedXYTArr[i][3], eq(i3, 4));
        cachedXYT.copyConditional(cachedXYTArr[i][4], eq(i3, 5));
        cachedXYT.copyConditional(cachedXYTArr[i][5], eq(i3, 6));
        cachedXYT.copyConditional(cachedXYTArr[i][6], eq(i3, 7));
        cachedXYT.copyConditional(cachedXYTArr[i][7], eq(i3, 8));
        long[] jArrCopyOf = Arrays.copyOf(cachedXYT.yMinusX, 10);
        long[] jArrCopyOf2 = Arrays.copyOf(cachedXYT.yPlusX, 10);
        long[] jArrCopyOf3 = Arrays.copyOf(cachedXYT.t2d, 10);
        neg(jArrCopyOf3, jArrCopyOf3);
        cachedXYT.copyConditional(new CachedXYT(jArrCopyOf, jArrCopyOf2, jArrCopyOf3), i2);
    }

    private static XYZ scalarMultWithBase(byte[] bArr) {
        int i;
        byte[] bArr2 = new byte[64];
        int i2 = 0;
        while (true) {
            if (i2 >= 32) {
                break;
            }
            int i3 = i2 * 2;
            bArr2[i3] = (byte) (bArr[i2] & Ascii.SI);
            bArr2[i3 + 1] = (byte) (((bArr[i2] & 255) >> 4) & 15);
            i2++;
        }
        int i4 = 0;
        int i5 = 0;
        while (i4 < 63) {
            byte b = (byte) (bArr2[i4] + i5);
            bArr2[i4] = b;
            int i6 = (b + 8) >> 4;
            bArr2[i4] = (byte) (b - (i6 << 4));
            i4++;
            i5 = i6;
        }
        bArr2[63] = (byte) (bArr2[63] + i5);
        PartialXYZT partialXYZT = new PartialXYZT(NEUTRAL);
        XYZT xyzt = new XYZT();
        for (i = 1; i < 64; i += 2) {
            CachedXYT cachedXYT = new CachedXYT(CACHED_NEUTRAL);
            select(cachedXYT, i / 2, bArr2[i]);
            add(partialXYZT, XYZT.fromPartialXYZT(xyzt, partialXYZT), cachedXYT);
        }
        XYZ xyz = new XYZ();
        doubleXYZ(partialXYZT, XYZ.fromPartialXYZT(xyz, partialXYZT));
        doubleXYZ(partialXYZT, XYZ.fromPartialXYZT(xyz, partialXYZT));
        doubleXYZ(partialXYZT, XYZ.fromPartialXYZT(xyz, partialXYZT));
        doubleXYZ(partialXYZT, XYZ.fromPartialXYZT(xyz, partialXYZT));
        for (int i7 = 0; i7 < 64; i7 += 2) {
            CachedXYT cachedXYT2 = new CachedXYT(CACHED_NEUTRAL);
            select(cachedXYT2, i7 / 2, bArr2[i7]);
            add(partialXYZT, XYZT.fromPartialXYZT(xyzt, partialXYZT), cachedXYT2);
        }
        XYZ xyz2 = new XYZ(partialXYZT);
        if (xyz2.isOnCurve()) {
            return xyz2;
        }
        throw new IllegalStateException("arithmetic error in scalar multiplication");
    }

    public static byte[] scalarMultWithBaseToBytes(byte[] bArr) {
        return scalarMultWithBase(bArr).toBytes();
    }

    private static byte[] slide(byte[] bArr) {
        int i;
        byte[] bArr2 = new byte[256];
        for (int i2 = 0; i2 < 256; i2++) {
            bArr2[i2] = (byte) (1 & ((bArr[i2 >> 3] & 255) >> (i2 & 7)));
        }
        for (int i3 = 0; i3 < 256; i3++) {
            if (bArr2[i3] != 0) {
                for (int i4 = 1; i4 <= 6 && (i = i3 + i4) < 256; i4++) {
                    byte b = bArr2[i];
                    if (b != 0) {
                        byte b2 = bArr2[i3];
                        int i5 = b << i4;
                        int i6 = i5 + b2;
                        if (i6 <= 15) {
                            bArr2[i3] = (byte) i6;
                            bArr2[i] = 0;
                        } else {
                            int i7 = b2 - i5;
                            if (i7 < -15) {
                                break;
                            }
                            bArr2[i3] = (byte) i7;
                            while (i < 256) {
                                if (bArr2[i] == 0) {
                                    bArr2[i] = 1;
                                    break;
                                }
                                bArr2[i] = 0;
                                i++;
                            }
                        }
                    }
                }
            }
        }
        return bArr2;
    }

    private static XYZ doubleScalarMultVarTime(byte[] bArr, XYZT xyzt, byte[] bArr2) {
        CachedXYZT[] cachedXYZTArr = new CachedXYZT[8];
        cachedXYZTArr[0] = new CachedXYZT(xyzt);
        PartialXYZT partialXYZT = new PartialXYZT();
        doubleXYZT(partialXYZT, xyzt);
        XYZT xyzt2 = new XYZT(partialXYZT);
        for (int i = 1; i < 8; i++) {
            add(partialXYZT, xyzt2, cachedXYZTArr[i - 1]);
            cachedXYZTArr[i] = new CachedXYZT(new XYZT(partialXYZT));
        }
        byte[] bArrSlide = slide(bArr);
        byte[] bArrSlide2 = slide(bArr2);
        PartialXYZT partialXYZT2 = new PartialXYZT(NEUTRAL);
        XYZT xyzt3 = new XYZT();
        int i2 = 255;
        while (i2 >= 0 && bArrSlide[i2] == 0 && bArrSlide2[i2] == 0) {
            i2--;
        }
        while (i2 >= 0) {
            doubleXYZ(partialXYZT2, new XYZ(partialXYZT2));
            byte b = bArrSlide[i2];
            if (b > 0) {
                add(partialXYZT2, XYZT.fromPartialXYZT(xyzt3, partialXYZT2), cachedXYZTArr[bArrSlide[i2] / 2]);
            } else if (b < 0) {
                sub(partialXYZT2, XYZT.fromPartialXYZT(xyzt3, partialXYZT2), cachedXYZTArr[(-bArrSlide[i2]) / 2]);
            }
            byte b2 = bArrSlide2[i2];
            if (b2 > 0) {
                add(partialXYZT2, XYZT.fromPartialXYZT(xyzt3, partialXYZT2), Ed25519Constants.B2[bArrSlide2[i2] / 2]);
            } else if (b2 < 0) {
                sub(partialXYZT2, XYZT.fromPartialXYZT(xyzt3, partialXYZT2), Ed25519Constants.B2[(-bArrSlide2[i2]) / 2]);
            }
            i2--;
        }
        return new XYZ(partialXYZT2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isNonZeroVarTime(long[] jArr) {
        long[] jArr2 = new long[jArr.length + 1];
        System.arraycopy(jArr, 0, jArr2, 0, jArr.length);
        Field25519.reduceCoefficients(jArr2);
        for (byte b : Field25519.contract(jArr2)) {
            if (b != 0) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getLsb(long[] jArr) {
        return Field25519.contract(jArr)[0] & 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void neg(long[] jArr, long[] jArr2) {
        for (int i = 0; i < jArr2.length; i++) {
            jArr[i] = -jArr2[i];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void pow2252m3(long[] jArr, long[] jArr2) {
        long[] jArr3 = new long[10];
        long[] jArr4 = new long[10];
        long[] jArr5 = new long[10];
        Field25519.square(jArr3, jArr2);
        Field25519.square(jArr4, jArr3);
        Field25519.square(jArr4, jArr4);
        Field25519.mult(jArr4, jArr2, jArr4);
        Field25519.mult(jArr3, jArr3, jArr4);
        Field25519.square(jArr3, jArr3);
        Field25519.mult(jArr3, jArr4, jArr3);
        Field25519.square(jArr4, jArr3);
        for (int i = 1; i < 5; i++) {
            Field25519.square(jArr4, jArr4);
        }
        Field25519.mult(jArr3, jArr4, jArr3);
        Field25519.square(jArr4, jArr3);
        for (int i2 = 1; i2 < 10; i2++) {
            Field25519.square(jArr4, jArr4);
        }
        Field25519.mult(jArr4, jArr4, jArr3);
        Field25519.square(jArr5, jArr4);
        for (int i3 = 1; i3 < 20; i3++) {
            Field25519.square(jArr5, jArr5);
        }
        Field25519.mult(jArr4, jArr5, jArr4);
        Field25519.square(jArr4, jArr4);
        for (int i4 = 1; i4 < 10; i4++) {
            Field25519.square(jArr4, jArr4);
        }
        Field25519.mult(jArr3, jArr4, jArr3);
        Field25519.square(jArr4, jArr3);
        for (int i5 = 1; i5 < 50; i5++) {
            Field25519.square(jArr4, jArr4);
        }
        Field25519.mult(jArr4, jArr4, jArr3);
        Field25519.square(jArr5, jArr4);
        for (int i6 = 1; i6 < 100; i6++) {
            Field25519.square(jArr5, jArr5);
        }
        Field25519.mult(jArr4, jArr5, jArr4);
        Field25519.square(jArr4, jArr4);
        for (int i7 = 1; i7 < 50; i7++) {
            Field25519.square(jArr4, jArr4);
        }
        Field25519.mult(jArr3, jArr4, jArr3);
        Field25519.square(jArr3, jArr3);
        Field25519.square(jArr3, jArr3);
        Field25519.mult(jArr, jArr3, jArr2);
    }

    private static long load3(byte[] bArr, int i) {
        return (((long) (bArr[i + 2] & 255)) << 16) | (((long) bArr[i]) & 255) | (((long) (bArr[i + 1] & 255)) << 8);
    }

    private static long load4(byte[] bArr, int i) {
        return (((long) (bArr[i + 3] & 255)) << 24) | load3(bArr, i);
    }

    private static void reduce(byte[] bArr) {
        long jLoad3 = load3(bArr, 0);
        long jLoad4 = load4(bArr, 2);
        long jLoad5 = load3(bArr, 5);
        long jLoad6 = load4(bArr, 7);
        long jLoad7 = load4(bArr, 10);
        long jLoad8 = load3(bArr, 13);
        long jLoad9 = load4(bArr, 15);
        long jLoad10 = load3(bArr, 18);
        long jLoad11 = load3(bArr, 21);
        long jLoad12 = load4(bArr, 23);
        long jLoad13 = load3(bArr, 26);
        long jLoad14 = load4(bArr, 28);
        long jLoad15 = load4(bArr, 31);
        long jLoad16 = load3(bArr, 34);
        long jLoad17 = load4(bArr, 36);
        long jLoad18 = load3(bArr, 39);
        long jLoad19 = load3(bArr, 42);
        long jLoad20 = load4(bArr, 44);
        long jLoad21 = (load3(bArr, 47) >> 2) & 2097151;
        long jLoad22 = (load4(bArr, 49) >> 7) & 2097151;
        long jLoad23 = (load4(bArr, 52) >> 4) & 2097151;
        long jLoad24 = (load3(bArr, 55) >> 1) & 2097151;
        long jLoad25 = (load4(bArr, 57) >> 6) & 2097151;
        long jLoad26 = load4(bArr, 60) >> 3;
        long j = (jLoad19 & 2097151) - (jLoad26 * 683901);
        long j2 = ((((jLoad17 >> 6) & 2097151) - (jLoad26 * 997805)) + (jLoad25 * 136657)) - (jLoad24 * 683901);
        long j3 = ((((((jLoad15 >> 4) & 2097151) + (jLoad26 * 470296)) + (jLoad25 * 654183)) - (jLoad24 * 997805)) + (jLoad23 * 136657)) - (jLoad22 * 683901);
        long j4 = ((jLoad9 >> 6) & 2097151) + (jLoad21 * 666643);
        long j5 = (jLoad11 & 2097151) + (jLoad23 * 666643) + (jLoad22 * 470296) + (jLoad21 * 654183);
        long j6 = ((((((jLoad13 >> 2) & 2097151) + (jLoad25 * 666643)) + (jLoad24 * 470296)) + (jLoad23 * 654183)) - (jLoad22 * 997805)) + (jLoad21 * 136657);
        long j7 = (j4 + 1048576) >> 21;
        long j8 = ((jLoad10 >> 3) & 2097151) + (jLoad22 * 666643) + (jLoad21 * 470296) + j7;
        long j9 = (j5 + 1048576) >> 21;
        long j10 = ((((((jLoad12 >> 5) & 2097151) + (jLoad24 * 666643)) + (jLoad23 * 470296)) + (jLoad22 * 654183)) - (jLoad21 * 997805)) + j9;
        long j11 = (j6 + 1048576) >> 21;
        long j12 = ((((((((jLoad14 >> 7) & 2097151) + (jLoad26 * 666643)) + (jLoad25 * 470296)) + (jLoad24 * 654183)) - (jLoad23 * 997805)) + (jLoad22 * 136657)) - (jLoad21 * 683901)) + j11;
        long j13 = (j3 + 1048576) >> 21;
        long j14 = ((((((jLoad16 >> 1) & 2097151) + (jLoad26 * 654183)) - (jLoad25 * 997805)) + (jLoad24 * 136657)) - (jLoad23 * 683901)) + j13;
        long j15 = (j2 + 1048576) >> 21;
        long j16 = ((((jLoad18 >> 3) & 2097151) + (jLoad26 * 136657)) - (jLoad25 * 683901)) + j15;
        long j17 = (j + 1048576) >> 21;
        long j18 = ((jLoad20 >> 5) & 2097151) + j17;
        long j19 = (j8 + 1048576) >> 21;
        long j20 = (j10 + 1048576) >> 21;
        long j21 = (j12 + 1048576) >> 21;
        long j22 = (j3 - (j13 << 21)) + j21;
        long j23 = (j14 + 1048576) >> 21;
        long j24 = (j2 - (j15 << 21)) + j23;
        long j25 = j14 - (j23 << 21);
        long j26 = (j16 + 1048576) >> 21;
        long j27 = (j - (j17 << 21)) + j26;
        long j28 = j16 - (j26 << 21);
        long j29 = ((j6 - (j11 << 21)) + j20) - (j18 * 683901);
        long j30 = ((((j5 - (j9 << 21)) + j19) - (j18 * 997805)) + (j27 * 136657)) - (j28 * 683901);
        long j31 = (((((j4 - (j7 << 21)) + (j18 * 470296)) + (j27 * 654183)) - (j28 * 997805)) + (j24 * 136657)) - (j25 * 683901);
        long j32 = (jLoad3 & 2097151) + (j22 * 666643);
        long j33 = ((jLoad5 >> 2) & 2097151) + (j24 * 666643) + (j25 * 470296) + (j22 * 654183);
        long j34 = ((((((jLoad7 >> 4) & 2097151) + (j27 * 666643)) + (j28 * 470296)) + (j24 * 654183)) - (j25 * 997805)) + (j22 * 136657);
        long j35 = (j32 + 1048576) >> 21;
        long j36 = ((jLoad4 >> 5) & 2097151) + (j25 * 666643) + (j22 * 470296) + j35;
        long j37 = (j33 + 1048576) >> 21;
        long j38 = ((((((jLoad6 >> 7) & 2097151) + (j28 * 666643)) + (j24 * 470296)) + (j25 * 654183)) - (j22 * 997805)) + j37;
        long j39 = (j34 + 1048576) >> 21;
        long j40 = ((((((((jLoad8 >> 1) & 2097151) + (j18 * 666643)) + (j27 * 470296)) + (j28 * 654183)) - (j24 * 997805)) + (j25 * 136657)) - (j22 * 683901)) + j39;
        long j41 = (j31 + 1048576) >> 21;
        long j42 = (((((j8 - (j19 << 21)) + (j18 * 654183)) - (j27 * 997805)) + (j28 * 136657)) - (j24 * 683901)) + j41;
        long j43 = (j30 + 1048576) >> 21;
        long j44 = (((j10 - (j20 << 21)) + (j18 * 136657)) - (j27 * 683901)) + j43;
        long j45 = (j29 + 1048576) >> 21;
        long j46 = (j12 - (j21 << 21)) + j45;
        long j47 = (j36 + 1048576) >> 21;
        long j48 = (j38 + 1048576) >> 21;
        long j49 = (j40 + 1048576) >> 21;
        long j50 = (j42 + 1048576) >> 21;
        long j51 = (j44 + 1048576) >> 21;
        long j52 = (j46 + 1048576) >> 21;
        long j53 = (j32 - (j35 << 21)) + (j52 * 666643);
        long j54 = j53 >> 21;
        long j55 = (j36 - (j47 << 21)) + (j52 * 470296) + j54;
        long j56 = j55 >> 21;
        long j57 = (j33 - (j37 << 21)) + j47 + (j52 * 654183) + j56;
        long j58 = j57 >> 21;
        long j59 = ((j38 - (j48 << 21)) - (j52 * 997805)) + j58;
        long j60 = j59 >> 21;
        long j61 = (j34 - (j39 << 21)) + j48 + (j52 * 136657) + j60;
        long j62 = j61 >> 21;
        long j63 = ((j40 - (j49 << 21)) - (j52 * 683901)) + j62;
        long j64 = j63 >> 21;
        long j65 = (j31 - (j41 << 21)) + j49 + j64;
        long j66 = j65 >> 21;
        long j67 = (j42 - (j50 << 21)) + j66;
        long j68 = j67 >> 21;
        long j69 = (j30 - (j43 << 21)) + j50 + j68;
        long j70 = j69 >> 21;
        long j71 = (j44 - (j51 << 21)) + j70;
        long j72 = j71 >> 21;
        long j73 = (j29 - (j45 << 21)) + j51 + j72;
        long j74 = j73 >> 21;
        long j75 = (j46 - (j52 << 21)) + j74;
        long j76 = j75 >> 21;
        long j77 = (j53 - (j54 << 21)) + (666643 * j76);
        long j78 = j77 >> 21;
        long j79 = (j55 - (j56 << 21)) + (470296 * j76) + j78;
        long j80 = j77 - (j78 << 21);
        long j81 = j79 >> 21;
        long j82 = (j57 - (j58 << 21)) + (654183 * j76) + j81;
        long j83 = j79 - (j81 << 21);
        long j84 = j82 >> 21;
        long j85 = ((j59 - (j60 << 21)) - (997805 * j76)) + j84;
        long j86 = j82 - (j84 << 21);
        long j87 = j85 >> 21;
        long j88 = (j61 - (j62 << 21)) + (136657 * j76) + j87;
        long j89 = j85 - (j87 << 21);
        long j90 = j88 >> 21;
        long j91 = ((j63 - (j64 << 21)) - (683901 * j76)) + j90;
        long j92 = j88 - (j90 << 21);
        long j93 = j91 >> 21;
        long j94 = (j65 - (j66 << 21)) + j93;
        long j95 = j91 - (j93 << 21);
        long j96 = j94 >> 21;
        long j97 = (j67 - (j68 << 21)) + j96;
        long j98 = j94 - (j96 << 21);
        long j99 = j97 >> 21;
        long j100 = (j69 - (j70 << 21)) + j99;
        long j101 = j97 - (j99 << 21);
        long j102 = j100 >> 21;
        long j103 = (j71 - (j72 << 21)) + j102;
        long j104 = j100 - (j102 << 21);
        long j105 = j103 >> 21;
        long j106 = (j73 - (j74 << 21)) + j105;
        long j107 = j103 - (j105 << 21);
        long j108 = j106 >> 21;
        long j109 = (j75 - (j76 << 21)) + j108;
        long j110 = j106 - (j108 << 21);
        bArr[0] = (byte) j80;
        bArr[1] = (byte) (j80 >> 8);
        bArr[2] = (byte) ((j80 >> 16) | (j83 << 5));
        bArr[3] = (byte) (j83 >> 3);
        bArr[4] = (byte) (j83 >> 11);
        bArr[5] = (byte) ((j83 >> 19) | (j86 << 2));
        bArr[6] = (byte) (j86 >> 6);
        bArr[7] = (byte) ((j86 >> 14) | (j89 << 7));
        bArr[8] = (byte) (j89 >> 1);
        bArr[9] = (byte) (j89 >> 9);
        bArr[10] = (byte) ((j89 >> 17) | (j92 << 4));
        bArr[11] = (byte) (j92 >> 4);
        bArr[12] = (byte) (j92 >> 12);
        bArr[13] = (byte) ((j92 >> 20) | (j95 << 1));
        bArr[14] = (byte) (j95 >> 7);
        bArr[15] = (byte) ((j95 >> 15) | (j98 << 6));
        bArr[16] = (byte) (j98 >> 2);
        bArr[17] = (byte) (j98 >> 10);
        bArr[18] = (byte) ((j98 >> 18) | (j101 << 3));
        bArr[19] = (byte) (j101 >> 5);
        bArr[20] = (byte) (j101 >> 13);
        bArr[21] = (byte) j104;
        bArr[22] = (byte) (j104 >> 8);
        bArr[23] = (byte) ((j104 >> 16) | (j107 << 5));
        bArr[24] = (byte) (j107 >> 3);
        bArr[25] = (byte) (j107 >> 11);
        bArr[26] = (byte) ((j107 >> 19) | (j110 << 2));
        bArr[27] = (byte) (j110 >> 6);
        bArr[28] = (byte) ((j110 >> 14) | (j109 << 7));
        bArr[29] = (byte) (j109 >> 1);
        bArr[30] = (byte) (j109 >> 9);
        bArr[31] = (byte) (j109 >> 17);
    }

    private static void mulAdd(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        long jLoad3 = load3(bArr2, 0) & 2097151;
        long jLoad4 = (load4(bArr2, 2) >> 5) & 2097151;
        long jLoad5 = (load3(bArr2, 5) >> 2) & 2097151;
        long jLoad6 = (load4(bArr2, 7) >> 7) & 2097151;
        long jLoad7 = (load4(bArr2, 10) >> 4) & 2097151;
        long jLoad8 = (load3(bArr2, 13) >> 1) & 2097151;
        long jLoad9 = (load4(bArr2, 15) >> 6) & 2097151;
        long jLoad10 = (load3(bArr2, 18) >> 3) & 2097151;
        long jLoad11 = load3(bArr2, 21) & 2097151;
        long jLoad12 = (load4(bArr2, 23) >> 5) & 2097151;
        long jLoad13 = (load3(bArr2, 26) >> 2) & 2097151;
        long jLoad14 = load4(bArr2, 28) >> 7;
        long jLoad15 = load3(bArr3, 0) & 2097151;
        long jLoad16 = (load4(bArr3, 2) >> 5) & 2097151;
        long jLoad17 = (load3(bArr3, 5) >> 2) & 2097151;
        long jLoad18 = (load4(bArr3, 7) >> 7) & 2097151;
        long jLoad19 = (load4(bArr3, 10) >> 4) & 2097151;
        long jLoad20 = (load3(bArr3, 13) >> 1) & 2097151;
        long jLoad21 = (load4(bArr3, 15) >> 6) & 2097151;
        long jLoad22 = (load3(bArr3, 18) >> 3) & 2097151;
        long jLoad23 = load3(bArr3, 21) & 2097151;
        long jLoad24 = (load4(bArr3, 23) >> 5) & 2097151;
        long jLoad25 = (load3(bArr3, 26) >> 2) & 2097151;
        long jLoad26 = load4(bArr3, 28) >> 7;
        long jLoad27 = load3(bArr4, 0);
        long jLoad28 = load4(bArr4, 2);
        long jLoad29 = load3(bArr4, 5);
        long jLoad30 = load4(bArr4, 7);
        long jLoad31 = load4(bArr4, 10);
        long jLoad32 = load3(bArr4, 13);
        long jLoad33 = load4(bArr4, 15);
        long jLoad34 = load3(bArr4, 18);
        long jLoad35 = load3(bArr4, 21);
        long jLoad36 = load4(bArr4, 23);
        long j = (jLoad27 & 2097151) + (jLoad3 * jLoad15);
        long j2 = ((jLoad29 >> 2) & 2097151) + (jLoad3 * jLoad17) + (jLoad4 * jLoad16) + (jLoad5 * jLoad15);
        long j3 = ((jLoad31 >> 4) & 2097151) + (jLoad3 * jLoad19) + (jLoad4 * jLoad18) + (jLoad5 * jLoad17) + (jLoad6 * jLoad16) + (jLoad7 * jLoad15);
        long j4 = ((jLoad33 >> 6) & 2097151) + (jLoad3 * jLoad21) + (jLoad4 * jLoad20) + (jLoad5 * jLoad19) + (jLoad6 * jLoad18) + (jLoad7 * jLoad17) + (jLoad8 * jLoad16) + (jLoad9 * jLoad15);
        long j5 = (jLoad35 & 2097151) + (jLoad3 * jLoad23) + (jLoad4 * jLoad22) + (jLoad5 * jLoad21) + (jLoad6 * jLoad20) + (jLoad7 * jLoad19) + (jLoad8 * jLoad18) + (jLoad9 * jLoad17) + (jLoad10 * jLoad16) + (jLoad11 * jLoad15);
        long jLoad37 = ((load3(bArr4, 26) >> 2) & 2097151) + (jLoad3 * jLoad25) + (jLoad4 * jLoad24) + (jLoad5 * jLoad23) + (jLoad6 * jLoad22) + (jLoad7 * jLoad21) + (jLoad8 * jLoad20) + (jLoad9 * jLoad19) + (jLoad10 * jLoad18) + (jLoad11 * jLoad17) + (jLoad12 * jLoad16) + (jLoad13 * jLoad15);
        long j6 = (jLoad4 * jLoad26) + (jLoad5 * jLoad25) + (jLoad6 * jLoad24) + (jLoad7 * jLoad23) + (jLoad8 * jLoad22) + (jLoad9 * jLoad21) + (jLoad10 * jLoad20) + (jLoad11 * jLoad19) + (jLoad12 * jLoad18) + (jLoad13 * jLoad17) + (jLoad16 * jLoad14);
        long j7 = (jLoad6 * jLoad26) + (jLoad7 * jLoad25) + (jLoad8 * jLoad24) + (jLoad9 * jLoad23) + (jLoad10 * jLoad22) + (jLoad11 * jLoad21) + (jLoad12 * jLoad20) + (jLoad13 * jLoad19) + (jLoad18 * jLoad14);
        long j8 = (jLoad8 * jLoad26) + (jLoad9 * jLoad25) + (jLoad10 * jLoad24) + (jLoad11 * jLoad23) + (jLoad12 * jLoad22) + (jLoad13 * jLoad21) + (jLoad20 * jLoad14);
        long j9 = (jLoad10 * jLoad26) + (jLoad11 * jLoad25) + (jLoad12 * jLoad24) + (jLoad13 * jLoad23) + (jLoad22 * jLoad14);
        long j10 = (jLoad12 * jLoad26) + (jLoad13 * jLoad25) + (jLoad24 * jLoad14);
        long j11 = jLoad14 * jLoad26;
        long j12 = (j + 1048576) >> 21;
        long j13 = ((jLoad28 >> 5) & 2097151) + (jLoad3 * jLoad16) + (jLoad4 * jLoad15) + j12;
        long j14 = (j2 + 1048576) >> 21;
        long j15 = ((jLoad30 >> 7) & 2097151) + (jLoad3 * jLoad18) + (jLoad4 * jLoad17) + (jLoad5 * jLoad16) + (jLoad6 * jLoad15) + j14;
        long j16 = (j3 + 1048576) >> 21;
        long j17 = ((jLoad32 >> 1) & 2097151) + (jLoad3 * jLoad20) + (jLoad4 * jLoad19) + (jLoad5 * jLoad18) + (jLoad6 * jLoad17) + (jLoad7 * jLoad16) + (jLoad8 * jLoad15) + j16;
        long j18 = (j4 + 1048576) >> 21;
        long j19 = ((jLoad34 >> 3) & 2097151) + (jLoad3 * jLoad22) + (jLoad4 * jLoad21) + (jLoad5 * jLoad20) + (jLoad6 * jLoad19) + (jLoad7 * jLoad18) + (jLoad8 * jLoad17) + (jLoad9 * jLoad16) + (jLoad10 * jLoad15) + j18;
        long j20 = (j5 + 1048576) >> 21;
        long j21 = ((jLoad36 >> 5) & 2097151) + (jLoad3 * jLoad24) + (jLoad4 * jLoad23) + (jLoad5 * jLoad22) + (jLoad6 * jLoad21) + (jLoad7 * jLoad20) + (jLoad8 * jLoad19) + (jLoad9 * jLoad18) + (jLoad10 * jLoad17) + (jLoad11 * jLoad16) + (jLoad12 * jLoad15) + j20;
        long j22 = (jLoad37 + 1048576) >> 21;
        long jLoad38 = (load4(bArr4, 28) >> 7) + (jLoad3 * jLoad26) + (jLoad4 * jLoad25) + (jLoad5 * jLoad24) + (jLoad6 * jLoad23) + (jLoad7 * jLoad22) + (jLoad8 * jLoad21) + (jLoad9 * jLoad20) + (jLoad10 * jLoad19) + (jLoad11 * jLoad18) + (jLoad12 * jLoad17) + (jLoad16 * jLoad13) + (jLoad15 * jLoad14) + j22;
        long j23 = (j6 + 1048576) >> 21;
        long j24 = (jLoad5 * jLoad26) + (jLoad6 * jLoad25) + (jLoad7 * jLoad24) + (jLoad8 * jLoad23) + (jLoad9 * jLoad22) + (jLoad10 * jLoad21) + (jLoad11 * jLoad20) + (jLoad12 * jLoad19) + (jLoad18 * jLoad13) + (jLoad17 * jLoad14) + j23;
        long j25 = (j7 + 1048576) >> 21;
        long j26 = (jLoad7 * jLoad26) + (jLoad8 * jLoad25) + (jLoad9 * jLoad24) + (jLoad10 * jLoad23) + (jLoad11 * jLoad22) + (jLoad12 * jLoad21) + (jLoad20 * jLoad13) + (jLoad19 * jLoad14) + j25;
        long j27 = (j8 + 1048576) >> 21;
        long j28 = (jLoad9 * jLoad26) + (jLoad10 * jLoad25) + (jLoad11 * jLoad24) + (jLoad12 * jLoad23) + (jLoad22 * jLoad13) + (jLoad21 * jLoad14) + j27;
        long j29 = (j9 + 1048576) >> 21;
        long j30 = (jLoad11 * jLoad26) + (jLoad12 * jLoad25) + (jLoad24 * jLoad13) + (jLoad23 * jLoad14) + j29;
        long j31 = (j10 + 1048576) >> 21;
        long j32 = (jLoad13 * jLoad26) + (jLoad25 * jLoad14) + j31;
        long j33 = (j11 + 1048576) >> 21;
        long j34 = (j13 + 1048576) >> 21;
        long j35 = (j15 + 1048576) >> 21;
        long j36 = (j17 + 1048576) >> 21;
        long j37 = (j19 + 1048576) >> 21;
        long j38 = (j21 + 1048576) >> 21;
        long j39 = (jLoad38 + 1048576) >> 21;
        long j40 = (j24 + 1048576) >> 21;
        long j41 = (j26 + 1048576) >> 21;
        long j42 = (j28 + 1048576) >> 21;
        long j43 = (j9 - (j29 << 21)) + j42;
        long j44 = (j30 + 1048576) >> 21;
        long j45 = (j10 - (j31 << 21)) + j44;
        long j46 = j30 - (j44 << 21);
        long j47 = (j32 + 1048576) >> 21;
        long j48 = (j11 - (j33 << 21)) + j47;
        long j49 = j32 - (j47 << 21);
        long j50 = ((j8 - (j27 << 21)) + j41) - (j33 * 683901);
        long j51 = ((((j7 - (j25 << 21)) + j40) - (j33 * 997805)) + (j48 * 136657)) - (j49 * 683901);
        long j52 = ((((((j6 - (j23 << 21)) + j39) + (j33 * 470296)) + (j48 * 654183)) - (j49 * 997805)) + (j45 * 136657)) - (j46 * 683901);
        long j53 = (j4 - (j18 << 21)) + j36 + (j43 * 666643);
        long j54 = (j5 - (j20 << 21)) + j37 + (j45 * 666643) + (j46 * 470296) + (j43 * 654183);
        long j55 = ((((((jLoad37 - (j22 << 21)) + j38) + (j48 * 666643)) + (j49 * 470296)) + (j45 * 654183)) - (j46 * 997805)) + (j43 * 136657);
        long j56 = (j53 + 1048576) >> 21;
        long j57 = (j19 - (j37 << 21)) + (j46 * 666643) + (j43 * 470296) + j56;
        long j58 = (j54 + 1048576) >> 21;
        long j59 = (((((j21 - (j38 << 21)) + (j49 * 666643)) + (j45 * 470296)) + (j46 * 654183)) - (j43 * 997805)) + j58;
        long j60 = (j55 + 1048576) >> 21;
        long j61 = (((((((jLoad38 - (j39 << 21)) + (j33 * 666643)) + (j48 * 470296)) + (j49 * 654183)) - (j45 * 997805)) + (j46 * 136657)) - (j43 * 683901)) + j60;
        long j62 = (j52 + 1048576) >> 21;
        long j63 = (((((j24 - (j40 << 21)) + (j33 * 654183)) - (j48 * 997805)) + (j49 * 136657)) - (j45 * 683901)) + j62;
        long j64 = (j51 + 1048576) >> 21;
        long j65 = (((j26 - (j41 << 21)) + (j33 * 136657)) - (j48 * 683901)) + j64;
        long j66 = (j50 + 1048576) >> 21;
        long j67 = (j28 - (j42 << 21)) + j66;
        long j68 = (j57 + 1048576) >> 21;
        long j69 = (j59 + 1048576) >> 21;
        long j70 = (j61 + 1048576) >> 21;
        long j71 = (j52 - (j62 << 21)) + j70;
        long j72 = (j63 + 1048576) >> 21;
        long j73 = (j51 - (j64 << 21)) + j72;
        long j74 = j63 - (j72 << 21);
        long j75 = (j65 + 1048576) >> 21;
        long j76 = (j50 - (j66 << 21)) + j75;
        long j77 = j65 - (j75 << 21);
        long j78 = ((j55 - (j60 << 21)) + j69) - (j67 * 683901);
        long j79 = ((((j54 - (j58 << 21)) + j68) - (j67 * 997805)) + (j76 * 136657)) - (j77 * 683901);
        long j80 = (((((j53 - (j56 << 21)) + (j67 * 470296)) + (j76 * 654183)) - (j77 * 997805)) + (j73 * 136657)) - (j74 * 683901);
        long j81 = (j - (j12 << 21)) + (j71 * 666643);
        long j82 = (j2 - (j14 << 21)) + j34 + (j73 * 666643) + (j74 * 470296) + (j71 * 654183);
        long j83 = ((((((j3 - (j16 << 21)) + j35) + (j76 * 666643)) + (j77 * 470296)) + (j73 * 654183)) - (j74 * 997805)) + (j71 * 136657);
        long j84 = (j81 + 1048576) >> 21;
        long j85 = (j13 - (j34 << 21)) + (j74 * 666643) + (j71 * 470296) + j84;
        long j86 = (j82 + 1048576) >> 21;
        long j87 = (((((j15 - (j35 << 21)) + (j77 * 666643)) + (j73 * 470296)) + (j74 * 654183)) - (j71 * 997805)) + j86;
        long j88 = (j83 + 1048576) >> 21;
        long j89 = (((((((j17 - (j36 << 21)) + (j67 * 666643)) + (j76 * 470296)) + (j77 * 654183)) - (j73 * 997805)) + (j74 * 136657)) - (j71 * 683901)) + j88;
        long j90 = (j80 + 1048576) >> 21;
        long j91 = (((((j57 - (j68 << 21)) + (j67 * 654183)) - (j76 * 997805)) + (j77 * 136657)) - (j73 * 683901)) + j90;
        long j92 = (j79 + 1048576) >> 21;
        long j93 = (((j59 - (j69 << 21)) + (j67 * 136657)) - (j76 * 683901)) + j92;
        long j94 = (j78 + 1048576) >> 21;
        long j95 = (j61 - (j70 << 21)) + j94;
        long j96 = (j85 + 1048576) >> 21;
        long j97 = (j87 + 1048576) >> 21;
        long j98 = (j89 + 1048576) >> 21;
        long j99 = (j91 + 1048576) >> 21;
        long j100 = (j93 + 1048576) >> 21;
        long j101 = (j95 + 1048576) >> 21;
        long j102 = (j81 - (j84 << 21)) + (j101 * 666643);
        long j103 = j102 >> 21;
        long j104 = (j85 - (j96 << 21)) + (j101 * 470296) + j103;
        long j105 = j104 >> 21;
        long j106 = (j82 - (j86 << 21)) + j96 + (j101 * 654183) + j105;
        long j107 = j106 >> 21;
        long j108 = ((j87 - (j97 << 21)) - (j101 * 997805)) + j107;
        long j109 = j108 >> 21;
        long j110 = (j83 - (j88 << 21)) + j97 + (j101 * 136657) + j109;
        long j111 = j110 >> 21;
        long j112 = ((j89 - (j98 << 21)) - (j101 * 683901)) + j111;
        long j113 = j112 >> 21;
        long j114 = (j80 - (j90 << 21)) + j98 + j113;
        long j115 = j114 >> 21;
        long j116 = (j91 - (j99 << 21)) + j115;
        long j117 = j116 >> 21;
        long j118 = (j79 - (j92 << 21)) + j99 + j117;
        long j119 = j118 >> 21;
        long j120 = (j93 - (j100 << 21)) + j119;
        long j121 = j120 >> 21;
        long j122 = (j78 - (j94 << 21)) + j100 + j121;
        long j123 = j122 >> 21;
        long j124 = (j95 - (j101 << 21)) + j123;
        long j125 = j124 >> 21;
        long j126 = (j102 - (j103 << 21)) + (666643 * j125);
        long j127 = j126 >> 21;
        long j128 = (j104 - (j105 << 21)) + (470296 * j125) + j127;
        long j129 = j126 - (j127 << 21);
        long j130 = j128 >> 21;
        long j131 = (j106 - (j107 << 21)) + (654183 * j125) + j130;
        long j132 = j128 - (j130 << 21);
        long j133 = j131 >> 21;
        long j134 = ((j108 - (j109 << 21)) - (997805 * j125)) + j133;
        long j135 = j131 - (j133 << 21);
        long j136 = j134 >> 21;
        long j137 = (j110 - (j111 << 21)) + (136657 * j125) + j136;
        long j138 = j134 - (j136 << 21);
        long j139 = j137 >> 21;
        long j140 = ((j112 - (j113 << 21)) - (683901 * j125)) + j139;
        long j141 = j137 - (j139 << 21);
        long j142 = j140 >> 21;
        long j143 = (j114 - (j115 << 21)) + j142;
        long j144 = j140 - (j142 << 21);
        long j145 = j143 >> 21;
        long j146 = (j116 - (j117 << 21)) + j145;
        long j147 = j143 - (j145 << 21);
        long j148 = j146 >> 21;
        long j149 = (j118 - (j119 << 21)) + j148;
        long j150 = j146 - (j148 << 21);
        long j151 = j149 >> 21;
        long j152 = (j120 - (j121 << 21)) + j151;
        long j153 = j149 - (j151 << 21);
        long j154 = j152 >> 21;
        long j155 = (j122 - (j123 << 21)) + j154;
        long j156 = j152 - (j154 << 21);
        long j157 = j155 >> 21;
        long j158 = (j124 - (j125 << 21)) + j157;
        long j159 = j155 - (j157 << 21);
        bArr[0] = (byte) j129;
        bArr[1] = (byte) (j129 >> 8);
        bArr[2] = (byte) ((j129 >> 16) | (j132 << 5));
        bArr[3] = (byte) (j132 >> 3);
        bArr[4] = (byte) (j132 >> 11);
        bArr[5] = (byte) ((j132 >> 19) | (j135 << 2));
        bArr[6] = (byte) (j135 >> 6);
        bArr[7] = (byte) ((j135 >> 14) | (j138 << 7));
        bArr[8] = (byte) (j138 >> 1);
        bArr[9] = (byte) (j138 >> 9);
        bArr[10] = (byte) ((j138 >> 17) | (j141 << 4));
        bArr[11] = (byte) (j141 >> 4);
        bArr[12] = (byte) (j141 >> 12);
        bArr[13] = (byte) ((j141 >> 20) | (j144 << 1));
        bArr[14] = (byte) (j144 >> 7);
        bArr[15] = (byte) ((j144 >> 15) | (j147 << 6));
        bArr[16] = (byte) (j147 >> 2);
        bArr[17] = (byte) (j147 >> 10);
        bArr[18] = (byte) ((j147 >> 18) | (j150 << 3));
        bArr[19] = (byte) (j150 >> 5);
        bArr[20] = (byte) (j150 >> 13);
        bArr[21] = (byte) j153;
        bArr[22] = (byte) (j153 >> 8);
        bArr[23] = (byte) ((j153 >> 16) | (j156 << 5));
        bArr[24] = (byte) (j156 >> 3);
        bArr[25] = (byte) (j156 >> 11);
        bArr[26] = (byte) ((j156 >> 19) | (j159 << 2));
        bArr[27] = (byte) (j159 >> 6);
        bArr[28] = (byte) ((j159 >> 14) | (j158 << 7));
        bArr[29] = (byte) (j158 >> 1);
        bArr[30] = (byte) (j158 >> 9);
        bArr[31] = (byte) (j158 >> 17);
    }

    public static byte[] getHashedScalar(byte[] bArr) throws GeneralSecurityException {
        MessageDigest engineFactory = EngineFactory.MESSAGE_DIGEST.getInstance("SHA-512");
        engineFactory.update(bArr, 0, 32);
        byte[] bArrDigest = engineFactory.digest();
        bArrDigest[0] = (byte) (bArrDigest[0] & 248);
        byte b = (byte) (bArrDigest[31] & 127);
        bArrDigest[31] = b;
        bArrDigest[31] = (byte) (b | SignedBytes.MAX_POWER_OF_TWO);
        return bArrDigest;
    }

    public static byte[] sign(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 0, bArr.length);
        MessageDigest engineFactory = EngineFactory.MESSAGE_DIGEST.getInstance("SHA-512");
        engineFactory.update(bArr3, 32, 32);
        engineFactory.update(bArrCopyOfRange);
        byte[] bArrDigest = engineFactory.digest();
        reduce(bArrDigest);
        byte[] bArrCopyOfRange2 = Arrays.copyOfRange(scalarMultWithBase(bArrDigest).toBytes(), 0, 32);
        engineFactory.reset();
        engineFactory.update(bArrCopyOfRange2);
        engineFactory.update(bArr2);
        engineFactory.update(bArrCopyOfRange);
        byte[] bArrDigest2 = engineFactory.digest();
        reduce(bArrDigest2);
        byte[] bArr4 = new byte[32];
        mulAdd(bArr4, bArrDigest2, bArr3, bArrDigest);
        return Bytes.concat(bArrCopyOfRange2, bArr4);
    }

    private static boolean isSmallerThanGroupOrder(byte[] bArr) {
        for (int i = 31; i >= 0; i--) {
            int i2 = bArr[i] & 255;
            int i3 = GROUP_ORDER[i] & 255;
            if (i2 != i3) {
                return i2 < i3;
            }
        }
        return false;
    }

    public static boolean verify(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        if (bArr2.length != 64) {
            return false;
        }
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr2, 32, 64);
        if (!isSmallerThanGroupOrder(bArrCopyOfRange)) {
            return false;
        }
        MessageDigest engineFactory = EngineFactory.MESSAGE_DIGEST.getInstance("SHA-512");
        engineFactory.update(bArr2, 0, 32);
        engineFactory.update(bArr3);
        engineFactory.update(bArr);
        byte[] bArrDigest = engineFactory.digest();
        reduce(bArrDigest);
        byte[] bytes = doubleScalarMultVarTime(bArrDigest, XYZT.fromBytesNegateVarTime(bArr3), bArrCopyOfRange).toBytes();
        for (int i = 0; i < 32; i++) {
            if (bytes[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void init() {
        if (Ed25519Constants.D == null) {
            throw new IllegalStateException("Could not initialize Ed25519.");
        }
    }

    private Ed25519() {
    }
}
