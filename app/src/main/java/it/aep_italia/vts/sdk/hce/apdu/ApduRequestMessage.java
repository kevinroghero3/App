package it.aep_italia.vts.sdk.hce.apdu;

import android.os.Parcel;
import android.os.Parcelable;
import it.aep_italia.vts.sdk.utils.ByteUtils;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public class ApduRequestMessage implements Parcelable {
    public static final Parcelable.Creator<ApduRequestMessage> CREATOR = new a();
    private byte a;
    private byte b;
    private byte c;
    private byte d;
    private byte[] e;
    private int f;

    class a implements Parcelable.Creator<ApduRequestMessage> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ApduRequestMessage createFromParcel(Parcel parcel) {
            return new ApduRequestMessage(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ApduRequestMessage[] newArray(int i) {
            return new ApduRequestMessage[i];
        }
    }

    public ApduRequestMessage() {
        this.e = new byte[0];
    }

    protected ApduRequestMessage(Parcel parcel) {
        this.e = new byte[0];
        this.a = parcel.readByte();
        this.b = parcel.readByte();
        this.c = parcel.readByte();
        this.d = parcel.readByte();
        this.e = parcel.createByteArray();
        this.f = parcel.readInt();
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public ApduRequestMessage m5466clone() {
        ApduRequestMessage apduRequestMessage = new ApduRequestMessage();
        apduRequestMessage.a = this.a;
        apduRequestMessage.b = this.b;
        apduRequestMessage.c = this.c;
        apduRequestMessage.d = this.d;
        apduRequestMessage.e = this.e;
        apduRequestMessage.f = this.f;
        return apduRequestMessage;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj != null && obj.getClass().equals(getClass())) {
            ApduRequestMessage apduRequestMessage = (ApduRequestMessage) obj;
            if (this.a == apduRequestMessage.a && this.b == apduRequestMessage.b && this.c == apduRequestMessage.c && this.d == apduRequestMessage.d && this.f == apduRequestMessage.f && Arrays.equals(this.e, apduRequestMessage.e)) {
                return true;
            }
        }
        return false;
    }

    public byte getCLA() {
        return this.a;
    }

    public byte[] getData() {
        byte[] bArr = this.e;
        return bArr == null ? new byte[0] : bArr;
    }

    public byte getINS() {
        return this.b;
    }

    public byte[] getLc() {
        byte[] bArr = this.e;
        if (bArr == null || bArr.length == 0) {
            return new byte[0];
        }
        int length = bArr.length;
        int length2 = bArr.length;
        return length < 256 ? new byte[]{(byte) length2} : ByteUtils.longToBytes(length2, 5);
    }

    public byte[] getLe() {
        int i = this.f;
        if (i == 0) {
            return new byte[0];
        }
        if (i < 256) {
            return new byte[]{(byte) i};
        }
        if (i == 256) {
            return new byte[]{0};
        }
        return ByteUtils.longToBytes(i == 65536 ? 0L : i, getLc().length > 0 ? 6 : 5);
    }

    public byte getP1() {
        return this.c;
    }

    public byte getP2() {
        return this.d;
    }

    public int getResponseLength() {
        return this.f;
    }

    public int hashCode() {
        byte b = this.a;
        byte b2 = this.b;
        byte b3 = this.c;
        byte b4 = this.d;
        int i = this.f;
        return Objects.hash(Byte.valueOf(b), Byte.valueOf(b2), Byte.valueOf(b3), Byte.valueOf(b4), Integer.valueOf(i), this.e);
    }

    public boolean isCLA(String str) {
        return this.a == ByteUtils.stringToByte(str);
    }

    public boolean isINS(String str) {
        return this.b == ByteUtils.stringToByte(str);
    }

    public boolean isMatch(String str, String str2) {
        return isCLA(str) && isINS(str2);
    }

    public boolean isMatch(String str, String str2, String str3, String str4) {
        return isCLA(str) && isINS(str2) && isP1(str3) && isP2(str4);
    }

    public boolean isP1(String str) {
        return this.c == ByteUtils.stringToByte(str);
    }

    public boolean isP2(String str) {
        return this.d == ByteUtils.stringToByte(str);
    }

    public void replace(byte b, int i) throws IndexOutOfBoundsException {
        byte[] bArr = this.e;
        if (bArr.length < i + 1) {
            throw new IndexOutOfBoundsException();
        }
        bArr[i] = b;
    }

    public void replaceRange(byte[] bArr, int i) throws IndexOutOfBoundsException {
        if (bArr == null) {
            return;
        }
        if (this.e.length < bArr.length + i) {
            throw new IndexOutOfBoundsException();
        }
        for (int i2 = 0; i2 < bArr.length; i2++) {
            this.e[i + i2] = bArr[i2];
        }
    }

    public void setCLA(byte b) {
        this.a = b;
    }

    public void setData(byte[] bArr) {
        if (bArr != null && bArr.length > 65535) {
            throw new IllegalArgumentException("Data field cannot exceed 65,535 bytes.");
        }
        this.e = bArr;
    }

    public void setINS(byte b) {
        this.b = b;
    }

    public void setP1(byte b) {
        this.c = b;
    }

    public void setP2(byte b) {
        this.d = b;
    }

    public void setResponseLength(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Max data payload length cannot be negative.");
        }
        if (i > 65536) {
            throw new IllegalArgumentException("Max data payload length cannot exceed 65,536.");
        }
        this.f = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.a);
        parcel.writeByte(this.b);
        parcel.writeByte(this.c);
        parcel.writeByte(this.d);
        parcel.writeByteArray(this.e);
        parcel.writeInt(this.f);
    }
}
