package com.google.crypto.tink.aead;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.Key;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.TinkProtoParametersFormat;
import com.google.crypto.tink.internal.MutableKeyCreationRegistry;
import com.google.crypto.tink.internal.MutablePrimitiveRegistry;
import com.google.crypto.tink.internal.MutableSerializationRegistry;
import com.google.crypto.tink.internal.ProtoKeySerialization;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class KmsEnvelopeAead implements Aead {
    private static final int LENGTH_ENCRYPTED_DEK = 4;
    private static final int MAX_LENGTH_ENCRYPTED_DEK = 4096;
    private final Parameters parametersForNewKeys;
    private final Aead remote;
    private final String typeUrlForParsing;
    private static final byte[] EMPTY_AAD = new byte[0];
    private static final Set<String> supportedDekKeyTypes = listSupportedDekKeyTypes();

    private static Set<String> listSupportedDekKeyTypes() {
        HashSet hashSet = new HashSet();
        hashSet.add("type.googleapis.com/google.crypto.tink.AesGcmKey");
        hashSet.add("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
        hashSet.add("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
        hashSet.add("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
        hashSet.add("type.googleapis.com/google.crypto.tink.AesGcmSivKey");
        hashSet.add("type.googleapis.com/google.crypto.tink.AesEaxKey");
        return Collections.unmodifiableSet(hashSet);
    }

    public static boolean isSupportedDekKeyType(String str) {
        return supportedDekKeyTypes.contains(str);
    }

    private Parameters getRawParameters(KeyTemplate keyTemplate) throws GeneralSecurityException {
        return TinkProtoParametersFormat.parse(KeyTemplate.newBuilder(keyTemplate).setOutputPrefixType(OutputPrefixType.RAW).build().toByteArray());
    }

    @Deprecated
    public KmsEnvelopeAead(KeyTemplate keyTemplate, Aead aead) throws GeneralSecurityException {
        if (!isSupportedDekKeyType(keyTemplate.getTypeUrl())) {
            throw new IllegalArgumentException("Unsupported DEK key type: " + keyTemplate.getTypeUrl() + ". Only Tink AEAD key types are supported.");
        }
        this.typeUrlForParsing = keyTemplate.getTypeUrl();
        this.parametersForNewKeys = getRawParameters(keyTemplate);
        this.remote = aead;
    }

    public static Aead create(AeadParameters aeadParameters, Aead aead) throws GeneralSecurityException {
        try {
            return new KmsEnvelopeAead(KeyTemplate.parseFrom(TinkProtoParametersFormat.serialize(aeadParameters), ExtensionRegistryLite.getEmptyRegistry()), aead);
        } catch (InvalidProtocolBufferException e) {
            throw new GeneralSecurityException(e);
        }
    }

    @Override // com.google.crypto.tink.Aead
    public byte[] encrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        Key keyCreateKey = MutableKeyCreationRegistry.globalInstance().createKey(this.parametersForNewKeys, null);
        byte[] bArrEncrypt = this.remote.encrypt(((ProtoKeySerialization) MutableSerializationRegistry.globalInstance().serializeKey(keyCreateKey, ProtoKeySerialization.class, InsecureSecretKeyAccess.get())).getValue().toByteArray(), EMPTY_AAD);
        if (bArrEncrypt.length > 4096) {
            throw new GeneralSecurityException("length of encrypted DEK too large");
        }
        return buildCiphertext(bArrEncrypt, ((Aead) MutablePrimitiveRegistry.globalInstance().getPrimitive(keyCreateKey, Aead.class)).encrypt(bArr, bArr2));
    }

    @Override // com.google.crypto.tink.Aead
    public byte[] decrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        try {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
            int i = byteBufferWrap.getInt();
            if (i <= 0 || i > 4096 || i > bArr.length - 4) {
                throw new GeneralSecurityException("length of encrypted DEK too large");
            }
            byte[] bArr3 = new byte[i];
            byteBufferWrap.get(bArr3, 0, i);
            byte[] bArr4 = new byte[byteBufferWrap.remaining()];
            byteBufferWrap.get(bArr4, 0, byteBufferWrap.remaining());
            return ((Aead) MutablePrimitiveRegistry.globalInstance().getPrimitive(MutableSerializationRegistry.globalInstance().parseKey(ProtoKeySerialization.create(this.typeUrlForParsing, ByteString.copyFrom(this.remote.decrypt(bArr3, EMPTY_AAD)), KeyData.KeyMaterialType.SYMMETRIC, OutputPrefixType.RAW, null), InsecureSecretKeyAccess.get()), Aead.class)).decrypt(bArr4, bArr2);
        } catch (IndexOutOfBoundsException | NegativeArraySizeException | BufferUnderflowException e) {
            throw new GeneralSecurityException("invalid ciphertext", e);
        }
    }

    private byte[] buildCiphertext(byte[] bArr, byte[] bArr2) {
        return ByteBuffer.allocate(bArr.length + 4 + bArr2.length).putInt(bArr.length).put(bArr).put(bArr2).array();
    }
}
