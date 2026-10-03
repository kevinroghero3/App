package com.salesforce.marketingcloud.messages.iam;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.constraintlayout.widget.ConstraintLayout;

/* JADX INFO: loaded from: classes3.dex */
public class ClippingConstraintLayout extends ConstraintLayout {
    private float borderWidth;
    private float cornerRadius;
    private Path path;
    private RectF rect;
    private Rect tmpRect;

    public ClippingConstraintLayout(Context context) {
        super(context);
        this.path = new Path();
        this.rect = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.tmpRect = new Rect(0, 0, 0, 0);
        init();
    }

    private void init() {
        Resources resources = getResources();
        this.cornerRadius = (float) Math.floor(TypedValue.applyDimension(1, 30.0f, resources.getDisplayMetrics()));
        this.borderWidth = TypedValue.applyDimension(1, 3.0f, resources.getDisplayMetrics());
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        int iSave = canvas.save();
        canvas.clipPath(this.path);
        super.dispatchDraw(canvas);
        canvas.restoreToCount(iSave);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.path.reset();
        getDrawingRect(this.tmpRect);
        RectF rectF = this.rect;
        Rect rect = this.tmpRect;
        float f = rect.left;
        float f2 = this.borderWidth;
        rectF.set(f + f2, rect.top + f2, rect.right - f2, rect.bottom - f2);
        Path path = this.path;
        RectF rectF2 = this.rect;
        float f3 = this.cornerRadius;
        path.addRoundRect(rectF2, f3, f3, Path.Direction.CW);
        this.path.close();
    }

    public void setClippingDetails(float f, float f2) {
        if (this.borderWidth == f && this.cornerRadius == f2) {
            return;
        }
        this.borderWidth = f;
        this.cornerRadius = (float) Math.floor(f2);
        invalidate();
    }

    public ClippingConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.path = new Path();
        this.rect = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.tmpRect = new Rect(0, 0, 0, 0);
        init();
    }

    public ClippingConstraintLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.path = new Path();
        this.rect = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.tmpRect = new Rect(0, 0, 0, 0);
        init();
    }
}
