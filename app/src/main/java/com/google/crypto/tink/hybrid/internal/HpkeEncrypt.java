package com.google.crypto.tink.hybrid.internal;

import com.google.crypto.tink.HybridEncrypt;
import com.google.crypto.tink.hybrid.HpkeParameters;
import com.google.crypto.tink.hybrid.HpkePublicKey;
import com.google.crypto.tink.util.Bytes;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes2.dex */
@Immutable
public final class HpkeEncrypt implements HybridEncrypt {
    private static final byte[] EMPTY_ASSOCIATED_DATA = new byte[0];
    private final HpkeAead aead;
    private final HpkeKdf kdf;
    private final HpkeKem kem;
    private final byte[] outputPrefix;
    private final byte[] recipientPublicKey;

    private HpkeEncrypt(Bytes bytes, HpkeKem hpkeKem, HpkeKdf hpkeKdf, HpkeAead hpkeAead, Bytes bytes2) {
        this.recipientPublicKey = bytes.toByteArray();
        this.kem = hpkeKem;
        this.kdf = hpkeKdf;
        this.aead = hpkeAead;
        this.outputPrefix = bytes2.toByteArray();
    }

    public static HybridEncrypt create(HpkePublicKey hpkePublicKey) throws GeneralSecurityException {
        HpkeParameters parameters = hpkePublicKey.getParameters();
        return new HpkeEncrypt(hpkePublicKey.getPublicKeyBytes(), HpkePrimitiveFactory.createKem(parameters.getKemId()), HpkePrimitiveFactory.createKdf(parameters.getKdfId()), HpkePrimitiveFactory.createAead(parameters.getAeadId()), hpkePublicKey.getOutputPrefix());
    }

    @Override // com.google.crypto.tink.HybridEncrypt
    public byte[] encrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        HpkeContext hpkeContextCreateSenderContext = HpkeContext.createSenderContext(this.recipientPublicKey, this.kem, this.kdf, this.aead, bArr2);
        byte[] encapsulatedKey = hpkeContextCreateSenderContext.getEncapsulatedKey();
        byte[] bArrSeal = hpkeContextCreateSenderContext.seal(bArr, this.outputPrefix.length + encapsulatedKey.length, EMPTY_ASSOCIATED_DATA);
        byte[] bArr3 = this.outputPrefix;
        System.arraycopy(bArr3, 0, bArrSeal, 0, bArr3.length);
        System.arraycopy(encapsulatedKey, 0, bArrSeal, this.outputPrefix.length, encapsulatedKey.length);
        return bArrSeal;
    }
}
