package androidx.startup;

import android.content.Context;
import androidx.annotation.NonNull;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface Initializer<T> {
    T create(@NonNull Context context);

    List<Class<? extends Initializer<?>>> dependencies();
}
