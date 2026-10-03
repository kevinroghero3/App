package com.google.crypto.tink;

import com.google.crypto.tink.aead.AesCtrHmacAeadKey;
import com.google.crypto.tink.aead.AesGcmKey;
import com.google.crypto.tink.aead.internal.WrappedAead;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.PrimitiveWrapper;
import com.google.crypto.tink.internal.Random;
import com.google.crypto.tink.mac.ChunkedMac;
import com.google.crypto.tink.mac.HmacKey;
import com.google.crypto.tink.mac.internal.ChunkedHmacImpl;
import com.google.crypto.tink.mac.internal.WrappedChunkedMac;
import com.google.crypto.tink.mac.internal.WrappedMac;
import com.google.crypto.tink.prf.HmacPrfKey;
import com.google.crypto.tink.prf.Prf;
import com.google.crypto.tink.prf.PrfSet;
import com.google.crypto.tink.prf.internal.WrappedPrfSet;
import com.google.crypto.tink.signature.EcdsaPrivateKey;
import com.google.crypto.tink.signature.EcdsaPublicKey;
import com.google.crypto.tink.signature.RsaSsaPkcs1PrivateKey;
import com.google.crypto.tink.signature.RsaSsaPkcs1PublicKey;
import com.google.crypto.tink.signature.RsaSsaPssPrivateKey;
import com.google.crypto.tink.signature.RsaSsaPssPublicKey;
import com.google.crypto.tink.signature.internal.RsaSsaPkcs1VerifyConscrypt;
import com.google.crypto.tink.signature.internal.RsaSsaPssSignConscrypt;
import com.google.crypto.tink.signature.internal.RsaSsaPssVerifyConscrypt;
import com.google.crypto.tink.signature.internal.WrappedPublicKeySign;
import com.google.crypto.tink.signature.internal.WrappedPublicKeyVerify;
import com.google.crypto.tink.subtle.AesGcmJce;
import com.google.crypto.tink.subtle.EcdsaSignJce;
import com.google.crypto.tink.subtle.EcdsaVerifyJce;
import com.google.crypto.tink.subtle.EncryptThenAuthenticate;
import com.google.crypto.tink.subtle.PrfHmacJce;
import com.google.crypto.tink.subtle.PrfMac;
import com.google.crypto.tink.subtle.RsaSsaPkcs1SignJce;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes5.dex */
public class ConfigurationFips140v2 {
    private static final Configuration CONFIGURATION = create();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ PublicKeyVerify access$000(KeysetHandleInterface.Entry entry) throws GeneralSecurityException {
        return createPublicKeyVerify(entry);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ PublicKeySign access$100(KeysetHandleInterface.Entry entry) throws GeneralSecurityException {
        return createPublicKeySign(entry);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Prf access$200(KeysetHandleInterface.Entry entry) throws GeneralSecurityException {
        return createPrf(entry);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ ChunkedMac access$300(KeysetHandleInterface.Entry entry) throws GeneralSecurityException {
        return createChunkedMac(entry);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Mac access$400(KeysetHandleInterface.Entry entry) throws GeneralSecurityException {
        return createMac(entry);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Aead access$500(KeysetHandleInterface.Entry entry) throws GeneralSecurityException {
        return createAead(entry);
    }

    public static Configuration get() throws GeneralSecurityException {
        if (!TinkFipsUtil.fipsModuleAvailable()) {
            throw new GeneralSecurityException("Conscrypt is not available or does not support checking for FIPS build.");
        }
        Random.validateUsesConscrypt();
        return CONFIGURATION;
    }

    /* JADX INFO: renamed from: com.google.crypto.tink.ConfigurationFips140v2$1, reason: invalid class name */
    class AnonymousClass1 implements Configuration {
        AnonymousClass1() {
        }

        @Override // com.google.crypto.tink.Configuration
        public <P> P createPrimitive(KeysetHandleInterface keysetHandleInterface, Class<P> cls) throws GeneralSecurityException {
            if (cls.equals(Aead.class)) {
                return cls.cast(WrappedAead.create(keysetHandleInterface, new PrimitiveWrapper.PrimitiveFactory() { // from class: com.google.crypto.tink.ConfigurationFips140v2$1$$ExternalSyntheticLambda0
                    @Override // com.google.crypto.tink.internal.PrimitiveWrapper.PrimitiveFactory
                    public final Object create(KeysetHandleInterface.Entry entry) {
                        return ConfigurationFips140v2.access$500(entry);
                    }
                }));
            }
            if (cls.equals(Mac.class)) {
                return cls.cast(WrappedMac.create(keysetHandleInterface, new PrimitiveWrapper.PrimitiveFactory() { // from class: com.google.crypto.tink.ConfigurationFips140v2$1$$ExternalSyntheticLambda1
                    @Override // com.google.crypto.tink.internal.PrimitiveWrapper.PrimitiveFactory
                    public final Object create(KeysetHandleInterface.Entry entry) {
                        return ConfigurationFips140v2.access$400(entry);
                    }
                }));
            }
            if (cls.equals(ChunkedMac.class)) {
                return cls.cast(WrappedChunkedMac.create(keysetHandleInterface, new PrimitiveWrapper.PrimitiveFactory() { // from class: com.google.crypto.tink.ConfigurationFips140v2$1$$ExternalSyntheticLambda2
                    @Override // com.google.crypto.tink.internal.PrimitiveWrapper.PrimitiveFactory
                    public final Object create(KeysetHandleInterface.Entry entry) {
                        return ConfigurationFips140v2.access$300(entry);
                    }
                }));
            }
            if (cls.equals(PrfSet.class)) {
                return cls.cast(WrappedPrfSet.create(keysetHandleInterface, new PrimitiveWrapper.PrimitiveFactory() { // from class: com.google.crypto.tink.ConfigurationFips140v2$1$$ExternalSyntheticLambda3
                    @Override // com.google.crypto.tink.internal.PrimitiveWrapper.PrimitiveFactory
                    public final Object create(KeysetHandleInterface.Entry entry) {
                        return ConfigurationFips140v2.access$200(entry);
                    }
                }));
            }
            if (cls.equals(PublicKeySign.class)) {
                return cls.cast(WrappedPublicKeySign.create(keysetHandleInterface, new PrimitiveWrapper.PrimitiveFactory() { // from class: com.google.crypto.tink.ConfigurationFips140v2$1$$ExternalSyntheticLambda4
                    @Override // com.google.crypto.tink.internal.PrimitiveWrapper.PrimitiveFactory
                    public final Object create(KeysetHandleInterface.Entry entry) {
                        return ConfigurationFips140v2.access$100(entry);
                    }
                }));
            }
            if (cls.equals(PublicKeyVerify.class)) {
                return cls.cast(WrappedPublicKeyVerify.create(keysetHandleInterface, new PrimitiveWrapper.PrimitiveFactory() { // from class: com.google.crypto.tink.ConfigurationFips140v2$1$$ExternalSyntheticLambda5
                    @Override // com.google.crypto.tink.internal.PrimitiveWrapper.PrimitiveFactory
                    public final Object create(KeysetHandleInterface.Entry entry) {
                        return ConfigurationFips140v2.access$000(entry);
                    }
                }));
            }
            throw new GeneralSecurityException("No primitive creator for " + cls.getName() + " available in ConfigurationFips140v2");
        }
    }

    private static Configuration create() {
        return new AnonymousClass1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Aead createAead(KeysetHandleInterface.Entry entry) throws GeneralSecurityException {
        Key key = entry.getKey();
        if (key instanceof AesCtrHmacAeadKey) {
            return EncryptThenAuthenticate.create((AesCtrHmacAeadKey) key);
        }
        if (key instanceof AesGcmKey) {
            return AesGcmJce.create((AesGcmKey) key);
        }
        throw new GeneralSecurityException("Key type" + key.getClass() + " not supported for AEAD");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Mac createMac(KeysetHandleInterface.Entry entry) throws GeneralSecurityException {
        Key key = entry.getKey();
        if (key instanceof HmacKey) {
            return PrfMac.create((HmacKey) key);
        }
        throw new GeneralSecurityException("Key type" + key.getClass() + " not supported for MAC");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ChunkedMac createChunkedMac(KeysetHandleInterface.Entry entry) throws GeneralSecurityException {
        Key key = entry.getKey();
        if (key instanceof HmacKey) {
            return new ChunkedHmacImpl((HmacKey) key);
        }
        throw new GeneralSecurityException("Key type" + key.getClass() + " not supported for ChunkedMac");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Prf createPrf(KeysetHandleInterface.Entry entry) throws GeneralSecurityException {
        Key key = entry.getKey();
        if (key instanceof HmacPrfKey) {
            return PrfHmacJce.create((HmacPrfKey) key);
        }
        throw new GeneralSecurityException("Key type" + key.getClass() + " not supported for Prf");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static PublicKeySign createPublicKeySign(KeysetHandleInterface.Entry entry) throws GeneralSecurityException {
        Key key = entry.getKey();
        if (key instanceof EcdsaPrivateKey) {
            return EcdsaSignJce.create((EcdsaPrivateKey) key);
        }
        if (key instanceof RsaSsaPkcs1PrivateKey) {
            return rsaSsaPkcs1SignCreate((RsaSsaPkcs1PrivateKey) key);
        }
        if (key instanceof RsaSsaPssPrivateKey) {
            return rsaSsaPssSignCreate((RsaSsaPssPrivateKey) key);
        }
        throw new GeneralSecurityException("Key type" + key.getClass() + " not supported for PublicKeySign");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static PublicKeyVerify createPublicKeyVerify(KeysetHandleInterface.Entry entry) throws GeneralSecurityException {
        Key key = entry.getKey();
        if (key instanceof EcdsaPublicKey) {
            return EcdsaVerifyJce.create((EcdsaPublicKey) key);
        }
        if (key instanceof RsaSsaPkcs1PublicKey) {
            return rsaSsaPkcs1VerifyCreate((RsaSsaPkcs1PublicKey) key);
        }
        if (key instanceof RsaSsaPssPublicKey) {
            return rsaSsaPssVerifyCreate((RsaSsaPssPublicKey) key);
        }
        throw new GeneralSecurityException("Key type" + key.getClass() + " not supported for PublicKeyVerify");
    }

    private ConfigurationFips140v2() {
    }

    private static PublicKeySign rsaSsaPkcs1SignCreate(RsaSsaPkcs1PrivateKey rsaSsaPkcs1PrivateKey) throws GeneralSecurityException {
        if (rsaSsaPkcs1PrivateKey.getParameters().getModulusSizeBits() != 2048 && rsaSsaPkcs1PrivateKey.getParameters().getModulusSizeBits() != 3072) {
            throw new GeneralSecurityException("Cannot create FIPS-compliant PublicKeySign: wrong RsaSsaPkcs1 key modulus size");
        }
        return RsaSsaPkcs1SignJce.create(rsaSsaPkcs1PrivateKey);
    }

    private static PublicKeyVerify rsaSsaPkcs1VerifyCreate(RsaSsaPkcs1PublicKey rsaSsaPkcs1PublicKey) throws GeneralSecurityException {
        if (rsaSsaPkcs1PublicKey.getParameters().getModulusSizeBits() != 2048 && rsaSsaPkcs1PublicKey.getParameters().getModulusSizeBits() != 3072) {
            throw new GeneralSecurityException("Cannot create FIPS-compliant PublicKeyVerify: wrong RsaSsaPkcs1 key modulus size");
        }
        return RsaSsaPkcs1VerifyConscrypt.create(rsaSsaPkcs1PublicKey);
    }

    private static PublicKeySign rsaSsaPssSignCreate(RsaSsaPssPrivateKey rsaSsaPssPrivateKey) throws GeneralSecurityException {
        if (rsaSsaPssPrivateKey.getParameters().getModulusSizeBits() != 2048 && rsaSsaPssPrivateKey.getParameters().getModulusSizeBits() != 3072) {
            throw new GeneralSecurityException("Cannot create FIPS-compliant PublicKeySign: wrong RsaSsaPss key modulus size");
        }
        return RsaSsaPssSignConscrypt.create(rsaSsaPssPrivateKey);
    }

    private static PublicKeyVerify rsaSsaPssVerifyCreate(RsaSsaPssPublicKey rsaSsaPssPublicKey) throws GeneralSecurityException {
        if (rsaSsaPssPublicKey.getParameters().getModulusSizeBits() != 2048 && rsaSsaPssPublicKey.getParameters().getModulusSizeBits() != 3072) {
            throw new GeneralSecurityException("Cannot create FIPS-compliant PublicKeyVerify: wrong RsaSsaPss key modulus size");
        }
        return RsaSsaPssVerifyConscrypt.create(rsaSsaPssPublicKey);
    }
}
