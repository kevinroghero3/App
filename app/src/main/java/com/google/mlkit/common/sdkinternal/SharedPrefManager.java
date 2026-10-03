package com.google.mlkit.common.sdkinternal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.Dependency;
import com.google.mlkit.common.model.RemoteModel;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public class SharedPrefManager {
    public static final Component<?> COMPONENT = Component.builder(SharedPrefManager.class).add(Dependency.required((Class<?>) MlKitContext.class)).add(Dependency.required((Class<?>) Context.class)).factory(new ComponentFactory() { // from class: com.google.mlkit.common.sdkinternal.zzs
        @Override // com.google.firebase.components.ComponentFactory
        public final Object create(ComponentContainer componentContainer) {
            return new SharedPrefManager((Context) componentContainer.get(Context.class));
        }
    }).build();
    public static final String PREF_FILE = "com.google.mlkit.internal";
    protected final Context zza;

    public SharedPrefManager(@NonNull Context context) {
        this.zza = context;
    }

    public static SharedPrefManager getInstance(@NonNull MlKitContext mlKitContext) {
        return (SharedPrefManager) mlKitContext.get(SharedPrefManager.class);
    }

    public void clearDownloadingModelInfo(@NonNull RemoteModel remoteModel) {
        synchronized (this) {
            zza().edit().remove(String.format("downloading_model_id_%s", remoteModel.getUniqueModelNameForPersist())).remove(String.format("downloading_model_hash_%s", remoteModel.getUniqueModelNameForPersist())).remove(String.format("downloading_model_type_%s", getDownloadingModelHash(remoteModel))).remove(String.format("downloading_begin_time_%s", remoteModel.getUniqueModelNameForPersist())).remove(String.format("model_first_use_time_%s", remoteModel.getUniqueModelNameForPersist())).apply();
        }
    }

    public void clearIncompatibleModelInfo(@NonNull RemoteModel remoteModel) {
        synchronized (this) {
            zza().edit().remove(String.format("bad_hash_%s", remoteModel.getUniqueModelNameForPersist())).remove("app_version").apply();
        }
    }

    public void clearLatestModelHash(@NonNull RemoteModel remoteModel) {
        synchronized (this) {
            zza().edit().remove(String.format("current_model_hash_%s", remoteModel.getUniqueModelNameForPersist())).commit();
        }
    }

    public String getDownloadingModelHash(@NonNull RemoteModel remoteModel) {
        String string;
        synchronized (this) {
            string = zza().getString(String.format("downloading_model_hash_%s", remoteModel.getUniqueModelNameForPersist()), null);
        }
        return string;
    }

    public Long getDownloadingModelId(@NonNull RemoteModel remoteModel) {
        synchronized (this) {
            long j = zza().getLong(String.format("downloading_model_id_%s", remoteModel.getUniqueModelNameForPersist()), -1L);
            if (j < 0) {
                return null;
            }
            return Long.valueOf(j);
        }
    }

    public String getIncompatibleModelHash(@NonNull RemoteModel remoteModel) {
        String string;
        synchronized (this) {
            string = zza().getString(String.format("bad_hash_%s", remoteModel.getUniqueModelNameForPersist()), null);
        }
        return string;
    }

    public String getLatestModelHash(@NonNull RemoteModel remoteModel) {
        String string;
        synchronized (this) {
            string = zza().getString(String.format("current_model_hash_%s", remoteModel.getUniqueModelNameForPersist()), null);
        }
        return string;
    }

    public String getMlSdkInstanceId() {
        synchronized (this) {
            String string = zza().getString("ml_sdk_instance_id", null);
            if (string != null) {
                return string;
            }
            String string2 = UUID.randomUUID().toString();
            zza().edit().putString("ml_sdk_instance_id", string2).apply();
            return string2;
        }
    }

    public long getModelDownloadBeginTimeMs(@NonNull RemoteModel remoteModel) {
        long j;
        synchronized (this) {
            j = zza().getLong(String.format("downloading_begin_time_%s", remoteModel.getUniqueModelNameForPersist()), 0L);
        }
        return j;
    }

    public long getModelFirstUseTimeMs(@NonNull RemoteModel remoteModel) {
        long j;
        synchronized (this) {
            j = zza().getLong(String.format("model_first_use_time_%s", remoteModel.getUniqueModelNameForPersist()), 0L);
        }
        return j;
    }

    public String getPreviousAppVersion() {
        String string;
        synchronized (this) {
            string = zza().getString("app_version", null);
        }
        return string;
    }

    public void setDownloadingModelInfo(long j, @NonNull ModelInfo modelInfo) {
        synchronized (this) {
            String modelNameForPersist = modelInfo.getModelNameForPersist();
            zza().edit().putString(String.format("downloading_model_hash_%s", modelNameForPersist), modelInfo.getModelHash()).putLong(String.format("downloading_model_id_%s", modelNameForPersist), j).putLong(String.format("downloading_begin_time_%s", modelNameForPersist), SystemClock.elapsedRealtime()).apply();
        }
    }

    public void setIncompatibleModelInfo(@NonNull RemoteModel remoteModel, @NonNull String str, @NonNull String str2) {
        synchronized (this) {
            zza().edit().putString(String.format("bad_hash_%s", remoteModel.getUniqueModelNameForPersist()), str).putString("app_version", str2).apply();
        }
    }

    public void setLatestModelHash(@NonNull RemoteModel remoteModel, @NonNull String str) {
        synchronized (this) {
            zza().edit().putString(String.format("current_model_hash_%s", remoteModel.getUniqueModelNameForPersist()), str).apply();
        }
    }

    public void setModelFirstUseTimeMs(@NonNull RemoteModel remoteModel, long j) {
        synchronized (this) {
            zza().edit().putLong(String.format("model_first_use_time_%s", remoteModel.getUniqueModelNameForPersist()), j).apply();
        }
    }

    protected final SharedPreferences zza() {
        return this.zza.getSharedPreferences(PREF_FILE, 0);
    }

    public final String zzb(@NonNull String str, long j) {
        String string;
        synchronized (this) {
            string = zza().getString(String.format("cached_local_model_hash_%1s_%2s", Preconditions.checkNotNull(str), Long.valueOf(j)), null);
        }
        return string;
    }

    public final void zzc(@NonNull String str, long j, @NonNull String str2) {
        synchronized (this) {
            zza().edit().putString(String.format("cached_local_model_hash_%1s_%2s", Preconditions.checkNotNull(str), Long.valueOf(j)), str2).apply();
        }
    }
}
