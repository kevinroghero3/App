package it.aep_italia.vts.sdk.hce.crypto;

import it.aep_italia.vts.sdk.hce.VtsExchangeException;
import it.aep_italia.vts.sdk.hce.apdu.ApduRequestMessage;
import it.aep_italia.vts.sdk.hce.apdu.ApduResponseMessage;

/* JADX INFO: loaded from: classes3.dex */
public interface VtsMessageCipher {
    ApduRequestMessage decryptPhase2Request(ApduRequestMessage apduRequestMessage) throws VtsExchangeException;

    ApduRequestMessage decryptPhase3Request(ApduRequestMessage apduRequestMessage) throws VtsExchangeException;

    ApduResponseMessage encryptPhase1Response(ApduResponseMessage apduResponseMessage) throws VtsExchangeException;

    ApduResponseMessage encryptPhase2Response(ApduResponseMessage apduResponseMessage) throws VtsExchangeException;

    ApduResponseMessage encryptPhase3Response(ApduResponseMessage apduResponseMessage) throws VtsExchangeException;
}
