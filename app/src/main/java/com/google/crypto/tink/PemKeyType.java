package com.google.crypto.tink;

import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import com.google.crypto.tink.internal.PemUtil;
import com.google.crypto.tink.subtle.EllipticCurves;
import com.google.crypto.tink.subtle.EngineFactory;
import com.google.crypto.tink.subtle.Enums;
import java.io.BufferedReader;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.interfaces.ECKey;
import java.security.interfaces.RSAKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.EncodedKeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.annotation.Nullable;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'RSA_PSS_2048_SHA256' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:399)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:364)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:349)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:315)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:288)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes5.dex */
public final class PemKeyType {
    private static final /* synthetic */ PemKeyType[] $VALUES;
    public static final PemKeyType ECDSA_P256_SHA256;
    public static final PemKeyType ECDSA_P384_SHA384;
    public static final PemKeyType ECDSA_P521_SHA512;
    public static final PemKeyType ED25519;
    public static final PemKeyType ML_DSA_65;
    public static final PemKeyType ML_DSA_87;
    public static final PemKeyType RSA_PSS_2048_SHA256;
    public static final PemKeyType RSA_PSS_3072_SHA256;
    public static final PemKeyType RSA_PSS_4096_SHA256;
    public static final PemKeyType RSA_PSS_4096_SHA512;
    public static final PemKeyType RSA_SIGN_PKCS1_2048_SHA256;
    public static final PemKeyType RSA_SIGN_PKCS1_3072_SHA256;
    public static final PemKeyType RSA_SIGN_PKCS1_4096_SHA256;
    public static final PemKeyType RSA_SIGN_PKCS1_4096_SHA512;
    public final String algorithm;
    public final Enums.HashType hash;
    public final int keySizeInBits;
    public final String keyType;

    private static /* synthetic */ PemKeyType[] $values() {
        return new PemKeyType[]{RSA_PSS_2048_SHA256, RSA_PSS_3072_SHA256, RSA_PSS_4096_SHA256, RSA_PSS_4096_SHA512, RSA_SIGN_PKCS1_2048_SHA256, RSA_SIGN_PKCS1_3072_SHA256, RSA_SIGN_PKCS1_4096_SHA256, RSA_SIGN_PKCS1_4096_SHA512, ECDSA_P256_SHA256, ECDSA_P384_SHA384, ECDSA_P521_SHA512, ED25519, ML_DSA_65, ML_DSA_87};
    }

    public static PemKeyType valueOf(String str) {
        return (PemKeyType) Enum.valueOf(PemKeyType.class, str);
    }

    public static PemKeyType[] values() {
        return (PemKeyType[]) $VALUES.clone();
    }

    static {
        Enums.HashType hashType = Enums.HashType.SHA256;
        RSA_PSS_2048_SHA256 = new PemKeyType("RSA_PSS_2048_SHA256", 0, "RSA", "RSASSA-PSS", 2048, hashType);
        RSA_PSS_3072_SHA256 = new PemKeyType("RSA_PSS_3072_SHA256", 1, "RSA", "RSASSA-PSS", 3072, hashType);
        RSA_PSS_4096_SHA256 = new PemKeyType("RSA_PSS_4096_SHA256", 2, "RSA", "RSASSA-PSS", 4096, hashType);
        Enums.HashType hashType2 = Enums.HashType.SHA512;
        RSA_PSS_4096_SHA512 = new PemKeyType("RSA_PSS_4096_SHA512", 3, "RSA", "RSASSA-PSS", 4096, hashType2);
        RSA_SIGN_PKCS1_2048_SHA256 = new PemKeyType("RSA_SIGN_PKCS1_2048_SHA256", 4, "RSA", "RSASSA-PKCS1-v1_5", 2048, hashType);
        RSA_SIGN_PKCS1_3072_SHA256 = new PemKeyType("RSA_SIGN_PKCS1_3072_SHA256", 5, "RSA", "RSASSA-PKCS1-v1_5", 3072, hashType);
        RSA_SIGN_PKCS1_4096_SHA256 = new PemKeyType("RSA_SIGN_PKCS1_4096_SHA256", 6, "RSA", "RSASSA-PKCS1-v1_5", 4096, hashType);
        RSA_SIGN_PKCS1_4096_SHA512 = new PemKeyType("RSA_SIGN_PKCS1_4096_SHA512", 7, "RSA", "RSASSA-PKCS1-v1_5", 4096, hashType2);
        ECDSA_P256_SHA256 = new PemKeyType("ECDSA_P256_SHA256", 8, "EC", "ECDSA", 256, hashType);
        ECDSA_P384_SHA384 = new PemKeyType("ECDSA_P384_SHA384", 9, "EC", "ECDSA", BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, Enums.HashType.SHA384);
        ECDSA_P521_SHA512 = new PemKeyType("ECDSA_P521_SHA512", 10, "EC", "ECDSA", 521, hashType2);
        ED25519 = new PemKeyType("ED25519", 11, "EdDSA", "EdDSA", 256);
        ML_DSA_65 = new PemKeyType("ML_DSA_65", 12, "ML-DSA", "ML-DSA", 15616);
        ML_DSA_87 = new PemKeyType("ML_DSA_87", 13, "ML-DSA", "ML-DSA", 20736);
        $VALUES = $values();
    }

    private PemKeyType(String str, int i, String str2, String str3, int i2, Enums.HashType hashType) {
        super(str, i);
        this.keyType = str2;
        this.algorithm = str3;
        this.keySizeInBits = i2;
        this.hash = hashType;
    }

    private PemKeyType(String str, int i, String str2, String str3, int i2) {
        this(str, i, str2, str3, i2, null);
    }

    @Nullable
    public java.security.Key readKey(BufferedReader bufferedReader) throws IOException {
        if (this.keyType.equals("ML-DSA") || this.keyType.equals("EdDSA")) {
            throw new UnsupportedOperationException("readKey is not supported for ML-DSA and EdDSA.");
        }
        EncodedKeySpec pemToKeySpec = PemUtil.parsePemToKeySpec(bufferedReader);
        if (pemToKeySpec == null) {
            return null;
        }
        try {
            if (pemToKeySpec instanceof X509EncodedKeySpec) {
                return getPublicKey(pemToKeySpec.getEncoded());
            }
            if (pemToKeySpec instanceof PKCS8EncodedKeySpec) {
                return getPrivateKey(pemToKeySpec.getEncoded());
            }
            return null;
        } catch (IllegalArgumentException | GeneralSecurityException unused) {
        }
    }

    private java.security.Key getPublicKey(byte[] bArr) throws GeneralSecurityException {
        return validate(EngineFactory.KEY_FACTORY.getInstance(this.keyType).generatePublic(new X509EncodedKeySpec(bArr)));
    }

    private java.security.Key getPrivateKey(byte[] bArr) throws GeneralSecurityException {
        return validate(EngineFactory.KEY_FACTORY.getInstance(this.keyType).generatePrivate(new PKCS8EncodedKeySpec(bArr)));
    }

    private java.security.Key validate(java.security.Key key) throws GeneralSecurityException {
        if (this.keyType.equals("RSA")) {
            int iBitLength = ((RSAKey) key).getModulus().bitLength();
            int i = this.keySizeInBits;
            if (iBitLength != i) {
                throw new GeneralSecurityException(String.format("invalid RSA key size, want %d got %d", Integer.valueOf(i), Integer.valueOf(iBitLength)));
            }
        } else {
            ECParameterSpec params = ((ECKey) key).getParams();
            if (!EllipticCurves.isNistEcParameterSpec(params)) {
                throw new GeneralSecurityException("unsupport EC spec: " + params.toString());
            }
            int iFieldSizeInBits = EllipticCurves.fieldSizeInBits(params.getCurve());
            int i2 = this.keySizeInBits;
            if (iFieldSizeInBits != i2) {
                throw new GeneralSecurityException(String.format("invalid EC key size, want %d got %d", Integer.valueOf(i2), Integer.valueOf(iFieldSizeInBits)));
            }
        }
        return key;
    }
}
