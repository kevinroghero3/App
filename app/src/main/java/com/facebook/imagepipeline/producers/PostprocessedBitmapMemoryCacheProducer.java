package com.facebook.imagepipeline.producers;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.net.SyslogConstants;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.references.CloseableReference;
import com.facebook.hermes.intl.Constants;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.Postprocessor;
import com.facebook.imagepipeline.request.RepeatedPostprocessor;
import com.google.common.base.Ascii;
import com.salesforce.marketingcloud.analytics.stats.b;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Random;
import javax.annotation.Nullable;
import kotlin.text.Typography;
import net.time4j.DayPeriod;
import o.ArtificialStackFrames;
import o.extraCallback;
import o.onMessageChannelReady;
import okhttp3.internal.ws.WebSocketProtocol;
import org.apache.commons.lang3.CharUtils;

/* JADX INFO: loaded from: classes2.dex */
public class PostprocessedBitmapMemoryCacheProducer implements Producer<CloseableReference<CloseableImage>> {
    public static final String PRODUCER_NAME = "PostprocessedBitmapMemoryCacheProducer";
    static final String VALUE_FOUND = "cached_value_found";
    private final CacheKeyFactory mCacheKeyFactory;
    private final Producer<CloseableReference<CloseableImage>> mInputProducer;
    private final MemoryCache<CacheKey, CloseableImage> mMemoryCache;

    public PostprocessedBitmapMemoryCacheProducer(MemoryCache<CacheKey, CloseableImage> memoryCache, CacheKeyFactory cacheKeyFactory, Producer<CloseableReference<CloseableImage>> producer) {
        this.mMemoryCache = memoryCache;
        this.mCacheKeyFactory = cacheKeyFactory;
        this.mInputProducer = producer;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext) {
        ProducerListener2 producerListener = producerContext.getProducerListener();
        ImageRequest imageRequest = producerContext.getImageRequest();
        Object callerContext = producerContext.getCallerContext();
        Postprocessor postprocessor = imageRequest.getPostprocessor();
        if (postprocessor == null || postprocessor.getPostprocessorCacheKey() == null) {
            this.mInputProducer.produceResults(consumer, producerContext);
            return;
        }
        producerListener.onProducerStart(producerContext, getProducerName());
        CacheKey postprocessedBitmapCacheKey = this.mCacheKeyFactory.getPostprocessedBitmapCacheKey(imageRequest, callerContext);
        CloseableReference<CloseableImage> closeableReference = producerContext.getImageRequest().isCacheEnabled(1) ? this.mMemoryCache.get(postprocessedBitmapCacheKey) : null;
        if (closeableReference != null) {
            producerListener.onProducerFinishWithSuccess(producerContext, getProducerName(), producerListener.requiresExtraMap(producerContext, getProducerName()) ? ImmutableMap.of("cached_value_found", "true") : null);
            producerListener.onUltimateProducerReached(producerContext, PRODUCER_NAME, true);
            producerContext.putOriginExtra("memory_bitmap", "postprocessed");
            consumer.onProgressUpdate(1.0f);
            consumer.onNewResult(closeableReference, 1);
            closeableReference.close();
            return;
        }
        CachedPostprocessorConsumer cachedPostprocessorConsumer = new CachedPostprocessorConsumer(consumer, postprocessedBitmapCacheKey, postprocessor instanceof RepeatedPostprocessor, this.mMemoryCache, producerContext.getImageRequest().isCacheEnabled(2));
        producerListener.onProducerFinishWithSuccess(producerContext, getProducerName(), producerListener.requiresExtraMap(producerContext, getProducerName()) ? ImmutableMap.of("cached_value_found", Constants.CASEFIRST_FALSE) : null);
        this.mInputProducer.produceResults(cachedPostprocessorConsumer, producerContext);
    }

    public static class CachedPostprocessorConsumer extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> {
        private final CacheKey mCacheKey;
        private final boolean mIsBitmapCacheEnabledForWrite;
        private final boolean mIsRepeatedProcessor;
        private final MemoryCache<CacheKey, CloseableImage> mMemoryCache;
        private static final byte[] $$a = {Ascii.RS, -66, -95, 114};
        private static final int $$b = 67;
        private static int $10 = 0;
        private static int $11 = 1;
        private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        private static int artificialFrame = 1;
        private static char[] ArtificialStackFrames = {39070, 44376, 44404, 44402, 44365, 44391, 44385, 44390, 44392, 39069, 44396, 44398, 44386, 44334, 44353, 39065, 44405, 39068, 44373, 44399, 44332, 44393, 44395, 44355, 39071, 44336, 44400, 44389, 44403, 44368, 44341, 44387, 44371, 44349, 44408, 44397, 44354, 44366, 44406, 44388, 44394, 39058, 39064, 44356, 44345, 44367, 44320, 44409, 39067};
        private static char coroutineCreation = 39069;
        private static char[] validateRelationship = {56150, 56156, 56132, 56134, 56173, 56130, 56144, 55971, 55989, 55975, 55970, 55976, 56131, 56177, 56149, 55988, 55991, 55972, 55978, 55984, 56163, 55990, 55973, 55969, 55980, 56129, 55982, 56140, 56136, 55979, 55993, 56164, 56161, 56152, 55983, 55963, 55974, 55960, 56139};
        private static int warmup = -1044260079;
        private static boolean requestPostMessageChannelWithExtras = true;
        private static boolean ICustomTabsServiceDefault = true;

        /* JADX WARN: Code duplicated, block: B:10:0x0023  */
        /* JADX WARN: Code duplicated, block: B:8:0x001d  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x002c). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static java.lang.String $$c(int r6, byte r7, short r8) {
            /*
                int r7 = r7 * 3
                int r0 = 1 - r7
                byte[] r1 = com.facebook.imagepipeline.producers.PostprocessedBitmapMemoryCacheProducer.CachedPostprocessorConsumer.$$a
                int r8 = r8 * 4
                int r8 = 4 - r8
                int r6 = 121 - r6
                byte[] r0 = new byte[r0]
                r2 = 0
                int r7 = 0 - r7
                if (r1 != 0) goto L17
                r3 = r8
                r4 = r2
                r8 = r7
                goto L2c
            L17:
                r3 = r2
            L18:
                byte r4 = (byte) r6
                r0[r3] = r4
                if (r3 != r7) goto L23
                java.lang.String r6 = new java.lang.String
                r6.<init>(r0, r2)
                return r6
            L23:
                r4 = r1[r8]
                int r3 = r3 + 1
                r5 = r8
                r8 = r6
                r6 = r4
                r4 = r3
                r3 = r5
            L2c:
                int r6 = -r6
                int r6 = r6 + r8
                int r8 = r3 + 1
                r3 = r4
                goto L18
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.PostprocessedBitmapMemoryCacheProducer.CachedPostprocessorConsumer.$$c(int, byte, short):java.lang.String");
        }

        public CachedPostprocessorConsumer(Consumer<CloseableReference<CloseableImage>> consumer, CacheKey cacheKey, boolean z, MemoryCache<CacheKey, CloseableImage> memoryCache, boolean z2) {
            super(consumer);
            this.mCacheKey = cacheKey;
            this.mIsRepeatedProcessor = z;
            this.mMemoryCache = memoryCache;
            this.mIsBitmapCacheEnabledForWrite = z2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(@Nullable CloseableReference<CloseableImage> closeableReference, int i) {
            if (closeableReference == null) {
                if (BaseConsumer.isLast(i)) {
                    getConsumer().onNewResult(null, i);
                }
            } else if (!BaseConsumer.isNotLast(i) || this.mIsRepeatedProcessor) {
                CloseableReference<CloseableImage> closeableReferenceCache = this.mIsBitmapCacheEnabledForWrite ? this.mMemoryCache.cache(this.mCacheKey, closeableReference) : null;
                try {
                    getConsumer().onProgressUpdate(1.0f);
                    Consumer<CloseableReference<CloseableImage>> consumer = getConsumer();
                    if (closeableReferenceCache != null) {
                        closeableReference = closeableReferenceCache;
                    }
                    consumer.onNewResult(closeableReference, i);
                } finally {
                    CloseableReference.closeSafely(closeableReferenceCache);
                }
            }
        }

        private static void b(char[] cArr, byte[] bArr, int i, int[] iArr, Object[] objArr) throws Throwable {
            char[] cArr2;
            int i2;
            int length;
            char[] cArr3;
            int i3 = 2 % 2;
            onMessageChannelReady onmessagechannelready = new onMessageChannelReady();
            char[] cArr4 = validateRelationship;
            char c = '0';
            int i4 = 0;
            if (cArr4 != null) {
                int i5 = $11 + 49;
                $10 = i5 % 128;
                if (i5 % 2 != 0) {
                    length = cArr4.length;
                    cArr3 = new char[length];
                } else {
                    length = cArr4.length;
                    cArr3 = new char[length];
                }
                int i6 = 0;
                while (i6 < length) {
                    int i7 = $11 + 77;
                    $10 = i7 % 128;
                    if (i7 % 2 != 0) {
                        try {
                            Object[] objArr2 = new Object[1];
                            objArr2[i4] = Integer.valueOf(cArr4[i6]);
                            Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(115862995);
                            if (objAccessartificialFrame == null) {
                                int packedPositionGroup = 26 - ExpandableListView.getPackedPositionGroup(0L);
                                char bitsPerPixel = (char) ((-1) - ImageFormat.getBitsPerPixel(i4));
                                int iLastIndexOf = TextUtils.lastIndexOf("", c) + 1042;
                                byte b = (byte) i4;
                                byte b2 = b;
                                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(packedPositionGroup, bitsPerPixel, iLastIndexOf, -1719489573, false, $$c(b, b2, b2), new Class[]{Integer.TYPE});
                            }
                            cArr3[i6] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                        } catch (Throwable th) {
                            Throwable cause = th.getCause();
                            if (cause == null) {
                                throw th;
                            }
                            throw cause;
                        }
                    } else {
                        Object[] objArr3 = {Integer.valueOf(cArr4[i6])};
                        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(115862995);
                        if (objAccessartificialFrame2 == null) {
                            byte b3 = (byte) 0;
                            byte b4 = b3;
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(View.resolveSizeAndState(0, 0, 0) + 26, (char) TextUtils.indexOf("", ""), 1041 - Color.green(0), -1719489573, false, $$c(b3, b4, b4), new Class[]{Integer.TYPE});
                        }
                        cArr3[i6] = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
                        i6++;
                    }
                    c = '0';
                    i4 = 0;
                }
                cArr4 = cArr3;
            }
            Object[] objArr4 = {Integer.valueOf(warmup)};
            Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1820173622);
            if (objAccessartificialFrame3 == null) {
                byte b5 = (byte) 0;
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(15 - Color.green(0), (char) (20488 - (ViewConfiguration.getMaximumFlingVelocity() >> 16)), (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 2148, 216472770, false, $$c((byte) 54, b5, b5), new Class[]{Integer.TYPE});
            }
            int iIntValue = ((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue();
            int i8 = 55;
            int i9 = 59174;
            if (ICustomTabsServiceDefault) {
                onmessagechannelready.c = bArr.length;
                char[] cArr5 = new char[onmessagechannelready.c];
                onmessagechannelready.a = 0;
                while (onmessagechannelready.a < onmessagechannelready.c) {
                    int i10 = $10 + 79;
                    $11 = i10 % 128;
                    int i11 = i10 % 2;
                    cArr5[onmessagechannelready.a] = (char) (cArr4[bArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] + i] - iIntValue);
                    Object[] objArr5 = {onmessagechannelready, onmessagechannelready};
                    Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-2083387879);
                    if (objAccessartificialFrame4 == null) {
                        byte b6 = (byte) 0;
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(20 - ImageFormat.getBitsPerPixel(0), (char) (View.getDefaultSize(0, 0) + 59174), (Process.myPid() >> 22) + 1943, 481771537, false, $$c((byte) 55, b6, b6), new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame4).invoke(null, objArr5);
                }
                objArr[0] = new String(cArr5);
                return;
            }
            if (!requestPostMessageChannelWithExtras) {
                onmessagechannelready.c = iArr.length;
                char[] cArr6 = new char[onmessagechannelready.c];
                onmessagechannelready.a = 0;
                int i12 = $11 + 113;
                $10 = i12 % 128;
                int i13 = i12 % 2;
                while (onmessagechannelready.a < onmessagechannelready.c) {
                    int i14 = $10 + 59;
                    $11 = i14 % 128;
                    int i15 = i14 % 2;
                    cArr6[onmessagechannelready.a] = (char) (cArr4[iArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] - i] - iIntValue);
                    onmessagechannelready.a++;
                }
                objArr[0] = new String(cArr6);
                return;
            }
            int i16 = $11 + 41;
            $10 = i16 % 128;
            if (i16 % 2 != 0) {
                onmessagechannelready.c = cArr.length;
                cArr2 = new char[onmessagechannelready.c];
                onmessagechannelready.a = 1;
            } else {
                onmessagechannelready.c = cArr.length;
                cArr2 = new char[onmessagechannelready.c];
                onmessagechannelready.a = 0;
            }
            while (onmessagechannelready.a < onmessagechannelready.c) {
                int i17 = $10 + 117;
                $11 = i17 % 128;
                if (i17 % 2 == 0) {
                    cArr2[onmessagechannelready.a] = (char) (cArr4[cArr[(onmessagechannelready.c % 1) >> onmessagechannelready.a] - i] >>> iIntValue);
                    Object[] objArr6 = {onmessagechannelready, onmessagechannelready};
                    Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-2083387879);
                    if (objAccessartificialFrame5 == null) {
                        byte b7 = (byte) 0;
                        objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(20 - TextUtils.lastIndexOf("", '0', 0, 0), (char) ((ViewConfiguration.getLongPressTimeout() >> 16) + i9), 1943 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), 481771537, false, $$c((byte) i8, b7, b7), new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame5).invoke(null, objArr6);
                    i8 = 55;
                } else {
                    cArr2[onmessagechannelready.a] = (char) (cArr4[cArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] - i] - iIntValue);
                    Object[] objArr7 = {onmessagechannelready, onmessagechannelready};
                    Object objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-2083387879);
                    if (objAccessartificialFrame6 == null) {
                        i2 = 55;
                        byte b8 = (byte) 0;
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(21 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) (((Process.getThreadPriority(0) + 20) >> 6) + i9), 1943 - View.resolveSize(0, 0), 481771537, false, $$c((byte) 55, b8, b8), new Class[]{Object.class, Object.class});
                    } else {
                        i2 = 55;
                    }
                    ((Method) objAccessartificialFrame6).invoke(null, objArr7);
                    i8 = i2;
                    i9 = 59174;
                }
            }
            objArr[0] = new String(cArr2);
        }

        private static void a(int i, char[] cArr, byte b, Object[] objArr) throws Throwable {
            int i2;
            char c;
            int i3 = 2;
            int i4 = 2 % 2;
            extraCallback extracallback = new extraCallback();
            char[] cArr2 = ArtificialStackFrames;
            int i5 = 24;
            char c2 = '0';
            float f = 0.0f;
            if (cArr2 != null) {
                int length = cArr2.length;
                char[] cArr3 = new char[length];
                int i6 = 0;
                while (i6 < length) {
                    int i7 = $10 + 3;
                    $11 = i7 % 128;
                    int i8 = i7 % i3;
                    try {
                        Object[] objArr2 = {Integer.valueOf(cArr2[i6])};
                        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1819279892);
                        if (objAccessartificialFrame == null) {
                            int iResolveSizeAndState = View.resolveSizeAndState(0, 0, 0) + 15;
                            char cLastIndexOf = (char) (TextUtils.lastIndexOf("", c2) + 20489);
                            int i9 = (PointF.length(f, f) > f ? 1 : (PointF.length(f, f) == f ? 0 : -1)) + 2148;
                            byte b2 = (byte) i5;
                            byte b3 = (byte) 0;
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(iResolveSizeAndState, cLastIndexOf, i9, 216710116, false, $$c(b2, b3, b3), new Class[]{Integer.TYPE});
                        }
                        cArr3[i6] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                        i6++;
                        i3 = 2;
                        i5 = 24;
                        c2 = '0';
                        f = 0.0f;
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
            char c3 = 6;
            if (objAccessartificialFrame2 == null) {
                byte b4 = (byte) 0;
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(15 - ((Process.getThreadPriority(0) + 20) >> 6), (char) (View.MeasureSpec.getSize(0) + 20488), TextUtils.lastIndexOf("", '0', 0) + 2149, 216710116, false, $$c((byte) 24, b4, b4), new Class[]{Integer.TYPE});
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
                    int i10 = $11 + 49;
                    $10 = i10 % 128;
                    int i11 = i10 % 2;
                    extracallback.createBrowser = cArr[extracallback.a];
                    extracallback.c = cArr[extracallback.a + 1];
                    if (extracallback.createBrowser == extracallback.c) {
                        cArr4[extracallback.a] = (char) (extracallback.createBrowser - b);
                        cArr4[extracallback.a + 1] = (char) (extracallback.c - b);
                        c = c3;
                    } else {
                        Object[] objArr4 = new Object[13];
                        objArr4[12] = extracallback;
                        objArr4[11] = Integer.valueOf(cCharValue);
                        objArr4[10] = extracallback;
                        objArr4[9] = extracallback;
                        objArr4[8] = Integer.valueOf(cCharValue);
                        objArr4[7] = extracallback;
                        objArr4[c3] = extracallback;
                        objArr4[5] = Integer.valueOf(cCharValue);
                        objArr4[4] = extracallback;
                        objArr4[3] = extracallback;
                        objArr4[2] = Integer.valueOf(cCharValue);
                        objArr4[1] = extracallback;
                        objArr4[0] = extracallback;
                        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1894223152);
                        if (objAccessartificialFrame3 == null) {
                            byte b5 = (byte) 0;
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(45 - TextUtils.indexOf((CharSequence) "", '0'), (char) (58859 - (ViewConfiguration.getJumpTapTimeout() >> 16)), 2464 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), 276640984, false, $$c((byte) 19, b5, b5), new Class[]{Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class});
                        }
                        if (((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue() == extracallback.g) {
                            int i12 = $10 + 67;
                            $11 = i12 % 128;
                            int i13 = i12 % 2;
                            Object[] objArr5 = {extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, Integer.valueOf(cCharValue), extracallback};
                            Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1361113423);
                            if (objAccessartificialFrame4 == null) {
                                byte b6 = (byte) 0;
                                c = 6;
                                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(24 - (ViewConfiguration.getKeyRepeatDelay() >> 16), (char) (ViewConfiguration.getFadingEdgeLength() >> 16), (ViewConfiguration.getEdgeSlop() >> 16) + 792, -834291897, false, $$c((byte) ($$b >>> 2), b6, b6), new Class[]{Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Integer.TYPE, Object.class});
                            } else {
                                c = 6;
                            }
                            int iIntValue = ((Integer) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).intValue();
                            int i14 = (extracallback.d * cCharValue) + extracallback.g;
                            cArr4[extracallback.a] = cArr2[iIntValue];
                            cArr4[extracallback.a + 1] = cArr2[i14];
                        } else {
                            c = 6;
                            if (extracallback.b == extracallback.d) {
                                int i15 = $11 + 23;
                                $10 = i15 % 128;
                                int i16 = i15 % 2;
                                extracallback.j = ((extracallback.j + cCharValue) - 1) % cCharValue;
                                extracallback.g = ((extracallback.g + cCharValue) - 1) % cCharValue;
                                int i17 = (extracallback.b * cCharValue) + extracallback.j;
                                int i18 = (extracallback.d * cCharValue) + extracallback.g;
                                cArr4[extracallback.a] = cArr2[i17];
                                cArr4[extracallback.a + 1] = cArr2[i18];
                            } else {
                                int i19 = (extracallback.b * cCharValue) + extracallback.g;
                                int i20 = (extracallback.d * cCharValue) + extracallback.j;
                                cArr4[extracallback.a] = cArr2[i19];
                                cArr4[extracallback.a + 1] = cArr2[i20];
                            }
                        }
                    }
                    extracallback.a += 2;
                    c3 = c;
                }
            }
            int i21 = 0;
            while (i21 < i) {
                int i22 = $11 + 97;
                $10 = i22 % 128;
                if (i22 % 2 != 0) {
                    cArr4[i21] = (char) (cArr4[i21] ^ 8533);
                    i21 += 76;
                } else {
                    cArr4[i21] = (char) (cArr4[i21] ^ 13722);
                    i21++;
                }
            }
            objArr[0] = new String(cArr4);
        }

        /* JADX WARN: Code duplicated, block: B:150:0x0dbd  */
        /* JADX WARN: Code duplicated, block: B:151:0x0dc4  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0 */
        /* JADX WARN: Type inference failed for: r2v1 */
        /* JADX WARN: Type inference failed for: r2v106 */
        /* JADX WARN: Type inference failed for: r2v107 */
        /* JADX WARN: Type inference failed for: r2v2 */
        /* JADX WARN: Type inference failed for: r2v54 */
        /* JADX WARN: Type inference failed for: r2v55 */
        /* JADX WARN: Type inference failed for: r2v58, types: [byte[]] */
        /* JADX WARN: Type inference failed for: r2v64 */
        /* JADX WARN: Type inference failed for: r2v65 */
        /* JADX WARN: Type inference failed for: r2v66 */
        /* JADX WARN: Type inference failed for: r2v8 */
        public static Object[] accessartificialFrame(Context context, int i, int i2) {
            Object[] objArr;
            int[] iArr;
            int[] iArr2;
            int i3;
            char c;
            int i4;
            Class<?> cls;
            Class<?> cls2;
            Class<?>[] clsArr;
            int threadPriority;
            int i5;
            int i6;
            int i7;
            int i8;
            int i9;
            int i10;
            int i11;
            int i12;
            String str;
            Method method;
            int i13;
            Object obj;
            ?? r2 = i2;
            int i14 = 2 % 2;
            int i15 = getARTIFICIAL_FRAME_PACKAGE_NAME + 71;
            int i16 = i15 % 128;
            artificialFrame = i16;
            Object obj2 = null;
            if (i15 % 2 == 0) {
                obj2.hashCode();
                throw null;
            }
            if (context == null) {
                objArr = new Object[4];
                int[] iArr3 = new int[1];
                int i17 = i16 + 59;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i17 % 128;
                int i18 = i17 % 2;
                objArr[0] = iArr3;
                int[] iArr4 = new int[1];
                objArr[1] = iArr4;
                objArr[2] = new int[1];
                int i19 = i16 + 101;
                int i20 = i19 % 128;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i20;
                int i21 = i19 % 2;
                int i22 = i20 + 37;
                int i23 = i22 % 128;
                artificialFrame = i23;
                if (i22 % 2 == 0) {
                    iArr4[1] = i;
                } else {
                    iArr3[0] = i;
                }
                iArr4[0] = i;
                objArr[3] = null;
                int i24 = (i23 ^ 69) + ((i23 & 69) << 1);
                getARTIFICIAL_FRAME_PACKAGE_NAME = i24 % 128;
                int i25 = i24 % 2;
                int iNextInt = new Random().nextInt();
                int i26 = -(-(569121036 + ((iNextInt | (-20749)) * (-381)) + (((~((~iNextInt) | 533866002)) | (-89149727)) * 381) + 7904988));
                int i27 = (r2 & i26) + (i26 | r2);
                int i28 = i27 << 13;
                int i29 = (i28 | i27) & (~(i27 & i28));
                int i30 = i29 >>> 17;
                int i31 = (i29 | i30) & (~(i29 & i30));
                int i32 = i31 << 5;
                ((int[]) objArr[2])[0] = (i31 | i32) & (~(i31 & i32));
                int i33 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                int i34 = ((i33 | 43) << 1) - (i33 ^ 43);
                artificialFrame = i34 % 128;
                int i35 = i34 % 2;
                i4 = 2;
            } else {
                try {
                    int longPressTimeout = 38 - (ViewConfiguration.getLongPressTimeout() >> 16);
                    char[] cArr = {CoreConstants.RIGHT_PARENTHESIS_CHAR, 5, CoreConstants.RIGHT_PARENTHESIS_CHAR, 3, CoreConstants.RIGHT_PARENTHESIS_CHAR, 20, '\"', 21, 30, 17, 0, 24, 5, CoreConstants.COMMA_CHAR, 20, CharUtils.CR, 23, '\t', '\t', 7, 28, 31, 13843, 13843, '\b', 6, ' ', 23, 22, ' ', 0, 24, '\n', ' ', 22, 27, 3, CharUtils.CR};
                    int i36 = -AndroidCharacter.getMirror('0');
                    int i37 = (i36 * 450) - 68544;
                    int i38 = ~i36;
                    int i39 = ~((i38 ^ 153) | (i38 & 153));
                    int i40 = ((-154) ^ i36) | ((-154) & i36);
                    int i41 = ~((i40 ^ i) | (i40 & i));
                    int i42 = -(-(((i39 ^ i41) | (i39 & i41)) * 449));
                    int i43 = (i37 ^ i42) + ((i37 & i42) << 1) + ((~(i38 | 153)) * (-1347));
                    int i44 = ~i36;
                    int i45 = ~((i44 & 153) | (i44 ^ 153));
                    int i46 = ~((1944596256 ^ i) | (1944596256 & i));
                    int i47 = ((1772287708 ^ i46) | (1772287708 & i46)) * (-964);
                    int i48 = (1976366638 & i47) + (1976366638 | i47);
                    int i49 = ~i;
                    int i50 = (i48 - (~(((~((1944596256 ^ i49) | (1944596256 & i49))) | 134402268) * (-964)))) - 1;
                    int i51 = ~i;
                    int i52 = ~((-326042975) | i51);
                    int i53 = -(-(((1059404896 ^ i52) | (1059404896 & i52)) * (-933)));
                    int i54 = (((-895654376) | i53) << 1) - ((-895654376) ^ i53);
                    int i55 = ~((1059404896 ^ i49) | (1059404896 & i49));
                    int i56 = ((i55 ^ (-1064254847)) | (i55 & (-1064254847))) * 933;
                    int i57 = ((i54 | i56) << 1) - (i54 ^ i56);
                    if (i50 <= (i57 ^ 1556909216) + ((i57 & 1556909216) << 1)) {
                        int i58 = ((-154) & i49) | ((-154) ^ i49);
                        int i59 = ~((i58 & i36) | (i58 ^ i36));
                        byte b = (byte) (i43 * (449 % ((i59 & i45) | (i45 ^ i59))));
                        Object[] objArr2 = new Object[1];
                        a(longPressTimeout, cArr, b, objArr2);
                        cls = Class.forName((String) objArr2[0]);
                    } else {
                        int i60 = ((-154) & i49) | ((-154) ^ i49);
                        int i61 = -(-(((~((i60 & i36) | (i60 ^ i36))) | i45) * 449));
                        Object[] objArr3 = new Object[1];
                        a(longPressTimeout, cArr, (byte) ((i43 & i61) + (i61 | i43)), objArr3);
                        cls = Class.forName((String) objArr3[0]);
                    }
                    Object[] objArr4 = (Object[]) Array.newInstance(cls, 2);
                    int i62 = -(ViewConfiguration.getPressedStateDuration() >> 16);
                    int i63 = (i62 * 471) + 14601;
                    int i64 = ((i62 ^ 31) | (i62 & 31)) * (-470);
                    int i65 = (i63 ^ i64) + ((i63 & i64) << 1);
                    int i66 = ~i62;
                    int i67 = ~((i66 & (-32)) | (i66 ^ (-32)));
                    int i68 = ~(((-32) ^ i) | ((-32) & i));
                    int i69 = (i67 & i68) | (i67 ^ i68);
                    int i70 = (i51 ^ i62) | (i51 & i62);
                    int i71 = ~((i70 & 31) | (i70 ^ 31));
                    int i72 = -(-(((i69 & i71) | (i69 ^ i71)) * (-470)));
                    int i73 = (i65 ^ i72) + ((i72 & i65) << 1);
                    int i74 = ((-32) ^ i62) | ((-32) & i62);
                    int i75 = ~((i74 & i) | (i74 ^ i));
                    int i76 = i62 | i51;
                    int i77 = ~((i76 & 31) | (i76 ^ 31));
                    int i78 = ((i77 & i75) | (i75 ^ i77)) * 470;
                    int i79 = (i73 & i78) + (i78 | i73);
                    char[] cArr2 = {30, CoreConstants.COMMA_CHAR, 28, 19, 18, '.', 5, 17, 25, '#', '/', CoreConstants.COMMA_CHAR, 26, CharUtils.CR, 19, 2, 17, '0', 28, 19, 18, '.', 5, 17, 25, '#', 16, 27, ' ', 19, 13845};
                    int i80 = -(-(ViewConfiguration.getDoubleTapTimeout() >> 16));
                    Object[] objArr5 = new Object[1];
                    a(i79, cArr2, (byte) ((i80 ^ 76) + ((i80 & 76) << 1)), objArr5);
                    try {
                        Object[] objArr6 = {(String) objArr5[0]};
                        int i81 = -(-(ViewConfiguration.getMaximumFlingVelocity() >> 16));
                        int i82 = (i81 ^ 38) + ((i81 & 38) << 1);
                        char[] cArr3 = {CoreConstants.RIGHT_PARENTHESIS_CHAR, 5, CoreConstants.RIGHT_PARENTHESIS_CHAR, 3, CoreConstants.RIGHT_PARENTHESIS_CHAR, 20, '\"', 21, 30, 17, 0, 24, 5, CoreConstants.COMMA_CHAR, 20, CharUtils.CR, 23, '\t', '\t', 7, 28, 31, 13843, 13843, '\b', 6, ' ', 23, 22, ' ', 0, 24, '\n', ' ', 22, 27, 3, CharUtils.CR};
                        int i83 = artificialFrame + 89;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i83 % 128;
                        if (i83 % 2 != 0) {
                            Object[] objArr7 = new Object[1];
                            a(i82, cArr3, (byte) (105 >> Drawable.resolveOpacity(0, 0)), objArr7);
                            cls2 = Class.forName((String) objArr7[0]);
                            clsArr = new Class[0];
                            clsArr[0] = String.class;
                        } else {
                            int iResolveOpacity = Drawable.resolveOpacity(0, 0);
                            Object[] objArr8 = new Object[1];
                            a(i82, cArr3, (byte) (((iResolveOpacity | 105) << 1) - (iResolveOpacity ^ 105)), objArr8);
                            cls2 = Class.forName((String) objArr8[0]);
                            clsArr = new Class[]{String.class};
                        }
                        objArr4[0] = cls2.getDeclaredConstructor(clsArr).newInstance(objArr6);
                        byte[] bArr = {-109, -110, -111, -112, -113, -114, -119, -116, -117, -118, -119, -120, -121, -126, -115, -127, -123, -119, -116, -117, -118, -119, -120, -121, -126, -122, -123, -124, -125, -126, -127};
                        int i84 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                        int i85 = (i84 & 23) + (i84 | 23);
                        artificialFrame = i85 % 128;
                        if (i85 % 2 == 0) {
                            threadPriority = Process.getThreadPriority(1);
                            i5 = 94;
                            i6 = 79;
                        } else {
                            threadPriority = Process.getThreadPriority(0);
                            i5 = 127;
                            i6 = 20;
                        }
                        int i86 = (-661) * i6;
                        int i87 = -(-(threadPriority * (-661)));
                        int i88 = ((i86 | i87) << 1) - (i86 ^ i87);
                        int i89 = ~i6;
                        int i90 = ~threadPriority;
                        int i91 = -(-(((~((i89 ^ i90) | (i89 & i90))) | i49) * 1324));
                        int i92 = ((i88 | i91) << 1) - (i88 ^ i91);
                        int i93 = ~(i6 | i);
                        int i94 = ~((threadPriority ^ i) | (threadPriority & i));
                        int i95 = i92 + (((i93 ^ i94) | (i94 & i93)) * (-1324));
                        int i96 = ~i6;
                        int i97 = -(-(((~((i96 & threadPriority) | (i96 ^ threadPriority))) | (~((~threadPriority) | i6))) * 662));
                        int i98 = -((((i95 | i97) << 1) - (i97 ^ i95)) >> 6);
                        int i99 = (i5 ^ i98) + ((i98 & i5) << 1);
                        Object[] objArr9 = new Object[1];
                        b(null, bArr, i99, null, objArr9);
                        try {
                            Object[] objArr10 = {(String) objArr9[0]};
                            int longPressTimeout2 = ViewConfiguration.getLongPressTimeout() >> 16;
                            int i100 = ((longPressTimeout2 | 38) << 1) - (longPressTimeout2 ^ 38);
                            char[] cArr4 = {CoreConstants.RIGHT_PARENTHESIS_CHAR, 5, CoreConstants.RIGHT_PARENTHESIS_CHAR, 3, CoreConstants.RIGHT_PARENTHESIS_CHAR, 20, '\"', 21, 30, 17, 0, 24, 5, CoreConstants.COMMA_CHAR, 20, CharUtils.CR, 23, '\t', '\t', 7, 28, 31, 13843, 13843, '\b', 6, ' ', 23, 22, ' ', 0, 24, '\n', ' ', 22, 27, 3, CharUtils.CR};
                            int iIndexOf = TextUtils.indexOf("", "", 0);
                            int i101 = iIndexOf * 471;
                            int i102 = (i101 ^ 49455) + ((i101 & 49455) << 1);
                            int i103 = ((iIndexOf ^ 105) | (iIndexOf & 105)) * (-470);
                            int i104 = (i102 ^ i103) + ((i103 & i102) << 1);
                            int i105 = ~iIndexOf;
                            int i106 = ~((i105 & (-106)) | (i105 ^ (-106)));
                            DayPeriod.Extension.postOrRun();
                            DayPeriod.Extension.postOrRun();
                            int i107 = ~(((-106) ^ i) | ((-106) & i));
                            int i108 = (i106 ^ i107) | (i106 & i107);
                            int i109 = ~(i51 | iIndexOf | 105);
                            int i110 = (-470) * ((i108 ^ i109) | (i108 & i109));
                            int i111 = (i104 ^ i110) + ((i104 & i110) << 1);
                            int i112 = ((-106) ^ iIndexOf) | ((-106) & iIndexOf);
                            int i113 = ~((i112 & i) | (i112 ^ i));
                            int i114 = (iIndexOf & i49) | (i49 ^ iIndexOf);
                            int i115 = ~((i114 & 105) | (i114 ^ 105));
                            int i116 = ((i115 & i113) | (i113 ^ i115)) * 470;
                            byte b2 = (byte) ((i111 ^ i116) + ((i116 & i111) << 1));
                            Object[] objArr11 = new Object[1];
                            a(i100, cArr4, b2, objArr11);
                            objArr4[1] = Class.forName((String) objArr11[0]).getDeclaredConstructor(String.class).newInstance(objArr10);
                            try {
                                int i117 = -(TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                                int i118 = (i117 & 23) + (i117 | 23);
                                char[] cArr5 = {4, CharUtils.CR, Typography.amp, 4, 14, 26, CoreConstants.RIGHT_PARENTHESIS_CHAR, 11, '!', 17, '\t', 4, 25, CharUtils.CR, 6, '\t', 26, 16, '\t', 4, '\"', CoreConstants.RIGHT_PARENTHESIS_CHAR, 13898};
                                int trimmedLength = TextUtils.getTrimmedLength("");
                                int iPostOrRun = DayPeriod.Extension.postOrRun();
                                int i119 = trimmedLength * TypedValues.Custom.TYPE_DIMENSION;
                                int i120 = (i119 & (-83076)) + (i119 | (-83076));
                                int i121 = ~trimmedLength;
                                int i122 = ~((i121 ^ iPostOrRun) | (i121 & iPostOrRun));
                                int i123 = ~iPostOrRun;
                                int i124 = ((~((i123 ^ 92) | (i123 & 92))) | i122) * (-1808);
                                int i125 = (i120 & i124) + (i124 | i120);
                                int i126 = ~trimmedLength;
                                int i127 = (i126 & (-93)) | (i126 ^ (-93));
                                int i128 = ~((i127 & iPostOrRun) | (i127 ^ iPostOrRun));
                                int i129 = (~iPostOrRun) | trimmedLength;
                                int i130 = (i125 - (~((i128 | (~((i129 ^ 92) | (i129 & 92)))) * TypedValues.Custom.TYPE_BOOLEAN))) - 1;
                                int i131 = (~((i121 ^ 92) | (i121 & 92))) | (~((iPostOrRun & (-93)) | ((-93) ^ iPostOrRun)));
                                int i132 = ~((trimmedLength & i123) | (i123 ^ trimmedLength));
                                int i133 = -(-(((i132 & i131) | (i131 ^ i132)) * TypedValues.Custom.TYPE_BOOLEAN));
                                Object[] objArr12 = new Object[1];
                                a(i118, cArr5, (byte) ((i130 ^ i133) + ((i133 & i130) << 1)), objArr12);
                                Class<?> cls3 = Class.forName((String) objArr12[0]);
                                int i134 = (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                                char[] cArr6 = {6, 26, 1, 30, 3, '\"', 27, 1, 6, 26, 5, 0, CharUtils.CR, 4, 6, 26, 13919};
                                int i135 = -(-KeyEvent.keyCodeFromString(""));
                                Object[] objArr13 = new Object[1];
                                a((i134 ^ 16) + ((i134 & 16) << 1), cArr6, (byte) (((i135 | 119) << 1) - (i135 ^ 119)), objArr13);
                                Object objInvoke = cls3.getMethod((String) objArr13[0], null).invoke(context, null);
                                int i136 = getARTIFICIAL_FRAME_PACKAGE_NAME + 17;
                                artificialFrame = i136 % 128;
                                int i137 = i136 % 2;
                                try {
                                    int i138 = -TextUtils.lastIndexOf("", '0', 0, 0);
                                    int iPostOrRun2 = DayPeriod.Extension.postOrRun();
                                    int i139 = i138 * 628;
                                    int i140 = ((i139 | 13816) << 1) - (i139 ^ 13816);
                                    int i141 = (iPostOrRun2 ^ 22) | (iPostOrRun2 & 22);
                                    int i142 = ~i138;
                                    int i143 = i140 + (((i141 & i142) | (i141 ^ i142)) * (-627)) + (((~(((-23) & iPostOrRun2) | ((-23) ^ iPostOrRun2))) | i138) * (-627));
                                    int i144 = ~iPostOrRun2;
                                    int i145 = ~((i144 & 22) | (i144 ^ 22));
                                    int i146 = ~((i138 & iPostOrRun2) | (i138 ^ iPostOrRun2));
                                    int i147 = i145 ^ i146;
                                    Object[] objArr14 = new Object[1];
                                    a((i143 - (~(-(-(((i146 & i145) | i147) * 627))))) - 1, new char[]{4, CharUtils.CR, Typography.amp, 4, 14, 26, CoreConstants.RIGHT_PARENTHESIS_CHAR, 11, '!', 17, '\t', 4, 25, CharUtils.CR, 6, '\t', 26, 16, '\t', 4, '\"', CoreConstants.RIGHT_PARENTHESIS_CHAR, 13898}, (byte) ((ViewConfiguration.getDoubleTapTimeout() >> 16) + 92), objArr14);
                                    Class<?> cls4 = Class.forName((String) objArr14[0]);
                                    int iBlue = Color.blue(0);
                                    int i148 = ~(((-15) ^ i51) | ((-15) & i51));
                                    int i149 = (iBlue * 46) + 644 + (((i148 & iBlue) | (iBlue ^ i148)) * (-90));
                                    int i150 = ((~(((-15) & i) | ((-15) ^ i))) | (~((iBlue ^ 14) | (iBlue & 14)))) * (-45);
                                    int i151 = ((i149 | i150) << 1) - (i149 ^ i150);
                                    int i152 = ~iBlue;
                                    int i153 = ~((i152 & i) | (i152 ^ i));
                                    int i154 = (i153 & (-15)) | ((-15) ^ i153);
                                    int i155 = ~(iBlue | i51);
                                    Object[] objArr15 = new Object[1];
                                    a(i151 + (((i154 & i155) | (i154 ^ i155)) * 45), new char[]{6, 26, 1, 30, 3, '\"', 27, 1, 6, 26, CoreConstants.RIGHT_PARENTHESIS_CHAR, 2, CoreConstants.RIGHT_PARENTHESIS_CHAR, 21}, (byte) (47 - KeyEvent.normalizeMetaState(0)), objArr15);
                                    try {
                                        Object[] objArr16 = {cls4.getMethod((String) objArr15[0], null).invoke(context, null), 64};
                                        int i156 = (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
                                        int i157 = (i156 * (-317)) + 40194;
                                        int i158 = ~i156;
                                        int i159 = i158 | (-127);
                                        int i160 = ~((i159 & i) | (i159 ^ i));
                                        int i161 = (i51 ^ i156) | (i51 & i156);
                                        int i162 = ~((i161 & WebSocketProtocol.PAYLOAD_SHORT) | (i161 ^ WebSocketProtocol.PAYLOAD_SHORT));
                                        int i163 = -(-(((i160 & i162) | (i160 ^ i162)) * (-318)));
                                        int i164 = ((i157 | i163) << 1) - (i157 ^ i163);
                                        int i165 = ~(((-127) & i156) | ((-127) ^ i156));
                                        int i166 = ~(i156 | i);
                                        int i167 = (((i164 - (~(-(-(((i166 & i165) | (i165 ^ i166)) * (-318)))))) - 1) - (~(((~(i158 | i)) | (-127)) * TypedValues.AttributesType.TYPE_PIVOT_TARGET))) - 1;
                                        Object[] objArr17 = new Object[1];
                                        b(null, new byte[]{-118, -112, -109, -108, -120, -108, -100, -112, -109, -108, -101, -106, -108, -102, -107, -103, -104, -107, -105, -120, -112, -105, -120, -117, -106, -107, -119, -116, -117, -118, -119, -120, -108}, i167, null, objArr17);
                                        Class<?> cls5 = Class.forName((String) objArr17[0]);
                                        int packedPositionChild = ExpandableListView.getPackedPositionChild(0L);
                                        int i168 = ~packedPositionChild;
                                        int i169 = (packedPositionChild * (-183)) + 23680 + (((i168 & 128) | (i168 ^ 128)) * (-368));
                                        int i170 = -(-(((packedPositionChild ^ (-129)) | (packedPositionChild & (-129)) | i51) * SyslogConstants.LOG_LOCAL7));
                                        int i171 = ((i169 | i170) << 1) - (i169 ^ i170);
                                        int i172 = ~packedPositionChild;
                                        int i173 = ~((i172 & (-129)) | (i172 ^ (-129)));
                                        int i174 = ~(i49 | packedPositionChild);
                                        int i175 = (i173 ^ i174) | (i173 & i174);
                                        int i176 = ~((packedPositionChild & 128) | (packedPositionChild ^ 128));
                                        int i177 = ((i176 & i175) | (i175 ^ i176)) * SyslogConstants.LOG_LOCAL7;
                                        int i178 = ((i171 | i177) << 1) - (i177 ^ i171);
                                        Object[] objArr18 = new Object[1];
                                        b(null, new byte[]{-117, -98, -120, -99, -112, -109, -108, -101, -106, -108, -102, -105, -112, -109}, i178, null, objArr18);
                                        Object objInvoke2 = cls5.getMethod((String) objArr18[0], String.class, Integer.TYPE).invoke(objInvoke, objArr16);
                                        byte[] bArr2 = {-117, -98, -120, -99, -112, -109, -108, -101, -106, -108, -102, -107, -103, -104, -107, -105, -120, -112, -105, -120, -117, -106, -107, -119, -116, -117, -118, -119, -120, -108};
                                        int i179 = -(CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                                        int iPostOrRun3 = DayPeriod.Extension.postOrRun();
                                        int i180 = (i179 * 46) + 5842;
                                        int i181 = ~iPostOrRun3;
                                        int i182 = ~((i181 & (-128)) | ((-128) ^ i181));
                                        int i183 = ((i182 & i179) | (i179 ^ i182)) * (-90);
                                        int i184 = (i180 & i183) + (i180 | i183);
                                        int i185 = ~(((-128) ^ iPostOrRun3) | ((-128) & iPostOrRun3));
                                        int i186 = ~(i179 | 127);
                                        int i187 = (i184 - (~(((i185 ^ i186) | (i185 & i186)) * (-45)))) - 1;
                                        int i188 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                        int i189 = ((i188 | 89) << 1) - (i188 ^ 89);
                                        artificialFrame = i189 % 128;
                                        int i190 = i189 % 2;
                                        int i191 = ~i179;
                                        int i192 = ~((i191 & iPostOrRun3) | (i191 ^ iPostOrRun3));
                                        int i193 = ~iPostOrRun3;
                                        int i194 = -(-(45 * ((~((i179 & i193) | (i193 ^ i179))) | (i192 & (-128)) | ((-128) ^ i192))));
                                        int i195 = ((i187 | i194) << 1) - (i194 ^ i187);
                                        Object[] objArr19 = new Object[1];
                                        b(null, bArr2, i195, null, objArr19);
                                        Class<?> cls6 = Class.forName((String) objArr19[0]);
                                        int i196 = 10 - (~(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)));
                                        char[] cArr7 = {'#', 28, 4, '\f', 0, 3, 17, 2, 21, '\"'};
                                        int i197 = -(AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                                        int i198 = artificialFrame + 81;
                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i198 % 128;
                                        int i199 = i198 % 2;
                                        int i200 = (i197 * 141) - 12649;
                                        int i201 = ~i197;
                                        int i202 = ~((i201 ^ 91) | (i201 & 91));
                                        int i203 = ~i197;
                                        int i204 = -(-(((~((i203 ^ i) | (i203 & i))) | i202) * (-280)));
                                        int i205 = ((i200 | i204) << 1) - (i200 ^ i204);
                                        int i206 = ~((i201 ^ i) | (i201 & i));
                                        int i207 = ~(((-92) ^ i) | ((-92) & i));
                                        int i208 = ((i206 ^ i207) | (i206 & i207)) * 140;
                                        int i209 = ((i205 | i208) << 1) - (i208 ^ i205);
                                        int i210 = i201 | (-92);
                                        int i211 = ~((i210 & i) | (i210 ^ i));
                                        int i212 = i201 | i49;
                                        int i213 = ~((i212 & 91) | (i212 ^ 91));
                                        int i214 = (i213 & i211) | (i211 ^ i213);
                                        int i215 = (-92) | i51;
                                        int i216 = ~((i197 & i215) | (i215 ^ i197));
                                        int i217 = -(-(((i214 & i216) | (i214 ^ i216)) * 140));
                                        Object[] objArr20 = new Object[1];
                                        a(i196, cArr7, (byte) (((i209 | i217) << 1) - (i217 ^ i209)), objArr20);
                                        Object[] objArr21 = (Object[]) cls6.getField((String) objArr20[0]).get(objInvoke2);
                                        int length = objArr21.length;
                                        int i218 = 0;
                                        r2 = r2;
                                        while (i218 < length) {
                                            Object obj3 = objArr21[i218];
                                            int i219 = -(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1));
                                            int iPostOrRun4 = DayPeriod.Extension.postOrRun();
                                            int i220 = i219 * 71;
                                            int i221 = (i220 & (-8694)) + (i220 | (-8694));
                                            int i222 = ~i219;
                                            int i223 = ~(i222 | WebSocketProtocol.PAYLOAD_SHORT);
                                            int i224 = ~((iPostOrRun4 ^ WebSocketProtocol.PAYLOAD_SHORT) | (iPostOrRun4 & WebSocketProtocol.PAYLOAD_SHORT));
                                            int i225 = ((i223 ^ i224) | (i224 & i223)) * (-140);
                                            int i226 = (i221 ^ i225) + ((i225 & i221) << 1);
                                            int i227 = (~(i219 | WebSocketProtocol.PAYLOAD_SHORT | iPostOrRun4)) * 70;
                                            int i228 = (i226 ^ i227) + ((i227 & i226) << 1) + (((~((i222 ^ WebSocketProtocol.PAYLOAD_SHORT) | (i222 & WebSocketProtocol.PAYLOAD_SHORT))) | (~(((-127) ^ i219) | ((-127) & i219))) | (~((i219 & iPostOrRun4) | (i219 ^ iPostOrRun4)))) * 70);
                                            Object[] objArr22 = new Object[1];
                                            b(null, new byte[]{-94, -95, -96, -107, -97}, i228, null, objArr22);
                                            String str2 = (String) objArr22[0];
                                            int i229 = artificialFrame;
                                            int i230 = (i229 ^ 115) + ((i229 & 115) << 1);
                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i230 % 128;
                                            int i231 = i230 % 2;
                                            try {
                                                Object[] objArr23 = {str2};
                                                int i232 = -TextUtils.lastIndexOf("", '0');
                                                int i233 = i232 * (-963);
                                                int i234 = ((((i233 & (-964)) + (i233 | (-964))) + 121590) - (~(((~i232) | (~(((-127) ^ i) | ((-127) & i)))) * (-964)))) - 1;
                                                int i235 = ~(((-127) ^ i51) | ((-127) & i51));
                                                int i236 = ~(((-127) & i232) | ((-127) ^ i232));
                                                Object[] objArr24 = new Object[1];
                                                b(null, new byte[]{-90, -118, -117, -105, -106, -108, -89, -112, -105, -108, -106, -116, -98, -116, -105, -118, -112, -127, -107, -105, -118, -112, -106, -107, -90, -105, -116, -118, -110, -106, -112, -91, -107, -108, -92, -108, -93}, (i234 - (~(((i236 & i235) | (i235 ^ i236)) * (-964)))) - 1, null, objArr24);
                                                Class<?> cls7 = Class.forName((String) objArr24[0]);
                                                int jumpTapTimeout = ViewConfiguration.getJumpTapTimeout() >> 16;
                                                int i237 = jumpTapTimeout * (-520);
                                                int i238 = (i237 ^ 66294) + ((i237 & 66294) << 1);
                                                int i239 = ~jumpTapTimeout;
                                                int i240 = i238 + ((~((i239 & 127) | (i239 ^ 127) | i)) * 521);
                                                int i241 = -(-((~(((-128) ^ jumpTapTimeout) | ((-128) & jumpTapTimeout))) * (-1042)));
                                                int i242 = (i240 ^ i241) + ((i241 & i240) << 1);
                                                int i243 = ~(((-128) & jumpTapTimeout) | ((-128) ^ jumpTapTimeout));
                                                int i244 = ~jumpTapTimeout;
                                                int i245 = (i244 & i51) | (i244 ^ i51);
                                                int i246 = ~((i245 & 127) | (i245 ^ 127));
                                                Object[] objArr25 = new Object[1];
                                                b(null, new byte[]{-112, -106, -120, -108, -105, -91, -120, -99, -105, -112, -109}, i242 + (((i246 & i243) | (i243 ^ i246)) * 521), null, objArr25);
                                                Object objInvoke3 = cls7.getMethod((String) objArr25[0], String.class).invoke(null, objArr23);
                                                try {
                                                    int maximumFlingVelocity = ViewConfiguration.getMaximumFlingVelocity() >> 16;
                                                    int i247 = (maximumFlingVelocity * (-495)) - 13860;
                                                    int i248 = artificialFrame + 71;
                                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i248 % 128;
                                                    if (i248 % 2 != 0) {
                                                        int i249 = ~maximumFlingVelocity;
                                                        int i250 = (~((i249 & i) | (i249 ^ i))) | (~((i249 ^ (-29)) | (i249 & (-29))));
                                                        i7 = i247 / ((i250 ^ 992) + ((i250 & 992) << 1));
                                                    } else {
                                                        int i251 = ~maximumFlingVelocity;
                                                        int i252 = ~(i251 | (-29));
                                                        int i253 = ~((i251 & i) | (i251 ^ i));
                                                        i7 = i247 + (((i253 & i252) | (i252 ^ i253)) * 992);
                                                    }
                                                    int i254 = ~maximumFlingVelocity;
                                                    int i255 = ~((i254 & (-29)) | (i254 ^ (-29)));
                                                    int i256 = ~maximumFlingVelocity;
                                                    int i257 = i255 | (~((i256 & i) | (i256 ^ i)));
                                                    int i258 = ~(maximumFlingVelocity | i51 | 28);
                                                    int i259 = (-496) * ((i258 & i257) | (i257 ^ i258));
                                                    int i260 = ((((i7 | i259) << 1) - (i7 ^ i259)) - (~(-(-((28 | i) * 496))))) - 1;
                                                    char[] cArr8 = {4, CharUtils.CR, Typography.amp, 4, 14, 26, CoreConstants.RIGHT_PARENTHESIS_CHAR, 11, '!', 17, '\t', 4, 25, CharUtils.CR, 6, '\t', 21, CoreConstants.LEFT_PARENTHESIS_CHAR, 11, '\"', 26, 0, CharUtils.CR, 4, '\t', 23, 6, 24};
                                                    int i261 = -TextUtils.indexOf("", "", 0, 0);
                                                    int i262 = (i261 * (-958)) - 71850;
                                                    int i263 = ~(((-76) ^ i51) | ((-76) & i51));
                                                    Object[] objArr26 = objArr21;
                                                    int i264 = ~i261;
                                                    int i265 = (~((i264 ^ i) | (i264 & i))) | i263;
                                                    int i266 = ~(((-1937519896) ^ i51) | ((-1937519896) & i51));
                                                    int i267 = length;
                                                    int i268 = ~(((-1466699147) ^ i) | ((-1466699147) & i));
                                                    int i269 = (i266 ^ i268) | (i268 & i266);
                                                    int i270 = ~((i51 ^ 1466699146) | (i51 & 1466699146));
                                                    int i271 = (-1361663614) + (((i269 ^ i270) | (i269 & i270)) * 959);
                                                    int i272 = ((i271 | (-1704273312)) << 1) - ((-1704273312) ^ i271);
                                                    int i273 = ~((-1466699147) | i51);
                                                    int i274 = ~(((-1937519896) ^ i) | ((-1937519896) & i));
                                                    int i275 = (i273 ^ i274) | (i273 & i274);
                                                    int i276 = ~((1466699146 ^ i) | (1466699146 & i));
                                                    int i277 = -(-(((i275 ^ i276) | (i275 & i276)) * 959));
                                                    int i278 = (i272 ^ i277) + ((i272 & i277) << 1);
                                                    int i279 = i218;
                                                    int i280 = 362616240 + (((~(1635727308 | i)) | (~(i51 | (-1259245235)))) * (-1808));
                                                    int i281 = ~((1803534334 ^ i) | (1803534334 & i));
                                                    int i282 = (i51 ^ (-1635727309)) | (i51 & (-1635727309));
                                                    int i283 = ~((i282 ^ (-1259245235)) | (i282 & (-1259245235)));
                                                    int i284 = ((i281 ^ i283) | (i283 & i281)) * TypedValues.Custom.TYPE_BOOLEAN;
                                                    int i285 = (i280 & i284) + (i284 | i280);
                                                    int i286 = ~((1259245234 & i) | (1259245234 ^ i));
                                                    if (i278 > (i285 - (~(-(-((((167807026 ^ i286) | (i286 & 167807026)) | (~((i49 ^ (-1635727309)) | (i49 & (-1635727309))))) * TypedValues.Custom.TYPE_BOOLEAN))))) - 1) {
                                                        int i287 = ~((i49 ^ i261) | (i49 & i261));
                                                        int i288 = i262 >>> (959 - ((i265 & i287) | (i265 ^ i287)));
                                                        try {
                                                            int i289 = -(-((-959) % (~((i261 ^ 75) | (i261 & 75)))));
                                                            i8 = ((i288 | i289) << 1) - (i288 ^ i289);
                                                            int i290 = ~i261;
                                                            i9 = i290 ^ i49;
                                                            i10 = i290 & i49;
                                                        } catch (Throwable th) {
                                                            th = th;
                                                            Throwable cause = th.getCause();
                                                            if (cause != null) {
                                                                throw cause;
                                                            }
                                                            throw th;
                                                        }
                                                    } else {
                                                        int i291 = i262 + ((i265 | (~((i51 ^ i261) | (i51 & i261)))) * 959);
                                                        int i292 = (~((i261 ^ 75) | (i261 & 75))) * (-959);
                                                        i8 = (i291 ^ i292) + ((i292 & i291) << 1);
                                                        int i293 = ~i261;
                                                        i9 = i293 ^ i51;
                                                        i10 = i293 & i51;
                                                    }
                                                    int i294 = ~(i10 | i9);
                                                    int i295 = ~(((-76) & i) | ((-76) ^ i));
                                                    int i296 = (i294 & i295) | (i294 ^ i295);
                                                    int i297 = ~((i261 ^ i) | (i261 & i));
                                                    int i298 = -(-(959 * ((i296 & i297) | (i296 ^ i297))));
                                                    Object[] objArr27 = new Object[1];
                                                    a(i260, cArr8, (byte) ((i8 ^ i298) + ((i298 & i8) << 1)), objArr27);
                                                    Class<?> cls8 = Class.forName((String) objArr27[0]);
                                                    int i299 = -(SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                                                    Object[] objArr28 = new Object[1];
                                                    a((i299 ^ 12) + ((i299 & 12) << 1), new char[]{5, 16, CoreConstants.LEFT_PARENTHESIS_CHAR, '+', 6, 23, 17, 0, 4, 0, 13839}, (byte) (42 - (~(-Process.getGidForName("")))), objArr28);
                                                    r2 = 0;
                                                    try {
                                                        try {
                                                            Object[] objArr29 = {new ByteArrayInputStream((byte[]) cls8.getMethod((String) objArr28[0], null).invoke(obj3, null))};
                                                            r2 = new byte[]{-90, -118, -117, -105, -106, -108, -89, -112, -105, -108, -106, -116, -98, -116, -105, -118, -112, -127, -107, -105, -118, -112, -106, -107, -90, -105, -116, -118, -110, -106, -112, -91, -107, -108, -92, -108, -93};
                                                            int i300 = -(ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                                                            int iPostOrRun5 = DayPeriod.Extension.postOrRun();
                                                            int i301 = i300 * (-391);
                                                            int i302 = artificialFrame;
                                                            int i303 = (i302 & 27) + (i302 | 27);
                                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i303 % 128;
                                                            if (i303 % 2 != 0) {
                                                                i11 = i301 / (-323);
                                                                i12 = ((-129) ^ i300) | ((-129) & i300);
                                                            } else {
                                                                i11 = ((i301 & (-24960)) << 1) + (i301 ^ (-24960));
                                                                i12 = ((-129) & i300) | ((-129) ^ i300);
                                                            }
                                                            int i304 = (-196) * ((~i12) | (~((iPostOrRun5 ^ 128) | (iPostOrRun5 & 128))));
                                                            int i305 = ((((i11 | i304) << 1) - (i11 ^ i304)) - (~(((i300 ^ 128) | (i300 & 128)) * 392))) - 1;
                                                            int i306 = ~i300;
                                                            int i307 = (i302 & 67) + (i302 | 67);
                                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i307 % 128;
                                                            if (i307 % 2 != 0) {
                                                                int i308 = ~((i306 & (-129)) | (i306 ^ (-129)));
                                                                int i309 = ~((iPostOrRun5 & 128) | (iPostOrRun5 ^ 128));
                                                                int i310 = i305 * ((i308 & i309) | (i308 ^ i309)) * 196;
                                                                Object[] objArr30 = new Object[1];
                                                                b(null, r2, i310, null, objArr30);
                                                                str = (String) objArr30[0];
                                                            } else {
                                                                int i311 = i305 + (((~(i306 | (-129))) | (~((iPostOrRun5 & 128) | (iPostOrRun5 ^ 128)))) * 196);
                                                                Object[] objArr31 = new Object[1];
                                                                b(null, r2, i311, null, objArr31);
                                                                str = (String) objArr31[0];
                                                            }
                                                            Class<?> cls9 = Class.forName(str);
                                                            int i312 = -(ViewConfiguration.getScrollBarFadeDuration() >> 16);
                                                            int i313 = ((i312 | 19) << 1) - (i312 ^ 19);
                                                            char[] cArr9 = {6, 26, CharUtils.CR, 25, 4, 0, 6, 23, 24, 21, 4, 3, 28, 14, 24, 28, 0, 3, 13872};
                                                            int i314 = -KeyEvent.getDeadChar(0, 0);
                                                            byte b3 = (byte) ((i314 ^ 49) + ((i314 & 49) << 1));
                                                            int i315 = artificialFrame;
                                                            int i316 = ((i315 | 53) << 1) - (i315 ^ 53);
                                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i316 % 128;
                                                            if (i316 % 2 != 0) {
                                                                Object[] objArr32 = new Object[1];
                                                                a(i313, cArr9, b3, objArr32);
                                                                String str3 = (String) objArr32[0];
                                                                Class<?>[] clsArr2 = new Class[1];
                                                                clsArr2[1] = InputStream.class;
                                                                method = cls9.getMethod(str3, clsArr2);
                                                            } else {
                                                                Object[] objArr33 = new Object[1];
                                                                a(i313, cArr9, b3, objArr33);
                                                                method = cls9.getMethod((String) objArr33[0], InputStream.class);
                                                            }
                                                            Object objInvoke4 = method.invoke(objInvoke3, objArr29);
                                                            int length2 = objArr4.length;
                                                            r2 = 0;
                                                            while (r2 < 2) {
                                                                int i317 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                                int i318 = (i317 ^ 23) + ((i317 & 23) << 1);
                                                                artificialFrame = i318 % 128;
                                                                if (i318 % 2 == 0) {
                                                                    obj = objArr4[r2];
                                                                    i13 = 0;
                                                                    int i319 = 19 / 0;
                                                                } else {
                                                                    i13 = 0;
                                                                    obj = objArr4[r2];
                                                                }
                                                                try {
                                                                    int i320 = -KeyEvent.getDeadChar(i13, i13);
                                                                    int i321 = (i320 ^ 34) + ((i320 & 34) << 1);
                                                                    char[] cArr10 = {CoreConstants.RIGHT_PARENTHESIS_CHAR, 5, CoreConstants.RIGHT_PARENTHESIS_CHAR, 3, 7, '\"', 24, '\"', 17, 2, 23, 0, '0', '\f', '\"', 24, 4, 3, '\b', 6, ' ', 23, 2, 30, 24, 6, 0, 23, 14, 28, '\"', 3, 6, 23};
                                                                    int i322 = -(ViewConfiguration.getJumpTapTimeout() >> 16);
                                                                    Object[] objArr34 = new Object[1];
                                                                    a(i321, cArr10, (byte) (((i322 | 107) << 1) - (i322 ^ 107)), objArr34);
                                                                    Class<?> cls10 = Class.forName((String) objArr34[0]);
                                                                    int i323 = -(ViewConfiguration.getDoubleTapTimeout() >> 16);
                                                                    int iPostOrRun6 = DayPeriod.Extension.postOrRun();
                                                                    int i324 = i323 * 221;
                                                                    int i325 = (i324 ^ (-5037)) + ((i324 & (-5037)) << 1);
                                                                    int i326 = ~((~i323) | (-24));
                                                                    int i327 = ~iPostOrRun6;
                                                                    int i328 = (i327 ^ i323) | (i327 & i323);
                                                                    int i329 = ~((i328 & 23) | (i328 ^ 23));
                                                                    int i330 = ((i326 & i329) | (i326 ^ i329)) * 220;
                                                                    int i331 = ((i325 | i330) << 1) - (i330 ^ i325);
                                                                    int i332 = ~((i327 ^ 23) | (i327 & 23));
                                                                    int i333 = ((i332 & i323) | (i323 ^ i332)) * (-440);
                                                                    int i334 = (i331 & i333) + (i333 | i331);
                                                                    int i335 = (i323 & 23) | (i323 ^ 23);
                                                                    int i336 = ((i335 & iPostOrRun6) | (i335 ^ iPostOrRun6)) * 220;
                                                                    int i337 = ((i334 | i336) << 1) - (i336 ^ i334);
                                                                    char[] cArr11 = {6, 26, 4, 30, 19, '\t', CoreConstants.RIGHT_PARENTHESIS_CHAR, 26, 30, 3, 2, 29, 13844, 13844, 31, 1, 25, 7, 28, 24, 27, 5, 13920};
                                                                    int i338 = -(-(CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)));
                                                                    Object[] objArr35 = new Object[1];
                                                                    a(i337, cArr11, (byte) (((i338 | b.l) << 1) - (i338 ^ b.l)), objArr35);
                                                                    if (!obj.equals(cls10.getMethod((String) objArr35[0], null).invoke(objInvoke4, null))) {
                                                                        r2 = ((r2 & 1) << 1) + (r2 ^ 1);
                                                                    } else {
                                                                        int i339 = getARTIFICIAL_FRAME_PACKAGE_NAME + 71;
                                                                        artificialFrame = i339 % 128;
                                                                        int i340 = i339 % 2;
                                                                        Object[] objArr36 = {new int[]{i}, new int[]{(~(i & 1)) & (i | 1)}, new int[1], null};
                                                                        int i341 = ~new Random().nextInt();
                                                                        int i342 = (-988583490) + (((~(i341 | 144808231)) | (-968072184)) * (-160)) + (((~(i341 | (-833815544))) | 144808231) * SyslogConstants.LOG_LOCAL4) + 16;
                                                                        int i343 = ((i342 * (-1529)) - (~(-(-(i2 * (-764)))))) - 1;
                                                                        int i344 = ~i342;
                                                                        int i345 = ~i2;
                                                                        int i346 = ~(i344 | i345 | i49);
                                                                        int i347 = ~i342;
                                                                        int i348 = (i347 ^ i2) | (i347 & i2);
                                                                        int i349 = i346 | (~((i348 & i) | (i348 ^ i)));
                                                                        int i350 = ~((i345 ^ i342) | (i345 & i342) | i);
                                                                        int i351 = -(-(((i349 & i350) | (i349 ^ i350)) * 765));
                                                                        int i352 = (i343 & i351) + (i343 | i351);
                                                                        int i353 = ~i2;
                                                                        int i354 = ~((i353 & i347) | (i347 ^ i353));
                                                                        int i355 = ~((i344 & i49) | (i344 ^ i49));
                                                                        int i356 = artificialFrame;
                                                                        int i357 = ((i356 | 17) << 1) - (i356 ^ 17);
                                                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i357 % 128;
                                                                        int i358 = i357 % 2;
                                                                        int i359 = (i352 - (~(1530 * (i354 | i355)))) - 1;
                                                                        int i360 = ((~((i347 ^ i) | (i347 & i))) | (~((i51 & i345) | (i345 ^ i51) | i342))) * 765;
                                                                        int i361 = ((i359 | i360) << 1) - (i360 ^ i359);
                                                                        int i362 = (i361 << 13) ^ i361;
                                                                        int i363 = i362 >>> 17;
                                                                        int i364 = (i362 | i363) & (~(i362 & i363));
                                                                        int i365 = i364 << 5;
                                                                        ((int[]) objArr36[2])[0] = ((~i364) & i365) | ((~i365) & i364);
                                                                        objArr = objArr36;
                                                                        i4 = 2;
                                                                    }
                                                                } catch (Throwable th2) {
                                                                    Throwable cause2 = th2.getCause();
                                                                    if (cause2 != null) {
                                                                        throw cause2;
                                                                    }
                                                                    throw th2;
                                                                }
                                                            }
                                                            r2 = i2;
                                                            i218 = i279 + 1;
                                                            objArr21 = objArr26;
                                                            length = i267;
                                                        } catch (Throwable th3) {
                                                            Throwable cause3 = th3.getCause();
                                                            if (cause3 != null) {
                                                                throw cause3;
                                                            }
                                                            throw th3;
                                                        }
                                                    } catch (Throwable unused) {
                                                        r2 = i2;
                                                        objArr = new Object[4];
                                                        iArr = new int[1];
                                                        int i366 = artificialFrame + 81;
                                                        int i367 = i366 % 128;
                                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i367;
                                                        int i368 = i366 % 2;
                                                        objArr[0] = iArr;
                                                        iArr2 = new int[1];
                                                        objArr[1] = iArr2;
                                                        objArr[2] = new int[1];
                                                        i3 = ((i367 | 89) << 1) - (i367 ^ 89);
                                                        artificialFrame = i3 % 128;
                                                        if (i3 % 2 == 0) {
                                                            iArr2[1] = i;
                                                            c = 0;
                                                        } else {
                                                            c = 0;
                                                            iArr[0] = i;
                                                        }
                                                        iArr2[c] = i;
                                                        objArr[3] = null;
                                                        int i369 = (int) Runtime.getRuntime().totalMemory();
                                                        int i370 = ~i369;
                                                        int i371 = (-1581604898) + (((~(797474627 | i370)) | 4456600) * SyslogConstants.LOG_LOCAL7) + ((i369 | 620782080) * (-184)) + ((~((-181149148) | i370)) * SyslogConstants.LOG_LOCAL7);
                                                        int i372 = (r2 & i371) + (r2 | i371);
                                                        int i373 = i372 << 13;
                                                        int i374 = ((~i372) & i373) | ((~i373) & i372);
                                                        int i375 = i374 >>> 17;
                                                        int i376 = (i374 | i375) & (~(i374 & i375));
                                                        int i377 = i376 << 5;
                                                        int i378 = ((~i376) & i377) | ((~i377) & i376);
                                                        i4 = 2;
                                                        ((int[]) objArr[2])[0] = i378;
                                                    }
                                                } catch (Throwable th4) {
                                                    th = th4;
                                                }
                                            } catch (Throwable th5) {
                                                Throwable cause4 = th5.getCause();
                                                if (cause4 != null) {
                                                    throw cause4;
                                                }
                                                throw th5;
                                            }
                                        }
                                        objArr = new Object[4];
                                        iArr = new int[1];
                                        int i3610 = artificialFrame + 81;
                                        int i3611 = i3610 % 128;
                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i3611;
                                        int i3612 = i3610 % 2;
                                        objArr[0] = iArr;
                                        iArr2 = new int[1];
                                        objArr[1] = iArr2;
                                        objArr[2] = new int[1];
                                        i3 = ((i3611 | 89) << 1) - (i3611 ^ 89);
                                        artificialFrame = i3 % 128;
                                        if (i3 % 2 == 0) {
                                            iArr2[1] = i;
                                            c = 0;
                                        } else {
                                            c = 0;
                                            iArr[0] = i;
                                        }
                                        iArr2[c] = i;
                                        objArr[3] = null;
                                        int i3613 = (int) Runtime.getRuntime().totalMemory();
                                        int i379 = ~i3613;
                                        int i3710 = (-1581604898) + (((~(797474627 | i379)) | 4456600) * SyslogConstants.LOG_LOCAL7) + ((i3613 | 620782080) * (-184)) + ((~((-181149148) | i379)) * SyslogConstants.LOG_LOCAL7);
                                        int i3711 = (r2 & i3710) + (r2 | i3710);
                                        int i3712 = i3711 << 13;
                                        int i3713 = ((~i3711) & i3712) | ((~i3712) & i3711);
                                        int i3714 = i3713 >>> 17;
                                        int i3715 = (i3713 | i3714) & (~(i3713 & i3714));
                                        int i3716 = i3715 << 5;
                                        int i3717 = ((~i3715) & i3716) | ((~i3716) & i3715);
                                        i4 = 2;
                                        ((int[]) objArr[2])[0] = i3717;
                                    } catch (Throwable th6) {
                                        Throwable cause5 = th6.getCause();
                                        if (cause5 != null) {
                                            throw cause5;
                                        }
                                        throw th6;
                                    }
                                } catch (Throwable th7) {
                                    Throwable cause6 = th7.getCause();
                                    if (cause6 != null) {
                                        throw cause6;
                                    }
                                    throw th7;
                                }
                            } catch (Throwable th8) {
                                Throwable cause7 = th8.getCause();
                                if (cause7 != null) {
                                    throw cause7;
                                }
                                throw th8;
                            }
                        } catch (Throwable th9) {
                            Throwable cause8 = th9.getCause();
                            if (cause8 != null) {
                                throw cause8;
                            }
                            throw th9;
                        }
                    } catch (Throwable th10) {
                        Throwable cause9 = th10.getCause();
                        if (cause9 != null) {
                            throw cause9;
                        }
                        throw th10;
                    }
                } catch (Throwable unused2) {
                }
            }
            int i380 = artificialFrame + 97;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i380 % 128;
            int i381 = i380 % i4;
            return objArr;
        }
    }

    protected String getProducerName() {
        return PRODUCER_NAME;
    }
}
