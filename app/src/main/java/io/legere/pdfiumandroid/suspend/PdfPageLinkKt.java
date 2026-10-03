package io.legere.pdfiumandroid.suspend;

import android.graphics.RectF;
import io.legere.pdfiumandroid.PdfPageLink;
import java.io.Closeable;
import kotlin.Pair;
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
public final class PdfPageLinkKt implements Closeable {
    private final CoroutineDispatcher dispatcher;
    private final PdfPageLink pageLink;

    public PdfPageLinkKt(@NotNull PdfPageLink pageLink, @NotNull CoroutineDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(pageLink, "pageLink");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.pageLink = pageLink;
        this.dispatcher = dispatcher;
    }

    public final PdfPageLink getPageLink() {
        return this.pageLink;
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageLinkKt$countWebLinks$2, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfPageLinkKt$countWebLinks$2", f = "PdfPageLinkKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C04052 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
        int label;

        C04052(Continuation<? super C04052> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PdfPageLinkKt.this.new C04052(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Integer> continuation) {
            return ((C04052) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxInt(PdfPageLinkKt.this.getPageLink().countWebLinks());
        }
    }

    public final Object countWebLinks(@NotNull Continuation<? super Integer> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C04052(null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageLinkKt$getURL$2, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfPageLinkKt$getURL$2", f = "PdfPageLinkKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C04082 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
        final /* synthetic */ int $index;
        final /* synthetic */ int $length;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04082(int i, int i2, Continuation<? super C04082> continuation) {
            super(2, continuation);
            this.$index = i;
            this.$length = i2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PdfPageLinkKt.this.new C04082(this.$index, this.$length, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
            return ((C04082) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return PdfPageLinkKt.this.getPageLink().getURL(this.$index, this.$length);
        }
    }

    public final Object getURL(int i, int i2, @NotNull Continuation<? super String> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C04082(i, i2, null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageLinkKt$countRects$2, reason: invalid class name */
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfPageLinkKt$countRects$2", f = "PdfPageLinkKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
        final /* synthetic */ int $index;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(int i, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$index = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PdfPageLinkKt.this.new AnonymousClass2(this.$index, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Integer> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxInt(PdfPageLinkKt.this.getPageLink().countRects(this.$index));
        }
    }

    public final Object countRects(int i, @NotNull Continuation<? super Integer> continuation) {
        return BuildersKt.withContext(this.dispatcher, new AnonymousClass2(i, null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageLinkKt$getRect$2, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfPageLinkKt$getRect$2", f = "PdfPageLinkKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C04062 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super RectF>, Object> {
        final /* synthetic */ int $linkIndex;
        final /* synthetic */ int $rectIndex;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04062(int i, int i2, Continuation<? super C04062> continuation) {
            super(2, continuation);
            this.$linkIndex = i;
            this.$rectIndex = i2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PdfPageLinkKt.this.new C04062(this.$linkIndex, this.$rectIndex, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super RectF> continuation) {
            return ((C04062) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return PdfPageLinkKt.this.getPageLink().getRect(this.$linkIndex, this.$rectIndex);
        }
    }

    public final Object getRect(int i, int i2, @NotNull Continuation<? super RectF> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C04062(i, i2, null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageLinkKt$getTextRange$2, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfPageLinkKt$getTextRange$2", f = "PdfPageLinkKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C04072 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends Integer, ? extends Integer>>, Object> {
        final /* synthetic */ int $index;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04072(int i, Continuation<? super C04072> continuation) {
            super(2, continuation);
            this.$index = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PdfPageLinkKt.this.new C04072(this.$index, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Pair<? extends Integer, ? extends Integer>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Pair<Integer, Integer>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Pair<Integer, Integer>> continuation) {
            return ((C04072) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return PdfPageLinkKt.this.getPageLink().getTextRange(this.$index);
        }
    }

    public final Object getTextRange(int i, @NotNull Continuation<? super Pair<Integer, Integer>> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C04072(i, null), continuation);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.pageLink.close();
    }
}
