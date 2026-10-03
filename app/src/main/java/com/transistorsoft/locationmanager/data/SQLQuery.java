package com.transistorsoft.locationmanager.data;

import ch.qos.logback.classic.db.names.ColumnName;
import ch.qos.logback.classic.db.names.DefaultDBNameResolver;
import java.util.ArrayList;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes.dex */
public class SQLQuery {
    public static String FIELD_END = "end";
    public static String FIELD_LIMIT = "limit";
    public static String FIELD_ORDER = "order";
    public static String FIELD_START = "start";
    public static int ORDER_ASC = 1;
    public static int ORDER_DESC = -1;
    private long a;
    private long b;
    private int c = ORDER_ASC;
    private int d;

    public static SQLQuery create() {
        return new SQLQuery();
    }

    public static SQLQuery fromMap(Map map) {
        SQLQuery sQLQuery = new SQLQuery();
        if (map.containsKey(FIELD_START)) {
            sQLQuery.setStart(((Long) map.get(FIELD_START)).longValue());
        }
        if (map.containsKey(FIELD_END)) {
            sQLQuery.setEnd(((Long) map.get(FIELD_END)).longValue());
        }
        if (map.containsKey(FIELD_ORDER)) {
            sQLQuery.setOrder(((Integer) map.get(FIELD_ORDER)).intValue());
        }
        if (map.containsKey(FIELD_LIMIT)) {
            sQLQuery.setLimit(((Integer) map.get(FIELD_LIMIT)).intValue());
        }
        return sQLQuery;
    }

    public long getEnd() {
        return this.b;
    }

    public int getLimit() {
        return this.d;
    }

    public int getOrder() {
        return this.c;
    }

    public String getSelection(DefaultDBNameResolver defaultDBNameResolver) {
        if (this.a == 0 && this.b == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.a > 0) {
            arrayList.add(defaultDBNameResolver.getColumnName(ColumnName.TIMESTMP) + " >= " + this.a);
        }
        if (this.b > 0) {
            arrayList.add(defaultDBNameResolver.getColumnName(ColumnName.TIMESTMP) + " <= " + this.b);
        }
        String str = "" + ((String) arrayList.get(0));
        if (arrayList.size() <= 1) {
            return str;
        }
        return str + " AND " + ((String) arrayList.get(1));
    }

    public long getStart() {
        return this.a;
    }

    public SQLQuery setEnd(long j) {
        this.b = j;
        return this;
    }

    public SQLQuery setLimit(int i) {
        this.d = i;
        return this;
    }

    public SQLQuery setOrder(int i) {
        int i2 = ORDER_ASC;
        if (i != i2 && i != ORDER_DESC) {
            i = i2;
        }
        this.c = i;
        return this;
    }

    public SQLQuery setStart(long j) {
        this.a = j;
        return this;
    }

    public String toString() {
        return "[LogQuery " + FIELD_START + "=" + this.a + StringUtils.SPACE + FIELD_END + "=" + this.b + StringUtils.SPACE + FIELD_ORDER + "=" + this.c + StringUtils.SPACE + FIELD_LIMIT + "=" + this.d + "]";
    }
}
