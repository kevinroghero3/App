package com.shopify.reactnative.skia;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.security.keystore.KeyGenParameterSpec;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PixelCopy;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import ch.qos.logback.core.net.SyslogConstants;
import com.facebook.imageutils.JfifUtil;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.views.view.ReactViewGroup;
import com.google.common.base.Ascii;
import com.google.gson.internal.sql.SqlDateTypeAdapter;
import com.salesforce.marketingcloud.analytics.stats.b;
import io.sentry.android.core.SentryLogcatAdapter;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.LongBuffer;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.text.Typography;
import o.ArtificialStackFrames;
import o.build;
import o.onPostMessage;

/* JADX INFO: loaded from: classes6.dex */
public class ViewScreenshotService {
    private static final long SURFACE_VIEW_READ_PIXELS_TIMEOUT = 5;
    private static final String TAG = "SkiaScreenshot";
    private static final byte[] $$c = {32, -45, -106, 106};
    private static final int $$d = b.f40o;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$a = {67, 32, -18, 9, -12, -6, Ascii.ESC, -22, -26, 4, -12, 0, -8, -2, -8};
    private static final int $$b = 16;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static char[] IPostMessageService = {38205, 38218, 38073, 38043, 38044, 38073, 38208, 38044, 38044, 38050, 38041, 38044, 38050, 38049, 38042, 38060, 38067, 38045, 38041, 38306, 38047, 38036, 38035, 38234, 38055, 38034, 38055, 38046, 38051, 38036, 38055, 38212, 38234, 38044, 38298, 38275, 38380, 38345, 38353, 38354, 38348, 38355, 38363, 38355, 38383, 38392, 38356, 38356, 38362, 38360, 38356, 38351, 38350, 38364, 38361, 38352, 38285, 38359, 38354, 38359, 38362, 38269, 38148, 38269, 38269, 38270, 38144, 38164, 38190, 38169, 38268, 38264, 38258, 38165, 38175, 38267, 38267, 38145, 38293, 38363, 38355, 38355, 38355, 38358, 38356, 38285, 38358, 38356, 38369, 38363, 38355, 38361, 38202, 38075, 38211, 38078, 38230, 38260, 38258, 38227, 38230, 38360, 38255, 38249, 38258, 38257, 38248, 38247, 38247, 38250, 38252, 38250, 38250, 38267, 38260, 38250, 38269, 38158, 38159, 38170, 38155, 38255, 38249, 38242, 38147, 38144, 38237, 38245, 38246, 38240, 38247, 38255, 38247, 38147, 38156, 38248, 38248, 38254, 38294, 38386, 38395, 38280, 38288, 38284, 38282, 38205, 38076, 38241, 38234, 38271, 38237, 38222, 38241, 38239, 38233, 38236, 38233, 38222, 38224, 38237, 38271, 38222, 38237, 38235, 38228, 38233, 38274, 38343, 38341, 38193, 38198, 38196, 38223, 38234, 38078, 38071, 38063, 38225, 38250, 38222, 38071, 38063, 38068, 38075, 38075, 38076, 38208, 38072, 38070, 38075, 38077, 38071, 38071, 38235, 38226, 38070, 38078, 38070, 38063, 38069, 38068, 38385, 38179, 38173, 38189, 38192, 38177, 38176, 38176, 38181, 38181, 38308, 38283, 38288, 38288, 38288, 38287, 38287, 38284, 38282, 38286, 38286, 38286, 38288, 38288, 38288, 38286, 38286, 38288, 38288, 38285, 38285, 38287, 38287, 38288, 38386, 38185, 38179, 38179, 38343, 38206, 38178, 38186, 38178, 38171, 38177, 38176, 38168, 38203, 38342, 38186, 38179, 38171, 38205, 38347, 38344, 38364, 38362, 38352, 38202, 38179, 38171, 38176, 38183, 38183, 38184, 38188, 38180, 38178, 38339, 38216, 38210, 38226, 38224, 38072, 38210, 38213, 38078, 38208, 38210, 38208, 38220, 38227, 38216, 38078, 38209, 38349, 38227, 38216, 38217, 38257, 38220, 38213, 38212, 38247, 38208, 38226, 38209, 38222, 38221, 38221, 38078, 38279, 38353, 38352, 38352, 38349, 38189, 38046, 38050, 38044, 38044, 38050, 38038, 38030, 38287, 38360, 38358, 38361, 38361, 38355, 38365, 38375, 38365, 38360, 38361, 38363, 38361, 38374, 38361, 38260, 38165, 38179, 38154, 38144, 38267, 38268, 38270, 38268, 38153, 38155, 38267, 38267, 38270, 38268, 38263, 38265, 38267, 38265, 38263, 38258, 38262, 38268, 38169, 38170, 38265, 38260, 38257, 38262, 38265, 38257, 38161, 38202, 38070, 38064, 38074, 38212, 38074, 38069, 38070, 38072, 38070, 38213, 38209, 38066, 38066, 38287, 38360, 38358, 38356, 38351, 38355, 38361, 38390, 38391, 38358, 38353, 38350, 38355, 38358, 38350, 38382, 38384, 38353, 38386, 38272, 38375, 38365, 38360, 38361, 38363, 38361, 38376, 38372, 38357, 38357, 38280, 38358, 38356, 38351, 38355, 38361, 38390, 38391, 38358, 38353, 38350, 38355, 38358, 38350, 38382, 38384, 38353, 38386, 38399, 38369, 38359, 38357, 38360, 38357, 38347, 38348, 38356, 38364, 38354, 38248, 38145, 38268, 38243, 38253, 38150, 38144, 38247, 38256, 38252, 38276, 38356, 38378, 38378};
    private static char TopicBuilder = 29383;
    private static char ICustomTabsCallback = 52140;
    private static char extraCallbackWithResult = 19641;
    private static char onMessageChannelReady = 8422;

    /* JADX WARN: Code duplicated, block: B:10:0x0022  */
    /* JADX WARN: Code duplicated, block: B:8:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0022 -> B:11:0x0026). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0022
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$e(short r6, byte r7, short r8) {
        /*
            int r6 = 122 - r6
            byte[] r0 = com.shopify.reactnative.skia.ViewScreenshotService.$$c
            int r7 = r7 * 3
            int r7 = 3 - r7
            int r8 = r8 * 4
            int r8 = 1 - r8
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L14
            r3 = r8
            r4 = r2
            goto L26
        L14:
            r3 = r2
        L15:
            int r4 = r3 + 1
            byte r5 = (byte) r6
            r1[r3] = r5
            if (r4 != r8) goto L22
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            return r6
        L22:
            int r7 = r7 + 1
            r3 = r0[r7]
        L26:
            int r3 = -r3
            int r6 = r6 + r3
            r3 = r4
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopify.reactnative.skia.ViewScreenshotService.$$e(short, byte, short):java.lang.String");
    }

    private static void b(int i, int i2, short s, Object[] objArr) {
        byte[] bArr = $$a;
        int i3 = s * 5;
        int i4 = 115 - (i2 * 3);
        int i5 = 12 - (i * 8);
        byte[] bArr2 = new byte[i3 + 4];
        int i6 = i3 + 3;
        int i7 = -1;
        if (bArr == null) {
            i5++;
            i4 = (i6 + (-i4)) - 7;
            i7 = -1;
        }
        while (true) {
            int i8 = i7 + 1;
            bArr2[i8] = (byte) i4;
            if (i8 == i6) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            int i9 = bArr[i5];
            i5++;
            i4 = (i4 + (-i9)) - 7;
            i7 = i8;
        }
    }

    public static Bitmap makeViewScreenshotFromTag(ReactContext reactContext, int i) {
        View viewResolveView;
        try {
            viewResolveView = UIManagerHelper.getUIManagerForReactTag(reactContext, i).resolveView(i);
        } catch (RuntimeException e) {
            reactContext.handleException(e);
            viewResolveView = null;
        }
        if (viewResolveView == null) {
            return null;
        }
        int width = viewResolveView.getWidth();
        int height = viewResolveView.getHeight();
        if (width <= 0 || height <= 0) {
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paintCreatePaint = createPaint();
        canvas.save();
        canvas.translate(-viewResolveView.getLeft(), -viewResolveView.getTop());
        renderViewToCanvas(canvas, viewResolveView, paintCreatePaint, 1.0f);
        canvas.restore();
        return bitmapCreateBitmap;
    }

    private static Paint createPaint() {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        return paint;
    }

    private static void renderViewToCanvas(Canvas canvas, View view, Paint paint, float f) {
        float alpha = f * view.getAlpha();
        canvas.save();
        applyTransformations(canvas, view);
        if (view instanceof ScrollView) {
            ScrollView scrollView = (ScrollView) view;
            int scrollX = scrollView.getScrollX();
            int scrollY = scrollView.getScrollY();
            canvas.clipRect(scrollX, scrollY, scrollView.getWidth() + scrollX, scrollView.getHeight() + scrollY);
        }
        if (view instanceof ViewGroup) {
            drawBackgroundIfPresent(canvas, view, alpha);
            drawChildren(canvas, (ViewGroup) view, paint, alpha);
        } else {
            drawView(canvas, view, paint, alpha);
        }
        canvas.restore();
    }

    private static void drawBackgroundIfPresent(Canvas canvas, View view, float f) {
        Drawable background = view.getBackground();
        if (background != null) {
            canvas.saveLayerAlpha(null, Math.round(f * 255.0f));
            background.draw(canvas);
            canvas.restore();
        }
    }

    private static void drawChildren(Canvas canvas, ViewGroup viewGroup, Paint paint, float f) {
        if (viewGroup instanceof ReactViewGroup) {
            try {
                Method declaredMethod = ReactViewGroup.class.getDeclaredMethod("dispatchOverflowDraw", Canvas.class);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(viewGroup, canvas);
            } catch (Exception e) {
                SentryLogcatAdapter.e(TAG, "couldn't invoke dispatchOverflowDraw() on ReactViewGroup", e);
            }
        }
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt.getVisibility() == 0) {
                if (childAt instanceof TextureView) {
                    drawTextureView(canvas, (TextureView) childAt, paint, f);
                } else if (childAt instanceof SurfaceView) {
                    drawSurfaceView(canvas, (SurfaceView) childAt, paint, f);
                } else {
                    renderViewToCanvas(canvas, childAt, paint, f);
                }
            }
        }
    }

    private static void c(int i, char[] cArr, Object[] objArr) throws Throwable {
        char c = 2;
        int i2 = 2 % 2;
        build buildVar = new build();
        char[] cArr2 = new char[cArr.length];
        int i3 = 0;
        buildVar.c = 0;
        char[] cArr3 = new char[2];
        while (buildVar.c < cArr.length) {
            cArr3[i3] = cArr[buildVar.c];
            cArr3[1] = cArr[buildVar.c + 1];
            int i4 = 58224;
            int i5 = i3;
            while (i5 < 16) {
                char c2 = cArr3[1];
                char c3 = cArr3[i3];
                int i6 = (c3 + i4) ^ ((c3 << 4) + ((char) (((long) extraCallbackWithResult) ^ (-4408183324873663413L))));
                int i7 = c3 >>> 5;
                try {
                    Object[] objArr2 = new Object[4];
                    objArr2[3] = Integer.valueOf(onMessageChannelReady);
                    objArr2[c] = Integer.valueOf(i7);
                    objArr2[1] = Integer.valueOf(i6);
                    objArr2[i3] = Integer.valueOf(c2);
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1585798252);
                    if (objAccessartificialFrame == null) {
                        int pressedStateDuration = 28 - (ViewConfiguration.getPressedStateDuration() >> 16);
                        char jumpTapTimeout = (char) (17263 - (ViewConfiguration.getJumpTapTimeout() >> 16));
                        int i8 = 1067 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                        byte b = (byte) i3;
                        String str$$e = $$e((byte) ($$d & 30), b, b);
                        Class[] clsArr = new Class[4];
                        clsArr[i3] = Integer.TYPE;
                        clsArr[1] = Integer.TYPE;
                        clsArr[2] = Integer.TYPE;
                        clsArr[3] = Integer.TYPE;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(pressedStateDuration, jumpTapTimeout, i8, 1042277788, false, str$$e, clsArr);
                    }
                    char cCharValue = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                    cArr3[1] = cCharValue;
                    char[] cArr4 = cArr3;
                    Object[] objArr3 = {Integer.valueOf(cArr3[i3]), Integer.valueOf((cCharValue + i4) ^ ((cCharValue << 4) + ((char) (((long) TopicBuilder) ^ (-4408183324873663413L))))), Integer.valueOf(cCharValue >>> 5), Integer.valueOf(ICustomTabsCallback)};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1585798252);
                    if (objAccessartificialFrame2 == null) {
                        byte b2 = (byte) 0;
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 28, (char) (17262 - TextUtils.indexOf((CharSequence) "", '0')), (ViewConfiguration.getEdgeSlop() >> 16) + 1067, 1042277788, false, $$e((byte) ($$d & 30), b2, b2), new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    cArr4[0] = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
                    i4 -= 40503;
                    i5++;
                    int i9 = $11 + 41;
                    $10 = i9 % 128;
                    int i10 = i9 % 2;
                    cArr3 = cArr4;
                    c = 2;
                    i3 = 0;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            char[] cArr5 = cArr3;
            cArr2[buildVar.c] = cArr5[0];
            cArr2[buildVar.c + 1] = cArr5[1];
            Object[] objArr4 = {buildVar, buildVar};
            Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1010141908);
            if (objAccessartificialFrame3 == null) {
                byte b3 = (byte) 0;
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(25 - Color.argb(0, 0, 0, 0), (char) (63927 - TextUtils.indexOf((CharSequence) "", '0', 0, 0)), 485 - TextUtils.lastIndexOf("", '0', 0, 0), 1554985764, false, $$e((byte) ($$d & 28), b3, b3), new Class[]{Object.class, Object.class});
            }
            ((Method) objAccessartificialFrame3).invoke(null, objArr4);
            cArr3 = cArr5;
            c = 2;
            i3 = 0;
        }
        String str = new String(cArr2, 0, i);
        int i11 = $10 + 29;
        $11 = i11 % 128;
        int i12 = i11 % 2;
        objArr[0] = str;
    }

    private static void drawView(Canvas canvas, View view, Paint paint, float f) {
        canvas.saveLayerAlpha(null, Math.round(f * 255.0f));
        view.draw(canvas);
        canvas.restore();
    }

    private static void drawTextureView(Canvas canvas, TextureView textureView, Paint paint, float f) {
        textureView.setOpaque(false);
        Bitmap bitmap = textureView.getBitmap(Bitmap.createBitmap(textureView.getWidth(), textureView.getHeight(), Bitmap.Config.ARGB_8888));
        canvas.save();
        applyTransformations(canvas, textureView);
        paint.setAlpha(Math.round(f * 255.0f));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        canvas.restore();
    }

    private static void drawSurfaceView(final Canvas canvas, final SurfaceView surfaceView, final Paint paint, final float f) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final Bitmap bitmapCreateBitmap = Bitmap.createBitmap(surfaceView.getWidth(), surfaceView.getHeight(), Bitmap.Config.ARGB_8888);
        try {
            PixelCopy.request(surfaceView, bitmapCreateBitmap, new PixelCopy.OnPixelCopyFinishedListener() { // from class: com.shopify.reactnative.skia.ViewScreenshotService$$ExternalSyntheticLambda0
                @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
                public final void onPixelCopyFinished(int i) {
                    ViewScreenshotService.lambda$drawSurfaceView$0(canvas, surfaceView, paint, f, bitmapCreateBitmap, countDownLatch, i);
                }
            }, new Handler(Looper.getMainLooper()));
            countDownLatch.await(5L, TimeUnit.SECONDS);
        } catch (Exception e) {
            SentryLogcatAdapter.e(TAG, "Cannot PixelCopy for " + surfaceView, e);
            drawSurfaceViewFromCache(canvas, surfaceView, paint, f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$drawSurfaceView$0(Canvas canvas, SurfaceView surfaceView, Paint paint, float f, Bitmap bitmap, CountDownLatch countDownLatch, int i) {
        canvas.save();
        applyTransformations(canvas, surfaceView);
        paint.setAlpha(Math.round(f * 255.0f));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        canvas.restore();
        countDownLatch.countDown();
    }

    private static void drawSurfaceViewFromCache(Canvas canvas, SurfaceView surfaceView, Paint paint, float f) {
        Bitmap drawingCache = surfaceView.getDrawingCache();
        if (drawingCache != null) {
            canvas.save();
            applyTransformations(canvas, surfaceView);
            paint.setAlpha(Math.round(f * 255.0f));
            canvas.drawBitmap(drawingCache, 0.0f, 0.0f, paint);
            canvas.restore();
        }
    }

    private static void applyTransformations(Canvas canvas, @NonNull View view) {
        Matrix matrix = view.getMatrix();
        Matrix matrix2 = new Matrix();
        matrix2.setTranslate((view.getLeft() + view.getPaddingLeft()) - view.getScrollX(), (view.getTop() + view.getPaddingTop()) - view.getScrollY());
        canvas.concat(matrix2);
        canvas.concat(matrix);
    }

    private static void a(byte[] bArr, int[] iArr, boolean z, Object[] objArr) throws Throwable {
        int i;
        byte b;
        char[] cArr;
        int i2 = 2 % 2;
        onPostMessage onpostmessage = new onPostMessage();
        int i3 = 0;
        int i4 = iArr[0];
        int i5 = 1;
        int i6 = iArr[1];
        int i7 = iArr[2];
        int i8 = iArr[3];
        char[] cArr2 = IPostMessageService;
        long j = 0;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            int i9 = 0;
            while (i9 < length) {
                int i10 = $10 + 123;
                $11 = i10 % 128;
                if (i10 % 2 == 0) {
                    try {
                        Object[] objArr2 = new Object[i5];
                        objArr2[i3] = Integer.valueOf(cArr2[i9]);
                        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1782207618);
                        if (objAccessartificialFrame == null) {
                            byte b2 = (byte) i3;
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(11 - Drawable.resolveOpacity(i3, i3), (char) ExpandableListView.getPackedPositionGroup(j), 1561 - TextUtils.indexOf((CharSequence) "", '0', i3), 178318710, false, $$e((byte) 57, b2, b2), new Class[]{Integer.TYPE});
                        }
                        cArr3[i9] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                } else {
                    try {
                        Object[] objArr3 = {Integer.valueOf(cArr2[i9])};
                        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1782207618);
                        if (objAccessartificialFrame2 == null) {
                            byte b3 = (byte) 0;
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(11 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (char) (1 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))), (ViewConfiguration.getJumpTapTimeout() >> 16) + 1562, 178318710, false, $$e((byte) 57, b3, b3), new Class[]{Integer.TYPE});
                        }
                        cArr3[i9] = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
                        i9++;
                    } catch (Throwable th2) {
                        Throwable cause2 = th2.getCause();
                        if (cause2 == null) {
                            throw th2;
                        }
                        throw cause2;
                    }
                }
                i3 = 0;
                i5 = 1;
                j = 0;
            }
            cArr2 = cArr3;
        }
        char[] cArr4 = new char[i6];
        System.arraycopy(cArr2, i4, cArr4, 0, i6);
        if (bArr != null) {
            int i11 = $10 + 23;
            $11 = i11 % 128;
            if (i11 % 2 == 0) {
                cArr = new char[i6];
                b = 1;
                onpostmessage.a = 1;
            } else {
                b = 1;
                cArr = new char[i6];
                onpostmessage.a = 0;
            }
            char c = 0;
            while (onpostmessage.a < i6) {
                if (bArr[onpostmessage.a] == b) {
                    int i12 = $11 + 123;
                    $10 = i12 % 128;
                    int i13 = i12 % 2;
                    int i14 = onpostmessage.a;
                    Object[] objArr4 = {Integer.valueOf(cArr4[onpostmessage.a]), Integer.valueOf(c)};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(1378437083);
                    if (objAccessartificialFrame3 == null) {
                        byte b4 = (byte) 0;
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 22, (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16), 2441 - TextUtils.getOffsetBefore("", 0), -850656813, false, $$e((byte) 54, b4, b4), new Class[]{Integer.TYPE, Integer.TYPE});
                    }
                    cArr[i14] = ((Character) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).charValue();
                } else {
                    int i15 = onpostmessage.a;
                    Object[] objArr5 = {Integer.valueOf(cArr4[onpostmessage.a]), Integer.valueOf(c)};
                    Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-314759072);
                    if (objAccessartificialFrame4 == null) {
                        byte b5 = (byte) 0;
                        byte b6 = b5;
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(11 - TextUtils.indexOf("", "", 0, 0), (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), Color.red(0) + 1562, 1918398056, false, $$e(b5, b6, b6), new Class[]{Integer.TYPE, Integer.TYPE});
                    }
                    cArr[i15] = ((Character) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).charValue();
                }
                c = cArr[onpostmessage.a];
                Object[] objArr6 = {onpostmessage, onpostmessage};
                Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(898481158);
                if (objAccessartificialFrame5 == null) {
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 21, (char) (29363 - (ViewConfiguration.getMinimumFlingVelocity() >> 16)), 215 - (ViewConfiguration.getDoubleTapTimeout() >> 16), -1427572210, false, "F", new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame5).invoke(null, objArr6);
                b = 1;
            }
            cArr4 = cArr;
        }
        if (i8 > 0) {
            char[] cArr5 = new char[i6];
            i = 0;
            System.arraycopy(cArr4, 0, cArr5, 0, i6);
            int i16 = i6 - i8;
            System.arraycopy(cArr5, 0, cArr4, i16, i8);
            System.arraycopy(cArr5, i8, cArr4, 0, i16);
        } else {
            i = 0;
        }
        if (z) {
            char[] cArr6 = new char[i6];
            onpostmessage.a = i;
            int i17 = $10 + 75;
            $11 = i17 % 128;
            if (i17 % 2 == 0) {
                int i18 = 4 % 3;
            }
            while (onpostmessage.a < i6) {
                cArr6[onpostmessage.a] = cArr4[(i6 - onpostmessage.a) - 1];
                onpostmessage.a++;
            }
            cArr4 = cArr6;
        }
        if (i7 > 0) {
            int i19 = $11 + 105;
            $10 = i19 % 128;
            int i20 = i19 % 2 != 0 ? 1 : 0;
            while (true) {
                onpostmessage.a = i20;
                if (onpostmessage.a >= i6) {
                    break;
                }
                cArr4[onpostmessage.a] = (char) (cArr4[onpostmessage.a] - iArr[2]);
                i20 = onpostmessage.a + 1;
            }
        }
        objArr[0] = new String(cArr4);
    }

    /* JADX WARN: Code duplicated, block: B:1030:0x265c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:1099:0x0a7e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:1125:0x0a73 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:1186:0x2603 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:1188:0x304c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:1191:0x303f A[EDGE_INSN: B:1191:0x303f->B:923:0x303f BREAK  A[LOOP:13: B:1028:0x2ecc->B:906:0x300b], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:1197:? A[Catch: Exception -> 0x1f8c, SYNTHETIC, TRY_ENTER, TRY_LEAVE, TryCatch #34 {Exception -> 0x1f8c, blocks: (B:218:0x0b1f, B:221:0x0b27, B:223:0x0b32, B:229:0x0bb9, B:272:0x0ed0, B:274:0x0edc, B:275:0x0f07, B:277:0x0f18, B:278:0x0f45, B:320:0x1242, B:322:0x1271, B:323:0x129a, B:325:0x12b3, B:326:0x12db, B:329:0x12f1, B:331:0x12fe, B:332:0x132b, B:333:0x133a, B:335:0x1340, B:337:0x134d, B:338:0x1372, B:340:0x1381, B:341:0x13ae, B:343:0x13b8, B:345:0x13c1, B:346:0x13ea, B:348:0x13f2, B:350:0x13fb, B:351:0x1425, B:417:0x1819, B:419:0x181f, B:420:0x1845, B:422:0x1856, B:423:0x187f, B:469:0x1b8b, B:503:0x1c0d, B:505:0x1c0f, B:507:0x1c16, B:508:0x1c17, B:510:0x1c19, B:512:0x1c20, B:513:0x1c21, B:352:0x142d, B:354:0x1436, B:355:0x1460, B:357:0x146f, B:358:0x1496, B:413:0x1803, B:566:0x1cfd, B:567:0x1d00, B:569:0x1d02, B:571:0x1d09, B:572:0x1d0a, B:574:0x1d0d, B:576:0x1d1c, B:577:0x1d22, B:579:0x1d2b, B:580:0x1d53, B:586:0x1d9a, B:587:0x1da9, B:589:0x1daf, B:591:0x1dbc, B:592:0x1de6, B:594:0x1df7, B:595:0x1e1f, B:598:0x1e35, B:600:0x1e3c, B:601:0x1e3d, B:634:0x1eb8, B:636:0x1eba, B:638:0x1ec1, B:639:0x1ec2, B:641:0x1ec4, B:643:0x1ecb, B:644:0x1ecc, B:677:0x1f43, B:679:0x1f45, B:681:0x1f4c, B:682:0x1f4d, B:684:0x1f4f, B:686:0x1f56, B:687:0x1f57, B:688:0x1f58, B:690:0x1f5d, B:692:0x1f64, B:693:0x1f65, B:695:0x1f67, B:697:0x1f6e, B:698:0x1f6f, B:119:0x09d3, B:121:0x09d9, B:126:0x09de, B:700:0x1f71, B:702:0x1f78, B:703:0x1f79, B:201:0x0a73, B:202:0x0a76, B:206:0x0a7e, B:705:0x1f7b, B:707:0x1f86, B:708:0x1f87, B:283:0x0fb8, B:285:0x0fbe, B:286:0x0fe9, B:291:0x1033, B:293:0x1039, B:294:0x105f, B:299:0x10ae, B:301:0x10b4, B:302:0x10dd, B:308:0x1139, B:310:0x113f, B:311:0x1170, B:604:0x1e40, B:606:0x1e46, B:607:0x1e47, B:609:0x1e49, B:611:0x1e50, B:612:0x1e51, B:614:0x1e53, B:616:0x1e5a, B:617:0x1e5b, B:619:0x1e5d, B:621:0x1e64, B:622:0x1e65, B:624:0x1e67, B:626:0x1e6e, B:627:0x1e6f, B:316:0x11de, B:318:0x11eb, B:319:0x123c, B:312:0x1176, B:314:0x1183, B:315:0x11d8, B:304:0x10e4, B:306:0x10f9, B:307:0x1133, B:295:0x1065, B:297:0x1072, B:298:0x10a2, B:287:0x0fef, B:289:0x0ffc, B:290:0x102d, B:582:0x1d63, B:584:0x1d69, B:585:0x1d93, B:630:0x1e72, B:632:0x1e7f, B:633:0x1eb0, B:279:0x0f52, B:281:0x0f5f, B:282:0x0fb0, B:673:0x1f01, B:675:0x1f0e, B:676:0x1f3b, B:230:0x0be8, B:232:0x0bf5, B:233:0x0c49, B:235:0x0c54, B:237:0x0c5a, B:238:0x0c8a, B:243:0x0cd7, B:245:0x0cdd, B:246:0x0d03, B:251:0x0d55, B:253:0x0d5b, B:254:0x0d83, B:260:0x0dd8, B:262:0x0dde, B:263:0x0e05, B:647:0x1ecf, B:649:0x1ed5, B:650:0x1ed6, B:652:0x1ed8, B:654:0x1edf, B:655:0x1ee0, B:657:0x1ee2, B:659:0x1ee9, B:660:0x1eea, B:662:0x1eec, B:664:0x1ef3, B:665:0x1ef4, B:667:0x1ef6, B:669:0x1efd, B:670:0x1efe, B:363:0x150b, B:365:0x1511, B:366:0x153a, B:371:0x1587, B:373:0x158d, B:374:0x15b5, B:379:0x1606, B:381:0x160c, B:382:0x1638, B:390:0x16a0, B:401:0x16fd, B:403:0x1703, B:404:0x1733, B:516:0x1c24, B:518:0x1c2a, B:519:0x1c2b, B:521:0x1c2d, B:523:0x1c34, B:524:0x1c35, B:526:0x1c37, B:528:0x1c3e, B:529:0x1c3f, B:392:0x16a2, B:394:0x16a9, B:395:0x16aa, B:531:0x1c41, B:533:0x1c48, B:534:0x1c49, B:536:0x1c4b, B:538:0x1c52, B:539:0x1c53, B:548:0x1c9d, B:560:0x1cf2, B:562:0x1cf4, B:564:0x1cfb, B:565:0x1cfc, B:550:0x1c9f, B:552:0x1ca6, B:553:0x1ca7, B:225:0x0b5c, B:227:0x0b7f, B:213:0x0adf, B:215:0x0ae5, B:216:0x0b14, B:208:0x0a83, B:210:0x0a9c, B:211:0x0ad6, B:53:0x046e, B:359:0x149c, B:361:0x14a9, B:362:0x1503, B:499:0x1bc4, B:501:0x1bd1, B:502:0x1c05, B:424:0x188c, B:426:0x1899, B:427:0x18f2, B:429:0x18fd, B:431:0x1903, B:432:0x192c, B:438:0x1978, B:440:0x197e, B:441:0x19a8, B:447:0x19fc, B:449:0x1a02, B:450:0x1a2b, B:457:0x1a88, B:459:0x1a8e, B:460:0x1ab9, B:473:0x1b92, B:475:0x1b98, B:476:0x1b99, B:478:0x1b9b, B:480:0x1ba2, B:481:0x1ba3, B:483:0x1ba5, B:485:0x1bac, B:486:0x1bad, B:488:0x1baf, B:490:0x1bb6, B:491:0x1bb7, B:493:0x1bb9, B:495:0x1bc0, B:496:0x1bc1), top: B:1067:0x03fd, inners: #0, #16, #22, #30, #31, #39, #41, #46, #52, #62, #67, #74, #76, #82, #87, #93 }] */
    /* JADX WARN: Code duplicated, block: B:172:0x0a33 A[Catch: all -> 0x0a51, Exception -> 0x0a7c, TryCatch #40 {all -> 0x0a51, blocks: (B:86:0x0719, B:88:0x0770, B:90:0x07a0, B:92:0x084a, B:94:0x089e, B:96:0x08ec, B:98:0x08f0, B:101:0x0941, B:103:0x0999, B:107:0x09b3, B:109:0x09b9, B:110:0x09ba, B:112:0x09bc, B:114:0x09c3, B:115:0x09c4, B:130:0x09e6, B:132:0x09ec, B:133:0x09ed, B:135:0x09ef, B:137:0x09f6, B:138:0x09f7, B:141:0x09fa, B:143:0x0a00, B:144:0x0a01, B:147:0x0a04, B:149:0x0a06, B:151:0x0a0d, B:152:0x0a0e, B:154:0x0a10, B:156:0x0a17, B:157:0x0a18, B:159:0x0a1a, B:161:0x0a21, B:162:0x0a22, B:170:0x0a2c, B:172:0x0a33, B:173:0x0a34, B:176:0x0a3b, B:178:0x0a41, B:179:0x0a42, B:181:0x0a44, B:183:0x0a4f, B:184:0x0a50), top: B:1077:0x052e }] */
    /* JADX WARN: Code duplicated, block: B:173:0x0a34 A[Catch: all -> 0x0a51, Exception -> 0x0a7c, TryCatch #40 {all -> 0x0a51, blocks: (B:86:0x0719, B:88:0x0770, B:90:0x07a0, B:92:0x084a, B:94:0x089e, B:96:0x08ec, B:98:0x08f0, B:101:0x0941, B:103:0x0999, B:107:0x09b3, B:109:0x09b9, B:110:0x09ba, B:112:0x09bc, B:114:0x09c3, B:115:0x09c4, B:130:0x09e6, B:132:0x09ec, B:133:0x09ed, B:135:0x09ef, B:137:0x09f6, B:138:0x09f7, B:141:0x09fa, B:143:0x0a00, B:144:0x0a01, B:147:0x0a04, B:149:0x0a06, B:151:0x0a0d, B:152:0x0a0e, B:154:0x0a10, B:156:0x0a17, B:157:0x0a18, B:159:0x0a1a, B:161:0x0a21, B:162:0x0a22, B:170:0x0a2c, B:172:0x0a33, B:173:0x0a34, B:176:0x0a3b, B:178:0x0a41, B:179:0x0a42, B:181:0x0a44, B:183:0x0a4f, B:184:0x0a50), top: B:1077:0x052e }] */
    /* JADX WARN: Code duplicated, block: B:178:0x0a41 A[Catch: all -> 0x0a51, Exception -> 0x0a7c, TryCatch #40 {all -> 0x0a51, blocks: (B:86:0x0719, B:88:0x0770, B:90:0x07a0, B:92:0x084a, B:94:0x089e, B:96:0x08ec, B:98:0x08f0, B:101:0x0941, B:103:0x0999, B:107:0x09b3, B:109:0x09b9, B:110:0x09ba, B:112:0x09bc, B:114:0x09c3, B:115:0x09c4, B:130:0x09e6, B:132:0x09ec, B:133:0x09ed, B:135:0x09ef, B:137:0x09f6, B:138:0x09f7, B:141:0x09fa, B:143:0x0a00, B:144:0x0a01, B:147:0x0a04, B:149:0x0a06, B:151:0x0a0d, B:152:0x0a0e, B:154:0x0a10, B:156:0x0a17, B:157:0x0a18, B:159:0x0a1a, B:161:0x0a21, B:162:0x0a22, B:170:0x0a2c, B:172:0x0a33, B:173:0x0a34, B:176:0x0a3b, B:178:0x0a41, B:179:0x0a42, B:181:0x0a44, B:183:0x0a4f, B:184:0x0a50), top: B:1077:0x052e }] */
    /* JADX WARN: Code duplicated, block: B:179:0x0a42 A[Catch: all -> 0x0a51, Exception -> 0x0a7c, TryCatch #40 {all -> 0x0a51, blocks: (B:86:0x0719, B:88:0x0770, B:90:0x07a0, B:92:0x084a, B:94:0x089e, B:96:0x08ec, B:98:0x08f0, B:101:0x0941, B:103:0x0999, B:107:0x09b3, B:109:0x09b9, B:110:0x09ba, B:112:0x09bc, B:114:0x09c3, B:115:0x09c4, B:130:0x09e6, B:132:0x09ec, B:133:0x09ed, B:135:0x09ef, B:137:0x09f6, B:138:0x09f7, B:141:0x09fa, B:143:0x0a00, B:144:0x0a01, B:147:0x0a04, B:149:0x0a06, B:151:0x0a0d, B:152:0x0a0e, B:154:0x0a10, B:156:0x0a17, B:157:0x0a18, B:159:0x0a1a, B:161:0x0a21, B:162:0x0a22, B:170:0x0a2c, B:172:0x0a33, B:173:0x0a34, B:176:0x0a3b, B:178:0x0a41, B:179:0x0a42, B:181:0x0a44, B:183:0x0a4f, B:184:0x0a50), top: B:1077:0x052e }] */
    /* JADX WARN: Code duplicated, block: B:210:0x0a9c A[Catch: all -> 0x1f70, TryCatch #67 {all -> 0x1f70, blocks: (B:208:0x0a83, B:210:0x0a9c, B:211:0x0ad6), top: B:1117:0x0a83, outer: #34 }] */
    /* JADX WARN: Code duplicated, block: B:215:0x0ae5 A[Catch: all -> 0x1f66, TryCatch #62 {all -> 0x1f66, blocks: (B:213:0x0adf, B:215:0x0ae5, B:216:0x0b14), top: B:1109:0x0adf, outer: #34 }] */
    /* JADX WARN: Code duplicated, block: B:710:0x1f8c A[EDGE_INSN: B:710:0x1f8c->B:711:0x1f8d BREAK  A[LOOP:1: B:222:0x0b30->B:688:0x1f58], PHI: r26 r27
  0x1f8c: PHI (r26v7 ??) = (r26v6 ??), (r26v17 ??), (r26v35 ??), (r26v35 ??), (r26v35 ??) binds: [B:709:0x1f88, B:995:0x1f8c, B:217:0x0b1d, B:1172:0x1f8c, B:220:0x0b25] A[DONT_GENERATE, DONT_INLINE]
  0x1f8c: PHI (r27v4 ??) = (r27v3 ??), (r27v6 ??), (r27v21 ??), (r27v21 ??), (r27v21 ??) binds: [B:709:0x1f88, B:995:0x1f8c, B:217:0x0b1d, B:1172:0x1f8c, B:220:0x0b25] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:763:0x2266  */
    /* JADX WARN: Code duplicated, block: B:766:0x226b  */
    /* JADX WARN: Code duplicated, block: B:767:0x226f  */
    /* JADX WARN: Code duplicated, block: B:769:0x2279  */
    /* JADX WARN: Code duplicated, block: B:770:0x227b  */
    /* JADX WARN: Code duplicated, block: B:773:0x235c  */
    /* JADX WARN: Code duplicated, block: B:776:0x23a1  */
    /* JADX WARN: Code duplicated, block: B:778:0x23b1  */
    /* JADX WARN: Code duplicated, block: B:799:0x24ea  */
    /* JADX WARN: Code duplicated, block: B:801:0x253f A[Catch: all -> 0x330c, TryCatch #81 {all -> 0x330c, blocks: (B:800:0x24eb, B:801:0x253f, B:803:0x2549, B:814:0x25bc, B:816:0x25e5, B:818:0x25ed, B:819:0x25fa, B:822:0x260a, B:824:0x2611, B:825:0x2612, B:820:0x2603, B:827:0x2614, B:829:0x261b, B:830:0x261c, B:832:0x261f, B:934:0x3172, B:935:0x317f, B:937:0x3193, B:939:0x319c, B:940:0x319d, B:942:0x319f, B:944:0x31a8, B:945:0x31a9, B:950:0x31b0, B:952:0x31b7, B:953:0x31b8, B:955:0x31ba, B:957:0x31c2, B:958:0x31c3, B:960:0x31c5, B:962:0x31cd, B:963:0x31ce, B:964:0x31cf, B:966:0x31e5, B:968:0x31ed, B:969:0x31ee, B:970:0x31ef, B:971:0x3222, B:973:0x3228, B:974:0x328f, B:976:0x32ec, B:978:0x32f4, B:979:0x32f5, B:981:0x32f7, B:983:0x32ff, B:984:0x3300, B:986:0x3302, B:988:0x330a, B:989:0x330b, B:890:0x2d56, B:888:0x2cd5, B:877:0x2b57, B:873:0x2aee, B:871:0x2a67, B:868:0x29cd, B:870:0x2a4f, B:815:0x25c0, B:896:0x2ea4, B:805:0x254c, B:895:0x2e73), top: B:1143:0x24e8, inners: #23, #32, #60, #64, #70, #75, #80, #85, #86, #91 }] */
    /* JADX WARN: Code duplicated, block: B:803:0x2549 A[Catch: all -> 0x330c, TRY_LEAVE, TryCatch #81 {all -> 0x330c, blocks: (B:800:0x24eb, B:801:0x253f, B:803:0x2549, B:814:0x25bc, B:816:0x25e5, B:818:0x25ed, B:819:0x25fa, B:822:0x260a, B:824:0x2611, B:825:0x2612, B:820:0x2603, B:827:0x2614, B:829:0x261b, B:830:0x261c, B:832:0x261f, B:934:0x3172, B:935:0x317f, B:937:0x3193, B:939:0x319c, B:940:0x319d, B:942:0x319f, B:944:0x31a8, B:945:0x31a9, B:950:0x31b0, B:952:0x31b7, B:953:0x31b8, B:955:0x31ba, B:957:0x31c2, B:958:0x31c3, B:960:0x31c5, B:962:0x31cd, B:963:0x31ce, B:964:0x31cf, B:966:0x31e5, B:968:0x31ed, B:969:0x31ee, B:970:0x31ef, B:971:0x3222, B:973:0x3228, B:974:0x328f, B:976:0x32ec, B:978:0x32f4, B:979:0x32f5, B:981:0x32f7, B:983:0x32ff, B:984:0x3300, B:986:0x3302, B:988:0x330a, B:989:0x330b, B:890:0x2d56, B:888:0x2cd5, B:877:0x2b57, B:873:0x2aee, B:871:0x2a67, B:868:0x29cd, B:870:0x2a4f, B:815:0x25c0, B:896:0x2ea4, B:805:0x254c, B:895:0x2e73), top: B:1143:0x24e8, inners: #23, #32, #60, #64, #70, #75, #80, #85, #86, #91 }] */
    /* JADX WARN: Code duplicated, block: B:808:0x259e  */
    /* JADX WARN: Code duplicated, block: B:809:0x25b2  */
    /* JADX WARN: Code duplicated, block: B:813:0x25ba  */
    /* JADX WARN: Code duplicated, block: B:818:0x25ed A[Catch: all -> 0x330c, LOOP:10: B:817:0x25eb->B:818:0x25ed, LOOP_END, TryCatch #81 {all -> 0x330c, blocks: (B:800:0x24eb, B:801:0x253f, B:803:0x2549, B:814:0x25bc, B:816:0x25e5, B:818:0x25ed, B:819:0x25fa, B:822:0x260a, B:824:0x2611, B:825:0x2612, B:820:0x2603, B:827:0x2614, B:829:0x261b, B:830:0x261c, B:832:0x261f, B:934:0x3172, B:935:0x317f, B:937:0x3193, B:939:0x319c, B:940:0x319d, B:942:0x319f, B:944:0x31a8, B:945:0x31a9, B:950:0x31b0, B:952:0x31b7, B:953:0x31b8, B:955:0x31ba, B:957:0x31c2, B:958:0x31c3, B:960:0x31c5, B:962:0x31cd, B:963:0x31ce, B:964:0x31cf, B:966:0x31e5, B:968:0x31ed, B:969:0x31ee, B:970:0x31ef, B:971:0x3222, B:973:0x3228, B:974:0x328f, B:976:0x32ec, B:978:0x32f4, B:979:0x32f5, B:981:0x32f7, B:983:0x32ff, B:984:0x3300, B:986:0x3302, B:988:0x330a, B:989:0x330b, B:890:0x2d56, B:888:0x2cd5, B:877:0x2b57, B:873:0x2aee, B:871:0x2a67, B:868:0x29cd, B:870:0x2a4f, B:815:0x25c0, B:896:0x2ea4, B:805:0x254c, B:895:0x2e73), top: B:1143:0x24e8, inners: #23, #32, #60, #64, #70, #75, #80, #85, #86, #91 }] */
    /* JADX WARN: Code duplicated, block: B:832:0x261f A[Catch: all -> 0x330c, TRY_LEAVE, TryCatch #81 {all -> 0x330c, blocks: (B:800:0x24eb, B:801:0x253f, B:803:0x2549, B:814:0x25bc, B:816:0x25e5, B:818:0x25ed, B:819:0x25fa, B:822:0x260a, B:824:0x2611, B:825:0x2612, B:820:0x2603, B:827:0x2614, B:829:0x261b, B:830:0x261c, B:832:0x261f, B:934:0x3172, B:935:0x317f, B:937:0x3193, B:939:0x319c, B:940:0x319d, B:942:0x319f, B:944:0x31a8, B:945:0x31a9, B:950:0x31b0, B:952:0x31b7, B:953:0x31b8, B:955:0x31ba, B:957:0x31c2, B:958:0x31c3, B:960:0x31c5, B:962:0x31cd, B:963:0x31ce, B:964:0x31cf, B:966:0x31e5, B:968:0x31ed, B:969:0x31ee, B:970:0x31ef, B:971:0x3222, B:973:0x3228, B:974:0x328f, B:976:0x32ec, B:978:0x32f4, B:979:0x32f5, B:981:0x32f7, B:983:0x32ff, B:984:0x3300, B:986:0x3302, B:988:0x330a, B:989:0x330b, B:890:0x2d56, B:888:0x2cd5, B:877:0x2b57, B:873:0x2aee, B:871:0x2a67, B:868:0x29cd, B:870:0x2a4f, B:815:0x25c0, B:896:0x2ea4, B:805:0x254c, B:895:0x2e73), top: B:1143:0x24e8, inners: #23, #32, #60, #64, #70, #75, #80, #85, #86, #91 }] */
    /* JADX WARN: Code duplicated, block: B:844:0x2784 A[Catch: all -> 0x29b7, TryCatch #19 {all -> 0x29b7, blocks: (B:842:0x2747, B:844:0x2784, B:846:0x278e, B:901:0x2f14, B:906:0x300b, B:908:0x301f, B:910:0x3026, B:911:0x3027, B:913:0x3029, B:915:0x3030, B:916:0x3031, B:923:0x303f, B:928:0x30c2, B:930:0x30d1, B:932:0x30ef, B:929:0x30c9, B:918:0x3033, B:920:0x303a, B:921:0x303b, B:903:0x2f1d, B:899:0x2ecc, B:905:0x2f77), top: B:1038:0x2747, inners: #7, #14, #90 }] */
    /* JADX WARN: Code duplicated, block: B:851:0x284b A[Catch: all -> 0x29c6, TryCatch #35 {all -> 0x29c6, blocks: (B:848:0x2833, B:849:0x2840, B:851:0x284b, B:852:0x28c5, B:854:0x28cd, B:857:0x295a, B:874:0x2b4c, B:876:0x2b55, B:881:0x2ba4, B:883:0x2c28, B:885:0x2cb5, B:887:0x2cd3, B:882:0x2bbd, B:861:0x29be, B:863:0x29c4, B:864:0x29c5), top: B:1068:0x261d }] */
    /* JADX WARN: Code duplicated, block: B:852:0x28c5 A[Catch: all -> 0x29c6, TryCatch #35 {all -> 0x29c6, blocks: (B:848:0x2833, B:849:0x2840, B:851:0x284b, B:852:0x28c5, B:854:0x28cd, B:857:0x295a, B:874:0x2b4c, B:876:0x2b55, B:881:0x2ba4, B:883:0x2c28, B:885:0x2cb5, B:887:0x2cd3, B:882:0x2bbd, B:861:0x29be, B:863:0x29c4, B:864:0x29c5), top: B:1068:0x261d }] */
    /* JADX WARN: Code duplicated, block: B:854:0x28cd A[Catch: all -> 0x29c6, TryCatch #35 {all -> 0x29c6, blocks: (B:848:0x2833, B:849:0x2840, B:851:0x284b, B:852:0x28c5, B:854:0x28cd, B:857:0x295a, B:874:0x2b4c, B:876:0x2b55, B:881:0x2ba4, B:883:0x2c28, B:885:0x2cb5, B:887:0x2cd3, B:882:0x2bbd, B:861:0x29be, B:863:0x29c4, B:864:0x29c5), top: B:1068:0x261d }] */
    /* JADX WARN: Code duplicated, block: B:855:0x2956  */
    /* JADX WARN: Code duplicated, block: B:857:0x295a A[Catch: all -> 0x29c6, TryCatch #35 {all -> 0x29c6, blocks: (B:848:0x2833, B:849:0x2840, B:851:0x284b, B:852:0x28c5, B:854:0x28cd, B:857:0x295a, B:874:0x2b4c, B:876:0x2b55, B:881:0x2ba4, B:883:0x2c28, B:885:0x2cb5, B:887:0x2cd3, B:882:0x2bbd, B:861:0x29be, B:863:0x29c4, B:864:0x29c5), top: B:1068:0x261d }] */
    /* JADX WARN: Code duplicated, block: B:866:0x29c9  */
    /* JADX WARN: Code duplicated, block: B:876:0x2b55 A[Catch: all -> 0x29c6, TRY_LEAVE, TryCatch #35 {all -> 0x29c6, blocks: (B:848:0x2833, B:849:0x2840, B:851:0x284b, B:852:0x28c5, B:854:0x28cd, B:857:0x295a, B:874:0x2b4c, B:876:0x2b55, B:881:0x2ba4, B:883:0x2c28, B:885:0x2cb5, B:887:0x2cd3, B:882:0x2bbd, B:861:0x29be, B:863:0x29c4, B:864:0x29c5), top: B:1068:0x261d }] */
    /* JADX WARN: Code duplicated, block: B:880:0x2ba3  */
    /* JADX WARN: Code duplicated, block: B:882:0x2bbd A[Catch: all -> 0x29c6, TryCatch #35 {all -> 0x29c6, blocks: (B:848:0x2833, B:849:0x2840, B:851:0x284b, B:852:0x28c5, B:854:0x28cd, B:857:0x295a, B:874:0x2b4c, B:876:0x2b55, B:881:0x2ba4, B:883:0x2c28, B:885:0x2cb5, B:887:0x2cd3, B:882:0x2bbd, B:861:0x29be, B:863:0x29c4, B:864:0x29c5), top: B:1068:0x261d }] */
    /* JADX WARN: Code duplicated, block: B:887:0x2cd3 A[Catch: all -> 0x29c6, TRY_LEAVE, TryCatch #35 {all -> 0x29c6, blocks: (B:848:0x2833, B:849:0x2840, B:851:0x284b, B:852:0x28c5, B:854:0x28cd, B:857:0x295a, B:874:0x2b4c, B:876:0x2b55, B:881:0x2ba4, B:883:0x2c28, B:885:0x2cb5, B:887:0x2cd3, B:882:0x2bbd, B:861:0x29be, B:863:0x29c4, B:864:0x29c5), top: B:1068:0x261d }] */
    /* JADX WARN: Code duplicated, block: B:898:0x2ec8  */
    /* JADX WARN: Code duplicated, block: B:901:0x2f14 A[Catch: all -> 0x29b7, TRY_ENTER, TRY_LEAVE, TryCatch #19 {all -> 0x29b7, blocks: (B:842:0x2747, B:844:0x2784, B:846:0x278e, B:901:0x2f14, B:906:0x300b, B:908:0x301f, B:910:0x3026, B:911:0x3027, B:913:0x3029, B:915:0x3030, B:916:0x3031, B:923:0x303f, B:928:0x30c2, B:930:0x30d1, B:932:0x30ef, B:929:0x30c9, B:918:0x3033, B:920:0x303a, B:921:0x303b, B:903:0x2f1d, B:899:0x2ecc, B:905:0x2f77), top: B:1038:0x2747, inners: #7, #14, #90 }] */
    /* JADX WARN: Code duplicated, block: B:922:0x303c  */
    /* JADX WARN: Code duplicated, block: B:927:0x30c1  */
    /* JADX WARN: Code duplicated, block: B:929:0x30c9 A[Catch: all -> 0x29b7, TryCatch #19 {all -> 0x29b7, blocks: (B:842:0x2747, B:844:0x2784, B:846:0x278e, B:901:0x2f14, B:906:0x300b, B:908:0x301f, B:910:0x3026, B:911:0x3027, B:913:0x3029, B:915:0x3030, B:916:0x3031, B:923:0x303f, B:928:0x30c2, B:930:0x30d1, B:932:0x30ef, B:929:0x30c9, B:918:0x3033, B:920:0x303a, B:921:0x303b, B:903:0x2f1d, B:899:0x2ecc, B:905:0x2f77), top: B:1038:0x2747, inners: #7, #14, #90 }] */
    /* JADX WARN: Code duplicated, block: B:935:0x317f A[Catch: all -> 0x330c, LOOP:12: B:886:0x2cd1->B:935:0x317f, LOOP_END, TryCatch #81 {all -> 0x330c, blocks: (B:800:0x24eb, B:801:0x253f, B:803:0x2549, B:814:0x25bc, B:816:0x25e5, B:818:0x25ed, B:819:0x25fa, B:822:0x260a, B:824:0x2611, B:825:0x2612, B:820:0x2603, B:827:0x2614, B:829:0x261b, B:830:0x261c, B:832:0x261f, B:934:0x3172, B:935:0x317f, B:937:0x3193, B:939:0x319c, B:940:0x319d, B:942:0x319f, B:944:0x31a8, B:945:0x31a9, B:950:0x31b0, B:952:0x31b7, B:953:0x31b8, B:955:0x31ba, B:957:0x31c2, B:958:0x31c3, B:960:0x31c5, B:962:0x31cd, B:963:0x31ce, B:964:0x31cf, B:966:0x31e5, B:968:0x31ed, B:969:0x31ee, B:970:0x31ef, B:971:0x3222, B:973:0x3228, B:974:0x328f, B:976:0x32ec, B:978:0x32f4, B:979:0x32f5, B:981:0x32f7, B:983:0x32ff, B:984:0x3300, B:986:0x3302, B:988:0x330a, B:989:0x330b, B:890:0x2d56, B:888:0x2cd5, B:877:0x2b57, B:873:0x2aee, B:871:0x2a67, B:868:0x29cd, B:870:0x2a4f, B:815:0x25c0, B:896:0x2ea4, B:805:0x254c, B:895:0x2e73), top: B:1143:0x24e8, inners: #23, #32, #60, #64, #70, #75, #80, #85, #86, #91 }] */
    /* JADX WARN: Code duplicated, block: B:973:0x3228 A[Catch: all -> 0x330c, LOOP:14: B:971:0x3222->B:973:0x3228, LOOP_END, TryCatch #81 {all -> 0x330c, blocks: (B:800:0x24eb, B:801:0x253f, B:803:0x2549, B:814:0x25bc, B:816:0x25e5, B:818:0x25ed, B:819:0x25fa, B:822:0x260a, B:824:0x2611, B:825:0x2612, B:820:0x2603, B:827:0x2614, B:829:0x261b, B:830:0x261c, B:832:0x261f, B:934:0x3172, B:935:0x317f, B:937:0x3193, B:939:0x319c, B:940:0x319d, B:942:0x319f, B:944:0x31a8, B:945:0x31a9, B:950:0x31b0, B:952:0x31b7, B:953:0x31b8, B:955:0x31ba, B:957:0x31c2, B:958:0x31c3, B:960:0x31c5, B:962:0x31cd, B:963:0x31ce, B:964:0x31cf, B:966:0x31e5, B:968:0x31ed, B:969:0x31ee, B:970:0x31ef, B:971:0x3222, B:973:0x3228, B:974:0x328f, B:976:0x32ec, B:978:0x32f4, B:979:0x32f5, B:981:0x32f7, B:983:0x32ff, B:984:0x3300, B:986:0x3302, B:988:0x330a, B:989:0x330b, B:890:0x2d56, B:888:0x2cd5, B:877:0x2b57, B:873:0x2aee, B:871:0x2a67, B:868:0x29cd, B:870:0x2a4f, B:815:0x25c0, B:896:0x2ea4, B:805:0x254c, B:895:0x2e73), top: B:1143:0x24e8, inners: #23, #32, #60, #64, #70, #75, #80, #85, #86, #91 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v114, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r10v167, types: [java.nio.LongBuffer] */
    /* JADX WARN: Type inference failed for: r11v72, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r12v61, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v131, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r1v260, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r1v59, types: [int] */
    /* JADX WARN: Type inference failed for: r1v77, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r26v17 */
    /* JADX WARN: Type inference failed for: r26v22 */
    /* JADX WARN: Type inference failed for: r26v23 */
    /* JADX WARN: Type inference failed for: r26v27 */
    /* JADX WARN: Type inference failed for: r26v33 */
    /* JADX WARN: Type inference failed for: r26v35 */
    /* JADX WARN: Type inference failed for: r26v36 */
    /* JADX WARN: Type inference failed for: r26v39, types: [char] */
    /* JADX WARN: Type inference failed for: r26v40 */
    /* JADX WARN: Type inference failed for: r26v41 */
    /* JADX WARN: Type inference failed for: r26v42 */
    /* JADX WARN: Type inference failed for: r26v43 */
    /* JADX WARN: Type inference failed for: r26v44 */
    /* JADX WARN: Type inference failed for: r26v6 */
    /* JADX WARN: Type inference failed for: r26v7 */
    /* JADX WARN: Type inference failed for: r26v8 */
    /* JADX WARN: Type inference failed for: r27v0 */
    /* JADX WARN: Type inference failed for: r27v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r27v11 */
    /* JADX WARN: Type inference failed for: r27v12 */
    /* JADX WARN: Type inference failed for: r27v13 */
    /* JADX WARN: Type inference failed for: r27v19 */
    /* JADX WARN: Type inference failed for: r27v21 */
    /* JADX WARN: Type inference failed for: r27v22 */
    /* JADX WARN: Type inference failed for: r27v24, types: [int] */
    /* JADX WARN: Type inference failed for: r27v25 */
    /* JADX WARN: Type inference failed for: r27v26 */
    /* JADX WARN: Type inference failed for: r27v27 */
    /* JADX WARN: Type inference failed for: r27v28 */
    /* JADX WARN: Type inference failed for: r27v29 */
    /* JADX WARN: Type inference failed for: r27v3 */
    /* JADX WARN: Type inference failed for: r27v30 */
    /* JADX WARN: Type inference failed for: r27v4 */
    /* JADX WARN: Type inference failed for: r27v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r27v6 */
    /* JADX WARN: Type inference failed for: r29v0 */
    /* JADX WARN: Type inference failed for: r29v1 */
    /* JADX WARN: Type inference failed for: r29v11 */
    /* JADX WARN: Type inference failed for: r29v2 */
    /* JADX WARN: Type inference failed for: r2v35, types: [java.nio.LongBuffer[]] */
    /* JADX WARN: Type inference failed for: r3v45 */
    /* JADX WARN: Type inference failed for: r3v471 */
    /* JADX WARN: Type inference failed for: r3v49 */
    /* JADX WARN: Type inference failed for: r3v90 */
    /* JADX WARN: Type inference failed for: r46v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11, types: [int] */
    /* JADX WARN: Type inference failed for: r5v110, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r5v115 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v140 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v23, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v235 */
    /* JADX WARN: Type inference failed for: r5v236 */
    /* JADX WARN: Type inference failed for: r5v237 */
    /* JADX WARN: Type inference failed for: r5v24 */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v253 */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r5v545 */
    /* JADX WARN: Type inference failed for: r5v546 */
    /* JADX WARN: Type inference failed for: r5v551 */
    /* JADX WARN: Type inference failed for: r5v552 */
    /* JADX WARN: Type inference failed for: r5v553 */
    /* JADX WARN: Type inference failed for: r5v554 */
    /* JADX WARN: Type inference failed for: r5v555 */
    /* JADX WARN: Type inference failed for: r5v556 */
    /* JADX WARN: Type inference failed for: r5v557 */
    /* JADX WARN: Type inference failed for: r5v558 */
    /* JADX WARN: Type inference failed for: r5v559 */
    /* JADX WARN: Type inference failed for: r5v57 */
    /* JADX WARN: Type inference failed for: r5v59 */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.nio.LongBuffer[]] */
    /* JADX WARN: Type inference failed for: r5v74 */
    /* JADX WARN: Type inference failed for: r5v75 */
    /* JADX WARN: Type inference failed for: r5v83, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v9, types: [int] */
    /* JADX WARN: Type inference failed for: r6v113 */
    /* JADX WARN: Type inference failed for: r6v114 */
    /* JADX WARN: Type inference failed for: r6v189, types: [java.lang.Object, java.nio.LongBuffer] */
    /* JADX WARN: Type inference failed for: r6v196, types: [java.lang.Object, java.nio.LongBuffer] */
    /* JADX WARN: Type inference failed for: r6v27 */
    /* JADX WARN: Type inference failed for: r6v28 */
    /* JADX WARN: Type inference failed for: r6v29 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v45 */
    /* JADX WARN: Type inference failed for: r6v518 */
    /* JADX WARN: Type inference failed for: r6v519 */
    /* JADX WARN: Type inference failed for: r6v520 */
    /* JADX WARN: Type inference failed for: r6v521 */
    /* JADX WARN: Type inference failed for: r6v96 */
    /* JADX WARN: Type inference failed for: r8v231, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v457 */
    /* JADX WARN: Type inference failed for: r8v471 */
    /* JADX WARN: Type inference failed for: r8v472 */
    /* JADX WARN: Type inference failed for: r9v109, types: [java.lang.Object, java.nio.LongBuffer] */
    /* JADX WARN: Type inference failed for: r9v60, types: [java.lang.Object, java.nio.LongBuffer] */
    public static Object[] accessartificialFrame(Context context, String[] strArr, int i, int i2, int i3) throws Throwable {
        Object obj;
        int i4;
        ?? r29;
        ?? r27;
        int i5;
        char c;
        int i6;
        Object[] objArr;
        ?? Invoke;
        ?? r3;
        byte[][] bArr;
        int length;
        int i7;
        int i8;
        ?? r6;
        String str;
        int i9;
        int i10;
        Object objInvoke;
        LinkedHashSet linkedHashSet;
        int i11;
        ?? r7;
        ?? r4;
        int i12;
        ArrayList arrayList;
        String[] strArr2;
        int i13;
        ?? r9;
        Class<?> cls;
        Object[] objArr2;
        String str2;
        int length2;
        int i14;
        ?? r8;
        Object obj2;
        String str3;
        ?? r46;
        int i15;
        int i16;
        int i17;
        int i18;
        Object objInvoke2;
        String str4;
        String string;
        int i19;
        int i20;
        int i21;
        int i22;
        Class<?> cls2;
        Object[] objArr3;
        String[][] strArr3;
        Throwable th;
        Object objAccessartificialFrame;
        int i23;
        int i24;
        int i25;
        int i26;
        Object[] objArr4;
        ?? r10;
        Class<?> cls3;
        Object[] objArr5;
        boolean z;
        LongBuffer longBuffer;
        long[] jArrArray;
        int length3;
        int i27;
        ?? r26;
        ?? r28;
        List listEmptyList;
        ?? r210;
        ?? r211;
        ?? r5;
        String strSubstring;
        ?? r11;
        int i28;
        int i29;
        int i30;
        Object objAccessartificialFrame2;
        int i31;
        String string2;
        ?? method;
        Throwable th2;
        int i32;
        ArrayList arrayList2;
        Object objAccessartificialFrame3;
        Object objNewInstance;
        int i33;
        int i34;
        Class<?> cls4;
        Throwable th3;
        Throwable cause;
        Throwable th4;
        Throwable cause2;
        Object objAccessartificialFrame4;
        List list;
        Object obj3;
        Object[] objArr6;
        String[] strArr4 = strArr;
        int i35 = i;
        int i36 = 2 % 2;
        int packedPositionChild = ExpandableListView.getPackedPositionChild(0L);
        int i37 = 1;
        Object[] objArr7 = new Object[1];
        c(((packedPositionChild | 12) << 1) - (packedPositionChild ^ 12), new char[]{53866, 34687, 2128, 51169, 31081, 8017, 47102, 21450, 30804, 52427, 41716, 19142}, objArr7);
        byte b = 0;
        String str5 = (String) objArr7[0];
        int i38 = artificialFrame;
        int i39 = ((i38 | 79) << 1) - (i38 ^ 79);
        getARTIFICIAL_FRAME_PACKAGE_NAME = i39 % 128;
        if (i39 % 2 != 0) {
            Object[] objArr8 = new Object[1];
            c(View.MeasureSpec.getMode(1) * 63, new char[]{20794, 4322, 33636, 55455, 18972, 17295, 63872, 20131, 32357, 8626, 5318, 18154, 59070, 9716, 48690, 6926, 56076, 31992, 23144, 34195}, objArr8);
            obj = objArr8[0];
        } else {
            Object[] objArr9 = new Object[1];
            c(View.MeasureSpec.getMode(0) + 19, new char[]{20794, 4322, 33636, 55455, 18972, 17295, 63872, 20131, 32357, 8626, 5318, 18154, 59070, 9716, 48690, 6926, 56076, 31992, 23144, 34195}, objArr9);
            obj = objArr9[0];
        }
        String str6 = (String) obj;
        if (context == null) {
            Object[] objArr10 = {new int[]{i35}, null, new int[]{((~i) & i) | ((~i) & i)}, new int[]{i35}};
            int i40 = ~i35;
            int i41 = (-1084539062) + (((~((-181859183) | i40)) | (~(21509456 | i35))) * JfifUtil.MARKER_EOI) + (((~((-181859183) | i35)) | 177652270) * JfifUtil.MARKER_EOI) + (((~(21509456 | i40)) | 181859182) * JfifUtil.MARKER_EOI);
            int i42 = (-1) - (~(-(-(i41 * (-495)))));
            int i43 = ~i41;
            int i44 = i42 + ((~(((-1) ^ i43) | i43)) * 992);
            int i45 = ~(i43 | ((-1) ^ i43));
            int i46 = ~(((-1) ^ i35) | i35);
            int i47 = (i3 - (~(-(-(((i44 - (~(((~((i40 & i41) | (i40 ^ i41))) | ((i45 & i46) | (i45 ^ i46))) * (-496)))) - 1) + (((i41 ^ i35) | (i35 & i41)) * 496)))))) - 1;
            int i48 = i47 << 13;
            int i49 = (i47 | i48) & (~(i47 & i48));
            int i50 = i49 ^ (i49 >>> 17);
            int i51 = i50 << 5;
            return objArr10;
        }
        if (strArr4.length != 0) {
            int length4 = strArr4.length;
            Object[] objArr11 = new Object[1];
            a(new byte[]{0, 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1}, new int[]{0, 19, SyslogConstants.LOG_LOCAL7, 10}, true, objArr11);
            ?? r12 = (LongBuffer[]) Array.newInstance(Class.forName((String) objArr11[0]), length4);
            int i52 = 0;
            while (i52 < strArr4.length) {
                String lowerCase = strArr4[i52].toLowerCase();
                byte[] bArr2 = new byte[i37];
                bArr2[b] = b;
                Object[] objArr12 = new Object[i37];
                a(bArr2, new int[]{19, i37, b, b}, b, objArr12);
                String strReplaceAll = lowerCase.replaceAll((String) objArr12[b], "");
                long jLongValue = new BigInteger(strReplaceAll.substring(16, 32), 16).longValue();
                long jLongValue2 = new BigInteger(strReplaceAll.substring(b, 16), 16).longValue();
                int length5 = strReplaceAll.length();
                if (length5 == 32) {
                    r12[i52] = LongBuffer.allocate(2).put(jLongValue2).put(jLongValue);
                } else if (length5 != 64) {
                    objArr6 = new Object[]{new int[]{i35 ^ 3}, null, new int[1], new int[]{i35}};
                    int i53 = ~i35;
                    int i54 = 798454822 + ((~(431247754 | i53)) * 979) + ((i35 | 591597480) * (-979)) + (((~(i53 | 591597480)) | (~(i35 | 431247754))) * 979);
                    int iINotificationSideChannel = SqlDateTypeAdapter.AnonymousClass1.INotificationSideChannel();
                    int i55 = -(-(i54 * (-756)));
                    int i56 = (12128 ^ i55) + ((i55 & 12128) << 1);
                    int i57 = ((~iINotificationSideChannel) | 16) * (-757);
                    int i58 = (i56 ^ i57) + ((i57 & i56) << 1);
                    int i59 = ~i54;
                    int i60 = i59 | 16;
                    int i61 = i58 + ((~((i60 & iINotificationSideChannel) | (i60 ^ iINotificationSideChannel))) * 1514);
                    int i62 = ~(i59 | (-17));
                    int i63 = ~i54;
                    int i64 = ~iINotificationSideChannel;
                    int i65 = ~((i63 & i64) | (i63 ^ i64));
                    int i66 = (i62 & i65) | (i62 ^ i65);
                    int i67 = 16 | i54;
                    int i68 = -(-(i61 + (((~((iINotificationSideChannel & i67) | (i67 ^ iINotificationSideChannel))) | i66) * 757)));
                    int i69 = ((i3 | i68) << 1) - (i68 ^ i3);
                    int i70 = i69 << 13;
                    int i71 = (i70 | i69) & (~(i69 & i70));
                    int i72 = i71 >>> 17;
                    int i73 = ((~i71) & i72) | ((~i72) & i71);
                    int i74 = i73 << 5;
                    ((int[]) objArr6[2])[0] = ((~i73) & i74) | ((~i74) & i73);
                } else {
                    r12[i52] = LongBuffer.allocate(4).put(jLongValue2).put(jLongValue).put(new BigInteger(strReplaceAll.substring(32, 48), 16).longValue()).put(new BigInteger(strReplaceAll.substring(48), 16).longValue());
                }
                int i75 = i52 - 76;
                i52 = (i75 ^ 77) + ((i75 & 77) << 1);
                strArr4 = strArr;
                i35 = i;
                str6 = str6;
                b = 0;
                i37 = 1;
            }
            ?? r13 = str6;
            boolean z2 = (i2 & 2) != 0;
            try {
                if (z2) {
                    Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(682069389);
                    if (objAccessartificialFrame5 == null) {
                        int i76 = 22 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
                        char cMyPid = (char) (Process.myPid() >> 22);
                        int iResolveSizeAndState = View.resolveSizeAndState(0, 0, 0) + 465;
                        byte b2 = (byte) ($$a[11] + 1);
                        byte b3 = b2;
                        Object[] objArr13 = new Object[1];
                        b(b2, b3, b3, objArr13);
                        r26 = cMyPid;
                        r28 = iResolveSizeAndState;
                        objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(i76, r26, r28, -1211970683, false, (String) objArr13[0], null);
                    }
                    if (((Field) objAccessartificialFrame5).get(null) == null) {
                        try {
                            Object[] objArr14 = new Object[1];
                            a(null, new int[]{20, 14, 183, 8}, true, objArr14);
                            try {
                                String string3 = Class.forName((String) objArr14[0]).getDeclaredConstructor(null).newInstance(null).toString();
                                int offsetAfter = TextUtils.getOffsetAfter("", 0);
                                int i77 = (offsetAfter * TypedValues.PositionType.TYPE_PERCENT_WIDTH) + 2515;
                                int i78 = (offsetAfter ^ 5) | (offsetAfter & 5);
                                int i79 = i78 * (-502);
                                int i80 = (i77 & i79) + (i77 | i79);
                                int i81 = ~offsetAfter;
                                int i82 = ~(i81 | (-6));
                                int i83 = ~i;
                                int i84 = (~((i81 ^ i83) | (i81 & i83))) | i82;
                                int i85 = i78 | i;
                                int i86 = ~i85;
                                int i87 = ((i84 & i86) | (i84 ^ i86)) * (-502);
                                int i88 = (i80 ^ i87) + ((i87 & i80) << 1);
                                int i89 = (~offsetAfter) | (~i);
                                int i90 = ~((i89 & 5) | (i89 ^ 5));
                                int i91 = ~i85;
                                int i92 = ((i90 & i91) | (i90 ^ i91)) * TypedValues.PositionType.TYPE_DRAWPATH;
                                Object[] objArr15 = new Object[1];
                                c(((i88 | i92) << 1) - (i92 ^ i88), new char[]{64469, 30621, 20646, 5997, 28472, 4129}, objArr15);
                                byte[] bytes = string3.getBytes((String) objArr15[0]);
                                try {
                                    if (Build.VERSION.SDK_INT < 24) {
                                        try {
                                            Object[] objArr16 = {0, null, null};
                                            Object objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(1655552463);
                                            if (objAccessartificialFrame6 == null) {
                                                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getWindowTouchSlop() >> 8) + 42, (char) (19408 - ExpandableListView.getPackedPositionChild(0L)), 3807 - TextUtils.indexOf((CharSequence) "", '0'), -37158969, false, null, new Class[]{Integer.TYPE, Exception.class, List.class});
                                            }
                                            objNewInstance = ((Constructor) objAccessartificialFrame6).newInstance(objArr16);
                                            r26 = r12;
                                            r28 = r13;
                                        } catch (Throwable th5) {
                                            Throwable cause3 = th5.getCause();
                                            if (cause3 != null) {
                                                throw cause3;
                                            }
                                            throw th5;
                                        }
                                    } else {
                                        try {
                                            Object[] objArr17 = new Object[1];
                                            a(null, new int[]{20, 14, 183, 8}, true, objArr17);
                                            Date date = (Date) Class.forName((String) objArr17[0]).getDeclaredConstructor(null).newInstance(null);
                                            String string4 = UUID.randomUUID().toString();
                                            try {
                                                try {
                                                    int packedPositionChild2 = ExpandableListView.getPackedPositionChild(0L);
                                                    int iINotificationSideChannel2 = SqlDateTypeAdapter.AnonymousClass1.INotificationSideChannel();
                                                    int i93 = packedPositionChild2 * 595;
                                                    int i94 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                    int i95 = (i94 & 123) + (i94 | 123);
                                                    artificialFrame = i95 % 128;
                                                    if (i95 % 2 == 0) {
                                                        i33 = i93 >> 65535;
                                                        int i96 = ~packedPositionChild2;
                                                        i34 = (i96 & 16) | (i96 ^ 16);
                                                    } else {
                                                        i33 = i93 - 18992;
                                                        i34 = (~packedPositionChild2) | 16;
                                                    }
                                                    int i97 = ~i34;
                                                    int i98 = ~iINotificationSideChannel2;
                                                    int i99 = (-1188) * (i97 | (((i98 ^ 16) | (i98 & 16)) ^ (-1)));
                                                    int i100 = (i33 ^ i99) + ((i33 & i99) << 1);
                                                    int i101 = ~packedPositionChild2;
                                                    r13 = (-17) & iINotificationSideChannel2;
                                                    int i102 = (~((i101 & 16) | (i101 ^ 16))) | (~(((-17) ^ iINotificationSideChannel2) | r13));
                                                    int i103 = ~iINotificationSideChannel2;
                                                    int i104 = ~((i103 ^ packedPositionChild2) | (i103 & packedPositionChild2));
                                                    r12 = i102 ^ i104;
                                                    int i105 = (((i100 - (~((r12 | (i102 & i104)) * 594))) - 1) - (~(-(-((((~(((-17) ^ i103) | ((-17) & i103))) | (~(((-17) & packedPositionChild2) | ((-17) ^ packedPositionChild2)))) | (~((i103 & packedPositionChild2) | (i103 ^ packedPositionChild2)))) * 594))))) - 1;
                                                    try {
                                                        Object[] objArr18 = new Object[1];
                                                        c(i105, new char[]{36405, 4474, 39408, 9603, 19947, 34441, 33376, 45521, 51456, 41181, 57373, 652, 345, 3413, 41716, 19142}, objArr18);
                                                        KeyStore keyStore = null;
                                                        try {
                                                            try {
                                                                try {
                                                                    Object[] objArr19 = {(String) objArr18[0]};
                                                                    Object[] objArr20 = new Object[1];
                                                                    a(new byte[]{1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0}, new int[]{34, 22, 0, 15}, true, objArr20);
                                                                    KeyStore keyStore2 = (KeyStore) Class.forName((String) objArr20[0]).getMethod(str5, String.class).invoke(null, objArr19);
                                                                    try {
                                                                        Object[] objArr21 = new Object[1];
                                                                        a(new byte[]{1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0}, new int[]{34, 22, 0, 15}, true, objArr21);
                                                                        Class<?> cls5 = Class.forName((String) objArr21[0]);
                                                                        Object[] objArr22 = new Object[1];
                                                                        a(new byte[]{0, 0, 1, 0}, new int[]{56, 4, 0, 1}, false, objArr22);
                                                                        cls5.getMethod((String) objArr22[0], KeyStore.LoadStoreParameter.class).invoke(keyStore2, null);
                                                                        int i106 = getARTIFICIAL_FRAME_PACKAGE_NAME + 35;
                                                                        artificialFrame = i106 % 128;
                                                                        if (i106 % 2 == 0) {
                                                                            try {
                                                                                Object[] objArr23 = new Object[1];
                                                                                a(new byte[]{1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1}, new int[]{60, 18, 89, 0}, true, objArr23);
                                                                                cls4 = Class.forName((String) objArr23[0]);
                                                                            } catch (Throwable th6) {
                                                                                th3 = th6;
                                                                                cause = th3.getCause();
                                                                                if (cause != null) {
                                                                                    throw cause;
                                                                                }
                                                                                throw th3;
                                                                            }
                                                                        } else {
                                                                            try {
                                                                                Object[] objArr24 = new Object[1];
                                                                                a(new byte[]{1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1}, new int[]{60, 18, 89, 0}, true, objArr24);
                                                                                cls4 = Class.forName((String) objArr24[0]);
                                                                            } catch (Throwable th7) {
                                                                                th3 = th7;
                                                                                cause = th3.getCause();
                                                                                if (cause != null) {
                                                                                    throw cause;
                                                                                }
                                                                                throw th3;
                                                                            }
                                                                        }
                                                                        Object objInvoke3 = cls4.getMethod(str5, null).invoke(null, null);
                                                                        int i107 = artificialFrame + 21;
                                                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i107 % 128;
                                                                        int i108 = i107 % 2;
                                                                        try {
                                                                            Object[] objArr25 = {date};
                                                                            Object[] objArr26 = new Object[1];
                                                                            a(new byte[]{1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1}, new int[]{60, 18, 89, 0}, true, objArr26);
                                                                            Class<?> cls6 = Class.forName((String) objArr26[0]);
                                                                            r26 = r12;
                                                                            try {
                                                                                Object[] objArr27 = new Object[1];
                                                                                a(new byte[]{0, 0, 1, 0, 0, 0, 0}, new int[]{78, 7, 0, 4}, true, objArr27);
                                                                                String str7 = (String) objArr27[0];
                                                                                Class<?>[] clsArr = new Class[1];
                                                                                r28 = r13;
                                                                                try {
                                                                                    Object[] objArr28 = new Object[1];
                                                                                    a(null, new int[]{20, 14, 183, 8}, true, objArr28);
                                                                                    clsArr[0] = Class.forName((String) objArr28[0]);
                                                                                    cls6.getMethod(str7, clsArr).invoke(objInvoke3, objArr25);
                                                                                    try {
                                                                                        Object[] objArr29 = new Object[1];
                                                                                        a(new byte[]{1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1}, new int[]{60, 18, 89, 0}, true, objArr29);
                                                                                        Class<?> cls7 = Class.forName((String) objArr29[0]);
                                                                                        int i109 = -Color.rgb(0, 0, 0);
                                                                                        Object[] objArr30 = new Object[1];
                                                                                        c(((i109 | (-16777213)) << 1) - (i109 ^ (-16777213)), new char[]{3314, 19692, 24807, 42355}, objArr30);
                                                                                        cls7.getMethod((String) objArr30[0], Integer.TYPE, Integer.TYPE).invoke(objInvoke3, 11, 1);
                                                                                        try {
                                                                                            Object[] objArr31 = new Object[1];
                                                                                            a(new byte[]{1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1}, new int[]{60, 18, 89, 0}, true, objArr31);
                                                                                            Class<?> cls8 = Class.forName((String) objArr31[0]);
                                                                                            Object[] objArr32 = new Object[1];
                                                                                            a(new byte[]{1, 0, 0, 1, 0, 1, 0}, new int[]{85, 7, 0, 0}, true, objArr32);
                                                                                            Date date2 = (Date) cls8.getMethod((String) objArr32[0], null).invoke(objInvoke3, null);
                                                                                            KeyGenParameterSpec.Builder builder = new KeyGenParameterSpec.Builder(string4, 12);
                                                                                            Object[] objArr33 = new Object[1];
                                                                                            a(new byte[]{1, 0, 0, 1, 0, 1, 1, 0, 1}, new int[]{92, 9, SyslogConstants.LOG_LOCAL3, 0}, false, objArr33);
                                                                                            try {
                                                                                                Object[] objArr34 = {(String) objArr33[0]};
                                                                                                Object[] objArr35 = new Object[1];
                                                                                                a(new byte[]{1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1}, new int[]{101, 37, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, 0}, true, objArr35);
                                                                                                KeyGenParameterSpec.Builder algorithmParameterSpec = builder.setAlgorithmParameterSpec((AlgorithmParameterSpec) Class.forName((String) objArr35[0]).getDeclaredConstructor(String.class).newInstance(objArr34));
                                                                                                Object[] objArr36 = new Object[1];
                                                                                                a(new byte[]{1, 1, 1, 0, 1, 1, 1}, new int[]{138, 7, 0, 7}, false, objArr36);
                                                                                                KeyGenParameterSpec.Builder attestationChallenge = algorithmParameterSpec.setDigests((String) objArr36[0]).setKeyValidityStart(date).setKeyValidityEnd(date2).setAttestationChallenge(bytes);
                                                                                                try {
                                                                                                    Object[] objArr37 = new Object[1];
                                                                                                    a(new byte[]{0, 0}, new int[]{145, 2, 191, 0}, false, objArr37);
                                                                                                    String str8 = (String) objArr37[0];
                                                                                                    int i110 = -(-(CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)));
                                                                                                    Object[] objArr38 = new Object[1];
                                                                                                    c((i110 & 15) + (i110 | 15), new char[]{36405, 4474, 39408, 9603, 19947, 34441, 33376, 45521, 51456, 41181, 57373, 652, 345, 3413, 41716, 19142}, objArr38);
                                                                                                    try {
                                                                                                        Object[] objArr39 = {str8, (String) objArr38[0]};
                                                                                                        int i111 = -(ViewConfiguration.getScrollBarSize() >> 8);
                                                                                                        int iINotificationSideChannel3 = SqlDateTypeAdapter.AnonymousClass1.INotificationSideChannel();
                                                                                                        int i112 = ~i111;
                                                                                                        int i113 = ((i111 * (-159)) - 4770) + (((i112 & 30) | (i112 ^ 30)) * SyslogConstants.LOG_LOCAL4);
                                                                                                        int i114 = ~iINotificationSideChannel3;
                                                                                                        int i115 = ~((i114 & i111) | (i114 ^ i111));
                                                                                                        int i116 = ~(i111 | 30);
                                                                                                        int i117 = -(-(((i115 & i116) | (i115 ^ i116)) * (-160)));
                                                                                                        int i118 = ((i113 | i117) << 1) - (i113 ^ i117);
                                                                                                        int i119 = ~iINotificationSideChannel3;
                                                                                                        int i120 = (i111 | (~((i119 & (-31)) | ((-31) ^ i119)))) * SyslogConstants.LOG_LOCAL4;
                                                                                                        Object[] objArr40 = new Object[1];
                                                                                                        c((i118 ^ i120) + ((i120 & i118) << 1), new char[]{20794, 4322, 33636, 55455, 11143, 59227, 29278, 55764, 30482, 35605, 23247, 20961, 62390, 21178, 5177, 43895, 41558, 34496, 19698, 17019, 32155, 10013, 19934, 59436, 3831, 5048, 59984, 13011, 345, 3413}, objArr40);
                                                                                                        KeyPairGenerator keyPairGenerator = (KeyPairGenerator) Class.forName((String) objArr40[0]).getMethod(str5, String.class, String.class).invoke(null, objArr39);
                                                                                                        keyPairGenerator.initialize(attestationChallenge.build());
                                                                                                        keyPairGenerator.generateKeyPair();
                                                                                                        try {
                                                                                                            Object[] objArr41 = new Object[1];
                                                                                                            a(new byte[]{1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0}, new int[]{34, 22, 0, 15}, true, objArr41);
                                                                                                            Class<?> cls9 = Class.forName((String) objArr41[0]);
                                                                                                            Object[] objArr42 = new Object[1];
                                                                                                            a(null, new int[]{147, 19, 125, 17}, true, objArr42);
                                                                                                            Object[] objArr43 = (Object[]) cls9.getMethod((String) objArr42[0], String.class).invoke(keyStore2, string4);
                                                                                                            arrayList2 = new ArrayList();
                                                                                                            Object[] objArr44 = new Object[1];
                                                                                                            a(new byte[]{1, 1, 1, 1, 0}, new int[]{166, 5, 70, 3}, false, objArr44);
                                                                                                            try {
                                                                                                                Object[] objArr45 = {(String) objArr44[0]};
                                                                                                                Object[] objArr46 = new Object[1];
                                                                                                                c(KeyEvent.normalizeMetaState(0) + 37, new char[]{20794, 4322, 33636, 55455, 11143, 59227, 29278, 55764, 30482, 35605, 23247, 20961, 62390, 21178, 681, 61091, 41777, 4489, 46967, 15806, 3831, 5048, 55017, 17473, 56742, 35361, '/', 47841, 50502, 30485, 45490, 61815, 19536, 53388, 345, 3413, 25622, 56438}, objArr46);
                                                                                                                Object objInvoke4 = Class.forName((String) objArr46[0]).getMethod(str5, String.class).invoke(null, objArr45);
                                                                                                                int length6 = objArr43.length;
                                                                                                                int i121 = 0;
                                                                                                                while (i121 < length6) {
                                                                                                                    Object obj4 = objArr43[i121];
                                                                                                                    try {
                                                                                                                        Object[] objArr47 = objArr43;
                                                                                                                        Object[] objArr48 = new Object[1];
                                                                                                                        a(new byte[]{0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1}, new int[]{171, 30, 157, 18}, false, objArr48);
                                                                                                                        Class<?> cls10 = Class.forName((String) objArr48[0]);
                                                                                                                        int i122 = length6;
                                                                                                                        Object[] objArr49 = new Object[1];
                                                                                                                        a(new byte[]{1, 0, 1, 1, 1, 1, 0, 1, 1, 1}, new int[]{201, 10, 54, 0}, false, objArr49);
                                                                                                                        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream((byte[]) cls10.getMethod((String) objArr49[0], null).invoke(obj4, null));
                                                                                                                        try {
                                                                                                                            int i123 = -(-(Process.myPid() >> 22));
                                                                                                                            Object[] objArr50 = new Object[1];
                                                                                                                            c(((i123 | 37) << 1) - (i123 ^ 37), new char[]{20794, 4322, 33636, 55455, 11143, 59227, 29278, 55764, 30482, 35605, 23247, 20961, 62390, 21178, 681, 61091, 41777, 4489, 46967, 15806, 3831, 5048, 55017, 17473, 56742, 35361, '/', 47841, 50502, 30485, 45490, 61815, 19536, 53388, 345, 3413, 25622, 56438}, objArr50);
                                                                                                                            Class<?> cls11 = Class.forName((String) objArr50[0]);
                                                                                                                            Object[] objArr51 = new Object[1];
                                                                                                                            c(17 - (~(AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))), new char[]{53866, 34687, 47159, 33362, 26282, 50216, 50502, 30485, 21180, 5437, 41777, 4489, 50184, 4011, 19801, 22230, 59984, 13011, 41716, 19142}, objArr51);
                                                                                                                            arrayList2.add(cls11.getMethod((String) objArr51[0], InputStream.class).invoke(objInvoke4, byteArrayInputStream));
                                                                                                                            byteArrayInputStream.close();
                                                                                                                            int i124 = artificialFrame + 79;
                                                                                                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i124 % 128;
                                                                                                                            int i125 = i124 % 2;
                                                                                                                            i121++;
                                                                                                                            objArr43 = objArr47;
                                                                                                                            length6 = i122;
                                                                                                                        } catch (Throwable th8) {
                                                                                                                            Throwable cause4 = th8.getCause();
                                                                                                                            if (cause4 != null) {
                                                                                                                                throw cause4;
                                                                                                                            }
                                                                                                                            throw th8;
                                                                                                                        }
                                                                                                                    } catch (Throwable th9) {
                                                                                                                        Throwable cause5 = th9.getCause();
                                                                                                                        if (cause5 != null) {
                                                                                                                            throw cause5;
                                                                                                                        }
                                                                                                                        throw th9;
                                                                                                                    }
                                                                                                                }
                                                                                                                if (keyStore2 != null) {
                                                                                                                    int i126 = artificialFrame + 83;
                                                                                                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i126 % 128;
                                                                                                                    try {
                                                                                                                        if (i126 % 2 != 0) {
                                                                                                                            keyStore2.deleteEntry(string4);
                                                                                                                            int i127 = 63 / 0;
                                                                                                                        } else {
                                                                                                                            keyStore2.deleteEntry(string4);
                                                                                                                        }
                                                                                                                    } catch (KeyStoreException unused) {
                                                                                                                    }
                                                                                                                }
                                                                                                                i32 = 3;
                                                                                                                try {
                                                                                                                    Object[] objArr52 = new Object[i32];
                                                                                                                    objArr52[2] = arrayList2;
                                                                                                                    objArr52[1] = null;
                                                                                                                    objArr52[0] = 0;
                                                                                                                    objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(1655552463);
                                                                                                                    if (objAccessartificialFrame3 == null) {
                                                                                                                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(42 - (ViewConfiguration.getJumpTapTimeout() >> 16), (char) (19409 - (ViewConfiguration.getJumpTapTimeout() >> 16)), KeyEvent.normalizeMetaState(0) + 3808, -37158969, false, null, new Class[]{Integer.TYPE, Exception.class, List.class});
                                                                                                                    }
                                                                                                                    objNewInstance = ((Constructor) objAccessartificialFrame3).newInstance(objArr52);
                                                                                                                    r26 = r26;
                                                                                                                    r28 = r28;
                                                                                                                } catch (Throwable th10) {
                                                                                                                    Throwable cause6 = th10.getCause();
                                                                                                                    if (cause6 != null) {
                                                                                                                        throw cause6;
                                                                                                                    }
                                                                                                                    throw th10;
                                                                                                                }
                                                                                                            } catch (Throwable th11) {
                                                                                                                Throwable cause7 = th11.getCause();
                                                                                                                if (cause7 != null) {
                                                                                                                    throw cause7;
                                                                                                                }
                                                                                                                throw th11;
                                                                                                            }
                                                                                                        } catch (Throwable th12) {
                                                                                                            Throwable cause8 = th12.getCause();
                                                                                                            if (cause8 != null) {
                                                                                                                throw cause8;
                                                                                                            }
                                                                                                            throw th12;
                                                                                                        }
                                                                                                    } catch (Throwable th13) {
                                                                                                        Throwable cause9 = th13.getCause();
                                                                                                        if (cause9 != null) {
                                                                                                            throw cause9;
                                                                                                        }
                                                                                                        throw th13;
                                                                                                    }
                                                                                                } catch (Exception e) {
                                                                                                    throw e;
                                                                                                }
                                                                                            } catch (Throwable th14) {
                                                                                                Throwable cause10 = th14.getCause();
                                                                                                if (cause10 != null) {
                                                                                                    throw cause10;
                                                                                                }
                                                                                                throw th14;
                                                                                            }
                                                                                        } catch (Throwable th15) {
                                                                                            Throwable cause11 = th15.getCause();
                                                                                            if (cause11 != null) {
                                                                                                throw cause11;
                                                                                            }
                                                                                            throw th15;
                                                                                        }
                                                                                    } catch (Throwable th16) {
                                                                                        Throwable cause12 = th16.getCause();
                                                                                        if (cause12 != null) {
                                                                                            throw cause12;
                                                                                        }
                                                                                        throw th16;
                                                                                    }
                                                                                } catch (Throwable th17) {
                                                                                    th = th17;
                                                                                    th4 = th;
                                                                                    cause2 = th4.getCause();
                                                                                    if (cause2 != null) {
                                                                                        throw cause2;
                                                                                    }
                                                                                    throw th4;
                                                                                }
                                                                            } catch (Throwable th18) {
                                                                                th = th18;
                                                                                th4 = th;
                                                                                cause2 = th4.getCause();
                                                                                if (cause2 != null) {
                                                                                    throw cause2;
                                                                                }
                                                                                throw th4;
                                                                            }
                                                                        } catch (Throwable th19) {
                                                                            th = th19;
                                                                        }
                                                                    } catch (Throwable th20) {
                                                                        Throwable cause13 = th20.getCause();
                                                                        if (cause13 != null) {
                                                                            throw cause13;
                                                                        }
                                                                        throw th20;
                                                                    }
                                                                } catch (Throwable th21) {
                                                                    try {
                                                                        Throwable cause14 = th21.getCause();
                                                                        if (cause14 != null) {
                                                                            throw cause14;
                                                                        }
                                                                        throw th21;
                                                                    } catch (Exception unused2) {
                                                                        keyStore = null;
                                                                        if (keyStore != null) {
                                                                            try {
                                                                                keyStore.deleteEntry(string4);
                                                                            } catch (KeyStoreException unused3) {
                                                                            }
                                                                        }
                                                                        i32 = 3;
                                                                        arrayList2 = null;
                                                                        r26 = r12;
                                                                        r28 = r13;
                                                                        Object[] objArr53 = new Object[i32];
                                                                        objArr53[2] = arrayList2;
                                                                        objArr53[1] = null;
                                                                        objArr53[0] = 0;
                                                                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(1655552463);
                                                                        if (objAccessartificialFrame3 == null) {
                                                                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(42 - (ViewConfiguration.getJumpTapTimeout() >> 16), (char) (19409 - (ViewConfiguration.getJumpTapTimeout() >> 16)), KeyEvent.normalizeMetaState(0) + 3808, -37158969, false, null, new Class[]{Integer.TYPE, Exception.class, List.class});
                                                                        }
                                                                        objNewInstance = ((Constructor) objAccessartificialFrame3).newInstance(objArr53);
                                                                        r26 = r26;
                                                                        r28 = r28;
                                                                        objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1379818893);
                                                                        if (objAccessartificialFrame4 == null) {
                                                                            objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(41 - TextUtils.lastIndexOf("", '0', 0), (char) ((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 19409), 3808 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), -849667195, false, "onResult", new Class[0]);
                                                                        }
                                                                        list = (List) ((Method) objAccessartificialFrame4).invoke(objNewInstance, null);
                                                                        if (list == null) {
                                                                            listEmptyList = null;
                                                                            r211 = r26;
                                                                            r210 = r28;
                                                                            break;
                                                                        }
                                                                        listEmptyList = null;
                                                                        r211 = r26;
                                                                        r210 = r28;
                                                                        break;
                                                                        if (listEmptyList == null) {
                                                                            r211 = r26;
                                                                            r210 = r28;
                                                                            r211 = r26;
                                                                            r210 = r28;
                                                                            r5 = r211;
                                                                            strSubstring = null;
                                                                            r11 = r5;
                                                                        } else {
                                                                            r211 = r26;
                                                                            r210 = r28;
                                                                            r211 = r26;
                                                                            r210 = r28;
                                                                            r5 = r211;
                                                                            strSubstring = null;
                                                                            r11 = r5;
                                                                        }
                                                                        if (strSubstring == null) {
                                                                            r11 = r5;
                                                                            i4 = i;
                                                                            i28 = i4;
                                                                        } else {
                                                                            r11 = r5;
                                                                            i4 = i;
                                                                            i28 = (~(i4 & 5)) & (i4 | 5);
                                                                        }
                                                                        if (strSubstring == null) {
                                                                            r11 = r5;
                                                                            r11 = r5;
                                                                            i29 = 0;
                                                                        } else {
                                                                            r11 = r5;
                                                                            r11 = r5;
                                                                            i29 = 16;
                                                                        }
                                                                        objArr4 = new Object[]{new int[]{i28}, new String[]{strSubstring}, new int[1], new int[]{i4}};
                                                                        int startElapsedRealtime = (int) Process.getStartElapsedRealtime();
                                                                        int i128 = ~startElapsedRealtime;
                                                                        int i129 = (~((-966450716) | i128)) | 160612354;
                                                                        int i130 = ~(startElapsedRealtime | (-262629));
                                                                        int i131 = (-816627191) + ((i129 | i130) * (-502)) + ((i130 | (~(i128 | (-805838362)))) * TypedValues.PositionType.TYPE_DRAWPATH);
                                                                        int iINotificationSideChannel4 = SqlDateTypeAdapter.AnonymousClass1.INotificationSideChannel();
                                                                        int i132 = ((i29 * (-344)) - (~(-(-(i131 * (-344)))))) - 1;
                                                                        int i133 = ~i29;
                                                                        int i134 = ~i131;
                                                                        int i135 = ~(i133 | i134);
                                                                        int i136 = ~i29;
                                                                        int i137 = ~(i136 | iINotificationSideChannel4);
                                                                        int i138 = -(-(((i135 ^ i137) | (i137 & i135)) * 345));
                                                                        int i139 = (i132 ^ i138) + ((i132 & i138) << 1);
                                                                        int i140 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                                        int i141 = (i140 & 121) + (i140 | 121);
                                                                        r29 = r11;
                                                                        artificialFrame = i141 % 128;
                                                                        int i142 = i141 % 2;
                                                                        int i143 = ~iINotificationSideChannel4;
                                                                        int i144 = ~((i143 & i133) | (i133 ^ i143));
                                                                        int i145 = ~i131;
                                                                        int i146 = -(-(345 * ((~((i29 & i145) | (i145 ^ i29))) | i144)));
                                                                        int i147 = (i139 & i146) + (i146 | i139);
                                                                        int i148 = (i136 ^ i134) | (i136 & i134);
                                                                        int i149 = -(-((i147 - (~(-(-((~((i148 & iINotificationSideChannel4) | (i148 ^ iINotificationSideChannel4))) * 345))))) - 1));
                                                                        i30 = i3;
                                                                        int i150 = (i30 & i149) + (i149 | i30);
                                                                        int i151 = i150 << 13;
                                                                        int i152 = (i151 & (~i150)) | ((~i151) & i150);
                                                                        int i153 = i152 >>> 17;
                                                                        int i154 = (i152 | i153) & (~(i152 & i153));
                                                                        int i155 = i154 << 5;
                                                                        int i156 = (i154 | i155) & (~(i154 & i155));
                                                                        int i157 = (i140 ^ 21) + ((i140 & 21) << 1);
                                                                        artificialFrame = i157 % 128;
                                                                        int i158 = i157 % 2;
                                                                        ((int[]) objArr4[2])[0] = i156;
                                                                        objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(682069389);
                                                                        if (objAccessartificialFrame2 == null) {
                                                                            int packedPositionChild3 = 20 - ExpandableListView.getPackedPositionChild(0L);
                                                                            char maximumDrawingCacheSize = (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                                                                            int bitsPerPixel = 464 - ImageFormat.getBitsPerPixel(0);
                                                                            byte b4 = (byte) ($$a[11] + 1);
                                                                            byte b5 = b4;
                                                                            Object[] objArr54 = new Object[1];
                                                                            b(b4, b5, b5, objArr54);
                                                                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(packedPositionChild3, maximumDrawingCacheSize, bitsPerPixel, -1211970683, false, (String) objArr54[0], null);
                                                                        }
                                                                        ((Field) objAccessartificialFrame2).set(null, objArr4);
                                                                        if (i4 == i28) {
                                                                            c = 0;
                                                                            i6 = 1;
                                                                            Invoke = i30;
                                                                            r27 = r210;
                                                                            if (context == 0) {
                                                                                Object[] objArr55 = new Object[4];
                                                                                int[] iArr = new int[i6];
                                                                                objArr55[c] = iArr;
                                                                                int[] iArr2 = new int[i6];
                                                                                objArr55[2] = iArr2;
                                                                                int[] iArr3 = new int[i6];
                                                                                objArr55[3] = iArr3;
                                                                                iArr3[0] = i4;
                                                                                iArr[0] = i4;
                                                                                int i159 = ~i4;
                                                                                int i160 = (~((-93693465) | i159)) | 26279936;
                                                                                int i161 = ~(134069789 | i4);
                                                                                int i162 = (Invoke - (~((467975709 + ((i160 | i161) * (-502))) + (((~(i159 | (-67413529))) | i161) * TypedValues.PositionType.TYPE_DRAWPATH)))) - 1;
                                                                                int i163 = i162 << 13;
                                                                                int i164 = (i162 | i163) & (~(i162 & i163));
                                                                                int i165 = i164 ^ (i164 >>> 17);
                                                                                iArr2[0] = i165 ^ (i165 << 5);
                                                                                objArr55[1] = null;
                                                                                return objArr55;
                                                                            }
                                                                            r3 = r29;
                                                                            bArr = new byte[r3.length][];
                                                                            length = r3.length;
                                                                            i7 = 0;
                                                                            i8 = 0;
                                                                            while (i7 < length) {
                                                                                r10 = r3[i7];
                                                                                try {
                                                                                    int i166 = -(PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                                                                                    Object[] objArr56 = new Object[1];
                                                                                    c((i166 ^ 15) + ((i166 & 15) << 1), new char[]{20794, 4322, 33636, 55455, 18972, 17295, 63872, 20131, 32357, 8626, 48690, 6926, 56076, 31992, 23144, 34195}, objArr56);
                                                                                    cls3 = Class.forName((String) objArr56[0]);
                                                                                    int i167 = length;
                                                                                    objArr5 = new Object[1];
                                                                                    a(new byte[]{0, 0, 0, 1, 1, 0, 0, 1}, new int[]{307, 8, 187, 6}, true, objArr5);
                                                                                    if (((Integer) cls3.getMethod((String) objArr5[0], null).invoke(r10, null)).intValue() == 4) {
                                                                                        int i168 = artificialFrame;
                                                                                        int i169 = (i168 ^ 85) + ((i168 & 85) << 1);
                                                                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i169 % 128;
                                                                                        int i170 = i169 % 2;
                                                                                        z = true;
                                                                                    } else {
                                                                                        z = false;
                                                                                    }
                                                                                    if (!(!z)) {
                                                                                        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(32);
                                                                                        try {
                                                                                            Class<?> cls12 = Class.forName(r27);
                                                                                            Object[] objArr57 = new Object[1];
                                                                                            a(null, new int[]{290, 12, 140, 7}, true, objArr57);
                                                                                            longBuffer = (LongBuffer) cls12.getMethod((String) objArr57[0], null).invoke(byteBufferAllocate, null);
                                                                                            jArrArray = r10.array();
                                                                                            length3 = jArrArray.length;
                                                                                            for (i27 = 0; i27 < length3; i27 = ((i27 & 1) << 1) + (i27 ^ 1)) {
                                                                                                longBuffer.put(jArrArray[i27]);
                                                                                            }
                                                                                            bArr[i8] = byteBufferAllocate.array();
                                                                                            i8++;
                                                                                        } catch (Throwable th22) {
                                                                                            Throwable cause15 = th22.getCause();
                                                                                            if (cause15 != null) {
                                                                                                throw cause15;
                                                                                            }
                                                                                            throw th22;
                                                                                        }
                                                                                    }
                                                                                    i7++;
                                                                                    length = i167;
                                                                                } catch (Throwable th23) {
                                                                                    Throwable cause16 = th23.getCause();
                                                                                    if (cause16 != null) {
                                                                                        throw cause16;
                                                                                    }
                                                                                    throw th23;
                                                                                }
                                                                            }
                                                                            try {
                                                                                if (i8 > 0) {
                                                                                    strArr3 = new String[1][];
                                                                                    int iCurrentTimeMillis = (int) System.currentTimeMillis();
                                                                                    int i171 = (iCurrentTimeMillis | 343337308) & (~(iCurrentTimeMillis & 343337308));
                                                                                    try {
                                                                                        Object[] objArr58 = {Integer.valueOf((~(i4 & i171)) & (i4 | i171)), bArr, Integer.valueOf(i8), Integer.valueOf(i2), strArr3};
                                                                                        objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1514071993);
                                                                                        if (objAccessartificialFrame == null) {
                                                                                            try {
                                                                                                int iIndexOf = TextUtils.indexOf("", "", 0, 0) + 21;
                                                                                                char cIndexOf = (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0));
                                                                                                int bitsPerPixel2 = 464 - ImageFormat.getBitsPerPixel(0);
                                                                                                byte b6 = $$a[11];
                                                                                                byte b7 = b6;
                                                                                                Object[] objArr59 = new Object[1];
                                                                                                b(b6, b7, b7, objArr59);
                                                                                                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(iIndexOf, cIndexOf, bitsPerPixel2, 983850575, false, (String) objArr59[0], new Class[]{Integer.TYPE, byte[][].class, Integer.TYPE, Integer.TYPE, String[][].class});
                                                                                            } catch (Throwable th24) {
                                                                                                th = th24;
                                                                                                Throwable cause17 = th.getCause();
                                                                                                if (cause17 != null) {
                                                                                                    throw cause17;
                                                                                                }
                                                                                                throw th;
                                                                                            }
                                                                                        }
                                                                                        long jLongValue3 = ((Long) ((Method) objAccessartificialFrame).invoke(null, objArr58)).longValue();
                                                                                        long j = -553755991;
                                                                                        long j2 = 193;
                                                                                        long j3 = i4;
                                                                                        str = "";
                                                                                        long j4 = -1;
                                                                                        long j5 = j3 ^ j4;
                                                                                        long j6 = j ^ j4;
                                                                                        long j7 = (j2 * j) + (j2 * jLongValue3) + (((long) (-192)) * (j5 | ((j6 | jLongValue3) ^ j4)));
                                                                                        long j8 = jLongValue3 ^ j4;
                                                                                        long j9 = j6 | j8;
                                                                                        long j10 = j8 | j5;
                                                                                        long j11 = j7 + (((long) (-384)) * ((j9 ^ j4) | (j10 ^ j4))) + (((long) JfifUtil.MARKER_SOFn) * (((j9 | j3) ^ j4) | ((j10 | j) ^ j4) | (((jLongValue3 | j) | j3) ^ j4))) + ((long) (-1408458699));
                                                                                        i23 = ~i4;
                                                                                        int i172 = ~((-1633642444) | i23);
                                                                                        int i173 = ~(196416032 | i4);
                                                                                        int i174 = ((int) (j11 >> 32)) & ((-334238508) + ((i172 | i173) * 1150) + (((~((-196416033) | i23)) | i173) * (-575)) + (((~((-1633642444) | i4)) | (~(1633642443 | i23))) * 575));
                                                                                        int i175 = (int) j11;
                                                                                        try {
                                                                                            int iElapsedRealtime = (int) SystemClock.elapsedRealtime();
                                                                                            int i176 = ~iElapsedRealtime;
                                                                                            int i177 = (-1880002655) + (((~((-1869509451) | i176)) | 155455744) * (-1188));
                                                                                            int i178 = (~(iElapsedRealtime | 1869509450)) | 155455744;
                                                                                            int i179 = ~(432283040 | i176);
                                                                                            int i180 = i175 & (i177 + ((i178 | i179) * 594) + (((~(1869509450 | i176)) | (-2146336747) | i179) * 594));
                                                                                            i24 = ((i180 & i174) | (i174 ^ i180)) ^ i171;
                                                                                            if ((i2 & 1) != 1) {
                                                                                            }
                                                                                            i25 = i3;
                                                                                            i26 = (i24 & i23) | ((~i24) & i4);
                                                                                            if (i26 == 17) {
                                                                                                Object[] objArr60 = {new int[]{i24}, strArr3[0], new int[1], new int[]{i4}};
                                                                                                int iNextInt = new Random().nextInt(1371143253);
                                                                                                int i181 = ~iNextInt;
                                                                                                int i182 = (-1213847242) + (((~(608852493 | i181)) | 769202219) * (-90)) + (((~(608852493 | iNextInt)) | 147972) * (-45)) + (((~(iNextInt | (-769202220))) | 608852493 | (~(i181 | 769202219))) * 45) + 16;
                                                                                                int i183 = ((i25 == true ? 1 : 0) ^ i182) + (((i25 == true ? 1 : 0) & i182) << 1);
                                                                                                int i184 = i183 << 13;
                                                                                                int i185 = (i183 | i184) & (~(i183 & i184));
                                                                                                int i186 = i185 >>> 17;
                                                                                                int i187 = ((~i185) & i186) | ((~i186) & i185);
                                                                                                ((int[]) objArr60[2])[0] = i187 ^ (i187 << 5);
                                                                                                return objArr60;
                                                                                            }
                                                                                            if (((~(i24 & i4)) & (i24 | i4)) == 0) {
                                                                                                Object[] objArr61 = {new int[]{i24}, null, new int[]{(i | i) & (~(i & i))}, new int[]{i4}};
                                                                                                int i188 = ((((~(i4 | 59521427)) | 100828298) * 56) - 1718705691) + ((59521427 | (~(100828298 | i23))) * 56);
                                                                                                int i189 = i188 * 370;
                                                                                                int i190 = ((i188 ^ i23) | (i23 & i188)) * (-369);
                                                                                                int i191 = (i189 ^ i190) + ((i189 & i190) << 1);
                                                                                                int i192 = ~i4;
                                                                                                int i193 = ~(i192 | ((-1) ^ i192));
                                                                                                int i194 = i191 + (((i193 & i188) | (i188 ^ i193)) * (-369));
                                                                                                int i195 = ~(~i188);
                                                                                                int i196 = ~i4;
                                                                                                int i197 = (i195 & i196) | (i195 ^ i196);
                                                                                                int i198 = ~(i188 | ((-1) ^ i188));
                                                                                                int i199 = ((i197 & i198) | (i197 ^ i198)) * 369;
                                                                                                int i200 = (i194 ^ i199) + ((i199 & i194) << 1);
                                                                                                int i201 = (((i25 == true ? 1 : 0) | i200) << 1) - (i200 ^ (i25 == true ? 1 : 0));
                                                                                                int i202 = i201 << 13;
                                                                                                int i203 = ((~i201) & i202) | ((~i202) & i201);
                                                                                                int i204 = i203 >>> 17;
                                                                                                int i205 = ((~i203) & i204) | ((~i204) & i203);
                                                                                                int i206 = i205 << 5;
                                                                                                return objArr61;
                                                                                            }
                                                                                            if (i26 == 11) {
                                                                                                Invoke = i26;
                                                                                                r6 = i25;
                                                                                                objArr4 = new Object[]{new int[]{i24}, strArr3[0], new int[]{i ^ (i << 5)}, new int[]{i4}};
                                                                                                int i207 = ((i25 == true ? 1 : 0) - (~(((729202488 + (((~((-167779871) | i4)) | (~((-7430145) | i4))) * 69)) + ((((~((-1049108479) | i4)) | 881328608) | (~((-888758753) | i4))) * (-69))) + 113279061))) - 1;
                                                                                                int i208 = i207 ^ (i207 << 13);
                                                                                                int i209 = i208 ^ (i208 >>> 17);
                                                                                            }
                                                                                        } catch (Throwable unused4) {
                                                                                            Invoke = i3;
                                                                                            int i210 = ~i4;
                                                                                            objArr = new Object[]{new int[]{(i4 & (-3)) | (i210 & 2)}, null, new int[]{((~i) & i) | ((~i) & i)}, new int[]{i4}};
                                                                                            int i211 = 1535794187 + ((i4 | 222778326) * (-50)) + (((~(i4 | (-205996615))) | (~(268425214 | i210))) * 50) + (((~(222778326 | i210)) | (~(62428600 | i210)) | (-268425215)) * 50);
                                                                                            ?? r1 = (i211 ^ 16) + ((16 & i211) << 1) + Invoke;
                                                                                            int i212 = r1 << 13;
                                                                                            int i213 = ((~r1) & i212) | ((~i212) & r1);
                                                                                            int i214 = i213 ^ (i213 >>> 17);
                                                                                            int i215 = i214 << 5;
                                                                                            return objArr;
                                                                                        }
                                                                                    } catch (Throwable th25) {
                                                                                        th = th25;
                                                                                    }
                                                                                } else {
                                                                                    r6 = Invoke;
                                                                                    str = "";
                                                                                    Invoke = Invoke;
                                                                                }
                                                                                Invoke = i26;
                                                                                r6 = i25;
                                                                                try {
                                                                                    int i216 = -Color.blue(0);
                                                                                    Object[] objArr62 = new Object[1];
                                                                                    c((i216 & 23) + (i216 | 23), new char[]{37254, 28566, 39408, 9603, 19947, 34441, 40540, 33064, 3405, 52960, 3224, 8817, 19934, 59436, 43728, 50638, 38455, 41647, 3224, 8817, 42949, 16154, 5394, 44112}, objArr62);
                                                                                    Class<?> cls13 = Class.forName((String) objArr62[0]);
                                                                                    int i217 = -View.MeasureSpec.makeMeasureSpec(0, 0);
                                                                                    int i218 = (i217 * (-711)) + 12121;
                                                                                    int i219 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                                                    int i220 = ((i219 | 7) << 1) - (i219 ^ 7);
                                                                                    artificialFrame = i220 % 128;
                                                                                    int i221 = i220 % 2;
                                                                                    int i222 = ~(((-18) ^ i217) | ((-18) & i217));
                                                                                    i9 = ~i4;
                                                                                    int i223 = ~((i9 ^ i217) | (i9 & i217));
                                                                                    int i224 = (-712) * ((i222 & i223) | (i222 ^ i223));
                                                                                    int i225 = (i218 ^ i224) + ((i218 & i224) << 1);
                                                                                    i10 = ~i4;
                                                                                    int i226 = ((-18) & i10) | ((-18) ^ i10);
                                                                                    int i227 = ~((i226 & i217) | (i226 ^ i217));
                                                                                    int i228 = ~((i217 ^ 17) | (i217 & 17) | i4);
                                                                                    int i229 = (i225 - (~(((i227 & i228) | (i227 ^ i228)) * (-712)))) - 1;
                                                                                    int i230 = ~((i217 & i10) | (i10 ^ i217));
                                                                                    Object[] objArr63 = new Object[1];
                                                                                    c((i229 - (~(((i230 & (-18)) | ((-18) ^ i230)) * 712))) - 1, new char[]{53866, 34687, 55204, 17900, 1308, 17685, 46884, 6988, 53866, 34687, 21752, 41224, 18764, 26637, 53866, 34687, 23144, 34195}, objArr63);
                                                                                    Invoke = cls13.getMethod((String) objArr63[0], null).invoke(context, null);
                                                                                    try {
                                                                                        int i231 = -(ViewConfiguration.getMinimumFlingVelocity() >> 16);
                                                                                        int i232 = i231 * 319;
                                                                                        int i233 = (i232 ^ (-7291)) + ((i232 & (-7291)) << 1);
                                                                                        int i234 = ~i231;
                                                                                        int i235 = i233 + (((~((i234 & i4) | (i234 ^ i4))) | (-24)) * (-318));
                                                                                        int i236 = ~((-24) | i4);
                                                                                        int i237 = ~((i9 ^ i231) | (i9 & i231) | 23);
                                                                                        int i238 = i235 + (((i236 & i237) | (i236 ^ i237)) * TypedValues.AttributesType.TYPE_PIVOT_TARGET);
                                                                                        int i239 = ((-24) & i9) | ((-24) ^ i9);
                                                                                        int i240 = ~((i239 & i231) | (i239 ^ i231));
                                                                                        int i241 = (i231 & 23) | (i231 ^ 23);
                                                                                        int i242 = ~((i241 & i4) | (i241 ^ i4));
                                                                                        int i243 = ((i242 & i240) | (i240 ^ i242)) * TypedValues.AttributesType.TYPE_PIVOT_TARGET;
                                                                                        Object[] objArr64 = new Object[1];
                                                                                        c((i238 ^ i243) + ((i243 & i238) << 1), new char[]{37254, 28566, 39408, 9603, 19947, 34441, 40540, 33064, 3405, 52960, 3224, 8817, 19934, 59436, 43728, 50638, 38455, 41647, 3224, 8817, 42949, 16154, 5394, 44112}, objArr64);
                                                                                        Class<?> cls14 = Class.forName((String) objArr64[0]);
                                                                                        Object[] objArr65 = new Object[1];
                                                                                        a(new byte[]{1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1}, new int[]{315, 14, 0, 3}, false, objArr65);
                                                                                        try {
                                                                                            Object[] objArr66 = {cls14.getMethod((String) objArr65[0], null).invoke(context, null), 64};
                                                                                            Object[] objArr67 = new Object[1];
                                                                                            a(new byte[]{1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0}, new int[]{329, 33, 93, 17}, false, objArr67);
                                                                                            Class<?> cls15 = Class.forName((String) objArr67[0]);
                                                                                            Object[] objArr68 = new Object[1];
                                                                                            a(new byte[]{0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1}, new int[]{362, 14, 163, 0}, false, objArr68);
                                                                                            objInvoke = cls15.getMethod((String) objArr68[0], String.class, Integer.TYPE).invoke(Invoke, objArr66);
                                                                                            linkedHashSet = new LinkedHashSet();
                                                                                            int length7 = r3.length;
                                                                                            i11 = 0;
                                                                                            r4 = r3;
                                                                                            Invoke = length7;
                                                                                            r7 = r6;
                                                                                            while (i11 < Invoke) {
                                                                                                r9 = r4[i11];
                                                                                                try {
                                                                                                    Object[] objArr69 = new Object[1];
                                                                                                    c((ViewConfiguration.getTapTimeout() >> 16) + 15, new char[]{20794, 4322, 33636, 55455, 18972, 17295, 63872, 20131, 32357, 8626, 48690, 6926, 56076, 31992, 23144, 34195}, objArr69);
                                                                                                    cls = Class.forName((String) objArr69[0]);
                                                                                                    ?? r212 = r4;
                                                                                                    objArr2 = new Object[1];
                                                                                                    a(new byte[]{0, 0, 0, 1, 1, 0, 0, 1}, new int[]{307, 8, 187, 6}, true, objArr2);
                                                                                                    if (((Integer) cls.getMethod((String) objArr2[0], null).invoke(r9, null)).intValue() == 4) {
                                                                                                        Object[] objArr70 = new Object[1];
                                                                                                        a(new byte[]{1, 1, 1, 0, 1, 1, 1}, new int[]{138, 7, 0, 7}, false, objArr70);
                                                                                                        str2 = (String) objArr70[0];
                                                                                                    } else {
                                                                                                        int i244 = -(KeyEvent.getMaxKeyCode() >> 16);
                                                                                                        int iINotificationSideChannel5 = SqlDateTypeAdapter.AnonymousClass1.INotificationSideChannel();
                                                                                                        int i245 = ~i244;
                                                                                                        int i246 = ~iINotificationSideChannel5;
                                                                                                        int i247 = ~((i245 ^ i246) | (i246 & i245));
                                                                                                        int i248 = (i245 ^ 3) | (i245 & 3);
                                                                                                        int i249 = ~i248;
                                                                                                        int i250 = (i247 ^ i249) | (i249 & i247);
                                                                                                        int i251 = ~((~iINotificationSideChannel5) | 3);
                                                                                                        int i252 = (((i244 * 398) - 1188) - (~(((i250 ^ i251) | (i250 & i251)) * (-397)))) - 1;
                                                                                                        int i253 = (~i248) * (-397);
                                                                                                        int i254 = (i252 & i253) + (i253 | i252);
                                                                                                        int i255 = ~((i245 ^ 3) | (i245 & 3));
                                                                                                        int i256 = (i255 & iINotificationSideChannel5) | (iINotificationSideChannel5 ^ i255);
                                                                                                        int i257 = ~((i244 & (-4)) | ((-4) ^ i244));
                                                                                                        int i258 = i256 ^ i257;
                                                                                                        Object[] objArr71 = new Object[1];
                                                                                                        c((i254 - (~(-(-(((i257 & i256) | i258) * 397))))) - 1, new char[]{29921, 63486, 64688, 55477}, objArr71);
                                                                                                        str2 = (String) objArr71[0];
                                                                                                    }
                                                                                                    Object[] objArr72 = new Object[1];
                                                                                                    a(new byte[]{1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1}, new int[]{376, 30, 0, 0}, false, objArr72);
                                                                                                    Class<?> cls16 = Class.forName((String) objArr72[0]);
                                                                                                    int i259 = -View.MeasureSpec.getSize(0);
                                                                                                    int iINotificationSideChannel6 = SqlDateTypeAdapter.AnonymousClass1.INotificationSideChannel();
                                                                                                    int i260 = i259 * 866;
                                                                                                    int i261 = ((i260 | (-8640)) << 1) - (i260 ^ (-8640));
                                                                                                    int i262 = artificialFrame;
                                                                                                    int i263 = (i262 ^ 49) + ((i262 & 49) << 1);
                                                                                                    int i264 = i263 % 128;
                                                                                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i264;
                                                                                                    int i265 = i263 % 2;
                                                                                                    int i266 = i11;
                                                                                                    int i267 = ~((~iINotificationSideChannel6) | (~i259));
                                                                                                    int i268 = (-865) * (((-11) ^ i267) | (i267 & (-11)));
                                                                                                    int i269 = (i261 & i268) + (i261 | i268);
                                                                                                    int i270 = (~((i259 ^ iINotificationSideChannel6) | (i259 & iINotificationSideChannel6))) * 865;
                                                                                                    int i271 = (i269 & i270) + (i269 | i270);
                                                                                                    int i272 = ~iINotificationSideChannel6;
                                                                                                    int i273 = ~(((-11) ^ i272) | ((-11) & i272));
                                                                                                    int i274 = ~((i272 & i259) | (i272 ^ i259));
                                                                                                    int i275 = -(-(((i274 & i273) | (i273 ^ i274)) * 865));
                                                                                                    int i276 = (i271 ^ i275) + ((i271 & i275) << 1);
                                                                                                    int i277 = ((i264 | 5) << 1) - (i264 ^ 5);
                                                                                                    artificialFrame = i277 % 128;
                                                                                                    int i278 = i277 % 2;
                                                                                                    Object[] objArr73 = new Object[1];
                                                                                                    c(i276, new char[]{18119, 44752, 14387, 11769, 59984, 13011, 30482, 35605, 21275, 48028}, objArr73);
                                                                                                    Object[] objArr74 = (Object[]) cls16.getField((String) objArr73[0]).get(objInvoke);
                                                                                                    length2 = objArr74.length;
                                                                                                    i14 = 0;
                                                                                                    Invoke = objArr74;
                                                                                                    r8 = r7;
                                                                                                    while (i14 < length2) {
                                                                                                        ?? r14 = Invoke[i14];
                                                                                                        try {
                                                                                                            Object[] objArr75 = {str2};
                                                                                                            int deadChar = KeyEvent.getDeadChar(0, 0);
                                                                                                            int i279 = deadChar * (-743);
                                                                                                            obj2 = objInvoke;
                                                                                                            int i280 = ((i279 | (-20061)) << 1) - (i279 ^ (-20061));
                                                                                                            int i281 = (deadChar ^ 27) | (deadChar & 27);
                                                                                                            str3 = str2;
                                                                                                            r46 = Invoke;
                                                                                                            int i282 = (~i281) | (~((deadChar ^ i4) | (deadChar & i4)));
                                                                                                            int i283 = ~((i4 ^ 27) | (i4 & 27));
                                                                                                            int i284 = ((i282 ^ i283) | (i282 & i283)) * (-744);
                                                                                                            int i285 = (i280 & i284) + (i280 | i284);
                                                                                                            int i286 = ~deadChar;
                                                                                                            int i287 = ~((i286 & (-28)) | (i286 ^ (-28)));
                                                                                                            int i288 = ((i287 & i9) | (i9 ^ i287)) * 744;
                                                                                                            Object[] objArr76 = new Object[1];
                                                                                                            c((((i285 & i288) + (i288 | i285)) - (~(-(-(((i281 ^ i4) | (i281 & i4)) * 744))))) - 1, new char[]{20794, 4322, 33636, 55455, 11143, 59227, 29278, 55764, 30482, 35605, 23247, 20961, 62390, 21178, 38011, 56431, 30316, 50537, 41530, 38433, 'T', 5334, 18542, 5203, 21275, 48028, 5394, 44112}, objArr76);
                                                                                                            String str9 = str5;
                                                                                                            Invoke = 0;
                                                                                                            Object objInvoke5 = Class.forName((String) objArr76[0]).getMethod(str9, String.class).invoke(null, objArr75);
                                                                                                            Invoke = 28;
                                                                                                            try {
                                                                                                                str5 = str9;
                                                                                                                Object[] objArr77 = new Object[1];
                                                                                                                a(new byte[]{0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0}, new int[]{406, 28, 0, 27}, false, objArr77);
                                                                                                                Class<?> cls17 = Class.forName((String) objArr77[0]);
                                                                                                                i15 = length2;
                                                                                                                Object[] objArr78 = new Object[1];
                                                                                                                a(new byte[]{0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0}, new int[]{434, 11, 102, 0}, false, objArr78);
                                                                                                                Invoke = (String) objArr78[0];
                                                                                                                Object objInvoke6 = cls17.getMethod(Invoke, null).invoke(r14, null);
                                                                                                                int i289 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                                                                                int i290 = (i289 ^ 57) + ((i289 & 57) << 1);
                                                                                                                artificialFrame = i290 % 128;
                                                                                                                int i291 = i290 % 2;
                                                                                                                try {
                                                                                                                    Object[] objArr79 = {objInvoke6};
                                                                                                                    int i292 = -(-(ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)));
                                                                                                                    Object[] objArr80 = new Object[1];
                                                                                                                    c((i292 ^ 26) + ((i292 & 26) << 1), new char[]{20794, 4322, 33636, 55455, 11143, 59227, 29278, 55764, 30482, 35605, 23247, 20961, 62390, 21178, 38011, 56431, 30316, 50537, 41530, 38433, 'T', 5334, 18542, 5203, 21275, 48028, 5394, 44112}, objArr80);
                                                                                                                    Class<?> cls18 = Class.forName((String) objArr80[0]);
                                                                                                                    int i293 = -View.MeasureSpec.makeMeasureSpec(0, 0);
                                                                                                                    int iINotificationSideChannel7 = SqlDateTypeAdapter.AnonymousClass1.INotificationSideChannel();
                                                                                                                    int i294 = i293 * (-919);
                                                                                                                    int i295 = ((i294 | (-5514)) << 1) - (i294 ^ (-5514));
                                                                                                                    int i296 = ~i293;
                                                                                                                    int i297 = (i296 ^ (-7)) | (i296 & (-7));
                                                                                                                    int i298 = ~((i297 ^ iINotificationSideChannel7) | (i297 & iINotificationSideChannel7));
                                                                                                                    i16 = i9;
                                                                                                                    int i299 = ~iINotificationSideChannel7;
                                                                                                                    int i300 = (-7) | i299;
                                                                                                                    i17 = i14;
                                                                                                                    int i301 = ~((i300 ^ i293) | (i300 & i293));
                                                                                                                    int i302 = ((i298 ^ i301) | (i301 & i298)) * 920;
                                                                                                                    int i303 = ((i295 | i302) << 1) - (i302 ^ i295);
                                                                                                                    int i304 = ~i293;
                                                                                                                    int i305 = ~((i304 ^ (-7)) | (i304 & (-7)));
                                                                                                                    int i306 = ~iINotificationSideChannel7;
                                                                                                                    int i307 = -(-(((~((i304 ^ i306) | (i306 & i304))) | i305) * 920));
                                                                                                                    int i308 = (i303 ^ i307) + ((i307 & i303) << 1);
                                                                                                                    int i309 = (i304 ^ (-7)) | (i304 & (-7));
                                                                                                                    int i310 = ~((i309 & i299) | (i309 ^ i299));
                                                                                                                    int i311 = (i296 ^ 6) | (i296 & 6);
                                                                                                                    int i312 = ~((i311 & iINotificationSideChannel7) | (i311 ^ iINotificationSideChannel7));
                                                                                                                    int i313 = (i310 & i312) | (i310 ^ i312);
                                                                                                                    int i314 = (-7) | i293;
                                                                                                                    int i315 = ~((i314 & iINotificationSideChannel7) | (i314 ^ iINotificationSideChannel7));
                                                                                                                    try {
                                                                                                                        Object[] objArr81 = new Object[1];
                                                                                                                        c(i308 + (((i315 & i313) | (i313 ^ i315)) * 920), new char[]{53560, 53417, 53866, 34687, 14879, 640}, objArr81);
                                                                                                                        Invoke = cls18.getMethod((String) objArr81[0], byte[].class);
                                                                                                                        try {
                                                                                                                            Object[] objArr82 = {Invoke.invoke(objInvoke5, objArr79)};
                                                                                                                            Class<?> cls19 = Class.forName(r27);
                                                                                                                            Object[] objArr83 = new Object[1];
                                                                                                                            a(new byte[]{0, 1, 1, 1}, new int[]{286, 4, 131, 3}, true, objArr83);
                                                                                                                            Invoke = 0;
                                                                                                                            Invoke = 0;
                                                                                                                            Invoke = 0;
                                                                                                                            Object objInvoke7 = cls19.getMethod((String) objArr83[0], byte[].class).invoke(null, objArr82);
                                                                                                                            try {
                                                                                                                                Class<?> cls20 = Class.forName(r27);
                                                                                                                                Object[] objArr84 = new Object[1];
                                                                                                                                a(null, new int[]{290, 12, 140, 7}, true, objArr84);
                                                                                                                                i18 = 0;
                                                                                                                                objInvoke2 = cls20.getMethod((String) objArr84[0], null).invoke(objInvoke7, null);
                                                                                                                                if (objInvoke2 != null) {
                                                                                                                                    i22 = 0;
                                                                                                                                    string = str;
                                                                                                                                    str4 = string;
                                                                                                                                    while (true) {
                                                                                                                                        try {
                                                                                                                                            int i316 = -TextUtils.getOffsetAfter(str4, i18);
                                                                                                                                            Object[] objArr85 = new Object[1];
                                                                                                                                            c((i316 & 15) + (i316 | 15), new char[]{20794, 4322, 33636, 55455, 18972, 17295, 63872, 20131, 32357, 8626, 48690, 6926, 56076, 31992, 23144, 34195}, objArr85);
                                                                                                                                            cls2 = Class.forName((String) objArr85[0]);
                                                                                                                                            objArr3 = new Object[1];
                                                                                                                                            a(new byte[]{0, 1, 0, 0, 1}, new int[]{302, 5, 4, 0}, false, objArr3);
                                                                                                                                            if (i22 >= ((Integer) cls2.getMethod((String) objArr3[0], null).invoke(objInvoke2, null)).intValue()) {
                                                                                                                                                break;
                                                                                                                                            }
                                                                                                                                            StringBuilder sb = new StringBuilder();
                                                                                                                                            sb.append(string);
                                                                                                                                            try {
                                                                                                                                                Object[] objArr86 = {Integer.valueOf(i22)};
                                                                                                                                                Object[] objArr87 = new Object[1];
                                                                                                                                                a(new byte[]{0, 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1}, new int[]{0, 19, SyslogConstants.LOG_LOCAL7, 10}, true, objArr87);
                                                                                                                                                Class<?> cls21 = Class.forName((String) objArr87[0]);
                                                                                                                                                int i317 = -(-KeyEvent.normalizeMetaState(0));
                                                                                                                                                Object[] objArr88 = new Object[1];
                                                                                                                                                c(((i317 | 3) << 1) - (i317 ^ 3), new char[]{53866, 34687, 5394, 44112}, objArr88);
                                                                                                                                                try {
                                                                                                                                                    Object[] objArr89 = {Long.valueOf(((Long) cls21.getMethod((String) objArr88[0], Integer.TYPE).invoke(objInvoke2, objArr86)).longValue())};
                                                                                                                                                    Object[] objArr90 = new Object[1];
                                                                                                                                                    c(13 - (~(-Drawable.resolveOpacity(0, 0))), new char[]{20794, 4322, 33636, 55455, 41565, 27421, 37254, 28566, 34439, 38407, 43287, 26265, 18855, 10826}, objArr90);
                                                                                                                                                    Class<?> cls22 = Class.forName((String) objArr90[0]);
                                                                                                                                                    int jumpTapTimeout = ViewConfiguration.getJumpTapTimeout() >> 16;
                                                                                                                                                    int iINotificationSideChannel8 = SqlDateTypeAdapter.AnonymousClass1.INotificationSideChannel();
                                                                                                                                                    int i318 = jumpTapTimeout * 934;
                                                                                                                                                    int i319 = ((i318 | (-10252)) << 1) - (i318 ^ (-10252));
                                                                                                                                                    int i320 = ~jumpTapTimeout;
                                                                                                                                                    int i321 = ~iINotificationSideChannel8;
                                                                                                                                                    int i322 = ~((i320 ^ i321) | (i321 & i320));
                                                                                                                                                    int i323 = (i319 - (~((((-12) ^ i322) | (i322 & (-12))) * (-933)))) - 1;
                                                                                                                                                    int i324 = ~iINotificationSideChannel8;
                                                                                                                                                    int i325 = ~(((-12) ^ i324) | (i324 & (-12)));
                                                                                                                                                    int i326 = ~((-12) | jumpTapTimeout);
                                                                                                                                                    int i327 = i323 + (((i325 & i326) | (i325 ^ i326)) * 933);
                                                                                                                                                    int i328 = (~((jumpTapTimeout & 11) | (jumpTapTimeout ^ 11))) * 933;
                                                                                                                                                    Object[] objArr91 = new Object[1];
                                                                                                                                                    c((i327 & i328) + (i327 | i328), new char[]{56090, 24477, Typography.notEqual, 31812, 38990, 40251, 31280, 48988, 64830, 55973, 3405, 65022}, objArr91);
                                                                                                                                                    sb.append((String) cls22.getMethod((String) objArr91[0], Long.TYPE).invoke(null, objArr89));
                                                                                                                                                    string = sb.toString();
                                                                                                                                                    i22 = ((i22 | 1) << 1) - (i22 ^ 1);
                                                                                                                                                    i18 = 0;
                                                                                                                                                } catch (Throwable th26) {
                                                                                                                                                    Throwable cause18 = th26.getCause();
                                                                                                                                                    if (cause18 != null) {
                                                                                                                                                        throw cause18;
                                                                                                                                                    }
                                                                                                                                                    throw th26;
                                                                                                                                                }
                                                                                                                                            } catch (Throwable th27) {
                                                                                                                                                Throwable cause19 = th27.getCause();
                                                                                                                                                if (cause19 != null) {
                                                                                                                                                    throw cause19;
                                                                                                                                                }
                                                                                                                                                throw th27;
                                                                                                                                            }
                                                                                                                                        } catch (Throwable th28) {
                                                                                                                                            Throwable cause20 = th28.getCause();
                                                                                                                                            if (cause20 != null) {
                                                                                                                                                throw cause20;
                                                                                                                                            }
                                                                                                                                            throw th28;
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                } else {
                                                                                                                                    str4 = str;
                                                                                                                                    string = str4;
                                                                                                                                }
                                                                                                                                linkedHashSet.add(string);
                                                                                                                                if (objInvoke2.equals(r9.rewind())) {
                                                                                                                                    int iINotificationSideChannel9 = SqlDateTypeAdapter.AnonymousClass1.INotificationSideChannel();
                                                                                                                                    int i329 = ~iINotificationSideChannel9;
                                                                                                                                    int i330 = ~(((-1172061424) & i329) | ((-1172061424) ^ i329));
                                                                                                                                    int i331 = ~((1910321450 ^ iINotificationSideChannel9) | (1910321450 & iINotificationSideChannel9));
                                                                                                                                    int i332 = ((i330 & i331) | (i330 ^ i331)) * 333;
                                                                                                                                    int i333 = ((-185130971) ^ i332) + ((i332 & (-185130971)) << 1);
                                                                                                                                    int i334 = ((~((iINotificationSideChannel9 & (-1172061424)) | ((-1172061424) ^ iINotificationSideChannel9))) | (~((i329 & 1910321450) | (i329 ^ 1910321450)))) * 333;
                                                                                                                                    i19 = ((i333 | i334) << 1) - (i334 ^ i333);
                                                                                                                                    int iINotificationSideChannel10 = SqlDateTypeAdapter.AnonymousClass1.INotificationSideChannel();
                                                                                                                                    int i335 = ~((1618314597 & iINotificationSideChannel10) | (1618314597 ^ iINotificationSideChannel10));
                                                                                                                                    i20 = -(-(((i335 & 481085041) | (481085041 ^ i335)) * (-964)));
                                                                                                                                    int i336 = ~iINotificationSideChannel10;
                                                                                                                                    i21 = ~((i336 & 1618314597) | (1618314597 ^ i336));
                                                                                                                                    if (i19 <= (((1122935188 ^ i20) + ((i20 & 1122935188) << 1)) - (~(-(-(((i21 & 478691856) | (i21 ^ 478691856)) * (-964)))))) - 1) {
                                                                                                                                        objArr = new Object[3];
                                                                                                                                        objArr[1] = new int[1];
                                                                                                                                    } else {
                                                                                                                                        objArr = new Object[4];
                                                                                                                                        objArr[0] = new int[1];
                                                                                                                                    }
                                                                                                                                    objArr[2] = new int[1];
                                                                                                                                    objArr[3] = new int[]{i4};
                                                                                                                                    int[] iArr4 = (int[]) objArr[0];
                                                                                                                                    int i337 = artificialFrame + 49;
                                                                                                                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i337 % 128;
                                                                                                                                    int i338 = i337 % 2;
                                                                                                                                    iArr4[0] = i4;
                                                                                                                                    int i339 = (~(177675197 | i4)) | (~(338024923 | i10));
                                                                                                                                    int i340 = ~((-177675198) | i10);
                                                                                                                                    int i341 = 347059641 + ((i339 | i340) * (-516)) + (((~((-337690691) | i4)) | (~((-334234) | i10))) * 516) + ((334233 | i340) * 516);
                                                                                                                                    int i342 = (i341 << 1) - i341;
                                                                                                                                    int iINotificationSideChannel11 = SqlDateTypeAdapter.AnonymousClass1.INotificationSideChannel();
                                                                                                                                    int i343 = i342 * (-963);
                                                                                                                                    int i344 = (((i343 ^ (-964)) + ((i343 & (-964)) << 1)) - (~(i3 * 965))) - 1;
                                                                                                                                    int i345 = ~i342;
                                                                                                                                    int i346 = ~i3;
                                                                                                                                    int i347 = ~((i346 ^ iINotificationSideChannel11) | (i346 & iINotificationSideChannel11));
                                                                                                                                    int i348 = (i344 - (~(-(-(((i345 & i347) | (i345 ^ i347)) * (-964)))))) - 1;
                                                                                                                                    int i349 = ~iINotificationSideChannel11;
                                                                                                                                    int i350 = ~((i349 & i346) | (i346 ^ i349));
                                                                                                                                    int i351 = ~i3;
                                                                                                                                    int i352 = ~((i342 & i351) | (i351 ^ i342));
                                                                                                                                    int i353 = ((i352 & i350) | (i350 ^ i352)) * (-964);
                                                                                                                                    int i354 = ((i348 | i353) << 1) - (i353 ^ i348);
                                                                                                                                    int i355 = (i354 << 13) ^ i354;
                                                                                                                                    int i356 = i355 >>> 17;
                                                                                                                                    int i357 = (i355 | i356) & (~(i355 & i356));
                                                                                                                                    int i358 = i357 << 5;
                                                                                                                                    ((int[]) objArr[2])[0] = ((~i357) & i358) | ((~i358) & i357);
                                                                                                                                    objArr[1] = null;
                                                                                                                                } else {
                                                                                                                                    i14 = i17 + 1;
                                                                                                                                    objInvoke = obj2;
                                                                                                                                    str2 = str3;
                                                                                                                                    r8 = i3;
                                                                                                                                    str = str4;
                                                                                                                                    length2 = i15;
                                                                                                                                    i9 = i16;
                                                                                                                                    Invoke = r46;
                                                                                                                                }
                                                                                                                            } catch (Throwable th29) {
                                                                                                                                Throwable cause21 = th29.getCause();
                                                                                                                                if (cause21 != null) {
                                                                                                                                    throw cause21;
                                                                                                                                }
                                                                                                                                throw th29;
                                                                                                                            }
                                                                                                                        } catch (Throwable th30) {
                                                                                                                            Throwable cause22 = th30.getCause();
                                                                                                                            if (cause22 != null) {
                                                                                                                                throw cause22;
                                                                                                                            }
                                                                                                                            throw th30;
                                                                                                                        }
                                                                                                                    } catch (Throwable th31) {
                                                                                                                        th = th31;
                                                                                                                        Throwable th32 = th;
                                                                                                                        Throwable cause23 = th32.getCause();
                                                                                                                        if (cause23 != null) {
                                                                                                                            throw cause23;
                                                                                                                        }
                                                                                                                        throw th32;
                                                                                                                    }
                                                                                                                } catch (Throwable th33) {
                                                                                                                    th = th33;
                                                                                                                    boolean z3 = r8 == true ? 1 : 0;
                                                                                                                }
                                                                                                            } catch (Throwable th34) {
                                                                                                                boolean z4 = r8 == true ? 1 : 0;
                                                                                                                Throwable cause24 = th34.getCause();
                                                                                                                if (cause24 != null) {
                                                                                                                    throw cause24;
                                                                                                                }
                                                                                                                throw th34;
                                                                                                            }
                                                                                                        } catch (Throwable th35) {
                                                                                                            boolean z5 = r8 == true ? 1 : 0;
                                                                                                            Throwable cause25 = th35.getCause();
                                                                                                            if (cause25 != null) {
                                                                                                                throw cause25;
                                                                                                            }
                                                                                                            throw th35;
                                                                                                        }
                                                                                                    }
                                                                                                    boolean z6 = r8 == true ? 1 : 0;
                                                                                                    Invoke = Invoke;
                                                                                                    r4 = r212;
                                                                                                    i11 = (i266 & 1) + (i266 | 1);
                                                                                                    objInvoke = objInvoke;
                                                                                                    r7 = r8;
                                                                                                } catch (Throwable th36) {
                                                                                                    boolean z7 = r7 == true ? 1 : 0;
                                                                                                    Throwable cause26 = th36.getCause();
                                                                                                    if (cause26 != null) {
                                                                                                        throw cause26;
                                                                                                    }
                                                                                                    throw th36;
                                                                                                }
                                                                                            }
                                                                                            boolean z8 = r7 == true ? 1 : 0;
                                                                                            i12 = i9;
                                                                                            int i359 = (i4 & (-2)) | (i10 & 1);
                                                                                            arrayList = new ArrayList(linkedHashSet);
                                                                                            int size = arrayList.size();
                                                                                            strArr2 = new String[((size | 1) << 1) - (size ^ 1)];
                                                                                            Object[] objArr92 = new Object[1];
                                                                                            a(new byte[]{0, 1, 1, 1}, new int[]{445, 4, 0, 2}, false, objArr92);
                                                                                            strArr2[0] = (String) objArr92[0];
                                                                                            i13 = 0;
                                                                                            while (i13 < arrayList.size()) {
                                                                                                int i360 = 595 + (i13 * (-1187));
                                                                                                int i361 = ~((-2) | i13);
                                                                                                int i362 = ~(i10 | i13);
                                                                                                int i363 = ((i361 & i362) | (i361 ^ i362)) * (-1188);
                                                                                                int i364 = (i360 & i363) + (i363 | i360);
                                                                                                int i365 = ~(((-2) & i13) | ((-2) ^ i13));
                                                                                                int i366 = ~i13;
                                                                                                int i367 = ~((i366 ^ i4) | (i366 & i4));
                                                                                                int i368 = (i365 & i367) | (i365 ^ i367);
                                                                                                int i369 = ~((i12 ^ 1) | (i12 & 1));
                                                                                                int i370 = i364 + (((i368 & i369) | (i368 ^ i369)) * 594);
                                                                                                int i371 = ~((i366 ^ i10) | (i366 & i10));
                                                                                                int i372 = ~(i366 | 1);
                                                                                                int i373 = (i371 & i372) | (i371 ^ i372);
                                                                                                int i374 = ~((i10 ^ 1) | (i10 & 1));
                                                                                                int i375 = ((i373 & i374) | (i373 ^ i374)) * 594;
                                                                                                strArr2[(i370 & i375) + (i375 | i370)] = (String) arrayList.get(i13);
                                                                                                int i376 = (i13 ^ 107) + ((i13 & 107) << 1);
                                                                                                i13 = ((i376 | (-106)) << 1) - (i376 ^ (-106));
                                                                                            }
                                                                                            Object[] objArr93 = {new int[]{i359}, strArr2, new int[]{(i | i) & (~(i & i))}, new int[]{i4}};
                                                                                            int i377 = 549719059 + (((-336658471) | i10) * (-490)) + (((~(713476616 | i4)) | (-1050135087)) * 490) + 1321821546;
                                                                                            int i378 = ((z8 ? 1 : 0) ^ i377) + ((i377 & (z8 ? 1 : 0)) << 1);
                                                                                            int i379 = i378 << 13;
                                                                                            int i380 = (i378 | i379) & (~(i378 & i379));
                                                                                            int i381 = i380 >>> 17;
                                                                                            int i382 = (i380 | i381) & (~(i380 & i381));
                                                                                            int i383 = i382 << 5;
                                                                                            return objArr93;
                                                                                        } catch (Throwable th37) {
                                                                                            Throwable cause27 = th37.getCause();
                                                                                            if (cause27 != null) {
                                                                                                throw cause27;
                                                                                            }
                                                                                            throw th37;
                                                                                        }
                                                                                    } catch (Throwable th38) {
                                                                                        Throwable cause28 = th38.getCause();
                                                                                        if (cause28 != null) {
                                                                                            throw cause28;
                                                                                        }
                                                                                        throw th38;
                                                                                    }
                                                                                } catch (Throwable th39) {
                                                                                    Throwable cause29 = th39.getCause();
                                                                                    if (cause29 != null) {
                                                                                        throw cause29;
                                                                                    }
                                                                                    throw th39;
                                                                                }
                                                                            } catch (Throwable unused5) {
                                                                                Invoke = length;
                                                                            }
                                                                            return objArr;
                                                                        }
                                                                        int i384 = artificialFrame;
                                                                        int i385 = (i384 & 53) + (i384 | 53);
                                                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i385 % 128;
                                                                        int i386 = i385 % 2;
                                                                        return objArr4;
                                                                    } catch (Throwable th40) {
                                                                        th = th40;
                                                                        th2 = th;
                                                                        keyStore = null;
                                                                        if (keyStore != null) {
                                                                            throw th2;
                                                                        }
                                                                        try {
                                                                            keyStore.deleteEntry(string4);
                                                                            throw th2;
                                                                        } catch (KeyStoreException unused6) {
                                                                            throw th2;
                                                                        }
                                                                    }
                                                                }
                                                            } catch (Exception unused7) {
                                                                if (keyStore != null) {
                                                                    keyStore.deleteEntry(string4);
                                                                }
                                                                i32 = 3;
                                                                arrayList2 = null;
                                                                r26 = r12;
                                                                r28 = r13;
                                                            }
                                                        } catch (Throwable th41) {
                                                            th2 = th41;
                                                            if (keyStore != null) {
                                                                throw th2;
                                                            }
                                                            keyStore.deleteEntry(string4);
                                                            throw th2;
                                                        }
                                                    } catch (Throwable th42) {
                                                        th = th42;
                                                    }
                                                } catch (Throwable th43) {
                                                    th = th43;
                                                }
                                            } catch (Exception unused8) {
                                            }
                                        } catch (Throwable th44) {
                                            Throwable cause30 = th44.getCause();
                                            if (cause30 != null) {
                                                throw cause30;
                                            }
                                            throw th44;
                                        }
                                    }
                                    try {
                                        objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1379818893);
                                        if (objAccessartificialFrame4 == null) {
                                            objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(41 - TextUtils.lastIndexOf("", '0', 0), (char) ((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 19409), 3808 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), -849667195, false, "onResult", new Class[0]);
                                        }
                                        list = (List) ((Method) objAccessartificialFrame4).invoke(objNewInstance, null);
                                        if (list == null || list.isEmpty()) {
                                            listEmptyList = null;
                                            r211 = r26;
                                            r210 = r28;
                                            break;
                                        }
                                        int size2 = list.size();
                                        int i387 = (size2 ^ (-1)) + (size2 << 1);
                                        while (true) {
                                            if (i387 < 0) {
                                                listEmptyList = null;
                                                r211 = r26;
                                                r210 = r28;
                                                break;
                                            }
                                            Object obj5 = list.get(i387);
                                            Object[] objArr94 = new Object[1];
                                            a(new byte[]{1, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1}, new int[]{211, 24, 0, 0}, true, objArr94);
                                            String str10 = (String) objArr94[0];
                                            int i388 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                            int i389 = ((i388 | 21) << 1) - (i388 ^ 21);
                                            artificialFrame = i389 % 128;
                                            int i390 = i389 % 2;
                                            try {
                                                Object[] objArr95 = {str10};
                                                byte[] bArr3 = {1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1};
                                                int[] iArr5 = {235, 34, 49, 0};
                                                int i391 = (i388 ^ 65) + ((i388 & 65) << 1);
                                                artificialFrame = i391 % 128;
                                                int i392 = i391 % 2;
                                                Object[] objArr96 = new Object[1];
                                                a(bArr3, iArr5, false, objArr96);
                                                Class<?> cls23 = Class.forName((String) objArr96[0]);
                                                Object[] objArr97 = new Object[1];
                                                a(new byte[]{0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 0}, new int[]{269, 17, 145, 0}, false, objArr97);
                                                byte[] bArr4 = (byte[]) cls23.getMethod((String) objArr97[0], String.class).invoke(obj5, objArr95);
                                                if (bArr4 != null) {
                                                    Object objNewInstance2 = ((Class) ArtificialStackFrames.coroutineCreation(47 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (char) ((ViewConfiguration.getPressedStateDuration() >> 16) + 31395), (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 2646)).getConstructor(new Class[0]).newInstance(new Object[0]);
                                                    try {
                                                        Object[] objArr98 = {objNewInstance2, bArr4};
                                                        Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(1094878374);
                                                        if (objAccessartificialFrame7 == null) {
                                                            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(24 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), ImageFormat.getBitsPerPixel(0) + 387, -567819602, false, null, new Class[]{(Class) ArtificialStackFrames.coroutineCreation(AndroidCharacter.getMirror('0') - 24, (char) ((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 53250), AndroidCharacter.getMirror('0') + 'L'), byte[].class});
                                                        }
                                                        InputStream inputStream = (InputStream) ((Constructor) objAccessartificialFrame7).newInstance(objArr98);
                                                        int i393 = -1239553844;
                                                        try {
                                                            Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-1239553844);
                                                            if (objAccessartificialFrame8 == null) {
                                                                objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(24 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 1), 385 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), 695774916, false, "MediaMetadataCompatBitmapKey", null);
                                                            }
                                                            Object obj6 = ((Field) objAccessartificialFrame8).get(inputStream);
                                                            try {
                                                                Object[] objArr99 = {inputStream};
                                                                Object objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(1296960672);
                                                                if (objAccessartificialFrame9 == null) {
                                                                    objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(23 - TextUtils.indexOf((CharSequence) "", '0', 0), (char) ((ViewConfiguration.getWindowTouchSlop() >> 8) + 53250), 123 - ExpandableListView.getPackedPositionChild(0L), -768914776, false, "coroutineBoundary", new Class[]{InputStream.class});
                                                                }
                                                                Object objInvoke8 = ((Method) objAccessartificialFrame9).invoke(obj6, objArr99);
                                                                Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-1239553844);
                                                                if (objAccessartificialFrame10 == null) {
                                                                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation((-16777192) - Color.rgb(0, 0, 0), (char) View.getDefaultSize(0, 0), KeyEvent.normalizeMetaState(0) + 386, 695774916, false, "MediaMetadataCompatBitmapKey", null);
                                                                }
                                                                Object obj7 = ((Field) objAccessartificialFrame10).get(inputStream);
                                                                try {
                                                                    Object[] objArr100 = {inputStream};
                                                                    Object objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(-119044754);
                                                                    if (objAccessartificialFrame11 == null) {
                                                                        objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 25, (char) (53251 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))), 124 - View.resolveSize(0, 0), 1736622950, false, "ArtificialStackFrames", new Class[]{InputStream.class});
                                                                    }
                                                                    int iIntValue = ((Integer) ((Method) objAccessartificialFrame11).invoke(obj7, objArr100)).intValue();
                                                                    Object objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(-1239553844);
                                                                    if (objAccessartificialFrame12 == null) {
                                                                        objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(24 - Color.argb(0, 0, 0, 0), (char) (ViewConfiguration.getWindowTouchSlop() >> 8), 386 - Color.red(0), 695774916, false, "MediaMetadataCompatBitmapKey", null);
                                                                    }
                                                                    Object obj8 = ((Field) objAccessartificialFrame12).get(inputStream);
                                                                    try {
                                                                        Object[] objArr101 = {Integer.valueOf(iIntValue), inputStream};
                                                                        Object objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(-729892777);
                                                                        if (objAccessartificialFrame13 == null) {
                                                                            objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(TextUtils.indexOf("", "", 0) + 24, (char) (53249 - MotionEvent.axisFromString("")), ImageFormat.getBitsPerPixel(0) + 125, 1260125791, false, "ArtificialStackFrames", new Class[]{Integer.TYPE, InputStream.class});
                                                                        }
                                                                        Object objInvoke9 = ((Method) objAccessartificialFrame13).invoke(obj8, objArr101);
                                                                        Object objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(-1239553844);
                                                                        if (objAccessartificialFrame14 == null) {
                                                                            objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(24 - TextUtils.getOffsetAfter("", 0), (char) KeyEvent.normalizeMetaState(0), TextUtils.indexOf((CharSequence) "", '0', 0) + 387, 695774916, false, "MediaMetadataCompatBitmapKey", null);
                                                                        }
                                                                        try {
                                                                            Object[] objArr102 = {((Field) objAccessartificialFrame14).get(inputStream)};
                                                                            Object objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(1328317403);
                                                                            if (objAccessartificialFrame15 == null) {
                                                                                objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(ExpandableListView.getPackedPositionGroup(0L) + 14, (char) (ViewConfiguration.getTouchSlop() >> 8), 2753 - (ViewConfiguration.getTouchSlop() >> 8), -800471597, false, "ArtificialStackFrames", new Class[]{(Class) ArtificialStackFrames.coroutineCreation(25 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), (char) ((Process.myPid() >> 22) + 53250), 123 - ImageFormat.getBitsPerPixel(0))});
                                                                            }
                                                                            Object objInvoke10 = ((Method) objAccessartificialFrame15).invoke(objInvoke8, objArr102);
                                                                            try {
                                                                                Object[] objArr103 = {objInvoke8, objInvoke9};
                                                                                Object objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(1176953419);
                                                                                if (objAccessartificialFrame16 == null) {
                                                                                    objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(KeyEvent.keyCodeFromString("") + 15, (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 1), 342 - TextUtils.lastIndexOf("", '0', 0), -649878461, false, "accessartificialFrame", new Class[]{(Class) ArtificialStackFrames.coroutineCreation(14 - View.resolveSizeAndState(0, 0, 0), (char) TextUtils.indexOf("", ""), 2753 - View.getDefaultSize(0, 0)), byte[].class});
                                                                                }
                                                                                Object objInvoke11 = ((Method) objAccessartificialFrame16).invoke(objInvoke10, objArr103);
                                                                                inputStream.close();
                                                                                Object objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(-2134990334);
                                                                                if (objAccessartificialFrame17 == null) {
                                                                                    objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getKeyRepeatDelay() >> 16) + 22, (char) (AndroidCharacter.getMirror('0') - '0'), MotionEvent.axisFromString("") + 3983, 534504458, false, "e", null);
                                                                                }
                                                                                byte[] bArr5 = (byte[]) ((Field) objAccessartificialFrame17).get(objInvoke11);
                                                                                Object objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(-2134990334);
                                                                                if (objAccessartificialFrame18 == null) {
                                                                                    objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(((Process.getThreadPriority(0) + 20) >> 6) + 22, (char) ((-1) - Process.getGidForName("")), 3982 - View.resolveSizeAndState(0, 0, 0), 534504458, false, "e", null);
                                                                                }
                                                                                try {
                                                                                    Object[] objArr104 = {objNewInstance2, Arrays.copyOf(bArr5, ((byte[]) ((Field) objAccessartificialFrame18).get(objInvoke11)).length)};
                                                                                    Object objAccessartificialFrame19 = ArtificialStackFrames.accessartificialFrame(1094878374);
                                                                                    if (objAccessartificialFrame19 == null) {
                                                                                        objAccessartificialFrame19 = ArtificialStackFrames.coroutineCreation(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 25, (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 1), View.getDefaultSize(0, 0) + 386, -567819602, false, null, new Class[]{(Class) ArtificialStackFrames.coroutineCreation(Color.alpha(0) + 24, (char) (53250 - KeyEvent.keyCodeFromString("")), 124 - TextUtils.indexOf("", "")), byte[].class});
                                                                                    }
                                                                                    InputStream inputStream2 = (InputStream) ((Constructor) objAccessartificialFrame19).newInstance(objArr104);
                                                                                    try {
                                                                                        Object objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(-1239553844);
                                                                                        if (objAccessartificialFrame20 == null) {
                                                                                            objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation(((byte) KeyEvent.getModifierMetaStateMask()) + Ascii.EM, (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) - 1), (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 385, 695774916, false, "MediaMetadataCompatBitmapKey", null);
                                                                                        }
                                                                                        Object obj9 = ((Field) objAccessartificialFrame20).get(inputStream2);
                                                                                        try {
                                                                                            Object[] objArr105 = {inputStream2};
                                                                                            Object objAccessartificialFrame21 = ArtificialStackFrames.accessartificialFrame(1296960672);
                                                                                            if (objAccessartificialFrame21 == null) {
                                                                                                objAccessartificialFrame21 = ArtificialStackFrames.coroutineCreation(View.getDefaultSize(0, 0) + 24, (char) (53250 - KeyEvent.getDeadChar(0, 0)), 123 - TextUtils.indexOf((CharSequence) "", '0', 0), -768914776, false, "coroutineBoundary", new Class[]{InputStream.class});
                                                                                            }
                                                                                            Object objInvoke12 = ((Method) objAccessartificialFrame21).invoke(obj9, objArr105);
                                                                                            Object objAccessartificialFrame22 = ArtificialStackFrames.accessartificialFrame(-1239553844);
                                                                                            if (objAccessartificialFrame22 == null) {
                                                                                                objAccessartificialFrame22 = ArtificialStackFrames.coroutineCreation(24 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (char) View.resolveSize(0, 0), TextUtils.indexOf("", "") + 386, 695774916, false, "MediaMetadataCompatBitmapKey", null);
                                                                                            }
                                                                                            Object obj10 = ((Field) objAccessartificialFrame22).get(inputStream2);
                                                                                            try {
                                                                                                Object[] objArr106 = {inputStream2};
                                                                                                Object objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(-119044754);
                                                                                                if (objAccessartificialFrame23 == null) {
                                                                                                    objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(24 - TextUtils.getOffsetBefore("", 0), (char) (((byte) KeyEvent.getModifierMetaStateMask()) + Ascii.ETX), 124 - Gravity.getAbsoluteGravity(0, 0), 1736622950, false, "ArtificialStackFrames", new Class[]{InputStream.class});
                                                                                                }
                                                                                                int iIntValue2 = ((Integer) ((Method) objAccessartificialFrame23).invoke(obj10, objArr106)).intValue();
                                                                                                Object objAccessartificialFrame24 = ArtificialStackFrames.accessartificialFrame(-1239553844);
                                                                                                if (objAccessartificialFrame24 == null) {
                                                                                                    objAccessartificialFrame24 = ArtificialStackFrames.coroutineCreation(TextUtils.getOffsetAfter("", 0) + 24, (char) (ViewConfiguration.getTapTimeout() >> 16), 386 - (KeyEvent.getMaxKeyCode() >> 16), 695774916, false, "MediaMetadataCompatBitmapKey", null);
                                                                                                }
                                                                                                Object obj11 = ((Field) objAccessartificialFrame24).get(inputStream2);
                                                                                                try {
                                                                                                    Object[] objArr107 = {Integer.valueOf(iIntValue2), inputStream2};
                                                                                                    Object objAccessartificialFrame25 = ArtificialStackFrames.accessartificialFrame(-729892777);
                                                                                                    if (objAccessartificialFrame25 == null) {
                                                                                                        objAccessartificialFrame25 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 24, (char) ((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 53250), 123 - ImageFormat.getBitsPerPixel(0), 1260125791, false, "ArtificialStackFrames", new Class[]{Integer.TYPE, InputStream.class});
                                                                                                    }
                                                                                                    Object objInvoke13 = ((Method) objAccessartificialFrame25).invoke(obj11, objArr107);
                                                                                                    Object objAccessartificialFrame26 = ArtificialStackFrames.accessartificialFrame(-1239553844);
                                                                                                    if (objAccessartificialFrame26 == null) {
                                                                                                        objAccessartificialFrame26 = ArtificialStackFrames.coroutineCreation(24 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)), (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1), TextUtils.lastIndexOf("", '0', 0, 0) + 387, 695774916, false, "MediaMetadataCompatBitmapKey", null);
                                                                                                    }
                                                                                                    try {
                                                                                                        Object[] objArr108 = {((Field) objAccessartificialFrame26).get(inputStream2)};
                                                                                                        Object objAccessartificialFrame27 = ArtificialStackFrames.accessartificialFrame(1328317403);
                                                                                                        if (objAccessartificialFrame27 == null) {
                                                                                                            objAccessartificialFrame27 = ArtificialStackFrames.coroutineCreation(14 - (ViewConfiguration.getScrollBarSize() >> 8), (char) View.MeasureSpec.getMode(0), 2752 - TextUtils.indexOf((CharSequence) "", '0'), -800471597, false, "ArtificialStackFrames", new Class[]{(Class) ArtificialStackFrames.coroutineCreation(TextUtils.getCapsMode("", 0, 0) + 24, (char) (53250 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1))), 125 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)))});
                                                                                                        }
                                                                                                        Object objInvoke14 = ((Method) objAccessartificialFrame27).invoke(objInvoke12, objArr108);
                                                                                                        try {
                                                                                                            Object[] objArr109 = {objInvoke12, objInvoke13};
                                                                                                            Object objAccessartificialFrame28 = ArtificialStackFrames.accessartificialFrame(1176953419);
                                                                                                            if (objAccessartificialFrame28 == null) {
                                                                                                                objAccessartificialFrame28 = ArtificialStackFrames.coroutineCreation(15 - Color.argb(0, 0, 0, 0), (char) (ViewConfiguration.getDoubleTapTimeout() >> 16), 342 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), -649878461, false, "accessartificialFrame", new Class[]{(Class) ArtificialStackFrames.coroutineCreation((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 13, (char) (Process.myPid() >> 22), TextUtils.getCapsMode("", 0, 0) + 2753), byte[].class});
                                                                                                            }
                                                                                                            Object objInvoke15 = ((Method) objAccessartificialFrame28).invoke(objInvoke14, objArr109);
                                                                                                            inputStream2.close();
                                                                                                            Object[] objArr110 = (Object[]) Array.newInstance((Class<?>) ArtificialStackFrames.coroutineCreation(20 - (ViewConfiguration.getDoubleTapTimeout() >> 16), (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16), TextUtils.getOffsetBefore("", 0) + 3316), 2);
                                                                                                            Object objAccessartificialFrame29 = ArtificialStackFrames.accessartificialFrame(-1944720953);
                                                                                                            if (objAccessartificialFrame29 == null) {
                                                                                                                objAccessartificialFrame29 = ArtificialStackFrames.coroutineCreation(20 - Drawable.resolveOpacity(0, 0), (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), 3316 - (ViewConfiguration.getFadingEdgeLength() >> 16), 326152143, false, "b", null);
                                                                                                            }
                                                                                                            objArr110[0] = ((List) ((Field) objAccessartificialFrame29).get(objInvoke15)).get(7);
                                                                                                            Object objAccessartificialFrame30 = ArtificialStackFrames.accessartificialFrame(-1944720953);
                                                                                                            if (objAccessartificialFrame30 == null) {
                                                                                                                objAccessartificialFrame30 = ArtificialStackFrames.coroutineCreation(20 - View.getDefaultSize(0, 0), (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), 3317 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), 326152143, false, "b", null);
                                                                                                            }
                                                                                                            objArr110[1] = ((List) ((Field) objAccessartificialFrame30).get(objInvoke15)).get(6);
                                                                                                            int length8 = objArr110.length;
                                                                                                            Object objInvoke16 = null;
                                                                                                            int i394 = 0;
                                                                                                            while (i394 < 2) {
                                                                                                                Object obj12 = objArr110[i394];
                                                                                                                Object objAccessartificialFrame31 = ArtificialStackFrames.accessartificialFrame(-1944720953);
                                                                                                                if (objAccessartificialFrame31 == null) {
                                                                                                                    objAccessartificialFrame31 = ArtificialStackFrames.coroutineCreation((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 19, (char) (1 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))), 3315 - Process.getGidForName(""), 326152143, false, "b", null);
                                                                                                                }
                                                                                                                for (Object obj13 : new ArrayList((Collection) ((Field) objAccessartificialFrame31).get(obj12))) {
                                                                                                                    Object objAccessartificialFrame32 = ArtificialStackFrames.accessartificialFrame(-1172013915);
                                                                                                                    if (objAccessartificialFrame32 == null) {
                                                                                                                        objAccessartificialFrame32 = ArtificialStackFrames.coroutineCreation(KeyEvent.getDeadChar(0, 0) + 10, (char) ExpandableListView.getPackedPositionGroup(0L), Color.red(0) + 2694, 625031853, false, "MediaControllerCompatCallbackStubCompat", null);
                                                                                                                    }
                                                                                                                    Object obj14 = ((Field) objAccessartificialFrame32).get(obj13);
                                                                                                                    Object objAccessartificialFrame33 = ArtificialStackFrames.accessartificialFrame(-1196027417);
                                                                                                                    if (objAccessartificialFrame33 == null) {
                                                                                                                        objAccessartificialFrame33 = ArtificialStackFrames.coroutineCreation(Color.alpha(0) + 14, (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 1), (ViewConfiguration.getDoubleTapTimeout() >> 16) + 2753, 668162031, false, "MediaControllerCompatMediaControllerImplApi24", null);
                                                                                                                    }
                                                                                                                    if (((Field) objAccessartificialFrame33).getInt(obj14) == 709) {
                                                                                                                        Object objAccessartificialFrame34 = ArtificialStackFrames.accessartificialFrame(-2123799311);
                                                                                                                        if (objAccessartificialFrame34 == null) {
                                                                                                                            objAccessartificialFrame34 = ArtificialStackFrames.coroutineCreation(32 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (char) (30292 - Color.argb(0, 0, 0, 0)), 2986 - Color.blue(0), 504111865, false, "getCurrentVolume", null);
                                                                                                                        }
                                                                                                                        if (((Field) objAccessartificialFrame34).get(obj13) != null) {
                                                                                                                            Object objAccessartificialFrame35 = ArtificialStackFrames.accessartificialFrame(-2123799311);
                                                                                                                            if (objAccessartificialFrame35 == null) {
                                                                                                                                objAccessartificialFrame35 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getJumpTapTimeout() >> 16) + 32, (char) (KeyEvent.keyCodeFromString("") + 30292), 2986 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), 504111865, false, "getCurrentVolume", null);
                                                                                                                            }
                                                                                                                            obj3 = ((Field) objAccessartificialFrame35).get(obj13);
                                                                                                                        } else {
                                                                                                                            Object objAccessartificialFrame36 = ArtificialStackFrames.accessartificialFrame(318476122);
                                                                                                                            if (objAccessartificialFrame36 == null) {
                                                                                                                                objAccessartificialFrame36 = ArtificialStackFrames.coroutineCreation(TextUtils.lastIndexOf("", '0') + 33, (char) ((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 30292), 2986 - View.resolveSizeAndState(0, 0, 0), -1918973614, false, "MediaMetadataCompatBuilder", null);
                                                                                                                            }
                                                                                                                            Object obj15 = ((Field) objAccessartificialFrame36).get(obj13);
                                                                                                                            Object objAccessartificialFrame37 = ArtificialStackFrames.accessartificialFrame(209482075);
                                                                                                                            if (objAccessartificialFrame37 == null) {
                                                                                                                                objAccessartificialFrame37 = ArtificialStackFrames.coroutineCreation(32 - View.MeasureSpec.getMode(0), (char) (30340 - AndroidCharacter.getMirror('0')), View.MeasureSpec.getSize(0) + 2986, -1827063981, false, "a", null);
                                                                                                                            }
                                                                                                                            try {
                                                                                                                                Object[] objArr111 = {obj15, ((Field) objAccessartificialFrame37).get(obj13)};
                                                                                                                                Object objAccessartificialFrame38 = ArtificialStackFrames.accessartificialFrame(1094878374);
                                                                                                                                if (objAccessartificialFrame38 == null) {
                                                                                                                                    objAccessartificialFrame38 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 24, (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), 386 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), -567819602, false, null, new Class[]{(Class) ArtificialStackFrames.coroutineCreation((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 24, (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 53249), TextUtils.lastIndexOf("", '0', 0) + 125), byte[].class});
                                                                                                                                }
                                                                                                                                InputStream inputStream3 = (InputStream) ((Constructor) objAccessartificialFrame38).newInstance(objArr111);
                                                                                                                                try {
                                                                                                                                    try {
                                                                                                                                        Object objAccessartificialFrame39 = ArtificialStackFrames.accessartificialFrame(i393);
                                                                                                                                        if (objAccessartificialFrame39 == null) {
                                                                                                                                            objAccessartificialFrame39 = ArtificialStackFrames.coroutineCreation(25 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), (char) Color.blue(0), (Process.myPid() >> 22) + 386, 695774916, false, "MediaMetadataCompatBitmapKey", null);
                                                                                                                                        }
                                                                                                                                        Object obj16 = ((Field) objAccessartificialFrame39).get(inputStream3);
                                                                                                                                        try {
                                                                                                                                            Object[] objArr112 = {inputStream3};
                                                                                                                                            Object objAccessartificialFrame40 = ArtificialStackFrames.accessartificialFrame(1296960672);
                                                                                                                                            if (objAccessartificialFrame40 == null) {
                                                                                                                                                objAccessartificialFrame40 = ArtificialStackFrames.coroutineCreation((Process.myTid() >> 22) + 24, (char) (AndroidCharacter.getMirror('0') + 53202), View.MeasureSpec.makeMeasureSpec(0, 0) + 124, -768914776, false, "coroutineBoundary", new Class[]{InputStream.class});
                                                                                                                                            }
                                                                                                                                            Object objInvoke17 = ((Method) objAccessartificialFrame40).invoke(obj16, objArr112);
                                                                                                                                            Object objAccessartificialFrame41 = ArtificialStackFrames.accessartificialFrame(i393);
                                                                                                                                            if (objAccessartificialFrame41 == null) {
                                                                                                                                                objAccessartificialFrame41 = ArtificialStackFrames.coroutineCreation(View.MeasureSpec.getSize(0) + 24, (char) (ViewConfiguration.getLongPressTimeout() >> 16), 386 - TextUtils.getOffsetAfter("", 0), 695774916, false, "MediaMetadataCompatBitmapKey", null);
                                                                                                                                            }
                                                                                                                                            Object obj17 = ((Field) objAccessartificialFrame41).get(inputStream3);
                                                                                                                                            try {
                                                                                                                                                Object[] objArr113 = {inputStream3};
                                                                                                                                                Object objAccessartificialFrame42 = ArtificialStackFrames.accessartificialFrame(-119044754);
                                                                                                                                                if (objAccessartificialFrame42 == null) {
                                                                                                                                                    objAccessartificialFrame42 = ArtificialStackFrames.coroutineCreation(Color.rgb(0, 0, 0) + 16777240, (char) (ExpandableListView.getPackedPositionType(0L) + 53250), 123 - Process.getGidForName(""), 1736622950, false, "ArtificialStackFrames", new Class[]{InputStream.class});
                                                                                                                                                }
                                                                                                                                                int iIntValue3 = ((Integer) ((Method) objAccessartificialFrame42).invoke(obj17, objArr113)).intValue();
                                                                                                                                                Object objAccessartificialFrame43 = ArtificialStackFrames.accessartificialFrame(i393);
                                                                                                                                                if (objAccessartificialFrame43 == null) {
                                                                                                                                                    objAccessartificialFrame43 = ArtificialStackFrames.coroutineCreation(24 - View.resolveSize(0, 0), (char) (1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))), View.MeasureSpec.getSize(0) + 386, 695774916, false, "MediaMetadataCompatBitmapKey", null);
                                                                                                                                                }
                                                                                                                                                Object obj18 = ((Field) objAccessartificialFrame43).get(inputStream3);
                                                                                                                                                int i395 = getARTIFICIAL_FRAME_PACKAGE_NAME + 83;
                                                                                                                                                artificialFrame = i395 % 128;
                                                                                                                                                if (i395 % 2 == 0) {
                                                                                                                                                    try {
                                                                                                                                                        Object[] objArr114 = {Integer.valueOf(iIntValue3), inputStream3};
                                                                                                                                                        Object objAccessartificialFrame44 = ArtificialStackFrames.accessartificialFrame(-729892777);
                                                                                                                                                        if (objAccessartificialFrame44 == null) {
                                                                                                                                                            objAccessartificialFrame44 = ArtificialStackFrames.coroutineCreation(25 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (char) (53250 - (ViewConfiguration.getTouchSlop() >> 8)), 124 - (KeyEvent.getMaxKeyCode() >> 16), 1260125791, false, "ArtificialStackFrames", new Class[]{Integer.TYPE, InputStream.class});
                                                                                                                                                        }
                                                                                                                                                        ((Method) objAccessartificialFrame44).invoke(obj18, objArr114);
                                                                                                                                                        throw null;
                                                                                                                                                    } catch (Throwable th45) {
                                                                                                                                                        Throwable cause31 = th45.getCause();
                                                                                                                                                        if (cause31 != null) {
                                                                                                                                                            throw cause31;
                                                                                                                                                        }
                                                                                                                                                        throw th45;
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                                try {
                                                                                                                                                    Object[] objArr115 = {Integer.valueOf(iIntValue3), inputStream3};
                                                                                                                                                    Object objAccessartificialFrame45 = ArtificialStackFrames.accessartificialFrame(-729892777);
                                                                                                                                                    if (objAccessartificialFrame45 == null) {
                                                                                                                                                        objAccessartificialFrame45 = ArtificialStackFrames.coroutineCreation(24 - TextUtils.getTrimmedLength(""), (char) (Color.blue(0) + 53250), 124 - (ViewConfiguration.getScrollBarSize() >> 8), 1260125791, false, "ArtificialStackFrames", new Class[]{Integer.TYPE, InputStream.class});
                                                                                                                                                    }
                                                                                                                                                    Object objInvoke18 = ((Method) objAccessartificialFrame45).invoke(obj18, objArr115);
                                                                                                                                                    Object objAccessartificialFrame46 = ArtificialStackFrames.accessartificialFrame(i393);
                                                                                                                                                    if (objAccessartificialFrame46 == null) {
                                                                                                                                                        objAccessartificialFrame46 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getKeyRepeatDelay() >> 16) + 24, (char) (AndroidCharacter.getMirror('0') - '0'), 386 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), 695774916, false, "MediaMetadataCompatBitmapKey", null);
                                                                                                                                                    }
                                                                                                                                                    try {
                                                                                                                                                        Object[] objArr116 = {((Field) objAccessartificialFrame46).get(inputStream3)};
                                                                                                                                                        Object objAccessartificialFrame47 = ArtificialStackFrames.accessartificialFrame(1328317403);
                                                                                                                                                        if (objAccessartificialFrame47 == null) {
                                                                                                                                                            objAccessartificialFrame47 = ArtificialStackFrames.coroutineCreation((-16777202) - Color.rgb(0, 0, 0), (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), TextUtils.indexOf("", "", 0) + 2753, -800471597, false, "ArtificialStackFrames", new Class[]{(Class) ArtificialStackFrames.coroutineCreation(24 - Color.red(0), (char) (53249 - TextUtils.indexOf((CharSequence) "", '0', 0)), 123 - MotionEvent.axisFromString(""))});
                                                                                                                                                        }
                                                                                                                                                        Object objInvoke19 = ((Method) objAccessartificialFrame47).invoke(objInvoke17, objArr116);
                                                                                                                                                        try {
                                                                                                                                                            Object[] objArr117 = {objInvoke17, objInvoke18};
                                                                                                                                                            Object objAccessartificialFrame48 = ArtificialStackFrames.accessartificialFrame(1176953419);
                                                                                                                                                            if (objAccessartificialFrame48 == null) {
                                                                                                                                                                objAccessartificialFrame48 = ArtificialStackFrames.coroutineCreation(15 - TextUtils.indexOf("", ""), (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), 343 - (KeyEvent.getMaxKeyCode() >> 16), -649878461, false, "accessartificialFrame", new Class[]{(Class) ArtificialStackFrames.coroutineCreation(14 - View.MeasureSpec.getMode(0), (char) (TextUtils.indexOf((CharSequence) "", '0') + 1), (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 2752), byte[].class});
                                                                                                                                                            }
                                                                                                                                                            Object objInvoke20 = ((Method) objAccessartificialFrame48).invoke(objInvoke19, objArr117);
                                                                                                                                                            try {
                                                                                                                                                                inputStream3.close();
                                                                                                                                                                int i396 = artificialFrame;
                                                                                                                                                                int i397 = (i396 ^ 119) + ((i396 & 119) << 1);
                                                                                                                                                                getARTIFICIAL_FRAME_PACKAGE_NAME = i397 % 128;
                                                                                                                                                                int i398 = i397 % 2;
                                                                                                                                                            } catch (IOException unused9) {
                                                                                                                                                            }
                                                                                                                                                            obj3 = objInvoke20;
                                                                                                                                                        } catch (Throwable th46) {
                                                                                                                                                            Throwable cause32 = th46.getCause();
                                                                                                                                                            if (cause32 != null) {
                                                                                                                                                                throw cause32;
                                                                                                                                                            }
                                                                                                                                                            throw th46;
                                                                                                                                                        }
                                                                                                                                                    } catch (Throwable th47) {
                                                                                                                                                        Throwable cause33 = th47.getCause();
                                                                                                                                                        if (cause33 != null) {
                                                                                                                                                            throw cause33;
                                                                                                                                                        }
                                                                                                                                                        throw th47;
                                                                                                                                                    }
                                                                                                                                                } catch (Throwable th48) {
                                                                                                                                                    Throwable cause34 = th48.getCause();
                                                                                                                                                    if (cause34 != null) {
                                                                                                                                                        throw cause34;
                                                                                                                                                    }
                                                                                                                                                    throw th48;
                                                                                                                                                }
                                                                                                                                            } catch (Throwable th49) {
                                                                                                                                                Throwable cause35 = th49.getCause();
                                                                                                                                                if (cause35 != null) {
                                                                                                                                                    throw cause35;
                                                                                                                                                }
                                                                                                                                                throw th49;
                                                                                                                                            }
                                                                                                                                        } catch (Throwable th50) {
                                                                                                                                            Throwable cause36 = th50.getCause();
                                                                                                                                            if (cause36 != null) {
                                                                                                                                                throw cause36;
                                                                                                                                            }
                                                                                                                                            throw th50;
                                                                                                                                        }
                                                                                                                                    } catch (Exception e2) {
                                                                                                                                        try {
                                                                                                                                            try {
                                                                                                                                                Object[] objArr118 = {e2};
                                                                                                                                                Object objAccessartificialFrame49 = ArtificialStackFrames.accessartificialFrame(534109792);
                                                                                                                                                if (objAccessartificialFrame49 == null) {
                                                                                                                                                    objAccessartificialFrame49 = ArtificialStackFrames.coroutineCreation(MotionEvent.axisFromString("") + 29, (char) (ViewConfiguration.getLongPressTimeout() >> 16), 358 - (ViewConfiguration.getDoubleTapTimeout() >> 16), -2135910296, false, null, new Class[]{Throwable.class});
                                                                                                                                                }
                                                                                                                                                throw ((Throwable) ((Constructor) objAccessartificialFrame49).newInstance(objArr118));
                                                                                                                                            } catch (Throwable th51) {
                                                                                                                                                Throwable cause37 = th51.getCause();
                                                                                                                                                if (cause37 != null) {
                                                                                                                                                    throw cause37;
                                                                                                                                                }
                                                                                                                                                throw th51;
                                                                                                                                            }
                                                                                                                                        } catch (Exception e3) {
                                                                                                                                            try {
                                                                                                                                                Object[] objArr119 = {e3};
                                                                                                                                                Object objAccessartificialFrame50 = ArtificialStackFrames.accessartificialFrame(534109792);
                                                                                                                                                if (objAccessartificialFrame50 == null) {
                                                                                                                                                    objAccessartificialFrame50 = ArtificialStackFrames.coroutineCreation(28 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 358, -2135910296, false, null, new Class[]{Throwable.class});
                                                                                                                                                }
                                                                                                                                                throw ((Throwable) ((Constructor) objAccessartificialFrame50).newInstance(objArr119));
                                                                                                                                            } catch (Throwable th52) {
                                                                                                                                                Throwable cause38 = th52.getCause();
                                                                                                                                                if (cause38 != null) {
                                                                                                                                                    throw cause38;
                                                                                                                                                }
                                                                                                                                                throw th52;
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                } catch (Throwable th53) {
                                                                                                                                    try {
                                                                                                                                        inputStream3.close();
                                                                                                                                        throw th53;
                                                                                                                                    } catch (IOException unused10) {
                                                                                                                                        throw th53;
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            } catch (Throwable th54) {
                                                                                                                                Throwable cause39 = th54.getCause();
                                                                                                                                if (cause39 != null) {
                                                                                                                                    throw cause39;
                                                                                                                                }
                                                                                                                                throw th54;
                                                                                                                            }
                                                                                                                        }
                                                                                                                        Object objAccessartificialFrame51 = ArtificialStackFrames.accessartificialFrame(-2134990334);
                                                                                                                        if (objAccessartificialFrame51 == null) {
                                                                                                                            objAccessartificialFrame51 = ArtificialStackFrames.coroutineCreation(22 - (Process.myPid() >> 22), (char) KeyEvent.normalizeMetaState(0), View.getDefaultSize(0, 0) + 3982, 534504458, false, "e", null);
                                                                                                                        }
                                                                                                                        byte[] bArr6 = (byte[]) ((Field) objAccessartificialFrame51).get(obj3);
                                                                                                                        Object objAccessartificialFrame52 = ArtificialStackFrames.accessartificialFrame(-2134990334);
                                                                                                                        if (objAccessartificialFrame52 == null) {
                                                                                                                            objAccessartificialFrame52 = ArtificialStackFrames.coroutineCreation(22 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (char) TextUtils.indexOf("", "", 0), 3982 - (Process.myPid() >> 22), 534504458, false, "e", null);
                                                                                                                        }
                                                                                                                        try {
                                                                                                                            Object[] objArr120 = {objNewInstance2, Arrays.copyOf(bArr6, ((byte[]) ((Field) objAccessartificialFrame52).get(obj3)).length)};
                                                                                                                            Object objAccessartificialFrame53 = ArtificialStackFrames.accessartificialFrame(1094878374);
                                                                                                                            if (objAccessartificialFrame53 == null) {
                                                                                                                                objAccessartificialFrame53 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 23, (char) View.resolveSizeAndState(0, 0, 0), (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 385, -567819602, false, null, new Class[]{(Class) ArtificialStackFrames.coroutineCreation(23 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) ((ViewConfiguration.getTapTimeout() >> 16) + 53250), 123 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))), byte[].class});
                                                                                                                            }
                                                                                                                            InputStream inputStream4 = (InputStream) ((Constructor) objAccessartificialFrame53).newInstance(objArr120);
                                                                                                                            try {
                                                                                                                                Object objAccessartificialFrame54 = ArtificialStackFrames.accessartificialFrame(-1239553844);
                                                                                                                                if (objAccessartificialFrame54 == null) {
                                                                                                                                    objAccessartificialFrame54 = ArtificialStackFrames.coroutineCreation(25 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), (char) Color.blue(0), 385 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), 695774916, false, "MediaMetadataCompatBitmapKey", null);
                                                                                                                                }
                                                                                                                                Object obj19 = ((Field) objAccessartificialFrame54).get(inputStream4);
                                                                                                                                try {
                                                                                                                                    Object[] objArr121 = {inputStream4};
                                                                                                                                    Object objAccessartificialFrame55 = ArtificialStackFrames.accessartificialFrame(1296960672);
                                                                                                                                    if (objAccessartificialFrame55 == null) {
                                                                                                                                        objAccessartificialFrame55 = ArtificialStackFrames.coroutineCreation(MotionEvent.axisFromString("") + 25, (char) (53250 - (ViewConfiguration.getJumpTapTimeout() >> 16)), 123 - ((byte) KeyEvent.getModifierMetaStateMask()), -768914776, false, "coroutineBoundary", new Class[]{InputStream.class});
                                                                                                                                    }
                                                                                                                                    Object objInvoke21 = ((Method) objAccessartificialFrame55).invoke(obj19, objArr121);
                                                                                                                                    Object objAccessartificialFrame56 = ArtificialStackFrames.accessartificialFrame(-1239553844);
                                                                                                                                    if (objAccessartificialFrame56 == null) {
                                                                                                                                        objAccessartificialFrame56 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 23, (char) (ViewConfiguration.getFadingEdgeLength() >> 16), (ViewConfiguration.getFadingEdgeLength() >> 16) + 386, 695774916, false, "MediaMetadataCompatBitmapKey", null);
                                                                                                                                    }
                                                                                                                                    Object obj20 = ((Field) objAccessartificialFrame56).get(inputStream4);
                                                                                                                                    try {
                                                                                                                                        Object[] objArr122 = {inputStream4};
                                                                                                                                        Object objAccessartificialFrame57 = ArtificialStackFrames.accessartificialFrame(-119044754);
                                                                                                                                        if (objAccessartificialFrame57 == null) {
                                                                                                                                            objAccessartificialFrame57 = ArtificialStackFrames.coroutineCreation(TextUtils.getCapsMode("", 0, 0) + 24, (char) ((ViewConfiguration.getFadingEdgeLength() >> 16) + 53250), 124 - TextUtils.getOffsetAfter("", 0), 1736622950, false, "ArtificialStackFrames", new Class[]{InputStream.class});
                                                                                                                                        }
                                                                                                                                        int iIntValue4 = ((Integer) ((Method) objAccessartificialFrame57).invoke(obj20, objArr122)).intValue();
                                                                                                                                        Object objAccessartificialFrame58 = ArtificialStackFrames.accessartificialFrame(-1239553844);
                                                                                                                                        if (objAccessartificialFrame58 == null) {
                                                                                                                                            objAccessartificialFrame58 = ArtificialStackFrames.coroutineCreation('H' - AndroidCharacter.getMirror('0'), (char) (TextUtils.indexOf((CharSequence) "", '0') + 1), (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 386, 695774916, false, "MediaMetadataCompatBitmapKey", null);
                                                                                                                                        }
                                                                                                                                        Object obj21 = ((Field) objAccessartificialFrame58).get(inputStream4);
                                                                                                                                        try {
                                                                                                                                            Object[] objArr123 = {Integer.valueOf(iIntValue4), inputStream4};
                                                                                                                                            Object objAccessartificialFrame59 = ArtificialStackFrames.accessartificialFrame(-729892777);
                                                                                                                                            if (objAccessartificialFrame59 == null) {
                                                                                                                                                objAccessartificialFrame59 = ArtificialStackFrames.coroutineCreation(24 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (char) (TextUtils.lastIndexOf("", '0', 0) + 53251), KeyEvent.normalizeMetaState(0) + 124, 1260125791, false, "ArtificialStackFrames", new Class[]{Integer.TYPE, InputStream.class});
                                                                                                                                            }
                                                                                                                                            Object objInvoke22 = ((Method) objAccessartificialFrame59).invoke(obj21, objArr123);
                                                                                                                                            Object objAccessartificialFrame60 = ArtificialStackFrames.accessartificialFrame(-1239553844);
                                                                                                                                            if (objAccessartificialFrame60 == null) {
                                                                                                                                                objAccessartificialFrame60 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getLongPressTimeout() >> 16) + 24, (char) KeyEvent.normalizeMetaState(0), 386 - (Process.myTid() >> 22), 695774916, false, "MediaMetadataCompatBitmapKey", null);
                                                                                                                                            }
                                                                                                                                            try {
                                                                                                                                                Object[] objArr124 = {((Field) objAccessartificialFrame60).get(inputStream4)};
                                                                                                                                                Object objAccessartificialFrame61 = ArtificialStackFrames.accessartificialFrame(1328317403);
                                                                                                                                                if (objAccessartificialFrame61 == null) {
                                                                                                                                                    objAccessartificialFrame61 = ArtificialStackFrames.coroutineCreation(14 - TextUtils.indexOf("", "", 0, 0), (char) TextUtils.getTrimmedLength(""), (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 2752, -800471597, false, "ArtificialStackFrames", new Class[]{(Class) ArtificialStackFrames.coroutineCreation('H' - AndroidCharacter.getMirror('0'), (char) ((KeyEvent.getMaxKeyCode() >> 16) + 53250), Color.alpha(0) + 124)});
                                                                                                                                                }
                                                                                                                                                Object objInvoke23 = ((Method) objAccessartificialFrame61).invoke(objInvoke21, objArr124);
                                                                                                                                                try {
                                                                                                                                                    Object[] objArr125 = {objInvoke21, objInvoke22};
                                                                                                                                                    Object objAccessartificialFrame62 = ArtificialStackFrames.accessartificialFrame(1176953419);
                                                                                                                                                    if (objAccessartificialFrame62 == null) {
                                                                                                                                                        objAccessartificialFrame62 = ArtificialStackFrames.coroutineCreation(15 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (char) (ViewConfiguration.getWindowTouchSlop() >> 8), 342 - ((byte) KeyEvent.getModifierMetaStateMask()), -649878461, false, "accessartificialFrame", new Class[]{(Class) ArtificialStackFrames.coroutineCreation(14 - KeyEvent.getDeadChar(0, 0), (char) (Color.rgb(0, 0, 0) + 16777216), (KeyEvent.getMaxKeyCode() >> 16) + 2753), byte[].class});
                                                                                                                                                    }
                                                                                                                                                    objInvoke16 = ((Method) objAccessartificialFrame62).invoke(objInvoke23, objArr125);
                                                                                                                                                    inputStream4.close();
                                                                                                                                                    break;
                                                                                                                                                } catch (Throwable th55) {
                                                                                                                                                    Throwable cause40 = th55.getCause();
                                                                                                                                                    if (cause40 != null) {
                                                                                                                                                        throw cause40;
                                                                                                                                                    }
                                                                                                                                                    throw th55;
                                                                                                                                                }
                                                                                                                                            } catch (Throwable th56) {
                                                                                                                                                Throwable cause41 = th56.getCause();
                                                                                                                                                if (cause41 != null) {
                                                                                                                                                    throw cause41;
                                                                                                                                                }
                                                                                                                                                throw th56;
                                                                                                                                            }
                                                                                                                                        } catch (Throwable th57) {
                                                                                                                                            Throwable cause42 = th57.getCause();
                                                                                                                                            if (cause42 != null) {
                                                                                                                                                throw cause42;
                                                                                                                                            }
                                                                                                                                            throw th57;
                                                                                                                                        }
                                                                                                                                    } catch (Throwable th58) {
                                                                                                                                        Throwable cause43 = th58.getCause();
                                                                                                                                        if (cause43 != null) {
                                                                                                                                            throw cause43;
                                                                                                                                        }
                                                                                                                                        throw th58;
                                                                                                                                    }
                                                                                                                                } catch (Throwable th59) {
                                                                                                                                    Throwable cause44 = th59.getCause();
                                                                                                                                    if (cause44 != null) {
                                                                                                                                        throw cause44;
                                                                                                                                    }
                                                                                                                                    throw th59;
                                                                                                                                }
                                                                                                                            } catch (Exception e4) {
                                                                                                                                try {
                                                                                                                                    Object[] objArr126 = {e4};
                                                                                                                                    Object objAccessartificialFrame63 = ArtificialStackFrames.accessartificialFrame(534109792);
                                                                                                                                    if (objAccessartificialFrame63 == null) {
                                                                                                                                        objAccessartificialFrame63 = ArtificialStackFrames.coroutineCreation(28 - (Process.myTid() >> 22), (char) (TextUtils.lastIndexOf("", '0') + 1), 359 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), -2135910296, false, null, new Class[]{Throwable.class});
                                                                                                                                    }
                                                                                                                                    throw ((Throwable) ((Constructor) objAccessartificialFrame63).newInstance(objArr126));
                                                                                                                                } catch (Throwable th60) {
                                                                                                                                    Throwable cause45 = th60.getCause();
                                                                                                                                    if (cause45 != null) {
                                                                                                                                        throw cause45;
                                                                                                                                    }
                                                                                                                                    throw th60;
                                                                                                                                }
                                                                                                                            }
                                                                                                                        } catch (Throwable th61) {
                                                                                                                            Throwable cause46 = th61.getCause();
                                                                                                                            if (cause46 != null) {
                                                                                                                                throw cause46;
                                                                                                                            }
                                                                                                                            throw th61;
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                                if (objInvoke16 != null) {
                                                                                                                    break;
                                                                                                                }
                                                                                                                i394 = ((i394 | 1) << 1) - (i394 ^ 1);
                                                                                                                i393 = -1239553844;
                                                                                                            }
                                                                                                            if (objInvoke16 == null) {
                                                                                                                listEmptyList = Collections.emptyList();
                                                                                                                break;
                                                                                                            }
                                                                                                            Object objAccessartificialFrame64 = ArtificialStackFrames.accessartificialFrame(-1944720953);
                                                                                                            if (objAccessartificialFrame64 == null) {
                                                                                                                objAccessartificialFrame64 = ArtificialStackFrames.coroutineCreation(21 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 1), Process.getGidForName("") + 3317, 326152143, false, "b", null);
                                                                                                            }
                                                                                                            Object obj22 = ((List) ((Field) objAccessartificialFrame64).get(objInvoke16)).get(1);
                                                                                                            try {
                                                                                                                Object objAccessartificialFrame65 = ArtificialStackFrames.accessartificialFrame(1548792202);
                                                                                                                if (objAccessartificialFrame65 == null) {
                                                                                                                    objAccessartificialFrame65 = ArtificialStackFrames.coroutineCreation(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 11, (char) (ViewConfiguration.getJumpTapTimeout() >> 16), TextUtils.indexOf("", "", 0) + 2694, -1019873406, false, "sendCustomAction", new Class[0]);
                                                                                                                }
                                                                                                                Set set = (Set) ((Method) objAccessartificialFrame65).invoke(obj22, null);
                                                                                                                ArrayList arrayList3 = new ArrayList(set.size());
                                                                                                                for (Object obj23 : set) {
                                                                                                                    Object objAccessartificialFrame66 = ArtificialStackFrames.accessartificialFrame(-2134990334);
                                                                                                                    if (objAccessartificialFrame66 == null) {
                                                                                                                        objAccessartificialFrame66 = ArtificialStackFrames.coroutineCreation(22 - (Process.myTid() >> 22), (char) Gravity.getAbsoluteGravity(0, 0), 3982 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), 534504458, false, "e", null);
                                                                                                                    }
                                                                                                                    byte[] bArr7 = (byte[]) ((Field) objAccessartificialFrame66).get(obj23);
                                                                                                                    Object objAccessartificialFrame67 = ArtificialStackFrames.accessartificialFrame(-2134990334);
                                                                                                                    if (objAccessartificialFrame67 == null) {
                                                                                                                        objAccessartificialFrame67 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getLongPressTimeout() >> 16) + 22, (char) TextUtils.indexOf("", ""), (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 3982, 534504458, false, "e", null);
                                                                                                                    }
                                                                                                                    arrayList3.add(Arrays.copyOf(bArr7, ((byte[]) ((Field) objAccessartificialFrame67).get(obj23)).length));
                                                                                                                }
                                                                                                                listEmptyList = arrayList3;
                                                                                                                r211 = r26;
                                                                                                                r210 = r28;
                                                                                                                break;
                                                                                                            } catch (Throwable th62) {
                                                                                                                Throwable cause47 = th62.getCause();
                                                                                                                if (cause47 != null) {
                                                                                                                    throw cause47;
                                                                                                                }
                                                                                                                throw th62;
                                                                                                            }
                                                                                                        } catch (Throwable th63) {
                                                                                                            Throwable cause48 = th63.getCause();
                                                                                                            if (cause48 != null) {
                                                                                                                throw cause48;
                                                                                                            }
                                                                                                            throw th63;
                                                                                                        }
                                                                                                    } catch (Throwable th64) {
                                                                                                        Throwable cause49 = th64.getCause();
                                                                                                        if (cause49 != null) {
                                                                                                            throw cause49;
                                                                                                        }
                                                                                                        throw th64;
                                                                                                    }
                                                                                                } catch (Throwable th65) {
                                                                                                    Throwable cause50 = th65.getCause();
                                                                                                    if (cause50 != null) {
                                                                                                        throw cause50;
                                                                                                    }
                                                                                                    throw th65;
                                                                                                }
                                                                                            } catch (Throwable th66) {
                                                                                                Throwable cause51 = th66.getCause();
                                                                                                if (cause51 != null) {
                                                                                                    throw cause51;
                                                                                                }
                                                                                                throw th66;
                                                                                            }
                                                                                        } catch (Throwable th67) {
                                                                                            Throwable cause52 = th67.getCause();
                                                                                            if (cause52 != null) {
                                                                                                throw cause52;
                                                                                            }
                                                                                            throw th67;
                                                                                        }
                                                                                    } catch (Exception e5) {
                                                                                        try {
                                                                                            Object[] objArr127 = {e5};
                                                                                            Object objAccessartificialFrame68 = ArtificialStackFrames.accessartificialFrame(534109792);
                                                                                            if (objAccessartificialFrame68 == null) {
                                                                                                objAccessartificialFrame68 = ArtificialStackFrames.coroutineCreation(Process.getGidForName("") + 29, (char) (TextUtils.lastIndexOf("", '0') + 1), 358 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), -2135910296, false, null, new Class[]{Throwable.class});
                                                                                            }
                                                                                            throw ((Throwable) ((Constructor) objAccessartificialFrame68).newInstance(objArr127));
                                                                                        } catch (Throwable th68) {
                                                                                            Throwable cause53 = th68.getCause();
                                                                                            if (cause53 != null) {
                                                                                                throw cause53;
                                                                                            }
                                                                                            throw th68;
                                                                                        }
                                                                                    }
                                                                                } catch (Throwable th69) {
                                                                                    Throwable cause54 = th69.getCause();
                                                                                    if (cause54 != null) {
                                                                                        throw cause54;
                                                                                    }
                                                                                    throw th69;
                                                                                }
                                                                            } catch (Throwable th70) {
                                                                                Throwable cause55 = th70.getCause();
                                                                                if (cause55 != null) {
                                                                                    throw cause55;
                                                                                }
                                                                                throw th70;
                                                                            }
                                                                        } catch (Throwable th71) {
                                                                            Throwable cause56 = th71.getCause();
                                                                            if (cause56 != null) {
                                                                                throw cause56;
                                                                            }
                                                                            throw th71;
                                                                        }
                                                                    } catch (Throwable th72) {
                                                                        Throwable cause57 = th72.getCause();
                                                                        if (cause57 != null) {
                                                                            throw cause57;
                                                                        }
                                                                        throw th72;
                                                                    }
                                                                } catch (Throwable th73) {
                                                                    Throwable cause58 = th73.getCause();
                                                                    if (cause58 != null) {
                                                                        throw cause58;
                                                                    }
                                                                    throw th73;
                                                                }
                                                            } catch (Throwable th74) {
                                                                Throwable cause59 = th74.getCause();
                                                                if (cause59 != null) {
                                                                    throw cause59;
                                                                }
                                                                throw th74;
                                                            }
                                                        } catch (Exception e6) {
                                                            try {
                                                                Object[] objArr128 = {e6};
                                                                Object objAccessartificialFrame69 = ArtificialStackFrames.accessartificialFrame(534109792);
                                                                if (objAccessartificialFrame69 == null) {
                                                                    objAccessartificialFrame69 = ArtificialStackFrames.coroutineCreation(28 - TextUtils.getOffsetAfter("", 0), (char) (ViewConfiguration.getTouchSlop() >> 8), KeyEvent.getDeadChar(0, 0) + 358, -2135910296, false, null, new Class[]{Throwable.class});
                                                                }
                                                                throw ((Throwable) ((Constructor) objAccessartificialFrame69).newInstance(objArr128));
                                                            } catch (Throwable th75) {
                                                                Throwable cause60 = th75.getCause();
                                                                if (cause60 != null) {
                                                                    throw cause60;
                                                                }
                                                                throw th75;
                                                            }
                                                        }
                                                    } catch (Throwable th76) {
                                                        Throwable cause61 = th76.getCause();
                                                        if (cause61 != null) {
                                                            throw cause61;
                                                        }
                                                        throw th76;
                                                    }
                                                }
                                                i387--;
                                            } catch (Throwable th77) {
                                                Throwable cause62 = th77.getCause();
                                                if (cause62 != null) {
                                                    throw cause62;
                                                }
                                                throw th77;
                                            }
                                        }
                                    } catch (Throwable th78) {
                                        Throwable cause63 = th78.getCause();
                                        if (cause63 != null) {
                                            throw cause63;
                                        }
                                        throw th78;
                                    }
                                } catch (Exception unused11) {
                                    listEmptyList = null;
                                    r211 = r26;
                                    r210 = r28;
                                    break;
                                }
                            } catch (Exception unused12) {
                                r26 = r12;
                                r28 = r13;
                            }
                            if (listEmptyList == null && !listEmptyList.isEmpty()) {
                                r211 = r26;
                                r210 = r28;
                                int size3 = listEmptyList.size();
                                Object[] objArr129 = new Object[1];
                                a(new byte[]{0, 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1}, new int[]{0, 19, SyslogConstants.LOG_LOCAL7, 10}, true, objArr129);
                                ?? r2 = (LongBuffer[]) Array.newInstance(Class.forName((String) objArr129[0]), size3);
                                for (int i399 = 0; i399 < listEmptyList.size(); i399 = (((i399 | b.l) << 1) - (i399 ^ b.l)) - 105) {
                                    Object[] objArr130 = {(byte[]) listEmptyList.get(i399)};
                                    Class<?> cls24 = Class.forName(r210);
                                    Object[] objArr131 = new Object[1];
                                    a(new byte[]{0, 1, 1, 1}, new int[]{286, 4, 131, 3}, true, objArr131);
                                    Object objInvoke24 = cls24.getMethod((String) objArr131[0], byte[].class).invoke(null, objArr130);
                                    Class<?> cls25 = Class.forName(r210);
                                    Object[] objArr132 = new Object[1];
                                    a(null, new int[]{290, 12, 140, 7}, true, objArr132);
                                    r2[i399] = cls25.getMethod((String) objArr132[0], null).invoke(objInvoke24, null);
                                }
                                r5 = r211;
                                boolean z9 = false;
                                for (?? r15 : r5) {
                                    r15.rewind();
                                    int length9 = r2.length;
                                    for (int i400 = 0; i400 < length9; i400 = ((i400 & 1) << 1) + (i400 ^ 1)) {
                                        if (r15.equals(r2[i400].rewind())) {
                                            int i401 = artificialFrame + b.f40o;
                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i401 % 128;
                                            z9 = i401 % 2 == 0;
                                        }
                                        r15.rewind();
                                        if (z9) {
                                            break;
                                        }
                                    }
                                }
                                if (!z9) {
                                    int length10 = r2.length;
                                    String string5 = "";
                                    int i402 = 0;
                                    while (i402 < length10) {
                                        ?? r16 = r2[i402];
                                        r16.rewind();
                                        StringBuilder sb2 = new StringBuilder();
                                        sb2.append(string5);
                                        if (r16 != 0) {
                                            string2 = "";
                                            int i403 = 0;
                                            while (true) {
                                                int iBlue = Color.blue(0);
                                                int iINotificationSideChannel12 = SqlDateTypeAdapter.AnonymousClass1.INotificationSideChannel();
                                                int i404 = artificialFrame + 93;
                                                getARTIFICIAL_FRAME_PACKAGE_NAME = i404 % 128;
                                                int i405 = i404 % 2;
                                                int i406 = 659 * iBlue;
                                                int i407 = (i406 ^ (-9855)) + ((i406 & (-9855)) << 1);
                                                int i408 = ~iBlue;
                                                int i409 = ~((i408 & 15) | (i408 ^ 15));
                                                int i410 = ~(((-16) ^ iBlue) | ((-16) & iBlue));
                                                int i411 = (i409 ^ i410) | (i409 & i410);
                                                int i412 = (iINotificationSideChannel12 & iBlue) | (iBlue ^ iINotificationSideChannel12);
                                                int i413 = ~i412;
                                                int i414 = ((i407 + (((i411 ^ i413) | (i411 & i413)) * (-658))) - (~(-(-((~(((-16) ^ iBlue) | ((-16) & iBlue))) * 658))))) - 1;
                                                int i415 = ~(iBlue | (-16));
                                                int i416 = ~i412;
                                                int i417 = (i414 - (~(((i416 & i415) | (i415 ^ i416)) * 658))) - 1;
                                                Object[] objArr133 = new Object[1];
                                                c(i417, new char[]{20794, 4322, 33636, 55455, 18972, 17295, 63872, 20131, 32357, 8626, 48690, 6926, 56076, 31992, 23144, 34195}, objArr133);
                                                Class<?> cls26 = Class.forName((String) objArr133[0]);
                                                i31 = length10;
                                                Object[] objArr134 = new Object[1];
                                                a(new byte[]{0, 1, 0, 0, 1}, new int[]{302, 5, 4, 0}, false, objArr134);
                                                if (i403 < ((Integer) cls26.getMethod((String) objArr134[0], null).invoke(r16, null)).intValue()) {
                                                    StringBuilder sb3 = new StringBuilder();
                                                    sb3.append(string2);
                                                    Object[] objArr135 = {Integer.valueOf(i403)};
                                                    Object[] objArr136 = new Object[1];
                                                    a(new byte[]{0, 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1}, new int[]{0, 19, SyslogConstants.LOG_LOCAL7, 10}, true, objArr136);
                                                    Class<?> cls27 = Class.forName((String) objArr136[0]);
                                                    Object[] objArr137 = new Object[1];
                                                    c(3 - TextUtils.indexOf("", ""), new char[]{53866, 34687, 5394, 44112}, objArr137);
                                                    String str11 = (String) objArr137[0];
                                                    int i418 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                    int i419 = ((i418 | 21) << 1) - (i418 ^ 21);
                                                    artificialFrame = i419 % 128;
                                                    if (i419 % 2 == 0) {
                                                        Class<?>[] clsArr2 = new Class[1];
                                                        clsArr2[1] = Integer.TYPE;
                                                        method = cls27.getMethod(str11, clsArr2);
                                                    } else {
                                                        method = cls27.getMethod(str11, Integer.TYPE);
                                                    }
                                                    long jLongValue4 = ((Long) method.invoke(r16, objArr135)).longValue();
                                                    int i420 = artificialFrame;
                                                    int i421 = ((i420 | 115) << 1) - (i420 ^ 115);
                                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i421 % 128;
                                                    int i422 = i421 % 2;
                                                    Object[] objArr138 = {Long.valueOf(jLongValue4)};
                                                    int i423 = -(KeyEvent.getMaxKeyCode() >> 16);
                                                    Object[] objArr139 = new Object[1];
                                                    c(((i423 | 14) << 1) - (i423 ^ 14), new char[]{20794, 4322, 33636, 55455, 41565, 27421, 37254, 28566, 34439, 38407, 43287, 26265, 18855, 10826}, objArr139);
                                                    Class<?> cls28 = Class.forName((String) objArr139[0]);
                                                    int i424 = -(ViewConfiguration.getKeyRepeatDelay() >> 16);
                                                    Object[] objArr140 = new Object[1];
                                                    c((i424 & 11) + (i424 | 11), new char[]{56090, 24477, Typography.notEqual, 31812, 38990, 40251, 31280, 48988, 64830, 55973, 3405, 65022}, objArr140);
                                                    sb3.append((String) cls28.getMethod((String) objArr140[0], Long.TYPE).invoke(null, objArr138));
                                                    string2 = sb3.toString();
                                                    i403++;
                                                    length10 = i31;
                                                }
                                            }
                                        } else {
                                            i31 = length10;
                                            string2 = "";
                                        }
                                        sb2.append(string2);
                                        String string6 = sb2.toString();
                                        StringBuilder sb4 = new StringBuilder();
                                        sb4.append(string6);
                                        int iIndexOf2 = TextUtils.indexOf("", "", 0, 0);
                                        Object[] objArr141 = new Object[1];
                                        c(((iIndexOf2 | 1) << 1) - (iIndexOf2 ^ 1), new char[]{55917, 7484}, objArr141);
                                        sb4.append((String) objArr141[0]);
                                        string5 = sb4.toString();
                                        int i425 = (i402 ^ (-60)) + ((i402 & (-60)) << 1);
                                        i402 = (i425 & 61) + (i425 | 61);
                                        length10 = i31;
                                    }
                                    strSubstring = "".equals(string5) ? string5 : string5.substring(0, (-2) - (string5.length() ^ (-1)));
                                }
                                if (strSubstring == null) {
                                    r11 = r5;
                                    i4 = i;
                                    i28 = i4;
                                } else {
                                    r11 = r5;
                                    i4 = i;
                                    i28 = (~(i4 & 5)) & (i4 | 5);
                                }
                                if (strSubstring == null) {
                                    r11 = r5;
                                    r11 = r5;
                                    i29 = 0;
                                } else {
                                    r11 = r5;
                                    r11 = r5;
                                    i29 = 16;
                                }
                                objArr4 = new Object[]{new int[]{i28}, new String[]{strSubstring}, new int[1], new int[]{i4}};
                                int startElapsedRealtime2 = (int) Process.getStartElapsedRealtime();
                                int i1210 = ~startElapsedRealtime2;
                                int i1211 = (~((-966450716) | i1210)) | 160612354;
                                int i1310 = ~(startElapsedRealtime2 | (-262629));
                                int i1311 = (-816627191) + ((i1211 | i1310) * (-502)) + ((i1310 | (~(i1210 | (-805838362)))) * TypedValues.PositionType.TYPE_DRAWPATH);
                                int iINotificationSideChannel13 = SqlDateTypeAdapter.AnonymousClass1.INotificationSideChannel();
                                int i1312 = ((i29 * (-344)) - (~(-(-(i1311 * (-344)))))) - 1;
                                int i1313 = ~i29;
                                int i1314 = ~i1311;
                                int i1315 = ~(i1313 | i1314);
                                int i1316 = ~i29;
                                int i1317 = ~(i1316 | iINotificationSideChannel13);
                                int i1318 = -(-(((i1315 ^ i1317) | (i1317 & i1315)) * 345));
                                int i1319 = (i1312 ^ i1318) + ((i1312 & i1318) << 1);
                                int i1410 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                int i1411 = (i1410 & 121) + (i1410 | 121);
                                r29 = r11;
                                artificialFrame = i1411 % 128;
                                int i1412 = i1411 % 2;
                                int i1413 = ~iINotificationSideChannel13;
                                int i1414 = ~((i1413 & i1313) | (i1313 ^ i1413));
                                int i1415 = ~i1311;
                                int i1416 = -(-(345 * ((~((i29 & i1415) | (i1415 ^ i29))) | i1414)));
                                int i1417 = (i1319 & i1416) + (i1416 | i1319);
                                int i1418 = (i1316 ^ i1314) | (i1316 & i1314);
                                int i1419 = -(-((i1417 - (~(-(-((~((i1418 & iINotificationSideChannel13) | (i1418 ^ iINotificationSideChannel13))) * 345))))) - 1));
                                i30 = i3;
                                int i1510 = (i30 & i1419) + (i1419 | i30);
                                int i1511 = i1510 << 13;
                                int i1512 = (i1511 & (~i1510)) | ((~i1511) & i1510);
                                int i1513 = i1512 >>> 17;
                                int i1514 = (i1512 | i1513) & (~(i1512 & i1513));
                                int i1515 = i1514 << 5;
                                int i1516 = (i1514 | i1515) & (~(i1514 & i1515));
                                int i1517 = (i1410 ^ 21) + ((i1410 & 21) << 1);
                                artificialFrame = i1517 % 128;
                                int i1518 = i1517 % 2;
                                ((int[]) objArr4[2])[0] = i1516;
                                objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(682069389);
                                if (objAccessartificialFrame2 == null) {
                                    int packedPositionChild4 = 20 - ExpandableListView.getPackedPositionChild(0L);
                                    char maximumDrawingCacheSize2 = (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                                    int bitsPerPixel3 = 464 - ImageFormat.getBitsPerPixel(0);
                                    byte b8 = (byte) ($$a[11] + 1);
                                    byte b9 = b8;
                                    Object[] objArr510 = new Object[1];
                                    b(b8, b9, b9, objArr510);
                                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(packedPositionChild4, maximumDrawingCacheSize2, bitsPerPixel3, -1211970683, false, (String) objArr510[0], null);
                                }
                                ((Field) objAccessartificialFrame2).set(null, objArr4);
                                if (i4 == i28) {
                                    int i3810 = artificialFrame;
                                    int i3811 = (i3810 & 53) + (i3810 | 53);
                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i3811 % 128;
                                    int i3812 = i3811 % 2;
                                } else {
                                    c = 0;
                                    i6 = 1;
                                    Invoke = i30;
                                    r27 = r210;
                                }
                                return objArr4;
                            }
                            r211 = r26;
                            r210 = r28;
                            r211 = r26;
                            r210 = r28;
                            r5 = r211;
                            strSubstring = null;
                            r11 = r5;
                            if (strSubstring == null) {
                                r11 = r5;
                                i4 = i;
                                i28 = i4;
                            } else {
                                r11 = r5;
                                i4 = i;
                                i28 = (~(i4 & 5)) & (i4 | 5);
                            }
                            if (strSubstring == null) {
                                r11 = r5;
                                r11 = r5;
                                i29 = 0;
                            } else {
                                r11 = r5;
                                r11 = r5;
                                i29 = 16;
                            }
                            objArr4 = new Object[]{new int[]{i28}, new String[]{strSubstring}, new int[1], new int[]{i4}};
                            int startElapsedRealtime3 = (int) Process.getStartElapsedRealtime();
                            int i1212 = ~startElapsedRealtime3;
                            int i1213 = (~((-966450716) | i1212)) | 160612354;
                            int i13110 = ~(startElapsedRealtime3 | (-262629));
                            int i13111 = (-816627191) + ((i1213 | i13110) * (-502)) + ((i13110 | (~(i1212 | (-805838362)))) * TypedValues.PositionType.TYPE_DRAWPATH);
                            int iINotificationSideChannel14 = SqlDateTypeAdapter.AnonymousClass1.INotificationSideChannel();
                            int i13112 = ((i29 * (-344)) - (~(-(-(i13111 * (-344)))))) - 1;
                            int i13113 = ~i29;
                            int i13114 = ~i13111;
                            int i13115 = ~(i13113 | i13114);
                            int i13116 = ~i29;
                            int i13117 = ~(i13116 | iINotificationSideChannel14);
                            int i13118 = -(-(((i13115 ^ i13117) | (i13117 & i13115)) * 345));
                            int i13119 = (i13112 ^ i13118) + ((i13112 & i13118) << 1);
                            int i14110 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                            int i14111 = (i14110 & 121) + (i14110 | 121);
                            r29 = r11;
                            artificialFrame = i14111 % 128;
                            int i14112 = i14111 % 2;
                            int i14113 = ~iINotificationSideChannel14;
                            int i14114 = ~((i14113 & i13113) | (i13113 ^ i14113));
                            int i14115 = ~i13111;
                            int i14116 = -(-(345 * ((~((i29 & i14115) | (i14115 ^ i29))) | i14114)));
                            int i14117 = (i13119 & i14116) + (i14116 | i13119);
                            int i14118 = (i13116 ^ i13114) | (i13116 & i13114);
                            int i14119 = -(-((i14117 - (~(-(-((~((i14118 & iINotificationSideChannel14) | (i14118 ^ iINotificationSideChannel14))) * 345))))) - 1));
                            i30 = i3;
                            int i1519 = (i30 & i14119) + (i14119 | i30);
                            int i15110 = i1519 << 13;
                            int i15111 = (i15110 & (~i1519)) | ((~i15110) & i1519);
                            int i15112 = i15111 >>> 17;
                            int i15113 = (i15111 | i15112) & (~(i15111 & i15112));
                            int i15114 = i15113 << 5;
                            int i15115 = (i15113 | i15114) & (~(i15113 & i15114));
                            int i15116 = (i14110 ^ 21) + ((i14110 & 21) << 1);
                            artificialFrame = i15116 % 128;
                            int i15117 = i15116 % 2;
                            ((int[]) objArr4[2])[0] = i15115;
                            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(682069389);
                            if (objAccessartificialFrame2 == null) {
                                int packedPositionChild5 = 20 - ExpandableListView.getPackedPositionChild(0L);
                                char maximumDrawingCacheSize3 = (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                                int bitsPerPixel4 = 464 - ImageFormat.getBitsPerPixel(0);
                                byte b10 = (byte) ($$a[11] + 1);
                                byte b11 = b10;
                                Object[] objArr511 = new Object[1];
                                b(b10, b11, b11, objArr511);
                                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(packedPositionChild5, maximumDrawingCacheSize3, bitsPerPixel4, -1211970683, false, (String) objArr511[0], null);
                            }
                            ((Field) objAccessartificialFrame2).set(null, objArr4);
                            if (i4 == i28) {
                                int i3813 = artificialFrame;
                                int i3814 = (i3813 & 53) + (i3813 | 53);
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i3814 % 128;
                                int i3815 = i3814 % 2;
                            } else {
                                c = 0;
                                i6 = 1;
                                Invoke = i30;
                                r27 = r210;
                            }
                            return objArr4;
                        } catch (Throwable th79) {
                            Throwable cause64 = th79.getCause();
                            if (cause64 != null) {
                                throw cause64;
                            }
                            throw th79;
                        }
                    }
                    if (context == 0) {
                        Object[] objArr512 = new Object[4];
                        int[] iArr6 = new int[i6];
                        objArr512[c] = iArr6;
                        int[] iArr7 = new int[i6];
                        objArr512[2] = iArr7;
                        int[] iArr8 = new int[i6];
                        objArr512[3] = iArr8;
                        iArr8[0] = i4;
                        iArr6[0] = i4;
                        int i1520 = ~i4;
                        int i1610 = (~((-93693465) | i1520)) | 26279936;
                        int i1611 = ~(134069789 | i4);
                        int i1612 = (Invoke - (~((467975709 + ((i1610 | i1611) * (-502))) + (((~(i1520 | (-67413529))) | i1611) * TypedValues.PositionType.TYPE_DRAWPATH)))) - 1;
                        int i1613 = i1612 << 13;
                        int i1614 = (i1612 | i1613) & (~(i1612 & i1613));
                        int i1615 = i1614 ^ (i1614 >>> 17);
                        iArr7[0] = i1615 ^ (i1615 << 5);
                        objArr512[1] = null;
                        return objArr512;
                    }
                    r3 = r29;
                    bArr = new byte[r3.length][];
                    length = r3.length;
                    i7 = 0;
                    i8 = 0;
                    while (i7 < length) {
                        r10 = r3[i7];
                        int i1616 = -(PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                        Object[] objArr513 = new Object[1];
                        c((i1616 ^ 15) + ((i1616 & 15) << 1), new char[]{20794, 4322, 33636, 55455, 18972, 17295, 63872, 20131, 32357, 8626, 48690, 6926, 56076, 31992, 23144, 34195}, objArr513);
                        cls3 = Class.forName((String) objArr513[0]);
                        int i1617 = length;
                        objArr5 = new Object[1];
                        a(new byte[]{0, 0, 0, 1, 1, 0, 0, 1}, new int[]{307, 8, 187, 6}, true, objArr5);
                        if (((Integer) cls3.getMethod((String) objArr5[0], null).invoke(r10, null)).intValue() == 4) {
                            int i1618 = artificialFrame;
                            int i1619 = (i1618 ^ 85) + ((i1618 & 85) << 1);
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i1619 % 128;
                            int i1710 = i1619 % 2;
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!(!z)) {
                            ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(32);
                            Class<?> cls110 = Class.forName(r27);
                            Object[] objArr514 = new Object[1];
                            a(null, new int[]{290, 12, 140, 7}, true, objArr514);
                            longBuffer = (LongBuffer) cls110.getMethod((String) objArr514[0], null).invoke(byteBufferAllocate2, null);
                            jArrArray = r10.array();
                            length3 = jArrArray.length;
                            while (i27 < length3) {
                                longBuffer.put(jArrArray[i27]);
                            }
                            bArr[i8] = byteBufferAllocate2.array();
                            i8++;
                        }
                        i7++;
                        length = i1617;
                    }
                    if (i8 > 0) {
                        strArr3 = new String[1][];
                        int iCurrentTimeMillis2 = (int) System.currentTimeMillis();
                        int i1711 = (iCurrentTimeMillis2 | 343337308) & (~(iCurrentTimeMillis2 & 343337308));
                        Object[] objArr515 = {Integer.valueOf((~(i4 & i1711)) & (i4 | i1711)), bArr, Integer.valueOf(i8), Integer.valueOf(i2), strArr3};
                        objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1514071993);
                        if (objAccessartificialFrame == null) {
                            int iIndexOf3 = TextUtils.indexOf("", "", 0, 0) + 21;
                            char cIndexOf2 = (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0));
                            int bitsPerPixel5 = 464 - ImageFormat.getBitsPerPixel(0);
                            byte b12 = $$a[11];
                            byte b13 = b12;
                            Object[] objArr516 = new Object[1];
                            b(b12, b13, b13, objArr516);
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(iIndexOf3, cIndexOf2, bitsPerPixel5, 983850575, false, (String) objArr516[0], new Class[]{Integer.TYPE, byte[][].class, Integer.TYPE, Integer.TYPE, String[][].class});
                        }
                        long jLongValue5 = ((Long) ((Method) objAccessartificialFrame).invoke(null, objArr515)).longValue();
                        long j12 = -553755991;
                        long j13 = 193;
                        long j14 = i4;
                        str = "";
                        long j15 = -1;
                        long j16 = j14 ^ j15;
                        long j17 = j12 ^ j15;
                        long j18 = (j13 * j12) + (j13 * jLongValue5) + (((long) (-192)) * (j16 | ((j17 | jLongValue5) ^ j15)));
                        long j19 = jLongValue5 ^ j15;
                        long j20 = j17 | j19;
                        long j110 = j19 | j16;
                        long j111 = j18 + (((long) (-384)) * ((j20 ^ j15) | (j110 ^ j15))) + (((long) JfifUtil.MARKER_SOFn) * (((j20 | j14) ^ j15) | ((j110 | j12) ^ j15) | (((jLongValue5 | j12) | j14) ^ j15))) + ((long) (-1408458699));
                        i23 = ~i4;
                        int i1712 = ~((-1633642444) | i23);
                        int i1713 = ~(196416032 | i4);
                        int i1714 = ((int) (j111 >> 32)) & ((-334238508) + ((i1712 | i1713) * 1150) + (((~((-196416033) | i23)) | i1713) * (-575)) + (((~((-1633642444) | i4)) | (~(1633642443 | i23))) * 575));
                        int i1715 = (int) j111;
                        int iElapsedRealtime2 = (int) SystemClock.elapsedRealtime();
                        int i1716 = ~iElapsedRealtime2;
                        int i1717 = (-1880002655) + (((~((-1869509451) | i1716)) | 155455744) * (-1188));
                        int i1718 = (~(iElapsedRealtime2 | 1869509450)) | 155455744;
                        int i1719 = ~(432283040 | i1716);
                        int i1810 = i1715 & (i1717 + ((i1718 | i1719) * 594) + (((~(1869509450 | i1716)) | (-2146336747) | i1719) * 594));
                        i24 = ((i1810 & i1714) | (i1714 ^ i1810)) ^ i1711;
                        if ((i2 & 1) != 1 && ((~(i24 & i4)) & (i24 | i4)) == 15) {
                            Object[] objArr142 = new Object[4];
                            objArr142[0] = new int[]{i24};
                            objArr142[2] = new int[1];
                            objArr142[3] = new int[]{i4};
                            int i426 = 1748079833 + ((934208126 | i4) * (-676)) + (((~(548331610 | i23)) | (-934208127)) * 676) + (((~(387981884 | i23)) | 546226242 | (~((-385876517) | i4))) * 676);
                            int i427 = ((i426 | 16) << 1) - (i426 ^ 16);
                            int iINotificationSideChannel15 = SqlDateTypeAdapter.AnonymousClass1.INotificationSideChannel();
                            int i428 = i427 * (-661);
                            int i429 = -(-(i3 * (-661)));
                            int i430 = (i428 ^ i429) + ((i428 & i429) << 1);
                            int i431 = ((~iINotificationSideChannel15) | (~((~i427) | (~i3)))) * 1324;
                            int i432 = (i430 ^ i431) + ((i431 & i430) << 1);
                            int i433 = ~(i427 | iINotificationSideChannel15);
                            int i434 = ~((iINotificationSideChannel15 & i3) | (i3 ^ iINotificationSideChannel15));
                            int i435 = -(-(((i434 & i433) | (i433 ^ i434)) * (-1324)));
                            int i436 = ((i432 | i435) << 1) - (i435 ^ i432);
                            int i437 = ~i427;
                            int i438 = ~((i437 & i3) | (i437 ^ i3));
                            int i439 = ~i3;
                            int i440 = ~((i427 & i439) | (i439 ^ i427));
                            int i441 = (i436 - (~(((i440 & i438) | (i438 ^ i440)) * 662))) - 1;
                            int i442 = (i441 << 13) ^ i441;
                            int i443 = i442 ^ (i442 >>> 17);
                            int i444 = i443 << 5;
                            ((int[]) objArr142[2])[0] = ((~i443) & i444) | ((~i444) & i443);
                            objArr142[1] = null;
                            return objArr142;
                        }
                        i25 = i3;
                        i26 = (i24 & i23) | ((~i24) & i4);
                        if (i26 == 17) {
                            Object[] objArr610 = {new int[]{i24}, strArr3[0], new int[1], new int[]{i4}};
                            int iNextInt2 = new Random().nextInt(1371143253);
                            int i1811 = ~iNextInt2;
                            int i1812 = (-1213847242) + (((~(608852493 | i1811)) | 769202219) * (-90)) + (((~(608852493 | iNextInt2)) | 147972) * (-45)) + (((~(iNextInt2 | (-769202220))) | 608852493 | (~(i1811 | 769202219))) * 45) + 16;
                            int i1813 = ((i25 == true ? 1 : 0) ^ i1812) + (((i25 == true ? 1 : 0) & i1812) << 1);
                            int i1814 = i1813 << 13;
                            int i1815 = (i1813 | i1814) & (~(i1813 & i1814));
                            int i1816 = i1815 >>> 17;
                            int i1817 = ((~i1815) & i1816) | ((~i1816) & i1815);
                            ((int[]) objArr610[2])[0] = i1817 ^ (i1817 << 5);
                            return objArr610;
                        }
                        if (((~(i24 & i4)) & (i24 | i4)) == 0) {
                            Object[] objArr611 = {new int[]{i24}, null, new int[]{(i205 | i206) & (~(i205 & i206))}, new int[]{i4}};
                            int i1818 = ((((~(i4 | 59521427)) | 100828298) * 56) - 1718705691) + ((59521427 | (~(100828298 | i23))) * 56);
                            int i1819 = i1818 * 370;
                            int i1910 = ((i1818 ^ i23) | (i23 & i1818)) * (-369);
                            int i1911 = (i1819 ^ i1910) + ((i1819 & i1910) << 1);
                            int i1912 = ~i4;
                            int i1913 = ~(i1912 | ((-1) ^ i1912));
                            int i1914 = i1911 + (((i1913 & i1818) | (i1818 ^ i1913)) * (-369));
                            int i1915 = ~(~i1818);
                            int i1916 = ~i4;
                            int i1917 = (i1915 & i1916) | (i1915 ^ i1916);
                            int i1918 = ~(i1818 | ((-1) ^ i1818));
                            int i1919 = ((i1917 & i1918) | (i1917 ^ i1918)) * 369;
                            int i2010 = (i1914 ^ i1919) + ((i1919 & i1914) << 1);
                            int i2011 = (((i25 == true ? 1 : 0) | i2010) << 1) - (i2010 ^ (i25 == true ? 1 : 0));
                            int i2012 = i2011 << 13;
                            int i2013 = ((~i2011) & i2012) | ((~i2012) & i2011);
                            int i2014 = i2013 >>> 17;
                            int i2015 = ((~i2013) & i2014) | ((~i2014) & i2013);
                            int i2016 = i2015 << 5;
                            return objArr611;
                        }
                        if (i26 == 11) {
                            Invoke = i26;
                            r6 = i25;
                            objArr4 = new Object[]{new int[]{i24}, strArr3[0], new int[]{i209 ^ (i209 << 5)}, new int[]{i4}};
                            int i2017 = ((i25 == true ? 1 : 0) - (~(((729202488 + (((~((-167779871) | i4)) | (~((-7430145) | i4))) * 69)) + ((((~((-1049108479) | i4)) | 881328608) | (~((-888758753) | i4))) * (-69))) + 113279061))) - 1;
                            int i2018 = i2017 ^ (i2017 << 13);
                            int i2019 = i2018 ^ (i2018 >>> 17);
                            return objArr4;
                        }
                    } else {
                        r6 = Invoke;
                        str = "";
                        Invoke = Invoke;
                    }
                    Invoke = i26;
                    r6 = i25;
                    int i2110 = -Color.blue(0);
                    Object[] objArr612 = new Object[1];
                    c((i2110 & 23) + (i2110 | 23), new char[]{37254, 28566, 39408, 9603, 19947, 34441, 40540, 33064, 3405, 52960, 3224, 8817, 19934, 59436, 43728, 50638, 38455, 41647, 3224, 8817, 42949, 16154, 5394, 44112}, objArr612);
                    Class<?> cls111 = Class.forName((String) objArr612[0]);
                    int i2111 = -View.MeasureSpec.makeMeasureSpec(0, 0);
                    int i2112 = (i2111 * (-711)) + 12121;
                    int i2113 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                    int i2210 = ((i2113 | 7) << 1) - (i2113 ^ 7);
                    artificialFrame = i2210 % 128;
                    int i2211 = i2210 % 2;
                    int i2212 = ~(((-18) ^ i2111) | ((-18) & i2111));
                    i9 = ~i4;
                    int i2213 = ~((i9 ^ i2111) | (i9 & i2111));
                    int i2214 = (-712) * ((i2212 & i2213) | (i2212 ^ i2213));
                    int i2215 = (i2112 ^ i2214) + ((i2112 & i2214) << 1);
                    i10 = ~i4;
                    int i2216 = ((-18) & i10) | ((-18) ^ i10);
                    int i2217 = ~((i2216 & i2111) | (i2216 ^ i2111));
                    int i2218 = ~((i2111 ^ 17) | (i2111 & 17) | i4);
                    int i2219 = (i2215 - (~(((i2217 & i2218) | (i2217 ^ i2218)) * (-712)))) - 1;
                    int i2310 = ~((i2111 & i10) | (i10 ^ i2111));
                    Object[] objArr613 = new Object[1];
                    c((i2219 - (~(((i2310 & (-18)) | ((-18) ^ i2310)) * 712))) - 1, new char[]{53866, 34687, 55204, 17900, 1308, 17685, 46884, 6988, 53866, 34687, 21752, 41224, 18764, 26637, 53866, 34687, 23144, 34195}, objArr613);
                    Invoke = cls111.getMethod((String) objArr613[0], null).invoke(context, null);
                    int i2311 = -(ViewConfiguration.getMinimumFlingVelocity() >> 16);
                    int i2312 = i2311 * 319;
                    int i2313 = (i2312 ^ (-7291)) + ((i2312 & (-7291)) << 1);
                    int i2314 = ~i2311;
                    int i2315 = i2313 + (((~((i2314 & i4) | (i2314 ^ i4))) | (-24)) * (-318));
                    int i2316 = ~((-24) | i4);
                    int i2317 = ~((i9 ^ i2311) | (i9 & i2311) | 23);
                    int i2318 = i2315 + (((i2316 & i2317) | (i2316 ^ i2317)) * TypedValues.AttributesType.TYPE_PIVOT_TARGET);
                    int i2319 = ((-24) & i9) | ((-24) ^ i9);
                    int i2410 = ~((i2319 & i2311) | (i2319 ^ i2311));
                    int i2411 = (i2311 & 23) | (i2311 ^ 23);
                    int i2412 = ~((i2411 & i4) | (i2411 ^ i4));
                    int i2413 = ((i2412 & i2410) | (i2410 ^ i2412)) * TypedValues.AttributesType.TYPE_PIVOT_TARGET;
                    Object[] objArr614 = new Object[1];
                    c((i2318 ^ i2413) + ((i2413 & i2318) << 1), new char[]{37254, 28566, 39408, 9603, 19947, 34441, 40540, 33064, 3405, 52960, 3224, 8817, 19934, 59436, 43728, 50638, 38455, 41647, 3224, 8817, 42949, 16154, 5394, 44112}, objArr614);
                    Class<?> cls112 = Class.forName((String) objArr614[0]);
                    Object[] objArr615 = new Object[1];
                    a(new byte[]{1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1}, new int[]{315, 14, 0, 3}, false, objArr615);
                    Object[] objArr616 = {cls112.getMethod((String) objArr615[0], null).invoke(context, null), 64};
                    Object[] objArr617 = new Object[1];
                    a(new byte[]{1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0}, new int[]{329, 33, 93, 17}, false, objArr617);
                    Class<?> cls113 = Class.forName((String) objArr617[0]);
                    Object[] objArr618 = new Object[1];
                    a(new byte[]{0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1}, new int[]{362, 14, 163, 0}, false, objArr618);
                    objInvoke = cls113.getMethod((String) objArr618[0], String.class, Integer.TYPE).invoke(Invoke, objArr616);
                    linkedHashSet = new LinkedHashSet();
                    int length11 = r3.length;
                    i11 = 0;
                    r4 = r3;
                    Invoke = length11;
                    r7 = r6;
                    while (i11 < Invoke) {
                        r9 = r4[i11];
                        Object[] objArr619 = new Object[1];
                        c((ViewConfiguration.getTapTimeout() >> 16) + 15, new char[]{20794, 4322, 33636, 55455, 18972, 17295, 63872, 20131, 32357, 8626, 48690, 6926, 56076, 31992, 23144, 34195}, objArr619);
                        cls = Class.forName((String) objArr619[0]);
                        ?? r213 = r4;
                        objArr2 = new Object[1];
                        a(new byte[]{0, 0, 0, 1, 1, 0, 0, 1}, new int[]{307, 8, 187, 6}, true, objArr2);
                        if (((Integer) cls.getMethod((String) objArr2[0], null).invoke(r9, null)).intValue() == 4) {
                            Object[] objArr710 = new Object[1];
                            a(new byte[]{1, 1, 1, 0, 1, 1, 1}, new int[]{138, 7, 0, 7}, false, objArr710);
                            str2 = (String) objArr710[0];
                        } else {
                            int i2414 = -(KeyEvent.getMaxKeyCode() >> 16);
                            int iINotificationSideChannel16 = SqlDateTypeAdapter.AnonymousClass1.INotificationSideChannel();
                            int i2415 = ~i2414;
                            int i2416 = ~iINotificationSideChannel16;
                            int i2417 = ~((i2415 ^ i2416) | (i2416 & i2415));
                            int i2418 = (i2415 ^ 3) | (i2415 & 3);
                            int i2419 = ~i2418;
                            int i2510 = (i2417 ^ i2419) | (i2419 & i2417);
                            int i2511 = ~((~iINotificationSideChannel16) | 3);
                            int i2512 = (((i2414 * 398) - 1188) - (~(((i2510 ^ i2511) | (i2510 & i2511)) * (-397)))) - 1;
                            int i2513 = (~i2418) * (-397);
                            int i2514 = (i2512 & i2513) + (i2513 | i2512);
                            int i2515 = ~((i2415 ^ 3) | (i2415 & 3));
                            int i2516 = (i2515 & iINotificationSideChannel16) | (iINotificationSideChannel16 ^ i2515);
                            int i2517 = ~((i2414 & (-4)) | ((-4) ^ i2414));
                            int i2518 = i2516 ^ i2517;
                            Object[] objArr711 = new Object[1];
                            c((i2514 - (~(-(-(((i2517 & i2516) | i2518) * 397))))) - 1, new char[]{29921, 63486, 64688, 55477}, objArr711);
                            str2 = (String) objArr711[0];
                        }
                        Object[] objArr712 = new Object[1];
                        a(new byte[]{1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1}, new int[]{376, 30, 0, 0}, false, objArr712);
                        Class<?> cls114 = Class.forName((String) objArr712[0]);
                        int i2519 = -View.MeasureSpec.getSize(0);
                        int iINotificationSideChannel17 = SqlDateTypeAdapter.AnonymousClass1.INotificationSideChannel();
                        int i2610 = i2519 * 866;
                        int i2611 = ((i2610 | (-8640)) << 1) - (i2610 ^ (-8640));
                        int i2612 = artificialFrame;
                        int i2613 = (i2612 ^ 49) + ((i2612 & 49) << 1);
                        int i2614 = i2613 % 128;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i2614;
                        int i2615 = i2613 % 2;
                        int i2616 = i11;
                        int i2617 = ~((~iINotificationSideChannel17) | (~i2519));
                        int i2618 = (-865) * (((-11) ^ i2617) | (i2617 & (-11)));
                        int i2619 = (i2611 & i2618) + (i2611 | i2618);
                        int i2710 = (~((i2519 ^ iINotificationSideChannel17) | (i2519 & iINotificationSideChannel17))) * 865;
                        int i2711 = (i2619 & i2710) + (i2619 | i2710);
                        int i2712 = ~iINotificationSideChannel17;
                        int i2713 = ~(((-11) ^ i2712) | ((-11) & i2712));
                        int i2714 = ~((i2712 & i2519) | (i2712 ^ i2519));
                        int i2715 = -(-(((i2714 & i2713) | (i2713 ^ i2714)) * 865));
                        int i2716 = (i2711 ^ i2715) + ((i2711 & i2715) << 1);
                        int i2717 = ((i2614 | 5) << 1) - (i2614 ^ 5);
                        artificialFrame = i2717 % 128;
                        int i2718 = i2717 % 2;
                        Object[] objArr713 = new Object[1];
                        c(i2716, new char[]{18119, 44752, 14387, 11769, 59984, 13011, 30482, 35605, 21275, 48028}, objArr713);
                        Object[] objArr714 = (Object[]) cls114.getField((String) objArr713[0]).get(objInvoke);
                        length2 = objArr714.length;
                        i14 = 0;
                        Invoke = objArr714;
                        r8 = r7;
                        while (i14 < length2) {
                            ?? r17 = Invoke[i14];
                            Object[] objArr715 = {str2};
                            int deadChar2 = KeyEvent.getDeadChar(0, 0);
                            int i2719 = deadChar2 * (-743);
                            obj2 = objInvoke;
                            int i2810 = ((i2719 | (-20061)) << 1) - (i2719 ^ (-20061));
                            int i2811 = (deadChar2 ^ 27) | (deadChar2 & 27);
                            str3 = str2;
                            r46 = Invoke;
                            int i2812 = (~i2811) | (~((deadChar2 ^ i4) | (deadChar2 & i4)));
                            int i2813 = ~((i4 ^ 27) | (i4 & 27));
                            int i2814 = ((i2812 ^ i2813) | (i2812 & i2813)) * (-744);
                            int i2815 = (i2810 & i2814) + (i2810 | i2814);
                            int i2816 = ~deadChar2;
                            int i2817 = ~((i2816 & (-28)) | (i2816 ^ (-28)));
                            int i2818 = ((i2817 & i9) | (i9 ^ i2817)) * 744;
                            Object[] objArr716 = new Object[1];
                            c((((i2815 & i2818) + (i2818 | i2815)) - (~(-(-(((i2811 ^ i4) | (i2811 & i4)) * 744))))) - 1, new char[]{20794, 4322, 33636, 55455, 11143, 59227, 29278, 55764, 30482, 35605, 23247, 20961, 62390, 21178, 38011, 56431, 30316, 50537, 41530, 38433, 'T', 5334, 18542, 5203, 21275, 48028, 5394, 44112}, objArr716);
                            String str12 = str5;
                            Invoke = 0;
                            Object objInvoke25 = Class.forName((String) objArr716[0]).getMethod(str12, String.class).invoke(null, objArr715);
                            Invoke = 28;
                            str5 = str12;
                            Object[] objArr717 = new Object[1];
                            a(new byte[]{0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0}, new int[]{406, 28, 0, 27}, false, objArr717);
                            Class<?> cls115 = Class.forName((String) objArr717[0]);
                            i15 = length2;
                            Object[] objArr718 = new Object[1];
                            a(new byte[]{0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0}, new int[]{434, 11, 102, 0}, false, objArr718);
                            Invoke = (String) objArr718[0];
                            Object objInvoke26 = cls115.getMethod(Invoke, null).invoke(r17, null);
                            int i2819 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                            int i2910 = (i2819 ^ 57) + ((i2819 & 57) << 1);
                            artificialFrame = i2910 % 128;
                            int i2911 = i2910 % 2;
                            Object[] objArr719 = {objInvoke26};
                            int i2912 = -(-(ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)));
                            Object[] objArr810 = new Object[1];
                            c((i2912 ^ 26) + ((i2912 & 26) << 1), new char[]{20794, 4322, 33636, 55455, 11143, 59227, 29278, 55764, 30482, 35605, 23247, 20961, 62390, 21178, 38011, 56431, 30316, 50537, 41530, 38433, 'T', 5334, 18542, 5203, 21275, 48028, 5394, 44112}, objArr810);
                            Class<?> cls116 = Class.forName((String) objArr810[0]);
                            int i2913 = -View.MeasureSpec.makeMeasureSpec(0, 0);
                            int iINotificationSideChannel18 = SqlDateTypeAdapter.AnonymousClass1.INotificationSideChannel();
                            int i2914 = i2913 * (-919);
                            int i2915 = ((i2914 | (-5514)) << 1) - (i2914 ^ (-5514));
                            int i2916 = ~i2913;
                            int i2917 = (i2916 ^ (-7)) | (i2916 & (-7));
                            int i2918 = ~((i2917 ^ iINotificationSideChannel18) | (i2917 & iINotificationSideChannel18));
                            i16 = i9;
                            int i2919 = ~iINotificationSideChannel18;
                            int i3010 = (-7) | i2919;
                            i17 = i14;
                            int i3011 = ~((i3010 ^ i2913) | (i3010 & i2913));
                            int i3012 = ((i2918 ^ i3011) | (i3011 & i2918)) * 920;
                            int i3013 = ((i2915 | i3012) << 1) - (i3012 ^ i2915);
                            int i3014 = ~i2913;
                            int i3015 = ~((i3014 ^ (-7)) | (i3014 & (-7)));
                            int i3016 = ~iINotificationSideChannel18;
                            int i3017 = -(-(((~((i3014 ^ i3016) | (i3016 & i3014))) | i3015) * 920));
                            int i3018 = (i3013 ^ i3017) + ((i3017 & i3013) << 1);
                            int i3019 = (i3014 ^ (-7)) | (i3014 & (-7));
                            int i3110 = ~((i3019 & i2919) | (i3019 ^ i2919));
                            int i3111 = (i2916 ^ 6) | (i2916 & 6);
                            int i3112 = ~((i3111 & iINotificationSideChannel18) | (i3111 ^ iINotificationSideChannel18));
                            int i3113 = (i3110 & i3112) | (i3110 ^ i3112);
                            int i3114 = (-7) | i2913;
                            int i3115 = ~((i3114 & iINotificationSideChannel18) | (i3114 ^ iINotificationSideChannel18));
                            Object[] objArr811 = new Object[1];
                            c(i3018 + (((i3115 & i3113) | (i3113 ^ i3115)) * 920), new char[]{53560, 53417, 53866, 34687, 14879, 640}, objArr811);
                            Invoke = cls116.getMethod((String) objArr811[0], byte[].class);
                            Object[] objArr812 = {Invoke.invoke(objInvoke25, objArr719)};
                            Class<?> cls117 = Class.forName(r27);
                            Object[] objArr813 = new Object[1];
                            a(new byte[]{0, 1, 1, 1}, new int[]{286, 4, 131, 3}, true, objArr813);
                            Invoke = 0;
                            Invoke = 0;
                            Invoke = 0;
                            Object objInvoke27 = cls117.getMethod((String) objArr813[0], byte[].class).invoke(null, objArr812);
                            Class<?> cls29 = Class.forName(r27);
                            Object[] objArr814 = new Object[1];
                            a(null, new int[]{290, 12, 140, 7}, true, objArr814);
                            i18 = 0;
                            objInvoke2 = cls29.getMethod((String) objArr814[0], null).invoke(objInvoke27, null);
                            if (objInvoke2 != null) {
                                i22 = 0;
                                string = str;
                                str4 = string;
                                while (true) {
                                    int i3116 = -TextUtils.getOffsetAfter(str4, i18);
                                    Object[] objArr815 = new Object[1];
                                    c((i3116 & 15) + (i3116 | 15), new char[]{20794, 4322, 33636, 55455, 18972, 17295, 63872, 20131, 32357, 8626, 48690, 6926, 56076, 31992, 23144, 34195}, objArr815);
                                    cls2 = Class.forName((String) objArr815[0]);
                                    objArr3 = new Object[1];
                                    a(new byte[]{0, 1, 0, 0, 1}, new int[]{302, 5, 4, 0}, false, objArr3);
                                    if (i22 >= ((Integer) cls2.getMethod((String) objArr3[0], null).invoke(objInvoke2, null)).intValue()) {
                                        break;
                                        break;
                                    }
                                    StringBuilder sb5 = new StringBuilder();
                                    sb5.append(string);
                                    Object[] objArr816 = {Integer.valueOf(i22)};
                                    Object[] objArr817 = new Object[1];
                                    a(new byte[]{0, 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1}, new int[]{0, 19, SyslogConstants.LOG_LOCAL7, 10}, true, objArr817);
                                    Class<?> cls210 = Class.forName((String) objArr817[0]);
                                    int i3117 = -(-KeyEvent.normalizeMetaState(0));
                                    Object[] objArr818 = new Object[1];
                                    c(((i3117 | 3) << 1) - (i3117 ^ 3), new char[]{53866, 34687, 5394, 44112}, objArr818);
                                    Object[] objArr819 = {Long.valueOf(((Long) cls210.getMethod((String) objArr818[0], Integer.TYPE).invoke(objInvoke2, objArr816)).longValue())};
                                    Object[] objArr910 = new Object[1];
                                    c(13 - (~(-Drawable.resolveOpacity(0, 0))), new char[]{20794, 4322, 33636, 55455, 41565, 27421, 37254, 28566, 34439, 38407, 43287, 26265, 18855, 10826}, objArr910);
                                    Class<?> cls211 = Class.forName((String) objArr910[0]);
                                    int jumpTapTimeout2 = ViewConfiguration.getJumpTapTimeout() >> 16;
                                    int iINotificationSideChannel19 = SqlDateTypeAdapter.AnonymousClass1.INotificationSideChannel();
                                    int i3118 = jumpTapTimeout2 * 934;
                                    int i3119 = ((i3118 | (-10252)) << 1) - (i3118 ^ (-10252));
                                    int i3210 = ~jumpTapTimeout2;
                                    int i3211 = ~iINotificationSideChannel19;
                                    int i3212 = ~((i3210 ^ i3211) | (i3211 & i3210));
                                    int i3213 = (i3119 - (~((((-12) ^ i3212) | (i3212 & (-12))) * (-933)))) - 1;
                                    int i3214 = ~iINotificationSideChannel19;
                                    int i3215 = ~(((-12) ^ i3214) | (i3214 & (-12)));
                                    int i3216 = ~((-12) | jumpTapTimeout2);
                                    int i3217 = i3213 + (((i3215 & i3216) | (i3215 ^ i3216)) * 933);
                                    int i3218 = (~((jumpTapTimeout2 & 11) | (jumpTapTimeout2 ^ 11))) * 933;
                                    Object[] objArr911 = new Object[1];
                                    c((i3217 & i3218) + (i3217 | i3218), new char[]{56090, 24477, Typography.notEqual, 31812, 38990, 40251, 31280, 48988, 64830, 55973, 3405, 65022}, objArr911);
                                    sb5.append((String) cls211.getMethod((String) objArr911[0], Long.TYPE).invoke(null, objArr819));
                                    string = sb5.toString();
                                    i22 = ((i22 | 1) << 1) - (i22 ^ 1);
                                    i18 = 0;
                                }
                            } else {
                                str4 = str;
                                string = str4;
                            }
                            linkedHashSet.add(string);
                            if (objInvoke2.equals(r9.rewind())) {
                                int iINotificationSideChannel20 = SqlDateTypeAdapter.AnonymousClass1.INotificationSideChannel();
                                int i3219 = ~iINotificationSideChannel20;
                                int i3310 = ~(((-1172061424) & i3219) | ((-1172061424) ^ i3219));
                                int i3311 = ~((1910321450 ^ iINotificationSideChannel20) | (1910321450 & iINotificationSideChannel20));
                                int i3312 = ((i3310 & i3311) | (i3310 ^ i3311)) * 333;
                                int i3313 = ((-185130971) ^ i3312) + ((i3312 & (-185130971)) << 1);
                                int i3314 = ((~((iINotificationSideChannel20 & (-1172061424)) | ((-1172061424) ^ iINotificationSideChannel20))) | (~((i3219 & 1910321450) | (i3219 ^ 1910321450)))) * 333;
                                i19 = ((i3313 | i3314) << 1) - (i3314 ^ i3313);
                                int iINotificationSideChannel110 = SqlDateTypeAdapter.AnonymousClass1.INotificationSideChannel();
                                int i3315 = ~((1618314597 & iINotificationSideChannel110) | (1618314597 ^ iINotificationSideChannel110));
                                i20 = -(-(((i3315 & 481085041) | (481085041 ^ i3315)) * (-964)));
                                int i3316 = ~iINotificationSideChannel110;
                                i21 = ~((i3316 & 1618314597) | (1618314597 ^ i3316));
                                if (i19 <= (((1122935188 ^ i20) + ((i20 & 1122935188) << 1)) - (~(-(-(((i21 & 478691856) | (i21 ^ 478691856)) * (-964)))))) - 1) {
                                    objArr = new Object[3];
                                    objArr[1] = new int[1];
                                } else {
                                    objArr = new Object[4];
                                    objArr[0] = new int[1];
                                }
                                objArr[2] = new int[1];
                                objArr[3] = new int[]{i4};
                                int[] iArr9 = (int[]) objArr[0];
                                int i3317 = artificialFrame + 49;
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i3317 % 128;
                                int i3318 = i3317 % 2;
                                iArr9[0] = i4;
                                int i3319 = (~(177675197 | i4)) | (~(338024923 | i10));
                                int i3410 = ~((-177675198) | i10);
                                int i3411 = 347059641 + ((i3319 | i3410) * (-516)) + (((~((-337690691) | i4)) | (~((-334234) | i10))) * 516) + ((334233 | i3410) * 516);
                                int i3412 = (i3411 << 1) - i3411;
                                int iINotificationSideChannel111 = SqlDateTypeAdapter.AnonymousClass1.INotificationSideChannel();
                                int i3413 = i3412 * (-963);
                                int i3414 = (((i3413 ^ (-964)) + ((i3413 & (-964)) << 1)) - (~(i3 * 965))) - 1;
                                int i3415 = ~i3412;
                                int i3416 = ~i3;
                                int i3417 = ~((i3416 ^ iINotificationSideChannel111) | (i3416 & iINotificationSideChannel111));
                                int i3418 = (i3414 - (~(-(-(((i3415 & i3417) | (i3415 ^ i3417)) * (-964)))))) - 1;
                                int i3419 = ~iINotificationSideChannel111;
                                int i3510 = ~((i3419 & i3416) | (i3416 ^ i3419));
                                int i3511 = ~i3;
                                int i3512 = ~((i3412 & i3511) | (i3511 ^ i3412));
                                int i3513 = ((i3512 & i3510) | (i3510 ^ i3512)) * (-964);
                                int i3514 = ((i3418 | i3513) << 1) - (i3513 ^ i3418);
                                int i3515 = (i3514 << 13) ^ i3514;
                                int i3516 = i3515 >>> 17;
                                int i3517 = (i3515 | i3516) & (~(i3515 & i3516));
                                int i3518 = i3517 << 5;
                                ((int[]) objArr[2])[0] = ((~i3517) & i3518) | ((~i3518) & i3517);
                                objArr[1] = null;
                                return objArr;
                            }
                            i14 = i17 + 1;
                            objInvoke = obj2;
                            str2 = str3;
                            r8 = i3;
                            str = str4;
                            length2 = i15;
                            i9 = i16;
                            Invoke = r46;
                        }
                        boolean z10 = r8 == true ? 1 : 0;
                        Invoke = Invoke;
                        r4 = r213;
                        i11 = (i2616 & 1) + (i2616 | 1);
                        objInvoke = objInvoke;
                        r7 = r8;
                    }
                    boolean z11 = r7 == true ? 1 : 0;
                    i12 = i9;
                    int i3519 = (i4 & (-2)) | (i10 & 1);
                    arrayList = new ArrayList(linkedHashSet);
                    int size4 = arrayList.size();
                    strArr2 = new String[((size4 | 1) << 1) - (size4 ^ 1)];
                    Object[] objArr912 = new Object[1];
                    a(new byte[]{0, 1, 1, 1}, new int[]{445, 4, 0, 2}, false, objArr912);
                    strArr2[0] = (String) objArr912[0];
                    i13 = 0;
                    while (i13 < arrayList.size()) {
                        int i3610 = 595 + (i13 * (-1187));
                        int i3611 = ~((-2) | i13);
                        int i3612 = ~(i10 | i13);
                        int i3613 = ((i3611 & i3612) | (i3611 ^ i3612)) * (-1188);
                        int i3614 = (i3610 & i3613) + (i3613 | i3610);
                        int i3615 = ~(((-2) & i13) | ((-2) ^ i13));
                        int i3616 = ~i13;
                        int i3617 = ~((i3616 ^ i4) | (i3616 & i4));
                        int i3618 = (i3615 & i3617) | (i3615 ^ i3617);
                        int i3619 = ~((i12 ^ 1) | (i12 & 1));
                        int i3710 = i3614 + (((i3618 & i3619) | (i3618 ^ i3619)) * 594);
                        int i3711 = ~((i3616 ^ i10) | (i3616 & i10));
                        int i3712 = ~(i3616 | 1);
                        int i3713 = (i3711 & i3712) | (i3711 ^ i3712);
                        int i3714 = ~((i10 ^ 1) | (i10 & 1));
                        int i3715 = ((i3713 & i3714) | (i3713 ^ i3714)) * 594;
                        strArr2[(i3710 & i3715) + (i3715 | i3710)] = (String) arrayList.get(i13);
                        int i3716 = (i13 ^ 107) + ((i13 & 107) << 1);
                        i13 = ((i3716 | (-106)) << 1) - (i3716 ^ (-106));
                    }
                    Object[] objArr913 = {new int[]{i3519}, strArr2, new int[]{(i382 | i383) & (~(i382 & i383))}, new int[]{i4}};
                    int i3717 = 549719059 + (((-336658471) | i10) * (-490)) + (((~(713476616 | i4)) | (-1050135087)) * 490) + 1321821546;
                    int i3718 = ((z11 ? 1 : 0) ^ i3717) + ((i3717 & (z11 ? 1 : 0)) << 1);
                    int i3719 = i3718 << 13;
                    int i3816 = (i3718 | i3719) & (~(i3718 & i3719));
                    int i3817 = i3816 >>> 17;
                    int i3818 = (i3816 | i3817) & (~(i3816 & i3817));
                    int i3819 = i3818 << 5;
                    return objArr913;
                }
                if (z2) {
                    Object objAccessartificialFrame70 = ArtificialStackFrames.accessartificialFrame(682069389);
                    if (objAccessartificialFrame70 == null) {
                        int iIndexOf4 = TextUtils.indexOf("", "") + 21;
                        char threadPriority = (char) ((Process.getThreadPriority(0) + 20) >> 6);
                        int jumpTapTimeout3 = 465 - (ViewConfiguration.getJumpTapTimeout() >> 16);
                        byte b14 = (byte) ($$a[11] + 1);
                        byte b15 = b14;
                        Object[] objArr143 = new Object[1];
                        b(b14, b15, b15, objArr143);
                        objAccessartificialFrame70 = ArtificialStackFrames.coroutineCreation(iIndexOf4, threadPriority, jumpTapTimeout3, -1211970683, false, (String) objArr143[0], null);
                    }
                    int i445 = ((int[]) ((Object[]) ((Field) objAccessartificialFrame70).get(null))[3])[0];
                    Object objAccessartificialFrame71 = ArtificialStackFrames.accessartificialFrame(682069389);
                    if (objAccessartificialFrame71 == null) {
                        int i446 = 22 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                        char cIndexOf3 = (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0));
                        int pressedStateDuration = (ViewConfiguration.getPressedStateDuration() >> 16) + 465;
                        byte b16 = (byte) ($$a[11] + 1);
                        byte b17 = b16;
                        Object[] objArr144 = new Object[1];
                        b(b16, b17, b17, objArr144);
                        objAccessartificialFrame71 = ArtificialStackFrames.coroutineCreation(i446, cIndexOf3, pressedStateDuration, -1211970683, false, (String) objArr144[0], null);
                    }
                    c = 0;
                    if (i445 != ((int[]) ((Object[]) ((Field) objAccessartificialFrame71).get(null))[0])[0]) {
                        objArr = new Object[]{new int[]{(i4 & (-6)) | ((~i4) & 5)}, null, new int[]{(i | i) & (~(i & i))}, new int[]{i4}};
                        int i447 = (-91906788) + (((~((-202587713) | i4)) | (~((-42237987) | i4))) * 69) + (((~((-763051849) | i4)) | 560464136 | (~(i4 | (-602702123)))) * (-69)) + 269576249;
                        int i448 = ((i5 == true ? 1 : 0) & i447) + ((i5 == true ? 1 : 0) | i447);
                        int i449 = i448 << 13;
                        int i450 = (i448 | i449) & (~(i448 & i449));
                        int i451 = i450 >>> 17;
                        int i452 = (i450 | i451) & (~(i450 & i451));
                        int i453 = i452 << 5;
                    }
                    return objArr;
                }
                c = 0;
                if (context == 0) {
                    Object[] objArr517 = new Object[4];
                    int[] iArr10 = new int[i6];
                    objArr517[c] = iArr10;
                    int[] iArr11 = new int[i6];
                    objArr517[2] = iArr11;
                    int[] iArr12 = new int[i6];
                    objArr517[3] = iArr12;
                    iArr12[0] = i4;
                    iArr10[0] = i4;
                    int i1521 = ~i4;
                    int i16110 = (~((-93693465) | i1521)) | 26279936;
                    int i16111 = ~(134069789 | i4);
                    int i16112 = (Invoke - (~((467975709 + ((i16110 | i16111) * (-502))) + (((~(i1521 | (-67413529))) | i16111) * TypedValues.PositionType.TYPE_DRAWPATH)))) - 1;
                    int i16113 = i16112 << 13;
                    int i16114 = (i16112 | i16113) & (~(i16112 & i16113));
                    int i16115 = i16114 ^ (i16114 >>> 17);
                    iArr11[0] = i16115 ^ (i16115 << 5);
                    objArr517[1] = null;
                    return objArr517;
                }
                r3 = r29;
                bArr = new byte[r3.length][];
                length = r3.length;
                i7 = 0;
                i8 = 0;
                while (i7 < length) {
                    r10 = r3[i7];
                    int i16116 = -(PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                    Object[] objArr518 = new Object[1];
                    c((i16116 ^ 15) + ((i16116 & 15) << 1), new char[]{20794, 4322, 33636, 55455, 18972, 17295, 63872, 20131, 32357, 8626, 48690, 6926, 56076, 31992, 23144, 34195}, objArr518);
                    cls3 = Class.forName((String) objArr518[0]);
                    int i16117 = length;
                    objArr5 = new Object[1];
                    a(new byte[]{0, 0, 0, 1, 1, 0, 0, 1}, new int[]{307, 8, 187, 6}, true, objArr5);
                    if (((Integer) cls3.getMethod((String) objArr5[0], null).invoke(r10, null)).intValue() == 4) {
                        int i16118 = artificialFrame;
                        int i16119 = (i16118 ^ 85) + ((i16118 & 85) << 1);
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i16119 % 128;
                        int i17110 = i16119 % 2;
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!(!z)) {
                        ByteBuffer byteBufferAllocate3 = ByteBuffer.allocate(32);
                        Class<?> cls118 = Class.forName(r27);
                        Object[] objArr519 = new Object[1];
                        a(null, new int[]{290, 12, 140, 7}, true, objArr519);
                        longBuffer = (LongBuffer) cls118.getMethod((String) objArr519[0], null).invoke(byteBufferAllocate3, null);
                        jArrArray = r10.array();
                        length3 = jArrArray.length;
                        while (i27 < length3) {
                            longBuffer.put(jArrArray[i27]);
                        }
                        bArr[i8] = byteBufferAllocate3.array();
                        i8++;
                    }
                    i7++;
                    length = i16117;
                }
                if (i8 > 0) {
                    strArr3 = new String[1][];
                    int iCurrentTimeMillis3 = (int) System.currentTimeMillis();
                    int i17111 = (iCurrentTimeMillis3 | 343337308) & (~(iCurrentTimeMillis3 & 343337308));
                    Object[] objArr5110 = {Integer.valueOf((~(i4 & i17111)) & (i4 | i17111)), bArr, Integer.valueOf(i8), Integer.valueOf(i2), strArr3};
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1514071993);
                    if (objAccessartificialFrame == null) {
                        int iIndexOf5 = TextUtils.indexOf("", "", 0, 0) + 21;
                        char cIndexOf4 = (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0));
                        int bitsPerPixel6 = 464 - ImageFormat.getBitsPerPixel(0);
                        byte b18 = $$a[11];
                        byte b19 = b18;
                        Object[] objArr5111 = new Object[1];
                        b(b18, b19, b19, objArr5111);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(iIndexOf5, cIndexOf4, bitsPerPixel6, 983850575, false, (String) objArr5111[0], new Class[]{Integer.TYPE, byte[][].class, Integer.TYPE, Integer.TYPE, String[][].class});
                    }
                    long jLongValue6 = ((Long) ((Method) objAccessartificialFrame).invoke(null, objArr5110)).longValue();
                    long j112 = -553755991;
                    long j113 = 193;
                    long j114 = i4;
                    str = "";
                    long j115 = -1;
                    long j116 = j114 ^ j115;
                    long j117 = j112 ^ j115;
                    long j118 = (j113 * j112) + (j113 * jLongValue6) + (((long) (-192)) * (j116 | ((j117 | jLongValue6) ^ j115)));
                    long j119 = jLongValue6 ^ j115;
                    long j21 = j117 | j119;
                    long j1110 = j119 | j116;
                    long j1111 = j118 + (((long) (-384)) * ((j21 ^ j115) | (j1110 ^ j115))) + (((long) JfifUtil.MARKER_SOFn) * (((j21 | j114) ^ j115) | ((j1110 | j112) ^ j115) | (((jLongValue6 | j112) | j114) ^ j115))) + ((long) (-1408458699));
                    i23 = ~i4;
                    int i17112 = ~((-1633642444) | i23);
                    int i17113 = ~(196416032 | i4);
                    int i17114 = ((int) (j1111 >> 32)) & ((-334238508) + ((i17112 | i17113) * 1150) + (((~((-196416033) | i23)) | i17113) * (-575)) + (((~((-1633642444) | i4)) | (~(1633642443 | i23))) * 575));
                    int i17115 = (int) j1111;
                    int iElapsedRealtime3 = (int) SystemClock.elapsedRealtime();
                    int i17116 = ~iElapsedRealtime3;
                    int i17117 = (-1880002655) + (((~((-1869509451) | i17116)) | 155455744) * (-1188));
                    int i17118 = (~(iElapsedRealtime3 | 1869509450)) | 155455744;
                    int i17119 = ~(432283040 | i17116);
                    int i18110 = i17115 & (i17117 + ((i17118 | i17119) * 594) + (((~(1869509450 | i17116)) | (-2146336747) | i17119) * 594));
                    i24 = ((i18110 & i17114) | (i17114 ^ i18110)) ^ i17111;
                    if ((i2 & 1) != 1) {
                    }
                    i25 = i3;
                    i26 = (i24 & i23) | ((~i24) & i4);
                    if (i26 == 17) {
                        Object[] objArr6110 = {new int[]{i24}, strArr3[0], new int[1], new int[]{i4}};
                        int iNextInt3 = new Random().nextInt(1371143253);
                        int i18111 = ~iNextInt3;
                        int i18112 = (-1213847242) + (((~(608852493 | i18111)) | 769202219) * (-90)) + (((~(608852493 | iNextInt3)) | 147972) * (-45)) + (((~(iNextInt3 | (-769202220))) | 608852493 | (~(i18111 | 769202219))) * 45) + 16;
                        int i18113 = ((i25 == true ? 1 : 0) ^ i18112) + (((i25 == true ? 1 : 0) & i18112) << 1);
                        int i18114 = i18113 << 13;
                        int i18115 = (i18113 | i18114) & (~(i18113 & i18114));
                        int i18116 = i18115 >>> 17;
                        int i18117 = ((~i18115) & i18116) | ((~i18116) & i18115);
                        ((int[]) objArr6110[2])[0] = i18117 ^ (i18117 << 5);
                        return objArr6110;
                    }
                    if (((~(i24 & i4)) & (i24 | i4)) == 0) {
                        Object[] objArr6111 = {new int[]{i24}, null, new int[]{(i2015 | i2016) & (~(i2015 & i2016))}, new int[]{i4}};
                        int i18118 = ((((~(i4 | 59521427)) | 100828298) * 56) - 1718705691) + ((59521427 | (~(100828298 | i23))) * 56);
                        int i18119 = i18118 * 370;
                        int i19110 = ((i18118 ^ i23) | (i23 & i18118)) * (-369);
                        int i19111 = (i18119 ^ i19110) + ((i18119 & i19110) << 1);
                        int i19112 = ~i4;
                        int i19113 = ~(i19112 | ((-1) ^ i19112));
                        int i19114 = i19111 + (((i19113 & i18118) | (i18118 ^ i19113)) * (-369));
                        int i19115 = ~(~i18118);
                        int i19116 = ~i4;
                        int i19117 = (i19115 & i19116) | (i19115 ^ i19116);
                        int i19118 = ~(i18118 | ((-1) ^ i18118));
                        int i19119 = ((i19117 & i19118) | (i19117 ^ i19118)) * 369;
                        int i20110 = (i19114 ^ i19119) + ((i19119 & i19114) << 1);
                        int i20111 = (((i25 == true ? 1 : 0) | i20110) << 1) - (i20110 ^ (i25 == true ? 1 : 0));
                        int i20112 = i20111 << 13;
                        int i20113 = ((~i20111) & i20112) | ((~i20112) & i20111);
                        int i20114 = i20113 >>> 17;
                        int i20115 = ((~i20113) & i20114) | ((~i20114) & i20113);
                        int i20116 = i20115 << 5;
                        return objArr6111;
                    }
                    if (i26 == 11) {
                        Invoke = i26;
                        r6 = i25;
                        objArr4 = new Object[]{new int[]{i24}, strArr3[0], new int[]{i2019 ^ (i2019 << 5)}, new int[]{i4}};
                        int i20117 = ((i25 == true ? 1 : 0) - (~(((729202488 + (((~((-167779871) | i4)) | (~((-7430145) | i4))) * 69)) + ((((~((-1049108479) | i4)) | 881328608) | (~((-888758753) | i4))) * (-69))) + 113279061))) - 1;
                        int i20118 = i20117 ^ (i20117 << 13);
                        int i20119 = i20118 ^ (i20118 >>> 17);
                        return objArr4;
                    }
                } else {
                    r6 = Invoke;
                    str = "";
                    Invoke = Invoke;
                }
                Invoke = i26;
                r6 = i25;
                int i2114 = -Color.blue(0);
                Object[] objArr6112 = new Object[1];
                c((i2114 & 23) + (i2114 | 23), new char[]{37254, 28566, 39408, 9603, 19947, 34441, 40540, 33064, 3405, 52960, 3224, 8817, 19934, 59436, 43728, 50638, 38455, 41647, 3224, 8817, 42949, 16154, 5394, 44112}, objArr6112);
                Class<?> cls119 = Class.forName((String) objArr6112[0]);
                int i2115 = -View.MeasureSpec.makeMeasureSpec(0, 0);
                int i2116 = (i2115 * (-711)) + 12121;
                int i2117 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                int i22110 = ((i2117 | 7) << 1) - (i2117 ^ 7);
                artificialFrame = i22110 % 128;
                int i22111 = i22110 % 2;
                int i22112 = ~(((-18) ^ i2115) | ((-18) & i2115));
                i9 = ~i4;
                int i22113 = ~((i9 ^ i2115) | (i9 & i2115));
                int i22114 = (-712) * ((i22112 & i22113) | (i22112 ^ i22113));
                int i22115 = (i2116 ^ i22114) + ((i2116 & i22114) << 1);
                i10 = ~i4;
                int i22116 = ((-18) & i10) | ((-18) ^ i10);
                int i22117 = ~((i22116 & i2115) | (i22116 ^ i2115));
                int i22118 = ~((i2115 ^ 17) | (i2115 & 17) | i4);
                int i22119 = (i22115 - (~(((i22117 & i22118) | (i22117 ^ i22118)) * (-712)))) - 1;
                int i23110 = ~((i2115 & i10) | (i10 ^ i2115));
                Object[] objArr6113 = new Object[1];
                c((i22119 - (~(((i23110 & (-18)) | ((-18) ^ i23110)) * 712))) - 1, new char[]{53866, 34687, 55204, 17900, 1308, 17685, 46884, 6988, 53866, 34687, 21752, 41224, 18764, 26637, 53866, 34687, 23144, 34195}, objArr6113);
                Invoke = cls119.getMethod((String) objArr6113[0], null).invoke(context, null);
                int i23111 = -(ViewConfiguration.getMinimumFlingVelocity() >> 16);
                int i23112 = i23111 * 319;
                int i23113 = (i23112 ^ (-7291)) + ((i23112 & (-7291)) << 1);
                int i23114 = ~i23111;
                int i23115 = i23113 + (((~((i23114 & i4) | (i23114 ^ i4))) | (-24)) * (-318));
                int i23116 = ~((-24) | i4);
                int i23117 = ~((i9 ^ i23111) | (i9 & i23111) | 23);
                int i23118 = i23115 + (((i23116 & i23117) | (i23116 ^ i23117)) * TypedValues.AttributesType.TYPE_PIVOT_TARGET);
                int i23119 = ((-24) & i9) | ((-24) ^ i9);
                int i24110 = ~((i23119 & i23111) | (i23119 ^ i23111));
                int i24111 = (i23111 & 23) | (i23111 ^ 23);
                int i24112 = ~((i24111 & i4) | (i24111 ^ i4));
                int i24113 = ((i24112 & i24110) | (i24110 ^ i24112)) * TypedValues.AttributesType.TYPE_PIVOT_TARGET;
                Object[] objArr6114 = new Object[1];
                c((i23118 ^ i24113) + ((i24113 & i23118) << 1), new char[]{37254, 28566, 39408, 9603, 19947, 34441, 40540, 33064, 3405, 52960, 3224, 8817, 19934, 59436, 43728, 50638, 38455, 41647, 3224, 8817, 42949, 16154, 5394, 44112}, objArr6114);
                Class<?> cls1110 = Class.forName((String) objArr6114[0]);
                Object[] objArr6115 = new Object[1];
                a(new byte[]{1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1}, new int[]{315, 14, 0, 3}, false, objArr6115);
                Object[] objArr6116 = {cls1110.getMethod((String) objArr6115[0], null).invoke(context, null), 64};
                Object[] objArr6117 = new Object[1];
                a(new byte[]{1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0}, new int[]{329, 33, 93, 17}, false, objArr6117);
                Class<?> cls1111 = Class.forName((String) objArr6117[0]);
                Object[] objArr6118 = new Object[1];
                a(new byte[]{0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1}, new int[]{362, 14, 163, 0}, false, objArr6118);
                objInvoke = cls1111.getMethod((String) objArr6118[0], String.class, Integer.TYPE).invoke(Invoke, objArr6116);
                linkedHashSet = new LinkedHashSet();
                int length12 = r3.length;
                i11 = 0;
                r4 = r3;
                Invoke = length12;
                r7 = r6;
                while (i11 < Invoke) {
                    r9 = r4[i11];
                    Object[] objArr6119 = new Object[1];
                    c((ViewConfiguration.getTapTimeout() >> 16) + 15, new char[]{20794, 4322, 33636, 55455, 18972, 17295, 63872, 20131, 32357, 8626, 48690, 6926, 56076, 31992, 23144, 34195}, objArr6119);
                    cls = Class.forName((String) objArr6119[0]);
                    ?? r214 = r4;
                    objArr2 = new Object[1];
                    a(new byte[]{0, 0, 0, 1, 1, 0, 0, 1}, new int[]{307, 8, 187, 6}, true, objArr2);
                    if (((Integer) cls.getMethod((String) objArr2[0], null).invoke(r9, null)).intValue() == 4) {
                        Object[] objArr7110 = new Object[1];
                        a(new byte[]{1, 1, 1, 0, 1, 1, 1}, new int[]{138, 7, 0, 7}, false, objArr7110);
                        str2 = (String) objArr7110[0];
                    } else {
                        int i24114 = -(KeyEvent.getMaxKeyCode() >> 16);
                        int iINotificationSideChannel112 = SqlDateTypeAdapter.AnonymousClass1.INotificationSideChannel();
                        int i24115 = ~i24114;
                        int i24116 = ~iINotificationSideChannel112;
                        int i24117 = ~((i24115 ^ i24116) | (i24116 & i24115));
                        int i24118 = (i24115 ^ 3) | (i24115 & 3);
                        int i24119 = ~i24118;
                        int i25110 = (i24117 ^ i24119) | (i24119 & i24117);
                        int i25111 = ~((~iINotificationSideChannel112) | 3);
                        int i25112 = (((i24114 * 398) - 1188) - (~(((i25110 ^ i25111) | (i25110 & i25111)) * (-397)))) - 1;
                        int i25113 = (~i24118) * (-397);
                        int i25114 = (i25112 & i25113) + (i25113 | i25112);
                        int i25115 = ~((i24115 ^ 3) | (i24115 & 3));
                        int i25116 = (i25115 & iINotificationSideChannel112) | (iINotificationSideChannel112 ^ i25115);
                        int i25117 = ~((i24114 & (-4)) | ((-4) ^ i24114));
                        int i25118 = i25116 ^ i25117;
                        Object[] objArr7111 = new Object[1];
                        c((i25114 - (~(-(-(((i25117 & i25116) | i25118) * 397))))) - 1, new char[]{29921, 63486, 64688, 55477}, objArr7111);
                        str2 = (String) objArr7111[0];
                    }
                    Object[] objArr7112 = new Object[1];
                    a(new byte[]{1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1}, new int[]{376, 30, 0, 0}, false, objArr7112);
                    Class<?> cls1112 = Class.forName((String) objArr7112[0]);
                    int i25119 = -View.MeasureSpec.getSize(0);
                    int iINotificationSideChannel113 = SqlDateTypeAdapter.AnonymousClass1.INotificationSideChannel();
                    int i26110 = i25119 * 866;
                    int i26111 = ((i26110 | (-8640)) << 1) - (i26110 ^ (-8640));
                    int i26112 = artificialFrame;
                    int i26113 = (i26112 ^ 49) + ((i26112 & 49) << 1);
                    int i26114 = i26113 % 128;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i26114;
                    int i26115 = i26113 % 2;
                    int i26116 = i11;
                    int i26117 = ~((~iINotificationSideChannel113) | (~i25119));
                    int i26118 = (-865) * (((-11) ^ i26117) | (i26117 & (-11)));
                    int i26119 = (i26111 & i26118) + (i26111 | i26118);
                    int i27110 = (~((i25119 ^ iINotificationSideChannel113) | (i25119 & iINotificationSideChannel113))) * 865;
                    int i27111 = (i26119 & i27110) + (i26119 | i27110);
                    int i27112 = ~iINotificationSideChannel113;
                    int i27113 = ~(((-11) ^ i27112) | ((-11) & i27112));
                    int i27114 = ~((i27112 & i25119) | (i27112 ^ i25119));
                    int i27115 = -(-(((i27114 & i27113) | (i27113 ^ i27114)) * 865));
                    int i27116 = (i27111 ^ i27115) + ((i27111 & i27115) << 1);
                    int i27117 = ((i26114 | 5) << 1) - (i26114 ^ 5);
                    artificialFrame = i27117 % 128;
                    int i27118 = i27117 % 2;
                    Object[] objArr7113 = new Object[1];
                    c(i27116, new char[]{18119, 44752, 14387, 11769, 59984, 13011, 30482, 35605, 21275, 48028}, objArr7113);
                    Object[] objArr7114 = (Object[]) cls1112.getField((String) objArr7113[0]).get(objInvoke);
                    length2 = objArr7114.length;
                    i14 = 0;
                    Invoke = objArr7114;
                    r8 = r7;
                    while (i14 < length2) {
                        ?? r18 = Invoke[i14];
                        Object[] objArr7115 = {str2};
                        int deadChar3 = KeyEvent.getDeadChar(0, 0);
                        int i27119 = deadChar3 * (-743);
                        obj2 = objInvoke;
                        int i28110 = ((i27119 | (-20061)) << 1) - (i27119 ^ (-20061));
                        int i28111 = (deadChar3 ^ 27) | (deadChar3 & 27);
                        str3 = str2;
                        r46 = Invoke;
                        int i28112 = (~i28111) | (~((deadChar3 ^ i4) | (deadChar3 & i4)));
                        int i28113 = ~((i4 ^ 27) | (i4 & 27));
                        int i28114 = ((i28112 ^ i28113) | (i28112 & i28113)) * (-744);
                        int i28115 = (i28110 & i28114) + (i28110 | i28114);
                        int i28116 = ~deadChar3;
                        int i28117 = ~((i28116 & (-28)) | (i28116 ^ (-28)));
                        int i28118 = ((i28117 & i9) | (i9 ^ i28117)) * 744;
                        Object[] objArr7116 = new Object[1];
                        c((((i28115 & i28118) + (i28118 | i28115)) - (~(-(-(((i28111 ^ i4) | (i28111 & i4)) * 744))))) - 1, new char[]{20794, 4322, 33636, 55455, 11143, 59227, 29278, 55764, 30482, 35605, 23247, 20961, 62390, 21178, 38011, 56431, 30316, 50537, 41530, 38433, 'T', 5334, 18542, 5203, 21275, 48028, 5394, 44112}, objArr7116);
                        String str13 = str5;
                        Invoke = 0;
                        Object objInvoke28 = Class.forName((String) objArr7116[0]).getMethod(str13, String.class).invoke(null, objArr7115);
                        Invoke = 28;
                        str5 = str13;
                        Object[] objArr7117 = new Object[1];
                        a(new byte[]{0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0}, new int[]{406, 28, 0, 27}, false, objArr7117);
                        Class<?> cls1113 = Class.forName((String) objArr7117[0]);
                        i15 = length2;
                        Object[] objArr7118 = new Object[1];
                        a(new byte[]{0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0}, new int[]{434, 11, 102, 0}, false, objArr7118);
                        Invoke = (String) objArr7118[0];
                        Object objInvoke29 = cls1113.getMethod(Invoke, null).invoke(r18, null);
                        int i28119 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                        int i29110 = (i28119 ^ 57) + ((i28119 & 57) << 1);
                        artificialFrame = i29110 % 128;
                        int i29111 = i29110 % 2;
                        Object[] objArr7119 = {objInvoke29};
                        int i29112 = -(-(ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)));
                        Object[] objArr8110 = new Object[1];
                        c((i29112 ^ 26) + ((i29112 & 26) << 1), new char[]{20794, 4322, 33636, 55455, 11143, 59227, 29278, 55764, 30482, 35605, 23247, 20961, 62390, 21178, 38011, 56431, 30316, 50537, 41530, 38433, 'T', 5334, 18542, 5203, 21275, 48028, 5394, 44112}, objArr8110);
                        Class<?> cls1114 = Class.forName((String) objArr8110[0]);
                        int i29113 = -View.MeasureSpec.makeMeasureSpec(0, 0);
                        int iINotificationSideChannel114 = SqlDateTypeAdapter.AnonymousClass1.INotificationSideChannel();
                        int i29114 = i29113 * (-919);
                        int i29115 = ((i29114 | (-5514)) << 1) - (i29114 ^ (-5514));
                        int i29116 = ~i29113;
                        int i29117 = (i29116 ^ (-7)) | (i29116 & (-7));
                        int i29118 = ~((i29117 ^ iINotificationSideChannel114) | (i29117 & iINotificationSideChannel114));
                        i16 = i9;
                        int i29119 = ~iINotificationSideChannel114;
                        int i30110 = (-7) | i29119;
                        i17 = i14;
                        int i30111 = ~((i30110 ^ i29113) | (i30110 & i29113));
                        int i30112 = ((i29118 ^ i30111) | (i30111 & i29118)) * 920;
                        int i30113 = ((i29115 | i30112) << 1) - (i30112 ^ i29115);
                        int i30114 = ~i29113;
                        int i30115 = ~((i30114 ^ (-7)) | (i30114 & (-7)));
                        int i30116 = ~iINotificationSideChannel114;
                        int i30117 = -(-(((~((i30114 ^ i30116) | (i30116 & i30114))) | i30115) * 920));
                        int i30118 = (i30113 ^ i30117) + ((i30117 & i30113) << 1);
                        int i30119 = (i30114 ^ (-7)) | (i30114 & (-7));
                        int i31110 = ~((i30119 & i29119) | (i30119 ^ i29119));
                        int i31111 = (i29116 ^ 6) | (i29116 & 6);
                        int i31112 = ~((i31111 & iINotificationSideChannel114) | (i31111 ^ iINotificationSideChannel114));
                        int i31113 = (i31110 & i31112) | (i31110 ^ i31112);
                        int i31114 = (-7) | i29113;
                        int i31115 = ~((i31114 & iINotificationSideChannel114) | (i31114 ^ iINotificationSideChannel114));
                        Object[] objArr8111 = new Object[1];
                        c(i30118 + (((i31115 & i31113) | (i31113 ^ i31115)) * 920), new char[]{53560, 53417, 53866, 34687, 14879, 640}, objArr8111);
                        Invoke = cls1114.getMethod((String) objArr8111[0], byte[].class);
                        Object[] objArr8112 = {Invoke.invoke(objInvoke28, objArr7119)};
                        Class<?> cls1115 = Class.forName(r27);
                        Object[] objArr8113 = new Object[1];
                        a(new byte[]{0, 1, 1, 1}, new int[]{286, 4, 131, 3}, true, objArr8113);
                        Invoke = 0;
                        Invoke = 0;
                        Invoke = 0;
                        Object objInvoke210 = cls1115.getMethod((String) objArr8113[0], byte[].class).invoke(null, objArr8112);
                        Class<?> cls212 = Class.forName(r27);
                        Object[] objArr8114 = new Object[1];
                        a(null, new int[]{290, 12, 140, 7}, true, objArr8114);
                        i18 = 0;
                        objInvoke2 = cls212.getMethod((String) objArr8114[0], null).invoke(objInvoke210, null);
                        if (objInvoke2 != null) {
                            i22 = 0;
                            string = str;
                            str4 = string;
                            while (true) {
                                int i31116 = -TextUtils.getOffsetAfter(str4, i18);
                                Object[] objArr8115 = new Object[1];
                                c((i31116 & 15) + (i31116 | 15), new char[]{20794, 4322, 33636, 55455, 18972, 17295, 63872, 20131, 32357, 8626, 48690, 6926, 56076, 31992, 23144, 34195}, objArr8115);
                                cls2 = Class.forName((String) objArr8115[0]);
                                objArr3 = new Object[1];
                                a(new byte[]{0, 1, 0, 0, 1}, new int[]{302, 5, 4, 0}, false, objArr3);
                                if (i22 >= ((Integer) cls2.getMethod((String) objArr3[0], null).invoke(objInvoke2, null)).intValue()) {
                                    break;
                                    break;
                                }
                                StringBuilder sb6 = new StringBuilder();
                                sb6.append(string);
                                Object[] objArr8116 = {Integer.valueOf(i22)};
                                Object[] objArr8117 = new Object[1];
                                a(new byte[]{0, 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1}, new int[]{0, 19, SyslogConstants.LOG_LOCAL7, 10}, true, objArr8117);
                                Class<?> cls213 = Class.forName((String) objArr8117[0]);
                                int i31117 = -(-KeyEvent.normalizeMetaState(0));
                                Object[] objArr8118 = new Object[1];
                                c(((i31117 | 3) << 1) - (i31117 ^ 3), new char[]{53866, 34687, 5394, 44112}, objArr8118);
                                Object[] objArr8119 = {Long.valueOf(((Long) cls213.getMethod((String) objArr8118[0], Integer.TYPE).invoke(objInvoke2, objArr8116)).longValue())};
                                Object[] objArr914 = new Object[1];
                                c(13 - (~(-Drawable.resolveOpacity(0, 0))), new char[]{20794, 4322, 33636, 55455, 41565, 27421, 37254, 28566, 34439, 38407, 43287, 26265, 18855, 10826}, objArr914);
                                Class<?> cls214 = Class.forName((String) objArr914[0]);
                                int jumpTapTimeout4 = ViewConfiguration.getJumpTapTimeout() >> 16;
                                int iINotificationSideChannel115 = SqlDateTypeAdapter.AnonymousClass1.INotificationSideChannel();
                                int i31118 = jumpTapTimeout4 * 934;
                                int i31119 = ((i31118 | (-10252)) << 1) - (i31118 ^ (-10252));
                                int i32110 = ~jumpTapTimeout4;
                                int i32111 = ~iINotificationSideChannel115;
                                int i32112 = ~((i32110 ^ i32111) | (i32111 & i32110));
                                int i32113 = (i31119 - (~((((-12) ^ i32112) | (i32112 & (-12))) * (-933)))) - 1;
                                int i32114 = ~iINotificationSideChannel115;
                                int i32115 = ~(((-12) ^ i32114) | (i32114 & (-12)));
                                int i32116 = ~((-12) | jumpTapTimeout4);
                                int i32117 = i32113 + (((i32115 & i32116) | (i32115 ^ i32116)) * 933);
                                int i32118 = (~((jumpTapTimeout4 & 11) | (jumpTapTimeout4 ^ 11))) * 933;
                                Object[] objArr915 = new Object[1];
                                c((i32117 & i32118) + (i32117 | i32118), new char[]{56090, 24477, Typography.notEqual, 31812, 38990, 40251, 31280, 48988, 64830, 55973, 3405, 65022}, objArr915);
                                sb6.append((String) cls214.getMethod((String) objArr915[0], Long.TYPE).invoke(null, objArr8119));
                                string = sb6.toString();
                                i22 = ((i22 | 1) << 1) - (i22 ^ 1);
                                i18 = 0;
                            }
                        } else {
                            str4 = str;
                            string = str4;
                        }
                        linkedHashSet.add(string);
                        if (objInvoke2.equals(r9.rewind())) {
                            int iINotificationSideChannel21 = SqlDateTypeAdapter.AnonymousClass1.INotificationSideChannel();
                            int i32119 = ~iINotificationSideChannel21;
                            int i33110 = ~(((-1172061424) & i32119) | ((-1172061424) ^ i32119));
                            int i33111 = ~((1910321450 ^ iINotificationSideChannel21) | (1910321450 & iINotificationSideChannel21));
                            int i33112 = ((i33110 & i33111) | (i33110 ^ i33111)) * 333;
                            int i33113 = ((-185130971) ^ i33112) + ((i33112 & (-185130971)) << 1);
                            int i33114 = ((~((iINotificationSideChannel21 & (-1172061424)) | ((-1172061424) ^ iINotificationSideChannel21))) | (~((i32119 & 1910321450) | (i32119 ^ 1910321450)))) * 333;
                            i19 = ((i33113 | i33114) << 1) - (i33114 ^ i33113);
                            int iINotificationSideChannel116 = SqlDateTypeAdapter.AnonymousClass1.INotificationSideChannel();
                            int i33115 = ~((1618314597 & iINotificationSideChannel116) | (1618314597 ^ iINotificationSideChannel116));
                            i20 = -(-(((i33115 & 481085041) | (481085041 ^ i33115)) * (-964)));
                            int i33116 = ~iINotificationSideChannel116;
                            i21 = ~((i33116 & 1618314597) | (1618314597 ^ i33116));
                            if (i19 <= (((1122935188 ^ i20) + ((i20 & 1122935188) << 1)) - (~(-(-(((i21 & 478691856) | (i21 ^ 478691856)) * (-964)))))) - 1) {
                                objArr = new Object[3];
                                objArr[1] = new int[1];
                            } else {
                                objArr = new Object[4];
                                objArr[0] = new int[1];
                            }
                            objArr[2] = new int[1];
                            objArr[3] = new int[]{i4};
                            int[] iArr13 = (int[]) objArr[0];
                            int i33117 = artificialFrame + 49;
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i33117 % 128;
                            int i33118 = i33117 % 2;
                            iArr13[0] = i4;
                            int i33119 = (~(177675197 | i4)) | (~(338024923 | i10));
                            int i34110 = ~((-177675198) | i10);
                            int i34111 = 347059641 + ((i33119 | i34110) * (-516)) + (((~((-337690691) | i4)) | (~((-334234) | i10))) * 516) + ((334233 | i34110) * 516);
                            int i34112 = (i34111 << 1) - i34111;
                            int iINotificationSideChannel117 = SqlDateTypeAdapter.AnonymousClass1.INotificationSideChannel();
                            int i34113 = i34112 * (-963);
                            int i34114 = (((i34113 ^ (-964)) + ((i34113 & (-964)) << 1)) - (~(i3 * 965))) - 1;
                            int i34115 = ~i34112;
                            int i34116 = ~i3;
                            int i34117 = ~((i34116 ^ iINotificationSideChannel117) | (i34116 & iINotificationSideChannel117));
                            int i34118 = (i34114 - (~(-(-(((i34115 & i34117) | (i34115 ^ i34117)) * (-964)))))) - 1;
                            int i34119 = ~iINotificationSideChannel117;
                            int i35110 = ~((i34119 & i34116) | (i34116 ^ i34119));
                            int i35111 = ~i3;
                            int i35112 = ~((i34112 & i35111) | (i35111 ^ i34112));
                            int i35113 = ((i35112 & i35110) | (i35110 ^ i35112)) * (-964);
                            int i35114 = ((i34118 | i35113) << 1) - (i35113 ^ i34118);
                            int i35115 = (i35114 << 13) ^ i35114;
                            int i35116 = i35115 >>> 17;
                            int i35117 = (i35115 | i35116) & (~(i35115 & i35116));
                            int i35118 = i35117 << 5;
                            ((int[]) objArr[2])[0] = ((~i35117) & i35118) | ((~i35118) & i35117);
                            objArr[1] = null;
                        } else {
                            i14 = i17 + 1;
                            objInvoke = obj2;
                            str2 = str3;
                            r8 = i3;
                            str = str4;
                            length2 = i15;
                            i9 = i16;
                            Invoke = r46;
                        }
                    }
                    boolean z12 = r8 == true ? 1 : 0;
                    Invoke = Invoke;
                    r4 = r214;
                    i11 = (i26116 & 1) + (i26116 | 1);
                    objInvoke = objInvoke;
                    r7 = r8;
                }
                boolean z13 = r7 == true ? 1 : 0;
                i12 = i9;
                int i35119 = (i4 & (-2)) | (i10 & 1);
                arrayList = new ArrayList(linkedHashSet);
                int size5 = arrayList.size();
                strArr2 = new String[((size5 | 1) << 1) - (size5 ^ 1)];
                Object[] objArr916 = new Object[1];
                a(new byte[]{0, 1, 1, 1}, new int[]{445, 4, 0, 2}, false, objArr916);
                strArr2[0] = (String) objArr916[0];
                i13 = 0;
                while (i13 < arrayList.size()) {
                    int i36110 = 595 + (i13 * (-1187));
                    int i36111 = ~((-2) | i13);
                    int i36112 = ~(i10 | i13);
                    int i36113 = ((i36111 & i36112) | (i36111 ^ i36112)) * (-1188);
                    int i36114 = (i36110 & i36113) + (i36113 | i36110);
                    int i36115 = ~(((-2) & i13) | ((-2) ^ i13));
                    int i36116 = ~i13;
                    int i36117 = ~((i36116 ^ i4) | (i36116 & i4));
                    int i36118 = (i36115 & i36117) | (i36115 ^ i36117);
                    int i36119 = ~((i12 ^ 1) | (i12 & 1));
                    int i37110 = i36114 + (((i36118 & i36119) | (i36118 ^ i36119)) * 594);
                    int i37111 = ~((i36116 ^ i10) | (i36116 & i10));
                    int i37112 = ~(i36116 | 1);
                    int i37113 = (i37111 & i37112) | (i37111 ^ i37112);
                    int i37114 = ~((i10 ^ 1) | (i10 & 1));
                    int i37115 = ((i37113 & i37114) | (i37113 ^ i37114)) * 594;
                    strArr2[(i37110 & i37115) + (i37115 | i37110)] = (String) arrayList.get(i13);
                    int i37116 = (i13 ^ 107) + ((i13 & 107) << 1);
                    i13 = ((i37116 | (-106)) << 1) - (i37116 ^ (-106));
                }
                Object[] objArr917 = {new int[]{i35119}, strArr2, new int[]{(i3818 | i3819) & (~(i3818 & i3819))}, new int[]{i4}};
                int i37117 = 549719059 + (((-336658471) | i10) * (-490)) + (((~(713476616 | i4)) | (-1050135087)) * 490) + 1321821546;
                int i37118 = ((z13 ? 1 : 0) ^ i37117) + ((i37117 & (z13 ? 1 : 0)) << 1);
                int i37119 = i37118 << 13;
                int i38110 = (i37118 | i37119) & (~(i37118 & i37119));
                int i38111 = i38110 >>> 17;
                int i38112 = (i38110 | i38111) & (~(i38110 & i38111));
                int i38113 = i38112 << 5;
                return objArr917;
            } catch (Throwable unused13) {
                int i2118 = ~i4;
                objArr = new Object[]{new int[]{(i4 & (-3)) | (i2118 & 2)}, null, new int[]{((~i214) & i215) | ((~i215) & i214)}, new int[]{i4}};
                int i2119 = 1535794187 + ((i4 | 222778326) * (-50)) + (((~(i4 | (-205996615))) | (~(268425214 | i2118))) * 50) + (((~(222778326 | i2118)) | (~(62428600 | i2118)) | (-268425215)) * 50);
                ?? r19 = (i2119 ^ 16) + ((16 & i2119) << 1) + Invoke;
                int i2120 = r19 << 13;
                int i2121 = ((~r19) & i2120) | ((~i2120) & r19);
                int i2122 = i2121 ^ (i2121 >>> 17);
                int i2123 = i2122 << 5;
            }
            i4 = i;
            r29 = r12;
            r27 = r13;
            i5 = i3;
            i6 = 1;
            Invoke = i5;
            return objArr;
        }
        objArr6 = new Object[]{new int[]{(~(i35 & 4)) & (i35 | 4)}, null, new int[1], new int[]{i35}};
        int iMaxMemory = (int) Runtime.getRuntime().maxMemory();
        int i454 = ~iMaxMemory;
        int i455 = (-1529488243) + ((~(108527192 | i454)) * (-560)) + ((~(iMaxMemory | (-16777606))) * (-560)) + (((~(51822533 | i454)) | 73482264) * 560) + 16;
        int i456 = i455 * (-1965);
        int i457 = i3 * 984;
        int i458 = ((i456 | i457) << 1) - (i456 ^ i457);
        int i459 = ~i3;
        int i460 = ((i455 ^ i459) | (i455 & i459)) * 983;
        int i461 = ((i458 | i460) << 1) - (i460 ^ i458);
        int i462 = ~i455;
        int i463 = ~i35;
        int i464 = ~((i459 & i463) | (i459 ^ i463));
        int i465 = ((i464 & i462) | (i462 ^ i464)) * (-983);
        int i466 = (((i461 | i465) << 1) - (i465 ^ i461)) + (((~((i462 ^ i463) | (i463 & i462))) | (~((i462 ^ i3) | (i3 & i462)))) * 983);
        int i467 = i466 << 13;
        int i468 = (i467 | i466) & (~(i466 & i467));
        int i469 = i468 >>> 17;
        int i470 = ((~i468) & i469) | ((~i469) & i468);
        int i471 = getARTIFICIAL_FRAME_PACKAGE_NAME;
        int i472 = (i471 ^ 37) + ((i471 & 37) << 1);
        artificialFrame = i472 % 128;
        int i473 = i472 % 2;
        int i474 = i470 << 5;
        ((int[]) objArr6[2])[0] = (i470 | i474) & (~(i470 & i474));
        return objArr6;
    }
}
