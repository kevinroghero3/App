package it.aep_italia.vts.sdk.dto.soap.functions.requests;

import com.facebook.hermes.intl.Constants;
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
public class GetServerInfoInput implements VtsSoapFunctionPayload {

    @Attribute(name = "Version")
    @Path("vts:Header")
    private int a = 1;

    @Attribute(name = "RequestUserData")
    @Path("vts:Body/vts:Parameters")
    private String b;

    @Attribute(name = "RequestPhotoImage")
    @Path("vts:Body/vts:Parameters")
    private String c;

    @Attribute(name = "RequestStatistics")
    @Path("vts:Body/vts:Parameters")
    private String d;

    public GetServerInfoInput(boolean z, boolean z2, boolean z3) {
        this.b = z ? "true" : Constants.CASEFIRST_FALSE;
        this.c = z2 ? "true" : Constants.CASEFIRST_FALSE;
        this.d = z3 ? "true" : Constants.CASEFIRST_FALSE;
    }

    @Override // it.aep_italia.vts.sdk.dto.soap.functions.VtsSoapFunctionPayload
    public String getFunctionName() {
        return "vts_FuncGetServerInfo";
    }

    public String getRequestPhotoImage() {
        return this.c;
    }

    public String getRequestStatistics() {
        return this.d;
    }

    public String getRequestUserData() {
        return this.b;
    }

    @Override // it.aep_italia.vts.sdk.dto.soap.functions.VtsSoapFunctionPayload
    public String getStringifiedParameters() {
        return String.format(Locale.ITALY, "RequesterUserData: %s, RequesterUserData: %s, RequestStatistics: %s", this.b, this.c, this.d);
    }
}
