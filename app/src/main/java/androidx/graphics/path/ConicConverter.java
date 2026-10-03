package androidx.graphics.path;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class ConicConverter {
    private int currentQuadratic;
    private int quadraticCount;
    private float[] quadraticData = new float[130];

    private final native int internalConicToQuadratics(float[] fArr, int i, float[] fArr2, float f, float f2);

    public final int getQuadraticCount() {
        return this.quadraticCount;
    }

    public final int getCurrentQuadratic() {
        return this.currentQuadratic;
    }

    public final void setCurrentQuadratic(int i) {
        this.currentQuadratic = i;
    }

    public static /* synthetic */ boolean nextQuadratic$default(ConicConverter conicConverter, float[] fArr, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return conicConverter.nextQuadratic(fArr, i);
    }

    public final boolean nextQuadratic(@NotNull float[] points, int i) {
        Intrinsics.checkNotNullParameter(points, "points");
        int i2 = this.currentQuadratic;
        if (i2 >= this.quadraticCount) {
            return false;
        }
        int i3 = i2 * 4;
        float[] fArr = this.quadraticData;
        points[i] = fArr[i3];
        points[i + 1] = fArr[i3 + 1];
        points[i + 2] = fArr[i3 + 2];
        points[i + 3] = fArr[i3 + 3];
        points[i + 4] = fArr[i3 + 4];
        points[i + 5] = fArr[i3 + 5];
        this.currentQuadratic = i2 + 1;
        return true;
    }

    public static /* synthetic */ void convert$default(ConicConverter conicConverter, float[] fArr, float f, float f2, int i, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            i = 0;
        }
        conicConverter.convert(fArr, f, f2, i);
    }

    public final void convert(@NotNull float[] points, float f, float f2, int i) {
        Intrinsics.checkNotNullParameter(points, "points");
        int iInternalConicToQuadratics = internalConicToQuadratics(points, i, this.quadraticData, f, f2);
        this.quadraticCount = iInternalConicToQuadratics;
        int i2 = (iInternalConicToQuadratics * 4) + 2;
        if (i2 > this.quadraticData.length) {
            float[] fArr = new float[i2];
            this.quadraticData = fArr;
            this.quadraticCount = internalConicToQuadratics(points, i, fArr, f, f2);
        }
        this.currentQuadratic = 0;
    }
}
