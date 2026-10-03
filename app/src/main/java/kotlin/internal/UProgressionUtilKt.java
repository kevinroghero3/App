package kotlin.internal;

import kotlin.UByte$$ExternalSyntheticBackport1;
import kotlin.UByte$$ExternalSyntheticBackport2;
import kotlin.UInt;
import kotlin.ULong;

/* JADX INFO: loaded from: classes6.dex */
public final class UProgressionUtilKt {
    /* JADX INFO: renamed from: differenceModulo-WZ9TVnA, reason: not valid java name */
    private static final int m6696differenceModuloWZ9TVnA(int i, int i2, int i3) {
        int iM = UByte$$ExternalSyntheticBackport1.m(i, i3);
        int iM2 = UByte$$ExternalSyntheticBackport1.m(i2, i3);
        int iCompare = Integer.compare(iM ^ Integer.MIN_VALUE, iM2 ^ Integer.MIN_VALUE);
        int iM5567constructorimpl = UInt.m5567constructorimpl(iM - iM2);
        return iCompare >= 0 ? iM5567constructorimpl : UInt.m5567constructorimpl(iM5567constructorimpl + i3);
    }

    /* JADX INFO: renamed from: differenceModulo-sambcqE, reason: not valid java name */
    private static final long m6697differenceModulosambcqE(long j, long j2, long j3) {
        long jM = UByte$$ExternalSyntheticBackport2.m(j, j3);
        long jM2 = UByte$$ExternalSyntheticBackport2.m(j2, j3);
        int iCompare = Long.compare(jM ^ Long.MIN_VALUE, jM2 ^ Long.MIN_VALUE);
        long jM5646constructorimpl = ULong.m5646constructorimpl(jM - jM2);
        return iCompare >= 0 ? jM5646constructorimpl : ULong.m5646constructorimpl(jM5646constructorimpl + j3);
    }

    /* JADX INFO: renamed from: getProgressionLastElement-Nkh28Cs, reason: not valid java name */
    public static final int m6699getProgressionLastElementNkh28Cs(int i, int i2, int i3) {
        if (i3 > 0) {
            return Integer.compare(i ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE) >= 0 ? i2 : UInt.m5567constructorimpl(i2 - m6696differenceModuloWZ9TVnA(i2, i, UInt.m5567constructorimpl(i3)));
        }
        if (i3 < 0) {
            return Integer.compare(i ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE) <= 0 ? i2 : UInt.m5567constructorimpl(i2 + m6696differenceModuloWZ9TVnA(i, i2, UInt.m5567constructorimpl(-i3)));
        }
        throw new IllegalArgumentException("Step is zero.");
    }

    /* JADX INFO: renamed from: getProgressionLastElement-7ftBX0g, reason: not valid java name */
    public static final long m6698getProgressionLastElement7ftBX0g(long j, long j2, long j3) {
        if (j3 > 0) {
            return Long.compare(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE) >= 0 ? j2 : ULong.m5646constructorimpl(j2 - m6697differenceModulosambcqE(j2, j, ULong.m5646constructorimpl(j3)));
        }
        if (j3 < 0) {
            return Long.compare(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE) <= 0 ? j2 : ULong.m5646constructorimpl(j2 + m6697differenceModulosambcqE(j, j2, ULong.m5646constructorimpl(-j3)));
        }
        throw new IllegalArgumentException("Step is zero.");
    }
}
