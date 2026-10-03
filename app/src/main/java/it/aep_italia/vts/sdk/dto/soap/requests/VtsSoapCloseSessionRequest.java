package it.aep_italia.vts.sdk.dto.soap.requests;

import it.aep_italia.vts.sdk.dto.soap.VtsSoapEnvelope;
import it.aep_italia.vts.sdk.dto.soap.VtsSoapHeader;
import it.aep_italia.vts.sdk.errors.VtsError;
import it.aep_italia.vts.sdk.utils.ValidationUtils;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

/* JADX INFO: loaded from: classes6.dex */
@Root(name = "soap:Envelope")
public class VtsSoapCloseSessionRequest extends VtsSoapEnvelope {

    @Element(name = "vtsf:SessionID")
    @Path("soap:Body/vtsr:vts_CloseSession/vtsr:msgIn")
    private String b;

    public VtsSoapCloseSessionRequest(String str, String str2) {
        super(new VtsSoapHeader(str, "http://tempuri.org/IServiceVtsFrontend/vts_CloseSession"));
        ValidationUtils.assertNonBlank(str2, VtsError.INVALID_PARAMETER, "SessionID cannot be null", new Object[0]);
        setSessionID(str2);
    }

    public String getSessionID() {
        return this.b;
    }

    public void setSessionID(String str) {
        this.b = str;
    }
}
