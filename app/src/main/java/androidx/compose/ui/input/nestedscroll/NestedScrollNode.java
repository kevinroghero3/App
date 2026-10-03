package androidx.compose.ui.input.nestedscroll;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNodeKt;
import androidx.compose.ui.unit.Velocity;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class NestedScrollNode extends Modifier.Node implements TraversableNode, NestedScrollConnection {
    public static final int $stable = 8;
    private NestedScrollConnection connection;
    private NestedScrollDispatcher resolvedDispatcher;
    private final Object traverseKey;

    public final NestedScrollConnection getConnection() {
        return this.connection;
    }

    public final void setConnection(@NotNull NestedScrollConnection nestedScrollConnection) {
        this.connection = nestedScrollConnection;
    }

    public NestedScrollNode(@NotNull NestedScrollConnection nestedScrollConnection, @Nullable NestedScrollDispatcher nestedScrollDispatcher) {
        this.connection = nestedScrollConnection;
        this.resolvedDispatcher = nestedScrollDispatcher == null ? new NestedScrollDispatcher() : nestedScrollDispatcher;
        this.traverseKey = "androidx.compose.ui.input.nestedscroll.NestedScrollNode";
    }

    public final NestedScrollNode getParentNestedScrollNode$ui_release() {
        if (isAttached()) {
            return (NestedScrollNode) TraversableNodeKt.findNearestAncestor(this);
        }
        return null;
    }

    private final NestedScrollConnection getParentConnection() {
        if (isAttached()) {
            return getParentNestedScrollNode$ui_release();
        }
        return null;
    }

    @Override // androidx.compose.ui.node.TraversableNode
    public Object getTraverseKey() {
        return this.traverseKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoroutineScope getNestedCoroutineScope() {
        CoroutineScope scope$ui_release;
        NestedScrollNode parentNestedScrollNode$ui_release = getParentNestedScrollNode$ui_release();
        if ((parentNestedScrollNode$ui_release == null || (scope$ui_release = parentNestedScrollNode$ui_release.getNestedCoroutineScope()) == null) && (scope$ui_release = this.resolvedDispatcher.getScope$ui_release()) == null) {
            throw new IllegalStateException("in order to access nested coroutine scope you need to attach dispatcher to the `Modifier.nestedScroll` first.");
        }
        return scope$ui_release;
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreScroll-OzD1aCk */
    public long mo599onPreScrollOzD1aCk(long j, int i) {
        NestedScrollConnection parentConnection = getParentConnection();
        long jMo599onPreScrollOzD1aCk = parentConnection != null ? parentConnection.mo599onPreScrollOzD1aCk(j, i) : Offset.Companion.m944getZeroF1C5BW0();
        return Offset.m933plusMKHz9U(jMo599onPreScrollOzD1aCk, this.connection.mo599onPreScrollOzD1aCk(Offset.m932minusMKHz9U(j, jMo599onPreScrollOzD1aCk), i));
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
    public long mo597onPostScrollDzOQY0M(long j, long j2, int i) {
        long jM944getZeroF1C5BW0;
        long jMo597onPostScrollDzOQY0M = this.connection.mo597onPostScrollDzOQY0M(j, j2, i);
        NestedScrollConnection parentConnection = getParentConnection();
        if (parentConnection != null) {
            jM944getZeroF1C5BW0 = parentConnection.mo597onPostScrollDzOQY0M(Offset.m933plusMKHz9U(j, jMo597onPostScrollDzOQY0M), Offset.m932minusMKHz9U(j2, jMo597onPostScrollDzOQY0M), i);
        } else {
            jM944getZeroF1C5BW0 = Offset.Companion.m944getZeroF1C5BW0();
        }
        return Offset.m933plusMKHz9U(jMo597onPostScrollDzOQY0M, jM944getZeroF1C5BW0);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0078 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:27:0x0079  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreFling-QWom1Mo */
    public Object mo598onPreFlingQWom1Mo(long j, @NotNull Continuation<? super Velocity> continuation) {
        NestedScrollNode$onPreFling$1 nestedScrollNode$onPreFling$1;
        long jM3898getZero9UxMQ8M;
        NestedScrollNode nestedScrollNode;
        long j2;
        if (continuation instanceof NestedScrollNode$onPreFling$1) {
            nestedScrollNode$onPreFling$1 = (NestedScrollNode$onPreFling$1) continuation;
            int i = nestedScrollNode$onPreFling$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                nestedScrollNode$onPreFling$1.label = i - Integer.MIN_VALUE;
            } else {
                nestedScrollNode$onPreFling$1 = new NestedScrollNode$onPreFling$1(this, continuation);
            }
        } else {
            nestedScrollNode$onPreFling$1 = new NestedScrollNode$onPreFling$1(this, continuation);
        }
        Object objMo598onPreFlingQWom1Mo = nestedScrollNode$onPreFling$1.result;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = nestedScrollNode$onPreFling$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objMo598onPreFlingQWom1Mo);
            NestedScrollConnection parentConnection = getParentConnection();
            if (parentConnection != null) {
                nestedScrollNode$onPreFling$1.L$0 = this;
                nestedScrollNode$onPreFling$1.J$0 = j;
                nestedScrollNode$onPreFling$1.label = 1;
                objMo598onPreFlingQWom1Mo = parentConnection.mo598onPreFlingQWom1Mo(j, nestedScrollNode$onPreFling$1);
                if (objMo598onPreFlingQWom1Mo == coroutine_suspended) {
                    return coroutine_suspended;
                }
                nestedScrollNode = this;
            } else {
                jM3898getZero9UxMQ8M = Velocity.Companion.m3898getZero9UxMQ8M();
                nestedScrollNode = this;
            }
            NestedScrollConnection nestedScrollConnection = nestedScrollNode.connection;
            long jM3890minusAH228Gc = Velocity.m3890minusAH228Gc(j, jM3898getZero9UxMQ8M);
            nestedScrollNode$onPreFling$1.L$0 = null;
            nestedScrollNode$onPreFling$1.J$0 = jM3898getZero9UxMQ8M;
            nestedScrollNode$onPreFling$1.label = 2;
            objMo598onPreFlingQWom1Mo = nestedScrollConnection.mo598onPreFlingQWom1Mo(jM3890minusAH228Gc, nestedScrollNode$onPreFling$1);
            if (objMo598onPreFlingQWom1Mo == coroutine_suspended) {
                return coroutine_suspended;
            }
            j2 = jM3898getZero9UxMQ8M;
            return Velocity.m3878boximpl(Velocity.m3891plusAH228Gc(j2, ((Velocity) objMo598onPreFlingQWom1Mo).m3896unboximpl()));
        }
        if (i2 == 1) {
            j = nestedScrollNode$onPreFling$1.J$0;
            nestedScrollNode = (NestedScrollNode) nestedScrollNode$onPreFling$1.L$0;
            ResultKt.throwOnFailure(objMo598onPreFlingQWom1Mo);
        } else {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j2 = nestedScrollNode$onPreFling$1.J$0;
            ResultKt.throwOnFailure(objMo598onPreFlingQWom1Mo);
        }
        return Velocity.m3878boximpl(Velocity.m3891plusAH228Gc(j2, ((Velocity) objMo598onPreFlingQWom1Mo).m3896unboximpl()));
        jM3898getZero9UxMQ8M = ((Velocity) objMo598onPreFlingQWom1Mo).m3896unboximpl();
        NestedScrollConnection nestedScrollConnection2 = nestedScrollNode.connection;
        long jM3890minusAH228Gc2 = Velocity.m3890minusAH228Gc(j, jM3898getZero9UxMQ8M);
        nestedScrollNode$onPreFling$1.L$0 = null;
        nestedScrollNode$onPreFling$1.J$0 = jM3898getZero9UxMQ8M;
        nestedScrollNode$onPreFling$1.label = 2;
        objMo598onPreFlingQWom1Mo = nestedScrollConnection2.mo598onPreFlingQWom1Mo(jM3890minusAH228Gc2, nestedScrollNode$onPreFling$1);
        if (objMo598onPreFlingQWom1Mo == coroutine_suspended) {
            return coroutine_suspended;
        }
        j2 = jM3898getZero9UxMQ8M;
        return Velocity.m3878boximpl(Velocity.m3891plusAH228Gc(j2, ((Velocity) objMo598onPreFlingQWom1Mo).m3896unboximpl()));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
    public Object mo596onPostFlingRZ2iAVY(long j, long j2, @NotNull Continuation<? super Velocity> continuation) {
        NestedScrollNode$onPostFling$1 nestedScrollNode$onPostFling$1;
        long j3;
        long j4;
        NestedScrollNode nestedScrollNode;
        long jM3898getZero9UxMQ8M;
        long j5;
        long j6;
        if (continuation instanceof NestedScrollNode$onPostFling$1) {
            nestedScrollNode$onPostFling$1 = (NestedScrollNode$onPostFling$1) continuation;
            int i = nestedScrollNode$onPostFling$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                nestedScrollNode$onPostFling$1.label = i - Integer.MIN_VALUE;
            } else {
                nestedScrollNode$onPostFling$1 = new NestedScrollNode$onPostFling$1(this, continuation);
            }
        } else {
            nestedScrollNode$onPostFling$1 = new NestedScrollNode$onPostFling$1(this, continuation);
        }
        Object objMo596onPostFlingRZ2iAVY = nestedScrollNode$onPostFling$1.result;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = nestedScrollNode$onPostFling$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objMo596onPostFlingRZ2iAVY);
            NestedScrollConnection nestedScrollConnection = this.connection;
            nestedScrollNode$onPostFling$1.L$0 = this;
            j3 = j;
            nestedScrollNode$onPostFling$1.J$0 = j3;
            j4 = j2;
            nestedScrollNode$onPostFling$1.J$1 = j4;
            nestedScrollNode$onPostFling$1.label = 1;
            objMo596onPostFlingRZ2iAVY = nestedScrollConnection.mo596onPostFlingRZ2iAVY(j, j2, nestedScrollNode$onPostFling$1);
            if (objMo596onPostFlingRZ2iAVY == coroutine_suspended) {
                return coroutine_suspended;
            }
            nestedScrollNode = this;
        } else {
            if (i2 == 1) {
                long j7 = nestedScrollNode$onPostFling$1.J$1;
                long j8 = nestedScrollNode$onPostFling$1.J$0;
                nestedScrollNode = (NestedScrollNode) nestedScrollNode$onPostFling$1.L$0;
                ResultKt.throwOnFailure(objMo596onPostFlingRZ2iAVY);
                j4 = j7;
                j3 = j8;
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j6 = nestedScrollNode$onPostFling$1.J$0;
                ResultKt.throwOnFailure(objMo596onPostFlingRZ2iAVY);
            }
            jM3898getZero9UxMQ8M = ((Velocity) objMo596onPostFlingRZ2iAVY).m3896unboximpl();
            j5 = j6;
            return Velocity.m3878boximpl(Velocity.m3891plusAH228Gc(j5, jM3898getZero9UxMQ8M));
        }
        long jM3896unboximpl = ((Velocity) objMo596onPostFlingRZ2iAVY).m3896unboximpl();
        NestedScrollConnection parentConnection = nestedScrollNode.getParentConnection();
        if (parentConnection != null) {
            long jM3891plusAH228Gc = Velocity.m3891plusAH228Gc(j3, jM3896unboximpl);
            long jM3890minusAH228Gc = Velocity.m3890minusAH228Gc(j4, jM3896unboximpl);
            nestedScrollNode$onPostFling$1.L$0 = null;
            nestedScrollNode$onPostFling$1.J$0 = jM3896unboximpl;
            nestedScrollNode$onPostFling$1.label = 2;
            objMo596onPostFlingRZ2iAVY = parentConnection.mo596onPostFlingRZ2iAVY(jM3891plusAH228Gc, jM3890minusAH228Gc, nestedScrollNode$onPostFling$1);
            if (objMo596onPostFlingRZ2iAVY == coroutine_suspended) {
                return coroutine_suspended;
            }
            j6 = jM3896unboximpl;
            jM3898getZero9UxMQ8M = ((Velocity) objMo596onPostFlingRZ2iAVY).m3896unboximpl();
            j5 = j6;
        } else {
            jM3898getZero9UxMQ8M = Velocity.Companion.m3898getZero9UxMQ8M();
            j5 = jM3896unboximpl;
        }
        return Velocity.m3878boximpl(Velocity.m3891plusAH228Gc(j5, jM3898getZero9UxMQ8M));
    }

    private final void updateDispatcher(NestedScrollDispatcher nestedScrollDispatcher) {
        resetDispatcherFields();
        if (nestedScrollDispatcher == null) {
            this.resolvedDispatcher = new NestedScrollDispatcher();
        } else if (!Intrinsics.areEqual(nestedScrollDispatcher, this.resolvedDispatcher)) {
            this.resolvedDispatcher = nestedScrollDispatcher;
        }
        if (isAttached()) {
            updateDispatcherFields();
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        updateDispatcherFields();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        resetDispatcherFields();
    }

    private final void updateDispatcherFields() {
        this.resolvedDispatcher.setNestedScrollNode$ui_release(this);
        this.resolvedDispatcher.setCalculateNestedScrollScope$ui_release(new Function0<CoroutineScope>() { // from class: androidx.compose.ui.input.nestedscroll.NestedScrollNode.updateDispatcherFields.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final CoroutineScope invoke() {
                return NestedScrollNode.this.getNestedCoroutineScope();
            }
        });
        this.resolvedDispatcher.setScope$ui_release(getCoroutineScope());
    }

    private final void resetDispatcherFields() {
        if (this.resolvedDispatcher.getNestedScrollNode$ui_release() == this) {
            this.resolvedDispatcher.setNestedScrollNode$ui_release(null);
        }
    }

    public final void updateNode$ui_release(@NotNull NestedScrollConnection nestedScrollConnection, @Nullable NestedScrollDispatcher nestedScrollDispatcher) {
        this.connection = nestedScrollConnection;
        updateDispatcher(nestedScrollDispatcher);
    }
}
