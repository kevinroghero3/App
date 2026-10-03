package it.aep_italia.vts.sdk.dto.soap;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;

/* JADX INFO: loaded from: classes6.dex */
@NamespaceList({@Namespace(prefix = "adr", reference = VtsSoapEnvelope.NAMESPACE_ADDR)})
public class VtsSoapHeader {

    @Element(name = "To", required = false)
    @Namespace(prefix = "adr", reference = VtsSoapEnvelope.NAMESPACE_ADDR)
    private String a;

    @Element(name = "Action", required = false)
    @Namespace(prefix = "adr", reference = VtsSoapEnvelope.NAMESPACE_ADDR)
    private String b;

    public VtsSoapHeader() {
    }

    public VtsSoapHeader(String str, String str2) {
        setTo(str);
        setAction(str2);
    }

    public String getAction() {
        return this.b;
    }

    public String getTo() {
        return this.a;
    }

    public void setAction(String str) {
        this.b = str;
    }

    public void setTo(String str) {
        this.a = str;
    }
}
