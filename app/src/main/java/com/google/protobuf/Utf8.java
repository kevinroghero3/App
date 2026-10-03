package com.google.protobuf;

import com.facebook.imageutils.JfifUtil;
import com.google.common.base.Ascii;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
final class Utf8 {
    private static final long ASCII_MASK_LONG = -9187201950435737472L;
    static final int COMPLETE = 0;
    static final int MALFORMED = -1;
    static final int MAX_BYTES_PER_CHAR = 3;
    private static final int UNSAFE_COUNT_ASCII_THRESHOLD = 16;
    private static final Processor processor;

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(int i) {
        if (i > -12) {
            return -1;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(int i, int i2) {
        if (i > -12 || i2 > -65) {
            return -1;
        }
        return i ^ (i2 << 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(int i, int i2, int i3) {
        if (i > -12 || i2 > -65 || i3 > -65) {
            return -1;
        }
        return (i ^ (i2 << 8)) ^ (i3 << 16);
    }

    static {
        Processor safeProcessor;
        if (UnsafeProcessor.isAvailable() && !Android.isOnAndroidDevice()) {
            safeProcessor = new UnsafeProcessor();
        } else {
            safeProcessor = new SafeProcessor();
        }
        processor = safeProcessor;
    }

    static boolean isValidUtf8(byte[] bArr) {
        return processor.isValidUtf8(bArr, 0, bArr.length);
    }

    static boolean isValidUtf8(byte[] bArr, int i, int i2) {
        return processor.isValidUtf8(bArr, i, i2);
    }

    static int partialIsValidUtf8(int i, byte[] bArr, int i2, int i3) {
        return processor.partialIsValidUtf8(i, bArr, i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(byte[] bArr, int i, int i2) {
        byte b = bArr[i - 1];
        int i3 = i2 - i;
        if (i3 == 0) {
            return incompleteStateFor(b);
        }
        if (i3 == 1) {
            return incompleteStateFor(b, bArr[i]);
        }
        if (i3 == 2) {
            return incompleteStateFor(b, bArr[i], bArr[i + 1]);
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(ByteBuffer byteBuffer, int i, int i2, int i3) {
        if (i3 == 0) {
            return incompleteStateFor(i);
        }
        if (i3 == 1) {
            return incompleteStateFor(i, byteBuffer.get(i2));
        }
        if (i3 == 2) {
            return incompleteStateFor(i, byteBuffer.get(i2), byteBuffer.get(i2 + 1));
        }
        throw new AssertionError();
    }

    static class UnpairedSurrogateException extends IllegalArgumentException {
        UnpairedSurrogateException(int i, int i2) {
            super("Unpaired surrogate at index " + i + " of " + i2);
        }
    }

    static int encodedLength(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        while (i < length && charSequence.charAt(i) < 128) {
            i++;
        }
        int iEncodedLengthGeneral = length;
        while (i < length) {
            char cCharAt = charSequence.charAt(i);
            if (cCharAt >= 2048) {
                iEncodedLengthGeneral += encodedLengthGeneral(charSequence, i);
                break;
            }
            iEncodedLengthGeneral += (127 - cCharAt) >>> 31;
            i++;
        }
        if (iEncodedLengthGeneral >= length) {
            return iEncodedLengthGeneral;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) iEncodedLengthGeneral) + 4294967296L));
    }

    private static int encodedLengthGeneral(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = 0;
        while (i < length) {
            char cCharAt = charSequence.charAt(i);
            if (cCharAt < 2048) {
                i2 += (127 - cCharAt) >>> 31;
            } else {
                i2 += 2;
                if (55296 <= cCharAt && cCharAt <= 57343) {
                    if (Character.codePointAt(charSequence, i) < 65536) {
                        throw new UnpairedSurrogateException(i, length);
                    }
                    i++;
                }
            }
            i++;
        }
        return i2;
    }

    static int encode(CharSequence charSequence, byte[] bArr, int i, int i2) {
        return processor.encodeUtf8(charSequence, bArr, i, i2);
    }

    static boolean isValidUtf8(ByteBuffer byteBuffer) {
        return processor.isValidUtf8(byteBuffer, byteBuffer.position(), byteBuffer.remaining());
    }

    static int partialIsValidUtf8(int i, ByteBuffer byteBuffer, int i2, int i3) {
        return processor.partialIsValidUtf8(i, byteBuffer, i2, i3);
    }

    static String decodeUtf8(ByteBuffer byteBuffer, int i, int i2) throws InvalidProtocolBufferException {
        return processor.decodeUtf8(byteBuffer, i, i2);
    }

    static String decodeUtf8(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException {
        return processor.decodeUtf8(bArr, i, i2);
    }

    static void encodeUtf8(CharSequence charSequence, ByteBuffer byteBuffer) {
        processor.encodeUtf8(charSequence, byteBuffer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int estimateConsecutiveAscii(ByteBuffer byteBuffer, int i, int i2) {
        int i3 = i;
        while (i3 < i2 - 7 && (byteBuffer.getLong(i3) & (-9187201950435737472L)) == 0) {
            i3 += 8;
        }
        return i3 - i;
    }

    static abstract class Processor {
        abstract String decodeUtf8(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException;

        abstract String decodeUtf8Direct(ByteBuffer byteBuffer, int i, int i2) throws InvalidProtocolBufferException;

        abstract int encodeUtf8(CharSequence charSequence, byte[] bArr, int i, int i2);

        abstract void encodeUtf8Direct(CharSequence charSequence, ByteBuffer byteBuffer);

        abstract int partialIsValidUtf8(int i, byte[] bArr, int i2, int i3);

        abstract int partialIsValidUtf8Direct(int i, ByteBuffer byteBuffer, int i2, int i3);

        Processor() {
        }

        final boolean isValidUtf8(byte[] bArr, int i, int i2) {
            return partialIsValidUtf8(0, bArr, i, i2) == 0;
        }

        final boolean isValidUtf8(ByteBuffer byteBuffer, int i, int i2) {
            return partialIsValidUtf8(0, byteBuffer, i, i2) == 0;
        }

        final int partialIsValidUtf8(int i, ByteBuffer byteBuffer, int i2, int i3) {
            if (byteBuffer.hasArray()) {
                int iArrayOffset = byteBuffer.arrayOffset();
                return partialIsValidUtf8(i, byteBuffer.array(), i2 + iArrayOffset, iArrayOffset + i3);
            }
            if (byteBuffer.isDirect()) {
                return partialIsValidUtf8Direct(i, byteBuffer, i2, i3);
            }
            return partialIsValidUtf8Default(i, byteBuffer, i2, i3);
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0017, code lost:
        
            if (r8.get(r9) > (-65)) goto L11;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0048, code lost:
        
            if (r8.get(r9) > (-65)) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x008b, code lost:
        
            if (r8.get(r9) > (-65)) goto L53;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        final int partialIsValidUtf8Default(int r7, java.nio.ByteBuffer r8, int r9, int r10) {
            /*
                r6 = this;
                if (r7 == 0) goto L91
                if (r9 < r10) goto L5
                return r7
            L5:
                byte r0 = (byte) r7
                r1 = -32
                r2 = -1
                r3 = -65
                if (r0 >= r1) goto L1a
                r7 = -62
                if (r0 < r7) goto L19
                int r7 = r9 + 1
                byte r9 = r8.get(r9)
                if (r9 <= r3) goto L8e
            L19:
                return r2
            L1a:
                r4 = -16
                if (r0 >= r4) goto L4b
                int r7 = r7 >> 8
                int r7 = ~r7
                byte r7 = (byte) r7
                if (r7 != 0) goto L34
                int r7 = r9 + 1
                byte r9 = r8.get(r9)
                if (r7 < r10) goto L31
                int r7 = com.google.protobuf.Utf8.access$000(r0, r9)
                return r7
            L31:
                r5 = r9
                r9 = r7
                r7 = r5
            L34:
                if (r7 > r3) goto L4a
                r4 = -96
                if (r0 != r1) goto L3c
                if (r7 < r4) goto L4a
            L3c:
                r1 = -19
                if (r0 != r1) goto L42
                if (r7 >= r4) goto L4a
            L42:
                int r7 = r9 + 1
                byte r9 = r8.get(r9)
                if (r9 <= r3) goto L8e
            L4a:
                return r2
            L4b:
                int r1 = r7 >> 8
                int r1 = ~r1
                byte r1 = (byte) r1
                if (r1 != 0) goto L63
                int r7 = r9 + 1
                byte r1 = r8.get(r9)
                if (r7 < r10) goto L5e
                int r7 = com.google.protobuf.Utf8.access$000(r0, r1)
                return r7
            L5e:
                r9 = 0
                r5 = r9
                r9 = r7
                r7 = r5
                goto L66
            L63:
                int r7 = r7 >> 16
                byte r7 = (byte) r7
            L66:
                if (r7 != 0) goto L78
                int r7 = r9 + 1
                byte r9 = r8.get(r9)
                if (r7 < r10) goto L75
                int r7 = com.google.protobuf.Utf8.access$100(r0, r1, r9)
                return r7
            L75:
                r5 = r9
                r9 = r7
                r7 = r5
            L78:
                if (r1 > r3) goto L90
                int r0 = r0 << 28
                int r1 = r1 + 112
                int r0 = r0 + r1
                int r0 = r0 >> 30
                if (r0 != 0) goto L90
                if (r7 > r3) goto L90
                int r7 = r9 + 1
                byte r9 = r8.get(r9)
                if (r9 <= r3) goto L8e
                goto L90
            L8e:
                r9 = r7
                goto L91
            L90:
                return r2
            L91:
                int r7 = partialIsValidUtf8(r8, r9, r10)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.Processor.partialIsValidUtf8Default(int, java.nio.ByteBuffer, int, int):int");
        }

        private static int partialIsValidUtf8(ByteBuffer byteBuffer, int i, int i2) {
            int iEstimateConsecutiveAscii = i + Utf8.estimateConsecutiveAscii(byteBuffer, i, i2);
            while (iEstimateConsecutiveAscii < i2) {
                int i3 = iEstimateConsecutiveAscii + 1;
                byte b = byteBuffer.get(iEstimateConsecutiveAscii);
                if (b < 0) {
                    if (b < -32) {
                        if (i3 >= i2) {
                            return b;
                        }
                        if (b < -62 || byteBuffer.get(i3) > -65) {
                            return -1;
                        }
                        iEstimateConsecutiveAscii += 2;
                    } else {
                        if (b >= -16) {
                            if (i3 >= i2 - 2) {
                                return Utf8.incompleteStateFor(byteBuffer, b, i3, i2 - i3);
                            }
                            byte b2 = byteBuffer.get(i3);
                            if (b2 <= -65 && (((b << Ascii.FS) + (b2 + 112)) >> 30) == 0 && byteBuffer.get(iEstimateConsecutiveAscii + 2) <= -65) {
                                i3 = iEstimateConsecutiveAscii + 4;
                                if (byteBuffer.get(iEstimateConsecutiveAscii + 3) > -65) {
                                }
                            }
                            return -1;
                        }
                        if (i3 >= i2 - 1) {
                            return Utf8.incompleteStateFor(byteBuffer, b, i3, i2 - i3);
                        }
                        byte b3 = byteBuffer.get(i3);
                        if (b3 > -65 || ((b == -32 && b3 < -96) || ((b == -19 && b3 >= -96) || byteBuffer.get(iEstimateConsecutiveAscii + 2) > -65))) {
                            return -1;
                        }
                        iEstimateConsecutiveAscii += 3;
                    }
                }
                iEstimateConsecutiveAscii = i3;
            }
            return 0;
        }

        final String decodeUtf8(ByteBuffer byteBuffer, int i, int i2) throws InvalidProtocolBufferException {
            if (byteBuffer.hasArray()) {
                return decodeUtf8(byteBuffer.array(), byteBuffer.arrayOffset() + i, i2);
            }
            if (byteBuffer.isDirect()) {
                return decodeUtf8Direct(byteBuffer, i, i2);
            }
            return decodeUtf8Default(byteBuffer, i, i2);
        }

        final String decodeUtf8Default(ByteBuffer byteBuffer, int i, int i2) throws InvalidProtocolBufferException {
            if ((i | i2 | ((byteBuffer.limit() - i) - i2)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i), Integer.valueOf(i2)));
            }
            int i3 = i + i2;
            char[] cArr = new char[i2];
            int i4 = 0;
            while (i < i3) {
                byte b = byteBuffer.get(i);
                if (!DecodeUtil.isOneByte(b)) {
                    break;
                }
                i++;
                DecodeUtil.handleOneByte(b, cArr, i4);
                i4++;
            }
            int i5 = i4;
            while (i < i3) {
                int i6 = i + 1;
                byte b2 = byteBuffer.get(i);
                if (DecodeUtil.isOneByte(b2)) {
                    DecodeUtil.handleOneByte(b2, cArr, i5);
                    i5++;
                    i = i6;
                    while (i < i3) {
                        byte b3 = byteBuffer.get(i);
                        if (!DecodeUtil.isOneByte(b3)) {
                            break;
                        }
                        i++;
                        DecodeUtil.handleOneByte(b3, cArr, i5);
                        i5++;
                    }
                } else if (DecodeUtil.isTwoBytes(b2)) {
                    if (i6 >= i3) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    i += 2;
                    DecodeUtil.handleTwoBytes(b2, byteBuffer.get(i6), cArr, i5);
                    i5++;
                } else if (DecodeUtil.isThreeBytes(b2)) {
                    if (i6 >= i3 - 1) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    DecodeUtil.handleThreeBytes(b2, byteBuffer.get(i6), byteBuffer.get(i + 2), cArr, i5);
                    i5++;
                    i += 3;
                } else {
                    if (i6 >= i3 - 2) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    DecodeUtil.handleFourBytes(b2, byteBuffer.get(i6), byteBuffer.get(i + 2), byteBuffer.get(i + 3), cArr, i5);
                    i5 += 2;
                    i += 4;
                }
            }
            return new String(cArr, 0, i5);
        }

        final void encodeUtf8(CharSequence charSequence, ByteBuffer byteBuffer) {
            if (byteBuffer.hasArray()) {
                int iArrayOffset = byteBuffer.arrayOffset();
            } else if (byteBuffer.isDirect()) {
                encodeUtf8Direct(charSequence, byteBuffer);
            } else {
                encodeUtf8Default(charSequence, byteBuffer);
            }
        }

        final void encodeUtf8Default(CharSequence charSequence, ByteBuffer byteBuffer) {
            int i;
            int i2;
            int length = charSequence.length();
            int iPosition = byteBuffer.position();
            int i3 = 0;
            while (i3 < length) {
                try {
                    char cCharAt = charSequence.charAt(i3);
                    if (cCharAt >= 128) {
                        break;
                    }
                    byteBuffer.put(iPosition + i3, (byte) cCharAt);
                    i3++;
                } catch (IndexOutOfBoundsException unused) {
                    i = iPosition;
                }
            }
            if (i3 == length) {
                return;
            }
            int i4 = iPosition + i3;
            while (i3 < length) {
                char cCharAt2 = charSequence.charAt(i3);
                if (cCharAt2 < 128) {
                    byteBuffer.put(i4, (byte) cCharAt2);
                } else if (cCharAt2 < 2048) {
                    int i5 = i4 + 1;
                    try {
                        byteBuffer.put(i4, (byte) ((cCharAt2 >>> 6) | JfifUtil.MARKER_SOFn));
                        byteBuffer.put(i5, (byte) ((cCharAt2 & '?') | 128));
                        i4 = i5;
                    } catch (IndexOutOfBoundsException unused2) {
                        i = i5;
                    }
                } else if (cCharAt2 < 55296 || 57343 < cCharAt2) {
                    int i6 = i4 + 1;
                    byteBuffer.put(i4, (byte) ((cCharAt2 >>> '\f') | 224));
                    i4 += 2;
                    byteBuffer.put(i6, (byte) (((cCharAt2 >>> 6) & 63) | 128));
                    byteBuffer.put(i4, (byte) ((cCharAt2 & '?') | 128));
                } else {
                    int i7 = i3 + 1;
                    if (i7 != length) {
                        try {
                            char cCharAt3 = charSequence.charAt(i7);
                            if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                i2 = i4 + 1;
                                try {
                                    byteBuffer.put(i4, (byte) ((codePoint >>> 18) | 240));
                                    i = i4 + 2;
                                    try {
                                        byteBuffer.put(i2, (byte) (((codePoint >>> 12) & 63) | 128));
                                        i4 += 3;
                                        byteBuffer.put(i, (byte) (((codePoint >>> 6) & 63) | 128));
                                        byteBuffer.put(i4, (byte) ((codePoint & 63) | 128));
                                        i3 = i7;
                                    } catch (IndexOutOfBoundsException unused3) {
                                    }
                                } catch (IndexOutOfBoundsException unused4) {
                                    i = i2;
                                }
                            } else {
                                i3 = i7;
                            }
                        } catch (IndexOutOfBoundsException unused5) {
                            i2 = i4;
                        }
                        i = i2;
                        i3 = i7;
                        throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i3) + " at index " + (byteBuffer.position() + Math.max(i3, (i - byteBuffer.position()) + 1)));
                    }
                    throw new UnpairedSurrogateException(i3, length);
                }
                i3++;
                i4++;
            }
        }
    }

    static final class SafeProcessor extends Processor {
        SafeProcessor() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0015, code lost:
        
            if (r8[r9] > (-65)) goto L11;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0042, code lost:
        
            if (r8[r9] > (-65)) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x007f, code lost:
        
            if (r8[r9] > (-65)) goto L53;
         */
        @Override // com.google.protobuf.Utf8.Processor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        int partialIsValidUtf8(int r7, byte[] r8, int r9, int r10) {
            /*
                r6 = this;
                if (r7 == 0) goto L85
                if (r9 < r10) goto L5
                return r7
            L5:
                byte r0 = (byte) r7
                r1 = -32
                r2 = -1
                r3 = -65
                if (r0 >= r1) goto L18
                r7 = -62
                if (r0 < r7) goto L17
                int r7 = r9 + 1
                r9 = r8[r9]
                if (r9 <= r3) goto L82
            L17:
                return r2
            L18:
                r4 = -16
                if (r0 >= r4) goto L45
                int r7 = r7 >> 8
                int r7 = ~r7
                byte r7 = (byte) r7
                if (r7 != 0) goto L30
                int r7 = r9 + 1
                r9 = r8[r9]
                if (r7 < r10) goto L2d
                int r7 = com.google.protobuf.Utf8.access$000(r0, r9)
                return r7
            L2d:
                r5 = r9
                r9 = r7
                r7 = r5
            L30:
                if (r7 > r3) goto L44
                r4 = -96
                if (r0 != r1) goto L38
                if (r7 < r4) goto L44
            L38:
                r1 = -19
                if (r0 != r1) goto L3e
                if (r7 >= r4) goto L44
            L3e:
                int r7 = r9 + 1
                r9 = r8[r9]
                if (r9 <= r3) goto L82
            L44:
                return r2
            L45:
                int r1 = r7 >> 8
                int r1 = ~r1
                byte r1 = (byte) r1
                if (r1 != 0) goto L5b
                int r7 = r9 + 1
                r1 = r8[r9]
                if (r7 < r10) goto L56
                int r7 = com.google.protobuf.Utf8.access$000(r0, r1)
                return r7
            L56:
                r9 = 0
                r5 = r9
                r9 = r7
                r7 = r5
                goto L5e
            L5b:
                int r7 = r7 >> 16
                byte r7 = (byte) r7
            L5e:
                if (r7 != 0) goto L6e
                int r7 = r9 + 1
                r9 = r8[r9]
                if (r7 < r10) goto L6b
                int r7 = com.google.protobuf.Utf8.access$100(r0, r1, r9)
                return r7
            L6b:
                r5 = r9
                r9 = r7
                r7 = r5
            L6e:
                if (r1 > r3) goto L84
                int r0 = r0 << 28
                int r1 = r1 + 112
                int r0 = r0 + r1
                int r0 = r0 >> 30
                if (r0 != 0) goto L84
                if (r7 > r3) goto L84
                int r7 = r9 + 1
                r9 = r8[r9]
                if (r9 <= r3) goto L82
                goto L84
            L82:
                r9 = r7
                goto L85
            L84:
                return r2
            L85:
                int r7 = partialIsValidUtf8(r8, r9, r10)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.SafeProcessor.partialIsValidUtf8(int, byte[], int, int):int");
        }

        @Override // com.google.protobuf.Utf8.Processor
        int partialIsValidUtf8Direct(int i, ByteBuffer byteBuffer, int i2, int i3) {
            return partialIsValidUtf8Default(i, byteBuffer, i2, i3);
        }

        @Override // com.google.protobuf.Utf8.Processor
        String decodeUtf8(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException {
            if ((i | i2 | ((bArr.length - i) - i2)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
            }
            int i3 = i + i2;
            char[] cArr = new char[i2];
            int i4 = 0;
            while (i < i3) {
                byte b = bArr[i];
                if (!DecodeUtil.isOneByte(b)) {
                    break;
                }
                i++;
                DecodeUtil.handleOneByte(b, cArr, i4);
                i4++;
            }
            int i5 = i4;
            while (i < i3) {
                int i6 = i + 1;
                byte b2 = bArr[i];
                if (DecodeUtil.isOneByte(b2)) {
                    DecodeUtil.handleOneByte(b2, cArr, i5);
                    i5++;
                    i = i6;
                    while (i < i3) {
                        byte b3 = bArr[i];
                        if (!DecodeUtil.isOneByte(b3)) {
                            break;
                        }
                        i++;
                        DecodeUtil.handleOneByte(b3, cArr, i5);
                        i5++;
                    }
                } else if (DecodeUtil.isTwoBytes(b2)) {
                    if (i6 >= i3) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    i += 2;
                    DecodeUtil.handleTwoBytes(b2, bArr[i6], cArr, i5);
                    i5++;
                } else if (DecodeUtil.isThreeBytes(b2)) {
                    if (i6 >= i3 - 1) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    DecodeUtil.handleThreeBytes(b2, bArr[i6], bArr[i + 2], cArr, i5);
                    i5++;
                    i += 3;
                } else {
                    if (i6 >= i3 - 2) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    DecodeUtil.handleFourBytes(b2, bArr[i6], bArr[i + 2], bArr[i + 3], cArr, i5);
                    i5 += 2;
                    i += 4;
                }
            }
            return new String(cArr, 0, i5);
        }

        @Override // com.google.protobuf.Utf8.Processor
        String decodeUtf8Direct(ByteBuffer byteBuffer, int i, int i2) throws InvalidProtocolBufferException {
            return decodeUtf8Default(byteBuffer, i, i2);
        }

        @Override // com.google.protobuf.Utf8.Processor
        int encodeUtf8(CharSequence charSequence, byte[] bArr, int i, int i2) {
            int i3;
            int i4;
            int i5;
            char cCharAt;
            int length = charSequence.length();
            int i6 = i2 + i;
            int i7 = 0;
            while (i7 < length && (i5 = i7 + i) < i6 && (cCharAt = charSequence.charAt(i7)) < 128) {
                bArr[i5] = (byte) cCharAt;
                i7++;
            }
            if (i7 == length) {
                return i + length;
            }
            int i8 = i + i7;
            while (i7 < length) {
                char cCharAt2 = charSequence.charAt(i7);
                if (cCharAt2 >= 128 || i8 >= i6) {
                    if (cCharAt2 < 2048 && i8 <= i6 - 2) {
                        bArr[i8] = (byte) ((cCharAt2 >>> 6) | 960);
                        i3 = i8 + 2;
                        bArr[i8 + 1] = (byte) ((cCharAt2 & '?') | 128);
                    } else {
                        if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || i8 > i6 - 3) {
                            if (i8 <= i6 - 4) {
                                int i9 = i7 + 1;
                                if (i9 != charSequence.length()) {
                                    char cCharAt3 = charSequence.charAt(i9);
                                    if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                        int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                        bArr[i8] = (byte) ((codePoint >>> 18) | 240);
                                        bArr[i8 + 1] = (byte) (((codePoint >>> 12) & 63) | 128);
                                        bArr[i8 + 2] = (byte) (((codePoint >>> 6) & 63) | 128);
                                        bArr[i8 + 3] = (byte) ((codePoint & 63) | 128);
                                        i8 += 4;
                                        i7 = i9;
                                    } else {
                                        i7 = i9;
                                    }
                                }
                                throw new UnpairedSurrogateException(i7 - 1, length);
                            }
                            if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i4 = i7 + 1) == charSequence.length() || !Character.isSurrogatePair(cCharAt2, charSequence.charAt(i4)))) {
                                throw new UnpairedSurrogateException(i7, length);
                            }
                            throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt2 + " at index " + i8);
                        }
                        bArr[i8] = (byte) ((cCharAt2 >>> '\f') | 480);
                        bArr[i8 + 1] = (byte) (((cCharAt2 >>> 6) & 63) | 128);
                        i3 = i8 + 3;
                        bArr[i8 + 2] = (byte) ((cCharAt2 & '?') | 128);
                    }
                    i8 = i3;
                } else {
                    bArr[i8] = (byte) cCharAt2;
                    i8++;
                }
                i7++;
            }
            return i8;
        }

        @Override // com.google.protobuf.Utf8.Processor
        void encodeUtf8Direct(CharSequence charSequence, ByteBuffer byteBuffer) {
            encodeUtf8Default(charSequence, byteBuffer);
        }

        private static int partialIsValidUtf8(byte[] bArr, int i, int i2) {
            while (i < i2 && bArr[i] >= 0) {
                i++;
            }
            if (i >= i2) {
                return 0;
            }
            return partialIsValidUtf8NonAscii(bArr, i, i2);
        }

        private static int partialIsValidUtf8NonAscii(byte[] bArr, int i, int i2) {
            while (i < i2) {
                int i3 = i + 1;
                byte b = bArr[i];
                if (b < 0) {
                    if (b < -32) {
                        if (i3 >= i2) {
                            return b;
                        }
                        if (b >= -62) {
                            i += 2;
                            if (bArr[i3] > -65) {
                            }
                        }
                        return -1;
                    }
                    if (b >= -16) {
                        if (i3 >= i2 - 2) {
                            return Utf8.incompleteStateFor(bArr, i3, i2);
                        }
                        byte b2 = bArr[i3];
                        if (b2 <= -65 && (((b << Ascii.FS) + (b2 + 112)) >> 30) == 0 && bArr[i + 2] <= -65) {
                            i3 = i + 4;
                            if (bArr[i + 3] > -65) {
                            }
                        }
                        return -1;
                    }
                    if (i3 >= i2 - 1) {
                        return Utf8.incompleteStateFor(bArr, i3, i2);
                    }
                    byte b3 = bArr[i3];
                    if (b3 <= -65 && ((b != -32 || b3 >= -96) && (b != -19 || b3 < -96))) {
                        i3 = i + 3;
                        if (bArr[i + 2] > -65) {
                        }
                    }
                    return -1;
                }
                i = i3;
            }
            return 0;
        }
    }

    static final class UnsafeProcessor extends Processor {
        UnsafeProcessor() {
        }

        static boolean isAvailable() {
            return UnsafeUtil.hasUnsafeArrayOperations() && UnsafeUtil.hasUnsafeByteBufferOperations();
        }

        /* JADX WARN: Code restructure failed: missing block: B:35:0x0056, code lost:
        
            if (com.google.protobuf.UnsafeUtil.getByte(r12, r0) > (-65)) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x009b, code lost:
        
            if (com.google.protobuf.UnsafeUtil.getByte(r12, r0) > (-65)) goto L59;
         */
        @Override // com.google.protobuf.Utf8.Processor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        int partialIsValidUtf8(int r11, byte[] r12, int r13, int r14) {
            /*
                r10 = this;
                r0 = r13 | r14
                int r1 = r12.length
                int r1 = r1 - r14
                r0 = r0 | r1
                if (r0 < 0) goto La5
                long r0 = (long) r13
                long r13 = (long) r14
                if (r11 == 0) goto L9e
                int r2 = (r0 > r13 ? 1 : (r0 == r13 ? 0 : -1))
                if (r2 < 0) goto L10
                return r11
            L10:
                byte r2 = (byte) r11
                r3 = -32
                r4 = -1
                r5 = 1
                r7 = -65
                if (r2 >= r3) goto L29
                r11 = -62
                if (r2 < r11) goto L28
                byte r11 = com.google.protobuf.UnsafeUtil.getByte(r12, r0)
                if (r11 <= r7) goto L25
                goto L28
            L25:
                long r0 = r0 + r5
                goto L9e
            L28:
                return r4
            L29:
                r8 = -16
                if (r2 >= r8) goto L5c
                int r11 = r11 >> 8
                int r11 = ~r11
                byte r11 = (byte) r11
                if (r11 != 0) goto L43
                long r8 = r0 + r5
                byte r11 = com.google.protobuf.UnsafeUtil.getByte(r12, r0)
                int r0 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
                if (r0 < 0) goto L42
                int r11 = com.google.protobuf.Utf8.access$000(r2, r11)
                return r11
            L42:
                r0 = r8
            L43:
                if (r11 > r7) goto L5b
                r8 = -96
                if (r2 != r3) goto L4b
                if (r11 < r8) goto L5b
            L4b:
                r3 = -19
                if (r2 != r3) goto L51
                if (r11 >= r8) goto L5b
            L51:
                long r5 = r5 + r0
                byte r11 = com.google.protobuf.UnsafeUtil.getByte(r12, r0)
                if (r11 <= r7) goto L59
                goto L5b
            L59:
                r0 = r5
                goto L9e
            L5b:
                return r4
            L5c:
                int r3 = r11 >> 8
                int r3 = ~r3
                byte r3 = (byte) r3
                if (r3 != 0) goto L74
                long r8 = r0 + r5
                byte r3 = com.google.protobuf.UnsafeUtil.getByte(r12, r0)
                int r11 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
                if (r11 < 0) goto L71
                int r11 = com.google.protobuf.Utf8.access$000(r2, r3)
                return r11
            L71:
                r11 = 0
                r0 = r8
                goto L77
            L74:
                int r11 = r11 >> 16
                byte r11 = (byte) r11
            L77:
                if (r11 != 0) goto L89
                long r8 = r0 + r5
                byte r11 = com.google.protobuf.UnsafeUtil.getByte(r12, r0)
                int r0 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
                if (r0 < 0) goto L88
                int r11 = com.google.protobuf.Utf8.access$100(r2, r3, r11)
                return r11
            L88:
                r0 = r8
            L89:
                if (r3 > r7) goto L9d
                int r2 = r2 << 28
                int r3 = r3 + 112
                int r2 = r2 + r3
                int r2 = r2 >> 30
                if (r2 != 0) goto L9d
                if (r11 > r7) goto L9d
                long r5 = r5 + r0
                byte r11 = com.google.protobuf.UnsafeUtil.getByte(r12, r0)
                if (r11 <= r7) goto L59
            L9d:
                return r4
            L9e:
                long r13 = r13 - r0
                int r11 = (int) r13
                int r11 = partialIsValidUtf8(r12, r0, r11)
                return r11
            La5:
                int r11 = r12.length
                java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
                java.lang.Integer r12 = java.lang.Integer.valueOf(r13)
                java.lang.Integer r13 = java.lang.Integer.valueOf(r14)
                java.lang.Object[] r11 = new java.lang.Object[]{r11, r12, r13}
                java.lang.ArrayIndexOutOfBoundsException r12 = new java.lang.ArrayIndexOutOfBoundsException
                java.lang.String r13 = "Array length=%d, index=%d, limit=%d"
                java.lang.String r11 = java.lang.String.format(r13, r11)
                r12.<init>(r11)
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.UnsafeProcessor.partialIsValidUtf8(int, byte[], int, int):int");
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x002d, code lost:
        
            if (com.google.protobuf.UnsafeUtil.getByte(r0) > (-65)) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0061, code lost:
        
            if (com.google.protobuf.UnsafeUtil.getByte(r0) > (-65)) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x00a3, code lost:
        
            if (com.google.protobuf.UnsafeUtil.getByte(r0) > (-65)) goto L57;
         */
        @Override // com.google.protobuf.Utf8.Processor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        int partialIsValidUtf8Direct(int r10, java.nio.ByteBuffer r11, int r12, int r13) {
            /*
                Method dump skipped, instruction units count: 205
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.UnsafeProcessor.partialIsValidUtf8Direct(int, java.nio.ByteBuffer, int, int):int");
        }

        @Override // com.google.protobuf.Utf8.Processor
        String decodeUtf8(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException {
            Charset charset = Internal.UTF_8;
            String str = new String(bArr, i, i2, charset);
            if (str.contains("�") && !Arrays.equals(str.getBytes(charset), Arrays.copyOfRange(bArr, i, i2 + i))) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            return str;
        }

        @Override // com.google.protobuf.Utf8.Processor
        String decodeUtf8Direct(ByteBuffer byteBuffer, int i, int i2) throws InvalidProtocolBufferException {
            if ((i | i2 | ((byteBuffer.limit() - i) - i2)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i), Integer.valueOf(i2)));
            }
            long jAddressOffset = UnsafeUtil.addressOffset(byteBuffer) + ((long) i);
            long j = ((long) i2) + jAddressOffset;
            char[] cArr = new char[i2];
            int i3 = 0;
            while (jAddressOffset < j) {
                byte b = UnsafeUtil.getByte(jAddressOffset);
                if (!DecodeUtil.isOneByte(b)) {
                    break;
                }
                jAddressOffset++;
                DecodeUtil.handleOneByte(b, cArr, i3);
                i3++;
            }
            int i4 = i3;
            while (jAddressOffset < j) {
                long j2 = jAddressOffset + 1;
                byte b2 = UnsafeUtil.getByte(jAddressOffset);
                if (DecodeUtil.isOneByte(b2)) {
                    DecodeUtil.handleOneByte(b2, cArr, i4);
                    i4++;
                    jAddressOffset = j2;
                    while (jAddressOffset < j) {
                        byte b3 = UnsafeUtil.getByte(jAddressOffset);
                        if (!DecodeUtil.isOneByte(b3)) {
                            break;
                        }
                        jAddressOffset++;
                        DecodeUtil.handleOneByte(b3, cArr, i4);
                        i4++;
                    }
                } else if (DecodeUtil.isTwoBytes(b2)) {
                    if (j2 >= j) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    jAddressOffset += 2;
                    DecodeUtil.handleTwoBytes(b2, UnsafeUtil.getByte(j2), cArr, i4);
                    i4++;
                } else if (DecodeUtil.isThreeBytes(b2)) {
                    if (j2 >= j - 1) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    DecodeUtil.handleThreeBytes(b2, UnsafeUtil.getByte(j2), UnsafeUtil.getByte(jAddressOffset + 2), cArr, i4);
                    i4++;
                    jAddressOffset = 3 + jAddressOffset;
                } else {
                    if (j2 >= j - 2) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    DecodeUtil.handleFourBytes(b2, UnsafeUtil.getByte(j2), UnsafeUtil.getByte(2 + jAddressOffset), UnsafeUtil.getByte(jAddressOffset + 3), cArr, i4);
                    i4 += 2;
                    jAddressOffset += 4;
                }
            }
            return new String(cArr, 0, i4);
        }

        @Override // com.google.protobuf.Utf8.Processor
        int encodeUtf8(CharSequence charSequence, byte[] bArr, int i, int i2) {
            long j;
            long j2;
            int i3;
            char cCharAt;
            long j3 = i;
            long j4 = ((long) i2) + j3;
            int length = charSequence.length();
            String str = " at index ";
            String str2 = "Failed writing ";
            if (length > i2 || bArr.length - i2 < i) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(length - 1) + " at index " + (i + i2));
            }
            int i4 = 0;
            while (true) {
                j = 1;
                if (i4 >= length || (cCharAt = charSequence.charAt(i4)) >= 128) {
                    break;
                }
                UnsafeUtil.putByte(bArr, j3, (byte) cCharAt);
                i4++;
                j3++;
            }
            if (i4 == length) {
                return (int) j3;
            }
            while (i4 < length) {
                char cCharAt2 = charSequence.charAt(i4);
                if (cCharAt2 >= 128 || j3 >= j4) {
                    if (cCharAt2 < 2048 && j3 <= j4 - 2) {
                        UnsafeUtil.putByte(bArr, j3, (byte) ((cCharAt2 >>> 6) | 960));
                        j2 = 2 + j3;
                        UnsafeUtil.putByte(bArr, j3 + j, (byte) ((cCharAt2 & '?') | 128));
                    } else {
                        if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || j3 > j4 - 3) {
                            str = str;
                            str2 = str2;
                            if (j3 <= j4 - 4) {
                                int i5 = i4 + 1;
                                if (i5 != length) {
                                    char cCharAt3 = charSequence.charAt(i5);
                                    if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                        int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                        UnsafeUtil.putByte(bArr, j3, (byte) ((codePoint >>> 18) | 240));
                                        UnsafeUtil.putByte(bArr, j3 + j, (byte) (((codePoint >>> 12) & 63) | 128));
                                        UnsafeUtil.putByte(bArr, j3 + 2, (byte) (((codePoint >>> 6) & 63) | 128));
                                        UnsafeUtil.putByte(bArr, j3 + 3, (byte) ((codePoint & 63) | 128));
                                        j3 = 4 + j3;
                                        i4 = i5;
                                    } else {
                                        i4 = i5;
                                    }
                                }
                                throw new UnpairedSurrogateException(i4 - 1, length);
                            }
                            if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i3 = i4 + 1) == length || !Character.isSurrogatePair(cCharAt2, charSequence.charAt(i3)))) {
                                throw new UnpairedSurrogateException(i4, length);
                            }
                            throw new ArrayIndexOutOfBoundsException(str2 + cCharAt2 + str + j3);
                        }
                        UnsafeUtil.putByte(bArr, j3, (byte) ((cCharAt2 >>> '\f') | 480));
                        UnsafeUtil.putByte(bArr, j3 + j, (byte) (((cCharAt2 >>> 6) & 63) | 128));
                        j2 = j3 + 3;
                        UnsafeUtil.putByte(bArr, j3 + 2, (byte) ((cCharAt2 & '?') | 128));
                    }
                    j3 = j2;
                } else {
                    UnsafeUtil.putByte(bArr, j3, (byte) cCharAt2);
                    j3 += j;
                    str = str;
                    str2 = str2;
                }
                i4++;
                str = str;
                str2 = str2;
                j = 1;
            }
            return (int) j3;
        }

        @Override // com.google.protobuf.Utf8.Processor
        void encodeUtf8Direct(CharSequence charSequence, ByteBuffer byteBuffer) {
            long j;
            char c;
            long j2;
            int i;
            char c2;
            char cCharAt;
            long jAddressOffset = UnsafeUtil.addressOffset(byteBuffer);
            long jPosition = ((long) byteBuffer.position()) + jAddressOffset;
            long jLimit = ((long) byteBuffer.limit()) + jAddressOffset;
            int length = charSequence.length();
            if (length > jLimit - jPosition) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(length - 1) + " at index " + byteBuffer.limit());
            }
            int i2 = 0;
            while (true) {
                j = 1;
                c = 128;
                if (i2 >= length || (cCharAt = charSequence.charAt(i2)) >= 128) {
                    break;
                }
                UnsafeUtil.putByte(jPosition, (byte) cCharAt);
                i2++;
                jPosition++;
            }
            if (i2 == length) {
                return;
            }
            while (i2 < length) {
                char cCharAt2 = charSequence.charAt(i2);
                if (cCharAt2 >= c || jPosition >= jLimit) {
                    if (cCharAt2 < 2048 && jPosition <= jLimit - 2) {
                        UnsafeUtil.putByte(jPosition, (byte) ((cCharAt2 >>> 6) | 960));
                        j2 = jPosition + 2;
                        UnsafeUtil.putByte(jPosition + 1, (byte) ((cCharAt2 & '?') | c));
                    } else {
                        if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || jPosition > jLimit - 3) {
                            if (jPosition <= jLimit - 4) {
                                int i3 = i2 + 1;
                                if (i3 != length) {
                                    char cCharAt3 = charSequence.charAt(i3);
                                    if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                        int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                        UnsafeUtil.putByte(jPosition, (byte) ((codePoint >>> 18) | 240));
                                        UnsafeUtil.putByte(jPosition + 1, (byte) (((codePoint >>> 12) & 63) | 128));
                                        UnsafeUtil.putByte(jPosition + 2, (byte) (((codePoint >>> 6) & 63) | 128));
                                        c2 = 128;
                                        UnsafeUtil.putByte(jPosition + 3, (byte) ((codePoint & 63) | 128));
                                        i2 = i3;
                                        jPosition += 4;
                                    } else {
                                        i2 = i3;
                                    }
                                }
                                throw new UnpairedSurrogateException(i2 - 1, length);
                            }
                            if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i = i2 + 1) == length || !Character.isSurrogatePair(cCharAt2, charSequence.charAt(i)))) {
                                throw new UnpairedSurrogateException(i2, length);
                            }
                            throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt2 + " at index " + jPosition);
                        }
                        UnsafeUtil.putByte(jPosition, (byte) ((cCharAt2 >>> '\f') | 480));
                        UnsafeUtil.putByte(jPosition + 1, (byte) (((cCharAt2 >>> 6) & 63) | c));
                        UnsafeUtil.putByte(jPosition + 2, (byte) ((cCharAt2 & '?') | 128));
                        j2 = jPosition + 3;
                    }
                    jPosition = j2;
                    c2 = 128;
                } else {
                    UnsafeUtil.putByte(jPosition, (byte) cCharAt2);
                    jPosition += j;
                    c2 = c;
                }
                i2++;
                c = c2;
                jLimit = jLimit;
                j = 1;
            }
        }

        private static int unsafeEstimateConsecutiveAscii(byte[] bArr, long j, int i) {
            int i2 = 0;
            if (i < 16) {
                return 0;
            }
            int i3 = (int) j;
            while (i2 < 8 - (i3 & 7)) {
                if (UnsafeUtil.getByte(bArr, j) < 0) {
                    return i2;
                }
                i2++;
                j++;
            }
            while (true) {
                int i4 = i2 + 8;
                if (i4 > i || (UnsafeUtil.getLong((Object) bArr, UnsafeUtil.BYTE_ARRAY_BASE_OFFSET + j) & (-9187201950435737472L)) != 0) {
                    break;
                }
                j += 8;
                i2 = i4;
            }
            while (i2 < i) {
                if (UnsafeUtil.getByte(bArr, j) < 0) {
                    return i2;
                }
                i2++;
                j++;
            }
            return i;
        }

        private static int unsafeEstimateConsecutiveAscii(long j, int i) {
            if (i < 16) {
                return 0;
            }
            int i2 = (int) ((-j) & 7);
            int i3 = i2;
            while (i3 > 0) {
                if (UnsafeUtil.getByte(j) < 0) {
                    return i2 - i3;
                }
                i3--;
                j++;
            }
            int i4 = i - i2;
            while (i4 >= 8 && (UnsafeUtil.getLong(j) & (-9187201950435737472L)) == 0) {
                j += 8;
                i4 -= 8;
            }
            return i - i4;
        }

        private static int partialIsValidUtf8(byte[] bArr, long j, int i) {
            long j2;
            int iUnsafeEstimateConsecutiveAscii = unsafeEstimateConsecutiveAscii(bArr, j, i);
            int i2 = i - iUnsafeEstimateConsecutiveAscii;
            long j3 = j + ((long) iUnsafeEstimateConsecutiveAscii);
            while (true) {
                byte b = 0;
                while (i2 > 0) {
                    long j4 = j3 + 1;
                    b = UnsafeUtil.getByte(bArr, j3);
                    if (b < 0) {
                        j3 = j4;
                        break;
                    }
                    i2--;
                    j3 = j4;
                }
                if (i2 == 0) {
                    return 0;
                }
                int i3 = i2 - 1;
                if (b >= -32) {
                    if (b >= -16) {
                        if (i3 < 3) {
                            return unsafeIncompleteStateFor(bArr, b, j3, i3);
                        }
                        i2 -= 4;
                        byte b2 = UnsafeUtil.getByte(bArr, j3);
                        if (b2 <= -65 && (((b << Ascii.FS) + (b2 + 112)) >> 30) == 0 && UnsafeUtil.getByte(bArr, 1 + j3) <= -65) {
                            j2 = 3 + j3;
                            if (UnsafeUtil.getByte(bArr, j3 + 2) > -65) {
                            }
                        }
                        return -1;
                    }
                    if (i3 < 2) {
                        return unsafeIncompleteStateFor(bArr, b, j3, i3);
                    }
                    i2 -= 3;
                    byte b3 = UnsafeUtil.getByte(bArr, j3);
                    if (b3 <= -65 && ((b != -32 || b3 >= -96) && (b != -19 || b3 < -96))) {
                        j2 = j3 + 2;
                        if (UnsafeUtil.getByte(bArr, j3 + 1) > -65) {
                        }
                    }
                    return -1;
                    j3 = j2;
                } else {
                    if (i3 == 0) {
                        return b;
                    }
                    i2 -= 2;
                    if (b < -62 || UnsafeUtil.getByte(bArr, j3) > -65) {
                        return -1;
                    }
                    j3++;
                }
            }
        }

        private static int partialIsValidUtf8(long j, int i) {
            long j2;
            int iUnsafeEstimateConsecutiveAscii = unsafeEstimateConsecutiveAscii(j, i);
            long j3 = j + ((long) iUnsafeEstimateConsecutiveAscii);
            int i2 = i - iUnsafeEstimateConsecutiveAscii;
            while (true) {
                byte b = 0;
                while (i2 > 0) {
                    long j4 = j3 + 1;
                    b = UnsafeUtil.getByte(j3);
                    if (b < 0) {
                        j3 = j4;
                        break;
                    }
                    i2--;
                    j3 = j4;
                }
                if (i2 == 0) {
                    return 0;
                }
                int i3 = i2 - 1;
                if (b >= -32) {
                    if (b >= -16) {
                        if (i3 < 3) {
                            return unsafeIncompleteStateFor(j3, b, i3);
                        }
                        i2 -= 4;
                        byte b2 = UnsafeUtil.getByte(j3);
                        if (b2 <= -65 && (((b << Ascii.FS) + (b2 + 112)) >> 30) == 0 && UnsafeUtil.getByte(1 + j3) <= -65) {
                            j2 = 3 + j3;
                            if (UnsafeUtil.getByte(j3 + 2) > -65) {
                            }
                        }
                        return -1;
                    }
                    if (i3 < 2) {
                        return unsafeIncompleteStateFor(j3, b, i3);
                    }
                    i2 -= 3;
                    byte b3 = UnsafeUtil.getByte(j3);
                    if (b3 <= -65 && ((b != -32 || b3 >= -96) && (b != -19 || b3 < -96))) {
                        j2 = j3 + 2;
                        if (UnsafeUtil.getByte(j3 + 1) > -65) {
                        }
                    }
                    return -1;
                    j3 = j2;
                } else {
                    if (i3 == 0) {
                        return b;
                    }
                    i2 -= 2;
                    if (b < -62 || UnsafeUtil.getByte(j3) > -65) {
                        return -1;
                    }
                    j3++;
                }
            }
        }

        private static int unsafeIncompleteStateFor(byte[] bArr, int i, long j, int i2) {
            if (i2 == 0) {
                return Utf8.incompleteStateFor(i);
            }
            if (i2 == 1) {
                return Utf8.incompleteStateFor(i, UnsafeUtil.getByte(bArr, j));
            }
            if (i2 == 2) {
                return Utf8.incompleteStateFor(i, UnsafeUtil.getByte(bArr, j), UnsafeUtil.getByte(bArr, j + 1));
            }
            throw new AssertionError();
        }

        private static int unsafeIncompleteStateFor(long j, int i, int i2) {
            if (i2 == 0) {
                return Utf8.incompleteStateFor(i);
            }
            if (i2 == 1) {
                return Utf8.incompleteStateFor(i, UnsafeUtil.getByte(j));
            }
            if (i2 == 2) {
                return Utf8.incompleteStateFor(i, UnsafeUtil.getByte(j), UnsafeUtil.getByte(j + 1));
            }
            throw new AssertionError();
        }
    }

    static class DecodeUtil {
        private static char highSurrogate(int i) {
            return (char) ((i >>> 10) + okio.Utf8.HIGH_SURROGATE_HEADER);
        }

        private static boolean isNotTrailingByte(byte b) {
            return b > -65;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isOneByte(byte b) {
            return b >= 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isThreeBytes(byte b) {
            return b < -16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isTwoBytes(byte b) {
            return b < -32;
        }

        private static char lowSurrogate(int i) {
            return (char) ((i & 1023) + okio.Utf8.LOG_SURROGATE_HEADER);
        }

        private static int trailingByteValue(byte b) {
            return b & okio.Utf8.REPLACEMENT_BYTE;
        }

        private DecodeUtil() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void handleOneByte(byte b, char[] cArr, int i) {
            cArr[i] = (char) b;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void handleTwoBytes(byte b, byte b2, char[] cArr, int i) throws InvalidProtocolBufferException {
            if (b < -62 || isNotTrailingByte(b2)) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            cArr[i] = (char) (((b & Ascii.US) << 6) | trailingByteValue(b2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void handleThreeBytes(byte b, byte b2, byte b3, char[] cArr, int i) throws InvalidProtocolBufferException {
            if (isNotTrailingByte(b2) || ((b == -32 && b2 < -96) || ((b == -19 && b2 >= -96) || isNotTrailingByte(b3)))) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            cArr[i] = (char) (((b & Ascii.SI) << 12) | (trailingByteValue(b2) << 6) | trailingByteValue(b3));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void handleFourBytes(byte b, byte b2, byte b3, byte b4, char[] cArr, int i) throws InvalidProtocolBufferException {
            if (isNotTrailingByte(b2) || (((b << Ascii.FS) + (b2 + 112)) >> 30) != 0 || isNotTrailingByte(b3) || isNotTrailingByte(b4)) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            int iTrailingByteValue = ((b & 7) << 18) | (trailingByteValue(b2) << 12) | (trailingByteValue(b3) << 6) | trailingByteValue(b4);
            cArr[i] = highSurrogate(iTrailingByteValue);
            cArr[i + 1] = lowSurrogate(iTrailingByteValue);
        }
    }

    private Utf8() {
    }
}
