package androidx.compose.ui.input.pointer;

import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.JvmInline;

/* JADX INFO: loaded from: classes4.dex */
@JvmInline
public final class PointerButtons {
    private final int packedValue;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ PointerButtons m2312boximpl(int i) {
        return new PointerButtons(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m2313constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m2314equalsimpl(int i, Object obj) {
        return (obj instanceof PointerButtons) && i == ((PointerButtons) obj).m2318unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2315equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m2316hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m2317toStringimpl(int i) {
        return "PointerButtons(packedValue=" + i + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public boolean equals(Object obj) {
        return m2314equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m2316hashCodeimpl(this.packedValue);
    }

    public String toString() {
        return m2317toStringimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m2318unboximpl() {
        return this.packedValue;
    }

    private /* synthetic */ PointerButtons(int i) {
        this.packedValue = i;
    }
}
