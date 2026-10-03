package it.aep_italia.vts.sdk.dto.domain;

import org.simpleframework.xml.Attribute;

/* JADX INFO: loaded from: classes6.dex */
public class VtsOperatorDTO {

    @Attribute(name = "OperatorId")
    private int a;

    @Attribute(name = "OperatorDescription")
    private String b;

    @Attribute(name = "OperatorShortDescription")
    private String c;

    @Attribute(name = "FiscalCode")
    private String d;

    @Attribute(name = "WebSiteUrl")
    private String e;

    @Attribute(name = "Address")
    private String f;

    @Attribute(name = "City")
    private String g;

    @Attribute(name = "ZipCode")
    private String h;

    @Attribute(name = "IsOperator")
    private boolean i;

    @Attribute(name = "IsProvider")
    private boolean j;

    @Attribute(name = "SellEnabled")
    private boolean k;

    @Attribute(name = "LogoImageSmallVTID")
    private String l;

    @Attribute(name = "LogoImageLargeVTID")
    private String m;

    public String getAddress() {
        return this.f;
    }

    public String getCity() {
        return this.g;
    }

    public String getFiscalCode() {
        return this.d;
    }

    public String getLogoImageLargeVTID() {
        return this.m;
    }

    public String getLogoImageSmallVTID() {
        return this.l;
    }

    public String getOperatorDescription() {
        return this.b;
    }

    public int getOperatorID() {
        return this.a;
    }

    public String getOperatorShortDescription() {
        return this.c;
    }

    public String getWebSiteUrl() {
        return this.e;
    }

    public String getZipCode() {
        return this.h;
    }

    public boolean isOperator() {
        return this.i;
    }

    public boolean isProvider() {
        return this.j;
    }

    public boolean isSellEnabled() {
        return this.k;
    }

    public void setAddress(String str) {
        this.f = str;
    }

    public void setCity(String str) {
        this.g = str;
    }

    public void setFiscalCode(String str) {
        this.d = str;
    }

    public void setLogoImageLargeVTID(String str) {
        this.m = str;
    }

    public void setLogoImageSmallVTID(String str) {
        this.l = str;
    }

    public void setOperator(boolean z) {
        this.i = z;
    }

    public void setOperatorDescription(String str) {
        this.b = str;
    }

    public void setOperatorID(int i) {
        this.a = i;
    }

    public void setOperatorShortDescription(String str) {
        this.c = str;
    }

    public void setProvider(boolean z) {
        this.j = z;
    }

    public void setSellEnabled(boolean z) {
        this.k = z;
    }

    public void setWebSiteUrl(String str) {
        this.e = str;
    }

    public void setZipCode(String str) {
        this.h = str;
    }
}
