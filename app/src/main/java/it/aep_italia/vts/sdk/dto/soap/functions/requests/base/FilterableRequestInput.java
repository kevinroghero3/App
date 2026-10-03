package it.aep_italia.vts.sdk.dto.soap.functions.requests.base;

import it.aep_italia.vts.sdk.domain.filters.VtsFilter;
import it.aep_italia.vts.sdk.dto.soap.functions.VtsSoapFunctionPayload;
import java.util.HashMap;
import java.util.Map;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.Path;

/* JADX INFO: loaded from: classes6.dex */
public abstract class FilterableRequestInput implements VtsSoapFunctionPayload {

    @Attribute(name = "Version")
    @Path("vts:Header")
    protected int version = 1;

    @ElementMap(attribute = true, entry = "vts:Parameter", inline = true, key = "ParameterId", keyType = Integer.class, value = "ParameterValue", valueType = Integer.class)
    @Path("vts:Body/vts:Parameters")
    protected Map<Integer, String> filters = new HashMap();

    public FilterableRequestInput() {
    }

    public FilterableRequestInput(VtsFilter... vtsFilterArr) {
        if (vtsFilterArr == null) {
            return;
        }
        for (VtsFilter vtsFilter : vtsFilterArr) {
            putFilter(vtsFilter);
        }
    }

    @Override // it.aep_italia.vts.sdk.dto.soap.functions.VtsSoapFunctionPayload
    public String getStringifiedParameters() {
        if (this.filters.size() == 0) {
            return "(none)";
        }
        StringBuilder sb = new StringBuilder();
        for (Integer num : this.filters.keySet()) {
            if (sb.length() > 0) {
                sb.append("; ");
            }
            sb.append(num);
            sb.append(": ");
            sb.append(this.filters.get(num));
        }
        return sb.toString();
    }

    public void putFilter(VtsFilter vtsFilter) {
        if (vtsFilter == null) {
            return;
        }
        this.filters.put(Integer.valueOf(vtsFilter.getFilterID()), vtsFilter.getFilterValue());
    }

    public void removeFilter(VtsFilter vtsFilter) {
        if (vtsFilter == null) {
            return;
        }
        this.filters.remove(Integer.valueOf(vtsFilter.getFilterID()));
    }
}
