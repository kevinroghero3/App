package it.aep_italia.vts.sdk.dto.domain.token.payload;

import it.aep_italia.vts.sdk.utils.StringUtils;
import org.simpleframework.xml.Attribute;

/* JADX INFO: loaded from: classes6.dex */
public class VtsVTokenPayloadContractDTO {

    @Attribute(name = "FormulaExpansionWeight", required = false)
    private Integer A;

    @Attribute(name = "OriginNodeId", required = false)
    private Integer B;

    @Attribute(name = "OriginNodeDescription", required = false)
    private String C;

    @Attribute(name = "DestinationNodeId", required = false)
    private Integer D;

    @Attribute(name = "DestinationNodeDescription", required = false)
    private String E;

    @Attribute(name = "TariffFamilyId")
    private Integer a;

    @Attribute(name = "TariffFamilyType", required = false)
    private Integer b;

    @Attribute(name = "ProviderId")
    private Integer c;

    @Attribute(name = "ProviderDescription")
    private String d;

    @Attribute(name = "TariffId")
    private Integer e;

    @Attribute(name = "TariffDescription")
    private String f;

    @Attribute(name = "ContractUid")
    private String g;

    @Attribute(name = "SellingOperatorId")
    private Integer h;

    @Attribute(name = "SellingOperatorDescription")
    private String i;

    @Attribute(name = "SellingDate")
    private String j;

    @Attribute(name = "StartValidityDateTime", required = false)
    private String k;

    @Attribute(name = "EndValidityDateTime", required = false)
    private String l;

    @Attribute(name = "Price")
    private String m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Attribute(name = "ContractTypeDescription")
    private String f138n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Attribute(name = "ContractTypeDuration")
    private String f139o;

    @Attribute(name = "FrontImageVTID")
    private String p;

    @Attribute(name = "BackImageVTID")
    private String q;

    @Attribute(name = "TotalRides", required = false)
    private String r;

    @Attribute(name = "RidesToGo", required = false)
    private Integer s;

    @Attribute(name = "RideMaxDuration", required = false)
    private String t;

    @Attribute(name = "MinutesToGo", required = false)
    private String u;

    @Attribute(name = "RechargeUid", required = false)
    private String v;

    @Attribute(name = "FormulaZones", required = false)
    private String w;

    @Attribute(name = "FormulaZonesWeight", required = false)
    private Integer x;

    @Attribute(name = "ExpansionTypeId", required = false)
    private Integer y;

    @Attribute(name = "ExpansionTypeDescription", required = false)
    private String z;

    public String getBackImageVTID() {
        return this.q;
    }

    public String getContractTypeDescription() {
        return this.f138n;
    }

    public String getContractTypeDuration() {
        return this.f139o;
    }

    public String getContractUID() {
        return this.g;
    }

    public String getDestinationNodeDescription() {
        return this.E;
    }

    public Integer getDestinationNodeID() {
        return this.D;
    }

    public String getEndValidityDateTime() {
        return this.l;
    }

    public String getExpansionTypeDescription() {
        return this.z;
    }

    public Integer getExpansionTypeID() {
        return this.y;
    }

    public Integer getFormulaExpansionWeight() {
        return this.A;
    }

    public String getFormulaZones() {
        return this.w;
    }

    public Integer getFormulaZonesWeight() {
        return this.x;
    }

    public String getFrontImageVTID() {
        return this.p;
    }

    public String getMinutesToGo() {
        return this.u;
    }

    public String getOriginNodeDescription() {
        return this.C;
    }

    public Integer getOriginNodeID() {
        return this.B;
    }

    public Integer getPrice() {
        if (StringUtils.isBlank(this.m)) {
            return null;
        }
        return Integer.valueOf(Integer.parseInt(this.m));
    }

    public String getProviderDescription() {
        return this.d;
    }

    public Integer getProviderID() {
        return this.c;
    }

    public Integer getRechargeUID() {
        if (StringUtils.isBlank(this.v)) {
            return null;
        }
        return Integer.valueOf(Integer.parseInt(this.v));
    }

    public String getRideMaxDuration() {
        return this.t;
    }

    public Integer getRidesToGo() {
        return this.s;
    }

    public String getSellingDate() {
        return this.j;
    }

    public String getSellingOperatorDescription() {
        return this.i;
    }

    public Integer getSellingOperatorID() {
        return this.h;
    }

    public String getStartValidityDateTime() {
        return this.k;
    }

    public String getTariffDescription() {
        return this.f;
    }

    public Integer getTariffFamilyID() {
        return this.a;
    }

    public Integer getTariffFamilyType() {
        Integer num = this.b;
        if (num == null) {
            return 1;
        }
        return num;
    }

    public Integer getTariffID() {
        return this.e;
    }

    public String getTotalRides() {
        return this.r;
    }

    public void setBackImageVTID(String str) {
        this.q = str;
    }

    public void setContractTypeDescription(String str) {
        this.f138n = str;
    }

    public void setContractTypeDuration(String str) {
        this.f139o = str;
    }

    public void setContractUID(String str) {
        this.g = str;
    }

    public void setDestinationNodeDescription(String str) {
        this.E = str;
    }

    public void setDestinationNodeID(Integer num) {
        this.D = num;
    }

    public void setEndValidityDateTime(String str) {
        this.l = str;
    }

    public void setExpansionTypeDescription(String str) {
        this.z = str;
    }

    public void setExpansionTypeID(Integer num) {
        this.y = num;
    }

    public void setFormulaExpansionWeight(Integer num) {
        this.A = num;
    }

    public void setFormulaZones(String str) {
        this.w = str;
    }

    public void setFormulaZonesWeight(Integer num) {
        this.x = num;
    }

    public void setFrontImageVTID(String str) {
        this.p = str;
    }

    public void setMinutesToGo(String str) {
        this.u = str;
    }

    public void setOriginNodeDescription(String str) {
        this.C = str;
    }

    public void setOriginNodeID(Integer num) {
        this.B = num;
    }

    public void setPrice(int i) {
        this.m = "" + i;
    }

    public void setProviderDescription(String str) {
        this.d = str;
    }

    public void setProviderID(Integer num) {
        this.c = num;
    }

    public void setRechargeUID(int i) {
        this.v = "" + i;
    }

    public void setRideMaxDuration(String str) {
        this.t = str;
    }

    public void setRidesToGo(Integer num) {
        this.s = num;
    }

    public void setSellingDate(String str) {
        this.j = str;
    }

    public void setSellingOperatorDescription(String str) {
        this.i = str;
    }

    public void setSellingOperatorID(Integer num) {
        this.h = num;
    }

    public void setStartValidityDateTime(String str) {
        this.k = str;
    }

    public void setTariffDescription(String str) {
        this.f = str;
    }

    public void setTariffFamilyID(Integer num) {
        this.a = num;
    }

    public void setTariffFamilyType(Integer num) {
        this.b = num;
    }

    public void setTariffID(Integer num) {
        this.e = num;
    }

    public void setTotalRides(String str) {
        this.r = str;
    }
}
