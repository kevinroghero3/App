package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class UvmEntries extends AbstractSafeParcelable {
    public static final Parcelable.Creator<UvmEntries> CREATOR = new zzaz();
    private final List zza;

    public static final class Builder {
        private final List zza = new ArrayList();

        public Builder addAll(@NonNull List<UvmEntry> list) {
            com.google.android.gms.internal.fido.zzam.zzc(this.zza.size() + list.size() <= 3);
            this.zza.addAll(list);
            return this;
        }

        public Builder addUvmEntry(@Nullable UvmEntry uvmEntry) {
            if (this.zza.size() >= 3) {
                throw new IllegalStateException();
            }
            this.zza.add(uvmEntry);
            return this;
        }

        public UvmEntries build() {
            return new UvmEntries(this.zza);
        }
    }

    UvmEntries(@Nullable @SafeParcelable.Param(id = 1) List list) {
        this.zza = list;
    }

    public boolean equals(@NonNull Object obj) {
        List list;
        if (!(obj instanceof UvmEntries)) {
            return false;
        }
        UvmEntries uvmEntries = (UvmEntries) obj;
        List list2 = this.zza;
        return (list2 == null && uvmEntries.zza == null) || (list2 != null && (list = uvmEntries.zza) != null && list2.containsAll(list) && uvmEntries.zza.containsAll(this.zza));
    }

    public List<UvmEntry> getUvmEntryList() {
        return this.zza;
    }

    public int hashCode() {
        return Objects.hashCode(new HashSet(this.zza));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, getUvmEntryList(), false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
