package it.aep_italia.vts.sdk.dto.server.server_list;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

/* JADX INFO: loaded from: classes6.dex */
@Root(name = "vts:VtsSystem")
public class VtsSystemDTO {

    @Attribute(name = "Description")
    private String a;

    @Attribute(name = "SystemType", required = false)
    private int b;

    @Attribute(name = "SystemSubType", required = false)
    private int c;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        VtsSystemDTO vtsSystemDTO = (VtsSystemDTO) obj;
        return this.b == vtsSystemDTO.b && this.c == vtsSystemDTO.c;
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

    public int hashCode() {
        return (this.b * 31) + this.c;
    }
}
