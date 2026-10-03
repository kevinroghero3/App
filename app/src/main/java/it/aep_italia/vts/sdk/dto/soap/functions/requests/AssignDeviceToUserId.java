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
public class AssignDeviceToUserId implements VtsSoapFunctionPayload {

    @Attribute(name = "Version")
    @Path("vts:Header")
    private int a = 1;

    @Attribute(name = "InsertMode")
    @Path("vts:Body/vts:Parameters")
    private String b;

    @Attribute(name = "UserId")
    @Path("vts:Body/vts:Parameters")
    private String c;

    @Attribute(name = "DeviceUID")
    @Path("vts:Body/vts:Parameters")
    private String d;

    public AssignDeviceToUserId(String str, int i, String str2) {
        this.b = str;
        this.c = String.valueOf(i);
        this.d = str2;
    }

    public String getDeviceUID() {
        return this.d;
    }

    @Override // it.aep_italia.vts.sdk.dto.soap.functions.VtsSoapFunctionPayload
    public String getFunctionName() {
        return "vts_FuncSetClientInfo";
    }

    public String getInsertMode() {
        return this.b;
    }

    @Override // it.aep_italia.vts.sdk.dto.soap.functions.VtsSoapFunctionPayload
    public String getStringifiedParameters() {
        return String.format(Locale.ITALY, "InsertMode: %s; Userid: %s; DeviceUID: %s", this.b, this.c, this.d);
    }

    public String getUserid() {
        return this.c;
    }

    public void setDeviceUID(String str) {
        this.d = str;
    }

    public void setInsertMode(String str) {
        this.b = this.b;
    }

    public void setUserid(String str) {
        this.c = str;
    }
}
