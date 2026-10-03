package it.aep_italia.vts.sdk.dto.soap.functions.responses;

import it.aep_italia.vts.sdk.dto.domain.VtsShoppingCartDTO;
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
public class ShoppingCartOutput {

    @Attribute(name = "Version")
    @Path("vts:Header")
    private int a;

    @Element(name = "ShoppingItems")
    @Path("vts:Body")
    private VtsShoppingCartDTO b;

    public VtsShoppingCartDTO getShoppingCart() {
        return this.b;
    }

    public int getVersion() {
        return this.a;
    }

    public void setShoppingCart(VtsShoppingCartDTO vtsShoppingCartDTO) {
        this.b = vtsShoppingCartDTO;
    }

    public void setVersion(int i) {
        this.a = i;
    }
}
