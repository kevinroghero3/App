package it.aep_italia.vts.sdk.domain;

import android.os.Parcel;
import android.os.Parcelable;
import ch.qos.logback.core.CoreConstants;
import it.aep_italia.vts.sdk.dto.domain.VtsSellProposalDTO;
import it.aep_italia.vts.sdk.utils.DateUtils;
import it.aep_italia.vts.sdk.utils.StringUtils;
import java.util.Date;

/* JADX INFO: loaded from: classes6.dex */
public class VtsSellProposal extends VtsSellableContract {
    public static final Parcelable.Creator<VtsSellProposal> CREATOR = new a();
    private static final long serialVersionUID = 3530826884524426805L;
    private Integer destinationNodeID;
    public Date endValidityDate;
    private Integer originNodeID;
    public int priceEuroCent;
    public long proposalID;
    public Date startValidityDate;

    class a implements Parcelable.Creator<VtsSellProposal> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public VtsSellProposal createFromParcel(Parcel parcel) {
            return new VtsSellProposal(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public VtsSellProposal[] newArray(int i) {
            return new VtsSellProposal[i];
        }
    }

    public VtsSellProposal() {
    }

    protected VtsSellProposal(Parcel parcel) {
        super(parcel);
        this.proposalID = parcel.readLong();
        this.priceEuroCent = parcel.readInt();
        long j = parcel.readLong();
        this.startValidityDate = j == -1 ? null : new Date(j);
        long j2 = parcel.readLong();
        this.endValidityDate = j2 != -1 ? new Date(j2) : null;
        this.originNodeID = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.destinationNodeID = (Integer) parcel.readValue(Integer.class.getClassLoader());
    }

    public static VtsSellProposal fromDto(VtsSellableContract vtsSellableContract, VtsSellProposalDTO vtsSellProposalDTO) {
        VtsSellProposal vtsSellProposal = new VtsSellProposal();
        if (vtsSellableContract != null) {
            vtsSellProposal.providerID = vtsSellableContract.getProviderID();
            vtsSellProposal.tariffFamilyID = vtsSellableContract.getTariffFamilyID();
            vtsSellProposal.tariffID = vtsSellableContract.getTariffID();
            vtsSellProposal.tariffFamilyType = vtsSellableContract.getTariffFamilyType();
            vtsSellProposal.contractDescription = vtsSellableContract.getContractDescription();
            vtsSellProposal.contractDurationDescription = vtsSellableContract.getContractDurationDescription();
            vtsSellProposal.contractTypeDescription = vtsSellableContract.getContractTypeDescription();
            vtsSellProposal.frontImageVTID = vtsSellableContract.getFrontImageVTID();
            vtsSellProposal.backImageVTID = vtsSellableContract.getBackImageVTID();
        }
        if (vtsSellProposalDTO != null) {
            vtsSellProposal.startValidityDate = DateUtils.fromISO8601(vtsSellProposalDTO.getEndValidityDateTime());
            vtsSellProposal.endValidityDate = DateUtils.fromISO8601(vtsSellProposalDTO.getEndValidityDateTime());
            vtsSellProposal.priceEuroCent = vtsSellProposalDTO.getPriceEuroCent();
            vtsSellProposal.proposalID = vtsSellProposalDTO.getSellProposalID();
            if (!StringUtils.isBlank(vtsSellProposalDTO.getContractTypeDescription())) {
                vtsSellProposal.contractTypeDescription = vtsSellProposalDTO.getContractTypeDescription();
            }
            if (!StringUtils.isBlank(vtsSellProposalDTO.getContractDurationDescription())) {
                vtsSellProposal.contractDurationDescription = vtsSellProposalDTO.getContractDurationDescription();
            }
        }
        return vtsSellProposal;
    }

    @Override // it.aep_italia.vts.sdk.domain.VtsSellableContract, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // it.aep_italia.vts.sdk.domain.VtsSellableContract
    public boolean equals(Object obj) {
        return obj != null && (obj instanceof VtsSellProposal) && super.equals(obj) && this.proposalID == ((VtsSellProposal) obj).proposalID;
    }

    public Integer getDestinationNodeID() {
        return this.destinationNodeID;
    }

    public Date getEndValidityDate() {
        return this.endValidityDate;
    }

    public Integer getOriginNodeID() {
        return this.originNodeID;
    }

    public int getPriceEuroCent() {
        return this.priceEuroCent;
    }

    public long getProposalID() {
        return this.proposalID;
    }

    public Date getStartValidityDate() {
        return this.startValidityDate;
    }

    @Override // it.aep_italia.vts.sdk.domain.VtsSellableContract
    public int hashCode() {
        int iHashCode = super.hashCode();
        long j = this.proposalID;
        return (iHashCode * 31) + ((int) (j ^ (j >>> 32)));
    }

    public void setDestinationNodeID(Integer num) {
        this.destinationNodeID = num;
    }

    public void setEndValidityDate(Date date) {
        this.endValidityDate = this.endValidityDate;
    }

    public void setOriginNodeID(Integer num) {
        this.originNodeID = num;
    }

    public void setPriceEuroCent(Integer num) {
        this.priceEuroCent = num.intValue();
    }

    public void setProposalID(Integer num) {
        this.proposalID = num.intValue();
    }

    public void setStartValidityDate(Date date) {
        this.startValidityDate = date;
    }

    @Override // it.aep_italia.vts.sdk.domain.VtsSellableContract
    public String toString() {
        return "VtsSellProposal{proposalID=" + this.proposalID + ", priceEuroCent=" + this.priceEuroCent + ", startValidityDate=" + this.startValidityDate + ", endValidityDate=" + this.endValidityDate + ", originNodeID=" + this.originNodeID + ", destinationNodeID=" + this.destinationNodeID + CoreConstants.CURLY_RIGHT;
    }

    @Override // it.aep_italia.vts.sdk.domain.VtsSellableContract, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeLong(this.proposalID);
        parcel.writeInt(this.priceEuroCent);
        Date date = this.startValidityDate;
        parcel.writeLong(date != null ? date.getTime() : -1L);
        Date date2 = this.endValidityDate;
        parcel.writeLong(date2 != null ? date2.getTime() : -1L);
        parcel.writeValue(this.originNodeID);
        parcel.writeValue(this.destinationNodeID);
    }
}
