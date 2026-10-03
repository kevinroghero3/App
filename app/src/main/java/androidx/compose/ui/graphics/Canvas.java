package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public interface Canvas {
    /* JADX INFO: renamed from: clipPath-mtrdD-E */
    void mo1022clipPathmtrdDE(@NotNull Path path, int i);

    /* JADX INFO: renamed from: clipRect-N_I0leg */
    void mo1023clipRectN_I0leg(float f, float f2, float f3, float f4, int i);

    /* JADX INFO: renamed from: concat-58bKbWc */
    void mo1024concat58bKbWc(@NotNull float[] fArr);

    void disableZ();

    void drawArc(float f, float f2, float f3, float f4, float f5, float f6, boolean z, @NotNull Paint paint);

    /* JADX INFO: renamed from: drawCircle-9KIMszo */
    void mo1025drawCircle9KIMszo(long j, float f, @NotNull Paint paint);

    /* JADX INFO: renamed from: drawImage-d-4ec7I */
    void mo1026drawImaged4ec7I(@NotNull ImageBitmap imageBitmap, long j, @NotNull Paint paint);

    /* JADX INFO: renamed from: drawImageRect-HPBpro0 */
    void mo1027drawImageRectHPBpro0(@NotNull ImageBitmap imageBitmap, long j, long j2, long j3, long j4, @NotNull Paint paint);

    /* JADX INFO: renamed from: drawLine-Wko1d7g */
    void mo1028drawLineWko1d7g(long j, long j2, @NotNull Paint paint);

    void drawOval(float f, float f2, float f3, float f4, @NotNull Paint paint);

    void drawPath(@NotNull Path path, @NotNull Paint paint);

    /* JADX INFO: renamed from: drawPoints-O7TthRY */
    void mo1029drawPointsO7TthRY(int i, @NotNull List<Offset> list, @NotNull Paint paint);

    /* JADX INFO: renamed from: drawRawPoints-O7TthRY */
    void mo1030drawRawPointsO7TthRY(int i, @NotNull float[] fArr, @NotNull Paint paint);

    void drawRect(float f, float f2, float f3, float f4, @NotNull Paint paint);

    void drawRoundRect(float f, float f2, float f3, float f4, float f5, float f6, @NotNull Paint paint);

    /* JADX INFO: renamed from: drawVertices-TPEHhCM */
    void mo1031drawVerticesTPEHhCM(@NotNull Vertices vertices, int i, @NotNull Paint paint);

    void enableZ();

    void restore();

    void rotate(float f);

    void save();

    void saveLayer(@NotNull Rect rect, @NotNull Paint paint);

    void scale(float f, float f2);

    void skew(float f, float f2);

    void translate(float f, float f2);

    /* JADX INFO: loaded from: classes4.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static void skewRad(@NotNull Canvas canvas, float f, float f2) {
            Canvas.super.skewRad(f, f2);
        }

        @Deprecated
        /* JADX INFO: renamed from: clipRect-mtrdD-E, reason: not valid java name */
        public static void m1147clipRectmtrdDE(@NotNull Canvas canvas, @NotNull Rect rect, int i) {
            Canvas.super.m1144clipRectmtrdDE(rect, i);
        }

        @Deprecated
        public static void drawRect(@NotNull Canvas canvas, @NotNull Rect rect, @NotNull Paint paint) {
            Canvas.super.drawRect(rect, paint);
        }

        @Deprecated
        public static void drawOval(@NotNull Canvas canvas, @NotNull Rect rect, @NotNull Paint paint) {
            Canvas.super.drawOval(rect, paint);
        }

        @Deprecated
        public static void drawArc(@NotNull Canvas canvas, @NotNull Rect rect, float f, float f2, boolean z, @NotNull Paint paint) {
            Canvas.super.drawArc(rect, f, f2, z, paint);
        }

        @Deprecated
        public static void drawArcRad(@NotNull Canvas canvas, @NotNull Rect rect, float f, float f2, boolean z, @NotNull Paint paint) {
            Canvas.super.drawArcRad(rect, f, f2, z, paint);
        }
    }

    static /* synthetic */ void scale$default(Canvas canvas, float f, float f2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scale");
        }
        if ((i & 2) != 0) {
            f2 = f;
        }
        canvas.scale(f, f2);
    }

    default void skewRad(float f, float f2) {
        skew(DegreesKt.degrees(f), DegreesKt.degrees(f2));
    }

    /* JADX INFO: renamed from: clipRect-mtrdD-E$default, reason: not valid java name */
    static /* synthetic */ void m1142clipRectmtrdDE$default(Canvas canvas, Rect rect, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clipRect-mtrdD-E");
        }
        if ((i2 & 2) != 0) {
            i = ClipOp.Companion.m1158getIntersectrtfAjoo();
        }
        canvas.m1144clipRectmtrdDE(rect, i);
    }

    /* JADX INFO: renamed from: clipRect-mtrdD-E, reason: not valid java name */
    default void m1144clipRectmtrdDE(@NotNull Rect rect, int i) {
        mo1023clipRectN_I0leg(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), i);
    }

    /* JADX INFO: renamed from: clipRect-N_I0leg$default, reason: not valid java name */
    static /* synthetic */ void m1141clipRectN_I0leg$default(Canvas canvas, float f, float f2, float f3, float f4, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clipRect-N_I0leg");
        }
        if ((i2 & 16) != 0) {
            i = ClipOp.Companion.m1158getIntersectrtfAjoo();
        }
        canvas.mo1023clipRectN_I0leg(f, f2, f3, f4, i);
    }

    /* JADX INFO: renamed from: clipPath-mtrdD-E$default, reason: not valid java name */
    static /* synthetic */ void m1140clipPathmtrdDE$default(Canvas canvas, Path path, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clipPath-mtrdD-E");
        }
        if ((i2 & 2) != 0) {
            i = ClipOp.Companion.m1158getIntersectrtfAjoo();
        }
        canvas.mo1022clipPathmtrdDE(path, i);
    }

    default void drawRect(@NotNull Rect rect, @NotNull Paint paint) {
        drawRect(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), paint);
    }

    default void drawOval(@NotNull Rect rect, @NotNull Paint paint) {
        drawOval(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), paint);
    }

    default void drawArc(@NotNull Rect rect, float f, float f2, boolean z, @NotNull Paint paint) {
        drawArc(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), f, f2, z, paint);
    }

    default void drawArcRad(@NotNull Rect rect, float f, float f2, boolean z, @NotNull Paint paint) {
        drawArc(rect, DegreesKt.degrees(f), DegreesKt.degrees(f2), z, paint);
    }

    /* JADX INFO: renamed from: drawImageRect-HPBpro0$default, reason: not valid java name */
    static /* synthetic */ void m1143drawImageRectHPBpro0$default(Canvas canvas, ImageBitmap imageBitmap, long j, long j2, long j3, long j4, Paint paint, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawImageRect-HPBpro0");
        }
        long jM3788getZeronOccac = (i & 2) != 0 ? IntOffset.Companion.m3788getZeronOccac() : j;
        long jIntSize = (i & 4) != 0 ? IntSizeKt.IntSize(imageBitmap.getWidth(), imageBitmap.getHeight()) : j2;
        canvas.mo1027drawImageRectHPBpro0(imageBitmap, jM3788getZeronOccac, jIntSize, (i & 8) != 0 ? IntOffset.Companion.m3788getZeronOccac() : j3, (i & 16) != 0 ? jIntSize : j4, paint);
    }
}
