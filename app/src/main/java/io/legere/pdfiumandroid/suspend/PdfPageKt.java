package io.legere.pdfiumandroid.suspend;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.Surface;
import com.facebook.imageutils.JfifUtil;
import io.legere.pdfiumandroid.Logger;
import io.legere.pdfiumandroid.PdfDocument;
import io.legere.pdfiumandroid.PdfPage;
import io.legere.pdfiumandroid.PdfiumCore;
import io.legere.pdfiumandroid.util.Size;
import java.io.Closeable;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.sync.Mutex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class PdfPageKt implements Closeable {
    private final CoroutineDispatcher dispatcher;
    private final PdfPage page;

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageKt$renderPage$1, reason: invalid class name */
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfPageKt", f = "PdfPageKt.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3}, l = {399, 167, 181, 194}, m = "renderPage", n = {"this", "surface", "retValue", "$this$withLock_u24default$iv", "startX", "startY", "drawSizeX", "drawSizeY", "renderAnnot", "canvasColor", "pageBackgroundColor", "this", "retValue", "$this$withLock_u24default$iv", "pointers", "startX", "startY", "drawSizeX", "drawSizeY", "renderAnnot", "canvasColor", "pageBackgroundColor", "retValue", "$this$withLock_u24default$iv", "nativeWindow", "bufferPtr", "retValue", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "I$2", "I$3", "Z$0", "I$4", "I$5", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "I$2", "I$3", "Z$0", "I$4", "I$5", "L$0", "L$1", "J$0", "J$1", "L$0", "L$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        int I$5;
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PdfPageKt.this.renderPage(null, 0, 0, 0, 0, false, 0, 0, this);
        }
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageKt$renderPage$3, reason: invalid class name */
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfPageKt", f = "PdfPageKt.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3}, l = {399, JfifUtil.MARKER_SOS, 235, 249}, m = "renderPage", n = {"this", "surface", "matrix", "clipRect", "retValue", "$this$withLock_u24default$iv", "renderAnnot", "textMask", "canvasColor", "pageBackgroundColor", "this", "surface", "matrix", "clipRect", "retValue", "$this$withLock_u24default$iv", "sizes", "pointers", "renderAnnot", "textMask", "canvasColor", "pageBackgroundColor", "surface", "retValue", "$this$withLock_u24default$iv", "nativeWindow", "bufferPtr", "retValue", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0", "Z$1", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "Z$0", "Z$1", "I$0", "I$1", "L$0", "L$1", "L$2", "J$0", "J$1", "L$0", "L$1"})
    static final class AnonymousClass3 extends ContinuationImpl {
        int I$0;
        int I$1;
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        boolean Z$0;
        boolean Z$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PdfPageKt.this.renderPage(null, null, null, false, false, 0, 0, this);
        }
    }

    public PdfPageKt(@NotNull PdfPage page, @NotNull CoroutineDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(page, "page");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.page = page;
        this.dispatcher = dispatcher;
    }

    public final PdfPage getPage() {
        return this.page;
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageKt$openTextPage$2, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfPageKt$openTextPage$2", f = "PdfPageKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C04032 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super PdfTextPageKt>, Object> {
        int label;

        C04032(Continuation<? super C04032> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PdfPageKt.this.new C04032(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super PdfTextPageKt> continuation) {
            return ((C04032) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return new PdfTextPageKt(PdfPageKt.this.getPage().openTextPage(), PdfPageKt.this.dispatcher);
        }
    }

    public final Object openTextPage(@NotNull Continuation<? super PdfTextPageKt> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C04032(null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageKt$getPageWidth$2, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfPageKt$getPageWidth$2", f = "PdfPageKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C03972 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
        final /* synthetic */ int $screenDpi;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03972(int i, Continuation<? super C03972> continuation) {
            super(2, continuation);
            this.$screenDpi = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PdfPageKt.this.new C03972(this.$screenDpi, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Integer> continuation) {
            return ((C03972) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxInt(PdfPageKt.this.getPage().getPageWidth(this.$screenDpi));
        }
    }

    public final Object getPageWidth(int i, @NotNull Continuation<? super Integer> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C03972(i, null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageKt$getPageHeight$2, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfPageKt$getPageHeight$2", f = "PdfPageKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C03892 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
        final /* synthetic */ int $screenDpi;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03892(int i, Continuation<? super C03892> continuation) {
            super(2, continuation);
            this.$screenDpi = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PdfPageKt.this.new C03892(this.$screenDpi, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Integer> continuation) {
            return ((C03892) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxInt(PdfPageKt.this.getPage().getPageHeight(this.$screenDpi));
        }
    }

    public final Object getPageHeight(int i, @NotNull Continuation<? super Integer> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C03892(i, null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageKt$getPageWidthPoint$2, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfPageKt$getPageWidthPoint$2", f = "PdfPageKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C03982 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
        int label;

        C03982(Continuation<? super C03982> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PdfPageKt.this.new C03982(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Integer> continuation) {
            return ((C03982) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxInt(PdfPageKt.this.getPage().getPageWidthPoint());
        }
    }

    public final Object getPageWidthPoint(@NotNull Continuation<? super Integer> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C03982(null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageKt$getPageHeightPoint$2, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfPageKt$getPageHeightPoint$2", f = "PdfPageKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C03902 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
        int label;

        C03902(Continuation<? super C03902> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PdfPageKt.this.new C03902(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Integer> continuation) {
            return ((C03902) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxInt(PdfPageKt.this.getPage().getPageHeightPoint());
        }
    }

    public final Object getPageHeightPoint(@NotNull Continuation<? super Integer> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C03902(null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageKt$getPageMatrix$2, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfPageKt$getPageMatrix$2", f = "PdfPageKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C03922 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Matrix>, Object> {
        int label;

        C03922(Continuation<? super C03922> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PdfPageKt.this.new C03922(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Matrix> continuation) {
            return ((C03922) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return PdfPageKt.this.getPage().getPageMatrix();
        }
    }

    public final Object getPageMatrix(@NotNull Continuation<? super Matrix> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C03922(null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageKt$getPageRotation$2, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfPageKt$getPageRotation$2", f = "PdfPageKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C03942 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
        int label;

        C03942(Continuation<? super C03942> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PdfPageKt.this.new C03942(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Integer> continuation) {
            return ((C03942) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxInt(PdfPageKt.this.getPage().getPageRotation());
        }
    }

    public final Object getPageRotation(@NotNull Continuation<? super Integer> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C03942(null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageKt$getPageCropBox$2, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfPageKt$getPageCropBox$2", f = "PdfPageKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C03882 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super RectF>, Object> {
        int label;

        C03882(Continuation<? super C03882> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PdfPageKt.this.new C03882(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super RectF> continuation) {
            return ((C03882) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return PdfPageKt.this.getPage().getPageCropBox();
        }
    }

    public final Object getPageCropBox(@NotNull Continuation<? super RectF> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C03882(null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageKt$getPageMediaBox$2, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfPageKt$getPageMediaBox$2", f = "PdfPageKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C03932 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super RectF>, Object> {
        int label;

        C03932(Continuation<? super C03932> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PdfPageKt.this.new C03932(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super RectF> continuation) {
            return ((C03932) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return PdfPageKt.this.getPage().getPageMediaBox();
        }
    }

    public final Object getPageMediaBox(@NotNull Continuation<? super RectF> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C03932(null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageKt$getPageBleedBox$2, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfPageKt$getPageBleedBox$2", f = "PdfPageKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C03862 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super RectF>, Object> {
        int label;

        C03862(Continuation<? super C03862> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PdfPageKt.this.new C03862(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super RectF> continuation) {
            return ((C03862) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return PdfPageKt.this.getPage().getPageBleedBox();
        }
    }

    public final Object getPageBleedBox(@NotNull Continuation<? super RectF> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C03862(null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageKt$getPageTrimBox$2, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfPageKt$getPageTrimBox$2", f = "PdfPageKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C03962 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super RectF>, Object> {
        int label;

        C03962(Continuation<? super C03962> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PdfPageKt.this.new C03962(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super RectF> continuation) {
            return ((C03962) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return PdfPageKt.this.getPage().getPageTrimBox();
        }
    }

    public final Object getPageTrimBox(@NotNull Continuation<? super RectF> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C03962(null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageKt$getPageArtBox$2, reason: invalid class name */
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfPageKt$getPageArtBox$2", f = "PdfPageKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super RectF>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PdfPageKt.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super RectF> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return PdfPageKt.this.getPage().getPageArtBox();
        }
    }

    public final Object getPageArtBox(@NotNull Continuation<? super RectF> continuation) {
        return BuildersKt.withContext(this.dispatcher, new AnonymousClass2(null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageKt$getPageBoundingBox$2, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfPageKt$getPageBoundingBox$2", f = "PdfPageKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C03872 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super RectF>, Object> {
        int label;

        C03872(Continuation<? super C03872> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PdfPageKt.this.new C03872(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super RectF> continuation) {
            return ((C03872) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return PdfPageKt.this.getPage().getPageBoundingBox();
        }
    }

    public final Object getPageBoundingBox(@NotNull Continuation<? super RectF> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C03872(null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageKt$getPageSize$2, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfPageKt$getPageSize$2", f = "PdfPageKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C03952 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Size>, Object> {
        final /* synthetic */ int $screenDpi;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03952(int i, Continuation<? super C03952> continuation) {
            super(2, continuation);
            this.$screenDpi = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PdfPageKt.this.new C03952(this.$screenDpi, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Size> continuation) {
            return ((C03952) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return PdfPageKt.this.getPage().getPageSize(this.$screenDpi);
        }
    }

    public final Object getPageSize(int i, @NotNull Continuation<? super Size> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C03952(i, null), continuation);
    }

    /* JADX WARN: Code duplicated, block: B:51:0x0199 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:54:0x01b9 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:55:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object, kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v6, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r4v0, types: [int] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v17, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [kotlinx.coroutines.sync.Mutex] */
    public final Object renderPage(@Nullable Surface surface, int i, int i2, int i3, int i4, boolean z, int i5, int i6, @NotNull Continuation<? super Boolean> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        ?? r5;
        Mutex surfaceMutex;
        int i7;
        int i8;
        int i9;
        int i10;
        boolean z2;
        int i11;
        int i12;
        Ref.BooleanRef booleanRef;
        PdfPageKt pdfPageKt;
        Surface surface2;
        int i13;
        Object obj;
        long[] jArr;
        ?? r3;
        int i14;
        int i15;
        int i16;
        int i17;
        boolean z3;
        int i18;
        int i19;
        Ref.BooleanRef booleanRef2;
        PdfPageKt pdfPageKt2;
        long j;
        long j2;
        CoroutineDispatcher coroutineDispatcher;
        PdfPageKt$renderPage$2$2 pdfPageKt$renderPage$2$2;
        ?? r4;
        MainCoroutineDispatcher main;
        PdfPageKt$renderPage$2$3 pdfPageKt$renderPage$2$3;
        Ref.BooleanRef booleanRef3;
        ?? r6;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i20 = anonymousClass1.label;
            if ((i20 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i20 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj2 = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r7 = anonymousClass1.label;
        try {
            try {
                if (r7 == 0) {
                    ResultKt.throwOnFailure(obj2);
                    Ref.BooleanRef booleanRef4 = new Ref.BooleanRef();
                    surfaceMutex = PdfiumCore.Companion.getSurfaceMutex();
                    anonymousClass1.L$0 = this;
                    anonymousClass1.L$1 = surface;
                    anonymousClass1.L$2 = booleanRef4;
                    anonymousClass1.L$3 = surfaceMutex;
                    i7 = i;
                    anonymousClass1.I$0 = i7;
                    i8 = i2;
                    anonymousClass1.I$1 = i8;
                    i9 = i3;
                    anonymousClass1.I$2 = i9;
                    i10 = i4;
                    anonymousClass1.I$3 = i10;
                    z2 = z;
                    anonymousClass1.Z$0 = z2;
                    i11 = i5;
                    anonymousClass1.I$4 = i11;
                    i12 = i6;
                    anonymousClass1.I$5 = i12;
                    anonymousClass1.label = 1;
                    if (surfaceMutex.lock(null, anonymousClass1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    booleanRef = booleanRef4;
                    pdfPageKt = this;
                    surface2 = surface;
                    i13 = 2;
                } else {
                    if (r7 == 1) {
                        int i21 = anonymousClass1.I$5;
                        int i22 = anonymousClass1.I$4;
                        boolean z4 = anonymousClass1.Z$0;
                        int i23 = anonymousClass1.I$3;
                        int i24 = anonymousClass1.I$2;
                        int i25 = anonymousClass1.I$1;
                        int i26 = anonymousClass1.I$0;
                        Mutex mutex = (Mutex) anonymousClass1.L$3;
                        booleanRef = (Ref.BooleanRef) anonymousClass1.L$2;
                        surface2 = (Surface) anonymousClass1.L$1;
                        PdfPageKt pdfPageKt3 = (PdfPageKt) anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj2);
                        pdfPageKt = pdfPageKt3;
                        i8 = i25;
                        z2 = z4;
                        i7 = i26;
                        i11 = i22;
                        i13 = 2;
                        i12 = i21;
                        surfaceMutex = mutex;
                        i10 = i23;
                        i9 = i24;
                    } else {
                        if (r7 == 2) {
                            int i27 = anonymousClass1.I$5;
                            int i28 = anonymousClass1.I$4;
                            boolean z5 = anonymousClass1.Z$0;
                            int i29 = anonymousClass1.I$3;
                            int i30 = anonymousClass1.I$2;
                            int i31 = anonymousClass1.I$1;
                            int i32 = anonymousClass1.I$0;
                            jArr = (long[]) anonymousClass1.L$3;
                            r5 = (Mutex) anonymousClass1.L$2;
                            booleanRef2 = (Ref.BooleanRef) anonymousClass1.L$1;
                            pdfPageKt2 = (PdfPageKt) anonymousClass1.L$0;
                            try {
                                ResultKt.throwOnFailure(obj2);
                                i19 = i27;
                                i18 = i28;
                                z3 = z5;
                                i17 = i29;
                                i16 = i30;
                                i15 = i31;
                                i14 = i32;
                                obj = coroutine_suspended;
                                r3 = r5;
                                j = jArr[0];
                                j2 = jArr[1];
                                if (j2 != 0 && j2 != -1 && j != 0 && j != -1) {
                                    coroutineDispatcher = pdfPageKt2.dispatcher;
                                    pdfPageKt$renderPage$2$2 = new PdfPageKt$renderPage$2$2(booleanRef2, pdfPageKt2, j2, i14, i15, i16, i17, z3, i18, i19, null);
                                    anonymousClass1.L$0 = booleanRef2;
                                    anonymousClass1.L$1 = r3;
                                    anonymousClass1.L$2 = null;
                                    anonymousClass1.L$3 = null;
                                    anonymousClass1.J$0 = j;
                                    anonymousClass1.J$1 = j2;
                                    anonymousClass1.label = 3;
                                    if (BuildersKt.withContext(coroutineDispatcher, pdfPageKt$renderPage$2$2, anonymousClass1) == obj) {
                                        r4 = r3;
                                        return obj;
                                    }
                                    r4 = r3;
                                    main = Dispatchers.getMain();
                                    pdfPageKt$renderPage$2$3 = new PdfPageKt$renderPage$2$3(j, j2, null);
                                    anonymousClass1.L$0 = booleanRef2;
                                    anonymousClass1.L$1 = r4;
                                    anonymousClass1.label = 4;
                                    if (BuildersKt.withContext(main, pdfPageKt$renderPage$2$3, anonymousClass1) == obj) {
                                        return obj;
                                    }
                                    booleanRef3 = booleanRef2;
                                    r6 = r4;
                                }
                                Boolean boolBoxBoolean = Boxing.boxBoolean(false);
                                r3.unlock(null);
                                return boolBoxBoolean;
                            } catch (Throwable th) {
                                th = th;
                                r5.unlock(null);
                                throw th;
                            }
                        }
                        if (r7 == 3) {
                            long j3 = anonymousClass1.J$1;
                            j = anonymousClass1.J$0;
                            Mutex mutex2 = (Mutex) anonymousClass1.L$1;
                            Ref.BooleanRef booleanRef5 = (Ref.BooleanRef) anonymousClass1.L$0;
                            ResultKt.throwOnFailure(obj2);
                            obj = coroutine_suspended;
                            r4 = mutex2;
                            booleanRef2 = booleanRef5;
                            j2 = j3;
                            r4 = r3;
                            main = Dispatchers.getMain();
                            pdfPageKt$renderPage$2$3 = new PdfPageKt$renderPage$2$3(j, j2, null);
                            anonymousClass1.L$0 = booleanRef2;
                            anonymousClass1.L$1 = r4;
                            anonymousClass1.label = 4;
                            if (BuildersKt.withContext(main, pdfPageKt$renderPage$2$3, anonymousClass1) == obj) {
                                return obj;
                            }
                            booleanRef3 = booleanRef2;
                            r6 = r4;
                        } else {
                            if (r7 != 4) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            Mutex mutex3 = (Mutex) anonymousClass1.L$1;
                            booleanRef3 = (Ref.BooleanRef) anonymousClass1.L$0;
                            ResultKt.throwOnFailure(obj2);
                            r6 = mutex3;
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                    r6.unlock(null);
                    return Boxing.boxBoolean(booleanRef3.element);
                }
                int[] iArr = new int[i13];
                long[] jArr2 = new long[i13];
                MainCoroutineDispatcher main2 = Dispatchers.getMain();
                PdfPageKt$renderPage$2$1 pdfPageKt$renderPage$2$1 = new PdfPageKt$renderPage$2$1(surface2, iArr, jArr2, null);
                anonymousClass1.L$0 = pdfPageKt;
                anonymousClass1.L$1 = booleanRef;
                anonymousClass1.L$2 = surfaceMutex;
                anonymousClass1.L$3 = jArr2;
                anonymousClass1.I$0 = i7;
                anonymousClass1.I$1 = i8;
                anonymousClass1.I$2 = i9;
                anonymousClass1.I$3 = i10;
                anonymousClass1.Z$0 = z2;
                anonymousClass1.I$4 = i11;
                anonymousClass1.I$5 = i12;
                anonymousClass1.label = 2;
                Object objWithContext = BuildersKt.withContext(main2, pdfPageKt$renderPage$2$1, anonymousClass1);
                obj = coroutine_suspended;
                if (objWithContext == obj) {
                    return obj;
                }
                jArr = jArr2;
                r3 = surfaceMutex;
                i14 = i7;
                i15 = i8;
                i16 = i9;
                i17 = i10;
                z3 = z2;
                i18 = i11;
                i19 = i12;
                booleanRef2 = booleanRef;
                pdfPageKt2 = pdfPageKt;
                j = jArr[0];
                j2 = jArr[1];
                if (j2 != 0) {
                    coroutineDispatcher = pdfPageKt2.dispatcher;
                    pdfPageKt$renderPage$2$2 = new PdfPageKt$renderPage$2$2(booleanRef2, pdfPageKt2, j2, i14, i15, i16, i17, z3, i18, i19, null);
                    anonymousClass1.L$0 = booleanRef2;
                    anonymousClass1.L$1 = r3;
                    anonymousClass1.L$2 = null;
                    anonymousClass1.L$3 = null;
                    anonymousClass1.J$0 = j;
                    anonymousClass1.J$1 = j2;
                    anonymousClass1.label = 3;
                    if (BuildersKt.withContext(coroutineDispatcher, pdfPageKt$renderPage$2$2, anonymousClass1) == obj) {
                        r4 = r3;
                        return obj;
                    }
                    r4 = r3;
                    main = Dispatchers.getMain();
                    pdfPageKt$renderPage$2$3 = new PdfPageKt$renderPage$2$3(j, j2, null);
                    anonymousClass1.L$0 = booleanRef2;
                    anonymousClass1.L$1 = r4;
                    anonymousClass1.label = 4;
                    if (BuildersKt.withContext(main, pdfPageKt$renderPage$2$3, anonymousClass1) == obj) {
                        return obj;
                    }
                    booleanRef3 = booleanRef2;
                    r6 = r4;
                    Unit unit2 = Unit.INSTANCE;
                    r6.unlock(null);
                    return Boxing.boxBoolean(booleanRef3.element);
                }
                Boolean boolBoxBoolean2 = Boxing.boxBoolean(false);
                r3.unlock(null);
                return boolBoxBoolean2;
            } catch (Throwable th2) {
                th = th2;
                r5 = coroutine_suspended;
            }
        } catch (Throwable th3) {
            th = th3;
            r5 = r7;
        }
    }

    /* JADX WARN: Code duplicated, block: B:53:0x01bb A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:54:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:57:0x01e1 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:58:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [int] */
    /* JADX WARN: Type inference failed for: r4v1, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v6 */
    public final Object renderPage(@Nullable Surface surface, @NotNull Matrix matrix, @NotNull RectF rectF, boolean z, boolean z2, int i, int i2, @NotNull Continuation<? super Boolean> continuation) throws Throwable {
        AnonymousClass3 anonymousClass3;
        RectF rectF2;
        boolean z3;
        boolean z4;
        int i3;
        Ref.BooleanRef booleanRef;
        PdfPageKt pdfPageKt;
        Surface surface2;
        Mutex mutex;
        int i4;
        Matrix matrix2;
        int i5;
        Mutex mutex2;
        RectF rectF3;
        boolean z5;
        boolean z6;
        int i6;
        Matrix matrix3;
        Surface surface3;
        PdfPageKt pdfPageKt2;
        int[] iArr;
        long[] jArr;
        long j;
        long j2;
        int i7;
        int i8;
        CoroutineDispatcher coroutineDispatcher;
        PdfPageKt$renderPage$4$2 pdfPageKt$renderPage$4$2;
        Ref.BooleanRef booleanRef2;
        Object obj;
        Mutex mutex3;
        Ref.BooleanRef booleanRef3;
        if (continuation instanceof AnonymousClass3) {
            anonymousClass3 = (AnonymousClass3) continuation;
            int i9 = anonymousClass3.label;
            if ((i9 & Integer.MIN_VALUE) != 0) {
                anonymousClass3.label = i9 - Integer.MIN_VALUE;
            } else {
                anonymousClass3 = new AnonymousClass3(continuation);
            }
        } else {
            anonymousClass3 = new AnonymousClass3(continuation);
        }
        Object objWithContext = anonymousClass3.result;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r4 = anonymousClass3.label;
        try {
            try {
                if (r4 == 0) {
                    ResultKt.throwOnFailure(objWithContext);
                    Ref.BooleanRef booleanRef4 = new Ref.BooleanRef();
                    Mutex surfaceMutex = PdfiumCore.Companion.getSurfaceMutex();
                    anonymousClass3.L$0 = this;
                    anonymousClass3.L$1 = surface;
                    anonymousClass3.L$2 = matrix;
                    rectF2 = rectF;
                    anonymousClass3.L$3 = rectF2;
                    anonymousClass3.L$4 = booleanRef4;
                    anonymousClass3.L$5 = surfaceMutex;
                    z3 = z;
                    anonymousClass3.Z$0 = z3;
                    z4 = z2;
                    anonymousClass3.Z$1 = z4;
                    i3 = i;
                    anonymousClass3.I$0 = i3;
                    anonymousClass3.I$1 = i2;
                    anonymousClass3.label = 1;
                    if (surfaceMutex.lock(null, anonymousClass3) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    booleanRef = booleanRef4;
                    pdfPageKt = this;
                    surface2 = surface;
                    mutex = surfaceMutex;
                    i4 = i2;
                    matrix2 = matrix;
                } else {
                    if (r4 != 1) {
                        if (r4 != 2) {
                            if (r4 != 3) {
                                if (r4 != 4) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                mutex3 = (Mutex) anonymousClass3.L$1;
                                booleanRef3 = (Ref.BooleanRef) anonymousClass3.L$0;
                                try {
                                    ResultKt.throwOnFailure(objWithContext);
                                    obj = null;
                                    mutex3.unlock(obj);
                                    return Boxing.boxBoolean(booleanRef3.element);
                                } catch (Throwable th) {
                                    th = th;
                                    r4 = mutex3;
                                    r4.unlock(null);
                                    throw th;
                                }
                            }
                            j2 = anonymousClass3.J$1;
                            j = anonymousClass3.J$0;
                            mutex2 = (Mutex) anonymousClass3.L$2;
                            booleanRef2 = (Ref.BooleanRef) anonymousClass3.L$1;
                            Surface surface4 = (Surface) anonymousClass3.L$0;
                            ResultKt.throwOnFailure(objWithContext);
                            surface3 = surface4;
                            MainCoroutineDispatcher main = Dispatchers.getMain();
                            PdfPageKt$renderPage$4$3 pdfPageKt$renderPage$4$3 = new PdfPageKt$renderPage$4$3(surface3, j, j2, null);
                            anonymousClass3.L$0 = booleanRef2;
                            anonymousClass3.L$1 = mutex2;
                            obj = null;
                            anonymousClass3.L$2 = null;
                            anonymousClass3.label = 4;
                            objWithContext = BuildersKt.withContext(main, pdfPageKt$renderPage$4$3, anonymousClass3);
                            if (objWithContext == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            mutex3 = mutex2;
                            booleanRef3 = booleanRef2;
                            mutex3.unlock(obj);
                            return Boxing.boxBoolean(booleanRef3.element);
                        }
                        int i10 = anonymousClass3.I$1;
                        int i11 = anonymousClass3.I$0;
                        boolean z7 = anonymousClass3.Z$1;
                        boolean z8 = anonymousClass3.Z$0;
                        jArr = (long[]) anonymousClass3.L$7;
                        iArr = (int[]) anonymousClass3.L$6;
                        Mutex mutex4 = (Mutex) anonymousClass3.L$5;
                        booleanRef = (Ref.BooleanRef) anonymousClass3.L$4;
                        RectF rectF4 = (RectF) anonymousClass3.L$3;
                        Matrix matrix4 = (Matrix) anonymousClass3.L$2;
                        surface3 = (Surface) anonymousClass3.L$1;
                        pdfPageKt2 = (PdfPageKt) anonymousClass3.L$0;
                        try {
                            ResultKt.throwOnFailure(objWithContext);
                            i5 = i10;
                            rectF3 = rectF4;
                            matrix3 = matrix4;
                            i6 = i11;
                            z6 = z7;
                            z5 = z8;
                            mutex2 = mutex4;
                            j = jArr[0];
                            j2 = jArr[1];
                            i7 = iArr[0];
                            i8 = iArr[1];
                            Logger.INSTANCE.d("PdfPageKt", "nativeWindow: " + j);
                            if (j2 != 0 && j2 != -1 && j != 0 && j != -1) {
                                coroutineDispatcher = pdfPageKt2.dispatcher;
                                pdfPageKt$renderPage$4$2 = new PdfPageKt$renderPage$4$2(booleanRef, pdfPageKt2, j2, i7, i8, matrix3, rectF3, z5, z6, i6, i5, null);
                                anonymousClass3.L$0 = surface3;
                                anonymousClass3.L$1 = booleanRef;
                                anonymousClass3.L$2 = mutex2;
                                anonymousClass3.L$3 = null;
                                anonymousClass3.L$4 = null;
                                anonymousClass3.L$5 = null;
                                anonymousClass3.L$6 = null;
                                anonymousClass3.L$7 = null;
                                anonymousClass3.J$0 = j;
                                anonymousClass3.J$1 = j2;
                                anonymousClass3.label = 3;
                                if (BuildersKt.withContext(coroutineDispatcher, pdfPageKt$renderPage$4$2, anonymousClass3) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                booleanRef2 = booleanRef;
                                MainCoroutineDispatcher main2 = Dispatchers.getMain();
                                PdfPageKt$renderPage$4$3 pdfPageKt$renderPage$4$4 = new PdfPageKt$renderPage$4$3(surface3, j, j2, null);
                                anonymousClass3.L$0 = booleanRef2;
                                anonymousClass3.L$1 = mutex2;
                                obj = null;
                                anonymousClass3.L$2 = null;
                                anonymousClass3.label = 4;
                                objWithContext = BuildersKt.withContext(main2, pdfPageKt$renderPage$4$4, anonymousClass3);
                                if (objWithContext == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                mutex3 = mutex2;
                                booleanRef3 = booleanRef2;
                                mutex3.unlock(obj);
                                return Boxing.boxBoolean(booleanRef3.element);
                            }
                            Boolean boolBoxBoolean = Boxing.boxBoolean(false);
                            mutex2.unlock(null);
                            return boolBoxBoolean;
                        } catch (Throwable th2) {
                            th = th2;
                            r4 = mutex4;
                            r4.unlock(null);
                            throw th;
                        }
                    }
                    i4 = anonymousClass3.I$1;
                    int i12 = anonymousClass3.I$0;
                    boolean z9 = anonymousClass3.Z$1;
                    boolean z10 = anonymousClass3.Z$0;
                    Mutex mutex5 = (Mutex) anonymousClass3.L$5;
                    Ref.BooleanRef booleanRef5 = (Ref.BooleanRef) anonymousClass3.L$4;
                    RectF rectF5 = (RectF) anonymousClass3.L$3;
                    matrix2 = (Matrix) anonymousClass3.L$2;
                    surface2 = (Surface) anonymousClass3.L$1;
                    pdfPageKt = (PdfPageKt) anonymousClass3.L$0;
                    ResultKt.throwOnFailure(objWithContext);
                    booleanRef = booleanRef5;
                    z4 = z9;
                    i3 = i12;
                    mutex = mutex5;
                    z3 = z10;
                    rectF2 = rectF5;
                }
                int[] iArr2 = new int[2];
                long[] jArr2 = new long[2];
                MainCoroutineDispatcher main3 = Dispatchers.getMain();
                PdfPageKt$renderPage$4$1 pdfPageKt$renderPage$4$1 = new PdfPageKt$renderPage$4$1(surface2, iArr2, jArr2, null);
                anonymousClass3.L$0 = pdfPageKt;
                anonymousClass3.L$1 = surface2;
                anonymousClass3.L$2 = matrix2;
                anonymousClass3.L$3 = rectF2;
                anonymousClass3.L$4 = booleanRef;
                anonymousClass3.L$5 = mutex;
                anonymousClass3.L$6 = iArr2;
                anonymousClass3.L$7 = jArr2;
                anonymousClass3.Z$0 = z3;
                anonymousClass3.Z$1 = z4;
                anonymousClass3.I$0 = i3;
                anonymousClass3.I$1 = i4;
                anonymousClass3.label = 2;
                coroutine_suspended = coroutine_suspended;
                if (BuildersKt.withContext(main3, pdfPageKt$renderPage$4$1, anonymousClass3) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                i5 = i4;
                mutex2 = mutex;
                rectF3 = rectF2;
                z5 = z3;
                z6 = z4;
                i6 = i3;
                matrix3 = matrix2;
                surface3 = surface2;
                pdfPageKt2 = pdfPageKt;
                iArr = iArr2;
                jArr = jArr2;
                j = jArr[0];
                j2 = jArr[1];
                i7 = iArr[0];
                i8 = iArr[1];
                Logger.INSTANCE.d("PdfPageKt", "nativeWindow: " + j);
                if (j2 != 0) {
                    coroutineDispatcher = pdfPageKt2.dispatcher;
                    pdfPageKt$renderPage$4$2 = new PdfPageKt$renderPage$4$2(booleanRef, pdfPageKt2, j2, i7, i8, matrix3, rectF3, z5, z6, i6, i5, null);
                    anonymousClass3.L$0 = surface3;
                    anonymousClass3.L$1 = booleanRef;
                    anonymousClass3.L$2 = mutex2;
                    anonymousClass3.L$3 = null;
                    anonymousClass3.L$4 = null;
                    anonymousClass3.L$5 = null;
                    anonymousClass3.L$6 = null;
                    anonymousClass3.L$7 = null;
                    anonymousClass3.J$0 = j;
                    anonymousClass3.J$1 = j2;
                    anonymousClass3.label = 3;
                    if (BuildersKt.withContext(coroutineDispatcher, pdfPageKt$renderPage$4$2, anonymousClass3) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    booleanRef2 = booleanRef;
                    MainCoroutineDispatcher main4 = Dispatchers.getMain();
                    PdfPageKt$renderPage$4$3 pdfPageKt$renderPage$4$5 = new PdfPageKt$renderPage$4$3(surface3, j, j2, null);
                    anonymousClass3.L$0 = booleanRef2;
                    anonymousClass3.L$1 = mutex2;
                    obj = null;
                    anonymousClass3.L$2 = null;
                    anonymousClass3.label = 4;
                    objWithContext = BuildersKt.withContext(main4, pdfPageKt$renderPage$4$5, anonymousClass3);
                    if (objWithContext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    mutex3 = mutex2;
                    booleanRef3 = booleanRef2;
                    mutex3.unlock(obj);
                    return Boxing.boxBoolean(booleanRef3.element);
                }
                Boolean boolBoxBoolean2 = Boxing.boxBoolean(false);
                mutex2.unlock(null);
                return boolBoxBoolean2;
            } catch (Throwable th3) {
                th = th3;
                r4 = mutex;
                r4.unlock(null);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageKt$renderPageBitmap$2, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfPageKt$renderPageBitmap$2", f = "PdfPageKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C04042 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Bitmap $bitmap;
        final /* synthetic */ int $canvasColor;
        final /* synthetic */ int $drawSizeX;
        final /* synthetic */ int $drawSizeY;
        final /* synthetic */ int $pageBackgroundColor;
        final /* synthetic */ boolean $renderAnnot;
        final /* synthetic */ int $startX;
        final /* synthetic */ int $startY;
        final /* synthetic */ boolean $textMask;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04042(Bitmap bitmap, int i, int i2, int i3, int i4, boolean z, boolean z2, int i5, int i6, Continuation<? super C04042> continuation) {
            super(2, continuation);
            this.$bitmap = bitmap;
            this.$startX = i;
            this.$startY = i2;
            this.$drawSizeX = i3;
            this.$drawSizeY = i4;
            this.$renderAnnot = z;
            this.$textMask = z2;
            this.$canvasColor = i5;
            this.$pageBackgroundColor = i6;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PdfPageKt.this.new C04042(this.$bitmap, this.$startX, this.$startY, this.$drawSizeX, this.$drawSizeY, this.$renderAnnot, this.$textMask, this.$canvasColor, this.$pageBackgroundColor, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04042) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            PdfPageKt.this.getPage().renderPageBitmap(this.$bitmap, this.$startX, this.$startY, this.$drawSizeX, this.$drawSizeY, this.$renderAnnot, this.$textMask, this.$canvasColor, this.$pageBackgroundColor);
            return Unit.INSTANCE;
        }
    }

    public final Object renderPageBitmap(@NotNull Bitmap bitmap, int i, int i2, int i3, int i4, boolean z, boolean z2, int i5, int i6, @NotNull Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(this.dispatcher, new C04042(bitmap, i, i2, i3, i4, z, z2, i5, i6, null), continuation);
        return objWithContext == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageKt$renderPageBitmap$4, reason: invalid class name */
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfPageKt$renderPageBitmap$4", f = "PdfPageKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Bitmap $bitmap;
        final /* synthetic */ int $canvasColor;
        final /* synthetic */ RectF $clipRect;
        final /* synthetic */ Matrix $matrix;
        final /* synthetic */ int $pageBackgroundColor;
        final /* synthetic */ boolean $renderAnnot;
        final /* synthetic */ boolean $textMask;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(Bitmap bitmap, Matrix matrix, RectF rectF, boolean z, boolean z2, int i, int i2, Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
            this.$bitmap = bitmap;
            this.$matrix = matrix;
            this.$clipRect = rectF;
            this.$renderAnnot = z;
            this.$textMask = z2;
            this.$canvasColor = i;
            this.$pageBackgroundColor = i2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PdfPageKt.this.new AnonymousClass4(this.$bitmap, this.$matrix, this.$clipRect, this.$renderAnnot, this.$textMask, this.$canvasColor, this.$pageBackgroundColor, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            PdfPageKt.this.getPage().renderPageBitmap(this.$bitmap, this.$matrix, this.$clipRect, this.$renderAnnot, this.$textMask, this.$canvasColor, this.$pageBackgroundColor);
            return Unit.INSTANCE;
        }
    }

    public final Object renderPageBitmap(@Nullable Bitmap bitmap, @NotNull Matrix matrix, @NotNull RectF rectF, boolean z, boolean z2, int i, int i2, @NotNull Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(this.dispatcher, new AnonymousClass4(bitmap, matrix, rectF, z, z2, i, i2, null), continuation);
        return objWithContext == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageKt$getPageLinks$2, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfPageKt$getPageLinks$2", f = "PdfPageKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C03912 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends PdfDocument.Link>>, Object> {
        int label;

        C03912(Continuation<? super C03912> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PdfPageKt.this.new C03912(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends PdfDocument.Link>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super List<PdfDocument.Link>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<PdfDocument.Link>> continuation) {
            return ((C03912) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return PdfPageKt.this.getPage().getPageLinks();
        }
    }

    public final Object getPageLinks(@NotNull Continuation<? super List<PdfDocument.Link>> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C03912(null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageKt$mapPageCoordsToDevice$2, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfPageKt$mapPageCoordsToDevice$2", f = "PdfPageKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C04002 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Point>, Object> {
        final /* synthetic */ double $pageX;
        final /* synthetic */ double $pageY;
        final /* synthetic */ int $rotate;
        final /* synthetic */ int $sizeX;
        final /* synthetic */ int $sizeY;
        final /* synthetic */ int $startX;
        final /* synthetic */ int $startY;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04002(int i, int i2, int i3, int i4, int i5, double d, double d2, Continuation<? super C04002> continuation) {
            super(2, continuation);
            this.$startX = i;
            this.$startY = i2;
            this.$sizeX = i3;
            this.$sizeY = i4;
            this.$rotate = i5;
            this.$pageX = d;
            this.$pageY = d2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PdfPageKt.this.new C04002(this.$startX, this.$startY, this.$sizeX, this.$sizeY, this.$rotate, this.$pageX, this.$pageY, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Point> continuation) {
            return ((C04002) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return PdfPageKt.this.getPage().mapPageCoordsToDevice(this.$startX, this.$startY, this.$sizeX, this.$sizeY, this.$rotate, this.$pageX, this.$pageY);
        }
    }

    public final Object mapPageCoordsToDevice(int i, int i2, int i3, int i4, int i5, double d, double d2, @NotNull Continuation<? super Point> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C04002(i, i2, i3, i4, i5, d, d2, null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageKt$mapDeviceCoordsToPage$2, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfPageKt$mapDeviceCoordsToPage$2", f = "PdfPageKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C03992 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super PointF>, Object> {
        final /* synthetic */ int $deviceX;
        final /* synthetic */ int $deviceY;
        final /* synthetic */ int $rotate;
        final /* synthetic */ int $sizeX;
        final /* synthetic */ int $sizeY;
        final /* synthetic */ int $startX;
        final /* synthetic */ int $startY;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03992(int i, int i2, int i3, int i4, int i5, int i6, int i7, Continuation<? super C03992> continuation) {
            super(2, continuation);
            this.$startX = i;
            this.$startY = i2;
            this.$sizeX = i3;
            this.$sizeY = i4;
            this.$rotate = i5;
            this.$deviceX = i6;
            this.$deviceY = i7;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PdfPageKt.this.new C03992(this.$startX, this.$startY, this.$sizeX, this.$sizeY, this.$rotate, this.$deviceX, this.$deviceY, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super PointF> continuation) {
            return ((C03992) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return PdfPageKt.this.getPage().mapDeviceCoordsToPage(this.$startX, this.$startY, this.$sizeX, this.$sizeY, this.$rotate, this.$deviceX, this.$deviceY);
        }
    }

    public final Object mapDeviceCoordsToPage(int i, int i2, int i3, int i4, int i5, int i6, int i7, @NotNull Continuation<? super PointF> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C03992(i, i2, i3, i4, i5, i6, i7, null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageKt$mapRectToDevice$2, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfPageKt$mapRectToDevice$2", f = "PdfPageKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C04012 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Rect>, Object> {
        final /* synthetic */ RectF $coords;
        final /* synthetic */ int $rotate;
        final /* synthetic */ int $sizeX;
        final /* synthetic */ int $sizeY;
        final /* synthetic */ int $startX;
        final /* synthetic */ int $startY;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04012(int i, int i2, int i3, int i4, int i5, RectF rectF, Continuation<? super C04012> continuation) {
            super(2, continuation);
            this.$startX = i;
            this.$startY = i2;
            this.$sizeX = i3;
            this.$sizeY = i4;
            this.$rotate = i5;
            this.$coords = rectF;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PdfPageKt.this.new C04012(this.$startX, this.$startY, this.$sizeX, this.$sizeY, this.$rotate, this.$coords, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Rect> continuation) {
            return ((C04012) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return PdfPageKt.this.getPage().mapRectToDevice(this.$startX, this.$startY, this.$sizeX, this.$sizeY, this.$rotate, this.$coords);
        }
    }

    public final Object mapRectToDevice(int i, int i2, int i3, int i4, int i5, @NotNull RectF rectF, @NotNull Continuation<? super Rect> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C04012(i, i2, i3, i4, i5, rectF, null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageKt$mapRectToPage$2, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfPageKt$mapRectToPage$2", f = "PdfPageKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C04022 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super RectF>, Object> {
        final /* synthetic */ Rect $coords;
        final /* synthetic */ int $rotate;
        final /* synthetic */ int $sizeX;
        final /* synthetic */ int $sizeY;
        final /* synthetic */ int $startX;
        final /* synthetic */ int $startY;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04022(int i, int i2, int i3, int i4, int i5, Rect rect, Continuation<? super C04022> continuation) {
            super(2, continuation);
            this.$startX = i;
            this.$startY = i2;
            this.$sizeX = i3;
            this.$sizeY = i4;
            this.$rotate = i5;
            this.$coords = rect;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PdfPageKt.this.new C04022(this.$startX, this.$startY, this.$sizeX, this.$sizeY, this.$rotate, this.$coords, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super RectF> continuation) {
            return ((C04022) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return PdfPageKt.this.getPage().mapRectToPage(this.$startX, this.$startY, this.$sizeX, this.$sizeY, this.$rotate, this.$coords);
        }
    }

    public final Object mapRectToPage(int i, int i2, int i3, int i4, int i5, @NotNull Rect rect, @NotNull Continuation<? super RectF> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C04022(i, i2, i3, i4, i5, rect, null), continuation);
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
            Logger.INSTANCE.e("PdfPageKt", e, "PdfPageKt.safeClose");
            return false;
        }
    }
}
