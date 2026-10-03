package okio.internal;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public interface HashFunction {
    byte[] digest();

    void update(@NotNull byte[] bArr, int i, int i2);
}
