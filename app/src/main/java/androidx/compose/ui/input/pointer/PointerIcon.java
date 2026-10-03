package androidx.compose.ui.input.pointer;

/* JADX INFO: loaded from: classes4.dex */
public interface PointerIcon {
    public static final Companion Companion = Companion.$$INSTANCE;

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final PointerIcon Default = PointerIcon_androidKt.getPointerIconDefault();
        private static final PointerIcon Crosshair = PointerIcon_androidKt.getPointerIconCrosshair();
        private static final PointerIcon Text = PointerIcon_androidKt.getPointerIconText();
        private static final PointerIcon Hand = PointerIcon_androidKt.getPointerIconHand();

        private Companion() {
        }

        public final PointerIcon getDefault() {
            return Default;
        }

        public final PointerIcon getCrosshair() {
            return Crosshair;
        }

        public final PointerIcon getText() {
            return Text;
        }

        public final PointerIcon getHand() {
            return Hand;
        }
    }
}
