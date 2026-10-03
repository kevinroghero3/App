package it.aep_italia.vts.sdk.dto.server.server_list;

import java.util.ArrayList;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

/* JADX INFO: loaded from: classes6.dex */
@Root(name = "vts:VtsServer")
public class VtsServerDTO {

    @Attribute(name = "ServerID")
    private String a;

    @Attribute(name = "Description", required = false)
    private String b;

    @Attribute(name = "ServerURI", required = false)
    private String c;

    @Attribute(name = "ServerURISSL", required = false)
    private String d;

    @Attribute(name = "ServerURISSLCertCN", required = false)
    private String e;

    @ElementList(entry = "VtsSystem", inline = true, required = false)
    private ArrayList<VtsSystemDTO> f;

    @ElementList(entry = "AuthorizedApp", inline = true, required = false)
    private ArrayList<VtsAuthorizedAppDTO> g;

    public ArrayList<VtsAuthorizedAppDTO> getAuthApps() {
        ArrayList<VtsAuthorizedAppDTO> arrayList = this.g;
        return arrayList == null ? new ArrayList<>() : arrayList;
    }

    public String getDescription() {
        return this.b;
    }

    public String getID() {
        return this.a;
    }

    public String getServerURISSLCertCN() {
        return this.e;
    }

    public String getServerUri() {
        return this.c;
    }

    public String getServerUriSSL() {
        return this.d;
    }

    public VtsSystemDTO getSystemForTypes(int i, int i2) {
        ArrayList<VtsSystemDTO> arrayList = this.f;
        if (arrayList == null) {
            return null;
        }
        for (VtsSystemDTO vtsSystemDTO : arrayList) {
            if (vtsSystemDTO.getSystemType() == i && vtsSystemDTO.getSystemSubType() == i2) {
                return vtsSystemDTO;
            }
        }
        return null;
    }

    public ArrayList<VtsSystemDTO> getSystems() {
        ArrayList<VtsSystemDTO> arrayList = this.f;
        return arrayList == null ? new ArrayList<>() : arrayList;
    }
}
