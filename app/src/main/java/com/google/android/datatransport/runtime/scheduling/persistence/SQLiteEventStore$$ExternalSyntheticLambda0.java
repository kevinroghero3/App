package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import android.os.Process;
import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class SQLiteEventStore$$ExternalSyntheticLambda0 implements SQLiteEventStore.Function {
    public static int INotificationSideChannel_Parcel;
    public static int access100;
    public final /* synthetic */ SQLiteEventStore f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ Map f$2;
    public final /* synthetic */ ClientMetrics.Builder f$3;

    public /* synthetic */ SQLiteEventStore$$ExternalSyntheticLambda0(SQLiteEventStore sQLiteEventStore, String str, Map map, ClientMetrics.Builder builder) {
        this.f$0 = sQLiteEventStore;
        this.f$1 = str;
        this.f$2 = map;
        this.f$3 = builder;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public final Object apply(Object obj) {
        return this.f$0.lambda$loadClientMetrics$20(this.f$1, this.f$2, this.f$3, (SQLiteDatabase) obj);
    }

    public static int ICustomTabsService() {
        int i = INotificationSideChannel_Parcel;
        int i2 = i % 5411804;
        INotificationSideChannel_Parcel = i + 1;
        if (i2 != 0) {
            return access100;
        }
        int startUptimeMillis = (int) Process.getStartUptimeMillis();
        access100 = startUptimeMillis;
        return startUptimeMillis;
    }
}
