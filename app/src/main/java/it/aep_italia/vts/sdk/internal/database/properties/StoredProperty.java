package it.aep_italia.vts.sdk.internal.database.properties;

import androidx.annotation.NonNull;
import java.util.Date;

/* JADX INFO: loaded from: classes6.dex */
public class StoredProperty {
    public static final String ACTIVE_VTOKEN = "activeVTokenUID";
    public static final String DOWNLOAD_COUNTER = "downloadCounter";
    public static final String LAST_SYNCHRONIZATION = "lastSynchronization";
    public static final String NEXT_SYNCHRONIZATION = "nextSynchronization";
    private String a;
    private long b;
    private long c;

    public StoredProperty(String str, long j) {
        this.a = str;
        this.b = j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.a.equals(((StoredProperty) obj).a);
    }

    public long getLastUpdated() {
        long j = this.c;
        return j == 0 ? new Date().getTime() : j;
    }

    public String getName() {
        return this.a;
    }

    public long getValue() {
        return this.b;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public void setLastUpdated(long j) {
        this.c = j;
    }

    public void setName(@NonNull String str) {
        this.a = str;
    }

    public void setValue(long j) {
        this.b = j;
    }

    public void setValueAndUpdate(long j) {
        this.b = j;
        this.c = new Date().getTime();
    }
}
