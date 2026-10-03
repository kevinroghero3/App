package com.google.android.gms.internal.auth;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import libcore.io.Memory;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes4.dex */
final class zzhj {
    static final boolean zza;
    private static final Unsafe zzb;
    private static final Class zzc;
    private static final boolean zzd;
    private static final zzhi zze;
    private static final boolean zzf;
    private static final boolean zzg;

    /* JADX WARN: Code duplicated, block: B:20:0x0061  */
    /* JADX WARN: Code duplicated, block: B:9:0x002d  */
    static {
        zzhi zzhgVar;
        boolean z;
        boolean z2;
        zzhi zzhiVar;
        Unsafe unsafeZzg = zzg();
        zzb = unsafeZzg;
        int i = zzds.zza;
        zzc = Memory.class;
        Class<?> cls = Long.TYPE;
        boolean zZzs = zzs(cls);
        zzd = zZzs;
        boolean zZzs2 = zzs(Integer.TYPE);
        if (unsafeZzg == null) {
            zzhgVar = null;
        } else if (zZzs) {
            zzhgVar = new zzhh(unsafeZzg);
        } else if (zZzs2) {
            zzhgVar = new zzhg(unsafeZzg);
        } else {
            zzhgVar = null;
        }
        zze = zzhgVar;
        if (zzhgVar == null) {
            z = false;
        } else {
            try {
                Class<?> cls2 = zzhgVar.zza.getClass();
                cls2.getMethod("objectFieldOffset", Field.class);
                cls2.getMethod("getLong", Object.class, cls);
                if (zzy() == null) {
                    z = false;
                } else {
                    z = true;
                }
            } catch (Throwable th) {
                zzh(th);
            }
        }
        zzf = z;
        zzhi zzhiVar2 = zze;
        if (zzhiVar2 == null) {
            z2 = false;
        } else {
            try {
                Class<?> cls3 = zzhiVar2.zza.getClass();
                cls3.getMethod("objectFieldOffset", Field.class);
                cls3.getMethod("arrayBaseOffset", Class.class);
                cls3.getMethod("arrayIndexScale", Class.class);
                Class<?> cls4 = Long.TYPE;
                cls3.getMethod("getInt", Object.class, cls4);
                cls3.getMethod("putInt", Object.class, cls4, Integer.TYPE);
                cls3.getMethod("getLong", Object.class, cls4);
                cls3.getMethod("putLong", Object.class, cls4, cls4);
                cls3.getMethod("getObject", Object.class, cls4);
                cls3.getMethod("putObject", Object.class, cls4, Object.class);
                z2 = true;
            } catch (Throwable th2) {
                zzh(th2);
                z2 = false;
            }
        }
        zzg = z2;
        zzw(byte[].class);
        zzw(boolean[].class);
        zzx(boolean[].class);
        zzw(int[].class);
        zzx(int[].class);
        zzw(long[].class);
        zzx(long[].class);
        zzw(float[].class);
        zzx(float[].class);
        zzw(double[].class);
        zzx(double[].class);
        zzw(Object[].class);
        zzx(Object[].class);
        Field fieldZzy = zzy();
        if (fieldZzy != null && (zzhiVar = zze) != null) {
            zzhiVar.zza.objectFieldOffset(fieldZzy);
        }
        zza = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    private zzhj() {
    }

    static double zza(Object obj, long j) {
        return zze.zza(obj, j);
    }

    static float zzb(Object obj, long j) {
        return zze.zzb(obj, j);
    }

    static int zzc(Object obj, long j) {
        return zze.zza.getInt(obj, j);
    }

    static long zzd(Object obj, long j) {
        return zze.zza.getLong(obj, j);
    }

    static Object zze(Class cls) {
        try {
            return zzb.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    static Object zzf(Object obj, long j) {
        return zze.zza.getObject(obj, j);
    }

    static Unsafe zzg() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzhf());
        } catch (Throwable unused) {
            return null;
        }
    }

    static /* synthetic */ void zzh(Throwable th) {
        Logger.getLogger(zzhj.class.getName()).logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(th.toString()));
    }

    static /* synthetic */ void zzi(Object obj, long j, boolean z) {
        zzhi zzhiVar = zze;
        long j2 = (-4) & j;
        int i = zzhiVar.zza.getInt(obj, j2);
        int i2 = ((~((int) j)) & 3) << 3;
        zzhiVar.zza.putInt(obj, j2, ((~(255 << i2)) & i) | ((z ? 1 : 0) << i2));
    }

    static /* synthetic */ void zzj(Object obj, long j, boolean z) {
        zzhi zzhiVar = zze;
        long j2 = (-4) & j;
        int i = zzhiVar.zza.getInt(obj, j2);
        int i2 = (((int) j) & 3) << 3;
        zzhiVar.zza.putInt(obj, j2, ((~(255 << i2)) & i) | ((z ? 1 : 0) << i2));
    }

    static void zzk(Object obj, long j, boolean z) {
        zze.zzc(obj, j, z);
    }

    static void zzl(Object obj, long j, double d) {
        zze.zzd(obj, j, d);
    }

    static void zzm(Object obj, long j, float f) {
        zze.zze(obj, j, f);
    }

    static void zzn(Object obj, long j, int i) {
        zze.zza.putInt(obj, j, i);
    }

    static void zzo(Object obj, long j, long j2) {
        zze.zza.putLong(obj, j, j2);
    }

    static void zzp(Object obj, long j, Object obj2) {
        zze.zza.putObject(obj, j, obj2);
    }

    static /* synthetic */ boolean zzq(Object obj, long j) {
        return ((byte) ((zze.zza.getInt(obj, (-4) & j) >>> ((int) (((~j) & 3) << 3))) & 255)) != 0;
    }

    static /* synthetic */ boolean zzr(Object obj, long j) {
        return ((byte) ((zze.zza.getInt(obj, (-4) & j) >>> ((int) ((j & 3) << 3))) & 255)) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static boolean zzs(Class cls) {
        int i = zzds.zza;
        try {
            Class cls2 = zzc;
            Class cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    static boolean zzt(Object obj, long j) {
        return zze.zzf(obj, j);
    }

    static boolean zzu() {
        return zzg;
    }

    static boolean zzv() {
        return zzf;
    }

    private static int zzw(Class cls) {
        if (zzg) {
            return zze.zza.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int zzx(Class cls) {
        if (zzg) {
            return zze.zza.arrayIndexScale(cls);
        }
        return -1;
    }

    private static Field zzy() {
        int i = zzds.zza;
        Field fieldZzz = zzz(Buffer.class, "effectiveDirectAddress");
        if (fieldZzz != null) {
            return fieldZzz;
        }
        Field fieldZzz2 = zzz(Buffer.class, "address");
        if (fieldZzz2 == null || fieldZzz2.getType() != Long.TYPE) {
            return null;
        }
        return fieldZzz2;
    }

    private static Field zzz(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
