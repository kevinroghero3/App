package it.aep_italia.vts.sdk.dto.domain;

import org.simpleframework.xml.Attribute;

/* JADX INFO: loaded from: classes6.dex */
public class VtsRideDTO {

    @Attribute(name = "RideId")
    private Integer a;

    @Attribute(name = "RideCode")
    private String b;

    @Attribute(name = "OperatorId")
    private Integer c;

    @Attribute(name = "AvmId", required = false)
    private String d;

    @Attribute(name = "RideDescription")
    private String e;

    @Attribute(name = "RideShortDescription")
    private String f;

    public String getAvmID() {
        return this.d;
    }

    public String getDescription() {
        return this.e;
    }

    public Integer getOperatorID() {
        return this.c;
    }

    public String getRideCode() {
        return this.b;
    }

    public Integer getRideID() {
        return this.a;
    }

    public String getShortDescription() {
        return this.f;
    }

    public void setAvmID(String str) {
        this.d = str;
    }

    public void setDescription(String str) {
        this.e = str;
    }

    public void setOperatorID(Integer num) {
        this.c = num;
    }

    public void setRideCode(String str) {
        this.b = str;
    }

    public void setRideID(Integer num) {
        this.a = num;
    }

    public void setShortDescription(String str) {
        this.f = str;
    }
}
