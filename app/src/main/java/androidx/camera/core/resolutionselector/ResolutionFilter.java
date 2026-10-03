package androidx.camera.core.resolutionselector;

import android.util.Size;
import androidx.annotation.NonNull;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface ResolutionFilter {
    List<Size> filter(@NonNull List<Size> list, int i);
}
