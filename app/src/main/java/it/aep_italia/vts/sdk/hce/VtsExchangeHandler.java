package it.aep_italia.vts.sdk.hce;

import it.aep_italia.vts.sdk.hce.apdu.ApduRequestMessage;
import it.aep_italia.vts.sdk.hce.apdu.ApduResponseMessage;

/* JADX INFO: loaded from: classes6.dex */
public interface VtsExchangeHandler {
    ApduResponseMessage generatePhase0Response() throws VtsExchangeException;

    ApduResponseMessage generatePhase1Response() throws VtsExchangeException;

    ApduResponseMessage generatePhase2Response() throws VtsExchangeException;

    ApduResponseMessage generatePhase3Response() throws VtsExchangeException;

    void handlePhase0Request(ApduRequestMessage apduRequestMessage);

    void handlePhase1Request(ApduRequestMessage apduRequestMessage);

    void handlePhase2Request(ApduRequestMessage apduRequestMessage);

    void handlePhase3Request(ApduRequestMessage apduRequestMessage);

    boolean isExchangeCompleted();
}
