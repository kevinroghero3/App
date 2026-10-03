package com.google.crypto.tink.hybrid.internal;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.SecretKeyAccess;
import com.google.crypto.tink.TinkProtoParametersFormat;
import com.google.crypto.tink.hybrid.EciesParameters;
import com.google.crypto.tink.hybrid.EciesPrivateKey;
import com.google.crypto.tink.hybrid.EciesPublicKey;
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
import com.google.crypto.tink.proto.EcPointFormat;
import com.google.crypto.tink.proto.EciesAeadDemParams;
import com.google.crypto.tink.proto.EciesAeadHkdfKeyFormat;
import com.google.crypto.tink.proto.EciesAeadHkdfParams;
import com.google.crypto.tink.proto.EciesAeadHkdfPrivateKey;
import com.google.crypto.tink.proto.EciesAeadHkdfPublicKey;
import com.google.crypto.tink.proto.EciesHkdfKemParams;
import com.google.crypto.tink.proto.EllipticCurveType;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.util.Bytes;
import com.google.crypto.tink.util.SecretBigInteger;
import com.google.crypto.tink.util.SecretBytes;
import java.security.GeneralSecurityException;
import java.security.spec.ECPoint;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class EciesProtoSerialization {
    private static final EnumTypeProtoConverter<EllipticCurveType, EciesParameters.CurveType> CURVE_TYPE_CONVERTER;
    private static final EnumTypeProtoConverter<HashType, EciesParameters.HashType> HASH_TYPE_CONVERTER;
    private static final ParametersParser<ProtoParametersSerialization> PARAMETERS_PARSER;
    private static final ParametersSerializer<EciesParameters, ProtoParametersSerialization> PARAMETERS_SERIALIZER;
    private static final EnumTypeProtoConverter<EcPointFormat, EciesParameters.PointFormat> POINT_FORMAT_CONVERTER;
    private static final KeyParser<ProtoKeySerialization> PRIVATE_KEY_PARSER;
    private static final KeySerializer<EciesPrivateKey, ProtoKeySerialization> PRIVATE_KEY_SERIALIZER;
    private static final String PRIVATE_TYPE_URL = "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey";
    private static final Bytes PRIVATE_TYPE_URL_BYTES;
    private static final KeyParser<ProtoKeySerialization> PUBLIC_KEY_PARSER;
    private static final KeySerializer<EciesPublicKey, ProtoKeySerialization> PUBLIC_KEY_SERIALIZER;
    private static final String PUBLIC_TYPE_URL = "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey";
    private static final Bytes PUBLIC_TYPE_URL_BYTES;
    private static final EnumTypeProtoConverter<OutputPrefixType, EciesParameters.Variant> VARIANT_CONVERTER;

    static {
        Bytes bytesFromPrintableAscii = Util.toBytesFromPrintableAscii(PRIVATE_TYPE_URL);
        PRIVATE_TYPE_URL_BYTES = bytesFromPrintableAscii;
        Bytes bytesFromPrintableAscii2 = Util.toBytesFromPrintableAscii(PUBLIC_TYPE_URL);
        PUBLIC_TYPE_URL_BYTES = bytesFromPrintableAscii2;
        PARAMETERS_SERIALIZER = ParametersSerializer.create(new ParametersSerializer.ParametersSerializationFunction() { // from class: com.google.crypto.tink.hybrid.internal.EciesProtoSerialization$$ExternalSyntheticLambda0
            @Override // com.google.crypto.tink.internal.ParametersSerializer.ParametersSerializationFunction
            public final Serialization serializeParameters(Parameters parameters) {
                return EciesProtoSerialization.serializeParameters((EciesParameters) parameters);
            }
        }, EciesParameters.class, ProtoParametersSerialization.class);
        PARAMETERS_PARSER = ParametersParser.create(new ParametersParser.ParametersParsingFunction() { // from class: com.google.crypto.tink.hybrid.internal.EciesProtoSerialization$$ExternalSyntheticLambda1
            @Override // com.google.crypto.tink.internal.ParametersParser.ParametersParsingFunction
            public final Parameters parseParameters(Serialization serialization) {
                return EciesProtoSerialization.parseParameters((ProtoParametersSerialization) serialization);
            }
        }, bytesFromPrintableAscii, ProtoParametersSerialization.class);
        PUBLIC_KEY_SERIALIZER = KeySerializer.create(new KeySerializer.KeySerializationFunction() { // from class: com.google.crypto.tink.hybrid.internal.EciesProtoSerialization$$ExternalSyntheticLambda2
            @Override // com.google.crypto.tink.internal.KeySerializer.KeySerializationFunction
            public final Serialization serializeKey(Key key, SecretKeyAccess secretKeyAccess) {
                return EciesProtoSerialization.serializePublicKey((EciesPublicKey) key, secretKeyAccess);
            }
        }, EciesPublicKey.class, ProtoKeySerialization.class);
        PUBLIC_KEY_PARSER = KeyParser.create(new KeyParser.KeyParsingFunction() { // from class: com.google.crypto.tink.hybrid.internal.EciesProtoSerialization$$ExternalSyntheticLambda3
            @Override // com.google.crypto.tink.internal.KeyParser.KeyParsingFunction
            public final Key parseKey(Serialization serialization, SecretKeyAccess secretKeyAccess) {
                return EciesProtoSerialization.parsePublicKey((ProtoKeySerialization) serialization, secretKeyAccess);
            }
        }, bytesFromPrintableAscii2, ProtoKeySerialization.class);
        PRIVATE_KEY_SERIALIZER = KeySerializer.create(new KeySerializer.KeySerializationFunction() { // from class: com.google.crypto.tink.hybrid.internal.EciesProtoSerialization$$ExternalSyntheticLambda4
            @Override // com.google.crypto.tink.internal.KeySerializer.KeySerializationFunction
            public final Serialization serializeKey(Key key, SecretKeyAccess secretKeyAccess) {
                return EciesProtoSerialization.serializePrivateKey((EciesPrivateKey) key, secretKeyAccess);
            }
        }, EciesPrivateKey.class, ProtoKeySerialization.class);
        PRIVATE_KEY_PARSER = KeyParser.create(new KeyParser.KeyParsingFunction() { // from class: com.google.crypto.tink.hybrid.internal.EciesProtoSerialization$$ExternalSyntheticLambda5
            @Override // com.google.crypto.tink.internal.KeyParser.KeyParsingFunction
            public final Key parseKey(Serialization serialization, SecretKeyAccess secretKeyAccess) {
                return EciesProtoSerialization.parsePrivateKey((ProtoKeySerialization) serialization, secretKeyAccess);
            }
        }, bytesFromPrintableAscii, ProtoKeySerialization.class);
        EnumTypeProtoConverter.Builder builderAdd = EnumTypeProtoConverter.builder().add(OutputPrefixType.RAW, EciesParameters.Variant.NO_PREFIX).add(OutputPrefixType.TINK, EciesParameters.Variant.TINK);
        OutputPrefixType outputPrefixType = OutputPrefixType.LEGACY;
        EciesParameters.Variant variant = EciesParameters.Variant.CRUNCHY;
        VARIANT_CONVERTER = builderAdd.add(outputPrefixType, variant).add(OutputPrefixType.CRUNCHY, variant).build();
        HASH_TYPE_CONVERTER = EnumTypeProtoConverter.builder().add(HashType.SHA1, EciesParameters.HashType.SHA1).add(HashType.SHA224, EciesParameters.HashType.SHA224).add(HashType.SHA256, EciesParameters.HashType.SHA256).add(HashType.SHA384, EciesParameters.HashType.SHA384).add(HashType.SHA512, EciesParameters.HashType.SHA512).build();
        CURVE_TYPE_CONVERTER = EnumTypeProtoConverter.builder().add(EllipticCurveType.NIST_P256, EciesParameters.CurveType.NIST_P256).add(EllipticCurveType.NIST_P384, EciesParameters.CurveType.NIST_P384).add(EllipticCurveType.NIST_P521, EciesParameters.CurveType.NIST_P521).add(EllipticCurveType.CURVE25519, EciesParameters.CurveType.X25519).build();
        POINT_FORMAT_CONVERTER = EnumTypeProtoConverter.builder().add(EcPointFormat.UNCOMPRESSED, EciesParameters.PointFormat.UNCOMPRESSED).add(EcPointFormat.COMPRESSED, EciesParameters.PointFormat.COMPRESSED).add(EcPointFormat.DO_NOT_USE_CRUNCHY_UNCOMPRESSED, EciesParameters.PointFormat.LEGACY_UNCOMPRESSED).build();
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

    private static EciesAeadHkdfParams toProtoParameters(EciesParameters eciesParameters) throws GeneralSecurityException {
        EciesHkdfKemParams.Builder hkdfHashType = EciesHkdfKemParams.newBuilder().setCurveType((EllipticCurveType) CURVE_TYPE_CONVERTER.toProtoEnum(eciesParameters.getCurveType())).setHkdfHashType((HashType) HASH_TYPE_CONVERTER.toProtoEnum(eciesParameters.getHashType()));
        if (eciesParameters.getSalt() != null && eciesParameters.getSalt().size() > 0) {
            hkdfHashType.setHkdfSalt(ByteString.copyFrom(eciesParameters.getSalt().toByteArray()));
        }
        EciesHkdfKemParams eciesHkdfKemParamsBuild = hkdfHashType.build();
        try {
            KeyTemplate from = KeyTemplate.parseFrom(TinkProtoParametersFormat.serialize(eciesParameters.getDemParameters()), ExtensionRegistryLite.getEmptyRegistry());
            EciesAeadDemParams eciesAeadDemParamsBuild = EciesAeadDemParams.newBuilder().setAeadDem(KeyTemplate.newBuilder().setTypeUrl(from.getTypeUrl()).setOutputPrefixType(OutputPrefixType.TINK).setValue(from.getValue()).build()).build();
            EciesParameters.PointFormat nistCurvePointFormat = eciesParameters.getNistCurvePointFormat();
            if (nistCurvePointFormat == null) {
                nistCurvePointFormat = EciesParameters.PointFormat.COMPRESSED;
            }
            return EciesAeadHkdfParams.newBuilder().setKemParams(eciesHkdfKemParamsBuild).setDemParams(eciesAeadDemParamsBuild).setEcPointFormat((EcPointFormat) POINT_FORMAT_CONVERTER.toProtoEnum(nistCurvePointFormat)).build();
        } catch (InvalidProtocolBufferException e) {
            throw new GeneralSecurityException("Parsing EciesParameters failed: ", e);
        }
    }

    private static EciesParameters fromProtoParameters(OutputPrefixType outputPrefixType, EciesAeadHkdfParams eciesAeadHkdfParams) throws GeneralSecurityException {
        EciesParameters.Builder salt = EciesParameters.builder().setVariant(VARIANT_CONVERTER.fromProtoEnum(outputPrefixType)).setCurveType(CURVE_TYPE_CONVERTER.fromProtoEnum(eciesAeadHkdfParams.getKemParams().getCurveType())).setHashType(HASH_TYPE_CONVERTER.fromProtoEnum(eciesAeadHkdfParams.getKemParams().getHkdfHashType())).setDemParameters(TinkProtoParametersFormat.parse(KeyTemplate.newBuilder().setTypeUrl(eciesAeadHkdfParams.getDemParams().getAeadDem().getTypeUrl()).setOutputPrefixType(OutputPrefixType.RAW).setValue(eciesAeadHkdfParams.getDemParams().getAeadDem().getValue()).build().toByteArray())).setSalt(Bytes.copyFrom(eciesAeadHkdfParams.getKemParams().getHkdfSalt().toByteArray()));
        if (!eciesAeadHkdfParams.getKemParams().getCurveType().equals(EllipticCurveType.CURVE25519)) {
            salt.setNistCurvePointFormat(POINT_FORMAT_CONVERTER.fromProtoEnum(eciesAeadHkdfParams.getEcPointFormat()));
        } else if (!eciesAeadHkdfParams.getEcPointFormat().equals(EcPointFormat.COMPRESSED)) {
            throw new GeneralSecurityException("For CURVE25519 EcPointFormat must be compressed");
        }
        return salt.build();
    }

    private static int getEncodingLength(EciesParameters.CurveType curveType) throws GeneralSecurityException {
        if (EciesParameters.CurveType.NIST_P256.equals(curveType)) {
            return 33;
        }
        if (EciesParameters.CurveType.NIST_P384.equals(curveType)) {
            return 49;
        }
        if (EciesParameters.CurveType.NIST_P521.equals(curveType)) {
            return 67;
        }
        throw new GeneralSecurityException("Unable to serialize CurveType " + curveType);
    }

    private static EciesAeadHkdfPublicKey toProtoPublicKey(EciesPublicKey eciesPublicKey) throws GeneralSecurityException {
        if (eciesPublicKey.getParameters().getCurveType().equals(EciesParameters.CurveType.X25519)) {
            return EciesAeadHkdfPublicKey.newBuilder().setVersion(0).setParams(toProtoParameters(eciesPublicKey.getParameters())).setX(ByteString.copyFrom(eciesPublicKey.getX25519CurvePointBytes().toByteArray())).setY(ByteString.EMPTY).build();
        }
        int encodingLength = getEncodingLength(eciesPublicKey.getParameters().getCurveType());
        ECPoint nistCurvePoint = eciesPublicKey.getNistCurvePoint();
        if (nistCurvePoint == null) {
            throw new GeneralSecurityException("NistCurvePoint was null for NIST curve");
        }
        return EciesAeadHkdfPublicKey.newBuilder().setVersion(0).setParams(toProtoParameters(eciesPublicKey.getParameters())).setX(ByteString.copyFrom(BigIntegerEncoding.toBigEndianBytesOfFixedLength(nistCurvePoint.getAffineX(), encodingLength))).setY(ByteString.copyFrom(BigIntegerEncoding.toBigEndianBytesOfFixedLength(nistCurvePoint.getAffineY(), encodingLength))).build();
    }

    private static EciesAeadHkdfPrivateKey toProtoPrivateKey(EciesPrivateKey eciesPrivateKey, @Nullable SecretKeyAccess secretKeyAccess) throws GeneralSecurityException {
        EciesAeadHkdfPrivateKey.Builder publicKey = EciesAeadHkdfPrivateKey.newBuilder().setVersion(0).setPublicKey(toProtoPublicKey(eciesPrivateKey.getPublicKey()));
        if (eciesPrivateKey.getParameters().getCurveType().equals(EciesParameters.CurveType.X25519)) {
            publicKey.setKeyValue(ByteString.copyFrom(eciesPrivateKey.getX25519PrivateKeyBytes().toByteArray(SecretKeyAccess.requireAccess(secretKeyAccess))));
        } else {
            publicKey.setKeyValue(ByteString.copyFrom(BigIntegerEncoding.toBigEndianBytesOfFixedLength(eciesPrivateKey.getNistPrivateKeyValue().getBigInteger(SecretKeyAccess.requireAccess(secretKeyAccess)), getEncodingLength(eciesPrivateKey.getParameters().getCurveType()))));
        }
        return publicKey.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ProtoParametersSerialization serializeParameters(EciesParameters eciesParameters) throws GeneralSecurityException {
        return ProtoParametersSerialization.create(KeyTemplate.newBuilder().setTypeUrl(PRIVATE_TYPE_URL).setValue(EciesAeadHkdfKeyFormat.newBuilder().setParams(toProtoParameters(eciesParameters)).build().toByteString()).setOutputPrefixType((OutputPrefixType) VARIANT_CONVERTER.toProtoEnum(eciesParameters.getVariant())).build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ProtoKeySerialization serializePublicKey(EciesPublicKey eciesPublicKey, @Nullable SecretKeyAccess secretKeyAccess) throws GeneralSecurityException {
        return ProtoKeySerialization.create(PUBLIC_TYPE_URL, toProtoPublicKey(eciesPublicKey).toByteString(), KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC, (OutputPrefixType) VARIANT_CONVERTER.toProtoEnum(eciesPublicKey.getParameters().getVariant()), eciesPublicKey.getIdRequirementOrNull());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ProtoKeySerialization serializePrivateKey(EciesPrivateKey eciesPrivateKey, @Nullable SecretKeyAccess secretKeyAccess) throws GeneralSecurityException {
        return ProtoKeySerialization.create(PRIVATE_TYPE_URL, toProtoPrivateKey(eciesPrivateKey, secretKeyAccess).toByteString(), KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE, (OutputPrefixType) VARIANT_CONVERTER.toProtoEnum(eciesPrivateKey.getParameters().getVariant()), eciesPrivateKey.getIdRequirementOrNull());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static EciesParameters parseParameters(ProtoParametersSerialization protoParametersSerialization) throws GeneralSecurityException {
        if (!protoParametersSerialization.getKeyTemplate().getTypeUrl().equals(PRIVATE_TYPE_URL)) {
            throw new IllegalArgumentException("Wrong type URL in call to EciesProtoSerialization.parseParameters: " + protoParametersSerialization.getKeyTemplate().getTypeUrl());
        }
        try {
            return fromProtoParameters(protoParametersSerialization.getKeyTemplate().getOutputPrefixType(), EciesAeadHkdfKeyFormat.parseFrom(protoParametersSerialization.getKeyTemplate().getValue(), ExtensionRegistryLite.getEmptyRegistry()).getParams());
        } catch (InvalidProtocolBufferException e) {
            throw new GeneralSecurityException("Parsing EciesParameters failed: ", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static EciesPublicKey parsePublicKey(ProtoKeySerialization protoKeySerialization, @Nullable SecretKeyAccess secretKeyAccess) throws GeneralSecurityException {
        if (!protoKeySerialization.getTypeUrl().equals(PUBLIC_TYPE_URL)) {
            throw new IllegalArgumentException("Wrong type URL in call to EciesProtoSerialization.parsePublicKey: " + protoKeySerialization.getTypeUrl());
        }
        try {
            EciesAeadHkdfPublicKey from = EciesAeadHkdfPublicKey.parseFrom(protoKeySerialization.getValue(), ExtensionRegistryLite.getEmptyRegistry());
            if (from.getVersion() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            EciesParameters eciesParametersFromProtoParameters = fromProtoParameters(protoKeySerialization.getOutputPrefixType(), from.getParams());
            if (eciesParametersFromProtoParameters.getCurveType().equals(EciesParameters.CurveType.X25519)) {
                if (!from.getY().isEmpty()) {
                    throw new GeneralSecurityException("Y must be empty for X25519 points");
                }
                return EciesPublicKey.createForCurveX25519(eciesParametersFromProtoParameters, Bytes.copyFrom(from.getX().toByteArray()), protoKeySerialization.getIdRequirementOrNull());
            }
            return EciesPublicKey.createForNistCurve(eciesParametersFromProtoParameters, new ECPoint(BigIntegerEncoding.fromUnsignedBigEndianBytes(from.getX().toByteArray()), BigIntegerEncoding.fromUnsignedBigEndianBytes(from.getY().toByteArray())), protoKeySerialization.getIdRequirementOrNull());
        } catch (InvalidProtocolBufferException | IllegalArgumentException unused) {
            throw new GeneralSecurityException("Parsing EcdsaPublicKey failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static EciesPrivateKey parsePrivateKey(ProtoKeySerialization protoKeySerialization, @Nullable SecretKeyAccess secretKeyAccess) throws GeneralSecurityException {
        if (!protoKeySerialization.getTypeUrl().equals(PRIVATE_TYPE_URL)) {
            throw new IllegalArgumentException("Wrong type URL in call to EciesProtoSerialization.parsePrivateKey: " + protoKeySerialization.getTypeUrl());
        }
        try {
            EciesAeadHkdfPrivateKey from = EciesAeadHkdfPrivateKey.parseFrom(protoKeySerialization.getValue(), ExtensionRegistryLite.getEmptyRegistry());
            if (from.getVersion() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            EciesAeadHkdfPublicKey publicKey = from.getPublicKey();
            if (publicKey.getVersion() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            EciesParameters eciesParametersFromProtoParameters = fromProtoParameters(protoKeySerialization.getOutputPrefixType(), publicKey.getParams());
            if (eciesParametersFromProtoParameters.getCurveType().equals(EciesParameters.CurveType.X25519)) {
                return EciesPrivateKey.createForCurveX25519(EciesPublicKey.createForCurveX25519(eciesParametersFromProtoParameters, Bytes.copyFrom(publicKey.getX().toByteArray()), protoKeySerialization.getIdRequirementOrNull()), SecretBytes.copyFrom(from.getKeyValue().toByteArray(), SecretKeyAccess.requireAccess(secretKeyAccess)));
            }
            return EciesPrivateKey.createForNistCurve(EciesPublicKey.createForNistCurve(eciesParametersFromProtoParameters, new ECPoint(BigIntegerEncoding.fromUnsignedBigEndianBytes(publicKey.getX().toByteArray()), BigIntegerEncoding.fromUnsignedBigEndianBytes(publicKey.getY().toByteArray())), protoKeySerialization.getIdRequirementOrNull()), SecretBigInteger.fromBigInteger(BigIntegerEncoding.fromUnsignedBigEndianBytes(from.getKeyValue().toByteArray()), SecretKeyAccess.requireAccess(secretKeyAccess)));
        } catch (InvalidProtocolBufferException | IllegalArgumentException unused) {
            throw new GeneralSecurityException("Parsing EcdsaPrivateKey failed");
        }
    }

    private EciesProtoSerialization() {
    }
}
