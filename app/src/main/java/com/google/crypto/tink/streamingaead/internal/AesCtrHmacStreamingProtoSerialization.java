package com.google.crypto.tink.streamingaead.internal;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.SecretKeyAccess;
import com.google.crypto.tink.internal.KeyParser;
import com.google.crypto.tink.internal.KeySerializer;
import com.google.crypto.tink.internal.MutableSerializationRegistry;
import com.google.crypto.tink.internal.ParametersParser;
import com.google.crypto.tink.internal.ParametersSerializer;
import com.google.crypto.tink.internal.ProtoKeySerialization;
import com.google.crypto.tink.internal.ProtoParametersSerialization;
import com.google.crypto.tink.internal.Serialization;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.proto.AesCtrHmacStreamingKeyFormat;
import com.google.crypto.tink.proto.AesCtrHmacStreamingParams;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.HmacParams;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.streamingaead.AesCtrHmacStreamingKey;
import com.google.crypto.tink.streamingaead.AesCtrHmacStreamingParameters;
import com.google.crypto.tink.util.Bytes;
import com.google.crypto.tink.util.SecretBytes;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class AesCtrHmacStreamingProtoSerialization {
    private static final KeyParser<ProtoKeySerialization> KEY_PARSER;
    private static final KeySerializer<AesCtrHmacStreamingKey, ProtoKeySerialization> KEY_SERIALIZER;
    private static final ParametersParser<ProtoParametersSerialization> PARAMETERS_PARSER;
    private static final ParametersSerializer<AesCtrHmacStreamingParameters, ProtoParametersSerialization> PARAMETERS_SERIALIZER;
    private static final String TYPE_URL = "type.googleapis.com/google.crypto.tink.AesCtrHmacStreamingKey";
    private static final Bytes TYPE_URL_BYTES;

    static {
        Bytes bytesFromPrintableAscii = Util.toBytesFromPrintableAscii(TYPE_URL);
        TYPE_URL_BYTES = bytesFromPrintableAscii;
        PARAMETERS_SERIALIZER = ParametersSerializer.create(new ParametersSerializer.ParametersSerializationFunction() { // from class: com.google.crypto.tink.streamingaead.internal.AesCtrHmacStreamingProtoSerialization$$ExternalSyntheticLambda0
            @Override // com.google.crypto.tink.internal.ParametersSerializer.ParametersSerializationFunction
            public final Serialization serializeParameters(Parameters parameters) {
                return AesCtrHmacStreamingProtoSerialization.serializeParameters((AesCtrHmacStreamingParameters) parameters);
            }
        }, AesCtrHmacStreamingParameters.class, ProtoParametersSerialization.class);
        PARAMETERS_PARSER = ParametersParser.create(new ParametersParser.ParametersParsingFunction() { // from class: com.google.crypto.tink.streamingaead.internal.AesCtrHmacStreamingProtoSerialization$$ExternalSyntheticLambda1
            @Override // com.google.crypto.tink.internal.ParametersParser.ParametersParsingFunction
            public final Parameters parseParameters(Serialization serialization) {
                return AesCtrHmacStreamingProtoSerialization.parseParameters((ProtoParametersSerialization) serialization);
            }
        }, bytesFromPrintableAscii, ProtoParametersSerialization.class);
        KEY_SERIALIZER = KeySerializer.create(new KeySerializer.KeySerializationFunction() { // from class: com.google.crypto.tink.streamingaead.internal.AesCtrHmacStreamingProtoSerialization$$ExternalSyntheticLambda2
            @Override // com.google.crypto.tink.internal.KeySerializer.KeySerializationFunction
            public final Serialization serializeKey(Key key, SecretKeyAccess secretKeyAccess) {
                return AesCtrHmacStreamingProtoSerialization.serializeKey((AesCtrHmacStreamingKey) key, secretKeyAccess);
            }
        }, AesCtrHmacStreamingKey.class, ProtoKeySerialization.class);
        KEY_PARSER = KeyParser.create(new KeyParser.KeyParsingFunction() { // from class: com.google.crypto.tink.streamingaead.internal.AesCtrHmacStreamingProtoSerialization$$ExternalSyntheticLambda3
            @Override // com.google.crypto.tink.internal.KeyParser.KeyParsingFunction
            public final Key parseKey(Serialization serialization, SecretKeyAccess secretKeyAccess) {
                return AesCtrHmacStreamingProtoSerialization.parseKey((ProtoKeySerialization) serialization, secretKeyAccess);
            }
        }, bytesFromPrintableAscii, ProtoKeySerialization.class);
    }

    private static HashType toProtoHashType(AesCtrHmacStreamingParameters.HashType hashType) throws GeneralSecurityException {
        if (AesCtrHmacStreamingParameters.HashType.SHA1.equals(hashType)) {
            return HashType.SHA1;
        }
        if (AesCtrHmacStreamingParameters.HashType.SHA256.equals(hashType)) {
            return HashType.SHA256;
        }
        if (AesCtrHmacStreamingParameters.HashType.SHA512.equals(hashType)) {
            return HashType.SHA512;
        }
        throw new GeneralSecurityException("Unable to serialize HashType " + hashType);
    }

    /* JADX INFO: renamed from: com.google.crypto.tink.streamingaead.internal.AesCtrHmacStreamingProtoSerialization$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$HashType;

        static {
            int[] iArr = new int[HashType.values().length];
            $SwitchMap$com$google$crypto$tink$proto$HashType = iArr;
            try {
                iArr[HashType.SHA1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$HashType[HashType.SHA256.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$HashType[HashType.SHA512.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private static AesCtrHmacStreamingParameters.HashType toHashType(HashType hashType) throws GeneralSecurityException {
        int i = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$HashType[hashType.ordinal()];
        if (i == 1) {
            return AesCtrHmacStreamingParameters.HashType.SHA1;
        }
        if (i == 2) {
            return AesCtrHmacStreamingParameters.HashType.SHA256;
        }
        if (i == 3) {
            return AesCtrHmacStreamingParameters.HashType.SHA512;
        }
        throw new GeneralSecurityException("Unable to parse HashType: " + hashType.getNumber());
    }

    private static AesCtrHmacStreamingParams toProtoParams(AesCtrHmacStreamingParameters aesCtrHmacStreamingParameters) throws GeneralSecurityException {
        return AesCtrHmacStreamingParams.newBuilder().setCiphertextSegmentSize(aesCtrHmacStreamingParameters.getCiphertextSegmentSizeBytes()).setDerivedKeySize(aesCtrHmacStreamingParameters.getDerivedKeySizeBytes()).setHkdfHashType(toProtoHashType(aesCtrHmacStreamingParameters.getHkdfHashType())).setHmacParams(HmacParams.newBuilder().setHash(toProtoHashType(aesCtrHmacStreamingParameters.getHmacHashType())).setTagSize(aesCtrHmacStreamingParameters.getHmacTagSizeBytes())).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ProtoParametersSerialization serializeParameters(AesCtrHmacStreamingParameters aesCtrHmacStreamingParameters) throws GeneralSecurityException {
        return ProtoParametersSerialization.create(KeyTemplate.newBuilder().setTypeUrl(TYPE_URL).setValue(AesCtrHmacStreamingKeyFormat.newBuilder().setKeySize(aesCtrHmacStreamingParameters.getKeySizeBytes()).setParams(toProtoParams(aesCtrHmacStreamingParameters)).build().toByteString()).setOutputPrefixType(OutputPrefixType.RAW).build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ProtoKeySerialization serializeKey(AesCtrHmacStreamingKey aesCtrHmacStreamingKey, @Nullable SecretKeyAccess secretKeyAccess) throws GeneralSecurityException {
        return ProtoKeySerialization.create(TYPE_URL, com.google.crypto.tink.proto.AesCtrHmacStreamingKey.newBuilder().setKeyValue(ByteString.copyFrom(aesCtrHmacStreamingKey.getInitialKeyMaterial().toByteArray(SecretKeyAccess.requireAccess(secretKeyAccess)))).setParams(toProtoParams(aesCtrHmacStreamingKey.getParameters())).build().toByteString(), KeyData.KeyMaterialType.SYMMETRIC, OutputPrefixType.RAW, aesCtrHmacStreamingKey.getIdRequirementOrNull());
    }

    private static AesCtrHmacStreamingParameters toParametersObject(AesCtrHmacStreamingParams aesCtrHmacStreamingParams, int i) throws GeneralSecurityException {
        return AesCtrHmacStreamingParameters.builder().setKeySizeBytes(i).setDerivedKeySizeBytes(aesCtrHmacStreamingParams.getDerivedKeySize()).setCiphertextSegmentSizeBytes(aesCtrHmacStreamingParams.getCiphertextSegmentSize()).setHkdfHashType(toHashType(aesCtrHmacStreamingParams.getHkdfHashType())).setHmacHashType(toHashType(aesCtrHmacStreamingParams.getHmacParams().getHash())).setHmacTagSizeBytes(Integer.valueOf(aesCtrHmacStreamingParams.getHmacParams().getTagSize())).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AesCtrHmacStreamingParameters parseParameters(ProtoParametersSerialization protoParametersSerialization) throws GeneralSecurityException {
        if (!protoParametersSerialization.getKeyTemplate().getTypeUrl().equals(TYPE_URL)) {
            throw new IllegalArgumentException("Wrong type URL in call to AesCtrHmacStreamingParameters.parseParameters: " + protoParametersSerialization.getKeyTemplate().getTypeUrl());
        }
        try {
            AesCtrHmacStreamingKeyFormat from = AesCtrHmacStreamingKeyFormat.parseFrom(protoParametersSerialization.getKeyTemplate().getValue(), ExtensionRegistryLite.getEmptyRegistry());
            return toParametersObject(from.getParams(), from.getKeySize());
        } catch (InvalidProtocolBufferException e) {
            throw new GeneralSecurityException("Parsing AesCtrHmacStreamingParameters failed: ", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AesCtrHmacStreamingKey parseKey(ProtoKeySerialization protoKeySerialization, @Nullable SecretKeyAccess secretKeyAccess) throws GeneralSecurityException {
        if (!protoKeySerialization.getTypeUrl().equals(TYPE_URL)) {
            throw new IllegalArgumentException("Wrong type URL in call to AesCtrHmacStreamingParameters.parseParameters");
        }
        try {
            com.google.crypto.tink.proto.AesCtrHmacStreamingKey from = com.google.crypto.tink.proto.AesCtrHmacStreamingKey.parseFrom(protoKeySerialization.getValue(), ExtensionRegistryLite.getEmptyRegistry());
            if (from.getVersion() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            return AesCtrHmacStreamingKey.create(toParametersObject(from.getParams(), from.getKeyValue().size()), SecretBytes.copyFrom(from.getKeyValue().toByteArray(), SecretKeyAccess.requireAccess(secretKeyAccess)));
        } catch (InvalidProtocolBufferException unused) {
            throw new GeneralSecurityException("Parsing AesCtrHmacStreamingKey failed");
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

    private AesCtrHmacStreamingProtoSerialization() {
    }
}
