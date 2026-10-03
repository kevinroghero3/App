package com.facebook.react.views.scroll;

import android.os.SystemClock;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.util.Pools;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.events.Event;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class ScrollEvent extends Event<ScrollEvent> {
    private int contentHeight;
    private int contentWidth;
    private ScrollEventType scrollEventType;
    private int scrollViewHeight;
    private int scrollViewWidth;
    private float scrollX;
    private float scrollY;
    private long timestamp;
    private float xVelocity;
    private float yVelocity;
    public static final Companion Companion = new Companion(null);
    private static final String TAG = ScrollEvent.class.getSimpleName();
    private static final Pools.SynchronizedPool<ScrollEvent> EVENTS_POOL = new Pools.SynchronizedPool<>(3);

    public /* synthetic */ ScrollEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    public static final ScrollEvent obtain(int i, int i2, @Nullable ScrollEventType scrollEventType, float f, float f2, float f3, float f4, int i3, int i4, int i5, int i6) {
        return Companion.obtain(i, i2, scrollEventType, f, f2, f3, f4, i3, i4, i5, i6);
    }

    @Deprecated(message = "Use the obtain version that explicitly takes surfaceId as an argument", replaceWith = @ReplaceWith(expression = "obtain(surfaceId, viewTag, scrollEventType, scrollX, scrollY, xVelocity, yVelocity, contentWidth, contentHeight, scrollViewWidth, scrollViewHeight)", imports = {}))
    @JvmStatic
    public static final ScrollEvent obtain(int i, @Nullable ScrollEventType scrollEventType, float f, float f2, float f3, float f4, int i2, int i3, int i4, int i5) {
        return Companion.obtain(i, scrollEventType, f, f2, f3, f4, i2, i3, i4, i5);
    }

    private ScrollEvent() {
    }

    @Override // com.facebook.react.uimanager.events.Event
    public void onDispose() {
        try {
            EVENTS_POOL.release(this);
        } catch (IllegalStateException e) {
            String TAG2 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            ReactSoftExceptionLogger.logSoftException(TAG2, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void init(int i, int i2, ScrollEventType scrollEventType, float f, float f2, float f3, float f4, int i3, int i4, int i5, int i6) {
        super.init(i, i2);
        this.scrollEventType = scrollEventType;
        this.scrollX = f;
        this.scrollY = f2;
        this.xVelocity = f3;
        this.yVelocity = f4;
        this.contentWidth = i3;
        this.contentHeight = i4;
        this.scrollViewWidth = i5;
        this.scrollViewHeight = i6;
        this.timestamp = SystemClock.uptimeMillis();
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        ScrollEventType.Companion companion = ScrollEventType.Companion;
        Object objAssertNotNull = Assertions.assertNotNull(this.scrollEventType);
        Intrinsics.checkNotNullExpressionValue(objAssertNotNull, "assertNotNull(...)");
        return companion.getJSEventName((ScrollEventType) objAssertNotNull);
    }

    @Override // com.facebook.react.uimanager.events.Event
    public boolean canCoalesce() {
        return this.scrollEventType == ScrollEventType.SCROLL;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putDouble("top", 0.0d);
        writableMapCreateMap.putDouble(ViewProps.BOTTOM, 0.0d);
        writableMapCreateMap.putDouble("left", 0.0d);
        writableMapCreateMap.putDouble(ViewProps.RIGHT, 0.0d);
        WritableMap writableMapCreateMap2 = Arguments.createMap();
        writableMapCreateMap2.putDouble("x", PixelUtil.toDIPFromPixel(this.scrollX));
        writableMapCreateMap2.putDouble("y", PixelUtil.toDIPFromPixel(this.scrollY));
        WritableMap writableMapCreateMap3 = Arguments.createMap();
        writableMapCreateMap3.putDouble("width", PixelUtil.toDIPFromPixel(this.contentWidth));
        writableMapCreateMap3.putDouble("height", PixelUtil.toDIPFromPixel(this.contentHeight));
        WritableMap writableMapCreateMap4 = Arguments.createMap();
        writableMapCreateMap4.putDouble("width", PixelUtil.toDIPFromPixel(this.scrollViewWidth));
        writableMapCreateMap4.putDouble("height", PixelUtil.toDIPFromPixel(this.scrollViewHeight));
        WritableMap writableMapCreateMap5 = Arguments.createMap();
        writableMapCreateMap5.putDouble("x", this.xVelocity);
        writableMapCreateMap5.putDouble("y", this.yVelocity);
        WritableMap writableMapCreateMap6 = Arguments.createMap();
        writableMapCreateMap6.putMap("contentInset", writableMapCreateMap);
        writableMapCreateMap6.putMap("contentOffset", writableMapCreateMap2);
        writableMapCreateMap6.putMap("contentSize", writableMapCreateMap3);
        writableMapCreateMap6.putMap("layoutMeasurement", writableMapCreateMap4);
        writableMapCreateMap6.putMap("velocity", writableMapCreateMap5);
        writableMapCreateMap6.putInt(TypedValues.AttributesType.S_TARGET, getViewTag());
        writableMapCreateMap6.putDouble("timestamp", this.timestamp);
        writableMapCreateMap6.putBoolean("responderIgnoreScroll", true);
        Intrinsics.checkNotNull(writableMapCreateMap6);
        return writableMapCreateMap6;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ScrollEvent obtain(int i, int i2, @Nullable ScrollEventType scrollEventType, float f, float f2, float f3, float f4, int i3, int i4, int i5, int i6) {
            ScrollEvent scrollEvent = (ScrollEvent) ScrollEvent.EVENTS_POOL.acquire();
            if (scrollEvent == null) {
                scrollEvent = new ScrollEvent(null);
            }
            scrollEvent.init(i, i2, scrollEventType, f, f2, f3, f4, i3, i4, i5, i6);
            return scrollEvent;
        }

        @Deprecated(message = "Use the obtain version that explicitly takes surfaceId as an argument", replaceWith = @ReplaceWith(expression = "obtain(surfaceId, viewTag, scrollEventType, scrollX, scrollY, xVelocity, yVelocity, contentWidth, contentHeight, scrollViewWidth, scrollViewHeight)", imports = {}))
        @JvmStatic
        public final ScrollEvent obtain(int i, @Nullable ScrollEventType scrollEventType, float f, float f2, float f3, float f4, int i2, int i3, int i4, int i5) {
            return obtain(-1, i, scrollEventType, f, f2, f3, f4, i2, i3, i4, i5);
        }
    }
}
