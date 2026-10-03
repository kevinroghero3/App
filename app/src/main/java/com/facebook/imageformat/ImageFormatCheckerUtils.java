package com.facebook.imageformat;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public final class ImageFormatCheckerUtils {
    public static final ImageFormatCheckerUtils INSTANCE = new ImageFormatCheckerUtils();

    private ImageFormatCheckerUtils() {
    }

    @JvmStatic
    public static final byte[] asciiBytes(@NotNull String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        try {
            Charset charsetForName = Charset.forName("ASCII");
            Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(...)");
            byte[] bytes = value.getBytes(charsetForName);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            return bytes;
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("ASCII not found!", e);
        }
    }

    @JvmStatic
    public static final boolean startsWithPattern(@NotNull byte[] byteArray, @NotNull byte[] pattern) {
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        return hasPatternAt(byteArray, pattern, 0);
    }

    @JvmStatic
    public static final boolean hasPatternAt(@NotNull byte[] byteArray, @NotNull byte[] pattern, int i) {
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        if (pattern.length + i > byteArray.length) {
            return false;
        }
        Iterable indices = ArraysKt___ArraysKt.getIndices(pattern);
        if (!(indices instanceof Collection) || !((Collection) indices).isEmpty()) {
            Iterator it2 = indices.iterator();
            while (it2.hasNext()) {
                int iNextInt = ((IntIterator) it2).nextInt();
                if (byteArray[i + iNextInt] != pattern[iNextInt]) {
                    return false;
                }
            }
        }
        return true;
    }

    @JvmStatic
    public static final int indexOfPattern(@NotNull byte[] byteArray, int i, @NotNull byte[] pattern, int i2) {
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        if (i2 > i) {
            return -1;
        }
        int i3 = 0;
        byte b = pattern[0];
        int i4 = i - i2;
        while (i3 <= i4) {
            if (byteArray[i3] != b) {
                do {
                    i3++;
                    if (i3 > i4) {
                        break;
                    }
                } while (byteArray[i3] != b);
            }
            if (i3 <= i4) {
                int i5 = i3 + 1;
                int i6 = (i5 + i2) - 1;
                for (int i7 = 1; i5 < i6 && byteArray[i5] == pattern[i7]; i7++) {
                    i5++;
                }
                if (i5 == i6) {
                    return i3;
                }
            }
            i3++;
        }
        return -1;
    }
}
