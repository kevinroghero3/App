package com.google.crypto.tink;

import com.google.crypto.tink.aead.AesCtrHmacAeadKey;
import com.google.crypto.tink.aead.AesEaxKey;
import com.google.crypto.tink.aead.AesGcmKey;
import com.google.crypto.tink.aead.AesGcmSivKey;
import com.google.crypto.tink.aead.ChaCha20Poly1305Key;
import com.google.crypto.tink.aead.XChaCha20Poly1305Key;
import com.google.crypto.tink.aead.internal.ChaCha20Poly1305Jce;
import com.google.crypto.tink.aead.internal.WrappedAead;
import com.google.crypto.tink.aead.internal.XChaCha20Poly1305Jce;
import com.google.crypto.tink.aead.subtle.AesGcmSiv;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.daead.AesSivKey;
import com.google.crypto.tink.daead.internal.WrappedDeterministicAead;
import com.google.crypto.tink.hybrid.EciesPrivateKey;
import com.google.crypto.tink.hybrid.EciesPublicKey;
import com.google.crypto.tink.hybrid.HpkePrivateKey;
import com.google.crypto.tink.hybrid.HpkePublicKey;
import com.google.crypto.tink.hybrid.internal.HpkeDecrypt;
import com.google.crypto.tink.hybrid.internal.HpkeEncrypt;
import com.google.crypto.tink.hybrid.internal.WrappedHybridDecrypt;
import com.google.crypto.tink.hybrid.internal.WrappedHybridEncrypt;
import com.google.crypto.tink.internal.LegacyProtoKey;
import com.google.crypto.tink.internal.MutableSerializationRegistry;
import com.google.crypto.tink.internal.PrimitiveWrapper;
import com.google.crypto.tink.mac.AesCmacKey;
import com.google.crypto.tink.mac.ChunkedMac;
import com.google.crypto.tink.mac.HmacKey;
import com.google.crypto.tink.mac.internal.ChunkedAesCmacImpl;
import com.google.crypto.tink.mac.internal.ChunkedHmacImpl;
import com.google.crypto.tink.mac.internal.WrappedChunkedMac;
import com.google.crypto.tink.mac.internal.WrappedMac;
import com.google.crypto.tink.prf.AesCmacPrfKey;
import com.google.crypto.tink.prf.HkdfPrfKey;
import com.google.crypto.tink.prf.HkdfPrfParameters;
import com.google.crypto.tink.prf.HmacPrfKey;
import com.google.crypto.tink.prf.Prf;
import com.google.crypto.tink.prf.PrfSet;
import com.google.crypto.tink.prf.internal.WrappedPrfSet;
import com.google.crypto.tink.signature.EcdsaPrivateKey;
import com.google.crypto.tink.signature.EcdsaPublicKey;
import com.google.crypto.tink.signature.Ed25519PrivateKey;
import com.google.crypto.tink.signature.Ed25519PublicKey;
import com.google.crypto.tink.signature.RsaSsaPkcs1PrivateKey;
import com.google.crypto.tink.signature.RsaSsaPkcs1PublicKey;
import com.google.crypto.tink.signature.RsaSsaPssPrivateKey;
import com.google.crypto.tink.signature.RsaSsaPssPublicKey;
import com.google.crypto.tink.signature.internal.WrappedPublicKeySign;
import com.google.crypto.tink.signature.internal.WrappedPublicKeyVerify;
import com.google.crypto.tink.streamingaead.AesCtrHmacStreamingKey;
import com.google.crypto.tink.streamingaead.AesGcmHkdfStreamingKey;
import com.google.crypto.tink.streamingaead.internal.WrappedStreamingAead;
import com.google.crypto.tink.subtle.AesCtrHmacStreaming;
import com.google.crypto.tink.subtle.AesEaxJce;
import com.google.crypto.tink.subtle.AesGcmHkdfStreaming;
import com.google.crypto.tink.subtle.AesGcmJce;
import com.google.crypto.tink.subtle.AesSiv;
import com.google.crypto.tink.subtle.ChaCha20Poly1305;
import com.google.crypto.tink.subtle.EcdsaSignJce;
import com.google.crypto.tink.subtle.EcdsaVerifyJce;
import com.google.crypto.tink.subtle.EciesAeadHkdfHybridDecrypt;
import com.google.crypto.tink.subtle.EciesAeadHkdfHybridEncrypt;
import com.google.crypto.tink.subtle.Ed25519Sign;
import com.google.crypto.tink.subtle.Ed25519Verify;
import com.google.crypto.tink.subtle.EncryptThenAuthenticate;
import com.google.crypto.tink.subtle.PrfAesCmac;
import com.google.crypto.tink.subtle.PrfHmacJce;
import com.google.crypto.tink.subtle.PrfMac;
import com.google.crypto.tink.subtle.RsaSsaPkcs1SignJce;
import com.google.crypto.tink.subtle.RsaSsaPkcs1VerifyJce;
import com.google.crypto.tink.subtle.RsaSsaPssSignJce;
import com.google.crypto.tink.subtle.RsaSsaPssVerifyJce;
import com.google.crypto.tink.subtle.XChaCha20Poly1305;
import com.google.crypto.tink.subtle.prf.HkdfStreamingPrf;
import com.google.crypto.tink.subtle.prf.PrfImpl;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes2.dex */
public class ConfigurationV0 {
    private static final int AES_CMAC_KEY_SIZE_BYTES = 32;
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
    public static /* synthetic */ HybridDecrypt access$300(KeysetHandleInterface.Entry entry) throws GeneralSecurityException {
        return createHybridDecrypt(entry);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ HybridEncrypt access$400(KeysetHandleInterface.Entry entry) throws GeneralSecurityException {
        return createHybridEncrypt(entry);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ StreamingAead access$500(KeysetHandleInterface.Entry entry) throws GeneralSecurityException {
        return createStreamingAead(entry);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ DeterministicAead access$600(KeysetHandleInterface.Entry entry) throws GeneralSecurityException {
        return createDeterministicAead(entry);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Aead access$700(KeysetHandleInterface.Entry entry) throws GeneralSecurityException {
        return createAead(entry);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ ChunkedMac access$800(KeysetHandleInterface.Entry entry) throws GeneralSecurityException {
        return createChunkedMac(entry);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Mac access$900(KeysetHandleInterface.Entry entry) throws GeneralSecurityException {
        return createMac(entry);
    }

    private ConfigurationV0() {
    }

    public static Configuration get() throws GeneralSecurityException {
        if (TinkFipsUtil.useOnlyFips()) {
            throw new GeneralSecurityException("Cannot use non-FIPS-compliant ConfigurationV0 in FIPS mode");
        }
        return CONFIGURATION;
    }

    /* JADX INFO: renamed from: com.google.crypto.tink.ConfigurationV0$1, reason: invalid class name */
    class AnonymousClass1 implements Configuration {
        AnonymousClass1() {
        }

        @Override // com.google.crypto.tink.Configuration
        public <P> P createPrimitive(KeysetHandleInterface keysetHandleInterface, Class<P> cls) throws GeneralSecurityException {
            if (cls.equals(Mac.class)) {
                return cls.cast(WrappedMac.create(keysetHandleInterface, new PrimitiveWrapper.PrimitiveFactory() { // from class: com.google.crypto.tink.ConfigurationV0$1$$ExternalSyntheticLambda0
                    @Override // com.google.crypto.tink.internal.PrimitiveWrapper.PrimitiveFactory
                    public final Object create(KeysetHandleInterface.Entry entry) {
                        return ConfigurationV0.access$900(entry);
                    }
                }));
            }
            if (cls.equals(ChunkedMac.class)) {
                return cls.cast(WrappedChunkedMac.create(keysetHandleInterface, new PrimitiveWrapper.PrimitiveFactory() { // from class: com.google.crypto.tink.ConfigurationV0$1$$ExternalSyntheticLambda1
                    @Override // com.google.crypto.tink.internal.PrimitiveWrapper.PrimitiveFactory
                    public final Object create(KeysetHandleInterface.Entry entry) {
                        return ConfigurationV0.access$800(entry);
                    }
                }));
            }
            if (cls.equals(Aead.class)) {
                return cls.cast(WrappedAead.create(keysetHandleInterface, new PrimitiveWrapper.PrimitiveFactory() { // from class: com.google.crypto.tink.ConfigurationV0$1$$ExternalSyntheticLambda2
                    @Override // com.google.crypto.tink.internal.PrimitiveWrapper.PrimitiveFactory
                    public final Object create(KeysetHandleInterface.Entry entry) {
                        return ConfigurationV0.access$700(entry);
                    }
                }));
            }
            if (cls.equals(DeterministicAead.class)) {
                return cls.cast(WrappedDeterministicAead.create(keysetHandleInterface, new PrimitiveWrapper.PrimitiveFactory() { // from class: com.google.crypto.tink.ConfigurationV0$1$$ExternalSyntheticLambda3
                    @Override // com.google.crypto.tink.internal.PrimitiveWrapper.PrimitiveFactory
                    public final Object create(KeysetHandleInterface.Entry entry) {
                        return ConfigurationV0.access$600(entry);
                    }
                }));
            }
            if (cls.equals(StreamingAead.class)) {
                return cls.cast(WrappedStreamingAead.wrap(keysetHandleInterface, new PrimitiveWrapper.PrimitiveFactory() { // from class: com.google.crypto.tink.ConfigurationV0$1$$ExternalSyntheticLambda4
                    @Override // com.google.crypto.tink.internal.PrimitiveWrapper.PrimitiveFactory
                    public final Object create(KeysetHandleInterface.Entry entry) {
                        return ConfigurationV0.access$500(entry);
                    }
                }));
            }
            if (cls.equals(HybridEncrypt.class)) {
                return cls.cast(WrappedHybridEncrypt.create(keysetHandleInterface, new PrimitiveWrapper.PrimitiveFactory() { // from class: com.google.crypto.tink.ConfigurationV0$1$$ExternalSyntheticLambda5
                    @Override // com.google.crypto.tink.internal.PrimitiveWrapper.PrimitiveFactory
                    public final Object create(KeysetHandleInterface.Entry entry) {
                        return ConfigurationV0.access$400(entry);
                    }
                }));
            }
            if (cls.equals(HybridDecrypt.class)) {
                return cls.cast(WrappedHybridDecrypt.create(keysetHandleInterface, new PrimitiveWrapper.PrimitiveFactory() { // from class: com.google.crypto.tink.ConfigurationV0$1$$ExternalSyntheticLambda6
                    @Override // com.google.crypto.tink.internal.PrimitiveWrapper.PrimitiveFactory
                    public final Object create(KeysetHandleInterface.Entry entry) {
                        return ConfigurationV0.access$300(entry);
                    }
                }));
            }
            if (cls.equals(PrfSet.class)) {
                return cls.cast(WrappedPrfSet.create(keysetHandleInterface, new PrimitiveWrapper.PrimitiveFactory() { // from class: com.google.crypto.tink.ConfigurationV0$1$$ExternalSyntheticLambda7
                    @Override // com.google.crypto.tink.internal.PrimitiveWrapper.PrimitiveFactory
                    public final Object create(KeysetHandleInterface.Entry entry) {
                        return ConfigurationV0.access$200(entry);
                    }
                }));
            }
            if (cls.equals(PublicKeySign.class)) {
                return cls.cast(WrappedPublicKeySign.create(keysetHandleInterface, new PrimitiveWrapper.PrimitiveFactory() { // from class: com.google.crypto.tink.ConfigurationV0$1$$ExternalSyntheticLambda8
                    @Override // com.google.crypto.tink.internal.PrimitiveWrapper.PrimitiveFactory
                    public final Object create(KeysetHandleInterface.Entry entry) {
                        return ConfigurationV0.access$100(entry);
                    }
                }));
            }
            if (cls.equals(PublicKeyVerify.class)) {
                return cls.cast(WrappedPublicKeyVerify.create(keysetHandleInterface, new ConfigurationV0$1$$ExternalSyntheticLambda9()));
            }
            throw new GeneralSecurityException("ConfigurationV0 does not support creating primitives of type " + cls.getName());
        }
    }

    private static Configuration create() {
        return new AnonymousClass1();
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

    private static DeterministicAead createAesSiv(AesSivKey aesSivKey) throws GeneralSecurityException {
        if (aesSivKey.getParameters().getKeySizeBytes() != 64) {
            throw new GeneralSecurityException("invalid key size: " + aesSivKey.getParameters().getKeySizeBytes() + ". Valid keys must have 64 bytes.");
        }
        return AesSiv.create(aesSivKey);
    }

    private static Prf createHkdfPrf(HkdfPrfKey hkdfPrfKey) throws GeneralSecurityException {
        if (hkdfPrfKey.getParameters().getKeySizeBytes() < 32) {
            throw new GeneralSecurityException("Key size must be at least 32");
        }
        if (hkdfPrfKey.getParameters().getHashType() != HkdfPrfParameters.HashType.SHA256 && hkdfPrfKey.getParameters().getHashType() != HkdfPrfParameters.HashType.SHA512) {
            throw new GeneralSecurityException("Hash type must be SHA256 or SHA512");
        }
        return PrfImpl.wrap(HkdfStreamingPrf.create(hkdfPrfKey));
    }

    private static Prf createAesCmacPrf(AesCmacPrfKey aesCmacPrfKey) throws GeneralSecurityException {
        if (aesCmacPrfKey.getParameters().getKeySizeBytes() != 32) {
            throw new GeneralSecurityException("Key size must be 32 bytes");
        }
        return PrfAesCmac.create(aesCmacPrfKey);
    }

    private static ChunkedMac createChunkedAesCmac(AesCmacKey aesCmacKey) throws GeneralSecurityException {
        if (aesCmacKey.getParameters().getKeySizeBytes() != 32) {
            throw new GeneralSecurityException("AesCmac key size is not 32 bytes");
        }
        return ChunkedAesCmacImpl.create(aesCmacKey);
    }

    private static Mac createAesCmac(AesCmacKey aesCmacKey) throws GeneralSecurityException {
        if (aesCmacKey.getParameters().getKeySizeBytes() != 32) {
            throw new GeneralSecurityException("AesCmac key size is not 32 bytes");
        }
        return PrfMac.create(aesCmacKey);
    }

    private static Key reparseLegacyProtoKey(Key key) throws GeneralSecurityException {
        return key instanceof LegacyProtoKey ? MutableSerializationRegistry.globalInstance().parseKey(((LegacyProtoKey) key).getSerialization(InsecureSecretKeyAccess.get()), InsecureSecretKeyAccess.get()) : key;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Mac createMac(KeysetHandleInterface.Entry entry) throws GeneralSecurityException {
        Key keyReparseLegacyProtoKey = reparseLegacyProtoKey(entry.getKey());
        if (keyReparseLegacyProtoKey instanceof AesCmacKey) {
            return createAesCmac((AesCmacKey) keyReparseLegacyProtoKey);
        }
        if (keyReparseLegacyProtoKey instanceof HmacKey) {
            return PrfMac.create((HmacKey) keyReparseLegacyProtoKey);
        }
        throw new GeneralSecurityException("Cannot create Mac for key " + keyReparseLegacyProtoKey);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ChunkedMac createChunkedMac(KeysetHandleInterface.Entry entry) throws GeneralSecurityException {
        Key keyReparseLegacyProtoKey = reparseLegacyProtoKey(entry.getKey());
        if (keyReparseLegacyProtoKey instanceof AesCmacKey) {
            return createChunkedAesCmac((AesCmacKey) keyReparseLegacyProtoKey);
        }
        if (keyReparseLegacyProtoKey instanceof HmacKey) {
            return new ChunkedHmacImpl((HmacKey) keyReparseLegacyProtoKey);
        }
        throw new GeneralSecurityException("Cannot create ChunkedMac for key " + keyReparseLegacyProtoKey);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Aead createAead(KeysetHandleInterface.Entry entry) throws GeneralSecurityException {
        Key keyReparseLegacyProtoKey = reparseLegacyProtoKey(entry.getKey());
        if (keyReparseLegacyProtoKey instanceof AesCtrHmacAeadKey) {
            return EncryptThenAuthenticate.create((AesCtrHmacAeadKey) keyReparseLegacyProtoKey);
        }
        if (keyReparseLegacyProtoKey instanceof AesEaxKey) {
            return AesEaxJce.create((AesEaxKey) keyReparseLegacyProtoKey);
        }
        if (keyReparseLegacyProtoKey instanceof AesGcmKey) {
            return AesGcmJce.create((AesGcmKey) keyReparseLegacyProtoKey);
        }
        if (keyReparseLegacyProtoKey instanceof AesGcmSivKey) {
            return AesGcmSiv.create((AesGcmSivKey) keyReparseLegacyProtoKey);
        }
        if (keyReparseLegacyProtoKey instanceof ChaCha20Poly1305Key) {
            return createChaCha20Poly1305((ChaCha20Poly1305Key) keyReparseLegacyProtoKey);
        }
        if (keyReparseLegacyProtoKey instanceof XChaCha20Poly1305Key) {
            return createXChaCha20Poly1305((XChaCha20Poly1305Key) keyReparseLegacyProtoKey);
        }
        throw new GeneralSecurityException("Cannot create Aead for key " + keyReparseLegacyProtoKey);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static DeterministicAead createDeterministicAead(KeysetHandleInterface.Entry entry) throws GeneralSecurityException {
        Key keyReparseLegacyProtoKey = reparseLegacyProtoKey(entry.getKey());
        if (keyReparseLegacyProtoKey instanceof AesSivKey) {
            return createAesSiv((AesSivKey) keyReparseLegacyProtoKey);
        }
        throw new GeneralSecurityException("Cannot create DeterministicAead for key " + keyReparseLegacyProtoKey);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static StreamingAead createStreamingAead(KeysetHandleInterface.Entry entry) throws GeneralSecurityException {
        Key keyReparseLegacyProtoKey = reparseLegacyProtoKey(entry.getKey());
        if (keyReparseLegacyProtoKey instanceof AesCtrHmacStreamingKey) {
            return AesCtrHmacStreaming.create((AesCtrHmacStreamingKey) keyReparseLegacyProtoKey);
        }
        if (keyReparseLegacyProtoKey instanceof AesGcmHkdfStreamingKey) {
            return AesGcmHkdfStreaming.create((AesGcmHkdfStreamingKey) keyReparseLegacyProtoKey);
        }
        throw new GeneralSecurityException("Cannot create StreamingAead for key " + keyReparseLegacyProtoKey);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static HybridEncrypt createHybridEncrypt(KeysetHandleInterface.Entry entry) throws GeneralSecurityException {
        Key keyReparseLegacyProtoKey = reparseLegacyProtoKey(entry.getKey());
        if (keyReparseLegacyProtoKey instanceof EciesPublicKey) {
            return EciesAeadHkdfHybridEncrypt.create((EciesPublicKey) keyReparseLegacyProtoKey);
        }
        if (keyReparseLegacyProtoKey instanceof HpkePublicKey) {
            return HpkeEncrypt.create((HpkePublicKey) keyReparseLegacyProtoKey);
        }
        throw new GeneralSecurityException("Cannot create HybridEncrypt for key " + keyReparseLegacyProtoKey);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static HybridDecrypt createHybridDecrypt(KeysetHandleInterface.Entry entry) throws GeneralSecurityException {
        Key keyReparseLegacyProtoKey = reparseLegacyProtoKey(entry.getKey());
        if (keyReparseLegacyProtoKey instanceof EciesPrivateKey) {
            return EciesAeadHkdfHybridDecrypt.create((EciesPrivateKey) keyReparseLegacyProtoKey);
        }
        if (keyReparseLegacyProtoKey instanceof HpkePrivateKey) {
            return HpkeDecrypt.create((HpkePrivateKey) keyReparseLegacyProtoKey);
        }
        throw new GeneralSecurityException("Cannot create HybridDecrypt for key " + keyReparseLegacyProtoKey);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Prf createPrf(KeysetHandleInterface.Entry entry) throws GeneralSecurityException {
        Key keyReparseLegacyProtoKey = reparseLegacyProtoKey(entry.getKey());
        if (keyReparseLegacyProtoKey instanceof AesCmacPrfKey) {
            return createAesCmacPrf((AesCmacPrfKey) keyReparseLegacyProtoKey);
        }
        if (keyReparseLegacyProtoKey instanceof HkdfPrfKey) {
            return createHkdfPrf((HkdfPrfKey) keyReparseLegacyProtoKey);
        }
        if (keyReparseLegacyProtoKey instanceof HmacPrfKey) {
            return PrfHmacJce.create((HmacPrfKey) keyReparseLegacyProtoKey);
        }
        throw new GeneralSecurityException("Cannot create Prf for key " + keyReparseLegacyProtoKey);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static PublicKeySign createPublicKeySign(KeysetHandleInterface.Entry entry) throws GeneralSecurityException {
        Key keyReparseLegacyProtoKey = reparseLegacyProtoKey(entry.getKey());
        if (keyReparseLegacyProtoKey instanceof EcdsaPrivateKey) {
            return EcdsaSignJce.create((EcdsaPrivateKey) keyReparseLegacyProtoKey);
        }
        if (keyReparseLegacyProtoKey instanceof Ed25519PrivateKey) {
            return Ed25519Sign.create((Ed25519PrivateKey) keyReparseLegacyProtoKey);
        }
        if (keyReparseLegacyProtoKey instanceof RsaSsaPkcs1PrivateKey) {
            return RsaSsaPkcs1SignJce.create((RsaSsaPkcs1PrivateKey) keyReparseLegacyProtoKey);
        }
        if (keyReparseLegacyProtoKey instanceof RsaSsaPssPrivateKey) {
            return RsaSsaPssSignJce.create((RsaSsaPssPrivateKey) keyReparseLegacyProtoKey);
        }
        throw new GeneralSecurityException("Cannot create PublicKeySign for key " + keyReparseLegacyProtoKey);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static PublicKeyVerify createPublicKeyVerify(KeysetHandleInterface.Entry entry) throws GeneralSecurityException {
        Key keyReparseLegacyProtoKey = reparseLegacyProtoKey(entry.getKey());
        if (keyReparseLegacyProtoKey instanceof EcdsaPublicKey) {
            return EcdsaVerifyJce.create((EcdsaPublicKey) keyReparseLegacyProtoKey);
        }
        if (keyReparseLegacyProtoKey instanceof Ed25519PublicKey) {
            return Ed25519Verify.create((Ed25519PublicKey) keyReparseLegacyProtoKey);
        }
        if (keyReparseLegacyProtoKey instanceof RsaSsaPkcs1PublicKey) {
            return RsaSsaPkcs1VerifyJce.create((RsaSsaPkcs1PublicKey) keyReparseLegacyProtoKey);
        }
        if (keyReparseLegacyProtoKey instanceof RsaSsaPssPublicKey) {
            return RsaSsaPssVerifyJce.create((RsaSsaPssPublicKey) keyReparseLegacyProtoKey);
        }
        throw new GeneralSecurityException("Cannot create PublicKeyVerify for key " + keyReparseLegacyProtoKey);
    }
}
