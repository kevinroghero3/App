package it.aep_italia.vts.sdk.domain.filters;

/* JADX INFO: loaded from: classes6.dex */
public class VtsAvmTypeFilter implements VtsFilter {
    private AvmType a;

    public enum AvmType {
        SWARCO_MIZARD(1),
        AESYS(2),
        DIVITECH(3),
        SELEX_FINMECCANICA_LEONARDO(4),
        AEP(5);

        private int value;

        AvmType(int i) {
            this.value = i;
        }
    }

    public VtsAvmTypeFilter(AvmType avmType) {
        this.a = avmType;
    }

    @Override // it.aep_italia.vts.sdk.domain.filters.VtsFilter
    public int getFilterID() {
        return 4;
    }

    @Override // it.aep_italia.vts.sdk.domain.filters.VtsFilter
    public String getFilterValue() {
        return "" + this.a.value;
    }

    public String toString() {
        return "VtsFilter{filterID=" + getFilterID() + ", rideCode=" + getFilterValue() + "}";
    }
}
