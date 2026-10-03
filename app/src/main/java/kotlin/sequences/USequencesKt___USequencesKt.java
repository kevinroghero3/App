package kotlin.sequences;

import java.util.Iterator;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
class USequencesKt___USequencesKt {
    public static final int sumOfUInt(@NotNull Sequence<UInt> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<UInt> it2 = sequence.iterator();
        int iM5567constructorimpl = 0;
        while (it2.hasNext()) {
            iM5567constructorimpl = UInt.m5567constructorimpl(iM5567constructorimpl + it2.next().m5619unboximpl());
        }
        return iM5567constructorimpl;
    }

    public static final long sumOfULong(@NotNull Sequence<ULong> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<ULong> it2 = sequence.iterator();
        long jM5646constructorimpl = 0;
        while (it2.hasNext()) {
            jM5646constructorimpl = ULong.m5646constructorimpl(jM5646constructorimpl + it2.next().m5698unboximpl());
        }
        return jM5646constructorimpl;
    }

    public static final int sumOfUByte(@NotNull Sequence<UByte> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<UByte> it2 = sequence.iterator();
        int iM5567constructorimpl = 0;
        while (it2.hasNext()) {
            iM5567constructorimpl = UInt.m5567constructorimpl(iM5567constructorimpl + UInt.m5567constructorimpl(it2.next().m5540unboximpl() & 255));
        }
        return iM5567constructorimpl;
    }

    public static final int sumOfUShort(@NotNull Sequence<UShort> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<UShort> it2 = sequence.iterator();
        int iM5567constructorimpl = 0;
        while (it2.hasNext()) {
            iM5567constructorimpl = UInt.m5567constructorimpl(iM5567constructorimpl + UInt.m5567constructorimpl(it2.next().m5803unboximpl() & UShort.MAX_VALUE));
        }
        return iM5567constructorimpl;
    }
}
