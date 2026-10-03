package androidx.compose.ui.autofill;

import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
@JvmInline
public final class ContentDataType {
    private final int dataType;
    public static final Companion Companion = new Companion(null);
    private static final int Text = m787constructorimpl(1);
    private static final int List = m787constructorimpl(3);
    private static final int Date = m787constructorimpl(4);
    private static final int Toggle = m787constructorimpl(2);
    private static final int None = m787constructorimpl(0);

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ContentDataType m786boximpl(int i) {
        return new ContentDataType(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m787constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m788equalsimpl(int i, Object obj) {
        return (obj instanceof ContentDataType) && i == ((ContentDataType) obj).m792unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m789equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m790hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m791toStringimpl(int i) {
        return "ContentDataType(dataType=" + i + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public boolean equals(Object obj) {
        return m788equalsimpl(this.dataType, obj);
    }

    public int hashCode() {
        return m790hashCodeimpl(this.dataType);
    }

    public String toString() {
        return m791toStringimpl(this.dataType);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m792unboximpl() {
        return this.dataType;
    }

    private /* synthetic */ ContentDataType(int i) {
        this.dataType = i;
    }

    public final int getDataType() {
        return this.dataType;
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getText-A48pgw8, reason: not valid java name */
        public final int m797getTextA48pgw8() {
            return ContentDataType.Text;
        }

        /* JADX INFO: renamed from: getList-A48pgw8, reason: not valid java name */
        public final int m795getListA48pgw8() {
            return ContentDataType.List;
        }

        /* JADX INFO: renamed from: getDate-A48pgw8, reason: not valid java name */
        public final int m794getDateA48pgw8() {
            return ContentDataType.Date;
        }

        /* JADX INFO: renamed from: getToggle-A48pgw8, reason: not valid java name */
        public final int m798getToggleA48pgw8() {
            return ContentDataType.Toggle;
        }

        /* JADX INFO: renamed from: getNone-A48pgw8, reason: not valid java name */
        public final int m796getNoneA48pgw8() {
            return ContentDataType.None;
        }

        /* JADX INFO: renamed from: from-LGGHU18$ui_release, reason: not valid java name */
        public final int m793fromLGGHU18$ui_release(int i) {
            if (i == 0) {
                return m796getNoneA48pgw8();
            }
            if (i == 1) {
                return m797getTextA48pgw8();
            }
            if (i == 2) {
                return m798getToggleA48pgw8();
            }
            if (i == 3) {
                return m795getListA48pgw8();
            }
            if (i == 4) {
                return m794getDateA48pgw8();
            }
            throw new IllegalArgumentException("Invalid autofill type value: " + i);
        }
    }
}
