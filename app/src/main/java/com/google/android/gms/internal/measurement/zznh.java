package com.google.android.gms.internal.measurement;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'zzc' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes4.dex */
public class zznh {
    public static final zznh zza;
    public static final zznh zzb;
    public static final zznh zzc;
    public static final zznh zzd;
    public static final zznh zze;
    public static final zznh zzf;
    public static final zznh zzg;
    public static final zznh zzh;
    public static final zznh zzi;
    public static final zznh zzj;
    public static final zznh zzk;
    public static final zznh zzl;
    public static final zznh zzm;
    public static final zznh zzn;
    public static final zznh zzo;
    public static final zznh zzp;
    public static final zznh zzq;
    public static final zznh zzr;
    private static final /* synthetic */ zznh[] zzs;
    private final zznr zzt;
    private final int zzu;

    /* synthetic */ zznh(String str, int i, zznr zznrVar, int i2, zzns zznsVar) {
        this(str, i, zznrVar, i2);
    }

    public final int zza() {
        return this.zzu;
    }

    public final zznr zzb() {
        return this.zzt;
    }

    static {
        zznh zznhVar = new zznh("DOUBLE", 0, zznr.DOUBLE, 1);
        zza = zznhVar;
        zznh zznhVar2 = new zznh("FLOAT", 1, zznr.FLOAT, 5);
        zzb = zznhVar2;
        zznr zznrVar = zznr.LONG;
        zznh zznhVar3 = new zznh("INT64", 2, zznrVar, 0);
        zzc = zznhVar3;
        zznh zznhVar4 = new zznh("UINT64", 3, zznrVar, 0);
        zzd = zznhVar4;
        zznr zznrVar2 = zznr.INT;
        zznh zznhVar5 = new zznh("INT32", 4, zznrVar2, 0);
        zze = zznhVar5;
        zznh zznhVar6 = new zznh("FIXED64", 5, zznrVar, 1);
        zzf = zznhVar6;
        zznh zznhVar7 = new zznh("FIXED32", 6, zznrVar2, 5);
        zzg = zznhVar7;
        zznh zznhVar8 = new zznh("BOOL", 7, zznr.BOOLEAN, 0);
        zzh = zznhVar8;
        zznk zznkVar = new zznk("STRING", zznr.STRING);
        zzi = zznkVar;
        zznr zznrVar3 = zznr.MESSAGE;
        zznm zznmVar = new zznm("GROUP", zznrVar3);
        zzj = zznmVar;
        zzno zznoVar = new zzno("MESSAGE", zznrVar3);
        zzk = zznoVar;
        zznq zznqVar = new zznq("BYTES", zznr.BYTE_STRING);
        zzl = zznqVar;
        zznh zznhVar9 = new zznh("UINT32", 12, zznrVar2, 0);
        zzm = zznhVar9;
        zznh zznhVar10 = new zznh("ENUM", 13, zznr.ENUM, 0);
        zzn = zznhVar10;
        zznh zznhVar11 = new zznh("SFIXED32", 14, zznrVar2, 5);
        zzo = zznhVar11;
        zznh zznhVar12 = new zznh("SFIXED64", 15, zznrVar, 1);
        zzp = zznhVar12;
        zznh zznhVar13 = new zznh("SINT32", 16, zznrVar2, 0);
        zzq = zznhVar13;
        zznh zznhVar14 = new zznh("SINT64", 17, zznrVar, 0);
        zzr = zznhVar14;
        zzs = new zznh[]{zznhVar, zznhVar2, zznhVar3, zznhVar4, zznhVar5, zznhVar6, zznhVar7, zznhVar8, zznkVar, zznmVar, zznoVar, zznqVar, zznhVar9, zznhVar10, zznhVar11, zznhVar12, zznhVar13, zznhVar14};
    }

    private zznh(String str, int i, zznr zznrVar, int i2) {
        super(str, i);
        this.zzt = zznrVar;
        this.zzu = i2;
    }

    public static zznh[] values() {
        return (zznh[]) zzs.clone();
    }
}
