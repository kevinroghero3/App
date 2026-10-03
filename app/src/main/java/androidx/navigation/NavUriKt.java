package androidx.navigation;

import android.net.Uri;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class NavUriKt {
    public static final Uri NavUri(@NotNull String uriString) {
        Intrinsics.checkNotNullParameter(uriString, "uriString");
        return NavUriUtils.INSTANCE.parse(uriString);
    }
}
