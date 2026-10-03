package com.google.crypto.tink.signature;

import androidx.exifinterface.media.ExifInterface;
import com.google.errorprone.annotations.Immutable;
import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public class SlhDsaParameters extends SignatureParameters {
    public static final int SLH_DSA_128_PRIVATE_KEY_SIZE_BYTES = 64;
    private final HashType hashType;
    private final int privateKeySize;
    private final SignatureType signatureType;
    private final Variant variant;

    @Immutable
    public static final class Variant {
        private final String name;
        public static final Variant TINK = new Variant("TINK");
        public static final Variant NO_PREFIX = new Variant("NO_PREFIX");

        private Variant(String str) {
            this.name = str;
        }

        public String toString() {
            return this.name;
        }
    }

    @Immutable
    public static final class HashType {
        public static final HashType SHA2 = new HashType("SHA2");
        public static final HashType SHAKE = new HashType("SHAKE");
        private final String name;

        private HashType(String str) {
            this.name = str;
        }

        public String toString() {
            return this.name;
        }
    }

    @Immutable
    public static final class SignatureType {
        public static final SignatureType FAST_SIGNING = new SignatureType("F");
        public static final SignatureType SMALL_SIGNATURE = new SignatureType(ExifInterface.LATITUDE_SOUTH);
        private final String name;

        private SignatureType(String str) {
            this.name = str;
        }

        public String toString() {
            return this.name;
        }
    }

    public static SlhDsaParameters createSlhDsaWithSha2And128S(Variant variant) {
        return new SlhDsaParameters(HashType.SHA2, 64, SignatureType.SMALL_SIGNATURE, variant);
    }

    private SlhDsaParameters(HashType hashType, int i, SignatureType signatureType, Variant variant) {
        this.hashType = hashType;
        this.privateKeySize = i;
        this.signatureType = signatureType;
        this.variant = variant;
    }

    public HashType getHashType() {
        return this.hashType;
    }

    public SignatureType getSignatureType() {
        return this.signatureType;
    }

    public Variant getVariant() {
        return this.variant;
    }

    public int getPrivateKeySize() {
        return this.privateKeySize;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SlhDsaParameters)) {
            return false;
        }
        SlhDsaParameters slhDsaParameters = (SlhDsaParameters) obj;
        return slhDsaParameters.getHashType() == getHashType() && slhDsaParameters.getSignatureType() == getSignatureType() && slhDsaParameters.getVariant() == getVariant() && slhDsaParameters.getPrivateKeySize() == getPrivateKeySize();
    }

    public int hashCode() {
        HashType hashType = this.hashType;
        int i = this.privateKeySize;
        return Objects.hash(SlhDsaParameters.class, hashType, Integer.valueOf(i), this.signatureType, this.variant);
    }

    @Override // com.google.crypto.tink.Parameters
    public boolean hasIdRequirement() {
        return this.variant != Variant.NO_PREFIX;
    }

    public String toString() {
        return "SLH-DSA-" + this.hashType.toString() + "-" + (this.privateKeySize * 2) + this.signatureType + " instance, variant: " + this.variant;
    }
}
