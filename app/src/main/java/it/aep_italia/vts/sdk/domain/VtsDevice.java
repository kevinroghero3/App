package it.aep_italia.vts.sdk.domain;

import android.os.Parcel;
import android.os.Parcelable;
import ch.qos.logback.core.CoreConstants;
import it.aep_italia.vts.sdk.dto.domain.VtsDeviceDTO;
import it.aep_italia.vts.sdk.utils.StringUtils;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class VtsDevice implements Serializable, Parcelable {
    public static final Parcelable.Creator<VtsDevice> CREATOR = new a();
    private static final long serialVersionUID = 4192223409634830192L;
    public String deviceSubType;
    public String deviceType;
    public long deviceUID;
    public String iMEI;
    public String iMSI;
    public String lastConnectionDateTime;
    public String localIpv4Address;
    public String localIpv6Address;
    public String phoneNumber;
    public String sIMID;
    public int userId;
    public int vTokenCount;

    class a implements Parcelable.Creator<VtsDevice> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public VtsDevice createFromParcel(Parcel parcel) {
            return new VtsDevice(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public VtsDevice[] newArray(int i) {
            return new VtsDevice[i];
        }
    }

    public VtsDevice() {
    }

    protected VtsDevice(Parcel parcel) {
        this.deviceUID = parcel.readLong();
        this.deviceType = parcel.readString();
        this.deviceSubType = parcel.readString();
        this.phoneNumber = parcel.readString();
        this.userId = parcel.readInt();
        this.vTokenCount = parcel.readInt();
        this.lastConnectionDateTime = parcel.readString();
        this.iMEI = parcel.readString();
        this.iMSI = parcel.readString();
        this.sIMID = parcel.readString();
        this.localIpv4Address = parcel.readString();
        this.localIpv6Address = parcel.readString();
    }

    public static VtsDevice fromDto(VtsDeviceDTO vtsDeviceDTO) {
        if (vtsDeviceDTO == null) {
            return new VtsDevice();
        }
        VtsDevice vtsDevice = new VtsDevice();
        vtsDevice.deviceUID = StringUtils.unsignedHexStringToSignedLong(vtsDeviceDTO.getDeviceUID());
        vtsDevice.deviceType = vtsDeviceDTO.getDeviceType();
        vtsDevice.deviceSubType = vtsDeviceDTO.getDeviceSubType();
        vtsDevice.phoneNumber = vtsDeviceDTO.getPhoneNumber();
        vtsDevice.userId = vtsDeviceDTO.getUserId().intValue();
        vtsDevice.vTokenCount = vtsDeviceDTO.getvTokenCount().intValue();
        vtsDevice.lastConnectionDateTime = vtsDeviceDTO.getLastConnectionDateTime();
        vtsDevice.iMEI = vtsDeviceDTO.getiMEI();
        vtsDevice.iMSI = vtsDeviceDTO.getiMSI();
        vtsDevice.sIMID = vtsDeviceDTO.getsIMID();
        vtsDevice.localIpv4Address = vtsDeviceDTO.getLocalIpv4Address();
        vtsDevice.localIpv6Address = vtsDeviceDTO.getLocalIpv6Address();
        return vtsDevice;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDeviceSubType() {
        return this.deviceSubType;
    }

    public String getDeviceType() {
        return this.deviceType;
    }

    public long getDeviceUID() {
        return this.deviceUID;
    }

    public String getLastConnectionDateTime() {
        return this.lastConnectionDateTime;
    }

    public String getLocalIpv4Address() {
        return this.localIpv4Address;
    }

    public String getLocalIpv6Address() {
        return this.localIpv6Address;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public int getUserId() {
        return this.userId;
    }

    public String getiMEI() {
        return this.iMEI;
    }

    public String getiMSI() {
        return this.iMSI;
    }

    public String getsIMID() {
        return this.sIMID;
    }

    public int getvTokenCount() {
        return this.vTokenCount;
    }

    public void setDeviceSubType(String str) {
        this.deviceSubType = str;
    }

    public void setDeviceType(String str) {
        this.deviceType = str;
    }

    public void setDeviceUID(long j) {
        this.deviceUID = j;
    }

    public void setLastConnectionDateTime(String str) {
        this.lastConnectionDateTime = str;
    }

    public void setLocalIpv4Address(String str) {
        this.localIpv4Address = str;
    }

    public void setLocalIpv6Address(String str) {
        this.localIpv6Address = str;
    }

    public void setPhoneNumber(String str) {
        this.phoneNumber = str;
    }

    public void setUserId(int i) {
        this.userId = i;
    }

    public void setiMEI(String str) {
        this.iMEI = str;
    }

    public void setiMSI(String str) {
        this.iMSI = str;
    }

    public void setsIMID(String str) {
        this.sIMID = str;
    }

    public void setvTokenCount(int i) {
        this.vTokenCount = i;
    }

    public String toString() {
        return "VtsDevice{deviceUID=" + this.deviceUID + ", deviceType=" + this.deviceType + ", deviceSubType=" + this.deviceSubType + ", phoneNumber=" + this.phoneNumber + ", userId='" + this.userId + CoreConstants.SINGLE_QUOTE_CHAR + ", vTokenCount='" + this.vTokenCount + CoreConstants.SINGLE_QUOTE_CHAR + ", lastConnectionDateTime='" + this.lastConnectionDateTime + CoreConstants.SINGLE_QUOTE_CHAR + ", iMEI='" + this.iMEI + CoreConstants.SINGLE_QUOTE_CHAR + ", iMSI='" + this.iMSI + CoreConstants.SINGLE_QUOTE_CHAR + ", sIMID='" + this.sIMID + CoreConstants.SINGLE_QUOTE_CHAR + ", localIpv4Address='" + this.localIpv4Address + CoreConstants.SINGLE_QUOTE_CHAR + ", localIpv6Address='" + this.localIpv6Address + CoreConstants.CURLY_RIGHT;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.deviceUID);
        parcel.writeString(this.deviceType);
        parcel.writeString(this.deviceSubType);
        parcel.writeString(this.phoneNumber);
        parcel.writeInt(this.userId);
        parcel.writeInt(this.vTokenCount);
        parcel.writeString(this.lastConnectionDateTime);
        parcel.writeString(this.iMEI);
        parcel.writeString(this.iMSI);
        parcel.writeString(this.sIMID);
        parcel.writeString(this.localIpv4Address);
        parcel.writeString(this.localIpv6Address);
    }
}
