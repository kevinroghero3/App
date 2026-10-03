package com.google.crypto.tink.jwt.internal;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.SecretKeyAccess;
import com.google.crypto.tink.internal.BigIntegerEncoding;
import com.google.crypto.tink.internal.KeyParser;
import com.google.crypto.tink.internal.KeySerializer;
import com.google.crypto.tink.internal.MutableSerializationRegistry;
import com.google.crypto.tink.internal.ParametersParser;
import com.google.crypto.tink.internal.ParametersSerializer;
import com.google.crypto.tink.internal.ProtoKeySerialization;
import com.google.crypto.tink.internal.ProtoParametersSerialization;
import com.google.crypto.tink.internal.Serialization;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.jwt.JwtEcdsaParameters;
import com.google.crypto.tink.jwt.JwtEcdsaPrivateKey;
import com.google.crypto.tink.jwt.JwtEcdsaPublicKey;
import com.google.crypto.tink.proto.JwtEcdsaAlgorithm;
import com.google.crypto.tink.proto.JwtEcdsaKeyFormat;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.util.Bytes;
import com.google.crypto.tink.util.SecretBigInteger;
import java.security.GeneralSecurityException;
import java.security.spec.ECPoint;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class JwtEcdsaProtoSerialization {
    private static final ParametersParser<ProtoParametersSerialization> PARAMETERS_PARSER;
    private static final ParametersSerializer<JwtEcdsaParameters, ProtoParametersSerialization> PARAMETERS_SERIALIZER;
    private static final KeyParser<ProtoKeySerialization> PRIVATE_KEY_PARSER;
    private static final KeySerializer<JwtEcdsaPrivateKey, ProtoKeySerialization> PRIVATE_KEY_SERIALIZER;
    private static final KeyParser<ProtoKeySerialization> PUBLIC_KEY_PARSER;
    private static final KeySerializer<JwtEcdsaPublicKey, ProtoKeySerialization> PUBLIC_KEY_SERIALIZER;
    private static final String PUBLIC_TYPE_URL = "type.googleapis.com/google.crypto.tink.JwtEcdsaPublicKey";
    private static final Bytes PUBLIC_TYPE_URL_BYTES;
    private static final String TYPE_URL = "type.googleapis.com/google.crypto.tink.JwtEcdsaPrivateKey";
    private static final Bytes TYPE_URL_BYTES;

    static {
        Bytes bytesFromPrintableAscii = Util.toBytesFromPrintableAscii(TYPE_URL);
        TYPE_URL_BYTES = bytesFromPrintableAscii;
        Bytes bytesFromPrintableAscii2 = Util.toBytesFromPrintableAscii(PUBLIC_TYPE_URL);
        PUBLIC_TYPE_URL_BYTES = bytesFromPrintableAscii2;
        PARAMETERS_SERIALIZER = ParametersSerializer.create(new ParametersSerializer.ParametersSerializationFunction() { // from class: com.google.crypto.tink.jwt.internal.JwtEcdsaProtoSerialization$$ExternalSyntheticLambda0
            @Override // com.google.crypto.tink.internal.ParametersSerializer.ParametersSerializationFunction
            public final Serialization serializeParameters(Parameters parameters) {
                return JwtEcdsaProtoSerialization.serializeParameters((JwtEcdsaParameters) parameters);
            }
        }, JwtEcdsaParameters.class, ProtoParametersSerialization.class);
        PARAMETERS_PARSER = ParametersParser.create(new ParametersParser.ParametersParsingFunction() { // from class: com.google.crypto.tink.jwt.internal.JwtEcdsaProtoSerialization$$ExternalSyntheticLambda1
            @Override // com.google.crypto.tink.internal.ParametersParser.ParametersParsingFunction
            public final Parameters parseParameters(Serialization serialization) {
                return JwtEcdsaProtoSerialization.parseParameters((ProtoParametersSerialization) serialization);
            }
        }, bytesFromPrintableAscii, ProtoParametersSerialization.class);
        PUBLIC_KEY_SERIALIZER = KeySerializer.create(new KeySerializer.KeySerializationFunction() { // from class: com.google.crypto.tink.jwt.internal.JwtEcdsaProtoSerialization$$ExternalSyntheticLambda2
            @Override // com.google.crypto.tink.internal.KeySerializer.KeySerializationFunction
            public final Serialization serializeKey(Key key, SecretKeyAccess secretKeyAccess) {
                return JwtEcdsaProtoSerialization.serializePublicKey((JwtEcdsaPublicKey) key, secretKeyAccess);
            }
        }, JwtEcdsaPublicKey.class, ProtoKeySerialization.class);
        PUBLIC_KEY_PARSER = KeyParser.create(new KeyParser.KeyParsingFunction() { // from class: com.google.crypto.tink.jwt.internal.JwtEcdsaProtoSerialization$$ExternalSyntheticLambda3
            @Override // com.google.crypto.tink.internal.KeyParser.KeyParsingFunction
            public final Key parseKey(Serialization serialization, SecretKeyAccess secretKeyAccess) {
                return JwtEcdsaProtoSerialization.parsePublicKey((ProtoKeySerialization) serialization, secretKeyAccess);
            }
        }, bytesFromPrintableAscii2, ProtoKeySerialization.class);
        PRIVATE_KEY_SERIALIZER = KeySerializer.create(new KeySerializer.KeySerializationFunction() { // from class: com.google.crypto.tink.jwt.internal.JwtEcdsaProtoSerialization$$ExternalSyntheticLambda4
            @Override // com.google.crypto.tink.internal.KeySerializer.KeySerializationFunction
            public final Serialization serializeKey(Key key, SecretKeyAccess secretKeyAccess) {
                return JwtEcdsaProtoSerialization.serializePrivateKey((JwtEcdsaPrivateKey) key, secretKeyAccess);
            }
        }, JwtEcdsaPrivateKey.class, ProtoKeySerialization.class);
        PRIVATE_KEY_PARSER = KeyParser.create(new KeyParser.KeyParsingFunction() { // from class: com.google.crypto.tink.jwt.internal.JwtEcdsaProtoSerialization$$ExternalSyntheticLambda5
            @Override // com.google.crypto.tink.internal.KeyParser.KeyParsingFunction
            public final Key parseKey(Serialization serialization, SecretKeyAccess secretKeyAccess) {
                return JwtEcdsaProtoSerialization.parsePrivateKey((ProtoKeySerialization) serialization, secretKeyAccess);
            }
        }, bytesFromPrintableAscii, ProtoKeySerialization.class);
    }

    private static JwtEcdsaAlgorithm toProtoAlgorithm(JwtEcdsaParameters.Algorithm algorithm) throws GeneralSecurityException {
        if (JwtEcdsaParameters.Algorithm.ES256.equals(algorithm)) {
            return JwtEcdsaAlgorithm.ES256;
        }
        if (JwtEcdsaParameters.Algorithm.ES384.equals(algorithm)) {
            return JwtEcdsaAlgorithm.ES384;
        }
        if (JwtEcdsaParameters.Algorithm.ES512.equals(algorithm)) {
            return JwtEcdsaAlgorithm.ES512;
        }
        throw new GeneralSecurityException("Unable to serialize algorithm: " + algorithm);
    }

    /* JADX INFO: renamed from: com.google.crypto.tink.jwt.internal.JwtEcdsaProtoSerialization$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$JwtEcdsaAlgorithm;

        static {
            int[] iArr = new int[JwtEcdsaAlgorithm.values().length];
            $SwitchMap$com$google$crypto$tink$proto$JwtEcdsaAlgorithm = iArr;
            try {
                iArr[JwtEcdsaAlgorithm.ES256.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$JwtEcdsaAlgorithm[JwtEcdsaAlgorithm.ES384.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$JwtEcdsaAlgorithm[JwtEcdsaAlgorithm.ES512.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private static JwtEcdsaParameters.Algorithm toAlgorithm(JwtEcdsaAlgorithm jwtEcdsaAlgorithm) throws GeneralSecurityException {
        int i = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$JwtEcdsaAlgorithm[jwtEcdsaAlgorithm.ordinal()];
        if (i == 1) {
            return JwtEcdsaParameters.Algorithm.ES256;
        }
        if (i == 2) {
            return JwtEcdsaParameters.Algorithm.ES384;
        }
        if (i == 3) {
            return JwtEcdsaParameters.Algorithm.ES512;
        }
        throw new GeneralSecurityException("Unable to parse algorithm: " + jwtEcdsaAlgorithm.getNumber());
    }

    private static JwtEcdsaKeyFormat serializeToJwtEcdsaKeyFormat(JwtEcdsaParameters jwtEcdsaParameters) throws GeneralSecurityException {
        if (!jwtEcdsaParameters.getKidStrategy().equals(JwtEcdsaParameters.KidStrategy.IGNORED) && !jwtEcdsaParameters.getKidStrategy().equals(JwtEcdsaParameters.KidStrategy.BASE64_ENCODED_KEY_ID)) {
            throw new GeneralSecurityException("Unable to serialize Parameters object with KidStrategy " + jwtEcdsaParameters.getKidStrategy());
        }
        return JwtEcdsaKeyFormat.newBuilder().setVersion(0).setAlgorithm(toProtoAlgorithm(jwtEcdsaParameters.getAlgorithm())).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ProtoParametersSerialization serializeParameters(JwtEcdsaParameters jwtEcdsaParameters) throws GeneralSecurityException {
        OutputPrefixType outputPrefixType = OutputPrefixType.TINK;
        if (jwtEcdsaParameters.getKidStrategy().equals(JwtEcdsaParameters.KidStrategy.IGNORED)) {
            outputPrefixType = OutputPrefixType.RAW;
        }
        return ProtoParametersSerialization.create(KeyTemplate.newBuilder().setTypeUrl(TYPE_URL).setValue(serializeToJwtEcdsaKeyFormat(jwtEcdsaParameters).toByteString()).setOutputPrefixType(outputPrefixType).build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JwtEcdsaParameters parseParameters(ProtoParametersSerialization protoParametersSerialization) throws GeneralSecurityException {
        if (!protoParametersSerialization.getKeyTemplate().getTypeUrl().equals(TYPE_URL)) {
            throw new IllegalArgumentException("Wrong type URL in call to JwtEcdsaParameters.parseParameters: " + protoParametersSerialization.getKeyTemplate().getTypeUrl());
        }
        try {
            JwtEcdsaKeyFormat from = JwtEcdsaKeyFormat.parseFrom(protoParametersSerialization.getKeyTemplate().getValue(), ExtensionRegistryLite.getEmptyRegistry());
            if (from.getVersion() != 0) {
                throw new GeneralSecurityException("Parsing HmacParameters failed: unknown Version " + from.getVersion());
            }
            JwtEcdsaParameters.KidStrategy kidStrategy = protoParametersSerialization.getKeyTemplate().getOutputPrefixType().equals(OutputPrefixType.TINK) ? JwtEcdsaParameters.KidStrategy.BASE64_ENCODED_KEY_ID : null;
            if (protoParametersSerialization.getKeyTemplate().getOutputPrefixType().equals(OutputPrefixType.RAW)) {
                kidStrategy = JwtEcdsaParameters.KidStrategy.IGNORED;
            }
            if (kidStrategy == null) {
                throw new GeneralSecurityException("Invalid OutputPrefixType for JwtHmacKeyFormat");
            }
            return JwtEcdsaParameters.builder().setAlgorithm(toAlgorithm(from.getAlgorithm())).setKidStrategy(kidStrategy).build();
        } catch (InvalidProtocolBufferException e) {
            throw new GeneralSecurityException("Parsing JwtEcdsaKeyFormat failed: ", e);
        }
    }

    private static int getEncodingLength(JwtEcdsaParameters.Algorithm algorithm) throws GeneralSecurityException {
        if (algorithm.equals(JwtEcdsaParameters.Algorithm.ES256)) {
            return 33;
        }
        if (algorithm.equals(JwtEcdsaParameters.Algorithm.ES384)) {
            return 49;
        }
        if (algorithm.equals(JwtEcdsaParameters.Algorithm.ES512)) {
            return 67;
        }
        throw new GeneralSecurityException("Unknown algorithm: " + algorithm);
    }

    private static OutputPrefixType toProtoOutputPrefixType(JwtEcdsaParameters jwtEcdsaParameters) {
        if (jwtEcdsaParameters.getKidStrategy().equals(JwtEcdsaParameters.KidStrategy.BASE64_ENCODED_KEY_ID)) {
            return OutputPrefixType.TINK;
        }
        return OutputPrefixType.RAW;
    }

    private static com.google.crypto.tink.proto.JwtEcdsaPublicKey serializePublicKey(JwtEcdsaPublicKey jwtEcdsaPublicKey) throws GeneralSecurityException {
        int encodingLength = getEncodingLength(jwtEcdsaPublicKey.getParameters().getAlgorithm());
        ECPoint publicPoint = jwtEcdsaPublicKey.getPublicPoint();
        com.google.crypto.tink.proto.JwtEcdsaPublicKey.Builder y = com.google.crypto.tink.proto.JwtEcdsaPublicKey.newBuilder().setVersion(0).setAlgorithm(toProtoAlgorithm(jwtEcdsaPublicKey.getParameters().getAlgorithm())).setX(ByteString.copyFrom(BigIntegerEncoding.toBigEndianBytesOfFixedLength(publicPoint.getAffineX(), encodingLength))).setY(ByteString.copyFrom(BigIntegerEncoding.toBigEndianBytesOfFixedLength(publicPoint.getAffineY(), encodingLength)));
        if (jwtEcdsaPublicKey.getParameters().getKidStrategy().equals(JwtEcdsaParameters.KidStrategy.CUSTOM)) {
            y.setCustomKid(com.google.crypto.tink.proto.JwtEcdsaPublicKey.CustomKid.newBuilder().setValue(jwtEcdsaPublicKey.getKid().get()).build());
        }
        return y.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ProtoKeySerialization serializePublicKey(JwtEcdsaPublicKey jwtEcdsaPublicKey, @Nullable SecretKeyAccess secretKeyAccess) throws GeneralSecurityException {
        return ProtoKeySerialization.create(PUBLIC_TYPE_URL, serializePublicKey(jwtEcdsaPublicKey).toByteString(), KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC, toProtoOutputPrefixType(jwtEcdsaPublicKey.getParameters()), jwtEcdsaPublicKey.getIdRequirementOrNull());
    }

    private static JwtEcdsaPublicKey parsePublicKeyFromProto(com.google.crypto.tink.proto.JwtEcdsaPublicKey jwtEcdsaPublicKey, OutputPrefixType outputPrefixType, @Nullable Integer num) throws GeneralSecurityException {
        if (jwtEcdsaPublicKey.getVersion() != 0) {
            throw new GeneralSecurityException("Only version 0 keys are accepted");
        }
        JwtEcdsaParameters.Builder builder = JwtEcdsaParameters.builder();
        JwtEcdsaPublicKey.Builder builder2 = JwtEcdsaPublicKey.builder();
        if (outputPrefixType.equals(OutputPrefixType.TINK)) {
            if (jwtEcdsaPublicKey.hasCustomKid()) {
                throw new GeneralSecurityException("Keys serialized with OutputPrefixType TINK should not have a custom kid");
            }
            if (num == null) {
                throw new GeneralSecurityException("Keys serialized with OutputPrefixType TINK need an ID Requirement");
            }
            builder.setKidStrategy(JwtEcdsaParameters.KidStrategy.BASE64_ENCODED_KEY_ID);
            builder2.setIdRequirement(num);
        } else if (outputPrefixType.equals(OutputPrefixType.RAW)) {
            if (jwtEcdsaPublicKey.hasCustomKid()) {
                builder.setKidStrategy(JwtEcdsaParameters.KidStrategy.CUSTOM);
                builder2.setCustomKid(jwtEcdsaPublicKey.getCustomKid().getValue());
            } else {
                builder.setKidStrategy(JwtEcdsaParameters.KidStrategy.IGNORED);
            }
        }
        builder.setAlgorithm(toAlgorithm(jwtEcdsaPublicKey.getAlgorithm()));
        builder2.setPublicPoint(new ECPoint(BigIntegerEncoding.fromUnsignedBigEndianBytes(jwtEcdsaPublicKey.getX().toByteArray()), BigIntegerEncoding.fromUnsignedBigEndianBytes(jwtEcdsaPublicKey.getY().toByteArray())));
        return builder2.setParameters(builder.build()).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JwtEcdsaPublicKey parsePublicKey(ProtoKeySerialization protoKeySerialization, @Nullable SecretKeyAccess secretKeyAccess) throws GeneralSecurityException {
        if (!protoKeySerialization.getTypeUrl().equals(PUBLIC_TYPE_URL)) {
            throw new IllegalArgumentException("Wrong type URL in call to EcdsaProtoSerialization.parsePublicKey: " + protoKeySerialization.getTypeUrl());
        }
        try {
            return parsePublicKeyFromProto(com.google.crypto.tink.proto.JwtEcdsaPublicKey.parseFrom(protoKeySerialization.getValue(), ExtensionRegistryLite.getEmptyRegistry()), protoKeySerialization.getOutputPrefixType(), protoKeySerialization.getIdRequirementOrNull());
        } catch (InvalidProtocolBufferException unused) {
            throw new GeneralSecurityException("Parsing EcdsaPublicKey failed");
        }
    }

    private static com.google.crypto.tink.proto.JwtEcdsaPrivateKey serializePrivateKeyToProto(JwtEcdsaPrivateKey jwtEcdsaPrivateKey, SecretKeyAccess secretKeyAccess) throws GeneralSecurityException {
        return com.google.crypto.tink.proto.JwtEcdsaPrivateKey.newBuilder().setPublicKey(serializePublicKey(jwtEcdsaPrivateKey.getPublicKey())).setKeyValue(ByteString.copyFrom(BigIntegerEncoding.toBigEndianBytesOfFixedLength(jwtEcdsaPrivateKey.getPrivateValue().getBigInteger(secretKeyAccess), getEncodingLength(jwtEcdsaPrivateKey.getParameters().getAlgorithm())))).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ProtoKeySerialization serializePrivateKey(JwtEcdsaPrivateKey jwtEcdsaPrivateKey, @Nullable SecretKeyAccess secretKeyAccess) throws GeneralSecurityException {
        return ProtoKeySerialization.create(TYPE_URL, serializePrivateKeyToProto(jwtEcdsaPrivateKey, SecretKeyAccess.requireAccess(secretKeyAccess)).toByteString(), KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE, toProtoOutputPrefixType(jwtEcdsaPrivateKey.getParameters()), jwtEcdsaPrivateKey.getIdRequirementOrNull());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JwtEcdsaPrivateKey parsePrivateKey(ProtoKeySerialization protoKeySerialization, @Nullable SecretKeyAccess secretKeyAccess) throws GeneralSecurityException {
        if (!protoKeySerialization.getTypeUrl().equals(TYPE_URL)) {
            throw new IllegalArgumentException("Wrong type URL in call to EcdsaProtoSerialization.parsePublicKey: " + protoKeySerialization.getTypeUrl());
        }
        try {
            com.google.crypto.tink.proto.JwtEcdsaPrivateKey from = com.google.crypto.tink.proto.JwtEcdsaPrivateKey.parseFrom(protoKeySerialization.getValue(), ExtensionRegistryLite.getEmptyRegistry());
            if (from.getVersion() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            return JwtEcdsaPrivateKey.create(parsePublicKeyFromProto(from.getPublicKey(), protoKeySerialization.getOutputPrefixType(), protoKeySerialization.getIdRequirementOrNull()), SecretBigInteger.fromBigInteger(BigIntegerEncoding.fromUnsignedBigEndianBytes(from.getKeyValue().toByteArray()), SecretKeyAccess.requireAccess(secretKeyAccess)));
        } catch (InvalidProtocolBufferException unused) {
            throw new GeneralSecurityException("Parsing EcdsaPrivateKey failed");
        }
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

    private JwtEcdsaProtoSerialization() {
    }
}
