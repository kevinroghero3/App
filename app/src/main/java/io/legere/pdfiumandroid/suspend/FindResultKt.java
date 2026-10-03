package io.legere.pdfiumandroid.suspend;

import io.legere.pdfiumandroid.FindResult;
import java.io.Closeable;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class FindResultKt implements Closeable {
    private final CoroutineDispatcher dispatcher;
    private final FindResult findResult;

    public FindResultKt(@NotNull FindResult findResult, @NotNull CoroutineDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(findResult, "findResult");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.findResult = findResult;
        this.dispatcher = dispatcher;
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.FindResultKt$findNext$2, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.FindResultKt$findNext$2", f = "FindResultKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C03732 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        int label;

        C03732(Continuation<? super C03732> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FindResultKt.this.new C03732(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((C03732) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return Boxing.boxBoolean(FindResultKt.this.findResult.findNext());
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final Object findNext(@NotNull Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C03732(null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.FindResultKt$findPrev$2, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.FindResultKt$findPrev$2", f = "FindResultKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C03742 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        int label;

        C03742(Continuation<? super C03742> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FindResultKt.this.new C03742(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((C03742) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return Boxing.boxBoolean(FindResultKt.this.findResult.findPrev());
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final Object findPrev(@NotNull Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C03742(null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.FindResultKt$getSchResultIndex$2, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.FindResultKt$getSchResultIndex$2", f = "FindResultKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C03762 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
        int label;

        C03762(Continuation<? super C03762> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FindResultKt.this.new C03762(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Integer> continuation) {
            return ((C03762) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return Boxing.boxInt(FindResultKt.this.findResult.getSchResultIndex());
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final Object getSchResultIndex(@NotNull Continuation<? super Integer> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C03762(null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.FindResultKt$getSchCount$2, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.FindResultKt$getSchCount$2", f = "FindResultKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C03752 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
        int label;

        C03752(Continuation<? super C03752> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FindResultKt.this.new C03752(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Integer> continuation) {
            return ((C03752) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return Boxing.boxInt(FindResultKt.this.findResult.getSchCount());
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final Object getSchCount(@NotNull Continuation<? super Integer> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C03752(null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.FindResultKt$closeFind$2, reason: invalid class name */
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.FindResultKt$closeFind$2", f = "FindResultKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FindResultKt.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                FindResultKt.this.findResult.closeFind();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final Object closeFind(@NotNull Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(this.dispatcher, new AnonymousClass2(null), continuation);
        return objWithContext == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.findResult.closeFind();
    }
}
