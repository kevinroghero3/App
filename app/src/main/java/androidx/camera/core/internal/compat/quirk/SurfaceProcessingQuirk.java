package androidx.camera.core.internal.compat.quirk;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.Quirk;
import androidx.camera.core.impl.Quirks;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public interface SurfaceProcessingQuirk extends Quirk {
    default boolean workaroundBySurfaceProcessing() {
        return true;
    }

    static boolean workaroundBySurfaceProcessing(@NonNull Quirks quirks) {
        Iterator it2 = quirks.getAll(SurfaceProcessingQuirk.class).iterator();
        while (it2.hasNext()) {
            if (((SurfaceProcessingQuirk) it2.next()).workaroundBySurfaceProcessing()) {
                return true;
            }
        }
        return false;
    }
}
