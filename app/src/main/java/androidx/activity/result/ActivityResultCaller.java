package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContract;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public interface ActivityResultCaller {
    <I, O> ActivityResultLauncher<I> registerForActivityResult(@NotNull ActivityResultContract<I, O> activityResultContract, @NotNull ActivityResultCallback<O> activityResultCallback);

    <I, O> ActivityResultLauncher<I> registerForActivityResult(@NotNull ActivityResultContract<I, O> activityResultContract, @NotNull ActivityResultRegistry activityResultRegistry, @NotNull ActivityResultCallback<O> activityResultCallback);
}
