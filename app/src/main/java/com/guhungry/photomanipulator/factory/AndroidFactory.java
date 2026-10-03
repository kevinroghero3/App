package com.guhungry.photomanipulator.factory;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public interface AndroidFactory {
    Canvas makeCanvas(@NotNull Bitmap bitmap);

    Paint makePaint();

    Point makePoint(int i, int i2);

    Rect makeRect(int i, int i2, int i3, int i4);

    Uri makeUri(@NotNull String str);
}
