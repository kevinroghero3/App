package com.google.mlkit.common.sdkinternal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_common.zzsh;
import com.google.android.gms.internal.mlkit_common.zzsk;
import com.google.android.gms.internal.mlkit_common.zzss;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.model.CustomRemoteModel;
import com.google.mlkit.common.model.LocalModel;
import com.google.mlkit.common.model.RemoteModel;
import com.google.mlkit.common.sdkinternal.Constants;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class CustomModelLoader {
    private static final GmsLogger zza = new GmsLogger("CustomModelLoader", "");
    private static final Map zzb = new HashMap();
    private final MlKitContext zzc;
    private final LocalModel zzd;
    private final CustomRemoteModel zze;
    private final RemoteModelDownloadManager zzf;
    private final RemoteModelFileManager zzg;
    private final zzsh zzh;
    private boolean zzi;

    public interface CustomModelLoaderHelper {
        void logLoad() throws MlKitException;

        boolean tryLoad(@NonNull LocalModel localModel) throws MlKitException;
    }

    private CustomModelLoader(@NonNull MlKitContext mlKitContext, @Nullable LocalModel localModel, @Nullable CustomRemoteModel customRemoteModel) {
        if (customRemoteModel != null) {
            RemoteModelFileManager remoteModelFileManager = new RemoteModelFileManager(mlKitContext, customRemoteModel, null, new ModelFileHelper(mlKitContext), new com.google.mlkit.common.internal.model.zza(mlKitContext, customRemoteModel.getUniqueModelNameForPersist()));
            this.zzg = remoteModelFileManager;
            this.zzf = RemoteModelDownloadManager.getInstance(mlKitContext, customRemoteModel, new ModelFileHelper(mlKitContext), remoteModelFileManager, (ModelInfoRetrieverInterop) mlKitContext.get(ModelInfoRetrieverInterop.class));
            this.zzi = true;
        } else {
            this.zzg = null;
            this.zzf = null;
        }
        this.zzc = mlKitContext;
        this.zzd = localModel;
        this.zze = customRemoteModel;
        this.zzh = zzss.zzb("common");
    }

    public static CustomModelLoader getInstance(@NonNull MlKitContext mlKitContext, @Nullable LocalModel localModel, @Nullable CustomRemoteModel customRemoteModel) {
        CustomModelLoader customModelLoader;
        synchronized (CustomModelLoader.class) {
            try {
                String string = customRemoteModel == null ? ((LocalModel) Preconditions.checkNotNull(localModel)).toString() : customRemoteModel.getUniqueModelNameForPersist();
                Map map = zzb;
                if (!map.containsKey(string)) {
                    map.put(string, new CustomModelLoader(mlKitContext, localModel, customRemoteModel));
                }
                customModelLoader = (CustomModelLoader) map.get(string);
            } catch (Throwable th) {
                throw th;
            }
        }
        return customModelLoader;
    }

    private final File zza() throws MlKitException {
        String strZzb = ((RemoteModelFileManager) Preconditions.checkNotNull(this.zzg)).zzb();
        if (strZzb == null) {
            zza.d("CustomModelLoader", "No existing model file");
            return null;
        }
        File file = new File(strZzb);
        File[] fileArrListFiles = file.listFiles();
        return ((File[]) Preconditions.checkNotNull(fileArrListFiles)).length == 1 ? fileArrListFiles[0] : file;
    }

    private final void zzb() throws MlKitException {
        ((RemoteModelDownloadManager) Preconditions.checkNotNull(this.zzf)).removeOrCancelDownload();
    }

    private static final LocalModel zzc(File file) {
        if (file.isDirectory()) {
            LocalModel.Builder builder = new LocalModel.Builder();
            builder.setAbsoluteManifestFilePath(new File(file.getAbsolutePath(), Constants.AUTOML_IMAGE_LABELING_MANIFEST_JSON_FILE_NAME).toString());
            return builder.build();
        }
        LocalModel.Builder builder2 = new LocalModel.Builder();
        builder2.setAbsoluteFilePath(file.getAbsolutePath());
        return builder2.build();
    }

    public LocalModel createLocalModelByLatestExistingModel() throws MlKitException {
        synchronized (this) {
            zza.d("CustomModelLoader", "Try to get the latest existing model file.");
            File fileZza = zza();
            if (fileZza == null) {
                return null;
            }
            return zzc(fileZza);
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0098 A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:24:0x009a A[Catch: all -> 0x00a0, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0022, B:9:0x002a, B:24:0x009a, B:10:0x002e, B:12:0x0045, B:15:0x004e, B:16:0x0067, B:18:0x006f, B:19:0x008b), top: B:30:0x0001 }] */
    public LocalModel createLocalModelByNewlyDownloadedModel() throws MlKitException {
        File fileZzi;
        synchronized (this) {
            GmsLogger gmsLogger = zza;
            gmsLogger.d("CustomModelLoader", "Try to get newly downloaded model file.");
            Long downloadingId = ((RemoteModelDownloadManager) Preconditions.checkNotNull(this.zzf)).getDownloadingId();
            String downloadingModelHash = this.zzf.getDownloadingModelHash();
            if (downloadingId == null || downloadingModelHash == null) {
                gmsLogger.d("CustomModelLoader", "No new model is downloading.");
                zzb();
            } else {
                Integer downloadingModelStatusCode = this.zzf.getDownloadingModelStatusCode();
                if (downloadingModelStatusCode == null) {
                    zzb();
                } else {
                    gmsLogger.d("CustomModelLoader", "Download Status code: ".concat(downloadingModelStatusCode.toString()));
                    if (downloadingModelStatusCode.intValue() == 8) {
                        fileZzi = this.zzf.zzi(downloadingModelHash);
                        if (fileZzi != null) {
                            gmsLogger.d("CustomModelLoader", "Moved the downloaded model to private folder successfully: ".concat(String.valueOf(fileZzi.getParent())));
                            this.zzf.updateLatestModelHashAndType(downloadingModelHash);
                        }
                        if (fileZzi == null) {
                            return null;
                        }
                        return zzc(fileZzi);
                    }
                    if (downloadingModelStatusCode.intValue() == 16) {
                        this.zzh.zze(zzsk.zzg(), (RemoteModel) Preconditions.checkNotNull(this.zze), false, this.zzf.getFailureReason(downloadingId));
                        zzb();
                    }
                }
            }
            fileZzi = null;
            if (fileZzi == null) {
                return null;
            }
            return zzc(fileZzi);
        }
    }

    public void deleteLatestExistingModel() throws MlKitException {
        File fileZza = zza();
        if (fileZza != null) {
            ((RemoteModelFileManager) Preconditions.checkNotNull(this.zzg)).zzc(fileZza);
            SharedPrefManager.getInstance(this.zzc).clearLatestModelHash((RemoteModel) Preconditions.checkNotNull(this.zze));
        }
    }

    public void deleteOldModels(@NonNull LocalModel localModel) throws MlKitException {
        File parentFile = new File((String) Preconditions.checkNotNull(localModel.getAbsoluteFilePath())).getParentFile();
        if (!((RemoteModelFileManager) Preconditions.checkNotNull(this.zzg)).zzd((File) Preconditions.checkNotNull(parentFile))) {
            zza.e("CustomModelLoader", "Failed to delete old models");
        } else {
            zza.d("CustomModelLoader", "All old models are deleted.");
            this.zzg.zza(parentFile);
        }
    }

    public void load(@NonNull CustomModelLoaderHelper customModelLoaderHelper) throws MlKitException {
        synchronized (this) {
            LocalModel localModelCreateLocalModelByLatestExistingModel = this.zzd;
            if (localModelCreateLocalModelByLatestExistingModel == null) {
                localModelCreateLocalModelByLatestExistingModel = createLocalModelByNewlyDownloadedModel();
            }
            if (localModelCreateLocalModelByLatestExistingModel == null) {
                localModelCreateLocalModelByLatestExistingModel = createLocalModelByLatestExistingModel();
            }
            if (localModelCreateLocalModelByLatestExistingModel == null) {
                throw new MlKitException("Model is not available.", 14);
            }
            while (!customModelLoaderHelper.tryLoad(localModelCreateLocalModelByLatestExistingModel)) {
                if (this.zze != null) {
                    deleteLatestExistingModel();
                    localModelCreateLocalModelByLatestExistingModel = createLocalModelByLatestExistingModel();
                } else {
                    localModelCreateLocalModelByLatestExistingModel = null;
                }
                if (localModelCreateLocalModelByLatestExistingModel == null) {
                    customModelLoaderHelper.logLoad();
                    return;
                }
            }
            if (this.zze != null && this.zzi) {
                deleteOldModels((LocalModel) Preconditions.checkNotNull(localModelCreateLocalModelByLatestExistingModel));
                this.zzi = false;
            }
            customModelLoaderHelper.logLoad();
        }
    }
}
