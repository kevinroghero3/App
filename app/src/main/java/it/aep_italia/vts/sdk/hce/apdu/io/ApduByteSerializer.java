package it.aep_italia.vts.sdk.hce.apdu.io;

import it.aep_italia.vts.sdk.errors.VtsError;
import it.aep_italia.vts.sdk.errors.VtsException;
import it.aep_italia.vts.sdk.hce.apdu.ApduRequestMessage;
import it.aep_italia.vts.sdk.hce.apdu.ApduResponseMessage;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes6.dex */
public class ApduByteSerializer {
    public byte[] serialize(ApduRequestMessage apduRequestMessage) throws VtsException {
        if (apduRequestMessage == null) {
            throw new VtsException(VtsError.COULD_NOT_SERIALIZE_APDU, "Input message cannot be null.", new Object[0]);
        }
        byte[] lc = apduRequestMessage.getLc();
        byte[] le = apduRequestMessage.getLe();
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(lc.length + 4 + le.length + apduRequestMessage.getData().length);
        byteBufferAllocate.put(apduRequestMessage.getCLA());
        byteBufferAllocate.put(apduRequestMessage.getINS());
        byteBufferAllocate.put(apduRequestMessage.getP1());
        byteBufferAllocate.put(apduRequestMessage.getP2());
        byteBufferAllocate.put(lc);
        byteBufferAllocate.put(apduRequestMessage.getData());
        byteBufferAllocate.put(le);
        return byteBufferAllocate.array();
    }

    public byte[] serialize(ApduResponseMessage apduResponseMessage) throws VtsException {
        if (apduResponseMessage == null) {
            throw new VtsException(VtsError.COULD_NOT_SERIALIZE_APDU, "Input message cannot be null.", new Object[0]);
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(apduResponseMessage.getData().length + 2);
        byteBufferAllocate.put(apduResponseMessage.getData());
        byteBufferAllocate.put(apduResponseMessage.getSW1());
        byteBufferAllocate.put(apduResponseMessage.getSW2());
        return byteBufferAllocate.array();
    }
}
