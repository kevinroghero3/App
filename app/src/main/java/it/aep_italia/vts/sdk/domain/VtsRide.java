package it.aep_italia.vts.sdk.domain;

import android.os.Parcel;
import android.os.Parcelable;
import it.aep_italia.vts.sdk.dto.domain.VtsRideDTO;
import it.aep_italia.vts.sdk.utils.StringUtils;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class VtsRide implements Serializable, Parcelable {
    public static final Parcelable.Creator<VtsRide> CREATOR = new a();
    private int avmID;
    private String description;
    private int operatorID;
    private String rideCode;
    private int rideID;
    private String shortDescription;

    class a implements Parcelable.Creator<VtsRide> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public VtsRide createFromParcel(Parcel parcel) {
            return new VtsRide(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public VtsRide[] newArray(int i) {
            return new VtsRide[i];
        }
    }

    public VtsRide() {
    }

    protected VtsRide(Parcel parcel) {
        this.rideID = parcel.readInt();
        this.rideCode = parcel.readString();
        this.operatorID = parcel.readInt();
        this.avmID = parcel.readInt();
        this.description = parcel.readString();
        this.shortDescription = parcel.readString();
    }

    public static VtsRide fromDto(VtsRideDTO vtsRideDTO) {
        if (vtsRideDTO == null) {
            return new VtsRide();
        }
        VtsRide vtsRide = new VtsRide();
        vtsRide.rideID = vtsRideDTO.getRideID().intValue();
        vtsRide.rideCode = vtsRideDTO.getRideCode();
        vtsRide.operatorID = vtsRideDTO.getOperatorID().intValue();
        if (!StringUtils.isBlank(vtsRideDTO.getAvmID())) {
            try {
                vtsRide.avmID = Integer.parseInt(vtsRideDTO.getAvmID());
            } catch (Exception unused) {
            }
        }
        vtsRide.description = vtsRideDTO.getDescription();
        vtsRide.shortDescription = vtsRideDTO.getShortDescription();
        return vtsRide;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAvmID() {
        return this.avmID;
    }

    public String getDescription() {
        return this.description;
    }

    public int getOperatorID() {
        return this.operatorID;
    }

    public String getRideCode() {
        return this.rideCode;
    }

    public int getRideID() {
        return this.rideID;
    }

    public String getShortDescription() {
        return this.shortDescription;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(this.rideCode);
        if (StringUtils.isBlank(this.description)) {
            if (!StringUtils.isBlank(this.shortDescription)) {
                sb.append(" - ");
                str = this.shortDescription;
            }
            return sb.toString();
        }
        sb.append(" - ");
        str = this.description;
        sb.append(str);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.rideID);
        parcel.writeString(this.rideCode);
        parcel.writeInt(this.operatorID);
        parcel.writeInt(this.avmID);
        parcel.writeString(this.description);
        parcel.writeString(this.shortDescription);
    }
}
