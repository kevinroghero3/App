package androidx.compose.ui.graphics;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.internal.AnalyticsEvents;
import com.swmansion.rnscreens.Screen;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
@JvmInline
public final class BlendMode {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int Clear = m1078constructorimpl(0);
    private static final int Src = m1078constructorimpl(1);
    private static final int Dst = m1078constructorimpl(2);
    private static final int SrcOver = m1078constructorimpl(3);
    private static final int DstOver = m1078constructorimpl(4);
    private static final int SrcIn = m1078constructorimpl(5);
    private static final int DstIn = m1078constructorimpl(6);
    private static final int SrcOut = m1078constructorimpl(7);
    private static final int DstOut = m1078constructorimpl(8);
    private static final int SrcAtop = m1078constructorimpl(9);
    private static final int DstAtop = m1078constructorimpl(10);
    private static final int Xor = m1078constructorimpl(11);
    private static final int Plus = m1078constructorimpl(12);
    private static final int Modulate = m1078constructorimpl(13);
    private static final int Screen = m1078constructorimpl(14);
    private static final int Overlay = m1078constructorimpl(15);
    private static final int Darken = m1078constructorimpl(16);
    private static final int Lighten = m1078constructorimpl(17);
    private static final int ColorDodge = m1078constructorimpl(18);
    private static final int ColorBurn = m1078constructorimpl(19);
    private static final int Hardlight = m1078constructorimpl(20);
    private static final int Softlight = m1078constructorimpl(21);
    private static final int Difference = m1078constructorimpl(22);
    private static final int Exclusion = m1078constructorimpl(23);
    private static final int Multiply = m1078constructorimpl(24);
    private static final int Hue = m1078constructorimpl(25);
    private static final int Saturation = m1078constructorimpl(26);
    private static final int Color = m1078constructorimpl(27);
    private static final int Luminosity = m1078constructorimpl(28);

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ BlendMode m1077boximpl(int i) {
        return new BlendMode(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m1078constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m1079equalsimpl(int i, Object obj) {
        return (obj instanceof BlendMode) && i == ((BlendMode) obj).m1083unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1080equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1081hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m1079equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m1081hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m1083unboximpl() {
        return this.value;
    }

    private /* synthetic */ BlendMode(int i) {
        this.value = i;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getClear-0nO6VwU, reason: not valid java name */
        public final int m1084getClear0nO6VwU() {
            return BlendMode.Clear;
        }

        /* JADX INFO: renamed from: getSrc-0nO6VwU, reason: not valid java name */
        public final int m1107getSrc0nO6VwU() {
            return BlendMode.Src;
        }

        /* JADX INFO: renamed from: getDst-0nO6VwU, reason: not valid java name */
        public final int m1090getDst0nO6VwU() {
            return BlendMode.Dst;
        }

        /* JADX INFO: renamed from: getSrcOver-0nO6VwU, reason: not valid java name */
        public final int m1111getSrcOver0nO6VwU() {
            return BlendMode.SrcOver;
        }

        /* JADX INFO: renamed from: getDstOver-0nO6VwU, reason: not valid java name */
        public final int m1094getDstOver0nO6VwU() {
            return BlendMode.DstOver;
        }

        /* JADX INFO: renamed from: getSrcIn-0nO6VwU, reason: not valid java name */
        public final int m1109getSrcIn0nO6VwU() {
            return BlendMode.SrcIn;
        }

        /* JADX INFO: renamed from: getDstIn-0nO6VwU, reason: not valid java name */
        public final int m1092getDstIn0nO6VwU() {
            return BlendMode.DstIn;
        }

        /* JADX INFO: renamed from: getSrcOut-0nO6VwU, reason: not valid java name */
        public final int m1110getSrcOut0nO6VwU() {
            return BlendMode.SrcOut;
        }

        /* JADX INFO: renamed from: getDstOut-0nO6VwU, reason: not valid java name */
        public final int m1093getDstOut0nO6VwU() {
            return BlendMode.DstOut;
        }

        /* JADX INFO: renamed from: getSrcAtop-0nO6VwU, reason: not valid java name */
        public final int m1108getSrcAtop0nO6VwU() {
            return BlendMode.SrcAtop;
        }

        /* JADX INFO: renamed from: getDstAtop-0nO6VwU, reason: not valid java name */
        public final int m1091getDstAtop0nO6VwU() {
            return BlendMode.DstAtop;
        }

        /* JADX INFO: renamed from: getXor-0nO6VwU, reason: not valid java name */
        public final int m1112getXor0nO6VwU() {
            return BlendMode.Xor;
        }

        /* JADX INFO: renamed from: getPlus-0nO6VwU, reason: not valid java name */
        public final int m1103getPlus0nO6VwU() {
            return BlendMode.Plus;
        }

        /* JADX INFO: renamed from: getModulate-0nO6VwU, reason: not valid java name */
        public final int m1100getModulate0nO6VwU() {
            return BlendMode.Modulate;
        }

        /* JADX INFO: renamed from: getScreen-0nO6VwU, reason: not valid java name */
        public final int m1105getScreen0nO6VwU() {
            return BlendMode.Screen;
        }

        /* JADX INFO: renamed from: getOverlay-0nO6VwU, reason: not valid java name */
        public final int m1102getOverlay0nO6VwU() {
            return BlendMode.Overlay;
        }

        /* JADX INFO: renamed from: getDarken-0nO6VwU, reason: not valid java name */
        public final int m1088getDarken0nO6VwU() {
            return BlendMode.Darken;
        }

        /* JADX INFO: renamed from: getLighten-0nO6VwU, reason: not valid java name */
        public final int m1098getLighten0nO6VwU() {
            return BlendMode.Lighten;
        }

        /* JADX INFO: renamed from: getColorDodge-0nO6VwU, reason: not valid java name */
        public final int m1087getColorDodge0nO6VwU() {
            return BlendMode.ColorDodge;
        }

        /* JADX INFO: renamed from: getColorBurn-0nO6VwU, reason: not valid java name */
        public final int m1086getColorBurn0nO6VwU() {
            return BlendMode.ColorBurn;
        }

        /* JADX INFO: renamed from: getHardlight-0nO6VwU, reason: not valid java name */
        public final int m1096getHardlight0nO6VwU() {
            return BlendMode.Hardlight;
        }

        /* JADX INFO: renamed from: getSoftlight-0nO6VwU, reason: not valid java name */
        public final int m1106getSoftlight0nO6VwU() {
            return BlendMode.Softlight;
        }

        /* JADX INFO: renamed from: getDifference-0nO6VwU, reason: not valid java name */
        public final int m1089getDifference0nO6VwU() {
            return BlendMode.Difference;
        }

        /* JADX INFO: renamed from: getExclusion-0nO6VwU, reason: not valid java name */
        public final int m1095getExclusion0nO6VwU() {
            return BlendMode.Exclusion;
        }

        /* JADX INFO: renamed from: getMultiply-0nO6VwU, reason: not valid java name */
        public final int m1101getMultiply0nO6VwU() {
            return BlendMode.Multiply;
        }

        /* JADX INFO: renamed from: getHue-0nO6VwU, reason: not valid java name */
        public final int m1097getHue0nO6VwU() {
            return BlendMode.Hue;
        }

        /* JADX INFO: renamed from: getSaturation-0nO6VwU, reason: not valid java name */
        public final int m1104getSaturation0nO6VwU() {
            return BlendMode.Saturation;
        }

        /* JADX INFO: renamed from: getColor-0nO6VwU, reason: not valid java name */
        public final int m1085getColor0nO6VwU() {
            return BlendMode.Color;
        }

        /* JADX INFO: renamed from: getLuminosity-0nO6VwU, reason: not valid java name */
        public final int m1099getLuminosity0nO6VwU() {
            return BlendMode.Luminosity;
        }
    }

    public String toString() {
        return m1082toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1082toStringimpl(int i) {
        if (m1080equalsimpl0(i, Clear)) {
            return "Clear";
        }
        if (m1080equalsimpl0(i, Src)) {
            return "Src";
        }
        if (m1080equalsimpl0(i, Dst)) {
            return "Dst";
        }
        if (m1080equalsimpl0(i, SrcOver)) {
            return "SrcOver";
        }
        if (m1080equalsimpl0(i, DstOver)) {
            return "DstOver";
        }
        if (m1080equalsimpl0(i, SrcIn)) {
            return "SrcIn";
        }
        if (m1080equalsimpl0(i, DstIn)) {
            return "DstIn";
        }
        if (m1080equalsimpl0(i, SrcOut)) {
            return "SrcOut";
        }
        if (m1080equalsimpl0(i, DstOut)) {
            return "DstOut";
        }
        if (m1080equalsimpl0(i, SrcAtop)) {
            return "SrcAtop";
        }
        if (m1080equalsimpl0(i, DstAtop)) {
            return "DstAtop";
        }
        if (m1080equalsimpl0(i, Xor)) {
            return "Xor";
        }
        if (m1080equalsimpl0(i, Plus)) {
            return "Plus";
        }
        if (m1080equalsimpl0(i, Modulate)) {
            return "Modulate";
        }
        if (m1080equalsimpl0(i, Screen)) {
            return Screen.TAG;
        }
        if (m1080equalsimpl0(i, Overlay)) {
            return "Overlay";
        }
        if (m1080equalsimpl0(i, Darken)) {
            return "Darken";
        }
        if (m1080equalsimpl0(i, Lighten)) {
            return "Lighten";
        }
        if (m1080equalsimpl0(i, ColorDodge)) {
            return "ColorDodge";
        }
        if (m1080equalsimpl0(i, ColorBurn)) {
            return "ColorBurn";
        }
        if (m1080equalsimpl0(i, Hardlight)) {
            return "HardLight";
        }
        if (m1080equalsimpl0(i, Softlight)) {
            return "Softlight";
        }
        if (m1080equalsimpl0(i, Difference)) {
            return "Difference";
        }
        if (m1080equalsimpl0(i, Exclusion)) {
            return "Exclusion";
        }
        if (m1080equalsimpl0(i, Multiply)) {
            return "Multiply";
        }
        if (m1080equalsimpl0(i, Hue)) {
            return "Hue";
        }
        if (m1080equalsimpl0(i, Saturation)) {
            return ExifInterface.TAG_SATURATION;
        }
        if (m1080equalsimpl0(i, Color)) {
            return "Color";
        }
        return m1080equalsimpl0(i, Luminosity) ? "Luminosity" : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
    }
}
