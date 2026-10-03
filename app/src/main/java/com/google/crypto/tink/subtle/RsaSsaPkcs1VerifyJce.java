package com.google.crypto.tink.subtle;

import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.EnumTypeProtoConverter;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.signature.RsaSsaPkcs1Parameters;
import com.google.crypto.tink.signature.RsaSsaPkcs1PublicKey;
import com.google.crypto.tink.signature.internal.RsaSsaPkcs1VerifyConscrypt;
import com.google.errorprone.annotations.Immutable;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchProviderException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
@Immutable
public final class RsaSsaPkcs1VerifyJce implements PublicKeyVerify {
    private final PublicKeyVerify verify;
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
    private static final byte[] EMPTY = new byte[0];
    private static final byte[] legacyMessageSuffix = {0};
    static final EnumTypeProtoConverter<Enums.HashType, RsaSsaPkcs1Parameters.HashType> HASH_TYPE_CONVERTER = EnumTypeProtoConverter.builder().add(Enums.HashType.SHA256, RsaSsaPkcs1Parameters.HashType.SHA256).add(Enums.HashType.SHA384, RsaSsaPkcs1Parameters.HashType.SHA384).add(Enums.HashType.SHA512, RsaSsaPkcs1Parameters.HashType.SHA512).build();

    static final class InternalJavaImpl implements PublicKeyVerify {
        private static final String ASN_PREFIX_SHA256 = "3031300d060960864801650304020105000420";
        private static final String ASN_PREFIX_SHA384 = "3041300d060960864801650304020205000430";
        private static final String ASN_PREFIX_SHA512 = "3051300d060960864801650304020305000440";
        private final Enums.HashType hash;
        private final byte[] messageSuffix;
        private final byte[] outputPrefix;
        private final RSAPublicKey publicKey;

        /* synthetic */ InternalJavaImpl(RSAPublicKey rSAPublicKey, Enums.HashType hashType, byte[] bArr, byte[] bArr2, AnonymousClass1 anonymousClass1) throws GeneralSecurityException {
            this(rSAPublicKey, hashType, bArr, bArr2);
        }

        private InternalJavaImpl(RSAPublicKey rSAPublicKey, Enums.HashType hashType, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            if (TinkFipsUtil.useOnlyFips()) {
                throw new GeneralSecurityException("Conscrypt is not available, and we cannot use Java Implementation of RSA-PKCS1.5 in FIPS-mode.");
            }
            Validators.validateSignatureHash(hashType);
            Validators.validateRsaModulusSize(rSAPublicKey.getModulus().bitLength());
            Validators.validateRsaPublicExponent(rSAPublicKey.getPublicExponent());
            this.publicKey = rSAPublicKey;
            this.hash = hashType;
            this.outputPrefix = bArr;
            this.messageSuffix = bArr2;
        }

        private void noPrefixVerify(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            BigInteger publicExponent = this.publicKey.getPublicExponent();
            BigInteger modulus = this.publicKey.getModulus();
            int iBitLength = (modulus.bitLength() + 7) / 8;
            if (iBitLength != bArr.length) {
                throw new GeneralSecurityException("invalid signature's length");
            }
            BigInteger bigIntegerBytes2Integer = SubtleUtil.bytes2Integer(bArr);
            if (bigIntegerBytes2Integer.compareTo(modulus) >= 0) {
                throw new GeneralSecurityException("signature out of range");
            }
            if (!Bytes.equal(SubtleUtil.integer2Bytes(bigIntegerBytes2Integer.modPow(publicExponent, modulus), iBitLength), emsaPkcs1(bArr2, iBitLength, this.hash))) {
                throw new GeneralSecurityException("invalid signature");
            }
        }

        private byte[] emsaPkcs1(byte[] bArr, int i, Enums.HashType hashType) throws GeneralSecurityException {
            Validators.validateSignatureHash(hashType);
            MessageDigest engineFactory = EngineFactory.MESSAGE_DIGEST.getInstance(SubtleUtil.toDigestAlgo(this.hash));
            engineFactory.update(bArr);
            byte[] bArr2 = this.messageSuffix;
            if (bArr2.length != 0) {
                engineFactory.update(bArr2);
            }
            byte[] bArrDigest = engineFactory.digest();
            byte[] asnPrefix = toAsnPrefix(hashType);
            int length = asnPrefix.length + bArrDigest.length;
            if (i < length + 11) {
                throw new GeneralSecurityException("intended encoded message length too short");
            }
            byte[] bArr3 = new byte[i];
            bArr3[0] = 0;
            bArr3[1] = 1;
            int i2 = 2;
            int i3 = 0;
            while (i3 < (i - length) - 3) {
                bArr3[i2] = -1;
                i3++;
                i2++;
            }
            int i4 = i2 + 1;
            bArr3[i2] = 0;
            System.arraycopy(asnPrefix, 0, bArr3, i4, asnPrefix.length);
            System.arraycopy(bArrDigest, 0, bArr3, i4 + asnPrefix.length, bArrDigest.length);
            return bArr3;
        }

        private byte[] toAsnPrefix(Enums.HashType hashType) throws GeneralSecurityException {
            int i = AnonymousClass1.$SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[hashType.ordinal()];
            if (i == 1) {
                return Hex.decode(ASN_PREFIX_SHA256);
            }
            if (i == 2) {
                return Hex.decode(ASN_PREFIX_SHA384);
            }
            if (i == 3) {
                return Hex.decode(ASN_PREFIX_SHA512);
            }
            throw new GeneralSecurityException("Unsupported hash " + hashType);
        }

        @Override // com.google.crypto.tink.PublicKeyVerify
        public void verify(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            byte[] bArr3 = this.outputPrefix;
            if (bArr3.length == 0) {
                noPrefixVerify(bArr, bArr2);
            } else {
                if (!Util.isPrefix(bArr3, bArr)) {
                    throw new GeneralSecurityException("Invalid signature (output prefix mismatch)");
                }
                noPrefixVerify(Arrays.copyOfRange(bArr, this.outputPrefix.length, bArr.length), bArr2);
            }
        }
    }

    /* JADX INFO: renamed from: com.google.crypto.tink.subtle.RsaSsaPkcs1VerifyJce$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType;

        static {
            int[] iArr = new int[Enums.HashType.values().length];
            $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType = iArr;
            try {
                iArr[Enums.HashType.SHA256.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[Enums.HashType.SHA384.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[Enums.HashType.SHA512.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static PublicKeyVerify create(RsaSsaPkcs1PublicKey rsaSsaPkcs1PublicKey) throws GeneralSecurityException {
        byte[] bArr;
        try {
            return RsaSsaPkcs1VerifyConscrypt.create(rsaSsaPkcs1PublicKey);
        } catch (NoSuchProviderException unused) {
            RSAPublicKey rSAPublicKey = (RSAPublicKey) EngineFactory.KEY_FACTORY.getInstance("RSA").generatePublic(new RSAPublicKeySpec(rsaSsaPkcs1PublicKey.getModulus(), rsaSsaPkcs1PublicKey.getParameters().getPublicExponent()));
            Enums.HashType hashType = (Enums.HashType) HASH_TYPE_CONVERTER.toProtoEnum(rsaSsaPkcs1PublicKey.getParameters().getHashType());
            byte[] byteArray = rsaSsaPkcs1PublicKey.getOutputPrefix().toByteArray();
            if (rsaSsaPkcs1PublicKey.getParameters().getVariant().equals(RsaSsaPkcs1Parameters.Variant.LEGACY)) {
                bArr = legacyMessageSuffix;
            } else {
                bArr = EMPTY;
            }
            return new InternalJavaImpl(rSAPublicKey, hashType, byteArray, bArr, null);
        }
    }

    private static RsaSsaPkcs1Parameters.HashType getHashType(Enums.HashType hashType) throws GeneralSecurityException {
        int i = AnonymousClass1.$SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[hashType.ordinal()];
        if (i == 1) {
            return RsaSsaPkcs1Parameters.HashType.SHA256;
        }
        if (i == 2) {
            return RsaSsaPkcs1Parameters.HashType.SHA384;
        }
        if (i == 3) {
            return RsaSsaPkcs1Parameters.HashType.SHA512;
        }
        throw new GeneralSecurityException("Unsupported hash: " + hashType);
    }

    private RsaSsaPkcs1PublicKey convertKey(RSAPublicKey rSAPublicKey, Enums.HashType hashType) throws GeneralSecurityException {
        return RsaSsaPkcs1PublicKey.builder().setParameters(RsaSsaPkcs1Parameters.builder().setModulusSizeBits(rSAPublicKey.getModulus().bitLength()).setPublicExponent(rSAPublicKey.getPublicExponent()).setHashType(getHashType(hashType)).setVariant(RsaSsaPkcs1Parameters.Variant.NO_PREFIX).build()).setModulus(rSAPublicKey.getModulus()).build();
    }

    public RsaSsaPkcs1VerifyJce(RSAPublicKey rSAPublicKey, Enums.HashType hashType) throws GeneralSecurityException {
        this.verify = create(convertKey(rSAPublicKey, hashType));
    }

    @Override // com.google.crypto.tink.PublicKeyVerify
    public void verify(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        this.verify.verify(bArr, bArr2);
    }
}
