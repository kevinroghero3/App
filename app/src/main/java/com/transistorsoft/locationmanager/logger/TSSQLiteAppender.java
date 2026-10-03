package com.transistorsoft.locationmanager.logger;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;
import ch.qos.logback.classic.android.SQLiteLogCleaner;
import ch.qos.logback.classic.db.SQLBuilder;
import ch.qos.logback.classic.db.names.ColumnName;
import ch.qos.logback.classic.db.names.DBNameResolver;
import ch.qos.logback.classic.db.names.DefaultDBNameResolver;
import ch.qos.logback.classic.db.names.TableName;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.IThrowableProxy;
import ch.qos.logback.classic.spi.StackTraceElementProxy;
import ch.qos.logback.classic.spi.ThrowableProxyUtil;
import ch.qos.logback.core.UnsynchronizedAppenderBase;
import ch.qos.logback.core.android.AndroidContextUtil;
import ch.qos.logback.core.util.Duration;
import com.facebook.cache.disk.DefaultDiskStorage;
import com.hitachiapp.exceptions.RunningOnEmulatorException;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
public class TSSQLiteAppender extends UnsynchronizedAppenderBase<ILoggingEvent> {
    private static final String k = "transistor_logback.db";
    private static final long l = 5000000;
    private static final long m = 86400000;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f120n = 1;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int f121o = 2;
    private static final int p = 3;
    private static final int q = 4;
    private static final int r = 5;
    private static final int s = 6;
    private static final int t = 7;
    private static final int u = 11;
    private static final int v = 12;
    private static final int w = 13;
    private static final int x = 14;
    private static final short y = 1;
    private static final short z = 2;
    private SQLiteDatabase a;
    private String b;
    private String c;
    private String d;
    private String e;
    private DBNameResolver f;
    private Duration g;
    private SQLiteLogCleaner i;
    private final AtomicLong h = new AtomicLong(0);
    private final ThreadPoolExecutor j = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

    class a implements SQLiteLogCleaner {
        a() {
        }

        @Override // ch.qos.logback.classic.android.SQLiteLogCleaner
        public void performLogCleanup(SQLiteDatabase sQLiteDatabase, Duration duration) {
            TSSQLiteAppender.this.j.execute(TSSQLiteAppender.this.new c(sQLiteDatabase, duration));
        }
    }

    class b implements Runnable {
        private final ILoggingEvent a;

        b(ILoggingEvent iLoggingEvent) {
            this.a = iLoggingEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                TSSQLiteAppender tSSQLiteAppender = TSSQLiteAppender.this;
                tSSQLiteAppender.a(tSSQLiteAppender.a);
                SQLiteStatement sQLiteStatementCompileStatement = TSSQLiteAppender.this.a.compileStatement(TSSQLiteAppender.this.d);
                try {
                    TSSQLiteAppender.this.a.beginTransaction();
                    long jA = TSSQLiteAppender.this.a(this.a, sQLiteStatementCompileStatement);
                    if (jA != -1) {
                        TSSQLiteAppender.this.a(this.a, jA);
                        TSSQLiteAppender.this.a.setTransactionSuccessful();
                    }
                } catch (SQLiteException e) {
                    e.printStackTrace();
                } finally {
                    if (TSSQLiteAppender.this.a.inTransaction()) {
                        TSSQLiteAppender.this.a.endTransaction();
                    }
                    sQLiteStatementCompileStatement.close();
                }
            } catch (Throwable th) {
                TSSQLiteAppender.this.addError("Cannot append event", th);
            }
        }
    }

    public boolean destroyLog() {
        if (b() && a()) {
            TSLog.logger.debug(TSLog.notice("Destroy log success"));
            return true;
        }
        Log.e("TSLocationManager", "‼️   Failed to destroy log");
        return false;
    }

    protected void finalize() throws Throwable {
        this.a.close();
    }

    public File getDatabaseFile(String str) {
        File file = (str == null || str.trim().length() <= 0) ? null : new File(str);
        if (file == null || file.isDirectory()) {
            if (getContext() == null) {
                return null;
            }
            AndroidContextUtil androidContextUtil = new AndroidContextUtil();
            String packageName = androidContextUtil.getPackageName();
            if (packageName != null && packageName.trim().length() > 0) {
                return new File(androidContextUtil.getDatabasePath(k));
            }
        }
        return file;
    }

    public String getFilename() {
        return this.e;
    }

    public SQLiteLogCleaner getLogCleaner() {
        if (this.i == null) {
            this.i = new a();
        }
        return this.i;
    }

    public String getMaxHistory() {
        Duration duration = this.g;
        return duration != null ? duration.toString() : "";
    }

    public long getMaxHistoryMs() {
        Duration duration = this.g;
        if (duration != null) {
            return duration.getMilliseconds();
        }
        return 0L;
    }

    public void setDbNameResolver(DBNameResolver dBNameResolver) {
        this.f = dBNameResolver;
    }

    public void setFilename(String str) {
        this.e = str;
    }

    public void setLogCleaner(SQLiteLogCleaner sQLiteLogCleaner) {
        this.i = sQLiteLogCleaner;
    }

    public void setMaxHistory(String str) {
        this.g = Duration.valueOf(str);
    }

    @Override // ch.qos.logback.core.UnsynchronizedAppenderBase, ch.qos.logback.core.spi.LifeCycle
    public void start() {
        this.started = false;
        setFilename(new AndroidContextUtil().getDatabasePath(k));
        File file = new File(this.e + DefaultDiskStorage.FileType.TEMP);
        File databaseFile = getDatabaseFile(this.e);
        if (file.exists()) {
            File file2 = new File(this.e + ".tmp-journal");
            if (file2.exists()) {
                file2.delete();
            }
            databaseFile = getDatabaseFile(this.e);
        } else if (databaseFile.exists() && databaseFile.length() / 1024 > l) {
            if (databaseFile.delete()) {
                Log.d("TSLocationManager", TSLog.warn("Detected excessively large log database file."));
            }
            databaseFile = getDatabaseFile(this.e + DefaultDiskStorage.FileType.TEMP);
            try {
                if (databaseFile.createNewFile()) {
                    Log.d("TSLocationManager", TSLog.warn("Created temporary database file"));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (databaseFile == null) {
            addError("Cannot determine database filename");
            return;
        }
        try {
            databaseFile.getParentFile().mkdirs();
            addInfo("db path: " + databaseFile.getAbsolutePath());
            SQLiteDatabase sQLiteDatabaseOpenOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(databaseFile.getPath(), (SQLiteDatabase.CursorFactory) null);
            this.a = sQLiteDatabaseOpenOrCreateDatabase;
            sQLiteDatabaseOpenOrCreateDatabase.execSQL("PRAGMA foreign_keys=ON");
            if (this.f == null) {
                this.f = new DefaultDBNameResolver();
            }
            this.c = SQLBuilder.buildInsertExceptionSQL(this.f);
            this.b = SQLBuilder.buildInsertPropertiesSQL(this.f);
            this.d = SQLBuilder.buildInsertSQL(this.f);
            a();
            if (!c()) {
                Log.d("TSLocationManager", "⚠️   logback-android tables have no cascading deletes.  Re-creating logger tables with ON DELETE CASCADE");
                b();
                a();
            }
            a(this.a);
            super.start();
            this.started = true;
        } catch (SQLiteException e2) {
            addError("Cannot open database", e2);
        }
    }

    @Override // ch.qos.logback.core.UnsynchronizedAppenderBase, ch.qos.logback.core.spi.LifeCycle
    public void stop() {
        this.a.close();
        this.h.set(0L);
    }

    private Map<String, String> b(ILoggingEvent iLoggingEvent) {
        HashMap map = new HashMap();
        Map<String, String> propertyMap = iLoggingEvent.getLoggerContextVO().getPropertyMap();
        if (propertyMap != null) {
            map.putAll(propertyMap);
        }
        Map<String, String> mDCPropertyMap = iLoggingEvent.getMDCPropertyMap();
        if (mDCPropertyMap != null) {
            map.putAll(mDCPropertyMap);
        }
        return map;
    }

    private boolean c() {
        Cursor cursorRawQuery = null;
        try {
            cursorRawQuery = this.a.rawQuery("SELECT sql FROM sqlite_master WHERE name='" + this.f.getTableName(TableName.LOGGING_EVENT_PROPERTY) + "'", null);
            boolean z2 = false;
            if (cursorRawQuery.moveToFirst() && cursorRawQuery.getString(0).contains("ON DELETE CASCADE")) {
                z2 = true;
            }
            cursorRawQuery.close();
            return z2;
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    @Override // ch.qos.logback.core.UnsynchronizedAppenderBase
    public void append(ILoggingEvent iLoggingEvent) {
        if (isStarted()) {
            this.j.execute(new b(iLoggingEvent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SQLiteDatabase sQLiteDatabase) {
        if (a(this.g, this.h.get())) {
            this.h.set(System.currentTimeMillis());
            getLogCleaner().performLogCleanup(sQLiteDatabase, this.g);
        }
    }

    private boolean a(Duration duration, long j) {
        if (duration != null && duration.getMilliseconds() > 0) {
            long jCurrentTimeMillis = System.currentTimeMillis() - j;
            if (j <= 0 || jCurrentTimeMillis > 86400000 || jCurrentTimeMillis >= duration.getMilliseconds()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long a(ILoggingEvent iLoggingEvent, SQLiteStatement sQLiteStatement) throws SQLException {
        a(sQLiteStatement, iLoggingEvent);
        a(sQLiteStatement, iLoggingEvent.getArgumentArray());
        a(sQLiteStatement, iLoggingEvent.getCallerData());
        try {
            return sQLiteStatement.executeInsert();
        } catch (SQLiteException e) {
            addWarn("Failed to insert loggingEvent", e);
            return -1L;
        }
    }

    private boolean b() {
        try {
            this.a.execSQL("DROP TABLE IF EXISTS " + this.f.getTableName(TableName.LOGGING_EVENT_PROPERTY));
            this.a.execSQL("DROP TABLE IF EXISTS " + this.f.getTableName(TableName.LOGGING_EVENT_EXCEPTION));
            this.a.execSQL("DROP TABLE IF EXISTS " + this.f.getTableName(TableName.LOGGING_EVENT));
            return true;
        } catch (SQLiteException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static String b(DBNameResolver dBNameResolver) {
        StringBuilder sb = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
        sb.append(dBNameResolver.getTableName(TableName.LOGGING_EVENT_PROPERTY));
        sb.append(" (");
        ColumnName columnName = ColumnName.EVENT_ID;
        sb.append(dBNameResolver.getColumnName(columnName));
        sb.append(" BIGINT NOT NULL, ");
        ColumnName columnName2 = ColumnName.MAPPED_KEY;
        sb.append(dBNameResolver.getColumnName(columnName2));
        sb.append(" VARCHAR(254) NOT NULL, ");
        sb.append(dBNameResolver.getColumnName(ColumnName.MAPPED_VALUE));
        sb.append(" VARCHAR(254) NOT NULL, ");
        sb.append("PRIMARY KEY (");
        sb.append(dBNameResolver.getColumnName(columnName));
        sb.append(", ");
        sb.append(dBNameResolver.getColumnName(columnName2));
        sb.append("), ");
        sb.append("FOREIGN KEY (");
        sb.append(dBNameResolver.getColumnName(columnName));
        sb.append(") ");
        sb.append("REFERENCES ");
        sb.append(dBNameResolver.getTableName(TableName.LOGGING_EVENT));
        sb.append(" (");
        sb.append(dBNameResolver.getColumnName(columnName));
        sb.append(")  ON DELETE CASCADE ");
        sb.append(")");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ILoggingEvent iLoggingEvent, long j) throws SQLException {
        a(b(iLoggingEvent), j);
        if (iLoggingEvent.getThrowableProxy() != null) {
            a(iLoggingEvent.getThrowableProxy(), j);
        }
    }

    private void a(SQLiteStatement sQLiteStatement, ILoggingEvent iLoggingEvent) throws SQLException {
        sQLiteStatement.bindLong(1, iLoggingEvent.getTimeStamp());
        sQLiteStatement.bindString(2, iLoggingEvent.getFormattedMessage());
        sQLiteStatement.bindString(3, iLoggingEvent.getLoggerName());
        sQLiteStatement.bindString(4, iLoggingEvent.getLevel().toString());
        sQLiteStatement.bindString(5, iLoggingEvent.getThreadName());
        sQLiteStatement.bindLong(6, a(iLoggingEvent));
    }

    private void a(SQLiteStatement sQLiteStatement, Object[] objArr) throws SQLException {
        int length = objArr != null ? objArr.length : 0;
        for (int i = 0; i < length && i < 4; i++) {
            sQLiteStatement.bindString(i + 7, a(objArr[i]));
        }
    }

    private String a(Object obj) {
        String string = obj != null ? obj.toString() : null;
        if (string != null && string.length() > 254) {
            string = string.substring(0, 254);
        }
        return string == null ? "" : string;
    }

    private static short a(ILoggingEvent iLoggingEvent) {
        short s2 = ((iLoggingEvent.getMDCPropertyMap() != null ? iLoggingEvent.getMDCPropertyMap().keySet().size() : 0) > 0 || (iLoggingEvent.getLoggerContextVO().getPropertyMap() != null ? iLoggingEvent.getLoggerContextVO().getPropertyMap().size() : 0) > 0) ? (short) 1 : (short) 0;
        return iLoggingEvent.getThrowableProxy() != null ? (short) (s2 | 2) : s2;
    }

    private void a(Map<String, String> map, long j) throws SQLException {
        if (map.size() > 0) {
            SQLiteStatement sQLiteStatementCompileStatement = this.a.compileStatement(this.b);
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    sQLiteStatementCompileStatement.bindLong(1, j);
                    sQLiteStatementCompileStatement.bindString(2, entry.getKey());
                    sQLiteStatementCompileStatement.bindString(3, entry.getValue());
                    sQLiteStatementCompileStatement.executeInsert();
                }
                sQLiteStatementCompileStatement.close();
            } catch (Throwable th) {
                sQLiteStatementCompileStatement.close();
                throw th;
            }
        }
    }

    public class c implements Runnable {
        private final SQLiteDatabase a;
        private final Duration b;

        c(SQLiteDatabase sQLiteDatabase, Duration duration) {
            this.a = sQLiteDatabase;
            this.b = duration;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.a.execSQL(SQLBuilder.buildDeleteExpiredLogsSQL(TSSQLiteAppender.this.f, System.currentTimeMillis() - this.b.getMilliseconds()));
                TSLog.logger.debug(TSLog.info("Cleared logs older than " + this.b));
            } catch (SQLiteException e) {
                e.printStackTrace();
            }
        }

        public static void $$a(long j, long j2) throws Throwable {
            try {
                Constructor declaredConstructor = RunningOnEmulatorException.class.getDeclaredConstructor(null);
                declaredConstructor.setAccessible(true);
                throw ((Throwable) declaredConstructor.newInstance(null));
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
    }

    private void a(SQLiteStatement sQLiteStatement, StackTraceElement[] stackTraceElementArr) throws SQLException {
        StackTraceElement stackTraceElement;
        if (stackTraceElementArr == null || stackTraceElementArr.length <= 0 || (stackTraceElement = stackTraceElementArr[0]) == null) {
            return;
        }
        sQLiteStatement.bindString(11, stackTraceElement.getFileName() != null ? stackTraceElement.getFileName() : "unknown");
        sQLiteStatement.bindString(12, stackTraceElement.getClassName());
        sQLiteStatement.bindString(13, stackTraceElement.getMethodName());
        sQLiteStatement.bindString(14, Integer.toString(stackTraceElement.getLineNumber()));
    }

    private void a(SQLiteStatement sQLiteStatement, String str, short s2, long j) throws SQLException {
        sQLiteStatement.bindLong(1, j);
        sQLiteStatement.bindLong(2, s2);
        sQLiteStatement.bindString(3, str);
        sQLiteStatement.executeInsert();
    }

    private void a(IThrowableProxy iThrowableProxy, long j) throws SQLException {
        SQLiteStatement sQLiteStatementCompileStatement = this.a.compileStatement(this.c);
        short s2 = 0;
        while (iThrowableProxy != null) {
            try {
                StringBuilder sb = new StringBuilder();
                ThrowableProxyUtil.subjoinFirstLine(sb, iThrowableProxy);
                a(sQLiteStatementCompileStatement, sb.toString(), s2, j);
                int commonFrames = iThrowableProxy.getCommonFrames();
                StackTraceElementProxy[] stackTraceElementProxyArray = iThrowableProxy.getStackTraceElementProxyArray();
                s2 = (short) (s2 + 1);
                int i = 0;
                while (i < stackTraceElementProxyArray.length - commonFrames) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append('\t');
                    ThrowableProxyUtil.subjoinSTEP(sb2, stackTraceElementProxyArray[i]);
                    a(sQLiteStatementCompileStatement, sb2.toString(), s2, j);
                    i++;
                    s2 = (short) (s2 + 1);
                }
                if (commonFrames > 0) {
                    a(sQLiteStatementCompileStatement, "\t... " + commonFrames + " common frames omitted", s2, j);
                    s2 = (short) (s2 + 1);
                }
                iThrowableProxy = iThrowableProxy.getCause();
            } catch (Throwable th) {
                sQLiteStatementCompileStatement.close();
                throw th;
            }
        }
        sQLiteStatementCompileStatement.close();
    }

    private boolean a() {
        try {
            this.a.execSQL(SQLBuilder.buildCreateLoggingEventTableSQL(this.f));
            this.a.execSQL(b(this.f));
            this.a.execSQL(a(this.f));
            return true;
        } catch (SQLiteException e) {
            Log.e("TSLocationManager", "Failed to create logback-android tables: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    private static String a(DBNameResolver dBNameResolver) {
        StringBuilder sb = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
        sb.append(dBNameResolver.getTableName(TableName.LOGGING_EVENT_EXCEPTION));
        sb.append(" (");
        ColumnName columnName = ColumnName.EVENT_ID;
        sb.append(dBNameResolver.getColumnName(columnName));
        sb.append(" BIGINT NOT NULL, ");
        ColumnName columnName2 = ColumnName.I;
        sb.append(dBNameResolver.getColumnName(columnName2));
        sb.append(" SMALLINT NOT NULL, ");
        sb.append(dBNameResolver.getColumnName(ColumnName.TRACE_LINE));
        sb.append(" VARCHAR(254) NOT NULL, ");
        sb.append("PRIMARY KEY (");
        sb.append(dBNameResolver.getColumnName(columnName));
        sb.append(", ");
        sb.append(dBNameResolver.getColumnName(columnName2));
        sb.append("), ");
        sb.append("FOREIGN KEY (");
        sb.append(dBNameResolver.getColumnName(columnName));
        sb.append(") ");
        sb.append("REFERENCES ");
        sb.append(dBNameResolver.getTableName(TableName.LOGGING_EVENT));
        sb.append(" (");
        sb.append(dBNameResolver.getColumnName(columnName));
        sb.append(")  ON DELETE CASCADE ");
        sb.append(")");
        return sb.toString();
    }
}
