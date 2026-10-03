package com.google.crypto.tink.subtle;

import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.signature.EcdsaPublicKey;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.security.interfaces.ECPublicKey;

/* JADX INFO: loaded from: classes3.dex */
@Immutable
public final class EcdsaVerifyJce implements PublicKeyVerify {
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
    private final PublicKeyVerify verifier;

    public static PublicKeyVerify create(EcdsaPublicKey ecdsaPublicKey) throws GeneralSecurityException {
        return com.google.crypto.tink.signature.internal.EcdsaVerifyJce.create(ecdsaPublicKey);
    }

    public EcdsaVerifyJce(ECPublicKey eCPublicKey, Enums.HashType hashType, EllipticCurves.EcdsaEncoding ecdsaEncoding) throws GeneralSecurityException {
        this.verifier = new com.google.crypto.tink.signature.internal.EcdsaVerifyJce(eCPublicKey, hashType, ecdsaEncoding);
    }

    @Override // com.google.crypto.tink.PublicKeyVerify
    public void verify(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        this.verifier.verify(bArr, bArr2);
    }
}
