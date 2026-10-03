package androidx.camera.video.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.internal.compat.quirk.SurfaceProcessingQuirk;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: loaded from: classes2.dex */
public final class PreviewBlackScreenQuirk implements SurfaceProcessingQuirk {
    public static final Companion Companion = new Companion(null);
    private static final boolean isMotorolaEdge20Fusion;

    @JvmStatic
    public static final boolean load() {
        return Companion.load();
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final boolean load() {
            return PreviewBlackScreenQuirk.isMotorolaEdge20Fusion;
        }
    }

    static {
        isMotorolaEdge20Fusion = StringsKt__StringsJVMKt.equals(Build.BRAND, "motorola", true) && StringsKt__StringsJVMKt.equals(Build.MODEL, "motorola edge 20 fusion", true);
    }
}
