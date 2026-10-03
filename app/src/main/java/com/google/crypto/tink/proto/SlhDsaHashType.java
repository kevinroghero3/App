package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.Internal;

/* JADX INFO: loaded from: classes5.dex */
public enum SlhDsaHashType implements Internal.EnumLite {
    SLH_DSA_HASH_TYPE_UNSPECIFIED(0),
    SHA2(1),
    SHAKE(2),
    UNRECOGNIZED(-1);

    public static final int SHA2_VALUE = 1;
    public static final int SHAKE_VALUE = 2;
    public static final int SLH_DSA_HASH_TYPE_UNSPECIFIED_VALUE = 0;
    private static final Internal.EnumLiteMap<SlhDsaHashType> internalValueMap = new Internal.EnumLiteMap<SlhDsaHashType>() { // from class: com.google.crypto.tink.proto.SlhDsaHashType.1
        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumLiteMap
        public SlhDsaHashType findValueByNumber(int i) {
            return SlhDsaHashType.forNumber(i);
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
    public static SlhDsaHashType valueOf(int i) {
        return forNumber(i);
    }

    public static SlhDsaHashType forNumber(int i) {
        if (i == 0) {
            return SLH_DSA_HASH_TYPE_UNSPECIFIED;
        }
        if (i == 1) {
            return SHA2;
        }
        if (i != 2) {
            return null;
        }
        return SHAKE;
    }

    public static Internal.EnumLiteMap<SlhDsaHashType> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return SlhDsaHashTypeVerifier.INSTANCE;
    }

    static final class SlhDsaHashTypeVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new SlhDsaHashTypeVerifier();

        private SlhDsaHashTypeVerifier() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return SlhDsaHashType.forNumber(i) != null;
        }
    }

    SlhDsaHashType(int i) {
        this.value = i;
    }
}
