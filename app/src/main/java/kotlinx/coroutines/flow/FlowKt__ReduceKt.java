package kotlinx.coroutines.flow;

import android.content.Context;
import android.graphics.Color;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.facebook.imageutils.JfifUtil;
import com.google.crypto.tink.KeysetHandle$$ExternalSyntheticLambda0;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.NoSuchElementException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.AbortFlowException;
import kotlinx.coroutines.flow.internal.FlowExceptions_commonKt;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import o.ArtificialStackFrames;
import o.asBinder;
import o.onPostMessage;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
final /* synthetic */ class FlowKt__ReduceKt {

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$first$1, reason: invalid class name */
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0, 0}, l = {179}, m = "first", n = {"result", "collector$iv"}, s = {"L$0", "L$1"})
    static final class AnonymousClass1<T> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt.first(null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$first$3, reason: invalid class name */
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0, 0, 0}, l = {179}, m = "first", n = {"predicate", "result", "collector$iv"}, s = {"L$0", "L$1", "L$2"})
    static final class AnonymousClass3<T> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt.first(null, null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$3, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0, 0}, l = {179}, m = "firstOrNull", n = {"result", "collector$iv"}, s = {"L$0", "L$1"})
    static final class C04923<T> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C04923(Continuation<? super C04923> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt.firstOrNull(null, null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0}, l = {40}, m = "fold", n = {"accumulator"}, s = {"L$0"})
    static final class C04931<T, R> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C04931(Continuation<? super C04931> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__ReduceKt.fold(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$last$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0}, l = {151}, m = "last", n = {"result"}, s = {"L$0"})
    static final class C04941<T> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C04941(Continuation<? super C04941> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt.last(null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$lastOrNull$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0}, l = {163}, m = "lastOrNull", n = {"result"}, s = {"L$0"})
    static final class C04961<T> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C04961(Continuation<? super C04961> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt.lastOrNull(null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0}, l = {18}, m = "reduce", n = {"accumulator"}, s = {"L$0"})
    static final class C04981<S, T extends S> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C04981(Continuation<? super C04981> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt.reduce(null, null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$single$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0}, l = {ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF}, m = "single", n = {"result"}, s = {"L$0"})
    static final class C05001<T> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C05001(Continuation<? super C05001> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt.single(null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$singleOrNull$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0, 0}, l = {179}, m = "singleOrNull", n = {"result", "collector$iv"}, s = {"L$0", "L$1"})
    static final class C05021<T> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C05021(Continuation<? super C05021> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt.singleOrNull(null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, kotlinx.coroutines.internal.Symbol] */
    public static final <S, T extends S> Object reduce(@NotNull Flow<? extends T> flow, @NotNull Function3<? super S, ? super T, ? super Continuation<? super S>, ? extends Object> function3, @NotNull Continuation<? super S> continuation) {
        C04981 c04981;
        Ref.ObjectRef objectRef;
        if (continuation instanceof C04981) {
            c04981 = (C04981) continuation;
            int i = c04981.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c04981.label = i - Integer.MIN_VALUE;
            } else {
                c04981 = new C04981(continuation);
            }
        } else {
            c04981 = new C04981(continuation);
        }
        Object obj = c04981.result;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c04981.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            objectRef2.element = NullSurrogateKt.NULL;
            FlowCollector<? super Object> c04992 = new C04992<>(objectRef2, function3);
            c04981.L$0 = objectRef2;
            c04981.label = 1;
            if (flow.collect(c04992, c04981) == coroutine_suspended) {
                return coroutine_suspended;
            }
            objectRef = objectRef2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objectRef = (Ref.ObjectRef) c04981.L$0;
            ResultKt.throwOnFailure(obj);
        }
        T t = objectRef.element;
        if (t != NullSurrogateKt.NULL) {
            return t;
        }
        throw new NoSuchElementException("Empty flow can't be reduced");
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: loaded from: classes6.dex */
    static final class C04992<T> implements FlowCollector {
        final /* synthetic */ Ref.ObjectRef<Object> $accumulator;
        final /* synthetic */ Function3<S, T, Continuation<? super S>, Object> $operation;

        /* JADX WARN: Multi-variable type inference failed */
        C04992(Ref.ObjectRef<Object> objectRef, Function3<? super S, ? super T, ? super Continuation<? super S>, ? extends Object> function3) {
            this.$accumulator = objectRef;
            this.$operation = function3;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(T t, Continuation<? super Unit> continuation) {
            FlowKt__ReduceKt$reduce$2$emit$1 flowKt__ReduceKt$reduce$2$emit$1;
            Ref.ObjectRef<Object> objectRef;
            Ref.ObjectRef<Object> objectRef2;
            if (continuation instanceof FlowKt__ReduceKt$reduce$2$emit$1) {
                flowKt__ReduceKt$reduce$2$emit$1 = (FlowKt__ReduceKt$reduce$2$emit$1) continuation;
                int i = flowKt__ReduceKt$reduce$2$emit$1.label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    flowKt__ReduceKt$reduce$2$emit$1.label = i - Integer.MIN_VALUE;
                } else {
                    flowKt__ReduceKt$reduce$2$emit$1 = new FlowKt__ReduceKt$reduce$2$emit$1(this, continuation);
                }
            } else {
                flowKt__ReduceKt$reduce$2$emit$1 = new FlowKt__ReduceKt$reduce$2$emit$1(this, continuation);
            }
            Object obj = flowKt__ReduceKt$reduce$2$emit$1.result;
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = flowKt__ReduceKt$reduce$2$emit$1.label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                objectRef = this.$accumulator;
                Object obj2 = objectRef.element;
                if (obj2 != NullSurrogateKt.NULL) {
                    Function3<S, T, Continuation<? super S>, Object> function3 = this.$operation;
                    flowKt__ReduceKt$reduce$2$emit$1.L$0 = objectRef;
                    flowKt__ReduceKt$reduce$2$emit$1.label = 1;
                    Object objInvoke = function3.invoke((S) obj2, t, flowKt__ReduceKt$reduce$2$emit$1);
                    if (objInvoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = objInvoke;
                    objectRef2 = objectRef;
                }
                objectRef.element = t;
                return Unit.INSTANCE;
            }
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objectRef2 = (Ref.ObjectRef) flowKt__ReduceKt$reduce$2$emit$1.L$0;
            ResultKt.throwOnFailure(obj);
            Object obj3 = obj;
            objectRef = objectRef2;
            t = (T) obj3;
            objectRef.element = t;
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, R> Object fold(@NotNull Flow<? extends T> flow, R r, @NotNull Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> function3, @NotNull Continuation<? super R> continuation) {
        C04931 c04931;
        Ref.ObjectRef objectRef;
        if (continuation instanceof C04931) {
            c04931 = (C04931) continuation;
            int i = c04931.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c04931.label = i - Integer.MIN_VALUE;
            } else {
                c04931 = new C04931(continuation);
            }
        } else {
            c04931 = new C04931(continuation);
        }
        Object obj = c04931.result;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c04931.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            objectRef2.element = r;
            FlowCollector<? super Object> anonymousClass2 = new AnonymousClass2<>(objectRef2, function3);
            c04931.L$0 = objectRef2;
            c04931.label = 1;
            if (flow.collect(anonymousClass2, c04931) == coroutine_suspended) {
                return coroutine_suspended;
            }
            objectRef = objectRef2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objectRef = (Ref.ObjectRef) c04931.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return objectRef.element;
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$2, reason: invalid class name */
    /* JADX INFO: loaded from: classes6.dex */
    public static final class AnonymousClass2<T> implements FlowCollector {
        final /* synthetic */ Ref.ObjectRef<R> $accumulator;
        final /* synthetic */ Function3<R, T, Continuation<? super R>, Object> $operation;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Ref.ObjectRef<R> objectRef, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> function3) {
            this.$accumulator = objectRef;
            this.$operation = function3;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(T t, Continuation<? super Unit> continuation) {
            FlowKt__ReduceKt$fold$2$emit$1 flowKt__ReduceKt$fold$2$emit$1;
            Ref.ObjectRef objectRef;
            if (continuation instanceof FlowKt__ReduceKt$fold$2$emit$1) {
                flowKt__ReduceKt$fold$2$emit$1 = (FlowKt__ReduceKt$fold$2$emit$1) continuation;
                int i = flowKt__ReduceKt$fold$2$emit$1.label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    flowKt__ReduceKt$fold$2$emit$1.label = i - Integer.MIN_VALUE;
                } else {
                    flowKt__ReduceKt$fold$2$emit$1 = new FlowKt__ReduceKt$fold$2$emit$1(this, continuation);
                }
            } else {
                flowKt__ReduceKt$fold$2$emit$1 = new FlowKt__ReduceKt$fold$2$emit$1(this, continuation);
            }
            Object obj = flowKt__ReduceKt$fold$2$emit$1.result;
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = flowKt__ReduceKt$fold$2$emit$1.label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                Ref.ObjectRef objectRef2 = this.$accumulator;
                Function3<R, T, Continuation<? super R>, Object> function3 = this.$operation;
                T t2 = objectRef2.element;
                flowKt__ReduceKt$fold$2$emit$1.L$0 = objectRef2;
                flowKt__ReduceKt$fold$2$emit$1.label = 1;
                Object objInvoke = function3.invoke((R) t2, t, flowKt__ReduceKt$fold$2$emit$1);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = (T) objInvoke;
                objectRef = objectRef2;
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                objectRef = (Ref.ObjectRef) flowKt__ReduceKt$fold$2$emit$1.L$0;
                ResultKt.throwOnFailure(obj);
            }
            objectRef.element = (T) obj;
            return Unit.INSTANCE;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public final Object emit$$forInline(T t, Continuation<? super Unit> continuation) {
            InlineMarker.mark(4);
            new FlowKt__ReduceKt$fold$2$emit$1(this, continuation);
            InlineMarker.mark(5);
            Ref.ObjectRef<R> objectRef = this.$accumulator;
            objectRef.element = (T) this.$operation.invoke((R) objectRef.element, t, (Continuation<? super R>) continuation);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T, R> Object fold$$forInline(Flow<? extends T> flow, R r, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> function3, Continuation<? super R> continuation) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = r;
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(objectRef, function3);
        InlineMarker.mark(0);
        flow.collect(anonymousClass2, continuation);
        InlineMarker.mark(1);
        return objectRef.element;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final <T> Object single(@NotNull Flow<? extends T> flow, @NotNull Continuation<? super T> continuation) {
        C05001 c05001;
        Ref.ObjectRef objectRef;
        if (continuation instanceof C05001) {
            c05001 = (C05001) continuation;
            int i = c05001.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c05001.label = i - Integer.MIN_VALUE;
            } else {
                c05001 = new C05001(continuation);
            }
        } else {
            c05001 = new C05001(continuation);
        }
        Object obj = c05001.result;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c05001.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            objectRef2.element = (T) NullSurrogateKt.NULL;
            FlowCollector<? super Object> flowCollector = new FlowCollector() { // from class: kotlinx.coroutines.flow.FlowKt__ReduceKt.single.2
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(T t, Continuation<? super Unit> continuation2) {
                    Ref.ObjectRef<Object> objectRef3 = objectRef2;
                    if (objectRef3.element != NullSurrogateKt.NULL) {
                        throw new IllegalArgumentException("Flow has more than one element");
                    }
                    objectRef3.element = t;
                    return Unit.INSTANCE;
                }
            };
            c05001.L$0 = objectRef2;
            c05001.label = 1;
            if (flow.collect(flowCollector, c05001) == coroutine_suspended) {
                return coroutine_suspended;
            }
            objectRef = objectRef2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objectRef = (Ref.ObjectRef) c05001.L$0;
            ResultKt.throwOnFailure(obj);
        }
        T t = objectRef.element;
        if (t != NullSurrogateKt.NULL) {
            return t;
        }
        throw new NoSuchElementException("Flow is empty");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final <T> Object singleOrNull(@NotNull Flow<? extends T> flow, @NotNull Continuation<? super T> continuation) {
        C05021 c05021;
        Ref.ObjectRef objectRef;
        AbortFlowException e;
        FlowCollector<T> flowCollector;
        if (continuation instanceof C05021) {
            c05021 = (C05021) continuation;
            int i = c05021.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c05021.label = i - Integer.MIN_VALUE;
            } else {
                c05021 = new C05021(continuation);
            }
        } else {
            c05021 = new C05021(continuation);
        }
        Object obj = c05021.result;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c05021.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            objectRef2.element = (T) NullSurrogateKt.NULL;
            FlowCollector<T> flowCollector2 = new FlowCollector<T>() { // from class: kotlinx.coroutines.flow.FlowKt__ReduceKt$singleOrNull$$inlined$collectWhile$1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public Object emit(T t, Continuation<? super Unit> continuation2) {
                    Ref.ObjectRef objectRef3 = objectRef2;
                    T t2 = objectRef3.element;
                    T t3 = (T) NullSurrogateKt.NULL;
                    if (t2 == t3) {
                        objectRef3.element = t;
                        return Unit.INSTANCE;
                    }
                    objectRef3.element = t3;
                    throw new AbortFlowException(this);
                }
            };
            try {
                c05021.L$0 = objectRef2;
                c05021.L$1 = flowCollector2;
                c05021.label = 1;
                if (flow.collect(flowCollector2, c05021) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                objectRef = objectRef2;
            } catch (AbortFlowException e2) {
                objectRef = objectRef2;
                e = e2;
                flowCollector = flowCollector2;
                FlowExceptions_commonKt.checkOwnership(e, flowCollector);
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            flowCollector = (FlowKt__ReduceKt$singleOrNull$$inlined$collectWhile$1) c05021.L$1;
            objectRef = (Ref.ObjectRef) c05021.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (AbortFlowException e3) {
                e = e3;
                FlowExceptions_commonKt.checkOwnership(e, flowCollector);
            }
        }
        T t = objectRef.element;
        if (t == NullSurrogateKt.NULL) {
            return null;
        }
        return t;
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0, 0}, l = {179}, m = "firstOrNull", n = {"result", "collector$iv"}, s = {"L$0", "L$1"})
    public static final class C04911<T> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        private static final byte[] $$a = {54, 81, -13, 100};
        private static final int $$b = 96;
        private static int $10 = 0;
        private static int $11 = 1;
        private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        private static int artificialFrame = 1;
        private static char[] IPostMessageService = {38275, 38380, 38383, 38355, 38363, 38355, 38348, 38354, 38353, 38345, 38380, 38392, 38356, 38347, 38353, 38388, 38380, 38377, 38285, 38287, 38288, 38396, 38393, 38285, 38287, 38399, 38366, 38354, 38356, 38359, 38361, 38355, 38359, 38361, 38356, 38362, 38356, 38356, 38305, 38272, 38376, 38358, 38356, 38351, 38355, 38361, 38397, 38285, 38379, 38364, 38356, 38353, 38390, 38274, 38393, 38272, 38376, 38358, 38356, 38351, 38355, 38361, 38391, 38280, 38399, 38390, 38379, 38388, 38391, 38360, 38260, 38265, 38147, 38265, 38255, 38261, 38261, 38258, 38260, 38148, 38146, 38261, 38263, 38285, 38361, 38355, 38351, 38356, 38358, 38360, 38358, 38356, 38361, 38363, 38360, 38360, 38376, 38374, 38361, 38363, 38361, 38360, 38365, 38375, 38272, 38386, 38353, 38384, 38382, 38350, 38358, 38355, 38350, 38353, 38358, 38391, 38204, 38066, 38064, 38062, 38057, 38061, 38067, 38224, 38225, 38064, 38059, 38056, 38061, 38064, 38056, 38216, 38218, 38059, 38220, 38234, 38209, 38071, 38066, 38067, 38069, 38067, 38210, 38078, 38063, 38063, 38388, 38189, 38191, 38192, 38174, 38381, 38175, 38180, 38179, 38185, 38194, 38337, 38207, 38184, 38186, 38194, 38190, 38189, 38189, 38182, 38177, 38185, 38336, 38364, 38339, 38177, 38185, 38192, 38348, 38337, 38174, 38182, 38183, 38177, 38184, 38192, 38184, 38340, 38349, 38185, 38185, 38191, 38197, 38057, 38050, 38042, 38076, 38218, 38215, 38235, 38233, 38223, 38073, 38050, 38042, 38047, 38054, 38054, 38055, 38059, 38051, 38049, 38054, 38056, 38050, 38050, 38214, 38077, 38049, 38057, 38049, 38042, 38048, 38047, 38039, 38074};
        private static long extraCommand = 3961597598399110772L;

        /* JADX WARN: Code duplicated, block: B:10:0x0023  */
        /* JADX WARN: Code duplicated, block: B:8:0x001d  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x002a). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static java.lang.String $$c(short r6, int r7, short r8) {
            /*
                int r7 = r7 * 3
                int r0 = 1 - r7
                int r8 = r8 + 65
                int r6 = r6 * 2
                int r6 = 4 - r6
                byte[] r1 = kotlinx.coroutines.flow.FlowKt__ReduceKt.C04911.$$a
                byte[] r0 = new byte[r0]
                r2 = 0
                int r7 = 0 - r7
                if (r1 != 0) goto L17
                r4 = r8
                r3 = r2
                r8 = r6
                goto L2a
            L17:
                r3 = r2
            L18:
                byte r4 = (byte) r8
                r0[r3] = r4
                if (r3 != r7) goto L23
                java.lang.String r6 = new java.lang.String
                r6.<init>(r0, r2)
                return r6
            L23:
                int r3 = r3 + 1
                r4 = r1[r6]
                r5 = r8
                r8 = r6
                r6 = r5
            L2a:
                int r6 = r6 + r4
                int r8 = r8 + 1
                r5 = r8
                r8 = r6
                r6 = r5
                goto L18
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ReduceKt.C04911.$$c(short, int, short):java.lang.String");
        }

        C04911(Continuation<? super C04911> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt.firstOrNull(null, this);
        }

        private static void b(int i, char[] cArr, Object[] objArr) throws Throwable {
            int i2 = 2 % 2;
            asBinder asbinder = new asBinder();
            asbinder.c = i;
            int length = cArr.length;
            long[] jArr = new long[length];
            asbinder.d = 0;
            while (asbinder.d < cArr.length) {
                int i3 = asbinder.d;
                try {
                    Object[] objArr2 = {Integer.valueOf(cArr[asbinder.d]), asbinder, asbinder};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1562553046);
                    if (objAccessartificialFrame == null) {
                        byte b = (byte) 0;
                        byte b2 = b;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 10, (char) Color.red(0), (KeyEvent.getMaxKeyCode() >> 16) + 1407, 1035473698, false, $$c(b, b2, (byte) (b2 | 53)), new Class[]{Integer.TYPE, Object.class, Object.class});
                    }
                    jArr[i3] = ((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue() ^ (extraCommand ^ (-2360974883025274865L));
                    Object[] objArr3 = {asbinder, asbinder};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1981632360);
                    if (objAccessartificialFrame2 == null) {
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation((-16777208) - Color.rgb(0, 0, 0), (char) KeyEvent.normalizeMetaState(0), 249 - (KeyEvent.getMaxKeyCode() >> 16), 378009232, false, "w", new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame2).invoke(null, objArr3);
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            char[] cArr2 = new char[length];
            asbinder.d = 0;
            while (asbinder.d < cArr.length) {
                int i4 = $11 + 89;
                $10 = i4 % 128;
                if (i4 % 2 != 0) {
                    cArr2[asbinder.d] = (char) jArr[asbinder.d];
                    Object[] objArr4 = {asbinder, asbinder};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1981632360);
                    if (objAccessartificialFrame3 == null) {
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(KeyEvent.keyCodeFromString("") + 8, (char) KeyEvent.keyCodeFromString(""), (KeyEvent.getMaxKeyCode() >> 16) + 249, 378009232, false, "w", new Class[]{Object.class, Object.class});
                    }
                    Object obj = null;
                    ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                    obj.hashCode();
                    throw null;
                }
                cArr2[asbinder.d] = (char) jArr[asbinder.d];
                try {
                    Object[] objArr5 = {asbinder, asbinder};
                    Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1981632360);
                    if (objAccessartificialFrame4 == null) {
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(9 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 1), (ViewConfiguration.getFadingEdgeLength() >> 16) + 249, 378009232, false, "w", new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame4).invoke(null, objArr5);
                } catch (Throwable th2) {
                    Throwable cause2 = th2.getCause();
                    if (cause2 == null) {
                        throw th2;
                    }
                    throw cause2;
                }
            }
            String str = new String(cArr2);
            int i5 = $11 + 119;
            $10 = i5 % 128;
            int i6 = i5 % 2;
            objArr[0] = str;
        }

        private static void a(byte[] bArr, int[] iArr, boolean z, Object[] objArr) throws Throwable {
            int i = 2;
            int i2 = 2 % 2;
            onPostMessage onpostmessage = new onPostMessage();
            int i3 = 0;
            int i4 = iArr[0];
            int i5 = 1;
            int i6 = iArr[1];
            int i7 = iArr[2];
            int i8 = iArr[3];
            char[] cArr = IPostMessageService;
            if (cArr != null) {
                int length = cArr.length;
                char[] cArr2 = new char[length];
                int i9 = 0;
                while (i9 < length) {
                    int i10 = $10 + 45;
                    $11 = i10 % 128;
                    int i11 = i10 % i;
                    try {
                        Object[] objArr2 = new Object[i5];
                        objArr2[i3] = Integer.valueOf(cArr[i9]);
                        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1782207618);
                        if (objAccessartificialFrame == null) {
                            byte b = (byte) i3;
                            byte b2 = b;
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(11 - (ViewConfiguration.getScrollBarSize() >> 8), (char) Color.alpha(i3), 1562 - (ViewConfiguration.getPressedStateDuration() >> 16), 178318710, false, $$c(b, b2, b2), new Class[]{Integer.TYPE});
                        }
                        cArr2[i9] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                        i9++;
                        i = 2;
                        i3 = 0;
                        i5 = 1;
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                }
                cArr = cArr2;
            }
            char[] cArr3 = new char[i6];
            System.arraycopy(cArr, i4, cArr3, 0, i6);
            if (bArr != null) {
                char[] cArr4 = new char[i6];
                onpostmessage.a = 0;
                char c = 0;
                while (onpostmessage.a < i6) {
                    if (bArr[onpostmessage.a] == 1) {
                        int i12 = $10 + 33;
                        $11 = i12 % 128;
                        int i13 = i12 % 2;
                        int i14 = onpostmessage.a;
                        try {
                            Object[] objArr3 = {Integer.valueOf(cArr3[onpostmessage.a]), Integer.valueOf(c)};
                            Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1378437083);
                            if (objAccessartificialFrame2 == null) {
                                byte b3 = (byte) 0;
                                byte b4 = b3;
                                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation((CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 23, (char) (ViewConfiguration.getTouchSlop() >> 8), 2441 - TextUtils.indexOf("", "", 0), -850656813, false, $$c(b3, b4, (byte) (b4 + 3)), new Class[]{Integer.TYPE, Integer.TYPE});
                            }
                            cArr4[i14] = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
                        } catch (Throwable th2) {
                            Throwable cause2 = th2.getCause();
                            if (cause2 == null) {
                                throw th2;
                            }
                            throw cause2;
                        }
                    } else {
                        int i15 = onpostmessage.a;
                        Object[] objArr4 = {Integer.valueOf(cArr3[onpostmessage.a]), Integer.valueOf(c)};
                        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-314759072);
                        if (objAccessartificialFrame3 == null) {
                            byte b5 = (byte) 0;
                            byte b6 = b5;
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(View.MeasureSpec.getMode(0) + 11, (char) View.MeasureSpec.makeMeasureSpec(0, 0), 1562 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), 1918398056, false, $$c(b5, b6, (byte) (b6 | 57)), new Class[]{Integer.TYPE, Integer.TYPE});
                        }
                        cArr4[i15] = ((Character) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).charValue();
                    }
                    c = cArr4[onpostmessage.a];
                    Object[] objArr5 = {onpostmessage, onpostmessage};
                    Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(898481158);
                    if (objAccessartificialFrame4 == null) {
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(21 - Process.getGidForName(""), (char) (29363 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1))), KeyEvent.keyCodeFromString("") + JfifUtil.MARKER_RST7, -1427572210, false, "F", new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame4).invoke(null, objArr5);
                }
                cArr3 = cArr4;
            }
            if (i8 > 0) {
                char[] cArr5 = new char[i6];
                System.arraycopy(cArr3, 0, cArr5, 0, i6);
                int i16 = i6 - i8;
                System.arraycopy(cArr5, 0, cArr3, i16, i8);
                System.arraycopy(cArr5, i8, cArr3, 0, i16);
            }
            if (!(!z)) {
                int i17 = $10 + 107;
                $11 = i17 % 128;
                int i18 = i17 % 2;
                char[] cArr6 = new char[i6];
                onpostmessage.a = 0;
                int i19 = $11 + 59;
                $10 = i19 % 128;
                if (i19 % 2 != 0) {
                    int i20 = 2 % 5;
                }
                while (onpostmessage.a < i6) {
                    cArr6[onpostmessage.a] = cArr3[(i6 - onpostmessage.a) - 1];
                    onpostmessage.a++;
                }
                cArr3 = cArr6;
            }
            if (i7 > 0) {
                onpostmessage.a = 0;
                while (onpostmessage.a < i6) {
                    cArr3[onpostmessage.a] = (char) (cArr3[onpostmessage.a] - iArr[2]);
                    onpostmessage.a++;
                    int i21 = $11 + 97;
                    $10 = i21 % 128;
                    int i22 = i21 % 2;
                }
            }
            objArr[0] = new String(cArr3);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r12v0 */
        /* JADX WARN: Type inference failed for: r12v20 */
        public static Object[] accessartificialFrame(Context context, int i, int i2) {
            Object[] objArr;
            int i3;
            int i4;
            Class<?> cls;
            int iLastIndexOf;
            Object objInvoke;
            Class<?> cls2;
            int iIndexOf;
            Class<?> cls3;
            int i5;
            Object obj;
            Method method;
            int i6;
            int i7;
            int i8;
            int i9;
            int i10;
            int i11 = 2;
            int i12 = 2 % 2;
            int i13 = 1;
            if (context == null) {
                int i14 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                int i15 = (i14 ^ 113) + ((i14 & 113) << 1);
                artificialFrame = i15 % 128;
                if (i15 % 2 == 0) {
                    objArr = new Object[4];
                    objArr[1] = new int[0];
                    objArr[1] = new int[1];
                    objArr[5] = new int[1];
                } else {
                    objArr = new Object[4];
                    objArr[0] = new int[1];
                    objArr[1] = new int[1];
                    objArr[2] = new int[1];
                }
                ((int[]) objArr[0])[0] = i;
                ((int[]) objArr[1])[0] = i;
                int i16 = i14 + 39;
                artificialFrame = i16 % 128;
                if (i16 % 2 == 0) {
                    objArr[3] = null;
                    int i17 = (~i) | 36606292;
                    i9 = (-254266291) + (i17 * 495) + (((~i17) | 2490688) * 495);
                    i10 = TypedValues.Custom.TYPE_DIMENSION;
                } else {
                    objArr[3] = null;
                    int i18 = (-7478402) + (((~(276969249 | i)) | 701654525) * 672);
                    int i19 = ~i;
                    i9 = i18 + (((~(701654525 | i)) | (~((-276969250) | i19))) * (-672)) + (((~(i19 | (-701654526))) | 693125340) * 672);
                    i10 = 0;
                }
                int i20 = (i10 - (~(i9 * (-903)))) - 1;
                int i21 = ~(((-1) ^ i) | i);
                int i22 = ~i;
                int i23 = -(-((i21 | (~((i22 & i9) | (i22 ^ i9)))) * (-1808)));
                int i24 = (i20 ^ i23) + ((i20 & i23) << 1);
                int i25 = ~i9;
                int i26 = i25 | ((-1) ^ i25);
                int i27 = ~((i26 & i) | (i26 ^ i));
                int i28 = ~i;
                int i29 = ~((i28 ^ i9) | (i28 & i9));
                int i30 = -(-(((i27 & i29) | (i27 ^ i29)) * TypedValues.Custom.TYPE_BOOLEAN));
                int i31 = (i24 & i30) + (i30 | i24);
                int i32 = ~(((-1) ^ i9) | i9);
                int i33 = ~(i | (~i9));
                int i34 = (i32 & i33) | (i32 ^ i33);
                int i35 = ~i28;
                int i36 = i31 + (((i34 & i35) | (i34 ^ i35)) * TypedValues.Custom.TYPE_BOOLEAN);
                int iOnExtraCallback = KeysetHandle$$ExternalSyntheticLambda0.onExtraCallback();
                int i37 = ~i2;
                int i38 = ~iOnExtraCallback;
                int i39 = (i38 & i37) | (i37 ^ i38);
                int i40 = (i37 & i36) | (i37 ^ i36);
                int i41 = ((((i36 * (-129)) + (i2 * 131)) - (~((~((i39 & i36) | (i39 ^ i36))) * 130))) - 1) + ((~i40) * (-260));
                int i42 = ~i36;
                int i43 = ~((i2 & i42) | (i42 ^ i2));
                int i44 = ~((iOnExtraCallback & i40) | (i40 ^ iOnExtraCallback));
                int i45 = (i44 & i43) | (i43 ^ i44);
                int i46 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                int i47 = ((i46 | 33) << 1) - (i46 ^ 33);
                artificialFrame = i47 % 128;
                int i48 = i47 % 2;
                int i49 = -(-(130 * i45));
                int i50 = (i41 ^ i49) + ((i49 & i41) << 1);
                int i51 = (i50 << 13) ^ i50;
                int i52 = i51 >>> 17;
                int i53 = ((~i51) & i52) | ((~i52) & i51);
                int i54 = i53 << 5;
                ((int[]) objArr[2])[0] = (i53 | i54) & (~(i53 & i54));
            } else {
                try {
                    Object[] objArr2 = new Object[1];
                    a(new byte[]{0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1}, new int[]{0, 38, 0, 34}, false, objArr2);
                    Object[] objArr3 = (Object[]) Array.newInstance(Class.forName((String) objArr2[0]), 2);
                    Object[] objArr4 = new Object[1];
                    a(new byte[]{1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1}, new int[]{38, 31, 0, 29}, false, objArr4);
                    String str = (String) objArr4[0];
                    int i55 = artificialFrame;
                    int i56 = ((i55 | 35) << 1) - (i55 ^ 35);
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i56 % 128;
                    int i57 = i56 % 2;
                    try {
                        Object[] objArr5 = {str};
                        Object[] objArr6 = new Object[1];
                        a(new byte[]{0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1}, new int[]{0, 38, 0, 34}, false, objArr6);
                        Class<?> cls4 = Class.forName((String) objArr6[0]);
                        int i58 = getARTIFICIAL_FRAME_PACKAGE_NAME + 17;
                        artificialFrame = i58 % 128;
                        objArr3[0] = (i58 % 2 == 0 ? cls4.getDeclaredConstructor(String.class) : cls4.getDeclaredConstructor(String.class)).newInstance(objArr5);
                        int packedPositionType = ExpandableListView.getPackedPositionType(0L);
                        int iOnExtraCallback2 = KeysetHandle$$ExternalSyntheticLambda0.onExtraCallback();
                        int i59 = getARTIFICIAL_FRAME_PACKAGE_NAME + 83;
                        int i60 = i59 % 128;
                        artificialFrame = i60;
                        if (i59 % 2 == 0) {
                            int i61 = -packedPositionType;
                            i3 = (((i61 | 881) << 1) - (i61 ^ 881)) - 35284;
                        } else {
                            int i62 = packedPositionType * 881;
                            i3 = (i62 ^ 30309043) + ((i62 & 30309043) << 1);
                        }
                        int i63 = ~packedPositionType;
                        int i64 = ~((i63 ^ (-34404)) | (i63 & (-34404)));
                        int i65 = ~((i63 ^ iOnExtraCallback2) | (i63 & iOnExtraCallback2));
                        int i66 = (i64 ^ i65) | (i65 & i64);
                        int i67 = i60 + 113;
                        int i68 = i67 % 128;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i68;
                        int i69 = i67 % 2;
                        int i70 = ~(((-34404) ^ iOnExtraCallback2) | ((-34404) & iOnExtraCallback2));
                        int i71 = (-880) * ((i66 ^ i70) | (i70 & i66));
                        int i72 = (i3 ^ i71) + ((i71 & i3) << 1);
                        int i73 = (i68 ^ 53) + ((i68 & 53) << 1);
                        artificialFrame = i73 % 128;
                        if (i73 % 2 == 0) {
                            int i74 = ~iOnExtraCallback2;
                            int i75 = ~((i63 ^ i74) | (i63 & i74));
                            int i76 = (i75 & 34403) | (i75 ^ 34403);
                            int i77 = ~((packedPositionType ^ iOnExtraCallback2) | (packedPositionType & iOnExtraCallback2));
                            i4 = i72 / ((-880) << ((i76 & i77) | (i76 ^ i77)));
                        } else {
                            int i78 = ~(i63 | (~iOnExtraCallback2));
                            int i79 = (i78 & 34403) | (i78 ^ 34403);
                            int i80 = ~((packedPositionType ^ iOnExtraCallback2) | (packedPositionType & iOnExtraCallback2));
                            int i81 = ((i79 & i80) | (i79 ^ i80)) * (-880);
                            i4 = ((i72 | i81) << 1) - (i81 ^ i72);
                        }
                        Object[] objArr7 = new Object[1];
                        b(i4 + (880 * (~((packedPositionType & iOnExtraCallback2) | (packedPositionType ^ iOnExtraCallback2)))), new char[]{9784, 40997, 10984, 46337, 16347, 47579, 20, 35471, 5389, 40804, 6615, 57429, 27318, 62744, 32573, 63989, 16389, 51925, 21708, 57164, 22947, 8214, 43670, 13559, 48983, 14832, 32817, 2671, 38093, 7993, 39302}, objArr7);
                        try {
                            Object[] objArr8 = {(String) objArr7[0]};
                            Object[] objArr9 = new Object[1];
                            a(new byte[]{0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1}, new int[]{0, 38, 0, 34}, false, objArr9);
                            objArr3[1] = Class.forName((String) objArr9[0]).getDeclaredConstructor(String.class).newInstance(objArr8);
                            try {
                                int i82 = -KeyEvent.keyCodeFromString("");
                                Object[] objArr10 = new Object[1];
                                b((i82 & 1171) + (i82 | 1171), new char[]{9754, 8838, 12089, 11184, 13400, 12493, 15725, 1616, 640, 3903, 2987, 5214, 4346, 7522, 26117, 25288, 28424, 27607, 29763, 28902, 32098, 17932, 17069}, objArr10);
                                String str2 = (String) objArr10[0];
                                int i83 = artificialFrame;
                                int i84 = ((i83 | 11) << 1) - (i83 ^ 11);
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i84 % 128;
                                if (i84 % 2 != 0) {
                                    cls = Class.forName(str2);
                                    iLastIndexOf = TextUtils.lastIndexOf("", '?', 0, 0);
                                } else {
                                    cls = Class.forName(str2);
                                    iLastIndexOf = TextUtils.lastIndexOf("", '0', 0, 0);
                                }
                                Object[] objArr11 = new Object[1];
                                b(43499 - (~iLastIndexOf), new char[]{9756, 36853, 30169, 56298, 33206, 30607, 56722, 33655, 26948, 57181, 34072, 27395, 53521, 34549, 27846, 53979, 47289}, objArr11);
                                Object objInvoke2 = cls.getMethod((String) objArr11[0], null).invoke(context, null);
                                int i85 = artificialFrame;
                                int i86 = (i85 & 29) + (i85 | 29);
                                int i87 = i86 % 128;
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i87;
                                int i88 = i86 % 2;
                                int i89 = (i87 ^ AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY) + ((i87 & AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY) << 1);
                                artificialFrame = i89 % 128;
                                int i90 = i89 % 2;
                                try {
                                    Object[] objArr12 = new Object[1];
                                    b(1170 - (~(-(-View.MeasureSpec.getMode(0)))), new char[]{9754, 8838, 12089, 11184, 13400, 12493, 15725, 1616, 640, 3903, 2987, 5214, 4346, 7522, 26117, 25288, 28424, 27607, 29763, 28902, 32098, 17932, 17069}, objArr12);
                                    Class<?> cls5 = Class.forName((String) objArr12[0]);
                                    Object[] objArr13 = new Object[1];
                                    a(new byte[]{1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0}, new int[]{69, 14, 100, 7}, true, objArr13);
                                    Object objInvoke3 = cls5.getMethod((String) objArr13[0], null).invoke(context, null);
                                    int i91 = artificialFrame;
                                    int i92 = (i91 & 77) + (i91 | 77);
                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i92 % 128;
                                    int i93 = i92 % 2;
                                    try {
                                        Object[] objArr14 = {objInvoke3, 64};
                                        Object[] objArr15 = new Object[1];
                                        a(new byte[]{0, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1}, new int[]{83, 33, 0, 7}, true, objArr15);
                                        Class<?> cls6 = Class.forName((String) objArr15[0]);
                                        int i94 = (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                                        int iOnExtraCallback3 = KeysetHandle$$ExternalSyntheticLambda0.onExtraCallback();
                                        int i95 = i94 * (-523);
                                        int i96 = ((i95 | 1415203) << 1) - (i95 ^ 1415203);
                                        int i97 = ~i94;
                                        int i98 = ~((i97 & 5381) | (i97 ^ 5381));
                                        int i99 = ~(((-5382) ^ i94) | ((-5382) & i94));
                                        int i100 = (i98 ^ i99) | (i98 & i99);
                                        int i101 = ~(((-5382) ^ iOnExtraCallback3) | ((-5382) & iOnExtraCallback3));
                                        int i102 = ((i96 + (((i100 ^ i101) | (i101 & i100)) * 262)) - (~(i99 * (-786)))) - 1;
                                        int i103 = ~((~iOnExtraCallback3) | (-5382));
                                        int i104 = ~i94;
                                        int i105 = ~((i104 & 5381) | (i104 ^ 5381));
                                        int i106 = (i103 & i105) | (i103 ^ i105);
                                        int i107 = ~((i94 & (-5382)) | ((-5382) ^ i94));
                                        int i108 = artificialFrame;
                                        int i109 = (i108 & 7) + (i108 | 7);
                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i109 % 128;
                                        int i110 = i109 % 2;
                                        int i111 = 262 * ((i107 & i106) | (i106 ^ i107));
                                        Object[] objArr16 = new Object[1];
                                        b((i102 & i111) + (i111 | i102), new char[]{9756, 13083, 3077, 6436, 29198, 20225, 22542, 46393, 36404, 39731, 62464, 49442, 55841, 14165}, objArr16);
                                        Method method2 = cls6.getMethod((String) objArr16[0], String.class, Integer.TYPE);
                                        int i112 = artificialFrame;
                                        int i113 = ((i112 | 17) << 1) - (i112 ^ 17);
                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i113 % 128;
                                        if (i113 % 2 != 0) {
                                            objInvoke = method2.invoke(objInvoke2, objArr14);
                                            Object[] objArr17 = new Object[1];
                                            a(new byte[]{1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1}, new int[]{116, 30, 166, 0}, true, objArr17);
                                            cls2 = Class.forName((String) objArr17[0]);
                                            iIndexOf = 20037 / TextUtils.indexOf("", "", 0, 0);
                                        } else {
                                            objInvoke = method2.invoke(objInvoke2, objArr14);
                                            Object[] objArr18 = new Object[1];
                                            a(new byte[]{1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1}, new int[]{116, 30, 166, 0}, false, objArr18);
                                            cls2 = Class.forName((String) objArr18[0]);
                                            iIndexOf = 18839 - TextUtils.indexOf("", "", 0, 0);
                                        }
                                        Object[] objArr19 = new Object[1];
                                        b(iIndexOf, new char[]{9736, 28549, 46386, 64208, 'F', 18940, 40836, 9512, 27302, 45127}, objArr19);
                                        Object[] objArr20 = (Object[]) cls2.getField((String) objArr19[0]).get(objInvoke);
                                        int length = objArr20.length;
                                        int i114 = 0;
                                        while (i114 < length) {
                                            Object obj2 = objArr20[i114];
                                            Object[] objArr21 = new Object[i13];
                                            a(new byte[]{1, 1, 1, 1, 0}, new int[]{146, 5, 94, 0}, i13, objArr21);
                                            try {
                                                Object[] objArr22 = {(String) objArr21[0]};
                                                byte[] bArr = {0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1};
                                                int i115 = artificialFrame + 81;
                                                getARTIFICIAL_FRAME_PACKAGE_NAME = i115 % 128;
                                                if (i115 % i11 != 0) {
                                                    Object[] objArr23 = new Object[i13];
                                                    a(bArr, new int[]{151, 37, 43, 0}, false, objArr23);
                                                    cls3 = Class.forName((String) objArr23[0]);
                                                    i5 = 2846;
                                                } else {
                                                    Object[] objArr24 = new Object[i13];
                                                    a(bArr, new int[]{151, 37, 43, 0}, i13, objArr24);
                                                    cls3 = Class.forName((String) objArr24[0]);
                                                    i5 = 26687;
                                                }
                                                int i116 = getARTIFICIAL_FRAME_PACKAGE_NAME + 123;
                                                artificialFrame = i116 % 128;
                                                if (i116 % i11 == 0) {
                                                    Object[] objArr25 = new Object[i13];
                                                    b(i5 * (ViewConfiguration.getMaximumDrawingCacheSize() >> 45), new char[]{9756, 20001, 63089, 7823, 34537, 12083, 22389, 65443, 26605, 35887, 13416}, objArr25);
                                                    obj = objArr25[0];
                                                } else {
                                                    Object[] objArr26 = new Object[i13];
                                                    b(i5 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), new char[]{9756, 20001, 63089, 7823, 34537, 12083, 22389, 65443, 26605, 35887, 13416}, objArr26);
                                                    obj = objArr26[0];
                                                }
                                                String str3 = (String) obj;
                                                int i117 = artificialFrame;
                                                int i118 = (i117 & 61) + (i117 | 61);
                                                getARTIFICIAL_FRAME_PACKAGE_NAME = i118 % 128;
                                                if (i118 % i11 != 0) {
                                                    Class<?>[] clsArr = new Class[0];
                                                    clsArr[0] = String.class;
                                                    method = cls3.getMethod(str3, clsArr);
                                                } else {
                                                    Class<?>[] clsArr2 = new Class[i13];
                                                    clsArr2[0] = String.class;
                                                    method = cls3.getMethod(str3, clsArr2);
                                                }
                                                Object objInvoke4 = method.invoke(null, objArr22);
                                                try {
                                                    int doubleTapTimeout = ViewConfiguration.getDoubleTapTimeout() >> 16;
                                                    int i119 = doubleTapTimeout * 868;
                                                    int i120 = (i119 & 47881484) + (i119 | 47881484);
                                                    int i121 = ~doubleTapTimeout;
                                                    int i122 = ~i;
                                                    int i123 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                    int i124 = (i123 & 79) + (i123 | 79);
                                                    Object[] objArr27 = objArr20;
                                                    artificialFrame = i124 % 128;
                                                    int i125 = i124 % i11;
                                                    int i126 = ~((i121 ^ i122) | (i121 & i122));
                                                    if (i125 == 0) {
                                                        int i127 = (-867) >>> (i126 | (~(((-55164) ^ i122) | ((-55164) & i122))));
                                                        i6 = ((i120 | i127) << 1) - (i120 ^ i127);
                                                        i7 = ~doubleTapTimeout;
                                                    } else {
                                                        i6 = i120 + ((i126 | (~(((-55164) ^ i122) | ((-55164) & i122)))) * (-867));
                                                        i7 = i121;
                                                    }
                                                    int i128 = ~((i7 & (-55164)) | (i7 ^ (-55164)));
                                                    int i129 = ~((i121 ^ i) | (i121 & i));
                                                    int i130 = (i128 ^ i129) | (i128 & i129);
                                                    int i131 = ((i123 | 11) << 1) - (i123 ^ 11);
                                                    int i132 = length;
                                                    int i133 = i131 % 128;
                                                    artificialFrame = i133;
                                                    int i134 = i131 % 2;
                                                    int i135 = ((-55164) | i) ^ (-1);
                                                    int i136 = (-1734) * ((i135 & i130) | (i130 ^ i135));
                                                    int i137 = (i6 ^ i136) + ((i136 & i6) << 1);
                                                    int i138 = (i121 ^ (-55164)) | (i121 & (-55164));
                                                    int i139 = ~((i138 & i122) | (i138 ^ i122));
                                                    int i140 = i133 + 49;
                                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i140 % 128;
                                                    int i141 = i140 % 2;
                                                    int i142 = ~doubleTapTimeout;
                                                    int i143 = (i142 & 55163) | (i142 ^ 55163);
                                                    int i144 = ~((i143 & i) | (i143 ^ i));
                                                    int i145 = (i139 & i144) | (i139 ^ i144);
                                                    int i146 = (-55164) | doubleTapTimeout;
                                                    int i147 = ~((i146 & i) | (i146 ^ i));
                                                    int i148 = ((i145 & i147) | (i145 ^ i147)) * 867;
                                                    Object[] objArr28 = new Object[1];
                                                    b((i137 ^ i148) + ((i137 & i148) << 1), new char[]{9754, 61806, 35049, 41080, 31736, 4981, 11005, 49672, 40384, 46407, 19675, 25670, 16346, 55082, 61109, 34400, 20923, 26941, 243, 55305, 62350, 35595, 41607, 31255, 5511, 11533, 50295, 40935}, objArr28);
                                                    Class<?> cls7 = Class.forName((String) objArr28[0]);
                                                    Object[] objArr29 = new Object[1];
                                                    b(49522 - (~(-KeyEvent.keyCodeFromString(""))), new char[]{9743, 59239, 42207, 25179, 9155, 57633, 44680, 27692, 11665, 60177, 43132}, objArr29);
                                                    try {
                                                        Object[] objArr30 = {new ByteArrayInputStream((byte[]) cls7.getMethod((String) objArr29[0], null).invoke(obj2, null))};
                                                        Object[] objArr31 = new Object[1];
                                                        a(new byte[]{0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1}, new int[]{151, 37, 43, 0}, true, objArr31);
                                                        Class<?> cls8 = Class.forName((String) objArr31[0]);
                                                        Object[] objArr32 = new Object[1];
                                                        b(25470 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), new char[]{9756, 17763, 57583, 3177, 44029, 55147, 29409, 40565, 15824, 22907, 50411, 24656, 36814, 11076, 22212, 62027, 4554, 48450, 55508}, objArr32);
                                                        Object objInvoke5 = cls8.getMethod((String) objArr32[0], InputStream.class).invoke(objInvoke4, objArr30);
                                                        int length2 = objArr3.length;
                                                        int i149 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                        int i150 = (i149 & 89) + (i149 | 89);
                                                        artificialFrame = i150 % 128;
                                                        int i151 = i150 % 2;
                                                        int i152 = 0;
                                                        for (int i153 = 2; i152 < i153; i153 = 2) {
                                                            int i154 = artificialFrame;
                                                            int i155 = (i154 & 1) + (i154 | 1);
                                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i155 % 128;
                                                            int i156 = i155 % i153;
                                                            Object obj3 = objArr3[i152];
                                                            try {
                                                                Object[] objArr33 = new Object[1];
                                                                a(new byte[]{1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1}, new int[]{188, 34, 178, 20}, false, objArr33);
                                                                Class<?> cls9 = Class.forName((String) objArr33[0]);
                                                                int i157 = -TextUtils.indexOf((CharSequence) "", '0', 0, 0);
                                                                int i158 = i157 * 273;
                                                                int i159 = (i158 & (-6962532)) + (i158 | (-6962532));
                                                                int i160 = ~i157;
                                                                int i161 = (i160 ^ (-25693)) | (i160 & (-25693));
                                                                int i162 = ~i;
                                                                int i163 = ~((i161 ^ i162) | (i161 & i162));
                                                                int i164 = ~((i157 ^ 25692) | (i157 & 25692) | i);
                                                                int i165 = (i159 - (~(-(-(((i164 & i163) | (i163 ^ i164)) * (-272)))))) - 1;
                                                                int i166 = ~i157;
                                                                int i167 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                                int i168 = (i167 & 79) + (i167 | 79);
                                                                artificialFrame = i168 % 128;
                                                                if (i168 % 2 == 0) {
                                                                    int i169 = ~((i166 & 25692) | (i166 ^ 25692));
                                                                    int i170 = ~(i160 | i);
                                                                    i8 = i165 % ((-272) << ((i169 & i170) | (i169 ^ i170)));
                                                                } else {
                                                                    int i171 = ~((i166 & 25692) | (i166 ^ 25692));
                                                                    int i172 = ~((i160 & i) | (i160 ^ i));
                                                                    i8 = i165 + (((i171 & i172) | (i171 ^ i172)) * (-272));
                                                                }
                                                                int i173 = ~((i157 ^ i) | (i157 & i));
                                                                Object[] objArr34 = new Object[1];
                                                                b(i8 + (272 * ((i173 & 25692) | (i173 ^ 25692))), new char[]{9756, 16963, 61109, 2879, 46970, 54216, 31807, 39061, 1264, 41290, 52609, 27057, 37399, 16114, 23357, 51066, 25538, 35896, 10386, 21749, 61775, 7611, 47593}, objArr34);
                                                                if (!(!obj3.equals(cls9.getMethod((String) objArr34[0], null).invoke(objInvoke5, null)))) {
                                                                    Object[] objArr35 = {new int[]{i}, new int[]{i ^ 1}, new int[]{((~i) & i) | ((~i) & i)}, null};
                                                                    int i174 = (-1228291784) + (((~((-560508860) | i162)) | (~((-418114916) | i))) * 210) + (((~((-411254849) | i162)) | (~((-553648793) | i))) * 210);
                                                                    int i175 = (i2 - (~(((i174 | 16) << 1) - (i174 ^ 16)))) - 1;
                                                                    int i176 = i175 ^ (i175 << 13);
                                                                    int i177 = i176 >>> 17;
                                                                    int i178 = (i176 | i177) & (~(i176 & i177));
                                                                    int i179 = i178 << 5;
                                                                    objArr = objArr35;
                                                                } else {
                                                                    i152 = (i152 & 1) + (i152 | 1);
                                                                }
                                                            } catch (Throwable th) {
                                                                Throwable cause = th.getCause();
                                                                if (cause != null) {
                                                                    throw cause;
                                                                }
                                                                throw th;
                                                            }
                                                        }
                                                        i114 = (i114 & 1) + (i114 | 1);
                                                        length = i132;
                                                        objArr20 = objArr27;
                                                        i11 = 2;
                                                        i13 = 1;
                                                    } catch (Throwable th2) {
                                                        Throwable cause2 = th2.getCause();
                                                        if (cause2 != null) {
                                                            throw cause2;
                                                        }
                                                        throw th2;
                                                    }
                                                } catch (Throwable th3) {
                                                    Throwable cause3 = th3.getCause();
                                                    if (cause3 != null) {
                                                        throw cause3;
                                                    }
                                                    throw th3;
                                                }
                                            } catch (Throwable th4) {
                                                Throwable cause4 = th4.getCause();
                                                if (cause4 != null) {
                                                    throw cause4;
                                                }
                                                throw th4;
                                            }
                                        }
                                    } catch (Throwable th5) {
                                        Throwable cause5 = th5.getCause();
                                        if (cause5 != null) {
                                            throw cause5;
                                        }
                                        throw th5;
                                    }
                                } catch (Throwable th6) {
                                    Throwable cause6 = th6.getCause();
                                    if (cause6 != null) {
                                        throw cause6;
                                    }
                                    throw th6;
                                }
                            } catch (Throwable th7) {
                                Throwable cause7 = th7.getCause();
                                if (cause7 != null) {
                                    throw cause7;
                                }
                                throw th7;
                            }
                        } catch (Throwable th8) {
                            Throwable cause8 = th8.getCause();
                            if (cause8 != null) {
                                throw cause8;
                            }
                            throw th8;
                        }
                    } catch (Throwable th9) {
                        Throwable cause9 = th9.getCause();
                        if (cause9 != null) {
                            throw cause9;
                        }
                        throw th9;
                    }
                } catch (Throwable unused) {
                }
                objArr = new Object[]{new int[]{i}, new int[]{i}, new int[]{((~i) & i) | ((~i) & i)}, null};
                int i180 = ~i;
                int i181 = (((-1123613338) + (((-39862274) | i180) * (-490))) + (((~((-66342918) | i)) | 26480644) * 490)) - 341021636;
                int i182 = ~i181;
                int i183 = ~(((-1) ^ i182) | i182);
                int i184 = ~(((-1) ^ i180) | i180);
                int i185 = (i184 & i183) | (i183 ^ i184);
                int i186 = ~((i182 ^ i180) | (i182 & i180));
                int i187 = (i185 & i186) | (i185 ^ i186);
                int i188 = ~((i181 ^ i) | (i181 & i));
                int i189 = ((i181 * 85) - (~(((i187 & i188) | (i187 ^ i188)) * (-84)))) - 1;
                int i190 = ~((i182 & i) | (i182 ^ i));
                int i191 = ~i;
                int i192 = ~((i191 & i181) | (i191 ^ i181));
                int i193 = -(-(((i190 & i192) | (i190 ^ i192)) * (-84)));
                int i194 = (i189 & i193) + (i189 | i193);
                int i195 = ~((i180 ^ i181) | (i180 & i181));
                int i196 = ~i181;
                int i197 = ((i195 & i196) | (i195 ^ i196)) * 84;
                int i198 = ((i194 | i197) << 1) - (i197 ^ i194);
                int i199 = ((i198 * (-743)) - (~(i2 * (-743)))) - 1;
                int i200 = (i198 ^ i2) | (i198 & i2);
                int i201 = ~i200;
                int i202 = artificialFrame;
                int i203 = ((i202 | 71) << 1) - (i202 ^ 71);
                getARTIFICIAL_FRAME_PACKAGE_NAME = i203 % 128;
                int i204 = i203 % 2;
                int i205 = ~((i198 ^ i) | (i198 & i));
                int i206 = (i205 & i201) | (i201 ^ i205);
                int i207 = ~((i2 ^ i) | (i2 & i));
                int i208 = (i199 - (~((-744) * ((i206 & i207) | (i206 ^ i207))))) - 1;
                int i209 = ~i198;
                int i210 = ~i2;
                int i211 = ~((i210 & i209) | (i209 ^ i210));
                int i212 = -(-(((i180 & i211) | (i180 ^ i211)) * 744));
                int i213 = (i208 ^ i212) + ((i212 & i208) << 1);
                int i214 = -(-(((i200 ^ i) | (i & i200)) * 744));
                int i215 = ((i213 | i214) << 1) - (i214 ^ i213);
                int i216 = i215 << 13;
                int i217 = (i216 | i215) & (~(i215 & i216));
                int i218 = i217 ^ (i217 >>> 17);
                int i219 = i218 << 5;
            }
            int i220 = artificialFrame + 45;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i220 % 128;
            int i221 = i220 % 2;
            return objArr;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final <T> Object first(@NotNull Flow<? extends T> flow, @NotNull Continuation<? super T> continuation) {
        AnonymousClass1 anonymousClass1;
        Ref.ObjectRef objectRef;
        AbortFlowException e;
        FlowCollector<T> flowCollector;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            objectRef2.element = (T) NullSurrogateKt.NULL;
            FlowCollector<T> flowCollector2 = new FlowCollector<T>() { // from class: kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public Object emit(T t, Continuation<? super Unit> continuation2) {
                    objectRef2.element = t;
                    throw new AbortFlowException(this);
                }
            };
            try {
                anonymousClass1.L$0 = objectRef2;
                anonymousClass1.L$1 = flowCollector2;
                anonymousClass1.label = 1;
                if (flow.collect(flowCollector2, anonymousClass1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                objectRef = objectRef2;
            } catch (AbortFlowException e2) {
                objectRef = objectRef2;
                e = e2;
                flowCollector = flowCollector2;
                FlowExceptions_commonKt.checkOwnership(e, flowCollector);
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            flowCollector = (FlowKt__ReduceKt$first$$inlined$collectWhile$1) anonymousClass1.L$1;
            objectRef = (Ref.ObjectRef) anonymousClass1.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (AbortFlowException e3) {
                e = e3;
                FlowExceptions_commonKt.checkOwnership(e, flowCollector);
            }
        }
        T t = objectRef.element;
        if (t != NullSurrogateKt.NULL) {
            return t;
        }
        throw new NoSuchElementException("Expected at least one element");
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0071 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:29:0x0072  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Instruction removed from duplicated block: B:29:0x0072, please report this as an issue */
    public static final <T> Object first(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
        AnonymousClass3 anonymousClass3;
        Ref.ObjectRef objectRef;
        AbortFlowException abortFlowException;
        FlowCollector<? super Object> flowCollector;
        Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function3;
        Ref.ObjectRef objectRef2;
        T t;
        if (continuation instanceof AnonymousClass3) {
            anonymousClass3 = (AnonymousClass3) continuation;
            int i = anonymousClass3.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass3.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass3 = new AnonymousClass3(continuation);
            }
        } else {
            anonymousClass3 = new AnonymousClass3(continuation);
        }
        Object obj = anonymousClass3.result;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass3.label;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            flowCollector = (FlowKt__ReduceKt$first$$inlined$collectWhile$2) anonymousClass3.L$2;
            objectRef2 = (Ref.ObjectRef) anonymousClass3.L$1;
            function3 = (Function2) anonymousClass3.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (AbortFlowException e) {
                objectRef = objectRef2;
                function2 = function3;
                abortFlowException = e;
                FlowExceptions_commonKt.checkOwnership(abortFlowException, flowCollector);
                function3 = function2;
                objectRef2 = objectRef;
            }
            t = objectRef2.element;
            if (t != NullSurrogateKt.NULL) {
                return t;
            }
            throw new NoSuchElementException("Expected at least one element matching the predicate " + function3);
        }
        ResultKt.throwOnFailure(obj);
        objectRef = new Ref.ObjectRef();
        objectRef.element = (T) NullSurrogateKt.NULL;
        FlowCollector<? super Object> flowKt__ReduceKt$first$$inlined$collectWhile$2 = new FlowKt__ReduceKt$first$$inlined$collectWhile$2<>(function2, objectRef);
        try {
            anonymousClass3.L$0 = function2;
            anonymousClass3.L$1 = objectRef;
            anonymousClass3.L$2 = flowKt__ReduceKt$first$$inlined$collectWhile$2;
            anonymousClass3.label = 1;
            if (flow.collect(flowKt__ReduceKt$first$$inlined$collectWhile$2, anonymousClass3) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } catch (AbortFlowException e2) {
            abortFlowException = e2;
            flowCollector = flowKt__ReduceKt$first$$inlined$collectWhile$2;
            FlowExceptions_commonKt.checkOwnership(abortFlowException, flowCollector);
        }
        function3 = function2;
        objectRef2 = objectRef;
        t = objectRef2.element;
        if (t != NullSurrogateKt.NULL) {
            return t;
        }
        throw new NoSuchElementException("Expected at least one element matching the predicate " + function3);
        FlowExceptions_commonKt.checkOwnership(abortFlowException, flowCollector);
        function3 = function2;
        objectRef2 = objectRef;
        t = objectRef2.element;
        if (t != NullSurrogateKt.NULL) {
            return t;
        }
        throw new NoSuchElementException("Expected at least one element matching the predicate " + function3);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final <T> Object firstOrNull(@NotNull Flow<? extends T> flow, @NotNull Continuation<? super T> continuation) {
        C04911 c04911;
        Ref.ObjectRef objectRef;
        AbortFlowException e;
        FlowCollector<T> flowCollector;
        if (continuation instanceof C04911) {
            c04911 = (C04911) continuation;
            int i = c04911.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c04911.label = i - Integer.MIN_VALUE;
            } else {
                c04911 = new C04911(continuation);
            }
        } else {
            c04911 = new C04911(continuation);
        }
        Object obj = c04911.result;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c04911.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            FlowCollector<T> flowCollector2 = new FlowCollector<T>() { // from class: kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public Object emit(T t, Continuation<? super Unit> continuation2) {
                    objectRef2.element = t;
                    throw new AbortFlowException(this);
                }
            };
            try {
                c04911.L$0 = objectRef2;
                c04911.L$1 = flowCollector2;
                c04911.label = 1;
                if (flow.collect(flowCollector2, c04911) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                objectRef = objectRef2;
            } catch (AbortFlowException e2) {
                objectRef = objectRef2;
                e = e2;
                flowCollector = flowCollector2;
                FlowExceptions_commonKt.checkOwnership(e, flowCollector);
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            flowCollector = (FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$1) c04911.L$1;
            objectRef = (Ref.ObjectRef) c04911.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (AbortFlowException e3) {
                e = e3;
                FlowExceptions_commonKt.checkOwnership(e, flowCollector);
            }
        }
        return objectRef.element;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final <T> Object firstOrNull(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
        C04923 c04923;
        Ref.ObjectRef objectRef;
        AbortFlowException e;
        FlowCollector<? super Object> flowCollector;
        if (continuation instanceof C04923) {
            c04923 = (C04923) continuation;
            int i = c04923.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c04923.label = i - Integer.MIN_VALUE;
            } else {
                c04923 = new C04923(continuation);
            }
        } else {
            c04923 = new C04923(continuation);
        }
        Object obj = c04923.result;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c04923.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            FlowCollector<? super Object> flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2 = new FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2<>(function2, objectRef2);
            try {
                c04923.L$0 = objectRef2;
                c04923.L$1 = flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2;
                c04923.label = 1;
                if (flow.collect(flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2, c04923) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                objectRef = objectRef2;
            } catch (AbortFlowException e2) {
                objectRef = objectRef2;
                e = e2;
                flowCollector = flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2;
                FlowExceptions_commonKt.checkOwnership(e, flowCollector);
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            flowCollector = (FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2) c04923.L$1;
            objectRef = (Ref.ObjectRef) c04923.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (AbortFlowException e3) {
                e = e3;
                FlowExceptions_commonKt.checkOwnership(e, flowCollector);
            }
        }
        return objectRef.element;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final <T> Object last(@NotNull Flow<? extends T> flow, @NotNull Continuation<? super T> continuation) {
        C04941 c04941;
        Ref.ObjectRef objectRef;
        if (continuation instanceof C04941) {
            c04941 = (C04941) continuation;
            int i = c04941.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c04941.label = i - Integer.MIN_VALUE;
            } else {
                c04941 = new C04941(continuation);
            }
        } else {
            c04941 = new C04941(continuation);
        }
        Object obj = c04941.result;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c04941.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            objectRef2.element = (T) NullSurrogateKt.NULL;
            FlowCollector<? super Object> flowCollector = new FlowCollector() { // from class: kotlinx.coroutines.flow.FlowKt__ReduceKt.last.2
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(T t, Continuation<? super Unit> continuation2) {
                    objectRef2.element = t;
                    return Unit.INSTANCE;
                }
            };
            c04941.L$0 = objectRef2;
            c04941.label = 1;
            if (flow.collect(flowCollector, c04941) == coroutine_suspended) {
                return coroutine_suspended;
            }
            objectRef = objectRef2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objectRef = (Ref.ObjectRef) c04941.L$0;
            ResultKt.throwOnFailure(obj);
        }
        T t = objectRef.element;
        if (t != NullSurrogateKt.NULL) {
            return t;
        }
        throw new NoSuchElementException("Expected at least one element");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final <T> Object lastOrNull(@NotNull Flow<? extends T> flow, @NotNull Continuation<? super T> continuation) {
        C04961 c04961;
        Ref.ObjectRef objectRef;
        if (continuation instanceof C04961) {
            c04961 = (C04961) continuation;
            int i = c04961.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c04961.label = i - Integer.MIN_VALUE;
            } else {
                c04961 = new C04961(continuation);
            }
        } else {
            c04961 = new C04961(continuation);
        }
        Object obj = c04961.result;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c04961.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            FlowCollector<? super Object> flowCollector = new FlowCollector() { // from class: kotlinx.coroutines.flow.FlowKt__ReduceKt.lastOrNull.2
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(T t, Continuation<? super Unit> continuation2) {
                    objectRef2.element = t;
                    return Unit.INSTANCE;
                }
            };
            c04961.L$0 = objectRef2;
            c04961.label = 1;
            if (flow.collect(flowCollector, c04961) == coroutine_suspended) {
                return coroutine_suspended;
            }
            objectRef = objectRef2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objectRef = (Ref.ObjectRef) c04961.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return objectRef.element;
    }
}
