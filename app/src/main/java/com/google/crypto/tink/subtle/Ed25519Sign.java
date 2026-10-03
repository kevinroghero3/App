package com.google.crypto.tink.subtle;

import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.PublicKeySign;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.Ed25519;
import com.google.crypto.tink.signature.Ed25519Parameters;
import com.google.crypto.tink.signature.Ed25519PrivateKey;
import com.google.crypto.tink.signature.internal.Ed25519SignJce;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class Ed25519Sign implements PublicKeySign {
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS;
    public static final int SECRET_KEY_LEN = 32;
    private final byte[] hashedPrivateKey;
    private final byte[] messageSuffix;
    private final byte[] outputPrefix;
    private final byte[] publicKey;

    public static PublicKeySign create(Ed25519PrivateKey ed25519PrivateKey) throws GeneralSecurityException {
        byte[] bArr;
        if (!FIPS.isCompatible()) {
            throw new GeneralSecurityException("Can not use Ed25519 in FIPS-mode.");
        }
        try {
            return Ed25519SignJce.create(ed25519PrivateKey);
        } catch (GeneralSecurityException unused) {
            byte[] byteArray = ed25519PrivateKey.getPrivateKeyBytes().toByteArray(InsecureSecretKeyAccess.get());
            byte[] byteArray2 = ed25519PrivateKey.getOutputPrefix().toByteArray();
            if (ed25519PrivateKey.getParameters().getVariant().equals(Ed25519Parameters.Variant.LEGACY)) {
                bArr = new byte[]{0};
            } else {
                bArr = new byte[0];
            }
            return new Ed25519Sign(byteArray, byteArray2, bArr);
        }
    }

    private Ed25519Sign(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        if (!FIPS.isCompatible()) {
            throw new GeneralSecurityException("Can not use Ed25519 in FIPS-mode.");
        }
        if (bArr.length != 32) {
            throw new IllegalArgumentException(String.format("Given private key's length is not %s", 32));
        }
        byte[] hashedScalar = Ed25519.getHashedScalar(bArr);
        this.hashedPrivateKey = hashedScalar;
        this.publicKey = Ed25519.scalarMultWithBaseToBytes(hashedScalar);
        this.outputPrefix = bArr2;
        this.messageSuffix = bArr3;
    }

    public Ed25519Sign(byte[] bArr) throws GeneralSecurityException {
        this(bArr, new byte[0], new byte[0]);
    }

    private byte[] noPrefixSign(byte[] bArr) throws GeneralSecurityException {
        return Ed25519.sign(bArr, this.publicKey, this.hashedPrivateKey);
    }

    @Override // com.google.crypto.tink.PublicKeySign
    public byte[] sign(byte[] bArr) throws GeneralSecurityException {
        byte[] bArrNoPrefixSign;
        byte[] bArr2 = this.messageSuffix;
        if (bArr2.length == 0) {
            bArrNoPrefixSign = noPrefixSign(bArr);
        } else {
            bArrNoPrefixSign = noPrefixSign(Bytes.concat(bArr, bArr2));
        }
        byte[] bArr3 = this.outputPrefix;
        return bArr3.length == 0 ? bArrNoPrefixSign : Bytes.concat(bArr3, bArrNoPrefixSign);
    }

    /* JADX INFO: loaded from: classes5.dex */
    public static final class KeyPair {
        private final byte[] privateKey;
        private final byte[] publicKey;

        private KeyPair(byte[] bArr, byte[] bArr2) {
            this.publicKey = bArr;
            this.privateKey = bArr2;
        }

        public byte[] getPublicKey() {
            byte[] bArr = this.publicKey;
            return Arrays.copyOf(bArr, bArr.length);
        }

        public byte[] getPrivateKey() {
            byte[] bArr = this.privateKey;
            return Arrays.copyOf(bArr, bArr.length);
        }

        public static KeyPair newKeyPair() throws GeneralSecurityException {
            return newKeyPairFromSeed(Random.randBytes(32));
        }

        public static KeyPair newKeyPairFromSeed(byte[] bArr) throws GeneralSecurityException {
            if (bArr.length != 32) {
                throw new IllegalArgumentException(String.format("Given secret seed length is not %s", 32));
            }
            return new KeyPair(Ed25519.scalarMultWithBaseToBytes(Ed25519.getHashedScalar(bArr)), bArr);
        }
    }
}
