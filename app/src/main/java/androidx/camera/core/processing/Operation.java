package androidx.camera.core.processing;

import androidx.annotation.NonNull;
import androidx.camera.core.ImageCaptureException;

/* JADX INFO: loaded from: classes2.dex */
public interface Operation<I, O> {
    O apply(@NonNull I i) throws ImageCaptureException;
}
