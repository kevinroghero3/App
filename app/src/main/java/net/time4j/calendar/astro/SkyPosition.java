package net.time4j.calendar.astro;

import ch.qos.logback.core.CoreConstants;
import com.google.firebase.sessions.settings.RemoteSettings;

/* JADX INFO: loaded from: classes6.dex */
final class SkyPosition implements EquatorialCoordinates {
    private final double dec;
    private final double ra;

    SkyPosition(double d, double d2) {
        if (Double.isNaN(d) || Double.isInfinite(d) || Double.isNaN(d2) || Double.isInfinite(d2)) {
            throw new IllegalArgumentException("Not finite: " + d + RemoteSettings.FORWARD_SLASH_STRING + d2);
        }
        this.ra = d;
        this.dec = d2;
    }

    @Override // net.time4j.calendar.astro.EquatorialCoordinates
    public double getRightAscension() {
        return this.ra;
    }

    @Override // net.time4j.calendar.astro.EquatorialCoordinates
    public double getDeclination() {
        return this.dec;
    }

    public boolean equals(Object obj) {
        if (obj instanceof SkyPosition) {
            SkyPosition skyPosition = (SkyPosition) obj;
            if (this.ra == skyPosition.ra && this.dec == skyPosition.dec) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return AstroUtils.hashCode(this.ra) + (AstroUtils.hashCode(this.dec) * 37);
    }

    public String toString() {
        return "RA/Dec=[" + this.ra + CoreConstants.COMMA_CHAR + this.dec + ']';
    }
}
