package com.google.crypto.tink.keyderivation.internal;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.SecretKeyAccess;
import com.google.crypto.tink.TinkProtoParametersFormat;
import com.google.crypto.tink.internal.KeyParser;
import com.google.crypto.tink.internal.KeySerializer;
import com.google.crypto.tink.internal.MutableSerializationRegistry;
import com.google.crypto.tink.internal.ParametersParser;
import com.google.crypto.tink.internal.ParametersSerializer;
import com.google.crypto.tink.internal.ProtoKeySerialization;
import com.google.crypto.tink.internal.ProtoParametersSerialization;
import com.google.crypto.tink.internal.Serialization;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.keyderivation.PrfBasedKeyDerivationKey;
import com.google.crypto.tink.keyderivation.PrfBasedKeyDerivationParameters;
import com.google.crypto.tink.prf.PrfKey;
import com.google.crypto.tink.prf.PrfParameters;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.proto.PrfBasedDeriverKey;
import com.google.crypto.tink.proto.PrfBasedDeriverKeyFormat;
import com.google.crypto.tink.proto.PrfBasedDeriverParams;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.util.Bytes;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class PrfBasedKeyDerivationKeyProtoSerialization {
    private static final KeyParser<ProtoKeySerialization> KEY_PARSER;
    private static final KeySerializer<PrfBasedKeyDerivationKey, ProtoKeySerialization> KEY_SERIALIZER;
    private static final ParametersParser<ProtoParametersSerialization> PARAMETERS_PARSER;
    private static final ParametersSerializer<PrfBasedKeyDerivationParameters, ProtoParametersSerialization> PARAMETERS_SERIALIZER;
    private static final String TYPE_URL = "type.googleapis.com/google.crypto.tink.PrfBasedDeriverKey";
    private static final Bytes TYPE_URL_BYTES;

    static {
        Bytes bytesFromPrintableAscii = Util.toBytesFromPrintableAscii(TYPE_URL);
        TYPE_URL_BYTES = bytesFromPrintableAscii;
        PARAMETERS_SERIALIZER = ParametersSerializer.create(new ParametersSerializer.ParametersSerializationFunction() { // from class: com.google.crypto.tink.keyderivation.internal.PrfBasedKeyDerivationKeyProtoSerialization$$ExternalSyntheticLambda0
            @Override // com.google.crypto.tink.internal.ParametersSerializer.ParametersSerializationFunction
            public final Serialization serializeParameters(Parameters parameters) {
                return PrfBasedKeyDerivationKeyProtoSerialization.serializeParameters((PrfBasedKeyDerivationParameters) parameters);
            }
        }, PrfBasedKeyDerivationParameters.class, ProtoParametersSerialization.class);
        PARAMETERS_PARSER = ParametersParser.create(new ParametersParser.ParametersParsingFunction() { // from class: com.google.crypto.tink.keyderivation.internal.PrfBasedKeyDerivationKeyProtoSerialization$$ExternalSyntheticLambda1
            @Override // com.google.crypto.tink.internal.ParametersParser.ParametersParsingFunction
            public final Parameters parseParameters(Serialization serialization) {
                return PrfBasedKeyDerivationKeyProtoSerialization.parseParameters((ProtoParametersSerialization) serialization);
            }
        }, bytesFromPrintableAscii, ProtoParametersSerialization.class);
        KEY_SERIALIZER = KeySerializer.create(new KeySerializer.KeySerializationFunction() { // from class: com.google.crypto.tink.keyderivation.internal.PrfBasedKeyDerivationKeyProtoSerialization$$ExternalSyntheticLambda2
            @Override // com.google.crypto.tink.internal.KeySerializer.KeySerializationFunction
            public final Serialization serializeKey(Key key, SecretKeyAccess secretKeyAccess) {
                return PrfBasedKeyDerivationKeyProtoSerialization.serializeKey((PrfBasedKeyDerivationKey) key, secretKeyAccess);
            }
        }, PrfBasedKeyDerivationKey.class, ProtoKeySerialization.class);
        KEY_PARSER = KeyParser.create(new KeyParser.KeyParsingFunction() { // from class: com.google.crypto.tink.keyderivation.internal.PrfBasedKeyDerivationKeyProtoSerialization$$ExternalSyntheticLambda3
            @Override // com.google.crypto.tink.internal.KeyParser.KeyParsingFunction
            public final Key parseKey(Serialization serialization, SecretKeyAccess secretKeyAccess) {
                return PrfBasedKeyDerivationKeyProtoSerialization.parseKey((ProtoKeySerialization) serialization, secretKeyAccess);
            }
        }, bytesFromPrintableAscii, ProtoKeySerialization.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static PrfBasedKeyDerivationParameters parseParameters(ProtoParametersSerialization protoParametersSerialization) throws GeneralSecurityException {
        if (!protoParametersSerialization.getKeyTemplate().getTypeUrl().equals(TYPE_URL)) {
            throw new IllegalArgumentException("Wrong type URL in call to PrfBasedKeyDerivationKeyProtoSerialization.parseParameters: " + protoParametersSerialization.getKeyTemplate().getTypeUrl());
        }
        try {
            PrfBasedDeriverKeyFormat from = PrfBasedDeriverKeyFormat.parseFrom(protoParametersSerialization.getKeyTemplate().getValue(), ExtensionRegistryLite.getEmptyRegistry());
            Parameters parameters = TinkProtoParametersFormat.parse(from.getParams().getDerivedKeyTemplate().toByteArray());
            Parameters parameters2 = TinkProtoParametersFormat.parse(from.getPrfKeyTemplate().toByteArray());
            if (!(parameters2 instanceof PrfParameters)) {
                throw new GeneralSecurityException("Non-PRF parameters stored in the field prf_key_template");
            }
            if (protoParametersSerialization.getKeyTemplate().getOutputPrefixType() != from.getParams().getDerivedKeyTemplate().getOutputPrefixType()) {
                throw new GeneralSecurityException("Output-Prefix mismatch in parameters while parsing " + from);
            }
            return PrfBasedKeyDerivationParameters.builder().setPrfParameters((PrfParameters) parameters2).setDerivedKeyParameters(parameters).build();
        } catch (InvalidProtocolBufferException e) {
            throw new GeneralSecurityException("Parsing PrfBasedDeriverKeyFormat failed: ", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ProtoParametersSerialization serializeParameters(PrfBasedKeyDerivationParameters prfBasedKeyDerivationParameters) throws GeneralSecurityException {
        try {
            KeyTemplate from = KeyTemplate.parseFrom(TinkProtoParametersFormat.serialize(prfBasedKeyDerivationParameters.getPrfParameters()), ExtensionRegistryLite.getEmptyRegistry());
            KeyTemplate from2 = KeyTemplate.parseFrom(TinkProtoParametersFormat.serialize(prfBasedKeyDerivationParameters.getDerivedKeyParameters()), ExtensionRegistryLite.getEmptyRegistry());
            return ProtoParametersSerialization.create(KeyTemplate.newBuilder().setTypeUrl(TYPE_URL).setValue(PrfBasedDeriverKeyFormat.newBuilder().setPrfKeyTemplate(from).setParams(PrfBasedDeriverParams.newBuilder().setDerivedKeyTemplate(from2)).build().toByteString()).setOutputPrefixType(from2.getOutputPrefixType()).build());
        } catch (InvalidProtocolBufferException e) {
            throw new GeneralSecurityException("Serializing PrfBasedKeyDerivationParameters failed: ", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ProtoKeySerialization serializeKey(PrfBasedKeyDerivationKey prfBasedKeyDerivationKey, @Nullable SecretKeyAccess secretKeyAccess) throws GeneralSecurityException {
        ProtoKeySerialization protoKeySerialization = (ProtoKeySerialization) MutableSerializationRegistry.globalInstance().serializeKey(prfBasedKeyDerivationKey.getPrfKey(), ProtoKeySerialization.class, secretKeyAccess);
        ProtoParametersSerialization protoParametersSerialization = (ProtoParametersSerialization) MutableSerializationRegistry.globalInstance().serializeParameters(prfBasedKeyDerivationKey.getParameters().getDerivedKeyParameters(), ProtoParametersSerialization.class);
        return ProtoKeySerialization.create(TYPE_URL, PrfBasedDeriverKey.newBuilder().setPrfKey(KeyData.newBuilder().setValue(protoKeySerialization.getValue()).setTypeUrl(protoKeySerialization.getTypeUrl()).setKeyMaterialType(protoKeySerialization.getKeyMaterialType())).setParams(PrfBasedDeriverParams.newBuilder().setDerivedKeyTemplate(protoParametersSerialization.getKeyTemplate())).build().toByteString(), KeyData.KeyMaterialType.SYMMETRIC, protoParametersSerialization.getKeyTemplate().getOutputPrefixType(), prfBasedKeyDerivationKey.getIdRequirementOrNull());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static PrfBasedKeyDerivationKey parseKey(ProtoKeySerialization protoKeySerialization, @Nullable SecretKeyAccess secretKeyAccess) throws GeneralSecurityException {
        if (!protoKeySerialization.getTypeUrl().equals(TYPE_URL)) {
            throw new IllegalArgumentException("Wrong type URL in call to PrfBasedKeyDerivationKey.parseKey");
        }
        try {
            PrfBasedDeriverKey from = PrfBasedDeriverKey.parseFrom(protoKeySerialization.getValue(), ExtensionRegistryLite.getEmptyRegistry());
            Key key = MutableSerializationRegistry.globalInstance().parseKey(ProtoKeySerialization.create(from.getPrfKey().getTypeUrl(), from.getPrfKey().getValue(), from.getPrfKey().getKeyMaterialType(), OutputPrefixType.RAW, null), secretKeyAccess);
            if (!(key instanceof PrfKey)) {
                throw new GeneralSecurityException("Non-PRF key stored in the field prf_key");
            }
            PrfKey prfKey = (PrfKey) key;
            ProtoParametersSerialization protoParametersSerializationCheckedCreate = ProtoParametersSerialization.checkedCreate(from.getParams().getDerivedKeyTemplate());
            PrfBasedKeyDerivationParameters prfBasedKeyDerivationParametersBuild = PrfBasedKeyDerivationParameters.builder().setDerivedKeyParameters(MutableSerializationRegistry.globalInstance().parseParameters(protoParametersSerializationCheckedCreate)).setPrfParameters(prfKey.getParameters()).build();
            if (protoKeySerialization.getOutputPrefixType() != protoParametersSerializationCheckedCreate.getKeyTemplate().getOutputPrefixType()) {
                throw new GeneralSecurityException("Output-Prefix mismatch in parameters while parsing PrfBasedKeyDerivationKey with parameters " + prfBasedKeyDerivationParametersBuild);
            }
            return PrfBasedKeyDerivationKey.create(prfBasedKeyDerivationParametersBuild, prfKey, protoKeySerialization.getIdRequirementOrNull());
        } catch (InvalidProtocolBufferException unused) {
            throw new GeneralSecurityException("Parsing HmacKey failed");
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

    private PrfBasedKeyDerivationKeyProtoSerialization() {
    }
}
