package androidx.compose.ui;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class ZIndexModifierKt {
    public static final Modifier zIndex(@NotNull Modifier modifier, float f) {
        return modifier.then(new ZIndexElement(f));
    }
}
