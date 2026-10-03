package com.google.crypto.tink.internal;

import com.google.crypto.tink.shaded.protobuf.MessageLite;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes5.dex */
public abstract class PrimitiveFactory<PrimitiveT, KeyProtoT extends MessageLite> {
    private final Class<PrimitiveT> clazz;

    public abstract PrimitiveT getPrimitive(KeyProtoT keyprotot) throws GeneralSecurityException;

    public PrimitiveFactory(Class<PrimitiveT> cls) {
        this.clazz = cls;
    }

    final Class<PrimitiveT> getPrimitiveClass() {
        return this.clazz;
    }
}
