package androidx.fragment.app;

import android.view.View;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class ViewKt {
    public static final <F extends Fragment> F findFragment(@NotNull View view) {
        return (F) FragmentManager.findFragment(view);
    }
}
