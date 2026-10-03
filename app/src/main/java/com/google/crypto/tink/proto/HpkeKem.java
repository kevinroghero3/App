package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.Internal;

/* JADX INFO: loaded from: classes5.dex */
public enum HpkeKem implements Internal.EnumLite {
    KEM_UNKNOWN(0),
    DHKEM_X25519_HKDF_SHA256(1),
    DHKEM_P256_HKDF_SHA256(2),
    DHKEM_P384_HKDF_SHA384(3),
    DHKEM_P521_HKDF_SHA512(4),
    X_WING(5),
    ML_KEM768(6),
    ML_KEM1024(7),
    UNRECOGNIZED(-1);

    public static final int DHKEM_P256_HKDF_SHA256_VALUE = 2;
    public static final int DHKEM_P384_HKDF_SHA384_VALUE = 3;
    public static final int DHKEM_P521_HKDF_SHA512_VALUE = 4;
    public static final int DHKEM_X25519_HKDF_SHA256_VALUE = 1;
    public static final int KEM_UNKNOWN_VALUE = 0;
    public static final int ML_KEM1024_VALUE = 7;
    public static final int ML_KEM768_VALUE = 6;
    public static final int X_WING_VALUE = 5;
    private static final Internal.EnumLiteMap<HpkeKem> internalValueMap = new Internal.EnumLiteMap<HpkeKem>() { // from class: com.google.crypto.tink.proto.HpkeKem.1
        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumLiteMap
        public HpkeKem findValueByNumber(int i) {
            return HpkeKem.forNumber(i);
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
    public static HpkeKem valueOf(int i) {
        return forNumber(i);
    }

    public static HpkeKem forNumber(int i) {
        switch (i) {
            case 0:
                return KEM_UNKNOWN;
            case 1:
                return DHKEM_X25519_HKDF_SHA256;
            case 2:
                return DHKEM_P256_HKDF_SHA256;
            case 3:
                return DHKEM_P384_HKDF_SHA384;
            case 4:
                return DHKEM_P521_HKDF_SHA512;
            case 5:
                return X_WING;
            case 6:
                return ML_KEM768;
            case 7:
                return ML_KEM1024;
            default:
                return null;
        }
    }

    public static Internal.EnumLiteMap<HpkeKem> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return HpkeKemVerifier.INSTANCE;
    }

    static final class HpkeKemVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new HpkeKemVerifier();

        private HpkeKemVerifier() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return HpkeKem.forNumber(i) != null;
        }
    }

    HpkeKem(int i) {
        this.value = i;
    }
}
