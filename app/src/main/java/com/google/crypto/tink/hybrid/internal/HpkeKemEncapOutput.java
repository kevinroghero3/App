package com.google.crypto.tink.hybrid.internal;

/* JADX INFO: loaded from: classes5.dex */
final class HpkeKemEncapOutput {
    private final byte[] encapsulatedKey;
    private final byte[] sharedSecret;

    HpkeKemEncapOutput(byte[] bArr, byte[] bArr2) {
        this.sharedSecret = bArr;
        this.encapsulatedKey = bArr2;
    }

    byte[] getSharedSecret() {
        return this.sharedSecret;
    }

    byte[] getEncapsulatedKey() {
        return this.encapsulatedKey;
    }
}
