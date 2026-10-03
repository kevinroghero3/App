package it.aep_italia.vts.sdk.domain;

import it.aep_italia.vts.sdk.dto.server.server_list.VtsSystemDTO;

/* JADX INFO: loaded from: classes6.dex */
public class VtsSystem {
    private String a;
    private int b;
    private int c;

    public static VtsSystem fromDto(VtsSystemDTO vtsSystemDTO) {
        if (vtsSystemDTO == null) {
            return new VtsSystem();
        }
        VtsSystem vtsSystem = new VtsSystem();
        vtsSystem.a = vtsSystemDTO.getDescription();
        vtsSystem.b = vtsSystemDTO.getSystemType();
        vtsSystem.c = vtsSystemDTO.getSystemSubType();
        return vtsSystem;
    }

    public String getDescription() {
        return this.a;
    }

    public int getSystemSubType() {
        return this.c;
    }

    public int getSystemType() {
        return this.b;
    }
}
