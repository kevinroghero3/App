package it.aep_italia.vts.sdk.domain;

import android.os.Parcel;
import android.os.Parcelable;
import it.aep_italia.vts.sdk.dto.domain.VtsNodeDTO;
import it.aep_italia.vts.sdk.utils.StringUtils;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class VtsNode implements Serializable, Parcelable {
    public static final Parcelable.Creator<VtsNode> CREATOR = new a();
    private static final long serialVersionUID = -788878413099257393L;
    private String description;
    private int nodeID;
    private String shortDescription;

    class a implements Parcelable.Creator<VtsNode> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public VtsNode createFromParcel(Parcel parcel) {
            return new VtsNode(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public VtsNode[] newArray(int i) {
            return new VtsNode[i];
        }
    }

    public VtsNode() {
    }

    protected VtsNode(Parcel parcel) {
        this.nodeID = parcel.readInt();
        this.description = parcel.readString();
        this.shortDescription = parcel.readString();
    }

    public static VtsNode forID(int i) {
        VtsNode vtsNode = new VtsNode();
        vtsNode.nodeID = i;
        return vtsNode;
    }

    public static VtsNode fromDto(VtsNodeDTO vtsNodeDTO) {
        if (vtsNodeDTO == null) {
            return new VtsNode();
        }
        VtsNode vtsNode = new VtsNode();
        vtsNode.nodeID = vtsNodeDTO.getID().intValue();
        vtsNode.description = vtsNodeDTO.getDescription();
        vtsNode.shortDescription = vtsNodeDTO.getShortDescription();
        return vtsNode;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDescription() {
        return this.description;
    }

    public int getID() {
        return this.nodeID;
    }

    public String getShortDescription() {
        return this.shortDescription;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(this.nodeID);
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
        parcel.writeInt(this.nodeID);
        parcel.writeString(this.description);
        parcel.writeString(this.shortDescription);
    }
}
