package io.legere.pdfiumandroid.suspend;

import android.graphics.RectF;
import io.legere.pdfiumandroid.FindFlags;
import io.legere.pdfiumandroid.FindResult;
import io.legere.pdfiumandroid.Logger;
import io.legere.pdfiumandroid.PdfTextPage;
import io.legere.pdfiumandroid.WordRangeRect;
import java.io.Closeable;
import java.util.List;
import java.util.Set;
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

/* JADX INFO: loaded from: classes.dex */
public final class PdfTextPageKt implements Closeable {
    private final CoroutineDispatcher dispatcher;
    private final PdfTextPage page;

    public PdfTextPageKt(@NotNull PdfTextPage page, @NotNull CoroutineDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(page, "page");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.page = page;
        this.dispatcher = dispatcher;
    }

    public final PdfTextPage getPage() {
        return this.page;
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfTextPageKt$textPageCountChars$2, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfTextPageKt$textPageCountChars$2", f = "PdfTextPageKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C04112 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
        int label;

        C04112(Continuation<? super C04112> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PdfTextPageKt.this.new C04112(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Integer> continuation) {
            return ((C04112) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxInt(PdfTextPageKt.this.getPage().textPageCountChars());
        }
    }

    public final Object textPageCountChars(@NotNull Continuation<? super Integer> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C04112(null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfTextPageKt$textPageGetText$2, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfTextPageKt$textPageGetText$2", f = "PdfTextPageKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C04182 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
        final /* synthetic */ int $length;
        final /* synthetic */ int $startIndex;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04182(int i, int i2, Continuation<? super C04182> continuation) {
            super(2, continuation);
            this.$startIndex = i;
            this.$length = i2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PdfTextPageKt.this.new C04182(this.$startIndex, this.$length, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
            return ((C04182) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return PdfTextPageKt.this.getPage().textPageGetText(this.$startIndex, this.$length);
        }
    }

    public final Object textPageGetText(int i, int i2, @NotNull Continuation<? super String> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C04182(i, i2, null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfTextPageKt$textPageGetUnicode$2, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfTextPageKt$textPageGetUnicode$2", f = "PdfTextPageKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C04192 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Character>, Object> {
        final /* synthetic */ int $index;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04192(int i, Continuation<? super C04192> continuation) {
            super(2, continuation);
            this.$index = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PdfTextPageKt.this.new C04192(this.$index, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Character> continuation) {
            return ((C04192) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxChar(PdfTextPageKt.this.getPage().textPageGetUnicode(this.$index));
        }
    }

    public final Object textPageGetUnicode(int i, @NotNull Continuation<? super Character> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C04192(i, null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfTextPageKt$textPageGetCharBox$2, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfTextPageKt$textPageGetCharBox$2", f = "PdfTextPageKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C04142 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super RectF>, Object> {
        final /* synthetic */ int $index;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04142(int i, Continuation<? super C04142> continuation) {
            super(2, continuation);
            this.$index = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PdfTextPageKt.this.new C04142(this.$index, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super RectF> continuation) {
            return ((C04142) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return PdfTextPageKt.this.getPage().textPageGetCharBox(this.$index);
        }
    }

    public final Object textPageGetCharBox(int i, @NotNull Continuation<? super RectF> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C04142(i, null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfTextPageKt$textPageGetCharIndexAtPos$2, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfTextPageKt$textPageGetCharIndexAtPos$2", f = "PdfTextPageKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C04152 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
        final /* synthetic */ double $x;
        final /* synthetic */ double $xTolerance;
        final /* synthetic */ double $y;
        final /* synthetic */ double $yTolerance;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04152(double d, double d2, double d3, double d4, Continuation<? super C04152> continuation) {
            super(2, continuation);
            this.$x = d;
            this.$y = d2;
            this.$xTolerance = d3;
            this.$yTolerance = d4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PdfTextPageKt.this.new C04152(this.$x, this.$y, this.$xTolerance, this.$yTolerance, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Integer> continuation) {
            return ((C04152) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxInt(PdfTextPageKt.this.getPage().textPageGetCharIndexAtPos(this.$x, this.$y, this.$xTolerance, this.$yTolerance));
        }
    }

    public final Object textPageGetCharIndexAtPos(double d, double d2, double d3, double d4, @NotNull Continuation<? super Integer> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C04152(d, d2, d3, d4, null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfTextPageKt$textPageCountRects$2, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfTextPageKt$textPageCountRects$2", f = "PdfTextPageKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C04122 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
        final /* synthetic */ int $count;
        final /* synthetic */ int $startIndex;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04122(int i, int i2, Continuation<? super C04122> continuation) {
            super(2, continuation);
            this.$startIndex = i;
            this.$count = i2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PdfTextPageKt.this.new C04122(this.$startIndex, this.$count, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Integer> continuation) {
            return ((C04122) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxInt(PdfTextPageKt.this.getPage().textPageCountRects(this.$startIndex, this.$count));
        }
    }

    public final Object textPageCountRects(int i, int i2, @NotNull Continuation<? super Integer> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C04122(i, i2, null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfTextPageKt$textPageGetRect$2, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfTextPageKt$textPageGetRect$2", f = "PdfTextPageKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C04162 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super RectF>, Object> {
        final /* synthetic */ int $rectIndex;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04162(int i, Continuation<? super C04162> continuation) {
            super(2, continuation);
            this.$rectIndex = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PdfTextPageKt.this.new C04162(this.$rectIndex, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super RectF> continuation) {
            return ((C04162) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return PdfTextPageKt.this.getPage().textPageGetRect(this.$rectIndex);
        }
    }

    public final Object textPageGetRect(int i, @NotNull Continuation<? super RectF> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C04162(i, null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfTextPageKt$textPageGetRectsForRanges$2, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfTextPageKt$textPageGetRectsForRanges$2", f = "PdfTextPageKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C04172 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends WordRangeRect>>, Object> {
        final /* synthetic */ int[] $wordRanges;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04172(int[] iArr, Continuation<? super C04172> continuation) {
            super(2, continuation);
            this.$wordRanges = iArr;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PdfTextPageKt.this.new C04172(this.$wordRanges, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends WordRangeRect>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super List<WordRangeRect>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<WordRangeRect>> continuation) {
            return ((C04172) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return PdfTextPageKt.this.getPage().textPageGetRectsForRanges(this.$wordRanges);
        }
    }

    public final Object textPageGetRectsForRanges(@NotNull int[] iArr, @NotNull Continuation<? super List<WordRangeRect>> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C04172(iArr, null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfTextPageKt$textPageGetBoundedText$2, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfTextPageKt$textPageGetBoundedText$2", f = "PdfTextPageKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C04132 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
        final /* synthetic */ int $length;
        final /* synthetic */ RectF $rect;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04132(RectF rectF, int i, Continuation<? super C04132> continuation) {
            super(2, continuation);
            this.$rect = rectF;
            this.$length = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PdfTextPageKt.this.new C04132(this.$rect, this.$length, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
            return ((C04132) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return PdfTextPageKt.this.getPage().textPageGetBoundedText(this.$rect, this.$length);
        }
    }

    public final Object textPageGetBoundedText(@NotNull RectF rectF, int i, @NotNull Continuation<? super String> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C04132(rectF, i, null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfTextPageKt$getFontSize$2, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfTextPageKt$getFontSize$2", f = "PdfTextPageKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C04092 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Double>, Object> {
        final /* synthetic */ int $charIndex;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04092(int i, Continuation<? super C04092> continuation) {
            super(2, continuation);
            this.$charIndex = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PdfTextPageKt.this.new C04092(this.$charIndex, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Double> continuation) {
            return ((C04092) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxDouble(PdfTextPageKt.this.getPage().getFontSize(this.$charIndex));
        }
    }

    public final Object getFontSize(int i, @NotNull Continuation<? super Double> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C04092(i, null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfTextPageKt$findStart$2, reason: invalid class name */
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfTextPageKt$findStart$2", f = "PdfTextPageKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super FindResultKt>, Object> {
        final /* synthetic */ String $findWhat;
        final /* synthetic */ Set<FindFlags> $flags;
        final /* synthetic */ int $startIndex;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(String str, Set<? extends FindFlags> set, int i, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$findWhat = str;
            this.$flags = set;
            this.$startIndex = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PdfTextPageKt.this.new AnonymousClass2(this.$findWhat, this.$flags, this.$startIndex, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super FindResultKt> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            FindResult findResultFindStart = PdfTextPageKt.this.getPage().findStart(this.$findWhat, this.$flags, this.$startIndex);
            if (findResultFindStart == null) {
                return null;
            }
            return new FindResultKt(findResultFindStart, PdfTextPageKt.this.dispatcher);
        }
    }

    public final Object findStart(@NotNull String str, @NotNull Set<? extends FindFlags> set, int i, @NotNull Continuation<? super FindResultKt> continuation) {
        return BuildersKt.withContext(this.dispatcher, new AnonymousClass2(str, set, i, null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfTextPageKt$loadWebLink$2, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfTextPageKt$loadWebLink$2", f = "PdfTextPageKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C04102 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super PdfPageLinkKt>, Object> {
        int label;

        C04102(Continuation<? super C04102> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PdfTextPageKt.this.new C04102(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super PdfPageLinkKt> continuation) {
            return ((C04102) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return new PdfPageLinkKt(PdfTextPageKt.this.getPage().loadWebLink(), PdfTextPageKt.this.dispatcher);
        }
    }

    public final Object loadWebLink(@NotNull Continuation<? super PdfPageLinkKt> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C04102(null), continuation);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.page.close();
    }

    public final boolean safeClose() {
        try {
            this.page.close();
            return true;
        } catch (IllegalStateException e) {
            Logger.INSTANCE.e("PdfTextPageKt", e, "PdfTextPageKt.safeClose");
            return false;
        }
    }
}
