package it.aep_italia.vts.sdk.domain;

import it.aep_italia.vts.sdk.dto.server.server_list.VtsAuthorizedAppDTO;
import it.aep_italia.vts.sdk.dto.server.server_list.VtsServerDTO;
import it.aep_italia.vts.sdk.dto.server.server_list.VtsSystemDTO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class VtsServer {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private List<VtsSystem> f;
    private List<VtsAuthorizedApp> g;

    public static VtsServer fromDto(VtsServerDTO vtsServerDTO) {
        if (vtsServerDTO == null) {
            return new VtsServer();
        }
        VtsServer vtsServer = new VtsServer();
        vtsServer.a = vtsServerDTO.getID();
        vtsServer.b = vtsServerDTO.getDescription();
        vtsServer.c = vtsServerDTO.getServerUri();
        vtsServer.d = vtsServerDTO.getServerUriSSL();
        vtsServer.e = vtsServerDTO.getServerURISSLCertCN();
        vtsServer.f = new ArrayList();
        vtsServer.g = new ArrayList();
        Iterator<VtsSystemDTO> it2 = vtsServerDTO.getSystems().iterator();
        while (it2.hasNext()) {
            vtsServer.f.add(VtsSystem.fromDto(it2.next()));
        }
        Iterator<VtsAuthorizedAppDTO> it3 = vtsServerDTO.getAuthApps().iterator();
        while (it3.hasNext()) {
            vtsServer.g.add(VtsAuthorizedApp.fromDto(it3.next()));
        }
        return vtsServer;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        String str = this.a;
        String str2 = ((VtsServer) obj).a;
        if (str != null) {
            return str.equals(str2);
        }
        return str2 == null;
    }

    public List<VtsAuthorizedApp> getAuthorizedApps() {
        return this.g;
    }

    public String getDescription() {
        return this.b;
    }

    public String getId() {
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

    public List<VtsSystem> getSystems() {
        return this.f;
    }

    public int hashCode() {
        String str = this.a;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public VtsSystem searchSystem(int i, int i2) {
        List<VtsSystem> list = this.f;
        if (list == null) {
            return null;
        }
        for (VtsSystem vtsSystem : list) {
            if (vtsSystem.getSystemType() == i && vtsSystem.getSystemSubType() == i2) {
                return vtsSystem;
            }
        }
        return null;
    }
}
