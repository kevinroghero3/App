package it.aep_italia.vts.sdk.internal;

import android.content.Context;
import com.google.firebase.perf.FirebasePerformance;
import it.aep_italia.vts.sdk.VtsSdkConfiguration;
import it.aep_italia.vts.sdk.utils.DateUtils;
import it.aep_italia.vts.sdk.utils.StringUtils;
import java.io.File;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import timber.log.Timber;

/* JADX INFO: loaded from: classes6.dex */
public class VtsFileLogger extends Timber.DebugTree {
    private Logger a;

    static class b extends Formatter {
        private b() {
        }

        private String a(Level level) {
            if (level == Level.FINEST) {
                return FirebasePerformance.HttpMethod.TRACE;
            }
            if (level == Level.FINER) {
                return "VERBOSE";
            }
            if (level == Level.FINE) {
                return "DEBUG";
            }
            if (level == Level.INFO) {
                return "INFO";
            }
            if (level == Level.WARNING) {
                return "WARN";
            }
            return level == Level.SEVERE ? "ERROR" : "";
        }

        @Override // java.util.logging.Formatter
        public String format(LogRecord logRecord) {
            return StringUtils.padLeftToLength(a(logRecord.getLevel()), 7, ' ') + " | " + DateUtils.toISO8601(new Date(logRecord.getMillis())) + " | " + logRecord.getMessage() + '\n';
        }
    }

    public VtsFileLogger(Context context, VtsSdkConfiguration vtsSdkConfiguration) {
        Logger logger = Logger.getLogger("VtsLog");
        this.a = logger;
        logger.setLevel(Level.ALL);
        this.a.setUseParentHandlers(false);
        for (Handler handler : this.a.getHandlers()) {
            this.a.removeHandler(handler);
        }
        try {
            FileHandler fileHandler = new FileHandler(context.getExternalFilesDir("logs").getPath() + File.separator + "aep.%g.log", true);
            fileHandler.setLevel(Level.ALL);
            if (!vtsSdkConfiguration.loggingUseXml()) {
                fileHandler.setFormatter(new b());
            }
            this.a.addHandler(fileHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // timber.log.Timber.DebugTree, timber.log.Timber.Tree
    public void log(int i, String str, String str2, Throwable th) {
        switch (i) {
            case 2:
                this.a.finer(str2);
                break;
            case 3:
                this.a.fine(str2);
                break;
            case 4:
                this.a.info(str2);
                break;
            case 5:
                this.a.warning(str2);
                break;
            case 6:
            case 7:
                this.a.severe(str2);
                break;
        }
    }
}
