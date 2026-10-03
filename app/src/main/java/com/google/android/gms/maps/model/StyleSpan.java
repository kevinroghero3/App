package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes2.dex */
public final class StyleSpan extends AbstractSafeParcelable {
    public static final Parcelable.Creator<StyleSpan> CREATOR = new zzab();
    private final StrokeStyle zza;
    private final double zzb;

    public StyleSpan(int i) {
        this.zza = StrokeStyle.colorBuilder(i).build();
        this.zzb = 1.0d;
    }

    public double getSegments() {
        return this.zzb;
    }

    public StrokeStyle getStyle() {
        return this.zza;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, getStyle(), i, false);
        SafeParcelWriter.writeDouble(parcel, 3, getSegments());
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public StyleSpan(int i, double d) {
        if (d <= 0.0d) {
            throw new IllegalArgumentException("A style must be applied to some segments on a polyline.");
        }
        this.zza = StrokeStyle.colorBuilder(i).build();
        this.zzb = d;
    }

    public StyleSpan(@NonNull StrokeStyle strokeStyle) {
        this.zza = strokeStyle;
        this.zzb = 1.0d;
    }

    public StyleSpan(@NonNull @SafeParcelable.Param(id = 2) StrokeStyle strokeStyle, @SafeParcelable.Param(id = 3) double d) {
        if (d <= 0.0d) {
            throw new IllegalArgumentException("A style must be applied to some segments on a polyline.");
        }
        this.zza = strokeStyle;
        this.zzb = d;
    }
}
