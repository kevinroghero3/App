package it.aep_italia.vts.sdk.domain;

import it.aep_italia.vts.sdk.dto.server.server_list.VtsAuthorizedAppDTO;

/* JADX INFO: loaded from: classes6.dex */
public class VtsAuthorizedApp {
    private String a;
    private String b;
    private boolean c;
    private boolean d;

    public static VtsAuthorizedApp fromDto(VtsAuthorizedAppDTO vtsAuthorizedAppDTO) {
        if (vtsAuthorizedAppDTO == null) {
            return new VtsAuthorizedApp();
        }
        VtsAuthorizedApp vtsAuthorizedApp = new VtsAuthorizedApp();
        vtsAuthorizedApp.a = vtsAuthorizedAppDTO.getDescription();
        vtsAuthorizedApp.b = vtsAuthorizedAppDTO.getApplicationKeyId();
        vtsAuthorizedApp.c = vtsAuthorizedAppDTO.isListEnable();
        vtsAuthorizedApp.d = vtsAuthorizedAppDTO.isConnectEnable();
        return vtsAuthorizedApp;
    }

    public String getApplicationKeyId() {
        return this.b;
    }

    public String getDescription() {
        return this.a;
    }

    public boolean isConnectEnable() {
        return this.d;
    }

    public boolean isListEnable() {
        return this.c;
    }
}
