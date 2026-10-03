package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
class UCollectionsKt___UCollectionsKt {
    public static final byte[] toUByteArray(@NotNull Collection<UByte> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        byte[] bArrM5542constructorimpl = UByteArray.m5542constructorimpl(collection.size());
        Iterator<UByte> it2 = collection.iterator();
        int i = 0;
        while (it2.hasNext()) {
            UByteArray.m5553setVurrAj0(bArrM5542constructorimpl, i, it2.next().m5540unboximpl());
            i++;
        }
        return bArrM5542constructorimpl;
    }

    public static final int[] toUIntArray(@NotNull Collection<UInt> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        int[] iArrM5621constructorimpl = UIntArray.m5621constructorimpl(collection.size());
        Iterator<UInt> it2 = collection.iterator();
        int i = 0;
        while (it2.hasNext()) {
            UIntArray.m5632setVXSXFK8(iArrM5621constructorimpl, i, it2.next().m5619unboximpl());
            i++;
        }
        return iArrM5621constructorimpl;
    }

    public static final long[] toULongArray(@NotNull Collection<ULong> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        long[] jArrM5700constructorimpl = ULongArray.m5700constructorimpl(collection.size());
        Iterator<ULong> it2 = collection.iterator();
        int i = 0;
        while (it2.hasNext()) {
            ULongArray.m5711setk8EXiF4(jArrM5700constructorimpl, i, it2.next().m5698unboximpl());
            i++;
        }
        return jArrM5700constructorimpl;
    }

    public static final short[] toUShortArray(@NotNull Collection<UShort> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        short[] sArrM5805constructorimpl = UShortArray.m5805constructorimpl(collection.size());
        Iterator<UShort> it2 = collection.iterator();
        int i = 0;
        while (it2.hasNext()) {
            UShortArray.m5816set01HTLdE(sArrM5805constructorimpl, i, it2.next().m5803unboximpl());
            i++;
        }
        return sArrM5805constructorimpl;
    }

    public static final int sumOfUInt(@NotNull Iterable<UInt> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<UInt> it2 = iterable.iterator();
        int iM5567constructorimpl = 0;
        while (it2.hasNext()) {
            iM5567constructorimpl = UInt.m5567constructorimpl(iM5567constructorimpl + it2.next().m5619unboximpl());
        }
        return iM5567constructorimpl;
    }

    public static final long sumOfULong(@NotNull Iterable<ULong> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<ULong> it2 = iterable.iterator();
        long jM5646constructorimpl = 0;
        while (it2.hasNext()) {
            jM5646constructorimpl = ULong.m5646constructorimpl(jM5646constructorimpl + it2.next().m5698unboximpl());
        }
        return jM5646constructorimpl;
    }

    public static final int sumOfUByte(@NotNull Iterable<UByte> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<UByte> it2 = iterable.iterator();
        int iM5567constructorimpl = 0;
        while (it2.hasNext()) {
            iM5567constructorimpl = UInt.m5567constructorimpl(iM5567constructorimpl + UInt.m5567constructorimpl(it2.next().m5540unboximpl() & 255));
        }
        return iM5567constructorimpl;
    }

    public static final int sumOfUShort(@NotNull Iterable<UShort> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<UShort> it2 = iterable.iterator();
        int iM5567constructorimpl = 0;
        while (it2.hasNext()) {
            iM5567constructorimpl = UInt.m5567constructorimpl(iM5567constructorimpl + UInt.m5567constructorimpl(it2.next().m5803unboximpl() & UShort.MAX_VALUE));
        }
        return iM5567constructorimpl;
    }
}
