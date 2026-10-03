package com.google.crypto.tink.signature.internal;

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
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.proto.RsaSsaPkcs1KeyFormat;
import com.google.crypto.tink.proto.RsaSsaPkcs1Params;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.signature.RsaSsaPkcs1Parameters;
import com.google.crypto.tink.signature.RsaSsaPkcs1PrivateKey;
import com.google.crypto.tink.signature.RsaSsaPkcs1PublicKey;
import com.google.crypto.tink.util.Bytes;
import com.google.crypto.tink.util.SecretBigInteger;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class RsaSsaPkcs1ProtoSerialization {
    private static final EnumTypeProtoConverter<HashType, RsaSsaPkcs1Parameters.HashType> HASH_TYPE_CONVERTER;
    private static final ParametersParser<ProtoParametersSerialization> PARAMETERS_PARSER;
    private static final ParametersSerializer<RsaSsaPkcs1Parameters, ProtoParametersSerialization> PARAMETERS_SERIALIZER;
    private static final KeyParser<ProtoKeySerialization> PRIVATE_KEY_PARSER;
    private static final KeySerializer<RsaSsaPkcs1PrivateKey, ProtoKeySerialization> PRIVATE_KEY_SERIALIZER;
    private static final String PRIVATE_TYPE_URL = "type.googleapis.com/google.crypto.tink.RsaSsaPkcs1PrivateKey";
    private static final Bytes PRIVATE_TYPE_URL_BYTES;
    private static final KeyParser<ProtoKeySerialization> PUBLIC_KEY_PARSER;
    private static final KeySerializer<RsaSsaPkcs1PublicKey, ProtoKeySerialization> PUBLIC_KEY_SERIALIZER;
    private static final String PUBLIC_TYPE_URL = "type.googleapis.com/google.crypto.tink.RsaSsaPkcs1PublicKey";
    private static final Bytes PUBLIC_TYPE_URL_BYTES;
    private static final EnumTypeProtoConverter<OutputPrefixType, RsaSsaPkcs1Parameters.Variant> VARIANT_CONVERTER;

    static {
        Bytes bytesFromPrintableAscii = Util.toBytesFromPrintableAscii(PRIVATE_TYPE_URL);
        PRIVATE_TYPE_URL_BYTES = bytesFromPrintableAscii;
        Bytes bytesFromPrintableAscii2 = Util.toBytesFromPrintableAscii(PUBLIC_TYPE_URL);
        PUBLIC_TYPE_URL_BYTES = bytesFromPrintableAscii2;
        PARAMETERS_SERIALIZER = ParametersSerializer.create(new ParametersSerializer.ParametersSerializationFunction() { // from class: com.google.crypto.tink.signature.internal.RsaSsaPkcs1ProtoSerialization$$ExternalSyntheticLambda0
            @Override // com.google.crypto.tink.internal.ParametersSerializer.ParametersSerializationFunction
            public final Serialization serializeParameters(Parameters parameters) {
                return RsaSsaPkcs1ProtoSerialization.serializeParameters((RsaSsaPkcs1Parameters) parameters);
            }
        }, RsaSsaPkcs1Parameters.class, ProtoParametersSerialization.class);
        PARAMETERS_PARSER = ParametersParser.create(new ParametersParser.ParametersParsingFunction() { // from class: com.google.crypto.tink.signature.internal.RsaSsaPkcs1ProtoSerialization$$ExternalSyntheticLambda1
            @Override // com.google.crypto.tink.internal.ParametersParser.ParametersParsingFunction
            public final Parameters parseParameters(Serialization serialization) {
                return RsaSsaPkcs1ProtoSerialization.parseParameters((ProtoParametersSerialization) serialization);
            }
        }, bytesFromPrintableAscii, ProtoParametersSerialization.class);
        PUBLIC_KEY_SERIALIZER = KeySerializer.create(new KeySerializer.KeySerializationFunction() { // from class: com.google.crypto.tink.signature.internal.RsaSsaPkcs1ProtoSerialization$$ExternalSyntheticLambda2
            @Override // com.google.crypto.tink.internal.KeySerializer.KeySerializationFunction
            public final Serialization serializeKey(Key key, SecretKeyAccess secretKeyAccess) {
                return RsaSsaPkcs1ProtoSerialization.serializePublicKey((RsaSsaPkcs1PublicKey) key, secretKeyAccess);
            }
        }, RsaSsaPkcs1PublicKey.class, ProtoKeySerialization.class);
        PUBLIC_KEY_PARSER = KeyParser.create(new KeyParser.KeyParsingFunction() { // from class: com.google.crypto.tink.signature.internal.RsaSsaPkcs1ProtoSerialization$$ExternalSyntheticLambda3
            @Override // com.google.crypto.tink.internal.KeyParser.KeyParsingFunction
            public final Key parseKey(Serialization serialization, SecretKeyAccess secretKeyAccess) {
                return RsaSsaPkcs1ProtoSerialization.parsePublicKey((ProtoKeySerialization) serialization, secretKeyAccess);
            }
        }, bytesFromPrintableAscii2, ProtoKeySerialization.class);
        PRIVATE_KEY_SERIALIZER = KeySerializer.create(new KeySerializer.KeySerializationFunction() { // from class: com.google.crypto.tink.signature.internal.RsaSsaPkcs1ProtoSerialization$$ExternalSyntheticLambda4
            @Override // com.google.crypto.tink.internal.KeySerializer.KeySerializationFunction
            public final Serialization serializeKey(Key key, SecretKeyAccess secretKeyAccess) {
                return RsaSsaPkcs1ProtoSerialization.serializePrivateKey((RsaSsaPkcs1PrivateKey) key, secretKeyAccess);
            }
        }, RsaSsaPkcs1PrivateKey.class, ProtoKeySerialization.class);
        PRIVATE_KEY_PARSER = KeyParser.create(new KeyParser.KeyParsingFunction() { // from class: com.google.crypto.tink.signature.internal.RsaSsaPkcs1ProtoSerialization$$ExternalSyntheticLambda5
            @Override // com.google.crypto.tink.internal.KeyParser.KeyParsingFunction
            public final Key parseKey(Serialization serialization, SecretKeyAccess secretKeyAccess) {
                return RsaSsaPkcs1ProtoSerialization.parsePrivateKey((ProtoKeySerialization) serialization, secretKeyAccess);
            }
        }, bytesFromPrintableAscii, ProtoKeySerialization.class);
        VARIANT_CONVERTER = EnumTypeProtoConverter.builder().add(OutputPrefixType.RAW, RsaSsaPkcs1Parameters.Variant.NO_PREFIX).add(OutputPrefixType.TINK, RsaSsaPkcs1Parameters.Variant.TINK).add(OutputPrefixType.CRUNCHY, RsaSsaPkcs1Parameters.Variant.CRUNCHY).add(OutputPrefixType.LEGACY, RsaSsaPkcs1Parameters.Variant.LEGACY).build();
        HASH_TYPE_CONVERTER = EnumTypeProtoConverter.builder().add(HashType.SHA256, RsaSsaPkcs1Parameters.HashType.SHA256).add(HashType.SHA384, RsaSsaPkcs1Parameters.HashType.SHA384).add(HashType.SHA512, RsaSsaPkcs1Parameters.HashType.SHA512).build();
    }

    private static RsaSsaPkcs1Params getProtoParams(RsaSsaPkcs1Parameters rsaSsaPkcs1Parameters) throws GeneralSecurityException {
        return RsaSsaPkcs1Params.newBuilder().setHashType((HashType) HASH_TYPE_CONVERTER.toProtoEnum(rsaSsaPkcs1Parameters.getHashType())).build();
    }

    private static ByteString encodeBigInteger(BigInteger bigInteger) {
        return ByteString.copyFrom(BigIntegerEncoding.toBigEndianBytes(bigInteger));
    }

    private static com.google.crypto.tink.proto.RsaSsaPkcs1PublicKey getProtoPublicKey(RsaSsaPkcs1PublicKey rsaSsaPkcs1PublicKey) throws GeneralSecurityException {
        return com.google.crypto.tink.proto.RsaSsaPkcs1PublicKey.newBuilder().setParams(getProtoParams(rsaSsaPkcs1PublicKey.getParameters())).setN(encodeBigInteger(rsaSsaPkcs1PublicKey.getModulus())).setE(encodeBigInteger(rsaSsaPkcs1PublicKey.getParameters().getPublicExponent())).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ProtoParametersSerialization serializeParameters(RsaSsaPkcs1Parameters rsaSsaPkcs1Parameters) throws GeneralSecurityException {
        return ProtoParametersSerialization.create(KeyTemplate.newBuilder().setTypeUrl(PRIVATE_TYPE_URL).setValue(RsaSsaPkcs1KeyFormat.newBuilder().setParams(getProtoParams(rsaSsaPkcs1Parameters)).setModulusSizeInBits(rsaSsaPkcs1Parameters.getModulusSizeBits()).setPublicExponent(encodeBigInteger(rsaSsaPkcs1Parameters.getPublicExponent())).build().toByteString()).setOutputPrefixType((OutputPrefixType) VARIANT_CONVERTER.toProtoEnum(rsaSsaPkcs1Parameters.getVariant())).build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ProtoKeySerialization serializePublicKey(RsaSsaPkcs1PublicKey rsaSsaPkcs1PublicKey, @Nullable SecretKeyAccess secretKeyAccess) throws GeneralSecurityException {
        return ProtoKeySerialization.create(PUBLIC_TYPE_URL, getProtoPublicKey(rsaSsaPkcs1PublicKey).toByteString(), KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC, (OutputPrefixType) VARIANT_CONVERTER.toProtoEnum(rsaSsaPkcs1PublicKey.getParameters().getVariant()), rsaSsaPkcs1PublicKey.getIdRequirementOrNull());
    }

    private static ByteString encodeSecretBigInteger(SecretBigInteger secretBigInteger, SecretKeyAccess secretKeyAccess) {
        return encodeBigInteger(secretBigInteger.getBigInteger(secretKeyAccess));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ProtoKeySerialization serializePrivateKey(RsaSsaPkcs1PrivateKey rsaSsaPkcs1PrivateKey, @Nullable SecretKeyAccess secretKeyAccess) throws GeneralSecurityException {
        SecretKeyAccess secretKeyAccessRequireAccess = SecretKeyAccess.requireAccess(secretKeyAccess);
        return ProtoKeySerialization.create(PRIVATE_TYPE_URL, com.google.crypto.tink.proto.RsaSsaPkcs1PrivateKey.newBuilder().setVersion(0).setPublicKey(getProtoPublicKey(rsaSsaPkcs1PrivateKey.getPublicKey())).setD(encodeSecretBigInteger(rsaSsaPkcs1PrivateKey.getPrivateExponent(), secretKeyAccessRequireAccess)).setP(encodeSecretBigInteger(rsaSsaPkcs1PrivateKey.getPrimeP(), secretKeyAccessRequireAccess)).setQ(encodeSecretBigInteger(rsaSsaPkcs1PrivateKey.getPrimeQ(), secretKeyAccessRequireAccess)).setDp(encodeSecretBigInteger(rsaSsaPkcs1PrivateKey.getPrimeExponentP(), secretKeyAccessRequireAccess)).setDq(encodeSecretBigInteger(rsaSsaPkcs1PrivateKey.getPrimeExponentQ(), secretKeyAccessRequireAccess)).setCrt(encodeSecretBigInteger(rsaSsaPkcs1PrivateKey.getCrtCoefficient(), secretKeyAccessRequireAccess)).build().toByteString(), KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE, (OutputPrefixType) VARIANT_CONVERTER.toProtoEnum(rsaSsaPkcs1PrivateKey.getParameters().getVariant()), rsaSsaPkcs1PrivateKey.getIdRequirementOrNull());
    }

    private static BigInteger decodeBigInteger(ByteString byteString) {
        return BigIntegerEncoding.fromUnsignedBigEndianBytes(byteString.toByteArray());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static RsaSsaPkcs1Parameters parseParameters(ProtoParametersSerialization protoParametersSerialization) throws GeneralSecurityException {
        if (!protoParametersSerialization.getKeyTemplate().getTypeUrl().equals(PRIVATE_TYPE_URL)) {
            throw new IllegalArgumentException("Wrong type URL in call to RsaSsaPkcs1ProtoSerialization.parseParameters: " + protoParametersSerialization.getKeyTemplate().getTypeUrl());
        }
        try {
            RsaSsaPkcs1KeyFormat from = RsaSsaPkcs1KeyFormat.parseFrom(protoParametersSerialization.getKeyTemplate().getValue(), ExtensionRegistryLite.getEmptyRegistry());
            return RsaSsaPkcs1Parameters.builder().setHashType(HASH_TYPE_CONVERTER.fromProtoEnum(from.getParams().getHashType())).setPublicExponent(decodeBigInteger(from.getPublicExponent())).setModulusSizeBits(from.getModulusSizeInBits()).setVariant(VARIANT_CONVERTER.fromProtoEnum(protoParametersSerialization.getKeyTemplate().getOutputPrefixType())).build();
        } catch (InvalidProtocolBufferException e) {
            throw new GeneralSecurityException("Parsing RsaSsaPkcs1Parameters failed: ", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static RsaSsaPkcs1PublicKey parsePublicKey(ProtoKeySerialization protoKeySerialization, @Nullable SecretKeyAccess secretKeyAccess) throws GeneralSecurityException {
        if (!protoKeySerialization.getTypeUrl().equals(PUBLIC_TYPE_URL)) {
            throw new IllegalArgumentException("Wrong type URL in call to RsaSsaPkcs1ProtoSerialization.parsePublicKey: " + protoKeySerialization.getTypeUrl());
        }
        try {
            com.google.crypto.tink.proto.RsaSsaPkcs1PublicKey from = com.google.crypto.tink.proto.RsaSsaPkcs1PublicKey.parseFrom(protoKeySerialization.getValue(), ExtensionRegistryLite.getEmptyRegistry());
            if (from.getVersion() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            BigInteger bigIntegerDecodeBigInteger = decodeBigInteger(from.getN());
            return RsaSsaPkcs1PublicKey.builder().setParameters(RsaSsaPkcs1Parameters.builder().setHashType(HASH_TYPE_CONVERTER.fromProtoEnum(from.getParams().getHashType())).setPublicExponent(decodeBigInteger(from.getE())).setModulusSizeBits(bigIntegerDecodeBigInteger.bitLength()).setVariant(VARIANT_CONVERTER.fromProtoEnum(protoKeySerialization.getOutputPrefixType())).build()).setModulus(bigIntegerDecodeBigInteger).setIdRequirement(protoKeySerialization.getIdRequirementOrNull()).build();
        } catch (InvalidProtocolBufferException | IllegalArgumentException unused) {
            throw new GeneralSecurityException("Parsing RsaSsaPkcs1PublicKey failed");
        }
    }

    private static SecretBigInteger decodeSecretBigInteger(ByteString byteString, SecretKeyAccess secretKeyAccess) {
        return SecretBigInteger.fromBigInteger(BigIntegerEncoding.fromUnsignedBigEndianBytes(byteString.toByteArray()), secretKeyAccess);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static RsaSsaPkcs1PrivateKey parsePrivateKey(ProtoKeySerialization protoKeySerialization, @Nullable SecretKeyAccess secretKeyAccess) throws GeneralSecurityException {
        if (!protoKeySerialization.getTypeUrl().equals(PRIVATE_TYPE_URL)) {
            throw new IllegalArgumentException("Wrong type URL in call to RsaSsaPkcs1ProtoSerialization.parsePrivateKey: " + protoKeySerialization.getTypeUrl());
        }
        try {
            com.google.crypto.tink.proto.RsaSsaPkcs1PrivateKey from = com.google.crypto.tink.proto.RsaSsaPkcs1PrivateKey.parseFrom(protoKeySerialization.getValue(), ExtensionRegistryLite.getEmptyRegistry());
            if (from.getVersion() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            com.google.crypto.tink.proto.RsaSsaPkcs1PublicKey publicKey = from.getPublicKey();
            if (publicKey.getVersion() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            BigInteger bigIntegerDecodeBigInteger = decodeBigInteger(publicKey.getN());
            RsaSsaPkcs1PublicKey rsaSsaPkcs1PublicKeyBuild = RsaSsaPkcs1PublicKey.builder().setParameters(RsaSsaPkcs1Parameters.builder().setHashType(HASH_TYPE_CONVERTER.fromProtoEnum(publicKey.getParams().getHashType())).setPublicExponent(decodeBigInteger(publicKey.getE())).setModulusSizeBits(bigIntegerDecodeBigInteger.bitLength()).setVariant(VARIANT_CONVERTER.fromProtoEnum(protoKeySerialization.getOutputPrefixType())).build()).setModulus(bigIntegerDecodeBigInteger).setIdRequirement(protoKeySerialization.getIdRequirementOrNull()).build();
            SecretKeyAccess secretKeyAccessRequireAccess = SecretKeyAccess.requireAccess(secretKeyAccess);
            return RsaSsaPkcs1PrivateKey.builder().setPublicKey(rsaSsaPkcs1PublicKeyBuild).setPrimes(decodeSecretBigInteger(from.getP(), secretKeyAccessRequireAccess), decodeSecretBigInteger(from.getQ(), secretKeyAccessRequireAccess)).setPrivateExponent(decodeSecretBigInteger(from.getD(), secretKeyAccessRequireAccess)).setPrimeExponents(decodeSecretBigInteger(from.getDp(), secretKeyAccessRequireAccess), decodeSecretBigInteger(from.getDq(), secretKeyAccessRequireAccess)).setCrtCoefficient(decodeSecretBigInteger(from.getCrt(), secretKeyAccessRequireAccess)).build();
        } catch (InvalidProtocolBufferException | IllegalArgumentException unused) {
            throw new GeneralSecurityException("Parsing RsaSsaPkcs1PrivateKey failed");
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

    private RsaSsaPkcs1ProtoSerialization() {
    }
}
