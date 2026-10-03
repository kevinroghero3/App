package androidx.fragment.app;

import android.os.Bundle;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentKt {
    public static final void setFragmentResult(@NotNull Fragment fragment, @NotNull String str, @NotNull Bundle bundle) {
        fragment.getParentFragmentManager().setFragmentResult(str, bundle);
    }

    public static final void clearFragmentResult(@NotNull Fragment fragment, @NotNull String str) {
        fragment.getParentFragmentManager().clearFragmentResult(str);
    }

    public static final void setFragmentResultListener(@NotNull Fragment fragment, @NotNull String str, @NotNull final Function2<? super String, ? super Bundle, Unit> function2) {
        fragment.getParentFragmentManager().setFragmentResultListener(str, fragment, new FragmentResultListener() { // from class: androidx.fragment.app.FragmentKt$$ExternalSyntheticLambda0
            @Override // androidx.fragment.app.FragmentResultListener
            public final void onFragmentResult(String str2, Bundle bundle) {
                function2.invoke(str2, bundle);
            }
        });
    }

    public static final void clearFragmentResultListener(@NotNull Fragment fragment, @NotNull String str) {
        fragment.getParentFragmentManager().clearFragmentResultListener(str);
    }
}
