package androidx.compose.ui.input.pointer;

import androidx.collection.MutableLongObjectMap;
import androidx.collection.MutableObjectList;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class HitPathTracker {
    public static final int $stable = 8;
    private final LayoutCoordinates rootCoordinates;
    private final NodeParent root = new NodeParent();
    private final MutableLongObjectMap<MutableObjectList<Node>> hitPointerIdsAndNodes = new MutableLongObjectMap<>(10);

    public HitPathTracker(@NotNull LayoutCoordinates layoutCoordinates) {
        this.rootCoordinates = layoutCoordinates;
    }

    public final NodeParent getRoot$ui_release() {
        return this.root;
    }

    /* JADX INFO: renamed from: addHitPath-QJqDSyo$default, reason: not valid java name */
    public static /* synthetic */ void m2307addHitPathQJqDSyo$default(HitPathTracker hitPathTracker, long j, List list, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        hitPathTracker.m2308addHitPathQJqDSyo(j, list, z);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0080  */
    /* JADX WARN: Code duplicated, block: B:25:0x008a  */
    /* JADX INFO: renamed from: addHitPath-QJqDSyo, reason: not valid java name */
    public final void m2308addHitPathQJqDSyo(long j, @NotNull List<? extends Modifier.Node> list, boolean z) {
        MutableLongObjectMap<MutableObjectList<Node>> mutableLongObjectMap;
        MutableObjectList<Node> mutableObjectList;
        Node node;
        NodeParent nodeParent = this.root;
        this.hitPointerIdsAndNodes.clear();
        int size = list.size();
        boolean z2 = true;
        for (int i = 0; i < size; i++) {
            Modifier.Node node2 = list.get(i);
            if (z2) {
                MutableVector<Node> children = nodeParent.getChildren();
                int size2 = children.getSize();
                if (size2 <= 0) {
                    node = null;
                    break;
                }
                Node[] content = children.getContent();
                int i2 = 0;
                while (true) {
                    node = content[i2];
                    if (Intrinsics.areEqual(node.getModifierNode(), node2)) {
                        break;
                    }
                    i2++;
                    if (i2 >= size2) {
                        node = null;
                        break;
                    }
                }
                Node node3 = node;
                if (node3 != null) {
                    node3.markIsIn();
                    node3.getPointerIds().m2488add0FcD4WY(j);
                    MutableLongObjectMap<MutableObjectList<Node>> mutableLongObjectMap2 = this.hitPointerIdsAndNodes;
                    MutableObjectList<Node> mutableObjectList2 = mutableLongObjectMap2.get(j);
                    if (mutableObjectList2 == null) {
                        mutableObjectList2 = new MutableObjectList<>(0, 1, null);
                        mutableLongObjectMap2.set(j, mutableObjectList2);
                    }
                    mutableObjectList2.add(node3);
                    nodeParent = node3;
                } else {
                    z2 = false;
                    Node node4 = new Node(node2);
                    node4.getPointerIds().m2488add0FcD4WY(j);
                    mutableLongObjectMap = this.hitPointerIdsAndNodes;
                    mutableObjectList = mutableLongObjectMap.get(j);
                    if (mutableObjectList == null) {
                        mutableObjectList = new MutableObjectList<>(0, 1, null);
                        mutableLongObjectMap.set(j, mutableObjectList);
                    }
                    mutableObjectList.add(node4);
                    nodeParent.getChildren().add(node4);
                    nodeParent = node4;
                }
            } else {
                Node node5 = new Node(node2);
                node5.getPointerIds().m2488add0FcD4WY(j);
                mutableLongObjectMap = this.hitPointerIdsAndNodes;
                mutableObjectList = mutableLongObjectMap.get(j);
                if (mutableObjectList == null) {
                    mutableObjectList = new MutableObjectList<>(0, 1, null);
                    mutableLongObjectMap.set(j, mutableObjectList);
                }
                mutableObjectList.add(node5);
                nodeParent.getChildren().add(node5);
                nodeParent = node5;
            }
        }
        if (!z) {
            return;
        }
        MutableLongObjectMap<MutableObjectList<Node>> mutableLongObjectMap3 = this.hitPointerIdsAndNodes;
        long[] jArr = mutableLongObjectMap3.keys;
        Object[] objArr = mutableLongObjectMap3.values;
        long[] jArr2 = mutableLongObjectMap3.metadata;
        int length = jArr2.length - 2;
        if (length < 0) {
            return;
        }
        int i3 = 0;
        while (true) {
            long j2 = jArr2[i3];
            if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i4 = 8 - ((~(i3 - length)) >>> 31);
                for (int i5 = 0; i5 < i4; i5++) {
                    if ((255 & j2) < 128) {
                        int i6 = (i3 << 3) + i5;
                        removeInvalidPointerIdsAndChanges(jArr[i6], (MutableObjectList) objArr[i6]);
                    }
                    j2 >>= 8;
                }
                if (i4 != 8) {
                    return;
                }
            }
            if (i3 == length) {
                return;
            } else {
                i3++;
            }
        }
    }

    private final void removeInvalidPointerIdsAndChanges(long j, MutableObjectList<Node> mutableObjectList) {
        this.root.removeInvalidPointerIdsAndChanges(j, mutableObjectList);
    }

    public static /* synthetic */ boolean dispatchChanges$default(HitPathTracker hitPathTracker, InternalPointerEvent internalPointerEvent, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return hitPathTracker.dispatchChanges(internalPointerEvent, z);
    }

    public final boolean dispatchChanges(@NotNull InternalPointerEvent internalPointerEvent, boolean z) {
        if (this.root.buildCache(internalPointerEvent.getChanges(), this.rootCoordinates, internalPointerEvent, z)) {
            return this.root.dispatchFinalEventPass(internalPointerEvent) || this.root.dispatchMainEventPass(internalPointerEvent.getChanges(), this.rootCoordinates, internalPointerEvent, z);
        }
        return false;
    }

    public final void clearPreviouslyHitModifierNodeCache() {
        this.root.clear();
    }

    public final void processCancel() {
        this.root.dispatchCancel();
        clearPreviouslyHitModifierNodeCache();
    }

    public final void removeDetachedPointerInputNodes() {
        this.root.removeDetachedPointerInputModifierNodes();
    }
}
