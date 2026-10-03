package androidx.navigation.serialization;

import android.os.Bundle;
import androidx.navigation.NavType;
import androidx.savedstate.SavedStateReader;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
final class SavedStateArgStore extends ArgStore {
    private final Bundle savedState;
    private final Map<String, NavType<?>> typeMap;

    /* JADX WARN: Multi-variable type inference failed */
    public SavedStateArgStore(@NotNull Bundle savedState, @NotNull Map<String, ? extends NavType<?>> typeMap) {
        Intrinsics.checkNotNullParameter(savedState, "savedState");
        Intrinsics.checkNotNullParameter(typeMap, "typeMap");
        this.savedState = savedState;
        this.typeMap = typeMap;
    }

    @Override // androidx.navigation.serialization.ArgStore
    public Object get(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        NavType<?> navType = this.typeMap.get(key);
        if (navType != null) {
            return navType.get(this.savedState, key);
        }
        return null;
    }

    @Override // androidx.navigation.serialization.ArgStore
    public boolean contains(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return SavedStateReader.m4026containsimpl(SavedStateReader.m4025constructorimpl(this.savedState), key);
    }
}
