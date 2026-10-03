package it.aep_italia.vts.sdk.dto.server.server_list;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

/* JADX INFO: loaded from: classes6.dex */
@Root(name = "vts:VtsSystem")
public class VtsAuthorizedAppDTO {

    @Attribute(name = "Description")
    private String a;

    @Attribute(name = "ApplicationKeyId", required = false)
    private String b;

    @Attribute(name = "ListEnable", required = false)
    private boolean c;

    @Attribute(name = "ConnectEnable", required = false)
    private boolean d;

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
