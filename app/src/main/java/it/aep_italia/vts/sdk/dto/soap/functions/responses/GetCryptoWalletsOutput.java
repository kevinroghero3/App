package it.aep_italia.vts.sdk.dto.soap.functions.responses;

import it.aep_italia.vts.sdk.dto.domain.VtsCryptoWalletsDTO;
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
public class GetCryptoWalletsOutput {

    @Attribute(name = "Version")
    @Path("vts:Header")
    private int a;

    @Element(name = "Body")
    private VtsCryptoWalletsDTO b;

    public VtsCryptoWalletsDTO getCryptoWallets() {
        return this.b;
    }

    public int getVersion() {
        return this.a;
    }

    public void setCryptoWallets(VtsCryptoWalletsDTO vtsCryptoWalletsDTO) {
        this.b = vtsCryptoWalletsDTO;
    }

    public void setVersion(int i) {
        this.a = i;
    }
}
