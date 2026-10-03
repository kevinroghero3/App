package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewSource;

/* JADX INFO: loaded from: classes4.dex */
public final class StreetViewPanoramaOptions extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<StreetViewPanoramaOptions> CREATOR = new zzaq();
    private StreetViewPanoramaCamera zza;
    private String zzb;
    private LatLng zzc;
    private Integer zzd;
    private Boolean zze;
    private Boolean zzf;
    private Boolean zzg;
    private Boolean zzh;
    private Boolean zzi;
    private StreetViewSource zzj;

    public StreetViewPanoramaOptions() {
        Boolean bool = Boolean.TRUE;
        this.zze = bool;
        this.zzf = bool;
        this.zzg = bool;
        this.zzh = bool;
        this.zzj = StreetViewSource.DEFAULT;
    }

    public Boolean getPanningGesturesEnabled() {
        return this.zzg;
    }

    public String getPanoramaId() {
        return this.zzb;
    }

    public LatLng getPosition() {
        return this.zzc;
    }

    public Integer getRadius() {
        return this.zzd;
    }

    public StreetViewSource getSource() {
        return this.zzj;
    }

    public Boolean getStreetNamesEnabled() {
        return this.zzh;
    }

    public StreetViewPanoramaCamera getStreetViewPanoramaCamera() {
        return this.zza;
    }

    public Boolean getUseViewLifecycleInFragment() {
        return this.zzi;
    }

    public Boolean getUserNavigationEnabled() {
        return this.zze;
    }

    public Boolean getZoomGesturesEnabled() {
        return this.zzf;
    }

    public StreetViewPanoramaOptions panningGesturesEnabled(boolean z) {
        this.zzg = Boolean.valueOf(z);
        return this;
    }

    public StreetViewPanoramaOptions panoramaCamera(@Nullable StreetViewPanoramaCamera streetViewPanoramaCamera) {
        this.zza = streetViewPanoramaCamera;
        return this;
    }

    public StreetViewPanoramaOptions panoramaId(@Nullable String str) {
        this.zzb = str;
        return this;
    }

    public StreetViewPanoramaOptions position(@Nullable LatLng latLng) {
        this.zzc = latLng;
        return this;
    }

    public StreetViewPanoramaOptions position(@Nullable LatLng latLng, @NonNull StreetViewSource streetViewSource) {
        this.zzc = latLng;
        this.zzj = streetViewSource;
        return this;
    }

    public StreetViewPanoramaOptions position(@Nullable LatLng latLng, @Nullable Integer num) {
        this.zzc = latLng;
        this.zzd = num;
        return this;
    }

    public StreetViewPanoramaOptions position(@Nullable LatLng latLng, @Nullable Integer num, @NonNull StreetViewSource streetViewSource) {
        this.zzc = latLng;
        this.zzd = num;
        this.zzj = streetViewSource;
        return this;
    }

    public StreetViewPanoramaOptions streetNamesEnabled(boolean z) {
        this.zzh = Boolean.valueOf(z);
        return this;
    }

    public String toString() {
        return Objects.toStringHelper(this).add("PanoramaId", this.zzb).add("Position", this.zzc).add("Radius", this.zzd).add("Source", this.zzj).add("StreetViewPanoramaCamera", this.zza).add("UserNavigationEnabled", this.zze).add("ZoomGesturesEnabled", this.zzf).add("PanningGesturesEnabled", this.zzg).add("StreetNamesEnabled", this.zzh).add("UseViewLifecycleInFragment", this.zzi).toString();
    }

    public StreetViewPanoramaOptions useViewLifecycleInFragment(boolean z) {
        this.zzi = Boolean.valueOf(z);
        return this;
    }

    public StreetViewPanoramaOptions userNavigationEnabled(boolean z) {
        this.zze = Boolean.valueOf(z);
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, getStreetViewPanoramaCamera(), i, false);
        SafeParcelWriter.writeString(parcel, 3, getPanoramaId(), false);
        SafeParcelWriter.writeParcelable(parcel, 4, getPosition(), i, false);
        SafeParcelWriter.writeIntegerObject(parcel, 5, getRadius(), false);
        SafeParcelWriter.writeByte(parcel, 6, com.google.android.gms.maps.internal.zza.zza(this.zze));
        SafeParcelWriter.writeByte(parcel, 7, com.google.android.gms.maps.internal.zza.zza(this.zzf));
        SafeParcelWriter.writeByte(parcel, 8, com.google.android.gms.maps.internal.zza.zza(this.zzg));
        SafeParcelWriter.writeByte(parcel, 9, com.google.android.gms.maps.internal.zza.zza(this.zzh));
        SafeParcelWriter.writeByte(parcel, 10, com.google.android.gms.maps.internal.zza.zza(this.zzi));
        SafeParcelWriter.writeParcelable(parcel, 11, getSource(), i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public StreetViewPanoramaOptions zoomGesturesEnabled(boolean z) {
        this.zzf = Boolean.valueOf(z);
        return this;
    }

    StreetViewPanoramaOptions(@Nullable @SafeParcelable.Param(id = 2) StreetViewPanoramaCamera streetViewPanoramaCamera, @Nullable @SafeParcelable.Param(id = 3) String str, @Nullable @SafeParcelable.Param(id = 4) LatLng latLng, @Nullable @SafeParcelable.Param(id = 5) Integer num, @SafeParcelable.Param(id = 6) byte b, @SafeParcelable.Param(id = 7) byte b2, @SafeParcelable.Param(id = 8) byte b3, @SafeParcelable.Param(id = 9) byte b4, @SafeParcelable.Param(id = 10) byte b5, @SafeParcelable.Param(id = 11) StreetViewSource streetViewSource) {
        Boolean bool = Boolean.TRUE;
        this.zze = bool;
        this.zzf = bool;
        this.zzg = bool;
        this.zzh = bool;
        this.zzj = StreetViewSource.DEFAULT;
        this.zza = streetViewPanoramaCamera;
        this.zzc = latLng;
        this.zzd = num;
        this.zzb = str;
        this.zze = com.google.android.gms.maps.internal.zza.zzb(b);
        this.zzf = com.google.android.gms.maps.internal.zza.zzb(b2);
        this.zzg = com.google.android.gms.maps.internal.zza.zzb(b3);
        this.zzh = com.google.android.gms.maps.internal.zza.zzb(b4);
        this.zzi = com.google.android.gms.maps.internal.zza.zzb(b5);
        this.zzj = streetViewSource;
    }
}
