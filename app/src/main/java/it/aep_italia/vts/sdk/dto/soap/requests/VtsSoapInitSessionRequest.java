package it.aep_italia.vts.sdk.dto.soap.requests;

import it.aep_italia.vts.sdk.dto.soap.VtsSoapEnvelope;
import it.aep_italia.vts.sdk.dto.soap.VtsSoapHeader;
import it.aep_italia.vts.sdk.errors.VtsError;
import it.aep_italia.vts.sdk.errors.VtsException;
import it.aep_italia.vts.sdk.utils.SerializationUtils;
import it.aep_italia.vts.sdk.utils.ValidationUtils;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

/* JADX INFO: loaded from: classes6.dex */
@Root(name = "soap:Envelope")
public class VtsSoapInitSessionRequest extends VtsSoapEnvelope {

    @Element(name = "vtsf:DataIn", required = false)
    @Path("soap:Body/vtsr:vts_InitSession/vtsr:msgIn")
    private String b;

    public VtsSoapInitSessionRequest(String str, VtsSoapInitSessionInput vtsSoapInitSessionInput) throws VtsException {
        super(new VtsSoapHeader(str, "http://tempuri.org/IServiceVtsFrontend/vts_InitSession"));
        ValidationUtils.assertNonNull(vtsSoapInitSessionInput, VtsError.INVALID_PARAMETER, "Payload cannot be null.", new Object[0]);
        setData(vtsSoapInitSessionInput == null ? null : SerializationUtils.serializeToXmlBase64(vtsSoapInitSessionInput));
    }

    public String getData() {
        return this.b;
    }

    public void setData(String str) {
        this.b = str;
    }
}
