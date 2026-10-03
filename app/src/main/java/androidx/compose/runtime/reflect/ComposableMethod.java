package androidx.compose.runtime.reflect;

import androidx.compose.runtime.Composer;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class ComposableMethod {
    public static final int $stable = 8;
    private final ComposableInfo composableInfo;
    private final Method method;

    public ComposableMethod(@NotNull Method method, @NotNull ComposableInfo composableInfo) {
        this.method = method;
        this.composableInfo = composableInfo;
    }

    public final Method asMethod() {
        return this.method;
    }

    public final int getParameterCount() {
        return this.composableInfo.getRealParamsCount();
    }

    public final Parameter[] getParameters() {
        return (Parameter[]) ArraysKt___ArraysJvmKt.copyOfRange(this.method.getParameters(), 0, this.composableInfo.getRealParamsCount());
    }

    public final Class<?>[] getParameterTypes() {
        return (Class[]) ArraysKt___ArraysJvmKt.copyOfRange(this.method.getParameterTypes(), 0, this.composableInfo.getRealParamsCount());
    }

    public final Object invoke(@NotNull Composer composer, @Nullable Object obj, @NotNull Object... objArr) {
        Object defaultValue;
        ComposableInfo composableInfo = this.composableInfo;
        int iComponent2 = composableInfo.component2();
        int iComponent3 = composableInfo.component3();
        int iComponent4 = composableInfo.component4();
        int length = this.method.getParameterTypes().length;
        int i = iComponent2 + 1;
        int i2 = iComponent3 + i;
        Object[] objArr2 = new Integer[iComponent4];
        for (int i3 = 0; i3 < iComponent4; i3++) {
            int i4 = i3 * 31;
            IntRange intRangeUntil = RangesKt___RangesKt.until(i4, Math.min(i4 + 31, iComponent2));
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(intRangeUntil, 10));
            Iterator<Integer> it2 = intRangeUntil.iterator();
            while (it2.hasNext()) {
                int iNextInt = ((IntIterator) it2).nextInt();
                arrayList.add(Integer.valueOf((iNextInt >= objArr.length || objArr[iNextInt] == null) ? 1 : 0));
            }
            int iIntValue = 0;
            int i5 = 0;
            for (Object obj2 : arrayList) {
                if (i5 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                iIntValue |= ((Number) obj2).intValue() << i5;
                i5++;
            }
            objArr2[i3] = Integer.valueOf(iIntValue);
        }
        Object[] objArr3 = new Object[length];
        int i6 = 0;
        while (i6 < length) {
            if (i6 >= 0 && i6 < iComponent2) {
                defaultValue = (i6 < 0 || i6 > ArraysKt___ArraysKt.getLastIndex(objArr)) ? ComposableMethodKt.getDefaultValue(this.method.getParameterTypes()[i6]) : objArr[i6];
            } else if (i6 == iComponent2) {
                defaultValue = composer;
            } else if (i6 == i || (iComponent2 + 2 <= i6 && i6 < i2)) {
                defaultValue = 0;
            } else {
                if (i2 > i6 || i6 >= length) {
                    throw new IllegalStateException("Unexpected index");
                }
                defaultValue = objArr2[i6 - i2];
            }
            objArr3[i6] = defaultValue;
            i6++;
        }
        return this.method.invoke(obj, Arrays.copyOf(objArr3, length));
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof ComposableMethod) {
            return Intrinsics.areEqual(this.method, ((ComposableMethod) obj).method);
        }
        return false;
    }

    public int hashCode() {
        return this.method.hashCode();
    }
}
