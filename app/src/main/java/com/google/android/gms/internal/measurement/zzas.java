package com.google.android.gms.internal.measurement;

import ch.qos.logback.core.pattern.parser.Parser;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes4.dex */
public final class zzas implements zzaq, Iterable<zzaq> {
    private final String zza;

    public final int hashCode() {
        return this.zza.hashCode();
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0159  */
    /* JADX WARN: Code duplicated, block: B:102:0x015f  */
    /* JADX WARN: Code duplicated, block: B:105:0x0169  */
    /* JADX WARN: Code duplicated, block: B:106:0x016f  */
    /* JADX WARN: Code duplicated, block: B:108:0x0179  */
    /* JADX WARN: Code duplicated, block: B:109:0x017c  */
    /* JADX WARN: Code duplicated, block: B:110:0x0180  */
    /* JADX WARN: Code duplicated, block: B:113:0x018d  */
    /* JADX WARN: Code duplicated, block: B:114:0x0193 A[PHI: r3 r6 r7
  0x0193: PHI (r3v83 java.lang.String) = (r3v2 java.lang.String), (r3v3 java.lang.String), (r3v84 java.lang.String) binds: [B:111:0x018a, B:108:0x0179, B:44:0x00c1] A[DONT_GENERATE, DONT_INLINE]
  0x0193: PHI (r6v44 java.lang.String) = (r6v4 java.lang.String), (r6v5 java.lang.String), (r6v45 java.lang.String) binds: [B:111:0x018a, B:108:0x0179, B:44:0x00c1] A[DONT_GENERATE, DONT_INLINE]
  0x0193: PHI (r7v14 java.lang.String) = (r7v1 java.lang.String), (r7v2 java.lang.String), (r7v15 java.lang.String) binds: [B:111:0x018a, B:108:0x0179, B:44:0x00c1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:116:0x019b  */
    /* JADX WARN: Code duplicated, block: B:118:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:120:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:121:0x01be  */
    /* JADX WARN: Code duplicated, block: B:124:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:125:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:128:0x0200  */
    /* JADX WARN: Code duplicated, block: B:130:0x0216  */
    /* JADX WARN: Code duplicated, block: B:132:0x022c  */
    /* JADX WARN: Code duplicated, block: B:135:0x023e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:136:0x023f  */
    /* JADX WARN: Code duplicated, block: B:138:0x0243  */
    /* JADX WARN: Code duplicated, block: B:139:0x0269  */
    /* JADX WARN: Code duplicated, block: B:142:0x0293  */
    /* JADX WARN: Code duplicated, block: B:144:0x02a5  */
    /* JADX WARN: Code duplicated, block: B:145:0x02be  */
    /* JADX WARN: Code duplicated, block: B:148:0x02c6  */
    /* JADX WARN: Code duplicated, block: B:149:0x02de  */
    /* JADX WARN: Code duplicated, block: B:152:0x030d  */
    /* JADX WARN: Code duplicated, block: B:154:0x031f  */
    /* JADX WARN: Code duplicated, block: B:156:0x032b  */
    /* JADX WARN: Code duplicated, block: B:158:0x0337  */
    /* JADX WARN: Code duplicated, block: B:159:0x033c  */
    /* JADX WARN: Code duplicated, block: B:161:0x0351  */
    /* JADX WARN: Code duplicated, block: B:162:0x0368  */
    /* JADX WARN: Code duplicated, block: B:165:0x0371  */
    /* JADX WARN: Code duplicated, block: B:167:0x0377  */
    /* JADX WARN: Code duplicated, block: B:174:0x03a0  */
    /* JADX WARN: Code duplicated, block: B:177:0x03a7  */
    /* JADX WARN: Code duplicated, block: B:179:0x03ab A[LOOP:0: B:178:0x03a9->B:179:0x03ab, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:182:0x03be  */
    /* JADX WARN: Code duplicated, block: B:184:0x03d0  */
    /* JADX WARN: Code duplicated, block: B:185:0x03e4  */
    /* JADX WARN: Code duplicated, block: B:188:0x03f0  */
    /* JADX WARN: Code duplicated, block: B:189:0x03fb  */
    /* JADX WARN: Code duplicated, block: B:192:0x040c  */
    /* JADX WARN: Code duplicated, block: B:193:0x041f  */
    /* JADX WARN: Code duplicated, block: B:196:0x042e  */
    /* JADX WARN: Code duplicated, block: B:197:0x0439  */
    /* JADX WARN: Code duplicated, block: B:200:0x0454  */
    /* JADX WARN: Code duplicated, block: B:202:0x0466  */
    /* JADX WARN: Code duplicated, block: B:203:0x0469  */
    /* JADX WARN: Code duplicated, block: B:206:0x0486  */
    /* JADX WARN: Code duplicated, block: B:208:0x049b  */
    /* JADX WARN: Code duplicated, block: B:210:0x049e  */
    /* JADX WARN: Code duplicated, block: B:212:0x04b2  */
    /* JADX WARN: Code duplicated, block: B:214:0x04c8  */
    /* JADX WARN: Code duplicated, block: B:216:0x04da  */
    /* JADX WARN: Code duplicated, block: B:217:0x04e1  */
    /* JADX WARN: Code duplicated, block: B:220:0x04f7  */
    /* JADX WARN: Code duplicated, block: B:221:0x04fa  */
    /* JADX WARN: Code duplicated, block: B:224:0x0513  */
    /* JADX WARN: Code duplicated, block: B:225:0x0516  */
    /* JADX WARN: Code duplicated, block: B:228:0x052a  */
    /* JADX WARN: Code duplicated, block: B:230:0x053e  */
    /* JADX WARN: Code duplicated, block: B:232:0x054f  */
    /* JADX WARN: Code duplicated, block: B:233:0x055e  */
    /* JADX WARN: Code duplicated, block: B:236:0x0574  */
    /* JADX WARN: Code duplicated, block: B:238:0x0583  */
    /* JADX WARN: Code duplicated, block: B:240:0x058f  */
    /* JADX WARN: Code duplicated, block: B:242:0x05a7  */
    /* JADX WARN: Code duplicated, block: B:244:0x05b3 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:245:0x05b4  */
    /* JADX WARN: Code duplicated, block: B:248:0x05c2 A[LOOP:1: B:246:0x05bc->B:248:0x05c2, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:251:0x05e0  */
    /* JADX WARN: Code duplicated, block: B:253:0x05f0  */
    /* JADX WARN: Code duplicated, block: B:254:0x0609  */
    /* JADX WARN: Code duplicated, block: B:264:0x0626  */
    /* JADX WARN: Code duplicated, block: B:266:0x063b  */
    /* JADX WARN: Code duplicated, block: B:268:0x0644  */
    /* JADX WARN: Code duplicated, block: B:270:0x0669  */
    /* JADX WARN: Code duplicated, block: B:272:0x066c  */
    /* JADX WARN: Code duplicated, block: B:285:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:286:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:287:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:288:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:289:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:290:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:291:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:292:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:293:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:294:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:295:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:296:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:297:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:43:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:44:0x00c1 A[PHI: r6
  0x00c1: PHI (r6v45 java.lang.String) = 
  (r6v6 java.lang.String)
  (r6v7 java.lang.String)
  (r6v8 java.lang.String)
  (r6v9 java.lang.String)
  (r6v10 java.lang.String)
  (r6v11 java.lang.String)
  (r6v12 java.lang.String)
  (r6v13 java.lang.String)
  (r6v14 java.lang.String)
  (r6v15 java.lang.String)
  (r6v16 java.lang.String)
  (r6v17 java.lang.String)
  (r6v18 java.lang.String)
  (r6v19 java.lang.String)
  (r6v21 java.lang.String)
  (r6v46 java.lang.String)
 binds: [B:103:0x0165, B:99:0x0156, B:297:?, B:296:?, B:295:?, B:294:?, B:293:?, B:292:?, B:291:?, B:290:?, B:289:?, B:288:?, B:287:?, B:286:?, B:285:?, B:43:0x00bf] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:45:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:48:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:49:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:52:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:53:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:56:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:57:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:60:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:61:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:64:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:65:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:68:0x0104  */
    /* JADX WARN: Code duplicated, block: B:69:0x0107  */
    /* JADX WARN: Code duplicated, block: B:72:0x010e  */
    /* JADX WARN: Code duplicated, block: B:73:0x0111  */
    /* JADX WARN: Code duplicated, block: B:76:0x0118  */
    /* JADX WARN: Code duplicated, block: B:77:0x011b  */
    /* JADX WARN: Code duplicated, block: B:80:0x0122  */
    /* JADX WARN: Code duplicated, block: B:81:0x0125  */
    /* JADX WARN: Code duplicated, block: B:84:0x012c  */
    /* JADX WARN: Code duplicated, block: B:85:0x012e  */
    /* JADX WARN: Code duplicated, block: B:88:0x0135  */
    /* JADX WARN: Code duplicated, block: B:89:0x0137  */
    /* JADX WARN: Code duplicated, block: B:92:0x013e  */
    /* JADX WARN: Code duplicated, block: B:93:0x0140  */
    /* JADX WARN: Code duplicated, block: B:96:0x0148  */
    /* JADX WARN: Code duplicated, block: B:98:0x0150  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.zzaq
    public final zzaq zza(String str, zzh zzhVar, List<zzaq> list) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        byte b;
        zzaq zzaqVarZza;
        double dDoubleValue;
        int i;
        int iZza;
        StringBuilder sb;
        int i2;
        String strZzf;
        Matcher matcher;
        String strZzf2;
        double dDoubleValue2;
        double dZza;
        String strZzf3;
        String str8;
        double dDoubleValue3;
        double dZza2;
        double dMin;
        double length;
        double dZza3;
        double dMin2;
        String str9;
        ArrayList arrayList;
        String strZzf4;
        long jZzc;
        String[] strArrSplit;
        int length2;
        int i3;
        boolean zIsEmpty;
        String str10;
        int iZza2;
        int length3;
        zzaq zzaqVarZza2;
        String strZzf5;
        String str11;
        int iIndexOf;
        int i4;
        zzh zzhVar2;
        String strZzf6;
        double dDoubleValue4;
        if (!"charAt".equals(str) && !"concat".equals(str) && !"hasOwnProperty".equals(str) && !"indexOf".equals(str) && !"lastIndexOf".equals(str) && !"match".equals(str) && !Parser.REPLACE_CONVERTER_WORD.equals(str) && !"search".equals(str) && !"slice".equals(str) && !"split".equals(str) && !"substring".equals(str) && !"toLowerCase".equals(str) && !"toLocaleLowerCase".equals(str) && !InAppPurchaseConstants.METHOD_TO_STRING.equals(str) && !"toUpperCase".equals(str)) {
            str2 = "toLocaleUpperCase";
            if (!str2.equals(str)) {
                str3 = "trim";
                if (!str3.equals(str)) {
                    throw new IllegalArgumentException(String.format("%s is not a String function", str));
                }
            }
            str.hashCode();
            switch (str.hashCode()) {
                case -1789698943:
                    str4 = "charAt";
                    str5 = str7;
                    str6 = InAppPurchaseConstants.METHOD_TO_STRING;
                    if (str.equals(str5)) {
                        str7 = str5;
                        b = 0;
                    } else {
                        b = -1;
                        str7 = str5;
                    }
                    break;
                case -1776922004:
                    str4 = "charAt";
                    str6 = InAppPurchaseConstants.METHOD_TO_STRING;
                    if (str.equals(str6)) {
                        b = 1;
                    } else {
                        str5 = str7;
                        b = -1;
                        str7 = str5;
                    }
                    break;
                case -1464939364:
                    str4 = "charAt";
                    if (str.equals("toLocaleLowerCase")) {
                        str6 = InAppPurchaseConstants.METHOD_TO_STRING;
                        b = 2;
                    } else {
                        str5 = "hasOwnProperty";
                        str6 = InAppPurchaseConstants.METHOD_TO_STRING;
                        b = -1;
                        str7 = str5;
                    }
                    break;
                case -1361633751:
                    str4 = "charAt";
                    if (str.equals(str4)) {
                        str6 = InAppPurchaseConstants.METHOD_TO_STRING;
                        b = 3;
                    } else {
                        str5 = "hasOwnProperty";
                        str6 = InAppPurchaseConstants.METHOD_TO_STRING;
                        b = -1;
                        str7 = str5;
                    }
                    break;
                case -1354795244:
                    if (!str.equals("concat")) {
                        str4 = "charAt";
                        str5 = "hasOwnProperty";
                        str6 = InAppPurchaseConstants.METHOD_TO_STRING;
                        b = -1;
                        str7 = str5;
                    } else {
                        b = 4;
                        str4 = "charAt";
                        str6 = InAppPurchaseConstants.METHOD_TO_STRING;
                    }
                    break;
                case -1137582698:
                    if (!str.equals("toLowerCase")) {
                        str4 = "charAt";
                        str5 = "hasOwnProperty";
                        str6 = InAppPurchaseConstants.METHOD_TO_STRING;
                        b = -1;
                        str7 = str5;
                    } else {
                        b = 5;
                        str4 = "charAt";
                        str6 = InAppPurchaseConstants.METHOD_TO_STRING;
                    }
                    break;
                case -906336856:
                    if (!str.equals("search")) {
                        str4 = "charAt";
                        str5 = "hasOwnProperty";
                        str6 = InAppPurchaseConstants.METHOD_TO_STRING;
                        b = -1;
                        str7 = str5;
                    } else {
                        b = 6;
                        str4 = "charAt";
                        str6 = InAppPurchaseConstants.METHOD_TO_STRING;
                    }
                    break;
                case -726908483:
                    if (!str.equals(str2)) {
                        str4 = "charAt";
                        str5 = "hasOwnProperty";
                        str6 = InAppPurchaseConstants.METHOD_TO_STRING;
                        b = -1;
                        str7 = str5;
                    } else {
                        b = 7;
                        str4 = "charAt";
                        str6 = InAppPurchaseConstants.METHOD_TO_STRING;
                    }
                    break;
                case -467511597:
                    if (!str.equals("lastIndexOf")) {
                        str4 = "charAt";
                        str5 = "hasOwnProperty";
                        str6 = InAppPurchaseConstants.METHOD_TO_STRING;
                        b = -1;
                        str7 = str5;
                    } else {
                        b = 8;
                        str4 = "charAt";
                        str6 = InAppPurchaseConstants.METHOD_TO_STRING;
                    }
                    break;
                case -399551817:
                    if (!str.equals("toUpperCase")) {
                        str4 = "charAt";
                        str5 = "hasOwnProperty";
                        str6 = InAppPurchaseConstants.METHOD_TO_STRING;
                        b = -1;
                        str7 = str5;
                    } else {
                        b = 9;
                        str4 = "charAt";
                        str6 = InAppPurchaseConstants.METHOD_TO_STRING;
                    }
                    break;
                case 3568674:
                    if (!str.equals(str3)) {
                        str4 = "charAt";
                        str5 = "hasOwnProperty";
                        str6 = InAppPurchaseConstants.METHOD_TO_STRING;
                        b = -1;
                        str7 = str5;
                    } else {
                        b = 10;
                        str4 = "charAt";
                        str6 = InAppPurchaseConstants.METHOD_TO_STRING;
                    }
                    break;
                case 103668165:
                    if (!str.equals("match")) {
                        str4 = "charAt";
                        str5 = "hasOwnProperty";
                        str6 = InAppPurchaseConstants.METHOD_TO_STRING;
                        b = -1;
                        str7 = str5;
                    } else {
                        b = Ascii.VT;
                        str4 = "charAt";
                        str6 = InAppPurchaseConstants.METHOD_TO_STRING;
                    }
                    break;
                case 109526418:
                    if (!str.equals("slice")) {
                        str4 = "charAt";
                        str5 = "hasOwnProperty";
                        str6 = InAppPurchaseConstants.METHOD_TO_STRING;
                        b = -1;
                        str7 = str5;
                    } else {
                        b = Ascii.FF;
                        str4 = "charAt";
                        str6 = InAppPurchaseConstants.METHOD_TO_STRING;
                    }
                    break;
                case 109648666:
                    if (!str.equals("split")) {
                        str4 = "charAt";
                        str5 = "hasOwnProperty";
                        str6 = InAppPurchaseConstants.METHOD_TO_STRING;
                        b = -1;
                        str7 = str5;
                    } else {
                        b = Ascii.CR;
                        str4 = "charAt";
                        str6 = InAppPurchaseConstants.METHOD_TO_STRING;
                    }
                    break;
                case 530542161:
                    if (!str.equals("substring")) {
                        str4 = "charAt";
                        str5 = "hasOwnProperty";
                        str6 = InAppPurchaseConstants.METHOD_TO_STRING;
                        b = -1;
                        str7 = str5;
                    } else {
                        b = Ascii.SO;
                        str4 = "charAt";
                        str6 = InAppPurchaseConstants.METHOD_TO_STRING;
                    }
                    break;
                case 1094496948:
                    if (!str.equals(Parser.REPLACE_CONVERTER_WORD)) {
                        str4 = "charAt";
                        str5 = "hasOwnProperty";
                        str6 = InAppPurchaseConstants.METHOD_TO_STRING;
                        b = -1;
                        str7 = str5;
                    } else {
                        b = Ascii.SI;
                        str4 = "charAt";
                        str6 = InAppPurchaseConstants.METHOD_TO_STRING;
                    }
                    break;
                case 1943291465:
                    if (!str.equals("indexOf")) {
                        str4 = "charAt";
                        str5 = "hasOwnProperty";
                        str6 = InAppPurchaseConstants.METHOD_TO_STRING;
                        b = -1;
                        str7 = str5;
                    } else {
                        b = Ascii.DLE;
                        str4 = "charAt";
                        str6 = InAppPurchaseConstants.METHOD_TO_STRING;
                    }
                    break;
                default:
                    str4 = "charAt";
                    str5 = "hasOwnProperty";
                    str6 = InAppPurchaseConstants.METHOD_TO_STRING;
                    b = -1;
                    str7 = str5;
                    break;
            }
            switch (b) {
                case 0:
                    zzg.zza(str7, 1, list);
                    String str12 = this.zza;
                    zzaqVarZza = zzhVar.zza(list.get(0));
                    if ("length".equals(zzaqVarZza.zzf())) {
                        return zzaq.zzh;
                    }
                    dDoubleValue = zzaqVarZza.zze().doubleValue();
                    if (dDoubleValue != Math.floor(dDoubleValue) && (i = (int) dDoubleValue) >= 0 && i < str12.length()) {
                        return zzaq.zzh;
                    }
                    return zzaq.zzi;
                case 1:
                    zzg.zza(str6, 0, list);
                    return this;
                case 2:
                    zzg.zza("toLocaleLowerCase", 0, list);
                    return new zzas(this.zza.toLowerCase());
                case 3:
                    zzg.zzc(str4, 1, list);
                    if (list.isEmpty()) {
                        iZza = 0;
                    } else {
                        iZza = (int) zzg.zza(zzhVar.zza(list.get(0)).zze().doubleValue());
                    }
                    String str13 = this.zza;
                    if (iZza >= 0 || iZza >= str13.length()) {
                        return zzaq.zzj;
                    }
                    return new zzas(String.valueOf(str13.charAt(iZza)));
                case 4:
                    if (list.isEmpty()) {
                        return this;
                    }
                    sb = new StringBuilder(this.zza);
                    for (i2 = 0; i2 < list.size(); i2++) {
                        sb.append(zzhVar.zza(list.get(i2)).zzf());
                    }
                    return new zzas(sb.toString());
                case 5:
                    zzg.zza("toLowerCase", 0, list);
                    return new zzas(this.zza.toLowerCase(Locale.ENGLISH));
                case 6:
                    zzg.zzc("search", 1, list);
                    if (!list.isEmpty()) {
                        strZzf = zzhVar.zza(list.get(0)).zzf();
                    } else {
                        strZzf = zzaq.zzc.zzf();
                    }
                    matcher = Pattern.compile(strZzf).matcher(this.zza);
                    if (matcher.find()) {
                        return new zzai(Double.valueOf(matcher.start()));
                    }
                    return new zzai(Double.valueOf(-1.0d));
                case 7:
                    zzg.zza(str2, 0, list);
                    return new zzas(this.zza.toUpperCase());
                case 8:
                    zzg.zzc("lastIndexOf", 2, list);
                    String str14 = this.zza;
                    if (list.size() <= 0) {
                        strZzf2 = zzaq.zzc.zzf();
                    } else {
                        strZzf2 = zzhVar.zza(list.get(0)).zzf();
                    }
                    if (list.size() < 2) {
                        dDoubleValue2 = Double.NaN;
                    } else {
                        dDoubleValue2 = zzhVar.zza(list.get(1)).zze().doubleValue();
                    }
                    if (Double.isNaN(dDoubleValue2)) {
                        dZza = Double.POSITIVE_INFINITY;
                    } else {
                        dZza = zzg.zza(dDoubleValue2);
                    }
                    return new zzai(Double.valueOf(str14.lastIndexOf(strZzf2, (int) dZza)));
                case 9:
                    zzg.zza("toUpperCase", 0, list);
                    return new zzas(this.zza.toUpperCase(Locale.ENGLISH));
                case 10:
                    zzg.zza("toUpperCase", 0, list);
                    return new zzas(this.zza.trim());
                case 11:
                    zzg.zzc("match", 1, list);
                    String str15 = this.zza;
                    if (list.size() <= 0) {
                        strZzf3 = "";
                    } else {
                        strZzf3 = zzhVar.zza(list.get(0)).zzf();
                    }
                    Matcher matcher2 = Pattern.compile(strZzf3).matcher(str15);
                    return matcher2.find() ? new zzaf(new zzas(matcher2.group())) : zzaq.zzd;
                case 12:
                    zzg.zzc("slice", 2, list);
                    str8 = this.zza;
                    if (list.isEmpty()) {
                        dDoubleValue3 = 0.0d;
                    } else {
                        dDoubleValue3 = zzhVar.zza(list.get(0)).zze().doubleValue();
                    }
                    dZza2 = zzg.zza(dDoubleValue3);
                    if (dZza2 < 0.0d) {
                        dMin = Math.max(((double) str8.length()) + dZza2, 0.0d);
                    } else {
                        dMin = Math.min(dZza2, str8.length());
                    }
                    int i5 = (int) dMin;
                    if (list.size() > 1) {
                        length = zzhVar.zza(list.get(1)).zze().doubleValue();
                    } else {
                        length = str8.length();
                    }
                    dZza3 = zzg.zza(length);
                    if (dZza3 < 0.0d) {
                        dMin2 = Math.max(((double) str8.length()) + dZza3, 0.0d);
                    } else {
                        dMin2 = Math.min(dZza3, str8.length());
                    }
                    return new zzas(str8.substring(i5, Math.max(0, ((int) dMin2) - i5) + i5));
                case 13:
                    zzg.zzc("split", 2, list);
                    str9 = this.zza;
                    if (str9.length() == 0) {
                        return new zzaf(this);
                    }
                    arrayList = new ArrayList();
                    if (list.isEmpty()) {
                        arrayList.add(this);
                    } else {
                        strZzf4 = zzhVar.zza(list.get(0)).zzf();
                        if (list.size() > 1) {
                            jZzc = zzg.zzc(zzhVar.zza(list.get(1)).zze().doubleValue());
                        } else {
                            jZzc = 2147483647L;
                        }
                        if (jZzc == 0) {
                            return new zzaf();
                        }
                        strArrSplit = str9.split(Pattern.quote(strZzf4), ((int) jZzc) + 1);
                        length2 = strArrSplit.length;
                        if (strZzf4.isEmpty() || strArrSplit.length <= 0) {
                            i3 = 0;
                        } else {
                            zIsEmpty = strArrSplit[0].isEmpty();
                            if (strArrSplit[strArrSplit.length - 1].isEmpty()) {
                                i3 = zIsEmpty;
                                length2 = strArrSplit.length - 1;
                                i3 = zIsEmpty;
                            }
                        }
                        i3 = zIsEmpty;
                        if (strArrSplit.length > jZzc) {
                            length2--;
                        }
                        while (i3 < length2) {
                            arrayList.add(new zzas(strArrSplit[i3]));
                            i3++;
                        }
                    }
                    return new zzaf(arrayList);
                case 14:
                    zzg.zzc("substring", 2, list);
                    str10 = this.zza;
                    if (list.isEmpty()) {
                        iZza2 = 0;
                    } else {
                        iZza2 = (int) zzg.zza(zzhVar.zza(list.get(0)).zze().doubleValue());
                    }
                    if (list.size() > 1) {
                        length3 = (int) zzg.zza(zzhVar.zza(list.get(1)).zze().doubleValue());
                    } else {
                        length3 = str10.length();
                    }
                    int iMin = Math.min(Math.max(iZza2, 0), str10.length());
                    int iMin2 = Math.min(Math.max(length3, 0), str10.length());
                    return new zzas(str10.substring(Math.min(iMin, iMin2), Math.max(iMin, iMin2)));
                case 15:
                    zzg.zzc(Parser.REPLACE_CONVERTER_WORD, 2, list);
                    zzaqVarZza2 = zzaq.zzc;
                    strZzf5 = zzaqVarZza2.zzf();
                    if (!list.isEmpty()) {
                        strZzf5 = zzhVar.zza(list.get(0)).zzf();
                        if (list.size() > 1) {
                            zzaqVarZza2 = zzhVar.zza(list.get(1));
                        }
                    }
                    str11 = this.zza;
                    iIndexOf = str11.indexOf(strZzf5);
                    if (iIndexOf < 0) {
                        return this;
                    }
                    if (zzaqVarZza2 instanceof zzal) {
                        i4 = 0;
                        zzaqVarZza2 = ((zzal) zzaqVarZza2).zza(zzhVar, Arrays.asList(new zzas(strZzf5), new zzai(Double.valueOf(iIndexOf)), this));
                    } else {
                        i4 = 0;
                    }
                    return new zzas(str11.substring(i4, iIndexOf) + zzaqVarZza2.zzf() + str11.substring(iIndexOf + strZzf5.length()));
                case 16:
                    zzg.zzc("indexOf", 2, list);
                    String str16 = this.zza;
                    if (list.size() <= 0) {
                        strZzf6 = zzaq.zzc.zzf();
                        zzhVar2 = zzhVar;
                    } else {
                        zzhVar2 = zzhVar;
                        strZzf6 = zzhVar2.zza(list.get(0)).zzf();
                    }
                    if (list.size() < 2) {
                        dDoubleValue4 = 0.0d;
                    } else {
                        dDoubleValue4 = zzhVar2.zza(list.get(1)).zze().doubleValue();
                    }
                    return new zzai(Double.valueOf(str16.indexOf(strZzf6, (int) zzg.zza(dDoubleValue4))));
                default:
                    throw new IllegalArgumentException("Command not supported");
            }
        }
        str2 = "toLocaleUpperCase";
        str3 = "trim";
        str.hashCode();
        switch (str.hashCode()) {
            case -1789698943:
                str4 = "charAt";
                str5 = str7;
                str6 = InAppPurchaseConstants.METHOD_TO_STRING;
                if (str.equals(str5)) {
                    b = -1;
                    str7 = str5;
                } else {
                    str7 = str5;
                    b = 0;
                }
                break;
            case -1776922004:
                str4 = "charAt";
                str6 = InAppPurchaseConstants.METHOD_TO_STRING;
                if (str.equals(str6)) {
                    str5 = str7;
                    b = -1;
                    str7 = str5;
                } else {
                    b = 1;
                }
                break;
            case -1464939364:
                str4 = "charAt";
                if (str.equals("toLocaleLowerCase")) {
                    str5 = "hasOwnProperty";
                    str6 = InAppPurchaseConstants.METHOD_TO_STRING;
                    b = -1;
                    str7 = str5;
                } else {
                    str6 = InAppPurchaseConstants.METHOD_TO_STRING;
                    b = 2;
                }
                break;
            case -1361633751:
                str4 = "charAt";
                if (str.equals(str4)) {
                    str5 = "hasOwnProperty";
                    str6 = InAppPurchaseConstants.METHOD_TO_STRING;
                    b = -1;
                    str7 = str5;
                } else {
                    str6 = InAppPurchaseConstants.METHOD_TO_STRING;
                    b = 3;
                }
                break;
            case -1354795244:
                if (!str.equals("concat")) {
                    str4 = "charAt";
                    str5 = "hasOwnProperty";
                    str6 = InAppPurchaseConstants.METHOD_TO_STRING;
                    b = -1;
                    str7 = str5;
                } else {
                    b = 4;
                    str4 = "charAt";
                    str6 = InAppPurchaseConstants.METHOD_TO_STRING;
                }
                break;
            case -1137582698:
                if (!str.equals("toLowerCase")) {
                    str4 = "charAt";
                    str5 = "hasOwnProperty";
                    str6 = InAppPurchaseConstants.METHOD_TO_STRING;
                    b = -1;
                    str7 = str5;
                } else {
                    b = 5;
                    str4 = "charAt";
                    str6 = InAppPurchaseConstants.METHOD_TO_STRING;
                }
                break;
            case -906336856:
                if (!str.equals("search")) {
                    str4 = "charAt";
                    str5 = "hasOwnProperty";
                    str6 = InAppPurchaseConstants.METHOD_TO_STRING;
                    b = -1;
                    str7 = str5;
                } else {
                    b = 6;
                    str4 = "charAt";
                    str6 = InAppPurchaseConstants.METHOD_TO_STRING;
                }
                break;
            case -726908483:
                if (!str.equals(str2)) {
                    str4 = "charAt";
                    str5 = "hasOwnProperty";
                    str6 = InAppPurchaseConstants.METHOD_TO_STRING;
                    b = -1;
                    str7 = str5;
                } else {
                    b = 7;
                    str4 = "charAt";
                    str6 = InAppPurchaseConstants.METHOD_TO_STRING;
                }
                break;
            case -467511597:
                if (!str.equals("lastIndexOf")) {
                    str4 = "charAt";
                    str5 = "hasOwnProperty";
                    str6 = InAppPurchaseConstants.METHOD_TO_STRING;
                    b = -1;
                    str7 = str5;
                } else {
                    b = 8;
                    str4 = "charAt";
                    str6 = InAppPurchaseConstants.METHOD_TO_STRING;
                }
                break;
            case -399551817:
                if (!str.equals("toUpperCase")) {
                    str4 = "charAt";
                    str5 = "hasOwnProperty";
                    str6 = InAppPurchaseConstants.METHOD_TO_STRING;
                    b = -1;
                    str7 = str5;
                } else {
                    b = 9;
                    str4 = "charAt";
                    str6 = InAppPurchaseConstants.METHOD_TO_STRING;
                }
                break;
            case 3568674:
                if (!str.equals(str3)) {
                    str4 = "charAt";
                    str5 = "hasOwnProperty";
                    str6 = InAppPurchaseConstants.METHOD_TO_STRING;
                    b = -1;
                    str7 = str5;
                } else {
                    b = 10;
                    str4 = "charAt";
                    str6 = InAppPurchaseConstants.METHOD_TO_STRING;
                }
                break;
            case 103668165:
                if (!str.equals("match")) {
                    str4 = "charAt";
                    str5 = "hasOwnProperty";
                    str6 = InAppPurchaseConstants.METHOD_TO_STRING;
                    b = -1;
                    str7 = str5;
                } else {
                    b = Ascii.VT;
                    str4 = "charAt";
                    str6 = InAppPurchaseConstants.METHOD_TO_STRING;
                }
                break;
            case 109526418:
                if (!str.equals("slice")) {
                    str4 = "charAt";
                    str5 = "hasOwnProperty";
                    str6 = InAppPurchaseConstants.METHOD_TO_STRING;
                    b = -1;
                    str7 = str5;
                } else {
                    b = Ascii.FF;
                    str4 = "charAt";
                    str6 = InAppPurchaseConstants.METHOD_TO_STRING;
                }
                break;
            case 109648666:
                if (!str.equals("split")) {
                    str4 = "charAt";
                    str5 = "hasOwnProperty";
                    str6 = InAppPurchaseConstants.METHOD_TO_STRING;
                    b = -1;
                    str7 = str5;
                } else {
                    b = Ascii.CR;
                    str4 = "charAt";
                    str6 = InAppPurchaseConstants.METHOD_TO_STRING;
                }
                break;
            case 530542161:
                if (!str.equals("substring")) {
                    str4 = "charAt";
                    str5 = "hasOwnProperty";
                    str6 = InAppPurchaseConstants.METHOD_TO_STRING;
                    b = -1;
                    str7 = str5;
                } else {
                    b = Ascii.SO;
                    str4 = "charAt";
                    str6 = InAppPurchaseConstants.METHOD_TO_STRING;
                }
                break;
            case 1094496948:
                if (!str.equals(Parser.REPLACE_CONVERTER_WORD)) {
                    str4 = "charAt";
                    str5 = "hasOwnProperty";
                    str6 = InAppPurchaseConstants.METHOD_TO_STRING;
                    b = -1;
                    str7 = str5;
                } else {
                    b = Ascii.SI;
                    str4 = "charAt";
                    str6 = InAppPurchaseConstants.METHOD_TO_STRING;
                }
                break;
            case 1943291465:
                if (!str.equals("indexOf")) {
                    str4 = "charAt";
                    str5 = "hasOwnProperty";
                    str6 = InAppPurchaseConstants.METHOD_TO_STRING;
                    b = -1;
                    str7 = str5;
                } else {
                    b = Ascii.DLE;
                    str4 = "charAt";
                    str6 = InAppPurchaseConstants.METHOD_TO_STRING;
                }
                break;
            default:
                str4 = "charAt";
                str5 = "hasOwnProperty";
                str6 = InAppPurchaseConstants.METHOD_TO_STRING;
                b = -1;
                str7 = str5;
                break;
        }
        switch (b) {
            case 0:
                zzg.zza(str7, 1, list);
                String str17 = this.zza;
                zzaqVarZza = zzhVar.zza(list.get(0));
                if ("length".equals(zzaqVarZza.zzf())) {
                    return zzaq.zzh;
                }
                dDoubleValue = zzaqVarZza.zze().doubleValue();
                if (dDoubleValue != Math.floor(dDoubleValue)) {
                    break;
                }
                return zzaq.zzi;
            case 1:
                zzg.zza(str6, 0, list);
                return this;
            case 2:
                zzg.zza("toLocaleLowerCase", 0, list);
                return new zzas(this.zza.toLowerCase());
            case 3:
                zzg.zzc(str4, 1, list);
                if (list.isEmpty()) {
                    iZza = (int) zzg.zza(zzhVar.zza(list.get(0)).zze().doubleValue());
                } else {
                    iZza = 0;
                }
                String str18 = this.zza;
                if (iZza >= 0) {
                    break;
                }
                return zzaq.zzj;
            case 4:
                if (list.isEmpty()) {
                    return this;
                }
                sb = new StringBuilder(this.zza);
                while (i2 < list.size()) {
                    sb.append(zzhVar.zza(list.get(i2)).zzf());
                }
                return new zzas(sb.toString());
            case 5:
                zzg.zza("toLowerCase", 0, list);
                return new zzas(this.zza.toLowerCase(Locale.ENGLISH));
            case 6:
                zzg.zzc("search", 1, list);
                if (!list.isEmpty()) {
                    strZzf = zzhVar.zza(list.get(0)).zzf();
                } else {
                    strZzf = zzaq.zzc.zzf();
                }
                matcher = Pattern.compile(strZzf).matcher(this.zza);
                if (matcher.find()) {
                    return new zzai(Double.valueOf(matcher.start()));
                }
                return new zzai(Double.valueOf(-1.0d));
            case 7:
                zzg.zza(str2, 0, list);
                return new zzas(this.zza.toUpperCase());
            case 8:
                zzg.zzc("lastIndexOf", 2, list);
                String str19 = this.zza;
                if (list.size() <= 0) {
                    strZzf2 = zzaq.zzc.zzf();
                } else {
                    strZzf2 = zzhVar.zza(list.get(0)).zzf();
                }
                if (list.size() < 2) {
                    dDoubleValue2 = Double.NaN;
                } else {
                    dDoubleValue2 = zzhVar.zza(list.get(1)).zze().doubleValue();
                }
                if (Double.isNaN(dDoubleValue2)) {
                    dZza = Double.POSITIVE_INFINITY;
                } else {
                    dZza = zzg.zza(dDoubleValue2);
                }
                return new zzai(Double.valueOf(str19.lastIndexOf(strZzf2, (int) dZza)));
            case 9:
                zzg.zza("toUpperCase", 0, list);
                return new zzas(this.zza.toUpperCase(Locale.ENGLISH));
            case 10:
                zzg.zza("toUpperCase", 0, list);
                return new zzas(this.zza.trim());
            case 11:
                zzg.zzc("match", 1, list);
                String str110 = this.zza;
                if (list.size() <= 0) {
                    strZzf3 = "";
                } else {
                    strZzf3 = zzhVar.zza(list.get(0)).zzf();
                }
                Matcher matcher3 = Pattern.compile(strZzf3).matcher(str110);
                if (matcher3.find()) {
                }
            case 12:
                zzg.zzc("slice", 2, list);
                str8 = this.zza;
                if (list.isEmpty()) {
                    dDoubleValue3 = zzhVar.zza(list.get(0)).zze().doubleValue();
                } else {
                    dDoubleValue3 = 0.0d;
                }
                dZza2 = zzg.zza(dDoubleValue3);
                if (dZza2 < 0.0d) {
                    dMin = Math.max(((double) str8.length()) + dZza2, 0.0d);
                } else {
                    dMin = Math.min(dZza2, str8.length());
                }
                int i6 = (int) dMin;
                if (list.size() > 1) {
                    length = zzhVar.zza(list.get(1)).zze().doubleValue();
                } else {
                    length = str8.length();
                }
                dZza3 = zzg.zza(length);
                if (dZza3 < 0.0d) {
                    dMin2 = Math.max(((double) str8.length()) + dZza3, 0.0d);
                } else {
                    dMin2 = Math.min(dZza3, str8.length());
                }
                return new zzas(str8.substring(i6, Math.max(0, ((int) dMin2) - i6) + i6));
            case 13:
                zzg.zzc("split", 2, list);
                str9 = this.zza;
                if (str9.length() == 0) {
                    return new zzaf(this);
                }
                arrayList = new ArrayList();
                if (list.isEmpty()) {
                    arrayList.add(this);
                } else {
                    strZzf4 = zzhVar.zza(list.get(0)).zzf();
                    if (list.size() > 1) {
                        jZzc = zzg.zzc(zzhVar.zza(list.get(1)).zze().doubleValue());
                    } else {
                        jZzc = 2147483647L;
                    }
                    if (jZzc == 0) {
                        return new zzaf();
                    }
                    strArrSplit = str9.split(Pattern.quote(strZzf4), ((int) jZzc) + 1);
                    length2 = strArrSplit.length;
                    if (strZzf4.isEmpty()) {
                        i3 = 0;
                    } else {
                        i3 = 0;
                    }
                    i3 = zIsEmpty;
                    if (strArrSplit.length > jZzc) {
                        length2--;
                    }
                    while (i3 < length2) {
                        arrayList.add(new zzas(strArrSplit[i3]));
                        i3++;
                    }
                }
                return new zzaf(arrayList);
            case 14:
                zzg.zzc("substring", 2, list);
                str10 = this.zza;
                if (list.isEmpty()) {
                    iZza2 = (int) zzg.zza(zzhVar.zza(list.get(0)).zze().doubleValue());
                } else {
                    iZza2 = 0;
                }
                if (list.size() > 1) {
                    length3 = (int) zzg.zza(zzhVar.zza(list.get(1)).zze().doubleValue());
                } else {
                    length3 = str10.length();
                }
                int iMin3 = Math.min(Math.max(iZza2, 0), str10.length());
                int iMin4 = Math.min(Math.max(length3, 0), str10.length());
                return new zzas(str10.substring(Math.min(iMin3, iMin4), Math.max(iMin3, iMin4)));
            case 15:
                zzg.zzc(Parser.REPLACE_CONVERTER_WORD, 2, list);
                zzaqVarZza2 = zzaq.zzc;
                strZzf5 = zzaqVarZza2.zzf();
                if (!list.isEmpty()) {
                    strZzf5 = zzhVar.zza(list.get(0)).zzf();
                    if (list.size() > 1) {
                        zzaqVarZza2 = zzhVar.zza(list.get(1));
                    }
                }
                str11 = this.zza;
                iIndexOf = str11.indexOf(strZzf5);
                if (iIndexOf < 0) {
                    return this;
                }
                if (zzaqVarZza2 instanceof zzal) {
                    i4 = 0;
                    zzaqVarZza2 = ((zzal) zzaqVarZza2).zza(zzhVar, Arrays.asList(new zzas(strZzf5), new zzai(Double.valueOf(iIndexOf)), this));
                } else {
                    i4 = 0;
                }
                return new zzas(str11.substring(i4, iIndexOf) + zzaqVarZza2.zzf() + str11.substring(iIndexOf + strZzf5.length()));
            case 16:
                zzg.zzc("indexOf", 2, list);
                String str111 = this.zza;
                if (list.size() <= 0) {
                    strZzf6 = zzaq.zzc.zzf();
                    zzhVar2 = zzhVar;
                } else {
                    zzhVar2 = zzhVar;
                    strZzf6 = zzhVar2.zza(list.get(0)).zzf();
                }
                if (list.size() < 2) {
                    dDoubleValue4 = 0.0d;
                } else {
                    dDoubleValue4 = zzhVar2.zza(list.get(1)).zze().doubleValue();
                }
                return new zzai(Double.valueOf(str111.indexOf(strZzf6, (int) zzg.zza(dDoubleValue4))));
            default:
                throw new IllegalArgumentException("Command not supported");
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzaq
    public final zzaq zzc() {
        return new zzas(this.zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzaq
    public final Boolean zzd() {
        return Boolean.valueOf(!this.zza.isEmpty());
    }

    @Override // com.google.android.gms.internal.measurement.zzaq
    public final Double zze() {
        if (this.zza.isEmpty()) {
            return Double.valueOf(0.0d);
        }
        try {
            return Double.valueOf(this.zza);
        } catch (NumberFormatException unused) {
            return Double.valueOf(Double.NaN);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzaq
    public final String zzf() {
        return this.zza;
    }

    public final String toString() {
        return "\"" + this.zza + "\"";
    }

    @Override // com.google.android.gms.internal.measurement.zzaq
    public final Iterator<zzaq> zzh() {
        return new zzav(this);
    }

    @Override // java.lang.Iterable
    public final Iterator<zzaq> iterator() {
        return new zzau(this);
    }

    public zzas(String str) {
        if (str == null) {
            throw new IllegalArgumentException("StringValue cannot be null.");
        }
        this.zza = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzas) {
            return this.zza.equals(((zzas) obj).zza);
        }
        return false;
    }
}
