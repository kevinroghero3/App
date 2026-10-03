package androidx.compose.ui.node;

/* JADX INFO: loaded from: classes4.dex */
public interface TraversableNode extends DelegatableNode {
    public static final Companion Companion = Companion.$$INSTANCE;

    Object getTraverseKey();

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        public enum TraverseDescendantsAction {
            ContinueTraversal,
            SkipSubtreeAndContinueTraversal,
            CancelTraversal
        }

        private Companion() {
        }
    }
}
