package androidx.compose.ui.layout;

/* JADX INFO: loaded from: classes4.dex */
public interface PinnableContainer {

    public interface PinnedHandle {
        void release();
    }

    PinnedHandle pin();
}
