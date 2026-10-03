package it.aep_italia.vts.sdk.dto.domain;

import it.aep_italia.vts.sdk.dto.soap.VtsSoapEnvelope;
import java.util.ArrayList;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

/* JADX INFO: loaded from: classes6.dex */
@NamespaceList({@Namespace(prefix = "vts", reference = VtsSoapEnvelope.NAMESPACE_AEP)})
@Root(name = "vts:ShoppingItems")
public class VtsShoppingCartDTO {

    @Attribute(name = "Count")
    private int a;

    @Attribute(name = "SubTotalEuroCent")
    private int b;

    @ElementList(entry = "ShoppingItem", inline = true, required = false)
    private ArrayList<VtsShoppingItemDTO> c;

    public int getCount() {
        return this.a;
    }

    public ArrayList<VtsShoppingItemDTO> getShoppingItems() {
        ArrayList<VtsShoppingItemDTO> arrayList = this.c;
        return arrayList == null ? new ArrayList<>() : arrayList;
    }

    public int getSubTotalEuroCent() {
        return this.b;
    }

    public void setCount(int i) {
        this.a = i;
    }

    public void setShoppingItems(ArrayList<VtsShoppingItemDTO> arrayList) {
        this.c = arrayList;
    }

    public void setSubTotalEuroCent(int i) {
        this.b = i;
    }
}
