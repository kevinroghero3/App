package androidx.navigation;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class CollectionNavType<T> extends NavType<T> {
    public abstract T emptyCollection();

    public abstract List<String> serializeAsValues(T t);

    public CollectionNavType(boolean z) {
        super(z);
    }
}
