package it.aep_italia.vts.sdk.domain;

import android.os.Parcel;
import android.os.Parcelable;
import it.aep_italia.vts.sdk.dto.domain.VtsContractDTO;
import it.aep_italia.vts.sdk.dto.domain.token.payload.VtsVTokenPayloadContractDTO;
import it.aep_italia.vts.sdk.utils.DateUtils;
import it.aep_italia.vts.sdk.utils.StringUtils;
import java.util.Date;

/* JADX INFO: loaded from: classes6.dex */
public final class VtsContract extends VtsSellProposal {
    public static final Parcelable.Creator<VtsContract> CREATOR = new a();
    private static final long serialVersionUID = -6434011579535076627L;
    public long contractID;
    public Date sellingDate;
    public long vTokenUID;

    class a implements Parcelable.Creator<VtsContract> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public VtsContract createFromParcel(Parcel parcel) {
            return new VtsContract(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public VtsContract[] newArray(int i) {
            return new VtsContract[i];
        }
    }

    VtsContract() {
    }

    protected VtsContract(Parcel parcel) {
        super(parcel);
        this.contractID = parcel.readLong();
        this.vTokenUID = parcel.readLong();
        long j = parcel.readLong();
        this.sellingDate = j == -1 ? null : new Date(j);
    }

    public static VtsContract fromDto(VtsSellProposal vtsSellProposal, VtsContractDTO vtsContractDTO) {
        VtsContract vtsContract = new VtsContract();
        if (vtsSellProposal != null) {
            vtsContract.providerID = vtsSellProposal.getProviderID();
            vtsContract.tariffID = vtsSellProposal.getTariffID();
            vtsContract.tariffFamilyID = vtsSellProposal.getTariffFamilyID();
            vtsContract.tariffFamilyType = vtsSellProposal.getTariffFamilyType();
            vtsContract.contractDescription = vtsSellProposal.getContractDescription();
            vtsContract.proposalID = vtsSellProposal.getProposalID();
            vtsContract.priceEuroCent = vtsSellProposal.getPriceEuroCent();
            vtsContract.startValidityDate = vtsSellProposal.getStartValidityDate();
            vtsContract.endValidityDate = vtsSellProposal.getEndValidityDate();
            vtsContract.contractTypeDescription = vtsSellProposal.getContractTypeDescription();
            vtsContract.contractDurationDescription = vtsSellProposal.getContractDurationDescription();
            vtsContract.frontImageVTID = vtsSellProposal.getFrontImageVTID();
            vtsContract.backImageVTID = vtsSellProposal.getBackImageVTID();
        }
        if (vtsContractDTO != null) {
            vtsContract.contractID = StringUtils.unsignedHexStringToSignedLong(vtsContractDTO.getContractUID());
            vtsContract.vTokenUID = StringUtils.unsignedHexStringToSignedLong(vtsContractDTO.getVTokenUID());
            vtsContract.sellingDate = DateUtils.fromISO8601(vtsContractDTO.getSellDateTime());
        }
        return vtsContract;
    }

    public static VtsContract fromDto(VtsVTokenPayloadContractDTO vtsVTokenPayloadContractDTO, long j) {
        VtsContract vtsContract = new VtsContract();
        if (vtsVTokenPayloadContractDTO != null) {
            Integer price = vtsVTokenPayloadContractDTO.getPrice();
            vtsContract.providerID = vtsVTokenPayloadContractDTO.getProviderID().intValue();
            vtsContract.tariffID = vtsVTokenPayloadContractDTO.getTariffID().intValue();
            vtsContract.tariffFamilyID = vtsVTokenPayloadContractDTO.getTariffFamilyID().intValue();
            vtsContract.tariffFamilyType = vtsVTokenPayloadContractDTO.getTariffFamilyType().intValue();
            vtsContract.contractDescription = vtsVTokenPayloadContractDTO.getTariffDescription();
            vtsContract.priceEuroCent = price == null ? 0 : vtsVTokenPayloadContractDTO.getPrice().intValue();
            vtsContract.startValidityDate = DateUtils.fromISO8601(vtsVTokenPayloadContractDTO.getStartValidityDateTime());
            vtsContract.endValidityDate = DateUtils.fromISO8601(vtsVTokenPayloadContractDTO.getEndValidityDateTime());
            vtsContract.contractTypeDescription = vtsVTokenPayloadContractDTO.getContractTypeDescription();
            vtsContract.contractDurationDescription = vtsVTokenPayloadContractDTO.getContractTypeDuration();
            if (!StringUtils.isBlank(vtsVTokenPayloadContractDTO.getFrontImageVTID())) {
                vtsContract.frontImageVTID = Long.valueOf(StringUtils.unsignedHexStringToSignedLong(vtsVTokenPayloadContractDTO.getFrontImageVTID()));
            }
            if (!StringUtils.isBlank(vtsVTokenPayloadContractDTO.getBackImageVTID())) {
                vtsContract.backImageVTID = Long.valueOf(StringUtils.unsignedHexStringToSignedLong(vtsVTokenPayloadContractDTO.getBackImageVTID()));
            }
            vtsContract.contractID = StringUtils.unsignedHexStringToSignedLong(vtsVTokenPayloadContractDTO.getContractUID());
            vtsContract.vTokenUID = j;
            vtsContract.sellingDate = DateUtils.fromISO8601(vtsVTokenPayloadContractDTO.getSellingDate());
        }
        return vtsContract;
    }

    @Override // it.aep_italia.vts.sdk.domain.VtsSellProposal, it.aep_italia.vts.sdk.domain.VtsSellableContract, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // it.aep_italia.vts.sdk.domain.VtsSellProposal, it.aep_italia.vts.sdk.domain.VtsSellableContract
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || VtsContract.class != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        VtsContract vtsContract = (VtsContract) obj;
        if (this.contractID != vtsContract.contractID || this.vTokenUID != vtsContract.vTokenUID) {
            return false;
        }
        Date date = this.sellingDate;
        Date date2 = vtsContract.sellingDate;
        if (date != null) {
            return date.equals(date2);
        }
        return date2 == null;
    }

    public Date getSellingDate() {
        return this.sellingDate;
    }

    public long getUID() {
        return this.contractID;
    }

    public long getVTokenUID() {
        return this.vTokenUID;
    }

    @Override // it.aep_italia.vts.sdk.domain.VtsSellProposal, it.aep_italia.vts.sdk.domain.VtsSellableContract
    public int hashCode() {
        int iHashCode = super.hashCode();
        long j = this.contractID;
        int i = (int) (j ^ (j >>> 32));
        long j2 = this.vTokenUID;
        int i2 = (int) ((j2 >>> 32) ^ j2);
        Date date = this.sellingDate;
        return (((((iHashCode * 31) + i) * 31) + i2) * 31) + (date != null ? date.hashCode() : 0);
    }

    @Override // it.aep_italia.vts.sdk.domain.VtsSellProposal, it.aep_italia.vts.sdk.domain.VtsSellableContract, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeLong(this.contractID);
        parcel.writeLong(this.vTokenUID);
        Date date = this.sellingDate;
        parcel.writeLong(date != null ? date.getTime() : -1L);
    }
}
