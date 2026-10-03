package com.google.crypto.tink.subtle;

import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.EnumTypeProtoConverter;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.signature.RsaSsaPssParameters;
import com.google.crypto.tink.signature.RsaSsaPssPublicKey;
import com.google.crypto.tink.signature.internal.RsaSsaPssVerifyConscrypt;
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
public final class RsaSsaPssVerifyJce implements PublicKeyVerify {
    private final PublicKeyVerify verify;
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
    static final EnumTypeProtoConverter<Enums.HashType, RsaSsaPssParameters.HashType> HASH_TYPE_CONVERTER = EnumTypeProtoConverter.builder().add(Enums.HashType.SHA256, RsaSsaPssParameters.HashType.SHA256).add(Enums.HashType.SHA384, RsaSsaPssParameters.HashType.SHA384).add(Enums.HashType.SHA512, RsaSsaPssParameters.HashType.SHA512).build();
    private static final byte[] EMPTY = new byte[0];
    private static final byte[] legacyMessageSuffix = {0};

    static final class InternalImpl implements PublicKeyVerify {
        private final byte[] messageSuffix;
        private final Enums.HashType mgf1Hash;
        private final byte[] outputPrefix;
        private final RSAPublicKey publicKey;
        private final int saltLength;
        private final Enums.HashType sigHash;

        /* synthetic */ InternalImpl(RSAPublicKey rSAPublicKey, Enums.HashType hashType, Enums.HashType hashType2, int i, byte[] bArr, byte[] bArr2, AnonymousClass1 anonymousClass1) throws GeneralSecurityException {
            this(rSAPublicKey, hashType, hashType2, i, bArr, bArr2);
        }

        private InternalImpl(RSAPublicKey rSAPublicKey, Enums.HashType hashType, Enums.HashType hashType2, int i, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            if (TinkFipsUtil.useOnlyFips()) {
                throw new GeneralSecurityException("Can not use RSA PSS in FIPS-mode, as BoringCrypto module is not available.");
            }
            Validators.validateSignatureHash(hashType);
            if (!hashType.equals(hashType2)) {
                throw new GeneralSecurityException("sigHash and mgf1Hash must be the same");
            }
            Validators.validateRsaModulusSize(rSAPublicKey.getModulus().bitLength());
            Validators.validateRsaPublicExponent(rSAPublicKey.getPublicExponent());
            this.publicKey = rSAPublicKey;
            this.sigHash = hashType;
            this.mgf1Hash = hashType2;
            this.saltLength = i;
            this.outputPrefix = bArr;
            this.messageSuffix = bArr2;
        }

        private void noPrefixVerify(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            BigInteger publicExponent = this.publicKey.getPublicExponent();
            BigInteger modulus = this.publicKey.getModulus();
            int iBitLength = (modulus.bitLength() + 7) / 8;
            int iBitLength2 = (modulus.bitLength() + 6) / 8;
            if (iBitLength != bArr.length) {
                throw new GeneralSecurityException("invalid signature's length");
            }
            BigInteger bigIntegerBytes2Integer = SubtleUtil.bytes2Integer(bArr);
            if (bigIntegerBytes2Integer.compareTo(modulus) >= 0) {
                throw new GeneralSecurityException("signature out of range");
            }
            emsaPssVerify(bArr2, SubtleUtil.integer2Bytes(bigIntegerBytes2Integer.modPow(publicExponent, modulus), iBitLength2), modulus.bitLength() - 1);
        }

        private void emsaPssVerify(byte[] bArr, byte[] bArr2, int i) throws GeneralSecurityException {
            Validators.validateSignatureHash(this.sigHash);
            MessageDigest engineFactory = EngineFactory.MESSAGE_DIGEST.getInstance(SubtleUtil.toDigestAlgo(this.sigHash));
            engineFactory.update(bArr);
            byte[] bArr3 = this.messageSuffix;
            if (bArr3.length != 0) {
                engineFactory.update(bArr3);
            }
            byte[] bArrDigest = engineFactory.digest();
            int digestLength = engineFactory.getDigestLength();
            int length = bArr2.length;
            if (length < this.saltLength + digestLength + 2) {
                throw new GeneralSecurityException("inconsistent");
            }
            if (bArr2[bArr2.length - 1] != -68) {
                throw new GeneralSecurityException("inconsistent");
            }
            int i2 = length - digestLength;
            int i3 = i2 - 1;
            byte[] bArrCopyOf = Arrays.copyOf(bArr2, i3);
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr2, bArrCopyOf.length, bArrCopyOf.length + digestLength);
            int i4 = 0;
            while (true) {
                int i5 = i3;
                MessageDigest messageDigest = engineFactory;
                byte[] bArr4 = bArrDigest;
                long j = (((long) length) * 8) - ((long) i);
                if (i4 < j) {
                    if (((bArrCopyOf[i4 / 8] >> (7 - (i4 % 8))) & 1) != 0) {
                        throw new GeneralSecurityException("inconsistent");
                    }
                    i4++;
                    i3 = i5;
                    engineFactory = messageDigest;
                    bArrDigest = bArr4;
                } else {
                    byte[] bArrMgf1 = SubtleUtil.mgf1(bArrCopyOfRange, i5, this.mgf1Hash);
                    int length2 = bArrMgf1.length;
                    byte[] bArr5 = new byte[length2];
                    for (int i6 = 0; i6 < length2; i6++) {
                        bArr5[i6] = (byte) (bArrMgf1[i6] ^ bArrCopyOf[i6]);
                    }
                    for (int i7 = 0; i7 <= j; i7++) {
                        int i8 = i7 / 8;
                        bArr5[i8] = (byte) ((~(1 << (7 - (i7 % 8)))) & bArr5[i8]);
                    }
                    int i9 = 0;
                    while (true) {
                        int i10 = this.saltLength;
                        int i11 = (i2 - i10) - 2;
                        if (i9 < i11) {
                            if (bArr5[i9] != 0) {
                                throw new GeneralSecurityException("inconsistent");
                            }
                            i9++;
                        } else {
                            if (bArr5[i11] != 1) {
                                throw new GeneralSecurityException("inconsistent");
                            }
                            byte[] bArrCopyOfRange2 = Arrays.copyOfRange(bArr5, length2 - i10, length2);
                            int i12 = digestLength + 8;
                            byte[] bArr6 = new byte[this.saltLength + i12];
                            System.arraycopy(bArr4, 0, bArr6, 8, bArr4.length);
                            System.arraycopy(bArrCopyOfRange2, 0, bArr6, i12, bArrCopyOfRange2.length);
                            if (!Bytes.equal(messageDigest.digest(bArr6), bArrCopyOfRange)) {
                                throw new GeneralSecurityException("inconsistent");
                            }
                            return;
                        }
                    }
                }
            }
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

    public static PublicKeyVerify create(RsaSsaPssPublicKey rsaSsaPssPublicKey) throws GeneralSecurityException {
        byte[] bArr;
        try {
            return RsaSsaPssVerifyConscrypt.create(rsaSsaPssPublicKey);
        } catch (NoSuchProviderException unused) {
            RSAPublicKey rSAPublicKey = (RSAPublicKey) EngineFactory.KEY_FACTORY.getInstance("RSA").generatePublic(new RSAPublicKeySpec(rsaSsaPssPublicKey.getModulus(), rsaSsaPssPublicKey.getParameters().getPublicExponent()));
            RsaSsaPssParameters parameters = rsaSsaPssPublicKey.getParameters();
            Enums.HashType hashType = (Enums.HashType) HASH_TYPE_CONVERTER.toProtoEnum(parameters.getSigHashType());
            Enums.HashType hashType2 = (Enums.HashType) HASH_TYPE_CONVERTER.toProtoEnum(parameters.getMgf1HashType());
            int saltLengthBytes = parameters.getSaltLengthBytes();
            byte[] byteArray = rsaSsaPssPublicKey.getOutputPrefix().toByteArray();
            if (rsaSsaPssPublicKey.getParameters().getVariant().equals(RsaSsaPssParameters.Variant.LEGACY)) {
                bArr = legacyMessageSuffix;
            } else {
                bArr = EMPTY;
            }
            return new InternalImpl(rSAPublicKey, hashType, hashType2, saltLengthBytes, byteArray, bArr, null);
        }
    }

    /* JADX INFO: renamed from: com.google.crypto.tink.subtle.RsaSsaPssVerifyJce$1, reason: invalid class name */
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

    private static RsaSsaPssParameters.HashType getHashType(Enums.HashType hashType) throws GeneralSecurityException {
        int i = AnonymousClass1.$SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[hashType.ordinal()];
        if (i == 1) {
            return RsaSsaPssParameters.HashType.SHA256;
        }
        if (i == 2) {
            return RsaSsaPssParameters.HashType.SHA384;
        }
        if (i == 3) {
            return RsaSsaPssParameters.HashType.SHA512;
        }
        throw new GeneralSecurityException("Unsupported hash: " + hashType);
    }

    private RsaSsaPssPublicKey convertKey(RSAPublicKey rSAPublicKey, Enums.HashType hashType, Enums.HashType hashType2, int i) throws GeneralSecurityException {
        return RsaSsaPssPublicKey.builder().setParameters(RsaSsaPssParameters.builder().setModulusSizeBits(rSAPublicKey.getModulus().bitLength()).setPublicExponent(rSAPublicKey.getPublicExponent()).setSigHashType(getHashType(hashType)).setMgf1HashType(getHashType(hashType2)).setSaltLengthBytes(i).setVariant(RsaSsaPssParameters.Variant.NO_PREFIX).build()).setModulus(rSAPublicKey.getModulus()).build();
    }

    public RsaSsaPssVerifyJce(RSAPublicKey rSAPublicKey, Enums.HashType hashType, Enums.HashType hashType2, int i) throws GeneralSecurityException {
        this.verify = create(convertKey(rSAPublicKey, hashType, hashType2, i));
    }

    @Override // com.google.crypto.tink.PublicKeyVerify
    public void verify(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        this.verify.verify(bArr, bArr2);
    }
}
