package it.aep_italia.vts.sdk.domain;

import android.os.Parcel;
import android.os.Parcelable;
import it.aep_italia.vts.sdk.dto.domain.SbeCustomerDTO;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class SbeCustomer implements Serializable, Parcelable {
    public static final Parcelable.Creator<SbeCustomer> CREATOR = new a();
    private static final long serialVersionUID = 4192223409634830192L;
    long a;
    String b;
    String c;
    String d;
    String e;
    String f;
    String g;
    String h;
    String i;
    String j;
    String k;
    String l;
    String m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    String f130n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    String f131o;
    String p;
    String q;
    String r;
    String s;
    String t;
    String u;

    class a implements Parcelable.Creator<SbeCustomer> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public SbeCustomer createFromParcel(Parcel parcel) {
            return new SbeCustomer(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public SbeCustomer[] newArray(int i) {
            return new SbeCustomer[i];
        }
    }

    public SbeCustomer() {
    }

    protected SbeCustomer(Parcel parcel) {
        this.a = parcel.readLong();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readString();
        this.g = parcel.readString();
        this.h = parcel.readString();
        this.i = parcel.readString();
        this.j = parcel.readString();
        this.k = parcel.readString();
        this.l = parcel.readString();
        this.m = parcel.readString();
        this.f130n = parcel.readString();
        this.f131o = parcel.readString();
        this.p = parcel.readString();
        this.q = parcel.readString();
        this.r = parcel.readString();
        this.s = parcel.readString();
        this.t = parcel.readString();
        this.u = parcel.readString();
    }

    public static SbeCustomer fromDto(SbeCustomerDTO sbeCustomerDTO) {
        if (sbeCustomerDTO == null) {
            return new SbeCustomer();
        }
        SbeCustomer sbeCustomer = new SbeCustomer();
        sbeCustomer.a = sbeCustomerDTO.getCustomerId();
        sbeCustomer.b = sbeCustomerDTO.getLastName();
        sbeCustomer.c = sbeCustomerDTO.getFirstName();
        sbeCustomer.d = sbeCustomerDTO.getFiscalCode();
        sbeCustomer.e = sbeCustomerDTO.getBirthDate();
        sbeCustomer.f = sbeCustomerDTO.getSex();
        sbeCustomer.g = sbeCustomerDTO.getStatus();
        sbeCustomer.h = sbeCustomerDTO.geteMail();
        sbeCustomer.i = sbeCustomerDTO.getInsertDate();
        sbeCustomer.j = sbeCustomerDTO.getLastUpdate();
        sbeCustomer.k = sbeCustomerDTO.getPhotoImage();
        sbeCustomer.l = sbeCustomerDTO.getPhoneNumber();
        sbeCustomer.m = sbeCustomerDTO.getSecPhoneNumber();
        sbeCustomer.f130n = sbeCustomerDTO.getAddress();
        sbeCustomer.f131o = sbeCustomerDTO.getHouse();
        sbeCustomer.p = sbeCustomerDTO.getLocality();
        sbeCustomer.q = sbeCustomerDTO.getCity();
        sbeCustomer.r = sbeCustomerDTO.getDistrict();
        sbeCustomer.s = sbeCustomerDTO.getZipCode();
        sbeCustomer.t = sbeCustomerDTO.getBirthPlace();
        sbeCustomer.u = sbeCustomerDTO.getNationality();
        return sbeCustomer;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAddress() {
        return this.f130n;
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
        return this.f131o;
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
        this.f130n = str;
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
        this.f131o = str;
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

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
        parcel.writeString(this.i);
        parcel.writeString(this.j);
        parcel.writeString(this.k);
        parcel.writeString(this.l);
        parcel.writeString(this.m);
        parcel.writeString(this.f130n);
        parcel.writeString(this.f131o);
        parcel.writeString(this.p);
        parcel.writeString(this.q);
        parcel.writeString(this.r);
        parcel.writeString(this.s);
        parcel.writeString(this.t);
        parcel.writeString(this.u);
    }
}
