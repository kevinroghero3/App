package com.google.crypto.tink.signature;

import com.google.errorprone.annotations.Immutable;
import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public final class MlDsaParameters extends SignatureParameters {
    private final MlDsaInstance mlDsaInstance;
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
    public static final class MlDsaInstance {
        public static final MlDsaInstance ML_DSA_65 = new MlDsaInstance("ML_DSA_65");
        public static final MlDsaInstance ML_DSA_87 = new MlDsaInstance("ML_DSA_87");
        private final String name;

        private MlDsaInstance(String str) {
            this.name = str;
        }

        public String toString() {
            return this.name;
        }
    }

    public static MlDsaParameters create(MlDsaInstance mlDsaInstance, Variant variant) {
        return new MlDsaParameters(mlDsaInstance, variant);
    }

    private MlDsaParameters(MlDsaInstance mlDsaInstance, Variant variant) {
        this.mlDsaInstance = mlDsaInstance;
        this.variant = variant;
    }

    public MlDsaInstance getMlDsaInstance() {
        return this.mlDsaInstance;
    }

    public Variant getVariant() {
        return this.variant;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MlDsaParameters)) {
            return false;
        }
        MlDsaParameters mlDsaParameters = (MlDsaParameters) obj;
        return mlDsaParameters.getMlDsaInstance() == getMlDsaInstance() && mlDsaParameters.getVariant() == getVariant();
    }

    public int hashCode() {
        return Objects.hash(MlDsaParameters.class, this.mlDsaInstance, this.variant);
    }

    @Override // com.google.crypto.tink.Parameters
    public boolean hasIdRequirement() {
        return this.variant != Variant.NO_PREFIX;
    }

    public String toString() {
        return "ML-DSA Parameters (ML-DSA instance: " + this.mlDsaInstance + ", variant: " + this.variant + ")";
    }
}
