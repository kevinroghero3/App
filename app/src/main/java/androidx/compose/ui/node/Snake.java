package androidx.compose.ui.node;

import ch.qos.logback.core.CoreConstants;
import java.util.Arrays;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@JvmInline
final class Snake {
    private final int[] data;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Snake m2820boximpl(int[] iArr) {
        return new Snake(iArr);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int[] m2821constructorimpl(@NotNull int[] iArr) {
        return iArr;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m2822equalsimpl(int[] iArr, Object obj) {
        return (obj instanceof Snake) && Intrinsics.areEqual(iArr, ((Snake) obj).m2834unboximpl());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2823equalsimpl0(int[] iArr, int[] iArr2) {
        return Intrinsics.areEqual(iArr, iArr2);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m2831hashCodeimpl(int[] iArr) {
        return Arrays.hashCode(iArr);
    }

    public boolean equals(Object obj) {
        return m2822equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m2831hashCodeimpl(this.data);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int[] m2834unboximpl() {
        return this.data;
    }

    private /* synthetic */ Snake(int[] iArr) {
        this.data = iArr;
    }

    public final int[] getData() {
        return this.data;
    }

    /* JADX INFO: renamed from: getStartX-impl, reason: not valid java name */
    public static final int m2829getStartXimpl(int[] iArr) {
        return iArr[0];
    }

    /* JADX INFO: renamed from: getStartY-impl, reason: not valid java name */
    public static final int m2830getStartYimpl(int[] iArr) {
        return iArr[1];
    }

    /* JADX INFO: renamed from: getEndX-impl, reason: not valid java name */
    public static final int m2825getEndXimpl(int[] iArr) {
        return iArr[2];
    }

    /* JADX INFO: renamed from: getEndY-impl, reason: not valid java name */
    public static final int m2826getEndYimpl(int[] iArr) {
        return iArr[3];
    }

    /* JADX INFO: renamed from: getReverse-impl, reason: not valid java name */
    public static final boolean m2828getReverseimpl(int[] iArr) {
        return iArr[4] != 0;
    }

    /* JADX INFO: renamed from: getDiagonalSize-impl, reason: not valid java name */
    public static final int m2824getDiagonalSizeimpl(int[] iArr) {
        return Math.min(m2825getEndXimpl(iArr) - m2829getStartXimpl(iArr), m2826getEndYimpl(iArr) - m2830getStartYimpl(iArr));
    }

    /* JADX INFO: renamed from: getHasAdditionOrRemoval-impl, reason: not valid java name */
    private static final boolean m2827getHasAdditionOrRemovalimpl(int[] iArr) {
        return m2826getEndYimpl(iArr) - m2830getStartYimpl(iArr) != m2825getEndXimpl(iArr) - m2829getStartXimpl(iArr);
    }

    /* JADX INFO: renamed from: isAddition-impl, reason: not valid java name */
    private static final boolean m2832isAdditionimpl(int[] iArr) {
        return m2826getEndYimpl(iArr) - m2830getStartYimpl(iArr) > m2825getEndXimpl(iArr) - m2829getStartXimpl(iArr);
    }

    /* JADX INFO: renamed from: addDiagonalToStack-impl, reason: not valid java name */
    public static final void m2819addDiagonalToStackimpl(int[] iArr, @NotNull IntStack intStack) {
        if (m2827getHasAdditionOrRemovalimpl(iArr)) {
            if (m2828getReverseimpl(iArr)) {
                intStack.pushDiagonal(m2829getStartXimpl(iArr), m2830getStartYimpl(iArr), m2824getDiagonalSizeimpl(iArr));
                return;
            } else if (m2832isAdditionimpl(iArr)) {
                intStack.pushDiagonal(m2829getStartXimpl(iArr), m2830getStartYimpl(iArr) + 1, m2824getDiagonalSizeimpl(iArr));
                return;
            } else {
                intStack.pushDiagonal(m2829getStartXimpl(iArr) + 1, m2830getStartYimpl(iArr), m2824getDiagonalSizeimpl(iArr));
                return;
            }
        }
        intStack.pushDiagonal(m2829getStartXimpl(iArr), m2830getStartYimpl(iArr), m2825getEndXimpl(iArr) - m2829getStartXimpl(iArr));
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m2833toStringimpl(int[] iArr) {
        return "Snake(" + m2829getStartXimpl(iArr) + CoreConstants.COMMA_CHAR + m2830getStartYimpl(iArr) + CoreConstants.COMMA_CHAR + m2825getEndXimpl(iArr) + CoreConstants.COMMA_CHAR + m2826getEndYimpl(iArr) + CoreConstants.COMMA_CHAR + m2828getReverseimpl(iArr) + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public String toString() {
        return m2833toStringimpl(this.data);
    }
}
