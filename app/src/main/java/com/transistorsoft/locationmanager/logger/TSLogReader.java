package com.transistorsoft.locationmanager.logger;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import ch.qos.logback.classic.db.names.ColumnName;
import ch.qos.logback.classic.db.names.DefaultDBNameResolver;
import ch.qos.logback.classic.db.names.TableName;
import com.transistorsoft.locationmanager.data.SQLQuery;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes.dex */
public class TSLogReader {
    private static final SimpleDateFormat b;
    private static final String c = "MM-dd HH:mm:ss.SSS";
    private static final String d = "Failed to open database";
    private static final String[] e = {ColumnName.EVENT_ID.toString(), ColumnName.TIMESTMP.toString(), ColumnName.LEVEL_STRING.toString(), ColumnName.CALLER_CLASS.toString(), ColumnName.CALLER_METHOD.toString(), ColumnName.FORMATTED_MESSAGE.toString()};
    private static final DefaultDBNameResolver a = new DefaultDBNameResolver();

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(c, Locale.ENGLISH);
        b = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getDefault());
    }

    private static String a(Cursor cursor, Map<Long, String> map) {
        StringBuffer stringBuffer = new StringBuffer(1024);
        try {
            DefaultDBNameResolver defaultDBNameResolver = a;
            long j = cursor.getInt(cursor.getColumnIndex(defaultDBNameResolver.getColumnName(ColumnName.EVENT_ID)));
            stringBuffer.append(b.format(Long.valueOf(cursor.getLong(cursor.getColumnIndex(defaultDBNameResolver.getColumnName(ColumnName.TIMESTMP))))));
            stringBuffer.append(StringUtils.SPACE);
            stringBuffer.append(cursor.getString(cursor.getColumnIndex(defaultDBNameResolver.getColumnName(ColumnName.LEVEL_STRING))));
            stringBuffer.append(StringUtils.SPACE);
            stringBuffer.append("[");
            String[] strArrSplit = cursor.getString(cursor.getColumnIndex(defaultDBNameResolver.getColumnName(ColumnName.CALLER_CLASS))).split("\\.");
            if (strArrSplit.length > 0) {
                stringBuffer.append(strArrSplit[strArrSplit.length - 1]);
            }
            stringBuffer.append(StringUtils.SPACE);
            stringBuffer.append(cursor.getString(cursor.getColumnIndex(defaultDBNameResolver.getColumnName(ColumnName.CALLER_METHOD))));
            stringBuffer.append("] ");
            stringBuffer.append(cursor.getString(cursor.getColumnIndex(defaultDBNameResolver.getColumnName(ColumnName.FORMATTED_MESSAGE))));
            if (map.containsKey(Long.valueOf(j))) {
                stringBuffer.append("\n");
                stringBuffer.append(map.get(Long.valueOf(j)));
            }
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
            stringBuffer.append(TSLog.error("FAILURE DURING getLog: " + e2.getMessage()));
        }
        stringBuffer.append("\n");
        return stringBuffer.toString();
    }

    public static String getLog(SQLQuery sQLQuery) {
        Cursor cursorQuery;
        SQLiteDatabase sQLiteDatabaseA = a(1);
        Cursor cursorQuery2 = null;
        if (sQLiteDatabaseA == null || !sQLiteDatabaseA.isOpen()) {
            TSLog.logger.error(TSLog.error(d));
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            DefaultDBNameResolver defaultDBNameResolver = a;
            String selection = sQLQuery.getSelection(defaultDBNameResolver);
            cursorQuery = sQLiteDatabaseA.query(false, defaultDBNameResolver.getTableName(TableName.LOGGING_EVENT_EXCEPTION), null, null, null, null, null, ColumnName.EVENT_ID + " ASC", null);
            try {
                HashMap map = new HashMap();
                long j = 0;
                while (cursorQuery.moveToNext()) {
                    long j2 = cursorQuery.getInt(0);
                    if (j != 0 && j2 != j) {
                        map.put(Long.valueOf(j), stringBuffer.toString());
                        stringBuffer.setLength(0);
                    }
                    stringBuffer.append(cursorQuery.getString(cursorQuery.getColumnIndex(a.getColumnName(ColumnName.TRACE_LINE))) + "\n");
                    j = j2;
                }
                if (j != 0) {
                    map.put(Long.valueOf(j), stringBuffer.toString());
                }
                stringBuffer.setLength(0);
                cursorQuery.close();
                String str = sQLQuery.getOrder() == SQLQuery.ORDER_ASC ? "ASC" : "DESC";
                String strValueOf = sQLQuery.getLimit() > 0 ? String.valueOf(sQLQuery.getLimit()) : null;
                cursorQuery2 = sQLiteDatabaseA.query(false, a.getTableName(TableName.LOGGING_EVENT), e, selection, null, null, null, ColumnName.TIMESTMP + StringUtils.SPACE + str, strValueOf);
                while (cursorQuery2.moveToNext()) {
                    stringBuffer.append(a(cursorQuery2, map));
                }
                cursorQuery2.close();
                if (!cursorQuery2.isClosed()) {
                    cursorQuery2.close();
                }
                sQLiteDatabaseA.close();
                return stringBuffer.toString();
            } catch (Throwable th) {
                th = th;
                if (cursorQuery != null && !cursorQuery.isClosed()) {
                    cursorQuery.close();
                }
                sQLiteDatabaseA.close();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = cursorQuery2;
        }
    }

    private static SQLiteDatabase a(int i) {
        File databaseFile = TSLog.getDatabaseFile();
        if (databaseFile == null) {
            return null;
        }
        return SQLiteDatabase.openDatabase(databaseFile.getPath(), null, i);
    }
}
