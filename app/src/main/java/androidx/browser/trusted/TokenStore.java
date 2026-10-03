package androidx.browser.trusted;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public interface TokenStore {
    Token load();

    void store(@Nullable Token token);
}
