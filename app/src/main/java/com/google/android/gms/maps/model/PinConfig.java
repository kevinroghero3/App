package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public class PinConfig extends AbstractSafeParcelable {
    public static final int BITMAP_LENGTH_DP = 37;
    public static final int BITMAP_WIDTH_DP = 26;
    public static final Parcelable.Creator<PinConfig> CREATOR = new zzo();
    public static final int DEFAULT_PIN_BACKGROUND_COLOR = -1424587;
    public static final int DEFAULT_PIN_BORDER_COLOR = -3857889;
    public static final int DEFAULT_PIN_GLYPH_COLOR = -5041134;
    private final int zza;
    private final int zzb;
    private final Glyph zzc;

    public static class Builder {
        private int zza = PinConfig.DEFAULT_PIN_BACKGROUND_COLOR;
        private int zzb = PinConfig.DEFAULT_PIN_BORDER_COLOR;
        private Glyph zzc = new Glyph(PinConfig.DEFAULT_PIN_GLYPH_COLOR);

        public PinConfig build() {
            return new PinConfig(this.zza, this.zzb, this.zzc);
        }

        public Builder setBackgroundColor(@ColorInt int i) {
            this.zza = i;
            return this;
        }

        public Builder setBorderColor(@ColorInt int i) {
            this.zzb = i;
            return this;
        }

        public Builder setGlyph(@NonNull Glyph glyph) {
            this.zzc = glyph;
            return this;
        }
    }

    public static class Glyph extends AbstractSafeParcelable {
        public static final Parcelable.Creator<Glyph> CREATOR = new zzf();
        public static final float DEFAULT_CIRCLE_RADIUS_DP = 5.0f;
        public static final float X_COORDINATE_DP = 13.0f;
        public static final float Y_COORDINATE_DP = 13.0f;
        private String zza;
        private BitmapDescriptor zzb;
        private int zzc;
        private int zzd;

        public Glyph(@ColorInt int i) {
            this.zzd = ViewCompat.MEASURED_STATE_MASK;
            this.zzc = i;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Glyph)) {
                return false;
            }
            Glyph glyph = (Glyph) obj;
            if (this.zzc != glyph.zzc || !zzn.zza(this.zza, glyph.zza) || this.zzd != glyph.zzd) {
                return false;
            }
            BitmapDescriptor bitmapDescriptor = this.zzb;
            if ((bitmapDescriptor == null && glyph.zzb != null) || (bitmapDescriptor != null && glyph.zzb == null)) {
                return false;
            }
            BitmapDescriptor bitmapDescriptor2 = glyph.zzb;
            if (bitmapDescriptor == null || bitmapDescriptor2 == null) {
                return true;
            }
            return zzn.zza(ObjectWrapper.unwrap(bitmapDescriptor.zza()), ObjectWrapper.unwrap(bitmapDescriptor2.zza()));
        }

        public BitmapDescriptor getBitmapDescriptor() {
            return this.zzb;
        }

        public int getGlyphColor() {
            return this.zzc;
        }

        public String getText() {
            return this.zza;
        }

        public int getTextColor() {
            return this.zzd;
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{this.zza, this.zzb, Integer.valueOf(this.zzc)});
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i) {
            int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeString(parcel, 2, getText(), false);
            BitmapDescriptor bitmapDescriptor = this.zzb;
            SafeParcelWriter.writeIBinder(parcel, 3, bitmapDescriptor == null ? null : bitmapDescriptor.zza().asBinder(), false);
            SafeParcelWriter.writeInt(parcel, 4, getGlyphColor());
            SafeParcelWriter.writeInt(parcel, 5, getTextColor());
            SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
        }

        public Glyph(@Nullable BitmapDescriptor bitmapDescriptor) {
            this.zzc = PinConfig.DEFAULT_PIN_GLYPH_COLOR;
            this.zzd = ViewCompat.MEASURED_STATE_MASK;
            this.zzb = bitmapDescriptor;
        }

        public Glyph(@NonNull String str) {
            this(str, ViewCompat.MEASURED_STATE_MASK);
        }

        public Glyph(@NonNull String str, @ColorInt int i) {
            this.zzc = PinConfig.DEFAULT_PIN_GLYPH_COLOR;
            this.zza = str;
            this.zzd = i;
        }

        Glyph(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) IBinder iBinder, @SafeParcelable.Param(id = 4) int i, @SafeParcelable.Param(id = 5) int i2) {
            this.zzc = PinConfig.DEFAULT_PIN_GLYPH_COLOR;
            this.zzd = ViewCompat.MEASURED_STATE_MASK;
            this.zza = str;
            this.zzb = iBinder == null ? null : new BitmapDescriptor(IObjectWrapper.Stub.asInterface(iBinder));
            this.zzc = i;
            this.zzd = i2;
        }
    }

    PinConfig(@SafeParcelable.Param(id = 2) @ColorInt int i, @SafeParcelable.Param(id = 3) @ColorInt int i2, @SafeParcelable.Param(id = 4) Glyph glyph) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = glyph;
    }

    public static Builder builder() {
        return new Builder();
    }

    public int getBackgroundColor() {
        return this.zza;
    }

    public int getBorderColor() {
        return this.zzb;
    }

    public Glyph getGlyph() {
        return this.zzc;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, getBackgroundColor());
        SafeParcelWriter.writeInt(parcel, 3, getBorderColor());
        SafeParcelWriter.writeParcelable(parcel, 4, getGlyph(), i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
