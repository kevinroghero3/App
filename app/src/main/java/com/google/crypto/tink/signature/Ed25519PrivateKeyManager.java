package com.google.crypto.tink.signature;

import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.Key;
import com.google.crypto.tink.KeyManager;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.PrivateKeyManager;
import com.google.crypto.tink.PublicKeySign;
import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.SecretKeyAccess;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.KeyCreator;
import com.google.crypto.tink.internal.KeyManagerRegistry;
import com.google.crypto.tink.internal.LegacyKeyManagerImpl;
import com.google.crypto.tink.internal.MutableKeyCreationRegistry;
import com.google.crypto.tink.internal.MutableKeyDerivationRegistry;
import com.google.crypto.tink.internal.MutableParametersRegistry;
import com.google.crypto.tink.internal.MutablePrimitiveRegistry;
import com.google.crypto.tink.internal.PrimitiveConstructor;
import com.google.crypto.tink.internal.TinkBugException;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.signature.internal.Ed25519ProtoSerialization;
import com.google.crypto.tink.subtle.Ed25519Sign;
import com.google.crypto.tink.subtle.Ed25519Verify;
import com.google.crypto.tink.util.Bytes;
import com.google.crypto.tink.util.SecretBytes;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class Ed25519PrivateKeyManager {
    private static final PrimitiveConstructor<Ed25519PrivateKey, PublicKeySign> PUBLIC_KEY_SIGN_PRIMITIVE_CONSTRUCTOR = PrimitiveConstructor.create(new PrimitiveConstructor.PrimitiveConstructionFunction() { // from class: com.google.crypto.tink.signature.Ed25519PrivateKeyManager$$ExternalSyntheticLambda2
        @Override // com.google.crypto.tink.internal.PrimitiveConstructor.PrimitiveConstructionFunction
        public final Object constructPrimitive(Key key) {
            return Ed25519Sign.create((Ed25519PrivateKey) key);
        }
    }, Ed25519PrivateKey.class, PublicKeySign.class);
    private static final PrimitiveConstructor<Ed25519PublicKey, PublicKeyVerify> PUBLIC_KEY_VERIFY_PRIMITIVE_CONSTRUCTOR = PrimitiveConstructor.create(new PrimitiveConstructor.PrimitiveConstructionFunction() { // from class: com.google.crypto.tink.signature.Ed25519PrivateKeyManager$$ExternalSyntheticLambda3
        @Override // com.google.crypto.tink.internal.PrimitiveConstructor.PrimitiveConstructionFunction
        public final Object constructPrimitive(Key key) {
            return Ed25519Verify.create((Ed25519PublicKey) key);
        }
    }, Ed25519PublicKey.class, PublicKeyVerify.class);
    private static final PrivateKeyManager<PublicKeySign> legacyPrivateKeyManager = LegacyKeyManagerImpl.createPrivateKeyManager(getKeyType(), PublicKeySign.class, com.google.crypto.tink.proto.Ed25519PrivateKey.parser());
    private static final KeyManager<PublicKeyVerify> legacyPublicKeyManager = LegacyKeyManagerImpl.create(Ed25519PublicKeyManager.getKeyType(), PublicKeyVerify.class, KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC, com.google.crypto.tink.proto.Ed25519PublicKey.parser());
    private static final MutableKeyDerivationRegistry.InsecureKeyCreator<Ed25519Parameters> KEY_DERIVER = new MutableKeyDerivationRegistry.InsecureKeyCreator() { // from class: com.google.crypto.tink.signature.Ed25519PrivateKeyManager$$ExternalSyntheticLambda4
        @Override // com.google.crypto.tink.internal.MutableKeyDerivationRegistry.InsecureKeyCreator
        public final Key createKeyFromRandomness(Parameters parameters, InputStream inputStream, Integer num, SecretKeyAccess secretKeyAccess) {
            return Ed25519PrivateKeyManager.createEd25519KeyFromRandomness((Ed25519Parameters) parameters, inputStream, num, secretKeyAccess);
        }
    };
    private static final KeyCreator<Ed25519Parameters> KEY_CREATOR = new KeyCreator() { // from class: com.google.crypto.tink.signature.Ed25519PrivateKeyManager$$ExternalSyntheticLambda5
        @Override // com.google.crypto.tink.internal.KeyCreator
        public final Key createKey(Parameters parameters, Integer num) {
            return Ed25519PrivateKeyManager.createEd25519Key((Ed25519Parameters) parameters, num);
        }
    };

    static String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.Ed25519PrivateKey";
    }

    static Ed25519PrivateKey createEd25519KeyFromRandomness(Ed25519Parameters ed25519Parameters, InputStream inputStream, @Nullable Integer num, SecretKeyAccess secretKeyAccess) throws GeneralSecurityException {
        Ed25519Sign.KeyPair keyPairNewKeyPairFromSeed = Ed25519Sign.KeyPair.newKeyPairFromSeed(Util.readIntoSecretBytes(inputStream, 32, secretKeyAccess).toByteArray(secretKeyAccess));
        return Ed25519PrivateKey.create(Ed25519PublicKey.create(ed25519Parameters.getVariant(), Bytes.copyFrom(keyPairNewKeyPairFromSeed.getPublicKey()), num), SecretBytes.copyFrom(keyPairNewKeyPairFromSeed.getPrivateKey(), secretKeyAccess));
    }

    static Ed25519PrivateKey createEd25519Key(Ed25519Parameters ed25519Parameters, @Nullable Integer num) throws GeneralSecurityException {
        Ed25519Sign.KeyPair keyPairNewKeyPair = Ed25519Sign.KeyPair.newKeyPair();
        return Ed25519PrivateKey.create(Ed25519PublicKey.create(ed25519Parameters.getVariant(), Bytes.copyFrom(keyPairNewKeyPair.getPublicKey()), num), SecretBytes.copyFrom(keyPairNewKeyPair.getPrivateKey(), InsecureSecretKeyAccess.get()));
    }

    private static Map<String, Parameters> namedParameters() throws GeneralSecurityException {
        HashMap map = new HashMap();
        map.put("ED25519", Ed25519Parameters.create(Ed25519Parameters.Variant.TINK));
        Ed25519Parameters.Variant variant = Ed25519Parameters.Variant.NO_PREFIX;
        map.put("ED25519_RAW", Ed25519Parameters.create(variant));
        map.put("ED25519WithRawOutput", Ed25519Parameters.create(variant));
        return Collections.unmodifiableMap(map);
    }

    public static void registerPair(boolean z) throws GeneralSecurityException {
        if (!TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS.isCompatible()) {
            throw new GeneralSecurityException("Registering AES GCM SIV is not supported in FIPS mode");
        }
        Ed25519ProtoSerialization.register();
        MutableParametersRegistry.globalInstance().putAll(namedParameters());
        MutableKeyCreationRegistry.globalInstance().add(KEY_CREATOR, Ed25519Parameters.class);
        MutableKeyDerivationRegistry.globalInstance().add(KEY_DERIVER, Ed25519Parameters.class);
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(PUBLIC_KEY_SIGN_PRIMITIVE_CONSTRUCTOR);
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(PUBLIC_KEY_VERIFY_PRIMITIVE_CONSTRUCTOR);
        KeyManagerRegistry.globalInstance().registerKeyManager(legacyPrivateKeyManager, z);
        KeyManagerRegistry.globalInstance().registerKeyManager(legacyPublicKeyManager, false);
    }

    public static final KeyTemplate ed25519Template() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.signature.Ed25519PrivateKeyManager$$ExternalSyntheticLambda1
            @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
            public final Object get() {
                return Ed25519PrivateKeyManager.lambda$ed25519Template$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ KeyTemplate lambda$ed25519Template$0() throws Exception {
        return KeyTemplate.createFrom(Ed25519Parameters.create(Ed25519Parameters.Variant.TINK));
    }

    public static final KeyTemplate rawEd25519Template() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.signature.Ed25519PrivateKeyManager$$ExternalSyntheticLambda0
            @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
            public final Object get() {
                return Ed25519PrivateKeyManager.lambda$rawEd25519Template$1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ KeyTemplate lambda$rawEd25519Template$1() throws Exception {
        return KeyTemplate.createFrom(Ed25519Parameters.create(Ed25519Parameters.Variant.NO_PREFIX));
    }

    private Ed25519PrivateKeyManager() {
    }
}
