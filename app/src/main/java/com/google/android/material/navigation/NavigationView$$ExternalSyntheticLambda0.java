package com.google.android.material.navigation;

import android.graphics.Canvas;
import android.os.Process;
import com.google.android.material.canvas.CanvasCompat;

/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class NavigationView$$ExternalSyntheticLambda0 implements CanvasCompat.CanvasOperation {
    public static int d;
    public static int e;
    public final /* synthetic */ NavigationView f$0;

    public /* synthetic */ NavigationView$$ExternalSyntheticLambda0(NavigationView navigationView) {
        this.f$0 = navigationView;
    }

    @Override // com.google.android.material.canvas.CanvasCompat.CanvasOperation
    public final void run(Canvas canvas) {
        this.f$0.lambda$dispatchDraw$0(canvas);
    }

    public static int f() {
        int i = d;
        int i2 = i % 6462388;
        d = i + 1;
        if (i2 != 0) {
            return e;
        }
        int iMyTid = Process.myTid();
        e = iMyTid;
        return iMyTid;
    }
}
