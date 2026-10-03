package androidx.navigation.compose;

import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.navigation.compose.internal.NavComposeUtils_androidKt;
import androidx.navigation.compose.internal.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class BackStackEntryIdViewModel extends ViewModel {
    public static final int $stable = 8;
    private final String IdKey = "SaveableStateHolder_BackStackEntryKey";
    private final String id;
    public WeakReference<SaveableStateHolder> saveableStateHolderRef;

    public BackStackEntryIdViewModel(@NotNull SavedStateHandle savedStateHandle) {
        String strRandomUUID = (String) savedStateHandle.get("SaveableStateHolder_BackStackEntryKey");
        if (strRandomUUID == null) {
            strRandomUUID = NavComposeUtils_androidKt.randomUUID();
            savedStateHandle.set("SaveableStateHolder_BackStackEntryKey", strRandomUUID);
        }
        this.id = strRandomUUID;
    }

    public final String getId() {
        return this.id;
    }

    public final WeakReference<SaveableStateHolder> getSaveableStateHolderRef() {
        WeakReference<SaveableStateHolder> weakReference = this.saveableStateHolderRef;
        if (weakReference != null) {
            return weakReference;
        }
        Intrinsics.throwUninitializedPropertyAccessException("saveableStateHolderRef");
        return null;
    }

    public final void setSaveableStateHolderRef(@NotNull WeakReference<SaveableStateHolder> weakReference) {
        this.saveableStateHolderRef = weakReference;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        SaveableStateHolder saveableStateHolder = getSaveableStateHolderRef().get();
        if (saveableStateHolder != null) {
            saveableStateHolder.removeState(this.id);
        }
        getSaveableStateHolderRef().clear();
    }
}
