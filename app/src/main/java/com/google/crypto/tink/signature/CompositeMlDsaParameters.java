package com.google.crypto.tink.signature;

import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public final class CompositeMlDsaParameters extends SignatureParameters {
    private final ClassicalAlgorithm classicalAlgorithm;
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

    @Immutable
    public static final class ClassicalAlgorithm {
        private final String name;
        public static final ClassicalAlgorithm ED25519 = new ClassicalAlgorithm("ED25519");
        public static final ClassicalAlgorithm ECDSA_P256 = new ClassicalAlgorithm("ECDSA_P256");
        public static final ClassicalAlgorithm ECDSA_P384 = new ClassicalAlgorithm("ECDSA_P384");
        public static final ClassicalAlgorithm ECDSA_P521 = new ClassicalAlgorithm("ECDSA_P521");
        public static final ClassicalAlgorithm RSA3072_PSS = new ClassicalAlgorithm("RSA3072_PSS");
        public static final ClassicalAlgorithm RSA4096_PSS = new ClassicalAlgorithm("RSA4096_PSS");
        public static final ClassicalAlgorithm RSA3072_PKCS1 = new ClassicalAlgorithm("RSA3072_PKCS1");
        public static final ClassicalAlgorithm RSA4096_PKCS1 = new ClassicalAlgorithm("RSA4096_PKCS1");

        private ClassicalAlgorithm(String str) {
            this.name = str;
        }

        public String toString() {
            return this.name;
        }
    }

    public static final class Builder {
        private static final List<ClassicalAlgorithm> mlDsa65CompatibleClassicalAlgorithms;
        private static final List<ClassicalAlgorithm> mlDsa87CompatibleClassicalAlgorithms;
        private ClassicalAlgorithm classicalAlgorithm;
        private MlDsaInstance mlDsaInstance;
        private Variant variant;

        static {
            ClassicalAlgorithm classicalAlgorithm = ClassicalAlgorithm.ED25519;
            ClassicalAlgorithm classicalAlgorithm2 = ClassicalAlgorithm.ECDSA_P256;
            ClassicalAlgorithm classicalAlgorithm3 = ClassicalAlgorithm.ECDSA_P384;
            ClassicalAlgorithm classicalAlgorithm4 = ClassicalAlgorithm.RSA3072_PSS;
            ClassicalAlgorithm classicalAlgorithm5 = ClassicalAlgorithm.RSA4096_PSS;
            mlDsa65CompatibleClassicalAlgorithms = Arrays.asList(classicalAlgorithm, classicalAlgorithm2, classicalAlgorithm3, classicalAlgorithm4, classicalAlgorithm5, ClassicalAlgorithm.RSA3072_PKCS1, ClassicalAlgorithm.RSA4096_PKCS1);
            mlDsa87CompatibleClassicalAlgorithms = Arrays.asList(classicalAlgorithm3, ClassicalAlgorithm.ECDSA_P521, classicalAlgorithm4, classicalAlgorithm5);
        }

        private Builder() {
            this.mlDsaInstance = null;
            this.classicalAlgorithm = null;
            this.variant = Variant.NO_PREFIX;
        }

        public Builder setMlDsaInstance(MlDsaInstance mlDsaInstance) {
            this.mlDsaInstance = mlDsaInstance;
            return this;
        }

        public Builder setClassicalAlgorithm(ClassicalAlgorithm classicalAlgorithm) {
            this.classicalAlgorithm = classicalAlgorithm;
            return this;
        }

        public Builder setVariant(Variant variant) {
            this.variant = variant;
            return this;
        }

        public CompositeMlDsaParameters build() throws GeneralSecurityException {
            MlDsaInstance mlDsaInstance = this.mlDsaInstance;
            if (mlDsaInstance == null) {
                throw new GeneralSecurityException("ML-DSA instance is not set");
            }
            ClassicalAlgorithm classicalAlgorithm = this.classicalAlgorithm;
            if (classicalAlgorithm == null) {
                throw new GeneralSecurityException("Classical algorithm is not set");
            }
            if (this.variant == null) {
                throw new GeneralSecurityException("Variant is not set");
            }
            MlDsaInstance mlDsaInstance2 = MlDsaInstance.ML_DSA_65;
            if (mlDsaInstance == mlDsaInstance2 && !mlDsa65CompatibleClassicalAlgorithms.contains(classicalAlgorithm)) {
                throw new GeneralSecurityException("ML-DSA-65 is not compatible with the provided classical algorithm " + this.classicalAlgorithm);
            }
            MlDsaInstance mlDsaInstance3 = this.mlDsaInstance;
            MlDsaInstance mlDsaInstance4 = MlDsaInstance.ML_DSA_87;
            if (mlDsaInstance3 == mlDsaInstance4 && !mlDsa87CompatibleClassicalAlgorithms.contains(this.classicalAlgorithm)) {
                throw new GeneralSecurityException("ML-DSA-87 is not compatible with the provided classical algorithm " + this.classicalAlgorithm);
            }
            MlDsaInstance mlDsaInstance5 = this.mlDsaInstance;
            if (mlDsaInstance5 != mlDsaInstance2 && mlDsaInstance5 != mlDsaInstance4) {
                throw new GeneralSecurityException("Unknown ML-DSA instance: " + this.mlDsaInstance);
            }
            return new CompositeMlDsaParameters(mlDsaInstance5, this.classicalAlgorithm, this.variant);
        }
    }

    private CompositeMlDsaParameters(MlDsaInstance mlDsaInstance, ClassicalAlgorithm classicalAlgorithm, Variant variant) {
        this.mlDsaInstance = mlDsaInstance;
        this.classicalAlgorithm = classicalAlgorithm;
        this.variant = variant;
    }

    public static Builder builder() {
        return new Builder();
    }

    public MlDsaInstance getMlDsaInstance() {
        return this.mlDsaInstance;
    }

    public Variant getVariant() {
        return this.variant;
    }

    public ClassicalAlgorithm getClassicalAlgorithm() {
        return this.classicalAlgorithm;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CompositeMlDsaParameters)) {
            return false;
        }
        CompositeMlDsaParameters compositeMlDsaParameters = (CompositeMlDsaParameters) obj;
        return compositeMlDsaParameters.getMlDsaInstance() == getMlDsaInstance() && compositeMlDsaParameters.getClassicalAlgorithm() == getClassicalAlgorithm() && compositeMlDsaParameters.getVariant() == getVariant();
    }

    public int hashCode() {
        return Objects.hash(CompositeMlDsaParameters.class, this.mlDsaInstance, this.classicalAlgorithm, this.variant);
    }

    @Override // com.google.crypto.tink.Parameters
    public boolean hasIdRequirement() {
        return this.variant != Variant.NO_PREFIX;
    }

    public String toString() {
        return "Composite ML-DSA Parameters (ML-DSA instance: " + this.mlDsaInstance + ", classical algorithm: " + this.classicalAlgorithm + ", variant: " + this.variant + ")";
    }
}
