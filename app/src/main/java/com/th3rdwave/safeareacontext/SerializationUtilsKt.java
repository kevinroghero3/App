package com.th3rdwave.safeareacontext;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ViewProps;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class SerializationUtilsKt {
    public static final WritableMap edgeInsetsToJsMap(@NotNull EdgeInsets insets) {
        Intrinsics.checkNotNullParameter(insets, "insets");
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putDouble("top", PixelUtil.toDIPFromPixel(insets.getTop()));
        writableMapCreateMap.putDouble(ViewProps.RIGHT, PixelUtil.toDIPFromPixel(insets.getRight()));
        writableMapCreateMap.putDouble(ViewProps.BOTTOM, PixelUtil.toDIPFromPixel(insets.getBottom()));
        writableMapCreateMap.putDouble("left", PixelUtil.toDIPFromPixel(insets.getLeft()));
        Intrinsics.checkNotNull(writableMapCreateMap);
        return writableMapCreateMap;
    }

    public static final Map<String, Float> edgeInsetsToJavaMap(@NotNull EdgeInsets insets) {
        Intrinsics.checkNotNullParameter(insets, "insets");
        return MapsKt__MapsKt.mapOf(TuplesKt.to("top", Float.valueOf(PixelUtil.toDIPFromPixel(insets.getTop()))), TuplesKt.to(ViewProps.RIGHT, Float.valueOf(PixelUtil.toDIPFromPixel(insets.getRight()))), TuplesKt.to(ViewProps.BOTTOM, Float.valueOf(PixelUtil.toDIPFromPixel(insets.getBottom()))), TuplesKt.to("left", Float.valueOf(PixelUtil.toDIPFromPixel(insets.getLeft()))));
    }

    public static final WritableMap rectToJsMap(@NotNull Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putDouble("x", PixelUtil.toDIPFromPixel(rect.getX()));
        writableMapCreateMap.putDouble("y", PixelUtil.toDIPFromPixel(rect.getY()));
        writableMapCreateMap.putDouble("width", PixelUtil.toDIPFromPixel(rect.getWidth()));
        writableMapCreateMap.putDouble("height", PixelUtil.toDIPFromPixel(rect.getHeight()));
        Intrinsics.checkNotNull(writableMapCreateMap);
        return writableMapCreateMap;
    }

    public static final Map<String, Float> rectToJavaMap(@NotNull Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        return MapsKt__MapsKt.mapOf(TuplesKt.to("x", Float.valueOf(PixelUtil.toDIPFromPixel(rect.getX()))), TuplesKt.to("y", Float.valueOf(PixelUtil.toDIPFromPixel(rect.getY()))), TuplesKt.to("width", Float.valueOf(PixelUtil.toDIPFromPixel(rect.getWidth()))), TuplesKt.to("height", Float.valueOf(PixelUtil.toDIPFromPixel(rect.getHeight()))));
    }
}
