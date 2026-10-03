package com.google.android.material.color;

import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public interface ColorResourcesOverride {
    boolean applyIfPossible(@NonNull Context context, @NonNull Map<Integer, Integer> map);

    Context wrapContextIfPossible(@NonNull Context context, @NonNull Map<Integer, Integer> map);

    static ColorResourcesOverride getInstance() {
        int i = Build.VERSION.SDK_INT;
        if (30 <= i && i <= 33) {
            return ResourcesLoaderColorResourcesOverride.getInstance();
        }
        if (i >= 34) {
            return ResourcesLoaderColorResourcesOverride.getInstance();
        }
        return null;
    }
}
