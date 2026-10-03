package it.aep_italia.vts.sdk.dto.domain.token.payload;

import org.simpleframework.xml.Attribute;

/* JADX INFO: loaded from: classes6.dex */
public class VtsVTokenPayloadPhysicalDocInfoDTO {

    @Attribute(name = "ObjectType")
    private int a;

    @Attribute(name = "SerialNumber")
    private String b;

    @Attribute(name = "ApplicationType", required = false)
    private String c;

    @Attribute(name = "ApplicationSubType", required = false)
    private String d;

    @Attribute(name = "LayoutId", required = false)
    private int e;

    @Attribute(name = "MaskId", required = false)
    private int f;

    public String getApplicationSubType() {
        return this.d;
    }

    public String getApplicationType() {
        return this.c;
    }

    public int getLayoutID() {
        return this.e;
    }

    public int getMaskID() {
        return this.f;
    }

    public int getObjectType() {
        return this.a;
    }

    public String getSerialNumber() {
        return this.b;
    }

    public void setApplicationSubType(String str) {
        this.d = str;
    }

    public void setApplicationType(String str) {
        this.c = str;
    }

    public void setLayoutID(int i) {
        this.e = i;
    }

    public void setMaskID(int i) {
        this.f = i;
    }

    public void setObjectType(int i) {
        this.a = i;
    }

    public void setSerialNumber(String str) {
        this.b = str;
    }
}
