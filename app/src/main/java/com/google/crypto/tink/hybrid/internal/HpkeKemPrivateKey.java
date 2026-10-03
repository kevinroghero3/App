package com.google.crypto.tink.hybrid.internal;

import com.google.crypto.tink.util.Bytes;
import com.google.errorprone.annotations.Immutable;

/* JADX INFO: loaded from: classes2.dex */
@Immutable
public class HpkeKemPrivateKey {
    private final Bytes serializedPrivate;
    private final Bytes serializedPublic;

    public HpkeKemPrivateKey(Bytes bytes, Bytes bytes2) {
        this.serializedPrivate = bytes;
        this.serializedPublic = bytes2;
    }

    Bytes getSerializedPrivate() {
        return this.serializedPrivate;
    }

    Bytes getSerializedPublic() {
        return this.serializedPublic;
    }
}
