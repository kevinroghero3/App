package it.aep_italia.vts.sdk.hce.apdu.io;

import it.aep_italia.vts.sdk.hce.apdu.ApduResponseMessage;
import it.aep_italia.vts.sdk.utils.ByteUtils;
import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: classes6.dex */
public class ApduResponseBuilder {
    protected byte SW1;
    protected byte SW2;
    protected ByteArrayOutputStream dataStream = new ByteArrayOutputStream();

    protected ApduResponseBuilder() {
    }

    public static ApduResponseBuilder builder() {
        return new ApduResponseBuilder();
    }

    public ApduResponseBuilder SW1(byte b) {
        this.SW1 = b;
        return this;
    }

    public ApduResponseBuilder SW1(String str) {
        this.SW1 = ByteUtils.stringToByte(str);
        return this;
    }

    public ApduResponseBuilder SW2(byte b) {
        this.SW2 = b;
        return this;
    }

    public ApduResponseBuilder SW2(String str) {
        this.SW2 = ByteUtils.stringToByte(str);
        return this;
    }

    public ApduResponseBuilder appendData(byte b) {
        this.dataStream.write(b);
        return this;
    }

    public ApduResponseBuilder appendData(String str) {
        return appendData(ByteUtils.stringToBytes(str));
    }

    public ApduResponseBuilder appendData(byte[] bArr) {
        this.dataStream.write(bArr, 0, bArr.length);
        return this;
    }

    public ApduResponseMessage build() {
        ApduResponseMessage apduResponseMessage = new ApduResponseMessage();
        apduResponseMessage.setSW1(this.SW1);
        apduResponseMessage.setSW2(this.SW2);
        apduResponseMessage.setData(this.dataStream.toByteArray());
        return apduResponseMessage;
    }

    public ApduResponseBuilder data(String str) {
        return data(ByteUtils.stringToBytes(str));
    }

    public ApduResponseBuilder data(byte[] bArr) {
        this.dataStream.reset();
        return appendData(bArr);
    }
}
