package com.transistorsoft.locationmanager.logger;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.content.FileProvider;
import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.android.LogcatAppender;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import com.transistorsoft.locationmanager.adapter.BackgroundGeolocation;
import com.transistorsoft.locationmanager.adapter.TSConfig;
import com.transistorsoft.locationmanager.adapter.callback.TSCallback;
import com.transistorsoft.locationmanager.adapter.callback.TSEmailLogCallback;
import com.transistorsoft.locationmanager.adapter.callback.TSGetLogCallback;
import com.transistorsoft.locationmanager.data.SQLQuery;
import com.transistorsoft.locationmanager.device.DeviceInfo;
import com.transistorsoft.locationmanager.util.Sensors;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes.dex */
public class TSLog {
    public static final String ACTION_EMAIL_LOG = "emailLog";
    public static final String ACTION_GET_LOG = "getLog";
    public static final String ACTION_LOG = "log";
    public static final String ACTION_UPLOAD_LOG = "uploadLog";
    public static final String BOX_BOTTOM = "╚═════════════════════════════════════════════";
    public static final String BOX_HEADER_BOTTOM = "╠═════════════════════════════════════════════";
    public static final String BOX_HEADER_MIDDLE = "║";
    public static final String BOX_HEADER_TOP = "╔═════════════════════════════════════════════";
    public static final String BOX_ROW = "╟─ ";
    public static final String CRLF = "\n";
    public static final String HR = "╔══════════════════════════════════════════════";
    public static final String ICON_ACTIVITY = "🚘 ️";
    public static final String ICON_ALARM = "⏰ ";
    public static final String ICON_CALENDAR = "📅  ";
    public static final String ICON_CANCEL = "❌ ";
    public static final String ICON_CHECK = "✅  ";
    public static final String ICON_ERROR = "‼️  ";
    public static final String ICON_HOURGLASS = "⏳";
    public static final String ICON_INFO = "ℹ️  ";
    public static final String ICON_NOTICE = "🔵  ";
    public static final String ICON_OFF = "🔴  ";
    public static final String ICON_ON = "🎾  ";
    public static final String ICON_PIN = "📍  ";
    public static final String ICON_SIGNAL_BARS = "📶  ";
    public static final String ICON_WARN = "⚠️  ";
    public static final String LOG_FILENAME = "background-geolocation.log.gz";
    public static final String TAB = "  ";
    public static final String TREE_SW = "└";
    private static final String c = "[%class{30} %method] %msg";
    private static final String d = "sqlite";
    private static final String e = "7 days";
    private static final String f = "debug";
    private static final String g = "warn";
    private static final String h = "error";
    private static final String i = "info";
    private static final String j = "notice";
    private static final String k = "header";
    private static final String l = "on";
    private static final String m = "off";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String f119n = "ok";
    private static final AtomicBoolean a = new AtomicBoolean(false);
    private static final AtomicBoolean b = new AtomicBoolean(false);
    public static Logger logger = new LoggerFacade();

    /* JADX INFO: loaded from: classes3.dex */
    public static class DestroyLogTask implements Runnable {
        private final TSCallback a;

        DestroyLogTask(TSCallback tSCallback) {
            this.a = tSCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TSLog.getDatabaseAppender().destroyLog()) {
                this.a.onSuccess();
            } else {
                this.a.onFailure("Failed to destroy log");
            }
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    static class a implements Runnable {
        private static final String e = "BackgroundGeolocation log";
        private static final String f = "message/rfc822";
        private final String a;
        private final WeakReference<Activity> b;
        private final TSEmailLogCallback c;
        private final SQLQuery d;

        public a(Activity activity, String str, @Nullable SQLQuery sQLQuery, TSEmailLogCallback tSEmailLogCallback) {
            this.a = str;
            this.b = new WeakReference<>(activity);
            this.c = tSEmailLogCallback;
            this.d = sQLQuery;
        }

        @Override // java.lang.Runnable
        public void run() {
            Activity activity = this.b.get();
            if (activity == null) {
                this.c.onFailure("Failed to fetch Activity from WeakReference.  It seems the application process has been destroyed.");
                return;
            }
            Context applicationContext = activity.getApplicationContext();
            String log = TSLogReader.getLog(this.d);
            if (log == null) {
                this.c.onFailure("Failed to read log database.");
                return;
            }
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType(f);
            intent.putExtra("android.intent.extra.EMAIL", new String[]{this.a});
            intent.putExtra("android.intent.extra.SUBJECT", e);
            TSConfig tSConfig = TSConfig.getInstance(applicationContext);
            StringBuilder sb = new StringBuilder();
            sb.append(TSLog.header("TSLocationManager3.7.0 (444)"));
            sb.append(TSLog.boxRow(DeviceInfo.getInstance(applicationContext).print()));
            try {
                sb.append(tSConfig.toJson(true).toString(2));
            } catch (JSONException e2) {
                TSLog.logger.error(TSLog.error("Failed to write state to email body: " + e2.getMessage()), (Throwable) e2);
            }
            sb.append(Sensors.getInstance(applicationContext).print().toString());
            intent.putExtra("android.intent.extra.TEXT", sb.toString());
            File fileWriteLogFile = TSLog.writeLogFile(applicationContext, log);
            if (fileWriteLogFile == null) {
                this.c.onFailure("Failed to write log file");
                return;
            }
            intent.putExtra("android.intent.extra.STREAM", FileProvider.getUriForFile(applicationContext, applicationContext.getPackageName() + ".tslocationmanager.fileprovider", fileWriteLogFile));
            fileWriteLogFile.deleteOnExit();
            intent.setFlags(1);
            intent.setFlags(2);
            try {
                if (intent.hasExtra("error")) {
                    this.c.onFailure(intent.getStringExtra("error"));
                    return;
                }
                activity.startActivityForResult(Intent.createChooser(intent, "Send log: " + this.a + "..."), 1);
                this.c.onSuccess();
            } catch (ActivityNotFoundException e3) {
                TSLog.logger.warn(TSLog.warn(e3.getMessage()));
                intent.putExtra("error", "NO_EMAIL_CLIENT");
                this.c.onFailure("NO_EMAIL_CLIENT");
            }
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    static class b implements Runnable {
        private final TSGetLogCallback a;
        private final SQLQuery b;

        b(SQLQuery sQLQuery, TSGetLogCallback tSGetLogCallback) {
            this.b = sQLQuery;
            this.a = tSGetLogCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                String log = TSLogReader.getLog(this.b);
                if (log != null) {
                    this.a.onSuccess(log);
                } else {
                    this.a.onFailure("Failed to fetch logs");
                }
            } catch (Exception e) {
                this.a.onSuccess(e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(int i2, int i3) {
        ch.qos.logback.classic.Logger loggerA = a();
        loggerA.setLevel(a(i2));
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        loggerContext.reset();
        PatternLayoutEncoder patternLayoutEncoder = new PatternLayoutEncoder();
        patternLayoutEncoder.setContext(loggerContext);
        patternLayoutEncoder.setPattern(c);
        patternLayoutEncoder.start();
        LogcatAppender logcatAppender = new LogcatAppender();
        logcatAppender.setContext(loggerContext);
        logcatAppender.setEncoder(patternLayoutEncoder);
        logcatAppender.start();
        loggerA.addAppender(logcatAppender);
        TSSQLiteAppender tSSQLiteAppender = new TSSQLiteAppender();
        tSSQLiteAppender.setName(d);
        tSSQLiteAppender.setMaxHistory(i3 + " days");
        tSSQLiteAppender.setContext(loggerContext);
        loggerA.addAppender(tSSQLiteAppender);
        tSSQLiteAppender.start();
        List<LoggerFacade.a> queue = ((LoggerFacade) logger).getQueue();
        if (!(LoggerFactory.getLogger("TSLocationManager") instanceof ch.qos.logback.classic.Logger)) {
            Log.e("TSLocationManager", "‼️  TSLog LoggerFactory returned an instance of SubstituteLogger.  Logger is disabled ‼️");
            ((LoggerFacade) logger).a();
            return;
        }
        logger = LoggerFactory.getLogger("TSLocationManager");
        setLogLevel(i2);
        setMaxHistory(i3);
        Iterator<LoggerFacade.a> it2 = queue.iterator();
        while (it2.hasNext()) {
            it2.next().a(logger);
        }
    }

    public static String activity(String str) {
        return "\n  🚘 ️" + str;
    }

    public static String alarm(String str) {
        return "\n  ⏰ " + str;
    }

    private static boolean b() {
        return a.get() && b.get();
    }

    public static String box(String str) {
        return "╔═════════════════════════════════════════════\n║ " + str + "\n" + BOX_HEADER_BOTTOM + "\n";
    }

    public static String boxRow(String str) {
        return BOX_ROW + str + "\n";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(int i2) {
        a().setLevel(a(i2));
    }

    public static String calendar(String str) {
        return "\n  📅  " + str;
    }

    public static String cancel(String str) {
        return "\n  ❌ " + str;
    }

    public static String connectivity(String str) {
        return "\n  📶  " + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(int i2) {
        getDatabaseAppender().setMaxHistory(i2 + " days");
    }

    public static void destroyLog(TSCallback tSCallback) {
        BackgroundGeolocation.getThreadPool().execute(new DestroyLogTask(tSCallback));
    }

    public static void emailLog(String str, Activity activity, TSEmailLogCallback tSEmailLogCallback) {
        BackgroundGeolocation.getThreadPool().execute(new a(activity, str, new SQLQuery(), tSEmailLogCallback));
    }

    public static String error(String str) {
        return "\n  ‼️  " + str;
    }

    public static TSSQLiteAppender getDatabaseAppender() {
        return (TSSQLiteAppender) a().getAppender(d);
    }

    public static File getDatabaseFile() {
        TSSQLiteAppender databaseAppender = getDatabaseAppender();
        if (databaseAppender != null) {
            return databaseAppender.getDatabaseFile(databaseAppender.getFilename());
        }
        logger.error(error("Failed to locate sqlite database appender"));
        return null;
    }

    public static void getLog(TSGetLogCallback tSGetLogCallback) {
        getLog(SQLQuery.create(), tSGetLogCallback);
    }

    public static String header(String str) {
        return "\n" + box(str);
    }

    public static String info(String str) {
        return "\n  ℹ️  " + str;
    }

    public static void initialize(final int i2, final int i3) {
        if (logger.getClass() != LoggerFacade.class) {
            return;
        }
        BackgroundGeolocation.getThreadPool().execute(new Runnable() { // from class: com.transistorsoft.locationmanager.logger.TSLog$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                TSLog.a(i2, i3);
            }
        });
    }

    public static void log(String str, String str2) {
        if ("error".equalsIgnoreCase(str)) {
            logger.error(error(str2));
            return;
        }
        if ("warn".equalsIgnoreCase(str)) {
            logger.warn(warn(str2));
            return;
        }
        if ("debug".equalsIgnoreCase(str)) {
            logger.debug(str2);
            return;
        }
        if ("info".equalsIgnoreCase(str)) {
            logger.info(info(str2));
            return;
        }
        if (j.equalsIgnoreCase(str)) {
            logger.info(notice(str2));
            return;
        }
        if (k.equalsIgnoreCase(str)) {
            logger.info(header(str2));
            return;
        }
        if ("on".equalsIgnoreCase(str)) {
            logger.info(on(str2));
        } else if ("off".equalsIgnoreCase(str)) {
            logger.info(off(str2));
        } else if (f119n.equalsIgnoreCase(str)) {
            logger.info(ok(str2));
        }
    }

    public static String notice(String str) {
        return "\n  🔵  " + str;
    }

    public static String off(String str) {
        return "\n  🔴  " + str;
    }

    public static String ok(String str) {
        return "\n  ✅  " + str;
    }

    public static String on(String str) {
        return "\n  🎾  " + str;
    }

    public static String pin(String str) {
        return "\n  📍  " + str;
    }

    public static void r(boolean z) {
        b.set(z);
        a.set(true);
    }

    public static void setLogLevel(final int i2) {
        if (logger.getClass() == LoggerFacade.class) {
            return;
        }
        BackgroundGeolocation.getThreadPool().execute(new Runnable() { // from class: com.transistorsoft.locationmanager.logger.TSLog$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                TSLog.c(i2);
            }
        });
    }

    public static void setMaxHistory(final int i2) {
        BackgroundGeolocation.getThreadPool().execute(new Runnable() { // from class: com.transistorsoft.locationmanager.logger.TSLog$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                TSLog.d(i2);
            }
        });
    }

    public static void uploadLog(Context context, String str, SQLQuery sQLQuery, TSCallback tSCallback) {
        new com.transistorsoft.locationmanager.logger.a(context, str, sQLQuery, tSCallback);
    }

    public static String warn(String str) {
        return "\n  ⚠️  " + str;
    }

    public static File writeLogFile(Context context, String str) {
        File file = new File(context.getCacheDir(), LOG_FILENAME);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(str.length());
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                gZIPOutputStream.write(str.getBytes());
                gZIPOutputStream.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                fileOutputStream.write(byteArray);
                fileOutputStream.close();
                return file;
            } catch (IOException e2) {
                logger.error(error(e2.getMessage()), (Throwable) e2);
                e2.printStackTrace();
                return null;
            }
        } catch (FileNotFoundException e3) {
            logger.error(error(e3.getMessage()), (Throwable) e3);
            return null;
        }
    }

    private static String b(int i2) {
        return i2 + " days";
    }

    public static void emailLog(Activity activity, String str, SQLQuery sQLQuery, TSEmailLogCallback tSEmailLogCallback) {
        BackgroundGeolocation.getThreadPool().execute(new a(activity, str, sQLQuery, tSEmailLogCallback));
    }

    public static void getLog(SQLQuery sQLQuery, TSGetLogCallback tSGetLogCallback) {
        BackgroundGeolocation.getThreadPool().execute(new b(sQLQuery, tSGetLogCallback));
    }

    private static Level a(int i2) {
        if (!b()) {
            i2 = 0;
        }
        Level level = Level.ALL;
        if (i2 == 0) {
            return Level.OFF;
        }
        if (i2 == 1) {
            return Level.ERROR;
        }
        if (i2 == 2) {
            return Level.WARN;
        }
        if (i2 != 3) {
            return i2 != 4 ? level : Level.DEBUG;
        }
        return Level.INFO;
    }

    private static ch.qos.logback.classic.Logger a() {
        return (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
    }
}
