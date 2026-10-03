package it.aep_italia.vts.sdk.dto.soap.functions.requests;

import it.aep_italia.vts.sdk.domain.enums.VtsVTokenStatus;
import it.aep_italia.vts.sdk.dto.soap.VtsSoapEnvelope;
import it.aep_italia.vts.sdk.dto.soap.functions.VtsSoapFunctionPayload;
import it.aep_italia.vts.sdk.utils.StringUtils;
import java.util.Locale;
import net.openid.appauth.RegistrationRequest;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

/* JADX INFO: loaded from: classes6.dex */
@NamespaceList({@Namespace(prefix = "vts", reference = VtsSoapEnvelope.NAMESPACE_AEP)})
@Root(name = "vts:VTS_RequestFunction")
public class GetVTokenListInput implements VtsSoapFunctionPayload {

    @Attribute(name = "Version")
    @Path("vts:Header")
    private int a = 1;

    @Attribute(name = "DeviceUID")
    @Path("vts:Body/vts:Parameters")
    private String b;

    @Attribute(name = "ListType")
    @Path("vts:Body/vts:Parameters")
    private String c;

    @Attribute(name = "VTokenStatus", required = false)
    @Path("vts:Body/vts:Parameters")
    private Integer d;

    public enum ListType {
        PRIVATE("private"),
        PUBLIC(RegistrationRequest.SUBJECT_TYPE_PUBLIC),
        ALL("all");

        private String value;

        ListType(String str) {
            this.value = str;
        }
    }

    public GetVTokenListInput(long j, ListType listType, VtsVTokenStatus vtsVTokenStatus) {
        this.c = "all";
        this.b = Long.toHexString(j);
        this.c = listType.value;
        if (vtsVTokenStatus != null) {
            this.d = Integer.valueOf(vtsVTokenStatus.value());
        }
    }

    public long getDeviceUID() {
        return StringUtils.unsignedHexStringToSignedLong(this.b);
    }

    @Override // it.aep_italia.vts.sdk.dto.soap.functions.VtsSoapFunctionPayload
    public String getFunctionName() {
        return "vts_FuncGetVtokenList";
    }

    public ListType getListType() {
        return ListType.valueOf(this.c.toUpperCase(Locale.ITALY));
    }

    @Override // it.aep_italia.vts.sdk.dto.soap.functions.VtsSoapFunctionPayload
    public String getStringifiedParameters() {
        return String.format(Locale.ITALY, "DeviceUID: %s; ListType: %s, VTokenStatus: %s", this.b, this.c, "" + this.d);
    }

    public void setDeviceUID(long j) {
        this.b = Long.toHexString(j);
    }

    public void setListType(ListType listType) {
        this.c = listType.value;
    }
}
