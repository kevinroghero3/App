package okhttp3.internal.platform.android;

import android.util.Log;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class UtilKt {
    private static final int MAX_LOG_LENGTH = 4000;

    public static final void androidLog(int i, @NotNull String message, @Nullable Throwable th) {
        int iMin;
        Intrinsics.checkParameterIsNotNull(message, "message");
        int i2 = i != 5 ? 3 : 5;
        if (th != null) {
            message = message + "\n" + Log.getStackTraceString(th);
        }
        int length = message.length();
        int i3 = 0;
        while (i3 < length) {
            int iIndexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) message, '\n', i3, false, 4, (Object) null);
            if (iIndexOf$default == -1) {
                iIndexOf$default = length;
            }
            while (true) {
                iMin = Math.min(iIndexOf$default, i3 + MAX_LOG_LENGTH);
                String strSubstring = message.substring(i3, iMin);
                Intrinsics.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                Log.println(i2, "OkHttp", strSubstring);
                if (iMin >= iIndexOf$default) {
                    break;
                } else {
                    i3 = iMin;
                }
            }
            i3 = iMin + 1;
        }
    }
}
