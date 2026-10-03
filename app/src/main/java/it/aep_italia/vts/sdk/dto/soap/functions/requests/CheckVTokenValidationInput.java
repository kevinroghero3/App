package it.aep_italia.vts.sdk.dto.soap.functions.requests;

import it.aep_italia.vts.sdk.dto.soap.VtsSoapEnvelope;
import it.aep_italia.vts.sdk.dto.soap.functions.VtsSoapFunctionPayload;
import java.util.Locale;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

/* JADX INFO: loaded from: classes6.dex */
@NamespaceList({@Namespace(prefix = "vts", reference = VtsSoapEnvelope.NAMESPACE_AEP)})
@Root(name = "vts:VTS_RequestFunction")
public class CheckVTokenValidationInput implements VtsSoapFunctionPayload {

    @Attribute(name = "Version")
    @Path("vts:Header")
    private int a = 1;

    @Attribute(name = "VTokenUID")
    @Path("vts:Body/vts:Parameters")
    private String b;

    @Attribute(name = "SignatureCount")
    @Path("vts:Body/vts:Parameters")
    private int c;

    public CheckVTokenValidationInput(String str, int i) {
        this.b = str;
        this.c = i;
    }

    @Override // it.aep_italia.vts.sdk.dto.soap.functions.VtsSoapFunctionPayload
    public String getFunctionName() {
        return "vts_FuncCheckVTokenValidation";
    }

    public int getSignatureCount() {
        return this.c;
    }

    @Override // it.aep_italia.vts.sdk.dto.soap.functions.VtsSoapFunctionPayload
    public String getStringifiedParameters() {
        return String.format(Locale.ITALY, "VTokenUID: %s; SignatureCount: %d", this.b, Integer.valueOf(this.c));
    }

    public String getvTokenUID() {
        return this.b;
    }

    public void setSignatureCount(int i) {
        this.c = i;
    }

    public void setvTokenUID(String str) {
        this.b = str;
    }
}
