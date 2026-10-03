package com.google.crypto.tink.signature.internal;

import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.ConscryptUtil;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.signature.Ed25519Parameters;
import com.google.crypto.tink.signature.Ed25519PublicKey;
import com.google.crypto.tink.subtle.Bytes;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

/* JADX INFO: loaded from: classes3.dex */
@Immutable
public final class Ed25519VerifyJce implements PublicKeyVerify {
    private static final String ALGORITHM_NAME = "Ed25519";
    private static final int PUBLIC_KEY_LEN = 32;
    private static final int SIGNATURE_LEN = 64;
    private final byte[] messageSuffix;
    private final byte[] outputPrefix;
    private final Provider provider;
    private final PublicKey publicKey;
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS;
    private static final byte[] ed25519X509Prefix = {48, 42, 48, 5, 6, 3, 43, 101, 112, 3, 33, 0};

    static byte[] x509EncodePublicKey(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length != 32) {
            throw new IllegalArgumentException(String.format("Given public key's length is not %s.", 32));
        }
        return Bytes.concat(ed25519X509Prefix, bArr);
    }

    static Provider conscryptProvider() throws GeneralSecurityException {
        Provider providerProviderOrNull = ConscryptUtil.providerOrNull();
        if (providerProviderOrNull != null) {
            return providerProviderOrNull;
        }
        throw new NoSuchProviderException("Ed25519VerifyJce requires the Conscrypt provider.");
    }

    public static PublicKeyVerify create(Ed25519PublicKey ed25519PublicKey) throws GeneralSecurityException {
        return createWithProvider(ed25519PublicKey, conscryptProvider());
    }

    public static PublicKeyVerify createWithProvider(Ed25519PublicKey ed25519PublicKey, Provider provider) throws GeneralSecurityException {
        byte[] bArr;
        if (!FIPS.isCompatible()) {
            throw new GeneralSecurityException("Can not use Ed25519 in FIPS-mode.");
        }
        byte[] byteArray = ed25519PublicKey.getPublicKeyBytes().toByteArray();
        byte[] byteArray2 = ed25519PublicKey.getOutputPrefix().toByteArray();
        if (ed25519PublicKey.getParameters().getVariant().equals(Ed25519Parameters.Variant.LEGACY)) {
            bArr = new byte[]{0};
        } else {
            bArr = new byte[0];
        }
        return new Ed25519VerifyJce(byteArray, byteArray2, bArr, provider);
    }

    Ed25519VerifyJce(byte[] bArr) throws GeneralSecurityException {
        this(bArr, new byte[0], new byte[0], conscryptProvider());
    }

    private Ed25519VerifyJce(byte[] bArr, byte[] bArr2, byte[] bArr3, Provider provider) throws GeneralSecurityException {
        if (!FIPS.isCompatible()) {
            throw new GeneralSecurityException("Can not use Ed25519 in FIPS-mode.");
        }
        this.publicKey = KeyFactory.getInstance(ALGORITHM_NAME, provider).generatePublic(new X509EncodedKeySpec(x509EncodePublicKey(bArr)));
        this.outputPrefix = bArr2;
        this.messageSuffix = bArr3;
        this.provider = provider;
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

    @Override // com.google.crypto.tink.PublicKeyVerify
    public void verify(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        byte[] bArr3 = this.outputPrefix;
        if (length != bArr3.length + 64) {
            throw new GeneralSecurityException(String.format("Invalid signature length: %s", 64));
        }
        if (!Util.isPrefix(bArr3, bArr)) {
            throw new GeneralSecurityException("Invalid signature (output prefix mismatch)");
        }
        Signature signature = Signature.getInstance(ALGORITHM_NAME, this.provider);
        signature.initVerify(this.publicKey);
        signature.update(bArr2);
        signature.update(this.messageSuffix);
        try {
            if (signature.verify(bArr, this.outputPrefix.length, 64)) {
                return;
            }
        } catch (RuntimeException unused) {
        }
        throw new GeneralSecurityException("Signature check failed.");
    }
}
