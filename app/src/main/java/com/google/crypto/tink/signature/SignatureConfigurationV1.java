package com.google.crypto.tink.signature;

import com.google.crypto.tink.Configuration;
import com.google.crypto.tink.Key;
import com.google.crypto.tink.KeysetHandleInterface;
import com.google.crypto.tink.PublicKeySign;
import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.PrimitiveWrapper;
import com.google.crypto.tink.signature.internal.MlDsaSignConscrypt;
import com.google.crypto.tink.signature.internal.MlDsaVerifyConscrypt;
import com.google.crypto.tink.signature.internal.SlhDsaSignConscrypt;
import com.google.crypto.tink.signature.internal.SlhDsaVerifyConscrypt;
import com.google.crypto.tink.subtle.EcdsaSignJce;
import com.google.crypto.tink.subtle.EcdsaVerifyJce;
import com.google.crypto.tink.subtle.Ed25519Sign;
import com.google.crypto.tink.subtle.Ed25519Verify;
import com.google.crypto.tink.subtle.RsaSsaPkcs1SignJce;
import com.google.crypto.tink.subtle.RsaSsaPkcs1VerifyJce;
import com.google.crypto.tink.subtle.RsaSsaPssSignJce;
import com.google.crypto.tink.subtle.RsaSsaPssVerifyJce;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes5.dex */
class SignatureConfigurationV1 {
    private static final PublicKeySignWrapper PUBLIC_KEY_SIGN_WRAPPER = new PublicKeySignWrapper();
    private static final PublicKeyVerifyWrapper PUBLIC_KEY_VERIFY_WRAPPER = new PublicKeyVerifyWrapper();
    private static final Configuration CONFIGURATION = create();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ PublicKeyVerify access$200(KeysetHandleInterface.Entry entry) throws GeneralSecurityException {
        return createPublicKeyVerify(entry);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ PublicKeySign access$300(KeysetHandleInterface.Entry entry) throws GeneralSecurityException {
        return createPublicKeySign(entry);
    }

    private SignatureConfigurationV1() {
    }

    /* JADX INFO: renamed from: com.google.crypto.tink.signature.SignatureConfigurationV1$1, reason: invalid class name */
    class AnonymousClass1 implements Configuration {
        AnonymousClass1() {
        }

        @Override // com.google.crypto.tink.Configuration
        public <P> P createPrimitive(KeysetHandleInterface keysetHandleInterface, Class<P> cls) throws GeneralSecurityException {
            if (cls == PublicKeySign.class) {
                return cls.cast(SignatureConfigurationV1.PUBLIC_KEY_SIGN_WRAPPER.wrap(keysetHandleInterface, new PrimitiveWrapper.PrimitiveFactory() { // from class: com.google.crypto.tink.signature.SignatureConfigurationV1$1$$ExternalSyntheticLambda0
                    @Override // com.google.crypto.tink.internal.PrimitiveWrapper.PrimitiveFactory
                    public final Object create(KeysetHandleInterface.Entry entry) {
                        return SignatureConfigurationV1.access$300(entry);
                    }
                }));
            }
            if (cls == PublicKeyVerify.class) {
                return cls.cast(SignatureConfigurationV1.PUBLIC_KEY_VERIFY_WRAPPER.wrap(keysetHandleInterface, new PrimitiveWrapper.PrimitiveFactory() { // from class: com.google.crypto.tink.signature.SignatureConfigurationV1$1$$ExternalSyntheticLambda1
                    @Override // com.google.crypto.tink.internal.PrimitiveWrapper.PrimitiveFactory
                    public final Object create(KeysetHandleInterface.Entry entry) {
                        return SignatureConfigurationV1.access$200(entry);
                    }
                }));
            }
            throw new GeneralSecurityException("SignatureConfigurationV1 can only create PublicKeySign and PublicKeyVerify");
        }
    }

    private static Configuration create() {
        return new AnonymousClass1();
    }

    public static Configuration get() throws GeneralSecurityException {
        if (TinkFipsUtil.useOnlyFips()) {
            throw new GeneralSecurityException("Cannot use non-FIPS-compliant SignatureConfigurationV1 in FIPS mode");
        }
        return CONFIGURATION;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static PublicKeySign createPublicKeySign(KeysetHandleInterface.Entry entry) throws GeneralSecurityException {
        Key key = entry.getKey();
        if (key instanceof EcdsaPrivateKey) {
            return EcdsaSignJce.create((EcdsaPrivateKey) key);
        }
        if (key instanceof RsaSsaPssPrivateKey) {
            return RsaSsaPssSignJce.create((RsaSsaPssPrivateKey) key);
        }
        if (key instanceof RsaSsaPkcs1PrivateKey) {
            return RsaSsaPkcs1SignJce.create((RsaSsaPkcs1PrivateKey) key);
        }
        if (key instanceof Ed25519PrivateKey) {
            return Ed25519Sign.create((Ed25519PrivateKey) key);
        }
        if (key instanceof MlDsaPrivateKey) {
            return MlDsaSignConscrypt.create((MlDsaPrivateKey) key);
        }
        if (key instanceof SlhDsaPrivateKey) {
            return SlhDsaSignConscrypt.create((SlhDsaPrivateKey) key);
        }
        throw new GeneralSecurityException("Unknown key class: " + key.getClass());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static PublicKeyVerify createPublicKeyVerify(KeysetHandleInterface.Entry entry) throws GeneralSecurityException {
        Key key = entry.getKey();
        if (key instanceof EcdsaPublicKey) {
            return EcdsaVerifyJce.create((EcdsaPublicKey) key);
        }
        if (key instanceof RsaSsaPssPublicKey) {
            return RsaSsaPssVerifyJce.create((RsaSsaPssPublicKey) key);
        }
        if (key instanceof RsaSsaPkcs1PublicKey) {
            return RsaSsaPkcs1VerifyJce.create((RsaSsaPkcs1PublicKey) key);
        }
        if (key instanceof Ed25519PublicKey) {
            return Ed25519Verify.create((Ed25519PublicKey) key);
        }
        if (key instanceof MlDsaPublicKey) {
            return MlDsaVerifyConscrypt.create((MlDsaPublicKey) key);
        }
        if (key instanceof SlhDsaPublicKey) {
            return SlhDsaVerifyConscrypt.create((SlhDsaPublicKey) key);
        }
        throw new GeneralSecurityException("Unknown key class: " + key.getClass());
    }
}
