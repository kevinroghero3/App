package it.aep_italia.vts.sdk.dto.domain;

import org.simpleframework.xml.Attribute;

/* JADX INFO: loaded from: classes6.dex */
public class VtsShoppingItemDTO {

    @Attribute(name = "SellProposalId")
    private long a;

    @Attribute(name = "Quantity")
    private int b;

    @Attribute(name = "Description", required = false)
    private String c;

    @Attribute(name = "SubDescr01", required = false)
    private String d;

    @Attribute(name = "SubDescr02", required = false)
    private String e;

    @Attribute(name = "UnitPriceEuroCent")
    private int f;

    @Attribute(name = "PriceEuroCent")
    private int g;

    public String getDescription() {
        return this.c;
    }

    public int getPriceEuroCent() {
        return this.g;
    }

    public int getQuantity() {
        return this.b;
    }

    public long getSellProposalID() {
        return this.a;
    }

    public String getSubDescription1() {
        return this.d;
    }

    public String getSubDescription2() {
        return this.e;
    }

    public int getUnitPriceEuroCent() {
        return this.f;
    }

    public void setDescription(String str) {
        this.c = str;
    }

    public void setPriceEuroCent(int i) {
        this.g = i;
    }

    public void setQuantity(int i) {
        this.b = i;
    }

    public void setSellProposalID(long j) {
        this.a = j;
    }

    public void setSubDescription1(String str) {
        this.d = str;
    }

    public void setSubDescription2(String str) {
        this.e = str;
    }

    public void setUnitPriceEuroCent(int i) {
        this.f = i;
    }
}
