package androidx.camera.core.processing;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
public interface ShaderProvider {
    default String createFragmentShader(@NonNull String str, @NonNull String str2) {
        return null;
    }
}
