package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.Internal;

/* JADX INFO: loaded from: classes3.dex */
public enum JwtEcdsaAlgorithm implements Internal.EnumLite {
    ES_UNKNOWN(0),
    ES256(1),
    ES384(2),
    ES512(3),
    UNRECOGNIZED(-1);

    public static final int ES256_VALUE = 1;
    public static final int ES384_VALUE = 2;
    public static final int ES512_VALUE = 3;
    public static final int ES_UNKNOWN_VALUE = 0;
    private static final Internal.EnumLiteMap<JwtEcdsaAlgorithm> internalValueMap = new AnonymousClass1();
    private final int value;

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this == UNRECOGNIZED) {
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
        return this.value;
    }

    @Deprecated
    public static JwtEcdsaAlgorithm valueOf(int i) {
        return forNumber(i);
    }

    public static JwtEcdsaAlgorithm forNumber(int i) {
        if (i == 0) {
            return ES_UNKNOWN;
        }
        if (i == 1) {
            return ES256;
        }
        if (i == 2) {
            return ES384;
        }
        if (i != 3) {
            return null;
        }
        return ES512;
    }

    public static Internal.EnumLiteMap<JwtEcdsaAlgorithm> internalGetValueMap() {
        return internalValueMap;
    }

    /* JADX INFO: renamed from: com.google.crypto.tink.proto.JwtEcdsaAlgorithm$1, reason: invalid class name */
    public class AnonymousClass1 implements Internal.EnumLiteMap<JwtEcdsaAlgorithm> {
        public static int MediaBrowserCompatItemReceiver;
        public static int onLoadChildren;

        AnonymousClass1() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumLiteMap
        public JwtEcdsaAlgorithm findValueByNumber(int i) {
            return JwtEcdsaAlgorithm.forNumber(i);
        }

        public static int ITrustedWebActivityCallbackStub() {
            int i = MediaBrowserCompatItemReceiver;
            int i2 = i % 8302810;
            MediaBrowserCompatItemReceiver = i + 1;
            if (i2 != 0) {
                return onLoadChildren;
            }
            int i3 = (int) Runtime.getRuntime().totalMemory();
            onLoadChildren = i3;
            return i3;
        }
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return JwtEcdsaAlgorithmVerifier.INSTANCE;
    }

    /* JADX INFO: loaded from: classes5.dex */
    static final class JwtEcdsaAlgorithmVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new JwtEcdsaAlgorithmVerifier();

        private JwtEcdsaAlgorithmVerifier() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return JwtEcdsaAlgorithm.forNumber(i) != null;
        }
    }

    JwtEcdsaAlgorithm(int i) {
        this.value = i;
    }
}
