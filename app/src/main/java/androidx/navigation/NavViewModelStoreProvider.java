package androidx.navigation;

import androidx.lifecycle.ViewModelStore;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface NavViewModelStoreProvider {
    ViewModelStore getViewModelStore(@NotNull String str);
}
