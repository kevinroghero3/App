package androidx.sqlite.db.framework;

import android.database.sqlite.SQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import io.sentry.ISpan;
import io.sentry.Sentry;
import io.sentry.SpanStatus;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class FrameworkSQLiteStatement extends FrameworkSQLiteProgram implements SupportSQLiteStatement {
    private final SQLiteStatement delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrameworkSQLiteStatement(@NotNull SQLiteStatement delegate) {
        super(delegate);
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public void execute() {
        this.delegate.execute();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public int executeUpdateDelete() {
        String string = this.delegate.toString();
        String strSubstring = string.substring(string.indexOf(58) + 2);
        ISpan span = Sentry.getSpan();
        ISpan iSpanStartChild = span != null ? span.startChild("db.sql.query", strSubstring) : null;
        try {
            try {
                int iExecuteUpdateDelete = this.delegate.executeUpdateDelete();
                if (iSpanStartChild != null) {
                    iSpanStartChild.setStatus(SpanStatus.OK);
                }
                if (iSpanStartChild != null) {
                    iSpanStartChild.finish();
                }
                return iExecuteUpdateDelete;
            } catch (Exception e) {
                if (iSpanStartChild != null) {
                    iSpanStartChild.setStatus(SpanStatus.INTERNAL_ERROR);
                    iSpanStartChild.setThrowable(e);
                }
                throw e;
            }
        } catch (Throwable th) {
            if (iSpanStartChild != null) {
                iSpanStartChild.finish();
            }
            throw th;
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public long executeInsert() {
        String string = this.delegate.toString();
        String strSubstring = string.substring(string.indexOf(58) + 2);
        ISpan span = Sentry.getSpan();
        ISpan iSpanStartChild = span != null ? span.startChild("db.sql.query", strSubstring) : null;
        try {
            try {
                long jExecuteInsert = this.delegate.executeInsert();
                if (iSpanStartChild != null) {
                    iSpanStartChild.setStatus(SpanStatus.OK);
                }
                if (iSpanStartChild != null) {
                    iSpanStartChild.finish();
                }
                return jExecuteInsert;
            } catch (Exception e) {
                if (iSpanStartChild != null) {
                    iSpanStartChild.setStatus(SpanStatus.INTERNAL_ERROR);
                    iSpanStartChild.setThrowable(e);
                }
                throw e;
            }
        } catch (Throwable th) {
            if (iSpanStartChild != null) {
                iSpanStartChild.finish();
            }
            throw th;
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public long simpleQueryForLong() {
        return this.delegate.simpleQueryForLong();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public String simpleQueryForString() {
        return this.delegate.simpleQueryForString();
    }
}
