package androidx.compose.ui.layout;

import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public abstract class Ruler {
    public static final int $stable = 0;

    public /* synthetic */ Ruler(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract float calculateCoordinate$ui_release(float f, @NotNull LayoutCoordinates layoutCoordinates, @NotNull LayoutCoordinates layoutCoordinates2);

    private Ruler() {
    }
}
