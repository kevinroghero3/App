package com.google.crypto.tink.hybrid.internal;

import com.google.crypto.tink.hybrid.HpkeParameters;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.subtle.Bytes;
import com.google.crypto.tink.subtle.EllipticCurves;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes2.dex */
public final class HpkeUtil {
    private static final byte[] HPKE;
    private static final byte[] HPKE_V1;
    private static final byte[] KEM;
    public static final byte[] BASE_MODE = intToByteArray(1, 0);
    public static final byte[] AUTH_MODE = intToByteArray(1, 2);
    public static final byte[] X25519_HKDF_SHA256_KEM_ID = intToByteArray(2, 32);
    public static final byte[] P256_HKDF_SHA256_KEM_ID = intToByteArray(2, 16);
    public static final byte[] P384_HKDF_SHA384_KEM_ID = intToByteArray(2, 17);
    public static final byte[] P521_HKDF_SHA512_KEM_ID = intToByteArray(2, 18);
    public static final byte[] HKDF_SHA256_KDF_ID = intToByteArray(2, 1);
    public static final byte[] HKDF_SHA384_KDF_ID = intToByteArray(2, 2);
    public static final byte[] HKDF_SHA512_KDF_ID = intToByteArray(2, 3);
    public static final byte[] AES_128_GCM_AEAD_ID = intToByteArray(2, 1);
    public static final byte[] AES_256_GCM_AEAD_ID = intToByteArray(2, 2);
    public static final byte[] CHACHA20_POLY1305_AEAD_ID = intToByteArray(2, 3);
    public static final byte[] EMPTY_SALT = new byte[0];

    static {
        Charset charset = Util.UTF_8;
        KEM = "KEM".getBytes(charset);
        HPKE = "HPKE".getBytes(charset);
        HPKE_V1 = "HPKE-v1".getBytes(charset);
    }

    public static byte[] intToByteArray(int i, int i2) {
        if (i > 4 || i < 0) {
            throw new IllegalArgumentException("capacity must be between 0 and 4");
        }
        if (i2 < 0 || (i < 4 && i2 >= (1 << (i * 8)))) {
            throw new IllegalArgumentException("value too large");
        }
        byte[] bArr = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) ((i2 >> (((i - i3) - 1) * 8)) & 255);
        }
        return bArr;
    }

    static byte[] kemSuiteId(byte[] bArr) throws GeneralSecurityException {
        return Bytes.concat(KEM, bArr);
    }

    static byte[] hpkeSuiteId(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        return Bytes.concat(HPKE, bArr, bArr2, bArr3);
    }

    static byte[] labelIkm(String str, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return Bytes.concat(HPKE_V1, bArr2, str.getBytes(Util.UTF_8), bArr);
    }

    static byte[] labelInfo(String str, byte[] bArr, byte[] bArr2, int i) throws GeneralSecurityException {
        return Bytes.concat(intToByteArray(2, i), HPKE_V1, bArr2, str.getBytes(Util.UTF_8), bArr);
    }

    static EllipticCurves.CurveType nistHpkeKemToCurve(HpkeParameters.KemId kemId) throws GeneralSecurityException {
        if (kemId == HpkeParameters.KemId.DHKEM_P256_HKDF_SHA256) {
            return EllipticCurves.CurveType.NIST_P256;
        }
        if (kemId == HpkeParameters.KemId.DHKEM_P384_HKDF_SHA384) {
            return EllipticCurves.CurveType.NIST_P384;
        }
        if (kemId == HpkeParameters.KemId.DHKEM_P521_HKDF_SHA512) {
            return EllipticCurves.CurveType.NIST_P521;
        }
        throw new GeneralSecurityException("Unrecognized NIST HPKE KEM identifier");
    }

    public static int getEncodedPublicKeyLength(HpkeParameters.KemId kemId) throws GeneralSecurityException {
        if (kemId == HpkeParameters.KemId.DHKEM_X25519_HKDF_SHA256) {
            return 32;
        }
        if (kemId == HpkeParameters.KemId.DHKEM_P256_HKDF_SHA256) {
            return 65;
        }
        if (kemId == HpkeParameters.KemId.DHKEM_P384_HKDF_SHA384) {
            return 97;
        }
        if (kemId == HpkeParameters.KemId.DHKEM_P521_HKDF_SHA512) {
            return 133;
        }
        throw new GeneralSecurityException("Unrecognized HPKE KEM identifier");
    }

    public static int encodingSizeInBytes(HpkeParameters.KemId kemId) {
        if (kemId == HpkeParameters.KemId.DHKEM_X25519_HKDF_SHA256) {
            return 32;
        }
        if (kemId == HpkeParameters.KemId.DHKEM_P256_HKDF_SHA256) {
            return 65;
        }
        if (kemId == HpkeParameters.KemId.DHKEM_P384_HKDF_SHA384) {
            return 97;
        }
        if (kemId == HpkeParameters.KemId.DHKEM_P521_HKDF_SHA512) {
            return 133;
        }
        throw new IllegalArgumentException("Unable to determine KEM-encoding length for " + kemId);
    }

    public static int getEncodedPrivateKeyLength(HpkeParameters.KemId kemId) throws GeneralSecurityException {
        if (kemId == HpkeParameters.KemId.DHKEM_X25519_HKDF_SHA256 || kemId == HpkeParameters.KemId.DHKEM_P256_HKDF_SHA256) {
            return 32;
        }
        if (kemId == HpkeParameters.KemId.DHKEM_P384_HKDF_SHA384) {
            return 48;
        }
        if (kemId == HpkeParameters.KemId.DHKEM_P521_HKDF_SHA512) {
            return 66;
        }
        throw new GeneralSecurityException("Unrecognized HPKE KEM identifier");
    }

    private HpkeUtil() {
    }
}
