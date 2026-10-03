package it.aep_italia.vts.sdk.dto.soap.functions.responses;

import it.aep_italia.vts.sdk.dto.domain.PspPaymentRedirectDTO;
import it.aep_italia.vts.sdk.dto.soap.VtsSoapEnvelope;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

/* JADX INFO: loaded from: classes6.dex */
@NamespaceList({@Namespace(prefix = "vts", reference = VtsSoapEnvelope.NAMESPACE_AEP)})
@Root(name = "vts:VTS_RequestFunction")
public class GetPspPaymentUrlOutput {

    @Attribute(name = "Version")
    @Path("vts:Header")
    private int a;

    @Element(name = "PspPaymentRedirect")
    @Path("vts:Body")
    private PspPaymentRedirectDTO b;

    public PspPaymentRedirectDTO getPspPaymentRedirect() {
        return this.b;
    }

    public int getVersion() {
        return this.a;
    }

    public void setPspPaymentRedirect(PspPaymentRedirectDTO pspPaymentRedirectDTO) {
        this.b = this.b;
    }

    public void setVersion(int i) {
        this.a = i;
    }
}
