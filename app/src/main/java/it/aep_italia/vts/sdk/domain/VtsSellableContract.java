package it.aep_italia.vts.sdk.domain;

import android.os.Parcel;
import android.os.Parcelable;
import ch.qos.logback.core.CoreConstants;
import it.aep_italia.vts.sdk.dto.domain.VtsSellableContractDTO;
import it.aep_italia.vts.sdk.utils.StringUtils;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class VtsSellableContract implements Serializable, Parcelable {
    public static final Parcelable.Creator<VtsSellableContract> CREATOR = new a();
    private static final long serialVersionUID = 4192223409634830192L;
    public Long backImageVTID;
    public String contractDescription;
    public String contractDurationDescription;
    public String contractTypeDescription;
    public Long frontImageVTID;
    public int providerID;
    public int tariffFamilyID;
    public int tariffFamilyType;
    public int tariffID;

    class a implements Parcelable.Creator<VtsSellableContract> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public VtsSellableContract createFromParcel(Parcel parcel) {
            return new VtsSellableContract(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public VtsSellableContract[] newArray(int i) {
            return new VtsSellableContract[i];
        }
    }

    public VtsSellableContract() {
    }

    protected VtsSellableContract(Parcel parcel) {
        this.providerID = parcel.readInt();
        this.tariffID = parcel.readInt();
        this.tariffFamilyID = parcel.readInt();
        this.tariffFamilyType = parcel.readInt();
        this.contractDescription = parcel.readString();
        this.contractTypeDescription = parcel.readString();
        this.contractDurationDescription = parcel.readString();
        this.frontImageVTID = (Long) parcel.readValue(Long.class.getClassLoader());
        this.backImageVTID = (Long) parcel.readValue(Long.class.getClassLoader());
    }

    public static VtsSellableContract fromDto(VtsSellableContractDTO vtsSellableContractDTO) {
        if (vtsSellableContractDTO == null) {
            return new VtsSellableContract();
        }
        VtsSellableContract vtsSellableContract = new VtsSellableContract();
        vtsSellableContract.providerID = vtsSellableContractDTO.getProviderID();
        vtsSellableContract.contractDescription = vtsSellableContractDTO.getTariffDescription();
        vtsSellableContract.contractDurationDescription = vtsSellableContractDTO.getContractDurationDescription();
        vtsSellableContract.contractTypeDescription = vtsSellableContractDTO.getContractTypeDescription();
        vtsSellableContract.tariffID = vtsSellableContractDTO.getTariffID();
        vtsSellableContract.tariffFamilyID = vtsSellableContractDTO.getTariffFamilyID();
        vtsSellableContract.tariffFamilyType = vtsSellableContractDTO.getTariffFamilyType();
        if (!StringUtils.isBlank(vtsSellableContractDTO.getFrontImageVTID())) {
            vtsSellableContract.frontImageVTID = Long.valueOf(StringUtils.unsignedHexStringToSignedLong(vtsSellableContractDTO.getFrontImageVTID()));
        }
        if (!StringUtils.isBlank(vtsSellableContractDTO.getBackImageVTID())) {
            vtsSellableContract.backImageVTID = Long.valueOf(StringUtils.unsignedHexStringToSignedLong(vtsSellableContractDTO.getBackImageVTID()));
        }
        return vtsSellableContract;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof VtsSellableContract)) {
            VtsSellableContract vtsSellableContract = (VtsSellableContract) obj;
            if (this.providerID == vtsSellableContract.providerID && this.tariffID == vtsSellableContract.tariffID && this.tariffFamilyID == vtsSellableContract.tariffFamilyID) {
                return true;
            }
        }
        return false;
    }

    public Long getBackImageVTID() {
        return this.backImageVTID;
    }

    public String getContractDescription() {
        return this.contractDescription;
    }

    public String getContractDurationDescription() {
        return this.contractDurationDescription;
    }

    public String getContractTypeDescription() {
        return this.contractTypeDescription;
    }

    public Long getFrontImageVTID() {
        return this.frontImageVTID;
    }

    public int getProviderID() {
        return this.providerID;
    }

    public int getTariffFamilyID() {
        return this.tariffFamilyID;
    }

    public int getTariffFamilyType() {
        return this.tariffFamilyType;
    }

    public int getTariffID() {
        return this.tariffID;
    }

    public int hashCode() {
        return (((this.providerID * 31) + this.tariffID) * 31) + this.tariffFamilyID;
    }

    public void setBackImageVTID(Long l) {
        this.backImageVTID = l;
    }

    public void setContractDescription(String str) {
        this.contractDescription = str;
    }

    public void setContractDurationDescription(String str) {
        this.contractDurationDescription = str;
    }

    public void setContractTypeDescription(String str) {
        this.contractTypeDescription = str;
    }

    public void setFrontImageVTID(Long l) {
        this.frontImageVTID = l;
    }

    public void setProviderID(int i) {
        this.providerID = i;
    }

    public void setTariffFamilyID(int i) {
        this.tariffFamilyID = i;
    }

    public void setTariffFamilyType(int i) {
        this.tariffFamilyType = i;
    }

    public void setTariffID(int i) {
        this.tariffID = i;
    }

    public String toString() {
        return "VtsSellableContract{providerID=" + this.providerID + ", tariffID=" + this.tariffID + ", tariffFamilyID=" + this.tariffFamilyID + ", tariffFamilyType=" + this.tariffFamilyType + ", contractDescription='" + this.contractDescription + CoreConstants.SINGLE_QUOTE_CHAR + ", contractTypeDescription='" + this.contractTypeDescription + CoreConstants.SINGLE_QUOTE_CHAR + ", contractDurationDescription='" + this.contractDurationDescription + CoreConstants.SINGLE_QUOTE_CHAR + ", frontImageVTID=" + this.frontImageVTID + ", backImageVTID=" + this.backImageVTID + CoreConstants.CURLY_RIGHT;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.providerID);
        parcel.writeInt(this.tariffID);
        parcel.writeInt(this.tariffFamilyID);
        parcel.writeInt(this.tariffFamilyType);
        parcel.writeString(this.contractDescription);
        parcel.writeString(this.contractTypeDescription);
        parcel.writeString(this.contractDurationDescription);
        parcel.writeValue(this.frontImageVTID);
        parcel.writeValue(this.backImageVTID);
    }
}
