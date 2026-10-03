package it.aep_italia.vts.sdk.dto.domain.token;

import org.simpleframework.xml.Attribute;

/* JADX INFO: loaded from: classes6.dex */
public class VtsVTokenSignatureDTO {

    @Attribute(name = "Attribute")
    private int a;

    @Attribute(name = "SamType")
    private int b;

    @Attribute(name = "SamId")
    private String c;

    @Attribute(name = "SamCounter")
    private int d;

    @Attribute(name = "SignatureChecked")
    private boolean e;

    @Attribute(name = "SignatureValid")
    private boolean f;

    public int getAttributes() {
        return this.a;
    }

    public int getSamCounter() {
        return this.d;
    }

    public String getSamID() {
        return this.c;
    }

    public int getSamType() {
        return this.b;
    }

    public boolean isSignatureChecked() {
        return this.e;
    }

    public boolean isSignatureValid() {
        return this.f;
    }

    public void setAttributes(int i) {
        this.a = i;
    }

    public void setSamCounter(int i) {
        this.d = i;
    }

    public void setSamID(String str) {
        this.c = str;
    }

    public void setSamType(int i) {
        this.b = i;
    }

    public void setSignatureChecked(boolean z) {
        this.e = z;
    }

    public void setSignatureValid(boolean z) {
        this.f = z;
    }
}
