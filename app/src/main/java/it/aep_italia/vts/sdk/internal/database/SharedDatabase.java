package it.aep_italia.vts.sdk.internal.database;

import androidx.room.Room;
import androidx.room.RoomDatabase;
import it.aep_italia.vts.sdk.core.VtsSdk;
import it.aep_italia.vts.sdk.internal.database.images.ImageDao;
import it.aep_italia.vts.sdk.internal.database.properties.PropertyDao;
import it.aep_italia.vts.sdk.internal.database.receipts.ReceiptDao;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public abstract class SharedDatabase extends RoomDatabase {
    private static Map<a, SharedDatabase> a = new HashMap();

    static class a {
        private int a;
        private int b;

        public a(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.b == aVar.b;
        }

        public int hashCode() {
            return (this.a * 31) + this.b;
        }
    }

    public static SharedDatabase getInstance(VtsSdk vtsSdk) {
        a aVar = new a(vtsSdk.getSystemType(), vtsSdk.getSystemSubType());
        String version = vtsSdk.getVersion();
        if (!a.containsKey(aVar)) {
            a.put(aVar, (SharedDatabase) Room.databaseBuilder(vtsSdk.getContext(), SharedDatabase.class, String.format(Locale.ITALY, "aep.italia.shared.%d.%d.%s", Integer.valueOf(vtsSdk.getSystemType()), Integer.valueOf(vtsSdk.getSystemSubType()), version)).allowMainThreadQueries().build());
        }
        return a.get(aVar);
    }

    public abstract ImageDao imageDao();

    public abstract PropertyDao propertyDao();

    public abstract ReceiptDao receiptDao();
}
