package com.google.android.libraries.barhopper;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes5.dex */
public final class MultiScaleDecodingOptions {
    private float[] extraScales = new float[0];
    private int minimumDetectedDimension = 10;
    private boolean skipProcessingIfBarcodeFound = true;

    public float[] getExtraScales() {
        return this.extraScales;
    }

    public int getMinimumDetectedDimension() {
        return this.minimumDetectedDimension;
    }

    public boolean getSkipProcessingIfBarcodeFound() {
        return this.skipProcessingIfBarcodeFound;
    }

    public void setExtraScales(@NonNull float[] fArr) {
        this.extraScales = fArr;
    }

    public void setMinimumDetectedDimension(int i) {
        this.minimumDetectedDimension = i;
    }

    public void setSkipProcessingIfBarcodeFound(boolean z) {
        this.skipProcessingIfBarcodeFound = z;
    }
}
