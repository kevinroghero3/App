package androidx.compose.ui.input.pointer;

import androidx.collection.LongSparseArray;
import androidx.collection.MutableObjectList;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.layout.LayoutCoordinates;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public class NodeParent {
    public static final int $stable = MutableVector.$stable;
    private final MutableVector<Node> children = new MutableVector<>(new Node[16], 0);

    public final MutableVector<Node> getChildren() {
        return this.children;
    }

    public boolean buildCache(@NotNull LongSparseArray<PointerInputChange> longSparseArray, @NotNull LayoutCoordinates layoutCoordinates, @NotNull InternalPointerEvent internalPointerEvent, boolean z) {
        MutableVector<Node> mutableVector = this.children;
        int size = mutableVector.getSize();
        if (size <= 0) {
            return false;
        }
        Node[] content = mutableVector.getContent();
        int i = 0;
        boolean z2 = false;
        do {
            z2 = content[i].buildCache(longSparseArray, layoutCoordinates, internalPointerEvent, z) || z2;
            i++;
        } while (i < size);
        return z2;
    }

    public boolean dispatchMainEventPass(@NotNull LongSparseArray<PointerInputChange> longSparseArray, @NotNull LayoutCoordinates layoutCoordinates, @NotNull InternalPointerEvent internalPointerEvent, boolean z) {
        MutableVector<Node> mutableVector = this.children;
        int size = mutableVector.getSize();
        if (size <= 0) {
            return false;
        }
        Node[] content = mutableVector.getContent();
        int i = 0;
        boolean z2 = false;
        do {
            z2 = content[i].dispatchMainEventPass(longSparseArray, layoutCoordinates, internalPointerEvent, z) || z2;
            i++;
        } while (i < size);
        return z2;
    }

    public boolean dispatchFinalEventPass(@NotNull InternalPointerEvent internalPointerEvent) {
        MutableVector<Node> mutableVector = this.children;
        int size = mutableVector.getSize();
        boolean z = false;
        if (size > 0) {
            Node[] content = mutableVector.getContent();
            int i = 0;
            boolean z2 = false;
            do {
                z2 = content[i].dispatchFinalEventPass(internalPointerEvent) || z2;
                i++;
            } while (i < size);
            z = z2;
        }
        cleanUpHits(internalPointerEvent);
        return z;
    }

    public void dispatchCancel() {
        MutableVector<Node> mutableVector = this.children;
        int size = mutableVector.getSize();
        if (size > 0) {
            Node[] content = mutableVector.getContent();
            int i = 0;
            do {
                content[i].dispatchCancel();
                i++;
            } while (i < size);
        }
    }

    public final void clear() {
        this.children.clear();
    }

    public void removeInvalidPointerIdsAndChanges(long j, @NotNull MutableObjectList<Node> mutableObjectList) {
        MutableVector<Node> mutableVector = this.children;
        int size = mutableVector.getSize();
        if (size > 0) {
            Node[] content = mutableVector.getContent();
            int i = 0;
            do {
                content[i].removeInvalidPointerIdsAndChanges(j, mutableObjectList);
                i++;
            } while (i < size);
        }
    }

    public final void removeDetachedPointerInputModifierNodes() {
        int i = 0;
        while (i < this.children.getSize()) {
            Node node = this.children.getContent()[i];
            if (!node.getModifierNode().isAttached()) {
                node.dispatchCancel();
                this.children.removeAt(i);
            } else {
                i++;
                node.removeDetachedPointerInputModifierNodes();
            }
        }
    }

    public void cleanUpHits(@NotNull InternalPointerEvent internalPointerEvent) {
        int size = this.children.getSize();
        while (true) {
            size--;
            if (-1 >= size) {
                return;
            }
            if (this.children.getContent()[size].getPointerIds().isEmpty()) {
                this.children.removeAt(size);
            }
        }
    }
}
