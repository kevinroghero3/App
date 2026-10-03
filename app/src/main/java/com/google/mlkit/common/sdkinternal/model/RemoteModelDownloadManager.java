package com.google.mlkit.common.sdkinternal.model;

import android.app.DownloadManager;
import android.content.IntentFilter;
import android.database.Cursor;
import android.os.ParcelFileDescriptor;
import android.util.LongSparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_common.zzmu;
import com.google.android.gms.internal.mlkit_common.zzna;
import com.google.android.gms.internal.mlkit_common.zzry;
import com.google.android.gms.internal.mlkit_common.zzsh;
import com.google.android.gms.internal.mlkit_common.zzsk;
import com.google.android.gms.internal.mlkit_common.zzss;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.model.DownloadConditions;
import com.google.mlkit.common.model.RemoteModel;
import com.google.mlkit.common.sdkinternal.CommonUtils;
import com.google.mlkit.common.sdkinternal.MLTaskExecutor;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.ModelInfo;
import com.google.mlkit.common.sdkinternal.ModelType;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import io.sentry.clientreport.DiscardedEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class RemoteModelDownloadManager {
    private static final GmsLogger zza = new GmsLogger("ModelDownloadManager", "");
    private static final Map zzb = new HashMap();
    private final LongSparseArray zzc = new LongSparseArray();
    private final LongSparseArray zzd = new LongSparseArray();
    private final MlKitContext zze;
    private final DownloadManager zzf;
    private final RemoteModel zzg;
    private final ModelType zzh;
    private final zzsh zzi;
    private final SharedPrefManager zzj;
    private final ModelFileHelper zzk;
    private final ModelInfoRetrieverInterop zzl;
    private final RemoteModelFileManager zzm;
    private DownloadConditions zzn;

    RemoteModelDownloadManager(@NonNull MlKitContext mlKitContext, @NonNull RemoteModel remoteModel, @NonNull ModelFileHelper modelFileHelper, @NonNull RemoteModelFileManager remoteModelFileManager, @Nullable ModelInfoRetrieverInterop modelInfoRetrieverInterop, @NonNull zzsh zzshVar) {
        this.zze = mlKitContext;
        this.zzh = remoteModel.getModelType();
        this.zzg = remoteModel;
        DownloadManager downloadManager = (DownloadManager) mlKitContext.getApplicationContext().getSystemService("download");
        this.zzf = downloadManager;
        this.zzi = zzshVar;
        if (downloadManager == null) {
            zza.d("ModelDownloadManager", "Download manager service is not available in the service.");
        }
        this.zzk = modelFileHelper;
        this.zzj = SharedPrefManager.getInstance(mlKitContext);
        this.zzl = modelInfoRetrieverInterop;
        this.zzm = remoteModelFileManager;
    }

    public static RemoteModelDownloadManager getInstance(@NonNull MlKitContext mlKitContext, @NonNull RemoteModel remoteModel, @NonNull ModelFileHelper modelFileHelper, @NonNull RemoteModelFileManager remoteModelFileManager, @Nullable ModelInfoRetrieverInterop modelInfoRetrieverInterop) {
        RemoteModelDownloadManager remoteModelDownloadManager;
        synchronized (RemoteModelDownloadManager.class) {
            Map map = zzb;
            if (!map.containsKey(remoteModel)) {
                map.put(remoteModel, new RemoteModelDownloadManager(mlKitContext, remoteModel, modelFileHelper, remoteModelFileManager, modelInfoRetrieverInterop, zzss.zzb("common")));
            }
            remoteModelDownloadManager = (RemoteModelDownloadManager) map.get(remoteModel);
        }
        return remoteModelDownloadManager;
    }

    private final Task zzj(long j) {
        MlKitContext mlKitContext = this.zze;
        ContextCompat.registerReceiver(mlKitContext.getApplicationContext(), zzm(j), new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"), null, MLTaskExecutor.getInstance().getHandler(), 2);
        return zzk(j).getTask();
    }

    private final TaskCompletionSource zzk(long j) {
        synchronized (this) {
            TaskCompletionSource taskCompletionSource = (TaskCompletionSource) this.zzd.get(j);
            if (taskCompletionSource != null) {
                return taskCompletionSource;
            }
            TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
            this.zzd.put(j, taskCompletionSource2);
            return taskCompletionSource2;
        }
    }

    private final zzc zzm(long j) {
        synchronized (this) {
            zzc zzcVar = (zzc) this.zzc.get(j);
            if (zzcVar != null) {
                return zzcVar;
            }
            zzc zzcVar2 = new zzc(this, j, zzk(j), null);
            this.zzc.put(j, zzcVar2);
            return zzcVar2;
        }
    }

    private final Long zzn(@NonNull DownloadManager.Request request, @NonNull ModelInfo modelInfo) {
        synchronized (this) {
            DownloadManager downloadManager = this.zzf;
            if (downloadManager == null) {
                return null;
            }
            long jEnqueue = downloadManager.enqueue(request);
            zza.d("ModelDownloadManager", "Schedule a new downloading task: " + jEnqueue);
            this.zzj.setDownloadingModelInfo(jEnqueue, modelInfo);
            this.zzi.zzf(zzsk.zzg(), this.zzg, zzmu.NO_ERROR, false, modelInfo.getModelType(), zzna.SCHEDULED);
            return Long.valueOf(jEnqueue);
        }
    }

    private final Long zzo(@NonNull ModelInfo modelInfo, @NonNull DownloadConditions downloadConditions) throws MlKitException {
        synchronized (this) {
            Preconditions.checkNotNull(downloadConditions, "DownloadConditions can not be null");
            String downloadingModelHash = this.zzj.getDownloadingModelHash(this.zzg);
            Integer downloadingModelStatusCode = getDownloadingModelStatusCode();
            if (downloadingModelHash != null && downloadingModelHash.equals(modelInfo.getModelHash()) && downloadingModelStatusCode != null) {
                Integer downloadingModelStatusCode2 = getDownloadingModelStatusCode();
                if (downloadingModelStatusCode2 == null || (downloadingModelStatusCode2.intValue() != 8 && downloadingModelStatusCode2.intValue() != 16)) {
                    zzsh zzshVar = this.zzi;
                    RemoteModel remoteModel = this.zzg;
                    zzshVar.zzf(zzsk.zzg(), remoteModel, zzmu.NO_ERROR, false, remoteModel.getModelType(), zzna.DOWNLOADING);
                }
                zza.d("ModelDownloadManager", "New model is already in downloading, do nothing.");
                return null;
            }
            GmsLogger gmsLogger = zza;
            gmsLogger.d("ModelDownloadManager", "Need to download a new model.");
            removeOrCancelDownload();
            DownloadManager.Request request = new DownloadManager.Request(modelInfo.getModelUri());
            if (this.zzk.modelExistsLocally(modelInfo.getModelNameForPersist(), modelInfo.getModelType())) {
                gmsLogger.d("ModelDownloadManager", "Model update is enabled and have a previous downloaded model, use download condition");
                this.zzi.zzf(zzsk.zzg(), this.zzg, zzmu.NO_ERROR, false, modelInfo.getModelType(), zzna.UPDATE_AVAILABLE);
            }
            request.setRequiresCharging(downloadConditions.isChargingRequired());
            if (downloadConditions.isWifiRequired()) {
                request.setAllowedNetworkTypes(2);
            }
            return zzn(request, modelInfo);
        }
    }

    public Task<Void> ensureModelDownloaded() {
        MlKitException mlKitException;
        ModelInfo modelInfoZzg;
        this.zzi.zzf(zzsk.zzg(), this.zzg, zzmu.NO_ERROR, false, ModelType.UNKNOWN, zzna.EXPLICITLY_REQUESTED);
        Long lZzo = null;
        try {
            modelInfoZzg = zzg();
            mlKitException = null;
        } catch (MlKitException e) {
            mlKitException = e;
            modelInfoZzg = null;
        }
        try {
            Integer downloadingModelStatusCode = getDownloadingModelStatusCode();
            Long downloadingId = getDownloadingId();
            if (!modelExistsLocally() && (downloadingModelStatusCode == null || downloadingModelStatusCode.intValue() != 8)) {
                if (downloadingModelStatusCode != null && downloadingModelStatusCode.intValue() == 16) {
                    MlKitException mlKitExceptionZzl = zzl(downloadingId);
                    removeOrCancelDownload();
                    return Tasks.forException(mlKitExceptionZzl);
                }
                if (downloadingModelStatusCode == null || (!(downloadingModelStatusCode.intValue() == 4 || downloadingModelStatusCode.intValue() == 2 || downloadingModelStatusCode.intValue() == 1) || downloadingId == null || getDownloadingModelHash() == null)) {
                    if (modelInfoZzg != null) {
                        lZzo = zzo(modelInfoZzg, this.zzn);
                    }
                    return lZzo == null ? Tasks.forException(new MlKitException("Failed to schedule the download task", 13, mlKitException)) : zzj(lZzo.longValue());
                }
                zzsh zzshVar = this.zzi;
                zzry zzryVarZzg = zzsk.zzg();
                RemoteModel remoteModel = this.zzg;
                zzshVar.zzf(zzryVarZzg, remoteModel, zzmu.NO_ERROR, false, remoteModel.getModelType(), zzna.DOWNLOADING);
                return zzj(downloadingId.longValue());
            }
            if (modelInfoZzg != null) {
                Long lZzo2 = zzo(modelInfoZzg, this.zzn);
                if (lZzo2 != null) {
                    return zzj(lZzo2.longValue());
                }
                zza.i("ModelDownloadManager", "Didn't schedule download for the updated model");
            }
            return Tasks.forResult(null);
        } catch (MlKitException e2) {
            return Tasks.forException(new MlKitException("Failed to ensure the model is downloaded.", 13, e2));
        }
    }

    public ParcelFileDescriptor getDownloadedFile() {
        synchronized (this) {
            DownloadManager downloadManager = this.zzf;
            Long downloadingId = getDownloadingId();
            ParcelFileDescriptor parcelFileDescriptorOpenDownloadedFile = null;
            if (downloadManager == null || downloadingId == null) {
                return null;
            }
            try {
                parcelFileDescriptorOpenDownloadedFile = downloadManager.openDownloadedFile(downloadingId.longValue());
            } catch (FileNotFoundException unused) {
                zza.e("ModelDownloadManager", "Downloaded file is not found");
            }
            return parcelFileDescriptorOpenDownloadedFile;
        }
    }

    public Long getDownloadingId() {
        Long downloadingModelId;
        synchronized (this) {
            downloadingModelId = this.zzj.getDownloadingModelId(this.zzg);
        }
        return downloadingModelId;
    }

    public String getDownloadingModelHash() {
        String downloadingModelHash;
        synchronized (this) {
            downloadingModelHash = this.zzj.getDownloadingModelHash(this.zzg);
        }
        return downloadingModelHash;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0041 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:18:0x0043 A[Catch: all -> 0x007d, TRY_ENTER, TRY_LEAVE, TryCatch #2 {, blocks: (B:3:0x0001, B:7:0x000e, B:18:0x0043, B:33:0x006d, B:40:0x007a, B:39:0x0077, B:36:0x0072, B:9:0x0027, B:11:0x002d, B:20:0x0047, B:22:0x004e, B:24:0x0055, B:26:0x005b, B:28:0x0063), top: B:50:0x0001, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:20:0x0047 A[Catch: all -> 0x003c, TRY_ENTER, TryCatch #1 {all -> 0x003c, blocks: (B:9:0x0027, B:11:0x002d, B:20:0x0047, B:22:0x004e, B:24:0x0055, B:26:0x005b, B:28:0x0063), top: B:48:0x0027, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x006c  */
    public Integer getDownloadingModelStatusCode() {
        Integer numValueOf;
        synchronized (this) {
            DownloadManager downloadManager = this.zzf;
            Long downloadingId = getDownloadingId();
            if (downloadManager != null && downloadingId != null) {
                Cursor cursorQuery = downloadManager.query(new DownloadManager.Query().setFilterById(downloadingId.longValue()));
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            numValueOf = Integer.valueOf(cursorQuery.getInt(cursorQuery.getColumnIndex("status")));
                        }
                        if (numValueOf == null) {
                            Integer num = (numValueOf.intValue() != 2 || numValueOf.intValue() == 4 || numValueOf.intValue() == 1 || numValueOf.intValue() == 8 || numValueOf.intValue() == 16) ? numValueOf : null;
                            cursorQuery.close();
                            return num;
                        }
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                    } catch (Throwable th) {
                        try {
                            cursorQuery.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
                numValueOf = null;
                if (numValueOf == null) {
                    if (numValueOf.intValue() != 2) {
                    }
                    cursorQuery.close();
                    return num;
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
            return null;
        }
    }

    public boolean isModelDownloadedAndValid() throws MlKitException {
        try {
            if (modelExistsLocally()) {
                return true;
            }
        } catch (MlKitException unused) {
            zza.d("ModelDownloadManager", "Failed to check if the model exist locally.");
        }
        Long downloadingId = getDownloadingId();
        String downloadingModelHash = getDownloadingModelHash();
        if (downloadingId == null || downloadingModelHash == null) {
            zza.d("ModelDownloadManager", "No new model is downloading.");
            removeOrCancelDownload();
            return false;
        }
        Integer downloadingModelStatusCode = getDownloadingModelStatusCode();
        zza.d("ModelDownloadManager", "Download Status code: ".concat(String.valueOf(downloadingModelStatusCode)));
        if (downloadingModelStatusCode != null) {
            return Objects.equal(downloadingModelStatusCode, 8) && zzi(downloadingModelHash) != null;
        }
        removeOrCancelDownload();
        return false;
    }

    public boolean modelExistsLocally() throws MlKitException {
        return this.zzk.modelExistsLocally(this.zzg.getUniqueModelNameForPersist(), this.zzh);
    }

    public void removeOrCancelDownload() throws MlKitException {
        synchronized (this) {
            DownloadManager downloadManager = this.zzf;
            Long downloadingId = getDownloadingId();
            if (downloadManager != null && downloadingId != null) {
                zza.d("ModelDownloadManager", "Cancel or remove existing downloading task: ".concat(downloadingId.toString()));
                if (this.zzf.remove(downloadingId.longValue()) > 0 || getDownloadingModelStatusCode() == null) {
                    ModelFileHelper modelFileHelper = this.zzk;
                    RemoteModel remoteModel = this.zzg;
                    modelFileHelper.deleteTempFilesInPrivateFolder(remoteModel.getUniqueModelNameForPersist(), remoteModel.getModelType());
                    this.zzj.clearDownloadingModelInfo(this.zzg);
                }
            }
        }
    }

    public void setDownloadConditions(@NonNull DownloadConditions downloadConditions) {
        Preconditions.checkNotNull(downloadConditions, "DownloadConditions can not be null");
        this.zzn = downloadConditions;
    }

    public void updateLatestModelHashAndType(@NonNull String str) throws MlKitException {
        synchronized (this) {
            this.zzj.setLatestModelHash(this.zzg, str);
            removeOrCancelDownload();
        }
    }

    final ModelInfo zzg() throws MlKitException {
        boolean z;
        synchronized (this) {
            boolean zModelExistsLocally = modelExistsLocally();
            if (zModelExistsLocally) {
                zzsh zzshVar = this.zzi;
                RemoteModel remoteModel = this.zzg;
                zzshVar.zzf(zzsk.zzg(), remoteModel, zzmu.NO_ERROR, false, remoteModel.getModelType(), zzna.LIVE);
            }
            ModelInfoRetrieverInterop modelInfoRetrieverInterop = this.zzl;
            if (modelInfoRetrieverInterop == null) {
                throw new MlKitException("Please include com.google.mlkit:linkfirebase sdk as your dependency when you try to download from Firebase.", 14);
            }
            ModelInfo modelInfoRetrieveRemoteModelInfo = modelInfoRetrieverInterop.retrieveRemoteModelInfo(this.zzg);
            if (modelInfoRetrieveRemoteModelInfo == null) {
                return null;
            }
            MlKitContext mlKitContext = this.zze;
            RemoteModel remoteModel2 = this.zzg;
            String modelHash = modelInfoRetrieveRemoteModelInfo.getModelHash();
            SharedPrefManager sharedPrefManager = SharedPrefManager.getInstance(mlKitContext);
            boolean z2 = false;
            if (modelHash.equals(sharedPrefManager.getIncompatibleModelHash(remoteModel2)) && CommonUtils.getAppVersion(mlKitContext.getApplicationContext()).equals(sharedPrefManager.getPreviousAppVersion())) {
                zza.e("ModelDownloadManager", "The model is incompatible with TFLite and the app is not upgraded, do not download");
                z = false;
            } else {
                z = true;
            }
            if (!zModelExistsLocally) {
                this.zzj.clearLatestModelHash(this.zzg);
            }
            boolean zEquals = modelInfoRetrieveRemoteModelInfo.getModelHash().equals(SharedPrefManager.getInstance(this.zze).getLatestModelHash(this.zzg));
            if (!z) {
                z2 = !zEquals;
            } else if (!zModelExistsLocally || !zEquals) {
                return modelInfoRetrieveRemoteModelInfo;
            }
            if (zModelExistsLocally && (z2 ^ z)) {
                return null;
            }
            throw new MlKitException("The model " + this.zzg.getModelName() + " is incompatible with TFLite runtime", 100);
        }
    }

    public final File zzi(@NonNull String str) throws MlKitException {
        GmsLogger gmsLogger = zza;
        gmsLogger.d("ModelDownloadManager", "Model downloaded successfully");
        this.zzi.zzf(zzsk.zzg(), this.zzg, zzmu.NO_ERROR, true, this.zzh, zzna.SUCCEEDED);
        ParcelFileDescriptor downloadedFile = getDownloadedFile();
        if (downloadedFile == null) {
            removeOrCancelDownload();
            return null;
        }
        gmsLogger.d("ModelDownloadManager", "moving downloaded model from external storage to private folder.");
        try {
            return this.zzm.moveModelToPrivateFolder(downloadedFile, str, this.zzg);
        } finally {
            removeOrCancelDownload();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MlKitException zzl(@Nullable Long l) {
        String str;
        DownloadManager downloadManager = this.zzf;
        Cursor cursorQuery = (downloadManager == null || l == null) ? null : downloadManager.query(new DownloadManager.Query().setFilterById(l.longValue()));
        int i = 13;
        if (cursorQuery == null || !cursorQuery.moveToFirst()) {
            str = "Model downloading failed";
        } else {
            int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex(DiscardedEvent.JsonKeys.REASON));
            if (i2 == 1006) {
                str = "Model downloading failed due to insufficient space on the device.";
                i = 101;
            } else {
                str = "Model downloading failed due to error code: " + i2 + " from Android DownloadManager";
            }
        }
        return new MlKitException(str, i);
    }

    public int getFailureReason(@NonNull Long l) {
        int columnIndex;
        DownloadManager downloadManager = this.zzf;
        Cursor cursorQuery = (downloadManager == null || l == null) ? null : downloadManager.query(new DownloadManager.Query().setFilterById(l.longValue()));
        if (cursorQuery == null || !cursorQuery.moveToFirst() || (columnIndex = cursorQuery.getColumnIndex(DiscardedEvent.JsonKeys.REASON)) == -1) {
            return 0;
        }
        return cursorQuery.getInt(columnIndex);
    }
}
