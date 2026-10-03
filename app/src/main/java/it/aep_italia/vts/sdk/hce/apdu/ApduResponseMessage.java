package it.aep_italia.vts.sdk.hce.apdu;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public class ApduResponseMessage implements Parcelable {
    public static final Parcelable.Creator<ApduResponseMessage> CREATOR = new a();
    protected byte SW1;
    protected byte SW2;
    protected byte[] data;

    class a implements Parcelable.Creator<ApduResponseMessage> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ApduResponseMessage createFromParcel(Parcel parcel) {
            return new ApduResponseMessage(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ApduResponseMessage[] newArray(int i) {
            return new ApduResponseMessage[i];
        }
    }

    public ApduResponseMessage() {
        this.data = new byte[0];
    }

    protected ApduResponseMessage(Parcel parcel) {
        this.data = new byte[0];
        this.data = parcel.createByteArray();
        this.SW1 = parcel.readByte();
        this.SW2 = parcel.readByte();
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public ApduResponseMessage m5467clone() {
        ApduResponseMessage apduResponseMessage = new ApduResponseMessage();
        apduResponseMessage.SW1 = this.SW1;
        apduResponseMessage.SW2 = this.SW2;
        apduResponseMessage.data = this.data;
        return apduResponseMessage;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj != null && obj.getClass().equals(getClass())) {
            ApduResponseMessage apduResponseMessage = (ApduResponseMessage) obj;
            if (this.SW1 == apduResponseMessage.SW1 && this.SW2 == apduResponseMessage.SW2 && Arrays.equals(this.data, apduResponseMessage.data)) {
                return true;
            }
        }
        return false;
    }

    public byte[] getData() {
        byte[] bArr = this.data;
        return bArr == null ? new byte[0] : bArr;
    }

    public byte getSW1() {
        return this.SW1;
    }

    public byte getSW2() {
        return this.SW2;
    }

    public int hashCode() {
        byte b = this.SW1;
        byte b2 = this.SW2;
        return Objects.hash(Byte.valueOf(b), Byte.valueOf(b2), this.data);
    }

    public void replace(byte b, int i) throws IndexOutOfBoundsException {
        byte[] bArr = this.data;
        if (bArr.length < i + 1) {
            throw new IndexOutOfBoundsException();
        }
        bArr[i] = b;
    }

    public void replaceRange(byte[] bArr, int i) throws IndexOutOfBoundsException {
        if (bArr == null) {
            return;
        }
        if (this.data.length < bArr.length + i) {
            throw new IndexOutOfBoundsException();
        }
        for (int i2 = 0; i2 < bArr.length; i2++) {
            this.data[i + i2] = bArr[i2];
        }
    }

    public void setData(byte[] bArr) {
        if (bArr != null && bArr.length > 65536) {
            throw new IllegalArgumentException("Data field cannot exceed 65,536 bytes.");
        }
        this.data = bArr;
    }

    public void setSW1(byte b) {
        this.SW1 = b;
    }

    public void setSW2(byte b) {
        this.SW2 = b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(this.data);
        parcel.writeByte(this.SW1);
        parcel.writeByte(this.SW2);
    }
}
