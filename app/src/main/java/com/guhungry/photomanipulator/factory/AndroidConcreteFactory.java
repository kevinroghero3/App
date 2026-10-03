package com.guhungry.photomanipulator.factory;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidConcreteFactory implements AndroidFactory {
    @Override // com.guhungry.photomanipulator.factory.AndroidFactory
    public Point makePoint(int i, int i2) {
        return new Point(i, i2);
    }

    @Override // com.guhungry.photomanipulator.factory.AndroidFactory
    public Rect makeRect(int i, int i2, int i3, int i4) {
        return new Rect(i, i2, i3, i4);
    }

    @Override // com.guhungry.photomanipulator.factory.AndroidFactory
    public Uri makeUri(@NotNull String uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Uri uri2 = Uri.parse(uri);
        Intrinsics.checkNotNullExpressionValue(uri2, "parse(uri)");
        return uri2;
    }

    @Override // com.guhungry.photomanipulator.factory.AndroidFactory
    public Canvas makeCanvas(@NotNull Bitmap image) {
        Intrinsics.checkNotNullParameter(image, "image");
        return new Canvas(image);
    }

    @Override // com.guhungry.photomanipulator.factory.AndroidFactory
    public Paint makePaint() {
        return new Paint();
    }
}
