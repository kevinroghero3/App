package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzjm;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
final class zzjk<T extends zzjm<T>> {
    private static final zzjk zzb = new zzjk(true);
    final zzma<T, Object> zza;
    private boolean zzc;
    private boolean zzd;

    static int zza(zznh zznhVar, int i, Object obj) {
        int iZzf = zzjb.zzf(i);
        if (zznhVar == zznh.zzj) {
            zzjx.zza((zzlh) obj);
            iZzf <<= 1;
        }
        return iZzf + zza(zznhVar, obj);
    }

    private static int zza(zznh zznhVar, Object obj) {
        switch (zzjn.zzb[zznhVar.ordinal()]) {
            case 1:
                return zzjb.zza(((Double) obj).doubleValue());
            case 2:
                return zzjb.zza(((Float) obj).floatValue());
            case 3:
                return zzjb.zzb(((Long) obj).longValue());
            case 4:
                return zzjb.zze(((Long) obj).longValue());
            case 5:
                return zzjb.zzc(((Integer) obj).intValue());
            case 6:
                return zzjb.zza(((Long) obj).longValue());
            case 7:
                return zzjb.zzb(((Integer) obj).intValue());
            case 8:
                return zzjb.zza(((Boolean) obj).booleanValue());
            case 9:
                return zzjb.zza((zzlh) obj);
            case 10:
                if (obj instanceof zzkh) {
                    return zzjb.zza((zzkh) obj);
                }
                return zzjb.zzb((zzlh) obj);
            case 11:
                if (obj instanceof zzih) {
                    return zzjb.zza((zzih) obj);
                }
                return zzjb.zza((String) obj);
            case 12:
                if (obj instanceof zzih) {
                    return zzjb.zza((zzih) obj);
                }
                return zzjb.zza((byte[]) obj);
            case 13:
                return zzjb.zzg(((Integer) obj).intValue());
            case 14:
                return zzjb.zzd(((Integer) obj).intValue());
            case 15:
                return zzjb.zzc(((Long) obj).longValue());
            case 16:
                return zzjb.zze(((Integer) obj).intValue());
            case 17:
                return zzjb.zzd(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzjw) {
                    return zzjb.zza(((zzjw) obj).zza());
                }
                return zzjb.zza(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int zza(zzjm<?> zzjmVar, Object obj) {
        zznh zznhVarZzb = zzjmVar.zzb();
        int iZza = zzjmVar.zza();
        if (zzjmVar.zze()) {
            List list = (List) obj;
            int iZza2 = 0;
            if (zzjmVar.zzd()) {
                if (list.isEmpty()) {
                    return 0;
                }
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    iZza2 += zza(zznhVarZzb, it2.next());
                }
                return zzjb.zzf(iZza) + iZza2 + zzjb.zzg(iZza2);
            }
            Iterator it3 = list.iterator();
            while (it3.hasNext()) {
                iZza2 += zza(zznhVarZzb, iZza, it3.next());
            }
            return iZza2;
        }
        return zza(zznhVarZzb, iZza, obj);
    }

    public final int zza() {
        int iZza = 0;
        for (int i = 0; i < this.zza.zza(); i++) {
            iZza += zza((Map.Entry) this.zza.zzb(i));
        }
        Iterator it2 = this.zza.zzb().iterator();
        while (it2.hasNext()) {
            iZza += zza((Map.Entry) it2.next());
        }
        return iZza;
    }

    private static int zza(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (key.zzc() == zznr.MESSAGE && !key.zze() && !key.zzd()) {
            if (value instanceof zzkh) {
                return zzjb.zza(entry.getKey().zza(), (zzkh) value);
            }
            return zzjb.zza(entry.getKey().zza(), (zzlh) value);
        }
        return zza((zzjm<?>) key, value);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public static <T extends zzjm<T>> zzjk<T> zzb() {
        return zzb;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzjk zzjkVar = new zzjk();
        for (int i = 0; i < this.zza.zza(); i++) {
            Map.Entry<K, Object> entryZzb = this.zza.zzb(i);
            zzjkVar.zzb((zzjm) entryZzb.getKey(), entryZzb.getValue());
        }
        Iterator it2 = this.zza.zzb().iterator();
        while (it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it2.next();
            zzjkVar.zzb((zzjm) entry.getKey(), entry.getValue());
        }
        zzjkVar.zzd = this.zzd;
        return zzjkVar;
    }

    private static Object zza(Object obj) {
        if (obj instanceof zzlm) {
            return ((zzlm) obj).clone();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private final Object zza(T t) {
        Object obj = this.zza.get(t);
        return obj instanceof zzkh ? zzkh.zza() : obj;
    }

    final Iterator<Map.Entry<T, Object>> zzc() {
        if (this.zzd) {
            return new zzki(this.zza.zzc().iterator());
        }
        return this.zza.zzc().iterator();
    }

    public final Iterator<Map.Entry<T, Object>> zzd() {
        if (this.zzd) {
            return new zzki(this.zza.entrySet().iterator());
        }
        return this.zza.entrySet().iterator();
    }

    private zzjk() {
        this.zza = zzma.zza(16);
    }

    private zzjk(zzma<T, Object> zzmaVar) {
        this.zza = zzmaVar;
        zze();
    }

    private zzjk(boolean z) {
        this(zzma.zza(0));
        zze();
    }

    public final void zze() {
        if (this.zzc) {
            return;
        }
        for (int i = 0; i < this.zza.zza(); i++) {
            Map.Entry<K, Object> entryZzb = this.zza.zzb(i);
            if (entryZzb.getValue() instanceof zzju) {
                ((zzju) entryZzb.getValue()).zzch();
            }
        }
        this.zza.zzd();
        this.zzc = true;
    }

    public final void zza(zzjk<T> zzjkVar) {
        for (int i = 0; i < zzjkVar.zza.zza(); i++) {
            zzb((Map.Entry) zzjkVar.zza.zzb(i));
        }
        Iterator it2 = zzjkVar.zza.zzb().iterator();
        while (it2.hasNext()) {
            zzb((Map.Entry) it2.next());
        }
    }

    private final void zzb(Map.Entry<T, Object> entry) {
        zzlh zzlhVarZzah;
        T key = entry.getKey();
        Object value = entry.getValue();
        boolean z = value instanceof zzkh;
        if (key.zze()) {
            if (z) {
                throw new IllegalStateException("Lazy fields can not be repeated");
            }
            Object objZza = zza((zzjm) key);
            if (objZza == null) {
                objZza = new ArrayList();
            }
            Iterator it2 = ((List) value).iterator();
            while (it2.hasNext()) {
                ((List) objZza).add(zza(it2.next()));
            }
            this.zza.put(key, objZza);
            return;
        }
        if (key.zzc() != zznr.MESSAGE) {
            if (z) {
                throw new IllegalStateException("Lazy fields must be message-valued");
            }
            this.zza.put(key, zza(value));
            return;
        }
        Object objZza2 = zza((zzjm) key);
        if (objZza2 == null) {
            this.zza.put(key, zza(value));
            if (z) {
                this.zzd = true;
                return;
            }
            return;
        }
        if (z) {
            value = zzkh.zza();
        }
        if (objZza2 instanceof zzlm) {
            zzlhVarZzah = key.zza((zzlm) objZza2, (zzlm) value);
        } else {
            zzlhVarZzah = key.zza(((zzlh) objZza2).zzcg(), (zzlh) value).zzah();
        }
        this.zza.put(key, zzlhVarZzah);
    }

    private final void zzb(T t, Object obj) {
        if (t.zze()) {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList.get(i);
                i++;
                zzc(t, obj2);
            }
            obj = arrayList;
        } else {
            zzc(t, obj);
        }
        if (obj instanceof zzkh) {
            this.zzd = true;
        }
        this.zza.put(t, obj);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:32:? A[RETURN, SYNTHETIC] */
    private static void zzc(T t, Object obj) {
        boolean z;
        zznh zznhVarZzb = t.zzb();
        zzjx.zza(obj);
        switch (zzjn.zza[zznhVarZzb.zzb().ordinal()]) {
            case 1:
                z = obj instanceof Integer;
                if (z) {
                    return;
                }
                int iZza = t.zza();
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(iZza), t.zzb().zzb(), obj.getClass().getName()));
            case 2:
                z = obj instanceof Long;
                if (z) {
                    return;
                }
                int iZza2 = t.zza();
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(iZza2), t.zzb().zzb(), obj.getClass().getName()));
            case 3:
                z = obj instanceof Float;
                if (z) {
                    return;
                }
                int iZza3 = t.zza();
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(iZza3), t.zzb().zzb(), obj.getClass().getName()));
            case 4:
                z = obj instanceof Double;
                if (z) {
                    return;
                }
                int iZza4 = t.zza();
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(iZza4), t.zzb().zzb(), obj.getClass().getName()));
            case 5:
                z = obj instanceof Boolean;
                if (z) {
                    return;
                }
                int iZza5 = t.zza();
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(iZza5), t.zzb().zzb(), obj.getClass().getName()));
            case 6:
                z = obj instanceof String;
                if (z) {
                    return;
                }
                int iZza6 = t.zza();
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(iZza6), t.zzb().zzb(), obj.getClass().getName()));
            case 7:
                if ((obj instanceof zzih) || (obj instanceof byte[])) {
                    return;
                }
                int iZza7 = t.zza();
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(iZza7), t.zzb().zzb(), obj.getClass().getName()));
            case 8:
                if ((obj instanceof Integer) || (obj instanceof zzjw)) {
                    return;
                }
                int iZza8 = t.zza();
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(iZza8), t.zzb().zzb(), obj.getClass().getName()));
            case 9:
                if ((obj instanceof zzlh) || (obj instanceof zzkh)) {
                    return;
                }
                int iZza9 = t.zza();
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(iZza9), t.zzb().zzb(), obj.getClass().getName()));
            default:
                int iZza10 = t.zza();
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(iZza10), t.zzb().zzb(), obj.getClass().getName()));
        }
    }

    static void zza(zzjb zzjbVar, zznh zznhVar, int i, Object obj) throws IOException {
        if (zznhVar == zznh.zzj) {
            zzlh zzlhVar = (zzlh) obj;
            zzjx.zza(zzlhVar);
            zzjbVar.zzj(i, 3);
            zzlhVar.zza(zzjbVar);
            zzjbVar.zzj(i, 4);
        }
        zzjbVar.zzj(i, zznhVar.zza());
        switch (zzjn.zzb[zznhVar.ordinal()]) {
            case 1:
                zzjbVar.zzb(((Double) obj).doubleValue());
                break;
            case 2:
                zzjbVar.zzb(((Float) obj).floatValue());
                break;
            case 3:
                zzjbVar.zzh(((Long) obj).longValue());
                break;
            case 4:
                zzjbVar.zzh(((Long) obj).longValue());
                break;
            case 5:
                zzjbVar.zzi(((Integer) obj).intValue());
                break;
            case 6:
                zzjbVar.zzf(((Long) obj).longValue());
                break;
            case 7:
                zzjbVar.zzh(((Integer) obj).intValue());
                break;
            case 8:
                zzjbVar.zzb(((Boolean) obj).booleanValue());
                break;
            case 9:
                ((zzlh) obj).zza(zzjbVar);
                break;
            case 10:
                zzjbVar.zzc((zzlh) obj);
                break;
            case 11:
                if (obj instanceof zzih) {
                    zzjbVar.zzb((zzih) obj);
                } else {
                    zzjbVar.zzb((String) obj);
                }
                break;
            case 12:
                if (obj instanceof zzih) {
                    zzjbVar.zzb((zzih) obj);
                } else {
                    byte[] bArr = (byte[]) obj;
                    zzjbVar.zzb(bArr, 0, bArr.length);
                }
                break;
            case 13:
                zzjbVar.zzk(((Integer) obj).intValue());
                break;
            case 14:
                zzjbVar.zzh(((Integer) obj).intValue());
                break;
            case 15:
                zzjbVar.zzf(((Long) obj).longValue());
                break;
            case 16:
                zzjbVar.zzj(((Integer) obj).intValue());
                break;
            case 17:
                zzjbVar.zzg(((Long) obj).longValue());
                break;
            case 18:
                if (obj instanceof zzjw) {
                    zzjbVar.zzi(((zzjw) obj).zza());
                } else {
                    zzjbVar.zzi(((Integer) obj).intValue());
                }
                break;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzjk) {
            return this.zza.equals(((zzjk) obj).zza);
        }
        return false;
    }

    public final boolean zzf() {
        return this.zzc;
    }

    public final boolean zzg() {
        for (int i = 0; i < this.zza.zza(); i++) {
            if (!zzc(this.zza.zzb(i))) {
                return false;
            }
        }
        Iterator it2 = this.zza.zzb().iterator();
        while (it2.hasNext()) {
            if (!zzc((Map.Entry) it2.next())) {
                return false;
            }
        }
        return true;
    }

    private static <T extends zzjm<T>> boolean zzc(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.zzc() != zznr.MESSAGE) {
            return true;
        }
        if (key.zze()) {
            Iterator it2 = ((List) entry.getValue()).iterator();
            while (it2.hasNext()) {
                if (!zzb(it2.next())) {
                    return false;
                }
            }
            return true;
        }
        return zzb(entry.getValue());
    }

    private static boolean zzb(Object obj) {
        if (obj instanceof zzlj) {
            return ((zzlj) obj).i_();
        }
        if (obj instanceof zzkh) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }
}
