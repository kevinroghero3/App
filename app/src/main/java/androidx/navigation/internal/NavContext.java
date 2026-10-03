package androidx.navigation.internal;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class NavContext {
    private final Context context;

    public NavContext(@Nullable Context context) {
        this.context = context;
    }

    public final Context getContext() {
        return this.context;
    }

    public final String getResourceName(int i) {
        try {
            Context context = this.context;
            Intrinsics.checkNotNull(context);
            String resourceName = context.getResources().getResourceName(i);
            Intrinsics.checkNotNull(resourceName);
            return resourceName;
        } catch (Resources.NotFoundException unused) {
            return String.valueOf(i);
        }
    }

    public final Object getApplication() {
        Context context = this.context;
        Context applicationContext = context != null ? context.getApplicationContext() : null;
        if (applicationContext instanceof Application) {
            return (Application) applicationContext;
        }
        return null;
    }
}
