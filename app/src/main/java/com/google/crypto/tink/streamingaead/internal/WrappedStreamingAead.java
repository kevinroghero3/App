package com.google.crypto.tink.streamingaead.internal;

import com.google.crypto.tink.KeyStatus;
import com.google.crypto.tink.KeysetHandleInterface;
import com.google.crypto.tink.StreamingAead;
import com.google.crypto.tink.internal.PrimitiveWrapper;
import java.security.GeneralSecurityException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class WrappedStreamingAead {
    WrappedStreamingAead() {
    }

    public static StreamingAead wrap(KeysetHandleInterface keysetHandleInterface, PrimitiveWrapper.PrimitiveFactory<StreamingAead> primitiveFactory) throws GeneralSecurityException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < keysetHandleInterface.size(); i++) {
            KeysetHandleInterface.Entry at = keysetHandleInterface.getAt(i);
            if (at.getStatus().equals(KeyStatus.ENABLED)) {
                arrayList.add(primitiveFactory.create(at));
            }
        }
        KeysetHandleInterface.Entry primary = keysetHandleInterface.getPrimary();
        if (primary == null) {
            throw new GeneralSecurityException("No primary set");
        }
        StreamingAead streamingAeadCreate = primitiveFactory.create(primary);
        if (streamingAeadCreate == null) {
            throw new GeneralSecurityException("No primary set");
        }
        return new StreamingAeadHelper(arrayList, streamingAeadCreate);
    }
}
