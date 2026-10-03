package androidx.compose.ui.graphics.layer;

import android.graphics.Bitmap;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface LayerSnapshotImpl {
    Object toBitmap(@NotNull GraphicsLayer graphicsLayer, @NotNull Continuation<? super Bitmap> continuation);
}
