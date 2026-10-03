package androidx.compose.ui.semantics;

import com.facebook.internal.AnalyticsEvents;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
@JvmInline
public final class Role {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int Button = m2939constructorimpl(0);
    private static final int Checkbox = m2939constructorimpl(1);
    private static final int Switch = m2939constructorimpl(2);
    private static final int RadioButton = m2939constructorimpl(3);
    private static final int Tab = m2939constructorimpl(4);
    private static final int Image = m2939constructorimpl(5);
    private static final int DropdownList = m2939constructorimpl(6);

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Role m2938boximpl(int i) {
        return new Role(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int m2939constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m2940equalsimpl(int i, Object obj) {
        return (obj instanceof Role) && i == ((Role) obj).m2944unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2941equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m2942hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m2940equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m2942hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m2944unboximpl() {
        return this.value;
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getButton-o7Vup1c, reason: not valid java name */
        public final int m2945getButtono7Vup1c() {
            return Role.Button;
        }

        /* JADX INFO: renamed from: getCheckbox-o7Vup1c, reason: not valid java name */
        public final int m2946getCheckboxo7Vup1c() {
            return Role.Checkbox;
        }

        /* JADX INFO: renamed from: getSwitch-o7Vup1c, reason: not valid java name */
        public final int m2950getSwitcho7Vup1c() {
            return Role.Switch;
        }

        /* JADX INFO: renamed from: getRadioButton-o7Vup1c, reason: not valid java name */
        public final int m2949getRadioButtono7Vup1c() {
            return Role.RadioButton;
        }

        /* JADX INFO: renamed from: getTab-o7Vup1c, reason: not valid java name */
        public final int m2951getTabo7Vup1c() {
            return Role.Tab;
        }

        /* JADX INFO: renamed from: getImage-o7Vup1c, reason: not valid java name */
        public final int m2948getImageo7Vup1c() {
            return Role.Image;
        }

        /* JADX INFO: renamed from: getDropdownList-o7Vup1c, reason: not valid java name */
        public final int m2947getDropdownListo7Vup1c() {
            return Role.DropdownList;
        }
    }

    private /* synthetic */ Role(int i) {
        this.value = i;
    }

    public String toString() {
        return m2943toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m2943toStringimpl(int i) {
        if (m2941equalsimpl0(i, Button)) {
            return "Button";
        }
        if (m2941equalsimpl0(i, Checkbox)) {
            return "Checkbox";
        }
        if (m2941equalsimpl0(i, Switch)) {
            return "Switch";
        }
        if (m2941equalsimpl0(i, RadioButton)) {
            return "RadioButton";
        }
        if (m2941equalsimpl0(i, Tab)) {
            return "Tab";
        }
        if (m2941equalsimpl0(i, Image)) {
            return "Image";
        }
        return m2941equalsimpl0(i, DropdownList) ? "DropdownList" : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
    }
}
