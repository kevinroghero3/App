package com.google.mlkit.common.sdkinternal.model;

import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.ktx.BuildConfig;
import com.google.mlkit.common.MlKitException;
import java.nio.MappedByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class ModelLoader {
    private static final GmsLogger zza = new GmsLogger("ModelLoader", "");
    public final LocalModelLoader localModelLoader;
    protected ModelLoadingState modelLoadingState = ModelLoadingState.NO_MODEL_LOADED;
    public final RemoteModelLoader remoteModelLoader;
    private final ModelLoadingLogger zzb;

    public interface ModelContentHandler {
        void constructModel(@NonNull MappedByteBuffer mappedByteBuffer) throws MlKitException;
    }

    public interface ModelLoadingLogger {
        void logErrorCodes(@NonNull List<Integer> list);
    }

    protected enum ModelLoadingState {
        NO_MODEL_LOADED,
        REMOTE_MODEL_LOADED,
        LOCAL_MODEL_LOADED
    }

    public ModelLoader(@Nullable RemoteModelLoader remoteModelLoader, @Nullable LocalModelLoader localModelLoader, @NonNull ModelLoadingLogger modelLoadingLogger) {
        Preconditions.checkArgument((remoteModelLoader == null && localModelLoader == null) ? false : true, "At least one of RemoteModelLoader or LocalModelLoader must be non-null.");
        Preconditions.checkNotNull(modelLoadingLogger);
        this.remoteModelLoader = remoteModelLoader;
        this.localModelLoader = localModelLoader;
        this.zzb = modelLoadingLogger;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0051  */
    private final String zza() {
        String string;
        LocalModelLoader localModelLoader = this.localModelLoader;
        if (localModelLoader == null) {
            string = null;
        } else if (localModelLoader.getLocalModel().getAssetFilePath() != null) {
            string = this.localModelLoader.getLocalModel().getAssetFilePath();
        } else if (this.localModelLoader.getLocalModel().getAbsoluteFilePath() != null) {
            string = this.localModelLoader.getLocalModel().getAbsoluteFilePath();
        } else if (this.localModelLoader.getLocalModel().getUri() != null) {
            string = ((Uri) Preconditions.checkNotNull(this.localModelLoader.getLocalModel().getUri())).toString();
        } else {
            string = null;
        }
        RemoteModelLoader remoteModelLoader = this.remoteModelLoader;
        return String.format("Local model path: %s. Remote model name: %s. ", string, remoteModelLoader == null ? BuildConfig.VERSION_NAME : remoteModelLoader.getRemoteModel().getUniqueModelNameForPersist());
    }

    private final boolean zzb(ModelContentHandler modelContentHandler, List list) throws MlKitException {
        MappedByteBuffer mappedByteBufferLoad;
        synchronized (this) {
            LocalModelLoader localModelLoader = this.localModelLoader;
            if (localModelLoader == null || (mappedByteBufferLoad = localModelLoader.load()) == null) {
                return false;
            }
            try {
                modelContentHandler.constructModel(mappedByteBufferLoad);
                zza.d("ModelLoader", "Local model source is loaded successfully");
                return true;
            } catch (RuntimeException e) {
                list.add(18);
                throw e;
            }
        }
    }

    private final boolean zzc(ModelContentHandler modelContentHandler, List list) throws MlKitException {
        synchronized (this) {
            RemoteModelLoader remoteModelLoader = this.remoteModelLoader;
            if (remoteModelLoader != null) {
                try {
                    MappedByteBuffer mappedByteBufferLoad = remoteModelLoader.load();
                    if (mappedByteBufferLoad != null) {
                        try {
                            modelContentHandler.constructModel(mappedByteBufferLoad);
                            zza.d("ModelLoader", "Remote model source is loaded successfully");
                            return true;
                        } catch (RuntimeException e) {
                            list.add(19);
                            throw e;
                        }
                    }
                    zza.d("ModelLoader", "Remote model source can NOT be loaded, try local model.");
                    list.add(21);
                } catch (MlKitException e2) {
                    zza.d("ModelLoader", "Remote model source can NOT be loaded, try local model.");
                    list.add(20);
                    throw e2;
                }
            }
            return false;
        }
    }

    public boolean isRemoteModelLoaded() {
        ModelLoadingState modelLoadingState;
        ModelLoadingState modelLoadingState2;
        synchronized (this) {
            modelLoadingState = this.modelLoadingState;
            modelLoadingState2 = ModelLoadingState.REMOTE_MODEL_LOADED;
        }
        return modelLoadingState == modelLoadingState2;
    }

    public void loadWithModelContentHandler(@NonNull ModelContentHandler modelContentHandler) throws MlKitException {
        Exception exc;
        boolean zZzc;
        synchronized (this) {
            ArrayList arrayList = new ArrayList();
            Exception e = null;
            boolean zZzb = false;
            try {
                zZzc = zzc(modelContentHandler, arrayList);
                exc = null;
            } catch (Exception e2) {
                exc = e2;
                zZzc = false;
            }
            if (zZzc) {
                this.zzb.logErrorCodes(arrayList);
                this.modelLoadingState = ModelLoadingState.REMOTE_MODEL_LOADED;
                return;
            }
            try {
                zZzb = zzb(modelContentHandler, arrayList);
            } catch (Exception e3) {
                e = e3;
            }
            if (zZzb) {
                this.zzb.logErrorCodes(arrayList);
                this.modelLoadingState = ModelLoadingState.LOCAL_MODEL_LOADED;
                return;
            }
            arrayList.add(17);
            this.zzb.logErrorCodes(arrayList);
            this.modelLoadingState = ModelLoadingState.NO_MODEL_LOADED;
            if (exc != null) {
                throw new MlKitException("Remote model load failed with the model options: ".concat(String.valueOf(zza())), 14, exc);
            }
            if (e == null) {
                throw new MlKitException("Cannot load any model with the model options: ".concat(String.valueOf(zza())), 14);
            }
            throw new MlKitException("Local model load failed with the model options: ".concat(String.valueOf(zza())), 14, e);
        }
    }
}
