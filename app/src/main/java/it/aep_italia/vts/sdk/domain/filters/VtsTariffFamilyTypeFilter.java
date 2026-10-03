package it.aep_italia.vts.sdk.domain.filters;

/* JADX INFO: loaded from: classes6.dex */
public class VtsTariffFamilyTypeFilter implements VtsFilter {
    private int a;

    public VtsTariffFamilyTypeFilter(int i) {
        this.a = i;
    }

    @Override // it.aep_italia.vts.sdk.domain.filters.VtsFilter
    public int getFilterID() {
        return 3;
    }

    @Override // it.aep_italia.vts.sdk.domain.filters.VtsFilter
    public String getFilterValue() {
        return "" + this.a;
    }

    public String toString() {
        return "VtsFilter{filterID=" + getFilterID() + ", rideCode=" + getFilterValue() + "}";
    }
}
