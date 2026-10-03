package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Comparator;
import kotlinx.coroutines.debug.internal.DebugCoroutineInfoImplKt;

/* JADX INFO: loaded from: classes2.dex */
public class DetectedActivity extends AbstractSafeParcelable {
    public static final int IN_VEHICLE = 0;
    public static final int ON_BICYCLE = 1;
    public static final int ON_FOOT = 2;
    public static final int RUNNING = 8;
    public static final int STILL = 3;
    public static final int TILTING = 5;
    public static final int UNKNOWN = 4;
    public static final int WALKING = 7;
    int zzb;
    int zzc;
    public static final Comparator zza = new zzk();
    public static final Parcelable.Creator<DetectedActivity> CREATOR = new zzl();

    public DetectedActivity(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) int i2) {
        this.zzb = i;
        this.zzc = i2;
    }

    public final boolean equals(@Nullable Object obj) {
        if (!(obj instanceof DetectedActivity)) {
            return false;
        }
        DetectedActivity detectedActivity = (DetectedActivity) obj;
        return this.zzb == detectedActivity.zzb && this.zzc == detectedActivity.zzc;
    }

    public int getConfidence() {
        return this.zzc;
    }

    public int getType() {
        int i = this.zzb;
        if (i > 22 || i < 0) {
            return 4;
        }
        return i;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zzb), Integer.valueOf(this.zzc));
    }

    public String toString() {
        String string;
        int type = getType();
        if (type == 0) {
            string = "IN_VEHICLE";
        } else if (type == 1) {
            string = "ON_BICYCLE";
        } else if (type == 2) {
            string = "ON_FOOT";
        } else if (type == 3) {
            string = "STILL";
        } else if (type == 4) {
            string = "UNKNOWN";
        } else if (type == 5) {
            string = "TILTING";
        } else if (type == 7) {
            string = "WALKING";
        } else if (type == 8) {
            string = DebugCoroutineInfoImplKt.RUNNING;
        } else if (type != 16) {
            string = type != 17 ? Integer.toString(type) : "IN_RAIL_VEHICLE";
        } else {
            string = "IN_ROAD_VEHICLE";
        }
        return "DetectedActivity [type=" + string + ", confidence=" + this.zzc + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        Preconditions.checkNotNull(parcel);
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzb);
        SafeParcelWriter.writeInt(parcel, 2, this.zzc);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
