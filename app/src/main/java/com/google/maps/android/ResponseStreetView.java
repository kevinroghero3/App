package com.google.maps.android;

import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class ResponseStreetView {
    private final Status status;

    public static /* synthetic */ ResponseStreetView copy$default(ResponseStreetView responseStreetView, Status status, int i, Object obj) {
        if ((i & 1) != 0) {
            status = responseStreetView.status;
        }
        return responseStreetView.copy(status);
    }

    public final Status component1() {
        return this.status;
    }

    public final ResponseStreetView copy(@NotNull Status status) {
        Intrinsics.checkNotNullParameter(status, "status");
        return new ResponseStreetView(status);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ResponseStreetView) && this.status == ((ResponseStreetView) obj).status;
    }

    public int hashCode() {
        return this.status.hashCode();
    }

    public String toString() {
        return "ResponseStreetView(status=" + this.status + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public ResponseStreetView(@NotNull Status status) {
        Intrinsics.checkNotNullParameter(status, "status");
        this.status = status;
    }

    public final Status getStatus() {
        return this.status;
    }
}
