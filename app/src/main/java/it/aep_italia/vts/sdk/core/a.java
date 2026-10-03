package it.aep_italia.vts.sdk.core;

import it.aep_italia.vts.sdk.errors.VtsError;
import it.aep_italia.vts.sdk.hce.VtsExchangeError;
import it.aep_italia.vts.sdk.hce.VtsExchangeException;
import it.aep_italia.vts.sdk.hce.VtsExchangeHandler;
import it.aep_italia.vts.sdk.hce.apdu.ApduRequestMessage;
import it.aep_italia.vts.sdk.hce.apdu.ApduResponseMessage;
import it.aep_italia.vts.sdk.hce.apdu.io.ApduResponseBuilder;
import it.aep_italia.vts.sdk.hce.crypto.VtsAesMessageCipher;
import it.aep_italia.vts.sdk.hce.crypto.VtsMessageCipher;
import it.aep_italia.vts.sdk.hce.crypto.VtsPlaintextMessageCipher;
import it.aep_italia.vts.sdk.utils.ByteUtils;
import it.aep_italia.vts.sdk.utils.ValidationUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
final class a implements VtsExchangeHandler {
    private byte[] a;
    private byte[] b;
    private VtsMessageCipher c;
    private int d = -1;
    private ApduRequestMessage e = null;
    private ByteArrayOutputStream f = new ByteArrayOutputStream();
    private byte[][] g;
    private VtsSdk h;

    a(VtsSdk vtsSdk, byte[][] bArr) {
        ValidationUtils.assertNonNull(vtsSdk, VtsError.COULD_NOT_INITIALIZE_HANDLER, "No SDK instance provided", new Object[0]);
        this.h = vtsSdk;
        this.b = new byte[4];
        this.g = bArr;
    }

    private void a(ApduRequestMessage apduRequestMessage) {
        byte b = ByteUtils.extract(apduRequestMessage.getData(), 2, 1)[0];
        if (b == 0) {
            this.c = new VtsPlaintextMessageCipher();
            return;
        }
        if (b != 1) {
            throw new VtsExchangeException(VtsExchangeError.UNSUPPORTED_CYPHER);
        }
        int iBytesToInt = ByteUtils.bytesToInt(ByteUtils.extract(apduRequestMessage.getData(), 3, 2));
        byte[][] bArr = this.g;
        if (bArr == null || bArr.length < iBytesToInt + 1) {
            throw new VtsExchangeException(VtsExchangeError.KEY_NOT_FOUND);
        }
        this.c = new VtsAesMessageCipher(bArr[iBytesToInt]);
    }

    private void a(byte[] bArr) throws VtsExchangeException {
        try {
            this.h.d().a(bArr);
        } catch (Exception e) {
            VtsLog.e(e, "Could not save VToken", new Object[0]);
            throw new VtsExchangeException(VtsExchangeError.EXCHANGE_FAILED);
        }
    }

    private byte[] a() throws VtsExchangeException {
        try {
            long activeVToken = this.h.getActiveVToken();
            if (activeVToken != 0) {
                return this.h.a(activeVToken);
            }
            throw new VtsExchangeException(VtsExchangeError.NO_TICKET_SELECTED);
        } catch (VtsExchangeException e) {
            throw e;
        } catch (Exception e2) {
            VtsLog.e(e2, "Could not load VToken", new Object[0]);
            throw new VtsExchangeException(VtsExchangeError.NO_TICKET_SELECTED);
        }
    }

    @Override // it.aep_italia.vts.sdk.hce.VtsExchangeHandler
    public ApduResponseMessage generatePhase0Response() throws VtsExchangeException {
        return ApduResponseBuilder.builder().appendData("6F").appendData("2A").appendData("84").appendData((byte) this.e.getData().length).appendData(this.e.getData()).appendData("A5").appendData("16").appendData("BF 0C").appendData("13").appendData("C7").appendData("08").appendData(ByteUtils.longToBytes(this.h.getDeviceUID(), 0)).appendData("53").appendData("07").appendData("01").appendData("01").appendData(ByteUtils.longToBytes(this.a.length, 6)).appendData("10").appendData("01").appendData(VtsSdk.SDK_VERSION.getShortString()).SW1("90").SW2("00").build();
    }

    @Override // it.aep_italia.vts.sdk.hce.VtsExchangeHandler
    public ApduResponseMessage generatePhase1Response() throws VtsExchangeException {
        return this.c.encryptPhase1Response(ApduResponseBuilder.builder().appendData("80").appendData("12").appendData("03").appendData("01").SW1("90").SW2("00").build());
    }

    @Override // it.aep_italia.vts.sdk.hce.VtsExchangeHandler
    public ApduResponseMessage generatePhase2Response() throws VtsExchangeException {
        int i = this.d;
        if (i != 1 && i != 2) {
            throw new VtsExchangeException(VtsExchangeError.OUT_OF_ORDER_COMMAND, "Expected a phase %d command, received a phase 2 command", Integer.valueOf(this.d + 1));
        }
        ApduRequestMessage apduRequestMessage = this.e;
        int i2 = this.c instanceof VtsPlaintextMessageCipher ? 248 : 235;
        int iByteToInt = (ByteUtils.byteToInt(apduRequestMessage.getP1()) << 8) + ByteUtils.byteToInt(apduRequestMessage.getP2());
        int iByteToInt2 = ByteUtils.byteToInt(apduRequestMessage.getData()[2]);
        if (iByteToInt2 == 0) {
            iByteToInt2 = Math.min(i2, this.a.length);
        }
        if (iByteToInt >= this.a.length) {
            throw new VtsExchangeException(VtsExchangeError.WRONG_LE_FIELD, "Cannot read (read offset %d is greater than token size %d)", Integer.valueOf(iByteToInt), Integer.valueOf(this.a.length));
        }
        if (apduRequestMessage.getData()[1] == 0 && iByteToInt2 < this.a.length) {
            throw new VtsExchangeException(VtsExchangeError.WRONG_LE_FIELD, "Cannot read (performing an unpaginated read with read size %d smaller than token size %d)", Integer.valueOf(iByteToInt2), Integer.valueOf(this.a.length));
        }
        if (iByteToInt2 > i2) {
            throw new VtsExchangeException(VtsExchangeError.WRONG_LE_FIELD, "Cannot read (read size %d is greater than token size %d)", Integer.valueOf(iByteToInt2), Integer.valueOf(this.a.length));
        }
        byte[] bArrExtract = ByteUtils.extract(this.a, iByteToInt, iByteToInt2);
        return this.c.encryptPhase2Response(ApduResponseBuilder.builder().SW1("90").SW2("00").appendData("80").appendData((byte) (bArrExtract.length + 5)).appendData((byte) bArrExtract.length).appendData(this.b).appendData(bArrExtract).build());
    }

    @Override // it.aep_italia.vts.sdk.hce.VtsExchangeHandler
    public ApduResponseMessage generatePhase3Response() throws VtsExchangeException {
        int i = this.d;
        if (i != 2 && i != 3) {
            throw new VtsExchangeException(VtsExchangeError.OUT_OF_ORDER_COMMAND, "Expected a phase %d command, received a phase 3 command", Integer.valueOf(this.d + 1));
        }
        if (ByteUtils.byteToInt(this.e.getData()[0]) == 1) {
            this.d = 4;
        }
        return this.c.encryptPhase3Response(ApduResponseBuilder.builder().SW1("90").SW2("00").appendData("80").appendData("04").appendData(this.b).build());
    }

    @Override // it.aep_italia.vts.sdk.hce.VtsExchangeHandler
    public void handlePhase0Request(ApduRequestMessage apduRequestMessage) {
        if (this.d != -1) {
            throw new VtsExchangeException(VtsExchangeError.OUT_OF_ORDER_COMMAND, "Expected a phase %d command, received a phase 0 command", Integer.valueOf(this.d + 1));
        }
        this.e = apduRequestMessage;
        this.d = 0;
        this.a = a();
    }

    @Override // it.aep_italia.vts.sdk.hce.VtsExchangeHandler
    public void handlePhase1Request(ApduRequestMessage apduRequestMessage) {
        if (this.d != 0) {
            throw new VtsExchangeException(VtsExchangeError.OUT_OF_ORDER_COMMAND, "Expected a phase %d command, received a phase 1 command", Integer.valueOf(this.d + 1));
        }
        if (apduRequestMessage.getData().length != 5) {
            throw new VtsExchangeException(VtsExchangeError.WRONG_COMMAND_LENGTH, "Expected a 5-byte long data field, got %d bytes", Integer.valueOf(apduRequestMessage.getData().length));
        }
        if (apduRequestMessage.getData()[2] != 0 && apduRequestMessage.getData()[2] != 1) {
            throw new VtsExchangeException(VtsExchangeError.UNSUPPORTED_CYPHER, "Unsupported cypher requested (supported: plaintext, AES; requested string: %s)", ByteUtils.byteToHexString(apduRequestMessage.getData()[2]));
        }
        byte b = apduRequestMessage.getData()[0];
        byte b2 = apduRequestMessage.getData()[1];
        if (b < 1 || b > 23 || b2 < 1 || b2 > 3 || (b == 2 && b2 > 2)) {
            throw new VtsExchangeException(VtsExchangeError.WRONG_LE_FIELD, "Unrecognized device type/subtype (got type: %s, subtype: %s)", ByteUtils.byteToHexString(b), ByteUtils.byteToHexString(b2));
        }
        this.e = apduRequestMessage;
        this.d = 1;
        a(apduRequestMessage);
    }

    @Override // it.aep_italia.vts.sdk.hce.VtsExchangeHandler
    public void handlePhase2Request(ApduRequestMessage apduRequestMessage) {
        int i = this.d;
        if (i != 1 && i != 2) {
            throw new VtsExchangeException(VtsExchangeError.OUT_OF_ORDER_COMMAND, "Expected a phase %d command, received a phase 2 command", Integer.valueOf(this.d + 1));
        }
        if (apduRequestMessage.getData().length != 7) {
            throw new VtsExchangeException(VtsExchangeError.WRONG_COMMAND_LENGTH, "Expected a 7-byte long data field, got %d bytes", Integer.valueOf(apduRequestMessage.getData().length));
        }
        if (apduRequestMessage.getData()[0] != 1 && apduRequestMessage.getData()[0] != 2) {
            throw new VtsExchangeException(VtsExchangeError.WRONG_LE_FIELD, "Unknown operation mode (got string: %s)", ByteUtils.byteToHexString(apduRequestMessage.getData()[0]));
        }
        if (apduRequestMessage.getData()[1] != 0 && apduRequestMessage.getData()[1] != 1) {
            throw new VtsExchangeException(VtsExchangeError.WRONG_LE_FIELD, "Unknown read mode (got string: %s)", ByteUtils.byteToHexString(apduRequestMessage.getData()[1]));
        }
        this.e = this.c.decryptPhase2Request(apduRequestMessage);
        this.d = 2;
        this.b = ByteUtils.extract(apduRequestMessage.getData(), 3, 4);
    }

    @Override // it.aep_italia.vts.sdk.hce.VtsExchangeHandler
    public void handlePhase3Request(ApduRequestMessage apduRequestMessage) {
        int i = this.d;
        if (i != 2 && i != 3) {
            throw new VtsExchangeException(VtsExchangeError.OUT_OF_ORDER_COMMAND, "Expected a phase %d command, received a phase 3 command", Integer.valueOf(this.d + 1));
        }
        if (apduRequestMessage.getData().length < 7) {
            throw new VtsExchangeException(VtsExchangeError.WRONG_COMMAND_LENGTH, "Expected a data field of at least 7 bytes, got %d bytes", Integer.valueOf(apduRequestMessage.getData().length));
        }
        ApduRequestMessage apduRequestMessageDecryptPhase3Request = this.c.decryptPhase3Request(apduRequestMessage);
        int iByteToInt = ByteUtils.byteToInt(apduRequestMessageDecryptPhase3Request.getData()[0]);
        if (iByteToInt != 0 && iByteToInt != 1) {
            throw new VtsExchangeException(VtsExchangeError.WRONG_LE_FIELD, "Unknown completion flag string (got string: %s)", ByteUtils.byteToHexString(apduRequestMessageDecryptPhase3Request.getData()[0]));
        }
        int iByteToInt2 = ByteUtils.byteToInt(apduRequestMessageDecryptPhase3Request.getData()[1]);
        if (iByteToInt2 != 0 && iByteToInt2 != 1) {
            throw new VtsExchangeException(VtsExchangeError.WRONG_LE_FIELD, "Unknown write mode string (got string: %s)", ByteUtils.byteToHexString(apduRequestMessageDecryptPhase3Request.getData()[1]));
        }
        int iByteToInt3 = ByteUtils.byteToInt(apduRequestMessageDecryptPhase3Request.getData()[2]);
        int i2 = iByteToInt3 + 7;
        if (apduRequestMessageDecryptPhase3Request.getData().length < i2) {
            throw new VtsExchangeException(VtsExchangeError.WRONG_LE_FIELD, "Wrong unencrypted size (expected a data field of at least %d bytes, got %d bytes)", Integer.valueOf(i2), Integer.valueOf(apduRequestMessageDecryptPhase3Request.getData().length));
        }
        this.e = apduRequestMessageDecryptPhase3Request;
        this.d = 2;
        this.b = ByteUtils.extract(apduRequestMessageDecryptPhase3Request.getData(), 3, 4);
        int iByteToInt4 = (ByteUtils.byteToInt(apduRequestMessageDecryptPhase3Request.getP1()) << 8) + ByteUtils.byteToInt(apduRequestMessageDecryptPhase3Request.getP2());
        try {
            byte[] bArrExtract = ByteUtils.extract(apduRequestMessageDecryptPhase3Request.getData(), 7, iByteToInt3);
            if (this.f.size() == iByteToInt4) {
                this.f.write(bArrExtract);
            } else {
                byte[] byteArray = this.f.toByteArray();
                this.f.reset();
                this.f.write(ByteUtils.extract(byteArray, 0, iByteToInt4));
                this.f.write(bArrExtract);
                this.f.write(ByteUtils.extract(byteArray, iByteToInt4 + bArrExtract.length, 65535));
            }
            if (iByteToInt == 1) {
                a(this.f.toByteArray());
            }
        } catch (IOException unused) {
            throw new VtsExchangeException(VtsExchangeError.COULD_NOT_PARSE_REQUEST);
        }
    }

    @Override // it.aep_italia.vts.sdk.hce.VtsExchangeHandler
    public boolean isExchangeCompleted() {
        return this.d == 4;
    }
}
