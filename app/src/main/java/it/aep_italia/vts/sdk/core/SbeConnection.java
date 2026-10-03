package it.aep_italia.vts.sdk.core;

import it.aep_italia.vts.sdk.domain.SbeCustomer;
import it.aep_italia.vts.sdk.domain.filters.VtsFilter;
import it.aep_italia.vts.sdk.dto.soap.VtsSoapReturnCode;
import it.aep_italia.vts.sdk.dto.soap.functions.VtsSoapFunctionPayload;
import it.aep_italia.vts.sdk.dto.soap.functions.requests.GetCustomerInput;
import it.aep_italia.vts.sdk.dto.soap.functions.requests.PutCustomerInput;
import it.aep_italia.vts.sdk.dto.soap.functions.responses.GetCustomerOutput;
import it.aep_italia.vts.sdk.dto.soap.responses.VtsSoapRequestFunctionResponse;
import it.aep_italia.vts.sdk.errors.VtsError;
import it.aep_italia.vts.sdk.errors.VtsException;
import it.aep_italia.vts.sdk.utils.StringUtils;
import it.aep_italia.vts.sdk.utils.ValidationUtils;

/* JADX INFO: loaded from: classes6.dex */
public class SbeConnection extends VtsConnection {
    private VtsSdk e;
    private final b f;

    SbeConnection(VtsSdk vtsSdk) {
        super(vtsSdk);
        this.e = vtsSdk;
        this.f = new b(this);
    }

    private VtsSoapRequestFunctionResponse a(VtsSoapFunctionPayload vtsSoapFunctionPayload, byte[] bArr) {
        return a(vtsSoapFunctionPayload, bArr, true);
    }

    private VtsSoapRequestFunctionResponse a(VtsSoapFunctionPayload vtsSoapFunctionPayload, byte[] bArr, boolean z) {
        ValidationUtils.assertNonNull(vtsSoapFunctionPayload, VtsError.INVALID_PARAMETER, "Request cannot be null", new Object[0]);
        VtsSoapReturnCode vtsSoapReturnCode = VtsSoapReturnCode.NO_ERROR;
        setLastErrorCode(Integer.valueOf(vtsSoapReturnCode.value()));
        VtsLog.d("[%s] Starting new %s request with parameters [%s]", this.f.f(), vtsSoapFunctionPayload.getFunctionName(), vtsSoapFunctionPayload.getStringifiedParameters());
        VtsSoapRequestFunctionResponse vtsSoapRequestFunctionResponseA = this.f.a(vtsSoapFunctionPayload, bArr);
        VtsError vtsError = VtsError.REQUEST_FAILED;
        ValidationUtils.assertNonNull(vtsSoapRequestFunctionResponseA, vtsError, "Received a null response", new Object[0]);
        setLastErrorCode(vtsSoapRequestFunctionResponseA.getReturnCode());
        boolean z2 = vtsSoapRequestFunctionResponseA.getReturnCode() == null || vtsSoapRequestFunctionResponseA.getReturnCode().intValue() != vtsSoapReturnCode.value();
        Object[] objArr = {this.f.f(), vtsSoapFunctionPayload.getFunctionName(), vtsSoapRequestFunctionResponseA.getReturnCode(), VtsSoapReturnCode.parse(vtsSoapRequestFunctionResponseA.getReturnCode())};
        if (z2) {
            VtsLog.w("[%s] VTSS function request %s FAILED ReturnCode: %s (%s)", objArr);
            VtsLog.w("[%s] VTSS function request %s ErrorString: %s", this.f.f(), vtsSoapFunctionPayload.getFunctionName(), vtsSoapRequestFunctionResponseA.getErrorString());
            VtsLog.w("[%s] VTSS function request %s DataOutXml: %s", this.f.f(), vtsSoapFunctionPayload.getFunctionName(), vtsSoapRequestFunctionResponseA.getDataOutXml());
        } else {
            VtsLog.i("[%s] VTSS function request %s SUCCESSFUL ReturnCode: %s (%s)", objArr);
            VtsLog.i("[%s] VTSS function request %s DataOutXml: %s", this.f.f(), vtsSoapFunctionPayload.getFunctionName(), vtsSoapRequestFunctionResponseA.getDataOutXml());
        }
        if (!z2 || !z) {
            return vtsSoapRequestFunctionResponseA;
        }
        throw new VtsException(vtsError, "VTSS Function Call FAILED (" + vtsSoapFunctionPayload.getFunctionName() + "). VTSS error code : " + vtsSoapRequestFunctionResponseA.getReturnCode(), new Object[0]);
    }

    public SbeCustomer getCustomer(VtsFilter... vtsFilterArr) throws VtsException {
        setLastErrorCode(Integer.valueOf(VtsSoapReturnCode.NO_ERROR.value()));
        this.e.a("VtsConnection#getCustomer", StringUtils.stringifyParams("Filters", vtsFilterArr));
        VtsSoapRequestFunctionResponse vtsSoapRequestFunctionResponseA = a(new GetCustomerInput(vtsFilterArr), (byte[]) null);
        setLastErrorCode(vtsSoapRequestFunctionResponseA.getReturnCode());
        GetCustomerOutput getCustomerOutput = (GetCustomerOutput) vtsSoapRequestFunctionResponseA.getXmlAs(GetCustomerOutput.class);
        return getCustomerOutput.getCustomers().size() > 0 ? SbeCustomer.fromDto(getCustomerOutput.getCustomers().get(0)) : new SbeCustomer();
    }

    public boolean setCustomer(long j, SbeCustomer sbeCustomer) throws VtsException {
        setLastErrorCode(Integer.valueOf(VtsSoapReturnCode.NO_ERROR.value()));
        this.e.a("VtsConnection#setCustomer");
        VtsSoapRequestFunctionResponse vtsSoapRequestFunctionResponseA = a(new PutCustomerInput(j, sbeCustomer), (byte[]) null);
        setLastErrorCode(vtsSoapRequestFunctionResponseA.getReturnCode());
        return ((GetCustomerOutput) vtsSoapRequestFunctionResponseA.getXmlAs(GetCustomerOutput.class)).getCustomers().size() > 0;
    }
}
