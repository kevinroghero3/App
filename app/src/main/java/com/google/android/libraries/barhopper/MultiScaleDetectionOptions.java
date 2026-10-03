package com.google.android.libraries.barhopper;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes5.dex */
public final class MultiScaleDetectionOptions {
    private float[] extraScales = new float[0];

    public float[] getExtraScales() {
        return this.extraScales;
    }

    public void setExtraScales(@NonNull float[] fArr) {
        this.extraScales = fArr;
    }
}
