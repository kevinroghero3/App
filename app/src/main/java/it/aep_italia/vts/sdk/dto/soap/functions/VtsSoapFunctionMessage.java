package it.aep_italia.vts.sdk.dto.soap.functions;

import it.aep_italia.vts.sdk.dto.soap.VtsSoapEnvelope;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;

/* JADX INFO: loaded from: classes6.dex */
@Order(elements = {"DataInBin", "DataInXml", "FunctionName", "SessionID"})
@Root(name = "vtsr:msgIn")
public class VtsSoapFunctionMessage {

    @Element(name = "SessionID")
    @Namespace(reference = VtsSoapEnvelope.NAMESPACE_VTSF)
    private String a;

    @Element(name = "FunctionName")
    @Namespace(reference = VtsSoapEnvelope.NAMESPACE_VTSF)
    private String b;

    @Element(name = "DataInXml", required = false)
    @Namespace(reference = VtsSoapEnvelope.NAMESPACE_VTSF)
    private String c;

    @Element(name = "DataInBin", required = false)
    @Namespace(reference = VtsSoapEnvelope.NAMESPACE_VTSF)
    private String d;

    public String getDataInBin() {
        return this.d;
    }

    public String getDataInXml() {
        return this.c;
    }

    public String getFunctionName() {
        return this.b;
    }

    public String getSessionID() {
        return this.a;
    }

    public void setDataInBin(String str) {
        this.d = str;
    }

    public void setDataInXml(String str) {
        this.c = str;
    }

    public void setFunctionName(String str) {
        this.b = str;
    }

    public void setSessionID(String str) {
        this.a = str;
    }
}
