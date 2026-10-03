package it.aep_italia.vts.sdk.domain;

import android.os.Parcel;
import android.os.Parcelable;
import it.aep_italia.vts.sdk.domain.enums.VtsObjectType;
import it.aep_italia.vts.sdk.domain.enums.VtsObjectTypeFormat;
import it.aep_italia.vts.sdk.domain.enums.VtsVTokenType;
import java.io.Serializable;
import java.util.Date;

/* JADX INFO: loaded from: classes6.dex */
public class VtsVToken implements Serializable, Parcelable {
    public static final Parcelable.Creator<VtsVToken> CREATOR = new a();
    private static final long serialVersionUID = 6427879890405733295L;
    private long deviceUID;
    private int groupUID;
    private boolean isExpired;
    private boolean isPublic;
    private boolean isSystem;
    private Date lastUpdate;
    private VtsObjectType objectType;
    private VtsObjectTypeFormat objectTypeFormat;
    private long objectUID;
    private int payloadSize;
    private boolean requiresGeneration;
    private int signatureCount;
    private int systemSubType;
    private int systemType;
    private VtsVTokenType tokenType;
    private long tokenUID;
    private int tokenVersion;
    private VtsValidation vtsValidation;

    class a implements Parcelable.Creator<VtsVToken> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public VtsVToken createFromParcel(Parcel parcel) {
            return new VtsVToken(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public VtsVToken[] newArray(int i) {
            return new VtsVToken[i];
        }
    }

    public VtsVToken() {
    }

    protected VtsVToken(Parcel parcel) {
        this.tokenUID = parcel.readLong();
        this.objectUID = parcel.readLong();
        this.deviceUID = parcel.readLong();
        this.groupUID = parcel.readInt();
        this.tokenVersion = parcel.readInt();
        this.systemType = parcel.readInt();
        this.systemSubType = parcel.readInt();
        int i = parcel.readInt();
        this.objectType = i == -1 ? null : VtsObjectType.values()[i];
        int i2 = parcel.readInt();
        this.objectTypeFormat = i2 == -1 ? null : VtsObjectTypeFormat.values()[i2];
        int i3 = parcel.readInt();
        this.tokenType = i3 != -1 ? VtsVTokenType.values()[i3] : null;
        this.isExpired = parcel.readByte() != 0;
        this.isPublic = parcel.readByte() != 0;
        this.isSystem = parcel.readByte() != 0;
        this.vtsValidation = (VtsValidation) parcel.readParcelable(VtsValidation.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getDeviceUID() {
        return this.deviceUID;
    }

    public int getGroupUID() {
        return this.groupUID;
    }

    public Date getLastUpdate() {
        return this.lastUpdate;
    }

    public VtsObjectType getObjectType() {
        return this.objectType;
    }

    public VtsObjectTypeFormat getObjectTypeFormat() {
        return this.objectTypeFormat;
    }

    public long getObjectUID() {
        return this.objectUID;
    }

    public int getPayloadSize() {
        return this.payloadSize;
    }

    public int getSignatureCount() {
        return this.signatureCount;
    }

    public int getSystemSubType() {
        return this.systemSubType;
    }

    public int getSystemType() {
        return this.systemType;
    }

    public VtsVTokenType getTokenType() {
        return this.tokenType;
    }

    public long getUID() {
        return this.tokenUID;
    }

    public VtsValidation getValidation() {
        return this.vtsValidation;
    }

    public int getVersion() {
        return this.tokenVersion;
    }

    public boolean isExpired() {
        VtsValidation vtsValidation;
        if (this.isExpired) {
            return true;
        }
        VtsObjectType vtsObjectType = this.objectType;
        if (vtsObjectType == VtsObjectType.CALYPSO_SMARTCARD || vtsObjectType == VtsObjectType.MIFARE_1K_SMARTCARD || vtsObjectType == VtsObjectType.INNOVATRON_CD97_SMARTCARD || (vtsValidation = this.vtsValidation) == null) {
            return false;
        }
        if (vtsValidation.isExpired()) {
            return true;
        }
        return this.vtsValidation.isValidated() && this.vtsValidation.isMinutesToGoValid() && this.vtsValidation.getActualMinutesToGo() <= 0;
    }

    public boolean isPublic() {
        return this.isPublic;
    }

    public boolean isSmartCard() {
        VtsObjectType vtsObjectType = this.objectType;
        return vtsObjectType == VtsObjectType.CALYPSO_SMARTCARD || vtsObjectType == VtsObjectType.MIFARE_1K_SMARTCARD || vtsObjectType == VtsObjectType.INNOVATRON_CD97_SMARTCARD;
    }

    public boolean isSmartTicket() {
        VtsObjectType vtsObjectType = this.objectType;
        return vtsObjectType == VtsObjectType.SMART_TICKET_OR_COP_MIFARE_UL || vtsObjectType == VtsObjectType.CRYPTOGRAM_OR_QR_CODE || vtsObjectType == VtsObjectType.MAGNETIC_STRIPE_TICKET;
    }

    public boolean isSystem() {
        return this.isSystem;
    }

    public boolean requiresGeneration() {
        return this.requiresGeneration;
    }

    public void setDeviceUID(long j) {
        this.deviceUID = j;
    }

    public void setExpired(boolean z) {
        this.isExpired = z;
    }

    public void setGroupUID(int i) {
        this.groupUID = i;
    }

    public void setLastUpdate(Date date) {
        this.lastUpdate = date;
    }

    public void setObjectType(VtsObjectType vtsObjectType) {
        this.objectType = vtsObjectType;
    }

    public void setObjectTypeFormat(VtsObjectTypeFormat vtsObjectTypeFormat) {
        this.objectTypeFormat = vtsObjectTypeFormat;
    }

    public void setObjectUID(long j) {
        this.objectUID = j;
    }

    public void setPayloadSize(int i) {
        this.payloadSize = i;
    }

    public void setPublic(boolean z) {
    }

    public void setRequiresGeneration(boolean z) {
        this.requiresGeneration = z;
    }

    public void setSignatureCount(int i) {
        this.signatureCount = i;
    }

    public void setSystem(boolean z) {
        this.isSystem = z;
    }

    public void setSystemSubType(int i) {
        this.systemSubType = i;
    }

    public void setSystemType(int i) {
        this.systemType = i;
    }

    public void setTokenType(VtsVTokenType vtsVTokenType) {
        this.tokenType = vtsVTokenType;
    }

    public void setUID(long j) {
        this.tokenUID = j;
    }

    public void setValidation(VtsValidation vtsValidation) {
        this.vtsValidation = vtsValidation;
    }

    public void setVersion(int i) {
        this.tokenVersion = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.tokenUID);
        parcel.writeLong(this.objectUID);
        parcel.writeLong(this.deviceUID);
        parcel.writeInt(this.groupUID);
        parcel.writeInt(this.tokenVersion);
        parcel.writeInt(this.systemType);
        parcel.writeInt(this.systemSubType);
        VtsObjectType vtsObjectType = this.objectType;
        parcel.writeInt(vtsObjectType == null ? -1 : vtsObjectType.ordinal());
        VtsObjectTypeFormat vtsObjectTypeFormat = this.objectTypeFormat;
        parcel.writeInt(vtsObjectTypeFormat == null ? -1 : vtsObjectTypeFormat.ordinal());
        VtsVTokenType vtsVTokenType = this.tokenType;
        parcel.writeInt(vtsVTokenType != null ? vtsVTokenType.ordinal() : -1);
        parcel.writeByte(this.isExpired ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isPublic ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isSystem ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.vtsValidation, i);
    }
}
