package androidx.work.impl.model;

import androidx.lifecycle.LiveData;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public interface PreferenceDao {
    Long getLongValue(@NotNull String str);

    LiveData<Long> getObservableLongValue(@NotNull String str);

    void insertPreference(@NotNull Preference preference);
}
