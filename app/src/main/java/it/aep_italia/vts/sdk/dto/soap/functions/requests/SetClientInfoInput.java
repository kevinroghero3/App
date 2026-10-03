package it.aep_italia.vts.sdk.dto.soap.functions.requests;

import it.aep_italia.vts.sdk.dto.server.server_info.VtsServerUserDataDTO;
import it.aep_italia.vts.sdk.dto.soap.VtsSoapEnvelope;
import it.aep_italia.vts.sdk.dto.soap.functions.VtsSoapFunctionPayload;
import it.aep_italia.vts.sdk.dto.utils.VtsUserDataDTO;
import java.util.Locale;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

/* JADX INFO: loaded from: classes6.dex */
@NamespaceList({@Namespace(prefix = "vts", reference = VtsSoapEnvelope.NAMESPACE_AEP)})
@Root(name = "vts:VTS_RequestFunction")
public class SetClientInfoInput implements VtsSoapFunctionPayload {

    @Attribute(name = "Version")
    @Path("vts:Header")
    private int a = 1;

    @Attribute(name = "IdleTimeoutSec", required = false)
    @Path("vts:Body/vts:Parameters/vts:ClientPreferences")
    private Integer b;

    @Attribute(name = "UserLangType", required = false)
    @Path("vts:Body/vts:Parameters/vts:ClientPreferences")
    private String c;

    @Attribute(name = "ErrorMsgLangType", required = false)
    @Path("vts:Body/vts:Parameters/vts:ClientPreferences")
    private String d;

    @Element(name = "UserData", required = false)
    @Path("vts:Body/vts:Parameters")
    private VtsServerUserDataDTO e;

    public SetClientInfoInput(int i, String str, String str2, VtsUserDataDTO vtsUserDataDTO) {
        this.b = Integer.valueOf(i);
        this.c = str;
        this.d = str2;
        this.e = new VtsServerUserDataDTO(vtsUserDataDTO);
    }

    public String getErrorLangType() {
        return this.d;
    }

    @Override // it.aep_italia.vts.sdk.dto.soap.functions.VtsSoapFunctionPayload
    public String getFunctionName() {
        return "vts_FuncSetClientInfo";
    }

    public Integer getIdleTimeout() {
        return this.b;
    }

    @Override // it.aep_italia.vts.sdk.dto.soap.functions.VtsSoapFunctionPayload
    public String getStringifiedParameters() {
        Locale locale = Locale.ITALY;
        String str = String.format(locale, "IdleTimeoutSec: %s; UserLangType: %s; ErrorMsgLangType: %s", this.b, this.c, this.d);
        if (this.e == null) {
            return str;
        }
        return str + String.format(locale, "; FirstName: %s; LastName: %s; BirthDate: %s; Sex: %s; FiscalCode: %s; EMail: %s; PhotoImage: %s", this.e.getFirstName(), this.e.getLastName(), this.e.getBirthDate(), this.e.getSex(), this.e.getFiscalCode(), this.e.getEmail(), this.e.getPhotoImage());
    }

    public VtsServerUserDataDTO getUserData() {
        return this.e;
    }

    public String getUserLangType() {
        return this.c;
    }

    public void setErrorLangType(String str) {
        this.d = str;
    }

    public void setIdleTimeout(Integer num) {
        this.b = num;
    }

    public void setUserData(VtsServerUserDataDTO vtsServerUserDataDTO) {
        this.e = vtsServerUserDataDTO;
    }

    public void setUserLangType(String str) {
        this.c = str;
    }
}
