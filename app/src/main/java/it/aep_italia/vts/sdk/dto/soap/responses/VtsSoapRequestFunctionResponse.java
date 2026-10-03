package it.aep_italia.vts.sdk.dto.soap.responses;

import it.aep_italia.vts.sdk.dto.soap.VtsSoapEnvelope;
import it.aep_italia.vts.sdk.dto.soap.VtsSoapHeader;
import it.aep_italia.vts.sdk.errors.VtsException;
import it.aep_italia.vts.sdk.utils.SerializationUtils;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

/* JADX INFO: loaded from: classes6.dex */
@Root(name = "Envelope")
public class VtsSoapRequestFunctionResponse extends VtsSoapEnvelope implements VtsSoapResponse {

    @Element(name = "ErrorStr", required = false)
    @Path("soap:Body/vtsr:vts_RequestFunctionResponse/vtsr:vts_RequestFunctionResult")
    private String b;

    @Element(name = "RetCode")
    @Path("soap:Body/vtsr:vts_RequestFunctionResponse/vtsr:vts_RequestFunctionResult")
    private Integer c;

    @Element(name = "DataOutXml", required = false)
    @Path("soap:Body/vtsr:vts_RequestFunctionResponse/vtsr:vts_RequestFunctionResult")
    private String d;

    @Element(name = "DataOutBin", required = false)
    @Path("soap:Body/vtsr:vts_RequestFunctionResponse/vtsr:vts_RequestFunctionResult")
    private String e;

    public VtsSoapRequestFunctionResponse() {
        super(new VtsSoapHeader(null, null));
    }

    @Override // it.aep_italia.vts.sdk.dto.soap.responses.VtsSoapResponse
    public String getDataOutBin() {
        return this.e;
    }

    @Override // it.aep_italia.vts.sdk.dto.soap.responses.VtsSoapResponse
    public String getDataOutXml() {
        return this.d;
    }

    @Override // it.aep_italia.vts.sdk.dto.soap.responses.VtsSoapResponse
    public String getErrorString() {
        return this.b;
    }

    @Override // it.aep_italia.vts.sdk.dto.soap.responses.VtsSoapResponse
    public Integer getReturnCode() {
        return this.c;
    }

    public <T> T getXmlAs(Class<T> cls) throws VtsException {
        return (T) SerializationUtils.deserializeFromXmlBase64(getDataOutXml(), cls);
    }

    public void setDataOutBin(String str) {
        this.e = str;
    }

    public void setDataOutXml(String str) {
        this.d = str;
    }

    public void setErrorString(String str) {
        this.b = str;
    }

    public void setReturnCode(Integer num) {
        this.c = num;
    }
}
