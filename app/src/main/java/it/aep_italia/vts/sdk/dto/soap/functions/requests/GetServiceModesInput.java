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
public class GetServiceModesInput extends FilterableRequestInput {
    public GetServiceModesInput() {
    }

    public GetServiceModesInput(VtsFilter... vtsFilterArr) {
        super(vtsFilterArr);
    }

    @Override // it.aep_italia.vts.sdk.dto.soap.functions.VtsSoapFunctionPayload
    public String getFunctionName() {
        return "vts_FuncGetServiceModes";
    }
}
