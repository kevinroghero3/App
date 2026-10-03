package it.aep_italia.vts.sdk.domain;

import android.os.Parcel;
import android.os.Parcelable;
import it.aep_italia.vts.sdk.domain.enums.VtsVTokenClassID;
import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes6.dex */
public class VtsValidation implements Serializable, Parcelable {
    public static final Parcelable.Creator<VtsValidation> CREATOR = new a();
    private static final long serialVersionUID = 5811008268661297596L;
    private VtsVTokenClassID classID;
    private long contractID;
    private int equipmentID;
    private Date firstValidation;
    private boolean isExpired;
    private boolean isMinutesToGoValid;
    private boolean isRidesToGoValid;
    private boolean isValidated;
    private Date lastValidation;
    private int minutesToGo;
    private int nodeID;
    private int operatorID;
    private String rideDescription;
    private int rideID;
    private int ridesToGo;
    private int stopID;

    class a implements Parcelable.Creator<VtsValidation> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public VtsValidation createFromParcel(Parcel parcel) {
            return new VtsValidation(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public VtsValidation[] newArray(int i) {
            return new VtsValidation[i];
        }
    }

    public VtsValidation() {
    }

    protected VtsValidation(Parcel parcel) {
        this.isExpired = parcel.readByte() != 0;
        this.isValidated = parcel.readByte() != 0;
        this.isMinutesToGoValid = parcel.readByte() != 0;
        this.isRidesToGoValid = parcel.readByte() != 0;
        this.minutesToGo = parcel.readInt();
        this.ridesToGo = parcel.readInt();
        long j = parcel.readLong();
        this.firstValidation = j == -1 ? null : new Date(j);
        long j2 = parcel.readLong();
        this.lastValidation = j2 == -1 ? null : new Date(j2);
        this.contractID = parcel.readLong();
        this.operatorID = parcel.readInt();
        int i = parcel.readInt();
        this.classID = i != -1 ? VtsVTokenClassID.values()[i] : null;
        this.equipmentID = parcel.readInt();
        this.nodeID = parcel.readInt();
        this.stopID = parcel.readInt();
        this.rideID = parcel.readInt();
        this.rideDescription = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getActualMinutesToGo() {
        Date expirationDate = getExpirationDate();
        if (expirationDate == null) {
            return 0;
        }
        long time = expirationDate.getTime() - new Date().getTime();
        if (time <= 0) {
            return 0;
        }
        return (int) TimeUnit.MILLISECONDS.toMinutes(time);
    }

    public VtsVTokenClassID getClassID() {
        return this.classID;
    }

    public long getContractID() {
        return this.contractID;
    }

    public int getEquipmentID() {
        return this.equipmentID;
    }

    public Date getExpirationDate() {
        Date lastValidation = getLastValidation();
        int minutesToGo = getMinutesToGo();
        if (lastValidation == null || minutesToGo == 0) {
            return null;
        }
        return new Date(lastValidation.getTime() + TimeUnit.MINUTES.toMillis(minutesToGo));
    }

    public Date getFirstValidation() {
        return this.firstValidation;
    }

    public Date getLastValidation() {
        return this.lastValidation;
    }

    public int getMinutesToGo() {
        return this.minutesToGo;
    }

    public int getNodeID() {
        return this.nodeID;
    }

    public int getOperatorID() {
        return this.operatorID;
    }

    public String getRideDescription() {
        return this.rideDescription;
    }

    public int getRideID() {
        return this.rideID;
    }

    public int getRidesToGo() {
        return this.ridesToGo;
    }

    public int getStopID() {
        return this.stopID;
    }

    public boolean isExpired() {
        return this.isExpired;
    }

    public boolean isMinutesToGoValid() {
        return this.isMinutesToGoValid;
    }

    public boolean isRidesToGoValid() {
        return this.isRidesToGoValid;
    }

    public boolean isValidated() {
        return this.isValidated;
    }

    public void setClassID(VtsVTokenClassID vtsVTokenClassID) {
        this.classID = vtsVTokenClassID;
    }

    public void setContractID(long j) {
        this.contractID = j;
    }

    public void setEquipmentID(int i) {
        this.equipmentID = i;
    }

    public void setExpired(boolean z) {
        this.isExpired = z;
    }

    public void setFirstValidation(Date date) {
        this.firstValidation = date;
    }

    public void setLastValidation(Date date) {
        this.lastValidation = date;
    }

    public void setMinutesToGo(int i) {
        this.minutesToGo = i;
    }

    public void setMinutesToGoValid(boolean z) {
        this.isMinutesToGoValid = z;
    }

    public void setNodeID(int i) {
        this.nodeID = i;
    }

    public void setOperatorID(int i) {
        this.operatorID = i;
    }

    public void setRideDescription(String str) {
        this.rideDescription = str;
    }

    public void setRideID(int i) {
        this.rideID = i;
    }

    public void setRidesToGo(int i) {
        this.ridesToGo = i;
    }

    public void setRidesToGoValid(boolean z) {
        this.isRidesToGoValid = z;
    }

    public void setStopID(int i) {
        this.stopID = i;
    }

    public void setValidated(boolean z) {
        this.isValidated = z;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.isExpired ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isValidated ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isMinutesToGoValid ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isRidesToGoValid ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.minutesToGo);
        parcel.writeInt(this.ridesToGo);
        Date date = this.firstValidation;
        parcel.writeLong(date != null ? date.getTime() : -1L);
        Date date2 = this.lastValidation;
        parcel.writeLong(date2 != null ? date2.getTime() : -1L);
        parcel.writeLong(this.contractID);
        parcel.writeInt(this.operatorID);
        VtsVTokenClassID vtsVTokenClassID = this.classID;
        parcel.writeInt(vtsVTokenClassID == null ? -1 : vtsVTokenClassID.ordinal());
        parcel.writeInt(this.equipmentID);
        parcel.writeInt(this.nodeID);
        parcel.writeInt(this.stopID);
        parcel.writeInt(this.rideID);
        parcel.writeString(this.rideDescription);
    }
}
