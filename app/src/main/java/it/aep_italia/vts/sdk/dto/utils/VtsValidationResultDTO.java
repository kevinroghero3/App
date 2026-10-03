package it.aep_italia.vts.sdk.dto.utils;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class VtsValidationResultDTO {
    private int a;
    private List<String> b;

    public VtsValidationResultDTO(int i, List<String> list) {
        this.a = i;
        this.b = list;
    }

    public List<String> getMessages() {
        List<String> list = this.b;
        return list == null ? new ArrayList() : list;
    }

    public int getResult() {
        return this.a;
    }
}
