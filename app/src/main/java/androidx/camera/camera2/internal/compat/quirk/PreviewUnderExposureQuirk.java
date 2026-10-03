package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;
import kotlin.jvm.JvmStatic;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: loaded from: classes2.dex */
public final class PreviewUnderExposureQuirk implements Quirk {
    public static final PreviewUnderExposureQuirk INSTANCE = new PreviewUnderExposureQuirk();
    private static final boolean isTclDevice = StringsKt__StringsJVMKt.equals(Build.BRAND, "TCL", true);

    private PreviewUnderExposureQuirk() {
    }

    @JvmStatic
    public static final boolean load() {
        return isTclDevice;
    }
}
