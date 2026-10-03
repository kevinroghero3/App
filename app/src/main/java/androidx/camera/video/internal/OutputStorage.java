package androidx.camera.video.internal;

import androidx.camera.video.OutputOptions;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public interface OutputStorage {

    public interface Factory {
        OutputStorage create(@NotNull OutputOptions outputOptions);
    }

    long getAvailableBytes();

    OutputOptions getOutputOptions();
}
