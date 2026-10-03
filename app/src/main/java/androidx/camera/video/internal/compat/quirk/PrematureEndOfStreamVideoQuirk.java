package androidx.camera.video.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;
import kotlin.jvm.JvmStatic;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: loaded from: classes2.dex */
public final class PrematureEndOfStreamVideoQuirk implements Quirk {
    public static final PrematureEndOfStreamVideoQuirk INSTANCE = new PrematureEndOfStreamVideoQuirk();
    private static final boolean isCph1931;

    private PrematureEndOfStreamVideoQuirk() {
    }

    @JvmStatic
    public static final boolean load() {
        return isCph1931;
    }

    static {
        isCph1931 = StringsKt__StringsJVMKt.equals("OPPO", Build.BRAND, true) && StringsKt__StringsJVMKt.equals("CPH1931", Build.MODEL, true);
    }
}
