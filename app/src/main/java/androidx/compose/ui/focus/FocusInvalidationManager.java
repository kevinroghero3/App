package androidx.compose.ui.focus;

import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class FocusInvalidationManager {
    public static final int $stable = 8;
    private final Function0<Unit> invalidateOwnerFocusState;
    private final Function1<Function0<Unit>, Unit> onRequestApplyChangesListener;
    private final MutableScatterSet<FocusTargetNode> focusTargetNodes = ScatterSetKt.mutableScatterSetOf();
    private final MutableScatterSet<FocusEventModifierNode> focusEventNodes = ScatterSetKt.mutableScatterSetOf();
    private final MutableScatterSet<FocusPropertiesModifierNode> focusPropertiesNodes = ScatterSetKt.mutableScatterSetOf();
    private final MutableScatterSet<FocusTargetNode> focusTargetsWithInvalidatedFocusEvents = ScatterSetKt.mutableScatterSetOf();

    /* JADX WARN: Multi-variable type inference failed */
    public FocusInvalidationManager(@NotNull Function1<? super Function0<Unit>, Unit> function1, @NotNull Function0<Unit> function0) {
        this.onRequestApplyChangesListener = function1;
        this.invalidateOwnerFocusState = function0;
    }

    public final void scheduleInvalidation(@NotNull FocusTargetNode focusTargetNode) {
        scheduleInvalidation(this.focusTargetNodes, focusTargetNode);
    }

    public final void scheduleInvalidation(@NotNull FocusEventModifierNode focusEventModifierNode) {
        scheduleInvalidation(this.focusEventNodes, focusEventModifierNode);
    }

    public final void scheduleInvalidation(@NotNull FocusPropertiesModifierNode focusPropertiesModifierNode) {
        scheduleInvalidation(this.focusPropertiesNodes, focusPropertiesModifierNode);
    }

    public final boolean hasPendingInvalidation() {
        return this.focusTargetNodes.isNotEmpty() || this.focusPropertiesNodes.isNotEmpty() || this.focusEventNodes.isNotEmpty();
    }

    private final <T> void scheduleInvalidation(MutableScatterSet<T> mutableScatterSet, T t) {
        if (mutableScatterSet.add(t) && this.focusTargetNodes.getSize() + this.focusEventNodes.getSize() + this.focusPropertiesNodes.getSize() == 1) {
            this.onRequestApplyChangesListener.invoke(new AnonymousClass1(this));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.focus.FocusInvalidationManager$scheduleInvalidation$1, reason: invalid class name */
    final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Unit> {
        AnonymousClass1(Object obj) {
            super(0, obj, FocusInvalidationManager.class, "invalidateNodes", "invalidateNodes()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((FocusInvalidationManager) this.receiver).invalidateNodes();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void invalidateNodes() {
        int i;
        long[] jArr;
        Object[] objArr;
        long[] jArr2;
        Object[] objArr2;
        FocusState focusState;
        int i2;
        int i3;
        long[] jArr3;
        Object[] objArr3;
        boolean z;
        Object[] objArr4;
        long[] jArr4;
        long[] jArr5;
        int i4;
        long[] jArr6;
        MutableScatterSet<FocusPropertiesModifierNode> mutableScatterSet = this.focusPropertiesNodes;
        Object[] objArr5 = mutableScatterSet.elements;
        long[] jArr7 = mutableScatterSet.metadata;
        int length = jArr7.length - 2;
        char c = 7;
        long j = -9187201950435737472L;
        int i5 = 8;
        int i6 = 1;
        if (length >= 0) {
            int i7 = 0;
            while (true) {
                long j2 = jArr7[i7];
                if ((((~j2) << c) & j2 & j) != j) {
                    int i8 = 8 - ((~(i7 - length)) >>> 31);
                    int i9 = 0;
                    while (i9 < i8) {
                        if ((j2 & 255) < 128) {
                            FocusPropertiesModifierNode focusPropertiesModifierNode = (FocusPropertiesModifierNode) objArr5[(i7 << 3) + i9];
                            if (focusPropertiesModifierNode.getNode().isAttached()) {
                                int iM2761constructorimpl = NodeKind.m2761constructorimpl(1024);
                                Modifier.Node node = focusPropertiesModifierNode.getNode();
                                MutableVector mutableVector = null;
                                while (node != null) {
                                    if (node instanceof FocusTargetNode) {
                                        this.focusTargetNodes.add((FocusTargetNode) node);
                                    } else {
                                        if ((node.getKindSet$ui_release() & iM2761constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                                            Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release();
                                            int i10 = 0;
                                            while (delegate$ui_release != null) {
                                                if ((delegate$ui_release.getKindSet$ui_release() & iM2761constructorimpl) != 0) {
                                                    i10++;
                                                    if (i10 == i6) {
                                                        jArr7 = jArr7;
                                                        node = delegate$ui_release;
                                                    } else {
                                                        if (mutableVector == null) {
                                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                        }
                                                        if (node != null) {
                                                            mutableVector.add(node);
                                                            node = null;
                                                        }
                                                        mutableVector.add(delegate$ui_release);
                                                    }
                                                } else {
                                                    jArr7 = jArr7;
                                                }
                                                delegate$ui_release = delegate$ui_release.getChild$ui_release();
                                                jArr7 = jArr7;
                                                i6 = 1;
                                            }
                                            jArr6 = jArr7;
                                            if (i10 == i6) {
                                            }
                                            jArr7 = jArr6;
                                            i6 = 1;
                                        }
                                        node = DelegatableNodeKt.pop(mutableVector);
                                        jArr7 = jArr6;
                                        i6 = 1;
                                    }
                                    jArr6 = jArr7;
                                    node = DelegatableNodeKt.pop(mutableVector);
                                    jArr7 = jArr6;
                                    i6 = 1;
                                }
                                jArr5 = jArr7;
                                if (!focusPropertiesModifierNode.getNode().isAttached()) {
                                    throw new IllegalStateException("visitChildren called on an unattached node");
                                }
                                MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                Modifier.Node child$ui_release = focusPropertiesModifierNode.getNode().getChild$ui_release();
                                if (child$ui_release == null) {
                                    DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, focusPropertiesModifierNode.getNode());
                                } else {
                                    mutableVector2.add(child$ui_release);
                                }
                                while (mutableVector2.isNotEmpty()) {
                                    Modifier.Node nodePop = (Modifier.Node) mutableVector2.removeAt(mutableVector2.getSize() - 1);
                                    if ((nodePop.getAggregateChildKindSet$ui_release() & iM2761constructorimpl) == 0) {
                                        DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, nodePop);
                                    } else {
                                        while (nodePop != null) {
                                            if ((nodePop.getKindSet$ui_release() & iM2761constructorimpl) != 0) {
                                                MutableVector mutableVector3 = null;
                                                while (nodePop != null) {
                                                    if (nodePop instanceof FocusTargetNode) {
                                                        this.focusTargetNodes.add((FocusTargetNode) nodePop);
                                                    } else if ((nodePop.getKindSet$ui_release() & iM2761constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                                                        int i11 = 0;
                                                        for (Modifier.Node delegate$ui_release2 = ((DelegatingNode) nodePop).getDelegate$ui_release(); delegate$ui_release2 != null; delegate$ui_release2 = delegate$ui_release2.getChild$ui_release()) {
                                                            if ((delegate$ui_release2.getKindSet$ui_release() & iM2761constructorimpl) != 0) {
                                                                i11++;
                                                                if (i11 == 1) {
                                                                    nodePop = delegate$ui_release2;
                                                                } else {
                                                                    if (mutableVector3 == null) {
                                                                        mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                                                    }
                                                                    if (nodePop != null) {
                                                                        mutableVector3.add(nodePop);
                                                                        nodePop = null;
                                                                    }
                                                                    mutableVector3.add(delegate$ui_release2);
                                                                }
                                                            }
                                                        }
                                                        if (i11 == 1) {
                                                        }
                                                    }
                                                    nodePop = DelegatableNodeKt.pop(mutableVector3);
                                                }
                                                break;
                                            }
                                            nodePop = nodePop.getChild$ui_release();
                                        }
                                    }
                                }
                            } else {
                                jArr5 = jArr7;
                            }
                            i4 = 8;
                        } else {
                            jArr5 = jArr7;
                            i4 = i5;
                        }
                        j2 >>= i4;
                        i9++;
                        i5 = i4;
                        jArr7 = jArr5;
                        i6 = 1;
                    }
                    jArr4 = jArr7;
                    if (i8 != i5) {
                        break;
                    }
                } else {
                    jArr4 = jArr7;
                }
                if (i7 == length) {
                    break;
                }
                i7++;
                jArr7 = jArr4;
                c = 7;
                j = -9187201950435737472L;
                i6 = 1;
                i5 = 8;
            }
        }
        this.focusPropertiesNodes.clear();
        MutableScatterSet<FocusEventModifierNode> mutableScatterSet2 = this.focusEventNodes;
        Object[] objArr6 = mutableScatterSet2.elements;
        long[] jArr8 = mutableScatterSet2.metadata;
        int length2 = jArr8.length - 2;
        if (length2 >= 0) {
            int i12 = 0;
            while (true) {
                long j3 = jArr8[i12];
                if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i13 = 8 - ((~(i12 - length2)) >>> 31);
                    int i14 = 0;
                    while (i14 < i13) {
                        if ((j3 & 255) < 128) {
                            FocusEventModifierNode focusEventModifierNode = (FocusEventModifierNode) objArr6[(i12 << 3) + i14];
                            if (focusEventModifierNode.getNode().isAttached()) {
                                int iM2761constructorimpl2 = NodeKind.m2761constructorimpl(1024);
                                Modifier.Node node2 = focusEventModifierNode.getNode();
                                boolean z2 = false;
                                boolean z3 = true;
                                FocusTargetNode focusTargetNode = null;
                                MutableVector mutableVector4 = null;
                                while (node2 != null) {
                                    if (node2 instanceof FocusTargetNode) {
                                        FocusTargetNode focusTargetNode2 = (FocusTargetNode) node2;
                                        if (focusTargetNode != null) {
                                            z2 = true;
                                        }
                                        if (this.focusTargetNodes.contains(focusTargetNode2)) {
                                            this.focusTargetsWithInvalidatedFocusEvents.add(focusTargetNode2);
                                            z3 = false;
                                        }
                                        jArr3 = jArr8;
                                        objArr3 = objArr6;
                                        focusTargetNode = focusTargetNode2;
                                    } else {
                                        if ((node2.getKindSet$ui_release() & iM2761constructorimpl2) == 0 || !(node2 instanceof DelegatingNode)) {
                                            jArr3 = jArr8;
                                            objArr3 = objArr6;
                                            z = z2;
                                        } else {
                                            Modifier.Node delegate$ui_release3 = ((DelegatingNode) node2).getDelegate$ui_release();
                                            jArr3 = jArr8;
                                            int i15 = 0;
                                            while (delegate$ui_release3 != null) {
                                                if ((delegate$ui_release3.getKindSet$ui_release() & iM2761constructorimpl2) != 0) {
                                                    i15++;
                                                    objArr4 = objArr6;
                                                    if (i15 == 1) {
                                                        node2 = delegate$ui_release3;
                                                    } else {
                                                        MutableVector mutableVector5 = mutableVector4 == null ? new MutableVector(new Modifier.Node[16], 0) : mutableVector4;
                                                        if (node2 != null) {
                                                            mutableVector5.add(node2);
                                                            node2 = null;
                                                        }
                                                        mutableVector5.add(delegate$ui_release3);
                                                        mutableVector4 = mutableVector5;
                                                        i15 = i15;
                                                    }
                                                    delegate$ui_release3 = delegate$ui_release3.getChild$ui_release();
                                                    objArr6 = objArr4;
                                                    z2 = z2;
                                                } else {
                                                    objArr4 = objArr6;
                                                }
                                                z2 = z2;
                                                delegate$ui_release3 = delegate$ui_release3.getChild$ui_release();
                                                objArr6 = objArr4;
                                                z2 = z2;
                                            }
                                            objArr3 = objArr6;
                                            z = z2;
                                            if (i15 == 1) {
                                                z2 = z;
                                            }
                                            jArr8 = jArr3;
                                            objArr6 = objArr3;
                                        }
                                        z2 = z;
                                    }
                                    node2 = DelegatableNodeKt.pop(mutableVector4);
                                    jArr8 = jArr3;
                                    objArr6 = objArr3;
                                }
                                jArr2 = jArr8;
                                objArr2 = objArr6;
                                boolean z4 = z2;
                                if (!focusEventModifierNode.getNode().isAttached()) {
                                    throw new IllegalStateException("visitChildren called on an unattached node");
                                }
                                MutableVector mutableVector6 = new MutableVector(new Modifier.Node[16], 0);
                                Modifier.Node child$ui_release2 = focusEventModifierNode.getNode().getChild$ui_release();
                                if (child$ui_release2 == null) {
                                    DelegatableNodeKt.addLayoutNodeChildren(mutableVector6, focusEventModifierNode.getNode());
                                } else {
                                    mutableVector6.add(child$ui_release2);
                                }
                                boolean z5 = z4;
                                while (mutableVector6.isNotEmpty()) {
                                    Modifier.Node nodePop2 = (Modifier.Node) mutableVector6.removeAt(mutableVector6.getSize() - 1);
                                    if ((nodePop2.getAggregateChildKindSet$ui_release() & iM2761constructorimpl2) == 0) {
                                        DelegatableNodeKt.addLayoutNodeChildren(mutableVector6, nodePop2);
                                    } else {
                                        while (true) {
                                            if (nodePop2 != null) {
                                                if ((nodePop2.getKindSet$ui_release() & iM2761constructorimpl2) != 0) {
                                                    MutableVector mutableVector7 = null;
                                                    while (nodePop2 != null) {
                                                        if (nodePop2 instanceof FocusTargetNode) {
                                                            FocusTargetNode focusTargetNode3 = (FocusTargetNode) nodePop2;
                                                            if (focusTargetNode != null) {
                                                                z5 = true;
                                                            }
                                                            if (this.focusTargetNodes.contains(focusTargetNode3)) {
                                                                this.focusTargetsWithInvalidatedFocusEvents.add(focusTargetNode3);
                                                                z3 = false;
                                                            }
                                                            focusTargetNode = focusTargetNode3;
                                                        } else {
                                                            if ((nodePop2.getKindSet$ui_release() & iM2761constructorimpl2) != 0 && (nodePop2 instanceof DelegatingNode)) {
                                                                Modifier.Node delegate$ui_release4 = ((DelegatingNode) nodePop2).getDelegate$ui_release();
                                                                mutableVector6 = mutableVector6;
                                                                int i16 = 0;
                                                                while (delegate$ui_release4 != null) {
                                                                    if ((delegate$ui_release4.getKindSet$ui_release() & iM2761constructorimpl2) != 0) {
                                                                        i16++;
                                                                        i3 = iM2761constructorimpl2;
                                                                        if (i16 == 1) {
                                                                            nodePop2 = delegate$ui_release4;
                                                                        } else {
                                                                            if (mutableVector7 == null) {
                                                                                mutableVector7 = new MutableVector(new Modifier.Node[16], 0);
                                                                            }
                                                                            if (nodePop2 != null) {
                                                                                mutableVector7.add(nodePop2);
                                                                                nodePop2 = null;
                                                                            }
                                                                            mutableVector7.add(delegate$ui_release4);
                                                                            i16 = i16;
                                                                        }
                                                                        delegate$ui_release4 = delegate$ui_release4.getChild$ui_release();
                                                                        iM2761constructorimpl2 = i3;
                                                                    } else {
                                                                        i3 = iM2761constructorimpl2;
                                                                    }
                                                                    delegate$ui_release4 = delegate$ui_release4.getChild$ui_release();
                                                                    iM2761constructorimpl2 = i3;
                                                                }
                                                                i2 = iM2761constructorimpl2;
                                                                if (i16 != 1) {
                                                                    nodePop2 = DelegatableNodeKt.pop(mutableVector7);
                                                                }
                                                            }
                                                            mutableVector6 = mutableVector6;
                                                            iM2761constructorimpl2 = i2;
                                                        }
                                                        i2 = iM2761constructorimpl2;
                                                        nodePop2 = DelegatableNodeKt.pop(mutableVector7);
                                                        mutableVector6 = mutableVector6;
                                                        iM2761constructorimpl2 = i2;
                                                    }
                                                    break;
                                                }
                                                nodePop2 = nodePop2.getChild$ui_release();
                                                iM2761constructorimpl2 = iM2761constructorimpl2;
                                            }
                                        }
                                    }
                                    mutableVector6 = mutableVector6;
                                    iM2761constructorimpl2 = iM2761constructorimpl2;
                                }
                                if (z3) {
                                    if (z5) {
                                        focusState = FocusEventModifierNodeKt.getFocusState(focusEventModifierNode);
                                    } else if (focusTargetNode == null || (focusState = focusTargetNode.getFocusState()) == null) {
                                        focusState = FocusStateImpl.Inactive;
                                    }
                                    focusEventModifierNode.onFocusEvent(focusState);
                                }
                            } else {
                                focusEventModifierNode.onFocusEvent(FocusStateImpl.Inactive);
                                jArr2 = jArr8;
                                objArr2 = objArr6;
                            }
                        } else {
                            jArr2 = jArr8;
                            objArr2 = objArr6;
                        }
                        j3 >>= 8;
                        i14++;
                        jArr8 = jArr2;
                        objArr6 = objArr2;
                    }
                    jArr = jArr8;
                    objArr = objArr6;
                    i = 0;
                    if (i13 != 8) {
                        break;
                    }
                } else {
                    jArr = jArr8;
                    objArr = objArr6;
                    i = 0;
                }
                if (i12 == length2) {
                    break;
                }
                i12++;
                jArr8 = jArr;
                objArr6 = objArr;
            }
        } else {
            i = 0;
        }
        this.focusEventNodes.clear();
        MutableScatterSet<FocusTargetNode> mutableScatterSet3 = this.focusTargetNodes;
        Object[] objArr7 = mutableScatterSet3.elements;
        long[] jArr9 = mutableScatterSet3.metadata;
        int length3 = jArr9.length - 2;
        if (length3 >= 0) {
            int i17 = i;
            while (true) {
                long j4 = jArr9[i17];
                if ((((~j4) << 7) & j4 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i18 = 8 - ((~(i17 - length3)) >>> 31);
                    for (int i19 = i; i19 < i18; i19++) {
                        if ((j4 & 255) < 128) {
                            FocusTargetNode focusTargetNode4 = (FocusTargetNode) objArr7[(i17 << 3) + i19];
                            if (focusTargetNode4.isAttached()) {
                                FocusStateImpl focusState2 = focusTargetNode4.getFocusState();
                                focusTargetNode4.invalidateFocus$ui_release();
                                if (focusState2 != focusTargetNode4.getFocusState() || this.focusTargetsWithInvalidatedFocusEvents.contains(focusTargetNode4)) {
                                    FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetNode4);
                                }
                            }
                        }
                        j4 >>= 8;
                    }
                    if (i18 != 8) {
                        break;
                    }
                }
                if (i17 == length3) {
                    break;
                } else {
                    i17++;
                }
            }
        }
        this.focusTargetNodes.clear();
        this.focusTargetsWithInvalidatedFocusEvents.clear();
        this.invalidateOwnerFocusState.invoke();
        if (!this.focusPropertiesNodes.isEmpty()) {
            InlineClassHelperKt.throwIllegalStateException("Unprocessed FocusProperties nodes");
        }
        if (!this.focusEventNodes.isEmpty()) {
            InlineClassHelperKt.throwIllegalStateException("Unprocessed FocusEvent nodes");
        }
        if (this.focusTargetNodes.isEmpty()) {
            return;
        }
        InlineClassHelperKt.throwIllegalStateException("Unprocessed FocusTarget nodes");
    }
}
