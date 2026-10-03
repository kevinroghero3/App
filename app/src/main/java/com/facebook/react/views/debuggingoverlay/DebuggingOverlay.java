package com.facebook.react.views.debuggingoverlay;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import com.facebook.react.bridge.UiThreadUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public final class DebuggingOverlay extends View {
    private final Paint highlightedElementsPaint;
    private List<RectF> highlightedElementsRectangles;
    private final HashMap<Integer, Runnable> traceUpdateIdToCleanupRunnableMap;
    private final Paint traceUpdatePaint;
    private final HashMap<Integer, TraceUpdate> traceUpdatesToDisplayMap;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebuggingOverlay(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Paint paint = new Paint();
        this.traceUpdatePaint = paint;
        this.traceUpdatesToDisplayMap = new HashMap<>();
        this.traceUpdateIdToCleanupRunnableMap = new HashMap<>();
        Paint paint2 = new Paint();
        this.highlightedElementsPaint = paint2;
        this.highlightedElementsRectangles = new ArrayList();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(6.0f);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setColor(-859248897);
    }

    public final void setTraceUpdates(@NotNull List<TraceUpdate> traceUpdates) {
        Intrinsics.checkNotNullParameter(traceUpdates, "traceUpdates");
        for (TraceUpdate traceUpdate : traceUpdates) {
            int id = traceUpdate.getId();
            if (this.traceUpdateIdToCleanupRunnableMap.containsKey(Integer.valueOf(id))) {
                UiThreadUtil.removeOnUiThread(this.traceUpdateIdToCleanupRunnableMap.get(Integer.valueOf(id)));
                this.traceUpdateIdToCleanupRunnableMap.remove(Integer.valueOf(id));
            }
            this.traceUpdatesToDisplayMap.put(Integer.valueOf(id), traceUpdate);
        }
        invalidate();
    }

    public final void setHighlightedElementsRectangles(@NotNull List<RectF> elementsRectangles) {
        Intrinsics.checkNotNullParameter(elementsRectangles, "elementsRectangles");
        this.highlightedElementsRectangles = elementsRectangles;
        invalidate();
    }

    public final void clearElementsHighlights() {
        this.highlightedElementsRectangles.clear();
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        for (TraceUpdate traceUpdate : this.traceUpdatesToDisplayMap.values()) {
            Intrinsics.checkNotNullExpressionValue(traceUpdate, "next(...)");
            TraceUpdate traceUpdate2 = traceUpdate;
            this.traceUpdatePaint.setColor(traceUpdate2.getColor());
            canvas.drawRect(traceUpdate2.getRectangle(), this.traceUpdatePaint);
            final int id = traceUpdate2.getId();
            Runnable runnable = new Runnable() { // from class: com.facebook.react.views.debuggingoverlay.DebuggingOverlay$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    DebuggingOverlay.onDraw$lambda$0(this.f$0, id);
                }
            };
            if (!this.traceUpdateIdToCleanupRunnableMap.containsKey(Integer.valueOf(id))) {
                this.traceUpdateIdToCleanupRunnableMap.put(Integer.valueOf(id), runnable);
                UiThreadUtil.runOnUiThread(runnable, 2000L);
            }
        }
        Iterator<RectF> it2 = this.highlightedElementsRectangles.iterator();
        while (it2.hasNext()) {
            canvas.drawRect(it2.next(), this.highlightedElementsPaint);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onDraw$lambda$0(DebuggingOverlay debuggingOverlay, int i) {
        debuggingOverlay.traceUpdatesToDisplayMap.remove(Integer.valueOf(i));
        debuggingOverlay.traceUpdateIdToCleanupRunnableMap.remove(Integer.valueOf(i));
        debuggingOverlay.invalidate();
    }
}
