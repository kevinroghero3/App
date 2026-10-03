package com.google.crypto.tink.jwt.internal;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.SecretKeyAccess;
import com.google.crypto.tink.internal.BigIntegerEncoding;
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
import com.google.crypto.tink.jwt.JwtRsaSsaPssParameters;
import com.google.crypto.tink.jwt.JwtRsaSsaPssPrivateKey;
import com.google.crypto.tink.jwt.JwtRsaSsaPssPublicKey;
import com.google.crypto.tink.proto.JwtRsaSsaPssAlgorithm;
import com.google.crypto.tink.proto.JwtRsaSsaPssKeyFormat;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.util.Bytes;
import com.google.crypto.tink.util.SecretBigInteger;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class JwtRsaSsaPssProtoSerialization {
    private static final EnumTypeProtoConverter<JwtRsaSsaPssAlgorithm, JwtRsaSsaPssParameters.Algorithm> ALGORITHM_CONVERTER;
    private static final ParametersParser<ProtoParametersSerialization> PARAMETERS_PARSER;
    private static final ParametersSerializer<JwtRsaSsaPssParameters, ProtoParametersSerialization> PARAMETERS_SERIALIZER;
    private static final KeyParser<ProtoKeySerialization> PRIVATE_KEY_PARSER;
    private static final KeySerializer<JwtRsaSsaPssPrivateKey, ProtoKeySerialization> PRIVATE_KEY_SERIALIZER;
    private static final String PRIVATE_TYPE_URL = "type.googleapis.com/google.crypto.tink.JwtRsaSsaPssPrivateKey";
    private static final Bytes PRIVATE_TYPE_URL_BYTES;
    private static final KeyParser<ProtoKeySerialization> PUBLIC_KEY_PARSER;
    private static final KeySerializer<JwtRsaSsaPssPublicKey, ProtoKeySerialization> PUBLIC_KEY_SERIALIZER;
    private static final String PUBLIC_TYPE_URL = "type.googleapis.com/google.crypto.tink.JwtRsaSsaPssPublicKey";
    private static final Bytes PUBLIC_TYPE_URL_BYTES;

    static {
        Bytes bytesFromPrintableAscii = Util.toBytesFromPrintableAscii(PRIVATE_TYPE_URL);
        PRIVATE_TYPE_URL_BYTES = bytesFromPrintableAscii;
        Bytes bytesFromPrintableAscii2 = Util.toBytesFromPrintableAscii(PUBLIC_TYPE_URL);
        PUBLIC_TYPE_URL_BYTES = bytesFromPrintableAscii2;
        PARAMETERS_SERIALIZER = ParametersSerializer.create(new ParametersSerializer.ParametersSerializationFunction() { // from class: com.google.crypto.tink.jwt.internal.JwtRsaSsaPssProtoSerialization$$ExternalSyntheticLambda0
            @Override // com.google.crypto.tink.internal.ParametersSerializer.ParametersSerializationFunction
            public final Serialization serializeParameters(Parameters parameters) {
                return JwtRsaSsaPssProtoSerialization.serializeParameters((JwtRsaSsaPssParameters) parameters);
            }
        }, JwtRsaSsaPssParameters.class, ProtoParametersSerialization.class);
        PARAMETERS_PARSER = ParametersParser.create(new ParametersParser.ParametersParsingFunction() { // from class: com.google.crypto.tink.jwt.internal.JwtRsaSsaPssProtoSerialization$$ExternalSyntheticLambda1
            @Override // com.google.crypto.tink.internal.ParametersParser.ParametersParsingFunction
            public final Parameters parseParameters(Serialization serialization) {
                return JwtRsaSsaPssProtoSerialization.parseParameters((ProtoParametersSerialization) serialization);
            }
        }, bytesFromPrintableAscii, ProtoParametersSerialization.class);
        PUBLIC_KEY_SERIALIZER = KeySerializer.create(new KeySerializer.KeySerializationFunction() { // from class: com.google.crypto.tink.jwt.internal.JwtRsaSsaPssProtoSerialization$$ExternalSyntheticLambda2
            @Override // com.google.crypto.tink.internal.KeySerializer.KeySerializationFunction
            public final Serialization serializeKey(Key key, SecretKeyAccess secretKeyAccess) {
                return JwtRsaSsaPssProtoSerialization.serializePublicKey((JwtRsaSsaPssPublicKey) key, secretKeyAccess);
            }
        }, JwtRsaSsaPssPublicKey.class, ProtoKeySerialization.class);
        PUBLIC_KEY_PARSER = KeyParser.create(new KeyParser.KeyParsingFunction() { // from class: com.google.crypto.tink.jwt.internal.JwtRsaSsaPssProtoSerialization$$ExternalSyntheticLambda3
            @Override // com.google.crypto.tink.internal.KeyParser.KeyParsingFunction
            public final Key parseKey(Serialization serialization, SecretKeyAccess secretKeyAccess) {
                return JwtRsaSsaPssProtoSerialization.parsePublicKey((ProtoKeySerialization) serialization, secretKeyAccess);
            }
        }, bytesFromPrintableAscii2, ProtoKeySerialization.class);
        PRIVATE_KEY_SERIALIZER = KeySerializer.create(new KeySerializer.KeySerializationFunction() { // from class: com.google.crypto.tink.jwt.internal.JwtRsaSsaPssProtoSerialization$$ExternalSyntheticLambda4
            @Override // com.google.crypto.tink.internal.KeySerializer.KeySerializationFunction
            public final Serialization serializeKey(Key key, SecretKeyAccess secretKeyAccess) {
                return JwtRsaSsaPssProtoSerialization.serializePrivateKey((JwtRsaSsaPssPrivateKey) key, secretKeyAccess);
            }
        }, JwtRsaSsaPssPrivateKey.class, ProtoKeySerialization.class);
        PRIVATE_KEY_PARSER = KeyParser.create(new KeyParser.KeyParsingFunction() { // from class: com.google.crypto.tink.jwt.internal.JwtRsaSsaPssProtoSerialization$$ExternalSyntheticLambda5
            @Override // com.google.crypto.tink.internal.KeyParser.KeyParsingFunction
            public final Key parseKey(Serialization serialization, SecretKeyAccess secretKeyAccess) {
                return JwtRsaSsaPssProtoSerialization.parsePrivateKey((ProtoKeySerialization) serialization, secretKeyAccess);
            }
        }, bytesFromPrintableAscii, ProtoKeySerialization.class);
        ALGORITHM_CONVERTER = EnumTypeProtoConverter.builder().add(JwtRsaSsaPssAlgorithm.PS256, JwtRsaSsaPssParameters.Algorithm.PS256).add(JwtRsaSsaPssAlgorithm.PS384, JwtRsaSsaPssParameters.Algorithm.PS384).add(JwtRsaSsaPssAlgorithm.PS512, JwtRsaSsaPssParameters.Algorithm.PS512).build();
    }

    private static OutputPrefixType toProtoOutputPrefixType(JwtRsaSsaPssParameters jwtRsaSsaPssParameters) {
        if (jwtRsaSsaPssParameters.getKidStrategy().equals(JwtRsaSsaPssParameters.KidStrategy.BASE64_ENCODED_KEY_ID)) {
            return OutputPrefixType.TINK;
        }
        return OutputPrefixType.RAW;
    }

    private static ByteString encodeBigInteger(BigInteger bigInteger) {
        return ByteString.copyFrom(BigIntegerEncoding.toBigEndianBytes(bigInteger));
    }

    private static JwtRsaSsaPssKeyFormat getProtoKeyFormat(JwtRsaSsaPssParameters jwtRsaSsaPssParameters) throws GeneralSecurityException {
        if (!jwtRsaSsaPssParameters.getKidStrategy().equals(JwtRsaSsaPssParameters.KidStrategy.IGNORED) && !jwtRsaSsaPssParameters.getKidStrategy().equals(JwtRsaSsaPssParameters.KidStrategy.BASE64_ENCODED_KEY_ID)) {
            throw new GeneralSecurityException("Unable to serialize Parameters object with KidStrategy " + jwtRsaSsaPssParameters.getKidStrategy());
        }
        return JwtRsaSsaPssKeyFormat.newBuilder().setVersion(0).setAlgorithm((JwtRsaSsaPssAlgorithm) ALGORITHM_CONVERTER.toProtoEnum(jwtRsaSsaPssParameters.getAlgorithm())).setModulusSizeInBits(jwtRsaSsaPssParameters.getModulusSizeBits()).setPublicExponent(encodeBigInteger(jwtRsaSsaPssParameters.getPublicExponent())).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ProtoParametersSerialization serializeParameters(JwtRsaSsaPssParameters jwtRsaSsaPssParameters) throws GeneralSecurityException {
        return ProtoParametersSerialization.create(KeyTemplate.newBuilder().setTypeUrl(PRIVATE_TYPE_URL).setValue(getProtoKeyFormat(jwtRsaSsaPssParameters).toByteString()).setOutputPrefixType(toProtoOutputPrefixType(jwtRsaSsaPssParameters)).build());
    }

    private static com.google.crypto.tink.proto.JwtRsaSsaPssPublicKey getProtoPublicKey(JwtRsaSsaPssPublicKey jwtRsaSsaPssPublicKey) throws GeneralSecurityException {
        com.google.crypto.tink.proto.JwtRsaSsaPssPublicKey.Builder e = com.google.crypto.tink.proto.JwtRsaSsaPssPublicKey.newBuilder().setVersion(0).setAlgorithm((JwtRsaSsaPssAlgorithm) ALGORITHM_CONVERTER.toProtoEnum(jwtRsaSsaPssPublicKey.getParameters().getAlgorithm())).setN(encodeBigInteger(jwtRsaSsaPssPublicKey.getModulus())).setE(encodeBigInteger(jwtRsaSsaPssPublicKey.getParameters().getPublicExponent()));
        if (jwtRsaSsaPssPublicKey.getParameters().getKidStrategy().equals(JwtRsaSsaPssParameters.KidStrategy.CUSTOM)) {
            e.setCustomKid(com.google.crypto.tink.proto.JwtRsaSsaPssPublicKey.CustomKid.newBuilder().setValue(jwtRsaSsaPssPublicKey.getKid().get()).build());
        }
        return e.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ProtoKeySerialization serializePublicKey(JwtRsaSsaPssPublicKey jwtRsaSsaPssPublicKey, @Nullable SecretKeyAccess secretKeyAccess) throws GeneralSecurityException {
        return ProtoKeySerialization.create(PUBLIC_TYPE_URL, getProtoPublicKey(jwtRsaSsaPssPublicKey).toByteString(), KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC, toProtoOutputPrefixType(jwtRsaSsaPssPublicKey.getParameters()), jwtRsaSsaPssPublicKey.getIdRequirementOrNull());
    }

    private static ByteString encodeSecretBigInteger(SecretBigInteger secretBigInteger, SecretKeyAccess secretKeyAccess) {
        return encodeBigInteger(secretBigInteger.getBigInteger(secretKeyAccess));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ProtoKeySerialization serializePrivateKey(JwtRsaSsaPssPrivateKey jwtRsaSsaPssPrivateKey, @Nullable SecretKeyAccess secretKeyAccess) throws GeneralSecurityException {
        SecretKeyAccess secretKeyAccessRequireAccess = SecretKeyAccess.requireAccess(secretKeyAccess);
        return ProtoKeySerialization.create(PRIVATE_TYPE_URL, com.google.crypto.tink.proto.JwtRsaSsaPssPrivateKey.newBuilder().setVersion(0).setPublicKey(getProtoPublicKey(jwtRsaSsaPssPrivateKey.getPublicKey())).setD(encodeSecretBigInteger(jwtRsaSsaPssPrivateKey.getPrivateExponent(), secretKeyAccessRequireAccess)).setP(encodeSecretBigInteger(jwtRsaSsaPssPrivateKey.getPrimeP(), secretKeyAccessRequireAccess)).setQ(encodeSecretBigInteger(jwtRsaSsaPssPrivateKey.getPrimeQ(), secretKeyAccessRequireAccess)).setDp(encodeSecretBigInteger(jwtRsaSsaPssPrivateKey.getPrimeExponentP(), secretKeyAccessRequireAccess)).setDq(encodeSecretBigInteger(jwtRsaSsaPssPrivateKey.getPrimeExponentQ(), secretKeyAccessRequireAccess)).setCrt(encodeSecretBigInteger(jwtRsaSsaPssPrivateKey.getCrtCoefficient(), secretKeyAccessRequireAccess)).build().toByteString(), KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE, toProtoOutputPrefixType(jwtRsaSsaPssPrivateKey.getParameters()), jwtRsaSsaPssPrivateKey.getIdRequirementOrNull());
    }

    private static BigInteger decodeBigInteger(ByteString byteString) {
        return BigIntegerEncoding.fromUnsignedBigEndianBytes(byteString.toByteArray());
    }

    private static void validateVersion(int i) throws GeneralSecurityException {
        if (i == 0) {
            return;
        }
        throw new GeneralSecurityException("Parsing failed: unknown version " + i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JwtRsaSsaPssParameters parseParameters(ProtoParametersSerialization protoParametersSerialization) throws GeneralSecurityException {
        if (!protoParametersSerialization.getKeyTemplate().getTypeUrl().equals(PRIVATE_TYPE_URL)) {
            throw new IllegalArgumentException("Wrong type URL in call to JwtRsaSsaPssProtoSerialization.parseParameters: " + protoParametersSerialization.getKeyTemplate().getTypeUrl());
        }
        try {
            JwtRsaSsaPssKeyFormat from = JwtRsaSsaPssKeyFormat.parseFrom(protoParametersSerialization.getKeyTemplate().getValue(), ExtensionRegistryLite.getEmptyRegistry());
            validateVersion(from.getVersion());
            JwtRsaSsaPssParameters.KidStrategy kidStrategy = protoParametersSerialization.getKeyTemplate().getOutputPrefixType().equals(OutputPrefixType.TINK) ? JwtRsaSsaPssParameters.KidStrategy.BASE64_ENCODED_KEY_ID : null;
            if (protoParametersSerialization.getKeyTemplate().getOutputPrefixType().equals(OutputPrefixType.RAW)) {
                kidStrategy = JwtRsaSsaPssParameters.KidStrategy.IGNORED;
            }
            if (kidStrategy == null) {
                throw new GeneralSecurityException("Invalid OutputPrefixType for JwtHmacKeyFormat");
            }
            return JwtRsaSsaPssParameters.builder().setKidStrategy(kidStrategy).setAlgorithm(ALGORITHM_CONVERTER.fromProtoEnum(from.getAlgorithm())).setPublicExponent(decodeBigInteger(from.getPublicExponent())).setModulusSizeBits(from.getModulusSizeInBits()).build();
        } catch (InvalidProtocolBufferException e) {
            throw new GeneralSecurityException("Parsing JwtRsaSsaPssParameters failed: ", e);
        }
    }

    private static JwtRsaSsaPssPublicKey getPublicKeyFromProto(com.google.crypto.tink.proto.JwtRsaSsaPssPublicKey jwtRsaSsaPssPublicKey, OutputPrefixType outputPrefixType, @Nullable Integer num) throws GeneralSecurityException {
        validateVersion(jwtRsaSsaPssPublicKey.getVersion());
        JwtRsaSsaPssParameters.Builder builder = JwtRsaSsaPssParameters.builder();
        JwtRsaSsaPssPublicKey.Builder builder2 = JwtRsaSsaPssPublicKey.builder();
        if (outputPrefixType.equals(OutputPrefixType.TINK)) {
            if (jwtRsaSsaPssPublicKey.hasCustomKid()) {
                throw new GeneralSecurityException("Keys serialized with OutputPrefixType TINK should not have a custom kid");
            }
            if (num == null) {
                throw new GeneralSecurityException("Keys serialized with OutputPrefixType TINK need an ID Requirement");
            }
            builder.setKidStrategy(JwtRsaSsaPssParameters.KidStrategy.BASE64_ENCODED_KEY_ID);
            builder2.setIdRequirement(num);
        } else if (outputPrefixType.equals(OutputPrefixType.RAW)) {
            if (jwtRsaSsaPssPublicKey.hasCustomKid()) {
                builder.setKidStrategy(JwtRsaSsaPssParameters.KidStrategy.CUSTOM);
                builder2.setCustomKid(jwtRsaSsaPssPublicKey.getCustomKid().getValue());
            } else {
                builder.setKidStrategy(JwtRsaSsaPssParameters.KidStrategy.IGNORED);
            }
        }
        BigInteger bigIntegerDecodeBigInteger = decodeBigInteger(jwtRsaSsaPssPublicKey.getN());
        builder.setAlgorithm(ALGORITHM_CONVERTER.fromProtoEnum(jwtRsaSsaPssPublicKey.getAlgorithm())).setPublicExponent(decodeBigInteger(jwtRsaSsaPssPublicKey.getE())).setModulusSizeBits(bigIntegerDecodeBigInteger.bitLength());
        builder2.setModulus(bigIntegerDecodeBigInteger).setParameters(builder.build());
        return builder2.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JwtRsaSsaPssPublicKey parsePublicKey(ProtoKeySerialization protoKeySerialization, @Nullable SecretKeyAccess secretKeyAccess) throws GeneralSecurityException {
        if (!protoKeySerialization.getTypeUrl().equals(PUBLIC_TYPE_URL)) {
            throw new IllegalArgumentException("Wrong type URL in call to JwtRsaSsaPssProtoSerialization.parsePublicKey: " + protoKeySerialization.getTypeUrl());
        }
        try {
            return getPublicKeyFromProto(com.google.crypto.tink.proto.JwtRsaSsaPssPublicKey.parseFrom(protoKeySerialization.getValue(), ExtensionRegistryLite.getEmptyRegistry()), protoKeySerialization.getOutputPrefixType(), protoKeySerialization.getIdRequirementOrNull());
        } catch (InvalidProtocolBufferException unused) {
            throw new GeneralSecurityException("Parsing JwtRsaSsaPssPublicKey failed");
        }
    }

    private static SecretBigInteger decodeSecretBigInteger(ByteString byteString, SecretKeyAccess secretKeyAccess) {
        return SecretBigInteger.fromBigInteger(BigIntegerEncoding.fromUnsignedBigEndianBytes(byteString.toByteArray()), secretKeyAccess);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JwtRsaSsaPssPrivateKey parsePrivateKey(ProtoKeySerialization protoKeySerialization, @Nullable SecretKeyAccess secretKeyAccess) throws GeneralSecurityException {
        if (!protoKeySerialization.getTypeUrl().equals(PRIVATE_TYPE_URL)) {
            throw new IllegalArgumentException("Wrong type URL in call to JwtRsaSsaPssProtoSerialization.parsePrivateKey: " + protoKeySerialization.getTypeUrl());
        }
        try {
            com.google.crypto.tink.proto.JwtRsaSsaPssPrivateKey from = com.google.crypto.tink.proto.JwtRsaSsaPssPrivateKey.parseFrom(protoKeySerialization.getValue(), ExtensionRegistryLite.getEmptyRegistry());
            validateVersion(from.getVersion());
            JwtRsaSsaPssPublicKey publicKeyFromProto = getPublicKeyFromProto(from.getPublicKey(), protoKeySerialization.getOutputPrefixType(), protoKeySerialization.getIdRequirementOrNull());
            SecretKeyAccess secretKeyAccessRequireAccess = SecretKeyAccess.requireAccess(secretKeyAccess);
            return JwtRsaSsaPssPrivateKey.builder().setPublicKey(publicKeyFromProto).setPrimes(decodeSecretBigInteger(from.getP(), secretKeyAccessRequireAccess), decodeSecretBigInteger(from.getQ(), secretKeyAccessRequireAccess)).setPrivateExponent(decodeSecretBigInteger(from.getD(), secretKeyAccessRequireAccess)).setPrimeExponents(decodeSecretBigInteger(from.getDp(), secretKeyAccessRequireAccess), decodeSecretBigInteger(from.getDq(), secretKeyAccessRequireAccess)).setCrtCoefficient(decodeSecretBigInteger(from.getCrt(), secretKeyAccessRequireAccess)).build();
        } catch (InvalidProtocolBufferException unused) {
            throw new GeneralSecurityException("Parsing JwtRsaSsaPssPrivateKey failed");
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

    private JwtRsaSsaPssProtoSerialization() {
    }
}
