package androidx.compose.runtime.external.kotlinx.collections.immutable.internal;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class ForEachOneBitKt {
    public static final void forEachOneBit(int i, @NotNull Function2<? super Integer, ? super Integer, Unit> function2) {
        int i2 = 0;
        while (i != 0) {
            int iLowestOneBit = Integer.lowestOneBit(i);
            function2.invoke(Integer.valueOf(iLowestOneBit), Integer.valueOf(i2));
            i2++;
            i ^= iLowestOneBit;
        }
    }
}
