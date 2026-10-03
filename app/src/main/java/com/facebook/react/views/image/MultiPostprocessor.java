package com.facebook.react.views.image;

import android.graphics.Bitmap;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.MultiCacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.request.Postprocessor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public final class MultiPostprocessor implements Postprocessor {
    public static final Companion Companion = new Companion(null);
    private final List<Postprocessor> postprocessors;

    public /* synthetic */ MultiPostprocessor(List list, DefaultConstructorMarker defaultConstructorMarker) {
        this(list);
    }

    @JvmStatic
    public static final Postprocessor from(@NotNull List<? extends Postprocessor> list) {
        return Companion.from(list);
    }

    private MultiPostprocessor(List<? extends Postprocessor> list) {
        this.postprocessors = new LinkedList(list);
    }

    @Override // com.facebook.imagepipeline.request.Postprocessor
    public String getName() {
        return "MultiPostProcessor (" + CollectionsKt___CollectionsKt.joinToString$default(this.postprocessors, ",", null, null, 0, null, null, 62, null) + ")";
    }

    @Override // com.facebook.imagepipeline.request.Postprocessor
    public CacheKey getPostprocessorCacheKey() {
        List<Postprocessor> list = this.postprocessors;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList.add(((Postprocessor) it2.next()).getPostprocessorCacheKey());
        }
        return new MultiCacheKey(arrayList);
    }

    @Override // com.facebook.imagepipeline.request.Postprocessor
    public CloseableReference<Bitmap> process(@NotNull Bitmap sourceBitmap, @NotNull PlatformBitmapFactory bitmapFactory) {
        Bitmap bitmap;
        Intrinsics.checkNotNullParameter(sourceBitmap, "sourceBitmap");
        Intrinsics.checkNotNullParameter(bitmapFactory, "bitmapFactory");
        CloseableReference<Bitmap> closeableReferenceProcess = null;
        try {
            CloseableReference<Bitmap> closeableReferenceMo4256clone = null;
            for (Postprocessor postprocessor : this.postprocessors) {
                if (closeableReferenceMo4256clone == null || (bitmap = closeableReferenceMo4256clone.get()) == null) {
                    bitmap = sourceBitmap;
                }
                closeableReferenceProcess = postprocessor.process(bitmap, bitmapFactory);
                CloseableReference.closeSafely(closeableReferenceMo4256clone);
                closeableReferenceMo4256clone = closeableReferenceProcess.mo4256clone();
            }
            if (closeableReferenceProcess == null) {
                throw new IllegalStateException(("MultiPostprocessor returned null bitmap - Number of Postprocessors: " + this.postprocessors.size()).toString());
            }
            CloseableReference<Bitmap> closeableReferenceMo4256clone2 = closeableReferenceProcess.mo4256clone();
            Intrinsics.checkNotNullExpressionValue(closeableReferenceMo4256clone2, "clone(...)");
            CloseableReference.closeSafely(closeableReferenceProcess);
            return closeableReferenceMo4256clone2;
        } catch (Throwable th) {
            CloseableReference.closeSafely((CloseableReference<?>) null);
            throw th;
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Postprocessor from(@NotNull List<? extends Postprocessor> postprocessors) {
            Intrinsics.checkNotNullParameter(postprocessors, "postprocessors");
            int size = postprocessors.size();
            DefaultConstructorMarker defaultConstructorMarker = null;
            if (size == 0) {
                return null;
            }
            if (size == 1) {
                return postprocessors.get(0);
            }
            return new MultiPostprocessor(postprocessors, defaultConstructorMarker);
        }
    }
}
