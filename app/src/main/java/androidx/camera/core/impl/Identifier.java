package androidx.camera.core.impl;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Identifier {
    public abstract Object getValue();

    public static Identifier create(@NonNull Object obj) {
        return new AutoValue_Identifier(obj);
    }
}
