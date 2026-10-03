package com.google.mlkit.vision.barcode;

import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.vision.barcode.internal.zzg;

/* JADX INFO: loaded from: classes3.dex */
public class BarcodeScanning {
    private BarcodeScanning() {
    }

    public static BarcodeScanner getClient() {
        return ((zzg) MlKitContext.getInstance().get(zzg.class)).zza();
    }

    public static BarcodeScanner getClient(@NonNull BarcodeScannerOptions barcodeScannerOptions) {
        Preconditions.checkNotNull(barcodeScannerOptions, "You must provide a valid BarcodeScannerOptions.");
        return ((zzg) MlKitContext.getInstance().get(zzg.class)).zzb(barcodeScannerOptions);
    }
}
