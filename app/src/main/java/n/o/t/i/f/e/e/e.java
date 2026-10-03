package n.o.t.i.f.e.e;

import android.content.Context;
import app.notifee.core.Logger;
import ch.qos.logback.core.CoreConstants;

/* JADX INFO: loaded from: classes.dex */
public class e {
    public static Context a;

    public static void a(Context context) {
        Logger.d(CoreConstants.CONTEXT_SCOPE_VALUE, "received application context");
        a = context;
    }
}
