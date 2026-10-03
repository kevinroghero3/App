package ch.qos.logback.classic.spi;

import android.os.SystemClock;
import ch.qos.logback.classic.LoggerContext;
import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public class LoggerRemoteView implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static int ICustomTabsCallbackDefault = 0;
    public static int asBinder = 0;
    private static final long serialVersionUID = 5028223666108713696L;
    final LoggerContextVO loggerContextView;
    final String name;

    public LoggerRemoteView(String str, LoggerContext loggerContext) {
        this.name = str;
        this.loggerContextView = loggerContext.getLoggerContextRemoteView();
    }

    public LoggerContextVO getLoggerContextView() {
        return this.loggerContextView;
    }

    public String getName() {
        return this.name;
    }

    public static int TopicBuilder() {
        int i = ICustomTabsCallbackDefault;
        int i2 = i % 6210622;
        ICustomTabsCallbackDefault = i + 1;
        if (i2 != 0) {
            return asBinder;
        }
        int iUptimeMillis = (int) SystemClock.uptimeMillis();
        asBinder = iUptimeMillis;
        return iUptimeMillis;
    }
}
