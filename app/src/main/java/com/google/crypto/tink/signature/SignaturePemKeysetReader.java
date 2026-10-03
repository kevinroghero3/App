package com.google.crypto.tink.signature;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.KeysetReader;
import com.google.crypto.tink.PemKeyType;
import com.google.crypto.tink.TinkProtoKeysetFormat;
import com.google.crypto.tink.internal.PemUtil;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.proto.EncryptedKeyset;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.subtle.EllipticCurves;
import com.google.crypto.tink.subtle.EngineFactory;
import com.google.crypto.tink.subtle.Hex;
import com.google.crypto.tink.util.Bytes;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.security.GeneralSecurityException;
import java.security.interfaces.ECPublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class SignaturePemKeysetReader implements KeysetReader {
    private static final MlDsaParameters ML_DSA_65_PARAMS;
    private static final MlDsaParameters ML_DSA_87_PARAMS;
    private static final byte[] x509PreambleEd25519 = Hex.decode("302a300506032b6570032100");
    private static final byte[] x509PreambleMlDsa65;
    private static final byte[] x509PreambleMlDsa87;

    @Nullable
    private final IOException exception;

    @Nullable
    private final Keyset keyset;

    /* synthetic */ SignaturePemKeysetReader(Keyset keyset, IOException iOException, AnonymousClass1 anonymousClass1) {
        this(keyset, iOException);
    }

    private SignaturePemKeysetReader(Keyset keyset, IOException iOException) {
        if (keyset == null && iOException == null) {
            throw new IllegalArgumentException("Exactly one of keyset and exception must be non-null.");
        }
        if (keyset != null && iOException != null) {
            throw new IllegalArgumentException("Exactly one of keyset and exception must be non-null.");
        }
        this.keyset = keyset;
        this.exception = iOException;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private List<PemKey> pemKeys = new ArrayList();
        private GeneralSecurityException firstException = null;

        Builder() {
        }

        @Nullable
        private Key readKey(BufferedReader bufferedReader, PemKeyType pemKeyType) {
            try {
                return SignaturePemKeysetReader.readKeyWithExceptions(bufferedReader, pemKeyType);
            } catch (GeneralSecurityException e) {
                if (this.firstException != null) {
                    return null;
                }
                this.firstException = e;
                return null;
            }
        }

        public KeysetHandle buildPublicKeysetHandle() throws GeneralSecurityException {
            KeysetHandle.Builder builderNewBuilder = KeysetHandle.newBuilder();
            for (PemKey pemKey : this.pemKeys) {
                BufferedReader bufferedReader = new BufferedReader(new StringReader(pemKey.pem));
                Key key = readKey(bufferedReader, pemKey.type);
                while (key != null) {
                    builderNewBuilder.addEntry(KeysetHandle.importKey(key).withRandomId());
                    key = readKey(bufferedReader, pemKey.type);
                }
            }
            if (builderNewBuilder.size() == 0) {
                if (this.firstException != null) {
                    throw new GeneralSecurityException("parsing failed for all keys. First exception: " + this.firstException);
                }
                throw new GeneralSecurityException("cannot find any key");
            }
            builderNewBuilder.getAt(0).makePrimary();
            return builderNewBuilder.build();
        }

        @Deprecated
        public KeysetReader build() {
            IOException e;
            IOException iOException;
            Keyset from;
            AnonymousClass1 anonymousClass1 = null;
            try {
                from = Keyset.parseFrom(TinkProtoKeysetFormat.serializeKeysetWithoutSecret(buildPublicKeysetHandle()), ExtensionRegistryLite.getEmptyRegistry());
                iOException = null;
            } catch (IOException e2) {
                e = e2;
                iOException = e;
                from = null;
            } catch (GeneralSecurityException e3) {
                e = new IOException(e3);
                iOException = e;
                from = null;
            }
            return new SignaturePemKeysetReader(from, iOException, anonymousClass1);
        }

        public Builder addPem(String str, PemKeyType pemKeyType) {
            PemKey pemKey = new PemKey(null);
            pemKey.pem = str;
            pemKey.type = pemKeyType;
            this.pemKeys.add(pemKey);
            return this;
        }
    }

    static final class PemKey {
        String pem;
        PemKeyType type;

        private PemKey() {
        }

        /* synthetic */ PemKey(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    @Override // com.google.crypto.tink.KeysetReader
    public Keyset read() throws IOException {
        IOException iOException = this.exception;
        if (iOException != null) {
            throw iOException;
        }
        return this.keyset;
    }

    @Override // com.google.crypto.tink.KeysetReader
    public EncryptedKeyset readEncrypted() throws IOException {
        throw new UnsupportedOperationException();
    }

    private static RSAPublicKey parseRsaPublicKey(X509EncodedKeySpec x509EncodedKeySpec, int i) throws GeneralSecurityException {
        RSAPublicKey rSAPublicKey = (RSAPublicKey) EngineFactory.KEY_FACTORY.getInstance("RSA").generatePublic(x509EncodedKeySpec);
        if (rSAPublicKey.getModulus().bitLength() == i) {
            return rSAPublicKey;
        }
        throw new GeneralSecurityException("wrong key size");
    }

    private static ECPublicKey parseEcPublicKey(X509EncodedKeySpec x509EncodedKeySpec, int i) throws GeneralSecurityException {
        ECPublicKey eCPublicKey = (ECPublicKey) EngineFactory.KEY_FACTORY.getInstance("EC").generatePublic(x509EncodedKeySpec);
        ECParameterSpec params = eCPublicKey.getParams();
        if (!EllipticCurves.isNistEcParameterSpec(params)) {
            throw new GeneralSecurityException("EC key is not a NIST curve");
        }
        int iFieldSizeInBits = EllipticCurves.fieldSizeInBits(params.getCurve());
        if (iFieldSizeInBits == i) {
            return eCPublicKey;
        }
        throw new GeneralSecurityException(String.format("wrong NIST curve: found curve with %d bits, expected %d bits", Integer.valueOf(iFieldSizeInBits), Integer.valueOf(i)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Key readKeyWithExceptions(BufferedReader bufferedReader, PemKeyType pemKeyType) throws GeneralSecurityException {
        EncodedKeySpec pemToKeySpec = PemUtil.parsePemToKeySpec(bufferedReader);
        if (pemToKeySpec == null) {
            throw new GeneralSecurityException("cannot parse PEM key");
        }
        if (!(pemToKeySpec instanceof X509EncodedKeySpec)) {
            throw new GeneralSecurityException("PEM key is not a public key");
        }
        X509EncodedKeySpec x509EncodedKeySpec = (X509EncodedKeySpec) pemToKeySpec;
        switch (AnonymousClass1.$SwitchMap$com$google$crypto$tink$PemKeyType[pemKeyType.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                return convertRsaSsaPkcs1PublicKey(pemKeyType, x509EncodedKeySpec);
            case 5:
            case 6:
            case 7:
            case 8:
                return convertRsaSsaPssPublicKey(pemKeyType, x509EncodedKeySpec);
            case 9:
            case 10:
            case 11:
                return convertEcdsaPublicKey(pemKeyType, x509EncodedKeySpec);
            case 12:
                return convertEd25519PublicKey(x509EncodedKeySpec);
            case 13:
                return convertMlDsa65PublicKey(x509EncodedKeySpec);
            case 14:
                return convertMlDsa87PublicKey(x509EncodedKeySpec);
            default:
                throw new IllegalArgumentException("unsupported key type: " + pemKeyType);
        }
    }

    /* JADX INFO: renamed from: com.google.crypto.tink.signature.SignaturePemKeysetReader$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$PemKeyType;

        static {
            int[] iArr = new int[PemKeyType.values().length];
            $SwitchMap$com$google$crypto$tink$PemKeyType = iArr;
            try {
                iArr[PemKeyType.RSA_SIGN_PKCS1_2048_SHA256.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$PemKeyType[PemKeyType.RSA_SIGN_PKCS1_3072_SHA256.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$PemKeyType[PemKeyType.RSA_SIGN_PKCS1_4096_SHA256.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$PemKeyType[PemKeyType.RSA_SIGN_PKCS1_4096_SHA512.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$PemKeyType[PemKeyType.RSA_PSS_2048_SHA256.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$PemKeyType[PemKeyType.RSA_PSS_3072_SHA256.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$PemKeyType[PemKeyType.RSA_PSS_4096_SHA256.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$PemKeyType[PemKeyType.RSA_PSS_4096_SHA512.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$PemKeyType[PemKeyType.ECDSA_P256_SHA256.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$PemKeyType[PemKeyType.ECDSA_P384_SHA384.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$PemKeyType[PemKeyType.ECDSA_P521_SHA512.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$PemKeyType[PemKeyType.ED25519.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$PemKeyType[PemKeyType.ML_DSA_65.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$PemKeyType[PemKeyType.ML_DSA_87.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    private static RsaSsaPkcs1Parameters getRsaPkcs1Parameters(PemKeyType pemKeyType) throws GeneralSecurityException {
        int i = AnonymousClass1.$SwitchMap$com$google$crypto$tink$PemKeyType[pemKeyType.ordinal()];
        if (i == 1) {
            return RsaSsaPkcs1Parameters.builder().setModulusSizeBits(2048).setPublicExponent(RsaSsaPkcs1Parameters.F4).setHashType(RsaSsaPkcs1Parameters.HashType.SHA256).setVariant(RsaSsaPkcs1Parameters.Variant.NO_PREFIX).build();
        }
        if (i == 2) {
            return RsaSsaPkcs1Parameters.builder().setModulusSizeBits(3072).setPublicExponent(RsaSsaPkcs1Parameters.F4).setHashType(RsaSsaPkcs1Parameters.HashType.SHA256).setVariant(RsaSsaPkcs1Parameters.Variant.NO_PREFIX).build();
        }
        if (i == 3) {
            return RsaSsaPkcs1Parameters.builder().setModulusSizeBits(4096).setPublicExponent(RsaSsaPkcs1Parameters.F4).setHashType(RsaSsaPkcs1Parameters.HashType.SHA256).setVariant(RsaSsaPkcs1Parameters.Variant.NO_PREFIX).build();
        }
        if (i == 4) {
            return RsaSsaPkcs1Parameters.builder().setModulusSizeBits(4096).setPublicExponent(RsaSsaPkcs1Parameters.F4).setHashType(RsaSsaPkcs1Parameters.HashType.SHA512).setVariant(RsaSsaPkcs1Parameters.Variant.NO_PREFIX).build();
        }
        throw new IllegalArgumentException("unsupported RSA PKCS1 key type: " + pemKeyType);
    }

    private static Key convertRsaSsaPkcs1PublicKey(PemKeyType pemKeyType, X509EncodedKeySpec x509EncodedKeySpec) throws GeneralSecurityException {
        return RsaSsaPkcs1PublicKey.builder().setParameters(getRsaPkcs1Parameters(pemKeyType)).setModulus(parseRsaPublicKey(x509EncodedKeySpec, pemKeyType.keySizeInBits).getModulus()).build();
    }

    private static RsaSsaPssParameters getRsaPssParameters(PemKeyType pemKeyType) throws GeneralSecurityException {
        int i = AnonymousClass1.$SwitchMap$com$google$crypto$tink$PemKeyType[pemKeyType.ordinal()];
        if (i == 5) {
            RsaSsaPssParameters.Builder publicExponent = RsaSsaPssParameters.builder().setModulusSizeBits(2048).setPublicExponent(RsaSsaPssParameters.F4);
            RsaSsaPssParameters.HashType hashType = RsaSsaPssParameters.HashType.SHA256;
            return publicExponent.setSigHashType(hashType).setMgf1HashType(hashType).setVariant(RsaSsaPssParameters.Variant.NO_PREFIX).setSaltLengthBytes(32).build();
        }
        if (i == 6) {
            RsaSsaPssParameters.Builder publicExponent2 = RsaSsaPssParameters.builder().setModulusSizeBits(3072).setPublicExponent(RsaSsaPssParameters.F4);
            RsaSsaPssParameters.HashType hashType2 = RsaSsaPssParameters.HashType.SHA256;
            return publicExponent2.setSigHashType(hashType2).setMgf1HashType(hashType2).setVariant(RsaSsaPssParameters.Variant.NO_PREFIX).setSaltLengthBytes(32).build();
        }
        if (i == 7) {
            RsaSsaPssParameters.Builder publicExponent3 = RsaSsaPssParameters.builder().setModulusSizeBits(4096).setPublicExponent(RsaSsaPssParameters.F4);
            RsaSsaPssParameters.HashType hashType3 = RsaSsaPssParameters.HashType.SHA256;
            return publicExponent3.setSigHashType(hashType3).setMgf1HashType(hashType3).setVariant(RsaSsaPssParameters.Variant.NO_PREFIX).setSaltLengthBytes(32).build();
        }
        if (i == 8) {
            RsaSsaPssParameters.Builder publicExponent4 = RsaSsaPssParameters.builder().setModulusSizeBits(4096).setPublicExponent(RsaSsaPssParameters.F4);
            RsaSsaPssParameters.HashType hashType4 = RsaSsaPssParameters.HashType.SHA512;
            return publicExponent4.setSigHashType(hashType4).setMgf1HashType(hashType4).setVariant(RsaSsaPssParameters.Variant.NO_PREFIX).setSaltLengthBytes(64).build();
        }
        throw new IllegalArgumentException("unsupported RSA PSS key type: " + pemKeyType);
    }

    private static Key convertRsaSsaPssPublicKey(PemKeyType pemKeyType, X509EncodedKeySpec x509EncodedKeySpec) throws GeneralSecurityException {
        return RsaSsaPssPublicKey.builder().setParameters(getRsaPssParameters(pemKeyType)).setModulus(parseRsaPublicKey(x509EncodedKeySpec, pemKeyType.keySizeInBits).getModulus()).build();
    }

    private static EcdsaParameters getEcdsaParameters(PemKeyType pemKeyType) throws GeneralSecurityException {
        switch (AnonymousClass1.$SwitchMap$com$google$crypto$tink$PemKeyType[pemKeyType.ordinal()]) {
            case 9:
                return EcdsaParameters.builder().setSignatureEncoding(EcdsaParameters.SignatureEncoding.DER).setCurveType(EcdsaParameters.CurveType.NIST_P256).setHashType(EcdsaParameters.HashType.SHA256).setVariant(EcdsaParameters.Variant.NO_PREFIX).build();
            case 10:
                return EcdsaParameters.builder().setSignatureEncoding(EcdsaParameters.SignatureEncoding.DER).setCurveType(EcdsaParameters.CurveType.NIST_P384).setHashType(EcdsaParameters.HashType.SHA384).setVariant(EcdsaParameters.Variant.NO_PREFIX).build();
            case 11:
                return EcdsaParameters.builder().setSignatureEncoding(EcdsaParameters.SignatureEncoding.DER).setCurveType(EcdsaParameters.CurveType.NIST_P521).setHashType(EcdsaParameters.HashType.SHA512).build();
            default:
                throw new IllegalArgumentException("unsupported EC key type: " + pemKeyType);
        }
    }

    private static Key convertEcdsaPublicKey(PemKeyType pemKeyType, X509EncodedKeySpec x509EncodedKeySpec) throws GeneralSecurityException {
        return EcdsaPublicKey.builder().setParameters(getEcdsaParameters(pemKeyType)).setPublicPoint(parseEcPublicKey(x509EncodedKeySpec, pemKeyType.keySizeInBits).getW()).build();
    }

    static {
        MlDsaParameters.MlDsaInstance mlDsaInstance = MlDsaParameters.MlDsaInstance.ML_DSA_65;
        MlDsaParameters.Variant variant = MlDsaParameters.Variant.NO_PREFIX;
        ML_DSA_65_PARAMS = MlDsaParameters.create(mlDsaInstance, variant);
        x509PreambleMlDsa65 = Hex.decode("308207b2300b0609608648016503040312038207a100");
        ML_DSA_87_PARAMS = MlDsaParameters.create(MlDsaParameters.MlDsaInstance.ML_DSA_87, variant);
        x509PreambleMlDsa87 = Hex.decode("30820a32300b060960864801650304031303820a2100");
    }

    @Nullable
    private static Key convertEd25519PublicKey(X509EncodedKeySpec x509EncodedKeySpec) throws GeneralSecurityException {
        byte[] encoded = x509EncodedKeySpec.getEncoded();
        byte[] bArr = x509PreambleEd25519;
        if (!Util.isPrefix(bArr, encoded)) {
            return null;
        }
        byte[] bArrCopyOfRange = Arrays.copyOfRange(encoded, bArr.length, encoded.length);
        if (bArrCopyOfRange.length != 32) {
            return null;
        }
        return Ed25519PublicKey.create(Bytes.copyFrom(bArrCopyOfRange));
    }

    @Nullable
    static MlDsaPublicKey convertMlDsa65PublicKey(X509EncodedKeySpec x509EncodedKeySpec) throws GeneralSecurityException {
        byte[] encoded = x509EncodedKeySpec.getEncoded();
        byte[] bArr = x509PreambleMlDsa65;
        if (!Util.isPrefix(bArr, encoded)) {
            throw new GeneralSecurityException("is not a ML-DSA-65 public key");
        }
        byte[] bArrCopyOfRange = Arrays.copyOfRange(encoded, bArr.length, encoded.length);
        if (bArrCopyOfRange.length != 1952) {
            throw new GeneralSecurityException("wrong key length");
        }
        return MlDsaPublicKey.builder().setParameters(ML_DSA_65_PARAMS).setSerializedPublicKey(Bytes.copyFrom(bArrCopyOfRange)).build();
    }

    @Nullable
    static MlDsaPublicKey convertMlDsa87PublicKey(X509EncodedKeySpec x509EncodedKeySpec) throws GeneralSecurityException {
        byte[] encoded = x509EncodedKeySpec.getEncoded();
        byte[] bArr = x509PreambleMlDsa87;
        if (!Util.isPrefix(bArr, encoded)) {
            throw new GeneralSecurityException("is not a ML-DSA-87 public key");
        }
        byte[] bArrCopyOfRange = Arrays.copyOfRange(encoded, bArr.length, encoded.length);
        if (bArrCopyOfRange.length != 2592) {
            throw new GeneralSecurityException("wrong key length");
        }
        return MlDsaPublicKey.builder().setParameters(ML_DSA_87_PARAMS).setSerializedPublicKey(Bytes.copyFrom(bArrCopyOfRange)).build();
    }
}
