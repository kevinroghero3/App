package com.google.crypto.tink;

import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes2.dex */
public interface KeyManager<P> {
    String getKeyType();

    P getPrimitive(ByteString byteString) throws GeneralSecurityException;

    Class<P> getPrimitiveClass();

    KeyData newKeyData(ByteString byteString) throws GeneralSecurityException;

    @Deprecated
    default P getPrimitive(MessageLite messageLite) throws GeneralSecurityException {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default MessageLite newKey(ByteString byteString) throws GeneralSecurityException {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default MessageLite newKey(MessageLite messageLite) throws GeneralSecurityException {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default boolean doesSupport(String str) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default int getVersion() {
        throw new UnsupportedOperationException();
    }
}
