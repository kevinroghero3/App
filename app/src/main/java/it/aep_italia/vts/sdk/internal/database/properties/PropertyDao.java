package it.aep_italia.vts.sdk.internal.database.properties;

/* JADX INFO: loaded from: classes6.dex */
public interface PropertyDao {
    StoredProperty getProperty(String str);

    Long getValue(String str);

    void putValue(StoredProperty storedProperty);

    default void putValue(String str, long j) {
        putValue(new StoredProperty(str, j));
    }

    void removeValue(String str);
}
