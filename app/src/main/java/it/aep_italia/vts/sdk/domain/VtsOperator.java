package it.aep_italia.vts.sdk.domain;

import android.os.Parcel;
import android.os.Parcelable;
import it.aep_italia.vts.sdk.dto.domain.VtsOperatorDTO;
import it.aep_italia.vts.sdk.utils.StringUtils;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class VtsOperator implements Serializable, Parcelable {
    public static final Parcelable.Creator<VtsOperator> CREATOR = new a();
    private static final long serialVersionUID = -4414833318781218155L;
    private String address;
    private String city;
    private String description;
    private String fiscalCode;
    private boolean isOperator;
    private boolean isProvider;
    private boolean isSellEnabled;
    private Long logoImageLargeVTID;
    private Long logoImageSmallVTID;
    private int operatorID;
    private String shortDescription;
    private String webSiteUrl;
    private String zipCode;

    class a implements Parcelable.Creator<VtsOperator> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public VtsOperator createFromParcel(Parcel parcel) {
            return new VtsOperator(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public VtsOperator[] newArray(int i) {
            return new VtsOperator[i];
        }
    }

    public VtsOperator() {
    }

    protected VtsOperator(Parcel parcel) {
        this.operatorID = parcel.readInt();
        this.description = parcel.readString();
        this.shortDescription = parcel.readString();
        this.fiscalCode = parcel.readString();
        this.webSiteUrl = parcel.readString();
        this.address = parcel.readString();
        this.city = parcel.readString();
        this.zipCode = parcel.readString();
        this.isOperator = parcel.readByte() != 0;
        this.isProvider = parcel.readByte() != 0;
        this.isSellEnabled = parcel.readByte() != 0;
        this.logoImageLargeVTID = (Long) parcel.readValue(Long.class.getClassLoader());
        this.logoImageSmallVTID = (Long) parcel.readValue(Long.class.getClassLoader());
    }

    public static VtsOperator fromDto(VtsOperatorDTO vtsOperatorDTO) {
        if (vtsOperatorDTO == null) {
            return new VtsOperator();
        }
        VtsOperator vtsOperator = new VtsOperator();
        vtsOperator.operatorID = vtsOperatorDTO.getOperatorID();
        vtsOperator.description = vtsOperatorDTO.getOperatorDescription();
        vtsOperator.shortDescription = vtsOperatorDTO.getOperatorShortDescription();
        vtsOperator.fiscalCode = vtsOperatorDTO.getFiscalCode();
        vtsOperator.webSiteUrl = vtsOperatorDTO.getWebSiteUrl();
        vtsOperator.address = vtsOperatorDTO.getAddress();
        vtsOperator.city = vtsOperatorDTO.getCity();
        vtsOperator.zipCode = vtsOperatorDTO.getZipCode();
        vtsOperator.isOperator = vtsOperatorDTO.isOperator();
        vtsOperator.isProvider = vtsOperatorDTO.isProvider();
        vtsOperator.isSellEnabled = vtsOperatorDTO.isSellEnabled();
        if (vtsOperatorDTO.getLogoImageLargeVTID() != null && vtsOperatorDTO.getLogoImageLargeVTID().length() > 0) {
            vtsOperator.logoImageLargeVTID = Long.valueOf(StringUtils.unsignedHexStringToSignedLong(vtsOperatorDTO.getLogoImageLargeVTID()));
        }
        if (vtsOperatorDTO.getLogoImageSmallVTID() != null && vtsOperatorDTO.getLogoImageSmallVTID().length() > 0) {
            vtsOperator.logoImageSmallVTID = Long.valueOf(StringUtils.unsignedHexStringToSignedLong(vtsOperatorDTO.getLogoImageSmallVTID()));
        }
        return vtsOperator;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAddress() {
        return this.address;
    }

    public String getCity() {
        return this.city;
    }

    public String getDescription() {
        return this.description;
    }

    public String getFiscalCode() {
        return this.fiscalCode;
    }

    public Long getLogoImageLargeVTID() {
        return this.logoImageLargeVTID;
    }

    public Long getLogoImageSmallVTID() {
        return this.logoImageSmallVTID;
    }

    public int getOperatorID() {
        return this.operatorID;
    }

    public String getShortDescription() {
        return this.shortDescription;
    }

    public String getWebSiteUrl() {
        return this.webSiteUrl;
    }

    public String getZipCode() {
        return this.zipCode;
    }

    public boolean isOperator() {
        return this.isOperator;
    }

    public boolean isProvider() {
        return this.isProvider;
    }

    public boolean isSellEnabled() {
        return this.isSellEnabled;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.operatorID);
        parcel.writeString(this.description);
        parcel.writeString(this.shortDescription);
        parcel.writeString(this.fiscalCode);
        parcel.writeString(this.webSiteUrl);
        parcel.writeString(this.address);
        parcel.writeString(this.city);
        parcel.writeString(this.zipCode);
        parcel.writeByte(this.isOperator ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isProvider ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isSellEnabled ? (byte) 1 : (byte) 0);
        parcel.writeValue(this.logoImageLargeVTID);
        parcel.writeValue(this.logoImageSmallVTID);
    }
}
