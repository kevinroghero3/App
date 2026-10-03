package it.aep_italia.vts.sdk.dto.soap.functions.requests;

import it.aep_italia.vts.sdk.domain.SbeCustomer;
import it.aep_italia.vts.sdk.dto.soap.VtsSoapEnvelope;
import it.aep_italia.vts.sdk.dto.soap.functions.VtsSoapFunctionPayload;
import java.util.Locale;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

/* JADX INFO: loaded from: classes6.dex */
@NamespaceList({@Namespace(prefix = "vts", reference = VtsSoapEnvelope.NAMESPACE_AEP)})
@Root(name = "vts:VTS_RequestFunction")
public class PutCustomerInput implements VtsSoapFunctionPayload {

    @Attribute(name = "InsertMode")
    @Path("vts:Body/vts:Parameters")
    private String b;

    @Attribute(name = "CustomerId", required = true)
    @Path("vts:Body/vts:Parameters/vts:Customer")
    private long c;

    @Attribute(name = "LastName", required = false)
    @Path("vts:Body/vts:Parameters/vts:Customer")
    private String d;

    @Attribute(name = "FirstName", required = false)
    @Path("vts:Body/vts:Parameters/vts:Customer")
    private String e;

    @Attribute(name = "FiscalCode", required = false)
    @Path("vts:Body/vts:Parameters/vts:Customer")
    private String f;

    @Attribute(name = "BirthDate", required = false)
    @Path("vts:Body/vts:Parameters/vts:Customer")
    private String g;

    @Attribute(name = "Sex", required = false)
    @Path("vts:Body/vts:Parameters/vts:Customer")
    private String h;

    @Attribute(name = "EMail", required = false)
    @Path("vts:Body/vts:Parameters/vts:Customer")
    private String j;

    @Attribute(name = "PhotoImage", required = false)
    @Path("vts:Body/vts:Parameters/vts:Customer")
    private String k;

    @Attribute(name = "PhoneNumber", required = false)
    @Path("vts:Body/vts:Parameters/vts:Customer")
    private String l;

    @Attribute(name = "SecPhoneNumber", required = false)
    @Path("vts:Body/vts:Parameters/vts:Customer")
    private String m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Attribute(name = "Address", required = false)
    @Path("vts:Body/vts:Parameters/vts:Customer")
    private String f140n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Attribute(name = "House", required = false)
    @Path("vts:Body/vts:Parameters/vts:Customer")
    private String f141o;

    @Attribute(name = "Locality", required = false)
    @Path("vts:Body/vts:Parameters/vts:Customer")
    private String p;

    @Attribute(name = "City", required = false)
    @Path("vts:Body/vts:Parameters/vts:Customer")
    private String q;

    @Attribute(name = "District", required = false)
    @Path("vts:Body/vts:Parameters/vts:Customer")
    private String r;

    @Attribute(name = "ZipCode", required = false)
    @Path("vts:Body/vts:Parameters/vts:Customer")
    private String s;

    @Attribute(name = "BirthPlace", required = false)
    @Path("vts:Body/vts:Parameters/vts:Customer")
    private String t;

    @Attribute(name = "Nationality", required = false)
    @Path("vts:Body/vts:Parameters/vts:Customer")
    private String u;

    @Attribute(name = "Version")
    @Path("vts:Header")
    private int a = 1;

    @Attribute(name = "Status", required = false)
    @Path("vts:Body/vts:Parameters/vts:Customer")
    private String i = "ACTIVE";

    public PutCustomerInput(long j, SbeCustomer sbeCustomer) {
        setInsertMode(j == 0 ? "insert" : "update");
        setCustomerId(sbeCustomer.getCustomerId());
        setLastName(sbeCustomer.getLastName().isEmpty() ? null : sbeCustomer.getLastName());
        setFirstName(sbeCustomer.getFirstName().isEmpty() ? null : sbeCustomer.getFirstName());
        setFiscalCode(sbeCustomer.getFiscalCode().isEmpty() ? null : sbeCustomer.getFiscalCode());
        setBirthDate(sbeCustomer.getBirthDate().isEmpty() ? null : sbeCustomer.getBirthDate());
        setSex(sbeCustomer.getSex().isEmpty() ? null : sbeCustomer.getSex());
        setStatus(sbeCustomer.getStatus().isEmpty() ? null : sbeCustomer.getStatus());
        seteMail(sbeCustomer.geteMail().isEmpty() ? null : sbeCustomer.geteMail());
        setPhotoImage(sbeCustomer.getPhotoImage().isEmpty() ? null : sbeCustomer.getPhotoImage());
        setPhoneNumber(sbeCustomer.getPhoneNumber().isEmpty() ? null : sbeCustomer.getPhoneNumber());
        setSecPhoneNumber(sbeCustomer.getSecPhoneNumber().isEmpty() ? null : sbeCustomer.getSecPhoneNumber());
        setAddress(sbeCustomer.getAddress().isEmpty() ? null : sbeCustomer.getAddress());
        setHouse(sbeCustomer.getHouse().isEmpty() ? null : sbeCustomer.getHouse());
        setLocality(sbeCustomer.getLocality().isEmpty() ? null : sbeCustomer.getLocality());
        setCity(sbeCustomer.getCity().isEmpty() ? null : sbeCustomer.getCity());
        setDistrict(sbeCustomer.getDistrict().isEmpty() ? null : sbeCustomer.getDistrict());
        setZipCode(sbeCustomer.getZipCode().isEmpty() ? null : sbeCustomer.getZipCode());
        setBirthPlace(sbeCustomer.getBirthPlace().isEmpty() ? null : sbeCustomer.getBirthPlace());
        setNationality(sbeCustomer.getNationality().isEmpty() ? null : sbeCustomer.getNationality());
    }

    public String getAddress() {
        return this.f140n;
    }

    public String getBirthDate() {
        return this.g;
    }

    public String getBirthPlace() {
        return this.t;
    }

    public String getCity() {
        return this.q;
    }

    public long getCustomerId() {
        return this.c;
    }

    public String getDistrict() {
        return this.r;
    }

    public String getFirstName() {
        return this.e;
    }

    public String getFiscalCode() {
        return this.f;
    }

    @Override // it.aep_italia.vts.sdk.dto.soap.functions.VtsSoapFunctionPayload
    public String getFunctionName() {
        return "vts_FuncPutCustomers";
    }

    public String getHouse() {
        return this.f141o;
    }

    public String getInsertMode() {
        return this.b;
    }

    public String getLastName() {
        return this.d;
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
        return this.h;
    }

    public String getStatus() {
        return "ACTIVE";
    }

    @Override // it.aep_italia.vts.sdk.dto.soap.functions.VtsSoapFunctionPayload
    public String getStringifiedParameters() {
        return String.format(Locale.ITALY, "InsertMode: %s", this.b);
    }

    public String getZipCode() {
        return this.s;
    }

    public String geteMail() {
        return this.j;
    }

    public void setAddress(String str) {
        this.f140n = str;
    }

    public void setBirthDate(String str) {
        this.g = str;
    }

    public void setBirthPlace(String str) {
        this.t = str;
    }

    public void setCity(String str) {
        this.q = str;
    }

    public void setCustomerId(long j) {
        this.c = j;
    }

    public void setDistrict(String str) {
        this.r = str;
    }

    public void setFirstName(String str) {
        this.e = str;
    }

    public void setFiscalCode(String str) {
        this.f = str;
    }

    public void setHouse(String str) {
        this.f141o = str;
    }

    public void setInsertMode(String str) {
        this.b = str;
    }

    public void setLastName(String str) {
        this.d = str;
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
        this.h = str;
    }

    public void setStatus(String str) {
        this.i = str;
    }

    public void setZipCode(String str) {
        this.s = str;
    }

    public void seteMail(String str) {
        this.j = str;
    }
}
