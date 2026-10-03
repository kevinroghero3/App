package it.aep_italia.vts.sdk.hce.crypto;

import it.aep_italia.vts.sdk.hce.VtsExchangeError;
import it.aep_italia.vts.sdk.hce.VtsExchangeException;
import it.aep_italia.vts.sdk.hce.apdu.ApduRequestMessage;
import it.aep_italia.vts.sdk.hce.apdu.ApduResponseMessage;
import it.aep_italia.vts.sdk.utils.ByteUtils;
import it.aep_italia.vts.sdk.utils.CryptoUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class VtsAesMessageCipher implements VtsMessageCipher {
    public static int setQueue;
    public static int setSessionActivity;
    protected byte[] aesKey;

    public VtsAesMessageCipher(byte[] bArr) {
        this.aesKey = bArr;
    }

    @Override // it.aep_italia.vts.sdk.hce.crypto.VtsMessageCipher
    public ApduRequestMessage decryptPhase2Request(ApduRequestMessage apduRequestMessage) throws VtsExchangeException {
        return apduRequestMessage;
    }

    @Override // it.aep_italia.vts.sdk.hce.crypto.VtsMessageCipher
    public ApduRequestMessage decryptPhase3Request(ApduRequestMessage apduRequestMessage) throws VtsExchangeException {
        ApduRequestMessage apduRequestMessageM5466clone = apduRequestMessage.m5466clone();
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(apduRequestMessageM5466clone.getData(), 0, 3);
            byte[] bArrAesDecrypt = CryptoUtils.aesDecrypt(ByteUtils.extract(apduRequestMessageM5466clone.getData(), 3, apduRequestMessageM5466clone.getData().length), this.aesKey);
            byteArrayOutputStream.write(bArrAesDecrypt, 0, bArrAesDecrypt.length);
            apduRequestMessageM5466clone.setData(byteArrayOutputStream.toByteArray());
            return apduRequestMessageM5466clone;
        } catch (IOException unused) {
            throw new VtsExchangeException(VtsExchangeError.COULD_NOT_DECRYPT_DATA);
        }
    }

    @Override // it.aep_italia.vts.sdk.hce.crypto.VtsMessageCipher
    public ApduResponseMessage encryptPhase1Response(ApduResponseMessage apduResponseMessage) throws VtsExchangeException {
        return apduResponseMessage;
    }

    @Override // it.aep_italia.vts.sdk.hce.crypto.VtsMessageCipher
    public ApduResponseMessage encryptPhase2Response(ApduResponseMessage apduResponseMessage) {
        ApduResponseMessage apduResponseMessageM5467clone = apduResponseMessage.m5467clone();
        try {
            byte[] bArrAesEncrypt = CryptoUtils.aesEncrypt(ByteUtils.extract(apduResponseMessageM5467clone.getData(), 3, apduResponseMessageM5467clone.getData().length), this.aesKey);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(apduResponseMessageM5467clone.getData(), 0, 1);
            byteArrayOutputStream.write(bArrAesEncrypt.length + 1);
            byteArrayOutputStream.write(apduResponseMessageM5467clone.getData(), 2, 1);
            byteArrayOutputStream.write(bArrAesEncrypt, 0, bArrAesEncrypt.length);
            apduResponseMessageM5467clone.setData(byteArrayOutputStream.toByteArray());
            return apduResponseMessageM5467clone;
        } catch (IOException unused) {
            throw new VtsExchangeException(VtsExchangeError.COULD_NOT_ENCRYPT_DATA);
        }
    }

    @Override // it.aep_italia.vts.sdk.hce.crypto.VtsMessageCipher
    public ApduResponseMessage encryptPhase3Response(ApduResponseMessage apduResponseMessage) throws VtsExchangeException {
        return apduResponseMessage;
    }

    public static int MediaBrowserCompatMediaBrowserImplApi215() {
        int i = setQueue;
        int i2 = i % 5592101;
        setQueue = i + 1;
        if (i2 != 0) {
            return setSessionActivity;
        }
        int iMaxMemory = (int) Runtime.getRuntime().maxMemory();
        setSessionActivity = iMaxMemory;
        return iMaxMemory;
    }
}
