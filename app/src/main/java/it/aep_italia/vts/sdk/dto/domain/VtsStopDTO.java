package it.aep_italia.vts.sdk.dto.domain;

import org.simpleframework.xml.Attribute;

/* JADX INFO: loaded from: classes6.dex */
public class VtsStopDTO {

    @Attribute(name = "StopId")
    private Integer a;

    @Attribute(name = "StopCode")
    private String b;

    @Attribute(name = "StopCustomerCode")
    private String c;

    @Attribute(name = "NodeId")
    private Integer d;

    @Attribute(name = "OperatorId")
    private Integer e;

    @Attribute(name = "AvmId")
    private Integer f;

    @Attribute(name = "StopDescription")
    private String g;

    @Attribute(name = "StopShortDescription")
    private String h;

    @Attribute(name = "StopGpsPosition")
    private String i;

    public Integer getAvmID() {
        return this.f;
    }

    public String getDescription() {
        return this.g;
    }

    public String getGpsPosition() {
        return this.i;
    }

    public Integer getNodeID() {
        return this.d;
    }

    public Integer getOperatorID() {
        return this.e;
    }

    public String getShortDescription() {
        return this.h;
    }

    public String getStopCode() {
        return this.b;
    }

    public String getStopCustomerCode() {
        return this.c;
    }

    public Integer getStopID() {
        return this.a;
    }

    public void setAvmID(Integer num) {
        this.f = num;
    }

    public void setDescription(String str) {
        this.g = str;
    }

    public void setGpsPosition(String str) {
        this.i = str;
    }

    public void setNodeID(Integer num) {
        this.d = num;
    }

    public void setOperatorID(Integer num) {
        this.e = num;
    }

    public void setShortDescription(String str) {
        this.h = str;
    }

    public void setStopCode(String str) {
        this.b = str;
    }

    public void setStopCustomerCode(String str) {
        this.c = str;
    }

    public void setStopID(Integer num) {
        this.a = num;
    }
}
