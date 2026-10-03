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
import com.google.crypto.tink.jwt.JwtRsaSsaPkcs1Parameters;
import com.google.crypto.tink.jwt.JwtRsaSsaPkcs1PrivateKey;
import com.google.crypto.tink.jwt.JwtRsaSsaPkcs1PublicKey;
import com.google.crypto.tink.proto.JwtRsaSsaPkcs1Algorithm;
import com.google.crypto.tink.proto.JwtRsaSsaPkcs1KeyFormat;
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
public final class JwtRsaSsaPkcs1ProtoSerialization {
    private static final EnumTypeProtoConverter<JwtRsaSsaPkcs1Algorithm, JwtRsaSsaPkcs1Parameters.Algorithm> ALGORITHM_CONVERTER;
    private static final ParametersParser<ProtoParametersSerialization> PARAMETERS_PARSER;
    private static final ParametersSerializer<JwtRsaSsaPkcs1Parameters, ProtoParametersSerialization> PARAMETERS_SERIALIZER;
    private static final KeyParser<ProtoKeySerialization> PRIVATE_KEY_PARSER;
    private static final KeySerializer<JwtRsaSsaPkcs1PrivateKey, ProtoKeySerialization> PRIVATE_KEY_SERIALIZER;
    private static final String PRIVATE_TYPE_URL = "type.googleapis.com/google.crypto.tink.JwtRsaSsaPkcs1PrivateKey";
    private static final Bytes PRIVATE_TYPE_URL_BYTES;
    private static final KeyParser<ProtoKeySerialization> PUBLIC_KEY_PARSER;
    private static final KeySerializer<JwtRsaSsaPkcs1PublicKey, ProtoKeySerialization> PUBLIC_KEY_SERIALIZER;
    private static final String PUBLIC_TYPE_URL = "type.googleapis.com/google.crypto.tink.JwtRsaSsaPkcs1PublicKey";
    private static final Bytes PUBLIC_TYPE_URL_BYTES;

    static {
        Bytes bytesFromPrintableAscii = Util.toBytesFromPrintableAscii(PRIVATE_TYPE_URL);
        PRIVATE_TYPE_URL_BYTES = bytesFromPrintableAscii;
        Bytes bytesFromPrintableAscii2 = Util.toBytesFromPrintableAscii(PUBLIC_TYPE_URL);
        PUBLIC_TYPE_URL_BYTES = bytesFromPrintableAscii2;
        PARAMETERS_SERIALIZER = ParametersSerializer.create(new ParametersSerializer.ParametersSerializationFunction() { // from class: com.google.crypto.tink.jwt.internal.JwtRsaSsaPkcs1ProtoSerialization$$ExternalSyntheticLambda0
            @Override // com.google.crypto.tink.internal.ParametersSerializer.ParametersSerializationFunction
            public final Serialization serializeParameters(Parameters parameters) {
                return JwtRsaSsaPkcs1ProtoSerialization.serializeParameters((JwtRsaSsaPkcs1Parameters) parameters);
            }
        }, JwtRsaSsaPkcs1Parameters.class, ProtoParametersSerialization.class);
        PARAMETERS_PARSER = ParametersParser.create(new ParametersParser.ParametersParsingFunction() { // from class: com.google.crypto.tink.jwt.internal.JwtRsaSsaPkcs1ProtoSerialization$$ExternalSyntheticLambda1
            @Override // com.google.crypto.tink.internal.ParametersParser.ParametersParsingFunction
            public final Parameters parseParameters(Serialization serialization) {
                return JwtRsaSsaPkcs1ProtoSerialization.parseParameters((ProtoParametersSerialization) serialization);
            }
        }, bytesFromPrintableAscii, ProtoParametersSerialization.class);
        PUBLIC_KEY_SERIALIZER = KeySerializer.create(new KeySerializer.KeySerializationFunction() { // from class: com.google.crypto.tink.jwt.internal.JwtRsaSsaPkcs1ProtoSerialization$$ExternalSyntheticLambda2
            @Override // com.google.crypto.tink.internal.KeySerializer.KeySerializationFunction
            public final Serialization serializeKey(Key key, SecretKeyAccess secretKeyAccess) {
                return JwtRsaSsaPkcs1ProtoSerialization.serializePublicKey((JwtRsaSsaPkcs1PublicKey) key, secretKeyAccess);
            }
        }, JwtRsaSsaPkcs1PublicKey.class, ProtoKeySerialization.class);
        PUBLIC_KEY_PARSER = KeyParser.create(new KeyParser.KeyParsingFunction() { // from class: com.google.crypto.tink.jwt.internal.JwtRsaSsaPkcs1ProtoSerialization$$ExternalSyntheticLambda3
            @Override // com.google.crypto.tink.internal.KeyParser.KeyParsingFunction
            public final Key parseKey(Serialization serialization, SecretKeyAccess secretKeyAccess) {
                return JwtRsaSsaPkcs1ProtoSerialization.parsePublicKey((ProtoKeySerialization) serialization, secretKeyAccess);
            }
        }, bytesFromPrintableAscii2, ProtoKeySerialization.class);
        PRIVATE_KEY_SERIALIZER = KeySerializer.create(new KeySerializer.KeySerializationFunction() { // from class: com.google.crypto.tink.jwt.internal.JwtRsaSsaPkcs1ProtoSerialization$$ExternalSyntheticLambda4
            @Override // com.google.crypto.tink.internal.KeySerializer.KeySerializationFunction
            public final Serialization serializeKey(Key key, SecretKeyAccess secretKeyAccess) {
                return JwtRsaSsaPkcs1ProtoSerialization.serializePrivateKey((JwtRsaSsaPkcs1PrivateKey) key, secretKeyAccess);
            }
        }, JwtRsaSsaPkcs1PrivateKey.class, ProtoKeySerialization.class);
        PRIVATE_KEY_PARSER = KeyParser.create(new KeyParser.KeyParsingFunction() { // from class: com.google.crypto.tink.jwt.internal.JwtRsaSsaPkcs1ProtoSerialization$$ExternalSyntheticLambda5
            @Override // com.google.crypto.tink.internal.KeyParser.KeyParsingFunction
            public final Key parseKey(Serialization serialization, SecretKeyAccess secretKeyAccess) {
                return JwtRsaSsaPkcs1ProtoSerialization.parsePrivateKey((ProtoKeySerialization) serialization, secretKeyAccess);
            }
        }, bytesFromPrintableAscii, ProtoKeySerialization.class);
        ALGORITHM_CONVERTER = EnumTypeProtoConverter.builder().add(JwtRsaSsaPkcs1Algorithm.RS256, JwtRsaSsaPkcs1Parameters.Algorithm.RS256).add(JwtRsaSsaPkcs1Algorithm.RS384, JwtRsaSsaPkcs1Parameters.Algorithm.RS384).add(JwtRsaSsaPkcs1Algorithm.RS512, JwtRsaSsaPkcs1Parameters.Algorithm.RS512).build();
    }

    private static OutputPrefixType toProtoOutputPrefixType(JwtRsaSsaPkcs1Parameters jwtRsaSsaPkcs1Parameters) {
        if (jwtRsaSsaPkcs1Parameters.getKidStrategy().equals(JwtRsaSsaPkcs1Parameters.KidStrategy.BASE64_ENCODED_KEY_ID)) {
            return OutputPrefixType.TINK;
        }
        return OutputPrefixType.RAW;
    }

    private static ByteString encodeBigInteger(BigInteger bigInteger) {
        return ByteString.copyFrom(BigIntegerEncoding.toBigEndianBytes(bigInteger));
    }

    private static JwtRsaSsaPkcs1KeyFormat getProtoKeyFormat(JwtRsaSsaPkcs1Parameters jwtRsaSsaPkcs1Parameters) throws GeneralSecurityException {
        if (!jwtRsaSsaPkcs1Parameters.getKidStrategy().equals(JwtRsaSsaPkcs1Parameters.KidStrategy.IGNORED) && !jwtRsaSsaPkcs1Parameters.getKidStrategy().equals(JwtRsaSsaPkcs1Parameters.KidStrategy.BASE64_ENCODED_KEY_ID)) {
            throw new GeneralSecurityException("Unable to serialize Parameters object with KidStrategy " + jwtRsaSsaPkcs1Parameters.getKidStrategy());
        }
        return JwtRsaSsaPkcs1KeyFormat.newBuilder().setVersion(0).setAlgorithm((JwtRsaSsaPkcs1Algorithm) ALGORITHM_CONVERTER.toProtoEnum(jwtRsaSsaPkcs1Parameters.getAlgorithm())).setModulusSizeInBits(jwtRsaSsaPkcs1Parameters.getModulusSizeBits()).setPublicExponent(encodeBigInteger(jwtRsaSsaPkcs1Parameters.getPublicExponent())).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ProtoParametersSerialization serializeParameters(JwtRsaSsaPkcs1Parameters jwtRsaSsaPkcs1Parameters) throws GeneralSecurityException {
        return ProtoParametersSerialization.create(KeyTemplate.newBuilder().setTypeUrl(PRIVATE_TYPE_URL).setValue(getProtoKeyFormat(jwtRsaSsaPkcs1Parameters).toByteString()).setOutputPrefixType(toProtoOutputPrefixType(jwtRsaSsaPkcs1Parameters)).build());
    }

    private static com.google.crypto.tink.proto.JwtRsaSsaPkcs1PublicKey getProtoPublicKey(JwtRsaSsaPkcs1PublicKey jwtRsaSsaPkcs1PublicKey) throws GeneralSecurityException {
        com.google.crypto.tink.proto.JwtRsaSsaPkcs1PublicKey.Builder e = com.google.crypto.tink.proto.JwtRsaSsaPkcs1PublicKey.newBuilder().setVersion(0).setAlgorithm((JwtRsaSsaPkcs1Algorithm) ALGORITHM_CONVERTER.toProtoEnum(jwtRsaSsaPkcs1PublicKey.getParameters().getAlgorithm())).setN(encodeBigInteger(jwtRsaSsaPkcs1PublicKey.getModulus())).setE(encodeBigInteger(jwtRsaSsaPkcs1PublicKey.getParameters().getPublicExponent()));
        if (jwtRsaSsaPkcs1PublicKey.getParameters().getKidStrategy().equals(JwtRsaSsaPkcs1Parameters.KidStrategy.CUSTOM)) {
            e.setCustomKid(com.google.crypto.tink.proto.JwtRsaSsaPkcs1PublicKey.CustomKid.newBuilder().setValue(jwtRsaSsaPkcs1PublicKey.getKid().get()).build());
        }
        return e.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ProtoKeySerialization serializePublicKey(JwtRsaSsaPkcs1PublicKey jwtRsaSsaPkcs1PublicKey, @Nullable SecretKeyAccess secretKeyAccess) throws GeneralSecurityException {
        return ProtoKeySerialization.create(PUBLIC_TYPE_URL, getProtoPublicKey(jwtRsaSsaPkcs1PublicKey).toByteString(), KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC, toProtoOutputPrefixType(jwtRsaSsaPkcs1PublicKey.getParameters()), jwtRsaSsaPkcs1PublicKey.getIdRequirementOrNull());
    }

    private static ByteString encodeSecretBigInteger(SecretBigInteger secretBigInteger, SecretKeyAccess secretKeyAccess) {
        return encodeBigInteger(secretBigInteger.getBigInteger(secretKeyAccess));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ProtoKeySerialization serializePrivateKey(JwtRsaSsaPkcs1PrivateKey jwtRsaSsaPkcs1PrivateKey, @Nullable SecretKeyAccess secretKeyAccess) throws GeneralSecurityException {
        SecretKeyAccess secretKeyAccessRequireAccess = SecretKeyAccess.requireAccess(secretKeyAccess);
        return ProtoKeySerialization.create(PRIVATE_TYPE_URL, com.google.crypto.tink.proto.JwtRsaSsaPkcs1PrivateKey.newBuilder().setVersion(0).setPublicKey(getProtoPublicKey(jwtRsaSsaPkcs1PrivateKey.getPublicKey())).setD(encodeSecretBigInteger(jwtRsaSsaPkcs1PrivateKey.getPrivateExponent(), secretKeyAccessRequireAccess)).setP(encodeSecretBigInteger(jwtRsaSsaPkcs1PrivateKey.getPrimeP(), secretKeyAccessRequireAccess)).setQ(encodeSecretBigInteger(jwtRsaSsaPkcs1PrivateKey.getPrimeQ(), secretKeyAccessRequireAccess)).setDp(encodeSecretBigInteger(jwtRsaSsaPkcs1PrivateKey.getPrimeExponentP(), secretKeyAccessRequireAccess)).setDq(encodeSecretBigInteger(jwtRsaSsaPkcs1PrivateKey.getPrimeExponentQ(), secretKeyAccessRequireAccess)).setCrt(encodeSecretBigInteger(jwtRsaSsaPkcs1PrivateKey.getCrtCoefficient(), secretKeyAccessRequireAccess)).build().toByteString(), KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE, toProtoOutputPrefixType(jwtRsaSsaPkcs1PrivateKey.getParameters()), jwtRsaSsaPkcs1PrivateKey.getIdRequirementOrNull());
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
    public static JwtRsaSsaPkcs1Parameters parseParameters(ProtoParametersSerialization protoParametersSerialization) throws GeneralSecurityException {
        if (!protoParametersSerialization.getKeyTemplate().getTypeUrl().equals(PRIVATE_TYPE_URL)) {
            throw new IllegalArgumentException("Wrong type URL in call to JwtRsaSsaPkcs1ProtoSerialization.parseParameters: " + protoParametersSerialization.getKeyTemplate().getTypeUrl());
        }
        try {
            JwtRsaSsaPkcs1KeyFormat from = JwtRsaSsaPkcs1KeyFormat.parseFrom(protoParametersSerialization.getKeyTemplate().getValue(), ExtensionRegistryLite.getEmptyRegistry());
            validateVersion(from.getVersion());
            JwtRsaSsaPkcs1Parameters.KidStrategy kidStrategy = protoParametersSerialization.getKeyTemplate().getOutputPrefixType().equals(OutputPrefixType.TINK) ? JwtRsaSsaPkcs1Parameters.KidStrategy.BASE64_ENCODED_KEY_ID : null;
            if (protoParametersSerialization.getKeyTemplate().getOutputPrefixType().equals(OutputPrefixType.RAW)) {
                kidStrategy = JwtRsaSsaPkcs1Parameters.KidStrategy.IGNORED;
            }
            if (kidStrategy == null) {
                throw new GeneralSecurityException("Invalid OutputPrefixType for JwtHmacKeyFormat");
            }
            return JwtRsaSsaPkcs1Parameters.builder().setKidStrategy(kidStrategy).setAlgorithm(ALGORITHM_CONVERTER.fromProtoEnum(from.getAlgorithm())).setPublicExponent(decodeBigInteger(from.getPublicExponent())).setModulusSizeBits(from.getModulusSizeInBits()).build();
        } catch (InvalidProtocolBufferException e) {
            throw new GeneralSecurityException("Parsing JwtRsaSsaPkcs1Parameters failed: ", e);
        }
    }

    private static JwtRsaSsaPkcs1PublicKey getPublicKeyFromProto(com.google.crypto.tink.proto.JwtRsaSsaPkcs1PublicKey jwtRsaSsaPkcs1PublicKey, OutputPrefixType outputPrefixType, @Nullable Integer num) throws GeneralSecurityException {
        validateVersion(jwtRsaSsaPkcs1PublicKey.getVersion());
        JwtRsaSsaPkcs1Parameters.Builder builder = JwtRsaSsaPkcs1Parameters.builder();
        JwtRsaSsaPkcs1PublicKey.Builder builder2 = JwtRsaSsaPkcs1PublicKey.builder();
        if (outputPrefixType.equals(OutputPrefixType.TINK)) {
            if (jwtRsaSsaPkcs1PublicKey.hasCustomKid()) {
                throw new GeneralSecurityException("Keys serialized with OutputPrefixType TINK should not have a custom kid");
            }
            if (num == null) {
                throw new GeneralSecurityException("Keys serialized with OutputPrefixType TINK need an ID Requirement");
            }
            builder.setKidStrategy(JwtRsaSsaPkcs1Parameters.KidStrategy.BASE64_ENCODED_KEY_ID);
            builder2.setIdRequirement(num);
        } else if (outputPrefixType.equals(OutputPrefixType.RAW)) {
            if (jwtRsaSsaPkcs1PublicKey.hasCustomKid()) {
                builder.setKidStrategy(JwtRsaSsaPkcs1Parameters.KidStrategy.CUSTOM);
                builder2.setCustomKid(jwtRsaSsaPkcs1PublicKey.getCustomKid().getValue());
            } else {
                builder.setKidStrategy(JwtRsaSsaPkcs1Parameters.KidStrategy.IGNORED);
            }
        }
        BigInteger bigIntegerDecodeBigInteger = decodeBigInteger(jwtRsaSsaPkcs1PublicKey.getN());
        builder.setAlgorithm(ALGORITHM_CONVERTER.fromProtoEnum(jwtRsaSsaPkcs1PublicKey.getAlgorithm())).setPublicExponent(decodeBigInteger(jwtRsaSsaPkcs1PublicKey.getE())).setModulusSizeBits(bigIntegerDecodeBigInteger.bitLength());
        builder2.setModulus(bigIntegerDecodeBigInteger).setParameters(builder.build());
        return builder2.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JwtRsaSsaPkcs1PublicKey parsePublicKey(ProtoKeySerialization protoKeySerialization, @Nullable SecretKeyAccess secretKeyAccess) throws GeneralSecurityException {
        if (!protoKeySerialization.getTypeUrl().equals(PUBLIC_TYPE_URL)) {
            throw new IllegalArgumentException("Wrong type URL in call to JwtRsaSsaPkcs1ProtoSerialization.parsePublicKey: " + protoKeySerialization.getTypeUrl());
        }
        try {
            return getPublicKeyFromProto(com.google.crypto.tink.proto.JwtRsaSsaPkcs1PublicKey.parseFrom(protoKeySerialization.getValue(), ExtensionRegistryLite.getEmptyRegistry()), protoKeySerialization.getOutputPrefixType(), protoKeySerialization.getIdRequirementOrNull());
        } catch (InvalidProtocolBufferException unused) {
            throw new GeneralSecurityException("Parsing JwtRsaSsaPkcs1PublicKey failed");
        }
    }

    private static SecretBigInteger decodeSecretBigInteger(ByteString byteString, SecretKeyAccess secretKeyAccess) {
        return SecretBigInteger.fromBigInteger(BigIntegerEncoding.fromUnsignedBigEndianBytes(byteString.toByteArray()), secretKeyAccess);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JwtRsaSsaPkcs1PrivateKey parsePrivateKey(ProtoKeySerialization protoKeySerialization, @Nullable SecretKeyAccess secretKeyAccess) throws GeneralSecurityException {
        if (!protoKeySerialization.getTypeUrl().equals(PRIVATE_TYPE_URL)) {
            throw new IllegalArgumentException("Wrong type URL in call to JwtRsaSsaPkcs1ProtoSerialization.parsePrivateKey: " + protoKeySerialization.getTypeUrl());
        }
        try {
            com.google.crypto.tink.proto.JwtRsaSsaPkcs1PrivateKey from = com.google.crypto.tink.proto.JwtRsaSsaPkcs1PrivateKey.parseFrom(protoKeySerialization.getValue(), ExtensionRegistryLite.getEmptyRegistry());
            validateVersion(from.getVersion());
            JwtRsaSsaPkcs1PublicKey publicKeyFromProto = getPublicKeyFromProto(from.getPublicKey(), protoKeySerialization.getOutputPrefixType(), protoKeySerialization.getIdRequirementOrNull());
            SecretKeyAccess secretKeyAccessRequireAccess = SecretKeyAccess.requireAccess(secretKeyAccess);
            return JwtRsaSsaPkcs1PrivateKey.builder().setPublicKey(publicKeyFromProto).setPrimes(decodeSecretBigInteger(from.getP(), secretKeyAccessRequireAccess), decodeSecretBigInteger(from.getQ(), secretKeyAccessRequireAccess)).setPrivateExponent(decodeSecretBigInteger(from.getD(), secretKeyAccessRequireAccess)).setPrimeExponents(decodeSecretBigInteger(from.getDp(), secretKeyAccessRequireAccess), decodeSecretBigInteger(from.getDq(), secretKeyAccessRequireAccess)).setCrtCoefficient(decodeSecretBigInteger(from.getCrt(), secretKeyAccessRequireAccess)).build();
        } catch (InvalidProtocolBufferException unused) {
            throw new GeneralSecurityException("Parsing JwtRsaSsaPkcs1PrivateKey failed");
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

    private JwtRsaSsaPkcs1ProtoSerialization() {
    }
}
