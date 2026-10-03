package it.aep_italia.vts.sdk.dto.domain.token.payload;

import org.simpleframework.xml.Attribute;

/* JADX INFO: loaded from: classes6.dex */
public class VtsVTokenPayloadValidationDTO {

    @Attribute(name = "ContractUid")
    private String a;

    @Attribute(name = "ValidationDateTime")
    private String b;

    @Attribute(name = "OperationType", required = false)
    private String c;

    @Attribute(name = "RideId", required = false)
    private int d;

    @Attribute(name = "RideDescription", required = false)
    private String e;

    @Attribute(name = "NodeId", required = false)
    private int f;

    @Attribute(name = "NodeDescription", required = false)
    private String g;

    @Attribute(name = "PassengerCount", required = false)
    private int h;

    public String getContractUID() {
        return this.a;
    }

    public String getNodeDescription() {
        return this.g;
    }

    public int getNodeID() {
        return this.f;
    }

    public String getOperationType() {
        return this.c;
    }

    public int getPassengerCount() {
        return this.h;
    }

    public String getRideDescription() {
        return this.e;
    }

    public int getRideID() {
        return this.d;
    }

    public String getValidationDateTime() {
        return this.b;
    }

    public void setContractUID(String str) {
        this.a = str;
    }

    public void setNodeDescription(String str) {
        this.g = str;
    }

    public void setNodeID(int i) {
        this.f = i;
    }

    public void setOperationType(String str) {
        this.c = str;
    }

    public void setPassengerCount(int i) {
        this.h = i;
    }

    public void setRideDescription(String str) {
        this.e = str;
    }

    public void setRideID(int i) {
        this.d = i;
    }

    public void setValidationDateTime(String str) {
        this.b = str;
    }
}
