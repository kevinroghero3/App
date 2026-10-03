package it.aep_italia.vts.sdk.dto.domain;

import org.simpleframework.xml.Attribute;

/* JADX INFO: loaded from: classes6.dex */
public class VtsContractDTO {

    @Attribute(name = "ContractUID")
    private String a;

    @Attribute(name = "VTokenUID")
    private String b;

    @Attribute(name = "SellDateTime")
    private String c;

    @Attribute(name = "ReceiptVTID", required = false)
    private String d;

    @Attribute(name = "ReceiptType", required = false)
    private String e;

    public String getContractUID() {
        return this.a;
    }

    public String getReceiptType() {
        return this.e;
    }

    public String getReceiptVTID() {
        return this.d;
    }

    public String getSellDateTime() {
        return this.c;
    }

    public String getVTokenUID() {
        return this.b;
    }

    public void setContractUID(String str) {
        this.a = str;
    }

    public void setReceiptType(String str) {
        this.e = str;
    }

    public void setReceiptVTID(String str) {
        this.d = str;
    }

    public void setSellDateTime(String str) {
        this.c = str;
    }

    public void setVTokenUID(String str) {
        this.b = str;
    }
}
