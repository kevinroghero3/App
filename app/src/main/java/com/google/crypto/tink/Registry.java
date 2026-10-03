package com.google.crypto.tink;

import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.KeyManagerRegistry;
import com.google.crypto.tink.internal.MutableParametersRegistry;
import com.google.crypto.tink.internal.MutablePrimitiveRegistry;
import com.google.crypto.tink.prf.Prf;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes5.dex */
public final class Registry {
    private static final Logger logger = Logger.getLogger(Registry.class.getName());
    private static final ConcurrentMap<String, Catalogue<?>> catalogueMap = new ConcurrentHashMap();
    private static final Set<Class<?>> ALLOWED_PRIMITIVES = Collections.unmodifiableSet(createAllowedPrimitives());

    static void reset() {
        synchronized (Registry.class) {
            KeyManagerRegistry.resetGlobalInstanceTestOnly();
            MutablePrimitiveRegistry.resetGlobalInstanceTestOnly();
            catalogueMap.clear();
        }
    }

    @Deprecated
    public static void addCatalogue(String str, Catalogue<?> catalogue) throws GeneralSecurityException {
        synchronized (Registry.class) {
            try {
                if (str == null) {
                    throw new IllegalArgumentException("catalogueName must be non-null.");
                }
                if (catalogue == null) {
                    throw new IllegalArgumentException("catalogue must be non-null.");
                }
                ConcurrentMap<String, Catalogue<?>> concurrentMap = catalogueMap;
                Locale locale = Locale.US;
                if (concurrentMap.containsKey(str.toLowerCase(locale))) {
                    if (!catalogue.getClass().getName().equals(concurrentMap.get(str.toLowerCase(locale)).getClass().getName())) {
                        logger.warning("Attempted overwrite of a catalogueName catalogue for name " + str);
                        throw new GeneralSecurityException("catalogue for name " + str + " has been already registered");
                    }
                }
                concurrentMap.put(str.toLowerCase(locale), catalogue);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Deprecated
    public static Catalogue<?> getCatalogue(String str) throws GeneralSecurityException {
        if (str == null) {
            throw new IllegalArgumentException("catalogueName must be non-null.");
        }
        ConcurrentMap<String, Catalogue<?>> concurrentMap = catalogueMap;
        Locale locale = Locale.US;
        Catalogue<?> catalogue = concurrentMap.get(str.toLowerCase(locale));
        if (catalogue != null) {
            return catalogue;
        }
        String str2 = String.format("no catalogue found for %s. ", str);
        if (str.toLowerCase(locale).startsWith("tinkaead")) {
            str2 = str2 + "Maybe call AeadConfig.register().";
        }
        if (str.toLowerCase(locale).startsWith("tinkdeterministicaead")) {
            str2 = str2 + "Maybe call DeterministicAeadConfig.register().";
        } else if (str.toLowerCase(locale).startsWith("tinkstreamingaead")) {
            str2 = str2 + "Maybe call StreamingAeadConfig.register().";
        } else if (str.toLowerCase(locale).startsWith("tinkhybriddecrypt") || str.toLowerCase(locale).startsWith("tinkhybridencrypt")) {
            str2 = str2 + "Maybe call HybridConfig.register().";
        } else if (str.toLowerCase(locale).startsWith("tinkmac")) {
            str2 = str2 + "Maybe call MacConfig.register().";
        } else if (str.toLowerCase(locale).startsWith("tinkpublickeysign") || str.toLowerCase(locale).startsWith("tinkpublickeyverify")) {
            str2 = str2 + "Maybe call SignatureConfig.register().";
        } else if (str.toLowerCase(locale).startsWith("tink")) {
            str2 = str2 + "Maybe call TinkConfig.register().";
        }
        throw new GeneralSecurityException(str2);
    }

    public static <P> void registerKeyManager(KeyManager<P> keyManager) throws GeneralSecurityException {
        synchronized (Registry.class) {
            registerKeyManager((KeyManager) keyManager, true);
        }
    }

    private static Set<Class<?>> createAllowedPrimitives() {
        HashSet hashSet = new HashSet();
        hashSet.add(Aead.class);
        hashSet.add(DeterministicAead.class);
        hashSet.add(StreamingAead.class);
        hashSet.add(HybridEncrypt.class);
        hashSet.add(HybridDecrypt.class);
        hashSet.add(Mac.class);
        hashSet.add(Prf.class);
        hashSet.add(PublicKeySign.class);
        hashSet.add(PublicKeyVerify.class);
        return hashSet;
    }

    public static <P> void registerKeyManager(KeyManager<P> keyManager, boolean z) throws GeneralSecurityException {
        synchronized (Registry.class) {
            try {
                if (keyManager == null) {
                    throw new IllegalArgumentException("key manager must be non-null.");
                }
                if (!ALLOWED_PRIMITIVES.contains(keyManager.getPrimitiveClass())) {
                    throw new GeneralSecurityException("Registration of key managers for class " + keyManager.getPrimitiveClass() + " has been disabled. Please file an issue on https://github.com/tink-crypto/tink-java");
                }
                if (!TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS.isCompatible()) {
                    throw new GeneralSecurityException("Registering key managers is not supported in FIPS mode");
                }
                KeyManagerRegistry.globalInstance().registerKeyManager(keyManager, z);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Deprecated
    public static <P> void registerKeyManager(String str, KeyManager<P> keyManager) throws GeneralSecurityException {
        synchronized (Registry.class) {
            registerKeyManager(str, keyManager, true);
        }
    }

    @Deprecated
    public static <P> void registerKeyManager(String str, KeyManager<P> keyManager, boolean z) throws GeneralSecurityException {
        synchronized (Registry.class) {
            try {
                if (keyManager == null) {
                    throw new IllegalArgumentException("key manager must be non-null.");
                }
                if (!str.equals(keyManager.getKeyType())) {
                    throw new GeneralSecurityException("Manager does not support key type " + str + ".");
                }
                registerKeyManager(keyManager, z);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Deprecated
    public static <P> KeyManager<P> getKeyManager(String str, Class<P> cls) throws GeneralSecurityException {
        return KeyManagerRegistry.globalInstance().getKeyManager(str, cls);
    }

    @Deprecated
    public static KeyManager<?> getUntypedKeyManager(String str) throws GeneralSecurityException {
        return KeyManagerRegistry.globalInstance().getUntypedKeyManager(str);
    }

    @Deprecated
    public static KeyData newKeyData(com.google.crypto.tink.proto.KeyTemplate keyTemplate) throws GeneralSecurityException {
        KeyData keyDataNewKeyData;
        synchronized (Registry.class) {
            KeyManager<?> untypedKeyManager = KeyManagerRegistry.globalInstance().getUntypedKeyManager(keyTemplate.getTypeUrl());
            if (KeyManagerRegistry.globalInstance().isNewKeyAllowed(keyTemplate.getTypeUrl())) {
                keyDataNewKeyData = untypedKeyManager.newKeyData(keyTemplate.getValue());
            } else {
                throw new GeneralSecurityException("newKey-operation not permitted for key type " + keyTemplate.getTypeUrl());
            }
        }
        return keyDataNewKeyData;
    }

    @Deprecated
    public static KeyData newKeyData(KeyTemplate keyTemplate) throws GeneralSecurityException {
        KeyData keyDataNewKeyData;
        synchronized (Registry.class) {
            try {
                keyDataNewKeyData = newKeyData(com.google.crypto.tink.proto.KeyTemplate.parseFrom(TinkProtoParametersFormat.serialize(keyTemplate.toParameters()), ExtensionRegistryLite.getEmptyRegistry()));
            } catch (InvalidProtocolBufferException e) {
                throw new GeneralSecurityException("Failed to parse serialized parameters", e);
            }
        }
        return keyDataNewKeyData;
    }

    @Deprecated
    public static MessageLite newKey(com.google.crypto.tink.proto.KeyTemplate keyTemplate) throws GeneralSecurityException {
        MessageLite messageLiteNewKey;
        synchronized (Registry.class) {
            KeyManager<?> untypedKeyManager = getUntypedKeyManager(keyTemplate.getTypeUrl());
            if (KeyManagerRegistry.globalInstance().isNewKeyAllowed(keyTemplate.getTypeUrl())) {
                messageLiteNewKey = untypedKeyManager.newKey(keyTemplate.getValue());
            } else {
                throw new GeneralSecurityException("newKey-operation not permitted for key type " + keyTemplate.getTypeUrl());
            }
        }
        return messageLiteNewKey;
    }

    @Deprecated
    public static MessageLite newKey(String str, MessageLite messageLite) throws GeneralSecurityException {
        MessageLite messageLiteNewKey;
        synchronized (Registry.class) {
            KeyManager<?> untypedKeyManager = getUntypedKeyManager(str);
            if (KeyManagerRegistry.globalInstance().isNewKeyAllowed(str)) {
                messageLiteNewKey = untypedKeyManager.newKey(messageLite);
            } else {
                throw new GeneralSecurityException("newKey-operation not permitted for key type " + str);
            }
        }
        return messageLiteNewKey;
    }

    @Deprecated
    public static KeyData getPublicKeyData(String str, ByteString byteString) throws GeneralSecurityException {
        KeyManager<?> untypedKeyManager = getUntypedKeyManager(str);
        if (!(untypedKeyManager instanceof PrivateKeyManager)) {
            throw new GeneralSecurityException("manager for key type " + str + " is not a PrivateKeyManager");
        }
        return ((PrivateKeyManager) untypedKeyManager).getPublicKeyData(byteString);
    }

    @Deprecated
    public static <P> P getPrimitive(String str, MessageLite messageLite, Class<P> cls) throws GeneralSecurityException {
        return KeyManagerRegistry.globalInstance().getKeyManager(str, cls).getPrimitive(messageLite.toByteString());
    }

    @Deprecated
    public static <P> P getPrimitive(String str, ByteString byteString, Class<P> cls) throws GeneralSecurityException {
        return KeyManagerRegistry.globalInstance().getKeyManager(str, cls).getPrimitive(byteString);
    }

    @Deprecated
    public static <P> P getPrimitive(String str, byte[] bArr, Class<P> cls) throws GeneralSecurityException {
        return (P) getPrimitive(str, ByteString.copyFrom(bArr), cls);
    }

    @Deprecated
    public static <P> P getPrimitive(KeyData keyData, Class<P> cls) throws GeneralSecurityException {
        return (P) getPrimitive(keyData.getTypeUrl(), keyData.getValue(), cls);
    }

    static <KeyT extends Key, P> P getFullPrimitive(KeyT keyt, Class<P> cls) throws GeneralSecurityException {
        return (P) MutablePrimitiveRegistry.globalInstance().getPrimitive(keyt, cls);
    }

    public static List<String> keyTemplates() {
        List<String> names;
        synchronized (Registry.class) {
            names = MutableParametersRegistry.globalInstance().getNames();
        }
        return names;
    }

    public static void restrictToFipsIfEmpty() throws GeneralSecurityException {
        synchronized (Registry.class) {
            KeyManagerRegistry.globalInstance().restrictToFipsIfEmptyAndGlobalInstance();
        }
    }

    private Registry() {
    }
}
