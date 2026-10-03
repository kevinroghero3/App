package androidx.compose.ui.text.style;

import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
@JvmInline
public final class TextAlign {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int Left = m3533constructorimpl(1);
    private static final int Right = m3533constructorimpl(2);
    private static final int Center = m3533constructorimpl(3);
    private static final int Justify = m3533constructorimpl(4);
    private static final int Start = m3533constructorimpl(5);
    private static final int End = m3533constructorimpl(6);
    private static final int Unspecified = m3533constructorimpl(Integer.MIN_VALUE);

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TextAlign m3532boximpl(int i) {
        return new TextAlign(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m3533constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m3534equalsimpl(int i, Object obj) {
        return (obj instanceof TextAlign) && i == ((TextAlign) obj).m3538unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3535equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m3536hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m3534equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m3536hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m3538unboximpl() {
        return this.value;
    }

    private /* synthetic */ TextAlign(int i) {
        this.value = i;
    }

    public String toString() {
        return m3537toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m3537toStringimpl(int i) {
        if (m3535equalsimpl0(i, Left)) {
            return "Left";
        }
        if (m3535equalsimpl0(i, Right)) {
            return "Right";
        }
        if (m3535equalsimpl0(i, Center)) {
            return "Center";
        }
        if (m3535equalsimpl0(i, Justify)) {
            return "Justify";
        }
        if (m3535equalsimpl0(i, Start)) {
            return "Start";
        }
        if (m3535equalsimpl0(i, End)) {
            return "End";
        }
        return m3535equalsimpl0(i, Unspecified) ? "Unspecified" : "Invalid";
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getLeft-e0LSkKk, reason: not valid java name */
        public final int m3542getLefte0LSkKk() {
            return TextAlign.Left;
        }

        /* JADX INFO: renamed from: getRight-e0LSkKk, reason: not valid java name */
        public final int m3543getRighte0LSkKk() {
            return TextAlign.Right;
        }

        /* JADX INFO: renamed from: getCenter-e0LSkKk, reason: not valid java name */
        public final int m3539getCentere0LSkKk() {
            return TextAlign.Center;
        }

        /* JADX INFO: renamed from: getJustify-e0LSkKk, reason: not valid java name */
        public final int m3541getJustifye0LSkKk() {
            return TextAlign.Justify;
        }

        /* JADX INFO: renamed from: getStart-e0LSkKk, reason: not valid java name */
        public final int m3544getStarte0LSkKk() {
            return TextAlign.Start;
        }

        /* JADX INFO: renamed from: getEnd-e0LSkKk, reason: not valid java name */
        public final int m3540getEnde0LSkKk() {
            return TextAlign.End;
        }

        public final List<TextAlign> values() {
            return CollectionsKt__CollectionsKt.listOf((Object[]) new TextAlign[]{TextAlign.m3532boximpl(m3542getLefte0LSkKk()), TextAlign.m3532boximpl(m3543getRighte0LSkKk()), TextAlign.m3532boximpl(m3539getCentere0LSkKk()), TextAlign.m3532boximpl(m3541getJustifye0LSkKk()), TextAlign.m3532boximpl(m3544getStarte0LSkKk()), TextAlign.m3532boximpl(m3540getEnde0LSkKk())});
        }

        /* JADX INFO: renamed from: getUnspecified-e0LSkKk, reason: not valid java name */
        public final int m3545getUnspecifiede0LSkKk() {
            return TextAlign.Unspecified;
        }
    }
}
