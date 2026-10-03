package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.Internal;

/* JADX INFO: loaded from: classes5.dex */
public enum HpkeAead implements Internal.EnumLite {
    AEAD_UNKNOWN(0),
    AES_128_GCM(1),
    AES_256_GCM(2),
    CHACHA20_POLY1305(3),
    UNRECOGNIZED(-1);

    public static final int AEAD_UNKNOWN_VALUE = 0;
    public static final int AES_128_GCM_VALUE = 1;
    public static final int AES_256_GCM_VALUE = 2;
    public static final int CHACHA20_POLY1305_VALUE = 3;
    private static final Internal.EnumLiteMap<HpkeAead> internalValueMap = new Internal.EnumLiteMap<HpkeAead>() { // from class: com.google.crypto.tink.proto.HpkeAead.1
        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumLiteMap
        public HpkeAead findValueByNumber(int i) {
            return HpkeAead.forNumber(i);
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
    public static HpkeAead valueOf(int i) {
        return forNumber(i);
    }

    public static HpkeAead forNumber(int i) {
        if (i == 0) {
            return AEAD_UNKNOWN;
        }
        if (i == 1) {
            return AES_128_GCM;
        }
        if (i == 2) {
            return AES_256_GCM;
        }
        if (i != 3) {
            return null;
        }
        return CHACHA20_POLY1305;
    }

    public static Internal.EnumLiteMap<HpkeAead> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return HpkeAeadVerifier.INSTANCE;
    }

    static final class HpkeAeadVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new HpkeAeadVerifier();

        private HpkeAeadVerifier() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return HpkeAead.forNumber(i) != null;
        }
    }

    HpkeAead(int i) {
        this.value = i;
    }
}
