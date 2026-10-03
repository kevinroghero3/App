package com.google.crypto.tink.subtle;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.aead.XChaCha20Poly1305Key;
import com.google.crypto.tink.aead.internal.InsecureNonceXChaCha20Poly1305;
import com.google.crypto.tink.internal.Util;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class XChaCha20Poly1305 implements Aead {
    private final InsecureNonceXChaCha20Poly1305 cipher;
    private final byte[] outputPrefix;

    private XChaCha20Poly1305(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        this.cipher = new InsecureNonceXChaCha20Poly1305(bArr);
        this.outputPrefix = bArr2;
    }

    public XChaCha20Poly1305(byte[] bArr) throws GeneralSecurityException {
        this(bArr, new byte[0]);
    }

    public static Aead create(XChaCha20Poly1305Key xChaCha20Poly1305Key) throws GeneralSecurityException {
        return new XChaCha20Poly1305(xChaCha20Poly1305Key.getKeyBytes().toByteArray(InsecureSecretKeyAccess.get()), xChaCha20Poly1305Key.getOutputPrefix().toByteArray());
    }

    private byte[] rawEncrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArr.length + 40);
        byte[] bArrRandBytes = Random.randBytes(24);
        byteBufferAllocate.put(bArrRandBytes);
        this.cipher.encrypt(byteBufferAllocate, bArrRandBytes, bArr, bArr2);
        return byteBufferAllocate.array();
    }

    @Override // com.google.crypto.tink.Aead
    public byte[] encrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArrRawEncrypt = rawEncrypt(bArr, bArr2);
        byte[] bArr3 = this.outputPrefix;
        return bArr3.length == 0 ? bArrRawEncrypt : Bytes.concat(bArr3, bArrRawEncrypt);
    }

    private byte[] rawDecrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length < 40) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, 24);
        return this.cipher.decrypt(ByteBuffer.wrap(bArr, 24, bArr.length - 24), bArrCopyOf, bArr2);
    }

    @Override // com.google.crypto.tink.Aead
    public byte[] decrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.outputPrefix;
        if (bArr3.length == 0) {
            return rawDecrypt(bArr, bArr2);
        }
        if (!Util.isPrefix(bArr3, bArr)) {
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
        return rawDecrypt(Arrays.copyOfRange(bArr, this.outputPrefix.length, bArr.length), bArr2);
    }
}
