package androidx.compose.ui.text.android.selection;

/* JADX INFO: loaded from: classes4.dex */
public interface SegmentFinder {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final int DONE = -1;

    int nextEndBoundary(int i);

    int nextStartBoundary(int i);

    int previousEndBoundary(int i);

    int previousStartBoundary(int i);

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int DONE = -1;

        private Companion() {
        }
    }
}
