package it.aep_italia.vts.sdk.dto.domain;

import org.simpleframework.xml.Attribute;

/* JADX INFO: loaded from: classes6.dex */
public class VtsServiceModeDTO {

    @Attribute(name = "ServiceModeId")
    private Integer a;

    @Attribute(name = "ServiceModeDescription")
    private String b;

    @Attribute(name = "ServiceModeShortDescription")
    private String c;

    public String getDescription() {
        return this.b;
    }

    public Integer getID() {
        return this.a;
    }

    public String getShortDescription() {
        return this.c;
    }

    public void setDescription(String str) {
        this.b = str;
    }

    public void setID(Integer num) {
        this.a = num;
    }

    public void setShortDescription(String str) {
        this.c = str;
    }
}
