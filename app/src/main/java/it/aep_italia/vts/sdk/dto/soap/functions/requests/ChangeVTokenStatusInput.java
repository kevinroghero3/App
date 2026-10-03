package it.aep_italia.vts.sdk.dto.soap.functions.requests;

import it.aep_italia.vts.sdk.domain.enums.VtsVTokenStatus;
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
public class ChangeVTokenStatusInput implements VtsSoapFunctionPayload {

    @Attribute(name = "Version")
    @Path("vts:Header")
    private int a = 1;

    @Attribute(name = "VTokenUID")
    @Path("vts:Body/vts:Parameters")
    private String b;

    @Attribute(name = "VTokenStatus")
    @Path("vts:Body/vts:Parameters")
    private int c;

    public ChangeVTokenStatusInput(long j, VtsVTokenStatus vtsVTokenStatus) {
        setVTokenUID(j);
        setVTokenStatus(vtsVTokenStatus);
    }

    @Override // it.aep_italia.vts.sdk.dto.soap.functions.VtsSoapFunctionPayload
    public String getFunctionName() {
        return "vts_FuncChangeVTokenStatus";
    }

    @Override // it.aep_italia.vts.sdk.dto.soap.functions.VtsSoapFunctionPayload
    public String getStringifiedParameters() {
        return String.format(Locale.ITALY, "VTokenUID: %s, VTokenStatus: %d", this.b, Integer.valueOf(this.c));
    }

    public int getVTokenStatus() {
        return this.c;
    }

    public long getVTokenUID() {
        return StringUtils.unsignedHexStringToSignedLong(this.b);
    }

    public void setVTokenStatus(VtsVTokenStatus vtsVTokenStatus) {
        if (vtsVTokenStatus == null) {
            vtsVTokenStatus = VtsVTokenStatus.ACTIVE;
        }
        this.c = vtsVTokenStatus.value();
    }

    public void setVTokenUID(long j) {
        this.b = Long.toHexString(j);
    }
}
