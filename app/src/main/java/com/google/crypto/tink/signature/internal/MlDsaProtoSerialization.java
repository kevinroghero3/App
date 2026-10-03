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
import com.google.crypto.tink.proto.MlDsaInstance;
import com.google.crypto.tink.proto.MlDsaKeyFormat;
import com.google.crypto.tink.proto.MlDsaParams;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.signature.MlDsaParameters;
import com.google.crypto.tink.signature.MlDsaPrivateKey;
import com.google.crypto.tink.signature.MlDsaPublicKey;
import com.google.crypto.tink.util.Bytes;
import com.google.crypto.tink.util.SecretBytes;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class MlDsaProtoSerialization {
    private static final EnumTypeProtoConverter<MlDsaInstance, MlDsaParameters.MlDsaInstance> INSTANCE_CONVERTER;
    private static final ParametersParser<ProtoParametersSerialization> PARAMETERS_PARSER;
    private static final ParametersSerializer<MlDsaParameters, ProtoParametersSerialization> PARAMETERS_SERIALIZER;
    private static final KeyParser<ProtoKeySerialization> PRIVATE_KEY_PARSER;
    private static final KeySerializer<MlDsaPrivateKey, ProtoKeySerialization> PRIVATE_KEY_SERIALIZER;
    private static final String PRIVATE_TYPE_URL = "type.googleapis.com/google.crypto.tink.MlDsaPrivateKey";
    private static final Bytes PRIVATE_TYPE_URL_BYTES;
    private static final KeyParser<ProtoKeySerialization> PUBLIC_KEY_PARSER;
    private static final KeySerializer<MlDsaPublicKey, ProtoKeySerialization> PUBLIC_KEY_SERIALIZER;
    private static final String PUBLIC_TYPE_URL = "type.googleapis.com/google.crypto.tink.MlDsaPublicKey";
    private static final Bytes PUBLIC_TYPE_URL_BYTES;
    private static final EnumTypeProtoConverter<OutputPrefixType, MlDsaParameters.Variant> VARIANT_CONVERTER;

    static {
        Bytes bytesFromPrintableAscii = Util.toBytesFromPrintableAscii(PRIVATE_TYPE_URL);
        PRIVATE_TYPE_URL_BYTES = bytesFromPrintableAscii;
        Bytes bytesFromPrintableAscii2 = Util.toBytesFromPrintableAscii(PUBLIC_TYPE_URL);
        PUBLIC_TYPE_URL_BYTES = bytesFromPrintableAscii2;
        PARAMETERS_SERIALIZER = ParametersSerializer.create(new ParametersSerializer.ParametersSerializationFunction() { // from class: com.google.crypto.tink.signature.internal.MlDsaProtoSerialization$$ExternalSyntheticLambda0
            @Override // com.google.crypto.tink.internal.ParametersSerializer.ParametersSerializationFunction
            public final Serialization serializeParameters(Parameters parameters) {
                return MlDsaProtoSerialization.serializeParameters((MlDsaParameters) parameters);
            }
        }, MlDsaParameters.class, ProtoParametersSerialization.class);
        PARAMETERS_PARSER = ParametersParser.create(new ParametersParser.ParametersParsingFunction() { // from class: com.google.crypto.tink.signature.internal.MlDsaProtoSerialization$$ExternalSyntheticLambda1
            @Override // com.google.crypto.tink.internal.ParametersParser.ParametersParsingFunction
            public final Parameters parseParameters(Serialization serialization) {
                return MlDsaProtoSerialization.parseParameters((ProtoParametersSerialization) serialization);
            }
        }, bytesFromPrintableAscii, ProtoParametersSerialization.class);
        PUBLIC_KEY_SERIALIZER = KeySerializer.create(new KeySerializer.KeySerializationFunction() { // from class: com.google.crypto.tink.signature.internal.MlDsaProtoSerialization$$ExternalSyntheticLambda2
            @Override // com.google.crypto.tink.internal.KeySerializer.KeySerializationFunction
            public final Serialization serializeKey(Key key, SecretKeyAccess secretKeyAccess) {
                return MlDsaProtoSerialization.serializePublicKey((MlDsaPublicKey) key, secretKeyAccess);
            }
        }, MlDsaPublicKey.class, ProtoKeySerialization.class);
        PUBLIC_KEY_PARSER = KeyParser.create(new KeyParser.KeyParsingFunction() { // from class: com.google.crypto.tink.signature.internal.MlDsaProtoSerialization$$ExternalSyntheticLambda3
            @Override // com.google.crypto.tink.internal.KeyParser.KeyParsingFunction
            public final Key parseKey(Serialization serialization, SecretKeyAccess secretKeyAccess) {
                return MlDsaProtoSerialization.parsePublicKey((ProtoKeySerialization) serialization, secretKeyAccess);
            }
        }, bytesFromPrintableAscii2, ProtoKeySerialization.class);
        PRIVATE_KEY_SERIALIZER = KeySerializer.create(new KeySerializer.KeySerializationFunction() { // from class: com.google.crypto.tink.signature.internal.MlDsaProtoSerialization$$ExternalSyntheticLambda4
            @Override // com.google.crypto.tink.internal.KeySerializer.KeySerializationFunction
            public final Serialization serializeKey(Key key, SecretKeyAccess secretKeyAccess) {
                return MlDsaProtoSerialization.serializePrivateKey((MlDsaPrivateKey) key, secretKeyAccess);
            }
        }, MlDsaPrivateKey.class, ProtoKeySerialization.class);
        PRIVATE_KEY_PARSER = KeyParser.create(new KeyParser.KeyParsingFunction() { // from class: com.google.crypto.tink.signature.internal.MlDsaProtoSerialization$$ExternalSyntheticLambda5
            @Override // com.google.crypto.tink.internal.KeyParser.KeyParsingFunction
            public final Key parseKey(Serialization serialization, SecretKeyAccess secretKeyAccess) {
                return MlDsaProtoSerialization.parsePrivateKey((ProtoKeySerialization) serialization, secretKeyAccess);
            }
        }, bytesFromPrintableAscii, ProtoKeySerialization.class);
        VARIANT_CONVERTER = EnumTypeProtoConverter.builder().add(OutputPrefixType.RAW, MlDsaParameters.Variant.NO_PREFIX).add(OutputPrefixType.TINK, MlDsaParameters.Variant.TINK).build();
        INSTANCE_CONVERTER = EnumTypeProtoConverter.builder().add(MlDsaInstance.ML_DSA_65, MlDsaParameters.MlDsaInstance.ML_DSA_65).add(MlDsaInstance.ML_DSA_87, MlDsaParameters.MlDsaInstance.ML_DSA_87).build();
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

    private static MlDsaParams getProtoParams(MlDsaParameters mlDsaParameters) throws GeneralSecurityException {
        return MlDsaParams.newBuilder().setMlDsaInstance((MlDsaInstance) INSTANCE_CONVERTER.toProtoEnum(mlDsaParameters.getMlDsaInstance())).build();
    }

    private static com.google.crypto.tink.proto.MlDsaPublicKey getProtoPublicKey(MlDsaPublicKey mlDsaPublicKey) throws GeneralSecurityException {
        return com.google.crypto.tink.proto.MlDsaPublicKey.newBuilder().setVersion(0).setParams(getProtoParams(mlDsaPublicKey.getParameters())).setKeyValue(ByteString.copyFrom(mlDsaPublicKey.getSerializedPublicKey().toByteArray())).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ProtoParametersSerialization serializeParameters(MlDsaParameters mlDsaParameters) throws GeneralSecurityException {
        return ProtoParametersSerialization.create(KeyTemplate.newBuilder().setTypeUrl(PRIVATE_TYPE_URL).setValue(MlDsaKeyFormat.newBuilder().setParams(getProtoParams(mlDsaParameters)).setVersion(0).build().toByteString()).setOutputPrefixType((OutputPrefixType) VARIANT_CONVERTER.toProtoEnum(mlDsaParameters.getVariant())).build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ProtoKeySerialization serializePublicKey(MlDsaPublicKey mlDsaPublicKey, @Nullable SecretKeyAccess secretKeyAccess) throws GeneralSecurityException {
        return ProtoKeySerialization.create(PUBLIC_TYPE_URL, getProtoPublicKey(mlDsaPublicKey).toByteString(), KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC, (OutputPrefixType) VARIANT_CONVERTER.toProtoEnum(mlDsaPublicKey.getParameters().getVariant()), mlDsaPublicKey.getIdRequirementOrNull());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ProtoKeySerialization serializePrivateKey(MlDsaPrivateKey mlDsaPrivateKey, @Nullable SecretKeyAccess secretKeyAccess) throws GeneralSecurityException {
        return ProtoKeySerialization.create(PRIVATE_TYPE_URL, com.google.crypto.tink.proto.MlDsaPrivateKey.newBuilder().setVersion(0).setPublicKey(getProtoPublicKey(mlDsaPrivateKey.getPublicKey())).setKeyValue(ByteString.copyFrom(mlDsaPrivateKey.getPrivateSeed().toByteArray(SecretKeyAccess.requireAccess(secretKeyAccess)))).build().toByteString(), KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE, (OutputPrefixType) VARIANT_CONVERTER.toProtoEnum(mlDsaPrivateKey.getParameters().getVariant()), mlDsaPrivateKey.getIdRequirementOrNull());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static MlDsaParameters parseParameters(ProtoParametersSerialization protoParametersSerialization) throws GeneralSecurityException {
        if (!protoParametersSerialization.getKeyTemplate().getTypeUrl().equals(PRIVATE_TYPE_URL)) {
            throw new IllegalArgumentException("Wrong type URL in call to MlDsaProtoSerialization.parseParameters: " + protoParametersSerialization.getKeyTemplate().getTypeUrl());
        }
        try {
            MlDsaKeyFormat from = MlDsaKeyFormat.parseFrom(protoParametersSerialization.getKeyTemplate().getValue(), ExtensionRegistryLite.getEmptyRegistry());
            if (from.getVersion() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted for ML-DSA.");
            }
            return MlDsaParameters.create(INSTANCE_CONVERTER.fromProtoEnum(from.getParams().getMlDsaInstance()), VARIANT_CONVERTER.fromProtoEnum(protoParametersSerialization.getKeyTemplate().getOutputPrefixType()));
        } catch (InvalidProtocolBufferException e) {
            throw new GeneralSecurityException("Parsing MlDsaParameters failed: ", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static MlDsaPublicKey parsePublicKey(ProtoKeySerialization protoKeySerialization, @Nullable SecretKeyAccess secretKeyAccess) throws GeneralSecurityException {
        if (!protoKeySerialization.getTypeUrl().equals(PUBLIC_TYPE_URL)) {
            throw new IllegalArgumentException("Wrong type URL in call to MlDsaProtoSerialization.parsePublicKey: " + protoKeySerialization.getTypeUrl());
        }
        if (protoKeySerialization.getKeyMaterialType() != KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC) {
            throw new GeneralSecurityException("Wrong KeyMaterialType for MlDsaPublicKey: " + protoKeySerialization.getKeyMaterialType());
        }
        try {
            com.google.crypto.tink.proto.MlDsaPublicKey from = com.google.crypto.tink.proto.MlDsaPublicKey.parseFrom(protoKeySerialization.getValue(), ExtensionRegistryLite.getEmptyRegistry());
            if (from.getVersion() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            MlDsaPublicKey.Builder serializedPublicKey = MlDsaPublicKey.builder().setParameters(MlDsaParameters.create(INSTANCE_CONVERTER.fromProtoEnum(from.getParams().getMlDsaInstance()), VARIANT_CONVERTER.fromProtoEnum(protoKeySerialization.getOutputPrefixType()))).setSerializedPublicKey(Bytes.copyFrom(from.getKeyValue().toByteArray()));
            if (protoKeySerialization.getIdRequirementOrNull() != null) {
                serializedPublicKey.setIdRequirement(protoKeySerialization.getIdRequirementOrNull());
            }
            return serializedPublicKey.build();
        } catch (InvalidProtocolBufferException unused) {
            throw new GeneralSecurityException("Parsing MlDsaPublicKey failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static MlDsaPrivateKey parsePrivateKey(ProtoKeySerialization protoKeySerialization, @Nullable SecretKeyAccess secretKeyAccess) throws GeneralSecurityException {
        if (!protoKeySerialization.getTypeUrl().equals(PRIVATE_TYPE_URL)) {
            throw new IllegalArgumentException("Wrong type URL in call to MlDsaProtoSerialization.parsePrivateKey: " + protoKeySerialization.getTypeUrl());
        }
        if (protoKeySerialization.getKeyMaterialType() != KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE) {
            throw new GeneralSecurityException("Wrong KeyMaterialType for MlDsaPrivateKey: " + protoKeySerialization.getKeyMaterialType());
        }
        try {
            com.google.crypto.tink.proto.MlDsaPrivateKey from = com.google.crypto.tink.proto.MlDsaPrivateKey.parseFrom(protoKeySerialization.getValue(), ExtensionRegistryLite.getEmptyRegistry());
            if (from.getVersion() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            com.google.crypto.tink.proto.MlDsaPublicKey publicKey = from.getPublicKey();
            if (publicKey.getVersion() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            MlDsaPublicKey.Builder serializedPublicKey = MlDsaPublicKey.builder().setParameters(MlDsaParameters.create(INSTANCE_CONVERTER.fromProtoEnum(publicKey.getParams().getMlDsaInstance()), VARIANT_CONVERTER.fromProtoEnum(protoKeySerialization.getOutputPrefixType()))).setSerializedPublicKey(Bytes.copyFrom(publicKey.getKeyValue().toByteArray()));
            if (protoKeySerialization.getIdRequirementOrNull() != null) {
                serializedPublicKey.setIdRequirement(protoKeySerialization.getIdRequirementOrNull());
            }
            return MlDsaPrivateKey.createWithoutVerification(serializedPublicKey.build(), SecretBytes.copyFrom(from.getKeyValue().toByteArray(), SecretKeyAccess.requireAccess(secretKeyAccess)));
        } catch (InvalidProtocolBufferException unused) {
            throw new GeneralSecurityException("Parsing MlDsaPrivateKey failed");
        }
    }

    private MlDsaProtoSerialization() {
    }
}
