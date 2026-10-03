package androidx.compose.ui.platform;

import android.graphics.Matrix;
import androidx.compose.ui.graphics.AndroidMatrixConversions_androidKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class LayerMatrixCache<T> {
    public static final int $stable = 8;
    private Matrix androidMatrixCache;
    private final Function2<T, Matrix, Unit> getMatrix;
    private float[] inverseMatrixCache;
    private boolean isDirty = true;
    private boolean isInverseDirty = true;
    private boolean isInverseValid = true;
    private float[] matrixCache;
    private Matrix previousAndroidMatrix;

    /* JADX WARN: Multi-variable type inference failed */
    public LayerMatrixCache(@NotNull Function2<? super T, ? super Matrix, Unit> function2) {
        this.getMatrix = function2;
    }

    public final void invalidate() {
        this.isDirty = true;
        this.isInverseDirty = true;
    }

    /* JADX INFO: renamed from: calculateMatrix-GrdbGEg, reason: not valid java name */
    public final float[] m2894calculateMatrixGrdbGEg(T t) {
        float[] fArrM1401constructorimpl$default = this.matrixCache;
        if (fArrM1401constructorimpl$default == null) {
            fArrM1401constructorimpl$default = androidx.compose.ui.graphics.Matrix.m1401constructorimpl$default(null, 1, null);
            this.matrixCache = fArrM1401constructorimpl$default;
        }
        if (!this.isDirty) {
            return fArrM1401constructorimpl$default;
        }
        Matrix matrix = this.androidMatrixCache;
        if (matrix == null) {
            matrix = new Matrix();
            this.androidMatrixCache = matrix;
        }
        this.getMatrix.invoke(t, matrix);
        Matrix matrix2 = this.previousAndroidMatrix;
        if (matrix2 == null || !Intrinsics.areEqual(matrix, matrix2)) {
            AndroidMatrixConversions_androidKt.m1040setFromtUYjHk(fArrM1401constructorimpl$default, matrix);
            this.androidMatrixCache = matrix2;
            this.previousAndroidMatrix = matrix;
        }
        this.isDirty = false;
        return fArrM1401constructorimpl$default;
    }

    /* JADX INFO: renamed from: calculateInverseMatrix-bWbORWo, reason: not valid java name */
    public final float[] m2893calculateInverseMatrixbWbORWo(T t) {
        float[] fArrM1401constructorimpl$default = this.inverseMatrixCache;
        if (fArrM1401constructorimpl$default == null) {
            fArrM1401constructorimpl$default = androidx.compose.ui.graphics.Matrix.m1401constructorimpl$default(null, 1, null);
            this.inverseMatrixCache = fArrM1401constructorimpl$default;
        }
        if (this.isInverseDirty) {
            this.isInverseValid = InvertMatrixKt.m2891invertToJiSxe2E(m2894calculateMatrixGrdbGEg(t), fArrM1401constructorimpl$default);
            this.isInverseDirty = false;
        }
        if (this.isInverseValid) {
            return fArrM1401constructorimpl$default;
        }
        return null;
    }
}
