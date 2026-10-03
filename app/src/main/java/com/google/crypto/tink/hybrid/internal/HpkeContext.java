package com.google.crypto.tink.hybrid.internal;

import com.google.crypto.tink.hybrid.HpkePublicKey;
import com.google.crypto.tink.internal.BigIntegerEncoding;
import com.google.crypto.tink.subtle.Bytes;
import java.math.BigInteger;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes5.dex */
public final class HpkeContext {
    private static final byte[] EMPTY_IKM = new byte[0];
    private final HpkeAead aead;
    private final byte[] baseNonce;
    private final byte[] encapsulatedKey;
    private final byte[] key;
    private final BigInteger maxSequenceNumber;
    private BigInteger sequenceNumber = BigInteger.ZERO;

    private HpkeContext(byte[] bArr, byte[] bArr2, byte[] bArr3, BigInteger bigInteger, HpkeAead hpkeAead) {
        this.encapsulatedKey = bArr;
        this.key = bArr2;
        this.baseNonce = bArr3;
        this.maxSequenceNumber = bigInteger;
        this.aead = hpkeAead;
    }

    static HpkeContext createContext(byte[] bArr, byte[] bArr2, byte[] bArr3, HpkeKem hpkeKem, HpkeKdf hpkeKdf, HpkeAead hpkeAead, byte[] bArr4) throws GeneralSecurityException {
        byte[] bArrHpkeSuiteId = HpkeUtil.hpkeSuiteId(hpkeKem.getKemId(), hpkeKdf.getKdfId(), hpkeAead.getAeadId());
        byte[] bArr5 = HpkeUtil.EMPTY_SALT;
        byte[] bArr6 = EMPTY_IKM;
        byte[] bArrConcat = Bytes.concat(bArr, hpkeKdf.labeledExtract(bArr5, bArr6, "psk_id_hash", bArrHpkeSuiteId), hpkeKdf.labeledExtract(bArr5, bArr4, "info_hash", bArrHpkeSuiteId));
        byte[] bArrLabeledExtract = hpkeKdf.labeledExtract(bArr3, bArr6, "secret", bArrHpkeSuiteId);
        return new HpkeContext(bArr2, hpkeKdf.labeledExpand(bArrLabeledExtract, bArrConcat, "key", bArrHpkeSuiteId, hpkeAead.getKeyLength()), hpkeKdf.labeledExpand(bArrLabeledExtract, bArrConcat, "base_nonce", bArrHpkeSuiteId, hpkeAead.getNonceLength()), maxSequenceNumber(hpkeAead.getNonceLength()), hpkeAead);
    }

    static HpkeContext createSenderContext(byte[] bArr, HpkeKem hpkeKem, HpkeKdf hpkeKdf, HpkeAead hpkeAead, byte[] bArr2) throws GeneralSecurityException {
        HpkeKemEncapOutput hpkeKemEncapOutputEncapsulate = hpkeKem.encapsulate(bArr);
        return createContext(HpkeUtil.BASE_MODE, hpkeKemEncapOutputEncapsulate.getEncapsulatedKey(), hpkeKemEncapOutputEncapsulate.getSharedSecret(), hpkeKem, hpkeKdf, hpkeAead, bArr2);
    }

    public static HpkeContext createAuthSenderContext(HpkePublicKey hpkePublicKey, HpkeKem hpkeKem, HpkeKdf hpkeKdf, HpkeAead hpkeAead, byte[] bArr, HpkeKemPrivateKey hpkeKemPrivateKey) throws GeneralSecurityException {
        HpkeKemEncapOutput hpkeKemEncapOutputAuthEncapsulate = hpkeKem.authEncapsulate(hpkePublicKey.getPublicKeyBytes().toByteArray(), hpkeKemPrivateKey);
        return createContext(HpkeUtil.AUTH_MODE, hpkeKemEncapOutputAuthEncapsulate.getEncapsulatedKey(), hpkeKemEncapOutputAuthEncapsulate.getSharedSecret(), hpkeKem, hpkeKdf, hpkeAead, bArr);
    }

    public static HpkeContext createRecipientContext(byte[] bArr, HpkeKemPrivateKey hpkeKemPrivateKey, HpkeKem hpkeKem, HpkeKdf hpkeKdf, HpkeAead hpkeAead, byte[] bArr2) throws GeneralSecurityException {
        return createContext(HpkeUtil.BASE_MODE, bArr, hpkeKem.decapsulate(bArr, hpkeKemPrivateKey), hpkeKem, hpkeKdf, hpkeAead, bArr2);
    }

    public static HpkeContext createAuthRecipientContext(byte[] bArr, HpkeKemPrivateKey hpkeKemPrivateKey, HpkeKem hpkeKem, HpkeKdf hpkeKdf, HpkeAead hpkeAead, byte[] bArr2, HpkePublicKey hpkePublicKey) throws GeneralSecurityException {
        return createContext(HpkeUtil.AUTH_MODE, bArr, hpkeKem.authDecapsulate(bArr, hpkeKemPrivateKey, hpkePublicKey.getPublicKeyBytes().toByteArray()), hpkeKem, hpkeKdf, hpkeAead, bArr2);
    }

    private static BigInteger maxSequenceNumber(int i) {
        BigInteger bigInteger = BigInteger.ONE;
        return bigInteger.shiftLeft(i * 8).subtract(bigInteger);
    }

    private void incrementSequenceNumber() throws GeneralSecurityException {
        if (this.sequenceNumber.compareTo(this.maxSequenceNumber) >= 0) {
            throw new GeneralSecurityException("message limit reached");
        }
        this.sequenceNumber = this.sequenceNumber.add(BigInteger.ONE);
    }

    private byte[] computeNonce() throws GeneralSecurityException {
        return Bytes.xor(this.baseNonce, BigIntegerEncoding.toBigEndianBytesOfFixedLength(this.sequenceNumber, this.aead.getNonceLength()));
    }

    private byte[] computeNonceAndIncrementSequenceNumber() throws GeneralSecurityException {
        byte[] bArrComputeNonce;
        synchronized (this) {
            bArrComputeNonce = computeNonce();
            incrementSequenceNumber();
        }
        return bArrComputeNonce;
    }

    byte[] getKey() {
        return this.key;
    }

    byte[] getBaseNonce() {
        return this.baseNonce;
    }

    public byte[] getEncapsulatedKey() {
        return this.encapsulatedKey;
    }

    public byte[] seal(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return this.aead.seal(this.key, computeNonceAndIncrementSequenceNumber(), bArr, bArr2);
    }

    byte[] seal(byte[] bArr, int i, byte[] bArr2) throws GeneralSecurityException {
        return this.aead.seal(this.key, computeNonceAndIncrementSequenceNumber(), bArr, i, bArr2);
    }

    public byte[] open(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return open(bArr, 0, bArr2);
    }

    byte[] open(byte[] bArr, int i, byte[] bArr2) throws GeneralSecurityException {
        return this.aead.open(this.key, computeNonceAndIncrementSequenceNumber(), bArr, i, bArr2);
    }
}
