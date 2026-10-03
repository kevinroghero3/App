package it.aep_italia.vts.sdk.hce.apdu.io;

import it.aep_italia.vts.sdk.errors.VtsError;
import it.aep_italia.vts.sdk.errors.VtsException;
import it.aep_italia.vts.sdk.hce.apdu.ApduRequestMessage;
import it.aep_italia.vts.sdk.hce.apdu.ApduResponseMessage;
import it.aep_italia.vts.sdk.utils.ByteUtils;
import java.util.Locale;

/* JADX INFO: loaded from: classes6.dex */
public class ApduByteParser {
    protected void parseOptional(ApduRequestMessage apduRequestMessage, byte[] bArr, int i, int i2) {
        int iBytesToInt;
        if (i > 0) {
            iBytesToInt = ByteUtils.bytesToInt(ByteUtils.extract(bArr, 4, i));
            int i3 = i + 4;
            if (i3 + iBytesToInt > bArr.length) {
                throw new VtsException(VtsError.COULD_NOT_DESERIALIZE_APDU, String.format(Locale.ITALY, "Expected %d bytes of data, got %d.", Integer.valueOf(iBytesToInt), Integer.valueOf((bArr.length - 4) - i)), new Object[0]);
            }
            apduRequestMessage.setData(ByteUtils.extract(bArr, i3, iBytesToInt));
        } else {
            iBytesToInt = 0;
        }
        if (i2 > 0) {
            int i4 = i > 0 ? 4 + i + iBytesToInt : 4;
            if (i4 + i2 > bArr.length) {
                throw new VtsException(VtsError.COULD_NOT_DESERIALIZE_APDU, String.format(Locale.ITALY, "Expected %d bytes of data, got %d.", Integer.valueOf(i2), Integer.valueOf(bArr.length - i4)), new Object[0]);
            }
            int iBytesToInt2 = ByteUtils.bytesToInt(ByteUtils.extract(bArr, i4, i2));
            if (iBytesToInt2 == 0) {
                iBytesToInt2 = 256;
            }
            apduRequestMessage.setResponseLength(iBytesToInt2);
        }
    }

    public ApduRequestMessage parseRequest(byte[] bArr) throws VtsException {
        if (bArr == null) {
            throw new VtsException(VtsError.COULD_NOT_DESERIALIZE_APDU, "Input array cannot be null.", new Object[0]);
        }
        if (bArr.length < 4) {
            throw new VtsException(VtsError.COULD_NOT_DESERIALIZE_APDU, "Request messages cannot have fewer than 4 bytes.", new Object[0]);
        }
        ApduRequestMessage apduRequestMessage = new ApduRequestMessage();
        apduRequestMessage.setCLA(bArr[0]);
        apduRequestMessage.setINS(bArr[1]);
        apduRequestMessage.setP1(bArr[2]);
        apduRequestMessage.setP2(bArr[3]);
        int iByteToInt = ByteUtils.byteToInt(bArr[4]);
        if (bArr.length == 4) {
            return apduRequestMessage;
        }
        if (bArr.length == 5) {
            parseOptional(apduRequestMessage, bArr, 0, 1);
        } else if (iByteToInt == 0 && bArr.length == 7) {
            parseOptional(apduRequestMessage, bArr, 0, 3);
        } else if (iByteToInt == 0 && bArr.length > 7) {
            parseOptional(apduRequestMessage, bArr, 3, 0);
        } else if (iByteToInt != 0 && (bArr.length - iByteToInt) - 5 == 0) {
            parseOptional(apduRequestMessage, bArr, 1, 0);
        } else if (iByteToInt != 0 && (bArr.length - iByteToInt) - 5 == 1) {
            parseOptional(apduRequestMessage, bArr, 1, 1);
        } else {
            if (iByteToInt == 0 || (bArr.length - iByteToInt) - 5 != 2) {
                throw new VtsException(VtsError.COULD_NOT_DESERIALIZE_APDU, "Could not parse message.", new Object[0]);
            }
            parseOptional(apduRequestMessage, bArr, 1, 2);
        }
        return apduRequestMessage;
    }

    public ApduResponseMessage parseResponse(byte[] bArr) throws VtsException {
        if (bArr == null) {
            throw new VtsException(VtsError.COULD_NOT_DESERIALIZE_APDU, "Input array cannot be null.", new Object[0]);
        }
        if (bArr.length < 2) {
            throw new VtsException(VtsError.COULD_NOT_DESERIALIZE_APDU, "Response messages cannot have fewer than 2 bytes.", new Object[0]);
        }
        ApduResponseMessage apduResponseMessage = new ApduResponseMessage();
        if (bArr.length > 2) {
            apduResponseMessage.setData(ByteUtils.extract(bArr, 0, bArr.length - 2));
        }
        apduResponseMessage.setSW1(bArr[bArr.length - 2]);
        apduResponseMessage.setSW2(bArr[bArr.length - 1]);
        return apduResponseMessage;
    }
}
