package com.facebook.datasource;

import android.util.Pair;
import com.facebook.common.internal.Preconditions;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractDataSource<T> implements DataSource<T> {

    @Nullable
    private static volatile DataSourceInstrumenter sDataSourceInstrumenter;

    @Nullable
    private Map<String, Object> mExtras;

    @Nullable
    private T mResult = null;

    @Nullable
    private Throwable mFailureThrowable = null;
    private float mProgress = 0.0f;
    private boolean mIsClosed = false;
    private DataSourceStatus mDataSourceStatus = DataSourceStatus.IN_PROGRESS;
    private final ConcurrentLinkedQueue<Pair<DataSubscriber<T>, Executor>> mSubscribers = new ConcurrentLinkedQueue<>();

    public interface DataSourceInstrumenter {
        Runnable decorateRunnable(Runnable runnable, String str);
    }

    enum DataSourceStatus {
        IN_PROGRESS,
        SUCCESS,
        FAILURE
    }

    protected void closeResult(@Nullable T t) {
    }

    @Override // com.facebook.datasource.DataSource
    public boolean hasMultipleResults() {
        return false;
    }

    public static void provideInstrumenter(@Nullable DataSourceInstrumenter dataSourceInstrumenter) {
        sDataSourceInstrumenter = dataSourceInstrumenter;
    }

    @Override // com.facebook.datasource.DataSource
    public boolean isClosed() {
        boolean z;
        synchronized (this) {
            z = this.mIsClosed;
        }
        return z;
    }

    @Override // com.facebook.datasource.DataSource
    public boolean isFinished() {
        boolean z;
        synchronized (this) {
            z = this.mDataSourceStatus != DataSourceStatus.IN_PROGRESS;
        }
        return z;
    }

    @Override // com.facebook.datasource.DataSource
    public boolean hasResult() {
        boolean z;
        synchronized (this) {
            z = this.mResult != null;
        }
        return z;
    }

    @Override // com.facebook.datasource.DataSource
    @Nullable
    public T getResult() {
        T t;
        synchronized (this) {
            t = this.mResult;
        }
        return t;
    }

    @Override // com.facebook.datasource.DataSource
    @Nullable
    public Map<String, Object> getExtras() {
        return this.mExtras;
    }

    public void setExtras(@Nullable Map<String, Object> map) {
        this.mExtras = map;
    }

    @Override // com.facebook.datasource.DataSource
    public boolean hasFailed() {
        boolean z;
        synchronized (this) {
            z = this.mDataSourceStatus == DataSourceStatus.FAILURE;
        }
        return z;
    }

    @Override // com.facebook.datasource.DataSource
    @Nullable
    public Throwable getFailureCause() {
        Throwable th;
        synchronized (this) {
            th = this.mFailureThrowable;
        }
        return th;
    }

    @Override // com.facebook.datasource.DataSource
    public float getProgress() {
        float f;
        synchronized (this) {
            f = this.mProgress;
        }
        return f;
    }

    @Override // com.facebook.datasource.DataSource
    public boolean close() {
        synchronized (this) {
            if (this.mIsClosed) {
                return false;
            }
            this.mIsClosed = true;
            T t = this.mResult;
            this.mResult = null;
            if (t != null) {
                closeResult(t);
            }
            if (!isFinished()) {
                notifyDataSubscribers();
            }
            synchronized (this) {
                this.mSubscribers.clear();
            }
            return true;
        }
    }

    @Override // com.facebook.datasource.DataSource
    public void subscribe(DataSubscriber<T> dataSubscriber, Executor executor) {
        Preconditions.checkNotNull(dataSubscriber);
        Preconditions.checkNotNull(executor);
        synchronized (this) {
            if (this.mIsClosed) {
                return;
            }
            if (this.mDataSourceStatus == DataSourceStatus.IN_PROGRESS) {
                this.mSubscribers.add(Pair.create(dataSubscriber, executor));
            }
            boolean z = hasResult() || isFinished() || wasCancelled();
            if (z) {
                notifyDataSubscriber(dataSubscriber, executor, hasFailed(), wasCancelled());
            }
        }
    }

    private void notifyDataSubscribers() {
        boolean zHasFailed = hasFailed();
        boolean zWasCancelled = wasCancelled();
        for (Pair<DataSubscriber<T>, Executor> pair : this.mSubscribers) {
            notifyDataSubscriber((DataSubscriber) pair.first, (Executor) pair.second, zHasFailed, zWasCancelled);
        }
    }

    protected void notifyDataSubscriber(final DataSubscriber<T> dataSubscriber, Executor executor, final boolean z, final boolean z2) {
        Runnable runnableDecorateRunnable = new Runnable() { // from class: com.facebook.datasource.AbstractDataSource.1
            @Override // java.lang.Runnable
            public void run() {
                if (z) {
                    dataSubscriber.onFailure(AbstractDataSource.this);
                } else if (z2) {
                    dataSubscriber.onCancellation(AbstractDataSource.this);
                } else {
                    dataSubscriber.onNewResult(AbstractDataSource.this);
                }
            }
        };
        DataSourceInstrumenter dataSourceInstrumenter = getDataSourceInstrumenter();
        if (dataSourceInstrumenter != null) {
            runnableDecorateRunnable = dataSourceInstrumenter.decorateRunnable(runnableDecorateRunnable, "AbstractDataSource_notifyDataSubscriber");
        }
        executor.execute(runnableDecorateRunnable);
    }

    private boolean wasCancelled() {
        boolean z;
        synchronized (this) {
            z = isClosed() && !isFinished();
        }
        return z;
    }

    public boolean setResult(@Nullable T t, boolean z, @Nullable Map<String, Object> map) {
        setExtras(map);
        boolean resultInternal = setResultInternal(t, z);
        if (resultInternal) {
            notifyDataSubscribers();
        }
        return resultInternal;
    }

    public boolean setResult(@Nullable T t, boolean z) {
        return setResult(t, z, null);
    }

    public boolean setFailure(Throwable th) {
        return setFailure(th, null);
    }

    public boolean setFailure(@Nullable Throwable th, @Nullable Map<String, Object> map) {
        boolean failureInternal = setFailureInternal(th, map);
        if (failureInternal) {
            notifyDataSubscribers();
        }
        return failureInternal;
    }

    public boolean setProgress(float f) {
        boolean progressInternal = setProgressInternal(f);
        if (progressInternal) {
            notifyProgressUpdate();
        }
        return progressInternal;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0023, code lost:
    
        if (r5 == null) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0025, code lost:
    
        closeResult(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0028, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x002b, code lost:
    
        if (r5 == null) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x002d, code lost:
    
        closeResult(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0030, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:?, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:?, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean setResultInternal(@javax.annotation.Nullable T r5, boolean r6) {
        /*
            r4 = this;
            r0 = 0
            monitor-enter(r4)     // Catch: java.lang.Throwable -> L3b
            boolean r1 = r4.mIsClosed     // Catch: java.lang.Throwable -> L38
            if (r1 != 0) goto L2a
            com.facebook.datasource.AbstractDataSource$DataSourceStatus r1 = r4.mDataSourceStatus     // Catch: java.lang.Throwable -> L38
            com.facebook.datasource.AbstractDataSource$DataSourceStatus r2 = com.facebook.datasource.AbstractDataSource.DataSourceStatus.IN_PROGRESS     // Catch: java.lang.Throwable -> L38
            if (r1 == r2) goto Ld
            goto L2a
        Ld:
            if (r6 == 0) goto L17
            com.facebook.datasource.AbstractDataSource$DataSourceStatus r6 = com.facebook.datasource.AbstractDataSource.DataSourceStatus.SUCCESS     // Catch: java.lang.Throwable -> L38
            r4.mDataSourceStatus = r6     // Catch: java.lang.Throwable -> L38
            r6 = 1065353216(0x3f800000, float:1.0)
            r4.mProgress = r6     // Catch: java.lang.Throwable -> L38
        L17:
            T r6 = r4.mResult     // Catch: java.lang.Throwable -> L38
            if (r6 == r5) goto L21
            r4.mResult = r5     // Catch: java.lang.Throwable -> L1f
            r5 = r6
            goto L22
        L1f:
            r5 = move-exception
            goto L36
        L21:
            r5 = r0
        L22:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L32
            if (r5 == 0) goto L28
            r4.closeResult(r5)
        L28:
            r5 = 1
            return r5
        L2a:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L32
            if (r5 == 0) goto L30
            r4.closeResult(r5)
        L30:
            r5 = 0
            return r5
        L32:
            r6 = move-exception
            r3 = r6
            r6 = r5
            r5 = r3
        L36:
            r0 = r6
            goto L39
        L38:
            r5 = move-exception
        L39:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L38
            throw r5     // Catch: java.lang.Throwable -> L3b
        L3b:
            r5 = move-exception
            if (r0 == 0) goto L41
            r4.closeResult(r0)
        L41:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.datasource.AbstractDataSource.setResultInternal(java.lang.Object, boolean):boolean");
    }

    private boolean setFailureInternal(@Nullable Throwable th, @Nullable Map<String, Object> map) {
        synchronized (this) {
            if (!this.mIsClosed && this.mDataSourceStatus == DataSourceStatus.IN_PROGRESS) {
                this.mDataSourceStatus = DataSourceStatus.FAILURE;
                this.mFailureThrowable = th;
                this.mExtras = map;
                return true;
            }
            return false;
        }
    }

    private boolean setProgressInternal(float f) {
        synchronized (this) {
            if (!this.mIsClosed && this.mDataSourceStatus == DataSourceStatus.IN_PROGRESS) {
                if (f < this.mProgress) {
                    return false;
                }
                this.mProgress = f;
                return true;
            }
            return false;
        }
    }

    protected void notifyProgressUpdate() {
        for (Pair<DataSubscriber<T>, Executor> pair : this.mSubscribers) {
            final DataSubscriber dataSubscriber = (DataSubscriber) pair.first;
            ((Executor) pair.second).execute(new Runnable() { // from class: com.facebook.datasource.AbstractDataSource.2
                @Override // java.lang.Runnable
                public void run() {
                    dataSubscriber.onProgressUpdate(AbstractDataSource.this);
                }
            });
        }
    }

    @Nullable
    public static DataSourceInstrumenter getDataSourceInstrumenter() {
        return sDataSourceInstrumenter;
    }
}
