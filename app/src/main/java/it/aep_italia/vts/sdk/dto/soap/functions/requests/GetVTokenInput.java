package it.aep_italia.vts.sdk.dto.soap.functions.requests;

import it.aep_italia.vts.sdk.dto.soap.VtsSoapEnvelope;
import it.aep_italia.vts.sdk.dto.soap.functions.VtsSoapFunctionPayload;
import it.aep_italia.vts.sdk.utils.StringUtils;
import java.util.Locale;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

/* JADX INFO: loaded from: classes6.dex */
@NamespaceList({@Namespace(prefix = "vts", reference = VtsSoapEnvelope.NAMESPACE_AEP)})
@Root(name = "vts:VTS_RequestFunction")
public class GetVTokenInput implements VtsSoapFunctionPayload {

    @Attribute(name = "Version")
    @Path("vts:Header")
    private int a = 1;

    @Attribute(name = "VTokenUID")
    @Path("vts:Body/vts:Parameters")
    private String b;

    public GetVTokenInput(Long l) {
        setVTokenUID(l);
    }

    @Override // it.aep_italia.vts.sdk.dto.soap.functions.VtsSoapFunctionPayload
    public String getFunctionName() {
        return "vts_FuncGetVtoken";
    }

    @Override // it.aep_italia.vts.sdk.dto.soap.functions.VtsSoapFunctionPayload
    public String getStringifiedParameters() {
        return String.format(Locale.ITALY, "VTokenUID: %s", this.b);
    }

    public Long getVTokenUID() {
        String str = this.b;
        if (str == null) {
            return null;
        }
        return Long.valueOf(StringUtils.unsignedHexStringToSignedLong(str));
    }

    public void setVTokenUID(Long l) {
        this.b = l == null ? null : Long.toHexString(l.longValue());
    }
}
