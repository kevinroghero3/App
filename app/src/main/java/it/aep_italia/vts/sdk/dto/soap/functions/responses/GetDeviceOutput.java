package it.aep_italia.vts.sdk.dto.soap.functions.responses;

import com.facebook.fbreact.specs.NativeDeviceInfoSpec;
import it.aep_italia.vts.sdk.dto.domain.VtsDeviceDTO;
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
public class GetDeviceOutput {

    @Attribute(name = "Version")
    @Path("vts:Header")
    private int a;

    @ElementList(entry = NativeDeviceInfoSpec.NAME, name = "DevicesInfo")
    @Path("vts:Body")
    private ArrayList<VtsDeviceDTO> b;

    public ArrayList<VtsDeviceDTO> getDevices() {
        return this.b;
    }

    public int getVersion() {
        return this.a;
    }

    public void setDevices(ArrayList<VtsDeviceDTO> arrayList) {
        this.b = arrayList;
    }

    public void setVersion(int i) {
        this.a = i;
    }
}
