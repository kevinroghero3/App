package it.aep_italia.vts.sdk.dto.utils;

import it.aep_italia.vts.sdk.domain.enums.VtsReceiptType;

/* JADX INFO: loaded from: classes6.dex */
public class VtsReceiptDTO {
    private String a;
    private byte[] b;

    public VtsReceiptDTO() {
    }

    public VtsReceiptDTO(VtsReceiptType vtsReceiptType, byte[] bArr) {
        setReceiptType(vtsReceiptType);
        setReceiptContents(bArr);
    }

    public byte[] getReceiptContents() {
        return this.b;
    }

    public VtsReceiptType getReceiptType() {
        String str = this.a;
        if (str == null) {
            return null;
        }
        return VtsReceiptType.parse(str);
    }

    public void setReceiptContents(byte[] bArr) {
        this.b = bArr;
    }

    public void setReceiptType(VtsReceiptType vtsReceiptType) {
        this.a = vtsReceiptType == null ? null : vtsReceiptType.value();
    }
}
