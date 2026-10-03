package it.aep_italia.vts.sdk.dto.soap.functions.requests;

import android.util.Base64;
import it.aep_italia.vts.sdk.dto.soap.VtsSoapEnvelope;
import it.aep_italia.vts.sdk.dto.soap.functions.VtsSoapFunctionPayload;
import java.util.Locale;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

/* JADX INFO: loaded from: classes6.dex */
@NamespaceList({@Namespace(prefix = "vts", reference = VtsSoapEnvelope.NAMESPACE_AEP)})
@Root(name = "vts:VTS_RequestFunction")
public class GetSendMailInput implements VtsSoapFunctionPayload {

    @Attribute(name = "Version")
    @Path("vts:Header")
    private int a = 1;

    @Attribute(name = "To")
    @Path("vts:Body/vts:MailEnvelope")
    private String b;

    @Attribute(name = "Subject")
    @Path("vts:Body/vts:MailEnvelope")
    private String c;

    @Attribute(name = "MessageBody")
    @Path("vts:Body/vts:MailMessage")
    private String d;

    public GetSendMailInput(String str, String str2, String str3) {
        this.b = str.toLowerCase();
        this.c = str2;
        this.d = Base64.encodeToString(str3.getBytes(), 0).trim();
    }

    @Override // it.aep_italia.vts.sdk.dto.soap.functions.VtsSoapFunctionPayload
    public String getFunctionName() {
        return "vts_FuncSendEmail";
    }

    public String getMessageBody() {
        return this.d;
    }

    public String getMessageSubject() {
        return this.c;
    }

    public String getMessageTo() {
        return this.b;
    }

    @Override // it.aep_italia.vts.sdk.dto.soap.functions.VtsSoapFunctionPayload
    public String getStringifiedParameters() {
        return String.format(Locale.ITALY, "To: %s, Subject: %s", "MessageBody: %s", this.b, this.c, this.d);
    }
}
