package kotlin;

/* JADX INFO: loaded from: classes.dex */
public interface Lazy<T> {
    T getValue();

    boolean isInitialized();
}
