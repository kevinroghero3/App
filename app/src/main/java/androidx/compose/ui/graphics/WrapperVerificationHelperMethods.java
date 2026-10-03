package androidx.compose.ui.graphics;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class WrapperVerificationHelperMethods {
    public static final WrapperVerificationHelperMethods INSTANCE = new WrapperVerificationHelperMethods();

    private WrapperVerificationHelperMethods() {
    }

    /* JADX INFO: renamed from: setBlendMode-GB0RdKg, reason: not valid java name */
    public final void m1574setBlendModeGB0RdKg(@NotNull android.graphics.Paint paint, int i) {
        paint.setBlendMode(AndroidBlendMode_androidKt.m1020toAndroidBlendModes9anfk8(i));
    }
}
