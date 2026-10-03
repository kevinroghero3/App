package io.legere.pdfiumandroid.suspend;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.Surface;
import io.legere.pdfiumandroid.PdfDocument;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes.dex */
@DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfDocumentKt$renderPages$2$1", f = "PdfDocumentKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class PdfDocumentKt$renderPages$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ int $canvasColor;
    final /* synthetic */ List<RectF> $clipRects;
    final /* synthetic */ List<Matrix> $matrices;
    final /* synthetic */ int $pageBackgroundColor;
    final /* synthetic */ List<PdfPageKt> $pages;
    final /* synthetic */ boolean $renderAnnot;
    final /* synthetic */ Surface $surface;
    final /* synthetic */ boolean $textMask;
    int label;
    final /* synthetic */ PdfDocumentKt this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    PdfDocumentKt$renderPages$2$1(PdfDocumentKt pdfDocumentKt, Surface surface, List<PdfPageKt> list, List<? extends Matrix> list2, List<? extends RectF> list3, boolean z, boolean z2, int i, int i2, Continuation<? super PdfDocumentKt$renderPages$2$1> continuation) {
        super(2, continuation);
        this.this$0 = pdfDocumentKt;
        this.$surface = surface;
        this.$pages = list;
        this.$matrices = list2;
        this.$clipRects = list3;
        this.$renderAnnot = z;
        this.$textMask = z2;
        this.$canvasColor = i;
        this.$pageBackgroundColor = i2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PdfDocumentKt$renderPages$2$1(this.this$0, this.$surface, this.$pages, this.$matrices, this.$clipRects, this.$renderAnnot, this.$textMask, this.$canvasColor, this.$pageBackgroundColor, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((PdfDocumentKt$renderPages$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        PdfDocument document = this.this$0.getDocument();
        Surface surface = this.$surface;
        List<PdfPageKt> list = this.$pages;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList.add(((PdfPageKt) it2.next()).getPage());
        }
        return Boxing.boxBoolean(document.renderPages(surface, arrayList, this.$matrices, this.$clipRects, this.$renderAnnot, this.$textMask, this.$canvasColor, this.$pageBackgroundColor));
    }
}
