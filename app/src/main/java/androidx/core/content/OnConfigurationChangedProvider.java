package androidx.core.content;

import android.content.res.Configuration;
import androidx.core.util.Consumer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public interface OnConfigurationChangedProvider {
    void addOnConfigurationChangedListener(@NotNull Consumer<Configuration> consumer);

    void removeOnConfigurationChangedListener(@NotNull Consumer<Configuration> consumer);
}
