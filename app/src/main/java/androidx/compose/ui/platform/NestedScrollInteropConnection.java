package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.unit.Velocity;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ViewCompat;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class NestedScrollInteropConnection implements NestedScrollConnection {
    public static final int $stable = 8;
    private final int[] consumedScrollCache;
    private final NestedScrollingChildHelper nestedScrollChildHelper;
    private final View view;

    public NestedScrollInteropConnection(@NotNull View view) {
        this.view = view;
        NestedScrollingChildHelper nestedScrollingChildHelper = new NestedScrollingChildHelper(view);
        nestedScrollingChildHelper.setNestedScrollingEnabled(true);
        this.nestedScrollChildHelper = nestedScrollingChildHelper;
        this.consumedScrollCache = new int[2];
        ViewCompat.setNestedScrollingEnabled(view, true);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreScroll-OzD1aCk */
    public long mo599onPreScrollOzD1aCk(long j, int i) {
        if (this.nestedScrollChildHelper.startNestedScroll(NestedScrollInteropConnectionKt.m2912getScrollAxesk4lQ0M(j), NestedScrollInteropConnectionKt.m2914toViewTypeGyEprt8(i))) {
            ArraysKt___ArraysJvmKt.fill$default(this.consumedScrollCache, 0, 0, 0, 6, (Object) null);
            this.nestedScrollChildHelper.dispatchNestedPreScroll(NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m928getXimpl(j)), NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m929getYimpl(j)), this.consumedScrollCache, null, NestedScrollInteropConnectionKt.m2914toViewTypeGyEprt8(i));
            return NestedScrollInteropConnectionKt.m2913toOffsetUv8p0NA(this.consumedScrollCache, j);
        }
        return Offset.Companion.m944getZeroF1C5BW0();
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
    public long mo597onPostScrollDzOQY0M(long j, long j2, int i) {
        if (this.nestedScrollChildHelper.startNestedScroll(NestedScrollInteropConnectionKt.m2912getScrollAxesk4lQ0M(j2), NestedScrollInteropConnectionKt.m2914toViewTypeGyEprt8(i))) {
            ArraysKt___ArraysJvmKt.fill$default(this.consumedScrollCache, 0, 0, 0, 6, (Object) null);
            this.nestedScrollChildHelper.dispatchNestedScroll(NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m928getXimpl(j)), NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m929getYimpl(j)), NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m928getXimpl(j2)), NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m929getYimpl(j2)), null, NestedScrollInteropConnectionKt.m2914toViewTypeGyEprt8(i), this.consumedScrollCache);
            return NestedScrollInteropConnectionKt.m2913toOffsetUv8p0NA(this.consumedScrollCache, j2);
        }
        return Offset.Companion.m944getZeroF1C5BW0();
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreFling-QWom1Mo */
    public Object mo598onPreFlingQWom1Mo(long j, @NotNull Continuation<? super Velocity> continuation) {
        if (!this.nestedScrollChildHelper.dispatchNestedPreFling(NestedScrollInteropConnectionKt.toViewVelocity(Velocity.m3887getXimpl(j)), NestedScrollInteropConnectionKt.toViewVelocity(Velocity.m3888getYimpl(j)))) {
            j = Velocity.Companion.m3898getZero9UxMQ8M();
        }
        interruptOngoingScrolls();
        return Velocity.m3878boximpl(j);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
    public Object mo596onPostFlingRZ2iAVY(long j, long j2, @NotNull Continuation<? super Velocity> continuation) {
        if (!this.nestedScrollChildHelper.dispatchNestedFling(NestedScrollInteropConnectionKt.toViewVelocity(Velocity.m3887getXimpl(j2)), NestedScrollInteropConnectionKt.toViewVelocity(Velocity.m3888getYimpl(j2)), true)) {
            j2 = Velocity.Companion.m3898getZero9UxMQ8M();
        }
        interruptOngoingScrolls();
        return Velocity.m3878boximpl(j2);
    }

    private final void interruptOngoingScrolls() {
        if (this.nestedScrollChildHelper.hasNestedScrollingParent(0)) {
            this.nestedScrollChildHelper.stopNestedScroll(0);
        }
        if (this.nestedScrollChildHelper.hasNestedScrollingParent(1)) {
            this.nestedScrollChildHelper.stopNestedScroll(1);
        }
    }
}
