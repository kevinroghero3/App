package it.aep_italia.vts.sdk.dto.soap.requests;

import android.util.Base64;
import it.aep_italia.vts.sdk.dto.soap.VtsSoapEnvelope;
import it.aep_italia.vts.sdk.dto.soap.VtsSoapHeader;
import it.aep_italia.vts.sdk.dto.soap.functions.VtsSoapFunctionMessage;
import it.aep_italia.vts.sdk.dto.soap.functions.VtsSoapFunctionPayload;
import it.aep_italia.vts.sdk.errors.VtsError;
import it.aep_italia.vts.sdk.errors.VtsException;
import it.aep_italia.vts.sdk.utils.SerializationUtils;
import it.aep_italia.vts.sdk.utils.StringUtils;
import it.aep_italia.vts.sdk.utils.ValidationUtils;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

/* JADX INFO: loaded from: classes6.dex */
@Root(name = "soap:Envelope")
public class VtsSoapRequestFunctionRequest extends VtsSoapEnvelope {

    @Element(name = "vtsr:msgIn")
    @Path("soap:Body/vtsr:vts_RequestFunction")
    private VtsSoapFunctionMessage b;

    public VtsSoapRequestFunctionRequest(String str, String str2, VtsSoapFunctionPayload vtsSoapFunctionPayload, byte[] bArr) throws VtsException {
        super(new VtsSoapHeader(str, "http://tempuri.org/IServiceVtsFrontend/vts_RequestFunction"));
        ValidationUtils.assertNonNull(vtsSoapFunctionPayload, VtsError.INVALID_PARAMETER, "Payload cannot be null", new Object[0]);
        this.b = new VtsSoapFunctionMessage();
        setSessionID(str2);
        setFunctionName(vtsSoapFunctionPayload.getFunctionName());
        String serializedForm = vtsSoapFunctionPayload.getSerializedForm();
        setDataInXml(!StringUtils.isBlank(serializedForm) ? SerializationUtils.toBase64String(serializedForm) : SerializationUtils.serializeToXmlBase64(vtsSoapFunctionPayload));
        if (bArr != null) {
            setDataInBin(Base64.encodeToString(bArr, 2));
        }
    }

    public String getDataInBin() {
        return this.b.getDataInBin();
    }

    public String getDataInXml() {
        return this.b.getDataInXml();
    }

    public String getFunctionName() {
        return this.b.getFunctionName();
    }

    public String getSessionID() {
        return this.b.getSessionID();
    }

    public void setDataInBin(String str) {
        this.b.setDataInBin(str);
    }

    public void setDataInXml(String str) {
        this.b.setDataInXml(str);
    }

    public void setFunctionName(String str) {
        this.b.setFunctionName(str);
    }

    public void setSessionID(String str) {
        this.b.setSessionID(str);
    }
}
