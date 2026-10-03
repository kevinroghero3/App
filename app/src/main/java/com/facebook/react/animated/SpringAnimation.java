package com.facebook.react.animated;

import com.facebook.react.bridge.ReadableMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.DurationKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class SpringAnimation extends AnimationDriver {
    public static final Companion Companion = new Companion(null);
    private static final double MAX_DELTA_TIME_SEC = 0.064d;
    private int currentLoop;
    private final PhysicsState currentState;
    private double displacementFromRestThreshold;
    private double endValue;
    private double initialVelocity;
    private int iterations;
    private long lastTime;
    private double originalValue;
    private boolean overshootClampingEnabled;
    private double restSpeedThreshold;
    private double springDamping;
    private double springMass;
    private boolean springStarted;
    private double springStiffness;
    private double startValue;
    private double timeAccumulator;

    public SpringAnimation(@NotNull ReadableMap config) {
        Intrinsics.checkNotNullParameter(config, "config");
        PhysicsState physicsState = new PhysicsState(0.0d, 0.0d, 3, null);
        this.currentState = physicsState;
        physicsState.setVelocity(config.getDouble("initialVelocity"));
        resetConfig(config);
    }

    static final class PhysicsState {
        private double position;
        private double velocity;

        public PhysicsState() {
            this(0.0d, 0.0d, 3, null);
        }

        public static /* synthetic */ PhysicsState copy$default(PhysicsState physicsState, double d, double d2, int i, Object obj) {
            if ((i & 1) != 0) {
                d = physicsState.position;
            }
            if ((i & 2) != 0) {
                d2 = physicsState.velocity;
            }
            return physicsState.copy(d, d2);
        }

        public final double component1() {
            return this.position;
        }

        public final double component2() {
            return this.velocity;
        }

        public final PhysicsState copy(double d, double d2) {
            return new PhysicsState(d, d2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PhysicsState)) {
                return false;
            }
            PhysicsState physicsState = (PhysicsState) obj;
            return Double.compare(this.position, physicsState.position) == 0 && Double.compare(this.velocity, physicsState.velocity) == 0;
        }

        public int hashCode() {
            return (Double.hashCode(this.position) * 31) + Double.hashCode(this.velocity);
        }

        public String toString() {
            return "PhysicsState(position=" + this.position + ", velocity=" + this.velocity + ")";
        }

        public PhysicsState(double d, double d2) {
            this.position = d;
            this.velocity = d2;
        }

        public /* synthetic */ PhysicsState(double d, double d2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? 0.0d : d, (i & 2) != 0 ? 0.0d : d2);
        }

        public final double getPosition() {
            return this.position;
        }

        public final double getVelocity() {
            return this.velocity;
        }

        public final void setPosition(double d) {
            this.position = d;
        }

        public final void setVelocity(double d) {
            this.velocity = d;
        }
    }

    @Override // com.facebook.react.animated.AnimationDriver
    public void resetConfig(@NotNull ReadableMap config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.springStiffness = config.getDouble("stiffness");
        this.springDamping = config.getDouble("damping");
        this.springMass = config.getDouble("mass");
        this.initialVelocity = this.currentState.getVelocity();
        this.endValue = config.getDouble("toValue");
        this.restSpeedThreshold = config.getDouble("restSpeedThreshold");
        this.displacementFromRestThreshold = config.getDouble("restDisplacementThreshold");
        this.overshootClampingEnabled = config.getBoolean("overshootClamping");
        int i = config.hasKey("iterations") ? config.getInt("iterations") : 1;
        this.iterations = i;
        this.hasFinished = i == 0;
        this.currentLoop = 0;
        this.timeAccumulator = 0.0d;
        this.springStarted = false;
    }

    @Override // com.facebook.react.animated.AnimationDriver
    public void runAnimationStep(long j) {
        ValueAnimatedNode valueAnimatedNode = this.animatedValue;
        if (valueAnimatedNode == null) {
            throw new IllegalArgumentException("Animated value should not be null");
        }
        long j2 = j / ((long) DurationKt.NANOS_IN_MILLIS);
        if (!this.springStarted) {
            if (this.currentLoop == 0) {
                this.originalValue = valueAnimatedNode.nodeValue;
                this.currentLoop = 1;
            }
            this.currentState.setPosition(valueAnimatedNode.nodeValue);
            this.startValue = this.currentState.getPosition();
            this.lastTime = j2;
            this.timeAccumulator = 0.0d;
            this.springStarted = true;
        }
        advance((j2 - this.lastTime) / 1000.0d);
        this.lastTime = j2;
        valueAnimatedNode.nodeValue = this.currentState.getPosition();
        if (isAtRest()) {
            int i = this.iterations;
            if (i == -1 || this.currentLoop < i) {
                this.springStarted = false;
                valueAnimatedNode.nodeValue = this.originalValue;
                this.currentLoop++;
                return;
            }
            this.hasFinished = true;
        }
    }

    private final double getDisplacementDistanceForState(PhysicsState physicsState) {
        return Math.abs(this.endValue - physicsState.getPosition());
    }

    private final boolean isAtRest() {
        return Math.abs(this.currentState.getVelocity()) <= this.restSpeedThreshold && (getDisplacementDistanceForState(this.currentState) <= this.displacementFromRestThreshold || this.springStiffness == 0.0d);
    }

    private final boolean isOvershooting() {
        return this.springStiffness > 0.0d && ((this.startValue < this.endValue && this.currentState.getPosition() > this.endValue) || (this.startValue > this.endValue && this.currentState.getPosition() < this.endValue));
    }

    private final void advance(double d) {
        double dSin;
        double dSin2;
        if (isAtRest()) {
            return;
        }
        double d2 = MAX_DELTA_TIME_SEC;
        if (d <= MAX_DELTA_TIME_SEC) {
            d2 = d;
        }
        this.timeAccumulator += d2;
        double d3 = this.springDamping;
        double d4 = this.springMass;
        double d5 = this.springStiffness;
        double d6 = -this.initialVelocity;
        double dSqrt = d3 / (((double) 2) * Math.sqrt(d5 * d4));
        double dSqrt2 = Math.sqrt(d5 / d4);
        double dSqrt3 = Math.sqrt(1.0d - (dSqrt * dSqrt)) * dSqrt2;
        double d7 = this.endValue - this.startValue;
        double d8 = this.timeAccumulator;
        if (dSqrt < 1.0d) {
            double dExp = Math.exp((-dSqrt) * dSqrt2 * d8);
            double d9 = dSqrt * dSqrt2;
            double d10 = d6 + (d9 * d7);
            double d11 = d8 * dSqrt3;
            dSin = this.endValue - ((((d10 / dSqrt3) * Math.sin(d11)) + (Math.cos(d11) * d7)) * dExp);
            dSin2 = ((d9 * dExp) * (((Math.sin(d11) * d10) / dSqrt3) + (Math.cos(d11) * d7))) - (((Math.cos(d11) * d10) - ((dSqrt3 * d7) * Math.sin(d11))) * dExp);
        } else {
            double dExp2 = Math.exp((-dSqrt2) * d8);
            dSin = this.endValue - (((((dSqrt2 * d7) + d6) * d8) + d7) * dExp2);
            dSin2 = dExp2 * ((((d8 * dSqrt2) - ((double) 1)) * d6) + (d8 * d7 * dSqrt2 * dSqrt2));
        }
        this.currentState.setPosition(dSin);
        this.currentState.setVelocity(dSin2);
        if (isAtRest() || (this.overshootClampingEnabled && isOvershooting())) {
            if (this.springStiffness > 0.0d) {
                double d12 = this.endValue;
                this.startValue = d12;
                this.currentState.setPosition(d12);
            } else {
                double position = this.currentState.getPosition();
                this.endValue = position;
                this.startValue = position;
            }
            this.currentState.setVelocity(0.0d);
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
