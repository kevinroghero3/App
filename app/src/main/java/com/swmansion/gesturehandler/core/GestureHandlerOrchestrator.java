package com.swmansion.gesturehandler.core;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import com.facebook.react.uimanager.RootView;
import com.swmansion.gesturehandler.react.ExtensionsKt;
import com.swmansion.gesturehandler.react.RNGestureHandlerRootHelper;
import com.swmansion.gesturehandler.react.RNGestureHandlerRootView;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt__ReversedViewsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class GestureHandlerOrchestrator {
    private static final float DEFAULT_MIN_ALPHA_FOR_TRAVERSAL = 0.0f;
    private int activationIndex;
    private final ArrayList<GestureHandler> awaitingHandlers;
    private final HashSet<Integer> awaitingHandlersTags;
    private boolean finishedHandlersCleanupScheduled;
    private final ArrayList<GestureHandler> gestureHandlers;
    private final GestureHandlerRegistry handlerRegistry;
    private int handlingChangeSemaphore;
    private boolean isHandlingTouch;
    private float minimumAlphaForTraversal;
    private final ArrayList<GestureHandler> preparedHandlers;
    private final ViewGroup rootView;
    private final ViewConfigurationHelper viewConfigHelper;
    private final ViewGroup wrapperView;
    public static final Companion Companion = new Companion(null);
    private static final PointF tempPoint = new PointF();
    private static final float[] matrixTransformCoords = new float[2];
    private static final Matrix inverseMatrix = new Matrix();
    private static final float[] tempCoords = new float[2];
    private static final Comparator<GestureHandler> handlersComparator = new Comparator() { // from class: com.swmansion.gesturehandler.core.GestureHandlerOrchestrator$$ExternalSyntheticLambda0
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return GestureHandlerOrchestrator.handlersComparator$lambda$15((GestureHandler) obj, (GestureHandler) obj2);
        }
    };

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PointerEventsConfig.values().length];
            try {
                iArr[PointerEventsConfig.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PointerEventsConfig.BOX_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PointerEventsConfig.BOX_NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PointerEventsConfig.AUTO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public GestureHandlerOrchestrator(@NotNull ViewGroup wrapperView, @NotNull GestureHandlerRegistry handlerRegistry, @NotNull ViewConfigurationHelper viewConfigHelper, @NotNull ViewGroup rootView) {
        Intrinsics.checkNotNullParameter(wrapperView, "wrapperView");
        Intrinsics.checkNotNullParameter(handlerRegistry, "handlerRegistry");
        Intrinsics.checkNotNullParameter(viewConfigHelper, "viewConfigHelper");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        this.wrapperView = wrapperView;
        this.handlerRegistry = handlerRegistry;
        this.viewConfigHelper = viewConfigHelper;
        this.rootView = rootView;
        this.gestureHandlers = new ArrayList<>();
        this.awaitingHandlers = new ArrayList<>();
        this.preparedHandlers = new ArrayList<>();
        this.awaitingHandlersTags = new HashSet<>();
    }

    public final float getMinimumAlphaForTraversal() {
        return this.minimumAlphaForTraversal;
    }

    public final void setMinimumAlphaForTraversal(float f) {
        this.minimumAlphaForTraversal = f;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x001c  */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.isHandlingTouch = true;
        int actionMasked = event.getActionMasked();
        if (actionMasked == 0) {
            extractGestureHandlers(event);
        } else if (actionMasked == 3) {
            cancelAll();
        } else if (actionMasked == 5 || actionMasked == 7) {
            extractGestureHandlers(event);
        }
        deliverEventToGestureHandlers(event);
        this.isHandlingTouch = false;
        if (this.finishedHandlersCleanupScheduled && this.handlingChangeSemaphore == 0) {
            cleanupFinishedHandlers();
        }
        if ((actionMasked == 1 || actionMasked == 3 || actionMasked == 10) && this.gestureHandlers.isEmpty()) {
            ViewGroup viewGroup = this.rootView;
            if (viewGroup instanceof RootView) {
                ((RootView) viewGroup).onChildEndedNativeGesture(viewGroup, event);
            }
        }
        return true;
    }

    public final ArrayList<GestureHandler> getHandlersForView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return this.handlerRegistry.getHandlersForView(view);
    }

    private final void scheduleFinishedHandlersCleanup() {
        if (this.isHandlingTouch || this.handlingChangeSemaphore != 0) {
            this.finishedHandlersCleanupScheduled = true;
        } else {
            cleanupFinishedHandlers();
        }
    }

    private final void cleanupFinishedHandlers() {
        for (GestureHandler gestureHandler : CollectionsKt__ReversedViewsKt.asReversedMutable(this.gestureHandlers)) {
            if (Companion.isFinished(gestureHandler.getState()) && !gestureHandler.isAwaiting()) {
                gestureHandler.reset();
                gestureHandler.setActive(false);
                gestureHandler.setAwaiting(false);
                gestureHandler.setActivationIndex(Integer.MAX_VALUE);
            }
        }
        CollectionsKt__MutableCollectionsKt.removeAll((List) this.gestureHandlers, new Function1() { // from class: com.swmansion.gesturehandler.core.GestureHandlerOrchestrator$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(GestureHandlerOrchestrator.cleanupFinishedHandlers$lambda$1((GestureHandler) obj));
            }
        });
        this.finishedHandlersCleanupScheduled = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean cleanupFinishedHandlers$lambda$1(GestureHandler it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        return Companion.isFinished(it2.getState()) && !it2.isAwaiting();
    }

    private final boolean hasOtherHandlerToWaitFor(GestureHandler gestureHandler) {
        ArrayList<GestureHandler> arrayList = this.gestureHandlers;
        if (arrayList == null || !arrayList.isEmpty()) {
            for (GestureHandler gestureHandler2 : arrayList) {
                Companion companion = Companion;
                if (!companion.isFinished(gestureHandler2.getState()) && companion.shouldHandlerWaitForOther(gestureHandler, gestureHandler2)) {
                    return true;
                }
            }
        }
        return false;
    }

    private final boolean shouldBeCancelledByFinishedHandler(GestureHandler gestureHandler) {
        ArrayList<GestureHandler> arrayList = this.gestureHandlers;
        if (arrayList == null || !arrayList.isEmpty()) {
            for (GestureHandler gestureHandler2 : arrayList) {
                if (Companion.shouldHandlerWaitForOther(gestureHandler, gestureHandler2) && gestureHandler2.getState() == 5) {
                    return true;
                }
            }
        }
        return false;
    }

    private final boolean shouldBeCancelledByActiveHandler(GestureHandler gestureHandler) {
        ArrayList<GestureHandler> arrayList = this.gestureHandlers;
        if (arrayList == null || !arrayList.isEmpty()) {
            for (GestureHandler gestureHandler2 : arrayList) {
                if (gestureHandler.hasCommonPointers(gestureHandler2) && gestureHandler2.getState() == 4 && !Companion.canRunSimultaneously(gestureHandler, gestureHandler2) && gestureHandler.isDescendantOf(gestureHandler2)) {
                    return true;
                }
            }
        }
        return false;
    }

    private final void tryActivate(GestureHandler gestureHandler) {
        if (shouldBeCancelledByFinishedHandler(gestureHandler) || shouldBeCancelledByActiveHandler(gestureHandler)) {
            gestureHandler.cancel();
        } else if (hasOtherHandlerToWaitFor(gestureHandler)) {
            addAwaitingHandler(gestureHandler);
        } else {
            makeActive(gestureHandler);
            gestureHandler.setAwaiting(false);
        }
    }

    private final void cleanupAwaitingHandlers() {
        for (GestureHandler gestureHandler : CollectionsKt___CollectionsKt.toList(this.awaitingHandlers)) {
            if (!gestureHandler.isAwaiting()) {
                this.awaitingHandlers.remove(gestureHandler);
                this.awaitingHandlersTags.remove(Integer.valueOf(gestureHandler.getTag()));
            }
        }
    }

    public final void onHandlerStateChange(@NotNull GestureHandler handler, int i, int i2) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.handlingChangeSemaphore++;
        if (Companion.isFinished(i)) {
            for (GestureHandler gestureHandler : CollectionsKt___CollectionsKt.toList(this.awaitingHandlers)) {
                if (Companion.shouldHandlerWaitForOther(gestureHandler, handler) && this.awaitingHandlersTags.contains(Integer.valueOf(gestureHandler.getTag()))) {
                    if (i == 5) {
                        gestureHandler.cancel();
                        if (gestureHandler.getState() == 5) {
                            gestureHandler.dispatchStateChange(3, 2);
                        }
                        gestureHandler.setAwaiting(false);
                    } else {
                        tryActivate(gestureHandler);
                    }
                }
            }
            cleanupAwaitingHandlers();
        }
        if (i == 4) {
            tryActivate(handler);
        } else if (i2 == 4 || i2 == 5) {
            if (handler.isActive()) {
                handler.dispatchStateChange(i, i2);
            } else if (i2 == 4 && (i == 3 || i == 1)) {
                handler.dispatchStateChange(i, 2);
            }
        } else if (i2 != 0 || i != 3) {
            handler.dispatchStateChange(i, i2);
        }
        this.handlingChangeSemaphore--;
        scheduleFinishedHandlersCleanup();
    }

    private final void makeActive(GestureHandler gestureHandler) {
        int state = gestureHandler.getState();
        gestureHandler.setAwaiting(false);
        gestureHandler.setActive(true);
        gestureHandler.setShouldResetProgress(true);
        int i = this.activationIndex;
        this.activationIndex = i + 1;
        gestureHandler.setActivationIndex(i);
        for (GestureHandler gestureHandler2 : CollectionsKt__ReversedViewsKt.asReversedMutable(this.gestureHandlers)) {
            if (Companion.shouldHandlerBeCancelledBy(gestureHandler2, gestureHandler)) {
                gestureHandler2.cancel();
            }
        }
        for (GestureHandler gestureHandler3 : CollectionsKt__ReversedViewsKt.asReversedMutable(this.awaitingHandlers)) {
            if (Companion.shouldHandlerBeCancelledBy(gestureHandler3, gestureHandler)) {
                gestureHandler3.setAwaiting(false);
            }
        }
        cleanupAwaitingHandlers();
        if (state == 1 || state == 3) {
            return;
        }
        gestureHandler.dispatchStateChange(4, 2);
        if (state != 4) {
            gestureHandler.dispatchStateChange(5, 4);
            if (state != 5) {
                gestureHandler.dispatchStateChange(0, 5);
            }
        }
    }

    private final void deliverEventToGestureHandlers(MotionEvent motionEvent) {
        this.preparedHandlers.clear();
        this.preparedHandlers.addAll(this.gestureHandlers);
        CollectionsKt__MutableCollectionsJVMKt.sortWith(this.preparedHandlers, handlersComparator);
        Iterator<GestureHandler> it2 = this.preparedHandlers.iterator();
        Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
        while (it2.hasNext()) {
            deliverEventToGestureHandler(it2.next(), motionEvent);
        }
    }

    private final void cancelAll() {
        Iterator it2 = CollectionsKt___CollectionsKt.toList(CollectionsKt__ReversedViewsKt.asReversedMutable(this.awaitingHandlers)).iterator();
        while (it2.hasNext()) {
            ((GestureHandler) it2.next()).cancel();
        }
        this.preparedHandlers.clear();
        this.preparedHandlers.addAll(this.gestureHandlers);
        Iterator it3 = CollectionsKt__ReversedViewsKt.asReversedMutable(this.gestureHandlers).iterator();
        while (it3.hasNext()) {
            ((GestureHandler) it3.next()).cancel();
        }
    }

    private final void deliverEventToGestureHandler(GestureHandler gestureHandler, MotionEvent motionEvent) {
        if (!isViewAttachedUnderWrapper(gestureHandler.getView())) {
            gestureHandler.cancel();
            return;
        }
        if (gestureHandler.wantsEvent(motionEvent)) {
            int actionMasked = motionEvent.getActionMasked();
            View view = gestureHandler.getView();
            MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
            Intrinsics.checkNotNullExpressionValue(motionEventObtain, "obtain(...)");
            MotionEvent motionEventTransformEventToViewCoords = transformEventToViewCoords(view, motionEventObtain);
            if (gestureHandler.getNeedsPointerData() && gestureHandler.getState() != 0) {
                gestureHandler.updatePointerData(motionEventTransformEventToViewCoords, motionEvent);
            }
            if (!gestureHandler.isAwaiting() || actionMasked != 2) {
                boolean z = gestureHandler.getState() == 0;
                gestureHandler.handle(motionEventTransformEventToViewCoords, motionEvent);
                if (gestureHandler.isActive()) {
                    if (gestureHandler.getShouldResetProgress()) {
                        gestureHandler.setShouldResetProgress(false);
                        gestureHandler.resetProgress();
                    }
                    gestureHandler.dispatchHandlerUpdate(motionEventTransformEventToViewCoords);
                }
                if (gestureHandler.getNeedsPointerData() && z) {
                    gestureHandler.updatePointerData(motionEventTransformEventToViewCoords, motionEvent);
                }
                if (actionMasked == 1 || actionMasked == 6 || actionMasked == 10) {
                    gestureHandler.stopTrackingPointer(motionEventTransformEventToViewCoords.getPointerId(motionEventTransformEventToViewCoords.getActionIndex()));
                }
            }
            motionEventTransformEventToViewCoords.recycle();
        }
    }

    private final boolean isViewAttachedUnderWrapper(View view) {
        if (view == null) {
            return false;
        }
        if (view == this.wrapperView) {
            return true;
        }
        ViewParent parent = view.getParent();
        while (parent != null && parent != this.wrapperView) {
            parent = parent.getParent();
        }
        return parent == this.wrapperView;
    }

    public final boolean isAnyHandlerActive() {
        ArrayList<GestureHandler> arrayList = this.gestureHandlers;
        if (arrayList == null || !arrayList.isEmpty()) {
            Iterator<T> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                if (((GestureHandler) it2.next()).getState() == 4) {
                    return true;
                }
            }
        }
        return false;
    }

    public final MotionEvent transformEventToViewCoords(@Nullable View view, @NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (view == null) {
            return event;
        }
        ViewParent parent = view.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (!Intrinsics.areEqual(viewGroup, this.wrapperView)) {
            transformEventToViewCoords(viewGroup, event);
        }
        if (viewGroup != null) {
            event.setLocation((event.getX() + viewGroup.getScrollX()) - view.getLeft(), (event.getY() + viewGroup.getScrollY()) - view.getTop());
        }
        if (!view.getMatrix().isIdentity()) {
            Matrix matrix = view.getMatrix();
            Matrix matrix2 = inverseMatrix;
            matrix.invert(matrix2);
            event.transform(matrix2);
        }
        return event;
    }

    public final PointF transformPointToViewCoords(@Nullable View view, @NotNull PointF point) {
        Intrinsics.checkNotNullParameter(point, "point");
        if (view == null) {
            return point;
        }
        ViewParent parent = view.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (!Intrinsics.areEqual(viewGroup, this.wrapperView)) {
            transformPointToViewCoords(viewGroup, point);
        }
        if (viewGroup != null) {
            point.x += viewGroup.getScrollX() - view.getLeft();
            point.y += viewGroup.getScrollY() - view.getTop();
        }
        if (!view.getMatrix().isIdentity()) {
            Matrix matrix = view.getMatrix();
            Matrix matrix2 = inverseMatrix;
            matrix.invert(matrix2);
            float[] fArr = tempCoords;
            fArr[0] = point.x;
            fArr[1] = point.y;
            matrix2.mapPoints(fArr);
            point.x = fArr[0];
            point.y = fArr[1];
        }
        return point;
    }

    private final void addAwaitingHandler(GestureHandler gestureHandler) {
        if (this.awaitingHandlers.contains(gestureHandler)) {
            return;
        }
        this.awaitingHandlers.add(gestureHandler);
        this.awaitingHandlersTags.add(Integer.valueOf(gestureHandler.getTag()));
        gestureHandler.setAwaiting(true);
        int i = this.activationIndex;
        this.activationIndex = i + 1;
        gestureHandler.setActivationIndex(i);
    }

    private final void recordHandlerIfNotPresent(GestureHandler gestureHandler, View view) {
        if (this.gestureHandlers.contains(gestureHandler)) {
            return;
        }
        this.gestureHandlers.add(gestureHandler);
        gestureHandler.setActive(false);
        gestureHandler.setAwaiting(false);
        gestureHandler.setActivationIndex(Integer.MAX_VALUE);
        gestureHandler.prepare(view, this);
    }

    private final boolean isViewOverflowingParent(View view) {
        ViewParent parent = view.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup == null) {
            return false;
        }
        Matrix matrix = view.getMatrix();
        float[] fArr = matrixTransformCoords;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        matrix.mapPoints(fArr);
        float left = fArr[0] + view.getLeft();
        float top = fArr[1] + view.getTop();
        return left < 0.0f || left + ((float) view.getWidth()) > ((float) viewGroup.getWidth()) || top < 0.0f || top + ((float) view.getHeight()) > ((float) viewGroup.getHeight());
    }

    private final boolean extractAncestorHandlers(View view, float[] fArr, int i) {
        boolean z = false;
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof ViewGroup) {
                if ((parent instanceof RNGestureHandlerRootView) && ((RNGestureHandlerRootView) parent).isRootViewEnabled()) {
                    break;
                }
                ViewGroup viewGroup = (ViewGroup) parent;
                ArrayList<GestureHandler> handlersForView = this.handlerRegistry.getHandlersForView((View) parent);
                if (handlersForView != null) {
                    synchronized (handlersForView) {
                        Iterator<GestureHandler> it2 = handlersForView.iterator();
                        Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
                        while (it2.hasNext()) {
                            GestureHandler next = it2.next();
                            if (next.isEnabled() && next.isWithinBounds(view, fArr[0], fArr[1])) {
                                recordHandlerIfNotPresent(next, viewGroup);
                                next.startTrackingPointer(i);
                                z = true;
                            }
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                } else {
                    continue;
                }
            }
        }
        return z;
    }

    private final boolean shouldHandlerSkipHoverEvents(GestureHandler gestureHandler, MotionEvent motionEvent) {
        return ((gestureHandler instanceof HoverGestureHandler) || (gestureHandler instanceof RNGestureHandlerRootHelper.RootViewGestureHandler) || !ExtensionsKt.isHoverAction(motionEvent)) ? false : true;
    }

    private final boolean recordViewHandlersForPointer(View view, float[] fArr, int i, MotionEvent motionEvent) {
        boolean z;
        ArrayList<GestureHandler> handlersForView = this.handlerRegistry.getHandlersForView(view);
        if (handlersForView != null) {
            synchronized (handlersForView) {
                Iterator<GestureHandler> it2 = handlersForView.iterator();
                Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
                z = false;
                while (it2.hasNext()) {
                    GestureHandler next = it2.next();
                    if (next.isEnabled() && next.isWithinBounds(view, fArr[0], fArr[1]) && !shouldHandlerSkipHoverEvents(next, motionEvent)) {
                        recordHandlerIfNotPresent(next, view);
                        next.startTrackingPointer(i);
                        z = true;
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
        } else {
            z = false;
        }
        float width = view.getWidth();
        float f = fArr[0];
        if (0.0f <= f && f <= width) {
            float height = view.getHeight();
            float f2 = fArr[1];
            if (0.0f <= f2 && f2 <= height && isViewOverflowingParent(view) && extractAncestorHandlers(view, fArr, i)) {
                return true;
            }
        }
        return z;
    }

    private final void extractGestureHandlers(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        int pointerId = motionEvent.getPointerId(actionIndex);
        float[] fArr = tempCoords;
        fArr[0] = motionEvent.getX(actionIndex);
        fArr[1] = motionEvent.getY(actionIndex);
        traverseWithPointerEvents(this.wrapperView, fArr, pointerId, motionEvent);
        extractGestureHandlers(this.wrapperView, fArr, pointerId, motionEvent);
    }

    private final boolean shouldIgnoreSubtreeIfGestureHandlerRootView(View view) {
        return (view instanceof RNGestureHandlerRootView) && !Intrinsics.areEqual(view, this.wrapperView) && ((RNGestureHandlerRootView) view).isRootViewEnabled();
    }

    private final boolean extractGestureHandlers(ViewGroup viewGroup, float[] fArr, int i, MotionEvent motionEvent) {
        if (shouldIgnoreSubtreeIfGestureHandlerRootView(viewGroup)) {
            return false;
        }
        for (int childCount = viewGroup.getChildCount() - 1; -1 < childCount; childCount--) {
            View childInDrawingOrderAtIndex = this.viewConfigHelper.getChildInDrawingOrderAtIndex(viewGroup, childCount);
            if (canReceiveEvents(childInDrawingOrderAtIndex)) {
                PointF pointF = tempPoint;
                Companion companion = Companion;
                companion.transformPointToChildViewCoords(fArr[0], fArr[1], viewGroup, childInDrawingOrderAtIndex, pointF);
                float f = fArr[0];
                float f2 = fArr[1];
                fArr[0] = pointF.x;
                fArr[1] = pointF.y;
                boolean zTraverseWithPointerEvents = (!isClipping(childInDrawingOrderAtIndex) || companion.isTransformedTouchPointInView(fArr[0], fArr[1], childInDrawingOrderAtIndex)) ? traverseWithPointerEvents(childInDrawingOrderAtIndex, fArr, i, motionEvent) : false;
                fArr[0] = f;
                fArr[1] = f2;
                if (zTraverseWithPointerEvents) {
                    return true;
                }
            }
        }
        return false;
    }

    private final boolean traverseWithPointerEvents(View view, float[] fArr, int i, MotionEvent motionEvent) {
        if (shouldIgnoreSubtreeIfGestureHandlerRootView(view)) {
            return false;
        }
        int i2 = WhenMappings.$EnumSwitchMapping$0[this.viewConfigHelper.getPointerEventsConfigForView(view).ordinal()];
        if (i2 == 1) {
            return false;
        }
        if (i2 != 2) {
            if (i2 == 3) {
                if (view instanceof ViewGroup) {
                    boolean zExtractGestureHandlers = extractGestureHandlers((ViewGroup) view, fArr, i, motionEvent);
                    if (!zExtractGestureHandlers) {
                        return zExtractGestureHandlers;
                    }
                    recordViewHandlersForPointer(view, fArr, i, motionEvent);
                    return zExtractGestureHandlers;
                }
                if (view instanceof EditText) {
                    return recordViewHandlersForPointer(view, fArr, i, motionEvent);
                }
                return false;
            }
            if (i2 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            boolean zExtractGestureHandlers2 = view instanceof ViewGroup ? extractGestureHandlers((ViewGroup) view, fArr, i, motionEvent) : false;
            if (!recordViewHandlersForPointer(view, fArr, i, motionEvent) && !zExtractGestureHandlers2 && !Companion.shouldHandlerlessViewBecomeTouchTarget(view, fArr)) {
                return false;
            }
        } else if (!recordViewHandlersForPointer(view, fArr, i, motionEvent) && !Companion.shouldHandlerlessViewBecomeTouchTarget(view, fArr)) {
            return false;
        }
        return true;
    }

    private final boolean canReceiveEvents(View view) {
        return view.getVisibility() == 0 && view.getAlpha() >= this.minimumAlphaForTraversal;
    }

    private final boolean isClipping(View view) {
        return !(view instanceof ViewGroup) || this.viewConfigHelper.isViewClippingChildren((ViewGroup) view);
    }

    public final void activateNativeHandlersForView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        ArrayList<GestureHandler> handlersForView = this.handlerRegistry.getHandlersForView(view);
        if (handlersForView != null) {
            for (final GestureHandler gestureHandler : handlersForView) {
                if (gestureHandler instanceof NativeViewGestureHandler) {
                    recordHandlerIfNotPresent(gestureHandler, view);
                    gestureHandler.withMarkedAsInBounds(new Function0() { // from class: com.swmansion.gesturehandler.core.GestureHandlerOrchestrator$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return GestureHandlerOrchestrator.activateNativeHandlersForView$lambda$14$lambda$13(gestureHandler);
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit activateNativeHandlersForView$lambda$14$lambda$13(GestureHandler gestureHandler) {
        gestureHandler.begin();
        gestureHandler.activate();
        gestureHandler.end();
        return Unit.INSTANCE;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isFinished(int i) {
            return i == 3 || i == 1 || i == 5;
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean shouldHandlerlessViewBecomeTouchTarget(View view, float[] fArr) {
            return !((view instanceof ViewGroup) && view.getBackground() == null) && isTransformedTouchPointInView(fArr[0], fArr[1], view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void transformPointToChildViewCoords(float f, float f2, ViewGroup viewGroup, View view, PointF pointF) {
            float scrollX = (f + viewGroup.getScrollX()) - view.getLeft();
            float scrollY = (f2 + viewGroup.getScrollY()) - view.getTop();
            Matrix matrix = view.getMatrix();
            if (!matrix.isIdentity()) {
                float[] fArr = GestureHandlerOrchestrator.matrixTransformCoords;
                fArr[0] = scrollX;
                fArr[1] = scrollY;
                matrix.invert(GestureHandlerOrchestrator.inverseMatrix);
                GestureHandlerOrchestrator.inverseMatrix.mapPoints(fArr);
                float f3 = fArr[0];
                scrollY = fArr[1];
                scrollX = f3;
            }
            pointF.set(scrollX, scrollY);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isTransformedTouchPointInView(float f, float f2, View view) {
            return 0.0f <= f && f <= ((float) view.getWidth()) && 0.0f <= f2 && f2 <= ((float) view.getHeight());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean shouldHandlerWaitForOther(GestureHandler gestureHandler, GestureHandler gestureHandler2) {
            return gestureHandler != gestureHandler2 && (gestureHandler.shouldWaitForHandlerFailure(gestureHandler2) || gestureHandler2.shouldRequireToWaitForFailure(gestureHandler));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean canRunSimultaneously(GestureHandler gestureHandler, GestureHandler gestureHandler2) {
            return gestureHandler == gestureHandler2 || gestureHandler.shouldRecognizeSimultaneously(gestureHandler2) || gestureHandler2.shouldRecognizeSimultaneously(gestureHandler);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean shouldHandlerBeCancelledBy(GestureHandler gestureHandler, GestureHandler gestureHandler2) {
            if (!gestureHandler.hasCommonPointers(gestureHandler2) || canRunSimultaneously(gestureHandler, gestureHandler2)) {
                return false;
            }
            if (gestureHandler == gestureHandler2 || !(gestureHandler.isAwaiting() || gestureHandler.getState() == 4)) {
                return true;
            }
            return gestureHandler.shouldBeCancelledBy(gestureHandler2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int handlersComparator$lambda$15(GestureHandler gestureHandler, GestureHandler gestureHandler2) {
        if ((gestureHandler.isActive() && gestureHandler2.isActive()) || (gestureHandler.isAwaiting() && gestureHandler2.isAwaiting())) {
            return Integer.signum(gestureHandler2.getActivationIndex() - gestureHandler.getActivationIndex());
        }
        if (!gestureHandler.isActive()) {
            if (!gestureHandler2.isActive()) {
                if (!gestureHandler.isAwaiting()) {
                    if (!gestureHandler2.isAwaiting()) {
                        return 0;
                    }
                }
            }
            return 1;
        }
        return -1;
    }
}
