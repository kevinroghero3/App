package com.facebook.imagepipeline.core;

import android.content.ContentResolver;
import android.graphics.PointF;
import android.media.AudioTrack;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.media.MediaUtils;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.AddImageTransformMetaDataProducer;
import com.facebook.imagepipeline.producers.BitmapMemoryCacheGetProducer;
import com.facebook.imagepipeline.producers.BitmapMemoryCacheKeyMultiplexProducer;
import com.facebook.imagepipeline.producers.BitmapMemoryCacheProducer;
import com.facebook.imagepipeline.producers.BitmapProbeProducer;
import com.facebook.imagepipeline.producers.BranchOnSeparateImagesProducer;
import com.facebook.imagepipeline.producers.CustomProducerSequenceFactory;
import com.facebook.imagepipeline.producers.DataFetchProducer;
import com.facebook.imagepipeline.producers.DecodeProducer;
import com.facebook.imagepipeline.producers.DelayProducer;
import com.facebook.imagepipeline.producers.DiskCacheReadProducer;
import com.facebook.imagepipeline.producers.DiskCacheWriteProducer;
import com.facebook.imagepipeline.producers.EncodedCacheKeyMultiplexProducer;
import com.facebook.imagepipeline.producers.EncodedProbeProducer;
import com.facebook.imagepipeline.producers.LocalAssetFetchProducer;
import com.facebook.imagepipeline.producers.LocalContentUriFetchProducer;
import com.facebook.imagepipeline.producers.LocalFileFetchProducer;
import com.facebook.imagepipeline.producers.LocalResourceFetchProducer;
import com.facebook.imagepipeline.producers.LocalThumbnailBitmapSdk29Producer;
import com.facebook.imagepipeline.producers.LocalVideoThumbnailProducer;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import com.facebook.imagepipeline.producers.PartialDiskCacheProducer;
import com.facebook.imagepipeline.producers.PostprocessorProducer;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.QualifiedResourceFetchProducer;
import com.facebook.imagepipeline.producers.RemoveImageTransformMetaDataProducer;
import com.facebook.imagepipeline.producers.ResizeAndRotateProducer;
import com.facebook.imagepipeline.producers.SwallowResultProducer;
import com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue;
import com.facebook.imagepipeline.producers.ThrottlingProducer;
import com.facebook.imagepipeline.producers.ThumbnailBranchProducer;
import com.facebook.imagepipeline.producers.ThumbnailProducer;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.imagepipeline.transcoder.ImageTranscoderFactory;
import com.google.common.base.Ascii;
import com.hitachiapp.exceptions.AppHookedException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o.ArtificialStackFrames;
import o.extraCallback;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class ProducerSequenceFactory {
    public static final Companion Companion = new Companion(null);
    private final boolean allowDelay;
    private final Lazy backgroundLocalContentUriFetchToEncodeMemorySequence$delegate;
    private final Lazy backgroundLocalFileFetchToEncodeMemorySequence$delegate;
    private final Lazy backgroundNetworkFetchToEncodedMemorySequence$delegate;
    private Map<Producer<CloseableReference<CloseableImage>>, Producer<CloseableReference<CloseableImage>>> bitmapPrepareSequences;
    private Map<Producer<CloseableReference<CloseableImage>>, Producer<Void>> closeableImagePrefetchSequences;
    private final Lazy commonNetworkFetchToEncodedMemorySequence$delegate;
    private final ContentResolver contentResolver;
    private final Set<CustomProducerSequenceFactory> customProducerSequenceFactories;
    private final Lazy dataFetchSequence$delegate;
    private final boolean diskCacheEnabled;
    private final DownsampleMode downsampleMode;
    private final ImageTranscoderFactory imageTranscoderFactory;
    private final boolean isDiskCacheProbingEnabled;
    private final boolean isEncodedMemoryCacheProbingEnabled;
    private final Lazy localAssetFetchSequence$delegate;
    private final Lazy localContentUriFetchEncodedImageProducerSequence$delegate;
    private final Lazy localContentUriFetchSequence$delegate;
    private final Lazy localFileFetchEncodedImageProducerSequence$delegate;
    private final Lazy localFileFetchToEncodedMemoryPrefetchSequence$delegate;
    private final Lazy localImageFileFetchSequence$delegate;
    private final Lazy localResourceFetchSequence$delegate;
    private final Lazy localThumbnailBitmapSdk29FetchSequence$delegate;
    private final Lazy localVideoFileFetchSequence$delegate;
    private final Lazy networkFetchEncodedImageProducerSequence$delegate;
    private final Lazy networkFetchSequence$delegate;
    private final Lazy networkFetchToEncodedMemoryPrefetchSequence$delegate;
    private final NetworkFetcher<?> networkFetcher;
    private final boolean partialImageCachingEnabled;
    private Map<Producer<CloseableReference<CloseableImage>>, Producer<CloseableReference<CloseableImage>>> postprocessorSequences;
    private final ProducerFactory producerFactory;
    private final Lazy qualifiedResourceFetchSequence$delegate;
    private final boolean resizeAndRotateEnabledForNetwork;
    private final ThreadHandoffProducerQueue threadHandoffProducerQueue;
    private final boolean useBitmapPrepareToDraw;
    private final boolean webpSupportEnabled;

    public static /* synthetic */ void getBitmapPrepareSequences$annotations() {
    }

    public static /* synthetic */ void getCloseableImagePrefetchSequences$annotations() {
    }

    public static /* synthetic */ void getLocalFileFetchEncodedImageProducerSequence$annotations() {
    }

    public static /* synthetic */ void getPostprocessorSequences$annotations() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ProducerSequenceFactory(@NotNull ContentResolver contentResolver, @NotNull ProducerFactory producerFactory, @NotNull NetworkFetcher<?> networkFetcher, boolean z, boolean z2, @NotNull ThreadHandoffProducerQueue threadHandoffProducerQueue, @NotNull DownsampleMode downsampleMode, boolean z3, boolean z4, boolean z5, @NotNull ImageTranscoderFactory imageTranscoderFactory, boolean z6, boolean z7, boolean z8, @Nullable Set<? extends CustomProducerSequenceFactory> set) {
        Intrinsics.checkNotNullParameter(contentResolver, "contentResolver");
        Intrinsics.checkNotNullParameter(producerFactory, "producerFactory");
        Intrinsics.checkNotNullParameter(networkFetcher, "networkFetcher");
        Intrinsics.checkNotNullParameter(threadHandoffProducerQueue, "threadHandoffProducerQueue");
        Intrinsics.checkNotNullParameter(downsampleMode, "downsampleMode");
        Intrinsics.checkNotNullParameter(imageTranscoderFactory, "imageTranscoderFactory");
        this.contentResolver = contentResolver;
        this.producerFactory = producerFactory;
        this.networkFetcher = networkFetcher;
        this.resizeAndRotateEnabledForNetwork = z;
        this.webpSupportEnabled = z2;
        this.threadHandoffProducerQueue = threadHandoffProducerQueue;
        this.downsampleMode = downsampleMode;
        this.useBitmapPrepareToDraw = z3;
        this.partialImageCachingEnabled = z4;
        this.diskCacheEnabled = z5;
        this.imageTranscoderFactory = imageTranscoderFactory;
        this.isEncodedMemoryCacheProbingEnabled = z6;
        this.isDiskCacheProbingEnabled = z7;
        this.allowDelay = z8;
        this.customProducerSequenceFactories = set;
        this.postprocessorSequences = new LinkedHashMap();
        this.closeableImagePrefetchSequences = new LinkedHashMap();
        this.bitmapPrepareSequences = new LinkedHashMap();
        this.networkFetchEncodedImageProducerSequence$delegate = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.facebook.imagepipeline.core.ProducerSequenceFactory$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProducerSequenceFactory.networkFetchEncodedImageProducerSequence_delegate$lambda$2(this.f$0);
            }
        });
        this.localFileFetchEncodedImageProducerSequence$delegate = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.facebook.imagepipeline.core.ProducerSequenceFactory$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProducerSequenceFactory.localFileFetchEncodedImageProducerSequence_delegate$lambda$4(this.f$0);
            }
        });
        this.localContentUriFetchEncodedImageProducerSequence$delegate = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.facebook.imagepipeline.core.ProducerSequenceFactory$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProducerSequenceFactory.localContentUriFetchEncodedImageProducerSequence_delegate$lambda$6(this.f$0);
            }
        });
        this.networkFetchSequence$delegate = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.facebook.imagepipeline.core.ProducerSequenceFactory$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProducerSequenceFactory.networkFetchSequence_delegate$lambda$11(this.f$0);
            }
        });
        this.backgroundNetworkFetchToEncodedMemorySequence$delegate = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.facebook.imagepipeline.core.ProducerSequenceFactory$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProducerSequenceFactory.backgroundNetworkFetchToEncodedMemorySequence_delegate$lambda$13(this.f$0);
            }
        });
        this.networkFetchToEncodedMemoryPrefetchSequence$delegate = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.facebook.imagepipeline.core.ProducerSequenceFactory$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProducerSequenceFactory.networkFetchToEncodedMemoryPrefetchSequence_delegate$lambda$15(this.f$0);
            }
        });
        this.commonNetworkFetchToEncodedMemorySequence$delegate = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.facebook.imagepipeline.core.ProducerSequenceFactory$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProducerSequenceFactory.commonNetworkFetchToEncodedMemorySequence_delegate$lambda$17(this.f$0);
            }
        });
        this.localFileFetchToEncodedMemoryPrefetchSequence$delegate = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.facebook.imagepipeline.core.ProducerSequenceFactory$$ExternalSyntheticLambda15
            private static final byte[] $$c = {71, -70, 54, 33};
            private static final int $$d = 90;
            private static int $10 = 0;
            private static int $11 = 1;
            private static final byte[] $$a = {79, -66, -116, -33, Ascii.VT, 2, -12};
            private static final int $$b = 25;
            private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
            private static int artificialFrame = 1;
            private static char[] ArtificialStackFrames = {39059, 44407, 44334, 44404, 44389, 44398, 44399, 44335, 44409, 44388, 44355, 44403, 39071, 39067, 44356, 39064, 44395, 39056, 44391, 44390, 44405, 39065, 44386, 39068, 44385, 44402, 39070, 44396, 44337, 44383, 44387, 44393, 44400, 39058, 44358, 39069};
            private static char coroutineCreation = 39068;

            /* JADX WARN: Code duplicated, block: B:10:0x0026  */
            /* JADX WARN: Code duplicated, block: B:8:0x0020  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x002a). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0026
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            private static java.lang.String $$e(short r6, byte r7, byte r8) {
                /*
                    int r7 = r7 * 4
                    int r0 = 1 - r7
                    byte[] r1 = com.facebook.imagepipeline.core.ProducerSequenceFactory$$ExternalSyntheticLambda15.$$c
                    int r6 = r6 * 2
                    int r6 = 4 - r6
                    int r8 = 105 - r8
                    byte[] r0 = new byte[r0]
                    r2 = 0
                    int r7 = 0 - r7
                    if (r1 != 0) goto L17
                    r8 = r6
                    r4 = r7
                    r3 = r2
                    goto L2a
                L17:
                    r3 = r2
                    r5 = r8
                    r8 = r6
                    r6 = r5
                L1b:
                    byte r4 = (byte) r6
                    r0[r3] = r4
                    if (r3 != r7) goto L26
                    java.lang.String r6 = new java.lang.String
                    r6.<init>(r0, r2)
                    return r6
                L26:
                    int r3 = r3 + 1
                    r4 = r1[r8]
                L2a:
                    int r4 = -r4
                    int r6 = r6 + r4
                    int r8 = r8 + 1
                    goto L1b
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.core.ProducerSequenceFactory$$ExternalSyntheticLambda15.$$e(short, byte, byte):java.lang.String");
            }

            /* JADX WARN: Code duplicated, block: B:10:0x0027  */
            /* JADX WARN: Code duplicated, block: B:8:0x001f  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x002b). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0027
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            private static void b(int r5, byte r6, short r7, java.lang.Object[] r8) {
                /*
                    int r7 = r7 * 3
                    int r7 = r7 + 109
                    int r5 = r5 * 2
                    int r5 = 4 - r5
                    int r6 = r6 * 3
                    int r0 = 4 - r6
                    byte[] r1 = com.facebook.imagepipeline.core.ProducerSequenceFactory$$ExternalSyntheticLambda15.$$a
                    byte[] r0 = new byte[r0]
                    int r6 = 3 - r6
                    r2 = 0
                    if (r1 != 0) goto L19
                    r4 = r7
                    r3 = r2
                    r7 = r5
                    goto L2b
                L19:
                    r3 = r2
                L1a:
                    byte r4 = (byte) r7
                    r0[r3] = r4
                    if (r3 != r6) goto L27
                    java.lang.String r5 = new java.lang.String
                    r5.<init>(r0, r2)
                    r8[r2] = r5
                    return
                L27:
                    int r3 = r3 + 1
                    r4 = r1[r5]
                L2b:
                    int r5 = r5 + 1
                    int r7 = r7 + r4
                    int r7 = r7 + (-3)
                    goto L1a
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.core.ProducerSequenceFactory$$ExternalSyntheticLambda15.b(int, byte, short, java.lang.Object[]):void");
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProducerSequenceFactory.localFileFetchToEncodedMemoryPrefetchSequence_delegate$lambda$20(this.f$0);
            }

            private static void a(int i, char[] cArr, byte b, Object[] objArr) throws Throwable {
                int i2;
                Object obj;
                int i3 = 2 % 2;
                extraCallback extracallback = new extraCallback();
                char[] cArr2 = ArtificialStackFrames;
                long j = 0;
                Object obj2 = null;
                if (cArr2 != null) {
                    int length = cArr2.length;
                    char[] cArr3 = new char[length];
                    int i4 = 0;
                    while (i4 < length) {
                        try {
                            Object[] objArr2 = {Integer.valueOf(cArr2[i4])};
                            Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1819279892);
                            if (objAccessartificialFrame == null) {
                                byte b2 = (byte) 0;
                                byte b3 = b2;
                                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(View.getDefaultSize(0, 0) + 15, (char) (ExpandableListView.getPackedPositionChild(j) + 20489), (ViewConfiguration.getTouchSlop() >> 8) + 2148, 216710116, false, $$e(b2, b3, (byte) (b3 | 8)), new Class[]{Integer.TYPE});
                            }
                            cArr3[i4] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                            i4++;
                            j = 0;
                        } catch (Throwable th) {
                            Throwable cause = th.getCause();
                            if (cause == null) {
                                throw th;
                            }
                            throw cause;
                        }
                    }
                    cArr2 = cArr3;
                }
                Object[] objArr3 = {Integer.valueOf(coroutineCreation)};
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1819279892);
                long j2 = -1;
                if (objAccessartificialFrame2 == null) {
                    byte b4 = (byte) 0;
                    byte b5 = b4;
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(16 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), (char) (20487 - TextUtils.lastIndexOf("", '0', 0)), 2149 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), 216710116, false, $$e(b4, b5, (byte) (b5 | 8)), new Class[]{Integer.TYPE});
                }
                char cCharValue = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
                char[] cArr4 = new char[i];
                if (i % 2 != 0) {
                    i2 = i - 1;
                    cArr4[i2] = (char) (cArr[i2] - b);
                } else {
                    i2 = i;
                }
                if (i2 > 1) {
                    extracallback.a = 0;
                    while (extracallback.a < i2) {
                        int i5 = $11 + 99;
                        $10 = i5 % 128;
                        int i6 = i5 % 2;
                        extracallback.createBrowser = cArr[extracallback.a];
                        extracallback.c = cArr[extracallback.a + 1];
                        if (extracallback.createBrowser == extracallback.c) {
                            cArr4[extracallback.a] = (char) (extracallback.createBrowser - b);
                            cArr4[extracallback.a + 1] = (char) (extracallback.c - b);
                            int i7 = $11 + 93;
                            $10 = i7 % 128;
                            int i8 = i7 % 2;
                            obj = obj2;
                        } else {
                            Object[] objArr4 = {extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback};
                            Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1894223152);
                            if (objAccessartificialFrame3 == null) {
                                byte b6 = (byte) 0;
                                byte b7 = b6;
                                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(46 - Gravity.getAbsoluteGravity(0, 0), (char) (58860 - (SystemClock.currentThreadTimeMillis() > j2 ? 1 : (SystemClock.currentThreadTimeMillis() == j2 ? 0 : -1))), (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 2465, 276640984, false, $$e(b6, b7, (byte) (b7 + 3)), new Class[]{Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class});
                            }
                            if (((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue() == extracallback.g) {
                                Object[] objArr5 = {extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, Integer.valueOf(cCharValue), extracallback};
                                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1361113423);
                                if (objAccessartificialFrame4 == null) {
                                    byte b8 = (byte) 0;
                                    byte b9 = b8;
                                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(24 - TextUtils.getCapsMode("", 0, 0), (char) (ViewConfiguration.getKeyRepeatDelay() >> 16), 792 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), -834291897, false, $$e(b8, b9, b9), new Class[]{Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Integer.TYPE, Object.class});
                                }
                                obj = null;
                                int iIntValue = ((Integer) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).intValue();
                                int i9 = (extracallback.d * cCharValue) + extracallback.g;
                                cArr4[extracallback.a] = cArr2[iIntValue];
                                cArr4[extracallback.a + 1] = cArr2[i9];
                            } else {
                                obj = null;
                                if (extracallback.b == extracallback.d) {
                                    int i10 = $11 + 87;
                                    $10 = i10 % 128;
                                    int i11 = i10 % 2;
                                    extracallback.j = ((extracallback.j + cCharValue) - 1) % cCharValue;
                                    extracallback.g = ((extracallback.g + cCharValue) - 1) % cCharValue;
                                    int i12 = (extracallback.b * cCharValue) + extracallback.j;
                                    int i13 = (extracallback.d * cCharValue) + extracallback.g;
                                    cArr4[extracallback.a] = cArr2[i12];
                                    cArr4[extracallback.a + 1] = cArr2[i13];
                                } else {
                                    int i14 = (extracallback.b * cCharValue) + extracallback.g;
                                    int i15 = (extracallback.d * cCharValue) + extracallback.j;
                                    cArr4[extracallback.a] = cArr2[i14];
                                    cArr4[extracallback.a + 1] = cArr2[i15];
                                }
                            }
                        }
                        extracallback.a += 2;
                        obj2 = obj;
                        j2 = -1;
                    }
                }
                int i16 = $10 + 117;
                $11 = i16 % 128;
                int i17 = i16 % 2;
                for (int i18 = 0; i18 < i; i18++) {
                    cArr4[i18] = (char) (cArr4[i18] ^ 13722);
                }
                objArr[0] = new String(cArr4);
            }

            /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
                java.util.NoSuchElementException
                	at java.base/java.util.TreeMap.key(Unknown Source)
                	at java.base/java.util.TreeMap.lastKey(Unknown Source)
                	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
                	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
                	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
                */
            public static java.lang.Object[] coroutineCreation(int r26, int r27) {
                /*
                    Method dump skipped, instruction units count: 3516
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.core.ProducerSequenceFactory$$ExternalSyntheticLambda15.coroutineCreation(int, int):java.lang.Object[]");
            }
        });
        this.backgroundLocalFileFetchToEncodeMemorySequence$delegate = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.facebook.imagepipeline.core.ProducerSequenceFactory$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProducerSequenceFactory.backgroundLocalFileFetchToEncodeMemorySequence_delegate$lambda$22(this.f$0);
            }
        });
        this.backgroundLocalContentUriFetchToEncodeMemorySequence$delegate = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.facebook.imagepipeline.core.ProducerSequenceFactory$$ExternalSyntheticLambda17
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProducerSequenceFactory.backgroundLocalContentUriFetchToEncodeMemorySequence_delegate$lambda$24(this.f$0);
            }
        });
        this.localImageFileFetchSequence$delegate = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.facebook.imagepipeline.core.ProducerSequenceFactory$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProducerSequenceFactory.localImageFileFetchSequence_delegate$lambda$25(this.f$0);
            }
        });
        this.localVideoFileFetchSequence$delegate = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.facebook.imagepipeline.core.ProducerSequenceFactory$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProducerSequenceFactory.localVideoFileFetchSequence_delegate$lambda$26(this.f$0);
            }
        });
        this.localContentUriFetchSequence$delegate = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.facebook.imagepipeline.core.ProducerSequenceFactory$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProducerSequenceFactory.localContentUriFetchSequence_delegate$lambda$27(this.f$0);
            }
        });
        this.localThumbnailBitmapSdk29FetchSequence$delegate = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.facebook.imagepipeline.core.ProducerSequenceFactory$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProducerSequenceFactory.localThumbnailBitmapSdk29FetchSequence_delegate$lambda$28(this.f$0);
            }
        });
        this.qualifiedResourceFetchSequence$delegate = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.facebook.imagepipeline.core.ProducerSequenceFactory$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProducerSequenceFactory.qualifiedResourceFetchSequence_delegate$lambda$29(this.f$0);
            }
        });
        this.localResourceFetchSequence$delegate = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.facebook.imagepipeline.core.ProducerSequenceFactory$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProducerSequenceFactory.localResourceFetchSequence_delegate$lambda$30(this.f$0);
            }
        });
        this.localAssetFetchSequence$delegate = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.facebook.imagepipeline.core.ProducerSequenceFactory$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProducerSequenceFactory.localAssetFetchSequence_delegate$lambda$31(this.f$0);
            }
        });
        this.dataFetchSequence$delegate = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.facebook.imagepipeline.core.ProducerSequenceFactory$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProducerSequenceFactory.dataFetchSequence_delegate$lambda$32(this.f$0);
            }
        });
    }

    public final Map<Producer<CloseableReference<CloseableImage>>, Producer<CloseableReference<CloseableImage>>> getPostprocessorSequences() {
        return this.postprocessorSequences;
    }

    public final void setPostprocessorSequences(@NotNull Map<Producer<CloseableReference<CloseableImage>>, Producer<CloseableReference<CloseableImage>>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.postprocessorSequences = map;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static void $$a(long j, long j2) throws Throwable {
            try {
                Constructor declaredConstructor = AppHookedException.class.getDeclaredConstructor(null);
                declaredConstructor.setAccessible(true);
                throw ((Throwable) declaredConstructor.newInstance(null));
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void validateEncodedImageRequest(ImageRequest imageRequest) {
            Preconditions.checkArgument(Boolean.valueOf(imageRequest.getLowestPermittedRequestLevel().getValue() <= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String getShortenedUriString(Uri uri) {
            String string = uri.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            if (string.length() <= 30) {
                return string;
            }
            String strSubstring = string.substring(0, 30);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            return strSubstring + "...";
        }
    }

    public final Map<Producer<CloseableReference<CloseableImage>>, Producer<Void>> getCloseableImagePrefetchSequences() {
        return this.closeableImagePrefetchSequences;
    }

    public final void setCloseableImagePrefetchSequences(@NotNull Map<Producer<CloseableReference<CloseableImage>>, Producer<Void>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.closeableImagePrefetchSequences = map;
    }

    public final Map<Producer<CloseableReference<CloseableImage>>, Producer<CloseableReference<CloseableImage>>> getBitmapPrepareSequences() {
        return this.bitmapPrepareSequences;
    }

    public final void setBitmapPrepareSequences(@NotNull Map<Producer<CloseableReference<CloseableImage>>, Producer<CloseableReference<CloseableImage>>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.bitmapPrepareSequences = map;
    }

    public final Producer<CloseableReference<PooledByteBuffer>> getEncodedImageProducerSequence(@NotNull ImageRequest imageRequest) {
        Producer<CloseableReference<PooledByteBuffer>> networkFetchEncodedImageProducerSequence;
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        FrescoSystrace frescoSystrace = FrescoSystrace.INSTANCE;
        if (!FrescoSystrace.isTracing()) {
            Companion.validateEncodedImageRequest(imageRequest);
            Uri sourceUri = imageRequest.getSourceUri();
            Intrinsics.checkNotNullExpressionValue(sourceUri, "getSourceUri(...)");
            int sourceUriType = imageRequest.getSourceUriType();
            if (sourceUriType == 0) {
                return getNetworkFetchEncodedImageProducerSequence();
            }
            if (sourceUriType == 2 || sourceUriType == 3) {
                return getLocalFileFetchEncodedImageProducerSequence();
            }
            if (sourceUriType == 4) {
                return getLocalContentUriFetchEncodedImageProducerSequence();
            }
            Set<CustomProducerSequenceFactory> set = this.customProducerSequenceFactories;
            if (set != null) {
                Iterator<CustomProducerSequenceFactory> it2 = set.iterator();
                while (it2.hasNext()) {
                    Producer<CloseableReference<PooledByteBuffer>> customEncodedImageSequence = it2.next().getCustomEncodedImageSequence(imageRequest, this, this.producerFactory, this.threadHandoffProducerQueue);
                    if (customEncodedImageSequence != null) {
                        return customEncodedImageSequence;
                    }
                }
            }
            throw new IllegalArgumentException("Unsupported uri scheme for encoded image fetch! Uri is: " + Companion.getShortenedUriString(sourceUri));
        }
        FrescoSystrace.beginSection("ProducerSequenceFactory#getEncodedImageProducerSequence");
        try {
            Companion.validateEncodedImageRequest(imageRequest);
            Uri sourceUri2 = imageRequest.getSourceUri();
            Intrinsics.checkNotNullExpressionValue(sourceUri2, "getSourceUri(...)");
            int sourceUriType2 = imageRequest.getSourceUriType();
            if (sourceUriType2 == 0) {
                networkFetchEncodedImageProducerSequence = getNetworkFetchEncodedImageProducerSequence();
            } else if (sourceUriType2 == 2 || sourceUriType2 == 3) {
                networkFetchEncodedImageProducerSequence = getLocalFileFetchEncodedImageProducerSequence();
            } else if (sourceUriType2 == 4) {
                networkFetchEncodedImageProducerSequence = getLocalContentUriFetchEncodedImageProducerSequence();
            } else {
                Set<CustomProducerSequenceFactory> set2 = this.customProducerSequenceFactories;
                if (set2 != null) {
                    Iterator<CustomProducerSequenceFactory> it3 = set2.iterator();
                    while (it3.hasNext()) {
                        Producer<CloseableReference<PooledByteBuffer>> customEncodedImageSequence2 = it3.next().getCustomEncodedImageSequence(imageRequest, this, this.producerFactory, this.threadHandoffProducerQueue);
                        if (customEncodedImageSequence2 != null) {
                            FrescoSystrace.endSection();
                            return customEncodedImageSequence2;
                        }
                    }
                }
                throw new IllegalArgumentException("Unsupported uri scheme for encoded image fetch! Uri is: " + Companion.getShortenedUriString(sourceUri2));
            }
            FrescoSystrace.endSection();
            return networkFetchEncodedImageProducerSequence;
        } catch (Throwable th) {
            FrescoSystrace.endSection();
            throw th;
        }
    }

    public final Producer<CloseableReference<PooledByteBuffer>> getNetworkFetchEncodedImageProducerSequence() {
        return (Producer) this.networkFetchEncodedImageProducerSequence$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RemoveImageTransformMetaDataProducer networkFetchEncodedImageProducerSequence_delegate$lambda$2(ProducerSequenceFactory this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FrescoSystrace frescoSystrace = FrescoSystrace.INSTANCE;
        if (!FrescoSystrace.isTracing()) {
            return new RemoveImageTransformMetaDataProducer(this$0.getBackgroundNetworkFetchToEncodedMemorySequence());
        }
        FrescoSystrace.beginSection("ProducerSequenceFactory#getNetworkFetchEncodedImageProducerSequence:init");
        try {
            return new RemoveImageTransformMetaDataProducer(this$0.getBackgroundNetworkFetchToEncodedMemorySequence());
        } finally {
            FrescoSystrace.endSection();
        }
    }

    public final Producer<CloseableReference<PooledByteBuffer>> getLocalFileFetchEncodedImageProducerSequence() {
        return (Producer) this.localFileFetchEncodedImageProducerSequence$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RemoveImageTransformMetaDataProducer localFileFetchEncodedImageProducerSequence_delegate$lambda$4(ProducerSequenceFactory this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FrescoSystrace frescoSystrace = FrescoSystrace.INSTANCE;
        if (!FrescoSystrace.isTracing()) {
            return new RemoveImageTransformMetaDataProducer(this$0.getBackgroundLocalFileFetchToEncodeMemorySequence());
        }
        FrescoSystrace.beginSection("ProducerSequenceFactory#getLocalFileFetchEncodedImageProducerSequence:init");
        try {
            return new RemoveImageTransformMetaDataProducer(this$0.getBackgroundLocalFileFetchToEncodeMemorySequence());
        } finally {
            FrescoSystrace.endSection();
        }
    }

    public final Producer<CloseableReference<PooledByteBuffer>> getLocalContentUriFetchEncodedImageProducerSequence() {
        return (Producer) this.localContentUriFetchEncodedImageProducerSequence$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RemoveImageTransformMetaDataProducer localContentUriFetchEncodedImageProducerSequence_delegate$lambda$6(ProducerSequenceFactory this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FrescoSystrace frescoSystrace = FrescoSystrace.INSTANCE;
        if (!FrescoSystrace.isTracing()) {
            return new RemoveImageTransformMetaDataProducer(this$0.getBackgroundLocalContentUriFetchToEncodeMemorySequence());
        }
        FrescoSystrace.beginSection("ProducerSequenceFactory#getLocalContentUriFetchEncodedImageProducerSequence:init");
        try {
            return new RemoveImageTransformMetaDataProducer(this$0.getBackgroundLocalContentUriFetchToEncodeMemorySequence());
        } finally {
            FrescoSystrace.endSection();
        }
    }

    public final Producer<Void> getEncodedImagePrefetchProducerSequence(@NotNull ImageRequest imageRequest) {
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        Companion companion = Companion;
        companion.validateEncodedImageRequest(imageRequest);
        int sourceUriType = imageRequest.getSourceUriType();
        if (sourceUriType == 0) {
            return getNetworkFetchToEncodedMemoryPrefetchSequence();
        }
        if (sourceUriType == 2 || sourceUriType == 3) {
            return getLocalFileFetchToEncodedMemoryPrefetchSequence();
        }
        Uri sourceUri = imageRequest.getSourceUri();
        Intrinsics.checkNotNullExpressionValue(sourceUri, "getSourceUri(...)");
        throw new IllegalArgumentException("Unsupported uri scheme for encoded image fetch! Uri is: " + companion.getShortenedUriString(sourceUri));
    }

    public final Producer<CloseableReference<CloseableImage>> getDecodedImageProducerSequence(@NotNull ImageRequest imageRequest) {
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        FrescoSystrace frescoSystrace = FrescoSystrace.INSTANCE;
        if (!FrescoSystrace.isTracing()) {
            Producer<CloseableReference<CloseableImage>> basicDecodedImageSequence = getBasicDecodedImageSequence(imageRequest);
            if (imageRequest.getPostprocessor() != null) {
                basicDecodedImageSequence = getPostprocessorSequence(basicDecodedImageSequence);
            }
            if (this.useBitmapPrepareToDraw) {
                basicDecodedImageSequence = getBitmapPrepareSequence(basicDecodedImageSequence);
            }
            return (!this.allowDelay || imageRequest.getDelayMs() <= 0) ? basicDecodedImageSequence : getDelaySequence(basicDecodedImageSequence);
        }
        FrescoSystrace.beginSection("ProducerSequenceFactory#getDecodedImageProducerSequence");
        try {
            Producer<CloseableReference<CloseableImage>> basicDecodedImageSequence2 = getBasicDecodedImageSequence(imageRequest);
            if (imageRequest.getPostprocessor() != null) {
                basicDecodedImageSequence2 = getPostprocessorSequence(basicDecodedImageSequence2);
            }
            if (this.useBitmapPrepareToDraw) {
                basicDecodedImageSequence2 = getBitmapPrepareSequence(basicDecodedImageSequence2);
            }
            if (this.allowDelay && imageRequest.getDelayMs() > 0) {
                basicDecodedImageSequence2 = getDelaySequence(basicDecodedImageSequence2);
            }
            return basicDecodedImageSequence2;
        } finally {
            FrescoSystrace.endSection();
        }
    }

    public final Producer<Void> getDecodedImagePrefetchProducerSequence(@NotNull ImageRequest imageRequest) {
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        Producer<CloseableReference<CloseableImage>> basicDecodedImageSequence = getBasicDecodedImageSequence(imageRequest);
        if (this.useBitmapPrepareToDraw) {
            basicDecodedImageSequence = getBitmapPrepareSequence(basicDecodedImageSequence);
        }
        return getDecodedImagePrefetchSequence(basicDecodedImageSequence);
    }

    private final Producer<CloseableReference<CloseableImage>> getBasicDecodedImageSequence(ImageRequest imageRequest) {
        Producer<CloseableReference<CloseableImage>> networkFetchSequence;
        FrescoSystrace frescoSystrace = FrescoSystrace.INSTANCE;
        if (!FrescoSystrace.isTracing()) {
            Uri sourceUri = imageRequest.getSourceUri();
            Intrinsics.checkNotNullExpressionValue(sourceUri, "getSourceUri(...)");
            if (sourceUri == null) {
                throw new IllegalStateException("Uri is null.");
            }
            int sourceUriType = imageRequest.getSourceUriType();
            if (sourceUriType == 0) {
                return getNetworkFetchSequence();
            }
            switch (sourceUriType) {
                case 2:
                    return imageRequest.getLoadThumbnailOnlyForAndroidSdkAboveQ() ? getLocalThumbnailBitmapSdk29FetchSequence() : getLocalVideoFileFetchSequence();
                case 3:
                    return imageRequest.getLoadThumbnailOnlyForAndroidSdkAboveQ() ? getLocalThumbnailBitmapSdk29FetchSequence() : getLocalImageFileFetchSequence();
                case 4:
                    if (imageRequest.getLoadThumbnailOnlyForAndroidSdkAboveQ()) {
                        return getLocalThumbnailBitmapSdk29FetchSequence();
                    }
                    return MediaUtils.isVideo(this.contentResolver.getType(sourceUri)) ? getLocalVideoFileFetchSequence() : getLocalContentUriFetchSequence();
                case 5:
                    return getLocalAssetFetchSequence();
                case 6:
                    return getLocalResourceFetchSequence();
                case 7:
                    return getDataFetchSequence();
                case 8:
                    return getQualifiedResourceFetchSequence();
                default:
                    Set<CustomProducerSequenceFactory> set = this.customProducerSequenceFactories;
                    if (set != null) {
                        Iterator<CustomProducerSequenceFactory> it2 = set.iterator();
                        while (it2.hasNext()) {
                            Producer<CloseableReference<CloseableImage>> customDecodedImageSequence = it2.next().getCustomDecodedImageSequence(imageRequest, this, this.producerFactory, this.threadHandoffProducerQueue, this.isEncodedMemoryCacheProbingEnabled, this.isDiskCacheProbingEnabled);
                            if (customDecodedImageSequence != null) {
                                return customDecodedImageSequence;
                            }
                        }
                    }
                    throw new IllegalArgumentException("Unsupported uri scheme! Uri is: " + Companion.getShortenedUriString(sourceUri));
            }
        }
        FrescoSystrace.beginSection("ProducerSequenceFactory#getBasicDecodedImageSequence");
        try {
            Uri sourceUri2 = imageRequest.getSourceUri();
            Intrinsics.checkNotNullExpressionValue(sourceUri2, "getSourceUri(...)");
            if (sourceUri2 == null) {
                throw new IllegalStateException("Uri is null.");
            }
            int sourceUriType2 = imageRequest.getSourceUriType();
            if (sourceUriType2 != 0) {
                switch (sourceUriType2) {
                    case 2:
                        if (imageRequest.getLoadThumbnailOnlyForAndroidSdkAboveQ()) {
                            Producer<CloseableReference<CloseableImage>> localThumbnailBitmapSdk29FetchSequence = getLocalThumbnailBitmapSdk29FetchSequence();
                            FrescoSystrace.endSection();
                            return localThumbnailBitmapSdk29FetchSequence;
                        }
                        networkFetchSequence = getLocalVideoFileFetchSequence();
                        break;
                    case 3:
                        if (imageRequest.getLoadThumbnailOnlyForAndroidSdkAboveQ()) {
                            Producer<CloseableReference<CloseableImage>> localThumbnailBitmapSdk29FetchSequence2 = getLocalThumbnailBitmapSdk29FetchSequence();
                            FrescoSystrace.endSection();
                            return localThumbnailBitmapSdk29FetchSequence2;
                        }
                        networkFetchSequence = getLocalImageFileFetchSequence();
                        break;
                    case 4:
                        if (imageRequest.getLoadThumbnailOnlyForAndroidSdkAboveQ()) {
                            Producer<CloseableReference<CloseableImage>> localThumbnailBitmapSdk29FetchSequence3 = getLocalThumbnailBitmapSdk29FetchSequence();
                            FrescoSystrace.endSection();
                            return localThumbnailBitmapSdk29FetchSequence3;
                        }
                        if (MediaUtils.isVideo(this.contentResolver.getType(sourceUri2))) {
                            Producer<CloseableReference<CloseableImage>> localVideoFileFetchSequence = getLocalVideoFileFetchSequence();
                            FrescoSystrace.endSection();
                            return localVideoFileFetchSequence;
                        }
                        networkFetchSequence = getLocalContentUriFetchSequence();
                        break;
                    case 5:
                        networkFetchSequence = getLocalAssetFetchSequence();
                        break;
                    case 6:
                        networkFetchSequence = getLocalResourceFetchSequence();
                        break;
                    case 7:
                        networkFetchSequence = getDataFetchSequence();
                        break;
                    case 8:
                        networkFetchSequence = getQualifiedResourceFetchSequence();
                        break;
                    default:
                        Set<CustomProducerSequenceFactory> set2 = this.customProducerSequenceFactories;
                        if (set2 != null) {
                            Iterator<CustomProducerSequenceFactory> it3 = set2.iterator();
                            while (it3.hasNext()) {
                                Producer<CloseableReference<CloseableImage>> customDecodedImageSequence2 = it3.next().getCustomDecodedImageSequence(imageRequest, this, this.producerFactory, this.threadHandoffProducerQueue, this.isEncodedMemoryCacheProbingEnabled, this.isDiskCacheProbingEnabled);
                                if (customDecodedImageSequence2 != null) {
                                    FrescoSystrace.endSection();
                                    return customDecodedImageSequence2;
                                }
                            }
                        }
                        throw new IllegalArgumentException("Unsupported uri scheme! Uri is: " + Companion.getShortenedUriString(sourceUri2));
                }
            } else {
                networkFetchSequence = getNetworkFetchSequence();
            }
            FrescoSystrace.endSection();
            return networkFetchSequence;
        } catch (Throwable th) {
            FrescoSystrace.endSection();
            throw th;
        }
    }

    public final Producer<CloseableReference<CloseableImage>> getNetworkFetchSequence() {
        return (Producer) this.networkFetchSequence$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Producer networkFetchSequence_delegate$lambda$11(ProducerSequenceFactory this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FrescoSystrace frescoSystrace = FrescoSystrace.INSTANCE;
        if (!FrescoSystrace.isTracing()) {
            return this$0.newBitmapCacheGetToDecodeSequence(this$0.getCommonNetworkFetchToEncodedMemorySequence());
        }
        FrescoSystrace.beginSection("ProducerSequenceFactory#getNetworkFetchSequence:init");
        try {
            return this$0.newBitmapCacheGetToDecodeSequence(this$0.getCommonNetworkFetchToEncodedMemorySequence());
        } finally {
            FrescoSystrace.endSection();
        }
    }

    public final Producer<EncodedImage> getBackgroundNetworkFetchToEncodedMemorySequence() {
        Object value = this.backgroundNetworkFetchToEncodedMemorySequence$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Producer) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Producer backgroundNetworkFetchToEncodedMemorySequence_delegate$lambda$13(ProducerSequenceFactory this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FrescoSystrace frescoSystrace = FrescoSystrace.INSTANCE;
        if (!FrescoSystrace.isTracing()) {
            return this$0.producerFactory.newBackgroundThreadHandoffProducer(this$0.getCommonNetworkFetchToEncodedMemorySequence(), this$0.threadHandoffProducerQueue);
        }
        FrescoSystrace.beginSection("ProducerSequenceFactory#getBackgroundNetworkFetchToEncodedMemorySequence:init");
        try {
            return this$0.producerFactory.newBackgroundThreadHandoffProducer(this$0.getCommonNetworkFetchToEncodedMemorySequence(), this$0.threadHandoffProducerQueue);
        } finally {
            FrescoSystrace.endSection();
        }
    }

    public final Producer<Void> getNetworkFetchToEncodedMemoryPrefetchSequence() {
        Object value = this.networkFetchToEncodedMemoryPrefetchSequence$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Producer) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SwallowResultProducer networkFetchToEncodedMemoryPrefetchSequence_delegate$lambda$15(ProducerSequenceFactory this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FrescoSystrace frescoSystrace = FrescoSystrace.INSTANCE;
        if (!FrescoSystrace.isTracing()) {
            return this$0.producerFactory.newSwallowResultProducer(this$0.getBackgroundNetworkFetchToEncodedMemorySequence());
        }
        FrescoSystrace.beginSection("ProducerSequenceFactory#getNetworkFetchToEncodedMemoryPrefetchSequence");
        try {
            return this$0.producerFactory.newSwallowResultProducer(this$0.getBackgroundNetworkFetchToEncodedMemorySequence());
        } finally {
            FrescoSystrace.endSection();
        }
    }

    public final Producer<EncodedImage> getCommonNetworkFetchToEncodedMemorySequence() {
        return (Producer) this.commonNetworkFetchToEncodedMemorySequence$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Producer commonNetworkFetchToEncodedMemorySequence_delegate$lambda$17(ProducerSequenceFactory this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FrescoSystrace frescoSystrace = FrescoSystrace.INSTANCE;
        if (!FrescoSystrace.isTracing()) {
            return this$0.newCommonNetworkFetchToEncodedMemorySequence(this$0.networkFetcher);
        }
        FrescoSystrace.beginSection("ProducerSequenceFactory#getCommonNetworkFetchToEncodedMemorySequence");
        try {
            return this$0.newCommonNetworkFetchToEncodedMemorySequence(this$0.networkFetcher);
        } finally {
            FrescoSystrace.endSection();
        }
    }

    public final Producer<EncodedImage> newCommonNetworkFetchToEncodedMemorySequence(@NotNull NetworkFetcher<?> networkFetcher) {
        synchronized (this) {
            Intrinsics.checkNotNullParameter(networkFetcher, "networkFetcher");
            FrescoSystrace frescoSystrace = FrescoSystrace.INSTANCE;
            boolean z = true;
            if (!FrescoSystrace.isTracing()) {
                Producer<EncodedImage> producerNewNetworkFetchProducer = this.producerFactory.newNetworkFetchProducer(networkFetcher);
                Intrinsics.checkNotNullExpressionValue(producerNewNetworkFetchProducer, "newNetworkFetchProducer(...)");
                AddImageTransformMetaDataProducer addImageTransformMetaDataProducerNewAddImageTransformMetaDataProducer = ProducerFactory.newAddImageTransformMetaDataProducer(newEncodedCacheMultiplexToTranscodeSequence(producerNewNetworkFetchProducer));
                Intrinsics.checkNotNullExpressionValue(addImageTransformMetaDataProducerNewAddImageTransformMetaDataProducer, "newAddImageTransformMetaDataProducer(...)");
                ProducerFactory producerFactory = this.producerFactory;
                if (!this.resizeAndRotateEnabledForNetwork || this.downsampleMode == DownsampleMode.NEVER) {
                    z = false;
                }
                return producerFactory.newResizeAndRotateProducer(addImageTransformMetaDataProducerNewAddImageTransformMetaDataProducer, z, this.imageTranscoderFactory);
            }
            FrescoSystrace.beginSection("ProducerSequenceFactory#createCommonNetworkFetchToEncodedMemorySequence");
            try {
                Producer<EncodedImage> producerNewNetworkFetchProducer2 = this.producerFactory.newNetworkFetchProducer(networkFetcher);
                Intrinsics.checkNotNullExpressionValue(producerNewNetworkFetchProducer2, "newNetworkFetchProducer(...)");
                AddImageTransformMetaDataProducer addImageTransformMetaDataProducerNewAddImageTransformMetaDataProducer2 = ProducerFactory.newAddImageTransformMetaDataProducer(newEncodedCacheMultiplexToTranscodeSequence(producerNewNetworkFetchProducer2));
                Intrinsics.checkNotNullExpressionValue(addImageTransformMetaDataProducerNewAddImageTransformMetaDataProducer2, "newAddImageTransformMetaDataProducer(...)");
                ProducerFactory producerFactory2 = this.producerFactory;
                if (!this.resizeAndRotateEnabledForNetwork || this.downsampleMode == DownsampleMode.NEVER) {
                    z = false;
                }
                ResizeAndRotateProducer resizeAndRotateProducerNewResizeAndRotateProducer = producerFactory2.newResizeAndRotateProducer(addImageTransformMetaDataProducerNewAddImageTransformMetaDataProducer2, z, this.imageTranscoderFactory);
                FrescoSystrace.endSection();
                return resizeAndRotateProducerNewResizeAndRotateProducer;
            } catch (Throwable th) {
                FrescoSystrace.endSection();
                throw th;
            }
        }
    }

    public final Producer<Void> getLocalFileFetchToEncodedMemoryPrefetchSequence() {
        Object value = this.localFileFetchToEncodedMemoryPrefetchSequence$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Producer) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SwallowResultProducer localFileFetchToEncodedMemoryPrefetchSequence_delegate$lambda$20(ProducerSequenceFactory this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FrescoSystrace frescoSystrace = FrescoSystrace.INSTANCE;
        if (!FrescoSystrace.isTracing()) {
            return this$0.producerFactory.newSwallowResultProducer(this$0.getBackgroundLocalFileFetchToEncodeMemorySequence());
        }
        FrescoSystrace.beginSection("ProducerSequenceFactory#getLocalFileFetchToEncodedMemoryPrefetchSequence:init");
        try {
            return this$0.producerFactory.newSwallowResultProducer(this$0.getBackgroundLocalFileFetchToEncodeMemorySequence());
        } finally {
            FrescoSystrace.endSection();
        }
    }

    public final Producer<EncodedImage> getBackgroundLocalFileFetchToEncodeMemorySequence() {
        Object value = this.backgroundLocalFileFetchToEncodeMemorySequence$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Producer) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Producer backgroundLocalFileFetchToEncodeMemorySequence_delegate$lambda$22(ProducerSequenceFactory this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FrescoSystrace frescoSystrace = FrescoSystrace.INSTANCE;
        if (!FrescoSystrace.isTracing()) {
            LocalFileFetchProducer localFileFetchProducerNewLocalFileFetchProducer = this$0.producerFactory.newLocalFileFetchProducer();
            Intrinsics.checkNotNullExpressionValue(localFileFetchProducerNewLocalFileFetchProducer, "newLocalFileFetchProducer(...)");
            return this$0.producerFactory.newBackgroundThreadHandoffProducer(this$0.newEncodedCacheMultiplexToTranscodeSequence(localFileFetchProducerNewLocalFileFetchProducer), this$0.threadHandoffProducerQueue);
        }
        FrescoSystrace.beginSection("ProducerSequenceFactory#getBackgroundLocalFileFetchToEncodeMemorySequence");
        try {
            LocalFileFetchProducer localFileFetchProducerNewLocalFileFetchProducer2 = this$0.producerFactory.newLocalFileFetchProducer();
            Intrinsics.checkNotNullExpressionValue(localFileFetchProducerNewLocalFileFetchProducer2, "newLocalFileFetchProducer(...)");
            return this$0.producerFactory.newBackgroundThreadHandoffProducer(this$0.newEncodedCacheMultiplexToTranscodeSequence(localFileFetchProducerNewLocalFileFetchProducer2), this$0.threadHandoffProducerQueue);
        } finally {
            FrescoSystrace.endSection();
        }
    }

    public final Producer<EncodedImage> getBackgroundLocalContentUriFetchToEncodeMemorySequence() {
        Object value = this.backgroundLocalContentUriFetchToEncodeMemorySequence$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Producer) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Producer backgroundLocalContentUriFetchToEncodeMemorySequence_delegate$lambda$24(ProducerSequenceFactory this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FrescoSystrace frescoSystrace = FrescoSystrace.INSTANCE;
        if (!FrescoSystrace.isTracing()) {
            LocalContentUriFetchProducer localContentUriFetchProducerNewLocalContentUriFetchProducer = this$0.producerFactory.newLocalContentUriFetchProducer();
            Intrinsics.checkNotNullExpressionValue(localContentUriFetchProducerNewLocalContentUriFetchProducer, "newLocalContentUriFetchProducer(...)");
            return this$0.producerFactory.newBackgroundThreadHandoffProducer(this$0.newEncodedCacheMultiplexToTranscodeSequence(localContentUriFetchProducerNewLocalContentUriFetchProducer), this$0.threadHandoffProducerQueue);
        }
        FrescoSystrace.beginSection("ProducerSequenceFactory#getBackgroundLocalContentUriFetchToEncodeMemorySequence:init");
        try {
            LocalContentUriFetchProducer localContentUriFetchProducerNewLocalContentUriFetchProducer2 = this$0.producerFactory.newLocalContentUriFetchProducer();
            Intrinsics.checkNotNullExpressionValue(localContentUriFetchProducerNewLocalContentUriFetchProducer2, "newLocalContentUriFetchProducer(...)");
            return this$0.producerFactory.newBackgroundThreadHandoffProducer(this$0.newEncodedCacheMultiplexToTranscodeSequence(localContentUriFetchProducerNewLocalContentUriFetchProducer2), this$0.threadHandoffProducerQueue);
        } finally {
            FrescoSystrace.endSection();
        }
    }

    public final Producer<CloseableReference<CloseableImage>> getLocalImageFileFetchSequence() {
        return (Producer) this.localImageFileFetchSequence$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Producer localImageFileFetchSequence_delegate$lambda$25(ProducerSequenceFactory this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LocalFileFetchProducer localFileFetchProducerNewLocalFileFetchProducer = this$0.producerFactory.newLocalFileFetchProducer();
        Intrinsics.checkNotNullExpressionValue(localFileFetchProducerNewLocalFileFetchProducer, "newLocalFileFetchProducer(...)");
        return this$0.newBitmapCacheGetToLocalTransformSequence(localFileFetchProducerNewLocalFileFetchProducer);
    }

    public final Producer<CloseableReference<CloseableImage>> getLocalVideoFileFetchSequence() {
        return (Producer) this.localVideoFileFetchSequence$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Producer localVideoFileFetchSequence_delegate$lambda$26(ProducerSequenceFactory this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LocalVideoThumbnailProducer localVideoThumbnailProducerNewLocalVideoThumbnailProducer = this$0.producerFactory.newLocalVideoThumbnailProducer();
        Intrinsics.checkNotNullExpressionValue(localVideoThumbnailProducerNewLocalVideoThumbnailProducer, "newLocalVideoThumbnailProducer(...)");
        return this$0.newBitmapCacheGetToBitmapCacheSequence(localVideoThumbnailProducerNewLocalVideoThumbnailProducer);
    }

    public final Producer<CloseableReference<CloseableImage>> getLocalContentUriFetchSequence() {
        return (Producer) this.localContentUriFetchSequence$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Producer localContentUriFetchSequence_delegate$lambda$27(ProducerSequenceFactory this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LocalContentUriFetchProducer localContentUriFetchProducerNewLocalContentUriFetchProducer = this$0.producerFactory.newLocalContentUriFetchProducer();
        Intrinsics.checkNotNullExpressionValue(localContentUriFetchProducerNewLocalContentUriFetchProducer, "newLocalContentUriFetchProducer(...)");
        return this$0.newBitmapCacheGetToLocalTransformSequence(localContentUriFetchProducerNewLocalContentUriFetchProducer, new ThumbnailProducer[]{this$0.producerFactory.newLocalContentUriThumbnailFetchProducer(), this$0.producerFactory.newLocalExifThumbnailProducer()});
    }

    public final Producer<CloseableReference<CloseableImage>> getLocalThumbnailBitmapSdk29FetchSequence() {
        return (Producer) this.localThumbnailBitmapSdk29FetchSequence$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Producer localThumbnailBitmapSdk29FetchSequence_delegate$lambda$28(ProducerSequenceFactory this$0) throws Throwable {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Build.VERSION.SDK_INT >= 29) {
            LocalThumbnailBitmapSdk29Producer localThumbnailBitmapSdk29ProducerNewLocalThumbnailBitmapSdk29Producer = this$0.producerFactory.newLocalThumbnailBitmapSdk29Producer();
            Intrinsics.checkNotNullExpressionValue(localThumbnailBitmapSdk29ProducerNewLocalThumbnailBitmapSdk29Producer, "newLocalThumbnailBitmapSdk29Producer(...)");
            return this$0.newBitmapCacheGetToBitmapCacheSequence(localThumbnailBitmapSdk29ProducerNewLocalThumbnailBitmapSdk29Producer);
        }
        throw new Throwable("Unreachable exception. Just to make linter happy for the lazy block.");
    }

    public final Producer<CloseableReference<CloseableImage>> getQualifiedResourceFetchSequence() {
        return (Producer) this.qualifiedResourceFetchSequence$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Producer qualifiedResourceFetchSequence_delegate$lambda$29(ProducerSequenceFactory this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QualifiedResourceFetchProducer qualifiedResourceFetchProducerNewQualifiedResourceFetchProducer = this$0.producerFactory.newQualifiedResourceFetchProducer();
        Intrinsics.checkNotNullExpressionValue(qualifiedResourceFetchProducerNewQualifiedResourceFetchProducer, "newQualifiedResourceFetchProducer(...)");
        return this$0.newBitmapCacheGetToLocalTransformSequence(qualifiedResourceFetchProducerNewQualifiedResourceFetchProducer);
    }

    public final Producer<CloseableReference<CloseableImage>> getLocalResourceFetchSequence() {
        return (Producer) this.localResourceFetchSequence$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Producer localResourceFetchSequence_delegate$lambda$30(ProducerSequenceFactory this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LocalResourceFetchProducer localResourceFetchProducerNewLocalResourceFetchProducer = this$0.producerFactory.newLocalResourceFetchProducer();
        Intrinsics.checkNotNullExpressionValue(localResourceFetchProducerNewLocalResourceFetchProducer, "newLocalResourceFetchProducer(...)");
        return this$0.newBitmapCacheGetToLocalTransformSequence(localResourceFetchProducerNewLocalResourceFetchProducer);
    }

    public final Producer<CloseableReference<CloseableImage>> getLocalAssetFetchSequence() {
        return (Producer) this.localAssetFetchSequence$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Producer localAssetFetchSequence_delegate$lambda$31(ProducerSequenceFactory this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LocalAssetFetchProducer localAssetFetchProducerNewLocalAssetFetchProducer = this$0.producerFactory.newLocalAssetFetchProducer();
        Intrinsics.checkNotNullExpressionValue(localAssetFetchProducerNewLocalAssetFetchProducer, "newLocalAssetFetchProducer(...)");
        return this$0.newBitmapCacheGetToLocalTransformSequence(localAssetFetchProducerNewLocalAssetFetchProducer);
    }

    public final Producer<CloseableReference<CloseableImage>> getDataFetchSequence() {
        return (Producer) this.dataFetchSequence$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Producer dataFetchSequence_delegate$lambda$32(ProducerSequenceFactory this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DataFetchProducer dataFetchProducerNewDataFetchProducer = this$0.producerFactory.newDataFetchProducer();
        Intrinsics.checkNotNullExpressionValue(dataFetchProducerNewDataFetchProducer, "newDataFetchProducer(...)");
        return this$0.newBitmapCacheGetToDecodeSequence(this$0.producerFactory.newResizeAndRotateProducer(ProducerFactory.newAddImageTransformMetaDataProducer(dataFetchProducerNewDataFetchProducer), true, this$0.imageTranscoderFactory));
    }

    private final Producer<CloseableReference<CloseableImage>> newBitmapCacheGetToLocalTransformSequence(Producer<EncodedImage> producer) {
        return newBitmapCacheGetToLocalTransformSequence(producer, new ThumbnailProducer[]{this.producerFactory.newLocalExifThumbnailProducer()});
    }

    private final Producer<CloseableReference<CloseableImage>> newBitmapCacheGetToLocalTransformSequence(Producer<EncodedImage> producer, ThumbnailProducer<EncodedImage>[] thumbnailProducerArr) {
        return newBitmapCacheGetToDecodeSequence(newLocalTransformationsSequence(newEncodedCacheMultiplexToTranscodeSequence(producer), thumbnailProducerArr));
    }

    public final Producer<CloseableReference<CloseableImage>> newBitmapCacheGetToDecodeSequence(@NotNull Producer<EncodedImage> inputProducer) {
        Intrinsics.checkNotNullParameter(inputProducer, "inputProducer");
        FrescoSystrace frescoSystrace = FrescoSystrace.INSTANCE;
        if (!FrescoSystrace.isTracing()) {
            DecodeProducer decodeProducerNewDecodeProducer = this.producerFactory.newDecodeProducer(inputProducer);
            Intrinsics.checkNotNullExpressionValue(decodeProducerNewDecodeProducer, "newDecodeProducer(...)");
            return newBitmapCacheGetToBitmapCacheSequence(decodeProducerNewDecodeProducer);
        }
        FrescoSystrace.beginSection("ProducerSequenceFactory#newBitmapCacheGetToDecodeSequence");
        try {
            DecodeProducer decodeProducerNewDecodeProducer2 = this.producerFactory.newDecodeProducer(inputProducer);
            Intrinsics.checkNotNullExpressionValue(decodeProducerNewDecodeProducer2, "newDecodeProducer(...)");
            return newBitmapCacheGetToBitmapCacheSequence(decodeProducerNewDecodeProducer2);
        } finally {
            FrescoSystrace.endSection();
        }
    }

    private final Producer<EncodedImage> newEncodedCacheMultiplexToTranscodeSequence(Producer<EncodedImage> producer) {
        if (this.diskCacheEnabled) {
            producer = newDiskCacheSequence(producer);
        }
        Producer<EncodedImage> producerNewEncodedMemoryCacheProducer = this.producerFactory.newEncodedMemoryCacheProducer(producer);
        Intrinsics.checkNotNullExpressionValue(producerNewEncodedMemoryCacheProducer, "newEncodedMemoryCacheProducer(...)");
        if (this.isDiskCacheProbingEnabled) {
            EncodedProbeProducer encodedProbeProducerNewEncodedProbeProducer = this.producerFactory.newEncodedProbeProducer(producerNewEncodedMemoryCacheProducer);
            Intrinsics.checkNotNullExpressionValue(encodedProbeProducerNewEncodedProbeProducer, "newEncodedProbeProducer(...)");
            EncodedCacheKeyMultiplexProducer encodedCacheKeyMultiplexProducerNewEncodedCacheKeyMultiplexProducer = this.producerFactory.newEncodedCacheKeyMultiplexProducer(encodedProbeProducerNewEncodedProbeProducer);
            Intrinsics.checkNotNullExpressionValue(encodedCacheKeyMultiplexProducerNewEncodedCacheKeyMultiplexProducer, "newEncodedCacheKeyMultiplexProducer(...)");
            return encodedCacheKeyMultiplexProducerNewEncodedCacheKeyMultiplexProducer;
        }
        EncodedCacheKeyMultiplexProducer encodedCacheKeyMultiplexProducerNewEncodedCacheKeyMultiplexProducer2 = this.producerFactory.newEncodedCacheKeyMultiplexProducer(producerNewEncodedMemoryCacheProducer);
        Intrinsics.checkNotNullExpressionValue(encodedCacheKeyMultiplexProducerNewEncodedCacheKeyMultiplexProducer2, "newEncodedCacheKeyMultiplexProducer(...)");
        return encodedCacheKeyMultiplexProducerNewEncodedCacheKeyMultiplexProducer2;
    }

    private final Producer<EncodedImage> newDiskCacheSequence(Producer<EncodedImage> producer) {
        DiskCacheWriteProducer diskCacheWriteProducerNewDiskCacheWriteProducer;
        DiskCacheWriteProducer diskCacheWriteProducerNewDiskCacheWriteProducer2;
        FrescoSystrace frescoSystrace = FrescoSystrace.INSTANCE;
        if (!FrescoSystrace.isTracing()) {
            if (this.partialImageCachingEnabled) {
                PartialDiskCacheProducer partialDiskCacheProducerNewPartialDiskCacheProducer = this.producerFactory.newPartialDiskCacheProducer(producer);
                Intrinsics.checkNotNullExpressionValue(partialDiskCacheProducerNewPartialDiskCacheProducer, "newPartialDiskCacheProducer(...)");
                diskCacheWriteProducerNewDiskCacheWriteProducer2 = this.producerFactory.newDiskCacheWriteProducer(partialDiskCacheProducerNewPartialDiskCacheProducer);
            } else {
                diskCacheWriteProducerNewDiskCacheWriteProducer2 = this.producerFactory.newDiskCacheWriteProducer(producer);
            }
            Intrinsics.checkNotNull(diskCacheWriteProducerNewDiskCacheWriteProducer2);
            DiskCacheReadProducer diskCacheReadProducerNewDiskCacheReadProducer = this.producerFactory.newDiskCacheReadProducer(diskCacheWriteProducerNewDiskCacheWriteProducer2);
            Intrinsics.checkNotNullExpressionValue(diskCacheReadProducerNewDiskCacheReadProducer, "newDiskCacheReadProducer(...)");
            return diskCacheReadProducerNewDiskCacheReadProducer;
        }
        FrescoSystrace.beginSection("ProducerSequenceFactory#newDiskCacheSequence");
        try {
            if (this.partialImageCachingEnabled) {
                PartialDiskCacheProducer partialDiskCacheProducerNewPartialDiskCacheProducer2 = this.producerFactory.newPartialDiskCacheProducer(producer);
                Intrinsics.checkNotNullExpressionValue(partialDiskCacheProducerNewPartialDiskCacheProducer2, "newPartialDiskCacheProducer(...)");
                diskCacheWriteProducerNewDiskCacheWriteProducer = this.producerFactory.newDiskCacheWriteProducer(partialDiskCacheProducerNewPartialDiskCacheProducer2);
            } else {
                diskCacheWriteProducerNewDiskCacheWriteProducer = this.producerFactory.newDiskCacheWriteProducer(producer);
            }
            Intrinsics.checkNotNull(diskCacheWriteProducerNewDiskCacheWriteProducer);
            DiskCacheReadProducer diskCacheReadProducerNewDiskCacheReadProducer2 = this.producerFactory.newDiskCacheReadProducer(diskCacheWriteProducerNewDiskCacheWriteProducer);
            Intrinsics.checkNotNullExpressionValue(diskCacheReadProducerNewDiskCacheReadProducer2, "newDiskCacheReadProducer(...)");
            return diskCacheReadProducerNewDiskCacheReadProducer2;
        } finally {
            FrescoSystrace.endSection();
        }
    }

    private final Producer<CloseableReference<CloseableImage>> newBitmapCacheGetToBitmapCacheSequence(Producer<CloseableReference<CloseableImage>> producer) {
        BitmapMemoryCacheProducer bitmapMemoryCacheProducerNewBitmapMemoryCacheProducer = this.producerFactory.newBitmapMemoryCacheProducer(producer);
        Intrinsics.checkNotNullExpressionValue(bitmapMemoryCacheProducerNewBitmapMemoryCacheProducer, "newBitmapMemoryCacheProducer(...)");
        BitmapMemoryCacheKeyMultiplexProducer bitmapMemoryCacheKeyMultiplexProducerNewBitmapMemoryCacheKeyMultiplexProducer = this.producerFactory.newBitmapMemoryCacheKeyMultiplexProducer(bitmapMemoryCacheProducerNewBitmapMemoryCacheProducer);
        Intrinsics.checkNotNullExpressionValue(bitmapMemoryCacheKeyMultiplexProducerNewBitmapMemoryCacheKeyMultiplexProducer, "newBitmapMemoryCacheKeyMultiplexProducer(...)");
        Producer<CloseableReference<CloseableImage>> producerNewBackgroundThreadHandoffProducer = this.producerFactory.newBackgroundThreadHandoffProducer(bitmapMemoryCacheKeyMultiplexProducerNewBitmapMemoryCacheKeyMultiplexProducer, this.threadHandoffProducerQueue);
        Intrinsics.checkNotNullExpressionValue(producerNewBackgroundThreadHandoffProducer, "newBackgroundThreadHandoffProducer(...)");
        if (this.isEncodedMemoryCacheProbingEnabled || this.isDiskCacheProbingEnabled) {
            BitmapMemoryCacheGetProducer bitmapMemoryCacheGetProducerNewBitmapMemoryCacheGetProducer = this.producerFactory.newBitmapMemoryCacheGetProducer(producerNewBackgroundThreadHandoffProducer);
            Intrinsics.checkNotNullExpressionValue(bitmapMemoryCacheGetProducerNewBitmapMemoryCacheGetProducer, "newBitmapMemoryCacheGetProducer(...)");
            BitmapProbeProducer bitmapProbeProducerNewBitmapProbeProducer = this.producerFactory.newBitmapProbeProducer(bitmapMemoryCacheGetProducerNewBitmapMemoryCacheGetProducer);
            Intrinsics.checkNotNullExpressionValue(bitmapProbeProducerNewBitmapProbeProducer, "newBitmapProbeProducer(...)");
            return bitmapProbeProducerNewBitmapProbeProducer;
        }
        BitmapMemoryCacheGetProducer bitmapMemoryCacheGetProducerNewBitmapMemoryCacheGetProducer2 = this.producerFactory.newBitmapMemoryCacheGetProducer(producerNewBackgroundThreadHandoffProducer);
        Intrinsics.checkNotNullExpressionValue(bitmapMemoryCacheGetProducerNewBitmapMemoryCacheGetProducer2, "newBitmapMemoryCacheGetProducer(...)");
        return bitmapMemoryCacheGetProducerNewBitmapMemoryCacheGetProducer2;
    }

    private final Producer<EncodedImage> newLocalTransformationsSequence(Producer<EncodedImage> producer, ThumbnailProducer<EncodedImage>[] thumbnailProducerArr) {
        AddImageTransformMetaDataProducer addImageTransformMetaDataProducerNewAddImageTransformMetaDataProducer = ProducerFactory.newAddImageTransformMetaDataProducer(producer);
        Intrinsics.checkNotNullExpressionValue(addImageTransformMetaDataProducerNewAddImageTransformMetaDataProducer, "newAddImageTransformMetaDataProducer(...)");
        ThrottlingProducer throttlingProducerNewThrottlingProducer = this.producerFactory.newThrottlingProducer(this.producerFactory.newResizeAndRotateProducer(addImageTransformMetaDataProducerNewAddImageTransformMetaDataProducer, true, this.imageTranscoderFactory));
        Intrinsics.checkNotNullExpressionValue(throttlingProducerNewThrottlingProducer, "newThrottlingProducer(...)");
        BranchOnSeparateImagesProducer branchOnSeparateImagesProducerNewBranchOnSeparateImagesProducer = ProducerFactory.newBranchOnSeparateImagesProducer(newLocalThumbnailProducer(thumbnailProducerArr), throttlingProducerNewThrottlingProducer);
        Intrinsics.checkNotNullExpressionValue(branchOnSeparateImagesProducerNewBranchOnSeparateImagesProducer, "newBranchOnSeparateImagesProducer(...)");
        return branchOnSeparateImagesProducerNewBranchOnSeparateImagesProducer;
    }

    private final Producer<EncodedImage> newLocalThumbnailProducer(ThumbnailProducer<EncodedImage>[] thumbnailProducerArr) {
        ThumbnailBranchProducer thumbnailBranchProducerNewThumbnailBranchProducer = this.producerFactory.newThumbnailBranchProducer(thumbnailProducerArr);
        Intrinsics.checkNotNullExpressionValue(thumbnailBranchProducerNewThumbnailBranchProducer, "newThumbnailBranchProducer(...)");
        ResizeAndRotateProducer resizeAndRotateProducerNewResizeAndRotateProducer = this.producerFactory.newResizeAndRotateProducer(thumbnailBranchProducerNewThumbnailBranchProducer, true, this.imageTranscoderFactory);
        Intrinsics.checkNotNullExpressionValue(resizeAndRotateProducerNewResizeAndRotateProducer, "newResizeAndRotateProducer(...)");
        return resizeAndRotateProducerNewResizeAndRotateProducer;
    }

    private final Producer<CloseableReference<CloseableImage>> getPostprocessorSequence(Producer<CloseableReference<CloseableImage>> producer) {
        Producer<CloseableReference<CloseableImage>> producerNewPostprocessorBitmapMemoryCacheProducer;
        synchronized (this) {
            producerNewPostprocessorBitmapMemoryCacheProducer = this.postprocessorSequences.get(producer);
            if (producerNewPostprocessorBitmapMemoryCacheProducer == null) {
                PostprocessorProducer postprocessorProducerNewPostprocessorProducer = this.producerFactory.newPostprocessorProducer(producer);
                Intrinsics.checkNotNullExpressionValue(postprocessorProducerNewPostprocessorProducer, "newPostprocessorProducer(...)");
                producerNewPostprocessorBitmapMemoryCacheProducer = this.producerFactory.newPostprocessorBitmapMemoryCacheProducer(postprocessorProducerNewPostprocessorProducer);
                this.postprocessorSequences.put(producer, producerNewPostprocessorBitmapMemoryCacheProducer);
            }
        }
        return producerNewPostprocessorBitmapMemoryCacheProducer;
    }

    private final Producer<Void> getDecodedImagePrefetchSequence(Producer<CloseableReference<CloseableImage>> producer) {
        Producer<Void> producerNewSwallowResultProducer;
        synchronized (this) {
            producerNewSwallowResultProducer = this.closeableImagePrefetchSequences.get(producer);
            if (producerNewSwallowResultProducer == null) {
                producerNewSwallowResultProducer = this.producerFactory.newSwallowResultProducer(producer);
                this.closeableImagePrefetchSequences.put(producer, producerNewSwallowResultProducer);
            }
        }
        return producerNewSwallowResultProducer;
    }

    private final Producer<CloseableReference<CloseableImage>> getBitmapPrepareSequence(Producer<CloseableReference<CloseableImage>> producer) {
        Producer<CloseableReference<CloseableImage>> producerNewBitmapPrepareProducer;
        synchronized (this) {
            producerNewBitmapPrepareProducer = this.bitmapPrepareSequences.get(producer);
            if (producerNewBitmapPrepareProducer == null) {
                producerNewBitmapPrepareProducer = this.producerFactory.newBitmapPrepareProducer(producer);
                this.bitmapPrepareSequences.put(producer, producerNewBitmapPrepareProducer);
            }
        }
        return producerNewBitmapPrepareProducer;
    }

    private final Producer<CloseableReference<CloseableImage>> getDelaySequence(Producer<CloseableReference<CloseableImage>> producer) {
        DelayProducer delayProducerNewDelayProducer;
        synchronized (this) {
            delayProducerNewDelayProducer = this.producerFactory.newDelayProducer(producer);
            Intrinsics.checkNotNullExpressionValue(delayProducerNewDelayProducer, "newDelayProducer(...)");
        }
        return delayProducerNewDelayProducer;
    }
}
