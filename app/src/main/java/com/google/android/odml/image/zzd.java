package com.google.android.odml.image;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes5.dex */
final /* synthetic */ class zzd {
    static final /* synthetic */ int[] zza;

    static {
        int[] iArr = new int[Bitmap.Config.values().length];
        zza = iArr;
        try {
            iArr[Bitmap.Config.ALPHA_8.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            zza[Bitmap.Config.ARGB_8888.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}
