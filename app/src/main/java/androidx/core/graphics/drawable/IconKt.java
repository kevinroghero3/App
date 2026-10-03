package androidx.core.graphics.drawable;

import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.net.Uri;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class IconKt {
    public static final Icon toAdaptiveIcon(@NotNull Bitmap bitmap) {
        return Icon.createWithAdaptiveBitmap(bitmap);
    }

    public static final Icon toIcon(@NotNull Bitmap bitmap) {
        return Icon.createWithBitmap(bitmap);
    }

    public static final Icon toIcon(@NotNull Uri uri) {
        return Icon.createWithContentUri(uri);
    }

    public static final Icon toIcon(@NotNull byte[] bArr) {
        return Icon.createWithData(bArr, 0, bArr.length);
    }
}
