package it.aep_italia.vts.sdk.domain;

import android.os.Parcel;
import android.os.Parcelable;
import it.aep_italia.vts.sdk.dto.domain.VtsStopDTO;
import it.aep_italia.vts.sdk.utils.StringUtils;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class VtsStop implements Serializable, Parcelable {
    public static final Parcelable.Creator<VtsStop> CREATOR = new a();
    private int avmID;
    private String description;
    private String gpsPosition;
    private int nodeID;
    private int operatorID;
    private String shortDescription;
    private String stopCode;
    private String stopCustomerCode;
    private int stopID;

    class a implements Parcelable.Creator<VtsStop> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public VtsStop createFromParcel(Parcel parcel) {
            return new VtsStop(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public VtsStop[] newArray(int i) {
            return new VtsStop[i];
        }
    }

    public VtsStop() {
    }

    protected VtsStop(Parcel parcel) {
        this.stopID = parcel.readInt();
        this.nodeID = parcel.readInt();
        this.operatorID = parcel.readInt();
        this.avmID = parcel.readInt();
        this.description = parcel.readString();
        this.shortDescription = parcel.readString();
        this.gpsPosition = parcel.readString();
    }

    public static VtsStop fromDto(VtsStopDTO vtsStopDTO) {
        if (vtsStopDTO == null) {
            return new VtsStop();
        }
        VtsStop vtsStop = new VtsStop();
        vtsStop.stopID = vtsStopDTO.getStopID().intValue();
        vtsStop.stopCode = vtsStopDTO.getStopCode();
        vtsStop.stopCustomerCode = vtsStopDTO.getStopCustomerCode();
        vtsStop.nodeID = vtsStopDTO.getNodeID().intValue();
        vtsStop.operatorID = vtsStopDTO.getOperatorID().intValue();
        vtsStop.avmID = vtsStopDTO.getAvmID().intValue();
        vtsStop.description = vtsStopDTO.getDescription();
        vtsStop.shortDescription = vtsStopDTO.getShortDescription();
        vtsStop.gpsPosition = vtsStopDTO.getGpsPosition();
        return vtsStop;
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

    public String getGpsPosition() {
        return this.gpsPosition;
    }

    public int getNodeID() {
        return this.nodeID;
    }

    public int getOperatorID() {
        return this.operatorID;
    }

    public String getShortDescription() {
        return this.shortDescription;
    }

    public String getStopCode() {
        return this.stopCode;
    }

    public String getStopCustomerCode() {
        return this.stopCustomerCode;
    }

    public int getStopID() {
        return this.stopID;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(this.stopID);
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
        parcel.writeInt(this.stopID);
        parcel.writeInt(this.nodeID);
        parcel.writeInt(this.operatorID);
        parcel.writeInt(this.avmID);
        parcel.writeString(this.description);
        parcel.writeString(this.shortDescription);
        parcel.writeString(this.gpsPosition);
    }
}
