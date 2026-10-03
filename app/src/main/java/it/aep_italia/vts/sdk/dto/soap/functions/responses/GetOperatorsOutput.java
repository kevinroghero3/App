package it.aep_italia.vts.sdk.dto.soap.functions.responses;

import it.aep_italia.vts.sdk.domain.VtsOperator;
import it.aep_italia.vts.sdk.dto.domain.VtsOperatorDTO;
import it.aep_italia.vts.sdk.dto.soap.VtsSoapEnvelope;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

/* JADX INFO: loaded from: classes6.dex */
@NamespaceList({@Namespace(prefix = "vts", reference = VtsSoapEnvelope.NAMESPACE_AEP)})
@Root(name = "vts:VTS_RequestFunction")
public class GetOperatorsOutput {

    @Attribute(name = "Version")
    @Path("vts:Header")
    private int a;

    @ElementList(entry = "vts:Operator", name = "Operators")
    @Path("vts:Body")
    private ArrayList<VtsOperatorDTO> b;

    public List<VtsOperator> buildOperators() {
        if (this.b == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<VtsOperatorDTO> it2 = this.b.iterator();
        while (it2.hasNext()) {
            arrayList.add(VtsOperator.fromDto(it2.next()));
        }
        return arrayList;
    }

    public ArrayList<VtsOperatorDTO> getOperators() {
        return this.b;
    }

    public int getVersion() {
        return this.a;
    }

    public void setOperators(ArrayList<VtsOperatorDTO> arrayList) {
        this.b = arrayList;
    }

    public void setVersion(int i) {
        this.a = i;
    }
}
