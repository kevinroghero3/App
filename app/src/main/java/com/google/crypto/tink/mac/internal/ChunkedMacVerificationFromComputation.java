package com.google.crypto.tink.mac.internal;

import com.google.crypto.tink.mac.ChunkedMacComputation;
import com.google.crypto.tink.mac.ChunkedMacVerification;
import com.google.crypto.tink.util.Bytes;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes5.dex */
final class ChunkedMacVerificationFromComputation implements ChunkedMacVerification {
    private final ChunkedMacComputation macComputation;
    private final Bytes tag;

    private ChunkedMacVerificationFromComputation(ChunkedMacComputation chunkedMacComputation, byte[] bArr) {
        this.macComputation = chunkedMacComputation;
        this.tag = Bytes.copyFrom(bArr);
    }

    @Override // com.google.crypto.tink.mac.ChunkedMacVerification
    public void update(ByteBuffer byteBuffer) throws GeneralSecurityException {
        this.macComputation.update(byteBuffer);
    }

    @Override // com.google.crypto.tink.mac.ChunkedMacVerification
    public void verifyMac() throws GeneralSecurityException {
        if (!this.tag.equals(Bytes.copyFrom(this.macComputation.computeMac()))) {
            throw new GeneralSecurityException("invalid MAC");
        }
    }

    static ChunkedMacVerification create(ChunkedMacComputation chunkedMacComputation, byte[] bArr) {
        return new ChunkedMacVerificationFromComputation(chunkedMacComputation, bArr);
    }
}
