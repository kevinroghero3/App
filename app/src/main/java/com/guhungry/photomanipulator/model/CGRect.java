package com.guhungry.photomanipulator.model;

import android.graphics.Point;
import android.graphics.Rect;
import com.guhungry.photomanipulator.factory.AndroidConcreteFactory;
import com.guhungry.photomanipulator.factory.AndroidFactory;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class CGRect {
    private final AndroidFactory factory;
    private final Point origin;
    private final CGSize size;

    public CGRect(int i, int i2, int i3, int i4) {
        this(i, i2, i3, i4, null, 16, null);
    }

    public CGRect(@NotNull Point origin, @NotNull CGSize size, @NotNull AndroidFactory factory) {
        Intrinsics.checkNotNullParameter(origin, "origin");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(factory, "factory");
        this.origin = origin;
        this.size = size;
        this.factory = factory;
    }

    public /* synthetic */ CGRect(Point point, CGSize cGSize, AndroidFactory androidFactory, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(point, cGSize, (i & 4) != 0 ? new AndroidConcreteFactory() : androidFactory);
    }

    public final Point getOrigin() {
        return this.origin;
    }

    public final CGSize getSize() {
        return this.size;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CGRect(int i, int i2, int i3, int i4, @NotNull AndroidFactory factory) {
        this(factory.makePoint(i, i2), new CGSize(i3, i4), factory);
        Intrinsics.checkNotNullParameter(factory, "factory");
    }

    public /* synthetic */ CGRect(int i, int i2, int i3, int i4, AndroidFactory androidFactory, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, i4, (i5 & 16) != 0 ? new AndroidConcreteFactory() : androidFactory);
    }

    public final Rect toRect() {
        AndroidFactory androidFactory = this.factory;
        Point point = this.origin;
        int i = point.x;
        return androidFactory.makeRect(i, point.y, this.size.getWidth() + i, this.origin.y + this.size.getHeight());
    }
}
