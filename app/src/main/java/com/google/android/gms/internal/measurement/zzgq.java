package com.google.android.gms.internal.measurement;

import android.content.Context;
import com.google.common.base.Optional;
import com.google.common.base.Supplier;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
final class zzgq extends zzhp {
    private final Context zza;

    @Nullable
    private final Supplier<Optional<zzhc>> zzb;

    public final int hashCode() {
        int iHashCode = this.zza.hashCode();
        Supplier<Optional<zzhc>> supplier = this.zzb;
        return ((iHashCode ^ 1000003) * 1000003) ^ (supplier == null ? 0 : supplier.hashCode());
    }

    @Override // com.google.android.gms.internal.measurement.zzhp
    final Context zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzhp
    @Nullable
    final Supplier<Optional<zzhc>> zzb() {
        return this.zzb;
    }

    public final String toString() {
        return "FlagsContext{context=" + String.valueOf(this.zza) + ", hermeticFileOverrides=" + String.valueOf(this.zzb) + "}";
    }

    zzgq(Context context, @Nullable Supplier<Optional<zzhc>> supplier) {
        if (context == null) {
            throw new NullPointerException("Null context");
        }
        this.zza = context;
        this.zzb = supplier;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzhp)) {
            return false;
        }
        zzhp zzhpVar = (zzhp) obj;
        if (!this.zza.equals(zzhpVar.zza())) {
            return false;
        }
        Supplier<Optional<zzhc>> supplier = this.zzb;
        if (supplier == null) {
            if (zzhpVar.zzb() != null) {
                return false;
            }
        } else if (!supplier.equals(zzhpVar.zzb())) {
            return false;
        }
        return true;
    }
}
