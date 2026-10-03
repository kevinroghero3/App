package com.google.crypto.tink.aead;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.Configuration;
import com.google.crypto.tink.Key;
import com.google.crypto.tink.KeysetHandleInterface;
import com.google.crypto.tink.aead.internal.ChaCha20Poly1305Jce;
import com.google.crypto.tink.aead.internal.XAesGcm;
import com.google.crypto.tink.aead.internal.XChaCha20Poly1305Jce;
import com.google.crypto.tink.aead.subtle.AesGcmSiv;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.PrimitiveWrapper;
import com.google.crypto.tink.subtle.AesEaxJce;
import com.google.crypto.tink.subtle.AesGcmJce;
import com.google.crypto.tink.subtle.ChaCha20Poly1305;
import com.google.crypto.tink.subtle.EncryptThenAuthenticate;
import com.google.crypto.tink.subtle.XChaCha20Poly1305;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes5.dex */
class AeadConfigurationV1 {
    private static final AeadWrapper WRAPPER = new AeadWrapper();
    private static final Configuration CONFIGURATION = create();

    private AeadConfigurationV1() {
    }

    static Aead createAead(KeysetHandleInterface.Entry entry) throws GeneralSecurityException {
        Key key = entry.getKey();
        if (key instanceof AesCtrHmacAeadKey) {
            return EncryptThenAuthenticate.create((AesCtrHmacAeadKey) key);
        }
        if (key instanceof AesGcmKey) {
            return AesGcmJce.create((AesGcmKey) key);
        }
        if (key instanceof AesGcmSivKey) {
            return AesGcmSiv.create((AesGcmSivKey) key);
        }
        if (key instanceof AesEaxKey) {
            return AesEaxJce.create((AesEaxKey) key);
        }
        if (key instanceof ChaCha20Poly1305Key) {
            return createChaCha20Poly1305((ChaCha20Poly1305Key) key);
        }
        if (key instanceof XChaCha20Poly1305Key) {
            return createXChaCha20Poly1305((XChaCha20Poly1305Key) key);
        }
        if (key instanceof XAesGcmKey) {
            return XAesGcm.create((XAesGcmKey) key);
        }
        throw new GeneralSecurityException("Unknown key class: " + key.getClass());
    }

    private static Configuration create() {
        return new Configuration() { // from class: com.google.crypto.tink.aead.AeadConfigurationV1.1
            @Override // com.google.crypto.tink.Configuration
            public <P> P createPrimitive(KeysetHandleInterface keysetHandleInterface, Class<P> cls) throws GeneralSecurityException {
                if (cls == Aead.class) {
                    return cls.cast(AeadConfigurationV1.WRAPPER.wrap(keysetHandleInterface, new PrimitiveWrapper.PrimitiveFactory() { // from class: com.google.crypto.tink.aead.AeadConfigurationV1$1$$ExternalSyntheticLambda0
                        @Override // com.google.crypto.tink.internal.PrimitiveWrapper.PrimitiveFactory
                        public final Object create(KeysetHandleInterface.Entry entry) {
                            return AeadConfigurationV1.createAead(entry);
                        }
                    }));
                }
                throw new GeneralSecurityException("AeadConfigurationV1 can only create AEADs");
            }
        };
    }

    public static Configuration get() throws GeneralSecurityException {
        if (TinkFipsUtil.useOnlyFips()) {
            throw new GeneralSecurityException("Cannot use non-FIPS-compliant AeadConfigurationV1 in FIPS mode");
        }
        return CONFIGURATION;
    }

    private static Aead createChaCha20Poly1305(ChaCha20Poly1305Key chaCha20Poly1305Key) throws GeneralSecurityException {
        if (ChaCha20Poly1305Jce.isSupported()) {
            return ChaCha20Poly1305Jce.create(chaCha20Poly1305Key);
        }
        return ChaCha20Poly1305.create(chaCha20Poly1305Key);
    }

    private static Aead createXChaCha20Poly1305(XChaCha20Poly1305Key xChaCha20Poly1305Key) throws GeneralSecurityException {
        if (XChaCha20Poly1305Jce.isSupported()) {
            return XChaCha20Poly1305Jce.create(xChaCha20Poly1305Key);
        }
        return XChaCha20Poly1305.create(xChaCha20Poly1305Key);
    }
}
