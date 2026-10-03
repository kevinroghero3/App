package androidx.compose.animation.core;

import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class ArcSpline {
    public static final int ArcAbove = 5;
    public static final int ArcBelow = 4;
    public static final int ArcStartFlip = 3;
    public static final int ArcStartHorizontal = 2;
    public static final int ArcStartLinear = 0;
    public static final int ArcStartVertical = 1;
    private static final int DownArc = 4;
    private static final int StartHorizontal = 2;
    private static final int StartLinear = 3;
    private static final int StartVertical = 1;
    private static final int UpArc = 5;
    private final Arc[][] arcs;
    private final boolean isExtrapolate = true;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* JADX WARN: Code duplicated, block: B:16:0x002b  */
    /* JADX WARN: Code duplicated, block: B:18:0x002e A[PHI: r10
  0x002e: PHI (r10v1 int) = (r10v0 int), (r10v5 int), (r10v6 int) binds: [B:5:0x0018, B:10:0x0021, B:12:0x0024] A[DONT_GENERATE, DONT_INLINE]] */
    public ArcSpline(@NotNull int[] iArr, @NotNull float[] fArr, @NotNull float[][] fArr2) {
        int length = fArr.length - 1;
        Arc[][] arcArr = new Arc[length][];
        int i = 1;
        int i2 = 1;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = iArr[i3];
            int i5 = 3;
            if (i4 == 0) {
                i2 = i5;
            } else if (i4 == 1) {
                i = 1;
                i2 = i;
            } else {
                if (i4 != 2) {
                    if (i4 != 3) {
                        i5 = 4;
                        if (i4 != 4) {
                            i5 = 5;
                            if (i4 == 5) {
                                i2 = i5;
                            }
                        } else {
                            i2 = i5;
                        }
                    } else {
                        if (i != 1) {
                            i = 1;
                        }
                        i2 = i;
                    }
                }
                i = 2;
                i2 = i;
            }
            float[] fArr3 = fArr2[i3];
            int length2 = (fArr3.length / 2) + (fArr3.length % 2);
            Arc[] arcArr2 = new Arc[length2];
            for (int i6 = 0; i6 < length2; i6++) {
                int i7 = i6 * 2;
                float f = fArr[i3];
                int i8 = i3 + 1;
                float f2 = fArr[i8];
                float[] fArr4 = fArr2[i3];
                float f3 = fArr4[i7];
                int i9 = i7 + 1;
                float f4 = fArr4[i9];
                float[] fArr5 = fArr2[i8];
                arcArr2[i6] = new Arc(i2, f, f2, f3, f4, fArr5[i7], fArr5[i9]);
            }
            arcArr[i3] = arcArr2;
        }
        this.arcs = arcArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0022, code lost:
    
        if (r9 > r0[r0.length - 1][0].getTime2()) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void getPos(float r9, @org.jetbrains.annotations.NotNull float[] r10) {
        /*
            Method dump skipped, instruction units count: 377
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.ArcSpline.getPos(float, float[]):void");
    }

    public final void getSlope(float f, @NotNull float[] fArr) {
        if (f < this.arcs[0][0].getTime1()) {
            f = this.arcs[0][0].getTime1();
        } else {
            Arc[][] arcArr = this.arcs;
            if (f > arcArr[arcArr.length - 1][0].getTime2()) {
                Arc[][] arcArr2 = this.arcs;
                f = arcArr2[arcArr2.length - 1][0].getTime2();
            }
        }
        int length = this.arcs.length;
        boolean z = false;
        for (int i = 0; i < length; i++) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < fArr.length) {
                if (f <= this.arcs[i][i3].getTime2()) {
                    if (this.arcs[i][i3].isLinear()) {
                        fArr[i2] = this.arcs[i][i3].getLinearDX();
                        fArr[i2 + 1] = this.arcs[i][i3].getLinearDY();
                    } else {
                        this.arcs[i][i3].setPoint(f);
                        fArr[i2] = this.arcs[i][i3].calcDX();
                        fArr[i2 + 1] = this.arcs[i][i3].calcDY();
                    }
                    z = true;
                }
                i2 += 2;
                i3++;
            }
            if (z) {
                return;
            }
        }
    }

    public static final class Arc {
        private static final float Epsilon = 0.001f;
        private static float[] _ourPercent;
        private float arcDistance;
        private final float arcVelocity;
        private final float ellipseA;
        private final float ellipseB;
        private final float ellipseCenterX;
        private final float ellipseCenterY;
        private final boolean isLinear;
        private final boolean isVertical;
        private final float[] lut;
        private final float oneOverDeltaTime;
        private final float time1;
        private final float time2;
        private float tmpCosAngle;
        private float tmpSinAngle;
        private final float x1;
        private final float x2;
        private final float y1;
        private final float y2;
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;

        public Arc(int i, float f, float f2, float f3, float f4, float f5, float f6) {
            this.time1 = f;
            this.time2 = f2;
            this.x1 = f3;
            this.y1 = f4;
            this.x2 = f5;
            this.y2 = f6;
            float f7 = f5 - f3;
            float f8 = f6 - f4;
            boolean z = true;
            boolean z2 = i == 1 || (i == 4 ? f8 > 0.0f : !(i != 5 || f8 >= 0.0f));
            this.isVertical = z2;
            float f9 = f2 - f;
            float f10 = 1 / f9;
            this.oneOverDeltaTime = f10;
            boolean z3 = 3 == i;
            if (z3 || Math.abs(f7) < Epsilon || Math.abs(f8) < Epsilon) {
                float fHypot = (float) Math.hypot(f8, f7);
                this.arcDistance = fHypot;
                this.arcVelocity = fHypot * f10;
                this.ellipseCenterX = f7 / f9;
                this.ellipseCenterY = f8 / f9;
                this.lut = new float[101];
                this.ellipseA = Float.NaN;
                this.ellipseB = Float.NaN;
            } else {
                this.lut = new float[101];
                this.ellipseA = f7 * (z2 ? -1 : 1);
                this.ellipseB = f8 * (z2 ? 1 : -1);
                this.ellipseCenterX = z2 ? f5 : f3;
                this.ellipseCenterY = z2 ? f4 : f6;
                buildTable(f3, f4, f5, f6);
                this.arcVelocity = this.arcDistance * f10;
                z = z3;
            }
            this.isLinear = z;
        }

        public final float getTime1() {
            return this.time1;
        }

        public final float getTime2() {
            return this.time2;
        }

        public final boolean isLinear() {
            return this.isLinear;
        }

        public final void setPoint(float f) {
            double dLookup = lookup((this.isVertical ? this.time2 - f : f - this.time1) * this.oneOverDeltaTime) * 1.5707964f;
            this.tmpSinAngle = (float) Math.sin(dLookup);
            this.tmpCosAngle = (float) Math.cos(dLookup);
        }

        public final float calcX() {
            return this.ellipseCenterX + (this.ellipseA * this.tmpSinAngle);
        }

        public final float calcY() {
            return this.ellipseCenterY + (this.ellipseB * this.tmpCosAngle);
        }

        public final float calcDX() {
            float f = this.ellipseA * this.tmpCosAngle;
            float fHypot = this.arcVelocity / ((float) Math.hypot(f, (-this.ellipseB) * this.tmpSinAngle));
            if (this.isVertical) {
                f = -f;
            }
            return f * fHypot;
        }

        public final float calcDY() {
            float f = this.ellipseA;
            float f2 = this.tmpCosAngle;
            float f3 = (-this.ellipseB) * this.tmpSinAngle;
            float fHypot = this.arcVelocity / ((float) Math.hypot(f * f2, f3));
            return this.isVertical ? (-f3) * fHypot : f3 * fHypot;
        }

        public final float getLinearX(float f) {
            float f2 = this.time1;
            float f3 = this.oneOverDeltaTime;
            float f4 = this.x1;
            return f4 + ((f - f2) * f3 * (this.x2 - f4));
        }

        public final float getLinearY(float f) {
            float f2 = this.time1;
            float f3 = this.oneOverDeltaTime;
            float f4 = this.y1;
            return f4 + ((f - f2) * f3 * (this.y2 - f4));
        }

        public final float getLinearDX() {
            return this.ellipseCenterX;
        }

        public final float getLinearDY() {
            return this.ellipseCenterY;
        }

        private final float lookup(float f) {
            if (f <= 0.0f) {
                return 0.0f;
            }
            if (f >= 1.0f) {
                return 1.0f;
            }
            float[] fArr = this.lut;
            float length = f * (fArr.length - 1);
            int i = (int) length;
            float f2 = fArr[i];
            return f2 + ((length - i) * (fArr[i + 1] - f2));
        }

        private final void buildTable(float f, float f2, float f3, float f4) {
            int length = Companion.getOurPercent().length;
            int i = 0;
            float fHypot = 0.0f;
            float f5 = 0.0f;
            float f6 = 0.0f;
            while (i < length) {
                Companion companion = Companion;
                double radians = (float) Math.toRadians((((double) i) * 90.0d) / ((double) (companion.getOurPercent().length - 1)));
                float fSin = ((float) Math.sin(radians)) * (f3 - f);
                float fCos = ((float) Math.cos(radians)) * (f2 - f4);
                if (i > 0) {
                    fHypot += (float) Math.hypot(fSin - f5, fCos - f6);
                    companion.getOurPercent()[i] = fHypot;
                }
                i++;
                f6 = fCos;
                f5 = fSin;
            }
            this.arcDistance = fHypot;
            int length2 = Companion.getOurPercent().length;
            for (int i2 = 0; i2 < length2; i2++) {
                float[] ourPercent = Companion.getOurPercent();
                ourPercent[i2] = ourPercent[i2] / fHypot;
            }
            int length3 = this.lut.length;
            for (int i3 = 0; i3 < length3; i3++) {
                float length4 = i3 / (this.lut.length - 1);
                Companion companion2 = Companion;
                int iBinarySearch$default = ArraysKt___ArraysJvmKt.binarySearch$default(companion2.getOurPercent(), length4, 0, 0, 6, (Object) null);
                if (iBinarySearch$default >= 0) {
                    this.lut[i3] = iBinarySearch$default / (companion2.getOurPercent().length - 1);
                } else if (iBinarySearch$default == -1) {
                    this.lut[i3] = 0.0f;
                } else {
                    int i4 = -iBinarySearch$default;
                    int i5 = i4 - 2;
                    this.lut[i3] = (i5 + ((length4 - companion2.getOurPercent()[i5]) / (companion2.getOurPercent()[i4 - 1] - companion2.getOurPercent()[i5]))) / (companion2.getOurPercent().length - 1);
                }
            }
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final float[] getOurPercent() {
                if (Arc._ourPercent != null) {
                    float[] fArr = Arc._ourPercent;
                    Intrinsics.checkNotNull(fArr);
                    return fArr;
                }
                Arc._ourPercent = new float[91];
                float[] fArr2 = Arc._ourPercent;
                Intrinsics.checkNotNull(fArr2);
                return fArr2;
            }
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
