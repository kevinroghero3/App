package it.aep_italia.vts.sdk.domain.filters;

import it.aep_italia.vts.sdk.errors.VtsError;
import it.aep_italia.vts.sdk.utils.ValidationUtils;
import java.util.Locale;

/* JADX INFO: loaded from: classes6.dex */
public class VtsGpsLocationFilter implements VtsFilter {
    private double a;
    private double b;

    public VtsGpsLocationFilter(double d, double d2) {
        boolean z = d >= 0.0d && d <= 90.0d;
        VtsError vtsError = VtsError.INVALID_PARAMETER;
        ValidationUtils.assertTrue(z, vtsError, "Invalid latitude parameter", new Object[0]);
        ValidationUtils.assertTrue(d2 >= -180.0d && d <= 180.0d, vtsError, "Invalid longitude parameter", new Object[0]);
        this.a = d;
        this.b = d2;
    }

    @Override // it.aep_italia.vts.sdk.domain.filters.VtsFilter
    public int getFilterID() {
        return 30;
    }

    @Override // it.aep_italia.vts.sdk.domain.filters.VtsFilter
    public String getFilterValue() {
        return String.format(Locale.ITALY, "%.10f;%.10f", Double.valueOf(this.a), Double.valueOf(this.b));
    }

    public String toString() {
        return "VtsFilter{filterID=" + getFilterID() + ", rideCode=" + getFilterValue() + "}";
    }
}
