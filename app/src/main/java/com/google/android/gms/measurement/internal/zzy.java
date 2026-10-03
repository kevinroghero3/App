package com.google.android.gms.measurement.internal;

import androidx.collection.ArrayMap;
import com.google.android.gms.internal.measurement.zzov;
import com.google.maps.android.BuildConfig;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
final class zzy extends zzab {
    private com.google.android.gms.internal.measurement.zzfg.zzb zzg;
    private final /* synthetic */ zzs zzh;

    @Override // com.google.android.gms.measurement.internal.zzab
    final int zza() {
        return this.zzg.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzab
    final boolean zzc() {
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzy(zzs zzsVar, String str, int i, com.google.android.gms.internal.measurement.zzfg.zzb zzbVar) {
        super(str, i);
        this.zzh = zzsVar;
        this.zzg = zzbVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzab
    final boolean zzb() {
        return this.zzg.zzk();
    }

    /* JADX WARN: Code duplicated, block: B:104:0x02b1  */
    /* JADX WARN: Code duplicated, block: B:107:0x02c3  */
    /* JADX WARN: Code duplicated, block: B:112:0x02d1  */
    /* JADX WARN: Code duplicated, block: B:114:0x02d7  */
    /* JADX WARN: Code duplicated, block: B:115:0x02e8  */
    /* JADX WARN: Code duplicated, block: B:117:0x02ee  */
    /* JADX WARN: Code duplicated, block: B:119:0x02f6  */
    /* JADX WARN: Code duplicated, block: B:122:0x0302  */
    /* JADX WARN: Code duplicated, block: B:128:0x0356 A[EDGE_INSN: B:128:0x0356->B:131:0x03a2 BREAK  A[LOOP:0: B:47:0x0118->B:52:0x0149]] */
    /* JADX WARN: Code duplicated, block: B:129:0x037c A[EDGE_INSN: B:129:0x037c->B:131:0x03a2 BREAK  A[LOOP:0: B:47:0x0118->B:52:0x0149]] */
    /* JADX WARN: Code duplicated, block: B:163:0x0151 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:164:0x012e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:165:0x01eb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:166:0x0174 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:167:0x0192 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:168:0x01b0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:169:0x017a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:170:0x0198 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:171:0x01c2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:173:0x015e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:177:0x027e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:178:0x03a0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:179:0x0218 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:180:0x0282 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:181:0x0241 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:182:0x03a2 A[EDGE_INSN: B:182:0x03a2->B:131:0x03a2 BREAK  A[LOOP:0: B:47:0x0118->B:52:0x0149], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:183:0x02cd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:184:0x028c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:185:0x03a2 A[EDGE_INSN: B:185:0x03a2->B:131:0x03a2 BREAK  A[LOOP:0: B:47:0x0118->B:52:0x0149], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:186:0x02c9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:187:0x023b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:188:0x0286 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:189:0x0354 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:190:0x0330 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:191:0x030c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:192:0x03a2 A[EDGE_INSN: B:192:0x03a2->B:131:0x03a2 BREAK  A[LOOP:0: B:47:0x0118->B:52:0x0149], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:193:0x0308 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:195:0x01f3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:196:0x01f3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:197:0x01f3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:0x010b  */
    /* JADX WARN: Code duplicated, block: B:49:0x011e  */
    /* JADX WARN: Code duplicated, block: B:52:0x0149 A[LOOP:0: B:47:0x0118->B:52:0x0149, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:56:0x0164  */
    /* JADX WARN: Code duplicated, block: B:62:0x0184  */
    /* JADX WARN: Code duplicated, block: B:63:0x018d  */
    /* JADX WARN: Code duplicated, block: B:69:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:70:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:74:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:79:0x01f9  */
    /* JADX WARN: Code duplicated, block: B:84:0x020d  */
    /* JADX WARN: Code duplicated, block: B:88:0x0233  */
    /* JADX WARN: Code duplicated, block: B:93:0x0266  */
    /* JADX WARN: Code duplicated, block: B:96:0x0278  */
    /* JADX WARN: Multi-variable type inference failed */
    final boolean zza(Long l, Long l2, com.google.android.gms.internal.measurement.zzfs.zze zzeVar, long j, zzbb zzbbVar, boolean z) {
        HashSet hashSet;
        Iterator<com.google.android.gms.internal.measurement.zzfg.zzc> it2;
        ArrayMap arrayMap;
        Iterator<com.google.android.gms.internal.measurement.zzfs.zzg> it3;
        Iterator<com.google.android.gms.internal.measurement.zzfg.zzc> it4;
        com.google.android.gms.internal.measurement.zzfg.zzc next;
        boolean z2;
        String strZze;
        Object obj;
        Boolean boolZza;
        Boolean boolZza2;
        String str;
        Boolean boolZza3;
        com.google.android.gms.internal.measurement.zzfs.zzg next2;
        Long lValueOf;
        Double dValueOf;
        com.google.android.gms.internal.measurement.zzfg.zzc next3;
        byte b = zzov.zza() && this.zzh.zze().zzf(this.zza, zzbh.zzbi);
        long j2 = this.zzg.zzj() ? zzbbVar.zze : j;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        Boolean bool = null;
        if (this.zzh.zzj().zza(2)) {
            this.zzh.zzj().zzp().zza("Evaluating filter. audience, filter, event", Integer.valueOf(this.zzb), this.zzg.zzl() ? Integer.valueOf(this.zzg.zzb()) : null, this.zzh.zzi().zza(this.zzg.zzf()));
            this.zzh.zzj().zzp().zza("Filter definition", this.zzh.g_().zza(this.zzg));
        }
        if (!this.zzg.zzl() || this.zzg.zzb() > 256) {
            this.zzh.zzj().zzu().zza("Invalid event filter ID. appId, id", zzgb.zza(this.zza), String.valueOf(this.zzg.zzl() ? Integer.valueOf(this.zzg.zzb()) : null));
            return false;
        }
        byte b2 = this.zzg.zzh() || this.zzg.zzi() || this.zzg.zzj();
        if (z && b2 == false) {
            this.zzh.zzj().zzp().zza("Event filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", Integer.valueOf(this.zzb), this.zzg.zzl() ? Integer.valueOf(this.zzg.zzb()) : null);
            return true;
        }
        com.google.android.gms.internal.measurement.zzfg.zzb zzbVar = this.zzg;
        String strZzg = zzeVar.zzg();
        if (zzbVar.zzk()) {
            Boolean boolZza4 = zzab.zza(j2, zzbVar.zze());
            if (boolZza4 != null) {
                if (!boolZza4.booleanValue()) {
                    bool = Boolean.FALSE;
                } else {
                    hashSet = new HashSet();
                    it2 = zzbVar.zzg().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            next3 = it2.next();
                            if (next3.zze().isEmpty()) {
                                this.zzh.zzj().zzu().zza("null or empty param name in filter. event", this.zzh.zzi().zza(strZzg));
                                break;
                            }
                            hashSet.add(next3.zze());
                        } else {
                            arrayMap = new ArrayMap();
                            it3 = zzeVar.zzh().iterator();
                            while (true) {
                                if (it3.hasNext()) {
                                    next2 = it3.next();
                                    if (!hashSet.contains(next2.zzg())) {
                                        if (next2.zzl()) {
                                            String strZzg2 = next2.zzg();
                                            if (next2.zzl()) {
                                                lValueOf = Long.valueOf(next2.zzd());
                                            } else {
                                                lValueOf = null;
                                            }
                                            arrayMap.put(strZzg2, lValueOf);
                                        } else if (next2.zzj()) {
                                            String strZzg3 = next2.zzg();
                                            if (next2.zzj()) {
                                                dValueOf = Double.valueOf(next2.zza());
                                            } else {
                                                dValueOf = null;
                                            }
                                            arrayMap.put(strZzg3, dValueOf);
                                        } else if (next2.zzn()) {
                                            arrayMap.put(next2.zzg(), next2.zzh());
                                        } else {
                                            this.zzh.zzj().zzu().zza("Unknown value for param. event, param", this.zzh.zzi().zza(strZzg), this.zzh.zzi().zzb(next2.zzg()));
                                            break;
                                        }
                                    }
                                } else {
                                    it4 = zzbVar.zzg().iterator();
                                    while (true) {
                                        if (it4.hasNext()) {
                                            next = it4.next();
                                            if (next.zzg()) {
                                                z2 = false;
                                            } else {
                                                z2 = false;
                                            }
                                            strZze = next.zze();
                                            if (strZze.isEmpty()) {
                                                this.zzh.zzj().zzu().zza("Event has empty param name. event", this.zzh.zzi().zza(strZzg));
                                                break;
                                            }
                                            obj = arrayMap.get(strZze);
                                            if (obj instanceof Long) {
                                                if (!next.zzh()) {
                                                    this.zzh.zzj().zzu().zza("No number filter for long param. event, param", this.zzh.zzi().zza(strZzg), this.zzh.zzi().zzb(strZze));
                                                    break;
                                                }
                                                boolZza = zzab.zza(((Long) obj).longValue(), next.zzc());
                                                if (boolZza != null) {
                                                    break;
                                                    break;
                                                }
                                                if (boolZza.booleanValue() == z2) {
                                                    bool = Boolean.FALSE;
                                                    break;
                                                }
                                            } else if (obj instanceof Double) {
                                                if (!next.zzh()) {
                                                    this.zzh.zzj().zzu().zza("No number filter for double param. event, param", this.zzh.zzi().zza(strZzg), this.zzh.zzi().zzb(strZze));
                                                    break;
                                                }
                                                boolZza2 = zzab.zza(((Double) obj).doubleValue(), next.zzc());
                                                if (boolZza2 != null) {
                                                    break;
                                                    break;
                                                }
                                                if (boolZza2.booleanValue() == z2) {
                                                    bool = Boolean.FALSE;
                                                    break;
                                                }
                                            } else {
                                                if (obj instanceof String) {
                                                    if (obj == null) {
                                                        this.zzh.zzj().zzp().zza("Missing param for filter. event, param", this.zzh.zzi().zza(strZzg), this.zzh.zzi().zzb(strZze));
                                                        bool = Boolean.FALSE;
                                                        break;
                                                    }
                                                    this.zzh.zzj().zzu().zza("Unknown param type. event, param", this.zzh.zzi().zza(strZzg), this.zzh.zzi().zzb(strZze));
                                                    break;
                                                }
                                                if (next.zzj()) {
                                                    boolZza3 = zzab.zza((String) obj, next.zzd(), this.zzh.zzj());
                                                } else if (next.zzh()) {
                                                    str = (String) obj;
                                                    if (zznt.zzb(str)) {
                                                        boolZza3 = zzab.zza(str, next.zzc());
                                                    } else {
                                                        this.zzh.zzj().zzu().zza("Invalid param value for number filter. event, param", this.zzh.zzi().zza(strZzg), this.zzh.zzi().zzb(strZze));
                                                        break;
                                                    }
                                                } else {
                                                    this.zzh.zzj().zzu().zza("No filter for String param. event, param", this.zzh.zzi().zza(strZzg), this.zzh.zzi().zzb(strZze));
                                                    break;
                                                }
                                                if (boolZza3 != null) {
                                                    break;
                                                    break;
                                                }
                                                if (boolZza3.booleanValue() == z2) {
                                                    bool = Boolean.FALSE;
                                                    break;
                                                }
                                            }
                                        } else {
                                            bool = Boolean.TRUE;
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else {
            hashSet = new HashSet();
            it2 = zzbVar.zzg().iterator();
            while (true) {
                if (it2.hasNext()) {
                    next3 = it2.next();
                    if (next3.zze().isEmpty()) {
                        this.zzh.zzj().zzu().zza("null or empty param name in filter. event", this.zzh.zzi().zza(strZzg));
                        break;
                    }
                    hashSet.add(next3.zze());
                } else {
                    arrayMap = new ArrayMap();
                    it3 = zzeVar.zzh().iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            next2 = it3.next();
                            if (!hashSet.contains(next2.zzg())) {
                                if (next2.zzl()) {
                                    String strZzg4 = next2.zzg();
                                    if (next2.zzl()) {
                                        lValueOf = Long.valueOf(next2.zzd());
                                    } else {
                                        lValueOf = null;
                                    }
                                    arrayMap.put(strZzg4, lValueOf);
                                } else if (next2.zzj()) {
                                    String strZzg5 = next2.zzg();
                                    if (next2.zzj()) {
                                        dValueOf = Double.valueOf(next2.zza());
                                    } else {
                                        dValueOf = null;
                                    }
                                    arrayMap.put(strZzg5, dValueOf);
                                } else if (next2.zzn()) {
                                    arrayMap.put(next2.zzg(), next2.zzh());
                                } else {
                                    this.zzh.zzj().zzu().zza("Unknown value for param. event, param", this.zzh.zzi().zza(strZzg), this.zzh.zzi().zzb(next2.zzg()));
                                    break;
                                }
                            }
                        } else {
                            it4 = zzbVar.zzg().iterator();
                            while (true) {
                                if (it4.hasNext()) {
                                    next = it4.next();
                                    if (next.zzg() || !next.zzf()) {
                                        z2 = false;
                                    } else {
                                        z2 = true;
                                    }
                                    strZze = next.zze();
                                    if (strZze.isEmpty()) {
                                        this.zzh.zzj().zzu().zza("Event has empty param name. event", this.zzh.zzi().zza(strZzg));
                                        break;
                                    }
                                    obj = arrayMap.get(strZze);
                                    if (obj instanceof Long) {
                                        if (!next.zzh()) {
                                            this.zzh.zzj().zzu().zza("No number filter for long param. event, param", this.zzh.zzi().zza(strZzg), this.zzh.zzi().zzb(strZze));
                                            break;
                                        }
                                        boolZza = zzab.zza(((Long) obj).longValue(), next.zzc());
                                        if (boolZza != null) {
                                            break;
                                        }
                                        if (boolZza.booleanValue() == z2) {
                                            bool = Boolean.FALSE;
                                            break;
                                        }
                                    } else if (obj instanceof Double) {
                                        if (!next.zzh()) {
                                            this.zzh.zzj().zzu().zza("No number filter for double param. event, param", this.zzh.zzi().zza(strZzg), this.zzh.zzi().zzb(strZze));
                                            break;
                                        }
                                        boolZza2 = zzab.zza(((Double) obj).doubleValue(), next.zzc());
                                        if (boolZza2 != null) {
                                            break;
                                        }
                                        if (boolZza2.booleanValue() == z2) {
                                            bool = Boolean.FALSE;
                                            break;
                                        }
                                    } else {
                                        if (obj instanceof String) {
                                            if (obj == null) {
                                                this.zzh.zzj().zzp().zza("Missing param for filter. event, param", this.zzh.zzi().zza(strZzg), this.zzh.zzi().zzb(strZze));
                                                bool = Boolean.FALSE;
                                                break;
                                            }
                                            this.zzh.zzj().zzu().zza("Unknown param type. event, param", this.zzh.zzi().zza(strZzg), this.zzh.zzi().zzb(strZze));
                                            break;
                                        }
                                        if (next.zzj()) {
                                            boolZza3 = zzab.zza((String) obj, next.zzd(), this.zzh.zzj());
                                        } else if (next.zzh()) {
                                            str = (String) obj;
                                            if (zznt.zzb(str)) {
                                                boolZza3 = zzab.zza(str, next.zzc());
                                            } else {
                                                this.zzh.zzj().zzu().zza("Invalid param value for number filter. event, param", this.zzh.zzi().zza(strZzg), this.zzh.zzi().zzb(strZze));
                                                break;
                                            }
                                        } else {
                                            this.zzh.zzj().zzu().zza("No filter for String param. event, param", this.zzh.zzi().zza(strZzg), this.zzh.zzi().zzb(strZze));
                                            break;
                                        }
                                        if (boolZza3 != null) {
                                            break;
                                        }
                                        if (boolZza3.booleanValue() == z2) {
                                            bool = Boolean.FALSE;
                                            break;
                                        }
                                    }
                                } else {
                                    bool = Boolean.TRUE;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        this.zzh.zzj().zzp().zza("Event filter result", bool == null ? BuildConfig.TRAVIS : bool);
        if (bool == null) {
            return false;
        }
        Boolean bool2 = Boolean.TRUE;
        this.zzc = bool2;
        if (!bool.booleanValue()) {
            return true;
        }
        this.zzd = bool2;
        if (b2 != false && zzeVar.zzk()) {
            Long lValueOf2 = Long.valueOf(zzeVar.zzd());
            if (this.zzg.zzi()) {
                if (b != false && this.zzg.zzk()) {
                    lValueOf2 = l;
                }
                this.zzf = lValueOf2;
            } else {
                if (b != false && this.zzg.zzk()) {
                    lValueOf2 = l2;
                }
                this.zze = lValueOf2;
            }
        }
        return true;
    }
}
