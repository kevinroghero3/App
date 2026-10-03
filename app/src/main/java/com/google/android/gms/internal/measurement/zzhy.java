package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzhy;
import com.google.android.gms.internal.measurement.zzia;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class zzhy<MessageType extends zzhy<MessageType, BuilderType>, BuilderType extends zzia<MessageType, BuilderType>> implements zzlh {
    protected int zza = 0;

    int zzbv() {
        throw new UnsupportedOperationException();
    }

    int zza(zzlz zzlzVar) {
        int iZzbv = zzbv();
        if (iZzbv != -1) {
            return iZzbv;
        }
        int iZza = zzlzVar.zza(this);
        zzc(iZza);
        return iZza;
    }

    @Override // com.google.android.gms.internal.measurement.zzlh
    public final zzih zzbw() {
        try {
            zziq zziqVarZzc = zzih.zzc(zzby());
            zza(zziqVarZzc.zzb());
            return zziqVarZzc.zza();
        } catch (IOException e) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a ByteString threw an IOException (should never happen).", e);
        }
    }

    protected static <T> void zza(Iterable<T> iterable, List<? super T> list) {
        zzjx.zza(iterable);
        if (iterable instanceof zzkn) {
            List<?> listZze = ((zzkn) iterable).zze();
            zzkn zzknVar = (zzkn) list;
            int size = list.size();
            for (Object obj : listZze) {
                if (obj == null) {
                    String str = "Element at index " + (zzknVar.size() - size) + " is null.";
                    for (int size2 = zzknVar.size() - 1; size2 >= size; size2--) {
                        zzknVar.remove(size2);
                    }
                    throw new NullPointerException(str);
                }
                if (obj instanceof zzih) {
                    zzknVar.zza((zzih) obj);
                } else {
                    zzknVar.add((String) obj);
                }
            }
            return;
        }
        if (iterable instanceof zzlt) {
            list.addAll((Collection) iterable);
            return;
        }
        if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
            ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
        }
        int size3 = list.size();
        for (T t : iterable) {
            if (t == null) {
                String str2 = "Element at index " + (list.size() - size3) + " is null.";
                for (int size4 = list.size() - 1; size4 >= size3; size4--) {
                    list.remove(size4);
                }
                throw new NullPointerException(str2);
            }
            list.add(t);
        }
    }

    void zzc(int i) {
        throw new UnsupportedOperationException();
    }

    public final byte[] zzbx() {
        try {
            byte[] bArr = new byte[zzby()];
            zzjb zzjbVarZzb = zzjb.zzb(bArr);
            zza(zzjbVarZzb);
            zzjbVarZzb.zzb();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a byte array threw an IOException (should never happen).", e);
        }
    }
}
