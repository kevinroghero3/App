package it.aep_italia.vts.sdk.dto.domain;

import org.simpleframework.xml.Attribute;

/* JADX INFO: loaded from: classes6.dex */
public class VtsDeviceDTO {

    @Attribute(name = "DeviceUID")
    private String a;

    @Attribute(name = "DeviceType")
    private String b;

    @Attribute(name = "DeviceSubType", required = false)
    private String c;

    @Attribute(name = "PhoneNumber", required = false)
    private String d;

    @Attribute(name = "UserId", required = false)
    private Integer e;

    @Attribute(name = "VTokenCount", required = false)
    private Integer f;

    @Attribute(name = "LastConnectionDateTime", required = false)
    private String g;

    @Attribute(name = "IMEI", required = false)
    private String h;

    @Attribute(name = "IMSI", required = false)
    private String i;

    @Attribute(name = "SIMID", required = false)
    private String j;

    @Attribute(name = "LocalIpv4Address", required = false)
    private String k;

    @Attribute(name = "LocalIpv6Address", required = false)
    private String l;

    public String getDeviceSubType() {
        return this.c;
    }

    public String getDeviceType() {
        return this.b;
    }

    public String getDeviceUID() {
        return this.a;
    }

    public String getLastConnectionDateTime() {
        return this.g;
    }

    public String getLocalIpv4Address() {
        return this.k;
    }

    public String getLocalIpv6Address() {
        return this.l;
    }

    public String getPhoneNumber() {
        return this.d;
    }

    public Integer getUserId() {
        return this.e;
    }

    public String getiMEI() {
        return this.h;
    }

    public String getiMSI() {
        return this.i;
    }

    public String getsIMID() {
        return this.j;
    }

    public Integer getvTokenCount() {
        return this.f;
    }

    public void setDeviceSubType(String str) {
        this.c = str;
    }

    public void setDeviceType(String str) {
        this.b = str;
    }

    public void setDeviceUID(String str) {
        this.a = str;
    }

    public void setLastConnectionDateTime(String str) {
        this.g = str;
    }

    public void setLocalIpv4Address(String str) {
        this.k = str;
    }

    public void setLocalIpv6Address(String str) {
        this.l = str;
    }

    public void setPhoneNumber(String str) {
        this.d = str;
    }

    public void setUserId(Integer num) {
        this.e = num;
    }

    public void setiMEI(String str) {
        this.h = str;
    }

    public void setiMSI(String str) {
        this.i = str;
    }

    public void setsIMID(String str) {
        this.j = str;
    }

    public void setvTokenCount(Integer num) {
        this.f = num;
    }
}
