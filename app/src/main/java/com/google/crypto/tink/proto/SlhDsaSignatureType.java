package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.Internal;

/* JADX INFO: loaded from: classes5.dex */
public enum SlhDsaSignatureType implements Internal.EnumLite {
    SLH_DSA_SIGNATURE_TYPE_UNSPECIFIED(0),
    FAST_SIGNING(1),
    SMALL_SIGNATURE(2),
    UNRECOGNIZED(-1);

    public static final int FAST_SIGNING_VALUE = 1;
    public static final int SLH_DSA_SIGNATURE_TYPE_UNSPECIFIED_VALUE = 0;
    public static final int SMALL_SIGNATURE_VALUE = 2;
    private static final Internal.EnumLiteMap<SlhDsaSignatureType> internalValueMap = new Internal.EnumLiteMap<SlhDsaSignatureType>() { // from class: com.google.crypto.tink.proto.SlhDsaSignatureType.1
        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumLiteMap
        public SlhDsaSignatureType findValueByNumber(int i) {
            return SlhDsaSignatureType.forNumber(i);
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
    public static SlhDsaSignatureType valueOf(int i) {
        return forNumber(i);
    }

    public static SlhDsaSignatureType forNumber(int i) {
        if (i == 0) {
            return SLH_DSA_SIGNATURE_TYPE_UNSPECIFIED;
        }
        if (i == 1) {
            return FAST_SIGNING;
        }
        if (i != 2) {
            return null;
        }
        return SMALL_SIGNATURE;
    }

    public static Internal.EnumLiteMap<SlhDsaSignatureType> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return SlhDsaSignatureTypeVerifier.INSTANCE;
    }

    static final class SlhDsaSignatureTypeVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new SlhDsaSignatureTypeVerifier();

        private SlhDsaSignatureTypeVerifier() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return SlhDsaSignatureType.forNumber(i) != null;
        }
    }

    SlhDsaSignatureType(int i) {
        this.value = i;
    }
}
