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
public class GetMoveTokensInput implements VtsSoapFunctionPayload {

    @Attribute(name = "Version")
    @Path("vts:Header")
    private int a = 1;

    @Attribute(name = "SourceDeviceUID")
    @Path("vts:Body/vts:Parameters")
    private String b;

    @Attribute(name = "DestinationDeviceUID")
    @Path("vts:Body/vts:Parameters")
    private String c;

    public GetMoveTokensInput(long j, long j2) {
        this.b = StringUtils.toFullHexString(Long.valueOf(j)).toLowerCase();
        this.c = StringUtils.toFullHexString(Long.valueOf(j2)).toLowerCase();
    }

    public String getDestinationDeviceUID() {
        return this.c;
    }

    @Override // it.aep_italia.vts.sdk.dto.soap.functions.VtsSoapFunctionPayload
    public String getFunctionName() {
        return "vts_FuncMoveVTokens";
    }

    public String getSourceDeviceUID() {
        return this.b;
    }

    @Override // it.aep_italia.vts.sdk.dto.soap.functions.VtsSoapFunctionPayload
    public String getStringifiedParameters() {
        return String.format(Locale.ITALY, "SourceDeviceUID: %s, DestinationDeviceUID: %s", this.b, this.c);
    }
}
