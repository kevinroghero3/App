package it.aep_italia.vts.sdk.dto.server.server_info;

import org.simpleframework.xml.Attribute;

/* JADX INFO: loaded from: classes6.dex */
public class VtsServerNamedValueDTO {

    @Attribute(name = "Name", required = false)
    private String a;

    @Attribute(name = "Value", required = false)
    private String b;

    public String getName() {
        return this.a;
    }

    public String getValue() {
        return this.b;
    }

    public void setName(String str) {
        this.a = str;
    }

    public void setValue(String str) {
        this.b = str;
    }
}
