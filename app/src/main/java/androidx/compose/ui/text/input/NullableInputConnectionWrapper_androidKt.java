package androidx.compose.ui.text.input;

import android.os.Build;
import android.view.inputmethod.InputConnection;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class NullableInputConnectionWrapper_androidKt {
    public static final NullableInputConnectionWrapper NullableInputConnectionWrapper(@NotNull InputConnection inputConnection, @NotNull Function1<? super NullableInputConnectionWrapper, Unit> function1) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 34) {
            return new NullableInputConnectionWrapperApi34(inputConnection, function1);
        }
        if (i >= 25) {
            return new NullableInputConnectionWrapperApi25(inputConnection, function1);
        }
        return new NullableInputConnectionWrapperApi24(inputConnection, function1);
    }
}
