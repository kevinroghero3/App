package it.aep_italia.vts.sdk.dto.domain;

import org.simpleframework.xml.Attribute;

/* JADX INFO: loaded from: classes6.dex */
public class PspPaymentRedirectDTO {

    @Attribute(name = "ResponseCode")
    private String a;

    @Attribute(name = "Token")
    private String b;

    @Attribute(name = "RedirectUrl")
    private String c;

    @Attribute(name = "CodeIdentifier")
    private String d;

    @Attribute(name = "ExternalCode")
    private String e;

    public String getApiToken() {
        return this.b;
    }

    public String getCodeIdentifier() {
        return this.d;
    }

    public String getExternalCode() {
        return this.e;
    }

    public String getRedirectUrl() {
        return this.c;
    }

    public String getResponseCode() {
        return this.a;
    }

    public void setApiToken(String str) {
        this.b = str;
    }

    public void setRedirectUrl(String str) {
        this.c = str;
    }

    public void setResponseCode(String str) {
        this.a = str;
    }
}
