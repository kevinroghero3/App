package it.aep_italia.vts.sdk.core;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import it.aep_italia.vts.sdk.VtsSdkConfiguration;
import it.aep_italia.vts.sdk.domain.VtsSynchronization;
import it.aep_italia.vts.sdk.dto.domain.VtsSynchronizationDTO;
import it.aep_italia.vts.sdk.errors.VtsException;
import it.aep_italia.vts.sdk.internal.database.SharedDatabase;
import it.aep_italia.vts.sdk.internal.database.properties.StoredProperty;
import it.aep_italia.vts.sdk.utils.DateUtils;
import it.aep_italia.vts.sdk.utils.SerializationUtils;
import java.util.Date;

/* JADX INFO: loaded from: classes6.dex */
public class VtsSyncWorker extends Worker {
    VtsSyncService a;
    VtsSdk b;
    Intent c;

    public VtsSyncWorker(@NonNull Context context, @NonNull WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    private long a(long j) {
        Long value = SharedDatabase.getInstance(this.b).propertyDao().getValue(StoredProperty.LAST_SYNCHRONIZATION);
        return value == null ? j : j - value.longValue();
    }

    private void a(VtsSynchronization.Status status, Date date, Date date2, Throwable th) {
        String message;
        if (th == null) {
            message = null;
        } else {
            try {
                message = th.getMessage();
            } catch (Exception e) {
                VtsLog.e(e, "updateStatus() Could not persist last synchronization details", new Object[0]);
                return;
            }
        }
        VtsSynchronizationDTO vtsSynchronizationDTO = new VtsSynchronizationDTO();
        vtsSynchronizationDTO.setStatus(status.name());
        vtsSynchronizationDTO.setStartDate(DateUtils.toISO8601(date));
        vtsSynchronizationDTO.setEndDate(DateUtils.toISO8601(date2));
        vtsSynchronizationDTO.setErrorMessage(SerializationUtils.toBase64String(message));
        this.a.getSharedPreferences("it.aep_italia.vts.nfc.PREFS", 0).edit().putString("it.aep_italia.vts.nfc.SYNC_DETAILS", SerializationUtils.serializeToXml(vtsSynchronizationDTO)).commit();
    }

    private void a(Date date) {
        try {
            a(VtsSynchronization.Status.ERROR, date, new Date(), null);
            this.a.sendBroadcast(new Intent(VtsSyncService.ACTION_SYNC_FAILED));
        } catch (Exception unused) {
        }
    }

    private void b(long j) {
        SharedDatabase.getInstance(this.b).propertyDao().putValue(StoredProperty.LAST_SYNCHRONIZATION, j);
    }

    private void b(Date date) {
        try {
            a(VtsSynchronization.Status.IN_PROGRESS, date, null, null);
            this.a.sendBroadcast(new Intent(VtsSyncService.ACTION_SYNC_STARTED));
        } catch (Exception unused) {
        }
    }

    private void c(Date date) {
        try {
            a(VtsSynchronization.Status.SUCCESS, date, new Date(), null);
            this.a.sendBroadcast(new Intent(VtsSyncService.ACTION_SYNC_COMPLETE));
        } catch (Exception unused) {
        }
    }

    @Override // androidx.work.Worker
    public ListenableWorker.Result doWork() {
        VtsLog.d("doWork() ============================================================", new Object[0]);
        VtsLog.d("doWork() =============[ WORKER STARTS ]==============================", new Object[0]);
        VtsLog.d("doWork() ============================================================", new Object[0]);
        this.a = VtsSyncWorkerManager.getInstance().getSyncService();
        this.c = VtsSyncWorkerManager.getInstance().getIntent();
        this.b = this.a.createSdk(getApplicationContext());
        try {
            makeSync();
            VtsLog.d("doWork() ==============================================================", new Object[0]);
            VtsLog.d("doWork() =============[ WORKER TERMINATED ]============================", new Object[0]);
            VtsLog.d("doWork() ==============================================================", new Object[0]);
            return ListenableWorker.Result.success();
        } catch (Exception e) {
            VtsLog.e(e, "doWork() Worker Exception. ErrMessage='%s'", e.getLocalizedMessage());
            return ListenableWorker.Result.retry();
        }
    }

    public void makeSync() {
        Date date = new Date();
        VtsLog.i("makeSync() Function STARTS", new Object[0]);
        b(date);
        VtsLog.init(this.b);
        VtsSdkConfiguration sdkConfiguration = this.b.getSdkConfiguration();
        try {
            if (!this.b.isInitialized()) {
                VtsLog.e("VtsSyncWorker", "makeSync() Synchronization NOT PERFORMED ( SDK not initialized )");
                VtsLog.i("makeSync() Function ENDS", new Object[0]);
                return;
            }
            long time = new Date().getTime();
            if (a(time) < 5000) {
                VtsLog.w("makeSync() Synchronization NOT PERFORMED. The request to the synchronization function was made too early ( within %d Sec ) , the request is ignored", 5);
                VtsLog.i("makeSync() Function ENDS", new Object[0]);
                c(date);
                return;
            }
            b(time);
            boolean z = getApplicationContext().getSharedPreferences("vtsSDK", 0).getBoolean("it.aep_italia.vts.nfc.FORCE_SYNC", false);
            boolean z2 = getApplicationContext().getSharedPreferences("vtsSDK", 0).getBoolean("it.aep_italia.vts.nfc.SKIP_REFRESH", false);
            if (z) {
                VtsLog.d("makeSync() isForcedSync: TRUE", new Object[0]);
            } else {
                VtsLog.d("makeSync() isForcedSync: FALSE", new Object[0]);
            }
            if (z2) {
                VtsLog.d("makeSync() shouldRefresh: TRUE", new Object[0]);
            } else {
                VtsLog.d("makeSync() shouldRefresh: FALSE", new Object[0]);
            }
            if (!z && sdkConfiguration.isSynchronizationDisabled()) {
                VtsLog.w("makeSync() SDK Synchronization NOT performed. ( Synchronization Disabled by configuration )", new Object[0]);
                VtsLog.i("makeSync() Function ENDS", new Object[0]);
                c(date);
                return;
            }
            if (z && z2) {
                try {
                    VtsLog.d("makeSync() Running 'VtsSdkInitializer.initializeAsync', ( RefreshOperation=true and ShouldRefresh=true ), SystemType=%d, SystemSubType=%d ...", Integer.valueOf(this.b.getSystemType()), Integer.valueOf(this.b.getSystemSubType()));
                    new c(this.b, true).b();
                } catch (VtsException e) {
                    VtsLog.e(e, "makeSync() Worker Exception. ErrMessage='%s'", e.getLocalizedMessage());
                    VtsLog.i("makeSync() Function ENDS", new Object[0]);
                    a(date);
                    return;
                }
            } else {
                try {
                    VtsLog.d("makeSync() makeSync() Running 'VtsSdkInitializer.initializeAsync()', ( RefreshOperation=false or ShouldRefresh=false ), SystemType=%d, SystemSubType=%d ...", Integer.valueOf(this.b.getSystemType()), Integer.valueOf(this.b.getSystemSubType()));
                    new c(this.b, false).b();
                } catch (VtsException e2) {
                    VtsLog.e(e2, "makeSync() Worker Exception. ErrMessage='%s'", e2.getLocalizedMessage());
                    VtsLog.i("makeSync() Function ENDS", new Object[0]);
                    a(date);
                    return;
                }
            }
            Long scheduledTime = this.a.getScheduledTime();
            if (z || scheduledTime == null || scheduledTime.longValue() <= new Date().getTime()) {
                try {
                    VtsLog.i("makeSync() Starting 'VtsSyncHandler()' parallel Thread ( STARTING WALLET SYNC THREAD... )", new Object[0]);
                    new d(this.a, this.b).b().onResultReady(this.a.syncListener);
                } catch (VtsException e3) {
                    VtsLog.e(e3, "makeSync() Worker Exception. ErrMessage='%s'", e3.getLocalizedMessage());
                    VtsLog.i("makeSync() Function ENDS", new Object[0]);
                    a(date);
                    return;
                }
            } else {
                VtsLog.i("makeSync() Skipping Local Wallet Synchronization. ( not enough time passed since last activation or isForcedSync=false ) ", new Object[0]);
                this.a.rescheduleService(scheduledTime.longValue(), sdkConfiguration.synchronizeUseExactTimes());
            }
            VtsLog.i("makeSync() Function ENDS", new Object[0]);
            c(date);
        } catch (Exception e4) {
            VtsLog.e(e4, "makeSync() Worker Exception. ErrMessage='%s'", e4.getLocalizedMessage());
            VtsLog.i("makeSync() Function ENDS", new Object[0]);
            a(date);
        }
    }
}
