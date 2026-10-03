package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.activity.BackEventCompat;
import androidx.collection.ArrayMap;
import androidx.core.app.SharedElementCallback;
import androidx.core.os.CancellationSignal;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupCompat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class DefaultSpecialEffectsController extends SpecialEffectsController {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultSpecialEffectsController(@NotNull ViewGroup container) {
        super(container);
        Intrinsics.checkNotNullParameter(container, "container");
    }

    @Override // androidx.fragment.app.SpecialEffectsController
    public void collectEffects(@NotNull List<? extends SpecialEffectsController.Operation> operations, boolean z) {
        SpecialEffectsController.Operation operation;
        Object next;
        Intrinsics.checkNotNullParameter(operations, "operations");
        Iterator<T> it2 = operations.iterator();
        while (true) {
            operation = null;
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
            SpecialEffectsController.Operation operation2 = (SpecialEffectsController.Operation) next;
            SpecialEffectsController.Operation.State.Companion companion = SpecialEffectsController.Operation.State.Companion;
            View view = operation2.getFragment().mView;
            Intrinsics.checkNotNullExpressionValue(view, "operation.fragment.mView");
            SpecialEffectsController.Operation.State stateAsOperationState = companion.asOperationState(view);
            SpecialEffectsController.Operation.State state = SpecialEffectsController.Operation.State.VISIBLE;
            if (stateAsOperationState == state && operation2.getFinalState() != state) {
                break;
            }
        }
        SpecialEffectsController.Operation operation3 = (SpecialEffectsController.Operation) next;
        ListIterator<? extends SpecialEffectsController.Operation> listIterator = operations.listIterator(operations.size());
        while (listIterator.hasPrevious()) {
            SpecialEffectsController.Operation operationPrevious = listIterator.previous();
            SpecialEffectsController.Operation operation4 = operationPrevious;
            SpecialEffectsController.Operation.State.Companion companion2 = SpecialEffectsController.Operation.State.Companion;
            View view2 = operation4.getFragment().mView;
            Intrinsics.checkNotNullExpressionValue(view2, "operation.fragment.mView");
            SpecialEffectsController.Operation.State stateAsOperationState2 = companion2.asOperationState(view2);
            SpecialEffectsController.Operation.State state2 = SpecialEffectsController.Operation.State.VISIBLE;
            if (stateAsOperationState2 != state2 && operation4.getFinalState() == state2) {
                operation = operationPrevious;
                break;
            }
        }
        SpecialEffectsController.Operation operation5 = operation;
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "Executing operations from " + operation3 + " to " + operation5);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        syncAnimations(operations);
        Iterator<? extends SpecialEffectsController.Operation> it3 = operations.iterator();
        while (it3.hasNext()) {
            final SpecialEffectsController.Operation next2 = it3.next();
            arrayList.add(new AnimationInfo(next2, z));
            arrayList2.add(new TransitionInfo(next2, z, !z ? next2 != operation5 : next2 != operation3));
            next2.addCompletionListener(new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    DefaultSpecialEffectsController.collectEffects$lambda$2(this.f$0, next2);
                }
            });
        }
        createTransitionEffect(arrayList2, z, operation3, operation5);
        collectAnimEffects(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void collectEffects$lambda$2(DefaultSpecialEffectsController this$0, SpecialEffectsController.Operation operation) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(operation, "$operation");
        this$0.applyContainerChangesToOperation$fragment_release(operation);
    }

    private final void syncAnimations(List<? extends SpecialEffectsController.Operation> list) {
        Fragment fragment = ((SpecialEffectsController.Operation) CollectionsKt___CollectionsKt.last((List) list)).getFragment();
        for (SpecialEffectsController.Operation operation : list) {
            operation.getFragment().mAnimationInfo.mEnterAnim = fragment.mAnimationInfo.mEnterAnim;
            operation.getFragment().mAnimationInfo.mExitAnim = fragment.mAnimationInfo.mExitAnim;
            operation.getFragment().mAnimationInfo.mPopEnterAnim = fragment.mAnimationInfo.mPopEnterAnim;
            operation.getFragment().mAnimationInfo.mPopExitAnim = fragment.mAnimationInfo.mPopExitAnim;
        }
    }

    private final void collectAnimEffects(List<AnimationInfo> list) {
        ArrayList<AnimationInfo> arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList2, ((AnimationInfo) it2.next()).getOperation().getEffects$fragment_release());
        }
        boolean zIsEmpty = arrayList2.isEmpty();
        boolean z = false;
        for (AnimationInfo animationInfo : list) {
            Context context = getContainer().getContext();
            SpecialEffectsController.Operation operation = animationInfo.getOperation();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            FragmentAnim.AnimationOrAnimator animation = animationInfo.getAnimation(context);
            if (animation != null) {
                if (animation.animator == null) {
                    arrayList.add(animationInfo);
                } else {
                    Fragment fragment = operation.getFragment();
                    if (!operation.getEffects$fragment_release().isEmpty()) {
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Log.v(FragmentManager.TAG, "Ignoring Animator set on " + fragment + " as this Fragment was involved in a Transition.");
                        }
                    } else {
                        if (operation.getFinalState() == SpecialEffectsController.Operation.State.GONE) {
                            operation.setAwaitingContainerChanges(false);
                        }
                        operation.addEffect(new AnimatorEffect(animationInfo));
                        z = true;
                    }
                }
            }
        }
        for (AnimationInfo animationInfo2 : arrayList) {
            SpecialEffectsController.Operation operation2 = animationInfo2.getOperation();
            Fragment fragment2 = operation2.getFragment();
            if (zIsEmpty) {
                if (z) {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v(FragmentManager.TAG, "Ignoring Animation set on " + fragment2 + " as Animations cannot run alongside Animators.");
                    }
                } else {
                    operation2.addEffect(new AnimationEffect(animationInfo2));
                }
            } else if (FragmentManager.isLoggingEnabled(2)) {
                Log.v(FragmentManager.TAG, "Ignoring Animation set on " + fragment2 + " as Animations cannot run alongside Transitions.");
            }
        }
    }

    private final void createTransitionEffect(List<TransitionInfo> list, boolean z, SpecialEffectsController.Operation operation, SpecialEffectsController.Operation operation2) {
        ArrayList<String> arrayList;
        ArrayList<String> arrayList2;
        Object obj;
        FragmentTransitionImpl fragmentTransitionImpl;
        ArrayList arrayList3;
        ArrayList arrayList4;
        Iterator it2;
        ArrayList arrayList5;
        ArrayList<String> sharedElementSourceNames;
        ArrayList<String> sharedElementTargetNames;
        Pair pair;
        Object obj2;
        String strFindKeyForValue;
        ArrayList arrayList6 = new ArrayList();
        for (Object obj3 : list) {
            if (!((TransitionInfo) obj3).isVisibilityUnchanged()) {
                arrayList6.add(obj3);
            }
        }
        ArrayList<TransitionInfo> arrayList7 = new ArrayList();
        for (Object obj4 : arrayList6) {
            if (((TransitionInfo) obj4).getHandlingImpl() != null) {
                arrayList7.add(obj4);
            }
        }
        FragmentTransitionImpl fragmentTransitionImpl2 = null;
        for (TransitionInfo transitionInfo : arrayList7) {
            FragmentTransitionImpl handlingImpl = transitionInfo.getHandlingImpl();
            if (fragmentTransitionImpl2 != null && handlingImpl != fragmentTransitionImpl2) {
                throw new IllegalArgumentException(("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + transitionInfo.getOperation().getFragment() + " returned Transition " + transitionInfo.getTransition() + " which uses a different Transition type than other Fragments.").toString());
            }
            fragmentTransitionImpl2 = handlingImpl;
        }
        if (fragmentTransitionImpl2 == null) {
            return;
        }
        ArrayList arrayList8 = new ArrayList();
        ArrayList arrayList9 = new ArrayList();
        ArrayMap arrayMap = new ArrayMap();
        ArrayList<String> arrayList10 = new ArrayList<>();
        ArrayList<String> arrayList11 = new ArrayList<>();
        ArrayMap<String, View> arrayMap2 = new ArrayMap<>();
        ArrayMap<String, View> arrayMap3 = new ArrayMap<>();
        Iterator it3 = arrayList7.iterator();
        loop3: while (true) {
            arrayList = arrayList10;
            arrayList2 = arrayList11;
            obj = null;
            while (true) {
                if (!it3.hasNext()) {
                    break loop3;
                }
                TransitionInfo transitionInfo2 = (TransitionInfo) it3.next();
                if (!transitionInfo2.hasSharedElementTransition() || operation == null || operation2 == null) {
                    fragmentTransitionImpl = fragmentTransitionImpl2;
                    arrayList3 = arrayList8;
                    arrayList4 = arrayList9;
                    it2 = it3;
                    arrayList5 = arrayList7;
                } else {
                    Object objWrapTransitionInSet = fragmentTransitionImpl2.wrapTransitionInSet(fragmentTransitionImpl2.cloneTransition(transitionInfo2.getSharedElementTransition()));
                    sharedElementSourceNames = operation2.getFragment().getSharedElementSourceNames();
                    Intrinsics.checkNotNullExpressionValue(sharedElementSourceNames, "lastIn.fragment.sharedElementSourceNames");
                    ArrayList<String> sharedElementSourceNames2 = operation.getFragment().getSharedElementSourceNames();
                    Intrinsics.checkNotNullExpressionValue(sharedElementSourceNames2, "firstOut.fragment.sharedElementSourceNames");
                    ArrayList<String> sharedElementTargetNames2 = operation.getFragment().getSharedElementTargetNames();
                    Intrinsics.checkNotNullExpressionValue(sharedElementTargetNames2, "firstOut.fragment.sharedElementTargetNames");
                    int size = sharedElementTargetNames2.size();
                    it2 = it3;
                    int i = 0;
                    while (i < size) {
                        int i2 = size;
                        int iIndexOf = sharedElementSourceNames.indexOf(sharedElementTargetNames2.get(i));
                        ArrayList<String> arrayList12 = sharedElementTargetNames2;
                        if (iIndexOf != -1) {
                            sharedElementSourceNames.set(iIndexOf, sharedElementSourceNames2.get(i));
                        }
                        i++;
                        size = i2;
                        sharedElementTargetNames2 = arrayList12;
                    }
                    sharedElementTargetNames = operation2.getFragment().getSharedElementTargetNames();
                    Intrinsics.checkNotNullExpressionValue(sharedElementTargetNames, "lastIn.fragment.sharedElementTargetNames");
                    if (!z) {
                        pair = TuplesKt.to(operation.getFragment().getExitTransitionCallback(), operation2.getFragment().getEnterTransitionCallback());
                    } else {
                        pair = TuplesKt.to(operation.getFragment().getEnterTransitionCallback(), operation2.getFragment().getExitTransitionCallback());
                    }
                    SharedElementCallback sharedElementCallback = (SharedElementCallback) pair.component1();
                    SharedElementCallback sharedElementCallback2 = (SharedElementCallback) pair.component2();
                    int size2 = sharedElementSourceNames.size();
                    fragmentTransitionImpl = fragmentTransitionImpl2;
                    int i3 = 0;
                    arrayList5 = arrayList7;
                    while (true) {
                        arrayList4 = arrayList9;
                        if (i3 >= size2) {
                            break;
                        }
                        int i4 = size2;
                        String str = sharedElementSourceNames.get(i3);
                        Intrinsics.checkNotNullExpressionValue(str, "exitingNames[i]");
                        String str2 = sharedElementTargetNames.get(i3);
                        Intrinsics.checkNotNullExpressionValue(str2, "enteringNames[i]");
                        arrayMap.put(str, str2);
                        i3++;
                        arrayList9 = arrayList4;
                        size2 = i4;
                    }
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v(FragmentManager.TAG, ">>> entering view names <<<");
                        Iterator<String> it4 = sharedElementTargetNames.iterator();
                        while (true) {
                            arrayList3 = arrayList8;
                            if (!it4.hasNext()) {
                                break;
                            }
                            Iterator<String> it5 = it4;
                            Log.v(FragmentManager.TAG, "Name: " + it4.next());
                            objWrapTransitionInSet = objWrapTransitionInSet;
                            arrayList8 = arrayList3;
                            it4 = it5;
                        }
                        obj2 = objWrapTransitionInSet;
                        Log.v(FragmentManager.TAG, ">>> exiting view names <<<");
                        for (Iterator<String> it6 = sharedElementSourceNames.iterator(); it6.hasNext(); it6 = it6) {
                            Log.v(FragmentManager.TAG, "Name: " + it6.next());
                        }
                    } else {
                        obj2 = objWrapTransitionInSet;
                        arrayList3 = arrayList8;
                    }
                    View view = operation.getFragment().mView;
                    Intrinsics.checkNotNullExpressionValue(view, "firstOut.fragment.mView");
                    findNamedViews(arrayMap2, view);
                    arrayMap2.retainAll(sharedElementSourceNames);
                    if (sharedElementCallback != null) {
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Log.v(FragmentManager.TAG, "Executing exit callback for operation " + operation);
                        }
                        sharedElementCallback.onMapSharedElements(sharedElementSourceNames, arrayMap2);
                        int size3 = sharedElementSourceNames.size() - 1;
                        if (size3 >= 0) {
                            while (true) {
                                int i5 = size3 - 1;
                                String str3 = sharedElementSourceNames.get(size3);
                                Intrinsics.checkNotNullExpressionValue(str3, "exitingNames[i]");
                                String str4 = str3;
                                View view2 = arrayMap2.get(str4);
                                if (view2 == null) {
                                    arrayMap.remove(str4);
                                } else if (!Intrinsics.areEqual(str4, ViewCompat.getTransitionName(view2))) {
                                    arrayMap.put(ViewCompat.getTransitionName(view2), (String) arrayMap.remove(str4));
                                }
                                if (i5 < 0) {
                                    break;
                                } else {
                                    size3 = i5;
                                }
                            }
                        }
                    } else {
                        arrayMap.retainAll(arrayMap2.keySet());
                    }
                    View view3 = operation2.getFragment().mView;
                    Intrinsics.checkNotNullExpressionValue(view3, "lastIn.fragment.mView");
                    findNamedViews(arrayMap3, view3);
                    arrayMap3.retainAll(sharedElementTargetNames);
                    arrayMap3.retainAll(arrayMap.values());
                    if (sharedElementCallback2 != null) {
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Log.v(FragmentManager.TAG, "Executing enter callback for operation " + operation2);
                        }
                        sharedElementCallback2.onMapSharedElements(sharedElementTargetNames, arrayMap3);
                        int size4 = sharedElementTargetNames.size() - 1;
                        if (size4 >= 0) {
                            while (true) {
                                int i6 = size4 - 1;
                                String str5 = sharedElementTargetNames.get(size4);
                                Intrinsics.checkNotNullExpressionValue(str5, "enteringNames[i]");
                                String str6 = str5;
                                View view4 = arrayMap3.get(str6);
                                if (view4 == null) {
                                    String strFindKeyForValue2 = FragmentTransition.findKeyForValue(arrayMap, str6);
                                    if (strFindKeyForValue2 != null) {
                                        arrayMap.remove(strFindKeyForValue2);
                                    }
                                } else if (!Intrinsics.areEqual(str6, ViewCompat.getTransitionName(view4)) && (strFindKeyForValue = FragmentTransition.findKeyForValue(arrayMap, str6)) != null) {
                                    arrayMap.put(strFindKeyForValue, ViewCompat.getTransitionName(view4));
                                }
                                if (i6 < 0) {
                                    break;
                                } else {
                                    size4 = i6;
                                }
                            }
                        }
                    } else {
                        FragmentTransition.retainValues(arrayMap, arrayMap3);
                    }
                    Collection<String> collectionKeySet = arrayMap.keySet();
                    Intrinsics.checkNotNullExpressionValue(collectionKeySet, "sharedElementNameMapping.keys");
                    retainMatchingViews(arrayMap2, collectionKeySet);
                    Collection<String> collectionValues = arrayMap.values();
                    Intrinsics.checkNotNullExpressionValue(collectionValues, "sharedElementNameMapping.values");
                    retainMatchingViews(arrayMap3, collectionValues);
                    if (arrayMap.isEmpty()) {
                        break;
                    }
                    arrayList2 = sharedElementSourceNames;
                    arrayList = sharedElementTargetNames;
                    obj = obj2;
                }
                arrayList7 = arrayList5;
                it3 = it2;
                fragmentTransitionImpl2 = fragmentTransitionImpl;
                arrayList9 = arrayList4;
                arrayList8 = arrayList3;
            }
            Log.i(FragmentManager.TAG, "Ignoring shared elements transition " + obj2 + " between " + operation + " and " + operation2 + " as there are no matching elements in both the entering and exiting fragment. In order to run a SharedElementTransition, both fragments involved must have the element.");
            arrayList3.clear();
            arrayList4.clear();
            arrayList11 = sharedElementSourceNames;
            arrayList10 = sharedElementTargetNames;
            arrayList7 = arrayList5;
            it3 = it2;
            fragmentTransitionImpl2 = fragmentTransitionImpl;
            arrayList9 = arrayList4;
            arrayList8 = arrayList3;
        }
        FragmentTransitionImpl fragmentTransitionImpl3 = fragmentTransitionImpl2;
        ArrayList arrayList13 = arrayList8;
        ArrayList arrayList14 = arrayList9;
        ArrayList arrayList15 = arrayList7;
        if (obj == null) {
            if (arrayList15.isEmpty()) {
                return;
            }
            Iterator it7 = arrayList15.iterator();
            while (it7.hasNext()) {
                if (((TransitionInfo) it7.next()).getTransition() == null) {
                }
            }
            return;
        }
        TransitionEffect transitionEffect = new TransitionEffect(arrayList15, operation, operation2, fragmentTransitionImpl3, obj, arrayList13, arrayList14, arrayMap, arrayList, arrayList2, arrayMap2, arrayMap3, z);
        Iterator it8 = arrayList15.iterator();
        while (it8.hasNext()) {
            ((TransitionInfo) it8.next()).getOperation().addEffect(transitionEffect);
        }
    }

    private final void retainMatchingViews(ArrayMap<String, View> arrayMap, final Collection<String> collection) {
        Set<Map.Entry<String, View>> entries = arrayMap.entrySet();
        Intrinsics.checkNotNullExpressionValue(entries, "entries");
        CollectionsKt__MutableCollectionsKt.retainAll(entries, new Function1<Map.Entry<String, View>, Boolean>() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.retainMatchingViews.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(@NotNull Map.Entry<String, View> entry) {
                Intrinsics.checkNotNullParameter(entry, "entry");
                return Boolean.valueOf(CollectionsKt___CollectionsKt.contains(collection, ViewCompat.getTransitionName(entry.getValue())));
            }
        });
    }

    private final void findNamedViews(Map<String, View> map, View view) {
        String transitionName = ViewCompat.getTransitionName(view);
        if (transitionName != null) {
            map.put(transitionName, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View child = viewGroup.getChildAt(i);
                if (child.getVisibility() == 0) {
                    Intrinsics.checkNotNullExpressionValue(child, "child");
                    findNamedViews(map, child);
                }
            }
        }
    }

    public static class SpecialEffectsInfo {
        private final SpecialEffectsController.Operation operation;

        public SpecialEffectsInfo(@NotNull SpecialEffectsController.Operation operation) {
            Intrinsics.checkNotNullParameter(operation, "operation");
            this.operation = operation;
        }

        public final SpecialEffectsController.Operation getOperation() {
            return this.operation;
        }

        public final boolean isVisibilityUnchanged() {
            SpecialEffectsController.Operation.State state;
            View view = this.operation.getFragment().mView;
            SpecialEffectsController.Operation.State stateAsOperationState = view != null ? SpecialEffectsController.Operation.State.Companion.asOperationState(view) : null;
            SpecialEffectsController.Operation.State finalState = this.operation.getFinalState();
            return stateAsOperationState == finalState || !(stateAsOperationState == (state = SpecialEffectsController.Operation.State.VISIBLE) || finalState == state);
        }
    }

    static final class AnimationInfo extends SpecialEffectsInfo {
        private FragmentAnim.AnimationOrAnimator animation;
        private boolean isAnimLoaded;
        private final boolean isPop;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnimationInfo(@NotNull SpecialEffectsController.Operation operation, boolean z) {
            super(operation);
            Intrinsics.checkNotNullParameter(operation, "operation");
            this.isPop = z;
        }

        public final FragmentAnim.AnimationOrAnimator getAnimation(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (this.isAnimLoaded) {
                return this.animation;
            }
            FragmentAnim.AnimationOrAnimator animationOrAnimatorLoadAnimation = FragmentAnim.loadAnimation(context, getOperation().getFragment(), getOperation().getFinalState() == SpecialEffectsController.Operation.State.VISIBLE, this.isPop);
            this.animation = animationOrAnimatorLoadAnimation;
            this.isAnimLoaded = true;
            return animationOrAnimatorLoadAnimation;
        }
    }

    static final class TransitionInfo extends SpecialEffectsInfo {
        private final boolean isOverlapAllowed;
        private final Object sharedElementTransition;
        private final Object transition;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TransitionInfo(@NotNull SpecialEffectsController.Operation operation, boolean z, boolean z2) {
            Object returnTransition;
            boolean allowEnterTransitionOverlap;
            Object sharedElementEnterTransition;
            super(operation);
            Intrinsics.checkNotNullParameter(operation, "operation");
            SpecialEffectsController.Operation.State finalState = operation.getFinalState();
            SpecialEffectsController.Operation.State state = SpecialEffectsController.Operation.State.VISIBLE;
            if (finalState == state) {
                Fragment fragment = operation.getFragment();
                returnTransition = z ? fragment.getReenterTransition() : fragment.getEnterTransition();
            } else {
                Fragment fragment2 = operation.getFragment();
                returnTransition = z ? fragment2.getReturnTransition() : fragment2.getExitTransition();
            }
            this.transition = returnTransition;
            if (operation.getFinalState() != state) {
                allowEnterTransitionOverlap = true;
            } else if (z) {
                allowEnterTransitionOverlap = operation.getFragment().getAllowReturnTransitionOverlap();
            } else {
                allowEnterTransitionOverlap = operation.getFragment().getAllowEnterTransitionOverlap();
            }
            this.isOverlapAllowed = allowEnterTransitionOverlap;
            if (!z2) {
                sharedElementEnterTransition = null;
            } else if (z) {
                sharedElementEnterTransition = operation.getFragment().getSharedElementReturnTransition();
            } else {
                sharedElementEnterTransition = operation.getFragment().getSharedElementEnterTransition();
            }
            this.sharedElementTransition = sharedElementEnterTransition;
        }

        public final Object getTransition() {
            return this.transition;
        }

        public final boolean isOverlapAllowed() {
            return this.isOverlapAllowed;
        }

        public final Object getSharedElementTransition() {
            return this.sharedElementTransition;
        }

        public final boolean hasSharedElementTransition() {
            return this.sharedElementTransition != null;
        }

        public final FragmentTransitionImpl getHandlingImpl() {
            FragmentTransitionImpl handlingImpl = getHandlingImpl(this.transition);
            FragmentTransitionImpl handlingImpl2 = getHandlingImpl(this.sharedElementTransition);
            if (handlingImpl == null || handlingImpl2 == null || handlingImpl == handlingImpl2) {
                return handlingImpl == null ? handlingImpl2 : handlingImpl;
            }
            throw new IllegalArgumentException(("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + getOperation().getFragment() + " returned Transition " + this.transition + " which uses a different Transition  type than its shared element transition " + this.sharedElementTransition).toString());
        }

        private final FragmentTransitionImpl getHandlingImpl(Object obj) {
            if (obj == null) {
                return null;
            }
            FragmentTransitionImpl fragmentTransitionImpl = FragmentTransition.PLATFORM_IMPL;
            if (fragmentTransitionImpl != null && fragmentTransitionImpl.canHandle(obj)) {
                return fragmentTransitionImpl;
            }
            FragmentTransitionImpl fragmentTransitionImpl2 = FragmentTransition.SUPPORT_IMPL;
            if (fragmentTransitionImpl2 != null && fragmentTransitionImpl2.canHandle(obj)) {
                return fragmentTransitionImpl2;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + getOperation().getFragment() + " is not a valid framework Transition or AndroidX Transition");
        }
    }

    static final class AnimationEffect extends SpecialEffectsController.Effect {
        private final AnimationInfo animationInfo;

        public AnimationEffect(@NotNull AnimationInfo animationInfo) {
            Intrinsics.checkNotNullParameter(animationInfo, "animationInfo");
            this.animationInfo = animationInfo;
        }

        public final AnimationInfo getAnimationInfo() {
            return this.animationInfo;
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Effect
        public void onCommit(@NotNull ViewGroup container) {
            Intrinsics.checkNotNullParameter(container, "container");
            if (this.animationInfo.isVisibilityUnchanged()) {
                this.animationInfo.getOperation().completeEffect(this);
                return;
            }
            Context context = container.getContext();
            SpecialEffectsController.Operation operation = this.animationInfo.getOperation();
            View view = operation.getFragment().mView;
            AnimationInfo animationInfo = this.animationInfo;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            FragmentAnim.AnimationOrAnimator animation = animationInfo.getAnimation(context);
            if (animation == null) {
                throw new IllegalStateException("Required value was null.");
            }
            Animation animation2 = animation.animation;
            if (animation2 == null) {
                throw new IllegalStateException("Required value was null.");
            }
            if (operation.getFinalState() != SpecialEffectsController.Operation.State.REMOVED) {
                view.startAnimation(animation2);
                this.animationInfo.getOperation().completeEffect(this);
                return;
            }
            container.startViewTransition(view);
            FragmentAnim.EndViewTransitionAnimation endViewTransitionAnimation = new FragmentAnim.EndViewTransitionAnimation(animation2, container, view);
            endViewTransitionAnimation.setAnimationListener(new DefaultSpecialEffectsController$AnimationEffect$onCommit$1(operation, container, view, this));
            view.startAnimation(endViewTransitionAnimation);
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v(FragmentManager.TAG, "Animation from operation " + operation + " has started.");
            }
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Effect
        public void onCancel(@NotNull ViewGroup container) {
            Intrinsics.checkNotNullParameter(container, "container");
            SpecialEffectsController.Operation operation = this.animationInfo.getOperation();
            View view = operation.getFragment().mView;
            view.clearAnimation();
            container.endViewTransition(view);
            this.animationInfo.getOperation().completeEffect(this);
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v(FragmentManager.TAG, "Animation from operation " + operation + " has been cancelled.");
            }
        }
    }

    static final class AnimatorEffect extends SpecialEffectsController.Effect {
        private AnimatorSet animator;
        private final AnimationInfo animatorInfo;

        @Override // androidx.fragment.app.SpecialEffectsController.Effect
        public boolean isSeekingSupported() {
            return true;
        }

        public AnimatorEffect(@NotNull AnimationInfo animatorInfo) {
            Intrinsics.checkNotNullParameter(animatorInfo, "animatorInfo");
            this.animatorInfo = animatorInfo;
        }

        public final AnimationInfo getAnimatorInfo() {
            return this.animatorInfo;
        }

        public final AnimatorSet getAnimator() {
            return this.animator;
        }

        public final void setAnimator(@Nullable AnimatorSet animatorSet) {
            this.animator = animatorSet;
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Effect
        public void onStart(@NotNull final ViewGroup container) {
            Intrinsics.checkNotNullParameter(container, "container");
            if (this.animatorInfo.isVisibilityUnchanged()) {
                return;
            }
            Context context = container.getContext();
            AnimationInfo animationInfo = this.animatorInfo;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            FragmentAnim.AnimationOrAnimator animation = animationInfo.getAnimation(context);
            this.animator = animation != null ? animation.animator : null;
            final SpecialEffectsController.Operation operation = this.animatorInfo.getOperation();
            Fragment fragment = operation.getFragment();
            final boolean z = operation.getFinalState() == SpecialEffectsController.Operation.State.GONE;
            final View view = fragment.mView;
            container.startViewTransition(view);
            AnimatorSet animatorSet = this.animator;
            if (animatorSet != null) {
                animatorSet.addListener(new AnimatorListenerAdapter() { // from class: androidx.fragment.app.DefaultSpecialEffectsController$AnimatorEffect$onStart$1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(@NotNull Animator anim) {
                        Intrinsics.checkNotNullParameter(anim, "anim");
                        container.endViewTransition(view);
                        if (z) {
                            SpecialEffectsController.Operation.State finalState = operation.getFinalState();
                            View viewToAnimate = view;
                            Intrinsics.checkNotNullExpressionValue(viewToAnimate, "viewToAnimate");
                            finalState.applyState(viewToAnimate, container);
                        }
                        this.getAnimatorInfo().getOperation().completeEffect(this);
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Log.v(FragmentManager.TAG, "Animator from operation " + operation + " has ended.");
                        }
                    }
                });
            }
            AnimatorSet animatorSet2 = this.animator;
            if (animatorSet2 != null) {
                animatorSet2.setTarget(view);
            }
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Effect
        public void onProgress(@NotNull BackEventCompat backEvent, @NotNull ViewGroup container) {
            Intrinsics.checkNotNullParameter(backEvent, "backEvent");
            Intrinsics.checkNotNullParameter(container, "container");
            SpecialEffectsController.Operation operation = this.animatorInfo.getOperation();
            AnimatorSet animatorSet = this.animator;
            if (animatorSet == null) {
                this.animatorInfo.getOperation().completeEffect(this);
                return;
            }
            if (Build.VERSION.SDK_INT < 34 || !operation.getFragment().mTransitioning) {
                return;
            }
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v(FragmentManager.TAG, "Adding BackProgressCallbacks for Animators to operation " + operation);
            }
            long j = Api24Impl.INSTANCE.totalDuration(animatorSet);
            long progress = (long) (backEvent.getProgress() * j);
            if (progress == 0) {
                progress = 1;
            }
            if (progress == j) {
                progress = j - 1;
            }
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v(FragmentManager.TAG, "Setting currentPlayTime to " + progress + " for Animator " + animatorSet + " on operation " + operation);
            }
            Api26Impl.INSTANCE.setCurrentPlayTime(animatorSet, progress);
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Effect
        public void onCommit(@NotNull ViewGroup container) {
            Intrinsics.checkNotNullParameter(container, "container");
            SpecialEffectsController.Operation operation = this.animatorInfo.getOperation();
            AnimatorSet animatorSet = this.animator;
            if (animatorSet == null) {
                this.animatorInfo.getOperation().completeEffect(this);
                return;
            }
            animatorSet.start();
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v(FragmentManager.TAG, "Animator from operation " + operation + " has started.");
            }
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Effect
        public void onCancel(@NotNull ViewGroup container) {
            Intrinsics.checkNotNullParameter(container, "container");
            AnimatorSet animatorSet = this.animator;
            if (animatorSet == null) {
                this.animatorInfo.getOperation().completeEffect(this);
                return;
            }
            SpecialEffectsController.Operation operation = this.animatorInfo.getOperation();
            if (operation.isSeeking()) {
                if (Build.VERSION.SDK_INT >= 26) {
                    Api26Impl.INSTANCE.reverse(animatorSet);
                }
            } else {
                animatorSet.end();
            }
            if (FragmentManager.isLoggingEnabled(2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Animator from operation ");
                sb.append(operation);
                sb.append(" has been canceled");
                sb.append(operation.isSeeking() ? " with seeking." : ".");
                sb.append(' ');
                Log.v(FragmentManager.TAG, sb.toString());
            }
        }
    }

    static final class TransitionEffect extends SpecialEffectsController.Effect {
        private Object controller;
        private final ArrayList<String> enteringNames;
        private final ArrayList<String> exitingNames;
        private final SpecialEffectsController.Operation firstOut;
        private final ArrayMap<String, View> firstOutViews;
        private final boolean isPop;
        private final SpecialEffectsController.Operation lastIn;
        private final ArrayMap<String, View> lastInViews;
        private final ArrayList<View> sharedElementFirstOutViews;
        private final ArrayList<View> sharedElementLastInViews;
        private final ArrayMap<String, String> sharedElementNameMapping;
        private final Object sharedElementTransition;
        private final FragmentTransitionImpl transitionImpl;
        private final List<TransitionInfo> transitionInfos;
        private final CancellationSignal transitionSignal;

        public static /* synthetic */ void getTransitionSignal$annotations() {
        }

        public final List<TransitionInfo> getTransitionInfos() {
            return this.transitionInfos;
        }

        public final SpecialEffectsController.Operation getFirstOut() {
            return this.firstOut;
        }

        public final SpecialEffectsController.Operation getLastIn() {
            return this.lastIn;
        }

        public final FragmentTransitionImpl getTransitionImpl() {
            return this.transitionImpl;
        }

        public final Object getSharedElementTransition() {
            return this.sharedElementTransition;
        }

        public final ArrayList<View> getSharedElementFirstOutViews() {
            return this.sharedElementFirstOutViews;
        }

        public final ArrayList<View> getSharedElementLastInViews() {
            return this.sharedElementLastInViews;
        }

        public final ArrayMap<String, String> getSharedElementNameMapping() {
            return this.sharedElementNameMapping;
        }

        public final ArrayList<String> getEnteringNames() {
            return this.enteringNames;
        }

        public final ArrayList<String> getExitingNames() {
            return this.exitingNames;
        }

        public final ArrayMap<String, View> getFirstOutViews() {
            return this.firstOutViews;
        }

        public final ArrayMap<String, View> getLastInViews() {
            return this.lastInViews;
        }

        public final boolean isPop() {
            return this.isPop;
        }

        public TransitionEffect(@NotNull List<TransitionInfo> transitionInfos, @Nullable SpecialEffectsController.Operation operation, @Nullable SpecialEffectsController.Operation operation2, @NotNull FragmentTransitionImpl transitionImpl, @Nullable Object obj, @NotNull ArrayList<View> sharedElementFirstOutViews, @NotNull ArrayList<View> sharedElementLastInViews, @NotNull ArrayMap<String, String> sharedElementNameMapping, @NotNull ArrayList<String> enteringNames, @NotNull ArrayList<String> exitingNames, @NotNull ArrayMap<String, View> firstOutViews, @NotNull ArrayMap<String, View> lastInViews, boolean z) {
            Intrinsics.checkNotNullParameter(transitionInfos, "transitionInfos");
            Intrinsics.checkNotNullParameter(transitionImpl, "transitionImpl");
            Intrinsics.checkNotNullParameter(sharedElementFirstOutViews, "sharedElementFirstOutViews");
            Intrinsics.checkNotNullParameter(sharedElementLastInViews, "sharedElementLastInViews");
            Intrinsics.checkNotNullParameter(sharedElementNameMapping, "sharedElementNameMapping");
            Intrinsics.checkNotNullParameter(enteringNames, "enteringNames");
            Intrinsics.checkNotNullParameter(exitingNames, "exitingNames");
            Intrinsics.checkNotNullParameter(firstOutViews, "firstOutViews");
            Intrinsics.checkNotNullParameter(lastInViews, "lastInViews");
            this.transitionInfos = transitionInfos;
            this.firstOut = operation;
            this.lastIn = operation2;
            this.transitionImpl = transitionImpl;
            this.sharedElementTransition = obj;
            this.sharedElementFirstOutViews = sharedElementFirstOutViews;
            this.sharedElementLastInViews = sharedElementLastInViews;
            this.sharedElementNameMapping = sharedElementNameMapping;
            this.enteringNames = enteringNames;
            this.exitingNames = exitingNames;
            this.firstOutViews = firstOutViews;
            this.lastInViews = lastInViews;
            this.isPop = z;
            this.transitionSignal = new CancellationSignal();
        }

        public final CancellationSignal getTransitionSignal() {
            return this.transitionSignal;
        }

        public final Object getController() {
            return this.controller;
        }

        public final void setController(@Nullable Object obj) {
            this.controller = obj;
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Effect
        public boolean isSeekingSupported() {
            Object obj;
            if (this.transitionImpl.isSeekingSupported()) {
                List<TransitionInfo> list = this.transitionInfos;
                if ((list instanceof Collection) && list.isEmpty()) {
                    obj = this.sharedElementTransition;
                    if (obj != null) {
                    }
                    return true;
                }
                for (TransitionInfo transitionInfo : list) {
                    if (Build.VERSION.SDK_INT < 34 || transitionInfo.getTransition() == null || !this.transitionImpl.isSeekingSupported(transitionInfo.getTransition())) {
                    }
                }
                obj = this.sharedElementTransition;
                if (obj != null || this.transitionImpl.isSeekingSupported(obj)) {
                    return true;
                }
            }
            return false;
        }

        public final boolean getTransitioning() {
            List<TransitionInfo> list = this.transitionInfos;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it2 = list.iterator();
                while (it2.hasNext()) {
                    if (!((TransitionInfo) it2.next()).getOperation().getFragment().mTransitioning) {
                        return false;
                    }
                }
            }
            return true;
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Effect
        public void onStart(@NotNull final ViewGroup container) {
            Intrinsics.checkNotNullParameter(container, "container");
            if (container.isLaidOut()) {
                if (getTransitioning() && this.sharedElementTransition != null && !isSeekingSupported()) {
                    Log.i(FragmentManager.TAG, "Ignoring shared elements transition " + this.sharedElementTransition + " between " + this.firstOut + " and " + this.lastIn + " as neither fragment has set a Transition. In order to run a SharedElementTransition, you must also set either an enter or exit transition on a fragment involved in the transaction. The sharedElementTransition will run after the back gesture has been committed.");
                }
                if (isSeekingSupported() && getTransitioning()) {
                    final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    Pair<ArrayList<View>, Object> pairCreateMergedTransition = createMergedTransition(container, this.lastIn, this.firstOut);
                    ArrayList<View> arrayListComponent1 = pairCreateMergedTransition.component1();
                    final Object objComponent2 = pairCreateMergedTransition.component2();
                    List<TransitionInfo> list = this.transitionInfos;
                    ArrayList<SpecialEffectsController.Operation> arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                    Iterator<T> it2 = list.iterator();
                    while (it2.hasNext()) {
                        arrayList.add(((TransitionInfo) it2.next()).getOperation());
                    }
                    for (final SpecialEffectsController.Operation operation : arrayList) {
                        this.transitionImpl.setListenerForTransitionEnd(operation.getFragment(), objComponent2, this.transitionSignal, new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect$$ExternalSyntheticLambda3
                            @Override // java.lang.Runnable
                            public final void run() {
                                DefaultSpecialEffectsController.TransitionEffect.onStart$lambda$6$lambda$4(objectRef);
                            }
                        }, new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect$$ExternalSyntheticLambda4
                            @Override // java.lang.Runnable
                            public final void run() {
                                DefaultSpecialEffectsController.TransitionEffect.onStart$lambda$6$lambda$5(operation, this);
                            }
                        });
                    }
                    runTransition(arrayListComponent1, container, new Function0<Unit>() { // from class: androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect$onStart$4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX WARN: Type inference failed for: r3v2, types: [T, androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect$onStart$4$2] */
                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            DefaultSpecialEffectsController.TransitionEffect transitionEffect = this.this$0;
                            transitionEffect.setController(transitionEffect.getTransitionImpl().controlDelayedTransition(container, objComponent2));
                            boolean z = this.this$0.getController() != null;
                            Object obj = objComponent2;
                            ViewGroup viewGroup = container;
                            if (!z) {
                                throw new IllegalStateException(("Unable to start transition " + obj + " for container " + viewGroup + '.').toString());
                            }
                            objectRef.element = new AnonymousClass2(this.this$0, obj, viewGroup);
                            if (FragmentManager.isLoggingEnabled(2)) {
                                Log.v(FragmentManager.TAG, "Started executing operations from " + this.this$0.getFirstOut() + " to " + this.this$0.getLastIn());
                            }
                        }

                        /* JADX INFO: renamed from: androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect$onStart$4$2, reason: invalid class name */
                        static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
                            final /* synthetic */ ViewGroup $container;
                            final /* synthetic */ Object $mergedTransition;
                            final /* synthetic */ DefaultSpecialEffectsController.TransitionEffect this$0;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            AnonymousClass2(DefaultSpecialEffectsController.TransitionEffect transitionEffect, Object obj, ViewGroup viewGroup) {
                                super(0);
                                this.this$0 = transitionEffect;
                                this.$mergedTransition = obj;
                                this.$container = viewGroup;
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                List<DefaultSpecialEffectsController.TransitionInfo> transitionInfos = this.this$0.getTransitionInfos();
                                if (!(transitionInfos instanceof Collection) || !transitionInfos.isEmpty()) {
                                    Iterator<T> it2 = transitionInfos.iterator();
                                    while (it2.hasNext()) {
                                        if (!((DefaultSpecialEffectsController.TransitionInfo) it2.next()).getOperation().isSeeking()) {
                                            if (FragmentManager.isLoggingEnabled(2)) {
                                                Log.v(FragmentManager.TAG, "Completing animating immediately");
                                            }
                                            CancellationSignal cancellationSignal = new CancellationSignal();
                                            FragmentTransitionImpl transitionImpl = this.this$0.getTransitionImpl();
                                            Fragment fragment = this.this$0.getTransitionInfos().get(0).getOperation().getFragment();
                                            Object obj = this.$mergedTransition;
                                            final DefaultSpecialEffectsController.TransitionEffect transitionEffect = this.this$0;
                                            transitionImpl.setListenerForTransitionEnd(fragment, obj, cancellationSignal, 
                                            /*  JADX ERROR: Method code generation error
                                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0067: INVOKE 
                                                  (r1v7 'transitionImpl' androidx.fragment.app.FragmentTransitionImpl)
                                                  (r2v6 'fragment' androidx.fragment.app.Fragment)
                                                  (r3v2 'obj' java.lang.Object)
                                                  (r0v5 'cancellationSignal' androidx.core.os.CancellationSignal)
                                                  (wrap java.lang.Runnable:0x0064: CONSTRUCTOR (r5v0 'transitionEffect' androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect A[DONT_INLINE]) A[MD:(androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect):void (m), WRAPPED] (LINE:814) call: androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect$onStart$4$2$$ExternalSyntheticLambda1.<init>(androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect):void type: CONSTRUCTOR)
                                                 VIRTUAL call: androidx.fragment.app.FragmentTransitionImpl.setListenerForTransitionEnd(androidx.fragment.app.Fragment, java.lang.Object, androidx.core.os.CancellationSignal, java.lang.Runnable):void A[MD:(androidx.fragment.app.Fragment, java.lang.Object, androidx.core.os.CancellationSignal, java.lang.Runnable):void (m)] (LINE:814) in method: androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect$onStart$4.2.invoke():void, file: classes2.dex
                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:226)
                                                	at jadx.core.dex.regions.loops.LoopRegion.generate(LoopRegion.java:173)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
                                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
                                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
                                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
                                                	at java.base/java.util.ArrayList.forEach(Unknown Source)
                                                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
                                                	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
                                                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
                                                	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
                                                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
                                                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
                                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
                                                	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
                                                	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
                                                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                                                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                                                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                                                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                                                	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
                                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
                                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
                                                	at java.base/java.util.ArrayList.forEach(Unknown Source)
                                                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
                                                	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
                                                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
                                                	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
                                                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
                                                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
                                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
                                                	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
                                                	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
                                                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                                                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                                                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:845)
                                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1143)
                                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:910)
                                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
                                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
                                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
                                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
                                                	at java.base/java.util.ArrayList.forEach(Unknown Source)
                                                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
                                                	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
                                                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
                                                	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
                                                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
                                                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
                                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
                                                	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
                                                	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
                                                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                                                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                                                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                                                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                                                	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
                                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
                                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
                                                	at java.base/java.util.ArrayList.forEach(Unknown Source)
                                                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
                                                	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
                                                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
                                                	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
                                                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
                                                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
                                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
                                                	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
                                                	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
                                                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                                                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                                                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                                                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                                                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
                                                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                                                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                                                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                                                	at jadx.core.ProcessClass.process(ProcessClass.java:89)
                                                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
                                                	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
                                                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
                                                	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
                                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect$onStart$4$2$$ExternalSyntheticLambda1, state: NOT_LOADED
                                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:306)
                                                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:807)
                                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1143)
                                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:910)
                                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                                	... 139 more
                                                */
                                            /*
                                                this = this;
                                                androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect r0 = r6.this$0
                                                java.util.List r0 = r0.getTransitionInfos()
                                                java.lang.Iterable r0 = (java.lang.Iterable) r0
                                                boolean r1 = r0 instanceof java.util.Collection
                                                java.lang.String r2 = "FragmentManager"
                                                r3 = 2
                                                if (r1 == 0) goto L19
                                                r1 = r0
                                                java.util.Collection r1 = (java.util.Collection) r1
                                                boolean r1 = r1.isEmpty()
                                                if (r1 == 0) goto L19
                                                goto L6e
                                            L19:
                                                java.util.Iterator r0 = r0.iterator()
                                            L1d:
                                                boolean r1 = r0.hasNext()
                                                if (r1 == 0) goto L6e
                                                java.lang.Object r1 = r0.next()
                                                androidx.fragment.app.DefaultSpecialEffectsController$TransitionInfo r1 = (androidx.fragment.app.DefaultSpecialEffectsController.TransitionInfo) r1
                                                androidx.fragment.app.SpecialEffectsController$Operation r1 = r1.getOperation()
                                                boolean r1 = r1.isSeeking()
                                                if (r1 != 0) goto L1d
                                                boolean r0 = androidx.fragment.app.FragmentManager.isLoggingEnabled(r3)
                                                if (r0 == 0) goto L3e
                                                java.lang.String r0 = "Completing animating immediately"
                                                android.util.Log.v(r2, r0)
                                            L3e:
                                                androidx.core.os.CancellationSignal r0 = new androidx.core.os.CancellationSignal
                                                r0.<init>()
                                                androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect r1 = r6.this$0
                                                androidx.fragment.app.FragmentTransitionImpl r1 = r1.getTransitionImpl()
                                                androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect r2 = r6.this$0
                                                java.util.List r2 = r2.getTransitionInfos()
                                                r3 = 0
                                                java.lang.Object r2 = r2.get(r3)
                                                androidx.fragment.app.DefaultSpecialEffectsController$TransitionInfo r2 = (androidx.fragment.app.DefaultSpecialEffectsController.TransitionInfo) r2
                                                androidx.fragment.app.SpecialEffectsController$Operation r2 = r2.getOperation()
                                                androidx.fragment.app.Fragment r2 = r2.getFragment()
                                                java.lang.Object r3 = r6.$mergedTransition
                                                androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect$onStart$4$2$$ExternalSyntheticLambda1 r4 = new androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect$onStart$4$2$$ExternalSyntheticLambda1
                                                androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect r5 = r6.this$0
                                                r4.<init>(r5)
                                                r1.setListenerForTransitionEnd(r2, r3, r0, r4)
                                                r0.cancel()
                                                goto L94
                                            L6e:
                                                boolean r0 = androidx.fragment.app.FragmentManager.isLoggingEnabled(r3)
                                                if (r0 == 0) goto L79
                                                java.lang.String r0 = "Animating to start"
                                                android.util.Log.v(r2, r0)
                                            L79:
                                                androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect r0 = r6.this$0
                                                androidx.fragment.app.FragmentTransitionImpl r0 = r0.getTransitionImpl()
                                                androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect r1 = r6.this$0
                                                java.lang.Object r1 = r1.getController()
                                                kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
                                                androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect$onStart$4$2$$ExternalSyntheticLambda0 r2 = new androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect$onStart$4$2$$ExternalSyntheticLambda0
                                                androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect r3 = r6.this$0
                                                android.view.ViewGroup r4 = r6.$container
                                                r2.<init>(r3, r4)
                                                r0.animateToStart(r1, r2)
                                            L94:
                                                return
                                            */
                                            throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect$onStart$4.AnonymousClass2.invoke2():void");
                                        }

                                        /* JADX INFO: Access modifiers changed from: private */
                                        public static final void invoke$lambda$2(DefaultSpecialEffectsController.TransitionEffect this$0, ViewGroup container) {
                                            Intrinsics.checkNotNullParameter(this$0, "this$0");
                                            Intrinsics.checkNotNullParameter(container, "$container");
                                            Iterator<T> it2 = this$0.getTransitionInfos().iterator();
                                            while (it2.hasNext()) {
                                                SpecialEffectsController.Operation operation = ((DefaultSpecialEffectsController.TransitionInfo) it2.next()).getOperation();
                                                View view = operation.getFragment().getView();
                                                if (view != null) {
                                                    operation.getFinalState().applyState(view, container);
                                                }
                                            }
                                        }

                                        /* JADX INFO: Access modifiers changed from: private */
                                        public static final void invoke$lambda$4(DefaultSpecialEffectsController.TransitionEffect this$0) {
                                            Intrinsics.checkNotNullParameter(this$0, "this$0");
                                            if (FragmentManager.isLoggingEnabled(2)) {
                                                Log.v(FragmentManager.TAG, "Transition for all operations has completed");
                                            }
                                            Iterator<T> it2 = this$0.getTransitionInfos().iterator();
                                            while (it2.hasNext()) {
                                                ((DefaultSpecialEffectsController.TransitionInfo) it2.next()).getOperation().completeEffect(this$0);
                                            }
                                        }
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        Iterator<T> it3 = this.transitionInfos.iterator();
                        while (it3.hasNext()) {
                            SpecialEffectsController.Operation operation2 = ((TransitionInfo) it3.next()).getOperation();
                            if (FragmentManager.isLoggingEnabled(2)) {
                                Log.v(FragmentManager.TAG, "SpecialEffectsController: Container " + container + " has not been laid out. Skipping onStart for operation " + operation2);
                            }
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final void onStart$lambda$6$lambda$4(Ref.ObjectRef seekCancelLambda) {
                        Intrinsics.checkNotNullParameter(seekCancelLambda, "$seekCancelLambda");
                        Function0 function0 = (Function0) seekCancelLambda.element;
                        if (function0 != null) {
                            function0.invoke();
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final void onStart$lambda$6$lambda$5(SpecialEffectsController.Operation operation, TransitionEffect this$0) {
                        Intrinsics.checkNotNullParameter(operation, "$operation");
                        Intrinsics.checkNotNullParameter(this$0, "this$0");
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Log.v(FragmentManager.TAG, "Transition for operation " + operation + " has completed");
                        }
                        operation.completeEffect(this$0);
                    }

                    @Override // androidx.fragment.app.SpecialEffectsController.Effect
                    public void onProgress(@NotNull BackEventCompat backEvent, @NotNull ViewGroup container) {
                        Intrinsics.checkNotNullParameter(backEvent, "backEvent");
                        Intrinsics.checkNotNullParameter(container, "container");
                        Object obj = this.controller;
                        if (obj != null) {
                            this.transitionImpl.setCurrentPlayTime(obj, backEvent.getProgress());
                        }
                    }

                    @Override // androidx.fragment.app.SpecialEffectsController.Effect
                    public void onCommit(@NotNull final ViewGroup container) {
                        Intrinsics.checkNotNullParameter(container, "container");
                        if (container.isLaidOut()) {
                            Object obj = this.controller;
                            if (obj != null) {
                                FragmentTransitionImpl fragmentTransitionImpl = this.transitionImpl;
                                Intrinsics.checkNotNull(obj);
                                fragmentTransitionImpl.animateToEnd(obj);
                                if (FragmentManager.isLoggingEnabled(2)) {
                                    Log.v(FragmentManager.TAG, "Ending execution of operations from " + this.firstOut + " to " + this.lastIn);
                                    return;
                                }
                                return;
                            }
                            Pair<ArrayList<View>, Object> pairCreateMergedTransition = createMergedTransition(container, this.lastIn, this.firstOut);
                            ArrayList<View> arrayListComponent1 = pairCreateMergedTransition.component1();
                            final Object objComponent2 = pairCreateMergedTransition.component2();
                            List<TransitionInfo> list = this.transitionInfos;
                            ArrayList<SpecialEffectsController.Operation> arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                            Iterator<T> it2 = list.iterator();
                            while (it2.hasNext()) {
                                arrayList.add(((TransitionInfo) it2.next()).getOperation());
                            }
                            for (final SpecialEffectsController.Operation operation : arrayList) {
                                this.transitionImpl.setListenerForTransitionEnd(operation.getFragment(), objComponent2, this.transitionSignal, new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect$$ExternalSyntheticLambda5
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        DefaultSpecialEffectsController.TransitionEffect.onCommit$lambda$11$lambda$10(operation, this);
                                    }
                                });
                            }
                            runTransition(arrayListComponent1, container, new Function0<Unit>() { // from class: androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect$onCommit$4
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    this.this$0.getTransitionImpl().beginDelayedTransition(container, objComponent2);
                                }
                            });
                            if (FragmentManager.isLoggingEnabled(2)) {
                                Log.v(FragmentManager.TAG, "Completed executing operations from " + this.firstOut + " to " + this.lastIn);
                                return;
                            }
                            return;
                        }
                        for (TransitionInfo transitionInfo : this.transitionInfos) {
                            SpecialEffectsController.Operation operation2 = transitionInfo.getOperation();
                            if (FragmentManager.isLoggingEnabled(2)) {
                                Log.v(FragmentManager.TAG, "SpecialEffectsController: Container " + container + " has not been laid out. Completing operation " + operation2);
                            }
                            transitionInfo.getOperation().completeEffect(this);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final void onCommit$lambda$11$lambda$10(SpecialEffectsController.Operation operation, TransitionEffect this$0) {
                        Intrinsics.checkNotNullParameter(operation, "$operation");
                        Intrinsics.checkNotNullParameter(this$0, "this$0");
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Log.v(FragmentManager.TAG, "Transition for operation " + operation + " has completed");
                        }
                        operation.completeEffect(this$0);
                    }

                    private final Pair<ArrayList<View>, Object> createMergedTransition(ViewGroup viewGroup, SpecialEffectsController.Operation operation, final SpecialEffectsController.Operation operation2) {
                        Object obj;
                        Object objMergeTransitionsTogether;
                        final SpecialEffectsController.Operation operation3 = operation;
                        View view = new View(viewGroup.getContext());
                        final Rect rect = new Rect();
                        Iterator<TransitionInfo> it2 = this.transitionInfos.iterator();
                        boolean z = false;
                        View view2 = null;
                        while (it2.hasNext()) {
                            if (it2.next().hasSharedElementTransition() && operation2 != null && operation3 != null && !this.sharedElementNameMapping.isEmpty() && this.sharedElementTransition != null) {
                                FragmentTransition.callSharedElementStartEnd(operation.getFragment(), operation2.getFragment(), this.isPop, this.firstOutViews, true);
                                OneShotPreDrawListener.add(viewGroup, new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect$$ExternalSyntheticLambda0
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        DefaultSpecialEffectsController.TransitionEffect.createMergedTransition$lambda$12(operation3, operation2, this);
                                    }
                                });
                                this.sharedElementFirstOutViews.addAll(this.firstOutViews.values());
                                if (!this.exitingNames.isEmpty()) {
                                    String str = this.exitingNames.get(0);
                                    Intrinsics.checkNotNullExpressionValue(str, "exitingNames[0]");
                                    view2 = this.firstOutViews.get(str);
                                    this.transitionImpl.setEpicenter(this.sharedElementTransition, view2);
                                }
                                this.sharedElementLastInViews.addAll(this.lastInViews.values());
                                if (!this.enteringNames.isEmpty()) {
                                    String str2 = this.enteringNames.get(0);
                                    Intrinsics.checkNotNullExpressionValue(str2, "enteringNames[0]");
                                    final View view3 = this.lastInViews.get(str2);
                                    if (view3 != null) {
                                        final FragmentTransitionImpl fragmentTransitionImpl = this.transitionImpl;
                                        OneShotPreDrawListener.add(viewGroup, new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect$$ExternalSyntheticLambda1
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                DefaultSpecialEffectsController.TransitionEffect.createMergedTransition$lambda$13(fragmentTransitionImpl, view3, rect);
                                            }
                                        });
                                        z = true;
                                    }
                                }
                                this.transitionImpl.setSharedElementTargets(this.sharedElementTransition, view, this.sharedElementFirstOutViews);
                                FragmentTransitionImpl fragmentTransitionImpl2 = this.transitionImpl;
                                Object obj2 = this.sharedElementTransition;
                                fragmentTransitionImpl2.scheduleRemoveTargets(obj2, null, null, null, null, obj2, this.sharedElementLastInViews);
                            }
                        }
                        ArrayList arrayList = new ArrayList();
                        Iterator<TransitionInfo> it3 = this.transitionInfos.iterator();
                        Object obj3 = null;
                        Object objMergeTransitionsTogether2 = null;
                        while (it3.hasNext()) {
                            TransitionInfo next = it3.next();
                            SpecialEffectsController.Operation operation4 = next.getOperation();
                            Iterator<TransitionInfo> it4 = it3;
                            Object objCloneTransition = this.transitionImpl.cloneTransition(next.getTransition());
                            if (objCloneTransition != null) {
                                final ArrayList<View> arrayList2 = new ArrayList<>();
                                Object obj4 = objMergeTransitionsTogether2;
                                View view4 = operation4.getFragment().mView;
                                Object obj5 = obj3;
                                Intrinsics.checkNotNullExpressionValue(view4, "operation.fragment.mView");
                                captureTransitioningViews(arrayList2, view4);
                                if (this.sharedElementTransition != null && (operation4 == operation2 || operation4 == operation3)) {
                                    if (operation4 == operation2) {
                                        arrayList2.removeAll(CollectionsKt___CollectionsKt.toSet(this.sharedElementFirstOutViews));
                                    } else {
                                        arrayList2.removeAll(CollectionsKt___CollectionsKt.toSet(this.sharedElementLastInViews));
                                    }
                                }
                                if (arrayList2.isEmpty()) {
                                    this.transitionImpl.addTarget(objCloneTransition, view);
                                } else {
                                    this.transitionImpl.addTargets(objCloneTransition, arrayList2);
                                    this.transitionImpl.scheduleRemoveTargets(objCloneTransition, objCloneTransition, arrayList2, null, null, null, null);
                                    if (operation4.getFinalState() == SpecialEffectsController.Operation.State.GONE) {
                                        operation4.setAwaitingContainerChanges(false);
                                        ArrayList<View> arrayList3 = new ArrayList<>(arrayList2);
                                        arrayList3.remove(operation4.getFragment().mView);
                                        this.transitionImpl.scheduleHideFragmentView(objCloneTransition, operation4.getFragment().mView, arrayList3);
                                        OneShotPreDrawListener.add(viewGroup, new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect$$ExternalSyntheticLambda2
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                DefaultSpecialEffectsController.TransitionEffect.createMergedTransition$lambda$14(arrayList2);
                                            }
                                        });
                                    }
                                }
                                if (operation4.getFinalState() == SpecialEffectsController.Operation.State.VISIBLE) {
                                    arrayList.addAll(arrayList2);
                                    if (z) {
                                        this.transitionImpl.setEpicenter(objCloneTransition, rect);
                                    }
                                    if (FragmentManager.isLoggingEnabled(2)) {
                                        Log.v(FragmentManager.TAG, "Entering Transition: " + objCloneTransition);
                                        Log.v(FragmentManager.TAG, ">>>>> EnteringViews <<<<<");
                                        for (View transitioningViews : arrayList2) {
                                            Intrinsics.checkNotNullExpressionValue(transitioningViews, "transitioningViews");
                                            Log.v(FragmentManager.TAG, "View: " + transitioningViews);
                                        }
                                    }
                                } else {
                                    this.transitionImpl.setEpicenter(objCloneTransition, view2);
                                    if (FragmentManager.isLoggingEnabled(2)) {
                                        Log.v(FragmentManager.TAG, "Exiting Transition: " + objCloneTransition);
                                        Log.v(FragmentManager.TAG, ">>>>> ExitingViews <<<<<");
                                        for (View transitioningViews2 : arrayList2) {
                                            Intrinsics.checkNotNullExpressionValue(transitioningViews2, "transitioningViews");
                                            Log.v(FragmentManager.TAG, "View: " + transitioningViews2);
                                        }
                                    }
                                }
                                if (next.isOverlapAllowed()) {
                                    objMergeTransitionsTogether = this.transitionImpl.mergeTransitionsTogether(obj5, objCloneTransition, null);
                                    objMergeTransitionsTogether2 = obj4;
                                } else {
                                    obj = obj5;
                                    objMergeTransitionsTogether2 = this.transitionImpl.mergeTransitionsTogether(obj4, objCloneTransition, null);
                                }
                                obj3 = objMergeTransitionsTogether;
                                it3 = it4;
                                operation3 = operation;
                            } else {
                                obj = obj3;
                            }
                            objMergeTransitionsTogether = obj;
                            obj3 = objMergeTransitionsTogether;
                            it3 = it4;
                            operation3 = operation;
                        }
                        Object objMergeTransitionsInSequence = this.transitionImpl.mergeTransitionsInSequence(obj3, objMergeTransitionsTogether2, this.sharedElementTransition);
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Log.v(FragmentManager.TAG, "Final merged transition: " + objMergeTransitionsInSequence);
                        }
                        return new Pair<>(arrayList, objMergeTransitionsInSequence);
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final void createMergedTransition$lambda$12(SpecialEffectsController.Operation operation, SpecialEffectsController.Operation operation2, TransitionEffect this$0) {
                        Intrinsics.checkNotNullParameter(this$0, "this$0");
                        FragmentTransition.callSharedElementStartEnd(operation.getFragment(), operation2.getFragment(), this$0.isPop, this$0.lastInViews, false);
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final void createMergedTransition$lambda$13(FragmentTransitionImpl impl, View view, Rect lastInEpicenterRect) {
                        Intrinsics.checkNotNullParameter(impl, "$impl");
                        Intrinsics.checkNotNullParameter(lastInEpicenterRect, "$lastInEpicenterRect");
                        impl.getBoundsOnScreen(view, lastInEpicenterRect);
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final void createMergedTransition$lambda$14(ArrayList transitioningViews) {
                        Intrinsics.checkNotNullParameter(transitioningViews, "$transitioningViews");
                        FragmentTransition.setViewVisibility(transitioningViews, 4);
                    }

                    private final void runTransition(ArrayList<View> arrayList, ViewGroup viewGroup, Function0<Unit> function0) {
                        FragmentTransition.setViewVisibility(arrayList, 4);
                        ArrayList<String> arrayListPrepareSetNameOverridesReordered = this.transitionImpl.prepareSetNameOverridesReordered(this.sharedElementLastInViews);
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Log.v(FragmentManager.TAG, ">>>>> Beginning transition <<<<<");
                            Log.v(FragmentManager.TAG, ">>>>> SharedElementFirstOutViews <<<<<");
                            for (View sharedElementFirstOutViews : this.sharedElementFirstOutViews) {
                                Intrinsics.checkNotNullExpressionValue(sharedElementFirstOutViews, "sharedElementFirstOutViews");
                                View view = sharedElementFirstOutViews;
                                Log.v(FragmentManager.TAG, "View: " + view + " Name: " + ViewCompat.getTransitionName(view));
                            }
                            Log.v(FragmentManager.TAG, ">>>>> SharedElementLastInViews <<<<<");
                            for (View sharedElementLastInViews : this.sharedElementLastInViews) {
                                Intrinsics.checkNotNullExpressionValue(sharedElementLastInViews, "sharedElementLastInViews");
                                View view2 = sharedElementLastInViews;
                                Log.v(FragmentManager.TAG, "View: " + view2 + " Name: " + ViewCompat.getTransitionName(view2));
                            }
                        }
                        function0.invoke();
                        this.transitionImpl.setNameOverridesReordered(viewGroup, this.sharedElementFirstOutViews, this.sharedElementLastInViews, arrayListPrepareSetNameOverridesReordered, this.sharedElementNameMapping);
                        FragmentTransition.setViewVisibility(arrayList, 0);
                        this.transitionImpl.swapSharedElementTargets(this.sharedElementTransition, this.sharedElementFirstOutViews, this.sharedElementLastInViews);
                    }

                    @Override // androidx.fragment.app.SpecialEffectsController.Effect
                    public void onCancel(@NotNull ViewGroup container) {
                        Intrinsics.checkNotNullParameter(container, "container");
                        this.transitionSignal.cancel();
                    }

                    private final void captureTransitioningViews(ArrayList<View> arrayList, View view) {
                        if (view instanceof ViewGroup) {
                            ViewGroup viewGroup = (ViewGroup) view;
                            if (ViewGroupCompat.isTransitionGroup(viewGroup)) {
                                if (arrayList.contains(view)) {
                                    return;
                                }
                                arrayList.add(view);
                                return;
                            }
                            int childCount = viewGroup.getChildCount();
                            for (int i = 0; i < childCount; i++) {
                                View child = viewGroup.getChildAt(i);
                                if (child.getVisibility() == 0) {
                                    Intrinsics.checkNotNullExpressionValue(child, "child");
                                    captureTransitioningViews(arrayList, child);
                                }
                            }
                            return;
                        }
                        if (arrayList.contains(view)) {
                            return;
                        }
                        arrayList.add(view);
                    }
                }

                public static final class Api24Impl {
                    public static final Api24Impl INSTANCE = new Api24Impl();

                    private Api24Impl() {
                    }

                    public final long totalDuration(@NotNull AnimatorSet animatorSet) {
                        Intrinsics.checkNotNullParameter(animatorSet, "animatorSet");
                        return animatorSet.getTotalDuration();
                    }
                }

                public static final class Api26Impl {
                    public static final Api26Impl INSTANCE = new Api26Impl();

                    private Api26Impl() {
                    }

                    public final void reverse(@NotNull AnimatorSet animatorSet) {
                        Intrinsics.checkNotNullParameter(animatorSet, "animatorSet");
                        animatorSet.reverse();
                    }

                    public final void setCurrentPlayTime(@NotNull AnimatorSet animatorSet, long j) {
                        Intrinsics.checkNotNullParameter(animatorSet, "animatorSet");
                        animatorSet.setCurrentPlayTime(j);
                    }
                }
            }
