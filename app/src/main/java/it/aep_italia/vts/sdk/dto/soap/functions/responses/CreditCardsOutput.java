package it.aep_italia.vts.sdk.dto.soap.functions.responses;

import it.aep_italia.vts.sdk.dto.domain.VtsCreditCardDTO;
import it.aep_italia.vts.sdk.dto.soap.VtsSoapEnvelope;
import java.util.ArrayList;
import java.util.List;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

/* JADX INFO: loaded from: classes6.dex */
@NamespaceList({@Namespace(prefix = "vts", reference = VtsSoapEnvelope.NAMESPACE_AEP)})
@Root(name = "vts:VTS_RequestFunction")
public class CreditCardsOutput {

    @Attribute(name = "Version")
    @Path("vts:Header")
    private int a;

    @Element(name = "CreditCards", required = false)
    @Path("vts:Body")
    private VtsCreditCardListDTO b;

    public static class VtsCreditCardListDTO {

        @Attribute(name = "Count")
        private int a;

        @ElementList(entry = "CreditCard", inline = true, required = false)
        private ArrayList<VtsCreditCardDTO> b;
    }

    public List<VtsCreditCardDTO> getCreditCards() {
        VtsCreditCardListDTO vtsCreditCardListDTO = this.b;
        return (vtsCreditCardListDTO == null || vtsCreditCardListDTO.b == null) ? new ArrayList() : this.b.b;
    }

    public int getVersion() {
        return this.a;
    }

    public void setCreditCards(List<VtsCreditCardDTO> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        VtsCreditCardListDTO vtsCreditCardListDTO = new VtsCreditCardListDTO();
        this.b = vtsCreditCardListDTO;
        vtsCreditCardListDTO.b = new ArrayList(list);
        this.b.a += list.size();
    }

    public void setVersion(int i) {
        this.a = i;
    }
}
