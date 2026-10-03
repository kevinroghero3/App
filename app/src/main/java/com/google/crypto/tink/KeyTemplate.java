package com.google.crypto.tink;

import com.google.crypto.tink.internal.LegacyProtoParameters;
import com.google.crypto.tink.internal.MutableSerializationRegistry;
import com.google.crypto.tink.internal.ProtoParametersSerialization;
import com.google.crypto.tink.internal.TinkBugException;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Immutable
public final class KeyTemplate {

    @Nullable
    private final com.google.crypto.tink.proto.KeyTemplate kt;

    @Nullable
    private final Parameters parameters;

    /* JADX INFO: loaded from: classes5.dex */
    public enum OutputPrefixType {
        TINK,
        LEGACY,
        RAW,
        CRUNCHY
    }

    /* JADX INFO: renamed from: com.google.crypto.tink.KeyTemplate$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType;

        static {
            int[] iArr = new int[com.google.crypto.tink.proto.OutputPrefixType.values().length];
            $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType = iArr;
            try {
                iArr[com.google.crypto.tink.proto.OutputPrefixType.TINK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[com.google.crypto.tink.proto.OutputPrefixType.LEGACY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[com.google.crypto.tink.proto.OutputPrefixType.RAW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[com.google.crypto.tink.proto.OutputPrefixType.CRUNCHY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static OutputPrefixType fromProto(com.google.crypto.tink.proto.OutputPrefixType outputPrefixType) {
        int i = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[outputPrefixType.ordinal()];
        if (i == 1) {
            return OutputPrefixType.TINK;
        }
        if (i == 2) {
            return OutputPrefixType.LEGACY;
        }
        if (i == 3) {
            return OutputPrefixType.RAW;
        }
        if (i == 4) {
            return OutputPrefixType.CRUNCHY;
        }
        throw new IllegalArgumentException("Unknown output prefix type");
    }

    static com.google.crypto.tink.proto.OutputPrefixType toProto(OutputPrefixType outputPrefixType) {
        int iOrdinal = outputPrefixType.ordinal();
        if (iOrdinal == 0) {
            return com.google.crypto.tink.proto.OutputPrefixType.TINK;
        }
        if (iOrdinal == 1) {
            return com.google.crypto.tink.proto.OutputPrefixType.LEGACY;
        }
        if (iOrdinal == 2) {
            return com.google.crypto.tink.proto.OutputPrefixType.RAW;
        }
        if (iOrdinal == 3) {
            return com.google.crypto.tink.proto.OutputPrefixType.CRUNCHY;
        }
        throw new IllegalArgumentException("Unknown output prefix type");
    }

    @Deprecated
    public static KeyTemplate create(String str, byte[] bArr, OutputPrefixType outputPrefixType) {
        return new KeyTemplate(com.google.crypto.tink.proto.KeyTemplate.newBuilder().setTypeUrl(str).setValue(ByteString.copyFrom(bArr)).setOutputPrefixType(toProto(outputPrefixType)).build());
    }

    public static KeyTemplate createFrom(Parameters parameters) throws GeneralSecurityException {
        return new KeyTemplate(parameters);
    }

    private KeyTemplate(com.google.crypto.tink.proto.KeyTemplate keyTemplate) {
        this.kt = keyTemplate;
        this.parameters = null;
    }

    private KeyTemplate(Parameters parameters) {
        this.kt = null;
        this.parameters = parameters;
    }

    com.google.crypto.tink.proto.KeyTemplate getProto() {
        try {
            return getProtoMaybeThrow();
        } catch (GeneralSecurityException e) {
            throw new TinkBugException("Parsing parameters failed in getProto(). You probably want to call some Tink register function for " + this.parameters, e);
        }
    }

    com.google.crypto.tink.proto.KeyTemplate getProtoMaybeThrow() throws GeneralSecurityException {
        com.google.crypto.tink.proto.KeyTemplate keyTemplate = this.kt;
        if (keyTemplate != null) {
            return keyTemplate;
        }
        Parameters parameters = this.parameters;
        if (parameters instanceof LegacyProtoParameters) {
            return ((LegacyProtoParameters) parameters).getSerialization().getKeyTemplate();
        }
        return ((ProtoParametersSerialization) MutableSerializationRegistry.globalInstance().serializeParameters(this.parameters, ProtoParametersSerialization.class)).getKeyTemplate();
    }

    @Deprecated
    public String getTypeUrl() {
        return getProto().getTypeUrl();
    }

    @Deprecated
    public byte[] getValue() {
        return getProto().getValue().toByteArray();
    }

    @Deprecated
    public OutputPrefixType getOutputPrefixType() {
        return fromProto(getProto().getOutputPrefixType());
    }

    public Parameters toParameters() throws GeneralSecurityException {
        Parameters parameters = this.parameters;
        return parameters != null ? parameters : TinkProtoParametersFormat.parse(getProto().toByteArray());
    }
}
