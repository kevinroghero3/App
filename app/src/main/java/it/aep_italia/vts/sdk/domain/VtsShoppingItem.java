package it.aep_italia.vts.sdk.domain;

import android.os.Parcel;
import android.os.Parcelable;
import ch.qos.logback.core.CoreConstants;
import it.aep_italia.vts.sdk.dto.domain.VtsShoppingItemDTO;
import it.aep_italia.vts.sdk.errors.VtsError;
import it.aep_italia.vts.sdk.utils.ValidationUtils;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class VtsShoppingItem implements Serializable, Parcelable {
    public static final Parcelable.Creator<VtsShoppingItem> CREATOR = new a();
    private static final long serialVersionUID = 6091833108266144068L;
    private String description;
    private int priceEuroCent;
    private int quantity;
    private long sellProposalID;
    private String subDescription1;
    private String subDescription2;
    private int unitPriceEuroCent;

    class a implements Parcelable.Creator<VtsShoppingItem> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public VtsShoppingItem createFromParcel(Parcel parcel) {
            return new VtsShoppingItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public VtsShoppingItem[] newArray(int i) {
            return new VtsShoppingItem[i];
        }
    }

    public VtsShoppingItem() {
    }

    protected VtsShoppingItem(Parcel parcel) {
        this.sellProposalID = parcel.readLong();
        this.quantity = parcel.readInt();
        this.description = parcel.readString();
        this.subDescription1 = parcel.readString();
        this.subDescription2 = parcel.readString();
        this.unitPriceEuroCent = parcel.readInt();
        this.priceEuroCent = parcel.readInt();
    }

    public static VtsShoppingItem fromDto(VtsShoppingItemDTO vtsShoppingItemDTO) {
        VtsShoppingItem vtsShoppingItem = new VtsShoppingItem();
        vtsShoppingItem.sellProposalID = vtsShoppingItemDTO.getSellProposalID();
        vtsShoppingItem.quantity = vtsShoppingItemDTO.getQuantity();
        vtsShoppingItem.description = vtsShoppingItemDTO.getDescription();
        vtsShoppingItem.subDescription1 = vtsShoppingItemDTO.getSubDescription1();
        vtsShoppingItem.subDescription2 = vtsShoppingItemDTO.getSubDescription2();
        vtsShoppingItem.unitPriceEuroCent = vtsShoppingItemDTO.getUnitPriceEuroCent();
        vtsShoppingItem.priceEuroCent = vtsShoppingItemDTO.getPriceEuroCent();
        return vtsShoppingItem;
    }

    public static VtsShoppingItem fromSellProposal(VtsSellProposal vtsSellProposal, int i) {
        VtsError vtsError = VtsError.INVALID_PARAMETER;
        ValidationUtils.assertNonNull(vtsSellProposal, vtsError, "Sell proposal cannot be null", new Object[0]);
        ValidationUtils.assertTrue(i > 0, vtsError, "Quantity must be positive", new Object[0]);
        VtsShoppingItem vtsShoppingItem = new VtsShoppingItem();
        vtsShoppingItem.sellProposalID = vtsSellProposal.getProposalID();
        vtsShoppingItem.quantity = i;
        vtsShoppingItem.unitPriceEuroCent = vtsSellProposal.getPriceEuroCent();
        vtsShoppingItem.priceEuroCent = vtsSellProposal.getPriceEuroCent() * i;
        return vtsShoppingItem;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        VtsShoppingItem vtsShoppingItem = (VtsShoppingItem) obj;
        return this.sellProposalID == vtsShoppingItem.sellProposalID && this.unitPriceEuroCent == vtsShoppingItem.unitPriceEuroCent;
    }

    public String getDescription() {
        return this.description;
    }

    public int getPriceEuroCent() {
        return this.priceEuroCent;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public long getSellProposalID() {
        return this.sellProposalID;
    }

    public String getSubDescription1() {
        return this.subDescription1;
    }

    public String getSubDescription2() {
        return this.subDescription2;
    }

    public int getUnitPriceEuroCent() {
        return this.unitPriceEuroCent;
    }

    public int hashCode() {
        long j = this.sellProposalID;
        return (((int) (j ^ (j >>> 32))) * 31) + this.unitPriceEuroCent;
    }

    public String toString() {
        return "VtsShoppingItem{sellProposalID=" + this.sellProposalID + ", quantity=" + this.quantity + ", description='" + this.description + CoreConstants.SINGLE_QUOTE_CHAR + ", subDescription1='" + this.subDescription1 + CoreConstants.SINGLE_QUOTE_CHAR + ", subDescription2='" + this.subDescription2 + CoreConstants.SINGLE_QUOTE_CHAR + ", unitPriceEuroCent=" + this.unitPriceEuroCent + ", priceEuroCent=" + this.priceEuroCent + CoreConstants.CURLY_RIGHT;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.sellProposalID);
        parcel.writeInt(this.quantity);
        parcel.writeString(this.description);
        parcel.writeString(this.subDescription1);
        parcel.writeString(this.subDescription2);
        parcel.writeInt(this.unitPriceEuroCent);
        parcel.writeInt(this.priceEuroCent);
    }
}
