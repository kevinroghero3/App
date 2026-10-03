package com.facebook.react.uimanager.events;

import android.view.MotionEvent;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.systrace.Systrace;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class TouchesHelper {
    private static final String CHANGED_TOUCHES_KEY = "changedTouches";
    private static final String LOCATION_X_KEY = "locationX";
    private static final String LOCATION_Y_KEY = "locationY";
    private static final String PAGE_X_KEY = "pageX";
    private static final String PAGE_Y_KEY = "pageY";
    private static final String POINTER_IDENTIFIER_KEY = "identifier";
    private static final String TARGET_SURFACE_KEY = "targetSurface";
    private static final String TIMESTAMP_KEY = "timestamp";
    private static final String TOUCHES_KEY = "touches";
    public static final TouchesHelper INSTANCE = new TouchesHelper();
    public static final String TARGET_KEY = TypedValues.AttributesType.S_TARGET;

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TouchEventType.values().length];
            try {
                iArr[TouchEventType.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TouchEventType.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TouchEventType.MOVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TouchEventType.CANCEL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Deprecated(message = "Not used in New Architecture")
    public static /* synthetic */ void getTARGET_KEY$annotations() {
    }

    private TouchesHelper() {
    }

    private final WritableMap[] createPointersArray(TouchEvent touchEvent) {
        MotionEvent motionEvent = touchEvent.getMotionEvent();
        WritableMap[] writableMapArr = new WritableMap[motionEvent.getPointerCount()];
        float x = motionEvent.getX();
        float viewX = touchEvent.getViewX();
        float y = motionEvent.getY();
        float viewY = touchEvent.getViewY();
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            WritableMap writableMapCreateMap = Arguments.createMap();
            PixelUtil pixelUtil = PixelUtil.INSTANCE;
            writableMapCreateMap.putDouble(PAGE_X_KEY, pixelUtil.pxToDp(motionEvent.getX(i)));
            writableMapCreateMap.putDouble(PAGE_Y_KEY, pixelUtil.pxToDp(motionEvent.getY(i)));
            float x2 = motionEvent.getX(i);
            float y2 = motionEvent.getY(i);
            writableMapCreateMap.putDouble(LOCATION_X_KEY, pixelUtil.pxToDp(x2 - (x - viewX)));
            writableMapCreateMap.putDouble(LOCATION_Y_KEY, pixelUtil.pxToDp(y2 - (y - viewY)));
            writableMapCreateMap.putInt(TARGET_SURFACE_KEY, touchEvent.getSurfaceId());
            writableMapCreateMap.putInt(TARGET_KEY, touchEvent.getViewTag());
            writableMapCreateMap.putDouble("timestamp", touchEvent.getTimestampMs());
            writableMapCreateMap.putDouble("identifier", motionEvent.getPointerId(i));
            writableMapArr[i] = writableMapCreateMap;
        }
        return writableMapArr;
    }

    @JvmStatic
    public static final void sendTouchesLegacy(@NotNull RCTEventEmitter rctEventEmitter, @NotNull TouchEvent touchEvent) {
        Intrinsics.checkNotNullParameter(rctEventEmitter, "rctEventEmitter");
        Intrinsics.checkNotNullParameter(touchEvent, "touchEvent");
        TouchEventType touchEventType = touchEvent.getTouchEventType();
        TouchesHelper touchesHelper = INSTANCE;
        WritableArray writableArray = touchesHelper.getWritableArray(false, touchesHelper.createPointersArray(touchEvent));
        MotionEvent motionEvent = touchEvent.getMotionEvent();
        WritableArray writableArrayCreateArray = Arguments.createArray();
        if (touchEventType == TouchEventType.MOVE || touchEventType == TouchEventType.CANCEL) {
            int pointerCount = motionEvent.getPointerCount();
            for (int i = 0; i < pointerCount; i++) {
                writableArrayCreateArray.pushInt(i);
            }
        } else {
            if (touchEventType != TouchEventType.START && touchEventType != TouchEventType.END) {
                throw new RuntimeException("Unknown touch type: " + touchEventType);
            }
            writableArrayCreateArray.pushInt(motionEvent.getActionIndex());
        }
        String jSEventName = TouchEventType.Companion.getJSEventName(touchEventType);
        Intrinsics.checkNotNull(writableArrayCreateArray);
        rctEventEmitter.receiveTouches(jSEventName, writableArray, writableArrayCreateArray);
    }

    /* JADX WARN: Code duplicated, block: B:32:0x009b A[Catch: all -> 0x00dd, TryCatch #0 {all -> 0x00dd, blocks: (B:3:0x002d, B:11:0x0051, B:29:0x0091, B:30:0x0095, B:32:0x009b, B:34:0x00a3, B:36:0x00be, B:12:0x0056, B:13:0x005b, B:14:0x005c, B:15:0x005f, B:17:0x0062, B:19:0x0066, B:21:0x006c, B:22:0x0071, B:23:0x007e, B:25:0x0086, B:27:0x008c), top: B:43:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:34:0x00a3 A[Catch: all -> 0x00dd, TryCatch #0 {all -> 0x00dd, blocks: (B:3:0x002d, B:11:0x0051, B:29:0x0091, B:30:0x0095, B:32:0x009b, B:34:0x00a3, B:36:0x00be, B:12:0x0056, B:13:0x005b, B:14:0x005c, B:15:0x005f, B:17:0x0062, B:19:0x0066, B:21:0x006c, B:22:0x0071, B:23:0x007e, B:25:0x0086, B:27:0x008c), top: B:43:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:35:0x00bd  */
    @JvmStatic
    public static final void sendTouchEvent(@NotNull RCTModernEventEmitter eventEmitter, @NotNull TouchEvent event) {
        WritableMap[] writableMapArr;
        WritableMap[] writableMapArr2;
        Iterator it2;
        WritableMap writableMap;
        WritableMap writableMap2;
        Intrinsics.checkNotNullParameter(eventEmitter, "eventEmitter");
        Intrinsics.checkNotNullParameter(event, "event");
        Systrace.beginSection(0L, "TouchesHelper.sentTouchEventModern(" + event.getEventName() + ")");
        try {
            TouchEventType touchEventType = event.getTouchEventType();
            MotionEvent motionEvent = event.getMotionEvent();
            WritableMap[] writableMapArrCreatePointersArray = INSTANCE.createPointersArray(event);
            int i = WhenMappings.$EnumSwitchMapping$0[touchEventType.ordinal()];
            if (i == 1) {
                WritableMap writableMap3 = writableMapArrCreatePointersArray[motionEvent.getActionIndex()];
                writableMapArr = new WritableMap[]{writableMap3 != null ? writableMap3.copy() : null};
            } else if (i == 2) {
                int actionIndex = motionEvent.getActionIndex();
                WritableMap writableMap4 = writableMapArrCreatePointersArray[actionIndex];
                writableMapArrCreatePointersArray[actionIndex] = null;
                writableMapArr = new WritableMap[]{writableMap4};
            } else {
                if (i == 3) {
                    writableMapArr = new WritableMap[writableMapArrCreatePointersArray.length];
                    for (int i2 = 0; i2 < writableMapArrCreatePointersArray.length; i2++) {
                        WritableMap writableMap5 = writableMapArrCreatePointersArray[i2];
                        writableMapArr[i2] = writableMap5 != null ? writableMap5.copy() : null;
                    }
                } else {
                    if (i != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    writableMapArr2 = new WritableMap[0];
                    writableMapArr = writableMapArrCreatePointersArray;
                }
                it2 = ArrayIteratorKt.iterator(writableMapArr);
                while (it2.hasNext()) {
                    writableMap = (WritableMap) it2.next();
                    if (writableMap != null) {
                        WritableMap writableMapCopy = writableMap.copy();
                        TouchesHelper touchesHelper = INSTANCE;
                        WritableArray writableArray = touchesHelper.getWritableArray(true, writableMapArr);
                        WritableArray writableArray2 = touchesHelper.getWritableArray(true, writableMapArr2);
                        writableMapCopy.putArray(CHANGED_TOUCHES_KEY, writableArray);
                        writableMapCopy.putArray(TOUCHES_KEY, writableArray2);
                        writableMap2 = writableMapCopy;
                    } else {
                        writableMap2 = null;
                    }
                    eventEmitter.receiveEvent(event.getSurfaceId(), event.getViewTag(), event.getEventName(), event.canCoalesce(), 0, writableMap2, event.getEventCategory());
                }
                Systrace.endSection(0L);
            }
            writableMapArr2 = writableMapArrCreatePointersArray;
            it2 = ArrayIteratorKt.iterator(writableMapArr);
            while (it2.hasNext()) {
                writableMap = (WritableMap) it2.next();
                if (writableMap != null) {
                    WritableMap writableMapCopy2 = writableMap.copy();
                    TouchesHelper touchesHelper2 = INSTANCE;
                    WritableArray writableArray3 = touchesHelper2.getWritableArray(true, writableMapArr);
                    WritableArray writableArray4 = touchesHelper2.getWritableArray(true, writableMapArr2);
                    writableMapCopy2.putArray(CHANGED_TOUCHES_KEY, writableArray3);
                    writableMapCopy2.putArray(TOUCHES_KEY, writableArray4);
                    writableMap2 = writableMapCopy2;
                } else {
                    writableMap2 = null;
                }
                eventEmitter.receiveEvent(event.getSurfaceId(), event.getViewTag(), event.getEventName(), event.canCoalesce(), 0, writableMap2, event.getEventCategory());
            }
            Systrace.endSection(0L);
        } catch (Throwable th) {
            Systrace.endSection(0L);
            throw th;
        }
    }

    private final WritableArray getWritableArray(boolean z, WritableMap[] writableMapArr) {
        WritableArray writableArrayCreateArray = Arguments.createArray();
        for (WritableMap writableMapCopy : writableMapArr) {
            if (writableMapCopy != null) {
                if (z) {
                    writableMapCopy = writableMapCopy.copy();
                }
                writableArrayCreateArray.pushMap(writableMapCopy);
            }
        }
        Intrinsics.checkNotNull(writableArrayCreateArray);
        return writableArrayCreateArray;
    }
}
