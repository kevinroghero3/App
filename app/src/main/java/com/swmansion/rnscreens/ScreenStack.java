package com.swmansion.rnscreens;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.view.View;
import androidx.fragment.app.FragmentTransaction;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.swmansion.rnscreens.bottomsheet.SheetUtilsKt;
import com.swmansion.rnscreens.events.StackFinishTransitioningEvent;
import com.swmansion.rnscreens.stack.views.ChildrenDrawingOrderStrategy;
import com.swmansion.rnscreens.stack.views.ReverseFromIndex;
import com.swmansion.rnscreens.stack.views.ReverseOrder;
import com.swmansion.rnscreens.stack.views.ScreensCoordinatorLayout;
import com.swmansion.rnscreens.utils.FragmentTransactionKtKt;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt__ReversedViewsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class ScreenStack extends ScreenContainer {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "ScreenStack";
    private ChildrenDrawingOrderStrategy childrenDrawingOrderStrategy;
    private List<View> disappearingTransitioningChildren;
    private final Set<ScreenStackFragmentWrapper> dismissedWrappers;
    private final List<DrawingOp> drawingOpPool;
    private List<DrawingOp> drawingOps;
    private boolean goingForward;
    private boolean removalTransitionStarted;
    private final ArrayList<ScreenStackFragmentWrapper> stack;
    private ScreenStackFragmentWrapper topScreenWrapper;

    /* JADX INFO: loaded from: classes3.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Screen.StackPresentation.values().length];
            try {
                iArr[Screen.StackPresentation.FORM_SHEET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ScreenStack(@Nullable Context context) {
        super(context);
        this.stack = new ArrayList<>();
        this.dismissedWrappers = new HashSet();
        this.drawingOpPool = new ArrayList();
        this.drawingOps = new ArrayList();
        this.disappearingTransitioningChildren = new ArrayList();
    }

    public final boolean getGoingForward() {
        return this.goingForward;
    }

    public final void setGoingForward(boolean z) {
        this.goingForward = z;
    }

    public final void dismiss(@NotNull ScreenStackFragmentWrapper screenFragment) {
        Intrinsics.checkNotNullParameter(screenFragment, "screenFragment");
        this.dismissedWrappers.add(screenFragment);
        performUpdatesNow();
    }

    @Override // com.swmansion.rnscreens.ScreenContainer
    public Screen getTopScreen() {
        ScreenStackFragmentWrapper screenStackFragmentWrapper = this.topScreenWrapper;
        if (screenStackFragmentWrapper != null) {
            return screenStackFragmentWrapper.getScreen();
        }
        return null;
    }

    public final ArrayList<ScreenStackFragmentWrapper> getFragments() {
        return this.stack;
    }

    public final Screen getRootScreen() {
        Object next;
        Screen screen;
        Iterator<T> it2 = this.screenWrappers.iterator();
        do {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
        } while (CollectionsKt___CollectionsKt.contains(this.dismissedWrappers, (ScreenFragmentWrapper) next));
        ScreenFragmentWrapper screenFragmentWrapper = (ScreenFragmentWrapper) next;
        if (screenFragmentWrapper == null || (screen = screenFragmentWrapper.getScreen()) == null) {
            throw new IllegalStateException("[RNScreens] Stack has no root screen set");
        }
        return screen;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.swmansion.rnscreens.ScreenContainer
    public ScreenStackFragmentWrapper adapt(@NotNull Screen screen) {
        Intrinsics.checkNotNullParameter(screen, "screen");
        if (WhenMappings.$EnumSwitchMapping$0[screen.getStackPresentation().ordinal()] == 1) {
            return new ScreenStackFragment(screen);
        }
        return new ScreenStackFragment(screen);
    }

    @Override // android.view.ViewGroup
    public void startViewTransition(@NotNull View view) {
        ChildrenDrawingOrderStrategy childrenDrawingOrderStrategy;
        Intrinsics.checkNotNullParameter(view, "view");
        if (!(view instanceof ScreensCoordinatorLayout)) {
            throw new IllegalStateException(("[RNScreens] Unexpected type of ScreenStack direct subview " + view.getClass()).toString());
        }
        super.startViewTransition(view);
        if (((ScreensCoordinatorLayout) view).getFragment$react_native_screens_release().isRemoving()) {
            this.disappearingTransitioningChildren.add(view);
        }
        if (!this.disappearingTransitioningChildren.isEmpty() && (childrenDrawingOrderStrategy = this.childrenDrawingOrderStrategy) != null) {
            childrenDrawingOrderStrategy.enable();
        }
        this.removalTransitionStarted = true;
    }

    @Override // android.view.ViewGroup
    public void endViewTransition(@NotNull View view) {
        ChildrenDrawingOrderStrategy childrenDrawingOrderStrategy;
        Intrinsics.checkNotNullParameter(view, "view");
        super.endViewTransition(view);
        this.disappearingTransitioningChildren.remove(view);
        if (this.disappearingTransitioningChildren.isEmpty() && (childrenDrawingOrderStrategy = this.childrenDrawingOrderStrategy) != null) {
            childrenDrawingOrderStrategy.disable();
        }
        if (this.removalTransitionStarted) {
            this.removalTransitionStarted = false;
            dispatchOnFinishTransitioning();
        }
    }

    public final void onViewAppearTransitionEnd() {
        if (this.removalTransitionStarted) {
            return;
        }
        dispatchOnFinishTransitioning();
    }

    public final List<String> getScreenIds() {
        ArrayList<ScreenFragmentWrapper> arrayList = this.screenWrappers;
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
        Iterator<T> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.add(((ScreenFragmentWrapper) it2.next()).getScreen().getScreenId());
        }
        return arrayList2;
    }

    private final void dispatchOnFinishTransitioning() {
        int surfaceId = UIManagerHelper.getSurfaceId(this);
        Context context = getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag((ReactContext) context, getId());
        if (eventDispatcherForReactTag != null) {
            eventDispatcherForReactTag.dispatchEvent(new StackFinishTransitioningEvent(surfaceId, getId()));
        }
    }

    @Override // com.swmansion.rnscreens.ScreenContainer
    public void removeScreenAt(int i) {
        Set<ScreenStackFragmentWrapper> set = this.dismissedWrappers;
        TypeIntrinsics.asMutableCollection(set).remove(getScreenFragmentWrapperAt(i));
        super.removeScreenAt(i);
    }

    @Override // com.swmansion.rnscreens.ScreenContainer
    public void removeAllScreens() {
        this.dismissedWrappers.clear();
        super.removeAllScreens();
    }

    @Override // com.swmansion.rnscreens.ScreenContainer
    public boolean hasScreen(@Nullable ScreenFragmentWrapper screenFragmentWrapper) {
        return super.hasScreen(screenFragmentWrapper) && !CollectionsKt___CollectionsKt.contains(this.dismissedWrappers, screenFragmentWrapper);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [T, java.lang.Object] */
    @Override // com.swmansion.rnscreens.ScreenContainer
    public void onUpdate() {
        T t;
        Screen.StackAnimation stackAnimation;
        boolean z;
        Screen screen;
        ScreenStackFragmentWrapper screenStackFragmentWrapper;
        int iCount;
        T t2;
        Screen screen2;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        this.childrenDrawingOrderStrategy = null;
        Sequence sequenceFilter = SequencesKt___SequencesKt.filter(CollectionsKt___CollectionsKt.asSequence(CollectionsKt__ReversedViewsKt.asReversedMutable(this.screenWrappers)), new Function1() { // from class: com.swmansion.rnscreens.ScreenStack$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(ScreenStack.onUpdate$lambda$3(this.f$0, (ScreenFragmentWrapper) obj));
            }
        });
        objectRef.element = SequencesKt___SequencesKt.firstOrNull(sequenceFilter);
        ScreenFragmentWrapper screenFragmentWrapper = (ScreenFragmentWrapper) SequencesKt___SequencesKt.firstOrNull(SequencesKt___SequencesKt.dropWhile(sequenceFilter, new Function1() { // from class: com.swmansion.rnscreens.ScreenStack$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(ScreenStack.onUpdate$lambda$4((ScreenFragmentWrapper) obj));
            }
        }));
        if (screenFragmentWrapper == null || screenFragmentWrapper == objectRef.element) {
            t = screenFragmentWrapper;
            t = 0;
        }
        t = screenFragmentWrapper;
        objectRef2.element = t;
        boolean zContains = CollectionsKt___CollectionsKt.contains(this.stack, objectRef.element);
        T t3 = objectRef.element;
        ScreenStackFragmentWrapper screenStackFragmentWrapper2 = this.topScreenWrapper;
        boolean z2 = t3 != screenStackFragmentWrapper2;
        if (t3 == 0 || zContains) {
            if (t3 == 0 || screenStackFragmentWrapper2 == null || !z2) {
                stackAnimation = null;
                z = true;
            } else {
                stackAnimation = (screenStackFragmentWrapper2 == null || (screen = screenStackFragmentWrapper2.getScreen()) == null) ? null : screen.getStackAnimation();
                z = false;
            }
        } else if (screenStackFragmentWrapper2 != null) {
            z = (screenStackFragmentWrapper2 != null && this.screenWrappers.contains(screenStackFragmentWrapper2)) || (((ScreenFragmentWrapper) objectRef.element).getScreen().getReplaceAnimation() == Screen.ReplaceAnimation.PUSH);
            if (z) {
                screen2 = ((ScreenFragmentWrapper) objectRef.element).getScreen();
            } else {
                ScreenStackFragmentWrapper screenStackFragmentWrapper3 = this.topScreenWrapper;
                if (screenStackFragmentWrapper3 == null || (screen2 = screenStackFragmentWrapper3.getScreen()) == null) {
                    stackAnimation = null;
                }
            }
            stackAnimation = screen2.getStackAnimation();
        } else {
            Screen.StackAnimation stackAnimation2 = Screen.StackAnimation.NONE;
            this.goingForward = true;
            stackAnimation = stackAnimation2;
            z = true;
        }
        this.goingForward = z;
        if (z && (t2 = objectRef.element) != 0 && Companion.needsDrawReordering((ScreenFragmentWrapper) t2, stackAnimation) && objectRef2.element == 0) {
            this.childrenDrawingOrderStrategy = new ReverseOrder();
        } else if (objectRef.element != 0 && zContains && (screenStackFragmentWrapper = this.topScreenWrapper) != null && screenStackFragmentWrapper.isTranslucent() && !((ScreenFragmentWrapper) objectRef.element).isTranslucent() && (iCount = SequencesKt___SequencesKt.count(SequencesKt___SequencesKt.takeWhile(CollectionsKt___CollectionsKt.asSequence(CollectionsKt__ReversedViewsKt.asReversedMutable(this.stack)), new Function1() { // from class: com.swmansion.rnscreens.ScreenStack$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(ScreenStack.onUpdate$lambda$7(objectRef, (ScreenStackFragmentWrapper) obj));
            }
        }))) > 1) {
            this.childrenDrawingOrderStrategy = new ReverseFromIndex(Math.max((CollectionsKt__CollectionsKt.getLastIndex(this.stack) - iCount) + 1, 0));
        }
        FragmentTransaction fragmentTransactionCreateTransaction = createTransaction();
        if (stackAnimation != null) {
            FragmentTransactionKtKt.setTweenAnimations(fragmentTransactionCreateTransaction, stackAnimation, z);
        }
        Iterator it2 = SequencesKt___SequencesKt.filter(CollectionsKt___CollectionsKt.asSequence(this.stack), new Function1() { // from class: com.swmansion.rnscreens.ScreenStack$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(ScreenStack.onUpdate$lambda$17$lambda$8(this.f$0, (ScreenStackFragmentWrapper) obj));
            }
        }).iterator();
        while (it2.hasNext()) {
            fragmentTransactionCreateTransaction.remove(((ScreenStackFragmentWrapper) it2.next()).getFragment());
        }
        Iterator it3 = SequencesKt___SequencesKt.filter(SequencesKt___SequencesKt.takeWhile(CollectionsKt___CollectionsKt.asSequence(this.screenWrappers), new Function1() { // from class: com.swmansion.rnscreens.ScreenStack$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(ScreenStack.onUpdate$lambda$17$lambda$10(objectRef2, (ScreenFragmentWrapper) obj));
            }
        }), new Function1() { // from class: com.swmansion.rnscreens.ScreenStack$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(ScreenStack.onUpdate$lambda$17$lambda$11(objectRef, this, (ScreenFragmentWrapper) obj));
            }
        }).iterator();
        while (it3.hasNext()) {
            fragmentTransactionCreateTransaction.remove(((ScreenFragmentWrapper) it3.next()).getFragment());
        }
        T t4 = objectRef2.element;
        if (t4 != 0 && !((ScreenFragmentWrapper) t4).getFragment().isAdded()) {
            final ScreenFragmentWrapper screenFragmentWrapper2 = (ScreenFragmentWrapper) objectRef.element;
            Iterator it4 = SequencesKt___SequencesKt.dropWhile(CollectionsKt___CollectionsKt.asSequence(this.screenWrappers), new Function1() { // from class: com.swmansion.rnscreens.ScreenStack$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(ScreenStack.onUpdate$lambda$17$lambda$13(objectRef2, (ScreenFragmentWrapper) obj));
                }
            }).iterator();
            while (it4.hasNext()) {
                fragmentTransactionCreateTransaction.add(getId(), ((ScreenFragmentWrapper) it4.next()).getFragment()).runOnCommit(new Runnable() { // from class: com.swmansion.rnscreens.ScreenStack$$ExternalSyntheticLambda7
                    @Override // java.lang.Runnable
                    public final void run() {
                        ScreenStack.onUpdate$lambda$17$lambda$15$lambda$14(screenFragmentWrapper2);
                    }
                });
            }
        } else {
            T t5 = objectRef.element;
            if (t5 != 0 && !((ScreenFragmentWrapper) t5).getFragment().isAdded()) {
                if (SheetUtilsKt.requiresEnterTransitionPostponing(((ScreenFragmentWrapper) objectRef.element).getScreen())) {
                    ((ScreenFragmentWrapper) objectRef.element).getFragment().postponeEnterTransition();
                }
                fragmentTransactionCreateTransaction.add(getId(), ((ScreenFragmentWrapper) objectRef.element).getFragment());
            }
        }
        T t6 = objectRef.element;
        this.topScreenWrapper = t6 instanceof ScreenStackFragmentWrapper ? (ScreenStackFragmentWrapper) t6 : null;
        this.stack.clear();
        CollectionsKt__MutableCollectionsKt.addAll(this.stack, SequencesKt___SequencesKt.map(CollectionsKt___CollectionsKt.asSequence(this.screenWrappers), new Function1() { // from class: com.swmansion.rnscreens.ScreenStack$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ScreenStack.onUpdate$lambda$17$lambda$16((ScreenFragmentWrapper) obj);
            }
        }));
        turnOffA11yUnderTransparentScreen((ScreenFragmentWrapper) objectRef2.element);
        fragmentTransactionCreateTransaction.commitNowAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onUpdate$lambda$3(ScreenStack screenStack, ScreenFragmentWrapper it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        return (CollectionsKt___CollectionsKt.contains(screenStack.dismissedWrappers, it2) || it2.getScreen().getActivityState() == Screen.ActivityState.INACTIVE) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onUpdate$lambda$4(ScreenFragmentWrapper it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        return it2.isTranslucent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onUpdate$lambda$7(Ref.ObjectRef objectRef, ScreenStackFragmentWrapper it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        return it2 != objectRef.element && it2.isTranslucent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onUpdate$lambda$17$lambda$8(ScreenStack screenStack, ScreenStackFragmentWrapper wrapper) {
        Intrinsics.checkNotNullParameter(wrapper, "wrapper");
        return !screenStack.screenWrappers.contains(wrapper) || screenStack.dismissedWrappers.contains(wrapper);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onUpdate$lambda$17$lambda$10(Ref.ObjectRef objectRef, ScreenFragmentWrapper it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        return it2 != objectRef.element;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onUpdate$lambda$17$lambda$11(Ref.ObjectRef objectRef, ScreenStack screenStack, ScreenFragmentWrapper it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        return !(it2 == objectRef.element || CollectionsKt___CollectionsKt.contains(screenStack.dismissedWrappers, it2)) || it2.getScreen().getActivityState() == Screen.ActivityState.INACTIVE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onUpdate$lambda$17$lambda$13(Ref.ObjectRef objectRef, ScreenFragmentWrapper it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        return it2 != objectRef.element;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onUpdate$lambda$17$lambda$15$lambda$14(ScreenFragmentWrapper screenFragmentWrapper) {
        Screen screen;
        if (screenFragmentWrapper == null || (screen = screenFragmentWrapper.getScreen()) == null) {
            return;
        }
        screen.bringToFront();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScreenStackFragmentWrapper onUpdate$lambda$17$lambda$16(ScreenFragmentWrapper it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        return (ScreenStackFragmentWrapper) it2;
    }

    private final void turnOffA11yUnderTransparentScreen(ScreenFragmentWrapper screenFragmentWrapper) {
        ScreenStackFragmentWrapper screenStackFragmentWrapper;
        if (this.screenWrappers.size() > 1 && screenFragmentWrapper != null && (screenStackFragmentWrapper = this.topScreenWrapper) != null && screenStackFragmentWrapper.isTranslucent()) {
            ArrayList<ScreenFragmentWrapper> arrayList = this.screenWrappers;
            for (ScreenFragmentWrapper screenFragmentWrapper2 : CollectionsKt__ReversedViewsKt.asReversed(CollectionsKt___CollectionsKt.slice((List) arrayList, RangesKt___RangesKt.until(0, arrayList.size() - 1)))) {
                screenFragmentWrapper2.getScreen().changeAccessibilityMode(4);
                if (Intrinsics.areEqual(screenFragmentWrapper2, screenFragmentWrapper)) {
                    break;
                }
            }
        }
        Screen topScreen = getTopScreen();
        if (topScreen != null) {
            topScreen.changeAccessibilityMode(0);
        }
    }

    @Override // com.swmansion.rnscreens.ScreenContainer
    protected void notifyContainerUpdate() {
        Iterator<T> it2 = this.stack.iterator();
        while (it2.hasNext()) {
            ((ScreenStackFragmentWrapper) it2.next()).onContainerUpdate();
        }
    }

    private final void drawAndRelease() {
        List<DrawingOp> list = this.drawingOps;
        this.drawingOps = new ArrayList();
        for (DrawingOp drawingOp : list) {
            drawingOp.draw();
            this.drawingOpPool.add(drawingOp);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.dispatchDraw(canvas);
        ChildrenDrawingOrderStrategy childrenDrawingOrderStrategy = this.childrenDrawingOrderStrategy;
        if (childrenDrawingOrderStrategy != null) {
            childrenDrawingOrderStrategy.apply(this.drawingOps);
        }
        drawAndRelease();
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(@NotNull Canvas canvas, @NotNull View child, long j) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(child, "child");
        List<DrawingOp> list = this.drawingOps;
        DrawingOp drawingOpObtainDrawingOp = obtainDrawingOp();
        drawingOpObtainDrawingOp.setCanvas(canvas);
        drawingOpObtainDrawingOp.setChild(child);
        drawingOpObtainDrawingOp.setDrawingTime(j);
        list.add(drawingOpObtainDrawingOp);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void performDraw(DrawingOp drawingOp) {
        Canvas canvas = drawingOp.getCanvas();
        Intrinsics.checkNotNull(canvas);
        super.drawChild(canvas, drawingOp.getChild(), drawingOp.getDrawingTime());
    }

    private final DrawingOp obtainDrawingOp() {
        if (this.drawingOpPool.isEmpty()) {
            return new DrawingOp();
        }
        List<DrawingOp> list = this.drawingOpPool;
        return list.remove(CollectionsKt__CollectionsKt.getLastIndex(list));
    }

    /* JADX INFO: loaded from: classes3.dex */
    public final class DrawingOp {
        private Canvas canvas;
        private View child;
        private long drawingTime;

        public DrawingOp() {
        }

        public final Canvas getCanvas() {
            return this.canvas;
        }

        public final void setCanvas(@Nullable Canvas canvas) {
            this.canvas = canvas;
        }

        public final View getChild() {
            return this.child;
        }

        public final void setChild(@Nullable View view) {
            this.child = view;
        }

        public final long getDrawingTime() {
            return this.drawingTime;
        }

        public final void setDrawingTime(long j) {
            this.drawingTime = j;
        }

        public final void draw() {
            ScreenStack.this.performDraw(this);
            this.canvas = null;
            this.child = null;
            this.drawingTime = 0L;
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean needsDrawReordering(ScreenFragmentWrapper screenFragmentWrapper, Screen.StackAnimation stackAnimation) {
            if (stackAnimation == null) {
                stackAnimation = screenFragmentWrapper.getScreen().getStackAnimation();
            }
            return (Build.VERSION.SDK_INT >= 33 || stackAnimation == Screen.StackAnimation.SLIDE_FROM_BOTTOM || stackAnimation == Screen.StackAnimation.FADE_FROM_BOTTOM || stackAnimation == Screen.StackAnimation.IOS_FROM_RIGHT || stackAnimation == Screen.StackAnimation.IOS_FROM_LEFT) && stackAnimation != Screen.StackAnimation.NONE;
        }
    }
}
