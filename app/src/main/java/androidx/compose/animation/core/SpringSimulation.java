package androidx.compose.animation.core;

/* JADX INFO: loaded from: classes3.dex */
public final class SpringSimulation {
    public static final int $stable = 8;
    private double dampedFreq;
    private float finalPosition;
    private double gammaMinus;
    private double gammaPlus;
    private boolean initialized;
    private double naturalFreq = Math.sqrt(50.0d);
    private float dampingRatio = 1.0f;

    public SpringSimulation(float f) {
        this.finalPosition = f;
    }

    public final float getFinalPosition() {
        return this.finalPosition;
    }

    public final void setFinalPosition(float f) {
        this.finalPosition = f;
    }

    public final void setStiffness(float f) {
        if (getStiffness() <= 0.0f) {
            throw new IllegalArgumentException("Spring stiffness constant must be positive.");
        }
        this.naturalFreq = Math.sqrt(f);
        this.initialized = false;
    }

    public final float getStiffness() {
        double d = this.naturalFreq;
        return (float) (d * d);
    }

    public final float getDampingRatio() {
        return this.dampingRatio;
    }

    public final void setDampingRatio(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("Damping ratio must be non-negative");
        }
        this.dampingRatio = f;
        this.initialized = false;
    }

    public final float getAcceleration(float f, float f2) {
        float f3 = this.finalPosition;
        double d = this.naturalFreq;
        return (float) (((-(d * d)) * ((double) (f - f3))) - (((d * 2.0d) * ((double) this.dampingRatio)) * ((double) f2)));
    }

    private final void init() {
        if (this.initialized) {
            return;
        }
        if (this.finalPosition == SpringSimulationKt.getUNSET()) {
            throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
        }
        float f = this.dampingRatio;
        double d = f;
        double d2 = d * d;
        if (f > 1.0f) {
            double d3 = this.naturalFreq;
            double d4 = d2 - ((double) 1);
            this.gammaPlus = (((double) (-f)) * d3) + (d3 * Math.sqrt(d4));
            double d5 = -this.dampingRatio;
            double d6 = this.naturalFreq;
            this.gammaMinus = (d5 * d6) - (d6 * Math.sqrt(d4));
        } else if (f >= 0.0f && f < 1.0f) {
            this.dampedFreq = this.naturalFreq * Math.sqrt(((double) 1) - d2);
        }
        this.initialized = true;
    }

    /* JADX INFO: renamed from: updateValues-IJZedt4$animation_core_release, reason: not valid java name */
    public final long m332updateValuesIJZedt4$animation_core_release(float f, float f2, long j) {
        double dExp;
        double dCos;
        init();
        float f3 = f - this.finalPosition;
        double d = j / 1000.0d;
        float f4 = this.dampingRatio;
        if (f4 > 1.0f) {
            double d2 = f3;
            double d3 = this.gammaMinus;
            double d4 = ((d3 * d2) - ((double) f2)) / (d3 - this.gammaPlus);
            double d5 = d2 - d4;
            dExp = (Math.exp(d3 * d) * d5) + (Math.exp(this.gammaPlus * d) * d4);
            double d6 = this.gammaMinus;
            double dExp2 = Math.exp(d6 * d);
            double d7 = this.gammaPlus;
            dCos = (d5 * d6 * dExp2) + (d4 * d7 * Math.exp(d7 * d));
        } else if (f4 == 1.0f) {
            double d8 = this.naturalFreq;
            double d9 = f3;
            double d10 = ((double) f2) + (d8 * d9);
            double d11 = d9 + (d10 * d);
            double dExp3 = Math.exp((-d8) * d);
            double dExp4 = Math.exp((-this.naturalFreq) * d);
            double d12 = -this.naturalFreq;
            dCos = (d10 * Math.exp(d12 * d)) + (dExp4 * d11 * d12);
            dExp = d11 * dExp3;
        } else {
            double d13 = ((double) 1) / this.dampedFreq;
            double d14 = this.naturalFreq;
            double d15 = f3;
            double d16 = d13 * ((((double) f4) * d14 * d15) + ((double) f2));
            dExp = Math.exp(((double) (-f4)) * d14 * d) * ((Math.cos(this.dampedFreq * d) * d15) + (Math.sin(this.dampedFreq * d) * d16));
            double d17 = this.naturalFreq;
            float f5 = this.dampingRatio;
            double d18 = f5;
            double dExp5 = Math.exp(((double) (-f5)) * d17 * d);
            double d19 = this.dampedFreq;
            double d20 = -d19;
            double dSin = Math.sin(d19 * d);
            double d21 = this.dampedFreq;
            dCos = (((d20 * d15 * dSin) + (d16 * d21 * Math.cos(d21 * d))) * dExp5) + ((-d17) * dExp * d18);
        }
        return SpringSimulationKt.Motion((float) (dExp + ((double) this.finalPosition)), (float) dCos);
    }
}
