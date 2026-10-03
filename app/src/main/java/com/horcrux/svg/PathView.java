package com.horcrux.svg;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.facebook.react.bridge.ReactContext;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
class PathView extends RenderableView {
    private Path mPath;

    public PathView(ReactContext reactContext) {
        super(reactContext);
        PathParser.mScale = this.mScale;
        this.mPath = new Path();
    }

    public void setD(String str) {
        this.mPath = PathParser.parse(str);
        ArrayList<PathElement> arrayList = PathParser.elements;
        this.elements = arrayList;
        Iterator<PathElement> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            for (Point point : it2.next().points) {
                double d = point.x;
                double d2 = this.mScale;
                point.x = d * d2;
                point.y *= d2;
            }
        }
        invalidate();
    }

    @Override // com.horcrux.svg.RenderableView, com.horcrux.svg.VirtualView
    Path getPath(Canvas canvas, Paint paint) {
        return this.mPath;
    }
}
