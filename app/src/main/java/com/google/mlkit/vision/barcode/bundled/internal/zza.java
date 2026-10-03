package com.google.mlkit.vision.barcode.bundled.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Point;
import android.media.Image;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzam;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzan;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzao;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzap;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzaq;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzar;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzas;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzat;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzau;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzav;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzaw;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzax;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzay;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzba;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzbc;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzbe;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzbm;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcc;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzci;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzck;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzco;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf;
import com.google.android.libraries.barhopper.BarhopperV3;
import com.google.android.libraries.barhopper.MultiScaleDecodingOptions;
import com.google.android.libraries.barhopper.MultiScaleDetectionOptions;
import com.google.android.libraries.barhopper.RecognitionOptions;
import com.google.barhopper.deeplearning.BarhopperV3Options;
import com.google.barhopper.deeplearning.zzab;
import com.google.barhopper.deeplearning.zzac;
import com.google.barhopper.deeplearning.zze;
import com.google.barhopper.deeplearning.zzf;
import com.google.barhopper.deeplearning.zzh;
import com.google.barhopper.deeplearning.zzi;
import com.google.barhopper.deeplearning.zzk;
import com.google.mlkit.vision.common.internal.ImageUtils;
import com.google.photos.vision.barhopper.BarhopperProto$BarhopperResponse;
import com.google.photos.vision.barhopper.zzae;
import com.google.photos.vision.barhopper.zzaf;
import com.google.photos.vision.barhopper.zzah;
import com.google.photos.vision.barhopper.zzak;
import com.google.photos.vision.barhopper.zzb;
import com.google.photos.vision.barhopper.zzc;
import com.google.photos.vision.barhopper.zzl;
import com.google.photos.vision.barhopper.zzn;
import com.google.photos.vision.barhopper.zzp;
import com.google.photos.vision.barhopper.zzr;
import com.google.photos.vision.barhopper.zzv;
import com.google.photos.vision.barhopper.zzz;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes5.dex */
final class zza extends zzbm {
    private static final int[] zza = {5, 7, 7, 7, 5, 5};
    private static final double[][] zzb;
    private final Context zzc;
    private final zzba zzd;
    private BarhopperV3 zze;

    static {
        double[] dArr = new double[2];
        // fill-array-data instruction
        dArr[0] = 0.5d;
        dArr[1] = 1.0d;
        zzb = new double[][]{new double[]{0.075d, 1.0d}, new double[]{0.1d, 1.0d}, new double[]{0.125d, 1.0d}, new double[]{0.2d, 2.0d}, new double[]{0.2d, 0.5d}, new double[]{0.15d, 1.0d}, new double[]{0.2d, 1.0d}, new double[]{0.25d, 1.0d}, new double[]{0.35d, 2.0d}, new double[]{0.35d, 0.5d}, new double[]{0.35d, 3.0d}, new double[]{0.35d, 0.3333d}, new double[]{0.3d, 1.0d}, new double[]{0.4d, 1.0d}, dArr, new double[]{0.5d, 2.0d}, new double[]{0.5d, 0.5d}, new double[]{0.5d, 3.0d}, new double[]{0.5d, 0.3333d}, new double[]{0.6d, 1.0d}, new double[]{0.8d, 1.0d}, new double[]{1.0d, 1.0d}, new double[]{0.65d, 2.0d}, new double[]{0.65d, 0.5d}, new double[]{0.65d, 3.0d}, new double[]{0.65d, 0.3333d}, new double[]{1.0d, 1.0d}, new double[]{0.8d, 2.0d}, new double[]{0.8d, 0.5d}, new double[]{0.8d, 3.0d}, new double[]{0.8d, 0.3333d}, new double[]{1.0d, 1.0d}, new double[]{0.95d, 2.0d}, new double[]{0.95d, 0.5d}, new double[]{0.95d, 3.0d}, new double[]{0.95d, 0.3333d}};
    }

    zza(Context context, zzba zzbaVar) {
        this.zzc = context;
        this.zzd = zzbaVar;
    }

    private final RecognitionOptions zzg() {
        RecognitionOptions recognitionOptions = new RecognitionOptions();
        recognitionOptions.setBarcodeFormats(this.zzd.zza());
        recognitionOptions.setOutputUnrecognizedBarcodes(this.zzd.zzb());
        recognitionOptions.setEnableQrAlignmentGrid(true);
        recognitionOptions.setEnableUseKeypointAsFinderPattern(true);
        return recognitionOptions;
    }

    private static zzan zzh(@Nullable zzl zzlVar, @Nullable String str, String str2) {
        if (zzlVar == null || str == null) {
            return null;
        }
        Matcher matcher = Pattern.compile(str2).matcher(str);
        return new zzan(zzlVar.zzf(), zzlVar.zzd(), zzlVar.zza(), zzlVar.zzb(), zzlVar.zzc(), zzlVar.zze(), zzlVar.zzj(), matcher.find() ? matcher.group(1) : null);
    }

    private final BarhopperProto$BarhopperResponse zzi(ByteBuffer byteBuffer, zzcc zzccVar, RecognitionOptions recognitionOptions) {
        BarhopperV3 barhopperV3 = (BarhopperV3) Preconditions.checkNotNull(this.zze);
        if (((ByteBuffer) Preconditions.checkNotNull(byteBuffer)).isDirect()) {
            return barhopperV3.recognize(zzccVar.zzd(), zzccVar.zza(), byteBuffer, recognitionOptions);
        }
        if (byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0) {
            return barhopperV3.recognize(zzccVar.zzd(), zzccVar.zza(), byteBuffer.array(), recognitionOptions);
        }
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr);
        return barhopperV3.recognize(zzccVar.zzd(), zzccVar.zza(), bArr, recognitionOptions);
    }

    private final List zzj(IObjectWrapper iObjectWrapper, zzcc zzccVar, RecognitionOptions recognitionOptions) {
        BarhopperProto$BarhopperResponse barhopperProto$BarhopperResponseRecognize;
        zzar zzarVar;
        zzau zzauVar;
        zzav zzavVar;
        zzax zzaxVar;
        zzaw zzawVar;
        zzas zzasVar;
        zzao zzaoVar;
        zzap zzapVar;
        zzaq zzaqVar;
        int i;
        Point[] pointArr;
        int i2;
        int i3;
        zzau[] zzauVarArr;
        zzar[] zzarVarArr;
        zzam[] zzamVarArr;
        int iZzb = zzccVar.zzb();
        if (iZzb == -1) {
            barhopperProto$BarhopperResponseRecognize = ((BarhopperV3) Preconditions.checkNotNull(this.zze)).recognize((Bitmap) ObjectWrapper.unwrap(iObjectWrapper), recognitionOptions);
        } else if (iZzb == 17) {
            barhopperProto$BarhopperResponseRecognize = zzi((ByteBuffer) ObjectWrapper.unwrap(iObjectWrapper), zzccVar, recognitionOptions);
        } else if (iZzb != 35) {
            if (iZzb != 842094169) {
                throw new IllegalArgumentException("Unsupported image format: " + zzccVar.zzb());
            }
            barhopperProto$BarhopperResponseRecognize = zzi((ByteBuffer) ObjectWrapper.unwrap(iObjectWrapper), zzccVar, recognitionOptions);
        } else {
            barhopperProto$BarhopperResponseRecognize = zzi(((Image) Preconditions.checkNotNull((Image) ObjectWrapper.unwrap(iObjectWrapper))).getPlanes()[0].getBuffer(), zzccVar, recognitionOptions);
        }
        ArrayList arrayList = new ArrayList();
        Matrix uprightRotationMatrix = ImageUtils.getInstance().getUprightRotationMatrix(zzccVar.zzd(), zzccVar.zza(), zzccVar.zzc());
        for (zzc zzcVar : barhopperProto$BarhopperResponseRecognize.zzc()) {
            int i4 = 1;
            if (zzcVar.zza() > 0 && uprightRotationMatrix != null) {
                float[] fArr = new float[8];
                List listZzo = zzcVar.zzo();
                int iZza = zzcVar.zza();
                for (int i5 = 0; i5 < iZza; i5++) {
                    int i6 = i5 + i5;
                    fArr[i6] = ((zzaf) listZzo.get(i5)).zza();
                    fArr[i6 + 1] = ((zzaf) listZzo.get(i5)).zzb();
                }
                uprightRotationMatrix.mapPoints(fArr);
                int iZzc = zzccVar.zzc();
                for (int i7 = 0; i7 < iZza; i7++) {
                    zzb zzbVar = (zzb) zzcVar.zzH();
                    int i8 = i7 + i7;
                    zzae zzaeVarZzc = zzaf.zzc();
                    zzaeVarZzc.zza((int) fArr[i8]);
                    zzaeVarZzc.zzb((int) fArr[i8 + 1]);
                    zzbVar.zza((i7 + iZzc) % iZza, (zzaf) zzaeVarZzc.zzj());
                    zzcVar = (zzc) zzbVar.zzj();
                }
            }
            if (zzcVar.zzt()) {
                zzv zzvVarZzh = zzcVar.zzh();
                zzarVar = new zzar(zzvVarZzh.zzf() - 1, zzvVarZzh.zzc(), zzvVarZzh.zze(), zzvVarZzh.zzd());
            } else {
                zzarVar = null;
            }
            if (zzcVar.zzv()) {
                zzco zzcoVarZzb = zzcVar.zzb();
                zzauVar = new zzau(zzcoVarZzb.zzd() - 1, zzcoVarZzb.zzc());
            } else {
                zzauVar = null;
            }
            if (zzcVar.zzw()) {
                zzah zzahVarZzj = zzcVar.zzj();
                zzavVar = new zzav(zzahVarZzj.zzc(), zzahVarZzj.zzd());
            } else {
                zzavVar = null;
            }
            if (zzcVar.zzy()) {
                com.google.photos.vision.barhopper.zzao zzaoVarZzl = zzcVar.zzl();
                zzaxVar = new zzax(zzaoVarZzl.zzd(), zzaoVarZzl.zzc(), zzaoVarZzl.zze() - 1);
            } else {
                zzaxVar = null;
            }
            if (zzcVar.zzx()) {
                zzak zzakVarZzk = zzcVar.zzk();
                zzawVar = new zzaw(zzakVarZzk.zzc(), zzakVarZzk.zzd());
            } else {
                zzawVar = null;
            }
            if (zzcVar.zzu()) {
                zzz zzzVarZzi = zzcVar.zzi();
                zzasVar = new zzas(zzzVarZzi.zza(), zzzVarZzi.zzb());
            } else {
                zzasVar = null;
            }
            if (zzcVar.zzq()) {
                zzn zznVarZzd = zzcVar.zzd();
                zzaoVar = new zzao(zznVarZzd.zzj(), zznVarZzd.zze(), zznVarZzd.zzf(), zznVarZzd.zzh(), zznVarZzd.zzi(), zzh(zznVarZzd.zzb(), zzcVar.zzm().zzn() ? zzcVar.zzm().zzt() : null, "DTSTART:([0-9TZ]*)"), zzh(zznVarZzd.zza(), zzcVar.zzm().zzn() ? zzcVar.zzm().zzt() : null, "DTEND:([0-9TZ]*)"));
            } else {
                zzaoVar = null;
            }
            if (zzcVar.zzr()) {
                zzp zzpVarZze = zzcVar.zze();
                zzck zzckVarZza = zzpVarZze.zza();
                zzat zzatVar = zzckVarZza != null ? new zzat(zzckVarZza.zzd(), zzckVarZza.zzi(), zzckVarZza.zzh(), zzckVarZza.zzc(), zzckVarZza.zzf(), zzckVarZza.zze(), zzckVarZza.zzj()) : null;
                String strZzd = zzpVarZze.zzd();
                String strZze = zzpVarZze.zze();
                List listZzi = zzpVarZze.zzi();
                if (listZzi.isEmpty()) {
                    zzauVarArr = null;
                } else {
                    zzau[] zzauVarArr2 = new zzau[listZzi.size()];
                    for (int i9 = 0; i9 < listZzi.size(); i9++) {
                        zzauVarArr2[i9] = new zzau(((zzco) listZzi.get(i9)).zzd() - 1, ((zzco) listZzi.get(i9)).zzc());
                    }
                    zzauVarArr = zzauVarArr2;
                }
                List listZzh = zzpVarZze.zzh();
                if (listZzh.isEmpty()) {
                    zzarVarArr = null;
                } else {
                    zzar[] zzarVarArr2 = new zzar[listZzh.size()];
                    int i10 = 0;
                    while (i10 < listZzh.size()) {
                        zzarVarArr2[i10] = new zzar(((zzv) listZzh.get(i10)).zzf() - i4, ((zzv) listZzh.get(i10)).zzc(), ((zzv) listZzh.get(i10)).zze(), ((zzv) listZzh.get(i10)).zzd());
                        i10++;
                        i4 = 1;
                    }
                    zzarVarArr = zzarVarArr2;
                }
                String[] strArr = (String[]) zzpVarZze.zzj().toArray(new String[0]);
                List listZzf = zzpVarZze.zzf();
                if (listZzf.isEmpty()) {
                    zzamVarArr = null;
                } else {
                    zzam[] zzamVarArr2 = new zzam[listZzf.size()];
                    for (int i11 = 0; i11 < listZzf.size(); i11++) {
                        zzamVarArr2[i11] = new zzam(((zzci) listZzf.get(i11)).zzc() - 1, (String[]) ((zzci) listZzf.get(i11)).zzb().toArray(new String[0]));
                    }
                    zzamVarArr = zzamVarArr2;
                }
                zzapVar = new zzap(zzatVar, strZzd, strZze, zzauVarArr, zzarVarArr, strArr, zzamVarArr);
            } else {
                zzapVar = null;
            }
            if (zzcVar.zzs()) {
                zzr zzrVarZzf = zzcVar.zzf();
                zzaqVar = new zzaq(zzrVarZzf.zzi(), zzrVarZzf.zzk(), zzrVarZzf.zzq(), zzrVarZzf.zzo(), zzrVarZzf.zzl(), zzrVarZzf.zze(), zzrVarZzf.zzc(), zzrVarZzf.zzd(), zzrVarZzf.zzf(), zzrVarZzf.zzp(), zzrVarZzf.zzm(), zzrVarZzf.zzj(), zzrVarZzf.zzh(), zzrVarZzf.zzn());
            } else {
                zzaqVar = null;
            }
            int i12 = 4;
            switch (zzcVar.zzz() - 1) {
                case 0:
                    i = 0;
                    break;
                case 1:
                    i = 1;
                    break;
                case 2:
                    i = 2;
                    break;
                case 3:
                    i = 4;
                    break;
                case 4:
                    i = 8;
                    break;
                case 5:
                    i = 16;
                    break;
                case 6:
                    i = 32;
                    break;
                case 7:
                    i = 64;
                    break;
                case 8:
                    i = 128;
                    break;
                case 9:
                    i = 256;
                    break;
                case 10:
                    i = 512;
                    break;
                case 11:
                    i = 1024;
                    break;
                case 12:
                    i = 2048;
                    break;
                case 13:
                    i = 4096;
                    break;
                default:
                    i = -1;
                    break;
            }
            String strZzn = zzcVar.zzn();
            String strZzt = zzcVar.zzm().zzn() ? zzcVar.zzm().zzt() : null;
            byte[] bArrZzw = zzcVar.zzm().zzw();
            List listZzo2 = zzcVar.zzo();
            if (listZzo2.isEmpty()) {
                pointArr = null;
            } else {
                Point[] pointArr2 = new Point[listZzo2.size()];
                for (int i13 = 0; i13 < listZzo2.size(); i13++) {
                    pointArr2[i13] = new Point(((zzaf) listZzo2.get(i13)).zza(), ((zzaf) listZzo2.get(i13)).zzb());
                }
                pointArr = pointArr2;
            }
            switch (zzcVar.zzA() - 1) {
                case 1:
                    i2 = 1;
                    continue;
                    arrayList.add(new zzay(i, strZzn, strZzt, bArrZzw, pointArr, i2, zzarVar, zzauVar, zzavVar, zzaxVar, zzawVar, zzasVar, zzaoVar, zzapVar, zzaqVar));
                    break;
                case 2:
                    i2 = 2;
                    continue;
                    arrayList.add(new zzay(i, strZzn, strZzt, bArrZzw, pointArr, i2, zzarVar, zzauVar, zzavVar, zzaxVar, zzawVar, zzasVar, zzaoVar, zzapVar, zzaqVar));
                    break;
                case 3:
                    i3 = 3;
                    break;
                case 4:
                    i2 = i12;
                    continue;
                    arrayList.add(new zzay(i, strZzn, strZzt, bArrZzw, pointArr, i2, zzarVar, zzauVar, zzavVar, zzaxVar, zzawVar, zzasVar, zzaoVar, zzapVar, zzaqVar));
                    break;
                case 5:
                    i3 = 5;
                    break;
                case 6:
                    i3 = 6;
                    break;
                case 7:
                    i3 = 7;
                    break;
                case 8:
                    i2 = 8;
                    continue;
                    arrayList.add(new zzay(i, strZzn, strZzt, bArrZzw, pointArr, i2, zzarVar, zzauVar, zzavVar, zzaxVar, zzawVar, zzasVar, zzaoVar, zzapVar, zzaqVar));
                    break;
                case 9:
                    i3 = 9;
                    break;
                case 10:
                    i3 = 10;
                    break;
                case 11:
                    i3 = 11;
                    break;
                case 12:
                    i3 = 12;
                    break;
                default:
                    i2 = 0;
                    continue;
                    arrayList.add(new zzay(i, strZzn, strZzt, bArrZzw, pointArr, i2, zzarVar, zzauVar, zzavVar, zzaxVar, zzawVar, zzasVar, zzaoVar, zzapVar, zzaqVar));
                    break;
            }
            i12 = i3;
            i2 = i12;
            continue;
            arrayList.add(new zzay(i, strZzn, strZzt, bArrZzw, pointArr, i2, zzarVar, zzauVar, zzavVar, zzaxVar, zzawVar, zzasVar, zzaoVar, zzapVar, zzaqVar));
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzbn
    public final List zzb(IObjectWrapper iObjectWrapper, zzcc zzccVar) {
        return zzj(iObjectWrapper, zzccVar, zzg());
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzbn
    public final List zzc(IObjectWrapper iObjectWrapper, zzcc zzccVar, zzbc zzbcVar) {
        RecognitionOptions recognitionOptionsZzg = zzg();
        MultiScaleDecodingOptions multiScaleDecodingOptions = new MultiScaleDecodingOptions();
        multiScaleDecodingOptions.setExtraScales(zzbcVar.zza().zzc());
        multiScaleDecodingOptions.setMinimumDetectedDimension(zzbcVar.zza().zza());
        multiScaleDecodingOptions.setSkipProcessingIfBarcodeFound(zzbcVar.zza().zzb());
        recognitionOptionsZzg.setMultiScaleDecodingOptions(multiScaleDecodingOptions);
        MultiScaleDetectionOptions multiScaleDetectionOptions = new MultiScaleDetectionOptions();
        multiScaleDetectionOptions.setExtraScales(zzbcVar.zza().zzc());
        recognitionOptionsZzg.setMultiScaleDetectionOptions(multiScaleDetectionOptions);
        recognitionOptionsZzg.setQrEnableFourthCornerApproximation(zzbcVar.zzb());
        return zzj(iObjectWrapper, zzccVar, recognitionOptionsZzg);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzbn
    public final void zzd() {
        if (this.zze != null) {
            return;
        }
        this.zze = new BarhopperV3();
        zzh zzhVarZza = zzi.zza();
        zze zzeVarZza = zzf.zza();
        int i = 16;
        int i2 = 0;
        for (int i3 = 0; i3 < 6; i3++) {
            com.google.barhopper.deeplearning.zzb zzbVarZza = com.google.barhopper.deeplearning.zzc.zza();
            zzbVarZza.zzc(i);
            zzbVarZza.zzd(i);
            for (int i4 = 0; i4 < zza[i3]; i4++) {
                double[] dArr = zzb[i2];
                double d = dArr[0];
                float fSqrt = (float) Math.sqrt(dArr[1]);
                float f = (float) (d * 320.0d);
                zzbVarZza.zza(f / fSqrt);
                zzbVarZza.zzb(f * fSqrt);
                i2++;
            }
            i += i;
            zzeVarZza.zza(zzbVarZza);
        }
        zzhVarZza.zza(zzeVarZza);
        try {
            InputStream inputStreamOpen = this.zzc.getAssets().open("mlkit_barcode_models/barcode_ssd_mobilenet_v1_dmp25_quant.tflite");
            try {
                InputStream inputStreamOpen2 = this.zzc.getAssets().open("mlkit_barcode_models/oned_auto_regressor_mobile.tflite");
                try {
                    InputStream inputStreamOpen3 = this.zzc.getAssets().open("mlkit_barcode_models/oned_feature_extractor_mobile.tflite");
                    try {
                        BarhopperV3 barhopperV3 = (BarhopperV3) Preconditions.checkNotNull(this.zze);
                        zzk zzkVarZza = BarhopperV3Options.zza();
                        zzhVarZza.zzb(zzdf.zzs(inputStreamOpen));
                        zzkVarZza.zza(zzhVarZza);
                        zzab zzabVarZza = zzac.zza();
                        zzabVarZza.zza(zzdf.zzs(inputStreamOpen2));
                        zzabVarZza.zzb(zzdf.zzs(inputStreamOpen3));
                        zzkVarZza.zzb(zzabVarZza);
                        barhopperV3.create(zzkVarZza.zzj());
                        if (inputStreamOpen3 != null) {
                            inputStreamOpen3.close();
                        }
                        if (inputStreamOpen2 != null) {
                            inputStreamOpen2.close();
                        }
                        if (inputStreamOpen != null) {
                            inputStreamOpen.close();
                        }
                    } catch (Throwable th) {
                        if (inputStreamOpen3 != null) {
                            try {
                                inputStreamOpen3.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    if (inputStreamOpen2 != null) {
                        try {
                            inputStreamOpen2.close();
                        } catch (Throwable th4) {
                            th3.addSuppressed(th4);
                        }
                    }
                    throw th3;
                }
            } catch (Throwable th5) {
                if (inputStreamOpen != null) {
                    try {
                        inputStreamOpen.close();
                    } catch (Throwable th6) {
                        th5.addSuppressed(th6);
                    }
                }
                throw th5;
            }
        } catch (IOException e) {
            throw new IllegalStateException("Failed to open Barcode models", e);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzbn
    public final void zze(zzbe zzbeVar) {
        zzd();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzbn
    public final void zzf() {
        BarhopperV3 barhopperV3 = this.zze;
        if (barhopperV3 != null) {
            barhopperV3.close();
            this.zze = null;
        }
    }
}
