package androidx.camera.core;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.Identifier;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface CameraFilter {
    public static final Identifier DEFAULT_ID = Identifier.create(new Object());

    List<CameraInfo> filter(@NonNull List<CameraInfo> list);

    default Identifier getIdentifier() {
        return DEFAULT_ID;
    }
}
