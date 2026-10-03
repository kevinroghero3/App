package androidx.compose.ui.modifier;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface ModifierLocalReadScope {
    <T> T getCurrent(@NotNull ModifierLocal<T> modifierLocal);
}
