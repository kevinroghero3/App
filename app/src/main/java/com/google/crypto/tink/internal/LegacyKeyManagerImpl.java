package com.google.crypto.tink.internal;

import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.KeyManager;
import com.google.crypto.tink.PrivateKey;
import com.google.crypto.tink.PrivateKeyManager;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes2.dex */
public class LegacyKeyManagerImpl<P> implements KeyManager<P> {
    final KeyData.KeyMaterialType keyMaterialType;
    final Class<P> primitiveClass;
    final Parser<? extends MessageLite> protobufKeyParser;
    final String typeUrl;

    @Override // com.google.crypto.tink.KeyManager
    public int getVersion() {
        return 0;
    }

    public static <P> KeyManager<P> create(String str, Class<P> cls, KeyData.KeyMaterialType keyMaterialType, Parser<? extends MessageLite> parser) {
        return new LegacyKeyManagerImpl(str, cls, keyMaterialType, parser);
    }

    LegacyKeyManagerImpl(String str, Class<P> cls, KeyData.KeyMaterialType keyMaterialType, Parser<? extends MessageLite> parser) {
        this.protobufKeyParser = parser;
        this.typeUrl = str;
        this.primitiveClass = cls;
        this.keyMaterialType = keyMaterialType;
    }

    @Override // com.google.crypto.tink.KeyManager
    public P getPrimitive(ByteString byteString) throws GeneralSecurityException {
        return (P) MutablePrimitiveRegistry.globalInstance().getPrimitive(MutableSerializationRegistry.globalInstance().parseKey(ProtoKeySerialization.create(this.typeUrl, byteString, this.keyMaterialType, OutputPrefixType.RAW, null), InsecureSecretKeyAccess.get()), this.primitiveClass);
    }

    @Override // com.google.crypto.tink.KeyManager
    public final P getPrimitive(MessageLite messageLite) throws GeneralSecurityException {
        return getPrimitive(messageLite.toByteString());
    }

    @Override // com.google.crypto.tink.KeyManager
    public final MessageLite newKey(ByteString byteString) throws GeneralSecurityException {
        try {
            return this.protobufKeyParser.parseFrom(newKeyData(byteString).getValue(), ExtensionRegistryLite.getEmptyRegistry());
        } catch (InvalidProtocolBufferException unused) {
            throw new GeneralSecurityException("Unexpectedly failed to parse key");
        }
    }

    @Override // com.google.crypto.tink.KeyManager
    public final MessageLite newKey(MessageLite messageLite) throws GeneralSecurityException {
        return newKey(messageLite.toByteString());
    }

    @Override // com.google.crypto.tink.KeyManager
    public final boolean doesSupport(String str) {
        return str.equals(getKeyType());
    }

    @Override // com.google.crypto.tink.KeyManager
    public final String getKeyType() {
        return this.typeUrl;
    }

    @Override // com.google.crypto.tink.KeyManager
    public final KeyData newKeyData(ByteString byteString) throws GeneralSecurityException {
        ProtoKeySerialization protoKeySerialization = (ProtoKeySerialization) MutableSerializationRegistry.globalInstance().serializeKey(MutableKeyCreationRegistry.globalInstance().createKey(MutableSerializationRegistry.globalInstance().parseParameters(ProtoParametersSerialization.checkedCreate(KeyTemplate.newBuilder().setTypeUrl(this.typeUrl).setValue(byteString).setOutputPrefixType(OutputPrefixType.RAW).build())), null), ProtoKeySerialization.class, InsecureSecretKeyAccess.get());
        return KeyData.newBuilder().setTypeUrl(protoKeySerialization.getTypeUrl()).setValue(protoKeySerialization.getValue()).setKeyMaterialType(protoKeySerialization.getKeyMaterialType()).build();
    }

    @Override // com.google.crypto.tink.KeyManager
    public final Class<P> getPrimitiveClass() {
        return this.primitiveClass;
    }

    static class LegacyPrivateKeyManagerImpl<P> extends LegacyKeyManagerImpl<P> implements PrivateKeyManager<P> {
        LegacyPrivateKeyManagerImpl(String str, Class<P> cls, Parser<? extends MessageLite> parser) {
            super(str, cls, KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE, parser);
        }

        @Override // com.google.crypto.tink.PrivateKeyManager
        public KeyData getPublicKeyData(ByteString byteString) throws GeneralSecurityException {
            Object key = MutableSerializationRegistry.globalInstance().parseKey(ProtoKeySerialization.create(this.typeUrl, byteString, this.keyMaterialType, OutputPrefixType.RAW, null), InsecureSecretKeyAccess.get());
            if (!(key instanceof PrivateKey)) {
                throw new GeneralSecurityException("Key not private key");
            }
            ProtoKeySerialization protoKeySerialization = (ProtoKeySerialization) MutableSerializationRegistry.globalInstance().serializeKey(((PrivateKey) key).getPublicKey(), ProtoKeySerialization.class, InsecureSecretKeyAccess.get());
            return KeyData.newBuilder().setTypeUrl(protoKeySerialization.getTypeUrl()).setValue(protoKeySerialization.getValue()).setKeyMaterialType(protoKeySerialization.getKeyMaterialType()).build();
        }
    }

    public static <P> PrivateKeyManager<P> createPrivateKeyManager(String str, Class<P> cls, Parser<? extends MessageLite> parser) {
        return new LegacyPrivateKeyManagerImpl(str, cls, parser);
    }
}
