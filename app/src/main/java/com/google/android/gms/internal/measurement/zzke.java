package com.google.android.gms.internal.measurement;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'zzb' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes4.dex */
public final class zzke {
    public static final zzke zza;
    public static final zzke zzb;
    public static final zzke zzc;
    public static final zzke zzd;
    public static final zzke zze;
    public static final zzke zzf;
    public static final zzke zzg;
    public static final zzke zzh;
    public static final zzke zzi;
    public static final zzke zzj;
    private static final /* synthetic */ zzke[] zzk;
    private final Class<?> zzl;
    private final Class<?> zzm;
    private final Object zzn;

    public final Class<?> zza() {
        return this.zzm;
    }

    static {
        zzke zzkeVar = new zzke("VOID", 0, Void.class, Void.class, null);
        zza = zzkeVar;
        Class cls = Integer.TYPE;
        zzke zzkeVar2 = new zzke("INT", 1, cls, Integer.class, 0);
        zzb = zzkeVar2;
        zzke zzkeVar3 = new zzke("LONG", 2, Long.TYPE, Long.class, 0L);
        zzc = zzkeVar3;
        zzke zzkeVar4 = new zzke("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        zzd = zzkeVar4;
        zzke zzkeVar5 = new zzke("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0d));
        zze = zzkeVar5;
        zzke zzkeVar6 = new zzke("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        zzf = zzkeVar6;
        zzke zzkeVar7 = new zzke("STRING", 6, String.class, String.class, "");
        zzg = zzkeVar7;
        zzke zzkeVar8 = new zzke("BYTE_STRING", 7, zzih.class, zzih.class, zzih.zza);
        zzh = zzkeVar8;
        zzke zzkeVar9 = new zzke("ENUM", 8, cls, Integer.class, null);
        zzi = zzkeVar9;
        zzke zzkeVar10 = new zzke("MESSAGE", 9, Object.class, Object.class, null);
        zzj = zzkeVar10;
        zzk = new zzke[]{zzkeVar, zzkeVar2, zzkeVar3, zzkeVar4, zzkeVar5, zzkeVar6, zzkeVar7, zzkeVar8, zzkeVar9, zzkeVar10};
    }

    private zzke(String str, int i, Class cls, Class cls2, Object obj) {
        super(str, i);
        this.zzl = cls;
        this.zzm = cls2;
        this.zzn = obj;
    }

    public static zzke[] values() {
        return (zzke[]) zzk.clone();
    }
}
