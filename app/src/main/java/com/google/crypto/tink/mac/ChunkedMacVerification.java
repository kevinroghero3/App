package com.google.crypto.tink.mac;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes5.dex */
public interface ChunkedMacVerification {
    void update(ByteBuffer byteBuffer) throws GeneralSecurityException;

    void verifyMac() throws GeneralSecurityException;
}
