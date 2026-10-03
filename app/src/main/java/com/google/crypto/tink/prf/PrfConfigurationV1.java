package com.google.crypto.tink.prf;

import com.google.crypto.tink.Configuration;
import com.google.crypto.tink.Key;
import com.google.crypto.tink.KeysetHandleInterface;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.PrimitiveWrapper;
import com.google.crypto.tink.subtle.PrfAesCmac;
import com.google.crypto.tink.subtle.PrfHmacJce;
import com.google.crypto.tink.subtle.prf.HkdfStreamingPrf;
import com.google.crypto.tink.subtle.prf.PrfImpl;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes5.dex */
class PrfConfigurationV1 {
    private static final int MIN_HKDF_PRF_KEY_SIZE = 32;
    private static final PrfSetWrapper PRF_SET_WRAPPER = new PrfSetWrapper();
    private static final Configuration CONFIGURATION = create();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Prf access$100(KeysetHandleInterface.Entry entry) throws GeneralSecurityException {
        return createPrf(entry);
    }

    private PrfConfigurationV1() {
    }

    /* JADX INFO: renamed from: com.google.crypto.tink.prf.PrfConfigurationV1$1, reason: invalid class name */
    class AnonymousClass1 implements Configuration {
        AnonymousClass1() {
        }

        @Override // com.google.crypto.tink.Configuration
        public <P> P createPrimitive(KeysetHandleInterface keysetHandleInterface, Class<P> cls) throws GeneralSecurityException {
            if (cls.equals(PrfSet.class)) {
                return cls.cast(PrfConfigurationV1.PRF_SET_WRAPPER.wrap(keysetHandleInterface, new PrimitiveWrapper.PrimitiveFactory() { // from class: com.google.crypto.tink.prf.PrfConfigurationV1$1$$ExternalSyntheticLambda0
                    @Override // com.google.crypto.tink.internal.PrimitiveWrapper.PrimitiveFactory
                    public final Object create(KeysetHandleInterface.Entry entry) {
                        return PrfConfigurationV1.access$100(entry);
                    }
                }));
            }
            throw new GeneralSecurityException("PrfConfigurationV1 can only create PrfSet primitive");
        }
    }

    private static Configuration create() {
        return new AnonymousClass1();
    }

    public static Configuration get() throws GeneralSecurityException {
        if (TinkFipsUtil.useOnlyFips()) {
            throw new GeneralSecurityException("Cannot use non-FIPS-compliant PrfConfigurationV1 in FIPS mode");
        }
        return CONFIGURATION;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Prf createPrf(KeysetHandleInterface.Entry entry) throws GeneralSecurityException {
        Key key = entry.getKey();
        if (key instanceof HmacPrfKey) {
            return PrfHmacJce.create((HmacPrfKey) key);
        }
        if (key instanceof HkdfPrfKey) {
            return createHkdfPrf((HkdfPrfKey) key);
        }
        if (key instanceof AesCmacPrfKey) {
            return createAesCmacPrf((AesCmacPrfKey) key);
        }
        throw new GeneralSecurityException("Unknown key class: " + key.getClass());
    }

    private static Prf createHkdfPrf(HkdfPrfKey hkdfPrfKey) throws GeneralSecurityException {
        if (hkdfPrfKey.getParameters().getKeySizeBytes() < 32) {
            throw new GeneralSecurityException("HkdfPrf key size must be at least 32");
        }
        if (hkdfPrfKey.getParameters().getHashType() != HkdfPrfParameters.HashType.SHA256 && hkdfPrfKey.getParameters().getHashType() != HkdfPrfParameters.HashType.SHA512) {
            throw new GeneralSecurityException("HkdfPrf hash type must be SHA256 or SHA512");
        }
        return PrfImpl.wrap(HkdfStreamingPrf.create(hkdfPrfKey));
    }

    private static Prf createAesCmacPrf(AesCmacPrfKey aesCmacPrfKey) throws GeneralSecurityException {
        if (aesCmacPrfKey.getParameters().getKeySizeBytes() != 32) {
            throw new GeneralSecurityException("AesCmacPrf key size must be 32 bytes");
        }
        return PrfAesCmac.create(aesCmacPrfKey);
    }
}
