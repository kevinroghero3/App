package com.google.crypto.tink.internal;

import com.google.crypto.tink.SecretKeyAccess;
import com.google.crypto.tink.util.Bytes;
import com.google.crypto.tink.util.SecretBytes;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.util.Objects;
import javax.annotation.Nullable;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: loaded from: classes2.dex */
public final class Util {
    public static final Charset UTF_8 = Charset.forName(CharEncoding.UTF_8);

    public static int randKeyId() {
        int i = 0;
        while (i == 0) {
            byte[] bArrRandBytes = Random.randBytes(4);
            i = (bArrRandBytes[3] & 255) | ((bArrRandBytes[0] & 255) << 24) | ((bArrRandBytes[1] & 255) << 16) | ((bArrRandBytes[2] & 255) << 8);
        }
        return i;
    }

    private static final byte toByteFromPrintableAscii(char c) {
        if (c >= '!' && c <= '~') {
            return (byte) c;
        }
        throw new TinkBugException("Not a printable ASCII character: " + c);
    }

    private static final byte checkedToByteFromPrintableAscii(char c) throws GeneralSecurityException {
        if (c >= '!' && c <= '~') {
            return (byte) c;
        }
        throw new GeneralSecurityException("Not a printable ASCII character: " + c);
    }

    public static final Bytes toBytesFromPrintableAscii(String str) {
        byte[] bArr = new byte[str.length()];
        for (int i = 0; i < str.length(); i++) {
            bArr[i] = toByteFromPrintableAscii(str.charAt(i));
        }
        return Bytes.copyFrom(bArr);
    }

    public static final Bytes checkedToBytesFromPrintableAscii(String str) throws GeneralSecurityException {
        byte[] bArr = new byte[str.length()];
        for (int i = 0; i < str.length(); i++) {
            bArr[i] = checkedToByteFromPrintableAscii(str.charAt(i));
        }
        return Bytes.copyFrom(bArr);
    }

    public static boolean isAndroid() {
        return Objects.equals(System.getProperty("java.vendor"), "The Android Project");
    }

    @Nullable
    public static Integer getAndroidApiLevel() {
        if (isAndroid()) {
            return BuildDispatchedCode.getApiLevel();
        }
        return null;
    }

    public static boolean isPrefix(byte[] bArr, byte[] bArr2) {
        if (bArr2.length < bArr.length) {
            return false;
        }
        for (int i = 0; i < bArr.length; i++) {
            if (bArr2[i] != bArr[i]) {
                return false;
            }
        }
        return true;
    }

    public static SecretBytes readIntoSecretBytes(InputStream inputStream, int i, SecretKeyAccess secretKeyAccess) throws GeneralSecurityException {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            try {
                int i3 = inputStream.read(bArr, i2, i - i2);
                if (i3 == -1) {
                    throw new GeneralSecurityException("Not enough pseudorandomness provided");
                }
                i2 += i3;
            } catch (IOException unused) {
                throw new GeneralSecurityException("Reading pseudorandomness failed");
            }
        }
        return SecretBytes.copyFrom(bArr, secretKeyAccess);
    }

    private Util() {
    }
}
