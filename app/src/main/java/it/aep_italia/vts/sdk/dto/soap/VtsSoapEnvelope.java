package it.aep_italia.vts.sdk.dto.soap;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;

/* JADX INFO: loaded from: classes6.dex */
@NamespaceList({@Namespace(prefix = "soap", reference = VtsSoapEnvelope.NAMESPACE_SOAP), @Namespace(prefix = "vtsr", reference = VtsSoapEnvelope.NAMESPACE_VTSR), @Namespace(prefix = "vtsf", reference = VtsSoapEnvelope.NAMESPACE_VTSF)})
public abstract class VtsSoapEnvelope {
    public static final String NAMESPACE_ADDR = "http://www.w3.org/2005/08/addressing";
    public static final String NAMESPACE_AEP = "http://www.aep-italia.it/vts/";
    public static final String NAMESPACE_SOAP = "http://www.w3.org/2003/05/soap-envelope";
    public static final String NAMESPACE_VTSF = "http://schemas.datacontract.org/2004/07/VTS_Frontend";
    public static final String NAMESPACE_VTSR = "http://tempuri.org/";

    @Element(name = "Header", required = false)
    @Namespace(reference = NAMESPACE_SOAP)
    private VtsSoapHeader a;

    public VtsSoapEnvelope(VtsSoapHeader vtsSoapHeader) {
        setHeader(vtsSoapHeader);
    }

    public VtsSoapHeader getHeader() {
        return this.a;
    }

    public void setHeader(VtsSoapHeader vtsSoapHeader) {
        this.a = vtsSoapHeader;
    }
}
