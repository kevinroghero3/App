package it.aep_italia.vts.sdk.dto.soap.functions.responses;

import it.aep_italia.vts.sdk.dto.server.server_info.VtsServerInfoDTO;
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
public class GetServerInfoOutput {

    @Attribute(name = "Version")
    @Path("vts:Header")
    private int a;

    @Element(name = "Body")
    private VtsServerInfoDTO b;

    public VtsServerInfoDTO getServerInfo() {
        return this.b;
    }

    public int getVersion() {
        return this.a;
    }

    public void setServerInfo(VtsServerInfoDTO vtsServerInfoDTO) {
        this.b = vtsServerInfoDTO;
    }

    public void setVersion(int i) {
        this.a = i;
    }
}
