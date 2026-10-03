package com.facebook.fresco.animation.bitmap.preparation.ondemandanimation;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import com.facebook.common.references.CloseableReference;
import com.facebook.fresco.animation.backend.AnimationInformation;
import com.facebook.fresco.animation.bitmap.BitmapFrameRenderer;
import com.facebook.fresco.animation.bitmap.preparation.loadframe.AnimationLoaderExecutor;
import com.facebook.fresco.animation.bitmap.preparation.loadframe.FpsCompressorInfo;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.collections.SetsKt___SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public final class BufferFrameLoader implements FrameLoader {
    public static final Companion Companion = new Companion(null);
    private static final float THRESHOLD_PERCENTAGE = 0.5f;
    private final AnimationInformation animationInformation;
    private final BitmapFrameRenderer bitmapFrameRenderer;
    private final ConcurrentHashMap<Integer, BufferFrame> bufferFramesHash;
    private final int bufferLengthMilliseconds;
    private final int bufferSize;
    private Map<Integer, Integer> compressionFrameMap;
    private final FpsCompressorInfo fpsCompressor;
    private final CircularList frameSequence;
    private volatile boolean isFetching;
    private int lastRenderedFrameNumber;
    private final PlatformBitmapFactory platformBitmapFactory;
    private Set<Integer> renderableFrameIndexes;
    private volatile int thresholdFrame;

    public BufferFrameLoader(@NotNull PlatformBitmapFactory platformBitmapFactory, @NotNull BitmapFrameRenderer bitmapFrameRenderer, @NotNull FpsCompressorInfo fpsCompressor, @NotNull AnimationInformation animationInformation, int i) {
        Intrinsics.checkNotNullParameter(platformBitmapFactory, "platformBitmapFactory");
        Intrinsics.checkNotNullParameter(bitmapFrameRenderer, "bitmapFrameRenderer");
        Intrinsics.checkNotNullParameter(fpsCompressor, "fpsCompressor");
        Intrinsics.checkNotNullParameter(animationInformation, "animationInformation");
        this.platformBitmapFactory = platformBitmapFactory;
        this.bitmapFrameRenderer = bitmapFrameRenderer;
        this.fpsCompressor = fpsCompressor;
        this.animationInformation = animationInformation;
        this.bufferLengthMilliseconds = i;
        int iCoerceAtLeast = RangesKt___RangesKt.coerceAtLeast((fps(getAnimationInformation()) * i) / 1000, 1);
        this.bufferSize = iCoerceAtLeast;
        this.bufferFramesHash = new ConcurrentHashMap<>();
        this.frameSequence = new CircularList(getAnimationInformation().getFrameCount());
        this.lastRenderedFrameNumber = -1;
        this.compressionFrameMap = MapsKt__MapsKt.emptyMap();
        this.renderableFrameIndexes = SetsKt__SetsKt.emptySet();
        compressToFps(fps(getAnimationInformation()));
        this.thresholdFrame = (int) (iCoerceAtLeast * 0.5f);
    }

    @Override // com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.FrameLoader
    public void onStop() {
        FrameLoader.DefaultImpls.onStop(this);
    }

    @Override // com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.FrameLoader
    public AnimationInformation getAnimationInformation() {
        return this.animationInformation;
    }

    @Override // com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.FrameLoader
    public FrameResult getFrame(int i, int i2, int i3) {
        Integer num = this.compressionFrameMap.get(Integer.valueOf(i));
        if (num == null) {
            return findNearestToRender(i);
        }
        int iIntValue = num.intValue();
        this.lastRenderedFrameNumber = iIntValue;
        BufferFrame bufferFrame = this.bufferFramesHash.get(num);
        if (bufferFrame == null || !bufferFrame.isFrameAvailable()) {
            bufferFrame = null;
        }
        if (bufferFrame != null) {
            if (this.frameSequence.isTargetAhead(this.thresholdFrame, iIntValue, this.bufferSize)) {
                loadNextFrames(i2, i3);
            }
            return new FrameResult(bufferFrame.getBitmapRef().mo4256clone(), FrameResult.FrameType.SUCCESS);
        }
        loadNextFrames(i2, i3);
        return findNearestToRender(iIntValue);
    }

    private final FrameResult findNearestToRender(int i) {
        AnimationBitmapFrame animationBitmapFrameFindNearestFrame = findNearestFrame(i);
        if (animationBitmapFrameFindNearestFrame != null) {
            CloseableReference<Bitmap> closeableReferenceMo4256clone = animationBitmapFrameFindNearestFrame.getBitmap().mo4256clone();
            Intrinsics.checkNotNullExpressionValue(closeableReferenceMo4256clone, "clone(...)");
            this.lastRenderedFrameNumber = animationBitmapFrameFindNearestFrame.getFrameNumber();
            return new FrameResult(closeableReferenceMo4256clone, FrameResult.FrameType.NEAREST);
        }
        return new FrameResult(null, FrameResult.FrameType.MISSING);
    }

    @Override // com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.FrameLoader
    public void prepareFrames(int i, int i2, @NotNull Function0<Unit> onAnimationLoaded) {
        Intrinsics.checkNotNullParameter(onAnimationLoaded, "onAnimationLoaded");
        loadNextFrames(i, i2);
        onAnimationLoaded.invoke();
    }

    @Override // com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.FrameLoader
    public void compressToFps(int i) {
        Map<Integer, Integer> mapCalculateReducedIndexes = this.fpsCompressor.calculateReducedIndexes(getAnimationInformation().getLoopDurationMs() * RangesKt___RangesKt.coerceAtLeast(getAnimationInformation().getLoopCount(), 1), getAnimationInformation().getFrameCount(), RangesKt___RangesKt.coerceAtMost(i, fps(getAnimationInformation())));
        this.compressionFrameMap = mapCalculateReducedIndexes;
        this.renderableFrameIndexes = CollectionsKt___CollectionsKt.toSet(mapCalculateReducedIndexes.values());
    }

    @Override // com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.FrameLoader
    public void clear() {
        Collection<BufferFrame> collectionValues = this.bufferFramesHash.values();
        Intrinsics.checkNotNullExpressionValue(collectionValues, "<get-values>(...)");
        Iterator<T> it2 = collectionValues.iterator();
        while (it2.hasNext()) {
            ((BufferFrame) it2.next()).release();
        }
        this.bufferFramesHash.clear();
        this.lastRenderedFrameNumber = -1;
    }

    private final void loadNextFrames(final int i, final int i2) {
        if (this.isFetching) {
            return;
        }
        this.isFetching = true;
        AnimationLoaderExecutor.INSTANCE.execute(new Runnable() { // from class: com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.BufferFrameLoader$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                BufferFrameLoader.loadNextFrames$lambda$2(this.f$0, i, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadNextFrames$lambda$2(BufferFrameLoader this$0, int i, int i2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        while (!extractDemandedFrame$default(this$0, RangesKt___RangesKt.coerceAtLeast(this$0.lastRenderedFrameNumber, 0), i, i2, 0, 8, null)) {
        }
        this$0.isFetching = false;
    }

    static /* synthetic */ boolean extractDemandedFrame$default(BufferFrameLoader bufferFrameLoader, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 8) != 0) {
            i4 = 0;
        }
        return bufferFrameLoader.extractDemandedFrame(i, i2, i3, i4);
    }

    private final boolean extractDemandedFrame(int i, int i2, int i3, int i4) {
        int iIntValue;
        CloseableReference<Bitmap> bitmapRef;
        List<Integer> listSublist = this.frameSequence.sublist(i, this.bufferSize);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listSublist) {
            if (this.renderableFrameIndexes.contains(Integer.valueOf(((Number) obj).intValue()))) {
                arrayList.add(obj);
            }
        }
        Set set = CollectionsKt___CollectionsKt.toSet(arrayList);
        Set<Integer> setKeySet = this.bufferFramesHash.keySet();
        Intrinsics.checkNotNullExpressionValue(setKeySet, "<get-keys>(...)");
        ArrayDeque arrayDeque = new ArrayDeque(SetsKt___SetsKt.minus((Set) setKeySet, (Iterable) set));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            int iIntValue2 = ((Number) it2.next()).intValue();
            if (this.bufferFramesHash.get(Integer.valueOf(iIntValue2)) == null) {
                int i5 = this.lastRenderedFrameNumber;
                if (i5 != -1 && !set.contains(Integer.valueOf(i5))) {
                    return false;
                }
                Integer num = (Integer) arrayDeque.pollFirst();
                int iIntValue3 = num != null ? num.intValue() : -1;
                BufferFrame bufferFrame = this.bufferFramesHash.get(Integer.valueOf(iIntValue3));
                CloseableReference<Bitmap> closeableReferenceCloneOrNull = (bufferFrame == null || (bitmapRef = bufferFrame.getBitmapRef()) == null) ? null : bitmapRef.cloneOrNull();
                if (closeableReferenceCloneOrNull == null) {
                    CloseableReference<Bitmap> closeableReferenceCreateBitmap = this.platformBitmapFactory.createBitmap(i2, i3);
                    Intrinsics.checkNotNullExpressionValue(closeableReferenceCreateBitmap, "createBitmap(...)");
                    BufferFrame bufferFrame2 = new BufferFrame(closeableReferenceCreateBitmap);
                    closeableReferenceCloneOrNull = bufferFrame2.getBitmapRef().mo4256clone();
                    bufferFrame = bufferFrame2;
                }
                bufferFrame.setUpdatingFrame(true);
                try {
                    obtainFrame(closeableReferenceCloneOrNull, iIntValue2, i2, i3);
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(closeableReferenceCloneOrNull, null);
                    this.bufferFramesHash.remove(Integer.valueOf(iIntValue3));
                    bufferFrame.setUpdatingFrame(false);
                    this.bufferFramesHash.put(Integer.valueOf(iIntValue2), bufferFrame);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(closeableReferenceCloneOrNull, th);
                        throw th2;
                    }
                }
            }
        }
        if (arrayList.isEmpty()) {
            iIntValue = (int) (this.bufferSize * 0.5f);
        } else {
            int size = arrayList.size();
            iIntValue = ((Number) arrayList.get(RangesKt___RangesKt.coerceIn((int) (size * 0.5f), 0, size - 1))).intValue();
        }
        this.thresholdFrame = iIntValue;
        return true;
    }

    private final void obtainFrame(CloseableReference<Bitmap> closeableReference, int i, int i2, int i3) {
        CloseableReference<Bitmap> bitmap;
        CloseableReference<Bitmap> closeableReferenceCloneOrNull;
        AnimationBitmapFrame animationBitmapFrameFindNearestFrame = findNearestFrame(i);
        if (animationBitmapFrameFindNearestFrame != null && (bitmap = animationBitmapFrameFindNearestFrame.getBitmap()) != null && (closeableReferenceCloneOrNull = bitmap.cloneOrNull()) != null) {
            try {
                int frameNumber = animationBitmapFrameFindNearestFrame.getFrameNumber();
                if (frameNumber < i) {
                    Bitmap bitmap2 = closeableReferenceCloneOrNull.get();
                    Intrinsics.checkNotNullExpressionValue(bitmap2, "get(...)");
                    set(closeableReference, bitmap2);
                    Iterator<Integer> it2 = new IntRange(frameNumber + 1, i).iterator();
                    while (it2.hasNext()) {
                        int iNextInt = ((IntIterator) it2).nextInt();
                        BitmapFrameRenderer bitmapFrameRenderer = this.bitmapFrameRenderer;
                        Bitmap bitmap3 = closeableReference.get();
                        Intrinsics.checkNotNullExpressionValue(bitmap3, "get(...)");
                        bitmapFrameRenderer.renderFrame(iNextInt, bitmap3);
                    }
                    CloseableKt.closeFinally(closeableReferenceCloneOrNull, null);
                    return;
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(closeableReferenceCloneOrNull, null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(closeableReferenceCloneOrNull, th);
                    throw th2;
                }
            }
        }
        clear(closeableReference);
        Iterator<Integer> it3 = new IntRange(0, i).iterator();
        while (it3.hasNext()) {
            int iNextInt2 = ((IntIterator) it3).nextInt();
            BitmapFrameRenderer bitmapFrameRenderer2 = this.bitmapFrameRenderer;
            Bitmap bitmap4 = closeableReference.get();
            Intrinsics.checkNotNullExpressionValue(bitmap4, "get(...)");
            bitmapFrameRenderer2.renderFrame(iNextInt2, bitmap4);
        }
    }

    private final AnimationBitmapFrame findNearestFrame(int i) {
        AnimationBitmapFrame animationBitmapFrame;
        Iterator<Integer> it2 = new IntRange(0, this.frameSequence.getSize()).iterator();
        do {
            animationBitmapFrame = null;
            if (!it2.hasNext()) {
                break;
            }
            int position = this.frameSequence.getPosition(i - ((IntIterator) it2).nextInt());
            BufferFrame bufferFrame = this.bufferFramesHash.get(Integer.valueOf(position));
            if (bufferFrame != null) {
                if (!bufferFrame.isFrameAvailable()) {
                    bufferFrame = null;
                }
                if (bufferFrame != null) {
                    animationBitmapFrame = new AnimationBitmapFrame(position, bufferFrame.getBitmapRef());
                }
            }
        } while (animationBitmapFrame == null);
        return animationBitmapFrame;
    }

    private final void clear(CloseableReference<Bitmap> closeableReference) {
        if (closeableReference.isValid()) {
            new Canvas(closeableReference.get()).drawColor(0, PorterDuff.Mode.CLEAR);
        }
    }

    private final CloseableReference<Bitmap> set(CloseableReference<Bitmap> closeableReference, Bitmap bitmap) {
        if (closeableReference.isValid() && !Intrinsics.areEqual(closeableReference.get(), bitmap)) {
            Canvas canvas = new Canvas(closeableReference.get());
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        }
        return closeableReference;
    }

    private final int fps(AnimationInformation animationInformation) {
        return (int) RangesKt___RangesKt.coerceAtLeast(TimeUnit.SECONDS.toMillis(1L) / ((long) (animationInformation.getLoopDurationMs() / animationInformation.getFrameCount())), 1L);
    }

    static final class BufferFrame {
        private final CloseableReference<Bitmap> bitmapRef;
        private boolean isUpdatingFrame;

        public BufferFrame(@NotNull CloseableReference<Bitmap> bitmapRef) {
            Intrinsics.checkNotNullParameter(bitmapRef, "bitmapRef");
            this.bitmapRef = bitmapRef;
        }

        public final CloseableReference<Bitmap> getBitmapRef() {
            return this.bitmapRef;
        }

        public final boolean isUpdatingFrame() {
            return this.isUpdatingFrame;
        }

        public final void setUpdatingFrame(boolean z) {
            this.isUpdatingFrame = z;
        }

        public final boolean isFrameAvailable() {
            return !this.isUpdatingFrame && this.bitmapRef.isValid();
        }

        public final void release() {
            CloseableReference.closeSafely(this.bitmapRef);
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
