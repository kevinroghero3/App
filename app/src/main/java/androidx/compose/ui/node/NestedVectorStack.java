package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class NestedVectorStack<T> {
    public static final int $stable = 8;
    private int size;
    private int[] currentIndexes = new int[16];
    private MutableVector<T>[] vectors = new MutableVector[16];

    public final boolean isNotEmpty() {
        int i = this.size;
        return i > 0 && this.currentIndexes[i - 1] >= 0;
    }

    public final T pop() {
        int i = this.size;
        if (i <= 0) {
            throw new IllegalStateException("Cannot call pop() on an empty stack. Guard with a call to isNotEmpty()");
        }
        int i2 = i - 1;
        int i3 = this.currentIndexes[i2];
        MutableVector<T> mutableVector = this.vectors[i2];
        Intrinsics.checkNotNull(mutableVector);
        if (i3 > 0) {
            int[] iArr = this.currentIndexes;
            iArr[i2] = iArr[i2] - 1;
        } else if (i3 == 0) {
            this.vectors[i2] = null;
            this.size--;
        }
        return mutableVector.getContent()[i3];
    }

    public final void push(@NotNull MutableVector<T> mutableVector) {
        if (mutableVector.isEmpty()) {
            return;
        }
        int i = this.size;
        int[] iArr = this.currentIndexes;
        if (i >= iArr.length) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length * 2);
            Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(this, newSize)");
            this.currentIndexes = iArrCopyOf;
            MutableVector<T>[] mutableVectorArr = this.vectors;
            Object[] objArrCopyOf = Arrays.copyOf(mutableVectorArr, mutableVectorArr.length * 2);
            Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(this, newSize)");
            this.vectors = (MutableVector[]) objArrCopyOf;
        }
        this.currentIndexes[i] = mutableVector.getSize() - 1;
        this.vectors[i] = mutableVector;
        this.size++;
    }
}
