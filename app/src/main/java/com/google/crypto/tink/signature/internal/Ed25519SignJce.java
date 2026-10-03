package com.google.crypto.tink.signature.internal;

import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.PublicKeySign;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.ConscryptUtil;
import com.google.crypto.tink.signature.Ed25519Parameters;
import com.google.crypto.tink.signature.Ed25519PrivateKey;
import com.google.crypto.tink.subtle.Bytes;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;

/* JADX INFO: loaded from: classes3.dex */
@Immutable
public final class Ed25519SignJce implements PublicKeySign {
    private static final String ALGORITHM_NAME = "Ed25519";
    public static final int SECRET_KEY_LEN = 32;
    public static final int SIGNATURE_LEN = 64;
    private final byte[] messageSuffix;
    private final byte[] outputPrefix;
    private final PrivateKey privateKey;
    private final Provider provider;
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS;
    private static final byte[] ed25519Pkcs8Prefix = {48, 46, 2, 1, 0, 48, 5, 6, 3, 43, 101, 112, 4, 34, 4, 32};

    static byte[] pkcs8EncodePrivateKey(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length != 32) {
            throw new IllegalArgumentException(String.format("Given private key's length is not %s", 32));
        }
        return Bytes.concat(ed25519Pkcs8Prefix, bArr);
    }

    static Provider conscryptProvider() throws GeneralSecurityException {
        Provider providerProviderOrNull = ConscryptUtil.providerOrNull();
        if (providerProviderOrNull != null) {
            return providerProviderOrNull;
        }
        throw new NoSuchProviderException("Ed25519SignJce requires the Conscrypt provider.");
    }

    public static PublicKeySign create(Ed25519PrivateKey ed25519PrivateKey) throws GeneralSecurityException {
        return createWithProvider(ed25519PrivateKey, conscryptProvider());
    }

    public static PublicKeySign createWithProvider(Ed25519PrivateKey ed25519PrivateKey, Provider provider) throws GeneralSecurityException {
        byte[] bArr;
        byte[] byteArray = ed25519PrivateKey.getPrivateKeyBytes().toByteArray(InsecureSecretKeyAccess.get());
        byte[] byteArray2 = ed25519PrivateKey.getOutputPrefix().toByteArray();
        if (ed25519PrivateKey.getParameters().getVariant().equals(Ed25519Parameters.Variant.LEGACY)) {
            bArr = new byte[]{0};
        } else {
            bArr = new byte[0];
        }
        return new Ed25519SignJce(byteArray, byteArray2, bArr, provider);
    }

    private Ed25519SignJce(byte[] bArr, byte[] bArr2, byte[] bArr3, Provider provider) throws GeneralSecurityException {
        if (!FIPS.isCompatible()) {
            throw new GeneralSecurityException("Can not use Ed25519 in FIPS-mode.");
        }
        this.outputPrefix = bArr2;
        this.messageSuffix = bArr3;
        this.provider = provider;
        this.privateKey = KeyFactory.getInstance(ALGORITHM_NAME, provider).generatePrivate(new PKCS8EncodedKeySpec(pkcs8EncodePrivateKey(bArr)));
    }

    public Ed25519SignJce(byte[] bArr) throws GeneralSecurityException {
        this(bArr, new byte[0], new byte[0], conscryptProvider());
    }

    public static boolean isSupported() {
        Provider providerProviderOrNull = ConscryptUtil.providerOrNull();
        if (providerProviderOrNull == null) {
            return false;
        }
        try {
            KeyFactory.getInstance(ALGORITHM_NAME, providerProviderOrNull);
            Signature.getInstance(ALGORITHM_NAME, providerProviderOrNull);
            return true;
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }

    @Override // com.google.crypto.tink.PublicKeySign
    public byte[] sign(byte[] bArr) throws GeneralSecurityException {
        Signature signature = Signature.getInstance(ALGORITHM_NAME, this.provider);
        signature.initSign(this.privateKey);
        signature.update(bArr);
        signature.update(this.messageSuffix);
        byte[] bArrSign = signature.sign();
        byte[] bArr2 = this.outputPrefix;
        return bArr2.length == 0 ? bArrSign : Bytes.concat(bArr2, bArrSign);
    }
}
