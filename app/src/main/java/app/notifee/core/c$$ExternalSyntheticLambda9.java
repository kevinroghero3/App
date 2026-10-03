package app.notifee.core;

import app.notifee.core.model.NotificationAndroidModel;
import app.notifee.core.model.NotificationModel;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class c$$ExternalSyntheticLambda9 implements Callable {
    public static int g;
    public static int h;
    public final /* synthetic */ NotificationAndroidModel f$0;
    public final /* synthetic */ NotificationModel f$1;

    public /* synthetic */ c$$ExternalSyntheticLambda9(NotificationAndroidModel notificationAndroidModel, NotificationModel notificationModel) {
        this.f$0 = notificationAndroidModel;
        this.f$1 = notificationModel;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return c.a(this.f$0, this.f$1);
    }

    public static int ArtificialStackFrames() {
        int i = g;
        int i2 = i % 8357078;
        g = i + 1;
        if (i2 != 0) {
            return h;
        }
        int iFreeMemory = (int) Runtime.getRuntime().freeMemory();
        h = iFreeMemory;
        return iFreeMemory;
    }
}
