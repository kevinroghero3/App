package androidx.compose.ui.graphics.layer;

import android.graphics.Canvas;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import androidx.collection.MutableObjectList;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.core.os.HandlerCompat;
import java.util.Locale;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class LayerManager {
    public static final Companion Companion = new Companion(null);
    private static final boolean isRobolectric;
    private final CanvasHolder canvasHolder;
    private ImageReader imageReader;
    private boolean persistenceIterationInProgress;
    private MutableObjectList<GraphicsLayer> postponedReleaseRequests;
    private final MutableScatterSet<GraphicsLayer> layerSet = ScatterSetKt.mutableScatterSetOf();
    private final Handler handler = HandlerCompat.createAsync(Looper.getMainLooper(), new Handler.Callback() { // from class: androidx.compose.ui.graphics.layer.LayerManager$$ExternalSyntheticLambda1
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            return LayerManager.handler$lambda$0(this.f$0, message);
        }
    });

    public LayerManager(@NotNull CanvasHolder canvasHolder) {
        this.canvasHolder = canvasHolder;
    }

    public final CanvasHolder getCanvasHolder() {
        return this.canvasHolder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean handler$lambda$0(LayerManager layerManager, Message message) {
        layerManager.persistLayers(layerManager.layerSet);
        return true;
    }

    public final void persist(@NotNull GraphicsLayer graphicsLayer) {
        this.layerSet.add(graphicsLayer);
        if (this.handler.hasMessages(0)) {
            return;
        }
        this.handler.sendMessageAtFrontOfQueue(Message.obtain());
    }

    public final void release(@NotNull GraphicsLayer graphicsLayer) {
        if (!this.persistenceIterationInProgress) {
            if (this.layerSet.remove(graphicsLayer)) {
                graphicsLayer.discardDisplayList$ui_graphics_release();
            }
        } else {
            MutableObjectList<GraphicsLayer> mutableObjectList = this.postponedReleaseRequests;
            if (mutableObjectList == null) {
                mutableObjectList = new MutableObjectList<>(0, 1, null);
                this.postponedReleaseRequests = mutableObjectList;
            }
            mutableObjectList.add(graphicsLayer);
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0090 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:22:0x0092 A[LOOP:0: B:12:0x0056->B:22:0x0092, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:34:0x0096 A[EDGE_INSN: B:34:0x0096->B:23:0x0096 BREAK  A[LOOP:0: B:12:0x0056->B:22:0x0092], SYNTHETIC] */
    private final void persistLayers(ScatterSet<GraphicsLayer> scatterSet) {
        if (!scatterSet.isNotEmpty() || isRobolectric) {
            return;
        }
        ImageReader imageReaderNewInstance = this.imageReader;
        if (imageReaderNewInstance == null) {
            imageReaderNewInstance = ImageReader.newInstance(1, 1, 1, 3);
            imageReaderNewInstance.setOnImageAvailableListener(new ImageReader.OnImageAvailableListener() { // from class: androidx.compose.ui.graphics.layer.LayerManager$$ExternalSyntheticLambda0
                @Override // android.media.ImageReader.OnImageAvailableListener
                public final void onImageAvailable(ImageReader imageReader) {
                    LayerManager.persistLayers$lambda$3$lambda$2(imageReader);
                }
            }, this.handler);
            this.imageReader = imageReaderNewInstance;
        }
        Surface surface = imageReaderNewInstance.getSurface();
        Canvas canvasLockHardwareCanvas = LockHardwareCanvasHelper.INSTANCE.lockHardwareCanvas(surface);
        this.persistenceIterationInProgress = true;
        CanvasHolder canvasHolder = this.canvasHolder;
        Canvas internalCanvas = canvasHolder.getAndroidCanvas().getInternalCanvas();
        canvasHolder.getAndroidCanvas().setInternalCanvas(canvasLockHardwareCanvas);
        AndroidCanvas androidCanvas = canvasHolder.getAndroidCanvas();
        canvasLockHardwareCanvas.save();
        int i = 0;
        canvasLockHardwareCanvas.clipRect(0, 0, 1, 1);
        Object[] objArr = scatterSet.elements;
        long[] jArr = scatterSet.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i2 = 0;
            while (true) {
                long j = jArr[i2];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i3 = 8 - ((~(i2 - length)) >>> 31);
                    for (int i4 = i; i4 < i3; i4++) {
                        if ((j & 255) < 128) {
                            ((GraphicsLayer) objArr[(i2 << 3) + i4]).drawForPersistence$ui_graphics_release(androidCanvas);
                        }
                        j >>= 8;
                    }
                    if (i3 != 8) {
                        break;
                    }
                    if (i2 != length) {
                        break;
                    }
                    i2++;
                    i = 0;
                } else if (i2 != length) {
                    break;
                    break;
                } else {
                    i2++;
                    i = 0;
                }
            }
        }
        canvasLockHardwareCanvas.restore();
        canvasHolder.getAndroidCanvas().setInternalCanvas(internalCanvas);
        this.persistenceIterationInProgress = false;
        MutableObjectList<GraphicsLayer> mutableObjectList = this.postponedReleaseRequests;
        if (mutableObjectList != null && mutableObjectList.isNotEmpty()) {
            Object[] objArr2 = mutableObjectList.content;
            int i5 = mutableObjectList._size;
            for (int i6 = 0; i6 < i5; i6++) {
                release((GraphicsLayer) objArr2[i6]);
            }
            mutableObjectList.clear();
        }
        surface.unlockCanvasAndPost(canvasLockHardwareCanvas);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void persistLayers$lambda$3$lambda$2(ImageReader imageReader) {
        Image imageAcquireLatestImage;
        if (imageReader == null || (imageAcquireLatestImage = imageReader.acquireLatestImage()) == null) {
            return;
        }
        imageAcquireLatestImage.close();
    }

    public final void destroy() {
        ImageReader imageReader = this.imageReader;
        if (imageReader != null) {
            imageReader.close();
        }
        this.imageReader = null;
    }

    public final boolean hasImageReader() {
        return this.imageReader != null;
    }

    public final void updateLayerPersistence() {
        destroy();
        persistLayers(this.layerSet);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean isRobolectric() {
            return LayerManager.isRobolectric;
        }
    }

    static {
        String lowerCase = Build.FINGERPRINT.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        isRobolectric = Intrinsics.areEqual(lowerCase, "robolectric");
    }
}
