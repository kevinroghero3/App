package it.aep_italia.vts.sdk.dto.domain;

import org.simpleframework.xml.Attribute;

/* JADX INFO: loaded from: classes6.dex */
public class VtsSellProposalDTO {

    @Attribute(name = "SellProposalId")
    private long a;

    @Attribute(name = "PriceEuroCent")
    private int b;

    @Attribute(name = "StartValidityDateTime", required = false)
    private String c;

    @Attribute(name = "EndValidityDateTime")
    private String d;

    @Attribute(name = "ContractData", required = false)
    private String e;

    @Attribute(name = "ContractTypeDescription", required = false)
    private String f;

    @Attribute(name = "ContractDurationDescription", required = false)
    private String g;

    public String getContractData() {
        return this.e;
    }

    public String getContractDurationDescription() {
        return this.g;
    }

    public String getContractTypeDescription() {
        return this.f;
    }

    public String getEndValidityDateTime() {
        return this.d;
    }

    public int getPriceEuroCent() {
        return this.b;
    }

    public long getSellProposalID() {
        return this.a;
    }

    public String getStartValidityDateTime() {
        return this.c;
    }

    public void setContractData(String str) {
        this.e = str;
    }

    public void setContractDurationDescription(String str) {
        this.g = str;
    }

    public void setContractTypeDescription(String str) {
        this.f = str;
    }

    public void setEndValidityDateTime(String str) {
        this.d = str;
    }

    public void setPriceEuroCent(int i) {
        this.b = i;
    }

    public void setSellProposalID(int i) {
        this.a = i;
    }

    public void setStartValidityDateTime(String str) {
        this.c = str;
    }
}
