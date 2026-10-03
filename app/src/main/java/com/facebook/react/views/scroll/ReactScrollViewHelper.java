package com.facebook.react.views.scroll;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import android.widget.OverScroller;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.common.ViewUtil;
import com.facebook.react.uimanager.events.EventDispatcher;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class ReactScrollViewHelper {
    public static final String AUTO = "auto";
    private static final String CONTENT_OFFSET_LEFT = "contentOffsetLeft";
    private static final String CONTENT_OFFSET_TOP = "contentOffsetTop";
    private static final boolean DEBUG_MODE = false;
    public static final long MOMENTUM_DELAY = 20;
    public static final String OVER_SCROLL_ALWAYS = "always";
    public static final String OVER_SCROLL_NEVER = "never";
    private static final String SCROLL_AWAY_PADDING_TOP = "scrollAwayPaddingTop";
    public static final int SNAP_ALIGNMENT_CENTER = 2;
    public static final int SNAP_ALIGNMENT_DISABLED = 0;
    public static final int SNAP_ALIGNMENT_END = 3;
    public static final int SNAP_ALIGNMENT_START = 1;
    private static boolean smoothScrollDurationInitialized;
    public static final ReactScrollViewHelper INSTANCE = new ReactScrollViewHelper();
    private static final String TAG = ReactScrollView.class.getSimpleName();
    private static final CopyOnWriteArrayList<WeakReference<ScrollListener>> scrollListeners = new CopyOnWriteArrayList<>();
    private static final CopyOnWriteArrayList<WeakReference<LayoutChangeListener>> layoutChangeListeners = new CopyOnWriteArrayList<>();
    private static int SMOOTH_SCROLL_DURATION = ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION;

    public interface HasFlingAnimator {
        ValueAnimator getFlingAnimator();

        int getFlingExtrapolatedDistance(int i);

        void startFlingAnimator(int i, int i2);
    }

    public interface HasScrollEventThrottle {
        long getLastScrollDispatchTime();

        int getScrollEventThrottle();

        void setLastScrollDispatchTime(long j);

        void setScrollEventThrottle(int i);
    }

    public interface HasScrollState {
        ReactScrollViewScrollState getReactScrollViewScrollState();
    }

    public interface HasSmoothScroll {
        void reactSmoothScrollTo(int i, int i2);

        void scrollToPreservingMomentum(int i, int i2);
    }

    public interface HasStateWrapper {
        StateWrapper getStateWrapper();
    }

    public interface LayoutChangeListener {
        void onLayoutChange(@NotNull ViewGroup viewGroup);
    }

    public interface ScrollListener {
        void onLayout(@Nullable ViewGroup viewGroup);

        void onScroll(@Nullable ViewGroup viewGroup, @Nullable ScrollEventType scrollEventType, float f, float f2);
    }

    private ReactScrollViewHelper() {
    }

    @JvmStatic
    public static final <T extends ViewGroup & HasScrollEventThrottle> void emitScrollEvent(T t, float f, float f2) {
        INSTANCE.emitScrollEvent(t, ScrollEventType.SCROLL, f, f2);
    }

    @JvmStatic
    public static final <T extends ViewGroup & HasScrollEventThrottle> void emitScrollBeginDragEvent(T t) {
        INSTANCE.emitScrollEvent(t, ScrollEventType.BEGIN_DRAG);
    }

    @JvmStatic
    public static final <T extends ViewGroup & HasScrollEventThrottle> void emitScrollEndDragEvent(T t, float f, float f2) {
        INSTANCE.emitScrollEvent(t, ScrollEventType.END_DRAG, f, f2);
    }

    @JvmStatic
    public static final <T extends ViewGroup & HasScrollEventThrottle> void emitScrollMomentumBeginEvent(T t, int i, int i2) {
        INSTANCE.emitScrollEvent(t, ScrollEventType.MOMENTUM_BEGIN, i, i2);
    }

    @JvmStatic
    public static final <T extends ViewGroup & HasScrollEventThrottle> void emitScrollMomentumEndEvent(T t) {
        INSTANCE.emitScrollEvent(t, ScrollEventType.MOMENTUM_END);
    }

    private final <T extends ViewGroup & HasScrollEventThrottle> void emitScrollEvent(T t, ScrollEventType scrollEventType) {
        emitScrollEvent(t, scrollEventType, 0.0f, 0.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <T extends ViewGroup & HasScrollEventThrottle> void emitScrollEvent(T t, ScrollEventType scrollEventType, float f, float f2) {
        View childAt;
        long jCurrentTimeMillis = System.currentTimeMillis();
        T t2 = t;
        if (t2.getScrollEventThrottle() < Math.max(17L, jCurrentTimeMillis - t2.getLastScrollDispatchTime()) && (childAt = t.getChildAt(0)) != null) {
            Iterator<WeakReference<ScrollListener>> it2 = scrollListeners.iterator();
            Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
            while (it2.hasNext()) {
                ScrollListener scrollListener = it2.next().get();
                if (scrollListener != null) {
                    scrollListener.onScroll(t, scrollEventType, f, f2);
                }
            }
            Context context = t.getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
            ReactContext reactContext = (ReactContext) context;
            int surfaceId = UIManagerHelper.getSurfaceId(reactContext);
            EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag(reactContext, t.getId());
            if (eventDispatcherForReactTag != null) {
                eventDispatcherForReactTag.dispatchEvent(ScrollEvent.Companion.obtain(surfaceId, t.getId(), scrollEventType, t.getScrollX(), t.getScrollY(), f, f2, childAt.getWidth(), childAt.getHeight(), t.getWidth(), t.getHeight()));
                t2.setLastScrollDispatchTime(jCurrentTimeMillis);
            }
        }
    }

    @JvmStatic
    public static final void emitLayoutEvent(@NotNull ViewGroup scrollView) {
        Intrinsics.checkNotNullParameter(scrollView, "scrollView");
        Iterator<WeakReference<ScrollListener>> it2 = scrollListeners.iterator();
        Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
        while (it2.hasNext()) {
            ScrollListener scrollListener = it2.next().get();
            if (scrollListener != null) {
                scrollListener.onLayout(scrollView);
            }
        }
    }

    @JvmStatic
    public static final void emitLayoutChangeEvent(@NotNull ViewGroup scrollView) {
        Intrinsics.checkNotNullParameter(scrollView, "scrollView");
        Iterator<WeakReference<LayoutChangeListener>> it2 = layoutChangeListeners.iterator();
        Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
        while (it2.hasNext()) {
            LayoutChangeListener layoutChangeListener = it2.next().get();
            if (layoutChangeListener != null) {
                layoutChangeListener.onLayoutChange(scrollView);
            }
        }
    }

    @JvmStatic
    public static final int parseOverScrollMode(@Nullable String str) {
        if (str != null) {
            int iHashCode = str.hashCode();
            if (iHashCode != -1414557169) {
                if (iHashCode != 3005871) {
                    if (iHashCode == 104712844 && str.equals(OVER_SCROLL_NEVER)) {
                        return 2;
                    }
                } else if (!str.equals("auto")) {
                }
            } else if (str.equals(OVER_SCROLL_ALWAYS)) {
                return 0;
            }
            FLog.w(ReactConstants.TAG, "wrong overScrollMode: " + str);
        }
        return 1;
    }

    @JvmStatic
    public static final int parseSnapToAlignment(@Nullable String str) {
        if (str != null) {
            if (StringsKt__StringsJVMKt.equals("start", str, true)) {
                return 1;
            }
            if (StringsKt__StringsJVMKt.equals("center", str, true)) {
                return 2;
            }
            if (Intrinsics.areEqual(ViewProps.END, str)) {
                return 3;
            }
            FLog.w(ReactConstants.TAG, "wrong snap alignment value: " + str);
        }
        return 0;
    }

    @JvmStatic
    public static final int getDefaultScrollAnimationDuration(@Nullable Context context) {
        if (!smoothScrollDurationInitialized) {
            smoothScrollDurationInitialized = true;
            try {
                SMOOTH_SCROLL_DURATION = new OverScrollerDurationGetter(context).getScrollAnimationDuration();
            } catch (Throwable unused) {
            }
        }
        return SMOOTH_SCROLL_DURATION;
    }

    @JvmStatic
    public static final void addScrollListener(@NotNull ScrollListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        scrollListeners.add(new WeakReference<>(listener));
    }

    @JvmStatic
    public static final void removeScrollListener(@NotNull ScrollListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        scrollListeners.remove(new WeakReference(listener));
    }

    @JvmStatic
    public static final void addLayoutChangeListener(@NotNull LayoutChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        layoutChangeListeners.add(new WeakReference<>(listener));
    }

    @JvmStatic
    public static final void removeLayoutChangeListener(@NotNull LayoutChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        layoutChangeListeners.remove(new WeakReference(listener));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final <T extends ViewGroup & HasFlingAnimator & HasScrollState & HasStateWrapper> void smoothScrollTo(T t, int i, int i2) {
        if (DEBUG_MODE) {
            FLog.i(TAG, "smoothScrollTo[%d] x %d y %d", Integer.valueOf(t.getId()), Integer.valueOf(i), Integer.valueOf(i2));
        }
        T t2 = t;
        ValueAnimator flingAnimator = t2.getFlingAnimator();
        if (flingAnimator.getListeners() == null || flingAnimator.getListeners().size() == 0) {
            INSTANCE.registerFlingAnimator(t);
        }
        t.getReactScrollViewScrollState().setFinalAnimatedPositionScroll(i, i2);
        int scrollX = t.getScrollX();
        int scrollY = t.getScrollY();
        if (scrollX != i) {
            t2.startFlingAnimator(scrollX, i);
        }
        if (scrollY != i2) {
            t2.startFlingAnimator(scrollY, i2);
        }
    }

    @JvmStatic
    public static final <T extends ViewGroup & HasFlingAnimator & HasScrollState> int getNextFlingStartValue(T t, int i, int i2, int i3) {
        ReactScrollViewScrollState reactScrollViewScrollState = t.getReactScrollViewScrollState();
        return (!reactScrollViewScrollState.isFinished() || (reactScrollViewScrollState.isCanceled() && ((i3 != 0 ? i3 / Math.abs(i3) : 0) * (i2 - i) > 0))) ? i2 : i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final <T extends ViewGroup & HasFlingAnimator & HasScrollState & HasStateWrapper> void updateFabricScrollState(T t) {
        INSTANCE.updateFabricScrollState(t, t.getScrollX(), t.getScrollY());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends ViewGroup & HasScrollState & HasStateWrapper> void updateFabricScrollState(T t, int i, int i2) {
        if (DEBUG_MODE) {
            FLog.i(TAG, "updateFabricScrollState[%d] scrollX %d scrollY %d", Integer.valueOf(t.getId()), Integer.valueOf(i), Integer.valueOf(i2));
        }
        if (ViewUtil.getUIManagerType(t.getId()) == 1) {
            return;
        }
        ReactScrollViewScrollState reactScrollViewScrollState = t.getReactScrollViewScrollState();
        if (reactScrollViewScrollState.getLastStateUpdateScroll().equals(i, i2)) {
            return;
        }
        reactScrollViewScrollState.setLastStateUpdateScroll(i, i2);
        forceUpdateState(t);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final <T extends ViewGroup & HasScrollState & HasStateWrapper> void forceUpdateState(T t) {
        ReactScrollViewScrollState reactScrollViewScrollState = t.getReactScrollViewScrollState();
        int scrollAwayPaddingTop = reactScrollViewScrollState.getScrollAwayPaddingTop();
        Point lastStateUpdateScroll = reactScrollViewScrollState.getLastStateUpdateScroll();
        int i = lastStateUpdateScroll.x;
        int i2 = lastStateUpdateScroll.y;
        if (DEBUG_MODE) {
            FLog.i(TAG, "updateFabricScrollState[%d] scrollX %d scrollY %d", Integer.valueOf(t.getId()), Integer.valueOf(i), Integer.valueOf(i2));
        }
        StateWrapper stateWrapper = t.getStateWrapper();
        if (stateWrapper != null) {
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putDouble(CONTENT_OFFSET_LEFT, PixelUtil.toDIPFromPixel(i));
            writableNativeMap.putDouble(CONTENT_OFFSET_TOP, PixelUtil.toDIPFromPixel(i2));
            writableNativeMap.putDouble(SCROLL_AWAY_PADDING_TOP, PixelUtil.toDIPFromPixel(scrollAwayPaddingTop));
            stateWrapper.updateState(writableNativeMap);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final <T extends ViewGroup & HasFlingAnimator & HasScrollEventThrottle & HasScrollState & HasStateWrapper> void updateStateOnScrollChanged(T t, float f, float f2) {
        INSTANCE.updateFabricScrollState(t, t.getScrollX(), t.getScrollY());
        emitScrollEvent(t, f, f2);
    }

    public final <T extends ViewGroup & HasFlingAnimator & HasScrollState & HasStateWrapper> void registerFlingAnimator(final T t) {
        t.getFlingAnimator().addListener(new Animator.AnimatorListener() { // from class: com.facebook.react.views.scroll.ReactScrollViewHelper.registerFlingAnimator.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
                ReactScrollViewScrollState reactScrollViewScrollState = ((HasScrollState) t).getReactScrollViewScrollState();
                reactScrollViewScrollState.setCanceled(false);
                reactScrollViewScrollState.setFinished(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
                ((HasScrollState) t).getReactScrollViewScrollState().setFinished(true);
                ReactScrollViewHelper.updateFabricScrollState(t);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
                ((HasScrollState) t).getReactScrollViewScrollState().setCanceled(true);
            }
        });
    }

    @JvmStatic
    public static final <T extends ViewGroup & HasFlingAnimator & HasScrollEventThrottle> void dispatchMomentumEndOnAnimationEnd(final T t) {
        t.getFlingAnimator().addListener(new Animator.AnimatorListener() { // from class: com.facebook.react.views.scroll.ReactScrollViewHelper.dispatchMomentumEndOnAnimationEnd.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
                ReactScrollViewHelper.emitScrollMomentumEndEvent(t);
                animator.removeListener(this);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
                ReactScrollViewHelper.emitScrollMomentumEndEvent(t);
                animator.removeListener(this);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final <T extends ViewGroup & HasFlingAnimator & HasScrollState> Point predictFinalScrollPosition(T t, int i, int i2, int i3, int i4) {
        ReactScrollViewScrollState reactScrollViewScrollState = t.getReactScrollViewScrollState();
        OverScroller overScroller = new OverScroller(t.getContext());
        overScroller.setFriction(1.0f - reactScrollViewScrollState.getDecelerationRate());
        int width = t.getWidth();
        int paddingStart = t.getPaddingStart();
        int paddingEnd = t.getPaddingEnd();
        int height = t.getHeight();
        int paddingBottom = t.getPaddingBottom();
        int paddingTop = t.getPaddingTop();
        Point finalAnimatedPositionScroll = reactScrollViewScrollState.getFinalAnimatedPositionScroll();
        overScroller.fling(getNextFlingStartValue(t, t.getScrollX(), finalAnimatedPositionScroll.x, i), getNextFlingStartValue(t, t.getScrollY(), finalAnimatedPositionScroll.y, i2), i, i2, 0, i3, 0, i4, ((width - paddingStart) - paddingEnd) / 2, ((height - paddingBottom) - paddingTop) / 2);
        return new Point(overScroller.getFinalX(), overScroller.getFinalY());
    }

    static final class OverScrollerDurationGetter extends OverScroller {
        private int currentScrollAnimationDuration;

        public OverScrollerDurationGetter(@Nullable Context context) {
            super(context);
            this.currentScrollAnimationDuration = ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION;
        }

        public final int getScrollAnimationDuration() {
            super.startScroll(0, 0, 0, 0);
            return this.currentScrollAnimationDuration;
        }

        @Override // android.widget.OverScroller
        public void startScroll(int i, int i2, int i3, int i4, int i5) {
            this.currentScrollAnimationDuration = i5;
        }
    }

    public static final class ReactScrollViewScrollState {
        private boolean isCanceled;
        private int scrollAwayPaddingTop;
        private final Point finalAnimatedPositionScroll = new Point();
        private final Point lastStateUpdateScroll = new Point(-1, -1);
        private boolean isFinished = true;
        private float decelerationRate = 0.985f;

        public final Point getFinalAnimatedPositionScroll() {
            return this.finalAnimatedPositionScroll;
        }

        public final int getScrollAwayPaddingTop() {
            return this.scrollAwayPaddingTop;
        }

        public final void setScrollAwayPaddingTop(int i) {
            this.scrollAwayPaddingTop = i;
        }

        public final Point getLastStateUpdateScroll() {
            return this.lastStateUpdateScroll;
        }

        public final boolean isCanceled() {
            return this.isCanceled;
        }

        public final void setCanceled(boolean z) {
            this.isCanceled = z;
        }

        public final boolean isFinished() {
            return this.isFinished;
        }

        public final void setFinished(boolean z) {
            this.isFinished = z;
        }

        public final float getDecelerationRate() {
            return this.decelerationRate;
        }

        public final void setDecelerationRate(float f) {
            this.decelerationRate = f;
        }

        public final ReactScrollViewScrollState setFinalAnimatedPositionScroll(int i, int i2) {
            this.finalAnimatedPositionScroll.set(i, i2);
            return this;
        }

        public final ReactScrollViewScrollState setLastStateUpdateScroll(int i, int i2) {
            this.lastStateUpdateScroll.set(i, i2);
            return this;
        }
    }
}
