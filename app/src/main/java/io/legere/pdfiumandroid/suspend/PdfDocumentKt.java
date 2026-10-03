package io.legere.pdfiumandroid.suspend;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.Surface;
import io.legere.pdfiumandroid.Logger;
import io.legere.pdfiumandroid.PdfDocument;
import io.legere.pdfiumandroid.PdfPage;
import io.legere.pdfiumandroid.PdfTextPage;
import io.legere.pdfiumandroid.PdfWriteCallback;
import io.legere.pdfiumandroid.PdfiumCore;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class PdfDocumentKt implements Closeable {
    private final CoroutineDispatcher dispatcher;
    private final PdfDocument document;

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfDocumentKt$renderPages$1, reason: invalid class name */
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfDocumentKt", f = "PdfDocumentKt.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}, l = {171, 89}, m = "renderPages", n = {"this", "surface", "pages", "matrices", "clipRects", "renderCoroutinesDispatcher", "$this$withLock_u24default$iv", "renderAnnot", "textMask", "canvasColor", "pageBackgroundColor", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "Z$1", "I$0", "I$1", "L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        boolean Z$0;
        boolean Z$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PdfDocumentKt.this.renderPages(null, null, null, null, false, false, 0, 0, null, this);
        }
    }

    public PdfDocumentKt(@NotNull PdfDocument document, @NotNull CoroutineDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(document, "document");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.document = document;
        this.dispatcher = dispatcher;
    }

    public final PdfDocument getDocument() {
        return this.document;
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfDocumentKt$getPageCount$2, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfDocumentKt$getPageCount$2", f = "PdfDocumentKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C03792 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
        int label;

        C03792(Continuation<? super C03792> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PdfDocumentKt.this.new C03792(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Integer> continuation) {
            return ((C03792) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxInt(PdfDocumentKt.this.getDocument().getPageCount());
        }
    }

    public final Object getPageCount(@NotNull Continuation<? super Integer> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C03792(null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfDocumentKt$getPageCharCounts$2, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfDocumentKt$getPageCharCounts$2", f = "PdfDocumentKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C03782 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super int[]>, Object> {
        int label;

        C03782(Continuation<? super C03782> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PdfDocumentKt.this.new C03782(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super int[]> continuation) {
            return ((C03782) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return PdfDocumentKt.this.getDocument().getPageCharCounts();
        }
    }

    public final Object getPageCharCounts(@NotNull Continuation<? super int[]> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C03782(null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfDocumentKt$openPage$2, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfDocumentKt$openPage$2", f = "PdfDocumentKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C03812 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super PdfPageKt>, Object> {
        final /* synthetic */ int $pageIndex;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03812(int i, Continuation<? super C03812> continuation) {
            super(2, continuation);
            this.$pageIndex = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PdfDocumentKt.this.new C03812(this.$pageIndex, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super PdfPageKt> continuation) {
            return ((C03812) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return new PdfPageKt(PdfDocumentKt.this.getDocument().openPage(this.$pageIndex), PdfDocumentKt.this.dispatcher);
        }
    }

    public final Object openPage(int i, @NotNull Continuation<? super PdfPageKt> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C03812(i, null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfDocumentKt$deletePage$2, reason: invalid class name */
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfDocumentKt$deletePage$2", f = "PdfDocumentKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $pageIndex;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(int i, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$pageIndex = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PdfDocumentKt.this.new AnonymousClass2(this.$pageIndex, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            PdfDocumentKt.this.getDocument().deletePage(this.$pageIndex);
            return Unit.INSTANCE;
        }
    }

    public final Object deletePage(int i, @NotNull Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(this.dispatcher, new AnonymousClass2(i, null), continuation);
        return objWithContext == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfDocumentKt$openPages$2, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfDocumentKt$openPages$2", f = "PdfDocumentKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C03822 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends PdfPageKt>>, Object> {
        final /* synthetic */ int $fromIndex;
        final /* synthetic */ int $toIndex;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03822(int i, int i2, Continuation<? super C03822> continuation) {
            super(2, continuation);
            this.$fromIndex = i;
            this.$toIndex = i2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PdfDocumentKt.this.new C03822(this.$fromIndex, this.$toIndex, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends PdfPageKt>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super List<PdfPageKt>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<PdfPageKt>> continuation) {
            return ((C03822) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            List<PdfPage> listOpenPages = PdfDocumentKt.this.getDocument().openPages(this.$fromIndex, this.$toIndex);
            PdfDocumentKt pdfDocumentKt = PdfDocumentKt.this;
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listOpenPages, 10));
            Iterator<T> it2 = listOpenPages.iterator();
            while (it2.hasNext()) {
                arrayList.add(new PdfPageKt((PdfPage) it2.next(), pdfDocumentKt.dispatcher));
            }
            return arrayList;
        }
    }

    public final Object openPages(int i, int i2, @NotNull Continuation<? super List<PdfPageKt>> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C03822(i, i2, null), continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public final Object renderPages(@NotNull Surface surface, @NotNull List<PdfPageKt> list, @NotNull List<? extends Matrix> list2, @NotNull List<? extends RectF> list3, boolean z, boolean z2, int i, int i2, @NotNull CoroutineDispatcher coroutineDispatcher, @NotNull Continuation<? super Boolean> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        boolean z3;
        int i3;
        int i4;
        List<? extends Matrix> list4;
        List<? extends RectF> list5;
        boolean z4;
        PdfDocumentKt pdfDocumentKt;
        List<PdfPageKt> list6;
        Mutex mutex;
        CoroutineDispatcher coroutineDispatcher2;
        Surface surface2;
        Mutex mutex2;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i5 = anonymousClass1.label;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i5 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object objWithContext = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i6 = anonymousClass1.label;
        try {
            if (i6 == 0) {
                ResultKt.throwOnFailure(objWithContext);
                Mutex surfaceMutex = PdfiumCore.Companion.getSurfaceMutex();
                anonymousClass1.L$0 = this;
                anonymousClass1.L$1 = surface;
                anonymousClass1.L$2 = list;
                anonymousClass1.L$3 = list2;
                anonymousClass1.L$4 = list3;
                anonymousClass1.L$5 = coroutineDispatcher;
                anonymousClass1.L$6 = surfaceMutex;
                anonymousClass1.Z$0 = z;
                anonymousClass1.Z$1 = z2;
                anonymousClass1.I$0 = i;
                anonymousClass1.I$1 = i2;
                anonymousClass1.label = 1;
                if (surfaceMutex.lock(null, anonymousClass1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                z3 = z2;
                i3 = i;
                i4 = i2;
                list4 = list2;
                list5 = list3;
                z4 = z;
                pdfDocumentKt = this;
                list6 = list;
                mutex = surfaceMutex;
                coroutineDispatcher2 = coroutineDispatcher;
                surface2 = surface;
            } else {
                if (i6 != 1) {
                    if (i6 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    mutex2 = (Mutex) anonymousClass1.L$0;
                    try {
                        ResultKt.throwOnFailure(objWithContext);
                        mutex2.unlock(null);
                        return objWithContext;
                    } catch (Throwable th) {
                        th = th;
                        mutex2.unlock(null);
                        throw th;
                    }
                }
                int i7 = anonymousClass1.I$1;
                int i8 = anonymousClass1.I$0;
                boolean z5 = anonymousClass1.Z$1;
                boolean z6 = anonymousClass1.Z$0;
                Mutex mutex3 = (Mutex) anonymousClass1.L$6;
                CoroutineDispatcher coroutineDispatcher3 = (CoroutineDispatcher) anonymousClass1.L$5;
                List<? extends RectF> list7 = (List) anonymousClass1.L$4;
                List<? extends Matrix> list8 = (List) anonymousClass1.L$3;
                List<PdfPageKt> list9 = (List) anonymousClass1.L$2;
                Surface surface3 = (Surface) anonymousClass1.L$1;
                PdfDocumentKt pdfDocumentKt2 = (PdfDocumentKt) anonymousClass1.L$0;
                ResultKt.throwOnFailure(objWithContext);
                i4 = i7;
                i3 = i8;
                mutex = mutex3;
                coroutineDispatcher2 = coroutineDispatcher3;
                list6 = list9;
                surface2 = surface3;
                z3 = z5;
                z4 = z6;
                pdfDocumentKt = pdfDocumentKt2;
                list5 = list7;
                list4 = list8;
            }
            PdfDocumentKt$renderPages$2$1 pdfDocumentKt$renderPages$2$1 = new PdfDocumentKt$renderPages$2$1(pdfDocumentKt, surface2, list6, list4, list5, z4, z3, i3, i4, null);
            anonymousClass1.L$0 = mutex;
            anonymousClass1.L$1 = null;
            anonymousClass1.L$2 = null;
            anonymousClass1.L$3 = null;
            anonymousClass1.L$4 = null;
            anonymousClass1.L$5 = null;
            anonymousClass1.L$6 = null;
            anonymousClass1.label = 2;
            objWithContext = BuildersKt.withContext(coroutineDispatcher2, pdfDocumentKt$renderPages$2$1, anonymousClass1);
            if (objWithContext == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutex2 = mutex;
            mutex2.unlock(null);
            return objWithContext;
        } catch (Throwable th2) {
            th = th2;
            mutex2 = mutex;
            mutex2.unlock(null);
            throw th;
        }
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfDocumentKt$getDocumentMeta$2, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfDocumentKt$getDocumentMeta$2", f = "PdfDocumentKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C03772 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super PdfDocument.Meta>, Object> {
        int label;

        C03772(Continuation<? super C03772> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PdfDocumentKt.this.new C03772(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super PdfDocument.Meta> continuation) {
            return ((C03772) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return PdfDocumentKt.this.getDocument().getDocumentMeta();
        }
    }

    public final Object getDocumentMeta(@NotNull Continuation<? super PdfDocument.Meta> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C03772(null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfDocumentKt$getTableOfContents$2, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfDocumentKt$getTableOfContents$2", f = "PdfDocumentKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C03802 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends PdfDocument.Bookmark>>, Object> {
        int label;

        C03802(Continuation<? super C03802> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PdfDocumentKt.this.new C03802(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends PdfDocument.Bookmark>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super List<PdfDocument.Bookmark>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<PdfDocument.Bookmark>> continuation) {
            return ((C03802) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return PdfDocumentKt.this.getDocument().getTableOfContents();
        }
    }

    public final Object getTableOfContents(@NotNull Continuation<? super List<PdfDocument.Bookmark>> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C03802(null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfDocumentKt$openTextPage$2, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfDocumentKt$openTextPage$2", f = "PdfDocumentKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C03832 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super PdfTextPageKt>, Object> {
        final /* synthetic */ PdfPageKt $page;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03832(PdfPageKt pdfPageKt, Continuation<? super C03832> continuation) {
            super(2, continuation);
            this.$page = pdfPageKt;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PdfDocumentKt.this.new C03832(this.$page, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super PdfTextPageKt> continuation) {
            return ((C03832) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return new PdfTextPageKt(PdfDocumentKt.this.getDocument().openTextPage(this.$page.getPage()), PdfDocumentKt.this.dispatcher);
        }
    }

    @Deprecated(message = "use PdfPageKt.openTextPage", replaceWith = @ReplaceWith(expression = "page.openTextPage()", imports = {}))
    public final Object openTextPage(@NotNull PdfPageKt pdfPageKt, @NotNull Continuation<? super PdfTextPageKt> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C03832(pdfPageKt, null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfDocumentKt$openTextPages$2, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfDocumentKt$openTextPages$2", f = "PdfDocumentKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C03842 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends PdfTextPageKt>>, Object> {
        final /* synthetic */ int $fromIndex;
        final /* synthetic */ int $toIndex;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03842(int i, int i2, Continuation<? super C03842> continuation) {
            super(2, continuation);
            this.$fromIndex = i;
            this.$toIndex = i2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PdfDocumentKt.this.new C03842(this.$fromIndex, this.$toIndex, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends PdfTextPageKt>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super List<PdfTextPageKt>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<PdfTextPageKt>> continuation) {
            return ((C03842) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            List<PdfTextPage> listOpenTextPages = PdfDocumentKt.this.getDocument().openTextPages(this.$fromIndex, this.$toIndex);
            PdfDocumentKt pdfDocumentKt = PdfDocumentKt.this;
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listOpenTextPages, 10));
            Iterator<T> it2 = listOpenTextPages.iterator();
            while (it2.hasNext()) {
                arrayList.add(new PdfTextPageKt((PdfTextPage) it2.next(), pdfDocumentKt.dispatcher));
            }
            return arrayList;
        }
    }

    public final Object openTextPages(int i, int i2, @NotNull Continuation<? super List<PdfTextPageKt>> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C03842(i, i2, null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfDocumentKt$saveAsCopy$2, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfDocumentKt$saveAsCopy$2", f = "PdfDocumentKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C03852 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ PdfWriteCallback $callback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03852(PdfWriteCallback pdfWriteCallback, Continuation<? super C03852> continuation) {
            super(2, continuation);
            this.$callback = pdfWriteCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PdfDocumentKt.this.new C03852(this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((C03852) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxBoolean(PdfDocument.saveAsCopy$default(PdfDocumentKt.this.getDocument(), this.$callback, 0, 2, null));
        }
    }

    public final Object saveAsCopy(@NotNull PdfWriteCallback pdfWriteCallback, @NotNull Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C03852(pdfWriteCallback, null), continuation);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.document.close();
    }

    public final boolean safeClose() {
        try {
            this.document.close();
            return true;
        } catch (IllegalStateException e) {
            Logger.INSTANCE.e("PdfDocumentKt", e, "PdfDocumentKt.safeClose");
            return false;
        }
    }
}
