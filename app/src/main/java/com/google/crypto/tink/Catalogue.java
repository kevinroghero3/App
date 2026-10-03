package com.google.crypto.tink;

import com.google.crypto.tink.internal.PrimitiveWrapper;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public interface Catalogue<P> {
    KeyManager<P> getKeyManager(String str, String str2, int i) throws GeneralSecurityException;

    PrimitiveWrapper<?, P> getPrimitiveWrapper() throws GeneralSecurityException;
}
