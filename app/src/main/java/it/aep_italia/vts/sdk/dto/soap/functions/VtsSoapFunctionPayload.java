package it.aep_italia.vts.sdk.dto.soap.functions;

/* JADX INFO: loaded from: classes6.dex */
public interface VtsSoapFunctionPayload {
    String getFunctionName();

    default String getSerializedForm() {
        return null;
    }

    String getStringifiedParameters();
}
