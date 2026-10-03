package it.aep_italia.vts.sdk.dto.domain.token.payload;

import org.simpleframework.xml.Attribute;

/* JADX INFO: loaded from: classes6.dex */
public class VtsVTokenPayloadEnvironmentDTO {

    @Attribute(name = "CardStatus")
    private int a;

    @Attribute(name = "HolderId", required = false)
    private int b;

    @Attribute(name = "HolderFiscalCode", required = false)
    private String c;

    @Attribute(name = "CardIssueDateTime", required = false)
    private String d;

    @Attribute(name = "HolderProfileId", required = false)
    private int e;

    @Attribute(name = "HolderProfileDescription", required = false)
    private String f;

    @Attribute(name = "HolderProfileDuration", required = false)
    private int g;

    @Attribute(name = "IssuerId", required = false)
    private int h;

    @Attribute(name = "IssuerDescription", required = false)
    private String i;

    @Attribute(name = "CardEndValidityDateTime", required = false)
    private String j;

    @Attribute(name = "HolderProfileEndValidityDateTime", required = false)
    private String k;

    public String getCardEndValidityDateTime() {
        return this.j;
    }

    public String getCardIssueDateTime() {
        return this.d;
    }

    public int getCardStatus() {
        return this.a;
    }

    public String getHolderFiscalCode() {
        return this.c;
    }

    public int getHolderID() {
        return this.b;
    }

    public String getHolderProfileDescription() {
        return this.f;
    }

    public int getHolderProfileDuration() {
        return this.g;
    }

    public String getHolderProfileEndValidityDateTime() {
        return this.k;
    }

    public int getHolderProfileID() {
        return this.e;
    }

    public String getIssuerDescription() {
        return this.i;
    }

    public int getIssuerID() {
        return this.h;
    }

    public void setCardEndValidityDateTime(String str) {
        this.j = str;
    }

    public void setCardIssueDateTime(String str) {
        this.d = str;
    }

    public void setCardStatus(int i) {
        this.a = i;
    }

    public void setHolderFiscalCode(String str) {
        this.c = str;
    }

    public void setHolderID(int i) {
        this.b = i;
    }

    public void setHolderProfileDescription(String str) {
        this.f = str;
    }

    public void setHolderProfileDuration(int i) {
        this.g = i;
    }

    public void setHolderProfileID(int i) {
        this.e = i;
    }

    public void setHolderProfileValidityDateTime(String str) {
        this.k = str;
    }

    public void setIssuerDescription(String str) {
        this.i = str;
    }

    public void setIssuerID(int i) {
        this.h = i;
    }
}
