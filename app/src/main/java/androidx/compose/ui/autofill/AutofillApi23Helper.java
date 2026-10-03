package androidx.compose.ui.autofill;

import android.view.ViewStructure;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class AutofillApi23Helper {
    public static final int $stable = 0;
    public static final AutofillApi23Helper INSTANCE = new AutofillApi23Helper();

    private AutofillApi23Helper() {
    }

    public final ViewStructure newChild(@NotNull ViewStructure viewStructure, int i) {
        return viewStructure.newChild(i);
    }

    public final int addChildCount(@NotNull ViewStructure viewStructure, int i) {
        return viewStructure.addChildCount(i);
    }

    public final void setId(@NotNull ViewStructure viewStructure, int i, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        viewStructure.setId(i, str, str2, str3);
    }

    public final void setDimens(@NotNull ViewStructure viewStructure, int i, int i2, int i3, int i4, int i5, int i6) {
        viewStructure.setDimens(i, i2, i3, i4, i5, i6);
    }
}
