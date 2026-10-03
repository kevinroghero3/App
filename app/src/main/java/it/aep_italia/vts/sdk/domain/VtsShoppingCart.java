package it.aep_italia.vts.sdk.domain;

import android.os.Parcel;
import android.os.Parcelable;
import it.aep_italia.vts.sdk.dto.domain.VtsShoppingCartDTO;
import it.aep_italia.vts.sdk.dto.domain.VtsShoppingItemDTO;
import it.aep_italia.vts.sdk.utils.StringUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class VtsShoppingCart implements Serializable, Parcelable {
    public static final Parcelable.Creator<VtsShoppingCart> CREATOR = new a();
    private static final long serialVersionUID = -854152195124601035L;
    private ArrayList<VtsShoppingItem> shoppingItems;
    private int subEuroCent;

    class a implements Parcelable.Creator<VtsShoppingCart> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public VtsShoppingCart createFromParcel(Parcel parcel) {
            return new VtsShoppingCart(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public VtsShoppingCart[] newArray(int i) {
            return new VtsShoppingCart[i];
        }
    }

    public VtsShoppingCart() {
        this.shoppingItems = new ArrayList<>();
    }

    protected VtsShoppingCart(Parcel parcel) {
        this.subEuroCent = parcel.readInt();
        this.shoppingItems = parcel.createTypedArrayList(VtsShoppingItem.CREATOR);
    }

    public static VtsShoppingCart fromDto(VtsShoppingCartDTO vtsShoppingCartDTO) {
        VtsShoppingCart vtsShoppingCart = new VtsShoppingCart();
        vtsShoppingCart.subEuroCent = vtsShoppingCartDTO.getSubTotalEuroCent();
        vtsShoppingCart.shoppingItems = new ArrayList<>();
        Iterator<VtsShoppingItemDTO> it2 = vtsShoppingCartDTO.getShoppingItems().iterator();
        while (it2.hasNext()) {
            vtsShoppingCart.shoppingItems.add(VtsShoppingItem.fromDto(it2.next()));
        }
        return vtsShoppingCart;
    }

    public boolean containsItem(VtsShoppingItem vtsShoppingItem) {
        Iterator<VtsShoppingItem> it2 = this.shoppingItems.iterator();
        while (it2.hasNext()) {
            if (it2.next().equals(vtsShoppingItem)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCount() {
        ArrayList<VtsShoppingItem> arrayList = this.shoppingItems;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public VtsShoppingItem getItemForProposal(long j) {
        for (VtsShoppingItem vtsShoppingItem : this.shoppingItems) {
            if (vtsShoppingItem.getSellProposalID() == j) {
                return vtsShoppingItem;
            }
        }
        return null;
    }

    public VtsShoppingItem getItemForProposal(VtsSellProposal vtsSellProposal) {
        if (vtsSellProposal == null) {
            return null;
        }
        return getItemForProposal(vtsSellProposal.getProposalID());
    }

    public List<VtsShoppingItem> getShoppingItems() {
        return Collections.unmodifiableList(this.shoppingItems);
    }

    public int getSubEuroCent() {
        return this.subEuroCent;
    }

    public String toString() {
        ArrayList arrayList = new ArrayList();
        ArrayList<VtsShoppingItem> arrayList2 = this.shoppingItems;
        if (arrayList2 != null) {
            Iterator<VtsShoppingItem> it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                VtsShoppingItem next = it2.next();
                arrayList.add(next == null ? null : next.toString());
            }
        }
        return "VtsShoppingCart{subEuroCent=" + this.subEuroCent + ", shoppingItems=[" + StringUtils.join(arrayList, ",", true) + "]}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.subEuroCent);
        parcel.writeTypedList(this.shoppingItems);
    }
}
