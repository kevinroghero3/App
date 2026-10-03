package androidx.compose.animation.core;

import androidx.annotation.FloatRange;
import androidx.collection.MutableObjectList;
import androidx.compose.runtime.MonotonicFrameClockKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class SeekableTransitionState<S> extends TransitionState<S> {
    private final Function1<Long, Unit> animateOneFrameLambda;
    private S composedTargetState;
    private CancellableContinuation<? super S> compositionContinuation;
    private final Mutex compositionContinuationMutex;
    private SeekingAnimationState currentAnimation;
    private final MutableState currentState$delegate;
    private float durationScale;
    private final Function1<Long, Unit> firstFrameLambda;
    private final MutableFloatState fraction$delegate;
    private final MutableObjectList<SeekingAnimationState> initialValueAnimations;
    private long lastFrameTimeNanos;
    private final MutatorMutex mutatorMutex;
    private final Function0<Unit> recalculateTotalDurationNanos;
    private final MutableState targetState$delegate;
    private long totalDurationNanos;
    private Transition<S> transition;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final AnimationVector1D ZeroVelocity = new AnimationVector1D(0.0f);
    private static final AnimationVector1D Target1 = new AnimationVector1D(1.0f);

    /* JADX INFO: renamed from: androidx.compose.animation.core.SeekableTransitionState$runAnimations$1, reason: invalid class name */
    @DebugMetadata(c = "androidx.compose.animation.core.SeekableTransitionState", f = "Transition.kt", i = {0, 1}, l = {370, 373}, m = "runAnimations", n = {"this", "this"}, s = {"L$0", "L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SeekableTransitionState<S> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SeekableTransitionState<S> seekableTransitionState, Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
            this.this$0 = seekableTransitionState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.runAnimations(this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.SeekableTransitionState$waitForComposition$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "androidx.compose.animation.core.SeekableTransitionState", f = "Transition.kt", i = {0, 0, 1, 1}, l = {566, 2186}, m = "waitForComposition", n = {"this", "expectedState", "this", "expectedState"}, s = {"L$0", "L$1", "L$0", "L$1"})
    static final class C01781 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SeekableTransitionState<S> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C01781(SeekableTransitionState<S> seekableTransitionState, Continuation<? super C01781> continuation) {
            super(continuation);
            this.this$0 = seekableTransitionState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.waitForComposition(this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.SeekableTransitionState$waitForCompositionAfterTargetStateChange$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "androidx.compose.animation.core.SeekableTransitionState", f = "Transition.kt", i = {0, 0, 1, 1}, l = {542, 2186}, m = "waitForCompositionAfterTargetStateChange", n = {"this", "expectedState", "this", "expectedState"}, s = {"L$0", "L$1", "L$0", "L$1"})
    static final class C01791 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SeekableTransitionState<S> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C01791(SeekableTransitionState<S> seekableTransitionState, Continuation<? super C01791> continuation) {
            super(continuation);
            this.this$0 = seekableTransitionState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.waitForCompositionAfterTargetStateChange(this);
        }
    }

    public SeekableTransitionState(S s) {
        super(null);
        this.targetState$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(s, null, 2, null);
        this.currentState$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(s, null, 2, null);
        this.composedTargetState = s;
        this.recalculateTotalDurationNanos = new Function0<Unit>(this) { // from class: androidx.compose.animation.core.SeekableTransitionState$recalculateTotalDurationNanos$1
            final /* synthetic */ SeekableTransitionState<S> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                SeekableTransitionState<S> seekableTransitionState = this.this$0;
                Transition transition = ((SeekableTransitionState) seekableTransitionState).transition;
                seekableTransitionState.setTotalDurationNanos$animation_core_release(transition != null ? transition.getTotalDurationNanos() : 0L);
            }
        };
        this.fraction$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this.compositionContinuationMutex = MutexKt.Mutex$default(false, 1, null);
        this.mutatorMutex = new MutatorMutex();
        this.lastFrameTimeNanos = Long.MIN_VALUE;
        this.initialValueAnimations = new MutableObjectList<>(0, 1, null);
        this.firstFrameLambda = new Function1<Long, Unit>(this) { // from class: androidx.compose.animation.core.SeekableTransitionState$firstFrameLambda$1
            final /* synthetic */ SeekableTransitionState<S> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Unit invoke(Long l) {
                invoke(l.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j) {
                ((SeekableTransitionState) this.this$0).lastFrameTimeNanos = j;
            }
        };
        this.animateOneFrameLambda = new Function1<Long, Unit>(this) { // from class: androidx.compose.animation.core.SeekableTransitionState$animateOneFrameLambda$1
            final /* synthetic */ SeekableTransitionState<S> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Unit invoke(Long l) {
                invoke(l.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j) {
                long j2 = ((SeekableTransitionState) this.this$0).lastFrameTimeNanos;
                ((SeekableTransitionState) this.this$0).lastFrameTimeNanos = j;
                long jRoundToLong = MathKt__MathJVMKt.roundToLong((j - j2) / ((double) ((SeekableTransitionState) this.this$0).durationScale));
                if (((SeekableTransitionState) this.this$0).initialValueAnimations.isNotEmpty()) {
                    MutableObjectList mutableObjectList = ((SeekableTransitionState) this.this$0).initialValueAnimations;
                    SeekableTransitionState<S> seekableTransitionState = this.this$0;
                    Object[] objArr = mutableObjectList.content;
                    int i = mutableObjectList._size;
                    int i2 = 0;
                    for (int i3 = 0; i3 < i; i3++) {
                        SeekableTransitionState.SeekingAnimationState seekingAnimationState = (SeekableTransitionState.SeekingAnimationState) objArr[i3];
                        seekableTransitionState.recalculateAnimationValue(seekingAnimationState, jRoundToLong);
                        seekingAnimationState.setComplete(true);
                    }
                    Transition transition = ((SeekableTransitionState) this.this$0).transition;
                    if (transition != null) {
                        transition.updateInitialValues$animation_core_release();
                    }
                    MutableObjectList mutableObjectList2 = ((SeekableTransitionState) this.this$0).initialValueAnimations;
                    int i4 = mutableObjectList2._size;
                    Object[] objArr2 = mutableObjectList2.content;
                    IntRange intRangeUntil = RangesKt___RangesKt.until(0, i4);
                    int first = intRangeUntil.getFirst();
                    int last = intRangeUntil.getLast();
                    if (first <= last) {
                        while (true) {
                            objArr2[first - i2] = objArr2[first];
                            if (((SeekableTransitionState.SeekingAnimationState) objArr2[first]).isComplete()) {
                                i2++;
                            }
                            if (first == last) {
                                break;
                            } else {
                                first++;
                            }
                        }
                    }
                    ArraysKt___ArraysJvmKt.fill(objArr2, (Object) null, i4 - i2, i4);
                    mutableObjectList2._size -= i2;
                }
                SeekableTransitionState.SeekingAnimationState seekingAnimationState2 = ((SeekableTransitionState) this.this$0).currentAnimation;
                if (seekingAnimationState2 != null) {
                    seekingAnimationState2.setDurationNanos(this.this$0.getTotalDurationNanos$animation_core_release());
                    this.this$0.recalculateAnimationValue(seekingAnimationState2, jRoundToLong);
                    this.this$0.setFraction(seekingAnimationState2.getValue());
                    if (seekingAnimationState2.getValue() == 1.0f) {
                        ((SeekableTransitionState) this.this$0).currentAnimation = null;
                    }
                    this.this$0.seekToFraction();
                }
            }
        };
    }

    @Override // androidx.compose.animation.core.TransitionState
    public S getTargetState() {
        return (S) this.targetState$delegate.getValue();
    }

    @Override // androidx.compose.animation.core.TransitionState
    public void setTargetState$animation_core_release(S s) {
        this.targetState$delegate.setValue(s);
    }

    @Override // androidx.compose.animation.core.TransitionState
    public S getCurrentState() {
        return (S) this.currentState$delegate.getValue();
    }

    @Override // androidx.compose.animation.core.TransitionState
    public void setCurrentState$animation_core_release(S s) {
        this.currentState$delegate.setValue(s);
    }

    public final S getComposedTargetState$animation_core_release() {
        return this.composedTargetState;
    }

    public final void setComposedTargetState$animation_core_release(S s) {
        this.composedTargetState = s;
    }

    public final long getTotalDurationNanos$animation_core_release() {
        return this.totalDurationNanos;
    }

    public final void setTotalDurationNanos$animation_core_release(long j) {
        this.totalDurationNanos = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setFraction(float f) {
        this.fraction$delegate.setFloatValue(f);
    }

    public final float getFraction() {
        return this.fraction$delegate.getFloatValue();
    }

    public final CancellableContinuation<S> getCompositionContinuation$animation_core_release() {
        return this.compositionContinuation;
    }

    public final void setCompositionContinuation$animation_core_release(@Nullable CancellableContinuation<? super S> cancellableContinuation) {
        this.compositionContinuation = cancellableContinuation;
    }

    public final Mutex getCompositionContinuationMutex$animation_core_release() {
        return this.compositionContinuationMutex;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void endAllAnimations() {
        Transition<S> transition = this.transition;
        if (transition != null) {
            transition.clearInitialAnimations$animation_core_release();
        }
        this.initialValueAnimations.clear();
        if (this.currentAnimation != null) {
            this.currentAnimation = null;
            setFraction(1.0f);
            seekToFraction();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object runAnimations(Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        SeekableTransitionState seekableTransitionState;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(this, continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(this, continuation);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.initialValueAnimations.isEmpty() && this.currentAnimation == null) {
                return Unit.INSTANCE;
            }
            if (SuspendAnimationKt.getDurationScale(anonymousClass1.getContext()) == 0.0f) {
                endAllAnimations();
                this.lastFrameTimeNanos = Long.MIN_VALUE;
                return Unit.INSTANCE;
            }
            if (this.lastFrameTimeNanos == Long.MIN_VALUE) {
                Function1<Long, Unit> function1 = this.firstFrameLambda;
                anonymousClass1.L$0 = this;
                anonymousClass1.label = 1;
                if (MonotonicFrameClockKt.withFrameNanos(function1, anonymousClass1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            seekableTransitionState = this;
        } else {
            if (i2 != 1 && i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            seekableTransitionState = (SeekableTransitionState) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
        }
        do {
            if (seekableTransitionState.initialValueAnimations.isNotEmpty() || seekableTransitionState.currentAnimation != null) {
                anonymousClass1.L$0 = seekableTransitionState;
                anonymousClass1.label = 2;
            } else {
                seekableTransitionState.lastFrameTimeNanos = Long.MIN_VALUE;
                return Unit.INSTANCE;
            }
        } while (seekableTransitionState.animateOneFrame(anonymousClass1) != coroutine_suspended);
        return coroutine_suspended;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object doOneFrame(Continuation<? super Unit> continuation) {
        if (this.lastFrameTimeNanos == Long.MIN_VALUE) {
            Object objWithFrameNanos = MonotonicFrameClockKt.withFrameNanos(this.firstFrameLambda, continuation);
            return objWithFrameNanos == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithFrameNanos : Unit.INSTANCE;
        }
        Object objAnimateOneFrame = animateOneFrame(continuation);
        return objAnimateOneFrame == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnimateOneFrame : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object animateOneFrame(Continuation<? super Unit> continuation) {
        float durationScale = SuspendAnimationKt.getDurationScale(continuation.getContext());
        if (durationScale <= 0.0f) {
            endAllAnimations();
            return Unit.INSTANCE;
        }
        this.durationScale = durationScale;
        Object objWithFrameNanos = MonotonicFrameClockKt.withFrameNanos(this.animateOneFrameLambda, continuation);
        return objWithFrameNanos == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithFrameNanos : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void recalculateAnimationValue(SeekingAnimationState seekingAnimationState, long j) {
        long progressNanos = seekingAnimationState.getProgressNanos() + j;
        seekingAnimationState.setProgressNanos(progressNanos);
        long animationSpecDuration = seekingAnimationState.getAnimationSpecDuration();
        if (progressNanos >= animationSpecDuration) {
            seekingAnimationState.setValue(1.0f);
            return;
        }
        VectorizedAnimationSpec<AnimationVector1D> animationSpec = seekingAnimationState.getAnimationSpec();
        if (animationSpec != null) {
            AnimationVector1D start = seekingAnimationState.getStart();
            AnimationVector1D animationVector1D = Target1;
            AnimationVector1D initialVelocity = seekingAnimationState.getInitialVelocity();
            if (initialVelocity == null) {
                initialVelocity = ZeroVelocity;
            }
            seekingAnimationState.setValue(RangesKt___RangesKt.coerceIn(((AnimationVector1D) animationSpec.getValueFromNanos(progressNanos, start, animationVector1D, initialVelocity)).get$animation_core_release(0), 0.0f, 1.0f));
            return;
        }
        seekingAnimationState.setValue(VectorConvertersKt.lerp(seekingAnimationState.getStart().get$animation_core_release(0), 1.0f, progressNanos / animationSpecDuration));
    }

    public final Object snapTo(S s, @NotNull Continuation<? super Unit> continuation) {
        Transition<S> transition = this.transition;
        if (transition == null) {
            return Unit.INSTANCE;
        }
        if (Intrinsics.areEqual(getCurrentState(), s) && Intrinsics.areEqual(getTargetState(), s)) {
            return Unit.INSTANCE;
        }
        Object objMutate$default = MutatorMutex.mutate$default(this.mutatorMutex, null, new C01772(this, s, transition, null), continuation, 1, null);
        return objMutate$default == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMutate$default : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.SeekableTransitionState$snapTo$2, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "androidx.compose.animation.core.SeekableTransitionState$snapTo$2", f = "Transition.kt", i = {}, l = {477}, m = "invokeSuspend", n = {}, s = {})
    static final class C01772 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ S $targetState;
        final /* synthetic */ Transition<S> $transition;
        int label;
        final /* synthetic */ SeekableTransitionState<S> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C01772(SeekableTransitionState<S> seekableTransitionState, S s, Transition<S> transition, Continuation<? super C01772> continuation) {
            super(1, continuation);
            this.this$0 = seekableTransitionState;
            this.$targetState = s;
            this.$transition = transition;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
            return new C01772(this.this$0, this.$targetState, this.$transition, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(@Nullable Continuation<? super Unit> continuation) {
            return ((C01772) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(@NotNull Object obj) {
            float f;
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.this$0.endAllAnimations();
                ((SeekableTransitionState) this.this$0).lastFrameTimeNanos = Long.MIN_VALUE;
                this.this$0.setFraction(0.0f);
                S s = this.$targetState;
                if (Intrinsics.areEqual(s, this.this$0.getCurrentState())) {
                    f = -4.0f;
                } else {
                    f = Intrinsics.areEqual(s, this.this$0.getTargetState()) ? -5.0f : -3.0f;
                }
                this.$transition.updateTarget$animation_core_release(this.$targetState);
                this.$transition.setPlayTimeNanos(0L);
                this.this$0.setTargetState$animation_core_release(this.$targetState);
                this.this$0.setFraction(0.0f);
                this.this$0.setCurrentState$animation_core_release(this.$targetState);
                this.$transition.resetAnimationFraction$animation_core_release(f);
                if (f == -3.0f) {
                    SeekableTransitionState<S> seekableTransitionState = this.this$0;
                    this.label = 1;
                    if (seekableTransitionState.waitForCompositionAfterTargetStateChange(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            this.$transition.onTransitionEnd$animation_core_release();
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object seekTo$default(SeekableTransitionState seekableTransitionState, float f, Object obj, Continuation continuation, int i, Object obj2) {
        if ((i & 2) != 0) {
            obj = seekableTransitionState.getTargetState();
        }
        return seekableTransitionState.seekTo(f, obj, continuation);
    }

    public final Object seekTo(@FloatRange(from = 0.0d, to = 1.0d) float f, S s, @NotNull Continuation<? super Unit> continuation) {
        if (0.0f > f || f > 1.0f) {
            PreconditionsKt.throwIllegalArgumentException("Expecting fraction between 0 and 1. Got " + f);
        }
        Transition<S> transition = this.transition;
        if (transition == null) {
            return Unit.INSTANCE;
        }
        Object objMutate$default = MutatorMutex.mutate$default(this.mutatorMutex, null, new AnonymousClass3(s, getTargetState(), this, transition, f, null), continuation, 1, null);
        return objMutate$default == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMutate$default : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.SeekableTransitionState$seekTo$3, reason: invalid class name */
    /* JADX INFO: loaded from: classes3.dex */
    @DebugMetadata(c = "androidx.compose.animation.core.SeekableTransitionState$seekTo$3", f = "Transition.kt", i = {}, l = {509}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ float $fraction;
        final /* synthetic */ S $oldTargetState;
        final /* synthetic */ S $targetState;
        final /* synthetic */ Transition<S> $transition;
        int label;
        final /* synthetic */ SeekableTransitionState<S> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(S s, S s2, SeekableTransitionState<S> seekableTransitionState, Transition<S> transition, float f, Continuation<? super AnonymousClass3> continuation) {
            super(1, continuation);
            this.$targetState = s;
            this.$oldTargetState = s2;
            this.this$0 = seekableTransitionState;
            this.$transition = transition;
            this.$fraction = f;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
            return new AnonymousClass3(this.$targetState, this.$oldTargetState, this.this$0, this.$transition, this.$fraction, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(@Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: androidx.compose.animation.core.SeekableTransitionState$seekTo$3$1, reason: invalid class name */
        @DebugMetadata(c = "androidx.compose.animation.core.SeekableTransitionState$seekTo$3$1", f = "Transition.kt", i = {}, l = {531}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ float $fraction;
            final /* synthetic */ S $oldTargetState;
            final /* synthetic */ S $targetState;
            final /* synthetic */ Transition<S> $transition;
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ SeekableTransitionState<S> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(S s, S s2, SeekableTransitionState<S> seekableTransitionState, Transition<S> transition, float f, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$targetState = s;
                this.$oldTargetState = s2;
                this.this$0 = seekableTransitionState;
                this.$transition = transition;
                this.$fraction = f;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$targetState, this.$oldTargetState, this.this$0, this.$transition, this.$fraction, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(@NotNull Object obj) {
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                    if (!Intrinsics.areEqual(this.$targetState, this.$oldTargetState)) {
                        this.this$0.moveAnimationToInitialState();
                    } else {
                        ((SeekableTransitionState) this.this$0).currentAnimation = null;
                        if (Intrinsics.areEqual(this.this$0.getCurrentState(), this.$targetState)) {
                            return Unit.INSTANCE;
                        }
                    }
                    if (!Intrinsics.areEqual(this.$targetState, this.$oldTargetState)) {
                        this.$transition.updateTarget$animation_core_release(this.$targetState);
                        this.$transition.setPlayTimeNanos(0L);
                        this.this$0.setTargetState$animation_core_release(this.$targetState);
                        this.$transition.resetAnimationFraction$animation_core_release(this.$fraction);
                    }
                    this.this$0.setFraction(this.$fraction);
                    if (((SeekableTransitionState) this.this$0).initialValueAnimations.isNotEmpty()) {
                        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C00041(this.this$0, null), 3, null);
                    } else {
                        ((SeekableTransitionState) this.this$0).lastFrameTimeNanos = Long.MIN_VALUE;
                    }
                    SeekableTransitionState<S> seekableTransitionState = this.this$0;
                    this.label = 1;
                    if (seekableTransitionState.waitForCompositionAfterTargetStateChange(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.this$0.seekToFraction();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: androidx.compose.animation.core.SeekableTransitionState$seekTo$3$1$1, reason: invalid class name and collision with other inner class name */
            @DebugMetadata(c = "androidx.compose.animation.core.SeekableTransitionState$seekTo$3$1$1", f = "Transition.kt", i = {}, l = {527}, m = "invokeSuspend", n = {}, s = {})
            static final class C00041 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ SeekableTransitionState<S> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C00041(SeekableTransitionState<S> seekableTransitionState, Continuation<? super C00041> continuation) {
                    super(2, continuation);
                    this.this$0 = seekableTransitionState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                    return new C00041(this.this$0, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                    return ((C00041) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(@NotNull Object obj) {
                    Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        SeekableTransitionState<S> seekableTransitionState = this.this$0;
                        this.label = 1;
                        if (seekableTransitionState.runAnimations(this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$targetState, this.$oldTargetState, this.this$0, this.$transition, this.$fraction, null);
                this.label = 1;
                if (CoroutineScopeKt.coroutineScope(anonymousClass1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:33:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Instruction removed from duplicated block: B:33:0x00a3, please report this as an issue */
    public final Object waitForCompositionAfterTargetStateChange(Continuation<? super Unit> continuation) {
        C01791 c01791;
        Object targetState;
        SeekableTransitionState seekableTransitionState;
        Object obj;
        SeekableTransitionState seekableTransitionState2;
        if (continuation instanceof C01791) {
            c01791 = (C01791) continuation;
            int i = c01791.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c01791.label = i - Integer.MIN_VALUE;
            } else {
                c01791 = new C01791(this, continuation);
            }
        } else {
            c01791 = new C01791(this, continuation);
        }
        Object obj2 = c01791.result;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c01791.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj2);
            targetState = getTargetState();
            Mutex mutex = this.compositionContinuationMutex;
            c01791.L$0 = this;
            c01791.L$1 = targetState;
            c01791.label = 1;
            if (Mutex.DefaultImpls.lock$default(mutex, null, c01791, 1, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
            seekableTransitionState = this;
        } else {
            if (i2 == 1) {
                Object obj3 = c01791.L$1;
                seekableTransitionState = (SeekableTransitionState) c01791.L$0;
                ResultKt.throwOnFailure(obj2);
                targetState = obj3;
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                obj = c01791.L$1;
                seekableTransitionState2 = (SeekableTransitionState) c01791.L$0;
                ResultKt.throwOnFailure(obj2);
            }
            if (!Intrinsics.areEqual(obj2, obj)) {
                seekableTransitionState2.lastFrameTimeNanos = Long.MIN_VALUE;
                throw new CancellationException("snapTo() was canceled because state was changed to " + obj2 + " instead of " + obj);
            }
            return Unit.INSTANCE;
        }
        if (Intrinsics.areEqual(targetState, seekableTransitionState.composedTargetState)) {
            Mutex.DefaultImpls.unlock$default(seekableTransitionState.compositionContinuationMutex, null, 1, null);
        } else {
            c01791.L$0 = seekableTransitionState;
            c01791.L$1 = targetState;
            c01791.label = 2;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(c01791), 1);
            cancellableContinuationImpl.initCancellability();
            seekableTransitionState.setCompositionContinuation$animation_core_release(cancellableContinuationImpl);
            Mutex.DefaultImpls.unlock$default(seekableTransitionState.getCompositionContinuationMutex$animation_core_release(), null, 1, null);
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(c01791);
            }
            if (result == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj = targetState;
            obj2 = result;
            seekableTransitionState2 = seekableTransitionState;
            if (!Intrinsics.areEqual(obj2, obj)) {
                seekableTransitionState2.lastFrameTimeNanos = Long.MIN_VALUE;
                throw new CancellationException("snapTo() was canceled because state was changed to " + obj2 + " instead of " + obj);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:28:0x0092  */
    /* JADX WARN: Code duplicated, block: B:30:0x0095  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object waitForComposition(Continuation<? super Unit> continuation) {
        C01781 c01781;
        Object targetState;
        SeekableTransitionState seekableTransitionState;
        Object obj;
        SeekableTransitionState seekableTransitionState2;
        if (continuation instanceof C01781) {
            c01781 = (C01781) continuation;
            int i = c01781.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c01781.label = i - Integer.MIN_VALUE;
            } else {
                c01781 = new C01781(this, continuation);
            }
        } else {
            c01781 = new C01781(this, continuation);
        }
        Object obj2 = c01781.result;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c01781.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj2);
            targetState = getTargetState();
            Mutex mutex = this.compositionContinuationMutex;
            c01781.L$0 = this;
            c01781.L$1 = targetState;
            c01781.label = 1;
            if (Mutex.DefaultImpls.lock$default(mutex, null, c01781, 1, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
            seekableTransitionState = this;
        } else {
            if (i2 == 1) {
                Object obj3 = c01781.L$1;
                seekableTransitionState = (SeekableTransitionState) c01781.L$0;
                ResultKt.throwOnFailure(obj2);
                targetState = obj3;
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                obj = c01781.L$1;
                seekableTransitionState2 = (SeekableTransitionState) c01781.L$0;
                ResultKt.throwOnFailure(obj2);
            }
            if (Intrinsics.areEqual(obj2, obj)) {
                seekableTransitionState2.lastFrameTimeNanos = Long.MIN_VALUE;
                throw new CancellationException("targetState while waiting for composition");
            }
            return Unit.INSTANCE;
        }
        c01781.L$0 = seekableTransitionState;
        c01781.L$1 = targetState;
        c01781.label = 2;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(c01781), 1);
        cancellableContinuationImpl.initCancellability();
        seekableTransitionState.setCompositionContinuation$animation_core_release(cancellableContinuationImpl);
        Mutex.DefaultImpls.unlock$default(seekableTransitionState.getCompositionContinuationMutex$animation_core_release(), null, 1, null);
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(c01781);
        }
        if (result == coroutine_suspended) {
            return coroutine_suspended;
        }
        obj = targetState;
        obj2 = result;
        seekableTransitionState2 = seekableTransitionState;
        if (Intrinsics.areEqual(obj2, obj)) {
            seekableTransitionState2.lastFrameTimeNanos = Long.MIN_VALUE;
            throw new CancellationException("targetState while waiting for composition");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void moveAnimationToInitialState() {
        Transition<S> transition = this.transition;
        if (transition == null) {
            return;
        }
        SeekingAnimationState seekingAnimationState = this.currentAnimation;
        if (seekingAnimationState == null) {
            if (this.totalDurationNanos <= 0 || getFraction() == 1.0f || Intrinsics.areEqual(getCurrentState(), getTargetState())) {
                seekingAnimationState = null;
            } else {
                seekingAnimationState = new SeekingAnimationState();
                seekingAnimationState.setValue(getFraction());
                long j = this.totalDurationNanos;
                seekingAnimationState.setDurationNanos(j);
                seekingAnimationState.setAnimationSpecDuration(MathKt__MathJVMKt.roundToLong(j * (1.0d - ((double) getFraction()))));
                seekingAnimationState.getStart().set$animation_core_release(0, getFraction());
            }
        }
        if (seekingAnimationState != null) {
            seekingAnimationState.setDurationNanos(this.totalDurationNanos);
            this.initialValueAnimations.add(seekingAnimationState);
            transition.setInitialAnimations$animation_core_release(seekingAnimationState);
        }
        this.currentAnimation = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object animateTo$default(SeekableTransitionState seekableTransitionState, Object obj, FiniteAnimationSpec finiteAnimationSpec, Continuation continuation, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = seekableTransitionState.getTargetState();
        }
        if ((i & 2) != 0) {
            finiteAnimationSpec = null;
        }
        return seekableTransitionState.animateTo(obj, finiteAnimationSpec, continuation);
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.SeekableTransitionState$animateTo$2, reason: invalid class name */
    /* JADX INFO: loaded from: classes3.dex */
    @DebugMetadata(c = "androidx.compose.animation.core.SeekableTransitionState$animateTo$2", f = "Transition.kt", i = {}, l = {623}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ FiniteAnimationSpec<Float> $animationSpec;
        final /* synthetic */ S $targetState;
        final /* synthetic */ Transition<S> $transition;
        int label;
        final /* synthetic */ SeekableTransitionState<S> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Transition<S> transition, SeekableTransitionState<S> seekableTransitionState, S s, FiniteAnimationSpec<Float> finiteAnimationSpec, Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
            this.$transition = transition;
            this.this$0 = seekableTransitionState;
            this.$targetState = s;
            this.$animationSpec = finiteAnimationSpec;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
            return new AnonymousClass2(this.$transition, this.this$0, this.$targetState, this.$animationSpec, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(@Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: androidx.compose.animation.core.SeekableTransitionState$animateTo$2$1, reason: invalid class name */
        @DebugMetadata(c = "androidx.compose.animation.core.SeekableTransitionState$animateTo$2$1", f = "Transition.kt", i = {0}, l = {2191, 636, 638, 690, 692}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ FiniteAnimationSpec<Float> $animationSpec;
            final /* synthetic */ S $targetState;
            final /* synthetic */ Transition<S> $transition;
            Object L$0;
            Object L$1;
            int label;
            final /* synthetic */ SeekableTransitionState<S> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(SeekableTransitionState<S> seekableTransitionState, S s, Transition<S> transition, FiniteAnimationSpec<Float> finiteAnimationSpec, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = seekableTransitionState;
                this.$targetState = s;
                this.$transition = transition;
                this.$animationSpec = finiteAnimationSpec;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$targetState, this.$transition, this.$animationSpec, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code duplicated, block: B:31:0x00b7 A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:34:0x00c6  */
            /* JADX WARN: Code duplicated, block: B:36:0x00d2  */
            /* JADX WARN: Code duplicated, block: B:38:0x00dc  */
            /* JADX WARN: Code duplicated, block: B:39:0x00e7  */
            /* JADX WARN: Code duplicated, block: B:41:0x00ea  */
            /* JADX WARN: Code duplicated, block: B:43:0x00f4 A[DONT_INVERT] */
            /* JADX WARN: Code duplicated, block: B:44:0x00f6  */
            /* JADX WARN: Code duplicated, block: B:45:0x00fc  */
            /* JADX WARN: Code duplicated, block: B:47:0x00ff  */
            /* JADX WARN: Code duplicated, block: B:49:0x0115  */
            /* JADX WARN: Code duplicated, block: B:51:0x0126  */
            /* JADX WARN: Code duplicated, block: B:52:0x0128  */
            /* JADX WARN: Code duplicated, block: B:62:0x015b  */
            /* JADX WARN: Code duplicated, block: B:64:0x0165  */
            /* JADX WARN: Code duplicated, block: B:67:0x0198  */
            /* JADX WARN: Code duplicated, block: B:68:0x01a9  */
            /* JADX WARN: Code duplicated, block: B:72:0x01d5 A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:75:0x01e7 A[RETURN] */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(@NotNull Object obj) {
                Mutex mutex;
                SeekableTransitionState<S> seekableTransitionState;
                SeekableTransitionState<S> seekableTransitionState2;
                SeekableTransitionState<S> seekableTransitionState3;
                SeekingAnimationState seekingAnimationState;
                FiniteAnimationSpec<Float> finiteAnimationSpec;
                VectorizedAnimationSpec<AnimationVector1D> vectorizedAnimationSpecVectorize;
                VectorizedAnimationSpec<AnimationVector1D> animationSpec;
                AnimationVector1D zeroVelocity;
                long jRoundToLong;
                AnimationVector1D initialVelocity;
                SeekableTransitionState<S> seekableTransitionState4;
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                try {
                    if (i != 0) {
                        if (i == 1) {
                            seekableTransitionState = (SeekableTransitionState) this.L$1;
                            mutex = (Mutex) this.L$0;
                            ResultKt.throwOnFailure(obj);
                        } else {
                            if (i == 2) {
                                ResultKt.throwOnFailure(obj);
                                seekableTransitionState2 = this.this$0;
                                this.label = 3;
                                if (seekableTransitionState2.waitForCompositionAfterTargetStateChange(this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                if (!Intrinsics.areEqual(this.this$0.getCurrentState(), this.$targetState)) {
                                    if (this.this$0.getFraction() < 1.0f) {
                                        seekingAnimationState = ((SeekableTransitionState) this.this$0).currentAnimation;
                                        finiteAnimationSpec = this.$animationSpec;
                                        if (finiteAnimationSpec != null) {
                                            vectorizedAnimationSpecVectorize = finiteAnimationSpec.vectorize((TwoWayConverter<Float, V>) VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE));
                                        } else {
                                            vectorizedAnimationSpecVectorize = null;
                                        }
                                        if (seekingAnimationState != null) {
                                            if (seekingAnimationState != null) {
                                                animationSpec = seekingAnimationState.getAnimationSpec();
                                            } else {
                                                animationSpec = null;
                                            }
                                            if (animationSpec != null) {
                                                long progressNanos = seekingAnimationState.getProgressNanos();
                                                AnimationVector1D start = seekingAnimationState.getStart();
                                                AnimationVector1D target1 = SeekableTransitionState.Companion.getTarget1();
                                                initialVelocity = seekingAnimationState.getInitialVelocity();
                                                if (initialVelocity == null) {
                                                    initialVelocity = SeekableTransitionState.Companion.getZeroVelocity();
                                                }
                                                zeroVelocity = (AnimationVector1D) animationSpec.getVelocityFromNanos(progressNanos, start, target1, initialVelocity);
                                            } else if (seekingAnimationState != null) {
                                                zeroVelocity = SeekableTransitionState.Companion.getZeroVelocity();
                                            } else {
                                                zeroVelocity = SeekableTransitionState.Companion.getZeroVelocity();
                                            }
                                            if (seekingAnimationState == null) {
                                                seekingAnimationState = new SeekingAnimationState();
                                            }
                                            seekingAnimationState.setAnimationSpec(vectorizedAnimationSpecVectorize);
                                            seekingAnimationState.setComplete(false);
                                            seekingAnimationState.setValue(this.this$0.getFraction());
                                            seekingAnimationState.getStart().set$animation_core_release(0, this.this$0.getFraction());
                                            seekingAnimationState.setDurationNanos(this.this$0.getTotalDurationNanos$animation_core_release());
                                            seekingAnimationState.setProgressNanos(0L);
                                            seekingAnimationState.setInitialVelocity(zeroVelocity);
                                            if (vectorizedAnimationSpecVectorize != null) {
                                                jRoundToLong = vectorizedAnimationSpecVectorize.getDurationNanos(seekingAnimationState.getStart(), SeekableTransitionState.Companion.getTarget1(), zeroVelocity);
                                            } else {
                                                jRoundToLong = MathKt__MathJVMKt.roundToLong(this.this$0.getTotalDurationNanos$animation_core_release() * (1.0d - ((double) this.this$0.getFraction())));
                                            }
                                            seekingAnimationState.setAnimationSpecDuration(jRoundToLong);
                                            ((SeekableTransitionState) this.this$0).currentAnimation = seekingAnimationState;
                                        } else {
                                            if (seekingAnimationState != null) {
                                                animationSpec = seekingAnimationState.getAnimationSpec();
                                            } else {
                                                animationSpec = null;
                                            }
                                            if (animationSpec != null) {
                                                long progressNanos2 = seekingAnimationState.getProgressNanos();
                                                AnimationVector1D start2 = seekingAnimationState.getStart();
                                                AnimationVector1D target2 = SeekableTransitionState.Companion.getTarget1();
                                                initialVelocity = seekingAnimationState.getInitialVelocity();
                                                if (initialVelocity == null) {
                                                    initialVelocity = SeekableTransitionState.Companion.getZeroVelocity();
                                                }
                                                zeroVelocity = (AnimationVector1D) animationSpec.getVelocityFromNanos(progressNanos2, start2, target2, initialVelocity);
                                            } else if (seekingAnimationState != null) {
                                                zeroVelocity = SeekableTransitionState.Companion.getZeroVelocity();
                                            } else {
                                                zeroVelocity = SeekableTransitionState.Companion.getZeroVelocity();
                                            }
                                            if (seekingAnimationState == null) {
                                                seekingAnimationState = new SeekingAnimationState();
                                            }
                                            seekingAnimationState.setAnimationSpec(vectorizedAnimationSpecVectorize);
                                            seekingAnimationState.setComplete(false);
                                            seekingAnimationState.setValue(this.this$0.getFraction());
                                            seekingAnimationState.getStart().set$animation_core_release(0, this.this$0.getFraction());
                                            seekingAnimationState.setDurationNanos(this.this$0.getTotalDurationNanos$animation_core_release());
                                            seekingAnimationState.setProgressNanos(0L);
                                            seekingAnimationState.setInitialVelocity(zeroVelocity);
                                            if (vectorizedAnimationSpecVectorize != null) {
                                                jRoundToLong = vectorizedAnimationSpecVectorize.getDurationNanos(seekingAnimationState.getStart(), SeekableTransitionState.Companion.getTarget1(), zeroVelocity);
                                            } else {
                                                jRoundToLong = MathKt__MathJVMKt.roundToLong(this.this$0.getTotalDurationNanos$animation_core_release() * (1.0d - ((double) this.this$0.getFraction())));
                                            }
                                            seekingAnimationState.setAnimationSpecDuration(jRoundToLong);
                                            ((SeekableTransitionState) this.this$0).currentAnimation = seekingAnimationState;
                                        }
                                    }
                                    seekableTransitionState3 = this.this$0;
                                    this.L$0 = null;
                                    this.L$1 = null;
                                    this.label = 4;
                                    if (seekableTransitionState3.runAnimations(this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    this.this$0.setCurrentState$animation_core_release(this.$targetState);
                                    seekableTransitionState4 = this.this$0;
                                    this.label = 5;
                                    if (seekableTransitionState4.waitForComposition(this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                            if (i == 3) {
                                ResultKt.throwOnFailure(obj);
                                if (!Intrinsics.areEqual(this.this$0.getCurrentState(), this.$targetState)) {
                                    if (this.this$0.getFraction() < 1.0f) {
                                        seekingAnimationState = ((SeekableTransitionState) this.this$0).currentAnimation;
                                        finiteAnimationSpec = this.$animationSpec;
                                        if (finiteAnimationSpec != null) {
                                            vectorizedAnimationSpecVectorize = finiteAnimationSpec.vectorize((TwoWayConverter<Float, V>) VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE));
                                        } else {
                                            vectorizedAnimationSpecVectorize = null;
                                        }
                                        if (seekingAnimationState != null || !Intrinsics.areEqual(vectorizedAnimationSpecVectorize, seekingAnimationState.getAnimationSpec())) {
                                            if (seekingAnimationState != null) {
                                                animationSpec = seekingAnimationState.getAnimationSpec();
                                            } else {
                                                animationSpec = null;
                                            }
                                            if (animationSpec != null) {
                                                long progressNanos3 = seekingAnimationState.getProgressNanos();
                                                AnimationVector1D start3 = seekingAnimationState.getStart();
                                                AnimationVector1D target3 = SeekableTransitionState.Companion.getTarget1();
                                                initialVelocity = seekingAnimationState.getInitialVelocity();
                                                if (initialVelocity == null) {
                                                    initialVelocity = SeekableTransitionState.Companion.getZeroVelocity();
                                                }
                                                zeroVelocity = (AnimationVector1D) animationSpec.getVelocityFromNanos(progressNanos3, start3, target3, initialVelocity);
                                            } else if (seekingAnimationState != null || seekingAnimationState.getProgressNanos() == 0) {
                                                zeroVelocity = SeekableTransitionState.Companion.getZeroVelocity();
                                            } else {
                                                long durationNanos = seekingAnimationState.getDurationNanos();
                                                if (durationNanos == Long.MIN_VALUE) {
                                                    durationNanos = this.this$0.getTotalDurationNanos$animation_core_release();
                                                }
                                                float f = durationNanos / 1.0E9f;
                                                zeroVelocity = f <= 0.0f ? SeekableTransitionState.Companion.getZeroVelocity() : new AnimationVector1D(1.0f / f);
                                            }
                                            if (seekingAnimationState == null) {
                                                seekingAnimationState = new SeekingAnimationState();
                                            }
                                            seekingAnimationState.setAnimationSpec(vectorizedAnimationSpecVectorize);
                                            seekingAnimationState.setComplete(false);
                                            seekingAnimationState.setValue(this.this$0.getFraction());
                                            seekingAnimationState.getStart().set$animation_core_release(0, this.this$0.getFraction());
                                            seekingAnimationState.setDurationNanos(this.this$0.getTotalDurationNanos$animation_core_release());
                                            seekingAnimationState.setProgressNanos(0L);
                                            seekingAnimationState.setInitialVelocity(zeroVelocity);
                                            if (vectorizedAnimationSpecVectorize != null) {
                                                jRoundToLong = vectorizedAnimationSpecVectorize.getDurationNanos(seekingAnimationState.getStart(), SeekableTransitionState.Companion.getTarget1(), zeroVelocity);
                                            } else {
                                                jRoundToLong = MathKt__MathJVMKt.roundToLong(this.this$0.getTotalDurationNanos$animation_core_release() * (1.0d - ((double) this.this$0.getFraction())));
                                            }
                                            seekingAnimationState.setAnimationSpecDuration(jRoundToLong);
                                            ((SeekableTransitionState) this.this$0).currentAnimation = seekingAnimationState;
                                        }
                                    }
                                    seekableTransitionState3 = this.this$0;
                                    this.L$0 = null;
                                    this.L$1 = null;
                                    this.label = 4;
                                    if (seekableTransitionState3.runAnimations(this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    this.this$0.setCurrentState$animation_core_release(this.$targetState);
                                    seekableTransitionState4 = this.this$0;
                                    this.label = 5;
                                    if (seekableTransitionState4.waitForComposition(this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                            if (i == 4) {
                                ResultKt.throwOnFailure(obj);
                                this.this$0.setCurrentState$animation_core_release(this.$targetState);
                                seekableTransitionState4 = this.this$0;
                                this.label = 5;
                                if (seekableTransitionState4.waitForComposition(this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else {
                                if (i != 5) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj);
                            }
                        }
                        this.this$0.setFraction(0.0f);
                        return Unit.INSTANCE;
                    }
                    ResultKt.throwOnFailure(obj);
                    S targetState = this.this$0.getTargetState();
                    if (!Intrinsics.areEqual(this.$targetState, targetState)) {
                        this.this$0.moveAnimationToInitialState();
                        this.this$0.setFraction(0.0f);
                        this.$transition.updateTarget$animation_core_release(this.$targetState);
                        this.$transition.setPlayTimeNanos(0L);
                        this.this$0.setCurrentState$animation_core_release(targetState);
                        this.this$0.setTargetState$animation_core_release(this.$targetState);
                    }
                    Mutex compositionContinuationMutex$animation_core_release = this.this$0.getCompositionContinuationMutex$animation_core_release();
                    SeekableTransitionState<S> seekableTransitionState5 = this.this$0;
                    this.L$0 = compositionContinuationMutex$animation_core_release;
                    this.L$1 = seekableTransitionState5;
                    this.label = 1;
                    if (compositionContinuationMutex$animation_core_release.lock(null, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    mutex = compositionContinuationMutex$animation_core_release;
                    seekableTransitionState = seekableTransitionState5;
                    S composedTargetState$animation_core_release = seekableTransitionState.getComposedTargetState$animation_core_release();
                    mutex.unlock(null);
                    if (!Intrinsics.areEqual(this.$targetState, composedTargetState$animation_core_release)) {
                        SeekableTransitionState<S> seekableTransitionState6 = this.this$0;
                        this.L$0 = null;
                        this.L$1 = null;
                        this.label = 2;
                        if (seekableTransitionState6.doOneFrame(this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        seekableTransitionState2 = this.this$0;
                        this.label = 3;
                        if (seekableTransitionState2.waitForCompositionAfterTargetStateChange(this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        if (!Intrinsics.areEqual(this.this$0.getCurrentState(), this.$targetState)) {
                            if (this.this$0.getFraction() < 1.0f) {
                                seekingAnimationState = ((SeekableTransitionState) this.this$0).currentAnimation;
                                finiteAnimationSpec = this.$animationSpec;
                                if (finiteAnimationSpec != null) {
                                    vectorizedAnimationSpecVectorize = finiteAnimationSpec.vectorize((TwoWayConverter<Float, V>) VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE));
                                } else {
                                    vectorizedAnimationSpecVectorize = null;
                                }
                                if (seekingAnimationState != null) {
                                    if (seekingAnimationState != null) {
                                        animationSpec = seekingAnimationState.getAnimationSpec();
                                    } else {
                                        animationSpec = null;
                                    }
                                    if (animationSpec != null) {
                                        long progressNanos4 = seekingAnimationState.getProgressNanos();
                                        AnimationVector1D start4 = seekingAnimationState.getStart();
                                        AnimationVector1D target4 = SeekableTransitionState.Companion.getTarget1();
                                        initialVelocity = seekingAnimationState.getInitialVelocity();
                                        if (initialVelocity == null) {
                                            initialVelocity = SeekableTransitionState.Companion.getZeroVelocity();
                                        }
                                        zeroVelocity = (AnimationVector1D) animationSpec.getVelocityFromNanos(progressNanos4, start4, target4, initialVelocity);
                                    } else if (seekingAnimationState != null) {
                                        zeroVelocity = SeekableTransitionState.Companion.getZeroVelocity();
                                    } else {
                                        zeroVelocity = SeekableTransitionState.Companion.getZeroVelocity();
                                    }
                                    if (seekingAnimationState == null) {
                                        seekingAnimationState = new SeekingAnimationState();
                                    }
                                    seekingAnimationState.setAnimationSpec(vectorizedAnimationSpecVectorize);
                                    seekingAnimationState.setComplete(false);
                                    seekingAnimationState.setValue(this.this$0.getFraction());
                                    seekingAnimationState.getStart().set$animation_core_release(0, this.this$0.getFraction());
                                    seekingAnimationState.setDurationNanos(this.this$0.getTotalDurationNanos$animation_core_release());
                                    seekingAnimationState.setProgressNanos(0L);
                                    seekingAnimationState.setInitialVelocity(zeroVelocity);
                                    if (vectorizedAnimationSpecVectorize != null) {
                                        jRoundToLong = vectorizedAnimationSpecVectorize.getDurationNanos(seekingAnimationState.getStart(), SeekableTransitionState.Companion.getTarget1(), zeroVelocity);
                                    } else {
                                        jRoundToLong = MathKt__MathJVMKt.roundToLong(this.this$0.getTotalDurationNanos$animation_core_release() * (1.0d - ((double) this.this$0.getFraction())));
                                    }
                                    seekingAnimationState.setAnimationSpecDuration(jRoundToLong);
                                    ((SeekableTransitionState) this.this$0).currentAnimation = seekingAnimationState;
                                } else {
                                    if (seekingAnimationState != null) {
                                        animationSpec = seekingAnimationState.getAnimationSpec();
                                    } else {
                                        animationSpec = null;
                                    }
                                    if (animationSpec != null) {
                                        long progressNanos5 = seekingAnimationState.getProgressNanos();
                                        AnimationVector1D start5 = seekingAnimationState.getStart();
                                        AnimationVector1D target5 = SeekableTransitionState.Companion.getTarget1();
                                        initialVelocity = seekingAnimationState.getInitialVelocity();
                                        if (initialVelocity == null) {
                                            initialVelocity = SeekableTransitionState.Companion.getZeroVelocity();
                                        }
                                        zeroVelocity = (AnimationVector1D) animationSpec.getVelocityFromNanos(progressNanos5, start5, target5, initialVelocity);
                                    } else if (seekingAnimationState != null) {
                                        zeroVelocity = SeekableTransitionState.Companion.getZeroVelocity();
                                    } else {
                                        zeroVelocity = SeekableTransitionState.Companion.getZeroVelocity();
                                    }
                                    if (seekingAnimationState == null) {
                                        seekingAnimationState = new SeekingAnimationState();
                                    }
                                    seekingAnimationState.setAnimationSpec(vectorizedAnimationSpecVectorize);
                                    seekingAnimationState.setComplete(false);
                                    seekingAnimationState.setValue(this.this$0.getFraction());
                                    seekingAnimationState.getStart().set$animation_core_release(0, this.this$0.getFraction());
                                    seekingAnimationState.setDurationNanos(this.this$0.getTotalDurationNanos$animation_core_release());
                                    seekingAnimationState.setProgressNanos(0L);
                                    seekingAnimationState.setInitialVelocity(zeroVelocity);
                                    if (vectorizedAnimationSpecVectorize != null) {
                                        jRoundToLong = vectorizedAnimationSpecVectorize.getDurationNanos(seekingAnimationState.getStart(), SeekableTransitionState.Companion.getTarget1(), zeroVelocity);
                                    } else {
                                        jRoundToLong = MathKt__MathJVMKt.roundToLong(this.this$0.getTotalDurationNanos$animation_core_release() * (1.0d - ((double) this.this$0.getFraction())));
                                    }
                                    seekingAnimationState.setAnimationSpecDuration(jRoundToLong);
                                    ((SeekableTransitionState) this.this$0).currentAnimation = seekingAnimationState;
                                }
                            }
                            seekableTransitionState3 = this.this$0;
                            this.L$0 = null;
                            this.L$1 = null;
                            this.label = 4;
                            if (seekableTransitionState3.runAnimations(this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            this.this$0.setCurrentState$animation_core_release(this.$targetState);
                            seekableTransitionState4 = this.this$0;
                            this.label = 5;
                            if (seekableTransitionState4.waitForComposition(this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            this.this$0.setFraction(0.0f);
                        }
                    } else if (!Intrinsics.areEqual(this.this$0.getCurrentState(), this.$targetState)) {
                        if (this.this$0.getFraction() < 1.0f) {
                            seekingAnimationState = ((SeekableTransitionState) this.this$0).currentAnimation;
                            finiteAnimationSpec = this.$animationSpec;
                            if (finiteAnimationSpec != null) {
                                vectorizedAnimationSpecVectorize = finiteAnimationSpec.vectorize((TwoWayConverter<Float, V>) VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE));
                            } else {
                                vectorizedAnimationSpecVectorize = null;
                            }
                            if (seekingAnimationState != null) {
                                if (seekingAnimationState != null) {
                                    animationSpec = seekingAnimationState.getAnimationSpec();
                                } else {
                                    animationSpec = null;
                                }
                                if (animationSpec != null) {
                                    long progressNanos6 = seekingAnimationState.getProgressNanos();
                                    AnimationVector1D start6 = seekingAnimationState.getStart();
                                    AnimationVector1D target6 = SeekableTransitionState.Companion.getTarget1();
                                    initialVelocity = seekingAnimationState.getInitialVelocity();
                                    if (initialVelocity == null) {
                                        initialVelocity = SeekableTransitionState.Companion.getZeroVelocity();
                                    }
                                    zeroVelocity = (AnimationVector1D) animationSpec.getVelocityFromNanos(progressNanos6, start6, target6, initialVelocity);
                                } else if (seekingAnimationState != null) {
                                    zeroVelocity = SeekableTransitionState.Companion.getZeroVelocity();
                                } else {
                                    zeroVelocity = SeekableTransitionState.Companion.getZeroVelocity();
                                }
                                if (seekingAnimationState == null) {
                                    seekingAnimationState = new SeekingAnimationState();
                                }
                                seekingAnimationState.setAnimationSpec(vectorizedAnimationSpecVectorize);
                                seekingAnimationState.setComplete(false);
                                seekingAnimationState.setValue(this.this$0.getFraction());
                                seekingAnimationState.getStart().set$animation_core_release(0, this.this$0.getFraction());
                                seekingAnimationState.setDurationNanos(this.this$0.getTotalDurationNanos$animation_core_release());
                                seekingAnimationState.setProgressNanos(0L);
                                seekingAnimationState.setInitialVelocity(zeroVelocity);
                                if (vectorizedAnimationSpecVectorize != null) {
                                    jRoundToLong = vectorizedAnimationSpecVectorize.getDurationNanos(seekingAnimationState.getStart(), SeekableTransitionState.Companion.getTarget1(), zeroVelocity);
                                } else {
                                    jRoundToLong = MathKt__MathJVMKt.roundToLong(this.this$0.getTotalDurationNanos$animation_core_release() * (1.0d - ((double) this.this$0.getFraction())));
                                }
                                seekingAnimationState.setAnimationSpecDuration(jRoundToLong);
                                ((SeekableTransitionState) this.this$0).currentAnimation = seekingAnimationState;
                            } else {
                                if (seekingAnimationState != null) {
                                    animationSpec = seekingAnimationState.getAnimationSpec();
                                } else {
                                    animationSpec = null;
                                }
                                if (animationSpec != null) {
                                    long progressNanos7 = seekingAnimationState.getProgressNanos();
                                    AnimationVector1D start7 = seekingAnimationState.getStart();
                                    AnimationVector1D target7 = SeekableTransitionState.Companion.getTarget1();
                                    initialVelocity = seekingAnimationState.getInitialVelocity();
                                    if (initialVelocity == null) {
                                        initialVelocity = SeekableTransitionState.Companion.getZeroVelocity();
                                    }
                                    zeroVelocity = (AnimationVector1D) animationSpec.getVelocityFromNanos(progressNanos7, start7, target7, initialVelocity);
                                } else if (seekingAnimationState != null) {
                                    zeroVelocity = SeekableTransitionState.Companion.getZeroVelocity();
                                } else {
                                    zeroVelocity = SeekableTransitionState.Companion.getZeroVelocity();
                                }
                                if (seekingAnimationState == null) {
                                    seekingAnimationState = new SeekingAnimationState();
                                }
                                seekingAnimationState.setAnimationSpec(vectorizedAnimationSpecVectorize);
                                seekingAnimationState.setComplete(false);
                                seekingAnimationState.setValue(this.this$0.getFraction());
                                seekingAnimationState.getStart().set$animation_core_release(0, this.this$0.getFraction());
                                seekingAnimationState.setDurationNanos(this.this$0.getTotalDurationNanos$animation_core_release());
                                seekingAnimationState.setProgressNanos(0L);
                                seekingAnimationState.setInitialVelocity(zeroVelocity);
                                if (vectorizedAnimationSpecVectorize != null) {
                                    jRoundToLong = vectorizedAnimationSpecVectorize.getDurationNanos(seekingAnimationState.getStart(), SeekableTransitionState.Companion.getTarget1(), zeroVelocity);
                                } else {
                                    jRoundToLong = MathKt__MathJVMKt.roundToLong(this.this$0.getTotalDurationNanos$animation_core_release() * (1.0d - ((double) this.this$0.getFraction())));
                                }
                                seekingAnimationState.setAnimationSpecDuration(jRoundToLong);
                                ((SeekableTransitionState) this.this$0).currentAnimation = seekingAnimationState;
                            }
                        }
                        seekableTransitionState3 = this.this$0;
                        this.L$0 = null;
                        this.L$1 = null;
                        this.label = 4;
                        if (seekableTransitionState3.runAnimations(this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        this.this$0.setCurrentState$animation_core_release(this.$targetState);
                        seekableTransitionState4 = this.this$0;
                        this.label = 5;
                        if (seekableTransitionState4.waitForComposition(this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        this.this$0.setFraction(0.0f);
                    }
                    return Unit.INSTANCE;
                } catch (Throwable th) {
                    mutex.unlock(null);
                    throw th;
                }
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$targetState, this.$transition, this.$animationSpec, null);
                this.label = 1;
                if (CoroutineScopeKt.coroutineScope(anonymousClass1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            this.$transition.onTransitionEnd$animation_core_release();
            return Unit.INSTANCE;
        }
    }

    public final Object animateTo(S s, @Nullable FiniteAnimationSpec<Float> finiteAnimationSpec, @NotNull Continuation<? super Unit> continuation) {
        Transition<S> transition = this.transition;
        if (transition == null) {
            return Unit.INSTANCE;
        }
        Object objMutate$default = MutatorMutex.mutate$default(this.mutatorMutex, null, new AnonymousClass2(transition, this, s, finiteAnimationSpec, null), continuation, 1, null);
        return objMutate$default == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMutate$default : Unit.INSTANCE;
    }

    @Override // androidx.compose.animation.core.TransitionState
    public void transitionConfigured$animation_core_release(@NotNull Transition<S> transition) {
        Transition<S> transition2 = this.transition;
        if (transition2 != null && !Intrinsics.areEqual(transition, transition2)) {
            PreconditionsKt.throwIllegalStateException("An instance of SeekableTransitionState has been used in different Transitions. Previous instance: " + this.transition + ", new instance: " + transition);
        }
        this.transition = transition;
    }

    @Override // androidx.compose.animation.core.TransitionState
    public void transitionRemoved$animation_core_release() {
        this.transition = null;
        TransitionKt.getSeekableStateObserver().clear(this);
    }

    public final void observeTotalDuration$animation_core_release() {
        TransitionKt.getSeekableStateObserver().observeReads(this, TransitionKt.SeekableTransitionStateTotalDurationChanged, this.recalculateTotalDurationNanos);
    }

    public final void onTotalDurationChanged$animation_core_release() {
        long j = this.totalDurationNanos;
        observeTotalDuration$animation_core_release();
        long j2 = this.totalDurationNanos;
        if (j != j2) {
            SeekingAnimationState seekingAnimationState = this.currentAnimation;
            if (seekingAnimationState == null) {
                if (j2 != 0) {
                    seekToFraction();
                }
            } else {
                seekingAnimationState.setDurationNanos(j2);
                if (seekingAnimationState.getAnimationSpec() == null) {
                    seekingAnimationState.setAnimationSpecDuration(MathKt__MathJVMKt.roundToLong((1.0d - ((double) seekingAnimationState.getStart().get$animation_core_release(0))) * this.totalDurationNanos));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void seekToFraction() {
        Transition<S> transition = this.transition;
        if (transition == null) {
            return;
        }
        transition.seekAnimations$animation_core_release(MathKt__MathJVMKt.roundToLong(((double) getFraction()) * transition.getTotalDurationNanos()));
    }

    /* JADX INFO: loaded from: classes3.dex */
    public static final class SeekingAnimationState {
        public static final int $stable = 8;
        private VectorizedAnimationSpec<AnimationVector1D> animationSpec;
        private long animationSpecDuration;
        private long durationNanos;
        private AnimationVector1D initialVelocity;
        private boolean isComplete;
        private long progressNanos;
        private AnimationVector1D start = new AnimationVector1D(0.0f);
        private float value;

        public final long getProgressNanos() {
            return this.progressNanos;
        }

        public final void setProgressNanos(long j) {
            this.progressNanos = j;
        }

        public final VectorizedAnimationSpec<AnimationVector1D> getAnimationSpec() {
            return this.animationSpec;
        }

        public final void setAnimationSpec(@Nullable VectorizedAnimationSpec<AnimationVector1D> vectorizedAnimationSpec) {
            this.animationSpec = vectorizedAnimationSpec;
        }

        public final boolean isComplete() {
            return this.isComplete;
        }

        public final void setComplete(boolean z) {
            this.isComplete = z;
        }

        public final float getValue() {
            return this.value;
        }

        public final void setValue(float f) {
            this.value = f;
        }

        public final AnimationVector1D getStart() {
            return this.start;
        }

        public final void setStart(@NotNull AnimationVector1D animationVector1D) {
            this.start = animationVector1D;
        }

        public final AnimationVector1D getInitialVelocity() {
            return this.initialVelocity;
        }

        public final void setInitialVelocity(@Nullable AnimationVector1D animationVector1D) {
            this.initialVelocity = animationVector1D;
        }

        public final long getDurationNanos() {
            return this.durationNanos;
        }

        public final void setDurationNanos(long j) {
            this.durationNanos = j;
        }

        public final long getAnimationSpecDuration() {
            return this.animationSpecDuration;
        }

        public final void setAnimationSpecDuration(long j) {
            this.animationSpecDuration = j;
        }

        public String toString() {
            return "progress nanos: " + this.progressNanos + ", animationSpec: " + this.animationSpec + ", isComplete: " + this.isComplete + ", value: " + this.value + ", start: " + this.start + ", initialVelocity: " + this.initialVelocity + ", durationNanos: " + this.durationNanos + ", animationSpecDuration: " + this.animationSpecDuration;
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AnimationVector1D getZeroVelocity() {
            return SeekableTransitionState.ZeroVelocity;
        }

        public final AnimationVector1D getTarget1() {
            return SeekableTransitionState.Target1;
        }
    }
}
