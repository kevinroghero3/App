package kotlin.collections.unsigned;

import com.google.maps.android.BuildConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.Unit;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsJvmKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.IndexingIterable;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.UArraySortingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes.dex */
public class UArraysKt___UArraysKt extends UArraysKt___UArraysJvmKt {
    /* JADX INFO: renamed from: asByteArray-GBYM_sE, reason: not valid java name */
    private static final byte[] m6021asByteArrayGBYM_sE(byte[] asByteArray) {
        Intrinsics.checkNotNullParameter(asByteArray, "$this$asByteArray");
        return asByteArray;
    }

    /* JADX INFO: renamed from: asIntArray--ajY-9A, reason: not valid java name */
    private static final int[] m6022asIntArrayajY9A(int[] asIntArray) {
        Intrinsics.checkNotNullParameter(asIntArray, "$this$asIntArray");
        return asIntArray;
    }

    /* JADX INFO: renamed from: asLongArray-QwZRm1k, reason: not valid java name */
    private static final long[] m6023asLongArrayQwZRm1k(long[] asLongArray) {
        Intrinsics.checkNotNullParameter(asLongArray, "$this$asLongArray");
        return asLongArray;
    }

    /* JADX INFO: renamed from: asShortArray-rL5Bavg, reason: not valid java name */
    private static final short[] m6024asShortArrayrL5Bavg(short[] asShortArray) {
        Intrinsics.checkNotNullParameter(asShortArray, "$this$asShortArray");
        return asShortArray;
    }

    /* JADX INFO: renamed from: getIndices--ajY-9A$annotations, reason: not valid java name */
    public static /* synthetic */ void m6210getIndicesajY9A$annotations(int[] iArr) {
    }

    /* JADX INFO: renamed from: getIndices-GBYM_sE$annotations, reason: not valid java name */
    public static /* synthetic */ void m6212getIndicesGBYM_sE$annotations(byte[] bArr) {
    }

    /* JADX INFO: renamed from: getIndices-QwZRm1k$annotations, reason: not valid java name */
    public static /* synthetic */ void m6214getIndicesQwZRm1k$annotations(long[] jArr) {
    }

    /* JADX INFO: renamed from: getIndices-rL5Bavg$annotations, reason: not valid java name */
    public static /* synthetic */ void m6216getIndicesrL5Bavg$annotations(short[] sArr) {
    }

    /* JADX INFO: renamed from: getLastIndex--ajY-9A$annotations, reason: not valid java name */
    public static /* synthetic */ void m6218getLastIndexajY9A$annotations(int[] iArr) {
    }

    /* JADX INFO: renamed from: getLastIndex-GBYM_sE$annotations, reason: not valid java name */
    public static /* synthetic */ void m6220getLastIndexGBYM_sE$annotations(byte[] bArr) {
    }

    /* JADX INFO: renamed from: getLastIndex-QwZRm1k$annotations, reason: not valid java name */
    public static /* synthetic */ void m6222getLastIndexQwZRm1k$annotations(long[] jArr) {
    }

    /* JADX INFO: renamed from: getLastIndex-rL5Bavg$annotations, reason: not valid java name */
    public static /* synthetic */ void m6224getLastIndexrL5Bavg$annotations(short[] sArr) {
    }

    /* JADX INFO: renamed from: component1--ajY-9A, reason: not valid java name */
    private static final int m6033component1ajY9A(int[] component1) {
        Intrinsics.checkNotNullParameter(component1, "$this$component1");
        return UIntArray.m5627getpVg5ArA(component1, 0);
    }

    /* JADX INFO: renamed from: component1-QwZRm1k, reason: not valid java name */
    private static final long m6035component1QwZRm1k(long[] component1) {
        Intrinsics.checkNotNullParameter(component1, "$this$component1");
        return ULongArray.m5706getsVKNKU(component1, 0);
    }

    /* JADX INFO: renamed from: component1-GBYM_sE, reason: not valid java name */
    private static final byte m6034component1GBYM_sE(byte[] component1) {
        Intrinsics.checkNotNullParameter(component1, "$this$component1");
        return UByteArray.m5548getw2LRezQ(component1, 0);
    }

    /* JADX INFO: renamed from: component1-rL5Bavg, reason: not valid java name */
    private static final short m6036component1rL5Bavg(short[] component1) {
        Intrinsics.checkNotNullParameter(component1, "$this$component1");
        return UShortArray.m5811getMh2AYeg(component1, 0);
    }

    /* JADX INFO: renamed from: component2--ajY-9A, reason: not valid java name */
    private static final int m6037component2ajY9A(int[] component2) {
        Intrinsics.checkNotNullParameter(component2, "$this$component2");
        return UIntArray.m5627getpVg5ArA(component2, 1);
    }

    /* JADX INFO: renamed from: component2-QwZRm1k, reason: not valid java name */
    private static final long m6039component2QwZRm1k(long[] component2) {
        Intrinsics.checkNotNullParameter(component2, "$this$component2");
        return ULongArray.m5706getsVKNKU(component2, 1);
    }

    /* JADX INFO: renamed from: component2-GBYM_sE, reason: not valid java name */
    private static final byte m6038component2GBYM_sE(byte[] component2) {
        Intrinsics.checkNotNullParameter(component2, "$this$component2");
        return UByteArray.m5548getw2LRezQ(component2, 1);
    }

    /* JADX INFO: renamed from: component2-rL5Bavg, reason: not valid java name */
    private static final short m6040component2rL5Bavg(short[] component2) {
        Intrinsics.checkNotNullParameter(component2, "$this$component2");
        return UShortArray.m5811getMh2AYeg(component2, 1);
    }

    /* JADX INFO: renamed from: component3--ajY-9A, reason: not valid java name */
    private static final int m6041component3ajY9A(int[] component3) {
        Intrinsics.checkNotNullParameter(component3, "$this$component3");
        return UIntArray.m5627getpVg5ArA(component3, 2);
    }

    /* JADX INFO: renamed from: component3-QwZRm1k, reason: not valid java name */
    private static final long m6043component3QwZRm1k(long[] component3) {
        Intrinsics.checkNotNullParameter(component3, "$this$component3");
        return ULongArray.m5706getsVKNKU(component3, 2);
    }

    /* JADX INFO: renamed from: component3-GBYM_sE, reason: not valid java name */
    private static final byte m6042component3GBYM_sE(byte[] component3) {
        Intrinsics.checkNotNullParameter(component3, "$this$component3");
        return UByteArray.m5548getw2LRezQ(component3, 2);
    }

    /* JADX INFO: renamed from: component3-rL5Bavg, reason: not valid java name */
    private static final short m6044component3rL5Bavg(short[] component3) {
        Intrinsics.checkNotNullParameter(component3, "$this$component3");
        return UShortArray.m5811getMh2AYeg(component3, 2);
    }

    /* JADX INFO: renamed from: component4--ajY-9A, reason: not valid java name */
    private static final int m6045component4ajY9A(int[] component4) {
        Intrinsics.checkNotNullParameter(component4, "$this$component4");
        return UIntArray.m5627getpVg5ArA(component4, 3);
    }

    /* JADX INFO: renamed from: component4-QwZRm1k, reason: not valid java name */
    private static final long m6047component4QwZRm1k(long[] component4) {
        Intrinsics.checkNotNullParameter(component4, "$this$component4");
        return ULongArray.m5706getsVKNKU(component4, 3);
    }

    /* JADX INFO: renamed from: component4-GBYM_sE, reason: not valid java name */
    private static final byte m6046component4GBYM_sE(byte[] component4) {
        Intrinsics.checkNotNullParameter(component4, "$this$component4");
        return UByteArray.m5548getw2LRezQ(component4, 3);
    }

    /* JADX INFO: renamed from: component4-rL5Bavg, reason: not valid java name */
    private static final short m6048component4rL5Bavg(short[] component4) {
        Intrinsics.checkNotNullParameter(component4, "$this$component4");
        return UShortArray.m5811getMh2AYeg(component4, 3);
    }

    /* JADX INFO: renamed from: component5--ajY-9A, reason: not valid java name */
    private static final int m6049component5ajY9A(int[] component5) {
        Intrinsics.checkNotNullParameter(component5, "$this$component5");
        return UIntArray.m5627getpVg5ArA(component5, 4);
    }

    /* JADX INFO: renamed from: component5-QwZRm1k, reason: not valid java name */
    private static final long m6051component5QwZRm1k(long[] component5) {
        Intrinsics.checkNotNullParameter(component5, "$this$component5");
        return ULongArray.m5706getsVKNKU(component5, 4);
    }

    /* JADX INFO: renamed from: component5-GBYM_sE, reason: not valid java name */
    private static final byte m6050component5GBYM_sE(byte[] component5) {
        Intrinsics.checkNotNullParameter(component5, "$this$component5");
        return UByteArray.m5548getw2LRezQ(component5, 4);
    }

    /* JADX INFO: renamed from: component5-rL5Bavg, reason: not valid java name */
    private static final short m6052component5rL5Bavg(short[] component5) {
        Intrinsics.checkNotNullParameter(component5, "$this$component5");
        return UShortArray.m5811getMh2AYeg(component5, 4);
    }

    /* JADX INFO: renamed from: elementAtOrElse-QxvSvLU, reason: not valid java name */
    private static final int m6106elementAtOrElseQxvSvLU(int[] elementAtOrElse, int i, Function1<? super Integer, UInt> defaultValue) {
        Intrinsics.checkNotNullParameter(elementAtOrElse, "$this$elementAtOrElse");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return (i < 0 || i >= UIntArray.m5628getSizeimpl(elementAtOrElse)) ? defaultValue.invoke(Integer.valueOf(i)).m5619unboximpl() : UIntArray.m5627getpVg5ArA(elementAtOrElse, i);
    }

    /* JADX INFO: renamed from: elementAtOrElse-Xw8i6dc, reason: not valid java name */
    private static final long m6107elementAtOrElseXw8i6dc(long[] elementAtOrElse, int i, Function1<? super Integer, ULong> defaultValue) {
        Intrinsics.checkNotNullParameter(elementAtOrElse, "$this$elementAtOrElse");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return (i < 0 || i >= ULongArray.m5707getSizeimpl(elementAtOrElse)) ? defaultValue.invoke(Integer.valueOf(i)).m5698unboximpl() : ULongArray.m5706getsVKNKU(elementAtOrElse, i);
    }

    /* JADX INFO: renamed from: elementAtOrElse-cO-VybQ, reason: not valid java name */
    private static final byte m6108elementAtOrElsecOVybQ(byte[] elementAtOrElse, int i, Function1<? super Integer, UByte> defaultValue) {
        Intrinsics.checkNotNullParameter(elementAtOrElse, "$this$elementAtOrElse");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return (i < 0 || i >= UByteArray.m5549getSizeimpl(elementAtOrElse)) ? defaultValue.invoke(Integer.valueOf(i)).m5540unboximpl() : UByteArray.m5548getw2LRezQ(elementAtOrElse, i);
    }

    /* JADX INFO: renamed from: elementAtOrElse-CVVdw08, reason: not valid java name */
    private static final short m6105elementAtOrElseCVVdw08(short[] elementAtOrElse, int i, Function1<? super Integer, UShort> defaultValue) {
        Intrinsics.checkNotNullParameter(elementAtOrElse, "$this$elementAtOrElse");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return (i < 0 || i >= UShortArray.m5812getSizeimpl(elementAtOrElse)) ? defaultValue.invoke(Integer.valueOf(i)).m5803unboximpl() : UShortArray.m5811getMh2AYeg(elementAtOrElse, i);
    }

    /* JADX INFO: renamed from: elementAtOrNull-qFRl0hI, reason: not valid java name */
    private static final UInt m6111elementAtOrNullqFRl0hI(int[] elementAtOrNull, int i) {
        Intrinsics.checkNotNullParameter(elementAtOrNull, "$this$elementAtOrNull");
        return m6231getOrNullqFRl0hI(elementAtOrNull, i);
    }

    /* JADX INFO: renamed from: elementAtOrNull-r7IrZao, reason: not valid java name */
    private static final ULong m6112elementAtOrNullr7IrZao(long[] elementAtOrNull, int i) {
        Intrinsics.checkNotNullParameter(elementAtOrNull, "$this$elementAtOrNull");
        return m6232getOrNullr7IrZao(elementAtOrNull, i);
    }

    /* JADX INFO: renamed from: elementAtOrNull-PpDY95g, reason: not valid java name */
    private static final UByte m6109elementAtOrNullPpDY95g(byte[] elementAtOrNull, int i) {
        Intrinsics.checkNotNullParameter(elementAtOrNull, "$this$elementAtOrNull");
        return m6229getOrNullPpDY95g(elementAtOrNull, i);
    }

    /* JADX INFO: renamed from: elementAtOrNull-nggk6HY, reason: not valid java name */
    private static final UShort m6110elementAtOrNullnggk6HY(short[] elementAtOrNull, int i) {
        Intrinsics.checkNotNullParameter(elementAtOrNull, "$this$elementAtOrNull");
        return m6230getOrNullnggk6HY(elementAtOrNull, i);
    }

    /* JADX INFO: renamed from: find-jgv0xPQ, reason: not valid java name */
    private static final UInt m6147findjgv0xPQ(int[] find, Function1<? super UInt, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(find, "$this$find");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iM5628getSizeimpl = UIntArray.m5628getSizeimpl(find);
        for (int i = 0; i < iM5628getSizeimpl; i++) {
            int iM5627getpVg5ArA = UIntArray.m5627getpVg5ArA(find, i);
            if (predicate.invoke(UInt.m5561boximpl(iM5627getpVg5ArA)).booleanValue()) {
                return UInt.m5561boximpl(iM5627getpVg5ArA);
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: find-MShoTSo, reason: not valid java name */
    private static final ULong m6146findMShoTSo(long[] find, Function1<? super ULong, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(find, "$this$find");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iM5707getSizeimpl = ULongArray.m5707getSizeimpl(find);
        for (int i = 0; i < iM5707getSizeimpl; i++) {
            long jM5706getsVKNKU = ULongArray.m5706getsVKNKU(find, i);
            if (predicate.invoke(ULong.m5640boximpl(jM5706getsVKNKU)).booleanValue()) {
                return ULong.m5640boximpl(jM5706getsVKNKU);
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: find-JOV_ifY, reason: not valid java name */
    private static final UByte m6145findJOV_ifY(byte[] find, Function1<? super UByte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(find, "$this$find");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iM5549getSizeimpl = UByteArray.m5549getSizeimpl(find);
        for (int i = 0; i < iM5549getSizeimpl; i++) {
            byte bM5548getw2LRezQ = UByteArray.m5548getw2LRezQ(find, i);
            if (predicate.invoke(UByte.m5484boximpl(bM5548getw2LRezQ)).booleanValue()) {
                return UByte.m5484boximpl(bM5548getw2LRezQ);
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: find-xTcfx_M, reason: not valid java name */
    private static final UShort m6148findxTcfx_M(short[] find, Function1<? super UShort, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(find, "$this$find");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iM5812getSizeimpl = UShortArray.m5812getSizeimpl(find);
        for (int i = 0; i < iM5812getSizeimpl; i++) {
            short sM5811getMh2AYeg = UShortArray.m5811getMh2AYeg(find, i);
            if (predicate.invoke(UShort.m5747boximpl(sM5811getMh2AYeg)).booleanValue()) {
                return UShort.m5747boximpl(sM5811getMh2AYeg);
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: findLast-jgv0xPQ, reason: not valid java name */
    private static final UInt m6151findLastjgv0xPQ(int[] findLast, Function1<? super UInt, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(findLast, "$this$findLast");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iM5628getSizeimpl = UIntArray.m5628getSizeimpl(findLast) - 1;
        if (iM5628getSizeimpl >= 0) {
            while (true) {
                int i = iM5628getSizeimpl - 1;
                int iM5627getpVg5ArA = UIntArray.m5627getpVg5ArA(findLast, iM5628getSizeimpl);
                if (predicate.invoke(UInt.m5561boximpl(iM5627getpVg5ArA)).booleanValue()) {
                    return UInt.m5561boximpl(iM5627getpVg5ArA);
                }
                if (i >= 0) {
                    iM5628getSizeimpl = i;
                }
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: findLast-MShoTSo, reason: not valid java name */
    private static final ULong m6150findLastMShoTSo(long[] findLast, Function1<? super ULong, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(findLast, "$this$findLast");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iM5707getSizeimpl = ULongArray.m5707getSizeimpl(findLast) - 1;
        if (iM5707getSizeimpl >= 0) {
            while (true) {
                int i = iM5707getSizeimpl - 1;
                long jM5706getsVKNKU = ULongArray.m5706getsVKNKU(findLast, iM5707getSizeimpl);
                if (predicate.invoke(ULong.m5640boximpl(jM5706getsVKNKU)).booleanValue()) {
                    return ULong.m5640boximpl(jM5706getsVKNKU);
                }
                if (i >= 0) {
                    iM5707getSizeimpl = i;
                }
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: findLast-JOV_ifY, reason: not valid java name */
    private static final UByte m6149findLastJOV_ifY(byte[] findLast, Function1<? super UByte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(findLast, "$this$findLast");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iM5549getSizeimpl = UByteArray.m5549getSizeimpl(findLast) - 1;
        if (iM5549getSizeimpl >= 0) {
            while (true) {
                int i = iM5549getSizeimpl - 1;
                byte bM5548getw2LRezQ = UByteArray.m5548getw2LRezQ(findLast, iM5549getSizeimpl);
                if (predicate.invoke(UByte.m5484boximpl(bM5548getw2LRezQ)).booleanValue()) {
                    return UByte.m5484boximpl(bM5548getw2LRezQ);
                }
                if (i >= 0) {
                    iM5549getSizeimpl = i;
                }
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: findLast-xTcfx_M, reason: not valid java name */
    private static final UShort m6152findLastxTcfx_M(short[] findLast, Function1<? super UShort, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(findLast, "$this$findLast");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iM5812getSizeimpl = UShortArray.m5812getSizeimpl(findLast) - 1;
        if (iM5812getSizeimpl >= 0) {
            while (true) {
                int i = iM5812getSizeimpl - 1;
                short sM5811getMh2AYeg = UShortArray.m5811getMh2AYeg(findLast, iM5812getSizeimpl);
                if (predicate.invoke(UShort.m5747boximpl(sM5811getMh2AYeg)).booleanValue()) {
                    return UShort.m5747boximpl(sM5811getMh2AYeg);
                }
                if (i >= 0) {
                    iM5812getSizeimpl = i;
                }
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: first--ajY-9A, reason: not valid java name */
    private static final int m6153firstajY9A(int[] first) {
        Intrinsics.checkNotNullParameter(first, "$this$first");
        return UInt.m5567constructorimpl(ArraysKt___ArraysKt.first(first));
    }

    /* JADX INFO: renamed from: first-QwZRm1k, reason: not valid java name */
    private static final long m6157firstQwZRm1k(long[] first) {
        Intrinsics.checkNotNullParameter(first, "$this$first");
        return ULong.m5646constructorimpl(ArraysKt___ArraysKt.first(first));
    }

    /* JADX INFO: renamed from: first-GBYM_sE, reason: not valid java name */
    private static final byte m6154firstGBYM_sE(byte[] first) {
        Intrinsics.checkNotNullParameter(first, "$this$first");
        return UByte.m5490constructorimpl(ArraysKt___ArraysKt.first(first));
    }

    /* JADX INFO: renamed from: first-rL5Bavg, reason: not valid java name */
    private static final short m6159firstrL5Bavg(short[] first) {
        Intrinsics.checkNotNullParameter(first, "$this$first");
        return UShort.m5753constructorimpl(ArraysKt___ArraysKt.first(first));
    }

    /* JADX INFO: renamed from: first-jgv0xPQ, reason: not valid java name */
    private static final int m6158firstjgv0xPQ(int[] first, Function1<? super UInt, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(first, "$this$first");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iM5628getSizeimpl = UIntArray.m5628getSizeimpl(first);
        for (int i = 0; i < iM5628getSizeimpl; i++) {
            int iM5627getpVg5ArA = UIntArray.m5627getpVg5ArA(first, i);
            if (predicate.invoke(UInt.m5561boximpl(iM5627getpVg5ArA)).booleanValue()) {
                return iM5627getpVg5ArA;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    /* JADX INFO: renamed from: first-MShoTSo, reason: not valid java name */
    private static final long m6156firstMShoTSo(long[] first, Function1<? super ULong, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(first, "$this$first");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iM5707getSizeimpl = ULongArray.m5707getSizeimpl(first);
        for (int i = 0; i < iM5707getSizeimpl; i++) {
            long jM5706getsVKNKU = ULongArray.m5706getsVKNKU(first, i);
            if (predicate.invoke(ULong.m5640boximpl(jM5706getsVKNKU)).booleanValue()) {
                return jM5706getsVKNKU;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    /* JADX INFO: renamed from: first-JOV_ifY, reason: not valid java name */
    private static final byte m6155firstJOV_ifY(byte[] first, Function1<? super UByte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(first, "$this$first");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iM5549getSizeimpl = UByteArray.m5549getSizeimpl(first);
        for (int i = 0; i < iM5549getSizeimpl; i++) {
            byte bM5548getw2LRezQ = UByteArray.m5548getw2LRezQ(first, i);
            if (predicate.invoke(UByte.m5484boximpl(bM5548getw2LRezQ)).booleanValue()) {
                return bM5548getw2LRezQ;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    /* JADX INFO: renamed from: first-xTcfx_M, reason: not valid java name */
    private static final short m6160firstxTcfx_M(short[] first, Function1<? super UShort, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(first, "$this$first");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iM5812getSizeimpl = UShortArray.m5812getSizeimpl(first);
        for (int i = 0; i < iM5812getSizeimpl; i++) {
            short sM5811getMh2AYeg = UShortArray.m5811getMh2AYeg(first, i);
            if (predicate.invoke(UShort.m5747boximpl(sM5811getMh2AYeg)).booleanValue()) {
                return sM5811getMh2AYeg;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    /* JADX INFO: renamed from: firstOrNull--ajY-9A, reason: not valid java name */
    public static final UInt m6161firstOrNullajY9A(@NotNull int[] firstOrNull) {
        Intrinsics.checkNotNullParameter(firstOrNull, "$this$firstOrNull");
        if (UIntArray.m5630isEmptyimpl(firstOrNull)) {
            return null;
        }
        return UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(firstOrNull, 0));
    }

    /* JADX INFO: renamed from: firstOrNull-QwZRm1k, reason: not valid java name */
    public static final ULong m6165firstOrNullQwZRm1k(@NotNull long[] firstOrNull) {
        Intrinsics.checkNotNullParameter(firstOrNull, "$this$firstOrNull");
        if (ULongArray.m5709isEmptyimpl(firstOrNull)) {
            return null;
        }
        return ULong.m5640boximpl(ULongArray.m5706getsVKNKU(firstOrNull, 0));
    }

    /* JADX INFO: renamed from: firstOrNull-GBYM_sE, reason: not valid java name */
    public static final UByte m6162firstOrNullGBYM_sE(@NotNull byte[] firstOrNull) {
        Intrinsics.checkNotNullParameter(firstOrNull, "$this$firstOrNull");
        if (UByteArray.m5551isEmptyimpl(firstOrNull)) {
            return null;
        }
        return UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(firstOrNull, 0));
    }

    /* JADX INFO: renamed from: firstOrNull-rL5Bavg, reason: not valid java name */
    public static final UShort m6167firstOrNullrL5Bavg(@NotNull short[] firstOrNull) {
        Intrinsics.checkNotNullParameter(firstOrNull, "$this$firstOrNull");
        if (UShortArray.m5814isEmptyimpl(firstOrNull)) {
            return null;
        }
        return UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(firstOrNull, 0));
    }

    /* JADX INFO: renamed from: firstOrNull-jgv0xPQ, reason: not valid java name */
    private static final UInt m6166firstOrNulljgv0xPQ(int[] firstOrNull, Function1<? super UInt, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(firstOrNull, "$this$firstOrNull");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iM5628getSizeimpl = UIntArray.m5628getSizeimpl(firstOrNull);
        for (int i = 0; i < iM5628getSizeimpl; i++) {
            int iM5627getpVg5ArA = UIntArray.m5627getpVg5ArA(firstOrNull, i);
            if (predicate.invoke(UInt.m5561boximpl(iM5627getpVg5ArA)).booleanValue()) {
                return UInt.m5561boximpl(iM5627getpVg5ArA);
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: firstOrNull-MShoTSo, reason: not valid java name */
    private static final ULong m6164firstOrNullMShoTSo(long[] firstOrNull, Function1<? super ULong, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(firstOrNull, "$this$firstOrNull");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iM5707getSizeimpl = ULongArray.m5707getSizeimpl(firstOrNull);
        for (int i = 0; i < iM5707getSizeimpl; i++) {
            long jM5706getsVKNKU = ULongArray.m5706getsVKNKU(firstOrNull, i);
            if (predicate.invoke(ULong.m5640boximpl(jM5706getsVKNKU)).booleanValue()) {
                return ULong.m5640boximpl(jM5706getsVKNKU);
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: firstOrNull-JOV_ifY, reason: not valid java name */
    private static final UByte m6163firstOrNullJOV_ifY(byte[] firstOrNull, Function1<? super UByte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(firstOrNull, "$this$firstOrNull");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iM5549getSizeimpl = UByteArray.m5549getSizeimpl(firstOrNull);
        for (int i = 0; i < iM5549getSizeimpl; i++) {
            byte bM5548getw2LRezQ = UByteArray.m5548getw2LRezQ(firstOrNull, i);
            if (predicate.invoke(UByte.m5484boximpl(bM5548getw2LRezQ)).booleanValue()) {
                return UByte.m5484boximpl(bM5548getw2LRezQ);
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: firstOrNull-xTcfx_M, reason: not valid java name */
    private static final UShort m6168firstOrNullxTcfx_M(short[] firstOrNull, Function1<? super UShort, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(firstOrNull, "$this$firstOrNull");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iM5812getSizeimpl = UShortArray.m5812getSizeimpl(firstOrNull);
        for (int i = 0; i < iM5812getSizeimpl; i++) {
            short sM5811getMh2AYeg = UShortArray.m5811getMh2AYeg(firstOrNull, i);
            if (predicate.invoke(UShort.m5747boximpl(sM5811getMh2AYeg)).booleanValue()) {
                return UShort.m5747boximpl(sM5811getMh2AYeg);
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: getOrElse-QxvSvLU, reason: not valid java name */
    private static final int m6226getOrElseQxvSvLU(int[] getOrElse, int i, Function1<? super Integer, UInt> defaultValue) {
        Intrinsics.checkNotNullParameter(getOrElse, "$this$getOrElse");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return (i < 0 || i >= UIntArray.m5628getSizeimpl(getOrElse)) ? defaultValue.invoke(Integer.valueOf(i)).m5619unboximpl() : UIntArray.m5627getpVg5ArA(getOrElse, i);
    }

    /* JADX INFO: renamed from: getOrElse-Xw8i6dc, reason: not valid java name */
    private static final long m6227getOrElseXw8i6dc(long[] getOrElse, int i, Function1<? super Integer, ULong> defaultValue) {
        Intrinsics.checkNotNullParameter(getOrElse, "$this$getOrElse");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return (i < 0 || i >= ULongArray.m5707getSizeimpl(getOrElse)) ? defaultValue.invoke(Integer.valueOf(i)).m5698unboximpl() : ULongArray.m5706getsVKNKU(getOrElse, i);
    }

    /* JADX INFO: renamed from: getOrElse-cO-VybQ, reason: not valid java name */
    private static final byte m6228getOrElsecOVybQ(byte[] getOrElse, int i, Function1<? super Integer, UByte> defaultValue) {
        Intrinsics.checkNotNullParameter(getOrElse, "$this$getOrElse");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return (i < 0 || i >= UByteArray.m5549getSizeimpl(getOrElse)) ? defaultValue.invoke(Integer.valueOf(i)).m5540unboximpl() : UByteArray.m5548getw2LRezQ(getOrElse, i);
    }

    /* JADX INFO: renamed from: getOrElse-CVVdw08, reason: not valid java name */
    private static final short m6225getOrElseCVVdw08(short[] getOrElse, int i, Function1<? super Integer, UShort> defaultValue) {
        Intrinsics.checkNotNullParameter(getOrElse, "$this$getOrElse");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return (i < 0 || i >= UShortArray.m5812getSizeimpl(getOrElse)) ? defaultValue.invoke(Integer.valueOf(i)).m5803unboximpl() : UShortArray.m5811getMh2AYeg(getOrElse, i);
    }

    /* JADX INFO: renamed from: getOrNull-qFRl0hI, reason: not valid java name */
    public static final UInt m6231getOrNullqFRl0hI(@NotNull int[] getOrNull, int i) {
        Intrinsics.checkNotNullParameter(getOrNull, "$this$getOrNull");
        if (i < 0 || i >= UIntArray.m5628getSizeimpl(getOrNull)) {
            return null;
        }
        return UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(getOrNull, i));
    }

    /* JADX INFO: renamed from: getOrNull-r7IrZao, reason: not valid java name */
    public static final ULong m6232getOrNullr7IrZao(@NotNull long[] getOrNull, int i) {
        Intrinsics.checkNotNullParameter(getOrNull, "$this$getOrNull");
        if (i < 0 || i >= ULongArray.m5707getSizeimpl(getOrNull)) {
            return null;
        }
        return ULong.m5640boximpl(ULongArray.m5706getsVKNKU(getOrNull, i));
    }

    /* JADX INFO: renamed from: getOrNull-PpDY95g, reason: not valid java name */
    public static final UByte m6229getOrNullPpDY95g(@NotNull byte[] getOrNull, int i) {
        Intrinsics.checkNotNullParameter(getOrNull, "$this$getOrNull");
        if (i < 0 || i >= UByteArray.m5549getSizeimpl(getOrNull)) {
            return null;
        }
        return UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(getOrNull, i));
    }

    /* JADX INFO: renamed from: getOrNull-nggk6HY, reason: not valid java name */
    public static final UShort m6230getOrNullnggk6HY(@NotNull short[] getOrNull, int i) {
        Intrinsics.checkNotNullParameter(getOrNull, "$this$getOrNull");
        if (i < 0 || i >= UShortArray.m5812getSizeimpl(getOrNull)) {
            return null;
        }
        return UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(getOrNull, i));
    }

    /* JADX INFO: renamed from: indexOf-uWY9BYg, reason: not valid java name */
    private static final int m6252indexOfuWY9BYg(int[] indexOf, int i) {
        Intrinsics.checkNotNullParameter(indexOf, "$this$indexOf");
        return ArraysKt___ArraysKt.indexOf(indexOf, i);
    }

    /* JADX INFO: renamed from: indexOf-3uqUaXg, reason: not valid java name */
    private static final int m6249indexOf3uqUaXg(long[] indexOf, long j) {
        Intrinsics.checkNotNullParameter(indexOf, "$this$indexOf");
        return ArraysKt___ArraysKt.indexOf(indexOf, j);
    }

    /* JADX INFO: renamed from: indexOf-gMuBH34, reason: not valid java name */
    private static final int m6251indexOfgMuBH34(byte[] indexOf, byte b) {
        Intrinsics.checkNotNullParameter(indexOf, "$this$indexOf");
        return ArraysKt___ArraysKt.indexOf(indexOf, b);
    }

    /* JADX INFO: renamed from: indexOf-XzdR7RA, reason: not valid java name */
    private static final int m6250indexOfXzdR7RA(short[] indexOf, short s) {
        Intrinsics.checkNotNullParameter(indexOf, "$this$indexOf");
        return ArraysKt___ArraysKt.indexOf(indexOf, s);
    }

    /* JADX INFO: renamed from: last--ajY-9A, reason: not valid java name */
    private static final int m6261lastajY9A(int[] last) {
        Intrinsics.checkNotNullParameter(last, "$this$last");
        return UInt.m5567constructorimpl(ArraysKt___ArraysKt.last(last));
    }

    /* JADX INFO: renamed from: last-QwZRm1k, reason: not valid java name */
    private static final long m6265lastQwZRm1k(long[] last) {
        Intrinsics.checkNotNullParameter(last, "$this$last");
        return ULong.m5646constructorimpl(ArraysKt___ArraysKt.last(last));
    }

    /* JADX INFO: renamed from: last-GBYM_sE, reason: not valid java name */
    private static final byte m6262lastGBYM_sE(byte[] last) {
        Intrinsics.checkNotNullParameter(last, "$this$last");
        return UByte.m5490constructorimpl(ArraysKt___ArraysKt.last(last));
    }

    /* JADX INFO: renamed from: last-rL5Bavg, reason: not valid java name */
    private static final short m6267lastrL5Bavg(short[] last) {
        Intrinsics.checkNotNullParameter(last, "$this$last");
        return UShort.m5753constructorimpl(ArraysKt___ArraysKt.last(last));
    }

    /* JADX INFO: renamed from: last-jgv0xPQ, reason: not valid java name */
    private static final int m6266lastjgv0xPQ(int[] last, Function1<? super UInt, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(last, "$this$last");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iM5628getSizeimpl = UIntArray.m5628getSizeimpl(last) - 1;
        if (iM5628getSizeimpl >= 0) {
            while (true) {
                int i = iM5628getSizeimpl - 1;
                int iM5627getpVg5ArA = UIntArray.m5627getpVg5ArA(last, iM5628getSizeimpl);
                if (predicate.invoke(UInt.m5561boximpl(iM5627getpVg5ArA)).booleanValue()) {
                    return iM5627getpVg5ArA;
                }
                if (i >= 0) {
                    iM5628getSizeimpl = i;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    /* JADX INFO: renamed from: last-MShoTSo, reason: not valid java name */
    private static final long m6264lastMShoTSo(long[] last, Function1<? super ULong, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(last, "$this$last");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iM5707getSizeimpl = ULongArray.m5707getSizeimpl(last) - 1;
        if (iM5707getSizeimpl >= 0) {
            while (true) {
                int i = iM5707getSizeimpl - 1;
                long jM5706getsVKNKU = ULongArray.m5706getsVKNKU(last, iM5707getSizeimpl);
                if (predicate.invoke(ULong.m5640boximpl(jM5706getsVKNKU)).booleanValue()) {
                    return jM5706getsVKNKU;
                }
                if (i >= 0) {
                    iM5707getSizeimpl = i;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    /* JADX INFO: renamed from: last-JOV_ifY, reason: not valid java name */
    private static final byte m6263lastJOV_ifY(byte[] last, Function1<? super UByte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(last, "$this$last");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iM5549getSizeimpl = UByteArray.m5549getSizeimpl(last) - 1;
        if (iM5549getSizeimpl >= 0) {
            while (true) {
                int i = iM5549getSizeimpl - 1;
                byte bM5548getw2LRezQ = UByteArray.m5548getw2LRezQ(last, iM5549getSizeimpl);
                if (predicate.invoke(UByte.m5484boximpl(bM5548getw2LRezQ)).booleanValue()) {
                    return bM5548getw2LRezQ;
                }
                if (i >= 0) {
                    iM5549getSizeimpl = i;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    /* JADX INFO: renamed from: last-xTcfx_M, reason: not valid java name */
    private static final short m6268lastxTcfx_M(short[] last, Function1<? super UShort, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(last, "$this$last");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iM5812getSizeimpl = UShortArray.m5812getSizeimpl(last) - 1;
        if (iM5812getSizeimpl >= 0) {
            while (true) {
                int i = iM5812getSizeimpl - 1;
                short sM5811getMh2AYeg = UShortArray.m5811getMh2AYeg(last, iM5812getSizeimpl);
                if (predicate.invoke(UShort.m5747boximpl(sM5811getMh2AYeg)).booleanValue()) {
                    return sM5811getMh2AYeg;
                }
                if (i >= 0) {
                    iM5812getSizeimpl = i;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    /* JADX INFO: renamed from: lastIndexOf-uWY9BYg, reason: not valid java name */
    private static final int m6272lastIndexOfuWY9BYg(int[] lastIndexOf, int i) {
        Intrinsics.checkNotNullParameter(lastIndexOf, "$this$lastIndexOf");
        return ArraysKt___ArraysKt.lastIndexOf(lastIndexOf, i);
    }

    /* JADX INFO: renamed from: lastIndexOf-3uqUaXg, reason: not valid java name */
    private static final int m6269lastIndexOf3uqUaXg(long[] lastIndexOf, long j) {
        Intrinsics.checkNotNullParameter(lastIndexOf, "$this$lastIndexOf");
        return ArraysKt___ArraysKt.lastIndexOf(lastIndexOf, j);
    }

    /* JADX INFO: renamed from: lastIndexOf-gMuBH34, reason: not valid java name */
    private static final int m6271lastIndexOfgMuBH34(byte[] lastIndexOf, byte b) {
        Intrinsics.checkNotNullParameter(lastIndexOf, "$this$lastIndexOf");
        return ArraysKt___ArraysKt.lastIndexOf(lastIndexOf, b);
    }

    /* JADX INFO: renamed from: lastIndexOf-XzdR7RA, reason: not valid java name */
    private static final int m6270lastIndexOfXzdR7RA(short[] lastIndexOf, short s) {
        Intrinsics.checkNotNullParameter(lastIndexOf, "$this$lastIndexOf");
        return ArraysKt___ArraysKt.lastIndexOf(lastIndexOf, s);
    }

    /* JADX INFO: renamed from: lastOrNull--ajY-9A, reason: not valid java name */
    public static final UInt m6273lastOrNullajY9A(@NotNull int[] lastOrNull) {
        Intrinsics.checkNotNullParameter(lastOrNull, "$this$lastOrNull");
        if (UIntArray.m5630isEmptyimpl(lastOrNull)) {
            return null;
        }
        return UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(lastOrNull, UIntArray.m5628getSizeimpl(lastOrNull) - 1));
    }

    /* JADX INFO: renamed from: lastOrNull-QwZRm1k, reason: not valid java name */
    public static final ULong m6277lastOrNullQwZRm1k(@NotNull long[] lastOrNull) {
        Intrinsics.checkNotNullParameter(lastOrNull, "$this$lastOrNull");
        if (ULongArray.m5709isEmptyimpl(lastOrNull)) {
            return null;
        }
        return ULong.m5640boximpl(ULongArray.m5706getsVKNKU(lastOrNull, ULongArray.m5707getSizeimpl(lastOrNull) - 1));
    }

    /* JADX INFO: renamed from: lastOrNull-GBYM_sE, reason: not valid java name */
    public static final UByte m6274lastOrNullGBYM_sE(@NotNull byte[] lastOrNull) {
        Intrinsics.checkNotNullParameter(lastOrNull, "$this$lastOrNull");
        if (UByteArray.m5551isEmptyimpl(lastOrNull)) {
            return null;
        }
        return UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(lastOrNull, UByteArray.m5549getSizeimpl(lastOrNull) - 1));
    }

    /* JADX INFO: renamed from: lastOrNull-rL5Bavg, reason: not valid java name */
    public static final UShort m6279lastOrNullrL5Bavg(@NotNull short[] lastOrNull) {
        Intrinsics.checkNotNullParameter(lastOrNull, "$this$lastOrNull");
        if (UShortArray.m5814isEmptyimpl(lastOrNull)) {
            return null;
        }
        return UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(lastOrNull, UShortArray.m5812getSizeimpl(lastOrNull) - 1));
    }

    /* JADX INFO: renamed from: lastOrNull-jgv0xPQ, reason: not valid java name */
    private static final UInt m6278lastOrNulljgv0xPQ(int[] lastOrNull, Function1<? super UInt, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(lastOrNull, "$this$lastOrNull");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iM5628getSizeimpl = UIntArray.m5628getSizeimpl(lastOrNull) - 1;
        if (iM5628getSizeimpl < 0) {
            return null;
        }
        while (true) {
            int i = iM5628getSizeimpl - 1;
            int iM5627getpVg5ArA = UIntArray.m5627getpVg5ArA(lastOrNull, iM5628getSizeimpl);
            if (predicate.invoke(UInt.m5561boximpl(iM5627getpVg5ArA)).booleanValue()) {
                return UInt.m5561boximpl(iM5627getpVg5ArA);
            }
            if (i < 0) {
                return null;
            }
            iM5628getSizeimpl = i;
        }
    }

    /* JADX INFO: renamed from: lastOrNull-MShoTSo, reason: not valid java name */
    private static final ULong m6276lastOrNullMShoTSo(long[] lastOrNull, Function1<? super ULong, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(lastOrNull, "$this$lastOrNull");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iM5707getSizeimpl = ULongArray.m5707getSizeimpl(lastOrNull) - 1;
        if (iM5707getSizeimpl < 0) {
            return null;
        }
        while (true) {
            int i = iM5707getSizeimpl - 1;
            long jM5706getsVKNKU = ULongArray.m5706getsVKNKU(lastOrNull, iM5707getSizeimpl);
            if (predicate.invoke(ULong.m5640boximpl(jM5706getsVKNKU)).booleanValue()) {
                return ULong.m5640boximpl(jM5706getsVKNKU);
            }
            if (i < 0) {
                return null;
            }
            iM5707getSizeimpl = i;
        }
    }

    /* JADX INFO: renamed from: lastOrNull-JOV_ifY, reason: not valid java name */
    private static final UByte m6275lastOrNullJOV_ifY(byte[] lastOrNull, Function1<? super UByte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(lastOrNull, "$this$lastOrNull");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iM5549getSizeimpl = UByteArray.m5549getSizeimpl(lastOrNull) - 1;
        if (iM5549getSizeimpl < 0) {
            return null;
        }
        while (true) {
            int i = iM5549getSizeimpl - 1;
            byte bM5548getw2LRezQ = UByteArray.m5548getw2LRezQ(lastOrNull, iM5549getSizeimpl);
            if (predicate.invoke(UByte.m5484boximpl(bM5548getw2LRezQ)).booleanValue()) {
                return UByte.m5484boximpl(bM5548getw2LRezQ);
            }
            if (i < 0) {
                return null;
            }
            iM5549getSizeimpl = i;
        }
    }

    /* JADX INFO: renamed from: lastOrNull-xTcfx_M, reason: not valid java name */
    private static final UShort m6280lastOrNullxTcfx_M(short[] lastOrNull, Function1<? super UShort, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(lastOrNull, "$this$lastOrNull");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iM5812getSizeimpl = UShortArray.m5812getSizeimpl(lastOrNull) - 1;
        if (iM5812getSizeimpl < 0) {
            return null;
        }
        while (true) {
            int i = iM5812getSizeimpl - 1;
            short sM5811getMh2AYeg = UShortArray.m5811getMh2AYeg(lastOrNull, iM5812getSizeimpl);
            if (predicate.invoke(UShort.m5747boximpl(sM5811getMh2AYeg)).booleanValue()) {
                return UShort.m5747boximpl(sM5811getMh2AYeg);
            }
            if (i < 0) {
                return null;
            }
            iM5812getSizeimpl = i;
        }
    }

    /* JADX INFO: renamed from: random--ajY-9A, reason: not valid java name */
    private static final int m6437randomajY9A(int[] random) {
        Intrinsics.checkNotNullParameter(random, "$this$random");
        return m6438random2D5oskM(random, Random.Default);
    }

    /* JADX INFO: renamed from: random-QwZRm1k, reason: not valid java name */
    private static final long m6441randomQwZRm1k(long[] random) {
        Intrinsics.checkNotNullParameter(random, "$this$random");
        return m6440randomJzugnMA(random, Random.Default);
    }

    /* JADX INFO: renamed from: random-GBYM_sE, reason: not valid java name */
    private static final byte m6439randomGBYM_sE(byte[] random) {
        Intrinsics.checkNotNullParameter(random, "$this$random");
        return m6442randomoSF2wD8(random, Random.Default);
    }

    /* JADX INFO: renamed from: random-rL5Bavg, reason: not valid java name */
    private static final short m6443randomrL5Bavg(short[] random) {
        Intrinsics.checkNotNullParameter(random, "$this$random");
        return m6444randoms5X_as8(random, Random.Default);
    }

    /* JADX INFO: renamed from: random-2D5oskM, reason: not valid java name */
    public static final int m6438random2D5oskM(@NotNull int[] random, @NotNull Random random2) {
        Intrinsics.checkNotNullParameter(random, "$this$random");
        Intrinsics.checkNotNullParameter(random2, "random");
        if (UIntArray.m5630isEmptyimpl(random)) {
            throw new NoSuchElementException("Array is empty.");
        }
        return UIntArray.m5627getpVg5ArA(random, random2.nextInt(UIntArray.m5628getSizeimpl(random)));
    }

    /* JADX INFO: renamed from: random-JzugnMA, reason: not valid java name */
    public static final long m6440randomJzugnMA(@NotNull long[] random, @NotNull Random random2) {
        Intrinsics.checkNotNullParameter(random, "$this$random");
        Intrinsics.checkNotNullParameter(random2, "random");
        if (ULongArray.m5709isEmptyimpl(random)) {
            throw new NoSuchElementException("Array is empty.");
        }
        return ULongArray.m5706getsVKNKU(random, random2.nextInt(ULongArray.m5707getSizeimpl(random)));
    }

    /* JADX INFO: renamed from: random-oSF2wD8, reason: not valid java name */
    public static final byte m6442randomoSF2wD8(@NotNull byte[] random, @NotNull Random random2) {
        Intrinsics.checkNotNullParameter(random, "$this$random");
        Intrinsics.checkNotNullParameter(random2, "random");
        if (UByteArray.m5551isEmptyimpl(random)) {
            throw new NoSuchElementException("Array is empty.");
        }
        return UByteArray.m5548getw2LRezQ(random, random2.nextInt(UByteArray.m5549getSizeimpl(random)));
    }

    /* JADX INFO: renamed from: random-s5X_as8, reason: not valid java name */
    public static final short m6444randoms5X_as8(@NotNull short[] random, @NotNull Random random2) {
        Intrinsics.checkNotNullParameter(random, "$this$random");
        Intrinsics.checkNotNullParameter(random2, "random");
        if (UShortArray.m5814isEmptyimpl(random)) {
            throw new NoSuchElementException("Array is empty.");
        }
        return UShortArray.m5811getMh2AYeg(random, random2.nextInt(UShortArray.m5812getSizeimpl(random)));
    }

    /* JADX INFO: renamed from: randomOrNull--ajY-9A, reason: not valid java name */
    private static final UInt m6445randomOrNullajY9A(int[] randomOrNull) {
        Intrinsics.checkNotNullParameter(randomOrNull, "$this$randomOrNull");
        return m6446randomOrNull2D5oskM(randomOrNull, Random.Default);
    }

    /* JADX INFO: renamed from: randomOrNull-QwZRm1k, reason: not valid java name */
    private static final ULong m6449randomOrNullQwZRm1k(long[] randomOrNull) {
        Intrinsics.checkNotNullParameter(randomOrNull, "$this$randomOrNull");
        return m6448randomOrNullJzugnMA(randomOrNull, Random.Default);
    }

    /* JADX INFO: renamed from: randomOrNull-GBYM_sE, reason: not valid java name */
    private static final UByte m6447randomOrNullGBYM_sE(byte[] randomOrNull) {
        Intrinsics.checkNotNullParameter(randomOrNull, "$this$randomOrNull");
        return m6450randomOrNulloSF2wD8(randomOrNull, Random.Default);
    }

    /* JADX INFO: renamed from: randomOrNull-rL5Bavg, reason: not valid java name */
    private static final UShort m6451randomOrNullrL5Bavg(short[] randomOrNull) {
        Intrinsics.checkNotNullParameter(randomOrNull, "$this$randomOrNull");
        return m6452randomOrNulls5X_as8(randomOrNull, Random.Default);
    }

    /* JADX INFO: renamed from: randomOrNull-2D5oskM, reason: not valid java name */
    public static final UInt m6446randomOrNull2D5oskM(@NotNull int[] randomOrNull, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(randomOrNull, "$this$randomOrNull");
        Intrinsics.checkNotNullParameter(random, "random");
        if (UIntArray.m5630isEmptyimpl(randomOrNull)) {
            return null;
        }
        return UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(randomOrNull, random.nextInt(UIntArray.m5628getSizeimpl(randomOrNull))));
    }

    /* JADX INFO: renamed from: randomOrNull-JzugnMA, reason: not valid java name */
    public static final ULong m6448randomOrNullJzugnMA(@NotNull long[] randomOrNull, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(randomOrNull, "$this$randomOrNull");
        Intrinsics.checkNotNullParameter(random, "random");
        if (ULongArray.m5709isEmptyimpl(randomOrNull)) {
            return null;
        }
        return ULong.m5640boximpl(ULongArray.m5706getsVKNKU(randomOrNull, random.nextInt(ULongArray.m5707getSizeimpl(randomOrNull))));
    }

    /* JADX INFO: renamed from: randomOrNull-oSF2wD8, reason: not valid java name */
    public static final UByte m6450randomOrNulloSF2wD8(@NotNull byte[] randomOrNull, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(randomOrNull, "$this$randomOrNull");
        Intrinsics.checkNotNullParameter(random, "random");
        if (UByteArray.m5551isEmptyimpl(randomOrNull)) {
            return null;
        }
        return UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(randomOrNull, random.nextInt(UByteArray.m5549getSizeimpl(randomOrNull))));
    }

    /* JADX INFO: renamed from: randomOrNull-s5X_as8, reason: not valid java name */
    public static final UShort m6452randomOrNulls5X_as8(@NotNull short[] randomOrNull, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(randomOrNull, "$this$randomOrNull");
        Intrinsics.checkNotNullParameter(random, "random");
        if (UShortArray.m5814isEmptyimpl(randomOrNull)) {
            return null;
        }
        return UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(randomOrNull, random.nextInt(UShortArray.m5812getSizeimpl(randomOrNull))));
    }

    /* JADX INFO: renamed from: single--ajY-9A, reason: not valid java name */
    private static final int m6533singleajY9A(int[] single) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        return UInt.m5567constructorimpl(ArraysKt___ArraysKt.single(single));
    }

    /* JADX INFO: renamed from: single-QwZRm1k, reason: not valid java name */
    private static final long m6537singleQwZRm1k(long[] single) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        return ULong.m5646constructorimpl(ArraysKt___ArraysKt.single(single));
    }

    /* JADX INFO: renamed from: single-GBYM_sE, reason: not valid java name */
    private static final byte m6534singleGBYM_sE(byte[] single) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        return UByte.m5490constructorimpl(ArraysKt___ArraysKt.single(single));
    }

    /* JADX INFO: renamed from: single-rL5Bavg, reason: not valid java name */
    private static final short m6539singlerL5Bavg(short[] single) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        return UShort.m5753constructorimpl(ArraysKt___ArraysKt.single(single));
    }

    /* JADX INFO: renamed from: single-jgv0xPQ, reason: not valid java name */
    private static final int m6538singlejgv0xPQ(int[] single, Function1<? super UInt, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iM5628getSizeimpl = UIntArray.m5628getSizeimpl(single);
        UInt uIntM5561boximpl = null;
        boolean z = false;
        for (int i = 0; i < iM5628getSizeimpl; i++) {
            int iM5627getpVg5ArA = UIntArray.m5627getpVg5ArA(single, i);
            if (predicate.invoke(UInt.m5561boximpl(iM5627getpVg5ArA)).booleanValue()) {
                if (z) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                uIntM5561boximpl = UInt.m5561boximpl(iM5627getpVg5ArA);
                z = true;
            }
        }
        if (!z) {
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }
        return uIntM5561boximpl.m5619unboximpl();
    }

    /* JADX INFO: renamed from: single-MShoTSo, reason: not valid java name */
    private static final long m6536singleMShoTSo(long[] single, Function1<? super ULong, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iM5707getSizeimpl = ULongArray.m5707getSizeimpl(single);
        ULong uLongM5640boximpl = null;
        boolean z = false;
        for (int i = 0; i < iM5707getSizeimpl; i++) {
            long jM5706getsVKNKU = ULongArray.m5706getsVKNKU(single, i);
            if (predicate.invoke(ULong.m5640boximpl(jM5706getsVKNKU)).booleanValue()) {
                if (z) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                uLongM5640boximpl = ULong.m5640boximpl(jM5706getsVKNKU);
                z = true;
            }
        }
        if (!z) {
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }
        return uLongM5640boximpl.m5698unboximpl();
    }

    /* JADX INFO: renamed from: single-JOV_ifY, reason: not valid java name */
    private static final byte m6535singleJOV_ifY(byte[] single, Function1<? super UByte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iM5549getSizeimpl = UByteArray.m5549getSizeimpl(single);
        UByte uByteM5484boximpl = null;
        boolean z = false;
        for (int i = 0; i < iM5549getSizeimpl; i++) {
            byte bM5548getw2LRezQ = UByteArray.m5548getw2LRezQ(single, i);
            if (predicate.invoke(UByte.m5484boximpl(bM5548getw2LRezQ)).booleanValue()) {
                if (z) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                uByteM5484boximpl = UByte.m5484boximpl(bM5548getw2LRezQ);
                z = true;
            }
        }
        if (!z) {
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }
        return uByteM5484boximpl.m5540unboximpl();
    }

    /* JADX INFO: renamed from: single-xTcfx_M, reason: not valid java name */
    private static final short m6540singlexTcfx_M(short[] single, Function1<? super UShort, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iM5812getSizeimpl = UShortArray.m5812getSizeimpl(single);
        UShort uShortM5747boximpl = null;
        boolean z = false;
        for (int i = 0; i < iM5812getSizeimpl; i++) {
            short sM5811getMh2AYeg = UShortArray.m5811getMh2AYeg(single, i);
            if (predicate.invoke(UShort.m5747boximpl(sM5811getMh2AYeg)).booleanValue()) {
                if (z) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                uShortM5747boximpl = UShort.m5747boximpl(sM5811getMh2AYeg);
                z = true;
            }
        }
        if (!z) {
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }
        return uShortM5747boximpl.m5803unboximpl();
    }

    /* JADX INFO: renamed from: singleOrNull--ajY-9A, reason: not valid java name */
    public static final UInt m6541singleOrNullajY9A(@NotNull int[] singleOrNull) {
        Intrinsics.checkNotNullParameter(singleOrNull, "$this$singleOrNull");
        if (UIntArray.m5628getSizeimpl(singleOrNull) == 1) {
            return UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(singleOrNull, 0));
        }
        return null;
    }

    /* JADX INFO: renamed from: singleOrNull-QwZRm1k, reason: not valid java name */
    public static final ULong m6545singleOrNullQwZRm1k(@NotNull long[] singleOrNull) {
        Intrinsics.checkNotNullParameter(singleOrNull, "$this$singleOrNull");
        if (ULongArray.m5707getSizeimpl(singleOrNull) == 1) {
            return ULong.m5640boximpl(ULongArray.m5706getsVKNKU(singleOrNull, 0));
        }
        return null;
    }

    /* JADX INFO: renamed from: singleOrNull-GBYM_sE, reason: not valid java name */
    public static final UByte m6542singleOrNullGBYM_sE(@NotNull byte[] singleOrNull) {
        Intrinsics.checkNotNullParameter(singleOrNull, "$this$singleOrNull");
        if (UByteArray.m5549getSizeimpl(singleOrNull) == 1) {
            return UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(singleOrNull, 0));
        }
        return null;
    }

    /* JADX INFO: renamed from: singleOrNull-rL5Bavg, reason: not valid java name */
    public static final UShort m6547singleOrNullrL5Bavg(@NotNull short[] singleOrNull) {
        Intrinsics.checkNotNullParameter(singleOrNull, "$this$singleOrNull");
        if (UShortArray.m5812getSizeimpl(singleOrNull) == 1) {
            return UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(singleOrNull, 0));
        }
        return null;
    }

    /* JADX INFO: renamed from: singleOrNull-jgv0xPQ, reason: not valid java name */
    private static final UInt m6546singleOrNulljgv0xPQ(int[] singleOrNull, Function1<? super UInt, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(singleOrNull, "$this$singleOrNull");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iM5628getSizeimpl = UIntArray.m5628getSizeimpl(singleOrNull);
        boolean z = false;
        UInt uIntM5561boximpl = null;
        for (int i = 0; i < iM5628getSizeimpl; i++) {
            int iM5627getpVg5ArA = UIntArray.m5627getpVg5ArA(singleOrNull, i);
            if (predicate.invoke(UInt.m5561boximpl(iM5627getpVg5ArA)).booleanValue()) {
                if (z) {
                    return null;
                }
                uIntM5561boximpl = UInt.m5561boximpl(iM5627getpVg5ArA);
                z = true;
            }
        }
        if (z) {
            return uIntM5561boximpl;
        }
        return null;
    }

    /* JADX INFO: renamed from: singleOrNull-MShoTSo, reason: not valid java name */
    private static final ULong m6544singleOrNullMShoTSo(long[] singleOrNull, Function1<? super ULong, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(singleOrNull, "$this$singleOrNull");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iM5707getSizeimpl = ULongArray.m5707getSizeimpl(singleOrNull);
        boolean z = false;
        ULong uLongM5640boximpl = null;
        for (int i = 0; i < iM5707getSizeimpl; i++) {
            long jM5706getsVKNKU = ULongArray.m5706getsVKNKU(singleOrNull, i);
            if (predicate.invoke(ULong.m5640boximpl(jM5706getsVKNKU)).booleanValue()) {
                if (z) {
                    return null;
                }
                uLongM5640boximpl = ULong.m5640boximpl(jM5706getsVKNKU);
                z = true;
            }
        }
        if (z) {
            return uLongM5640boximpl;
        }
        return null;
    }

    /* JADX INFO: renamed from: singleOrNull-JOV_ifY, reason: not valid java name */
    private static final UByte m6543singleOrNullJOV_ifY(byte[] singleOrNull, Function1<? super UByte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(singleOrNull, "$this$singleOrNull");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iM5549getSizeimpl = UByteArray.m5549getSizeimpl(singleOrNull);
        boolean z = false;
        UByte uByteM5484boximpl = null;
        for (int i = 0; i < iM5549getSizeimpl; i++) {
            byte bM5548getw2LRezQ = UByteArray.m5548getw2LRezQ(singleOrNull, i);
            if (predicate.invoke(UByte.m5484boximpl(bM5548getw2LRezQ)).booleanValue()) {
                if (z) {
                    return null;
                }
                uByteM5484boximpl = UByte.m5484boximpl(bM5548getw2LRezQ);
                z = true;
            }
        }
        if (z) {
            return uByteM5484boximpl;
        }
        return null;
    }

    /* JADX INFO: renamed from: singleOrNull-xTcfx_M, reason: not valid java name */
    private static final UShort m6548singleOrNullxTcfx_M(short[] singleOrNull, Function1<? super UShort, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(singleOrNull, "$this$singleOrNull");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iM5812getSizeimpl = UShortArray.m5812getSizeimpl(singleOrNull);
        boolean z = false;
        UShort uShortM5747boximpl = null;
        for (int i = 0; i < iM5812getSizeimpl; i++) {
            short sM5811getMh2AYeg = UShortArray.m5811getMh2AYeg(singleOrNull, i);
            if (predicate.invoke(UShort.m5747boximpl(sM5811getMh2AYeg)).booleanValue()) {
                if (z) {
                    return null;
                }
                uShortM5747boximpl = UShort.m5747boximpl(sM5811getMh2AYeg);
                z = true;
            }
        }
        if (z) {
            return uShortM5747boximpl;
        }
        return null;
    }

    /* JADX INFO: renamed from: drop-qFRl0hI, reason: not valid java name */
    public static final List<UInt> m6091dropqFRl0hI(@NotNull int[] drop, int i) {
        Intrinsics.checkNotNullParameter(drop, "$this$drop");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        return m6619takeLastqFRl0hI(drop, RangesKt___RangesKt.coerceAtLeast(UIntArray.m5628getSizeimpl(drop) - i, 0));
    }

    /* JADX INFO: renamed from: drop-r7IrZao, reason: not valid java name */
    public static final List<ULong> m6092dropr7IrZao(@NotNull long[] drop, int i) {
        Intrinsics.checkNotNullParameter(drop, "$this$drop");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        return m6620takeLastr7IrZao(drop, RangesKt___RangesKt.coerceAtLeast(ULongArray.m5707getSizeimpl(drop) - i, 0));
    }

    /* JADX INFO: renamed from: drop-PpDY95g, reason: not valid java name */
    public static final List<UByte> m6089dropPpDY95g(@NotNull byte[] drop, int i) {
        Intrinsics.checkNotNullParameter(drop, "$this$drop");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        return m6617takeLastPpDY95g(drop, RangesKt___RangesKt.coerceAtLeast(UByteArray.m5549getSizeimpl(drop) - i, 0));
    }

    /* JADX INFO: renamed from: drop-nggk6HY, reason: not valid java name */
    public static final List<UShort> m6090dropnggk6HY(@NotNull short[] drop, int i) {
        Intrinsics.checkNotNullParameter(drop, "$this$drop");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        return m6618takeLastnggk6HY(drop, RangesKt___RangesKt.coerceAtLeast(UShortArray.m5812getSizeimpl(drop) - i, 0));
    }

    /* JADX INFO: renamed from: dropLast-qFRl0hI, reason: not valid java name */
    public static final List<UInt> m6095dropLastqFRl0hI(@NotNull int[] dropLast, int i) {
        Intrinsics.checkNotNullParameter(dropLast, "$this$dropLast");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        return m6615takeqFRl0hI(dropLast, RangesKt___RangesKt.coerceAtLeast(UIntArray.m5628getSizeimpl(dropLast) - i, 0));
    }

    /* JADX INFO: renamed from: dropLast-r7IrZao, reason: not valid java name */
    public static final List<ULong> m6096dropLastr7IrZao(@NotNull long[] dropLast, int i) {
        Intrinsics.checkNotNullParameter(dropLast, "$this$dropLast");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        return m6616taker7IrZao(dropLast, RangesKt___RangesKt.coerceAtLeast(ULongArray.m5707getSizeimpl(dropLast) - i, 0));
    }

    /* JADX INFO: renamed from: dropLast-PpDY95g, reason: not valid java name */
    public static final List<UByte> m6093dropLastPpDY95g(@NotNull byte[] dropLast, int i) {
        Intrinsics.checkNotNullParameter(dropLast, "$this$dropLast");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        return m6613takePpDY95g(dropLast, RangesKt___RangesKt.coerceAtLeast(UByteArray.m5549getSizeimpl(dropLast) - i, 0));
    }

    /* JADX INFO: renamed from: dropLast-nggk6HY, reason: not valid java name */
    public static final List<UShort> m6094dropLastnggk6HY(@NotNull short[] dropLast, int i) {
        Intrinsics.checkNotNullParameter(dropLast, "$this$dropLast");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        return m6614takenggk6HY(dropLast, RangesKt___RangesKt.coerceAtLeast(UShortArray.m5812getSizeimpl(dropLast) - i, 0));
    }

    /* JADX INFO: renamed from: dropWhile-jgv0xPQ, reason: not valid java name */
    private static final List<UInt> m6103dropWhilejgv0xPQ(int[] dropWhile, Function1<? super UInt, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dropWhile, "$this$dropWhile");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iM5628getSizeimpl = UIntArray.m5628getSizeimpl(dropWhile);
        boolean z = false;
        for (int i = 0; i < iM5628getSizeimpl; i++) {
            int iM5627getpVg5ArA = UIntArray.m5627getpVg5ArA(dropWhile, i);
            if (z) {
                arrayList.add(UInt.m5561boximpl(iM5627getpVg5ArA));
            } else if (!predicate.invoke(UInt.m5561boximpl(iM5627getpVg5ArA)).booleanValue()) {
                arrayList.add(UInt.m5561boximpl(iM5627getpVg5ArA));
                z = true;
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: dropWhile-MShoTSo, reason: not valid java name */
    private static final List<ULong> m6102dropWhileMShoTSo(long[] dropWhile, Function1<? super ULong, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dropWhile, "$this$dropWhile");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iM5707getSizeimpl = ULongArray.m5707getSizeimpl(dropWhile);
        boolean z = false;
        for (int i = 0; i < iM5707getSizeimpl; i++) {
            long jM5706getsVKNKU = ULongArray.m5706getsVKNKU(dropWhile, i);
            if (z) {
                arrayList.add(ULong.m5640boximpl(jM5706getsVKNKU));
            } else if (!predicate.invoke(ULong.m5640boximpl(jM5706getsVKNKU)).booleanValue()) {
                arrayList.add(ULong.m5640boximpl(jM5706getsVKNKU));
                z = true;
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: dropWhile-JOV_ifY, reason: not valid java name */
    private static final List<UByte> m6101dropWhileJOV_ifY(byte[] dropWhile, Function1<? super UByte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dropWhile, "$this$dropWhile");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iM5549getSizeimpl = UByteArray.m5549getSizeimpl(dropWhile);
        boolean z = false;
        for (int i = 0; i < iM5549getSizeimpl; i++) {
            byte bM5548getw2LRezQ = UByteArray.m5548getw2LRezQ(dropWhile, i);
            if (z) {
                arrayList.add(UByte.m5484boximpl(bM5548getw2LRezQ));
            } else if (!predicate.invoke(UByte.m5484boximpl(bM5548getw2LRezQ)).booleanValue()) {
                arrayList.add(UByte.m5484boximpl(bM5548getw2LRezQ));
                z = true;
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: dropWhile-xTcfx_M, reason: not valid java name */
    private static final List<UShort> m6104dropWhilexTcfx_M(short[] dropWhile, Function1<? super UShort, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dropWhile, "$this$dropWhile");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iM5812getSizeimpl = UShortArray.m5812getSizeimpl(dropWhile);
        boolean z = false;
        for (int i = 0; i < iM5812getSizeimpl; i++) {
            short sM5811getMh2AYeg = UShortArray.m5811getMh2AYeg(dropWhile, i);
            if (z) {
                arrayList.add(UShort.m5747boximpl(sM5811getMh2AYeg));
            } else if (!predicate.invoke(UShort.m5747boximpl(sM5811getMh2AYeg)).booleanValue()) {
                arrayList.add(UShort.m5747boximpl(sM5811getMh2AYeg));
                z = true;
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: filter-jgv0xPQ, reason: not valid java name */
    private static final List<UInt> m6123filterjgv0xPQ(int[] filter, Function1<? super UInt, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(filter, "$this$filter");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iM5628getSizeimpl = UIntArray.m5628getSizeimpl(filter);
        for (int i = 0; i < iM5628getSizeimpl; i++) {
            int iM5627getpVg5ArA = UIntArray.m5627getpVg5ArA(filter, i);
            if (predicate.invoke(UInt.m5561boximpl(iM5627getpVg5ArA)).booleanValue()) {
                arrayList.add(UInt.m5561boximpl(iM5627getpVg5ArA));
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: filter-MShoTSo, reason: not valid java name */
    private static final List<ULong> m6122filterMShoTSo(long[] filter, Function1<? super ULong, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(filter, "$this$filter");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iM5707getSizeimpl = ULongArray.m5707getSizeimpl(filter);
        for (int i = 0; i < iM5707getSizeimpl; i++) {
            long jM5706getsVKNKU = ULongArray.m5706getsVKNKU(filter, i);
            if (predicate.invoke(ULong.m5640boximpl(jM5706getsVKNKU)).booleanValue()) {
                arrayList.add(ULong.m5640boximpl(jM5706getsVKNKU));
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: filter-JOV_ifY, reason: not valid java name */
    private static final List<UByte> m6121filterJOV_ifY(byte[] filter, Function1<? super UByte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(filter, "$this$filter");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iM5549getSizeimpl = UByteArray.m5549getSizeimpl(filter);
        for (int i = 0; i < iM5549getSizeimpl; i++) {
            byte bM5548getw2LRezQ = UByteArray.m5548getw2LRezQ(filter, i);
            if (predicate.invoke(UByte.m5484boximpl(bM5548getw2LRezQ)).booleanValue()) {
                arrayList.add(UByte.m5484boximpl(bM5548getw2LRezQ));
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: filter-xTcfx_M, reason: not valid java name */
    private static final List<UShort> m6124filterxTcfx_M(short[] filter, Function1<? super UShort, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(filter, "$this$filter");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iM5812getSizeimpl = UShortArray.m5812getSizeimpl(filter);
        for (int i = 0; i < iM5812getSizeimpl; i++) {
            short sM5811getMh2AYeg = UShortArray.m5811getMh2AYeg(filter, i);
            if (predicate.invoke(UShort.m5747boximpl(sM5811getMh2AYeg)).booleanValue()) {
                arrayList.add(UShort.m5747boximpl(sM5811getMh2AYeg));
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: filterIndexed-WyvcNBI, reason: not valid java name */
    private static final List<UInt> m6126filterIndexedWyvcNBI(int[] filterIndexed, Function2<? super Integer, ? super UInt, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(filterIndexed, "$this$filterIndexed");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iM5628getSizeimpl = UIntArray.m5628getSizeimpl(filterIndexed);
        int i = 0;
        int i2 = 0;
        while (i < iM5628getSizeimpl) {
            int iM5627getpVg5ArA = UIntArray.m5627getpVg5ArA(filterIndexed, i);
            if (predicate.invoke(Integer.valueOf(i2), UInt.m5561boximpl(iM5627getpVg5ArA)).booleanValue()) {
                arrayList.add(UInt.m5561boximpl(iM5627getpVg5ArA));
            }
            i++;
            i2++;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: filterIndexed-s8dVfGU, reason: not valid java name */
    private static final List<ULong> m6127filterIndexeds8dVfGU(long[] filterIndexed, Function2<? super Integer, ? super ULong, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(filterIndexed, "$this$filterIndexed");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iM5707getSizeimpl = ULongArray.m5707getSizeimpl(filterIndexed);
        int i = 0;
        int i2 = 0;
        while (i < iM5707getSizeimpl) {
            long jM5706getsVKNKU = ULongArray.m5706getsVKNKU(filterIndexed, i);
            if (predicate.invoke(Integer.valueOf(i2), ULong.m5640boximpl(jM5706getsVKNKU)).booleanValue()) {
                arrayList.add(ULong.m5640boximpl(jM5706getsVKNKU));
            }
            i++;
            i2++;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: filterIndexed-ELGow60, reason: not valid java name */
    private static final List<UByte> m6125filterIndexedELGow60(byte[] filterIndexed, Function2<? super Integer, ? super UByte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(filterIndexed, "$this$filterIndexed");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iM5549getSizeimpl = UByteArray.m5549getSizeimpl(filterIndexed);
        int i = 0;
        int i2 = 0;
        while (i < iM5549getSizeimpl) {
            byte bM5548getw2LRezQ = UByteArray.m5548getw2LRezQ(filterIndexed, i);
            if (predicate.invoke(Integer.valueOf(i2), UByte.m5484boximpl(bM5548getw2LRezQ)).booleanValue()) {
                arrayList.add(UByte.m5484boximpl(bM5548getw2LRezQ));
            }
            i++;
            i2++;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: filterIndexed-xzaTVY8, reason: not valid java name */
    private static final List<UShort> m6128filterIndexedxzaTVY8(short[] filterIndexed, Function2<? super Integer, ? super UShort, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(filterIndexed, "$this$filterIndexed");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iM5812getSizeimpl = UShortArray.m5812getSizeimpl(filterIndexed);
        int i = 0;
        int i2 = 0;
        while (i < iM5812getSizeimpl) {
            short sM5811getMh2AYeg = UShortArray.m5811getMh2AYeg(filterIndexed, i);
            if (predicate.invoke(Integer.valueOf(i2), UShort.m5747boximpl(sM5811getMh2AYeg)).booleanValue()) {
                arrayList.add(UShort.m5747boximpl(sM5811getMh2AYeg));
            }
            i++;
            i2++;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: filterIndexedTo--6EtJGI, reason: not valid java name */
    private static final <C extends Collection<? super UInt>> C m6129filterIndexedTo6EtJGI(int[] filterIndexedTo, C destination, Function2<? super Integer, ? super UInt, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(filterIndexedTo, "$this$filterIndexedTo");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iM5628getSizeimpl = UIntArray.m5628getSizeimpl(filterIndexedTo);
        int i = 0;
        int i2 = 0;
        while (i < iM5628getSizeimpl) {
            int iM5627getpVg5ArA = UIntArray.m5627getpVg5ArA(filterIndexedTo, i);
            if (predicate.invoke(Integer.valueOf(i2), UInt.m5561boximpl(iM5627getpVg5ArA)).booleanValue()) {
                destination.add(UInt.m5561boximpl(iM5627getpVg5ArA));
            }
            i++;
            i2++;
        }
        return destination;
    }

    /* JADX INFO: renamed from: filterIndexedTo-pe2Q0Dw, reason: not valid java name */
    private static final <C extends Collection<? super ULong>> C m6132filterIndexedTope2Q0Dw(long[] filterIndexedTo, C destination, Function2<? super Integer, ? super ULong, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(filterIndexedTo, "$this$filterIndexedTo");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iM5707getSizeimpl = ULongArray.m5707getSizeimpl(filterIndexedTo);
        int i = 0;
        int i2 = 0;
        while (i < iM5707getSizeimpl) {
            long jM5706getsVKNKU = ULongArray.m5706getsVKNKU(filterIndexedTo, i);
            if (predicate.invoke(Integer.valueOf(i2), ULong.m5640boximpl(jM5706getsVKNKU)).booleanValue()) {
                destination.add(ULong.m5640boximpl(jM5706getsVKNKU));
            }
            i++;
            i2++;
        }
        return destination;
    }

    /* JADX INFO: renamed from: filterIndexedTo-eNpIKz8, reason: not valid java name */
    private static final <C extends Collection<? super UByte>> C m6131filterIndexedToeNpIKz8(byte[] filterIndexedTo, C destination, Function2<? super Integer, ? super UByte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(filterIndexedTo, "$this$filterIndexedTo");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iM5549getSizeimpl = UByteArray.m5549getSizeimpl(filterIndexedTo);
        int i = 0;
        int i2 = 0;
        while (i < iM5549getSizeimpl) {
            byte bM5548getw2LRezQ = UByteArray.m5548getw2LRezQ(filterIndexedTo, i);
            if (predicate.invoke(Integer.valueOf(i2), UByte.m5484boximpl(bM5548getw2LRezQ)).booleanValue()) {
                destination.add(UByte.m5484boximpl(bM5548getw2LRezQ));
            }
            i++;
            i2++;
        }
        return destination;
    }

    /* JADX INFO: renamed from: filterIndexedTo-QqktQ3k, reason: not valid java name */
    private static final <C extends Collection<? super UShort>> C m6130filterIndexedToQqktQ3k(short[] filterIndexedTo, C destination, Function2<? super Integer, ? super UShort, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(filterIndexedTo, "$this$filterIndexedTo");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iM5812getSizeimpl = UShortArray.m5812getSizeimpl(filterIndexedTo);
        int i = 0;
        int i2 = 0;
        while (i < iM5812getSizeimpl) {
            short sM5811getMh2AYeg = UShortArray.m5811getMh2AYeg(filterIndexedTo, i);
            if (predicate.invoke(Integer.valueOf(i2), UShort.m5747boximpl(sM5811getMh2AYeg)).booleanValue()) {
                destination.add(UShort.m5747boximpl(sM5811getMh2AYeg));
            }
            i++;
            i2++;
        }
        return destination;
    }

    /* JADX INFO: renamed from: filterNot-jgv0xPQ, reason: not valid java name */
    private static final List<UInt> m6135filterNotjgv0xPQ(int[] filterNot, Function1<? super UInt, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(filterNot, "$this$filterNot");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iM5628getSizeimpl = UIntArray.m5628getSizeimpl(filterNot);
        for (int i = 0; i < iM5628getSizeimpl; i++) {
            int iM5627getpVg5ArA = UIntArray.m5627getpVg5ArA(filterNot, i);
            if (!predicate.invoke(UInt.m5561boximpl(iM5627getpVg5ArA)).booleanValue()) {
                arrayList.add(UInt.m5561boximpl(iM5627getpVg5ArA));
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: filterNot-MShoTSo, reason: not valid java name */
    private static final List<ULong> m6134filterNotMShoTSo(long[] filterNot, Function1<? super ULong, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(filterNot, "$this$filterNot");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iM5707getSizeimpl = ULongArray.m5707getSizeimpl(filterNot);
        for (int i = 0; i < iM5707getSizeimpl; i++) {
            long jM5706getsVKNKU = ULongArray.m5706getsVKNKU(filterNot, i);
            if (!predicate.invoke(ULong.m5640boximpl(jM5706getsVKNKU)).booleanValue()) {
                arrayList.add(ULong.m5640boximpl(jM5706getsVKNKU));
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: filterNot-JOV_ifY, reason: not valid java name */
    private static final List<UByte> m6133filterNotJOV_ifY(byte[] filterNot, Function1<? super UByte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(filterNot, "$this$filterNot");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iM5549getSizeimpl = UByteArray.m5549getSizeimpl(filterNot);
        for (int i = 0; i < iM5549getSizeimpl; i++) {
            byte bM5548getw2LRezQ = UByteArray.m5548getw2LRezQ(filterNot, i);
            if (!predicate.invoke(UByte.m5484boximpl(bM5548getw2LRezQ)).booleanValue()) {
                arrayList.add(UByte.m5484boximpl(bM5548getw2LRezQ));
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: filterNot-xTcfx_M, reason: not valid java name */
    private static final List<UShort> m6136filterNotxTcfx_M(short[] filterNot, Function1<? super UShort, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(filterNot, "$this$filterNot");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iM5812getSizeimpl = UShortArray.m5812getSizeimpl(filterNot);
        for (int i = 0; i < iM5812getSizeimpl; i++) {
            short sM5811getMh2AYeg = UShortArray.m5811getMh2AYeg(filterNot, i);
            if (!predicate.invoke(UShort.m5747boximpl(sM5811getMh2AYeg)).booleanValue()) {
                arrayList.add(UShort.m5747boximpl(sM5811getMh2AYeg));
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: filterNotTo-wU5IKMo, reason: not valid java name */
    private static final <C extends Collection<? super UInt>> C m6139filterNotTowU5IKMo(int[] filterNotTo, C destination, Function1<? super UInt, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(filterNotTo, "$this$filterNotTo");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iM5628getSizeimpl = UIntArray.m5628getSizeimpl(filterNotTo);
        for (int i = 0; i < iM5628getSizeimpl; i++) {
            int iM5627getpVg5ArA = UIntArray.m5627getpVg5ArA(filterNotTo, i);
            if (!predicate.invoke(UInt.m5561boximpl(iM5627getpVg5ArA)).booleanValue()) {
                destination.add(UInt.m5561boximpl(iM5627getpVg5ArA));
            }
        }
        return destination;
    }

    /* JADX INFO: renamed from: filterNotTo-HqK1JgA, reason: not valid java name */
    private static final <C extends Collection<? super ULong>> C m6137filterNotToHqK1JgA(long[] filterNotTo, C destination, Function1<? super ULong, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(filterNotTo, "$this$filterNotTo");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iM5707getSizeimpl = ULongArray.m5707getSizeimpl(filterNotTo);
        for (int i = 0; i < iM5707getSizeimpl; i++) {
            long jM5706getsVKNKU = ULongArray.m5706getsVKNKU(filterNotTo, i);
            if (!predicate.invoke(ULong.m5640boximpl(jM5706getsVKNKU)).booleanValue()) {
                destination.add(ULong.m5640boximpl(jM5706getsVKNKU));
            }
        }
        return destination;
    }

    /* JADX INFO: renamed from: filterNotTo-wzUQCXU, reason: not valid java name */
    private static final <C extends Collection<? super UByte>> C m6140filterNotTowzUQCXU(byte[] filterNotTo, C destination, Function1<? super UByte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(filterNotTo, "$this$filterNotTo");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iM5549getSizeimpl = UByteArray.m5549getSizeimpl(filterNotTo);
        for (int i = 0; i < iM5549getSizeimpl; i++) {
            byte bM5548getw2LRezQ = UByteArray.m5548getw2LRezQ(filterNotTo, i);
            if (!predicate.invoke(UByte.m5484boximpl(bM5548getw2LRezQ)).booleanValue()) {
                destination.add(UByte.m5484boximpl(bM5548getw2LRezQ));
            }
        }
        return destination;
    }

    /* JADX INFO: renamed from: filterNotTo-oEOeDjA, reason: not valid java name */
    private static final <C extends Collection<? super UShort>> C m6138filterNotTooEOeDjA(short[] filterNotTo, C destination, Function1<? super UShort, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(filterNotTo, "$this$filterNotTo");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iM5812getSizeimpl = UShortArray.m5812getSizeimpl(filterNotTo);
        for (int i = 0; i < iM5812getSizeimpl; i++) {
            short sM5811getMh2AYeg = UShortArray.m5811getMh2AYeg(filterNotTo, i);
            if (!predicate.invoke(UShort.m5747boximpl(sM5811getMh2AYeg)).booleanValue()) {
                destination.add(UShort.m5747boximpl(sM5811getMh2AYeg));
            }
        }
        return destination;
    }

    /* JADX INFO: renamed from: filterTo-wU5IKMo, reason: not valid java name */
    private static final <C extends Collection<? super UInt>> C m6143filterTowU5IKMo(int[] filterTo, C destination, Function1<? super UInt, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(filterTo, "$this$filterTo");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iM5628getSizeimpl = UIntArray.m5628getSizeimpl(filterTo);
        for (int i = 0; i < iM5628getSizeimpl; i++) {
            int iM5627getpVg5ArA = UIntArray.m5627getpVg5ArA(filterTo, i);
            if (predicate.invoke(UInt.m5561boximpl(iM5627getpVg5ArA)).booleanValue()) {
                destination.add(UInt.m5561boximpl(iM5627getpVg5ArA));
            }
        }
        return destination;
    }

    /* JADX INFO: renamed from: filterTo-HqK1JgA, reason: not valid java name */
    private static final <C extends Collection<? super ULong>> C m6141filterToHqK1JgA(long[] filterTo, C destination, Function1<? super ULong, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(filterTo, "$this$filterTo");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iM5707getSizeimpl = ULongArray.m5707getSizeimpl(filterTo);
        for (int i = 0; i < iM5707getSizeimpl; i++) {
            long jM5706getsVKNKU = ULongArray.m5706getsVKNKU(filterTo, i);
            if (predicate.invoke(ULong.m5640boximpl(jM5706getsVKNKU)).booleanValue()) {
                destination.add(ULong.m5640boximpl(jM5706getsVKNKU));
            }
        }
        return destination;
    }

    /* JADX INFO: renamed from: filterTo-wzUQCXU, reason: not valid java name */
    private static final <C extends Collection<? super UByte>> C m6144filterTowzUQCXU(byte[] filterTo, C destination, Function1<? super UByte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(filterTo, "$this$filterTo");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iM5549getSizeimpl = UByteArray.m5549getSizeimpl(filterTo);
        for (int i = 0; i < iM5549getSizeimpl; i++) {
            byte bM5548getw2LRezQ = UByteArray.m5548getw2LRezQ(filterTo, i);
            if (predicate.invoke(UByte.m5484boximpl(bM5548getw2LRezQ)).booleanValue()) {
                destination.add(UByte.m5484boximpl(bM5548getw2LRezQ));
            }
        }
        return destination;
    }

    /* JADX INFO: renamed from: filterTo-oEOeDjA, reason: not valid java name */
    private static final <C extends Collection<? super UShort>> C m6142filterTooEOeDjA(short[] filterTo, C destination, Function1<? super UShort, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(filterTo, "$this$filterTo");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iM5812getSizeimpl = UShortArray.m5812getSizeimpl(filterTo);
        for (int i = 0; i < iM5812getSizeimpl; i++) {
            short sM5811getMh2AYeg = UShortArray.m5811getMh2AYeg(filterTo, i);
            if (predicate.invoke(UShort.m5747boximpl(sM5811getMh2AYeg)).booleanValue()) {
                destination.add(UShort.m5747boximpl(sM5811getMh2AYeg));
            }
        }
        return destination;
    }

    /* JADX INFO: renamed from: slice-tAntMlw, reason: not valid java name */
    public static final List<UInt> m6556slicetAntMlw(@NotNull int[] slice, @NotNull IntRange indices) {
        Intrinsics.checkNotNullParameter(slice, "$this$slice");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return indices.isEmpty() ? CollectionsKt__CollectionsKt.emptyList() : UArraysKt___UArraysJvmKt.m5952asListajY9A(UIntArray.m5622constructorimpl(ArraysKt___ArraysJvmKt.copyOfRange(slice, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1)));
    }

    /* JADX INFO: renamed from: slice-ZRhS8yI, reason: not valid java name */
    public static final List<ULong> m6554sliceZRhS8yI(@NotNull long[] slice, @NotNull IntRange indices) {
        Intrinsics.checkNotNullParameter(slice, "$this$slice");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return indices.isEmpty() ? CollectionsKt__CollectionsKt.emptyList() : UArraysKt___UArraysJvmKt.m5954asListQwZRm1k(ULongArray.m5701constructorimpl(ArraysKt___ArraysJvmKt.copyOfRange(slice, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1)));
    }

    /* JADX INFO: renamed from: slice-c0bezYM, reason: not valid java name */
    public static final List<UByte> m6555slicec0bezYM(@NotNull byte[] slice, @NotNull IntRange indices) {
        Intrinsics.checkNotNullParameter(slice, "$this$slice");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return indices.isEmpty() ? CollectionsKt__CollectionsKt.emptyList() : UArraysKt___UArraysJvmKt.m5953asListGBYM_sE(UByteArray.m5543constructorimpl(ArraysKt___ArraysJvmKt.copyOfRange(slice, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1)));
    }

    /* JADX INFO: renamed from: slice-Q6IL4kU, reason: not valid java name */
    public static final List<UShort> m6553sliceQ6IL4kU(@NotNull short[] slice, @NotNull IntRange indices) {
        Intrinsics.checkNotNullParameter(slice, "$this$slice");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return indices.isEmpty() ? CollectionsKt__CollectionsKt.emptyList() : UArraysKt___UArraysJvmKt.m5955asListrL5Bavg(UShortArray.m5806constructorimpl(ArraysKt___ArraysJvmKt.copyOfRange(slice, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1)));
    }

    /* JADX INFO: renamed from: slice-HwE9HBo, reason: not valid java name */
    public static final List<UInt> m6550sliceHwE9HBo(@NotNull int[] slice, @NotNull Iterable<Integer> indices) {
        Intrinsics.checkNotNullParameter(slice, "$this$slice");
        Intrinsics.checkNotNullParameter(indices, "indices");
        int iCollectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(indices, 10);
        if (iCollectionSizeOrDefault == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(iCollectionSizeOrDefault);
        Iterator<Integer> it2 = indices.iterator();
        while (it2.hasNext()) {
            arrayList.add(UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(slice, it2.next().intValue())));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: slice-F7u83W8, reason: not valid java name */
    public static final List<ULong> m6549sliceF7u83W8(@NotNull long[] slice, @NotNull Iterable<Integer> indices) {
        Intrinsics.checkNotNullParameter(slice, "$this$slice");
        Intrinsics.checkNotNullParameter(indices, "indices");
        int iCollectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(indices, 10);
        if (iCollectionSizeOrDefault == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(iCollectionSizeOrDefault);
        Iterator<Integer> it2 = indices.iterator();
        while (it2.hasNext()) {
            arrayList.add(ULong.m5640boximpl(ULongArray.m5706getsVKNKU(slice, it2.next().intValue())));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: slice-JQknh5Q, reason: not valid java name */
    public static final List<UByte> m6552sliceJQknh5Q(@NotNull byte[] slice, @NotNull Iterable<Integer> indices) {
        Intrinsics.checkNotNullParameter(slice, "$this$slice");
        Intrinsics.checkNotNullParameter(indices, "indices");
        int iCollectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(indices, 10);
        if (iCollectionSizeOrDefault == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(iCollectionSizeOrDefault);
        Iterator<Integer> it2 = indices.iterator();
        while (it2.hasNext()) {
            arrayList.add(UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(slice, it2.next().intValue())));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: slice-JGPC0-M, reason: not valid java name */
    public static final List<UShort> m6551sliceJGPC0M(@NotNull short[] slice, @NotNull Iterable<Integer> indices) {
        Intrinsics.checkNotNullParameter(slice, "$this$slice");
        Intrinsics.checkNotNullParameter(indices, "indices");
        int iCollectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(indices, 10);
        if (iCollectionSizeOrDefault == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(iCollectionSizeOrDefault);
        Iterator<Integer> it2 = indices.iterator();
        while (it2.hasNext()) {
            arrayList.add(UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(slice, it2.next().intValue())));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: sliceArray-CFIt9YE, reason: not valid java name */
    public static final int[] m6557sliceArrayCFIt9YE(@NotNull int[] sliceArray, @NotNull Collection<Integer> indices) {
        Intrinsics.checkNotNullParameter(sliceArray, "$this$sliceArray");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return UIntArray.m5622constructorimpl(ArraysKt___ArraysKt.sliceArray(sliceArray, (Collection<Integer>) indices));
    }

    /* JADX INFO: renamed from: sliceArray-kzHmqpY, reason: not valid java name */
    public static final long[] m6561sliceArraykzHmqpY(@NotNull long[] sliceArray, @NotNull Collection<Integer> indices) {
        Intrinsics.checkNotNullParameter(sliceArray, "$this$sliceArray");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return ULongArray.m5701constructorimpl(ArraysKt___ArraysKt.sliceArray(sliceArray, (Collection<Integer>) indices));
    }

    /* JADX INFO: renamed from: sliceArray-xo_DsdI, reason: not valid java name */
    public static final byte[] m6564sliceArrayxo_DsdI(@NotNull byte[] sliceArray, @NotNull Collection<Integer> indices) {
        Intrinsics.checkNotNullParameter(sliceArray, "$this$sliceArray");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return UByteArray.m5543constructorimpl(ArraysKt___ArraysKt.sliceArray(sliceArray, (Collection<Integer>) indices));
    }

    /* JADX INFO: renamed from: sliceArray-ojwP5H8, reason: not valid java name */
    public static final short[] m6562sliceArrayojwP5H8(@NotNull short[] sliceArray, @NotNull Collection<Integer> indices) {
        Intrinsics.checkNotNullParameter(sliceArray, "$this$sliceArray");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return UShortArray.m5806constructorimpl(ArraysKt___ArraysKt.sliceArray(sliceArray, (Collection<Integer>) indices));
    }

    /* JADX INFO: renamed from: sliceArray-tAntMlw, reason: not valid java name */
    public static final int[] m6563sliceArraytAntMlw(@NotNull int[] sliceArray, @NotNull IntRange indices) {
        Intrinsics.checkNotNullParameter(sliceArray, "$this$sliceArray");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return UIntArray.m5622constructorimpl(ArraysKt___ArraysKt.sliceArray(sliceArray, indices));
    }

    /* JADX INFO: renamed from: sliceArray-ZRhS8yI, reason: not valid java name */
    public static final long[] m6559sliceArrayZRhS8yI(@NotNull long[] sliceArray, @NotNull IntRange indices) {
        Intrinsics.checkNotNullParameter(sliceArray, "$this$sliceArray");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return ULongArray.m5701constructorimpl(ArraysKt___ArraysKt.sliceArray(sliceArray, indices));
    }

    /* JADX INFO: renamed from: sliceArray-c0bezYM, reason: not valid java name */
    public static final byte[] m6560sliceArrayc0bezYM(@NotNull byte[] sliceArray, @NotNull IntRange indices) {
        Intrinsics.checkNotNullParameter(sliceArray, "$this$sliceArray");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return UByteArray.m5543constructorimpl(ArraysKt___ArraysKt.sliceArray(sliceArray, indices));
    }

    /* JADX INFO: renamed from: sliceArray-Q6IL4kU, reason: not valid java name */
    public static final short[] m6558sliceArrayQ6IL4kU(@NotNull short[] sliceArray, @NotNull IntRange indices) {
        Intrinsics.checkNotNullParameter(sliceArray, "$this$sliceArray");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return UShortArray.m5806constructorimpl(ArraysKt___ArraysKt.sliceArray(sliceArray, indices));
    }

    /* JADX INFO: renamed from: take-qFRl0hI, reason: not valid java name */
    public static final List<UInt> m6615takeqFRl0hI(@NotNull int[] take, int i) {
        Intrinsics.checkNotNullParameter(take, "$this$take");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        if (i == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (i >= UIntArray.m5628getSizeimpl(take)) {
            return CollectionsKt___CollectionsKt.toList(UIntArray.m5620boximpl(take));
        }
        if (i == 1) {
            return CollectionsKt__CollectionsJVMKt.listOf(UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(take, 0)));
        }
        ArrayList arrayList = new ArrayList(i);
        int iM5628getSizeimpl = UIntArray.m5628getSizeimpl(take);
        int i2 = 0;
        for (int i3 = 0; i3 < iM5628getSizeimpl; i3++) {
            arrayList.add(UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(take, i3)));
            i2++;
            if (i2 == i) {
                break;
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: take-r7IrZao, reason: not valid java name */
    public static final List<ULong> m6616taker7IrZao(@NotNull long[] take, int i) {
        Intrinsics.checkNotNullParameter(take, "$this$take");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        if (i == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (i >= ULongArray.m5707getSizeimpl(take)) {
            return CollectionsKt___CollectionsKt.toList(ULongArray.m5699boximpl(take));
        }
        if (i == 1) {
            return CollectionsKt__CollectionsJVMKt.listOf(ULong.m5640boximpl(ULongArray.m5706getsVKNKU(take, 0)));
        }
        ArrayList arrayList = new ArrayList(i);
        int iM5707getSizeimpl = ULongArray.m5707getSizeimpl(take);
        int i2 = 0;
        for (int i3 = 0; i3 < iM5707getSizeimpl; i3++) {
            arrayList.add(ULong.m5640boximpl(ULongArray.m5706getsVKNKU(take, i3)));
            i2++;
            if (i2 == i) {
                break;
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: take-PpDY95g, reason: not valid java name */
    public static final List<UByte> m6613takePpDY95g(@NotNull byte[] take, int i) {
        Intrinsics.checkNotNullParameter(take, "$this$take");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        if (i == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (i >= UByteArray.m5549getSizeimpl(take)) {
            return CollectionsKt___CollectionsKt.toList(UByteArray.m5541boximpl(take));
        }
        if (i == 1) {
            return CollectionsKt__CollectionsJVMKt.listOf(UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(take, 0)));
        }
        ArrayList arrayList = new ArrayList(i);
        int iM5549getSizeimpl = UByteArray.m5549getSizeimpl(take);
        int i2 = 0;
        for (int i3 = 0; i3 < iM5549getSizeimpl; i3++) {
            arrayList.add(UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(take, i3)));
            i2++;
            if (i2 == i) {
                break;
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: take-nggk6HY, reason: not valid java name */
    public static final List<UShort> m6614takenggk6HY(@NotNull short[] take, int i) {
        Intrinsics.checkNotNullParameter(take, "$this$take");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        if (i == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (i >= UShortArray.m5812getSizeimpl(take)) {
            return CollectionsKt___CollectionsKt.toList(UShortArray.m5804boximpl(take));
        }
        if (i == 1) {
            return CollectionsKt__CollectionsJVMKt.listOf(UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(take, 0)));
        }
        ArrayList arrayList = new ArrayList(i);
        int iM5812getSizeimpl = UShortArray.m5812getSizeimpl(take);
        int i2 = 0;
        for (int i3 = 0; i3 < iM5812getSizeimpl; i3++) {
            arrayList.add(UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(take, i3)));
            i2++;
            if (i2 == i) {
                break;
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: takeLast-qFRl0hI, reason: not valid java name */
    public static final List<UInt> m6619takeLastqFRl0hI(@NotNull int[] takeLast, int i) {
        Intrinsics.checkNotNullParameter(takeLast, "$this$takeLast");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        if (i == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        int iM5628getSizeimpl = UIntArray.m5628getSizeimpl(takeLast);
        if (i >= iM5628getSizeimpl) {
            return CollectionsKt___CollectionsKt.toList(UIntArray.m5620boximpl(takeLast));
        }
        if (i == 1) {
            return CollectionsKt__CollectionsJVMKt.listOf(UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(takeLast, iM5628getSizeimpl - 1)));
        }
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = iM5628getSizeimpl - i; i2 < iM5628getSizeimpl; i2++) {
            arrayList.add(UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(takeLast, i2)));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: takeLast-r7IrZao, reason: not valid java name */
    public static final List<ULong> m6620takeLastr7IrZao(@NotNull long[] takeLast, int i) {
        Intrinsics.checkNotNullParameter(takeLast, "$this$takeLast");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        if (i == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        int iM5707getSizeimpl = ULongArray.m5707getSizeimpl(takeLast);
        if (i >= iM5707getSizeimpl) {
            return CollectionsKt___CollectionsKt.toList(ULongArray.m5699boximpl(takeLast));
        }
        if (i == 1) {
            return CollectionsKt__CollectionsJVMKt.listOf(ULong.m5640boximpl(ULongArray.m5706getsVKNKU(takeLast, iM5707getSizeimpl - 1)));
        }
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = iM5707getSizeimpl - i; i2 < iM5707getSizeimpl; i2++) {
            arrayList.add(ULong.m5640boximpl(ULongArray.m5706getsVKNKU(takeLast, i2)));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: takeLast-PpDY95g, reason: not valid java name */
    public static final List<UByte> m6617takeLastPpDY95g(@NotNull byte[] takeLast, int i) {
        Intrinsics.checkNotNullParameter(takeLast, "$this$takeLast");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        if (i == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        int iM5549getSizeimpl = UByteArray.m5549getSizeimpl(takeLast);
        if (i >= iM5549getSizeimpl) {
            return CollectionsKt___CollectionsKt.toList(UByteArray.m5541boximpl(takeLast));
        }
        if (i == 1) {
            return CollectionsKt__CollectionsJVMKt.listOf(UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(takeLast, iM5549getSizeimpl - 1)));
        }
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = iM5549getSizeimpl - i; i2 < iM5549getSizeimpl; i2++) {
            arrayList.add(UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(takeLast, i2)));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: takeLast-nggk6HY, reason: not valid java name */
    public static final List<UShort> m6618takeLastnggk6HY(@NotNull short[] takeLast, int i) {
        Intrinsics.checkNotNullParameter(takeLast, "$this$takeLast");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        if (i == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        int iM5812getSizeimpl = UShortArray.m5812getSizeimpl(takeLast);
        if (i >= iM5812getSizeimpl) {
            return CollectionsKt___CollectionsKt.toList(UShortArray.m5804boximpl(takeLast));
        }
        if (i == 1) {
            return CollectionsKt__CollectionsJVMKt.listOf(UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(takeLast, iM5812getSizeimpl - 1)));
        }
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = iM5812getSizeimpl - i; i2 < iM5812getSizeimpl; i2++) {
            arrayList.add(UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(takeLast, i2)));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: takeWhile-jgv0xPQ, reason: not valid java name */
    private static final List<UInt> m6627takeWhilejgv0xPQ(int[] takeWhile, Function1<? super UInt, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(takeWhile, "$this$takeWhile");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iM5628getSizeimpl = UIntArray.m5628getSizeimpl(takeWhile);
        for (int i = 0; i < iM5628getSizeimpl; i++) {
            int iM5627getpVg5ArA = UIntArray.m5627getpVg5ArA(takeWhile, i);
            if (!predicate.invoke(UInt.m5561boximpl(iM5627getpVg5ArA)).booleanValue()) {
                break;
            }
            arrayList.add(UInt.m5561boximpl(iM5627getpVg5ArA));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: takeWhile-MShoTSo, reason: not valid java name */
    private static final List<ULong> m6626takeWhileMShoTSo(long[] takeWhile, Function1<? super ULong, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(takeWhile, "$this$takeWhile");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iM5707getSizeimpl = ULongArray.m5707getSizeimpl(takeWhile);
        for (int i = 0; i < iM5707getSizeimpl; i++) {
            long jM5706getsVKNKU = ULongArray.m5706getsVKNKU(takeWhile, i);
            if (!predicate.invoke(ULong.m5640boximpl(jM5706getsVKNKU)).booleanValue()) {
                break;
            }
            arrayList.add(ULong.m5640boximpl(jM5706getsVKNKU));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: takeWhile-JOV_ifY, reason: not valid java name */
    private static final List<UByte> m6625takeWhileJOV_ifY(byte[] takeWhile, Function1<? super UByte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(takeWhile, "$this$takeWhile");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iM5549getSizeimpl = UByteArray.m5549getSizeimpl(takeWhile);
        for (int i = 0; i < iM5549getSizeimpl; i++) {
            byte bM5548getw2LRezQ = UByteArray.m5548getw2LRezQ(takeWhile, i);
            if (!predicate.invoke(UByte.m5484boximpl(bM5548getw2LRezQ)).booleanValue()) {
                break;
            }
            arrayList.add(UByte.m5484boximpl(bM5548getw2LRezQ));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: takeWhile-xTcfx_M, reason: not valid java name */
    private static final List<UShort> m6628takeWhilexTcfx_M(short[] takeWhile, Function1<? super UShort, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(takeWhile, "$this$takeWhile");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iM5812getSizeimpl = UShortArray.m5812getSizeimpl(takeWhile);
        for (int i = 0; i < iM5812getSizeimpl; i++) {
            short sM5811getMh2AYeg = UShortArray.m5811getMh2AYeg(takeWhile, i);
            if (!predicate.invoke(UShort.m5747boximpl(sM5811getMh2AYeg)).booleanValue()) {
                break;
            }
            arrayList.add(UShort.m5747boximpl(sM5811getMh2AYeg));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: reverse--ajY-9A, reason: not valid java name */
    private static final void m6485reverseajY9A(int[] reverse) {
        Intrinsics.checkNotNullParameter(reverse, "$this$reverse");
        ArraysKt___ArraysKt.reverse(reverse);
    }

    /* JADX INFO: renamed from: reverse-QwZRm1k, reason: not valid java name */
    private static final void m6490reverseQwZRm1k(long[] reverse) {
        Intrinsics.checkNotNullParameter(reverse, "$this$reverse");
        ArraysKt___ArraysKt.reverse(reverse);
    }

    /* JADX INFO: renamed from: reverse-GBYM_sE, reason: not valid java name */
    private static final void m6489reverseGBYM_sE(byte[] reverse) {
        Intrinsics.checkNotNullParameter(reverse, "$this$reverse");
        ArraysKt___ArraysKt.reverse(reverse);
    }

    /* JADX INFO: renamed from: reverse-rL5Bavg, reason: not valid java name */
    private static final void m6492reverserL5Bavg(short[] reverse) {
        Intrinsics.checkNotNullParameter(reverse, "$this$reverse");
        ArraysKt___ArraysKt.reverse(reverse);
    }

    /* JADX INFO: renamed from: reverse-oBK06Vg, reason: not valid java name */
    private static final void m6491reverseoBK06Vg(int[] reverse, int i, int i2) {
        Intrinsics.checkNotNullParameter(reverse, "$this$reverse");
        ArraysKt___ArraysKt.reverse(reverse, i, i2);
    }

    /* JADX INFO: renamed from: reverse--nroSd4, reason: not valid java name */
    private static final void m6486reversenroSd4(long[] reverse, int i, int i2) {
        Intrinsics.checkNotNullParameter(reverse, "$this$reverse");
        ArraysKt___ArraysKt.reverse(reverse, i, i2);
    }

    /* JADX INFO: renamed from: reverse-4UcCI2c, reason: not valid java name */
    private static final void m6487reverse4UcCI2c(byte[] reverse, int i, int i2) {
        Intrinsics.checkNotNullParameter(reverse, "$this$reverse");
        ArraysKt___ArraysKt.reverse(reverse, i, i2);
    }

    /* JADX INFO: renamed from: reverse-Aa5vz7o, reason: not valid java name */
    private static final void m6488reverseAa5vz7o(short[] reverse, int i, int i2) {
        Intrinsics.checkNotNullParameter(reverse, "$this$reverse");
        ArraysKt___ArraysKt.reverse(reverse, i, i2);
    }

    /* JADX INFO: renamed from: reversed--ajY-9A, reason: not valid java name */
    public static final List<UInt> m6493reversedajY9A(@NotNull int[] reversed) {
        Intrinsics.checkNotNullParameter(reversed, "$this$reversed");
        if (UIntArray.m5630isEmptyimpl(reversed)) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<UInt> mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) UIntArray.m5620boximpl(reversed));
        CollectionsKt___CollectionsJvmKt.reverse(mutableList);
        return mutableList;
    }

    /* JADX INFO: renamed from: reversed-QwZRm1k, reason: not valid java name */
    public static final List<ULong> m6495reversedQwZRm1k(@NotNull long[] reversed) {
        Intrinsics.checkNotNullParameter(reversed, "$this$reversed");
        if (ULongArray.m5709isEmptyimpl(reversed)) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<ULong> mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) ULongArray.m5699boximpl(reversed));
        CollectionsKt___CollectionsJvmKt.reverse(mutableList);
        return mutableList;
    }

    /* JADX INFO: renamed from: reversed-GBYM_sE, reason: not valid java name */
    public static final List<UByte> m6494reversedGBYM_sE(@NotNull byte[] reversed) {
        Intrinsics.checkNotNullParameter(reversed, "$this$reversed");
        if (UByteArray.m5551isEmptyimpl(reversed)) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<UByte> mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) UByteArray.m5541boximpl(reversed));
        CollectionsKt___CollectionsJvmKt.reverse(mutableList);
        return mutableList;
    }

    /* JADX INFO: renamed from: reversed-rL5Bavg, reason: not valid java name */
    public static final List<UShort> m6496reversedrL5Bavg(@NotNull short[] reversed) {
        Intrinsics.checkNotNullParameter(reversed, "$this$reversed");
        if (UShortArray.m5814isEmptyimpl(reversed)) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<UShort> mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) UShortArray.m5804boximpl(reversed));
        CollectionsKt___CollectionsJvmKt.reverse(mutableList);
        return mutableList;
    }

    /* JADX INFO: renamed from: reversedArray--ajY-9A, reason: not valid java name */
    private static final int[] m6497reversedArrayajY9A(int[] reversedArray) {
        Intrinsics.checkNotNullParameter(reversedArray, "$this$reversedArray");
        return UIntArray.m5622constructorimpl(ArraysKt___ArraysKt.reversedArray(reversedArray));
    }

    /* JADX INFO: renamed from: reversedArray-QwZRm1k, reason: not valid java name */
    private static final long[] m6499reversedArrayQwZRm1k(long[] reversedArray) {
        Intrinsics.checkNotNullParameter(reversedArray, "$this$reversedArray");
        return ULongArray.m5701constructorimpl(ArraysKt___ArraysKt.reversedArray(reversedArray));
    }

    /* JADX INFO: renamed from: reversedArray-GBYM_sE, reason: not valid java name */
    private static final byte[] m6498reversedArrayGBYM_sE(byte[] reversedArray) {
        Intrinsics.checkNotNullParameter(reversedArray, "$this$reversedArray");
        return UByteArray.m5543constructorimpl(ArraysKt___ArraysKt.reversedArray(reversedArray));
    }

    /* JADX INFO: renamed from: reversedArray-rL5Bavg, reason: not valid java name */
    private static final short[] m6500reversedArrayrL5Bavg(short[] reversedArray) {
        Intrinsics.checkNotNullParameter(reversedArray, "$this$reversedArray");
        return UShortArray.m5806constructorimpl(ArraysKt___ArraysKt.reversedArray(reversedArray));
    }

    /* JADX INFO: renamed from: shuffle--ajY-9A, reason: not valid java name */
    public static final void m6525shuffleajY9A(@NotNull int[] shuffle) {
        Intrinsics.checkNotNullParameter(shuffle, "$this$shuffle");
        m6526shuffle2D5oskM(shuffle, Random.Default);
    }

    /* JADX INFO: renamed from: shuffle-QwZRm1k, reason: not valid java name */
    public static final void m6529shuffleQwZRm1k(@NotNull long[] shuffle) {
        Intrinsics.checkNotNullParameter(shuffle, "$this$shuffle");
        m6528shuffleJzugnMA(shuffle, Random.Default);
    }

    /* JADX INFO: renamed from: shuffle-GBYM_sE, reason: not valid java name */
    public static final void m6527shuffleGBYM_sE(@NotNull byte[] shuffle) {
        Intrinsics.checkNotNullParameter(shuffle, "$this$shuffle");
        m6530shuffleoSF2wD8(shuffle, Random.Default);
    }

    /* JADX INFO: renamed from: shuffle-rL5Bavg, reason: not valid java name */
    public static final void m6531shufflerL5Bavg(@NotNull short[] shuffle) {
        Intrinsics.checkNotNullParameter(shuffle, "$this$shuffle");
        m6532shuffles5X_as8(shuffle, Random.Default);
    }

    /* JADX INFO: renamed from: sortDescending--ajY-9A, reason: not valid java name */
    public static final void m6577sortDescendingajY9A(@NotNull int[] sortDescending) {
        Intrinsics.checkNotNullParameter(sortDescending, "$this$sortDescending");
        if (UIntArray.m5628getSizeimpl(sortDescending) > 1) {
            m6565sortajY9A(sortDescending);
            ArraysKt___ArraysKt.reverse(sortDescending);
        }
    }

    /* JADX INFO: renamed from: sortDescending-QwZRm1k, reason: not valid java name */
    public static final void m6582sortDescendingQwZRm1k(@NotNull long[] sortDescending) {
        Intrinsics.checkNotNullParameter(sortDescending, "$this$sortDescending");
        if (ULongArray.m5707getSizeimpl(sortDescending) > 1) {
            m6573sortQwZRm1k(sortDescending);
            ArraysKt___ArraysKt.reverse(sortDescending);
        }
    }

    /* JADX INFO: renamed from: sortDescending-GBYM_sE, reason: not valid java name */
    public static final void m6581sortDescendingGBYM_sE(@NotNull byte[] sortDescending) {
        Intrinsics.checkNotNullParameter(sortDescending, "$this$sortDescending");
        if (UByteArray.m5549getSizeimpl(sortDescending) > 1) {
            m6572sortGBYM_sE(sortDescending);
            ArraysKt___ArraysKt.reverse(sortDescending);
        }
    }

    /* JADX INFO: renamed from: sortDescending-rL5Bavg, reason: not valid java name */
    public static final void m6584sortDescendingrL5Bavg(@NotNull short[] sortDescending) {
        Intrinsics.checkNotNullParameter(sortDescending, "$this$sortDescending");
        if (UShortArray.m5812getSizeimpl(sortDescending) > 1) {
            m6576sortrL5Bavg(sortDescending);
            ArraysKt___ArraysKt.reverse(sortDescending);
        }
    }

    /* JADX INFO: renamed from: sorted--ajY-9A, reason: not valid java name */
    public static final List<UInt> m6585sortedajY9A(@NotNull int[] sorted) {
        Intrinsics.checkNotNullParameter(sorted, "$this$sorted");
        int[] iArrCopyOf = Arrays.copyOf(sorted, sorted.length);
        Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
        int[] iArrM5622constructorimpl = UIntArray.m5622constructorimpl(iArrCopyOf);
        m6565sortajY9A(iArrM5622constructorimpl);
        return UArraysKt___UArraysJvmKt.m5952asListajY9A(iArrM5622constructorimpl);
    }

    /* JADX INFO: renamed from: sorted-QwZRm1k, reason: not valid java name */
    public static final List<ULong> m6587sortedQwZRm1k(@NotNull long[] sorted) {
        Intrinsics.checkNotNullParameter(sorted, "$this$sorted");
        long[] jArrCopyOf = Arrays.copyOf(sorted, sorted.length);
        Intrinsics.checkNotNullExpressionValue(jArrCopyOf, "copyOf(...)");
        long[] jArrM5701constructorimpl = ULongArray.m5701constructorimpl(jArrCopyOf);
        m6573sortQwZRm1k(jArrM5701constructorimpl);
        return UArraysKt___UArraysJvmKt.m5954asListQwZRm1k(jArrM5701constructorimpl);
    }

    /* JADX INFO: renamed from: sorted-GBYM_sE, reason: not valid java name */
    public static final List<UByte> m6586sortedGBYM_sE(@NotNull byte[] sorted) {
        Intrinsics.checkNotNullParameter(sorted, "$this$sorted");
        byte[] bArrCopyOf = Arrays.copyOf(sorted, sorted.length);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
        byte[] bArrM5543constructorimpl = UByteArray.m5543constructorimpl(bArrCopyOf);
        m6572sortGBYM_sE(bArrM5543constructorimpl);
        return UArraysKt___UArraysJvmKt.m5953asListGBYM_sE(bArrM5543constructorimpl);
    }

    /* JADX INFO: renamed from: sorted-rL5Bavg, reason: not valid java name */
    public static final List<UShort> m6588sortedrL5Bavg(@NotNull short[] sorted) {
        Intrinsics.checkNotNullParameter(sorted, "$this$sorted");
        short[] sArrCopyOf = Arrays.copyOf(sorted, sorted.length);
        Intrinsics.checkNotNullExpressionValue(sArrCopyOf, "copyOf(...)");
        short[] sArrM5806constructorimpl = UShortArray.m5806constructorimpl(sArrCopyOf);
        m6576sortrL5Bavg(sArrM5806constructorimpl);
        return UArraysKt___UArraysJvmKt.m5955asListrL5Bavg(sArrM5806constructorimpl);
    }

    /* JADX INFO: renamed from: sortedArray--ajY-9A, reason: not valid java name */
    public static final int[] m6589sortedArrayajY9A(@NotNull int[] sortedArray) {
        Intrinsics.checkNotNullParameter(sortedArray, "$this$sortedArray");
        if (UIntArray.m5630isEmptyimpl(sortedArray)) {
            return sortedArray;
        }
        int[] iArrCopyOf = Arrays.copyOf(sortedArray, sortedArray.length);
        Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
        int[] iArrM5622constructorimpl = UIntArray.m5622constructorimpl(iArrCopyOf);
        m6565sortajY9A(iArrM5622constructorimpl);
        return iArrM5622constructorimpl;
    }

    /* JADX INFO: renamed from: sortedArray-QwZRm1k, reason: not valid java name */
    public static final long[] m6591sortedArrayQwZRm1k(@NotNull long[] sortedArray) {
        Intrinsics.checkNotNullParameter(sortedArray, "$this$sortedArray");
        if (ULongArray.m5709isEmptyimpl(sortedArray)) {
            return sortedArray;
        }
        long[] jArrCopyOf = Arrays.copyOf(sortedArray, sortedArray.length);
        Intrinsics.checkNotNullExpressionValue(jArrCopyOf, "copyOf(...)");
        long[] jArrM5701constructorimpl = ULongArray.m5701constructorimpl(jArrCopyOf);
        m6573sortQwZRm1k(jArrM5701constructorimpl);
        return jArrM5701constructorimpl;
    }

    /* JADX INFO: renamed from: sortedArray-GBYM_sE, reason: not valid java name */
    public static final byte[] m6590sortedArrayGBYM_sE(@NotNull byte[] sortedArray) {
        Intrinsics.checkNotNullParameter(sortedArray, "$this$sortedArray");
        if (UByteArray.m5551isEmptyimpl(sortedArray)) {
            return sortedArray;
        }
        byte[] bArrCopyOf = Arrays.copyOf(sortedArray, sortedArray.length);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
        byte[] bArrM5543constructorimpl = UByteArray.m5543constructorimpl(bArrCopyOf);
        m6572sortGBYM_sE(bArrM5543constructorimpl);
        return bArrM5543constructorimpl;
    }

    /* JADX INFO: renamed from: sortedArray-rL5Bavg, reason: not valid java name */
    public static final short[] m6592sortedArrayrL5Bavg(@NotNull short[] sortedArray) {
        Intrinsics.checkNotNullParameter(sortedArray, "$this$sortedArray");
        if (UShortArray.m5814isEmptyimpl(sortedArray)) {
            return sortedArray;
        }
        short[] sArrCopyOf = Arrays.copyOf(sortedArray, sortedArray.length);
        Intrinsics.checkNotNullExpressionValue(sArrCopyOf, "copyOf(...)");
        short[] sArrM5806constructorimpl = UShortArray.m5806constructorimpl(sArrCopyOf);
        m6576sortrL5Bavg(sArrM5806constructorimpl);
        return sArrM5806constructorimpl;
    }

    /* JADX INFO: renamed from: sortedArrayDescending--ajY-9A, reason: not valid java name */
    public static final int[] m6593sortedArrayDescendingajY9A(@NotNull int[] sortedArrayDescending) {
        Intrinsics.checkNotNullParameter(sortedArrayDescending, "$this$sortedArrayDescending");
        if (UIntArray.m5630isEmptyimpl(sortedArrayDescending)) {
            return sortedArrayDescending;
        }
        int[] iArrCopyOf = Arrays.copyOf(sortedArrayDescending, sortedArrayDescending.length);
        Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
        int[] iArrM5622constructorimpl = UIntArray.m5622constructorimpl(iArrCopyOf);
        m6577sortDescendingajY9A(iArrM5622constructorimpl);
        return iArrM5622constructorimpl;
    }

    /* JADX INFO: renamed from: sortedArrayDescending-QwZRm1k, reason: not valid java name */
    public static final long[] m6595sortedArrayDescendingQwZRm1k(@NotNull long[] sortedArrayDescending) {
        Intrinsics.checkNotNullParameter(sortedArrayDescending, "$this$sortedArrayDescending");
        if (ULongArray.m5709isEmptyimpl(sortedArrayDescending)) {
            return sortedArrayDescending;
        }
        long[] jArrCopyOf = Arrays.copyOf(sortedArrayDescending, sortedArrayDescending.length);
        Intrinsics.checkNotNullExpressionValue(jArrCopyOf, "copyOf(...)");
        long[] jArrM5701constructorimpl = ULongArray.m5701constructorimpl(jArrCopyOf);
        m6582sortDescendingQwZRm1k(jArrM5701constructorimpl);
        return jArrM5701constructorimpl;
    }

    /* JADX INFO: renamed from: sortedArrayDescending-GBYM_sE, reason: not valid java name */
    public static final byte[] m6594sortedArrayDescendingGBYM_sE(@NotNull byte[] sortedArrayDescending) {
        Intrinsics.checkNotNullParameter(sortedArrayDescending, "$this$sortedArrayDescending");
        if (UByteArray.m5551isEmptyimpl(sortedArrayDescending)) {
            return sortedArrayDescending;
        }
        byte[] bArrCopyOf = Arrays.copyOf(sortedArrayDescending, sortedArrayDescending.length);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
        byte[] bArrM5543constructorimpl = UByteArray.m5543constructorimpl(bArrCopyOf);
        m6581sortDescendingGBYM_sE(bArrM5543constructorimpl);
        return bArrM5543constructorimpl;
    }

    /* JADX INFO: renamed from: sortedArrayDescending-rL5Bavg, reason: not valid java name */
    public static final short[] m6596sortedArrayDescendingrL5Bavg(@NotNull short[] sortedArrayDescending) {
        Intrinsics.checkNotNullParameter(sortedArrayDescending, "$this$sortedArrayDescending");
        if (UShortArray.m5814isEmptyimpl(sortedArrayDescending)) {
            return sortedArrayDescending;
        }
        short[] sArrCopyOf = Arrays.copyOf(sortedArrayDescending, sortedArrayDescending.length);
        Intrinsics.checkNotNullExpressionValue(sArrCopyOf, "copyOf(...)");
        short[] sArrM5806constructorimpl = UShortArray.m5806constructorimpl(sArrCopyOf);
        m6584sortDescendingrL5Bavg(sArrM5806constructorimpl);
        return sArrM5806constructorimpl;
    }

    /* JADX INFO: renamed from: sortedDescending--ajY-9A, reason: not valid java name */
    public static final List<UInt> m6597sortedDescendingajY9A(@NotNull int[] sortedDescending) {
        Intrinsics.checkNotNullParameter(sortedDescending, "$this$sortedDescending");
        int[] iArrCopyOf = Arrays.copyOf(sortedDescending, sortedDescending.length);
        Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
        int[] iArrM5622constructorimpl = UIntArray.m5622constructorimpl(iArrCopyOf);
        m6565sortajY9A(iArrM5622constructorimpl);
        return m6493reversedajY9A(iArrM5622constructorimpl);
    }

    /* JADX INFO: renamed from: sortedDescending-QwZRm1k, reason: not valid java name */
    public static final List<ULong> m6599sortedDescendingQwZRm1k(@NotNull long[] sortedDescending) {
        Intrinsics.checkNotNullParameter(sortedDescending, "$this$sortedDescending");
        long[] jArrCopyOf = Arrays.copyOf(sortedDescending, sortedDescending.length);
        Intrinsics.checkNotNullExpressionValue(jArrCopyOf, "copyOf(...)");
        long[] jArrM5701constructorimpl = ULongArray.m5701constructorimpl(jArrCopyOf);
        m6573sortQwZRm1k(jArrM5701constructorimpl);
        return m6495reversedQwZRm1k(jArrM5701constructorimpl);
    }

    /* JADX INFO: renamed from: sortedDescending-GBYM_sE, reason: not valid java name */
    public static final List<UByte> m6598sortedDescendingGBYM_sE(@NotNull byte[] sortedDescending) {
        Intrinsics.checkNotNullParameter(sortedDescending, "$this$sortedDescending");
        byte[] bArrCopyOf = Arrays.copyOf(sortedDescending, sortedDescending.length);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
        byte[] bArrM5543constructorimpl = UByteArray.m5543constructorimpl(bArrCopyOf);
        m6572sortGBYM_sE(bArrM5543constructorimpl);
        return m6494reversedGBYM_sE(bArrM5543constructorimpl);
    }

    /* JADX INFO: renamed from: sortedDescending-rL5Bavg, reason: not valid java name */
    public static final List<UShort> m6600sortedDescendingrL5Bavg(@NotNull short[] sortedDescending) {
        Intrinsics.checkNotNullParameter(sortedDescending, "$this$sortedDescending");
        short[] sArrCopyOf = Arrays.copyOf(sortedDescending, sortedDescending.length);
        Intrinsics.checkNotNullExpressionValue(sArrCopyOf, "copyOf(...)");
        short[] sArrM5806constructorimpl = UShortArray.m5806constructorimpl(sArrCopyOf);
        m6576sortrL5Bavg(sArrM5806constructorimpl);
        return m6496reversedrL5Bavg(sArrM5806constructorimpl);
    }

    private static final byte[] asUByteArray(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return UByteArray.m5543constructorimpl(bArr);
    }

    private static final int[] asUIntArray(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return UIntArray.m5622constructorimpl(iArr);
    }

    private static final long[] asULongArray(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        return ULongArray.m5701constructorimpl(jArr);
    }

    private static final short[] asUShortArray(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        return UShortArray.m5806constructorimpl(sArr);
    }

    /* JADX INFO: renamed from: contentEquals-KJPZfPQ, reason: not valid java name */
    public static boolean m6054contentEqualsKJPZfPQ(@Nullable int[] iArr, @Nullable int[] iArr2) {
        if (iArr == null) {
            iArr = null;
        }
        if (iArr2 == null) {
            iArr2 = null;
        }
        return Arrays.equals(iArr, iArr2);
    }

    /* JADX INFO: renamed from: contentEquals-lec5QzE, reason: not valid java name */
    public static boolean m6056contentEqualslec5QzE(@Nullable long[] jArr, @Nullable long[] jArr2) {
        if (jArr == null) {
            jArr = null;
        }
        if (jArr2 == null) {
            jArr2 = null;
        }
        return Arrays.equals(jArr, jArr2);
    }

    /* JADX INFO: renamed from: contentEquals-kV0jMPg, reason: not valid java name */
    public static boolean m6055contentEqualskV0jMPg(@Nullable byte[] bArr, @Nullable byte[] bArr2) {
        if (bArr == null) {
            bArr = null;
        }
        if (bArr2 == null) {
            bArr2 = null;
        }
        return Arrays.equals(bArr, bArr2);
    }

    /* JADX INFO: renamed from: contentEquals-FGO6Aew, reason: not valid java name */
    public static boolean m6053contentEqualsFGO6Aew(@Nullable short[] sArr, @Nullable short[] sArr2) {
        if (sArr == null) {
            sArr = null;
        }
        if (sArr2 == null) {
            sArr2 = null;
        }
        return Arrays.equals(sArr, sArr2);
    }

    /* JADX INFO: renamed from: contentHashCode-XUkPCBk, reason: not valid java name */
    public static final int m6058contentHashCodeXUkPCBk(@Nullable int[] iArr) {
        if (iArr == null) {
            iArr = null;
        }
        return Arrays.hashCode(iArr);
    }

    /* JADX INFO: renamed from: contentHashCode-uLth9ew, reason: not valid java name */
    public static final int m6060contentHashCodeuLth9ew(@Nullable long[] jArr) {
        if (jArr == null) {
            jArr = null;
        }
        return Arrays.hashCode(jArr);
    }

    /* JADX INFO: renamed from: contentHashCode-2csIQuQ, reason: not valid java name */
    public static final int m6057contentHashCode2csIQuQ(@Nullable byte[] bArr) {
        if (bArr == null) {
            bArr = null;
        }
        return Arrays.hashCode(bArr);
    }

    /* JADX INFO: renamed from: contentHashCode-d-6D3K8, reason: not valid java name */
    public static final int m6059contentHashCoded6D3K8(@Nullable short[] sArr) {
        if (sArr == null) {
            sArr = null;
        }
        return Arrays.hashCode(sArr);
    }

    /* JADX INFO: renamed from: contentToString-XUkPCBk, reason: not valid java name */
    public static String m6062contentToStringXUkPCBk(@Nullable int[] iArr) {
        String strJoinToString$default;
        return (iArr == null || (strJoinToString$default = CollectionsKt___CollectionsKt.joinToString$default(UIntArray.m5620boximpl(iArr), ", ", "[", "]", 0, null, null, 56, null)) == null) ? BuildConfig.TRAVIS : strJoinToString$default;
    }

    /* JADX INFO: renamed from: contentToString-uLth9ew, reason: not valid java name */
    public static String m6064contentToStringuLth9ew(@Nullable long[] jArr) {
        String strJoinToString$default;
        return (jArr == null || (strJoinToString$default = CollectionsKt___CollectionsKt.joinToString$default(ULongArray.m5699boximpl(jArr), ", ", "[", "]", 0, null, null, 56, null)) == null) ? BuildConfig.TRAVIS : strJoinToString$default;
    }

    /* JADX INFO: renamed from: contentToString-2csIQuQ, reason: not valid java name */
    public static String m6061contentToString2csIQuQ(@Nullable byte[] bArr) {
        String strJoinToString$default;
        return (bArr == null || (strJoinToString$default = CollectionsKt___CollectionsKt.joinToString$default(UByteArray.m5541boximpl(bArr), ", ", "[", "]", 0, null, null, 56, null)) == null) ? BuildConfig.TRAVIS : strJoinToString$default;
    }

    /* JADX INFO: renamed from: contentToString-d-6D3K8, reason: not valid java name */
    public static String m6063contentToStringd6D3K8(@Nullable short[] sArr) {
        String strJoinToString$default;
        return (sArr == null || (strJoinToString$default = CollectionsKt___CollectionsKt.joinToString$default(UShortArray.m5804boximpl(sArr), ", ", "[", "]", 0, null, null, 56, null)) == null) ? BuildConfig.TRAVIS : strJoinToString$default;
    }

    /* JADX INFO: renamed from: copyInto-sIZ3KeM$default, reason: not valid java name */
    static /* synthetic */ int[] m6072copyIntosIZ3KeM$default(int[] copyInto, int[] destination, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = UIntArray.m5628getSizeimpl(copyInto);
        }
        Intrinsics.checkNotNullParameter(copyInto, "$this$copyInto");
        Intrinsics.checkNotNullParameter(destination, "destination");
        ArraysKt___ArraysJvmKt.copyInto(copyInto, destination, i, i2, i3);
        return destination;
    }

    /* JADX INFO: renamed from: copyInto-sIZ3KeM, reason: not valid java name */
    private static final int[] m6071copyIntosIZ3KeM(int[] copyInto, int[] destination, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(copyInto, "$this$copyInto");
        Intrinsics.checkNotNullParameter(destination, "destination");
        ArraysKt___ArraysJvmKt.copyInto(copyInto, destination, i, i2, i3);
        return destination;
    }

    /* JADX INFO: renamed from: copyInto--B0-L2c$default, reason: not valid java name */
    static /* synthetic */ long[] m6066copyIntoB0L2c$default(long[] copyInto, long[] destination, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = ULongArray.m5707getSizeimpl(copyInto);
        }
        Intrinsics.checkNotNullParameter(copyInto, "$this$copyInto");
        Intrinsics.checkNotNullParameter(destination, "destination");
        ArraysKt___ArraysJvmKt.copyInto(copyInto, destination, i, i2, i3);
        return destination;
    }

    /* JADX INFO: renamed from: copyInto--B0-L2c, reason: not valid java name */
    private static final long[] m6065copyIntoB0L2c(long[] copyInto, long[] destination, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(copyInto, "$this$copyInto");
        Intrinsics.checkNotNullParameter(destination, "destination");
        ArraysKt___ArraysJvmKt.copyInto(copyInto, destination, i, i2, i3);
        return destination;
    }

    /* JADX INFO: renamed from: copyInto-FUQE5sA$default, reason: not valid java name */
    static /* synthetic */ byte[] m6070copyIntoFUQE5sA$default(byte[] copyInto, byte[] destination, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = UByteArray.m5549getSizeimpl(copyInto);
        }
        Intrinsics.checkNotNullParameter(copyInto, "$this$copyInto");
        Intrinsics.checkNotNullParameter(destination, "destination");
        ArraysKt___ArraysJvmKt.copyInto(copyInto, destination, i, i2, i3);
        return destination;
    }

    /* JADX INFO: renamed from: copyInto-FUQE5sA, reason: not valid java name */
    private static final byte[] m6069copyIntoFUQE5sA(byte[] copyInto, byte[] destination, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(copyInto, "$this$copyInto");
        Intrinsics.checkNotNullParameter(destination, "destination");
        ArraysKt___ArraysJvmKt.copyInto(copyInto, destination, i, i2, i3);
        return destination;
    }

    /* JADX INFO: renamed from: copyInto-9-ak10g$default, reason: not valid java name */
    static /* synthetic */ short[] m6068copyInto9ak10g$default(short[] copyInto, short[] destination, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = UShortArray.m5812getSizeimpl(copyInto);
        }
        Intrinsics.checkNotNullParameter(copyInto, "$this$copyInto");
        Intrinsics.checkNotNullParameter(destination, "destination");
        ArraysKt___ArraysJvmKt.copyInto(copyInto, destination, i, i2, i3);
        return destination;
    }

    /* JADX INFO: renamed from: copyInto-9-ak10g, reason: not valid java name */
    private static final short[] m6067copyInto9ak10g(short[] copyInto, short[] destination, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(copyInto, "$this$copyInto");
        Intrinsics.checkNotNullParameter(destination, "destination");
        ArraysKt___ArraysJvmKt.copyInto(copyInto, destination, i, i2, i3);
        return destination;
    }

    /* JADX INFO: renamed from: copyOf--ajY-9A, reason: not valid java name */
    private static final int[] m6073copyOfajY9A(int[] copyOf) {
        Intrinsics.checkNotNullParameter(copyOf, "$this$copyOf");
        int[] iArrCopyOf = Arrays.copyOf(copyOf, copyOf.length);
        Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
        return UIntArray.m5622constructorimpl(iArrCopyOf);
    }

    /* JADX INFO: renamed from: copyOf-QwZRm1k, reason: not valid java name */
    private static final long[] m6076copyOfQwZRm1k(long[] copyOf) {
        Intrinsics.checkNotNullParameter(copyOf, "$this$copyOf");
        long[] jArrCopyOf = Arrays.copyOf(copyOf, copyOf.length);
        Intrinsics.checkNotNullExpressionValue(jArrCopyOf, "copyOf(...)");
        return ULongArray.m5701constructorimpl(jArrCopyOf);
    }

    /* JADX INFO: renamed from: copyOf-GBYM_sE, reason: not valid java name */
    private static final byte[] m6074copyOfGBYM_sE(byte[] copyOf) {
        Intrinsics.checkNotNullParameter(copyOf, "$this$copyOf");
        byte[] bArrCopyOf = Arrays.copyOf(copyOf, copyOf.length);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
        return UByteArray.m5543constructorimpl(bArrCopyOf);
    }

    /* JADX INFO: renamed from: copyOf-rL5Bavg, reason: not valid java name */
    private static final short[] m6080copyOfrL5Bavg(short[] copyOf) {
        Intrinsics.checkNotNullParameter(copyOf, "$this$copyOf");
        short[] sArrCopyOf = Arrays.copyOf(copyOf, copyOf.length);
        Intrinsics.checkNotNullExpressionValue(sArrCopyOf, "copyOf(...)");
        return UShortArray.m5806constructorimpl(sArrCopyOf);
    }

    /* JADX INFO: renamed from: copyOf-qFRl0hI, reason: not valid java name */
    private static final int[] m6078copyOfqFRl0hI(int[] copyOf, int i) {
        Intrinsics.checkNotNullParameter(copyOf, "$this$copyOf");
        int[] iArrCopyOf = Arrays.copyOf(copyOf, i);
        Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
        return UIntArray.m5622constructorimpl(iArrCopyOf);
    }

    /* JADX INFO: renamed from: copyOf-r7IrZao, reason: not valid java name */
    private static final long[] m6079copyOfr7IrZao(long[] copyOf, int i) {
        Intrinsics.checkNotNullParameter(copyOf, "$this$copyOf");
        long[] jArrCopyOf = Arrays.copyOf(copyOf, i);
        Intrinsics.checkNotNullExpressionValue(jArrCopyOf, "copyOf(...)");
        return ULongArray.m5701constructorimpl(jArrCopyOf);
    }

    /* JADX INFO: renamed from: copyOf-PpDY95g, reason: not valid java name */
    private static final byte[] m6075copyOfPpDY95g(byte[] copyOf, int i) {
        Intrinsics.checkNotNullParameter(copyOf, "$this$copyOf");
        byte[] bArrCopyOf = Arrays.copyOf(copyOf, i);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
        return UByteArray.m5543constructorimpl(bArrCopyOf);
    }

    /* JADX INFO: renamed from: copyOf-nggk6HY, reason: not valid java name */
    private static final short[] m6077copyOfnggk6HY(short[] copyOf, int i) {
        Intrinsics.checkNotNullParameter(copyOf, "$this$copyOf");
        short[] sArrCopyOf = Arrays.copyOf(copyOf, i);
        Intrinsics.checkNotNullExpressionValue(sArrCopyOf, "copyOf(...)");
        return UShortArray.m5806constructorimpl(sArrCopyOf);
    }

    /* JADX INFO: renamed from: copyOfRange-oBK06Vg, reason: not valid java name */
    private static final int[] m6084copyOfRangeoBK06Vg(int[] copyOfRange, int i, int i2) {
        Intrinsics.checkNotNullParameter(copyOfRange, "$this$copyOfRange");
        return UIntArray.m5622constructorimpl(ArraysKt___ArraysJvmKt.copyOfRange(copyOfRange, i, i2));
    }

    /* JADX INFO: renamed from: copyOfRange--nroSd4, reason: not valid java name */
    private static final long[] m6081copyOfRangenroSd4(long[] copyOfRange, int i, int i2) {
        Intrinsics.checkNotNullParameter(copyOfRange, "$this$copyOfRange");
        return ULongArray.m5701constructorimpl(ArraysKt___ArraysJvmKt.copyOfRange(copyOfRange, i, i2));
    }

    /* JADX INFO: renamed from: copyOfRange-4UcCI2c, reason: not valid java name */
    private static final byte[] m6082copyOfRange4UcCI2c(byte[] copyOfRange, int i, int i2) {
        Intrinsics.checkNotNullParameter(copyOfRange, "$this$copyOfRange");
        return UByteArray.m5543constructorimpl(ArraysKt___ArraysJvmKt.copyOfRange(copyOfRange, i, i2));
    }

    /* JADX INFO: renamed from: copyOfRange-Aa5vz7o, reason: not valid java name */
    private static final short[] m6083copyOfRangeAa5vz7o(short[] copyOfRange, int i, int i2) {
        Intrinsics.checkNotNullParameter(copyOfRange, "$this$copyOfRange");
        return UShortArray.m5806constructorimpl(ArraysKt___ArraysJvmKt.copyOfRange(copyOfRange, i, i2));
    }

    /* JADX INFO: renamed from: fill-2fe2U9s$default, reason: not valid java name */
    public static /* synthetic */ void m6114fill2fe2U9s$default(int[] iArr, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = UIntArray.m5628getSizeimpl(iArr);
        }
        m6113fill2fe2U9s(iArr, i, i2, i3);
    }

    /* JADX INFO: renamed from: fill-2fe2U9s, reason: not valid java name */
    public static final void m6113fill2fe2U9s(@NotNull int[] fill, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(fill, "$this$fill");
        ArraysKt___ArraysJvmKt.fill(fill, i, i2, i3);
    }

    /* JADX INFO: renamed from: fill-K6DWlUc$default, reason: not valid java name */
    public static /* synthetic */ void m6118fillK6DWlUc$default(long[] jArr, long j, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = ULongArray.m5707getSizeimpl(jArr);
        }
        m6117fillK6DWlUc(jArr, j, i, i2);
    }

    /* JADX INFO: renamed from: fill-K6DWlUc, reason: not valid java name */
    public static final void m6117fillK6DWlUc(@NotNull long[] fill, long j, int i, int i2) {
        Intrinsics.checkNotNullParameter(fill, "$this$fill");
        ArraysKt___ArraysJvmKt.fill(fill, j, i, i2);
    }

    /* JADX INFO: renamed from: fill-WpHrYlw$default, reason: not valid java name */
    public static /* synthetic */ void m6120fillWpHrYlw$default(byte[] bArr, byte b, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UByteArray.m5549getSizeimpl(bArr);
        }
        m6119fillWpHrYlw(bArr, b, i, i2);
    }

    /* JADX INFO: renamed from: fill-WpHrYlw, reason: not valid java name */
    public static final void m6119fillWpHrYlw(@NotNull byte[] fill, byte b, int i, int i2) {
        Intrinsics.checkNotNullParameter(fill, "$this$fill");
        ArraysKt___ArraysJvmKt.fill(fill, b, i, i2);
    }

    /* JADX INFO: renamed from: fill-EtDCXyQ$default, reason: not valid java name */
    public static /* synthetic */ void m6116fillEtDCXyQ$default(short[] sArr, short s, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UShortArray.m5812getSizeimpl(sArr);
        }
        m6115fillEtDCXyQ(sArr, s, i, i2);
    }

    /* JADX INFO: renamed from: fill-EtDCXyQ, reason: not valid java name */
    public static final void m6115fillEtDCXyQ(@NotNull short[] fill, short s, int i, int i2) {
        Intrinsics.checkNotNullParameter(fill, "$this$fill");
        ArraysKt___ArraysJvmKt.fill(fill, s, i, i2);
    }

    /* JADX INFO: renamed from: getIndices--ajY-9A, reason: not valid java name */
    public static final IntRange m6209getIndicesajY9A(@NotNull int[] indices) {
        Intrinsics.checkNotNullParameter(indices, "$this$indices");
        return ArraysKt___ArraysKt.getIndices(indices);
    }

    /* JADX INFO: renamed from: getIndices-QwZRm1k, reason: not valid java name */
    public static final IntRange m6213getIndicesQwZRm1k(@NotNull long[] indices) {
        Intrinsics.checkNotNullParameter(indices, "$this$indices");
        return ArraysKt___ArraysKt.getIndices(indices);
    }

    /* JADX INFO: renamed from: getIndices-GBYM_sE, reason: not valid java name */
    public static final IntRange m6211getIndicesGBYM_sE(@NotNull byte[] indices) {
        Intrinsics.checkNotNullParameter(indices, "$this$indices");
        return ArraysKt___ArraysKt.getIndices(indices);
    }

    /* JADX INFO: renamed from: getIndices-rL5Bavg, reason: not valid java name */
    public static final IntRange m6215getIndicesrL5Bavg(@NotNull short[] indices) {
        Intrinsics.checkNotNullParameter(indices, "$this$indices");
        return ArraysKt___ArraysKt.getIndices(indices);
    }

    /* JADX INFO: renamed from: getLastIndex--ajY-9A, reason: not valid java name */
    public static final int m6217getLastIndexajY9A(@NotNull int[] lastIndex) {
        Intrinsics.checkNotNullParameter(lastIndex, "$this$lastIndex");
        return ArraysKt___ArraysKt.getLastIndex(lastIndex);
    }

    /* JADX INFO: renamed from: getLastIndex-QwZRm1k, reason: not valid java name */
    public static final int m6221getLastIndexQwZRm1k(@NotNull long[] lastIndex) {
        Intrinsics.checkNotNullParameter(lastIndex, "$this$lastIndex");
        return ArraysKt___ArraysKt.getLastIndex(lastIndex);
    }

    /* JADX INFO: renamed from: getLastIndex-GBYM_sE, reason: not valid java name */
    public static final int m6219getLastIndexGBYM_sE(@NotNull byte[] lastIndex) {
        Intrinsics.checkNotNullParameter(lastIndex, "$this$lastIndex");
        return ArraysKt___ArraysKt.getLastIndex(lastIndex);
    }

    /* JADX INFO: renamed from: getLastIndex-rL5Bavg, reason: not valid java name */
    public static final int m6223getLastIndexrL5Bavg(@NotNull short[] lastIndex) {
        Intrinsics.checkNotNullParameter(lastIndex, "$this$lastIndex");
        return ArraysKt___ArraysKt.getLastIndex(lastIndex);
    }

    /* JADX INFO: renamed from: plus-uWY9BYg, reason: not valid java name */
    private static final int[] m6434plusuWY9BYg(int[] plus, int i) {
        Intrinsics.checkNotNullParameter(plus, "$this$plus");
        return UIntArray.m5622constructorimpl(ArraysKt___ArraysJvmKt.plus(plus, i));
    }

    /* JADX INFO: renamed from: plus-3uqUaXg, reason: not valid java name */
    private static final long[] m6425plus3uqUaXg(long[] plus, long j) {
        Intrinsics.checkNotNullParameter(plus, "$this$plus");
        return ULongArray.m5701constructorimpl(ArraysKt___ArraysJvmKt.plus(plus, j));
    }

    /* JADX INFO: renamed from: plus-gMuBH34, reason: not valid java name */
    private static final byte[] m6429plusgMuBH34(byte[] plus, byte b) {
        Intrinsics.checkNotNullParameter(plus, "$this$plus");
        return UByteArray.m5543constructorimpl(ArraysKt___ArraysJvmKt.plus(plus, b));
    }

    /* JADX INFO: renamed from: plus-XzdR7RA, reason: not valid java name */
    private static final short[] m6427plusXzdR7RA(short[] plus, short s) {
        Intrinsics.checkNotNullParameter(plus, "$this$plus");
        return UShortArray.m5806constructorimpl(ArraysKt___ArraysJvmKt.plus(plus, s));
    }

    /* JADX INFO: renamed from: plus-CFIt9YE, reason: not valid java name */
    public static final int[] m6426plusCFIt9YE(@NotNull int[] plus, @NotNull Collection<UInt> elements) {
        Intrinsics.checkNotNullParameter(plus, "$this$plus");
        Intrinsics.checkNotNullParameter(elements, "elements");
        int iM5628getSizeimpl = UIntArray.m5628getSizeimpl(plus);
        int[] iArrCopyOf = Arrays.copyOf(plus, UIntArray.m5628getSizeimpl(plus) + elements.size());
        Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
        Iterator<UInt> it2 = elements.iterator();
        while (it2.hasNext()) {
            iArrCopyOf[iM5628getSizeimpl] = it2.next().m5619unboximpl();
            iM5628getSizeimpl++;
        }
        return UIntArray.m5622constructorimpl(iArrCopyOf);
    }

    /* JADX INFO: renamed from: plus-kzHmqpY, reason: not valid java name */
    public static final long[] m6431pluskzHmqpY(@NotNull long[] plus, @NotNull Collection<ULong> elements) {
        Intrinsics.checkNotNullParameter(plus, "$this$plus");
        Intrinsics.checkNotNullParameter(elements, "elements");
        int iM5707getSizeimpl = ULongArray.m5707getSizeimpl(plus);
        long[] jArrCopyOf = Arrays.copyOf(plus, ULongArray.m5707getSizeimpl(plus) + elements.size());
        Intrinsics.checkNotNullExpressionValue(jArrCopyOf, "copyOf(...)");
        Iterator<ULong> it2 = elements.iterator();
        while (it2.hasNext()) {
            jArrCopyOf[iM5707getSizeimpl] = it2.next().m5698unboximpl();
            iM5707getSizeimpl++;
        }
        return ULongArray.m5701constructorimpl(jArrCopyOf);
    }

    /* JADX INFO: renamed from: plus-xo_DsdI, reason: not valid java name */
    public static final byte[] m6436plusxo_DsdI(@NotNull byte[] plus, @NotNull Collection<UByte> elements) {
        Intrinsics.checkNotNullParameter(plus, "$this$plus");
        Intrinsics.checkNotNullParameter(elements, "elements");
        int iM5549getSizeimpl = UByteArray.m5549getSizeimpl(plus);
        byte[] bArrCopyOf = Arrays.copyOf(plus, UByteArray.m5549getSizeimpl(plus) + elements.size());
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
        Iterator<UByte> it2 = elements.iterator();
        while (it2.hasNext()) {
            bArrCopyOf[iM5549getSizeimpl] = it2.next().m5540unboximpl();
            iM5549getSizeimpl++;
        }
        return UByteArray.m5543constructorimpl(bArrCopyOf);
    }

    /* JADX INFO: renamed from: plus-ojwP5H8, reason: not valid java name */
    public static final short[] m6433plusojwP5H8(@NotNull short[] plus, @NotNull Collection<UShort> elements) {
        Intrinsics.checkNotNullParameter(plus, "$this$plus");
        Intrinsics.checkNotNullParameter(elements, "elements");
        int iM5812getSizeimpl = UShortArray.m5812getSizeimpl(plus);
        short[] sArrCopyOf = Arrays.copyOf(plus, UShortArray.m5812getSizeimpl(plus) + elements.size());
        Intrinsics.checkNotNullExpressionValue(sArrCopyOf, "copyOf(...)");
        Iterator<UShort> it2 = elements.iterator();
        while (it2.hasNext()) {
            sArrCopyOf[iM5812getSizeimpl] = it2.next().m5803unboximpl();
            iM5812getSizeimpl++;
        }
        return UShortArray.m5806constructorimpl(sArrCopyOf);
    }

    /* JADX INFO: renamed from: plus-ctEhBpI, reason: not valid java name */
    private static final int[] m6428plusctEhBpI(int[] plus, int[] elements) {
        Intrinsics.checkNotNullParameter(plus, "$this$plus");
        Intrinsics.checkNotNullParameter(elements, "elements");
        return UIntArray.m5622constructorimpl(ArraysKt___ArraysJvmKt.plus(plus, elements));
    }

    /* JADX INFO: renamed from: plus-us8wMrg, reason: not valid java name */
    private static final long[] m6435plusus8wMrg(long[] plus, long[] elements) {
        Intrinsics.checkNotNullParameter(plus, "$this$plus");
        Intrinsics.checkNotNullParameter(elements, "elements");
        return ULongArray.m5701constructorimpl(ArraysKt___ArraysJvmKt.plus(plus, elements));
    }

    /* JADX INFO: renamed from: plus-kdPth3s, reason: not valid java name */
    private static final byte[] m6430pluskdPth3s(byte[] plus, byte[] elements) {
        Intrinsics.checkNotNullParameter(plus, "$this$plus");
        Intrinsics.checkNotNullParameter(elements, "elements");
        return UByteArray.m5543constructorimpl(ArraysKt___ArraysJvmKt.plus(plus, elements));
    }

    /* JADX INFO: renamed from: plus-mazbYpA, reason: not valid java name */
    private static final short[] m6432plusmazbYpA(short[] plus, short[] elements) {
        Intrinsics.checkNotNullParameter(plus, "$this$plus");
        Intrinsics.checkNotNullParameter(elements, "elements");
        return UShortArray.m5806constructorimpl(ArraysKt___ArraysJvmKt.plus(plus, elements));
    }

    /* JADX INFO: renamed from: sort--ajY-9A, reason: not valid java name */
    public static final void m6565sortajY9A(@NotNull int[] sort) {
        Intrinsics.checkNotNullParameter(sort, "$this$sort");
        if (UIntArray.m5628getSizeimpl(sort) > 1) {
            UArraySortingKt.m5942sortArrayoBK06Vg(sort, 0, UIntArray.m5628getSizeimpl(sort));
        }
    }

    /* JADX INFO: renamed from: sort-QwZRm1k, reason: not valid java name */
    public static final void m6573sortQwZRm1k(@NotNull long[] sort) {
        Intrinsics.checkNotNullParameter(sort, "$this$sort");
        if (ULongArray.m5707getSizeimpl(sort) > 1) {
            UArraySortingKt.m5939sortArraynroSd4(sort, 0, ULongArray.m5707getSizeimpl(sort));
        }
    }

    /* JADX INFO: renamed from: sort-GBYM_sE, reason: not valid java name */
    public static final void m6572sortGBYM_sE(@NotNull byte[] sort) {
        Intrinsics.checkNotNullParameter(sort, "$this$sort");
        if (UByteArray.m5549getSizeimpl(sort) > 1) {
            UArraySortingKt.m5940sortArray4UcCI2c(sort, 0, UByteArray.m5549getSizeimpl(sort));
        }
    }

    /* JADX INFO: renamed from: sort-rL5Bavg, reason: not valid java name */
    public static final void m6576sortrL5Bavg(@NotNull short[] sort) {
        Intrinsics.checkNotNullParameter(sort, "$this$sort");
        if (UShortArray.m5812getSizeimpl(sort) > 1) {
            UArraySortingKt.m5941sortArrayAa5vz7o(sort, 0, UShortArray.m5812getSizeimpl(sort));
        }
    }

    /* JADX INFO: renamed from: sort-oBK06Vg$default, reason: not valid java name */
    public static /* synthetic */ void m6575sortoBK06Vg$default(int[] iArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = UIntArray.m5628getSizeimpl(iArr);
        }
        m6574sortoBK06Vg(iArr, i, i2);
    }

    /* JADX INFO: renamed from: sort-oBK06Vg, reason: not valid java name */
    public static final void m6574sortoBK06Vg(@NotNull int[] sort, int i, int i2) {
        Intrinsics.checkNotNullParameter(sort, "$this$sort");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i, i2, UIntArray.m5628getSizeimpl(sort));
        if (i < i2 - 1) {
            UArraySortingKt.m5942sortArrayoBK06Vg(sort, i, i2);
        }
    }

    /* JADX INFO: renamed from: sort--nroSd4$default, reason: not valid java name */
    public static /* synthetic */ void m6567sortnroSd4$default(long[] jArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = ULongArray.m5707getSizeimpl(jArr);
        }
        m6566sortnroSd4(jArr, i, i2);
    }

    /* JADX INFO: renamed from: sort--nroSd4, reason: not valid java name */
    public static final void m6566sortnroSd4(@NotNull long[] sort, int i, int i2) {
        Intrinsics.checkNotNullParameter(sort, "$this$sort");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i, i2, ULongArray.m5707getSizeimpl(sort));
        if (i < i2 - 1) {
            UArraySortingKt.m5939sortArraynroSd4(sort, i, i2);
        }
    }

    /* JADX INFO: renamed from: sort-4UcCI2c$default, reason: not valid java name */
    public static /* synthetic */ void m6569sort4UcCI2c$default(byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = UByteArray.m5549getSizeimpl(bArr);
        }
        m6568sort4UcCI2c(bArr, i, i2);
    }

    /* JADX INFO: renamed from: sort-4UcCI2c, reason: not valid java name */
    public static final void m6568sort4UcCI2c(@NotNull byte[] sort, int i, int i2) {
        Intrinsics.checkNotNullParameter(sort, "$this$sort");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i, i2, UByteArray.m5549getSizeimpl(sort));
        if (i < i2 - 1) {
            UArraySortingKt.m5940sortArray4UcCI2c(sort, i, i2);
        }
    }

    /* JADX INFO: renamed from: sort-Aa5vz7o$default, reason: not valid java name */
    public static /* synthetic */ void m6571sortAa5vz7o$default(short[] sArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = UShortArray.m5812getSizeimpl(sArr);
        }
        m6570sortAa5vz7o(sArr, i, i2);
    }

    /* JADX INFO: renamed from: sort-Aa5vz7o, reason: not valid java name */
    public static final void m6570sortAa5vz7o(@NotNull short[] sort, int i, int i2) {
        Intrinsics.checkNotNullParameter(sort, "$this$sort");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i, i2, UShortArray.m5812getSizeimpl(sort));
        if (i < i2 - 1) {
            UArraySortingKt.m5941sortArrayAa5vz7o(sort, i, i2);
        }
    }

    /* JADX INFO: renamed from: sortDescending-oBK06Vg, reason: not valid java name */
    public static final void m6583sortDescendingoBK06Vg(@NotNull int[] sortDescending, int i, int i2) {
        Intrinsics.checkNotNullParameter(sortDescending, "$this$sortDescending");
        m6574sortoBK06Vg(sortDescending, i, i2);
        ArraysKt___ArraysKt.reverse(sortDescending, i, i2);
    }

    /* JADX INFO: renamed from: sortDescending--nroSd4, reason: not valid java name */
    public static final void m6578sortDescendingnroSd4(@NotNull long[] sortDescending, int i, int i2) {
        Intrinsics.checkNotNullParameter(sortDescending, "$this$sortDescending");
        m6566sortnroSd4(sortDescending, i, i2);
        ArraysKt___ArraysKt.reverse(sortDescending, i, i2);
    }

    /* JADX INFO: renamed from: sortDescending-4UcCI2c, reason: not valid java name */
    public static final void m6579sortDescending4UcCI2c(@NotNull byte[] sortDescending, int i, int i2) {
        Intrinsics.checkNotNullParameter(sortDescending, "$this$sortDescending");
        m6568sort4UcCI2c(sortDescending, i, i2);
        ArraysKt___ArraysKt.reverse(sortDescending, i, i2);
    }

    /* JADX INFO: renamed from: sortDescending-Aa5vz7o, reason: not valid java name */
    public static final void m6580sortDescendingAa5vz7o(@NotNull short[] sortDescending, int i, int i2) {
        Intrinsics.checkNotNullParameter(sortDescending, "$this$sortDescending");
        m6570sortAa5vz7o(sortDescending, i, i2);
        ArraysKt___ArraysKt.reverse(sortDescending, i, i2);
    }

    /* JADX INFO: renamed from: toByteArray-GBYM_sE, reason: not valid java name */
    private static final byte[] m6629toByteArrayGBYM_sE(byte[] toByteArray) {
        Intrinsics.checkNotNullParameter(toByteArray, "$this$toByteArray");
        byte[] bArrCopyOf = Arrays.copyOf(toByteArray, toByteArray.length);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
        return bArrCopyOf;
    }

    /* JADX INFO: renamed from: toIntArray--ajY-9A, reason: not valid java name */
    private static final int[] m6630toIntArrayajY9A(int[] toIntArray) {
        Intrinsics.checkNotNullParameter(toIntArray, "$this$toIntArray");
        int[] iArrCopyOf = Arrays.copyOf(toIntArray, toIntArray.length);
        Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
        return iArrCopyOf;
    }

    /* JADX INFO: renamed from: toLongArray-QwZRm1k, reason: not valid java name */
    private static final long[] m6631toLongArrayQwZRm1k(long[] toLongArray) {
        Intrinsics.checkNotNullParameter(toLongArray, "$this$toLongArray");
        long[] jArrCopyOf = Arrays.copyOf(toLongArray, toLongArray.length);
        Intrinsics.checkNotNullExpressionValue(jArrCopyOf, "copyOf(...)");
        return jArrCopyOf;
    }

    /* JADX INFO: renamed from: toShortArray-rL5Bavg, reason: not valid java name */
    private static final short[] m6632toShortArrayrL5Bavg(short[] toShortArray) {
        Intrinsics.checkNotNullParameter(toShortArray, "$this$toShortArray");
        short[] sArrCopyOf = Arrays.copyOf(toShortArray, toShortArray.length);
        Intrinsics.checkNotNullExpressionValue(sArrCopyOf, "copyOf(...)");
        return sArrCopyOf;
    }

    /* JADX INFO: renamed from: toTypedArray--ajY-9A, reason: not valid java name */
    public static final UInt[] m6633toTypedArrayajY9A(@NotNull int[] toTypedArray) {
        Intrinsics.checkNotNullParameter(toTypedArray, "$this$toTypedArray");
        int iM5628getSizeimpl = UIntArray.m5628getSizeimpl(toTypedArray);
        UInt[] uIntArr = new UInt[iM5628getSizeimpl];
        for (int i = 0; i < iM5628getSizeimpl; i++) {
            uIntArr[i] = UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(toTypedArray, i));
        }
        return uIntArr;
    }

    /* JADX INFO: renamed from: toTypedArray-QwZRm1k, reason: not valid java name */
    public static final ULong[] m6635toTypedArrayQwZRm1k(@NotNull long[] toTypedArray) {
        Intrinsics.checkNotNullParameter(toTypedArray, "$this$toTypedArray");
        int iM5707getSizeimpl = ULongArray.m5707getSizeimpl(toTypedArray);
        ULong[] uLongArr = new ULong[iM5707getSizeimpl];
        for (int i = 0; i < iM5707getSizeimpl; i++) {
            uLongArr[i] = ULong.m5640boximpl(ULongArray.m5706getsVKNKU(toTypedArray, i));
        }
        return uLongArr;
    }

    /* JADX INFO: renamed from: toTypedArray-GBYM_sE, reason: not valid java name */
    public static final UByte[] m6634toTypedArrayGBYM_sE(@NotNull byte[] toTypedArray) {
        Intrinsics.checkNotNullParameter(toTypedArray, "$this$toTypedArray");
        int iM5549getSizeimpl = UByteArray.m5549getSizeimpl(toTypedArray);
        UByte[] uByteArr = new UByte[iM5549getSizeimpl];
        for (int i = 0; i < iM5549getSizeimpl; i++) {
            uByteArr[i] = UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(toTypedArray, i));
        }
        return uByteArr;
    }

    /* JADX INFO: renamed from: toTypedArray-rL5Bavg, reason: not valid java name */
    public static final UShort[] m6636toTypedArrayrL5Bavg(@NotNull short[] toTypedArray) {
        Intrinsics.checkNotNullParameter(toTypedArray, "$this$toTypedArray");
        int iM5812getSizeimpl = UShortArray.m5812getSizeimpl(toTypedArray);
        UShort[] uShortArr = new UShort[iM5812getSizeimpl];
        for (int i = 0; i < iM5812getSizeimpl; i++) {
            uShortArr[i] = UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(toTypedArray, i));
        }
        return uShortArr;
    }

    public static final byte[] toUByteArray(@NotNull UByte[] uByteArr) {
        Intrinsics.checkNotNullParameter(uByteArr, "<this>");
        int length = uByteArr.length;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = uByteArr[i].m5540unboximpl();
        }
        return UByteArray.m5543constructorimpl(bArr);
    }

    private static final byte[] toUByteArray(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
        return UByteArray.m5543constructorimpl(bArrCopyOf);
    }

    public static final int[] toUIntArray(@NotNull UInt[] uIntArr) {
        Intrinsics.checkNotNullParameter(uIntArr, "<this>");
        int length = uIntArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = uIntArr[i].m5619unboximpl();
        }
        return UIntArray.m5622constructorimpl(iArr);
    }

    private static final int[] toUIntArray(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
        Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
        return UIntArray.m5622constructorimpl(iArrCopyOf);
    }

    public static final long[] toULongArray(@NotNull ULong[] uLongArr) {
        Intrinsics.checkNotNullParameter(uLongArr, "<this>");
        int length = uLongArr.length;
        long[] jArr = new long[length];
        for (int i = 0; i < length; i++) {
            jArr[i] = uLongArr[i].m5698unboximpl();
        }
        return ULongArray.m5701constructorimpl(jArr);
    }

    private static final long[] toULongArray(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        long[] jArrCopyOf = Arrays.copyOf(jArr, jArr.length);
        Intrinsics.checkNotNullExpressionValue(jArrCopyOf, "copyOf(...)");
        return ULongArray.m5701constructorimpl(jArrCopyOf);
    }

    public static final short[] toUShortArray(@NotNull UShort[] uShortArr) {
        Intrinsics.checkNotNullParameter(uShortArr, "<this>");
        int length = uShortArr.length;
        short[] sArr = new short[length];
        for (int i = 0; i < length; i++) {
            sArr[i] = uShortArr[i].m5803unboximpl();
        }
        return UShortArray.m5806constructorimpl(sArr);
    }

    private static final short[] toUShortArray(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        short[] sArrCopyOf = Arrays.copyOf(sArr, sArr.length);
        Intrinsics.checkNotNullExpressionValue(sArrCopyOf, "copyOf(...)");
        return UShortArray.m5806constructorimpl(sArrCopyOf);
    }

    /* JADX INFO: renamed from: associateWith-jgv0xPQ, reason: not valid java name */
    private static final <V> Map<UInt, V> m6027associateWithjgv0xPQ(int[] associateWith, Function1<? super UInt, ? extends V> valueSelector) {
        Intrinsics.checkNotNullParameter(associateWith, "$this$associateWith");
        Intrinsics.checkNotNullParameter(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsJVMKt.mapCapacity(UIntArray.m5628getSizeimpl(associateWith)), 16));
        int iM5628getSizeimpl = UIntArray.m5628getSizeimpl(associateWith);
        for (int i = 0; i < iM5628getSizeimpl; i++) {
            int iM5627getpVg5ArA = UIntArray.m5627getpVg5ArA(associateWith, i);
            linkedHashMap.put(UInt.m5561boximpl(iM5627getpVg5ArA), valueSelector.invoke(UInt.m5561boximpl(iM5627getpVg5ArA)));
        }
        return linkedHashMap;
    }

    /* JADX INFO: renamed from: associateWith-MShoTSo, reason: not valid java name */
    private static final <V> Map<ULong, V> m6026associateWithMShoTSo(long[] associateWith, Function1<? super ULong, ? extends V> valueSelector) {
        Intrinsics.checkNotNullParameter(associateWith, "$this$associateWith");
        Intrinsics.checkNotNullParameter(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsJVMKt.mapCapacity(ULongArray.m5707getSizeimpl(associateWith)), 16));
        int iM5707getSizeimpl = ULongArray.m5707getSizeimpl(associateWith);
        for (int i = 0; i < iM5707getSizeimpl; i++) {
            long jM5706getsVKNKU = ULongArray.m5706getsVKNKU(associateWith, i);
            linkedHashMap.put(ULong.m5640boximpl(jM5706getsVKNKU), valueSelector.invoke(ULong.m5640boximpl(jM5706getsVKNKU)));
        }
        return linkedHashMap;
    }

    /* JADX INFO: renamed from: associateWith-JOV_ifY, reason: not valid java name */
    private static final <V> Map<UByte, V> m6025associateWithJOV_ifY(byte[] associateWith, Function1<? super UByte, ? extends V> valueSelector) {
        Intrinsics.checkNotNullParameter(associateWith, "$this$associateWith");
        Intrinsics.checkNotNullParameter(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsJVMKt.mapCapacity(UByteArray.m5549getSizeimpl(associateWith)), 16));
        int iM5549getSizeimpl = UByteArray.m5549getSizeimpl(associateWith);
        for (int i = 0; i < iM5549getSizeimpl; i++) {
            byte bM5548getw2LRezQ = UByteArray.m5548getw2LRezQ(associateWith, i);
            linkedHashMap.put(UByte.m5484boximpl(bM5548getw2LRezQ), valueSelector.invoke(UByte.m5484boximpl(bM5548getw2LRezQ)));
        }
        return linkedHashMap;
    }

    /* JADX INFO: renamed from: associateWith-xTcfx_M, reason: not valid java name */
    private static final <V> Map<UShort, V> m6028associateWithxTcfx_M(short[] associateWith, Function1<? super UShort, ? extends V> valueSelector) {
        Intrinsics.checkNotNullParameter(associateWith, "$this$associateWith");
        Intrinsics.checkNotNullParameter(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsJVMKt.mapCapacity(UShortArray.m5812getSizeimpl(associateWith)), 16));
        int iM5812getSizeimpl = UShortArray.m5812getSizeimpl(associateWith);
        for (int i = 0; i < iM5812getSizeimpl; i++) {
            short sM5811getMh2AYeg = UShortArray.m5811getMh2AYeg(associateWith, i);
            linkedHashMap.put(UShort.m5747boximpl(sM5811getMh2AYeg), valueSelector.invoke(UShort.m5747boximpl(sM5811getMh2AYeg)));
        }
        return linkedHashMap;
    }

    /* JADX INFO: renamed from: associateWithTo-4D70W2E, reason: not valid java name */
    private static final <V, M extends Map<? super UInt, ? super V>> M m6029associateWithTo4D70W2E(int[] associateWithTo, M destination, Function1<? super UInt, ? extends V> valueSelector) {
        Intrinsics.checkNotNullParameter(associateWithTo, "$this$associateWithTo");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(valueSelector, "valueSelector");
        int iM5628getSizeimpl = UIntArray.m5628getSizeimpl(associateWithTo);
        for (int i = 0; i < iM5628getSizeimpl; i++) {
            int iM5627getpVg5ArA = UIntArray.m5627getpVg5ArA(associateWithTo, i);
            destination.put(UInt.m5561boximpl(iM5627getpVg5ArA), valueSelector.invoke(UInt.m5561boximpl(iM5627getpVg5ArA)));
        }
        return destination;
    }

    /* JADX INFO: renamed from: associateWithTo-X6OPwNk, reason: not valid java name */
    private static final <V, M extends Map<? super ULong, ? super V>> M m6031associateWithToX6OPwNk(long[] associateWithTo, M destination, Function1<? super ULong, ? extends V> valueSelector) {
        Intrinsics.checkNotNullParameter(associateWithTo, "$this$associateWithTo");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(valueSelector, "valueSelector");
        int iM5707getSizeimpl = ULongArray.m5707getSizeimpl(associateWithTo);
        for (int i = 0; i < iM5707getSizeimpl; i++) {
            long jM5706getsVKNKU = ULongArray.m5706getsVKNKU(associateWithTo, i);
            destination.put(ULong.m5640boximpl(jM5706getsVKNKU), valueSelector.invoke(ULong.m5640boximpl(jM5706getsVKNKU)));
        }
        return destination;
    }

    /* JADX INFO: renamed from: associateWithTo-H21X9dk, reason: not valid java name */
    private static final <V, M extends Map<? super UByte, ? super V>> M m6030associateWithToH21X9dk(byte[] associateWithTo, M destination, Function1<? super UByte, ? extends V> valueSelector) {
        Intrinsics.checkNotNullParameter(associateWithTo, "$this$associateWithTo");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(valueSelector, "valueSelector");
        int iM5549getSizeimpl = UByteArray.m5549getSizeimpl(associateWithTo);
        for (int i = 0; i < iM5549getSizeimpl; i++) {
            byte bM5548getw2LRezQ = UByteArray.m5548getw2LRezQ(associateWithTo, i);
            destination.put(UByte.m5484boximpl(bM5548getw2LRezQ), valueSelector.invoke(UByte.m5484boximpl(bM5548getw2LRezQ)));
        }
        return destination;
    }

    /* JADX INFO: renamed from: associateWithTo-ciTST-8, reason: not valid java name */
    private static final <V, M extends Map<? super UShort, ? super V>> M m6032associateWithTociTST8(short[] associateWithTo, M destination, Function1<? super UShort, ? extends V> valueSelector) {
        Intrinsics.checkNotNullParameter(associateWithTo, "$this$associateWithTo");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(valueSelector, "valueSelector");
        int iM5812getSizeimpl = UShortArray.m5812getSizeimpl(associateWithTo);
        for (int i = 0; i < iM5812getSizeimpl; i++) {
            short sM5811getMh2AYeg = UShortArray.m5811getMh2AYeg(associateWithTo, i);
            destination.put(UShort.m5747boximpl(sM5811getMh2AYeg), valueSelector.invoke(UShort.m5747boximpl(sM5811getMh2AYeg)));
        }
        return destination;
    }

    /* JADX INFO: renamed from: flatMap-jgv0xPQ, reason: not valid java name */
    private static final <R> List<R> m6171flatMapjgv0xPQ(int[] flatMap, Function1<? super UInt, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(flatMap, "$this$flatMap");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int iM5628getSizeimpl = UIntArray.m5628getSizeimpl(flatMap);
        for (int i = 0; i < iM5628getSizeimpl; i++) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, transform.invoke(UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(flatMap, i))));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: flatMap-MShoTSo, reason: not valid java name */
    private static final <R> List<R> m6170flatMapMShoTSo(long[] flatMap, Function1<? super ULong, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(flatMap, "$this$flatMap");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int iM5707getSizeimpl = ULongArray.m5707getSizeimpl(flatMap);
        for (int i = 0; i < iM5707getSizeimpl; i++) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, transform.invoke(ULong.m5640boximpl(ULongArray.m5706getsVKNKU(flatMap, i))));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: flatMap-JOV_ifY, reason: not valid java name */
    private static final <R> List<R> m6169flatMapJOV_ifY(byte[] flatMap, Function1<? super UByte, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(flatMap, "$this$flatMap");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int iM5549getSizeimpl = UByteArray.m5549getSizeimpl(flatMap);
        for (int i = 0; i < iM5549getSizeimpl; i++) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, transform.invoke(UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(flatMap, i))));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: flatMap-xTcfx_M, reason: not valid java name */
    private static final <R> List<R> m6172flatMapxTcfx_M(short[] flatMap, Function1<? super UShort, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(flatMap, "$this$flatMap");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int iM5812getSizeimpl = UShortArray.m5812getSizeimpl(flatMap);
        for (int i = 0; i < iM5812getSizeimpl; i++) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, transform.invoke(UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(flatMap, i))));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: flatMapIndexed-WyvcNBI, reason: not valid java name */
    private static final <R> List<R> m6174flatMapIndexedWyvcNBI(int[] flatMapIndexed, Function2<? super Integer, ? super UInt, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(flatMapIndexed, "$this$flatMapIndexed");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int iM5628getSizeimpl = UIntArray.m5628getSizeimpl(flatMapIndexed);
        int i = 0;
        int i2 = 0;
        while (i < iM5628getSizeimpl) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, transform.invoke(Integer.valueOf(i2), UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(flatMapIndexed, i))));
            i++;
            i2++;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: flatMapIndexed-s8dVfGU, reason: not valid java name */
    private static final <R> List<R> m6175flatMapIndexeds8dVfGU(long[] flatMapIndexed, Function2<? super Integer, ? super ULong, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(flatMapIndexed, "$this$flatMapIndexed");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int iM5707getSizeimpl = ULongArray.m5707getSizeimpl(flatMapIndexed);
        int i = 0;
        int i2 = 0;
        while (i < iM5707getSizeimpl) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, transform.invoke(Integer.valueOf(i2), ULong.m5640boximpl(ULongArray.m5706getsVKNKU(flatMapIndexed, i))));
            i++;
            i2++;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: flatMapIndexed-ELGow60, reason: not valid java name */
    private static final <R> List<R> m6173flatMapIndexedELGow60(byte[] flatMapIndexed, Function2<? super Integer, ? super UByte, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(flatMapIndexed, "$this$flatMapIndexed");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int iM5549getSizeimpl = UByteArray.m5549getSizeimpl(flatMapIndexed);
        int i = 0;
        int i2 = 0;
        while (i < iM5549getSizeimpl) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, transform.invoke(Integer.valueOf(i2), UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(flatMapIndexed, i))));
            i++;
            i2++;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: flatMapIndexed-xzaTVY8, reason: not valid java name */
    private static final <R> List<R> m6176flatMapIndexedxzaTVY8(short[] flatMapIndexed, Function2<? super Integer, ? super UShort, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(flatMapIndexed, "$this$flatMapIndexed");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int iM5812getSizeimpl = UShortArray.m5812getSizeimpl(flatMapIndexed);
        int i = 0;
        int i2 = 0;
        while (i < iM5812getSizeimpl) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, transform.invoke(Integer.valueOf(i2), UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(flatMapIndexed, i))));
            i++;
            i2++;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: flatMapIndexedTo--6EtJGI, reason: not valid java name */
    private static final <R, C extends Collection<? super R>> C m6177flatMapIndexedTo6EtJGI(int[] flatMapIndexedTo, C destination, Function2<? super Integer, ? super UInt, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(flatMapIndexedTo, "$this$flatMapIndexedTo");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iM5628getSizeimpl = UIntArray.m5628getSizeimpl(flatMapIndexedTo);
        int i = 0;
        int i2 = 0;
        while (i < iM5628getSizeimpl) {
            CollectionsKt__MutableCollectionsKt.addAll(destination, transform.invoke(Integer.valueOf(i2), UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(flatMapIndexedTo, i))));
            i++;
            i2++;
        }
        return destination;
    }

    /* JADX INFO: renamed from: flatMapIndexedTo-pe2Q0Dw, reason: not valid java name */
    private static final <R, C extends Collection<? super R>> C m6180flatMapIndexedTope2Q0Dw(long[] flatMapIndexedTo, C destination, Function2<? super Integer, ? super ULong, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(flatMapIndexedTo, "$this$flatMapIndexedTo");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iM5707getSizeimpl = ULongArray.m5707getSizeimpl(flatMapIndexedTo);
        int i = 0;
        int i2 = 0;
        while (i < iM5707getSizeimpl) {
            CollectionsKt__MutableCollectionsKt.addAll(destination, transform.invoke(Integer.valueOf(i2), ULong.m5640boximpl(ULongArray.m5706getsVKNKU(flatMapIndexedTo, i))));
            i++;
            i2++;
        }
        return destination;
    }

    /* JADX INFO: renamed from: flatMapIndexedTo-eNpIKz8, reason: not valid java name */
    private static final <R, C extends Collection<? super R>> C m6179flatMapIndexedToeNpIKz8(byte[] flatMapIndexedTo, C destination, Function2<? super Integer, ? super UByte, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(flatMapIndexedTo, "$this$flatMapIndexedTo");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iM5549getSizeimpl = UByteArray.m5549getSizeimpl(flatMapIndexedTo);
        int i = 0;
        int i2 = 0;
        while (i < iM5549getSizeimpl) {
            CollectionsKt__MutableCollectionsKt.addAll(destination, transform.invoke(Integer.valueOf(i2), UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(flatMapIndexedTo, i))));
            i++;
            i2++;
        }
        return destination;
    }

    /* JADX INFO: renamed from: flatMapIndexedTo-QqktQ3k, reason: not valid java name */
    private static final <R, C extends Collection<? super R>> C m6178flatMapIndexedToQqktQ3k(short[] flatMapIndexedTo, C destination, Function2<? super Integer, ? super UShort, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(flatMapIndexedTo, "$this$flatMapIndexedTo");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iM5812getSizeimpl = UShortArray.m5812getSizeimpl(flatMapIndexedTo);
        int i = 0;
        int i2 = 0;
        while (i < iM5812getSizeimpl) {
            CollectionsKt__MutableCollectionsKt.addAll(destination, transform.invoke(Integer.valueOf(i2), UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(flatMapIndexedTo, i))));
            i++;
            i2++;
        }
        return destination;
    }

    /* JADX INFO: renamed from: flatMapTo-wU5IKMo, reason: not valid java name */
    private static final <R, C extends Collection<? super R>> C m6183flatMapTowU5IKMo(int[] flatMapTo, C destination, Function1<? super UInt, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(flatMapTo, "$this$flatMapTo");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iM5628getSizeimpl = UIntArray.m5628getSizeimpl(flatMapTo);
        for (int i = 0; i < iM5628getSizeimpl; i++) {
            CollectionsKt__MutableCollectionsKt.addAll(destination, transform.invoke(UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(flatMapTo, i))));
        }
        return destination;
    }

    /* JADX INFO: renamed from: flatMapTo-HqK1JgA, reason: not valid java name */
    private static final <R, C extends Collection<? super R>> C m6181flatMapToHqK1JgA(long[] flatMapTo, C destination, Function1<? super ULong, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(flatMapTo, "$this$flatMapTo");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iM5707getSizeimpl = ULongArray.m5707getSizeimpl(flatMapTo);
        for (int i = 0; i < iM5707getSizeimpl; i++) {
            CollectionsKt__MutableCollectionsKt.addAll(destination, transform.invoke(ULong.m5640boximpl(ULongArray.m5706getsVKNKU(flatMapTo, i))));
        }
        return destination;
    }

    /* JADX INFO: renamed from: flatMapTo-wzUQCXU, reason: not valid java name */
    private static final <R, C extends Collection<? super R>> C m6184flatMapTowzUQCXU(byte[] flatMapTo, C destination, Function1<? super UByte, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(flatMapTo, "$this$flatMapTo");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iM5549getSizeimpl = UByteArray.m5549getSizeimpl(flatMapTo);
        for (int i = 0; i < iM5549getSizeimpl; i++) {
            CollectionsKt__MutableCollectionsKt.addAll(destination, transform.invoke(UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(flatMapTo, i))));
        }
        return destination;
    }

    /* JADX INFO: renamed from: flatMapTo-oEOeDjA, reason: not valid java name */
    private static final <R, C extends Collection<? super R>> C m6182flatMapTooEOeDjA(short[] flatMapTo, C destination, Function1<? super UShort, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(flatMapTo, "$this$flatMapTo");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iM5812getSizeimpl = UShortArray.m5812getSizeimpl(flatMapTo);
        for (int i = 0; i < iM5812getSizeimpl; i++) {
            CollectionsKt__MutableCollectionsKt.addAll(destination, transform.invoke(UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(flatMapTo, i))));
        }
        return destination;
    }

    /* JADX INFO: renamed from: groupBy-jgv0xPQ, reason: not valid java name */
    private static final <K> Map<K, List<UInt>> m6239groupByjgv0xPQ(int[] groupBy, Function1<? super UInt, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(groupBy, "$this$groupBy");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int iM5628getSizeimpl = UIntArray.m5628getSizeimpl(groupBy);
        for (int i = 0; i < iM5628getSizeimpl; i++) {
            int iM5627getpVg5ArA = UIntArray.m5627getpVg5ArA(groupBy, i);
            K kInvoke = keySelector.invoke(UInt.m5561boximpl(iM5627getpVg5ArA));
            Object arrayList = linkedHashMap.get(kInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(kInvoke, arrayList);
            }
            ((List) arrayList).add(UInt.m5561boximpl(iM5627getpVg5ArA));
        }
        return linkedHashMap;
    }

    /* JADX INFO: renamed from: groupBy-MShoTSo, reason: not valid java name */
    private static final <K> Map<K, List<ULong>> m6237groupByMShoTSo(long[] groupBy, Function1<? super ULong, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(groupBy, "$this$groupBy");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int iM5707getSizeimpl = ULongArray.m5707getSizeimpl(groupBy);
        for (int i = 0; i < iM5707getSizeimpl; i++) {
            long jM5706getsVKNKU = ULongArray.m5706getsVKNKU(groupBy, i);
            K kInvoke = keySelector.invoke(ULong.m5640boximpl(jM5706getsVKNKU));
            Object arrayList = linkedHashMap.get(kInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(kInvoke, arrayList);
            }
            ((List) arrayList).add(ULong.m5640boximpl(jM5706getsVKNKU));
        }
        return linkedHashMap;
    }

    /* JADX INFO: renamed from: groupBy-JOV_ifY, reason: not valid java name */
    private static final <K> Map<K, List<UByte>> m6235groupByJOV_ifY(byte[] groupBy, Function1<? super UByte, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(groupBy, "$this$groupBy");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int iM5549getSizeimpl = UByteArray.m5549getSizeimpl(groupBy);
        for (int i = 0; i < iM5549getSizeimpl; i++) {
            byte bM5548getw2LRezQ = UByteArray.m5548getw2LRezQ(groupBy, i);
            K kInvoke = keySelector.invoke(UByte.m5484boximpl(bM5548getw2LRezQ));
            Object arrayList = linkedHashMap.get(kInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(kInvoke, arrayList);
            }
            ((List) arrayList).add(UByte.m5484boximpl(bM5548getw2LRezQ));
        }
        return linkedHashMap;
    }

    /* JADX INFO: renamed from: groupBy-xTcfx_M, reason: not valid java name */
    private static final <K> Map<K, List<UShort>> m6240groupByxTcfx_M(short[] groupBy, Function1<? super UShort, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(groupBy, "$this$groupBy");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int iM5812getSizeimpl = UShortArray.m5812getSizeimpl(groupBy);
        for (int i = 0; i < iM5812getSizeimpl; i++) {
            short sM5811getMh2AYeg = UShortArray.m5811getMh2AYeg(groupBy, i);
            K kInvoke = keySelector.invoke(UShort.m5747boximpl(sM5811getMh2AYeg));
            Object arrayList = linkedHashMap.get(kInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(kInvoke, arrayList);
            }
            ((List) arrayList).add(UShort.m5747boximpl(sM5811getMh2AYeg));
        }
        return linkedHashMap;
    }

    /* JADX INFO: renamed from: groupBy-L4rlFek, reason: not valid java name */
    private static final <K, V> Map<K, List<V>> m6236groupByL4rlFek(int[] groupBy, Function1<? super UInt, ? extends K> keySelector, Function1<? super UInt, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(groupBy, "$this$groupBy");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int iM5628getSizeimpl = UIntArray.m5628getSizeimpl(groupBy);
        for (int i = 0; i < iM5628getSizeimpl; i++) {
            int iM5627getpVg5ArA = UIntArray.m5627getpVg5ArA(groupBy, i);
            K kInvoke = keySelector.invoke(UInt.m5561boximpl(iM5627getpVg5ArA));
            List<V> arrayList = linkedHashMap.get(kInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                linkedHashMap.put(kInvoke, arrayList);
            }
            arrayList.add(valueTransform.invoke(UInt.m5561boximpl(iM5627getpVg5ArA)));
        }
        return linkedHashMap;
    }

    /* JADX INFO: renamed from: groupBy--_j2Y-Q, reason: not valid java name */
    private static final <K, V> Map<K, List<V>> m6233groupBy_j2YQ(long[] groupBy, Function1<? super ULong, ? extends K> keySelector, Function1<? super ULong, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(groupBy, "$this$groupBy");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int iM5707getSizeimpl = ULongArray.m5707getSizeimpl(groupBy);
        for (int i = 0; i < iM5707getSizeimpl; i++) {
            long jM5706getsVKNKU = ULongArray.m5706getsVKNKU(groupBy, i);
            K kInvoke = keySelector.invoke(ULong.m5640boximpl(jM5706getsVKNKU));
            List<V> arrayList = linkedHashMap.get(kInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                linkedHashMap.put(kInvoke, arrayList);
            }
            arrayList.add(valueTransform.invoke(ULong.m5640boximpl(jM5706getsVKNKU)));
        }
        return linkedHashMap;
    }

    /* JADX INFO: renamed from: groupBy-bBsjw1Y, reason: not valid java name */
    private static final <K, V> Map<K, List<V>> m6238groupBybBsjw1Y(byte[] groupBy, Function1<? super UByte, ? extends K> keySelector, Function1<? super UByte, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(groupBy, "$this$groupBy");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int iM5549getSizeimpl = UByteArray.m5549getSizeimpl(groupBy);
        for (int i = 0; i < iM5549getSizeimpl; i++) {
            byte bM5548getw2LRezQ = UByteArray.m5548getw2LRezQ(groupBy, i);
            K kInvoke = keySelector.invoke(UByte.m5484boximpl(bM5548getw2LRezQ));
            List<V> arrayList = linkedHashMap.get(kInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                linkedHashMap.put(kInvoke, arrayList);
            }
            arrayList.add(valueTransform.invoke(UByte.m5484boximpl(bM5548getw2LRezQ)));
        }
        return linkedHashMap;
    }

    /* JADX INFO: renamed from: groupBy-3bBvP4M, reason: not valid java name */
    private static final <K, V> Map<K, List<V>> m6234groupBy3bBvP4M(short[] groupBy, Function1<? super UShort, ? extends K> keySelector, Function1<? super UShort, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(groupBy, "$this$groupBy");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int iM5812getSizeimpl = UShortArray.m5812getSizeimpl(groupBy);
        for (int i = 0; i < iM5812getSizeimpl; i++) {
            short sM5811getMh2AYeg = UShortArray.m5811getMh2AYeg(groupBy, i);
            K kInvoke = keySelector.invoke(UShort.m5747boximpl(sM5811getMh2AYeg));
            List<V> arrayList = linkedHashMap.get(kInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                linkedHashMap.put(kInvoke, arrayList);
            }
            arrayList.add(valueTransform.invoke(UShort.m5747boximpl(sM5811getMh2AYeg)));
        }
        return linkedHashMap;
    }

    /* JADX INFO: renamed from: groupByTo-4D70W2E, reason: not valid java name */
    private static final <K, M extends Map<? super K, List<UInt>>> M m6241groupByTo4D70W2E(int[] groupByTo, M destination, Function1<? super UInt, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(groupByTo, "$this$groupByTo");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        int iM5628getSizeimpl = UIntArray.m5628getSizeimpl(groupByTo);
        for (int i = 0; i < iM5628getSizeimpl; i++) {
            int iM5627getpVg5ArA = UIntArray.m5627getpVg5ArA(groupByTo, i);
            K kInvoke = keySelector.invoke(UInt.m5561boximpl(iM5627getpVg5ArA));
            Object arrayList = destination.get(kInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(kInvoke, arrayList);
            }
            ((List) arrayList).add(UInt.m5561boximpl(iM5627getpVg5ArA));
        }
        return destination;
    }

    /* JADX INFO: renamed from: groupByTo-X6OPwNk, reason: not valid java name */
    private static final <K, M extends Map<? super K, List<ULong>>> M m6245groupByToX6OPwNk(long[] groupByTo, M destination, Function1<? super ULong, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(groupByTo, "$this$groupByTo");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        int iM5707getSizeimpl = ULongArray.m5707getSizeimpl(groupByTo);
        for (int i = 0; i < iM5707getSizeimpl; i++) {
            long jM5706getsVKNKU = ULongArray.m5706getsVKNKU(groupByTo, i);
            K kInvoke = keySelector.invoke(ULong.m5640boximpl(jM5706getsVKNKU));
            Object arrayList = destination.get(kInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(kInvoke, arrayList);
            }
            ((List) arrayList).add(ULong.m5640boximpl(jM5706getsVKNKU));
        }
        return destination;
    }

    /* JADX INFO: renamed from: groupByTo-H21X9dk, reason: not valid java name */
    private static final <K, M extends Map<? super K, List<UByte>>> M m6242groupByToH21X9dk(byte[] groupByTo, M destination, Function1<? super UByte, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(groupByTo, "$this$groupByTo");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        int iM5549getSizeimpl = UByteArray.m5549getSizeimpl(groupByTo);
        for (int i = 0; i < iM5549getSizeimpl; i++) {
            byte bM5548getw2LRezQ = UByteArray.m5548getw2LRezQ(groupByTo, i);
            K kInvoke = keySelector.invoke(UByte.m5484boximpl(bM5548getw2LRezQ));
            Object arrayList = destination.get(kInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(kInvoke, arrayList);
            }
            ((List) arrayList).add(UByte.m5484boximpl(bM5548getw2LRezQ));
        }
        return destination;
    }

    /* JADX INFO: renamed from: groupByTo-ciTST-8, reason: not valid java name */
    private static final <K, M extends Map<? super K, List<UShort>>> M m6246groupByTociTST8(short[] groupByTo, M destination, Function1<? super UShort, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(groupByTo, "$this$groupByTo");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        int iM5812getSizeimpl = UShortArray.m5812getSizeimpl(groupByTo);
        for (int i = 0; i < iM5812getSizeimpl; i++) {
            short sM5811getMh2AYeg = UShortArray.m5811getMh2AYeg(groupByTo, i);
            K kInvoke = keySelector.invoke(UShort.m5747boximpl(sM5811getMh2AYeg));
            Object arrayList = destination.get(kInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(kInvoke, arrayList);
            }
            ((List) arrayList).add(UShort.m5747boximpl(sM5811getMh2AYeg));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: groupByTo-JM6gNCM, reason: not valid java name */
    private static final <K, V, M extends Map<? super K, List<V>>> M m6243groupByToJM6gNCM(int[] groupByTo, M destination, Function1<? super UInt, ? extends K> keySelector, Function1<? super UInt, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(groupByTo, "$this$groupByTo");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        int iM5628getSizeimpl = UIntArray.m5628getSizeimpl(groupByTo);
        for (int i = 0; i < iM5628getSizeimpl; i++) {
            int iM5627getpVg5ArA = UIntArray.m5627getpVg5ArA(groupByTo, i);
            K kInvoke = keySelector.invoke(UInt.m5561boximpl(iM5627getpVg5ArA));
            Object arrayList = destination.get(kInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(kInvoke, arrayList);
            }
            ((List) arrayList).add(valueTransform.invoke(UInt.m5561boximpl(iM5627getpVg5ArA)));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: groupByTo-QxgOkWg, reason: not valid java name */
    private static final <K, V, M extends Map<? super K, List<V>>> M m6244groupByToQxgOkWg(long[] groupByTo, M destination, Function1<? super ULong, ? extends K> keySelector, Function1<? super ULong, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(groupByTo, "$this$groupByTo");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        int iM5707getSizeimpl = ULongArray.m5707getSizeimpl(groupByTo);
        for (int i = 0; i < iM5707getSizeimpl; i++) {
            long jM5706getsVKNKU = ULongArray.m5706getsVKNKU(groupByTo, i);
            K kInvoke = keySelector.invoke(ULong.m5640boximpl(jM5706getsVKNKU));
            Object arrayList = destination.get(kInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(kInvoke, arrayList);
            }
            ((List) arrayList).add(valueTransform.invoke(ULong.m5640boximpl(jM5706getsVKNKU)));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: groupByTo-qOZmbk8, reason: not valid java name */
    private static final <K, V, M extends Map<? super K, List<V>>> M m6248groupByToqOZmbk8(byte[] groupByTo, M destination, Function1<? super UByte, ? extends K> keySelector, Function1<? super UByte, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(groupByTo, "$this$groupByTo");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        int iM5549getSizeimpl = UByteArray.m5549getSizeimpl(groupByTo);
        for (int i = 0; i < iM5549getSizeimpl; i++) {
            byte bM5548getw2LRezQ = UByteArray.m5548getw2LRezQ(groupByTo, i);
            K kInvoke = keySelector.invoke(UByte.m5484boximpl(bM5548getw2LRezQ));
            Object arrayList = destination.get(kInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(kInvoke, arrayList);
            }
            ((List) arrayList).add(valueTransform.invoke(UByte.m5484boximpl(bM5548getw2LRezQ)));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: groupByTo-q8RuPII, reason: not valid java name */
    private static final <K, V, M extends Map<? super K, List<V>>> M m6247groupByToq8RuPII(short[] groupByTo, M destination, Function1<? super UShort, ? extends K> keySelector, Function1<? super UShort, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(groupByTo, "$this$groupByTo");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        int iM5812getSizeimpl = UShortArray.m5812getSizeimpl(groupByTo);
        for (int i = 0; i < iM5812getSizeimpl; i++) {
            short sM5811getMh2AYeg = UShortArray.m5811getMh2AYeg(groupByTo, i);
            K kInvoke = keySelector.invoke(UShort.m5747boximpl(sM5811getMh2AYeg));
            Object arrayList = destination.get(kInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(kInvoke, arrayList);
            }
            ((List) arrayList).add(valueTransform.invoke(UShort.m5747boximpl(sM5811getMh2AYeg)));
        }
        return destination;
    }

    /* JADX INFO: renamed from: map-jgv0xPQ, reason: not valid java name */
    private static final <R> List<R> m6283mapjgv0xPQ(int[] map, Function1<? super UInt, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(map, "$this$map");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(UIntArray.m5628getSizeimpl(map));
        int iM5628getSizeimpl = UIntArray.m5628getSizeimpl(map);
        for (int i = 0; i < iM5628getSizeimpl; i++) {
            arrayList.add(transform.invoke(UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(map, i))));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: map-MShoTSo, reason: not valid java name */
    private static final <R> List<R> m6282mapMShoTSo(long[] map, Function1<? super ULong, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(map, "$this$map");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(ULongArray.m5707getSizeimpl(map));
        int iM5707getSizeimpl = ULongArray.m5707getSizeimpl(map);
        for (int i = 0; i < iM5707getSizeimpl; i++) {
            arrayList.add(transform.invoke(ULong.m5640boximpl(ULongArray.m5706getsVKNKU(map, i))));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: map-JOV_ifY, reason: not valid java name */
    private static final <R> List<R> m6281mapJOV_ifY(byte[] map, Function1<? super UByte, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(map, "$this$map");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(UByteArray.m5549getSizeimpl(map));
        int iM5549getSizeimpl = UByteArray.m5549getSizeimpl(map);
        for (int i = 0; i < iM5549getSizeimpl; i++) {
            arrayList.add(transform.invoke(UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(map, i))));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: map-xTcfx_M, reason: not valid java name */
    private static final <R> List<R> m6284mapxTcfx_M(short[] map, Function1<? super UShort, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(map, "$this$map");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(UShortArray.m5812getSizeimpl(map));
        int iM5812getSizeimpl = UShortArray.m5812getSizeimpl(map);
        for (int i = 0; i < iM5812getSizeimpl; i++) {
            arrayList.add(transform.invoke(UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(map, i))));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: mapIndexed-WyvcNBI, reason: not valid java name */
    private static final <R> List<R> m6286mapIndexedWyvcNBI(int[] mapIndexed, Function2<? super Integer, ? super UInt, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(mapIndexed, "$this$mapIndexed");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(UIntArray.m5628getSizeimpl(mapIndexed));
        int iM5628getSizeimpl = UIntArray.m5628getSizeimpl(mapIndexed);
        int i = 0;
        int i2 = 0;
        while (i < iM5628getSizeimpl) {
            arrayList.add(transform.invoke(Integer.valueOf(i2), UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(mapIndexed, i))));
            i++;
            i2++;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: mapIndexed-s8dVfGU, reason: not valid java name */
    private static final <R> List<R> m6287mapIndexeds8dVfGU(long[] mapIndexed, Function2<? super Integer, ? super ULong, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(mapIndexed, "$this$mapIndexed");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(ULongArray.m5707getSizeimpl(mapIndexed));
        int iM5707getSizeimpl = ULongArray.m5707getSizeimpl(mapIndexed);
        int i = 0;
        int i2 = 0;
        while (i < iM5707getSizeimpl) {
            arrayList.add(transform.invoke(Integer.valueOf(i2), ULong.m5640boximpl(ULongArray.m5706getsVKNKU(mapIndexed, i))));
            i++;
            i2++;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: mapIndexed-ELGow60, reason: not valid java name */
    private static final <R> List<R> m6285mapIndexedELGow60(byte[] mapIndexed, Function2<? super Integer, ? super UByte, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(mapIndexed, "$this$mapIndexed");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(UByteArray.m5549getSizeimpl(mapIndexed));
        int iM5549getSizeimpl = UByteArray.m5549getSizeimpl(mapIndexed);
        int i = 0;
        int i2 = 0;
        while (i < iM5549getSizeimpl) {
            arrayList.add(transform.invoke(Integer.valueOf(i2), UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(mapIndexed, i))));
            i++;
            i2++;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: mapIndexed-xzaTVY8, reason: not valid java name */
    private static final <R> List<R> m6288mapIndexedxzaTVY8(short[] mapIndexed, Function2<? super Integer, ? super UShort, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(mapIndexed, "$this$mapIndexed");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(UShortArray.m5812getSizeimpl(mapIndexed));
        int iM5812getSizeimpl = UShortArray.m5812getSizeimpl(mapIndexed);
        int i = 0;
        int i2 = 0;
        while (i < iM5812getSizeimpl) {
            arrayList.add(transform.invoke(Integer.valueOf(i2), UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(mapIndexed, i))));
            i++;
            i2++;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: mapIndexedTo--6EtJGI, reason: not valid java name */
    private static final <R, C extends Collection<? super R>> C m6289mapIndexedTo6EtJGI(int[] mapIndexedTo, C destination, Function2<? super Integer, ? super UInt, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(mapIndexedTo, "$this$mapIndexedTo");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iM5628getSizeimpl = UIntArray.m5628getSizeimpl(mapIndexedTo);
        int i = 0;
        int i2 = 0;
        while (i < iM5628getSizeimpl) {
            destination.add(transform.invoke(Integer.valueOf(i2), UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(mapIndexedTo, i))));
            i++;
            i2++;
        }
        return destination;
    }

    /* JADX INFO: renamed from: mapIndexedTo-pe2Q0Dw, reason: not valid java name */
    private static final <R, C extends Collection<? super R>> C m6292mapIndexedTope2Q0Dw(long[] mapIndexedTo, C destination, Function2<? super Integer, ? super ULong, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(mapIndexedTo, "$this$mapIndexedTo");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iM5707getSizeimpl = ULongArray.m5707getSizeimpl(mapIndexedTo);
        int i = 0;
        int i2 = 0;
        while (i < iM5707getSizeimpl) {
            destination.add(transform.invoke(Integer.valueOf(i2), ULong.m5640boximpl(ULongArray.m5706getsVKNKU(mapIndexedTo, i))));
            i++;
            i2++;
        }
        return destination;
    }

    /* JADX INFO: renamed from: mapIndexedTo-eNpIKz8, reason: not valid java name */
    private static final <R, C extends Collection<? super R>> C m6291mapIndexedToeNpIKz8(byte[] mapIndexedTo, C destination, Function2<? super Integer, ? super UByte, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(mapIndexedTo, "$this$mapIndexedTo");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iM5549getSizeimpl = UByteArray.m5549getSizeimpl(mapIndexedTo);
        int i = 0;
        int i2 = 0;
        while (i < iM5549getSizeimpl) {
            destination.add(transform.invoke(Integer.valueOf(i2), UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(mapIndexedTo, i))));
            i++;
            i2++;
        }
        return destination;
    }

    /* JADX INFO: renamed from: mapIndexedTo-QqktQ3k, reason: not valid java name */
    private static final <R, C extends Collection<? super R>> C m6290mapIndexedToQqktQ3k(short[] mapIndexedTo, C destination, Function2<? super Integer, ? super UShort, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(mapIndexedTo, "$this$mapIndexedTo");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iM5812getSizeimpl = UShortArray.m5812getSizeimpl(mapIndexedTo);
        int i = 0;
        int i2 = 0;
        while (i < iM5812getSizeimpl) {
            destination.add(transform.invoke(Integer.valueOf(i2), UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(mapIndexedTo, i))));
            i++;
            i2++;
        }
        return destination;
    }

    /* JADX INFO: renamed from: mapTo-wU5IKMo, reason: not valid java name */
    private static final <R, C extends Collection<? super R>> C m6295mapTowU5IKMo(int[] mapTo, C destination, Function1<? super UInt, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(mapTo, "$this$mapTo");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iM5628getSizeimpl = UIntArray.m5628getSizeimpl(mapTo);
        for (int i = 0; i < iM5628getSizeimpl; i++) {
            destination.add(transform.invoke(UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(mapTo, i))));
        }
        return destination;
    }

    /* JADX INFO: renamed from: mapTo-HqK1JgA, reason: not valid java name */
    private static final <R, C extends Collection<? super R>> C m6293mapToHqK1JgA(long[] mapTo, C destination, Function1<? super ULong, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(mapTo, "$this$mapTo");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iM5707getSizeimpl = ULongArray.m5707getSizeimpl(mapTo);
        for (int i = 0; i < iM5707getSizeimpl; i++) {
            destination.add(transform.invoke(ULong.m5640boximpl(ULongArray.m5706getsVKNKU(mapTo, i))));
        }
        return destination;
    }

    /* JADX INFO: renamed from: mapTo-wzUQCXU, reason: not valid java name */
    private static final <R, C extends Collection<? super R>> C m6296mapTowzUQCXU(byte[] mapTo, C destination, Function1<? super UByte, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(mapTo, "$this$mapTo");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iM5549getSizeimpl = UByteArray.m5549getSizeimpl(mapTo);
        for (int i = 0; i < iM5549getSizeimpl; i++) {
            destination.add(transform.invoke(UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(mapTo, i))));
        }
        return destination;
    }

    /* JADX INFO: renamed from: mapTo-oEOeDjA, reason: not valid java name */
    private static final <R, C extends Collection<? super R>> C m6294mapTooEOeDjA(short[] mapTo, C destination, Function1<? super UShort, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(mapTo, "$this$mapTo");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iM5812getSizeimpl = UShortArray.m5812getSizeimpl(mapTo);
        for (int i = 0; i < iM5812getSizeimpl; i++) {
            destination.add(transform.invoke(UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(mapTo, i))));
        }
        return destination;
    }

    /* JADX INFO: renamed from: withIndex--ajY-9A, reason: not valid java name */
    public static final Iterable<IndexedValue<UInt>> m6637withIndexajY9A(@NotNull final int[] withIndex) {
        Intrinsics.checkNotNullParameter(withIndex, "$this$withIndex");
        return new IndexingIterable(new Function0() { // from class: kotlin.collections.unsigned.UArraysKt___UArraysKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return UIntArray.m5631iteratorimpl(withIndex);
            }
        });
    }

    /* JADX INFO: renamed from: withIndex-QwZRm1k, reason: not valid java name */
    public static final Iterable<IndexedValue<ULong>> m6639withIndexQwZRm1k(@NotNull final long[] withIndex) {
        Intrinsics.checkNotNullParameter(withIndex, "$this$withIndex");
        return new IndexingIterable(new Function0() { // from class: kotlin.collections.unsigned.UArraysKt___UArraysKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ULongArray.m5710iteratorimpl(withIndex);
            }
        });
    }

    /* JADX INFO: renamed from: withIndex-GBYM_sE, reason: not valid java name */
    public static final Iterable<IndexedValue<UByte>> m6638withIndexGBYM_sE(@NotNull final byte[] withIndex) {
        Intrinsics.checkNotNullParameter(withIndex, "$this$withIndex");
        return new IndexingIterable(new Function0() { // from class: kotlin.collections.unsigned.UArraysKt___UArraysKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return UByteArray.m5552iteratorimpl(withIndex);
            }
        });
    }

    /* JADX INFO: renamed from: withIndex-rL5Bavg, reason: not valid java name */
    public static final Iterable<IndexedValue<UShort>> m6640withIndexrL5Bavg(@NotNull final short[] withIndex) {
        Intrinsics.checkNotNullParameter(withIndex, "$this$withIndex");
        return new IndexingIterable(new Function0() { // from class: kotlin.collections.unsigned.UArraysKt___UArraysKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return UShortArray.m5815iteratorimpl(withIndex);
            }
        });
    }

    /* JADX INFO: renamed from: all-jgv0xPQ, reason: not valid java name */
    private static final boolean m6011alljgv0xPQ(int[] all, Function1<? super UInt, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(all, "$this$all");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iM5628getSizeimpl = UIntArray.m5628getSizeimpl(all);
        for (int i = 0; i < iM5628getSizeimpl; i++) {
            if (!predicate.invoke(UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(all, i))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: all-MShoTSo, reason: not valid java name */
    private static final boolean m6010allMShoTSo(long[] all, Function1<? super ULong, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(all, "$this$all");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iM5707getSizeimpl = ULongArray.m5707getSizeimpl(all);
        for (int i = 0; i < iM5707getSizeimpl; i++) {
            if (!predicate.invoke(ULong.m5640boximpl(ULongArray.m5706getsVKNKU(all, i))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: all-JOV_ifY, reason: not valid java name */
    private static final boolean m6009allJOV_ifY(byte[] all, Function1<? super UByte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(all, "$this$all");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iM5549getSizeimpl = UByteArray.m5549getSizeimpl(all);
        for (int i = 0; i < iM5549getSizeimpl; i++) {
            if (!predicate.invoke(UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(all, i))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: all-xTcfx_M, reason: not valid java name */
    private static final boolean m6012allxTcfx_M(short[] all, Function1<? super UShort, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(all, "$this$all");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iM5812getSizeimpl = UShortArray.m5812getSizeimpl(all);
        for (int i = 0; i < iM5812getSizeimpl; i++) {
            if (!predicate.invoke(UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(all, i))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: any--ajY-9A, reason: not valid java name */
    private static final boolean m6013anyajY9A(int[] any) {
        Intrinsics.checkNotNullParameter(any, "$this$any");
        return ArraysKt___ArraysKt.any(any);
    }

    /* JADX INFO: renamed from: any-QwZRm1k, reason: not valid java name */
    private static final boolean m6017anyQwZRm1k(long[] any) {
        Intrinsics.checkNotNullParameter(any, "$this$any");
        return ArraysKt___ArraysKt.any(any);
    }

    /* JADX INFO: renamed from: any-GBYM_sE, reason: not valid java name */
    private static final boolean m6014anyGBYM_sE(byte[] any) {
        Intrinsics.checkNotNullParameter(any, "$this$any");
        return ArraysKt___ArraysKt.any(any);
    }

    /* JADX INFO: renamed from: any-rL5Bavg, reason: not valid java name */
    private static final boolean m6019anyrL5Bavg(short[] any) {
        Intrinsics.checkNotNullParameter(any, "$this$any");
        return ArraysKt___ArraysKt.any(any);
    }

    /* JADX INFO: renamed from: any-jgv0xPQ, reason: not valid java name */
    private static final boolean m6018anyjgv0xPQ(int[] any, Function1<? super UInt, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(any, "$this$any");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iM5628getSizeimpl = UIntArray.m5628getSizeimpl(any);
        for (int i = 0; i < iM5628getSizeimpl; i++) {
            if (predicate.invoke(UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(any, i))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: any-MShoTSo, reason: not valid java name */
    private static final boolean m6016anyMShoTSo(long[] any, Function1<? super ULong, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(any, "$this$any");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iM5707getSizeimpl = ULongArray.m5707getSizeimpl(any);
        for (int i = 0; i < iM5707getSizeimpl; i++) {
            if (predicate.invoke(ULong.m5640boximpl(ULongArray.m5706getsVKNKU(any, i))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: any-JOV_ifY, reason: not valid java name */
    private static final boolean m6015anyJOV_ifY(byte[] any, Function1<? super UByte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(any, "$this$any");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iM5549getSizeimpl = UByteArray.m5549getSizeimpl(any);
        for (int i = 0; i < iM5549getSizeimpl; i++) {
            if (predicate.invoke(UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(any, i))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: any-xTcfx_M, reason: not valid java name */
    private static final boolean m6020anyxTcfx_M(short[] any, Function1<? super UShort, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(any, "$this$any");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iM5812getSizeimpl = UShortArray.m5812getSizeimpl(any);
        for (int i = 0; i < iM5812getSizeimpl; i++) {
            if (predicate.invoke(UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(any, i))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: count-jgv0xPQ, reason: not valid java name */
    private static final int m6087countjgv0xPQ(int[] count, Function1<? super UInt, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(count, "$this$count");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iM5628getSizeimpl = UIntArray.m5628getSizeimpl(count);
        int i = 0;
        for (int i2 = 0; i2 < iM5628getSizeimpl; i2++) {
            if (predicate.invoke(UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(count, i2))).booleanValue()) {
                i++;
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: count-MShoTSo, reason: not valid java name */
    private static final int m6086countMShoTSo(long[] count, Function1<? super ULong, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(count, "$this$count");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iM5707getSizeimpl = ULongArray.m5707getSizeimpl(count);
        int i = 0;
        for (int i2 = 0; i2 < iM5707getSizeimpl; i2++) {
            if (predicate.invoke(ULong.m5640boximpl(ULongArray.m5706getsVKNKU(count, i2))).booleanValue()) {
                i++;
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: count-JOV_ifY, reason: not valid java name */
    private static final int m6085countJOV_ifY(byte[] count, Function1<? super UByte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(count, "$this$count");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iM5549getSizeimpl = UByteArray.m5549getSizeimpl(count);
        int i = 0;
        for (int i2 = 0; i2 < iM5549getSizeimpl; i2++) {
            if (predicate.invoke(UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(count, i2))).booleanValue()) {
                i++;
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: count-xTcfx_M, reason: not valid java name */
    private static final int m6088countxTcfx_M(short[] count, Function1<? super UShort, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(count, "$this$count");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iM5812getSizeimpl = UShortArray.m5812getSizeimpl(count);
        int i = 0;
        for (int i2 = 0; i2 < iM5812getSizeimpl; i2++) {
            if (predicate.invoke(UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(count, i2))).booleanValue()) {
                i++;
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: fold-zi1B2BA, reason: not valid java name */
    private static final <R> R m6187foldzi1B2BA(int[] fold, R r, Function2<? super R, ? super UInt, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(fold, "$this$fold");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int iM5628getSizeimpl = UIntArray.m5628getSizeimpl(fold);
        for (int i = 0; i < iM5628getSizeimpl; i++) {
            r = operation.invoke(r, UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(fold, i)));
        }
        return r;
    }

    /* JADX INFO: renamed from: fold-A8wKCXQ, reason: not valid java name */
    private static final <R> R m6185foldA8wKCXQ(long[] fold, R r, Function2<? super R, ? super ULong, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(fold, "$this$fold");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int iM5707getSizeimpl = ULongArray.m5707getSizeimpl(fold);
        for (int i = 0; i < iM5707getSizeimpl; i++) {
            r = operation.invoke(r, ULong.m5640boximpl(ULongArray.m5706getsVKNKU(fold, i)));
        }
        return r;
    }

    /* JADX INFO: renamed from: fold-yXmHNn8, reason: not valid java name */
    private static final <R> R m6186foldyXmHNn8(byte[] fold, R r, Function2<? super R, ? super UByte, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(fold, "$this$fold");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int iM5549getSizeimpl = UByteArray.m5549getSizeimpl(fold);
        for (int i = 0; i < iM5549getSizeimpl; i++) {
            r = operation.invoke(r, UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(fold, i)));
        }
        return r;
    }

    /* JADX INFO: renamed from: fold-zww5nb8, reason: not valid java name */
    private static final <R> R m6188foldzww5nb8(short[] fold, R r, Function2<? super R, ? super UShort, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(fold, "$this$fold");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int iM5812getSizeimpl = UShortArray.m5812getSizeimpl(fold);
        for (int i = 0; i < iM5812getSizeimpl; i++) {
            r = operation.invoke(r, UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(fold, i)));
        }
        return r;
    }

    /* JADX INFO: renamed from: foldIndexed-yVwIW0Q, reason: not valid java name */
    private static final <R> R m6192foldIndexedyVwIW0Q(int[] foldIndexed, R r, Function3<? super Integer, ? super R, ? super UInt, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(foldIndexed, "$this$foldIndexed");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int iM5628getSizeimpl = UIntArray.m5628getSizeimpl(foldIndexed);
        int i = 0;
        int i2 = 0;
        while (i < iM5628getSizeimpl) {
            r = operation.invoke(Integer.valueOf(i2), r, UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(foldIndexed, i)));
            i++;
            i2++;
        }
        return r;
    }

    /* JADX INFO: renamed from: foldIndexed-mwnnOCs, reason: not valid java name */
    private static final <R> R m6191foldIndexedmwnnOCs(long[] foldIndexed, R r, Function3<? super Integer, ? super R, ? super ULong, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(foldIndexed, "$this$foldIndexed");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int iM5707getSizeimpl = ULongArray.m5707getSizeimpl(foldIndexed);
        int i = 0;
        int i2 = 0;
        while (i < iM5707getSizeimpl) {
            r = operation.invoke(Integer.valueOf(i2), r, ULong.m5640boximpl(ULongArray.m5706getsVKNKU(foldIndexed, i)));
            i++;
            i2++;
        }
        return r;
    }

    /* JADX INFO: renamed from: foldIndexed-3iWJZGE, reason: not valid java name */
    private static final <R> R m6189foldIndexed3iWJZGE(byte[] foldIndexed, R r, Function3<? super Integer, ? super R, ? super UByte, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(foldIndexed, "$this$foldIndexed");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int iM5549getSizeimpl = UByteArray.m5549getSizeimpl(foldIndexed);
        int i = 0;
        int i2 = 0;
        while (i < iM5549getSizeimpl) {
            r = operation.invoke(Integer.valueOf(i2), r, UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(foldIndexed, i)));
            i++;
            i2++;
        }
        return r;
    }

    /* JADX INFO: renamed from: foldIndexed-bzxtMww, reason: not valid java name */
    private static final <R> R m6190foldIndexedbzxtMww(short[] foldIndexed, R r, Function3<? super Integer, ? super R, ? super UShort, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(foldIndexed, "$this$foldIndexed");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int iM5812getSizeimpl = UShortArray.m5812getSizeimpl(foldIndexed);
        int i = 0;
        int i2 = 0;
        while (i < iM5812getSizeimpl) {
            r = operation.invoke(Integer.valueOf(i2), r, UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(foldIndexed, i)));
            i++;
            i2++;
        }
        return r;
    }

    /* JADX INFO: renamed from: forEach-jgv0xPQ, reason: not valid java name */
    private static final void m6203forEachjgv0xPQ(int[] forEach, Function1<? super UInt, Unit> action) {
        Intrinsics.checkNotNullParameter(forEach, "$this$forEach");
        Intrinsics.checkNotNullParameter(action, "action");
        int iM5628getSizeimpl = UIntArray.m5628getSizeimpl(forEach);
        for (int i = 0; i < iM5628getSizeimpl; i++) {
            action.invoke(UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(forEach, i)));
        }
    }

    /* JADX INFO: renamed from: forEach-MShoTSo, reason: not valid java name */
    private static final void m6202forEachMShoTSo(long[] forEach, Function1<? super ULong, Unit> action) {
        Intrinsics.checkNotNullParameter(forEach, "$this$forEach");
        Intrinsics.checkNotNullParameter(action, "action");
        int iM5707getSizeimpl = ULongArray.m5707getSizeimpl(forEach);
        for (int i = 0; i < iM5707getSizeimpl; i++) {
            action.invoke(ULong.m5640boximpl(ULongArray.m5706getsVKNKU(forEach, i)));
        }
    }

    /* JADX INFO: renamed from: forEach-JOV_ifY, reason: not valid java name */
    private static final void m6201forEachJOV_ifY(byte[] forEach, Function1<? super UByte, Unit> action) {
        Intrinsics.checkNotNullParameter(forEach, "$this$forEach");
        Intrinsics.checkNotNullParameter(action, "action");
        int iM5549getSizeimpl = UByteArray.m5549getSizeimpl(forEach);
        for (int i = 0; i < iM5549getSizeimpl; i++) {
            action.invoke(UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(forEach, i)));
        }
    }

    /* JADX INFO: renamed from: forEach-xTcfx_M, reason: not valid java name */
    private static final void m6204forEachxTcfx_M(short[] forEach, Function1<? super UShort, Unit> action) {
        Intrinsics.checkNotNullParameter(forEach, "$this$forEach");
        Intrinsics.checkNotNullParameter(action, "action");
        int iM5812getSizeimpl = UShortArray.m5812getSizeimpl(forEach);
        for (int i = 0; i < iM5812getSizeimpl; i++) {
            action.invoke(UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(forEach, i)));
        }
    }

    /* JADX INFO: renamed from: forEachIndexed-WyvcNBI, reason: not valid java name */
    private static final void m6206forEachIndexedWyvcNBI(int[] forEachIndexed, Function2<? super Integer, ? super UInt, Unit> action) {
        Intrinsics.checkNotNullParameter(forEachIndexed, "$this$forEachIndexed");
        Intrinsics.checkNotNullParameter(action, "action");
        int iM5628getSizeimpl = UIntArray.m5628getSizeimpl(forEachIndexed);
        int i = 0;
        int i2 = 0;
        while (i < iM5628getSizeimpl) {
            action.invoke(Integer.valueOf(i2), UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(forEachIndexed, i)));
            i++;
            i2++;
        }
    }

    /* JADX INFO: renamed from: forEachIndexed-s8dVfGU, reason: not valid java name */
    private static final void m6207forEachIndexeds8dVfGU(long[] forEachIndexed, Function2<? super Integer, ? super ULong, Unit> action) {
        Intrinsics.checkNotNullParameter(forEachIndexed, "$this$forEachIndexed");
        Intrinsics.checkNotNullParameter(action, "action");
        int iM5707getSizeimpl = ULongArray.m5707getSizeimpl(forEachIndexed);
        int i = 0;
        int i2 = 0;
        while (i < iM5707getSizeimpl) {
            action.invoke(Integer.valueOf(i2), ULong.m5640boximpl(ULongArray.m5706getsVKNKU(forEachIndexed, i)));
            i++;
            i2++;
        }
    }

    /* JADX INFO: renamed from: forEachIndexed-ELGow60, reason: not valid java name */
    private static final void m6205forEachIndexedELGow60(byte[] forEachIndexed, Function2<? super Integer, ? super UByte, Unit> action) {
        Intrinsics.checkNotNullParameter(forEachIndexed, "$this$forEachIndexed");
        Intrinsics.checkNotNullParameter(action, "action");
        int iM5549getSizeimpl = UByteArray.m5549getSizeimpl(forEachIndexed);
        int i = 0;
        int i2 = 0;
        while (i < iM5549getSizeimpl) {
            action.invoke(Integer.valueOf(i2), UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(forEachIndexed, i)));
            i++;
            i2++;
        }
    }

    /* JADX INFO: renamed from: forEachIndexed-xzaTVY8, reason: not valid java name */
    private static final void m6208forEachIndexedxzaTVY8(short[] forEachIndexed, Function2<? super Integer, ? super UShort, Unit> action) {
        Intrinsics.checkNotNullParameter(forEachIndexed, "$this$forEachIndexed");
        Intrinsics.checkNotNullParameter(action, "action");
        int iM5812getSizeimpl = UShortArray.m5812getSizeimpl(forEachIndexed);
        int i = 0;
        int i2 = 0;
        while (i < iM5812getSizeimpl) {
            action.invoke(Integer.valueOf(i2), UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(forEachIndexed, i)));
            i++;
            i2++;
        }
    }

    /* JADX INFO: renamed from: maxOrThrow-U, reason: not valid java name */
    public static final int m6342maxOrThrowU(@NotNull int[] max) {
        Intrinsics.checkNotNullParameter(max, "$this$max");
        if (UIntArray.m5630isEmptyimpl(max)) {
            throw new NoSuchElementException();
        }
        int iM5627getpVg5ArA = UIntArray.m5627getpVg5ArA(max, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(max);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                int iM5627getpVg5ArA2 = UIntArray.m5627getpVg5ArA(max, i);
                if (Integer.compare(iM5627getpVg5ArA ^ Integer.MIN_VALUE, iM5627getpVg5ArA2 ^ Integer.MIN_VALUE) < 0) {
                    iM5627getpVg5ArA = iM5627getpVg5ArA2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return iM5627getpVg5ArA;
    }

    /* JADX INFO: renamed from: maxOrThrow-U, reason: not valid java name */
    public static final long m6343maxOrThrowU(@NotNull long[] max) {
        Intrinsics.checkNotNullParameter(max, "$this$max");
        if (ULongArray.m5709isEmptyimpl(max)) {
            throw new NoSuchElementException();
        }
        long jM5706getsVKNKU = ULongArray.m5706getsVKNKU(max, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(max);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                long jM5706getsVKNKU2 = ULongArray.m5706getsVKNKU(max, i);
                if (Long.compare(jM5706getsVKNKU ^ Long.MIN_VALUE, jM5706getsVKNKU2 ^ Long.MIN_VALUE) < 0) {
                    jM5706getsVKNKU = jM5706getsVKNKU2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return jM5706getsVKNKU;
    }

    /* JADX INFO: renamed from: maxOrThrow-U, reason: not valid java name */
    public static final byte m6341maxOrThrowU(@NotNull byte[] max) {
        Intrinsics.checkNotNullParameter(max, "$this$max");
        if (UByteArray.m5551isEmptyimpl(max)) {
            throw new NoSuchElementException();
        }
        byte bM5548getw2LRezQ = UByteArray.m5548getw2LRezQ(max, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(max);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte bM5548getw2LRezQ2 = UByteArray.m5548getw2LRezQ(max, i);
                if (Intrinsics.compare(bM5548getw2LRezQ & 255, bM5548getw2LRezQ2 & 255) < 0) {
                    bM5548getw2LRezQ = bM5548getw2LRezQ2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return bM5548getw2LRezQ;
    }

    /* JADX INFO: renamed from: maxOrThrow-U, reason: not valid java name */
    public static final short m6344maxOrThrowU(@NotNull short[] max) {
        Intrinsics.checkNotNullParameter(max, "$this$max");
        if (UShortArray.m5814isEmptyimpl(max)) {
            throw new NoSuchElementException();
        }
        short sM5811getMh2AYeg = UShortArray.m5811getMh2AYeg(max, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(max);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                short sM5811getMh2AYeg2 = UShortArray.m5811getMh2AYeg(max, i);
                if (Intrinsics.compare(sM5811getMh2AYeg & UShort.MAX_VALUE, 65535 & sM5811getMh2AYeg2) < 0) {
                    sM5811getMh2AYeg = sM5811getMh2AYeg2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return sM5811getMh2AYeg;
    }

    /* JADX INFO: renamed from: maxByOrThrow-U, reason: not valid java name */
    private static final <R extends Comparable<? super R>> int m6302maxByOrThrowU(int[] maxBy, Function1<? super UInt, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(maxBy, "$this$maxBy");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UIntArray.m5630isEmptyimpl(maxBy)) {
            throw new NoSuchElementException();
        }
        int iM5627getpVg5ArA = UIntArray.m5627getpVg5ArA(maxBy, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(maxBy);
        if (lastIndex == 0) {
            return iM5627getpVg5ArA;
        }
        R rInvoke = selector.invoke(UInt.m5561boximpl(iM5627getpVg5ArA));
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                int iM5627getpVg5ArA2 = UIntArray.m5627getpVg5ArA(maxBy, i);
                R rInvoke2 = selector.invoke(UInt.m5561boximpl(iM5627getpVg5ArA2));
                if (rInvoke.compareTo(rInvoke2) < 0) {
                    iM5627getpVg5ArA = iM5627getpVg5ArA2;
                    rInvoke = rInvoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return iM5627getpVg5ArA;
    }

    /* JADX INFO: renamed from: maxByOrThrow-U, reason: not valid java name */
    private static final <R extends Comparable<? super R>> long m6303maxByOrThrowU(long[] maxBy, Function1<? super ULong, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(maxBy, "$this$maxBy");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (ULongArray.m5709isEmptyimpl(maxBy)) {
            throw new NoSuchElementException();
        }
        long jM5706getsVKNKU = ULongArray.m5706getsVKNKU(maxBy, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(maxBy);
        if (lastIndex == 0) {
            return jM5706getsVKNKU;
        }
        R rInvoke = selector.invoke(ULong.m5640boximpl(jM5706getsVKNKU));
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                long jM5706getsVKNKU2 = ULongArray.m5706getsVKNKU(maxBy, i);
                R rInvoke2 = selector.invoke(ULong.m5640boximpl(jM5706getsVKNKU2));
                if (rInvoke.compareTo(rInvoke2) < 0) {
                    jM5706getsVKNKU = jM5706getsVKNKU2;
                    rInvoke = rInvoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return jM5706getsVKNKU;
    }

    /* JADX INFO: renamed from: maxByOrThrow-U, reason: not valid java name */
    private static final <R extends Comparable<? super R>> byte m6301maxByOrThrowU(byte[] maxBy, Function1<? super UByte, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(maxBy, "$this$maxBy");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UByteArray.m5551isEmptyimpl(maxBy)) {
            throw new NoSuchElementException();
        }
        byte bM5548getw2LRezQ = UByteArray.m5548getw2LRezQ(maxBy, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(maxBy);
        if (lastIndex == 0) {
            return bM5548getw2LRezQ;
        }
        R rInvoke = selector.invoke(UByte.m5484boximpl(bM5548getw2LRezQ));
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte bM5548getw2LRezQ2 = UByteArray.m5548getw2LRezQ(maxBy, i);
                R rInvoke2 = selector.invoke(UByte.m5484boximpl(bM5548getw2LRezQ2));
                if (rInvoke.compareTo(rInvoke2) < 0) {
                    bM5548getw2LRezQ = bM5548getw2LRezQ2;
                    rInvoke = rInvoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return bM5548getw2LRezQ;
    }

    /* JADX INFO: renamed from: maxByOrThrow-U, reason: not valid java name */
    private static final <R extends Comparable<? super R>> short m6304maxByOrThrowU(short[] maxBy, Function1<? super UShort, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(maxBy, "$this$maxBy");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UShortArray.m5814isEmptyimpl(maxBy)) {
            throw new NoSuchElementException();
        }
        short sM5811getMh2AYeg = UShortArray.m5811getMh2AYeg(maxBy, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(maxBy);
        if (lastIndex == 0) {
            return sM5811getMh2AYeg;
        }
        R rInvoke = selector.invoke(UShort.m5747boximpl(sM5811getMh2AYeg));
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                short sM5811getMh2AYeg2 = UShortArray.m5811getMh2AYeg(maxBy, i);
                R rInvoke2 = selector.invoke(UShort.m5747boximpl(sM5811getMh2AYeg2));
                if (rInvoke.compareTo(rInvoke2) < 0) {
                    sM5811getMh2AYeg = sM5811getMh2AYeg2;
                    rInvoke = rInvoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return sM5811getMh2AYeg;
    }

    /* JADX INFO: renamed from: maxByOrNull-jgv0xPQ, reason: not valid java name */
    private static final <R extends Comparable<? super R>> UInt m6299maxByOrNulljgv0xPQ(int[] maxByOrNull, Function1<? super UInt, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(maxByOrNull, "$this$maxByOrNull");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UIntArray.m5630isEmptyimpl(maxByOrNull)) {
            return null;
        }
        int iM5627getpVg5ArA = UIntArray.m5627getpVg5ArA(maxByOrNull, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(maxByOrNull);
        if (lastIndex == 0) {
            return UInt.m5561boximpl(iM5627getpVg5ArA);
        }
        R rInvoke = selector.invoke(UInt.m5561boximpl(iM5627getpVg5ArA));
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                int iM5627getpVg5ArA2 = UIntArray.m5627getpVg5ArA(maxByOrNull, i);
                R rInvoke2 = selector.invoke(UInt.m5561boximpl(iM5627getpVg5ArA2));
                if (rInvoke.compareTo(rInvoke2) < 0) {
                    iM5627getpVg5ArA = iM5627getpVg5ArA2;
                    rInvoke = rInvoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UInt.m5561boximpl(iM5627getpVg5ArA);
    }

    /* JADX INFO: renamed from: maxByOrNull-MShoTSo, reason: not valid java name */
    private static final <R extends Comparable<? super R>> ULong m6298maxByOrNullMShoTSo(long[] maxByOrNull, Function1<? super ULong, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(maxByOrNull, "$this$maxByOrNull");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (ULongArray.m5709isEmptyimpl(maxByOrNull)) {
            return null;
        }
        long jM5706getsVKNKU = ULongArray.m5706getsVKNKU(maxByOrNull, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(maxByOrNull);
        if (lastIndex == 0) {
            return ULong.m5640boximpl(jM5706getsVKNKU);
        }
        R rInvoke = selector.invoke(ULong.m5640boximpl(jM5706getsVKNKU));
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                long jM5706getsVKNKU2 = ULongArray.m5706getsVKNKU(maxByOrNull, i);
                R rInvoke2 = selector.invoke(ULong.m5640boximpl(jM5706getsVKNKU2));
                if (rInvoke.compareTo(rInvoke2) < 0) {
                    jM5706getsVKNKU = jM5706getsVKNKU2;
                    rInvoke = rInvoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return ULong.m5640boximpl(jM5706getsVKNKU);
    }

    /* JADX INFO: renamed from: maxByOrNull-JOV_ifY, reason: not valid java name */
    private static final <R extends Comparable<? super R>> UByte m6297maxByOrNullJOV_ifY(byte[] maxByOrNull, Function1<? super UByte, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(maxByOrNull, "$this$maxByOrNull");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UByteArray.m5551isEmptyimpl(maxByOrNull)) {
            return null;
        }
        byte bM5548getw2LRezQ = UByteArray.m5548getw2LRezQ(maxByOrNull, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(maxByOrNull);
        if (lastIndex == 0) {
            return UByte.m5484boximpl(bM5548getw2LRezQ);
        }
        R rInvoke = selector.invoke(UByte.m5484boximpl(bM5548getw2LRezQ));
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte bM5548getw2LRezQ2 = UByteArray.m5548getw2LRezQ(maxByOrNull, i);
                R rInvoke2 = selector.invoke(UByte.m5484boximpl(bM5548getw2LRezQ2));
                if (rInvoke.compareTo(rInvoke2) < 0) {
                    bM5548getw2LRezQ = bM5548getw2LRezQ2;
                    rInvoke = rInvoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UByte.m5484boximpl(bM5548getw2LRezQ);
    }

    /* JADX INFO: renamed from: maxByOrNull-xTcfx_M, reason: not valid java name */
    private static final <R extends Comparable<? super R>> UShort m6300maxByOrNullxTcfx_M(short[] maxByOrNull, Function1<? super UShort, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(maxByOrNull, "$this$maxByOrNull");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UShortArray.m5814isEmptyimpl(maxByOrNull)) {
            return null;
        }
        short sM5811getMh2AYeg = UShortArray.m5811getMh2AYeg(maxByOrNull, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(maxByOrNull);
        if (lastIndex == 0) {
            return UShort.m5747boximpl(sM5811getMh2AYeg);
        }
        R rInvoke = selector.invoke(UShort.m5747boximpl(sM5811getMh2AYeg));
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                short sM5811getMh2AYeg2 = UShortArray.m5811getMh2AYeg(maxByOrNull, i);
                R rInvoke2 = selector.invoke(UShort.m5747boximpl(sM5811getMh2AYeg2));
                if (rInvoke.compareTo(rInvoke2) < 0) {
                    sM5811getMh2AYeg = sM5811getMh2AYeg2;
                    rInvoke = rInvoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UShort.m5747boximpl(sM5811getMh2AYeg);
    }

    /* JADX INFO: renamed from: maxOf-jgv0xPQ, reason: not valid java name */
    private static final double m6311maxOfjgv0xPQ(int[] maxOf, Function1<? super UInt, Double> selector) {
        Intrinsics.checkNotNullParameter(maxOf, "$this$maxOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UIntArray.m5630isEmptyimpl(maxOf)) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.invoke(UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(maxOf, 0))).doubleValue();
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(maxOf);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.max(dDoubleValue, selector.invoke(UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(maxOf, i))).doubleValue());
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return dDoubleValue;
    }

    /* JADX INFO: renamed from: maxOf-MShoTSo, reason: not valid java name */
    private static final double m6308maxOfMShoTSo(long[] maxOf, Function1<? super ULong, Double> selector) {
        Intrinsics.checkNotNullParameter(maxOf, "$this$maxOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (ULongArray.m5709isEmptyimpl(maxOf)) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.invoke(ULong.m5640boximpl(ULongArray.m5706getsVKNKU(maxOf, 0))).doubleValue();
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(maxOf);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.max(dDoubleValue, selector.invoke(ULong.m5640boximpl(ULongArray.m5706getsVKNKU(maxOf, i))).doubleValue());
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return dDoubleValue;
    }

    /* JADX INFO: renamed from: maxOf-JOV_ifY, reason: not valid java name */
    private static final double m6305maxOfJOV_ifY(byte[] maxOf, Function1<? super UByte, Double> selector) {
        Intrinsics.checkNotNullParameter(maxOf, "$this$maxOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UByteArray.m5551isEmptyimpl(maxOf)) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.invoke(UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(maxOf, 0))).doubleValue();
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(maxOf);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.max(dDoubleValue, selector.invoke(UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(maxOf, i))).doubleValue());
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return dDoubleValue;
    }

    /* JADX INFO: renamed from: maxOf-xTcfx_M, reason: not valid java name */
    private static final double m6314maxOfxTcfx_M(short[] maxOf, Function1<? super UShort, Double> selector) {
        Intrinsics.checkNotNullParameter(maxOf, "$this$maxOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UShortArray.m5814isEmptyimpl(maxOf)) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.invoke(UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(maxOf, 0))).doubleValue();
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(maxOf);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.max(dDoubleValue, selector.invoke(UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(maxOf, i))).doubleValue());
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return dDoubleValue;
    }

    /* JADX INFO: renamed from: maxOf-jgv0xPQ, reason: not valid java name */
    private static final float m6312maxOfjgv0xPQ(int[] maxOf, Function1<? super UInt, Float> selector) {
        Intrinsics.checkNotNullParameter(maxOf, "$this$maxOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UIntArray.m5630isEmptyimpl(maxOf)) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.invoke(UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(maxOf, 0))).floatValue();
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(maxOf);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.max(fFloatValue, selector.invoke(UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(maxOf, i))).floatValue());
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return fFloatValue;
    }

    /* JADX INFO: renamed from: maxOf-MShoTSo, reason: not valid java name */
    private static final float m6309maxOfMShoTSo(long[] maxOf, Function1<? super ULong, Float> selector) {
        Intrinsics.checkNotNullParameter(maxOf, "$this$maxOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (ULongArray.m5709isEmptyimpl(maxOf)) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.invoke(ULong.m5640boximpl(ULongArray.m5706getsVKNKU(maxOf, 0))).floatValue();
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(maxOf);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.max(fFloatValue, selector.invoke(ULong.m5640boximpl(ULongArray.m5706getsVKNKU(maxOf, i))).floatValue());
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return fFloatValue;
    }

    /* JADX INFO: renamed from: maxOf-JOV_ifY, reason: not valid java name */
    private static final float m6306maxOfJOV_ifY(byte[] maxOf, Function1<? super UByte, Float> selector) {
        Intrinsics.checkNotNullParameter(maxOf, "$this$maxOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UByteArray.m5551isEmptyimpl(maxOf)) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.invoke(UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(maxOf, 0))).floatValue();
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(maxOf);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.max(fFloatValue, selector.invoke(UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(maxOf, i))).floatValue());
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return fFloatValue;
    }

    /* JADX INFO: renamed from: maxOf-xTcfx_M, reason: not valid java name */
    private static final float m6315maxOfxTcfx_M(short[] maxOf, Function1<? super UShort, Float> selector) {
        Intrinsics.checkNotNullParameter(maxOf, "$this$maxOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UShortArray.m5814isEmptyimpl(maxOf)) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.invoke(UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(maxOf, 0))).floatValue();
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(maxOf);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.max(fFloatValue, selector.invoke(UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(maxOf, i))).floatValue());
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return fFloatValue;
    }

    /* JADX INFO: renamed from: maxOf-jgv0xPQ, reason: not valid java name */
    private static final <R extends Comparable<? super R>> R m6313maxOfjgv0xPQ(int[] maxOf, Function1<? super UInt, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(maxOf, "$this$maxOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UIntArray.m5630isEmptyimpl(maxOf)) {
            throw new NoSuchElementException();
        }
        R rInvoke = selector.invoke(UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(maxOf, 0)));
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(maxOf);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                R rInvoke2 = selector.invoke(UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(maxOf, i)));
                if (rInvoke.compareTo(rInvoke2) < 0) {
                    rInvoke = rInvoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return rInvoke;
    }

    /* JADX INFO: renamed from: maxOf-MShoTSo, reason: not valid java name */
    private static final <R extends Comparable<? super R>> R m6310maxOfMShoTSo(long[] maxOf, Function1<? super ULong, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(maxOf, "$this$maxOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (ULongArray.m5709isEmptyimpl(maxOf)) {
            throw new NoSuchElementException();
        }
        R rInvoke = selector.invoke(ULong.m5640boximpl(ULongArray.m5706getsVKNKU(maxOf, 0)));
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(maxOf);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                R rInvoke2 = selector.invoke(ULong.m5640boximpl(ULongArray.m5706getsVKNKU(maxOf, i)));
                if (rInvoke.compareTo(rInvoke2) < 0) {
                    rInvoke = rInvoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return rInvoke;
    }

    /* JADX INFO: renamed from: maxOf-JOV_ifY, reason: not valid java name */
    private static final <R extends Comparable<? super R>> R m6307maxOfJOV_ifY(byte[] maxOf, Function1<? super UByte, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(maxOf, "$this$maxOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UByteArray.m5551isEmptyimpl(maxOf)) {
            throw new NoSuchElementException();
        }
        R rInvoke = selector.invoke(UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(maxOf, 0)));
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(maxOf);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                R rInvoke2 = selector.invoke(UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(maxOf, i)));
                if (rInvoke.compareTo(rInvoke2) < 0) {
                    rInvoke = rInvoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return rInvoke;
    }

    /* JADX INFO: renamed from: maxOf-xTcfx_M, reason: not valid java name */
    private static final <R extends Comparable<? super R>> R m6316maxOfxTcfx_M(short[] maxOf, Function1<? super UShort, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(maxOf, "$this$maxOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UShortArray.m5814isEmptyimpl(maxOf)) {
            throw new NoSuchElementException();
        }
        R rInvoke = selector.invoke(UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(maxOf, 0)));
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(maxOf);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                R rInvoke2 = selector.invoke(UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(maxOf, i)));
                if (rInvoke.compareTo(rInvoke2) < 0) {
                    rInvoke = rInvoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return rInvoke;
    }

    /* JADX INFO: renamed from: maxOfOrNull-jgv0xPQ, reason: not valid java name */
    private static final Double m6324maxOfOrNulljgv0xPQ(int[] maxOfOrNull, Function1<? super UInt, Double> selector) {
        Intrinsics.checkNotNullParameter(maxOfOrNull, "$this$maxOfOrNull");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UIntArray.m5630isEmptyimpl(maxOfOrNull)) {
            return null;
        }
        double dDoubleValue = selector.invoke(UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(maxOfOrNull, 0))).doubleValue();
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(maxOfOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.max(dDoubleValue, selector.invoke(UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(maxOfOrNull, i))).doubleValue());
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    /* JADX INFO: renamed from: maxOfOrNull-MShoTSo, reason: not valid java name */
    private static final Double m6321maxOfOrNullMShoTSo(long[] maxOfOrNull, Function1<? super ULong, Double> selector) {
        Intrinsics.checkNotNullParameter(maxOfOrNull, "$this$maxOfOrNull");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (ULongArray.m5709isEmptyimpl(maxOfOrNull)) {
            return null;
        }
        double dDoubleValue = selector.invoke(ULong.m5640boximpl(ULongArray.m5706getsVKNKU(maxOfOrNull, 0))).doubleValue();
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(maxOfOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.max(dDoubleValue, selector.invoke(ULong.m5640boximpl(ULongArray.m5706getsVKNKU(maxOfOrNull, i))).doubleValue());
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    /* JADX INFO: renamed from: maxOfOrNull-JOV_ifY, reason: not valid java name */
    private static final Double m6318maxOfOrNullJOV_ifY(byte[] maxOfOrNull, Function1<? super UByte, Double> selector) {
        Intrinsics.checkNotNullParameter(maxOfOrNull, "$this$maxOfOrNull");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UByteArray.m5551isEmptyimpl(maxOfOrNull)) {
            return null;
        }
        double dDoubleValue = selector.invoke(UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(maxOfOrNull, 0))).doubleValue();
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(maxOfOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.max(dDoubleValue, selector.invoke(UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(maxOfOrNull, i))).doubleValue());
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    /* JADX INFO: renamed from: maxOfOrNull-xTcfx_M, reason: not valid java name */
    private static final Double m6327maxOfOrNullxTcfx_M(short[] maxOfOrNull, Function1<? super UShort, Double> selector) {
        Intrinsics.checkNotNullParameter(maxOfOrNull, "$this$maxOfOrNull");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UShortArray.m5814isEmptyimpl(maxOfOrNull)) {
            return null;
        }
        double dDoubleValue = selector.invoke(UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(maxOfOrNull, 0))).doubleValue();
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(maxOfOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.max(dDoubleValue, selector.invoke(UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(maxOfOrNull, i))).doubleValue());
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    /* JADX INFO: renamed from: maxOfOrNull-jgv0xPQ, reason: not valid java name */
    private static final Float m6325maxOfOrNulljgv0xPQ(int[] maxOfOrNull, Function1<? super UInt, Float> selector) {
        Intrinsics.checkNotNullParameter(maxOfOrNull, "$this$maxOfOrNull");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UIntArray.m5630isEmptyimpl(maxOfOrNull)) {
            return null;
        }
        float fFloatValue = selector.invoke(UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(maxOfOrNull, 0))).floatValue();
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(maxOfOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.max(fFloatValue, selector.invoke(UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(maxOfOrNull, i))).floatValue());
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    /* JADX INFO: renamed from: maxOfOrNull-MShoTSo, reason: not valid java name */
    private static final Float m6322maxOfOrNullMShoTSo(long[] maxOfOrNull, Function1<? super ULong, Float> selector) {
        Intrinsics.checkNotNullParameter(maxOfOrNull, "$this$maxOfOrNull");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (ULongArray.m5709isEmptyimpl(maxOfOrNull)) {
            return null;
        }
        float fFloatValue = selector.invoke(ULong.m5640boximpl(ULongArray.m5706getsVKNKU(maxOfOrNull, 0))).floatValue();
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(maxOfOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.max(fFloatValue, selector.invoke(ULong.m5640boximpl(ULongArray.m5706getsVKNKU(maxOfOrNull, i))).floatValue());
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    /* JADX INFO: renamed from: maxOfOrNull-JOV_ifY, reason: not valid java name */
    private static final Float m6319maxOfOrNullJOV_ifY(byte[] maxOfOrNull, Function1<? super UByte, Float> selector) {
        Intrinsics.checkNotNullParameter(maxOfOrNull, "$this$maxOfOrNull");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UByteArray.m5551isEmptyimpl(maxOfOrNull)) {
            return null;
        }
        float fFloatValue = selector.invoke(UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(maxOfOrNull, 0))).floatValue();
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(maxOfOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.max(fFloatValue, selector.invoke(UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(maxOfOrNull, i))).floatValue());
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    /* JADX INFO: renamed from: maxOfOrNull-xTcfx_M, reason: not valid java name */
    private static final Float m6328maxOfOrNullxTcfx_M(short[] maxOfOrNull, Function1<? super UShort, Float> selector) {
        Intrinsics.checkNotNullParameter(maxOfOrNull, "$this$maxOfOrNull");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UShortArray.m5814isEmptyimpl(maxOfOrNull)) {
            return null;
        }
        float fFloatValue = selector.invoke(UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(maxOfOrNull, 0))).floatValue();
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(maxOfOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.max(fFloatValue, selector.invoke(UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(maxOfOrNull, i))).floatValue());
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    /* JADX INFO: renamed from: maxOfOrNull-jgv0xPQ, reason: not valid java name */
    private static final <R extends Comparable<? super R>> R m6323maxOfOrNulljgv0xPQ(int[] maxOfOrNull, Function1<? super UInt, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(maxOfOrNull, "$this$maxOfOrNull");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UIntArray.m5630isEmptyimpl(maxOfOrNull)) {
            return null;
        }
        R rInvoke = selector.invoke(UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(maxOfOrNull, 0)));
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(maxOfOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                R rInvoke2 = selector.invoke(UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(maxOfOrNull, i)));
                if (rInvoke.compareTo(rInvoke2) < 0) {
                    rInvoke = rInvoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return rInvoke;
    }

    /* JADX INFO: renamed from: maxOfOrNull-MShoTSo, reason: not valid java name */
    private static final <R extends Comparable<? super R>> R m6320maxOfOrNullMShoTSo(long[] maxOfOrNull, Function1<? super ULong, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(maxOfOrNull, "$this$maxOfOrNull");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (ULongArray.m5709isEmptyimpl(maxOfOrNull)) {
            return null;
        }
        R rInvoke = selector.invoke(ULong.m5640boximpl(ULongArray.m5706getsVKNKU(maxOfOrNull, 0)));
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(maxOfOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                R rInvoke2 = selector.invoke(ULong.m5640boximpl(ULongArray.m5706getsVKNKU(maxOfOrNull, i)));
                if (rInvoke.compareTo(rInvoke2) < 0) {
                    rInvoke = rInvoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return rInvoke;
    }

    /* JADX INFO: renamed from: maxOfOrNull-JOV_ifY, reason: not valid java name */
    private static final <R extends Comparable<? super R>> R m6317maxOfOrNullJOV_ifY(byte[] maxOfOrNull, Function1<? super UByte, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(maxOfOrNull, "$this$maxOfOrNull");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UByteArray.m5551isEmptyimpl(maxOfOrNull)) {
            return null;
        }
        R rInvoke = selector.invoke(UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(maxOfOrNull, 0)));
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(maxOfOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                R rInvoke2 = selector.invoke(UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(maxOfOrNull, i)));
                if (rInvoke.compareTo(rInvoke2) < 0) {
                    rInvoke = rInvoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return rInvoke;
    }

    /* JADX INFO: renamed from: maxOfOrNull-xTcfx_M, reason: not valid java name */
    private static final <R extends Comparable<? super R>> R m6326maxOfOrNullxTcfx_M(short[] maxOfOrNull, Function1<? super UShort, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(maxOfOrNull, "$this$maxOfOrNull");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UShortArray.m5814isEmptyimpl(maxOfOrNull)) {
            return null;
        }
        R rInvoke = selector.invoke(UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(maxOfOrNull, 0)));
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(maxOfOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                R rInvoke2 = selector.invoke(UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(maxOfOrNull, i)));
                if (rInvoke.compareTo(rInvoke2) < 0) {
                    rInvoke = rInvoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return rInvoke;
    }

    /* JADX INFO: renamed from: maxOfWith-myNOsp4, reason: not valid java name */
    private static final <R> R m6332maxOfWithmyNOsp4(int[] maxOfWith, Comparator<? super R> comparator, Function1<? super UInt, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(maxOfWith, "$this$maxOfWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UIntArray.m5630isEmptyimpl(maxOfWith)) {
            throw new NoSuchElementException();
        }
        R rInvoke = selector.invoke(UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(maxOfWith, 0)));
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(maxOfWith);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                R rInvoke2 = selector.invoke(UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(maxOfWith, i)));
                if (comparator.compare(rInvoke, rInvoke2) < 0) {
                    rInvoke = rInvoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return rInvoke;
    }

    /* JADX INFO: renamed from: maxOfWith-5NtCtWE, reason: not valid java name */
    private static final <R> R m6329maxOfWith5NtCtWE(long[] maxOfWith, Comparator<? super R> comparator, Function1<? super ULong, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(maxOfWith, "$this$maxOfWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (ULongArray.m5709isEmptyimpl(maxOfWith)) {
            throw new NoSuchElementException();
        }
        R rInvoke = selector.invoke(ULong.m5640boximpl(ULongArray.m5706getsVKNKU(maxOfWith, 0)));
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(maxOfWith);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                R rInvoke2 = selector.invoke(ULong.m5640boximpl(ULongArray.m5706getsVKNKU(maxOfWith, i)));
                if (comparator.compare(rInvoke, rInvoke2) < 0) {
                    rInvoke = rInvoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return rInvoke;
    }

    /* JADX INFO: renamed from: maxOfWith-LTi4i_s, reason: not valid java name */
    private static final <R> R m6330maxOfWithLTi4i_s(byte[] maxOfWith, Comparator<? super R> comparator, Function1<? super UByte, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(maxOfWith, "$this$maxOfWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UByteArray.m5551isEmptyimpl(maxOfWith)) {
            throw new NoSuchElementException();
        }
        R rInvoke = selector.invoke(UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(maxOfWith, 0)));
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(maxOfWith);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                R rInvoke2 = selector.invoke(UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(maxOfWith, i)));
                if (comparator.compare(rInvoke, rInvoke2) < 0) {
                    rInvoke = rInvoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return rInvoke;
    }

    /* JADX INFO: renamed from: maxOfWith-l8EHGbQ, reason: not valid java name */
    private static final <R> R m6331maxOfWithl8EHGbQ(short[] maxOfWith, Comparator<? super R> comparator, Function1<? super UShort, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(maxOfWith, "$this$maxOfWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UShortArray.m5814isEmptyimpl(maxOfWith)) {
            throw new NoSuchElementException();
        }
        R rInvoke = selector.invoke(UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(maxOfWith, 0)));
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(maxOfWith);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                R rInvoke2 = selector.invoke(UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(maxOfWith, i)));
                if (comparator.compare(rInvoke, rInvoke2) < 0) {
                    rInvoke = rInvoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return rInvoke;
    }

    /* JADX INFO: renamed from: maxOfWithOrNull-myNOsp4, reason: not valid java name */
    private static final <R> R m6336maxOfWithOrNullmyNOsp4(int[] maxOfWithOrNull, Comparator<? super R> comparator, Function1<? super UInt, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(maxOfWithOrNull, "$this$maxOfWithOrNull");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UIntArray.m5630isEmptyimpl(maxOfWithOrNull)) {
            return null;
        }
        R rInvoke = selector.invoke(UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(maxOfWithOrNull, 0)));
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(maxOfWithOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                R rInvoke2 = selector.invoke(UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(maxOfWithOrNull, i)));
                if (comparator.compare(rInvoke, rInvoke2) < 0) {
                    rInvoke = rInvoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return rInvoke;
    }

    /* JADX INFO: renamed from: maxOfWithOrNull-5NtCtWE, reason: not valid java name */
    private static final <R> R m6333maxOfWithOrNull5NtCtWE(long[] maxOfWithOrNull, Comparator<? super R> comparator, Function1<? super ULong, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(maxOfWithOrNull, "$this$maxOfWithOrNull");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (ULongArray.m5709isEmptyimpl(maxOfWithOrNull)) {
            return null;
        }
        R rInvoke = selector.invoke(ULong.m5640boximpl(ULongArray.m5706getsVKNKU(maxOfWithOrNull, 0)));
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(maxOfWithOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                R rInvoke2 = selector.invoke(ULong.m5640boximpl(ULongArray.m5706getsVKNKU(maxOfWithOrNull, i)));
                if (comparator.compare(rInvoke, rInvoke2) < 0) {
                    rInvoke = rInvoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return rInvoke;
    }

    /* JADX INFO: renamed from: maxOfWithOrNull-LTi4i_s, reason: not valid java name */
    private static final <R> R m6334maxOfWithOrNullLTi4i_s(byte[] maxOfWithOrNull, Comparator<? super R> comparator, Function1<? super UByte, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(maxOfWithOrNull, "$this$maxOfWithOrNull");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UByteArray.m5551isEmptyimpl(maxOfWithOrNull)) {
            return null;
        }
        R rInvoke = selector.invoke(UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(maxOfWithOrNull, 0)));
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(maxOfWithOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                R rInvoke2 = selector.invoke(UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(maxOfWithOrNull, i)));
                if (comparator.compare(rInvoke, rInvoke2) < 0) {
                    rInvoke = rInvoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return rInvoke;
    }

    /* JADX INFO: renamed from: maxOfWithOrNull-l8EHGbQ, reason: not valid java name */
    private static final <R> R m6335maxOfWithOrNulll8EHGbQ(short[] maxOfWithOrNull, Comparator<? super R> comparator, Function1<? super UShort, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(maxOfWithOrNull, "$this$maxOfWithOrNull");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UShortArray.m5814isEmptyimpl(maxOfWithOrNull)) {
            return null;
        }
        R rInvoke = selector.invoke(UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(maxOfWithOrNull, 0)));
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(maxOfWithOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                R rInvoke2 = selector.invoke(UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(maxOfWithOrNull, i)));
                if (comparator.compare(rInvoke, rInvoke2) < 0) {
                    rInvoke = rInvoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return rInvoke;
    }

    /* JADX INFO: renamed from: maxOrNull--ajY-9A, reason: not valid java name */
    public static final UInt m6337maxOrNullajY9A(@NotNull int[] maxOrNull) {
        Intrinsics.checkNotNullParameter(maxOrNull, "$this$maxOrNull");
        if (UIntArray.m5630isEmptyimpl(maxOrNull)) {
            return null;
        }
        int iM5627getpVg5ArA = UIntArray.m5627getpVg5ArA(maxOrNull, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(maxOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                int iM5627getpVg5ArA2 = UIntArray.m5627getpVg5ArA(maxOrNull, i);
                if (Integer.compare(iM5627getpVg5ArA ^ Integer.MIN_VALUE, iM5627getpVg5ArA2 ^ Integer.MIN_VALUE) < 0) {
                    iM5627getpVg5ArA = iM5627getpVg5ArA2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UInt.m5561boximpl(iM5627getpVg5ArA);
    }

    /* JADX INFO: renamed from: maxOrNull-QwZRm1k, reason: not valid java name */
    public static final ULong m6339maxOrNullQwZRm1k(@NotNull long[] maxOrNull) {
        Intrinsics.checkNotNullParameter(maxOrNull, "$this$maxOrNull");
        if (ULongArray.m5709isEmptyimpl(maxOrNull)) {
            return null;
        }
        long jM5706getsVKNKU = ULongArray.m5706getsVKNKU(maxOrNull, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(maxOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                long jM5706getsVKNKU2 = ULongArray.m5706getsVKNKU(maxOrNull, i);
                if (Long.compare(jM5706getsVKNKU ^ Long.MIN_VALUE, jM5706getsVKNKU2 ^ Long.MIN_VALUE) < 0) {
                    jM5706getsVKNKU = jM5706getsVKNKU2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return ULong.m5640boximpl(jM5706getsVKNKU);
    }

    /* JADX INFO: renamed from: maxOrNull-GBYM_sE, reason: not valid java name */
    public static final UByte m6338maxOrNullGBYM_sE(@NotNull byte[] maxOrNull) {
        Intrinsics.checkNotNullParameter(maxOrNull, "$this$maxOrNull");
        if (UByteArray.m5551isEmptyimpl(maxOrNull)) {
            return null;
        }
        byte bM5548getw2LRezQ = UByteArray.m5548getw2LRezQ(maxOrNull, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(maxOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte bM5548getw2LRezQ2 = UByteArray.m5548getw2LRezQ(maxOrNull, i);
                if (Intrinsics.compare(bM5548getw2LRezQ & 255, bM5548getw2LRezQ2 & 255) < 0) {
                    bM5548getw2LRezQ = bM5548getw2LRezQ2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UByte.m5484boximpl(bM5548getw2LRezQ);
    }

    /* JADX INFO: renamed from: maxOrNull-rL5Bavg, reason: not valid java name */
    public static final UShort m6340maxOrNullrL5Bavg(@NotNull short[] maxOrNull) {
        Intrinsics.checkNotNullParameter(maxOrNull, "$this$maxOrNull");
        if (UShortArray.m5814isEmptyimpl(maxOrNull)) {
            return null;
        }
        short sM5811getMh2AYeg = UShortArray.m5811getMh2AYeg(maxOrNull, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(maxOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                short sM5811getMh2AYeg2 = UShortArray.m5811getMh2AYeg(maxOrNull, i);
                if (Intrinsics.compare(sM5811getMh2AYeg & UShort.MAX_VALUE, 65535 & sM5811getMh2AYeg2) < 0) {
                    sM5811getMh2AYeg = sM5811getMh2AYeg2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UShort.m5747boximpl(sM5811getMh2AYeg);
    }

    /* JADX INFO: renamed from: maxWithOrThrow-U, reason: not valid java name */
    public static final int m6350maxWithOrThrowU(@NotNull int[] maxWith, @NotNull Comparator<? super UInt> comparator) {
        Intrinsics.checkNotNullParameter(maxWith, "$this$maxWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (UIntArray.m5630isEmptyimpl(maxWith)) {
            throw new NoSuchElementException();
        }
        int iM5627getpVg5ArA = UIntArray.m5627getpVg5ArA(maxWith, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(maxWith);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                int iM5627getpVg5ArA2 = UIntArray.m5627getpVg5ArA(maxWith, i);
                if (comparator.compare(UInt.m5561boximpl(iM5627getpVg5ArA), UInt.m5561boximpl(iM5627getpVg5ArA2)) < 0) {
                    iM5627getpVg5ArA = iM5627getpVg5ArA2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return iM5627getpVg5ArA;
    }

    /* JADX INFO: renamed from: maxWithOrThrow-U, reason: not valid java name */
    public static final long m6351maxWithOrThrowU(@NotNull long[] maxWith, @NotNull Comparator<? super ULong> comparator) {
        Intrinsics.checkNotNullParameter(maxWith, "$this$maxWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (ULongArray.m5709isEmptyimpl(maxWith)) {
            throw new NoSuchElementException();
        }
        long jM5706getsVKNKU = ULongArray.m5706getsVKNKU(maxWith, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(maxWith);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                long jM5706getsVKNKU2 = ULongArray.m5706getsVKNKU(maxWith, i);
                if (comparator.compare(ULong.m5640boximpl(jM5706getsVKNKU), ULong.m5640boximpl(jM5706getsVKNKU2)) < 0) {
                    jM5706getsVKNKU = jM5706getsVKNKU2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return jM5706getsVKNKU;
    }

    /* JADX INFO: renamed from: maxWithOrThrow-U, reason: not valid java name */
    public static final byte m6349maxWithOrThrowU(@NotNull byte[] maxWith, @NotNull Comparator<? super UByte> comparator) {
        Intrinsics.checkNotNullParameter(maxWith, "$this$maxWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (UByteArray.m5551isEmptyimpl(maxWith)) {
            throw new NoSuchElementException();
        }
        byte bM5548getw2LRezQ = UByteArray.m5548getw2LRezQ(maxWith, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(maxWith);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte bM5548getw2LRezQ2 = UByteArray.m5548getw2LRezQ(maxWith, i);
                if (comparator.compare(UByte.m5484boximpl(bM5548getw2LRezQ), UByte.m5484boximpl(bM5548getw2LRezQ2)) < 0) {
                    bM5548getw2LRezQ = bM5548getw2LRezQ2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return bM5548getw2LRezQ;
    }

    /* JADX INFO: renamed from: maxWithOrThrow-U, reason: not valid java name */
    public static final short m6352maxWithOrThrowU(@NotNull short[] maxWith, @NotNull Comparator<? super UShort> comparator) {
        Intrinsics.checkNotNullParameter(maxWith, "$this$maxWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (UShortArray.m5814isEmptyimpl(maxWith)) {
            throw new NoSuchElementException();
        }
        short sM5811getMh2AYeg = UShortArray.m5811getMh2AYeg(maxWith, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(maxWith);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                short sM5811getMh2AYeg2 = UShortArray.m5811getMh2AYeg(maxWith, i);
                if (comparator.compare(UShort.m5747boximpl(sM5811getMh2AYeg), UShort.m5747boximpl(sM5811getMh2AYeg2)) < 0) {
                    sM5811getMh2AYeg = sM5811getMh2AYeg2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return sM5811getMh2AYeg;
    }

    /* JADX INFO: renamed from: maxWithOrNull-YmdZ_VM, reason: not valid java name */
    public static final UInt m6346maxWithOrNullYmdZ_VM(@NotNull int[] maxWithOrNull, @NotNull Comparator<? super UInt> comparator) {
        Intrinsics.checkNotNullParameter(maxWithOrNull, "$this$maxWithOrNull");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (UIntArray.m5630isEmptyimpl(maxWithOrNull)) {
            return null;
        }
        int iM5627getpVg5ArA = UIntArray.m5627getpVg5ArA(maxWithOrNull, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(maxWithOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                int iM5627getpVg5ArA2 = UIntArray.m5627getpVg5ArA(maxWithOrNull, i);
                if (comparator.compare(UInt.m5561boximpl(iM5627getpVg5ArA), UInt.m5561boximpl(iM5627getpVg5ArA2)) < 0) {
                    iM5627getpVg5ArA = iM5627getpVg5ArA2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UInt.m5561boximpl(iM5627getpVg5ArA);
    }

    /* JADX INFO: renamed from: maxWithOrNull-zrEWJaI, reason: not valid java name */
    public static final ULong m6348maxWithOrNullzrEWJaI(@NotNull long[] maxWithOrNull, @NotNull Comparator<? super ULong> comparator) {
        Intrinsics.checkNotNullParameter(maxWithOrNull, "$this$maxWithOrNull");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (ULongArray.m5709isEmptyimpl(maxWithOrNull)) {
            return null;
        }
        long jM5706getsVKNKU = ULongArray.m5706getsVKNKU(maxWithOrNull, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(maxWithOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                long jM5706getsVKNKU2 = ULongArray.m5706getsVKNKU(maxWithOrNull, i);
                if (comparator.compare(ULong.m5640boximpl(jM5706getsVKNKU), ULong.m5640boximpl(jM5706getsVKNKU2)) < 0) {
                    jM5706getsVKNKU = jM5706getsVKNKU2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return ULong.m5640boximpl(jM5706getsVKNKU);
    }

    /* JADX INFO: renamed from: maxWithOrNull-XMRcp5o, reason: not valid java name */
    public static final UByte m6345maxWithOrNullXMRcp5o(@NotNull byte[] maxWithOrNull, @NotNull Comparator<? super UByte> comparator) {
        Intrinsics.checkNotNullParameter(maxWithOrNull, "$this$maxWithOrNull");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (UByteArray.m5551isEmptyimpl(maxWithOrNull)) {
            return null;
        }
        byte bM5548getw2LRezQ = UByteArray.m5548getw2LRezQ(maxWithOrNull, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(maxWithOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte bM5548getw2LRezQ2 = UByteArray.m5548getw2LRezQ(maxWithOrNull, i);
                if (comparator.compare(UByte.m5484boximpl(bM5548getw2LRezQ), UByte.m5484boximpl(bM5548getw2LRezQ2)) < 0) {
                    bM5548getw2LRezQ = bM5548getw2LRezQ2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UByte.m5484boximpl(bM5548getw2LRezQ);
    }

    /* JADX INFO: renamed from: maxWithOrNull-eOHTfZs, reason: not valid java name */
    public static final UShort m6347maxWithOrNulleOHTfZs(@NotNull short[] maxWithOrNull, @NotNull Comparator<? super UShort> comparator) {
        Intrinsics.checkNotNullParameter(maxWithOrNull, "$this$maxWithOrNull");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (UShortArray.m5814isEmptyimpl(maxWithOrNull)) {
            return null;
        }
        short sM5811getMh2AYeg = UShortArray.m5811getMh2AYeg(maxWithOrNull, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(maxWithOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                short sM5811getMh2AYeg2 = UShortArray.m5811getMh2AYeg(maxWithOrNull, i);
                if (comparator.compare(UShort.m5747boximpl(sM5811getMh2AYeg), UShort.m5747boximpl(sM5811getMh2AYeg2)) < 0) {
                    sM5811getMh2AYeg = sM5811getMh2AYeg2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UShort.m5747boximpl(sM5811getMh2AYeg);
    }

    /* JADX INFO: renamed from: minOrThrow-U, reason: not valid java name */
    public static final int m6398minOrThrowU(@NotNull int[] min) {
        Intrinsics.checkNotNullParameter(min, "$this$min");
        if (UIntArray.m5630isEmptyimpl(min)) {
            throw new NoSuchElementException();
        }
        int iM5627getpVg5ArA = UIntArray.m5627getpVg5ArA(min, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(min);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                int iM5627getpVg5ArA2 = UIntArray.m5627getpVg5ArA(min, i);
                if (Integer.compare(iM5627getpVg5ArA ^ Integer.MIN_VALUE, iM5627getpVg5ArA2 ^ Integer.MIN_VALUE) > 0) {
                    iM5627getpVg5ArA = iM5627getpVg5ArA2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return iM5627getpVg5ArA;
    }

    /* JADX INFO: renamed from: minOrThrow-U, reason: not valid java name */
    public static final long m6399minOrThrowU(@NotNull long[] min) {
        Intrinsics.checkNotNullParameter(min, "$this$min");
        if (ULongArray.m5709isEmptyimpl(min)) {
            throw new NoSuchElementException();
        }
        long jM5706getsVKNKU = ULongArray.m5706getsVKNKU(min, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(min);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                long jM5706getsVKNKU2 = ULongArray.m5706getsVKNKU(min, i);
                if (Long.compare(jM5706getsVKNKU ^ Long.MIN_VALUE, jM5706getsVKNKU2 ^ Long.MIN_VALUE) > 0) {
                    jM5706getsVKNKU = jM5706getsVKNKU2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return jM5706getsVKNKU;
    }

    /* JADX INFO: renamed from: minOrThrow-U, reason: not valid java name */
    public static final byte m6397minOrThrowU(@NotNull byte[] min) {
        Intrinsics.checkNotNullParameter(min, "$this$min");
        if (UByteArray.m5551isEmptyimpl(min)) {
            throw new NoSuchElementException();
        }
        byte bM5548getw2LRezQ = UByteArray.m5548getw2LRezQ(min, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(min);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte bM5548getw2LRezQ2 = UByteArray.m5548getw2LRezQ(min, i);
                if (Intrinsics.compare(bM5548getw2LRezQ & 255, bM5548getw2LRezQ2 & 255) > 0) {
                    bM5548getw2LRezQ = bM5548getw2LRezQ2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return bM5548getw2LRezQ;
    }

    /* JADX INFO: renamed from: minOrThrow-U, reason: not valid java name */
    public static final short m6400minOrThrowU(@NotNull short[] min) {
        Intrinsics.checkNotNullParameter(min, "$this$min");
        if (UShortArray.m5814isEmptyimpl(min)) {
            throw new NoSuchElementException();
        }
        short sM5811getMh2AYeg = UShortArray.m5811getMh2AYeg(min, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(min);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                short sM5811getMh2AYeg2 = UShortArray.m5811getMh2AYeg(min, i);
                if (Intrinsics.compare(sM5811getMh2AYeg & UShort.MAX_VALUE, 65535 & sM5811getMh2AYeg2) > 0) {
                    sM5811getMh2AYeg = sM5811getMh2AYeg2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return sM5811getMh2AYeg;
    }

    /* JADX INFO: renamed from: minByOrThrow-U, reason: not valid java name */
    private static final <R extends Comparable<? super R>> int m6358minByOrThrowU(int[] minBy, Function1<? super UInt, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(minBy, "$this$minBy");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UIntArray.m5630isEmptyimpl(minBy)) {
            throw new NoSuchElementException();
        }
        int iM5627getpVg5ArA = UIntArray.m5627getpVg5ArA(minBy, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(minBy);
        if (lastIndex == 0) {
            return iM5627getpVg5ArA;
        }
        R rInvoke = selector.invoke(UInt.m5561boximpl(iM5627getpVg5ArA));
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                int iM5627getpVg5ArA2 = UIntArray.m5627getpVg5ArA(minBy, i);
                R rInvoke2 = selector.invoke(UInt.m5561boximpl(iM5627getpVg5ArA2));
                if (rInvoke.compareTo(rInvoke2) > 0) {
                    iM5627getpVg5ArA = iM5627getpVg5ArA2;
                    rInvoke = rInvoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return iM5627getpVg5ArA;
    }

    /* JADX INFO: renamed from: minByOrThrow-U, reason: not valid java name */
    private static final <R extends Comparable<? super R>> long m6359minByOrThrowU(long[] minBy, Function1<? super ULong, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(minBy, "$this$minBy");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (ULongArray.m5709isEmptyimpl(minBy)) {
            throw new NoSuchElementException();
        }
        long jM5706getsVKNKU = ULongArray.m5706getsVKNKU(minBy, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(minBy);
        if (lastIndex == 0) {
            return jM5706getsVKNKU;
        }
        R rInvoke = selector.invoke(ULong.m5640boximpl(jM5706getsVKNKU));
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                long jM5706getsVKNKU2 = ULongArray.m5706getsVKNKU(minBy, i);
                R rInvoke2 = selector.invoke(ULong.m5640boximpl(jM5706getsVKNKU2));
                if (rInvoke.compareTo(rInvoke2) > 0) {
                    jM5706getsVKNKU = jM5706getsVKNKU2;
                    rInvoke = rInvoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return jM5706getsVKNKU;
    }

    /* JADX INFO: renamed from: minByOrThrow-U, reason: not valid java name */
    private static final <R extends Comparable<? super R>> byte m6357minByOrThrowU(byte[] minBy, Function1<? super UByte, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(minBy, "$this$minBy");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UByteArray.m5551isEmptyimpl(minBy)) {
            throw new NoSuchElementException();
        }
        byte bM5548getw2LRezQ = UByteArray.m5548getw2LRezQ(minBy, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(minBy);
        if (lastIndex == 0) {
            return bM5548getw2LRezQ;
        }
        R rInvoke = selector.invoke(UByte.m5484boximpl(bM5548getw2LRezQ));
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte bM5548getw2LRezQ2 = UByteArray.m5548getw2LRezQ(minBy, i);
                R rInvoke2 = selector.invoke(UByte.m5484boximpl(bM5548getw2LRezQ2));
                if (rInvoke.compareTo(rInvoke2) > 0) {
                    bM5548getw2LRezQ = bM5548getw2LRezQ2;
                    rInvoke = rInvoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return bM5548getw2LRezQ;
    }

    /* JADX INFO: renamed from: minByOrThrow-U, reason: not valid java name */
    private static final <R extends Comparable<? super R>> short m6360minByOrThrowU(short[] minBy, Function1<? super UShort, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(minBy, "$this$minBy");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UShortArray.m5814isEmptyimpl(minBy)) {
            throw new NoSuchElementException();
        }
        short sM5811getMh2AYeg = UShortArray.m5811getMh2AYeg(minBy, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(minBy);
        if (lastIndex == 0) {
            return sM5811getMh2AYeg;
        }
        R rInvoke = selector.invoke(UShort.m5747boximpl(sM5811getMh2AYeg));
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                short sM5811getMh2AYeg2 = UShortArray.m5811getMh2AYeg(minBy, i);
                R rInvoke2 = selector.invoke(UShort.m5747boximpl(sM5811getMh2AYeg2));
                if (rInvoke.compareTo(rInvoke2) > 0) {
                    sM5811getMh2AYeg = sM5811getMh2AYeg2;
                    rInvoke = rInvoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return sM5811getMh2AYeg;
    }

    /* JADX INFO: renamed from: minByOrNull-jgv0xPQ, reason: not valid java name */
    private static final <R extends Comparable<? super R>> UInt m6355minByOrNulljgv0xPQ(int[] minByOrNull, Function1<? super UInt, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(minByOrNull, "$this$minByOrNull");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UIntArray.m5630isEmptyimpl(minByOrNull)) {
            return null;
        }
        int iM5627getpVg5ArA = UIntArray.m5627getpVg5ArA(minByOrNull, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(minByOrNull);
        if (lastIndex == 0) {
            return UInt.m5561boximpl(iM5627getpVg5ArA);
        }
        R rInvoke = selector.invoke(UInt.m5561boximpl(iM5627getpVg5ArA));
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                int iM5627getpVg5ArA2 = UIntArray.m5627getpVg5ArA(minByOrNull, i);
                R rInvoke2 = selector.invoke(UInt.m5561boximpl(iM5627getpVg5ArA2));
                if (rInvoke.compareTo(rInvoke2) > 0) {
                    iM5627getpVg5ArA = iM5627getpVg5ArA2;
                    rInvoke = rInvoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UInt.m5561boximpl(iM5627getpVg5ArA);
    }

    /* JADX INFO: renamed from: minByOrNull-MShoTSo, reason: not valid java name */
    private static final <R extends Comparable<? super R>> ULong m6354minByOrNullMShoTSo(long[] minByOrNull, Function1<? super ULong, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(minByOrNull, "$this$minByOrNull");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (ULongArray.m5709isEmptyimpl(minByOrNull)) {
            return null;
        }
        long jM5706getsVKNKU = ULongArray.m5706getsVKNKU(minByOrNull, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(minByOrNull);
        if (lastIndex == 0) {
            return ULong.m5640boximpl(jM5706getsVKNKU);
        }
        R rInvoke = selector.invoke(ULong.m5640boximpl(jM5706getsVKNKU));
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                long jM5706getsVKNKU2 = ULongArray.m5706getsVKNKU(minByOrNull, i);
                R rInvoke2 = selector.invoke(ULong.m5640boximpl(jM5706getsVKNKU2));
                if (rInvoke.compareTo(rInvoke2) > 0) {
                    jM5706getsVKNKU = jM5706getsVKNKU2;
                    rInvoke = rInvoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return ULong.m5640boximpl(jM5706getsVKNKU);
    }

    /* JADX INFO: renamed from: minByOrNull-JOV_ifY, reason: not valid java name */
    private static final <R extends Comparable<? super R>> UByte m6353minByOrNullJOV_ifY(byte[] minByOrNull, Function1<? super UByte, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(minByOrNull, "$this$minByOrNull");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UByteArray.m5551isEmptyimpl(minByOrNull)) {
            return null;
        }
        byte bM5548getw2LRezQ = UByteArray.m5548getw2LRezQ(minByOrNull, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(minByOrNull);
        if (lastIndex == 0) {
            return UByte.m5484boximpl(bM5548getw2LRezQ);
        }
        R rInvoke = selector.invoke(UByte.m5484boximpl(bM5548getw2LRezQ));
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte bM5548getw2LRezQ2 = UByteArray.m5548getw2LRezQ(minByOrNull, i);
                R rInvoke2 = selector.invoke(UByte.m5484boximpl(bM5548getw2LRezQ2));
                if (rInvoke.compareTo(rInvoke2) > 0) {
                    bM5548getw2LRezQ = bM5548getw2LRezQ2;
                    rInvoke = rInvoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UByte.m5484boximpl(bM5548getw2LRezQ);
    }

    /* JADX INFO: renamed from: minByOrNull-xTcfx_M, reason: not valid java name */
    private static final <R extends Comparable<? super R>> UShort m6356minByOrNullxTcfx_M(short[] minByOrNull, Function1<? super UShort, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(minByOrNull, "$this$minByOrNull");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UShortArray.m5814isEmptyimpl(minByOrNull)) {
            return null;
        }
        short sM5811getMh2AYeg = UShortArray.m5811getMh2AYeg(minByOrNull, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(minByOrNull);
        if (lastIndex == 0) {
            return UShort.m5747boximpl(sM5811getMh2AYeg);
        }
        R rInvoke = selector.invoke(UShort.m5747boximpl(sM5811getMh2AYeg));
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                short sM5811getMh2AYeg2 = UShortArray.m5811getMh2AYeg(minByOrNull, i);
                R rInvoke2 = selector.invoke(UShort.m5747boximpl(sM5811getMh2AYeg2));
                if (rInvoke.compareTo(rInvoke2) > 0) {
                    sM5811getMh2AYeg = sM5811getMh2AYeg2;
                    rInvoke = rInvoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UShort.m5747boximpl(sM5811getMh2AYeg);
    }

    /* JADX INFO: renamed from: minOf-jgv0xPQ, reason: not valid java name */
    private static final double m6367minOfjgv0xPQ(int[] minOf, Function1<? super UInt, Double> selector) {
        Intrinsics.checkNotNullParameter(minOf, "$this$minOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UIntArray.m5630isEmptyimpl(minOf)) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.invoke(UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(minOf, 0))).doubleValue();
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(minOf);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.min(dDoubleValue, selector.invoke(UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(minOf, i))).doubleValue());
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return dDoubleValue;
    }

    /* JADX INFO: renamed from: minOf-MShoTSo, reason: not valid java name */
    private static final double m6364minOfMShoTSo(long[] minOf, Function1<? super ULong, Double> selector) {
        Intrinsics.checkNotNullParameter(minOf, "$this$minOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (ULongArray.m5709isEmptyimpl(minOf)) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.invoke(ULong.m5640boximpl(ULongArray.m5706getsVKNKU(minOf, 0))).doubleValue();
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(minOf);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.min(dDoubleValue, selector.invoke(ULong.m5640boximpl(ULongArray.m5706getsVKNKU(minOf, i))).doubleValue());
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return dDoubleValue;
    }

    /* JADX INFO: renamed from: minOf-JOV_ifY, reason: not valid java name */
    private static final double m6361minOfJOV_ifY(byte[] minOf, Function1<? super UByte, Double> selector) {
        Intrinsics.checkNotNullParameter(minOf, "$this$minOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UByteArray.m5551isEmptyimpl(minOf)) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.invoke(UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(minOf, 0))).doubleValue();
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(minOf);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.min(dDoubleValue, selector.invoke(UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(minOf, i))).doubleValue());
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return dDoubleValue;
    }

    /* JADX INFO: renamed from: minOf-xTcfx_M, reason: not valid java name */
    private static final double m6370minOfxTcfx_M(short[] minOf, Function1<? super UShort, Double> selector) {
        Intrinsics.checkNotNullParameter(minOf, "$this$minOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UShortArray.m5814isEmptyimpl(minOf)) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.invoke(UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(minOf, 0))).doubleValue();
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(minOf);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.min(dDoubleValue, selector.invoke(UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(minOf, i))).doubleValue());
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return dDoubleValue;
    }

    /* JADX INFO: renamed from: minOf-jgv0xPQ, reason: not valid java name */
    private static final float m6368minOfjgv0xPQ(int[] minOf, Function1<? super UInt, Float> selector) {
        Intrinsics.checkNotNullParameter(minOf, "$this$minOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UIntArray.m5630isEmptyimpl(minOf)) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.invoke(UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(minOf, 0))).floatValue();
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(minOf);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.min(fFloatValue, selector.invoke(UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(minOf, i))).floatValue());
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return fFloatValue;
    }

    /* JADX INFO: renamed from: minOf-MShoTSo, reason: not valid java name */
    private static final float m6365minOfMShoTSo(long[] minOf, Function1<? super ULong, Float> selector) {
        Intrinsics.checkNotNullParameter(minOf, "$this$minOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (ULongArray.m5709isEmptyimpl(minOf)) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.invoke(ULong.m5640boximpl(ULongArray.m5706getsVKNKU(minOf, 0))).floatValue();
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(minOf);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.min(fFloatValue, selector.invoke(ULong.m5640boximpl(ULongArray.m5706getsVKNKU(minOf, i))).floatValue());
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return fFloatValue;
    }

    /* JADX INFO: renamed from: minOf-JOV_ifY, reason: not valid java name */
    private static final float m6362minOfJOV_ifY(byte[] minOf, Function1<? super UByte, Float> selector) {
        Intrinsics.checkNotNullParameter(minOf, "$this$minOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UByteArray.m5551isEmptyimpl(minOf)) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.invoke(UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(minOf, 0))).floatValue();
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(minOf);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.min(fFloatValue, selector.invoke(UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(minOf, i))).floatValue());
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return fFloatValue;
    }

    /* JADX INFO: renamed from: minOf-xTcfx_M, reason: not valid java name */
    private static final float m6371minOfxTcfx_M(short[] minOf, Function1<? super UShort, Float> selector) {
        Intrinsics.checkNotNullParameter(minOf, "$this$minOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UShortArray.m5814isEmptyimpl(minOf)) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.invoke(UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(minOf, 0))).floatValue();
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(minOf);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.min(fFloatValue, selector.invoke(UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(minOf, i))).floatValue());
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return fFloatValue;
    }

    /* JADX INFO: renamed from: minOf-jgv0xPQ, reason: not valid java name */
    private static final <R extends Comparable<? super R>> R m6369minOfjgv0xPQ(int[] minOf, Function1<? super UInt, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(minOf, "$this$minOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UIntArray.m5630isEmptyimpl(minOf)) {
            throw new NoSuchElementException();
        }
        R rInvoke = selector.invoke(UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(minOf, 0)));
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(minOf);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                R rInvoke2 = selector.invoke(UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(minOf, i)));
                if (rInvoke.compareTo(rInvoke2) > 0) {
                    rInvoke = rInvoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return rInvoke;
    }

    /* JADX INFO: renamed from: minOf-MShoTSo, reason: not valid java name */
    private static final <R extends Comparable<? super R>> R m6366minOfMShoTSo(long[] minOf, Function1<? super ULong, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(minOf, "$this$minOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (ULongArray.m5709isEmptyimpl(minOf)) {
            throw new NoSuchElementException();
        }
        R rInvoke = selector.invoke(ULong.m5640boximpl(ULongArray.m5706getsVKNKU(minOf, 0)));
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(minOf);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                R rInvoke2 = selector.invoke(ULong.m5640boximpl(ULongArray.m5706getsVKNKU(minOf, i)));
                if (rInvoke.compareTo(rInvoke2) > 0) {
                    rInvoke = rInvoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return rInvoke;
    }

    /* JADX INFO: renamed from: minOf-JOV_ifY, reason: not valid java name */
    private static final <R extends Comparable<? super R>> R m6363minOfJOV_ifY(byte[] minOf, Function1<? super UByte, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(minOf, "$this$minOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UByteArray.m5551isEmptyimpl(minOf)) {
            throw new NoSuchElementException();
        }
        R rInvoke = selector.invoke(UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(minOf, 0)));
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(minOf);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                R rInvoke2 = selector.invoke(UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(minOf, i)));
                if (rInvoke.compareTo(rInvoke2) > 0) {
                    rInvoke = rInvoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return rInvoke;
    }

    /* JADX INFO: renamed from: minOf-xTcfx_M, reason: not valid java name */
    private static final <R extends Comparable<? super R>> R m6372minOfxTcfx_M(short[] minOf, Function1<? super UShort, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(minOf, "$this$minOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UShortArray.m5814isEmptyimpl(minOf)) {
            throw new NoSuchElementException();
        }
        R rInvoke = selector.invoke(UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(minOf, 0)));
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(minOf);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                R rInvoke2 = selector.invoke(UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(minOf, i)));
                if (rInvoke.compareTo(rInvoke2) > 0) {
                    rInvoke = rInvoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return rInvoke;
    }

    /* JADX INFO: renamed from: minOfOrNull-jgv0xPQ, reason: not valid java name */
    private static final Double m6380minOfOrNulljgv0xPQ(int[] minOfOrNull, Function1<? super UInt, Double> selector) {
        Intrinsics.checkNotNullParameter(minOfOrNull, "$this$minOfOrNull");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UIntArray.m5630isEmptyimpl(minOfOrNull)) {
            return null;
        }
        double dDoubleValue = selector.invoke(UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(minOfOrNull, 0))).doubleValue();
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(minOfOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.min(dDoubleValue, selector.invoke(UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(minOfOrNull, i))).doubleValue());
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    /* JADX INFO: renamed from: minOfOrNull-MShoTSo, reason: not valid java name */
    private static final Double m6377minOfOrNullMShoTSo(long[] minOfOrNull, Function1<? super ULong, Double> selector) {
        Intrinsics.checkNotNullParameter(minOfOrNull, "$this$minOfOrNull");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (ULongArray.m5709isEmptyimpl(minOfOrNull)) {
            return null;
        }
        double dDoubleValue = selector.invoke(ULong.m5640boximpl(ULongArray.m5706getsVKNKU(minOfOrNull, 0))).doubleValue();
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(minOfOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.min(dDoubleValue, selector.invoke(ULong.m5640boximpl(ULongArray.m5706getsVKNKU(minOfOrNull, i))).doubleValue());
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    /* JADX INFO: renamed from: minOfOrNull-JOV_ifY, reason: not valid java name */
    private static final Double m6374minOfOrNullJOV_ifY(byte[] minOfOrNull, Function1<? super UByte, Double> selector) {
        Intrinsics.checkNotNullParameter(minOfOrNull, "$this$minOfOrNull");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UByteArray.m5551isEmptyimpl(minOfOrNull)) {
            return null;
        }
        double dDoubleValue = selector.invoke(UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(minOfOrNull, 0))).doubleValue();
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(minOfOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.min(dDoubleValue, selector.invoke(UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(minOfOrNull, i))).doubleValue());
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    /* JADX INFO: renamed from: minOfOrNull-xTcfx_M, reason: not valid java name */
    private static final Double m6383minOfOrNullxTcfx_M(short[] minOfOrNull, Function1<? super UShort, Double> selector) {
        Intrinsics.checkNotNullParameter(minOfOrNull, "$this$minOfOrNull");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UShortArray.m5814isEmptyimpl(minOfOrNull)) {
            return null;
        }
        double dDoubleValue = selector.invoke(UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(minOfOrNull, 0))).doubleValue();
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(minOfOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.min(dDoubleValue, selector.invoke(UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(minOfOrNull, i))).doubleValue());
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    /* JADX INFO: renamed from: minOfOrNull-jgv0xPQ, reason: not valid java name */
    private static final Float m6381minOfOrNulljgv0xPQ(int[] minOfOrNull, Function1<? super UInt, Float> selector) {
        Intrinsics.checkNotNullParameter(minOfOrNull, "$this$minOfOrNull");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UIntArray.m5630isEmptyimpl(minOfOrNull)) {
            return null;
        }
        float fFloatValue = selector.invoke(UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(minOfOrNull, 0))).floatValue();
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(minOfOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.min(fFloatValue, selector.invoke(UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(minOfOrNull, i))).floatValue());
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    /* JADX INFO: renamed from: minOfOrNull-MShoTSo, reason: not valid java name */
    private static final Float m6378minOfOrNullMShoTSo(long[] minOfOrNull, Function1<? super ULong, Float> selector) {
        Intrinsics.checkNotNullParameter(minOfOrNull, "$this$minOfOrNull");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (ULongArray.m5709isEmptyimpl(minOfOrNull)) {
            return null;
        }
        float fFloatValue = selector.invoke(ULong.m5640boximpl(ULongArray.m5706getsVKNKU(minOfOrNull, 0))).floatValue();
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(minOfOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.min(fFloatValue, selector.invoke(ULong.m5640boximpl(ULongArray.m5706getsVKNKU(minOfOrNull, i))).floatValue());
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    /* JADX INFO: renamed from: minOfOrNull-JOV_ifY, reason: not valid java name */
    private static final Float m6375minOfOrNullJOV_ifY(byte[] minOfOrNull, Function1<? super UByte, Float> selector) {
        Intrinsics.checkNotNullParameter(minOfOrNull, "$this$minOfOrNull");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UByteArray.m5551isEmptyimpl(minOfOrNull)) {
            return null;
        }
        float fFloatValue = selector.invoke(UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(minOfOrNull, 0))).floatValue();
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(minOfOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.min(fFloatValue, selector.invoke(UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(minOfOrNull, i))).floatValue());
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    /* JADX INFO: renamed from: minOfOrNull-xTcfx_M, reason: not valid java name */
    private static final Float m6384minOfOrNullxTcfx_M(short[] minOfOrNull, Function1<? super UShort, Float> selector) {
        Intrinsics.checkNotNullParameter(minOfOrNull, "$this$minOfOrNull");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UShortArray.m5814isEmptyimpl(minOfOrNull)) {
            return null;
        }
        float fFloatValue = selector.invoke(UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(minOfOrNull, 0))).floatValue();
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(minOfOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.min(fFloatValue, selector.invoke(UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(minOfOrNull, i))).floatValue());
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    /* JADX INFO: renamed from: minOfOrNull-jgv0xPQ, reason: not valid java name */
    private static final <R extends Comparable<? super R>> R m6379minOfOrNulljgv0xPQ(int[] minOfOrNull, Function1<? super UInt, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(minOfOrNull, "$this$minOfOrNull");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UIntArray.m5630isEmptyimpl(minOfOrNull)) {
            return null;
        }
        R rInvoke = selector.invoke(UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(minOfOrNull, 0)));
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(minOfOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                R rInvoke2 = selector.invoke(UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(minOfOrNull, i)));
                if (rInvoke.compareTo(rInvoke2) > 0) {
                    rInvoke = rInvoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return rInvoke;
    }

    /* JADX INFO: renamed from: minOfOrNull-MShoTSo, reason: not valid java name */
    private static final <R extends Comparable<? super R>> R m6376minOfOrNullMShoTSo(long[] minOfOrNull, Function1<? super ULong, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(minOfOrNull, "$this$minOfOrNull");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (ULongArray.m5709isEmptyimpl(minOfOrNull)) {
            return null;
        }
        R rInvoke = selector.invoke(ULong.m5640boximpl(ULongArray.m5706getsVKNKU(minOfOrNull, 0)));
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(minOfOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                R rInvoke2 = selector.invoke(ULong.m5640boximpl(ULongArray.m5706getsVKNKU(minOfOrNull, i)));
                if (rInvoke.compareTo(rInvoke2) > 0) {
                    rInvoke = rInvoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return rInvoke;
    }

    /* JADX INFO: renamed from: minOfOrNull-JOV_ifY, reason: not valid java name */
    private static final <R extends Comparable<? super R>> R m6373minOfOrNullJOV_ifY(byte[] minOfOrNull, Function1<? super UByte, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(minOfOrNull, "$this$minOfOrNull");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UByteArray.m5551isEmptyimpl(minOfOrNull)) {
            return null;
        }
        R rInvoke = selector.invoke(UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(minOfOrNull, 0)));
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(minOfOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                R rInvoke2 = selector.invoke(UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(minOfOrNull, i)));
                if (rInvoke.compareTo(rInvoke2) > 0) {
                    rInvoke = rInvoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return rInvoke;
    }

    /* JADX INFO: renamed from: minOfOrNull-xTcfx_M, reason: not valid java name */
    private static final <R extends Comparable<? super R>> R m6382minOfOrNullxTcfx_M(short[] minOfOrNull, Function1<? super UShort, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(minOfOrNull, "$this$minOfOrNull");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UShortArray.m5814isEmptyimpl(minOfOrNull)) {
            return null;
        }
        R rInvoke = selector.invoke(UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(minOfOrNull, 0)));
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(minOfOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                R rInvoke2 = selector.invoke(UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(minOfOrNull, i)));
                if (rInvoke.compareTo(rInvoke2) > 0) {
                    rInvoke = rInvoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return rInvoke;
    }

    /* JADX INFO: renamed from: minOfWith-myNOsp4, reason: not valid java name */
    private static final <R> R m6388minOfWithmyNOsp4(int[] minOfWith, Comparator<? super R> comparator, Function1<? super UInt, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(minOfWith, "$this$minOfWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UIntArray.m5630isEmptyimpl(minOfWith)) {
            throw new NoSuchElementException();
        }
        R rInvoke = selector.invoke(UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(minOfWith, 0)));
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(minOfWith);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                R rInvoke2 = selector.invoke(UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(minOfWith, i)));
                if (comparator.compare(rInvoke, rInvoke2) > 0) {
                    rInvoke = rInvoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return rInvoke;
    }

    /* JADX INFO: renamed from: minOfWith-5NtCtWE, reason: not valid java name */
    private static final <R> R m6385minOfWith5NtCtWE(long[] minOfWith, Comparator<? super R> comparator, Function1<? super ULong, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(minOfWith, "$this$minOfWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (ULongArray.m5709isEmptyimpl(minOfWith)) {
            throw new NoSuchElementException();
        }
        R rInvoke = selector.invoke(ULong.m5640boximpl(ULongArray.m5706getsVKNKU(minOfWith, 0)));
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(minOfWith);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                R rInvoke2 = selector.invoke(ULong.m5640boximpl(ULongArray.m5706getsVKNKU(minOfWith, i)));
                if (comparator.compare(rInvoke, rInvoke2) > 0) {
                    rInvoke = rInvoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return rInvoke;
    }

    /* JADX INFO: renamed from: minOfWith-LTi4i_s, reason: not valid java name */
    private static final <R> R m6386minOfWithLTi4i_s(byte[] minOfWith, Comparator<? super R> comparator, Function1<? super UByte, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(minOfWith, "$this$minOfWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UByteArray.m5551isEmptyimpl(minOfWith)) {
            throw new NoSuchElementException();
        }
        R rInvoke = selector.invoke(UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(minOfWith, 0)));
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(minOfWith);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                R rInvoke2 = selector.invoke(UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(minOfWith, i)));
                if (comparator.compare(rInvoke, rInvoke2) > 0) {
                    rInvoke = rInvoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return rInvoke;
    }

    /* JADX INFO: renamed from: minOfWith-l8EHGbQ, reason: not valid java name */
    private static final <R> R m6387minOfWithl8EHGbQ(short[] minOfWith, Comparator<? super R> comparator, Function1<? super UShort, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(minOfWith, "$this$minOfWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UShortArray.m5814isEmptyimpl(minOfWith)) {
            throw new NoSuchElementException();
        }
        R rInvoke = selector.invoke(UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(minOfWith, 0)));
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(minOfWith);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                R rInvoke2 = selector.invoke(UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(minOfWith, i)));
                if (comparator.compare(rInvoke, rInvoke2) > 0) {
                    rInvoke = rInvoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return rInvoke;
    }

    /* JADX INFO: renamed from: minOfWithOrNull-myNOsp4, reason: not valid java name */
    private static final <R> R m6392minOfWithOrNullmyNOsp4(int[] minOfWithOrNull, Comparator<? super R> comparator, Function1<? super UInt, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(minOfWithOrNull, "$this$minOfWithOrNull");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UIntArray.m5630isEmptyimpl(minOfWithOrNull)) {
            return null;
        }
        R rInvoke = selector.invoke(UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(minOfWithOrNull, 0)));
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(minOfWithOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                R rInvoke2 = selector.invoke(UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(minOfWithOrNull, i)));
                if (comparator.compare(rInvoke, rInvoke2) > 0) {
                    rInvoke = rInvoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return rInvoke;
    }

    /* JADX INFO: renamed from: minOfWithOrNull-5NtCtWE, reason: not valid java name */
    private static final <R> R m6389minOfWithOrNull5NtCtWE(long[] minOfWithOrNull, Comparator<? super R> comparator, Function1<? super ULong, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(minOfWithOrNull, "$this$minOfWithOrNull");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (ULongArray.m5709isEmptyimpl(minOfWithOrNull)) {
            return null;
        }
        R rInvoke = selector.invoke(ULong.m5640boximpl(ULongArray.m5706getsVKNKU(minOfWithOrNull, 0)));
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(minOfWithOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                R rInvoke2 = selector.invoke(ULong.m5640boximpl(ULongArray.m5706getsVKNKU(minOfWithOrNull, i)));
                if (comparator.compare(rInvoke, rInvoke2) > 0) {
                    rInvoke = rInvoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return rInvoke;
    }

    /* JADX INFO: renamed from: minOfWithOrNull-LTi4i_s, reason: not valid java name */
    private static final <R> R m6390minOfWithOrNullLTi4i_s(byte[] minOfWithOrNull, Comparator<? super R> comparator, Function1<? super UByte, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(minOfWithOrNull, "$this$minOfWithOrNull");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UByteArray.m5551isEmptyimpl(minOfWithOrNull)) {
            return null;
        }
        R rInvoke = selector.invoke(UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(minOfWithOrNull, 0)));
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(minOfWithOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                R rInvoke2 = selector.invoke(UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(minOfWithOrNull, i)));
                if (comparator.compare(rInvoke, rInvoke2) > 0) {
                    rInvoke = rInvoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return rInvoke;
    }

    /* JADX INFO: renamed from: minOfWithOrNull-l8EHGbQ, reason: not valid java name */
    private static final <R> R m6391minOfWithOrNulll8EHGbQ(short[] minOfWithOrNull, Comparator<? super R> comparator, Function1<? super UShort, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(minOfWithOrNull, "$this$minOfWithOrNull");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UShortArray.m5814isEmptyimpl(minOfWithOrNull)) {
            return null;
        }
        R rInvoke = selector.invoke(UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(minOfWithOrNull, 0)));
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(minOfWithOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                R rInvoke2 = selector.invoke(UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(minOfWithOrNull, i)));
                if (comparator.compare(rInvoke, rInvoke2) > 0) {
                    rInvoke = rInvoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return rInvoke;
    }

    /* JADX INFO: renamed from: minOrNull--ajY-9A, reason: not valid java name */
    public static final UInt m6393minOrNullajY9A(@NotNull int[] minOrNull) {
        Intrinsics.checkNotNullParameter(minOrNull, "$this$minOrNull");
        if (UIntArray.m5630isEmptyimpl(minOrNull)) {
            return null;
        }
        int iM5627getpVg5ArA = UIntArray.m5627getpVg5ArA(minOrNull, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(minOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                int iM5627getpVg5ArA2 = UIntArray.m5627getpVg5ArA(minOrNull, i);
                if (Integer.compare(iM5627getpVg5ArA ^ Integer.MIN_VALUE, iM5627getpVg5ArA2 ^ Integer.MIN_VALUE) > 0) {
                    iM5627getpVg5ArA = iM5627getpVg5ArA2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UInt.m5561boximpl(iM5627getpVg5ArA);
    }

    /* JADX INFO: renamed from: minOrNull-QwZRm1k, reason: not valid java name */
    public static final ULong m6395minOrNullQwZRm1k(@NotNull long[] minOrNull) {
        Intrinsics.checkNotNullParameter(minOrNull, "$this$minOrNull");
        if (ULongArray.m5709isEmptyimpl(minOrNull)) {
            return null;
        }
        long jM5706getsVKNKU = ULongArray.m5706getsVKNKU(minOrNull, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(minOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                long jM5706getsVKNKU2 = ULongArray.m5706getsVKNKU(minOrNull, i);
                if (Long.compare(jM5706getsVKNKU ^ Long.MIN_VALUE, jM5706getsVKNKU2 ^ Long.MIN_VALUE) > 0) {
                    jM5706getsVKNKU = jM5706getsVKNKU2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return ULong.m5640boximpl(jM5706getsVKNKU);
    }

    /* JADX INFO: renamed from: minOrNull-GBYM_sE, reason: not valid java name */
    public static final UByte m6394minOrNullGBYM_sE(@NotNull byte[] minOrNull) {
        Intrinsics.checkNotNullParameter(minOrNull, "$this$minOrNull");
        if (UByteArray.m5551isEmptyimpl(minOrNull)) {
            return null;
        }
        byte bM5548getw2LRezQ = UByteArray.m5548getw2LRezQ(minOrNull, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(minOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte bM5548getw2LRezQ2 = UByteArray.m5548getw2LRezQ(minOrNull, i);
                if (Intrinsics.compare(bM5548getw2LRezQ & 255, bM5548getw2LRezQ2 & 255) > 0) {
                    bM5548getw2LRezQ = bM5548getw2LRezQ2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UByte.m5484boximpl(bM5548getw2LRezQ);
    }

    /* JADX INFO: renamed from: minOrNull-rL5Bavg, reason: not valid java name */
    public static final UShort m6396minOrNullrL5Bavg(@NotNull short[] minOrNull) {
        Intrinsics.checkNotNullParameter(minOrNull, "$this$minOrNull");
        if (UShortArray.m5814isEmptyimpl(minOrNull)) {
            return null;
        }
        short sM5811getMh2AYeg = UShortArray.m5811getMh2AYeg(minOrNull, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(minOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                short sM5811getMh2AYeg2 = UShortArray.m5811getMh2AYeg(minOrNull, i);
                if (Intrinsics.compare(sM5811getMh2AYeg & UShort.MAX_VALUE, 65535 & sM5811getMh2AYeg2) > 0) {
                    sM5811getMh2AYeg = sM5811getMh2AYeg2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UShort.m5747boximpl(sM5811getMh2AYeg);
    }

    /* JADX INFO: renamed from: minWithOrThrow-U, reason: not valid java name */
    public static final int m6406minWithOrThrowU(@NotNull int[] minWith, @NotNull Comparator<? super UInt> comparator) {
        Intrinsics.checkNotNullParameter(minWith, "$this$minWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (UIntArray.m5630isEmptyimpl(minWith)) {
            throw new NoSuchElementException();
        }
        int iM5627getpVg5ArA = UIntArray.m5627getpVg5ArA(minWith, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(minWith);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                int iM5627getpVg5ArA2 = UIntArray.m5627getpVg5ArA(minWith, i);
                if (comparator.compare(UInt.m5561boximpl(iM5627getpVg5ArA), UInt.m5561boximpl(iM5627getpVg5ArA2)) > 0) {
                    iM5627getpVg5ArA = iM5627getpVg5ArA2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return iM5627getpVg5ArA;
    }

    /* JADX INFO: renamed from: minWithOrThrow-U, reason: not valid java name */
    public static final long m6407minWithOrThrowU(@NotNull long[] minWith, @NotNull Comparator<? super ULong> comparator) {
        Intrinsics.checkNotNullParameter(minWith, "$this$minWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (ULongArray.m5709isEmptyimpl(minWith)) {
            throw new NoSuchElementException();
        }
        long jM5706getsVKNKU = ULongArray.m5706getsVKNKU(minWith, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(minWith);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                long jM5706getsVKNKU2 = ULongArray.m5706getsVKNKU(minWith, i);
                if (comparator.compare(ULong.m5640boximpl(jM5706getsVKNKU), ULong.m5640boximpl(jM5706getsVKNKU2)) > 0) {
                    jM5706getsVKNKU = jM5706getsVKNKU2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return jM5706getsVKNKU;
    }

    /* JADX INFO: renamed from: minWithOrThrow-U, reason: not valid java name */
    public static final byte m6405minWithOrThrowU(@NotNull byte[] minWith, @NotNull Comparator<? super UByte> comparator) {
        Intrinsics.checkNotNullParameter(minWith, "$this$minWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (UByteArray.m5551isEmptyimpl(minWith)) {
            throw new NoSuchElementException();
        }
        byte bM5548getw2LRezQ = UByteArray.m5548getw2LRezQ(minWith, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(minWith);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte bM5548getw2LRezQ2 = UByteArray.m5548getw2LRezQ(minWith, i);
                if (comparator.compare(UByte.m5484boximpl(bM5548getw2LRezQ), UByte.m5484boximpl(bM5548getw2LRezQ2)) > 0) {
                    bM5548getw2LRezQ = bM5548getw2LRezQ2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return bM5548getw2LRezQ;
    }

    /* JADX INFO: renamed from: minWithOrThrow-U, reason: not valid java name */
    public static final short m6408minWithOrThrowU(@NotNull short[] minWith, @NotNull Comparator<? super UShort> comparator) {
        Intrinsics.checkNotNullParameter(minWith, "$this$minWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (UShortArray.m5814isEmptyimpl(minWith)) {
            throw new NoSuchElementException();
        }
        short sM5811getMh2AYeg = UShortArray.m5811getMh2AYeg(minWith, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(minWith);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                short sM5811getMh2AYeg2 = UShortArray.m5811getMh2AYeg(minWith, i);
                if (comparator.compare(UShort.m5747boximpl(sM5811getMh2AYeg), UShort.m5747boximpl(sM5811getMh2AYeg2)) > 0) {
                    sM5811getMh2AYeg = sM5811getMh2AYeg2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return sM5811getMh2AYeg;
    }

    /* JADX INFO: renamed from: minWithOrNull-YmdZ_VM, reason: not valid java name */
    public static final UInt m6402minWithOrNullYmdZ_VM(@NotNull int[] minWithOrNull, @NotNull Comparator<? super UInt> comparator) {
        Intrinsics.checkNotNullParameter(minWithOrNull, "$this$minWithOrNull");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (UIntArray.m5630isEmptyimpl(minWithOrNull)) {
            return null;
        }
        int iM5627getpVg5ArA = UIntArray.m5627getpVg5ArA(minWithOrNull, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(minWithOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                int iM5627getpVg5ArA2 = UIntArray.m5627getpVg5ArA(minWithOrNull, i);
                if (comparator.compare(UInt.m5561boximpl(iM5627getpVg5ArA), UInt.m5561boximpl(iM5627getpVg5ArA2)) > 0) {
                    iM5627getpVg5ArA = iM5627getpVg5ArA2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UInt.m5561boximpl(iM5627getpVg5ArA);
    }

    /* JADX INFO: renamed from: minWithOrNull-zrEWJaI, reason: not valid java name */
    public static final ULong m6404minWithOrNullzrEWJaI(@NotNull long[] minWithOrNull, @NotNull Comparator<? super ULong> comparator) {
        Intrinsics.checkNotNullParameter(minWithOrNull, "$this$minWithOrNull");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (ULongArray.m5709isEmptyimpl(minWithOrNull)) {
            return null;
        }
        long jM5706getsVKNKU = ULongArray.m5706getsVKNKU(minWithOrNull, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(minWithOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                long jM5706getsVKNKU2 = ULongArray.m5706getsVKNKU(minWithOrNull, i);
                if (comparator.compare(ULong.m5640boximpl(jM5706getsVKNKU), ULong.m5640boximpl(jM5706getsVKNKU2)) > 0) {
                    jM5706getsVKNKU = jM5706getsVKNKU2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return ULong.m5640boximpl(jM5706getsVKNKU);
    }

    /* JADX INFO: renamed from: minWithOrNull-XMRcp5o, reason: not valid java name */
    public static final UByte m6401minWithOrNullXMRcp5o(@NotNull byte[] minWithOrNull, @NotNull Comparator<? super UByte> comparator) {
        Intrinsics.checkNotNullParameter(minWithOrNull, "$this$minWithOrNull");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (UByteArray.m5551isEmptyimpl(minWithOrNull)) {
            return null;
        }
        byte bM5548getw2LRezQ = UByteArray.m5548getw2LRezQ(minWithOrNull, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(minWithOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte bM5548getw2LRezQ2 = UByteArray.m5548getw2LRezQ(minWithOrNull, i);
                if (comparator.compare(UByte.m5484boximpl(bM5548getw2LRezQ), UByte.m5484boximpl(bM5548getw2LRezQ2)) > 0) {
                    bM5548getw2LRezQ = bM5548getw2LRezQ2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UByte.m5484boximpl(bM5548getw2LRezQ);
    }

    /* JADX INFO: renamed from: minWithOrNull-eOHTfZs, reason: not valid java name */
    public static final UShort m6403minWithOrNulleOHTfZs(@NotNull short[] minWithOrNull, @NotNull Comparator<? super UShort> comparator) {
        Intrinsics.checkNotNullParameter(minWithOrNull, "$this$minWithOrNull");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (UShortArray.m5814isEmptyimpl(minWithOrNull)) {
            return null;
        }
        short sM5811getMh2AYeg = UShortArray.m5811getMh2AYeg(minWithOrNull, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(minWithOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                short sM5811getMh2AYeg2 = UShortArray.m5811getMh2AYeg(minWithOrNull, i);
                if (comparator.compare(UShort.m5747boximpl(sM5811getMh2AYeg), UShort.m5747boximpl(sM5811getMh2AYeg2)) > 0) {
                    sM5811getMh2AYeg = sM5811getMh2AYeg2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UShort.m5747boximpl(sM5811getMh2AYeg);
    }

    /* JADX INFO: renamed from: none--ajY-9A, reason: not valid java name */
    private static final boolean m6409noneajY9A(int[] none) {
        Intrinsics.checkNotNullParameter(none, "$this$none");
        return UIntArray.m5630isEmptyimpl(none);
    }

    /* JADX INFO: renamed from: none-QwZRm1k, reason: not valid java name */
    private static final boolean m6413noneQwZRm1k(long[] none) {
        Intrinsics.checkNotNullParameter(none, "$this$none");
        return ULongArray.m5709isEmptyimpl(none);
    }

    /* JADX INFO: renamed from: none-GBYM_sE, reason: not valid java name */
    private static final boolean m6410noneGBYM_sE(byte[] none) {
        Intrinsics.checkNotNullParameter(none, "$this$none");
        return UByteArray.m5551isEmptyimpl(none);
    }

    /* JADX INFO: renamed from: none-rL5Bavg, reason: not valid java name */
    private static final boolean m6415nonerL5Bavg(short[] none) {
        Intrinsics.checkNotNullParameter(none, "$this$none");
        return UShortArray.m5814isEmptyimpl(none);
    }

    /* JADX INFO: renamed from: none-jgv0xPQ, reason: not valid java name */
    private static final boolean m6414nonejgv0xPQ(int[] none, Function1<? super UInt, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(none, "$this$none");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iM5628getSizeimpl = UIntArray.m5628getSizeimpl(none);
        for (int i = 0; i < iM5628getSizeimpl; i++) {
            if (predicate.invoke(UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(none, i))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: none-MShoTSo, reason: not valid java name */
    private static final boolean m6412noneMShoTSo(long[] none, Function1<? super ULong, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(none, "$this$none");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iM5707getSizeimpl = ULongArray.m5707getSizeimpl(none);
        for (int i = 0; i < iM5707getSizeimpl; i++) {
            if (predicate.invoke(ULong.m5640boximpl(ULongArray.m5706getsVKNKU(none, i))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: none-JOV_ifY, reason: not valid java name */
    private static final boolean m6411noneJOV_ifY(byte[] none, Function1<? super UByte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(none, "$this$none");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iM5549getSizeimpl = UByteArray.m5549getSizeimpl(none);
        for (int i = 0; i < iM5549getSizeimpl; i++) {
            if (predicate.invoke(UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(none, i))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: none-xTcfx_M, reason: not valid java name */
    private static final boolean m6416nonexTcfx_M(short[] none, Function1<? super UShort, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(none, "$this$none");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iM5812getSizeimpl = UShortArray.m5812getSizeimpl(none);
        for (int i = 0; i < iM5812getSizeimpl; i++) {
            if (predicate.invoke(UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(none, i))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: onEach-jgv0xPQ, reason: not valid java name */
    private static final int[] m6419onEachjgv0xPQ(int[] onEach, Function1<? super UInt, Unit> action) {
        Intrinsics.checkNotNullParameter(onEach, "$this$onEach");
        Intrinsics.checkNotNullParameter(action, "action");
        int iM5628getSizeimpl = UIntArray.m5628getSizeimpl(onEach);
        for (int i = 0; i < iM5628getSizeimpl; i++) {
            action.invoke(UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(onEach, i)));
        }
        return onEach;
    }

    /* JADX INFO: renamed from: onEach-MShoTSo, reason: not valid java name */
    private static final long[] m6418onEachMShoTSo(long[] onEach, Function1<? super ULong, Unit> action) {
        Intrinsics.checkNotNullParameter(onEach, "$this$onEach");
        Intrinsics.checkNotNullParameter(action, "action");
        int iM5707getSizeimpl = ULongArray.m5707getSizeimpl(onEach);
        for (int i = 0; i < iM5707getSizeimpl; i++) {
            action.invoke(ULong.m5640boximpl(ULongArray.m5706getsVKNKU(onEach, i)));
        }
        return onEach;
    }

    /* JADX INFO: renamed from: onEach-JOV_ifY, reason: not valid java name */
    private static final byte[] m6417onEachJOV_ifY(byte[] onEach, Function1<? super UByte, Unit> action) {
        Intrinsics.checkNotNullParameter(onEach, "$this$onEach");
        Intrinsics.checkNotNullParameter(action, "action");
        int iM5549getSizeimpl = UByteArray.m5549getSizeimpl(onEach);
        for (int i = 0; i < iM5549getSizeimpl; i++) {
            action.invoke(UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(onEach, i)));
        }
        return onEach;
    }

    /* JADX INFO: renamed from: onEach-xTcfx_M, reason: not valid java name */
    private static final short[] m6420onEachxTcfx_M(short[] onEach, Function1<? super UShort, Unit> action) {
        Intrinsics.checkNotNullParameter(onEach, "$this$onEach");
        Intrinsics.checkNotNullParameter(action, "action");
        int iM5812getSizeimpl = UShortArray.m5812getSizeimpl(onEach);
        for (int i = 0; i < iM5812getSizeimpl; i++) {
            action.invoke(UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(onEach, i)));
        }
        return onEach;
    }

    /* JADX INFO: renamed from: onEachIndexed-WyvcNBI, reason: not valid java name */
    private static final int[] m6422onEachIndexedWyvcNBI(int[] onEachIndexed, Function2<? super Integer, ? super UInt, Unit> action) {
        Intrinsics.checkNotNullParameter(onEachIndexed, "$this$onEachIndexed");
        Intrinsics.checkNotNullParameter(action, "action");
        int iM5628getSizeimpl = UIntArray.m5628getSizeimpl(onEachIndexed);
        int i = 0;
        int i2 = 0;
        while (i < iM5628getSizeimpl) {
            action.invoke(Integer.valueOf(i2), UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(onEachIndexed, i)));
            i++;
            i2++;
        }
        return onEachIndexed;
    }

    /* JADX INFO: renamed from: onEachIndexed-s8dVfGU, reason: not valid java name */
    private static final long[] m6423onEachIndexeds8dVfGU(long[] onEachIndexed, Function2<? super Integer, ? super ULong, Unit> action) {
        Intrinsics.checkNotNullParameter(onEachIndexed, "$this$onEachIndexed");
        Intrinsics.checkNotNullParameter(action, "action");
        int iM5707getSizeimpl = ULongArray.m5707getSizeimpl(onEachIndexed);
        int i = 0;
        int i2 = 0;
        while (i < iM5707getSizeimpl) {
            action.invoke(Integer.valueOf(i2), ULong.m5640boximpl(ULongArray.m5706getsVKNKU(onEachIndexed, i)));
            i++;
            i2++;
        }
        return onEachIndexed;
    }

    /* JADX INFO: renamed from: onEachIndexed-ELGow60, reason: not valid java name */
    private static final byte[] m6421onEachIndexedELGow60(byte[] onEachIndexed, Function2<? super Integer, ? super UByte, Unit> action) {
        Intrinsics.checkNotNullParameter(onEachIndexed, "$this$onEachIndexed");
        Intrinsics.checkNotNullParameter(action, "action");
        int iM5549getSizeimpl = UByteArray.m5549getSizeimpl(onEachIndexed);
        int i = 0;
        int i2 = 0;
        while (i < iM5549getSizeimpl) {
            action.invoke(Integer.valueOf(i2), UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(onEachIndexed, i)));
            i++;
            i2++;
        }
        return onEachIndexed;
    }

    /* JADX INFO: renamed from: onEachIndexed-xzaTVY8, reason: not valid java name */
    private static final short[] m6424onEachIndexedxzaTVY8(short[] onEachIndexed, Function2<? super Integer, ? super UShort, Unit> action) {
        Intrinsics.checkNotNullParameter(onEachIndexed, "$this$onEachIndexed");
        Intrinsics.checkNotNullParameter(action, "action");
        int iM5812getSizeimpl = UShortArray.m5812getSizeimpl(onEachIndexed);
        int i = 0;
        int i2 = 0;
        while (i < iM5812getSizeimpl) {
            action.invoke(Integer.valueOf(i2), UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(onEachIndexed, i)));
            i++;
            i2++;
        }
        return onEachIndexed;
    }

    /* JADX INFO: renamed from: reduce-WyvcNBI, reason: not valid java name */
    private static final int m6454reduceWyvcNBI(int[] reduce, Function2<? super UInt, ? super UInt, UInt> operation) {
        Intrinsics.checkNotNullParameter(reduce, "$this$reduce");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (UIntArray.m5630isEmptyimpl(reduce)) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        int iM5627getpVg5ArA = UIntArray.m5627getpVg5ArA(reduce, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(reduce);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                iM5627getpVg5ArA = operation.invoke(UInt.m5561boximpl(iM5627getpVg5ArA), UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(reduce, i))).m5619unboximpl();
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return iM5627getpVg5ArA;
    }

    /* JADX INFO: renamed from: reduce-s8dVfGU, reason: not valid java name */
    private static final long m6455reduces8dVfGU(long[] reduce, Function2<? super ULong, ? super ULong, ULong> operation) {
        Intrinsics.checkNotNullParameter(reduce, "$this$reduce");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (ULongArray.m5709isEmptyimpl(reduce)) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        long jM5706getsVKNKU = ULongArray.m5706getsVKNKU(reduce, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(reduce);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                jM5706getsVKNKU = operation.invoke(ULong.m5640boximpl(jM5706getsVKNKU), ULong.m5640boximpl(ULongArray.m5706getsVKNKU(reduce, i))).m5698unboximpl();
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return jM5706getsVKNKU;
    }

    /* JADX INFO: renamed from: reduce-ELGow60, reason: not valid java name */
    private static final byte m6453reduceELGow60(byte[] reduce, Function2<? super UByte, ? super UByte, UByte> operation) {
        Intrinsics.checkNotNullParameter(reduce, "$this$reduce");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (UByteArray.m5551isEmptyimpl(reduce)) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        byte bM5548getw2LRezQ = UByteArray.m5548getw2LRezQ(reduce, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(reduce);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                bM5548getw2LRezQ = operation.invoke(UByte.m5484boximpl(bM5548getw2LRezQ), UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(reduce, i))).m5540unboximpl();
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return bM5548getw2LRezQ;
    }

    /* JADX INFO: renamed from: reduce-xzaTVY8, reason: not valid java name */
    private static final short m6456reducexzaTVY8(short[] reduce, Function2<? super UShort, ? super UShort, UShort> operation) {
        Intrinsics.checkNotNullParameter(reduce, "$this$reduce");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (UShortArray.m5814isEmptyimpl(reduce)) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        short sM5811getMh2AYeg = UShortArray.m5811getMh2AYeg(reduce, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(reduce);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                sM5811getMh2AYeg = operation.invoke(UShort.m5747boximpl(sM5811getMh2AYeg), UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(reduce, i))).m5803unboximpl();
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return sM5811getMh2AYeg;
    }

    /* JADX INFO: renamed from: reduceIndexed-D40WMg8, reason: not valid java name */
    private static final int m6457reduceIndexedD40WMg8(int[] reduceIndexed, Function3<? super Integer, ? super UInt, ? super UInt, UInt> operation) {
        Intrinsics.checkNotNullParameter(reduceIndexed, "$this$reduceIndexed");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (UIntArray.m5630isEmptyimpl(reduceIndexed)) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        int iM5627getpVg5ArA = UIntArray.m5627getpVg5ArA(reduceIndexed, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(reduceIndexed);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                iM5627getpVg5ArA = operation.invoke(Integer.valueOf(i), UInt.m5561boximpl(iM5627getpVg5ArA), UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(reduceIndexed, i))).m5619unboximpl();
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return iM5627getpVg5ArA;
    }

    /* JADX INFO: renamed from: reduceIndexed-z1zDJgo, reason: not valid java name */
    private static final long m6460reduceIndexedz1zDJgo(long[] reduceIndexed, Function3<? super Integer, ? super ULong, ? super ULong, ULong> operation) {
        Intrinsics.checkNotNullParameter(reduceIndexed, "$this$reduceIndexed");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (ULongArray.m5709isEmptyimpl(reduceIndexed)) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        long jM5706getsVKNKU = ULongArray.m5706getsVKNKU(reduceIndexed, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(reduceIndexed);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                jM5706getsVKNKU = operation.invoke(Integer.valueOf(i), ULong.m5640boximpl(jM5706getsVKNKU), ULong.m5640boximpl(ULongArray.m5706getsVKNKU(reduceIndexed, i))).m5698unboximpl();
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return jM5706getsVKNKU;
    }

    /* JADX INFO: renamed from: reduceIndexed-EOyYB1Y, reason: not valid java name */
    private static final byte m6458reduceIndexedEOyYB1Y(byte[] reduceIndexed, Function3<? super Integer, ? super UByte, ? super UByte, UByte> operation) {
        Intrinsics.checkNotNullParameter(reduceIndexed, "$this$reduceIndexed");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (UByteArray.m5551isEmptyimpl(reduceIndexed)) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        byte bM5548getw2LRezQ = UByteArray.m5548getw2LRezQ(reduceIndexed, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(reduceIndexed);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                bM5548getw2LRezQ = operation.invoke(Integer.valueOf(i), UByte.m5484boximpl(bM5548getw2LRezQ), UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(reduceIndexed, i))).m5540unboximpl();
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return bM5548getw2LRezQ;
    }

    /* JADX INFO: renamed from: reduceIndexed-aLgx1Fo, reason: not valid java name */
    private static final short m6459reduceIndexedaLgx1Fo(short[] reduceIndexed, Function3<? super Integer, ? super UShort, ? super UShort, UShort> operation) {
        Intrinsics.checkNotNullParameter(reduceIndexed, "$this$reduceIndexed");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (UShortArray.m5814isEmptyimpl(reduceIndexed)) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        short sM5811getMh2AYeg = UShortArray.m5811getMh2AYeg(reduceIndexed, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(reduceIndexed);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                sM5811getMh2AYeg = operation.invoke(Integer.valueOf(i), UShort.m5747boximpl(sM5811getMh2AYeg), UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(reduceIndexed, i))).m5803unboximpl();
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return sM5811getMh2AYeg;
    }

    /* JADX INFO: renamed from: reduceIndexedOrNull-D40WMg8, reason: not valid java name */
    private static final UInt m6461reduceIndexedOrNullD40WMg8(int[] reduceIndexedOrNull, Function3<? super Integer, ? super UInt, ? super UInt, UInt> operation) {
        Intrinsics.checkNotNullParameter(reduceIndexedOrNull, "$this$reduceIndexedOrNull");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (UIntArray.m5630isEmptyimpl(reduceIndexedOrNull)) {
            return null;
        }
        int iM5627getpVg5ArA = UIntArray.m5627getpVg5ArA(reduceIndexedOrNull, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(reduceIndexedOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                iM5627getpVg5ArA = operation.invoke(Integer.valueOf(i), UInt.m5561boximpl(iM5627getpVg5ArA), UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(reduceIndexedOrNull, i))).m5619unboximpl();
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UInt.m5561boximpl(iM5627getpVg5ArA);
    }

    /* JADX INFO: renamed from: reduceIndexedOrNull-z1zDJgo, reason: not valid java name */
    private static final ULong m6464reduceIndexedOrNullz1zDJgo(long[] reduceIndexedOrNull, Function3<? super Integer, ? super ULong, ? super ULong, ULong> operation) {
        Intrinsics.checkNotNullParameter(reduceIndexedOrNull, "$this$reduceIndexedOrNull");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (ULongArray.m5709isEmptyimpl(reduceIndexedOrNull)) {
            return null;
        }
        long jM5706getsVKNKU = ULongArray.m5706getsVKNKU(reduceIndexedOrNull, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(reduceIndexedOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                jM5706getsVKNKU = operation.invoke(Integer.valueOf(i), ULong.m5640boximpl(jM5706getsVKNKU), ULong.m5640boximpl(ULongArray.m5706getsVKNKU(reduceIndexedOrNull, i))).m5698unboximpl();
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return ULong.m5640boximpl(jM5706getsVKNKU);
    }

    /* JADX INFO: renamed from: reduceIndexedOrNull-EOyYB1Y, reason: not valid java name */
    private static final UByte m6462reduceIndexedOrNullEOyYB1Y(byte[] reduceIndexedOrNull, Function3<? super Integer, ? super UByte, ? super UByte, UByte> operation) {
        Intrinsics.checkNotNullParameter(reduceIndexedOrNull, "$this$reduceIndexedOrNull");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (UByteArray.m5551isEmptyimpl(reduceIndexedOrNull)) {
            return null;
        }
        byte bM5548getw2LRezQ = UByteArray.m5548getw2LRezQ(reduceIndexedOrNull, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(reduceIndexedOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                bM5548getw2LRezQ = operation.invoke(Integer.valueOf(i), UByte.m5484boximpl(bM5548getw2LRezQ), UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(reduceIndexedOrNull, i))).m5540unboximpl();
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UByte.m5484boximpl(bM5548getw2LRezQ);
    }

    /* JADX INFO: renamed from: reduceIndexedOrNull-aLgx1Fo, reason: not valid java name */
    private static final UShort m6463reduceIndexedOrNullaLgx1Fo(short[] reduceIndexedOrNull, Function3<? super Integer, ? super UShort, ? super UShort, UShort> operation) {
        Intrinsics.checkNotNullParameter(reduceIndexedOrNull, "$this$reduceIndexedOrNull");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (UShortArray.m5814isEmptyimpl(reduceIndexedOrNull)) {
            return null;
        }
        short sM5811getMh2AYeg = UShortArray.m5811getMh2AYeg(reduceIndexedOrNull, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(reduceIndexedOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                sM5811getMh2AYeg = operation.invoke(Integer.valueOf(i), UShort.m5747boximpl(sM5811getMh2AYeg), UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(reduceIndexedOrNull, i))).m5803unboximpl();
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UShort.m5747boximpl(sM5811getMh2AYeg);
    }

    /* JADX INFO: renamed from: reduceOrNull-WyvcNBI, reason: not valid java name */
    private static final UInt m6466reduceOrNullWyvcNBI(int[] reduceOrNull, Function2<? super UInt, ? super UInt, UInt> operation) {
        Intrinsics.checkNotNullParameter(reduceOrNull, "$this$reduceOrNull");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (UIntArray.m5630isEmptyimpl(reduceOrNull)) {
            return null;
        }
        int iM5627getpVg5ArA = UIntArray.m5627getpVg5ArA(reduceOrNull, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(reduceOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                iM5627getpVg5ArA = operation.invoke(UInt.m5561boximpl(iM5627getpVg5ArA), UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(reduceOrNull, i))).m5619unboximpl();
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UInt.m5561boximpl(iM5627getpVg5ArA);
    }

    /* JADX INFO: renamed from: reduceOrNull-s8dVfGU, reason: not valid java name */
    private static final ULong m6467reduceOrNulls8dVfGU(long[] reduceOrNull, Function2<? super ULong, ? super ULong, ULong> operation) {
        Intrinsics.checkNotNullParameter(reduceOrNull, "$this$reduceOrNull");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (ULongArray.m5709isEmptyimpl(reduceOrNull)) {
            return null;
        }
        long jM5706getsVKNKU = ULongArray.m5706getsVKNKU(reduceOrNull, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(reduceOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                jM5706getsVKNKU = operation.invoke(ULong.m5640boximpl(jM5706getsVKNKU), ULong.m5640boximpl(ULongArray.m5706getsVKNKU(reduceOrNull, i))).m5698unboximpl();
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return ULong.m5640boximpl(jM5706getsVKNKU);
    }

    /* JADX INFO: renamed from: reduceOrNull-ELGow60, reason: not valid java name */
    private static final UByte m6465reduceOrNullELGow60(byte[] reduceOrNull, Function2<? super UByte, ? super UByte, UByte> operation) {
        Intrinsics.checkNotNullParameter(reduceOrNull, "$this$reduceOrNull");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (UByteArray.m5551isEmptyimpl(reduceOrNull)) {
            return null;
        }
        byte bM5548getw2LRezQ = UByteArray.m5548getw2LRezQ(reduceOrNull, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(reduceOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                bM5548getw2LRezQ = operation.invoke(UByte.m5484boximpl(bM5548getw2LRezQ), UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(reduceOrNull, i))).m5540unboximpl();
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UByte.m5484boximpl(bM5548getw2LRezQ);
    }

    /* JADX INFO: renamed from: reduceOrNull-xzaTVY8, reason: not valid java name */
    private static final UShort m6468reduceOrNullxzaTVY8(short[] reduceOrNull, Function2<? super UShort, ? super UShort, UShort> operation) {
        Intrinsics.checkNotNullParameter(reduceOrNull, "$this$reduceOrNull");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (UShortArray.m5814isEmptyimpl(reduceOrNull)) {
            return null;
        }
        short sM5811getMh2AYeg = UShortArray.m5811getMh2AYeg(reduceOrNull, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(reduceOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                sM5811getMh2AYeg = operation.invoke(UShort.m5747boximpl(sM5811getMh2AYeg), UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(reduceOrNull, i))).m5803unboximpl();
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UShort.m5747boximpl(sM5811getMh2AYeg);
    }

    /* JADX INFO: renamed from: runningFold-zi1B2BA, reason: not valid java name */
    private static final <R> List<R> m6503runningFoldzi1B2BA(int[] runningFold, R r, Function2<? super R, ? super UInt, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(runningFold, "$this$runningFold");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (UIntArray.m5630isEmptyimpl(runningFold)) {
            return CollectionsKt__CollectionsJVMKt.listOf(r);
        }
        ArrayList arrayList = new ArrayList(UIntArray.m5628getSizeimpl(runningFold) + 1);
        arrayList.add(r);
        int iM5628getSizeimpl = UIntArray.m5628getSizeimpl(runningFold);
        for (int i = 0; i < iM5628getSizeimpl; i++) {
            r = operation.invoke(r, UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(runningFold, i)));
            arrayList.add(r);
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: runningFold-A8wKCXQ, reason: not valid java name */
    private static final <R> List<R> m6501runningFoldA8wKCXQ(long[] runningFold, R r, Function2<? super R, ? super ULong, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(runningFold, "$this$runningFold");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (ULongArray.m5709isEmptyimpl(runningFold)) {
            return CollectionsKt__CollectionsJVMKt.listOf(r);
        }
        ArrayList arrayList = new ArrayList(ULongArray.m5707getSizeimpl(runningFold) + 1);
        arrayList.add(r);
        int iM5707getSizeimpl = ULongArray.m5707getSizeimpl(runningFold);
        for (int i = 0; i < iM5707getSizeimpl; i++) {
            r = operation.invoke(r, ULong.m5640boximpl(ULongArray.m5706getsVKNKU(runningFold, i)));
            arrayList.add(r);
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: runningFold-yXmHNn8, reason: not valid java name */
    private static final <R> List<R> m6502runningFoldyXmHNn8(byte[] runningFold, R r, Function2<? super R, ? super UByte, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(runningFold, "$this$runningFold");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (UByteArray.m5551isEmptyimpl(runningFold)) {
            return CollectionsKt__CollectionsJVMKt.listOf(r);
        }
        ArrayList arrayList = new ArrayList(UByteArray.m5549getSizeimpl(runningFold) + 1);
        arrayList.add(r);
        int iM5549getSizeimpl = UByteArray.m5549getSizeimpl(runningFold);
        for (int i = 0; i < iM5549getSizeimpl; i++) {
            r = operation.invoke(r, UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(runningFold, i)));
            arrayList.add(r);
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: runningFold-zww5nb8, reason: not valid java name */
    private static final <R> List<R> m6504runningFoldzww5nb8(short[] runningFold, R r, Function2<? super R, ? super UShort, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(runningFold, "$this$runningFold");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (UShortArray.m5814isEmptyimpl(runningFold)) {
            return CollectionsKt__CollectionsJVMKt.listOf(r);
        }
        ArrayList arrayList = new ArrayList(UShortArray.m5812getSizeimpl(runningFold) + 1);
        arrayList.add(r);
        int iM5812getSizeimpl = UShortArray.m5812getSizeimpl(runningFold);
        for (int i = 0; i < iM5812getSizeimpl; i++) {
            r = operation.invoke(r, UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(runningFold, i)));
            arrayList.add(r);
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: runningFoldIndexed-yVwIW0Q, reason: not valid java name */
    private static final <R> List<R> m6508runningFoldIndexedyVwIW0Q(int[] runningFoldIndexed, R r, Function3<? super Integer, ? super R, ? super UInt, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(runningFoldIndexed, "$this$runningFoldIndexed");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (UIntArray.m5630isEmptyimpl(runningFoldIndexed)) {
            return CollectionsKt__CollectionsJVMKt.listOf(r);
        }
        ArrayList arrayList = new ArrayList(UIntArray.m5628getSizeimpl(runningFoldIndexed) + 1);
        arrayList.add(r);
        int iM5628getSizeimpl = UIntArray.m5628getSizeimpl(runningFoldIndexed);
        for (int i = 0; i < iM5628getSizeimpl; i++) {
            r = operation.invoke(Integer.valueOf(i), r, UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(runningFoldIndexed, i)));
            arrayList.add(r);
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: runningFoldIndexed-mwnnOCs, reason: not valid java name */
    private static final <R> List<R> m6507runningFoldIndexedmwnnOCs(long[] runningFoldIndexed, R r, Function3<? super Integer, ? super R, ? super ULong, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(runningFoldIndexed, "$this$runningFoldIndexed");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (ULongArray.m5709isEmptyimpl(runningFoldIndexed)) {
            return CollectionsKt__CollectionsJVMKt.listOf(r);
        }
        ArrayList arrayList = new ArrayList(ULongArray.m5707getSizeimpl(runningFoldIndexed) + 1);
        arrayList.add(r);
        int iM5707getSizeimpl = ULongArray.m5707getSizeimpl(runningFoldIndexed);
        for (int i = 0; i < iM5707getSizeimpl; i++) {
            r = operation.invoke(Integer.valueOf(i), r, ULong.m5640boximpl(ULongArray.m5706getsVKNKU(runningFoldIndexed, i)));
            arrayList.add(r);
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: runningFoldIndexed-3iWJZGE, reason: not valid java name */
    private static final <R> List<R> m6505runningFoldIndexed3iWJZGE(byte[] runningFoldIndexed, R r, Function3<? super Integer, ? super R, ? super UByte, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(runningFoldIndexed, "$this$runningFoldIndexed");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (UByteArray.m5551isEmptyimpl(runningFoldIndexed)) {
            return CollectionsKt__CollectionsJVMKt.listOf(r);
        }
        ArrayList arrayList = new ArrayList(UByteArray.m5549getSizeimpl(runningFoldIndexed) + 1);
        arrayList.add(r);
        int iM5549getSizeimpl = UByteArray.m5549getSizeimpl(runningFoldIndexed);
        for (int i = 0; i < iM5549getSizeimpl; i++) {
            r = operation.invoke(Integer.valueOf(i), r, UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(runningFoldIndexed, i)));
            arrayList.add(r);
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: runningFoldIndexed-bzxtMww, reason: not valid java name */
    private static final <R> List<R> m6506runningFoldIndexedbzxtMww(short[] runningFoldIndexed, R r, Function3<? super Integer, ? super R, ? super UShort, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(runningFoldIndexed, "$this$runningFoldIndexed");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (UShortArray.m5814isEmptyimpl(runningFoldIndexed)) {
            return CollectionsKt__CollectionsJVMKt.listOf(r);
        }
        ArrayList arrayList = new ArrayList(UShortArray.m5812getSizeimpl(runningFoldIndexed) + 1);
        arrayList.add(r);
        int iM5812getSizeimpl = UShortArray.m5812getSizeimpl(runningFoldIndexed);
        for (int i = 0; i < iM5812getSizeimpl; i++) {
            r = operation.invoke(Integer.valueOf(i), r, UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(runningFoldIndexed, i)));
            arrayList.add(r);
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: runningReduce-WyvcNBI, reason: not valid java name */
    private static final List<UInt> m6510runningReduceWyvcNBI(int[] runningReduce, Function2<? super UInt, ? super UInt, UInt> operation) {
        Intrinsics.checkNotNullParameter(runningReduce, "$this$runningReduce");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (UIntArray.m5630isEmptyimpl(runningReduce)) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        int iM5627getpVg5ArA = UIntArray.m5627getpVg5ArA(runningReduce, 0);
        ArrayList arrayList = new ArrayList(UIntArray.m5628getSizeimpl(runningReduce));
        arrayList.add(UInt.m5561boximpl(iM5627getpVg5ArA));
        int iM5628getSizeimpl = UIntArray.m5628getSizeimpl(runningReduce);
        for (int i = 1; i < iM5628getSizeimpl; i++) {
            iM5627getpVg5ArA = operation.invoke(UInt.m5561boximpl(iM5627getpVg5ArA), UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(runningReduce, i))).m5619unboximpl();
            arrayList.add(UInt.m5561boximpl(iM5627getpVg5ArA));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: runningReduce-s8dVfGU, reason: not valid java name */
    private static final List<ULong> m6511runningReduces8dVfGU(long[] runningReduce, Function2<? super ULong, ? super ULong, ULong> operation) {
        Intrinsics.checkNotNullParameter(runningReduce, "$this$runningReduce");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (ULongArray.m5709isEmptyimpl(runningReduce)) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        long jM5706getsVKNKU = ULongArray.m5706getsVKNKU(runningReduce, 0);
        ArrayList arrayList = new ArrayList(ULongArray.m5707getSizeimpl(runningReduce));
        arrayList.add(ULong.m5640boximpl(jM5706getsVKNKU));
        int iM5707getSizeimpl = ULongArray.m5707getSizeimpl(runningReduce);
        for (int i = 1; i < iM5707getSizeimpl; i++) {
            jM5706getsVKNKU = operation.invoke(ULong.m5640boximpl(jM5706getsVKNKU), ULong.m5640boximpl(ULongArray.m5706getsVKNKU(runningReduce, i))).m5698unboximpl();
            arrayList.add(ULong.m5640boximpl(jM5706getsVKNKU));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: runningReduce-ELGow60, reason: not valid java name */
    private static final List<UByte> m6509runningReduceELGow60(byte[] runningReduce, Function2<? super UByte, ? super UByte, UByte> operation) {
        Intrinsics.checkNotNullParameter(runningReduce, "$this$runningReduce");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (UByteArray.m5551isEmptyimpl(runningReduce)) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        byte bM5548getw2LRezQ = UByteArray.m5548getw2LRezQ(runningReduce, 0);
        ArrayList arrayList = new ArrayList(UByteArray.m5549getSizeimpl(runningReduce));
        arrayList.add(UByte.m5484boximpl(bM5548getw2LRezQ));
        int iM5549getSizeimpl = UByteArray.m5549getSizeimpl(runningReduce);
        for (int i = 1; i < iM5549getSizeimpl; i++) {
            bM5548getw2LRezQ = operation.invoke(UByte.m5484boximpl(bM5548getw2LRezQ), UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(runningReduce, i))).m5540unboximpl();
            arrayList.add(UByte.m5484boximpl(bM5548getw2LRezQ));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: runningReduce-xzaTVY8, reason: not valid java name */
    private static final List<UShort> m6512runningReducexzaTVY8(short[] runningReduce, Function2<? super UShort, ? super UShort, UShort> operation) {
        Intrinsics.checkNotNullParameter(runningReduce, "$this$runningReduce");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (UShortArray.m5814isEmptyimpl(runningReduce)) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        short sM5811getMh2AYeg = UShortArray.m5811getMh2AYeg(runningReduce, 0);
        ArrayList arrayList = new ArrayList(UShortArray.m5812getSizeimpl(runningReduce));
        arrayList.add(UShort.m5747boximpl(sM5811getMh2AYeg));
        int iM5812getSizeimpl = UShortArray.m5812getSizeimpl(runningReduce);
        for (int i = 1; i < iM5812getSizeimpl; i++) {
            sM5811getMh2AYeg = operation.invoke(UShort.m5747boximpl(sM5811getMh2AYeg), UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(runningReduce, i))).m5803unboximpl();
            arrayList.add(UShort.m5747boximpl(sM5811getMh2AYeg));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: runningReduceIndexed-D40WMg8, reason: not valid java name */
    private static final List<UInt> m6513runningReduceIndexedD40WMg8(int[] runningReduceIndexed, Function3<? super Integer, ? super UInt, ? super UInt, UInt> operation) {
        Intrinsics.checkNotNullParameter(runningReduceIndexed, "$this$runningReduceIndexed");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (UIntArray.m5630isEmptyimpl(runningReduceIndexed)) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        int iM5627getpVg5ArA = UIntArray.m5627getpVg5ArA(runningReduceIndexed, 0);
        ArrayList arrayList = new ArrayList(UIntArray.m5628getSizeimpl(runningReduceIndexed));
        arrayList.add(UInt.m5561boximpl(iM5627getpVg5ArA));
        int iM5628getSizeimpl = UIntArray.m5628getSizeimpl(runningReduceIndexed);
        for (int i = 1; i < iM5628getSizeimpl; i++) {
            iM5627getpVg5ArA = operation.invoke(Integer.valueOf(i), UInt.m5561boximpl(iM5627getpVg5ArA), UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(runningReduceIndexed, i))).m5619unboximpl();
            arrayList.add(UInt.m5561boximpl(iM5627getpVg5ArA));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: runningReduceIndexed-z1zDJgo, reason: not valid java name */
    private static final List<ULong> m6516runningReduceIndexedz1zDJgo(long[] runningReduceIndexed, Function3<? super Integer, ? super ULong, ? super ULong, ULong> operation) {
        Intrinsics.checkNotNullParameter(runningReduceIndexed, "$this$runningReduceIndexed");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (ULongArray.m5709isEmptyimpl(runningReduceIndexed)) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        long jM5706getsVKNKU = ULongArray.m5706getsVKNKU(runningReduceIndexed, 0);
        ArrayList arrayList = new ArrayList(ULongArray.m5707getSizeimpl(runningReduceIndexed));
        arrayList.add(ULong.m5640boximpl(jM5706getsVKNKU));
        int iM5707getSizeimpl = ULongArray.m5707getSizeimpl(runningReduceIndexed);
        for (int i = 1; i < iM5707getSizeimpl; i++) {
            jM5706getsVKNKU = operation.invoke(Integer.valueOf(i), ULong.m5640boximpl(jM5706getsVKNKU), ULong.m5640boximpl(ULongArray.m5706getsVKNKU(runningReduceIndexed, i))).m5698unboximpl();
            arrayList.add(ULong.m5640boximpl(jM5706getsVKNKU));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: runningReduceIndexed-EOyYB1Y, reason: not valid java name */
    private static final List<UByte> m6514runningReduceIndexedEOyYB1Y(byte[] runningReduceIndexed, Function3<? super Integer, ? super UByte, ? super UByte, UByte> operation) {
        Intrinsics.checkNotNullParameter(runningReduceIndexed, "$this$runningReduceIndexed");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (UByteArray.m5551isEmptyimpl(runningReduceIndexed)) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        byte bM5548getw2LRezQ = UByteArray.m5548getw2LRezQ(runningReduceIndexed, 0);
        ArrayList arrayList = new ArrayList(UByteArray.m5549getSizeimpl(runningReduceIndexed));
        arrayList.add(UByte.m5484boximpl(bM5548getw2LRezQ));
        int iM5549getSizeimpl = UByteArray.m5549getSizeimpl(runningReduceIndexed);
        for (int i = 1; i < iM5549getSizeimpl; i++) {
            bM5548getw2LRezQ = operation.invoke(Integer.valueOf(i), UByte.m5484boximpl(bM5548getw2LRezQ), UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(runningReduceIndexed, i))).m5540unboximpl();
            arrayList.add(UByte.m5484boximpl(bM5548getw2LRezQ));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: runningReduceIndexed-aLgx1Fo, reason: not valid java name */
    private static final List<UShort> m6515runningReduceIndexedaLgx1Fo(short[] runningReduceIndexed, Function3<? super Integer, ? super UShort, ? super UShort, UShort> operation) {
        Intrinsics.checkNotNullParameter(runningReduceIndexed, "$this$runningReduceIndexed");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (UShortArray.m5814isEmptyimpl(runningReduceIndexed)) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        short sM5811getMh2AYeg = UShortArray.m5811getMh2AYeg(runningReduceIndexed, 0);
        ArrayList arrayList = new ArrayList(UShortArray.m5812getSizeimpl(runningReduceIndexed));
        arrayList.add(UShort.m5747boximpl(sM5811getMh2AYeg));
        int iM5812getSizeimpl = UShortArray.m5812getSizeimpl(runningReduceIndexed);
        for (int i = 1; i < iM5812getSizeimpl; i++) {
            sM5811getMh2AYeg = operation.invoke(Integer.valueOf(i), UShort.m5747boximpl(sM5811getMh2AYeg), UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(runningReduceIndexed, i))).m5803unboximpl();
            arrayList.add(UShort.m5747boximpl(sM5811getMh2AYeg));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: scan-zi1B2BA, reason: not valid java name */
    private static final <R> List<R> m6519scanzi1B2BA(int[] scan, R r, Function2<? super R, ? super UInt, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(scan, "$this$scan");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (UIntArray.m5630isEmptyimpl(scan)) {
            return CollectionsKt__CollectionsJVMKt.listOf(r);
        }
        ArrayList arrayList = new ArrayList(UIntArray.m5628getSizeimpl(scan) + 1);
        arrayList.add(r);
        int iM5628getSizeimpl = UIntArray.m5628getSizeimpl(scan);
        for (int i = 0; i < iM5628getSizeimpl; i++) {
            r = operation.invoke(r, UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(scan, i)));
            arrayList.add(r);
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: scan-A8wKCXQ, reason: not valid java name */
    private static final <R> List<R> m6517scanA8wKCXQ(long[] scan, R r, Function2<? super R, ? super ULong, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(scan, "$this$scan");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (ULongArray.m5709isEmptyimpl(scan)) {
            return CollectionsKt__CollectionsJVMKt.listOf(r);
        }
        ArrayList arrayList = new ArrayList(ULongArray.m5707getSizeimpl(scan) + 1);
        arrayList.add(r);
        int iM5707getSizeimpl = ULongArray.m5707getSizeimpl(scan);
        for (int i = 0; i < iM5707getSizeimpl; i++) {
            r = operation.invoke(r, ULong.m5640boximpl(ULongArray.m5706getsVKNKU(scan, i)));
            arrayList.add(r);
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: scan-yXmHNn8, reason: not valid java name */
    private static final <R> List<R> m6518scanyXmHNn8(byte[] scan, R r, Function2<? super R, ? super UByte, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(scan, "$this$scan");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (UByteArray.m5551isEmptyimpl(scan)) {
            return CollectionsKt__CollectionsJVMKt.listOf(r);
        }
        ArrayList arrayList = new ArrayList(UByteArray.m5549getSizeimpl(scan) + 1);
        arrayList.add(r);
        int iM5549getSizeimpl = UByteArray.m5549getSizeimpl(scan);
        for (int i = 0; i < iM5549getSizeimpl; i++) {
            r = operation.invoke(r, UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(scan, i)));
            arrayList.add(r);
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: scan-zww5nb8, reason: not valid java name */
    private static final <R> List<R> m6520scanzww5nb8(short[] scan, R r, Function2<? super R, ? super UShort, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(scan, "$this$scan");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (UShortArray.m5814isEmptyimpl(scan)) {
            return CollectionsKt__CollectionsJVMKt.listOf(r);
        }
        ArrayList arrayList = new ArrayList(UShortArray.m5812getSizeimpl(scan) + 1);
        arrayList.add(r);
        int iM5812getSizeimpl = UShortArray.m5812getSizeimpl(scan);
        for (int i = 0; i < iM5812getSizeimpl; i++) {
            r = operation.invoke(r, UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(scan, i)));
            arrayList.add(r);
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: scanIndexed-yVwIW0Q, reason: not valid java name */
    private static final <R> List<R> m6524scanIndexedyVwIW0Q(int[] scanIndexed, R r, Function3<? super Integer, ? super R, ? super UInt, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(scanIndexed, "$this$scanIndexed");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (UIntArray.m5630isEmptyimpl(scanIndexed)) {
            return CollectionsKt__CollectionsJVMKt.listOf(r);
        }
        ArrayList arrayList = new ArrayList(UIntArray.m5628getSizeimpl(scanIndexed) + 1);
        arrayList.add(r);
        int iM5628getSizeimpl = UIntArray.m5628getSizeimpl(scanIndexed);
        for (int i = 0; i < iM5628getSizeimpl; i++) {
            r = operation.invoke(Integer.valueOf(i), r, UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(scanIndexed, i)));
            arrayList.add(r);
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: scanIndexed-mwnnOCs, reason: not valid java name */
    private static final <R> List<R> m6523scanIndexedmwnnOCs(long[] scanIndexed, R r, Function3<? super Integer, ? super R, ? super ULong, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(scanIndexed, "$this$scanIndexed");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (ULongArray.m5709isEmptyimpl(scanIndexed)) {
            return CollectionsKt__CollectionsJVMKt.listOf(r);
        }
        ArrayList arrayList = new ArrayList(ULongArray.m5707getSizeimpl(scanIndexed) + 1);
        arrayList.add(r);
        int iM5707getSizeimpl = ULongArray.m5707getSizeimpl(scanIndexed);
        for (int i = 0; i < iM5707getSizeimpl; i++) {
            r = operation.invoke(Integer.valueOf(i), r, ULong.m5640boximpl(ULongArray.m5706getsVKNKU(scanIndexed, i)));
            arrayList.add(r);
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: scanIndexed-3iWJZGE, reason: not valid java name */
    private static final <R> List<R> m6521scanIndexed3iWJZGE(byte[] scanIndexed, R r, Function3<? super Integer, ? super R, ? super UByte, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(scanIndexed, "$this$scanIndexed");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (UByteArray.m5551isEmptyimpl(scanIndexed)) {
            return CollectionsKt__CollectionsJVMKt.listOf(r);
        }
        ArrayList arrayList = new ArrayList(UByteArray.m5549getSizeimpl(scanIndexed) + 1);
        arrayList.add(r);
        int iM5549getSizeimpl = UByteArray.m5549getSizeimpl(scanIndexed);
        for (int i = 0; i < iM5549getSizeimpl; i++) {
            r = operation.invoke(Integer.valueOf(i), r, UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(scanIndexed, i)));
            arrayList.add(r);
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: scanIndexed-bzxtMww, reason: not valid java name */
    private static final <R> List<R> m6522scanIndexedbzxtMww(short[] scanIndexed, R r, Function3<? super Integer, ? super R, ? super UShort, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(scanIndexed, "$this$scanIndexed");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (UShortArray.m5814isEmptyimpl(scanIndexed)) {
            return CollectionsKt__CollectionsJVMKt.listOf(r);
        }
        ArrayList arrayList = new ArrayList(UShortArray.m5812getSizeimpl(scanIndexed) + 1);
        arrayList.add(r);
        int iM5812getSizeimpl = UShortArray.m5812getSizeimpl(scanIndexed);
        for (int i = 0; i < iM5812getSizeimpl; i++) {
            r = operation.invoke(Integer.valueOf(i), r, UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(scanIndexed, i)));
            arrayList.add(r);
        }
        return arrayList;
    }

    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    /* JADX INFO: renamed from: sumBy-jgv0xPQ, reason: not valid java name */
    private static final int m6607sumByjgv0xPQ(int[] sumBy, Function1<? super UInt, UInt> selector) {
        Intrinsics.checkNotNullParameter(sumBy, "$this$sumBy");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iM5628getSizeimpl = UIntArray.m5628getSizeimpl(sumBy);
        int iM5567constructorimpl = 0;
        for (int i = 0; i < iM5628getSizeimpl; i++) {
            iM5567constructorimpl = UInt.m5567constructorimpl(iM5567constructorimpl + selector.invoke(UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(sumBy, i))).m5619unboximpl());
        }
        return iM5567constructorimpl;
    }

    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    /* JADX INFO: renamed from: sumBy-MShoTSo, reason: not valid java name */
    private static final int m6606sumByMShoTSo(long[] sumBy, Function1<? super ULong, UInt> selector) {
        Intrinsics.checkNotNullParameter(sumBy, "$this$sumBy");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iM5707getSizeimpl = ULongArray.m5707getSizeimpl(sumBy);
        int iM5567constructorimpl = 0;
        for (int i = 0; i < iM5707getSizeimpl; i++) {
            iM5567constructorimpl = UInt.m5567constructorimpl(iM5567constructorimpl + selector.invoke(ULong.m5640boximpl(ULongArray.m5706getsVKNKU(sumBy, i))).m5619unboximpl());
        }
        return iM5567constructorimpl;
    }

    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    /* JADX INFO: renamed from: sumBy-JOV_ifY, reason: not valid java name */
    private static final int m6605sumByJOV_ifY(byte[] sumBy, Function1<? super UByte, UInt> selector) {
        Intrinsics.checkNotNullParameter(sumBy, "$this$sumBy");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iM5549getSizeimpl = UByteArray.m5549getSizeimpl(sumBy);
        int iM5567constructorimpl = 0;
        for (int i = 0; i < iM5549getSizeimpl; i++) {
            iM5567constructorimpl = UInt.m5567constructorimpl(iM5567constructorimpl + selector.invoke(UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(sumBy, i))).m5619unboximpl());
        }
        return iM5567constructorimpl;
    }

    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    /* JADX INFO: renamed from: sumBy-xTcfx_M, reason: not valid java name */
    private static final int m6608sumByxTcfx_M(short[] sumBy, Function1<? super UShort, UInt> selector) {
        Intrinsics.checkNotNullParameter(sumBy, "$this$sumBy");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iM5812getSizeimpl = UShortArray.m5812getSizeimpl(sumBy);
        int iM5567constructorimpl = 0;
        for (int i = 0; i < iM5812getSizeimpl; i++) {
            iM5567constructorimpl = UInt.m5567constructorimpl(iM5567constructorimpl + selector.invoke(UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(sumBy, i))).m5619unboximpl());
        }
        return iM5567constructorimpl;
    }

    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    /* JADX INFO: renamed from: sumByDouble-jgv0xPQ, reason: not valid java name */
    private static final double m6611sumByDoublejgv0xPQ(int[] sumByDouble, Function1<? super UInt, Double> selector) {
        Intrinsics.checkNotNullParameter(sumByDouble, "$this$sumByDouble");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iM5628getSizeimpl = UIntArray.m5628getSizeimpl(sumByDouble);
        double dDoubleValue = 0.0d;
        for (int i = 0; i < iM5628getSizeimpl; i++) {
            dDoubleValue += selector.invoke(UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(sumByDouble, i))).doubleValue();
        }
        return dDoubleValue;
    }

    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    /* JADX INFO: renamed from: sumByDouble-MShoTSo, reason: not valid java name */
    private static final double m6610sumByDoubleMShoTSo(long[] sumByDouble, Function1<? super ULong, Double> selector) {
        Intrinsics.checkNotNullParameter(sumByDouble, "$this$sumByDouble");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iM5707getSizeimpl = ULongArray.m5707getSizeimpl(sumByDouble);
        double dDoubleValue = 0.0d;
        for (int i = 0; i < iM5707getSizeimpl; i++) {
            dDoubleValue += selector.invoke(ULong.m5640boximpl(ULongArray.m5706getsVKNKU(sumByDouble, i))).doubleValue();
        }
        return dDoubleValue;
    }

    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    /* JADX INFO: renamed from: sumByDouble-JOV_ifY, reason: not valid java name */
    private static final double m6609sumByDoubleJOV_ifY(byte[] sumByDouble, Function1<? super UByte, Double> selector) {
        Intrinsics.checkNotNullParameter(sumByDouble, "$this$sumByDouble");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iM5549getSizeimpl = UByteArray.m5549getSizeimpl(sumByDouble);
        double dDoubleValue = 0.0d;
        for (int i = 0; i < iM5549getSizeimpl; i++) {
            dDoubleValue += selector.invoke(UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(sumByDouble, i))).doubleValue();
        }
        return dDoubleValue;
    }

    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    /* JADX INFO: renamed from: sumByDouble-xTcfx_M, reason: not valid java name */
    private static final double m6612sumByDoublexTcfx_M(short[] sumByDouble, Function1<? super UShort, Double> selector) {
        Intrinsics.checkNotNullParameter(sumByDouble, "$this$sumByDouble");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iM5812getSizeimpl = UShortArray.m5812getSizeimpl(sumByDouble);
        double dDoubleValue = 0.0d;
        for (int i = 0; i < iM5812getSizeimpl; i++) {
            dDoubleValue += selector.invoke(UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(sumByDouble, i))).doubleValue();
        }
        return dDoubleValue;
    }

    private static final double sumOfDouble(int[] sumOf, Function1<? super UInt, Double> selector) {
        Intrinsics.checkNotNullParameter(sumOf, "$this$sumOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iM5628getSizeimpl = UIntArray.m5628getSizeimpl(sumOf);
        double dDoubleValue = 0.0d;
        for (int i = 0; i < iM5628getSizeimpl; i++) {
            dDoubleValue += selector.invoke(UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(sumOf, i))).doubleValue();
        }
        return dDoubleValue;
    }

    private static final double sumOfDouble(long[] sumOf, Function1<? super ULong, Double> selector) {
        Intrinsics.checkNotNullParameter(sumOf, "$this$sumOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iM5707getSizeimpl = ULongArray.m5707getSizeimpl(sumOf);
        double dDoubleValue = 0.0d;
        for (int i = 0; i < iM5707getSizeimpl; i++) {
            dDoubleValue += selector.invoke(ULong.m5640boximpl(ULongArray.m5706getsVKNKU(sumOf, i))).doubleValue();
        }
        return dDoubleValue;
    }

    private static final double sumOfDouble(byte[] sumOf, Function1<? super UByte, Double> selector) {
        Intrinsics.checkNotNullParameter(sumOf, "$this$sumOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iM5549getSizeimpl = UByteArray.m5549getSizeimpl(sumOf);
        double dDoubleValue = 0.0d;
        for (int i = 0; i < iM5549getSizeimpl; i++) {
            dDoubleValue += selector.invoke(UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(sumOf, i))).doubleValue();
        }
        return dDoubleValue;
    }

    private static final double sumOfDouble(short[] sumOf, Function1<? super UShort, Double> selector) {
        Intrinsics.checkNotNullParameter(sumOf, "$this$sumOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iM5812getSizeimpl = UShortArray.m5812getSizeimpl(sumOf);
        double dDoubleValue = 0.0d;
        for (int i = 0; i < iM5812getSizeimpl; i++) {
            dDoubleValue += selector.invoke(UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(sumOf, i))).doubleValue();
        }
        return dDoubleValue;
    }

    private static final int sumOfInt(int[] sumOf, Function1<? super UInt, Integer> selector) {
        Intrinsics.checkNotNullParameter(sumOf, "$this$sumOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iM5628getSizeimpl = UIntArray.m5628getSizeimpl(sumOf);
        int iIntValue = 0;
        for (int i = 0; i < iM5628getSizeimpl; i++) {
            iIntValue += selector.invoke(UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(sumOf, i))).intValue();
        }
        return iIntValue;
    }

    private static final int sumOfInt(long[] sumOf, Function1<? super ULong, Integer> selector) {
        Intrinsics.checkNotNullParameter(sumOf, "$this$sumOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iM5707getSizeimpl = ULongArray.m5707getSizeimpl(sumOf);
        int iIntValue = 0;
        for (int i = 0; i < iM5707getSizeimpl; i++) {
            iIntValue += selector.invoke(ULong.m5640boximpl(ULongArray.m5706getsVKNKU(sumOf, i))).intValue();
        }
        return iIntValue;
    }

    private static final int sumOfInt(byte[] sumOf, Function1<? super UByte, Integer> selector) {
        Intrinsics.checkNotNullParameter(sumOf, "$this$sumOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iM5549getSizeimpl = UByteArray.m5549getSizeimpl(sumOf);
        int iIntValue = 0;
        for (int i = 0; i < iM5549getSizeimpl; i++) {
            iIntValue += selector.invoke(UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(sumOf, i))).intValue();
        }
        return iIntValue;
    }

    private static final int sumOfInt(short[] sumOf, Function1<? super UShort, Integer> selector) {
        Intrinsics.checkNotNullParameter(sumOf, "$this$sumOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iM5812getSizeimpl = UShortArray.m5812getSizeimpl(sumOf);
        int iIntValue = 0;
        for (int i = 0; i < iM5812getSizeimpl; i++) {
            iIntValue += selector.invoke(UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(sumOf, i))).intValue();
        }
        return iIntValue;
    }

    private static final long sumOfLong(int[] sumOf, Function1<? super UInt, Long> selector) {
        Intrinsics.checkNotNullParameter(sumOf, "$this$sumOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iM5628getSizeimpl = UIntArray.m5628getSizeimpl(sumOf);
        long jLongValue = 0;
        for (int i = 0; i < iM5628getSizeimpl; i++) {
            jLongValue += selector.invoke(UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(sumOf, i))).longValue();
        }
        return jLongValue;
    }

    private static final long sumOfLong(long[] sumOf, Function1<? super ULong, Long> selector) {
        Intrinsics.checkNotNullParameter(sumOf, "$this$sumOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iM5707getSizeimpl = ULongArray.m5707getSizeimpl(sumOf);
        long jLongValue = 0;
        for (int i = 0; i < iM5707getSizeimpl; i++) {
            jLongValue += selector.invoke(ULong.m5640boximpl(ULongArray.m5706getsVKNKU(sumOf, i))).longValue();
        }
        return jLongValue;
    }

    private static final long sumOfLong(byte[] sumOf, Function1<? super UByte, Long> selector) {
        Intrinsics.checkNotNullParameter(sumOf, "$this$sumOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iM5549getSizeimpl = UByteArray.m5549getSizeimpl(sumOf);
        long jLongValue = 0;
        for (int i = 0; i < iM5549getSizeimpl; i++) {
            jLongValue += selector.invoke(UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(sumOf, i))).longValue();
        }
        return jLongValue;
    }

    private static final long sumOfLong(short[] sumOf, Function1<? super UShort, Long> selector) {
        Intrinsics.checkNotNullParameter(sumOf, "$this$sumOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iM5812getSizeimpl = UShortArray.m5812getSizeimpl(sumOf);
        long jLongValue = 0;
        for (int i = 0; i < iM5812getSizeimpl; i++) {
            jLongValue += selector.invoke(UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(sumOf, i))).longValue();
        }
        return jLongValue;
    }

    private static final int sumOfUInt(int[] sumOf, Function1<? super UInt, UInt> selector) {
        Intrinsics.checkNotNullParameter(sumOf, "$this$sumOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iM5567constructorimpl = UInt.m5567constructorimpl(0);
        int iM5628getSizeimpl = UIntArray.m5628getSizeimpl(sumOf);
        for (int i = 0; i < iM5628getSizeimpl; i++) {
            iM5567constructorimpl = UInt.m5567constructorimpl(iM5567constructorimpl + selector.invoke(UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(sumOf, i))).m5619unboximpl());
        }
        return iM5567constructorimpl;
    }

    private static final int sumOfUInt(long[] sumOf, Function1<? super ULong, UInt> selector) {
        Intrinsics.checkNotNullParameter(sumOf, "$this$sumOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iM5567constructorimpl = UInt.m5567constructorimpl(0);
        int iM5707getSizeimpl = ULongArray.m5707getSizeimpl(sumOf);
        for (int i = 0; i < iM5707getSizeimpl; i++) {
            iM5567constructorimpl = UInt.m5567constructorimpl(iM5567constructorimpl + selector.invoke(ULong.m5640boximpl(ULongArray.m5706getsVKNKU(sumOf, i))).m5619unboximpl());
        }
        return iM5567constructorimpl;
    }

    private static final int sumOfUInt(byte[] sumOf, Function1<? super UByte, UInt> selector) {
        Intrinsics.checkNotNullParameter(sumOf, "$this$sumOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iM5567constructorimpl = UInt.m5567constructorimpl(0);
        int iM5549getSizeimpl = UByteArray.m5549getSizeimpl(sumOf);
        for (int i = 0; i < iM5549getSizeimpl; i++) {
            iM5567constructorimpl = UInt.m5567constructorimpl(iM5567constructorimpl + selector.invoke(UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(sumOf, i))).m5619unboximpl());
        }
        return iM5567constructorimpl;
    }

    private static final int sumOfUInt(short[] sumOf, Function1<? super UShort, UInt> selector) {
        Intrinsics.checkNotNullParameter(sumOf, "$this$sumOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iM5567constructorimpl = UInt.m5567constructorimpl(0);
        int iM5812getSizeimpl = UShortArray.m5812getSizeimpl(sumOf);
        for (int i = 0; i < iM5812getSizeimpl; i++) {
            iM5567constructorimpl = UInt.m5567constructorimpl(iM5567constructorimpl + selector.invoke(UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(sumOf, i))).m5619unboximpl());
        }
        return iM5567constructorimpl;
    }

    private static final long sumOfULong(int[] sumOf, Function1<? super UInt, ULong> selector) {
        Intrinsics.checkNotNullParameter(sumOf, "$this$sumOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        long jM5646constructorimpl = ULong.m5646constructorimpl(0L);
        int iM5628getSizeimpl = UIntArray.m5628getSizeimpl(sumOf);
        for (int i = 0; i < iM5628getSizeimpl; i++) {
            jM5646constructorimpl = ULong.m5646constructorimpl(jM5646constructorimpl + selector.invoke(UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(sumOf, i))).m5698unboximpl());
        }
        return jM5646constructorimpl;
    }

    private static final long sumOfULong(long[] sumOf, Function1<? super ULong, ULong> selector) {
        Intrinsics.checkNotNullParameter(sumOf, "$this$sumOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        long jM5646constructorimpl = ULong.m5646constructorimpl(0L);
        int iM5707getSizeimpl = ULongArray.m5707getSizeimpl(sumOf);
        for (int i = 0; i < iM5707getSizeimpl; i++) {
            jM5646constructorimpl = ULong.m5646constructorimpl(jM5646constructorimpl + selector.invoke(ULong.m5640boximpl(ULongArray.m5706getsVKNKU(sumOf, i))).m5698unboximpl());
        }
        return jM5646constructorimpl;
    }

    private static final long sumOfULong(byte[] sumOf, Function1<? super UByte, ULong> selector) {
        Intrinsics.checkNotNullParameter(sumOf, "$this$sumOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        long jM5646constructorimpl = ULong.m5646constructorimpl(0L);
        int iM5549getSizeimpl = UByteArray.m5549getSizeimpl(sumOf);
        for (int i = 0; i < iM5549getSizeimpl; i++) {
            jM5646constructorimpl = ULong.m5646constructorimpl(jM5646constructorimpl + selector.invoke(UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(sumOf, i))).m5698unboximpl());
        }
        return jM5646constructorimpl;
    }

    private static final long sumOfULong(short[] sumOf, Function1<? super UShort, ULong> selector) {
        Intrinsics.checkNotNullParameter(sumOf, "$this$sumOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        long jM5646constructorimpl = ULong.m5646constructorimpl(0L);
        int iM5812getSizeimpl = UShortArray.m5812getSizeimpl(sumOf);
        for (int i = 0; i < iM5812getSizeimpl; i++) {
            jM5646constructorimpl = ULong.m5646constructorimpl(jM5646constructorimpl + selector.invoke(UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(sumOf, i))).m5698unboximpl());
        }
        return jM5646constructorimpl;
    }

    /* JADX INFO: renamed from: zip-C-E_24M, reason: not valid java name */
    public static final <R> List<Pair<UInt, R>> m6643zipCE_24M(@NotNull int[] zip, @NotNull R[] other) {
        Intrinsics.checkNotNullParameter(zip, "$this$zip");
        Intrinsics.checkNotNullParameter(other, "other");
        int iMin = Math.min(UIntArray.m5628getSizeimpl(zip), other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i = 0; i < iMin; i++) {
            int iM5627getpVg5ArA = UIntArray.m5627getpVg5ArA(zip, i);
            arrayList.add(TuplesKt.to(UInt.m5561boximpl(iM5627getpVg5ArA), other[i]));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-f7H3mmw, reason: not valid java name */
    public static final <R> List<Pair<ULong, R>> m6657zipf7H3mmw(@NotNull long[] zip, @NotNull R[] other) {
        Intrinsics.checkNotNullParameter(zip, "$this$zip");
        Intrinsics.checkNotNullParameter(other, "other");
        int iMin = Math.min(ULongArray.m5707getSizeimpl(zip), other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i = 0; i < iMin; i++) {
            long jM5706getsVKNKU = ULongArray.m5706getsVKNKU(zip, i);
            arrayList.add(TuplesKt.to(ULong.m5640boximpl(jM5706getsVKNKU), other[i]));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-nl983wc, reason: not valid java name */
    public static final <R> List<Pair<UByte, R>> m6662zipnl983wc(@NotNull byte[] zip, @NotNull R[] other) {
        Intrinsics.checkNotNullParameter(zip, "$this$zip");
        Intrinsics.checkNotNullParameter(other, "other");
        int iMin = Math.min(UByteArray.m5549getSizeimpl(zip), other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i = 0; i < iMin; i++) {
            byte bM5548getw2LRezQ = UByteArray.m5548getw2LRezQ(zip, i);
            arrayList.add(TuplesKt.to(UByte.m5484boximpl(bM5548getw2LRezQ), other[i]));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-uaTIQ5s, reason: not valid java name */
    public static final <R> List<Pair<UShort, R>> m6663zipuaTIQ5s(@NotNull short[] zip, @NotNull R[] other) {
        Intrinsics.checkNotNullParameter(zip, "$this$zip");
        Intrinsics.checkNotNullParameter(other, "other");
        int iMin = Math.min(UShortArray.m5812getSizeimpl(zip), other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i = 0; i < iMin; i++) {
            short sM5811getMh2AYeg = UShortArray.m5811getMh2AYeg(zip, i);
            arrayList.add(TuplesKt.to(UShort.m5747boximpl(sM5811getMh2AYeg), other[i]));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-ZjwqOic, reason: not valid java name */
    private static final <R, V> List<V> m6654zipZjwqOic(int[] zip, R[] other, Function2<? super UInt, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(zip, "$this$zip");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iMin = Math.min(UIntArray.m5628getSizeimpl(zip), other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i = 0; i < iMin; i++) {
            arrayList.add(transform.invoke(UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(zip, i)), other[i]));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-8LME4QE, reason: not valid java name */
    private static final <R, V> List<V> m6642zip8LME4QE(long[] zip, R[] other, Function2<? super ULong, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(zip, "$this$zip");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iMin = Math.min(ULongArray.m5707getSizeimpl(zip), other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i = 0; i < iMin; i++) {
            arrayList.add(transform.invoke(ULong.m5640boximpl(ULongArray.m5706getsVKNKU(zip, i)), other[i]));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-LuipOMY, reason: not valid java name */
    private static final <R, V> List<V> m6650zipLuipOMY(byte[] zip, R[] other, Function2<? super UByte, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(zip, "$this$zip");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iMin = Math.min(UByteArray.m5549getSizeimpl(zip), other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i = 0; i < iMin; i++) {
            arrayList.add(transform.invoke(UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(zip, i)), other[i]));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-ePBmRWY, reason: not valid java name */
    private static final <R, V> List<V> m6656zipePBmRWY(short[] zip, R[] other, Function2<? super UShort, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(zip, "$this$zip");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iMin = Math.min(UShortArray.m5812getSizeimpl(zip), other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i = 0; i < iMin; i++) {
            arrayList.add(transform.invoke(UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(zip, i)), other[i]));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-HwE9HBo, reason: not valid java name */
    public static final <R> List<Pair<UInt, R>> m6645zipHwE9HBo(@NotNull int[] zip, @NotNull Iterable<? extends R> other) {
        Intrinsics.checkNotNullParameter(zip, "$this$zip");
        Intrinsics.checkNotNullParameter(other, "other");
        int iM5628getSizeimpl = UIntArray.m5628getSizeimpl(zip);
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(other, 10), iM5628getSizeimpl));
        int i = 0;
        for (R r : other) {
            if (i >= iM5628getSizeimpl) {
                break;
            }
            arrayList.add(TuplesKt.to(UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(zip, i)), r));
            i++;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-F7u83W8, reason: not valid java name */
    public static final <R> List<Pair<ULong, R>> m6644zipF7u83W8(@NotNull long[] zip, @NotNull Iterable<? extends R> other) {
        Intrinsics.checkNotNullParameter(zip, "$this$zip");
        Intrinsics.checkNotNullParameter(other, "other");
        int iM5707getSizeimpl = ULongArray.m5707getSizeimpl(zip);
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(other, 10), iM5707getSizeimpl));
        int i = 0;
        for (R r : other) {
            if (i >= iM5707getSizeimpl) {
                break;
            }
            arrayList.add(TuplesKt.to(ULong.m5640boximpl(ULongArray.m5706getsVKNKU(zip, i)), r));
            i++;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-JQknh5Q, reason: not valid java name */
    public static final <R> List<Pair<UByte, R>> m6648zipJQknh5Q(@NotNull byte[] zip, @NotNull Iterable<? extends R> other) {
        Intrinsics.checkNotNullParameter(zip, "$this$zip");
        Intrinsics.checkNotNullParameter(other, "other");
        int iM5549getSizeimpl = UByteArray.m5549getSizeimpl(zip);
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(other, 10), iM5549getSizeimpl));
        int i = 0;
        for (R r : other) {
            if (i >= iM5549getSizeimpl) {
                break;
            }
            arrayList.add(TuplesKt.to(UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(zip, i)), r));
            i++;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-JGPC0-M, reason: not valid java name */
    public static final <R> List<Pair<UShort, R>> m6647zipJGPC0M(@NotNull short[] zip, @NotNull Iterable<? extends R> other) {
        Intrinsics.checkNotNullParameter(zip, "$this$zip");
        Intrinsics.checkNotNullParameter(other, "other");
        int iM5812getSizeimpl = UShortArray.m5812getSizeimpl(zip);
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(other, 10), iM5812getSizeimpl));
        int i = 0;
        for (R r : other) {
            if (i >= iM5812getSizeimpl) {
                break;
            }
            arrayList.add(TuplesKt.to(UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(zip, i)), r));
            i++;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-7znnbtw, reason: not valid java name */
    private static final <R, V> List<V> m6641zip7znnbtw(int[] zip, Iterable<? extends R> other, Function2<? super UInt, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(zip, "$this$zip");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iM5628getSizeimpl = UIntArray.m5628getSizeimpl(zip);
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(other, 10), iM5628getSizeimpl));
        int i = 0;
        for (R r : other) {
            if (i >= iM5628getSizeimpl) {
                break;
            }
            arrayList.add(transform.invoke(UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(zip, i)), r));
            i++;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-TUPTUsU, reason: not valid java name */
    private static final <R, V> List<V> m6652zipTUPTUsU(long[] zip, Iterable<? extends R> other, Function2<? super ULong, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(zip, "$this$zip");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iM5707getSizeimpl = ULongArray.m5707getSizeimpl(zip);
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(other, 10), iM5707getSizeimpl));
        int i = 0;
        for (R r : other) {
            if (i >= iM5707getSizeimpl) {
                break;
            }
            arrayList.add(transform.invoke(ULong.m5640boximpl(ULongArray.m5706getsVKNKU(zip, i)), r));
            i++;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-UCnP4_w, reason: not valid java name */
    private static final <R, V> List<V> m6653zipUCnP4_w(byte[] zip, Iterable<? extends R> other, Function2<? super UByte, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(zip, "$this$zip");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iM5549getSizeimpl = UByteArray.m5549getSizeimpl(zip);
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(other, 10), iM5549getSizeimpl));
        int i = 0;
        for (R r : other) {
            if (i >= iM5549getSizeimpl) {
                break;
            }
            arrayList.add(transform.invoke(UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(zip, i)), r));
            i++;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-kBb4a-s, reason: not valid java name */
    private static final <R, V> List<V> m6659zipkBb4as(short[] zip, Iterable<? extends R> other, Function2<? super UShort, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(zip, "$this$zip");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iM5812getSizeimpl = UShortArray.m5812getSizeimpl(zip);
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(other, 10), iM5812getSizeimpl));
        int i = 0;
        for (R r : other) {
            if (i >= iM5812getSizeimpl) {
                break;
            }
            arrayList.add(transform.invoke(UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(zip, i)), r));
            i++;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-ctEhBpI, reason: not valid java name */
    public static final List<Pair<UInt, UInt>> m6655zipctEhBpI(@NotNull int[] zip, @NotNull int[] other) {
        Intrinsics.checkNotNullParameter(zip, "$this$zip");
        Intrinsics.checkNotNullParameter(other, "other");
        int iMin = Math.min(UIntArray.m5628getSizeimpl(zip), UIntArray.m5628getSizeimpl(other));
        ArrayList arrayList = new ArrayList(iMin);
        for (int i = 0; i < iMin; i++) {
            arrayList.add(TuplesKt.to(UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(zip, i)), UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(other, i))));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-us8wMrg, reason: not valid java name */
    public static final List<Pair<ULong, ULong>> m6664zipus8wMrg(@NotNull long[] zip, @NotNull long[] other) {
        Intrinsics.checkNotNullParameter(zip, "$this$zip");
        Intrinsics.checkNotNullParameter(other, "other");
        int iMin = Math.min(ULongArray.m5707getSizeimpl(zip), ULongArray.m5707getSizeimpl(other));
        ArrayList arrayList = new ArrayList(iMin);
        for (int i = 0; i < iMin; i++) {
            arrayList.add(TuplesKt.to(ULong.m5640boximpl(ULongArray.m5706getsVKNKU(zip, i)), ULong.m5640boximpl(ULongArray.m5706getsVKNKU(other, i))));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-kdPth3s, reason: not valid java name */
    public static final List<Pair<UByte, UByte>> m6660zipkdPth3s(@NotNull byte[] zip, @NotNull byte[] other) {
        Intrinsics.checkNotNullParameter(zip, "$this$zip");
        Intrinsics.checkNotNullParameter(other, "other");
        int iMin = Math.min(UByteArray.m5549getSizeimpl(zip), UByteArray.m5549getSizeimpl(other));
        ArrayList arrayList = new ArrayList(iMin);
        for (int i = 0; i < iMin; i++) {
            arrayList.add(TuplesKt.to(UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(zip, i)), UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(other, i))));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-mazbYpA, reason: not valid java name */
    public static final List<Pair<UShort, UShort>> m6661zipmazbYpA(@NotNull short[] zip, @NotNull short[] other) {
        Intrinsics.checkNotNullParameter(zip, "$this$zip");
        Intrinsics.checkNotNullParameter(other, "other");
        int iMin = Math.min(UShortArray.m5812getSizeimpl(zip), UShortArray.m5812getSizeimpl(other));
        ArrayList arrayList = new ArrayList(iMin);
        for (int i = 0; i < iMin; i++) {
            arrayList.add(TuplesKt.to(UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(zip, i)), UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(other, i))));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-L83TJbI, reason: not valid java name */
    private static final <V> List<V> m6649zipL83TJbI(int[] zip, int[] other, Function2<? super UInt, ? super UInt, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(zip, "$this$zip");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iMin = Math.min(UIntArray.m5628getSizeimpl(zip), UIntArray.m5628getSizeimpl(other));
        ArrayList arrayList = new ArrayList(iMin);
        for (int i = 0; i < iMin; i++) {
            arrayList.add(transform.invoke(UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(zip, i)), UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(other, i))));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-PabeH-Q, reason: not valid java name */
    private static final <V> List<V> m6651zipPabeHQ(long[] zip, long[] other, Function2<? super ULong, ? super ULong, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(zip, "$this$zip");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iMin = Math.min(ULongArray.m5707getSizeimpl(zip), ULongArray.m5707getSizeimpl(other));
        ArrayList arrayList = new ArrayList(iMin);
        for (int i = 0; i < iMin; i++) {
            arrayList.add(transform.invoke(ULong.m5640boximpl(ULongArray.m5706getsVKNKU(zip, i)), ULong.m5640boximpl(ULongArray.m5706getsVKNKU(other, i))));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-JAKpvQM, reason: not valid java name */
    private static final <V> List<V> m6646zipJAKpvQM(byte[] zip, byte[] other, Function2<? super UByte, ? super UByte, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(zip, "$this$zip");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iMin = Math.min(UByteArray.m5549getSizeimpl(zip), UByteArray.m5549getSizeimpl(other));
        ArrayList arrayList = new ArrayList(iMin);
        for (int i = 0; i < iMin; i++) {
            arrayList.add(transform.invoke(UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(zip, i)), UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(other, i))));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-gVVukQo, reason: not valid java name */
    private static final <V> List<V> m6658zipgVVukQo(short[] zip, short[] other, Function2<? super UShort, ? super UShort, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(zip, "$this$zip");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iMin = Math.min(UShortArray.m5812getSizeimpl(zip), UShortArray.m5812getSizeimpl(other));
        ArrayList arrayList = new ArrayList(iMin);
        for (int i = 0; i < iMin; i++) {
            arrayList.add(transform.invoke(UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(zip, i)), UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(other, i))));
        }
        return arrayList;
    }

    public static final int sumOfUInt(@NotNull UInt[] uIntArr) {
        Intrinsics.checkNotNullParameter(uIntArr, "<this>");
        int iM5567constructorimpl = 0;
        for (UInt uInt : uIntArr) {
            iM5567constructorimpl = UInt.m5567constructorimpl(iM5567constructorimpl + uInt.m5619unboximpl());
        }
        return iM5567constructorimpl;
    }

    public static final long sumOfULong(@NotNull ULong[] uLongArr) {
        Intrinsics.checkNotNullParameter(uLongArr, "<this>");
        long jM5646constructorimpl = 0;
        for (ULong uLong : uLongArr) {
            jM5646constructorimpl = ULong.m5646constructorimpl(jM5646constructorimpl + uLong.m5698unboximpl());
        }
        return jM5646constructorimpl;
    }

    public static final int sumOfUByte(@NotNull UByte[] uByteArr) {
        Intrinsics.checkNotNullParameter(uByteArr, "<this>");
        int iM5567constructorimpl = 0;
        for (UByte uByte : uByteArr) {
            iM5567constructorimpl = UInt.m5567constructorimpl(iM5567constructorimpl + UInt.m5567constructorimpl(uByte.m5540unboximpl() & 255));
        }
        return iM5567constructorimpl;
    }

    public static final int sumOfUShort(@NotNull UShort[] uShortArr) {
        Intrinsics.checkNotNullParameter(uShortArr, "<this>");
        int iM5567constructorimpl = 0;
        for (UShort uShort : uShortArr) {
            iM5567constructorimpl = UInt.m5567constructorimpl(iM5567constructorimpl + UInt.m5567constructorimpl(uShort.m5803unboximpl() & UShort.MAX_VALUE));
        }
        return iM5567constructorimpl;
    }

    /* JADX INFO: renamed from: sum--ajY-9A, reason: not valid java name */
    private static final int m6601sumajY9A(int[] sum) {
        Intrinsics.checkNotNullParameter(sum, "$this$sum");
        return UInt.m5567constructorimpl(ArraysKt___ArraysKt.sum(sum));
    }

    /* JADX INFO: renamed from: sum-QwZRm1k, reason: not valid java name */
    private static final long m6603sumQwZRm1k(long[] sum) {
        Intrinsics.checkNotNullParameter(sum, "$this$sum");
        return ULong.m5646constructorimpl(ArraysKt___ArraysKt.sum(sum));
    }

    /* JADX INFO: renamed from: sum-GBYM_sE, reason: not valid java name */
    private static final int m6602sumGBYM_sE(byte[] sum) {
        Intrinsics.checkNotNullParameter(sum, "$this$sum");
        int iM5567constructorimpl = UInt.m5567constructorimpl(0);
        int iM5549getSizeimpl = UByteArray.m5549getSizeimpl(sum);
        for (int i = 0; i < iM5549getSizeimpl; i++) {
            iM5567constructorimpl = UInt.m5567constructorimpl(iM5567constructorimpl + UInt.m5567constructorimpl(UByteArray.m5548getw2LRezQ(sum, i) & 255));
        }
        return iM5567constructorimpl;
    }

    /* JADX INFO: renamed from: sum-rL5Bavg, reason: not valid java name */
    private static final int m6604sumrL5Bavg(short[] sum) {
        Intrinsics.checkNotNullParameter(sum, "$this$sum");
        int iM5567constructorimpl = UInt.m5567constructorimpl(0);
        int iM5812getSizeimpl = UShortArray.m5812getSizeimpl(sum);
        for (int i = 0; i < iM5812getSizeimpl; i++) {
            iM5567constructorimpl = UInt.m5567constructorimpl(iM5567constructorimpl + UInt.m5567constructorimpl(UShortArray.m5811getMh2AYeg(sum, i) & UShort.MAX_VALUE));
        }
        return iM5567constructorimpl;
    }

    /* JADX INFO: renamed from: indexOfFirst-jgv0xPQ, reason: not valid java name */
    private static final int m6255indexOfFirstjgv0xPQ(int[] indexOfFirst, Function1<? super UInt, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(indexOfFirst, "$this$indexOfFirst");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = indexOfFirst.length;
        for (int i = 0; i < length; i++) {
            if (predicate.invoke(UInt.m5561boximpl(UInt.m5567constructorimpl(indexOfFirst[i]))).booleanValue()) {
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: indexOfFirst-MShoTSo, reason: not valid java name */
    private static final int m6254indexOfFirstMShoTSo(long[] indexOfFirst, Function1<? super ULong, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(indexOfFirst, "$this$indexOfFirst");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = indexOfFirst.length;
        for (int i = 0; i < length; i++) {
            if (predicate.invoke(ULong.m5640boximpl(ULong.m5646constructorimpl(indexOfFirst[i]))).booleanValue()) {
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: indexOfFirst-JOV_ifY, reason: not valid java name */
    private static final int m6253indexOfFirstJOV_ifY(byte[] indexOfFirst, Function1<? super UByte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(indexOfFirst, "$this$indexOfFirst");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = indexOfFirst.length;
        for (int i = 0; i < length; i++) {
            if (predicate.invoke(UByte.m5484boximpl(UByte.m5490constructorimpl(indexOfFirst[i]))).booleanValue()) {
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: indexOfFirst-xTcfx_M, reason: not valid java name */
    private static final int m6256indexOfFirstxTcfx_M(short[] indexOfFirst, Function1<? super UShort, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(indexOfFirst, "$this$indexOfFirst");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = indexOfFirst.length;
        for (int i = 0; i < length; i++) {
            if (predicate.invoke(UShort.m5747boximpl(UShort.m5753constructorimpl(indexOfFirst[i]))).booleanValue()) {
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: indexOfLast-jgv0xPQ, reason: not valid java name */
    private static final int m6259indexOfLastjgv0xPQ(int[] indexOfLast, Function1<? super UInt, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(indexOfLast, "$this$indexOfLast");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = indexOfLast.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (predicate.invoke(UInt.m5561boximpl(UInt.m5567constructorimpl(indexOfLast[length]))).booleanValue()) {
                    return length;
                }
                if (i >= 0) {
                    length = i;
                }
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: indexOfLast-MShoTSo, reason: not valid java name */
    private static final int m6258indexOfLastMShoTSo(long[] indexOfLast, Function1<? super ULong, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(indexOfLast, "$this$indexOfLast");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = indexOfLast.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (predicate.invoke(ULong.m5640boximpl(ULong.m5646constructorimpl(indexOfLast[length]))).booleanValue()) {
                    return length;
                }
                if (i >= 0) {
                    length = i;
                }
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: indexOfLast-JOV_ifY, reason: not valid java name */
    private static final int m6257indexOfLastJOV_ifY(byte[] indexOfLast, Function1<? super UByte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(indexOfLast, "$this$indexOfLast");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = indexOfLast.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (predicate.invoke(UByte.m5484boximpl(UByte.m5490constructorimpl(indexOfLast[length]))).booleanValue()) {
                    return length;
                }
                if (i >= 0) {
                    length = i;
                }
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: indexOfLast-xTcfx_M, reason: not valid java name */
    private static final int m6260indexOfLastxTcfx_M(short[] indexOfLast, Function1<? super UShort, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(indexOfLast, "$this$indexOfLast");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = indexOfLast.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (predicate.invoke(UShort.m5747boximpl(UShort.m5753constructorimpl(indexOfLast[length]))).booleanValue()) {
                    return length;
                }
                if (i >= 0) {
                    length = i;
                }
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: dropLastWhile-jgv0xPQ, reason: not valid java name */
    private static final List<UInt> m6099dropLastWhilejgv0xPQ(int[] dropLastWhile, Function1<? super UInt, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dropLastWhile, "$this$dropLastWhile");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = ArraysKt___ArraysKt.getLastIndex(dropLastWhile); -1 < lastIndex; lastIndex--) {
            if (!predicate.invoke(UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(dropLastWhile, lastIndex))).booleanValue()) {
                return m6615takeqFRl0hI(dropLastWhile, lastIndex + 1);
            }
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    /* JADX INFO: renamed from: dropLastWhile-MShoTSo, reason: not valid java name */
    private static final List<ULong> m6098dropLastWhileMShoTSo(long[] dropLastWhile, Function1<? super ULong, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dropLastWhile, "$this$dropLastWhile");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = ArraysKt___ArraysKt.getLastIndex(dropLastWhile); -1 < lastIndex; lastIndex--) {
            if (!predicate.invoke(ULong.m5640boximpl(ULongArray.m5706getsVKNKU(dropLastWhile, lastIndex))).booleanValue()) {
                return m6616taker7IrZao(dropLastWhile, lastIndex + 1);
            }
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    /* JADX INFO: renamed from: dropLastWhile-JOV_ifY, reason: not valid java name */
    private static final List<UByte> m6097dropLastWhileJOV_ifY(byte[] dropLastWhile, Function1<? super UByte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dropLastWhile, "$this$dropLastWhile");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = ArraysKt___ArraysKt.getLastIndex(dropLastWhile); -1 < lastIndex; lastIndex--) {
            if (!predicate.invoke(UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(dropLastWhile, lastIndex))).booleanValue()) {
                return m6613takePpDY95g(dropLastWhile, lastIndex + 1);
            }
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    /* JADX INFO: renamed from: dropLastWhile-xTcfx_M, reason: not valid java name */
    private static final List<UShort> m6100dropLastWhilexTcfx_M(short[] dropLastWhile, Function1<? super UShort, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dropLastWhile, "$this$dropLastWhile");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = ArraysKt___ArraysKt.getLastIndex(dropLastWhile); -1 < lastIndex; lastIndex--) {
            if (!predicate.invoke(UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(dropLastWhile, lastIndex))).booleanValue()) {
                return m6614takenggk6HY(dropLastWhile, lastIndex + 1);
            }
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    /* JADX INFO: renamed from: takeLastWhile-jgv0xPQ, reason: not valid java name */
    private static final List<UInt> m6623takeLastWhilejgv0xPQ(int[] takeLastWhile, Function1<? super UInt, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(takeLastWhile, "$this$takeLastWhile");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = ArraysKt___ArraysKt.getLastIndex(takeLastWhile); -1 < lastIndex; lastIndex--) {
            if (!predicate.invoke(UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(takeLastWhile, lastIndex))).booleanValue()) {
                return m6091dropqFRl0hI(takeLastWhile, lastIndex + 1);
            }
        }
        return CollectionsKt___CollectionsKt.toList(UIntArray.m5620boximpl(takeLastWhile));
    }

    /* JADX INFO: renamed from: takeLastWhile-MShoTSo, reason: not valid java name */
    private static final List<ULong> m6622takeLastWhileMShoTSo(long[] takeLastWhile, Function1<? super ULong, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(takeLastWhile, "$this$takeLastWhile");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = ArraysKt___ArraysKt.getLastIndex(takeLastWhile); -1 < lastIndex; lastIndex--) {
            if (!predicate.invoke(ULong.m5640boximpl(ULongArray.m5706getsVKNKU(takeLastWhile, lastIndex))).booleanValue()) {
                return m6092dropr7IrZao(takeLastWhile, lastIndex + 1);
            }
        }
        return CollectionsKt___CollectionsKt.toList(ULongArray.m5699boximpl(takeLastWhile));
    }

    /* JADX INFO: renamed from: takeLastWhile-JOV_ifY, reason: not valid java name */
    private static final List<UByte> m6621takeLastWhileJOV_ifY(byte[] takeLastWhile, Function1<? super UByte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(takeLastWhile, "$this$takeLastWhile");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = ArraysKt___ArraysKt.getLastIndex(takeLastWhile); -1 < lastIndex; lastIndex--) {
            if (!predicate.invoke(UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(takeLastWhile, lastIndex))).booleanValue()) {
                return m6089dropPpDY95g(takeLastWhile, lastIndex + 1);
            }
        }
        return CollectionsKt___CollectionsKt.toList(UByteArray.m5541boximpl(takeLastWhile));
    }

    /* JADX INFO: renamed from: takeLastWhile-xTcfx_M, reason: not valid java name */
    private static final List<UShort> m6624takeLastWhilexTcfx_M(short[] takeLastWhile, Function1<? super UShort, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(takeLastWhile, "$this$takeLastWhile");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = ArraysKt___ArraysKt.getLastIndex(takeLastWhile); -1 < lastIndex; lastIndex--) {
            if (!predicate.invoke(UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(takeLastWhile, lastIndex))).booleanValue()) {
                return m6090dropnggk6HY(takeLastWhile, lastIndex + 1);
            }
        }
        return CollectionsKt___CollectionsKt.toList(UShortArray.m5804boximpl(takeLastWhile));
    }

    /* JADX INFO: renamed from: shuffle-2D5oskM, reason: not valid java name */
    public static final void m6526shuffle2D5oskM(@NotNull int[] shuffle, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(shuffle, "$this$shuffle");
        Intrinsics.checkNotNullParameter(random, "random");
        for (int lastIndex = ArraysKt___ArraysKt.getLastIndex(shuffle); lastIndex > 0; lastIndex--) {
            int iNextInt = random.nextInt(lastIndex + 1);
            int iM5627getpVg5ArA = UIntArray.m5627getpVg5ArA(shuffle, lastIndex);
            UIntArray.m5632setVXSXFK8(shuffle, lastIndex, UIntArray.m5627getpVg5ArA(shuffle, iNextInt));
            UIntArray.m5632setVXSXFK8(shuffle, iNextInt, iM5627getpVg5ArA);
        }
    }

    /* JADX INFO: renamed from: shuffle-JzugnMA, reason: not valid java name */
    public static final void m6528shuffleJzugnMA(@NotNull long[] shuffle, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(shuffle, "$this$shuffle");
        Intrinsics.checkNotNullParameter(random, "random");
        for (int lastIndex = ArraysKt___ArraysKt.getLastIndex(shuffle); lastIndex > 0; lastIndex--) {
            int iNextInt = random.nextInt(lastIndex + 1);
            long jM5706getsVKNKU = ULongArray.m5706getsVKNKU(shuffle, lastIndex);
            ULongArray.m5711setk8EXiF4(shuffle, lastIndex, ULongArray.m5706getsVKNKU(shuffle, iNextInt));
            ULongArray.m5711setk8EXiF4(shuffle, iNextInt, jM5706getsVKNKU);
        }
    }

    /* JADX INFO: renamed from: shuffle-oSF2wD8, reason: not valid java name */
    public static final void m6530shuffleoSF2wD8(@NotNull byte[] shuffle, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(shuffle, "$this$shuffle");
        Intrinsics.checkNotNullParameter(random, "random");
        for (int lastIndex = ArraysKt___ArraysKt.getLastIndex(shuffle); lastIndex > 0; lastIndex--) {
            int iNextInt = random.nextInt(lastIndex + 1);
            byte bM5548getw2LRezQ = UByteArray.m5548getw2LRezQ(shuffle, lastIndex);
            UByteArray.m5553setVurrAj0(shuffle, lastIndex, UByteArray.m5548getw2LRezQ(shuffle, iNextInt));
            UByteArray.m5553setVurrAj0(shuffle, iNextInt, bM5548getw2LRezQ);
        }
    }

    /* JADX INFO: renamed from: shuffle-s5X_as8, reason: not valid java name */
    public static final void m6532shuffles5X_as8(@NotNull short[] shuffle, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(shuffle, "$this$shuffle");
        Intrinsics.checkNotNullParameter(random, "random");
        for (int lastIndex = ArraysKt___ArraysKt.getLastIndex(shuffle); lastIndex > 0; lastIndex--) {
            int iNextInt = random.nextInt(lastIndex + 1);
            short sM5811getMh2AYeg = UShortArray.m5811getMh2AYeg(shuffle, lastIndex);
            UShortArray.m5816set01HTLdE(shuffle, lastIndex, UShortArray.m5811getMh2AYeg(shuffle, iNextInt));
            UShortArray.m5816set01HTLdE(shuffle, iNextInt, sM5811getMh2AYeg);
        }
    }

    /* JADX INFO: renamed from: foldRight-zi1B2BA, reason: not valid java name */
    private static final <R> R m6195foldRightzi1B2BA(int[] foldRight, R r, Function2<? super UInt, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(foldRight, "$this$foldRight");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = ArraysKt___ArraysKt.getLastIndex(foldRight); lastIndex >= 0; lastIndex--) {
            r = operation.invoke(UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(foldRight, lastIndex)), r);
        }
        return r;
    }

    /* JADX INFO: renamed from: foldRight-A8wKCXQ, reason: not valid java name */
    private static final <R> R m6193foldRightA8wKCXQ(long[] foldRight, R r, Function2<? super ULong, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(foldRight, "$this$foldRight");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = ArraysKt___ArraysKt.getLastIndex(foldRight); lastIndex >= 0; lastIndex--) {
            r = operation.invoke(ULong.m5640boximpl(ULongArray.m5706getsVKNKU(foldRight, lastIndex)), r);
        }
        return r;
    }

    /* JADX INFO: renamed from: foldRight-yXmHNn8, reason: not valid java name */
    private static final <R> R m6194foldRightyXmHNn8(byte[] foldRight, R r, Function2<? super UByte, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(foldRight, "$this$foldRight");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = ArraysKt___ArraysKt.getLastIndex(foldRight); lastIndex >= 0; lastIndex--) {
            r = operation.invoke(UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(foldRight, lastIndex)), r);
        }
        return r;
    }

    /* JADX INFO: renamed from: foldRight-zww5nb8, reason: not valid java name */
    private static final <R> R m6196foldRightzww5nb8(short[] foldRight, R r, Function2<? super UShort, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(foldRight, "$this$foldRight");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = ArraysKt___ArraysKt.getLastIndex(foldRight); lastIndex >= 0; lastIndex--) {
            r = operation.invoke(UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(foldRight, lastIndex)), r);
        }
        return r;
    }

    /* JADX INFO: renamed from: foldRightIndexed-yVwIW0Q, reason: not valid java name */
    private static final <R> R m6200foldRightIndexedyVwIW0Q(int[] foldRightIndexed, R r, Function3<? super Integer, ? super UInt, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(foldRightIndexed, "$this$foldRightIndexed");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = ArraysKt___ArraysKt.getLastIndex(foldRightIndexed); lastIndex >= 0; lastIndex--) {
            r = operation.invoke(Integer.valueOf(lastIndex), UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(foldRightIndexed, lastIndex)), r);
        }
        return r;
    }

    /* JADX INFO: renamed from: foldRightIndexed-mwnnOCs, reason: not valid java name */
    private static final <R> R m6199foldRightIndexedmwnnOCs(long[] foldRightIndexed, R r, Function3<? super Integer, ? super ULong, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(foldRightIndexed, "$this$foldRightIndexed");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = ArraysKt___ArraysKt.getLastIndex(foldRightIndexed); lastIndex >= 0; lastIndex--) {
            r = operation.invoke(Integer.valueOf(lastIndex), ULong.m5640boximpl(ULongArray.m5706getsVKNKU(foldRightIndexed, lastIndex)), r);
        }
        return r;
    }

    /* JADX INFO: renamed from: foldRightIndexed-3iWJZGE, reason: not valid java name */
    private static final <R> R m6197foldRightIndexed3iWJZGE(byte[] foldRightIndexed, R r, Function3<? super Integer, ? super UByte, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(foldRightIndexed, "$this$foldRightIndexed");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = ArraysKt___ArraysKt.getLastIndex(foldRightIndexed); lastIndex >= 0; lastIndex--) {
            r = operation.invoke(Integer.valueOf(lastIndex), UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(foldRightIndexed, lastIndex)), r);
        }
        return r;
    }

    /* JADX INFO: renamed from: foldRightIndexed-bzxtMww, reason: not valid java name */
    private static final <R> R m6198foldRightIndexedbzxtMww(short[] foldRightIndexed, R r, Function3<? super Integer, ? super UShort, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(foldRightIndexed, "$this$foldRightIndexed");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = ArraysKt___ArraysKt.getLastIndex(foldRightIndexed); lastIndex >= 0; lastIndex--) {
            r = operation.invoke(Integer.valueOf(lastIndex), UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(foldRightIndexed, lastIndex)), r);
        }
        return r;
    }

    /* JADX INFO: renamed from: reduceRight-WyvcNBI, reason: not valid java name */
    private static final int m6470reduceRightWyvcNBI(int[] reduceRight, Function2<? super UInt, ? super UInt, UInt> operation) {
        Intrinsics.checkNotNullParameter(reduceRight, "$this$reduceRight");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(reduceRight);
        if (lastIndex < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        int iM5627getpVg5ArA = UIntArray.m5627getpVg5ArA(reduceRight, lastIndex);
        for (int i = lastIndex - 1; i >= 0; i--) {
            iM5627getpVg5ArA = operation.invoke(UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(reduceRight, i)), UInt.m5561boximpl(iM5627getpVg5ArA)).m5619unboximpl();
        }
        return iM5627getpVg5ArA;
    }

    /* JADX INFO: renamed from: reduceRight-s8dVfGU, reason: not valid java name */
    private static final long m6471reduceRights8dVfGU(long[] reduceRight, Function2<? super ULong, ? super ULong, ULong> operation) {
        Intrinsics.checkNotNullParameter(reduceRight, "$this$reduceRight");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(reduceRight);
        if (lastIndex < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        long jM5706getsVKNKU = ULongArray.m5706getsVKNKU(reduceRight, lastIndex);
        for (int i = lastIndex - 1; i >= 0; i--) {
            jM5706getsVKNKU = operation.invoke(ULong.m5640boximpl(ULongArray.m5706getsVKNKU(reduceRight, i)), ULong.m5640boximpl(jM5706getsVKNKU)).m5698unboximpl();
        }
        return jM5706getsVKNKU;
    }

    /* JADX INFO: renamed from: reduceRight-ELGow60, reason: not valid java name */
    private static final byte m6469reduceRightELGow60(byte[] reduceRight, Function2<? super UByte, ? super UByte, UByte> operation) {
        Intrinsics.checkNotNullParameter(reduceRight, "$this$reduceRight");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(reduceRight);
        if (lastIndex < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        byte bM5548getw2LRezQ = UByteArray.m5548getw2LRezQ(reduceRight, lastIndex);
        for (int i = lastIndex - 1; i >= 0; i--) {
            bM5548getw2LRezQ = operation.invoke(UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(reduceRight, i)), UByte.m5484boximpl(bM5548getw2LRezQ)).m5540unboximpl();
        }
        return bM5548getw2LRezQ;
    }

    /* JADX INFO: renamed from: reduceRight-xzaTVY8, reason: not valid java name */
    private static final short m6472reduceRightxzaTVY8(short[] reduceRight, Function2<? super UShort, ? super UShort, UShort> operation) {
        Intrinsics.checkNotNullParameter(reduceRight, "$this$reduceRight");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(reduceRight);
        if (lastIndex < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        short sM5811getMh2AYeg = UShortArray.m5811getMh2AYeg(reduceRight, lastIndex);
        for (int i = lastIndex - 1; i >= 0; i--) {
            sM5811getMh2AYeg = operation.invoke(UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(reduceRight, i)), UShort.m5747boximpl(sM5811getMh2AYeg)).m5803unboximpl();
        }
        return sM5811getMh2AYeg;
    }

    /* JADX INFO: renamed from: reduceRightIndexed-D40WMg8, reason: not valid java name */
    private static final int m6473reduceRightIndexedD40WMg8(int[] reduceRightIndexed, Function3<? super Integer, ? super UInt, ? super UInt, UInt> operation) {
        Intrinsics.checkNotNullParameter(reduceRightIndexed, "$this$reduceRightIndexed");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(reduceRightIndexed);
        if (lastIndex < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        int iM5627getpVg5ArA = UIntArray.m5627getpVg5ArA(reduceRightIndexed, lastIndex);
        for (int i = lastIndex - 1; i >= 0; i--) {
            iM5627getpVg5ArA = operation.invoke(Integer.valueOf(i), UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(reduceRightIndexed, i)), UInt.m5561boximpl(iM5627getpVg5ArA)).m5619unboximpl();
        }
        return iM5627getpVg5ArA;
    }

    /* JADX INFO: renamed from: reduceRightIndexed-z1zDJgo, reason: not valid java name */
    private static final long m6476reduceRightIndexedz1zDJgo(long[] reduceRightIndexed, Function3<? super Integer, ? super ULong, ? super ULong, ULong> operation) {
        Intrinsics.checkNotNullParameter(reduceRightIndexed, "$this$reduceRightIndexed");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(reduceRightIndexed);
        if (lastIndex < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        long jM5706getsVKNKU = ULongArray.m5706getsVKNKU(reduceRightIndexed, lastIndex);
        for (int i = lastIndex - 1; i >= 0; i--) {
            jM5706getsVKNKU = operation.invoke(Integer.valueOf(i), ULong.m5640boximpl(ULongArray.m5706getsVKNKU(reduceRightIndexed, i)), ULong.m5640boximpl(jM5706getsVKNKU)).m5698unboximpl();
        }
        return jM5706getsVKNKU;
    }

    /* JADX INFO: renamed from: reduceRightIndexed-EOyYB1Y, reason: not valid java name */
    private static final byte m6474reduceRightIndexedEOyYB1Y(byte[] reduceRightIndexed, Function3<? super Integer, ? super UByte, ? super UByte, UByte> operation) {
        Intrinsics.checkNotNullParameter(reduceRightIndexed, "$this$reduceRightIndexed");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(reduceRightIndexed);
        if (lastIndex < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        byte bM5548getw2LRezQ = UByteArray.m5548getw2LRezQ(reduceRightIndexed, lastIndex);
        for (int i = lastIndex - 1; i >= 0; i--) {
            bM5548getw2LRezQ = operation.invoke(Integer.valueOf(i), UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(reduceRightIndexed, i)), UByte.m5484boximpl(bM5548getw2LRezQ)).m5540unboximpl();
        }
        return bM5548getw2LRezQ;
    }

    /* JADX INFO: renamed from: reduceRightIndexed-aLgx1Fo, reason: not valid java name */
    private static final short m6475reduceRightIndexedaLgx1Fo(short[] reduceRightIndexed, Function3<? super Integer, ? super UShort, ? super UShort, UShort> operation) {
        Intrinsics.checkNotNullParameter(reduceRightIndexed, "$this$reduceRightIndexed");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(reduceRightIndexed);
        if (lastIndex < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        short sM5811getMh2AYeg = UShortArray.m5811getMh2AYeg(reduceRightIndexed, lastIndex);
        for (int i = lastIndex - 1; i >= 0; i--) {
            sM5811getMh2AYeg = operation.invoke(Integer.valueOf(i), UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(reduceRightIndexed, i)), UShort.m5747boximpl(sM5811getMh2AYeg)).m5803unboximpl();
        }
        return sM5811getMh2AYeg;
    }

    /* JADX INFO: renamed from: reduceRightIndexedOrNull-D40WMg8, reason: not valid java name */
    private static final UInt m6477reduceRightIndexedOrNullD40WMg8(int[] reduceRightIndexedOrNull, Function3<? super Integer, ? super UInt, ? super UInt, UInt> operation) {
        Intrinsics.checkNotNullParameter(reduceRightIndexedOrNull, "$this$reduceRightIndexedOrNull");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(reduceRightIndexedOrNull);
        if (lastIndex < 0) {
            return null;
        }
        int iM5627getpVg5ArA = UIntArray.m5627getpVg5ArA(reduceRightIndexedOrNull, lastIndex);
        for (int i = lastIndex - 1; i >= 0; i--) {
            iM5627getpVg5ArA = operation.invoke(Integer.valueOf(i), UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(reduceRightIndexedOrNull, i)), UInt.m5561boximpl(iM5627getpVg5ArA)).m5619unboximpl();
        }
        return UInt.m5561boximpl(iM5627getpVg5ArA);
    }

    /* JADX INFO: renamed from: reduceRightIndexedOrNull-z1zDJgo, reason: not valid java name */
    private static final ULong m6480reduceRightIndexedOrNullz1zDJgo(long[] reduceRightIndexedOrNull, Function3<? super Integer, ? super ULong, ? super ULong, ULong> operation) {
        Intrinsics.checkNotNullParameter(reduceRightIndexedOrNull, "$this$reduceRightIndexedOrNull");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(reduceRightIndexedOrNull);
        if (lastIndex < 0) {
            return null;
        }
        long jM5706getsVKNKU = ULongArray.m5706getsVKNKU(reduceRightIndexedOrNull, lastIndex);
        for (int i = lastIndex - 1; i >= 0; i--) {
            jM5706getsVKNKU = operation.invoke(Integer.valueOf(i), ULong.m5640boximpl(ULongArray.m5706getsVKNKU(reduceRightIndexedOrNull, i)), ULong.m5640boximpl(jM5706getsVKNKU)).m5698unboximpl();
        }
        return ULong.m5640boximpl(jM5706getsVKNKU);
    }

    /* JADX INFO: renamed from: reduceRightIndexedOrNull-EOyYB1Y, reason: not valid java name */
    private static final UByte m6478reduceRightIndexedOrNullEOyYB1Y(byte[] reduceRightIndexedOrNull, Function3<? super Integer, ? super UByte, ? super UByte, UByte> operation) {
        Intrinsics.checkNotNullParameter(reduceRightIndexedOrNull, "$this$reduceRightIndexedOrNull");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(reduceRightIndexedOrNull);
        if (lastIndex < 0) {
            return null;
        }
        byte bM5548getw2LRezQ = UByteArray.m5548getw2LRezQ(reduceRightIndexedOrNull, lastIndex);
        for (int i = lastIndex - 1; i >= 0; i--) {
            bM5548getw2LRezQ = operation.invoke(Integer.valueOf(i), UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(reduceRightIndexedOrNull, i)), UByte.m5484boximpl(bM5548getw2LRezQ)).m5540unboximpl();
        }
        return UByte.m5484boximpl(bM5548getw2LRezQ);
    }

    /* JADX INFO: renamed from: reduceRightIndexedOrNull-aLgx1Fo, reason: not valid java name */
    private static final UShort m6479reduceRightIndexedOrNullaLgx1Fo(short[] reduceRightIndexedOrNull, Function3<? super Integer, ? super UShort, ? super UShort, UShort> operation) {
        Intrinsics.checkNotNullParameter(reduceRightIndexedOrNull, "$this$reduceRightIndexedOrNull");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(reduceRightIndexedOrNull);
        if (lastIndex < 0) {
            return null;
        }
        short sM5811getMh2AYeg = UShortArray.m5811getMh2AYeg(reduceRightIndexedOrNull, lastIndex);
        for (int i = lastIndex - 1; i >= 0; i--) {
            sM5811getMh2AYeg = operation.invoke(Integer.valueOf(i), UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(reduceRightIndexedOrNull, i)), UShort.m5747boximpl(sM5811getMh2AYeg)).m5803unboximpl();
        }
        return UShort.m5747boximpl(sM5811getMh2AYeg);
    }

    /* JADX INFO: renamed from: reduceRightOrNull-WyvcNBI, reason: not valid java name */
    private static final UInt m6482reduceRightOrNullWyvcNBI(int[] reduceRightOrNull, Function2<? super UInt, ? super UInt, UInt> operation) {
        Intrinsics.checkNotNullParameter(reduceRightOrNull, "$this$reduceRightOrNull");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(reduceRightOrNull);
        if (lastIndex < 0) {
            return null;
        }
        int iM5627getpVg5ArA = UIntArray.m5627getpVg5ArA(reduceRightOrNull, lastIndex);
        for (int i = lastIndex - 1; i >= 0; i--) {
            iM5627getpVg5ArA = operation.invoke(UInt.m5561boximpl(UIntArray.m5627getpVg5ArA(reduceRightOrNull, i)), UInt.m5561boximpl(iM5627getpVg5ArA)).m5619unboximpl();
        }
        return UInt.m5561boximpl(iM5627getpVg5ArA);
    }

    /* JADX INFO: renamed from: reduceRightOrNull-s8dVfGU, reason: not valid java name */
    private static final ULong m6483reduceRightOrNulls8dVfGU(long[] reduceRightOrNull, Function2<? super ULong, ? super ULong, ULong> operation) {
        Intrinsics.checkNotNullParameter(reduceRightOrNull, "$this$reduceRightOrNull");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(reduceRightOrNull);
        if (lastIndex < 0) {
            return null;
        }
        long jM5706getsVKNKU = ULongArray.m5706getsVKNKU(reduceRightOrNull, lastIndex);
        for (int i = lastIndex - 1; i >= 0; i--) {
            jM5706getsVKNKU = operation.invoke(ULong.m5640boximpl(ULongArray.m5706getsVKNKU(reduceRightOrNull, i)), ULong.m5640boximpl(jM5706getsVKNKU)).m5698unboximpl();
        }
        return ULong.m5640boximpl(jM5706getsVKNKU);
    }

    /* JADX INFO: renamed from: reduceRightOrNull-ELGow60, reason: not valid java name */
    private static final UByte m6481reduceRightOrNullELGow60(byte[] reduceRightOrNull, Function2<? super UByte, ? super UByte, UByte> operation) {
        Intrinsics.checkNotNullParameter(reduceRightOrNull, "$this$reduceRightOrNull");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(reduceRightOrNull);
        if (lastIndex < 0) {
            return null;
        }
        byte bM5548getw2LRezQ = UByteArray.m5548getw2LRezQ(reduceRightOrNull, lastIndex);
        for (int i = lastIndex - 1; i >= 0; i--) {
            bM5548getw2LRezQ = operation.invoke(UByte.m5484boximpl(UByteArray.m5548getw2LRezQ(reduceRightOrNull, i)), UByte.m5484boximpl(bM5548getw2LRezQ)).m5540unboximpl();
        }
        return UByte.m5484boximpl(bM5548getw2LRezQ);
    }

    /* JADX INFO: renamed from: reduceRightOrNull-xzaTVY8, reason: not valid java name */
    private static final UShort m6484reduceRightOrNullxzaTVY8(short[] reduceRightOrNull, Function2<? super UShort, ? super UShort, UShort> operation) {
        Intrinsics.checkNotNullParameter(reduceRightOrNull, "$this$reduceRightOrNull");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(reduceRightOrNull);
        if (lastIndex < 0) {
            return null;
        }
        short sM5811getMh2AYeg = UShortArray.m5811getMh2AYeg(reduceRightOrNull, lastIndex);
        for (int i = lastIndex - 1; i >= 0; i--) {
            sM5811getMh2AYeg = operation.invoke(UShort.m5747boximpl(UShortArray.m5811getMh2AYeg(reduceRightOrNull, i)), UShort.m5747boximpl(sM5811getMh2AYeg)).m5803unboximpl();
        }
        return UShort.m5747boximpl(sM5811getMh2AYeg);
    }
}
