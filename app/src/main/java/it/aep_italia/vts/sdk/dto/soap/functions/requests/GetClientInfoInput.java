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
public class GetClientInfoInput implements VtsSoapFunctionPayload {

    @Attribute(name = "Version")
    @Path("vts:Header")
    private int a = 1;

    @Attribute(name = "EMail", required = false)
    @Path("vts:Body/vts:Parameters")
    private String b;

    @Attribute(name = "Userid", required = false)
    @Path("vts:Body/vts:Parameters")
    private String c;

    @Attribute(name = "RequestPhotoImage", required = false)
    @Path("vts:Body/vts:Parameters")
    private String d;

    public GetClientInfoInput(int i) {
        setUserID(String.valueOf(i));
    }

    public GetClientInfoInput(String str, String str2) {
        setEmail(str);
        setRequestPhotoImage(str2);
    }

    public String getEmail() {
        return this.b;
    }

    @Override // it.aep_italia.vts.sdk.dto.soap.functions.VtsSoapFunctionPayload
    public String getFunctionName() {
        return "vts_FuncGetClientInfo";
    }

    public String getRequestPhotoImage() {
        return this.d;
    }

    @Override // it.aep_italia.vts.sdk.dto.soap.functions.VtsSoapFunctionPayload
    public String getStringifiedParameters() {
        return String.format(Locale.ITALY, "Email: %s;", this.b);
    }

    public String getUserID() {
        return this.c;
    }

    public void setEmail(String str) {
        this.b = str;
    }

    public void setRequestPhotoImage(String str) {
        this.d = str;
    }

    public void setUserID(String str) {
        this.c = str;
    }
}
