package it.aep_italia.vts.sdk.dto.soap.functions.responses;

import it.aep_italia.vts.sdk.dto.domain.VtsStopDTO;
import it.aep_italia.vts.sdk.dto.soap.VtsSoapEnvelope;
import java.util.ArrayList;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

/* JADX INFO: loaded from: classes6.dex */
@NamespaceList({@Namespace(prefix = "vts", reference = VtsSoapEnvelope.NAMESPACE_AEP)})
@Root(name = "vts:VTS_RequestFunction")
public class GetStopsOutput {

    @Attribute(name = "Version")
    @Path("vts:Header")
    private int a;

    @ElementList(entry = "Stop", name = "Stops")
    @Path("vts:Body")
    private ArrayList<VtsStopDTO> b;

    public ArrayList<VtsStopDTO> getStops() {
        return this.b;
    }

    public int getVersion() {
        return this.a;
    }

    public void setStops(ArrayList<VtsStopDTO> arrayList) {
        this.b = arrayList;
    }

    public void setVersion(int i) {
        this.a = i;
    }
}
