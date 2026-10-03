package androidx.compose.ui.unit;

import androidx.compose.ui.util.MathHelpersKt;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class TextUnitKt {
    private static final long UNIT_MASK = 1095216660480L;
    private static final long UNIT_TYPE_EM = 8589934592L;
    private static final long UNIT_TYPE_SP = 4294967296L;
    private static final long UNIT_TYPE_UNSPECIFIED = 0;

    public static /* synthetic */ void getEm$annotations(double d) {
    }

    public static /* synthetic */ void getEm$annotations(float f) {
    }

    public static /* synthetic */ void getEm$annotations(int i) {
    }

    public static /* synthetic */ void getSp$annotations(double d) {
    }

    public static /* synthetic */ void getSp$annotations(float f) {
    }

    public static /* synthetic */ void getSp$annotations(int i) {
    }

    /* JADX INFO: renamed from: isSpecified--R2X_6o$annotations, reason: not valid java name */
    public static /* synthetic */ void m3860isSpecifiedR2X_6o$annotations(long j) {
    }

    /* JADX INFO: renamed from: isUnspecified--R2X_6o$annotations, reason: not valid java name */
    public static /* synthetic */ void m3862isUnspecifiedR2X_6o$annotations(long j) {
    }

    /* JADX INFO: renamed from: TextUnit-anM5pPY, reason: not valid java name */
    public static final long m3855TextUnitanM5pPY(float f, long j) {
        return pack(j, f);
    }

    /* JADX INFO: renamed from: isSpecified--R2X_6o, reason: not valid java name */
    public static final boolean m3859isSpecifiedR2X_6o(long j) {
        return !m3861isUnspecifiedR2X_6o(j);
    }

    /* JADX INFO: renamed from: isUnspecified--R2X_6o, reason: not valid java name */
    public static final boolean m3861isUnspecifiedR2X_6o(long j) {
        return TextUnit.m3841getRawTypeimpl(j) == 0;
    }

    public static final long getSp(float f) {
        return pack(UNIT_TYPE_SP, f);
    }

    public static final long getEm(float f) {
        return pack(UNIT_TYPE_EM, f);
    }

    public static final long getSp(double d) {
        return pack(UNIT_TYPE_SP, (float) d);
    }

    public static final long getEm(double d) {
        return pack(UNIT_TYPE_EM, (float) d);
    }

    public static final long getSp(int i) {
        return pack(UNIT_TYPE_SP, i);
    }

    public static final long getEm(int i) {
        return pack(UNIT_TYPE_EM, i);
    }

    /* JADX INFO: renamed from: times-mpE4wyQ, reason: not valid java name */
    public static final long m3866timesmpE4wyQ(float f, long j) {
        m3856checkArithmeticR2X_6o(j);
        return pack(TextUnit.m3841getRawTypeimpl(j), f * TextUnit.m3843getValueimpl(j));
    }

    /* JADX INFO: renamed from: times-mpE4wyQ, reason: not valid java name */
    public static final long m3865timesmpE4wyQ(double d, long j) {
        m3856checkArithmeticR2X_6o(j);
        return pack(TextUnit.m3841getRawTypeimpl(j), ((float) d) * TextUnit.m3843getValueimpl(j));
    }

    /* JADX INFO: renamed from: times-mpE4wyQ, reason: not valid java name */
    public static final long m3867timesmpE4wyQ(int i, long j) {
        m3856checkArithmeticR2X_6o(j);
        return pack(TextUnit.m3841getRawTypeimpl(j), i * TextUnit.m3843getValueimpl(j));
    }

    public static final long pack(long j, float f) {
        return TextUnit.m3835constructorimpl(j | (((long) Float.floatToIntBits(f)) & 4294967295L));
    }

    /* JADX INFO: renamed from: checkArithmetic--R2X_6o, reason: not valid java name */
    public static final void m3856checkArithmeticR2X_6o(long j) {
        if (m3861isUnspecifiedR2X_6o(j)) {
            throw new IllegalArgumentException("Cannot perform operation for Unspecified type.");
        }
    }

    /* JADX INFO: renamed from: checkArithmetic-NB67dxo, reason: not valid java name */
    public static final void m3857checkArithmeticNB67dxo(long j, long j2) {
        if (m3861isUnspecifiedR2X_6o(j) || m3861isUnspecifiedR2X_6o(j2)) {
            throw new IllegalArgumentException("Cannot perform operation for Unspecified type.");
        }
        if (TextUnitType.m3871equalsimpl0(TextUnit.m3842getTypeUIouoOA(j), TextUnit.m3842getTypeUIouoOA(j2))) {
            return;
        }
        throw new IllegalArgumentException(("Cannot perform operation for " + ((Object) TextUnitType.m3873toStringimpl(TextUnit.m3842getTypeUIouoOA(j))) + " and " + ((Object) TextUnitType.m3873toStringimpl(TextUnit.m3842getTypeUIouoOA(j2)))).toString());
    }

    /* JADX INFO: renamed from: checkArithmetic-vU-0ePk, reason: not valid java name */
    public static final void m3858checkArithmeticvU0ePk(long j, long j2, long j3) {
        if (m3861isUnspecifiedR2X_6o(j) || m3861isUnspecifiedR2X_6o(j2) || m3861isUnspecifiedR2X_6o(j3)) {
            throw new IllegalArgumentException("Cannot perform operation for Unspecified type.");
        }
        if (TextUnitType.m3871equalsimpl0(TextUnit.m3842getTypeUIouoOA(j), TextUnit.m3842getTypeUIouoOA(j2)) && TextUnitType.m3871equalsimpl0(TextUnit.m3842getTypeUIouoOA(j2), TextUnit.m3842getTypeUIouoOA(j3))) {
            return;
        }
        throw new IllegalArgumentException(("Cannot perform operation for " + ((Object) TextUnitType.m3873toStringimpl(TextUnit.m3842getTypeUIouoOA(j))) + " and " + ((Object) TextUnitType.m3873toStringimpl(TextUnit.m3842getTypeUIouoOA(j2)))).toString());
    }

    /* JADX INFO: renamed from: lerp-C3pnCVY, reason: not valid java name */
    public static final long m3863lerpC3pnCVY(long j, long j2, float f) {
        m3857checkArithmeticNB67dxo(j, j2);
        return pack(TextUnit.m3841getRawTypeimpl(j), MathHelpersKt.lerp(TextUnit.m3843getValueimpl(j), TextUnit.m3843getValueimpl(j2), f));
    }

    /* JADX INFO: renamed from: takeOrElse-eAf_CNQ, reason: not valid java name */
    public static final long m3864takeOrElseeAf_CNQ(long j, @NotNull Function0<TextUnit> function0) {
        return !m3861isUnspecifiedR2X_6o(j) ? j : function0.invoke().m3852unboximpl();
    }
}
