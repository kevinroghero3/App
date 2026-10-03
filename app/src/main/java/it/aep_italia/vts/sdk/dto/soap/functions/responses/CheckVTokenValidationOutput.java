package it.aep_italia.vts.sdk.dto.soap.functions.responses;

import it.aep_italia.vts.sdk.dto.soap.VtsSoapEnvelope;
import it.aep_italia.vts.sdk.dto.utils.VtsValidationResultDTO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

/* JADX INFO: loaded from: classes6.dex */
@NamespaceList({@Namespace(prefix = "vts", reference = VtsSoapEnvelope.NAMESPACE_AEP)})
@Root(name = "vts:VTS_RequestFunction")
public class CheckVTokenValidationOutput {

    @Attribute(name = "Version")
    @Path("vts:Header")
    private int a;

    @Attribute(name = "ValidationResult")
    @Path("vts:Body/vts:Result")
    private int b;

    @ElementList(entry = "UserMessage", inline = true)
    @Path("vts:Body/vts:Result")
    private ArrayList<a> c;

    static class a implements Serializable {
        private static final long serialVersionUID = 8574442714537672168L;

        @Attribute(name = "MessageText")
        private String messageText;

        private a() {
        }
    }

    public VtsValidationResultDTO getResult() {
        ArrayList arrayList = new ArrayList();
        ArrayList<a> arrayList2 = this.c;
        if (arrayList2 != null) {
            Iterator<a> it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                arrayList.add(it2.next().messageText);
            }
        }
        return new VtsValidationResultDTO(this.b, arrayList);
    }

    public ArrayList<a> getValidationMessages() {
        return this.c;
    }

    public int getValidationResult() {
        return this.b;
    }

    public int getVersion() {
        return this.a;
    }

    public void setValidationResult(int i) {
        this.b = i;
    }

    public void setVersion(int i) {
        this.a = i;
    }
}
