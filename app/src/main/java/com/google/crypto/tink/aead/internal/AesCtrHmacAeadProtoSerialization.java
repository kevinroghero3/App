package com.google.crypto.tink.aead.internal;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.SecretKeyAccess;
import com.google.crypto.tink.aead.AesCtrHmacAeadKey;
import com.google.crypto.tink.aead.AesCtrHmacAeadParameters;
import com.google.crypto.tink.internal.KeyParser;
import com.google.crypto.tink.internal.KeySerializer;
import com.google.crypto.tink.internal.MutableSerializationRegistry;
import com.google.crypto.tink.internal.ParametersParser;
import com.google.crypto.tink.internal.ParametersSerializer;
import com.google.crypto.tink.internal.ProtoKeySerialization;
import com.google.crypto.tink.internal.ProtoParametersSerialization;
import com.google.crypto.tink.internal.Serialization;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.proto.AesCtrHmacAeadKeyFormat;
import com.google.crypto.tink.proto.AesCtrKey;
import com.google.crypto.tink.proto.AesCtrKeyFormat;
import com.google.crypto.tink.proto.AesCtrParams;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.HmacKey;
import com.google.crypto.tink.proto.HmacKeyFormat;
import com.google.crypto.tink.proto.HmacParams;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.util.Bytes;
import com.google.crypto.tink.util.SecretBytes;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class AesCtrHmacAeadProtoSerialization {
    private static final KeyParser<ProtoKeySerialization> KEY_PARSER;
    private static final KeySerializer<AesCtrHmacAeadKey, ProtoKeySerialization> KEY_SERIALIZER;
    private static final ParametersParser<ProtoParametersSerialization> PARAMETERS_PARSER;
    private static final ParametersSerializer<AesCtrHmacAeadParameters, ProtoParametersSerialization> PARAMETERS_SERIALIZER;
    private static final String TYPE_URL = "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
    private static final Bytes TYPE_URL_BYTES;

    static {
        Bytes bytesFromPrintableAscii = Util.toBytesFromPrintableAscii(TYPE_URL);
        TYPE_URL_BYTES = bytesFromPrintableAscii;
        PARAMETERS_SERIALIZER = ParametersSerializer.create(new ParametersSerializer.ParametersSerializationFunction() { // from class: com.google.crypto.tink.aead.internal.AesCtrHmacAeadProtoSerialization$$ExternalSyntheticLambda0
            @Override // com.google.crypto.tink.internal.ParametersSerializer.ParametersSerializationFunction
            public final Serialization serializeParameters(Parameters parameters) {
                return AesCtrHmacAeadProtoSerialization.serializeParameters((AesCtrHmacAeadParameters) parameters);
            }
        }, AesCtrHmacAeadParameters.class, ProtoParametersSerialization.class);
        PARAMETERS_PARSER = ParametersParser.create(new ParametersParser.ParametersParsingFunction() { // from class: com.google.crypto.tink.aead.internal.AesCtrHmacAeadProtoSerialization$$ExternalSyntheticLambda1
            @Override // com.google.crypto.tink.internal.ParametersParser.ParametersParsingFunction
            public final Parameters parseParameters(Serialization serialization) {
                return AesCtrHmacAeadProtoSerialization.parseParameters((ProtoParametersSerialization) serialization);
            }
        }, bytesFromPrintableAscii, ProtoParametersSerialization.class);
        KEY_SERIALIZER = KeySerializer.create(new KeySerializer.KeySerializationFunction() { // from class: com.google.crypto.tink.aead.internal.AesCtrHmacAeadProtoSerialization$$ExternalSyntheticLambda2
            @Override // com.google.crypto.tink.internal.KeySerializer.KeySerializationFunction
            public final Serialization serializeKey(Key key, SecretKeyAccess secretKeyAccess) {
                return AesCtrHmacAeadProtoSerialization.serializeKey((AesCtrHmacAeadKey) key, secretKeyAccess);
            }
        }, AesCtrHmacAeadKey.class, ProtoKeySerialization.class);
        KEY_PARSER = KeyParser.create(new KeyParser.KeyParsingFunction() { // from class: com.google.crypto.tink.aead.internal.AesCtrHmacAeadProtoSerialization$$ExternalSyntheticLambda3
            @Override // com.google.crypto.tink.internal.KeyParser.KeyParsingFunction
            public final Key parseKey(Serialization serialization, SecretKeyAccess secretKeyAccess) {
                return AesCtrHmacAeadProtoSerialization.parseKey((ProtoKeySerialization) serialization, secretKeyAccess);
            }
        }, bytesFromPrintableAscii, ProtoKeySerialization.class);
    }

    private static OutputPrefixType toProtoOutputPrefixType(AesCtrHmacAeadParameters.Variant variant) throws GeneralSecurityException {
        if (AesCtrHmacAeadParameters.Variant.TINK.equals(variant)) {
            return OutputPrefixType.TINK;
        }
        if (AesCtrHmacAeadParameters.Variant.CRUNCHY.equals(variant)) {
            return OutputPrefixType.CRUNCHY;
        }
        if (AesCtrHmacAeadParameters.Variant.NO_PREFIX.equals(variant)) {
            return OutputPrefixType.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: " + variant);
    }

    private static AesCtrHmacAeadParameters.Variant toVariant(OutputPrefixType outputPrefixType) throws GeneralSecurityException {
        int i = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[outputPrefixType.ordinal()];
        if (i == 1) {
            return AesCtrHmacAeadParameters.Variant.TINK;
        }
        if (i == 2 || i == 3) {
            return AesCtrHmacAeadParameters.Variant.CRUNCHY;
        }
        if (i == 4) {
            return AesCtrHmacAeadParameters.Variant.NO_PREFIX;
        }
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + outputPrefixType.getNumber());
    }

    private static HashType toProtoHashType(AesCtrHmacAeadParameters.HashType hashType) throws GeneralSecurityException {
        if (AesCtrHmacAeadParameters.HashType.SHA1.equals(hashType)) {
            return HashType.SHA1;
        }
        if (AesCtrHmacAeadParameters.HashType.SHA224.equals(hashType)) {
            return HashType.SHA224;
        }
        if (AesCtrHmacAeadParameters.HashType.SHA256.equals(hashType)) {
            return HashType.SHA256;
        }
        if (AesCtrHmacAeadParameters.HashType.SHA384.equals(hashType)) {
            return HashType.SHA384;
        }
        if (AesCtrHmacAeadParameters.HashType.SHA512.equals(hashType)) {
            return HashType.SHA512;
        }
        throw new GeneralSecurityException("Unable to serialize HashType " + hashType);
    }

    /* JADX INFO: renamed from: com.google.crypto.tink.aead.internal.AesCtrHmacAeadProtoSerialization$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$HashType;
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType;

        static {
            int[] iArr = new int[HashType.values().length];
            $SwitchMap$com$google$crypto$tink$proto$HashType = iArr;
            try {
                iArr[HashType.SHA1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$HashType[HashType.SHA224.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$HashType[HashType.SHA256.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$HashType[HashType.SHA384.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$HashType[HashType.SHA512.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[OutputPrefixType.values().length];
            $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType = iArr2;
            try {
                iArr2[OutputPrefixType.TINK.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[OutputPrefixType.CRUNCHY.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[OutputPrefixType.LEGACY.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[OutputPrefixType.RAW.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    private static AesCtrHmacAeadParameters.HashType toHashType(HashType hashType) throws GeneralSecurityException {
        int i = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$HashType[hashType.ordinal()];
        if (i == 1) {
            return AesCtrHmacAeadParameters.HashType.SHA1;
        }
        if (i == 2) {
            return AesCtrHmacAeadParameters.HashType.SHA224;
        }
        if (i == 3) {
            return AesCtrHmacAeadParameters.HashType.SHA256;
        }
        if (i == 4) {
            return AesCtrHmacAeadParameters.HashType.SHA384;
        }
        if (i == 5) {
            return AesCtrHmacAeadParameters.HashType.SHA512;
        }
        throw new GeneralSecurityException("Unable to parse HashType: " + hashType.getNumber());
    }

    private static HmacParams getHmacProtoParams(AesCtrHmacAeadParameters aesCtrHmacAeadParameters) throws GeneralSecurityException {
        return HmacParams.newBuilder().setTagSize(aesCtrHmacAeadParameters.getTagSizeBytes()).setHash(toProtoHashType(aesCtrHmacAeadParameters.getHashType())).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ProtoParametersSerialization serializeParameters(AesCtrHmacAeadParameters aesCtrHmacAeadParameters) throws GeneralSecurityException {
        return ProtoParametersSerialization.create(KeyTemplate.newBuilder().setTypeUrl(TYPE_URL).setValue(AesCtrHmacAeadKeyFormat.newBuilder().setAesCtrKeyFormat(AesCtrKeyFormat.newBuilder().setParams(AesCtrParams.newBuilder().setIvSize(aesCtrHmacAeadParameters.getIvSizeBytes()).build()).setKeySize(aesCtrHmacAeadParameters.getAesKeySizeBytes()).build()).setHmacKeyFormat(HmacKeyFormat.newBuilder().setParams(getHmacProtoParams(aesCtrHmacAeadParameters)).setKeySize(aesCtrHmacAeadParameters.getHmacKeySizeBytes()).build()).build().toByteString()).setOutputPrefixType(toProtoOutputPrefixType(aesCtrHmacAeadParameters.getVariant())).build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ProtoKeySerialization serializeKey(AesCtrHmacAeadKey aesCtrHmacAeadKey, @Nullable SecretKeyAccess secretKeyAccess) throws GeneralSecurityException {
        return ProtoKeySerialization.create(TYPE_URL, com.google.crypto.tink.proto.AesCtrHmacAeadKey.newBuilder().setAesCtrKey(AesCtrKey.newBuilder().setParams(AesCtrParams.newBuilder().setIvSize(aesCtrHmacAeadKey.getParameters().getIvSizeBytes()).build()).setKeyValue(ByteString.copyFrom(aesCtrHmacAeadKey.getAesKeyBytes().toByteArray(SecretKeyAccess.requireAccess(secretKeyAccess)))).build()).setHmacKey(HmacKey.newBuilder().setParams(getHmacProtoParams(aesCtrHmacAeadKey.getParameters())).setKeyValue(ByteString.copyFrom(aesCtrHmacAeadKey.getHmacKeyBytes().toByteArray(SecretKeyAccess.requireAccess(secretKeyAccess)))).build()).build().toByteString(), KeyData.KeyMaterialType.SYMMETRIC, toProtoOutputPrefixType(aesCtrHmacAeadKey.getParameters().getVariant()), aesCtrHmacAeadKey.getIdRequirementOrNull());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AesCtrHmacAeadParameters parseParameters(ProtoParametersSerialization protoParametersSerialization) throws GeneralSecurityException {
        if (!protoParametersSerialization.getKeyTemplate().getTypeUrl().equals(TYPE_URL)) {
            throw new IllegalArgumentException("Wrong type URL in call to AesCtrHmacAeadProtoSerialization.parseParameters: " + protoParametersSerialization.getKeyTemplate().getTypeUrl());
        }
        try {
            AesCtrHmacAeadKeyFormat from = AesCtrHmacAeadKeyFormat.parseFrom(protoParametersSerialization.getKeyTemplate().getValue(), ExtensionRegistryLite.getEmptyRegistry());
            if (from.getHmacKeyFormat().getVersion() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            return AesCtrHmacAeadParameters.builder().setAesKeySizeBytes(from.getAesCtrKeyFormat().getKeySize()).setHmacKeySizeBytes(from.getHmacKeyFormat().getKeySize()).setIvSizeBytes(from.getAesCtrKeyFormat().getParams().getIvSize()).setTagSizeBytes(from.getHmacKeyFormat().getParams().getTagSize()).setHashType(toHashType(from.getHmacKeyFormat().getParams().getHash())).setVariant(toVariant(protoParametersSerialization.getKeyTemplate().getOutputPrefixType())).build();
        } catch (InvalidProtocolBufferException e) {
            throw new GeneralSecurityException("Parsing AesCtrHmacAeadParameters failed: ", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AesCtrHmacAeadKey parseKey(ProtoKeySerialization protoKeySerialization, @Nullable SecretKeyAccess secretKeyAccess) throws GeneralSecurityException {
        if (!protoKeySerialization.getTypeUrl().equals(TYPE_URL)) {
            throw new IllegalArgumentException("Wrong type URL in call to AesCtrHmacAeadProtoSerialization.parseKey");
        }
        try {
            com.google.crypto.tink.proto.AesCtrHmacAeadKey from = com.google.crypto.tink.proto.AesCtrHmacAeadKey.parseFrom(protoKeySerialization.getValue(), ExtensionRegistryLite.getEmptyRegistry());
            if (from.getVersion() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            if (from.getAesCtrKey().getVersion() != 0) {
                throw new GeneralSecurityException("Only version 0 keys inner AES CTR keys are accepted");
            }
            if (from.getHmacKey().getVersion() != 0) {
                throw new GeneralSecurityException("Only version 0 keys inner HMAC keys are accepted");
            }
            return AesCtrHmacAeadKey.builder().setParameters(AesCtrHmacAeadParameters.builder().setAesKeySizeBytes(from.getAesCtrKey().getKeyValue().size()).setHmacKeySizeBytes(from.getHmacKey().getKeyValue().size()).setIvSizeBytes(from.getAesCtrKey().getParams().getIvSize()).setTagSizeBytes(from.getHmacKey().getParams().getTagSize()).setHashType(toHashType(from.getHmacKey().getParams().getHash())).setVariant(toVariant(protoKeySerialization.getOutputPrefixType())).build()).setAesKeyBytes(SecretBytes.copyFrom(from.getAesCtrKey().getKeyValue().toByteArray(), SecretKeyAccess.requireAccess(secretKeyAccess))).setHmacKeyBytes(SecretBytes.copyFrom(from.getHmacKey().getKeyValue().toByteArray(), SecretKeyAccess.requireAccess(secretKeyAccess))).setIdRequirement(protoKeySerialization.getIdRequirementOrNull()).build();
        } catch (InvalidProtocolBufferException unused) {
            throw new GeneralSecurityException("Parsing AesCtrHmacAeadKey failed");
        }
    }

    public static void register() throws GeneralSecurityException {
        register(MutableSerializationRegistry.globalInstance());
    }

    public static void register(MutableSerializationRegistry mutableSerializationRegistry) throws GeneralSecurityException {
        mutableSerializationRegistry.registerParametersSerializer(PARAMETERS_SERIALIZER);
        mutableSerializationRegistry.registerParametersParser(PARAMETERS_PARSER);
        mutableSerializationRegistry.registerKeySerializer(KEY_SERIALIZER);
        mutableSerializationRegistry.registerKeyParser(KEY_PARSER);
    }

    private AesCtrHmacAeadProtoSerialization() {
    }
}
