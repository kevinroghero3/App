package it.aep_italia.vts.sdk.dto.server.server_list;

import it.aep_italia.vts.sdk.utils.StringUtils;
import java.util.ArrayList;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

/* JADX INFO: loaded from: classes6.dex */
@Root(name = "vts:VTS_ServersList")
public class VtsServerListDTO {

    @Attribute(name = "Version")
    @Path("vts:Header")
    private int a;

    @ElementList(entry = "vts:VtsServer", name = "ServersList")
    private ArrayList<VtsServerDTO> b;

    public VtsServerDTO getServerForTypes(int i, int i2) {
        return getServerForTypes(i, i2, null);
    }

    public VtsServerDTO getServerForTypes(int i, int i2, String str) {
        ArrayList<VtsServerDTO> arrayList = this.b;
        if (arrayList == null) {
            return null;
        }
        for (VtsServerDTO vtsServerDTO : arrayList) {
            if (StringUtils.isBlank(str) || str.equals(vtsServerDTO.getID())) {
                if (vtsServerDTO.getSystemForTypes(i, i2) != null) {
                    return vtsServerDTO;
                }
            }
        }
        return null;
    }

    public ArrayList<VtsServerDTO> getServers() {
        ArrayList<VtsServerDTO> arrayList = this.b;
        return arrayList == null ? new ArrayList<>() : arrayList;
    }

    public int getVersion() {
        return this.a;
    }
}
