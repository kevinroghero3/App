package it.aep_italia.vts.sdk.dto.soap.functions.requests;

import it.aep_italia.vts.sdk.domain.filters.VtsFilter;
import it.aep_italia.vts.sdk.dto.soap.VtsSoapEnvelope;
import it.aep_italia.vts.sdk.dto.soap.functions.requests.base.FilterableRequestInput;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

/* JADX INFO: loaded from: classes6.dex */
@NamespaceList({@Namespace(prefix = "vts", reference = VtsSoapEnvelope.NAMESPACE_AEP)})
@Root(name = "vts:VTS_RequestFunction")
public class GetDeviceInput extends FilterableRequestInput {
    public GetDeviceInput() {
    }

    public GetDeviceInput(VtsFilter... vtsFilterArr) {
        if (vtsFilterArr == null) {
            return;
        }
        for (VtsFilter vtsFilter : vtsFilterArr) {
            putFilter(vtsFilter);
        }
    }

    @Override // it.aep_italia.vts.sdk.dto.soap.functions.VtsSoapFunctionPayload
    public String getFunctionName() {
        return "vts_FuncGetDevices";
    }
}
