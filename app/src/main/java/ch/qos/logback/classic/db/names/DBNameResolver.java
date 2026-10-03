package ch.qos.logback.classic.db.names;

/* JADX INFO: loaded from: classes2.dex */
public interface DBNameResolver {
    <N extends Enum<?>> String getColumnName(N n2);

    <N extends Enum<?>> String getTableName(N n2);
}
