package androidx.compose.ui.graphics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.ClosedFloatingPointRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class IntervalTree<T> {
    private IntervalTree<T>.Node root;
    private final ArrayList<IntervalTree<T>.Node> stack;
    private final IntervalTree<T>.Node terminator;

    public enum TreeColor {
        Red,
        Black
    }

    public IntervalTree() {
        IntervalTree<T>.Node node = new Node(Float.MAX_VALUE, Float.MIN_VALUE, null, TreeColor.Black);
        this.terminator = node;
        this.root = node;
        this.stack = new ArrayList<>();
    }

    public final void clear() {
        this.root = this.terminator;
    }

    public final Interval<T> findFirstOverlap(@NotNull ClosedFloatingPointRange<Float> closedFloatingPointRange) {
        return findFirstOverlap(closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue());
    }

    public static /* synthetic */ Interval findFirstOverlap$default(IntervalTree intervalTree, float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            f2 = f;
        }
        return intervalTree.findFirstOverlap(f, f2);
    }

    public final Interval<T> findFirstOverlap(float f, float f2) {
        if (this.root != this.terminator && this.root != this.terminator) {
            ArrayList arrayList = this.stack;
            arrayList.add(this.root);
            while (arrayList.size() > 0) {
                Node node = (Node) CollectionsKt__MutableCollectionsKt.removeLast(arrayList);
                if (node.overlaps(f, f2)) {
                    return node;
                }
                if (node.getLeft() != this.terminator && node.getLeft().getMax() >= f) {
                    arrayList.add(node.getLeft());
                }
                if (node.getRight() != this.terminator && node.getRight().getMin() <= f2) {
                    arrayList.add(node.getRight());
                }
            }
            arrayList.clear();
        }
        Interval<T> interval = (Interval<T>) IntervalTreeKt.getEmptyInterval();
        Intrinsics.checkNotNull(interval, "null cannot be cast to non-null type androidx.compose.ui.graphics.Interval<T of androidx.compose.ui.graphics.IntervalTree>");
        return interval;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ List findOverlaps$default(IntervalTree intervalTree, ClosedFloatingPointRange closedFloatingPointRange, List list, int i, Object obj) {
        if ((i & 2) != 0) {
            list = new ArrayList();
        }
        return intervalTree.findOverlaps(closedFloatingPointRange, list);
    }

    public final List<Interval<T>> findOverlaps(@NotNull ClosedFloatingPointRange<Float> closedFloatingPointRange, @NotNull List<Interval<T>> list) {
        return findOverlaps(closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue(), list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ List findOverlaps$default(IntervalTree intervalTree, float f, float f2, List list, int i, Object obj) {
        if ((i & 2) != 0) {
            f2 = f;
        }
        if ((i & 4) != 0) {
            list = new ArrayList();
        }
        return intervalTree.findOverlaps(f, f2, list);
    }

    public final void forEach$ui_graphics_release(@NotNull ClosedFloatingPointRange<Float> closedFloatingPointRange, @NotNull Function1<? super Interval<T>, Unit> function1) {
        float fFloatValue = closedFloatingPointRange.getStart().floatValue();
        float fFloatValue2 = closedFloatingPointRange.getEndInclusive().floatValue();
        if (this.root != this.terminator) {
            ArrayList arrayList = this.stack;
            arrayList.add(this.root);
            while (arrayList.size() > 0) {
                Node node = (Node) CollectionsKt__MutableCollectionsKt.removeLast(arrayList);
                if (node.overlaps(fFloatValue, fFloatValue2)) {
                    function1.invoke(node);
                }
                if (node.getLeft() != this.terminator && node.getLeft().getMax() >= fFloatValue) {
                    arrayList.add(node.getLeft());
                }
                if (node.getRight() != this.terminator && node.getRight().getMin() <= fFloatValue2) {
                    arrayList.add(node.getRight());
                }
            }
            arrayList.clear();
        }
    }

    public static /* synthetic */ void forEach$ui_graphics_release$default(IntervalTree intervalTree, float f, float f2, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            f2 = f;
        }
        if (intervalTree.root != intervalTree.terminator) {
            ArrayList arrayList = intervalTree.stack;
            arrayList.add(intervalTree.root);
            while (arrayList.size() > 0) {
                Node node = (Node) CollectionsKt__MutableCollectionsKt.removeLast(arrayList);
                if (node.overlaps(f, f2)) {
                    function1.invoke(node);
                }
                if (node.getLeft() != intervalTree.terminator && node.getLeft().getMax() >= f) {
                    arrayList.add(node.getLeft());
                }
                if (node.getRight() != intervalTree.terminator && node.getRight().getMin() <= f2) {
                    arrayList.add(node.getRight());
                }
            }
            arrayList.clear();
        }
    }

    public final void forEach$ui_graphics_release(float f, float f2, @NotNull Function1<? super Interval<T>, Unit> function1) {
        if (this.root != this.terminator) {
            ArrayList arrayList = this.stack;
            arrayList.add(this.root);
            while (arrayList.size() > 0) {
                Node node = (Node) CollectionsKt__MutableCollectionsKt.removeLast(arrayList);
                if (node.overlaps(f, f2)) {
                    function1.invoke(node);
                }
                if (node.getLeft() != this.terminator && node.getLeft().getMax() >= f) {
                    arrayList.add(node.getLeft());
                }
                if (node.getRight() != this.terminator && node.getRight().getMin() <= f2) {
                    arrayList.add(node.getRight());
                }
            }
            arrayList.clear();
        }
    }

    public final boolean contains(float f) {
        return findFirstOverlap(f, f) != IntervalTreeKt.getEmptyInterval();
    }

    public final boolean contains(@NotNull ClosedFloatingPointRange<Float> closedFloatingPointRange) {
        return findFirstOverlap(closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue()) != IntervalTreeKt.getEmptyInterval();
    }

    /* JADX INFO: renamed from: androidx.compose.ui.graphics.IntervalTree$iterator$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Iterator<Interval<T>>, KMappedMarker {
        private IntervalTree<T>.Node next;
        final /* synthetic */ IntervalTree<T> this$0;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        AnonymousClass1(IntervalTree<T> intervalTree) {
            this.this$0 = intervalTree;
            this.next = ((IntervalTree) intervalTree).root.lowestNode();
        }

        public final IntervalTree<T>.Node getNext() {
            return this.next;
        }

        public final void setNext(@NotNull IntervalTree<T>.Node node) {
            this.next = node;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.next != ((IntervalTree) this.this$0).terminator;
        }

        @Override // java.util.Iterator
        public Interval<T> next() {
            IntervalTree<T>.Node node = this.next;
            this.next = node.next();
            return node;
        }
    }

    public final Iterator<Interval<T>> iterator() {
        return new AnonymousClass1(this);
    }

    public final void plusAssign(@NotNull Interval<T> interval) {
        addInterval(interval.getStart(), interval.getEnd(), interval.getData());
    }

    public final void addInterval(float f, float f2, @Nullable T t) {
        IntervalTree<T>.Node right;
        IntervalTree<T>.Node node = new Node(f, f2, t, TreeColor.Red);
        IntervalTree<T>.Node node2 = this.root;
        IntervalTree<T>.Node node3 = this.terminator;
        while (node2 != this.terminator) {
            if (node.getStart() <= node2.getStart()) {
                right = node2.getLeft();
            } else {
                right = node2.getRight();
            }
            IntervalTree<T>.Node node4 = right;
            node3 = node2;
            node2 = node4;
        }
        node.setParent(node3);
        if (node3 == this.terminator) {
            this.root = node;
        } else if (node.getStart() <= node3.getStart()) {
            node3.setLeft(node);
        } else {
            node3.setRight(node);
        }
        updateNodeData(node);
        rebalance(node);
    }

    private final void rebalance(IntervalTree<T>.Node node) {
        while (node != this.root) {
            TreeColor color = node.getParent().getColor();
            TreeColor treeColor = TreeColor.Red;
            if (color != treeColor) {
                break;
            }
            IntervalTree<T>.Node parent = node.getParent().getParent();
            if (node.getParent() == parent.getLeft()) {
                IntervalTree<T>.Node right = parent.getRight();
                if (right.getColor() == treeColor) {
                    TreeColor treeColor2 = TreeColor.Black;
                    right.setColor(treeColor2);
                    node.getParent().setColor(treeColor2);
                    parent.setColor(treeColor);
                    node = parent;
                } else {
                    if (node == node.getParent().getRight()) {
                        node = node.getParent();
                        rotateLeft(node);
                    }
                    node.getParent().setColor(TreeColor.Black);
                    parent.setColor(treeColor);
                    rotateRight(parent);
                }
            } else {
                IntervalTree<T>.Node left = parent.getLeft();
                if (left.getColor() == treeColor) {
                    TreeColor treeColor3 = TreeColor.Black;
                    left.setColor(treeColor3);
                    node.getParent().setColor(treeColor3);
                    parent.setColor(treeColor);
                    node = parent;
                } else {
                    if (node == node.getParent().getLeft()) {
                        node = node.getParent();
                        rotateRight(node);
                    }
                    node.getParent().setColor(TreeColor.Black);
                    parent.setColor(treeColor);
                    rotateLeft(parent);
                }
            }
        }
        this.root.setColor(TreeColor.Black);
    }

    private final void rotateLeft(IntervalTree<T>.Node node) {
        IntervalTree<T>.Node right = node.getRight();
        node.setRight(right.getLeft());
        if (right.getLeft() != this.terminator) {
            right.getLeft().setParent(node);
        }
        right.setParent(node.getParent());
        if (node.getParent() == this.terminator) {
            this.root = right;
        } else if (node.getParent().getLeft() == node) {
            node.getParent().setLeft(right);
        } else {
            node.getParent().setRight(right);
        }
        right.setLeft(node);
        node.setParent(right);
        updateNodeData(node);
    }

    private final void rotateRight(IntervalTree<T>.Node node) {
        IntervalTree<T>.Node left = node.getLeft();
        node.setLeft(left.getRight());
        if (left.getRight() != this.terminator) {
            left.getRight().setParent(node);
        }
        left.setParent(node.getParent());
        if (node.getParent() == this.terminator) {
            this.root = left;
        } else if (node.getParent().getRight() == node) {
            node.getParent().setRight(left);
        } else {
            node.getParent().setLeft(left);
        }
        left.setRight(node);
        node.setParent(left);
        updateNodeData(node);
    }

    private final void updateNodeData(IntervalTree<T>.Node node) {
        while (node != this.terminator) {
            node.setMin(Math.min(node.getStart(), Math.min(node.getLeft().getMin(), node.getRight().getMin())));
            node.setMax(Math.max(node.getEnd(), Math.max(node.getLeft().getMax(), node.getRight().getMax())));
            node = node.getParent();
        }
    }

    public final class Node extends Interval<T> {
        private TreeColor color;
        private IntervalTree<T>.Node left;
        private float max;
        private float min;
        private IntervalTree<T>.Node parent;
        private IntervalTree<T>.Node right;

        public Node(float f, @Nullable float f2, @NotNull T t, TreeColor treeColor) {
            super(f, f2, t);
            this.color = treeColor;
            this.min = f;
            this.max = f2;
            this.left = IntervalTree.this.terminator;
            this.right = IntervalTree.this.terminator;
            this.parent = IntervalTree.this.terminator;
        }

        public final TreeColor getColor() {
            return this.color;
        }

        public final void setColor(@NotNull TreeColor treeColor) {
            this.color = treeColor;
        }

        public final float getMin() {
            return this.min;
        }

        public final void setMin(float f) {
            this.min = f;
        }

        public final float getMax() {
            return this.max;
        }

        public final void setMax(float f) {
            this.max = f;
        }

        public final IntervalTree<T>.Node getLeft() {
            return this.left;
        }

        public final void setLeft(@NotNull IntervalTree<T>.Node node) {
            this.left = node;
        }

        public final IntervalTree<T>.Node getRight() {
            return this.right;
        }

        public final void setRight(@NotNull IntervalTree<T>.Node node) {
            this.right = node;
        }

        public final IntervalTree<T>.Node getParent() {
            return this.parent;
        }

        public final void setParent(@NotNull IntervalTree<T>.Node node) {
            this.parent = node;
        }

        public final IntervalTree<T>.Node lowestNode() {
            Node node = this;
            while (node.left != ((IntervalTree) IntervalTree.this).terminator) {
                node = node.left;
            }
            return node;
        }

        public final IntervalTree<T>.Node next() {
            if (this.right != ((IntervalTree) IntervalTree.this).terminator) {
                return this.right.lowestNode();
            }
            IntervalTree<T>.Node node = this.parent;
            Node node2 = this;
            while (node != ((IntervalTree) IntervalTree.this).terminator && node2 == node.right) {
                node2 = node;
                node = node.parent;
            }
            return node;
        }
    }

    public final List<Interval<T>> findOverlaps(float f, float f2, @NotNull List<Interval<T>> list) {
        if (this.root != this.terminator) {
            ArrayList arrayList = this.stack;
            arrayList.add(this.root);
            while (arrayList.size() > 0) {
                Node node = (Node) CollectionsKt__MutableCollectionsKt.removeLast(arrayList);
                if (node.overlaps(f, f2)) {
                    list.add(node);
                }
                if (node.getLeft() != this.terminator && node.getLeft().getMax() >= f) {
                    arrayList.add(node.getLeft());
                }
                if (node.getRight() != this.terminator && node.getRight().getMin() <= f2) {
                    arrayList.add(node.getRight());
                }
            }
            arrayList.clear();
        }
        return list;
    }
}
