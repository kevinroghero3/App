package it.aep_italia.vts.sdk.dto.domain;

import org.simpleframework.xml.Attribute;

/* JADX INFO: loaded from: classes6.dex */
public class SbeCustomerDTO {

    @Attribute(name = "CustomerId")
    private long a;

    @Attribute(name = "LastName")
    private String b;

    @Attribute(name = "FirstName")
    private String c;

    @Attribute(name = "FiscalCode")
    private String d;

    @Attribute(name = "BirthDate")
    private String e;

    @Attribute(name = "Sex")
    private String f;

    @Attribute(name = "Status")
    private String g;

    @Attribute(name = "EMail")
    private String h;

    @Attribute(name = "InsertDate")
    private String i;

    @Attribute(name = "LastUpdate")
    private String j;

    @Attribute(name = "PhotoImage")
    private String k;

    @Attribute(name = "PhoneNumber")
    private String l;

    @Attribute(name = "SecPhoneNumber")
    private String m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Attribute(name = "Address")
    private String f132n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Attribute(name = "House")
    private String f133o;

    @Attribute(name = "Locality")
    private String p;

    @Attribute(name = "City")
    private String q;

    @Attribute(name = "District")
    private String r;

    @Attribute(name = "ZipCode")
    private String s;

    @Attribute(name = "BirthPlace")
    private String t;

    @Attribute(name = "Nationality")
    private String u;

    public String getAddress() {
        return this.f132n;
    }

    public String getBirthDate() {
        return this.e;
    }

    public String getBirthPlace() {
        return this.t;
    }

    public String getCity() {
        return this.q;
    }

    public long getCustomerId() {
        return this.a;
    }

    public String getDistrict() {
        return this.r;
    }

    public String getFirstName() {
        return this.c;
    }

    public String getFiscalCode() {
        return this.d;
    }

    public String getHouse() {
        return this.f133o;
    }

    public String getInsertDate() {
        return this.i;
    }

    public String getLastName() {
        return this.b;
    }

    public String getLastUpdate() {
        return this.j;
    }

    public String getLocality() {
        return this.p;
    }

    public String getNationality() {
        return this.u;
    }

    public String getPhoneNumber() {
        return this.l;
    }

    public String getPhotoImage() {
        return this.k;
    }

    public String getSecPhoneNumber() {
        return this.m;
    }

    public String getSex() {
        return this.f;
    }

    public String getStatus() {
        return this.g;
    }

    public String getZipCode() {
        return this.s;
    }

    public String geteMail() {
        return this.h;
    }

    public void setAddress(String str) {
        this.f132n = str;
    }

    public void setBirthDate(String str) {
        this.e = str;
    }

    public void setBirthPlace(String str) {
        this.t = str;
    }

    public void setCity(String str) {
        this.q = str;
    }

    public void setCustomerId(long j) {
        this.a = j;
    }

    public void setDistrict(String str) {
        this.r = str;
    }

    public void setFirstName(String str) {
        this.c = str;
    }

    public void setFiscalCode(String str) {
        this.d = str;
    }

    public void setHouse(String str) {
        this.f133o = str;
    }

    public void setInsertDate(String str) {
        this.i = str;
    }

    public void setLastName(String str) {
        this.b = str;
    }

    public void setLastUpdate(String str) {
        this.j = str;
    }

    public void setLocality(String str) {
        this.p = str;
    }

    public void setNationality(String str) {
        this.u = str;
    }

    public void setPhoneNumber(String str) {
        this.l = str;
    }

    public void setPhotoImage(String str) {
        this.k = str;
    }

    public void setSecPhoneNumber(String str) {
        this.m = str;
    }

    public void setSex(String str) {
        this.f = str;
    }

    public void setStatus(String str) {
        this.g = str;
    }

    public void setZipCode(String str) {
        this.s = str;
    }

    public void seteMail(String str) {
        this.h = str;
    }
}
