package androidx.datastore.core;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.datastore.core.handlers.NoOpCorruptionHandler;
import com.facebook.cache.disk.DefaultDiskStorage;
import io.sentry.instrumentation.file.SentryFileInputStream;
import io.sentry.instrumentation.file.SentryFileOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class SingleProcessDataStore<T> implements DataStore<T> {
    public static final Companion Companion = new Companion(null);
    private static final Set<String> activeFiles = new LinkedHashSet();
    private static final Object activeFilesLock = new Object();
    private final String SCRATCH_SUFFIX;
    private final SimpleActor<Message<T>> actor;
    private final CorruptionHandler<T> corruptionHandler;
    private final Flow<T> data;
    private final MutableStateFlow<State<T>> downstreamFlow;
    private final Lazy file$delegate;
    private List<? extends Function2<? super InitializerApi<T>, ? super Continuation<? super Unit>, ? extends Object>> initTasks;
    private final Function0<File> produceFile;
    private final CoroutineScope scope;
    private final Serializer<T> serializer;

    /* JADX INFO: renamed from: androidx.datastore.core.SingleProcessDataStore$handleUpdate$1, reason: invalid class name */
    @DebugMetadata(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", i = {1, 1}, l = {276, 281, 284}, m = "handleUpdate", n = {"update", "$this$handleUpdate_u24lambda_u2d0"}, s = {"L$0", "L$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SingleProcessDataStore<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SingleProcessDataStore<T> singleProcessDataStore, Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
            this.this$0 = singleProcessDataStore;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.handleUpdate(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.SingleProcessDataStore$readAndInit$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", i = {0, 0, 1, 1, 1, 2}, l = {322, 348, TypedValues.PositionType.TYPE_SIZE_PERCENT}, m = "readAndInit", n = {"updateLock", "initData", "updateLock", "initData", "initializationComplete", "$this$withLock_u24default$iv"}, s = {"L$1", "L$2", "L$1", "L$2", "L$3", "L$3"})
    static final class C02661 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SingleProcessDataStore<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02661(SingleProcessDataStore<T> singleProcessDataStore, Continuation<? super C02661> continuation) {
            super(continuation);
            this.this$0 = singleProcessDataStore;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.readAndInit(this);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateAndThrowFailure$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", i = {0}, l = {302}, m = "readAndInitOrPropagateAndThrowFailure", n = {"this"}, s = {"L$0"})
    static final class C02671 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SingleProcessDataStore<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02671(SingleProcessDataStore<T> singleProcessDataStore, Continuation<? super C02671> continuation) {
            super(continuation);
            this.this$0 = singleProcessDataStore;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.readAndInitOrPropagateAndThrowFailure(this);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateFailure$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", i = {0}, l = {311}, m = "readAndInitOrPropagateFailure", n = {"this"}, s = {"L$0"})
    static final class C02681 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SingleProcessDataStore<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02681(SingleProcessDataStore<T> singleProcessDataStore, Continuation<? super C02681> continuation) {
            super(continuation);
            this.this$0 = singleProcessDataStore;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.readAndInitOrPropagateFailure(this);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.SingleProcessDataStore$readData$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", i = {0}, l = {381}, m = "readData", n = {"this"}, s = {"L$0"})
    static final class C02691 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SingleProcessDataStore<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02691(SingleProcessDataStore<T> singleProcessDataStore, Continuation<? super C02691> continuation) {
            super(continuation);
            this.this$0 = singleProcessDataStore;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.readData(this);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.SingleProcessDataStore$readDataOrHandleCorruption$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", i = {0, 1, 2, 2}, l = {359, 362, 365}, m = "readDataOrHandleCorruption", n = {"this", "ex", "ex", "newData"}, s = {"L$0", "L$1", "L$0", "L$1"})
    static final class C02701 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SingleProcessDataStore<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02701(SingleProcessDataStore<T> singleProcessDataStore, Continuation<? super C02701> continuation) {
            super(continuation);
            this.this$0 = singleProcessDataStore;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.readDataOrHandleCorruption(this);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.SingleProcessDataStore$transformAndWrite$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", i = {0, 0, 0}, l = {TypedValues.CycleType.TYPE_VISIBILITY, 410}, m = "transformAndWrite", n = {"this", "curDataAndHash", "curData"}, s = {"L$0", "L$1", "L$2"})
    static final class C02711 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SingleProcessDataStore<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02711(SingleProcessDataStore<T> singleProcessDataStore, Continuation<? super C02711> continuation) {
            super(continuation);
            this.this$0 = singleProcessDataStore;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.transformAndWrite(null, null, this);
        }
    }

    private static /* synthetic */ void getDownstreamFlow$annotations() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SingleProcessDataStore(@NotNull Function0<? extends File> produceFile, @NotNull Serializer<T> serializer, @NotNull List<? extends Function2<? super InitializerApi<T>, ? super Continuation<? super Unit>, ? extends Object>> initTasksList, @NotNull CorruptionHandler<T> corruptionHandler, @NotNull CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(produceFile, "produceFile");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(initTasksList, "initTasksList");
        Intrinsics.checkNotNullParameter(corruptionHandler, "corruptionHandler");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.produceFile = produceFile;
        this.serializer = serializer;
        this.corruptionHandler = corruptionHandler;
        this.scope = scope;
        this.data = FlowKt.flow(new SingleProcessDataStore$data$1(this, null));
        this.SCRATCH_SUFFIX = DefaultDiskStorage.FileType.TEMP;
        this.file$delegate = LazyKt__LazyJVMKt.lazy(new Function0<File>(this) { // from class: androidx.datastore.core.SingleProcessDataStore$file$2
            final /* synthetic */ SingleProcessDataStore<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final File invoke() {
                File file = (File) ((SingleProcessDataStore) this.this$0).produceFile.invoke();
                String it2 = file.getAbsolutePath();
                SingleProcessDataStore.Companion companion = SingleProcessDataStore.Companion;
                synchronized (companion.getActiveFilesLock$datastore_core()) {
                    if (companion.getActiveFiles$datastore_core().contains(it2)) {
                        throw new IllegalStateException(("There are multiple DataStores active for the same file: " + file + ". You should either maintain your DataStore as a singleton or confirm that there is no two DataStore's active on the same file (by confirming that the scope is cancelled).").toString());
                    }
                    Set<String> activeFiles$datastore_core = companion.getActiveFiles$datastore_core();
                    Intrinsics.checkNotNullExpressionValue(it2, "it");
                    activeFiles$datastore_core.add(it2);
                }
                return file;
            }
        });
        this.downstreamFlow = StateFlowKt.MutableStateFlow(UnInitialized.INSTANCE);
        this.initTasks = CollectionsKt___CollectionsKt.toList(initTasksList);
        this.actor = new SimpleActor<>(scope, new Function1<Throwable, Unit>(this) { // from class: androidx.datastore.core.SingleProcessDataStore$actor$1
            final /* synthetic */ SingleProcessDataStore<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Throwable th) {
                if (th != null) {
                    ((SingleProcessDataStore) this.this$0).downstreamFlow.setValue(new Final(th));
                }
                SingleProcessDataStore.Companion companion = SingleProcessDataStore.Companion;
                Object activeFilesLock$datastore_core = companion.getActiveFilesLock$datastore_core();
                SingleProcessDataStore<T> singleProcessDataStore = this.this$0;
                synchronized (activeFilesLock$datastore_core) {
                    companion.getActiveFiles$datastore_core().remove(singleProcessDataStore.getFile().getAbsolutePath());
                    Unit unit = Unit.INSTANCE;
                }
            }
        }, new Function2<Message<T>, Throwable, Unit>() { // from class: androidx.datastore.core.SingleProcessDataStore$actor$2
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Object obj, Throwable th) {
                invoke((SingleProcessDataStore.Message) obj, th);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull SingleProcessDataStore.Message<T> msg, @Nullable Throwable th) {
                Intrinsics.checkNotNullParameter(msg, "msg");
                if (msg instanceof SingleProcessDataStore.Message.Update) {
                    CompletableDeferred<T> ack = ((SingleProcessDataStore.Message.Update) msg).getAck();
                    if (th == null) {
                        th = new CancellationException("DataStore scope was cancelled before updateData could complete");
                    }
                    ack.completeExceptionally(th);
                }
            }
        }, new SingleProcessDataStore$actor$3(this, null));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ SingleProcessDataStore(Function0 function0, Serializer serializer, List list, CorruptionHandler corruptionHandler, CoroutineScope coroutineScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        List listEmptyList = (i & 4) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list;
        CorruptionHandler noOpCorruptionHandler = (i & 8) != 0 ? new NoOpCorruptionHandler() : corruptionHandler;
        if ((i & 16) != 0) {
            Dispatchers dispatchers = Dispatchers.INSTANCE;
            coroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        }
        this(function0, serializer, listEmptyList, noOpCorruptionHandler, coroutineScope);
    }

    @Override // androidx.datastore.core.DataStore
    public Flow<T> getData() {
        return this.data;
    }

    @Override // androidx.datastore.core.DataStore
    public Object updateData(@NotNull Function2<? super T, ? super Continuation<? super T>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
        CompletableDeferred completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        this.actor.offer(new Message.Update(function2, completableDeferredCompletableDeferred$default, this.downstreamFlow.getValue(), continuation.getContext()));
        return completableDeferredCompletableDeferred$default.await(continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File getFile() {
        return (File) this.file$delegate.getValue();
    }

    static abstract class Message<T> {
        public /* synthetic */ Message(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public abstract State<T> getLastState();

        private Message() {
        }

        public static final class Read<T> extends Message<T> {
            private final State<T> lastState;

            @Override // androidx.datastore.core.SingleProcessDataStore.Message
            public State<T> getLastState() {
                return this.lastState;
            }

            public Read(@Nullable State<T> state) {
                super(null);
                this.lastState = state;
            }
        }

        public static final class Update<T> extends Message<T> {
            private final CompletableDeferred<T> ack;
            private final CoroutineContext callerContext;
            private final State<T> lastState;
            private final Function2<T, Continuation<? super T>, Object> transform;

            public final Function2<T, Continuation<? super T>, Object> getTransform() {
                return this.transform;
            }

            public final CompletableDeferred<T> getAck() {
                return this.ack;
            }

            @Override // androidx.datastore.core.SingleProcessDataStore.Message
            public State<T> getLastState() {
                return this.lastState;
            }

            public final CoroutineContext getCallerContext() {
                return this.callerContext;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Update(@NotNull Function2<? super T, ? super Continuation<? super T>, ? extends Object> transform, @NotNull CompletableDeferred<T> ack, @Nullable State<T> state, @NotNull CoroutineContext callerContext) {
                super(null);
                Intrinsics.checkNotNullParameter(transform, "transform");
                Intrinsics.checkNotNullParameter(ack, "ack");
                Intrinsics.checkNotNullParameter(callerContext, "callerContext");
                this.transform = transform;
                this.ack = ack;
                this.lastState = state;
                this.callerContext = callerContext;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object handleRead(Message.Read<T> read, Continuation<? super Unit> continuation) {
        State<T> value = this.downstreamFlow.getValue();
        if (!(value instanceof Data)) {
            if (value instanceof ReadException) {
                if (value == read.getLastState()) {
                    Object andInitOrPropagateFailure = readAndInitOrPropagateFailure(continuation);
                    return andInitOrPropagateFailure == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? andInitOrPropagateFailure : Unit.INSTANCE;
                }
            } else {
                if (Intrinsics.areEqual(value, UnInitialized.INSTANCE)) {
                    Object andInitOrPropagateFailure2 = readAndInitOrPropagateFailure(continuation);
                    return andInitOrPropagateFailure2 == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? andInitOrPropagateFailure2 : Unit.INSTANCE;
                }
                if (value instanceof Final) {
                    throw new IllegalStateException("Can't read in final state.");
                }
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:44:0x00b4 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10, types: [androidx.datastore.core.SingleProcessDataStore] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [androidx.datastore.core.SingleProcessDataStore$Message$Update] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r8v0, types: [androidx.datastore.core.SingleProcessDataStore, androidx.datastore.core.SingleProcessDataStore<T>, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v0, types: [androidx.datastore.core.SingleProcessDataStore$Message$Update, androidx.datastore.core.SingleProcessDataStore$Message$Update<T>, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v29 */
    /* JADX WARN: Type inference failed for: r9v3, types: [kotlinx.coroutines.CompletableDeferred] */
    /* JADX WARN: Type inference failed for: r9v30 */
    /* JADX WARN: Type inference failed for: r9v31 */
    /* JADX WARN: Type inference failed for: r9v32 */
    public final Object handleUpdate(Message.Update<T> update, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        Object objM5472constructorimpl;
        ?? r9;
        CompletableDeferred ack;
        ?? r2;
        ?? r4;
        CompletableDeferred completableDeferred;
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
        Object objTransformAndWrite = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objTransformAndWrite);
                ack = update.getAck();
                try {
                    Result.Companion companion = Result.Companion;
                    State<T> value = this.downstreamFlow.getValue();
                    if (value instanceof Data) {
                        Function2 transform = update.getTransform();
                        CoroutineContext callerContext = update.getCallerContext();
                        anonymousClass1.L$0 = ack;
                        anonymousClass1.label = 1;
                        Object objTransformAndWrite2 = transformAndWrite(transform, callerContext, anonymousClass1);
                        if (objTransformAndWrite2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        objTransformAndWrite = objTransformAndWrite2;
                        update = ack;
                    } else {
                        if (!(value instanceof ReadException) && !(value instanceof UnInitialized)) {
                            if (value instanceof Final) {
                                throw ((Final) value).getFinalException();
                            }
                            throw new NoWhenBranchMatchedException();
                        }
                        if (value == update.getLastState()) {
                            anonymousClass1.L$0 = update;
                            anonymousClass1.L$1 = this;
                            anonymousClass1.L$2 = ack;
                            anonymousClass1.label = 2;
                            if (readAndInitOrPropagateAndThrowFailure(anonymousClass1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            r2 = this;
                            r4 = update;
                            completableDeferred = ack;
                            Function2 transform2 = r4.getTransform();
                            CoroutineContext callerContext2 = r4.getCallerContext();
                            anonymousClass1.L$0 = completableDeferred;
                            anonymousClass1.L$1 = null;
                            anonymousClass1.L$2 = null;
                            anonymousClass1.label = 3;
                            objTransformAndWrite = r2.transformAndWrite(transform2, callerContext2, anonymousClass1);
                            update = completableDeferred;
                            if (objTransformAndWrite == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            throw ((ReadException) value).getReadException();
                        }
                    }
                    objM5472constructorimpl = Result.m5472constructorimpl(objTransformAndWrite);
                    r9 = update;
                } catch (Throwable th) {
                    th = th;
                    CompletableDeferred completableDeferred2 = ack;
                    th = th;
                    update = completableDeferred2;
                    Result.Companion companion2 = Result.Companion;
                    objM5472constructorimpl = Result.m5472constructorimpl(ResultKt.createFailure(th));
                    r9 = update;
                    CompletableDeferredKt.completeWith(r9, objM5472constructorimpl);
                    return Unit.INSTANCE;
                }
            } else {
                if (i2 != 1) {
                    if (i2 == 2) {
                        CompletableDeferred completableDeferred3 = (Message.Update<T>) ((CompletableDeferred) anonymousClass1.L$2);
                        SingleProcessDataStore singleProcessDataStore = (SingleProcessDataStore) anonymousClass1.L$1;
                        Message.Update update2 = (Message.Update) anonymousClass1.L$0;
                        ResultKt.throwOnFailure(objTransformAndWrite);
                        r2 = singleProcessDataStore;
                        r4 = update2;
                        completableDeferred = completableDeferred3;
                        try {
                            Function2 transform3 = r4.getTransform();
                            CoroutineContext callerContext3 = r4.getCallerContext();
                            anonymousClass1.L$0 = completableDeferred;
                            anonymousClass1.L$1 = null;
                            anonymousClass1.L$2 = null;
                            anonymousClass1.label = 3;
                            objTransformAndWrite = r2.transformAndWrite(transform3, callerContext3, anonymousClass1);
                            update = completableDeferred;
                            if (objTransformAndWrite == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            objM5472constructorimpl = Result.m5472constructorimpl(objTransformAndWrite);
                            r9 = update;
                        } catch (Throwable th2) {
                            ack = completableDeferred;
                            th = th2;
                            CompletableDeferred completableDeferred4 = ack;
                            th = th;
                            update = completableDeferred4;
                            Result.Companion companion3 = Result.Companion;
                            objM5472constructorimpl = Result.m5472constructorimpl(ResultKt.createFailure(th));
                            r9 = update;
                        }
                    } else if (i2 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
                boolean z = (Message.Update<T>) ((CompletableDeferred) anonymousClass1.L$0);
                ResultKt.throwOnFailure(objTransformAndWrite);
                update = z;
                objM5472constructorimpl = Result.m5472constructorimpl(objTransformAndWrite);
                r9 = update;
            }
        } catch (Throwable th3) {
            th = th3;
        }
        CompletableDeferredKt.completeWith(r9, objM5472constructorimpl);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object readAndInitOrPropagateAndThrowFailure(Continuation<? super Unit> continuation) throws Throwable {
        C02671 c02671;
        SingleProcessDataStore singleProcessDataStore;
        if (continuation instanceof C02671) {
            c02671 = (C02671) continuation;
            int i = c02671.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c02671.label = i - Integer.MIN_VALUE;
            } else {
                c02671 = new C02671(this, continuation);
            }
        } else {
            c02671 = new C02671(this, continuation);
        }
        Object obj = c02671.result;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c02671.label;
        if (i2 != 0) {
            if (i2 == 1) {
                singleProcessDataStore = (SingleProcessDataStore) c02671.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                } catch (Throwable th) {
                    th = th;
                    singleProcessDataStore.downstreamFlow.setValue(new ReadException(th));
                    throw th;
                }
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        try {
            c02671.L$0 = this;
            c02671.label = 1;
            if (readAndInit(c02671) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        } catch (Throwable th2) {
            th = th2;
            singleProcessDataStore = this;
            singleProcessDataStore.downstreamFlow.setValue(new ReadException(th));
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object readAndInitOrPropagateFailure(Continuation<? super Unit> continuation) {
        C02681 c02681;
        SingleProcessDataStore singleProcessDataStore;
        if (continuation instanceof C02681) {
            c02681 = (C02681) continuation;
            int i = c02681.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c02681.label = i - Integer.MIN_VALUE;
            } else {
                c02681 = new C02681(this, continuation);
            }
        } else {
            c02681 = new C02681(this, continuation);
        }
        Object obj = c02681.result;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c02681.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                c02681.L$0 = this;
                c02681.label = 1;
                if (readAndInit(c02681) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } catch (Throwable th) {
                th = th;
                singleProcessDataStore = this;
                singleProcessDataStore.downstreamFlow.setValue(new ReadException(th));
            }
        } else if (i2 == 1) {
            singleProcessDataStore = (SingleProcessDataStore) c02681.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th2) {
                th = th2;
                singleProcessDataStore.downstreamFlow.setValue(new ReadException(th));
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:35:0x00de  */
    /* JADX WARN: Code duplicated, block: B:40:0x010f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:41:0x0110  */
    /* JADX WARN: Code duplicated, block: B:45:0x0120  */
    /* JADX WARN: Code duplicated, block: B:54:0x00f8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:56:? A[LOOP:0: B:33:0x00d8->B:56:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object readAndInit(Continuation<? super Unit> continuation) throws CorruptionException, IllegalAccessException, FileNotFoundException, InvocationTargetException {
        C02661 c02661;
        Ref.ObjectRef objectRef;
        SingleProcessDataStore singleProcessDataStore;
        Mutex mutex;
        Ref.ObjectRef objectRef2;
        Ref.BooleanRef booleanRef;
        SingleProcessDataStore$readAndInit$api$1 singleProcessDataStore$readAndInit$api$1;
        Iterator<T> it2;
        Ref.BooleanRef booleanRef2;
        Ref.ObjectRef objectRef3;
        Mutex mutex2;
        SingleProcessDataStore singleProcessDataStore2;
        Function2 function2;
        if (continuation instanceof C02661) {
            c02661 = (C02661) continuation;
            int i = c02661.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c02661.label = i - Integer.MIN_VALUE;
            } else {
                c02661 = new C02661(this, continuation);
            }
        } else {
            c02661 = new C02661(this, continuation);
        }
        T t = (T) c02661.result;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c02661.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(t);
            if (!Intrinsics.areEqual(this.downstreamFlow.getValue(), UnInitialized.INSTANCE) && !(this.downstreamFlow.getValue() instanceof ReadException)) {
                throw new IllegalStateException("Check failed.");
            }
            Mutex mutexMutex$default = MutexKt.Mutex$default(false, 1, null);
            objectRef = new Ref.ObjectRef();
            c02661.L$0 = this;
            c02661.L$1 = mutexMutex$default;
            c02661.L$2 = objectRef;
            c02661.L$3 = objectRef;
            c02661.label = 1;
            Object dataOrHandleCorruption = readDataOrHandleCorruption(c02661);
            if (dataOrHandleCorruption == coroutine_suspended) {
                return coroutine_suspended;
            }
            singleProcessDataStore = this;
            mutex = mutexMutex$default;
            objectRef2 = objectRef;
            t = (T) dataOrHandleCorruption;
        } else {
            if (i2 == 1) {
                objectRef = (Ref.ObjectRef) c02661.L$3;
                Ref.ObjectRef objectRef4 = (Ref.ObjectRef) c02661.L$2;
                Mutex mutex3 = (Mutex) c02661.L$1;
                SingleProcessDataStore singleProcessDataStore3 = (SingleProcessDataStore) c02661.L$0;
                ResultKt.throwOnFailure(t);
                mutex = mutex3;
                singleProcessDataStore = singleProcessDataStore3;
                objectRef2 = objectRef4;
            } else if (i2 == 2) {
                it2 = (Iterator) c02661.L$5;
                singleProcessDataStore$readAndInit$api$1 = (SingleProcessDataStore$readAndInit$api$1) c02661.L$4;
                booleanRef = (Ref.BooleanRef) c02661.L$3;
                objectRef2 = (Ref.ObjectRef) c02661.L$2;
                mutex = (Mutex) c02661.L$1;
                SingleProcessDataStore singleProcessDataStore4 = (SingleProcessDataStore) c02661.L$0;
                ResultKt.throwOnFailure(t);
                singleProcessDataStore = singleProcessDataStore4;
                while (it2.hasNext()) {
                    function2 = (Function2) it2.next();
                    c02661.L$0 = singleProcessDataStore;
                    c02661.L$1 = mutex;
                    c02661.L$2 = objectRef2;
                    c02661.L$3 = booleanRef;
                    c02661.L$4 = singleProcessDataStore$readAndInit$api$1;
                    c02661.L$5 = it2;
                    c02661.label = 2;
                    if (function2.invoke(singleProcessDataStore$readAndInit$api$1, c02661) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                booleanRef2 = booleanRef;
                singleProcessDataStore.initTasks = null;
                c02661.L$0 = singleProcessDataStore;
                c02661.L$1 = objectRef2;
                c02661.L$2 = booleanRef2;
                c02661.L$3 = mutex;
                c02661.L$4 = null;
                c02661.L$5 = null;
                c02661.label = 3;
                if (mutex.lock(null, c02661) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                objectRef3 = objectRef2;
                mutex2 = mutex;
                singleProcessDataStore2 = singleProcessDataStore;
            } else {
                if (i2 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutex2 = (Mutex) c02661.L$3;
                booleanRef2 = (Ref.BooleanRef) c02661.L$2;
                objectRef3 = (Ref.ObjectRef) c02661.L$1;
                SingleProcessDataStore singleProcessDataStore5 = (SingleProcessDataStore) c02661.L$0;
                ResultKt.throwOnFailure(t);
                singleProcessDataStore2 = singleProcessDataStore5;
            }
            try {
                booleanRef2.element = true;
                Unit unit = Unit.INSTANCE;
                mutex2.unlock(null);
                MutableStateFlow<State<T>> mutableStateFlow = singleProcessDataStore2.downstreamFlow;
                T t2 = objectRef3.element;
                mutableStateFlow.setValue(new Data(t2, t2 != null ? t2.hashCode() : 0));
                return unit;
            } catch (Throwable th) {
                mutex2.unlock(null);
                throw th;
            }
        }
        objectRef.element = t;
        booleanRef = new Ref.BooleanRef();
        singleProcessDataStore$readAndInit$api$1 = new SingleProcessDataStore$readAndInit$api$1(mutex, booleanRef, objectRef2, singleProcessDataStore);
        List<? extends Function2<? super InitializerApi<T>, ? super Continuation<? super Unit>, ? extends Object>> list = singleProcessDataStore.initTasks;
        if (list != null) {
            it2 = list.iterator();
            singleProcessDataStore = singleProcessDataStore;
            while (it2.hasNext()) {
                function2 = (Function2) it2.next();
                c02661.L$0 = singleProcessDataStore;
                c02661.L$1 = mutex;
                c02661.L$2 = objectRef2;
                c02661.L$3 = booleanRef;
                c02661.L$4 = singleProcessDataStore$readAndInit$api$1;
                c02661.L$5 = it2;
                c02661.label = 2;
                if (function2.invoke(singleProcessDataStore$readAndInit$api$1, c02661) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        }
        booleanRef2 = booleanRef;
        singleProcessDataStore.initTasks = null;
        c02661.L$0 = singleProcessDataStore;
        c02661.L$1 = objectRef2;
        c02661.L$2 = booleanRef2;
        c02661.L$3 = mutex;
        c02661.L$4 = null;
        c02661.L$5 = null;
        c02661.label = 3;
        if (mutex.lock(null, c02661) == coroutine_suspended) {
            return coroutine_suspended;
        }
        objectRef3 = objectRef2;
        mutex2 = mutex;
        singleProcessDataStore2 = singleProcessDataStore;
        booleanRef2.element = true;
        Unit unit2 = Unit.INSTANCE;
        mutex2.unlock(null);
        MutableStateFlow<State<T>> mutableStateFlow2 = singleProcessDataStore2.downstreamFlow;
        T t3 = objectRef3.element;
        mutableStateFlow2.setValue(new Data(t3, t3 != null ? t3.hashCode() : 0));
        return unit2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:35:0x0074 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:36:0x0075  */
    /* JADX WARN: Code duplicated, block: B:39:0x0085 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:40:0x0086  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [androidx.datastore.core.SingleProcessDataStore, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v6, types: [androidx.datastore.core.SingleProcessDataStore] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [androidx.datastore.core.SingleProcessDataStore] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r7v0, types: [androidx.datastore.core.SingleProcessDataStore, androidx.datastore.core.SingleProcessDataStore<T>, java.lang.Object] */
    public final Object readDataOrHandleCorruption(Continuation<? super T> continuation) throws CorruptionException, IllegalAccessException, FileNotFoundException, InvocationTargetException {
        C02701 c02701;
        ?? r2;
        Object objHandleCorruption;
        CorruptionException corruptionException;
        ?? r4;
        CorruptionException corruptionException2;
        if (continuation instanceof C02701) {
            c02701 = (C02701) continuation;
            int i = c02701.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c02701.label = i - Integer.MIN_VALUE;
            } else {
                c02701 = new C02701(this, continuation);
            }
        } else {
            c02701 = new C02701(this, continuation);
        }
        Object data = c02701.result;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c02701.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(data);
            try {
                c02701.L$0 = this;
                c02701.label = 1;
                data = readData(c02701);
                return data == coroutine_suspended ? coroutine_suspended : data;
            } catch (CorruptionException e) {
                e = e;
                r2 = this;
                CorruptionHandler<T> corruptionHandler = r2.corruptionHandler;
                c02701.L$0 = r2;
                c02701.L$1 = e;
                c02701.label = 2;
                objHandleCorruption = corruptionHandler.handleCorruption(e, c02701);
                if (objHandleCorruption == coroutine_suspended) {
                    return coroutine_suspended;
                }
                ?? r6 = r2;
                corruptionException = e;
                data = objHandleCorruption;
                r4 = r6;
                c02701.L$0 = corruptionException;
                c02701.L$1 = data;
                c02701.label = 3;
                if (r4.writeData$datastore_core(data, c02701) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return data;
            }
        }
        if (i2 == 1) {
            r2 = (SingleProcessDataStore) c02701.L$0;
            try {
                ResultKt.throwOnFailure(data);
            } catch (CorruptionException e2) {
                e = e2;
                CorruptionHandler<T> corruptionHandler2 = r2.corruptionHandler;
                c02701.L$0 = r2;
                c02701.L$1 = e;
                c02701.label = 2;
                objHandleCorruption = corruptionHandler2.handleCorruption(e, c02701);
                if (objHandleCorruption == coroutine_suspended) {
                    return coroutine_suspended;
                }
                ?? r7 = r2;
                corruptionException = e;
                data = objHandleCorruption;
                r4 = r7;
                c02701.L$0 = corruptionException;
                c02701.L$1 = data;
                c02701.label = 3;
                if (r4.writeData$datastore_core(data, c02701) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return data;
            }
        }
        if (i2 == 2) {
            corruptionException = (CorruptionException) c02701.L$1;
            SingleProcessDataStore singleProcessDataStore = (SingleProcessDataStore) c02701.L$0;
            ResultKt.throwOnFailure(data);
            r4 = singleProcessDataStore;
        } else {
            if (i2 != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Object obj = c02701.L$1;
            corruptionException2 = (CorruptionException) c02701.L$0;
            try {
                ResultKt.throwOnFailure(data);
                return obj;
            } catch (IOException e3) {
                e = e3;
            }
        }
        ExceptionsKt__ExceptionsKt.addSuppressed(corruptionException2, e);
        throw corruptionException2;
        try {
            c02701.L$0 = corruptionException;
            c02701.L$1 = data;
            c02701.label = 3;
            if (r4.writeData$datastore_core(data, c02701) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return data;
        } catch (IOException e4) {
            e = e4;
            corruptionException2 = corruptionException;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [androidx.datastore.core.SingleProcessDataStore] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.datastore.core.SingleProcessDataStore$readData$1, kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [androidx.datastore.core.SingleProcessDataStore] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.FileInputStream, java.io.InputStream, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r6v9, types: [androidx.datastore.core.Serializer, androidx.datastore.core.Serializer<T>] */
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
    public final Object readData(Continuation<? super T> continuation) throws FileNotFoundException {
        ?? c02691;
        ?? Create;
        Throwable th;
        ?? r2;
        if (continuation instanceof C02691) {
            C02691 c02692 = (C02691) continuation;
            int i = c02692.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c02692.label = i - Integer.MIN_VALUE;
                c02691 = c02692;
            } else {
                c02691 = new C02691(this, continuation);
            }
        } else {
            c02691 = new C02691(this, continuation);
        }
        Object from = c02691.result;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c02691.label;
        try {
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                th = (Throwable) c02691.L$2;
                Create = (Closeable) c02691.L$1;
                c02691 = (SingleProcessDataStore) c02691.L$0;
                try {
                    ResultKt.throwOnFailure(from);
                    r2 = Create;
                    CloseableKt.closeFinally(r2, th);
                    return from;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        throw th;
                    } catch (Throwable th3) {
                        CloseableKt.closeFinally(Create, th);
                        throw th3;
                    }
                }
            }
            ResultKt.throwOnFailure(from);
            try {
                File file = getFile();
                Create = SentryFileInputStream.Factory.create(new FileInputStream(file), file);
                try {
                    Serializer<T> serializer = this.serializer;
                    c02691.L$0 = this;
                    c02691.L$1 = Create;
                    c02691.L$2 = null;
                    c02691.label = 1;
                    from = serializer.readFrom(Create, c02691);
                    if (from == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    th = null;
                    r2 = Create;
                    CloseableKt.closeFinally(r2, th);
                    return from;
                } catch (Throwable th4) {
                    th = th4;
                    c02691 = this;
                    throw th;
                }
            } catch (FileNotFoundException e) {
                e = e;
                c02691 = this;
                if (c02691.getFile().exists()) {
                    throw e;
                }
                return c02691.serializer.getDefaultValue();
            }
        } catch (FileNotFoundException e2) {
            e = e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:29:0x0092  */
    /* JADX WARN: Code duplicated, block: B:30:0x0097  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object transformAndWrite(Function2<? super T, ? super Continuation<? super T>, ? extends Object> function2, CoroutineContext coroutineContext, Continuation<? super T> continuation) {
        C02711 c02711;
        Data data;
        Object obj;
        SingleProcessDataStore singleProcessDataStore;
        SingleProcessDataStore singleProcessDataStore2;
        int iHashCode;
        if (continuation instanceof C02711) {
            c02711 = (C02711) continuation;
            int i = c02711.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c02711.label = i - Integer.MIN_VALUE;
            } else {
                c02711 = new C02711(this, continuation);
            }
        } else {
            c02711 = new C02711(this, continuation);
        }
        Object obj2 = c02711.result;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c02711.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj2);
            Data data2 = (Data) this.downstreamFlow.getValue();
            data2.checkHashCode();
            Object value = data2.getValue();
            SingleProcessDataStore$transformAndWrite$newData$1 singleProcessDataStore$transformAndWrite$newData$1 = new SingleProcessDataStore$transformAndWrite$newData$1(function2, value, null);
            c02711.L$0 = this;
            c02711.L$1 = data2;
            c02711.L$2 = value;
            c02711.label = 1;
            Object objWithContext = BuildersKt.withContext(coroutineContext, singleProcessDataStore$transformAndWrite$newData$1, c02711);
            if (objWithContext == coroutine_suspended) {
                return coroutine_suspended;
            }
            data = data2;
            obj2 = objWithContext;
            obj = value;
            singleProcessDataStore = this;
        } else {
            if (i2 == 1) {
                obj = c02711.L$2;
                data = (Data) c02711.L$1;
                SingleProcessDataStore singleProcessDataStore3 = (SingleProcessDataStore) c02711.L$0;
                ResultKt.throwOnFailure(obj2);
                singleProcessDataStore = singleProcessDataStore3;
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                obj = c02711.L$1;
                SingleProcessDataStore singleProcessDataStore4 = (SingleProcessDataStore) c02711.L$0;
                ResultKt.throwOnFailure(obj2);
                singleProcessDataStore2 = singleProcessDataStore4;
            }
            MutableStateFlow<State<T>> mutableStateFlow = singleProcessDataStore2.downstreamFlow;
            if (obj != null) {
                iHashCode = obj.hashCode();
            } else {
                iHashCode = 0;
            }
            mutableStateFlow.setValue(new Data(obj, iHashCode));
            return obj;
        }
        data.checkHashCode();
        if (!Intrinsics.areEqual(obj, obj2)) {
            c02711.L$0 = singleProcessDataStore;
            c02711.L$1 = obj2;
            c02711.L$2 = null;
            c02711.label = 2;
            if (singleProcessDataStore.writeData$datastore_core(obj2, c02711) == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj = obj2;
            singleProcessDataStore2 = singleProcessDataStore;
            MutableStateFlow<State<T>> mutableStateFlow2 = singleProcessDataStore2.downstreamFlow;
            if (obj != null) {
                iHashCode = obj.hashCode();
            } else {
                iHashCode = 0;
            }
            mutableStateFlow2.setValue(new Data(obj, iHashCode));
        }
        return obj;
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.io.FileOutputStream, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v8, types: [java.io.FileOutputStream] */
    public final Object writeData$datastore_core(T t, @NotNull Continuation<? super Unit> continuation) throws IOException {
        SingleProcessDataStore$writeData$1 singleProcessDataStore$writeData$1;
        File file;
        ?? Create;
        SingleProcessDataStore<T> singleProcessDataStore;
        File file2;
        ?? r8;
        Throwable th;
        if (continuation instanceof SingleProcessDataStore$writeData$1) {
            singleProcessDataStore$writeData$1 = (SingleProcessDataStore$writeData$1) continuation;
            int i = singleProcessDataStore$writeData$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                singleProcessDataStore$writeData$1.label = i - Integer.MIN_VALUE;
            } else {
                singleProcessDataStore$writeData$1 = new SingleProcessDataStore$writeData$1(this, continuation);
            }
        } else {
            singleProcessDataStore$writeData$1 = new SingleProcessDataStore$writeData$1(this, continuation);
        }
        Object obj = singleProcessDataStore$writeData$1.result;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = singleProcessDataStore$writeData$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            createParentDirectories(getFile());
            file = new File(Intrinsics.stringPlus(getFile().getAbsolutePath(), this.SCRATCH_SUFFIX));
            try {
                Create = SentryFileOutputStream.Factory.create(new FileOutputStream(file), file);
                try {
                    Serializer<T> serializer = this.serializer;
                    UncloseableOutputStream uncloseableOutputStream = new UncloseableOutputStream(Create);
                    singleProcessDataStore$writeData$1.L$0 = this;
                    singleProcessDataStore$writeData$1.L$1 = file;
                    singleProcessDataStore$writeData$1.L$2 = Create;
                    singleProcessDataStore$writeData$1.L$3 = null;
                    singleProcessDataStore$writeData$1.L$4 = Create;
                    singleProcessDataStore$writeData$1.label = 1;
                    if (serializer.writeTo(t, uncloseableOutputStream, singleProcessDataStore$writeData$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    singleProcessDataStore = this;
                    file2 = file;
                    r8 = Create;
                    th = null;
                    Create = Create;
                } catch (Throwable th2) {
                    th = th2;
                    throw th;
                }
            } catch (IOException e) {
                e = e;
                if (file.exists()) {
                    file.delete();
                }
                throw e;
            }
        } else if (i2 == 1) {
            FileOutputStream fileOutputStream = (FileOutputStream) singleProcessDataStore$writeData$1.L$4;
            th = (Throwable) singleProcessDataStore$writeData$1.L$3;
            Create = (Closeable) singleProcessDataStore$writeData$1.L$2;
            file2 = (File) singleProcessDataStore$writeData$1.L$1;
            singleProcessDataStore = (SingleProcessDataStore) singleProcessDataStore$writeData$1.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                Create = Create;
                r8 = fileOutputStream;
            } catch (Throwable th3) {
                th = th3;
                file = file2;
                try {
                    throw th;
                } catch (Throwable th4) {
                    CloseableKt.closeFinally(Create, th);
                    throw th4;
                }
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        r8.getFD().sync();
        Unit unit = Unit.INSTANCE;
        try {
            CloseableKt.closeFinally(Create, th);
            if (file2.renameTo(singleProcessDataStore.getFile())) {
                return unit;
            }
            throw new IOException("Unable to rename " + file2 + ".This likely means that there are multiple instances of DataStore for this file. Ensure that you are only creating a single instance of datastore for this file.");
        } catch (IOException e2) {
            e = e2;
            file = file2;
            if (file.exists()) {
                file.delete();
            }
            throw e;
        }
    }

    private final void createParentDirectories(File file) throws IOException {
        File parentFile = file.getCanonicalFile().getParentFile();
        if (parentFile == null) {
            return;
        }
        parentFile.mkdirs();
        if (!parentFile.isDirectory()) {
            throw new IOException(Intrinsics.stringPlus("Unable to create parent directories of ", file));
        }
    }

    static final class UncloseableOutputStream extends OutputStream {
        private final FileOutputStream fileOutputStream;

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        public UncloseableOutputStream(@NotNull FileOutputStream fileOutputStream) {
            Intrinsics.checkNotNullParameter(fileOutputStream, "fileOutputStream");
            this.fileOutputStream = fileOutputStream;
        }

        public final FileOutputStream getFileOutputStream() {
            return this.fileOutputStream;
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            this.fileOutputStream.write(i);
        }

        @Override // java.io.OutputStream
        public void write(@NotNull byte[] b) throws IOException {
            Intrinsics.checkNotNullParameter(b, "b");
            this.fileOutputStream.write(b);
        }

        @Override // java.io.OutputStream
        public void write(@NotNull byte[] bytes, int i, int i2) throws IOException {
            Intrinsics.checkNotNullParameter(bytes, "bytes");
            this.fileOutputStream.write(bytes, i, i2);
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            this.fileOutputStream.flush();
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Set<String> getActiveFiles$datastore_core() {
            return SingleProcessDataStore.activeFiles;
        }

        public final Object getActiveFilesLock$datastore_core() {
            return SingleProcessDataStore.activeFilesLock;
        }
    }
}
