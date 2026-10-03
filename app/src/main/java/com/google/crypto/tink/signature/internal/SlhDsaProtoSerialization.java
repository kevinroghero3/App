package com.google.crypto.tink.signature.internal;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.SecretKeyAccess;
import com.google.crypto.tink.internal.EnumTypeProtoConverter;
import com.google.crypto.tink.internal.KeyParser;
import com.google.crypto.tink.internal.KeySerializer;
import com.google.crypto.tink.internal.MutableSerializationRegistry;
import com.google.crypto.tink.internal.ParametersParser;
import com.google.crypto.tink.internal.ParametersSerializer;
import com.google.crypto.tink.internal.ProtoKeySerialization;
import com.google.crypto.tink.internal.ProtoParametersSerialization;
import com.google.crypto.tink.internal.Serialization;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.proto.SlhDsaHashType;
import com.google.crypto.tink.proto.SlhDsaKeyFormat;
import com.google.crypto.tink.proto.SlhDsaParams;
import com.google.crypto.tink.proto.SlhDsaSignatureType;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.signature.SlhDsaParameters;
import com.google.crypto.tink.signature.SlhDsaPrivateKey;
import com.google.crypto.tink.signature.SlhDsaPublicKey;
import com.google.crypto.tink.util.Bytes;
import com.google.crypto.tink.util.SecretBytes;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class SlhDsaProtoSerialization {
    private static final EnumTypeProtoConverter<SlhDsaHashType, SlhDsaParameters.HashType> HASH_TYPE_CONVERTER;
    private static final ParametersParser<ProtoParametersSerialization> PARAMETERS_PARSER;
    private static final ParametersSerializer<SlhDsaParameters, ProtoParametersSerialization> PARAMETERS_SERIALIZER;
    private static final KeyParser<ProtoKeySerialization> PRIVATE_KEY_PARSER;
    private static final KeySerializer<SlhDsaPrivateKey, ProtoKeySerialization> PRIVATE_KEY_SERIALIZER;
    private static final String PRIVATE_TYPE_URL = "type.googleapis.com/google.crypto.tink.SlhDsaPrivateKey";
    private static final Bytes PRIVATE_TYPE_URL_BYTES;
    private static final KeyParser<ProtoKeySerialization> PUBLIC_KEY_PARSER;
    private static final KeySerializer<SlhDsaPublicKey, ProtoKeySerialization> PUBLIC_KEY_SERIALIZER;
    private static final String PUBLIC_TYPE_URL = "type.googleapis.com/google.crypto.tink.SlhDsaPublicKey";
    private static final Bytes PUBLIC_TYPE_URL_BYTES;
    private static final EnumTypeProtoConverter<SlhDsaSignatureType, SlhDsaParameters.SignatureType> SIGNATURE_TYPE_CONVERTER;
    private static final EnumTypeProtoConverter<OutputPrefixType, SlhDsaParameters.Variant> VARIANT_CONVERTER;

    static {
        Bytes bytesFromPrintableAscii = Util.toBytesFromPrintableAscii(PRIVATE_TYPE_URL);
        PRIVATE_TYPE_URL_BYTES = bytesFromPrintableAscii;
        Bytes bytesFromPrintableAscii2 = Util.toBytesFromPrintableAscii(PUBLIC_TYPE_URL);
        PUBLIC_TYPE_URL_BYTES = bytesFromPrintableAscii2;
        PARAMETERS_SERIALIZER = ParametersSerializer.create(new ParametersSerializer.ParametersSerializationFunction() { // from class: com.google.crypto.tink.signature.internal.SlhDsaProtoSerialization$$ExternalSyntheticLambda0
            @Override // com.google.crypto.tink.internal.ParametersSerializer.ParametersSerializationFunction
            public final Serialization serializeParameters(Parameters parameters) {
                return SlhDsaProtoSerialization.serializeParameters((SlhDsaParameters) parameters);
            }
        }, SlhDsaParameters.class, ProtoParametersSerialization.class);
        PARAMETERS_PARSER = ParametersParser.create(new ParametersParser.ParametersParsingFunction() { // from class: com.google.crypto.tink.signature.internal.SlhDsaProtoSerialization$$ExternalSyntheticLambda1
            @Override // com.google.crypto.tink.internal.ParametersParser.ParametersParsingFunction
            public final Parameters parseParameters(Serialization serialization) {
                return SlhDsaProtoSerialization.parseParameters((ProtoParametersSerialization) serialization);
            }
        }, bytesFromPrintableAscii, ProtoParametersSerialization.class);
        PUBLIC_KEY_SERIALIZER = KeySerializer.create(new KeySerializer.KeySerializationFunction() { // from class: com.google.crypto.tink.signature.internal.SlhDsaProtoSerialization$$ExternalSyntheticLambda2
            @Override // com.google.crypto.tink.internal.KeySerializer.KeySerializationFunction
            public final Serialization serializeKey(Key key, SecretKeyAccess secretKeyAccess) {
                return SlhDsaProtoSerialization.serializePublicKey((SlhDsaPublicKey) key, secretKeyAccess);
            }
        }, SlhDsaPublicKey.class, ProtoKeySerialization.class);
        PUBLIC_KEY_PARSER = KeyParser.create(new KeyParser.KeyParsingFunction() { // from class: com.google.crypto.tink.signature.internal.SlhDsaProtoSerialization$$ExternalSyntheticLambda3
            @Override // com.google.crypto.tink.internal.KeyParser.KeyParsingFunction
            public final Key parseKey(Serialization serialization, SecretKeyAccess secretKeyAccess) {
                return SlhDsaProtoSerialization.parsePublicKey((ProtoKeySerialization) serialization, secretKeyAccess);
            }
        }, bytesFromPrintableAscii2, ProtoKeySerialization.class);
        PRIVATE_KEY_SERIALIZER = KeySerializer.create(new KeySerializer.KeySerializationFunction() { // from class: com.google.crypto.tink.signature.internal.SlhDsaProtoSerialization$$ExternalSyntheticLambda4
            @Override // com.google.crypto.tink.internal.KeySerializer.KeySerializationFunction
            public final Serialization serializeKey(Key key, SecretKeyAccess secretKeyAccess) {
                return SlhDsaProtoSerialization.serializePrivateKey((SlhDsaPrivateKey) key, secretKeyAccess);
            }
        }, SlhDsaPrivateKey.class, ProtoKeySerialization.class);
        PRIVATE_KEY_PARSER = KeyParser.create(new KeyParser.KeyParsingFunction() { // from class: com.google.crypto.tink.signature.internal.SlhDsaProtoSerialization$$ExternalSyntheticLambda5
            @Override // com.google.crypto.tink.internal.KeyParser.KeyParsingFunction
            public final Key parseKey(Serialization serialization, SecretKeyAccess secretKeyAccess) {
                return SlhDsaProtoSerialization.parsePrivateKey((ProtoKeySerialization) serialization, secretKeyAccess);
            }
        }, bytesFromPrintableAscii, ProtoKeySerialization.class);
        VARIANT_CONVERTER = EnumTypeProtoConverter.builder().add(OutputPrefixType.RAW, SlhDsaParameters.Variant.NO_PREFIX).add(OutputPrefixType.TINK, SlhDsaParameters.Variant.TINK).build();
        HASH_TYPE_CONVERTER = EnumTypeProtoConverter.builder().add(SlhDsaHashType.SHA2, SlhDsaParameters.HashType.SHA2).add(SlhDsaHashType.SHAKE, SlhDsaParameters.HashType.SHAKE).build();
        SIGNATURE_TYPE_CONVERTER = EnumTypeProtoConverter.builder().add(SlhDsaSignatureType.FAST_SIGNING, SlhDsaParameters.SignatureType.FAST_SIGNING).add(SlhDsaSignatureType.SMALL_SIGNATURE, SlhDsaParameters.SignatureType.SMALL_SIGNATURE).build();
    }

    public static void register() throws GeneralSecurityException {
        register(MutableSerializationRegistry.globalInstance());
    }

    public static void register(MutableSerializationRegistry mutableSerializationRegistry) throws GeneralSecurityException {
        mutableSerializationRegistry.registerParametersSerializer(PARAMETERS_SERIALIZER);
        mutableSerializationRegistry.registerParametersParser(PARAMETERS_PARSER);
        mutableSerializationRegistry.registerKeySerializer(PUBLIC_KEY_SERIALIZER);
        mutableSerializationRegistry.registerKeyParser(PUBLIC_KEY_PARSER);
        mutableSerializationRegistry.registerKeySerializer(PRIVATE_KEY_SERIALIZER);
        mutableSerializationRegistry.registerKeyParser(PRIVATE_KEY_PARSER);
    }

    private static SlhDsaParams getProtoParams(SlhDsaParameters slhDsaParameters) throws GeneralSecurityException {
        return SlhDsaParams.newBuilder().setKeySize(slhDsaParameters.getPrivateKeySize()).setHashType((SlhDsaHashType) HASH_TYPE_CONVERTER.toProtoEnum(slhDsaParameters.getHashType())).setSigType((SlhDsaSignatureType) SIGNATURE_TYPE_CONVERTER.toProtoEnum(slhDsaParameters.getSignatureType())).build();
    }

    private static com.google.crypto.tink.proto.SlhDsaPublicKey getProtoPublicKey(SlhDsaPublicKey slhDsaPublicKey) throws GeneralSecurityException {
        return com.google.crypto.tink.proto.SlhDsaPublicKey.newBuilder().setVersion(0).setParams(getProtoParams(slhDsaPublicKey.getParameters())).setKeyValue(ByteString.copyFrom(slhDsaPublicKey.getSerializedPublicKey().toByteArray())).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ProtoParametersSerialization serializeParameters(SlhDsaParameters slhDsaParameters) throws GeneralSecurityException {
        return ProtoParametersSerialization.create(KeyTemplate.newBuilder().setTypeUrl(PRIVATE_TYPE_URL).setValue(SlhDsaKeyFormat.newBuilder().setParams(getProtoParams(slhDsaParameters)).setVersion(0).build().toByteString()).setOutputPrefixType((OutputPrefixType) VARIANT_CONVERTER.toProtoEnum(slhDsaParameters.getVariant())).build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ProtoKeySerialization serializePublicKey(SlhDsaPublicKey slhDsaPublicKey, @Nullable SecretKeyAccess secretKeyAccess) throws GeneralSecurityException {
        return ProtoKeySerialization.create(PUBLIC_TYPE_URL, getProtoPublicKey(slhDsaPublicKey).toByteString(), KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC, (OutputPrefixType) VARIANT_CONVERTER.toProtoEnum(slhDsaPublicKey.getParameters().getVariant()), slhDsaPublicKey.getIdRequirementOrNull());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ProtoKeySerialization serializePrivateKey(SlhDsaPrivateKey slhDsaPrivateKey, @Nullable SecretKeyAccess secretKeyAccess) throws GeneralSecurityException {
        return ProtoKeySerialization.create(PRIVATE_TYPE_URL, com.google.crypto.tink.proto.SlhDsaPrivateKey.newBuilder().setVersion(0).setPublicKey(getProtoPublicKey(slhDsaPrivateKey.getPublicKey())).setKeyValue(ByteString.copyFrom(slhDsaPrivateKey.getPrivateKeyBytes().toByteArray(SecretKeyAccess.requireAccess(secretKeyAccess)))).build().toByteString(), KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE, (OutputPrefixType) VARIANT_CONVERTER.toProtoEnum(slhDsaPrivateKey.getParameters().getVariant()), slhDsaPrivateKey.getIdRequirementOrNull());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static SlhDsaParameters parseParameters(ProtoParametersSerialization protoParametersSerialization) throws GeneralSecurityException {
        if (!protoParametersSerialization.getKeyTemplate().getTypeUrl().equals(PRIVATE_TYPE_URL)) {
            throw new IllegalArgumentException("Wrong type URL in call to SlhDsaProtoSerialization.parseParameters: " + protoParametersSerialization.getKeyTemplate().getTypeUrl());
        }
        try {
            SlhDsaKeyFormat from = SlhDsaKeyFormat.parseFrom(protoParametersSerialization.getKeyTemplate().getValue(), ExtensionRegistryLite.getEmptyRegistry());
            if (from.getVersion() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted for SLH-DSA.");
            }
            return validateAndConvertToSlhDsaParameters(from.getParams(), VARIANT_CONVERTER.fromProtoEnum(protoParametersSerialization.getKeyTemplate().getOutputPrefixType()));
        } catch (InvalidProtocolBufferException e) {
            throw new GeneralSecurityException("Parsing SlhDsaParameters failed: ", e);
        }
    }

    private static SlhDsaParameters validateAndConvertToSlhDsaParameters(SlhDsaParams slhDsaParams, SlhDsaParameters.Variant variant) throws GeneralSecurityException {
        if (slhDsaParams.getKeySize() != 64 || slhDsaParams.getHashType() != SlhDsaHashType.SHA2 || slhDsaParams.getSigType() != SlhDsaSignatureType.SMALL_SIGNATURE) {
            throw new GeneralSecurityException("Unsupported SLH-DSA parameters");
        }
        return SlhDsaParameters.createSlhDsaWithSha2And128S(variant);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static SlhDsaPublicKey parsePublicKey(ProtoKeySerialization protoKeySerialization, @Nullable SecretKeyAccess secretKeyAccess) throws GeneralSecurityException {
        if (!protoKeySerialization.getTypeUrl().equals(PUBLIC_TYPE_URL)) {
            throw new IllegalArgumentException("Wrong type URL in call to SlhDsaProtoSerialization.parsePublicKey: " + protoKeySerialization.getTypeUrl());
        }
        if (protoKeySerialization.getKeyMaterialType() != KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC) {
            throw new GeneralSecurityException("Wrong KeyMaterialType for SlhDsaPublicKey: " + protoKeySerialization.getKeyMaterialType().name());
        }
        try {
            return convertToSlhDsaPublicKey(protoKeySerialization, com.google.crypto.tink.proto.SlhDsaPublicKey.parseFrom(protoKeySerialization.getValue(), ExtensionRegistryLite.getEmptyRegistry()));
        } catch (InvalidProtocolBufferException unused) {
            throw new GeneralSecurityException("Parsing SlhDsaPublicKey failed");
        }
    }

    private static SlhDsaPublicKey convertToSlhDsaPublicKey(ProtoKeySerialization protoKeySerialization, com.google.crypto.tink.proto.SlhDsaPublicKey slhDsaPublicKey) throws GeneralSecurityException {
        if (slhDsaPublicKey.getVersion() != 0) {
            throw new GeneralSecurityException("Only version 0 keys are accepted");
        }
        SlhDsaPublicKey.Builder serializedPublicKey = SlhDsaPublicKey.builder().setParameters(validateAndConvertToSlhDsaParameters(slhDsaPublicKey.getParams(), VARIANT_CONVERTER.fromProtoEnum(protoKeySerialization.getOutputPrefixType()))).setSerializedPublicKey(Bytes.copyFrom(slhDsaPublicKey.getKeyValue().toByteArray()));
        if (protoKeySerialization.getIdRequirementOrNull() != null) {
            serializedPublicKey.setIdRequirement(protoKeySerialization.getIdRequirementOrNull());
        }
        return serializedPublicKey.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static SlhDsaPrivateKey parsePrivateKey(ProtoKeySerialization protoKeySerialization, @Nullable SecretKeyAccess secretKeyAccess) throws GeneralSecurityException {
        if (!protoKeySerialization.getTypeUrl().equals(PRIVATE_TYPE_URL)) {
            throw new IllegalArgumentException("Wrong type URL in call to SlhDsaProtoSerialization.parsePrivateKey: " + protoKeySerialization.getTypeUrl());
        }
        if (protoKeySerialization.getKeyMaterialType() != KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE) {
            throw new GeneralSecurityException("Wrong KeyMaterialType for SlhDsaPrivateKey: " + protoKeySerialization.getKeyMaterialType().name());
        }
        try {
            com.google.crypto.tink.proto.SlhDsaPrivateKey from = com.google.crypto.tink.proto.SlhDsaPrivateKey.parseFrom(protoKeySerialization.getValue(), ExtensionRegistryLite.getEmptyRegistry());
            if (from.getVersion() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            return SlhDsaPrivateKey.createWithoutVerification(convertToSlhDsaPublicKey(protoKeySerialization, from.getPublicKey()), SecretBytes.copyFrom(from.getKeyValue().toByteArray(), SecretKeyAccess.requireAccess(secretKeyAccess)));
        } catch (InvalidProtocolBufferException unused) {
            throw new GeneralSecurityException("Parsing SlhDsaPrivateKey failed");
        }
    }

    private SlhDsaProtoSerialization() {
    }
}
