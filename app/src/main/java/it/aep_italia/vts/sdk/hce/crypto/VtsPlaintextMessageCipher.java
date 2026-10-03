package it.aep_italia.vts.sdk.hce.crypto;

import it.aep_italia.vts.sdk.hce.VtsExchangeException;
import it.aep_italia.vts.sdk.hce.apdu.ApduRequestMessage;
import it.aep_italia.vts.sdk.hce.apdu.ApduResponseMessage;

/* JADX INFO: loaded from: classes6.dex */
public class VtsPlaintextMessageCipher implements VtsMessageCipher {
    @Override // it.aep_italia.vts.sdk.hce.crypto.VtsMessageCipher
    public ApduRequestMessage decryptPhase2Request(ApduRequestMessage apduRequestMessage) throws VtsExchangeException {
        return apduRequestMessage;
    }

    @Override // it.aep_italia.vts.sdk.hce.crypto.VtsMessageCipher
    public ApduRequestMessage decryptPhase3Request(ApduRequestMessage apduRequestMessage) throws VtsExchangeException {
        return apduRequestMessage;
    }

    @Override // it.aep_italia.vts.sdk.hce.crypto.VtsMessageCipher
    public ApduResponseMessage encryptPhase1Response(ApduResponseMessage apduResponseMessage) throws VtsExchangeException {
        return apduResponseMessage;
    }

    @Override // it.aep_italia.vts.sdk.hce.crypto.VtsMessageCipher
    public ApduResponseMessage encryptPhase2Response(ApduResponseMessage apduResponseMessage) throws VtsExchangeException {
        return apduResponseMessage;
    }

    @Override // it.aep_italia.vts.sdk.hce.crypto.VtsMessageCipher
    public ApduResponseMessage encryptPhase3Response(ApduResponseMessage apduResponseMessage) throws VtsExchangeException {
        return apduResponseMessage;
    }
}
