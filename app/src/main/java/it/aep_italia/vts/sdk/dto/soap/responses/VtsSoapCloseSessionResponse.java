package it.aep_italia.vts.sdk.dto.soap.responses;

import it.aep_italia.vts.sdk.dto.soap.VtsSoapEnvelope;
import it.aep_italia.vts.sdk.dto.soap.VtsSoapHeader;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

/* JADX INFO: loaded from: classes6.dex */
@Root(name = "Envelope")
public class VtsSoapCloseSessionResponse extends VtsSoapEnvelope implements VtsSoapResponse {

    @Element(name = "ErrorStr", required = false)
    @Path("soap:Body/vtsr:vts_CloseSessionResponse/vtsr:vts_CloseSessionResult")
    private String b;

    @Element(name = "RetCode")
    @Path("soap:Body/vtsr:vts_CloseSessionResponse/vtsr:vts_CloseSessionResult")
    private Integer c;

    protected VtsSoapCloseSessionResponse() {
        super(new VtsSoapHeader(null, null));
    }

    @Override // it.aep_italia.vts.sdk.dto.soap.responses.VtsSoapResponse
    public String getDataOutBin() {
        return null;
    }

    @Override // it.aep_italia.vts.sdk.dto.soap.responses.VtsSoapResponse
    public String getDataOutXml() {
        return null;
    }

    @Override // it.aep_italia.vts.sdk.dto.soap.responses.VtsSoapResponse
    public String getErrorString() {
        return this.b;
    }

    @Override // it.aep_italia.vts.sdk.dto.soap.responses.VtsSoapResponse
    public Integer getReturnCode() {
        return this.c;
    }

    public void setErrorString(String str) {
        this.b = str;
    }

    public void setReturnCode(Integer num) {
        this.c = num;
    }
}
