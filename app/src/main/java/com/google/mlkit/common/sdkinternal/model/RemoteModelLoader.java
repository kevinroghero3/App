package com.google.mlkit.common.sdkinternal.model;

import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.internal.mlkit_common.zzsh;
import com.google.android.gms.internal.mlkit_common.zzsk;
import com.google.android.gms.internal.mlkit_common.zzss;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.model.RemoteModel;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import java.io.File;
import java.nio.MappedByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class RemoteModelLoader {
    private static final GmsLogger zza = new GmsLogger("RemoteModelLoader", "");
    private static final Map zzb = new HashMap();
    private final MlKitContext zzc;
    private final RemoteModel zzd;
    private final RemoteModelDownloadManager zze;
    private final RemoteModelFileManager zzf;
    private final RemoteModelLoaderHelper zzg;
    private final zzsh zzh;
    private boolean zzi;

    private RemoteModelLoader(@NonNull MlKitContext mlKitContext, @NonNull RemoteModel remoteModel, @NonNull ModelValidator modelValidator, @NonNull RemoteModelLoaderHelper remoteModelLoaderHelper, @NonNull RemoteModelFileMover remoteModelFileMover) {
        RemoteModelFileManager remoteModelFileManager = new RemoteModelFileManager(mlKitContext, remoteModel, modelValidator, new ModelFileHelper(mlKitContext), remoteModelFileMover);
        this.zzf = remoteModelFileManager;
        this.zzi = true;
        this.zze = RemoteModelDownloadManager.getInstance(mlKitContext, remoteModel, new ModelFileHelper(mlKitContext), remoteModelFileManager, (ModelInfoRetrieverInterop) mlKitContext.get(ModelInfoRetrieverInterop.class));
        this.zzg = remoteModelLoaderHelper;
        this.zzc = mlKitContext;
        this.zzd = remoteModel;
        this.zzh = zzss.zzb("common");
    }

    public static RemoteModelLoader getInstance(@NonNull MlKitContext mlKitContext, @NonNull RemoteModel remoteModel, @NonNull ModelValidator modelValidator, @NonNull RemoteModelLoaderHelper remoteModelLoaderHelper, @NonNull RemoteModelFileMover remoteModelFileMover) {
        RemoteModelLoader remoteModelLoader;
        synchronized (RemoteModelLoader.class) {
            String uniqueModelNameForPersist = remoteModel.getUniqueModelNameForPersist();
            Map map = zzb;
            if (!map.containsKey(uniqueModelNameForPersist)) {
                map.put(uniqueModelNameForPersist, new RemoteModelLoader(mlKitContext, remoteModel, modelValidator, remoteModelLoaderHelper, remoteModelFileMover));
            }
            remoteModelLoader = (RemoteModelLoader) map.get(uniqueModelNameForPersist);
        }
        return remoteModelLoader;
    }

    private final MappedByteBuffer zza(@NonNull String str) throws MlKitException {
        return this.zzg.loadModelAtPath(str);
    }

    private final MappedByteBuffer zzb(File file) throws MlKitException {
        try {
            return zza(file.getAbsolutePath());
        } catch (Exception e) {
            this.zzf.zzc(file);
            throw new MlKitException("Failed to load newly downloaded model.", 14, e);
        }
    }

    public RemoteModel getRemoteModel() {
        return this.zzd;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x00b3 A[Catch: all -> 0x00f4, TryCatch #1 {, blocks: (B:3:0x0001, B:7:0x001e, B:9:0x0026, B:26:0x00b3, B:28:0x00c2, B:30:0x00ca, B:33:0x00d0, B:34:0x00ee, B:35:0x00ef, B:10:0x002d, B:12:0x0044, B:15:0x004d, B:17:0x006b, B:19:0x0073, B:20:0x0085, B:22:0x008d, B:23:0x00a4), top: B:44:0x0001, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:28:0x00c2 A[Catch: all -> 0x00f4, TRY_LEAVE, TryCatch #1 {, blocks: (B:3:0x0001, B:7:0x001e, B:9:0x0026, B:26:0x00b3, B:28:0x00c2, B:30:0x00ca, B:33:0x00d0, B:34:0x00ee, B:35:0x00ef, B:10:0x002d, B:12:0x0044, B:15:0x004d, B:17:0x006b, B:19:0x0073, B:20:0x0085, B:22:0x008d, B:23:0x00a4), top: B:44:0x0001, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x00ef A[Catch: all -> 0x00f4, TRY_LEAVE, TryCatch #1 {, blocks: (B:3:0x0001, B:7:0x001e, B:9:0x0026, B:26:0x00b3, B:28:0x00c2, B:30:0x00ca, B:33:0x00d0, B:34:0x00ee, B:35:0x00ef, B:10:0x002d, B:12:0x0044, B:15:0x004d, B:17:0x006b, B:19:0x0073, B:20:0x0085, B:22:0x008d, B:23:0x00a4), top: B:44:0x0001, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x00ca A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public MappedByteBuffer load() throws MlKitException {
        MappedByteBuffer mappedByteBufferZza;
        MappedByteBuffer mappedByteBufferZzb;
        String strZzb;
        synchronized (this) {
            GmsLogger gmsLogger = zza;
            gmsLogger.d("RemoteModelLoader", "Try to load newly downloaded model file.");
            RemoteModelDownloadManager remoteModelDownloadManager = this.zze;
            boolean z = this.zzi;
            Long downloadingId = remoteModelDownloadManager.getDownloadingId();
            String downloadingModelHash = remoteModelDownloadManager.getDownloadingModelHash();
            mappedByteBufferZza = null;
            if (downloadingId == null || downloadingModelHash == null) {
                gmsLogger.d("RemoteModelLoader", "No new model is downloading.");
                this.zze.removeOrCancelDownload();
            } else {
                Integer downloadingModelStatusCode = this.zze.getDownloadingModelStatusCode();
                if (downloadingModelStatusCode == null) {
                    this.zze.removeOrCancelDownload();
                } else {
                    gmsLogger.d("RemoteModelLoader", "Download Status code: ".concat(downloadingModelStatusCode.toString()));
                    if (downloadingModelStatusCode.intValue() == 8) {
                        File fileZzi = this.zze.zzi(downloadingModelHash);
                        if (fileZzi != null) {
                            mappedByteBufferZzb = zzb(fileZzi);
                            gmsLogger.d("RemoteModelLoader", "Moved the downloaded model to private folder successfully: ".concat(String.valueOf(fileZzi.getParent())));
                            this.zze.updateLatestModelHashAndType(downloadingModelHash);
                            if (z && this.zzf.zzd(fileZzi)) {
                                gmsLogger.d("RemoteModelLoader", "All old models are deleted.");
                                mappedByteBufferZzb = zzb(this.zzf.zza(fileZzi));
                            }
                        }
                        if (mappedByteBufferZzb == null) {
                            gmsLogger.d("RemoteModelLoader", "Loading existing model file.");
                            strZzb = this.zzf.zzb();
                            if (strZzb == null) {
                                gmsLogger.d("RemoteModelLoader", "No existing model file");
                            } else {
                                try {
                                    mappedByteBufferZza = zza(strZzb);
                                } catch (Exception e) {
                                    this.zzf.zzc(new File(strZzb));
                                    SharedPrefManager.getInstance(this.zzc).clearLatestModelHash(this.zzd);
                                    throw new MlKitException("Failed to load an already downloaded model.", 14, e);
                                }
                            }
                        } else {
                            this.zzi = false;
                            mappedByteBufferZza = mappedByteBufferZzb;
                        }
                    } else if (downloadingModelStatusCode.intValue() == 16) {
                        this.zzh.zze(zzsk.zzg(), this.zzd, false, this.zze.getFailureReason(downloadingId));
                        this.zze.removeOrCancelDownload();
                    }
                }
            }
            mappedByteBufferZzb = null;
            if (mappedByteBufferZzb == null) {
                gmsLogger.d("RemoteModelLoader", "Loading existing model file.");
                strZzb = this.zzf.zzb();
                if (strZzb == null) {
                    gmsLogger.d("RemoteModelLoader", "No existing model file");
                } else {
                    mappedByteBufferZza = zza(strZzb);
                }
            } else {
                this.zzi = false;
                mappedByteBufferZza = mappedByteBufferZzb;
            }
        }
        return mappedByteBufferZza;
    }
}
