package it.aep_italia.vts.sdk.dto.domain.token;

import com.facebook.appevents.AppEventsConstants;
import org.simpleframework.xml.Attribute;

/* JADX INFO: loaded from: classes6.dex */
public class VtsVTokenValidationDTO {

    @Attribute(name = "Validated")
    private String a;

    @Attribute(name = "FirstValidation", required = false)
    private String b;

    @Attribute(name = "LastValidation", required = false)
    private String c;

    @Attribute(name = "ContractUid", required = false)
    private String d;

    @Attribute(name = "OperatorId", required = false)
    private int e;

    @Attribute(name = "ClassId", required = false)
    private int f;

    @Attribute(name = "EquipmentId", required = false)
    private int g;

    @Attribute(name = "RideId", required = false)
    private int h;

    @Attribute(name = "RideDescription", required = false)
    private String i;

    @Attribute(name = "NodeId", required = false)
    private int j;

    @Attribute(name = "NodeDescription", required = false)
    private String k;

    @Attribute(name = "StopId", required = false)
    private int l;

    @Attribute(name = "StopDescription", required = false)
    private String m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Attribute(empty = AppEventsConstants.EVENT_PARAM_VALUE_NO, name = "MinutesToGo", required = false)
    private String f136n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Attribute(empty = AppEventsConstants.EVENT_PARAM_VALUE_NO, name = "RidesToGo", required = false)
    private String f137o;

    public int getClassID() {
        return this.f;
    }

    public String getContractUID() {
        return this.d;
    }

    public int getEquipmentID() {
        return this.g;
    }

    public String getFirstValidation() {
        return this.b;
    }

    public String getLastValidation() {
        return this.c;
    }

    public String getMinutesToGo() {
        return this.f136n;
    }

    public String getNodeDescription() {
        return this.k;
    }

    public int getNodeID() {
        return this.j;
    }

    public int getOperatorID() {
        return this.e;
    }

    public String getRideDescription() {
        return this.i;
    }

    public int getRideID() {
        return this.h;
    }

    public String getRidesToGo() {
        return this.f137o;
    }

    public String getStopDescription() {
        return this.m;
    }

    public int getStopID() {
        return this.l;
    }

    public String getValidated() {
        return this.a;
    }

    public void setClassID(int i) {
        this.f = i;
    }

    public void setContractUID(String str) {
        this.d = str;
    }

    public void setEquipmentID(int i) {
        this.g = i;
    }

    public void setFirstValidation(String str) {
        this.b = str;
    }

    public void setLastValidation(String str) {
        this.c = str;
    }

    public void setMinutesToGo(String str) {
        this.f136n = str;
    }

    public void setNodeDescription(String str) {
        this.k = str;
    }

    public void setNodeID(int i) {
        this.j = i;
    }

    public void setOperatorID(int i) {
        this.e = i;
    }

    public void setRideDescription(String str) {
        this.i = str;
    }

    public void setRideID(int i) {
        this.h = i;
    }

    public void setRidesToGo(String str) {
        this.f137o = str;
    }

    public void setStopDescription(String str) {
        this.m = str;
    }

    public void setStopID(int i) {
        this.l = i;
    }

    public void setValidated(String str) {
        this.a = str;
    }
}
