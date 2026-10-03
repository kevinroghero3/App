package androidx.camera.video.internal.compat.quirk;

import android.os.Build;
import androidx.annotation.Nullable;
import androidx.camera.core.impl.Quirk;

/* JADX INFO: loaded from: classes2.dex */
public class CodecStuckOnFlushQuirk implements Quirk {
    static boolean load() {
        return isNokia1();
    }

    private static boolean isNokia1() {
        return "Nokia".equalsIgnoreCase(Build.BRAND) && "Nokia 1".equalsIgnoreCase(Build.MODEL);
    }

    public boolean isProblematicMimeType(@Nullable String str) {
        return "video/mp4v-es".equals(str);
    }
}
