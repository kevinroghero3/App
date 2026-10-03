package com.swmansion.gesturehandler.core;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.PixelUtil;
import com.swmansion.gesturehandler.RNSVGHitTester;
import com.swmansion.gesturehandler.react.ExtensionsKt;
import com.swmansion.gesturehandler.react.eventbuilders.GestureHandlerEventDataBuilder;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt__IndentKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class GestureHandler {
    public static final int ACTION_TYPE_JS_FUNCTION_NEW_API = 4;
    public static final int ACTION_TYPE_JS_FUNCTION_OLD_API = 3;
    public static final int ACTION_TYPE_NATIVE_ANIMATED_EVENT = 2;
    public static final int ACTION_TYPE_REANIMATED_WORKLET = 1;
    public static final Companion Companion = new Companion(null);
    private static final Void DEFAULT_HIT_SLOP = null;
    private static final boolean DEFAULT_IS_ENABLED = true;
    private static final boolean DEFAULT_MANUAL_ACTIVATION = false;
    private static final int DEFAULT_MOUSE_BUTTON = 0;
    private static final boolean DEFAULT_NEEDS_POINTER_DATA = false;
    private static final boolean DEFAULT_SHOULD_CANCEL_WHEN_OUTSIDE = false;
    public static final int DIRECTION_DOWN = 8;
    public static final int DIRECTION_LEFT = 2;
    public static final int DIRECTION_RIGHT = 1;
    public static final int DIRECTION_UP = 4;
    private static final int HIT_SLOP_BOTTOM_IDX = 3;
    private static final int HIT_SLOP_HEIGHT_IDX = 5;
    private static final int HIT_SLOP_LEFT_IDX = 0;
    public static final float HIT_SLOP_NONE = Float.NaN;
    private static final int HIT_SLOP_RIGHT_IDX = 2;
    private static final int HIT_SLOP_TOP_IDX = 1;
    private static final int HIT_SLOP_WIDTH_IDX = 4;
    private static final int MAX_POINTERS_COUNT = 12;
    public static final int POINTER_TYPE_MOUSE = 2;
    public static final int POINTER_TYPE_OTHER = 3;
    public static final int POINTER_TYPE_STYLUS = 1;
    public static final int POINTER_TYPE_TOUCH = 0;
    public static final int STATE_ACTIVE = 4;
    public static final int STATE_BEGAN = 2;
    public static final int STATE_CANCELLED = 3;
    public static final int STATE_END = 5;
    public static final int STATE_FAILED = 1;
    public static final int STATE_UNDETERMINED = 0;
    private static short nextEventCoalescingKey;
    private static MotionEvent.PointerCoords[] pointerCoords;
    private static MotionEvent.PointerProperties[] pointerProps;
    private int actionType;
    private int activationIndex;
    private WritableArray allTouchesPayload;
    private WritableArray changedTouchesPayload;
    private short eventCoalescingKey;
    private float[] hitSlop;
    private GestureHandlerInteractionController interactionController;
    private boolean isActive;
    private boolean isAwaiting;
    private boolean isEnabled;
    private boolean isWithinBounds;
    private float lastAbsolutePositionX;
    private float lastAbsolutePositionY;
    private float lastEventOffsetX;
    private float lastEventOffsetY;
    private boolean manualActivation;
    private int mouseButton;
    private boolean needsPointerData;
    private int numberOfPointers;
    private OnTouchEventListener onTouchEventListener;
    private GestureHandlerOrchestrator orchestrator;
    private int pointerType;
    private boolean shouldCancelWhenOutside;
    private boolean shouldResetProgress;
    private int state;
    private int tag;
    private int touchEventType;
    private final int[] trackedPointerIDs = new int[12];
    private final PointerData[] trackedPointers;
    private int trackedPointersCount;
    private int trackedPointersIDsCount;
    private View view;
    private final int[] windowOffset;
    private float x;
    private float y;

    protected void onCancel() {
    }

    protected void onFail() {
    }

    protected void onHandleHover(@NotNull MotionEvent event, @NotNull MotionEvent sourceEvent) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(sourceEvent, "sourceEvent");
    }

    protected void onPrepare() {
    }

    protected void onReset() {
    }

    protected void onStateChange(int i, int i2) {
    }

    public void resetProgress() {
    }

    public GestureHandler() {
        int[] iArr = new int[2];
        for (int i = 0; i < 2; i++) {
            iArr[i] = 0;
        }
        this.windowOffset = iArr;
        this.isEnabled = true;
        PointerData[] pointerDataArr = new PointerData[12];
        for (int i2 = 0; i2 < 12; i2++) {
            pointerDataArr[i2] = null;
        }
        this.trackedPointers = pointerDataArr;
        this.pointerType = 3;
    }

    public final int getTag() {
        return this.tag;
    }

    public final void setTag(int i) {
        this.tag = i;
    }

    public final View getView() {
        return this.view;
    }

    public final int getState() {
        return this.state;
    }

    public final float getX() {
        return this.x;
    }

    public final float getY() {
        return this.y;
    }

    public final boolean isWithinBounds() {
        return this.isWithinBounds;
    }

    public final boolean isEnabled() {
        return this.isEnabled;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setEnabled(boolean z) {
        if (this.view != null && this.isEnabled != z) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.swmansion.gesturehandler.core.GestureHandler$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.cancel();
                }
            });
        }
        this.isEnabled = z;
    }

    public final int getActionType() {
        return this.actionType;
    }

    public final void setActionType(int i) {
        this.actionType = i;
    }

    public final WritableArray getChangedTouchesPayload() {
        return this.changedTouchesPayload;
    }

    public final WritableArray getAllTouchesPayload() {
        return this.allTouchesPayload;
    }

    public final int getTouchEventType() {
        return this.touchEventType;
    }

    public final int getTrackedPointersCount() {
        return this.trackedPointersCount;
    }

    public final boolean getNeedsPointerData() {
        return this.needsPointerData;
    }

    public final void setNeedsPointerData(boolean z) {
        this.needsPointerData = z;
    }

    public final short getEventCoalescingKey() {
        return this.eventCoalescingKey;
    }

    public final float getLastAbsolutePositionX() {
        return this.lastAbsolutePositionX;
    }

    public final float getLastAbsolutePositionY() {
        return this.lastAbsolutePositionY;
    }

    public final int getNumberOfPointers() {
        return this.numberOfPointers;
    }

    protected final void setNumberOfPointers(int i) {
        this.numberOfPointers = i;
    }

    protected final boolean getShouldCancelWhenOutside() {
        return this.shouldCancelWhenOutside;
    }

    protected final void setShouldCancelWhenOutside(boolean z) {
        this.shouldCancelWhenOutside = z;
    }

    public final GestureHandlerOrchestrator getOrchestrator() {
        return this.orchestrator;
    }

    protected final void setOrchestrator(@Nullable GestureHandlerOrchestrator gestureHandlerOrchestrator) {
        this.orchestrator = gestureHandlerOrchestrator;
    }

    public final OnTouchEventListener getOnTouchEventListener() {
        return this.onTouchEventListener;
    }

    public final void setOnTouchEventListener(@Nullable OnTouchEventListener onTouchEventListener) {
        this.onTouchEventListener = onTouchEventListener;
    }

    public final int getPointerType() {
        return this.pointerType;
    }

    protected final int getMouseButton() {
        return this.mouseButton;
    }

    protected final void setMouseButton(int i) {
        this.mouseButton = i;
    }

    public final int getActivationIndex() {
        return this.activationIndex;
    }

    public final void setActivationIndex(int i) {
        this.activationIndex = i;
    }

    public final boolean isActive() {
        return this.isActive;
    }

    public final void setActive(boolean z) {
        this.isActive = z;
    }

    public final boolean isAwaiting() {
        return this.isAwaiting;
    }

    public final void setAwaiting(boolean z) {
        this.isAwaiting = z;
    }

    public final boolean getShouldResetProgress() {
        return this.shouldResetProgress;
    }

    public final void setShouldResetProgress(boolean z) {
        this.shouldResetProgress = z;
    }

    public void dispatchStateChange(int i, int i2) {
        OnTouchEventListener onTouchEventListener = this.onTouchEventListener;
        if (onTouchEventListener != null) {
            onTouchEventListener.onStateChange(this, i, i2);
        }
    }

    public void dispatchHandlerUpdate(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        OnTouchEventListener onTouchEventListener = this.onTouchEventListener;
        if (onTouchEventListener != null) {
            onTouchEventListener.onHandlerUpdate(this, event);
        }
    }

    public void dispatchTouchEvent() {
        OnTouchEventListener onTouchEventListener;
        if (this.changedTouchesPayload == null || (onTouchEventListener = this.onTouchEventListener) == null) {
            return;
        }
        onTouchEventListener.onTouchEvent(this);
    }

    public void resetConfig() {
        this.needsPointerData = false;
        this.manualActivation = false;
        this.shouldCancelWhenOutside = false;
        setEnabled(true);
        this.hitSlop = (float[]) DEFAULT_HIT_SLOP;
        this.mouseButton = 0;
    }

    public final boolean hasCommonPointers(@NotNull GestureHandler other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int length = this.trackedPointerIDs.length;
        for (int i = 0; i < length; i++) {
            if (this.trackedPointerIDs[i] != -1 && other.trackedPointerIDs[i] != -1) {
                return true;
            }
        }
        return false;
    }

    public final void setHitSlop(float f, float f2, float f3, float f4, float f5, float f6) {
        if (this.hitSlop == null) {
            this.hitSlop = new float[6];
        }
        float[] fArr = this.hitSlop;
        Intrinsics.checkNotNull(fArr);
        fArr[0] = f;
        float[] fArr2 = this.hitSlop;
        Intrinsics.checkNotNull(fArr2);
        fArr2[1] = f2;
        float[] fArr3 = this.hitSlop;
        Intrinsics.checkNotNull(fArr3);
        fArr3[2] = f3;
        float[] fArr4 = this.hitSlop;
        Intrinsics.checkNotNull(fArr4);
        fArr4[3] = f4;
        float[] fArr5 = this.hitSlop;
        Intrinsics.checkNotNull(fArr5);
        fArr5[4] = f5;
        float[] fArr6 = this.hitSlop;
        Intrinsics.checkNotNull(fArr6);
        fArr6[5] = f6;
        Companion companion = Companion;
        if (companion.hitSlopSet(f5) && companion.hitSlopSet(f) && companion.hitSlopSet(f3)) {
            throw new IllegalArgumentException("Cannot have all of left, right and width defined");
        }
        if (companion.hitSlopSet(f5) && !companion.hitSlopSet(f) && !companion.hitSlopSet(f3)) {
            throw new IllegalArgumentException("When width is set one of left or right pads need to be defined");
        }
        if (companion.hitSlopSet(f6) && companion.hitSlopSet(f4) && companion.hitSlopSet(f2)) {
            throw new IllegalArgumentException("Cannot have all of top, bottom and height defined");
        }
        if (companion.hitSlopSet(f6) && !companion.hitSlopSet(f4) && !companion.hitSlopSet(f2)) {
            throw new IllegalArgumentException("When height is set one of top or bottom pads need to be defined");
        }
    }

    public final void setHitSlop(float f) {
        setHitSlop(f, f, f, f, Float.NaN, Float.NaN);
    }

    public final void setInteractionController(@Nullable GestureHandlerInteractionController gestureHandlerInteractionController) {
        this.interactionController = gestureHandlerInteractionController;
    }

    public final void prepare(@Nullable View view, @Nullable GestureHandlerOrchestrator gestureHandlerOrchestrator) {
        if (this.view != null || this.orchestrator != null) {
            throw new IllegalStateException("Already prepared or hasn't been reset");
        }
        Arrays.fill(this.trackedPointerIDs, -1);
        this.trackedPointersIDsCount = 0;
        this.state = 0;
        this.view = view;
        this.orchestrator = gestureHandlerOrchestrator;
        Activity activity = getActivity(view != null ? view.getContext() : null);
        View viewFindViewById = activity != null ? activity.findViewById(R.id.content) : null;
        if (viewFindViewById != null) {
            viewFindViewById.getLocationOnScreen(this.windowOffset);
        } else {
            int[] iArr = this.windowOffset;
            iArr[0] = 0;
            iArr[1] = 0;
        }
        onPrepare();
    }

    private final Activity getActivity(Context context) {
        if (context instanceof ReactContext) {
            return ((ReactContext) context).getCurrentActivity();
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return getActivity(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    private final int findNextLocalPointerId() {
        int[] iArr;
        int i = 0;
        while (i < this.trackedPointersIDsCount) {
            int i2 = 0;
            while (true) {
                iArr = this.trackedPointerIDs;
                if (i2 >= iArr.length || iArr[i2] == i) {
                    break;
                }
                i2++;
            }
            if (i2 == iArr.length) {
                return i;
            }
            i++;
        }
        return i;
    }

    public final void startTrackingPointer(int i) {
        if (isTrackingPointer(i)) {
            return;
        }
        this.trackedPointerIDs[i] = findNextLocalPointerId();
        this.trackedPointersIDsCount++;
    }

    public final void stopTrackingPointer(int i) {
        if (isTrackingPointer(i)) {
            this.trackedPointerIDs[i] = -1;
            this.trackedPointersIDsCount--;
        }
    }

    private final boolean isTrackingPointer(int i) {
        return this.trackedPointerIDs[i] != -1;
    }

    private final boolean needAdapt(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() != this.trackedPointersIDsCount) {
            return true;
        }
        int length = this.trackedPointerIDs.length;
        for (int i = 0; i < length; i++) {
            int i2 = this.trackedPointerIDs[i];
            if (i2 != -1 && i2 != i) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x001f  */
    /* JADX WARN: Code duplicated, block: B:14:0x002d  */
    /* JADX WARN: Code duplicated, block: B:16:0x0031  */
    /* JADX WARN: Code duplicated, block: B:17:0x0034  */
    /* JADX WARN: Code duplicated, block: B:18:0x0037  */
    /* JADX WARN: Code duplicated, block: B:20:0x0045  */
    /* JADX WARN: Code duplicated, block: B:22:0x0049  */
    /* JADX WARN: Code duplicated, block: B:23:0x004c  */
    /* JADX WARN: Code duplicated, block: B:24:0x0052 A[PHI: r0
  0x0052: PHI (r0v5 int) = (r0v2 int), (r0v16 int) binds: [B:19:0x0043, B:13:0x002b] A[DONT_GENERATE, DONT_INLINE]] */
    private final MotionEvent adaptEvent(MotionEvent motionEvent) throws AdaptEventException {
        int actionIndex;
        int i;
        MotionEvent.PointerProperties[] pointerPropertiesArr;
        MotionEvent.PointerProperties[] pointerPropertiesArr2;
        MotionEvent.PointerCoords[] pointerCoordsArr;
        if (!needAdapt(motionEvent)) {
            return motionEvent;
        }
        int actionMasked = motionEvent.getActionMasked();
        int i2 = 0;
        if (actionMasked == 0) {
            actionIndex = motionEvent.getActionIndex();
            if (this.trackedPointerIDs[motionEvent.getPointerId(actionIndex)] != -1) {
                i = actionIndex;
                actionMasked = 2;
            } else if (this.trackedPointersIDsCount == 1) {
                i = actionIndex;
                actionMasked = 0;
            } else {
                i = actionIndex;
                actionMasked = 5;
            }
        } else if (actionMasked == 1) {
            actionIndex = motionEvent.getActionIndex();
            if (this.trackedPointerIDs[motionEvent.getPointerId(actionIndex)] != -1) {
                i = actionIndex;
                actionMasked = 2;
            } else if (this.trackedPointersIDsCount == 1) {
                i = actionIndex;
                actionMasked = 1;
            } else {
                i = actionIndex;
                actionMasked = 6;
            }
        } else if (actionMasked == 5) {
            actionIndex = motionEvent.getActionIndex();
            if (this.trackedPointerIDs[motionEvent.getPointerId(actionIndex)] != -1) {
                i = actionIndex;
                actionMasked = 2;
            } else if (this.trackedPointersIDsCount == 1) {
                i = actionIndex;
                actionMasked = 0;
            } else {
                i = actionIndex;
                actionMasked = 5;
            }
        } else if (actionMasked != 6) {
            i = -1;
        } else {
            actionIndex = motionEvent.getActionIndex();
            if (this.trackedPointerIDs[motionEvent.getPointerId(actionIndex)] != -1) {
                i = actionIndex;
                actionMasked = 2;
            } else if (this.trackedPointersIDsCount == 1) {
                i = actionIndex;
                actionMasked = 1;
            } else {
                i = actionIndex;
                actionMasked = 6;
            }
        }
        Companion.initPointerProps(this.trackedPointersIDsCount);
        float rawX = motionEvent.getRawX() - motionEvent.getX();
        float rawY = motionEvent.getRawY() - motionEvent.getY();
        motionEvent.offsetLocation(rawX, rawY);
        int pointerCount = motionEvent.getPointerCount();
        int i3 = actionMasked;
        int i4 = 0;
        while (true) {
            pointerPropertiesArr = null;
            MotionEvent.PointerCoords[] pointerCoordsArr2 = null;
            if (i2 >= pointerCount) {
                break;
            }
            int pointerId = motionEvent.getPointerId(i2);
            if (this.trackedPointerIDs[pointerId] != -1) {
                MotionEvent.PointerProperties[] pointerPropertiesArr3 = pointerProps;
                if (pointerPropertiesArr3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pointerProps");
                    pointerPropertiesArr3 = null;
                }
                motionEvent.getPointerProperties(i2, pointerPropertiesArr3[i4]);
                MotionEvent.PointerProperties[] pointerPropertiesArr4 = pointerProps;
                if (pointerPropertiesArr4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pointerProps");
                    pointerPropertiesArr4 = null;
                }
                MotionEvent.PointerProperties pointerProperties = pointerPropertiesArr4[i4];
                Intrinsics.checkNotNull(pointerProperties);
                pointerProperties.id = this.trackedPointerIDs[pointerId];
                MotionEvent.PointerCoords[] pointerCoordsArr3 = pointerCoords;
                if (pointerCoordsArr3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pointerCoords");
                } else {
                    pointerCoordsArr2 = pointerCoordsArr3;
                }
                motionEvent.getPointerCoords(i2, pointerCoordsArr2[i4]);
                if (i2 == i) {
                    i3 |= i4 << 8;
                }
                i4++;
            }
            i2++;
        }
        MotionEvent.PointerProperties[] pointerPropertiesArr5 = pointerProps;
        if (pointerPropertiesArr5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pointerProps");
            pointerPropertiesArr5 = null;
        }
        if (pointerPropertiesArr5.length != 0) {
            MotionEvent.PointerCoords[] pointerCoordsArr4 = pointerCoords;
            if (pointerCoordsArr4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pointerCoords");
                pointerCoordsArr4 = null;
            }
            if (pointerCoordsArr4.length != 0) {
                try {
                    long downTime = motionEvent.getDownTime();
                    long eventTime = motionEvent.getEventTime();
                    MotionEvent.PointerProperties[] pointerPropertiesArr6 = pointerProps;
                    if (pointerPropertiesArr6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("pointerProps");
                        pointerPropertiesArr2 = null;
                    } else {
                        pointerPropertiesArr2 = pointerPropertiesArr6;
                    }
                    MotionEvent.PointerCoords[] pointerCoordsArr5 = pointerCoords;
                    if (pointerCoordsArr5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("pointerCoords");
                        pointerCoordsArr = null;
                    } else {
                        pointerCoordsArr = pointerCoordsArr5;
                    }
                    MotionEvent motionEventObtain = MotionEvent.obtain(downTime, eventTime, i3, i4, pointerPropertiesArr2, pointerCoordsArr, motionEvent.getMetaState(), motionEvent.getButtonState(), motionEvent.getXPrecision(), motionEvent.getYPrecision(), motionEvent.getDeviceId(), motionEvent.getEdgeFlags(), motionEvent.getSource(), motionEvent.getFlags());
                    float f = -rawX;
                    float f2 = -rawY;
                    motionEvent.offsetLocation(f, f2);
                    motionEventObtain.offsetLocation(f, f2);
                    return motionEventObtain;
                } catch (IllegalArgumentException e) {
                    throw new AdaptEventException(this, motionEvent, e);
                }
            }
        }
        MotionEvent.PointerCoords[] pointerCoordsArr6 = pointerCoords;
        if (pointerCoordsArr6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pointerCoords");
            pointerCoordsArr6 = null;
        }
        int length = pointerCoordsArr6.length;
        MotionEvent.PointerProperties[] pointerPropertiesArr7 = pointerProps;
        if (pointerPropertiesArr7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pointerProps");
        } else {
            pointerPropertiesArr = pointerPropertiesArr7;
        }
        throw new IllegalStateException("pointerCoords.size=" + length + ", pointerProps.size=" + pointerPropertiesArr.length);
    }

    public static final class AdaptEventException extends Exception {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AdaptEventException(@NotNull GestureHandler handler, @NotNull MotionEvent event, @NotNull IllegalArgumentException e) {
            super(StringsKt__IndentKt.trimIndent("\n    handler: " + Reflection.getOrCreateKotlinClass(handler.getClass()).getSimpleName() + "\n    state: " + handler.getState() + "\n    view: " + handler.getView() + "\n    orchestrator: " + handler.getOrchestrator() + "\n    isEnabled: " + handler.isEnabled() + "\n    isActive: " + handler.isActive() + "\n    isAwaiting: " + handler.isAwaiting() + "\n    trackedPointersCount: " + handler.trackedPointersIDsCount + "\n    trackedPointers: " + ArraysKt___ArraysKt.joinToString$default(handler.trackedPointerIDs, (CharSequence) ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null) + "\n    while handling event: " + event + "\n      "), e);
            Intrinsics.checkNotNullParameter(handler, "handler");
            Intrinsics.checkNotNullParameter(event, "event");
            Intrinsics.checkNotNullParameter(e, "e");
        }
    }

    public final void handle(@NotNull MotionEvent transformedEvent, @NotNull MotionEvent sourceEvent) {
        int i;
        Intrinsics.checkNotNullParameter(transformedEvent, "transformedEvent");
        Intrinsics.checkNotNullParameter(sourceEvent, "sourceEvent");
        if (!this.isEnabled || (i = this.state) == 3 || i == 1 || i == 5 || this.trackedPointersIDsCount < 1) {
            return;
        }
        try {
            MotionEvent[] motionEventArr = {adaptEvent(transformedEvent), adaptEvent(sourceEvent)};
            MotionEvent motionEvent = motionEventArr[0];
            MotionEvent motionEvent2 = motionEventArr[1];
            this.x = motionEvent.getX();
            this.y = motionEvent.getY();
            this.numberOfPointers = motionEvent.getPointerCount();
            boolean zIsWithinBounds = isWithinBounds(this.view, this.x, this.y);
            this.isWithinBounds = zIsWithinBounds;
            if (this.shouldCancelWhenOutside && !zIsWithinBounds) {
                int i2 = this.state;
                if (i2 == 4) {
                    cancel();
                    return;
                } else {
                    if (i2 == 2) {
                        fail();
                        return;
                    }
                    return;
                }
            }
            GestureUtils gestureUtils = GestureUtils.INSTANCE;
            this.lastAbsolutePositionX = gestureUtils.getLastPointerX(motionEvent, true);
            this.lastAbsolutePositionY = gestureUtils.getLastPointerY(motionEvent, true);
            this.lastEventOffsetX = motionEvent.getRawX() - motionEvent.getX();
            this.lastEventOffsetY = motionEvent.getRawY() - motionEvent.getY();
            if (sourceEvent.getAction() == 0 || sourceEvent.getAction() == 9 || sourceEvent.getAction() == 7) {
                setPointerType(sourceEvent);
            }
            if (ExtensionsKt.isHoverAction(sourceEvent)) {
                onHandleHover(motionEvent, motionEvent2);
            } else {
                onHandle(motionEvent, motionEvent2);
            }
            if (!Intrinsics.areEqual(motionEvent, transformedEvent)) {
                motionEvent.recycle();
            }
            if (Intrinsics.areEqual(motionEvent2, sourceEvent)) {
                return;
            }
            motionEvent2.recycle();
        } catch (AdaptEventException unused) {
            fail();
        }
    }

    private final void dispatchTouchDownEvent(MotionEvent motionEvent, MotionEvent motionEvent2) {
        this.changedTouchesPayload = null;
        this.touchEventType = 1;
        int pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
        float rawX = motionEvent2.getRawX();
        float x = motionEvent2.getX();
        float rawY = motionEvent2.getRawY();
        float y = motionEvent2.getY();
        this.trackedPointers[pointerId] = new PointerData(pointerId, motionEvent.getX(motionEvent.getActionIndex()), motionEvent.getY(motionEvent.getActionIndex()), (motionEvent2.getX(motionEvent.getActionIndex()) + (rawX - x)) - this.windowOffset[0], (motionEvent2.getY(motionEvent.getActionIndex()) + (rawY - y)) - this.windowOffset[1]);
        this.trackedPointersCount++;
        PointerData pointerData = this.trackedPointers[pointerId];
        Intrinsics.checkNotNull(pointerData);
        addChangedPointer(pointerData);
        extractAllPointersData();
        dispatchTouchEvent();
    }

    private final void dispatchTouchUpEvent(MotionEvent motionEvent, MotionEvent motionEvent2) {
        extractAllPointersData();
        this.changedTouchesPayload = null;
        this.touchEventType = 3;
        int pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
        float rawX = motionEvent2.getRawX();
        float x = motionEvent2.getX();
        float rawY = motionEvent2.getRawY();
        float y = motionEvent2.getY();
        this.trackedPointers[pointerId] = new PointerData(pointerId, motionEvent.getX(motionEvent.getActionIndex()), motionEvent.getY(motionEvent.getActionIndex()), (motionEvent2.getX(motionEvent.getActionIndex()) + (rawX - x)) - this.windowOffset[0], (motionEvent2.getY(motionEvent.getActionIndex()) + (rawY - y)) - this.windowOffset[1]);
        PointerData pointerData = this.trackedPointers[pointerId];
        Intrinsics.checkNotNull(pointerData);
        addChangedPointer(pointerData);
        this.trackedPointers[pointerId] = null;
        this.trackedPointersCount--;
        dispatchTouchEvent();
    }

    private final void dispatchTouchMoveEvent(MotionEvent motionEvent, MotionEvent motionEvent2) {
        this.changedTouchesPayload = null;
        this.touchEventType = 2;
        float rawX = motionEvent2.getRawX();
        float x = motionEvent2.getX();
        float rawY = motionEvent2.getRawY();
        float y = motionEvent2.getY();
        int pointerCount = motionEvent.getPointerCount();
        int i = 0;
        for (int i2 = 0; i2 < pointerCount; i2++) {
            PointerData pointerData = this.trackedPointers[motionEvent.getPointerId(i2)];
            if (pointerData != null && (pointerData.getX() != motionEvent.getX(i2) || pointerData.getY() != motionEvent.getY(i2))) {
                pointerData.setX(motionEvent.getX(i2));
                pointerData.setY(motionEvent.getY(i2));
                pointerData.setAbsoluteX((motionEvent2.getX(i2) + (rawX - x)) - this.windowOffset[0]);
                pointerData.setAbsoluteY((motionEvent2.getY(i2) + (rawY - y)) - this.windowOffset[1]);
                addChangedPointer(pointerData);
                i++;
            }
        }
        if (i > 0) {
            extractAllPointersData();
            dispatchTouchEvent();
        }
    }

    public final void updatePointerData(@NotNull MotionEvent event, @NotNull MotionEvent sourceEvent) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(sourceEvent, "sourceEvent");
        if (event.getActionMasked() == 0 || event.getActionMasked() == 5) {
            dispatchTouchDownEvent(event, sourceEvent);
            dispatchTouchMoveEvent(event, sourceEvent);
        } else if (event.getActionMasked() == 1 || event.getActionMasked() == 6) {
            dispatchTouchMoveEvent(event, sourceEvent);
            dispatchTouchUpEvent(event, sourceEvent);
        } else if (event.getActionMasked() == 2) {
            dispatchTouchMoveEvent(event, sourceEvent);
        }
    }

    private final void extractAllPointersData() {
        this.allTouchesPayload = null;
        for (PointerData pointerData : this.trackedPointers) {
            if (pointerData != null) {
                addPointerToAll(pointerData);
            }
        }
    }

    private final void cancelPointers() {
        this.touchEventType = 4;
        this.changedTouchesPayload = null;
        extractAllPointersData();
        for (PointerData pointerData : this.trackedPointers) {
            if (pointerData != null) {
                addChangedPointer(pointerData);
            }
        }
        this.trackedPointersCount = 0;
        ArraysKt___ArraysJvmKt.fill$default(this.trackedPointers, (Object) null, 0, 0, 6, (Object) null);
        dispatchTouchEvent();
    }

    private final void addChangedPointer(PointerData pointerData) {
        if (this.changedTouchesPayload == null) {
            this.changedTouchesPayload = Arguments.createArray();
        }
        WritableArray writableArray = this.changedTouchesPayload;
        Intrinsics.checkNotNull(writableArray);
        writableArray.pushMap(createPointerData(pointerData));
    }

    private final void addPointerToAll(PointerData pointerData) {
        if (this.allTouchesPayload == null) {
            this.allTouchesPayload = Arguments.createArray();
        }
        WritableArray writableArray = this.allTouchesPayload;
        Intrinsics.checkNotNull(writableArray);
        writableArray.pushMap(createPointerData(pointerData));
    }

    private final WritableMap createPointerData(PointerData pointerData) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putInt("id", pointerData.getPointerId());
        writableMapCreateMap.putDouble("x", PixelUtil.toDIPFromPixel(pointerData.getX()));
        writableMapCreateMap.putDouble("y", PixelUtil.toDIPFromPixel(pointerData.getY()));
        writableMapCreateMap.putDouble("absoluteX", PixelUtil.toDIPFromPixel(pointerData.getAbsoluteX()));
        writableMapCreateMap.putDouble("absoluteY", PixelUtil.toDIPFromPixel(pointerData.getAbsoluteY()));
        return writableMapCreateMap;
    }

    public final WritableArray consumeChangedTouchesPayload() {
        WritableArray writableArray = this.changedTouchesPayload;
        this.changedTouchesPayload = null;
        return writableArray;
    }

    public final WritableArray consumeAllTouchesPayload() {
        WritableArray writableArray = this.allTouchesPayload;
        this.allTouchesPayload = null;
        return writableArray;
    }

    private final void moveToState(int i) {
        UiThreadUtil.assertOnUiThread();
        if (this.state == i) {
            return;
        }
        if (this.trackedPointersCount > 0 && (i == 5 || i == 3 || i == 1)) {
            cancelPointers();
        }
        int i2 = this.state;
        this.state = i;
        if (i == 4) {
            short s = nextEventCoalescingKey;
            nextEventCoalescingKey = (short) (s + 1);
            this.eventCoalescingKey = s;
        }
        GestureHandlerOrchestrator gestureHandlerOrchestrator = this.orchestrator;
        Intrinsics.checkNotNull(gestureHandlerOrchestrator);
        gestureHandlerOrchestrator.onHandlerStateChange(this, i, i2);
        onStateChange(i, i2);
    }

    public final boolean wantsEvent(@NotNull MotionEvent event) {
        int i;
        Intrinsics.checkNotNullParameter(event, "event");
        return (!this.isEnabled || (i = this.state) == 1 || i == 3 || i == 5 || !isTrackingPointer(event.getPointerId(event.getActionIndex()))) ? false : true;
    }

    public boolean shouldRequireToWaitForFailure(@NotNull GestureHandler handler) {
        GestureHandlerInteractionController gestureHandlerInteractionController;
        Intrinsics.checkNotNullParameter(handler, "handler");
        if (handler == this || (gestureHandlerInteractionController = this.interactionController) == null) {
            return false;
        }
        return gestureHandlerInteractionController.shouldRequireHandlerToWaitForFailure(this, handler);
    }

    public final boolean shouldWaitForHandlerFailure(@NotNull GestureHandler handler) {
        GestureHandlerInteractionController gestureHandlerInteractionController;
        Intrinsics.checkNotNullParameter(handler, "handler");
        if (handler == this || (gestureHandlerInteractionController = this.interactionController) == null) {
            return false;
        }
        return gestureHandlerInteractionController.shouldWaitForHandlerFailure(this, handler);
    }

    public boolean shouldRecognizeSimultaneously(@NotNull GestureHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        if (handler == this) {
            return true;
        }
        GestureHandlerInteractionController gestureHandlerInteractionController = this.interactionController;
        if (gestureHandlerInteractionController != null) {
            return gestureHandlerInteractionController.shouldRecognizeSimultaneously(this, handler);
        }
        return false;
    }

    public boolean shouldBeCancelledBy(@NotNull GestureHandler handler) {
        GestureHandlerInteractionController gestureHandlerInteractionController;
        Intrinsics.checkNotNullParameter(handler, "handler");
        if (handler == this || (gestureHandlerInteractionController = this.interactionController) == null) {
            return false;
        }
        return gestureHandlerInteractionController.shouldHandlerBeCancelledBy(this, handler);
    }

    public final boolean isWithinBounds(@Nullable View view, float f, float f2) {
        float f3;
        RNSVGHitTester.Companion companion = RNSVGHitTester.Companion;
        Intrinsics.checkNotNull(view);
        if (companion.isSvgElement(view)) {
            return companion.hitTest(view, f, f2);
        }
        float width = view.getWidth();
        float height = view.getHeight();
        float[] fArr = this.hitSlop;
        float f4 = 0.0f;
        if (fArr != null) {
            float f5 = fArr[0];
            float f6 = fArr[1];
            float f7 = fArr[2];
            float f8 = fArr[3];
            Companion companion2 = Companion;
            float f9 = companion2.hitSlopSet(f5) ? 0.0f - f5 : 0.0f;
            f4 = companion2.hitSlopSet(f6) ? 0.0f - f6 : 0.0f;
            if (companion2.hitSlopSet(f7)) {
                width += f7;
            }
            if (companion2.hitSlopSet(f8)) {
                height += f8;
            }
            float f10 = fArr[4];
            float f11 = fArr[5];
            if (companion2.hitSlopSet(f10)) {
                if (!companion2.hitSlopSet(f5)) {
                    f9 = width - f10;
                } else if (!companion2.hitSlopSet(f7)) {
                    width = f10 + f9;
                }
            }
            if (companion2.hitSlopSet(f11)) {
                if (!companion2.hitSlopSet(f6)) {
                    f4 = height - f11;
                } else if (!companion2.hitSlopSet(f8)) {
                    height = f11 + f4;
                }
            }
            f3 = f4;
            f4 = f9;
        } else {
            f3 = 0.0f;
        }
        return f4 <= f && f <= width && f3 <= f2 && f2 <= height;
    }

    public final void cancel() {
        int i = this.state;
        if (i == 4 || i == 0 || i == 2 || this.isAwaiting) {
            onCancel();
            moveToState(3);
        }
    }

    public final void fail() {
        int i = this.state;
        if (i == 4 || i == 0 || i == 2) {
            onFail();
            moveToState(1);
        }
    }

    public final void activate() {
        activate(false);
    }

    public void activate(boolean z) {
        if (!this.manualActivation || z) {
            int i = this.state;
            if (i == 0 || i == 2) {
                moveToState(4);
            }
        }
    }

    public final void begin() {
        if (this.state == 0) {
            moveToState(2);
        }
    }

    public final void end() {
        int i = this.state;
        if (i == 2 || i == 4) {
            moveToState(5);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0018, code lost:
    
        r0 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean isDescendantOf(@org.jetbrains.annotations.NotNull com.swmansion.gesturehandler.core.GestureHandler r4) {
        /*
            r3 = this;
            java.lang.String r0 = "of"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            android.view.View r0 = r3.view
            r1 = 0
            if (r0 == 0) goto Lf
            android.view.ViewParent r0 = r0.getParent()
            goto L10
        Lf:
            r0 = r1
        L10:
            boolean r2 = r0 instanceof android.view.View
            if (r2 == 0) goto L17
            android.view.View r0 = (android.view.View) r0
            goto L18
        L17:
            r0 = r1
        L18:
            if (r0 == 0) goto L2f
            android.view.View r2 = r4.view
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r2)
            if (r2 == 0) goto L24
            r4 = 1
            return r4
        L24:
            android.view.ViewParent r0 = r0.getParent()
            boolean r2 = r0 instanceof android.view.View
            if (r2 == 0) goto L17
            android.view.View r0 = (android.view.View) r0
            goto L18
        L2f:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.gesturehandler.core.GestureHandler.isDescendantOf(com.swmansion.gesturehandler.core.GestureHandler):boolean");
    }

    protected void onHandle(@NotNull MotionEvent event, @NotNull MotionEvent sourceEvent) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(sourceEvent, "sourceEvent");
        moveToState(1);
    }

    private final boolean isButtonInConfig(int i) {
        int i2 = this.mouseButton;
        if (i2 == 0) {
            return i == 1;
        }
        return (i & i2) != 0;
    }

    protected final boolean shouldActivateWithMouse(@NotNull MotionEvent sourceEvent) {
        Intrinsics.checkNotNullParameter(sourceEvent, "sourceEvent");
        if (sourceEvent.getToolType(0) == 3) {
            if (sourceEvent.getAction() == 0 || sourceEvent.getAction() == 1 || sourceEvent.getAction() == 6 || sourceEvent.getAction() == 5 || !(sourceEvent.getAction() == 2 || isButtonInConfig(sourceEvent.getActionButton()))) {
                return false;
            }
            if (sourceEvent.getAction() == 2 && !isButtonInConfig(sourceEvent.getButtonState())) {
                return false;
            }
        }
        return true;
    }

    protected final PointF transformPoint(@NotNull PointF point) {
        PointF pointFTransformPointToViewCoords;
        Intrinsics.checkNotNullParameter(point, "point");
        GestureHandlerOrchestrator gestureHandlerOrchestrator = this.orchestrator;
        if (gestureHandlerOrchestrator != null && (pointFTransformPointToViewCoords = gestureHandlerOrchestrator.transformPointToViewCoords(this.view, point)) != null) {
            return pointFTransformPointToViewCoords;
        }
        point.x = Float.NaN;
        point.y = Float.NaN;
        return point;
    }

    public final void reset() {
        this.view = null;
        this.orchestrator = null;
        Arrays.fill(this.trackedPointerIDs, -1);
        this.trackedPointersIDsCount = 0;
        this.trackedPointersCount = 0;
        ArraysKt___ArraysJvmKt.fill$default(this.trackedPointers, (Object) null, 0, 0, 6, (Object) null);
        this.touchEventType = 0;
        onReset();
    }

    public final void withMarkedAsInBounds(@NotNull Function0<Unit> closure) {
        Intrinsics.checkNotNullParameter(closure, "closure");
        this.isWithinBounds = true;
        closure.invoke();
        this.isWithinBounds = false;
    }

    private final void setPointerType(MotionEvent motionEvent) {
        int toolType = motionEvent.getToolType(motionEvent.getActionIndex());
        int i = 1;
        if (toolType == 1) {
            i = 0;
        } else if (toolType != 2) {
            i = 3;
            if (toolType == 3) {
                i = 2;
            }
        }
        this.pointerType = i;
    }

    public String toString() {
        String simpleName;
        View view = this.view;
        if (view == null) {
            simpleName = null;
        } else {
            Intrinsics.checkNotNull(view);
            simpleName = view.getClass().getSimpleName();
        }
        return getClass().getSimpleName() + "@[" + this.tag + "]:" + simpleName;
    }

    public final float getLastRelativePositionX() {
        return this.lastAbsolutePositionX;
    }

    public final float getLastRelativePositionY() {
        return this.lastAbsolutePositionY;
    }

    public final float getLastPositionInWindowX() {
        return (this.lastAbsolutePositionX + this.lastEventOffsetX) - this.windowOffset[0];
    }

    public final float getLastPositionInWindowY() {
        return (this.lastAbsolutePositionY + this.lastEventOffsetY) - this.windowOffset[1];
    }

    public static abstract class Factory<T extends GestureHandler> {
        public static final Companion Companion = new Companion(null);
        private static final String KEY_ENABLED = "enabled";
        private static final String KEY_HIT_SLOP = "hitSlop";
        private static final String KEY_HIT_SLOP_BOTTOM = "bottom";
        private static final String KEY_HIT_SLOP_HEIGHT = "height";
        private static final String KEY_HIT_SLOP_HORIZONTAL = "horizontal";
        private static final String KEY_HIT_SLOP_LEFT = "left";
        private static final String KEY_HIT_SLOP_RIGHT = "right";
        private static final String KEY_HIT_SLOP_TOP = "top";
        private static final String KEY_HIT_SLOP_VERTICAL = "vertical";
        private static final String KEY_HIT_SLOP_WIDTH = "width";
        private static final String KEY_MANUAL_ACTIVATION = "manualActivation";
        private static final String KEY_MOUSE_BUTTON = "mouseButton";
        private static final String KEY_NEEDS_POINTER_DATA = "needsPointerData";
        private static final String KEY_SHOULD_CANCEL_WHEN_OUTSIDE = "shouldCancelWhenOutside";

        protected abstract T create(@Nullable Context context);

        public abstract GestureHandlerEventDataBuilder<T> createEventBuilder(@NotNull T t);

        public abstract String getName();

        public abstract Class<T> getType();

        public final T create(@Nullable Context context, int i) {
            T t = (T) create(context);
            t.setTag(i);
            return t;
        }

        public void setConfig(@NotNull T handler, @NotNull ReadableMap config) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            Intrinsics.checkNotNullParameter(config, "config");
            handler.resetConfig();
            if (config.hasKey(KEY_SHOULD_CANCEL_WHEN_OUTSIDE)) {
                handler.setShouldCancelWhenOutside(config.getBoolean(KEY_SHOULD_CANCEL_WHEN_OUTSIDE));
            }
            if (config.hasKey("enabled")) {
                handler.setEnabled(config.getBoolean("enabled"));
            }
            if (config.hasKey(KEY_HIT_SLOP)) {
                Companion.handleHitSlopProperty(handler, config);
            }
            if (config.hasKey(KEY_NEEDS_POINTER_DATA)) {
                handler.setNeedsPointerData(config.getBoolean(KEY_NEEDS_POINTER_DATA));
            }
            if (config.hasKey(KEY_MANUAL_ACTIVATION)) {
                ((GestureHandler) handler).manualActivation = config.getBoolean(KEY_MANUAL_ACTIVATION);
            }
            if (config.hasKey(KEY_MOUSE_BUTTON)) {
                handler.setMouseButton(config.getInt(KEY_MOUSE_BUTTON));
            }
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void handleHitSlopProperty(GestureHandler gestureHandler, ReadableMap readableMap) {
                if (readableMap.getType(Factory.KEY_HIT_SLOP) == ReadableType.Number) {
                    float pixelFromDIP = PixelUtil.toPixelFromDIP(readableMap.getDouble(Factory.KEY_HIT_SLOP));
                    gestureHandler.setHitSlop(pixelFromDIP, pixelFromDIP, pixelFromDIP, pixelFromDIP, Float.NaN, Float.NaN);
                    return;
                }
                ReadableMap map = readableMap.getMap(Factory.KEY_HIT_SLOP);
                Intrinsics.checkNotNull(map);
                float pixelFromDIP2 = map.hasKey(Factory.KEY_HIT_SLOP_HORIZONTAL) ? PixelUtil.toPixelFromDIP(map.getDouble(Factory.KEY_HIT_SLOP_HORIZONTAL)) : Float.NaN;
                float pixelFromDIP3 = map.hasKey(Factory.KEY_HIT_SLOP_VERTICAL) ? PixelUtil.toPixelFromDIP(map.getDouble(Factory.KEY_HIT_SLOP_VERTICAL)) : Float.NaN;
                float pixelFromDIP4 = map.hasKey("left") ? PixelUtil.toPixelFromDIP(map.getDouble("left")) : pixelFromDIP2;
                float pixelFromDIP5 = map.hasKey("top") ? PixelUtil.toPixelFromDIP(map.getDouble("top")) : pixelFromDIP3;
                if (map.hasKey("right")) {
                    pixelFromDIP2 = PixelUtil.toPixelFromDIP(map.getDouble("right"));
                }
                float f = pixelFromDIP2;
                if (map.hasKey("bottom")) {
                    pixelFromDIP3 = PixelUtil.toPixelFromDIP(map.getDouble("bottom"));
                }
                gestureHandler.setHitSlop(pixelFromDIP4, pixelFromDIP5, f, pixelFromDIP3, map.hasKey("width") ? PixelUtil.toPixelFromDIP(map.getDouble("width")) : Float.NaN, map.hasKey("height") ? PixelUtil.toPixelFromDIP(map.getDouble("height")) : Float.NaN);
            }
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void initPointerProps(int i) {
            if (GestureHandler.pointerProps == null) {
                GestureHandler.pointerProps = new MotionEvent.PointerProperties[12];
                GestureHandler.pointerCoords = new MotionEvent.PointerCoords[12];
            }
            while (i > 0) {
                MotionEvent.PointerProperties[] pointerPropertiesArr = GestureHandler.pointerProps;
                MotionEvent.PointerCoords[] pointerCoordsArr = null;
                if (pointerPropertiesArr == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pointerProps");
                    pointerPropertiesArr = null;
                }
                int i2 = i - 1;
                if (pointerPropertiesArr[i2] != null) {
                    return;
                }
                MotionEvent.PointerProperties[] pointerPropertiesArr2 = GestureHandler.pointerProps;
                if (pointerPropertiesArr2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pointerProps");
                    pointerPropertiesArr2 = null;
                }
                pointerPropertiesArr2[i2] = new MotionEvent.PointerProperties();
                MotionEvent.PointerCoords[] pointerCoordsArr2 = GestureHandler.pointerCoords;
                if (pointerCoordsArr2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pointerCoords");
                } else {
                    pointerCoordsArr = pointerCoordsArr2;
                }
                pointerCoordsArr[i2] = new MotionEvent.PointerCoords();
                i--;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean hitSlopSet(float f) {
            return !Float.isNaN(f);
        }

        public final String stateToString(int i) {
            if (i == 0) {
                return "UNDETERMINED";
            }
            if (i == 1) {
                return "FAILED";
            }
            if (i == 2) {
                return "BEGIN";
            }
            if (i == 3) {
                return "CANCELLED";
            }
            if (i == 4) {
                return "ACTIVE";
            }
            if (i != 5) {
                return null;
            }
            return "END";
        }
    }

    static final class PointerData {
        private float absoluteX;
        private float absoluteY;
        private final int pointerId;
        private float x;
        private float y;

        public static /* synthetic */ PointerData copy$default(PointerData pointerData, int i, float f, float f2, float f3, float f4, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = pointerData.pointerId;
            }
            if ((i2 & 2) != 0) {
                f = pointerData.x;
            }
            float f5 = f;
            if ((i2 & 4) != 0) {
                f2 = pointerData.y;
            }
            float f6 = f2;
            if ((i2 & 8) != 0) {
                f3 = pointerData.absoluteX;
            }
            float f7 = f3;
            if ((i2 & 16) != 0) {
                f4 = pointerData.absoluteY;
            }
            return pointerData.copy(i, f5, f6, f7, f4);
        }

        public final int component1() {
            return this.pointerId;
        }

        public final float component2() {
            return this.x;
        }

        public final float component3() {
            return this.y;
        }

        public final float component4() {
            return this.absoluteX;
        }

        public final float component5() {
            return this.absoluteY;
        }

        public final PointerData copy(int i, float f, float f2, float f3, float f4) {
            return new PointerData(i, f, f2, f3, f4);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PointerData)) {
                return false;
            }
            PointerData pointerData = (PointerData) obj;
            return this.pointerId == pointerData.pointerId && Float.compare(this.x, pointerData.x) == 0 && Float.compare(this.y, pointerData.y) == 0 && Float.compare(this.absoluteX, pointerData.absoluteX) == 0 && Float.compare(this.absoluteY, pointerData.absoluteY) == 0;
        }

        public int hashCode() {
            return (((((((Integer.hashCode(this.pointerId) * 31) + Float.hashCode(this.x)) * 31) + Float.hashCode(this.y)) * 31) + Float.hashCode(this.absoluteX)) * 31) + Float.hashCode(this.absoluteY);
        }

        public String toString() {
            return "PointerData(pointerId=" + this.pointerId + ", x=" + this.x + ", y=" + this.y + ", absoluteX=" + this.absoluteX + ", absoluteY=" + this.absoluteY + ")";
        }

        public PointerData(int i, float f, float f2, float f3, float f4) {
            this.pointerId = i;
            this.x = f;
            this.y = f2;
            this.absoluteX = f3;
            this.absoluteY = f4;
        }

        public final int getPointerId() {
            return this.pointerId;
        }

        public final float getX() {
            return this.x;
        }

        public final void setX(float f) {
            this.x = f;
        }

        public final float getY() {
            return this.y;
        }

        public final void setY(float f) {
            this.y = f;
        }

        public final float getAbsoluteX() {
            return this.absoluteX;
        }

        public final void setAbsoluteX(float f) {
            this.absoluteX = f;
        }

        public final float getAbsoluteY() {
            return this.absoluteY;
        }

        public final void setAbsoluteY(float f) {
            this.absoluteY = f;
        }
    }
}
