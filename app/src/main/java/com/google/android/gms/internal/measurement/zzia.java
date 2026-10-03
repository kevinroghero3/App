package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzhy;
import com.google.android.gms.internal.measurement.zzia;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public abstract class zzia<MessageType extends zzhy<MessageType, BuilderType>, BuilderType extends zzia<MessageType, BuilderType>> implements zzlg {
    @Override // 
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public abstract BuilderType zzb(zziv zzivVar, zzjh zzjhVar) throws IOException;

    @Override // 
    /* JADX INFO: renamed from: zzae, reason: merged with bridge method [inline-methods] */
    public abstract BuilderType clone();

    public BuilderType zza(byte[] bArr, int i, int i2) throws zzkc {
        try {
            zziv zzivVarZza = zziv.zza(bArr, 0, i2, false);
            zzb(zzivVarZza, zzjh.zza);
            zzivVarZza.zzc(0);
            return this;
        } catch (zzkc e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException(zza("byte array"), e2);
        }
    }

    public BuilderType zza(byte[] bArr, int i, int i2, zzjh zzjhVar) throws zzkc {
        try {
            zziv zzivVarZza = zziv.zza(bArr, 0, i2, false);
            zzb(zzivVarZza, zzjhVar);
            zzivVarZza.zzc(0);
            return this;
        } catch (zzkc e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException(zza("byte array"), e2);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzlg
    public final /* synthetic */ zzlg zza(byte[] bArr) throws zzkc {
        return zza(bArr, 0, bArr.length);
    }

    @Override // com.google.android.gms.internal.measurement.zzlg
    public final /* synthetic */ zzlg zza(byte[] bArr, zzjh zzjhVar) throws zzkc {
        return zza(bArr, 0, bArr.length, zzjhVar);
    }

    private final String zza(String str) {
        return "Reading " + getClass().getName() + " from a " + str + " threw an IOException (should never happen).";
    }
}
