package androidx.compose.ui.layout;

import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface BeyondBoundsLayout {

    public interface BeyondBoundsScope {
        boolean getHasMoreContent();
    }

    /* JADX INFO: renamed from: layout-o7g1Pn8, reason: not valid java name */
    <T> T m2501layouto7g1Pn8(int i, @NotNull Function1<? super BeyondBoundsScope, ? extends T> function1);

    @JvmInline
    public static final class LayoutDirection {
        private final int value;
        public static final Companion Companion = new Companion(null);
        private static final int Before = m2503constructorimpl(1);
        private static final int After = m2503constructorimpl(2);
        private static final int Left = m2503constructorimpl(3);
        private static final int Right = m2503constructorimpl(4);
        private static final int Above = m2503constructorimpl(5);
        private static final int Below = m2503constructorimpl(6);

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ LayoutDirection m2502boximpl(int i) {
            return new LayoutDirection(i);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static int m2503constructorimpl(int i) {
            return i;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m2504equalsimpl(int i, Object obj) {
            return (obj instanceof LayoutDirection) && i == ((LayoutDirection) obj).m2508unboximpl();
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m2505equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m2506hashCodeimpl(int i) {
            return Integer.hashCode(i);
        }

        public boolean equals(Object obj) {
            return m2504equalsimpl(this.value, obj);
        }

        public int hashCode() {
            return m2506hashCodeimpl(this.value);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ int m2508unboximpl() {
            return this.value;
        }

        private /* synthetic */ LayoutDirection(int i) {
            this.value = i;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX INFO: renamed from: getBefore-hoxUOeE, reason: not valid java name */
            public final int m2511getBeforehoxUOeE() {
                return LayoutDirection.Before;
            }

            /* JADX INFO: renamed from: getAfter-hoxUOeE, reason: not valid java name */
            public final int m2510getAfterhoxUOeE() {
                return LayoutDirection.After;
            }

            /* JADX INFO: renamed from: getLeft-hoxUOeE, reason: not valid java name */
            public final int m2513getLefthoxUOeE() {
                return LayoutDirection.Left;
            }

            /* JADX INFO: renamed from: getRight-hoxUOeE, reason: not valid java name */
            public final int m2514getRighthoxUOeE() {
                return LayoutDirection.Right;
            }

            /* JADX INFO: renamed from: getAbove-hoxUOeE, reason: not valid java name */
            public final int m2509getAbovehoxUOeE() {
                return LayoutDirection.Above;
            }

            /* JADX INFO: renamed from: getBelow-hoxUOeE, reason: not valid java name */
            public final int m2512getBelowhoxUOeE() {
                return LayoutDirection.Below;
            }
        }

        public String toString() {
            return m2507toStringimpl(this.value);
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m2507toStringimpl(int i) {
            if (m2505equalsimpl0(i, Before)) {
                return "Before";
            }
            if (m2505equalsimpl0(i, After)) {
                return "After";
            }
            if (m2505equalsimpl0(i, Left)) {
                return "Left";
            }
            if (m2505equalsimpl0(i, Right)) {
                return "Right";
            }
            if (m2505equalsimpl0(i, Above)) {
                return "Above";
            }
            return m2505equalsimpl0(i, Below) ? "Below" : "invalid LayoutDirection";
        }
    }
}
