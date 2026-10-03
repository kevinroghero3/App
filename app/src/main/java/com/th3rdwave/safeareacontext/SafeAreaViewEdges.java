package com.th3rdwave.safeareacontext;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class SafeAreaViewEdges {
    private final SafeAreaViewEdgeModes bottom;
    private final SafeAreaViewEdgeModes left;
    private final SafeAreaViewEdgeModes right;
    private final SafeAreaViewEdgeModes top;

    public static /* synthetic */ SafeAreaViewEdges copy$default(SafeAreaViewEdges safeAreaViewEdges, SafeAreaViewEdgeModes safeAreaViewEdgeModes, SafeAreaViewEdgeModes safeAreaViewEdgeModes2, SafeAreaViewEdgeModes safeAreaViewEdgeModes3, SafeAreaViewEdgeModes safeAreaViewEdgeModes4, int i, Object obj) {
        if ((i & 1) != 0) {
            safeAreaViewEdgeModes = safeAreaViewEdges.top;
        }
        if ((i & 2) != 0) {
            safeAreaViewEdgeModes2 = safeAreaViewEdges.right;
        }
        if ((i & 4) != 0) {
            safeAreaViewEdgeModes3 = safeAreaViewEdges.bottom;
        }
        if ((i & 8) != 0) {
            safeAreaViewEdgeModes4 = safeAreaViewEdges.left;
        }
        return safeAreaViewEdges.copy(safeAreaViewEdgeModes, safeAreaViewEdgeModes2, safeAreaViewEdgeModes3, safeAreaViewEdgeModes4);
    }

    public final SafeAreaViewEdgeModes component1() {
        return this.top;
    }

    public final SafeAreaViewEdgeModes component2() {
        return this.right;
    }

    public final SafeAreaViewEdgeModes component3() {
        return this.bottom;
    }

    public final SafeAreaViewEdgeModes component4() {
        return this.left;
    }

    public final SafeAreaViewEdges copy(@NotNull SafeAreaViewEdgeModes top, @NotNull SafeAreaViewEdgeModes right, @NotNull SafeAreaViewEdgeModes bottom, @NotNull SafeAreaViewEdgeModes left) {
        Intrinsics.checkNotNullParameter(top, "top");
        Intrinsics.checkNotNullParameter(right, "right");
        Intrinsics.checkNotNullParameter(bottom, "bottom");
        Intrinsics.checkNotNullParameter(left, "left");
        return new SafeAreaViewEdges(top, right, bottom, left);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SafeAreaViewEdges)) {
            return false;
        }
        SafeAreaViewEdges safeAreaViewEdges = (SafeAreaViewEdges) obj;
        return this.top == safeAreaViewEdges.top && this.right == safeAreaViewEdges.right && this.bottom == safeAreaViewEdges.bottom && this.left == safeAreaViewEdges.left;
    }

    public int hashCode() {
        return (((((this.top.hashCode() * 31) + this.right.hashCode()) * 31) + this.bottom.hashCode()) * 31) + this.left.hashCode();
    }

    public String toString() {
        return "SafeAreaViewEdges(top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + ", left=" + this.left + ")";
    }

    public SafeAreaViewEdges(@NotNull SafeAreaViewEdgeModes top, @NotNull SafeAreaViewEdgeModes right, @NotNull SafeAreaViewEdgeModes bottom, @NotNull SafeAreaViewEdgeModes left) {
        Intrinsics.checkNotNullParameter(top, "top");
        Intrinsics.checkNotNullParameter(right, "right");
        Intrinsics.checkNotNullParameter(bottom, "bottom");
        Intrinsics.checkNotNullParameter(left, "left");
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        this.left = left;
    }

    public final SafeAreaViewEdgeModes getTop() {
        return this.top;
    }

    public final SafeAreaViewEdgeModes getRight() {
        return this.right;
    }

    public final SafeAreaViewEdgeModes getBottom() {
        return this.bottom;
    }

    public final SafeAreaViewEdgeModes getLeft() {
        return this.left;
    }
}
