package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.OffsetKt;

/* JADX INFO: loaded from: classes4.dex */
public final class RenderEffectKt {
    /* JADX INFO: renamed from: BlurEffect-3YTHUZs$default, reason: not valid java name */
    public static /* synthetic */ BlurEffect m1480BlurEffect3YTHUZs$default(float f, float f2, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = TileMode.Companion.m1544getClamp3opZhB0();
        }
        return m1479BlurEffect3YTHUZs(f, f2, i);
    }

    /* JADX INFO: renamed from: BlurEffect-3YTHUZs, reason: not valid java name */
    public static final BlurEffect m1479BlurEffect3YTHUZs(float f, float f2, int i) {
        return new BlurEffect(null, f, f2, i, null);
    }

    public static final OffsetEffect OffsetEffect(float f, float f2) {
        return new OffsetEffect(null, OffsetKt.Offset(f, f2), null);
    }
}
