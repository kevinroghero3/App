package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.Internal;

/* JADX INFO: loaded from: classes5.dex */
public enum MlDsaInstance implements Internal.EnumLite {
    ML_DSA_UNKNOWN_INSTANCE(0),
    ML_DSA_65(1),
    ML_DSA_87(2),
    UNRECOGNIZED(-1);

    public static final int ML_DSA_65_VALUE = 1;
    public static final int ML_DSA_87_VALUE = 2;
    public static final int ML_DSA_UNKNOWN_INSTANCE_VALUE = 0;
    private static final Internal.EnumLiteMap<MlDsaInstance> internalValueMap = new Internal.EnumLiteMap<MlDsaInstance>() { // from class: com.google.crypto.tink.proto.MlDsaInstance.1
        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumLiteMap
        public MlDsaInstance findValueByNumber(int i) {
            return MlDsaInstance.forNumber(i);
        }
    };
    private final int value;

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this == UNRECOGNIZED) {
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
        return this.value;
    }

    @Deprecated
    public static MlDsaInstance valueOf(int i) {
        return forNumber(i);
    }

    public static MlDsaInstance forNumber(int i) {
        if (i == 0) {
            return ML_DSA_UNKNOWN_INSTANCE;
        }
        if (i == 1) {
            return ML_DSA_65;
        }
        if (i != 2) {
            return null;
        }
        return ML_DSA_87;
    }

    public static Internal.EnumLiteMap<MlDsaInstance> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return MlDsaInstanceVerifier.INSTANCE;
    }

    static final class MlDsaInstanceVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new MlDsaInstanceVerifier();

        private MlDsaInstanceVerifier() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return MlDsaInstance.forNumber(i) != null;
        }
    }

    MlDsaInstance(int i) {
        this.value = i;
    }
}
