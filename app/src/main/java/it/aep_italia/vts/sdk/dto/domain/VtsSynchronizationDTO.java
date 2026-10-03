package it.aep_italia.vts.sdk.dto.domain;

import org.simpleframework.xml.Attribute;

/* JADX INFO: loaded from: classes6.dex */
public class VtsSynchronizationDTO {

    @Attribute(name = "Status")
    private String a;

    @Attribute(name = "StartDate")
    private String b;

    @Attribute(name = "EndDate", required = false)
    private String c;

    @Attribute(name = "ErrorMessage", required = false)
    private String d;

    public String getEndDate() {
        return this.c;
    }

    public String getErrorMessage() {
        return this.d;
    }

    public String getStartDate() {
        return this.b;
    }

    public String getStatus() {
        return this.a;
    }

    public void setEndDate(String str) {
        this.c = str;
    }

    public void setErrorMessage(String str) {
        this.d = str;
    }

    public void setStartDate(String str) {
        this.b = str;
    }

    public void setStatus(String str) {
        this.a = str;
    }
}
