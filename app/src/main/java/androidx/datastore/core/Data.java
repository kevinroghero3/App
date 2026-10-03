package androidx.datastore.core;

/* JADX INFO: loaded from: classes4.dex */
final class Data<T> extends State<T> {
    private final int hashCode;
    private final T value;

    public Data(T t, int i) {
        super(null);
        this.value = t;
        this.hashCode = i;
    }

    public final int getHashCode() {
        return this.hashCode;
    }

    public final T getValue() {
        return this.value;
    }

    public final void checkHashCode() {
        T t = this.value;
        if ((t != null ? t.hashCode() : 0) != this.hashCode) {
            throw new IllegalStateException("Data in DataStore was mutated but DataStore is only compatible with Immutable types.");
        }
    }
}
