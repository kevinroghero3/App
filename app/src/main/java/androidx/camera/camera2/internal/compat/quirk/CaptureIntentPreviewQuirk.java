package androidx.camera.camera2.internal.compat.quirk;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.Quirk;
import androidx.camera.core.impl.Quirks;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public interface CaptureIntentPreviewQuirk extends Quirk {
    default boolean workaroundByCaptureIntentPreview() {
        return true;
    }

    static boolean workaroundByCaptureIntentPreview(@NonNull Quirks quirks) {
        Iterator it2 = quirks.getAll(CaptureIntentPreviewQuirk.class).iterator();
        while (it2.hasNext()) {
            if (((CaptureIntentPreviewQuirk) it2.next()).workaroundByCaptureIntentPreview()) {
                return true;
            }
        }
        return false;
    }
}
