package it.aep_italia.vts.sdk.domain.filters;

/* JADX INFO: loaded from: classes6.dex */
public class VtsBaseFilter implements VtsFilter {
    private int a;
    private String b;

    public VtsBaseFilter(int i, String str) {
        this.a = i;
        this.b = str;
    }

    @Override // it.aep_italia.vts.sdk.domain.filters.VtsFilter
    public int getFilterID() {
        return this.a;
    }

    @Override // it.aep_italia.vts.sdk.domain.filters.VtsFilter
    public String getFilterValue() {
        return this.b;
    }

    public String toString() {
        return "VtsFilter{filterID=" + getFilterID() + ", filterVALUE=" + getFilterValue() + "}";
    }
}
