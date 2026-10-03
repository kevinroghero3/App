package com.facebook.imageutils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.UShort;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public final class WebpUtil {
    public static final WebpUtil INSTANCE = new WebpUtil();
    private static final String VP8L_HEADER = "VP8L";
    private static final String VP8X_HEADER = "VP8X";
    private static final String VP8_HEADER = "VP8 ";

    private WebpUtil() {
    }

    @JvmStatic
    public static final Pair<Integer, Integer> getSize(@NotNull InputStream stream) {
        Intrinsics.checkNotNullParameter(stream, "stream");
        byte[] bArr = new byte[4];
        try {
            try {
                stream.read(bArr);
                WebpUtil webpUtil = INSTANCE;
                if (!webpUtil.compare(bArr, "RIFF")) {
                    return null;
                }
                webpUtil.getInt(stream);
                stream.read(bArr);
                if (!webpUtil.compare(bArr, "WEBP")) {
                    return null;
                }
                stream.read(bArr);
                String header = webpUtil.getHeader(bArr);
                int iHashCode = header.hashCode();
                if (iHashCode != 2640674) {
                    if (iHashCode != 2640718) {
                        if (iHashCode == 2640730 && header.equals(VP8X_HEADER)) {
                            return webpUtil.getVP8XDimension(stream);
                        }
                    } else if (header.equals(VP8L_HEADER)) {
                        return webpUtil.getVP8LDimension(stream);
                    }
                } else if (header.equals(VP8_HEADER)) {
                    return webpUtil.getVP8Dimension(stream);
                }
                return null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        } finally {
            try {
                stream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    private final Pair<Integer, Integer> getVP8Dimension(InputStream inputStream) throws IOException {
        inputStream.skip(7L);
        int nextByteAsInt = getNextByteAsInt(inputStream);
        int nextByteAsInt2 = getNextByteAsInt(inputStream);
        int nextByteAsInt3 = getNextByteAsInt(inputStream);
        if (nextByteAsInt == 157 && nextByteAsInt2 == 1 && nextByteAsInt3 == 42) {
            return new Pair<>(Integer.valueOf(get2BytesAsInt(inputStream)), Integer.valueOf(get2BytesAsInt(inputStream)));
        }
        return null;
    }

    private final Pair<Integer, Integer> getVP8LDimension(InputStream inputStream) throws IOException {
        getInt(inputStream);
        if (getNextByteAsInt(inputStream) != 47) {
            return null;
        }
        int i = inputStream.read();
        int i2 = inputStream.read();
        int i3 = inputStream.read();
        return new Pair<>(Integer.valueOf(((i & 255) | ((i2 & 63) << 8)) + 1), Integer.valueOf((((inputStream.read() & 15) << 10) | ((i3 & 255) << 2) | ((i2 & JfifUtil.MARKER_SOFn) >> 6)) + 1));
    }

    private final Pair<Integer, Integer> getVP8XDimension(InputStream inputStream) throws IOException {
        inputStream.skip(8L);
        return new Pair<>(Integer.valueOf(read3Bytes(inputStream) + 1), Integer.valueOf(read3Bytes(inputStream) + 1));
    }

    private final boolean compare(byte[] bArr, String str) {
        if (bArr.length != str.length()) {
            return false;
        }
        Iterable indices = ArraysKt___ArraysKt.getIndices(bArr);
        if (!(indices instanceof Collection) || !((Collection) indices).isEmpty()) {
            Iterator it2 = indices.iterator();
            while (it2.hasNext()) {
                int iNextInt = ((IntIterator) it2).nextInt();
                if (((byte) str.charAt(iNextInt)) != bArr[iNextInt]) {
                    return false;
                }
            }
        }
        return true;
    }

    private final String getHeader(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            sb.append((char) (UShort.m5753constructorimpl(b) & UShort.MAX_VALUE));
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    private final int getInt(InputStream inputStream) throws IOException {
        int nextByteAsInt = getNextByteAsInt(inputStream);
        int nextByteAsInt2 = getNextByteAsInt(inputStream);
        return (getNextByteAsInt(inputStream) << 24) | (getNextByteAsInt(inputStream) << 16) | (nextByteAsInt2 << 8) | nextByteAsInt;
    }

    @JvmStatic
    public static final int get2BytesAsInt(@NotNull InputStream stream) throws IOException {
        Intrinsics.checkNotNullParameter(stream, "stream");
        WebpUtil webpUtil = INSTANCE;
        return (webpUtil.getNextByteAsInt(stream) << 8) | webpUtil.getNextByteAsInt(stream);
    }

    private final int read3Bytes(InputStream inputStream) throws IOException {
        return (getNextByteAsInt(inputStream) << 16) | (getNextByteAsInt(inputStream) << 8) | getNextByteAsInt(inputStream);
    }

    private final int getNextByteAsInt(InputStream inputStream) throws IOException {
        return inputStream.read() & 255;
    }
}
