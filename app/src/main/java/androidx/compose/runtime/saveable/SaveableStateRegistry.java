package androidx.compose.runtime.saveable;

import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface SaveableStateRegistry {

    public interface Entry {
        void unregister();
    }

    boolean canBeSaved(@NotNull Object obj);

    Object consumeRestored(@NotNull String str);

    Map<String, List<Object>> performSave();

    Entry registerProvider(@NotNull String str, @NotNull Function0<? extends Object> function0);
}
